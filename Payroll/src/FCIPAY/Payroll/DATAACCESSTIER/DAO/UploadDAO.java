    /*
     * Module       :   UploadDAO.java
     * Author       :   V.Jegan
     * Date Written :   1st Oct 2003
     * Description  :   The DataAccess Object and here we will form the queries
     *                  and pass it to the connection class.
     * Revision Log :   (mm/dd/yy initials description)
     * -----------------------------------------------------------------
     * mm/dd/yy     xxxx    <comments on changes>
    */

package FCIPAY.Payroll.DATAACCESSTIER.DAO;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.Payroll.UTILITY.SelectCode;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UploadVO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.ErrorMessageVO;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.struts.upload.FormFile;
import FCIPAY.Payroll.DATAACCESSTIER.SQLQueries.UploadSQLQueries;
import java.net.InetAddress;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.*;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.util.Iterator;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.DSConnect;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class UploadDAO
{
    
    /**
    * This is the getAccCodeDtls() method called from the 
    *       buisness delegate(UploadBD.java)
    * This methos will check first whether the location id the user entered
    *   is a valid location id and if yes only it will retrive the Account Code from the database.
    * @returns upLoadVO which has the account code
    * @Checks the valid loc_id from the com_loc_mst
    * @retriving all the account id records from the "fin_acct_mst" table
    */
    public boolean getAccCodeDtls(UploadVO oUploadVO) throws IBAException,IBAFatalException,IBABusinessException,SQLException
    {
        boolean retType=false;
        ResultSet res_check=null;
        ResultSet res=null;
        ArrayList accList=new ArrayList();
        DSConnect dsc=new DSConnect();
        Connection conn=null;
        PreparedStatement pstmt=null;
        try
        {
            conn=dsc.getDBConnection();
            pstmt=conn.prepareStatement(FCIPAY.Payroll.DATAACCESSTIER.SQLQueries.UploadSQLQueries.sql_chkValidAccLoc);
            pstmt.setLong(1,oUploadVO.getUserLocId());
            res_check=pstmt.executeQuery();
            
            while(res_check.next())
                retType=true;
            res_check.close();
            pstmt.close();
            long tempAcct_Id=0;
            String tempAcct_Desc="";
            if(retType) 
            {
                pstmt=conn.prepareStatement(FCIPAY.Payroll.DATAACCESSTIER.SQLQueries.UploadSQLQueries.sql_getAccCode);
                res=pstmt.executeQuery();
                while(res.next()) 
                {
                    tempAcct_Id=res.getLong("acct_id");
                    tempAcct_Desc=res.getString("shrt_code");
                    accList.add(new SelectCode(tempAcct_Id,tempAcct_Desc));
                }
                res.close();
                pstmt.close();
                if(accList.size()>0)
                    oUploadVO.setListAccCode(accList);
            }
            conn.close();
        }
        catch(SQLException e)
        {
            conn.close();
            e.printStackTrace();
            throw new IBABusinessException("Finance.File.NotFound");
        }
        finally
        {
            conn.close();    
            return retType;
        }

    }

    /**
    * This is the setValues() method for constructing the Query
    *   to access to the database.
    * @param the VO (uploadVO.java) from the buisness delegate.
    * @returns true when exectued correctly
    * @returns false when not executed.
    * @deleting from the table FIN_BNK_TMP_TXN if the loc_code and acc_code exists
    * @checking the PMType and FINType from the com_gbl_mst with the txt file. 
    *       if exists insert into the FIN_BNK_TMP_TXN table 
    *       else exit();
    */

    public ErrorMessageVO setValues(UploadVO oUploadVO,FormFile sFile) throws IBAException,IBAFatalException,IBABusinessException,SQLException
    {
          boolean retval = false; 
          ErrorMessageVO oErrorMessageVO =  new ErrorMessageVO();
          if (oUploadVO.getOptReportType().equals("1"))
             oErrorMessageVO =  updateDirectTrans(oUploadVO,sFile);


          if (oUploadVO.getOptReportType().equals("2"))
             oErrorMessageVO =  updateNpcSoc(oUploadVO,sFile);
             

          if (oUploadVO.getOptReportType().equals("3"))
             oErrorMessageVO =  updateEmpField(oUploadVO,sFile);

          return oErrorMessageVO;
    }    

    public ErrorMessageVO updateDirectTrans(UploadVO oUploadVO,FormFile sFile) throws IBAException,IBAFatalException,IBABusinessException,SQLException
    {
        ArrayList QueryLst=new ArrayList();
        String fpath="";
        String strDelete="";
        String strPMPMTRCTTYPE="";
        String strFINSTRTYPE="";
        ResultSet res=null;
        boolean retType=false;
        boolean chkFlag=true;
        int noOfLines=0;
        ErrorMessageVO oErrorMessageVO = new ErrorMessageVO();        
        
//        DSConnect dsc=new DSConnect();
//        Connection conn=null;
         DBUtilitiesBean oBean = new DBUtilitiesBean();
        PreparedStatement pstmt=null;
        ArrayList oOutArray; 
        ArrayList oParameters=null;
        int iTotalErrCount = 0;
        int iTotalAccCount = 0;
        int iTotalRejCount = 0;        



//==============Code for deleting any previous record for that particular location and for that particular account code
        try
        {
            
        //    pstmt=conn.prepareStatement(UploadSQLQueries.sql_delPrevValues);
//            ArrayList olist =  oBean.executeQuery("Delete from PAY_PAYROLL_TXN_UPLOAD");
            
             BufferedReader br = new BufferedReader(new InputStreamReader(sFile.getInputStream()));            
            //fpath=oUploadVO.getFile();
         //   FileReader fr=new FileReader((File)(sFile));
           // BufferedReader br=new BufferedReader(fr);
            String s;//for reading line by line from the input file
                      
            boolean bInsert=false;
            long iErrCnt;
            int iErrorCount; 
            
            noOfLines=0;
            int i=0;

            while((s=br.readLine())!=null)
            {
                bInsert = true;
                oParameters = new ArrayList();                
                
                oParameters = new ArrayList();            
                noOfLines=noOfLines+1;
                i=0;
                if(s.length()!=0)
                {
                    StringTokenizer st=new StringTokenizer(s,",");
                    if(st.countTokens() <=0) {
                        continue;
                    }
                    while(st.hasMoreTokens())
                    {
                        String val=st.nextToken();
                        oParameters.add(new DBObject(++i,DBObject.IN,ParameterTypes.VARCHAR,new String(val)));                        
                    }
                    
                }
               try
               {
                oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR,Integer.toString(noOfLines)));                                                      
                oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR, new String( String.valueOf(oUploadVO.getUserEmpNo()))));                                       
                oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR,new String( String.valueOf(oUploadVO.getUserLocId()))));                                   
                oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.VARCHAR));                                  
                oParameters.add(new DBObject(11,DBObject.OUT,ParameterTypes.INTEGER));  

                System.out.println(oParameters.size());
                System.out.println(iTotalAccCount);
                if (oParameters.size() != 11)
                  throw new IBABusinessException("Finance.File.NotFound");

                oOutArray = oBean.callProc(oParameters, "PAYROLL_PKG_EXT.PAY_PAYROLL_TXN_UPLOAD(?,?,?,?,?,?,?,?,?,?,?)");            

      	        DBObject sErrMsg = (DBObject)oOutArray.get(0);                
                String sErrMessage = (((String)sErrMsg.getObject()).toString());
                oErrorMessageVO.setErrorCode(sErrMessage);
                
                DBObject oErrorCount = (DBObject)oOutArray.get(1);
                iErrorCount = (((Integer)oErrorCount.getObject()).intValue());
                iTotalAccCount = iTotalAccCount + 1;                 
                
               }
               catch(EnrgiseSystemException e)
               {
//                 System.out.println("The Error Line is " + noOfLines );
                  System.out.println(e.getMessage());      
                  iTotalErrCount = 1 +iTotalErrCount;    
                  iTotalRejCount = iTotalRejCount + 1;                  
                 continue; 
               }
           }

            oParameters.clear();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,Integer.toString(iTotalAccCount)));                                                      
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,Integer.toString(iTotalRejCount)));                                                                      
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));              
            oOutArray = oBean.callProc(oParameters, "PAYROLL_PKG_EXT.Upload_Summary(?,?,?)");            
                
       if (iTotalErrCount > 0) 
           {
           oErrorMessageVO.setBErrorFlag(false);           
//           return false;           
            return oErrorMessageVO;
           }
           else
           {
           oErrorMessageVO.setBErrorFlag(true);
//           return true;            
            return oErrorMessageVO;
           }
        }
           
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBABusinessException("Finance.File.NotFound");
        }
        
//        finally{
//            oUploadVO.setErrLineNo(noOfLines);
//            pstmt.close();
//               }
    }


    







    public ErrorMessageVO updateNpcSoc(UploadVO oUploadVO,FormFile sFile) throws IBAException,IBAFatalException,IBABusinessException,SQLException
    {
        ArrayList QueryLst=new ArrayList();
        String fpath="";
        String strDelete="";
        String strPMPMTRCTTYPE="";
        String strFINSTRTYPE="";
        ResultSet res=null;
        boolean retType=false;
        boolean chkFlag=true;
        int noOfLines=0;
        
         DBUtilitiesBean oBean = new DBUtilitiesBean();
        PreparedStatement pstmt=null;
        ArrayList oOutArray; 
        ArrayList oParameters=null;
        int iTotalErrCount = 0;
        int iTotalAccCount = 0;
        int iTotalRejCount = 0;      
        ErrorMessageVO oErrorMessageVO = new ErrorMessageVO();        



//==============Code for deleting any previous record for that particular location and for that particular account code
        try
        {
            
             BufferedReader br = new BufferedReader(new InputStreamReader(sFile.getInputStream()));            
            String s;//for reading line by line from the input file
                      
            boolean bInsert=false;
            long iErrCnt;
            int iErrorCount; 
            
            noOfLines=0;
            int i=0;

            while((s=br.readLine())!=null)
            {
                bInsert = true;
                oParameters = new ArrayList();                
                
                oParameters = new ArrayList();            
                noOfLines=noOfLines+1;
                i=0;
                if(s.length()!=0)
                {
                    StringTokenizer st=new StringTokenizer(s,",");
                    if(st.countTokens() <=0) {
                        continue;
                    }
                    while(st.hasMoreTokens())
                    {
                        String val=st.nextToken();
                        oParameters.add(new DBObject(++i,DBObject.IN,ParameterTypes.VARCHAR,new String(val)));                        
                    }
                    
                }
               try
               {
                oParameters.add(new DBObject(8,DBObject.IN,ParameterTypes.VARCHAR,Integer.toString(noOfLines)));                                                      
//                oParameters.add(new DBObject(9,DBObject.IN,ParameterTypes.VARCHAR, new String( String.valueOf(oUploadVO.getUserEmpNo()))));                                       
//                oParameters.add(new DBObject(10,DBObject.IN,ParameterTypes.VARCHAR,new String( String.valueOf(oUploadVO.getUserLocId()))));                                   
                oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));                  
                oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));  

                if (oParameters.size() != 10)
                  throw new IBABusinessException("Finance.File.NotFound");
                
                oOutArray = oBean.callProc(oParameters, "PAYROLL_PKG_EXT.PAY_PAYROLL_NPC_UPLOAD(?,?,?,?,?,?,?,?,?,?)");            

      	        DBObject sErrMsg = (DBObject)oOutArray.get(0);                
                String sErrMessage = (((String)sErrMsg.getObject()).toString());
                oErrorMessageVO.setErrorCode(sErrMessage);
                
                DBObject oErrorCount = (DBObject)oOutArray.get(1);
                iErrorCount = (((Integer)oErrorCount.getObject()).intValue());
                iTotalAccCount = iTotalAccCount + 1;                 
                
               }
               catch(EnrgiseSystemException e)
               {
                  System.out.println(e.getMessage());      
                  iTotalErrCount = 1 +iTotalErrCount;    
                  iTotalRejCount = iTotalRejCount + 1;                  
                 continue; 
               }
           }

            oParameters.clear();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,Integer.toString(iTotalAccCount)));                                                      
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,Integer.toString(iTotalRejCount)));                                                                      
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.INTEGER));              
            oOutArray = oBean.callProc(oParameters, "PAYROLL_PKG_EXT.Upload_NPC_Summary(?,?,?)");            
                
     if (iTotalErrCount > 0) 
           {
           oErrorMessageVO.setBErrorFlag(false);           
//           return false;           
            return oErrorMessageVO;
           }
           else
           {
           oErrorMessageVO.setBErrorFlag(true);
//           return true;            
            return oErrorMessageVO;
           }
        }
           
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBABusinessException("Finance.File.NotFound");
        }        
    }






    public ErrorMessageVO updateEmpField(UploadVO oUploadVO,FormFile sFile) throws IBAException,IBAFatalException,IBABusinessException,SQLException
    {
        ArrayList QueryLst=new ArrayList();
        String fpath="";
        String strDelete="";
        String strPMPMTRCTTYPE="";
        String strFINSTRTYPE="";
        ResultSet res=null;
        boolean retType=false;
        boolean chkFlag=true;
        int noOfLines=0;
        
         DBUtilitiesBean oBean = new DBUtilitiesBean();
        PreparedStatement pstmt=null;
        ArrayList oOutArray; 
        ArrayList oParameters=null;
        int iTotalErrCount = 0;
        int iTotalAccCount = 0;
        int iTotalRejCount = 0;     
        ErrorMessageVO oErrorMessageVO = new ErrorMessageVO();



//==============Code for deleting any previous record for that particular location and for that particular account code
        try
        {
            
             BufferedReader br = new BufferedReader(new InputStreamReader(sFile.getInputStream()));            
            String s;//for reading line by line from the input file
                      
            boolean bInsert=false;
            long iErrCnt;
            int iErrorCount; 
            
            noOfLines=0;
            int i=0;

            while((s=br.readLine())!=null)
            {
                bInsert = true;
                oParameters = new ArrayList();                
                
                oParameters = new ArrayList();            
                noOfLines=noOfLines+1;
                i=0;
                if(s.length()!=0)
                {
                    StringTokenizer st=new StringTokenizer(s,",");
                    if(st.countTokens() <=0) {
                        continue;
                    }
                    while(st.hasMoreTokens())
                    {
                        String val=st.nextToken();
                        oParameters.add(new DBObject(++i,DBObject.IN,ParameterTypes.VARCHAR,new String(val)));                        
                    }
                    
                }
               try
               {
                oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR,oUploadVO.getTxtEmpField() ));                                                                     
                oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR,Integer.toString(noOfLines)));                                                      
                oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, new String( String.valueOf(oUploadVO.getUserEmpNo()))));                                       
                oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR,new String( String.valueOf(oUploadVO.getUserLocId()))));                                                   
                oParameters.add(new DBObject(7,DBObject.OUT,ParameterTypes.VARCHAR));                  
                oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.INTEGER));  

                if (oParameters.size() != 8)
                  throw new IBABusinessException("Finance.File.NotFound");
                
                oOutArray = oBean.callProc(oParameters, "PAYROLL_PKG_EXT.PAY_EMP_MAST_FIELD_UPDATE(?,?,?,?,?,?,?,?)");            

                DBObject sErrMsg = (DBObject)oOutArray.get(0);                
                String sErrMessage = (((String)sErrMsg.getObject()).toString());
                oErrorMessageVO.setErrorCode(sErrMessage);
                
                DBObject oErrorCount = (DBObject)oOutArray.get(1);
                iErrorCount = (((Integer)oErrorCount.getObject()).intValue());
                iTotalAccCount = iTotalAccCount + 1;                 
                
               }
               catch(EnrgiseSystemException e)
               {
                  System.out.println(e.getMessage());      
                  iTotalErrCount = 1 +iTotalErrCount;    
                  iTotalRejCount = iTotalRejCount + 1;                  
                 continue; 
               }
           }

            oParameters.clear();
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,Integer.toString(iTotalAccCount)));                                                      
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,Integer.toString(iTotalRejCount)));                                                                      
            oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oUploadVO.getTxtEmpField()));                                                                                  
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));              
            oOutArray = oBean.callProc(oParameters, "PAYROLL_PKG_EXT.Upload_EMP_FIELD_Summary(?,?,?,?)");            


                            
           if (iTotalErrCount > 0) 
           {
           oErrorMessageVO.setBErrorFlag(false);           
//           return false;           
            return oErrorMessageVO;
           }
           else
           {
           oErrorMessageVO.setBErrorFlag(true);
//           return true;            
            return oErrorMessageVO;
           }
        }
           
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBABusinessException("Finance.File.NotFound");
        }        
    }
    

    /**
     * This function is to replace the local file name with the host name
     * If the path is in Local drive then replace the local drive with the host name of the machine
     * @arg:  String tempPath - the path selected by the user
     * @returns: String which has the correced path along with hostname
     */

    public String replacePath(String tempPath)
    {
        String correctPath="";
        //System.out.println("In Function " + tempPath);
        StringTokenizer temp=new StringTokenizer(tempPath,":");
        int cnt=temp.countTokens();
        String firstString=temp.nextToken();
        if((cnt==2)&&(firstString.length()==1))
        {
            String hstName="";
            try
            {
                InetAddress lclHost;
                lclHost=InetAddress.getLocalHost();
                hstName=lclHost.getHostName();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            String testStr=temp.nextToken();
            correctPath="\\\\"+hstName+testStr;
        }
        else
            correctPath=tempPath;
        //System.out.println("The Corrected Path is " + correctPath);
        return correctPath;
    }

    public String uploadFinal(UploadVO oUploadVO) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();    
        ArrayList oParameters=null;  
        ArrayList oOutArray;
        oParameters = new ArrayList();
        if (oUploadVO.getOptReportType().equals("2"))    
        {
            oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, new String( String.valueOf(oUploadVO.getUserEmpNo()))));                                       
            oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR,new String( String.valueOf(oUploadVO.getUserLocId()))));                                   
            oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.VARCHAR)); 
            oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));              
            oOutArray = oBean.callProc(oParameters, "PAYROLL_PKG_EXT.PAY_PAYROLL_TXN_NPC_UPLOAD(?,?,?,?)");                              
            DBObject oOutObject = (DBObject)oOutArray.get(0);
            String error_code = (String)oOutObject.getObject();  
            return error_code; 
        }

        if (oUploadVO.getOptReportType().equals("1"))    
        {
            oParameters.clear();
            oParameters.add(new DBObject(1,DBObject.OUT,ParameterTypes.VARCHAR));              
            oParameters.add(new DBObject(2,DBObject.OUT,ParameterTypes.INTEGER));                          
            oOutArray = oBean.callProc(oParameters, "PAYROLL_PKG_EXT.PAY_PAYROLL_TXN_ACT_UPLOAD(?,?)");                              
            DBObject oOutObject = (DBObject)oOutArray.get(0);
            String error_code = (String)oOutObject.getObject();  
            return error_code; 
        }
        

        return "12";

//        return true;
    }    
}
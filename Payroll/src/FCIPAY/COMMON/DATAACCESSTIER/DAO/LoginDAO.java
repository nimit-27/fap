package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.sql.*;
import FCIPAY.COMMON.DATAACCESSTIER.VO.LoginVO;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.LoginSQLQueries;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import java.util.ArrayList;
import java.util.Iterator;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.COMMON.UTILITY.comboBean;
import FCIPAY.COMMON.UTILITY.BaseDAO;


public class LoginDAO extends BaseDAO
{
    public LoginDAO()
    {
        super("Common");
    }

   /**
   * This method brings the location codes
   * @param String sEmpNo
   * @param String sEmpPwd
   * @exception IBAFatalException,IBABusinessException, IBAException
   * @return ArrayList
   */
//     public ArrayList getLocationCodes(String sEmpNo,String sEmpPwd) throws IBAFatalException,IBABusinessException, IBAException
    public ArrayList getLocationCodes(String sEmpNo,String sEmpPwd) throws EnrgiseSystemException, EnrgiseApplicationException 
    {     
      ArrayList oList = null;
      Iterator oIt = null;
      ArrayList tempList = new ArrayList();   
      QueryRow oRow = null; 
      int cnt=0;

      //System.out.println("Inside LogIn DAO::::");
      ArrayList oOutArray; 
      ArrayList oParameters = new ArrayList(); //Input Parameters      
      DBUtilitiesBean oBean = new DBUtilitiesBean();
      
      //oParameters = new ArrayList();
      oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sEmpNo));
      //oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sEmpPwd));
      oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.LoginSQLQueries.Chk_Employee_LOCKED); 
      oIt = oOutArray.iterator();
      if(oIt.hasNext())
      {
              oRow = (QueryRow)oIt.next();
              cnt =  Integer.parseInt(oRow.get("PSSWD_CHANGED").getString());
              int allowed_cnt = 0;
              oParameters = new ArrayList();
              oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.LoginSQLQueries.MAX_LOGIN_ATTEMPT);
              oIt = oOutArray.iterator();
              if(oIt.hasNext())
              {
                  oRow = (QueryRow)oIt.next();
                  allowed_cnt = Integer.parseInt(oRow.get("CNT").getString());
                  if(cnt >= allowed_cnt)
                  {
                    throw new EnrgiseApplicationException("Common.Login.UserLocked",FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR);
                  }
              }
      }
      
      oParameters = new ArrayList();
      oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sEmpNo));
      oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sEmpPwd));  
      oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.LoginSQLQueries.GET_LOC_CODE);
      //System.out.println(""+FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.LoginSQLQueries.GET_LOC_CODE);


//        oList = (ArrayList)((DBObject)oOutArray.get(0)).getObject();
        if(oOutArray.size() == 0)
        {        
           updateLoginAttempts(sEmpNo,1);
           throw new EnrgiseApplicationException("Common.LogIn.InvalidUser",FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR);
        } 
        else
          updateLoginAttempts(sEmpNo,0);
        oIt = oOutArray.iterator();
        while(oIt.hasNext())
        {
          oRow = (QueryRow)oIt.next();
//        tempList.add(new comboBean(rs.getString("LOC_ID"),rs.getString("LOC_DESC")));          
          tempList.add(new comboBean(oRow.get("LOC_ID").getString(),oRow.get("LOC_DESC").getString()));                    
/*         oCity.setTxtCityType((oRow.get("CITY_TYPE").getString()));
          oCity.setStatus("Q");
          oCity.setTxtDesc(oRow.get("CITY_TYPE_DESC").getString());
          oCity.setTxtCities((oRow.get("CITIES").getString()));
          oCityDetail.add(oCity); */
        }
        oOutArray = null;
        oParameters = null;
        return tempList;               
    }    

   /**
   * This method brings the emp details for user info bean
   * @param String sEmpNo
   * @exception IBAFatalException,IBABusinessException, IBAException
   * @return ArrayList
   */
//    public ArrayList getEmpDetails(String sEmpNo) throws IBAFatalException,IBABusinessException, IBAException
      public ArrayList getEmpDetails(String sEmpNo) throws EnrgiseSystemException, EnrgiseApplicationException 
    {     
/*        ResultSet rs = null;
        ArrayList lList = new ArrayList();
        String sFirstName = "";
        String sMiddleName  = "";
        String sLastName = "";
        int cnt=0;
        try
        {
            doPrepareStatement(LoginSQLQueries.GET_EMP_DET);
            setVARCHAR(sEmpNo);
            rs = doExecuteQuery(false);

            if (rs.next())
            {
                // Here we are quering 32 fields
                lList.add(rs.getString("EMP_NO"));
                sFirstName = rs.getString("EMP_FST_NAME").trim(); 
                sMiddleName = rs.getString("EMP_MDL_NAME").trim();
                if(sMiddleName.equals("??"))
                sMiddleName = "";
                sLastName = rs.getString("EMP_LST_NAME").trim();
                if(sLastName.equals("??"))
                sLastName = "";
                lList.add(sFirstName + " " + sMiddleName + " " +sLastName );                            
                lList.add(rs.getString("EMP_OFFC_PHONE_AUTO"));
                lList.add(rs.getString("EMP_EMAIL"));
                lList.add(rs.getString("DOB"));
                lList.add(rs.getString("EMP_SEX"));
                lList.add(rs.getString("DOJ_DAE"));
                lList.add(rs.getString("DOJ_GOV"));
                lList.add(rs.getString("DOJ_NPC"));
                lList.add(rs.getString("DOJ_SITE"));
                lList.add(rs.getString("EMP_TYPE"));                
                lList.add(rs.getString("CATEG_DESC"));                
                lList.add(rs.getString("CADRE_DESC"));                
                lList.add(rs.getString("EMP_UNIT_ID"));                  
                lList.add(rs.getString("DRCRT_NAME"));                
                lList.add(rs.getString("EMP_GRP"));                
                lList.add(rs.getString("GRP_NAME"));                
                lList.add(rs.getString("SECT_NAME"));                
                lList.add(rs.getString("EMP_REP_ID"));                
                lList.add(rs.getString("DESG_DESC"));                                
                lList.add(rs.getString("WORKMEN_FLAG"));                                
                lList.add(rs.getString("EMP_5TH_PAY_BASIC"));                                
                lList.add(rs.getString("EMP_LOC"));                                
                lList.add(rs.getString("EMP_SUB_LOC"));                                
                lList.add(rs.getString("EMP_DOC"));                                
                lList.add(rs.getString("INCR_DT"));                                
                lList.add(rs.getString("LST_PROM"));                                
                lList.add(rs.getString("CR_PRD_END_DT"));                                
                lList.add(rs.getString("EMP_OPT_EXERCISED"));                                
                lList.add(rs.getString("NORM_RET_DT")); 
                lList.add(rs.getString("LEAVE_TYPE"));       
                lList.add(rs.getString("CODE_DESC"));
                lList.add(rs.getString("LOC_DESC"));
                lList.add(rs.getString("EMP_SPLZN"));
            }
            else
            {
                throw new IBAFatalException("Common.DB.Administrator");
            }
        }
        catch (IBAFatalException ibab)
        {
            throw ibab;
        }
        catch (SQLException sqlEx)
        {
            //sqlEx.printStackTrace();
            throw new IBAFatalException("Common.DB.Administrator");
        }
        catch (Exception e)
        {
            //e.printStackTrace();
            throw new IBAFatalException("Common.DB.Administrator");
        }

        finally
        {
            closePreparedStatement();
            closeConnection();
        }
        return lList;  */

        ArrayList oList = null;
        Iterator oIt = null;
        ArrayList lList = new ArrayList();   
        QueryRow oRow = null;      
        String sFirstName = "";
        String sMiddleName  = "";
        String sLastName = "";        

        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        oParameters = new ArrayList();
        oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sEmpNo));
        oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.LoginSQLQueries.GET_EMP_DET);      

        if(oOutArray.size() == 0)
        {        
           throw new EnrgiseApplicationException("wenrgise.common.norecordfound",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
        }        
        oIt = oOutArray.iterator();
        while(oIt.hasNext())
        {
                oRow = (QueryRow)oIt.next();
                lList.add(oRow.get("EMP_NO").getString());
                lList.add(oRow.get("EMP_NAME").getString());                    
                lList.add(oRow.get("LOC_ID").getString());      
                lList.add(oRow.get("LOC_DESC").getString());      
                lList.add(oRow.get("LOC_TYPE_GBL").getString());
        }
        return lList;               
        
    } 



    /**
   * This method brings the emp details for user info bean
   * @param String sEmpNo
   * @exception IBAFatalException,IBABusinessException, IBAException
   * @return ArrayList
   */
//    public ArrayList getEmpDetails(String sEmpNo,String sEmpPwd) throws IBAFatalException,IBABusinessException, IBAException
      public ArrayList getEmpDetails(String sEmpNo,String sEmpPwd,String locCode) throws EnrgiseSystemException, EnrgiseApplicationException 
      {     
        ArrayList lList = new ArrayList();
        String sFirstName = "";
        String sMiddleName  = "";
        String sLastName = "";
        int cnt=0;
        int iSectHdFlg=0;

        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();        
        
        try
        {
            oParameters = new ArrayList();
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sEmpNo));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sEmpPwd));
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.LoginSQLQueries.Chk_Employee); 
            oIt = oOutArray.iterator();
            if(oIt.hasNext())
            {
                oRow = (QueryRow)oIt.next();
                oParameters = new ArrayList();
                oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sEmpNo));
                oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,locCode));
                oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.LoginSQLQueries.GET_EMP_DET);      
                if(oOutArray.size() == 0)
                {        
                   throw new EnrgiseApplicationException("wenrgise.common.norecordfound",FCIPAY.Payroll.common.utility.EnrgiseConstants.MESSAGE);
                }        
                oIt = oOutArray.iterator();
                while(oIt.hasNext())
                {
                        oRow = (QueryRow)oIt.next();
                        lList.add(oRow.get("EMP_NO").getString()); 
                        lList.add(oRow.get("EMP_NAME").getString());                    
                        lList.add(oRow.get("LOC_ID").getString());      
                        lList.add(oRow.get("LOC_DESC").getString());     
                        lList.add(oRow.get("LOC_TYPE_GBL").getString());
                        lList.add(oRow.get("STS").getString());
                }
            }
        return lList;  

    } 
    catch(Exception e)
    {
          throw new EnrgiseSystemException(e);
    }
  }
  
   /**
   * This method brings the emp details for user info bean
   * @param String sEmpNo
   * @exception IBAFatalException,IBABusinessException, IBAException
   * @return ArrayList
   */
//    public ArrayList getEmpDetails(String sEmpNo) throws IBAFatalException,IBABusinessException, IBAException
      public void updateLoginAttempts(String sEmpNo,int val) throws EnrgiseSystemException, EnrgiseApplicationException 
    {     
        ArrayList oList = null;
        Iterator oIt = null; 
        QueryRow oRow = null;        

        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        oParameters = new ArrayList();
        oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,sEmpNo));
        if(val==0)
          oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.LoginSQLQueries.UPDATE_LOGIN_SUCESS); 
        else
          oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.LoginSQLQueries.UPDATE_LOGIN_UNSUCESS); 
             
        
    } 
}      

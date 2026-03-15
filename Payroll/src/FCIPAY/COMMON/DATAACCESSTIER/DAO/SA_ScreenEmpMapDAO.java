
/*
 * Program Name : SA_ScreenEmpMapDAO.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Data Access Object File which access the 
 *                  Database and updates the Screens assigned to the User
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import FCIPAY.COMMON.DATAACCESSTIER.VO.SA_ScreenEmpMapVO;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.utility.RecordMetaInfo;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import java.util.Iterator;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;


import java.sql.*;
import java.util.ArrayList;
import FCIPAY.COMMON.UTILITY.DynamicMenuBean;
import FCIPAY.COMMON.UTILITY.comboBean;
import FCIPAY.COMMON.UTILITY.BaseDAO;

public class SA_ScreenEmpMapDAO extends BaseDAO
{
    public SA_ScreenEmpMapDAO() 
    {
        super("Common");
    }

    /**
     * This function is to get the Module List and the Employee List
     * @returns : SA_ScreenEmpMapVO which has the module list and the employee list
     * @Tables-Accessed: Retrived from sysadmin_screenaccess_mst,sysadmin_user_mst
     */
//    public SA_ScreenEmpMapVO getOnLoadDtls(long tempLocID) throws IBAFatalException,SQLException
      public SA_ScreenEmpMapVO getOnLoadDtls(long tempLocID) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
/*        SA_ScreenEmpMapVO osaVO=new SA_ScreenEmpMapVO();
        ResultSet res=null;
        String idString="";
        String code="";
        long idLong=0;
        ArrayList tempList=new ArrayList();
        try 
        {
            doPrepareStatement(ScreenAcessQueries.SQL_GETEMPNO);
            setLONGPRIMITIVE(tempLocID);
            res=doExecuteQuery(false);
            while(res.next()) 
            {
                idLong=res.getLong("emp_no");
                code=idLong + "";
                tempList.add(new comboBean(idLong,code));
            }
            osaVO.setEmpList(tempList);
            res.close();
            closePreparedStatement();  

            tempList=null;

            tempList=new ArrayList();
            doPrepareStatement(ScreenAcessQueries.SQL_GETMODULE);
            res=doExecuteQuery(false);
            while(res.next()) 
            {
                idString=res.getString("GBL_CODE");
                code=res.getString("MODULE_NAME");
                tempList.add(new comboBean(idString,code));
            }
            osaVO.setModuleList(tempList);
            res.close();
            closePreparedStatement();
            closeConnection();
        }
        catch(IBAFatalException ibafe) 
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            ibafe.printStackTrace();
            ibafe = new IBAFatalException("Common.Database.Error");
            throw ibafe;    
        }
        catch(Exception e) 
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            e.printStackTrace();
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return osaVO;  */

        SA_ScreenEmpMapVO osaVO=new SA_ScreenEmpMapVO();
        ArrayList tempList=new ArrayList();
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();         

        try
        {
            String idString="";
            String code="";
            long idLong=0;            
            oParameters = new ArrayList();

           // oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(tempLocID)));
            oOutArray = oBean.executeQuery(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_GETEMPNO); 
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();
                    idLong= Long.parseLong(oRow.get("EMP_NO").getString());
                    code=idLong + "";
                    tempList.add(new comboBean(idLong,code));                    
            }
            
            osaVO.setEmpList(tempList);       

            tempList=null;
            tempList=new ArrayList();            
            oOutArray = oBean.executeQuery(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_GETMODULE); 
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {            
                    oRow = (QueryRow)oIt.next();                    
                    idString=oRow.get("GBL_CODE").getString();
                    code=oRow.get("MODULE_NAME").getString();
                    tempList.add(new comboBean(idString,code));            
            }
            
            osaVO.setModuleList(tempList);            
        }

        catch(Exception e)
        {
              throw new EnrgiseSystemException(e);
        }                

        return osaVO;                  
    }

/**
     * This function is to get the Employee List like the employees whihc are entered in teh Text box
     * @returns : ArrayList which has theemployee list
     * @Tables-Accessed: Retrived from sysadmin_screenaccess_mst,sysadmin_user_mst
     */
//    public ArrayList getEmpLikeList(long tempLocID,long empNo) throws IBAFatalException,SQLException
      public ArrayList getEmpLikeList(long tempLocID,long empNo) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
/*        ResultSet res=null;
        String idString="";
        String code="";
        long idLong=0;
        ArrayList tempList=new ArrayList();
        try 
        {
            doPrepareStatement(ScreenAcessQueries.SQL_GETLikeEMPNO);
            setLONGPRIMITIVE(tempLocID);
            setVARCHAR(empNo+"%");
            res=doExecuteQuery(false);
            while(res.next()) 
            {
                idLong=res.getLong("emp_no");
                code=idLong + "";
                tempList.add(new comboBean(idLong,code));
            }
            res.close();
            closePreparedStatement();
            closeConnection();
        }
        catch(IBAFatalException ibafe) 
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            ibafe.printStackTrace();
            ibafe = new IBAFatalException("Common.Database.Error");
            throw ibafe;    
        }
        catch(Exception e) 
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            e.printStackTrace();
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }  */

        ArrayList tempList=new ArrayList();
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean(); 
        

        try
        {
            String idString="";
            String code="";
            long idLong=0;
            oParameters = new ArrayList();
           // oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(tempLocID)));            
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,empNo+"%"));                        
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_GETLikeEMPNO); 
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();
                    idLong=Long.parseLong(oRow.get("EMP_NO").getString());
                    code=idLong + "";
                    tempList.add(new comboBean(idLong,code));                    
            }

        }
        catch(Exception e)
        {
              throw new EnrgiseSystemException(e);
        }     
                        
        return tempList;
    }

    
    /**
     * This function is to get the Employee Details based on the selected employee
     * @returns : SA_ScreenEmpMapVO which has the employee Dtls
     * @Tables-Accessed: hrm_employee
     */
//    public SA_ScreenEmpMapVO getEmpDtls(long empNo) throws IBAFatalException,SQLException
      public ArrayList getEmpDtls(long empNo) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
/*        SA_ScreenEmpMapVO osaVO=new SA_ScreenEmpMapVO();
        ResultSet res=null;
        try 
        {
            osaVO.setHdnEmpName("");
            osaVO.setHdnDept("");
            osaVO.setHdnDesig("");
            doPrepareStatement(ScreenAcessQueries.SQL_GETEMPDTLS);
            setLONGPRIMITIVE(empNo);
            res=doExecuteQuery(false);
            while(res.next()) 
            {
                osaVO.setHdnEmpName(res.getString("emp_name"));
                osaVO.setHdnDept(res.getString("sect_name"));
                osaVO.setHdnDesig(res.getString("dsgn"));
            }
            res.close();
            closePreparedStatement();
            closeConnection();
        }
        catch(IBAFatalException ibafe) 
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            ibafe.printStackTrace();
            ibafe = new IBAFatalException("Common.Database.Error");
            throw ibafe;    
        }
        catch(Exception e) 
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            e.printStackTrace();
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }    */


        SA_ScreenEmpMapVO osaVO=new SA_ScreenEmpMapVO();
        ArrayList tempList=new ArrayList();
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean(); 

        try
        {
            String idString="";
            String code="";
            long idLong=0;
            oParameters = new ArrayList();
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(empNo)));            
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_GETEMPLOCDTLS); 
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();
                    code=oRow.get("loc_desc").getString();
                    idString=oRow.get("loc_id").getString();
                    idLong=Long.parseLong(idString);
                    tempList.add(new comboBean(idLong,code));                    
            }

        }
        catch(Exception e)
        {
              throw new EnrgiseSystemException(e);
        }     
                        

        
        return tempList;
    }


    /**
     * This function is to get the Header List for the Selected Module
     * @param : moduleName which was selected
     * @returns : ArrayList which has the header list based on the Module selected
     * @Tables-Accessed: Retrived from sysadmin_screenaccess_mst
     */
     
//    public ArrayList getHeaderDtls(String moduleName) throws IBAFatalException,SQLException
    public ArrayList getHeaderDtls(String moduleName) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
/*        ArrayList tempList=new ArrayList();
        String header="";
        ResultSet res=null;
        try 
        {
            doPrepareStatement(ScreenAcessQueries.SQL_GETHEADER);
            setVARCHAR(moduleName);
            res=doExecuteQuery(false);
            while(res.next()) 
            {
                header=res.getString("header_name");
                tempList.add(new comboBean(header,header));
            }
            res.close();
            closePreparedStatement();
            closeConnection();
        }
        catch(IBAFatalException ibafe) 
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            ibafe.printStackTrace();
            ibafe = new IBAFatalException("Common.Database.Error");
            throw ibafe;    
        }
        catch(Exception e) 
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            e.printStackTrace();
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }  */

        String header="";        
        ArrayList tempList=new ArrayList();
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean(); 
        

        try
        {
            String idString="";
            String code="";
            long idLong=0;
            oParameters = new ArrayList();
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,moduleName));            
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_GETHEADER); 
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();
                    header = oRow.get("header_name").getString();
                    tempList.add(new comboBean(header,header));
            }

        }
        catch(Exception e)
        {
              throw new EnrgiseSystemException(e);
        }     
            
        return tempList;
    }


    /**
     * This function is to get the Menu List for the Selected header
     * @param : moduleName which was selected
     * @param : headerName which was selected
     * @returns : ArrayList which has the menu list based on the Module and header selected
     * @Tables-Accessed: Retrived from sysadmin_screenaccess_mst
     */
     
//    public SA_ScreenEmpMapVO getLevelDtls(String moduleName,String headerName,long empNo,long locCode) throws IBAFatalException,SQLException
      public SA_ScreenEmpMapVO getLevelDtls(String moduleName,String headerName,long empNo,long locCode) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
/*      ArrayList tempList=new ArrayList();
        SA_ScreenEmpMapVO osaVO= new SA_ScreenEmpMapVO();
        String header="";
        ResultSet res=null;
        try 
        {
            //FOR GETTING THE NEW SCREENS FOR THAT MODULE
            doPrepareStatement(ScreenAcessQueries.SQL_GETLEVELS);
            setVARCHAR(moduleName);
            setVARCHAR(headerName);
            setLONGPRIMITIVE(empNo);
            setLONGPRIMITIVE(locCode);
            
            res=doExecuteQuery(false);
            while(res.next()) 
            {
                tempList.add(new DynamicMenuBean(res.getString("level1"),res.getString("level2"),res.getString("level3"),res.getLong("screenaccess_id"),"n"));
            }
            res.close();
            closePreparedStatement();
            osaVO.setMenuList(tempList);

            tempList=null;
            
            tempList=new ArrayList();

            //FOR GETTING THE ASSIGNED SCREENS TO THE CONCERNED EMPLOYEE
            doPrepareStatement(ScreenAcessQueries.SQL_ASSIGNEDLEVELS);
            setVARCHAR(moduleName);
            setVARCHAR(headerName);
            setLONGPRIMITIVE(empNo);
            setLONGPRIMITIVE(locCode);
            
            res=doExecuteQuery(false);
            while(res.next()) 
            {
                tempList.add(new DynamicMenuBean(res.getString("level1"),res.getString("level2"),res.getString("level3"),res.getLong("screen_emp_id"),"n"));
            }
            res.close();
            closePreparedStatement();
            osaVO.setAssignedList(tempList);
            closeConnection();
        }
        catch(IBAFatalException ibafe) 
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            ibafe.printStackTrace();
            ibafe = new IBAFatalException("Common.Database.Error");
            throw ibafe;    
        }
        catch(Exception e) 
        {
            res.close();
            closePreparedStatement();
            closeConnection();
            e.printStackTrace();
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return osaVO;  */

        ArrayList tempList=new ArrayList();
        SA_ScreenEmpMapVO osaVO= new SA_ScreenEmpMapVO();
        String header="";
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean(); 
                
        try 
        {
            //FOR GETTING THE NEW SCREENS FOR THAT MODULE
            oParameters = new ArrayList();
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,moduleName));            
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,headerName));            
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(empNo)));            
            oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(locCode)));                                    
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_GETLEVELS); 
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();            
                    tempList.add(new DynamicMenuBean(oRow.get("level1").getString(),oRow.get("level2").getString(),oRow.get("level3").getString(),Long.parseLong(oRow.get("screenaccess_id").getString()),Long.parseLong(oRow.get("screenaccess_id").getString()),"n"));
//                    tempList.add(new DynamicMenuBean(oRow.get("level1").getString(),oRow.get("level2").getString(),oRow.get("level3").getString(),Long.parseLong(oRow.get("screenaccess_id").getString()),"n"));
            }

            osaVO.setMenuList(tempList);

            tempList=null;            
            tempList=new ArrayList();

            //FOR GETTING THE ASSIGNED SCREENS TO THE CONCERNED EMPLOYEE
            oParameters = new ArrayList();            
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,moduleName));            
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,headerName));            
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(empNo)));            
            oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(locCode)));                                    
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_ASSIGNEDLEVELS);             

            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next(); 
                    
                    tempList.add(new DynamicMenuBean(oRow.get("level1").getString(),oRow.get("level2").getString(),oRow.get("level3").getString(), Long.parseLong(oRow.get("screen_emp_id").getString()),Long.parseLong(oRow.get("SCREEN_ID").getString()),"n"));  //added by swapnendu Dt 12.12.2012         
//                    tempList.add(new DynamicMenuBean(oRow.get("level1").getString(),oRow.get("level2").getString(),oRow.get("level3").getString(), Long.parseLong(oRow.get("screen_emp_id").getString()),"n"));            
//                    tempList.add(new DynamicMenuBean(res.getString("level1"),res.getString("level2"),res.getString("level3"),res.getLong("screen_emp_id"),"n"));                    
            }
            
            osaVO.setAssignedList(tempList);
        }
        catch(Exception e)
        {
              throw new EnrgiseSystemException(e);
        }     
        
        
        return osaVO;          
    }

    /**
     * This function is to get the Menu List for the Selected header
     * @param : moduleName which was selected
     * @param : headerName which was selected
     * @returns : boolean true if suceess
     * @Tables-Accessed: Retrived from sysadmin_screenaccess_mst
     */
     
//    public boolean saveDtls(SA_ScreenEmpMapVO osaVO) throws IBAFatalException,SQLException
     public boolean saveDtls(SA_ScreenEmpMapVO osaVO) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
/*        ArrayList tempList=new ArrayList();
        String header="";
        boolean retType=false;
        int j=0;
        int k=0;
        int i=0;
        try 
        {
            //FOR DELETING THE ALREADY ASSIGNED SCRRENS
            for(i=0;i<osaVO.getHdnDelScreenEmpId().length;i++)
            {
                doPrepareStatement(ScreenAcessQueries.SQL_DEL_ASSIGNEDLEVELS);                
                setLONGPRIMITIVE(osaVO.getHdnDelScreenEmpId()[i]);
                k=k+doExecuteUpdate();
                closePreparedStatement();                
            }

            //FOR INSERTING THE NEWLY ASSIGNED SCREENS TO THE USER        
            for(i=0;i<osaVO.getHdnScreenId().length;i++)
            {
                doPrepareStatement(ScreenAcessQueries.SQL_SAVE_EMPSCREENDTLS);                
                setLONGPRIMITIVE(osaVO.getUserSiteId());
                setLONGPRIMITIVE(osaVO.getHdnScreenId()[i]);
                setLONGPRIMITIVE(osaVO.getLstEmpNo());
                setLONGPRIMITIVE(osaVO.getUserSiteId());
                setLONGPRIMITIVE(osaVO.getUserEmpNo());
                setLONGPRIMITIVE(osaVO.getUserSiteId());
                j=j+doExecuteUpdate();
                closePreparedStatement();                
            }

            //to check that all the records are saved correctly
            if((j==osaVO.getHdnScreenId().length)&&(k==osaVO.getHdnDelScreenEmpId().length))
            {
                commit();
                retType=true;
            }
            closeConnection();
        }
        catch(IBAFatalException ibafe) 
        {
            rollBack();
            closePreparedStatement();
            closeConnection();
            ibafe.printStackTrace();
            ibafe = new IBAFatalException("Common.Database.Error");
            throw ibafe;    
        }
        catch(Exception e) 
        {
            rollBack();
            closePreparedStatement();
            closeConnection();
            e.printStackTrace();
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return retType;
    }   */

        ArrayList tempList=new ArrayList();
        String header="";
        boolean retType=false;
        int j=0;
        int k=0;
        int i=0;
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();       
        
        try 
        {
            //FOR DELETING THE ALREADY ASSIGNED SCRRENS
            for(i=0;i<osaVO.getHdnDelScreenEmpId().length;i++)
            {
                //added by swapnendu Dt 12.12.2012
                oParameters = new ArrayList();            
                oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(osaVO.getHdnDelScreenEmpId()[i])));                                    
                oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(osaVO.getLstLoc())));                                    
                oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(osaVO.getHdnAudScreenId()[i])));
                oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(osaVO.getLstEmpNo())));                                    
                oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(osaVO.getUserEmpNo())));                                    
                oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(osaVO.getUserSiteId())));                                    
                int y = oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_SAVE_EMPSCREENDTLS_AUDIT); 
                
                if(y > 0)
                {
                    oParameters = new ArrayList();            
                    oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(osaVO.getHdnDelScreenEmpId()[i])));                                    
                    int x = oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_DEL_ASSIGNEDLEVELS); 
                    k=k+x;
                }
            }
            //FOR INSERTING THE NEWLY ASSIGNED SCREENS TO THE USER        
            for(i=0;i<osaVO.getHdnScreenId().length;i++)
            {
                oParameters = new ArrayList();            
                oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(osaVO.getUserSiteId())));                                                
                oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(osaVO.getHdnScreenId()[i])));                                    
                oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,Long.toString(osaVO.getLstEmpNo())));                                                
                oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, Long.toString(osaVO.getLstLoc())));                                                
                oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, Long.toString(osaVO.getUserEmpNo())));                                                
                oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR, Long.toString(osaVO.getUserSiteId())));                                                                                
                int x = oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_SAVE_EMPSCREENDTLS); 
                j=j+x;
            }

            //to check that all the records are saved correctly
            if((j==osaVO.getHdnScreenId().length)&&(k==osaVO.getHdnDelScreenEmpId().length))
            {
//                commit();
                retType=true;
            }
        }

        catch(Exception e)
        {
              throw new EnrgiseSystemException(e);
        }     
                
        return retType;    

    }
}
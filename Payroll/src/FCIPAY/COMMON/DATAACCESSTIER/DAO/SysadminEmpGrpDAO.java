/* 
    * Module:        ScreenPermitMasterDAO.java 
    * Author:        Gaurav Arora   
    * Date Written:  11/2004    
    * Description:   Data Access Object class for Meter Master Screen
    * Revision Log   (mm/dd/yy initials description) 
    * -------------------------------------------------------- 
    * mm/dd/yy xxx  What you changed … 
*/ 

package FCIPAY.COMMON.DATAACCESSTIER.DAO;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.WEBTIER.Form.SysadminEmpGrpForm;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.SysadminEmpGrpQueries;
import FCIPAY.COMMON.DATAACCESSTIER.VO.SysadminEmpGrpVO;
import java.sql.*;
import java.util.*;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;


public class SysadminEmpGrpDAO 
{
    int j=0;
    SysadminEmpGrpForm oSPMForm=new SysadminEmpGrpForm();

    /**
     * This method retrieves CODE_DESC from SYSADMIN_SCREENACCESS_MST,COM_GBL_DTL Tables
     * @param String iLCCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
     */

    
    public List getValues(long lLocCode)  throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {
        List cList= new ArrayList();
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {     
        oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(lLocCode)));
        oOutArray = oBean.executeQuery(oParameters,SysadminEmpGrpQueries.sValuesQuery);
        oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
            oRow = (QueryRow)oIt.next();
            cList.add(oRow.get("grp_sdesc").getString());                      
            }
            
            return cList;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");        
        }
           
    }

        public  SysadminEmpGrpVO displayDesc(SysadminEmpGrpVO oSPMVO) throws IBAException,IBABusinessException,IBAFatalException,NullPointerException,SQLException
    {
         Iterator oIt = null;
         QueryRow oRow = null;      
         ArrayList oOutArray; 
         ArrayList oParameters = new ArrayList(); //Input Parameters      
         DBUtilitiesBean oBean = new DBUtilitiesBean();         
         try
        {
        //String sDescQuery1="select screenaccess_id,decode(nvl(level3,'empty'),'empty',decode(nvl(level2,'empty'),'empty',level1,level2),level3) FROM SYSADMIN_SCREENACCESS_MST where MODULE_NAME=(select GBL_CODE from COM_GBL_DTL where CODE_DESC='"+iLCCode+"')";
        oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oSPMVO.getLstModuleName()));
        oOutArray = oBean.executeQuery(oParameters,SysadminEmpGrpQueries.sDescQuery1);
        oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
            oRow = (QueryRow)oIt.next();
            oSPMVO.setTxtGrpDesc(oRow.get("grp_desc").getString());         
            oSPMVO.setTxtModule(oRow.get("code_desc").getString());  
            }         
        return oSPMVO;                
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");        
        }
    }

      public List getValues3(String query) throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {
        List cList3= new ArrayList();
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
         try
        {
        
        oOutArray = oBean.executeQuery(query);
        oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
            oRow = (QueryRow)oIt.next();
            cList3.add(oRow.get("EMP_NO").getString());                      
            }
        return cList3;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");        
        }

    }

    public boolean setDetails(SysadminEmpGrpVO oSPMVO,String iLCCode,String iLCCode1) throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {
       int i=0;
       int j=0;
       int flag=0;
       long lCount = 0;
       long userloc_id = 0;
       Iterator oIt = null;
       QueryRow oRow = null;      
       ArrayList oOutArray; 
       ArrayList oParameters = new ArrayList(); //Input Parameters      
       DBUtilitiesBean oBean = new DBUtilitiesBean();
       try
       {
          List cOldList = new ArrayList();
          //String sDescQuery4="SELECT DISTINCT(EMP_NO) FROM SYSADMIN_EMP_SCREEN_MAP WHERE LOC_ID='"+oSPMVO.getlLocationCode()+"'AND SCREEN_ID="+iLCCode1;
          String sDescQuery4="SELECT DISTINCT(EMP_NO) FROM sysadmin_grp_emp_mst WHERE grp_sdesc='"+iLCCode+"'";
          cOldList=this.getValues3(sDescQuery4);
              
          List cList= new ArrayList();            
          cList=oSPMVO.getLstMapValues();
          //System.out.println("size="+cList.size());
           //System.out.println("It is in SAVE in DAO");
       
           //System.out.println("size="+cOldList.size());
           for(i=0;i<cList.size();i++)
           {
             flag=0;
             for(j=0;((j<cOldList.size()) && (flag==0));j++)
             {
                if(cList.get(i).equals(cOldList.get(j)))
                {
                  flag=1;  
                }
             }      
             if(flag==0)
             {                   
              //userloc_id
              String query="select a.userloc_id userloc_id from sysadmin_user_loc a where a.emp_no="+cList.get(i)+" and a.loc_id="+oSPMVO.getlLocationCode(); 
              oOutArray = oBean.executeQuery(query);
              oIt = oOutArray.iterator();
              while(oIt.hasNext())
              {
                oRow = (QueryRow)oIt.next();
                userloc_id=Long.parseLong(oRow.get("userloc_id").getString());                      
              }
              
              String insert="insert into sysadmin_grp_emp_mst(grp_id,emp_no,grp_sdesc,created_site,created_user,userloc_id,created_dt) values(get_id("+oSPMVO.getlLocationCode()+", 'sysadmin_grp_emp_mst'),"+cList.get(i)+",'"+iLCCode+"',"+oSPMVO.getlLocationCode()+","+oSPMVO.getlEmployeeNo()+","+userloc_id+",sysdate)";
              //System.out.println(insert);                      
              lCount = oBean.executeUpsert(insert);
              if (lCount <= 0)
              {
                return false;
              }
            } 
          }
          for(i=0;i<cOldList.size();i++)
          {
             flag=2;
             for(j=0;((j<cList.size()) && (flag==2));j++)
             {
                 if(cList.get(j).equals(cOldList.get(i)))
                 {
                    flag=3;  
                 }
             }
             if(flag==2)
             {
           
              String delete="delete from sysadmin_grp_emp_mst where emp_no="+cOldList.get(i)+" and grp_sdesc='"+iLCCode+"'";
              lCount = oBean.executeUpsert(delete);
              if (lCount <= 0)
              {
                return false;
              } 
             }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");        
        } 
        return true;
    }
}

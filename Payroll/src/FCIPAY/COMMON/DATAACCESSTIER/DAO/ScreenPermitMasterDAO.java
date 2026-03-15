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
import FCIPAY.COMMON.WEBTIER.Form.ScreenPermitMasterForm;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ScreenPermitMasterVO;
import java.sql.*;
import FCIPAY.COMMON.UTILITY.DynamicMenuBean;
import java.util.*;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;


public class ScreenPermitMasterDAO extends BaseDAO
{
    int j=0;
    ScreenPermitMasterForm oSPMForm=new ScreenPermitMasterForm();

   public ScreenPermitMasterDAO()
    {
        super("Common");
    }
    /**
     * This method retrieves CODE_DESC from SYSADMIN_SCREENACCESS_MST,COM_GBL_DTL Tables
     * @param String iLCCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
     */

    
    public List getValues()  throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {
        List cList= new ArrayList();
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
        String sValuesQuery="select DISTINCT(COM_GBL_DTL.CODE_DESC) from COM_GBL_DTL,SYSADMIN_SCREENACCESS_MST where COM_GBL_DTL.GBL_CODE=SYSADMIN_SCREENACCESS_MST.MODULE_NAME and SYSADMIN_SCREENACCESS_MST.MODULE_NAME in('M$PAYROLL','M$SA','M$LBR','M$NWNP')";
        oOutArray = oBean.executeQuery(sValuesQuery);
        oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
            oRow = (QueryRow)oIt.next();
            cList.add(oRow.get("CODE_DESC").getString());                      
            }
            
            return cList;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");        
        }
           
    }

    /**
     * This method retrieves screenaccess_id,screen names from SYSADMIN_SCREENACCESS_MST,COM_GBL_DTL Tables
     * @param String iLCCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
     */
    
    public  List displayDesc(String iLCCode) throws IBAException,IBABusinessException,IBAFatalException,NullPointerException,SQLException
    {
         List cList1= new ArrayList();
         List cLabel= new ArrayList();
         List cValue= new ArrayList();
         
         Iterator oIt = null;
         QueryRow oRow = null;      
         ArrayList oOutArray; 
         ArrayList oParameters = new ArrayList(); //Input Parameters      
         DBUtilitiesBean oBean = new DBUtilitiesBean();
         try
        {
        String sDescQuery1="select screenaccess_id,decode(nvl(level3,'empty'),'empty',decode(nvl(level2,'empty'),'empty',level1,level2),level3) level FROM SYSADMIN_SCREENACCESS_MST where MODULE_NAME=(select GBL_CODE from COM_GBL_DTL where CODE_DESC='"+iLCCode+"')";
        oOutArray = oBean.executeQuery(sDescQuery1);
        oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
            oRow = (QueryRow)oIt.next();
            cLabel.add(oRow.get("level").getString());         
            cValue.add(oRow.get("screenaccess_id").getString());  
            }
            cList1.add(cLabel);
            cList1.add(cValue);          
        return cList1;                
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");        
        }
    }

    /**
     * This method retrieves EMP_NO from SYSADMIN_SCREENACCESS_MST,COM_GBL_DTL,SYSADMIN_USER_LOC Tables
     * @param String iLCCode,String iLCCode1,long lLocCode
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
     */

        public List getValues3(String query) throws IBAException,IBABusinessException, IBAFatalException,SQLException
        {
        List cList3Id= new ArrayList();
        List cList3Desc= new ArrayList();
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
                  cList3Desc.add(oRow.get("EMP_NO").getString());
                  cList3Id.add(oRow.get("EMP_LOC").getString());
              }
              cList3.add(cList3Desc);
              cList3.add(cList3Id);
              return cList3;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");        
        }
    }
    /**
     * This method insert and delete record into sysadmin_emp_screen_map Table
     * @param MeterMasterVO oSPMVO
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return true,false
     */
    
    public boolean setDetails(ScreenPermitMasterVO oSPMVO,String iLCCode,String iLCCode1) throws IBAException,IBABusinessException, IBAFatalException,SQLException
    {
       int i=0;
       int j=0;
       int flag=0;
       long lCount = 0;
       
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
       try
       {
       List cOldList = new ArrayList();
       String sDescQuery4="SELECT DISTINCT EMP_NO||':'||loc_id EMP_NO FROM SYSADMIN_EMP_SCREEN_MAP WHERE SCREEN_ID="+iLCCode1;
       cOldList=this.getEmp(sDescQuery4);
       
       List cList= new ArrayList(); 
       //System.out.println(oSPMVO.getLstMapValues().size());
       cList=oSPMVO.getLstMapValues();
       //System.out.println("size="+cList.size());
       //System.out.println("It is in SAVE in DAO");
       
        //System.out.println("size="+cOldList.size());
        for(i=0;i<cList.size();i++)
        {
           flag=0;
           String data=(String)cList.get(i);
           String [] sData=data.split(":");
           String sEmp=sData[0];
           String sLoc=sData[1];
           for(j=0;((j<cOldList.size()) && (flag==0));j++)
           {
            if(cList.get(i).equals(cOldList.get(j)))
               {
               flag=1;  
               }
           } 
           //System.out.println("Outside if "+i);
           //System.out.println("Flag "+flag);
           if(flag==0)
           {    
                 
                 String insert="insert into sysadmin_emp_screen_map(screen_emp_id,screen_id,emp_no,loc_id,created_user,created_site,created_date) values(get_id("+sLoc+",'sysadmin_emp_screen_map'),"+iLCCode1+","+sEmp+","+sLoc+","+oSPMVO.getlEmployeeNo()+","+oSPMVO.getlLocationCode()+",sysdate)";
                 System.out.println("Qruery is"+insert);
                 lCount = oBean.executeUpsert(insert);
                 //System.out.println(lCount);
                 if (lCount <= 0)
                 {
                  return false;
                 }
            } 
        }
        for(i=0;i<cOldList.size();i++)
        {
           flag=2;
           String data=(String)cOldList.get(i);
           String [] sData=data.split(":");
           String sEmp=sData[0];
           String sLoc=sData[1];
           for(j=0;((j<cList.size()) && (flag==2));j++)
           {
              if(cList.get(j).equals(cOldList.get(i)))
              {
               flag=3;  
              }
           }
           if(flag==2)
           {
           
             String delete="delete from sysadmin_emp_screen_map where emp_no="+sEmp+" and loc_id="+sLoc+" and screen_id="+iLCCode1;
             lCount = oBean.executeUpsert(delete);
             if (lCount <= 0)
              {
              return false;            
              }
           }
          
           
        }
           return true;
       } 
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");        
        } 
        
    }

     public ArrayList getLevels(String query,String module,String header) throws IBAException,IBABusinessException, IBAFatalException,SQLException
     {
         ArrayList tempList= new ArrayList();
         Iterator oIt = null;
         QueryRow oRow = null;      
         ArrayList oOutArray; 
         ArrayList oParameters = new ArrayList(); //Input Parameters      
         DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
              oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,module));
              oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,header));
              oOutArray = oBean.executeQuery(oParameters,query);
              oIt = oOutArray.iterator();
              while(oIt.hasNext())
              {
                  oRow = (QueryRow)oIt.next();
                  tempList.add(new DynamicMenuBean(oRow.get("level1").getString(),oRow.get("level2").getString(),oRow.get("level3").getString(),Long.parseLong(oRow.get("screenaccess_id").getString()),"n"));                     
              }
              return tempList;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");        
        }
     }
     
    /**
     * This method retrieves EMP_NO from SYSADMIN_SCREENACCESS_MST,COM_GBL_DTL,SYSADMIN_USER_LOC Tables
     * @exception IBAException,IBAFatalException,IBABusinessException
     * @return List
     */

        public List getEmp(String query) throws IBAException,IBABusinessException, IBAFatalException,SQLException
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
}






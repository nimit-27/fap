package FCIPAY.COMMON.DATAACCESSTIER.DAO;
import FCIPAY.COMMON.UTILITY.BaseDAO;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.WEBTIER.Form.ScreenPermitMasterForm;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ScreenPermitMasterVO;
import java.sql.*;
import FCIPAY.COMMON.UTILITY.DynamicMenuBean;
import java.util.*;
import FCIPAY.COMMON.DATAACCESSTIER.VO.ReportingOfficerScreenAccessVO;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ReportingOfficerScreenAccessQueries;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ReptOffChangeSQLQueries;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class ReportingOfficerScreenAccessDAO extends BaseDAO 
{
    public ReportingOfficerScreenAccessDAO()
    {
        super("COMMON");
    }
    
    public ArrayList getLevels(String query,String exisEmpNo,String ReptEmpNo,long locID,long newLocID) throws IBAException,IBABusinessException, IBAFatalException,SQLException
     {
         ArrayList tempList= new ArrayList();
         
         Iterator oIt = null;
         QueryRow oRow = null;      
         ArrayList oOutArray; 
         ArrayList oParameters = new ArrayList(); //Input Parameters      
         DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
              
              oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(exisEmpNo))));
              oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(locID)));
              oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(ReptEmpNo))));
              oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(newLocID)));
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

     public ArrayList getEmpName(ReportingOfficerScreenAccessVO oVO) throws IBAFatalException, SQLException
    {
        String empName = null;
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList locList=new ArrayList();
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oVO.getTxtExisEmployeeNo()))));
        //    oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oVO.getLSiteID())));
            oOutArray = oBean.executeQuery(oParameters,ReptOffChangeSQLQueries.GET_EMPNAME);
            oIt = oOutArray.iterator();
            String idString="";
            String code="";
            long idLong=0;
            while(oIt.hasNext())
            {
              oRow = (QueryRow)oIt.next();
              code=oRow.get("loc_desc").getString();
              idString=oRow.get("loc_id").getString();
              idLong=Long.parseLong(idString);
              locList.add(new comboBean(idLong,code));
            }
                
        }
        catch(Exception e)
        {
            throw new IBAFatalException("HRMS.DBError.General");
        }
        return locList;
    }

     public boolean updateList(ReportingOfficerScreenAccessVO oVO) throws IBAException,IBABusinessException, IBAFatalException,SQLException
     {
          boolean ret=false;
          Iterator oIt = null;
          QueryRow oRow = null;      
          ArrayList oOutArray; 
          ArrayList oParameters = new ArrayList(); //Input Parameters      
          DBUtilitiesBean oBean = new DBUtilitiesBean();
        
         try
         {
             oBean.createBatch(ReportingOfficerScreenAccessQueries.UPDATE_ACCESS);
             for(int i=0;i<oVO.getHeaderList().size();i++)
             {
                DynamicMenuBean oDBean=(DynamicMenuBean)oVO.getHeaderList().get(i);
                
                oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oVO.getLSiteID())));
                oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oDBean.getHdnScreenId())));
                oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oVO.getTxtReptEmployeeNo()))));
                oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oVO.getLUserID())));
                oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oVO.getLSiteID())));
                oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oVO.getLSiteID())));
                
                oBean.addToBatch(oParameters);
             }
             oBean.executeBatch();
             ret=true;
         }
         catch(Exception e)
         {
            e.printStackTrace();
            throw new IBAFatalException("Finance.DB.Administrator");        
         }
         return ret;
     }
}
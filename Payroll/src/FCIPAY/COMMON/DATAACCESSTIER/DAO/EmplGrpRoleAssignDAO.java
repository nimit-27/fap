package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.lang.StringBuffer;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.struts.util.LabelValueBean;
import org.apache.commons.lang.StringUtils;

import FCIPAY.COMMON.UTILITY.IBAException;
import FCIPAY.COMMON.UTILITY.IBABusinessException;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.BaseDAO;
import FCIPAY.COMMON.UTILITY.DateUtilities;
import FCIPAY.COMMON.UTILITY.EmplRoleRowBean;

import FCIPAY.COMMON.DATAACCESSTIER.VO.EmplGrpRoleAssignVO;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.EmplGrpRoleAssignQueries;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class EmplGrpRoleAssignDAO extends BaseDAO {
    private EmplGrpRoleAssignQueries oEmplGrpRoleAssignQueries=null;
    public EmplGrpRoleAssignDAO() {
        super("SA");
        oEmplGrpRoleAssignQueries=new EmplGrpRoleAssignQueries();
    }

    
    public ArrayList getEmpUserLocIdDetailsDAO(long empNo,long locId) throws IBAFatalException {
        ResultSet rSet=null;
        ArrayList lstReturn=new ArrayList(4);
        ArrayList lstModules=new ArrayList();
        ArrayList lstRoles=new ArrayList(4);
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try {
            
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(locId)));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(empNo)));
            oOutArray = oBean.executeQuery(oParameters,oEmplGrpRoleAssignQueries.GET_EMPL_USERLOCID_DETAILS);
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                oRow = (QueryRow)oIt.next();
                lstReturn.add(oRow.get("EMP_NAME").getString());
                lstReturn.add(new Long(oRow.get("LOC_ID").getLong()));
            }
            
            if(lstReturn.size()<=0)
                return lstReturn;
            oParameters=new ArrayList();
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(locId)));
            oOutArray = oBean.executeQuery(oParameters,oEmplGrpRoleAssignQueries.GET_MODULES);
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                oRow = (QueryRow)oIt.next();
                lstModules.add(new LabelValueBean(oRow.get("MODULE_GBL").getString(),oRow.get("CODE_DESC").getString()));
            }
            lstReturn.add(lstModules);
            oOutArray = oBean.executeQuery(oEmplGrpRoleAssignQueries.GET_ROLES);
            oIt = oOutArray.iterator();
            
            while(oIt.hasNext()) {
                oRow=(QueryRow)oIt.next();
                lstRoles.add(new LabelValueBean(oRow.get("GBL_CODE").getString(),oRow.get("CODE_DESC").getString()));
            }
            lstReturn.add(lstRoles);
        }
        catch(Exception e) {
            System.out.println("Error in getEmpUserLocIdDetailsDAO"+"-"+e.getMessage());
            throw new IBAFatalException("Common.DB.Administrator");
        }
        return lstReturn;
    }

    public ArrayList getEmpGroupDetailsDAO(long empNo,long locId,String modId) throws IBAFatalException {
        ResultSet rSet=null;
        ArrayList lstReturn=new ArrayList();
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try {
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(locId)));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,modId));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(empNo)));
            oOutArray=oBean.executeQuery(oEmplGrpRoleAssignQueries.GET_GROUPS);
            oIt=oOutArray.iterator();
            while(oIt.hasNext()) {
                oRow=(QueryRow)oIt.next();
                lstReturn.add(new LabelValueBean(oRow.get("GRP_SDESC").getString(),oRow.get("GRP_DESC").getString()));
            }
        }
        catch(Exception e) {
            System.out.println("Error in getEmpGroupDetailsDAO"+"-"+e.getMessage());
            throw new IBAFatalException("Common.DB.Administrator");
        }
        return lstReturn;
    }

    public ArrayList getEmpRoleDetailsDAO(long empNo,long locId,String modId) throws IBAFatalException {
        ResultSet rSet=null;
        ArrayList lstReturn=new ArrayList();
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try {
            
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(locId)));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,modId));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(empNo)));
            oOutArray=oBean.executeQuery(oEmplGrpRoleAssignQueries.GET_ROLES);
            oIt=oOutArray.iterator();
            while(oIt.hasNext()) {
                oRow=(QueryRow)oIt.next();
                lstReturn.add(new LabelValueBean(oRow.get("GBL_CODE").getString(),oRow.get("CODE_DESC").getString()));
            }
        }
        catch(Exception e) {
            System.out.println("Error in getEmpGroupDetailsDAO"+"-"+e.getMessage());
            throw new IBAFatalException("Common.DB.Administrator");
        }
        return lstReturn;
    }

    public ArrayList getEmpRoleRowDetailsDAO(long userLocId,String roleId,String modId) throws IBAFatalException {
        ResultSet rSet=null;
        ArrayList lstReturn=new ArrayList();
        HashMap tMap=new HashMap(10);
        String s1="";
        String s2="";
        String s3="";
        String s4="";
        
         Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try {
            
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(userLocId)));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,modId));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,roleId));
            oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(userLocId)));
            oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,roleId));
            oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(userLocId)));
            oParameters.add(new InputDBObject(7,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,modId));
            oParameters.add(new InputDBObject(8,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,roleId));
            oParameters.add(new InputDBObject(9,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(userLocId)));
            oParameters.add(new InputDBObject(10,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,modId));
            oParameters.add(new InputDBObject(11,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,roleId));
            oParameters.add(new InputDBObject(12,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(userLocId)));
            oParameters.add(new InputDBObject(13,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,roleId));
            oParameters.add(new InputDBObject(14,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,modId));
            
            int i=0;
            oOutArray=oBean.executeQuery(oEmplGrpRoleAssignQueries.GET_ROLES_ROWS);
            System.out.println(oEmplGrpRoleAssignQueries.GET_ROLES_ROWS);
            oIt=oOutArray.iterator();
            while(oIt.hasNext()) {
                oRow=(QueryRow)oIt.next();
                lstReturn.add(new EmplRoleRowBean(String.valueOf(oRow.get("EMPROLE_ID").getLong()),oRow.get("SCREEN_SDESC").getString(),oRow.get("ROLE_ID_GBL").getString(),oRow.get("SCREEN_DESC").getString()));
            }
            
        }
        catch(Exception e) {
            System.out.println("Error in getEmpRoleRowDetailsDAO"+"-"+e.getMessage());
            throw new IBAFatalException("Common.DB.Administrator");
        }
        return lstReturn;
    }
    public void SaveDAO(EmplGrpRoleAssignVO oEmplGrpRoleAssignVO) throws IBAFatalException {
        LabelValueBean oLabelValueBean=null;
        EmplRoleRowBean oEmplRoleRowBean=null;
        String[] strGroupRows=oEmplGrpRoleAssignVO.getTxtHidGroupChecked();
        String[] strRoleRows=oEmplGrpRoleAssignVO.getTxtHidRoleChecked();
        ArrayList lstGroupRows=oEmplGrpRoleAssignVO.getLstGroupRows();
        ArrayList lstRoleRows=oEmplGrpRoleAssignVO.getLstRoleRows();
        int i=0;
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        
        try {
            for(i=0;i<lstGroupRows.size();i++) {
                if("Y".equals(strGroupRows[i])) {
                    oParameters = new ArrayList();
                    oLabelValueBean=(LabelValueBean)lstGroupRows.get(i);
                 //   setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtLocId()));
                    oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtLocId()))));
                 //   setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtEmplNo()));
                    oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtEmplNo()))));
                 //   setSTRING(oLabelValueBean.getLabel());
                    oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oLabelValueBean.getLabel()));
                 //   setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtUserId()));
                    oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtUserId()))));
                //    setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtLocId()));
                    oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtLocId()))));
                 //   setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtHidUserLocId()));
                    oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtHidUserLocId()))));
                    
                    oBean.executeUpsert(oParameters,oEmplGrpRoleAssignQueries.INSERT_GROUPS);
                }
            }      
            for(i=0;i<lstRoleRows.size();i++) {
                if("Y".equals(strRoleRows[i])) {
                    oEmplRoleRowBean=(EmplRoleRowBean)lstRoleRows.get(i);
                    if("0".equals(oEmplRoleRowBean.getTxtEmpRoleId())) {
                        oParameters = new ArrayList();
                     //   setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtLocId()));
                        oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtLocId()))));
                     //   setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtHidUserLocId()));
                        oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtHidUserLocId()))));
                    //    setSTRING(oEmplGrpRoleAssignVO.getTxtRole());
                        oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oEmplGrpRoleAssignVO.getTxtRole()));
                   //     setSTRING(oEmplRoleRowBean.getTxtScreenSdesc());
                        oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oEmplRoleRowBean.getTxtScreenSdesc()));
                    //    setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtUserId()));
                        oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtUserId()))));
                    //    setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtLocId()));
                        oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtLocId()))));
                        
                        oBean.executeUpsert(oParameters,oEmplGrpRoleAssignQueries.INSERT_ASSIGN_ROLES);
                    }           
                    else {
                        oParameters = new ArrayList();
                     //   setSTRING(oEmplGrpRoleAssignVO.getTxtRole());
                        oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oEmplGrpRoleAssignVO.getTxtRole()));
                     //   setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtUserId()));
                        oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtUserId()))));
                     //   setLONGPRIMITIVE(Long.parseLong(oEmplGrpRoleAssignVO.getTxtLocId()));
                        oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplGrpRoleAssignVO.getTxtLocId()))));
                    //    setLONGPRIMITIVE(Long.parseLong(oEmplRoleRowBean.getTxtEmpRoleId()));
                        oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(Long.parseLong(oEmplRoleRowBean.getTxtEmpRoleId()))));
                        
                        oBean.executeUpsert(oParameters,oEmplGrpRoleAssignQueries.UPDATE_ASSIGN_ROLES);
                        
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println("Error in getEmpRoleRowDetailsDAO"+"-"+e.getMessage());
            rollBack();            
            throw new IBAFatalException("Common.DB.Administrator");
        }
    }
}
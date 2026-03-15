/*
 * Program Name : GroupMasterDAO.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This DAO has all the database relaated things
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.DAO;

import java.util.*;
import java.sql.*;

import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.GroupMasterQueries;
import FCIPAY.COMMON.DATAACCESSTIER.VO.GroupMasterVO;
import FCIPAY.COMMON.UTILITY.comboBean;
import FCIPAY.COMMON.UTILITY.DynamicMenuBean;
import FCIPAY.COMMON.UTILITY.IBAFatalException;
import FCIPAY.COMMON.UTILITY.BaseDAO;

import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class GroupMasterDAO extends BaseDAO
{
    public GroupMasterDAO() 
    {
        super("Common");
    }

    /**
     * This is the Onload function whihc gets executed on the Load of the pages
     * @param loc_Id The location id from the user info bean
     * @return GroupMasterVO which has all the Groups that are enetered already and the list of modules
     */

    public GroupMasterVO getOnLoadDtls(long loc_Id) throws IBAFatalException
    {
        GroupMasterVO oGrpMstVO=new GroupMasterVO();
        oGrpMstVO.setGrpList(getGroupList(loc_Id));
        ArrayList templist=new ArrayList();
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray;     
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
           // doPrepareStatement(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.GroupMasterQueries.SQL_GETMODULE);
            //setLONGPRIMITIVE(loc_Id);
            oOutArray = oBean.executeQuery(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.GroupMasterQueries.SQL_GETMODULE);
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                oRow = (QueryRow)oIt.next();
                templist.add(new comboBean(oRow.get("GBL_CODE").getString(),oRow.get("CODE_SDESC").getString()));
            } 
            
         /*   res=doExecuteQuery(false);
            while(res.next()) 
            {
                templist.add(new comboBean(res.getString("GBL_CODE"),res.getString("CODE_SDESC")));
            }
            res.close();
            closePreparedStatement();
            closeConnection();*/
            oGrpMstVO.setModuleList(templist);
            //System.out.println("Location Id is "  + loc_Id);
            //System.out.println("In Dao the Group List Size is " + oGrpMstVO.getGrpList().size());
            //System.out.println("In Dao the Module List Size is " + oGrpMstVO.getModuleList().size());
        }
        catch(Exception e) 
        {
       //     closePreparedStatement();
         //   closeConnection();
            //e.printStackTrace();    
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return oGrpMstVO;
    }


    /**
     * This is the function whihc gets all the Groups available for that Location
     * @param loc_Id The location id from the user info bean
     * @return ArrayList which has all the Groups that are enetered already
     */

    public ArrayList getGroupList(long loc_Id) throws IBAFatalException
    {
        ArrayList grpList=new ArrayList();
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        try
        {
           oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(loc_Id)));
         //  doPrepareStatement(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.GroupMasterQueries.SQL_GETGROUP_DTLS);
          //  setLONGPRIMITIVE(loc_Id);
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.GroupMasterQueries.SQL_GETGROUP_DTLS);
          //  res=doExecuteQuery(false);
            oIt = oOutArray.iterator();
            while(oIt.hasNext()) 
            {
                oRow = (QueryRow)oIt.next();
                grpList.add(new DynamicMenuBean(oRow.get("GRP_SDESC").getString(),oRow.get("GRP_DESC").getString(),oRow.get("GRP_STAT_FLG").getString(),oRow.get("MODULE_GBL").getString(),oRow.get("CODE_SDESC").getString()));    
            }
        }
        catch(Exception e) 
        {
            //e.printStackTrace();    
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return grpList;
    }


    /**
     * This is the Update function whihc is for updating the group details
     * @param oGrpVO GroupMasterVO which has all the form elements which are to be updated
     * @return ArrayList which has all the Groups that are enetered already
     */
    public ArrayList UpdateGrpDtls(GroupMasterVO oGrpVO) throws IBAFatalException
    {
        ArrayList UpdateGrpList=new ArrayList();
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int retSave=0;
        try
        {
           // doPrepareStatement(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.GroupMasterQueries.SQL_UPDATEGRP_DTLS);
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oGrpVO.getLstStatus()));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oGrpVO.getUserId())));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oGrpVO.getLocId())));
            oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oGrpVO.getTxtGrpSDesc()));
            oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oGrpVO.getLocId())));
            
            retSave = oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.GroupMasterQueries.SQL_UPDATEGRP_DTLS);
          /*  setVARCHAR(oGrpVO.getLstStatus());
            setLONGPRIMITIVE(oGrpVO.getUserId());
            setLONGPRIMITIVE(oGrpVO.getLocId());
            setVARCHAR(oGrpVO.getTxtGrpSDesc());
            setLONGPRIMITIVE(oGrpVO.getLocId());*/
            
            if(retSave>0) 
            {
                UpdateGrpList=getGroupList(oGrpVO.getLocId());
            }        
        }
        catch(IBAFatalException e) 
        {
            //e.printStackTrace(); 
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        catch(Exception e) 
        {
            //e.printStackTrace();    
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return UpdateGrpList;
    }


    /**
     * This is the Dave function whihc is for updating the group details
     * @param oGrpVO GroupMasterVO which has all the form elements which are to be saved
     * @return ArrayList which has all the Groups that are enetered already
     */
    public ArrayList saveGrpDtls(GroupMasterVO oGrpVO) throws IBAFatalException
    {
        ArrayList saveGrpList=new ArrayList();
        
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        int retSave=0;
        try
        {
            //doPrepareStatement(FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.GroupMasterQueries.SQL_INSERTGRP_DTLS);
            
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oGrpVO.getTxtGrpSDesc()));
            oParameters.add(new InputDBObject(2,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oGrpVO.getLocId())));
            oParameters.add(new InputDBObject(3,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oGrpVO.getTxtDesc()));
            oParameters.add(new InputDBObject(4,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oGrpVO.getLstStatus()));
            oParameters.add(new InputDBObject(5,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,oGrpVO.getLstModule()));
            oParameters.add(new InputDBObject(6,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oGrpVO.getUserId())));
            oParameters.add(new InputDBObject(7,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.BIGINT,new Long(oGrpVO.getLocId())));
            
            retSave = oBean.executeUpsert(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.GroupMasterQueries.SQL_INSERTGRP_DTLS);
           /* setVARCHAR(oGrpVO.getTxtGrpSDesc());
            setLONGPRIMITIVE(oGrpVO.getLocId());
            setVARCHAR(oGrpVO.getTxtDesc());
            setVARCHAR(oGrpVO.getLstStatus());
            setVARCHAR(oGrpVO.getLstModule());
            setLONGPRIMITIVE(oGrpVO.getUserId());
            setLONGPRIMITIVE(oGrpVO.getLocId());*/
            if(retSave>0) 
            {
                saveGrpList=getGroupList(oGrpVO.getLocId());
            }       
        }
        catch(IBAFatalException ibafe) 
        {
            //ibafe.printStackTrace();
            ibafe = new IBAFatalException(""+ibafe.getiErrCode());
            throw ibafe;
        }
        catch(Exception e) 
        {
            //e.printStackTrace();
            IBAFatalException iba = new IBAFatalException("Common.Database.Error");
            throw iba;
        }
        return saveGrpList;
    }
}
/*
 * Program Name : GroupMasterVO.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This Vo gets all the values to be in the Group Master Creation form
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.VO;

import java.util.ArrayList;

public class GroupMasterVO  
{
    private String txtGrpSDesc="";
    private String txtDesc="";
    private String lstStatus="";
    private long userId=0;
    private long locId=0;

    private ArrayList grpList=new ArrayList();
    private ArrayList moduleList=new ArrayList();
    private String lstModule;

    public long getLocId() {
        return locId;
    }

    public void setLocId(long newLocId) {
        locId = newLocId;
    }

    public String getLstStatus() {
        return lstStatus;
    }

    public void setLstStatus(String newLstStatus) {
        lstStatus = newLstStatus;
    }

    public String getTxtDesc() {
        return txtDesc;
    }

    public void setTxtDesc(String newTxtDesc) {
        txtDesc = newTxtDesc;
    }

    public String getTxtGrpSDesc() {
        return txtGrpSDesc;
    }

    public void setTxtGrpSDesc(String newTxtGrpSDesc) {
        txtGrpSDesc = newTxtGrpSDesc;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long newUserId) {
        userId = newUserId;
    }

    public ArrayList getModuleList()
    {
        return moduleList;
    }

    public void setModuleList(ArrayList newModuleList)
    {
        moduleList = newModuleList;
    }

    public ArrayList getGrpList()
    {
        return grpList;
    }

    public void setGrpList(ArrayList newGrpList)
    {
        grpList = newGrpList;
    }

    public String getLstModule()
    {
        return lstModule;
    }

    public void setLstModule(String newLstModule)
    {
        lstModule = newLstModule;
    }
}
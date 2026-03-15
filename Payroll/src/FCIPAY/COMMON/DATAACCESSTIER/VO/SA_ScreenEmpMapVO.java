
/*
 * Program Name : SA_ScreenEmpMapVO.java
 * Author       : Jegan.V
 * Date Written : 08/03/2004
 * Description  : This is the Value Object which has the values going to the DAO.
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.VO;

import java.util.ArrayList;

public class SA_ScreenEmpMapVO  {
    private ArrayList empList=new ArrayList();
    private ArrayList moduleList=new ArrayList();
    private ArrayList headerList=new ArrayList();
    private String hdnAction="";
    private String hdnEmpName="";
    private String hdnDesig="";
    private String hdnDept="";
    private long lstEmpNo=0;
    private long lstLoc=0;
    private String lstModule="";
    private String lstHeader="";
    private long[] hdnScreenId;
    private long[] hdnDelScreenEmpId;
    private long userSiteId=0;
    private long userEmpNo=0;
    private ArrayList menuList;
    private ArrayList assignedList;
    private long[] hdnAudScreenId; //added by swapnendu Dt 12/12/2012

    public ArrayList getEmpList() {
        return empList;
    }

    public void setEmpList(ArrayList newEmpList) {
        empList = newEmpList;
    }

    public ArrayList getModuleList() {
        return moduleList;
    }

    public void setModuleList(ArrayList newModuleList) {
        moduleList = newModuleList;
    }

    public ArrayList getHeaderList() {
        return headerList;
    }

    public void setHeaderList(ArrayList newHeaderList) {
        headerList = newHeaderList;
    }

    public String getHdnAction() {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction) {
        hdnAction = newHdnAction;
    }

    public String getHdnEmpName() {
        return hdnEmpName;
    }

    public void setHdnEmpName(String newHdnEmpName) {
        hdnEmpName = newHdnEmpName;
    }

    public String getHdnDesig() {
        return hdnDesig;
    }

    public void setHdnDesig(String newHdnDesig) {
        hdnDesig = newHdnDesig;
    }

    public String getHdnDept() {
        return hdnDept;
    }

    public void setHdnDept(String newHdnDept) {
        hdnDept = newHdnDept;
    }

    public long getLstEmpNo() {
        return lstEmpNo;
    }

    public void setLstEmpNo(long newLstEmpNo) {
        lstEmpNo = newLstEmpNo;
    }

    public String getLstModule() {
        return lstModule;
    }

    public void setLstModule(String newLstModule) {
        lstModule = newLstModule;
    }

    public String getLstHeader() {
        return lstHeader;
    }

    public void setLstHeader(String newLstHeader) {
        lstHeader = newLstHeader;
    }

    public long[] getHdnScreenId() {
        return hdnScreenId;
    }

    public void setHdnScreenId(long[] newHdnScreenId) {
        hdnScreenId = newHdnScreenId;
    }

    public long getUserSiteId() {
        return userSiteId;
    }

    public void setUserSiteId(long newUserSiteId) {
        userSiteId = newUserSiteId;
    }

    public long getUserEmpNo() {
        return userEmpNo;
    }

    public void setUserEmpNo(long newUserEmpNo) {
        userEmpNo = newUserEmpNo;
    }

    public ArrayList getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList newMenuList) {
        menuList = newMenuList;
    }

    public ArrayList getAssignedList() {
        return assignedList;
    }

    public void setAssignedList(ArrayList newAssignedList) {
        assignedList = newAssignedList;
    }

    public long[] getHdnDelScreenEmpId() {
        return hdnDelScreenEmpId;
    }

    public void setHdnDelScreenEmpId(long[] newHdnDelScreenEmpId) {
        hdnDelScreenEmpId = newHdnDelScreenEmpId;
    }

    public long getLstLoc() {
        return lstLoc;
    }

    public void setLstLoc(long newLstLoc) {
        lstLoc = newLstLoc;
    }
    public long[] getHdnAudScreenId() {
        return hdnAudScreenId;
    }

    public void setHdnAudScreenId(long[] newHdnAudScreenId) {
        hdnAudScreenId = newHdnAudScreenId;
    }

}
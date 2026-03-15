
/*
 * Program Name : SA_ScreenEmpMapForm.java
 * Author       : Jegan.V
 * Date Written : 08/03/2004
 * Description  : This is the Action Form which maps the values with the jsp page
 *
*/

package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class SA_ScreenEmpMapForm extends ActionForm  
{
    private ArrayList empList=new ArrayList();
    private ArrayList moduleList=new ArrayList();
    private ArrayList headerList=new ArrayList();
    private ArrayList locList=new ArrayList();
    private long lstLoc;
    private String hdnAction="";
    private String hdnEmpName="";
    private String hdnDesig="";
    private String hdnDept="";
    private long lstEmpNo=0;
    private String lstModule="";
    private String lstHeader="";
    private String chkSelect="";
    private ArrayList menuList=new ArrayList();
    private ArrayList assignedList=new ArrayList();
    private int hdnScreenCnt=0;
    private long[] hdnScreenId=null;
    private String[] hdnCheck=null;
    private int hdnDelCnt;
    private String chkDel="";
    private long txtEmpNo=0;
    private String hdnFocus="";
    private long[] hdnAudScreenId=null;

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

    public ArrayList getLocList() {
        return locList;
    }

    public void setLocList(ArrayList newLocList) {
        locList = newLocList;
    }

    public long getLstLoc() {
        return lstLoc;
    }

    public void setLstLoc(long newLstLoc) {
        lstLoc = newLstLoc;
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

    public String getChkSelect() {
        return chkSelect;
    }

    public void setChkSelect(String newChkSelect) {
        chkSelect = newChkSelect;
    }

    public ArrayList getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList newMenuList) {
        menuList = newMenuList;
    }

    public int getHdnScreenCnt() {
        return hdnScreenCnt;
    }

    public void setHdnScreenCnt(int newHdnScreenCnt) {
        hdnScreenCnt = newHdnScreenCnt;
    }

    public String[] getHdnCheck() {
        return hdnCheck;
    }

    public void setHdnCheck(String[] newHdnCheck) {
        hdnCheck = newHdnCheck;
    }

    public long[] getHdnScreenId() {
        return hdnScreenId;
    }

    public void setHdnScreenId(long[] newHdnScreenId) {
        hdnScreenId = newHdnScreenId;
    }

    public int getHdnDelCnt() {
        return hdnDelCnt;
    }

    public void setHdnDelCnt(int newHdnDelCnt) {
        hdnDelCnt = newHdnDelCnt;
    }

    public ArrayList getAssignedList() {
        return assignedList;
    }

    public void setAssignedList(ArrayList newAssignedList) {
        assignedList = newAssignedList;
    }

    public String getChkDel() {
        return chkDel;
    }

    public void setChkDel(String newChkDel) {
        chkDel = newChkDel;
    }

    public long getTxtEmpNo()
    {
        return txtEmpNo;
    }

    public void setTxtEmpNo(long newTxtEmpNo)
    {
        txtEmpNo = newTxtEmpNo;
    }

    public String getHdnFocus()
    {
        return hdnFocus;
    }

    public void setHdnFocus(String newHdnFocus)
    {
        hdnFocus = newHdnFocus;
    }
    public long[] getHdnAudScreenId() {
        return hdnAudScreenId;
    }

    public void setHdnAudScreenId(long[] newHdnAudScreenId) {
        hdnAudScreenId = newHdnAudScreenId;
    }

}
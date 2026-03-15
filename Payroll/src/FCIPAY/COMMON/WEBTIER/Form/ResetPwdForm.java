/*
 * Program Name : ResetPwdForm.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Action Form for resetPwd which is to get values from the page
 *
*/


package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class ResetPwdForm extends ActionForm  {
    private long txtEmpNo=0;
    private String hdnAction="";
    private int hdnEmpDtls=0;
    private String hdnEmpDesig="";
    private String hdnEmpName="";
    private String hdnEmpDept="";
    private String screenMode="";
    private String loginLocCode="";
    private String userStatus="";

    public long getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setTxtEmpNo(long newTxtEmpNo) {
        txtEmpNo = newTxtEmpNo;
    }

    public String getScreenMode() {
        return screenMode;
    }

    public void setScreenMode(String newScreenMode) {
        screenMode = newScreenMode;
    }

    public String getHdnAction() {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction) {
        hdnAction = newHdnAction;
    }

    public int getHdnEmpDtls() {
        return hdnEmpDtls;
    }

    public void setHdnEmpDtls(int newHdnEmpDtls) {
        hdnEmpDtls = newHdnEmpDtls;
    }

    public String getHdnEmpDesig() {
        return hdnEmpDesig;
    }

    public void setHdnEmpDesig(String newHdnEmpDesig) {
        hdnEmpDesig = newHdnEmpDesig;
    }

    public String getHdnEmpName() {
        return hdnEmpName;
    }

    public void setHdnEmpName(String newHdnEmpName) {
        hdnEmpName = newHdnEmpName;
    }

    public String getHdnEmpDept() {
        return hdnEmpDept;
    }

    public void setHdnEmpDept(String newHdnEmpDept) {
        hdnEmpDept = newHdnEmpDept;
    }

    public String getLoginLocCode()
    {
    return loginLocCode;  
    }
    
    public void setLoginLocCode(String newLoginLocCode)
    {
      loginLocCode=newLoginLocCode;
    }
    
    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String newUserStatus) {
        userStatus = newUserStatus;
    }
}
/*
 * Program Name : ChangePwdForm.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Action Form for the Change password screen
 *
*/


package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

import FCIPAY.COMMON.DATAACCESSTIER.VO.ChangePwdVO;

public class ChangePwdForm extends ActionForm  {
    private String txtOldPwd="";
    private String hdnAction="";
    private String txtNewPwd="";
    private String txtConfirmPwd="";

    private ChangePwdVO oChangePwdVO=null;
    private long hdnEmpNo;

   
    public String getTxtOldPwd() {
        return txtOldPwd;
    }

    public void setTxtOldPwd(String newTxtOldPwd) {
        txtOldPwd = newTxtOldPwd;
    }

    public String getHdnAction() {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction) {
        hdnAction = newHdnAction;
    }

    public String getTxtNewPwd() {
        return txtNewPwd;
    }

    public void setTxtNewPwd(String newTxtNewPwd) {
        txtNewPwd = newTxtNewPwd;
    }

    public String getTxtConfirmPwd() {
        return txtConfirmPwd;
    }

    public void setTxtConfirmPwd(String newTxtConfirmPwd) {
        txtConfirmPwd = newTxtConfirmPwd;
    }

    public ChangePwdVO createVO() {
        oChangePwdVO=new ChangePwdVO();
        oChangePwdVO.setTxtConfirmPwd(this.getTxtConfirmPwd());
        oChangePwdVO.setTxtNewPwd(this.getTxtNewPwd());
        return oChangePwdVO;
    }

    public long getHdnEmpNo() {
        return hdnEmpNo;
    }

    public void setHdnEmpNo(long newHdnEmpNo) {
        hdnEmpNo = newHdnEmpNo;
    }
}
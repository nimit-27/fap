package FCIPAY.COMMON.WEBTIER.Form;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import java.util.*;

import FCIPAY.COMMON.DATAACCESSTIER.VO.LoginVO;
import java.util.List;
import java.util.ArrayList;

public class LoginForm extends ActionForm 
{
    /**
    * Reset all properties to their default values.
    * @param mapping The ActionMapping used to select this instance.
    * @param request The HTTP Request we are processing.
    */
    private String txtUserId = "";
    private String txtPwd = "";
    private String lstLocCode = "";
    //private LoginVO oLoginVO = new LoginVO();
    
    private String hdnAction= "";
    private ArrayList locList=new ArrayList();
    private String actionValue="";
    private String screenName="";

/*    public void CreateVO()
    {
        oLoginVO.setTxtUserId(this.txtUserId);
        oLoginVO.setTxtPwd(this.txtPwd);
        oLoginVO.setLstLocCode(this.lstLocCode);
        return;
    }*/
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getScreenName() {
        return screenName;
    }
    public String getHdnAction()
    {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction)
    {
        hdnAction = newHdnAction;
    }

    public String getLstLocCode()
    {
        return lstLocCode;
    }

    public void setLstLocCode(String newLstLocCode)
    {
        lstLocCode = newLstLocCode;
    }

    public String getTxtPwd()
    {
        return txtPwd;
    }

    public void setTxtPwd(String newTxtPwd)
    {
        txtPwd = newTxtPwd;
    }

    public String getTxtUserId()
    {
        return txtUserId;
    }

    public void setTxtUserId(String newTxtUserId)
    {
        txtUserId = newTxtUserId;
    }

    public ArrayList getLocList() {
        return locList;
    }

    public void setLocList(ArrayList newLocList) {
        locList = newLocList;
    }

    public String getActionValue() {
        return actionValue;
    }

    public void setActionValue(String newActionValue) {
        actionValue = newActionValue;
    }
}
package FCIPAY.COMMON.DATAACCESSTIER.VO;

import FCIPAY.COMMON.WEBTIER.Form.LoginForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.util.*;
import java.util.ArrayList;

public class LoginVO 
{
    private String txtUserId = null;
    private String txtPwd = null;
    private String lstLocCode = null;

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
}
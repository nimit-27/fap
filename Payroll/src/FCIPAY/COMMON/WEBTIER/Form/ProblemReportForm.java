
/*
 * Program Name : ProblemReportForm.java
 * Author       : Jegan.V
 * Date Written : 24/05/2004
 * Description  : This is the Action Form which maps the values with the jsp page
 *
*/

package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class ProblemReportForm extends ActionForm 
{
    private String hdnAction="";
    private String txtScreenName="";
    private String txtArProblemDesc="";
    private String txtArCause="";

    public String getHdnAction()
    {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction)
    {
        hdnAction = newHdnAction;
    }

    public String getTxtScreenName()
    {
        return txtScreenName;
    }

    public void setTxtScreenName(String newTxtScreenName)
    {
        txtScreenName = newTxtScreenName;
    }

    public String getTxtArProblemDesc()
    {
        return txtArProblemDesc;
    }

    public void setTxtArProblemDesc(String newTxtArProblemDesc)
    {
        txtArProblemDesc = newTxtArProblemDesc;
    }

    public String getTxtArCause()
    {
        return txtArCause;
    }

    public void setTxtArCause(String newTxtArCause)
    {
        txtArCause = newTxtArCause;
    }
    
}
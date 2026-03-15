package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class HomePageForm extends ActionForm  {
    private String hdnAction="";
    private String hdnReportURL="";

    public String getHdnAction() {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction) {
        hdnAction = newHdnAction;
    }

    public String getHdnReportURL() {
        return hdnReportURL;
    }

    public void setHdnReportURL(String newHdnReportURL) {
        hdnReportURL = newHdnReportURL;
    }
}
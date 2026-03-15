/*
 * Program Name : UsrRespMapForm.java
 * Author       : Swapnendu Kumar Bastia
 * Date Written : 25/06/2013
 * Description  : This is the Action Form for jsp MaintainMasters\UserRespMapping.jsp
 *
*/

package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class UsrRespMapForm extends PayrollBaseForm
{
    private ArrayList locList=new ArrayList();
    private ArrayList lstInstrDtls=new ArrayList(); 
    private String txtUserCode;
    private String hdnAction;
    private String txtMapLoc;
    private String [] txtRespId;
    private String [] txtRespEndDt;
    
	public ArrayList getLstInstrDtls() {
		return lstInstrDtls;
	}
	public void setLstInstrDtls(ArrayList lstInstrDtls) {
		this.lstInstrDtls = lstInstrDtls;
	}    
    public String[] getTxtRespId() {
        return txtRespId;
    }
    public void setTxtRespId(String[] txtRespId) {
        this.txtRespId = txtRespId;
    }
    public String[] getTxtRespEndDt() {
        return txtRespEndDt;
    }
    public void setTxtRespEndDt(String[] txtRespEndDt) {
        this.txtRespEndDt = txtRespEndDt;
    }
    public ArrayList getLocList() {
        return locList;
    }
    public void setLocList(ArrayList newLocList) {
        locList = newLocList;
    }
	public String getTxtUserCode() {
		return txtUserCode;
	}
	public void setTxtUserCode(String txtUserCode) {
		this.txtUserCode = txtUserCode;
	}
	public String getHdnAction()
    {
        return hdnAction;
    }
    public void setHdnAction(String newHdnAction)
    {
        hdnAction = newHdnAction;
    }
	public String getTxtMapLoc() {
		return txtMapLoc;
	}

	public void setTxtMapLoc(String txtMapLoc) {
		this.txtMapLoc = txtMapLoc;
	}
}
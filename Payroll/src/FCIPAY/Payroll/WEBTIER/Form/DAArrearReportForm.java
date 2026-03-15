package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class DAArrearReportForm extends PayrollBaseForm
{
	private String txtYYMM;

	public DAArrearReportForm()
	{
	}

	public String getTxtYYMM()
	{
		return txtYYMM;
	}

	public void setTxtYYMM(String newTxtYYMM)
	{
		txtYYMM = newTxtYYMM;
	}
}
package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class ArrearCalcRepForm extends PayrollBaseForm
{
	private String txtYYMM;
	private String txtEmp;
	private String txtEmpName;  

	public ArrearCalcRepForm()
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

	public String getTxtEmp()
	{
		return txtEmp;
	}

	public void setTxtEmp(String newTxtEmp)
	{
		txtEmp = newTxtEmp;
	}

	public String getTxtEmpName()
	{
		return txtEmpName;
	}

	public void setTxtEmpName(String newTxtEmpName)
	{
		txtEmpName = newTxtEmpName;
	}
	
}
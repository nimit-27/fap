package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class MiscRecoveryRepForm extends PayrollBaseForm
{
	private String txtYYMM;
	private String txtEmp;
	private String txtEmpName;
  private String txtPayCode;
  private String txtPayCodeDesc;
  //added by himanshu on 20-Aug-2014
  private String txtCpfCode;
  
  public String getTxtCpfCode()
	{
		return txtCpfCode;
	}
    
    public void setTxtCpfCode(String newTxtCpfCode)
	{
		txtCpfCode = newTxtCpfCode;
	}
// end of addition by Himanshu
	public MiscRecoveryRepForm()
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

	public String getTxtPayCode()
	{
		return txtPayCode;
	}

	public void setTxtPayCode(String newTxtPayCode)
	{
		txtPayCode = newTxtPayCode;
	}

	public String getTxtPayCodeDesc()
	{
		return txtPayCodeDesc;
	}

	public void setTxtPayCodeDesc(String newTxtPayCodeDesc)
	{
		txtPayCodeDesc = newTxtPayCodeDesc;
	}

}
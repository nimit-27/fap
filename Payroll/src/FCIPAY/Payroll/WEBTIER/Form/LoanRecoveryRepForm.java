package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class LoanRecoveryRepForm extends PayrollBaseForm
{
	private String txtFromYYMM;
	private String txtEmp;
	private String txtEmpName;
	private String txtToYYMM;
  private String txtPayCode;
  private String txtPayCodeDesc;
  private String txtCpfCode;                               //by dushyant on 18-08-2010

	public LoanRecoveryRepForm()
	{
	}

	public String getTxtFromYYMM()
	{
		return txtFromYYMM;
	}

	public void setTxtFromYYMM(String newTxtFromYYMM)
	{
		txtFromYYMM = newTxtFromYYMM;
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

	public String getTxtToYYMM()
	{
		return txtToYYMM;
	}

	public void setTxtToYYMM(String newTxtToYYMM)
	{
		txtToYYMM = newTxtToYYMM;
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
  

                                  // added by dushyant 0n 18-082010  
  public String getTxtCpfCode()
  {
   return txtCpfCode;
  }
  public void setTxtCpfCode(String newTxtCpfCode)
  {
     txtCpfCode = newTxtCpfCode;
  }
                                  // end by dushyant 0n 18-08-2010            

}
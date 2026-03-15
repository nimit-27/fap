package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class SCRRepForm extends PayrollBaseForm
{
	private String txtFromYYMM;
	private String txtEmp;
	private String txtEmpName;
  private String txtCpfCode;                      //     <!--added by dushyant on 20-08-2010-->
	private String txtToYYMM;
  private String txtCtgry;

	public SCRRepForm()
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


                                    // <!--added by dushyant on 20-08-2010-->
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }


                                    // <!--added by dushyant on 20-08-2010-->
	public String getTxtToYYMM()
	{
		return txtToYYMM;
	}

	public void setTxtToYYMM(String newTxtToYYMM)
	{
		txtToYYMM = newTxtToYYMM;
	}
  
	public String getTxtCtgry()
	{
		return txtCtgry;
	}

	public void setTxtCtgry(String newTxtCtgry)
	{
		txtCtgry = newTxtCtgry;
	}

}
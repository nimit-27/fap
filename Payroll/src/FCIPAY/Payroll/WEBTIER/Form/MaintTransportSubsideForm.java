package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;



public class MaintTransportSubsideForm extends PayrollBaseForm
{
  
  ArrayList lstInstrDtls = new ArrayList();
  
  private String txtEmpNo;
  private String txtEmpName;
  private String txtFinYear;
  private String txtCpfCode;
  private String txtAmtHdr;
  private String [] txtMonth;
  private String [] txtYYMM = null;
  private String [] txtAmt = null;

 public MaintTransportSubsideForm()
  {
  }
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String[] getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String[] newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String[] getTxtAmt()
  {
    return txtAmt;
  }

  public void setTxtAmt(String[] newTxtAmt)
  {
    txtAmt = newTxtAmt;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtFinYear()
  {
    return txtFinYear;
  }

  public void setTxtFinYear(String newTxtFinYear)
  {
    txtFinYear = newTxtFinYear;
  }


  public String[] getTxtMonth()
  {
    return txtMonth;
  }

  public void setTxtMonth(String[] newTxtMonth)
  {
    txtMonth = newTxtMonth;
  }
  
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
  public String getTxtAmtHdr()
  {
    return txtAmtHdr;
  }
  public void setTxtAmtHdr(String newTxtAmtHdr)
  {
    txtAmtHdr = newTxtAmtHdr;
  }
}
package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class PFSummaryRepForm extends PayrollBaseForm 
{
  private String txtYYMM;
  private String txtPFType;

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getTxtPFType()
  {
    return txtPFType;
  }

  public void setTxtPFType(String newTxtPFType)
  {
    txtPFType = newTxtPFType;
  }


  
}
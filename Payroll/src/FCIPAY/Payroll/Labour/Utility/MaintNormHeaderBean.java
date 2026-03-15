package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintNormHeaderBean extends PayrollBaseHeaderBean
{
    private String txtEffDate;
    private String txtMou;
    private String txtNormTyp;

  public MaintNormHeaderBean()
  {
  }

   public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }

  public String getTxtMou()
  {
    return txtMou;
  }

  public void setTxtMou(String newTxtMou)
  {
    txtMou = newTxtMou;
  }

  public String getTxtNormTyp()
  {
    return txtNormTyp;
  }

  public void setTxtNormTyp(String newTxtNormTyp)
  {
    txtNormTyp = newTxtNormTyp;
  }

}
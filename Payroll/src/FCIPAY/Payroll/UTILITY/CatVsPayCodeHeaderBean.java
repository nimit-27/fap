package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;


public class CatVsPayCodeHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtCategory;

  public CatVsPayCodeHeaderBean()
  {
  }

  public String getTxtCategory()
  {
    return txtCategory;
  }

  public void setTxtCategory(String newTxtCategory)
  {
    txtCategory = newTxtCategory;
  }



 

}
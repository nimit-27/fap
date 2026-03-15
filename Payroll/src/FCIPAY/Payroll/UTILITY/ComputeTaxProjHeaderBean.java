package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;


public class ComputeTaxProjHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String optSelectAllEmp;
  private String txtEmp;
  private String hdnMaxRebFlag;

  public ComputeTaxProjHeaderBean()
  {
  }

  public String getOptSelectAllEmp()
  {
    return optSelectAllEmp;
  }

  public void setOptSelectAllEmp(String newOptSelectAllEmp)
  {
    optSelectAllEmp = newOptSelectAllEmp;
  }



  public String getTxtEmp()
  {
    return txtEmp;
  }

  public void setTxtEmp(String newTxtEmp)
  {
    txtEmp = newTxtEmp;
  }

  public String getHdnMaxRebFlag()
  {
    return hdnMaxRebFlag;
  }

  public void setHdnMaxRebFlag(String newHdnMaxRebFlag)
  {
    hdnMaxRebFlag = newHdnMaxRebFlag;
  }


}
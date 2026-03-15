package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MiscellaneousParamDtlUpgradeBean  extends PayrollBaseDetailBean implements Serializable 
{
  private String txtUpgradeAllow;
  private String txtUpgradeSrl;
  private String txtCateg;
  private String txtPayScale;

  public MiscellaneousParamDtlUpgradeBean()
  {
  }

  public String getTxtUpgradeAllow()
  {
    return txtUpgradeAllow;
  }

  public void setTxtUpgradeAllow(String newTxtUpgradeAllow)
  {
    txtUpgradeAllow = newTxtUpgradeAllow;
  }

  public String getTxtUpgradeSrl()
  {
    return txtUpgradeSrl;
  }

  public void setTxtUpgradeSrl(String newTxtUpgradeSrl)
  {
    txtUpgradeSrl = newTxtUpgradeSrl;
  }

  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }





  public String getTxtPayScale()
  {
    return txtPayScale;
  }

  public void setTxtPayScale(String newTxtPayScale)
  {
    txtPayScale = newTxtPayScale;
  }


}
package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class ComBonusAwardsHeaderBean extends PayrollBaseHeaderBean implements Serializable
{
  private String optSelect;
  private String txtEmpName;
  private String txtBonDays;
  private String txtAwdDays;
  private String txtMaxAwdAmt;
  private String txtYYMM;
  private String txtMaxEmolAmt;
  private String optVal;
  private String txtEmpNum;
  private String txtSrlNo;
  private String txtBonAwdFlag;

  public ComBonusAwardsHeaderBean()
  {
  }

  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtBonDays()
  {
    return txtBonDays;
  }

  public void setTxtBonDays(String newTxtBonDays)
  {
    txtBonDays = newTxtBonDays;
  }

  public String getTxtAwdDays()
  {
    return txtAwdDays;
  }

  public void setTxtAwdDays(String newTxtAwdDays)
  {
    txtAwdDays = newTxtAwdDays;
  }

  public String getTxtMaxAwdAmt()
  {
    return txtMaxAwdAmt;
  }

  public void setTxtMaxAwdAmt(String newTxtMaxAwdAmt)
  {
    txtMaxAwdAmt = newTxtMaxAwdAmt;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getTxtMaxEmolAmt()
  {
    return txtMaxEmolAmt;
  }

  public void setTxtMaxEmolAmt(String newTxtMaxEmolAmt)
  {
    txtMaxEmolAmt = newTxtMaxEmolAmt;
  }

  public String getOptVal()
  {
    return optVal;
  }

  public void setOptVal(String newOptVal)
  {
    optVal = newOptVal;
  }

  public String getTxtEmpNum()
  {
    return txtEmpNum;
  }

  public void setTxtEmpNum(String newTxtEmpNum)
  {
    txtEmpNum = newTxtEmpNum;
  }

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getTxtBonAwdFlag()
  {
    return txtBonAwdFlag;
  }

  public void setTxtBonAwdFlag(String newTxtBonAwdFlag)
  {
    txtBonAwdFlag = newTxtBonAwdFlag;
  }
}
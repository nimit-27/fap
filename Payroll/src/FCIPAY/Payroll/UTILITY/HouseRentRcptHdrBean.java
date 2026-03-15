package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;
public class HouseRentRcptHdrBean extends PayrollBaseHeaderBean implements Serializable  
{
  String txtEmpName;
  String txtEmpNo;
  private String txtFinYYMM;
  private String txtRentAmt;
  private boolean screenModeFlag;

  public HouseRentRcptHdrBean()
  {
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtFinYYMM()
  {
    return txtFinYYMM;
  }

  public void setTxtFinYYMM(String newTxtFinYYMM)
  {
    txtFinYYMM = newTxtFinYYMM;
  }
  
  public String getTxtRentAmt()
  {
    return txtRentAmt;
  }

  public void setTxtRentAmt(String newTxtRentAmt)
  {
    txtRentAmt = newTxtRentAmt;
  }

  public boolean isScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(boolean newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  }

}
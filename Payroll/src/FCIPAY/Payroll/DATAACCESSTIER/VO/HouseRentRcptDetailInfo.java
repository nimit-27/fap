package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class HouseRentRcptDetailInfo extends BaseDetailInfo implements Serializable
{

  private String txtEmpNo;
  private String txtFinYYMM;
  private boolean screenModeFlag;
  private String txtRentAmt;

  public HouseRentRcptDetailInfo()
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

  public String getTxtFinYYMM()
  {
    return txtFinYYMM;
  }

  public void setTxtFinYYMM(String newTxtFinYYMM)
  {
    txtFinYYMM = newTxtFinYYMM;
  }

  public boolean isScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(boolean newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  }

  public String getTxtRentAmt()
  {
    return txtRentAmt;
  }

  public void setTxtRentAmt(String newTxtRentAmt)
  {
    txtRentAmt = newTxtRentAmt;
  }

}
package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class MaintHouseRentRcptVO  extends PayrollBaseQueryVO implements Serializable 
{
  String txtEmpNo;
  private String txtFinYYMM;

  public MaintHouseRentRcptVO()
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
}
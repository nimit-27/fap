package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class EnqPayImageDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtEmpNo;
  private String txtYtm;

  public EnqPayImageDetailInfo()
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

  public String getTxtYtm()
  {
    return txtYtm;
  }

  public void setTxtYtm(String newTxtYtm)
  {
    txtYtm = newTxtYtm;
  }
}
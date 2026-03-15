package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class PayHistDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtPayHead;
  private String txtEmpNo;

  public PayHistDetailInfo()
  {
  }

  public String getTxtPayHead()
  {
    return txtPayHead;
  }

  public void setTxtPayHead(String newTxtPayHead)
  {
    txtPayHead = newTxtPayHead;
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }
}
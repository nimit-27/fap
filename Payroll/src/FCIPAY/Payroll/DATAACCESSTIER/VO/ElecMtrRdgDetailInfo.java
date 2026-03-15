package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class ElecMtrRdgDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtEmpNo;
  private String txtMtrNo;
  private String txtFreq;

  public ElecMtrRdgDetailInfo()
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

  public String getTxtMtrNo()
  {
    return txtMtrNo;
  }

  public void setTxtMtrNo(String newTxtMtrNo)
  {
    txtMtrNo = newTxtMtrNo;
  }

  public String getTxtFreq()
  {
    return txtFreq;
  }

  public void setTxtFreq(String newTxtFreq)
  {
    txtFreq = newTxtFreq;
  }
}
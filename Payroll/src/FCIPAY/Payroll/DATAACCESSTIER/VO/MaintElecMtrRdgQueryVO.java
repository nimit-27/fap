package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class MaintElecMtrRdgQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String txtEmpName;
  private String txtMtrNo;
  private String txtFreq;

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
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
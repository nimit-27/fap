package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

public class MaintBankMastQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtBankCode;

  public MaintBankMastQueryVO()
  {
  }

  public String getTxtBankCode()
  {
    return txtBankCode;
  }

  public void setTxtBankCode(String newTxtBankCode)
  {
    txtBankCode = newTxtBankCode;
  }
  
}
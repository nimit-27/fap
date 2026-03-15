package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class BankMastDetailInfo extends BaseDetailInfo implements Serializable
{

  private String txtBankCode;

  public BankMastDetailInfo()
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
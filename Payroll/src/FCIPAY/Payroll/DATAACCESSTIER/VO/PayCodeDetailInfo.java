package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class PayCodeDetailInfo extends BaseDetailInfo implements Serializable
{

  private String txtFromPayCode;
  private String txtToPayCode;
  
  public PayCodeDetailInfo()
  {
  }

  public String getTxtFromPayCode()
  {
    return txtFromPayCode;
  }

  public void setTxtFromPayCode(String newTxtFromPayCode)
  {
    txtFromPayCode = newTxtFromPayCode;
  }
  
  public String getTxtToPayCode()
  {
    return txtToPayCode;
  }

  public void setTxtToPayCode(String newTxtToPayCode)
  {
    txtToPayCode = newTxtToPayCode;
  }
}
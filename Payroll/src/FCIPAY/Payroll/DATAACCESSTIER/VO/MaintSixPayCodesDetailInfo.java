package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class MaintSixPayCodesDetailInfo extends BaseDetailInfo implements Serializable
{

  private String txtPayCode1;

  public MaintSixPayCodesDetailInfo()
  {
  }
 
  public String getTxtPayCode1()
  {
    return txtPayCode1;
  }

  public void setTxtPayCode1(String newTxtPayCode1)
  {
    txtPayCode1 = newTxtPayCode1;
  }  

}
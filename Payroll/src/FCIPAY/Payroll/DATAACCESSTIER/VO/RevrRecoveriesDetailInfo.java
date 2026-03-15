package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class RevrRecoveriesDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtpayYYMM;
  
  public RevrRecoveriesDetailInfo()
  {
  }

  public String getTxtpayYYMM()
  {
    return txtpayYYMM;
  }

  public void setTxtpayYYMM(String newTxtpayYYMM)
  {
    txtpayYYMM = newTxtpayYYMM;
  }
  

}
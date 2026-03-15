package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;


public class GenRevrRecoveriesQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtpayYYMM;
  
  public GenRevrRecoveriesQueryVO()
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
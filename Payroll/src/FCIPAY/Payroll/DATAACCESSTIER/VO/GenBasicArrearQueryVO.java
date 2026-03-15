package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;


public class GenBasicArrearQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtpayYYMM;
  
  public GenBasicArrearQueryVO()
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
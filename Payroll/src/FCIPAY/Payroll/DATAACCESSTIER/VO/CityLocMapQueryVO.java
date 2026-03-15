package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class CityLocMapQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtLocidSrch;

  public CityLocMapQueryVO()
  {
  }

  public String getTxtLocidSrch()
  {
    return txtLocidSrch;
  }

  public void setTxtLocidSrch(String newTxtLocidSrch)
  {
    txtLocidSrch = newTxtLocidSrch;
  }
}
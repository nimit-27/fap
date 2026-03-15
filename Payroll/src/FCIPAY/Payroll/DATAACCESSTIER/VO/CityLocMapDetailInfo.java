package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class CityLocMapDetailInfo extends BaseDetailInfo implements Serializable 
{
  private String txtLocidSrch;;
    
      
  public CityLocMapDetailInfo()
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
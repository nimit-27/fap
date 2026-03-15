package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class MaintainCCARatesQueryVO 
{
  private String txtCity[] = null;

  public MaintainCCARatesQueryVO()
  {
  }

  public String[] getTxtCity()
  {
    return txtCity;
  }

  public void setTxtCity(String[] newTxtCity)
  {
    txtCity = newTxtCity;
  }

}
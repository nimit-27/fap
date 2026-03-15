package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class EditPayImgComboVO extends PayrollBaseQueryVO implements Serializable
{  
  private ArrayList valYrMnth;

  public EditPayImgComboVO()
  {
  }  
  public ArrayList getValueYrMnth()
  {
    return valYrMnth;
  }

  public void setValYrMnth(ArrayList newValYrMnth)
  {
    valYrMnth = newValYrMnth;
  }
 
}
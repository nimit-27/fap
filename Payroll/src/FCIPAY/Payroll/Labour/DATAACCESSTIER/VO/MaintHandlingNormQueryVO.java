package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;

public class MaintHandlingNormQueryVO extends PayrollBaseQueryVO implements Serializable 
{
    private String txtMou;
    private String txtEffDate;
  
    public MaintHandlingNormQueryVO()
    {
    }

    public String getTxtMou()
    {
      return txtMou;
    }
    
    public void setTxtMou(String newTxtMou)
    {
      txtMou=newTxtMou;
    }
    
    public String getTxtEffDate()
    {
      return txtEffDate;
    }
    
    public void setTxtEffDate(String newTxtEffDate)
    {
      txtEffDate=newTxtEffDate;
    }
    
}
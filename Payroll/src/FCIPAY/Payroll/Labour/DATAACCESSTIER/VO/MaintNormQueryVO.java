package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;

public class MaintNormQueryVO extends PayrollBaseQueryVO implements Serializable 
{
    private String txtMou;
    private String txtEffDate;
    private String txtNormTyp;
  
    public MaintNormQueryVO()
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

    public String getTxtNormTyp()
    {
      return txtNormTyp;
    }
    
    public void setTxtNormTyp(String newTxtNormTyp)
    {
      txtNormTyp=newTxtNormTyp;
    }
    
}
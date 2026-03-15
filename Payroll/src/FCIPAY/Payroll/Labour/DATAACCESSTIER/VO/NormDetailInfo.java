package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;



public class NormDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtEffDate;
  private String txtNormTyp;
  private String txtMou; 
  
  public NormDetailInfo()
  {
  }

  public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }
  
   public String getTxtMou()
  {
    return txtMou;
  }

  public void setTxtMou(String newTxtMou)
  {
    txtMou = newTxtMou;
  }

   public String getTxtNormTyp()
  {
    return txtNormTyp;
  }

  public void setTxtNormTyp(String newTxtNormTyp)
  {
    txtNormTyp = newTxtNormTyp;
  }
 
}
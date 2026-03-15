package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class DPSOTARatesDetailInfo extends BaseDetailInfo implements Serializable
{  
  public String txtYYMM;
  private String txtLocId="";
  
  public DPSOTARatesDetailInfo()
  {
  }
  
  public String getTxtLocId()
  {
    return txtLocId;
  }
  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
  }
  
  public String getTxtYYMM()
  {
    return txtYYMM;
  }
  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }  
}
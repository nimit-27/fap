package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class DPSOTARatesQueryVO extends PayrollBaseQueryVO implements Serializable
{
  public String txtYYMM;
  private String txtLocId="";

  public DPSOTARatesQueryVO()
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
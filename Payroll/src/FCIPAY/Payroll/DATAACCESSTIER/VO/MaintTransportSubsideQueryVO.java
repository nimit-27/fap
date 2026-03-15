package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class MaintTransportSubsideQueryVO  extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String txtFinYear;
  
  public MaintTransportSubsideQueryVO()
  {
  }
  
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  } 
  
  public String getTxtFinYear()
  {
    return txtFinYear;
  }

  public void setTxtFinYear(String newTxtFinYear)
  {
    txtFinYear = newTxtFinYear;
  }
  
}
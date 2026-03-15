package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class MaintAnnIncQueryVO extends PayrollBaseQueryVO implements Serializable 
{
  private String txtEmpNo;
  private String txtFinYYMM;

  public MaintAnnIncQueryVO()
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

  public String getTxtFinYYMM()
  {
    return txtFinYYMM;
  }

  public void setTxtFinYYMM(String newTxtFinYYMM)
  {
    txtFinYYMM = newTxtFinYYMM;
  }
}
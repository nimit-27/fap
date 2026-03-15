package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class CPFStopQueryVO  extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String cpfFlag;
  
  public CPFStopQueryVO()
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
 
  public String getCpfFlag()
  {
    return cpfFlag;
  }

  public void setCpfFlag(String newCpfFlag)
  {
    cpfFlag = newCpfFlag;
  }
   
}
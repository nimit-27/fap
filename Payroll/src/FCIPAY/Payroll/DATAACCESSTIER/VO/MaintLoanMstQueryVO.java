package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class MaintLoanMstQueryVO extends PayrollBaseQueryVO implements Serializable 
{
  private String txtEmpNo;
  private String txtLoanType;

  public MaintLoanMstQueryVO()
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

  public String getTxtLoanType()
  {
    return txtLoanType;
  }

  public void setTxtLoanType(String newTxtLoanType)
  {
    txtLoanType = newTxtLoanType;
  }
}
package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class EmplyrTaxQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String txtFinYr;

  public EmplyrTaxQueryVO()
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

  public String getTxtFinYr()
  {
    return txtFinYr;
  }

  public void setTxtFinYr(String newTxtFinYr)
  {
    txtFinYr = newTxtFinYr;
  }
}
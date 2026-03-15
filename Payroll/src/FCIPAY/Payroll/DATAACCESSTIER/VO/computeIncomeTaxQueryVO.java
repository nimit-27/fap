package FCIPAY.Payroll.DATAACCESSTIER.VO;
import  FCIPAY.Payroll.common.vo.BaseQueryVO; 
import java.io.Serializable;

public class computeIncomeTaxQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmp;
  private String optSelectAllEmp;
  private String optSelectAllEmpVal;

  public computeIncomeTaxQueryVO()
  {
  }

  public String getTxtEmp()
  {
    return txtEmp;
  }

  public void setTxtEmp(String newTxtEmp)
  {
    txtEmp = newTxtEmp;
  }

  public String getOptSelectAllEmp()
  {
    return optSelectAllEmp;
  }

  public void setOptSelectAllEmp(String newOptSelectAllEmp)
  {
    optSelectAllEmp = newOptSelectAllEmp;
  }

  public String getOptSelectAllEmpVal()
  {
    return optSelectAllEmpVal;
  }

  public void setOptSelectAllEmpVal(String newOptSelectAllEmpVal)
  {
    optSelectAllEmpVal = newOptSelectAllEmpVal;
  }
}
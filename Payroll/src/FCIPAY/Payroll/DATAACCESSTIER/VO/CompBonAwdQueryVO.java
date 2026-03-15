package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

public class CompBonAwdQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtYYMM;
  private String optSelect;
  private String optVal;
  private String txtEmpNum;

  public CompBonAwdQueryVO()
  {
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }

  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
  }

  public String getOptVal()
  {
    return optVal;
  }

  public void setOptVal(String newOptVal)
  {
    optVal = newOptVal;
  }

  public String getTxtEmpNum()
  {
    return txtEmpNum;
  }

  public void setTxtEmpNum(String newTxtEmpNum)
  {
    txtEmpNum = newTxtEmpNum;
  }
}
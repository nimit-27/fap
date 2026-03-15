package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class StdDednQueryVO extends PayrollBaseQueryVO implements Serializable
{

  private String txtStdDednYYMM;

  public StdDednQueryVO()
  {
  }

  public String getTxtStdDednYYMM()
  {
    return txtStdDednYYMM;
  }

  public void setTxtStdDednYYMM(String newTxtStdDednYYMM)
  {
    txtStdDednYYMM = newTxtStdDednYYMM;
  }

}
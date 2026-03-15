package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;

public class AdhocPayQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtPayYYMM;
  private String txtPayCode;

  public AdhocPayQueryVO()
  {
  }

  public String getTxtPayYYMM()
  {
    return txtPayYYMM;
  }

  public void setTxtPayYYMM(String newTxtPayYYMM)
  {
    txtPayYYMM = newTxtPayYYMM;
  }

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }
}
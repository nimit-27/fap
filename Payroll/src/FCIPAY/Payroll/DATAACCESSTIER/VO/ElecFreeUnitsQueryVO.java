package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class ElecFreeUnitsQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtGradeCode;
  private String txtRevYYMM;
  private String txtRevYear;

  public ElecFreeUnitsQueryVO()
  {
  }
  public String getRevYYMM()
  {
    return txtRevYYMM;
  }
  public void setTxtRevYYMM(String newTxtRevYYMM)
  {
    txtRevYYMM=newTxtRevYYMM;
  }
  public String getTxtGradeCode()
  {
    return txtGradeCode;
  }

  public void setTxtGradeCode(String newTxtGradeCode)
  {
    txtGradeCode = newTxtGradeCode;
  }

  public String getTxtRevYear()
  {
    return txtRevYear;
  }

  public void setTxtRevYear(String newTxtRevYear)
  {
    txtRevYear = newTxtRevYear;
  }
}
package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class ElecFreeUnitsHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtGradeCode;
  private String screenModeElecFreeUnits;
  private String txtGradeDesc;
  public String txtRevYYMM;
  private String txtRevYear;

  public ElecFreeUnitsHeaderBean()
  {
  }

  public String getTxtGradeCode()
  {
    return txtGradeCode;
  }

  public void setTxtGradeCode(String newTxtGradeCode)
  {
    txtGradeCode = newTxtGradeCode;
  }

  public String getScreenModeElecFreeUnits()
  {
    return screenModeElecFreeUnits;
  }

  public void setScreenModeElecFreeUnits(String newscreenModeElecFreeUnits)
  {
    screenModeElecFreeUnits = newscreenModeElecFreeUnits;
  }

  public String getTxtGradeDesc()
  {
    return txtGradeDesc;
  }

  public void setTxtGradeDesc(String newTxtGradeDesc)
  {
    txtGradeDesc = newTxtGradeDesc;
  }

  public String getRevYYMM()
  {
    return txtRevYYMM;
  }

  public void setRevYYMM(String newRevYYMM)
  {
    txtRevYYMM = newRevYYMM;
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
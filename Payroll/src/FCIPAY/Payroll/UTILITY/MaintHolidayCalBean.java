package FCIPAY.Payroll.UTILITY;

public class MaintHolidayCalBean extends PayrollBaseDetailBean 
{
  private String txtHolidayCode;
  private String txtHolidayName;
  private String txtHolidayDt;
  
  public MaintHolidayCalBean()
  {
  }
  
  public String getTxtHolidayCode()
  {
    return txtHolidayCode;
  }

  public void setTxtHolidayCode(String newTxtHolidayCode)
  {
    txtHolidayCode = newTxtHolidayCode;
  }

  public String getTxtHolidayName()
  {
    return txtHolidayName;
  }

  public void setTxtHolidayName(String newTxtHolidayName)
  {
    txtHolidayName = newTxtHolidayName;
  }

  public String getTxtHolidayDt()
  {
    return txtHolidayDt;
  }

  public void setTxtHolidayDt(String newTxtHolidayDt)
  {
    txtHolidayDt = newTxtHolidayDt;
  }

}
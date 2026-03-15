package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;

public class MaintHolidayCalForm extends PayrollBaseForm 
{
  private String txtLocId;
  private String txtYr;
  private String txtWklyOff1;
  private String txtWklyOff2;
  private String [] txtHolidayCode;
  private String [] txtHolidayName;
  private String [] txtHolidayDt;
  private ArrayList lstInstrDtls=new ArrayList();

  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
  }

  public String getTxtYr()
  {
    return txtYr;
  }

  public void setTxtYr(String newTxtYr)
  {
    txtYr = newTxtYr;
  }

  public String getTxtWklyOff1()
  {
    return txtWklyOff1;
  }

  public void setTxtWklyOff1(String newTxtWklyOff1)
  {
    txtWklyOff1 = newTxtWklyOff1;
  }

  public String getTxtWklyOff2()
  {
    return txtWklyOff2;
  }

  public void setTxtWklyOff2(String newTxtWklyOff2)
  {
    txtWklyOff2 = newTxtWklyOff2;
  }

  public String[] getTxtHolidayCode()
  {
    return txtHolidayCode;
  }

  public void setTxtHolidayCode(String [] newTxtHolidayCode)
  {
    txtHolidayCode = newTxtHolidayCode;
  }

  public String [] getTxtHolidayName()
  {
    return txtHolidayName;
  }

  public void setTxtHolidayName(String [] newTxtHolidayName)
  {
    txtHolidayName = newTxtHolidayName;
  }

  public String [] getTxtHolidayDt()
  {
    return txtHolidayDt;
  }

  public void setTxtHolidayDt(String [] newTxtHolidayDt)
  {
    txtHolidayDt = newTxtHolidayDt;
  }

  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }

}
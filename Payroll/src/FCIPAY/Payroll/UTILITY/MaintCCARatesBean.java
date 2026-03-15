package FCIPAY.Payroll.UTILITY;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
import java.io.Serializable;

public class MaintCCARatesBean  extends PayrollBaseDetailBean implements Serializable
{

  private String txtSrlNo="";
  private String txtAllow="";
  private String startField;
  private String endField;
  private String txtStartDate;
  private String txtCtgry;  
  private String txtEndDate;
  
  public MaintCCARatesBean()
  {
  }

  
 public MaintCCARatesBean(String amtfrom,String amtto,String allow,String sSrlNo)
  {
      startField=amtfrom;
      endField=amtto;
      txtAllow=allow;
      txtSrlNo = sSrlNo;
  }

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }



  public String getTxtAllow()
  {
    return txtAllow;
  }

  public void setTxtAllow(String newTxtAllow)
  {
    txtAllow = newTxtAllow;
  }

  public String getStartField()
  {
    return startField;
  }

  public void setStartField(String newStartField)
  {
    startField = newStartField;
  }

  public String getEndField()
  {
    return endField;
  }

  public void setEndField(String newEndField)
  {
    endField = newEndField;
  }

  public String getTxtStartDate()
  {
    return txtStartDate;
  }

  public void setTxtStartDate(String newTxtStartDate)
  {
    txtStartDate = newTxtStartDate;
  }
  
  public String getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  }
  
  public String getTxtCtgry()
  {
    return txtCtgry;
  }

  public void setTxtCtgry(String newTxtCtgry)
  {
    txtCtgry = newTxtCtgry;
  }
}
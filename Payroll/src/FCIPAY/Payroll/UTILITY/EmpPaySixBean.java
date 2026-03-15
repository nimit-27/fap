package FCIPAY.Payroll.UTILITY;

public class EmpPaySixBean  extends PayrollBaseDetailBean
{
  private String  txtPayCode;
  private String  txtPayDesc;
  private String  txtPrcntage;
  private String  txtPayMode;

  public EmpPaySixBean()
  {
  }
  
  public String getTxtPayCode()
  {
    return txtPayCode;
  }
  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode=newTxtPayCode;
  }

  public String getTxtPayDesc()
  {
    return txtPayDesc;
  }

  public void setTxtPayDesc(String newTxtPayDesc)
  {
    txtPayDesc=newTxtPayDesc;
  }

  public String getTxtPrcntage()
  {
    return txtPrcntage;
  }
  public void setTxtPrcntage(String newTxtPrcntage)
  {
    txtPrcntage=newTxtPrcntage;
  }

  public String getTxtPayMode()
  {
    return txtPayMode;
  }
  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode=newTxtPayMode;
  }

}
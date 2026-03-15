package FCIPAY.Payroll.UTILITY;

public class OTAPymntBean extends PayrollBaseDetailBean
{
  private String txtOTARate;
  private String txtEmolument;
  private String txtOTAHrs;
  private String txtPayCode="";
  private String txtDesc="";
  private String txtAmt="";
  

  public OTAPymntBean()
  {
  }
  
  public String getTxtOTARate()
  {
    return txtOTARate;
  }

  public void setTxtOTARate(String newTxtOTARate)
  {
    txtOTARate = newTxtOTARate;
  }

   public String getTxtEmolument()
  {
    return txtEmolument;
  }

  public void setTxtEmolument(String newTxtEmolument)
  {
    txtEmolument = newTxtEmolument;
  }
  
   public String getTxtOTAHrs()
  {
    return txtOTAHrs;
  }

  public void setTxtOTAHrs(String newTxtOTAHrs)
  {
    txtOTAHrs = newTxtOTAHrs;
  }
  
  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtDesc()
  {
    return txtDesc;
  }

  public void setTxtDesc(String newTxtDesc)
  {
    txtDesc = newTxtDesc;
  }

  public String getTxtAmt()
  {
    return txtAmt;
  }

  public void setTxtAmt(String newTxtAmt)
  {
    txtAmt = newTxtAmt;
  }

}
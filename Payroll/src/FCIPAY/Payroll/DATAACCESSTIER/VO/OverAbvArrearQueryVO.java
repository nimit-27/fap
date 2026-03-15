package FCIPAY.Payroll.DATAACCESSTIER.VO;

public class OverAbvArrearQueryVO extends PayrollBaseQueryVO 
{
  private String txtEmpNo;
  private String txtPayCode;
  private String txtPayYYMM;
  private String hdnPayYYMM;
  private String txtDedIT;
  private String txtStartYr;
  private String txtEndYr;
  public OverAbvArrearQueryVO()
  {
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtPayYYMM()
  {
    return txtPayYYMM;
  }

  public void setTxtPayYYMM(String newTxtPayYYMM)
  {
    txtPayYYMM = newTxtPayYYMM;
  }
  
   public String getHdnPayYYMM()
  {
    return hdnPayYYMM;
  }

  public void setHdnPayYYMM(String newHdnPayYYMM)
  {
    hdnPayYYMM = newHdnPayYYMM;
  }
  
  
  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }  
  
  public String getTxtDedIT()
  {
    return txtDedIT;
  }

  public void setTxtDedIT(String newTxtDedIT)
  {
    txtDedIT = newTxtDedIT;
  }  
   public String getTxtStartYr()
  {
    return txtStartYr;
  }

 public String getTxtEndYr()
  {
    return txtEndYr;
  }

  public void setTxtStartYr(String newTxtStartYr)
  {
    txtStartYr = newTxtStartYr;
  }
  public void setTxtEndYr(String newTxtEndYr)
  {
    txtEndYr = newTxtEndYr;
  }

}
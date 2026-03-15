package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class OverAbvArrearHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{  
  private String txtEmpNo;
  private String txtEmpName;
  private String txtArrAmt;
  private String txtInvID;
  private String txtPayCode;
  private String txtDedIT;
  private String txtDedCPF;
  private String hdnPayYYMM;
  private String txtStartYr;
  private String txtEndYr;
  
  public OverAbvArrearHeaderBean()
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

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtArrAmt()
  {
    return txtArrAmt;
  }

  public void setTxtArrAmt(String newTxtArrAmt)
  {
    txtArrAmt = newTxtArrAmt;
  }

  public String getTxtInvID()
  {
    return txtInvID;
  }

  public void setTxtInvID(String newTxtInvID)
  {
    txtInvID = newTxtInvID;
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

  public String getTxtDedCPF()
  {
    return txtDedCPF;
  }

  public void setTxtDedCPF(String newTxtDedCPF)
  {
    txtDedCPF = newTxtDedCPF;
  }

  public String getHdnPayYYMM()
  {
    return hdnPayYYMM;
  }

  public void setHdnPayYYMM(String newHdnPayYYMM)
  {
    hdnPayYYMM = newHdnPayYYMM;
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
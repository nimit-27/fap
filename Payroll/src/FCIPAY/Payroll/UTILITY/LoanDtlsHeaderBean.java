package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class LoanDtlsHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtEmpNo;
  private String txtEmpName;
  private String txtDsgn;
  private String txtCateg;
  private String txtPresentPOP;
  private String hdnHeaderFlag;

  public LoanDtlsHeaderBean()
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
  
  public String getTxtDsgn()
  {
    return txtDsgn;
  }
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }

  public String getHdnHeaderFlag()
  {
    return hdnHeaderFlag;
  }

  public void setHdnHeaderFlag(String newHdnHeaderFlag)
  {
    hdnHeaderFlag = newHdnHeaderFlag;
  }
}
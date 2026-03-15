package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class GenDAArrearHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  private String txtPayYYMM;
  private String txtStYYMM;
  private String txtEndYYMM;
  private String txtDAType;
  private String payrollFlag;
  
  public GenDAArrearHeaderBean()
  {
  }

  public String getTxtPayYYMM()
  {
    return txtPayYYMM;
  }

  public void setTxtPayYYMM(String newTxtPayYYMM)
  {
    txtPayYYMM = newTxtPayYYMM;
  }

  public String getTxtStYYMM()
  {
    return txtStYYMM;
  }

  public void setTxtStYYMM(String newTxtStYYMM)
  {
    txtStYYMM = newTxtStYYMM;
  }

  public String getTxtEndYYMM()
  {
    return txtEndYYMM;
  }

  public void setTxtEndYYMM(String newTxtEndYYMM)
  {
    txtEndYYMM = newTxtEndYYMM;
  }

  public String getTxtDAType()
  {
    return txtDAType;
  }

  public void setTxtDAType(String newTxtDAType)
  {
    txtDAType = newTxtDAType;
  }

  public String getPayrollFlag()
  {
    return payrollFlag;
  }

  public void setPayrollFlag(String newPayrollFlag)
  {
    payrollFlag = newPayrollFlag;
  }
  
}
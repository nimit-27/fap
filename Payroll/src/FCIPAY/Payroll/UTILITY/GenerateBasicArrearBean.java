package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class GenerateBasicArrearBean extends PayrollBaseDetailBean implements Serializable 
{



  private String txtEmployeeNo;
  private String txtEmployeeName;
  private String txtFromDate;
  private String txtUptoMonth;
  
 public GenerateBasicArrearBean()
    {
    }

  
 
  public GenerateBasicArrearBean(String sEmployeeNo,String sEmployeeName,String sFromDate,String sUptoMonth)
  {
        txtEmployeeNo = sEmployeeNo;
        txtEmployeeName = sEmployeeName;
        txtFromDate = sFromDate;
        txtUptoMonth = sUptoMonth;       
       

  
  }

  public String getTxtEmployeeNo()
  {
    return txtEmployeeNo;
  }

  public void setTxtEmployeeNo(String newTxtEmployeeNo)
  {
    txtEmployeeNo = newTxtEmployeeNo;
  }

  public String getTxtEmployeeName()
  {
    return txtEmployeeName;
  }

  public void setTxtEmployeeName(String newTxtEmployeeName)
  {
    txtEmployeeName = newTxtEmployeeName;
  }

  public String getTxtFromDate()
  {
    return txtFromDate;
  }

  public void setTxtFromDate(String newTxtFromDate)
  {
    txtFromDate = newTxtFromDate;
  }

  public String getTxtUptoMonth()
  {
    return txtUptoMonth;
  }

  public void setTxtUptoMonth(String newTxtUptoMonth)
  {
    txtUptoMonth = newTxtUptoMonth;
  }
  
}
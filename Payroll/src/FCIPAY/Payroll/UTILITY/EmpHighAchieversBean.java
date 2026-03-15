package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class EmpHighAchieversBean extends PayrollBaseDetailBean implements Serializable
{
  public String txtEmployeeNo="";
  public String txtIncrementDt="";
  public String txtSequenceID="";
  public String txtEmployeeName ="";
  public EmpHighAchieversBean()
  {
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
  
  public String getTxtIncrementDt()
  {
    return txtIncrementDt;
  }
  
  public void setTxtIncrementDt(String newTxtIncrementDt)
  {
    txtIncrementDt = newTxtIncrementDt;
  }
  
 public String getTxtSequenceID()
  {
    return txtSequenceID;
  }
  
  public void setTxtSequenceID(String newTxtSequenceID)
  {
    txtSequenceID = newTxtSequenceID;
  } 
}
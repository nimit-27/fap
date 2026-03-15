package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import java.lang.String;

public class EmpHighAchieversForm extends PayrollBaseForm
{
  private ArrayList emphighachievers = new ArrayList();
  private String[] txtEmployeeNo;
  private String[] txtIncrementDt;
  private String[] txtSequenceID;
  private String[] txtEmployeeName;
  
  public String[] getTxtEmployeeNo()
  {
    return txtEmployeeNo;
  }
  
  public void setTxtEmployeeNo(String[] newTxtEmployeeNo)
  {
    txtEmployeeNo = newTxtEmployeeNo;
  }
  
 public String[] getTxtEmployeeName()
  {
    return txtEmployeeName;
  }
  
  public void setTxtEmployeeName(String[] newTxtEmployeeName)
  {
    txtEmployeeName = newTxtEmployeeName;
  }  
  
  public String[] getTxtIncrementDt()
  {
    return txtIncrementDt;
  }
  
  public void setTxtIncrementDt(String[] newTxtIncrementDt)
  {
    txtIncrementDt = newTxtIncrementDt;
  }
  
  public ArrayList getEmphighachievers()
  {
    return emphighachievers;
  }
  
  public void setEmphighachievers(ArrayList newEmphighachievers)
  {
    emphighachievers=newEmphighachievers;
  }
  
  public String[] getTxtSequenceID()
  {
    return txtSequenceID;
  }
  
  public void setTxtSequenceID(String[] newTxtSequenceID)
  {
    txtSequenceID = newTxtSequenceID;
  } 
}
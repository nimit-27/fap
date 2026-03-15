package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
public class LOVInfo implements Serializable
{
  private String facadeName;
  private String functionName;
  private String insertFlag;
  
  public LOVInfo()
  {
  }

  public String getFacadeName()
  {
    return facadeName;
  }

  public void setFacadeName(String newFacadeName)
  {
    facadeName = newFacadeName;
  }

  public String getFunctionName()
  {
    return functionName;
  }

  public void setFunctionName(String newFunctionName)
  {
    functionName = newFunctionName;
  }

  public String getInsertFlag()
  {
    return insertFlag;
  }

  public void setInsertFlag(String newInsertFlag)
  {
    insertFlag = newInsertFlag;
  }
}
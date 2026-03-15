package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class CPFFinalPayComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList sancTypeList;
  private ArrayList advReasonList;
  private ArrayList partReasonList;
  
  public CPFFinalPayComboVO()
  {
  }
  
  public ArrayList getSancTypeList()
  {
    return sancTypeList;
  }
  
  public void setSancTypeList(ArrayList newSancTypeList)
  {
    sancTypeList=newSancTypeList;
  }
  
  public ArrayList getAdvReasonList()
  {
    return advReasonList;
  }
  
  public void setAdvReasonList(ArrayList newAdvReasonList)
  {
    advReasonList=newAdvReasonList;
  }

  public ArrayList getPartReasonList()
  {
    return partReasonList;
  }
  
  public void setPartReasonList(ArrayList newPartReasonList)
  {
    partReasonList=newPartReasonList;
  }

}
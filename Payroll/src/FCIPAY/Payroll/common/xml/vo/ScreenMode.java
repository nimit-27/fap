package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
public class ScreenMode implements Serializable
{
  private String _ModeName;
  private String _FacadeName;
  private String _FunctionName;
  private String _InsertFlag;
  
  public ScreenMode()
  {
  }

  public String get_FacadeName()
  {
    return _FacadeName;
  }

  public void set_FacadeName(String new_FacadeName)
  {
    _FacadeName = new_FacadeName;
  }

  public String get_FunctionName()
  {
    return _FunctionName;
  }

  public void set_FunctionName(String new_FunctionName)
  {
    _FunctionName = new_FunctionName;
  }

  public String get_InsertFlag()
  {
    return _InsertFlag;
  }

  public void set_InsertFlag(String new_InsertFlag)
  {
    _InsertFlag = new_InsertFlag;
  }

  public String get_ModeName()
  {
    return _ModeName;
  }

  public void set_ModeName(String new_ModeName)
  {
    _ModeName = new_ModeName;
  }
}
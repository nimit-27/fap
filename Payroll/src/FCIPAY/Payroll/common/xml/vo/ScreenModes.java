package FCIPAY.Payroll.common.xml.vo;
import java.util.ArrayList;
import java.io.Serializable;
public class ScreenModes implements Serializable
{
  private ArrayList _ScreenMode;
  
  public ScreenModes()
  {
  }

  public ArrayList get_ScreenMode()
  {
    return _ScreenMode;
  }

  public void set_ScreenMode(ArrayList new_ScreenMode)
  {
    _ScreenMode = new_ScreenMode;
  }
}
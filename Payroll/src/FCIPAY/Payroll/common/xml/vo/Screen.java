package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
import FCIPAY.Payroll.common.xml.vo.ScreenModes;
public class Screen implements Serializable
{
  private String _ScreenName;
  private ScreenModes _ScreenModes;
  
  public Screen()
  {
  }

  public ScreenModes get_ScreenModes()
  {
    return _ScreenModes;
  }

  public void set_ScreenModes(ScreenModes new_ScreenModes)
  {
    _ScreenModes = new_ScreenModes;
  }

  public String get_ScreenName()
  {
    return _ScreenName;
  }

  public void set_ScreenName(String new_ScreenName)
  {
    _ScreenName = new_ScreenName;
  }
}
package FCIPAY.Payroll.common.xml.vo;
import java.util.ArrayList;
import java.io.Serializable;
public class ScreenInfo implements Serializable
{
  
  private String _ScreenName;
  private Reports _Reports;

  public ScreenInfo()
  {
  }
  public ScreenInfo(String _sscreennme)
  {
  this._ScreenName=_sscreennme;
  }

  public String get_ScreenName()
  {
    return _ScreenName;
  }

  public void set_ScreenName(String new_Screenname)
  {
    _ScreenName = new_Screenname;
  }

  public Reports get_Reports()
  {
    return _Reports;
  }

  public void set_Reports(Reports new_Reports)
  {
    _Reports = new_Reports;
  }
  
}

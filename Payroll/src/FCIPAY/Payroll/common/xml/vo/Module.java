package FCIPAY.Payroll.common.xml.vo;
import java.util.ArrayList;
import java.io.Serializable;
public class Module implements Serializable
{
  
  private String _ModuleName;
 // private ScreenInfos _ScreenInfos;
 private ArrayList _ScreenInfo;
   
  public Module()
  {
  }

  public Module(String _modulename)
  {
  this._ModuleName=_modulename;
  }
  public String get_ModuleName()
  {
    return _ModuleName;
  }

  public void set_ModuleName(String new_Modulename)
  {
    _ModuleName = new_Modulename;
  }

/*  public ScreenInfos get_ScreenInfos()
  {
    return _ScreenInfos;
  }

  public void set_ScreenInfos(ScreenInfos new_Screeninfos)
  {
    _ScreenInfos = new_Screeninfos;
  }
 */ 
 
 
   public ArrayList get_ScreenInfo()
  {
    return _ScreenInfo;
  }

  public void set_ScreenInfo(ArrayList new_Screeninfo)
  {
    _ScreenInfo = new_Screeninfo;
  }
  /*
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
  */
  

}

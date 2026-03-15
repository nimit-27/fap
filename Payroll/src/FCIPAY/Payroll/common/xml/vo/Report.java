package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
public class Report implements Serializable
{
  
   private String _KeyInfo;
   private String _ReportKey;
   
  
  public Report()
  {
  }

  public String get_ReportKey()
  {
    return _ReportKey;
  }

  public void set_ReportKey(String new_Reportkey)
  {
    _ReportKey = new_Reportkey;
  }
  public String get_KeyInfo()
  {
    return _KeyInfo;
  }

  public void set_KeyInfo(String new_Keyinfo)
  {
    _KeyInfo = new_Keyinfo;
  }
}


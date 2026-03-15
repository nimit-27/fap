package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
import FCIPAY.Payroll.common.xml.vo.Screens;
public class LOV implements Serializable
{
  private String _LOVName;
  private String _ID;
  private String _Code;
  private String _Description;
  private String _Table;
  private String _OrderBy;
  private String _SearchField;
  private String _LovKey;
  private Screens _Screens;
  
  
  public LOV()
  {
  }

  public String get_Code()
  {
    return _Code;
  }

  public void set_Code(String new_Code)
  {
    _Code = new_Code;
  }

  public String get_Description()
  {
    return _Description;
  }

  public void set_Description(String new_Description)
  {
    _Description = new_Description;
  }

  public String get_ID()
  {
    return _ID;
  }

  public void set_ID(String new_ID)
  {
    _ID = new_ID;
  }

  public String get_LOVName()
  {
    return _LOVName;
  }

  public void set_LOVName(String new_LOVName)
  {
    _LOVName = new_LOVName;
  }

  public String get_SearchField()
  {
    return _SearchField;
  }

  public void set_SearchField(String new_SearchField)
  {
    _SearchField = new_SearchField;
  }

  public String get_Table()
  {
    return _Table;
  }

  public void set_Table(String new_Table)
  {
    _Table = new_Table;
  }

  public String get_OrderBy()
  {
    return _OrderBy;
  }

  public void set_OrderBy(String new_OrderBy)
  {
    _OrderBy = new_OrderBy;
  }

  public String get_LovKey()
  {
    return _LovKey;
  }

  public void set_LovKey(String new_LovKey)
  {
    _LovKey = new_LovKey;
  }

  public Screens get_Screens()
  {
    return _Screens;
  }

  public void set_Screens(Screens new_Screens)
  {
    _Screens = new_Screens;
  }


}
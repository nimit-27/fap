package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
import java.util.ArrayList;
public class SingleForm implements Serializable
{
  private String _FormName;
  private String _EnrgiseQueryVO;
  private String _HeaderBD;
  private String _HeaderBean;
  private String _HeaderSize;
  private DetailScreens _DetailScreens;
  
  public SingleForm()
  {
  }
  
  public SingleForm(String _FormName, String _EnrgiseQueryVO, DetailScreens _DetailScreens)
  {
    this._FormName = _FormName;
    this._EnrgiseQueryVO = _EnrgiseQueryVO;
    this._DetailScreens = _DetailScreens;
  }

  public DetailScreens get_DetailScreens()
  {
    return _DetailScreens;
  }

  public void set_DetailScreens(DetailScreens new_DetailScreens)
  {
    _DetailScreens = new_DetailScreens;
  }

  public String get_EnrgiseQueryVO()
  {
    return _EnrgiseQueryVO;
  }

  public void set_EnrgiseQueryVO(String new_EnrgiseQueryVO)
  {
    _EnrgiseQueryVO = new_EnrgiseQueryVO;
  }

  public String get_FormName()
  {
    return _FormName;
  }

  public void set_FormName(String new_FormName)
  {
    _FormName = new_FormName;
  }

  public String get_HeaderBD()
  {
    return _HeaderBD;
  }

  public void set_HeaderBD(String new_HeaderBD)
  {
    _HeaderBD = new_HeaderBD;
  }

  public String get_HeaderBean()
  {
    return _HeaderBean;
  }

  public void set_HeaderBean(String new_HeaderBean)
  {
    _HeaderBean = new_HeaderBean;
  }

  public String get_HeaderSize()
  {
    return _HeaderSize;
  }

  public void set_HeaderSize(String new_HeaderSize)
  {
    _HeaderSize = new_HeaderSize;
  }
}
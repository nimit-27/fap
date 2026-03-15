package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
import java.util.ArrayList;
public class INFOClass implements Serializable
{
  private ArrayList  _Module;
  public INFOClass()
  {
  }
  public INFOClass(ArrayList _module)
  {
  this._Module=_module;
  }
  public ArrayList get_Module()
  {
    return _Module;
  }

  public void set_Module(ArrayList new_Module)
  {
    _Module = new_Module;
  }
}

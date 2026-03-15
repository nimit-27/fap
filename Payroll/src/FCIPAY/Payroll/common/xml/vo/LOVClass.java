package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
import java.util.ArrayList;
public class LOVClass implements Serializable
{
  private ArrayList _LOV;
  public LOVClass()
  {
  }

  public ArrayList get_LOV()
  {
    return _LOV;
  }

  public void set_LOV(ArrayList new_LOV)
  {
    _LOV = new_LOV;
  }
}
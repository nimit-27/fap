package FCIPAY.Payroll.common.xml.vo;
import java.util.ArrayList;
import java.io.Serializable;
public class Screens implements Serializable 
{
  private ArrayList _Screen;
  public Screens()
  {
  }

  public ArrayList get_Screen()
  {
    return _Screen;
  }

  public void set_Screen(ArrayList new_Screen)
  {
    _Screen = new_Screen;
  }
}
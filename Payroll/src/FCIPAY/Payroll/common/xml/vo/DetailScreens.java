package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
import java.util.ArrayList;

public class DetailScreens  implements Serializable
{
  private ArrayList _DetailScreen;
  
  public DetailScreens()
  {
  }
  public DetailScreens(ArrayList _DetailScreen)
  {
    this._DetailScreen = _DetailScreen;
  }

  public ArrayList get_DetailScreen()
  {
    return _DetailScreen;
  }

  public void set_DetailScreen(ArrayList new_DetailScreen)
  {
    _DetailScreen = new_DetailScreen;
  }
}
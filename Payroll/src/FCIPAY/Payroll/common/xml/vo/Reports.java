package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
import java.util.ArrayList;
public class Reports implements Serializable
{
  private ArrayList _Report;
 
    
  public Reports()
  {
  }

  public ArrayList get_Report()
  {
    return _Report;
  }

  public void set_Report(ArrayList new_Report)
  {
    _Report = new_Report;
  }

  
}

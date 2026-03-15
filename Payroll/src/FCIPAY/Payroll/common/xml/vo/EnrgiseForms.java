package FCIPAY.Payroll.common.xml.vo;
import java.io.Serializable;
import java.util.ArrayList;
public class EnrgiseForms 
{
  private ArrayList _SingleForm;

  public EnrgiseForms()
  {
    super();
  }
  
  public EnrgiseForms (ArrayList _SingleForm_)
  {
    super();
    set_SingleForm(_SingleForm_);
  }
  
  public boolean isEmpty_SingleForm()
  {
    return (null == _SingleForm)?true:(_SingleForm.isEmpty());
  }

  public ArrayList get_SingleForm()
  {
    return _SingleForm;
  }

  public void set_SingleForm(ArrayList new_SingleForm_)
  {
    _SingleForm = new_SingleForm_;
  }
}
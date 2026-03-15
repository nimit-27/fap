package FCIPAY.Payroll.common.xml.vo;
import java.util.HashMap;
import FCIPAY.Payroll.common.xml.vo.SingleForm;
public class HashedEnrgiseForms 
{
  private SingleForm singleForm;
  private HashMap detailMap;
  
  public HashedEnrgiseForms()
  {
    detailMap  = new HashMap();
  }

  public HashMap getDetailMap()
  {
    return detailMap;
  }

  public void setDetailMap(HashMap newDetailMap)
  {
    detailMap = newDetailMap;
  }

  public SingleForm getSingleForm()
  {
    return singleForm;
  }

  public void setSingleForm(SingleForm newSingleForm)
  {
    singleForm = newSingleForm;
  }
}
package FCIPAY.Payroll.EJB.common.helper;
import java.util.HashMap;
import java.io.Serializable;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
public class QueryRow implements Serializable
{
  private HashMap row = null;
  public QueryRow(int iCapacity)
  {
    row = new HashMap(iCapacity);
  }

  public HashMap getRow()
  {
    return row;
  }

  public void setRow(HashMap newRow)
  {
    row = newRow;
  }
  
  public QueryValue get(String sColumnName)
  {
    if(row != null)
    {
      return (QueryValue)row.get(sColumnName.toUpperCase());
    }
    
    return null;
  }
  
}
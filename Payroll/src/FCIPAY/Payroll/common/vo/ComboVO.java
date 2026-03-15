package FCIPAY.Payroll.common.vo;
import java.io.Serializable;

public class ComboVO implements Serializable
{

  private String label;
  private String value;

  public ComboVO(String newLabel , String newValue)
  {
    label = newLabel;
    value = newValue;
  }

  public String getLabel()
  {
    return label;
  }

  public void setLabel(String newLabel)
  {
    label = newLabel;
  }

  public String getValue()
  {
    return value;
  }

  public void setValue(String newValue)
  {
    value = newValue;
  }





}
package FCIPAY.Payroll.EJB.common.helper;

public class InputDBObject 
{
  private int iPosition; // Ordinal Position
  private int iDataType; // Data Type of the parameter
  private Object oValue; //Value of the parameter

  public InputDBObject(int iPosition,int iDataType,Object oValue)
  {
    this.iPosition = iPosition;
    this.iDataType = iDataType;
    this.oValue = oValue;
  }

  public int getDataType()
  {
    return iDataType;
  }

  public void setDataType(int newIDataType)
  {
    iDataType = newIDataType;
  }

  public int getPosition()
  {
    return iPosition;
  }

  public void setPosition(int newIPosition)
  {
    iPosition = newIPosition;
  }

  public Object getObject()
  {
    return oValue;
  }

  public void setObject(Object newOValue)
  {
    oValue = newOValue;
  }
}
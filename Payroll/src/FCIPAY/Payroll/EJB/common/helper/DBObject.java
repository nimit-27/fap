package FCIPAY.Payroll.EJB.common.helper;
import java.io.Serializable;
public class DBObject implements Serializable
{
  private int iPosition; // Ordinal Position
  private int iInputOutput; // Out=2, InOut=3 or IN=1
  private int iDataType; // Data Type of the parameter
  private Object oValue; //Value of the parameter
  public static final int IN = 1;
  public static final int OUT = 2;
  public static final int INOUT = 3;
  
  public DBObject()
  {
  }

  public DBObject(int iPosition,int iDataType)
  {
    this.iPosition = iPosition;
    this.iDataType = iDataType;
  }

  public DBObject(int iPosition,int iInputOutput,int iDataType)
  {
    this.iPosition = iPosition;
    this.iInputOutput = iInputOutput;
    this.iDataType = iDataType;
  }

  public DBObject(int iPosition,int iInputOutput,int iDataType, Object oValue)
  {
    this.iPosition = iPosition;
    this.iInputOutput = iInputOutput;
    this.iDataType = iDataType;
    this.oValue = oValue;
  }

  public int getPosition()
  {
    return iPosition;
  }

  public int getDirection()
  {
    return iInputOutput;
  }

  public int getDataType()
  {
    return iDataType;
  }

  public Object getObject()
  {
    return oValue;
  }

  public void setObject(Object oValue)
  {
    this.oValue = oValue;
  }





}
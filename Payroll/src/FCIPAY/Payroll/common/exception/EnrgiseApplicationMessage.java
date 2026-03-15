package FCIPAY.Payroll.common.exception;
import java.io.Serializable;
// This class is basically a redundant one we could keep a single
// class EnrgiseApplicationException and a flag to denote whether it's a message or 
public class EnrgiseApplicationMessage extends BaseException implements Serializable
{
  public EnrgiseApplicationMessage()
  {
  }
}
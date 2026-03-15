package FCIPAY.Payroll.common.exception;
import java.io.Serializable;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.exception.BaseException;
public class EnrgiseApplicationException extends BaseException implements Serializable
{
  private ArrayList oListExceptions; // Other Exceptions
  private ArrayList oArguments;     // Arguments to the key string to be passed
                                   // to the ActionError class
  private String errorType = null;     
  
  public EnrgiseApplicationException()
  {
	super();
  }

 public EnrgiseApplicationException(String sMsgKey)
 {
  super(sMsgKey);
  this.errorType = FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR;
 }

 public EnrgiseApplicationException(String sMsgKey,String errorType)
 {
  super(sMsgKey);
  this.errorType = errorType;
 }
 public EnrgiseApplicationException(String sMsgKey,ArrayList oArguments)
 {
  super(sMsgKey);
  this.oArguments = oArguments;
  this.errorType = FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR;
 }

 public EnrgiseApplicationException(String sMsgKey,ArrayList oArguments,String sErrorType)
 {
  super(sMsgKey);
  this.oArguments = oArguments;
  this.errorType = errorType;
 }
 
  public ArrayList getList()
  {
    return oListExceptions;
  }

  public void setList(ArrayList oListExceptions)
  {
    this.oListExceptions = oListExceptions;
  }

  public void addToList(EnrgiseApplicationException oAppExcp)
  {
    if(oListExceptions == null)
    {
      oListExceptions = new ArrayList();
    }
    
    oListExceptions.add(oAppExcp);

  }

  public ArrayList getArguments()
  {
    return oArguments;
  }

  public void setArguments(ArrayList newOArguments)
  {
    oArguments = newOArguments;
  }

  public String getErrorType()
  {
    return errorType;
  }
}
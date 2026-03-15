/*
 * Module:        IBAFatalException.java
 * Author:        Balram
 * Date Written:  September 2003
* Description:    Exception Class Handling Fatal Exceptions
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed 
*/

package FCIPAY.COMMON.UTILITY;
import FCIPAY.COMMON.UTILITY.IBAException;

public class IBAFatalException extends IBAException
{

    private String sMessage = "";
    private String errorKey = "";
    private int iErrCode = 0;

    public IBAFatalException()
    {
        
    }
    public IBAFatalException(String errorKey)
    {
        this.errorKey = errorKey;    
    }

    public IBAFatalException(int errCode,String errorMsg)
    {
        this.iErrCode = errCode;    
        this.sMessage=errorMsg;
    }

    public String getErrorKey()
    {
        return errorKey;
    }   

    public void setsMessage(String msg)
    {
        this.sMessage=msg;
    }
    
    public String getsMessage()
    {
        return this.sMessage;
    }

    public void setiErrCode(int iErrCode)
    {
        this.iErrCode=iErrCode;
    }
    public int getiErrCode()
    {
        return this.iErrCode;
    }
}
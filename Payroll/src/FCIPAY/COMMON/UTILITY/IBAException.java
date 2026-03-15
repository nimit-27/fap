/*
 * Module:        IBAException.java
 * Author:        Balram
 * Date Written:  September 2003
* Description:    Exception Class Handling Exceptions
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed 
*/





package FCIPAY.COMMON.UTILITY;

public class  IBAException extends Exception
{

    private String sMessage = "";
    private int iErrCode = 0;
    private String errorKey = "";
    
    public IBAException()
    {
        
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
    public IBAException(String errorKey)
    {
        this.errorKey = errorKey;       
    }

    public String getErrorKey()
    {
        return errorKey;
    }

}

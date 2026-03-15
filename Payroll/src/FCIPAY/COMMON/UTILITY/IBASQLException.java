/*
 * Module:        IBASQLException.java
 * Author:        Karthik Murthy
 * Date Written:  October 2004
* Description:    Exception Class Handling SQL Exceptions
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed 
*/





package FCIPAY.COMMON.UTILITY;

public class IBASQLException extends IBAException
{

    private String sMessage = "";
    private String errorKey = "";
    private int iErrCode = 0;

    public IBASQLException()
    {
        
    }
    public IBASQLException(String errorKey)
    {
        this.errorKey = errorKey;    
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
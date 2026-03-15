/*
 * Module:        IBABusinessException.java
 * Author:        Balram
 * Date Written:  September 2003
* Description:    Exception Class for Handling Business Exceptions
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed 
*/




package FCIPAY.COMMON.UTILITY;

public class IBABusinessException extends IBAException
{

    private String sMessage = "";
    private String errorKey = "";
    
    public IBABusinessException(String sErrorKey)
    {
        this.errorKey=sErrorKey;
    }
    public IBABusinessException()
    {
        
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
    
}
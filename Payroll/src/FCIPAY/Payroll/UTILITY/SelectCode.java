    /*
     * Module       :   SelectCode.java
     * Author       :   V.Jegan
     * Date Written :   30th Sept 2003
     * Description  :   The Bean class for retriving the code and 
     *                  populating into the combo boxes in the page.
     * Revision Log :   (mm/dd/yy initials description)
     * -----------------------------------------------------------------
     * mm/dd/yy     xxxx    <comments on changes>
    */

package FCIPAY.Payroll.UTILITY;

public class SelectCode 
{
  public SelectCode()
  {
  }
  
  private String tempCode="";
    private long ltempId;
    private int tempId;
    private String tempName;
  
  
  public SelectCode(int paramid,String paramcode)
    {
        this.tempId=paramid;
        this.tempCode=paramcode;
    }


    public SelectCode(long paramLid,String paramcode,String paramName)
    {
        this.ltempId=paramLid;
        this.tempCode=paramcode;
        this.tempName=paramName;
    }

    public SelectCode(long paramLid,String paramcode)
    {
        this.ltempId=paramLid;
        this.tempCode=paramcode;
    }

    public SelectCode(String paramsid,String paramcode)
    {
        this.tempName=paramcode;
        this.tempCode=paramsid;
    }

  public String getTempCode()
  {
    return tempCode;
  }

  public void setTempCode(String newTempCode)
  {
    tempCode = newTempCode;
  }

  public long getLtempId()
  {
        return ltempId;
  }

  public void setLtempId(long newLtempId)
  {
        ltempId = newLtempId;
  }

    public int getTempId()
    {
        return tempId;
    }

    public void setTempId(int newTempId)
    {
        tempId = newTempId;
    }

    public String getTempName()
    {
        return tempName;
    }

    public void setTempName(String newTempName)
    {
        tempName = newTempName;
    }
}

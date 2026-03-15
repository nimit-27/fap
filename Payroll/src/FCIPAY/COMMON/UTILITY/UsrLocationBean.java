package FCIPAY.COMMON.UTILITY;

public class UsrLocationBean 
{

    private long empNo=0;
    private String empName="";
    private long locCode=0;
    private String locDesc="";
    private String status="";
    private long hdnId=0;

public UsrLocationBean(long pEmpNo,String pEmpName,long pLocCode,String pLocDesc,String pStatus,long pId)
{
    this.empNo=pEmpNo;
    this.empName=pEmpName;
    this.locCode=pLocCode;
    this.locDesc=pLocDesc;
    this.status=pStatus;
    this.hdnId=pId;
}

    public long getEmpNo()
    {
        return empNo;
    }

    public void setEmpNo(long newEmpNo)
    {
        empNo = newEmpNo;
    }

    public String getEmpName()
    {
        return empName;
    }

    public void setEmpName(String newEmpName)
    {
        empName = newEmpName;
    }

    public long getLocCode()
    {
        return locCode;
    }

    public void setLocCode(long newLocCode)
    {
        locCode = newLocCode;
    }

    public String getLocDesc()
    {
        return locDesc;
    }

    public void setLocDesc(String newLocDesc)
    {
        locDesc = newLocDesc;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String newStatus)
    {
        status = newStatus;
    }

    public long getHdnId()
    {
        return hdnId;
    }

    public void setHdnId(long newHdnId)
    {
        hdnId = newHdnId;
    }










  
}
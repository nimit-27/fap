package FCIPAY.HRMS.DATAACCESSTIER.VO;

public class LeaveMastVO 
{
    private long sLEAVE_ID;
    private String SLEAVE_SDESC;
    private String SLEAVE_LDESC;

    private long sMAX_LIMIT_1;
    private String sMAX_LIMIT_1_UNIT;
    private long sMAX_LIMIT_2;
    private String sMAX_LIMIT_2_UNIT;
    private long sMAX_LIMIT_3;
    private String sMAX_LIMIT_3_UNIT;
    private String MAX_LIMIT_FREQ;
    private long sMIN_EXP_REQ;
    private long Empno;
    private long LocCode;
    private String sDISPLAY_FLG;
     private String lstApply;

    public LeaveMastVO()
    {
    }

    public long getSLEAVE_ID()
    {
        return sLEAVE_ID;
    }

    public void setSLEAVE_ID(long newSLEAVE_ID)
    {
        sLEAVE_ID = newSLEAVE_ID;
    }

    public String getSLEAVE_SDESC()
    {
        return SLEAVE_SDESC;
    }

    public void setSLEAVE_SDESC(String newSLEAVE_SDESC)
    {
        SLEAVE_SDESC = newSLEAVE_SDESC;
    }

    public String getSLEAVE_LDESC()
    {
        return SLEAVE_LDESC;
    }

    public void setSLEAVE_LDESC(String newLEAVE_LDESC)
    {
        SLEAVE_LDESC = newLEAVE_LDESC;
    }

    public long getSMAX_LIMIT_1()
    {
        return sMAX_LIMIT_1;
    }

    public void setSMAX_LIMIT_1(long newSMAX_LIMIT_1)
    {
        sMAX_LIMIT_1 = newSMAX_LIMIT_1;
    }

    public String getSMAX_LIMIT_1_UNIT()
    {
        return sMAX_LIMIT_1_UNIT;
    }

    public void setSMAX_LIMIT_1_UNIT(String newSMAX_LIMIT_1_UNIT)
    {
        sMAX_LIMIT_1_UNIT = newSMAX_LIMIT_1_UNIT;
    }

    public long getSMAX_LIMIT_2()
    {
        return sMAX_LIMIT_2;
    }

    public void setSMAX_LIMIT_2(long newSMAX_LIMIT_2)
    {
        sMAX_LIMIT_2 = newSMAX_LIMIT_2;
    }

    public String getSMAX_LIMIT_2_UNIT()
    {
        return sMAX_LIMIT_2_UNIT;
    }

    public void setSMAX_LIMIT_2_UNIT(String newSMAX_LIMIT_2_UNIT)
    {
        sMAX_LIMIT_2_UNIT = newSMAX_LIMIT_2_UNIT;
    }

    public long getSMAX_LIMIT_3()
    {
        return sMAX_LIMIT_3;
    }

    public void setSMAX_LIMIT_3(long newSMAX_LIMIT_3)
    {
        sMAX_LIMIT_3 = newSMAX_LIMIT_3;
    }

    public String getSMAX_LIMIT_3_UNIT()
    {
        return sMAX_LIMIT_3_UNIT;
    }

    public void setSMAX_LIMIT_3_UNIT(String newSMAX_LIMIT_3_UNIT)
    {
        sMAX_LIMIT_3_UNIT = newSMAX_LIMIT_3_UNIT;
    }

    public String getMAX_LIMIT_FREQ()
    {
        return MAX_LIMIT_FREQ;
    }

    public void setMAX_LIMIT_FREQ(String newMAX_LIMIT_FREQ)
    {
        MAX_LIMIT_FREQ = newMAX_LIMIT_FREQ;
    }

    public long getSMIN_EXP_REQ()
    {
        return sMIN_EXP_REQ;
    }

    public void setSMIN_EXP_REQ(long newSMIN_EXP_REQ)
    {
        sMIN_EXP_REQ = newSMIN_EXP_REQ;
    }

    public long getEmpno()
    {
        return Empno;
    }

    public void setEmpno(long newEmpno)
    {
        Empno = newEmpno;
    }

    public long getLocCode()
    {
        return LocCode;
    }

    public void setLocCode(long newLocCode)
    {
        LocCode = newLocCode;
    }

    public String getSDISPLAY_FLG()
    {
        return sDISPLAY_FLG;
    }

    public void setSDISPLAY_FLG(String newSDISPLAY_FLG)
    {
        sDISPLAY_FLG = newSDISPLAY_FLG;
    }


   public String getlstApply()
    {
        return lstApply;
    }

    public void setlstApply(String newLstApply)
    {
        lstApply = newLstApply;
    }


}
package FCIPAY.COMMON.UTILITY;

public class UserInfoBean 
{
  private long LEmployeeNo;
  private String SEmployeeName;
  private String SContactNo;

  private String sEmail;
  private String sDob;

  private String sSex;
  private String sDojDAE;
  private String sDojGov;
  
  private String sDoj;
  
  private String sDojSite;
  private String sEmpType;
  private String sCateg;
  private String sCadre;
  private String sUnit;

  private long LLocationCode;
 
  private String sDirectorate;
  
  private String sGroup;

  private String sFuncGrp;
  private String SSection;
  private String sSuperior;

  private String SDesignation;
  private String SGrade;

  private String sPay;

  private String SEmpLocation;
  private String SSubLocation;

  private String sConfDate;
  private String sIncrDate;
  private String sLstPromDate;
  private String sCRDate;
  private String sOption;

  private String sRetiremntDt;

  private String sLeaveType;
  private String sMarStatus;
    private String sunitname;
    private String ssectionHeadName;
    private String ssectionHeadDesgn;
    private String SEmpSplzn;
    private String saddress;
    private String SFinReportURL;
    private String SEsttReportURL;
    private String SHRMReportURL;
    private String SPasswdStaus;
  private String SgazettedFlag;
  
  public UserInfoBean()
  {
    /*LEmployeeNo = 9300004;    
    LLocationCode = 93;        
    SEmployeeName = "Employee XYZ";
    SDesignation = "Senior Manager(P&IR)";
    SSection = "Establishment";
    SContactNo = "02225992901";
    SEmpLocation = "VSB"; 
    SSubLocation = "9th Floor, B Wing";
    SGrade="Y";
    sGroup="C";
    sSex="M";
    sDoj="28/11/1998";
    sRetiremntDt="01/01/2000"; 
    sPay="1515";
    sDob="12/12/2001";*/
  }

  public long getLEmployeeNo()
  {
    return LEmployeeNo;
  }

  public void setLEmployeeNo(long newLEmployeeNo)
  {
    LEmployeeNo = newLEmployeeNo;
  }

  public long getLLocationCode()
  {
    return LLocationCode;
  }

  public void setLLocationCode(long newLLocationCode)
  {
    LLocationCode = newLLocationCode;
  }

  public String getSEmployeeName()
  {
    return SEmployeeName;
  }

  public void setSEmployeeName(String newSEmployeeName)
  {
    SEmployeeName = newSEmployeeName;
  }

  public String getSDesignation()
  {
    return SDesignation;
  }

  public void setSDesignation(String newSDesignation)
  {
    SDesignation = newSDesignation;
  }

  


  public String getSSection()
  {
    return SSection;
  }

  public void setSSection(String newSSection)
  {
    SSection = newSSection;
  }

  public String getSContactNo()
  {
    return SContactNo;
  }

  public void setSContactNo(String newSContactNo)
  {
    SContactNo = newSContactNo;
  }

  public String getSEmpLocation()
  {
    return SEmpLocation;
  }

  public void setSEmpLocation(String newSEmpLocation)
  {
    SEmpLocation = newSEmpLocation;
  }

  public String getSSubLocation()
  {
    return SSubLocation;
  }

  public void setSSubLocation(String newSSubLocation)
  {
    SSubLocation = newSSubLocation;
  }

    public String getSGrade()
    {
        return SGrade;
    }

    public void setSGrade(String newSGrade)
    {
        SGrade = newSGrade;
    }

    public String getSGroup()
    {
        return sGroup;
    }

    public void setSGroup(String newSGroup)
    {
        sGroup = newSGroup;
    }

    public String getSSex()
    {
        return sSex;
    }

    public void setSSex(String newSSex)
    {
        sSex = newSSex;
    }

    public String getSDoj()
    {
        return sDoj;
    }

    public void setSDoj(String newSDoj)
    {
        sDoj = newSDoj;
    }

    public String getSRetiremntDt()
    {
        return sRetiremntDt;
    }

    public void setSRetiremntDt(String newsRetiremntDt)
    {
        sRetiremntDt = newsRetiremntDt;
    }

    public String getSCRDate()
    {
        return sCRDate;
    }

    public void setSCRDate(String newSCRDate)
    {
        sCRDate = newSCRDate;
    }

    public String getSCadre()
    {
        return sCadre;
    }

    public void setSCadre(String newSCadre)
    {
        sCadre = newSCadre;
    }

    public String getSCateg()
    {
        return sCateg;
    }

    public void setSCateg(String newSCateg)
    {
        sCateg = newSCateg;
    }

    public String getSConfDate()
    {
        return sConfDate;
    }

    public void setSConfDate(String newSConfDate)
    {
        sConfDate = newSConfDate;
    }

    public String getSDirectorate()
    {
        return sDirectorate;
    }

    public void setSDirectorate(String newSDirectorate)
    {
        sDirectorate = newSDirectorate;
    }

    public String getSDob()
    {
        return sDob;
    }

    public void setSDob(String newSDob)
    {
        sDob = newSDob;
    }

    public String getSDojDAE()
    {
        return sDojDAE;
    }

    public void setSDojDAE(String newSDojDAE)
    {
        sDojDAE = newSDojDAE;
    }

    public String getSDojGov()
    {
        return sDojGov;
    }

    public void setSDojGov(String newSDojGov)
    {
        sDojGov = newSDojGov;
    }

    public String getSDojSite()
    {
        return sDojSite;
    }

    public void setSDojSite(String newSDojSite)
    {
        sDojSite = newSDojSite;
    }

    public String getSEmail()
    {
        return sEmail;
    }

    public void setSEmail(String newSEmail)
    {
        sEmail = newSEmail;
    }

    public String getSEmpType()
    {
        return sEmpType;
    }

    public void setSEmpType(String newSEmpType)
    {
        sEmpType = newSEmpType;
    }

    public String getSFuncGrp()
    {
        return sFuncGrp;
    }

    public void setSFuncGrp(String newSFuncGrp)
    {
        sFuncGrp = newSFuncGrp;
    }

    public String getSIncrDate()
    {
        return sIncrDate;
    }

    public void setSIncrDate(String newSIncrDate)
    {
        sIncrDate = newSIncrDate;
    }

    public String getSLstPromDate()
    {
        return sLstPromDate;
    }

    public void setSLstPromDate(String newSLstPromDate)
    {
        sLstPromDate = newSLstPromDate;
    }

    public String getSOption()
    {
        return sOption;
    }

    public void setSOption(String newSOption)
    {
        sOption = newSOption;
    }

    public String getSPay()
    {
        return sPay;
    }

    public void setSPay(String newSPay)
    {
        sPay = newSPay;
    }

    public String getSSuperior()
    {
        return sSuperior;
    }

    public void setSSuperior(String newSSuperior)
    {
        sSuperior = newSSuperior;
    }

    public String getSUnit()
    {
        return sUnit;
    }

    public void setSUnit(String newSUnit)
    {
        sUnit = newSUnit;
    }

    public String getsLeaveType()
    {
        return sLeaveType;
    }

    public void setsLeaveType(String newsLeaveType)
    {
        sLeaveType = newsLeaveType;
    }
    public String getsMarStatus()
    {
        return sMarStatus;
    }

    public void setsMarStatus(String newsMarStatus)
    {
        sMarStatus = newsMarStatus;
    }

    public String getSunitname() {
        return sunitname;
    }

    public void setSunitname(String newSunitname) {
        sunitname = newSunitname;
    }

    public String getSsectionHeadName() {
        return ssectionHeadName;
    }

    public void setSsectionHeadName(String newSsectionHeadName) {
        ssectionHeadName = newSsectionHeadName;
    }

    public String getSsectionHeadDesgn() {
        return ssectionHeadDesgn;
    }

    public void setSsectionHeadDesgn(String newSsectionHeadDesgn) {
        ssectionHeadDesgn = newSsectionHeadDesgn;
    }

    public String getSEmpSplzn()
    {
        return SEmpSplzn;
    }

    public void setSEmpSplzn(String newSEmpSplzn)
    {
        SEmpSplzn = newSEmpSplzn;
    }

    public String getSaddress()
    {
        return saddress;
    }

    public void setSaddress(String newSaddress)
    {
        saddress = newSaddress;
    }

    public String getSFinReportURL()
    {
        return SFinReportURL;
    }

    public void setSFinReportURL(String newSFinReportURL)
    {
        SFinReportURL = newSFinReportURL;
    }

    public String getSEsttReportURL()
    {
        return SEsttReportURL;
    }

    public void setSEsttReportURL(String newSEsttReportURL)
    {
        SEsttReportURL = newSEsttReportURL;
    }

    public String getSHRMReportURL()
    {
        return SHRMReportURL;
    }

    public void setSHRMReportURL(String newSHRMReportURL)
    {
        SHRMReportURL = newSHRMReportURL;
    }

    public String getSPasswdStaus()
    {
        return SPasswdStaus;
    }

    public void setSPasswdStaus(String newSPasswdStaus)
    {
        SPasswdStaus = newSPasswdStaus;
    }

  public String getSgazettedFlag()
  {
    return SgazettedFlag;
  }

  public void setSgazettedFlag(String newSgazettedFlag)
  {
    SgazettedFlag = newSgazettedFlag;
  }



  
}
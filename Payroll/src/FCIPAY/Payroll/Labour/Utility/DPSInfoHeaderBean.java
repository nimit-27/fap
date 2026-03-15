package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class DPSInfoHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  private String txtEmpNo;
  private String txtStaffCode;
  private String parentZone;
  private String txtEmpFirstName;
  private String txtEmpMiddleName;
  private String txtEmpLastName;
  private String txtDsgn;  
  private String txtDsgnDesc;
  private String txtCateg=""; 
  private String txtPFType;
  private String txtCpfCode;
 private String txtOldCpfCode;  // Added by dushyant on 18-May-2013
  private String txtFpsNo;
  private String txtDojFCI;
  private String txtPresentPOP;
  private String txtPresentPOPDesc;
  private String txtDOJSite;
  private String txtEmpStatus;
  private String prefix="";
  
  private String txtCurMGW;
  private String txtPayStatus;
  private String txtPayMode;
  private String txtPayStsChnDate="";
  
  private String hdnIRFlag;
  private String hdnBFFlag;
  private String hdnSocRecFlag;
  private String txtSocRecAmt;

  
  private String txtDOB;
  private String txtGender;
  private String txtMarStat;
  private String txtFatherNam;
  private String txtHomTwn;
  private String txtHandi;
  private String txtHandiEffDate;
  private String txtRetireDate;
  
  private String txtEpsFlag;
  private String txtEpsEntDt;
  private String txtEpsSepRsn;
  private String txtEpsSepDt;
  
  private String txtAddId;
  /*private String txtAddType;
  private String txtAddL1;
  private String txtAddL2;
  private String txtCity;
  private String txtState;
  private String txtCountry;
  private String txtPin;*/
  private String txtPermAddL1;
  private String txtPermAddL2;
  private String txtPermCity;
  private String txtPermState;
  private String txtPermStateDesc;
  private String txtPermCountry;
  private String txtPermPin;
  private String txtTempAddL1;
  private String txtTempAddL2;
  private String txtTempCity;
  private String txtTempState;
  private String txtTempStateDesc;
  private String txtTempCountry;
  private String txtTempPin;
  private String txtPanNo; // added by dushyant 0n 20-Dec-2011
  private String txtGangId; //added by Swapnendu Dt 21 May 2012.
  private String txtGangName; //added by Swapnendu Dt 21 May 2012.
  
  private String txtCasteCateg;
   private String txtHandiType;
   private String txtReligion;
   private String txtExsrvcman;
   private String txtAadharNum;
   private String txtUanNum;
   private String txtFathHusflag;

    public void setTxtMemberId(String txtMemberId) {
        this.txtMemberId = txtMemberId;
    }

    public String getTxtMemberId() {
        return txtMemberId;
    }
    private String txtBankDesc;
    private String txtBranchDesc;
    private String txtBankAccNo;
    private String txtBankCode;
    private String txtBranchCode;
    private String txtCPFIntEndDt; 
    private String txtMemberId;
    private String txtPohwEffDt;
    private String txtPohwFlag;

    public void setTxtPohwEffDt(String txtPohwEffDt) {
        this.txtPohwEffDt = txtPohwEffDt;
    }

    public String getTxtPohwEffDt() {
        return txtPohwEffDt;
    }

    public void setTxtPohwFlag(String txtPohwFlag) {
        this.txtPohwFlag = txtPohwFlag;
    }

    public String getTxtPohwFlag() {
        return txtPohwFlag;
    }

    public DPSInfoHeaderBean()
  {
  }
public String getTxtFathHusflag()
{
return txtFathHusflag;
}

public void setTxtFathHusflag(String newTxtFathHusflag)
  {
    txtFathHusflag = newTxtFathHusflag;
  } 
  
public String getTxtUanNum()
  {
    return txtUanNum;
  }

  public void setTxtUanNum(String newTxtUanNum)
  {
    txtUanNum = newTxtUanNum;
  } 
  
    public String getTxtAadharNum()
  {
    return txtAadharNum;
  }

  public void setTxtAadharNum(String newTxtAadharNum)
  {
    txtAadharNum = newTxtAadharNum;
  } 
  
    public String getTxtExsrvcman()
  {
    return txtExsrvcman;
  }

  public void setTxtExsrvcman(String newTxtExsrvcman)
  {
    txtExsrvcman = newTxtExsrvcman;
  } 
    
    public String getTxtReligion()
  {
    return txtReligion;
  }

  public void setTxtReligion(String newTxtReligion)
  {
    txtReligion = newTxtReligion;
  } 
  
    
      public String getTxtHandiType()
  {
    return txtHandiType;
  }

  public void setTxtHandiType(String newTxtHandiType)
  {
    txtHandiType = newTxtHandiType;
  } 
  
    public String getTxtCasteCateg()
  {
    return txtCasteCateg;
  }

  public void setTxtCasteCateg(String newTxtCasteCateg)
  {
    txtCasteCateg = newTxtCasteCateg;
  } 
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }  
  
  public String getTxtStaffCode()
  {
    return txtStaffCode;
  }

  public void setTxtStaffCode(String newTxtStaffCode)
  {
    txtStaffCode = newTxtStaffCode;
  } 
  
  public String getParentZone()
  {
    return parentZone;
  }

  public void setParentZone(String newParentZone)
  {
    parentZone = newParentZone;
  }
  
  public String getTxtEmpFirstName()
  {
    return txtEmpFirstName;
  }

  public void setTxtEmpFirstName(String newTxtEmpFirstName)
  {
    txtEmpFirstName = newTxtEmpFirstName;
  }
  
  public String getTxtEmpMiddleName()
  {
    return txtEmpMiddleName;
  }

  public void setTxtEmpMiddleName(String newTxtEmpMiddleName)
  {
    txtEmpMiddleName = newTxtEmpMiddleName;
  }
  
  public String getTxtEmpLastName()
  {
    return txtEmpLastName;
  }

  public void setTxtEmpLastName(String newTxtEmpLastName)
  {
    txtEmpLastName = newTxtEmpLastName;
  }
  
  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  public String getTxtPresentPOPDesc()
  {
    return txtPresentPOPDesc;
  }

  public void setTxtPresentPOPDesc(String newTxtPresentPOPDesc)
  {
    txtPresentPOPDesc = newTxtPresentPOPDesc;
  }
  
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }  
  
  public String getTxtFpsNo()
  {
    return txtFpsNo;
  }
  public void setTxtFpsNo(String newTxtFpsNo)
  {
    txtFpsNo = newTxtFpsNo;
  }
  
  public String getTxtDsgn()
  {
    return txtDsgn;
  }
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }

  public String getTxtCurMGW()
  {
    return txtCurMGW;
  }

  public void setTxtCurMGW(String newTxtCurMGW)
  {
    txtCurMGW = newTxtCurMGW;
  }
  
  public String getTxtHandi()
  {
    return txtHandi;
  }

  public void setTxtHandi(String newTxtHandi)
  {
    txtHandi = newTxtHandi;
  }

  public String getTxtPayMode()
  {
    return txtPayMode;
  }

  public void setTxtPayMode(String newTxtPayMode)
  {
    txtPayMode = newTxtPayMode;
  }


  public String getTxtPayStatus()
  {
    return txtPayStatus;
  }

  public void setTxtPayStatus(String newTxtPayStatus)
  {
    txtPayStatus = newTxtPayStatus;
  }

  public String getTxtPayStsChnDate()
  {
    return txtPayStsChnDate;
  }

  public void setTxtPayStsChnDate(String newTxtPayStsChnDate)
  {
    txtPayStsChnDate = newTxtPayStsChnDate;
  }  


  public String getTxtPFType()
  {
    return txtPFType;
  }

  public void setTxtPFType(String newTxtPFType)
  {
    txtPFType = newTxtPFType;
  }
  

  public String getTxtDojFCI()
  {
    return txtDojFCI;
  }

  public void setTxtDojFCI(String newTxtDojFCI)
  {
    txtDojFCI = newTxtDojFCI;
  }  
  
  public String getTxtDOB()
  {
    return txtDOB;
  }

  public void setTxtDOB(String newTxtDOB)
  {
    txtDOB = newTxtDOB;
  }
  
  public String getTxtGender()
  {
    return txtGender;
  }

  public void setTxtGender(String newTxtGender)
  {
    txtGender = newTxtGender;
  }
  
   public String getTxtMarStat()
  {
    return txtMarStat;
  }

  public void setTxtMarStat(String newTxtMarStat)
  {
    txtMarStat = newTxtMarStat;
  }
  
  public String getTxtFatherNam()
  {
    return txtFatherNam;
  }

  public void setTxtFatherNam(String newTxtFatherNam)
  {
    txtFatherNam = newTxtFatherNam;
  }

 public String getTxtHomTwn()
  {
    return txtHomTwn;
  }

  public void setTxtHomTwn(String newTxtHomTwn)
  {
    txtHomTwn = newTxtHomTwn;
  }

  public String getTxtHandiEffDate()
  {
    return txtHandiEffDate;
  }

  public void setTxtHandiEffDate(String newTxtHandiEffDate)
  {
    txtHandiEffDate = newTxtHandiEffDate;
  }

  public String getTxtRetireDate()
  {
    return txtRetireDate;
  }

  public void setTxtRetireDate(String newTxtRetireDate)
  {
    txtRetireDate = newTxtRetireDate;
  }

  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }

  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }
  
  public String getPrefix()
  {
    return prefix;
  }

  public void setPrefix(String newPrefix)
  {
    prefix = newPrefix;
  }  

  public String getTxtDOJSite()
  {
    return txtDOJSite;
  }

  public void setTxtDOJSite(String newTxtDOJSite)
  {
    txtDOJSite = newTxtDOJSite;
  } 
  
  public String getTxtAddId()
  {
    return txtAddId;
  }  

  public void setTxtAddId(String newTxtAddId)
  {
    txtAddId = newTxtAddId;
  }
  
  /* public String getTxtAddType()
  {
    return txtAddType;
  }  

  public void setTxtAddType(String newTxtAddType)
  {
    txtAddType = newTxtAddType;
  }
  
  public String getTxtAddL1()
  {
    return txtAddL1;
  }

  public void setTxtAddL1(String newTxtAddL1)
  {
    txtAddL1 = newTxtAddL1;
  }

  public String getTxtAddL2()
  {
    return txtAddL2;
  }

  public void setTxtAddL2(String newTxtAddL2)
  {
    txtAddL2 = newTxtAddL2;
  }
  
  public String getTxtCity()
  {
    return txtCity;
  }

  public void setTxtCity(String newTxtCity)
  {
    txtCity = newTxtCity;
  }
  
  public String getTxtState()
  {
    return txtState;
  }

  public void setTxtState(String newTxtState)
  {
    txtState = newTxtState;
  }
  
  public String getTxtCountry()
  {
    return txtCountry;
  }

  public void setTxtCountry(String newTxtCountry)
  {
    txtCountry = newTxtCountry;
  }
  
  public String getTxtPin()
  {
    return txtPin;
  }

  public void setTxtPin(String newTxtPin)
  {
    txtPin = newTxtPin;
  }*/

  public String getTxtPermAddL1()
  {
    return txtPermAddL1;
  }

  public void setTxtPermAddL1(String newTxtPermAddL1)
  {
    txtPermAddL1 = newTxtPermAddL1;
  }

  public String getTxtPermAddL2()
  {
    return txtPermAddL2;
  }

  public void setTxtPermAddL2(String newTxtPermAddL2)
  {
    txtPermAddL2 = newTxtPermAddL2;
  }
  
  public String getTxtPermCity()
  {
    return txtPermCity;
  }

  public void setTxtPermCity(String newTxtPermCity)
  {
    txtPermCity = newTxtPermCity;
  }
  
  public String getTxtPermState()
  {
    return txtPermState;
  }

  public void setTxtPermState(String newTxtPermState)
  {
    txtPermState = newTxtPermState;
  }
  
  public String getTxtPermStateDesc()
  {
    return txtPermStateDesc;
  }

  public void setTxtPermStateDesc(String newTxtPermStateDesc)
  {
    txtPermStateDesc = newTxtPermStateDesc;
  }
  
  public String getTxtPermCountry()
  {
    return txtPermCountry;
  }

  public void setTxtPermCountry(String newTxtPermCountry)
  {
    txtPermCountry = newTxtPermCountry;
  }
  
  public String getTxtPermPin()
  {
    return txtPermPin;
  }

  public void setTxtPermPin(String newTxtPermPin)
  {
    txtPermPin = newTxtPermPin;
  }
  
  public String getTxtTempAddL1()
  {
    return txtTempAddL1;
  }

  public void setTxtTempAddL1(String newTxtTempAddL1)
  {
    txtTempAddL1 = newTxtTempAddL1;
  }

  public String getTxtTempAddL2()
  {
    return txtTempAddL2;
  }

  public void setTxtTempAddL2(String newTxtTempAddL2)
  {
    txtTempAddL2 = newTxtTempAddL2;
  }
  
  public String getTxtTempCity()
  {
    return txtTempCity;
  }

  public void setTxtTempCity(String newTxtTempCity)
  {
    txtTempCity = newTxtTempCity;
  }
  
  public String getTxtTempState()
  {
    return txtTempState;
  }

  public void setTxtTempState(String newTxtTempState)
  {
    txtTempState = newTxtTempState;
  }
  
  public String getTxtTempStateDesc()
  {
    return txtTempStateDesc;
  }

  public void setTxtTempStateDesc(String newTxtTempStateDesc)
  {
    txtTempStateDesc = newTxtTempStateDesc;
  }
  
  public String getTxtTempCountry()
  {
    return txtTempCountry;
  }

  public void setTxtTempCountry(String newTxtTempCountry)
  {
    txtTempCountry = newTxtTempCountry;
  }
  
  public String getTxtTempPin()
  {
    return txtTempPin;
  }

  public void setTxtTempPin(String newTxtTempPin)
  {
    txtTempPin = newTxtTempPin;
  }

  public String getHdnBFFlag()
  {
    return hdnBFFlag;
  }

  public void setHdnBFFlag(String newHdnBFFlag)
  {
    hdnBFFlag = newHdnBFFlag;
  }

  public String getHdnIRFlag()
  {
    return hdnIRFlag;
  }

  public void setHdnIRFlag(String newHdnIRFlag)
  {
    hdnIRFlag = newHdnIRFlag;
  }

  public String getHdnSocRecFlag()
  {
    return hdnSocRecFlag;
  }

  public void setHdnSocRecFlag(String newHdnSocRecFlag)
  {
    hdnSocRecFlag = newHdnSocRecFlag;
  }

  public String getTxtSocRecAmt()
  {
    return txtSocRecAmt;
  }

  public void setTxtSocRecAmt(String newTxtSocRecAmt)
  {
    txtSocRecAmt = newTxtSocRecAmt;
  }

  public String getTxtEpsFlag()
  {
    return txtEpsFlag;
  }

  public void setTxtEpsFlag(String newTxtEpsFlag)
  {
    txtEpsFlag = newTxtEpsFlag;
  }  

  public String getTxtEpsEntDt()
  {
    return txtEpsEntDt;
  }

  public void setTxtEpsEntDt(String newTxtEpsEntDt)
  {
    txtEpsEntDt = newTxtEpsEntDt;
  }  

  public String getTxtEpsSepRsn()
  {
    return txtEpsSepRsn;
  }

  public void setTxtEpsSepRsn(String newTxtEpsSepRsn)
  {
    txtEpsSepRsn = newTxtEpsSepRsn;
  }  

  public String getTxtEpsSepDt()
  {
    return txtEpsSepDt;
  }

  public void setTxtEpsSepDt(String newTxtEpsSepDt)
  {
    txtEpsSepDt = newTxtEpsSepDt;
  }
  
  public String getTxtPanNo()     
  {
    return txtPanNo;
  }
  public void setTxtPanNo(String newTxtPanNo)
  {
    txtPanNo = newTxtPanNo;
  }
  public String getTxtGangId()
  {
    return txtGangId;
  }
  public void setTxtGangId(String newTxtGangId)
  {
    txtGangId = newTxtGangId;
  }

  public String getTxtGangName()
  {
    return txtGangName;
  }
  public void setTxtGangName(String newTxtGangName)
  {
    txtGangName = newTxtGangName;
  }
     public String getTxtOldCpfCode()
  {
    return txtOldCpfCode;
  }
  public void setTxtOldCpfCode(String newTxtOldCpfCode)
  {
    txtOldCpfCode = newTxtOldCpfCode;
  }

    public void setTxtBankDesc(String newTxtBankDesc) {
        txtBankDesc = newTxtBankDesc;
    }

    public String getTxtBankDesc() {
        return txtBankDesc;
    }

    public void setTxtBranchDesc(String newTxtBranchDesc) {
        txtBranchDesc = newTxtBranchDesc;
    }

    public String getTxtBranchDesc() {
        return txtBranchDesc;
    }

    public void setTxtBankAccNo(String newTxtBankAccNo) {
        txtBankAccNo = newTxtBankAccNo;
    }

    public String getTxtBankAccNo() {
        return txtBankAccNo;
    }

    public void setTxtBankCode(String newTxtBankCode) {
          txtBankCode = newTxtBankCode;
    }

    public String getTxtBankCode() {
        return txtBankCode;
    }

    public void setTxtBranchCode(String newTxtBranchCode) {
          txtBranchCode = newTxtBranchCode;
    }

    public String getTxtBranchCode() {
        return txtBranchCode;
    }

    public void setTxtCPFIntEndDt(String txtCPFIntEndDt) {
        this.txtCPFIntEndDt = txtCPFIntEndDt;
    }

    public String getTxtCPFIntEndDt() {
        return txtCPFIntEndDt;
    }
}

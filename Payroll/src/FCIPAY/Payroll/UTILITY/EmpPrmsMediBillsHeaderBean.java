package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class EmpPrmsMediBillsHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{  
  private String txtClaimId;
  private String txtEmpNo;
  private String txtEmpName;
  private String txtClaimAmt;
  private String txtInvID;
  private String txtPayCode;
  private String txtDedIT;
  private String txtAgencyName = null;
  private String txtAgency = null;
  private String txtAgencySite = null;
  private String txtAgencySiteCode = null;
  private String hdnPayYYMM;
  private String txtRelShip;
  private String txtDpndntId;
  private String txtDpndntNam;
  private String txtBillDate;
  private String txtFileDate;
  private String txtRemark;
  private String txtBillAgst;
  private String txtITDedAmt;
  private String hdnITFlag;
  private String txtNetAmt;
  private String quarter; // added by devendra on 8th sept 2010
  private String finYear; // added by devendra on 8th sept 2010
  private String reqAlreadyRaised; // added by devendra on 8th sept 2010
  private String txtStartDate; // added by sonia on 17th nov 2010
  private String txtEndDate;// added by sonia on 17th nov 2010
  private String txtOpenBal;
  private String txtCeilAdj;
  private String txtCloseBal;
    private String txtSancDate;
    private String txtSancOrder;
  
  
  public EmpPrmsMediBillsHeaderBean()
  {
    
  }
  
  
  // added by devendra on 13th sept 2010 start
  public String getReqAlreadyRaised()
  {
    return reqAlreadyRaised;
  }

  public void setReqAlreadyRaised(String newTxtReqAlreadyRaised)
  {
    reqAlreadyRaised = newTxtReqAlreadyRaised;
  }  
  // added by devendra on 13th sept 2010 end
  
  
  // added by devendra on 8th sept 2010 start
   public String getFinYear()
  {
    return finYear;
  }

    public void setTxtSancDate(String txtSancDate) {
        this.txtSancDate = txtSancDate;
    }

    public String getTxtSancDate() {
        return txtSancDate;
    }

    public void setTxtSancOrder(String txtSancOrder) {
        this.txtSancOrder = txtSancOrder;
    }

    public String getTxtSancOrder() {
        return txtSancOrder;
    }

    public void setFinYear(String newTxtFinYear)
  {
    finYear = newTxtFinYear;
  }  
  
  
  public String getQuarter()
  {
    return quarter;
  }

  public void setQuarter(String newQuarter)
  {
    quarter = newQuarter;
  }  
  // added by devendra on 8th sept 2010 end
  
  
  
   public String getTxtNetAmt()
  {
    return txtNetAmt;
  }
  
  public void setTxtNetAmt(String newTxtNetAmt)
  {
    txtNetAmt = newTxtNetAmt;
  }
  
  
  public String getHdnITFlag()
  {
    return hdnITFlag;
  }

  public void setHdnITFlag(String newHdnITFlag)
  {
    hdnITFlag = newHdnITFlag;
  }
  
  
  public String getTxtITDedAmt()
  {
    return txtITDedAmt;
  }
  
  public void setTxtITDedAmt(String newTxtITDedAmt)
  {
    txtITDedAmt = newTxtITDedAmt;
  }
  
  
  public String getTxtClaimId()
  {
    return txtClaimId;
  }
  
  public void setTxtClaimId(String newTxtClaimId)
  {
    txtClaimId = newTxtClaimId;
  }
  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }
  
  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }  

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtClaimAmt()
  {
    return txtClaimAmt;
  }

  public void setTxtClaimAmt(String newTxtClaimAmt)
  {
    txtClaimAmt = newTxtClaimAmt;
  }
  
  public String getTxtInvID()
  {
    return txtInvID;
  }

  public void setTxtInvID(String newTxtInvID)
  {
    txtInvID = newTxtInvID;
  }
  

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtDedIT()
  {
    return txtDedIT;
  }

  public void setTxtDedIT(String newTxtDedIT)
  {
    txtDedIT = newTxtDedIT;
  }

  public String getTxtAgency()
  {
    return txtAgency;
  }

  public void setTxtAgency(String newTxtAgency)
  {
    txtAgency = newTxtAgency;
  }

  public String getTxtAgencyName()
  {
    return txtAgencyName;
  }

  public void setTxtAgencyName(String newTxtAgencyName)
  {
    txtAgencyName = newTxtAgencyName;
  }
  
  public String getTxtAgencySite()
  {
    return txtAgencySite;
  }

  public void setTxtAgencySite(String newTxtAgencySite)
  {
    txtAgencySite = newTxtAgencySite;
  }

  public String getTxtAgencySiteCode()
  {
    return txtAgencySiteCode;
  }

  public void setTxtAgencySiteCode(String newTxtAgencySiteCode)
  {
    txtAgencySiteCode = newTxtAgencySiteCode;
  }

  public String getHdnPayYYMM()
  {
    return hdnPayYYMM;
  }

  public void setHdnPayYYMM(String newHdnPayYYMM)
  {
    hdnPayYYMM = newHdnPayYYMM;
  }
  
  public String getTxtRelShip()
  {
    return txtRelShip;
  }

  public void setTxtRelShip(String newTxtRelShip)
  {
    txtRelShip = newTxtRelShip;
  }
  
  public String getTxtDpndntId()
  {
    return txtDpndntId;
  }

  public void setTxtDpndntId(String newTxtDpndntId)
  {
    txtDpndntId = newTxtDpndntId;
  }
  
  public String getTxtDpndntNam()
  {
    return txtDpndntNam;
  }

  public void setTxtDpndntNam(String newTxtDpndntNam)
  {
    txtDpndntNam = newTxtDpndntNam;
  }
  
  public String getTxtBillDate()
  {
    return txtBillDate;
  }

  public void setTxtBillDate(String newTxtBillDate)
  {
    txtBillDate = newTxtBillDate;
  }
  
  public String getTxtFileDate()
  {
    return txtFileDate;
  }

  public void setTxtFileDate(String newTxtFileDate)
  {
    txtFileDate = newTxtFileDate;
  }
  
  public String getTxtRemark()
  {
    return txtRemark;
  }

  public void setTxtRemark(String newTxtRemark)
  {
    txtRemark = newTxtRemark;
  }
  public String getTxtBillAgst()
  {
    return txtBillAgst;
  }

  public void setTxtBillAgst(String newTxtBillAgst)
  {
    txtBillAgst = newTxtBillAgst;
  }
  ///added by sonia on 17-11-2011
  public String getTxtStartDate()
  {
    return txtStartDate;
  }
  public void setTxtStartDate(String newTxtStartDate)
  {
    txtStartDate = newTxtStartDate;
  }
  public String getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  } 
  ///end///

    public void setTxtOpenBal(String txtOpenBal) {
        this.txtOpenBal = txtOpenBal;
    }

    public String getTxtOpenBal() {
        return txtOpenBal;
    }

    public void setTxtCeilAdj(String txtCeilAdj) {
        this.txtCeilAdj = txtCeilAdj;
    }

    public String getTxtCeilAdj() {
        return txtCeilAdj;
    }

    public void setTxtCloseBal(String txtCloseBal) {
        this.txtCloseBal = txtCloseBal;
    }

    public String getTxtCloseBal() {
        return txtCloseBal;
    }
}

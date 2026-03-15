package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class OTAPymntHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{  
  private String txtEmpNo;
  private String txtEmpName;
  private String txtDsgn;  
  private String txtDsgnDesc;
  private String txtCateg;  
  private String txtCategDesc; 
  private String txtEmpType;
  private String txtCpfCode;
  private String txtPresentPOP;
  private String txtPresentPOPDesc;
  private String txtDOJSite;
  private String txtEmpStatus;
  private String txtCurrBas;
  
  private String txtYYMM;
  private String txtDedIT;
  private String txtDedOthr;
  private String txtRmrks;
  private String txtNetAmt;
  private String txtPayModeType;
  private String txtGrossAmt;
  private String txtInvId;
  private String txtHrlyWage;
  private String hdnTotHrs;
  private String hdnFlagIT;
//  private boolean ceilFlag = false;
  private String ceilFlag;
  private String txtDedAmt;
  private String txtHdnNetAmt;
  
  public OTAPymntHeaderBean()
  {
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

  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtCategDesc()
  {
    return txtCategDesc;
  }

  public void setTxtCategDesc(String newTxtCategDesc)
  {
    txtCategDesc = newTxtCategDesc;
  }
  
  public String getTxtEmpType()
  {
    return txtEmpType;
  }

  public void setTxtEmpType(String newTxtEmpType)
  {
    txtEmpType = newTxtEmpType;
  }  

  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
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

  public String getTxtDOJSite()
  {
    return txtDOJSite;
  }

  public void setTxtDOJSite(String newTxtDOJSite)
  {
    txtDOJSite = newTxtDOJSite;
  }

  public String getTxtEmpStatus()
  {
    return txtEmpStatus;
  }

  public void setTxtEmpStatus(String newTxtEmpStatus)
  {
    txtEmpStatus = newTxtEmpStatus;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }  

  public String getTxtDedIT()
  {
    return txtDedIT;
  }

  public void setTxtDedIT(String newTxtDedIT)
  {
    txtDedIT = newTxtDedIT;
  }  

  public String getTxtDedOthr()
  {
    return txtDedOthr;
  }

  public void setTxtDedOthr(String newTxtDedOthr)
  {
    txtDedOthr = newTxtDedOthr;
  }  

  public String getTxtRmrks()
  {
    return txtRmrks;
  }

  public void setTxtRmrks(String newTxtRmrks)
  {
    txtRmrks = newTxtRmrks;
  }

  public String getTxtNetAmt()
  {
    return txtNetAmt;
  }

  public void setTxtNetAmt(String newTxtNetAmt)
  {
    txtNetAmt = newTxtNetAmt;
  }

  public String getTxtCurrBas()
  {
    return txtCurrBas;
  }

  public void setTxtCurrBas(String newTxtCurrBas)
  {
    txtCurrBas = newTxtCurrBas;
  }

  public String getTxtPayModeType()
  {
    return txtPayModeType;
  }

  public void setTxtPayModeType(String newTxtPayModeType)
  {
    txtPayModeType = newTxtPayModeType;
  }

  public String getTxtGrossAmt()
  {
    return txtGrossAmt;
  }

  public void setTxtGrossAmt(String newTxtGrossAmt)
  {
    txtGrossAmt = newTxtGrossAmt;
  }

  public String getTxtInvId()
  {
    return txtInvId;
  }

  public void setTxtInvId(String newTxtInvId)
  {
    txtInvId = newTxtInvId;
  }

  public String getTxtHrlyWage()
  {
    return txtHrlyWage;
  }

  public void setTxtHrlyWage(String newTxtHrlyWage)
  {
    txtHrlyWage = newTxtHrlyWage;
  }

  public String getHdnTotHrs()
  {
    return hdnTotHrs;
  }

  public void setHdnTotHrs(String newHdnTotHrs)
  {
    hdnTotHrs = newHdnTotHrs;
  }

  public String getHdnFlagIT()
  {
    return hdnFlagIT;
  }

  public void setHdnFlagIT(String newHdnFlagIT)
  {
    hdnFlagIT = newHdnFlagIT;
  }

  public String getCeilFlag()
  {
    return ceilFlag;
  }

  public void setCeilFlag(String newCeilFlag)
  {
    ceilFlag = newCeilFlag;
  }
  
  public String getTxtDedAmt()
  {
    return txtDedAmt;
  }

  public void setTxtDedAmt(String newTxtDedAmt)
  {
    txtDedAmt = newTxtDedAmt;
  }
  
  public String getTxtHdnNetAmt()
  {
    return txtHdnNetAmt;
  }

  public void setTxtHdnNetAmt(String newTxtHdnNetAmt)
  {
    txtHdnNetAmt = newTxtHdnNetAmt;
  }
    @Override
    public String toString() {
        return "OTAPymntHeaderBean{" +
                "txtEmpNo='" + txtEmpNo + '\'' +
                ", txtEmpName='" + txtEmpName + '\'' +
                ", txtDsgn='" + txtDsgn + '\'' +
                ", txtDsgnDesc='" + txtDsgnDesc + '\'' +
                ", txtCateg='" + txtCateg + '\'' +
                ", txtCategDesc='" + txtCategDesc + '\'' +
                ", txtEmpType='" + txtEmpType + '\'' +
                ", txtCpfCode='" + txtCpfCode + '\'' +
                ", txtPresentPOP='" + txtPresentPOP + '\'' +
                ", txtPresentPOPDesc='" + txtPresentPOPDesc + '\'' +
                ", txtDOJSite='" + txtDOJSite + '\'' +
                ", txtEmpStatus='" + txtEmpStatus + '\'' +
                ", txtCurrBas='" + txtCurrBas + '\'' +
                ", txtYYMM='" + txtYYMM + '\'' +
                ", txtDedIT='" + txtDedIT + '\'' +
                ", txtDedOthr='" + txtDedOthr + '\'' +
                ", txtRmrks='" + txtRmrks + '\'' +
                ", txtNetAmt='" + txtNetAmt + '\'' +
                ", txtPayModeType='" + txtPayModeType + '\'' +
                ", txtGrossAmt='" + txtGrossAmt + '\'' +
                ", txtInvId='" + txtInvId + '\'' +
                ", txtHrlyWage='" + txtHrlyWage + '\'' +
                ", hdnTotHrs='" + hdnTotHrs + '\'' +
                ", hdnFlagIT='" + hdnFlagIT + '\'' +
                ", ceilFlag='" + ceilFlag + '\'' +
                ", txtDedAmt='" + txtDedAmt + '\'' +
                ", txtHdnNetAmt='" + txtHdnNetAmt + '\'' +
                '}';
    }


}
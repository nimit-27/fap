package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class MaintEmpIncrBean extends PayrollBaseHeaderBean implements Serializable
{
  private String txtEmpNo;  
  private String txtEmpName;  
  private String txtStaffCode;
  private String txtDsgn;  
  private String txtDsgnDesc;
  private String txtCateg;  
  private String txtCategDesc; 
  private String txtPayScaleCode;
  private String txtCurtBasic;  
  private String txtPresentPOP;
  private String txtInrSt;
  private String txtPayStsChnDate="";  
  private String txtGradePay;
  
  private String txtAdvIncrType;
  private String txtAdvIncrAmnt;
  private String txtAdvIncrNo;
  private String txtAdvIncrEffDate;
  private String txtStopRls;
  private String incrAction;
  private String txtIncrEffDate;
  private String remarks; 
  private String txtIncrEffTill;
  private String txtIncrNo;
  private String txtIncrRlsEffDate;
    private String txtStagIncrAmt;
    private String txtStagEffDt;
      private String txtTabType;
      private String forwardedPage;
  
  
  public MaintEmpIncrBean()
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
  
  public String getTxtStaffCode()
  {
    return txtStaffCode;
  }

  public void setTxtStaffCode(String newTxtStaffCode)
  {
    txtStaffCode = newTxtStaffCode;
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
  
  public String setTxtDsgnDesc()
  {
    return txtDsgnDesc;
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
  
  public String getTxtPayScaleCode()
  {
    return txtPayScaleCode;
  }

  public void setTxtPayScaleCode(String newTxtPayScaleCode)
  {
    txtPayScaleCode = newTxtPayScaleCode;
  }
  
  public String getTxtCurtBasic()
  {
    return txtCurtBasic;
  }

  public void setTxtCurtBasic(String newTxtCurtBasic)
  {
    txtCurtBasic = newTxtCurtBasic;
  }
  
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  public String getTxtInrSt()
  {
    return txtInrSt;
  }

  public void setTxtInrSt(String newTxtInrSt)
  {
    txtInrSt = newTxtInrSt;
  }
  
  public String getTxtPayStsChnDate()
  {
    return txtPayStsChnDate;
  }

  public void setTxtPayStsChnDate(String newTxtPayStsChnDate)
  {
    txtPayStsChnDate = newTxtPayStsChnDate;
  }
  
  public String getTxtAdvIncrType()
  {
    return txtAdvIncrType;
  }

  public void setTxtAdvIncrType(String newTxtAdvIncrType)
  {
    txtAdvIncrType = newTxtAdvIncrType;
  }
  
  public String getTxtAdvIncrAmnt()
  {
    return txtAdvIncrAmnt;
  }

  public void setTxtAdvIncrAmnt(String newTxtAdvIncrAmnt)
  {
    txtAdvIncrAmnt = newTxtAdvIncrAmnt;
  }
  
  public String getTxtAdvIncrNo()
  {
    return txtAdvIncrNo;
  }

  public void setTxtAdvIncrNo(String newTxtAdvIncrNo)
  {
    txtAdvIncrNo = newTxtAdvIncrNo;
  }
  
  public String getTxtAdvIncrEffDate()
  {
    return txtAdvIncrEffDate;
  }

  public void setTxtAdvIncrEffDate(String newTxtAdvIncrEffDate)
  {
    txtAdvIncrEffDate = newTxtAdvIncrEffDate;
  }
  
  public String getTxtStopRls()
  {
    return txtStopRls;
  }

  public void setTxtStopRls(String newTxtStopRls)
  {
    txtStopRls = newTxtStopRls;
  }
  
  public String getIncrAction()
  {
    return incrAction;
  }

  public void setIncrAction(String newIncrAction)
  {
    incrAction = newIncrAction;
  }
  
  public String getTxtIncrEffDate()
  {
    return txtIncrEffDate;
  }

  public void setTxtIncrEffDate(String newTxtIncrEffDate)
  {
    txtIncrEffDate = newTxtIncrEffDate;
  }
  
  public String getRemarks()
  {
    return remarks;
  }

  public void setRemarks(String newRemarks)
  {
    remarks = newRemarks;
  }
  public String getTxtIncrEffTill()
  {
    return txtIncrEffTill;
  }

  public void setTxtIncrEffTill(String newTxtIncrEffTill)
  {
    txtIncrEffTill = newTxtIncrEffTill;
  }  
  
  public String getTxtIncrNo()
  {
    return txtIncrNo;
  }

  public void setTxtIncrNo(String newTxtIncrNo)
  {
    txtIncrNo = newTxtIncrNo;
  }  

  public String getTxtIncrRlsEffDate()
  {
    return txtIncrRlsEffDate;
  }

  public void setTxtIncrRlsEffDate(String newTxtIncrRlsEffDate)
  {
    txtIncrRlsEffDate = newTxtIncrRlsEffDate;
  }
  /*added  by yogesh on 2 aug 2010*/
  
  public String getTxtGradePay()
  {
    return txtGradePay;
  
  }

  public void setTxtGradePay(String newTxtGradePay)
  {
    txtGradePay = newTxtGradePay;
  }

    public void setTxtStagIncrAmt(String txtStagIncrAmt) {
        this.txtStagIncrAmt = txtStagIncrAmt;
    }

    public String getTxtStagIncrAmt() {
        return txtStagIncrAmt;
    }

    public void setTxtStagEffDt(String txtStagEffDt) {
        this.txtStagEffDt = txtStagEffDt;
    }

    public String getTxtStagEffDt() {
        return txtStagEffDt;
    }

    public void setTxtTabType(String txtTabType) {
        this.txtTabType = txtTabType;
    }

    public String getTxtTabType() {
        return txtTabType;
    }

    public void setForwardedPage(String forwardedPage) {
        this.forwardedPage = forwardedPage;
    }

    public String getForwardedPage() {
        return forwardedPage;
    }
}

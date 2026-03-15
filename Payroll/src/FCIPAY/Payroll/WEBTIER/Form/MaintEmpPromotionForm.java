package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintEmpPromotionForm extends PayrollBaseForm
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
  private String txtCurtBasic;
  private String txtPrvPromDate;
  private String txtPayType;
  private String txtPersPaySFNAmt;  
  private String txtPerPayHighQual;
  private String txtPerPayAdvIncr;
  private String txtStagInc;
  private String perPayFutureIncr;
  private String txtGradePay; // added by sonia on 08-04-2011
  private String txtPayScaleType;  // added by sonia on 08-04-2011
  private String newPayScaleCode;  // added by sonia on 08-04-2011
  private String newGradePay; // added by sonia on 08-04-2011
  
  private String promType;
  private String newDsgn;  
  private String newDsgnDesc;
  private String newBasic;  
  private String newCateg;  
  private String newCategDesc;  
  private String payScaleCode;  
  private String payScaleCodeDesc;
  private String hdnStartBasic;
  private String hdnEndBasic; 
  private String newPerPayHighQual;
  private String newPerPayFutIncr;
  private String newStagInc;
  private String newPromEffDate;  
  private String adhcPromEndDate; 
  private String remarks;     
  private String newPromoBasic;  //added by jatin 29-08-2012
  private String retdscreenName;
  private String txtKotwalLabour;

  
  public MaintEmpPromotionForm()
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
  
  public String getTxtCurtBasic()
  {
    return txtCurtBasic;
  }

  public void setTxtCurtBasic(String newTxtCurtBasic)
  {
    txtCurtBasic = newTxtCurtBasic;
  }
  
  public String getTxtPrvPromDate()
  {
    return txtPrvPromDate;
  }

  public void setTxtPrvPromDate(String newTxtPrvPromDate)
  {
    txtPrvPromDate = newTxtPrvPromDate;
  }
  
   public String getTxtPayType()
  {
    return txtPayType;
  }

  public void setTxtPayType(String newTxtPayType)
  {
    txtPayType = newTxtPayType;
  }


  public String getPromType()
  {
    return promType;
  }

  public void setPromType(String newPromType)
  {
    promType = newPromType;
  }
 
 public String getNewDsgn()
  {
    return newDsgn;
  }
  public void setNewDsgn(String newNewDsgn)
  {
    newDsgn = newNewDsgn;
  }
  
  public String getNewDsgnDesc()
  {
    return newDsgnDesc;
  }
  
  public void setNewDsgnDesc(String newNewDsgnDesc)
  {
    newDsgnDesc = newNewDsgnDesc;
  }
  
  public String getNewBasic()
  {
    return newBasic;
  }

  public void setNewBasic(String newNewBasic)
  {
    newBasic = newNewBasic;
  }
  
  public String getNewPromEffDate()
  {
    return newPromEffDate;
  }

  public void setNewPromEffDate(String newNewPromEffDate)
  {
    newPromEffDate = newNewPromEffDate;
  }
  
  public String getRemarks()
  {
    return remarks;
  }

  public void setRemarks(String newRemarks)
  {
    remarks = newRemarks;
  }
  
  public String getNewCateg()
  {
    return newCateg;
  }

  public void setNewCateg(String newNewCateg)
  {
    newCateg = newNewCateg;
  }
  
  public String getNewCategDesc()
  {
    return newCategDesc;
  }

  public void setNewCategDesc(String newNewCategDesc)
  {
    newCategDesc = newNewCategDesc;
  }
  
  public String getPayScaleCode()
  {
    return payScaleCode;
  }

  public void setPayScaleCode(String newPayScaleCode)
  {
    payScaleCode = newPayScaleCode;
  }
  
  public String getPayScaleCodeDesc()
  {
    return payScaleCodeDesc;
  }

  public void setPayScaleCodeDesc(String newPayScaleCodeDesc)
  {
    payScaleCodeDesc = newPayScaleCodeDesc;
  }  
  
  public String getHdnStartBasic()
  {
    return hdnStartBasic;
  }

  public void setHdnStartBasic(String newHdnStartBasic)
  {
    hdnStartBasic = newHdnStartBasic;
  }
  
  public String getHdnEndBasic()
  {
    return hdnEndBasic;
  }

  public void setHdnEndBasic(String newHdnEndBasic)
  {
    hdnEndBasic = newHdnEndBasic;
  }
  
  public String getNewPerPayHighQual()
  {
    return newPerPayHighQual;
  }

  public void setNewPerPayHighQual(String newNewPerPayHighQual)
  {
    newPerPayHighQual = newNewPerPayHighQual;
  }
  
  public String getNewPerPayFutIncr()
  {
    return newPerPayFutIncr;
  }

  public void setNewPerPayFutIncr(String newNewPerPayFutIncr)
  {
    newPerPayFutIncr = newNewPerPayFutIncr;
  }
  
   public String getNewStagInc()
  {
    return newStagInc;
  }

  public void setNewStagInc(String newNewStagInc)
  {
    newStagInc = newNewStagInc;
  }
  
  public String getTxtPersPaySFNAmt()
  {
    return txtPersPaySFNAmt;
  }

  public void setTxtPersPaySFNAmt(String newTxtPersPaySFNAmt)
  {
    txtPersPaySFNAmt = newTxtPersPaySFNAmt;
  } 
  
  public String getTxtPerPayHighQual()
  {
    return txtPerPayHighQual;
  }

  public void setTxtPerPayHighQual(String newTxtPerPayHighQual)
  {
    txtPerPayHighQual = newTxtPerPayHighQual;
  }
  
   public String getTxtPerPayAdvIncr()
  {
    return txtPerPayAdvIncr;
  }

  public void setTxtPerPayAdvIncr(String newTxtPerPayAdvIncr)
  {
    txtPerPayAdvIncr = newTxtPerPayAdvIncr;
  } 
  
  public String getTxtStagInc()
  {
    return txtStagInc;
  }

  public void setTxtStagInc(String newTxtStagInc)
  {
    txtStagInc = newTxtStagInc;
  }
  
  public String getPerPayFutureIncr()
  {
    return perPayFutureIncr;
  }

  public void setPerPayFutureIncr(String newPerPayFutureIncr)
  {
    perPayFutureIncr = newPerPayFutureIncr;
  }
  
  public String getAdhcPromEndDate()
  {
    return adhcPromEndDate;
  }

  public void setAdhcPromEndDate(String newAdhcPromEndDate)
  {
    adhcPromEndDate = newAdhcPromEndDate;
  }
  
  //added by sonia on 08-04-2011
  public String getTxtGradePay()
  {
    return txtGradePay;
  }

  public void setTxtGradePay(String newGradePay)
  {
    txtGradePay = newGradePay;
  }
 
  public String getTxtPayScaleType()
  {
    return txtPayScaleType;
  }

  public void setTxtPayScaleType(String newPayScaleType)
  {
    txtPayScaleType = newPayScaleType;
  }

   public String getNewPayScaleCode()
  {
    return newPayScaleCode;
  }

  public void setNewPayScaleCode(String newPayScaleCode1)
  {
    newPayScaleCode = newPayScaleCode1;
  }


   public String getNewGradePay()
  {
    return newGradePay;
  }

  public void setNewGradePay(String newGradePay1)
  {
    newGradePay = newGradePay1;
  }


 // end added by sonia on 08-04-2011  newGradePay
 public String getNewPromoBasic()
  {
    return newPromoBasic;
  }

  public void setNewPromoBasic(String newNewPromoBasic)
  {
    newPromoBasic = newNewPromoBasic;
  }
    public String getRetdscreenName()
  {
    return retdscreenName;
  }

  public void setRetdscreenName(String newRetdscreenName)
  {
    retdscreenName = newRetdscreenName;
  }
  
  public String getTxtKotwalLabour()
  {
    return txtKotwalLabour;
  }



  
  public void setTxtKotwalLabour(String newTxtKotwalLabour)
  {
    txtKotwalLabour = newTxtKotwalLabour;
  }

 //added by jatin on 29-08-2012
}
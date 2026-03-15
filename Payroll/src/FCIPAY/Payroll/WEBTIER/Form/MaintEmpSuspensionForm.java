package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintEmpSuspensionForm extends PayrollBaseForm
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
  
  private String suspId;
  private String suspEffDate;
  private String suspReason;  
  private String subsAllow;
  private String subsEffDate; 
  private String revSubsAllow;
  private String revSubsEffDate;  
  
  private String revokeType;
  private String revokeDate;    
  
  private String txtYYMM;   
  private String txtInvNum; 
  private String radFlg;
  
  public MaintEmpSuspensionForm()
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

  public String getSuspId()
  {
    return suspId;
  }

  public void setSuspId(String newSuspId)
  {
    suspId = newSuspId;
  }
  
   public String getSuspEffDate()
  {
    return suspEffDate;
  }

  public void setSuspEffDate(String newSuspEffDate)
  {
    suspEffDate = newSuspEffDate;
  }
 
 public String getSuspReason()
  {
    return suspReason;
  }
  public void setSuspReason(String newSuspReason)
  {
    suspReason = newSuspReason;
  }
  
  public String getSubsAllow()
  {
    return subsAllow;
  }
  
  public void setSubsAllow(String newSubsAllow)
  {
    subsAllow = newSubsAllow;
  }
  
  public String getSubsEffDate()
  {
    return subsEffDate;
  }

  public void setSubsEffDate(String newSubsEffDate)
  {
    subsEffDate = newSubsEffDate;
  } 
  
  public String getRevokeType()
  {
    return revokeType;
  }

  public void setRevokeType(String newRevokeType)
  {
    revokeType = newRevokeType;
  } 
  
  public String getRevokeDate()
  {
    return revokeDate;
  }

  public void setRevokeDate(String newRevokeDate)
  {
    revokeDate = newRevokeDate;
  } 
  
  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  } 
  
  public String getRevSubsAllow()
  {
    return revSubsAllow;
  }
  
  public void setRevSubsAllow(String newRevSubsAllow)
  {
    revSubsAllow = newRevSubsAllow;
  }
  
  public String getRevSubsEffDate()
  {
    return revSubsEffDate;
  }

  public void setRevSubsEffDate(String newRevSubsEffDate)
  {
    revSubsEffDate = newRevSubsEffDate;
  }
  
  public String getTxtInvNum()
  {
    return txtInvNum;
  }

  public void setTxtInvNum(String newTxtInvNum)
  {
    txtInvNum = newTxtInvNum;
  } 

  public String getRadFlg()
  {
    return radFlg;
  }

  public void setRadFlg(String newRadFlg)
  {
    radFlg = newRadFlg;
  } 

}
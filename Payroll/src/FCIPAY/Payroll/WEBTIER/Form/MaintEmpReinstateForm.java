package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class MaintEmpReinstateForm extends PayrollBaseForm
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
  
  private String reinstId;
  private String reinstEffDate;
  private String reinstReason;  
  private String intervngPrd;
  
  
  
  public MaintEmpReinstateForm()
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
  
  
  public String getReinstId()
  {
    return reinstId;
  }

  public void setReinstId(String newReinstId)
  {
    reinstId = newReinstId;
  }
  
   public String getReinstEffDate()
  {
    return reinstEffDate;
  }

  public void setReinstEffDate(String newReinstEffDate)
  {
    reinstEffDate = newReinstEffDate;
  }
 
 public String getReinstReason()
  {
    return reinstReason;
  }
  public void setReinstReason(String newReinstReason)
  {
    reinstReason = newReinstReason;
  }
  
  public String getIntervngPrd()
  {
    return intervngPrd;
  }
  
  public void setIntervngPrd(String newIntervngPrd)
  {
    intervngPrd = newIntervngPrd;
  }
  
  
}
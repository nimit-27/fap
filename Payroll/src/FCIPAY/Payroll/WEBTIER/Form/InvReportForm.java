package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class InvReportForm extends PayrollBaseForm 
{
  
  
  private String txtEmp;  
  private String txtEmpName;  
  private String txtInvNum;
  private String txtPayCode;
  private String txtDescription;
  private String txtStartDate; 
  private String txtEndDate;
    private String hdnPayUser;
  private String hdnLoginUserId;
  private String hdnLoginUserName;
  private String txtAllEmpFlag;
  private String txtCpfCode; 
  

  public InvReportForm()
  {
  }

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
  
  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode= newTxtPayCode;
  }  

  public String getTxtDescription()
  {
    return txtDescription;
  }

  public void setTxtDescription(String newTxtDescription)
  {
    txtDescription= newTxtDescription;
  }  
   public String getTxtInvNum()
  {
    return txtInvNum;
  }

  public void setTxtInvNum(String newTxtInvNum)
  {
    txtInvNum= newTxtInvNum;
  } 
public String getTxtEmp()
  {
    return txtEmp;
  }

  public void setTxtEmp(String newTxtEmp)
  {
    txtEmp = newTxtEmp;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }
  
   public String getHdnPayUser()
  {
    return hdnPayUser;
  }

  public void setHdnPayUser(String newHdnPayUser)
  {
    hdnPayUser = newHdnPayUser;
  }

  public String getHdnLoginUserId()
  {
    return hdnLoginUserId;
  }

  public void setHdnLoginUserId(String newHdnLoginUserId)
  {
    hdnLoginUserId = newHdnLoginUserId;
  }

  public String getHdnLoginUserName()
  {
    return hdnLoginUserName;
  }

  public void setHdnLoginUserName(String newHdnLoginUserName)
  {
    hdnLoginUserName = newHdnLoginUserName;
  }
  public String getTxtAllEmpFlag()
  {
    return txtAllEmpFlag;
  }

  public void setTxtAllEmpFlag(String newTxtAllEmpFlag)
  {
    txtAllEmpFlag = newTxtAllEmpFlag;
  }
  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }
}
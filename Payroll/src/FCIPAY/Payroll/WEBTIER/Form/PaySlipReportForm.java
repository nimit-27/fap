package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class PaySlipReportForm extends PayrollBaseForm
{
  private String txtYYMM;
  private String optSelect;
  private String hdnPayUser;
  private String hdnLoginUserId;
  private String hdnLoginUserName;
  private String PaySlipLocationForm;
  private String txtAllEmpFlag;
  private String txtEmp;
  private String txtEmpName;
  private String txtCpfCode;   //Added By Swapnendu Dt 16/08/2010.
  private String hdnMaxYYMM;
  private String txtLocId;
  private String txtGangId;
  private String txtGangName;
  private String txtType;
  private String txtMou;

  private String txtLoc;   //added by jatin dt 19/07/2012

  public PaySlipReportForm()
  {
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }
  
   public String getTxtMou()
  {
    return txtMou;
  }

  public void setTxtMou(String newTxtMou)
  {
    txtMou = newTxtMou;
  }

 public String getTxtType()
  {
    return txtType;
  }

  public void setTxtType(String newTxtType)
  {
    txtType = newTxtType;
  }
public String getTxtGangName()
  {
    return txtGangName;
  }

  public void setTxtGangName(String newTxtGangName)
  {
    txtGangName = newTxtGangName;
  }

  public String getTxtGangId()
  {
    return txtGangId;
  }

  public void setTxtGangId(String newTxtGangId)
  {
    txtGangId = newTxtGangId;
  }
  public String getOptSelect()
  {
    return optSelect;
  }

  public void setOptSelect(String newOptSelect)
  {
    optSelect = newOptSelect;
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

  public String getPaySlipLocationForm()
  {
    return PaySlipLocationForm;
  }

  public void setPaySlipLocationForm(String newPaySlipLocationForm)
  {
    PaySlipLocationForm = newPaySlipLocationForm;
  }

  public String getTxtAllEmpFlag()
  {
    return txtAllEmpFlag;
  }

  public void setTxtAllEmpFlag(String newTxtAllEmpFlag)
  {
    txtAllEmpFlag = newTxtAllEmpFlag;
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

  public String getTxtCpfCode()
  {
    return txtCpfCode;
  }

  public void setTxtCpfCode(String newTxtCpfCode)
  {
    txtCpfCode = newTxtCpfCode;
  }

  public String getHdnMaxYYMM()
  {
    return hdnMaxYYMM;
  }

  public void setHdnMaxYYMM(String newHdnMaxYYMM)
  {
    hdnMaxYYMM = newHdnMaxYYMM;
  }
   public String getTxtLoc()
  {
    return txtLoc;
  }

  public void setTxtLoc(String newTxtLoc)
  {
    txtLoc = newTxtLoc;
  }
  
  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
  }

}
package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class AttendnceSummRepForm extends PayrollBaseForm
{
  private String txtYYMM;
  private String optSelect;
  private String hdnPayUser;
  private String hdnLoginUserId;
  private String hdnLoginUserName;
  private String PaySlipLocationForm;
  private String txtAllEmpFlag;  
  private String txtSiteCode;  
  private String txtSiteDesc;
  private String txtUserFlag; 
  private String txtDepotId; 
  private String txtDepotName; 
  private String txtGangId;
  private String txtGangName;
  
   public AttendnceSummRepForm()
  {
  }

  public String getTxtSiteCode()
  {
    return txtSiteCode;
  }

  public void setTxtSiteCode(String TxtSiteCode)
  {
    txtSiteCode = TxtSiteCode;
  }
  public String getTxtSiteDesc()
  {
    return txtSiteDesc;
  }

  public void setTxtSiteDesc(String TxtSiteDesc)
  {
    txtSiteDesc = TxtSiteDesc;
  }
  
   public String getTxtUserFlag()
  {
    return txtUserFlag;
  }

  public void setTxtUserFlag(String txtUserFlag)
  {
    txtUserFlag = txtUserFlag;
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
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
   public String getTxtDepotId()
  {
    return txtDepotId;
  }

  public void setTxtDepotId(String newTxtDepotId)
  {
    txtDepotId = newTxtDepotId;
  }
   public String getTxtDepotName()
  {
    return txtDepotName;
  }

  public void setTxtDepotName(String newTxtDepotName)
  {
    txtDepotName = newTxtDepotName;
  }
  /////
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
  /*
   pkg_pay_labour.proc_getloc_id -- location_id out loc_id loc_desc
pkg_pay_labour.proc_getgang_name -- loc_id out ref cursor
*/
}
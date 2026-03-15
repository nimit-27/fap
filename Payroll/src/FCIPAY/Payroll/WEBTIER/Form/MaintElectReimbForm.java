package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MaintElectReimbForm extends  PayrollBaseForm 
{
  private String txtEffectDate;
  private String[] txtAllow;
  private String screenModeElecReimb;
  private String hdnSrlNo[];
  private ArrayList lstInstrDtls = new ArrayList();  

  public MaintElectReimbForm()
  {
  }

  public String getTxtEffectDate()
  {
    return txtEffectDate;
  }

  public void setTxtEffectDate(String newTxtEffectDate)
  {
    txtEffectDate = newTxtEffectDate;
  }

  public String[] getTxtAllow()
  {
    return txtAllow;
  }

  public void setTxtAllow(String[] newTxtAllow)
  {
    txtAllow = newTxtAllow;
  }

  public String getScreenModeElecReimb()
  {
    return screenModeElecReimb;
  }

  public void setScreenModeElecReimb(String newScreenModeElecReimb)
  {
    screenModeElecReimb = newScreenModeElecReimb;
  }

  public String[] getHdnSrlNo()
  {
    return hdnSrlNo;
  }

  public void setHdnSrlNo(String[] newHdnSrlNo)
  {
    hdnSrlNo = newHdnSrlNo;
  }

    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls = newLstInstrDtls;
    }
  
}
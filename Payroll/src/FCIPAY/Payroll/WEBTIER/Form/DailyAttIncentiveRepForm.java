package FCIPAY.Payroll.WEBTIER.Form;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class DailyAttIncentiveRepForm extends PayrollBaseForm
{
  private String txtWrkSlipDt;  
  private String location;
  private String hdnGangId;
  private String txtGangName;    
  private String hdnMou;
  private String txtLbrType;
  

  public DailyAttIncentiveRepForm()
  {
  }

  public String getTxtWrkSlipDt()
  {
    return txtWrkSlipDt;
  }

  public void setTxtWrkSlipDt(String newTxtWrkSlipDt)
  {
    txtWrkSlipDt = newTxtWrkSlipDt;
  }  
  
  public String getLocation()
  {
    return location;
  }

  public void setLocation(String newLocation)
  {
    location= newLocation;
  } 

  public String getHdnGangId()
    {
      return hdnGangId;
    }
    
    public void setHdnGangId(String newHdnGangId)
    {
      hdnGangId=newHdnGangId;
    }
    
    public String getTxtGangName()
    {
      return txtGangName;
    }
    
    public void setTxtGangName(String newTxtGangName)
    {
      txtGangName=newTxtGangName;
    }
    
    public String getHdnMou()
    {
      return hdnMou;
    }
    
    public void setHdnMou(String newHdnMou)
    {
      hdnMou=newHdnMou;
    }
    
    public String getTxtLbrType()
    {
      return txtLbrType;
    }
    
    public void setTxtLbrType(String newTxtLbrType)
    {
      txtLbrType=newTxtLbrType;
    }


}
package FCIPAY.Payroll.Labour.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class CalcDpsWrkDoneForm   extends PayrollBaseForm 
{
  private String butAction;
  private String hdnAction;
  private String txtGangName;
  private String txtGangId;
  private String txtLoc;
  private String txtLocId;
  private String txtLbrTyp;
  private String txtFrom;
  private String txtTo;
  private String screenFlag;
  private String txtInvType;

  public CalcDpsWrkDoneForm()
  {
  }

  public String getButAction()
  {
    return butAction;
  }

  public void setButAction(String newButAction)
  {
    butAction = newButAction;
  }

  public String getHdnAction()
  {
    return hdnAction;
  }

  public void setHdnAction(String newHdnAction)
  {
    hdnAction = newHdnAction;
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

  public String getTxtLbrTyp()
  {
    return txtLbrTyp;
  }

  public void setTxtLbrTyp(String newTxtLbrTyp)
  {
    txtLbrTyp = newTxtLbrTyp;
  }

  public String getTxtFrom()
  {
    return txtFrom;
  }

  public void setTxtFrom(String newTxtFrom)
  {
    txtFrom = newTxtFrom;
  }

  public String getTxtTo()
  {
    return txtTo;
  }

  public void setTxtTo(String newTxtTo)
  {
    txtTo = newTxtTo;
  }

  public String getScreenFlag()
  {
    return screenFlag;
  }

  public void setScreenFlag(String newScreenFlag)
  {
    screenFlag = newScreenFlag;
  }

  public String getTxtInvType()
  {
    return txtInvType;
  }

  public void setTxtInvType(String newTxtInvType)
  {
    txtInvType = newTxtInvType;
  }
}
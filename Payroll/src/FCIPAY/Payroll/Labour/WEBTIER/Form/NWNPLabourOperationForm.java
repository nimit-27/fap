package FCIPAY.Payroll.Labour.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class NWNPLabourOperationForm extends PayrollBaseForm
{
  private String [] txtLocCode;
  private String txtLocName;
  private String [] txtOperation;
  private String txtEffDate;
  private String txtEndDate;  
  private ArrayList lstInstrDtls= new ArrayList();
  private String effStartDate;
  private String screenModeSOR;
  private String screenModeSOR1;
  private String screenModeSOR2;
  

  public NWNPLabourOperationForm()
  {
  }
  
  public String getScreenModeSOR()
  {
    return screenModeSOR;
  }

  public void setScreenModeSOR(String newScreenModeSOR)
  {
    screenModeSOR = newScreenModeSOR;
  } 
  public String getScreenModeSOR1()
  {
    return screenModeSOR1;
  }

  public void setScreenModeSOR1(String newScreenModeSOR1)
  {
    screenModeSOR1 = newScreenModeSOR1;
  } 
  public String getScreenModeSOR2()
  {
    return screenModeSOR2;
  }

  public void setScreenModeSOR2(String newScreenModeSOR2)
  {
    screenModeSOR2 = newScreenModeSOR2;
  } 

  public String [] getTxtLocCode()
  {
    return txtLocCode;
  }

  public void setTxtLocCode(String [] newTxtLocCode)
  {
    txtLocCode = newTxtLocCode;
  } 
  
   public String getTxtLocName()
  {
    return txtLocName;
  }

  public void setTxtLocName(String newTxtLocName)
  {
    txtLocName = newTxtLocName;
  } 
  
  public String [] getTxtOperation()
  {
    return txtOperation;
  }

  public void setTxtOperation(String [] newTxtOperation)
  {
    txtOperation = newTxtOperation;
  } 
  
  public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }
  
  public String getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  } 
  
  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
  
  public String getEffStartDate()
  {
    return effStartDate;
  }

  public void setEffStartDate(String newEffStartDate)
  {
    effStartDate = newEffStartDate;
  }
  
}



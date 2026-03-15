package FCIPAY.Payroll.Labour.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class DpsLabourASORInfoForm extends PayrollBaseForm
{
  private String txtPieceRate;
  private String txtMgwSardar;
  private String txtMgwMandal;
  private String txtMgwAncllry;
  private String txtMgwHndlng;
  private String txtEffDate;
  private String txtEndDate;  
  private String txtASORRevision;
  private String txtyyyymm;
  
  public DpsLabourASORInfoForm()
  {
  }

  public String getTxtPieceRate()
  {
    return txtPieceRate;
  }

  public void setTxtPieceRate(String newTxtPieceRate)
  {
    txtPieceRate = newTxtPieceRate;
  }  
  
  public String getTxtMgwMandal()
  {
    return txtMgwMandal;
  }

  public void setTxtMgwMandal(String newTxtMgwMandal)
  {
    txtMgwMandal = newTxtMgwMandal;
  } 
  
  public String getTxtMgwSardar()
  {
    return txtMgwSardar;
  }

  public void setTxtMgwSardar(String newTxtMgwSardar)
  {
    txtMgwSardar = newTxtMgwSardar;
  }
  
  public String getTxtMgwAncllry()
  {
    return txtMgwAncllry;
  }

  public void setTxtMgwAncllry(String newTxtMgwAncllry)
  {
    txtMgwAncllry = newTxtMgwAncllry;
  }
  
  public String getTxtMgwHndlng()
  {
    return txtMgwHndlng;
  }

  public void setTxtMgwHndlng(String newTxtMgwHndlng)
  {
    txtMgwHndlng = newTxtMgwHndlng;
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
  
    public String getTxtASORRevision()
  {
    return txtASORRevision;
  }

  public void setTxtASORRevision(String newTxtASORRevision)
  {
    txtASORRevision = newTxtASORRevision;
  } 
  
    public String getTxtyyyymm()
  {
    return txtyyyymm;
  }

  public void setTxtyyyymm(String newTxtyyyymm)
  {
    txtyyyymm = newTxtyyyymm;
  } 
  
}



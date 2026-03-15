package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class DpsLabourASORHeaderBean extends PayrollBaseHeaderBean implements Serializable  
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
  
  public DpsLabourASORHeaderBean()
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
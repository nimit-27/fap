package FCIPAY.Payroll.Labour.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class NWNPLabourSORInfoForm extends PayrollBaseForm
{
  private String [] txtLocCode;
  private String txtLocName;
  private String [] txtOperation;
  private String [] txtBagRateAbv65;
  private String [] txtBagRateBlw65;  
  private String txtEffDate;
  private String txtEndDate;  
  private ArrayList lstInstrDtls= new ArrayList();
  private String txtRegCode;  
  private String txtRegName;  
  private String effStartDate;
  private String screenModeSOR;
  private String screenModeSOR1;
  private String screenModeSOR2;
  private String txtLocation; 
  private String txtLocId;
  private String [] txtBaseYr;
  private String [] txtSorRateUpto50;
  private String [] txtSorRateUpto75;
  private String [] txtSorRateabove75;
  private String [] txtPieceWiseRate;
  public NWNPLabourSORInfoForm()
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
  
  public String [] getTxtBagRateAbv65()
  {
    return txtBagRateAbv65;
  }

  public void setTxtBagRateAbv65(String [] newTxtBagRateAbv65)
  {
    txtBagRateAbv65 = newTxtBagRateAbv65;
  }
  
  public String [] getTxtBagRateBlw65()
  {
    return txtBagRateBlw65;
  }

  public void setTxtBagRateBlw65(String [] newTxtBagRateBlw65)
  {
    txtBagRateBlw65 = newTxtBagRateBlw65;
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
  
  public String getTxtRegCode()
  {
    return txtRegCode;
  }

  public void setTxtRegCode(String newTxtRegCode)
  {
    txtRegCode = newTxtRegCode;
  } 
  
  public String getTxtRegName()
  {
    return txtRegName;
  }

  public void setTxtRegName(String newTxtRegName)
  {
    txtRegName = newTxtRegName;
  } 
  
  public String getEffStartDate()
  {
    return effStartDate;
  }

  public void setEffStartDate(String newEffStartDate)
  {
    effStartDate = newEffStartDate;
  }
    public String getTxtLocation()
    {
      return txtLocation;
    }

    public void setTxtLocation(String newTxtLocation)
    {
      txtLocation = newTxtLocation;
    }

    public String getTxtLocId()
    {
      return txtLocId;
    }

    public void setTxtLocId(String newTxtLocId)
    {
      txtLocId = newTxtLocId;
    }
    public String [] getTxtBaseYr()
    {
      return txtBaseYr;
    }

    public void setTxtBaseYr(String [] newTxtBaseYr)
    {
      txtBaseYr = newTxtBaseYr;
    }
    public String [] getTxtSorRateUpto50()
    {
      return txtSorRateUpto50;
    }

    public void setTxtSorRateUpto50(String [] newTxtSorRateUpto50)
    {
      txtSorRateUpto50 = newTxtSorRateUpto50;
    }
    public String [] getTxtSorRateUpto75()
    {
      return txtSorRateUpto75;
    }

    public void setTxtSorRateUpto75(String [] newTxtSorRateUpto75)
    {
      txtSorRateUpto75 = newTxtSorRateUpto75;
    }
    public String [] getTxtSorRateabove75()
    {
      return txtSorRateabove75;
    }

    public void setTxtSorRateabove75(String [] newTxtSorRateabove75)
    {
      txtSorRateabove75 = newTxtSorRateabove75;
    }
    public String [] getTxtPieceWiseRate()
    {
      return txtPieceWiseRate;
    }

    public void setTxtPieceWiseRate(String [] newTxtPieceWiseRate)
    {
      txtPieceWiseRate = newTxtPieceWiseRate;
    }  
}


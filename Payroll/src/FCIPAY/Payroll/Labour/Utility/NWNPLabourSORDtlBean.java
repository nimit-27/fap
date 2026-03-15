package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class NWNPLabourSORDtlBean extends PayrollBaseDetailBean implements Serializable  
{
  //private String txtRegCode=""; 
  private String txtOperation;
  private String txtBagRateAbv65;
  private String txtBagRateBlw65;  
  //private String txtEffDate;
  private String txtBaseYr;
  private String txtSorRateUpto50; 
  private String txtSorRateUpto75; 
  private String txtSorRateabove75;
  private String txtPieceWiseRate;
    
  public NWNPLabourSORDtlBean()
  {
  }
  
   /*public String getTxtRegCode()
  {
    return txtRegCode;
  }

  public void setTxtRegCode(String newTxtRegCode)
  {
    txtRegCode = newTxtRegCode;
  } */
  
  public String getTxtOperation()
  {
    return txtOperation;
  }

  public void setTxtOperation(String newTxtOperation)
  {
    txtOperation = newTxtOperation;
  } 
  
  public String getTxtBagRateAbv65()
  {
    return txtBagRateAbv65;
  }

  public void setTxtBagRateAbv65(String newTxtBagRateAbv65)
  {
    txtBagRateAbv65 = newTxtBagRateAbv65;
  }
  
  public String getTxtBagRateBlw65()
  {
    return txtBagRateBlw65;
  }

  public void setTxtBagRateBlw65(String newTxtBagRateBlw65)
  {
    txtBagRateBlw65 = newTxtBagRateBlw65;
  }  
  
  /*public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }*/  
  public String getTxtBaseYr()
  {
    return txtBaseYr;
  }

  public void setTxtBaseYr(String newTxtBaseYr)
  {
    txtBaseYr = newTxtBaseYr;
  }  
    public String getTxtSorRateUpto50()
    {
      return txtSorRateUpto50;
    }

    public void setTxtSorRateUpto50(String newTxtSorRateUpto50)
    {
      txtSorRateUpto50 = newTxtSorRateUpto50;
    }  
    public String getTxtSorRateUpto75()
    {
      return txtSorRateUpto75;
    }

    public void setTxtSorRateUpto75(String newTxtSorRateUpto75)
    {
      txtSorRateUpto75 = newTxtSorRateUpto75;
    }  
    public String getTxtSorRateabove75()
    {
      return txtSorRateabove75;
    }

    public void setTxtSorRateabove75(String newTxtSorRateabove75)
    {
      txtSorRateabove75 = newTxtSorRateabove75;
    }       
    public String getTxtPieceWiseRate()
    {
      return txtPieceWiseRate;
    }

    public void setTxtPieceWiseRate(String newTxtPieceWiseRate)
    {
      txtPieceWiseRate = newTxtPieceWiseRate;
    }    
}
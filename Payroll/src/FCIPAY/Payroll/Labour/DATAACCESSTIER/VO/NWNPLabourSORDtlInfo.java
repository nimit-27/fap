package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class NWNPLabourSORDtlInfo extends BaseDetailInfo implements Serializable
{
  //private String txtLocCode;
  private String txtRegCode="";
  private String txtLocId;
  private String txtOperation;
  private String txtBagRateAbv65;
  private String txtBagRateBlw65;  
  //private String txtEffDate;
  private String txtEndDate;
  private String txtBaseYr;
  private String txtSorRateUpto50; 
  private String txtSorRateUpto75; 
  private String txtSorRateabove75;
  private String txtLocation; 
  private String txtPieceWiseRate;

  public NWNPLabourSORDtlInfo()
  {
  }  
  
   public String getTxtRegCode()
  {
    return txtRegCode;
  }

  public void setTxtRegCode(String newTxtRegCode)
  {
    txtRegCode = newTxtRegCode;
  } 
  
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
  
  public String getTxtEndDate()
  {
    return txtEndDate;
  }

  public void setTxtEndDate(String newTxtEndDate)
  {
    txtEndDate = newTxtEndDate;
  } 
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
 
    public String getTxtLocId()
    {
     return txtLocId;
    }

    public void setTxtLocId(String newTxtLocId)
    {
     txtLocId = newTxtLocId;
    }
    public String getTxtLocation()
    {
     return txtLocation;
    }

    public void setTxtLocation(String newTxtLocation)
    {
     txtLocation = newTxtLocation;
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
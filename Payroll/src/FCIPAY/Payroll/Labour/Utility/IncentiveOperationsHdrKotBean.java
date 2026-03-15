package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;
public class IncentiveOperationsHdrKotBean extends PayrollBaseHeaderBean 
{
  private String txtEffFromDt;
  private String txtEffToDt;
  private String txtBagType;
  private String txtOperationID;
  private String txtOperationDesc;
  private String txtDatumVal;
  public IncentiveOperationsHdrKotBean()
  {
  }
  
   public String getTxtOperationDesc()
  {
    return txtOperationDesc;
  }

  public void setTxtOperationDesc(String newTxtOperationDesc)
  {
    txtOperationDesc= newTxtOperationDesc;
  }
   public String getTxtOperationID()
  {
    return txtOperationID;
  }

  public void setTxtOperationID(String newTxtOperationID)
  {
    txtOperationID= newTxtOperationID;
  }
  
   public String getTxtEffFromDt()
  {
    return txtEffFromDt;
  }

  public void setTxtEffFromDt(String newTxtEffFromDt)
  {
    txtEffFromDt = newTxtEffFromDt;
  }
  
    public String getTxtEffToDt()
  {
    return txtEffToDt;
  }

  public void setTxtEffToDt(String newTxtEffToDt)
  {
    txtEffToDt = newTxtEffToDt;
  }
  
    public String getTxtBagType()
  {
    return txtBagType;
  }

  public void setTxtBagType(String newTxtBagType)
  {
    txtBagType = newTxtBagType;
  }
  
  public String getTxtDatumVal()
  {
    return txtDatumVal;
  }

  public void setTxtDatumVal(String newTxtDatumVal)
  {
    txtDatumVal = newTxtDatumVal;
  }  
}
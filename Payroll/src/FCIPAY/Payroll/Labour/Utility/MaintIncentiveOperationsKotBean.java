package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
public class MaintIncentiveOperationsKotBean extends PayrollBaseDetailBean 
{
  
  private String txtOperationID="";
  private String txtOperationDesc="";
  private String txtDatumFlag="";
  //private String txtLeadFlag="";
  private String txtRate="";
  private String txtUnit="";
  
  public MaintIncentiveOperationsKotBean()
  {
  }
  
   public String getTxtOperationID()
  {
    return txtOperationID;
  }

  public void setTxtOperationID(String newTxtOperationID)
  {
    txtOperationID = newTxtOperationID;
  }
  
   public String getTxtOperationDesc()
  {
    return txtOperationDesc;
  }

  public void setTxtOperationDesc(String newTxtOperationDesc)
  {
    txtOperationDesc = newTxtOperationDesc;
  }


   public String getTxtDatumFlag()
  {
    return txtDatumFlag;
  }

  public void setTxtDatumFlag(String newTxtDatumFlag)
  {
    txtDatumFlag = newTxtDatumFlag;
  }
  
  /*public String getTxtLeadFlag()
  {
    return txtLeadFlag;
  }

  public void setTxtLeadFlag(String newTxtLeadFlag)
  {
    txtLeadFlag = newTxtLeadFlag;
  }*/
  
   public String getTxtRate()
  {
    return txtRate;
  }

  public void setTxtRate(String newTxtRate)
  {
    txtRate = newTxtRate;
  }
  
  public String getTxtUnit()
  {
    return txtUnit;
  }

  public void setTxtUnit(String newTxtUnit)
  {
    txtUnit = newTxtUnit;
  }
}
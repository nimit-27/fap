package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;


public class ElecFreeUnitsBean extends PayrollBaseDetailBean implements Serializable
{
  private String hdnElecFreeUnitsSrlNo = "";
  private String startField;
  private String endField;
  private String txtElecFreeUnits;

  //private String hdnCheck3 = "";
  //private boolean chkDel3;  

  public ElecFreeUnitsBean()
  {
    
  }
  public ElecFreeUnitsBean(String sEfuAmtFrom, String  sEfuAmtTo, String sEFUnits, String sSrlNo)
  {
  
    startField = sEfuAmtFrom;
    endField = sEfuAmtTo;
    txtElecFreeUnits = sEFUnits;
    hdnElecFreeUnitsSrlNo = sSrlNo;
    //hdnCheck3 = sCheck;
  }  

  public String gethdnElecFreeUnitsSrlNo()
  {
    return hdnElecFreeUnitsSrlNo;
  }

  public void sethdnElecFreeUnitsSrlNo(String newhdnElecFreeUnitsSrlNo)
  {
    hdnElecFreeUnitsSrlNo = newhdnElecFreeUnitsSrlNo;
  }

  public String getStartField()
  {
    return startField;
  }

  public void setStartField(String newStartField)
  {
    startField = newStartField;
  }

  public String getEndField()
  {
    return endField;
  }

  public void setEndField(String newEndField)
  {
    endField = newEndField;
  }

  public String getTxtElecFreeUnits()
  {
    return txtElecFreeUnits;
  }

  public void setTxtElecFreeUnits(String newTxtElecFreeUnits)
  {
    txtElecFreeUnits = newTxtElecFreeUnits;
  }



}
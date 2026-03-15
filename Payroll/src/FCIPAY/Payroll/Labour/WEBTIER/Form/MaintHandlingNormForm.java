package FCIPAY.Payroll.Labour.WEBTIER.Form;

import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import java.util.ArrayList;

public class MaintHandlingNormForm extends PayrollBaseForm 
{
  private String txtEffDate=null;
  private String txtMou;
  private String txtNormId[]=null;
  private String txtNormDesc[]=null;
  private String txtNormUnit[]=null;
  private String txtNormBel66kg[] =null;
  private String txtNormAbv66kg[] = null;
  private String txtNormRate[] = null;
  
  private ArrayList lstInstrDtls=new ArrayList();

  public MaintHandlingNormForm()
  {
  }

  public String getTxtEffDate()
  {
    return txtEffDate;
  }

  public void setTxtEffDate(String newTxtEffDate)
  {
    txtEffDate = newTxtEffDate;
  }

  public String getTxtMou()
  {
    return txtMou;
  }

  public void setTxtMou(String newTxtMou)
  {
    txtMou = newTxtMou;
  }

  public String[] getTxtNormId()
  {
    return txtNormId;
  }

  public void setTxtNormId(String[] newTxtNormId)
  {
    txtNormId = newTxtNormId;
  }

  public String[] getTxtNormDesc()
  {
    return txtNormDesc;
  }

  public void setTxtNormDesc(String[] newTxtNormDesc)
  {
    txtNormDesc = newTxtNormDesc;
  }

  public String[] getTxtNormBel66kg()
  {
    return txtNormBel66kg;
  }

  public void setTxtNormBel66kg(String[] newTxtNormBel66kg)
  {
    txtNormBel66kg = newTxtNormBel66kg;
  }

  public String[] getTxtNormAbv66kg()
  {
    return txtNormAbv66kg;
  }

  public void setTxtNormAbv66kg(String[] newTxtNormAbv66kg)
  {
    txtNormAbv66kg = newTxtNormAbv66kg;
  }
  
    public String[] getTxtNormUnit()
  {
    return txtNormUnit;
  }

  public void setTxtNormUnit(String[] newTxtNormUnit)
  {
    txtNormUnit = newTxtNormUnit;
  }
  
  public String[] getTxtNormRate()
  {
    return txtNormRate;
  }

  public void setTxtNormRate(String[] newTxtNormRate)
  {
    txtNormRate = newTxtNormRate;
  }
  
  public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
}


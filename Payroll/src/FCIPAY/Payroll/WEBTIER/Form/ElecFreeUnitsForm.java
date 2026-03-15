package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;

public class ElecFreeUnitsForm extends PayrollBaseForm
{
  private String txtEFUAmtFrom[];
  private String txtEFUAmtTo[];
  private String hdnElecFreeUnitsSrlNo[];
  private String txtRevYYMM;
  private String txtGradeCode;
  private String txtGradeDesc;
  private ArrayList lstElecFreeUnits = new ArrayList();
  private String screenTypeElecFreeUnits;
  private String screenType;
  private String screenModeElecFreeUnits;
  private String screenModeElecFreeUnits1;
  private String txtRevYear;
  private String txtElecFreeUnits[];

 public String[] getTxtEFUAmtFrom()
  {
    return txtEFUAmtFrom;
  }

  public void setTxtEFUAmtFrom(String[] newtxtEFUAmtFrom)
  {
    txtEFUAmtFrom = newtxtEFUAmtFrom;
  }

  public String[] getTxtEFUAmtTo()
  {
    return txtEFUAmtTo;
  }

  public void setTxtEFUAmtTo(String[] newtxtEFUAmtTo)
  {
    txtEFUAmtTo = newtxtEFUAmtTo;
  }



  public String[] getHdnElecFreeUnitsSrlNo()
  {
    return hdnElecFreeUnitsSrlNo;
  }

  public void setHdnElecFreeUnitsSrlNo(String[] newHdnElecFreeUnitsSrlNo)
  {
    hdnElecFreeUnitsSrlNo = newHdnElecFreeUnitsSrlNo;
  }

public String getTxtRevYYMM()
  {
    return txtRevYYMM;
  }

  public void setTxtRevYYMM(String newTxtRevYYMM)
  {
    txtRevYYMM = newTxtRevYYMM;
  }
 public String getTxtGradeCode()
  {
    return txtGradeCode;
  }

  public void setTxtGradeCode(String newTxtGradeCode)
  {
    txtGradeCode = newTxtGradeCode;
  }

  public String getTxtGradeDesc()
  {
    return txtGradeDesc;
  }

  public void setTxtGradeDesc(String newTxtGradeDesc)
  {
    txtGradeDesc = newTxtGradeDesc;
  }
  public ArrayList getLstElecFreeUnits()
  {
        return lstElecFreeUnits;
  }

  public void setLstElecFreeUnits(ArrayList newlstElecFreeUnits)
  {
        lstElecFreeUnits = newlstElecFreeUnits;
   }

  public String getScreenTypeElecFreeUnits()
  {
    return screenTypeElecFreeUnits;
  }

  public void setScreenTypeElecFreeUnits(String newScreenTypeElecFreeUnits)
  {
    screenTypeElecFreeUnits = newScreenTypeElecFreeUnits;
  }

  public String getScreenType()
  {
    return screenType;
  }

  public void setScreenType(String newScreenType)
  {
    screenType = newScreenType;
  }

  public String getScreenModeElecFreeUnits()
  {
    return screenModeElecFreeUnits;
  }

  public void setScreenModeElecFreeUnits(String newScreenModeElecFreeUnits)
  {
    screenModeElecFreeUnits = newScreenModeElecFreeUnits;
  }

  public String getScreenModeElecFreeUnits1()
  {
    return screenModeElecFreeUnits1;
  }

  public void setScreenModeElecFreeUnits1(String newScreenModeElecFreeUnits1)
  {
    screenModeElecFreeUnits1 = newScreenModeElecFreeUnits1;
  }



  public String getTxtRevYear()
  {
    return txtRevYear;
  }

  public void setTxtRevYear(String newTxtRevYear)
  {
    txtRevYear = newTxtRevYear;
  }

  public String[] getTxtElecFreeUnits()
  {
    return txtElecFreeUnits;
  }

  public void setTxtElecFreeUnits(String[] newTxtElecFreeUnits)
  {
    txtElecFreeUnits = newTxtElecFreeUnits;
  }



 



}
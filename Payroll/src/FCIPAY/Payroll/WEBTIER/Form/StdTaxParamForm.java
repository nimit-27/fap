package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;


public class StdTaxParamForm extends PayrollBaseForm 
{
   private String txtStdAmtFrom[];
   private String txtStdAmtTo[];
   private String txtStdMaleAmt[];
   private String txtStdFemaleAmt[];
   private String txtStdIncPer[];
   private ArrayList lstStdDedn = new ArrayList();
   private String txtStdDednYYMM;
  private String hdnStdDednSrlNo[];
  private String screenTypeStd;
  private String screenType;
  private String ScreenModeStd;
  private String screenModeStd1;


    public String[] getTxtStdAmtFrom()
  {
    return txtStdAmtFrom;
  }

  public void setTxtStdAmtFrom(String[] newTxtStdAmtFrom)
  {
    txtStdAmtFrom = newTxtStdAmtFrom;
  }

  public String[] getTxtStdAmtTo()
  {
    return txtStdAmtTo;
  }

  public void setTxtStdAmtTo(String[] newTxtStdAmtTo)
  {
    txtStdAmtTo = newTxtStdAmtTo;
  }

  public String[] getTxtStdMaleAmt()
  {
    return txtStdMaleAmt;
  }

  public void setTxtStdMaleAmt(String[] newTxtStdMaleAmt)
  {
    txtStdMaleAmt = newTxtStdMaleAmt;
  }

  public String[] getTxtStdFemaleAmt()
  {
    return txtStdFemaleAmt;
  }

  public void setTxtStdFemaleAmt(String[] newTxtStdFemaleAmt)
  {
    txtStdFemaleAmt = newTxtStdFemaleAmt;
  }

  public String[] getTxtStdIncPer()
  {
    return txtStdIncPer;
  }

  public void setTxtStdIncPer(String[] newTxtStdIncPer)
  {
    txtStdIncPer = newTxtStdIncPer;
  }
public ArrayList getlstStdDedn()
  {
        return lstStdDedn;
  }

  public void setlstStdDedn(ArrayList newlstStdDedn)
  {
        lstStdDedn = newlstStdDedn;
   }  
 public String getTxtStdDednYYMM()
  {
    return txtStdDednYYMM;
  }

  public void setTxtStdDednYYMM(String newTxtStdDednYYMM)
  {
    txtStdDednYYMM = newTxtStdDednYYMM;
  }

  public String[] getHdnStdDednSrlNo()
  {
    return hdnStdDednSrlNo;
  }

  public void setHdnStdDednSrlNo(String[] newHdnStdDednSrlNo)
  {
    hdnStdDednSrlNo = newHdnStdDednSrlNo;
  }

  public String getScreenTypeStd()
  {
    return screenTypeStd;
  }

  public void setScreenTypeStd(String newScreenTypeStd)
  {
    screenTypeStd = newScreenTypeStd;
  }

  public String getScreenType()
  {
    return screenType;
  }

  public void setScreenType(String newScreenType)
  {
    screenType = newScreenType;
  }

  public String getScreenModeStd()
  {
    return ScreenModeStd;
  }

  public void setScreenModeStd(String newScreenModeStd)
  {
    ScreenModeStd = newScreenModeStd;
  }

  public String getScreenModeStd1()
  {
    return screenModeStd1;
  }

  public void setScreenModeStd1(String newScreenModeStd1)
  {
    screenModeStd1 = newScreenModeStd1;
  }



}
package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class LbrHndlngAttndHeaderBean  extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtYYMM;
  private String txtDAType;
  private String headerMode;
  private String lstLabourType;
  private String txtGangId;
  private String txtGangName;
  private String txtLocation; 
  private String txtLocId;     
  //private String screenMode;
  //private String screenModeFlag;

  public LbrHndlngAttndHeaderBean()
  {
  }

  public String getTxtYYMM()
  {
    return txtYYMM;
  }

  public void setTxtYYMM(String newTxtYYMM)
  {
    txtYYMM = newTxtYYMM;
  }



  public String getTxtDAType()
  {
    return txtDAType;
  }

  public void setTxtDAType(String newTxtDAType)
  {
    txtDAType = newTxtDAType;
  }

  public String getHeaderMode()
  {
    return headerMode;
  }

  public void setHeaderMode(String newHeaderMode)
  {
    headerMode = newHeaderMode;
  }
  
  public String getLstLabourType()
  {
    return lstLabourType;
  }

  public void setLstLabourType(String newLstLabourType)
  {
    lstLabourType = newLstLabourType;
  }

  public String getTxtGangId()
  {
    return txtGangId;
  }

  public void setTxtGangId(String newTxtGangId)
  {
    txtGangId = newTxtGangId;
  }
  
  public String getTxtGangName()
  {
    return txtGangName;
  }

  public void setTxtGangName(String newTxtGangName)
  {
    txtGangName = newTxtGangName;
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
  
   /*public String getScreenMode()
  {
    return screenMode;
  }

  public void setScreenMode(String newScreenMode)
  {
    screenMode = newScreenMode;
  }
  
   public String getScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(String newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  }*/


}
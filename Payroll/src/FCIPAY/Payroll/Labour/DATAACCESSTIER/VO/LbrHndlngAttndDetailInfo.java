package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;



public class LbrHndlngAttndDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtYYMM;
  private String lstLabourType;
  private String txtGangId;
  private String txtGangName;
  private String txtDAType; 
  private String screenModeFlag;
  private String txtLocId;
  private String yrMonth;

  public LbrHndlngAttndDetailInfo()
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

  public String getTxtDAType()
  {
    return txtDAType;
  }

  public void setTxtDAType(String newTxtDAType)
  {
    txtDAType = newTxtDAType;
  } 
  
  public String getScreenModeFlag()
  {
    return screenModeFlag;
  }

  public void setScreenModeFlag(String newScreenModeFlag)
  {
    screenModeFlag = newScreenModeFlag;
  }
  
  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
  } 
  
   public String getYrMonth()
  {
    return yrMonth;
  }

  public void setYrMonth(String newYrMonth)
  {
    yrMonth = newYrMonth;
  }
  
}
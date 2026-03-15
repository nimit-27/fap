package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

public class LbrAncllryAttndQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtYYMM;
  private String lstLabourType;
  private String txtGangId;
  private String txtGangName;
  private String txtLocation;
  private String txtLocId;

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


}
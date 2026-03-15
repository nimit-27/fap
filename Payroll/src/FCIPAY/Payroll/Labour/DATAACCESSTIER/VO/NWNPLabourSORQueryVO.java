package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class NWNPLabourSORQueryVO extends PayrollBaseQueryVO implements Serializable
{
   private String effStartDate;   
   private String txtLocation; 
   private String txtLocId;
  public NWNPLabourSORQueryVO()
  {
  }

 public String getEffStartDate()
  {
    return effStartDate;
  }

  public void setEffStartDate(String newEffStartDate)
  {
    effStartDate = newEffStartDate;
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
}
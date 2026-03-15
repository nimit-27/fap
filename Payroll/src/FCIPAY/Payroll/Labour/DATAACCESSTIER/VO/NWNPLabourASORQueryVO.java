package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class NWNPLabourASORQueryVO extends PayrollBaseQueryVO implements Serializable
{
   private String effStartDate;   
   private String txtLocation; 
   private String txtLocId;
    private String txtAsorPercent;
    private String txtGoDownTyp; 
    private String  txtFromDate; 
    private String  txtToDate;
  public NWNPLabourASORQueryVO()
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

    public void setTxtAsorPercent(String txtAsorPercent) {
        this.txtAsorPercent = txtAsorPercent;
    }

    public String getTxtAsorPercent() {
        return txtAsorPercent;
    }

    public void setTxtGoDownTyp(String txtGoDownTyp) {
        this.txtGoDownTyp = txtGoDownTyp;
    }

    public String getTxtGoDownTyp() {
        return txtGoDownTyp;
    }

    public void setTxtFromDate(String txtFromDate) {
        this.txtFromDate = txtFromDate;
    }

    public String getTxtFromDate() {
        return txtFromDate;
    }

    public void setTxtToDate(String txtToDate) {
        this.txtToDate = txtToDate;
    }

    public String getTxtToDate() {
        return txtToDate;
    }
}

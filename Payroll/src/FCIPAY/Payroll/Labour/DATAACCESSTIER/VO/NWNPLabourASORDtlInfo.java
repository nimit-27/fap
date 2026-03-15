package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class NWNPLabourASORDtlInfo extends BaseDetailInfo implements Serializable
{
  //private String txtLocCode;
  private String txtRegCode="";
  private String txtLocId;
    private String txtAsorPercent;
                private String txtGoDownTyp; 
                private String  txtFromDate; 
                private String  txtToDate;
 // private String txtOperation;
 // private String txtBagRateAbv65;
  //private String txtBagRateBlw65;  
  //private String txtEffDate;
 // private String txtEndDate;
 // private String txtBaseYr;
//  private String txtASorRateUpto50; 
 // private String txtASorRateUpto75; 
 // private String txtASorRateabove75;
  private String txtLocation; 
  
  public NWNPLabourASORDtlInfo()
  {
  }


    public void setTxtRegCode(String txtRegCode) {
        this.txtRegCode = txtRegCode;
    }

    public String getTxtRegCode() {
        return txtRegCode;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
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

    public void setTxtLocation(String txtLocation) {
        this.txtLocation = txtLocation;
    }

    public String getTxtLocation() {
        return txtLocation;
    }
}

package FCIPAY.Payroll.Labour.Utility;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class NWNPLabourASORHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
    
  private String txtRegCode;  
  private String txtRegName;  
  private String effStartDate;
  private String txtEndDate;
  private String screenModeASOR1;
  private String txtLocation; 
  private String txtLocId;
  
  public NWNPLabourASORHeaderBean()
  {
  }


    public void setTxtRegCode(String txtRegCode) {
        this.txtRegCode = txtRegCode;
    }

    public String getTxtRegCode() {
        return txtRegCode;
    }

    public void setTxtRegName(String txtRegName) {
        this.txtRegName = txtRegName;
    }

    public String getTxtRegName() {
        return txtRegName;
    }

    public void setEffStartDate(String effStartDate) {
        this.effStartDate = effStartDate;
    }

    public String getEffStartDate() {
        return effStartDate;
    }

    public void setTxtEndDate(String txtEndDate) {
        this.txtEndDate = txtEndDate;
    }

    public String getTxtEndDate() {
        return txtEndDate;
    }

    public void setScreenModeASOR1(String screenModeASOR1) {
        this.screenModeASOR1 = screenModeASOR1;
    }

    public String getScreenModeASOR1() {
        return screenModeASOR1;
    }

    public void setTxtLocation(String txtLocation) {
        this.txtLocation = txtLocation;
    }

    public String getTxtLocation() {
        return txtLocation;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }
}

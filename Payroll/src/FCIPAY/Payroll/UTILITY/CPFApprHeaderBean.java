package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class CPFApprHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
  public CPFApprHeaderBean()
  {
  }
    private String txtEmpNo;
    private String txtUnitCode;
    private String txtAppvSts;
    private String txtEmpName;
    private String txtUnitDesc;
    private String txtCPFCode;
    
    public String getTxtCPFCode() {
        return txtCPFCode;
    }
    public void setTxtCPFCode(String txtCPFCode) {
        this.txtCPFCode = txtCPFCode;
    }
    public String getTxtEmpNo() {
        return txtEmpNo;
    }
    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }
    public String getTxtUnitCode() {
        return txtUnitCode;
    }
    public void setTxtUnitCode(String txtUnitCode) {
        this.txtUnitCode = txtUnitCode;
    }
    public String getTxtAppvSts() {
        return txtAppvSts;
    }
    public void setTxtAppvSts(String txtAppvSts) {
        this.txtAppvSts = txtAppvSts;
    }
    public String getTxtEmpName() {
        return txtEmpName;
    }
    public void setTxtEmpName(String txtEmpName) {
        this.txtEmpName = txtEmpName;
    }
    public String getTxtUnitDesc() {
        return txtUnitDesc;
    }
    public void setTxtUnitDesc(String txtUnitDesc) {
        this.txtUnitDesc = txtUnitDesc;
    }
    
}
package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class CPFApprQueryVO  extends PayrollBaseQueryVO implements Serializable
{
    private String txtEmpNo;
    private String txtUnitCode;
    private String txtAppvSts;
    
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
}
package FCIPAY.Payroll.DATAACCESSTIER.VO;

import FCIPAY.Payroll.common.vo.BaseDetailInfo;

import java.io.Serializable;

public class EmpTelephoneDataReimbursementHistoryDetailParm extends BaseDetailInfo implements Serializable{
    
    private String txtEmpNum;
    private String txtAdjType;
    private String txtFinYear;
    
    
    public EmpTelephoneDataReimbursementHistoryDetailParm() {
    
    }

    public void setTxtAdjType(String txtAdjType) {
        this.txtAdjType = txtAdjType;
    }

    public String getTxtAdjType() {
        return txtAdjType;
    }

    public void setTxtFinYear(String txtFinYear) {
        this.txtFinYear = txtFinYear;
    }

    public String getTxtFinYear() {
        return txtFinYear;
    }

    public void setTxtEmpNum(String txtEmpNum) {
        this.txtEmpNum = txtEmpNum;
    }

    public String getTxtEmpNum() {
        return txtEmpNum;
    }
}

// 
// Decompiled by Procyon v0.5.36
// 

package FCIPAY.Payroll.DATAACCESSTIER.VO;

import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class EmpLaptopAMCHistoryDetailParm extends BaseDetailInfo implements Serializable
{
    private String txtEmpNum;
    private String txtAdjType;
    private String txtFinYear;
    
    public void setTxtAdjType(final String txtAdjType) {
        this.txtAdjType = txtAdjType;
    }
    
    public String getTxtAdjType() {
        return this.txtAdjType;
    }
    
    public void setTxtFinYear(final String txtFinYear) {
        this.txtFinYear = txtFinYear;
    }
    
    public String getTxtFinYear() {
        return this.txtFinYear;
    }
    
    public void setTxtEmpNum(final String txtEmpNum) {
        this.txtEmpNum = txtEmpNum;
    }
    
    public String getTxtEmpNum() {
        return this.txtEmpNum;
    }
}

package FCIPAY.Payroll.DATAACCESSTIER.VO;

import FCIPAY.Payroll.common.vo.BaseDetailInfo;

import java.io.Serializable;

public class NWNPCityLocMapDetailInfo extends BaseDetailInfo implements Serializable  {
    
    private String txtDPLocidSrch;
    
    public NWNPCityLocMapDetailInfo() {
        
    }

    public void setTxtDPLocidSrch(String txtDPLocidSrch) {
        this.txtDPLocidSrch = txtDPLocidSrch;
    }

    public String getTxtDPLocidSrch() {
        return txtDPLocidSrch;
    }
}

package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

import java.io.Serializable;

public class NWNPAreaClassiFicationMappingQueryVO extends PayrollBaseQueryVO implements Serializable{
//    private String depotName;
//    private String areaTypeCat;
//    private String effStartDate;
    private String txtDPLocidSrch;
    
    public NWNPAreaClassiFicationMappingQueryVO() {
       
    }

//    public void setDepotName(String depotName) {
//        this.depotName = depotName;
//    }
//
//    public String getDepotName() {
//        return depotName;
//    }
//
//    public void setAreaTypeCat(String areaTypeCat) {
//        this.areaTypeCat = areaTypeCat;
//    }
//
//    public String getAreaTypeCat() {
//        return areaTypeCat;
//    }
//
//    public void setEffStartDate(String effStartDate) {
//        this.effStartDate = effStartDate;
//    }
//
//    public String getEffStartDate() {
//        return effStartDate;
//    }

    public void setTxtDPLocidSrch(String txtDPLocidSrch) {
        this.txtDPLocidSrch = txtDPLocidSrch;
    }

    public String getTxtDPLocidSrch() {
        return txtDPLocidSrch;
    }
}

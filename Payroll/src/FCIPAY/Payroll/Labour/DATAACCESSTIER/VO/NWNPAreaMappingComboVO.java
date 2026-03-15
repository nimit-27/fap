package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;


import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

import java.io.Serializable;

import java.util.ArrayList;


public class NWNPAreaMappingComboVO  extends PayrollBaseQueryVO implements Serializable {
    private ArrayList locationList;
    
    public NWNPAreaMappingComboVO() {

    }

    public void setLocationList(ArrayList locationList) {
        this.locationList = locationList;
    }

    public ArrayList getLocationList() {
        return locationList;
    }
}

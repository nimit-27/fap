package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

import java.io.Serializable;

import java.util.ArrayList;

public class NWNPWrkSlipComboVO  extends PayrollBaseQueryVO implements Serializable{
    
    private ArrayList hndlngNormList;
    private ArrayList normTypList;
    private ArrayList leadNormList;
    private ArrayList operationList;
    
    
    public NWNPWrkSlipComboVO() {
    }

    public void setHndlngNormList(ArrayList hndlngNormList) {
        this.hndlngNormList = hndlngNormList;
    }

    public ArrayList getHndlngNormList() {
        return hndlngNormList;
    }

    public void setNormTypList(ArrayList normTypList) {
        this.normTypList = normTypList;
    }

    public ArrayList getNormTypList() {
        return normTypList;
    }

    public void setLeadNormList(ArrayList leadNormList) {
        this.leadNormList = leadNormList;
    }

    public ArrayList getLeadNormList() {
        return leadNormList;
    }

    public void setOperationList(ArrayList operationList) {
        this.operationList = operationList;
    }

    public ArrayList getOperationList() {
        return operationList;
    }
}

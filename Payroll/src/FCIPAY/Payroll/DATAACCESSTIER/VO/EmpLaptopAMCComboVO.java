// 
// Decompiled by Procyon v0.5.36
// 

package FCIPAY.Payroll.DATAACCESSTIER.VO;

import java.util.ArrayList;
import java.io.Serializable;

public class EmpLaptopAMCComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList payCodeList;
    
    public ArrayList getPayCodeList() {
        return this.payCodeList;
    }
    
    public void setPayCodeList(final ArrayList newPayCodeList) {
        this.payCodeList = newPayCodeList;
    }
}

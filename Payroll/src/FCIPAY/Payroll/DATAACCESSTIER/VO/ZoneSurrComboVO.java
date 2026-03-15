package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class ZoneSurrComboVO extends PayrollBaseQueryVO implements Serializable
{  
    private ArrayList zoneList;
    
    public ZoneSurrComboVO()
    {
    }
    
    public ArrayList getZoneList() {
        return zoneList;
    }
    
    public void setZoneList(ArrayList zoneList) {
        this.zoneList = zoneList;
    }
}
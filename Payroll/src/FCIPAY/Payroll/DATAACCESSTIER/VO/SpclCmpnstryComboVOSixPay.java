package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class SpclCmpnstryComboVOSixPay extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList ctgryList;
    private ArrayList allowanceList;
    private ArrayList areaTypeList;
    
    public SpclCmpnstryComboVOSixPay()
    {
    }
    
    public ArrayList getCtgryList()
    {
        return ctgryList;
    }
    
    public void setCtgryList(ArrayList newCtgryList)
    {
        ctgryList = newCtgryList;
    }
    
    public ArrayList getAllowanceList()
    {
        return allowanceList;
    }
    
    public void setAllowanceList(ArrayList newAllowanceList)
    {
        allowanceList = newAllowanceList;
    }
    
    public ArrayList getAreaTypeList()
    {
        return areaTypeList;
    }
    
    public void setAreaTypeList(ArrayList newAreaTypeList)
    {
        areaTypeList = newAreaTypeList;
    }
}
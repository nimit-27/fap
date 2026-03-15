package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class MiscAllowanceComboVOSixPay extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList ctgryList;
    private ArrayList allowanceList;
    
    public MiscAllowanceComboVOSixPay()
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
}
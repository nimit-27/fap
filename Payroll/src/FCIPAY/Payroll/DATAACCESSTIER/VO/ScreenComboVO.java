package FCIPAY.Payroll.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;
import java.util.ArrayList;

public class ScreenComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList screenList;
    private ArrayList moduleList;
    
    public ScreenComboVO()
    {
    }
    
    public ArrayList getScreenList()
    {
      return screenList;
    }
  
    public void setScreenList(ArrayList newScreenList)
    {
      screenList = newScreenList;
    }
    
    public ArrayList getModuleList()
    {
      return moduleList;
    }

    public void setModuleList(ArrayList newModuleList)
    {
      moduleList = newModuleList;
    }
}
package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;
import java.util.ArrayList;

public class WrkSlipOprationComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList operationList;
    
    public WrkSlipOprationComboVO()
    {
    }
    
    public ArrayList getOperationList()
    {
      return operationList;
    }
  
    public void setOperationList(ArrayList newOperationList)
    {
      operationList = newOperationList;
    }
}
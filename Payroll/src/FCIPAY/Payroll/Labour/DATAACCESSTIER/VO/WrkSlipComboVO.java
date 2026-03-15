package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;
import java.util.ArrayList;

public class WrkSlipComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList hndlngNormList;
    private ArrayList normTypList;
    private ArrayList leadNormList;
    private ArrayList operationList; //addded by swapnendu Dt 06 Feb 2012
    
    public WrkSlipComboVO()
    {
    }
    
    public ArrayList getNormTypList()
    {
      return normTypList;
    }
  
    public void setNormTypList(ArrayList newNormTypList)
    {
      normTypList = newNormTypList;
    }

    public ArrayList getHndlngNormList()
    {
      return hndlngNormList;
    }
  
    public void setHndlngNormList(ArrayList newHndlngNormList)
    {
      hndlngNormList = newHndlngNormList;
    }

    public ArrayList getLeadNormList()
    {
      return leadNormList;
    }
  
    public void setLeadNormList(ArrayList newLeadNormList)
    {
      leadNormList = newLeadNormList;
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
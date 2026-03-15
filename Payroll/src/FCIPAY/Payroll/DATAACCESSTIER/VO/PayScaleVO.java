package FCIPAY.Payroll.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;
import java.util.ArrayList;

public class PayScaleVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList payScaleList;
   
    public PayScaleVO()
    {
    }
    
    public ArrayList getPayScaleList()
    {
      return payScaleList;
    }
  
    public void setPayScaleList(ArrayList newPayScaleList)
    {
      payScaleList = newPayScaleList;
    }
}
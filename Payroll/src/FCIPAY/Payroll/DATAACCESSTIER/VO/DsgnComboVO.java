package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class DsgnComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList ctgryList;
     private ArrayList payScaleList;
      private ArrayList payBandList;
    public DsgnComboVO()
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
    
    
    
    public ArrayList getPayBandList()
    {
      return payBandList;
    }
  
    public void setPayBandList(ArrayList newPayBandList)
    {
      payBandList = newPayBandList;
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
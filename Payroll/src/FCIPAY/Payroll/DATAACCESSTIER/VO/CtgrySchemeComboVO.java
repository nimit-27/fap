package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class CtgrySchemeComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList ctgryList;
    private ArrayList payScale;
    public CtgrySchemeComboVO()
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
  
  
    public ArrayList getPayScale()
    {
      return payScale;
    }
  
    public void setPayScale(ArrayList newPayScale)
    {
      payScale = newPayScale;
    }
  
}
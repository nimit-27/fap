package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;


public class PayScaleComboVO extends PayrollBaseQueryVO implements Serializable
{



  private ArrayList payScaleArr;

  public PayScaleComboVO()
  {
  }

  public ArrayList getPayScaleArr()
  {
    return payScaleArr;
  }

  public void setPayScaleArr(ArrayList newPayScaleArr)
  {
    payScaleArr = newPayScaleArr;
  }







}
package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;
public class MaintInterestRateBean extends PayrollBaseDetailBean  implements Serializable
{
  private String txtInrRate="";
  
 
  private String txtSrlNo="";
  private String startField;
  private String endField;

  public MaintInterestRateBean()
  {
  }

    public MaintInterestRateBean(String sAmtFrom,String sAmtTo, String stxtInrRate,String sSrlNo)
  {
    startField=sAmtFrom;
    endField=sAmtTo;
    txtInrRate=stxtInrRate;
    txtSrlNo=sSrlNo;
    
  }







  public String getTxtInrRate()
  {
    return txtInrRate;
  }

  public void setTxtInrRate(String newTxtInrRate)
  {
    txtInrRate = newTxtInrRate;
  }


  

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getStartField()
  {
    return startField;
  }

  public void setStartField(String newStartField)
  {
    startField = newStartField;
  }

  public String getEndField()
  {
    return endField;
  }

  public void setEndField(String newEndField)
  {
    endField = newEndField;
  }



}
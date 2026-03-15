package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;


public class MaintConvAllowBean  extends PayrollBaseDetailBean implements Serializable
{
  private String txtSrlNo="";
  private String txtAllow="";
  private String txtCategory="";
  private String txtHandicap="";
//  private String startField;
//  private String endField;
  private String txtPayScale;

  public MaintConvAllowBean()
  {
  }


 public MaintConvAllowBean(String PayScale,String allow,String srlno,String handicap,String category)
  {
    
//    startField=start;
//    endField=end;
      txtPayScale = PayScale; 
      txtAllow=allow;
      txtSrlNo=srlno;
      txtHandicap=handicap;
      txtCategory=category;
  }

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  public String getTxtAllow()
  {
    return txtAllow;
  }

  public void setTxtAllow(String newTxtAllow)
  {
    txtAllow = newTxtAllow;
  }

  public String getTxtCategory()
  {
    return txtCategory;
  }

  public void setTxtCategory(String newTxtCategory)
  {
    txtCategory = newTxtCategory;
  }
  
  public String getTxtHandicap()
  {
    return txtHandicap;
  }

  public void setTxtHandicap(String newTxtHandicap)
  {
    txtHandicap = newTxtHandicap;
  }


/*  public String getStartField()
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
  } */

  public String getTxtPayScale()
  {
    return txtPayScale;
  }

  public void setTxtPayScale(String newTxtPayScale)
  {
    txtPayScale = newTxtPayScale;
  }



}
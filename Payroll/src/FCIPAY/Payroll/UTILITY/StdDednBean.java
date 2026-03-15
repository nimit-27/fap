package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class StdDednBean extends PayrollBaseDetailBean implements Serializable
{
  private String txtStdMaleAmt = "";
  private String txtStdFemaleAmt = "";
  private String txtStdIncPer = "";
  private String hdnStdDednSrlNo = "";
  private String startField;
  private String endField;
  //private String hdnCheck2 = "";
  //private boolean chkDel2;


  public StdDednBean()
  {
  }
 
  public StdDednBean(String stdAmtFrom, String stdAmtTo, String stdMaleAmt, String stdFemaleAmt, String StdIncPer, String SrlNo)
  {
    startField = stdAmtFrom;
    endField = stdAmtTo;
    txtStdMaleAmt = stdMaleAmt;
    txtStdFemaleAmt = stdFemaleAmt;
    txtStdIncPer = StdIncPer;
    hdnStdDednSrlNo = SrlNo;
    //hdnCheck2 = sCheck;
  }





  public String getTxtStdMaleAmt()
  {
    return txtStdMaleAmt;
  }

  public void setTxtStdMaleAmt(String newTxtStdMaleAmt)
  {
    txtStdMaleAmt = newTxtStdMaleAmt;
  }

  public String getTxtStdFemaleAmt()
  {
    return txtStdFemaleAmt;
  }

  public void setTxtStdFemaleAmt(String newTxtStdFemaleAmt)
  {
    txtStdFemaleAmt = newTxtStdFemaleAmt;
  }

  public String getTxtStdIncPer()
  {
    return txtStdIncPer;
  }

  public void setTxtStdIncPer(String newTxtStdIncPer)
  {
    txtStdIncPer = newTxtStdIncPer;
  }

  public String getHdnStdDednSrlNo()
  {
    return hdnStdDednSrlNo;
  }

  public void setHdnStdDednSrlNo(String newHdnStdDednSrlNo)
  {
    hdnStdDednSrlNo = newHdnStdDednSrlNo;
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
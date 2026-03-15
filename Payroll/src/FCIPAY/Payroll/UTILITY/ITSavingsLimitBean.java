package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class ITSavingsLimitBean implements Serializable 
{
  private String txtAmt="";
  private String txtAddlLimit="";
  private String txtFemAddl="";
  private boolean chkDel4;
  private String hdnCheck4="";
  private String hdnITSavingsLimitSrlNo="";

  public ITSavingsLimitBean(String sAmt, String sAddlLimit, String sFemAddl,  String sSrlNo, String sCheck)
  {
  }

  public ITSavingsLimitBean()
  {
  }

  public String getTxtAmt()
  {
    return txtAmt;
  }

  public void setTxtAmt(String newTxtAmt)
  {
    txtAmt = newTxtAmt;
  }

  public String getTxtAddlLimit()
  {
    return txtAddlLimit;
  }

  public void setTxtAddlLimit(String newTxtAddlLimit)
  {
    txtAddlLimit = newTxtAddlLimit;
  }

  public String getTxtFemAddl()
  {
    return txtFemAddl;
  }

  public void setTxtFemAddl(String newTxtFemAddl)
  {
    txtFemAddl = newTxtFemAddl;
  }

  public boolean isChkDel4()
  {
    return chkDel4;
  }

  public void setChkDel4(boolean newChkDel4)
  {
    chkDel4 = newChkDel4;
  }

  public String getHdnCheck4()
  {
    return hdnCheck4;
  }

  public void setHdnCheck4(String newHdnCheck4)
  {
    hdnCheck4 = newHdnCheck4;
  }

  public String getHdnITSavingsLimitSrlNo()
  {
    return hdnITSavingsLimitSrlNo;
  }

  public void setHdnITSavingsLimitSrlNo(String newHdnITSavingsLimitSrlNo)
  {
    hdnITSavingsLimitSrlNo = newHdnITSavingsLimitSrlNo;
  }
}
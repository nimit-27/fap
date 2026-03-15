package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class EnqPayImgHdrBean extends PayrollBaseHeaderBean implements Serializable
{
  private String txtEmpNo;
  private String txtEmpName;
  private String txtYtm;
  private String lstGroup;
  private String txtDesig;
  private String lstCateg;
  private String txtrs1;
  private String txtrs2;

  public EnqPayImgHdrBean()
  {
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtEmpName()
  {
    return txtEmpName;
  }

  public void setTxtEmpName(String newTxtEmpName)
  {
    txtEmpName = newTxtEmpName;
  }

  public String getTxtYtm()
  {
    return txtYtm;
  }

  public void setTxtYtm(String newTxtYtm)
  {
    txtYtm = newTxtYtm;
  }

  public String getLstGroup()
  {
    return lstGroup;
  }

  public void setLstGroup(String newLstGroup)
  {
    lstGroup = newLstGroup;
  }

  public String getTxtDesig()
  {
    return txtDesig;
  }

  public void setTxtDesig(String newTxtDesig)
  {
    txtDesig = newTxtDesig;
  }

  public String getLstCateg()
  {
    return lstCateg;
  }

  public void setLstCateg(String newLstCateg)
  {
    lstCateg = newLstCateg;
  }

  public String getTxtrs1()
  {
    return txtrs1;
  }

  public void setTxtrs1(String newTxtrs1)
  {
    txtrs1 = newTxtrs1;
  }

  public String getTxtrs2()
  {
    return txtrs2;
  }

  public void setTxtrs2(String newTxtrs2)
  {
    txtrs2 = newTxtrs2;
  }
}
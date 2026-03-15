package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class EnqPayImageHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
  private String txtEmpNo;
  private String txtEmpName;
  private String lstGroup;
  private String txtDesig;
  private String lstCateg;
  private String txtYtm;
  private String txtCurrBas;
  private String txtNetEar;
  private String txtGrossEar;
  private String txtGrossDed;
  private String txtPenDed;
  private String txtEPSDed;
  private String txtPFContr;
  private String txtUptoYYMM;
  
  public EnqPayImageHeaderBean()
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

  public String getTxtYtm()
  {
    return txtYtm;
  }

  public void setTxtYtm(String newTxtYtm)
  {
    txtYtm = newTxtYtm;
  }

  public String getTxtCurrBas()
  {
    return txtCurrBas;
  }

  public void setTxtCurrBas(String newTxtCurrBas)
  {
    txtCurrBas = newTxtCurrBas;
  }
  
   public String getTxtNetEar()
  {
    return txtNetEar;
  }

  public void setTxtNetEar(String newTxtNetEar)
  {
    txtNetEar = newTxtNetEar;
  }

  public String getTxtGrossEar()
  {
    return txtGrossEar;
  }

  public void setTxtGrossEar(String newTxtGrossEar)
  {
    txtGrossEar = newTxtGrossEar;
  }

  public String getTxtGrossDed()
  {
    return txtGrossDed;
  }

  public void setTxtGrossDed(String newTxtGrossDed)
  {
    txtGrossDed = newTxtGrossDed;
  }
  
  public String getTxtEPSDed()
  {
    return txtEPSDed;
  }

  public void setTxtEPSDed(String newTxtEPSDed)
  {
    txtEPSDed = newTxtEPSDed;
  }
  
  public String getTxtPFContr()
  {
    return txtPFContr;
  }

  public void setTxtPFContr(String newTxtPFContr)
  {
    txtPFContr = newTxtPFContr;
  }

    public void setTxtUptoYYMM(String txtUptoYYMM) {
        this.txtUptoYYMM = txtUptoYYMM;
    }

    public String getTxtUptoYYMM() {
        return txtUptoYYMM;
    }

    public String getTxtPenDed()
    {
       
        return txtPenDed;
    }

    public void setTxtPenDed(String newTxtPenDed)
    {
      txtPenDed = newTxtPenDed;
    }
      
}

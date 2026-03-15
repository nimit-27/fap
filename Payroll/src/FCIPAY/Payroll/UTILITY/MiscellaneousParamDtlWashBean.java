package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import java.util.ArrayList;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MiscellaneousParamDtlWashBean  extends PayrollBaseDetailBean implements Serializable 
{
  private String lstCadre="";
  private String txtCategory="";
  private String txtWashAllowance="";
  private String txtCableReimb="";
  private String txtWashSrl="";
  private String lstCadreDesc="";

  public MiscellaneousParamDtlWashBean()
  {
  }

   public MiscellaneousParamDtlWashBean(String slstCadre,String sCategory,String sWashAllowance,String sCableReimb,String sSrl)
    
    {
          lstCadre = slstCadre;
          txtCategory =sCategory;
          txtWashAllowance =sWashAllowance;
          txtCableReimb =sCableReimb;
          txtWashSrl = sSrl;
    }








  public String getLstCadre()
  {
    return lstCadre;
  }

  public void setLstCadre(String newLstCadre)
  {
    lstCadre = newLstCadre;
  }

  public String getTxtCategory()
  {
    return txtCategory;
  }

  public void setTxtCategory(String newTxtCategory)
  {
    txtCategory = newTxtCategory;
  }

  public String getTxtWashAllowance()
  {
    return txtWashAllowance;
  }

  public void setTxtWashAllowance(String newTxtWashAllowance)
  {
    txtWashAllowance = newTxtWashAllowance;
  }

  public String getTxtCableReimb()
  {
    return txtCableReimb;
  }

  public void setTxtCableReimb(String newTxtCableReimb)
  {
    txtCableReimb = newTxtCableReimb;
  }

  public String getTxtWashSrl()
  {
    return txtWashSrl;
  }

  public void setTxtWashSrl(String newTxtWashSrl)
  {
    txtWashSrl = newTxtWashSrl;
  }

  public String getLstCadreDesc()
  {
    return lstCadreDesc;
  }

  public void setLstCadreDesc(String newLstCadreDesc)
  {
    lstCadreDesc = newLstCadreDesc;
  }

}
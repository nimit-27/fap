package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;

public class MaintBadClmtAllowFormSixPay extends PayrollBaseForm 
{
  private ArrayList lstInstrCdaDtls=new ArrayList();
  private ArrayList lstInstrIdaDtls=new ArrayList();
  private ArrayList lstInstrCdaDtlsSixPay =new ArrayList();
  private String txtPayScaleTyp;
  private String txtEffDt;
  private String [] txtBasicFrom;
  private String [] txtCtgry;
  private String [] txtBasicTo;
  private String [] txtAllow;
  private String [] txtStartDt;
  private String [] txtEndDt;
  private boolean flagIda=false;
  private boolean flagCda=false;
  private String txtEffToDt;
  private String txtSplCmpAllowAmt; 
  
  public String getTxtPayScaleTyp()
  {
    return txtPayScaleTyp;
  }

  public void setTxtPayScaleTyp(String newTxtPayScaleTyp)
  {
    txtPayScaleTyp = newTxtPayScaleTyp;
  }
  
  public String getTxtEffDt()
  {
    return txtEffDt;
  }

  public void setTxtEffDt(String newTxtEffDt)
  {
    txtEffDt = newTxtEffDt;
  }

   public ArrayList getLstInstrCdaDtls()
  {
    return lstInstrCdaDtls;
  }

  public void setLstInstrCdaDtls(ArrayList newLstInstrCdaDtls)
  {
    lstInstrCdaDtls = newLstInstrCdaDtls;
  }

   public ArrayList getLstInstrIdaDtls()
  {
    return lstInstrIdaDtls;
  }

  public void setLstInstrIdaDtls(ArrayList newLstInstrIdaDtls)
  {
    lstInstrIdaDtls = newLstInstrIdaDtls;
  }
  
  public ArrayList getLstInstrCdaDtlsSixPay()
  {
    return lstInstrCdaDtlsSixPay;
  }

  public void setLstInstrCdaDtlsSixPay(ArrayList newLstInstrIdaDtls)
  {
    lstInstrCdaDtlsSixPay = newLstInstrIdaDtls;
  }

  public String [] getTxtBasicFrom()
  {
    return txtBasicFrom;
  }

  public void setTxtBasicFrom(String[] newTxtBasicFrom)
  {
    txtBasicFrom = newTxtBasicFrom;
  }
  
   public String [] getTxtBasicTo()
  {
    return txtBasicTo;
  }

  public void setTxtBasicTo(String[] newTxtBasicTo)
  {
    txtBasicTo = newTxtBasicTo;
  }
   public String [] getTxtAllow()
  {
    return txtAllow;
  }

  public void setTxtAllow(String[] newTxtAllow)
  {
    txtAllow = newTxtAllow;
  }
   public String [] getTxtStartDt()
  {
    return txtStartDt;
  }

  public void setTxtStartDt(String[] newTxtStartDt)
  {
    txtStartDt = newTxtStartDt;
  }
  
   public String [] getTxtCtgry()
  {
    return txtCtgry;
  }

  public void setTxtCtgry(String[] newTxtCtgry)
  {
    txtCtgry = newTxtCtgry;
  }
  
  public String [] getTxtEndDt()
  {
    return txtEndDt;
  }

  public void setTxtEndDt(String[] newTxtEndDt)
  {
    txtEndDt = newTxtEndDt;
  }
  
    public boolean isFlagIda()
  {
    return flagIda;
  }
  
  public void setFlagIda(boolean newFlagIda)
  {
    flagIda=newFlagIda;
  }
  
  public boolean isFlagCda()
  {
    return flagCda;
  }
  
  public void setFlagCda(boolean newFlagCda)
  {
    flagCda=newFlagCda;
  }
  
  public String getTxtEffToDt()
  {
    return txtEffToDt;
  }

  public void setTxtEffToDt(String newTxtEffToDt)
  {
    txtEffToDt = newTxtEffToDt;
  }
  
  public String getTxtSplCmpAllowAmt()
  {
    return txtSplCmpAllowAmt;
  } 

  public void setTxtSplCmpAllowAmt(String newSplCmpAllowType)
  {
    txtSplCmpAllowAmt = newSplCmpAllowType;
  }
  
 
}
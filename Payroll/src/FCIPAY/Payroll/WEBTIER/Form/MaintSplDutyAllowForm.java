package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;

public class MaintSplDutyAllowForm extends PayrollBaseForm 
{
  private ArrayList lstInstrCdaDtls=new ArrayList();
  private ArrayList lstInstrIdaDtls=new ArrayList();
  private String txtPayScaleTyp;
  private String txtEffDt;
  private String [] txtCtgry;
  private String [] txtDsgn;
  private String [] txtDsgnId;
  private String [] txtParamFlg;
  private String [] txtAllow;
  private String [] txtStartDt;
  private String [] txtEndDt;
  private String [] txtRmrks;
  private String [] txtPayScale;
  private String [] txtArea;
  private boolean flagIda=false;
  private boolean flagCda=false;
  
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
  
  public String [] getTxtDsgn()
  {
    return txtDsgn;
  }

  public void setTxtDsgn(String[] newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }

  public String [] getTxtDsgnId()
  {
    return txtDsgnId;
  }

  public void setTxtDsgnId(String[] newTxtDsgnId)
  {
    txtDsgnId = newTxtDsgnId;
  }

  public String [] getTxtParamFlg()
  {
    return txtParamFlg;
  }

  public void setTxtParamFlg(String[] newTxtParamFlg)
  {
    txtParamFlg = newTxtParamFlg;
  }
  
  public String [] getTxtEndDt()
  {
    return txtEndDt;
  }

  public void setTxtEndDt(String[] newTxtEndDt)
  {
    txtEndDt = newTxtEndDt;
  }

  public String [] getTxtRmrks()
  {
    return txtRmrks;
  }

  public void setTxtRmrks(String[] newTxtRmrks)
  {
    txtRmrks = newTxtRmrks;
  }

  public String [] getTxtPayScale()
  {
    return txtPayScale;
  }

  public void setTxtPayScale(String[] newTxtPayScale)
  {
    txtPayScale = newTxtPayScale;
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
  
  public String [] getTxtArea()
  {
    return txtArea;
  }

  public void setTxtArea(String[] newTxtArea)
  {
    txtArea = newTxtArea;
  }

}
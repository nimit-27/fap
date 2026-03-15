package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;

public class MaintDsgnForm extends PayrollBaseForm 
{
  private ArrayList lstInstrDtls=new ArrayList();
  private String [] txtDsgnDesc;
  private String [] txtCtgry;
  private String [] txtPayScaleCode;
  private String [] txtPayScaleDesc;
  private String [] txtBoardFlg;
  private String [] txtDsgnId;
  
   public ArrayList getLstInstrDtls()
  {
    return lstInstrDtls;
  }

  public void setLstInstrDtls(ArrayList newLstInstrDtls)
  {
    lstInstrDtls = newLstInstrDtls;
  }
  
  public String [] getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String[] newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }
  
   public String [] getTxtDsgnId()
  {
    return txtDsgnId;
  }

  public void setTxtDsgnId(String[] newTxtDsgnId)
  {
    txtDsgnId = newTxtDsgnId;
  }
   public String [] getTxtBoardFlg()
  {
    return txtBoardFlg;
  }

  public void setTxtBoardFlg(String[] newTxtBoardFlg)
  {
    txtBoardFlg = newTxtBoardFlg;
  }
   public String [] getTxtPayScaleCode()
  {
    return txtPayScaleCode;
  }

  public void setTxtPayScaleCode(String[] newTxtPayScaleCode)
  {
    txtPayScaleCode = newTxtPayScaleCode;
  }
  
  public String [] getTxtPayScaleDesc()
  {
    return txtPayScaleDesc;
  }

  public void setTxtPayScaleDesc(String[] newTxtPayScaleDesc)
  {
    txtPayScaleDesc = newTxtPayScaleDesc;
  }
  
   public String [] getTxtCtgry()
  {
    return txtCtgry;
  }

  public void setTxtCtgry(String[] newTxtCtgry)
  {
    txtCtgry = newTxtCtgry;
  }
}
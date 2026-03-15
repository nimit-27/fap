package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class MaintDsgnBean extends PayrollBaseDetailBean implements Serializable
{

  private String txtDsgnDesc;
  private String txtCtgry;
  private String txtPayScaleCode;
  private String txtPayScaleDesc;
  private String txtBoardFlg;
  private String txtDsgnId;
  
  
  public MaintDsgnBean()
  {
  }
  
   public MaintDsgnBean(String sDsgnDesc,String sCtgry,String sPayScaleCode,String sPayScaleDesc,String sBoardFlg,String sDsgnId)
  {
    txtDsgnDesc=sDsgnDesc;
    txtCtgry=sCtgry;
    txtPayScaleCode=sPayScaleCode;
    txtPayScaleDesc=sPayScaleDesc;
    txtBoardFlg=sBoardFlg;
    txtDsgnId=sDsgnId;
  }
  
  public String getTxtDsgnDesc()
  {
    return txtDsgnDesc;
  }

  public void setTxtDsgnDesc(String newTxtDsgnDesc)
  {
    txtDsgnDesc = newTxtDsgnDesc;
  }
  
   public String getTxtDsgnId()
  {
    return txtDsgnId;
  }

  public void setTxtDsgnId(String newTxtDsgnId)
  {
    txtDsgnId = newTxtDsgnId;
  }
   public String getTxtBoardFlg()
  {
    return txtBoardFlg;
  }

  public void setTxtBoardFlg(String newTxtBoardFlg)
  {
    txtBoardFlg = newTxtBoardFlg;
  }
   public String getTxtPayScaleCode()
  {
    return txtPayScaleCode;
  }

  public void setTxtPayScaleCode(String newTxtPayScaleCode)
  {
    txtPayScaleCode = newTxtPayScaleCode;
  }
  
  public String getTxtPayScaleDesc()
  {
    return txtPayScaleDesc;
  }

  public void setTxtPayScaleDesc(String newTxtPayScaleDesc)
  {
    txtPayScaleDesc = newTxtPayScaleDesc;
  }
  
   public String getTxtCtgry()
  {
    return txtCtgry;
  }

  public void setTxtCtgry(String newTxtCtgry)
  {
    txtCtgry = newTxtCtgry;
  }
}
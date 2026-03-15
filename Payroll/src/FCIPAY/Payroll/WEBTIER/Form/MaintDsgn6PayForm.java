package FCIPAY.Payroll.WEBTIER.Form;
import java.util.ArrayList;

public class MaintDsgn6PayForm extends PayrollBaseForm
{
    private ArrayList lstInstrDtls=new ArrayList();
    private String [] txtDsgnDesc;
    private String [] txtCtgry;
    private String [] txtPayScaleCode;
    private String [] txtPayScaleDesc;
    
    private String [] txtPayBandCode;
    private String [] txtPayBandDesc;
    
    private String [] txtGradePay;
   
    
    private String [] txtBoardFlg;
    private String [] txtDsgnId;
    
    
    
    public String [] getTxtGradePay()
    {
      return txtGradePay;
    }
  
    public void setTxtGradePay(String[] newTxtGradePay)
    {
      txtGradePay = newTxtGradePay;
    }
    
    
     public String [] getTxtPayBandCode()
    {
      return txtPayBandCode;
    }
  
    public void setTxtPayBandCode(String[] newTxtPayBandCode)
    {
      txtPayBandCode = newTxtPayBandCode;
    }
    
    
    
     public String [] getTxtPayBandDesc()
    {
      return txtPayBandDesc;
    }
  
    public void setTxtPayBandDesc(String[] newTxtPayBandDesc)
    {
      txtPayBandDesc = newTxtPayBandDesc;
    }
    
    
    
    
    
    
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
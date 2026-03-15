package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class MaintDsgn6PayBean extends PayrollBaseDetailBean implements Serializable
{
    private String txtDsgnDesc;
    private String txtCtgry;
    private String txtPayScaleCode;
    private String txtPayScaleDesc;
    private String txtBoardFlg;
    private String txtDsgnId;
    private String txtPayBandCode;
    private String txtPayBandDesc;
    private String txtGradePay;
    //private String txtPayScaleType;
    
    
    
    public MaintDsgn6PayBean()
    {
    }
    
     //public MaintDsgn6PayBean(String sDsgnDesc,String sCtgry,String sPayScaleCode,String sPayScaleDesc,String sBoardFlg,String sDsgnId,String sPayBandCode,String sPayBandDesc,String sPayScaleType,String sGradePay)
     public MaintDsgn6PayBean(String sDsgnDesc,String sCtgry,String sPayScaleCode,String sPayScaleDesc,String sBoardFlg,String sDsgnId,String sPayBandCode,String sPayBandDesc,String sGradePay)
    {
      txtDsgnDesc=sDsgnDesc;
      txtCtgry=sCtgry;
      txtPayScaleCode=sPayScaleCode;
      txtPayScaleDesc=sPayScaleDesc;
      txtBoardFlg=sBoardFlg;
      txtDsgnId=sDsgnId;
      txtPayBandCode=sPayBandCode;
      txtPayBandDesc=sPayBandDesc;
      //txtPayScaleType=sPayScaleType;
       txtGradePay=sGradePay;
      
    }
    
    public String getTxtGradePay()
    {
      return txtGradePay;
    }
     public void setTxtGradePay(String newTxtGradePay)
    {
      txtGradePay = newTxtGradePay;
    }
   /* 
    public String getTxtPayScaleType()
    {
      return txtPayScaleType;
    }
     public void setTxtPayScaleType(String newTxtPayScaleType)
    {
      txtPayScaleType = newTxtPayScaleType;
    }
    
    */
     public String getTxtPayBandCode()
    {
      return txtPayBandCode;
    }
     public void setTxtPayBandCode(String newTxtPayBandCode)
    {
      txtPayBandCode = newTxtPayBandCode;
    }
     public String getTxtPayBandDesc()
    {
      return txtPayBandDesc;
    }
     public void setTxtPayBandDesc(String newTxtPayBandDesc)
    {
      txtPayBandDesc = newTxtPayBandDesc;
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
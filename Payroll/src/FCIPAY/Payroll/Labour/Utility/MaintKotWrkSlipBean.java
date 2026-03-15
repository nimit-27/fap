package FCIPAY.Payroll.Labour.Utility;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class MaintKotWrkSlipBean extends PayrollBaseDetailBean 
{
    //added by sakshi 13.2.09
    private String txtLbrCode;
    private String txtLbrID = null;
    private String txtLbrName;
    private String txtLbrDsgn;
    //added by sakshi ends 13.2.09
    private String txtNormTyp;
    private String txtBags;
    private String txtOperSeq;
    private String txtOperId;
    private String txtOperDesc;
    private String txtOperDatum;
    private String txtIncentive;
    private String txtIncentivelbr;
    //   private String hdnWrkSlipDtlId;
    private String txtSrlNo;
    private String txtBagTyp;
  
    public MaintKotWrkSlipBean()
    {
    }
    
    
    public String getTxtLbrCode()
    {
      return txtLbrCode;
    }

    public void setTxtLbrCode(String newTxtLbrCode)
    {
      txtLbrCode = newTxtLbrCode;
    }
    
     public String getTxtLbrID()
    {
      return txtLbrID;
    }

    public void setTxtLbrID(String newTxtLbrID)
    {
      txtLbrID = newTxtLbrID;
    }
    
     public String getTxtLbrName()
    {
      return txtLbrName;
    }

    public void setTxtLbrName(String newTxtLbrName)
    {
      txtLbrName = newTxtLbrName;
    }
     public String getTxtLbrDsgn()
    {
      return txtLbrDsgn;
    }

    public void setTxtLbrDsgn(String newTxtLbrDsgn)
    {
      txtLbrDsgn = newTxtLbrDsgn;
    }
    
    public String getTxtNormTyp()
    {
      return txtNormTyp;
    }
    
    public void setTxtNormTyp(String newTxtNormTyp)
    {
      txtNormTyp=newTxtNormTyp;
    }
    
    public String getTxtBags()
    {
      return txtBags;
    }
    
    public void setTxtBags(String newTxtBags)
    {
      txtBags=newTxtBags;
    }   
 
    public String getTxtOperSeq()
    {
      return txtOperSeq;
    }
    
    public void setTxtOperSeq(String newTxtOperSeq)
    {
      txtOperSeq=newTxtOperSeq;
    }
    
    public String getTxtOperId()
    {
      return txtOperId;
    }
    
    public void setTxtOperId(String newTxtOperId)
    {
      txtOperId=newTxtOperId;
    }

    public String getTxtOperDesc()
    {
      return txtOperDesc;
    }
    
    public void setTxtOperDesc(String newTxtOperDesc)
    {
      txtOperDesc=newTxtOperDesc;
    }

    public String  getTxtOperDatum()
    {
      return txtOperDatum;
    }
    
    public void setTxtOperDatum(String newTxtOperDatum)
    {
      txtOperDatum=newTxtOperDatum;
    }

    public String  getTxtIncentive()
    {
      return txtIncentive;
    }
    
    public void setTxtIncentive(String newTxtIncentive)
    {
      txtIncentive=newTxtIncentive;
    }

    public String getTxtBagTyp()
    {
      return txtBagTyp;
    }
    
    public void setTxtBagTyp(String newTxtBagTyp)
    {
      txtBagTyp=newTxtBagTyp;
    }
    
     public String  getTxtIncentivelbr()
    {
      return txtIncentivelbr;
    }
    
    public void setTxtIncentivelbr(String newTxtIncentivelbr)
    {
      txtIncentivelbr=newTxtIncentivelbr;
    }
    
    public String  getTxtSrlNo()
    {
      return txtSrlNo;
    }
    
    public void setTxtSrlNo(String newTxtSrlNo)
    {
      txtSrlNo=newTxtSrlNo;
    }

}
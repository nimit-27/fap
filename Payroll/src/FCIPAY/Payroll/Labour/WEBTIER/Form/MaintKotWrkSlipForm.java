package FCIPAY.Payroll.Labour.WEBTIER.Form;
import FCIPAY.Payroll.WEBTIER.Form.PayrollBaseForm;
import java.util.ArrayList;

public class MaintKotWrkSlipForm extends PayrollBaseForm 
{

    private ArrayList lstInstrDtls=new ArrayList();
    private ArrayList lstInstrDtlslbr=new ArrayList();
    private String hdnWrkSlipId;
    private String hdnGangId;
    private String txtGangName;
    private String txtWrkSlipDt;
    private String txtYYMM;
    private String [] txtNormTyp;
    private String [] txtBags;
    private String [] txtOperSeq;
    private String [] txtOperId;
    private String [] txtOperDesc;
    private String [] txtOperDatum;
    private String [] txtIncentive;
    private String  hdnWrkSlipDtlId;
    private String [] txtBagTyp;
    private String txtTotIncentive;
    private String txtNoLbrs;
    private String txtMukadam;
    private String txtTotBags;
    private String [] txtLbrCode;
    private String [] txtLbrID;
    private String [] txtLbrName;
    private String [] txtLbrDsgn;
    private String [] txtIncentivelbr;
    private String txtWrkSlipTyp;
    private String flagLbr;    
    private String flagWrkSlp;
    private String [] txtSrlNo;
    private String txtLocId;
    private String txtLoc;
    
    public ArrayList getLstInstrDtls()
    {
      return lstInstrDtls;
    }

    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
      lstInstrDtls = newLstInstrDtls;
    }
    
    
    public ArrayList getLstInstrDtlslbr()
    {
      return lstInstrDtlslbr;
    }

    public void setLstInstrDtlslbr(ArrayList newLstInstrDtlslbr)
    {
      lstInstrDtlslbr = newLstInstrDtlslbr;
    } 
    
    public String getHdnWrkSlipId()
    {
      return hdnWrkSlipId;
    }
    
    public void setHdnWrkSlipId(String newHdnWrkSlipId)
    {
      hdnWrkSlipId=newHdnWrkSlipId;
    }

    public String getHdnGangId()
    {
      return hdnGangId;
    }
    
    public void setHdnGangId(String newHdnGangId)
    {
      hdnGangId=newHdnGangId;
    }
    
    public String getTxtGangName()
    {
      return txtGangName;
    }
    
    public void setTxtGangName(String newTxtGangName)
    {
      txtGangName=newTxtGangName;
    }
    
    public String getTxtWrkSlipDt()
    {
      return txtWrkSlipDt;
    }
    
    public void setTxtWrkSlipDt(String newTxtWrkSlipDt)
    {
      txtWrkSlipDt=newTxtWrkSlipDt;
    }

    public String getTxtYYMM()
    {
      return txtYYMM;
    }
    
    public void setTxtYYMM(String newTxtYYMM)
    {
      txtYYMM=newTxtYYMM;
    }
    
    public String [] getTxtNormTyp()
    {
      return txtNormTyp;
    }
    
    public void setTxtNormTyp(String [] newTxtNormTyp)
    {
      txtNormTyp=newTxtNormTyp;
    }
    
    public String [] getTxtBags()
    {
      return txtBags;
    }
    
    public void setTxtBags(String[] newTxtBags)
    {
      txtBags=newTxtBags;
    }
    
    public String  getHdnWrkSlipDtlId()
    {
      return hdnWrkSlipDtlId;
    }
    
    public void setHdnWrkSlipDtlId(String  newHdnWrkSlipDtlId)
    {
      hdnWrkSlipDtlId=newHdnWrkSlipDtlId;
    }

    public String[] getTxtBagTyp()
    {
      return txtBagTyp;
    }
    
    public void setTxtBagTyp(String [] newTxtBagTyp)
    {
      txtBagTyp=newTxtBagTyp;
    }
    
    public String [] getTxtOperId()
    {
      return txtOperId;
    }
    
    public void setTxtOperId(String[] newTxtOperId)
    {
      txtOperId=newTxtOperId;
    }
    
    public String [] getTxtOperSeq()
    {
      return txtOperSeq;
    }
    
    public void setTxtOperSeq(String[] newTxtOperSeq)
    {
      txtOperSeq=newTxtOperSeq;
    }

    public String [] getTxtOperDesc()
    {
      return txtOperDesc;
    }
    
    public void setTxtOperDesc(String[] newTxtOperDesc)
    {
      txtOperDesc=newTxtOperDesc;
    }

    public String [] getTxtOperDatum()
    {
      return txtOperDatum;
    }
    
    public void setTxtOperDatum(String[] newTxtOperDatum)
    {
      txtOperDatum=newTxtOperDatum;
    }

    public String [] getTxtIncentive()
    {
      return txtIncentive;
    }
    
    public void setTxtIncentive(String[] newTxtIncentive)
    {
      txtIncentive=newTxtIncentive;
    }

    public String getTxtTotIncentive()
    {
      return txtTotIncentive;
    }
    
    public void setTxtTotIncentive(String newTxtTotIncentive)
    {
      txtTotIncentive=newTxtTotIncentive;
    }

    public String getTxtNoLbrs()
    {
      return txtNoLbrs;
    }
    
    public void setTxtNoLbrs(String newTxtNoLbrs)
    {
      txtNoLbrs=newTxtNoLbrs;
    }

    public String getTxtMukadam()
    {
      return txtMukadam;
    }
    
    public void setTxtMukadam(String newTxtMukadam)
    {
      txtMukadam=newTxtMukadam;
    }

    public String getTxtTotBags()
    {
      return txtTotBags;
    }
    
    public void setTxtTotBags(String newTxtTotBags)
    {
      txtTotBags=newTxtTotBags;
    }
    
    public String [] getTxtLbrID()
    {
      return txtLbrID;
    }
    
    public void setTxtLbrID(String[] newTxtLbrID)
    {
      txtLbrID=newTxtLbrID;
    } 
    
    public String [] getTxtLbrCode()
    {
      return txtLbrCode;
    }
    
    public void setTxtLbrCode(String[] newTxtLbrCode)
    {
      txtLbrCode=newTxtLbrCode;
    } 
    
    public String [] getTxtLbrName()
    {
      return txtLbrName;
    }
    
    public void setTxtLbrName(String[] newTxtLbrName)
    {
      txtLbrName=newTxtLbrName;
    } 
    
     public String [] getTxtLbrDsgn()
    {
      return txtLbrDsgn;
    }
    
    public void setTxtLbrDsgn(String[] newTxtLbrDsgn)
    {
      txtLbrDsgn=newTxtLbrDsgn;
    } 
    
     public String [] getTxtIncentivelbr()
    {
      return txtIncentive;
    }
    
    public void setTxtIncentivelbr(String[] newTxtIncentivelbr)
    {
      txtIncentivelbr=newTxtIncentivelbr;
    }
    
    public String getTxtWrkSlipTyp()
    {
      return txtWrkSlipTyp;
    }
    
    public void setTxtWrkSlipTyp(String newTxtWrkSlipTyp)
    {
      txtWrkSlipTyp=newTxtWrkSlipTyp;
    }
    
    public String getFlagLbr()
    {
      return flagLbr;
    }
    
    public void setFlagLbr(String newFlagLbr)
    {
      flagLbr=newFlagLbr;
    }
    
    public String [] getTxtSrlNo()
    {
      return txtSrlNo;
    }
    
    public void setTxtSrlNo(String [] newTxtSrlNo)
    {
      txtSrlNo=newTxtSrlNo;
    }
    
    public String getFlagWrkSlp()
    {
      return flagWrkSlp;
    }
    
    public void setFlagWrkSlp(String newFlagWrkSlp)
    {
      flagWrkSlp=newFlagWrkSlp;
    }
    
  public String getTxtLocId()
  {
    return txtLocId;
  }

  public void setTxtLocId(String newTxtLocId)
  {
    txtLocId = newTxtLocId;
  }
  
  public String getTxtLoc()
  {
    return txtLoc;
  }

  public void setTxtLoc(String newTxtLoc)
  {
    txtLoc = newTxtLoc;
  }
    
}
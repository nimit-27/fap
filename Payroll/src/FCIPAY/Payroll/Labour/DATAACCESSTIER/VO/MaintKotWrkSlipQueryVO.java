package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;

public class MaintKotWrkSlipQueryVO extends PayrollBaseQueryVO implements Serializable 
{
  
    private String hdnWrkSlipId;
     private String txtLocId;
    private String txtLoc;
    private String hdnGangId;
    private String txtGangName;
    private String txtWrkSlipDt;
    private String txtYYMM;
    private String txtWrkSlipTyp;
  
    public MaintKotWrkSlipQueryVO()
    {
    }
  
    public String getHdnWrkSlipId()
    {
    System.out.println(hdnWrkSlipId);
      return hdnWrkSlipId;
    }
    
    public void setHdnWrkSlipId(String newHdnWrkSlipId)
    {
      hdnWrkSlipId=newHdnWrkSlipId;
    }
    
    public String getTxtLocId()
    {
      return txtLocId;
    }
    
    public void setTxtLocId(String newTxtLocId)
    {
      txtLocId=newTxtLocId;
    }
    
    public String getTxtLoc()
    {
      return txtLoc;
    }
    
    public void setTxtLoc(String newTxtLoc)
    {
      txtLoc=newTxtLoc;
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
      txtGangName=txtGangName;
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
    
    public String getTxtWrkSlipTyp()
    {
      return txtWrkSlipTyp;
    }
    
    public void setTxtWrkSlipTyp(String newTxtWrkSlipTyp)
    {
      txtWrkSlipTyp=newTxtWrkSlipTyp;
    }
    
}
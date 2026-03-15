package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class KotWrkSlpDtlsVO extends  BaseDetailInfo implements Serializable 
{
  private String txtWrkSlipDt;
  private String hdnWrkSlipDtlId;
  private String txtYYMM;
 
  public KotWrkSlpDtlsVO()
  {
  }
    public String getTxtWrkSlipDt()
    {
      return txtWrkSlipDt;
    }
    
    public void setTxtWrkSlipDt(String newTxtWrkSlipDt)
    {
      txtWrkSlipDt=newTxtWrkSlipDt;
    }
    
    public String getHdnWrkSlipDtlId()
    {
      return hdnWrkSlipDtlId;
    }
    
    public void setHdnWrkSlipDtlId(String newHdnWrkSlipDtlId)
    {
      hdnWrkSlipDtlId=newHdnWrkSlipDtlId;
    }
    public String getTxtYYMM()
    {
      return txtYYMM;
    }
    
    public void setTxtYYMM(String newTxtYYMM)
    {
      txtYYMM=newTxtYYMM;
    }
    
}
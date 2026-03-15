package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class MiscAllowanceSixPayDetailInfo extends BaseDetailInfo implements Serializable 
{
  public MiscAllowanceSixPayDetailInfo()
  {
  }
    private String txtPayScaleTyp;
    private String txtEffFrmDt;
    private String txtEffToDt;
    private String txtPayCode;

    public String getTxtPayScaleTyp()
    {
        return txtPayScaleTyp;
    }
    public void setTxtPayScaleTyp(String newTxtPayScaleTyp)
    {
        txtPayScaleTyp = newTxtPayScaleTyp;
    } 

    public String getTxtEffFrmDt()
    {
        return txtEffFrmDt;
    }
    public void setTxtEffFrmDt(String newTxtEffFrmDt)
    {
        txtEffFrmDt = newTxtEffFrmDt;
    }
    
    public String getTxtEffToDt()
    {
        return txtEffToDt;
    }
    public void setTxtEffToDt(String newTxtEffToDt)
    {
        txtEffToDt = newTxtEffToDt;
    }

    public String getTxtPayCode()
    {
        return txtPayCode;
    }
    public void setTxtPayCode(String  newTxtPayCode)
    {
        txtPayCode = newTxtPayCode;
    }
}
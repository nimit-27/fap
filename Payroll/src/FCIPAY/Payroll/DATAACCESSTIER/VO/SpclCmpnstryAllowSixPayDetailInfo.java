package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class SpclCmpnstryAllowSixPayDetailInfo extends BaseDetailInfo implements Serializable 
{
    private String txtPayScaleTyp;
    private String cboAllowType;
    private String cboAreaType;
    private String txtEffFrmDt;
    private String txtEffToDt;
      
    public SpclCmpnstryAllowSixPayDetailInfo()
    {
    }

    public String getCboAllowType()
    {
        return cboAllowType;
    }
    public void setCboAllowType(String newCboAllowType)
    {
        cboAllowType = newCboAllowType;
    }
    
    public String getCboAreaType()
    {
        return cboAreaType;
    }
    public void setCboAreaType(String newCboAreaType)
    {
        cboAreaType = newCboAreaType;
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
    public String getTxtPayScaleTyp()
    {
        return txtPayScaleTyp;
    }
    public void setTxtPayScaleTyp(String newTxtPayScaleTyp)
    {
        txtPayScaleTyp = newTxtPayScaleTyp;
    } 
    
}
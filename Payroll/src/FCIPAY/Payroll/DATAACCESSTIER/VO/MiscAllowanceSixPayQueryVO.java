package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class MiscAllowanceSixPayQueryVO extends PayrollBaseQueryVO implements Serializable
{
    private String txtPayScaleTyp;
    private String cboAllowType;
    private String cboAreaType;
    private String txtEffFrmDt;
    private String txtEffToDt;
    private String txtPayCode;
    
    public MiscAllowanceSixPayQueryVO()
    {
    }
    
    public String getTxtPayScaleTyp()
    {
        return txtPayScaleTyp;
    }
    
    public void setTxtPayScaleTyp(String newTxtPayScaleTyp)
    {
        txtPayScaleTyp = newTxtPayScaleTyp;
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
    
    public String getTxtPayCode()
    {
        return txtPayCode;
    }
    
    public void setTxtPayCode(String  newTxtPayCode)
    {
        txtPayCode = newTxtPayCode;
    }

}
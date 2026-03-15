package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class EmpPaySixDetailInfo extends BaseDetailInfo implements Serializable 
{
    private String txtEmpNo;
    private String txtYYMM;
    private String txtEffDt;
    private String buttonFlag;
    
    public EmpPaySixDetailInfo()
    {
    }
    
    public String getTxtEmpNo()
    {
        return txtEmpNo;
    }
    
    public void setTxtEmpNo(String newTxtEmpNo)
    {
        txtEmpNo = newTxtEmpNo;
    } 
    
    public String getTxtYYMM()
    {
        return txtYYMM;
    }
    
    public void settxtYYMM(String newTxtYYMM)
    {
        txtYYMM = newTxtYYMM;
    }

    public String getTxtEffDt()
    {
        return txtEffDt;
    }
    
    public void setTxtEffDt(String newTxtEffDt)
    {
        txtEffDt = newTxtEffDt;
    }
    
    public String getButtonFlag()
    {
        return buttonFlag;
    }
    
    public void setButtonFlag(String newButtonFlag)
    {
        buttonFlag = newButtonFlag;
    }
  
}
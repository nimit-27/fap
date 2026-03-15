package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class EmpPaySixQueryVO  extends PayrollBaseQueryVO implements Serializable
{
    private String txtEmpNo;
    private String txtYYMM;
    private String txtEffDt;
    private String screenName;
    private String txtPayRevFlag;
    
    public EmpPaySixQueryVO()
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
    
    public String getScreenName()
    {
        return screenName;
    }
    
    public void setScreenName(String newScreenName)
    {
        screenName = newScreenName;
    }

    public void setTxtPayRevFlag(String txtPayRevFlag) {
        this.txtPayRevFlag = txtPayRevFlag;
    }

    public String getTxtPayRevFlag() {
        return txtPayRevFlag;
    }
}

package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;

public class EmpPaySixHeaderBean extends PayrollBaseHeaderBean implements Serializable  
{
    public EmpPaySixHeaderBean()
    {
    }
  
    private String txtEmpNo;
    private String txtEmpName;
    private String txtDsgn;
    private String txtCategDesc;
    private String txtEmpType;
    private String txtCpfCode;
    private String txtPresentPOPDesc;
    //private String txtDOJSite;
    private String txtEmpStatus;
    private String txtPayScale;
    private String txtYYMM;
    private String txtEffDt;
    private String chkVhclType;
    private String txtPayCodeAdj;
    private String txtPercAdj;
    private String txtPayCodePerc;
    private String txtPayRevFlag;

    public String getTxtEmpNo()
    {
        return txtEmpNo;
    }
    
    public void setTxtEmpNo(String newTxtEmpNo)
    {
        txtEmpNo = newTxtEmpNo;
    }  
    
    public String getTxtEmpName()
    {
        return txtEmpName;
    }
    
    public void setTxtEmpName(String newTxtEmpName)
    {
        txtEmpName = newTxtEmpName;
    }
    
    public String getTxtDsgn()
    {
        return txtDsgn;
    }
    
    public void setTxtDsgn(String newTxtDsgn)
    {
        txtDsgn = newTxtDsgn;
    }
    
    public String getTxtCategDesc()
    {
        return txtCategDesc;
    }
    
    public void setTxtCategDesc(String newTxtCategDesc)
    {
        txtCategDesc = newTxtCategDesc;
    }
    
    public String getTxtEmpType()
    {
        return txtEmpType;
    }
    
    public void setTxtEmpType(String newTxtEmpType)
    {
        txtEmpType = newTxtEmpType;
    }  
    
    public String getTxtCpfCode()
    {
        return txtCpfCode;
    }
    
    public void setTxtCpfCode(String newTxtCpfCode)
    {
        txtCpfCode = newTxtCpfCode;
    }  
    
    public String getTxtPresentPOPDesc()
    {
        return txtPresentPOPDesc;
    }
    
    public void setTxtPresentPOPDesc(String newTxtPresentPOPDesc)
    {
        txtPresentPOPDesc = newTxtPresentPOPDesc;
    }
 /*   
    public String getTxtDOJSite()
    {
        return txtDOJSite;
    }
    
    public void setTxtDOJSite(String newTxtDOJSite)
    {
        txtDOJSite = newTxtDOJSite;
    }
 */   
    public String getTxtEmpStatus()
    {
        return txtEmpStatus;
    }
    
    public void setTxtEmpStatus(String newTxtEmpStatus)
    {
        txtEmpStatus = newTxtEmpStatus;
    }

    public String getTxtPayScale()
    {
        return txtPayScale;
    }
    
    public void setTxtPayScale(String newTxtPayScale)
    {
        txtPayScale = newTxtPayScale;
    }
    
    public String getTxtYYMM()
    {
        return txtYYMM;
    }
    
    public void setTxtYYMM(String newTxtYYMM)
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

    public String getChkVhclType()
    {
        return chkVhclType;
    }
    
    public void setChkVhclType(String newChkVhclType)
    {
        chkVhclType = newChkVhclType;
    }

    public String getTxtPayCodeAdj()
    {
        return txtPayCodeAdj;
    }
    
    public void setTxtPayCodeAdj(String newTxtPayCodeAdj)
    {
        txtPayCodeAdj = newTxtPayCodeAdj;
    }
    
    public String getTxtPercAdj()
    {
        return txtPercAdj;
    }
    
    public void setTxtPercAdj(String newTxtPercAdj)
    {
        txtPercAdj = newTxtPercAdj;
    }
    
    public String getTxtPayCodePerc()
    {
        return txtPayCodePerc;
    }
    
    public void setTxtPayCodePerc(String newTxtPayCodePerc)
    {
        txtPayCodePerc = newTxtPayCodePerc;
    }

    public void setTxtPayRevFlag(String txtPayRevFlag) {
        this.txtPayRevFlag = txtPayRevFlag;
    }

    public String getTxtPayRevFlag() {
        return txtPayRevFlag;
    }
}

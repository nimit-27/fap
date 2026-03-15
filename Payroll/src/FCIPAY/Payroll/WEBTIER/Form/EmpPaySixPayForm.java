package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class EmpPaySixPayForm extends PayrollBaseForm 
{
    private ArrayList lstInstrDtls=new ArrayList();
  
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
    //private String txtTempTranId;
    private String userBtn;
    private String userBtn1;
    private String chkUpdtBtn;
    private String hdnFinYear;
    private String txtPayCodeAdj;
    private String txtPayCodePerc;
    private String txtPercAdj;
    private String hdnDesgId;
    private String hdnHandFlag;
    
    private String [] txtPayCode;
    private String [] txtPayDesc;
    private String [] txtPrcntage;
    private String [] txtPayMode;
    private String txtPayRevFlag;  
 
    public ArrayList getLstInstrDtls()
    {
        return lstInstrDtls;
    }
    
    public void setLstInstrDtls(ArrayList newLstInstrDtls)
    {
        lstInstrDtls=newLstInstrDtls;
    }
    
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
/*
    public String getTxtTempTranId()
    {
        return txtTempTranId;
    }
    
    public void setTxtTempTranId(String newTxtTempTranId)
    {
        txtTempTranId = newTxtTempTranId;
    }
*/
    public String getUserBtn()
    {
        return userBtn;
    }
    
    public void setUserBtn(String newUserBtn)
    {
        userBtn = newUserBtn;
    }

    public String getUserBtn1()
    {
        return userBtn1;
    }
    
    public void setUserBtn1(String newUserBtn1)
    {
        userBtn1 = newUserBtn1;
    }
    
    public String getChkUpdtBtn()
    {
        return chkUpdtBtn;
    }
    
    public void setChkUpdtBtn(String newChkUpdtBtn)
    {
        chkUpdtBtn = newChkUpdtBtn;
    }

    public String getHdnFinYear()
    {
        return hdnFinYear;
    }
    
    public void setHdnFinYear(String newHdnFinYear)
    {
        hdnFinYear = newHdnFinYear;
    }

    public String getTxtPayCodeAdj()
    {
        return txtPayCodeAdj;
    }
    
    public void setTxtPayCodeAdj(String newTxtPayCodeAdj)
    {
        txtPayCodeAdj = newTxtPayCodeAdj;
    }
    
    public String getTxtPayCodePerc()
    {
        return txtPayCodePerc;
    }
    
    public void setTxtPayCodePerc(String newTxtPayCodePerc)
    {
        txtPayCodePerc = newTxtPayCodePerc;
    }

    public String getTxtPercAdj()
    {
        return txtPercAdj;
    }
    
    public void setTxtPercAdj(String newTxtPercAdj)
    {
        txtPercAdj = newTxtPercAdj;
    }

    public String getHdnDesgId()
    {
        return hdnDesgId;
    }
    
    public void setHdnDesgId(String newHdnDesgId)
    {
        hdnDesgId = newHdnDesgId;
    }
    
    public String getHdnHandFlag()
    {
        return hdnHandFlag;
    }
    
    public void setHdnHandFlag(String newHdnHandFlag)
    {
        hdnHandFlag = newHdnHandFlag;
    }
    
//=======================================================================================================================================    
    public String [] getTxtPayCode()
    {
        return txtPayCode;
    }
    public void setTxtPayCode(String [] newTxtPayCode)
    {
        txtPayCode=newTxtPayCode;
    }
    
    public String [] getTxtPayDesc()
    {
        return txtPayDesc;
    }
    public void setTxtPayDesc(String [] newTxtPayDesc)
    {
        txtPayDesc=newTxtPayDesc;
    }
    
    public String [] getTxtPrcntage()
    {
        return txtPrcntage;
    }
    public void setTxtPrcntage(String [] newTxtPrcntage)
    {
        txtPrcntage=newTxtPrcntage;
    }
    
    public String [] getTxtPayMode()
    {
        return txtPayMode;
    }
    public void setTxtPayMode(String [] newTxtPayMode)
    {
        txtPayMode=newTxtPayMode;
    }

    public void setTxtPayRevFlag(String txtPayRevFlag) {
        this.txtPayRevFlag = txtPayRevFlag;
    }

    public String getTxtPayRevFlag() {
        return txtPayRevFlag;
    }
}

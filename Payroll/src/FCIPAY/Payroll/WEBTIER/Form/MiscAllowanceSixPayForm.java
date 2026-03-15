package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class MiscAllowanceSixPayForm extends PayrollBaseForm 
{
    private ArrayList lstSCADtlsCDA=new ArrayList();
    private ArrayList lstSCADtlsIDA=new ArrayList();
    
    private String txtPayScaleTyp;
    private String cboAllowType;
    private String cboAreaType;
    private String txtEffFrmDt;
    private String txtEffToDt;
    private boolean flagIda=false;
    private boolean flagCda=false;
    private String txtPayCode;
    private String txtPayCodeName;

    private String [] txtPayBand;
    private String [] txtGrade;
    private String [] txtRate;
    private String [] cboCatg;
    
    public ArrayList getLstSCADtlsCDA()
    {
        return lstSCADtlsCDA;
    }
    
    public void setLstSCADtlsCDA(ArrayList newLstSCADtlsCDA)
    {
        lstSCADtlsCDA=newLstSCADtlsCDA;
    }
    
    public String getTxtPayScaleTyp()
    {
        return txtPayScaleTyp;
    }
    
    public void setTxtPayScaleTyp(String newTxtPayScaleTyp)
    {
        txtPayScaleTyp = newTxtPayScaleTyp;
    } 

    public ArrayList getLstSCADtlsIDA()
    {
        return lstSCADtlsIDA;
    }
    
    public void setLstSCADtlsIDA(ArrayList newLstSCADtlsIDA)
    {
        lstSCADtlsIDA=newLstSCADtlsIDA;
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

    public boolean isFlagIda()
    {
        return flagIda;
    }
    
    public void setFlagIda(boolean newFlagIda)
    {
        flagIda=newFlagIda;
    }
    
    public boolean isFlagCda()
    {
        return flagCda;
    }
    
    public void setFlagCda(boolean newFlagCda)
    {
        flagCda=newFlagCda;
    }

    public String getTxtPayCode()
    {
        return txtPayCode;
    }
    
    public void setTxtPayCode(String  newTxtPayCode)
    {
        txtPayCode = newTxtPayCode;
    }
    
    public String getTxtPayCodeName()
    {
        return txtPayCodeName;
    }
    
    public void setTxtPayCodeName(String newTxtPayCodeName)
    {
        txtPayCodeName = newTxtPayCodeName;
    }
    
    public String[] getTxtPayBand()
    {
        return txtPayBand;
    }
    
    public void setTxtPayBand(String[] newTxtPayBand)
    {
        txtPayBand=newTxtPayBand;
    }
    
    public String[] getTxtGrade()
    {
        return txtGrade;
    }
    
    public void setTxtGrade(String[] newTxtGrade)
    {
        txtGrade=newTxtGrade;
    }
    
    public String[] getTxtRate()
    {
        return txtRate;
    }
    
    public void setTxtRate(String[] newTxtRate)
    {
        txtRate=newTxtRate;
    }
    
    public String[] getCboCatg()
    {
        return cboCatg;
    }
    public void setCboCatg(String[] newCboCatg)
    {
        cboCatg = newCboCatg;
    }
}
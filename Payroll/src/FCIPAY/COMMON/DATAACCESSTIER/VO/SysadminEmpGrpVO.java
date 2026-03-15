/* 
    * Module:        ScreenPermitMasterVO.java 
    * Author:        Gaurav Arora   
    * Date Written:  11/2004    
    * Description:   Value Object Class for Permit  Master Screen
    * Revision Log   (mm/dd/yy initials description) 
    * -------------------------------------------------------- 
    * mm/dd/yy xxx  What you changed … 
*/ 


package FCIPAY.COMMON.DATAACCESSTIER.VO;
import FCIPAY.COMMON.WEBTIER.Form.SysadminEmpGrpForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;


public class SysadminEmpGrpVO 
{
    private String lstModuleName=null;
    private String lstScreenName=null;
    private String lstUnMapDesc=null;
    private String lstMapDesc=null;
    private List lstMNameValues= new ArrayList();
    private List lstMNameLabels= new ArrayList();
    private List lstSNameValues= new ArrayList();
    private List lstSNameLabels= new ArrayList();
    private List lstUnMapValues= new ArrayList();
    private List lstUnMapLabels= new ArrayList();
    private List lstMapValues= new ArrayList();
    private List lstMapLabels= new ArrayList();
    private String SAction=null;
    private String SAction1=null;
    private long lEmployeeNo;
    private long lLocationCode;
    private String txtModule=null;
    private String txtGrpDesc=null;
    

    public SysadminEmpGrpVO()
    {
    }

    public String getLstModuleName()
    {
        return lstModuleName;
    }

    public void setLstModuleName(String newLstModuleName)
    {
        lstModuleName = newLstModuleName;
    }

    public String getLstScreenName()
    {
        return lstScreenName;
    }

    public void setLstScreenName(String newLstScreenName)
    {
        lstScreenName = newLstScreenName;
    }

    public String getLstUnMapDesc()
    {
        return lstUnMapDesc;
    }

    public void setLstUnMapDesc(String newLstUnMapDesc)
    {
        lstUnMapDesc = newLstUnMapDesc;
    }

    public String getLstMapDesc()
    {
        return lstMapDesc;
    }

    public void setLstMapDesc(String newLstMapDesc)
    {
        lstMapDesc = newLstMapDesc;
    }

    public List getLstMNameLabels()
    {
        return lstMNameLabels;
    }

    public void setLstMNameLabels(List newLstMNameLabels)
    {
        lstMNameLabels = newLstMNameLabels;
    }

    public List getLstMNameValues()
    {
        return lstMNameValues;
    }

    public void setLstMNameValues(List newLstMNameValues)
    {
        lstMNameValues = newLstMNameValues;
    }

    public List getLstMapLabels()
    {
        return lstMapLabels;
    }

    public void setLstMapLabels(List newLstMapLabels)
    {
        lstMapLabels = newLstMapLabels;
    }

    public List getLstMapValues()
    {
        return lstMapValues;
    }

    public void setLstMapValues(List newLstMapValues)
    {
        lstMapValues = newLstMapValues;
    }

    public List getLstSNameLabels()
    {
        return lstSNameLabels;
    }

    public void setLstSNameLabels(List newLstSNameLabels)
    {
        lstSNameLabels = newLstSNameLabels;
    }

    public List getLstSNameValues()
    {
        return lstSNameValues;
    }

    public void setLstSNameValues(List newLstSNameValues)
    {
        lstSNameValues = newLstSNameValues;
    }

    public List getLstUnMapLabels()
    {
        return lstUnMapLabels;
    }

    public void setLstUnMapLabels(List newLstUnMapLabels)
    {
        lstUnMapLabels = newLstUnMapLabels;
    }

    public List getLstUnMapValues()
    {
        return lstUnMapValues;
    }

    public void setLstUnMapValues(List newLstUnMapValues)
    {
        lstUnMapValues = newLstUnMapValues;
    }

    public String getSAction()
    {
        return SAction;
    }

    public void setSAction(String newSAction)
    {
        SAction = newSAction;
    }

    public String getSAction1()
    {
        return SAction1;
    }

    public void setSAction1(String newSAction1)
    {
        SAction1 = newSAction1;
    }

    public long getlEmployeeNo()
    {
        return lEmployeeNo;
    }

    public void setlEmployeeNo(long lEmployeeNo)
    {
        this.lEmployeeNo = lEmployeeNo;
    }

    public long getlLocationCode()
    {
        return lLocationCode;
    }

    public void setlLocationCode(long lLocationCode)
    {
        this.lLocationCode = lLocationCode;
    }

    public String getTxtGrpDesc()
    {
        return txtGrpDesc;
    }

    public void setTxtGrpDesc(String newTxtGrpDesc)
    {
        txtGrpDesc = newTxtGrpDesc;
    }

    public String getTxtModule()
    {
        return txtModule;
    }

    public void setTxtModule(String newTxtModule)
    {
        txtModule = newTxtModule;
    }
    
}
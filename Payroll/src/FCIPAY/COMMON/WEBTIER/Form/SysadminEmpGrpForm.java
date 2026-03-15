/* 
    * Module:        ScreenPermitMasterForm.java 
    * Author:        Gaurav Arora  
    * Date Written:  11/2004    
    * Description:   Action Form for Permit Master Screen
    * Revision Log   (mm/dd/yy initials description) 
    * -------------------------------------------------------- 
    * mm/dd/yy xxx  What you changed … 
*/ 



package FCIPAY.COMMON.WEBTIER.Form;
import FCIPAY.COMMON.DATAACCESSTIER.VO.SysadminEmpGrpVO;
//import IBA.Finance.BUSINESSTIER.BusinessDelegates.SysadminEmpGrpBD;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.sql.*;
import FCIPAY.COMMON.UTILITY.*;


public class SysadminEmpGrpForm extends ActionForm
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
    
    SysadminEmpGrpVO oSPMVO=new SysadminEmpGrpVO();
    private String txtModule=null;
    private String txtGrpDesc=null;

     /**
     * Reset all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     */
       
     public void reset(ActionMapping mapping, HttpServletRequest request)
    {
               
        this.lstModuleName="";
        this.lstScreenName="";
        this.lstUnMapDesc="";
        this.lstMapDesc="";
        this.lstUnMapLabels=new ArrayList();
        this.lstUnMapValues=new ArrayList();
        this.lstMapLabels=new ArrayList();
        this.lstMapValues=new ArrayList();
        //this.lstMNameValues=new ArrayList();
        //this.lstSNameValues=new ArrayList();
        //this.lstMNameLabels=new ArrayList();
        //this.lstSNameLabels=new ArrayList();
        this.SAction1 = ""; 
        this.txtGrpDesc= null;
        this.txtModule=null;
        
    } 

    /**
     * Validate all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return ActionErrors A list of all errors found.
     */

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
        return super.validate(mapping, request);
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

    public void setSAction(String newsAction)
    {
        SAction = newsAction;
    }

    public String getSAction1()
    {
        return SAction1;
    }

    public void setSAction1(String newsAction1)
    {
        SAction1 = newsAction1;
    }
    public boolean setVO()
    {
        oSPMVO.setLstUnMapDesc(this.lstModuleName);
        oSPMVO.setLstScreenName(this.lstScreenName);
        oSPMVO.setLstUnMapDesc(this.lstUnMapDesc);
        oSPMVO.setLstMapDesc(this.lstMapDesc);
        oSPMVO.setLstMNameLabels(this.lstMNameLabels);
        oSPMVO.setLstMNameValues(this.lstMNameValues);
        oSPMVO.setLstSNameLabels(this.lstMNameLabels);
        oSPMVO.setLstSNameValues(this.lstMNameValues);
        oSPMVO.setLstUnMapValues(this.lstUnMapValues);
        oSPMVO.setLstMapValues(this.lstMapValues);
        oSPMVO.setLstUnMapLabels(this.lstUnMapLabels);
        oSPMVO.setLstMapLabels(this.lstMapLabels);
        oSPMVO.setSAction(this.SAction);
        oSPMVO.setSAction1(this.SAction1);
        oSPMVO.setTxtGrpDesc(this.txtGrpDesc);
        oSPMVO.setTxtModule(this.txtModule);
        return true;
    }

    public SysadminEmpGrpVO getVO()
    {
        return oSPMVO;
    }

    public String getTxtModule()
    {
        return txtModule;
    }

    public void setTxtModule(String newTxtModule)
    {
        txtModule = newTxtModule;
    }

    public String getTxtGrpDesc()
    {
        return txtGrpDesc;
    }

    public void setTxtGrpDesc(String newTxtGrpDesc)
    {
        txtGrpDesc = newTxtGrpDesc;
    }
    
}
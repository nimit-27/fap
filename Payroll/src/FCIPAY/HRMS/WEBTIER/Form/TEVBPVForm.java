/*
    * Module:        TEVBPVForm.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Action Form for TEV Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.HRMS.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import FCIPAY.HRMS.DATAACCESSTIER.VO.TEVBPVVO;
import java.util.List;


public class TEVBPVForm extends ActionForm 
{
    private String lstPeriod= "";
    private String lstClaimNo = "";
    private String txtTravelDesc = "";
    private String txtEmpNo = "";
    private String txtEmpName = "";
    private String txtClaimDate = "";
    private String sAction="";
    private String txtVouchNo = "";
    private String txtDocLoc = "";
    private String txtDocRef = "";
    private String txtDocRem = "";
    private int hideRows=0;
    private String trId ="";

    private String txtSNo = "";
    private String txtPartMast = "";
    private String txtAcctIdMast = "";
    private String txtSlCodeMast = "";
    private String txtChCodeMast = "";
    private String txtCcCodeMast = "";
    private String txtLinkMast = "";
    private String txtDrMast = "";
    private String txtCrMast = "";

    private String txtTotDr = "";
    private String txtTotCr = "";

    private String txtHidMode = "";
    private String txtOpeningTime = "";    
    private String hidSBComments = "";
    
    
    private List voucherDtls = new ArrayList();
     
    private List lstPeriodValues= new ArrayList();
    private List lstPeriodLabels= new ArrayList();
    private List lstClaimNoValues= new ArrayList();
    private List lstClaimNoLabels= new ArrayList();
    TEVBPVVO oTBVO = new TEVBPVVO();
//added by bhavna 04/05/2005
 private String lstPmtMode="";
 private List lstPmtModeValues=new ArrayList();
 private List lstPmtModeLabels=new ArrayList();

 
    
    
/**
    * Reset all properties to their default values.
    * @param mapping The ActionMapping used to select this instance.
    * @param request The HTTP Request we are processing.
*/
    public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstClaimNo = "";
        this.hideRows = 0;
        this.trId = "";
        this.txtAcctIdMast = "";
        this.txtCcCodeMast = "";
        this.txtChCodeMast = "";
        this.txtCrMast = "";
        this.txtDocRef = "";
        this.txtDocRem = "";
        this.txtDrMast = "";
        this.txtEmpName = "";
        this.txtEmpNo = "";
        this.txtHidMode = "new";
        this.txtLinkMast = "";
        this.txtOpeningTime = "";
        this.txtPartMast = "";
        this.txtSlCodeMast = "";
        this.txtSNo = "";
        this.txtTravelDesc = "";
        this.txtVouchNo = "";
        this.hidSBComments = "";
        this.lstPmtMode="";
        this.lstPmtModeLabels=new ArrayList();
        this.lstPmtModeValues=new ArrayList();
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

    public String getsAction()
    {
        return sAction;
    }

    public void setsAction(String newsAction)
    {
        sAction = newsAction;
    }

    public String getLstClaimNo()
    {
        return lstClaimNo;
    }

    public void setLstClaimNo(String newLstClaimNo)
    {
        lstClaimNo = newLstClaimNo;
    }

    public List getLstClaimNoLabels()
    {
        return lstClaimNoLabels;
    }

    public void setLstClaimNoLabels(List newLstClaimNoLabels)
    {
        lstClaimNoLabels = newLstClaimNoLabels;
    }

    public List getLstClaimNoValues()
    {
        return lstClaimNoValues;
    }

    public void setLstClaimNoValues(List newLstClaimNoValues)
    {
        lstClaimNoValues = newLstClaimNoValues;
    }

    public String getLstPeriod()
    {
        return lstPeriod;
    }

    public void setLstPeriod(String newLstPeriod)
    {
        lstPeriod = newLstPeriod;
    }

    public List getLstPeriodLabels()
    {
        return lstPeriodLabels;
    }

    public void setLstPeriodLabels(List newLstPeriodLabels)
    {
        lstPeriodLabels = newLstPeriodLabels;
    }

    public List getLstPeriodValues()
    {
        return lstPeriodValues;
    }

    public void setLstPeriodValues(List newLstPeriodValues)
    {
        lstPeriodValues = newLstPeriodValues;
    }

    public String getTxtClaimDate()
    {
        return txtClaimDate;
    }

    public void setTxtClaimDate(String newTxtClaimDate)
    {
        txtClaimDate = newTxtClaimDate;
    }

    public String getTxtEmpName()
    {
        return txtEmpName;
    }

    public void setTxtEmpName(String newTxtEmpName)
    {
        txtEmpName = newTxtEmpName;
    }

    public String getTxtEmpNo()
    {
        return txtEmpNo;
    }

    public void setTxtEmpNo(String newTxtEmpNo)
    {
        txtEmpNo = newTxtEmpNo;
    }

    public String getTxtTravelDesc()
    {
        return txtTravelDesc;
    }

    public void setTxtTravelDesc(String newTxtTravelDesc)
    {
        txtTravelDesc = newTxtTravelDesc;
    }

    public boolean setVO()
    {
        oTBVO.setLstClaimNo(this.lstClaimNo);
        oTBVO.setLstPeriod(this.lstPeriod);
        oTBVO.setTxtClaimDate(this.txtClaimDate);
        oTBVO.setTxtEmpName(this.txtEmpName);
        oTBVO.setTxtEmpNo(this.txtEmpNo);
        oTBVO.setTxtTravelDesc(this.txtTravelDesc);
        oTBVO.setTxtVouchNo(this.txtVouchNo);
        oTBVO.setTxtDocLoc(this.txtDocLoc);
        oTBVO.setTxtDocRef(this.txtDocRef);
        oTBVO.setTxtDocRem(this.txtDocRem);
        oTBVO.setTrId(this.trId);
        oTBVO.setLstClaimNoValues(this.lstClaimNoValues);
        oTBVO.setLstClaimNoLabels(this.lstClaimNoLabels);
        oTBVO.setVoucherDtls(this.voucherDtls);
        oTBVO.setHidSBComments(this.hidSBComments);
        oTBVO.setTxtTotCr(this.txtTotCr);
        oTBVO.setTxtTotDr(this.txtTotDr);
        oTBVO.setLstPmtMode(this.lstPmtMode);
        return true;
    }

    public TEVBPVVO getVO()
    {
        return oTBVO;
    }

    public String getTxtVouchNo()
    {
        return txtVouchNo;
    }

    public void setTxtVouchNo(String newTxtVouchNo)
    {
        txtVouchNo = newTxtVouchNo;
    }

    public String getTxtDocRef()
    {
        return txtDocRef;
    }

    public void setTxtDocRef(String newTxtDocRef)
    {
        txtDocRef = newTxtDocRef;
    }

    public String getTxtDocLoc()
    {
        return txtDocLoc;
    }

    public void setTxtDocLoc(String newTxtDocLoc)
    {
        txtDocLoc = newTxtDocLoc;
    }

    public String getTxtDocRem()
    {
        return txtDocRem;
    }

    public void setTxtDocRem(String newTxtDocRem)
    {
        txtDocRem = newTxtDocRem;
    }

    public int getHideRows()
    {
        return hideRows;
    }

    public void setHideRows(int newHideRows)
    {
        hideRows = newHideRows;
    }

    public String getTrId()
    {
        return trId;
    }

    public void setTrId(String newTrId)
    {
        trId = newTrId;
    }

    public List getVoucherDtls()
    {
        return voucherDtls;
    }

    public void setVoucherDtls(List newVoucherDtls)
    {
        voucherDtls = newVoucherDtls;
    }

    public String getTxtAcctIdMast()
    {
        return txtAcctIdMast;
    }

    public void setTxtAcctIdMast(String newTxtAcctIdMast)
    {
        txtAcctIdMast = newTxtAcctIdMast;
    }

    public String getTxtCcCodeMast()
    {
        return txtCcCodeMast;
    }

    public void setTxtCcCodeMast(String newTxtCcCodeMast)
    {
        txtCcCodeMast = newTxtCcCodeMast;
    }

    public String getTxtChCodeMast()
    {
        return txtChCodeMast;
    }

    public void setTxtChCodeMast(String newTxtChCodeMast)
    {
        txtChCodeMast = newTxtChCodeMast;
    }

    public String getTxtCrMast()
    {
        return txtCrMast;
    }

    public void setTxtCrMast(String newTxtCrMast)
    {
        txtCrMast = newTxtCrMast;
    }

    public String getTxtDrMast()
    {
        return txtDrMast;
    }

    public void setTxtDrMast(String newTxtDrMast)
    {
        txtDrMast = newTxtDrMast;
    }

    public String getTxtHidMode()
    {
        return txtHidMode;
    }

    public void setTxtHidMode(String newTxtHidMode)
    {
        txtHidMode = newTxtHidMode;
    }

    public String getTxtLinkMast()
    {
        return txtLinkMast;
    }

    public void setTxtLinkMast(String newTxtLinkMast)
    {
        txtLinkMast = newTxtLinkMast;
    }

    public String getTxtOpeningTime()
    {
        return txtOpeningTime;
    }

    public void setTxtOpeningTime(String newTxtOpeningTime)
    {
        txtOpeningTime = newTxtOpeningTime;
    }

    public String getTxtPartMast()
    {
        return txtPartMast;
    }

    public void setTxtPartMast(String newTxtPartMast)
    {
        txtPartMast = newTxtPartMast;
    }

    public String getTxtSNo()
    {
        return txtSNo;
    }

    public void setTxtSNo(String newTxtSNo)
    {
        txtSNo = newTxtSNo;
    }

    public String getTxtSlCodeMast()
    {
        return txtSlCodeMast;
    }

    public void setTxtSlCodeMast(String newTxtSlCodeMast)
    {
        txtSlCodeMast = newTxtSlCodeMast;
    }

    public String getHidSBComments()
    {
        return hidSBComments;
    }

    public void setHidSBComments(String newHidSBComments)
    {
        hidSBComments = newHidSBComments;
    }

    public String getTxtTotCr()
    {
        return txtTotCr;
    }

    public void setTxtTotCr(String newTxtTotCr)
    {
        txtTotCr = newTxtTotCr;
    }

    public String getTxtTotDr()
    {
        return txtTotDr;
    }

    public void setTxtTotDr(String newTxtTotDr)
    {
        txtTotDr = newTxtTotDr;
    }

    public String getLstPmtMode()
    {
        return lstPmtMode;
    }

    public void setLstPmtMode(String newLstPmtMode)
    {
        lstPmtMode = newLstPmtMode;
    }

    public List getLstPmtModeLabels()
    {
        return lstPmtModeLabels;
    }

    public void setLstPmtModeLabels(List newLstPmtModeLabels)
    {
        lstPmtModeLabels = newLstPmtModeLabels;
    }

    public List getLstPmtModeValues()
    {
        return lstPmtModeValues;
    }

    public void setLstPmtModeValues(List newLstPmtModeValues)
    {
        lstPmtModeValues = newLstPmtModeValues;
    }
}
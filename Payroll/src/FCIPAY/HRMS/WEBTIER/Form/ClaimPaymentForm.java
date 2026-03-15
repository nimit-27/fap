/*
    * Module:        CliamPaymentForm.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Action Form for Claim Payment through Voucher Screen
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
import FCIPAY.HRMS.DATAACCESSTIER.VO.ClaimPaymentVO;

public class ClaimPaymentForm extends ActionForm 
{

    private String lstPeriod= "";
    private String lstEmpNo = "";
    private String txtEmpName = "";
    private String txtVouchDate = "";
    private String lstVoucherType = "";
    private String sAction="";
    private String txtVouchNo = "";
    private String txtDocLoc = "";
    private String txtDocRef = "";
    private String txtRemarks = "";
    private String txtModuleId = "";
    private String hidMIdforRetreival = "";
    private String txtHidVouId = "";
    private int hideRows=0;
    
    private String txtSNo = "";
    private String txtPartMast = "";
    private String txtAcctIdMast = "";
    private String txtSlCodeMast = "";
    private String txtChCodeMast = "";
    private String txtCcCodeMast = "";
    private String txtDrMast = "";
    private String txtHidVoucherId = "";
    private String txtHidMode = "";
    private String txtOpeningTime = "";   

    private String txtTotDrAmt = "";
    
    private List voucherDtls = new ArrayList();
     
    private List lstPeriodValues= new ArrayList();
    private List lstPeriodLabels= new ArrayList();
    private List lstEmpNoValues= new ArrayList();
    private List lstEmpNoLabels= new ArrayList();

    private ClaimPaymentVO  oCPVO = new ClaimPaymentVO();

/**
    * Reset all properties to their default values.
    * @param mapping The ActionMapping used to select this instance.
    * @param request The HTTP Request we are processing.
*/
    public void resetForm(ActionMapping mapping, HttpServletRequest request)
    {
        this.lstEmpNo = "";
        this.hideRows = 0;
        this.txtAcctIdMast = "";
        this.txtCcCodeMast = "";
        this.txtChCodeMast = "";
        this.txtDocRef = "";
        this.txtRemarks = "";
        this.txtDrMast = "";
        this.txtEmpName = "";
        this.txtHidMode = "new";        
        this.txtOpeningTime = "";
        this.txtPartMast = "";
        this.txtSlCodeMast = "";
        this.txtSNo = "";
        this.txtVouchNo = "";
        this.lstVoucherType = "";
        this.txtTotDrAmt = "";
        this.lstEmpNoLabels = new ArrayList();
        this.lstEmpNoValues = new ArrayList();
        
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
    
    public int getHideRows()
    {
        return hideRows;
    }

    public void setHideRows(int newHideRows)
    {
        hideRows = newHideRows;
    }

    public String getLstEmpNo()
    {
        return lstEmpNo;
    }

    public void setLstEmpNo(String newLstEmpNo)
    {
        lstEmpNo = newLstEmpNo;
    }

    public List getLstEmpNoLabels()
    {
        return lstEmpNoLabels;
    }

    public void setLstEmpNoLabels(List newLstEmpNoLabels)
    {
        lstEmpNoLabels = newLstEmpNoLabels;
    }

    public List getLstEmpNoValues()
    {
        return lstEmpNoValues;
    }

    public void setLstEmpNoValues(List newLstEmpNoValues)
    {
        lstEmpNoValues = newLstEmpNoValues;
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

    public String getTxtDocLoc()
    {
        return txtDocLoc;
    }

    public void setTxtDocLoc(String newTxtDocLoc)
    {
        txtDocLoc = newTxtDocLoc;
    }

    public String getTxtDocRef()
    {
        return txtDocRef;
    }

    public void setTxtDocRef(String newTxtDocRef)
    {
        txtDocRef = newTxtDocRef;
    }

    public String getTxtDrMast()
    {
        return txtDrMast;
    }

    public void setTxtDrMast(String newTxtDrMast)
    {
        txtDrMast = newTxtDrMast;
    }

    public String getTxtEmpName()
    {
        return txtEmpName;
    }

    public void setTxtEmpName(String newTxtEmpName)
    {
        txtEmpName = newTxtEmpName;
    }

    public String getTxtHidMode()
    {
        return txtHidMode;
    }

    public void setTxtHidMode(String newTxtHidMode)
    {
        txtHidMode = newTxtHidMode;
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

    public String getTxtRemarks()
    {
        return txtRemarks;
    }

    public void setTxtRemarks(String newTxtRemarks)
    {
        txtRemarks = newTxtRemarks;
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

    public String getTxtVouchDate()
    {
        return txtVouchDate;
    }

    public void setTxtVouchDate(String newTxtVouchDate)
    {
        txtVouchDate = newTxtVouchDate;
    }

    public String getTxtVouchNo()
    {
        return txtVouchNo;
    }

    public void setTxtVouchNo(String newTxtVouchNo)
    {
        txtVouchNo = newTxtVouchNo;
    }

    public List getVoucherDtls()
    {
        return voucherDtls;
    }

    public void setVoucherDtls(List newVoucherDtls)
    {
        voucherDtls = newVoucherDtls;
    }    
    
    public boolean setVO()
    {
        oCPVO.setLstEmpNo(this.lstEmpNo);
        oCPVO.setLstPeriod(this.lstPeriod);
        oCPVO.setTxtVouchDate(this.txtVouchDate);
        oCPVO.setTxtEmpName(this.txtEmpName);
        oCPVO.setTxtVouchNo(this.txtVouchNo);
        oCPVO.setTxtDocLoc(this.txtDocLoc);
        oCPVO.setTxtDocRef(this.txtDocRef);
        oCPVO.setTxtRemarks(this.txtRemarks);
        oCPVO.setLstEmpNoValues(this.lstEmpNoValues);
        oCPVO.setLstEmpNoLabels(this.lstEmpNoLabels);
        oCPVO.setVoucherDtls(this.voucherDtls);
        oCPVO.setLstVoucherType(this.lstVoucherType);
        oCPVO.setTxtTotDrAmt(this.txtTotDrAmt);
        oCPVO.setTxtModuleId(this.txtModuleId);
        oCPVO.setHidMIdforRetreival(this.hidMIdforRetreival);
        return true;
    }

    public ClaimPaymentVO getVO()
    {
        return oCPVO;
    }

    public String getLstVoucherType()
    {
        return lstVoucherType;
    }

    public void setLstVoucherType(String newLstVoucherType)
    {
        lstVoucherType = newLstVoucherType;
    }

    public String getTxtTotDrAmt()
    {
        return txtTotDrAmt;
    }

    public void setTxtTotDrAmt(String newTxtTotDrAmt)
    {
        txtTotDrAmt = newTxtTotDrAmt;
    }

    public String getTxtModuleId()
    {
        return txtModuleId;
    }

    public void setTxtModuleId(String newTxtModuleId)
    {
        txtModuleId = newTxtModuleId;
    }

    public String getHidMIdforRetreival()
    {
        return hidMIdforRetreival;
    }

    public void setHidMIdforRetreival(String newHidMIdforRetreival)
    {
        hidMIdforRetreival = newHidMIdforRetreival;
    }

  public String getTxtHidVoucherId()
  {
    return txtHidVoucherId;
  }

  public void setTxtHidVoucherId(String newTxtHidVoucherId)
  {
    txtHidVoucherId = newTxtHidVoucherId;
  }

  public String getTxtHidVouId()
  {
    return txtHidVouId;
  }

  public void setTxtHidVouId(String newTxtHidVouId)
  {
    txtHidVouId = newTxtHidVouId;
  }
}
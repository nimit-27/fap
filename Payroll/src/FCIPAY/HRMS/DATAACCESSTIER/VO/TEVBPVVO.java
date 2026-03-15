/*
    * Module:        TEVBPVVO.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Value Object Class for TEV Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.HRMS.DATAACCESSTIER.VO;
import java.util.*;
import java.util.List;

public class TEVBPVVO 
{
    private String lstPeriod= "";
    private String lstClaimNo = "";
    private String txtTravelDesc = "";
    private String txtEmpNo = "";
    private String txtEmpName = "";
    private String txtClaimDate = "";
    private String sAction="";
    private long lEmployeeNo=0;
    private long lLocationCode=0; 
    private String txtVouchNo="";
    private String txtDocLoc="";
    private String txtDocRef="";
    private String txtDocRem="";
    private String trId ="";
    private String hidSBComments = "";
    private String txtTotDr = "";
    private String txtTotCr = "";

    private List lstClaimNoValues = new ArrayList();
    private List lstClaimNoLabels = new ArrayList();    
    private List voucherDtls = new ArrayList();
     private String lstPmtMode="";
     private List lstPmtModeValues=new ArrayList();
     private List lstPmtModeLabels=new ArrayList();
     private List lstClaimDtls=new ArrayList();
     private String txtDesg="";


    public long getLEmployeeNo()
    {
        return lEmployeeNo;
    }

    public void setLEmployeeNo(long newLEmployeeNo)
    {
        lEmployeeNo = newLEmployeeNo;
    }

    public long getLLocationCode()
    {
        return lLocationCode;
    }

    public void setLLocationCode(long newLLocationCode)
    {
        lLocationCode = newLLocationCode;
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

    public String getLstPeriod()
    {
        return lstPeriod;
    }

    public void setLstPeriod(String newLstPeriod)
    {
        lstPeriod = newLstPeriod;
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

    public String getTxtVouchNo()
    {
        return txtVouchNo;
    }

    public void setTxtVouchNo(String newTxtVouchNo)
    {
        txtVouchNo = newTxtVouchNo;
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

    public String getTxtDocRem()
    {
        return txtDocRem;
    }

    public void setTxtDocRem(String newTxtDocRem)
    {
        txtDocRem = newTxtDocRem;
    }

    public String getTrId()
    {
        return trId;
    }

    public void setTrId(String newTrId)
    {
        trId = newTrId;
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

    public List getVoucherDtls()
    {
        return voucherDtls;
    }

    public void setVoucherDtls(List newVoucherDtls)
    {
        voucherDtls = newVoucherDtls;
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

    public List getLstClaimDtls()
    {
        return lstClaimDtls;
    }

    public void setLstClaimDtls(List newLstClaimDtls)
    {
        lstClaimDtls = newLstClaimDtls;
    }

    public String getTxtDesg()
    {
        return txtDesg;
    }

    public void setTxtDesg(String newTxtDesg)
    {
        txtDesg = newTxtDesg;
    }
}
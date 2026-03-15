/*
    * Module:        ClaimPaymentVO.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Value Object Class for Claim Payment through Voucher Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.HRMS.DATAACCESSTIER.VO;
import java.util.*;
import java.util.List;

public class ClaimPaymentVO 
{
    private String lstPeriod= "";
    private String lstEmpNo = "";
    private String txtEmpName = "";
    private String txtVouchDate = "";
    private String lstVoucherType = "";
    private String sAction="";
    private long lEmployeeNo=0;
    private long lLocationCode=0; 
    private String txtVouchNo="";
    private String txtDocLoc="";
    private String txtDocRef="";
    private String txtRemarks="";
    private String txtTotDrAmt = "";
    private String txtModuleId = "";
    private String txtHidVoucherId = "";
    private String hidMIdforRetreival = "";

    private List lstEmpNoValues = new ArrayList();
    private List lstEmpNoLabels = new ArrayList();    
    private List voucherDtls = new ArrayList();

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

    public String getTxtEmpName()
    {
        return txtEmpName;
    }

    public void setTxtEmpName(String newTxtEmpName)
    {
        txtEmpName = newTxtEmpName;
    }

    public String getTxtRemarks()
    {
        return txtRemarks;
    }

    public void setTxtRemarks(String newTxtRemarks)
    {
        txtRemarks = newTxtRemarks;
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
    
}
/*
    * Module:        ClaimPaymentBean.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Bean for Claim Payment through Voucher Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.HRMS.UTILITY;

public class ClaimPaymentBean 
{ 
    private String recordId = "";
    private long txtSNo = 0 ;
    private String txtParticulars = "" ;
    private String txtAcctId = "";
    private String txtEmpNo = "";
    private String txtChId = "";
    private String txtCCSgrpId = "";
    private String txtDrAmt = "";

    public ClaimPaymentBean(String sRecordId,long sSNo,String sParticulars, String sAcctId,String sEmpNo, String sChId, String sCCSgrpId, String sDrAmt)
    {        
        this.recordId = sRecordId;
        this.txtSNo = sSNo;
        this.txtParticulars = sParticulars;
        this.txtEmpNo = sEmpNo;
        this.txtAcctId = sAcctId;
        this.txtChId = sChId;
        this.txtCCSgrpId = sCCSgrpId;
        this.txtDrAmt = sDrAmt;
    }   

    public String getTxtAcctId()
    {
        return txtAcctId;
    }

    public void setTxtAcctId(String newTxtAcctId)
    {
        txtAcctId = newTxtAcctId;
    }

    public String getTxtCCSgrpId()
    {
        return txtCCSgrpId;
    }

    public void setTxtCCSgrpId(String newTxtCCSgrpId)
    {
        txtCCSgrpId = newTxtCCSgrpId;
    }

    public String getTxtChId()
    {
        return txtChId;
    }

    public void setTxtChId(String newTxtChId)
    {
        txtChId = newTxtChId;
    }

    public String getTxtDrAmt()
    {
        return txtDrAmt;
    }

    public void setTxtDrAmt(String newTxtDrAmt)
    {
        txtDrAmt = newTxtDrAmt;
    }

    public String getTxtEmpNo()
    {
        return txtEmpNo;
    }

    public void setTxtEmpNo(String newTxtEmpNo)
    {
        txtEmpNo = newTxtEmpNo;
    }

    public String getTxtParticulars()
    {
        return txtParticulars;
    }

    public void setTxtParticulars(String newTxtParticulars)
    {
        txtParticulars = newTxtParticulars;
    }

    public long getTxtSNo()
    {
        return txtSNo;
    }

    public void setTxtSNo(long newTxtSNo)
    {
        txtSNo = newTxtSNo;
    }

    public String getRecordId()
    {
        return recordId;
    }

    public void setRecordId(String newRecordId)
    {
        recordId = newRecordId;
    }
    
}
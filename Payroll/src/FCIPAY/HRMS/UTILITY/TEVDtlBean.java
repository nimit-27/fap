/*
    * Module:        TEVDtlBean.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   Bean for TEV Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.HRMS.UTILITY;

public class TEVDtlBean 
{
    private long txtSNo = 0 ;
    private String txtParticulars = "" ;
    private String txtAcctId = "";
    private String txtEmpNo = "";
    private String txtChId = "";
    private String txtCCSgrpId = "";
    private String txtLinkRef = "";
    private String txtDrAmt = "";
    private String txtCrAmt = "";
    private String dtlType = "";

    public TEVDtlBean(String detailType,long sSNo,String sParticulars, String sAcctId,String sEmpNo, String sChId, String sCCSgrpId, String sLinkRef, String sDrAmt, String sCrAmt)
    {
        this.dtlType = detailType;
        this.txtSNo = sSNo;
        this.txtParticulars = sParticulars;
        this.txtEmpNo = sEmpNo;
        this.txtAcctId = sAcctId;
        this.txtChId = sChId;
        this.txtCCSgrpId = sCCSgrpId;
        this.txtLinkRef = sLinkRef;
        this.txtDrAmt = sDrAmt;
        this.txtCrAmt = sCrAmt;
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

    public String getTxtCrAmt()
    {
        return txtCrAmt;
    }

    public void setTxtCrAmt(String newTxtCrAmt)
    {
        txtCrAmt = newTxtCrAmt;
    }

    public String getTxtDrAmt()
    {
        return txtDrAmt;
    }

    public void setTxtDrAmt(String newTxtDrAmt)
    {
        txtDrAmt = newTxtDrAmt;
    }

    public String getTxtLinkRef()
    {
        return txtLinkRef;
    }

    public void setTxtLinkRef(String newTxtLinkRef)
    {
        txtLinkRef = newTxtLinkRef;
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

    public String getTxtEmpNo()
    {
        return txtEmpNo;
    }

    public void setTxtEmpNo(String newTxtEmpNo)
    {
        txtEmpNo = newTxtEmpNo;
    }

    public String getDtlType()
    {
        return dtlType;
    }

    public void setDtlType(String newDtlType)
    {
        dtlType = newDtlType;
    }
}
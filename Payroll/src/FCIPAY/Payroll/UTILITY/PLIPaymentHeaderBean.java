package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseHeaderBean;


public class PLIPaymentHeaderBean extends PayrollBaseHeaderBean implements Serializable 
{
    public PLIPaymentHeaderBean()
    {
    }
    private String tranId;
    private String delTranId;
    private String txtEmpNo;
    private String txtEmpName;
    private String txtStaffCode;
    private String txtCPFCode;
    private String txtDesg;
    private String txtPayScale;
    private String txtCatg;
    private String delUpTran;
    private String txtCPFAuto;
    private String txtInvoice;
    private String txtIncomeTax;
    private String txtNetAmt;
    private String txtPenAmt;
    private String txtPayScaleType;
    private String txtPLIType;
    private String txtPLIPerc;
    private String  txtPLIAdvAmnt;
    private String  txtPLIYear;
    private String  txtEmpCategory;
    private String   optSelectAllEmp;
    
    public String getTxtNetAmt()
    {
      return txtNetAmt;
    }
    public void setTxtNetAmt(String newTxtNetAmt)
    {
      txtNetAmt = newTxtNetAmt;
    }

    public String getDelUpTran()
    {
      return delUpTran;
    }
    public void setDelUpTran(String newDelUpTran)
    {
      delUpTran = newDelUpTran;
    }

    public String getTranId()
    {
      return tranId;
    }
    public void setTranId(String newTranId)
    {
      tranId = newTranId;
    }

    public String getDelTranId()
    {
      return delTranId;
    }
    public void setDelTranId(String newDelTranId)
    {
      delTranId = newDelTranId;
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

    public String getTxtStaffCode()
    {
      return txtStaffCode;
    }
    public void setTxtStaffCode(String newTxtStaffCode)
    {
      txtStaffCode = newTxtStaffCode;
    }

    public String getTxtCPFCode()
    {
      return txtCPFCode;
    }
    public void setTxtCPFCode(String newTxtCPFCode)
    {
      txtCPFCode = newTxtCPFCode;
    }

    public String getTxtDesg()
    {
      return txtDesg;
    }
    public void setTxtDesg(String newTxtDesg)
    {
      txtDesg = newTxtDesg;
    }

    public String getTxtPayScale()
    {
      return txtPayScale;
    }
    public void setTxtPayScale(String newTxtPayScale)
    {
      txtPayScale = newTxtPayScale;
    }

    public String getTxtPayScaleType()
    {
      return txtPayScaleType;
    }
    public void setTxtPayScaleType(String newTxtPayScaleType)
    {
      txtPayScaleType = newTxtPayScaleType;
    }

    public String getTxtCatg()
    {
      return txtCatg;
    }
    public void setTxtCatg(String newTxtCatg)
    {
      txtCatg = newTxtCatg;
    }

    public String getTxtCPFAuto()
    {
      return txtCPFAuto;
    }
    public void setTxtCPFAuto(String newTxtCPFAuto)
    {
      txtCPFAuto = newTxtCPFAuto;
    }
    
    public String getTxtInvoice()
    {
      return txtInvoice;
    }
    public void setTxtInvoice(String newTxtInvoice)
    {
      txtInvoice = newTxtInvoice;
    }
    
    public String getTxtIncomeTax()
    {
      return txtIncomeTax;
    }
    public void setTxtIncomeTax(String newTxtIncomeTax)
    {
      txtIncomeTax = newTxtIncomeTax;
    }


    public String getTxtPenAmt()
    {
       return txtPenAmt;
    }
    public void setTxtPenAmt(String newTxtPenAmt)
    {
     txtPenAmt= newTxtPenAmt;
    }

    public void setTxtPLIType(String txtPLIType) {
        this.txtPLIType = txtPLIType;
    }

    public String getTxtPLIType() {
        return txtPLIType;
    }

    public void setTxtPLIPerc(String txtPLIPerc) {
        this.txtPLIPerc = txtPLIPerc;
    }

    public String getTxtPLIPerc() {
        return txtPLIPerc;
    }

    public void setTxtPLIAdvAmnt(String txtPLIAdvAmnt) {
        this.txtPLIAdvAmnt = txtPLIAdvAmnt;
    }

    public String getTxtPLIAdvAmnt() {
        return txtPLIAdvAmnt;
    }

    public void setTxtPLIYear(String txtPLIYear) {
        this.txtPLIYear = txtPLIYear;
    }

    public String getTxtPLIYear() {
        return txtPLIYear;
    }

    public void setTxtEmpCategory(String txtEmpCategory) {
        this.txtEmpCategory = txtEmpCategory;
    }

    public String getTxtEmpCategory() {
        return txtEmpCategory;
    }

    public void setOptSelectAllEmp(String optSelectAllEmp) {
        this.optSelectAllEmp = optSelectAllEmp;
    }

    public String getOptSelectAllEmp() {
        return optSelectAllEmp;
    }
}

package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
public class PensionEmpShareUploadBean  extends PayrollBaseDetailBean implements Serializable
{

    private String  txtEmployeeNo="";
    private String  txtEmployeeNoDesc="";
    private String  txtGrossAmount="";
    private String  txtTaxableAmount="";
    private String  txtIncomeTax="";
    private String  txtNetAmount="";
    private String  txtRemarks=""; 
 
  
  public PensionEmpShareUploadBean()
  {
  }
 
  public String getTxtEmployeeNo()
  {
    return txtEmployeeNo;
  }
  
  public void setTxtEmployeeNo(String newTxtEmployeeNo)
  {
    txtEmployeeNo = newTxtEmployeeNo;
  }
  public String getTxtEmployeeNoDesc()
  {
    return txtEmployeeNoDesc;
  }
  
  public void setTxtEmployeeNoDesc(String newTxtEmployeeNoDesc)
  {
    txtEmployeeNoDesc = newTxtEmployeeNoDesc;
  }

    public void setTxtGrossAmount(String txtGrossAmount) {
        this.txtGrossAmount = txtGrossAmount;
    }

    public String getTxtGrossAmount() {
        return txtGrossAmount;
    }

    public void setTxtTaxableAmount(String txtTaxableAmount) {
        this.txtTaxableAmount = txtTaxableAmount;
    }

    public String getTxtTaxableAmount() {
        return txtTaxableAmount;
    }

    public void setTxtIncomeTax(String txtIncomeTax) {
        this.txtIncomeTax = txtIncomeTax;
    }

    public String getTxtIncomeTax() {
        return txtIncomeTax;
    }

    public void setTxtNetAmount(String txtNetAmount) {
        this.txtNetAmount = txtNetAmount;
    }

    public String getTxtNetAmount() {
        return txtNetAmount;
    }

    public void setTxtRemarks(String txtRemarks) {
        this.txtRemarks = txtRemarks;
    }

    public String getTxtRemarks() {
        return txtRemarks;
    }
}

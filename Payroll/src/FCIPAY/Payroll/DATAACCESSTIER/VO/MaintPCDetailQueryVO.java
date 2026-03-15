package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class MaintPCDetailQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String txtFromYear;
  private String txtYYMMDtl;
  private String txtPensionId;
  private String txtEmpName;
  private String txtYr;
  private String txtQuarter;
  private String txtUserID;
  private String txtSiteID;
  
  public MaintPCDetailQueryVO()
  {
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtFromYear()
  {
    return txtFromYear;
  }

  public void setTxtFromYear(String newTxtFromYear)
  {
    txtFromYear = newTxtFromYear;
  }
  
    public String getTxtYYMMDtl()
    {
        return txtYYMMDtl;
    }
    public void setTxtYYMMDtl(String newTxtYYMMDtl)
    {
        txtYYMMDtl = newTxtYYMMDtl;
    }

    public void setTxtPensionId(String txtPensionId) {
        this.txtPensionId = txtPensionId;
    }

    public String getTxtPensionId() {
        return txtPensionId;
    }

    public void setTxtEmpName(String txtEmpName) {
        this.txtEmpName = txtEmpName;
    }

    public String getTxtEmpName() {
        return txtEmpName;
    }

    public void setTxtYr(String txtYr) {
        this.txtYr = txtYr;
    }

    public String getTxtYr() {
        return txtYr;
    }

    public void setTxtQuarter(String txtQuarter) {
        this.txtQuarter = txtQuarter;
    }

    public String getTxtQuarter() {
        return txtQuarter;
    }

    public void setTxtUserID(String txtUserID) {
        this.txtUserID = txtUserID;
    }

    public String getTxtUserID() {
        return txtUserID;
    }

    public void setTxtSiteID(String txtSiteID) {
        this.txtSiteID = txtSiteID;
    }

    public String getTxtSiteID() {
        return txtSiteID;
    }
}

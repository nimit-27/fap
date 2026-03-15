package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;


public class EmpIncrQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String screenName;  
    private String txtStagIncrAmt;
    private String txtStagEffDt;
      private String txtTabType;
      private String forwardedPage;
 // private String txtAdvIncrType;
  //private String txtEmpLastName;

  public EmpIncrQueryVO()
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

  public String getScreenName()
  {
    return screenName;
  }

  public void setScreenName(String newScreenName)
  {
    screenName = newScreenName;
  }

  /*public String getTxtEmpLastName()
  {
    return txtEmpLastName;
  }

  public void setTxtEmpLastName(String newTxtEmpLastName)
  {
    txtEmpLastName = newTxtEmpLastName;
  }*/

    public void setTxtStagIncrAmt(String txtStagIncrAmt) {
        this.txtStagIncrAmt = txtStagIncrAmt;
    }

    public String getTxtStagIncrAmt() {
        return txtStagIncrAmt;
    }

    public void setTxtStagEffDt(String txtStagEffDt) {
        this.txtStagEffDt = txtStagEffDt;
    }

    public String getTxtStagEffDt() {
        return txtStagEffDt;
    }

    public void setTxtTabType(String txtTabType) {
        this.txtTabType = txtTabType;
    }

    public String getTxtTabType() {
        return txtTabType;
    }

    public void setForwardedPage(String forwardedPage) {
        this.forwardedPage = forwardedPage;
    }

    public String getForwardedPage() {
        return forwardedPage;
    }
}

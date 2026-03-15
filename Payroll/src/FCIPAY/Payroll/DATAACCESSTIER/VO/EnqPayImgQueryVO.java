package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class EnqPayImgQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String txtYtm;
  private String txtPenDed;

  public EnqPayImgQueryVO()
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

  public String getTxtYtm()
  {
    return txtYtm;
  }

  public void setTxtYtm(String newTxtYtm)
  {
    txtYtm = newTxtYtm;
  }


    public void setTxtPenDed(String txtPenDed) {
        this.txtPenDed = txtPenDed;
    }

    public String getTxtPenDed() {
        return txtPenDed;
    }
}

package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;

public class MaintPFDetailQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String txtFromYear;
  private String txtPfType;
  private String txtYYMMDtl;
  
  public MaintPFDetailQueryVO()
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

  public String getTxtPfType()
  {
    return txtPfType;
  }

  public void setTxtPfType(String newTxtPfType)
  {
    txtPfType = newTxtPfType;
  }
  
    public String getTxtYYMMDtl()
    {
        return txtYYMMDtl;
    }
    public void setTxtYYMMDtl(String newTxtYYMMDtl)
    {
        txtYYMMDtl = newTxtYYMMDtl;
    }
}
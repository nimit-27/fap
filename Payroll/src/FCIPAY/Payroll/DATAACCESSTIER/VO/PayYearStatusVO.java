package FCIPAY.Payroll.DATAACCESSTIER.VO;

public class PayYearStatusVO
{
  private String hdnCurYYMM;
  private String hdnPayStatus;

  public PayYearStatusVO()
  {
  }

  public String getHdnCurYYMM()
  {
    return hdnCurYYMM;
  }

  public void setHdnCurYYMM(String newHdnCurYYMM)
  {
    hdnCurYYMM = newHdnCurYYMM;
  }

  public String getHdnPayStatus()
  {
    return hdnPayStatus;
  }

  public void setHdnPayStatus(String newHdnPayStatus)
  {
    hdnPayStatus = newHdnPayStatus;
  }
}
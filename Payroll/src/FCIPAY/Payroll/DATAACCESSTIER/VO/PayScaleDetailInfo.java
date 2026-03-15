package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;


public class PayScaleDetailInfo extends BaseDetailInfo implements Serializable
{
  private String txtRevYYMM;
  private String lstPayScale;
  //added by sakshi starts 26.12.2008
 private String txtPayScaleType;
  public String getTxtPayScaleType()
  {
    return txtPayScaleType;
  }

  public void setTxtPayScaleType(String newTxtPayScaleType)
  {
    txtPayScaleType = newTxtPayScaleType;
  }
// added by sakshi ends 26.12.2008
  public PayScaleDetailInfo()
  {
  }

  public String getTxtRevYYMM()
  {
    return txtRevYYMM;
  }

  public void setTxtRevYYMM(String newTxtRevYYMM)
  {
    txtRevYYMM = newTxtRevYYMM;
  }

  public String getLstPayScale()
  {
    return lstPayScale;
  }

  public void setLstPayScale(String newLstPayScale)
  {
    lstPayScale = newLstPayScale;
  }
}
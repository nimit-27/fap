package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;
import java.io.Serializable;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

public class EmpPenalityQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtEmpNo;
  private String txtPenaltyId;
  private String penaType;
  private String screenName;
  private String newPenaEffDate;
  private String txtPenaEffDateTo;
  private String txtIncrType;
  private String remarks;
  private String txtWaiveAmtPrt;
  private String txtWaiveDt;
  private String txtWaiveAmtRmn;
  private String incrWaveFrm;
  private String incrWaveTo;
  private String txtReinstateDt;
  private String txtReinstRsn;

  public EmpPenalityQueryVO()
  {
  }

  public String getTxtIncrType()
  {
    return txtIncrType;
  }

  public void setTxtIncrType(String newTxtIncrType)
  {
    txtIncrType = newTxtIncrType;
  }

  public String getTxtPenaltyId()
  {
    return txtPenaltyId;
  }

  public void setTxtPenaltyId(String newTxtPenaltyId)
  {
    txtPenaltyId = newTxtPenaltyId;
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
  public String getPenaType()
  {
    return penaType;
  }

  public void setPenaType(String newPenaType)
  {
    penaType = newPenaType;
  }
  public String getRemarks()
  {
    return remarks;
  }
  public void setRemarks(String newRemarks)
  {
    remarks = newRemarks;
  }
  public String getNewPenaEffDate()
  {
    return newPenaEffDate;
  }

  public void setNewPenaEffDate(String newNewPenaEffDate)
  {
    newPenaEffDate = newNewPenaEffDate;
  }
  public String getTxtPenaEffDateTo()
  {
    return txtPenaEffDateTo;
  }

  public void setTxtPenaEffDateTo(String newTxtPenaEffDateTo)
  {
    txtPenaEffDateTo = newTxtPenaEffDateTo;
  }
  public String getTxtWaiveAmtPrt()
  {
    return txtWaiveAmtPrt;
  }
  public void setTxtWaiveAmtPrt(String newTxtWaiveAmtPrt)
  {
    txtWaiveAmtPrt = newTxtWaiveAmtPrt;
  }
  public String getTxtWaiveDt()
  {
    return txtWaiveDt;
  }
  public void setTxtWaiveDt(String newTxtWaiveDt)
  {
    txtWaiveDt = newTxtWaiveDt;
  }
  public String getTxtWaiveAmtRmn()
  {
    return txtWaiveAmtRmn;
  }
  public void setTxtWaiveAmtRmn(String newTxtWaiveAmtRmn)
  {
    txtWaiveAmtRmn = newTxtWaiveAmtRmn;
  }
    public String getIncrWaveFrm() {
        return incrWaveFrm;
    }
    public void setIncrWaveFrm(String incrWaveFrm) {
        this.incrWaveFrm = incrWaveFrm;
    }
    public String getIncrWaveTo() {
        return incrWaveTo;
    }
    public void setIncrWaveTo(String incrWaveTo) {
        this.incrWaveTo = incrWaveTo;
    }
  public String getTxtReinstateDt()
  {
    return txtReinstateDt;
  }
  public void setTxtReinstateDt(String newTxtReinstateDt)
  {
    txtReinstateDt = newTxtReinstateDt;
  }
  public String getTxtReinstRsn()
  {
    return txtReinstRsn;
  }
  public void setTxtReinstRsn(String newTxtReinstRsn)
  {
    txtReinstRsn = newTxtReinstRsn;
  }
}
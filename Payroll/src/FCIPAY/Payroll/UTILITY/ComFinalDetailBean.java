package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;
import FCIPAY.Payroll.UTILITY.PayrollBaseDetailBean;

public class ComFinalDetailBean extends PayrollBaseDetailBean implements Serializable 
{
  private String txtPayCode;
  private String txtDesc;
  private String txtAmt;
  private String txtSerialNo;
  private String txtTransMastId;
  private String txtOutAmt;
  private String txtRecFlag;
  private String txtOldNewFlag;
  private String txtDednAdjFlag;
  private String chkManDednFlag;
  
  public ComFinalDetailBean()
  {
  }
  
  
   public String getTxtOldNewFlag()
  {
    return txtOldNewFlag;
  }

  public void setTxtOldNewFlag(String newTxtOldNewFlag)
  {
    txtOldNewFlag = newTxtOldNewFlag;
  }
  
  

  public String getTxtPayCode()
  {
    return txtPayCode;
  }

  public void setTxtPayCode(String newTxtPayCode)
  {
    txtPayCode = newTxtPayCode;
  }

  public String getTxtDesc()
  {
    return txtDesc;
  }

  public void setTxtDesc(String newTxtDesc)
  {
    txtDesc = newTxtDesc;
  }

  public String getTxtAmt()
  {
    return txtAmt;
  }

  public void setTxtAmt(String newTxtAmt)
  {
    txtAmt = newTxtAmt;
  }

  public String getTxtSerialNo()
  {
    return txtSerialNo;
  }

  public void setTxtSerialNo(String newTxtSerialNo)
  {
    txtSerialNo = newTxtSerialNo;
  }

  public String getTxtTransMastId()
  {
    return txtTransMastId;
  }

  public void setTxtTransMastId(String newTxtTransMastId)
  {
    txtTransMastId = newTxtTransMastId;
  }

  public String getTxtOutAmt()
  {
    return txtOutAmt;
  }

  public void setTxtOutAmt(String newTxtOutAmt)
  {
    txtOutAmt = newTxtOutAmt;
  }

  public String getTxtRecFlag()
  {
    return txtRecFlag;
  }

  public void setTxtRecFlag(String newTxtRecFlag)
  {
    txtRecFlag = newTxtRecFlag;
  }

  public String getTxtDednAdjFlag()
  {
    return txtDednAdjFlag;
  }

  public void setTxtDednAdjFlag(String newTxtDednAdjFlag)
  {
    txtDednAdjFlag = newTxtDednAdjFlag;
  }

    public void setChkManDednFlag(String chkManDednFlag) {
        this.chkManDednFlag = chkManDednFlag;
    }

    public String getChkManDednFlag() {
        return chkManDednFlag;
    }
}

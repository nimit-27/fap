package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;


public class ComFinalSetBean implements Serializable 
{
  private String txtPayCode="";
  private String txtDesc="";
  private String txtAmt="";
  private String txtTransMastId;

  public ComFinalSetBean()
  {
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
  
  public String getTxtTransMastId()
  {
    return txtTransMastId;
  }

  public void setTxtTransMastId(String newTxtTransMastId)
  {
    txtTransMastId = newTxtTransMastId;
  }

}
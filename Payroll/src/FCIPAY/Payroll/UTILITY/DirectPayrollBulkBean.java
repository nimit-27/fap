    /*
    * Module:        DirectPayrollBulkBean.java
    * Author:        Aqeel Ahmed
    * Date Written:  December 2008
    * Description:   Bean Class for Maintaining Direct Payroll Bulk
    * Revision Log  (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
    */

package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;

public class DirectPayrollBulkBean  extends PayrollBaseDetailBean implements Serializable
{
    private String txtSrNo = "";
    private String txtEmpNo = "";
    private String txtName = "";    
    private String txtSrlNo;
    private String txtDsgn;
    private String txtCateg;
    private String txtPresentPOP;
  

    public DirectPayrollBulkBean()
    {
    }

    public DirectPayrollBulkBean(String sEmpNo,String sEmpName, String sSrlNo)
    {
        //txtSrNo=sSrNo;
        txtEmpNo = sEmpNo;
        txtName = sEmpName;        
        txtSrlNo=sSrlNo;        
    }

 public String getTxtSrNo()
  {
    return txtSrNo;
  }

  public void setTxtSrNo(String newTxtSrNo)
  {
    txtSrNo = newTxtSrNo;
  }

  public String getTxtEmpNo()
  {
    return txtEmpNo;
  }

  public void setTxtEmpNo(String newTxtEmpNo)
  {
    txtEmpNo = newTxtEmpNo;
  }

  public String getTxtName()
  {
    return txtName;
  }

  public void setTxtName(String newTxtName)
  {
    txtName = newTxtName;
  }
  
   public String getTxtDsgn()
  {
    return txtDsgn;
  }
  
  public void setTxtDsgn(String newTxtDsgn)
  {
    txtDsgn = newTxtDsgn;
  }
  
  public String getTxtCateg()
  {
    return txtCateg;
  }

  public void setTxtCateg(String newTxtCateg)
  {
    txtCateg = newTxtCateg;
  }
  
  public String getTxtPresentPOP()
  {
    return txtPresentPOP;
  }

  public void setTxtPresentPOP(String newTxtPresentPOP)
  {
    txtPresentPOP = newTxtPresentPOP;
  }
  
  

  public String getTxtSrlNo()
  {
    return txtSrlNo;
  }

  public void setTxtSrlNo(String newTxtSrlNo)
  {
    txtSrlNo = newTxtSrlNo;
  }

  

}
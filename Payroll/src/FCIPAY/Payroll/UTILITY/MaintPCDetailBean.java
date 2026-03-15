
package FCIPAY.Payroll.UTILITY;
import java.io.Serializable;


public class MaintPCDetailBean extends PayrollBaseDetailBean implements Serializable 
{
  private String txtYearMon = "";
  private String txtEmpSub = "";
  private String txtEmpCon = "";
  private String txtVolPc = "";
  private String txtRemDate;
  private String txtArrEmp="";
  private String txtArrEmpr="";
  private String txtNoOfDays="";
 
  
  public MaintPCDetailBean()
  {
  }

 public MaintPCDetailBean(String sYearMon,String sEmpSub,String sEmpCon,String sVolPc)
  {
  
   txtYearMon=sYearMon;
   txtEmpSub=sEmpSub;
   txtEmpCon=sEmpCon;
   txtVolPc=sVolPc;
  }


    public void setTxtYearMon(String txtYearMon) {
        this.txtYearMon = txtYearMon;
    }

    public String getTxtYearMon() {
        return txtYearMon;
    }

    public void setTxtEmpSub(String txtEmpSub) {
        this.txtEmpSub = txtEmpSub;
    }

    public String getTxtEmpSub() {
        return txtEmpSub;
    }

    public void setTxtEmpCon(String txtEmpCon) {
        this.txtEmpCon = txtEmpCon;
    }

    public String getTxtEmpCon() {
        return txtEmpCon;
    }

    public void setTxtVolPc(String txtVolPc) {
        this.txtVolPc = txtVolPc;
    }

    public String getTxtVolPc() {
        return txtVolPc;
    }

    public void setTxtRemDate(String txtRemDate) {
        this.txtRemDate = txtRemDate;
    }

    public String getTxtRemDate() {
        return txtRemDate;
    }

    public void setTxtArrEmp(String txtArrEmp) {
        this.txtArrEmp = txtArrEmp;
    }

    public String getTxtArrEmp() {
        return txtArrEmp;
    }

    public void setTxtArrEmpr(String txtArrEmpr) {
        this.txtArrEmpr = txtArrEmpr;
    }

    public String getTxtArrEmpr() {
        return txtArrEmpr;
    }

    public void setTxtNoOfDays(String txtNoOfDays) {
        this.txtNoOfDays = txtNoOfDays;
    }

    public String getTxtNoOfDays() {
        return txtNoOfDays;
    }
}

package FCIPAY.Payroll.DATAACCESSTIER.VO;

import FCIPAY.Payroll.common.vo.BaseDetailInfo;

import java.io.Serializable;

public class PLIPayCanDetailInfo extends BaseDetailInfo implements Serializable
{
    private String txtPLIYear;    
    private String txtEmpNo;  
    private String screenModeFlag;   
    private String txtLocId;
    private String txtInvoice;
    private String screenName;
    
    public PLIPayCanDetailInfo() 
    {        
    }

    public void setTxtPLIYear(String txtPLIYear) {
        this.txtPLIYear = txtPLIYear;
    }

    public String getTxtPLIYear() {
        return txtPLIYear;
    }

    public void setTxtEmpNo(String txtEmpNo) {
        this.txtEmpNo = txtEmpNo;
    }

    public String getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setScreenModeFlag(String screenModeFlag) {
        this.screenModeFlag = screenModeFlag;
    }

    public String getScreenModeFlag() {
        return screenModeFlag;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }

    public void setTxtInvoice(String txtInvoice) {
        this.txtInvoice = txtInvoice;
    }

    public String getTxtInvoice() {
        return txtInvoice;
    }
    
    public String getScreenName()
    {
      return screenName;
    }

    public void setscreenName(String newScreenName)
    {
      screenName = newScreenName;
    }
}

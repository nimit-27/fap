package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;

import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;

import java.io.Serializable;

public class NWNPLbrHndlngAttndQueryVO extends PayrollBaseQueryVO implements Serializable
{
  private String txtYYMM;
  private String lstLabourType;
  private String txtGangId;
  private String txtGangName;
  private String txtLocId;
  
  private String hdnEmpLbrFlag;


    public void setTxtYYMM(String txtYYMM) {
        this.txtYYMM = txtYYMM;
    }

    public String getTxtYYMM() {
        return txtYYMM;
    }

    public void setLstLabourType(String lstLabourType) {
        this.lstLabourType = lstLabourType;
    }

    public String getLstLabourType() {
        return lstLabourType;
    }

    public void setTxtGangId(String txtGangId) {
        this.txtGangId = txtGangId;
    }

    public String getTxtGangId() {
        return txtGangId;
    }

    public void setTxtGangName(String txtGangName) {
        this.txtGangName = txtGangName;
    }

    public String getTxtGangName() {
        return txtGangName;
    }

    public void setTxtLocId(String txtLocId) {
        this.txtLocId = txtLocId;
    }

    public String getTxtLocId() {
        return txtLocId;
    }

    public void setHdnEmpLbrFlag(String hdnEmpLbrFlag) {
        this.hdnEmpLbrFlag = hdnEmpLbrFlag;
    }

    public String getHdnEmpLbrFlag() {
        return hdnEmpLbrFlag;
    }
}

package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class MaintPcDtlComboVO extends PayrollBaseQueryVO implements Serializable
{
  private ArrayList adjPensionHdrList;
  private ArrayList adjPensionDtlList;

  public MaintPcDtlComboVO()
  {
  }


    public void setAdjPensionHdrList(ArrayList adjPensionHdrList) {
        this.adjPensionHdrList = adjPensionHdrList;
    }

    public ArrayList getAdjPensionHdrList() {
        return adjPensionHdrList;
    }

    public void setAdjPensionDtlList(ArrayList adjPensionDtlList) {
        this.adjPensionDtlList = adjPensionDtlList;
    }

    public ArrayList getAdjPensionDtlList() {
        return adjPensionDtlList;
    }
}

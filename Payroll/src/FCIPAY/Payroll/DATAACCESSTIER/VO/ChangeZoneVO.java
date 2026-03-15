package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;

public class ChangeZoneVO extends PayrollBaseQueryVO implements Serializable
{
    private String txtEmpNo;
    private String txtDateFrom;
    private String txtDateTo;
    public ChangeZoneVO()
    {
    }
      
    public String getTxtEmpNo()
    {
        return txtEmpNo;
    }
   
    public void setTxtEmpNo(String newTxtEmpNo)
    {
        txtEmpNo=newTxtEmpNo;
    }
    
    public String geTxtDateFrom()
    {
        return txtDateFrom;
    }
    public void setTxtDateFrom(String newTxtDateFrom)
    {
        txtDateFrom=newTxtDateFrom ;
    }
    
    public String geTxtDateTo()
    {
        return txtDateTo;
    }
}
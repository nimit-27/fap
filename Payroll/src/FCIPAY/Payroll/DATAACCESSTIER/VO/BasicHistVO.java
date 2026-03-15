package FCIPAY.Payroll.DATAACCESSTIER.VO;

import java.io.Serializable;

public class BasicHistVO extends PayrollBaseQueryVO implements Serializable
{
    private String txtEmpNo;
    private String txtDateFrom;
    private String txtDateTo;
    public BasicHistVO()
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

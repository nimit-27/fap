package FCIPAY.Payroll.DATAACCESSTIER.VO;

import FCIPAY.Payroll.common.vo.BaseDetailInfo;

import java.io.Serializable;

public class BasicHistDetailInfo extends BaseDetailInfo implements Serializable 
{
    private String txtEmpNo;
    private String txtYYMMFrom;
    private String txtYYMMTo;

    public String getTxtEmpNo()
    {
        return txtEmpNo;
    }
    
    public void setTxtEmpNo(String newTxtEmpNo)
    {
        txtEmpNo=newTxtEmpNo;
    }
    
    public String getTxtYYMMFrom()
    {
        return txtYYMMFrom;
    }
    public void setTxtYYMMFrom(String newTxtDateFrom)
    {
        txtYYMMFrom=newTxtDateFrom ;
    }
    
    public String getTxtYYMMTo()
    {
        return txtYYMMTo;
    }
    public void setTxtYYMMTo(String newTxtYYMMTo)
    {
        txtYYMMTo=newTxtYYMMTo;
    }
}

package FCIPAY.Payroll.Labour.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
//import FCIPAY.Payroll.common.vo.BaseHeaderVO;

import java.util.ArrayList;
import java.io.Serializable;

public class KotLbrOprDetailsVO extends PayrollBaseQueryVO implements Serializable 
{
    private String txtBagType;
    private String txtEffFromDt;
    private String txtEffToDt;
    private String txtOperationID; 
    private String txtOperationDesc; 
  public KotLbrOprDetailsVO()
  {
  }
  
    public String getTxtBagType()
    {
      return txtBagType;
    }
    
    public void setTxtBagType(String newTxtBagType)
    {
      txtBagType=newTxtBagType;
    }
    
   public String getTxtEffFromDt()
    {
      return txtEffFromDt;
    }
    
    public void setTxtEffFromDt(String newTxtEffFromDt)
    {
      txtEffFromDt=newTxtEffFromDt;
    }  
    
     public String getTxtEffToDt()
    {
      return txtEffToDt;
    }
    
    public void setTxtEffToDt(String newTxtEffToDt)
    {
      txtEffToDt=newTxtEffToDt;
    }  
    
   public String getTxtOperationID()
    {
      return txtOperationID;
    }
    
    public void setTxtOperationID(String newTxtOperationID)
    {
      txtOperationID=newTxtOperationID;
    }    
    
   public String getTxtOperationDesc()
    {
      return txtOperationDesc;
    }
    
    public void setTxtOperationDesc(String newTxtOperationDesc)
    {
      txtOperationDesc=newTxtOperationDesc;
    }    
    
}
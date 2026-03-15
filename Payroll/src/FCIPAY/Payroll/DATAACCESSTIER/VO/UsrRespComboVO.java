package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.io.Serializable;
import java.util.ArrayList;

public class UsrRespComboVO extends PayrollBaseQueryVO implements Serializable
{  
    private ArrayList respList;
    
    public UsrRespComboVO()
    {
    }
  
    public ArrayList getRespList() {
		return respList;
	}
	public void setRespList(ArrayList respList) {
		this.respList = respList;
	}
}
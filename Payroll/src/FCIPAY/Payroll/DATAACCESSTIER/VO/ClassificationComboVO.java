package FCIPAY.Payroll.DATAACCESSTIER.VO;
import FCIPAY.Payroll.DATAACCESSTIER.VO.PayrollBaseQueryVO;
import java.io.Serializable;
import java.util.ArrayList;

public class ClassificationComboVO extends PayrollBaseQueryVO implements Serializable
{
    private ArrayList classificationTypList;
    
    public ClassificationComboVO()
    {
    }
    
    public ArrayList getClassificationTypList()
    {
      return classificationTypList;
    }
  
    public void setClassificationTypList(ArrayList newClassificationTypList)
    {
      classificationTypList = newClassificationTypList;
    }
}
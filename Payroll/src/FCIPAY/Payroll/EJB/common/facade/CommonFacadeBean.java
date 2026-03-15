package FCIPAY.Payroll.EJB.common.facade;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import FCIPAY.Payroll.common.xml.vo.LOV;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.bean.LOVBean;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import java.util.ArrayList;
import java.util.Iterator;
public class CommonFacadeBean implements SessionBean 
{
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
  }
  
  public ArrayList getLOVData(LOV oLOV, String sSearchCondition) throws EnrgiseSystemException
  {
/*    String sQuery = "SELECT " + oLOV.get_ID() + " , " + oLOV.get_Code() + " , " + oLOV.get_Description() + " FROM " + oLOV.get_Table();
    if(sSearchCondition != null)
    {
      sQuery = sQuery + " WHERE " + oLOV.get_SearchField() + " LIKE '" + sSearchCondition + "%' ";
    }
    if(oLOV.get_OrderBy() != null)
    {
      sQuery = sQuery + " ORDER BY " + oLOV.get_OrderBy();
    }
    System.out.println(sQuery);
    DBUtilitiesBean oBean = new DBUtilitiesBean();
    ArrayList oList = oBean.executeQuery(sQuery);

      LOVBean oLOVBean;
      int count = 0;
      QueryRow oRow = null;
      Iterator oIt = oList.iterator();
      while(oIt.hasNext())
      {
          if(count == 0)
          {
             oList = new ArrayList();
          }
          count++;
          oRow = (QueryRow)oIt.next();
          oLOVBean = new LOVBean();
          oLOVBean.setDetailId(Double.toString(oRow.get(oLOV.get_ID()).getDouble()));
          oLOVBean.setDetailCode(oRow.get(oLOV.get_Code()).getString());
          oLOVBean.setDetailDesc(oRow.get(oLOV.get_Description()).getString());
          oList.add(oLOVBean);
      }
    return oList; */
    return null;
  }
}
package FCIPAY.COMMON.WEBTIER.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.COMMON.UTILITY.*;
import FCIPAY.COMMON.WEBTIER.Form.RespCreatUpdtForm;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;
import org.apache.struts.action.ActionForm;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.lang.reflect.InvocationTargetException;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import java.util.ArrayList;
import FCIPAY.COMMON.DATAACCESSTIER.DAO.SA_ScreenEmpMapDAO;
import FCIPAY.COMMON.UTILITY.comboBean;
import java.util.Iterator;
import FCIPAY.Payroll.EJB.common.helper.InputDBObject;

public class ResponsibilityCreateAction extends BaseAction
{
  public ResponsibilityCreateAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
       
      BaseForm oBaseForm = (BaseForm)form;      
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();	  
      String aScreenAction = (String)(request.getParameter("param1"));
      BaseBD oBaseBD = getDetailBusinessDelegate(form);
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      RespCreatUpdtForm fedoForm = (RespCreatUpdtForm)oBaseForm; 
      String sHdnAction = fedoForm.getHdnAction();
      if (sHdnAction.equals("headerlist"))
      {
         SA_ScreenEmpMapDAO oSA_ScreenEmpMapDAO = new SA_ScreenEmpMapDAO();
         ArrayList hdrList=oSA_ScreenEmpMapDAO.getHeaderDtls(fedoForm.getLstModule());
         fedoForm.setHeaderList(hdrList);
      }
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);   
  }
  
  public ArrayList getScreensName(String headername) throws EnrgiseSystemException, EnrgiseApplicationException 
    {
        String screen="";        
        ArrayList tscreenList=new ArrayList();
        Iterator oIt = null;
        QueryRow oRow = null;      
        ArrayList oOutArray; 
        ArrayList oParameters = new ArrayList(); //Input Parameters      
        DBUtilitiesBean oBean = new DBUtilitiesBean(); 
        
        try
        {
            String idString="";
            String code="";
            long idLong=0;
            oParameters = new ArrayList();
            oParameters.add(new InputDBObject(1,FCIPAY.Payroll.EJB.common.helper.ParameterTypes.VARCHAR,headername));            
            oOutArray = oBean.executeQuery(oParameters,FCIPAY.COMMON.DATAACCESSTIER.SQLQueries.ScreenAcessQueries.SQL_GETSCREENNAMES); 
            oIt = oOutArray.iterator();
            while(oIt.hasNext())
            {
                    oRow = (QueryRow)oIt.next();
                    screen = oRow.get("level1").getString();
                    tscreenList.add(new comboBean(screen,screen));
            }

        }
        catch(Exception e)
        {
              throw new EnrgiseSystemException(e);
        }     
            
        return tscreenList;
    }

}
package FCIPAY.Payroll.common.webtier.action;
import org.apache.struts.action.ActionForm;
import FCIPAY.Payroll.common.utility.LOVManager;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.ArrayList;
import java.util.StringTokenizer;
import FCIPAY.Payroll.common.webtier.form.BaseLOVForm;
import FCIPAY.Payroll.common.businessdelegate.LOVBD;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.xml.vo.LOVInfo;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import FCIPAY.Payroll.common.vo.LovVO;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.webtier.action.GetInsertAction;

public class LOVAction  extends BaseAction
{
  public LOVAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseLOVForm oBaseLOVForm = (BaseLOVForm)form;
      
      //First time the form is submitted for bean:define
      if(oBaseLOVForm.getTxtHidAction().equals("FirstTime"))
      {
        //The totCols parameter is used to check for further 
        oBaseLOVForm.setTxtHidTotCols(-1);
        //String inputTxt = oBaseLOVForm.getTxtInputField(); // added by devendra
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
      }
      
      if(oBaseLOVForm.getTxtHidAction().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.FIRST_LOAD))
      {
         oBaseLOVForm.onLoadReset();
        
      }
      
      //Search
      else if(oBaseLOVForm.getTxtHidAction().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.SEARCH_RECORD))
      {
     
        LOVBD oLOVBD = new LOVBD();
        LOVInfo oLOVInfo = FCIPAY.Payroll.common.utility.LOVManager.getInstance().getCachedObject(oBaseLOVForm.getLovKey());
        LovVO oLovVO= new LovVO();
        LovQueryVO oLOVQueryVO= new LovQueryVO();
        
        StringTokenizer stParameters= new StringTokenizer(oBaseLOVForm.getQueryParam(),",");
        String sKeyValuePair;
        while(stParameters.hasMoreTokens())
        {
          sKeyValuePair=stParameters.nextToken();
          StringTokenizer stKeyVal= new StringTokenizer(sKeyValuePair ,"=");
          String sKey=null;
          String sValue=null;
          while(stKeyVal.hasMoreTokens())
          {
            sKey=stKeyVal.nextToken();
            sValue=stKeyVal.nextToken();
          }
          oLOVQueryVO.setProperty(sKey,sValue);
        }
      
        oLOVQueryVO.setSearchField1(oBaseLOVForm.getSearchField1());
        oLOVQueryVO.setSearchField2(oBaseLOVForm.getSearchField2());
        oLOVQueryVO.setSearchField3(oBaseLOVForm.getSearchField3());
        oLOVQueryVO.setSearchField4(oBaseLOVForm.getSearchField4()); // added by devendra on 16th aug 2010
//        System.out.println(oLOVQueryVO.values().toString());
        oLovVO = oLOVBD.getLOVData(oLOVInfo,oLOVQueryVO);
        
        if(oLovVO.getDetailList().size() >0)
        {
          BeanUtils.copyProperties(oBaseLOVForm,oLovVO);
          oBaseLOVForm.setTxtHidTotRows(oLovVO.getDetailList().size());
          oBaseLOVForm.setTxtHidTotCols(oLovVO.getHeaderList().size());
        }
        else
        {
          oBaseLOVForm.setTxtHidTotRows(-1);  
          oBaseLOVForm.setTxtHidTotCols(-1);
        }
        oBaseLOVForm.setTxtHidSubmitFirst("false");
        oBaseLOVForm.setInsertFlag(oLOVInfo.getInsertFlag()); 
        
      }
       return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);        
  }
}

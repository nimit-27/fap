package FCIPAY.Payroll.common.webtier.action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import javax.ejb.EJBObject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import javax.ejb.RemoveException;
import FCIPAY.Payroll.common.utility.ParamUtil;
import java.util.Iterator;
import java.util.ArrayList;
import java.lang.reflect.*;
import FCIPAY.Payroll.common.vo.BaseDetailInfo;
import FCIPAY.Payroll.common.utility.DebugHelper;
import FCIPAY.Payroll.common.xml.vo.DetailScreen;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.bean.BaseHeaderBean;
import FCIPAY.Payroll.common.bean.BaseDetailBean;

public abstract class BaseAction extends Action 
{
  //ArrayList oFieldList = new ArrayList();
  
  /**
   * This is the main action called from the Struts framework.
   * @param mapping The ActionMapping used to select this instance.
   * @param form The optional ActionForm bean for this request.
   * @param request The HTTP Request we are processing.
   * @param response The HTTP Response we are processing.
   */
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    ActionErrors oErrorTable = null;
    BaseForm oBaseForm = (BaseForm)form;
    try
    {
      //The following functionality will be written in the login page
      // this is just to facilitate debugging
      FCIPAY.Payroll.common.utility.DebugHelper.createUserEjb(request.getSession());
      return executeImpl(mapping,form,request,response);
      //return mapping.findForward(EnrgiseConstants.SUCCESS);
    }
    catch(ClassNotFoundException oClassEx)
    {
      processSystemException(oClassEx,oErrorTable);
    }
    catch(InstantiationException oInSt)
    {
      processSystemException(oInSt,oErrorTable);
    }
    catch(InvocationTargetException oInvTar)
    {
      processSystemException(oInvTar,oErrorTable);
    }
    catch(IllegalAccessException oIlAcc)
    {
      processSystemException(oIlAcc,oErrorTable);
    }
    catch(EnrgiseSystemException oSys)
    {
      oSys.printStackTrace();
      if(oErrorTable == null)
      {
        oErrorTable = new ActionErrors();
      }
      String sKey = (null != oSys.getKey())?oSys.getKey():"wenrgise.common.system";
      ActionError oSysError = new ActionError(sKey);
      oErrorTable.add(ActionErrors.GLOBAL_ERROR,oSysError);
    }
    catch(EnrgiseApplicationException oApp)
    {
    
      if(oErrorTable == null)
      {
        oErrorTable = new ActionErrors();
      }
      // Process the exception
      processException(oErrorTable,oApp);
      
      // Check if the application contains more exception
      if(oApp.getList() != null)
      {
        Iterator oIt = oApp.getList().iterator();
        
        while(oIt.hasNext())
        {
          EnrgiseApplicationException oAppErr = (EnrgiseApplicationException)oIt.next();
          // Process the exception
          processException(oErrorTable,oAppErr);
        }
      }
    }
    finally    
    {
      if(oErrorTable != null)
      {
        //System.out.println("Save errors in BaseAction.java file");
        saveErrors(request,oErrorTable);      
        return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
      }
    }
    return null;
  }
  
  private void processSystemException(Exception oEc,ActionErrors oErrorTable)
  {
    if(oErrorTable == null)
    {
      oErrorTable = new ActionErrors();
    }
    EnrgiseSystemException oSys = new EnrgiseSystemException("wenrgise.common.system",oEc);
    ActionError oSysError = new ActionError(oSys.getKey());
    oErrorTable.add(ActionErrors.GLOBAL_ERROR,oSysError);
  }
  private void processException(ActionErrors oErrorTable,EnrgiseApplicationException oApp)
  {
    
      if(oErrorTable == null)
      {
        oErrorTable = new ActionErrors();
      }
      // Check if the exception has got any arguments
      if(oApp.getArguments() == null)
      { // The exception has not got any arguments

        //Check whether it is an error or a message and place it in proper place
        if(oApp.getErrorType().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR))
        { // Error
          oErrorTable.add(ActionErrors.GLOBAL_ERROR,new ActionError(oApp.getKey()));
        }
        else
        { // Message         
          oErrorTable.add(ActionErrors.GLOBAL_MESSAGE,new ActionError(oApp.getKey()));
        }
      } 
      else
      { //No Arguments
        // Check whether it is of type error
        if(oApp.getErrorType().equals(FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR))
        { // Error         
          oErrorTable.add(ActionErrors.GLOBAL_ERROR,new ActionError(oApp.getKey(),oApp.getArguments().toArray()));
        }
        else
        { //Message         
          oErrorTable.add(ActionErrors.GLOBAL_MESSAGE,new ActionError(oApp.getKey(),oApp.getArguments().toArray()));
        }
      }
  }
  
  BaseQueryVO getQueryVO(ActionForm form)throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName(); // Get the action
      String sQueryVO = FCIPAY.Payroll.common.utility.ParamUtil.getQueryVO(sFormName); // Get the fully qualified VO class name
      BaseQueryVO oBaseQueryVO = (BaseQueryVO)Class.forName(sQueryVO).newInstance(); //Create new query vo instance
      return oBaseQueryVO;      
  }
  BaseDetailBean getDetailBean(ActionForm form)throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName(); // Get the action
      String sDetailBean = FCIPAY.Payroll.common.utility.ParamUtil.getDetailBeanName(sFormName,sScreenName);
      BaseDetailBean oBaseDetailBean = (BaseDetailBean)Class.forName(sDetailBean).newInstance();
      return oBaseDetailBean;
  }
  BaseBD getHeaderBusinessDelegate(ActionForm form)throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName(); // Get the action
      String sBusinessDelegate  = FCIPAY.Payroll.common.utility.ParamUtil.getHeaderBD(sFormName); // Get the fully qualified Business Delegate class name
      BaseBD oBaseBD = (BaseBD)Class.forName(sBusinessDelegate).newInstance(); //Create new BD instance
      return oBaseBD;
  }
  protected BaseBD getDetailBusinessDelegate(ActionForm form)throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName(); // Get the screen name
      String sBusinessDelegate  = FCIPAY.Payroll.common.utility.ParamUtil.getDetailBD(sFormName,sScreenName); // Get the fully qualified Business Delegate class name
      BaseBD oBaseBD = (BaseBD)Class.forName(sBusinessDelegate).newInstance(); //Create new BD instance
      return oBaseBD;
  }

  protected BaseHeaderBean getBaseHeaderBean(String sFormName)throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
      String sBaseHeaderBean  = FCIPAY.Payroll.common.utility.ParamUtil.getHeaderBean(sFormName); // Get the fully qualified Business Delegate class name
      BaseHeaderBean oBaseHeaderBean = (BaseHeaderBean)Class.forName(sBaseHeaderBean).newInstance();      
      return oBaseHeaderBean;
  }
  
  protected BaseDetailInfo getBaseDetailInfo(ActionForm form) throws ClassNotFoundException, InstantiationException, IllegalAccessException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName(); // Get the screen name
      String sBaseDetailInfo  = FCIPAY.Payroll.common.utility.ParamUtil.getDetailBaseInfo(sFormName,sScreenName); // Get the fully qualified Business Delegate class name
      if(sBaseDetailInfo == null)
      {
        return null;
      }
      else
      {
        BaseDetailInfo oBaseDetailInfo = (BaseDetailInfo)Class.forName(sBaseDetailInfo).newInstance(); //Create new base detail info instance
        return oBaseDetailInfo;
      }
    
  }
  
  protected UserSession getUserSessionBean(HttpServletRequest request)
  {
    HttpSession session = request.getSession();
    return (UserSession)session.getAttribute(FCIPAY.Payroll.common.utility.ParamUtil.getSessionBeanName());
  }
  
  void clearDetailLists(BaseForm form,ArrayList oDetailList) throws InvocationTargetException, IllegalAccessException
  {
    Iterator oIt = oDetailList.iterator();
    while(oIt.hasNext())
    {
      DetailScreen oDetailScreen = (DetailScreen)oIt.next();
      BeanUtils.copyProperty(form,oDetailScreen.get_DetailArrayName(),new ArrayList());
    }
  }

//Changed it access specifier for OTA IT deductions. by Balpreet dt 16 June 2008.
 protected ArrayList getDetailArray(BaseForm oBaseForm) throws ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException
  {
      String sFormName = oBaseForm.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName(); // Get the action
      ArrayList oDetailArray = new ArrayList();
      String sDetailBean = FCIPAY.Payroll.common.utility.ParamUtil.getDetailBeanName(sFormName,sScreenName);
      BaseDetailBean oBaseDetailBean = (BaseDetailBean)Class.forName(sDetailBean).newInstance();
      ArrayList oFieldList = new ArrayList();
      oFieldList = getFieldList(oFieldList,oBaseDetailBean.getClass());
      System.out.println( "base form page detail " + oBaseForm.getThisPageDetailCount());
      for(int iRecord = 0; iRecord < oBaseForm.getThisPageDetailCount(); ++iRecord)
      {
        oBaseDetailBean = (BaseDetailBean)Class.forName(sDetailBean).newInstance();
        try
        {
          Iterator oIt = oFieldList.iterator();
          while(oIt.hasNext())
          {
            Field ob = (Field)oIt.next();
//            System.out.println("Record name " + iRecord);
            String sFieldName = ob.getName();
//            System.out.println("Field name " + sFieldName);
            //System.out.println(sFieldName + " " + ob.getType().getName());
            if(ob.getType().getName().equals("boolean") || ob.getType().getName().equals("IBA.Payroll.common.bean.CommonAttributes"))
            {
              continue;
            }
            String sValue = BeanUtils.getIndexedProperty(oBaseForm,sFieldName,iRecord);
            BeanUtils.setProperty(oBaseDetailBean,sFieldName,sValue);                      
          }
        }
        catch(NoSuchMethodException oMtEx)
        {
          throw new EnrgiseSystemException(oMtEx);
        }
        oDetailArray.add(oBaseDetailBean);
      }
      
      return oDetailArray;
  }
  
  private ArrayList getFieldList(ArrayList oFieldList, Class oClass)
  {
    if(oClass == null)
    {
      return oFieldList;
    }
    else
    {
      Field [] oFields = oClass.getDeclaredFields();
      FCIPAY.Payroll.common.utility.ArrayListUtil.addToList(oFieldList,(Object [])oFields);
      return getFieldList(oFieldList,oClass.getSuperclass());
    }
  }
  
  protected void changeMode(BaseForm oBaseForm,HttpServletRequest request) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      String sFormName = oBaseForm.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      BaseHeaderBean oBaseHeaderBean = getBaseHeaderBean(sFormName);
      BeanUtils.copyProperties(oBaseForm,oBaseHeaderBean);
      clearDetailLists(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailList(sFormName));
      UserSession oUser = getUserSessionBean(request);
      oUser.putBaseHeaderVO(sFormName,null);
      oUser.putBaseDetailVO(sFormName,sScreenName, null);
      oUser.putBaseQueryVO(sFormName,null);
      oBaseForm.setPageRequested(0);
      oBaseForm.setPositionRequested(0);
      oBaseForm.setTotalCount(0);
      oBaseForm.setTotalPageCount(0);
      oBaseForm.setTotalDetailRecord(0);    
  }
  
  protected void checkHeaderNavigation(BaseForm oBaseForm, BaseHeaderVO oBaseHeaderVO) throws EnrgiseApplicationException
  {
    long lPositionRequested = Long.parseLong(oBaseForm.getUserPositionRequested());
    if(null != oBaseHeaderVO)
    {
      if(lPositionRequested <= 0 || lPositionRequested > oBaseHeaderVO.getTotalCount())
      {
        throw new EnrgiseApplicationException("wenrgise.common.headerNavigation",FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR);        
      }
      else
      {
        oBaseForm.setPositionRequested(lPositionRequested);
      }
    }
    else
    {
        throw new EnrgiseApplicationException("wenrgise.common.headerNavigation",FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR);        
    }
  }

  protected void checkDetailNavigation(BaseForm oBaseForm, BaseDetailVO oBaseDetailVO) throws EnrgiseApplicationException
  {
    long lPageRequested = Long.parseLong(oBaseForm.getUserPageRequested());
    if(null != oBaseDetailVO)
    {
      if(lPageRequested <= 0 || oBaseDetailVO.getTotalDetailRecord() <= oBaseDetailVO.getRecordsPerPage() * (lPageRequested -1))
      {
        throw new EnrgiseApplicationException("wenrgise.common.detailNavigation",FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR);        
      }
      else
      {
        oBaseForm.setPageRequested(lPageRequested);
      }
    }
    else
    {
        throw new EnrgiseApplicationException("wenrgise.common.detailNavigation",FCIPAY.Payroll.common.utility.EnrgiseConstants.ERROR);        
    }
  }


  protected void controlHeaderNavigation(BaseForm oBaseForm)  throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList arylstFields=new ArrayList();
    long lTotalRecord=oBaseForm.getTotalCount();
    long lRecordNum=oBaseForm.getPositionRequested();
    //No or Single Header
    if(lTotalRecord == 0 ||  lTotalRecord == 1 )
    {
      arylstFields.add("butNextHeader");
      arylstFields.add("butPrevHeader");
      arylstFields.add("newPositionRequested");
      arylstFields.add("butJumpHeader");
    }
    else
    {
      //In Last Record
      if(lRecordNum == lTotalRecord )
      {
        arylstFields.add("butNextHeader");
      }
      //In First Record
      if(lRecordNum  == 1 )
      {
        arylstFields.add("butPrevHeader");
      }
    }
    //Invoke the disabling function  
//    enableDisable(oBaseForm,arylstFields,EnrgiseConstants.DISABLE); //Toolbar & Buttons
  }


  protected void controlDetailNavigation(BaseForm oBaseForm)  throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
    ArrayList oEnableList=new ArrayList();
    ArrayList oDisableList=new ArrayList();
     long lTotalRecord=oBaseForm.getTotalPageCount();
    long lRecordNum=oBaseForm.getPageRequested();
    //No Header / Single Header
    if(lTotalRecord == 0 ||  lTotalRecord == 1 )
    {
      oDisableList.add("butNextDetail");
      oDisableList.add("butPrevDetail");
      oDisableList.add("newPageRequested");
      oDisableList.add("butJumpDetail");
    }
    else
    {
      //In Last Record
      if(lRecordNum == lTotalRecord )
      {
      oEnableList.add("butPrevDetail");
      oEnableList.add("newPageRequested");
      oEnableList.add("butJumpDetail");
      oDisableList.add("butNextDetail");
      }
      //In First Record
      if(lRecordNum  == 1 )
      {
      oEnableList.add("newPageRequested");
      oEnableList.add("butJumpDetail");
      oEnableList.add("butNextDetail");
      oDisableList.add("butPrevDetail");
      }
    }
    //Invoke the disabling function  
//    enableDisable(oBaseForm,oEnableList,EnrgiseConstants.ENABLE); //Toolbar & Buttons
//    enableDisable(oBaseForm,oDisableList,EnrgiseConstants.DISABLE); //Toolbar & Buttons

  }  

  
/*
  private ActionForward cleanSession(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, EnrgiseSystemException, EnrgiseApplicationException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException
  {
    
      SysadminBaseForm oSysadminBaseForm = (SysadminBaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oSysadminBaseForm.getScreenName(); // Get the action
      
      HashMap oMap = (HashMap)session.getAttribute(ParamUtil.getSessionListName());
      if(oMap == null)
      {
        return null;
      }
      ArrayList oList = (ArrayList)oMap.get(sFormName);
      if (oList == null)
      {
        return null;
      }
      try
      {        
        Iterator oIt = oList.iterator();
        while(oIt.hasNext())
        {
          EJBObject oObject = (EJBObject)oIt.next();
          oObject.remove();
        }
        oList = null;
        oMap.remove(sFormName);
        //oMap = null;
        
        return null;
      }
      catch(RemoveException oRv)
      {
        log.severe(oRv.getMessage());
        throw new EnrgiseSystemException();
      }
    
  }
  */
  public abstract ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException;
}

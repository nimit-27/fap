package FCIPAY.Payroll.common.webtier.action;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.ServletException;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import FCIPAY.Payroll.common.vo.BaseHeaderVO;
import FCIPAY.Payroll.common.vo.BaseDetailVO;
import FCIPAY.Payroll.common.vo.BaseQueryVO;
import FCIPAY.Payroll.common.webtier.form.BaseForm;
import FCIPAY.Payroll.EJB.common.session.UserSession;
import FCIPAY.Payroll.common.utility.ParamUtil;
import java.util.ArrayList;
import FCIPAY.Payroll.common.utility.ArrayListUtil;
import FCIPAY.Payroll.common.businessdelegate.BaseBD;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.bean.BaseDetailBean;
import FCIPAY.Payroll.common.vo.DetailSizeValues;
import FCIPAY.Payroll.common.utility.EnrgiseConstants;
import FCIPAY.Payroll.WEBTIER.Form.MaintMiscellaneousParamForm;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlUpgradeBean;
//import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlNdutyBean;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlprojBean;
import FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlovrtimeBean;
import FCIPAY.Payroll.UTILITY.MaintElecMtrRdgBean;
import FCIPAY.Payroll.WEBTIER.Form.MaintPayScaleForm;
import FCIPAY.Payroll.UTILITY.MaintPayScaleDtlIDABean;
import FCIPAY.Payroll.common.webtier.action.BaseAction;



public class IncrDeleteRowAction extends BaseAction
{
  public IncrDeleteRowAction()
  {
  }
  public ActionForward executeImpl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, ClassNotFoundException, InstantiationException, InvocationTargetException, IllegalAccessException, EnrgiseSystemException, EnrgiseApplicationException
  {
      BaseForm oBaseForm = (BaseForm)form;
      String sFormName = form.getClass().getName(); //Get fully qualified form class
      String sScreenName = oBaseForm.getScreenName();
      String [] itemChecked = oBaseForm.getItemChecked();
      UserSession oUser = getUserSessionBean(request);
      BaseDetailVO oBaseDetailVO = oUser.getBaseDetailVO(sFormName,sScreenName);
      BaseDetailBean oBaseDetailBean = null;
//      ArrayList oDetailArray = oBaseDetailVO.getOThisPageData();
      ArrayList oDetailArray = getDetailArray(oBaseForm);
      for(int i=0; i < itemChecked.length; ++i)
      {
        if(itemChecked[i].equals("Y"))
        {
            ((BaseDetailBean)oDetailArray.get(i)).setStatus("D");
            ((BaseDetailBean)oDetailArray.get(i)).setItemChecked("N");
            oBaseDetailVO.setTotalDetailRecord(oBaseDetailVO.getTotalDetailRecord() - 1);
            oBaseDetailVO.setRowDeleted(oBaseDetailVO.getRowDeleted() + 1);


            if(sScreenName.equals("PayScaleIDA"))
            {
                  String temp = ((MaintPayScaleDtlIDABean)oDetailArray.get(i)).getStartField();
                  if(i < itemChecked.length - 1)
                  {
                    ((MaintPayScaleDtlIDABean)oDetailArray.get(i + 1)).setStartField(temp);
                    ((MaintPayScaleDtlIDABean)oDetailArray.get(i + 1)).setStatus("U");                    
                  }
            }

            if(sScreenName.equals("PayScaleCDA"))
            {
                  String temp = ((MaintPayScaleDtlIDABean)oDetailArray.get(i)).getStartField();
                  if(i < itemChecked.length - 1)
                  {
                    ((MaintPayScaleDtlIDABean)oDetailArray.get(i + 1)).setStartField(temp);
                    ((MaintPayScaleDtlIDABean)oDetailArray.get(i + 1)).setStatus("U");                                        
                  }
            }


/*
            if(sScreenName.equals("MiscUpgradeParamScreen"))
            {
                  String temp = ((MiscellaneousParamDtlUpgradeBean)oDetailArray.get(i)).getTxtAmtffm();
                  if(i < itemChecked.length - 1)
                  {
                    ((MiscellaneousParamDtlUpgradeBean)oDetailArray.get(i+1)).setTxtAmtffm(temp);
                  }
            }

            if(sScreenName.equals("MiscNdutyParamScreen"))
            {
                  String temp = ((MiscellaneousParamDtlNdutyBean)oDetailArray.get(i)).getTxtMinBasic();
                  if(i < itemChecked.length - 1)
                  {
                    ((MiscellaneousParamDtlNdutyBean)oDetailArray.get(i+1)).setTxtMinBasic(temp);
                  }
            }

            if(sScreenName.equals("MiscProjParamScreen"))
            {
                String temp = ((MiscellaneousParamDtlprojBean)oDetailArray.get(i)).getTxtAmtffm();
                if(i < itemChecked.length - 1)
                {
                    for(int j=i+1;j<itemChecked.length;j++)
                    {
                        String state = ((MiscellaneousParamDtlprojBean)oDetailArray.get(j)).getStatus();
                        if(!(state.equals("D")))
                        {
                            ((MiscellaneousParamDtlprojBean)oDetailArray.get(j)).setStatus("U");
                            ((MiscellaneousParamDtlprojBean)oDetailArray.get(j)).setTxtAmtffm(temp);
                            break;
                        }
                    }
                }
            }

            if(sScreenName.equals("MiscOTimeParamScreen"))
            {
                  String temp = ((MiscellaneousParamDtlovrtimeBean)oDetailArray.get(i)).getTxtAmtffm();
                  if(i < itemChecked.length - 1)
                  {
                    ((MiscellaneousParamDtlovrtimeBean)oDetailArray.get(i+1)).setTxtAmtffm(temp);
                  }
            }*/

            if(sScreenName.equals("MtrRdgScreen"))
            {
                String tempR = ((MaintElecMtrRdgBean)oDetailArray.get(i)).getTxtInitialReading();
                String tempY = ((MaintElecMtrRdgBean)oDetailArray.get(i)).getTxtInitialYearMonth();
                if(i < itemChecked.length - 1)
                {
                    for(int j=i+1;j<itemChecked.length;j++)
                    {
                        String state = ((MaintElecMtrRdgBean)oDetailArray.get(i + 1)).getStatus();
                        if(!(state.equals("D")))
                        {
                            ((MaintElecMtrRdgBean)oDetailArray.get(i + 1)).setTxtInitialReading(tempR);
                            ((MaintElecMtrRdgBean)oDetailArray.get(i + 1)).setTxtInitialYearMonth(tempY);
                            ((MaintElecMtrRdgBean)oDetailArray.get(i + 1)).setStatus("U");
                            break;
                        }
                    }
                }
            }

        }
      }
      BeanUtils.setProperty(oBaseForm,FCIPAY.Payroll.common.utility.ParamUtil.getDetailArrayName(sFormName,sScreenName),oDetailArray);
      
      //oBaseDetailVO.setOThisPageData(oDetailArray);
      //BeanUtils.setProperty(oBaseForm,ParamUtil.getDetailArrayName(sFormName,sScreenName),oBaseDetailVO.getOThisPageData());
      //oUser.putBaseDetailVO(sFormName,sScreenName,oBaseDetailVO);
      return mapping.findForward(FCIPAY.Payroll.common.utility.EnrgiseConstants.SUCCESS);
  }
  
}
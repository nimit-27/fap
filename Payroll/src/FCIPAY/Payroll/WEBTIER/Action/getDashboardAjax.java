package FCIPAY.Payroll.WEBTIER.Action;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.PrintWriter;
import FCIPAY.COMMON.UTILITY.UserInfoBean;
import FCIPAY.Payroll.common.utility.*;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;
import FCIPAY.Payroll.EJB.common.helper.QueryRow;
import FCIPAY.Payroll.EJB.common.helper.QueryValue;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import javax.servlet.http.HttpSession;
import FCIPAY.COMMON.WEBTIER.Form.*;
import FCIPAY.Payroll.common.webtier.form.BaseForm;

public class getDashboardAjax extends Action
{
  StringBuffer xml;
    long location_code;
    String empType;
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)  throws Exception
    {
        try
        {
         System.out.println("Start of action ajax");
     BaseForm oBaseForm = (BaseForm)form;
        
        HttpSession session = request.getSession(false);
        UserInfoBean obUserInfo;// = new UserInfoBean();                                                                                     
        if(session!=null) 
        {
            //session.setAttribute("USERINFO",obUserInfo);
            if(session.getAttribute("USERINFO") == null)
                return mapping.findForward("ErrorPage");
            else
                obUserInfo =(UserInfoBean)session.getAttribute("USERINFO");
        }
        else 
            return mapping.findForward("ErrorPage");
            
                   
                 empType=obUserInfo.getSEmpType();
                  System.out.println("emp type" + empType );
                  //empType=(String)session.getAttribute("hdnEmpLbrFlag");
                  
                    location_code=obUserInfo.getLLocationCode();
                   
                    
        
            xml=new StringBuffer();
            xml.setLength(0);
            xml.append("<Table>");
             xml.append("<status>");
              getData(request);
             xml.append("</status>");
           
            xml.append("</Table>");
            System.out.println(xml);
            response.setContentType("text/xml");
            PrintWriter wr=response.getWriter();
            wr.write(xml.toString());
            wr.close();
            wr.flush();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return mapping.findForward(null);                                
    }
    private void getData(HttpServletRequest req) throws EnrgiseSystemException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters    
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;    
        ArrayList oOutArray; 
         
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR,new String(empType))); 
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(location_code)));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"fci_payroll_sequential_pkg.proc_getDashboardStatus(?,?,?,?)");
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());
        int count = 0;
        QueryRow oRow = null;
        Iterator oIt = oList.iterator();
        while(oIt.hasNext())
        {
            oRow = (QueryRow)oIt.next();
            xml.append("<record>");
            xml.append("<locid>"+ oRow.get("req_id").getString() +"</locid>");
            xml.append("<locid>"+ oRow.get("module").getString() +"</locid>");
            xml.append("<locid>"+ oRow.get("phase_code").getString() +"</locid>");
            xml.append("<locid>"+ oRow.get("undo_flag").getString() +"</locid>");
            xml.append("<locid>"+ oRow.get("errmsg").getString() +"</locid>");
            xml.append("<locid>"+ oRow.get("requested_start_date").getString()+"</locid>");
            xml.append("<locid>"+ oRow.get("actual_start_date").getString()+"</locid>");
            xml.append("<locid>"+ oRow.get("actual_completion_date").getString()+"</locid>");
            xml.append("</record>");
        } 
       
    }

}
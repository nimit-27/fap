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

public class ValidateEmployee extends Action 
{
	StringBuffer xml;
    long emp_no,location_code;
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    throws Exception
    {
        try
        {
            String mode=(String)request.getParameter("mode");
            emp_no=Long.parseLong((String)request.getParameter("p_emp_num"));
            location_code=Long.parseLong((String)request.getParameter("p_site_id"));
            //System.out.println("mode="+mode+",user="+emp_no);
            xml=new StringBuffer();
            xml.setLength(0);
            xml.append("<Table>");
            if(mode.equals("1"))
            {
                xml.append("<status>");
                getData(request);
                xml.append("</status>");
            }
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
         
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.BIGINT,new Long(emp_no)));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.BIGINT,new Long(location_code)));
        oParameters.add(new DBObject(3,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(4,DBObject.OUT,ParameterTypes.INTEGER));
        oOutArray = oBean.callProc(oParameters,"pkg_Payroll_utility_FCI.proc_validate_employee(?,?,?,?)");
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        oList = (ArrayList)(oOutObject.getObject());
        int count = 0;
        QueryRow oRow = null;
        Iterator oIt = oList.iterator();
        while(oIt.hasNext())
        {
            oRow = (QueryRow)oIt.next();
            xml.append("<record>"+ oRow.get("status").getString() +"</record>");
        } 
        //System.out.println("Status is : "+ oRow.get("status"));
    }
}   
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

public class GenForm16ChkAction extends Action 
{
	  StringBuffer xml;
    long loc_code,fin_yymm,emp_num;
   
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) 
    throws Exception
    {
        try
        {;
         //   String mode=(String)request.getParameter("mode");
            emp_num=Long.parseLong((String)request.getParameter("P_EMP_NUM"));
            fin_yymm=Long.parseLong((String)request.getParameter("P_FIN_YR"));
            loc_code=Long.parseLong((String)request.getParameter("P_SITE_ID"));
        //    user_id=Long.parseLong((String)request.getParameter("P_SITE_ID"));
            xml=new StringBuffer();
            xml.setLength(0);
            xml.append("<Table>");
            getfinvalidation(request);
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
    private void getfinvalidation(HttpServletRequest req) throws EnrgiseSystemException
    {
        ArrayList oParameters = new ArrayList(); //Input Parameters    
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;    
        ArrayList oOutArray; 
        oParameters.add(new DBObject(1, DBObject.IN,ParameterTypes.VARCHAR,new Long(emp_num)));
        oParameters.add(new DBObject(2, DBObject.IN,ParameterTypes.BIGINT,new Long(fin_yymm)));
        oParameters.add(new DBObject(3, DBObject.IN,ParameterTypes.BIGINT,new Long(loc_code)));
      //  oParameters.add(new DBObject(4, DBObject.IN,ParameterTypes.VARCHAR,new Long(user_id)));
        oParameters.add(new DBObject(4, DBObject.OUT,ParameterTypes.VARCHAR));
         oParameters.add(new DBObject(5,DBObject.OUT,ParameterTypes.INTEGER));
        oParameters.add(new DBObject(6,DBObject.OUT,ParameterTypes.VARCHAR));
        oOutArray = oBean.callProc(oParameters,"pkg_compute_form16.form16_validation(?,?,?,?,?,?)",true,true);
        DBObject oOutObject = (DBObject)oOutArray.get(0);
        DBObject oOutObject1= (DBObject)oOutArray.get(1);
        String flag = (String)(oOutObject.getObject());
        Integer errcode= (Integer)(oOutObject1.getObject());
        xml.append("<record>"+ flag +"</record>");
        xml.append("<record>"+ errcode +"</record>"); 
          
            
        //System.out.println("Status is : "+ oRow.get("status"));
    }
}   
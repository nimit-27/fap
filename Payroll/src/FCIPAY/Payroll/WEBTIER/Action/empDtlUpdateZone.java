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

public class empDtlUpdateZone extends Action {
    StringBuffer xml;
    String txtEmpNo = null, screenName = null, processName = null, primaryKey = null, possession_date = null;

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        try {
            String mode = (String) request.getParameter("mode");
            txtEmpNo = (String) request.getParameter("txtEmpNo");
            screenName = (String) request.getParameter("screenName");
            processName = (String) request.getParameter("processName");
            primaryKey = (String) request.getParameter("primaryKey");
            possession_date = (String) request.getParameter("possession_date");
            xml = new StringBuffer();
            xml.setLength(0);
            xml.append("<Table>");
            xml.append("<status>");
            if (mode.equals("1")) {
                getData(request);
            } else {
                proceedFurther(request);
            }
            xml.append("</status>");
            xml.append("</Table>");
            System.out.println(xml);
            response.setContentType("text/xml");
            PrintWriter wr = response.getWriter();
            wr.write(xml.toString());
            wr.close();
            wr.flush();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return mapping.findForward(null);
    }

    private void proceedFurther(HttpServletRequest req) throws EnrgiseSystemException {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        ArrayList oOutArray;
        if (screenName.equals("CPFPartFinalPayScreen") && processName.equals("UpdatePossessionDate")) {
            oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, primaryKey));
            oParameters.add(new DBObject(2, DBObject.IN, ParameterTypes.VARCHAR, txtEmpNo));
            oParameters.add(new DBObject(3, DBObject.IN, ParameterTypes.TIMESTAMP,
                                         FCIPAY.Payroll
                                                                                         .common
                                                                                         .utility
                                                                                         .EnrgiseUtil
                                                                                         .convertToSqlDate(possession_date)));
            oParameters.add(new DBObject(4, DBObject.OUT, ParameterTypes.CURSOR));
            oParameters.add(new DBObject(5, DBObject.OUT, ParameterTypes.INTEGER));

            oOutArray = oBean.callProc(oParameters, "pkg_update_misc_data.proc_update_possession_date_cpf(?,?,?,?,?)");
            DBObject oOutObject = (DBObject) oOutArray.get(0);
            oList = (ArrayList) (oOutObject.getObject());
            int count = 0;
            QueryRow oRow = null;
            Iterator oIt = oList.iterator();
            while (oIt.hasNext()) {
                oRow = (QueryRow) oIt.next();
                xml.append("<record>" + oRow.get("err_msg").getString() + "</record>");
            }
        }

    }

    private void getData(HttpServletRequest req) throws EnrgiseSystemException {
        ArrayList oParameters = new ArrayList(); //Input Parameters
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oList;
        ArrayList oOutArray;

        if (screenName.equals("CPFFinalPaymentScreen")) {
            oParameters.add(new DBObject(1, DBObject.IN, ParameterTypes.VARCHAR, txtEmpNo));
            oParameters.add(new DBObject(2, DBObject.OUT, ParameterTypes.CURSOR));
            oParameters.add(new DBObject(3, DBObject.OUT, ParameterTypes.INTEGER));

            oOutArray = oBean.callProc(oParameters, "fcipayroll.PKG_CPF_MISC.getbackdateseparation(?,?,?)");
            DBObject oOutObject = (DBObject) oOutArray.get(0);
            oList = (ArrayList) (oOutObject.getObject());
            int count = 0;
            QueryRow oRow = null;
            Iterator oIt = oList.iterator();
            while (oIt.hasNext()) {
                oRow = (QueryRow) oIt.next();
                xml.append("<record>" + oRow.get("err_msg").getString() + "</record>");
            }

        }
    }
}


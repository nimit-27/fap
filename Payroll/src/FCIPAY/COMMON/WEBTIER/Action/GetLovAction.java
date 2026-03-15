/*
 * Program Name : GetLovAction.java.java
 * Author       : Swapnendu Kumar Bastia
 * Date Written : 13/05/2013
 * Description  : This is the Action Class Get LOV. 
 *
*/
package FCIPAY.COMMON.WEBTIER.Action;
import FCIPAY.Payroll.common.vo.LovQueryVO;
import FCIPAY.Payroll.common.vo.LovVO;
import java.util.ArrayList;
import org.apache.commons.beanutils.BeanUtils;
import FCIPAY.Payroll.common.exception.EnrgiseSystemException;
import FCIPAY.Payroll.common.exception.EnrgiseApplicationException;
import FCIPAY.Payroll.EJB.common.utility.DBUtilitiesBean;
import FCIPAY.Payroll.EJB.common.helper.DBObject;
import FCIPAY.Payroll.EJB.common.helper.ParameterTypes;

public class GetLovAction
{
    public ArrayList GetLov(LovQueryVO oLovQueryVO, String superUserFlg) throws  EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, (oLovQueryVO.getProperty("screenName").toUpperCase())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("screenMode")));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
        System.out.println("oLovQueryVO.getProperty(\"hdnEmpLbrFlag\")"+oLovQueryVO.getProperty("hdnEmpLbrFlag"));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, superUserFlg));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
        oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
        ArrayList oOutArray = oBean.callProc(oParameters,"pkg_Payroll_utility_FCI.GET_LOV(?,?,?,?,?,?,?,?,?,?)");
        return oOutArray;
    }
    
    public ArrayList GetLovInst(LovQueryVO oLovQueryVO, String superUserFlg) throws  EnrgiseSystemException, EnrgiseApplicationException
    {
        DBUtilitiesBean oBean = new DBUtilitiesBean();
        ArrayList oParameters = new ArrayList();
        oParameters.add(new DBObject(1,DBObject.IN,ParameterTypes.VARCHAR, (oLovQueryVO.getProperty("screenName").toUpperCase())));
        oParameters.add(new DBObject(2,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("txtSiteID")));
        oParameters.add(new DBObject(3,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("screenMode")));
        oParameters.add(new DBObject(4,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getProperty("hdnEmpLbrFlag")));
        oParameters.add(new DBObject(5,DBObject.IN,ParameterTypes.VARCHAR, superUserFlg));
        oParameters.add(new DBObject(6,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField1()));
        oParameters.add(new DBObject(7,DBObject.IN,ParameterTypes.VARCHAR, oLovQueryVO.getSearchField2()));
        oParameters.add(new DBObject(8,DBObject.OUT,ParameterTypes.CURSOR));
        oParameters.add(new DBObject(9,DBObject.OUT,ParameterTypes.VARCHAR));
        oParameters.add(new DBObject(10,DBObject.OUT,ParameterTypes.INTEGER));
        ArrayList oOutArray = oBean.callProc(oParameters,"pkg_Payroll_utility_FCI.get_lov_inst(?,?,?,?,?,?,?,?,?,?)");
        return oOutArray;
    }
}
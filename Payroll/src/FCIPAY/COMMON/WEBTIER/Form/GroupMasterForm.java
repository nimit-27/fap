/*
 * Program Name : GroupMasterForm.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is Action Form of Group Master jsp page which has
 *                  all the page values
*/

package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

import FCIPAY.COMMON.DATAACCESSTIER.VO.GroupMasterVO;

public class GroupMasterForm extends ActionForm  
{
    private ArrayList grpList=new ArrayList();
    private ArrayList moduleList=new ArrayList();
    private String hdnAction="";
    private int hdnGrpCnt=0;
    private String txtGrpSDesc="";
    private String txtDesc="";
    private String lstStatus="";
    private String radSelect="";
    private GroupMasterVO oGrpVo=null;
    private String lstModule;

    public ArrayList getGrpList() {
        return grpList;
    }

    public void setGrpList(ArrayList newGrpList) {
        grpList = newGrpList;
    }

    public String getHdnAction() {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction) {
        hdnAction = newHdnAction;
    }

    public int getHdnGrpCnt() {
        return hdnGrpCnt;
    }

    public void setHdnGrpCnt(int newHdnGrpCnt) {
        hdnGrpCnt = newHdnGrpCnt;
    }

    public String getTxtGrpSDesc() {
        return txtGrpSDesc;
    }

    public void setTxtGrpSDesc(String newTxtGrpSDesc) {
        txtGrpSDesc = newTxtGrpSDesc;
    }

    public String getTxtDesc() {
        return txtDesc;
    }

    public void setTxtDesc(String newTxtDesc) {
        txtDesc = newTxtDesc;
    }

    public String getLstStatus() {
        return lstStatus;
    }

    public void setLstStatus(String newLstStatus) {
        lstStatus = newLstStatus;
    }

    public String getRadSelect() {
        return radSelect;
    }

    public void setRadSelect(String newRadSelect) {
        radSelect = newRadSelect;
    }

    public GroupMasterVO createVO() 
    {
        oGrpVo=new GroupMasterVO();
        oGrpVo.setLstStatus(this.lstStatus);
        oGrpVo.setTxtDesc(this.txtDesc);
        oGrpVo.setTxtGrpSDesc(this.txtGrpSDesc);
        oGrpVo.setLstModule(this.lstModule);
        return oGrpVo;
    }

    public ArrayList getModuleList()
    {
        return moduleList;
    }

    public void setModuleList(ArrayList newModuleList)
    {
        moduleList = newModuleList;
    }

    public String getLstModule()
    {
        return lstModule;
    }

    public void setLstModule(String newLstModule)
    {
        lstModule = newLstModule;
    }
}
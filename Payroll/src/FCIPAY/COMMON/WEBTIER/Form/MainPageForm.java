/*
 * Program Name : MainPageForm.java
 * Author       : Jegan.V
 * Date Written : 01/03/2004
 * Description  : This is the Action Form class for the mainpage
 *
*/

package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;

public class MainPageForm extends ActionForm  
{
    private String hdnAction="";
    private ArrayList moduleList=new ArrayList();
    private ArrayList menuList=new ArrayList();

    
    public String getHdnAction() 
    {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction) 
    {
        hdnAction = newHdnAction;
    }

    public ArrayList getModuleList() 
    {
        return moduleList;
    }

    public void setModuleList(ArrayList newModuleList) 
    {
        moduleList = newModuleList;
    }

    public ArrayList getMenuList() {
        return menuList;
    }

    public void setMenuList(ArrayList newMenuList) {
        menuList = newMenuList;
    }
}
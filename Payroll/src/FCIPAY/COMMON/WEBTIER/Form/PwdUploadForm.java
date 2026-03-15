    /*
     * Module       :   UploadForm.java
     * Author       :   V.Jegan
     * Date Written :   4th October 2004
     * Description  :   The Action Form which has all the get and
     *                  set methods of the PasswordUpload.jsp page.
     * Revision Log :   (mm/dd/yy initials description)
     * -----------------------------------------------------------------
     * mm/dd/yy     xxxx    <comments on changes>
    */


package FCIPAY.COMMON.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;

public class PwdUploadForm extends ActionForm 
{
    private String file="";
    private String uploadAction="";
    private long errLineNo=0;
    
    /**
     * Reset all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     */
    public void reset(ActionMapping mapping, HttpServletRequest request)
    {
        super.reset(mapping, request);
    }

    /**
     * Validate all properties to their default values.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return ActionErrors A list of all errors found.
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
    {
        return super.validate(mapping, request);
    }

    public long getErrLineNo()
    {
        return errLineNo;
    }

    public void setErrLineNo(long newErrLineNo)
    {
        errLineNo = newErrLineNo;
    }

    public String getFile()
    {
        return file;
    }

    public void setFile(String newFile)
    {
        file = newFile;
    }

    public String getUploadAction()
    {
        return uploadAction;
    }

    public void setUploadAction(String newUploadAction)
    {
        uploadAction = newUploadAction;
    }
}
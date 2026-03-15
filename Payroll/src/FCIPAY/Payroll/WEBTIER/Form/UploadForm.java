    /*
     * Module       :   UploadForm.java
     * Author       :   V.Jegan
     * Date Written :   30th Sept 2003
     * Description  :   The Action Form which has all the get and
     *                  set methods of the upload.jsp page.
     * Revision Log :   (mm/dd/yy initials description)
     * -----------------------------------------------------------------
     * mm/dd/yy     xxxx    <comments on changes>
    */
    

package FCIPAY.Payroll.WEBTIER.Form;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import org.apache.struts.upload.*;
import FCIPAY.Payroll.DATAACCESSTIER.VO.UploadVO;
import org.apache.struts.upload.FormFile;

public class UploadForm extends ActionForm 
{
  
    private long lstAccCode;
    private ArrayList listAccCode=new ArrayList();
//    private int lstLocCode=0;
//    private ArrayList listLocCode=null;
    private String file="";
    private String uploadAction="";
    private UploadVO oUploadVO=null;
    private long errLineNo;
   private FormFile theFile;
  private String optReportType;
  private String txtEmpField;
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


    public void setListAccCode(ArrayList newListAccCode)
    {
        listAccCode = newListAccCode;
    }

    
    public void setLstAccCode(long newLstAccCode)
    {
        lstAccCode = newLstAccCode;
    }

    public long getLstAccCode()
    {
        return lstAccCode;
    }

    public ArrayList getListAccCode()
    {
        return listAccCode;
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

    public long getErrLineNo() {
        return errLineNo;
    }

    public void setErrLineNo(long newErrLineNo) {
        errLineNo = newErrLineNo;
    }

  public FormFile getTheFile()
  {
    return theFile;
  }

  public void setTheFile(FormFile newTheFile)
  {
    theFile = newTheFile;
  }

  public String getOptReportType()
  {
    return optReportType;
  }

  public void setOptReportType(String newOptReportType)
  {
    optReportType = newOptReportType;
  }

  public String getTxtEmpField()
  {
    return txtEmpField;
  }

  public void setTxtEmpField(String newTxtEmpField)
  {
    txtEmpField = newTxtEmpField;
  }
}
    /*
     * Module       :   UploadVO.java
     * Author       :   V.Jegan
     * Date Written :   30th Sept 2003
     * Description  :   The Values Object class for the form.It has
     *                  all the get and set methods of the elements that 
     *                  has to be carried out the upper layers
     * Revision Log :   (mm/dd/yy initials description)
     * -----------------------------------------------------------------
     * mm/dd/yy     xxxx    <comments on changes>
    */


package FCIPAY.Payroll.DATAACCESSTIER.VO;
import java.util.ArrayList;

public class UploadVO 
{
    private long lstAccCode;
//    private int lstLocCode=0;
    private String file="";
    private long userLocId;
    private long userEmpNo;
    private ArrayList listAccCode=null;
    private transient long errLineNo;
  private String optReportType;
  private String txtEmpField;
    
    public UploadVO()
    {
    }

    public String getFile()
    {
        return file;
    }

    public void setFile(String newFile)
    {
        file = newFile;
    }

    public long getLstAccCode()
    {
        return lstAccCode;
    }

    public void setLstAccCode(long newLstAccCode)
    {
        lstAccCode = newLstAccCode;
    }

    public long getUserLocId() {
        return userLocId;
    }

    public void setUserLocId(long newUserLocId) {
        userLocId = newUserLocId;
    }

    public long getUserEmpNo() {
        return userEmpNo;
    }

    public void setUserEmpNo(long newUserEmpNo) {
        userEmpNo = newUserEmpNo;
    }

    public ArrayList getListAccCode() {
        return listAccCode;
    }

    public void setListAccCode(ArrayList newListAccCode) {
        listAccCode = newListAccCode;
    }

    public long getErrLineNo() {
        return errLineNo;
    }

    public void setErrLineNo(long newErrLineNo) {
        errLineNo = newErrLineNo;
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
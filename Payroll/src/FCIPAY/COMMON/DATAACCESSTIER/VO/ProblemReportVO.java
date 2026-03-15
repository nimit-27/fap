
/*
 * Program Name : ProblemReportVO.java
 * Author       : Jegan.V
 * Date Written : 24/05/2004
 * Description  : This is the Value Object which has the values going to the DAO.
 *
*/

package FCIPAY.COMMON.DATAACCESSTIER.VO;

public class ProblemReportVO 
{
    private String hdnAction="";
    private String txtScreenName="";
    private String txtArProblemDesc="";
    private String txtArCause="";
    private long userLoc=0;
    private long userEmpNo=0;

    public String getHdnAction()
    {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction)
    {
        hdnAction = newHdnAction;
    }

    public String getTxtScreenName()
    {
        return txtScreenName;
    }

    public void setTxtScreenName(String newTxtScreenName)
    {
        txtScreenName = newTxtScreenName;
    }

    public String getTxtArProblemDesc()
    {
        return txtArProblemDesc;
    }

    public void setTxtArProblemDesc(String newTxtArProblemDesc)
    {
        txtArProblemDesc = newTxtArProblemDesc;
    }

    public String getTxtArCause()
    {
        return txtArCause;
    }

    public void setTxtArCause(String newTxtArCause)
    {
        txtArCause = newTxtArCause;
    }

    public long getUserLoc()
    {
        return userLoc;
    }

    public void setUserLoc(long newUserLoc)
    {
        userLoc = newUserLoc;
    }

    public long getUserEmpNo()
    {
        return userEmpNo;
    }

    public void setUserEmpNo(long newUserEmpNo)
    {
        userEmpNo = newUserEmpNo;
    }
}
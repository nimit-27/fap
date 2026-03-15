/*
 * Program Name : ResetPwdVO.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Value Object Class for transfering the values from
 *                  the Action Class to the DAO and back to Action Class.
 *
*/


package FCIPAY.COMMON.DATAACCESSTIER.VO;

public class ResetPwdVO  
{
    private long txtEmpNo=0;
    private String hdnAction="";
    private int hdnEmpDtls=0;
    private String hdnEmpDesig="";
    private String hdnEmpName="";
    private String hdnEmpDept="";
    private long userEmpNo=0;
    private long userLocId=0;

    public long getTxtEmpNo() {
        return txtEmpNo;
    }

    public void setTxtEmpNo(long newTxtEmpNo) {
        txtEmpNo = newTxtEmpNo;
    }

    public String getHdnAction() {
        return hdnAction;
    }

    public void setHdnAction(String newHdnAction) {
        hdnAction = newHdnAction;
    }

    public int getHdnEmpDtls() {
        return hdnEmpDtls;
    }

    public void setHdnEmpDtls(int newHdnEmpDtls) {
        hdnEmpDtls = newHdnEmpDtls;
    }

    public String getHdnEmpDesig() {
        return hdnEmpDesig;
    }

    public void setHdnEmpDesig(String newHdnEmpDesig) {
        hdnEmpDesig = newHdnEmpDesig;
    }

    public String getHdnEmpName() {
        return hdnEmpName;
    }

    public void setHdnEmpName(String newHdnEmpName) {
        hdnEmpName = newHdnEmpName;
    }

    public String getHdnEmpDept() {
        return hdnEmpDept;
    }

    public void setHdnEmpDept(String newHdnEmpDept) {
        hdnEmpDept = newHdnEmpDept;
    }

    public long getUserEmpNo()
    {
        return userEmpNo;
    }

    public void setUserEmpNo(long newUserEmpNo)
    {
        userEmpNo = newUserEmpNo;
    }

    public long getUserLocId()
    {
        return userLocId;
    }

    public void setUserLocId(long newUserLocId)
    {
        userLocId = newUserLocId;
    }

}
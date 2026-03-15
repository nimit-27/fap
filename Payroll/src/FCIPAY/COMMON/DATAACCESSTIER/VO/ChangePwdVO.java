/*
 * Program Name : ChangePwdVO.java
 * Author       : Jegan.V
 * Date Written : 24/02/2004
 * Description  : This is the Value Object Class for transfering the values from
 *                  the Action Class to the DAO and back to Action Class.
 *
*/


package FCIPAY.COMMON.DATAACCESSTIER.VO;

public class ChangePwdVO  
{
    private String txtConfirmPwd="";
    private String txtNewPwd="";
    private String txtOldPwd="";
    private long userSiteId=0;
    private long userEmpNo=0;
    private String encryptPwd="";

    public ChangePwdVO() 
    {

    }

    public String getTxtConfirmPwd() {
        return txtConfirmPwd;
    }

    public void setTxtConfirmPwd(String newTxtConfirmPwd) {
        txtConfirmPwd = newTxtConfirmPwd;
    }

    public String getTxtNewPwd() {
        return txtNewPwd;
    }

    public void setTxtNewPwd(String newTxtNewPwd) {
        txtNewPwd = newTxtNewPwd;
    }

    public String getTxtOldPwd() {
        return txtOldPwd;
    }

    public void setTxtOldPwd(String newTxtOldPwd) {
        txtOldPwd = newTxtOldPwd;
    }

    public long getUserSiteId() {
        return userSiteId;
    }

    public void setUserSiteId(long newUserSiteId) {
        userSiteId = newUserSiteId;
    }

    public long getUserEmpNo() {
        return userEmpNo;
    }

    public void setUserEmpNo(long newUserEmpNo) {
        userEmpNo = newUserEmpNo;
    }

    public String getEncryptPwd() {
        return encryptPwd;
    }

    public void setEncryptPwd(String newEncryptPwd) {
        encryptPwd = newEncryptPwd;
    }
}
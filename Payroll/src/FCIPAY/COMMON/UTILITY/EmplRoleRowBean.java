package FCIPAY.COMMON.UTILITY;

public class EmplRoleRowBean  {
    private String txtEmpRoleId         ="";
    private String txtScreenSdesc       ="";
    private String txtScreenDesc        ="";
    private String txtRoleId            ="";
    public EmplRoleRowBean(String txtEmpRoleId,String txtScreenSdesc,String txtRoleId,String txtScreenDesc) {
        this.txtEmpRoleId=txtEmpRoleId;
        this.txtScreenSdesc=txtScreenSdesc;
        this.txtScreenDesc=txtScreenDesc;
        this.txtRoleId=txtRoleId;
    }

    public String getTxtEmpRoleId() {
        return txtEmpRoleId;
    }


    public String getTxtRoleId() {
        return txtRoleId;
    }

    public String getTxtScreenDesc() {
        return txtScreenDesc;
    }

    public String getTxtScreenSdesc() {
        return txtScreenSdesc;
    }

    public String toString() {
        StringBuffer strBuff=new StringBuffer("");
        strBuff.append(this.txtEmpRoleId);
        strBuff.append("-");
        strBuff.append(this.txtScreenSdesc);
        strBuff.append("-");
        strBuff.append(this.txtRoleId);
        strBuff.append("-");
        strBuff.append(this.txtScreenDesc);
        return strBuff.toString();
    }


}
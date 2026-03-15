/*
 * Program Name : DynamicMenuBean.java
 * Author       : Jegan.V
 * Date Written : 02/03/2004
 * Description  : This is the bean used for getting the Dynamic Menu and the Screen Names
 *
 * Date Modified: 09/21/2004
 * Modified by: Karthik Murthy
 * Modifications: Added an extra constructor and extra variables - secondDesc,listValue and codeValue
*/


package FCIPAY.COMMON.UTILITY;

public class DynamicMenuBean 
{
    String Header="";
    String level1="";
    String level2="";
    String level3="";
    String formbean="";
    String action="";
    String dynamicMenu="";
    long hdnScreenId=0;
    String hdnCheck="";
    String reprotURL="";
    private String grpSDesc="";
    private String desc="";
    private String grpStatus="";
    private String modName="";
    private String modId="";
    private String listValue = "";
    private String codeValue = "";
    private String secondDesc = "";
    private long rev_no;
    private long secondRev_no;
    private String hdnEmpLbrFlag;
    private long hdnAudScreenId=0;  //added by swapnendu Dt 12/12/2012

    public DynamicMenuBean(long newRev_no, String newCodeValue, String newDesc, String newSecondDesc)
    {
        this.secondDesc = newSecondDesc;
        this.desc = newDesc;
        this.rev_no = newRev_no;
        this.codeValue = newCodeValue;
    }

    public DynamicMenuBean(long newRev_no, long newSecondRev_no, String newCodeValue, String newDesc, String newSecondDesc)
    {
        this.secondDesc = newSecondDesc;
        this.desc = newDesc;
        this.rev_no = newRev_no;
        this.codeValue = newCodeValue;
        this.secondRev_no = newSecondRev_no;
    }
    
    public DynamicMenuBean(long newHdnScreenId, String newCodeValue, String newDesc, String pgrpStatus, String newSecondDesc)
    {
        this.secondDesc = newSecondDesc;
        this.desc = newDesc;
        this.grpStatus = pgrpStatus;
        this.hdnScreenId = newHdnScreenId;
        this.codeValue = newCodeValue;
    }

    public DynamicMenuBean(String pgrpSDesc,String pdesc,String pgrpStatus,String pmodId,String pmodName) 
    {
        this.grpSDesc=pgrpSDesc;
        this.desc=pdesc;
        this.grpStatus=pgrpStatus;
        this.modName=pmodName;
        this.modId=pmodId;
    }

    public DynamicMenuBean(String pHeader,String plevel1,String plevel2,String plevel3,String pformbean,String paction,String preportURL,String pEmpLbrFlag) 
    {
        this.Header=pHeader;
        this.level1=plevel1;
        this.level2=plevel2;
        this.level3=plevel3;
        this.formbean=pformbean;
        this.action=paction;
        this.reprotURL=preportURL;
        this.hdnEmpLbrFlag=pEmpLbrFlag;
    }

    public DynamicMenuBean(String plevel1,String plevel2,String plevel3,long pScreenId,String pCheck) 
    {
        this.level1=plevel1;
        this.level2=plevel2;
        this.level3=plevel3;
        this.hdnScreenId=pScreenId;
        this.hdnCheck=pCheck;
    }

    public DynamicMenuBean(String plevel1,String plevel2,String plevel3,long pScreenId,long pAuditScreenId,String pCheck) 
    {
        this.level1=plevel1;
        this.level2=plevel2;
        this.level3=plevel3;
        this.hdnScreenId=pScreenId;
        this.hdnCheck=pCheck;
        this.hdnAudScreenId=pAuditScreenId;
    }

    public DynamicMenuBean(String pDynamicMenu) 
    {
        this.dynamicMenu=pDynamicMenu;    
    }

    public String getHeader() 
    {
        return Header;
    }

    public void setHeader(String newHeader) 
    {
        Header = newHeader;
    }

    public String getAction() 
    {
        return action;
    }

    public void setAction(String newAction) 
    {
        action = newAction;
    }

    public String getFormbean() 
    {
        return formbean;
    }

    public void setFormbean(String newFormbean) 
    {
        formbean = newFormbean;
    }

    public String getlevel2() 
    {
        return level2;
    }

    public void setlevel2(String newlevel2) 
    {
        level2 = newlevel2;
    }

    public String getlevel1() 
    {
        return level1;
    }

    public void setlevel1(String newlevel1) 
    {
        level1 = newlevel1;
    }

    public String getlevel3() 
    {
        return level3;
    }

    public void setlevel3(String newlevel3) 
    {
        level3 = newlevel3;
    }

    public String toString() 
    {
        StringBuffer sb=new StringBuffer("");
        sb.append(this.Header);
        sb.append("-");
        sb.append(this.level1);
        sb.append("-");
        sb.append(this.level2);
        sb.append("-");
        sb.append(this.level3);
        sb.append("-");
        sb.append(this.formbean);
        sb.append("-");
        sb.append(this.action);
        return sb.toString();
    }

    public String getDynamicMenu() {
        return dynamicMenu;
    }

    public void setDynamicMenu(String newDynamicMenu) {
        dynamicMenu = newDynamicMenu;
    }

    public long getHdnScreenId() {
        return hdnScreenId;
    }

    public void setHdnScreenId(long newHdnScreenId) {
        hdnScreenId = newHdnScreenId;
    }

    public String getHdnCheck() {
        return hdnCheck;
    }

    public void setHdnCheck(String newHdnCheck) {
        hdnCheck = newHdnCheck;
    }

    public String getReprotURL() {
        return reprotURL;
    }

    public void setReprotURL(String newReprotURL) {
        reprotURL = newReprotURL;
    }

    public String getGrpSDesc() {
        return grpSDesc;
    }

    public void setGrpSDesc(String newGrpSDesc) {
        grpSDesc = newGrpSDesc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String newDesc) {
        desc = newDesc;
    }

    public String getGrpStatus() {
        return grpStatus;
    }

    public void setGrpStatus(String newGrpStatus) {
        grpStatus = newGrpStatus;
    }

    public String getModName()
    {
        return modName;
    }

    public void setModName(String newModName)
    {
        modName = newModName;
    }

    public String getModId()
    {
        return modId;
    }

    public void setModId(String newModId)
    {
        modId = newModId;
    }

    public String getListValue()
    {
        return listValue;
    }

    public void setListValue(String newListValue)
    {
        listValue = newListValue;
    }

    public String getCodeValue()
    {
        return codeValue;
    }

    public void setCodeValue(String newCodeValue)
    {
        codeValue = newCodeValue;
    }

    public String getSecondDesc()
    {
        return secondDesc;
    }

    public void setSecondDesc(String newSecondDesc)
    {
        secondDesc = newSecondDesc;
    }

    public long getRev_no()
    {
        return rev_no;
    }

    public void setRev_no(long newRev_no)
    {
        rev_no = newRev_no;
    }

    public long getSecondRev_no()
    {
        return secondRev_no;
    }

    public void setSecondRev_no(long newSecondRev_no)
    {
        secondRev_no = newSecondRev_no;
    }
    
    public String getHdnEmpLbrFlag()
    {
        return hdnEmpLbrFlag;
    }

    public void setHdnEmpLbrFlag(String newHdnEmpLbrFlag)
    {
        hdnEmpLbrFlag = newHdnEmpLbrFlag;
    }
    
    public long getHdnAudScreenId() {
        return hdnAudScreenId;
    }

    public void setHdnAudScreenId(long newHdnAudScreenId) {
        hdnAudScreenId = newHdnAudScreenId;
    }

}
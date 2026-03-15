<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html locale="true"><html:base />
    <head>
        <title>Reset Password</title>
        <link rel="STYLESHEET" type="text/css" href="<html:rewrite page="/COMMON/CSS/Menucss.css" />">
        <link rel="stylesheet" type="text/css" href="<html:rewrite page="/COMMON/CSS/IBA.css" />"> 
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />"></script>
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />"></script>
        <script type="text/javascript" language="javascript" src="<html:rewrite page="/COMMON/JavaScript/validate.js" />"></script>
    </head>
    <body onload="lfnLoad();history.forward(1);" scroll="no" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
        <html:form name="frmResetPwd" method="post" action="/ResetPwd" type="FCIPAY.COMMON.WEBTIER.Form.ResetPwdForm">

            <html:hidden property="hdnAction" />
            <html:hidden property="hdnEmpDtls" />

            <html:hidden property="hdnEmpName" />
            <html:hidden property="hdnEmpDept" />
            <html:hidden property="hdnEmpDesig" />
            
            <br><br>
            <table width="50%" border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><b class="MainHeader">Reset Password</b></td>
                </tr>
                <tr>
                    <td align="left"><i><font color="red">*</font>Mandatory Fields</i></td>
                </tr>
            </table>
      
            <html:errors />

            <br>
            <table border="1" width="50%" align="center">
                <tr>
                    <td>
                        <table border="1" cols="2" cellspacing="0" cellpadding="0" width="100%" class="bgndTable" bordercolor="white">
                            <tr>
                                <td width="35%" >Employee No : <font color="red">*</font></td>
                                <td width="65%" ><html:text property="txtEmpNo" size="20" maxlength="10" styleClass="required" onblur="if(num_Check(this.value,2)){lfnChkEmployee(this.value);}" /></td>
                            </tr>

                            <logic:equal name="frmResetPwd" property="hdnEmpDtls" value="1">
                                <tr>
                                    <td width="35%" >Employee Name :</td>
                                    <td width="65%" ><bean:write name="frmResetPwd" property="hdnEmpName" /></td>
                                </tr>

                                <tr>
                                    <td width="35%" >Designation :</td>
                                    <td width="65%" ><bean:write name="frmResetPwd" property="hdnEmpDesig" /></td>
                                </tr>

                                <tr>
                                    <td width="35%" >Place of Posting :</td>
                                    <td width="65%" ><bean:write name="frmResetPwd" property="hdnEmpDept" /></td>
                                </tr>
                            </logic:equal>
                        </table>
                    </td>
                </tr>
            </table>
                            
            <div align="center">
                <html:button accesskey="S" value="Reset Password" styleClass="butto" onclick="if(mandatory_Check(frmResetPwd)){lfnResetPwd();}" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnSubmit"/> 
                <html:button accesskey="C" value="Cancel" styleClass="butto" onclick="frmResetPwd.hdnAction.value='Cancel';frmResetPwd.submit();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnCancel"/> 
            </div>
        </html:form>
    </body>
</html:html>

<script>
function lfnLoad()
{
	if(frmResetPwd.txtEmpNo.value==0)
        frmResetPwd.txtEmpNo.value="";
    if((frmResetPwd.hdnEmpDtls.value=="")||(frmResetPwd.hdnEmpDtls.value==0))
        frmResetPwd.btnSubmit.disabled=true;
    else
        frmResetPwd.btnSubmit.disabled=false;
}

function lfnChkEmployee(value)
{
    if(value!="")
    {
        frmResetPwd.hdnAction.value='GetEmpDtls';
        frmResetPwd.submit();
    }
}

function lfnResetPwd()
{
    if(frmResetPwd.txtEmpNo.value!="")
    {
        frmResetPwd.hdnAction.value='ResetPwd';
        frmResetPwd.submit();
    }
}
</script>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html locale="true"><html:base />
    <head>
        <title>INTEGRATED BUSINESS APPLICATION</title>
        <link rel="STYLESHEET" type="text/css" href="<html:rewrite page="/COMMON/CSS/Menucss.css" />">
        <link rel="stylesheet" type="text/css" href="<html:rewrite page="/COMMON/CSS/IBA.css" />"> 
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />"></script>
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />"></script>
        <script type="text/javascript" language="javascript" src="<html:rewrite page="/COMMON/JavaScript/validate.js" />"></script>
    </head>
    <body scroll="no" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
        <html:form name="frmProblemReport" method="post" action="/Problem" type="FCIPAY.COMMON.WEBTIER.Form.ProblemReportForm">

            <html:hidden property="hdnAction" />
            <br>
            <table width="80%" border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><b class="MainHeader">Problem Reporting</b></td>
                </tr>
                <tr>
                    <td width="50%" align="left"><i><font color="red">*</font>Mandatory Fields</i></td>
                </tr>
            </table>

            <html:errors />

            <table width="80%" border="1" align="center">
                <tr>
                    <td>
                        <table border="1" cols="2" cellspacing="0" cellpadding="0" width="100%" class="bgndTable" bordercolor="white">
                            <tr height="20%">
                                <td width="25%" class="labelText" >Screen Name : <i><font color="red">*</font></i></td>
                                <td width="75%" ><html:text property="txtScreenName" styleClass="required" size="50" maxlength="50" /></td>
                            </tr>
                            <tr>
                                <td class="labelText" >Problem Description :</td>
                                <td><html:textarea property="txtArProblemDesc" styleClass="required" rows="4" cols="40" />
                            </tr>

                            <tr>
                                <td class="labelText" >Cause of Error :</td>
                                <td><html:textarea property="txtArCause" styleClass="required" rows="4" cols="40" />
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>

            <br>
            <div align="center">
                <html:button accesskey="S" value="Save" styleClass="butto" onclick="if(mandatory_Check(frmProblemReport)){setHidden(this.value);}" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnSubmit"/> 
                <html:button accesskey="C" value="Reset" styleClass="butto" onclick="setHidden(this.value);" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnCancel"/> 
            </div>
            
        </html:form>
    </body>
</html:html>

<script>

function setHidden(val)
{
    frmProblemReport.hdnAction.value=val;
    frmProblemReport.submit();
}

</script>
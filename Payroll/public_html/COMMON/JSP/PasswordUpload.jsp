<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html locale="true">
<head><html:base />
    <title>Upload Bank Details</title>
    <link rel="STYLESHEET" type="text/css" href="<html:rewrite page="/COMMON/CSS/Menucss.css" />">
    <link rel="stylesheet" type="text/css" href="<html:rewrite page="/COMMON/CSS/IBA.css" />"> 
    <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />"></script>
    <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />"></script>
    <script type="text/javascript" language="javascript" src="<html:rewrite page="/COMMON/JavaScript/validate.js" />"></script>
    
</head>

<%
response.setHeader("cache-Control","no-store");  
response.setHeader("cache-Control","max-age=0");
response.setHeader("Pragma","no-cache");
%>


<body onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
<!--<script language="JavaScript1.2" src='<html:rewrite page="/COMMON/JavaScript/Menujs.js" />'></script>-->
<jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
<br><br><br>
<html:form name ="frmPwdUpload" action="/PwdUpload" type="FCIPAY.COMMON.WEBTIER.Form.PwdUploadForm" method="post" >

    <html:hidden property="uploadAction" />
    <html:hidden property="errLineNo" />

    <table width="100%" border="0">
        <tr>
            <td colspan="2" align="center"><b class="MainHeader">Upload Password</b></td>
        </tr>
        <tr>
            <td width="50%" align="left"><i><font color="red">*</font>Mandatory Fields</i></td>
            <td width="50%" align="left"><div align="right"><i><font color="blue">#</font>Searchable Fields</i></div></td>
        </tr>
    </table>
    
    <html:errors />
    
    <logic:greaterThan name="frmPwdUpload" property="errLineNo" value="0" >
        <table width="100%">
            <center><td align="center" ><strong><font color="red" >Error in Line No <bean:write name="frmPwdUpload" property="errLineNo" /></font></strong></td></center>
        </table>
    </logic:greaterThan>

    <table cellspacing="0"  cols="4"  cellpadding="0"  width="100%"  class="bgndTable"  border="0" >
        <caption><div id="sty" ><b class="SubHeader" >Password File</b></div></caption>
        <tbody>
            <tr>
               <td width="15%"  class="labelText" >Upload File<font color="red"> * </font></td>
               <td width="35%"><html:file property="file"  /></td>
            </tr>
            <tr>
                <td colspan="4">
<br>
                   <b><u> Points to be taken Care in the CSV file Provided</u></b><br>
                        <p>    1) The CSV(Comma seperated) File provided should be in the order mentioned below :
                                    <b>Employee Number,Password to be Encrypted</b>.</p>
                </td>
            </tr>
        </tbody>
    </table>
    <br>
    <center>
    <table cellspacing = "0" cellpadding = "0">
        <tr>
            <td>     
                <html:button accesskey="U" value="Upload" onclick="setHidden();" styleClass="butto" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butUpload" /></td>
            </td>     
            <td>             
                <html:button accesskey="R" value="Reset" onclick="document.frmPwdUpload.uploadAction.value='reset';document.frmPwdUpload.submit();" styleClass="butto" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="butUpload" /></td>
            </td>
        </tr>
    </table>
    </center>
</html:form>
</body>
</html:html>

<script>

function lfnLoad()
{
    if(document.frmPwdUpload.uploadAction.value=="")
    {
        document.frmPwdUpload.uploadAction.value="onLoad";
        document.frmPwdUpload.submit();
    }
}

function setHidden()
{
    if(document.frmPwdUpload.file.value!="")
    {
        document.frmPwdUpload.uploadAction.value="upload";
        document.frmPwdUpload.submit();
    }
    else
        alert("Mandatory Fields is empty");
}
</script>
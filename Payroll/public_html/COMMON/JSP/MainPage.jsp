<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ page import="java.io.*" %>


<html:html locale="true">
<head><html:base />
    <script language="javascript"  src='<html:rewrite page="/COMMON/JavaScript/validate.js" />' ></script>
    <script language="JavaScript1.2"  src='<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />'  ></script>
    <script language="JavaScript1.2"  src='<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />' ></script>
    <script language="JavaScript"  src='<html:rewrite page="/COMMON/JavaScript/calendar1.js" />' ></script>
    <link rel="STYLESHEET"  type="text/css"  href='<html:rewrite page="/COMMON/CSS/Menucss.css" />' >
    <link rel ="STYLESHEET" href ='<html:rewrite page="/COMMON/CSS/IBA.css" />' >
	<TITLE>Main Page</TITLE>
</HEAD>

<style type="text/css" lang="CSS">
.clsModule
{
    BORDER-RIGHT: #040404  thick groove;
    BORDER-LEFT: #040404  thin groove;
    BORDER-BOTTOM: #040404 thick groove;
    BORDER-TOP: #040404  thin groove;
    background-color:#0080c0;
    PADDING-RIGHT: 2px;
    PADDING-LEFT: 2px;
    FONT-WEIGHT: lighter;
    PADDING-BOTTOM: 2px;
    MARGIN: 2px;
    PADDING-TOP: 2px;
    FONT-FAMILY: Verdana, Arial;
    color:White;
    width:110.0pt;
    height:80.0pt;
    border-style : outset;
    cursor:pointer;
}

.clsButtons 
{
    background-color: #7ea8cf;
    width: auto;
    text-align: center;
    cursor:pointer;
}
</style>

    <BODY onload="if(frmMainPage.hdnAction.value==''){setHidden('');}history.forward(1);" topmargin="0" bgcolor="#d9ecff" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <html:form name="frmMainPage" action="/MainPage" type="FCIPAY.COMMON.WEBTIER.Form.MainPageForm">

            <bean:define id="moduleList" name="frmMainPage" property="moduleList" />
            <bean:define id="menuList" name="frmMainPage" property="menuList" />
            
            <html:hidden property="hdnAction" />
            
            <TABLE width="100%" height="10%" bgcolor="#0080c0">
                <TR>
                    <TD width="75%"><div align="center"><font size="5"><b>PAYROLL MANAGEMENT SYSTEM</b></font></div></TD>
                </tr>
            </TABLE>
            <table width="100%">
            <tr><td align="right">
                <div align="right">
                    <html:button property="btnExit" value="Logout" styleClass="clsButtons" onclick="setHidden(this.value);" />
                    <html:button property="btnExit" value="Change Password" styleClass="clsButtons" onclick="setHidden(this.value);" />
                </div>
            </td></tr>
            </table>
            <BR>

            <TABLE bgcolor="" align="center">
                <TR>
                    <TD align="center"><b><u>LIST OF MODULES</u></b> </TD>
                </TR>
                
                <tr><td><br><br><br></td></tr>
                
                <TR>
                    <TD>
                        <center>
                            <% int i=0; %>
                            <logic:iterate name="frmMainPage" id="DynamicMenuBean" property="moduleList" >
                                <% ++i; %>
                                <html:button property="btnExit" styleClass="clsModule" onclick="setHidden(this.value);" >
                                    <bean:write name="DynamicMenuBean" property="dynamicMenu"/>
                                </html:button>   
                                <% if((i%4)==0) { %> 
                                    <br><br>
                                <% } %>
                            </logic:iterate>
                        </center>
                    </TD>
                </TR>
            </TABLE>
            <br><br>
        </html:form>
    </body>
</html:html>

<script>
<%
    String psswdStts=(String)session.getAttribute("psswrdStts");
    int days=Integer.parseInt(psswdStts);
%>
function setHidden(value)
{
//alert(1);
   var day=<%=days%>;
  // alert(day);
   if(day>=90)
   {
    alert("Your password has expired. Please change the password");
    value="Change Password";
   }
    
    if(value=="")
        value="OnLoad";
    frmMainPage.hdnAction.value=value;
    frmMainPage.submit();

}
</script>
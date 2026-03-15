<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html locale="true">
    <head><html:base />
        <title>LogIn Screen</title>

        <link rel="stylesheet" type="text/css" href="<html:rewrite page="/COMMON/CSS/IBA.css" />"> 
        <script type="text/javascript" language="javascript" src="<html:rewrite page="/COMMON/JavaScript/validate.js" />"></script>
    </head>

    <body bgcolor="white" topmargin="0" onload ="lfnOnLoad();history.forward(1);">
        <html:form name="frmLogin" action = "/Login" method="post" type="FCIPAY.COMMON.WEBTIER.Form.LoginForm" >

            <bean:define name="frmLogin" id="locList" property="locList" />

            <html:hidden property="hdnAction" />
            <table width="80%" height="100%" border="1" align="center" cellpadding="0" cellspacing="0" bordercolor="#000000">
                <tr>
                    <td valign="top">
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                            <tr> 
                                <td height="144" valign="top"> 
                                    <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                        <tr> 
                                            <td><img src="<html:rewrite page='/COMMON/JSP/Header.jpg' />" width="800" height="151"></td>
                                        </tr>
      						              
                                        <tr> 
                                            <td height="100" align="right" bgcolor="1059a2"><img src="<html:rewrite page='/COMMON/JSP/Title.jpg' />" width="431" height="46"></td>
                                        </tr>
                                    </table>
                                </td>
                            </tr>
                        </table>
                        
                        <html:errors />
                        
                        <table width="100%" border="0" cellpadding="0" cellspacing="0">
                            <tr>
                                <td align="center" valign="middle"><br><br>
                                    <table width="400" border="1" cellpadding="5" cellspacing="0">
                                        <tr>
                                            <td width="299" align="center" valign="middle" bgcolor="#DCDCDC"> 
                                                <table width="271" border="0" cellspacing="5" cellpadding="5">
                                                    <tr> 
                                                        <td width="90"><strong><font size="2" face="Arial, Helvetica, sans-serif">User Id</font></strong></td>
                                                        <td width="146"><html:text styleClass ="required" property="txtUserId" size = "20"   maxlength = "10" onblur="frmLogin.txtPwd.value='';frmLogin.lstLocCode.value='';" /></td>
                                                    </tr>

                                                    <tr> 
                                                        <td><strong><font size="2" face="Arial, Helvetica, sans-serif">Password</font></strong></td>
                                                        <td><html:password styleClass ="required" property="txtPwd" size = "20"  maxlength = "8" onkeypress="lfnChkEnterKey(this.value);" onblur="lfnGetLocDtls();" /></td>
                                                    </tr>

                                                    <tr> 
                                                        <td><strong><font size="2" face="Arial, Helvetica, sans-serif">Location</font></strong></td>
                                                        <td>
                                                            <html:select property="lstLocCode" styleClass ="required" style="width:250" onchange="if(this.value!=''){frmLogin.actionValue.focus();}" >
                                                                <html:option value="" >Please Select</html:option>
                                                                <html:options collection="locList" property="idString" labelProperty="code" />
                                                            </html:select>
                                                        </td>
                                                    </tr>

                                                    <tr> 
                                                        <td colspan="2" align="center"> <strong><font size="2"><html:submit accesskey="L" value="Login" property = "actionValue" /></font></strong></td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                    </table> 
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
        </html:form>
    </body>
</html:html>


<script>
var tempEnterKey;

function lfnOnLoad()
{
    if(frmLogin.lstLocCode.length==1)
    {
        frmLogin.txtUserId.value="";
        frmLogin.txtPwd.value="";
        frmLogin.txtUserId.focus();
    }
    else
    {
        if(frmLogin.lstLocCode.length==2)
            frmLogin.actionValue.focus();
        else
            frmLogin.lstLocCode.focus();
    }
}

function lfnChkEnterKey(val)
{
    if(event.keyCode==13)
        tempEnterKey=1;
    else
        tempEnterKey=0;
}


function lfnGetLocDtls()
{
    if((frmLogin.txtUserId.value!="")&&(frmLogin.txtPwd.value!="")&&(tempEnterKey!=1))
    {
        frmLogin.hdnAction.value="GetLocDetails";
        frmLogin.submit();
    }
}
</script>
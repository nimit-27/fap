<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html locale="true">
    <head><html:base />
        <title>LogIn Screen</title>

        <link rel="STYLESHEET" type="text/css" href="../../COMMON/CSS/Menucss.css"> 
        <script type="text/javascript" language="javascript" src="../../COMMON/JavaScript/validate.js"></script>
    </head>

    <body bgcolor="white" topmargin="0" onload ="lfnOnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <html:form name="frmLogin" action = "/Login" onsubmit="lfnOnSubmit();" method="post" type="FCIPAY.COMMON.WEBTIER.Form.LoginForm" >

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
                                           <td><img src="anim1.gif" width="310" height="151"></td>
                                           <td> <img src="fcilogo.gif" width="150" height="151"></td>
                                            <td><img src="anim2.gif" width="310" height="151"></td>
                                           </td>
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
                                                        <td width="146"><html:text styleClass ="required" property="txtUserId" size = "20"   maxlength = "10" /></td>
                                                    </tr>

                                                    <tr> 
                                                        <td><strong><font size="2" face="Arial, Helvetica, sans-serif">Password</font></strong></td>
                                                        <td><html:password styleClass ="required" property="txtPwd" size = "20"  maxlength = "50" onkeypress="lfnChkEnterKey(this.value);" onblur="lfnGetLocDtls();" /></td>
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


<script type="text/javascript">
var tempEnterKey;

function lfnOnLoad()
{
    chkcompartible();
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
        lfnOnSubmit();
        frmLogin.hdnAction.value="GetLocDetails";
        frmLogin.submit();
    }
}
function lfnOnSubmit() {
    frmLogin.autocomplete = "off";
    frmLogin.txtUserId.readOnly = true;
    return true;
}
function chkcompartible() 
{
      var ua = window.navigator.userAgent
      var msie = ua.indexOf ( "MSIE " )
      var ifcompatible=1;
      //alert("ua=="+ua+", msie=="+msie)
      
      if(navigator.userAgent.match(/Trident/) || navigator.userAgent.match(/Edge/)) {  //browser being used is IE 11, IE Edge
          if (!navigator.userAgent.match(/compatible/)) {
              ifcompatible=0; //web site is not added to compatible view.
          }
      }
      else {
          ifcompatible=2;
      }
      
    if(ifcompatible==0) 
    {
       alert("Please add the web site in compatible view.(internet explorer settings->Compatibility View settings->add)");
       var win=window.open("","_top","","true");
       win.opener=true;
       win.close();
    }
    if(ifcompatible==2) 
    {
       alert("Please run the application on Internet explorer only");
       var win1=window.open("","_top","","true");
       win1.opener=true;
       win1.close();
    }
}
</script>
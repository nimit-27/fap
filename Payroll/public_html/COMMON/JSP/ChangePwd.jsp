<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html locale="true"><html:base />
    <head>
        <title>FCI-Payroll</title>
        <link rel="STYLESHEET" type="text/css" href="<html:rewrite page="/COMMON/CSS/Menucss.css" />">
        <link rel="stylesheet" type="text/css" href="<html:rewrite page="/COMMON/CSS/IBA.css" />"> 
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />"></script>
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />"></script>
        <script type="text/javascript" language="javascript" src="<html:rewrite page="/COMMON/JavaScript/validate.js" />"></script>
    </head>
    <body onload="lfnOnLoad();frmChangePwd.txtOldPwd.focus();history.forward(1);" scroll="no" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <html:form name="frmChangePwd" method="post" action="/ChangePwd" type="FCIPAY.COMMON.WEBTIER.Form.ChangePwdForm">

            <html:hidden property="hdnAction" />
            <html:hidden property="hdnEmpNo" />
            
            <logic:notEqual property="hdnAction" value="Hide_home" name="frmChangePwd"> 
            <br>
            <div align="right">
                <html:button accesskey="H" value="Home" styleClass="butto" onclick="setHidden(this.value);" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnHome"/> 
            </div>
            <br>
            </logic:notEqual>
            <table width="50%" border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><b class="MainHeader">Change Password</b></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">&nbsp;</td>
                </tr>

            </table>
				 <html:errors />

            <table border="1" width="50%" align="center">
                <tr>
                    <td align="left"><i><font color="red">*</font>Mandatory Fields</i></td>
                </tr>
                <tr>
                    <td>
                        <table border="1" cols="2" cellspacing="0" cellpadding="0" width="100%" class="bgndTable" bordercolor="white">
                            <tr>
                                <td width="50%" >Emp No :</td>
                                <td width="50%" ><bean:write name="frmChangePwd" property="hdnEmpNo" /></td>
                            </tr>
                            
                            <tr>
                                <td width="50%" >Old Password : <font color="red">*</font></td>
                                <td width="50%" ><html:password property="txtOldPwd" size="20" maxlength="50" styleClass ="required" /></td>
                            </tr>

                            <tr>
                                <td width="50%" >New Password : <font color="red">*</font></td>
                                <td width="50%" ><html:password property="txtNewPwd" size="20" maxlength="50" styleClass ="required" /></td>
                            </tr>

                            <tr>
                                <td width="50%">Confirm Password : <font color="red">*</font></td>
                                <td width="50%"><html:password property="txtConfirmPwd" size="20" maxlength="50" styleClass ="required" /></td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>
            
            <br>
            <div align="center">
                <html:button accesskey="S" value="Change Password" styleClass="butto" onclick="if(mandatory_Check(frmChangePwd)){lfnSave(this.value);}" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnSubmit"/> 
                <html:button accesskey="C" value="Cancel" styleClass="butto" onclick="lfnClearValues();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnCancel"/> 
                
            </div>
			<table width="80%">
			    <tr>
	              <td colspan=2><b><u> <font color="red">Password Policy :</font></u></b></td>			
				</tr>
			    <tr>
	              <td>1.</td>			
	              <td>it should contain minimum 8 characters. </td>			
				</tr>
			    <tr>
	              <td>2.</td>			
	              <td>the use of both upper- and lower-case letters (case sensitivity).</td>			
				</tr>
			    <tr>
	              <td>3.</td>			
	              <td>inclusion of at least one numeric and alphabet.</td>			
				</tr>
		<!--commented to remove special charecter from password policy
        <tr>
	              <td>4.</td>			
	              <td>inclusion of one or more special characters. e.g @,#,$,% etc.</td>			
				</tr>
        -->
			</table>
        </html:form>
    </body>
</html:html>

<script>

function lfnOnLoad()
{
    frmChangePwd.txtOldPwd.value="";
    frmChangePwd.txtNewPwd.value="";
    frmChangePwd.txtConfirmPwd.value="";
    if(frmChangePwd.hdnEmpNo.value==0)
        frmChangePwd.hdnEmpNo.value="";
    if(frmChangePwd.hdnAction.value=="")
        setHidden('OnLoad');
    
}

function lfnSave(value)
{
    //if(lfnForceAlNum())
    //{
    if(frmChangePwd.txtNewPwd.value==frmChangePwd.txtOldPwd.value)
        alert("New and Old Passwords cant be the same");
    else if(frmChangePwd.txtNewPwd.value!=frmChangePwd.txtConfirmPwd.value)
        alert("Please give the same Password for New and Confirm");
    else
        setHidden(value);
    lfnClearValues();
    //}
    
    //else
    //return false;
}

function setHidden(value)
{
    frmChangePwd.hdnAction.value=value;
    frmChangePwd.submit();  
}

function lfnClearValues()
{
    frmChangePwd.txtOldPwd.value="";
    frmChangePwd.txtNewPwd.value="";
    frmChangePwd.txtConfirmPwd.value="";
    frmChangePwd.txtOldPwd.focus();
}
function alpha_Check_this(value) 
{
	if(value=="")
		return true;
	//value=trim(value);
	var alphanumPattern = /^[a-zA-Z\s]+$/;  
	if(alphanumPattern.test(value)) 
		return(true);
	else
	{
		
		return(false);
	}
}
function num_Check_this(value,temp)
        {
            if(value=="")
                return true;
            //value=trim(value);
            if(temp==0)//for acceptin Zeros
                var intPattern = /^(((\d*)+[1-9]{1}+[0-9]*)|(^0{1}))$/;//This will function will accept any number of Zeros at First
            if(temp==1)
                var intPattern =/^(([1-9]{1}+[0-9]*)|(0{1}))$/;
            if(temp==2)
                var intPattern =/^([1-9]{1}+[0-9]*)$/;
            if(intPattern.test(value))
                return(true);
            else
            {
            
            return(false);
            }
}
function alphanum_Check_this(value) 
{
	if(value=="") 
		return true;
	//value=trim(value);
	//var alphaPattern = /^[a-zA-Z0-9]{1}+[.a-zA-Z0-9\s]*$/; 
	var alphaPattern = /^[\.&_()<>%*,\-\/a-zA-Z0-9\s]+$/; 
	if (alphaPattern.test(value))
		return(true);
	else 
	{
		return(false);
	}
}


function lfnForceAlNum()
{
    if(!(alpha_Check_this(frmChangePwd.txtNewPwd.value))&&!(num_Check_this(frmChangePwd.txtNewPwd.value,2))&&(alphanum_Check_this(frmChangePwd.txtNewPwd.value))&& frmChangePwd.txtNewPwd.value.length>=8)
    {
        return true;
    }
    else
    {
        alert("The Password should contain both Alphabets and Numerals and length should be atleast 8 characters!");
        frmChangePwd.txtNewPwd.focus();
        return false;
    }
}
</script>

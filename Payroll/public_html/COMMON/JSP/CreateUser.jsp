<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>  
    <script language="JavaScript1.2" src="../INCLUDES/EmpFinanceInfo.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/ENRGISE.js"></script>
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
<html:html locale="true"><html:base />
    <head>
        <title>Create User</title>
        <link rel="STYLESHEET" type="text/css" href="<html:rewrite page="/COMMON/CSS/Menucss.css" />">
        <link rel="stylesheet" type="text/css" href="<html:rewrite page="/COMMON/CSS/IBA.css" />"> 
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />"></script>
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />"></script>
        <script type="text/javascript" language="javascript" src="<html:rewrite page="/COMMON/JavaScript/validate.js" />"></script>
    </head>
    <body onload="lfnLoad();history.forward(1);" scroll="no" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
        <html:form name="frmResetPwd" method="post" action="/CreateUser" type="FCIPAY.COMMON.WEBTIER.Form.ResetPwdForm">
        <bean:define id="ParentForm" name="frmResetPwd" toScope="session" />
            <html:hidden property="hdnAction" />
            <html:hidden property="hdnEmpDtls" />

            <html:hidden property="hdnEmpName" />
            <html:hidden property="hdnEmpDept" />
            <html:hidden property="hdnEmpDesig" />
            <html:hidden property="loginLocCode" name="frmResetPwd" value="" />
            <input type="hidden" name="queryParam" />
            <!--input type="hidden" name="loginLocCode" /-->
        
             <input type="hidden" name="txtInputField" />
             <input type="hidden" name="txtDisplayFields" />
             <input type="hidden" name="txtSearchFields" />
             <input type="hidden" name="txtIndex" />
            
            <input type="hidden" name="txtEmpName">

            <!--input type="hidden" name="txtEmpMiddleName">
            <input type="hidden" name="txtEmpLastName"-->
            <input type="hidden" name="txtCpfCode">
            <input type="hidden" name="txtSiteCode">
            <input type="hidden" name="txtSiteDesc">
            <input type="hidden" name="txtUserFlag">
            
        <!--input type="hidden" name="screenMode" /-->
         <input type="hidden" name="lovKey" />
            <html:hidden name="frmResetPwd"  property="screenName" value="CreateEmpDetailScreen" />  
             <html:hidden name="frmResetPwd"  property="screenMode" value="Q" />  
            <br><br>
            <table width="50%" border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><b class="MainHeader">Create User</b></td>
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
                                <td width="65%" >
                                <!-- Added by Neeraj on 05-oct-2010-->
                               
                                 <!--logic:equal property= "screenMode" name= "frmResetPwd" value="Q"-->
                                <!--End of code added on 05-oct-2010 -->
                                <html:text property="txtEmpNo" size="20"  maxlength="10" styleClass="required" onchange="lfnChkEmployee(this.value);" />
                                <!-- Added by Neeraj on 05-oct-2010-->
                                <img src="../Images/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                                <!--/logic:equal-->
                                <!--End of code added on 05-oct-2010 -->
                                </td>
								<html:hidden property="userStatus" name="frmResetPwd" />
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
				<logic:equal name="frmResetPwd" property="userStatus" value="I">
	                <html:button accesskey="U" value="Make Active" styleClass="butto" onclick="if(mandatory_Check(frmResetPwd)){activateUser();}" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnSubmit"/> 
				</logic:equal>
				<logic:notEqual name="frmResetPwd" property="userStatus" value="I">
		            <html:button accesskey="S" value="Create User" styleClass="butto" onclick="if(mandatory_Check(frmResetPwd)){lfnResetPwd();}" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnSubmit"/> 
				</logic:notEqual>
            </div>
        </html:form>
    </body>
</html:html>

<script>

function ShowEmpNum()
{
   frmResetPwd.lovKey.value = "EmpFinInfo" + frmResetPwd.screenName.value + frmResetPwd.screenMode.value;
   frmResetPwd.queryParam.value = "txtSiteID="+frmResetPwd.loginLocCode.value+",hdnEmpLbrFlag=E";

   if(frmResetPwd.screenMode.value == 'Q')
   {
     frmResetPwd.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode,txtSiteCode,txtSiteDesc,txtUserFlag"; //added by neeraj
     frmResetPwd.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.EmpName,Payroll.Common.cpfCode,Payroll.common.SiteCode,Payroll.common.SiteDesc,Payroll.common.UserFlag"; //added by devendra
	 frmResetPwd.txtIndex.value ="";      
   }
   frmResetPwd.txtInputField.value ="txtEmpNo"; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CreateSearchScreenNew.jsp" />', 'frmResetPwd');
   return true;
}

function showLov(pageName, formName) {
    var oLovWin=window.open(pageName,formName, "height=500,width=900,resizable=yes,menubar=no,toolbar=none,statusbar=none");
    oLovWin.moveTo(200,200);
    //oLovWin.document.all.hdnLOVFlag.value = '0';
}

<!--Added by Neeraj Ends-->
function lfnLoad()
{
	if(frmResetPwd.txtEmpNo.value==0)
	{
		frmResetPwd.txtEmpNo.value="";
	}

    if((frmResetPwd.hdnEmpDtls.value=="")||(frmResetPwd.hdnEmpDtls.value==0))
        frmResetPwd.btnSubmit.disabled=true;
    else
        frmResetPwd.btnSubmit.disabled=false;

    if(frmResetPwd.userStatus.value != "")
	{
		if(frmResetPwd.userStatus.value=="I")
		{
			alert("This User is Inactive in the System. Press 'Make Active' button to make the User Active.");
			frmResetPwd.btnSubmit.disabled=false;
		}
		else
		{
			frmResetPwd.btnSubmit.disabled=true;
		}
	}
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
        frmResetPwd.hdnAction.value='CreateUser';
        frmResetPwd.submit();
    }
}

function activateUser()
{
    if(frmResetPwd.txtEmpNo.value!="" && frmResetPwd.userStatus.value=='I')
    {
        frmResetPwd.hdnAction.value='activateUser';
        frmResetPwd.submit();
    }
	else
	{
		alert("This user is already Active");
	}
}
</script>
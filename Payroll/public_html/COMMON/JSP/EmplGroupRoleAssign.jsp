
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html locale="true"><head>
<html:base />
<title>Assign Groups & Roles</title>


<SCRIPT language="javascript" src='<html:rewrite page="/COMMON/JavaScript/validate.js" />'></SCRIPT>

<SCRIPT language="javascript" src='<html:rewrite page="/Finance/JavaScript/fin_validate.js" />'></SCRIPT>

<link rel="stylesheet" HREF='<html:rewrite page="/COMMON/CSS/IBA.css" />'>

<link rel="STYLESHEET" type="text/css" href='<html:rewrite page="/COMMON/CSS/Menucss.css" />'>

<script language="JavaScript1.2" src='<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />'></script>

<script language="JavaScript1.2" src='<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />'></script>

<style>
#div2 
{
	OVERFLOW: hidden
}

#div1 
{
	OVERFLOW: scroll; HEIGHT: 160px
}
#asdf
{
   WIDTH: 800px; HEIGHT: 600px
}
</style>

<script>

window.onunload=onCloseFromTop;
function onCloseFromTop() {
    if(window.screenTop>10000) {
        frmEmpGrpRoleAssign.txtHidAction.value="quitUser";
        frmEmpGrpRoleAssign.submit();
    }
}

var winSearchObj;

function openCentered (url, windowName) {
  winSearchObj=window.open(url, windowName);//,"menubar=no,resizable=no,toolbar=no,location=no,scrollbars=yes,width=700,height=550"); //, windowName, featureString);'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no
  return winSearchObj;
}



function lfnCheckStar(value) {  
   var open="false";
   var today;
   if((event.srcElement.value=="*") && (event.keyCode==13)) {
        event.srcElement.value="";
        open="true";
   }
   if(open=="true") {
        var err="";
        var errdesc="";
        today = new Date();
        if(winSearchObj==null) {
            frmEmpGrpRoleAssign.txtOpeningTime.value=today.toString();
            frmEmpGrpRoleAssign.txt_AddCond.value="";
            openCentered('<html:rewrite page="/COMMON/JSP/CommonSearchScreen.jsp" />','asdf');
        }
        else {
            try {
                winSearchObj.focus();
            }
            catch(exception) {
                if (exception.description != null) {
                    errdesc=exception.description;
                    if(exception.description==errdesc) {
                        err="Y";
                    }
                }
            }
        }
        if(err=="Y") {
            frmEmpGrpRoleAssign.txtOpeningTime.value=today.toString();
            frmEmpGrpRoleAssign.txt_AddCond.value="";
            openCentered('<html:rewrite page="/COMMON/JSP/CommonSearchScreen.jsp" />','asdf');
        }
        return true;
   }
}
function checkEmplNo() {
    if(event.srcElement.value!="" && num_Check(event.srcElement.value,1)==true) {
        frmEmpGrpRoleAssign.txtHidAction.value="getEmpUserLocIdDetails";
        frmEmpGrpRoleAssign.submit();
        return true;
    }
    return false;    
}
function selectGroups() {
    if(event.srcElement.value!="") {
        frmEmpGrpRoleAssign.txtHidAction.value="getEmplGroupDetails";
        frmEmpGrpRoleAssign.submit();
        return true;
    }
    return false;
}

function selectRoleRows() {
    if(event.srcElement.value!="") {
        if(frmEmpGrpRoleAssign.txtModule.value==""){
            alert("Module Should Be Selected Before Selecting The Role");
            frmEmpGrpRoleAssign.txtModule.focus();
            return false;
        }
        frmEmpGrpRoleAssign.txtHidAction.value="getEmpRoleRowDetails";
        frmEmpGrpRoleAssign.submit();
        return true;
    }
    return false;
}

/*function onLoadCall() {
    if(eval(frmEmpGrpRoleAssign.txtHidTotRowsGroups.value)>0) {
        for(i=0;i<eval(frmEmpGrpRoleAssign.txtHidTotRowsGroups.value);i++) {
            alert(document.getElementsByName("txtHidGroupChecked")[i].value);
            if(document.getElementsByName("txtHidGroupChecked")[i].value!="") {
                document.getElementsByName("isGroupChecked")[i].checked=true;
            }
            else
                document.getElementsByName("isGroupChecked")[i].checked=false;
            alert(document.getElementsByName("isGroupChecked")[i].checked);
        }
    } 
    if(eval(frmEmpGrpRoleAssign.txtHidTotRowsRole.value)>0) {
        for(i=0;i<eval(frmEmpGrpRoleAssign.txtHidTotRowsRole.value);i++) {
            if(document.getElementsByName("txtHidRoleChecked")[i].value!="") {
                document.getElementsByName("isRoleChecked")[i].checked=true;
            }
            else
                document.getElementsByName("isRoleChecked")[i].checked=false;
        }
    }
}*/

function onLOAD() {
    if(frmEmpGrpRoleAssign.txtHidDisableButtons.value=="NoEmpFound") {
        frmEmpGrpRoleAssign.txtEmplNo.value="";
        frmEmpGrpRoleAssign.txtEmplNo.focus();
    }
}

function Save() {
    var Save="NoSave";
    if(frmEmpGrpRoleAssign.txtEmplNo.value=="") {
        alert("Employee No Is Mandatory");
        frmEmpGrpRoleAssign.txtEmplNo.focus();
    }
    if(frmEmpGrpRoleAssign.txtModule.value==""){
        alert("Module Is Mandatory");
        frmEmpGrpRoleAssign.txtModule.focus();
        return false;
    }
    if(frmEmpGrpRoleAssign.txtRole.value==""){
        alert("Role Is Mandatory");
        frmEmpGrpRoleAssign.txtRole.focus();
        return false;
    }
    if(eval(frmEmpGrpRoleAssign.txtHidTotRowsGroups.value)>0) {
        for(i=0;i<eval(frmEmpGrpRoleAssign.txtHidTotRowsGroups.value);i++) {
            if(document.getElementsByName("isGroupChecked")[i].checked==true) {
                document.getElementsByName("txtHidGroupChecked")[i].value="Y"
                Save="Savve";
            }
        }
    } 
    if(eval(frmEmpGrpRoleAssign.txtHidTotRowsRole.value)>0) {
        for(i=0;i<eval(frmEmpGrpRoleAssign.txtHidTotRowsRole.value);i++) {
            if(document.getElementsByName("isRoleChecked")[i].checked==true) {
                document.getElementsByName("txtHidRoleChecked")[i].value="Y";
                Save="Savve";
            }
        }
    }
    if(Save!="Savve")  {
        alert("Nothing to save");
        return false;
    }
    frmEmpGrpRoleAssign.txtHidAction.value="Save";
    frmEmpGrpRoleAssign.submit();
}
function Reset() {
    frmEmpGrpRoleAssign.txtHidAction.value="Reset";
    frmEmpGrpRoleAssign.submit();
}
</script>
</head>
<body bgcolor="white" topmargin="0" onload="onLOAD();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">

    <!--script language="JavaScript1.2" src='<html:rewrite page="/COMMON/JavaScript/Menujs.js" />'></script-->
    <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
    <br><br>

<html:form name="frmEmpGrpRoleAssign"  method="post" action="EmplGrpRoleAssignMap" type="FCIPAY.COMMON.WEBTIER.Form.EmplGrpRoleAssignForm" >

    <html:hidden property="txtHidAction" />
    <html:hidden property="txtHidDisableButtons" />
    <html:hidden property="txtHidTotRowsGroups" />
    <html:hidden property="txtHidTotRowsRole" />

    <!-- Hidden Fields For Search Screen -->

    <html:hidden property="txtHidWhField" value="txtEmplNo" />
    <html:hidden property="txtIdLength" value="10" />
    <html:hidden property="txt_Id" value="EMP_NO" />
    <html:hidden property="txt_Desc" value="EMP_FST_NAME" />
    <html:hidden property="txtTable" value="HRM_EMPLOYEE" />
    <html:hidden property="txt_AddCond" value="" />
    <html:hidden property="txtOpeningTime" />

    <!-- Bean Definitions -->
    <bean:define id="lstRoles" name="frmEmpGrpRoleAssign" property="lstRoles" />
    <bean:define id="lstModules" name="frmEmpGrpRoleAssign" property="lstModules" />
    <bean:define id="lstGroupRows" name="frmEmpGrpRoleAssign" property="lstGroupRows" />
    <bean:define id="lstRoleRows" name="frmEmpGrpRoleAssign" property="lstRoleRows" />

    <center><b class="MainHeader" >Assign Groups & Roles</b></center>
    <br>
    <table cellspacing="0"  cellpadding="0"  width="100%"  bgcolor="white"   border="0" >
        <tbody>
          <tr align="left">
             <td width="85%"  class="labelText" align="left" ><font color="red" >*</font>&nbsp;&nbsp;Mandatory Fields </td>
             <td width="15%"  class="labelText" align="right" ><font color="blue" >#</font>&nbsp;&nbsp;Searchable Fields</td> 
          </tr>
        </tbody>
    </table>

    <html:errors />
    <html:messages id="messages" message="true">
     <center><font face="Arial" color="blue" size="3"><bean:write name="messages" /></font></center>
    </html:messages>


    <table cellspacing="0"  cols="4"  cellpadding="0"  width="100%"  class="bgndTable"  border="1" bordercolor="white" >
        <caption><div id="sty" ><b class="SubHeader" >Employee Detail</b></div></caption>
        <tbody>
            <tr>
                <td width="10%"  class="labelText" ><b>Employee No</b><font color="red" >*</font><font color="blue" >#</font></td>
                <td width="40%" ><html:text property="txtEmplNo" size="35" maxlength ="10" onkeydown="lfnCheckStar();" onblur="checkEmplNo();" /></td>

                <td width="10%" class="labelText" ><b>Employee Name</b></td>
                <td width="40%" class="printText"><bean:write property="txtEmplName" name="frmEmpGrpRoleAssign" />&nbsp;</td>
            </tr>
        </tbody>
    </table>
    <table cellspacing="0"  cols="4"  cellpadding="0"  width="100%"  class="bgndTable"  border="1" bordercolor="white" >
        <caption><div id="sty" ><b class="SubHeader" >Roles-Module Details</b></div></caption>
        <tbody>
            <tr>
                <td width="10%" class="labelText" ><b>Modules</b><font color="red" >*</font></td>
                <td width="40%" class="printText">
                    <html:select property="txtModule" size="1" style="width:230" onchange="frmEmpGrpRoleAssign.txtRole.value='';" >
                       <html:option value="">Please Select</html:option>
                       <html:options collection="lstModules" property="label" labelProperty="value" />
                    </html:select>
                </td>            
                <td width="10%"  class="labelText" ><b>Roles</b><font color="red" >*</font></td>
                <td width="40%" ><html:select property="txtRole" size="1" style="width:230" onchange="selectRoleRows();">
                           <html:option value="">Please Select</html:option>
                           <html:options collection="lstRoles" property="label" labelProperty="value" />
                           </html:select>
                </td>
            </tr>
        </tbody>
    </table>
    <%! int i=0; %>
    <% i=0; %>
    <logic:greaterEqual name="frmEmpGrpRoleAssign" property="txtHidTotRowsGroups" value="1" >
        <center>
        <table cellspacing="0"  cols="4"  cellpadding="0"  width="100%"  class="bgndTable"  border="1" bordercolor="white" >
            <caption><div id="sty" ><b class="SubHeader" >Group Details</b></div></caption>
        </table>
        <table cellspacing="0"  cellpadding="0"  width="100%"  class="bgndTable"  border="1" bordercolor="white" >
            <tbody>
                <tr>
                    <td width="5%"  align="center"  class="labelText" ><b><center>SrNo</center></b></td>
                    <td width="5%"  align="center"  class="labelText" ><b><center>Sel</center></b></td>
                    <td width="40%"  align="center"  class="labelText" ><b><center>Group Short Desc</center></b></td>
                    <td width="50%"  align="center"  class="labelText" ><b><center>Group Desc</center></b></td>
                </tr>
                <logic:iterate name="frmEmpGrpRoleAssign" property="lstGroupRows" id="Index" >
                    <html:hidden property="txtHidGroupChecked" name="frmEmpGrpRoleAssign" />
                    <tr>
                        <td width="5%" align="center" class="labelText" ><b><center><font color="red"><%=(i+1)%></font></center></b></td>
                        <td width="5%" align="center" ><html:checkbox property="isGroupChecked" alt="<%=String.valueOf(i++)%>" /></td>
                        <td width="40%" align="center"  class="labelText" ><bean:write property="label" name="Index" /></td>
                        <td width="50%" align="center"  class="labelText" ><bean:write property="value" name="Index" /></td>
                    </tr>
                </logic:iterate>
        </table>
        </center>
    </logic:greaterEqual>
    <% i=0; %>
    <logic:greaterEqual name="frmEmpGrpRoleAssign" property="txtHidTotRowsRole" value="1" >
        <center>
        <table cellspacing="0"  cols="4"  cellpadding="0"  width="100%"  class="bgndTable"  border="1" bordercolor="white" >
            <caption><div id="sty" ><b class="SubHeader" >Assign Role to Screen Details</b></div></caption>
        </table>
        <table cellspacing="0"  cellpadding="0"  width="100%"  class="bgndTable"  border="1" bordercolor="white" >
            <tbody>
                <tr>
                    <td width="5%"  align="center"  class="labelText" ><b><center>SrNo</center></b></td>
                    <td width="5%"  align="center"  class="labelText" ><b><center>Sel</center></b></td>
                    <td width="40%"  align="center"  class="labelText" ><b><center>Screen Short Desc</center></b></td>
                    <td width="50%"  align="center"  class="labelText" ><b><center>Screen Desc</center></b></td>
                </tr>
                <logic:iterate name="frmEmpGrpRoleAssign" property="lstRoleRows" id="Index" >
                    <html:hidden property="txtHidRoleChecked" name="frmEmpGrpRoleAssign" />
                    <logic:equal name="Index" property="txtEmpRoleId" value="0">
                    <tr>
                    </logic:equal>
                    <logic:notEqual name="Index" property="txtEmpRoleId" value="0">
                    <tr bgcolor="#d9eeaa">
                    </logic:notEqual>
                        <td width="5%" align="center" class="labelText" ><b><center><font color="red"><%=(i+1)%></font></center></b></td>
                        <td width="5%" align="center" ><html:checkbox property="isRoleChecked" alt="<%=String.valueOf(i++)%>" /></td>
                        <td width="40%" align="center"  class="labelText" ><bean:write property="txtScreenSdesc" name="Index" /></td>
                        <td width="50%" align="center"  class="labelText" ><bean:write property="txtScreenDesc" name="Index" /></td>
                    </tr>
                </logic:iterate>
        </table>
        </center>
    </logic:greaterEqual>
    <table width="100%">
        <center>    
            <td align="center" >
                <html:button accesskey="S" property="butSave" onclick="Save();" value="Save" styleClass="butto" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" />
                <html:button accesskey="S" property="butReset" onclick="Reset();" value="Reset" styleClass="butto" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" />
            </td>
        </center>
    </table>
</html:form>
</body>
</html:html>    

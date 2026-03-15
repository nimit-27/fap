<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!doctype html public -//w3c//dtd html 4.0 transitional//en>
<html:html locale="true"><head><html:base />
<title>Copy Screen Access</title>
<iframe ID="hiddenFrame" NAME="pri" WIDTH="0" HEIGHT="0"></iframe>
<script language="javascript"  src="../../COMMON/JavaScript/validate.js" ></script>

<link rel="STYLESHEET"  type="text/css"  href="../../COMMON/CSS/Menucss.css" >

<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_func.js" ></script>

<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_addins.js" ></script>

<link rel="stylesheet" href="../../COMMON/CSS/IBA.css" >

<%
response.setHeader("cache-Control","no-store");  
response.setHeader("cache-Control","max-age=0");
response.setHeader("Pragma","no-cache");
%>


<meta content="MSHTML 6.00.2600.0" name="GENERATOR" >
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" >
<style>
        #divTable 
        {
            overflow: auto;
            left: 22.5%;
            top: 150px;
            width: 100%;
            height:114px;
        }
    </style>

</head>
<BODY bgcolor="white" topmargin="0" onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
<jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />

<br><br><br> 


<html:form method="post"  name="frmReportingOfficerScreenAccess"  action="/ReportingOfficerScreenAccess" type="FCIPAY.COMMON.WEBTIER.Form.ReportingOfficerScreenAccessForm">
<DIV ID="printReady" class="Print">
<DIV align="center"><b class="MainHeader" >Copy Screen Access</b></DIV>
<br>
<html:errors />
<center>
<br>
             <bean:define name="frmReportingOfficerScreenAccess" id="empList" property="empList" />
            <bean:define name="frmReportingOfficerScreenAccess" id="moduleList" property="moduleList" />
            <bean:define name="frmReportingOfficerScreenAccess" id="headerList" property="headerList" />
            <bean:define name="frmReportingOfficerScreenAccess" id="locList" property="locList" />
            <bean:define name="frmReportingOfficerScreenAccess" id="newLocList" property="newLocList" />
            <html:hidden name="frmReportingOfficerScreenAccess" property="hdnCount"/>
            <html:hidden name="frmReportingOfficerScreenAccess" property="hdnID"/>
            <html:hidden property="txtOpeningTime" />
<html:hidden property="txtHidWhField" />
<html:hidden property="txtIdLength" />
<html:hidden property="txt_Desc" />
<html:hidden property="txt_Id" />
<html:hidden property="txtTable" />
<html:hidden property="txt_AddCond" />
<html:hidden property="hdnValue"/>
            
<table cellspacing="0" cellpadding="0" width="100%" class="bgndTable" border="0">
            <tr>
                <td width="25%">
                    <table>
                        <tr>
                            <td class="labelText">Existing Employee No.<font size="4" color="red">*</font><font size="3" color="blue">#</font></td>
                        </tr>
                    </table>
                </td>
                <td width="35%">
                    <table>
                        <tr>
                            <td>
                                <html:text property="txtExisEmployeeNo" size="20" styleClass="required" maxlength="10" onblur="if(num_Check(this.value,2)){emp_CheckExis(this.value);}" onkeypress="lfnCheckStarExis(this);" />
                            </td>
                        </tr>
                    </table>
                </td>
                <td width="15%">
                    <table>
                        <tr>
                            <td class="labelText">Location</td>
                        </tr>
                    </table>
                </td>
                <td width="35%">
                    <table>
                        <tr>
                            <td>
                                <html:select property="LSiteID" styleClass="required" >
                            <html:option value="">Please Select </html:option>
                            <html:options collection="locList" labelProperty="code" property="idLong" />
                        </html:select>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
            <tr>
                <td width="25%">
                    <table>
                        <tr>
                            <td class="labelText">New Employee No.<font color="red"> *</font><font size="3" color="blue">#</font></td>
                        </tr>
                    </table>
                </td>
                <td width="35%">
                    <table>
                        <tr>
                            <td>
                                <html:text property="txtReptEmployeeNo" size="20" styleClass="required" maxlength="10" onblur="if(num_Check(this.value,2)){emp_CheckRept(this.value);}" onkeypress="lfnCheckStarRept(this);" />
                            </td>
                        </tr>
                    </table>
                </td>
                <td width="15%">
                    <table>
                        <tr>
                            <td class="labelText">Location</td>
                        </tr>
                    </table>
                </td>
                <td width="35%">
                    <table>
                        <tr>
                            <td>
                                <html:select property="newLSiteID" styleClass="required" onblur="emp_CheckRept(this.value)" >
                            <html:option value="">Please Select </html:option>
                            <html:options collection="newLocList" labelProperty="code" property="idLong" />
                        </html:select>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>

            <div id="sty">
                <b class="SubHeader"><center>Screen Details</center></b>
            </div>
            <logic:greaterThan name="frmReportingOfficerScreenAccess" property="descTable" value="0">
            <table border="1" cols="4" cellspacing="0" cellpadding="0" width="100%" class="bgndTable" bordercolor="white">
                <tr>
                    <th width="6%">Select</th>
                    <th width="32%">Level 1/Screen Name</th>
                    <th width="32%">Level 2/Screen Name</th>
                    <th width="30%">Level 3/Screen Name</th>
                </tr>
            </table>
            
            <div name ="divTable" id ="divTable" >
                <table border="1" cols="4" cellspacing="0" cellpadding="0" width="100%"  class ="bgndTable" id="tblScreenDtls" bordercolor="white" >
                    <% int i=0; %>
                    <logic:iterate name="frmReportingOfficerScreenAccess" id="DynamicMenuBean" property="menuList" >
                    <% int j=++i; %>
                    <tr>
                        <td width="6%"><html:checkbox property="chkSelect" name="frmReportingOfficerScreenAccess" value="<%=String.valueOf(j)%>" /><%=String.valueOf(j)%></td>
                        <td width="32%"><bean:write name="DynamicMenuBean" property="level1" /></td>
                        <td width="32%"><bean:write name="DynamicMenuBean" property="level2" />&nbsp;&nbsp;</td>
                        <td width="28%"><bean:write name="DynamicMenuBean" property="level3" />&nbsp;&nbsp;</td>
                        <html:hidden property="hdnCheck" name="DynamicMenuBean"  />
                        <html:hidden property="hdnScreenId" name="DynamicMenuBean" />
                    </tr>
                    </logic:iterate>
                </table>
            </div>
            </logic:greaterThan>
            



<table cellspacing="0" cellpadding="0">
<tr>
<td>
<html:button styleClass="butto" onmouseover="this.style.color='yellow';" accesskey = "S" onclick="lfnGenerate();" onmouseout="this.style.color='white';" property = "butUpdate" value="Update"/></td>
<td>
 <html:button  styleClass="butto" onmouseover="this.style.color= 'yellow';" accesskey ="R" onclick="lfnReset()" onmouseout="this.style.color= 'white';" property ="butReset"  value="Reset"  />
</TD>
</tr>
</table>




<html:hidden property="SAction" />
<html:hidden property="SAction1"  value="" />
<br>
</center></html:form></BODY></html:html>

<SCRIPT> 
function lfnLoad()
{
    //----------------------------------To Set Focus--------------------------------
            val=frmReportingOfficerScreenAccess.hdnValue.value;
            if(val!="")
               {
                        type=eval("frmReportingOfficerScreenAccess."+ val + ".type");
                        if(type=="text")
                         eval("frmReportingOfficerScreenAccess."+ val + ".select()");
                           eval("frmReportingOfficerScreenAccess."+ val + ".focus()");
               }
            // --------------------------------------------------------------------------------
    history.forward(1);
    frmReportingOfficerScreenAccess.hdnCount.value=0;
 document.frmReportingOfficerScreenAccess.butUpdate.disabled=true;
    if(document.frmReportingOfficerScreenAccess.SAction.value == "")
    {
        document.frmReportingOfficerScreenAccess.SAction.value ="Load";
        
        document.frmReportingOfficerScreenAccess.submit();
    }

    
    if(document.frmReportingOfficerScreenAccess.SAction.value=="GetLevels")
    {
        document.frmReportingOfficerScreenAccess.butUpdate.disabled=false;
    }
    /*if(document.frmReportingOfficerScreenAccess.lstModuleName.value=="")
    {
        lfnDisplayModule("");
    }*/
}            


function setHidden(value)
{
    frmReportingOfficerScreenAccess.SAction.value=value;
    frmReportingOfficerScreenAccess.submit();  
}


function lfnCheckStarExis(obj)
  {
    if (trim(obj.value) == "*")
    {
        event.srcElement.value = "";
        try 
        {
            winObj.focus();
            return;
        }
        catch(e) 
        {
        }
        var today = new Date();
        frmReportingOfficerScreenAccess.txtOpeningTime.value = today.toString();
        frmReportingOfficerScreenAccess.txtHidWhField.value="txtExisEmployeeNo";
        frmReportingOfficerScreenAccess.txtIdLength.value="10";
        frmReportingOfficerScreenAccess.txt_Id.value="EMP_NO";
        frmReportingOfficerScreenAccess.txt_Desc.value="EMP_FST_NAME";
        frmReportingOfficerScreenAccess.txtTable.value="HRM_EMPLOYEE";
        frmReportingOfficerScreenAccess.txt_AddCond.value="emp_unit_id="+<bean:write name="USERINFO" property="LLocationCode"/>;
        event.srcElement.value="";
        openCentered('<html:rewrite page="/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmReportingOfficerScreenAccess');
    }
 }

function lfnCheckStarRept(obj)
  {
    if (trim(obj.value) == "*")
    {
        event.srcElement.value = "";
        try 
        {
            winObj.focus();
            return;
        }
        catch(e) 
        {
        }
        var today = new Date();
        frmReportingOfficerScreenAccess.txtOpeningTime.value = today.toString();
        frmReportingOfficerScreenAccess.txtHidWhField.value="txtReptEmployeeNo";
        frmReportingOfficerScreenAccess.txtIdLength.value="10";
        frmReportingOfficerScreenAccess.txt_Id.value="EMP_NO";
        frmReportingOfficerScreenAccess.txt_Desc.value="EMP_FST_NAME";
        frmReportingOfficerScreenAccess.txtTable.value="HRM_EMPLOYEE";
        frmReportingOfficerScreenAccess.txt_AddCond.value="EMP_TEMP_STATUS IN ('HEMPSTATUS$PERM','HEMPSTATUS$PROMPROB','HEMPSTATUS$PROB') and emp_unit_id="+<bean:write name="USERINFO" property="LLocationCode"/>;
        event.srcElement.value="";
        openCentered('<html:rewrite page="/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmReportingOfficerScreenAccess');
    }
 }

 function openCentered (url, windowName)
    {
      winObj=window.open(url, windowName,"menubar=no,resizable=yes,toolbar=no,location=no,scrollbars=yes"); //, windowName, featureString);'toolbar=no,location=no,directories=no,status=no,menubar=no,scrollbars=no,resizable=no
      return winObj;
    }

function emp_CheckRept(val)
   {   
            if(trim(val)=="*" || trim(val)=="" )
            {
                return true;
            }
            else
            {
                if(eval(frmReportingOfficerScreenAccess.txtExisEmployeeNo.value)==eval(frmReportingOfficerScreenAccess.txtReptEmployeeNo.value))
                {
                    if(eval(frmReportingOfficerScreenAccess.LSiteID.value)==eval(frmReportingOfficerScreenAccess.newLSiteID.value))
                    {
                    alert("New Employee cannot be same as the Existing Employee");
                    frmReportingOfficerScreenAccess.txtReptEmployeeNo.select();
                    frmReportingOfficerScreenAccess.txtReptEmployeeNo.focus();
                    return false;
                    }
                }
                frmReportingOfficerScreenAccess.SAction.value="chk";
                frmReportingOfficerScreenAccess.submit();
            }
   }

function emp_CheckExis(val)
   {   
            if(trim(val)=="*" || trim(val)=="" )
            {
                return true;
            }
            else
            {
                frmReportingOfficerScreenAccess.SAction.value="chk1";
                frmReportingOfficerScreenAccess.submit();
            }
   }

function lfnGenerate()
{	
	var d = document.frmReportingOfficerScreenAccess;
	if(mandatory_Check(frmReportingOfficerScreenAccess))
	{
        if(Check_F())
        {
            alert("Your Details are submitted!");
            document.frmReportingOfficerScreenAccess.SAction.value="Save";
            document.frmReportingOfficerScreenAccess.submit();
        }
	}
}

function Check_F()
{
    var flag=false;
    var count=0;
    var oTable = document.getElementById("tblScreenDtls");
    var iTR = eval(oTable.rows.length-1);
    var i;
    var k;
    if(iTR>0)
    {
        for(i=0;i<=iTR;i++)
        {
            if(document.getElementsByName("chkSelect")[i].checked)
            {
                frmReportingOfficerScreenAccess.hdnCheck[i].value="Checked";
                flag=true;
            }
            else
            {
                frmReportingOfficerScreenAccess.hdnCheck[i].value="UnChecked";
            }
        
        }
        if(flag)
        {
            return true;
        }
        else
        {
            alert("Please Select a screen");
            return false;
        }   
    }

    else
    {
         alert("There is no screen to update");
         return false;
    }     
}

function lfnReset()
{
    document.frmReportingOfficerScreenAccess.SAction.value ="Reset";
    document.frmReportingOfficerScreenAccess.submit();
}

function lfnPrintMandatoryMark()
{
	document.write("<font class = 'mandatory'>");
	document.write("*");
	document.write("</font>");
}
  
</SCRIPT> 

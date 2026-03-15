<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<html:html locale="true"><html:base />
    <head>
        <title>PAYROLL</title>
        <link rel="STYLESHEET" type="text/css" href="<html:rewrite page="/COMMON/CSS/Menucss.css" />">
        <link rel="stylesheet" type="text/css" href="<html:rewrite page="/COMMON/CSS/IBA.css" />"> 
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />"></script>
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />"></script>
        <script type="text/javascript" language="javascript" src="<html:rewrite page="/COMMON/JavaScript/validate.js" />"></script>
    </head>

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

    
    <body onload="lfnOnLoad();history.forward(1);" scroll="no" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
        <html:form name="frmSA_ScreenEmpMap" method="post" action="/SA_ScreenEmpMap" type="FCIPAY.COMMON.WEBTIER.Form.SA_ScreenEmpMapForm">

            <bean:define name="frmSA_ScreenEmpMap" id="empList" property="empList" />
            <bean:define name="frmSA_ScreenEmpMap" id="moduleList" property="moduleList" />
            <bean:define name="frmSA_ScreenEmpMap" id="headerList" property="headerList" />
            <bean:define name="frmSA_ScreenEmpMap" id="locList" property="locList" />

            <html:hidden property="hdnAction" />
            
            <html:hidden property="hdnEmpName" />
            <html:hidden property="hdnDesig" />
            <html:hidden property="hdnDept" />

            <html:hidden property="hdnFocus" />

            <html:hidden property="hdnScreenCnt" />
            <html:hidden property="hdnDelCnt" />
                        
            <br>
            <table width="100%" border="0" align="center">
                <tr>
                    <td colspan="2" align="center"><b class="MainHeader">Screen Access Rights</b></td>
                </tr>
                <tr>
                    <td width="50%" align="left"><i><font color="red">*</font>Mandatory Fields</i></td>
                </tr>
            </table>
      
            <html:errors />

            <table border="1" cols="4" cellspacing="0" cellpadding="0" width="100%" class="bgndTable" bordercolor="white">
                <tr>
                    <td width="15%" class="labelText" >Employee No : <i><font color="red">*</font></i></td>
                    <td width="35%" >
                        <html:text property="txtEmpNo" onblur="if((this.value!='')&&(num_Check(this.value,2))){setHidden('GetEmpLst');}" />
                        <html:select property="lstEmpNo" styleClass="required" onchange="if(this.value!=''){setHidden('GetEmpDtls');}">
                            <html:option value="">Please Select </html:option>
                            <html:options collection="empList" labelProperty="code" property="idLong" />
                        </html:select>
                    </td>
                    <td width="15%" class="labelText" >Location :<i><font color="red">*</font></i></td>
                    <td width="35%" >
                    <html:select property="lstLoc" styleClass="required" onchange="if(this.value!='' && frmSA_ScreenEmpMap.lstHeader.value!=''){setHidden('GetLevels');}" >
                            <html:option value="">Please Select </html:option>
                            <html:options collection="locList" labelProperty="code" property="idLong" />
                        </html:select> &nbsp;</td>
                </tr>

                <tr >
                    <td width="15%" class="labelText" >Module Name : <i><font color="red">*</font></i></td>
                    <td width="35%" >
                        <html:select property="lstModule" styleClass="required" onchange="if(this.value!=''){setHidden('GetHeader');}">
                            <html:option value="">Please Select </html:option>
                            <html:options collection="moduleList" labelProperty="code" property="idString" />
                        </html:select>
                    </td>

                    <td width="15%" class="labelText" >Header Name : <i><font color="red">*</font></i></td>
                    <td width="35%" >
                        <html:select property="lstHeader" styleClass="required" onchange="if(this.value!=''){setHidden('GetLevels');}">
                            <html:option value="">Please Select </html:option>
                            <html:options collection="headerList" labelProperty="code" property="idString" />
                        </html:select>
                    </td>
                </tr>
            </table>

            <div id="sty">
                <b class="SubHeader"><center>Screen Details</center></b>
            </div>
            
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
                    <logic:iterate name="frmSA_ScreenEmpMap" id="DynamicMenuBean" property="menuList" >
                    <% int j=++i; %>
                    <tr>
                        <td width="6%"><html:checkbox property="chkSelect" /><%=j%></td>
                        <td width="32%"><bean:write name="DynamicMenuBean" property="level1" /></td>
                        <td width="32%"><bean:write name="DynamicMenuBean" property="level2" />&nbsp;&nbsp;</td>
                        <td width="28%"><bean:write name="DynamicMenuBean" property="level3" />&nbsp;&nbsp;</td>
                        <html:hidden property="hdnCheck" name="DynamicMenuBean" />
                        <html:hidden property="hdnScreenId" name="DynamicMenuBean" />
						<html:hidden property="hdnAudScreenId" name="DynamicMenuBean" />
                    </tr>
                    </logic:iterate>
                </table>
            </div>

            <logic:greaterThan name="frmSA_ScreenEmpMap" property="hdnDelCnt" value="0">
                <div id="sty">
                    <b class="SubHeader"><center>Assigned Screen Details</center></b>
                </div>
            
                <table border="1" cols="4" cellspacing="0" cellpadding="0" width="100%" class="bgndTable" bordercolor="white">
                    <tr>
                        <th width="6%">Del</th>
                        <th width="32%">Level 1/Screen Name</th>
                        <th width="32%">Level 2/Screen Name</th>
                        <th width="30%">Level 3/Screen Name</th>
                    </tr>
                </table>
            
                <div name ="divTable" id ="divTable" >
                    <table border="1" cols="4" cellspacing="0" cellpadding="0" width="100%"  class ="bgndTable" id="tblAssignedDtls" bordercolor="white" >
                        <% i=0; %>
                        <logic:iterate name="frmSA_ScreenEmpMap" id="DynamicMenuBean" property="assignedList">
                        <% int j=++i; %>
                        <tr>
                            <td width="6%"><html:checkbox property="chkDel" /><%=j%></td>
                            <td width="32%"><bean:write name="DynamicMenuBean" property="level1" /></td>
                            <td width="32%"><bean:write name="DynamicMenuBean" property="level2" />&nbsp;&nbsp;</td>
                            <td width="28%"><bean:write name="DynamicMenuBean" property="level3" />&nbsp;&nbsp;</td>
                            <html:hidden property="hdnCheck" name="DynamicMenuBean" />
                            <html:hidden property="hdnScreenId" name="DynamicMenuBean" />
							<html:hidden property="hdnAudScreenId" name="DynamicMenuBean" />
                        </tr>
                        </logic:iterate>
                    </table>
                </div>
            </logic:greaterThan>
            
            <br>
            <div align="center">
                <html:button accesskey="S" value="Save" styleClass="butto" onclick="if(mandatory_Check(frmSA_ScreenEmpMap)){lfnSave();}" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnSubmit"/> 
                <html:button accesskey="C" value="Reset" styleClass="butto" onclick="setHidden('Reset');" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnCancel"/> 
            </div>
        </html:form>
    </body>
</html:html>

<script>

function lfnOnLoad()
{
	if(frmSA_ScreenEmpMap.txtEmpNo.value==0)
        frmSA_ScreenEmpMap.txtEmpNo.value="";

    //for getting the focus to the next enterable field
    var value=frmSA_ScreenEmpMap.hdnFocus.value;
    if(value!="")
        eval("frmSA_ScreenEmpMap."+ value + ".focus()");
    else
        frmSA_ScreenEmpMap.txtEmpNo.focus();

    if(frmSA_ScreenEmpMap.hdnAction.value=="")
        setHidden("OnLoad");       
}

function lfnSave()
{
    var oTable=document.getElementById("tblScreenDtls");
    var iTR=oTable.rows.length;
    var flag=0;
    for(i=0;i<iTR;i++)
    {
        if(document.getElementsByName("chkSelect")[i].checked)
        {
            flag=flag+1;
            document.getElementsByName("hdnCheck")[i].value="y";
        }
    }
    //for going to get the Id's of the Delted Screen Id
    if(frmSA_ScreenEmpMap.hdnDelCnt.value>0)
         frmSA_ScreenEmpMap.hdnDelCnt.value=lfnDelCnt(iTR);

    //to check how many checkboxes are selected
    if((flag==0)&&(frmSA_ScreenEmpMap.hdnDelCnt.value==0))
        alert("Select Screen to Assign/Delete to the User");
    else
    {
		
        frmSA_ScreenEmpMap.hdnScreenCnt.value=flag;
        setHidden("Save");
    }
}

function lfnDelCnt(cnt)
{
    var delCnt=0;
    var oTable=document.getElementById("tblAssignedDtls");
    var iTR=oTable.rows.length;
   
    for(i=0;i<iTR;i++)
    {
        if(document.getElementsByName("chkDel")[i].checked)
        {
            delCnt=delCnt+1;
            document.getElementsByName("hdnCheck")[i+cnt].value="d";
        }
    }
    return delCnt;
}

function setHidden(value)
{
	if(value!='Save')
	{
		var oTable=document.getElementById("tblScreenDtls");
		var iTR=oTable.rows.length;
	   
		for(i=0;i<iTR;i++)
		{
			document.getElementsByName("chkSelect")[i].checked="";
		}
	}
    frmSA_ScreenEmpMap.hdnAction.value=value;
    frmSA_ScreenEmpMap.submit();  
}

</script>
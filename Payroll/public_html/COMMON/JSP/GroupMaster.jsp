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

    <style>
        #divTable 
        {
            overflow: auto;
            left: 22.5%;
            top: 150px;
            width: 100%;
            height:154px;
        }
    </style>
    
    <body onload="lfnLoad();" scroll="no" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
        <html:form name="frmGroupMaster" method="post" action="/GroupMaster" type="FCIPAY.COMMON.WEBTIER.Form.GroupMasterForm">

            <bean:define name="frmGroupMaster" id="moduleList" property="moduleList" />
            
            <html:hidden property="hdnAction" />
            <html:hidden property="hdnGrpCnt" />
            
            <br><br>
            <table width="100%" border="0">
                <tr>
                    <td colspan="2" align="center"><b class="MainHeader">Group Master</b></td>
                </tr>
                <tr>
                    <td width="50%" align="left"><i><font color="red">*</font>Mandatory Fields</i></td>
                    <td width="50%" align="left"><div align="right"></div></td>
                </tr>
            </table>
      
            <html:errors />

            <table border="1" cellpadding="0" cellspacing="0" width="100%" class="bgndTable" bordercolor="white">
                <tr height="47%">
                    <td width="15%">Group Short Desc :</td>
                    <td width="35%"><html:text property="txtGrpSDesc" size="40" maxlength="45" styleClass="required" /></td>
                    <td width="15%">Description :</td>
                    <td width="35%"><html:text property="txtDesc" size="40" maxlength="45" styleClass="required" /></td>
                </tr>

                <tr>
                    <td width="15%">Module Name :</td>
                    <td width="35%">
                        <html:select property="lstModule" styleClass="required" style="width:200">
                            <html:option value="">Please Select</html:option>
                            <html:options collection="moduleList" property="idString" labelProperty="code" />
                        </html:select>
                    </td>
                    <td width="15%">Status :</td>
                    <td width="35%">
                        <html:select property="lstStatus" styleClass="required" style="width:130">
                            <html:option value="A">Active</html:option>
                            <html:option value="I">InActive</html:option>
                        </html:select>
                    </td>
                </tr>
            </table>

            <!--table border="1" cellspacing="0" cellpadding="0" width="100%" class="bgndTable" bordercolor="white">
                <tr>                
                    <td width="13%" class="labelText" >Group Short Desc :<i><font color="red">*</font></i></td>
                    <td width="15%"><html:text property="txtGrpSDesc" size="25" maxlength="45" styleClass="required" /><td>
                    <td width="10%" class="labelText" >Description :<i><font color="red">*</font></i></td>
                    <td width="25%"><html:text property="txtDesc" size="35" maxlength="45" styleClass="required" /></td>
                    <td width="10%" class="labelText" >Module Name :<i><font color="red">*</font></i></td>
                    <td width="13%">
                        <html:select property="lstStatus" styleClass="required" style="width:130">
                            <html:option value="A">Active</html:option>
                            <html:option value="I">InActive</html:option>
                        </html:select>
                    </td>
                    <td width="7%" class="labelText" >Status :<i><font color="red">*</font></i></td>
                    <td width="8%">
                        <html:select property="lstStatus" styleClass="required">
                            <html:option value="A">Active</html:option>
                            <html:option value="I">InActive</html:option>
                        </html:select>
                    </td>
                </tr>
            </table-->
            <br>
            
            <logic:greaterThan name="frmGroupMaster" property="hdnGrpCnt" value="0">

                <div align="right">
                    <html:button value="ReplaceRow" styleClass="butto" onclick="lfnReplaceRow();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnReplaceRow"/> 
                    <html:button value="ResetRow" styleClass="butto" onclick="lfnResetRow();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnResetRow"/> 
                </div>

                <div id="sty">
                    <b class="SubHeader"><center>Group Details</center></b>
                </div>
            
                <table border="1" cols="4" cellspacing="0" cellpadding="0" width="98%" class="bgndTable" bordercolor="white">
                    <tr>
                        <th width="5%">Sel</th>
                        <th width="30%">Group SDesc</th>
                        <th width="35%">Description</th>
                        <th width="14%">Module Name</th>
                        <th width="14%">Status</th>
                    </tr>
                </table>

                <div name ="divTable" id ="divTable" >
                    <table border="1" cols="4" cellspacing="0" cellpadding="0" width="100%"  class ="bgndTable" id="tblScreenDtls" bordercolor="white" >
                        <% int i=0; %>
                        <logic:iterate name="frmGroupMaster" property="grpList" id="DynamicMenuBean">
                        <% int j=++i; %>
                        <tr>
                            <td width="5%"><html:radio property="radSelect" value="<%=String.valueOf(j)%>" onclick="lfnOnClick(this.value);" /><%=String.valueOf(j)%></td>
                            <td width="30%"><html:text name="DynamicMenuBean" size="40" property="grpSDesc" /></td>
                            <td width="35%"><html:text name="DynamicMenuBean" size="50" property="desc" /></td>
                            <td width="14%"><html:text name="DynamicMenuBean" size="18" property="modName" /></td>
                            <td width="14%">
                                <logic:equal name="DynamicMenuBean" property="grpStatus" value="I">
                                    <html:text property="txtStatus" size="17" value="InActive" />
                                </logic:equal>
                                <logic:equal name="DynamicMenuBean" property="grpStatus" value="A">
                                    <html:text property="txtStatus" size="17" value="Active" />
                                </logic:equal>
                            </td>
                            <html:hidden property="modId" name="DynamicMenuBean" />
                        </tr>
                        </logic:iterate>
                    </table>
                </div>
            </logic:greaterThan>

            <br>
            <div align="center">
                <html:button accesskey="S" value="Save" styleClass="butto" onclick="if(mandatory_Check(frmGroupMaster)){setHidden('Save');}" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnSave"/> 
                <html:button accesskey="C" value="Reset" styleClass="butto" onclick="setHidden('Reset');" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnReset"/> 
            </div>
        </html:form>
    </body>
</html:html>

<script>
function lfnLoad()
{
    flag=0;
    if(frmGroupMaster.hdnAction.value=="")
    {
        frmGroupMaster.hdnAction.value="OnLoad";
        frmGroupMaster.submit();
    }
    for(i=0;i<frmGroupMaster.radSelect.length;i++)
    {
        if(frmGroupMaster.radSelect[i].checked)
            flag=1;
    }
    if(flag==0)
    {
        frmGroupMaster.btnReplaceRow.disabled=true;
        frmGroupMaster.btnResetRow.disabled=true;        
    }
    else
    {
        frmGroupMaster.btnReplaceRow.disabled=false;
        frmGroupMaster.btnResetRow.disabled=false;
    }
}


function lfnOnClick(radVal)
{
    radVal=radVal-1;
    frmGroupMaster.txtGrpSDesc.value=document.getElementsByName("grpSDesc")[radVal].value;
    frmGroupMaster.txtDesc.value=document.getElementsByName("desc")[radVal].value;
    frmGroupMaster.lstModule.value=document.getElementsByName("modId")[radVal].value;
    if(document.getElementsByName("txtStatus")[radVal].value=="Active")
        frmGroupMaster.lstStatus.value="A";
    else
        frmGroupMaster.lstStatus.value="I";

    frmGroupMaster.txtGrpSDesc.readOnly=true;
    frmGroupMaster.txtDesc.readOnly=true;
    frmGroupMaster.lstModule.disabled=true;

    frmGroupMaster.btnReplaceRow.disabled=false;
    frmGroupMaster.btnResetRow.disabled=false;
    frmGroupMaster.btnSave.disabled=true;
    frmGroupMaster.btnReset.disabled=true;
}


function lfnReplaceRow()
{
    if(mandatory_Check(frmGroupMaster))
    {
        frmGroupMaster.btnSave.disabled=false;
        frmGroupMaster.btnReset.disabled=false;

        frmGroupMaster.hdnAction.value="ReplaceRow";
        frmGroupMaster.submit();
    }
}

function lfnResetRow()
{
    frmGroupMaster.txtGrpSDesc.value="";
    frmGroupMaster.txtDesc.value="";
    frmGroupMaster.lstStatus.value="A";
    
    frmGroupMaster.btnReplaceRow.disabled=true;
    frmGroupMaster.btnResetRow.disabled=true;

    frmGroupMaster.btnSave.disabled=false;
    frmGroupMaster.btnReset.disabled=false;

    frmGroupMaster.txtGrpSDesc.readOnly=false;
    frmGroupMaster.txtDesc.readOnly=false;

    for(i=0;i<frmGroupMaster.radSelect.length;i++)
        frmGroupMaster.radSelect[i].checked=false;
}

function setHidden(value)
{
    frmGroupMaster.hdnAction.value=value;
    frmGroupMaster.submit();
}

</script>


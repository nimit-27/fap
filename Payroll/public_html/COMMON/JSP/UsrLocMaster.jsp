<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html locale="true">
    <head><html:base />
        <title>User Master</title>
        <iframe ID="hiddenFrame" NAME="pri" WIDTH="0" HEIGHT="0"></iframe>
        <link rel="STYLESHEET" type="text/css" href="<html:rewrite page="/COMMON/CSS/Menucss.css" />">
        <link rel="stylesheet" type="text/css" href="<html:rewrite page="/COMMON/CSS/IBA.css" />"> 
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />"></script>
        <script type="text/javascript" language="JavaScript1.2" src="<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />"></script>
        <script type="text/javascript" language="javascript" src="<html:rewrite page="/COMMON/JavaScript/validate.js" />"></script>

        <%
            response.setHeader("cache-Control","no-store");  
            response.setHeader("cache-Control","max-age=0");
            response.setHeader("Pragma","no-cache");
        %>

        <style>
            #divTable 
            {
                overflow: auto;
                left: 22.5%;
                top: 150px;
                width: 100%;
                height:104px;
            }
            
        </style>
    </head>

    <body onload="lfnload();history.forward(1);" scroll="no" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
        <DIV ID="printReady" class="Print">
            <html:form name="frmUsrLocMaster" method="post" action="/UsrLocMast" type="FCIPAY.COMMON.WEBTIER.Form.UsrLocMastForm">
                <br>
                <bean:define name="frmUsrLocMaster" id="empList" property="empList" />
                <bean:define name="frmUsrLocMaster" id="locList" property="locList" />
                
                <html:hidden property="hdnAction"  />
                <html:hidden property="hdnRowCount" />
                <html:hidden property="hdnUsrLocId" />

                <table width="100%" border="0">
                    <tr>
                        <td colspan="2" align="center"><b class="MainHeader">User Location Master</b></td>
                    </tr>
                    <tr>
                        <td width="50%" align="left"><i><font color="red">*</font>Mandatory Fields</i></td>
                        <td width="50%" align="left"><div align="right"></div></td>
                    </tr>
                </table>
                
                <html:errors/>
                <table cellspacing="0" cellpadding="0" width="100%" class="bgndTable" border="1">
                    <caption><div id="sty" ><b class="SubHeader">User Location Details</b></div></caption>
                    <TR>
                         <TD width="12%" class="labelText"><b>Employee</b><i><font color="red">*</font></i></TD>     
                         <TD width="35%" class="labelText"><b>Name Of Employee</b><i><font color="red">*</font></i></TD>
                         <TD width="10%" class="labelText"><b>Location</b><i><font color="red">*</font></i></TD>
                         <TD width="30%" class="labelText"><b>Location Desc</b><i><font color="red">*</font></i></TD>
                         <TD width="10%" class="labelText"><b>Status</b><i><font color="red">*</font></i></TD>            
                    </tr>                        
                    <TR> 
                        <TD>
                            <html:select property="lstEmpNo" styleClass="required" onchange="if(this.value!=''){setHidden('GetEmpDtls');}" >
                                <html:option value="" >Please Select</html:option>
                                <html:options collection="empList" labelProperty="idLong" property="idLong" />
                            </html:select>
                        </TD>					    
                        <TD><html:text property="txtEmpName" size="55" readonly="true" /></TD>
                        <TD>
                            <html:select property="lstLocation" styleClass="required" style="width:100" onchange="if(this.value!=''){setHidden('GetLocDtls');}" >
                                <html:option value="" >Please Select</html:option>
                                <html:options collection="locList" labelProperty="idLong" property="idLong" />
                            </html:select>
                        </TD>			
                        <TD><html:text property="txtLocDesc" size="50" readonly="true" /></TD>
                        <TD>
                            <html:select property="lstStatus" style="width:90"> 
                                <html:option value="A" >Active</html:option>
                                <html:option value="I" >Inactive</html:option>
                            </html:select>
                        </TD>	                   
                    </TR>
                </table>

                <br>  

                <center>
                    <html:button  styleClass="butto" onmouseover="this.style.color='yellow';" accesskey="S" onclick="if(mandatory_Check(frmUsrLocMaster)){setHidden('Save');}" onmouseout="this.style.color='white';" property="btnSave" value="Save" /></TD>
                    <html:button styleClass="butto" onmouseover="this.style.color='yellow';" accesskey="R" onclick="setHidden('Reset');" onmouseout="this.style.color='white';" property = "btnReset" value="Reset" />
                </center>

                <br><br>

                <logic:greaterThan name="frmUsrLocMaster" property="hdnRowCount" value="0">
                    <div align="right">
                        <html:button value="ReplaceRow" styleClass="butto" onclick="lfnReplaceRow();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnReplaceRow"/> 
                        <html:button value="ResetRow" styleClass="butto" onclick="lfnResetRow();" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" property="btnResetRow"/> 
                    </div>

                    <table border="1" cellspacing="0" cellpadding="0" width="100%" class="bgndTable">
                        <caption><div id="sty" ><b>Query Results</b></div></caption>        
                        <tr>            
                            <td width="5%" class="labelText"><b>Sel</b></td>
                            <td width="10%" class="labelText"><b>Employee</b></td>        
                            <td width="33%" class="labelText"><b>Name of Employee</b></td>
                            <td width="7%" class="labelText"><b>Location</b></td>
                            <td width="33%" class="labelText"><b>Location Desc</b></td>
                            <td width="10%" class="labelText"><b> Status</b></td>                                   
                        </tr>
                    </table>

                    <div id="divTable" class="divTable">
                        <table border="1" cellspacing="0" cellpadding="0" width="100%" class="bgndTable">
                            <% int i=0; %>
                            <logic:iterate name="frmUsrLocMaster" property="assignedList" id="UsrLocationBean">
                                <% int j=++i; %>
                                <tr>
                                      <td width="5%"><html:radio property="radSelect" value="<%=String.valueOf(j)%>" onclick="lfnOnClick(this.value);" /><%=j%></td>
                                      <td width="10%"><html:text property="empNo" name="UsrLocationBean" size="10" readonly="true" /></td>                  
                                      <td width="33%"><html:text property="empName" name="UsrLocationBean" size="50" readonly="true" /></td>      
                                      <td width="7%"><html:text property="locCode" name="UsrLocationBean" size="5" readonly="true" /></td>      
                                      <td width="33%"><html:text property="locDesc" name="UsrLocationBean" size="50" readonly="true" /></td>                        
                                      <td width="10%">
                                            <logic:equal name="UsrLocationBean" property="status" value="I">
                                                <html:text property="txtStatus" size="17" value="InActive" />
                                            </logic:equal>
                                            <logic:equal name="UsrLocationBean" property="status" value="A">
                                                <html:text property="txtStatus" size="17" value="Active" />
                                            </logic:equal>
                                      </td>          
                                      <html:hidden property="hdnId" name="UsrLocationBean" />
                                 </tr>
                            </logic:iterate>
                        </table>
                    </div>
                </logic:greaterThan>
            </html:form>
        </DIV>
    </body>
</html:html>

<SCRIPT>

    function lfnload()
    {    
        flag=0;
        
        if(frmUsrLocMaster.hdnAction.value=="")
            setHidden("OnLoad");  

        if(frmUsrLocMaster.hdnRowCount.value>0)
        {
            for(i=0;i<frmUsrLocMaster.radSelect.length;i++)
            {
                if(frmUsrLocMaster.radSelect[i].checked)
                    flag=1;
            }
            if(flag==1)
            {
                frmUsrLocMaster.btnSave.disabled=true;
                frmUsrLocMaster.lstEmpNo.disabled=true;
                frmUsrLocMaster.lstLocation.disabled=true;

                frmUsrLocMaster.btnReplaceRow.disabled=false;
                frmUsrLocMaster.btnResetRow.disabled=false;
            }
            else
            {
                frmUsrLocMaster.btnSave.disabled=false;
                frmUsrLocMaster.lstEmpNo.disabled=false;
                frmUsrLocMaster.lstLocation.disabled=false;

                frmUsrLocMaster.btnReplaceRow.disabled=true;
                frmUsrLocMaster.btnResetRow.disabled=true;
            }
        }        
    }

    function lfnOnClick(val)
    {
        val=val-1;
        //For Assigning the Elements from the detail to the Master Row
        frmUsrLocMaster.lstEmpNo.value=document.getElementsByName("empNo")[val].value;
        frmUsrLocMaster.txtEmpName.value=document.getElementsByName("empName")[val].value;
        frmUsrLocMaster.lstLocation.value=document.getElementsByName("locCode")[val].value;
        frmUsrLocMaster.txtLocDesc.value=document.getElementsByName("locDesc")[val].value;        
        if(document.getElementsByName("txtStatus")[val].value=="Active")
            frmUsrLocMaster.lstStatus.value="A";
        else
            frmUsrLocMaster.lstStatus.value="I";

        //For Disabling the Buttons and the combo boxes
        frmUsrLocMaster.btnSave.disabled=true;
        frmUsrLocMaster.lstEmpNo.disabled=true;
        frmUsrLocMaster.lstLocation.disabled=true;

        frmUsrLocMaster.btnReplaceRow.disabled=false;
        frmUsrLocMaster.btnResetRow.disabled=false;
    }



    function lfnReplaceRow()
    {
        j=0
        frmUsrLocMaster.hdnUsrLocId.value=0;
        if(frmUsrLocMaster.radSelect.length)
        {
          for(i=0;i<frmUsrLocMaster.radSelect.length;i++)
          {
              if(frmUsrLocMaster.radSelect[i].checked)
              {
                  frmUsrLocMaster.hdnUsrLocId.value=document.getElementsByName("hdnId")[i].value;
                  break;
              }
          }
        }
        else
        {
          if(frmUsrLocMaster.radSelect.checked)
          {
            frmUsrLocMaster.hdnUsrLocId.value=document.getElementsByName("hdnId")[0].value;
          }
        }
        if(frmUsrLocMaster.hdnUsrLocId.value!=0)
            setHidden("ReplaceRow");
    }


    function lfnResetRow()
    {
        frmUsrLocMaster.lstEmpNo.value="";
        frmUsrLocMaster.txtEmpName.value="";
        frmUsrLocMaster.lstLocation.value="";
        frmUsrLocMaster.txtLocDesc.value="";
        frmUsrLocMaster.lstStatus.value="A";

        for(i=0;i<frmUsrLocMaster.radSelect.length;i++)
            frmUsrLocMaster.radSelect[i].checked=false;

        frmUsrLocMaster.btnSave.disabled=false;
        frmUsrLocMaster.lstEmpNo.disabled=false;
        frmUsrLocMaster.lstLocation.disabled=false;

        frmUsrLocMaster.btnReplaceRow.disabled=true;
        frmUsrLocMaster.btnResetRow.disabled=true;
    }

    function setHidden(val)
    {
        frmUsrLocMaster.hdnAction.value=val;
        frmUsrLocMaster.submit();
    }
</SCRIPT>
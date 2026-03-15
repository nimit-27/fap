<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
	<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>

</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintDPSWrkSlip" name="frmMaintWrkSlip" type="FCIPAY.Payroll.Labour.WEBTIER.Form.MaintWrkSlipForm" scope="session">
<bean:define id="ParentForm" name="frmMaintWrkSlip" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN WORKSLIP DETAILS FOR DPS LABOURS</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
   <TR>
    <TD>
    
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=2>Header For Maintain Workslip Details</TD>
        </TR>
        <TR>
              <TD colspan=11 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
		 <tr>
  
            <td class="labelText">Gang No</td>
            <td>
			<html:text property="hdnGangId" styleClass="required" readonly="true" />&nbsp;
            <logic:equal name="frmMaintWrkSlip" property="screenMode" value="U" >
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang"  >
			<!--html:text  property="txtSite" maxlength="10" styleClass="locked" readonly="true" /-->  <!--added by dushyant on 10-03-2011-->
            </logic:equal>

            <logic:notEqual name="frmMaintWrkSlip" property="screenMode" value="U" >
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
			<!--html:text  property="txtSite" maxlength="10" styleClass="locked" readonly="true" /-->  <!--added by dushyant on 10-03-2011-->
            </logic:notEqual>
			&nbsp;
            <html:text  property="txtGangName" maxlength="10" size="26" styleClass="required" readonly="true" onchange="getOperations()" />
            <html:hidden property="hdnMou" />
			&nbsp;
			<html:text  property="txtSite" maxlength="10" styleClass="locked" readonly="true" />
            </td>

			<td class="labelText">WorkSlip Date</td>
            <td>
				<html:text property="txtWrkSlipDt" alt="txtWrkSlipDt" size="26" readonly="true" styleClass="required" onchange="clearEmpList()" />
               
               <logic:notEqual name="frmMaintWrkSlip" property="screenMode" value="U" >
                <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" onclick="showCalendar('txtWrkSlipDt',this)" />
               </logic:notEqual>
            </td>
        </tr>
        <tr>
		   <logic:equal name="frmMaintWrkSlip" property="screenMode" value="Q" >
				<td class="labelText">Year Month</td>
				<td><html:text property="txtYYMM" styleClass="optional" maxlength="6" /> </td>
		   </logic:equal>
		   <logic:equal name="frmMaintWrkSlip" property="screenMode" value="U" >
				<td class="labelText">Year Month</td>
				<td><html:text property="txtYYMM" styleClass="optional" maxlength="6" readonly="true" /> </td>
		   </logic:equal>
		   <logic:equal name="frmMaintWrkSlip" property="screenMode" value="N" >
			<td class="labelText"></td>
				<td><html:hidden property="txtYYMM" /> </td>
		   </logic:equal>
     </tr>
	 <tr height="10">		    
		<TD colspan="2" > </TD>
     </tr>
   	 </table>
    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText >Work Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" border="0"></td>

                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                </tr> 
  <TR height=10>
                   <!-- Detail table Container starts -->
                    <TD colspan=11>
                      <TABLE cellSpacing=0 cellPadding=0 border=0>
                        <TBODY>
                          <TR>
                           <TD >
                            <DIV id=divDtlTable style="height:500px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail" border=0>
                                <TBODY>
                                  <TR height="22">
									  <td class=tableHeader width="1%"><html:checkbox property="selectAll" disabled="false"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
									  <TD class=tableHeader width="6%">Bag Weight</TD>
									  <TD class=tableHeader width="55%">Type of Work</TD>
									  <TD class=tableHeader width="5%">No of Bags</td> 
									  <TD class=tableHeader width="5%">Cont. Work Check</td>
									  <TD class=tableHeader width="6%">Start Time (HH:MM)</td>
									  <TD class=tableHeader width="6%">End Time (HH:MM)</td>
									  <TD class=tableHeader >List of Employees</td> 
                                  </tr> 
                             <logic:iterate id="wrkInfo" name="frmMaintWrkSlip" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.MaintWrkSlipBean" >
                              <% ++i; %>
                               <logic:notEqual name="wrkInfo" property="status" value="D" >  
                                   <tr>
                                      <logic:equal property="status" name="wrkInfo" value="N">
										  <td align="center" width="1%">
											<html:checkbox property="checked"  onclick="checkRecord();" value="false" name="frmMaintWrkSlip" />
										  </td>
										  <td > 
												<html:select property="txtBagTyp" name="wrkInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);chkDuplicate(this.alt)" >
													<html:option value="B">Below 66 Kg</html:option>
													<html:option value="A">Above 66 Kg</html:option>
												</html:select>
										  </td>
										  <td width="55%">
										 		<html:select property="hdnHndlngNormId" name="wrkInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt);chkDuplicate(this.alt)" style="width: 100%;" >
													<html:option value="" >-----Please Select-----</html:option>      
													<logic:present name="DPSOperation">
													  <html:optionsCollection label="label" value="value" property="operationList" name="DPSOperation" />
													</logic:present>
												</html:select>
										  </td>
										  <td>
												<html:text property="txtBags" name="wrkInfo" size="5" styleClass="required" style="text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  />
										  </td>
										   <td align="center"  >
											   <logic:equal name="wrkInfo" property="hdnContWork" value="Y" >
												    <input type="checkbox" name="chkContWork" checked="checked" onclick="checkContWork(this.alt);" onchange="changed(this.alt)" alt="<%=String.valueOf(i)%>">
													<html:hidden property="hdnContWork" name="wrkInfo"  alt="<%=String.valueOf(i)%>" />
											   </logic:equal>
											   <logic:notEqual name="wrkInfo" property="hdnContWork" value="Y">
													<input type="checkbox" name="chkContWork" onclick="checkContWork(this.alt);" onchange="changed(this.alt)" alt="<%=String.valueOf(i)%>">
													<html:hidden property="hdnContWork" name="wrkInfo"  alt="<%=String.valueOf(i)%>" />
											   </logic:notEqual>
										   </td>
										  <td>
												<html:text property="txtStartHrs" name="wrkInfo"  styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;" /><b>&nbsp;:</b> 
												<html:text property="txtStartMin" name="wrkInfo"  styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;" />
										  </td>
										  <td>
												<html:text property="txtEndHrs" name="wrkInfo"  styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;" /><b>&nbsp;:</b> 
												<html:text property="txtEndMin" name="wrkInfo"  styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;" />
										  </td>
										  <td>
											   <html:textarea property="txtEmpList" cols="" rows="1" name="wrkInfo" styleClass="required" readonly="true" style="width:155px;text-align:left" alt="<%=String.valueOf(i)%>" onchange="setEmpLIst(this.alt); changed(this.alt)" />
											   <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtEmp" alt="<%=String.valueOf(i)%>" onclick="return ShowEmp(this.alt);" >
											   <html:hidden property="txtEmpNameList" name="wrkInfo" />
										  </td>
                                      </logic:equal>
                                      <logic:notEqual property="status" name="wrkInfo" value="N">
										  <td align="center" width="1%">
											<html:checkbox property="checked"  onclick="checkRecord();" value="false" name="frmMaintWrkSlip" />
										  </td>
										  <td > 
												<html:select property="txtBagTyp" name="wrkInfo" styleClass="required" disabled="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);chkDuplicate(this.alt)" >
													<html:option value="B">Below 66 Kg</html:option>
													<html:option value="A">Above 66 Kg</html:option>
												</html:select>
										  </td>
										  <td width="55%">
										 		<html:select property="hdnHndlngNormId" name="wrkInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt);chkDuplicate(this.alt)" style="width: 100%;" >
													<html:option value="" >-----Please Select-----</html:option>      
													<logic:present name="DPSOperation">
													  <html:optionsCollection label="label" value="value" property="operationList" name="DPSOperation" />
													</logic:present>
												</html:select>
										  </td>
										  <td>
												<html:text property="txtBags" name="wrkInfo" size="5" readonly="true" styleClass="required" style="text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  />
										  </td>
										   <td align="center"  >
											   <logic:equal name="wrkInfo" property="hdnContWork" value="Y" >
												    <input type="checkbox" name="chkContWork" checked="checked" onclick="checkContWork(this.alt);" onchange="changed(this.alt)" alt="<%=String.valueOf(i)%>">
													<html:hidden property="hdnContWork" name="wrkInfo"  alt="<%=String.valueOf(i)%>" />
											   </logic:equal>
											   <logic:notEqual name="wrkInfo" property="hdnContWork" value="Y">
													<input type="checkbox" name="chkContWork" onclick="checkContWork(this.alt);" onchange="changed(this.alt)" alt="<%=String.valueOf(i)%>">
													<html:hidden property="hdnContWork" name="wrkInfo"  alt="<%=String.valueOf(i)%>" />
											   </logic:notEqual>
										   </td>
										  <td>
												<html:text property="txtStartHrs" name="wrkInfo" readonly="true" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onblur="return checkTime(this.alt)" /><b>&nbsp;:</b> 
												<html:text property="txtStartMin" name="wrkInfo" readonly="true" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onblur="return checkTime(this.alt)" />
										  </td>
										  <td>
												<html:text property="txtEndHrs" name="wrkInfo" readonly="true" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onblur="return checkTime(this.alt)" /><b>&nbsp;:</b> 
												<html:text property="txtEndMin" name="wrkInfo" readonly="true" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onblur="return checkTime(this.alt)" />
										  </td>
										  <td>
											   <html:textarea property="txtEmpList" cols="" rows="1" name="wrkInfo" styleClass="required" readonly="true" style="width:155px;text-align:left" alt="<%=String.valueOf(i)%>" onchange="setEmpLIst(this.alt); changed(this.alt)" />
											   <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtEmp" alt="<%=String.valueOf(i)%>" onclick="return ShowEmp(this.alt);" >
											   <html:hidden property="txtEmpNameList" name="wrkInfo" />
										  </td>
                                       </logic:notEqual>

                                       <html:hidden property="txtOTHrs" name="wrkInfo" />
                                       <html:hidden property="txtNormTyp" name="wrkInfo" />
									   <html:hidden property="hdnHndlngNormUnit" name="wrkInfo" />
                                       <html:hidden property="txtSlab" name="wrkInfo" />
                                       <html:hidden property="hdnSlabId" name="wrkInfo" />
									   <html:hidden property="txtOTHrs" name="wrkInfo"  />
									   <html:hidden property="hdnWrkSlipDtlId" name="wrkInfo" />
									   <html:hidden property="itemChecked" name="wrkInfo" />
									   <html:hidden property="status" name="wrkInfo" />
									   <html:hidden property="detailId" name="wrkInfo" value="Default"/>
                                </tr>
                                </logic:notEqual>
                                <logic:equal name="wrkInfo" property="status" value="D" >
                                   <tr>
                                       <td><html:hidden property="checked" name="frmMaintWrkSlip" value="notchecked" /></td>                                      
                                       <td><html:hidden property="txtNormTyp" name="wrkInfo" /></td>
                                       <html:hidden property="hdnHndlngNormId" name="wrkInfo"  />
                                       <html:hidden property="hdnHndlngNormUnit" name="wrkInfo" />
                                       <td><html:hidden property="txtSlab" name="wrkInfo" /></td> 
                                       <html:hidden property="hdnSlabId" name="wrkInfo" alt="<%=String.valueOf(i)%>" />
                                       <td><html:hidden property="txtBags" name="wrkInfo" /></td>
                                       <html:hidden property="txtStartHrs" name="wrkInfo" />
                                       <html:hidden property="txtStartMin" name="wrkInfo" />
                                       <html:hidden property="txtEndHrs" name="wrkInfo" />
                                       <html:hidden property="txtEndMin" name="wrkInfo" />
                                       <td><html:hidden property="txtOTHrs" name="wrkInfo" /></td>
                                       <html:hidden property="txtEmpNameList" name="wrkInfo" />
                                       <html:hidden property="txtEmpList" name="wrkInfo" />
                                       <html:hidden property="hdnWrkSlipDtlId" name="wrkInfo" />
                                       <html:hidden property="itemChecked" name="wrkInfo" />                                   
                                       <html:hidden property="status" name="wrkInfo" />
                                       <html:hidden property="detailId" name="wrkInfo" value="Default"/>
                                       <html:hidden property="txtBagTyp" name="wrkInfo" />
									   <html:hidden property="chkContWork" name="wrkInfo" />
									   <html:hidden property="hdnContWork" name="wrkInfo" />
                                    </tr>
                                  </logic:equal>                                    
                           </logic:iterate>
                                 </TBODY>
                                </TABLE>

							 </DIV>
                           </TD>
                          </TR>                               
              <!-- Get details starts -->
                            <tr>
                              <td colspan=11>	
                                <TABLE border=0>
                                  <TBODY>
                                  <TR> <TD>
                                    <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" /></TD>
                                  </TR>
                                </TBODY>
                              </TABLE>
                             </TD>
                            </tr>
                          
                          </TBODY>
                        </TABLE>
                      </td>
                    </tr>
                  </TABLE>
                </td>
	            </tr>
                <!-- Tab Table Ends -->

                <!-- Bottom Blue Bar -->
              <TR>
                     <td align=center bgcolor=#4682b4 width="40%"></td>
                     <td bgColor=#4682b4><html:button property="reportButton" styleClass="bottomBarText" value="Generate Report" onclick="doGetReport()"  /></td>
                     <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
             </TR>
	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>


<!-- Container Table Ends -->

<html:hidden name="frmMaintWrkSlip"  property="screenMode"  />
<html:hidden name="frmMaintWrkSlip"  property="screenName" value="DPSWrkSlipScreen" />
<html:hidden name="frmMaintWrkSlip"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintWrkSlip"  />
<html:hidden property="buttonFlag" name="frmMaintWrkSlip"  />
<html:hidden property="userPageRequested" name="frmMaintWrkSlip" />
<html:hidden property="pageRequested" name="frmMaintWrkSlip" />
<html:hidden name="frmMaintWrkSlip"  property="loginLocCode"  />

<html:hidden property="lovKey" name="frmMaintWrkSlip"  />
<html:hidden property="txtFields" name="frmMaintWrkSlip"  />   
<html:hidden property="txtSearchFields" name="frmMaintWrkSlip"  />
<html:hidden property="txtDisplayFields" name="frmMaintWrkSlip"  />
<html:hidden property="txtIndex" name="frmMaintWrkSlip"  />
<html:hidden property="txtInputField" name="frmMaintWrkSlip"  />
<html:hidden property="headerDataChanged" name="frmMaintWrkSlip"  />
<html:hidden property="headerPrimaryKey" name="frmMaintWrkSlip"  />
<html:hidden property="positionRequested" name="frmMaintWrkSlip" />
<html:hidden property="userPositionRequested" name="frmMaintWrkSlip" />  
<!-- <html:hidden property="txtSite" name="frmMaintWrkSlip" />  --added by dushaynt on 10-03-2011-->
<input type="hidden" name="queryParam" />
<input type="hidden" name="multipleFlag" />
<input type="hidden" id="submitParam" name="submitParam" /> 

</html:form>
</body>
</html:html>

<script language="javascript">
var chkMes =0;

function doGetReport()
{  
    if(frmMaintWrkSlip.hdnGangId.value=="")
    {
      alert("Please enter Gang");
      return false;
    }
    if(frmMaintWrkSlip.txtYYMM.value=="" && frmMaintWrkSlip.txtWrkSlipDt.value=="")
    {
      alert("Please enter either Year Month or WorkSlip Date");
      return false;
    }
    
	var winurl="lbr_workslip_report.rdf&gang_id="+frmMaintWrkSlip.hdnGangId.value+"&workslip_date="+frmMaintWrkSlip.txtWrkSlipDt.value+"&wrkslip_yyyymm="+frmMaintWrkSlip.txtYYMM.value+"&lbr=DPS";
	document.getElementById('reportButton').value="Please wait. File is being downloaded..";
	document.getElementById('reportButton').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.frmMaintWrkSlip.action="../../../ReportLinkerAction.do";
	document.frmMaintWrkSlip.submit();
}


function lfnLoad()
{
  mode=document.all.screenMode.value;
  //alert(mode)
    frmMaintWrkSlip.butGetDetail.disabled="true";
    frmMaintWrkSlip.butInsert.disabled="true";
    frmMaintWrkSlip.butDelete.disabled="true";
     if(mode=='')
      {
        doQueryMode();
      }
 
    if (frmMaintWrkSlip.screenMode.value == 'U')
    { 
	  frmMaintWrkSlip.butGetDetail.disabled="";
	  frmMaintWrkSlip.butInsert.disabled="";
	  frmMaintWrkSlip.butDelete.disabled="";
	  populateFieldsUpdate();
	  setTime();//added by swapnendu 
    }
    if (frmMaintWrkSlip.screenMode.value == 'N')
    {
        populateFieldsNew();
        frmMaintWrkSlip.butInsert.disabled="";
        if(document.all.buttonFlag.value=="D") setTime();
    }

  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  if(iTr2 >= 1)
  {
	  addTitleAttributes();
  }

  menuHandling(mode);

}

function clearEmpList()
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value!='D')
		{
			document.getElementsByName("txtEmpList")[i].value = "";
		}
	}
}

function setEmpLIst(index)
{
	var oTable = document.getElementById("Detail");
	var iTr2 = oTable.rows.length;
	var i = 0;
	var empList = document.getElementsByName("txtEmpList")[index-1].value;
	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value!='D')
		{
			if(document.getElementsByName("txtEmpList")[i].value == "")
			{
				document.getElementsByName("txtEmpList")[i].value = empList;
			}
		}
	}
}

function addTitleAttributes()
{ 
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
	return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;

	for(i=0; i < iTr2 -1; i++)
	{
		if(document.getElementsByName("status")[i].value!='D')
		{
			if(document.getElementsByName("hdnHndlngNormId")[i])
			{
				numOptions = document.getElementsByName("hdnHndlngNormId")[i].options.length;   
				for (var j = 0; j < numOptions; j++)
				{
					document.getElementsByName("hdnHndlngNormId")[i].options[j].title =
						document.getElementsByName("hdnHndlngNormId")[i].options[j].text;
					
				}
			}
		}
	}
}

function getOperations()
{
	var site_id = frmMaintWrkSlip.loginLocCode.value;
    document.forms[0].action = "../../../WrkSlipOprationCombo.do";
    document.forms[0].submit();

}

function populateFieldsNew()
{
	var oTable = document.getElementById("Detail");
    var iTr2 = oTable.rows.length;
	
	if(oTable == null)
	{
		return;
	}
	iTr2 = iTr2-1;
	if(frmMaintWrkSlip.buttonFlag.value == 'D') //add row button clicked.
	{
		if(iTr2 > 1)
		{
			//document.getElementsByName("hdnHndlngNormId")[iTr2-1].selectedIndex = document.getElementsByName("hdnHndlngNormId")[0].selectedIndex;
			document.getElementsByName("txtEmpList")[iTr2-1].value = document.getElementsByName("txtEmpList")[0].value;
		}
		else if(iTr2 = 1)
		{
			document.getElementsByName("txtStartHrs")[0].value = "10";
			document.getElementsByName("txtStartMin")[0].value = "00";
			document.getElementsByName("txtEndHrs")[0].value =  "17";
			document.getElementsByName("txtEndMin")[0].value = "30";
		}
	}
}

function populateFieldsUpdate()
{
	var oTable = document.getElementById("Detail");
    var iTr2 = oTable.rows.length;
	
	if(oTable == null)
	{
		return;
	}
	iTr2 = iTr2-1;
	if(frmMaintWrkSlip.buttonFlag.value == 'D') //add row button clicked.
	{
		if(iTr2 > 1)
		{
			//document.getElementsByName("hdnHndlngNormId")[iTr2-1].selectedIndex = document.getElementsByName("hdnHndlngNormId")[0].selectedIndex;
			document.getElementsByName("txtEmpList")[iTr2-1].value = document.getElementsByName("txtEmpList")[0].value;
		}
	}
}

function checkTime(rowno) //added by swapnendu Dt 07 Jun 2011
{
	chkDuplicate(rowno);
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var endTM = document.getElementsByName("txtEndHrs")[rowno-1].value;
	var startTM = document.getElementsByName("txtStartHrs")[rowno-1].value;
	var endMNT = document.getElementsByName("txtEndMin")[rowno-1].value;
	var startMNT = document.getElementsByName("txtStartMin")[rowno-1].value;
	if(document.getElementsByName("hdnContWork")[rowno-1].value!='Y')
	{
		if(startTM == '0' || startTM == '00' || startTM > 24)
		{
			alert("Please enter valid start hour.");
			document.getElementsByName("txtStartHrs")[rowno-1].value="";
			document.getElementsByName("txtStartHrs")[rowno-1].focus();
			return;
		}
		if(startMNT == "0" || startMNT > 60)
		{
			alert("Please enter valid start minute.");
			document.getElementsByName("txtStartMin")[rowno-1].value="";
			document.getElementsByName("txtStartMin")[rowno-1].focus();
			return;
		}
		if(endTM == "0" || endTM == "00" || endTM > 24)
		{
			alert("Please enter valid end hour.");
			document.getElementsByName("txtEndHrs")[rowno-1].value="";
			document.getElementsByName("txtEndHrs")[rowno-1].focus();
			return;
		}
		if(startMNT == "0" || endMNT > 60)
		{
			alert("Please enter valid end minute.");
			document.getElementsByName("txtEndMin")[rowno-1].value="";
			document.getElementsByName("txtEndMin")[rowno-1].focus();
			return;
		}
		if(startTM == endTM)
		{
			if(endMNT==startMNT)
			{
				alert("End time can not be same as Start time");
				document.getElementsByName("txtEndMin")[rowno-1].value="";
				document.getElementsByName("txtEndHrs")[rowno-1].value="";
				document.getElementsByName("txtEndHrs")[rowno-1].focus();
				return;
			}
		}
		if(endTM != "")
		{
			if((eval(endTM) - eval(startTM)) >= 0)
			{
				if(rowno==1) setTime();
				return true;
			}
			else
			{
				alert("Invalid time entry. End time must be greater than Start time. Please ensure that you are using 24 hour time format (i.e HH24)");
				document.getElementsByName("txtEndMin")[rowno-1].value = "";
				document.getElementsByName("txtEndHrs")[rowno-1].select();
				return false;
			}
		}
	}
	else
	{
		if(startTM == '0' || startTM == '00' || startTM > 24)
		{
			alert("Please enter valid start hour.");
			document.getElementsByName("txtStartHrs")[rowno-1].value="";
			document.getElementsByName("txtStartHrs")[rowno-1].focus();
			return;
		}
		if(startMNT == "0" || startMNT > 60)
		{
			alert("Please enter valid start minute.");
			document.getElementsByName("txtStartMin")[rowno-1].value="";
			document.getElementsByName("txtStartMin")[rowno-1].focus();
			return;
		}
		if(endTM == "0" || endTM == "00" || endTM > 24)
		{
			alert("Please enter valid end hour.");
			document.getElementsByName("txtEndHrs")[rowno-1].value="";
			document.getElementsByName("txtEndHrs")[rowno-1].focus();
			return;
		}
		if(startMNT == "0" || endMNT > 60)
		{
			alert("Please enter valid end minute.");
			document.getElementsByName("txtEndMin")[rowno-1].value="";
			document.getElementsByName("txtEndMin")[rowno-1].focus();
			return;
		}
		if(endTM != "")
		{
			if((eval(endTM) - eval(startTM)) >= 0)
			{
				alert("Invalid time entry. End time can not exceed Start time");
				document.getElementsByName("txtEndMin")[rowno-1].value = "";
				document.getElementsByName("txtEndHrs")[rowno-1].select();
				return false;
			}
		}
	}
}

function setTime()
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	if (iTr2 > 2)
	{
		var startHr = document.getElementsByName("txtStartHrs")[0].value;
		var endHr = document.getElementsByName("txtEndHrs")[0].value;
		var startMnt = document.getElementsByName("txtStartMin")[0].value;
		var endMnt = document.getElementsByName("txtEndMin")[0].value;
		for(i=1; i < iTr2 -1; i++)
		{
			if (document.getElementsByName("status")[i].value != 'D')
			{
				if (document.getElementsByName("status")[i].value == 'N')
				{
					document.getElementsByName("txtStartHrs")[i].value = startHr;
					document.getElementsByName("txtEndHrs")[i].value = endHr;
					document.getElementsByName("txtStartMin")[i].value = startMnt;
					document.getElementsByName("txtEndMin")[i].value = endMnt;
				}
			}
		}
	}
}

function changed(val)
{ 
  frmMaintWrkSlip.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
    document.getElementsByName("status")[val-1].value = 'U';
}


function doGetNextHeader()
{   
    document.all.buttonFlag.value='';
    frmMaintWrkSlip.userPositionRequested.value = 1*frmMaintWrkSlip.positionRequested.value + 1;
    document.forms[0].action="../../../WrkSlipDPSGetNextHeader.do";
    document.forms[0].submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmMaintWrkSlip.userPositionRequested.value = 1*frmMaintWrkSlip.positionRequested.value - 1;
    document.forms[0].action="../../../WrkSlipDPSGetNextHeader.do";
    document.forms[0].submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmMaintWrkSlip.userPositionRequested.value = 1*frmMaintWrkSlip.newPositionRequested.value;
    document.forms[0].action="../../../WrkSlipDPSGetNextHeader.do";
    document.forms[0].submit();
}

function doBasePrevDetail()
{
    frmMaintWrkSlip.userPageRequested.value = 1*frmMaintWrkSlip.pageRequested.value - 1;
    frmMaintWrkSlip.action = "../../../WrkSlipDPSNextDetailAction.do";
    frmMaintWrkSlip.submit();
}

function doBaseNextDetail()
{
    frmMaintWrkSlip.userPageRequested.value = 1*frmMaintWrkSlip.pageRequested.value + 1;
    frmMaintWrkSlip.action = "../../../WrkSlipDPSNextDetailAction.do";
    frmMaintWrkSlip.submit();
}

function JumpDetail()
{
    frmMaintWrkSlip.userPageRequested.value = 1*frmMaintWrkSlip.newPageRequested.value;
    frmMaintWrkSlip.action = "../../../WrkSlipDPSNextDetailAction.do";
    frmMaintWrkSlip.submit();
}
function doBaseAddRow()
{
  EnableFields();
  
  if(mandatory_Check("frmMaintWrkSlip") && checkMandatory())
  {
    document.all.buttonFlag.value='D';
    frmMaintWrkSlip.headerPrimaryKey.disabled="";
    document.forms[0].action = "../../../WrkSlipDPSAddRowAction.do";
    document.forms[0].submit();
  }
  else
  {
      return false;
  }
}


function doBaseDelRow()
{
  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;


   var flag = 0;
   for(i=0; i < iTr2 -1; i++)
    {
        if(document.getElementsByName("checked")[i].checked)
        {
            flag=flag+1;
        }
    }  
    if ( flag == 0)
    {
        alert("Please check the rows to be deleted");
        return false;
    }
       
  for(i=0; i < iTr2 -1; i++)
  {

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintWrkSlip.detailDataChanged.value = "true";   
      document.all.buttonFlag.value='D';
    }

  }
  EnableFields();
  frmMaintWrkSlip.headerPrimaryKey.disabled="";
  document.forms[0].action = "../../../WrkSlipDPSDeleteRowAction.do";
  document.forms[0].submit();  
}



function GetDetail()
{
   document.all.buttonFlag.value='';
 // frmMaintWrkSlip.flagAll.value="true";
  frmMaintWrkSlip.headerPrimaryKey.value=frmMaintWrkSlip.headerPrimaryKey.value;
  document.all.screenMode.value='U';
  frmMaintWrkSlip.headerPrimaryKey.disabled="";
  frmMaintWrkSlip.action="../../../WrkSlipDPSGetDetailAction.do"
  frmMaintWrkSlip.submit();
}

function DelRecord()
{
  var oTable = document.getElementById("Detail");
  var iTr2 = oTable.rows.length;
  document.all.screenMode.value='D';
  document.all.buttonFlag.value='';
  frmMaintWrkSlip.headerPrimaryKey.value=frmMaintWrkSlip.headerPrimaryKey.value;
  frmMaintWrkSlip.headerFields.value = "false";
  document.all.headerDataChanged.value='true';
  frmMaintWrkSlip.totalDetailRecord.value = parseInt(iTr2,10) - 1;
  frmMaintWrkSlip.action = "../../../WrkSlipDPSDelRecordAction.do";
  frmMaintWrkSlip.submit();
}

function SaveRecord()
{
  EnableFields();   
 
  if(! mandatory_Check("frmMaintWrkSlip"))
  {    
    return false;     
  }
  if(checkMandatory())
  {
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    if(iTr2<2)
    {
      alert("Please Add at Least one row");
      return false;
    }
    var i = 0;  
    
    for(i=0; i < iTr2 -2; i++)
    {
        if (document.getElementsByName("status")[i].value == 'D')
          frmMaintWrkSlip.detailDataChanged.value = "true";
    }
    document.all.buttonFlag.value='';
    frmMaintWrkSlip.headerPrimaryKey.value=frmMaintWrkSlip.headerPrimaryKey.value;
    frmMaintWrkSlip.headerFields.value = "true";
    if ( document.all.screenMode.value == "N")
        document.all.headerDataChanged.value='true';
    frmMaintWrkSlip.totalDetailRecord.value = parseInt(iTr2,10) - 1;
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmMaintWrkSlip.action = "../../../WrkSlipDPSSaveAction.do";
    frmMaintWrkSlip.submit();
    }
    else
    {
      return false;
    }
}

function doInsertMode()
{
  if ( document.all.screenMode.value == "Q")
      document.all.headerDataChanged.value='';
      
  document.all.buttonFlag.value='';
  frmMaintWrkSlip.action="../../../WrkSlipDPSNewMode.do"
  frmMaintWrkSlip.submit();

}

function doQueryMode()
{
  document.all.buttonFlag.value='';
 //frmMaintWrkSlip.headerPrimaryKey.value="";
 
 //frmMaintWrkSlip.butInsert.disabled="true";
 //frmMaintWrkSlip.butDelete.disabled="true";
 frmMaintWrkSlip.action="../../../WrkSlipDPSQueryMode.do"
 frmMaintWrkSlip.submit();
document.all.butGetDetail.disabled="true";
}

function doRefresh()
{  
    frmMaintWrkSlip.action = "../../../WrkSlipDPSRefresh.do";
    frmMaintWrkSlip.submit();
}

function ShowSite()
{
   frmMaintWrkSlip.lovKey.value = "SiteId" + frmMaintWrkSlip.screenName.value + "Q";
   frmMaintWrkSlip.txtDisplayFields.value = "txtSiteId,txtSiteName";
   frmMaintWrkSlip.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   frmMaintWrkSlip.txtIndex.value="";
   frmMaintWrkSlip.txtInputField.value="";
   frmMaintWrkSlip.multipleFlag.value = "";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintWrkSlip');
   return true;
}

function ShowLovGang()
{
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      if(iTr2 > 1)
      {
        alert("you are not allowed to change the gang after adding atleast one workslip.");
        return false;
      }
      else
	  {
			frmMaintWrkSlip.queryParam.value="txtSiteID="+ frmMaintWrkSlip.loginLocCode.value +",txtLbrTyp=DPS" ;    
			frmMaintWrkSlip.lovKey.value = "GangList" + frmMaintWrkSlip.screenName.value + "Q";
			frmMaintWrkSlip.txtDisplayFields.value = "hdnGangId,txtGangName,hdnMou,txtSite";
			frmMaintWrkSlip.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
			frmMaintWrkSlip.txtIndex.value="";
			frmMaintWrkSlip.txtInputField.value="txtGangName";
			frmMaintWrkSlip.multipleFlag.value = "";
			showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintWrkSlip');
			return true;
	  }
}

function ShowSlab(i)
{
  if(document.getElementsByName("txtNormTyp")[i-1].value!='OT_ABOVE' && document.getElementsByName("txtNormTyp")[i-1].value!='ABOVE')
  {
     frmMaintWrkSlip.queryParam.value="txtMou="+ frmMaintWrkSlip.hdnMou.value +" ,txtNormTyp= "+document.getElementsByName("txtNormTyp")[i-1].value+",txtBagTyp="+document.getElementByName("txtBagTyp")[i-1].value ;    
     frmMaintWrkSlip.lovKey.value = "WrkSlipNormSlab" + frmMaintWrkSlip.screenName.value + frmMaintWrkSlip.screenMode.value;
     frmMaintWrkSlip.txtDisplayFields.value = "hdnSlabId,txtSlab";
     frmMaintWrkSlip.txtIndex.value=i-1;
     frmMaintWrkSlip.txtSearchFields.value = "";
     frmMaintWrkSlip.txtInputField.value="";
     frmMaintWrkSlip.multipleFlag.value = "";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintWrkSlip');
     return true;
  }
   return false;
}

function ShowHandlingNorm(i)
{
   frmMaintWrkSlip.queryParam.value="txtSiteID="+ frmMaintWrkSlip.loginLocCode.value;    
   frmMaintWrkSlip.lovKey.value = "WrkSlipHndlngNorm" + frmMaintWrkSlip.screenName.value + frmMaintWrkSlip.screenMode.value;
   frmMaintWrkSlip.txtDisplayFields.value = "hdnHndlngNormId,txtHndlngNorm";
   frmMaintWrkSlip.txtIndex.value=i-1;
   frmMaintWrkSlip.txtSearchFields.value = "";
   frmMaintWrkSlip.txtInputField.value="txtHndlngNorm";
   frmMaintWrkSlip.multipleFlag.value = "";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintWrkSlip');
   return true;
}

function ShowEmp(i)
{
   //  <!--norm type start  uncomment by dushyant on 11-feb-2011--> 
	if(document.getElementsByName("txtEndHrs")[i-1].value=='' || document.getElementsByName("txtEndMin")[i-1].value=='')
     {
      alert("Please enter the end time first");
      return false;
     }
   // <!--norm type end  uncomment by dushyant on 11-feb-2011-->

     frmMaintWrkSlip.queryParam.value="hdnGangId="+ frmMaintWrkSlip.hdnGangId.value+",txtWrkSlipDt="+frmMaintWrkSlip.txtWrkSlipDt.value+",txtEndHrs= "+document.getElementsByName("txtEndHrs")[i-1].value+",txtEndMin= "+document.getElementsByName("txtEndMin")[i-1].value;    
     frmMaintWrkSlip.lovKey.value = "WrkSlipEmpList" + frmMaintWrkSlip.screenName.value + frmMaintWrkSlip.screenMode.value;
     frmMaintWrkSlip.txtDisplayFields.value = "txtEmpList";
     frmMaintWrkSlip.txtIndex.value=i-1;
     frmMaintWrkSlip.txtSearchFields.value = "";
     frmMaintWrkSlip.multipleFlag.value = "true";
     frmMaintWrkSlip.txtInputField.value = "txtEmpList";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintWrkSlip');
     return true;
}
    
function doSetFields(arrList,arrLength,arrCols)
{
  var arrEmpNo=new Array();
   var arrEmpName=new Array();
 // arr=arrList;
  for( i=0;i<arrList.length;i++)
  {
     arrEmpNo[i]=arrList[i][0];
     arrEmpName[i]=arrList[i][1];
  }
  var indx=frmMaintWrkSlip.txtIndex.value;
  document.getElementsByName("txtEmpList")[indx].value=arrEmpNo;
  //document.getElementsByName("txtEmpNameList")[indx].value=arrEmpName;
}
 function getHeaderRecord()
 {
   if(checkHeaderMandatory())
   {
    document.all.buttonFlag.value=''; 
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmMaintWrkSlip.action="../../../WrkSlipDPSGetHeaderAction.do";
    frmMaintWrkSlip.submit();
   }
 }
 
 function checkHeaderMandatory()
 {
    if(document.all.txtGangName.value=="")
    {
      alert("Please Select/Enter Gang ");
     // document.all.buttxtGang.setFocus();
      return false;
    }
    return true;
}

function checkNormTyp(normTyp,i)
{
  if(normTyp=='OT_ABOVE' || normTyp=='ABOVE')
  {
    document.getElementsByName("txtStartHrs")[i-1].disabled="";
    document.getElementsByName("txtStartHrs")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtStartMin")[i-1].disabled="";
    document.getElementsByName("txtStartMin")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtEndHrs")[i-1].disabled="";
    document.getElementsByName("txtEndHrs")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtEndMin")[i-1].disabled="";
    document.getElementsByName("txtEndMin")[i-1].style.background="#ffffd3";
    document.getElementsByName("buttxtEmp")[i-1].disabled="";
    document.getElementsByName("txtEmpList")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtEmpList")[i-1].style.className="required";
    document.getElementsByName("txtSlab")[i-1].style.background="#ffffff";
    document.getElementsByName("txtSlab")[i-1].style.className="locked";
  }
  else
  {
    document.getElementsByName("txtStartHrs")[i-1].disabled="true";
    document.getElementsByName("txtStartHrs")[i-1].style.background="#ffffff";
    document.getElementsByName("txtStartMin")[i-1].disabled="true";
    document.getElementsByName("txtStartMin")[i-1].style.background="#ffffff";
    document.getElementsByName("txtEndHrs")[i-1].disabled="true";
    document.getElementsByName("txtEndHrs")[i-1].style.background="#ffffff";
    document.getElementsByName("txtEndMin")[i-1].disabled="true";
    document.getElementsByName("txtEndMin")[i-1].style.background="#ffffff";
    document.getElementsByName("buttxtEmp")[i-1].disabled="true";
    document.getElementsByName("txtEmpList")[i-1].style.background="#ffffff";
    document.getElementsByName("txtEmpList")[i-1].style.className="locked";
    document.getElementsByName("txtSlab")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtSlab")[i-1].style.className="required";
  }

}

function EnableFields()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("status")[i].value!=='D')
    {
     document.getElementsByName("txtStartHrs")[i].disabled=""; 
     document.getElementsByName("txtStartMin")[i].disabled=""; 
     document.getElementsByName("txtEndHrs")[i].disabled=""; 
     document.getElementsByName("txtEndMin")[i].disabled=""; 
	 document.getElementsByName("txtBagTyp")[i].disabled=""; 
    }
  }

}

function checkMandatoryNorm()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
     document.getElementsByName("txtOTHrs")[i].disabled=""; 
  }

}

function checkMandatory()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
	 if(document.getElementsByName("status")[i].value!='D')
	 {
		 if(document.getElementsByName("txtEmpList")[i].value=='')
		 {
		  alert("Mandatory Field Empty");
		  return false;
		 }
	 }
  } 
  return true;
}
/*
function checkTime(i)
{
 // alert(i)
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;

     var Starttime = 0;
     var Endtime = 0;
	 Starttime= document.getElementsByName("txtStartHrs")[i].value +document.getElementsByName("txtStartMin")[i].value;
     Endtime= document.getElementsByName("txtEndHrs")[i].value +document.getElementsByName("txtEndMin")[i].value;

     if(eval(Starttime) > eval(Endtime))
	  {
       alert ("End Time must be greater than Start Time");
	   document.getElementsByName("txtEndHrs")[i].value='';
	   document.getElementsByName("txtEndMin")[i].value='';
	   document.getElementsByName("txtEndHrs")[i].focus();
       return false;
	  }

return true;
}
*/
function chkDuplicate(indx) //also called from checkTime().
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
	var opr,bags,startHr,startMnt,bagWt;
	opr = document.getElementsByName("hdnHndlngNormId")[indx-1].value;
	bags = document.getElementsByName("txtBags")[indx-1].value;
	startHr = document.getElementsByName("txtStartHrs")[indx-1].value;
	startMnt = document.getElementsByName("txtStartMin")[indx-1].value;
	endHr = document.getElementsByName("txtEndHrs")[indx-1].value;
	endMnt = document.getElementsByName("txtEndMin")[indx-1].value;
	bagWt = document.getElementsByName("txtBagTyp")[indx-1].value;
	//alert("opr="+opr+",startHr="+startHr+",startMnt="+startMnt+",endHr="+endHr+",endMnt="+endMnt);
    var iTr2 = oTable.rows.length;
    var i = 0;
    for(i=0; i < iTr2 -1; i++)
    {
		var flag=0;
		if((indx-1) != i)
		{
			if(document.getElementsByName("status")[i].value!='D')
			{
				opr1 = document.getElementsByName("hdnHndlngNormId")[i].value;
				bags1 = document.getElementsByName("txtBags")[i].value;
				startHr1 = document.getElementsByName("txtStartHrs")[i].value;
				startMnt1 = document.getElementsByName("txtStartMin")[i].value;
				endHr1 = document.getElementsByName("txtEndHrs")[i].value;
				endMnt1 = document.getElementsByName("txtEndMin")[i].value;
				bagWt1 = document.getElementsByName("txtBagTyp")[i].value;
				//alert("opr1="+opr1+",startHr1="+startHr1+",startMnt1="+startMnt1+",endHr1="+endHr1+",endMnt1="+endMnt1);
				
				if(opr==opr1 && bagWt==bagWt1)
				{
					if(startHr==startHr1 || endHr==endHr1)
					{
						if(((startMnt1 >= startMnt) && (startMnt1 <= endMnt)) || ((endMnt1 >= startMnt) && (endMnt1 <= endMnt)))
						{
							flag=1;
						}
					}
					else if(((startHr > startHr1) && (startHr < endHr1)) || ((endHr > startHr1) && (endHr < endHr1)))
					{
    					flag=2;
					}
					else if(endHr==startHr1)
					{
						if(endMnt > startMnt1)
						{
							flag=3;
						}
					}
					else if(startHr==endHr1)
					{
						if(startMnt < endMnt1)
						{
							flag=4;
						}
					}
				}
			}
		}
		if(flag!=0)
		{
			alert("Duplicate entry is not allowed. Please check if Same Combination of Operation and Time Frame is already entered.");
			document.getElementsByName("hdnHndlngNormId")[indx-1].selectedIndex=0;
			return false;
		}
	}
	return true;
}

function checkContWork(indx)
{
	if(document.getElementsByName("chkContWork")[indx-1].checked)
	{
		document.getElementsByName("hdnContWork")[indx-1].value='Y'
	}
	else
	{
		document.getElementsByName("hdnContWork")[indx-1].value='';
	}

	document.getElementsByName("txtStartHrs")[indx-1].value = "";
	document.getElementsByName("txtEndHrs")[indx-1].value = "";
	document.getElementsByName("txtStartMin")[indx-1].value = "";
	document.getElementsByName("txtEndMin")[indx-1].value = "";
}

</script>
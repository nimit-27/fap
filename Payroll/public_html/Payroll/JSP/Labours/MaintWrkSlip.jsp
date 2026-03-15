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
<BODY onbeforeunload="confWindowClose()" onunload="handleOnClose()" onload="lfnLoad();history.forward(1);" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintWrkSlip" name="frmMaintWrkSlip" type="FCIPAY.Payroll.Labour.WEBTIER.Form.MaintWrkSlipForm" scope="session">
<bean:define id="ParentForm" name="frmMaintWrkSlip" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN WORKSLIP DETAILS FOR DEPT. LABOUR</TD>
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
			<html:text property="hdnGangId" styleClass="required"  maxlength="6" onchange="checkgang()" 
			onkeypress="if((event.keyCode < 48 || event.keyCode > 57))
						{                     
						  return false;
						};" />&nbsp;
            <logic:equal name="frmMaintWrkSlip" property="screenMode" value="U" >
	            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang"  >
            </logic:equal>
            <logic:notEqual name="frmMaintWrkSlip" property="screenMode" value="U" >
		        <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
            </logic:notEqual>
			&nbsp;
            <html:text  property="txtGangName" maxlength="10" size="26" styleClass="locked" readonly="true"  />
            &nbsp;
			<html:text  property="txtSite" maxlength="10" styleClass="locked" readonly="true" />
            <html:hidden property="hdnMou" />
            </td>

			<td class="labelText">WorkSlip Date</td>
            <td>
				<html:text property="txtWrkSlipDt" alt="txtWrkSlipDt" size="26" readonly="true" styleClass="required" onchange="clearEmpList()" />
               
               <logic:notEqual name="frmMaintWrkSlip" property="screenMode" value="U" >
                <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" onclick="enableCalendar() && showCalendar('txtWrkSlipDt',this)" />
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
                              <TABLE cellSpacing=0 cellPadding=0 border="0" id="Detail">
                                <TBODY>
                                  <TR height="22">
                                    <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                    <TD class=tableHeader width="3%">Bag Weight</TD>
                                    <TD class=tableHeader width="30%">Type of Work</TD>
                                    <TD class=tableHeader width="5%">Bag Type</TD>
                                    <TD class=tableHeader width="9%">Norm Type</td>
                                    <TD class=tableHeader width="7%">Slab </td>
                                    <TD class=tableHeader width="4%">No of Bags</td>
									<TD class=tableHeader width="4%">Cont. Work Check</td>
                                    <TD class=tableHeader width="7%">Start Time (HH:MM)</td>
                                    <TD class=tableHeader width="7%">End Time (HH:MM)</td>
                                    <TD class=tableHeader width="25%">List of Employees</td>
                                  </tr> 
                             <logic:iterate id="wrkInfo" name="frmMaintWrkSlip" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.MaintWrkSlipBean" >
                              <% ++i; %>
                               <logic:notEqual name="wrkInfo" property="status" value="D" >  
                                   <tr>
                                      <td><html:checkbox property="checked"  onclick="checkRecord();" value="false" name="frmMaintWrkSlip" /></td>

									  <logic:equal name="wrkInfo" property="status" value="N" >
										  <td>
												<html:select property="txtBagTyp" name="wrkInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="chkDuplicate(this.alt);return changed(this.alt)" >
													<html:option value="B">Below 66 Kg</html:option>
													<html:option value="A">Above 66 Kg</html:option>
												</html:select>
										  </td>
										   <td>
												<html:select property="hdnHndlngNormId" name="wrkInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="chkDuplicate(this.alt);changed(this.alt); return chkNoOfBags(this.alt)" style="WIDTH: 100%"  >
													<html:option value="" >-----Please Select-----</html:option>      
													<logic:present name="NormTyp">
													  <html:optionsCollection label="label" value="value" property="operationList" name="NormTyp" />
													</logic:present>
												</html:select>
										   </td>
										   <td>
												<html:select property="hdnHndlngNormUnit" name="wrkInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="mandateNorm(this.alt);changed(this.alt)"  style="WIDTH: 100%"  >
												   <html:option value="BAG">BAG</html:option>
												   <html:option value="BAILE">BAILE</html:option>
												   <html:option value="CRATE">CRATE</html:option>
												</html:select>
										   </td>
										   <td>
												<html:select property="txtNormTyp" name="wrkInfo" title="Norm Type"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="checkNormTyp(this.alt); setTimeOnLoad(this.alt); chkDuplicate(this.alt); changed(this.alt)"  style="WIDTH: 100%"  >
													<html:option value="" >-----Please Select-----</html:option>      
													<logic:present name="NormTyp">
													<html:optionsCollection label="label" value="value" property="normTypList" name="NormTyp" />
													</logic:present>
												</html:select>
										   </td>
										   <td align="center"><html:text property="txtSlab" name="wrkInfo" styleClass="required" readonly="true"  style="width:60%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="chkDuplicate(this.alt); return changed(this.alt)"  />
										   <html:hidden property="hdnSlabId" name="wrkInfo" alt="<%=String.valueOf(i)%>" />
										   <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSlab" alt="<%=String.valueOf(i)%>" onclick="return ShowSlab(this.alt);" >
										   </td>
										   <td align="center"><html:text property="txtBags" name="wrkInfo" size="5" styleClass="required" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onblur="chkNoOfBags(this.alt)" onchange="return changed(this.alt)"  onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;"/>
										   </td>
										   <td align="center">
											   <logic:equal name="wrkInfo" property="hdnContWork" value="Y" >
												    <input type="checkbox" name="chkContWork" checked="checked" onclick="checkContWork(this.alt);" onchange="changed(this.alt)" alt="<%=String.valueOf(i)%>">
													<html:hidden property="hdnContWork" name="wrkInfo"  alt="<%=String.valueOf(i)%>" />
											   </logic:equal>
											   <logic:notEqual name="wrkInfo" property="hdnContWork" value="Y">
													<input type="checkbox" name="chkContWork" onclick="checkContWork(this.alt);" onchange="changed(this.alt)" alt="<%=String.valueOf(i)%>">
													<html:hidden property="hdnContWork" name="wrkInfo"  alt="<%=String.valueOf(i)%>" />
											   </logic:notEqual>
										   </td>
										   <td><html:text property="txtStartHrs" name="wrkInfo" maxlength="2" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;"  /><b>&nbsp;:</b> 
												<html:text property="txtStartMin" name="wrkInfo" maxlength="2" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;"  />
										   </td>
										   <td><html:text property="txtEndHrs" name="wrkInfo" maxlength="2" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;"  /><b>&nbsp;:</b> 
												<html:text property="txtEndMin" name="wrkInfo" maxlength="2" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;"  />
										   </td>
										   <td>
										   <html:textarea property="txtEmpList" cols="" rows="1" name="wrkInfo" styleClass="required" readonly="true" style="width: 230px; text-align:left" alt="<%=String.valueOf(i)%>" onchange="setEmpLIst(this.alt); changed(this.alt)" />
										   <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtEmp" alt="<%=String.valueOf(i)%>" onclick="return ShowEmp(this.alt);" >
										   <html:hidden property="txtEmpNameList" name="wrkInfo" />
										   </td>
									  </logic:equal>
									  <logic:notEqual name="wrkInfo" property="status" value="N">
										  <td>
												<html:select property="txtBagTyp" name="wrkInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="chkDuplicate(this.alt);return changed(this.alt)" >
													<html:option value="B">Below 66 Kg</html:option>
													<html:option value="A">Above 66 Kg</html:option>
												</html:select>
										  </td>
										   <td>
												<html:select property="hdnHndlngNormId" name="wrkInfo" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="chkDuplicate(this.alt); changed(this.alt); return chkNoOfBags(this.alt)" style="WIDTH: 100%"  >
													<html:option value="" >-----Please Select-----</html:option>      
													<logic:present name="NormTyp">
													  <html:optionsCollection label="label" value="value" property="operationList" name="NormTyp" />
													</logic:present>
												</html:select>
										   </td>
										   <td>
												<html:select property="hdnHndlngNormUnit" name="wrkInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="mandateNorm(this.alt);changed(this.alt)"  style="WIDTH: 100%"  >
												   <html:option value="BAG">BAG</html:option>
												   <html:option value="BAILE">BAILE</html:option>
												   <html:option value="CRATE">CRATE</html:option>
												</html:select>
										   </td>
										   <td>
												<html:select property="txtNormTyp" name="wrkInfo"  title="Norm Type"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="checkNormTyp(this.alt); setTimeOnLoad(this.alt); chkDuplicate(this.alt); changed(this.alt)"  style="WIDTH: 100%"  >
													<html:option value="" >-----Please Select-----</html:option>      
													<logic:present name="NormTyp">
													<html:optionsCollection label="label" value="value" property="normTypList" name="NormTyp" />
													</logic:present>
												</html:select>
										   </td>
										   <td align="center"><html:text property="txtSlab" name="wrkInfo" readonly="true" styleClass="required"  style="width:60%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="chkDuplicate(this.alt); return changed(this.alt)"  />
										   <html:hidden property="hdnSlabId" name="wrkInfo" alt="<%=String.valueOf(i)%>" />
										   <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSlab" alt="<%=String.valueOf(i)%>" onclick="return ShowSlab(this.alt);" >
										   </td>
										   <td align="center"><html:text property="txtBags" name="wrkInfo" size="5" styleClass="required" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onblur="chkNoOfBags(this.alt) " onchange="return changed(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;" />
										   </td>
										   <td align="center">
											   <logic:equal name="wrkInfo" property="hdnContWork" value="Y" >
												    <input type="checkbox" name="chkContWork" checked="checked" onclick="checkContWork(this.alt);" onchange="changed(this.alt)" alt="<%=String.valueOf(i)%>">
													<html:hidden property="hdnContWork" name="wrkInfo"  alt="<%=String.valueOf(i)%>" />
											   </logic:equal>
											   <logic:notEqual name="wrkInfo" property="hdnContWork" value="Y">
													<input type="checkbox" name="chkContWork" onclick="checkContWork(this.alt);" onchange="changed(this.alt)" alt="<%=String.valueOf(i)%>">
													<html:hidden property="hdnContWork" name="wrkInfo"  alt="<%=String.valueOf(i)%>" />
											   </logic:notEqual>
										   </td>
										   <td><html:text property="txtStartHrs" name="wrkInfo" maxlength="2" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;"  /><b>&nbsp;:</b> 
												<html:text property="txtStartMin" name="wrkInfo" maxlength="2" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;"  />
										   </td>
										   <td><html:text property="txtEndHrs" name="wrkInfo" maxlength="2" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;"  /><b>&nbsp;:</b> 
												<html:text property="txtEndMin" name="wrkInfo" maxlength="2" styleClass="required" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" onblur="return checkTime(this.alt)" onkeypress="
												   if((event.keyCode < 48 || event.keyCode > 57))
													{                     
													  return false;
													}                 
													;"  />
										   </td>
										   <td>
										   <html:textarea property="txtEmpList" cols="" rows="1" name="wrkInfo" styleClass="required" readonly="true" style="width: 230px; text-align:left" alt="<%=String.valueOf(i)%>" onchange="setEmpLIst(this.alt); changed(this.alt)" />
										   <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtEmp" alt="<%=String.valueOf(i)%>" onclick="return ShowEmp(this.alt);" >
										   <html:hidden property="txtEmpNameList" name="wrkInfo" />
										   </td>
										</logic:notEqual>

                                       <html:hidden property="txtOTHrs" name="wrkInfo" />
                                       <html:hidden property="hdnWrkSlipDtlId" name="wrkInfo" />
                                       <html:hidden property="itemChecked" name="wrkInfo" />
                                       <html:hidden property="status" name="wrkInfo" />
                                       <html:hidden property="detailId" name="wrkInfo" value="Default"/>
                                </tr>
                                </logic:notEqual>
                                <logic:equal name="wrkInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintWrkSlip" value="notchecked" /></td>                                      
                                       <td ><html:hidden property="txtNormTyp" name="wrkInfo" /></td>
                                      
                                       <html:hidden property="hdnHndlngNormId" name="wrkInfo"  />
                                       <html:hidden property="hdnHndlngNormUnit" name="wrkInfo" />
                                       <td ><html:hidden property="txtSlab" name="wrkInfo" /></td> 
                                       <html:hidden property="hdnSlabId" name="wrkInfo" />
                                       <td ><html:hidden property="txtBags" name="wrkInfo" /></td>
                                       <html:hidden property="txtStartHrs" name="wrkInfo" />
                                       <html:hidden property="txtEndHrs" name="wrkInfo" />
                                       <html:hidden property="txtStartMin" name="wrkInfo" />
                                       <html:hidden property="txtEndMin" name="wrkInfo" />
                                       <td ><html:hidden property="txtOTHrs" name="wrkInfo" /></td>
                                       <html:hidden property="txtEmpNameList" name="wrkInfo" />
                                       <html:hidden property="txtEmpList" name="wrkInfo" />
                                       <html:hidden property="hdnWrkSlipDtlId" name="wrkInfo" />
									   <html:hidden property="txtBagTyp" name="wrkInfo" />
                                       <html:hidden property="itemChecked" name="wrkInfo" />                                   
                                       <html:hidden property="status" name="wrkInfo" />
                                       <html:hidden property="detailId" name="wrkInfo" value="Default"/>
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
<html:hidden name="frmMaintWrkSlip"  property="screenName" value="WrkSlipScreen" />
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
	var winurl="lbr_workslip_report.rdf&gang_id="+frmMaintWrkSlip.hdnGangId.value+"&workslip_date="+frmMaintWrkSlip.txtWrkSlipDt.value+"&wrkslip_yyyymm="+frmMaintWrkSlip.txtYYMM.value+"&lbr=DEP";
	document.getElementById('reportButton').value="Please wait. File is being downloaded..";
	document.getElementById('reportButton').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.frmMaintWrkSlip.action="../../../ReportLinkerAction.do";
	document.frmMaintWrkSlip.submit();
}

  
function lfnLoad()
{
    mode=document.all.screenMode.value;
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
		populateFields();
    }

	if (frmMaintWrkSlip.screenMode.value == 'N')
    {
        frmMaintWrkSlip.butInsert.disabled="";
		populateFields();
    }
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
      //checkUnit(i+1);
      checkNormTyp(i+1);
	  checkBagTypOnLoad(i+1);
    }
  }
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

function populateFields()
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
			var lbrList = "";
			for(var i=0; i<(iTr2-1); i++)
			{
				if(document.getElementsByName("status")[i].value != 'D')
				{
					lbrList = document.getElementsByName("txtEmpList")[i].value;
				}
				if(lbrList != "")
				{
					document.getElementsByName("txtEmpList")[iTr2-1].value = lbrList;
					break;
				}
			}
		}
	}
}

function checkTime(rowno) //added by swapnendu Dt 07 Jun 2011
{
	chkDuplicate(rowno);
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
		if(endTM != "")
		{
			if((eval(endTM) - eval(startTM)) >= 0)
			{
				setTime(rowno);
				return true;
			}
			else
			{
				alert("Invalid time entry. Please ensure that you are using 24 hour time format (i.e HH24)");
				document.getElementsByName("txtEndMin")[rowno-1].value = "";
				document.getElementsByName("txtEndHrs")[rowno-1].value="";
				document.getElementsByName("txtStartHrs")[rowno-1].value="";
				document.getElementsByName("txtStartMin")[rowno-1].value="";
				document.getElementsByName("chkContWork")[rowno-1].focus()="";
				return false;
			}
		}
	}
	else
	{
		if(startTM == '0' || startTM > 24)
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
		if(endTM == "0" || endTM > 24)
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
				document.getElementsByName("txtEndHrs")[rowno-1].value = "";
				document.getElementsByName("txtEndHrs")[rowno-1].focus();
				return false;
			}
		}
	}
}

function setTime(rowno)
{
	var rowno1 = rowno;
	var startHr = document.getElementsByName("txtStartHrs")[rowno1-1].value;
	var endHr = document.getElementsByName("txtEndHrs")[rowno1-1].value;
	var startMnt = document.getElementsByName("txtStartMin")[rowno1-1].value;
	var endMnt = document.getElementsByName("txtEndMin")[rowno1-1].value;
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	if (rowno == 1)
	{
		for(i=0; i < iTr2 -1; i++)
		{
    		//if(document.getElementsByName("txtNormTyp")[i].value =='OT_ABOVE' || document.getElementsByName("txtNormTyp")[i].value=='ABOVE' || document.getElementsByName("txtNormTyp")[i].value =='HEIGHT' || document.getElementsByName("txtNormTyp")[i].value =='OT_HEIGHT')
			//{
				document.getElementsByName("txtStartHrs")[i].value = startHr;
				document.getElementsByName("txtEndHrs")[i].value = endHr;
				document.getElementsByName("txtStartMin")[i].value = startMnt;
				document.getElementsByName("txtEndMin")[i].value = endMnt;
			//}
		}
	}
}
 
function setTimeOnLoad(i)
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return false;
	}
	var iTr2 = oTable.rows.length;
	if(iTr2 > 2)
	{
		if(document.getElementsByName("hdnContWork")[i-1].value != 'Y')
		{
			if((iTr2-1)==i)
			{
				document.getElementsByName("txtStartHrs")[i-1].value = "10";
				document.getElementsByName("txtStartMin")[i-1].value = "00";
				document.getElementsByName("txtEndHrs")[i-1].value = "17";
				document.getElementsByName("txtEndMin")[i-1].value = "30";
			}
			else
			{
				document.getElementsByName("txtStartHrs")[i-1].value = document.getElementById("txtStartHrs").value;
				document.getElementsByName("txtStartMin")[i-1].value = document.getElementById("txtStartMin").value;
				document.getElementsByName("txtEndHrs")[i-1].value = document.getElementById("txtEndHrs").value;
				document.getElementsByName("txtEndMin")[i-1].value = document.getElementById("txtEndMin").value;
			}

		}
		else
		{
			document.getElementsByName("txtStartHrs")[i-1].value = "";
			document.getElementsByName("txtEndHrs")[i-1].value = "";
			document.getElementsByName("txtStartMin")[i-1].value = "";
			document.getElementsByName("txtEndMin")[i-1].value = "";
		}
	}
	if(i=="1")
	{
		if(document.getElementsByName("hdnContWork")[i-1].value!='Y')
		{
			document.getElementsByName("txtStartHrs")[i-1].value = "10";
			document.getElementsByName("txtStartMin")[i-1].value = "00";
			document.getElementsByName("txtEndHrs")[i-1].value = "17";
			document.getElementsByName("txtEndMin")[i-1].value = "30";
		}
		else
		{
			document.getElementsByName("txtStartHrs")[i-1].value = "";
			document.getElementsByName("txtEndHrs")[i-1].value = "";
			document.getElementsByName("txtStartMin")[i-1].value = "";
			document.getElementsByName("txtEndMin")[i-1].value = "";
		}
	}
	document.getElementsByName("txtSlab")[i-1].value="";
	return true;
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
    document.forms[0].action="../../../WrkSlipGetNextHeader.do";
    document.forms[0].submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmMaintWrkSlip.userPositionRequested.value = 1*frmMaintWrkSlip.positionRequested.value - 1;
    document.forms[0].action="../../../WrkSlipGetNextHeader.do";
    document.forms[0].submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmMaintWrkSlip.userPositionRequested.value = 1*frmMaintWrkSlip.newPositionRequested.value;
    document.forms[0].action="../../../WrkSlipGetNextHeader.do";
    document.forms[0].submit();
}

function doBasePrevDetail()
{
    frmMaintWrkSlip.userPageRequested.value = 1*frmMaintWrkSlip.pageRequested.value - 1;
    frmMaintWrkSlip.action = "../../../WrkSlipNextDetailAction.do";
    frmMaintWrkSlip.submit();
}

function doBaseNextDetail()
{
    frmMaintWrkSlip.userPageRequested.value = 1*frmMaintWrkSlip.pageRequested.value + 1;
    frmMaintWrkSlip.action = "../../../WrkSlipNextDetailAction.do";
    frmMaintWrkSlip.submit();
}

function JumpDetail()
{
    frmMaintWrkSlip.userPageRequested.value = 1*frmMaintWrkSlip.newPageRequested.value;
    frmMaintWrkSlip.action = "../../../WrkSlipNextDetailAction.do";
    frmMaintWrkSlip.submit();
}

function doBaseAddRow()
{
  EnableFields();
  if(mandatory_Check("frmMaintWrkSlip") && checkMandatory())
  {
  document.all.buttonFlag.value='D';
  frmMaintWrkSlip.headerPrimaryKey.disabled="";
  document.forms[0].action = "../../../WrkSlipAddRowAction.do";
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
  document.forms[0].action = "../../../WrkSlipDeleteRowAction.do";
  document.forms[0].submit();  
}

function GetDetail()
{
   document.all.buttonFlag.value='';
 // frmMaintWrkSlip.flagAll.value="true";
  frmMaintWrkSlip.headerPrimaryKey.value=frmMaintWrkSlip.headerPrimaryKey.value;
  document.all.screenMode.value='U';
  frmMaintWrkSlip.headerPrimaryKey.disabled="";
  frmMaintWrkSlip.action="../../../WrkSlipGetDetailAction.do"
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
  frmMaintWrkSlip.action = "../../../WrkSlipDelRecordAction.do";
  frmMaintWrkSlip.submit();
}

function SaveRecord()
{
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
	  //alert(iTr2)
	  if(iTr2>2)
	  {
		  for(i=0; i < iTr2 -1; i++)
		  {
	          if (document.getElementsByName("status")[i].value != 'D')
			  {
					var endTM = document.getElementsByName("txtEndHrs")[i].value;
					var startTM = document.getElementsByName("txtStartHrs")[i].value;
					var endMNT = document.getElementsByName("txtEndMin")[i].value;
					var startMNT = document.getElementsByName("txtStartMin")[i].value;
					if(startTM == "" || startTM > 24)
					{
						alert("Please enter valid start hour.");
						document.getElementsByName("txtStartHrs")[i].value="";
						document.getElementsByName("txtStartHrs")[i].focus();
						return;
					}
					if(startMNT == "" || startMNT > 60)
					{
						alert("Please enter valid start minute.");
						document.getElementsByName("txtStartMin")[i].value="";
						document.getElementsByName("txtStartMin")[i].focus();
						return;
					}
					if(endTM == "" || endTM > 24)
					{
						alert("Please enter valid end hour.");
						document.getElementsByName("txtEndHrs")[i].value="";
						document.getElementsByName("txtEndHrs")[i].focus();
						return;
					}
					if(endMNT == "" || endMNT > 60)
					{
						alert("Please enter valid end minute.");
						document.getElementsByName("txtEndMin")[i].value="";
						document.getElementsByName("txtEndMin")[i].focus();
						return;
					}
			  }
		  }
	  }

	  <!--ashish-->


var endTM1 = 0;
					var startTM1 = 100;
					var endMNT1 =0;
					var startMNT1=100;
					var abvcount1=0;
					var startindex1=0;
					var endindex1=0;


var endTM2 = 0;
					var startTM2 = 100;
					var endMNT2 =0;
					var startMNT2=100;
					var abvcount2=0;
                    var startindex2=0;
					var endindex2=0;

var endTM3 = 0;
					var startTM3 = 100;
					var endMNT3 =0;
					var startMNT3=100;
                    var abvcount3=0;
					
					var startindex3=0;
					var endindex3=0;
for (i = 0; i < iTr2 - 1; i++) {

if(document.getElementsByName("status")[i].value != 'D')
{

    if (document.getElementsByName("txtNormTyp")[i].value.match('OT_ABOVE')) {
	

       
            if (parseInt(document.getElementsByName("txtStartHrs")[i].value.toString() + document.getElementsByName("txtStartMin")[i].value.toString()) < parseInt(startTM1.toString() + startMNT1.toString())) {
                startTM1 = document.getElementsByName("txtStartHrs")[i].value;
                startMNT1 = document.getElementsByName("txtStartMin")[i].value;
				startindex1=i;
					
            }

            if (document.getElementsByName("chkContWork")[i].checked) {
                if (parseInt((parseInt(document.getElementsByName("txtEndHrs")[i].value) + 24).toString() + document.getElementsByName("txtEndMin")[i].value.toString()) >= parseInt(endTM1.toString() + endMNT1.toString())) {
                    endTM1 = (parseInt(document.getElementsByName("txtEndHrs")[i].value) + 24).toString();
                    endMNT1 = document.getElementsByName("txtEndMin")[i].value;
					endindex1=i;
                }
				

            } else {

                if (parseInt((document.getElementsByName("txtEndHrs")[i].value).toString() + document.getElementsByName("txtEndMin")[i].value.toString()) >= parseInt(endTM1.toString() + endMNT1.toString())) {
                    endTM1 = (document.getElementsByName("txtEndHrs")[i].value)
                    endMNT1 = document.getElementsByName("txtEndMin")[i].value;
					endindex1=i;
                }

            }





       
        abvcount1 = abvcount1 + 1;

    } else if (document.getElementsByName("txtNormTyp")[i].value.match('OT_LEAD'))

    {


       
            if (parseInt(document.getElementsByName("txtStartHrs")[i].value.toString() + document.getElementsByName("txtStartMin")[i].value.toString()) < parseInt(startTM2.toString() + startMNT2.toString())) {
                startTM2 = document.getElementsByName("txtStartHrs")[i].value;
                startMNT2 = document.getElementsByName("txtStartMin")[i].value;
				startindex2=i;
            }
            if (document.getElementsByName("chkContWork")[i].checked) {
                if (parseInt((parseInt(document.getElementsByName("txtEndHrs")[i].value) + 24).toString() + document.getElementsByName("txtEndMin")[i].value.toString()) >= parseInt(endTM2.toString() + endMNT2.toString())) {
                    endTM2 = (parseInt(document.getElementsByName("txtEndHrs")[i].value) + 24).toString();
                    endMNT2 = document.getElementsByName("txtEndMin")[i].value;
					endindex2=i;
                }

            } else {
                if (parseInt((document.getElementsByName("txtEndHrs")[i].value).toString() + document.getElementsByName("txtEndMin")[i].value.toString()) >= parseInt(endTM2.toString() + endMNT2.toString())) {
                    endTM2 = (document.getElementsByName("txtEndHrs")[i].value)
                    endMNT2 = document.getElementsByName("txtEndMin")[i].value;
					endindex2=i;
                }

            }





        
        abvcount2 = abvcount2 + 1;

    }

	else if (document.getElementsByName("txtNormTyp")[i].value.match('OT_HEIGHT'))

    {

    
            if (parseInt(document.getElementsByName("txtStartHrs")[i].value.toString() + document.getElementsByName("txtStartMin")[i].value.toString()) < parseInt(startTM3.toString() + startMNT3.toString())) {
                startTM3 = document.getElementsByName("txtStartHrs")[i].value;
                startMNT3 = document.getElementsByName("txtStartMin")[i].value;
				startindex3=i;
            }
            if (document.getElementsByName("chkContWork")[i].checked) {
                if (parseInt((parseInt(document.getElementsByName("txtEndHrs")[i].value) + 24).toString() + document.getElementsByName("txtEndMin")[i].value.toString()) >= parseInt(endTM3.toString() + endMNT3.toString())) {
                    endTM3 = (parseInt(document.getElementsByName("txtEndHrs")[i].value) + 24).toString();
                    endMNT3 = document.getElementsByName("txtEndMin")[i].value;
					endindex3=i;

                }

            } else {
                if (parseInt((document.getElementsByName("txtEndHrs")[i].value).toString() + document.getElementsByName("txtEndMin")[i].value.toString()) >= parseInt(endTM3.toString() + endMNT3.toString())) {
                    endTM3 = (document.getElementsByName("txtEndHrs")[i].value)
                    endMNT3 = document.getElementsByName("txtEndMin")[i].value;
					endindex3=i;

                }

            }





 
        abvcount3 = abvcount3 + 1;
		
	}
		
		}

    }
  




if(abvcount1!=0)
{
if( abvcount2!=0 &&( !(startTM1.match(startTM2)) || !(startMNT1.match(startMNT2)) ))	

{

alert('Start Time of Overtime Above('+startTM1+':'+startMNT1+') and Overtime Lead ('+startTM2+':'+startMNT2+') entry must be same.');

                document.getElementsByName("txtStartHrs")[startindex2].value="";
            
                document.getElementsByName("txtStartMin")[startindex2].value="";
			
				
					document.getElementsByName("txtStartHrs")[startindex2].focus();

return false;
}
else if( abvcount2!=0 &&(  !(endTM1.match(endTM2)) || !(endMNT1.match(endMNT2))))

{
alert('End Time of Overtime Above('+endTM1+':'+endMNT1+') and Overtime Lead ('+endTM2+':'+endMNT2+') entry must be same.');
 document.getElementsByName("txtEndHrs")[endindex2].value="";
               
                document.getElementsByName("txtEndMin")[endindex2].value="";
			
				
               document.getElementsByName("txtEndHrs")[endindex2].focus();

return false;

}
if( abvcount3!=0 &&( !(startTM1.match(startTM3)) || !(startMNT1.match(startMNT3)) ))	

{
alert('Start Time of Overtime Above('+startTM1+':'+startMNT1+') and Overtime Height ('+startTM3+':'+startMNT3+') entry must be same.');

                document.getElementsByName("txtStartHrs")[startindex3].value="";
            
                document.getElementsByName("txtStartMin")[startindex3].value="";
				 
				   document.getElementsByName("txtStartHrs")[startindex3].focus();

return false;
}
else if( abvcount3!=0 &&(  !(endTM1.match(endTM3)) || !(endMNT1.match(endMNT3))))

{
alert('End Time of Overtime Above('+endTM1+':'+endMNT1+') and Overtime Height ('+endTM3+':'+endMNT3+') entry must be same.');
 document.getElementsByName("txtEndHrs")[endindex3].value="";
               
                document.getElementsByName("txtEndMin")[endindex3].value="";
				
               
  document.getElementsByName("txtEndHrs")[endindex3].focus();
return false;

}

}
	
	

	
      var i = 0;
      
      for(i=0; i < iTr2 -2; i++)
      {
          if (document.getElementsByName("status")[i].value == 'D')
            frmMaintWrkSlip.detailDataChanged.value = "true";
      }
      
      EnableFields(); 
      document.all.buttonFlag.value='';
      frmMaintWrkSlip.headerPrimaryKey.value=frmMaintWrkSlip.headerPrimaryKey.value;
      frmMaintWrkSlip.headerFields.value = "true";
      if (document.all.screenMode.value == "N")
        document.all.headerDataChanged.value='true';
      frmMaintWrkSlip.totalDetailRecord.value = parseInt(iTr2,10) - 1;
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintWrkSlip.action = "../../../WrkSlipSaveAction.do";
      frmMaintWrkSlip.submit();
    }
    else
    {
      return false;
    }
}

function doInsertMode()
{
  if(document.all.screenMode.value == "Q")
      document.all.headerDataChanged.value='';
      
  document.all.buttonFlag.value='';
  frmMaintWrkSlip.action="../../../WrkSlipNewMode.do"
  frmMaintWrkSlip.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmMaintWrkSlip.action="../../../WrkSlipQueryMode.do"
    frmMaintWrkSlip.submit();
    document.all.butGetDetail.disabled="true";
    document.all.butDel.disabled="true";    
}


function doRefresh()
{  
    frmMaintWrkSlip.action = "../../../WrkSlipRefresh.do";
    frmMaintWrkSlip.submit();
}

function ShowSite()
{
   frmMaintWrkSlip.queryParam.value="";
   frmMaintWrkSlip.lovKey.value = "SiteId" + frmMaintWrkSlip.screenName.value + "Q";
   frmMaintWrkSlip.txtDisplayFields.value = "txtSiteId,txtSiteName";
   frmMaintWrkSlip.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   frmMaintWrkSlip.txtIndex.value="";
   frmMaintWrkSlip.multipleFlag.value = "";
   frmMaintWrkSlip.txtInputField.value = "";
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
	     frmMaintWrkSlip.queryParam.value="txtSiteID="+ frmMaintWrkSlip.loginLocCode.value +",txtLbrTyp=DEP" ;    
	     frmMaintWrkSlip.lovKey.value = "GangList" + frmMaintWrkSlip.screenName.value + "Q";
	     frmMaintWrkSlip.txtDisplayFields.value = "hdnGangId,txtGangName,hdnMou,txtSite";
	     frmMaintWrkSlip.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
	     frmMaintWrkSlip.txtIndex.value="";
	     frmMaintWrkSlip.multipleFlag.value = "";
	     frmMaintWrkSlip.txtInputField.value = "";
	     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintWrkSlip');
	     return true;
	  }
}

function enableCalendar()
{
      var oTable = document.getElementById("Detail"); 
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      if(iTr2 > 1)
      {
        alert("You are not allowed to change the WORKSLIP DATE after adding atleast one workslip.");
        return false;
      }
      else
	  {
		return true; 
	  }
}

function ShowSlab(i)
{
  if(document.getElementsByName("txtNormTyp")[i-1].value!='OT_ABOVE' && document.getElementsByName("txtNormTyp")[i-1].value!='ABOVE' && document.getElementsByName("txtNormTyp")[i-1].value!='')
  {
     frmMaintWrkSlip.queryParam.value="txtMou="+ frmMaintWrkSlip.hdnMou.value +" ,txtNormTyp= "+document.getElementsByName("txtNormTyp")[i-1].value+",txtBagTyp="+document.getElementsByName("txtBagTyp")[i-1].value ;    
     frmMaintWrkSlip.lovKey.value = "WrkSlipNormSlab" + frmMaintWrkSlip.screenName.value + frmMaintWrkSlip.screenMode.value;
     frmMaintWrkSlip.txtDisplayFields.value = "hdnSlabId,txtSlab";
     frmMaintWrkSlip.txtIndex.value=i-1;
     frmMaintWrkSlip.txtSearchFields.value = "";
     frmMaintWrkSlip.multipleFlag.value = "";
     frmMaintWrkSlip.txtInputField.value = "txtSlab";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintWrkSlip');
     return true;
  }
   return false;
}

function ShowHandlingNorm(i)
{
    frmMaintWrkSlip.queryParam.value="txtMou="+ frmMaintWrkSlip.hdnMou.value;    
    frmMaintWrkSlip.lovKey.value = "WrkSlipHndlngNorm" + frmMaintWrkSlip.screenName.value + frmMaintWrkSlip.screenMode.value;
    frmMaintWrkSlip.txtDisplayFields.value = "hdnHndlngNormId,txtHndlngNorm,hdnHndlngNormUnit";
    frmMaintWrkSlip.txtIndex.value=i-1;
    frmMaintWrkSlip.txtSearchFields.value = "";
    frmMaintWrkSlip.multipleFlag.value = "";
    frmMaintWrkSlip.txtInputField.value = "txtHndlngNorm";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintWrkSlip');
    return true;
}

function ShowEmp(i)
{
  /* if(document.getElementsByName("txtEndHrs")[i-1].value=='' || document.getElementsByName("txtEndMin")[i-1].value=='')
   {
    alert("Please enter the end time first");
    return false;
   }
   */
   frmMaintWrkSlip.queryParam.value="hdnGangId="+ frmMaintWrkSlip.hdnGangId.value+",txtWrkSlipDt="+frmMaintWrkSlip.txtWrkSlipDt.value+",txtEndHrs= "+document.getElementsByName("txtEndHrs")[i-1].value+",txtEndMin= "+document.getElementsByName("txtEndMin")[i-1].value;    
   frmMaintWrkSlip.lovKey.value = "WrkSlipEmpList" + frmMaintWrkSlip.screenName.value + frmMaintWrkSlip.screenMode.value;
   frmMaintWrkSlip.txtDisplayFields.value = "txtEmpList";
   frmMaintWrkSlip.txtIndex.value=i-1;
   frmMaintWrkSlip.txtSearchFields.value = "";
   frmMaintWrkSlip.multipleFlag.value = "true";
   frmMaintWrkSlip.txtInputField.value = "txtEmpList";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintWrkSlip');
   changed(i);
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
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmMaintWrkSlip.action="../../../WrkSlipGetHeaderAction.do";
        frmMaintWrkSlip.submit();
    }
}
 
 function checkHeaderMandatory()
 {
   // if(document.all.txtGangName.value=="")
   if(document.all.hdnGangId.value=="")   // Added by dushyant on 25-Jun-2013
    {
      alert("Please Select/Enter Gang ");
     // document.all.buttxtGang.setFocus();
      return false;
    }
    return true;
}

function mandateNorm(i) //for bag type BAG norm is mandatory or else not.
{
	var bagTyp = document.getElementsByName("hdnHndlngNormUnit")[i-1].value;
	if(bagTyp == 'BAG')
	{
		document.getElementsByName("txtNormTyp")[i-1].style.background="#ffffd3";
		document.getElementsByName("txtNormTyp")[i-1].className="required";
		document.getElementsByName("txtNormTyp")[i-1].disabled="";
	}
	else
	{
		document.getElementsByName("txtNormTyp")[i-1].style.background="#ffffff";
		document.getElementsByName("txtNormTyp")[i-1].className="locked";
		document.getElementsByName("txtNormTyp")[i-1].selectedIndex=0;
		document.getElementsByName("txtNormTyp")[i-1].disabled="true";
		document.getElementsByName("txtSlab")[i-1].style.background="#ffffff";
		document.getElementsByName("txtSlab")[i-1].className="locked";
		document.getElementsByName("txtSlab")[i-1].value="";
		document.getElementsByName("hdnSlabId")[i-1].value="";
		if((document.getElementsByName("txtStartHrs")[i-1].value)=='') document.getElementsByName("txtStartHrs")[i-1].value = "10";
		if((document.getElementsByName("txtStartMin")[i-1].value)=='') document.getElementsByName("txtStartMin")[i-1].value = "00";
		if((document.getElementsByName("txtEndHrs")[i-1].value)=='') document.getElementsByName("txtEndHrs")[i-1].value = "17";
		if((document.getElementsByName("txtEndMin")[i-1].value)=='') document.getElementsByName("txtEndMin")[i-1].value = "30";
	}
}

function checkBagTypOnLoad(i)
{
	var bagTyp = document.getElementsByName("hdnHndlngNormUnit")[i-1].value;
	if(bagTyp == 'BAILE' || bagTyp == 'CRATE')
	{
		document.getElementsByName("txtNormTyp")[i-1].style.background="#ffffff";
		document.getElementsByName("txtNormTyp")[i-1].className="locked";
		document.getElementsByName("txtNormTyp")[i-1].selectedIndex=0;
		document.getElementsByName("txtNormTyp")[i-1].disabled="true";
		document.getElementsByName("txtSlab")[i-1].style.background="#ffffff";
		document.getElementsByName("txtSlab")[i-1].className="locked";
		document.getElementsByName("txtSlab")[i-1].value="";
		document.getElementsByName("hdnSlabId")[i-1].value="";
	}
}

function checkNormTyp(i)
{
  var normTyp=document.getElementsByName("txtNormTyp")[i-1].value;
  if(document.getElementsByName("status")[i-1].value != 'D')
  {
	  if(normTyp=='OT_ABOVE' || normTyp=='ABOVE' )
	  {
		document.getElementsByName("txtSlab")[i-1].style.background="#ffffff";
		document.getElementsByName("txtSlab")[i-1].className="locked";
		document.getElementsByName("txtSlab")[i-1].value="";
		document.getElementsByName("hdnSlabId")[i-1].value="";
	  }
	  else
	  {
		document.getElementsByName("txtSlab")[i-1].style.background="#ffffd3";
		document.getElementsByName("txtSlab")[i-1].className="required";
	  }
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
		 document.getElementsByName("hdnHndlngNormId")[i].disabled="";
		 document.getElementsByName("hdnHndlngNormUnit")[i].disabled="";
		 document.getElementsByName("txtNormTyp")[i].disabled="";
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
     var normTyp=document.getElementsByName("txtNormTyp")[i].value;
     if(normTyp=='OT_ABOVE' || normTyp=='ABOVE')
     {
     if(document.getElementsByName("status")[i].value!='D' && document.getElementsByName("txtEmpList")[i].value=='')
     {
      alert("Mandatory Field Empty");
      return false;
     }
    }
  }  
  return true;
}

function checkUnit(i)
{
  var unit=document.getElementsByName("hdnHndlngNormUnit")[i-1].value;
  if(unit!='BAG')
  {
    document.getElementsByName("txtNormTyp")[i-1].disabled="true";
    document.getElementsByName("txtNormTyp")[i-1].style.background="#ffffff";
    document.getElementsByName("txtStartHrs")[i-1].disabled="true";
    document.getElementsByName("txtStartHrs")[i-1].style.background="#ffffff";
    document.getElementsByName("txtStartMin")[i-1].disabled="true";
    document.getElementsByName("txtStartMin")[i-1].style.background="#ffffff";
    document.getElementsByName("txtEndHrs")[i-1].disabled="true";
    document.getElementsByName("txtEndHrs")[i-1].style.background="#ffffff";
    document.getElementsByName("txtEndMin")[i-1].disabled="true";
    document.getElementsByName("txtEndMin")[i-1].style.background="#ffffff";
    document.getElementsByName("txtSlab")[i-1].style.background="#ffffff";
    document.getElementsByName("txtSlab")[i-1].style.className="locked";
  }
  else
  {
    document.getElementsByName("txtNormTyp")[i-1].disabled="";
    document.getElementsByName("txtNormTyp")[i-1].style.background="#ffffd3";
  }
}

function validateNormType(indx)
{
  normTyp=document.getElementsByName("txtNormTyp")[indx-1].value;
  workType=document.getElementsByName("hdnHndlngNormId")[indx-1].value;
  if(normTyp=='HEIGHT' || normTyp=='LEAD' )
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
      if((indx-1)!=i)
      {
        var tempNormTyp=document.getElementsByName("txtNormTyp")[i].value;
        var tempWorkType=document.getElementsByName("hdnHndlngNormId")[i].value;
        if(tempNormTyp=='ABOVE' && tempWorkType==workType)
        {
          return true;
        }
      }
    }
    alert("Please enter the record for Above Norm for entered work Type First!!!");
    //document.getElementsByName("txtNormTyp")[indx-1].value='';
    document.getElementsByName("hdnHndlngNormId")[indx-1].selectedIndex=0;
    //document.getElementsByName("txtHndlngNorm")[indx-1].value='';
    document.getElementsByName("hdnHndlngNormUnit")[indx-1].selectedIndex=0;
    return false;
  }
  
  if(normTyp=='OT_HEIGHT' || normTyp=='OT_LEAD' )
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
      if((indx-1)!=i)
      {
        var tempNormTyp=document.getElementsByName("txtNormTyp")[i].value;
        var tempWorkType=document.getElementsByName("hdnHndlngNormId")[i].value;
        if(tempNormTyp=='OT_ABOVE' && tempWorkType==workType)
        {
          return true;
        }
      }
    }
    alert("Please enter the record for Above Norm for entered work Type First!!!");
    //document.getElementsByName("txtNormTyp")[indx-1].value='';
    document.getElementsByName("hdnHndlngNormId")[indx-1].selectedIndex=0;
   // document.getElementsByName("txtHndlngNorm")[indx-1].value='';
    document.getElementsByName("hdnHndlngNormUnit")[indx-1].selectedIndex=0;
    return false;
  }
}
/*
function chkDuplicate(indx) //called from operations, norm types, slabs and checkTime().
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
	var opr,norm,bags,startHr,startMnt,slabId,slabId1;
	opr = document.getElementsByName("hdnHndlngNormId")[indx-1].value;
	norm = document.getElementsByName("txtNormTyp")[indx-1].value;
	bags = eval(document.getElementsByName("txtBags")[indx-1].value);
	startHr = eval(document.getElementsByName("txtStartHrs")[indx-1].value);
	startMnt = eval(document.getElementsByName("txtStartMin")[indx-1].value);
	endHr = eval(document.getElementsByName("txtEndHrs")[indx-1].value);
	endMnt = eval(document.getElementsByName("txtEndMin")[indx-1].value);
	slabId = eval(document.getElementsByName("hdnSlabId")[indx-1].value);
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
				norm1 = document.getElementsByName("txtNormTyp")[i].value;
				bags1 = eval(document.getElementsByName("txtBags")[i].value);
				startHr1 = eval(document.getElementsByName("txtStartHrs")[i].value);
				startMnt1 = eval(document.getElementsByName("txtStartMin")[i].value);
				endHr1 = eval(document.getElementsByName("txtEndHrs")[i].value);
				endMnt1 = eval(document.getElementsByName("txtEndMin")[i].value);
				slabId1 = eval(document.getElementsByName("hdnSlabId")[i].value);
				//alert("opr1="+opr1+",slabId1="+slabId1+"startHr1="+startHr1+",startMnt1="+startMnt1+",endHr1="+endHr1+",endMnt1="+endMnt1);
				if(opr==opr1 && norm==norm1 && slabId==slabId1)
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
		alert(flag)
		if(flag!=0)
		{
			alert("Duplicate entry is not allowed. Please check if Same Combination of Operation, Norm Type and Time Frame is already entered.");
			document.getElementsByName("hdnHndlngNormId")[indx-1].selectedIndex=0;
			return false;
		}
	}
	return true;
}
*/

function chkDuplicate(indx) //called from operations, norm types, slabs and checkTime().
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
	var opr,norm,bags,startHr,startMnt,slabId,slabId1,bagWt;
	opr = document.getElementsByName("hdnHndlngNormId")[indx-1].value;
	norm = document.getElementsByName("txtNormTyp")[indx-1].value;
	bags = eval(document.getElementsByName("txtBags")[indx-1].value);
	startHr = eval(document.getElementsByName("txtStartHrs")[indx-1].value);
	startMnt = eval(document.getElementsByName("txtStartMin")[indx-1].value);
	endHr = eval(document.getElementsByName("txtEndHrs")[indx-1].value);
	endMnt = eval(document.getElementsByName("txtEndMin")[indx-1].value);
	slabId = eval(document.getElementsByName("hdnSlabId")[indx-1].value);
	bagWt = document.getElementsByName("txtBagTyp")[indx-1].value;
	//alert("opr="+opr+",startHr="+startHr+",startMnt="+startMnt+",endHr="+endHr+",endMnt="+endMnt+",bagWt="+bagWt);
	var starttm = document.getElementsByName("txtStartHrs")[indx-1].value+document.getElementsByName("txtStartMin")[indx-1].value;
	var endtm = document.getElementsByName("txtEndHrs")[indx-1].value+document.getElementsByName("txtEndMin")[indx-1].value;
	//alert(starttm+","+endtm)
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
				norm1 = document.getElementsByName("txtNormTyp")[i].value;
				bags1 = eval(document.getElementsByName("txtBags")[i].value);
				startHr1 = eval(document.getElementsByName("txtStartHrs")[i].value);
				startMnt1 = eval(document.getElementsByName("txtStartMin")[i].value);
				endHr1 = eval(document.getElementsByName("txtEndHrs")[i].value);
				endMnt1 = eval(document.getElementsByName("txtEndMin")[i].value);
				slabId1 = eval(document.getElementsByName("hdnSlabId")[i].value);
				bagWt1 = document.getElementsByName("txtBagTyp")[i].value;
				//alert("opr1="+opr1+",slabId1="+slabId1+"startHr1="+startHr1+",startMnt1="+startMnt1+",endHr1="+endHr1+",endMnt1="+endMnt1);
				var starttm1 = document.getElementsByName("txtStartHrs")[i].value+document.getElementsByName("txtStartMin")[i].value;
				var endtm1 = document.getElementsByName("txtEndHrs")[i].value+document.getElementsByName("txtEndMin")[i].value;
				//alert(starttm1+","+endtm1)
				if(opr==opr1 && norm==norm1 && slabId==slabId1 && bagWt==bagWt1)
				{
					if(starttm==starttm1 && endtm==endtm1)
					{
						flag=1
					}
					if((starttm > starttm1) && (starttm < endtm1))
					{
						flag=2;
					}
					if(endtm > starttm1 && endtm < endtm1)
					{
						flag=3;
					}
					if(starttm == starttm1)
					{
						if(endtm > endtm1)
						{
							flag=4;
						}
					}
					if(endtm == endtm1)
					{
						if(starttm > starttm1)
						{
							flag=5;
						}
					}
					if(document.getElementsByName("chkContWork")[indx-1].checked)
					{
						if(starttm == starttm1)
						{
							flag=6;
						}
						if(starttm >= starttm1 && starttm < endtm1)
						{
							flag=7;
						}
					}
				}
			}
		}
		
		if(flag!=0)
		{
			alert("Duplicate entry is not allowed. Please check if Same Combination of Operation, Norm Type and Time Frame is already entered.");
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

function chkNoOfBags(indx)
{
	var opr = document.getElementsByName("hdnHndlngNormId")[indx-1].value;
	var bags = document.getElementsByName("txtBags")[indx-1].value;
	if(opr == 143 && bags > 0)
	{
		alert("No of Bags can not exceed 0 for the selected Operation.");
		document.getElementsByName("txtBags")[indx-1].value = "";
		document.getElementsByName("txtBags")[indx-1].focus();
		return false;
	}
	return true;
}

function checkgang()
{
	// alert("Dept checkgang ");
    document.forms[0].action = "../../../Gangchekdep.do";
    document.forms[0].submit();

}

</script>
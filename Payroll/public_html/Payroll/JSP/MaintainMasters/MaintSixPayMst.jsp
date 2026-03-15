<%@ page import="java.util.*"%>
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
	<script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
	<script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
	<script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<%! int i=0,j=0; %>
<% i = 0; j=0; %>

<html:form  action="MaintSixPayCodesAction" name="frmMaintSixPayCodesAction" type="FCIPAY.Payroll.WEBTIER.Form.MaintSixPayCodesForm" scope="session">
<bean:define id="ParentForm" name="frmMaintSixPayCodesAction" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerDataChanged"  />
<html:hidden property="headerFields" value="false" />

<html:hidden property="lovKey" name="frmMaintSixPayCodesAction"  />
<html:hidden property="txtFields" name="frmMaintSixPayCodesAction"  />
<html:hidden property="txtSearchFields" name="frmMaintSixPayCodesAction"  />
<html:hidden property="txtDisplayFields" name="frmMaintSixPayCodesAction"  />
<html:hidden property="txtIndex" name="frmMaintSixPayCodesAction"  />
<html:hidden property="txtInputField" name="frmMaintSixPayCodesAction"  />


<table border = 0>
<TR height=30>
  <TD  colSpan=15 class=mainHeader height=10><bean:message key="Payroll.MaintSixPay.head" /></TD>
</TR>
</TABLE>
<html:errors/>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
	<TD>

	   <!--<div id=divBody>-->
	   <!-- Body table Starts -->
	   <TABLE cellSpacing=0 cellPadding=0 >
	   <!--Account  Header Row Starts -->
	   <TR>
		  <TD class=subHeader colspan=6><bean:message key="Payroll.MaintSixPay.hd" /></TD>
	  </TR>
		   <TR>
			  <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
		  </TR>

		 <tr height="15" >
			<td colspan="2"></td>
		 </tr>


		 <tr height="10">
		 <tr>
			<tr height="10">
			
			</tr> <tr>
					  <td class="labelText"  width="40%" ><bean:message key="Payroll.MaintSixPay.code" /></td>
					  <td><html:text  property="txtPayCode1" altKey="Payroll.MaintDirect.code" maxlength="10" size="23" styleClass="required"  onblur="lfnGetPayCodeName(this.value)" readonly="true" />
					  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtPayCode1" onclick="ShowLovPayCode();" >&nbsp;&nbsp;
					  <html:text  property="txtPayCodeName"  maxlength="10" size="26" styleClass="locked" readonly="true" /></td>
					 </tr>
		<TD colspan="6" > </TD>
	  </tr>
	 </table>
	</div>

		<table cellspacing=0 cellpadding=0 border=0>
		 <!-- Detail Information Row starts -->

	 <TR height="200">
			<TD colspan=11>

			<!-- Account Config Detail Table Starts -->
		   <TABLE cellspacing="0" cellPadding="0" >
			  <TR>
				<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td bgcolor="#4682B4" nowrap class=actTabText><bean:message key="Payroll.MaintSixPay.detail" /><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
				<td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
				<td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
				<td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
		   </TR>

			  <TR height=10>

		<!-- Detail table Container starts -->
				<TD colspan="11">
				  <TABLE cellSpacing="0" cellPadding="0" border="0">
					<TBODY>
					<TR>
					  <TD >

						<DIV id=divDtlTable style="height:280px">
			<!-- Detail table starts -->
						<TABLE cellSpacing="0" cellPadding="0" id="Detail">
						  <TBODY>
								  <TR>
									<td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
									<td class=tableHeader width="1%"><bean:message key="Payroll.MaintSixPay.srno" /></td>
									<td class=tableHeader width="6%"><bean:message key="Payroll.MaintSixPay.code" /></td>
									<td class=tableHeader width="8%"><bean:message key="Payroll.MaintSixPay.desc" /></td>
									<td class=tableHeader width="2%"><bean:message key="Payroll.MaintSixPay.perc" /></td>
									<td class=tableHeader width="4%"><bean:message key="Payroll.MaintSixPay.edu" /></td>
									<td class=tableHeader width="6%"><bean:message key="Payroll.MaintSixPay.desg" /></td>

									<td class=tableHeader width="5%"><bean:message key="Payroll.MaintSixPay.mobile" /></td>
									<td class=tableHeader width="6%"><bean:message key="Payroll.MaintSixPay.conv" /></td>


									<td class=tableHeader width="4%"><bean:message key="Payroll.MaintSixPay.startdt" /></td>
									<td class=tableHeader width="8%"><bean:message key="Payroll.MaintSixPay.enddt" /></td>
									</TR>

								  <logic:iterate id="SixPayCodeInfo" name="frmMaintSixPayCodesAction" property="lstInstrDtls"  type="FCIPAY.Payroll.UTILITY.MaintSixPayCodesBean"   indexId="idx">
								<% ++i; %>
									<logic:notEqual name="SixPayCodeInfo" property="status" value="D" >
									 <tr>
									<td ><html:checkbox property="checked" onclick="checkRecord();" name="frmMaintSixPayCodesAction" /></td>
									<logic:notEqual name="SixPayCodeInfo" property="status" value="N" >
									  <% ++j; %>
										   <td ><html:text property="txtSrlNo" name="SixPayCodeInfo" size="3"   value="<%=String.valueOf(i)%>" styleClass="locked" readonly="true" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);"  /></td>
										   &nbsp;&nbsp;&nbsp;&nbsp;

										  
										   <td ><html:text property="txtPayCode" name="SixPayCodeInfo" size="6"   styleClass="locked" readonly="true" style="width:70%" alt="<%=String.valueOf(i)%>" onchange="
										   if (!num_Check(this.value,1))
											{
											  this.focus();
											  return false;
											}
										   else
										   return changed(this.alt);
										   "   onblur="lfnGetPayCodeNameDtl(this.alt, this.value)"    /> 
											
										   <logic:equal name="SixPayCodeInfo" property="status" value="N">
											<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  onclick="ShowLovPayCode1(this.alt);" >
										   </logic:equal>
										   <logic:equal name="SixPayCodeInfo" property="status" value="Q">
											<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayCode1(this.alt);" >
										   </logic:equal>
										   <logic:equal name="SixPayCodeInfo" property="status" value="U">
											<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayCode1(this.alt);" >
										   </logic:equal>
										  </td>

										   <td ><html:text property="txtDescription" name="SixPayCodeInfo"  styleClass="locked" readonly="true" size="10" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>
											<td ><html:text property="txtPercentage" name="SixPayCodeInfo"  styleClass="locked" readonly="true"   size="20" style="width:80%" alt="<%=String.valueOf(i)%>" onchange="return checkPercentage(this)" /></td>
											<td ><html:select property="txtEducation" name="SixPayCodeInfo"  styleClass="locked" disabled="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"   >
											<html:option value="">------Please select------</html:option>
											<html:option value="S">School </html:option>
											<html:option value="C">College</html:option>
											<html:option value="U">University</html:option>
										   </html:select></td>

											<td > <html:text  property="txtDsgnDesc"  maxlength="30" size="5" name="SixPayCodeInfo"  style="width:70%" onchange="chkVldn();" styleClass="locked" readonly="true" alt="<%=String.valueOf(i)%>"/>
											  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" alt=<%=idx%> onclick=" return  ShowQryLovDsgn(this.alt);" disabled="true"></td>
											 <html:hidden  property="txtDesg" name="SixPayCodeInfo"  alt="<%=String.valueOf(i)%>" />   
										   <td ><html:select property="txtMobile" name="SixPayCodeInfo"  styleClass="locked"  disabled="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"   >
											<html:option value="">------Please select------</html:option>
											<html:option value="Y">Yes</html:option>
											<html:option value="N">NO</html:option>
																					   </html:select></td>

										   <td ><html:select property="txtConveyance" name="SixPayCodeInfo"  styleClass="locked"  disabled="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"   >
											<html:option value="">------Please select------</html:option>
											<html:option value="F">Four Wheeler</html:option>
											<html:option value="T">Two Wheeler</html:option>
										   </html:select></td>
										   <!--start changed by sonia on 19 -10-2010 -->

											<td align="center"><html:text property="txtStartDate" name="SixPayCodeInfo" size="9" styleClass="locked" readonly="true" disabled="true" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="chkFromDt(this.alt)" />
											   <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" onclick="showCalendar('txtStartDate',this)"  disabled="true"/>
											   </td>
	
											   <td align="center"><html:text property="txtEndDate" name="SixPayCodeInfo" size="9" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>"  styleClass="locked" disabled="true" readonly="true" onchange="chkToDt(this.alt)"  />
											   <img src="..\INCLUDES\IMAGES\cal.gif" name="imgtxtEndDate"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=i-1 %>" onclick="showCalendar('txtEndDate',this)" />
											   </td>
									  </logic:notEqual>


									  <logic:equal name="SixPayCodeInfo" property="status" value="N" >
										  <% ++j; %>
										   <td ><html:text property="txtSrlNo" name="SixPayCodeInfo" size="3"   value="<%=String.valueOf(i)%>" styleClass="locked" style="width:100%" alt="<%=String.valueOf(i)%>" readonly="true"  /></td>
										   <td ><html:text property="txtPayCode" name="SixPayCodeInfo" size="6"    styleClass="locked" style="width:70%" alt="<%=String.valueOf(i)%>" readonly="true"/>

										   <logic:equal name="SixPayCodeInfo" property="status" value="N">
											<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"   >
										   </logic:equal>
										   <logic:equal name="SixPayCodeInfo" property="status" value="Q">
											<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayCode1(this.alt);" >
										   </logic:equal>
										   <logic:equal name="SixPayCodeInfo" property="status" value="U">
											<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayCode1(this.alt);"  >
										   </logic:equal>
										   </td>

										   <td ><html:text property="txtDescription" name="SixPayCodeInfo"  styleClass="locked" readonly="true" size="10" style="width:100%" alt="<%=String.valueOf(i)%>"  /></td>
										  <td ><html:text property="txtPercentage" name="SixPayCodeInfo"  styleClass="required"  size="10"  style="width:80%" alt="<%=String.valueOf(i)%>" onchange="return checkPercentage(this)" /></td>
										  <td ><html:select property="txtEducation" name="SixPayCodeInfo"  styleClass="required" disabled="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"   >
											<html:option value="">------Please select------</html:option>
											<html:option value="S">School </html:option>
											<html:option value="C">College</html:option>
											<html:option value="U">University</html:option>
										   </html:select></td>

											<td > <html:text  property="txtDsgnDesc"  maxlength="25" size="5" name="SixPayCodeInfo"  style="width:70%" onchange="chkVldn();" disabled="true" styleClass="required" readonly="true" alt="<%=String.valueOf(i)%>"/>
											  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig" alt=<%=idx%> onclick=" return  ShowQryLovDsgn(this.alt);"  disabled="true"></td>
											<html:hidden  property="txtDesg" name="SixPayCodeInfo"  alt="<%=String.valueOf(i)%>" />  
										   <td ><html:select property="txtMobile" name="SixPayCodeInfo"  styleClass="required"  alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  disabled="true" >
											<html:option value="">------Please select------</html:option>
											<html:option value="Y">YES</html:option>
											<html:option value="N">NO</html:option>
										
										   </html:select></td>

										   <td ><html:select property="txtConveyance" name="SixPayCodeInfo"  styleClass="required" disabled="true" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"   >
											<html:option value="">------Please select------</html:option>
											<html:option value="F">Four Wheeler</html:option>
											<html:option value="T">Two Wheeler</html:option>
										   </html:select></td>



										   <td align="center"><html:text property="txtStartDate" name="SixPayCodeInfo" size="9" styleClass="required" readonly="true" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="chkFromDt(this.alt)" />
											   <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" onclick="showCalendar('txtStartDate',this)" />
											   </td>
	
											   <td align="center"><html:text property="txtEndDate" name="SixPayCodeInfo" size="9" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>" readonly="true" onchange="chkToDt(this.alt)"  />
										  <img src="..\INCLUDES\IMAGES\cal.gif" name="imgtxtEndDate"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=i-1 %>" onclick="showCalendar('txtEndDate',this)" />
											   </td>
										 
										 </logic:equal>
									 
											  <html:hidden property="itemChecked" name="SixPayCodeInfo" />
											   <html:hidden property="status" name="SixPayCodeInfo" />
											   <html:hidden property="detailId" name="SixPayCodeInfo" />
									  </tr>
									  </logic:notEqual>
									 
									  
									  <logic:equal name="SixPayCodeInfo" property="status" value="D" >
									   <tr>
										   <td ><html:hidden property="checked" name="SixPayCodeInfo" value="notchecked" /></td>
										   <html:hidden property="itemChecked" name="SixPayCodeInfo" />
										   <html:hidden property="status" name="SixPayCodeInfo" />
										   <html:hidden property="detailId" name="SixPayCodeInfo" />
										   <td ><html:hidden property="txtSrlNo" name="SixPayCodeInfo" /></td>
										   <td ><html:hidden property="txtPayCode" name="SixPayCodeInfo" /></td>
										   <td ><html:hidden property="txtDescription" name="SixPayCodeInfo" /></td>
										   <td ><html:hidden property="txtEducation" name="SixPayCodeInfo"/></td>
										   <td ><html:hidden property="txtDesg" name="SixPayCodeInfo" /></td>
										   <td ><html:hidden property="txtDsgnDesc" name="SixPayCodeInfo" /></td>   
										   <td ><html:hidden property="txtMobile" name="SixPayCodeInfo" /></td>
										   <td ><html:hidden property="txtConveyance" name="SixPayCodeInfo" /></td>
										   <td ><html:hidden property="txtPercentage" name="SixPayCodeInfo" /></td>
										   <td ><html:hidden property="txtStartDate" name="SixPayCodeInfo" /></td>
										   <td ><html:hidden property="txtEndDate" name="SixPayCodeInfo" /></td>


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
					<TR>
					  <TD>
					  <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
					  </td>              </TR>
				  </TBODY>
				</TABLE>
				</TD>
				  </tr>
  </TBODY>
			</TABLE>
		  </td>
			   </tr>
<!-- Tab table Row 3 starts -->
			   <tr>
		<TD background="../INCLUDES/IMAGES/line_r.gif"><IMG src="../INCLUDES/IMAGES/pixel.gif" border=0></TD>
		</TR>
	<TR>
	 <TD align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
	</TR>

</TABLE>
		</td>
	</tr>
				<!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
		<TR>
			   <td align=center bgcolor=#4682b4 width="40%"></td>
<!--               <td  bgcolor=#4682b4><html:button value='Approve'  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Reject '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Revise '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /></td>  -->
			   <td bgColor=#4682b4></td>
			   <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
		 </TR>

</TABLE>

<!-- Container Table Ending Columns Starts-->
	</TD>

</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->

<html:hidden property="hdnAction" name="frmMaintSixPayCodesAction"  />
<html:hidden property="hdnRowVal" name="frmMaintSixPayCodesAction"  />
<html:hidden property="hdnPayCode" name="frmMaintSixPayCodesAction"  />
<html:hidden property="hdnPayCodeName" name="frmMaintSixPayCodesAction"  />
<html:hidden property="hdnPayStatus" name="frmMaintSixPayCodesAction"  />
<html:hidden property="headerPrimaryKey" name="frmMaintSixPayCodesAction"  />
<html:hidden property="screenMode" name="frmMaintSixPayCodesAction"  />
<html:hidden property="screenModeDir" name="frmMaintSixPayCodesAction"  />
<html:hidden name="frmMaintSixPayCodesAction"  property="screenName" value="MaintSixPayCodesScreen" />
<html:hidden name="frmMaintSixPayCodesAction"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintSixPayCodesAction"  />
<html:hidden property="userPageRequested" name="frmMaintSixPayCodesAction" />
<html:hidden property="pageRequested" name="frmMaintSixPayCodesAction" />
<html:hidden property="buttonFlag" name="frmMaintSixPayCodesAction"  />


<html:hidden property="loginLocCode" name="frmMaintSixPayCodesAction"  />
<input type="hidden" name="queryParam" />
<!--input type="hidden" name="txtCPFCode"-->


</html:form>
</body>
</html:html>


<script language="javascript">

var chkMes = 0;
function changed(val)
{
  frmMaintSixPayCodesAction.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
  document.getElementsByName("status")[val-1].value = 'U';
}

function agChanged(val)
{
  document.getElementsByName("txtAgencySite")[val-1].value="";
  document.getElementsByName("txtAgencySiteCode")[val-1].value="";
  frmMaintSixPayCodesAction.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
  document.getElementsByName("status")[val-1].value = 'U';
}


function doBaseAddRow()
{ 
 document.all.buttonFlag.value='';
 if(!mandatory_Check("frmMaintSixPayCodesAction"))
		return false;

// if(!checkEndDate())
//return false;

		//isRecordExist();
		var oTable = document.getElementById("Detail");
		
			  if(oTable == null)
			  {
				return;
			  }
			  var iTr2 = oTable.rows.length;
			 // alert("length" + iTr2);
			  var i = 0;


  /*for(i=0; i < iTr2 -1; i++)
				  {
				   var perc=parseInt(document.getElementById("txtPercentage").value);
				   //alert("perc" + perc);
				   if(perc == 0 || perc < 0){
				    alert("Please enter the correct percentage value!!!");
				    return false;
				   }
				  }*/


			  for(i=0; i < iTr2 -1; i++)
				  {
				   var paycode=parseInt(document.getElementById("txtPayCode1").value);
				   if(paycode != 166 && paycode != 116 && paycode != 211 && paycode != 220 && paycode != 216){
				 // alert(document.getElementsByName("status")[i].value);
				 // alert(document.getElementsByName("txtEndDate")[i].value );
				 if(document.getElementsByName("status")[i].value!='D'){					 
				 if(document.getElementsByName("txtEndDate")[i].value == ""){
					alert("Please enter End Date!!!");
					if(document.getElementsByName("status")[i].value!='N'){
					document.getElementsByName("status")[i].value = 'U';
					}
					frmMaintSixPayCodesAction.detailDataChanged.value = "true";					
					document.getElementsByName("txtSrlNo")[i].disabled="";					
					document.getElementsByName("txtEndDate")[i].disabled="";
					document.getElementsByName("txtEndDate")[i].style.className="required";
					document.getElementsByName("txtEndDate")[i].style.background="#ffffd3";
					//alert("i value" +i );
					document.getElementsByName("imgtxtEndDate")[i].disabled="";
				   
					//alert("end");
					return false;
					}
				  }
				  }
				  }

  enableRow();
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
	return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

 frmMaintSixPayCodesAction.screenMode.value = "U";
 frmMaintSixPayCodesAction.action = "../../../SixPayAddRowAction.do";
 enableRow();
 frmMaintSixPayCodesAction.submit();
}

function doBaseDelRow()
{
  enableRow();
  document.all.buttonFlag.value='D';
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
	  // alert(document.getElementsByName("checked")[i].checked);
		if(document.getElementsByName("checked")[i].checked)
		{
			flag=flag+1;
			//alert("Flag" +flag);
		}
	}
	if ( flag == 0)
	{
		alert("Please check the rows to be deleted");
		return false;
	}


  for(i=0; i < iTr2 -1; i++)
  {
//alert("Value"  +document.getElementsByName("itemChecked")[i].value);
	if(document.getElementsByName("checked")[i].checked)
	{
	  document.getElementsByName("itemChecked")[i].value = "Y";
	  //frmMaintSixPayCodesAction.detailDataChanged.value = "true";
	}
	//alert("Value2"  +document.getElementsByName("itemChecked")[i].value);

  }


  //enable();
 
  
  document.forms[0].action = "../../../SixPaydeleteRowAction.do";
  document.forms[0].submit();
}


/*function enable()
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
   
        document.getElementsByName("txtPayCode1")[i].disabled="";
        document.getElementsByName("txtPayCodeName")[i].disabled="";
        document.getElementsByName("txtPayMode")[i].disabled="";
		document.getElementsByName("txtStartDate")[i].disabled="";
		document.getElementsByName("txtEndDate")[i].disabled="";
    }
  }*/





/*
function doBaseDelRow()
{
  enableRow();
  document.all.buttonFlag.value='D';
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  var strRecList='';
  for(i=0; i < iTr2 -1; i++)
  {
	  alert(document.getElementsByName("detailId")[i].value);
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("detailId")[i].value=='')
        document.getElementsByName("itemChecked")[i].value = "Y";
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  //alert("strRecList"+ strRecList)
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }   
  
  
  document.forms[0].action = "../../../SixPaydeleteRowAction.do";
  document.forms[0].submit();
}
*/


function SaveRecord()
{
 document.all.buttonFlag.value='';





 if(!isRecordExist())
return false;

 if(!mandatory_Check("frmMaintSixPayCodesAction"))
		return false;


//if(!checkEndDate())
//return false;

 
					
 /* var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;				  

 for(i=0; i < iTr2 -1; i++)
				  {
				 alert(document.getElementsByName("txtEndDate")[i].style.className);
				 if(document.getElementsByName("status")[i].value!='D'){					 
				 if(document.getElementsByName("txtEndDate")[i].value == "" &&       		   document.getElementsByName("txtEndDate")[i].style.className == "required"){
				 alert("Please enter End Date!!!");					
				 return false;
				 }
				 }
				  }
*/

/* if(!checkPayCode())
	  return false;*/

/* if(!AmtCheck())
	  return false;*/

 

	enableRow();
	// enable();

  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
	return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;


  for(i=0; i < iTr2 -1; i++)
  {
		//alert("inside for");
		//alert(document.getElementsByName("status")[i].value);

	   if(document.getElementsByName("status")[i].value == 'D')
		frmMaintSixPayCodesAction.detailDataChanged.value = "true";
  }


  frmMaintSixPayCodesAction.headerFields.value = "false";
  frmMaintSixPayCodesAction.totalDetailRecord.value = parseInt(iTr2,10) - 1;
  document.all.butSave.disabled="true";


	  if (document.all.screenMode.value == "N")
	  {
		 document.all.screenModeDir.value = "UG";
		 document.all.screenMode.value = "U";
	  }
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintSixPayCodesAction.action = "../../../SixPaySaveAction.do";
  frmMaintSixPayCodesAction.submit();
}


function checkPayCode()
{
			var oTable = document.getElementById("Detail");
			var iTr2 = oTable.rows.length;
			var flag =0;
			var i = 0;

			for(i=0;i<iTr2-1;i++)
			{
			  if (document.getElementsByName("status")[i].value != 'D')
			  {
				var tempPayCode = document.getElementsByName("txtPayCode")[i].value;
				 if ((parseInt(tempPayCode,10) < 100) ||  (parseInt(tempPayCode,10) > 999))
				{
				   alert("Pay Code should always be a 3 digit no.");
				   document.getElementsByName("txtPayCode")[i].focus();
				   return false;
				}

				else if((parseInt(tempPayCode.substring(0,1),10) > 5) && (parseInt(tempPayCode.substring(0,1),10) < 9))
				{
					alert("Pay Code should always start with 1,2,3,4,5 or 9");
					document.getElementsByName("txtPayCode")[i].focus();
				   return false;
				}
			  }
			}

		return true;
}



function doSetFlag(flag)
{
  document.all.criteria.value=flag;
  //alert('criteria in jsp='+document.all.criteria.value);
  doExecute();
}



	function PayClick()
  {
  document.frmMaintSixPayCodesAction.hdnAction.value = "";
	document.all.buttonFlag.value='';

	if (  document.all.screenModeDir.value == 'UG')
		  document.all.screenModeDir.value = 'U';

	document.frmMaintSixPayCodesAction.action="../../../SixPayOptionClickAction.do";
	//document.frmMaintSixPayCodesAction.optVal.value="2";
	document.frmMaintSixPayCodesAction.submit();
   }



function doInsertMode()
{
//  alert("new");
  document.frmMaintSixPayCodesAction.hdnAction.value = "";
  document.all.buttonFlag.value='';
  document.all.screenModeDir.value = 'N';
  frmMaintSixPayCodesAction.headerDataChanged.value = "false";
  frmMaintSixPayCodesAction.action="../../../SixPayNewMode.do"
 frmMaintSixPayCodesAction.submit();
}

function doQueryMode()
{
  document.all.buttonFlag.value='';
  document.frmMaintSixPayCodesAction.hdnAction.value = "";
  document.all.screenModeDir.value = 'Q';
  frmMaintSixPayCodesAction.headerDataChanged.value = "false";
  frmMaintSixPayCodesAction.action="../../../SixPayQueryMode.do"
  frmMaintSixPayCodesAction.submit();
}


function lfnLoad()
{
  mode = document.all.screenMode.value;
  //alert(mode);
  selectEnable();
  if(mode=='')
  {
	  doQueryMode();
  }


  /*if (document.all.screenModeDir.value == "")
  {
	 document.all.screenModeDir.value = "Q";
	 document.all.screenMode.value = "Q";
  }*/

 // mode = document.all.screenModeDir.value;

  if(mode=='')
  {
	 document.all.butGetDetail.disabled="";
	 document.all.butInsert.disabled="disabled";
	 document.all.butDelete.disabled="disabled";
  }

  if(mode=='Q')
  {
		   var PaycodeName= document.getElementById("txtPayCodeName").value;
		   if(PaycodeName!=""){
			document.getElementById("txtPayCodeName").value="";
		   }
	 document.all.butGetDetail.disabled="";
	 document.all.butInsert.disabled="disabled";
	 document.all.butDelete.disabled="disabled";
  }



  if(mode=='U')
  {
	  
	  setPayCodes();
	  document.all.butGetDetail.disabled="disabled";
	  document.all.butInsert.disabled="";
	  document.all.butDelete.disabled="disabled";
	  document.all.butInsertMode.disabled="disabled";
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";

	  var oTable = document.getElementById("Detail");
	  if(oTable == null)
	  {
		return;
	  }
  }

  if(mode=='N' )
  {
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
	return;
  }
  setPayCodes();
      var iTr2 = oTable.rows.length;
	  document.all.butGetDetail.disabled="disabled";
	  document.all.butInsert.disabled="";
	  document.all.butDelete.disabled="";
  }

  if(mode=='UG')
  {
	  document.all.butGetDetail.disabled="disabled";

	  document.all.butInsert.disabled="";
	  document.all.butDelete.disabled="";
  }






  if(document.frmMaintSixPayCodesAction.hdnAction.value == "GetPayCodeName")
  {
	  if (document.frmMaintSixPayCodesAction.txtPayCodeName.value == "")
	  {
		  alert("Invalid Savings Code");
		  document.frmMaintSixPayCodesAction.txtPayCode1.focus();
	  }
  }

  if(document.frmMaintSixPayCodesAction.hdnAction.value == "GetPayCodeNameDtl")
  {
	  var iRowVal = document.frmMaintSixPayCodesAction.hdnRowVal.value;
	  if (document.frmMaintSixPayCodesAction.hdnPayCodeName.value != "")
	  {
	  var iRowVal = document.frmMaintSixPayCodesAction.hdnRowVal.value;
	 // document.getElementsByName("txtDescription")[iRowVal-1].value = document.frmMaintSixPayCodesAction.hdnPayCodeName.value;
	  document.frmMaintSixPayCodesAction.hdnAction.value = "";
	  document.getElementsByName("txtPayMode")[iRowVal-1].focus();
	  }
	  else
	  {
		  alert("Invalid Pay Code");
		  document.getElementsByName("txtDescription")[iRowVal-1].value = "";
		  document.getElementsByName("txtPayCode")[iRowVal-1].focus();
	  }
  }





  var oTable = document.getElementById("Detail");
/*  if(oTable == null)
  {
	return;
  } */
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
	 if (document.getElementsByName("status")[i].value == 'Q')
	  {
		document.getElementsByName("txtPayCode")[i].disabled="disabled";

	  }
  }


  document.all.butDelete.disabled="true";
  mode1 = frmMaintSixPayCodesAction.screenMode.value;
  menuHandling(mode1);
   document.all.butInsertMode.disabled="disabled";
   document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";

 }


/*function GetDetail()
{
 document.all.buttonFlag.value=''; 

  frmMaintSixPayCodesAction.screenMode.value='U';
  frmMaintSixPayCodesAction.headerDataChanged.value = "false";

   if(!mandatory_Check("frmMaintSixPayCodesAction"))
		return false;

	  frmMaintSixPayCodesAction.headerPrimaryKey.value = frmMaintSixPayCodesAction.txtPayCode1.value ;


  frmMaintSixPayCodesAction.action="../../../SixPayFirstGetDetailAction.do"
  frmMaintSixPayCodesAction.submit();
}*/


function GetDetail()
{
	
	
	 document.all.buttonFlag.value='';	
     document.all.screenMode.value='U'; 
	 frmMaintSixPayCodesAction.headerPrimaryKey.value = "";	 
	 frmMaintSixPayCodesAction.action="../../../SixPayFirstGetDetailAction.do";
	 frmMaintSixPayCodesAction.submit();
	
}











//added by yogesh

function doBasePrevDetail()
{
	document.all.buttonFlag.value='';
	frmMaintSixPayCodesAction.userPageRequested.value = 1*frmMaintSixPayCodesAction.pageRequested.value - 1;
	frmMaintSixPayCodesAction.action = "../../../SixPayPrevDetailAction.do";
	frmMaintSixPayCodesAction.submit();
}


function doBaseNextDetail()
{
	document.all.buttonFlag.value='';
	frmMaintSixPayCodesAction.userPageRequested.value = 1*frmMaintSixPayCodesAction.pageRequested.value + 1;
	frmMaintSixPayCodesAction.action = "../../../SixPayNextDetailAction.do";
	frmMaintSixPayCodesAction.submit();
}

function JumpDetail()
{
	document.all.buttonFlag.value='';
	frmMaintSixPayCodesAction.userPageRequested.value = 1*frmMaintSixPayCodesAction.newPageRequested.value ;
	frmMaintSixPayCodesAction.action = "../../../DirectPayrollNextDetailAction.do";
	frmMaintSixPayCodesAction.submit();
}


function menuHandling(mode1)
{
//alert(mode1);
  if(mode1=='Q')
  {
	  document.all.butQueryMode.disabled="true";
	  document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";
	  document.all.butExecute.disabled="true";
	  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	  document.all.butSave.disabled="true";
	  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	  document.all.butDel.disabled="true";
	  document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
/*      document.all.butPrint.disabled="true";
	  document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg"; */
	  document.all.butRefresh.disabled="true";
	  document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";
	  document.all.butPrevHeader.disabled="true";
	  document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";
	  document.all.butNextHeader.disabled="true";
	  document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";
	  document.all.butnGo.disabled="true";
	 
  }
  if(mode1=='N')
  {

	  document.all.butInsertMode.disabled="true";
	  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
	  document.all.butExecute.disabled="true";
	  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	  document.all.butDel.disabled="true";
	  document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
//      document.all.butRefresh.disabled="true";
//      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";
	  document.all.butPrevHeader.disabled="true";
	  document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";
	  document.all.butNextHeader.disabled="true";
	  document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";
	  document.all.butnGo.disabled="true";
  }
  if(mode1=='U')
  {
	  document.all.butExecute.disabled="true";
	  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	  document.all.butDel.disabled="true";
	  document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
  }

if(document.all.buttonFlag.value=='D')
  {
/*     document.all.butQueryMode.disabled="true";
	  document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";
	  document.all.butInsertMode.disabled="true";
	  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  */

  }
}

  function doRefresh()
	{
		   document.frmMaintSixPayCodesAction.hdnAction.value = "";
		frmMaintSixPayCodesAction.action = "../../../SixPayRefresh.do";
		frmMaintSixPayCodesAction.submit();
	}





function lfnGetPayCodeName(val)
{
	if (val != "")
	{
		 frmMaintSixPayCodesAction.hdnAction.value="GetPayCodeName";
		//frmMaintSixPayCodesAction.action="../../../DirSavGetEmpName.do"  commented by Sonia on 21-10-2010
		 frmMaintSixPayCodesAction.action="../../../DirSavGetEmpNameNormal.do";
		 frmMaintSixPayCodesAction.submit();
	}
}

function lfnGetPayCodeNameDtl(val, value)
{
	if (value != "")
	{
		if(frmMaintSixPayCodesAction.screenModeDir.value="N")
		{
			EnableField();
		   frmMaintSixPayCodesAction.hdnAction.value="GetPayCodeNameDtl";
		   frmMaintSixPayCodesAction.hdnRowVal.value=val;
		   frmMaintSixPayCodesAction.hdnPayCode.value=value;
		   //frmMaintSixPayCodesAction.action="../../../DirSavGetEmpName.do"  commented by Sonia on 21-10-2010
		   frmMaintSixPayCodesAction.action="../../../DirSavGetEmpNameNormal.do";
		   frmMaintSixPayCodesAction.submit();
		}
   }
}



function EnableField()
{
  var oTable = document.getElementById("Detail");
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
		document.getElementsByName("txtEmpNo")[i].disabled="";
		document.getElementsByName("txtPayCode")[i].disabled="";


	  if (document.getElementsByName("status")[i].value == 'D')
		frmMaintSixPayCodesAction.detailDataChanged.value = "true";
  }

}

  function setPayCodes() {
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	if(iTr2>1) {
		var i=<%=i%>;
	
		var paycode=document.getElementById("txtPayCode1").value;
		var paycodedesc=document.getElementById("txtPayCodeName").value;
		
		document.getElementsByName("txtPayCode")[i-1].value=paycode;
		document.getElementsByName("txtDescription")[i-1].value=paycodedesc;
	}
}


function enableEndDt() {
	//var addBtn = document.getElementById("addBtnFlag").value;
	//if(addBtn == "") {
		var oTable = document.getElementById("Detail");
		if(oTable == null)
		{
			return;
		}
		var iTr2 = oTable.rows.length;
		var indx = <%=i-1%>;
		//alert("indx--" + indx);
		if(iTr2 > 1) {
			var endDt = document.getElementsByName("txtEndDate")[indx];
			if(endDt.value == "") {
				//endDt.readOnly=false;
				var imgtxtEndDate =  document.getElementsByName("imgtxtEndDate")[indx];
				imgtxtEndDate.onclick = function() {showCalendar(endDt,this);};
			}
		}
	//}
}

function chkEndDtStatus(){
	//var btnFlg = document.getElementById("addBtnFlag").value;
	//if(btnFlg == "" ){
		var oTable = document.getElementById("Detail");
		if(oTable == null)
		{
			return;
		}
		var iTr2 = oTable.rows.length;
		if(iTr2 > 1){
			var temp = <%=j%>;
			var temp1 = <%=i%>;
			var indx = <%=i-1%>
			if(temp < temp1) indx = <%=j-1%>;

			var prvEndDt = document.getElementsByName("txtEndDate")[indx].value;
			if(prvEndDt!=""){
				return true;
			}else{
				alert("Please End Date the Previous Record");
				disable();
				document.getElementsByName("txtEndDate")[indx].focus();
				return false;
			}
		}else{
			return true;
		}
	//}else{
		//return true;
	//}
}

function chkFromDt(i)
{
  var fromDt=document.getElementsByName("txtStartDate")[i-1].value;
  if(!cmpSysDate(fromDt,0))
	{
	  document.getElementsByName("txtStartDate")[i-1].value="";
	  return false;
	}
	setEndDt(i);
}

function chkToDt(i)
{
  var fromDt=document.getElementsByName("txtEndDate")[i-1].value;
  if(!cmpSysDate(fromDt,0))
	{
	  document.getElementsByName("txtEndDate")[i-1].value="";
	  return false;
	}

	comprDate(i);
}

function comprDate(indx){
	var frmDt = document.getElementsByName("txtStartDate")[indx-1].value;
	if(frmDt != ""){
		var toDt = document.getElementsByName("txtEndDate")[indx-1].value;
		if (!cmpDate(frmDt,toDt,0)){
			alert("End Date must be greater than Start Date.");
			document.getElementsByName("txtEndDate")[indx-1].value="";
			return false;
		}
	}else{
		alert("Enter Start Date First");
		document.getElementsByName("txtEndDate")[indx-1].value="";
		document.getElementsByName("txtStartDate")[indx-1].focus();
		return false;
	}
}

function setEndDt(rInd)
 {
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
	return;
  }
  var iTr2 = oTable.rows.length;
 // alert("Date Length" +iTr2);
  if(iTr2 > 2){
		//var btnFlg = document.getElementById("addBtnFlag").value;
		var temp = <%=j%>;
		var temp1 = <%=i%>;
		//alert(temp+"=="+temp1)
		var frmDt = document.getElementsByName("txtStartDate")[rInd-1].value;
		if(temp < temp1) rInd = <%=j%>;
		var prvToDt = document.getElementsByName("txtEndDate")[rInd-2].value;
		if (prvToDt == frmDt) {
			alert("Start Date Must Be Greater Than Previous End Date .");
			document.getElementsByName("txtStartDate")[temp1-1].value = "";
			return false;
		} else {
			if (!cmpDate(prvToDt,frmDt,0)){
				alert("Start Date Must Be Greater Than Previous End Date .");
				document.getElementsByName("txtStartDate")[temp1-1].value = "";
				return false;
			}
		}
  }
  else  return ;
}

function selectEnable(){

  var paycode=parseInt(document.getElementById("txtPayCode1").value);
  var oTable = document.getElementById("Detail");
	  if(oTable == null)
	  {
		return;
	  }
	  var iTr2 = oTable.rows.length;
	  var i = 0;
	  for(i=0; i < iTr2 -1; i++)
		  {
		  //alert(document.getElementsByName("status")[i].value);
		if(document.getElementsByName("status")[i].value=='N'){
				        if(paycode==166){
					   
					    document.getElementsByName("txtMobile")[i].disabled="";
					    }
						else if(paycode==216)
						{
						document.getElementsByName("txtConveyance")[i].disabled="";
					    }

						else if(paycode==116)
						{						
						document.getElementsByName("txtEducation")[i].disabled="";
						}

						else if(paycode==220 || paycode==211)
						{
						document.getElementsByName("txtDsgnDesc")[i].disabled="";
						document.getElementsByName("buttxtDesig")[i].disabled="";
						}
						//else if(paycode==116)
						//{
						//document.getElementsByName("txtMobile")[i].disabled="";
						
						//}
				}
		  }
}

function enableRow(){
// alert("inside enableRow if");
 	 var oTable = document.getElementById("Detail");
	  if(oTable == null)
	  {
		return;
	  }
	  var iTr2 = oTable.rows.length;
	  //alert("length" +iTr2);
	  var i = 0;
	  for(i=0; i < iTr2-1 ; i++)
		  {
		    document.getElementsByName("txtSrlNo")[i].disabled="";
			document.getElementsByName("txtMobile")[i].disabled="";
			document.getElementsByName("txtEducation")[i].disabled="";
			document.getElementsByName("txtDsgnDesc")[i].disabled="";
			document.getElementsByName("txtConveyance")[i].disabled="";			
			document.getElementsByName("txtPayCode")[i].disabled="";	
			document.getElementsByName("txtDescription")[i].disabled="";				
			document.getElementsByName("txtStartDate")[i].disabled="";
			document.getElementsByName("txtEndDate")[i].disabled="";
		  }
}


function ShowQryLovDsgn(i)
{  
       frmMaintSixPayCodesAction.lovKey.value = "SixPayCodeDesg" + frmMaintSixPayCodesAction.screenName.value +  "N"; 
       //frmMaintSixPayCodesAction.screenMode.value;	   
	   frmMaintSixPayCodesAction.txtDisplayFields.value = "txtDsgnDesc,txtDesg";
       frmMaintSixPayCodesAction.txtSearchFields.value = "pay.EnqPayImg.txtDesig,pay.MaintMiscellaneousParam.category,pay.MaintPayScaleIDA.payscalecode";
       frmMaintSixPayCodesAction.txtIndex.value=i;
	   frmMaintSixPayCodesAction.txtInputField.value=""; 
	   if(!(document.getElementsByName("status")[i].value == "N"))
		document.getElementsByName("status")[i].value = "U";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintSixPayCodesAction'); 
}

/*function ShowLovPayCode1(i)
{
   frmMaintSixPayCodesAction.lovKey.value = "MaintSixPayCode" + frmMaintSixPayCodesAction.screenName.value + "N";
   frmMaintSixPayCodesAction.txtDisplayFields.value = "txtPayCode,txtDescription";
   frmMaintSixPayCodesAction.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";
   frmMaintSixPayCodesAction.txtIndex.value=i;
   frmMaintSixPayCodesAction.txtInputField.value="";

   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintSixPayCodesAction');

   return true;
}*/


function ShowLovPayCode()
{

   frmMaintSixPayCodesAction.lovKey.value = "MaintSixPayCode" + frmMaintSixPayCodesAction.screenName.value + frmMaintSixPayCodesAction.screenMode.value;
   frmMaintSixPayCodesAction.txtDisplayFields.value = "txtPayCode1,txtPayCodeName";
   frmMaintSixPayCodesAction.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";
   frmMaintSixPayCodesAction.txtIndex.value="";
   frmMaintSixPayCodesAction.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintSixPayCodesAction');
   return true;
}

function checkEndDt(){
var oTable = document.getElementById("Detail");

	  if(oTable == null)
	  {
		return;
	  }
	  var iTr2 = oTable.rows.length;
	  var i = 0;
	  for(i=0; i < iTr2 -1; i++)
		  {
		
			if(document.getElementsByName("txtEndDate")[i].value == ""){
			
			return false;
			}
			
		  }
}




function isRecordExist(){
//alert("isRecordExist");

var oTable = document.getElementById("Detail");

if(oTable == null)
	  {
		return;
	  }
	  var iTr2 = oTable.rows.length;
	  var i = 0;
	   var flag = 0;
	  var recordData="";
	  var recordData1="";
	  var recordDataArr = new Array();
	  var checkDataArr = new Array();
	  for(i=0; i < iTr2 -1; i++)
		  {
			   recordData=  document.getElementsByName("txtPayCode")[i].value+document.getElementsByName("txtConveyance")[i].value+
			   document.getElementsByName("txtMobile")[i].value+
			   document.getElementsByName("txtPercentage")[i].value+
			   document.getElementsByName("txtDesg")[i].value+
			   document.getElementsByName("txtEducation")[i].value+
			   document.getElementsByName("txtStartDate")[i].value;

			   	if(document.getElementsByName("status")[i].value == 'Q'){
	           recordDataArr.push(recordData);
				}
			   //alert(recordData);
		  }
		  //alert("length"  + recordDataArr.length);

for(i=0; i < iTr2 -1; i++)
		  {
	//alert("Status"  + document.getElementsByName("status")[i].value == "N");
			if(document.getElementsByName("status")[i].value == 'N' || document.getElementsByName("status")[i].value == 'U' ){
			
			   recordData1=  document.getElementsByName("txtPayCode")[i].value+document.getElementsByName("txtConveyance")[i].value+
			   document.getElementsByName("txtMobile")[i].value+
			   document.getElementsByName("txtPercentage")[i].value+
			   document.getElementsByName("txtDesg")[i].value+
			   document.getElementsByName("txtEducation")[i].value+
			   document.getElementsByName("txtStartDate")[i].value;
	           checkDataArr.push(recordData1);
			  // alert(recordData1);
			
			}
		  }
//alert("length"  + checkDataArr.length);
			for(var m=0;m<checkDataArr.length;m++)
			{

				for(var n=0;n<recordDataArr.length;n++)
				{
					if(checkDataArr[m] == recordDataArr[n]){
					//alert(checkDataArr[m] + "equal" + recordDataArr[n]);
					}
					if(checkDataArr[m] == recordDataArr[n]){
					//alert(flag + "m" + m + "n"   +n);
					flag = flag+1;
					//alert(flag + "m" + m + "n"   +n);
						
					}
				}
			}

			if(flag > 0){			
			alert("Duplicate data not allowed!!!");
			return false;
			}
			
			return true;
}




/*function isRecordExist(){
//alert("isRecordExist");

var oTable = document.getElementById("Detail");

if(oTable == null)
	  {
		return;
	  }
	  var iTr2 = oTable.rows.length;
	  var i = 0;
	   var flag = 0;
	  var recordData="";
	  var recordData1="";
	  var recordDataArr = new Array();
	  var checkDataArr = new Array();
	  for(i=0; i < iTr2 -1; i++)
		  {
			   recordData=document.getElementsByName("txtSrlNo")[i].value+"@"+   document.getElementsByName("txtPayCode")[i].value+document.getElementsByName("txtConveyance")[i].value+
			   document.getElementsByName("txtMobile")[i].value+
			   document.getElementsByName("txtPercentage")[i].value+
			   document.getElementsByName("txtDesg")[i].value+
			   document.getElementsByName("txtEducation")[i].value+"$"+ 
			   document.getElementsByName("txtStartDate")[i].value;

			   	if(document.getElementsByName("status")[i].value == 'Q'){
	           recordDataArr.push(recordData);
				}
			   //alert(recordData);
		  }
		  //alert("length"  + recordDataArr.length);

for(i=0; i < iTr2 -1; i++)
		  {
	//alert("Status"  + document.getElementsByName("status")[i].value == "N");
			if(document.getElementsByName("status")[i].value == 'N' || document.getElementsByName("status")[i].value == 'U' ){
			
			   recordData1=  document.getElementsByName("txtPayCode")[i].value+document.getElementsByName("txtConveyance")[i].value+
			   document.getElementsByName("txtMobile")[i].value+
			   document.getElementsByName("txtPercentage")[i].value+
			   document.getElementsByName("txtDesg")[i].value+
			   document.getElementsByName("txtEducation")[i].value+
			   document.getElementsByName("txtStartDate")[i].value;
	           checkDataArr.push(recordData1);
			  // alert(recordData1);
			
			}
		  }
//alert("length"  + checkDataArr.length);
			for(var m=0;m<checkDataArr.length;m++)
			{

				for(var n=0;n<recordDataArr.length;n++)
				{
					var searchIndex = recordDataArr[m].indexOf("@");
					alert("searchIndex"  + searchIndex);
					var srlno = recordDataArr[m].substring(0,searchIndex);
					var searchIndex1 = existDataArr[n].indexOf("$");
					//alert("searchIndex1"  + searchIndex1);
					var existDataA=recordDataArr[m].substring(searchIndex+1,searchIndex1);
					//alert("existDataA--"  + existDataA);

					if(checkDataArr[m] == existDataA){
					//alert(checkDataArr[m] + "equal" + existDataA);
					}
					if(checkDataArr[m] == recordDataArr[n]){
					//alert(flag + "m" + m + "n"   +n);
					flag = flag+1;
					//alert(flag + "m" + m + "n"   +n);

             //document.getElementsByName("txtEndDate")[srlno].style.className="required";
			 //document.getElementsByName("txtEndDate")[].style.background="#ffffd3";

						
					}
				}
			}

			if(flag > 0){			
			alert("Duplicate data not allowed!!!");
			return false;
			}
			
			return true;
}

*/




function checkEndDate(){
var oTable = document.getElementById("Detail");
//alert("inside enddate");
if(oTable == null)
	  {
		return;
	  }
	  var iTr2 = oTable.rows.length;
	  var i = 0;
	  var flag = 0;     
	  var existData="";
	  var newData="";
	  var existDataArr = new Array();
	  var newDataArr = new Array();
	  var srlNoArr = new Array();
	  for(i=0; i < iTr2 -1; i++)
		  {
			   existData=document.getElementsByName("txtSrlNo")[i].value+"@"+  document.getElementsByName("txtPayCode")[i].value+document.getElementsByName("txtConveyance")[i].value+
			   document.getElementsByName("txtMobile")[i].value+
			   document.getElementsByName("txtPercentage")[i].value+
			   document.getElementsByName("txtDesg")[i].value+
			   document.getElementsByName("txtEducation")[i].value+"$"+ 
			   document.getElementsByName("txtStartDate")[i].value;
               //document.getElementsByName("txtEndDate")[i].value;
			   	if(document.getElementsByName("status")[i].value == 'Q'){
	           existDataArr.push(existData);
			   //alert(existData);
				}
			   
		  }

		  for(i=0; i < iTr2 -1; i++)
		  {	
			if(document.getElementsByName("status")[i].value == 'N' || document.getElementsByName("status")[i].value == 'U' ){
			
			   newData=  document.getElementsByName("txtPayCode")[i].value+document.getElementsByName("txtConveyance")[i].value+
			   document.getElementsByName("txtMobile")[i].value+
			   document.getElementsByName("txtPercentage")[i].value+
			   document.getElementsByName("txtDesg")[i].value+
			   document.getElementsByName("txtEducation")[i].value;//+"@"+ 
			   //document.getElementsByName("txtStartDate")[i].value;
	           newDataArr.push(newData);
			   //alert("new data--"  +newData);
			
			}
		  }



          for(var m=0;m<newDataArr.length;m++)
			{
				for(var n=0;n<existDataArr.length;n++)
				{
					var searchIndex = existDataArr[n].indexOf("@");
					//alert("searchIndex"  + searchIndex);
					var searchIndex1 = existDataArr[n].indexOf("$");
					//alert("searchIndex1"  + searchIndex1);
					var existDataA=existDataArr[n].substring(searchIndex+1,searchIndex1)
					//alert("existDataA--"  + existDataA);

					alert(existDataA  +"equals"+ newDataArr[m]);

					if(existDataA == newDataArr[m]){
					
					var srlno=existDataArr[n].substring(0,searchIndex);
					alert("srlno--"  +  srlno);
					srlNoArr.push(srlno);
					
					//alert(flag + "m" + m + "n"   +n);
						
					}
				}
			}


			 for(i=0; i < iTr2 -1; i++)
		  {
            
			for(s=0; s < srlNoArr.length; s++)
		  {
			if(i == srlNoArr[s]  && document.getElementsByName("txtEndDate")[s].value == ""){
			  alert("Please enter the end date");
			  var a=srlNoArr[s];
			  alert("value a--" +a);
              document.getElementsByName("txtEndDate")[a-1].style.className="required";
			  document.getElementsByName("txtEndDate")[a-1].style.background="#ffffd3"; 
			  //document.getElementsByName("txtStartDate")[a-1].value="";
			  return false;
			}
			
		  }



		  }


return true;

}

function checkPercentage(me)
{
  if(me.value <= 0)
  {
      me.value="";
      alert("Please enter the correct percentage value!!!");
      return  false;
  }
  return true;
}


</script>

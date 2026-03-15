<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.Calendar,java.text.SimpleDateFormat"%>




<html:html>
<%
 Calendar cal = Calendar.getInstance();
 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
 String now=sdf.format(cal.getTime());
%>
 	<HEAD>
  <html:base/>
	<TITLE><bean:message key="Payroll.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

     <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
     <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
  </HEAD>

<BODY scroll=yes onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>
<html:form action="SupplimentaryPayment" name="frmSupplPayForm" type="FCIPAY.Payroll.WEBTIER.Form.SupplPayForm" scope="session">
<bean:define id="ParentForm" name="frmSupplPayForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>  
<html:hidden property="detailDataChanged" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />

<input type="hidden" name="sysdate" value="<%=now%>">

<TABLE cellSpacing=0 cellPadding=0 border=0 >

	<TR height=30>
		<TD colSpan=11 class=mainHeader height=10>SUPPLEMENTARY PAYMENT</TD>
	</TR>

    <TR>
		<TD class=subHeader colspan=6> Employee Header</TD>
	</TR>
	<TR>
	    <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	</TR>
	<tr>
		<td height="10"></td>
	</tr>

	<table>
			<table border=0>
			<tr>
				<td width="20%" class="labelText"><bean:message key="Payroll.PaySlip.Emp" /></td>
				<td width="35%">
					<html:text  property="txtEmpNo" maxlength="10" size="10" styleClass="required" readonly="true" />

					 <logic:equal property= "screenMode" name= "frmSupplPayForm" value="">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
					 </logic:equal>
					 <logic:equal property= "screenMode" name= "frmSupplPayForm" value="Q">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
					 </logic:equal>
					 <logic:equal property= "screenMode" name= "frmSupplPayForm" value="N">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
					 </logic:equal>
					 <logic:equal property= "screenMode" name= "frmSupplPayForm" value="U">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" >
					 </logic:equal>
				</td>
				<td width="20%" class="labelText"><bean:message key="Payroll.SupplyPay.StaffCode" /></td>
				<td ><html:text property="txtStaffCode" size="10" readonly="true" styleClass="locked" /></td>
			</tr>
			<tr>
				<td class="labelText"><bean:message key="Payroll.SupplyPay.EmpName" /></td>
				<td ><html:text property="txtEmpName" maxlength="10" size="39" styleClass="locked" readonly="true" /></td>
				<td class="labelText"><bean:message key="Payroll.SupplyPay.CPFCode" /></td>
				<td ><html:text property="txtCPFCode" size="10" readonly="true" styleClass="locked" /></td>
			</tr>
			<tr>
				<td class="labelText"><bean:message key="Payroll.SupplyPay.Desg" /></td>
				<td ><html:text property="txtDesg" size="39" readonly="true" styleClass="locked" /></td>
				<td class="labelText"><bean:message key="Payroll.SupplyPay.Catg" /></td>
				<td><html:text property="txtCatg" size="10" readonly="true" styleClass="locked" />
								<html:hidden property="tranId" name="frmSupplPayForm" />
				</td>
			</tr>
			<tr>
				<td class="labelText"><bean:message key="Payroll.SupplyPay.PayScale" /></td>
				<td ><html:text property="txtPayScale" size="10" readonly="true" styleClass="locked" />
								<html:hidden property="txtPayScaleType" name="frmSupplPayForm" />
				</td>
			</tr>
	</table>
	<tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
   <TR>
    <TD>
	
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText>Payment Information<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
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
                            <DIV id=divDtlTable style="height:350px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                <TBODY>
                                     <TR height="20">
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                                              <TD class=tableHeader width="2%">Pay Code</TD>
                                              <TD class=tableHeader width="4%">Pay Code Desc</TD>
                                              <TD class=tableHeader width="3%">YYYYMM</td>
                                              <TD class=tableHeader width="3%">Pay Mode</td>
                                              <TD class=tableHeader width="3%">Amount</td>
                                      </TR>    

                         <logic:iterate id="supplyPay" name="frmSupplPayForm" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.SupplPayBean" indexId="idx"  >
                              <% ++i; %>
                                <logic:notEqual name="supplyPay" property="status" value="D" >

                                   <tr>   <% ++j; %>

                                      <td align=center >
											<html:checkbox property="checked" name="frmSupplPayForm" onclick="checkRecord();" value="false" />
									  </td>

									  <logic:equal name="supplyPay" property="status" value="N" >
										  <td align="right">
												<html:text property="txtPayCode" name="supplyPay" style="width:70%;text-align:right" styleClass="required" onchange="changed(this.alt)" />
												<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  onclick="ShowPayCode(this.alt);"  />&nbsp;&nbsp;
                                          </td>  
										  <td align="left">
												<html:text property="txtPayDesc" name="supplyPay" size="9" readonly="true" styleClass="locked" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" />
										  </td>
                                          <td colspan="1" align="center">
												<html:text property="txtYYMM" name="supplyPay" size="6"  maxlength="6" style="width:30%;text-align:right" styleClass="required" alt="<%=String.valueOf(i)%>" 
													onblur="
														   if(!(chk_YearMonth(this.alt)))
															  {
															  }                                            
													 " 
												    onchange="changed(this.alt)" />
										  </td>
                              
                                          <td colspan="1" align="center">
											   <html:select property="txtPayMode" name="supplyPay" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" >
												<html:option value="">------Please select------</html:option>
												<html:option value="1">1 - Current Payment</html:option>
												<html:option value="2">2 - Current Recovery</html:option>
												<html:option value="4">4 - Arrear Payment</html:option>
												<html:option value="5">5 - Arrear Recovery</html:option>
											   </html:select>                                    
										  </td>

										  <td colspan="1" align="center">
												<html:text property="txtAmt" name="supplyPay" size="6" styleClass="required" style="width:50%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt);checkValue(this.alt)"  onblur="checkValue(this.alt)"/>
										  </td>

									 </logic:equal>

                                     <logic:notEqual name="supplyPay" property="status" value="N" >
										  <td align="right">
												<html:text property="txtPayCode" name="supplyPay" style="width:70%;text-align:right" styleClass="required" onchange="changed(this.alt)" />
												<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  onclick="ShowPayCode(this.alt);"  />&nbsp;&nbsp;
                                          </td>  
										  <td align="left">
												<html:text property="txtPayDesc" name="supplyPay" size="9" readonly="true" styleClass="locked" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" />
										  </td>
                                          <td colspan="1" align="center">
												<html:text property="txtYYMM" name="supplyPay" size="6"  maxlength="6" style="width:30%;text-align:right" styleClass="required" alt="<%=String.valueOf(i)%>" 
													onblur="
														   if(!(chk_YearMonth(this.alt)))
															  {
															  }                                            
													 " 
												    onchange="changed(this.alt)" />
										  </td>
                              
                                          <td colspan="1" align="center">
											   <html:select property="txtPayMode" name="supplyPay" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" >
												<html:option value="">------Please select------</html:option>
												<html:option value="1">1 - Current Payment</html:option>
												<html:option value="2">2 - Current Recovery</html:option>
												<html:option value="4">4 - Arrear Payment</html:option>
												<html:option value="5">5 - Arrear Recovery</html:option>
											   </html:select>                                    
										  </td>

										  <td colspan="1" align="center">
												<html:text property="txtAmt" name="supplyPay"  styleClass="required" size="6" style="width:50%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt);checkValue(this.alt)" onblur="checkValue(this.alt)" />
										  </td>

                                    </logic:notEqual>


                                       <html:hidden property="itemChecked" name="supplyPay" />
                                       <html:hidden property="status" name="supplyPay" />
                                       <html:hidden property="detailId" name="supplyPay" />
									</tr>
                           </logic:notEqual>

                                  <logic:equal name="supplyPay" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmSupplPayForm" value="notchecked" /></td>
                                       <td ><html:hidden property="txtPayCode" name="supplyPay" /></td>
                                       <td ><html:hidden property="txtPayDesc" name="supplyPay" /></td>
                                       <td ><html:hidden property="txtYYMM" name="supplyPay" /></td>
                                       <td ><html:hidden property="txtPayMode" name="supplyPay" /></td>
                                       <td ><html:hidden property="txtAmt" name="supplyPay" /></td>
                                       <html:hidden property="itemChecked" name="supplyPay" />
                                       <html:hidden property="status" name="supplyPay" />
                                       <html:hidden property="detailId" name="supplyPay" />
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
										<td colspan=11>	
											<jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
										</TD> 
									</TR>
								  </TBODY>
                              </TABLE>

                             </TD>
                            </tr>

							<TR>
								<TD>
									<TABLE cellspacing="0" cellPadding="0">
										 <TBODY>
											  <TR>
												<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
												<td bgcolor="#4682B4" nowrap class=actTabText>&nbsp;&nbsp;&nbsp;&nbsp;<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
												<td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
												<td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
												<td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
											  </TR>
											   <TR>
												  <TD height="10" colspan="5"></TD>
											   </TR>

											  <TR>
												<TD colspan="11">
												  <table border=0>
													<tr>
														<td width="15%" class=labelText>CPF Deduction</td>
														<td align="left" width="15%">
															<html:text property="txtCPFAuto" name="frmSupplPayForm" styleClass="locked" style="text-align:right" size="10" readonly="true"/>
														</td> 

														<td width="15%" class=labelText>Invoice No</td>
														<td align="left" width="15%">
															<html:text property="txtInvoice" styleClass="locked" name="frmSupplPayForm" style="text-align:right" size="20" readonly="true"/>
														</td> 

														<td width="15%" class=labelText>Income Tax</td>
														<td align="left" width="15%">
														<logic:equal name="frmSupplPayForm" property="txtInvoice" value="" >
															<html:text property="txtIncomeTax" name="frmSupplPayForm" style="text-align:right" size="10" onchange="incmTaxchanged(1)" />
														</logic:equal>
														<logic:notEqual name="frmSupplPayForm" property="txtInvoice" value="" >
															<html:text property="txtIncomeTax" name="frmSupplPayForm" styleClass="locked" readonly="true" style="text-align:right" size="10" onchange="incmTaxchanged(1)" />
														</logic:notEqual>
															<html:hidden property="delTranId" name="frmSupplPayForm" />
															
														</td> 
													</tr>

													<tr>
														<td class=labelText>Net Amount Payable</td>
														<td align="left" colspan="5">
															<html:text property="txtNetAmt" name="frmSupplPayForm" styleClass="locked" style="text-align:right" size="10" readonly="true"/>
														</td> 
                                                                                                                <td class=labelText>Pension Deduction</td>
                                                                                                                 <td align="left" colspan="5">
                                                                                                                        <html:text property="txtPenAmt" name="frmSupplPayForm" styleClass="locked" style="text-align:right" size="20" readonly="true"/>
                                                                                                                </td>

													</tr>
												  
												  </table>
												<TD>
											  </TR>

										 </TBODY>
									</TABLE>
								</TD>
							</TR>
							<tr>
								<td height="10"></td>					
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
           <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />

           <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
            <% if(smode.equals(new String("U"))) {%> 
            Update Mode
           <%} else if(smode.equals(new String("N"))) {  %>
            New Mode
           <%} else if(smode.equals(new String("Q"))) {  %>
            Query Mode
           <%}  %>
           </td> 
          
           <td align=center bgcolor=#4682b4 width="35%"></td>
           <td bgcolor=#4682b4><html:button value='Send Invoice'  onclick="sendInv()" property="butSendInv" styleClass="bottomBarText" /></td>
          <td bgcolor=#4682b4><html:button value='Cancel Invoice'  onclick="cancelInv()" property="butCancelInv" styleClass="bottomBarText" /></td>

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

<html:hidden property="screenMode" name="frmSupplPayForm"  />
<html:hidden property="headerPrimaryKey" name="frmSupplPayForm" />
<html:hidden property="loginLocCode" name="frmSupplPayForm"  />
<html:hidden name="frmSupplPayForm"  property="screenName" value="SupplPaymentScreen" />
<html:hidden name="frmSupplPayForm"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmSupplPayForm"  />
<html:hidden property="lovKey" name="frmSupplPayForm"  />
<html:hidden property="txtFields" name="frmSupplPayForm"  />   
<html:hidden property="txtSearchFields" name="frmSupplPayForm"  />
<html:hidden property="txtDisplayFields" name="frmSupplPayForm"  />
<html:hidden property="txtIndex" name="frmSupplPayForm"  />
<html:hidden property="txtInputField" name="frmSupplPayForm"  />
<html:hidden property="userPageRequested" name="frmSupplPayForm"  />
<html:hidden property="pageRequested" name="frmSupplPayForm"  />
<html:hidden property="positionRequested" name="frmSupplPayForm" />
<html:hidden property="userPositionRequested" name="frmSupplPayForm" />
<html:hidden property="totalDetailRecord" name="frmSupplPayForm"  />
<html:hidden property="userBtn" name="frmSupplPayForm"  />
<html:hidden property="delUpTran" name="frmSupplPayForm"  />


<input type="hidden" name="queryParam" />

</html:form>


</body>
</html:html>


<script language="javascript">

function lfnLoad()
{
  var screenmode = document.all.screenMode.value;
  var vbtnflg = document.all.buttonFlag.value;
  var btnExe = document.all.userBtn.value ;
  //alert("screenmode=="+screenmode)
  //alert("button flag=="+vbtnflg)
  if(screenmode == '')
  {
      doQueryMode();
  }  
  if(screenmode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }
  if(screenmode=='Q')
  {
	 document.all.butGetDetail.disabled="disabled";
     document.all.butInsert.disabled="disabled";
  } 
  if(screenmode=='U')
  {
        if(vbtnflg == "IN") {
		    document.all.butInsertMode.disabled="true";    
			document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
			document.all.butInsert.disabled="";
			document.all.butGetDetail.disabled="disabled";
		}
		else if(vbtnflg == "SV") {
			populateData();
			document.all.butInsert.disabled="disabled";
			document.all.butGetDetail.disabled="disabled";
		}
		else if(btnExe == "EX") {
			document.all.butInsert.disabled="";
			document.all.butGetDetail.disabled="";
			//document.getElementById("txtIncomeTax").disabled='';
		}
		else {
			document.all.butInsert.disabled="";
			document.all.butGetDetail.disabled="";
		}
        document.all.butDelete.disabled="disabled";

  }

  menuHandling(screenmode);

  if(document.all.userBtn.value == 'SI') populateData();

  if(frmSupplPayForm.txtInvoice.value != ""){
	  document.all.hdnEmpLbrFlag.value='V';
	  document.all.butSendInv.disabled="true";
	  disable();
  }

  if(document.all.hdnEmpLbrFlag.value=='V')
  {
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      document.all.butInsert.disabled="true";
   }
 }

function enable()
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
		document.getElementsByName("txtPayCode")[i].disabled=true;
		document.getElementsByName("txtPayDesc")[i].disabled=true;
		document.getElementsByName("txtYYMM")[i].disabled=true;
		document.getElementsByName("txtPayMode")[i].disabled=true;
		document.getElementsByName("txtAmt")[i].disabled=true;
  }
 }

function disable(){
	 var oTable = document.getElementById("Detail");
	  if(oTable == null)
	  {
		return;
	  }
	  var iTr2 = oTable.rows.length;
	  var i = 0;
	  for(i=0; i < iTr2 -1; i++)
	  {
			document.getElementsByName("txtPayCode")[i].disabled=true;
			document.getElementsByName("txtPayDesc")[i].disabled=true;
			document.getElementsByName("txtYYMM")[i].disabled=true;
			document.getElementsByName("txtPayMode")[i].disabled=true;
			document.getElementsByName("txtAmt")[i].disabled=true;
	  }
 }

function populateData(){
	var tempArr = new Array();
	var hdrPrmKey = frmSupplPayForm.headerPrimaryKey.value;
	if(hdrPrmKey != ""){
		tempArr = (hdrPrmKey).split(",");
		frmSupplPayForm.txtCPFAuto.value = tempArr[0];
		frmSupplPayForm.txtIncomeTax.value = tempArr[1];
		frmSupplPayForm.txtInvoice.value = (tempArr[2]=="0")?"":tempArr[2];
		frmSupplPayForm.delTranId.value = tempArr[3];
		frmSupplPayForm.txtNetAmt.value = tempArr[4];
                frmSupplPayForm.txtPenAmt.value = tempArr[5]
	}
}

function doBaseAddRow()
{
  if(mandatory_Check("frmSupplPayForm"))
  {
	frmSupplPayForm.detailDataChanged.value = "false";
    if(document.all.userBtn.value == 'EX') document.all.buttonFlag.value = '';
	else document.all.buttonFlag.value='IN';
    document.all.screenMode.value='U';
	document.forms[0].action = "../../../SupplimentaryPaymentAddRowAction.do";
	document.forms[0].submit();
  }
  else
  {
	  return false;
  }
}

function changed(val)
{
    frmSupplPayForm.detailDataChanged.value = "true";
    if(document.getElementsByName("status")[val-1].value=='Q')
    {
      document.getElementsByName("status")[val-1].value='U';
    }
}

function incmTaxchanged(val)
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}

    frmSupplPayForm.detailDataChanged.value = "true";
	var iTr2 = oTable.rows.length;
	if (iTr2 > 1){
		if(document.getElementsByName("status")[val-1].value=='Q')
		{
		  document.getElementsByName("status")[val-1].value='U';
		}
	}
}

function SaveRecord()
{
  if(mandatory_Check("frmSupplPayForm"))
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
		if (document.getElementsByName("status")[i].value == 'D')
		   frmSupplPayForm.detailDataChanged.value = "true";
	}    

  frmSupplPayForm.headerPrimaryKey.value = "";

  if(iTr2 > 1)
  {
	  var trnid = document.getElementById("tranId").value;
	  if(trnid == "") frmSupplPayForm.delUpTran.value = document.getElementById("delTranId").value; //for deleting & updating
	  else frmSupplPayForm.delUpTran.value = trnid;

	  document.all.buttonFlag.value='SV';
	  document.all.userBtn.value = 'EX'; 
	  frmSupplPayForm.headerFields.value = "false";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	  frmSupplPayForm.action = "../../../SupplimentaryPaymentSaveAction.do";
	  frmSupplPayForm.submit();
  }
  else 
  {
	  return false;
  }
}
 else
  {
	//disable();
    return false;
  }
}

function doQueryMode()
{
  document.all.screenMode.value = "Q";
  frmSupplPayForm.action="../../../SupplimentaryPaymentQueryMode.do";
  frmSupplPayForm.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value = '';
  document.all.userBtn.value = ''; 
  frmSupplPayForm.action="../../../SupplimentaryPaymentNewMode.do"
  frmSupplPayForm.submit();
}

function getHeaderRecord()
{
	var empno=document.getElementById("txtEmpNo");
	if(empno.value!=""){
		document.all.userBtn.value='EX';
		frmSupplPayForm.detailDataChanged.value = "false";
		frmSupplPayForm.action="../../../SupplimentaryPaymentGetHeaderAction.do"
		frmSupplPayForm.submit();
	}else{
		alert("Enter Employee No.");
		empno.focus();
		return false;
	}
}

function GetDetail()
{
	
	var empno=document.getElementById("txtEmpNo");
	 document.all.buttonFlag.value='';
	if(empno.value!=""){
		  document.all.screenMode.value='U'; 
		  frmSupplPayForm.headerPrimaryKey.value = "";
		  frmSupplPayForm.action="../../../SupplimentaryPaymentDetailAction.do";
		  frmSupplPayForm.submit();
	}else{
		alert("Enter Employee No.");
		empno.focus();
		return false;
	}
}
 
function doRefresh()
{
  frmSupplPayForm.action="../../../SupplimentaryPaymentRefresh.do"
  frmSupplPayForm.submit();
}
     
function doBaseDelRow()
{
  //enable();
  var invoice = document.getElementById("txtInvoice").value;
  //alert(invoice)
  if(invoice == ""){
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
		if(document.getElementsByName("checked")[i].checked)
		{
		  //if(document.getElementsByName("detailId")[i].value=='')
			document.getElementsByName("itemChecked")[i].value = "Y";
		  //else
			//strRecList=strRecList+(i+1)+",";
		}
		/*else
		{
			document.getElementsByName("status")[i].value = "Q";
		}*/
	  }
	
	  /*if(strRecList!='')
	  {
		alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
	  } */  
	  
      
	  document.all.userBtn.value ='DEL'
	  document.all.buttonFlag.value='';
	  document.forms[0].action = "../../../SupplimentaryPaymentDeleteRowAction.do";
	  document.forms[0].submit();
  }else{
	  alert("You can not Delete the Record. Invoice is already generated");
  }
}

function JumpDetail()
{
    frmSupplPayForm.userPageRequested.value = 1*frmSupplPayForm.newPageRequested.value ;
    frmSupplPayForm.action = "../../../SupplimentaryPaymentNextDetailAction.do";
    frmSupplPayForm.submit();

}

function doBasePrevDetail()
{
    frmSupplPayForm.userPageRequested.value = 1*frmSupplPayForm.pageRequested.value - 1;
    frmSupplPayForm.action = "../../../SupplimentaryPaymentNextDetailAction.do";
    frmSupplPayForm.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmSupplPayForm.userPageRequested.value = 1*frmSupplPayForm.pageRequested.value + 1;
    frmSupplPayForm.action = "../../../SupplimentaryPaymentNextDetailAction.do";
    frmSupplPayForm.submit();
}

function doGetNextHeader()
{
	document.all.buttonFlag.value='';
    frmSupplPayForm.userPositionRequested.value = 1*frmSupplPayForm.positionRequested.value + 1;
    frmSupplPayForm.action="../../../SupplimentaryPaymentGetNextHeader.do";
    frmSupplPayForm.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmSupplPayForm.userPositionRequested.value = frmSupplPayForm.positionRequested.value - 1;
  frmSupplPayForm.action = "../../../SupplimentaryPaymentGetNextHeader.do";
  frmSupplPayForm.submit();
}

function JumpHeader()
{
    document.all.flagIda.value="false";
    document.all.flagCda.value="false";
    frmSupplPayForm.userPositionRequested.value = 1*frmSupplPayForm.newPositionRequested.value;
    frmSupplPayForm.action = "../../../SupplimentaryPaymentGetNextHeader.do";
    frmSupplPayForm.submit();
}

function ShowLovEmp(){
	frmSupplPayForm.lovKey.value = "SupplementaryPayment" +frmSupplPayForm.screenName.value + frmSupplPayForm.screenMode.value;
    frmSupplPayForm.queryParam.value="txtSiteID="+ frmSupplPayForm.loginLocCode.value +",hdnEmpLbrFlag="+frmSupplPayForm.hdnEmpLbrFlag.value ; 
	frmSupplPayForm.txtSearchFields.value = "Payroll.SupplyPay.EmpNo,Payroll.SupplyPay.EmpName,Payroll.SupplyPay.CPFCode";
	frmSupplPayForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCPFCode,txtStaffCode,txtDesg,txtPayScale,txtPayScaleType,txtCatg";
	frmSupplPayForm.txtIndex.value = 0;
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmSupplPayForm');
	return true;
}

function ShowPayCode(i)
{
    frmSupplPayForm.lovKey.value = "PaycodeAgencycodePayCode" + frmSupplPayForm.screenName.value + frmSupplPayForm.screenMode.value;
    frmSupplPayForm.queryParam.value = "hdnEmpLbrFlag="+frmSupplPayForm.hdnEmpLbrFlag.value+",screenName="+frmSupplPayForm.screenName.value+",screenMode="+frmSupplPayForm.screenMode.value+",txtSiteID="+frmSupplPayForm.loginLocCode.value;   // added by swapnendu Dt 07 Sep 2012.
    frmSupplPayForm.txtDisplayFields.value = "txtPayCode,txtPayDesc";
    frmSupplPayForm.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Paycode,Payroll.PaycodeVSAgencycode.PayDesc";
    frmSupplPayForm.txtIndex.value = i;
    frmSupplPayForm.txtInputField.value ="";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmSupplPayForm');
    return true;
}

function chk_YearMonth(i)
{
	var yearMObj = document.getElementsByName("txtYYMM")[i-1];
	var yearM = yearMObj.value;
	var arr = new Array();
	var currDate = frmSupplPayForm.sysdate.value;
	arr = currDate.split("/");
	var curr_month = arr[1];
	var curr_year = arr[2];
	if(yearM!=""){
       var month =  parseInt(yearM.substring(4,6),10);
       var year =  parseInt(yearM.substring(0,4),10);
		if (num_Check(yearM,1))
		 {                                   
			if (yearM.length != 6)
			{
			    alert("Year Month should be a Six digit Number");
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;            
			    return false;
			}
		    if(month < 1 || month > 12)
		    {
				alert("Month should be Within 1 to 12");
				document.getElementById("txtYYMM").focus();                     
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;                    
				return false;
		    }
			if(year == curr_year){
				if(month > curr_month){
					alert("Payment can not be done in advance. Check the month");
					event.srcElement.select();
					event.srcElement.focus();
					event.returnValue=false;            
					return false;
				}
			}
			if(year > curr_year){
				alert("Year should not exceed Current Year");
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;            
				return false;
			}
			return true;
		 }
		 else
		 {
			  document.getElementById("txtYYMM").select();
			  return false;
		 }
    }
}

function sendInv()
{
    if(!mandatory_Check("frmSupplPayForm"))
    {
      return false;
    }
	if(confirm("Do you want to send Invoice")){
		document.all.userBtn.value = 'SI'
		if(frmSupplPayForm.tranId.value == "") frmSupplPayForm.tranId.value = document.getElementById("delTranId").value;
        document.getElementById("butSendInv").disabled="true";
        frmSupplPayForm.action="../../../SupplimentaryPaymentSendInv.do"
		frmSupplPayForm.submit();
	}
}

function cancelInv()
{
   if(!mandatory_Check("frmSupplPayForm"))
    {
      return false;
    }
	if(confirm("Do you want to cancel Invoice")){
		//document.all.userBtn.value = 'SI'
		 document.getElementById("butCancelInv").disabled="true";
        frmSupplPayForm.action="../../../CancelSuppPaymentInv.do"
		frmSupplPayForm.submit();
	}
}
//added by geetika to validate only positive integer

function checkValue(vall)
{
    val=document.getElementsByName("txtAmt")[vall-1].value;
  
    var i;
	  s = val.toString();
    var t=0;
    
    for (i = 0; i < s.length; i++)
    {
         var c = s.charAt(i);
         if(c != '0')
         {
            t='1';
            
         }
         if (isNaN(c)) 
	       {
            alert("Amount should be a positive integer");
             document.getElementsByName("txtAmt")[vall-1].value='';;
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;    
            return false;
         }
    }
 
    if(t=='0'&&  document.getElementsByName("txtAmt")[vall-1].value !='')
    {
            alert("Amount can not be 0");
            document.getElementsByName("txtAmt")[vall-1].value='';
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;    
            return false;

    
    }
    return true;
}


</script>

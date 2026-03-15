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
<html:form  action="PLIAdjustmentReport" name="frmPLIAdjustForm" type="FCIPAY.Payroll.WEBTIER.Form.PLIReportAdjustmentForm" scope="session">
<bean:define id="ParentForm" name="frmPLIAdjustForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>  
<html:hidden property="detailDataChanged" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />

<input type="hidden" name="sysdate" value="<%=now%>">

<TABLE cellSpacing=0 cellPadding=0 border=0 >

	<TR height=30>
		<TD colSpan=11 class=mainHeader height=10>PLI Adjustment Report</TD>
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

					 <logic:equal property= "screenMode" name= "frmPLIAdjustForm" value="">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
					 </logic:equal>
					 <logic:equal property= "screenMode" name= "frmPLIAdjustForm" value="Q">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
					 </logic:equal>
					 <logic:equal property= "screenMode" name= "frmPLIAdjustForm" value="N">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
					 </logic:equal>
					 <logic:equal property= "screenMode" name= "frmPLIAdjustForm" value="U">
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
				<html:hidden property="tranId" name="frmPLIAdjustForm" />
				</td>
			</tr>
			<tr>
				<td class="labelText"><bean:message key="Payroll.SupplyPay.PayScale" /></td>
				<td ><html:text property="txtPayScale" size="10" readonly="true" styleClass="locked" />
                                <html:hidden property="txtPayScaleType" name="frmPLIAdjustForm" />
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
                                              <TD class=tableHeader width="3%">YYYYMM</td>
                                              <TD class=tableHeader width="3%">Pay Mode</td>
                                              <TD class=tableHeader width="3%">Amount</td>
                                      </TR>    

                         <logic:iterate id="supplyPay" name="frmPLIAdjustForm" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.PLIReportBean" indexId="idx"  >
                              <% ++i; %>
                                <logic:notEqual name="supplyPay" property="status" value="D" >

                                   <tr>   <% ++j; %>

                                      <td align=center >
											<html:checkbox property="checked" name="frmPLIAdjustForm" onclick="checkRecord();" value="false" />
									  </td>

									  <logic:equal name="supplyPay" property="status" value="N" >
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
												<html:option value="1">1 - Payment</html:option>
												<html:option value="2">2 - Recovery</html:option>
                                                                                           </html:select>                                    
										  </td>

										  <td colspan="1" align="center">
												<html:text property="txtAmt" name="supplyPay" size="6" styleClass="required" style="width:50%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt);checkValue(this.alt)"  onblur="checkValue(this.alt)"/>
										  </td>

									 </logic:equal>

                                     <logic:notEqual name="supplyPay" property="status" value="N" >
										  
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
												<html:option value="1">1 - Payment</html:option>
												<html:option value="2">2 - Recovery</html:option>
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
                                       <td ><html:hidden property="checked" name="frmPLIAdjustForm" value="notchecked" /></td>
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

<html:hidden property="screenMode" name="frmPLIAdjustForm"  />
<html:hidden property="headerPrimaryKey" name="frmPLIAdjustForm" />
<html:hidden property="loginLocCode" name="frmPLIAdjustForm"  />
<html:hidden name="frmPLIAdjustForm"  property="screenName" value="PLIAdjustmentScreen" />
<html:hidden name="frmPLIAdjustForm"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmPLIAdjustForm"  />
<html:hidden property="lovKey" name="frmPLIAdjustForm"  />
<html:hidden property="txtFields" name="frmPLIAdjustForm"  />   
<html:hidden property="txtSearchFields" name="frmPLIAdjustForm"  />
<html:hidden property="txtDisplayFields" name="frmPLIAdjustForm"  />
<html:hidden property="txtIndex" name="frmPLIAdjustForm"  />
<html:hidden property="txtInputField" name="frmPLIAdjustForm"  />
<html:hidden property="userPageRequested" name="frmPLIAdjustForm"  />
<html:hidden property="pageRequested" name="frmPLIAdjustForm"  />
<html:hidden property="positionRequested" name="frmPLIAdjustForm" />
<html:hidden property="userPositionRequested" name="frmPLIAdjustForm" />
<html:hidden property="totalDetailRecord" name="frmPLIAdjustForm"  />
<html:hidden property="userBtn" name="frmPLIAdjustForm"  />
<html:hidden property="delUpTran" name="frmPLIAdjustForm"  />


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

  if(frmPLIAdjustForm.txtInvoice.value != ""){
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
			document.getElementsByName("txtYYMM")[i].disabled=true;
			document.getElementsByName("txtPayMode")[i].disabled=true;
			document.getElementsByName("txtAmt")[i].disabled=true;
	  }
 }

function populateData(){
	var tempArr = new Array();
	var hdrPrmKey = frmPLIAdjustForm.headerPrimaryKey.value;
	if(hdrPrmKey != ""){
		tempArr = (hdrPrmKey).split(",");
		frmPLIAdjustForm.delTranId.value = tempArr[0];
                frmSupplPayForm.txtNetAmt.value = tempArr[1];
                frmSupplPayForm.txtInvoice.value = (tempArr[2]=="0")?"":tempArr[2];
        }
}

function doBaseAddRow()
{
  if(mandatory_Check("frmPLIAdjustForm"))
  {
	frmPLIAdjustForm.detailDataChanged.value = "false";
    if(document.all.userBtn.value == 'EX') document.all.buttonFlag.value = '';
	else document.all.buttonFlag.value='IN';
    document.all.screenMode.value='U';
	document.forms[0].action = "../../../PLIAdjustmentReportAddRowAction.do";
	document.forms[0].submit();
  }
  else
  {
	  return false;
  }
}

function changed(val)
{
    frmPLIAdjustForm.detailDataChanged.value = "true";
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

    frmPLIAdjustForm.detailDataChanged.value = "true";
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
  if(mandatory_Check("frmPLIAdjustForm"))
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
		   frmPLIAdjustForm.detailDataChanged.value = "true";
	}    

  frmPLIAdjustForm.headerPrimaryKey.value = "";

  if(iTr2 > 1)
  {
	  var trnid = document.getElementById("tranId").value;
	 // if(trnid == "") frmPLIAdjustForm.delUpTran.value = document.getElementById("delTranId").value; //for deleting & updating
	 // else frmPLIAdjustForm.delUpTran.value = trnid;
	  document.all.buttonFlag.value='SV';
	  document.all.userBtn.value = 'EX'; 
	  frmPLIAdjustForm.headerFields.value = "false";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	  frmPLIAdjustForm.action = "../../../PLIAdjustmentReportSaveAction.do";
	  frmPLIAdjustForm.submit();
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
  frmPLIAdjustForm.action="../../../PLIAdjustmentQueryMode.do";
  frmPLIAdjustForm.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value = '';
  document.all.userBtn.value = ''; 
  frmPLIAdjustForm.action="../../../PLIAdjustmentReportNewMode.do"
  frmPLIAdjustForm.submit();
}

function getHeaderRecord()
{
	var empno=document.getElementById("txtEmpNo");
	if(empno.value!=""){
		document.all.userBtn.value='EX';
		frmPLIAdjustForm.detailDataChanged.value = "false";
		frmPLIAdjustForm.action="../../../PLIAdjustmentReportGetHeaderAction.do"
		frmPLIAdjustForm.submit();
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
		  frmPLIAdjustForm.headerPrimaryKey.value = "";
		  frmPLIAdjustForm.action="../../../PLIAdjustmentReportDetailAction.do";
		  frmPLIAdjustForm.submit();
	}else{
		alert("Enter Employee No.");
		empno.focus();
		return false;
	}
}
 
function doRefresh()
{
  frmPLIAdjustForm.action="../../../PLIAdjustmentReportRefresh.do"
  frmPLIAdjustForm.submit();
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
	  var strRecList='';
	  
	  for(i=0; i < iTr2 -1; i++)
	  {
		if(document.getElementsByName("checked")[i].checked)
		{
			document.getElementsByName("itemChecked")[i].value = "Y";
		}
	  }
	  document.all.userBtn.value ='DEL'
	  document.all.buttonFlag.value='';
	  document.forms[0].action = "../../../PLIAdjustmentReportDeleteRowAction.do";
	  document.forms[0].submit();
}

function JumpDetail()
{
    frmPLIAdjustForm.userPageRequested.value = 1*frmPLIAdjustForm.newPageRequested.value ;
    frmPLIAdjustForm.action = "../../../PLIAdjustmentReportNextDetailAction.do";
    frmPLIAdjustForm.submit();

}

function doBasePrevDetail()
{
    frmPLIAdjustForm.userPageRequested.value = 1*frmPLIAdjustForm.pageRequested.value - 1;
    frmPLIAdjustForm.action = "../../../SupplimentaryPaymentNextDetailAction.do";
    frmPLIAdjustForm.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmPLIAdjustForm.userPageRequested.value = 1*frmPLIAdjustForm.pageRequested.value + 1;
    frmPLIAdjustForm.action = "../../../SupplimentaryPaymentNextDetailAction.do";
    frmPLIAdjustForm.submit();
}

function doGetNextHeader()
{
	document.all.buttonFlag.value='';
    frmPLIAdjustForm.userPositionRequested.value = 1*frmPLIAdjustForm.positionRequested.value + 1;
    frmPLIAdjustForm.action="../../../SupplimentaryPaymentGetNextHeader.do";
    frmPLIAdjustForm.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmPLIAdjustForm.userPositionRequested.value = frmPLIAdjustForm.positionRequested.value - 1;
  frmPLIAdjustForm.action = "../../../SupplimentaryPaymentGetNextHeader.do";
  frmPLIAdjustForm.submit();
}

function JumpHeader()
{
    document.all.flagIda.value="false";
    document.all.flagCda.value="false";
    frmPLIAdjustForm.userPositionRequested.value = 1*frmPLIAdjustForm.newPositionRequested.value;
    frmPLIAdjustForm.action = "../../../SupplimentaryPaymentGetNextHeader.do";
    frmPLIAdjustForm.submit();
}

function ShowLovEmp(){
	frmPLIAdjustForm.lovKey.value = "PLIAdjustmentReport" +frmPLIAdjustForm.screenName.value + frmPLIAdjustForm.screenMode.value;
    frmPLIAdjustForm.queryParam.value="txtSiteID="+ frmPLIAdjustForm.loginLocCode.value +",hdnEmpLbrFlag="+frmPLIAdjustForm.hdnEmpLbrFlag.value ; 
	frmPLIAdjustForm.txtSearchFields.value = "Payroll.SupplyPay.EmpNo,Payroll.SupplyPay.EmpName,Payroll.SupplyPay.CPFCode";
	frmPLIAdjustForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCPFCode,txtStaffCode,txtDesg,txtPayScale,txtPayScaleType,txtCatg";
	frmPLIAdjustForm.txtIndex.value = 0;
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmPLIAdjustForm');
	return true;
}

function ShowPayCode(i)
{
    frmPLIAdjustForm.lovKey.value = "PaycodeAgencycodePayCode" + frmPLIAdjustForm.screenName.value + frmPLIAdjustForm.screenMode.value;
    frmPLIAdjustForm.queryParam.value = "hdnEmpLbrFlag="+frmPLIAdjustForm.hdnEmpLbrFlag.value+",screenName="+frmPLIAdjustForm.screenName.value+",screenMode="+frmPLIAdjustForm.screenMode.value+",txtSiteID="+frmPLIAdjustForm.loginLocCode.value;   // added by swapnendu Dt 07 Sep 2012.
    frmPLIAdjustForm.txtDisplayFields.value = "txtPayCode,txtPayDesc";
    frmPLIAdjustForm.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Paycode,Payroll.PaycodeVSAgencycode.PayDesc";
    frmPLIAdjustForm.txtIndex.value = i;
    frmPLIAdjustForm.txtInputField.value ="";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPLIAdjustForm');
    return true;
}

function chk_YearMonth(i)
{
	var yearMObj = document.getElementsByName("txtYYMM")[i-1];
	var yearM = yearMObj.value;
	var arr = new Array();
	var currDate = frmPLIAdjustForm.sysdate.value;
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

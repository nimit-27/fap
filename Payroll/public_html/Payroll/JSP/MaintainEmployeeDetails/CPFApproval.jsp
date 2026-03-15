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
<BODY onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" scroll=yes >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>
<html:form action="CPFApprovalBaseAction" name="frmCPFApprovalForm" type="FCIPAY.Payroll.WEBTIER.Form.CPFApprovalForm" scope="session">
<bean:define id="ParentForm" name="frmCPFApprovalForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>  
<html:hidden property="detailDataChanged" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<input type="hidden" name="sysdate" value="<%=now%>">

<TABLE cellSpacing=0 cellPadding=0 border=0 >
	<TR height=30>
		<TD colSpan=11 class=mainHeader height=10>CPF APPROVAL/REJECTION</TD>
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
					<logic:equal property= "screenMode" name= "frmCPFApprovalForm" value="Q">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
					</logic:equal>
					<logic:notEqual property= "screenMode" name= "frmCPFApprovalForm" value="Q">
						<logic:equal property= "screenMode" name= "frmCPFApprovalForm" value="N">
							<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmCPFApprovalForm" value="N">
							<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" >
						</logic:notEqual>
					</logic:notEqual>
					<html:text property="txtEmpName" maxlength="10" size="39" styleClass="locked" readonly="true" />
					<html:hidden property="txtCPFCode" name= "frmCPFApprovalForm" />
				</td>
				<td width="20%" class="labelText">Approval Status</td>
				<td>
				<html:select property="txtAppvSts" name="frmCPFApprovalForm">
				<html:option value="P">Pending</html:option> 
				<html:option value="A">Approved</html:option> 
				<html:option value="R">Rejected</html:option> 
				<html:option value="">All</html:option> 
				</html:select>
				</td>
			</tr>
			<tr>
				<td class="labelText">Unit Code</td>
				<td><html:text  property="txtUnitCode" maxlength="10" size="10" styleClass="required" readonly="true" />
				<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovUnit();" >
				<html:text  property="txtUnitDesc"  size="39" styleClass="locked" readonly="true" /></td>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Approval Status<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                            <DIV id=divDtlTable style="height:450px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                <TBODY>
                                     <TR height="20">
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();enableBtn();" /></td>
                                              <TD class=tableHeader width="1%">Sl No.</TD>
                                              <TD class=tableHeader width="1%">Employee Code</TD>
                                              <TD class=tableHeader width="4%">Employee Name</td>
                                              <TD class=tableHeader width="3%">Present Place of Posting</td>
                                              <TD class=tableHeader width="2%">Fps/Eps Number</td>
                                              <TD class=tableHeader width="2%">Old CPF Code</td>
                                              <TD class=tableHeader width="2%">New CPF Code</td>
											  <TD class=tableHeader width="2%">Requested Zone</td>
                                              <TD class=tableHeader width="3%">Requester Name</td>
                                              <TD class=tableHeader width="3%">Reason of Req</td>
                                              <TD class=tableHeader width="2%">Req Initiation Date</td>
											  <TD class=tableHeader width="2%">Req Approved Date</td>
                                              <TD class=tableHeader width="2%">Status</td>
                                              <TD class=tableHeader width="3%">Remark</td>
                                      </TR>    

                         <logic:iterate id="CPFApprove" name="frmCPFApprovalForm" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.CPFApproveBean" indexId="idx"  >
                              <% ++i; %>
                                <logic:notEqual name="CPFApprove" property="status" value="D" >
                                   <tr>   <% ++j; %>
	                                  <td align=center >
											<logic:equal name="CPFApprove" property="txtAppvSts1" value="Approved" >	
												<html:checkbox property="checked" name="frmCPFApprovalForm" disabled="true" onclick="checkRecord();" value="false" />
											</logic:equal>
											<logic:notEqual name="CPFApprove" property="txtAppvSts1" value="Approved" >	
												<logic:equal name="CPFApprove" property="txtAppvSts1" value="Rejected" >
													<html:checkbox property="checked" name="frmCPFApprovalForm" disabled="true" onclick="checkRecord();" value="false" />
												</logic:equal>
												<logic:notEqual name="CPFApprove" property="txtAppvSts1" value="Rejected" >
													
													<html:checkbox property="checked" name="frmCPFApprovalForm"  alt="<%=String.valueOf(i)%>" onclick="checkRecord();enableBtn();" value="false" />
												</logic:notEqual>
											</logic:notEqual>
									  </td>
									  <td><html:text property="txtSrNo" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>"   /></td>  
									  <td><html:text property="txtEmpNo1" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" /></td>  
									  <td><html:text property="txtEmpName1" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>"  /></td>
									  <td><html:text property="txtPOP" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>"  /></td>
									  <td><html:text property="txtFpsNum" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>"  /></td>
									  <td><html:text property="txtOldCpf" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>"  /></td>
									  <td><html:text property="txtNewCpf" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" /></td>
									  <td><html:text property="txtReqZoneDesc" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" /></td>
									  <td><html:text property="txtRequester" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>"  /></td>
									  <td><html:text property="txtReqReason" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>"  /></td>
									  <td><html:text property="txtReqDate" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:center" alt="<%=String.valueOf(i)%>"  /></td>
									  <td><html:text property="txtApprDt" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" /></td>
									  <td><html:text property="txtAppvSts1" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:center" alt="<%=String.valueOf(i)%>" /></td>
									  <td><html:text property="txtRemark" name="CPFApprove" readonly="true" styleClass="locked" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" /></td>
									   <html:hidden property="txtApprId" name="CPFApprove" />
									   <html:hidden property="txtReqZone" name="CPFApprove" />
									   <html:hidden property="txtReqGenFrm" name="CPFApprove" />
                                       <html:hidden property="itemChecked" name="CPFApprove" />
                                       <html:hidden property="status" name="CPFApprove" />
                                       <html:hidden property="detailId" name="CPFApprove" />
									</tr>
                           </logic:notEqual>

                                  <logic:equal name="CPFApprove" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmCPFApprovalForm" value="notchecked" /></td>
                                       <td ><html:hidden property="txtSrNo" name="CPFApprove" /></td>
									   <td ><html:hidden property="txtApprId" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtEmpNo1" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtEmpName1" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtPOP" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtFpsNum" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtOldCpf" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtNewCpf" name="CPFApprove" /></td>
									   <td ><html:hidden property="txtReqZoneDesc" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtRequester" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtReqDate" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtReqReason" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtAppvSts1" name="CPFApprove" /></td>
                                       <td ><html:hidden property="txtRemark" name="CPFApprove" /></td>
									   <html:hidden property="txtReqZone" name="CPFApprove" />
									   <html:hidden property="txtReqGenFrm" name="CPFApprove" />
                                       <html:hidden property="itemChecked" name="CPFApprove" />
                                       <html:hidden property="status" name="CPFApprove" />
                                       <html:hidden property="detailId" name="CPFApprove" />
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
           <td bgcolor=#4682b4><html:button value='Approve' onclick="Approve()" property="butApprove" disabled="true" styleClass="bottomBarText" />
           <html:button value='Reject' onclick="Reject()" property="butReject" disabled="true" styleClass="bottomBarText" /></td>
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

<html:hidden property="screenMode" name="frmCPFApprovalForm"  />
<html:hidden property="headerPrimaryKey" name="frmCPFApprovalForm" />
<html:hidden property="loginLocCode" name="frmCPFApprovalForm"  />
<html:hidden name="frmCPFApprovalForm"  property="screenName" value="CPFApproveScreen" />
<html:hidden name="frmCPFApprovalForm"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmCPFApprovalForm"  />
<html:hidden property="lovKey" name="frmCPFApprovalForm"  />
<html:hidden property="txtFields" name="frmCPFApprovalForm"  />   
<html:hidden property="txtSearchFields" name="frmCPFApprovalForm"  />
<html:hidden property="txtDisplayFields" name="frmCPFApprovalForm"  />
<html:hidden property="txtIndex" name="frmCPFApprovalForm"  />
<html:hidden property="txtInputField" name="frmCPFApprovalForm"  />
<html:hidden property="userPageRequested" name="frmCPFApprovalForm"  />
<html:hidden property="pageRequested" name="frmCPFApprovalForm"  />
<html:hidden property="positionRequested" name="frmCPFApprovalForm" />
<html:hidden property="userPositionRequested" name="frmCPFApprovalForm" />
<html:hidden property="totalDetailRecord" name="frmCPFApprovalForm"  />

<input type="hidden" name="queryParam" />
</html:form>
</body>
</html:html>


<script language="javascript">

function lfnLoad()
{
  var screenmode = document.all.screenMode.value;
  //alert("screenmode=="+screenmode)

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
     document.all.butInsert.disabled="disabled";
  } 
  if(screenmode=='U')
  {
     document.all.butInsert.disabled="disabled";
  } 

  menuHandling(screenmode);
  document.all.butSave.disabled="true";    
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
  document.all.butInsertMode.disabled="true";    
  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    

 }

function doQueryMode()
{
  document.all.screenMode.value = "Q";
  frmCPFApprovalForm.action="../../../CPFApprovalQueryMode.do";
  frmCPFApprovalForm.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value = '';
  document.all.userBtn.value = ''; 
  frmCPFApprovalForm.action="../../../CPFApprovalNewMode.do"
  frmCPFApprovalForm.submit();
}

function getHeaderRecord()
{
	frmCPFApprovalForm.detailDataChanged.value = "false";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

	frmCPFApprovalForm.action="../../../CPFApprovalGetHeaderAction.do"
	frmCPFApprovalForm.submit();
}

function GetDetail()
{
	document.all.screenMode.value='U'; 
	frmCPFApprovalForm.headerPrimaryKey.value = "";
	frmCPFApprovalForm.action="../../../CPFApprovalDetailAction.do";
	frmCPFApprovalForm.submit();
}
 
function doRefresh()
{
  frmCPFApprovalForm.action="../../../CPFApprovalRefresh.do"
  frmCPFApprovalForm.submit();
}

function JumpDetail()
{
    frmCPFApprovalForm.userPageRequested.value = 1*frmCPFApprovalForm.newPageRequested.value ;
    frmCPFApprovalForm.action = "../../../CPFApprovalNextDetailAction.do";
    frmCPFApprovalForm.submit();

}

function doBasePrevDetail()
{
    frmCPFApprovalForm.userPageRequested.value = 1*frmCPFApprovalForm.pageRequested.value - 1;
    frmCPFApprovalForm.action = "../../../CPFApprovalNextDetailAction.do";
    frmCPFApprovalForm.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmCPFApprovalForm.userPageRequested.value = 1*frmCPFApprovalForm.pageRequested.value + 1;
    frmCPFApprovalForm.action = "../../../CPFApprovalNextDetailAction.do";
    frmCPFApprovalForm.submit();
}

function doGetNextHeader()
{
	document.all.buttonFlag.value='';
    frmCPFApprovalForm.userPositionRequested.value = 1*frmCPFApprovalForm.positionRequested.value + 1;
    frmCPFApprovalForm.action="../../../CPFApprovalGetNextHeader.do";
    frmCPFApprovalForm.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmCPFApprovalForm.userPositionRequested.value = frmCPFApprovalForm.positionRequested.value - 1;
  frmCPFApprovalForm.action = "../../../CPFApprovalGetNextHeader.do";
  frmCPFApprovalForm.submit();
}

function JumpHeader()
{
    document.all.flagIda.value="false";
    document.all.flagCda.value="false";
    frmCPFApprovalForm.userPositionRequested.value = 1*frmCPFApprovalForm.newPositionRequested.value;
    frmCPFApprovalForm.action = "../../../SupplimentaryPaymentGetNextHeader.do";
    frmCPFApprovalForm.submit();
}

function ShowLovEmp()
{
	frmCPFApprovalForm.lovKey.value = "CPFApprovalEmp" +frmCPFApprovalForm.screenName.value + frmCPFApprovalForm.screenMode.value;
    frmCPFApprovalForm.queryParam.value="txtSiteID="+ frmCPFApprovalForm.loginLocCode.value +",hdnEmpLbrFlag="+frmCPFApprovalForm.hdnEmpLbrFlag.value ; 
	frmCPFApprovalForm.txtSearchFields.value = "Payroll.SupplyPay.EmpNo,Payroll.SupplyPay.EmpName,Payroll.SupplyPay.CPFCode";
	frmCPFApprovalForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCPFCode";
	frmCPFApprovalForm.txtIndex.value = 0;
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmCPFApprovalForm');
	return true;
}

function ShowLovUnit()
{
	frmCPFApprovalForm.lovKey.value = "CPFApprovalUnit" +frmCPFApprovalForm.screenName.value + frmCPFApprovalForm.screenMode.value;
    frmCPFApprovalForm.queryParam.value="txtSiteID="+ frmCPFApprovalForm.loginLocCode.value ;
	frmCPFApprovalForm.txtSearchFields.value = "Payroll.Site.LocId,Payroll.Site.LocName";
	frmCPFApprovalForm.txtDisplayFields.value = "txtUnitCode,txtUnitDesc";
	frmCPFApprovalForm.txtIndex.value = 0;
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmCPFApprovalForm');
	return true;
}
  function checkRecord()
  {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
      var fl = 0;
      for(i=0; i < iTr2 - 1; i++)
      {
        if(document.getElementsByName("checked")[i].checked)
        {
			document.getElementsByName("txtRemark")[i].readOnly="";
			document.getElementsByName("txtRemark")[i].style.background="white";
			document.getElementsByName("txtRemark")[i].className="optional";
        }
		else
		{
			document.getElementsByName("txtRemark")[i].readOnly="true";
			document.getElementsByName("txtRemark")[i].style.background="#e0e0e0";
			document.getElementsByName("txtRemark")[i].className="locked";
			document.getElementsByName("txtRemark")[i].value="";
		}
      }
      if(fl == 0)   
      {      
          document.all.butApprove.disabled="true";
    	  document.all.butReject.disabled="true";
          document.all.butDelete.disabled="true";
          
      }
	  
  }

function enableBtn()
{
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var count=0;
	var rejCount=0;
	for(i=0; i < iTr2 - 1; i++)
	{
		if(document.getElementsByName("checked")[i].checked)
		{
			//added by nand on 18 Jun 2013
			/*if(document.getElementsByName("txtReqReason")[i].value=="NEW EMPLOYEE CREATION")
			{
				rejCount++;
				count++;
			}
			//end of addition by nand on 18 Jun 2013
			else
			{
                                rejCount++;
				count++;
			}*/ 
                        //Commented By Amresh on 17 03 2023
                        rejCount++;
                        count++;
		}
	}
	if(count>0)
	{
		document.all.butApprove.disabled="";
	}
	else
	{
		document.all.butApprove.disabled="true";
		
	}
	if(rejCount>0)
	{
		document.all.butReject.disabled="";
	}
	else
	{
		document.all.butReject.disabled="true";
	}
}

function Approve()
{
	if(confirm("Do you want to Approve request for the selected record(s)."))
	{
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
      for(i=0; i < iTr2 - 1; i++)
      {

        if(document.getElementsByName("checked")[i].checked)
        {
			document.getElementsByName("itemChecked")[i].value = "Y";
            document.all.butApprove.disabled="true";
			document.all.butReject.disabled="true";
        }
      }
		frmCPFApprovalForm.detailDataChanged.value = "true";
		frmCPFApprovalForm.action = "../../../CPFApproveAction.do?param=approve";
		frmCPFApprovalForm.submit();
	}
	return false;
}

function Reject()
{
	if(confirm("Do you want to Reject request for the selected record(s)."))
	{
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
      for(i=0; i < iTr2 - 1; i++)
      {

        if(document.getElementsByName("checked")[i].checked)
        {
			document.getElementsByName("itemChecked")[i].value = "Y";
            document.all.butApprove.disabled="true";
			document.all.butReject.disabled="true";
        }
      }
		frmCPFApprovalForm.detailDataChanged.value = "true";
		frmCPFApprovalForm.action = "../../../CPFApproveAction.do?param=reject";
		frmCPFApprovalForm.submit();
	}
	return false;
}
</script>



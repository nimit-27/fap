<%@ page contentType="text/html;charset=windows-1252"%>
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
	<TITLE><bean:message key="Payroll.ChangeZone.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
     <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
     <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
  </HEAD>
<BODY scroll=yes onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>
<html:form action="EmpbasicHistAction" name="frmEmpBasicHistForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpBasicHistForm" scope="session">
<bean:define id="ParentForm" name="frmEmpBasicHistForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>  
<html:hidden property="detailDataChanged" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<input type="hidden" name="sysdate" value="<%=now%>">

<TABLE cellSpacing=0 cellPadding=0 border=0 >

	<TR height=30>
		<TD colSpan=11 class=mainHeader height=10>Employee Basic Revision History</TD>
	</TR>

    <TR>
		<TD class=subHeader colspan=6>Employee Header</TD>
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
				<td width="20%" class="labelText"><bean:message key="Payroll.ChangeZone.empno" /></td>
				<td width="35%">
					<html:text property="txtEmpNo" maxlength="10" size="10" styleClass="required" readonly="true" />
					 <logic:equal property= "screenMode" name= "frmEmpBasicHistForm" value="">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowEmpNum();" >
					 </logic:equal>
					 <logic:equal property= "screenMode" name= "frmEmpBasicHistForm" value="Q">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowEmpNum();" >
					 </logic:equal>
					 <logic:equal property= "screenMode" name= "frmEmpBasicHistForm" value="N">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowEmpNum();" >
					 </logic:equal>
					 <logic:equal property= "screenMode" name= "frmEmpBasicHistForm" value="U">
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" >
					 </logic:equal>
					<html:text property="txtEmpName" name="frmEmpBasicHistForm" size="30" styleClass="locked" readonly="true" />
					
					<input type="hidden" name="txtSiteCode" ></input>
					<input type="hidden" name="txtSiteDesc"></input>
					<input type="hidden" name="txtUserFlag"></input>
				</td>
				 <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td> 
				<td>
					<html:text property="txtCpfCode" name="frmEmpBasicHistForm" size="30" styleClass="locked" readonly="true" />
				</td>
                </tr>
                <tr>
                <td class=labelText  ><bean:message key="Payroll.EmpInfo.txtDesig" /> </td> 
                <td>
                <html:text property="txtDesig" name="frmEmpBasicHistForm" size="30" styleClass="locked" readonly="true" />
                </td>
                <td class=labelText  ><bean:message key="Payroll.EmpInfo.dob" /> </td> 
                <td>
                <html:text property="txtDob" name="frmEmpBasicHistForm" size="30" styleClass="locked" readonly="true" />
                </td>
                </tr>
                <tr>
                <td class=labelText >Category </td> 
                <td>
                <html:text property="txtCategory" name="frmEmpBasicHistForm" size="30" styleClass="locked" readonly="true" />
                </td>
                <td class=labelText  ><bean:message key="Payroll.EmpInfo.StaffCode" /> </td> 
                <td>
                <html:text property="txtStaffCode" name="frmEmpBasicHistForm" size="30" styleClass="locked" readonly="true" />
                </td>
                </tr>
                <tr>
                <td class=labelText  >Pay Scale Code </td>                            
                <td>
                    <html:text property="txtPayScale" name="frmEmpBasicHistForm" size="30" styleClass="locked" readonly="true" />
               </td>
               <td class=labelText  >Pay Revision </td>                            
                <td>
                    <html:text property="txtPayRev" name="frmEmpBasicHistForm" size="30" styleClass="locked" readonly="true" />
               </td>
               </tr>
                <tr>
                        <td width="20%" class="labelText"><bean:message key="Payroll.ChangeZone.fromdt" /></td>
                        <td ><html:text property="txtYYMMFrom" size="10" styleClass="optional" /></td>
                        <td class="labelText"><bean:message key="Payroll.ChangeZone.todate" /></td>
                        <td ><html:text property="txtYYMMTo" size="10" styleClass="optional" /></td>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Employee Basic Revisions<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
										  
										  <TD class=tableHeader width="3%">Start Date</TD>
                                           <TD class=tableHeader width="4%">End Date</TD>
										  <TD class=tableHeader width="3%">Basic</TD>
                                          <TD class=tableHeader width="3%">Pay Scale Code</TD>
                                           <TD class=tableHeader width="4%">Grade Pay</TD>
										  <TD class=tableHeader width="3%">Event</TD>
                                              
                                      </TR>    

                         <logic:iterate id="basicHist" name="frmEmpBasicHistForm" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EmpBasicHistBean" indexId="idx"  >
                              <% ++i; %>
                                <logic:notEqual name="basicHist" property="status" value="D" >
                                   <tr>   <% ++j; %>

                                      <!--td align=center >
											<html:checkbox property="checked" name="frmEmpBasicHistForm" onclick="checkRecord();" value="false" />
									  </td-->

									  <logic:notEqual name="basicHist" property="status" value="N" >
                                                                      <td colspan="1" align="center">
                                                                                <html:text property="txtStartDt" name="basicHist" size="6"  maxlength="6" style="width:90%;text-align:right" styleClass="locked" readonly="true" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" />
                                                                      </td>
                                                                      <td align="left">
												<html:text property="txtEndDt" name="basicHist" size="9" readonly="true" styleClass="locked" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" />
										         
										  </td>
										  <td align="left">
												<html:text property="txtBasic" name="basicHist" size="9" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" styleClass="locked" readonly="true" onchange="changed(this.alt)" />
												
                                                                        </td>  
										 <td align="left">
												<html:text property="txtOldPayscale" name="basicHist" size="9" readonly="true" styleClass="locked" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" />
										  </td>
                                                                        <td align="left">
												<html:text property="txtGradePay" name="basicHist" size="9" readonly="true" styleClass="locked" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" />
										  </td>
                                                                        <td align="left">
												<html:text property="txtEvent" name="basicHist" size="9" readonly="true" styleClass="locked" style="width:90%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" />
										  </td>
									 </logic:notEqual>
                                       <html:hidden property="itemChecked" name="basicHist" />
                                       <html:hidden property="status" name="basicHist" />
                                       <html:hidden property="detailId" name="basicHist" />
									</tr>
                           </logic:notEqual>

                             

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
												  <TD height="10" colspan="5"></TD>
											   </TR>

											  <TR>
												<TD colspan="11">
												  <table border=0>
													
												  
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
          
           <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>	
	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>
<!-- Container Table Ends -->

<html:hidden property="screenMode" name="frmEmpBasicHistForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpBasicHistForm" />
<html:hidden property="loginLocCode" name="frmEmpBasicHistForm"  />
<html:hidden name="frmEmpBasicHistForm"  property="screenName" value="BasicHistScreen" />
<html:hidden name="frmEmpBasicHistForm"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmEmpBasicHistForm"  />
<html:hidden property="lovKey" name="frmEmpBasicHistForm"  />
<html:hidden property="txtFields" name="frmEmpBasicHistForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpBasicHistForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpBasicHistForm"  />
<html:hidden property="txtIndex" name="frmEmpBasicHistForm"  />
<html:hidden property="txtInputField" name="frmEmpBasicHistForm"  />
<html:hidden property="userPageRequested" name="frmEmpBasicHistForm"  />
<html:hidden property="pageRequested" name="frmEmpBasicHistForm"  />
<html:hidden property="positionRequested" name="frmEmpBasicHistForm" />
<html:hidden property="userPositionRequested" name="frmEmpBasicHistForm" />
<html:hidden property="totalDetailRecord" name="frmEmpBasicHistForm"  />
<html:hidden name="frmEmpBasicHistForm"  property="hdnAction" />
<html:hidden property="hdnEmpLbrFlag" name="frmEmpBasicHistForm"  />

<input type="hidden" name="queryParam" />
 
</html:form>

</body>
</html:html>
<script language="javascript">

function lfnLoad()
{
  
  var screenmode = document.all.screenMode.value;
  
  menuHandling(screenmode);
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
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg"; 
      document.all.butRefresh.disabled="false";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_act.jpg";
      document.all.butInsert.disabled="true";
      document.all.txtNewParentZone.disabled="true";
  } 
  
  if(screenmode=='U')
  {
	  
	   var empno = document.all.txtEmpNo.value;
	 
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";  
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";          
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butInsert.disabled="true";
      document.all.butGetDetail.disabled="";
	 
	  if(document.getElementById("hdnAction").value=='S')
	  {
		  document.getElementById("hdnAction").value='SUB';
		  document.all.txtEmpNo.disabled="true";
	      document.all.txtYYMMFrom.disabled="true";
	      document.all.txtYYMMTo.disabled="true";
	      document.all.txtNewParentZone.disabled="true";
		  SaveRecord();
	  }
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

function doBaseAddRow()
{

}

function changed(val)
{
    frmEmpBasicHistForm.detailDataChanged.value = "true";
    if(document.getElementsByName("status")[val-1].value=='Q')
    {
      document.getElementsByName("status")[val-1].value='U';
     document.all.butInsert.disabled="true";
    }
}

function SaveRecord()
{
  var buttonFlag = document.getElementById("hdnAction").value;
  if(mandatory_Check("frmEmpBasicHistForm"))
  { 
	var oTable = document.getElementById("Detail");
	if(oTable == null)
	{
		return;
	}
	var iTr2 = oTable.rows.length;
	var i = 0;       
    frmEmpBasicHistForm.headerPrimaryKey.value = "";
    frmEmpBasicHistForm.headerFields.value = "false";
	frmEmpBasicHistForm.detailDataChanged.value = "true";
    document.all.butSave.disabled="true";
    document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	if (buttonFlag=='SUB')
    {
		
		frmEmpBasicHistForm.action = "../../../EmpbasicHistSaveAction.do";
		frmEmpBasicHistForm.submit();
    }
	else
	{
		document.getElementById("hdnAction").value='S';
		frmEmpBasicHistForm.action = "../../../ProgressAction.do";
		frmEmpBasicHistForm.submit();
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
  frmEmpBasicHistForm.action="../../../EmpbasicHistQueryMode.do";
  frmEmpBasicHistForm.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value = '';
  frmEmpBasicHistForm.action="../../../EmpbasicHistNewMode.do"
  frmEmpBasicHistForm.submit();
}

function getHeaderRecord()
{
	var empno=document.getElementById("txtEmpNo");
	if(empno.value!=""){
		frmEmpBasicHistForm.detailDataChanged.value = "false";
		frmEmpBasicHistForm.action="../../../EmpbasicHistGetHeaderAction.do"
		frmEmpBasicHistForm.submit();
	}else{
		alert("Enter Employee No.");
		empno.focus();
		return false;
	}
}

function GetDetail()
{
	
	var empno=document.getElementById("txtEmpNo");
        var fromdt=document.getElementById("txtYYMMFrom");
        var todate=document.getElementById("txtYYMMTo");

	document.all.buttonFlag.value='';
	if(empno.value!=""){
		  document.all.screenMode.value='U'; 
		  frmEmpBasicHistForm.headerPrimaryKey.value = "";
		  frmEmpBasicHistForm.action="../../../EmpbasicHistDetailAction.do";
		  frmEmpBasicHistForm.submit();
	}else{
		alert("Mandatory field is empty.");
		empno.focus();
		return false;
	}
}
 
function doRefresh()
{
  frmEmpBasicHistForm.action="../../../EmpbasicHistRefresh.do"
  frmEmpBasicHistForm.submit();
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
	  }
      
	  document.all.buttonFlag.value='';
	  document.forms[0].action = "../../../SupplimentaryPaymentDeleteRowAction.do";
	  document.forms[0].submit();
  }else{
	  alert("You can not Delete the Record. Invoice is already generated");
  }
}

function JumpDetail()
{
    frmEmpBasicHistForm.userPageRequested.value = 1*frmEmpBasicHistForm.newPageRequested.value ;
    frmEmpBasicHistForm.action = "../../../EmpbasicHistNextDetailAction.do";
    frmEmpBasicHistForm.submit();

}

function doBasePrevDetail()
{
    frmEmpBasicHistForm.userPageRequested.value = 1*frmEmpBasicHistForm.pageRequested.value - 1;
    frmEmpBasicHistForm.action = "../../../EmpbasicHistNextDetailAction.do";
    frmEmpBasicHistForm.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmEmpBasicHistForm.userPageRequested.value = 1*frmEmpBasicHistForm.pageRequested.value + 1;
    frmEmpBasicHistForm.action = "../../../EmpbasicHistNextDetailAction.do";
    frmEmpBasicHistForm.submit();
}

function doGetNextHeader()
{
	document.all.buttonFlag.value='';
    frmEmpBasicHistForm.userPositionRequested.value = 1*frmEmpBasicHistForm.positionRequested.value + 1;
    frmEmpBasicHistForm.action="../../../EmpbasicHistGetNextHeader.do";
    frmEmpBasicHistForm.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmEmpBasicHistForm.userPositionRequested.value = frmEmpBasicHistForm.positionRequested.value - 1;
  frmEmpBasicHistForm.action = "../../../EmpbasicHistGetNextHeader.do";
  frmEmpBasicHistForm.submit();
}

function JumpHeader()
{
    document.all.flagIda.value="false";
    document.all.flagCda.value="false";
    frmEmpBasicHistForm.userPositionRequested.value = 1*frmEmpBasicHistForm.newPositionRequested.value;
    frmEmpBasicHistForm.action = "../../../EmpbasicHistGetHeaderAction.do";
    frmEmpBasicHistForm.submit();
}

function ShowEmpNum()
{

    frmEmpBasicHistForm.lovKey.value = "EmpBasicHist" + frmEmpBasicHistForm.screenName.value + frmEmpBasicHistForm.screenMode.value; 

    frmEmpBasicHistForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode,txtDesig,txtDob,txtCategory,txtStaffCode,txtPayScale,txtPayRev";
    frmEmpBasicHistForm.queryParam.value = "txtSiteID="+frmEmpBasicHistForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpBasicHistForm.hdnEmpLbrFlag.value;
    frmEmpBasicHistForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
    frmEmpBasicHistForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpBasicHistForm');
    return true;
} 


function clearField()
{
   document.all.txtEmpName.value="";
   document.all.txtCpfCode.value="";
   document.all.txtDesig.value="";
   document.all.txtDob.value="";
   document.all.txtCurrentZone.value="";
   document.all.txtStaffCode.value="";
		 
}

function getEmpDtlAjax()
{
	url="../../../GetEmpDtlRetroParZone.do";
    prm="mode=1&txtEmpNo="+frmEmpBasicHistForm.txtEmpNo.value+"&txtEmpName="+frmEmpBasicHistForm.txtEmpName.value+"&txtCpfCode="+frmEmpBasicHistForm.txtCpfCode.value+"&screenName="+frmEmpBasicHistForm.screenName.value;
	xml=getXML(url,prm);
	Tags=xml.getElementsByTagName("record");
	if(Tags.length > 0)
	{
     
		frmEmpBasicHistForm.txtEmpName.value=Tags[1].childNodes[0].nodeValue;
		frmEmpBasicHistForm.txtCpfCode.value=Tags[2].childNodes[0].nodeValue;
		frmEmpBasicHistForm.txtSiteCode.value=Tags[3].childNodes[0].nodeValue;
		frmEmpBasicHistForm.txtSiteDesc.value=Tags[4].childNodes[0].nodeValue;
		frmEmpBasicHistForm.txtDesig.value=Tags[5].childNodes[0].nodeValue;
		frmEmpBasicHistForm.txtDob.value=Tags[6].childNodes[0].nodeValue;
		frmEmpBasicHistForm.txtCurrentZone.value=Tags[7].childNodes[0].nodeValue;
		frmEmpBasicHistForm.txtStaffCode.value=Tags[8].childNodes[0].nodeValue;
	}
	else
	{
		alert("Invalid employee");
	}

}

</script>

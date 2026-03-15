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
<html:form action="ZoneSurrenderBaseAction" name="frmZoneSurrenderForm" type="FCIPAY.Payroll.WEBTIER.Form.ZoneSurrenderForm" scope="session">
<bean:define id="ParentForm" name="frmZoneSurrenderForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>  
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<input type="hidden" name="sysdate" value="<%=now%>">

<TABLE cellSpacing=0 cellPadding=0 border=0 >
	<TR height=30>
		<TD colSpan=11 class=mainHeader height=10>ZONE SURRENDER</TD>
	</TR>
    <TR>
		<TD class=subHeader colspan=6> Employee Header </TD>
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
					 <logic:equal property= "screenMode" name= "frmZoneSurrenderForm" value="N">
						<html:text  property="txtEmpNo" maxlength="10" size="10" styleClass="required" readonly="true" />
						<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
					 </logic:equal>
					 <logic:notEqual property="screenMode" name= "frmZoneSurrenderForm" value="N">
						<logic:equal property="screenMode" name= "frmZoneSurrenderForm" value="Q">
							<html:text  property="txtEmpNo" maxlength="10" size="10" styleClass="optional" readonly="true" />
							<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
						</logic:equal>
						<logic:notEqual property="screenMode" name= "frmZoneSurrenderForm" value="Q">
							<html:text  property="txtEmpNo" maxlength="10" size="10" styleClass="locked" readonly="true" />
							<img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType" onclick="ShowLovEmp();" >
						</logic:notEqual>
					 </logic:notEqual>
				</td>
				<td class="labelText"><bean:message key="Payroll.EmpInfo.Retdate" /></td>
				<td ><html:text property="txtRetrDt" size="10" readonly="true" styleClass="locked" /></td>
			</tr>
			<tr>
				<td class="labelText"><bean:message key="Payroll.SupplyPay.EmpName" /></td>
				<td ><html:text property="txtEmpName" size="39" styleClass="locked" readonly="true" /></td>
				<td width="20%" class="labelText"><bean:message key="Payroll.SupplyPay.StaffCode" /></td>
				<td ><html:text property="txtStaffCode" size="10" readonly="true" styleClass="locked" /></td>

			</tr>
			<tr>
				<td class="labelText"><bean:message key="Payroll.SupplyPay.CPFCode" /></td>
				<td ><html:text property="txtCPFCode" size="10" readonly="true" styleClass="locked" /></td>
				<td class="labelText">Present Location</td>
        		<td><html:text property="txtUnitDesc" size="39" readonly="true" styleClass="locked" /></td>
				<html:hidden property="txtUnitCode" name="frmZoneSurrenderForm" />
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
                            <DIV id=divDtlTable style="height:350px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail" >
                                <TBODY>
									<TR><TD height=10 colspan=11></TD></TR>
									<TR>
									<TD class="labelText" width="45%">Current Zone<TD>
									<td><html:text property="txtCurrZoneDesc" size="10" readonly="true" style="width:30%;text-align:left" styleClass="locked" /></td>
									<html:hidden property="txtCurrZone" name="frmZoneSurrenderForm" />
									</TR>									     
									<TR>
									<TD class="labelText">New Zone<TD>
									<td>
										<logic:equal property= "screenMode" name="frmZoneSurrenderForm" value="N">
											<html:select property="txtNewZone" name="frmZoneSurrenderForm"  styleClass="required" style="WIDTH: 30%"  >
											<html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>
											<logic:present name="zone">
											<html:optionsCollection label="label" value="value" property="zoneList" name="zone" />
											</logic:present>
											</html:select>
										</logic:equal>
										<logic:notEqual property= "screenMode" name="frmZoneSurrenderForm" value="N">
											<html:select property="txtNewZone" name="frmZoneSurrenderForm" disabled="true" styleClass="locked" style="WIDTH: 30%">
											<html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>
											<logic:present name="zone">
											<html:optionsCollection label="label" value="value" property="zoneList" name="zone" />
											</logic:present>
											</html:select>
										</logic:notEqual>
									</td>
									</TR>									     
									<TR>
									<TD class="labelText">Reason for Zone Surrender<TD>
									<td>
									<logic:equal property= "screenMode" name="frmZoneSurrenderForm" value="N">
										<html:textarea property="txtSurrRsn" rows="3" cols="50" style="text-align:left" onkeypress="return textCounter(this,1000);" styleClass="optional"/>
									</logic:equal>
									<logic:notEqual property= "screenMode" name="frmZoneSurrenderForm" value="N">
										<html:textarea property="txtSurrRsn" rows="3" cols="50" style="text-align:left" onkeypress="return textCounter(this,1000);" styleClass="locked"/>
									</logic:notEqual>
									</td>
									</TR>									     
									<TR>
									<TD class="labelText">Status<TD>
									<td><html:text property="txtAppvSts" size="10" readonly="true" styleClass="locked" /></td>
									</TR>									     
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

<html:hidden property="screenMode" name="frmZoneSurrenderForm"  />
<html:hidden property="headerPrimaryKey" name="frmZoneSurrenderForm" />
<html:hidden property="loginLocCode" name="frmZoneSurrenderForm"  />
<html:hidden name="frmZoneSurrenderForm"  property="screenName" value="ZoneSurrenderScreen" />
<html:hidden name="frmZoneSurrenderForm"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmZoneSurrenderForm"  />
<html:hidden property="lovKey" name="frmZoneSurrenderForm"  />
<html:hidden property="txtFields" name="frmZoneSurrenderForm"  />   
<html:hidden property="txtSearchFields" name="frmZoneSurrenderForm"  />
<html:hidden property="txtDisplayFields" name="frmZoneSurrenderForm"  />
<html:hidden property="txtIndex" name="frmZoneSurrenderForm"  />
<html:hidden property="txtInputField" name="frmZoneSurrenderForm"  />
<html:hidden property="userPageRequested" name="frmZoneSurrenderForm"  />
<html:hidden property="pageRequested" name="frmZoneSurrenderForm"  />
<html:hidden property="positionRequested" name="frmZoneSurrenderForm" />
<html:hidden property="userPositionRequested" name="frmZoneSurrenderForm" />
<html:hidden property="totalDetailRecord" name="frmZoneSurrenderForm"  />

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
  if(screenmode == 'U')
  {
	  document.all.butSave.disabled="true";    
	  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
	  document.all.butInsertMode.disabled="true";    
	  document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
  } 
	 document.all.butGetDetail.disabled="disabled";
	 document.all.butInsert.disabled="disabled";

  menuHandling(screenmode);

 }

function doQueryMode()
{
  document.all.screenMode.value = "Q";
  frmZoneSurrenderForm.action="../../../ZoneSurrQueryMode.do";
  frmZoneSurrenderForm.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value = '';
  frmZoneSurrenderForm.action="../../../ZoneSurrNewMode.do"
  frmZoneSurrenderForm.submit();
}

function getHeaderRecord()
{
	frmZoneSurrenderForm.detailDataChanged.value = "false";
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

	frmZoneSurrenderForm.action="../../../ZoneSurrGetHeaderAction.do"
	frmZoneSurrenderForm.submit();
}

function GetDetail()
{
	document.all.screenMode.value='U'; 
	frmZoneSurrenderForm.headerPrimaryKey.value = "";
	frmZoneSurrenderForm.action="../../../ZoneSurrDetailAction.do";
	frmZoneSurrenderForm.submit();
}
 
function doRefresh()
{
  frmZoneSurrenderForm.action="../../../ZoneSurrRefresh.do"
  frmZoneSurrenderForm.submit();
}
     
function SaveRecord()
{
  if(mandatory_Check("frmZoneSurrenderForm"))
  { 
	  frmZoneSurrenderForm.headerPrimaryKey.value = "";
	  frmZoneSurrenderForm.headerFields.value = "false";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	  frmZoneSurrenderForm.headerDataChanged.value = "true";
	  frmZoneSurrenderForm.detailDataChanged.value = "false";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";

	  frmZoneSurrenderForm.action = "../../../ZoneSurrSaveAction.do";
	  frmZoneSurrenderForm.submit();
  }
  else 
  {
	  return false;
  }
}

function JumpDetail()
{
    frmZoneSurrenderForm.userPageRequested.value = 1*frmZoneSurrenderForm.newPageRequested.value ;
    frmZoneSurrenderForm.action = "../../../CPFApprovalNextDetailAction.do";
    //frmZoneSurrenderForm.submit();

}

function doBasePrevDetail()
{
    frmZoneSurrenderForm.userPageRequested.value = 1*frmZoneSurrenderForm.pageRequested.value - 1;
    frmZoneSurrenderForm.action = "../../../CPFApprovalNextDetailAction.do";
    //frmZoneSurrenderForm.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmZoneSurrenderForm.userPageRequested.value = 1*frmZoneSurrenderForm.pageRequested.value + 1;
    frmZoneSurrenderForm.action = "../../../CPFApprovalNextDetailAction.do";
    //frmZoneSurrenderForm.submit();
}

function doGetNextHeader()
{
	document.all.buttonFlag.value='';
    frmZoneSurrenderForm.userPositionRequested.value = 1*frmZoneSurrenderForm.positionRequested.value + 1;
    frmZoneSurrenderForm.action="../../../ZoneSurrGetNextHeader.do";
    frmZoneSurrenderForm.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmZoneSurrenderForm.userPositionRequested.value = frmZoneSurrenderForm.positionRequested.value - 1;
  frmZoneSurrenderForm.action = "../../../ZoneSurrGetNextHeader.do";
  frmZoneSurrenderForm.submit();
}

function JumpHeader()
{
    document.all.flagIda.value="false";
    document.all.flagCda.value="false";
    frmZoneSurrenderForm.userPositionRequested.value = 1*frmZoneSurrenderForm.newPositionRequested.value;
    frmZoneSurrenderForm.action = "../../../ZoneSurrGetNextHeader.do";
    frmZoneSurrenderForm.submit();
}

function ShowLovEmp()
{
	frmZoneSurrenderForm.lovKey.value = "ZoneSurrEmp" +frmZoneSurrenderForm.screenName.value + frmZoneSurrenderForm.screenMode.value;
    frmZoneSurrenderForm.queryParam.value="txtSiteID="+ frmZoneSurrenderForm.loginLocCode.value +",hdnEmpLbrFlag="+frmZoneSurrenderForm.hdnEmpLbrFlag.value ; 
	frmZoneSurrenderForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName,Payroll.Common.cpfCode";
	frmZoneSurrenderForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCPFCode,txtRetrDt,txtStaffCode,txtUnitCode,txtUnitDesc,txtCurrZone,txtCurrZoneDesc";
	frmZoneSurrenderForm.txtIndex.value = 0;
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmZoneSurrenderForm');
	return true;
}

function textCounter(field, maxlimit)     
{
//alert(field.value.length)
	if (field.value.length >= maxlimit)         
	{   
		field.value = field.value.substring(0, maxlimit);            
		return false;
	}        
	else         
	{            
		return true;
	}
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
	for(i=0; i < iTr2 - 1; i++)
	{
		if(document.getElementsByName("checked")[i].checked)
		{
			count++;
		}
	}
	if(count>0)
	{
		document.all.butApprove.disabled="";
		document.all.butReject.disabled="";
	}
	else
	{
		document.all.butApprove.disabled="true";
		document.all.butReject.disabled="true";
	}
}

</script>

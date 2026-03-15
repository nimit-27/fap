<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.Calendar,java.text.SimpleDateFormat"%>
<%! int i=0;%>
<html:html>
 <%
 Calendar cal = Calendar.getInstance();
 SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
 String now=sdf.format(cal.getTime());
 SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
 String now1=sdf1.format(cal.getTime());
 %>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script> 
   <style type="text/css">
	.black_overlay{
		display: none;
		position: absolute;  
		top: 0px;
		left: 0px;
		width: 100%;
		background-color: black;
		z-index:1001;
		-moz-opacity: 0.7;
		opacity:.7;
		filter: alpha(opacity=70);
	}
	.white_content { 
		display: none;  
		position: absolute;
		padding: 5px;
		height:40px;
		border: 1px solid blue;
		background-color: white;
		z-index:1002;
	
		/*overflow: auto;*/
	}
	</style>
    

</head>

<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="PostYrEndRemitToAP" name="frmPostYrEndRemitToAP" type="FCIPAY.Payroll.WEBTIER.Form.PostYrEndRemitToAPForm">
<bean:define id="ParentForm" name="frmPostYrEndRemitToAP" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:hidden property="fromFlag" name="frmPostYrEndRemitToAP" value="First" />
<input type="hidden" name="sysdate" value="<%=sdf.format(cal.getTime())%>">
<input type="hidden" name="sysdate1" value="<%=now1%>">
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
<TR height=30>
  <TD  colSpan=11 class=mainHeader height=10>POST YEAR END REMITTANCES TO AP FOR <span id="displayYYMM" value=""></TD>
</TR>
<tr height="10"><td class=userText colspan="11"></td></tr>
</TABLE>

<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
      <!-- <div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--pay Scale Header Row Starts -->
       <TR>
           <TD class=subHeader colspan=6>POST YEAR END REMITTANCES TO AP</TD>
        </TR>
        <TR>
           <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
        </TR>
		<TR height=220>
		 <!-- Detail table Container starts -->
		<TD colspan=11>
		<TABLE cellSpacing=0 cellPadding=0 border=0>
		<TBODY>
		<TR>
		<TD>
		</TD>
		</TR>
		</TBODY>
		</TABLE>
		</TD>
		</TR>
        <tr>
			<td class=labelText align=left  width="35%" bgcolor=#4682b4> </td>                
			<td width="25%" bgcolor=#4682b4><font color="#FFFFFF">Invoice Date &nbsp;&nbsp;</font>
			<logic:equal name="frmPostYrEndRemitToAP" property="formFlag" value="First">
			<html:text  property="txtInvDt" styleClass = "optional" maxlength="10"  size="23"  readonly="true" onchange="checkfuturedate(this)" value="<%=now%>" />
			<!--img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butInvDt1" alt="<%=(i-1) %>" onclick="showCalendar('txtInvDt',this)" /-->
			</logic:equal>
			
			<logic:notEqual name="frmPostYrEndRemitToAP" property="formFlag" value="First">
			<html:text  property="txtInvDt" styleClass = "optional" maxlength="10"  size="23"  readonly="true" onchange="checkfuturedate(this)" />
			<!--img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" title="Calender" styleClass="lov" id="butInvDt" alt="<%=(i-1) %>" onclick="showCalendar('txtInvDt',this)" /-->
			</logic:notEqual>
		   </td>
			<td bgcolor=#4682b4>&nbsp;</td>
			<td bgcolor=#4682b4>&nbsp;</td>  
			<!--td>&nbsp;</td-->
		</tr>
		<tr>
			 <td>&nbsp;</td>
			 <td>&nbsp;</td>
			 <td>&nbsp;</td>
			 <td>&nbsp;</td>
		</tr>
        <TR>
			<td align=center bgcolor=#4682b4 width="35%"></td>
			<td  bgcolor=#4682b4 width="25%"><html:button value='Other Payments'  onclick="PostOtherPayments()" property="butOP" styleClass="bottomBarText" />&nbsp;
			<html:button value='Salary Remittance'  onclick="PostSalary()" property="butSAL" styleClass="bottomBarText" /></td>
			<td  bgcolor=#4682b4 width="25%">
			<td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
        </TR>
     </TD>
	 
   </TR>
   </TBODY>
   <table cellSpacing=0 cellPadding=3 border=0>
		<tr height=50><td>&nbsp;</tr>
		<tr height=20>
			<td style="font-size:12px;font-weight:bold"> Note:</td>
		</tr>
		<tr>
			<td style="font-size:12px">1. Posting of Other / Supplimentary payment's remittances are to be done before 31st March. After posting of remittances for Other / Supplimentary payments, the site will not be able to enter any Supplimentary/other payment. </td>
		</tr>
		<tr>
			<td style="font-size:12px">2. Salary remittances for March are to be done after 1st April. Salary remittances will not include any Other / Supplimentary payment remittances.  </td>
		</tr>
	</tr>
   </table>
   </table>

<html:hidden name="frmPostYrEndRemitToAP"  property="screenName" value="PostYrEndRemitToAPScreen" />
<html:hidden name="frmPostYrEndRemitToAP"  property="forwardedPage" />
<html:hidden name="frmPostYrEndRemitToAP"  property="hdnAction" />
<html:hidden property="screenMode" name="frmPostYrEndRemitToAP" />
<html:hidden property="payYYMM" name="frmPostYrEndRemitToAP" />
<html:hidden property="btnFlag" name="frmPostYrEndRemitToAP" />

</html:form>
<div id="fade" style="display: none; position: absolute; top: 0px; left: 0px; width: 100%; background-color: black; z-index:1001; -moz-opacity: 0.7; opacity:.7; filter: alpha(opacity=70)"></div>
</body>
</html:html>

<script language="javascript">
function checkfuturedate(seldate)
{
	var date1=new Date(seldate.value.replace(/[-]/g," "));
	var date2=new Date(frmPostYrEndRemitToAP.sysdate.value.replace(/[-]/g," "));
	if(date1.getTime()>date2.getTime())
	{
		alert("Invoice date cannot be more than the system date!");
		frmPostYrEndRemitToAP.txtInvDt.value=frmPostYrEndRemitToAP.sysdate.value;
	}
}

function lfnLoad()
{
	var screenmode = document.all.screenMode.value;
	if(screenmode == '')
	{
		doQueryMode();
		frmPostYrEndRemitToAP.hdnAction.value='';
	}
	else
	{
		var tempYYMM = document.getElementById("payYYMM").value;
		currYYMM = tempYYMM;
		currYYMM = currYYMM.substring(0,4)+"03";
        document.getElementById("displayYYMM").innerHTML = currYYMM;
		if(tempYYMM.substring(4) != "03")
		{
			alert("This screen is applicable only for the Remittances of March");
			createDiv();
			frmPostYrEndRemitToAP.action="../../../MainPage.do";
			frmPostYrEndRemitToAP.submit();
		}
	}


	if (frmPostYrEndRemitToAP.btnFlag.value=='OP')
	{
		if (frmPostYrEndRemitToAP.hdnAction.value=='S') 
		{
			document.all.butOP.disabled="true";
			document.all.butSAL.disabled="true";
			frmPostYrEndRemitToAP.hdnAction.value='SUB';
			PostOtherPayments(); 
		}
	}
	else if(frmPostYrEndRemitToAP.btnFlag.value=='SAL')
	{
		if (frmPostYrEndRemitToAP.hdnAction.value=='S') 
		{
			document.all.butOP.disabled="true";
			document.all.butSAL.disabled="true";
			frmPostYrEndRemitToAP.hdnAction.value='SUB';
			PostSalary(); 
		}
	}
	batchMenuHandling();
}

function doQueryMode()
{
  frmPostYrEndRemitToAP.action="../../../PostYrEndRemitQueryMode.do";
  frmPostYrEndRemitToAP.submit();
}

function PostOtherPayments()
{
	 frmPostYrEndRemitToAP.btnFlag.value = 'OP';
	 frmPostYrEndRemitToAP.butOP.disabled = "true";
	 frmPostYrEndRemitToAP.butSAL.disabled = "true";
	 if (frmPostYrEndRemitToAP.hdnAction.value != 'SUB') 
	 {
		if(confirm("You cannot enter any payment after posting of Remittances for Other / Supplimentary payments."))
		{
			frmPostYrEndRemitToAP.hdnAction.value = 'S'; 
			frmPostYrEndRemitToAP.action = "../../../PostYrEndRemitOthrPay.do";
			frmPostYrEndRemitToAP.submit();
		}
	 }
	 else
	 {
		frmPostYrEndRemitToAP.hdnAction.value='SUB';       
		frmPostYrEndRemitToAP.action = "../../../PostYrEndRemitOthrPay.do";
		frmPostYrEndRemitToAP.submit();
	 }
}

function createDiv()
{
	var fade_div=document.getElementById('fade');
	var y=getWindowHeight();
	var x=getWindowWidth();
	fade_div.style.height=y;
	fade_div.style.display='block';
}

function getWindowHeight(){
	if(document.all) return (document.documentElement.clientHeight) ? document.documentElement.clientHeight : document.body.clientHeight;
	else return window.innerHeight;
}

function getWindowWidth(){
	if(document.all) return (document.documentElement.clientWidth) ? document.documentElement.clientWidth : document.body.clientWidth;
	else return window.innerWidth;
}

function PostSalary()
{
	 if(validateYYYYMM()) return;
	 frmPostYrEndRemitToAP.btnFlag.value = 'SAL';
 	 frmPostYrEndRemitToAP.butOP.disabled = "true";
	 frmPostYrEndRemitToAP.butSAL.disabled = "true";
	 if (frmPostYrEndRemitToAP.hdnAction.value != 'SUB') 
     {
		frmPostYrEndRemitToAP.hdnAction.value = 'S'; 
		frmPostYrEndRemitToAP.action = "../../../PostYrEndRemitSalary.do";
		frmPostYrEndRemitToAP.submit();
	 }
	 else
	 {
		frmPostYrEndRemitToAP.hdnAction.value='SUB';       
		frmPostYrEndRemitToAP.action = "../../../PostYrEndRemitSalary.do";
		frmPostYrEndRemitToAP.submit();
	 }
}

function validateYYYYMM()
{
	var arr = new Array();
	var currDate = frmPostYrEndRemitToAP.sysdate1.value;
	arr = currDate.split("/");
	var curr_month = arr[1];
	var curr_year = arr[2];
	
	var yyyymm = frmPostYrEndRemitToAP.payYYMM.value;
	if (yyyymm == "") return true;
	var yyyy = yyyymm.substring(0,4);
	var mm = yyyymm.substring(4,6);

	var mon_arr = new Array();
	var msg_mon1 = "";
	var msg_mon2 = "";
	var msg_year2 = "";
	mon_arr = ["","Jan","Feb","Mar","Apr","May","Jun","July","Aug","Sep","Oct","Nov","Dec"];
	msg_mon1 = mon_arr[eval(mm)];
	if (eval(mm)==12)
	{
		msg_year2 = eval(yyyy)+1;
		msg_mon2 = mon_arr[1];
	}
	else
	{
		msg_year2 = yyyy;
		msg_mon2 = mon_arr[eval(mm)+1];
	}
	if (eval(yyyy) >= eval(curr_year))
	{
		if (eval(yyyy) > eval(curr_year))
		{
			alert("You can Post Remittances to AP For '"+msg_mon1+"-"+yyyy+"' From '01-" +msg_mon2+ "-" +msg_year2+ "' onwords Only.");
			return true;
		}
		if (eval(yyyy) == eval(curr_year))
		{
			if (eval(mm) >= eval(curr_month))
			{
				alert("You can Post Remittances to AP For '"+msg_mon1+"-"+yyyy+"' From '01-" +msg_mon2+ "-" +msg_year2+ "' onwords Only.");
				return true;
			}
		}
	}
	return false;
}

</script>
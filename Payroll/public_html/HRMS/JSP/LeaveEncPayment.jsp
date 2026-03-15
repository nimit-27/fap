<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html locale="true">
<head><html:base />
<title>Leave Encashment Payment through Voucher</title>
<iframe ID="hiddenFrame" NAME="pri" WIDTH="0" HEIGHT="0"></iframe>
<script language="javascript"  src="../../COMMON/JavaScript/validate.js" ></script>

<script language="javascript"  src="../../Finance/JavaScript/fin_validate.js" ></script>

<link rel="STYLESHEET"  type="text/css"  href="../../COMMON/CSS/Menucss.css" >

<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_func.js" ></script>

<script language="JavaScript1.2"  src="../../COMMON/JavaScript/Menu_addins.js" ></script>

<link rel="stylesheet" href="../../COMMON/CSS/IBA.css" >

<%
response.setHeader("cache-Control","no-store");  
response.setHeader("cache-Control","max-age=0");
response.setHeader("Pragma","no-cache");
%>


<style>
#div1{
	LEFT: 22.5%; OVERFLOW: auto; WIDTH: 100%; TOP: 150px; HEIGHT: 150px
}
.mandatory
{
	font-size:17; color:red;

}

#llist{
height:50px;
}

</style>

<SCRIPT>

// Disable key F5 and BackSpace
if (document.all)
{
    document.onkeydown = function ()
	{
        var key_backSpace = 8; // 8 = backSpace
        var key_f5 = 116; // 116 = F5
		if (event.keyCode == key_f5 || event.keyCode == key_backSpace)
		{
			event.keyCode = 0;
			alert ("This function is disabled!");
            return false;
		}
		return true;
	}    
}

function lfnload()
{    
    d = document.frmLvEncPay;
//    alert(d.sAction.value);
    if(d.sAction.value =="SaveFailed")
    {
        d.butSave.disabled = false;
        d.butMode.disabled = true;
        d.butGetDetails.disabled = true;
        
    }
    else if(d.sAction.value == "ClmDtlsNotFound")
    {
        d.butSave.disabled = true;
        d.butMode.disabled = true;
        d.butGetDetails.disabled = true;
    }
    
    if(d.sAction.value !="LoadingFailed" && d.lstEmpNo.length <2 && d.sAction.value !="SaveFailed")
    {        
        d.sAction.value = "Load";
        d.submit();
    }
    if(d.sAction.value == "GETVOUCHDTLS")
    {
        var TableId = 'tableId';
        var Sum = 0;
        var SacAmtFieldName = 'txtDrAmt';   
        d.txtTotDrAmt.value = lfnGetSum(TableId,Sum,SacAmtFieldName);
        if(eval(d.txtTotDrAmt.value) > 5000 && d.lstVoucherType.value == "VOUCHTYPE$CPV")
        {
            divAdvice.style.visibility = "visible";
        }
        else
        {
            divAdvice.style.visibility = "hidden";    
        }
        d.butSave.disabled = false;
        d.lstEmpNo.disalbed = true;
        d.butMode.disabled = true;
        d.butGetDetails.disabled = true;
    }
    if(d.sAction.value == "GetClmDtls")
    {
        if(d.lstEmpNo.value != "")
        {
            d.butMode.disabled = true;
        }        
    }
}

function lfnReset()
{
    d = document.frmLvEncPay;
    d.txtVouchDate.value = getSysDate();
    d.sAction.value = "Reset";
    d.submit();
}

function lfnGetSum(TableId,Sum,SacAmtFieldName)
{
    //CALCULATING SUM OF SANCTIONED AMOUNT IN A PANE
    var oTable = document.getElementById(TableId);
    var iTR = oTable.rows.length;
//    alert(iTR);
    for(i=0;i<iTR;i++)
    {
//        alert("hello");
        if(document.getElementsByName(SacAmtFieldName)[i].value == "")
        {
            amt = 0;
            document.getElementsByName(SacAmtFieldName)[i].value = 0;
        }            
        else
            amt = document.getElementsByName(SacAmtFieldName)[i].value;
        Sum = eval(Sum) + eval(amt);        
    }
    return Sum;
}


function lfnGetEmpDtls(value)
{
    d= document.frmLvEncPay;
    d.sAction.value = "GetEmpDtls";
    d.submit();
    return true;
}

function lfnGetVouchDtls()
{   
    var d = document.frmLvEncPay;
    if(d.lstEmpNo.value == "")
    {
        alert("Please select Employee Number");
        d.lstEmpNo.focus();
        return false;
    }
    if(d.lstVoucherType.value == "")
    {
        alert("Please select Voucher Type");
        d.lstVoucherType.focus();
        return false;
    }
    else
    {        
        d.sAction.value = "GETVOUCHDTLS";
        d.submit();        
        d.butSave.disabled = false;       
    }
}


function clearMasterDetails()
{   
   frmLvEncPay.txtAcctIdMast.value="";
   frmLvEncPay.txtSlCodeMast.value="";
   frmLvEncPay.txtChCodeMast.value="";
   frmLvEncPay.txtCcCodeMast.value="";
   frmLvEncPay.txtPartMast.value="";
   frmLvEncPay.txtDrMast.value="";
   frmLvEncPay.txtDrMast.value="";
   frmLvEncPay.txtDrMast.value="";
   frmLvEncPay.txtDrMast.value="";
   frmLvEncPay.txtDrMast.value="";
}

function lfnChangeMode()
{
    d= document.frmLvEncPay;
    if(frmLvEncPay.butMode.value=="Enter Query")
    {
        d.lstPeriod.disabled = true;
        d.lstEmpNo.value = "";
        d.lstEmpNo.disabled = true;
        d.butQuery.disabled=false;
        d.butGetDetails.disabled = true;
        d.txtVouchNo.readOnly = false;        
        d.txtVouchNo.value = "";
        d.txtDocRef.value = "";
        d.txtVouchDate.value = "";
        Query.style.display='block';
        New.style.display='none';
        frmLvEncPay.butMode.value="Enter New";
        frmLvEncPay.butQuery.disabled=false;
        frmLvEncPay.txtVouchNo.value="";
        clearMasterDetails();
    }
    else 
    {
        d.lstPeriod.disabled = false;
        d.lstEmpNo.disabled = false;
        d.butQuery.disabled=true;
        d.butGetDetails.disabled = false;
        frmLvEncPay.butMode.value="Enter Query";

        d.txtVouchDate.value = getSysDate();
        Query.style.display='none';
        New.style.display='block';
        frmLvEncPay.txtVouchNo.value="";
        
        d.txtVouchNo.readOnly = true;
        clearMasterDetails();
    }
}

function lfnQuery()
{
    var d = document.frmLvEncPay;
    if(d.lstVoucherType.value == "")
    {
        alert("Select Voucher Type before query");
        d.lstVoucherType.focus();
        return false;
    }
    var today = new Date();
    
    d.txtHidMode.value = "Query";
    d.txtHidVouchType.value = d.lstVoucherType.value;
//    alert(d.txtHidMode.value);
    if(d.txtHidMode.value=="Query")
    {
//       alert(d.txtLinkMast.value);       
       
        if(d.txtPartMast.value!="" || d.txtAcctIdMast.value!="" || d.txtChCodeMast.value!="" || d.txtCcCodeMast.value!=""  || d.txtDrMast.value!="" || d.txtVouchNo.value!="" || d.txtVouchDate.value!="" || d.txtDocRef.value!="" || d.txtRemarks.value!="" || d.txtOrderNoMast.value!="" || d.txtSlCodeMast.value!="") 
        {
            d.txtOpeningTime.value=today.toString();
            d.txtHidVoucherId.value="";
            openCentered('<html:rewrite page="/Finance/JSP/QueryVoucher.jsp" />','SearchScreen');
            return true;
        }
        else
        {
            alert("Enter some values in the fields to perform a query search");
        }
    }
    else 
    alert("Not in Query Mode");
}

function openCentered (url, windowName) 
{
    return window.open(url, windowName);//,"toolbar=no,location=no,scrollbars=yes,width=700,height=550"); //, windowName, featureString);
}

function lfnValidateForm(frm)
{
	var i;
	var validity = true;
	var d = document.frmLvEncPay;
	if(mandatory_Check(frm))
    {
        if(d.sAction.value == "Edit" || d.sAction.value == "Update")
        {
            d.sAction.value = "Update";
            for(i = 0; i< d.length; i++)
                d.elements[i].disabled = false;
            d.submit();
            return true;
        }
        document.frmLvEncPay.sAction.value="Save";
        for(i = 0; i< d.length; i++)
            d.elements[i].disabled = false;
        document.frmLvEncPay.submit();
        return true;
    }
    else
    {
        return false;
    }   
}

function lfnPrintMandatoryMark()
{
	document.write("<font class = 'mandatory'>");
	document.write("*");
	document.write("</font>");
}

function lfnPrintSearchableMark()
{
	document.write("<font class = 'searchable'>");
	document.write("#");
	document.write("</font>");
}

</SCRIPT>

</head>

<body bgcolor="white" topmargin="0" onload="lfnload();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<!--<script language="JavaScript1.2" src='<html:rewrite page="/COMMON/JavaScript/Menujs.js" />'></script>-->
<jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
<br><br><br>
<%! int i=0; %> 
<DIV ID="printReady" class="Print">
<html:form method="post" action="/LvEncPay" type="FCIPAY.HRMS.WEBTIER.Form.ClaimPaymentForm" name="frmLvEncPay" >
<br>  

<center><b class = "MainHeader">Leave Encashment Payment through Voucher</b></center>
<div id = "divAdvice" style = "visibility:hidden">
    <center><font face="Arial" color="red" size="3"><b>Amount is Higher than Rs. 5000, Advisable for a Bank Payment Advice</b></center>
</div>
<html:errors/>

<html:messages id = "messages" message = "true" >
<center><font face="Arial" color="blue" size="3"><b><bean:write name = "messages" /><b></font></center>
</html:messages>
<table cellspacing="0" cellpadding="0">
<TBODY>
<tr>
    <td width = "90%">
        <script language="JavaScript" >lfnPrintMandatoryMark();</script>&nbsp;&nbsp;<font class="labelText">&nbsp;Mandatory Fields</font>
    </td>
    <td class="labelText" width ="15%">Period<SCRIPT language=JavaScript>lfnPrintMandatoryMark();</SCRIPT></td>
    <td width = "5%">
                <html:select property="lstPeriod" styleClass="required" >                
                <html:options property="lstPeriodValues" labelProperty="lstPeriodLabels" style="llist" />
                </html:select>
    </td>
</tr>
</tbody>
</table>
<table cellspacing="0" cols="4" cellpadding="0" width="100%" class = "bgndTable" border="0" >
<caption><div id="sty" ><b class="SubHeader">Employee Details</b></div></caption>
<tbody>
<tr>
     <td class="labelText" width = "20%">Employee Number<SCRIPT language=JavaScript>lfnPrintMandatoryMark();</SCRIPT></td>
     <TD width = "25%">
                <html:select property="lstEmpNo" styleClass="required" onchange = "lfnGetEmpDtls(this.value);" style = "width:145">
                <html:option value="" >Please Select</html:option>
                    <html:options property="lstEmpNoValues" labelProperty="lstEmpNoLabels" style="llist" />
                </html:select>
    </TD>			       
     <td class="labelText" width = "20%">Employee Name<SCRIPT language=JavaScript>lfnPrintMandatoryMark();</SCRIPT></td>
     <TD width = "35%">
                <html:text property="txtEmpName" size = "60" readonly="true" />           
    </TD>
</tr>
</TBODY>
</TABLE>
<table cellspacing="0" cols="4" cellpadding="0" width="100%" class = "bgndTable" border="0" >
<caption><div id="sty" ><b class="SubHeader">Voucher Header</b></div></caption>
<tbody>
<tr>
     <td class="labelText" width = "20%">Voucher No</td>
     <TD width = "25%">
                <html:text property="txtVouchNo" size = "20" readonly="true" />           
    </TD>   
     
     <td class="labelText" width = "20%">Document Location<SCRIPT language=JavaScript>lfnPrintMandatoryMark();</SCRIPT></td>
     <TD width = "35%">
                <html:text property="txtDocLoc" size = "60" readonly="true" />           
    </TD>
</tr>
<tr>
    <td width="20%"  class="labelText" >Voucher Type&nbsp;<script language="JavaScript" >lfnPrintMandatoryMark();</script></td>
    <td width="25%" >    
            <html:select size ="1" property ="lstVoucherType" styleClass="required"   style = "width:145">
                <html:option value="">Please Select</html:option>
                <html:option value="VOUCHTYPE$BPV">BPV</html:option>
                <html:option value="VOUCHTYPE$CPV">CPV</html:option>
            </html:select>        
	</td>
     <td class="labelText" width = "20%">Voucher Date<SCRIPT language=JavaScript>lfnPrintMandatoryMark();</SCRIPT></td>
     <TD width = "25%">
                <html:text property="txtVouchDate" styleClass="required" size = "20" maxlength = "10" onblur ="ValidateDate(this.value,0);" />           
    </TD>       
     
</tr>
</TBODY>
</TABLE>
<table cellspacing="0" cols="4" cellpadding="0" width="100%" class = "bgndTable" border="0" >
<caption><div id="sty" ><b class="SubHeader">Reference</b></div></caption>
<tbody>
<tr>
     <td class="labelText" width = "20%">Document Reference<SCRIPT language=JavaScript>lfnPrintMandatoryMark();</SCRIPT></td>
     <TD width = "25%">
                <html:text property="txtDocRef" styleClass="required" size = "20" maxlength="20"/>           
    </TD>   
     
     <td class="labelText" width = "20%">Remarks</td>
     <TD width = "35%">
                <html:text property="txtRemarks" size = "60" maxlength="150" />           
    </TD>
</tr>
</TBODY>
</TABLE>
<br>
<Table width="100%">
	<TR align="right">
		<TD width = "100%" >
		<html:button  styleClass="butto" onmouseover="this.style.color='yellow';" accesskey="G"  onmouseout="this.style.color='white';" property="butGetDetails" value="Get Details" onclick = "lfnGetVouchDtls();"/></TD>
        <TD>
    </tr>
</table>

<html:hidden property="hideRows" />



<table border="1" cellspacing="0" cellpadding="0" width="100%" class="bgndTable">
<caption>
<div id="sty" ><b class="SubHeader">Voucher Details</b></div></caption>
    <tr>    
        <td width="5%" class="labelText"><b>S No</b></td>
        <td width="28%" class="labelText"><b>Particulars</b></td>
        <td width="12%" class="labelText"><b>Account Code <script language="JavaScript" >lfnPrintMandatoryMark();</script></b></td>
        <td width="12%" class="labelText"><b>Employee No</b></td>        
        <td width="12%" class="labelText"><b>Charge Code</b></td>
        <td width="12%" class="labelText"><b>CC Sgrp Code</b></td>
        <td  class="labelText"><b>Dr</td>
    </tr>
</table>

<div id="Query" style="display:none">
<table width="100%" border="1" id="tableId1" cellpadding="0" cellspacing="0" class="bgndTable">
<tbody>
<tr>        
       <td width="5%">
         <html:text property="txtSNo"  size="4" readonly ="true" />
       </td>
       <td width="28%">
         <html:text property="txtPartMast"  size="41" />
       </td>
       <td width="12%">
         <html:text property="txtAcctIdMast" size="15" />
       </td>
       <td width="12%">
         <html:text property="txtSlCodeMast" size="15" />
       </td>        
       <td width="12%">
         <html:text property="txtChCodeMast" size="15" />
       </td> 
       <td width="12%">
         <html:text property="txtCcCodeMast"  size="15" />
       </td>
       <td >
         <html:text property="txtDrMast" size="20" style = "text-align:right"/>
       </td>
</tr>
</tbody>
</table>
</div>

</div>

<div id="New" style="display:block">
<logic:greaterThan name="frmLvEncPay" property="hideRows" value="0">
<div id="div1" class="div1">
<table width="100%" border="1" id="tableId" cellpadding="0" cellspacing="0" class="bgndTable">

  <logic:iterate name="frmLvEncPay" property="voucherDtls" id="ClaimPaymentBean" >
     <tr> 
        <html:hidden property="recordId" name="ClaimPaymentBean" />
        <td width = "5%">
         <html:text property="txtSNo"  size="4" readonly ="true" name="ClaimPaymentBean" />
       </td>
       <td width="23%">
         <html:text property="txtParticulars"  size="41" readonly ="true" name="ClaimPaymentBean" />
       </td>
       <td width="10%">
         <html:text property="txtAcctId" size="15" readonly ="true" name="ClaimPaymentBean" />
       </td>
       <td width="10%">
         <html:text property="txtEmpNo" size="15" readonly ="true" name="ClaimPaymentBean" />
       </td>        
       <td width="10%">
         <html:text property="txtChId" size="15" readonly ="true" name="ClaimPaymentBean" />
       </td> 
       <td width="10%">
         <html:text property="txtCCSgrpId"  size="15" readonly ="true" name="ClaimPaymentBean" />
       </td>
       <td >
         <html:text property="txtDrAmt" size="20" readonly ="true" name="ClaimPaymentBean" style = "text-align:right" />
       </td>
     </tr>
</logic:iterate>
</table>
</div>

</logic:greaterThan>
</div>

<html:hidden property="sAction" />
<html:hidden property="txtHidMode" />
<html:hidden property="txtOrderNoMast" value="" />
<html:hidden property="txtOpeningTime" />
<html:hidden property="txtHidVoucherId" value="" />
<html:hidden property="txtHidVouchType" value="" />
<html:hidden property="txtModuleId" value="7" />
<html:hidden property="txtPwoIndMast" value="" />
<html:hidden property = "txtSlTypeMast" value = "EMPL" />
<html:hidden property = "txtLinkMast" value = "" />
<html:hidden property = "txtVouchType" value = "" />
<html:hidden property = "txtCrMast" value = "" />
<html:hidden property="hidMIdforRetreival" value="74" />

<br>
  <HR>

<table cellpadding="0" cellspacing="0" width = "100%">
<tbody>
<tr>
    <td width = "81%">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    Total Amount</td>
    <td ><html:text property="txtTotDrAmt" size="20" readonly="true" style = "text-align:right" /> </td>
</tr>
</tbody>
</table>
<br>
<center>
<Table cellpadding="0" cellspacing="0">
	<TR>
		<TD>
		<html:button  styleClass="butto" onmouseover="this.style.color='yellow';" accesskey="S" disabled = "true" onclick="lfnValidateForm(frmLvEncPay);" onmouseout="this.style.color='white';" property="butSave" value="Save" /></TD>        
        <td>
        <html:button styleClass="butto" onmouseover="this.style.color='yellow';" onclick="lfnChangeMode();" onmouseout="this.style.color='white';" property="butMode" value="Enter Query"/></td>
        <TD>
		<html:button styleClass="butto"  onmouseover="this.style.color='yellow';" accesskey="Q"  disabled = "true" onclick = "lfnQuery();" property = "butQuery" onmouseout="this.style.color='white';" value="Query" /></TD>        
        <TD>
		<html:button styleClass="butto" onmouseover="this.style.color='yellow';" accesskey="R" onclick="lfnReset();" onmouseout="this.style.color='white';" property = "butReset" value="Reset" />		
	</TR>
</Table>
</center>
<br><br>
</html:form>
</body>
</html:html>
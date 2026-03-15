<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html locale="true"><head><html:base /><title>JV (Leave Encashment)</title>

<script language="javascript"    src='<html:rewrite page="/FINANCE/JavaScript/validate.js" />' ></script>

<script language="javascript"  src='<html:rewrite page="/COMMON/JavaScript/validate.js" />' ></script>
<script language="JavaScript1.2"  src='<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />'  ></script>
<script language="JavaScript1.2"  src='<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />' ></script>
<script language="JavaScript"  src='<html:rewrite page="/COMMON/JavaScript/calendar1.js" />' ></script>
<link rel="STYLESHEET"  type="text/css"  href='<html:rewrite page="/COMMON/CSS/Menucss.css" />' >
<link rel ="STYLESHEET" href ='<html:rewrite page="/COMMON/CSS/IBA.css" />' >


<style>
#div1 {
	LEFT: 22.5%; OVERFLOW: auto; WIDTH: 100%; TOP: 150px; HEIGHT: 76px
}
#div2 {
	LEFT: 22.5%; OVERFLOW: auto; WIDTH: 100%; TOP: 150px; HEIGHT: 350px
}

</style>

<script>
// Disable key F5 only
if (document.all)
{
    document.onkeydown = function ()
	{
        //var key_backSpace = 8; // 8 = backSpace
        var key_f5 = 116; // 116 = F5
		if (event.keyCode == key_f5) // || event.keyCode == key_backSpace)
		{
			event.keyCode = 0;
//            alert ("This function is disabled!");
            return false;
		}
		return true;
	}    
}

function lfnQuery()
{
    var d = document.frmLeaveEncPayVoucher;
    var today = new Date();
/*    if (d.lstAvail.value == "" || d.lstAvail.selectedIndex ==0)
    {
        alert("Please Select Voucher Type to Perform Query");
        d.lstAvail.focus();
        return false;        
    }
*/
    if(d.lstYearly.value == "" && d.sbut.value == "" && d.sretjr.value == "" && d.scert.value == "" && d.txtOrg.value == "" && d.txtLno.value == "" && d.txtLeavefrom.value == "" && d.txtPlace.value == "" && d.txtDttravel.value == "" && d.sbut1.value == "")
    {
        alert("Please Enter Values in Some Fields to Perform Query");
        return false;
    }
    window.status = "Query in Progress";
    d.txtOpeningTime.value = today.toString();
    d.txtHidVouchType.value = 'VOUCHTYPE$NJV';
    d.txtVouchType.value ='NJV'
    d.txtVouchNo.value = d.txtLno.value;
    d.txtVouchDate.value = d.txtLeavefrom.value;
    d.txtDocRef.value ='';// d.txtPlace.value;
    d.txtRemarks.value = d.txtDttravel.value;
    d.txtPartMast.value = d.lstYearly.value;
    d.txtAcctIdMast.value = d.sbut.value;
    d.txtSlTypeMast.value ="EMPL";
    d.txtSlCodeMast.value = d.txtEno.value;
    d.txtChCodeMast.value =d.sretjr.value;
    d.txtCcCodeMast.value = d.scert.value;
    d.txtChCodeMast.value =d.sretjr.value;
    d.txtDrMast.value = d.txtOrg.value;
    d.txtCrMast.value = d.txtLeaveto.value;    
    
    d.txtHidVoucherId.value = "";
    openCentered('<html:rewrite page="/HRMS/JSP/QueryVoucher.jsp" />','QueryScreen');
    return true;    
}

function lfnChangeMode()
{
    var d = document.frmLeaveEncPayVoucher;
    var val = event.srcElement.value;
    var newVal = "";
    
    if (val == "Enter Query")
    {

        // Disable some elements
        d.lstModeo.disabled = true;
        d.lstModer.disabled = true;
        d.butQuery.disabled=false;
        d.butGetDetails.disabled = true;
        d.txtLno.readOnly = false;        
//        d.txtLno.disabled=false; 
        d.txtPlace.readOnly = false;
        d.txtLno.value = "";
        d.txtPlace.value = "";
        d.txtLeavefrom.value = "";
        Query.style.display='block';
        document.frmLeaveEncPayVoucher.butMode.value="Enter New";
        document.frmLeaveEncPayVoucher.butQuery.disabled=false;
        document.frmLeaveEncPayVoucher.txtLno.value="";
        newVal = "Enter New";
        clearMasterDetails();        
        // Disable some elements        
        newVal = "Enter New";
    }
    else if (val == "Enter New")
    {
        d.lstModeo.disabled = false;
        d.lstModer.disabled = false;
        d.butQuery.disabled=true;
        d.butGetDetails.disabled = false;
        document.frmLeaveEncPayVoucher.butMode.value="Enter Query";

        document.frmLeaveEncPayVoucher.txtLeavefrom.value = getSysDate();
        Query.style.display='none';
        document.frmLeaveEncPayVoucher.txtLno.value="";
        
        document.frmLeaveEncPayVoucher.txtLno.readOnly = true;
        d.txtPlace.readOnly = true;
        Query.style.display='none';
        newVal = "Enter Query";
        d.lstModer.focus();
    }

    event.srcElement.value = newVal;
    return true;
}

function clearMasterDetails()
{   
   document.frmLeaveEncPayVoucher.sbut.value="";
   document.frmLeaveEncPayVoucher.sbut1.value="";
   document.frmLeaveEncPayVoucher.sretjr.value="";
   document.frmLeaveEncPayVoucher.scert.value="";
   document.frmLeaveEncPayVoucher.txtDttravel.value="";
   document.frmLeaveEncPayVoucher.lstYearly.value="";
   document.frmLeaveEncPayVoucher.txtOrg.value="";
   document.frmLeaveEncPayVoucher.txtLeaveto.value="";
}

	function lfnCheckAmt_Type(){
		var d = document.frmLeaveEncPayVoucher;

		// If the amount of the voucher is higher than Rs.5000, Show the advice pane to make a BPV rather than a CPV
		if (eval(d.txtSancAmt.value) > 5000 && d.lstVoucherType.value == 'VOUCHTYPE$CPV')
		{
			divAdvice.style.visibility = "visible";
		}
		else
		{
			divAdvice.style.visibility = "hidden";    
		}
		d.txtVouchDate.focus();
		return true;
	}

	function lfnPrintMandatoryMark(){
		document.write("<font class = 'mandatory'>");
		document.write("*");
		document.write("</font>");
	}

	function lfnPrintSearchableMark(){
		document.write("<font class = 'searchable'>");
		document.write("#");
		document.write("</font>");
	}

	function lfnDisableAll(){
		var d = document.frmLeaveEncPayVoucher;
		var i = 0;
		for (i = 0; i < d.elements.length; i++){
			d.elements[i].disabled = true;
		}
		
		return true;
	}

	function lfnEnableAll(){
		var d = document.frmLeaveEncPayVoucher;
		var i = 0;

		for (i = 0; i < d.elements.length; i++)
		{
			d.elements[i].disabled = false;
		}
		
		return true;
	}

	function lfnLoad(){
		var d = document.frmLeaveEncPayVoucher;
         

		window.status = "Welcome to IBA";
		// Load the values into all the dropdowns
		if (d.sload.value != "Loaded"){
    	d.saction.value = "PreLoad_Check_LeaveEncash";
            lfnEnableAll();            
			d.submit();
			return true;
		}
    if (d.lstTraino.value == "")
    d.lstTraino.value='SETLMODE$PAYROLL';
    
		if (d.saction.value == "GetDetails_Leave" ){
            if (d.lstModeo.selectedIndex !=0){
                d.butMode.disabled = true;
                d.butGetDetails.disabled = true;
                d.butSubmit.disabled = false;
                d.butSubmit.focus();
                return true;
            }
            else {
                alert('No Period Selected');
                d.lstModeo.focus();
                return false;
            }
		}
        if (d.saction.value == "PreLoad_Check_LeaveEncash" || d.saction.value == "ResetValue")
        {
//            d.butMode.disabled = false;
            d.lstModeo.focus();
        }
		if (d.saction.value == "setDetails_Leave" ){
            if(d.lstModer.value != "" || d.lstModer.selectedIndex!=0 )
            {
                d.butMode.disabled = true;
            }        
		}
        
        if(document.frmLeaveEncPayVoucher.saction.value=="NotAllowedSave"){
            for(i=0;i<document.frmLeaveEncPayVoucher.elements.length;i++){
                if (document.frmLeaveEncPayVoucher.elements[i].name !="butPrint" && document.frmLeaveEncPayVoucher.elements[i].name !="butReset")
                    document.frmLeaveEncPayVoucher.elements[i].disabled=true;
            }
            document.frmLeaveEncPayVoucher.butSubmit.disabled = true;
            document.frmLeaveEncPayVoucher.butMode.disabled = true;
            document.frmLeaveEncPayVoucher.butGetDetails.disabled = true;
        }

        if(document.frmLeaveEncPayVoucher.saction.value=="NotAllowed"){
           // alert("sdjgdfg");
            for(i=0;i<document.frmLeaveEncPayVoucher.elements.length;i++){
                if (document.frmLeaveEncPayVoucher.elements[i].name !="butPrint" && document.frmLeaveEncPayVoucher.elements[i].name !="butReset" && document.frmLeaveEncPayVoucher.elements[i].name !="butMode"  )
                    document.frmLeaveEncPayVoucher.elements[i].disabled=true;
               else
                        document.frmLeaveEncPayVoucher.elements[i].disabled=false;
            }
            document.frmLeaveEncPayVoucher.butSubmit.disabled = true;
            document.frmLeaveEncPayVoucher.butMode.disabled = true;
            document.frmLeaveEncPayVoucher.butGetDetails.disabled = true;
        }
	}


	function lfnReset(){
		var d = document.frmLeaveEncPayVoucher;
		lfnEnableAll();
		d.saction.value = "ResetValue";
		d.submit();
		return true;
	}

	function lfnSubmit(){
		var d = document.frmLeaveEncPayVoucher;

		if (!mandatory_Check(frmLeaveEncPayVoucher))
		{
			return false;
		}
        if (chkPaymentMode()){
            lfnEnableAll();
    //		alert("Your Details are Submitted!!");
            d.saction.value = "SaveDetails_LeaveEncash";
            d.submit();
            return true;
        }            
	}

	function validateDate_Check_Comp(Val) {

        if(document.frmLeaveEncPayVoucher.butMode.value =="Enter Query" )
        {
            var retVal="";
            if(date_Check(Val)==false) {
              return false;
            }
            if(frmLeaveEncPayVoucher.txtLeavefrom.value!="") {
             frmLeaveEncPayVoucher.txtLeavefrom.value=change_DateFormat(Val);
             frmLeaveEncPayVoucher.saction.value="CompareDate";
             frmLeaveEncPayVoucher.submit();
            }
        }
	}

function lfnGetDetails()
{
    var d = document.frmLeaveEncPayVoucher;

    if (d.lstModer.value == "" || d.lstModer.selectedIndex ==0)
    {
        alert("Please Select the Advance Request No!");
        d.lstModer.focus();
        return false;    
    }
/*    else if (d.lstAvail.value == "" || d.lstAvail.selectedIndex == 0)
    {
        alert("Please Select the Type of the Voucher!");   
        d.lstAvail.focus();
        return false;    
    }
*/
    lfnEnableAll();
    d.saction.value = "GetDetails_Leave";
    d.submit();
    return true;
}

function CheckAcctId(element)
{
    var d = document.frmLeaveEncPayVoucher;

    if (trim(element.value) == "")
    {
        return true;
    }    
    
    if (!check_length(element, 5))
    {
        return false;
    }

    return true;
}

function CheckChargeId(element)
{
    var d = document.frmLeaveEncPayVoucher;

    if (trim(element.value) == "")
    {
        return true;
    }    
    
    if (!num_Check(element.value, 2))
    {
        return false;
    }

    return true;
}

function CheckCostCenterCode(element)
{
    var d = document.frmLeaveEncPayVoucher;

    if (trim(element.value) == "")
    {
        return true;
    }    
    
    if (!check_length(element, 3))
    {
        return false;
    }

    return true;
}


	function CheckUSICode(element){
		var d = document.frmLeaveEncPayVoucher;

		if ((trim(element.value) == "*" && d.butMode.value == "Enter Query") || trim(element.value) == ""){
			return true;
		}    

		if (!ValidateUSICode(element.value)){
			return false;
		}
	}

	function lfnCheckStar(value){  
		var d = document.frmLeaveEncPayVoucher;

		if (d.butMode.value == "Enter New" || trim(event.srcElement.value) != "*")
		{
			return false;
		}

		// Remove the star from the control
		event.srcElement.value = "";

		// assign the voucher type to the hidden field
		d.txtHidVouchType.value = d.lstVoucherType.value;
		
		if (value == 'USI')
		{
			d.txtHidSearchType.value = "USIId";
			d.txtHidWhField.value = "txtUSICodeMast";
		}
		else
		{
			return false;
		}
			
		var today = new Date();
		d.txtOpeningTime.value = today.toString();
		openCentered('<html:rewrite page="/Finance/JSP/Search_IdDesc.jsp" />','SearchScreen');
		return true;    
	}

	function openCentered (url, windowName){
		return window.open(url, windowName,"toolbar=no,location=no,scrollbars=yes,width=700,height=550"); //, windowName, featureString);
	}

	function setHidden(){
		if (event.srcElement.name=="lstModer" && event.srcElement.selectedIndex!=0){
			document.frmLeaveEncPayVoucher.saction.value="setDetails_Leave";
			document.frmLeaveEncPayVoucher.submit();            
		}
	}
    function chkPaymentMode(){
/*        alert(event.srcElement.value);
        if (document.frmLeaveEncPayVoucher.lstTraino.selectedIndex!=0 && document.frmLeaveEncPayVoucher.lstTraino.value!="SETLMODE$VOUCHER"){
            alert('You Cannot Select payroll for Payment');
            document.frmLeaveEncPayVoucher.lstTraino.focus();
            return false;
        }
        else
*/        
            return true;
    }



function showDetails()
{
    if (frmLeaveEncPayVoucher.lstModer.selectedIndex!=0){
            today = new Date();
            document.frmLeaveEncPayVoucher.sload.value=today.toString();
           // document.frmLeaveEncPayVoucher.smode.value=document.frmLeaveEncPayVoucher.lstModer.value;
           
            window.open('<html:rewrite page="/HRMS/JSP/LeaveEncashApplnView.jsp" />', 'frmLeaveEncPayVoucher','toolbar:no,resizable:yes,width=850,height=600,scrollbars=yes');
            return true;
        }
}
</script>

</head>
<body bgcolor="white" topmargin="0" onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
    <!--script language="JavaScript1.2" src='<html:rewrite page="/COMMON/JavaScript/Menujs.js" />'></script-->
    <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />

<br>

<html:form name="frmLeaveEncPayVoucher" action="/LeaveEncPayVoucher" method="post" type="FCIPAY.HRMS.WEBTIER.Form.LTCAdvanceForm" >

	<br>

	<!-- Main Header of the Screen -->
	<center><b class="MainHeader" >JV for Leave Encashment</b>
	
	<!-- Show the advice only when the amount is higher than Rs.5000 and the voucher type is CPV -->

	<div id = "divAdvice" style = "visibility:hidden">
		<center><font face="Arial" color="red" size="3"><b>Amount is Higher than Rs. 5000, Advisable for a Bank Payment Advice</b></center>
	</div>

	<html:errors />
    <logic:empty name="frmLeaveEncPayVoucher" property="sload" >
        <center><font color="red" size="3">Initializing Form Values...</font></center>
    </logic:empty>        
	<html:messages id = "messages" message = "true" >
		<center><font face="Arial" color="blue" size="3"><b><bean:write name = "messages" /><b></font></center>
	</html:messages>
	<bean:define name="frmLeaveEncPayVoucher" id="onwrdList" property="onwrdList" />
	<bean:define name="frmLeaveEncPayVoucher" id="blockList" property="blockList" />
	<bean:define name="frmLeaveEncPayVoucher" id="retList" property="retList" />
	<bean:define name="frmLeaveEncPayVoucher" id="leaveList" property="leaveList" />    
	<!-- Hidden Fields -->

	<html:hidden property = "saction" />
  	<html:hidden property = "lstType" value="LEAVE PAYMENT VOUCHER" />
    <html:hidden property = "lstAppl" value=""/>
    
	<html:hidden property="sload"  />        

    <!-- new fields -->
    <html:hidden property = "txtVouchType" value = "" />
    <html:hidden property = "txtDrMast" value = "" />
    <html:hidden property = "txtCrMast" value = "" />    
    <html:hidden property = "txtModuleId" value ="74" />
    <html:hidden property = "txtHidVoucherId" value = ""/>
    <html:hidden property = "txtHidVouchType" value="" />
    
    <html:hidden property = "txtVouchNo" value = "2"/>
    <html:hidden property = "txtVouchDate" value="" />
    <html:hidden property = "txtDocRef" value = ""/>
    <html:hidden property = "txtRemarks" value="" />
    <html:hidden property = "txtPartMast" value = ""/>
    <html:hidden property = "txtAcctIdMast" value="" />
    <html:hidden property = "txtPwoIndMast" value = ""/>
    <html:hidden property = "txtOrderNoMast" value="" />
    <html:hidden property = "txtSlTypeMast" value="" />
    <html:hidden property = "txtSlCodeMast" value = ""/>
    <html:hidden property = "txtChCodeMast" value="" />
    <html:hidden property = "txtCcCodeMast" value = ""/>
    <html:hidden property = "txtLinkMast" value = ""/>    
    
    <html:hidden property = "txtOpeningTime" value="" />

	<!-- First Line After the Main Header Starts -->
	<table cellspacing="0" cellpadding="0" width="100%"  bgcolor="white"  border="0" >
		<tr>
			<td width ="18%">&nbsp;</td>
			<td width ="70%">&nbsp;</td>
			<td width ="8%"  class ="labelText" >&nbsp;</td>
			<td width ="4%" >
				<html:select property ="lstModeo" styleClass="required" >
					<html:option value="">Please Select</html:option>
					<html:options collection="onwrdList" property="pId" labelProperty="pDesc" />
				</html:select>
			</td>
		</tr>
	</table>

	<!-- First Line After the Main Header Ends -->

	<!-- Applicant Details Pane Starts -->
	 
	<table cellspacing="0" cellpadding="0" width="100%"  class="bgndTable"  border="0" >
	<caption><div id="sty" ><b class="SubHeader" >Applicant/Advance Details</b></div></caption>
	<tbody>
	<tr>
		<td width="20%"  class="labelText" >Advance Request No.&nbsp;<font color="red">*</font></td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap>
				<html:select size ="1" property ="lstModer" styleClass="required"  onchange = "setHidden();" >
					<html:option value="">Please Select</html:option>
					<html:options collection="blockList" property="DPndtid" labelProperty="DPndtid" />
				</html:select>
            <td width="2%" class="labelText" align="left" > <div id="A1" style="display:block" ><html:button property="butview" styleClass="butto" value="View" onclick="showDetails();" /></div></td>
                <td width="60%" >&nbsp;</td>
			   </td>
			 </tr>
			 </tbody>
		  </table>
		 </td>
		 
		 <td width="20%"  class="labelText" >Employee No</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text property="txtEno" size="10" disabled = "true" /></td>
			</tr>
			</tbody>
		  </table>
		</td>
	 </tr>
	  
	<tr>
		<td width="20%"  class="labelText" >Name</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text property="txtName" size="60" readonly = "true" tabindex="-1"  /> </td>
			 </tr>
			 </tbody>
			</table>
		 </td>
		 
		<td width="20%"  class="labelText" >Designation</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text property="txtDesignation" size="20" readonly ="true" tabindex="-1" /> </td>
			 </tr>
			 </tbody>
			</table>
		 </td>
	 </tr>
		
	<tr>
		<td width="20%"  class="labelText" >Pay of Employee</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text property="txtBasicpay" size="20" disabled ="true" /> </td>
			 </tr>
			 </tbody>
			</table>
		 </td>

		<td width="20%"  class="labelText" >Amount Sanctioned</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text property="txtTelno" size="20"  disabled="true" /> </td>        
			</tr>
			 </tbody>
			</table>
		 </td>     
	 </tr>
	<tr>
		<td width="20%"  class="labelText" >No of Leave Days</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text property="lstBlockYr" size="10" disabled ="true" /> </td>
			 </tr>
			 </tbody>
			</table>
		 </td>
	 </tr>
     
	 </tbody>
	 </table>

	<!-- Applicant Details Pane Ends -->


	<!-- Tour Details Pane Ends -->

	<!-- Voucher Header Pane Starts -->

	<table cellspacing="0" cellpadding="0" width="100%" class="bgndTable" border="0" >
	<caption><div id="sty" ><b class="SubHeader" >Voucher Header</b></div></caption>
	<tbody>
	<tr>
		<td width="20%"  class="labelText" >Document Location</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:textarea rows = "2" cols = "16" property = "txtSig1" readonly ="true" /></td>
			</tr>
			</tbody>
		  </table>
		</td>
		
<!--		<td width="20%"  class="labelText" >Voucher Type<font color="red">*</font></td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap>
				<html:select size ="1" property ="lstAvail" styleClass="required"  >
					<html:option value="">Please Select</html:option>
					<html:option value="VOUCHTYPE$BPV">BPV</html:option>
					<html:option value="VOUCHTYPE$CPV">CPV</html:option>
				</html:select>
			</td>
			</tr>
			</tbody>
		  </table>
		</td>
-->        
	</tr>
		
	<tr>
		<td width="20%"  class="labelText" >Voucher No.</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text property="txtLno" size="21" maxlength="15" onblur = "alphanum_Check(this.value);" disabled="true" /> </td>
			</tr>
			</tbody>
		  </table>
		  </td>
	   
		<td width="20%"  class="labelText" >Voucher Date&nbsp;<font color="red">*</font></td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text property="txtLeavefrom" size="21" onblur="validateDate_Check_Comp(this.value);" />
			  </td>
		   </tr>
		   </tbody>
		   </table>
		   </td>
	</tr>

<!--	<tr>
		<td width="20%"  class="labelText" >Voucher For</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:textarea property="txtLeaveto" rows="2" cols="16" disabled="true" /> </td>
			 </tr>
			 </tbody>
			</table>
		 </td>
		 
		<td width="20%"  class="labelText" >Payee Name</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text property="txtDojnpc" size="60" disabled="true" /> </td>
			 </tr>
			 </tbody>
			</table>
		 </td>
	 </tr>
-->     
	</tbody>
	</table>

	<!-- Voucher Header Pane Ends -->

	<!-- References Pane Starts -->
			
	<table cellspacing="0" cellpadding="0" width="100%"  class="bgndTable"  border="0" >
	<caption><div id="sty" ><b class="SubHeader" >References</b></div></caption>
	<tbody>
	<tr>
		<td width="20%"  class="labelText" >Document Reference</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text disabled="true" maxlength="20"  onblur = "alphanum_Check(this.value);" size="21" property="txtPlace" /></td>
			</tr>
			</tbody>
		</table>
		</td>
		<td width="20%"  class="labelText" >Remarks</td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
			  <td nowrap><html:text onblur="alphanum_Check(this.value);" maxlength="150" size="21" property="txtDttravel" /></td>
			</tr>
			</tbody>
			</table>
		</td>
	</tr>
	<tr>
		<td width="20%"  class="labelText" >Payment Mode<font color="red">*</font></td>
		<td width="30%" >
		  <table>
			<tbody>
			<tr>
				<td nowrap>				
					<html:select size ="1" property ="lstTraino" styleClass="required" onchange="chkPaymentMode();"  >
						<html:option value="">Please Select</html:option>
    					<html:options collection="retList" property="QCode" labelProperty="QType" />					</html:select>
				</td>
			</tr>
			</tbody>
		</table>
		</td>
	</tr>
	</tbody>
	</table>

	<!-- References Pane Ends -->

	<!-- Get Details Button -->
	<table width="100%" >
	   <tr align="right" >
		  <td>
			 <html:button styleClass="butto" onmouseover="this.style.color='yellow';" onclick="lfnGetDetails();" onmouseout="this.style.color='white';" property="butGetDetails" value="Get Details"/>
		  </td>
	   </tr>
	</table>


	<!-- Account Details Pane Starts -->

<table cols ="4" cellspacing="0" cellpadding="0" width="100%" class ="bgndTable"  border="1" >
<caption><div id="sty" ><b class ="SubHeader" >Account Details</b></div></caption>
<tbody>
<tr>
    <td width="24%" style = "text-align: center;"><b class ="labelText"  >Particulars</b></td>
    <td width="12%" style = "text-align: center;"><b class ="labelText" >Account Id</b></td>
    <td width="12%" style = "text-align: center;"><b class ="labelText" >S/L Code</b></td>
    <td width="12%" style = "text-align: center;"><b class ="labelText" >Charge Code</b></td>
    <td width="12%" style = "text-align: center;"><b class ="labelText" >Cost Center Code</b></td>
    <td width="14%" style = "text-align: center;"><b class ="labelText" >Dr</b></td>
    <td width="14%" style = "text-align: center;"><b class ="labelText" >Cr</b></td>
</tr>
</tbody>
</table>
<div id="Query" style="display:none">
<table width="100%" border="1" id="tableId1" cellpadding="0" cellspacing="0" class="bgndTable">
<tbody>
<tr>        
       <td width="24%" valign="middle" style = "text-align: center;">
         <html:text property="lstYearly"  size="34" />
       </td>
       <td  width="12%" valign="middle" style = "text-align: center;">
         <html:text property="sbut" size="12" />
       </td>
       <td  width="12%" valign="middle" style = "text-align: center;">
         <html:text property="sbut1" size="12" />
       </td>        
       <td  width="12%" valign="middle" style = "text-align: center;">
         <html:text property="sretjr" size="12" />
       </td> 
       <td  width="12%" valign="middle" style = "text-align: center;">
         <html:text property="scert"  size="12" />
       </td>
       <td width="14%" valign="middle" style = "text-align: center;">
         <html:text property="txtOrg" size="13" />
       </td>
       <td  width="14%" valign="middle" style = "text-align: center;">
         <html:text property="txtLeaveto" size="12" />
       </td> 
       
</tr>
</tbody>
</table>
</div>

	<!-- Account Details Pane Ends -->
	<table cellspacing="0"  cellpadding="0"  width="100%"  class="bgndTable"  border="1"  name="Voucher_Details"  id="Voucher_DetailsMast" >
	<tbody>
    <logic:iterate name="frmLeaveEncPayVoucher" property="leaveList" id="Index"  indexId="Counter">    
            <tr>
                <td width="24%" valign="middle" style = "text-align: center;" >
                    <html:text property="DPndtid" size = "35" disabled = "true"  name="Index" />
                </td>
                <td width="12%" valign="middle" style = "text-align: center;" >
                    <html:text property="DPname" size = "15" disabled = "true"  name="Index" />
                </td>
                <td  width="12%" valign="middle" style = "text-align: center;" >
                    <html:text property="DOB" size = "15" disabled = "true"  name="Index" />
                </td>
                <td width="12%" valign="middle" style = "text-align: center;" >
                        <html:text property="RELTNAME" size = "15" disabled = "true"  name="Index" />
                </td>
                <td width="12%" valign="middle" style = "text-align: center;" >
                        <html:text property="BYear" size = "15" disabled = "true"  name="Index" />
                </td>
                <td width="14%" valign="middle" >
                    <html:text  name="Index" property="RESIDENT" size = "19" style = "text-align: right;" disabled = "true" />
                </td>
                <td width="14%" valign="middle" >
                    <html:text  name="Index" property="AGE" size = "19" style = "text-align: right;" disabled = "true" />
                </td>
            </tr>
        </logic:iterate>            
	</tbody>
	</table>
    

	<br><br>


	<!-- Buttons -->
        <center>
        <table cellspacing="0" cellpadding="0" >
            <tr>
                <td>
                    <html:button accesskey="B" value="Submit" disabled = "true" styleClass="butto" onclick = "lfnSubmit();" property="butSubmit" onmouseover="this.style.color= 'yellow';" onmouseout="this.style.color= 'white';" />                
                </td>                
                <td>
                    <html:button accesskey="R" value="Reset"  styleClass="butto" onclick = "lfnReset();"  property="butReset"  onmouseover="this.style.color= 'yellow';" onmouseout="this.style.color= 'white';" />                
                </td>
                <td>
                    <html:button styleClass="butto" onmouseover="this.style.color='yellow';" onclick="lfnChangeMode();" onmouseout="this.style.color='white';" property="butMode" value="Enter Query"/></td>                
                </td>                        
                <td>
                    <html:button accesskey="Q" value="Query" disabled = "true" styleClass="butto" onclick = "lfnQuery();" property="butQuery" onmouseover="this.style.color= 'yellow';" onmouseout="this.style.color= 'white';" />                
                </td>                
            </tr>    
        </table>
        </center>

	<br><br>

			
</html:form>
</body>
</html:html> 

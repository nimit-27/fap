<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
	<HEAD>
    <html:base/>
	<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />  
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>           
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </head>
  <BODY scroll=yes onload="lfnLoad();history.forward(1); " onbeforeunload="confWindowClose()" onunload="handleOnClose()" ></BODY>
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintLoanAdjustment" name="frmLoanAdjustment" type="FCIPAY.Payroll.WEBTIER.Form.LoanAdjustmentForm">
  <bean:define id="ParentForm" name="frmLoanAdjustment" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>LOAN AND ADVANCES ADJUSTMENT SCREEN</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
            <!--General Information Row Starts -->
            <TR>
              <TD class=subHeader colspan=6> Employee Header</TD>
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="6"></td>
            </tr>         
                            
            
            <tr></tr>
            <table  cellSpacing=0 cellPadding=0 border=0> 
            
                <TR>
                  <TD class=labelText><bean:message key="Payroll.Emp.loanopenyymm" /></TD>
                  <td align="left" >
				      <logic:equal name="frmLoanAdjustment" property="screenMode" value="Q">
                      <html:text property="txtOpenYYMM" size="23" styleClass="locked" readonly="true" value="201304" maxlength="6" onblur="chk_YearMonth()" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };"/>
					  </logic:equal>
				      <logic:notEqual name="frmLoanAdjustment" property="screenMode" value="Q">
                      <html:text property="txtOpenYYMM" size="23" styleClass="locked" readonly="true" maxlength="6"  onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };"/>
					  </logic:notEqual>
                  </td>  
                  
              </TR> 

				<TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" >
                  <html:text  property="txtEmpNo" size="23" styleClass="required" readonly="true" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" onclick ="ShowEmpNo(this.alt);">
                  </td>  
                  
                  <td class=labelText  >Employee Name </td>
                  <td>                             
                  <html:text  property="txtEmpName" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                    
                  <td  >&nbsp;</td>
                  <td >&nbsp;</td>
              </TR> 
              
              <TR>              
                  <TD width="15%" class=labelText><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtEmpCategory" styleClass="locked" readonly="true" size="23"/></td>                  
                                    
              </tr>
                      
              <tr>
                  <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType"   size="23" styleClass="locked" readonly="true"/>                  
                  </td> 
                  
                    
              
                   <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text property="txtEmpStatus" name="frmLoanAdjustment" readonly="true" styleClass="locked"  size="23"  />
            </td>    <tr>   
                   <td width="15%" class=labelText> CPF Code </td>                            
                  <td ><html:text property="txtEmpCPF" name="frmLoanAdjustment" readonly="true" styleClass="locked" size="23"   />
            </td>   
                  <td>&nbsp;</td>
              </tr>   
            </table>     
          </tr>                          
  </table>
    <table cellspacing=0 cellpadding=0 border=0 >
         <!-- Detail Information Row starts -->
 	 <TR height="200">
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
            <TABLE cellSpacing=0 cellPadding=0 border = 0 >
               <TR>          
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
            
                   <!--       <TD class=subHeader colspan=11> Loan/Advances Details </TD> -->
                    <td bgcolor="#4682B4" nowrap class=actTabText> Loan/Advances Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>                  
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="85%">&nbsp;</td>
                    
              </tr> 
            <tr height="10"><td class=userText colspan="17"></td></tr>            
            <TR height=10>
       <!-- Detail table Container starts -->
                <TD colspan=17>
                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                        <TD>
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0>
                          <TBODY>                                
                            <tr height = 3><td></td></tr>                          
                          </TBODY>
                        </TABLE>
                      </TD>
                    </TR>                       
                  </TBODY>
                </TABLE>
              </td>
            </tr>      
<!-- Tab table Row 3 starts -->
    </TABLE>
    <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellSpacing=0 cellPadding=0 >
        <TR>
          <TD class=subHeader colspan=11> </TD>
        </TR>   
        <TR height=20>
 <!-- Detail table Container starts -->
                <TD >
                  <TABLE cellSpacing=0 cellPadding=0 border=0 >
                    <TBODY>
                      <TR>
                        <TD >
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0 border=0>
                          <TBODY>                     
               <TR>    
				   <td  width="15%" class=labelText>Select Loan/Advance</TD>
				   <td align="left" >
				   <html:text property="txtLoan" styleClass="required" maxlength="50" size="23" readonly="true" alt="<%=String.valueOf(i)%>"  onchange="GetDetails()" />
				   <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center"  property="buttxtEmpNo"  onclick="ShowLoanAdvance(this.alt);" >
				   <html:text property="txtLoanDesc"  styleClass="locked" size="42"  maxlength="90" readonly="true" alt="<%=String.valueOf(i)%>"   /> 
				   </td>
				   <td  width="15%" class=labelText>Recovery Start YYMM</TD>
				   <td align="left" >
				   <html:text property="txtRecvYYMM" styleClass="locked" maxlength="50" size="23" readonly="true" alt="<%=String.valueOf(i)%>" />
				   </td>
			  </TR>
              <tr>  
		          <td class=labelText>Loan Amount </td>
                  <td>                             
                  <html:text  property="txtLoanAmt"  maxlength="50" size="23" readonly="true" styleClass="locked"  />                 
                  </td>   
                  <td class=labelText> Current Outstanding Principal </td>
                  <td>                             
                  <html:text  property="txtOutPrn" size="23" readonly="true" styleClass="locked" />                 
                  </td>                                        
              </tr> 
              <tr>  
                  <td class=labelText> Outstanding as on YYMM Amount </td>
                  <td>                             
                  <html:text  property="txtOutAson" size="23" readonly="true" styleClass="locked" />                 
                  </td>  
                  <td class=labelText>Monthly Instalment Amount</td>
                  <td>                             
                  <html:text  property="txtPaidPrnAmt"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
				  
              </tr> 
               <tr> 
                  <td class=labelText>Total Principal Installs </td>
                  <td>                             
                  <html:text  property="txtAlreadyPrn"  maxlength="50" size="23" readonly="true" styleClass="locked"  />                 
                  </td>    
                  <td class=labelText>Balance Principal Installments </td>
                  <td>                             
                  <html:text  property="txtPaidPrn"  maxlength="50" size="23" readonly="true" styleClass="locked"  />                 
                  </td>
               </tr>  
               <tr> 
                  <td class=labelText> Adjust Outstanding as on YYMM Amount</td>
                  <td> 
				      <logic:equal name="frmLoanAdjustment" property="screenMode" value="Q">
	                      <html:text  property="txtAdjOutAson" maxlength="50" size="23" readonly="true" styleClass="locked"  />
					  </logic:equal>
					  <logic:notEqual name="frmLoanAdjustment" property="screenMode" value="Q">
					      <html:text  property="txtAdjOutAson" maxlength="50" size="23" styleClass="required" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };" />                 
					  </logic:notEqual>
                  </td>    
               </tr>  
                   
                 <tr> 
                     <td colspan=6>&nbsp;</td> 
                           </tr>
                          <tr> 
                          <td  width="15%" class=labelText></td>
                              <td ></td>  
                              <td colspan=6>&nbsp;</td> </tr>                          
                          <tr height =1><td></td></tr>                          
                         </TBODY>
                       </TABLE>
                      </TD>
                    </TR>                       
                  </TBODY>
                </TABLE>
              </td>
            </tr>
<!-- Tab table Row 3 starts -->
        </TABLE>
      </td>
    </tr>
                <!-- Tab Table Ends -->
<!-- Bottom Blue Bar -->
      <TR>
        <td align=center bgcolor=#4682b4 width="40%"></td>
        <td bgColor=#4682b4></td>
        <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
      </TR>
    </TABLE> 
<!-- Container Table Ending Columns Starts-->
    </TD>    
</TR>
</TBODY>
</TABLE>
</div>

<html:hidden property="headerPrimaryKey" name="frmLoanAdjustment"  />

<html:hidden property="screenMode" name="frmLoanAdjustment"  />
<html:hidden name="frmLoanAdjustment"  property="screenName" value="LoanAdjustmentScreen" />
<html:hidden name="frmLoanAdjustment"  property="forwardedPage" />

<html:hidden property="txtTransID"  name="frmLoanAdjustment"  />
<html:hidden property="txtLoanFlag"  name="frmLoanAdjustment"  />
<html:hidden property="lovKey" name="frmLoanAdjustment"  />
<html:hidden property="txtFields" name="frmLoanAdjustment"  />
<html:hidden property="txtSearchFields" name="frmLoanAdjustment"  />
<html:hidden property="txtDisplayFields" name="frmLoanAdjustment"  />
<html:hidden property="txtIndex" name="frmLoanAdjustment"  />
<html:hidden property="txtInputField" name="frmLoanAdjustment"  />
<html:hidden property="buttonFlag" name="frmLoanAdjustment"  />
<html:hidden property="userPageRequested" name="frmLoanAdjustment" />
<html:hidden property="pageRequested" name="frmLoanAdjustment" />
<html:hidden property="loginLocCode" name="frmLoanAdjustment" />
<html:hidden property="positionRequested" name="frmLoanAdjustment" />
<html:hidden property="userPositionRequested" name="frmLoanAdjustment" />
<html:hidden  property="hdnAction" name="frmLoanAdjustment" />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function lfnLoad()
{   
   var mode = document.all.screenMode.value;

    if(mode == '')
    {
        doQueryMode();
    }
	document.all.butInsertMode.disabled="true";    
	document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
    hedMenuHandling(mode);
}

function doQueryMode()
{
    var mode = document.all.screenMode.value;
    document.all.buttonFlag.value='';    
    frmLoanAdjustment.action="../../../LoanAdjustmentQueryMode.do"
    frmLoanAdjustment.submit();
}

function doRefresh()
{
    frmLoanAdjustment.action="../../../LoanAdjustmentRefresh.do"
    frmLoanAdjustment.submit();
}

function ShowEmpNo()
{
	var yearMObj = document.getElementById("txtOpenYYMM");
	if (yearMObj.value=="")
	{
		alert("Please select YYYYMM");
		yearMObj.focus();
		return false;
	}
	  mode = document.all.screenMode.value;
	  frmLoanAdjustment.lovKey.value = "LoanAdjustmentEmpLov" + frmLoanAdjustment.screenName.value + frmLoanAdjustment.screenMode.value;
	  frmLoanAdjustment.queryParam.value="txtSiteID="+ frmLoanAdjustment.loginLocCode.value +",txtOpenYYMM="+ frmLoanAdjustment.txtOpenYYMM.value+",hdnEmpLbrFlag="+ frmLoanAdjustment.hdnEmpLbrFlag.value ;
	  frmLoanAdjustment.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtEmpCategory,txtEmpType,txtEmpStatus,txtEmpCPF";
	  frmLoanAdjustment.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.LoanForeclosure.CPFCode,Payroll.LoanForeclosure.EmpName";
	  frmLoanAdjustment.txtInputField.value ="";     
	  showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLoanAdjustment');
	  return true;
}

function ShowLoanAdvance()
{
  if(document.all.txtEmpNo.value=="" )
  {
   alert("Please Select the Employee first");
   return;
  }
  mode = document.all.screenMode.value;
  frmLoanAdjustment.lovKey.value = "LoanAdjustmentPayLov" + frmLoanAdjustment.screenName.value + frmLoanAdjustment.screenMode.value;
  frmLoanAdjustment.queryParam.value ="txtEmpNo="+document.all.txtEmpNo.value;
  frmLoanAdjustment.txtDisplayFields.value = "txtLoan,txtLoanDesc,txtOutPrn,txtTransID,txtLoanFlag,txtRecvYYMM";
  frmLoanAdjustment.txtSearchFields.value ="";
  frmLoanAdjustment.txtInputField.value ="txtLoan";   
  showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmLoanAdjustment');
  return true;
}

function GetDetails()
{
  document.all.hdnAction.value="getDtls";
  frmLoanAdjustment.action="../../../LoanRescheduleGetDetails.do";
  //frmLoanAdjustment.submit();
}

function doInsertMode()
{
    frmLoanAdjustment.action="../../../LoanAdjustmentNewMode.do"
    frmLoanAdjustment.submit();
}


function getHeaderRecord()
{
	if(mandatory_Check("frmLoanAdjustment"))
	{
		document.all.buttonFlag.value='';
		frmLoanAdjustment.action="../../../LoanAdjustmentGetHeaderAction.do"
		frmLoanAdjustment.submit();
	}
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmLoanAdjustment.userPositionRequested.value = 1*frmLoanAdjustment.positionRequested.value + 1;
    frmLoanAdjustment.action="../../../LoanAdjustmentGetNextHeader.do";
    frmLoanAdjustment.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmLoanAdjustment.userPositionRequested.value = 1*frmLoanAdjustment.positionRequested.value - 1;
    frmLoanAdjustment.action = "../../../LoanAdjustmentGetNextHeader.do";
    frmLoanAdjustment.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmLoanAdjustment.userPositionRequested.value = 1*frmLoanAdjustment.newPositionRequested.value;
    frmLoanAdjustment.action = "../../../LoanAdjustmentGetNextHeader.do";
    frmLoanAdjustment.submit();
}

function chk_YearMonth()
{
	var yearMObj = document.getElementById("txtOpenYYMM");
	var yearM = yearMObj.value;
	var y1 = yearM.substring(2,4);
	var month = yearM.substring(4,6);
	
	if(yearM!=""){
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
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;                    
				return false;
			}
			/*if (y2!='03')
			 {
			    alert("Please enter month of March");
				event.srcElement.select();
				event.srcElement.focus();
				event.returnValue=false;            
			    return false;

			 }*/
			return true;
		 }
		 else
		 {
			  document.getElementById("txtYYMM").select();
			  return false;
		 }
    }
}

function checkInstAmtU()
{
	var instalmntAmt = parseInt(document.getElementById("txtPaidPrnAmt").value,10);
	var balAmt = parseInt(document.getElementById("txtAdjOutAson").value,10);
    if (isNaN(instalmntAmt))
	{
		document.getElementById("instalmntAmt").value= "";
		return false;
	}

	if (isNaN(balAmt))
	{
		document.getElementById("balAmt").value= "";
		return false;
	}
	if(instalmntAmt > balAmt)
	{
		alert("Installment amount can not exceed Balance amount");
		return false;
	}
	var x=balAmt/instalmntAmt;
	var y=balAmt%instalmntAmt;
	var diff= x - Math.floor(x);
	diff = Math.ceil(diff);
	if (parseInt(diff)  > 0)
	{
		document.getElementById("txtPaidPrn").value=parseInt(Math.floor(x)) + 1;                                             
	}
	else
	{
		document.getElementById("txtAdjOutAson").value = Math.floor(x);  
	}
	return true;
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
	var recvyymm=document.getElementById("txtRecvYYMM").value;
	var outstnd=document.getElementById("txtOutPrn").value;
	var openyymm=document.getElementById("txtOpenYYMM").value;
	var asonyymm=document.getElementById("txtOutAson").value;
	
	
	if (recvyymm > openyymm)
	{
		alert("This loan/advance can not be adjusted as the recovery is started after "+openyymm);
		return false;
	}
	if (outstnd=='0')
	{
		alert("This loan/advance can not be adjusted as the current outstanding is 0");
		return false;
	}
	if(asonyymm=='0')
	{
		alert("The Outstanding balance as on March is 0, so this loan/advance can not be adjusted.");
		return false;
	}
    if(mandatory_Check("frmLoanAdjustment"))
    {     
		var answer = confirm("Have you verified the data.Press OK to save the record!!!!")
		if (!answer)
		{
			return false;
		}
		else
		{
     		frmLoanAdjustment.headerFields.value = "true";
			frmLoanAdjustment.headerDataChanged.value = "true";
			document.all.butSave.disabled="true";
			document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
			frmLoanAdjustment.action = "../../../LoanAdjustmentSaveAction.do";  
			frmLoanAdjustment.submit();
		}
	}
}


</script>
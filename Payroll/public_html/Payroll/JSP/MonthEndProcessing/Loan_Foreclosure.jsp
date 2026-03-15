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
  <BODY scroll=yes  onload="lfnLoad(); history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false"></BODY>
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="LoanForeclosureAction" name="frmLoanForeclosure" type="FCIPAY.Payroll.WEBTIER.Form.LoanForeclosureForm">
  <bean:define id="ParentForm" name="frmLoanForeclosure" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>LOAN FORECLOSURE</TD>
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
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" >
                  <html:text  property="txtEmpNo"   size="23" styleClass="required" readonly="true" />
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" onclick ="ShowEmpNo(this.alt);">
                  </td>  
                  
                  <td class=labelText  >Employee Name </td>
                  <td>                             
                  <html:text  property="txtEmpName"   size="23" readonly="true" styleClass="locked" />                 
                  </td>
                    
                  <td  >&nbsp;</td>
                  <td >&nbsp;</td>
              </TR> 
              
              <TR>              
                  <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn"   size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtEmpCategory" styleClass="locked" readonly="true" size="23"/></td>                  
                                    
              </tr>
                      
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType"   size="23" styleClass="locked" readonly="true"/>                  
                  </td> 
                  
                    
              
                   <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text property="txtEmpStatus" name="frmLoanForeclosure" readonly="true" styleClass="locked" size="23"   />
            </td>    <tr>   
                   <td width="15%" class=labelText  > CPF Code </td>                            
                  <td ><html:text property="txtEmpCPF" name="frmLoanForeclosure" readonly="true" styleClass="locked"  size="23"  />
            </td>   
            <td class=labelText  >ForeClosure Date </td>    
                  <td>
                  <html:text  property="txtSysdate" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
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
                            <td align="left" cellspacing ="4"> 
                          <html:text property="txtLoan"  styleClass="required" style="width:70%" readonly="true" alt="<%=String.valueOf(i)%>"  onchange="GetDetails()"   />
                           <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center"  property="buttxtEmpNo"  onclick="ShowLoanAdvance(this.alt);" > <!--</td>-->
                       <!-- <td> --> 
                       <!--    <td align="right" class=labelText > Description</td>
                          <td> -->
                
                      <td align="left" colspan ="1"> 
                          <html:text property="txtLoanDesc"  styleClass="locked" size="40"  maxlength="120" readonly="true" alt="<%=String.valueOf(i)%>"   /> </td>
                    
                     <td class=labelText align="right" >Loan Amount </td>
                  <td>                             
                  <html:text  property="txtLoanAmt"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                      <tr>         <td class=labelText  >Outstanding Principal </td>
                         
                  <td>                             
                  <html:text  property="txtOutPrn"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>                                        
                 
                 <td> 
                   <td class=labelText align="right"  >Outstanding Interest </td>
                  <td>                             
                  <html:text  property="txtOutInt"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                 
               <!--  <td>
       <html:button property="butLpc" value="GetDetails"  />
       </td>  -->
      <tr> 
        
                  
                 <td class=labelText colspan ="0" > Total Principal Installs </td>
                  <td>                             
                  <html:text  property="txtPrnInstalNo"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                   <td>  
                   <td class=labelText align="right" >Total Interest Installs </td>
                  <td>                             
                  <html:text  property="txtIntInstalNo"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  <tr> 
                   <td class=labelText  >Balance Principal Installs </td>
                  <td>                             
                  <html:text  property="txtBalPrnInstal"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  <td> 
                   <td class=labelText align="right" >Balance Interest Installs </td>
                  <td>                             
                  <html:text  property="txtBalIntInstal"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  <tr> 
                    <td class=labelText  >Principal Installment Amount </td>
                  <td>                             
                  <html:text  property="txtMonPrnAmt"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  <td> 
                  <td class=labelText align="right" >Interest Installment Amount </td>
                  <td>                             
                  <html:text  property="txtMonIntAmt"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  <tr> 
                     <td class=labelText align="left"  >Paid Principal during Foreclosure  </td>
                  <td>                             
                  <html:text  property="txtPaidPrn"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
               <td> 
                 
                   <td class=labelText  align="right">Paid Interest during Foreclosure</td>
                  <td>                             
                  <html:text  property="txtPaidInt"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  <tr> 
                    
                  <td class=labelText  >Receipt No </td>
                  <td>                             
                  <html:text  property="txtReceiptNo" maxlength="50" size="23" readonly="false" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode !=46 || event.keyCode > 57))return false;" />                 
                  </td>
                
                <td>   <td class=labelText  align="right">Receipt Amount </td>
                  <td>                             
                  <html:text  property="txtReceiptAmt" maxlength="50" size="23" readonly="false" styleClass="required" onblur="return chkRcptAmt();" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"/>                 
                  </td>
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
        <td  bgcolor=#4682b4>
       <html:button property="butLpc" value="ForeClose" onclick="LoanForeclose()"  />
       </td>
       
       <!--
<td  bgcolor=#4682b4>
       <html:button property="butLpc" value=" Calculate Interest" onclick="ForecloseInterest()"  />
       </td>
 -->        <td bgColor=#4682b4></td>
        
        <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
      </TR>
    </TABLE> 
<!-- Container Table Ending Columns Starts-->
    </TD>    
</TR>
</TBODY>
</TABLE>
</div>

<html:hidden property="headerPrimaryKey" name="frmLoanForeclosure"  />

<html:hidden property="screenMode" name="frmLoanForeclosure"  />
<html:hidden name="frmLoanForeclosure"  property="screenName" value="MaintLoanForeclosure" />
<html:hidden name="frmLoanForeclosure"  property="forwardedPage" />

<html:hidden property="txtT"  name="frmLoanForeclosure"  />
<html:hidden property="txtTransID"  name="frmLoanForeclosure"  />
<html:hidden property="txtLoanFlag"  name="frmLoanForeclosure"  />
<html:hidden property="lovKey" name="frmLoanForeclosure"  />
<html:hidden property="txtFields" name="frmLoanForeclosure"  />
<html:hidden property="txtSearchFields" name="frmLoanForeclosure"  />
<html:hidden property="txtDisplayFields" name="frmLoanForeclosure"  />
<html:hidden property="txtIndex" name="frmLoanForeclosure"  />
<html:hidden property="txtInputField" name="frmLoanForeclosure"  />
<html:hidden property="buttonFlag" name="frmLoanForeclosure"  />
<html:hidden property="userPageRequested" name="frmLoanForeclosure" />
<html:hidden property="pageRequested" name="frmLoanForeclosure" />
<html:hidden property="loginLocCode" name="frmLoanForeclosure" />
<html:hidden property="positionRequested" name="frmLoanForeclosure" />
<html:hidden property="userPositionRequested" name="frmLoanForeclosure" />
<html:hidden  property="hdnAction" name="frmLoanForeclosure" />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">
//int chk_flag=0;
function lfnLoad()
{   
   var mode = document.all.screenMode.value;
  //   alert(mode);
  
 /*  if(document.all.txtLoan.value == 87)
  {
    newfunc();
  }
   alert("HI" +document.all.txtPrnInstalNo.value);
    if((document.all.txtPrnInstalNo.value - document.all.txtBalPrnInstal.value) <=12)
    {
        document.all.txtT.value=1;
    }
    if ((document.all.txtPrnInstalNo.value - document.all.txtBalPrnInstal.value)>12 && (document.all.txtPrnInstalNo.value - document.all.txtBalPrnInstal.value)<=24)
    {
      document.all.txtT.value=2;
    }
    if((document.all.txtPrnInstalNo.value - document.all.txtBalPrnInstal.value)>24)
    {
      document.all.txtT.value=3;
    } 
    alert("T" +(document.all.txtPrnInstalNo.value - document.all.txtBalPrnInstal.value));
  } */
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='N')
    {        
          document.all.butSave.disabled="true";
       // document.all.butCancel.disabled = "true";
        //document.all.txtTrnsfrTo.disabled = "";
       // document.all.txtTrnsfrReason.disabled = "";
        //document.all.txtTrnsfrDt.disabled = "";
        //document.all.txtRlvngDt.disabled = "";
        //document.all.txtRlvngTime.disabled = "";
    }
    if(mode=='Q')
    {
    document.all.butLpc.disabled = "true";
    }
    if(mode== 'U')
    {
    document.all.butSave.disabled="true";
    document.all.butLpc.disabled = "true";
    }
    hedMenuHandling(mode);
    
disableInsert();
}

function disableInsert(){
   /* //Disabling INsert Mode  and Delete Mode 
    if (frmLoanForeclosure.hdnEmpLbrFlag.value=='E') {
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butDel.disabled="true";
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
    }*/
}
function newfunc()
{
if((document.all.txtPrnInstalNo.value - document.all.txtBalPrnInstal.value) <=12)
    {
        document.all.txtT.value=1;
    }
    if ((document.all.txtPrnInstalNo.value - document.all.txtBalPrnInstal.value)>12 && (document.all.txtPrnInstalNo.value - document.all.txtBalPrnInstal.value)<=24)
    {
      document.all.txtT.value=2;
    }
    if((document.all.txtPrnInstalNo.value - document.all.txtBalPrnInstal.value)>24)
    {
      document.all.txtT.value=3;
    } 
    alert("T" +(document.all.txtPrnInstalNo.value - document.all.txtBalPrnInstal.value));
}
function doQueryMode()
{
    var mode = document.all.screenMode.value;
   //  alert(mode);
    document.all.buttonFlag.value='';    
    frmLoanForeclosure.action="../../../LoanForeclosureQueryMode.do"
    frmLoanForeclosure.submit();
}

function doRefresh()
{
    frmLoanForeclosure.action="../../../LoanForeclosureRefresh.do"
    frmLoanForeclosure.submit();
}

function ShowEmpNo()
{
    mode = document.all.screenMode.value;
    if(mode == 'N')
    {    
      frmLoanForeclosure.lovKey.value = "LoanForeclosueEmpLOV" + frmLoanForeclosure.screenName.value + frmLoanForeclosure.screenMode.value;
      frmLoanForeclosure.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtEmpCategory,txtEmpType,txtEmpStatus,txtEmpCPF";      
      frmLoanForeclosure.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.LoanForeclosure.CPFCode,Payroll.LoanForeclosure.EmpName";      
      frmLoanForeclosure.txtInputField.value ="";     
      frmLoanForeclosure.queryParam.value= "txtSiteID="+frmLoanForeclosure.loginLocCode.value+",hdnEmpLbrFlag="+frmLoanForeclosure.hdnEmpLbrFlag.value;
      showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLoanForeclosure');
      return true;
    }
    else if(mode== 'Q')
    {
      frmLoanForeclosure.lovKey.value = "LoanForeclosueEmpLOV" + frmLoanForeclosure.screenName.value + frmLoanForeclosure.screenMode.value;      
      frmLoanForeclosure.txtDisplayFields.value = "txtEmpNo";     
      frmLoanForeclosure.txtInputField.value ="";     
      frmLoanForeclosure.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.LoanForeclosure.CPFCode,Payroll.LoanForeclosure.EmpName";
      frmLoanForeclosure.queryParam.value= "txtSiteID="+frmLoanForeclosure.loginLocCode.value+",hdnEmpLbrFlag="+frmLoanForeclosure.hdnEmpLbrFlag.value;
      showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLoanForeclosure');
      return true;
  } 
}

function ShowLoanAdvance()
{
mode = document.all.screenMode.value;
  if(mode == 'N')
  {
  frmLoanForeclosure.lovKey.value = "LoanAdvanceLOV" + frmLoanForeclosure.screenName.value + frmLoanForeclosure.screenMode.value;
  frmLoanForeclosure.txtDisplayFields.value = "txtLoan,txtLoanDesc,txtOutPrn,txtOutInt,txtTransID,txtLoanFlag";
  frmLoanForeclosure.txtSearchFields.value ="";
 // frmLoanForeclosure.txtIndex.value =i;      
  frmLoanForeclosure.txtInputField.value ="txtLoan";   
  if(document.all.txtEmpNo.value=="" )
  {
   alert("Please Select the Employee first");
   return;
  }
   else
   {
   //alert("value" +document.all.txtEmpNo.value);
   frmLoanForeclosure.queryParam.value ="txtEmpNo="+document.all.txtEmpNo.value;
   }
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmLoanForeclosure');
    return true;
 }
 else
 {
 document.all.txtLoan.disabled ="true";
 document.all.buttxtEmpNo.disabled = "true";
 }
 
}

function LoanForeclose()
{   
    if(mandatory_Check("frmLoanForeclosure"))
    {
  //  frmLoanForeclosure.detailDataChanged.value="true";
    frmLoanForeclosure.headerDataChanged.value="true";
    frmLoanForeclosure.action="../../../LoanForeclosureSave.do"
    document.all.butLpc.disabled = "true";
    frmLoanForeclosure.submit();
    }
    
    
}

function doInsertMode()
{
    frmLoanForeclosure.action="../../../LoanForeclosureNewmode.do"
    frmLoanForeclosure.submit();
}


function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    frmLoanForeclosure.action="../../../LoanForeclosureGetHeaderAction.do"
    frmLoanForeclosure.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmLoanForeclosure.userPositionRequested.value = 1*frmLoanForeclosure.positionRequested.value + 1;
    frmLoanForeclosure.action="../../../LoanForeclosureGetNextHeader.do";
    frmLoanForeclosure.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmLoanForeclosure.userPositionRequested.value = 1*frmLoanForeclosure.positionRequested.value - 1;
    frmLoanForeclosure.action = "../../../LoanForeclosureGetNextHeader.do";
    frmLoanForeclosure.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmLoanForeclosure.userPositionRequested.value = 1*frmLoanForeclosure.newPositionRequested.value;
    frmLoanForeclosure.action = "../../../LoanForeclosureGetNextHeader.do";
    frmLoanForeclosure.submit();
}

function GetDetails()
{
 // if(mandatory_Check("frmLoanForeclosure"))
  {
//  alert(document.all.txtT.value);
  document.all.hdnAction.value="getDtls";
  frmLoanForeclosure.action="../../../LoanForeclosureGetDetails.do";
 frmLoanForeclosure.submit();
   } 
   
}

function ForecloseInterest()
{
 // if(mandatory_Check("frmLoanForeclosure"))
  {
//  document.all.txtNewPrnAmt.enabled="true";
//alert(document.all.txtT.value);
  document.all.hdnAction.value="CalcInt";
  frmLoanForeclosure.action="../../../LoanForeclosureGetDetails.do";
 frmLoanForeclosure.submit();
   } 
}

function chkRcptAmt()
{
	var rcptAmt = eval(frmLoanForeclosure.txtReceiptAmt.value);
	var outPrn = eval(frmLoanForeclosure.txtOutPrn.value);
	var paidInt = eval(frmLoanForeclosure.txtOutInt.value)
	//alert("rcptAmt="+rcptAmt+",outPrn="+outPrn+"paidInt="+paidInt);
	if(rcptAmt != (outPrn+paidInt))
	{
		alert("Receipt Amount should be equal to Total of Outstanding Principal and Outstanding Interest during Foreclosure");
		frmLoanForeclosure.txtReceiptAmt.value="";
		frmLoanForeclosure.txtReceiptAmt.focus();
		return false;
	}
}


</script>

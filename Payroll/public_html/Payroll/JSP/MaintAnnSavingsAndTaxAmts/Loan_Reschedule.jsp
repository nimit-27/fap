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
  <html:form  action="LoanRescheduleAction" name="frmLoanReschedule" type="FCIPAY.Payroll.WEBTIER.Form.LoanRescheduleForm">
  <bean:define id="ParentForm" name="frmLoanReschedule" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>LOAN RESCHEDULE</TD>
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
                  <td ><html:text property="txtEmpStatus" name="frmLoanReschedule" readonly="true" styleClass="locked"  size="23"  />
            </td>    <tr>   
                   <td width="15%" class=labelText  > CPF Code </td>                            
                  <td ><html:text property="txtEmpCPF" name="frmLoanReschedule" readonly="true" styleClass="locked" size="23"   />
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
                          <html:text property="txtLoan"  styleClass="required" style="width:70%" readonly="true" alt="<%=String.valueOf(i)%>"  onchange="GetDetails()" />
                           <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center"  property="buttxtEmpNo"  onclick="ShowLoanAdvance(this.alt);" >   <!-- </td>
                          <td> 
                        <td align="left" class=labelText >        Description</td>   -->
                                   <td align="left" colspan ="2"> 
                          <html:text property="txtLoanDesc"  styleClass="locked" size="42"  maxlength="120" readonly="true" alt="<%=String.valueOf(i)%>"   /> </td>
          <tr>     <td class=labelText  >Loan Amount </td>
                  <td>                             
                  <html:text  property="txtLoanAmt"  maxlength="50" size="23" readonly="true" styleClass="locked"  />                 
                  </td>   
                  <td> <td>  
                  <td class=labelText  >Reschedule Date </td>    
                  <td>
                  <html:text  property="txtSysdate" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
              <tr> 
                           <td class=labelText  >           Outstanding Principal </td>
                  <td>                             
                  <html:text  property="txtOutPrn"   size="23" readonly="true" styleClass="locked" />                 
                  </td>                                        
             
                   <td> <td> 
                   <td class=labelText  >Outstanding Interest </td>
                  <td>                             
                  <html:text  property="txtOutInt"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                 
                 <tr> 
       <!--          
        <td>
       <html:button property="butGetDetails" value="GetDetails" onclick="GetDetails()"  />
       </td>   -->
       
            
                 
             <td class=labelText  >Total Principal Installs </td>
                  <td>                             
                  <html:text  property="txtAlreadyPrn"  maxlength="50" size="23" readonly="true" styleClass="locked"  />                 
                  </td>    
              
               <td><td>     <td class=labelText  >Total Interest Installs </td>
                  <td>                             
                  <html:text  property="txtAlreadyInt"  maxlength="50" size="23" readonly="true" styleClass="locked"  />                 
                  </td>    
                     <tr>  
                   
                    <td class=labelText  >Balance Principal Installments </td>
                  <td>                             
                  <html:text  property="txtPaidPrn"  maxlength="50" size="23" readonly="true" styleClass="locked"  />                 
                  </td>
                <td>  <td>  
                   <td class=labelText  > Balance Interest Installments</td>
                   
                  <td>                             
                  <html:text  property="txtPaidInt"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                   
               <!--    <td class=labelText  >Principal Installments Paid</td>
                  <td>                             
                  <html:text  property="txtPaidPrnInstal"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  <td class=labelText  >Interest Installments Paid</td>
                  <td>                             
                  <html:text  property="txtPaidIntInstal"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                -->
                   <tr> 
                  
                  <td class=labelText  >Monthly Principal Amount</td>
                  <td>                             
                  <html:text  property="txtPaidPrnAmt"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                   <td> <td>  
                  <td class=labelText  >Monthly Interest Amount </td>
                  <td>                             
                  <html:text  property="txtPaidIntAmt"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  <tr>  
                   
               
                  <td class=labelText  >New Principal Installments </td>
                  <td>                             
                  <html:text  property="txtNewPrnInstal" maxlength="50" size="23" styleClass="required" readonly="false"  onchange ="calculateInterest()"  onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"/>                 
                  </td>
                  <td>  <td>  
                  <td class=labelText  >New Interest Installments </td>
                  <td>                             
                  <html:text  property="txtNewIntInstal" maxlength="50" size="23" styleClass="required" readonly="false" onchange ="calculateInterest()" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"/>                 
                  </td>
                 <td> 
                 <tr> 
                  
                    
                   <td class=labelText  >New Monthly Principal Amount </td>    
                  <td>
                  <html:text  property="txtNewPrnAmt" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                   
                  </td> <td> <td> 
                    <td class=labelText  >New Monthly Interest Amount </td>    
                  <td>
                  <html:text  property="txtNewIntAmt" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
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
       <html:button property="butLpc" value="Reschedule" onclick="LoanReschedule()"  />
       </td>
       

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

<html:hidden property="headerPrimaryKey" name="frmLoanReschedule"  />

<html:hidden property="screenMode" name="frmLoanReschedule"  />
<html:hidden name="frmLoanReschedule"  property="screenName" value="MaintLoanReschedule" />
<html:hidden name="frmLoanReschedule"  property="forwardedPage" />

<html:hidden property="txtTransID"  name="frmLoanReschedule"  />
<html:hidden property="txtLoanFlag"  name="frmLoanReschedule"  />
<html:hidden property="lovKey" name="frmLoanReschedule"  />
<html:hidden property="txtFields" name="frmLoanReschedule"  />
<html:hidden property="txtSearchFields" name="frmLoanReschedule"  />
<html:hidden property="txtDisplayFields" name="frmLoanReschedule"  />
<html:hidden property="txtIndex" name="frmLoanReschedule"  />
<html:hidden property="txtInputField" name="frmLoanReschedule"  />
<html:hidden property="buttonFlag" name="frmLoanReschedule"  />
<html:hidden property="userPageRequested" name="frmLoanReschedule" />
<html:hidden property="pageRequested" name="frmLoanReschedule" />
<html:hidden property="loginLocCode" name="frmLoanReschedule" />
<html:hidden property="positionRequested" name="frmLoanReschedule" />
<html:hidden property="userPositionRequested" name="frmLoanReschedule" />
<html:hidden  property="hdnAction" name="frmLoanReschedule" />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">
//int chk_flag=0;
function lfnLoad()
{   
//alert(+document.all.txtLoanFlag.value);
   var mode = document.all.screenMode.value;
  //   alert(mode);
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='N')
    {        
          
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
   // document.all.butGetDetails.disabled = "true";
    }
    if(mode== 'U')
    {
    document.all.butLpc.disabled = "true";
//    document.all.butGetDetails.disabled = "true";
    }
   NewFunction();
    hedMenuHandling(mode);
    disableInsert();
}

function disableInsert(){
    //Disabling INsert Mode  and Delete Mode 
    /*document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butDel.disabled="true";
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
    */
}
function doQueryMode()
{
    var mode = document.all.screenMode.value;
   //  alert(mode);
    document.all.buttonFlag.value='';    
    frmLoanReschedule.action="../../../LoanRescheduleQueryMode.do"
    frmLoanReschedule.submit();
}

function doRefresh()
{
    frmLoanReschedule.action="../../../LoanRescheduleRefresh.do"
    frmLoanReschedule.submit();
}

function ShowEmpNo()
{
   mode = document.all.screenMode.value;
  if(mode == 'N')
  {
  frmLoanReschedule.lovKey.value = "LoanRescheduleEmpLOV" + frmLoanReschedule.screenName.value + frmLoanReschedule.screenMode.value;
  frmLoanReschedule.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtEmpCategory,txtEmpType,txtEmpStatus,txtEmpCPF";
 // frmLoanForeclosure.txtIndex.value =i;   
 frmLoanReschedule.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.LoanForeclosure.CPFCode,Payroll.LoanForeclosure.EmpName";

  frmLoanReschedule.txtInputField.value ="";     
  frmLoanReschedule.queryParam.value="txtSiteID="+ frmLoanReschedule.loginLocCode.value +" " ;
  showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLoanReschedule');
  return true;
  }
  else
  if(mode== 'Q')
  {
  frmLoanReschedule.lovKey.value = "LoanRescheduleEmpLOV" + frmLoanReschedule.screenName.value + frmLoanReschedule.screenMode.value;
  //alert(frmLoanForeclosure.lovKey.value);
  frmLoanReschedule.txtDisplayFields.value = "txtEmpNo";
 // frmLoanForeclosure.txtIndex.value =i;      
 frmLoanReschedule.txtInputField.value ="";         
 frmLoanReschedule.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.LoanForeclosure.CPFCode,Payroll.LoanForeclosure.EmpName";
 frmLoanReschedule.queryParam.value="txtSiteID="+ frmLoanReschedule.loginLocCode.value +" " ;
  showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLoanReschedule');
  return true;
  }
  
}

function ShowLoanAdvance()
{
  mode = document.all.screenMode.value;
  if(mode == 'N')
  {
  frmLoanReschedule.lovKey.value = "LoanRescheduleLOV" + frmLoanReschedule.screenName.value + frmLoanReschedule.screenMode.value;
  frmLoanReschedule.txtDisplayFields.value = "txtLoan,txtLoanDesc,txtOutPrn,txtOutInt,txtTransID,txtLoanFlag";
  frmLoanReschedule.txtSearchFields.value ="";
 // frmLoanForeclosure.txtIndex.value =i;      
  frmLoanReschedule.txtInputField.value ="txtLoan";   
  if(document.all.txtEmpNo.value=="" )
  {
   alert("Please Select the Employee first");
   return;
  }
   else
   {
   //alert("value" +document.all.txtEmpNo.value);
   frmLoanReschedule.queryParam.value ="txtEmpNo="+document.all.txtEmpNo.value;
   }
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmLoanReschedule');
    return true;
    }
    
    else
    {
    document.all.txtLoan.disabled ="true";
    document.all.buttxtEmpNo.disabled= "true";
    }
}

function LoanReschedule()
{   
 document.all.txtNewPrnAmt.enabled="true";
 document.all.txtNewIntAmt.enabled="true";
 if( 0> document.all.txtNewPrnAmt   || document.all.txtNewPrnAmt =="")
  {
    alert("wrong");
  }
    if(mandatory_Check("frmLoanReschedule"))
    {
  //  frmLoanForeclosure.detailDataChanged.value="true";
    frmLoanReschedule.headerDataChanged.value="true";
    document.all.txtNewPrnAmt.enabled="true";
    document.all.txtNewIntAmt.enabled="true";
    document.all.txtNewIntInstal.enabled = "true"
    if(document.all.txtNewPrnAmt <0   || document.all.txtNewPrnAmt =="")
  {
    alert("wrong");
  }
    document.all.txtNewIntInstal.disabled="";
    frmLoanReschedule.action="../../../LoanRescheduleSave.do"
    document.all.butLpc.disabled = "true";
    frmLoanReschedule.submit();
    }
    
    
}

function GetDetails()
{
 //  if(mandatory_Check("frmLoanReschedule"))
   {
  document.all.hdnAction.value="getDtls";
  frmLoanReschedule.action="../../../LoanRescheduleGetDetails.do";
 frmLoanReschedule.submit();
 }
   
}

function NewFunction()
{ 
mode = document.all.screenMode.value;
//alert(mode);
  if(mode == 'N')
  {
document.all.butSave.disabled="true";
if(document.all.txtLoanFlag.value =='Advance')
{
  document.all.txtNewIntInstal.disabled="true";
}
/* if(document.all.txtLoan.value==87)
{
duration = document.all.txtAlreadyPrn.value + document.all.txtNewPrnInstal.value - document.all.txtPaidPrn.value;
// document.all.txtNewIntInstal.disabled = "true";
if(duration <=12)
{
  document.all.txtNewIntInstal.value =1;
}
if(duration >12 && duration <=24)
{
document.all.txtNewIntInstal.value =2;
}
if(duration >24 && duration <=36)
{
  document.all.txtNewIntInstal.value =3;
}
} */
 if(document.all.txtPaidPrn.value ==0 && document.all.txtPaidInt.value >0)
  {
   document.all.txtNewPrnInstal.disabled = "true";
   if(document.all.txtNewIntInstal.value <0 ||  document.all.txtNewIntInstal.value >99)
   {
    alert("Please enter correct value");
    }
  }
 
  if(document.all.txtLoan.value==88 || document.all.txtLoan.value==89 || document.all.txtLoan.value==90 || document.all.txtLoan.value==91 || document.all.txtLoan.value==92)
  {
    // alert();
    document.all.txtNewIntInstal.disabled = "true";
    document.all.txtNewIntInstal.value = document.all.txtNewPrnInstal.value;
  //  document.all.txtNewIntInstal.enabled = "true"; 
    return;
  }
 
 
}

if(mode == 'U')
{
  document.all.butSave.disabled="true";
}
}

function doInsertMode()
{
    frmLoanReschedule.action="../../../LoanRescheduleNewmode.do"
    frmLoanReschedule.submit();
}


function getHeaderRecord()
{
    document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmLoanReschedule.action="../../../LoanRescheduleGetHeaderAction.do"
    frmLoanReschedule.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmLoanReschedule.userPositionRequested.value = 1*frmLoanReschedule.positionRequested.value + 1;
    frmLoanReschedule.action="../../../LoanRescheduleGetNextHeader.do";
    frmLoanReschedule.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmLoanReschedule.userPositionRequested.value = 1*frmLoanReschedule.positionRequested.value - 1;
    frmLoanReschedule.action = "../../../LoanRescheduleGetNextHeader.do";
    frmLoanReschedule.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmLoanReschedule.userPositionRequested.value = 1*frmLoanReschedule.newPositionRequested.value;
    frmLoanReschedule.action = "../../../LoanRescheduleGetNextHeader.do";
    frmLoanReschedule.submit();
}

function calculateInterest()
{ 
 /* if(document.all.txtNewPrnInstal !="")
  {
    if((document.all.txtAlreadyPrn - document.all.txtPaidPrn) > document.all.txtNewPrnInstal)
    {
      alert("It can't be lesser than Already Paid Installs"); 
      return false;
    }
  } 
  else if(document.all.txtNewIntInstal !="")
  {
    if((document.all.txtAlreadyInt - document.all.txtPaidInt) > document.all.txtNewIntinstal)
    {
      alert("It can't be lesser than Already Paid Installs"); 
      return false;
    }
  } */
  
  if(document.all.txtLoan.value==87)
{
 // alert("INSIDE 87");

// alert("Total" +document.all.txtAlreadyPrn.value);
// alert("Balance" +document.all.txtPaidPrn.value);
// alert("New" +document.all.txtNewPrnInstal.value);
// duration = parseInt(document.all.txt AlreadyPrn.value,10)+ parseInt(document.all.txtNewPrnInstal.value,10) - parseInt(document.all.txtPaidPrn.value,10);
duration = parseInt(document.all.txtAlreadyPrn.value) + parseInt(document.all.txtNewPrnInstal.value) - parseInt(document.all.txtPaidPrn.value);
// alert("Duration" +duration);
// document.all.txtNewIntInstal.disabled = "true";
if(duration <=12)
{
  document.all.txtNewIntInstal.value =1;
}
if(duration >12 && duration <=24)
{
document.all.txtNewIntInstal.value =2;
}
if(duration >24 && duration <=36)
{
  document.all.txtNewIntInstal.value =3;
}
}
      
  document.all.hdnAction.value="CalcInt";
  
  frmLoanReschedule.action="../../../LoanRescheduleGetDetails.do";
  if( 0> document.all.txtNewPrnAmt   || document.all.txtNewPrnAmt =="")
  {
    alert("wrong");
  }
  frmLoanReschedule.submit();
  
}

</script>
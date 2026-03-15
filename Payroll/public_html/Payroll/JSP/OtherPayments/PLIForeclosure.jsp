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
  <BODY scroll=yes  onload="lfnLoad(); history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" ></BODY>
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="PLIForeclosureAction" name="frmPLIForeclosure" type="FCIPAY.Payroll.WEBTIER.Form.PLIForeclosureForm">
  <bean:define id="ParentForm" name="frmPLIForeclosure" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>PLI FORECLOSURE</TD>
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
                  <td ><html:text property="txtEmpStatus" name="frmPLIForeclosure" readonly="true" styleClass="locked" size="23"   />
            </td>  </tr>    
            <tr>   
                   <td width="15%" class=labelText  > CPF Code </td>                            
                  <td ><html:text property="txtEmpCPF" name="frmPLIForeclosure" readonly="true" styleClass="locked"  size="23"  />
            </td>   
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
            <td bgcolor="#4682B4" nowrap class=actTabText> PLI Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                        <td  width="15%" class=labelText>Fin Year</TD>
                            <td  cellspacing ="4"> 
                     
                    <html:text property="txtFinyr"  style="width:70%" readonly="true" alt="<%=String.valueOf(i)%>" styleClass="locked"/>
                    </td>
                     <td width="15%" class=labelText>PLI Amount</td>
                     <td   cellspacing ="4">                         
                  <html:text  property="txtPLIAmt" style="width:70%"   readonly="true" styleClass="locked" />                 
                  </td>
                   
                      <tr>     <td class=labelText  >Outstanding Principal </td>
                         
                  <td>                             
                  <html:text  property="txtOutPrn"  maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td> 
                     <td>   <td class=labelText  align="right">Receipt Amount </td>
                  <td>                             
                  <html:text  property="txtReceiptAmt" maxlength="50" size="23" readonly="false" styleClass="required" onblur="return chkRcptAmt();" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;"/>                 
                  </td>
                 
             
                 
               <!--  <td>
       <html:button property="butLpc" value="GetDetails"  />
       </td>  -->
 
          <tr> 
                    
                  <td class=labelText  >Receipt No </td>
                  <td>                             
                  <html:text  property="txtReceiptNo" maxlength="50" size="23" readonly="false" styleClass="required" onkeypress="if((event.keyCode < 48 && event.keyCode !=46 || event.keyCode > 57))return false;" />                 
                  </td>
                 <td class=labelText  >Invoice Number </td>
                  <td>                             
                  <html:text  property="txtInvoiceNo" maxlength="50" size="23" readonly="true" styleClass="locked"/>                 
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

<html:hidden property="headerPrimaryKey" name="frmPLIForeclosure"  />

<html:hidden property="screenMode" name="frmPLIForeclosure"  />
<html:hidden name="frmPLIForeclosure"  property="screenName" value="MaintPLIForeclosure" />
<html:hidden name="frmPLIForeclosure"  property="forwardedPage" />

<html:hidden property="txtT"  name="frmPLIForeclosure"  />
<html:hidden property="txtTransID"  name="frmPLIForeclosure"  />
<html:hidden property="txtLoanFlag"  name="frmPLIForeclosure"  />  
<html:hidden property="lovKey" name="frmPLIForeclosure"  />
<html:hidden property="txtFields" name="frmPLIForeclosure"  />
<html:hidden property="txtSearchFields" name="frmPLIForeclosure"  />
<html:hidden property="txtDisplayFields" name="frmPLIForeclosure"  />
<html:hidden property="txtIndex" name="frmPLIForeclosure"  />
<html:hidden property="txtInputField" name="frmPLIForeclosure"  />
<html:hidden property="buttonFlag" name="frmPLIForeclosure"  />
<html:hidden property="userPageRequested" name="frmPLIForeclosure" />
<html:hidden property="pageRequested" name="frmPLIForeclosure" />
<html:hidden property="loginLocCode" name="frmPLIForeclosure" />
<html:hidden property="positionRequested" name="frmPLIForeclosure" />
<html:hidden property="userPositionRequested" name="frmPLIForeclosure" />
<html:hidden property="hdnAction" name="frmPLIForeclosure" />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">
//int chk_flag=0;
function lfnLoad()
{   
   var mode = document.all.screenMode.value;
    
    // alert(mode);
  
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
    }
    if(mode=='Q')
    {
    document.all.butLpc.disabled = "true";
 

    }
    if(mode== 'U')
    {
   //   if (document.all.txtOutPrn.value!=0) 
   //  {
    //   alert(Outstanding Principal Amount is 0);
    //  }
   
   if (document.all.txtInvoiceNo.value!="")   
        {
     document.all.txtReceiptAmt.disabled ="true";
     document.all.txtReceiptNo.disabled ="true";
        }
    }
    hedMenuHandling(mode);
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

    document.all.buttonFlag.value=''; 

    frmPLIForeclosure.action="../../../PLIForeclosureQueryMode.do"
      
    frmPLIForeclosure.submit();
}

function doRefresh()
{
    frmPLIForeclosure.action="../../../PLIForeclosureRefresh.do"
    frmPLIForeclosure.submit();
}

function ShowEmpNo()
{
    mode = document.all.screenMode.value;
    if(mode == 'N')
    {    
      frmPLIForeclosure.lovKey.value = "PLIForeclosueEmpLOV" + frmPLIForeclosure.screenName.value + frmPLIForeclosure.screenMode.value;
      frmPLIForeclosure.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtEmpCategory,txtEmpType,txtEmpStatus,txtEmpCPF";      
      frmPLIForeclosure.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.LoanForeclosure.CPFCode,Payroll.LoanForeclosure.EmpName";      
      frmPLIForeclosure.txtInputField.value ="";     
      frmPLIForeclosure.queryParam.value= "txtSiteID="+frmPLIForeclosure.loginLocCode.value+",hdnEmpLbrFlag="+frmPLIForeclosure.hdnEmpLbrFlag.value;
      showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPLIForeclosure');
      return true;
    }
    else if(mode== 'Q')
    {
      frmPLIForeclosure.lovKey.value = "PLIForeclosueEmpLOV" + frmPLIForeclosure.screenName.value + frmPLIForeclosure.screenMode.value;      
      frmPLIForeclosure.txtDisplayFields.value = "txtEmpNo";     
      frmPLIForeclosure.txtInputField.value ="";     
      frmPLIForeclosure.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.LoanForeclosure.CPFCode,Payroll.LoanForeclosure.EmpName";
      frmPLIForeclosure.queryParam.value= "txtSiteID="+frmPLIForeclosure.loginLocCode.value+",hdnEmpLbrFlag="+frmPLIForeclosure.hdnEmpLbrFlag.value;
      showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPLIForeclosure');
      return true;
  } 
}

function ShowPLIAdvance()
{
mode = document.all.screenMode.value;
  if(mode == 'N')
  {
  frmPLIForeclosure.lovKey.value = "PLILOV" + frmPLIForeclosure.screenName.value + frmPLIForeclosure.screenMode.value;
  frmPLIForeclosure.txtDisplayFields.value = "txtPLI,txtPLIDesc,txtOutPrn,txtTransID";
  frmPLIForeclosure.txtSearchFields.value ="";
 // frmPLIForeclosure.txtIndex.value =i;      
  frmPLIForeclosure.txtInputField.value ="txtLoan";   
  if(document.all.txtEmpNo.value=="" )
  {
   alert("Please Select the Employee first");
   return;
  }
   else
   {
   //alert("value" +document.all.txtEmpNo.value);
   frmPLIForeclosure.queryParam.value ="txtEmpNo="+document.all.txtEmpNo.value;
   }
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','frmPLIForeclosure');
    return true;
 }
 else
 {
 document.all.txtLoan.disabled ="true";
 document.all.buttxtEmpNo.disabled = "true";
 }
 
}

function SaveRecord()
{   

    if(mandatory_Check("frmPLIForeclosure"))
    {
  //  frmPLIForeclosure.detailDataChanged.value="true";
 
    frmPLIForeclosure.headerDataChanged.value="true";
    //document.all.butLpc.disabled = "true";
    frmPLIForeclosure.action="../../../PLIForeclosureSave.do"
   frmPLIForeclosure.submit();
    }
    
    
}

function doInsertMode()
{
    frmPLIForeclosure.action="../../../PLIForeclosureNewmode.do"
    frmPLIForeclosure.submit();
}


function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    frmPLIForeclosure.action="../../../PLIForeclosureGetHeaderAction.do"
    frmPLIForeclosure.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmPLIForeclosure.userPositionRequested.value = 1*frmPLIForeclosure.positionRequested.value + 1;
    frmPLIForeclosure.action="../../../PLIForeclosureGetNextHeader.do";
    frmPLIForeclosure.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmPLIForeclosure.userPositionRequested.value = 1*frmPLIForeclosure.positionRequested.value - 1;
    frmPLIForeclosure.action = "../../../PLIForeclosureGetNextHeader.do";
    frmPLIForeclosure.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmPLIForeclosure.userPositionRequested.value = 1*frmPLIForeclosure.newPositionRequested.value;
    frmPLIForeclosure.action = "../../../LoanForeclosureGetNextHeader.do";
    frmPLIForeclosure.submit();
}

function GetDetails()
{
 // if(mandatory_Check("frmPLIForeclosure"))
  {
//  alert(document.all.txtT.value);
  document.all.hdnAction.value="getDtls";
  frmPLIForeclosure.action="../../../LoanForeclosureGetDetails.do";
 frmPLIForeclosure.submit();
   } 
   
}
function chkRcptAmt()
{
	var rcptAmt = eval(frmPLIForeclosure.txtReceiptAmt.value);
	var outPrn = eval(frmPLIForeclosure.txtOutPrn.value);
	if(rcptAmt != (outPrn))
	{
		alert("Receipt Amount should be equal to Total of Outstanding Principal during PLI Foreclosure");
		frmPLIForeclosure.txtReceiptAmt.value="";
		frmPLIForeclosure.txtReceiptAmt.focus();
		return false;
	}
}


</script>

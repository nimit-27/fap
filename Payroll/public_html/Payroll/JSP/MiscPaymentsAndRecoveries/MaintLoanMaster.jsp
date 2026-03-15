<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>     

</head>

<BODY scroll=no  onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintainLoanMaster" name="frmMaintLoanMaster" type="FCIPAY.Payroll.WEBTIER.Form.MaintLoanMasterForm">
<bean:define id="ParentForm" name="frmMaintLoanMaster" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>

<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
<TR height=30>
  <TD  colSpan=11 class=mainHeader height=10>MAINTAIN LOAN MASTER</TD>
</TR>
<tr height="10"><td class=userText colspan="11"></td></tr>
</TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:440px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	

       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--General Information Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Header for Maintain Loan Master</TD>
        </TR>
       <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR> 
         <tr height="15" >
            <td colspan="8"></td>
            </tr>
        <TR>

                      <TD class=labelText width="25%" ><bean:message key="pay.MaintainLoanMaster.txtEmpNo" /></td>
                     <td align="left"><html:text  property="headerPrimaryKey" altKey="pay.MaintainLoanMaster.txtEmpNo" maxlength="10" size="18" styleClass="required"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" onclick="return ShowEmpNum();" >&nbsp;&nbsp;<html:text  property="txtEmpName" altKey="pay.MaintainLoanMaster.txtEmpName" maxlength="10" size="26" styleClass="locked" readonly="" /></td>
                     <TD class=labelText width="25%" ><bean:message key="pay.MaintainLoanMaster.txtLoanType" /></td>
                     <td align="left"><html:text  property="txtLoanType" altKey="pay.MaintainLoanMaster.txtLoanType" maxlength="10" size="18" styleClass="required"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtLoanType"  onclick="return ShowLoanType();" >&nbsp;&nbsp;<html:text  property="txtLoan" altKey="pay.MaintainLoanMaster.txtEmpName" maxlength="10" size="26" styleClass="locked" readonly="" /></td>
                     
          </tr> 
          
            <tr height="15" >
            <td colspan="6"></td>
            </tr>
                                 
         </table>
         
    
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="150">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
            <TABLE cellSpacing=0 cellPadding=0 >
 
              
		      <TR>
              <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              <td bgcolor="#4682B4" nowrap class=actTabText>Detail of Maintain Loan Master<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0>
                          <TBODY>
                                
                          <TR>                            
                              <td  width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtSanctionDate" /></td>
                              <td > <html:text  property="txtSanctionDate" styleClass="optional"  size="23" /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtSanctionDate" alt="<%=(i-1) %>"  onclick="showCalendar('txtSanctionDate',this)" /></td>

                              <td  width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtLoanAmount" /></td>                                                                                                                     
                              <td ><html:text  property="txtLoanAmount" styleClass = "required" altKey="pay.MaintainLoanMaster.txtLoanAmount" maxlength="10" size="23" onchange="lfnChange(this.value);"  readonly=""  style="text-align:right" /></td>                              
                          </tr> 


                         <TR>                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtInstAmt" /></td>
                              <td ><html:text  property="txtInstAmt" styleClass = "required" altKey="pay.MaintainLoanMaster.txtInstAmt" maxlength="10" size="23" onchange="lfnChange(this.value);" readonly="" style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtRecoverYYMM" /></td>
                              <td ><html:text  property="txtRecoverYYMM" altKey="pay.MaintainLoanMaster.txtRecoverYYMM" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" readonly="" style="text-align:right" /></td>
                          </tr> 
                      
	                       <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtBalNoofInstall" /></td>
                              <td ><html:text  property="txtBalNoofInstall" styleClass = "required" altKey="pay.MaintainLoanMaster.txtBalNoofInstall" maxlength="10" size="23" onchange="lfnChange(this.value);"  readonly="" style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtPaidInstall" /></td>
                              <td ><html:text  property="txtPaidInstall" styleClass = "required" altKey="pay.MaintainLoanMaster.txtPaidInstall" maxlength="10" size="23" onchange="lfnChange(this.value);" readonly=""  style="text-align:right" /></td>
                              
                          </tr> 

	                       <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtAmtPaid" /></td>
                              <td ><html:text  property="txtAmtPaid" styleClass = "required" altKey="pay.MaintainLoanMaster.txtAmtPaid" maxlength="10" size="23" onchange="lfnChange(this.value);"  readonly="" style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtExistLoanBal" /></td>
                              <td ><html:text  property="txtExistLoanBal" altKey="pay.MaintainLoanMaster.txtExistLoanBal" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  style="text-align:right" /></td>                              
                              
                          </tr> 
                          
                            <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtIntAmount" /></td>
                              <td ><html:text  property="txtIntAmount" altKey="pay.MaintainLoanMaster.txtIntAmount" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" readonly=""  style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtIntAmountFinYear" /></td> 
                              <td ><html:text  property="txtIntAmountFinYear" altKey="pay.MaintainLoanMaster.txtIntAmountFinYear" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  readonly="" style="text-align:right" /></td>
                              
                          </tr> 
                       
                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtBalIntAmount" /></td>
                              <td ><html:text  property="txtBalIntAmount" altKey="pay.MaintainLoanMaster.txtBalIntAmount" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtLoanOpBal" /></td>
                              <td ><html:text  property="txtLoanOpBal" altKey="pay.MaintainLoanMaster.txtLoanOpBal" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" style="text-align:right" /></td>
                              
                          </tr> 

                          <TR>       
                              <td width="15%" class=labelText><bean:message key="pay.MaintainLoanMaster.txtLoanStatus" /></td>
                              <td colspan="1" ><html:select property="txtLoanStatus" alt="txtLoanStatus" styleClass="required" style="width:55%" >
                              <html:option value="" ><bean:message   key="pay.MaintainLoanMaster.pleaseSelect" /></html:option>      
                               <html:option value="A" > <bean:message key="pay.MaintainLoanMaster.active" /></html:option>
                               <html:option value="E" > <bean:message key="pay.MaintainLoanMaster.ended" /></html:option>
                               </html:select>
                               </td>   
                      
                          </TR>
                           
                        
                          <tr height = 20><td></td></tr>
                          
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
  <!-- Bottom Blue Bar -->
        <TR>
             <td>
                  <jsp:include  page = "../INCLUDES/BottomBlueBar.jsp" flush="true" />
             </td>
	     </TR>             
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
</TBODY>
</TABLE>

</div>


<!-- Container Table Ends -->
<html:hidden name="frmMaintLoanMaster"  property="screenName" value="MaintainLoanMasterScreen" />
<html:hidden name="frmMaintLoanMaster"  property="forwardedPage" />
<html:hidden property="txtEmpNo" name="frmMaintLoanMaster" />
<html:hidden property="screenMode" name="frmMaintLoanMaster" />
<html:hidden property="positionRequested" name="frmMaintLoanMaster" />
<html:hidden property="userPositionRequested" name="frmMaintLoanMaster" />


<html:hidden property="lovKey" name="frmMaintLoanMaster"  />
<html:hidden property="txtFields" name="frmMaintLoanMaster"  />   
<html:hidden property="txtSearchFields" name="frmMaintLoanMaster"  />
<html:hidden property="txtDisplayFields" name="frmMaintLoanMaster"  />
<html:hidden property="txtIndex" name="frmMaintLoanMaster"  />
<html:hidden property="buttonFlag" name="frmMaintLoanMaster"  />

</html:form>
</body>
</html:html>

                        
         


<script language="javascript">

function lfnLoad()
{
  mode = document.all.screenMode.value;
  if(mode == '')
  {
      doQueryMode();
  }
  if(mode=='U')
  {

      document.all.headerPrimaryKey.disabled="true";
      document.all.butEmpNo.disabled="true";           
  }

  hedMenuHandling(mode);

}


 function lfnChange(val)
{
  if(num_Check(val,1))
  {
    frmMaintLoanMaster.headerDataChanged.value = "true";
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}

function getHeaderRecord()
{
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmMaintLoanMaster.action="../../../MaintLoanMasterGetHeaderAction.do"
	frmMaintLoanMaster.submit();
}


function doGetNextHeader()
{ 
    frmMaintLoanMaster.userPositionRequested.value = 1*frmMaintLoanMaster.positionRequested.value + 1;
    frmMaintLoanMaster.action="../../../MaintLoanMasterGetNextHeader.do";
    frmMaintLoanMaster.submit();
}


function PrevHeader()
{
  frmMaintLoanMaster.userPositionRequested.value = 1*frmMaintLoanMaster.positionRequested.value - 1;
  frmMaintLoanMaster.action = "../../../MaintLoanMasterGetPrevHeader.do";
  frmMaintLoanMaster.submit();
}


function JumpHeader()
{
  frmMaintLoanMaster.userPositionRequested.value = 1*frmMaintLoanMaster.newPositionRequested.value;
  frmMaintLoanMaster.action = "../../../MaintLoanMasterGetNextHeader.do";
  frmMaintLoanMaster.submit();
}


function doRefresh()
{
  frmMaintLoanMaster.action="../../../MaintLoanMasterRefresh.do"
  frmMaintLoanMaster.submit();
}


function SaveRecord()
{
  if(mandatory_Check("frmMaintLoanMaster"))
  {
    frmMaintLoanMaster.txtEmpNo.value = "##";
    frmMaintLoanMaster.detailDataChanged.value = "false";  
    if(frmMaintLoanMaster.screenMode.value == "N")
    frmMaintLoanMaster.headerDataChanged.value = "true";  
  
    frmMaintLoanMaster.headerPrimaryKey.disabled = "";
    frmMaintLoanMaster.headerFields.value = "true";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmMaintLoanMaster.action = "../../../MaintLoanMasterSaveAction.do";
    frmMaintLoanMaster.submit();
  }
  else
  {
    return false;
  }
}


function doInsertMode()
{
  frmMaintLoanMaster.action="../../../MaintLoanMasterNewMode.do"
  frmMaintLoanMaster.submit();
}

function doQueryMode()
{
  frmMaintLoanMaster.action="../../../MaintLoanMasterQueryMode.do"
  frmMaintLoanMaster.submit();
}


function ShowEmpNum()
{
   frmMaintLoanMaster.lovKey.value = "LoanMasterEmp" + frmMaintLoanMaster.screenName.value + frmMaintLoanMaster.screenMode.value;
   frmMaintLoanMaster.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
   frmMaintLoanMaster.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";   
   frmMaintLoanMaster.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintLoanMaster');
   return true;
}

function ShowLoanType()
{
    frmMaintLoanMaster.lovKey.value = "LoanMasterPayCode" + frmMaintLoanMaster.screenName.value + frmMaintLoanMaster.screenMode.value;
   frmMaintLoanMaster.txtDisplayFields.value = "txtLoanType,txtLoan";
   frmMaintLoanMaster.txtSearchFields.value = "pay.MaintainLoanMaster.txtLoanType,Payroll.Common.empName";   
   frmMaintLoanMaster.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintLoanMaster');
   return true;
}

function showCalendar(inputId, butId) {  
   if(butId.alt)
   {
    iIndex=butId.alt;
   }
   else
   {
    iIndex="-1";
   }
   Calendar.setup({inputField	: inputId,
		   ifFormat	: "%d-%b-%Y",
		   button	: butId,
       position: iIndex
  		  });
        
   return false;
}
</script>         

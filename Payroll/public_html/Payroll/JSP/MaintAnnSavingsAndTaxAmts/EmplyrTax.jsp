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

<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintEmplyrTax" name="frmEmplyrTax" type="FCIPAY.Payroll.WEBTIER.Form.EmplyrTaxForm">
<bean:define id="ParentForm" name="frmEmplyrTax" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>

<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />


<table>
<TR height=30>
  <TD  colSpan=11 class=mainHeader height=10>TAX SUBMITTED BY EMPLOYER</TD>
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
          <TD class=subHeader colspan=6>Tax Submitted by Employer</TD>
        </TR>
       <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR> 
         <tr height="15" >
            <td colspan="6"></td>
            </tr>
        <TR>

                     <TD class=labelText width="40%" >Financial Year(YYYYYY)</td>
                     <td>
                     <logic:equal property="screenMode" name="frmEmplyrTax" value="U">
                     <html:text  property="txtFinYr" altKey="pay.MaintainAnnualIncome.txtFinYYMM" maxlength="10" size="23" styleClass="locked" readonly="true" onchange="" />           
                     </logic:equal>
                     <logic:notEqual property="screenMode" name="frmEmplyrTax" value="U">
                     <html:text  property="txtFinYr" altKey="pay.MaintainAnnualIncome.txtFinYYMM" maxlength="10" size="23" styleClass="required"  onchange="" />           
                     </logic:notEqual>
                     </td>
        </tr>
        <tr>
                     <TD class=labelText width="40%" >Employee No</td>
                     <td align="left">
                     <logic:equal property="screenMode" name="frmEmplyrTax" value="U">
                     <html:text  property="txtEmpNo" altKey="pay.MaintainAnnualIncome.txtEmpNo" maxlength="10" size="18" styleClass="locked" readonly="true" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" >&nbsp;&nbsp;<html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="26" styleClass="locked" readonly="true" />
                     </logic:equal>
                     <logic:notEqual property="screenMode" name="frmEmplyrTax" value="U">
                     <html:text  property="txtEmpNo" altKey="pay.MaintainAnnualIncome.txtEmpNo" maxlength="10" size="18" styleClass="required" readonly="true"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="return ShowEmpNum();" >&nbsp;&nbsp;<html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="26" styleClass="locked" readonly="true" />
                     </logic:notEqual>
                     </td>
          </tr>
          <tr>
                     <TD class=labelText width="40%" >Tax Submitted by Employer</td>
                     <td align="left">
                     <logic:equal property="screenMode" name="frmEmplyrTax" value="N">
                     <html:text  property="txtTaxAmt" altKey="pay.MaintainAnnualIncome.txtEmpNo" maxlength="10" size="18" styleClass="required"  />
                     </logic:equal>
                     <logic:notEqual property="screenMode" name="frmEmplyrTax" value="N">
                     <html:text  property="txtTaxAmt" altKey="pay.MaintainAnnualIncome.txtEmpNo" maxlength="10" size="18" styleClass="locked" readonly="true" />
                     </logic:notEqual>
                     </td>
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
              <td bgcolor="#4682B4" nowrap class=actTabText>Recovery Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <td  width="40%" class=labelText>Recovery Start YYYYMM</td>
                              <td > 
                              <logic:equal property="screenMode" name="frmEmplyrTax" value="N">
                              <html:text  property="txtRecYYMM" styleClass="required" altKey="pay.MaintainAnnualIncome.txtGrossIncome" maxlength="10" size="23" onchange="lfnChange(this.value);" readonly=""  style="text-align:right" />
                              </logic:equal>
                              <logic:notEqual property="screenMode" name="frmEmplyrTax" value="N">
                              <html:text  property="txtRecYYMM" styleClass="locked" altKey="pay.MaintainAnnualIncome.txtGrossIncome" maxlength="10" size="23" onchange="lfnChange(this.value);" readonly="true"  style="text-align:right" />
                              </logic:notEqual>
                     </td>
                          </TR>
                          <TR>
                              <td  width="40%" class=labelText>Installment Amount</td>
                              <td >
                              <logic:equal property="screenMode" name="frmEmplyrTax" value="N">
                              <html:text  property="txtInstallAmt" styleClass = "required" altKey="pay.MaintainAnnualIncome.txtTaxableIncome" maxlength="10" size="23" onchange="lfnChange(this.value);"  readonly=""  style="text-align:right" /></td>                              
                              </logic:equal>
                              <logic:notEqual property="screenMode" name="frmEmplyrTax" value="N">
                              <html:text  property="txtInstallAmt" styleClass = "locked" altKey="pay.MaintainAnnualIncome.txtTaxableIncome" maxlength="10" size="23" onchange="lfnChange(this.value);"  readonly="true"  style="text-align:right" /></td>                              
                              </logic:notEqual>
                          </tr> 
                      
	                       <TR>
                            
                              <td width="40%" class=labelText>No of Installment</td>
                              <td >
                              <logic:equal property="screenMode" name="frmEmplyrTax" value="N">
                              <html:text  property="txtNoInstall" styleClass = "required" altKey="pay.MaintainAnnualIncome.txtIncomeTaxPaid" maxlength="10" size="23" onchange="lfnChange(this.value);"  readonly="" style="text-align:right" /></td>
                              </logic:equal>
                              <logic:notEqual property="screenMode" name="frmEmplyrTax" value="N">
                              <html:text  property="txtNoInstall" styleClass = "locked" altKey="pay.MaintainAnnualIncome.txtIncomeTaxPaid" maxlength="10" size="23" onchange="lfnChange(this.value);"  readonly="true" style="text-align:right" /></td>
                              </logic:notEqual>
                          </tr> 
                          
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
                <!-- Tab Table Ends -->

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
<html:hidden name="frmEmplyrTax"  property="screenName" value="EmplyrTaxScreen" />
<html:hidden name="frmEmplyrTax"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmplyrTax" />
<html:hidden property="positionRequested" name="frmEmplyrTax" />
<html:hidden property="userPositionRequested" name="frmEmplyrTax" />
<html:hidden property="loginLocCode" name="frmEmplyrTax" />


<html:hidden property="lovKey" name="frmEmplyrTax"  />
<html:hidden property="txtFields" name="frmEmplyrTax"  />   
<html:hidden property="txtSearchFields" name="frmEmplyrTax"  />
<html:hidden property="txtDisplayFields" name="frmEmplyrTax"  />
<html:hidden property="txtIndex" name="frmEmplyrTax"  />
<html:hidden property="buttonFlag" name="frmEmplyrTax"  />

<input type="hidden" name="queryParam" />
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

      document.all.butEmpNo.disabled="true";           
  }

  hedMenuHandling(mode);

}


 function lfnChange(val)
{
  if(num_Check(val,1))
  {
    frmEmplyrTax.headerDataChanged.value = "true";
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
    frmEmplyrTax.action="../../../EmplyrTaxFirstGetHeaderAction.do"
    frmEmplyrTax.submit();
}


function doGetNextHeader()
{ 
    frmEmplyrTax.userPositionRequested.value = 1*frmEmplyrTax.positionRequested.value + 1;
    frmEmplyrTax.action="../../../EmplyrTaxGetNextHeader.do";
    frmEmplyrTax.submit();
}


function PrevHeader()
{
  frmEmplyrTax.userPositionRequested.value = 1*frmEmplyrTax.positionRequested.value - 1;
  frmEmplyrTax.action = "../../../EmplyrTaxGetNextHeader.do";
  frmEmplyrTax.submit();
}


function JumpHeader()
{
  frmEmplyrTax.userPositionRequested.value = 1*frmEmplyrTax.newPositionRequested.value;
  frmEmplyrTax.action = "../../../EmplyrTaxGetNextHeader.do";
  frmEmplyrTax.submit();
}


function doRefresh()
{
  frmEmplyrTax.action="../../../EmplyrTaxRefresh.do"
  frmEmplyrTax.submit();
}


function SaveRecord()
{
  if(mandatory_Check("frmEmplyrTax"))
  {
    frmEmplyrTax.detailDataChanged.value = "false";  
    if(frmEmplyrTax.screenMode.value == "N")
      frmEmplyrTax.headerDataChanged.value = "true";  
    frmEmplyrTax.headerFields.value = "true";
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmEmplyrTax.action = "../../../EmplyrTaxSaveAction.do";
    frmEmplyrTax.submit();
  }
  else
  {
    return false;
  }
}


function doInsertMode()
{
  frmEmplyrTax.action="../../../EmplyrTaxNewMode.do"
  frmEmplyrTax.submit();
}

function doQueryMode()
{
  frmEmplyrTax.action="../../../EmplyrTaxQueryMode.do"
  frmEmplyrTax.submit();
}


function ShowEmpNum()
{
   if(document.all.txtFinYr.value=='')
   {
      alert("Please Enter Financial Year First");
      return false;
   }
   frmEmplyrTax.lovKey.value = "EmplyrTax" + frmEmplyrTax.screenName.value + frmEmplyrTax.screenMode.value;
   frmEmplyrTax.txtDisplayFields.value = "txtEmpNo,txtEmpName";
   frmEmplyrTax.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";   
   frmEmplyrTax.txtIndex.value ="";
   frmEmplyrTax.queryParam.value="txtSiteID="+ frmEmplyrTax.loginLocCode.value +",hdnEmpLbrFlag="+frmEmplyrTax.hdnEmpLbrFlag.value+",txtFinYr="+frmEmplyrTax.txtFinYr.value ;      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmplyrTax');
   return true;
}
</script>         
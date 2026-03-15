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

<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintainAnnualIncome" name="frmMaintainAnnualIncome" type="FCIPAY.Payroll.WEBTIER.Form.MaintainAnnualIncomeForm">
<bean:define id="ParentForm" name="frmMaintainAnnualIncome" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>

<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />


<table>
<TR height=30>
  <TD  colSpan=11 class=mainHeader height=10>MAINTAIN ANNUAL INCOME, SAVINGS & TAX AMOUNTS</TD>
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
          <TD class=subHeader colspan=6> Detail Information Of Annual Income,Savings & Tax Amounts</TD>
        </TR>
       <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR> 
         <tr height="15" >
            <td colspan="6"></td>
            </tr>
        <TR>

                     <TD class=labelText width="20%" ><bean:message key="pay.MaintainAnnualIncome.FinYYMM" /></td>
                     <td><html:text  property="txtFinYYMM" altKey="pay.MaintainAnnualIncome.txtFinYYMM" maxlength="10" size="23" styleClass="required"  onchange="" />

                 <logic:equal property= "screenMode" name= "frmMaintainAnnualIncome" value="">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  onclick="ShowLovYYMM();">                 
                 </logic:equal>                                      

                 <logic:equal property= "screenMode" name= "frmMaintainAnnualIncome" value="Q">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  onclick="ShowLovYYMM();">                 
                 </logic:equal>                                      

                 <logic:equal property= "screenMode" name= "frmMaintainAnnualIncome" value="I">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>      
                 <logic:equal property= "screenMode" name= "frmMaintainAnnualIncome" value="N">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>      
                 <logic:equal property= "screenMode" name= "frmMaintainAnnualIncome" value="U1">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>
                  <logic:equal property= "screenMode" name= "frmMaintainAnnualIncome" value="U">
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  disabled onclick="ShowLovYYMM();">                                  
                 </logic:equal>                   
                                  
                     </td>
        
                
                     <TD class=labelText width="25%" ><bean:message key="pay.MaintainAnnualIncome.txtEmpNo" /></td>
                     <td align="left"><html:text  property="headerPrimaryKey" altKey="pay.MaintainAnnualIncome.txtEmpNo" maxlength="10" size="18" styleClass="required"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" name="butEmpNo" onclick="return ShowEmpNum();" >&nbsp;&nbsp;<html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="26" styleClass="locked" readonly="" /></td>
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
              <td bgcolor="#4682B4" nowrap class=actTabText>Year To Month Figures<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <td  width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtGrossIncome" /></td>
                              <td > <html:text  property="txtGrossIncome" styleClass="required" altKey="pay.MaintainAnnualIncome.txtGrossIncome" maxlength="10" size="23" onchange="lfnChange(this.value);" readonly=""  style="text-align:right" />
                              </td>
                              <td  width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtTaxableIncome" /></td>
                              <td ><html:text  property="txtTaxableIncome" styleClass = "required" altKey="pay.MaintainAnnualIncome.txtTaxableIncome" maxlength="10" size="23" onchange="lfnChange(this.value);"  readonly=""  style="text-align:right" /></td>                              
                          </tr> 


                         <TR>                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtHRA" /></td>
                              <td ><html:text  property="txtHRA" styleClass = "optional" altKey="pay.MaintainAnnualIncome.txtHRA" maxlength="10" size="23" onchange="lfnChange(this.value);" readonly="" style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtTaxableHrr" /></td>
                              <td ><html:text  property="txtTaxableHrr" altKey="pay.MaintainAnnualIncome.txtTaxableHrr" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" readonly="" style="text-align:right" /></td>
                          </tr> 
                      
	                       <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtIncomeTaxPaid" /></td>
                              <td ><html:text  property="txtIncomeTaxPaid" styleClass = "required" altKey="pay.MaintainAnnualIncome.txtIncomeTaxPaid" maxlength="10" size="23" onchange="lfnChange(this.value);"  readonly="" style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtProfessionalTax" /></td>
                              <td ><html:text  property="txtProfessionalTax" styleClass = "required" altKey="pay.MaintainAnnualIncome.txtProfessionalTax" maxlength="10" size="23" onchange="lfnChange(this.value);" readonly=""  style="text-align:right" /></td>
                              
                          </tr> 

	                       <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtEdnCessPaid" /></td>
                              <td ><html:text  property="txtEdnCessPaid" styleClass = "required" altKey="pay.MaintainAnnualIncome.txtEdnCessPaid" maxlength="10" size="23" onchange="lfnChange(this.value);"  readonly="" style="text-align:right" /></td>
                            <!--  <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtExternalITPaid" /></td>  -->
                                 <td width="25%" class=labelText>Higher Education Cess</td>
                              <td ><html:text  property="txtExternalITPaid" altKey="pay.MaintainAnnualIncome.txtExternalITPaid" maxlength="10" size="23" styleClass="required" onchange="lfnChange(this.value);"  style="text-align:right" /></td>                              
                              
                          </tr> 
                          
                            <TR>
                            
                            <!--  <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtMedicalReimb" /></td>  -->
                               <td width="25%" class=labelText>Surcharge Paid</td>
                              <td ><html:text  property="txtMedicalReimb" altKey="pay.MaintainAnnualIncome.txtMedicalReimb" maxlength="10" size="23" styleClass="required" onchange="lfnChange(this.value);" readonly=""  style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtHRPaid" /></td> 
                              <td ><html:text  property="txtHRPaid" altKey="pay.MaintainAnnualIncome.txtHRPaid" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  readonly="" style="text-align:right" /></td>
                              
                          </tr> 
                       
                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtTaxDueToAppor" /></td>
                              <td ><html:text  property="txtTaxDueToAppor" altKey="pay.MaintainAnnualIncome.txtTaxDueToAppor" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtApporAmt" /></td>
                              <td ><html:text  property="txtApporAmt" altKey="pay.MaintainAnnualIncome.txtApporAmt" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" style="text-align:right" /></td>
                              
                          </tr> 
                      
                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtExternalIncome" /></td>
                              <td ><html:text  property="txtExternalIncome" altKey="pay.MaintainAnnualIncome.txtExternalIncome" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtGIS" /></td>
                              <td ><html:text  property="txtGIS" altKey="pay.MaintainAnnualIncome.txtGIS" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"   readonly="" style="text-align:right" /></td>
                          </tr> 
                                    
                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtCPF" /></td>
                              <td ><html:text  property="txtCPF" altKey="pay.MaintainAnnualIncome.txtCPF" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  readonly=""  style="text-align:right" /></td>
                              <td  width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtEPF" /></td>
                              <td ><html:text  property="txtEPF" altKey="pay.MaintainAnnualIncome.txtEPF" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" readonly="" style="text-align:right" /></td>
                              
                          </tr> 
                       
                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtFPF" /></td>
                              <td ><html:text  property="txtFPF" altKey="pay.MaintainAnnualIncome.txtFPF" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" readonly="" style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtLIC" /></td>
                              <td ><html:text  property="txtLIC" altKey="pay.MaintainAnnualIncome.txtLIC" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" readonly=""  style="text-align:right" /></td>
                              
                          </tr> 
                      
                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtVPF" /></td>
                              <td ><html:text  property="txtVPF" altKey="pay.MaintainAnnualIncome.txtVPF" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  readonly="" style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtOtherDedn" /></td>
                              <td ><html:text  property="txtOtherDedn" altKey="pay.MaintainAnnualIncome.txtOtherDedn" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  readonly="" style="text-align:right" /></td>
                              
                          </tr> 



                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtCTD" /></td>
                              <td ><html:text  property="txtCTD" altKey="pay.MaintainAnnualIncome.txtCTD" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  readonly="" style="text-align:right" /></td>
                              <td  width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtPLI" /></td>
                              <td ><html:text  property="txtPLI" altKey="pay.MaintainAnnualIncome.txtPLI" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" readonly="" style="text-align:right"  /></td>
                              
                          </tr> 

                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtULI" /></td>
                              <td ><html:text  property="txtULI" altKey="pay.MaintainAnnualIncome.txtULI" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  readonly="" style="text-align:right"  /></td>
                              <td  width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtGPF" /></td>
                              <td ><html:text  property="txtGPF" altKey="pay.MaintainAnnualIncome.txtGPF" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" readonly="" style="text-align:right"  /></td>
                              
                          </tr> 
                          
                            
                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtHbaInt" /></td>
                              <td ><html:text  property="txtHbaInt" altKey="pay.MaintainAnnualIncome.txtHbaInt" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  readonly=""  style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtHbaPrincipal" /></td>
                              <td ><html:text  property="txtHbaPrincipal" altKey="pay.MaintainAnnualIncome.txtHbaPrincipal" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" readonly="" style="text-align:right" /></td>
                              
                          </tr> 
                      
                          <TR>
                            
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtSalPrevEmployer" /></td>
                              <td ><html:text  property="txtSalPrevEmployer" altKey="pay.MaintainAnnualIncome.txtSalPrevEmployer" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  style="text-align:right" /></td>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtENCPF" /></td>
                              <td ><html:text  property="txtENCPF" altKey="pay.MaintainAnnualIncome.txtENCPF" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);" style="text-align:right"   /></td>                              
                          </tr> 

                          <TR>
                              <td width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtBonus" /></td>
                              <td ><html:text  property="txtBonus" altKey="pay.MaintainAnnualIncome.txtBonus" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  style="text-align:right" /></td>
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



            <!-- Purchase Requisition Info Table Starts -->
            <TABLE cellSpacing=0 cellPadding=0 >
 
              
		      <TR>
              <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              <td bgcolor="#4682B4" nowrap class=actTabText>Monthly Figures<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                            
                              <td  width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtHouseRent" /></td>
                              <td ><html:text  property="txtHouseRent" styleClass = "optional" altKey="pay.MaintainAnnualIncome.txtHouseRent" maxlength="10" size="23" onchange="lfnChange(this.value);" style="text-align:right"  /></td>
                              <td  width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtIncomeTax" /></td>
                               <td ><html:text  property="txtIncomeTax" altKey="pay.MaintainAnnualIncome.txtIncomeTax" maxlength="10" size="23" styleClass="optional" onchange="lfnChange(this.value);"  style="text-align:right"  /></td>
                              
                          </tr> 

                          <TR>
                            
                              <td  width="25%" class=labelText><bean:message key="pay.MaintainAnnualIncome.txtMthEdnCess" /></td>
                              <td ><html:text  property="txtMthEdnCess" styleClass = "optional" altKey="pay.MaintainAnnualIncome.txtHouseRent" maxlength="10" size="23" onchange="lfnChange(this.value);"  style="text-align:right"  /></td>
                              
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
<html:hidden name="frmMaintainAnnualIncome"  property="screenName" value="MaintainAnnualIncomeScreen" />
<html:hidden name="frmMaintainAnnualIncome"  property="forwardedPage" />
<html:hidden property="txtEmpNo" name="frmMaintainAnnualIncome" />
<html:hidden property="screenMode" name="frmMaintainAnnualIncome" />
<html:hidden property="positionRequested" name="frmMaintainAnnualIncome" />
<html:hidden property="userPositionRequested" name="frmMaintainAnnualIncome" />
<html:hidden property="loginLocCode" name="frmMaintainAnnualIncome" />


<html:hidden property="lovKey" name="frmMaintainAnnualIncome"  />
<html:hidden property="txtFields" name="frmMaintainAnnualIncome"  />   
<html:hidden property="txtSearchFields" name="frmMaintainAnnualIncome"  />
<html:hidden property="txtDisplayFields" name="frmMaintainAnnualIncome"  />
<html:hidden property="txtIndex" name="frmMaintainAnnualIncome"  />
<html:hidden property="buttonFlag" name="frmMaintainAnnualIncome"  />

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

      document.all.headerPrimaryKey.disabled="true";
      document.all.butEmpNo.disabled="true";           
  }

  hedMenuHandling(mode);

}


 function lfnChange(val)
{
  if(num_Check(val,1))
  {
    frmMaintainAnnualIncome.headerDataChanged.value = "true";
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
    frmMaintainAnnualIncome.action="../../../AnnIncFirstGetHeaderAction.do"
    frmMaintainAnnualIncome.submit();
}


function doGetNextHeader()
{ 
    frmMaintainAnnualIncome.userPositionRequested.value = 1*frmMaintainAnnualIncome.positionRequested.value + 1;
    frmMaintainAnnualIncome.action="../../../AnnIncGetNextHeader.do";
    frmMaintainAnnualIncome.submit();
}


function PrevHeader()
{
  frmMaintainAnnualIncome.userPositionRequested.value = 1*frmMaintainAnnualIncome.positionRequested.value - 1;
  frmMaintainAnnualIncome.action = "../../../AnnIncGetPrevHeader.do";
  frmMaintainAnnualIncome.submit();
}


function JumpHeader()
{
  frmMaintainAnnualIncome.userPositionRequested.value = 1*frmMaintainAnnualIncome.newPositionRequested.value;
  frmMaintainAnnualIncome.action = "../../../AnnIncGetNextHeader.do";
  frmMaintainAnnualIncome.submit();
}


function doRefresh()
{
  frmMaintainAnnualIncome.action="../../../AnnIncRefresh.do"
  frmMaintainAnnualIncome.submit();
}


function SaveRecord()
{
  if(mandatory_Check("frmMaintainAnnualIncome"))
  {

       var grossInc = parseInt(document.getElementById("txtGrossIncome").value);
       var taxableInc = parseInt(document.getElementById("txtTaxableIncome").value);
       var HRA = parseInt(document.getElementById("txtHRA").value);
       var taxableHRR = parseInt(document.getElementById("txtTaxableHrr").value);
       var INcTaxPaid = parseInt(document.getElementById("txtIncomeTaxPaid").value);
       var ProfTax = parseInt(document.getElementById("txtProfessionalTax").value);
       var TaxDTApp = parseInt(document.getElementById("txtTaxDueToAppor").value);
       var ApporAmt = parseInt(document.getElementById("txtApporAmt").value);
       var MthHR = parseInt(document.getElementById("txtHouseRent").value);
       var MthIT = parseInt(document.getElementById("txtIncomeTax").value);

      if( grossInc < taxableInc )
      {
        alert("Gross Income should be greater than or equal to Taxable Income");
        document.getElementById("txtGrossIncome").focus();
        return false;                        
      }


    if( taxableInc < HRA )
      {
        alert("Taxable Income should be greater than HRA ");
        document.getElementById("txtTaxableIncome").focus();
        return false;                        
      }

   if( taxableInc < taxableHRR )
      {
        alert("Taxable Income should be greater than TaxableHRR ");
        document.getElementById("txtTaxableIncome").focus();
        return false;                        
      }

    if( taxableInc < INcTaxPaid )
      {
        alert("Taxable Income should be greater than IncomeTaxPaid");
        document.getElementById("txtTaxableIncome").focus();
        return false;                        
      }

   if( taxableInc < ProfTax )
      {
        alert("Taxable Income should be greater than ProfessionalTax Paid");
        document.getElementById("txtTaxableIncome").focus();
        return false;                        
      }

   if( HRA < MthHR )
      {
        alert("HRA should be greater than Monthly House Rent");
        document.getElementById("txtHRA").focus();
        return false;                        
      }

    if( grossInc < MthIT )
      {
        alert("	Monthly IT should be less than Gross Income");
        document.getElementById("txtGrossIncome").focus();
        return false;                        
      }




    frmMaintainAnnualIncome.txtEmpNo.value = "##";
    frmMaintainAnnualIncome.detailDataChanged.value = "false";  
    if(frmMaintainAnnualIncome.screenMode.value == "N")
      frmMaintainAnnualIncome.headerDataChanged.value = "true";  
  
    frmMaintainAnnualIncome.headerPrimaryKey.disabled = "";
    frmMaintainAnnualIncome.headerFields.value = "true";
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmMaintainAnnualIncome.action = "../../../AnnIncSaveAction.do";
    frmMaintainAnnualIncome.submit();
  }
  else
  {
    return false;
  }
}


function doInsertMode()
{
  frmMaintainAnnualIncome.action="../../../AnnIncNewMode.do"
  frmMaintainAnnualIncome.submit();
}

function doQueryMode()
{
  frmMaintainAnnualIncome.action="../../../AnnIncQueryMode.do"
  frmMaintainAnnualIncome.submit();
}


function ShowEmpNum()
{
   frmMaintainAnnualIncome.lovKey.value = "AnnInc" + frmMaintainAnnualIncome.screenName.value + frmMaintainAnnualIncome.screenMode.value;
   frmMaintainAnnualIncome.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
//   frmMaintainAnnualIncome.txtSearchFields.value = "Payroll.MaintElecMtrRdg.empno";
   frmMaintainAnnualIncome.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";   
   frmMaintainAnnualIncome.txtIndex.value ="";
   frmMaintainAnnualIncome.queryParam.value="txtSiteID="+ frmMaintainAnnualIncome.loginLocCode.value +" " ;      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainAnnualIncome');
   return true;
}

function ShowLovYYMM()
{
   frmMaintainAnnualIncome.lovKey.value = "AnnIncFinYYMM" + frmMaintainAnnualIncome.screenName.value + frmMaintainAnnualIncome.screenMode.value;
   frmMaintainAnnualIncome.txtDisplayFields.value = "txtFinYYMM";      
   frmMaintainAnnualIncome.txtSearchFields.value = "pay.MaintainAnnualIncome.FinYYMM";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintainAnnualIncome');
   return true;
}

</script>         
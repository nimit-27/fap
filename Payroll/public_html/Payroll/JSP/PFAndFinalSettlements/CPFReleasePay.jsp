<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
 
</head>

<BODY scroll=no onload="siteLoad()" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="CPFReleasePay" name="frmCPFFinalPayForm" type="FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm" scope="session">
<bean:define id="ParentForm" name="frmCPFFinalPayForm" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>CPF ADVANCE/PART-FINAL PAYMENT DETAILS</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
   <TR>
    <TD>
     <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0>
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=2>Header For Payment Details</TD>
        </TR>
        <TR>
              <TD colspan=2 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>

            <td class="labelText"  width="25%" >Sanction Type</td>
            <td width="25%">
            <logic:equal name="frmCPFFinalPayForm" property="screenMode" value="Q" >
            <html:select property="hdnSancType" styleClass="required" >
            <html:option value="" >-----------Please Select-----------</html:option>      
                <logic:present name="CPFFinalPayComboVO">
                  <html:optionsCollection label="label" value="value" property="sancTypeList" name="CPFFinalPayComboVO"/>
                </logic:present>
                </html:select>
            </logic:equal>
            
            <logic:notEqual name="frmCPFFinalPayForm" property="screenMode" value="Q" >
            <html:select property="hdnSancType" styleClass="required"  disabled="true">
            <html:option value="" >-----------Please Select-----------</html:option>      
                <logic:present name="CPFFinalPayComboVO">
                  <html:optionsCollection label="label" value="value" property="sancTypeList" name="CPFFinalPayComboVO"/>
                </logic:present>
                </html:select>
            </logic:notEqual>
                </td>
           
          
            <td class="labelText" width="25%" ><bean:message key="Payroll.EmpInfo.Empno" />
            </td>
            <td width="25%">
            <html:text property="txtEmpNo" readonly="true" styleClass="required" />
            <logic:equal name="frmCPFFinalPayForm" property="screenMode" value="Q" >  
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtParentLoc" onclick="ShowEmpNum();" >
             </logic:equal>
            </td>
           
        </tr>
      <tr height="10">		    
        <TD colspan="2" > </TD>
      </tr>
   	 </table>
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText>Payment Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                            <DIV id=divDtlTable style="height:320px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                <TBODY>
                                
                                  <TR height="22">
                                      <td class=tableHeader width="0.5%"></td>
                                      <td class=tableHeader width="3%">Emp No</td>
                                      <td class=tableHeader width="6%"><bean:message key="Payroll.EmpInfo.EmpName" /></td>
                                      <td class=tableHeader width="3%"><bean:message key="Payroll.EmpInfo.sancOrderNo" /></td>
                                      <td class=tableHeader width="3%"><bean:message key="Payroll.EmpInfo.SancDate" /></td>
                                      <td class=tableHeader width="3%"><bean:message key="Payroll.EmpInfo.SancAmnt" /></td>
                                      <td class=tableHeader width="3%">Employee Contribution</td>
                                      <td class=tableHeader width="3%">Employer Contribution</td>
                                      <td class=tableHeader width="5%">Reason</td>
                                      <td class=tableHeader width="3%">Recovery YYYYMM</td>
                                      <logic:equal property="hdnSancType" name="frmCPFFinalPayForm" value="P">
                                      <td class=tableHeader width="3%">IT Ded</td>
                                      </logic:equal>
                                      <td class=tableHeader width="5%">Invoice No</td>
                                      <td class=tableHeader width="4%">&nbsp;</td>
                                   </tr>
                           <html:hidden property="hdnRecYYMM" name="frmCPFFinalPayForm" />      
                           <logic:iterate id="pymntInfo" name="frmCPFFinalPayForm" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.CPFFinalPaymentDetailBean" >
                              <% ++i; %>                            
                                   <tr>   <% ++j; %>
                                       <td align=center ></td>
                                       <td ><html:text property="txtEmpNoDtl" name="pymntInfo" size="9" disabled="true" maxlength="530"  styleClass="required" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="upper(this); checkDuplicacy('txtSiteName',this.alt); return changed(this.alt);" /></td>
                                       <td ><html:text property="txtEmpNameDtl" name="pymntInfo" size="15" disabled="true" maxlength="510" styleClass="optional" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>
                                        <td ><html:text property="sancOrderNoDtl" name="pymntInfo" size="15" readonly="true" styleClass="required" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /> </td>
                                        <td ><html:text property="sancDateDtl" name="pymntInfo" disabled="true" maxlength="6" styleClass="optional" size="9" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt);" /></td>
                                        <td ><html:text property="sancAmountDtl" name="pymntInfo" disabled="true" maxlength="15" styleClass="optional" size="9" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt);" /></td>
                                        <td ><html:text property="txtEmployeeCntr" name="pymntInfo" disabled="true" maxlength="15" styleClass="optional" size="9" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>"  onchange="return changed(this.alt);" /></td>
                                        <td ><html:text property="txtEmployerCntr" name="pymntInfo" disabled="true" maxlength="15" styleClass="optional" size="9" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>"  onchange="return changed(this.alt);" /></td>
                                        <td ><html:text property="txtsancReason" name="pymntInfo" disabled="true" maxlength="15" styleClass="optional" size="9" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>"  onchange="return changed(this.alt);" /></td>
                                        <td ><html:text property="txtRecYYYYMM" name="pymntInfo" size="15" disabled="true" maxlength="510" styleClass="optional" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>
                                        <logic:equal property="hdnSancType" name="frmCPFFinalPayForm" value="P">
                                        <td >
                                        <logic:equal property="flgDedITDtl" name="pymntInfo" value="Y">  
                                        <html:text property="dedITDtl" name="pymntInfo" maxlength="7" styleClass="optional" disabled="true" size="9" style="width:90%;text-align:left" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt);" />
                                        </logic:equal>  
                                        <logic:notEqual property="flgDedITDtl" name="pymntInfo" value="Y">
                                        <html:text property="dedITDtl" name="pymntInfo" maxlength="7" styleClass="optional" size="9" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>;"  /> 
                                        
                                        <!--  onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt);"  />    -->
                                        </logic:notEqual>  
                                        </td>
                                        </logic:equal>
                                        <td ><html:text property="txtInvoiceNo" name="pymntInfo" size="25" disabled="true" maxlength="510" styleClass="optional" style="width:110%;text-align:left" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>
                                        <td align="center"> <html:button property="butRelease" value="Release Payment" alt="<%=String.valueOf(i)%>" onclick="doGetSanc(this.alt)" /> </td>
                                       <html:hidden property="flgDedITDtl" name="pymntInfo" />
                                       <html:hidden property="itemChecked" name="pymntInfo" />
                                       <html:hidden property="status" name="pymntInfo" />
                                       <html:hidden property="detailId" name="pymntInfo" />
                                    </tr>                              
                           </logic:iterate>

                                 </TBODY>
                                </TABLE>
                              </DIV>
                             </TD>
                            </TR>                     
          
              <!-- Get details starts -->
                            <tr>
                              <td colspan=11>	
                                <TABLE border=0>
                                  <TBODY>
                                  <TR>
                                    <TD><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" /></td>                                 
                                  </TR>
                                </TBODY>
                              </TABLE>
                             </TD>
                            </tr>
                          
                          </TBODY>
                        </TABLE>
                      </td>
                    </tr>
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


<!-- Container Table Ends -->
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="headerPrimaryKey" />
<html:hidden property="screenMode" name="frmCPFFinalPayForm" />
<html:hidden name="frmCPFFinalPayForm"  property="screenName" value="CPFReleasePayScreen" />
<html:hidden name="frmCPFFinalPayForm"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmCPFFinalPayForm"  />
<html:hidden property="pageRequested" name="frmCPFFinalPayForm" />
<html:hidden property="userPageRequested" name="frmCPFFinalPayForm" />
<html:hidden property="userPositionRequested" name="frmCPFFinalPayForm" />
<html:hidden property="buttonFlag" name="frmCPFFinalPayForm"  />
<html:hidden property="lovKey" name="frmCPFFinalPayForm"  />
<html:hidden property="txtFields" name="frmCPFFinalPayForm"  />   
<html:hidden property="txtSearchFields" name="frmCPFFinalPayForm"  />
<html:hidden property="txtDisplayFields" name="frmCPFFinalPayForm"  />
<html:hidden property="txtIndex" name="frmCPFFinalPayForm"  />
<html:hidden property="loginLocCode" name="frmCPFFinalPayForm"  />
<html:hidden property="hdnAction" name="frmCPFFinalPayForm" />
<html:hidden property="txtDedIT" name="frmCPFFinalPayForm" />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

 <script language="javascript">

function GetDetail()
{
    document.all.hdnSancType.disabled="";
    if(document.all.hdnSancType.value=='')
    {
      alert("Please Select Sanction Type");
      return false;
    }
    
     if(document.all.txtEmpNo.value=='')
    {
      alert("Please Select the Employee");
      return false;
    }
    
    document.all.screenMode.value='U';
    frmCPFFinalPayForm.action="../../../CPFReleasePayGetDetailAction.do"
    frmCPFFinalPayForm.submit();
}


function siteLoad()
{
 // document.all.txtDedIT.value=document.getElementsByName("dedITDtl")[i-1].value;
 
 // doQueryMode();
  mode = document.all.screenMode.value;
//  alert('mode '+mode);
  if(mode=='')
  {
      doQueryMode();
   }
  
if(mode=='Q')
     {
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
     } 


  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }


  if(mode=='U')
  {
    //  document.all.txtRecYYYYMM.disabled = "";
  //  alert( 'no ' +document.all.txtInvoiceNo.value);
 //   if(document.all.hdnSancType.value=='P') 
    {
         if(document.all.txtInvoiceNo.value != '')
          {
             document.all.butRelease.disabled = "true";
             
          }
         else
          {
            document.all.butRelease.disabled = "";
          }
    }  
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";
      
  }
//detMenuHandling(mode);
menuHandling(mode);
}
function upper(val)
{
   val.value=val.value.toUpperCase();
}
     
function doBasePrevDetail()
{
    frmCPFFinalPayForm.userPageRequested.value = 1*frmCPFFinalPayForm.pageRequested.value - 1;
    frmCPFFinalPayForm.action = "../../../CPFReleasePayGetNextDetail.do";
    frmCPFFinalPayForm.submit();
}


function doBaseNextDetail()
{
    frmCPFFinalPayForm.userPageRequested.value = 1*frmCPFFinalPayForm.pageRequested.value + 1;
    frmCPFFinalPayForm.action = "../../../CPFReleasePayGetNextDetail.do";
    frmCPFFinalPayForm.submit();
}

function JumpDetail()
{
    frmCPFFinalPayForm.userPageRequested.value = 1*frmCPFFinalPayForm.newPageRequested.value ;
    frmCPFFinalPayForm.action = "../../../CPFReleasePayGetNextDetail.do";
    frmCPFFinalPayForm.submit();
}

function menuHandling(mode)
{
  if(mode=='' || mode =='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    

      document.all.butnGo.disabled="true";    
  }
  else
  {
      document.all.butQueryMode.disabled="";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    

  }
 

}

function doQueryMode()
{
     frmCPFFinalPayForm.action="../../../CPFReleasePayQueryMode.do"
     frmCPFFinalPayForm.submit();

}

function doRefresh()
{
 
  frmCPFFinalPayForm.action="../../../CPFReleasePayRefresh.do";
  frmCPFFinalPayForm.submit();
}

function ShowEmpNum()
{
    document.all.hdnSancType.disabled="";
    if(document.all.hdnSancType.value=='')
    {
      alert("Please Select Sanction Type");
      return false;
    }
    frmCPFFinalPayForm.lovKey.value = "EmpCpf" + frmCPFFinalPayForm.screenName.value + "Q";    
    frmCPFFinalPayForm.txtDisplayFields.value = "txtEmpNo";
    frmCPFFinalPayForm.queryParam.value = "txtSiteID="+frmCPFFinalPayForm.loginLocCode.value+",hdnEmpLbrFlag="+frmCPFFinalPayForm.hdnEmpLbrFlag.value+",hdnSancType="+frmCPFFinalPayForm.hdnSancType.value;
    frmCPFFinalPayForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
    frmCPFFinalPayForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmCPFFinalPayForm');
    return true;
}

function doGetSanc(i)
{
  document.all.butRelease.disabled="true";
  document.all.headerPrimaryKey.value=document.getElementsByName("detailId")[i-1].value;
  document.all.hdnRecYYMM.value = document.getElementsByName("txtRecYYYYMM")[i-1].value;
 // alert('hdnRecYYMM '+document.all.hdnRecYYMM.value);
  if(document.all.hdnSancType.value=='P')
 // alert(' dedIT '+document.getElementsByName("dedITDtl")[i-1].value)
    document.all.txtDedIT.value=document.getElementsByName("dedITDtl")[i-1].value;
  
  document.all.hdnAction.value="relCPFPay";
  frmCPFFinalPayForm.action="../../../CPFReleasePayment.do";
  frmCPFFinalPayForm.submit();
}
 </script>
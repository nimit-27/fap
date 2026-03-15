<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD> 
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
   
</head>
<BODY scroll=yes onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintLoanDtlsAdminBase" name="frmMaintLoanDtls" type="FCIPAY.Payroll.WEBTIER.Form.MaintLoanDtlsForm" scope="session">
<bean:define id="ParentForm" name="frmMaintLoanDtls" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
<TR height=30>
  <TD  colSpan=6 class=mainHeader height=10>MAINTAIN LOAN DETAILS (Admin User)</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0  border = 0>
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=18>Header For Employee Details</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
              <td colspan="6"></td>
            </tr>         
                            
            
            <tr></tr>
         </tr>
         
              <table  cellSpacing=0 cellPadding=0 border=0>     
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" colspan="5" >
                  <logic:equal property= "screenMode" name= "frmMaintLoanDtls" value="N">                   
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();" readonly="true">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmMaintLoanDtls" value="N">
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required"  readonly="true"/>
                  </logic:notEqual> 
                  <logic:equal property= "screenMode" name= "frmMaintLoanDtls" value="U">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo" >
                  </logic:equal>                                                                    
                  <logic:equal property= "screenMode" name= "frmMaintLoanDtls" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();" readonly="true">
                  </logic:equal>                   
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td>                  
                  
               </TR> 
               
               <tr>
                    <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /> </td>                            
                    <td ><html:text property="txtDsgn" styleClass="locked" readonly="true" size="23"/></td>                  
                    
                    <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                    <td ><html:text property="txtCateg" styleClass="locked" readonly="true" size="23"/></td> 
                    
                    <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                    <td><html:text  property="txtPresentPOP" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" styleClass="locked" readonly="true"/></td>                      
                    
                    </tr>  
                </table>     
          </tr>    
       
       <tr height="10">		    
        <TD > </TD>
      </tr>
   	 </table>
    
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=2 >

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>Loan Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="18">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail">
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"    /></td>
                            <TD class=tableHeader width="4%"><bean:message  key="Payroll.IntRates.loanType" /></TD>
                            <TD class=tableHeader width="7%"><bean:message  key="Payroll.LoanDtls.loanDesc" /></td>
                            <TD class=tableHeader width="4%"><bean:message  key="Payroll.LoanDtls.loanAmnt" /></TD>                            
                            <TD class=tableHeader width="7%"><bean:message  key="Payroll.LoanDtls.sanctionDate" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.LoanDtls.sanctionNo" /></td>
                            <TD class=tableHeader width="3%"><bean:message  key="Payroll.LoanDtls.recStartDate" /></td>
                            <TD class=tableHeader width="1%"><bean:message  key="Payroll.LoanDtls.noofPrincInstall" /></td>
                            <TD class=tableHeader width="1%"><bean:message  key="Payroll.LoanDtls.noofIntInstall" /></td>                                    
                            <TD class=tableHeader width="4%"><bean:message  key="Payroll.LoanDtls.installAmnt" /></td>                                    
                            <TD class=tableHeader width="4%"><bean:message  key="Payroll.LoanDtls.firstLoanAmnt" /></td>                                    
                            <TD class=tableHeader width="4%"><bean:message  key="Payroll.LoanDtls.intInstallAmnt" /></td>
                            
                            <TD class=tableHeader width="2%">Bal princ. or int instal</td>
                            <TD class=tableHeader width="2%">Paid Install</td>
                            <TD class=tableHeader width="4%">Total Amount Paid</td>
                            <TD class=tableHeader width="4%">Bal Prin.</td>
                            <TD class=tableHeader width="4%">Total Int Amt</td>  
                            <TD class=tableHeader width="4%">Bal Int Amt</td>
                          </TR>
                       
                          <logic:iterate id="LoanDtls" name="frmMaintLoanDtls" property="lstInstrAdminDtls" type="FCIPAY.Payroll.UTILITY.LoanDtlsDetailBean" >
                              <% ++i; %>
                                <logic:notEqual name="LoanDtls" property="status" value="D" >                                                        
                          
                             <tr>  <% ++j; %>
                              <td  align="center"><html:checkbox property="checked" onclick="checkRecord();" /></td>
                              <td  ><html:text property="loanType" name="LoanDtls" styleClass="required"  alt="<%=String.valueOf(i)%>" style="width:50%;text-align:left" onchange="setMandatory(this.alt)" maxlength="5" readonly="true" />
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=String.valueOf(i)%>" property="buttxtEmpNo"  onclick="ShowLovLoan(this.alt);" >
                                </td> 
                              <td ><html:textarea property="loanDesc" styleClass="locked"  name="LoanDtls" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  rows="1" readonly="true"/></td>
                                <td ><html:text property="loanAmnt" styleClass="required"  name="LoanDtls" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>
                                <td ><html:text property="sanctionDate" name="LoanDtls" styleClass="required"  style="width:70%;text-align:left"  alt="<%=String.valueOf(i)%>"  maxlength="50" readonly="true" onchange="changed(this.alt);"  />&nbsp;<img width=16 title="Calender" height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butSanctionDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>" onclick="showCalendar('sanctionDate',this)"  ></td>
                                <td ><html:textarea property="sanctionNo" name="LoanDtls" styleClass="required"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  rows="1" onchange="changed(this.alt);"  />
                                <td ><html:text property="recStartDate" name="LoanDtls" styleClass="required"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  onchange="if(chk_YearMonth(this.value,this.alt)) changed(this.alt);"   /></td>
                                <td ><html:text property="noofPrnInstall" name="LoanDtls" styleClass="required"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>
                                <td ><html:text property="noofIntInstall" name="LoanDtls" styleClass="optional"  style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="lfnChange(this.value,this.alt);"  /></td>                                       
                                <td ><html:text property="installAmnt" name="LoanDtls" styleClass="required"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>                                       
                                <td ><html:text property="firstInstallAmnt" name="LoanDtls" styleClass="required"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="checkInstallAmt(this.alt);lfnChange(this.value,this.alt);"  /></td>                                       
                                  <td ><html:text property="intInstallAmnt" name="LoanDtls" styleClass="optional" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="lfnChange(this.value,this.alt);"  /></td>                                       
                              
                                <td ><html:text property="balInstall" name="LoanDtls" styleClass="locked" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  maxlength="50" readonly="true" onchange="lfnChange(this.value,this.alt);"  /></td>                                       
                                <td ><html:text property="paidInstall" name="LoanDtls" styleClass="required" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="calcBalInstall(this.value,this.alt); lfnChange(this.value,this.alt);"  /></td>                                       
                                <td ><html:text property="paidAmt" name="LoanDtls" styleClass="locked" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  maxlength="50" readonly="true" onchange="lfnChange(this.value,this.alt);"  /></td>                                       
                                <td ><html:text property="balPrnAmt" name="LoanDtls" styleClass="locked" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  maxlength="50" readonly="true" onchange="lfnChange(this.value,this.alt);"  /></td>                                       
                                  <td ><html:text property="intAmnt" name="LoanDtls" styleClass="optional" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="onChangeIntAmnt(this.value,this.alt); lfnChange(this.value,this.alt);"  /></td>                                       
                                  <td ><html:text property="balIntAmt" name="LoanDtls" styleClass="optional" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="lfnChange(this.value,this.alt);"  /></td>                                       
                              
                              
                              
                              <html:hidden property="itemChecked" name="LoanDtls" />
                              <html:hidden property="loanFlag" name="LoanDtls" />
                              <html:hidden property="status" alt="<%=String.valueOf(i)%>" name="LoanDtls"/>
                              <html:hidden property="transMastId" alt="<%=String.valueOf(i)%>" name="LoanDtls" />
                              <html:hidden property="detailId" name="LoanDtls" />
                          </tr>  
                        </logic:notEqual>
                        <logic:equal name="LoanDtls" property="status" value="D" >
                           <tr>
                              <td  width="1%" ><html:hidden property="checked" value="notchecked" /></td>
                              <td  width="8%" ><html:hidden property="loanType" name="LoanDtls" /></td>
                              <td  width="15%" ><html:hidden property="loanDesc" name="LoanDtls"  /></td>
                              <td  width="8%" ><html:hidden property="loanAmnt" name="LoanDtls"  /></td>                              
                              <td  width="10%" ><html:hidden property="sanctionDate" name="LoanDtls"  /></td>
                              <td  width="10%" ><html:hidden property="sanctionNo" name="LoanDtls"  /></td>
                              <td  width="10%" ><html:hidden property="recStartDate" name="LoanDtls"  /></td>
                              <td  width="10%" ><html:hidden property="noofPrnInstall" name="LoanDtls"  /></td>
                              <td  width="10%" ><html:hidden property="noofIntInstall" name="LoanDtls"  /></td>                                                    
                              <td  width="10%" ><html:hidden property="installAmnt" name="LoanDtls"  /></td>                                                    
                              <td  width="8%" ><html:hidden property="firstInstallAmnt" name="LoanDtls"  /></td>                                                 
                              <td  width="8%" ><html:hidden property="intInstallAmnt" name="LoanDtls"  /></td>
                              
                              <td  width="8%" ><html:hidden property="balInstall" name="LoanDtls"  /></td>
                              <td  width="8%" ><html:hidden property="paidInstall" name="LoanDtls"  /></td>
                              <td  width="8%" ><html:hidden property="paidAmt" name="LoanDtls"  /></td>
                              <td  width="8%" ><html:hidden property="balPrnAmt" name="LoanDtls"  /></td>
                              <td  width="8%" ><html:hidden property="intAmnt" name="LoanDtls"  /></td>
                              <td  width="8%" ><html:hidden property="balIntAmt" name="LoanDtls"  /></td>
                              
                              <html:hidden property="itemChecked" name="LoanDtls" />
                              <html:hidden property="loanFlag" name="LoanDtls" />
                              <html:hidden property="status" alt="<%=String.valueOf(i)%>"  name="LoanDtls"/>
                              <html:hidden property="transMastId" name="LoanDtls" />
                              <html:hidden property="detailId" name="LoanDtls" />
                          </tr>  
                        </logic:equal>                                                              
                       </logic:iterate>       
                       </TBODY>
                     </TABLE>
                    </DIV>
                   </TD>
                  </TR>                     
                  
   <!-- Get details starts -->
	          <tr>
		          <td colspan=11>	
                    <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                </TD>
               
                  </tr>
  </TBODY>
		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
               <tr>
		<TD background="../INCLUDES/IMAGES/line_r.gif"><IMG src="../INCLUDES/IMAGES/pixel.gif" border=0></TD>
		</TR>
    <TR>
     <TD align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>

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


<!-- Container Table Ends -->
<html:hidden property="totalDetailRecord" name="frmMaintLoanDtls" />
<html:hidden property="headerPrimaryKey" name="frmMaintLoanDtls" />
<html:hidden property="screenMode" name="frmMaintLoanDtls" />
<html:hidden name="frmMaintLoanDtls"  property="screenName" value="LoanDtlsAdminScreen" />
<html:hidden name="frmMaintLoanDtls"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmMaintLoanDtls" />
<html:hidden property="userPositionRequested" name="frmMaintLoanDtls" />
<html:hidden property="pageRequested" name="frmMaintLoanDtls" />
<html:hidden property="userPageRequested" name="frmMaintLoanDtls" />
<html:hidden property="flag" name="frmMaintLoanDtls" />
<html:hidden property="loginLocCode" name="frmMaintLoanDtls" />
<input type=hidden name=queryParam>
<html:hidden property="lovKey" name="frmMaintLoanDtls"  />
<html:hidden property="txtFields" name="frmMaintLoanDtls"  />   
<html:hidden property="txtSearchFields" name="frmMaintLoanDtls"  />
<html:hidden property="txtDisplayFields" name="frmMaintLoanDtls"  />
<html:hidden property="txtInputField" name="frmMaintLoanDtls"  />
<html:hidden property="txtIndex" name="frmMaintLoanDtls"  />
<html:hidden property="buttonFlag" name="frmMaintLoanDtls"  />

</html:form>
</body>
</html:html>

<script language="javascript">
function ShowEmpNum()
{
   frmMaintLoanDtls.lovKey.value = "LoanDtls" + frmMaintLoanDtls.screenName.value + frmMaintLoanDtls.screenMode.value; 
   frmMaintLoanDtls.queryParam.value = "txtSiteID="+frmMaintLoanDtls.loginLocCode.value+",hdnEmpLbrFlag="+frmMaintLoanDtls.hdnEmpLbrFlag.value;
   frmMaintLoanDtls.txtInputField.value="";
   if(frmMaintLoanDtls.screenMode.value == 'N')
   {
       frmMaintLoanDtls.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCateg,txtDsgn,txtPresentPOP";      
       frmMaintLoanDtls.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
       frmMaintLoanDtls.txtIndex.value ="";      
   }
   if(frmMaintLoanDtls.screenMode.value == 'Q')
   {
     frmMaintLoanDtls.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCateg,txtDsgn,txtPresentPOP";
     frmMaintLoanDtls.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
     frmMaintLoanDtls.txtIndex.value ="";      
   }
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintLoanDtls');
   return true;
}

function ShowLovLoan(i)
{
  if (document.getElementsByName("status")[i-1].value != 'Q') 
  {
    frmMaintLoanDtls.lovKey.value = "LoanDtlsLoanType" + frmMaintLoanDtls.screenName.value + frmMaintLoanDtls.screenMode.value;       
    frmMaintLoanDtls.txtDisplayFields.value = "loanType,loanDesc,loanFlag,noofPrnInstall";
    frmMaintLoanDtls.txtSearchFields.value = "";
    frmMaintLoanDtls.txtInputField.value="loanType";
    frmMaintLoanDtls.txtIndex.value =i-1;      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintLoanDtls');
    return true;
  }
  else
    return false;
}

function lfnLoad()
{
     var sMode  = frmMaintLoanDtls.screenMode.value;
    if(sMode == "")
    {
        doQueryMode();
    }    
    mode = frmMaintLoanDtls.flag.value;    
    if(mode=='')
    {
        document.all.butGetDetail.disabled="disabled";   
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";
    }
    if(mode=='Q')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";     
    }
    if (frmMaintLoanDtls.screenMode.value == 'U')
    { 
        //document.getElementById("txtEffectDate").disabled = "true";
        //document.getElementById("headerPrimaryKey").disabled = "true";      
    }
    else
    {  
        //document.getElementById("txtEffectDate").disabled="";
        //document.getElementById("headerPrimaryKey").disabled="";
    } 

    if(mode=='U')
    {        
        document.all.butGetDetail.disabled="";
        document.all.butInsert.disabled="disabled";
        document.all.butDelete.disabled="disabled";       
        
    } 
    if(mode=='N')
    {        
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";        
    }    
    if(mode=='UG')
    {
        document.all.butGetDetail.disabled="disabled";
        document.all.butInsert.disabled="";
        document.all.butDelete.disabled="";
        
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
        return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;
        
        for(i=0; i < iTr2 -1; i++)
        {            
          setMandatory(i+1);
          
          if(document.getElementsByName("loanFlag")[i].value=='A' || document.getElementsByName("loanFlag")[i].value=='P')
          {
            var paidInstall = document.getElementsByName("paidInstall")[i].value==""?0:parseInt(document.getElementsByName("paidInstall")[i].value,10);              
            calcBalInstall(paidInstall,i+1);
          }
        }     
        
    }  
    mode = frmMaintLoanDtls.screenMode.value;  
    menuHandling(mode);   
    
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";   
    if(document.all.hdnEmpLbrFlag.value=='V')
    {
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
    }    
}

function doRefresh()
{
  frmMaintLoanDtls.action="../../../LoanDtlsAdminRefresh.do"
  frmMaintLoanDtls.submit();
}

 function lfnChange(val,ind)
{     
    if (num_Check(val,1))
    {
        frmMaintLoanDtls.detailDataChanged.value = "true";      
        if ((ind) > 0)
        {
            if (document.getElementsByName("status")[ind-1].value == "Q")
                document.getElementsByName("status")[ind-1].value = "U";
        }
    }  
}

function chk_YearMonth(recVal,Ind)
{       
    var  yearM = recVal;      
    var month =  yearM.substring(4,6);      
    if (num_Check(yearM,1))
    {                                       
        if (yearM.length != 6)
        {         
            alert(" Year Month should be a Six digit Number");
            document.getElementById("recStartDate").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                    
            return false;        
        }    
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("recStartDate").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;
        }
        else
        {
            return true;
        }
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;     
        return false;
    }
}

function getHeaderRecord()
{
	document.all.buttonFlag.value='';
	frmMaintLoanDtls.flag.value = "U";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmMaintLoanDtls.action="../../../LoanDtlsAdminFirstGetHeaderAction.do"
	frmMaintLoanDtls.submit();
}

function doGetNextHeader()
{
    document.all.buttonFlag.value='';
    frmMaintLoanDtls.flag.value = "U";
    frmMaintLoanDtls.userPositionRequested.value = 1*frmMaintLoanDtls.positionRequested.value + 1;
    frmMaintLoanDtls.action="../../../LoanDtlsAdminGetNextHeader.do";
    frmMaintLoanDtls.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmMaintLoanDtls.flag.value = "U";
  frmMaintLoanDtls.userPositionRequested.value = 1*frmMaintLoanDtls.positionRequested.value - 1;
  frmMaintLoanDtls.action = "../../../LoanDtlsAdminGetNextHeader.do";
  frmMaintLoanDtls.submit();
}


function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmMaintLoanDtls.flag.value = "U";
  frmMaintLoanDtls.userPositionRequested.value = 1*frmMaintLoanDtls.newPositionRequested.value;
  frmMaintLoanDtls.action = "../../../LoanDtlsAdminGetNextHeader.do";
  frmMaintLoanDtls.submit();
}

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmMaintLoanDtls.userPageRequested.value = 1*frmMaintLoanDtls.pageRequested.value - 1;
    frmMaintLoanDtls.action = "../../../LoanDtlsAdminNextDetailAction.do";
    frmMaintLoanDtls.submit();
}

function doBaseNextDetail()
{ 
    document.all.buttonFlag.value='';
    frmMaintLoanDtls.userPageRequested.value = 1*frmMaintLoanDtls.pageRequested.value + 1;
    frmMaintLoanDtls.action = "../../../LoanDtlsAdminNextDetailAction.do";
    frmMaintLoanDtls.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmMaintLoanDtls.userPageRequested.value = 1*frmMaintLoanDtls.newPageRequested.value ;
    frmMaintLoanDtls.action = "../../../LoanDtlsAdminNextDetailAction.do";
    frmMaintLoanDtls.submit();
}

function doBaseAddRow()
{  
   if(mandatory_Check("frmMaintLoanDtls") && checkIntField())
    {
        document.all.buttonFlag.value='';
        frmMaintLoanDtls.screenMode.value = "U";  
        enableLoanField();        
        document.forms[0].action = "../../../LoanDtlsAdminAddRowAction.do";     
        enableAll();      
        document.forms[0].submit();
    }
    else
    {
        return false;
    }
}

function enableAll()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
    document.getElementsByName("loanType")[i].disabled="";
    document.getElementsByName("loanDesc")[i].disabled="";
    document.getElementsByName("noofIntInstall")[i].disabled="";
    document.getElementsByName("noofPrnInstall")[i].disabled="";
    document.getElementsByName("recStartDate")[i].disabled="";
    document.getElementsByName("installAmnt")[i].disabled="";
    document.getElementsByName("firstInstallAmnt")[i].disabled="";
  }
}

function doBaseDelRow()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  var strRecList='';

  for(i=0; i < iTr2 -1; i++)
  {
    document.getElementsByName("checked")[i].disabled = "";
    if(document.getElementsByName("checked")[i].checked)
    {      
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintLoanDtls.detailDataChanged.value = "true";    
      document.all.buttonFlag.value='D';    
    }
  }
  enableAll(); 
  enableBvlntLoanField();
  document.forms[0].action = "../../../LoanDtlsAdminDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintLoanDtls") && checkIntField())
  {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;
      var i = 0;
      for(i=0; i < iTr2 -1; i++)
      {
          if(document.getElementsByName("loanFlag")[i].value=='B')
          {
            if(document.getElementsByName("intAmnt")[i].value=='' ) 
            {
              alert("Toatal Interest Amount is Mandatory");
              document.getElementsByName("intAmnt")[i].focus(); 
              return false;
            }
         }
          document.getElementsByName("checked")[i].disabled = "";
          if (document.getElementsByName("status")[i].value == 'D')
            frmMaintLoanDtls.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'N')
            frmMaintLoanDtls.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'U')
            frmMaintLoanDtls.detailDataChanged.value = "true";
      }      
      if(frmMaintLoanDtls.screenMode.value == "N")
      {     
          frmMaintLoanDtls.detailDataChanged.value = "true";
      }
      frmMaintLoanDtls.screenMode.value ="U";                    

      frmMaintLoanDtls.headerPrimaryKey.value = "##";
      //frmMaintLoanDtls.headerFields.value = "true";
      frmMaintLoanDtls.totalDetailRecord.value = parseInt(iTr2)-1;       
      frmMaintLoanDtls.buttonFlag.value='';
      enableAll();
      enableLoanField();
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintLoanDtls.action = "../../../LoanDtlsAdminSaveAction.do";
      frmMaintLoanDtls.submit();
  }
  else
  {
    return false;
  }
}


function GetDetail()
{
  document.all.buttonFlag.value='';
  frmMaintLoanDtls.headerPrimaryKey.value = "##";
  frmMaintLoanDtls.flag.value = "UG";
  frmMaintLoanDtls.action="../../../LoanDtlsAdminFirstGetDetailAction.do"
  frmMaintLoanDtls.submit();
}

function doInsertMode()
{
  document.all.buttonFlag.value='';
   frmMaintLoanDtls.flag.value='N';  
   //alert(frmMaintLoanDtls.flag.value);
  frmMaintLoanDtls.action="../../../LoanDtlsAdminNewMode.do"
  frmMaintLoanDtls.submit();
}


function doQueryMode()
{
  document.all.buttonFlag.value='';
  frmMaintLoanDtls.flag.value = 'Q';
  frmMaintLoanDtls.action="../../../LoanDtlsAdminQueryMode.do"  
  frmMaintLoanDtls.submit();
}

function showBankLov()
{
   frmMaintLoanDtls.lovKey.value = "BankMast" + frmMaintLoanDtls.screenName.value + frmMaintLoanDtls.screenMode.value;
   frmMaintLoanDtls.txtDisplayFields.value = "txtBankCode,hdnBankDesc";
   frmMaintLoanDtls.txtSearchFields.value = "Payroll.EmpInfo.BranchCode,Payroll.Common.desc";     
   frmMaintLoanDtls.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintLoanDtls');
   return true;
}

function changed(Ind)
{
  frmMaintLoanDtls.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[Ind-1].value == 'Q')
     document.getElementsByName("status")[Ind-1].value = 'U';
  
}

function upper(val)
{
   val.value=val.value.toUpperCase();
}

function checkIntField()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {      
      if (document.getElementsByName("status")[i].value != 'D')
      {
        var payCode=parseInt(document.getElementsByName("loanType")[i].value,10);
        var intInstall=trim(document.getElementsByName("noofIntInstall")[i].value);
        if(payCode >80 && intInstall=='' )
        {
          alert("Mandatory Field No of Interest Install. Empty");
          return false;
        }
      }  
  }
  return true;
}

function setMandatory(i)
{  
  if(document.getElementsByName("loanFlag")[i-1].value=='B')
  { 
    document.getElementsByName("intAmnt")[i-1].disabled="";
    document.getElementsByName("intAmnt")[i-1].style.background="#ffffd3";    
    
    document.getElementsByName("noofIntInstall")[i-1].readOnly=true;
    document.getElementsByName("noofIntInstall")[i-1].style.background="#e0e0e0";
    
    document.getElementsByName("intInstallAmnt")[i-1].readOnly=true;
    document.getElementsByName("intInstallAmnt")[i-1].style.background="#e0e0e0";
    
    document.getElementsByName("balIntAmt")[i-1].readOnly=true;
    document.getElementsByName("balIntAmt")[i-1].style.background="#e0e0e0";
    
  }
  else if(document.getElementsByName("loanFlag")[i-1].value=='L')
  {
    document.getElementsByName("noofIntInstall")[i-1].readOnly=false;
    document.getElementsByName("noofIntInstall")[i-1].style.background="#ffffd3";
    
    document.getElementsByName("intInstallAmnt")[i-1].disabled="true";
    document.getElementsByName("intInstallAmnt")[i-1].style.background="#e0e0e0";    
    
    document.getElementsByName("balIntAmt")[i-1].disabled="true";
    document.getElementsByName("balIntAmt")[i-1].style.background="#e0e0e0";    
    
    document.getElementsByName("intAmnt")[i-1].disabled="true";
    document.getElementsByName("intAmnt")[i-1].style.background="#e0e0e0";    
     
  }
  else
  {
    document.getElementsByName("intInstallAmnt")[i-1].disabled="true";
    document.getElementsByName("intInstallAmnt")[i-1].style.background="#e0e0e0";    
    
    document.getElementsByName("balIntAmt")[i-1].disabled="true";
    document.getElementsByName("balIntAmt")[i-1].style.background="#e0e0e0";    
    
    document.getElementsByName("intAmnt")[i-1].disabled="true";
    document.getElementsByName("intAmnt")[i-1].style.background="#e0e0e0";    
    
    document.getElementsByName("noofIntInstall")[i-1].value='';
    document.getElementsByName("noofIntInstall")[i-1].readOnly=true;
    document.getElementsByName("noofIntInstall")[i-1].style.background="#e0e0e0";
    
    document.getElementsByName("paidAmt")[i-1].readOnly=true;
    document.getElementsByName("paidAmt")[i-1].style.background="#e0e0e0";        
  }    
}

function checkInstallAmt(i)
{ 
  if(document.getElementsByName("loanFlag")[i-1].value=="P")
  {
    var indx=i-1;
    enableAll(); 
    //frmMaintLoanDtls.action="../../../LoanAdminIntAction.do?index="+indx;  
    //frmMaintLoanDtls.submit();
  }else
  {
    if(document.getElementsByName("loanFlag")[i-1].value=="B")
      document.getElementsByName("noofIntInstall")[i-1].value=document.getElementsByName("noofPrnInstall")[i-1].value;
    if(document.getElementsByName("loanAmnt")[i-1].value=="" || document.getElementsByName("noofPrnInstall")[i-1].value=="" || document.getElementsByName("installAmnt")[i-1].value==""|| document.getElementsByName("firstInstallAmnt")[i-1].value=="")
    {
      return true;
    }
    var loanAmnt=document.getElementsByName("loanAmnt")[i-1].value==""?0:parseInt(document.getElementsByName("loanAmnt")[i-1].value,10);
    var noofPrnInstall=document.getElementsByName("noofPrnInstall")[i-1].value==""?0:parseInt(document.getElementsByName("noofPrnInstall")[i-1].value,10);
    var installAmnt=document.getElementsByName("installAmnt")[i-1].value==""?0:parseInt(document.getElementsByName("installAmnt")[i-1].value,10);
    var firstInstallAmnt=document.getElementsByName("firstInstallAmnt")[i-1].value==""?0:parseInt(document.getElementsByName("firstInstallAmnt")[i-1].value,10);
    var calcAmt=firstInstallAmnt+(noofPrnInstall-1)*installAmnt;
    if(noofPrnInstall==1)
    {
      if(loanAmnt!=firstInstallAmnt || installAmnt!=0)
      {
        alert("Please Enter the correct installment Amount");
        document.getElementsByName("installAmnt")[i-1].value='';
        document.getElementsByName("firstInstallAmnt")[i-1].value='';
        return false;
      }
    }else if(noofPrnInstall>1)
    {
      if(installAmnt==0)
      {
        alert("Installment amount cannot be 0");
        document.getElementsByName("installAmnt")[i-1].value='';
      }
    }
    if(loanAmnt!=calcAmt)
    {
      alert("Please Enter the correct installment Amount");
      document.getElementsByName("installAmnt")[i-1].value='';
      return false;
    }
    if(document.getElementsByName("loanFlag")[i-1].value=="B")
    {
      var indx=i-1;
      //enableLoanField();
     // enableAll(); 
      //frmMaintLoanDtls.action="../../../LoanDtlAdminIntAction.do?index="+indx;  
      //frmMaintLoanDtls.submit();
    }
  }
}

function calcBalInstall(paidInstallVal,i)
{ 
  var loanAmnt=document.getElementsByName("loanAmnt")[i-1].value==""?0:parseInt(document.getElementsByName("loanAmnt")[i-1].value,10);  
  var frstInstall = document.getElementsByName("firstInstallAmnt")[i-1].value==""?0:parseInt(document.getElementsByName("firstInstallAmnt")[i-1].value,10);  
  var instAmnt = document.getElementsByName("installAmnt")[i-1].value==""?0:parseInt(document.getElementsByName("installAmnt")[i-1].value,10);  
  document.getElementsByName("balInstall")[i-1].value = parseInt(document.getElementsByName("noofPrnInstall")[i-1].value - paidInstallVal);  
  document.getElementsByName("paidAmt")[i-1].value = frstInstall+(paidInstallVal-1)*instAmnt;    
  if (paidInstallVal == 0)
  {
    document.getElementsByName("balPrnAmt")[i-1].value = loanAmnt;
    document.getElementsByName("paidAmt")[i-1].value = 0;
  }    
  else  
    document.getElementsByName("balPrnAmt")[i-1].value = loanAmnt-document.getElementsByName("paidAmt")[i-1].value;    
}

function onChangeIntAmnt(intAmnt,i)
{
  var paidInstAmnt = document.getElementsByName("paidInstall")[i-1].value==""?0:parseInt(document.getElementsByName("paidInstall")[i-1].value,10);
  var noIntInstall= document.getElementsByName("noofIntInstall")[i-1].value==""?0:parseInt(document.getElementsByName("noofIntInstall")[i-1].value,10);
  var intInstAmnt = intAmnt/noIntInstall;
  var rndIntInstAmnt = Math.round(intInstAmnt);
  document.getElementsByName("intInstallAmnt")[i-1].value = rndIntInstAmnt;
  document.getElementsByName("balIntAmt")[i-1].value = intAmnt-(paidInstAmnt*rndIntInstAmnt);  
  
} 

function enableLoanField()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
    document.getElementsByName("intInstallAmnt")[i].disabled="";
    document.getElementsByName("balIntAmt")[i].disabled="";
    document.getElementsByName("intAmnt")[i].disabled="";
  }
}

function enableBvlntLoanField()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
        document.getElementsByName("intInstallAmnt")[i].disabled="";
        document.getElementsByName("balIntAmt")[i].disabled="";
        document.getElementsByName("intAmnt")[i].disabled="";
  }
}



</script> 
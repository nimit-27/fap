<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    
    <link rel="STYLESHEET" type="text/css" href="../../CSS/PayrollMenucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>

<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="PLIActCancelBaseAction" name="frmPLIActualCancelForm" type="FCIPAY.Payroll.WEBTIER.Form.PLIActualCancelForm" scope="session">
<bean:define id="ParentForm" name="frmPLIActualCancelForm" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerDataChanged"  />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>PLI PAYMENT CANCELLATION</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>	
       <!--<div id=divBody>-->
       <!-- Body table Starts -->
        <TABLE cellSpacing=3 cellPadding=0 border=0>
       <!--Account  Header Row Starts -->
        <TR>
         <TD class=subHeader colspan=6>PLI Payment Header</TD>
        </TR>
        <TR>
          <TD colspan=4 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
        </TR>
        
        <tr>   
          <td>
            <table cellSpacing=3 cellPadding=0 border=0>              
                        
              <tr>              
                <td class="labelText" align=left><bean:message key="Payroll.PLI.PLIYear" /></td>
                <td>
                <logic:equal property= "screenMode" name= "frmPLIActualCancelForm" value="Q">                              
                <html:text  property="headerPrimaryKey" altKey="Payroll.PLI.PLIYear" maxlength="6" size="23" styleClass="required"  onchange="chk_FinYear(this.value)"onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;                  
                    };" />
                <bean:message key="Payroll.PLI.yyyy" />
                </logic:equal>                                                                                                 
                <logic:notEqual property= "screenMode" name= "frmPLIActualCancelForm" value="Q">                              
                <html:text  property="headerPrimaryKey" altKey="Payroll.PLI.PLIYear" maxlength="6" size="14" readonly="true"  onchange="chk_FinYear(this.value)" onkeypress="                   
                   if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;                  
                    };" />
                <bean:message key="Payroll.PLI.yyyy" />
                </logic:notEqual>                                                      
                </td>
               <!-- <td class=labelText>Location</td>
               <td ><html:text  property="txtLocDesc" styleClass = "required"  readonly="true"  altKey="Payroll.EmpInfo.PermAddLine1" maxlength="100" size="23"  />
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtLoc"  onclick="return ShowLovEmpLoc();">
                              <html:hidden property="txtLocId" name="frmPLIActualCancelForm" />
               </td>             
            </tr>  
            
            <tr> -->
                <td class="labelText"  ><bean:message key="Payroll.Compute.emp" /></td>
                <td ><html:text  property="txtEmpNo" altKey="Payroll.Compute.emp" maxlength="10" size="14" styleClass="required" />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpLOV"  name="buttxtEmpLOV" onclick="return showLOVEmp();">
                &nbsp;&nbsp;<html:text  property="txtEmpName" name="frmPLIActualCancelForm" readonly="true"   size="40" styleClass="locked" /></td>
            </tr>
              
            </table>
          </td>
          </tr>
          <tr height="10">		    
        <TD colspan="2" > </TD>
      </tr>
   	 </table>
    </div>
<table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                    
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    
                    <logic:notEqual property= "screenMode" name= "frmPLIActualCancelForm" value="N">
                    <td bgcolor="#4682B4" nowrap class=actTabText > PLI Payment Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    </logic:notEqual>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    
                    
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="8">
                  <TABLE cellSpacing="0" cellPadding="0" border="0" >
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail" border=0>
                          <TBODY>                          
                          <TR height=20>
                            <TD class=tableHeader width="20%"><bean:message  key="Payroll.Common.empNo" /></td>
                            <TD class=tableHeader width="20%"><bean:message  key="Payroll.Common.empName" /></td>                                       
                            <TD class=tableHeader width="20%"><bean:message  key="Payroll.PLI.PLIAmnt" /></td>                        
                            <TD class=tableHeader width="40%"><bean:message  key="Payroll.EmpInfo.InvNum" /></td> 
                            </TR>            
                          <logic:iterate id="PLIPaymentCancellation" name="frmPLIActualCancelForm" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.PLIPayCanDetailBean" indexId="idx">
                            <% ++i; %>
                                <logic:equal name="PLIPaymentCancellation" property="status" value="Q">
                                    <tr><% ++j; %>                              
                                    <!--<td align = "center"><html:checkbox property="checked"  onclick="checkRecord();" value="false" name="frmPLIActualCancelForm" /></td>-->
                                    <td width="20%"><html:text property="txtEmpNo" name="PLIPaymentCancellation" styleClass="required" readonly="true" style="width:75%;text-align:left"  alt="<%=String.valueOf(i)%>" />&nbsp;<img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpLOV" alt="<%=idx%>" name="buttxtEmpLOV" onclick="showLOVEmp(this.alt);"></td>                                                         
                                    <td width="20%"><html:text property="txtEmpName" name="PLIPaymentCancellation" styleClass="locked" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>" readonly="true" /></td>                                                         
                                    <td width="20%"><html:text property="txtPLIAmnt" name="PLIPaymentCancellation" styleClass="locked" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" readonly="true" /></td>                                                         
                                    <td width="40%"><html:text property="txtInvoice" name="PLIPaymentCancellation" styleClass="locked" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" readonly="true" /></td>                                                        
                                    <html:hidden property="itemChecked" name="PLIPaymentCancellation" />
                                    <html:hidden property="status" name="PLIPaymentCancellation" />    
                                    <html:hidden property="detailId" name="PLIPaymentCancellation" value="Default"/>
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
		          <td colspan=8>
                  <TABLE border=0>
                    <TBODY>
                        <TR >
                        <td ><jsp:include  page = "../INCLUDES/GenDetailCancelMenu.jsp" flush="true" />
                        </td>
                        </TR>
                  </TBODY>
                </TABLE>
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
<!-- These four hidden fields must be present in pages where there is a detail part -->
<html:hidden name="frmPLIActualCancelForm"  property="screenName" value="PLIPaymentCancellation" />
<html:hidden property="totalDetailRecord" name="frmPLIActualCancelForm" />
<html:hidden name="frmPLIActualCancelForm"  property="forwardedPage" />
<html:hidden name="frmPLIActualCancelForm"  property="butAction" />
<html:hidden name="frmPLIActualCancelForm"  property="hdnAction" />    
<html:hidden property="screenMode" name="frmPLIActualCancelForm"  />
<html:hidden property="screenModeFlag" name="frmPLIActualCancelForm"  />
<html:hidden name="frmPLIActualCancelForm"  property="lovKey"  />
<html:hidden name="frmPLIActualCancelForm"  property="txtFields" />   
<html:hidden name="frmPLIActualCancelForm"  property="txtSearchFields" />
<html:hidden name="frmPLIActualCancelForm"  property="txtDisplayFields"  />
<html:hidden name="frmPLIActualCancelForm"  property="txtIndex"  />
<html:hidden property="buttonFlag" name="frmPLIActualCancelForm"  />
<html:hidden property="userPageRequested" name="frmPLIActualCancelForm"  />
<html:hidden property="pageRequested" name="frmPLIActualCancelForm"  />
<html:hidden property="positionRequested" name="frmPLIActualCancelForm" />
<html:hidden property="userPositionRequested" name="frmPLIActualCancelForm" />
<html:hidden name="frmPLIActualCancelForm"  property="screenModePLI"  />
<html:hidden name="frmPLIActualCancelForm"  property="screenModePLI1"  />
<html:hidden name="frmPLIActualCancelForm"  property="screenModePLI2"  />
<html:hidden name="frmPLIActualCancelForm"  property="txtPLIYear"  />
<html:hidden name="frmPLIActualCancelForm"  property="txtEmpNo"  />
<html:hidden name="frmPLIActualCancelForm"  property="status"  />
<html:hidden property="loginLocCode" name="frmPLIActualCancelForm" />

<input type="hidden" name="queryParam" />

<!-- Hidden fields end -->

</html:form>
</body>
</html:html>

 
<script language="javascript">

function lfnLoad()
{  
  batchMenuHandling();   
  document.all.butRefresh.disabled="true";
  document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";
  mode1 = document.all.screenMode.value;    
  
  if(mode1 == '')
  {
    doQueryMode();
  }   
  document.all.butInsert.disabled="true";

  if(mode1=='Q')
  {      

  }
  menuHandling(mode1);   
}

function ShowLovEmpLoc()
{ 
    frmPLIActualCancelForm.lovKey.value = "EmpLoc" + frmPLIActualCancelForm.screenName.value + frmPLIActualCancelForm.screenMode.value;    
    frmPLIActualCancelForm.txtSearchFields.value ="Payroll.Site.LocId,Payroll.Site.LocName,Payroll.Site.parentLoc";
    frmPLIActualCancelForm.txtDisplayFields.value = "txtLocId,txtLocDesc";
    frmPLIActualCancelForm.txtIndex.value ="";
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPLIActualCancelForm');
 
   return true;
}



function showLOVEmp()
{  
    
     mode1 = document.all.screenMode.value;
   
     frmPLIActualCancelForm.lovKey.value = "PLICanPay" + frmPLIActualCancelForm.screenName.value + frmPLIActualCancelForm.screenMode.value;
     frmPLIActualCancelForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
     frmPLIActualCancelForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";     
     frmPLIActualCancelForm.queryParam.value = "txtLocationID="+document.all.loginLocCode.value+",txtScreenMode="+document.all.screenMode.value+",hdnEmpLbrFlag="+document.all.hdnEmpLbrFlag.value;
     frmPLIActualCancelForm.txtIndex.value ="";     
     
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmPLIActualCancelForm');
     return true;
}

function doRefresh()
{ 

  frmPLIActualCancelForm.action="../../../PLIActCancelRefresh.do";
  frmPLIActualCancelForm.submit();                      
}

function cancelInvoice()
{

   if(!mandatory_Check("frmPLIActualCancelForm"))
    {
      return false;
    }
    if(document.getElementById("txtInvoice")==null)
    {
      alert("Please click on GetDetail before proceeding towards Invoice Cancellation");
      return false;
    }
    
	if(confirm("Do you want to cancel Invoice"))
        {      
        
            document.getElementById("butCancelInvoice").disabled="true";
            frmPLIActualCancelForm.action="../../../CancelPLIPaymentInv.do"
            frmPLIActualCancelForm.submit();
	}
}

function doQueryMode()
{      

    document.all.screenModePLI.value  = "Q";
    document.all.screenMode.value = "Q";
    document.all.screenModePLI1.value = "Q";       
    
    frmPLIActualCancelForm.action="../../../PLIActCancelQueryAction.do"
    frmPLIActualCancelForm.submit();
}


function GetDetail()
{   
  
    if(!mandatory_Check("frmPLIActualCancelForm")) return false;  

    document.all.buttonFlag.value='';      
    document.getElementById("headerPrimaryKey").disabled="";
    frmPLIActualCancelForm.txtPLIYear.value=frmPLIActualCancelForm.headerPrimaryKey.value;           
    document.all.screenMode.value = "Q";
    document.all.screenModePLI.value='UGD';   
    frmPLIActualCancelForm.action="../../../PLIActCancelDetailAction.do"
    frmPLIActualCancelForm.submit(); 
    
}

function JumpDetail()
{
    frmPLIActualCancelForm.userPageRequested.value = 1*frmPLIActualCancelForm.pageRequested.value ;    
    frmPLIActualCancelForm.action = "../../../PLIActCancelNextDetailAction.do";
    frmPLIActualCancelForm.submit();
}


function lfnChange(ind)
{     
      frmPLIActualCancelForm.detailDataChanged.value = "true";      
      if (document.getElementsByName("status")[ind-1].value == 'Q')
         document.getElementsByName("status")[ind-1].value = 'U';
  
}

function chk_FinYear(val)
{
    var  yearM = document.getElementById("headerPrimaryKey").value;              
    var Year1;
    var Year2;    
    if ( yearM != "") 
    {
        if (num_Check(yearM,1))
        {                                   
            if (yearM.length != 6)
            {
                alert(" Year Month should be a Six digit Number");
                document.getElementById("headerPrimaryKey").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                            
                return false;    
            }        
            Year1 =  yearM.substring(2,4);
            Year2 =  yearM.substring(4,6);           
            var TempYr1 = parseInt(Year1,10)+1;             
            var TempYr2 = parseInt(Year2,10);                          
            if (TempYr1 != TempYr2)
            {
                alert("Year Range Should be in the format of a Financial Period Eg. 200809");
                document.getElementById("headerPrimaryKey").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                   
                return false;       
            }
    
            return true;                                     
        }      
        else
        {
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;     
            return false;
        }
    }
}

function getFinYear()
{
   var d = new Date();
   var fromyear,toyear,finyear;
   document.getElementById("headerPrimaryKey").value = "";
   fromyear = d.getMonth() < 2 ? d.getYear() - 1 : d.getYear()
   toyear=fromyear;
   fromyear = fromyear -1;
   
   toyear=toyear.toString();
   finyear=fromyear+toyear.substring(2,4);
   document.getElementById("headerPrimaryKey").value = finyear;  
   
}

</script>


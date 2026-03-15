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
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintIntRatesBase" name="frmMaintIntRates" type="FCIPAY.Payroll.WEBTIER.Form.MaintIntRatesForm" scope="session">
<bean:define id="ParentForm" name="frmMaintIntRates" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN INTEREST RATES ON LOANS</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 border=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>Loan Type Details</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="6"></td>
         </tr>
         
        <tr>
            <td class="labelText"  width="20%" ><bean:message key="Payroll.IntRates.loanType" /></td>
            <td width="30%"><html:text  property="headerPrimaryKey" altKey="" maxlength="10" size="10" styleClass="required" readonly="true" />
            <img src="../INCLUDES/IMAGES/lov.jpg" onmouseover="this.src='../INCLUDES/IMAGES/lov_act.jpg'" height="16" align="center" name="butLoanType"  onclick="ShowLovLoan();" >
            &nbsp;&nbsp;<html:text  property="loanHdrDesc"  name="frmMaintIntRates" maxlength="10" size="26" styleClass="locked" readonly="true" /></td>
            
            <td  width="20%" class=labelText><bean:message key="Payroll.IntRates.loanIntType" /></td>
            <td colspan="1" width="30%" ><html:select  property="loanIntType" styleClass = "required" style="width:40%" onchange="checkAddRow(this.value)" > 
            <html:option value="">-Select-</html:option> 
            <html:option value="N"> <bean:message key="Payroll.EmpInfo.No" /></html:option>                               
            <html:option value="Y" > <bean:message key="Payroll.EmpInfo.Yes" /></html:option>
            </html:select>
            </td>
            </tr>
            <tr>
           <td class=labelText width="20%" ><bean:message key="Payroll.IntRates.dateFrom" /></td>
           <td colspan="1" width="30%" ><html:text  property="dateFrom" altKey="" maxlength="10" size="16" styleClass="required" readonly="true" />&nbsp;<img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butFromDate" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" alt="<%=(i-1) %>" onclick="showCalendar('dateFrom',this)"  ></td>

           <td class=labelText width="20%" ><bean:message key="Payroll.IntRates.dateTo" /></td>
           <td colspan="1" width="30%" >
           <html:text  property="dateTo" altKey="" maxlength="10" size="16"  styleClass="optional" readonly="true" onchange="checkDates()" />&nbsp;<img width=16 height=19 align="top" src="../INCLUDES/IMAGES/cal.gif" name="butToDate" alt="<%=(i-1) %>" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('dateTo',this);"></td>
  
        </tr>
               
        <tr height="10">		    
      <TD colspan="6" > </TD>
    </tr>
  </table>    
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	 <TR height="200">
            <TD colspan=11>
            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>Loan Interest  Detail<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>   
           
              <TR height=10>                
		<!-- Detail table Container starts -->
                <TD colspan="11">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:250px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail">
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="2%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>                            
                            <TD class=tableHeader width="20%"><bean:message  key="Payroll.IntRates.amtFrom" /></TD>
                            <TD class=tableHeader width="20%"><bean:message  key="Payroll.IntRates.amtTo" /></td>
                            <TD class=tableHeader width="20%"><bean:message  key="Payroll.IntRates.intRate" /></TD>                           
                          </TR>
                       
                          <logic:iterate id="intRate" name="frmMaintIntRates" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.IntRateDetailBean" >
                              <% ++i; %>
                                <logic:notEqual name="intRate" property="status" value="D" >                                                        
                          
                           <tr>  <% ++j; %>
                           <td align="center"><html:checkbox property="checked" onclick="checkRecord()"/></td>
                              <td ><html:text property="startField" name="intRate" styleClass="required"  style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" readonly="true" /></td>
                              <logic:equal name="intRate" property="status" value="N">
                              <td ><html:text property="endField" styleClass="required" maxlength="12"  name="intRate" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " onchange="changed(this.alt)" onblur="checkEndRate(this.alt);" /></td>
                              <td ><html:text property="txtIntRate" styleClass="required"  name="intRate" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onkeypress="if(((event.keyCode < 48 && event.keyCode!=46) || event.keyCode > 57)){ return false;}; " onchange="if(lfnChange(this,2)){changed(this.alt);}"  /></td>
                              </logic:equal>
                              <logic:notEqual name="intRate" property="status" value="N">
                              <td ><html:text property="endField" styleClass="required" maxlength="12" readonly="true" name="intRate" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>"  onchange="if(lfnChange(this,1)){changed(this.alt);if(checkEndField(this.alt)){changeDtlStartField('startField','endField',this.alt,'0');}}" /></td>
                              <td ><html:text property="txtIntRate" styleClass="required"  name="intRate" readonly="true" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onkeypress="if(((event.keyCode < 48 && event.keyCode!=46) || event.keyCode > 57)){ return false;}; " onchange="if(lfnChange(this,2)){changed(this.alt);}"  /></td>
                              </logic:notEqual>
                              <html:hidden property="txtYearMonth" name="intRate" />
                              <html:hidden property="txtPenalty" name="intRate" />
                              <html:hidden property="txtConcession" name="intRate" />
                              <html:hidden property="txtSerialNo" name="intRate" />
                              <html:hidden property="itemChecked" name="intRate" />
                              <html:hidden property="status" name="intRate" />
                              <html:hidden property="detailId" name="intRate" />
                          </tr>  
                        </logic:notEqual>
                        <logic:equal name="intRate" property="status" value="D" >
                           <tr>
                            <% ++j; %>
                              <td align="center"><html:hidden property="checked" value="notchecked" /></td>                             
                              <td ><html:hidden property="txtIntRate" name="intRate"  /></td>                            
                              <td ><html:hidden property="startField" name="intRate"  /></td>
                              <td ><html:hidden property="endField" name="intRate"  /></td>
                              <html:hidden property="txtYearMonth" name="intRate" />
                              <html:hidden property="txtPenalty" name="intRate" />
                              <html:hidden property="txtConcession" name="intRate" />
                              <html:hidden property="txtSerialNo" name="intRate" />                              
                              <html:hidden property="itemChecked" name="intRate" />
                              <html:hidden property="status" name="intRate"/>
                              <html:hidden property="detailId" name="intRate" />
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
           <td align=center bgcolor=#4682b4 width="40%"></td>
  <!--     <td  bgcolor=#4682b4><html:button value='Approve'  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Reject '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Revise '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /></td>  -->
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
<html:hidden property="totalDetailRecord" name="frmMaintIntRates" />
<html:hidden property="screenMode" name="frmMaintIntRates" />
<html:hidden name="frmMaintIntRates"  property="screenName" value="IntRateScreen" />
<html:hidden name="frmMaintIntRates"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmMaintIntRates" />
<html:hidden property="userPositionRequested" name="frmMaintIntRates" />
<html:hidden property="pageRequested" name="frmMaintIntRates" />
<html:hidden property="userPageRequested" name="frmMaintIntRates" />
<html:hidden property="hdnHeaderFlag" name="frmMaintIntRates" />

<html:hidden property="lovKey" name="frmMaintIntRates"  />
<html:hidden property="txtFields" name="frmMaintIntRates"  />   
<html:hidden property="txtSearchFields" name="frmMaintIntRates"  />
<html:hidden property="txtDisplayFields" name="frmMaintIntRates"  />
<html:hidden property="txtIndex" name="frmMaintIntRates"  />
<html:hidden property="buttonFlag" name="frmMaintIntRates"  />
<html:hidden property="flag" name="frmMaintIntRates"  />

</html:form>
</body>
</html:html>

<script>
function lfnLoad()
{
  mode=document.all.screenMode.value;  
  menuHandling(mode);   
  if(mode=='')
  {
    doQueryMode();
  }
  if(mode=='N')
  {
    document.all.butGetDetail.disabled="true";
  }
  if(mode=='Q')
  {
    document.all.butInsert.disabled="disabled";
  }
  flag = document.all.flag.value;
  //alert(flag);
 if(mode=='U')
  {    
   if(flag == 'false')
    {
      document.all.butGetDetail.disabled="";
      if(document.all.dateTo.value=='')
      {
        document.all.butInsert.disabled="";
        document.all.butToDate.disabled="";
      }else
      {
        document.all.butInsert.disabled="true";
        document.all.butToDate.disabled="true";
      }      
      document.all.butDelete.disabled="true";
    }
    else
    {
      document.all.butGetDetail.disabled="true";
      if(document.all.dateTo.value=='')
      {
        document.all.butInsert.disabled="";
        document.all.butToDate.disabled="";
      }else
      {
        document.all.butInsert.disabled="true";
        document.all.butToDate.disabled="true";
      }      
      document.all.butDelete.disabled="true";
    } 
      
   //document.all.butGetDetail.disabled="true";
    document.all.butLoanType.disabled="true";
    document.all.loanIntType.disabled="true";
    document.all.butFromDate.disabled="true";
    document.all.butLoanType.src='../INCLUDES/IMAGES/lov_dis.jpg';
  }

  //menuHandling(mode);
  
  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
   {
     return;
   }
   var iTr2 = oTable.rows.length;
   var i = 0;
   
    checkAddRow(document.all.loanIntType.value);
   
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

function doQueryMode()
{
  document.all.loanHdrDesc.value="";
  frmMaintIntRates.flag.value = "false";
  frmMaintIntRates.action="../../../IntRateQueryMode.do"
  frmMaintIntRates.submit();
}

function GetDetail()
{
  if(mandatory_Check("frmMaintIntRates"))
  {
      frmMaintIntRates.flag.value = "true";
      frmMaintIntRates.screenMode.value = "U";
      frmMaintIntRates.action="../../../IntRateFirstGetDetailAction.do"
      frmMaintIntRates.submit();
  }
}

function getHeaderRecord()
{
  frmMaintIntRates.flag.value = "false";  
  document.all.butExecute.disabled="true";
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
  frmMaintIntRates.action="../../../IntRateFirstGetHeaderAction.do";
  frmMaintIntRates.submit();
}

function doGetNextHeader()
{ 
    frmMaintIntRates.flag.value = "false";
    frmMaintIntRates.userPositionRequested.value = 1*(frmMaintIntRates.positionRequested.value) + 1;  
    frmMaintIntRates.action="../../../IntRateGetNextHeader.do";
    frmMaintIntRates.submit();
}

function PrevHeader()
{
  frmMaintIntRates.flag.value = "false";
  frmMaintIntRates.userPositionRequested.value = frmMaintIntRates.positionRequested.value - 1;
  frmMaintIntRates.action = "../../../IntRateGetNextHeader.do";
  frmMaintIntRates.submit();
}

function JumpHeader()
{
  frmMaintIntRates.flag.value = "false";
  frmMaintIntRates.userPositionRequested.value = 1*frmMaintIntRates.newPositionRequested.value;
  frmMaintIntRates.action = "../../../IntRateGetNextHeader.do";
  frmMaintIntRates.submit();
}

function ShowLovLoan()
{
   frmMaintIntRates.lovKey.value = "IntRateLoanType" + frmMaintIntRates.screenName.value + frmMaintIntRates.screenMode.value; 
   frmMaintIntRates.txtDisplayFields.value = "headerPrimaryKey,loanHdrDesc";   
   frmMaintIntRates.txtSearchFields.value = "";
   frmMaintIntRates.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintIntRates');
   return true;
}

function ShowLovLoanDtl(i)
{
   if(document.all.headerPrimaryKey.value !='')
      return false;
   frmMaintIntRates.lovKey.value = "IntRateLoanType" + frmMaintIntRates.screenName.value + "N";
   frmMaintIntRates.txtDisplayFields.value = "loanType,loanDesc";   
   frmMaintIntRates.txtSearchFields.value = "";
   frmMaintIntRates.txtIndex.value =i-1;      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintIntRates');
   return true;
}

function changed(val)
{ 
  frmMaintIntRates.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
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

function doBaseAddRow()
{  
    if(mandatory_Check("frmMaintIntRates"))
    {
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;
        EnableFields();
        document.all.buttonFlag.value='D';
        document.forms[0].action = "../../../intRateAddRowAction.do";
        document.forms[0].submit();
    }
    else
    {
        return false;
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
  var strRecList="";
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("txtSerialNo")[i].value=="" )
        document.getElementsByName("itemChecked")[i].value = "Y";
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
   
  EnableFields();
  document.forms[0].action = "../../../intRateDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintIntRates"))
  {
      var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
      var iTr2 = oTable.rows.length;     
      var i = 0;
      if(document.all.loanIntType.value!='N')
      {
        if(iTr2>1)
        {
          frmMaintIntRates.detailDataChanged.value = "true";
        }else
        {
          alert("Please enter at least one detail row");
          return false;
        }
        
      }
      frmMaintIntRates.headerFields.value = "true";
      frmMaintIntRates.totalDetailRecord.value = parseInt(iTr2)-1; 
      frmMaintIntRates.buttonFlag.value='';    
    //  frmMaintIntRates.screenMode.value='U';
      frmMaintIntRates.headerDataChanged.value = "true";  
      EnableFields();
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintIntRates.action = "../../../IntRateSaveAction.do";      
      frmMaintIntRates.submit();
  }
  else
  {
    return false;
  }
}

function doInsertMode()
{
  document.all.buttonFlag.value='';
  frmMaintIntRates.action="../../../IntRateNewMode.do"
  frmMaintIntRates.submit();
}

function lfnChange(that, temp)
{
  if(temp==1)
  {
    if(num_Check(that.value,1))
    {
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
  else
  {        
    if(validate_Float(that.value,6,2))
    {
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

function calMonths(mon)
{
  month = 0;
  if(mon == 'Jan')
  {
    month = 1;
  }
  if(mon == 'Feb')
  {
    month = 2;
  }
  if(mon == 'Mar')
  {
    month = 3;
  }
  if(mon == 'Apr')
  {
    month = 4;
  }
  if(mon == 'May')
  {
    month = 5;
  }
  if(mon == 'Jun')
  {
    month = 6;
  }
  if(mon == 'Jul')
  {
    month = 7;
  }
  if(mon == 'Aug')
  {
    month = 8;
  }
  if(mon == 'Sep')
  {
    month = 9;
  }
  if(mon == 'Oct')
  {
    month = 10;
  }
  if(mon == 'Nov')
  {
    month = 11;
  }
  if(mon == 'Dec')
  {
    month = 12;
  }
  return month;
}

function checkDates()
{
  var fromDt=document.all.dateFrom.value;
  var toDt=document.all.dateTo.value; 
 /* if(!cmpSysDate(toDt,0))
    { 
      document.getElementsByName("txtTo")[i-1].value="";
      return false;
    }
 */
  if (!cmpDate(fromDt,toDt,0))
  {
    alert("To Date cannot be less than From Date");
    document.all.dateTo.value="";
    return false;                      
  }
 // changed(i);
}

function onChangeIntRateType()
{  
  var mode;
  mode= document.all.screenMode.value; 
  if(mode == 'N' && document.all.loanIntType.value=='N')
  {
    //frmMaintIntRates.headerDataChanged.value = "true";
    //frmMaintIntRates.detailDataChanged.value = "true";
    document.all.butGetDetail.disabled="true";
    document.all.butInsert.disabled="true";
    document.all.butDelete.disabled="true";    
  }
  else
  {
    document.all.butGetDetail.disabled="true";
    document.all.butInsert.disabled="";
    document.all.butDelete.disabled="";    
  }
       
}

function doRefresh()
{  
  document.all.buttonFlag.value='';
  frmMaintIntRates.action="../../../IntRateRefresh.do"
  frmMaintIntRates.submit();
}

function doBasePrevDetail()
{
    frmMaintIntRates.userPageRequested.value = 1*frmMaintIntRates.pageRequested.value - 1;
    frmMaintIntRates.action = "../../../IntRateNextDetailAction.do";
    frmMaintIntRates.submit();
}


function doBaseNextDetail()
{
    frmMaintIntRates.userPageRequested.value = 1*frmMaintIntRates.pageRequested.value + 1;
    frmMaintIntRates.action = "../../../IntRateNextDetailAction.do";
    frmMaintIntRates.submit();
}

function JumpDetail()
{
    frmMaintIntRates.userPageRequested.value = 1*frmMaintIntRates.newPageRequested.value ;
    frmMaintIntRates.action = "../../../IntRateNextDetailAction.do";
    frmMaintIntRates.submit();
}

function checkIntType(ind)
{
  if(document.getElementsByName("loanIntType")[ind-1].value=='N')
  {
    document.getElementsByName("txtIntRate")[ind-1].disabled="true";
  }
  else
  {
    document.getElementsByName("txtIntRate")[ind-1].disabled="";
  }
}

function EnableFields()
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
       // document.getElementsByName("loanIntType")[i].disabled="";
        document.getElementsByName("txtIntRate")[i].disabled="";
    }
}

function checkAddRow(val)
{   
    //alert(val);
    if(val=='N')
    {
        document.all.butGetDetail.disabled="true";
        document.all.butInsert.disabled="true";
        document.all.butDelete.disabled="true";    
    }
    else
    {
        if(document.all.dateTo.value=='')
          document.all.butInsert.disabled="";
        else
          document.all.butInsert.disabled="true";
       // document.all.butGetDetail.disabled="";
    }
}

function checkEndRate(i)
{
  if(parseInt(document.getElementsByName("startField")[i-1].value,10) >parseInt(document.getElementsByName("endField")[i-1].value,10))
  {
    alert("Amount From cannot be greater than Amount To");
    document.getElementsByName("endField")[i-1].value="";
    return false;
    
  }
}
</script>
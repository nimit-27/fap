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
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css"/>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
</head>
  <BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="LeaveTravelConcession" name="frmLeaveTravelConcession" type="FCIPAY.Payroll.WEBTIER.Form.LeaveTravelConcessionForm">
  <bean:define id="ParentForm" name="frmLeaveTravelConcession" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>Leave Travel Concession (LTC)</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
</table>
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
      <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0/></TD>
    </TR> 
    
    <TR>
      <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
      <td align="left" >
      <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();"/>
      </td>  
      
      <td class=labelText  >Employee Name </td>
      <td>                             
      <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
      </td>
    </TR> 
    <TR>              
      <TD width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
      <td align="left">
      <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>
      </td>
      
      <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
      <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/></td>                  
    </TR>              
    <tr>
      <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
      <td>
      <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                  
      </td> 
      
      <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
      <td>
      <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" readonly="true" maxlength="7" size="23" styleClass="locked" onkeypress="
       if((event.keyCode < 48 || event.keyCode > 57))
        {
          return false;
        };                            
              lfnChanged(this.value);
         "  style="text-align:right"   /></td>                                                                  
    </tr>                  
    <tr>
      <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
      <td>
      <html:text  property="txtPresentPOPDesc" altKey="Payroll.EmpInfo.PresentPOP" maxlength="10" size="23" styleClass="locked" readonly="true"/>
      </td>
      
      <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
      <td>
      <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" styleClass="locked" readonly="true"/>
      </td>
    </tr>   
    <tr>
      <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
      <td ><html:text property="txtEmpStatus" name="frmLeaveTravelConcession" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23"  onchange="return changed(this.alt)" />
      </td>             
      <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.curbas" /> </td>                            
      <td ><html:text property="txtCurrBas" name="frmLeaveTravelConcession" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23" onchange="return changed(this.alt)" />
      </td>
    </tr>
 </table>

<table cellspacing=0 cellpadding=0 border=0 >
<!-- Detail Information Row starts -->
<TR height="200">
<TD colspan=6>
<!-- Purchase Requisition Info Table Starts -->
<TABLE cellSpacing=0 cellPadding=0 border = 0 >
   <TR>          
       <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"/></td>
        <td bgcolor="#4682B4" nowrap class=actTabText> Leave Travel Concession (LTC) Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"/></td>
        <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"/></td>                  
        <td background="../INCLUDES/IMAGES/line_t.gif" width="85%">&nbsp;</td>
  </tr> 
<tr height="10"><td class=userText colspan="17"></td></tr>            
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
             <tr>
              <td width="15%" class=labelText>Application Date</td>
              <td width="10%"><html:text  property="txtApplnDt" disabled="true" readonly="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="21" onchange="chkApplnDt()" />
              <logic:equal name="frmLeaveTravelConcession" property="screenMode" value="N">
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtApplnDt" alt="<%=(i-1) %>" onclick="showCalendar('txtApplnDt',this)" />
              </logic:equal>
              </td>

            
             <td width="10%" class=labelText align="left">Sanction No</td>
            <logic:notEqual name="frmLeaveTravelConcession" property="screenMode" value="U">
                <td><html:text property="txtSnctnNo" styleClass ="required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23"/></td>
            </logic:notEqual>
            <logic:equal name="frmLeaveTravelConcession" property="screenMode" value="U">
                <td><html:text property="txtSnctnNo" readonly="true" styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23"/></td>
            </logic:equal>
             <td  width="10%" class=labelText>Sanction Date</td>
              <td ><html:text  property="txtSnctnDt"  disabled="true" readonly="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="chkSanctionDt()" />
              <logic:equal name="frmLeaveTravelConcession" property="screenMode" value="N">
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtSnctnDt" alt="<%=(i-1) %>" onclick="showCalendar('txtSnctnDt',this)"/>
              </logic:equal>
               </td>
               
               <td  width="10%" class=labelText align="left" >Block Year</td>
              <td ><html:text  property="txtYYYY" styleClass = "locked" readonly="true" maxlength="10" size="23"  /></td>                                                                       
             </tr>

           <tr>
              <td  width="10%" class=labelText >LTC Type</td>                              
              <td>
              <logic:notEqual name="frmLeaveTravelConcession" property="screenMode" value="U">
                  <html:select property="txtLTCType" alt="txtPayModeType" titleKey="" styleClass="required" >
                  <html:option value="Bharat Darshan" >&nbsp;&nbsp; <bean:message key="Payroll.OthrPayment.LTC.Bharat" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html:option>
                  <html:option value="Home Town" >&nbsp;&nbsp; <bean:message key="Payroll.OthrPayment.LTC.HomeTown" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html:option>
                  </html:select>
              </logic:notEqual>
              <logic:equal name="frmLeaveTravelConcession" property="screenMode" value="U">
                  <html:select property="txtLTCType" alt="txtPayModeType" titleKey="" styleClass="locked" readonly="true">
                  <html:option value="Bharat Darshan" >&nbsp;&nbsp; <bean:message key="Payroll.OthrPayment.LTC.Bharat" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html:option>
                  <html:option value="Home Town" >&nbsp;&nbsp; <bean:message key="Payroll.OthrPayment.LTC.HomeTown" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html:option>
                  </html:select>
              </logic:equal>
              </td>

              <td  width="10%" class=labelText>Travel Date</td>
              <td ><html:text  property="txtTravelDt" readonly="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="chkSanctionDt()" />
              <logic:equal name="frmLeaveTravelConcession" property="screenMode" value="N">
              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtTravelDt" alt="<%=(i-1) %>" onclick="showCalendar('txtTravelDt',this)"/>
              </logic:equal>
              </td>
              <td  width="10%" class=labelText>Ticket Amount</td>
              <logic:notEqual name="frmLeaveTravelConcession" property="screenMode" value="U">
                <td><html:text property="txtTicketAmount" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="calcAmt()"/></td>
              </logic:notEqual>
              <logic:equal name="frmLeaveTravelConcession" property="screenMode" value="U">
                <td><html:text property="txtTicketAmount" readonly="true" styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="calcAmt()"/></td>
              </logic:equal>
              
              <td  width="10%" class=labelText align="left" >IT Deductions</td> 
              <logic:notEqual name="frmLeaveTravelConcession" property="txtInvId" value=" ">
              <td><html:text  property="txtDedIT" disabled="true" styleClass = "optional"  altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" 
              onchange="calITDeduction()" /></td>   
              </logic:notEqual>
              <logic:equal name="frmLeaveTravelConcession" property="txtInvId" value=" ">
              <td><html:text  property="txtDedIT" disabled="true" styleClass = "locked"  readonly="true" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" 
              onchange="calITDeduction()" /></td> 
              </logic:equal>
              <html:hidden property="txtDedOthr" name="frmLeaveTravelConcession"  /> 
           </tr>
           <tr>                              
               <td class=labelText width="10%" >Remarks</td>                              
              <td ><html:textarea  property="txtRmrks" disabled="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermState" cols="27" /></td>                                                                                                    
              <td  width="10%" class=labelText align="left" >Net Amount Payable</td>
              <td ><html:text  property="txtNetAmt" disabled="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" /></td>                                                                       
              <html:hidden property="txtPayModeType" value="NA" />
              <td  width="10%" class=labelText align="left" >Invoice Number</td>
              <td ><html:text  property="txtInvId" readonly="true" styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" /></td>                                                                       
           </tr>
                                      
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
  <TR>
    <td align=center bgcolor=#4682b4 width="40%"></td>
    <td  bgcolor=#4682b4>
     <logic:equal name="frmLeaveTravelConcession" property="screenMode" value="U" >
      <logic:equal name="frmLeaveTravelConcession" property="txtInvId" value="" >
        <html:button value="Send Invoice" property="butInv" onclick="sendInv()" />
        <!--<html:button value="Cancel Invoice" property="butInv" disabled="true" />
        <html:button value="Delete Record" property="butInv" onclick="DelRecord()"  />-->
      </logic:equal>
      <logic:notEqual name="frmLeaveTravelConcession" property="txtInvId" value="" >
        <html:button value="Send Invoice" property="butInv" disabled="true" />
        <!--<html:button value="Cancel Invoice" property="butInv" onclick="cancelInv()" />
        <html:button value="Delete Record" property="butInv" onclick="DelRecord()" disabled="true" />-->
      </logic:notEqual>
    </logic:equal>
    </td>
    <td bgColor=#4682b4></td>
    <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"/></td>
  </TR>
  
</TABLE> 
<!-- Container Table Ending Columns Starts-->
</TD>    
</TR>
</TBODY>
</TABLE>
</div>

<!-- Container Table Ends -->
<html:hidden name="frmLeaveTravelConcession"  property="screenName" value="LeaveTravelConcessionScreen" />
<html:hidden property="loginLocCode" name="frmLeaveTravelConcession"  />
<html:hidden name="frmLeaveTravelConcession"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmLeaveTravelConcession" />
<html:hidden property="positionRequested" name="frmLeaveTravelConcession" />
<html:hidden property="userPositionRequested" name="frmLeaveTravelConcession" />
<html:hidden property="buttonFlag" name="frmLeaveTravelConcession"  />
<html:hidden property="lovKey" name="frmLeaveTravelConcession"  />
<html:hidden property="txtFields" name="frmLeaveTravelConcession"  />   
<html:hidden property="txtSearchFields" name="frmLeaveTravelConcession"  />
<html:hidden property="txtDisplayFields" name="frmLeaveTravelConcession"  />
<html:hidden property="txtIndex" name="frmLeaveTravelConcession"  />
<html:hidden property="hdnFlagIT" name="frmLeaveTravelConcession"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>


<script language="javascript">

function checkTravelPlace(val){

if(val == 'OTHER'){
    document.all.txtOtherTravelPlace.style.display = "";
    document.all.txtOtherTravelPlace.disabled="";
}else{
    document.all.txtOtherTravelPlace.value="";
    document.all.txtOtherTravelPlace.style.display = "none";
    document.all.txtOtherTravelPlace.disabled="true";
}
}

function checkTravelMode(val){

if(val == 'OTHER'){
    document.all.txtOtherTravelMode.style.display = "";
    document.all.txtOtherTravelMode.disabled="";
}else{
    document.all.txtOtherTravelMode.value="";
    document.all.txtOtherTravelMode.style.display = "none";
    document.all.txtOtherTravelMode.disabled="true";
}
}

function ShowEmpNum()
{
   frmLeaveTravelConcession.lovKey.value = "LeaveTravelConcessionEmp" + frmLeaveTravelConcession.screenName.value + frmLeaveTravelConcession.screenMode.value;
   frmLeaveTravelConcession.queryParam.value="txtSiteID="+ frmLeaveTravelConcession.loginLocCode.value +",hdnEmpLbrFlag="+ frmLeaveTravelConcession.hdnEmpLbrFlag.value ;
   if(frmLeaveTravelConcession.screenMode.value == 'N')
   {
      frmLeaveTravelConcession.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOPDesc,txtDOJSite,txtEmpStatus,txtCurrBas";
      // frmLeaveEncashForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
       frmLeaveTravelConcession.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
       frmLeaveTravelConcession.txtIndex.value ="";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLeaveTravelConcession');
   }
   if(frmLeaveTravelConcession.screenMode.value == 'Q')
   {
     frmLeaveTravelConcession.txtDisplayFields.value = "txtEmpNo,txtEmpName";
     frmLeaveTravelConcession.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
     frmLeaveTravelConcession.txtIndex.value ="";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLeaveTravelConcession');
   }
   
   return true;
}    

function lfnLoad()
{   
    mode = document.all.screenMode.value;
	
    if(mode == '')
    {
        doQueryMode();
    }
    
    if(document.all.txtInvId.value=='')
    {        
       // getBlockYr();
        document.all.txtApplnDt.disabled = "";
        document.all.txtSnctnDt.disabled = "";
        document.all.txtTicketAmount.disabled = "";
        document.all.txtRmrks.disabled = "";
		document.all.txtDedIT.disabled = "";
        if(document.all.hdnFlagIT.value=='N')
        {
          document.all.txtDedIT.disabled = "";
        }
        document.all.txtLTCType.disabled = "";
        document.all.txtPayModeType.disabled = "";
    }
    
    hedMenuHandling(mode);
    disableInsert();
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmLeaveTravelConcession"))
    {     
    var answer = confirm("Have you verified all the data including Income Tax.Press OK to save the record!!!!")
    if (!answer){
        return false;
    }

    if(document.all.txtNetAmt.value == 0){
          alert("Net Amount Payable can't be 0");
          return false;
    }

    if( document.all.txtDedIT.value != 0 ){
        calcNetAmntPayble();
        var itDed=document.all.txtDedIT.value;
        var checkDed=parseInt(document.all.txtTicketAmount.value-itDed);
        alert("Net Payable Amount is "+checkDed+"\n Click Ok to continue");
        if(checkDed != document.all.txtNetAmt.value){
        alert("Please check your calculation it is not correct");
        return false;
    }
}

    frmLeaveTravelConcession.detailDataChanged.value = "false";  
   // if(frmLeaveTravelConcession.screenMode.value == "N")
    frmLeaveTravelConcession.headerDataChanged.value = "true";      
    frmLeaveTravelConcession.headerFields.value = "true";
    document.all.txtNetAmt.disabled="";
    document.all.txtDedIT.disabled="";
    document.all.butSave.disabled="true";
    document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmLeaveTravelConcession.action = "../../../LeaveTravelConcessionSaveAction.do";  
    
    frmLeaveTravelConcession.submit();
    }
    else
    {
        return false;
    }
}

function lfnChanged(val)
{
    frmLeaveTravelConcession.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    frmLeaveTravelConcession.action="../../../LeaveTravelConcessionFirstGetHeaderAction.do"
    frmLeaveTravelConcession.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmLeaveTravelConcession.userPositionRequested.value = 1*frmLeaveTravelConcession.positionRequested.value + 1;
    frmLeaveTravelConcession.action="../../../LeaveTravelConcessionGetNextHeader.do";
    frmLeaveTravelConcession.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmLeaveTravelConcession.userPositionRequested.value = 1*frmLeaveTravelConcession.positionRequested.value - 1;
    frmLeaveTravelConcession.action = "../../../LeaveTravelConcessionGetNextHeader.do";
    frmLeaveTravelConcession.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmLeaveTravelConcession.userPositionRequested.value = 1*frmLeaveTravelConcession.newPositionRequested.value;
    frmLeaveTravelConcession.action = "../../../LeaveTravelConcessionGetNextHeader.do";
    frmLeaveTravelConcession.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmLeaveTravelConcession.action="../../../LeaveTravelConcessionNewMode.do"
    frmLeaveTravelConcession.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmLeaveTravelConcession.action="../../../LeaveTravelConcessionQueryMode.do"
    frmLeaveTravelConcession.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmLeaveTravelConcession.action="../../../LeaveTravelConcessionRefresh.do"
    frmLeaveTravelConcession.submit();
}

function calcAmt()
{	
        if(parseInt(document.all.txtDedIT.value) >= parseInt(document.all.txtTicketAmount.value))
            {
              alert('Deduction amount should not be greater than or equal to Ticket Amount'); 
              document.all.txtDedIT.value=0;
           }
        var itDed=document.all.txtDedIT.value==""?"0":document.all.txtDedIT.value;
        var othrDed=document.all.txtDedOthr.value==""?"0":document.all.txtDedOthr.value;
        document.all.txtNetAmt.value=parseInt(document.all.txtTicketAmount.value)-parseInt(itDed)-parseInt(othrDed);
        document.all.txtNetAmt.disabled="";
        document.all.txtDedIT.disabled="";
        
        frmLeaveTravelConcession.action="../../../LeaveTravelConcessionCalcITDed.do"
        frmLeaveTravelConcession.submit();
}

function calcNetAmntPayble()
{
  var itDed=document.all.txtDedIT.value==""?"0":document.all.txtDedIT.value;
  var othrDed=document.all.txtDedOthr.value==""?"0":document.all.txtDedOthr.value;
  document.all.txtNetAmt.value=parseInt(document.all.txtTicketAmount.value)-parseInt(itDed)-parseInt(othrDed);  
}

function getBlockYr()
{
  var len=document.all.txtApplnDt.value.length;
  var currYr=(document.all.txtApplnDt.value).substring((len-4));
  blocIndx=parseInt((currYr-2002)/4,10);
  var starYr=2002+4*blocIndx;
  endYr=starYr+3;
  document.all.txtYYYY.value=starYr+"-"+endYr;
}

function chkSanctionDt()
{
  var sanctionDt=document.all.txtSnctnDt.value;
  var applnDt=document.all.txtApplnDt.value;
 
  if(!cmpSysDate(sanctionDt,0))
    { 
      document.all.txtSnctnDt.value="";
      return false;
    }
  if(!cmpDate(applnDt,sanctionDt,0))
  {
    alert("Application Date cannot be greater than Sanction Date");
    document.all.txtSnctnDt.value="";
    return false;
  }
}

function chkApplnDt()
{
  var applnDt=document.all.txtApplnDt.value;
 
  if(!cmpSysDate(applnDt,0))
    { 
      document.all.txtApplnDt.value="";
      return false;
    }
  getBlockYr();
}

function sendInv()
{
      if(document.all.txtEmpNo.value=='')
  {
    alert("Please Select a record first!!");
    return false;
  }
  document.getElementById("butInv").disabled="true";
  frmLeaveTravelConcession.action="../../../LeaveTravelConcessionSendInv.do"
  frmLeaveTravelConcession.submit();
}

function DelRecord()
{ 
	
  if(document.all.txtEmpNo.value=='')
  {
    alert("Please Select a record first!!");
    return false;
  }
  if(document.all.txtInvId.value!='')
  {
    alert("Invoice created. Record cannot be deleted now ");
    return false;  
  }
  document.all.txtInvId.value='  ';
  frmLeaveTravelConcession.action="../../../LeaveTravelConcessionDelRecord.do?param1=ltConcession"
  frmLeaveTravelConcession.submit();
}

function cancelInv()
{ 
	
  if(document.all.txtEmpNo.value=='')
  {
    alert("Please Select a record first!!");
    return false;
  }
  if(document.all.txtInvId.value=='')
  {
    alert("Invoice not created.");
    return false;  
  }
  if(confirm("Do you want to cancel Invoice")){
   document.getElementById("butInv").disabled="true";
  frmLeaveTravelConcession.action="../../../LeaveTravelConcessionCancelInv.do"
  
  frmLeaveTravelConcession.submit();
 } 
}

function calITDeduction()
{ 
    if(parseInt(document.all.txtDedIT.value) >= parseInt(document.all.txtTicketAmount.value))
      {
          alert('Deduction cannot be greater than or equal to Ticket Amount'); 
                  document.all.txtDedIT.value=0;
          return false;
      }
     else calcNetAmntPayble();
}
function disableInsert() {
    lockField("butInsertMode");
    document.all.butInsertMode.src = "../INCLUDES/IMAGES/insert_dis.jpg";
}
function lockField(id) {
    var el = document.getElementById(id);
    if (!el) return;
    el.disabled = true;
    el.readOnly = true;
    el.style.background = "#e0e0e0";
    el.className = "locked";
}
</script>
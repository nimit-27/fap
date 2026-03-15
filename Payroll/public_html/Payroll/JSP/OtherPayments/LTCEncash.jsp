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
  <BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintLTCEncash" name="frmLTCEncashForm" type="FCIPAY.Payroll.WEBTIER.Form.LTCEncashForm">
  <bean:define id="ParentForm" name="frmLTCEncashForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>LTC ENCASHMENT</TD>
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
                  <html:text  property="txtEmpNo" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
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
                                    
              </tr>
                      
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
                  <td ><html:text property="txtEmpStatus" name="frmLTCEncashForm" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23"  onchange="return changed(this.alt)" />
                  </td>             
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.curbas" /> </td>                            
                  <td ><html:text property="txtCurrBas" name="frmLTCEncashForm" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23" onchange="return changed(this.alt)" />
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
                    <td bgcolor="#4682B4" nowrap class=actTabText> Encashment Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                             <tr>
                             <td  width="15%" class=labelText>Application Date</td>
                              <td ><html:text  property="txtApplnDt"  disabled="true" readonly="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="chkApplnDt()" />
                              <logic:equal name="frmLTCEncashForm" property="screenMode" value="N">
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtApplnDt" alt="<%=(i-1) %>" onclick="showCalendar('txtApplnDt',this)" /></td>                                                                         
                              </logic:equal>

                             <td  width="15%" class=labelText>Sanction Date</td>
                              <td ><html:text  property="txtSnctnDt"  disabled="true" readonly="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="chkSanctionDt()" />
                              <logic:equal name="frmLTCEncashForm" property="screenMode" value="N">
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtDOJSite" alt="<%=(i-1) %>" onclick="showCalendar('txtSnctnDt',this)" /></td>                                                                         
                              </logic:equal>
                                <td  width="15%" class=labelText >LTC Type</td>                              
                              <td >
                              <html:select property="txtLTCType" disabled="true" alt="txtPayModeType" titleKey="Payroll.EmpInfo.pmodeType" styleClass="required" >
                              <html:option value="B" >&nbsp;&nbsp; <bean:message key="Payroll.OthrPayment.LTCType" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</html:option>
                              </html:select> </td>
                                                                                                  
                             </tr>

                           <tr>
                             
                              
                              <td  width="15%" class=labelText align="left" >Encashment Amount</td>
							   <logic:notEqual name="frmLTCEncashForm" property="screenMode" value="U">
                              <td ><html:text  property="txtEncshAmt" disabled="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="calcAmt()" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" /></td>                                                                       
                              </logic:notEqual>
							  <logic:equal name="frmLTCEncashForm" property="screenMode" value="U">
                              <td ><html:text  property="txtEncshAmt" disabled="true" readonly="true" styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="calcAmt()" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" /></td>                                                                       
                              </logic:equal>
							  
							 <td  width="15%" class=labelText align="left" >IT Deductions</td> 
							 <logic:notEqual name="frmLTCEncashForm" property="screenMode" value="U">
                              <td><html:text  property="txtDedIT" disabled="" styleClass = "optional"  altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" 
                              onchange="calITDeduction()" /></td>   
							 </logic:notEqual>
							 <logic:equal name="frmLTCEncashForm" property="screenMode" value="U">
							  <td><html:text  property="txtDedIT" disabled="" styleClass = ""  readonly="" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" 
                              onchange="calITDeduction()" /></td> 
							  </logic:equal>
                              <html:hidden property="txtDedOthr" name="frmLTCEncashForm"  /> 
                              
                              </tr>
                              
                             
                           <tr>                              
                               <td class=labelText width="15%" >Remarks</td>                              
                              <td ><html:textarea  property="txtRmrks" disabled="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermState" cols="27" /></td>                                                                                                    
                             
 
                              
                              <td  width="15%" class=labelText align="left" >Net Amount Payable</td>
                              <td ><html:text  property="txtNetAmt" disabled="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" /></td>                                                                       
                                <html:hidden property="txtPayModeType" />
                              
                              <td  width="15%" class=labelText align="left" >Invoice Number</td>
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
                <!-- Tab Table Ends -->
<!-- Bottom Blue Bar -->
      <TR>
        <td align=center bgcolor=#4682b4 width="40%"></td>
        <td  bgcolor=#4682b4>
         <logic:equal name="frmLTCEncashForm" property="screenMode" value="U" >
          <logic:equal name="frmLTCEncashForm" property="txtInvId" value="" >
            <html:button value="Send Invoice" property="butInv" onclick="sendInv()" />
            <html:button value="Cancel Invoice" property="butInv" disabled="true" />

			<!--added by sonia on 31-08-2011-->
        <%--<html:button value="Delete Record" property="butInv" onclick="DelRecord()"  />--%>
          </logic:equal>
          <logic:notEqual name="frmLTCEncashForm" property="txtInvId" value="" >
            <html:button value="Send Invoice" property="butInv" disabled="true" />
            <html:button value="Cancel Invoice" property="butInv" onclick="cancelInv()" />
			<!--added by sonia on 31-08-2011-->
        <%--<html:button value="Delete Record" property="butInv" onclick="DelRecord()" disabled="true" />--%>
          </logic:notEqual>
        </logic:equal>
        
        
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
<!-- Container Table Ends -->
<html:hidden name="frmLTCEncashForm"  property="screenName" value="LTCEncashScreen" />
<html:hidden property="loginLocCode" name="frmLTCEncashForm"  />
<html:hidden name="frmLTCEncashForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmLTCEncashForm" />
<html:hidden property="positionRequested" name="frmLTCEncashForm" />
<html:hidden property="userPositionRequested" name="frmLTCEncashForm" />
<html:hidden property="buttonFlag" name="frmLTCEncashForm"  />
<html:hidden property="lovKey" name="frmLTCEncashForm"  />
<html:hidden property="txtFields" name="frmLTCEncashForm"  />   
<html:hidden property="txtSearchFields" name="frmLTCEncashForm"  />
<html:hidden property="txtDisplayFields" name="frmLTCEncashForm"  />
<html:hidden property="txtIndex" name="frmLTCEncashForm"  />
<html:hidden property="hdnFlagIT" name="frmLTCEncashForm"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">
function ShowEmpNum()
{
   frmLTCEncashForm.lovKey.value = "LTCEncashEmp" + frmLTCEncashForm.screenName.value + frmLTCEncashForm.screenMode.value;
   frmLTCEncashForm.queryParam.value="txtSiteID="+ frmLTCEncashForm.loginLocCode.value +",hdnEmpLbrFlag="+ frmLTCEncashForm.hdnEmpLbrFlag.value ;
   if(frmLTCEncashForm.screenMode.value == 'N')
   {
      frmLTCEncashForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOPDesc,txtDOJSite,txtEmpStatus,txtCurrBas";
      // frmLeaveEncashForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
       frmLTCEncashForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
       frmLTCEncashForm.txtIndex.value ="";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLTCEncashForm');
   }
   if(frmLTCEncashForm.screenMode.value == 'Q')
   {
     frmLTCEncashForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
     frmLTCEncashForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
     frmLTCEncashForm.txtIndex.value ="";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLTCEncashForm');
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
        document.all.txtEncshAmt.disabled = "";
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
    //Disabling INsert Mode  and Delete Mode 
  if (frmLTCEncashForm.hdnEmpLbrFlag.value=="E"){
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    }
    disableInsert();
    if(document.all.txtInvId.value!=''){
    document.all.txtDedIT.readOnly="true";
    document.all.txtDedIT.disabled="true";
    }
}
function disableInsert(){
    //Disabling INsert Mode  and Delete Mode 
    if (frmLTCEncashForm.hdnEmpLbrFlag.value=='E'){
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butDel.disabled="true";
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
    }

}

function SaveRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmLTCEncashForm"))
    {     
		
		 var answer = confirm("Have you verified all the data including Income Tax.Press OK to save the record!!!!")
	if (!answer){
		return false;
	}

if(document.all.txtNetAmt.value == 0)
       {
          alert("Net Amount Payable can't be 0");
          return false;
          
          }

///added by sonia 

if( document.all.txtDedIT.value != 0 ){
	         calcNetAmntPayble();
			 var itDed=document.all.txtDedIT.value;
             var checkDed=parseInt(document.all.txtEncshAmt.value-itDed);
			 alert("Net Encashment Amount is "+checkDed+"\n Click Ok to continue");
				if(checkDed != document.all.txtNetAmt.value){
				alert("Please check your calculation it is not correct");
				return false;
				}
}

/////end 


        frmLTCEncashForm.detailDataChanged.value = "false";  
       // if(frmLTCEncashForm.screenMode.value == "N")
          frmLTCEncashForm.headerDataChanged.value = "true";      
        frmLTCEncashForm.headerFields.value = "true";
        document.all.txtNetAmt.disabled="";
        document.all.txtDedIT.disabled="";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmLTCEncashForm.action = "../../../LTCEncashSaveAction.do";  
        
        frmLTCEncashForm.submit();
    }
    else
    {
        return false;
    }
}

function lfnChanged(val)
{
    frmLTCEncashForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    frmLTCEncashForm.action="../../../LTCEncashFirstGetHeaderAction.do"
    frmLTCEncashForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmLTCEncashForm.userPositionRequested.value = 1*frmLTCEncashForm.positionRequested.value + 1;
    frmLTCEncashForm.action="../../../LTCEncashGetNextHeader.do";
    frmLTCEncashForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmLTCEncashForm.userPositionRequested.value = 1*frmLTCEncashForm.positionRequested.value - 1;
    frmLTCEncashForm.action = "../../../LTCEncashGetNextHeader.do";
    frmLTCEncashForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmLTCEncashForm.userPositionRequested.value = 1*frmLTCEncashForm.newPositionRequested.value;
    frmLTCEncashForm.action = "../../../LTCEncashGetNextHeader.do";
    frmLTCEncashForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmLTCEncashForm.action="../../../LTCEncashNewMode.do"
    frmLTCEncashForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmLTCEncashForm.action="../../../LTCEncashQueryMode.do"
    frmLTCEncashForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmLTCEncashForm.action="../../../LTCEncashRefresh.do"
    frmLTCEncashForm.submit();
}

function calcAmt()
{	
if(parseInt(document.all.txtDedIT.value) >= parseInt(document.all.txtEncshAmt.value))
            {
              alert('Deduction amount should not be greater than or equal to Encashment Amount'); 
              document.all.txtDedIT.value=0;
           }
        var itDed=document.all.txtDedIT.value==""?"0":document.all.txtDedIT.value;
        var othrDed=document.all.txtDedOthr.value==""?"0":document.all.txtDedOthr.value;
        document.all.txtNetAmt.value=parseInt(document.all.txtEncshAmt.value)-parseInt(itDed)-parseInt(othrDed);
        document.all.txtNetAmt.disabled="";
        document.all.txtDedIT.disabled="";
        
        frmLTCEncashForm.action="../../../LTCEncashCalcITDed.do"
        frmLTCEncashForm.submit();
}

function calcNetAmntPayble()
{
  var itDed=document.all.txtDedIT.value==""?"0":document.all.txtDedIT.value;
  var othrDed=document.all.txtDedOthr.value==""?"0":document.all.txtDedOthr.value;
  document.all.txtNetAmt.value=parseInt(document.all.txtEncshAmt.value)-parseInt(itDed)-parseInt(othrDed);  
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
  frmLTCEncashForm.action="../../../LTCEncashSendInv.do"
  frmLTCEncashForm.submit();
}

//added by sonia on 31-08-2011
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
  frmLTCEncashForm.action="../../../LTCEncashDelRecord.do?param1=ltcencash"
  frmLTCEncashForm.submit();
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
  frmLTCEncashForm.action="../../../LTCEncashCancelInv.do"
  
  frmLTCEncashForm.submit();
 } 
}

function calITDeduction()
{ 
if(document.all.txtInvId.value!='')
  {
    alert("Invoice already Sent Cannot Update the Value.");
    return false;  
  }    
  if(parseInt(document.all.txtDedIT.value) >= parseInt(document.all.txtEncshAmt.value))
      {
          alert('Deduction cannot be greater than or equal to Encashment Amount'); 
		  document.all.txtDedIT.value=0;
          return false;
      }
     else calcNetAmntPayble();
}
//end
</script>
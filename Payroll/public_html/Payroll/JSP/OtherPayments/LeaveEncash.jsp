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
  <html:form  action="MaintLeaveEncash" name="frmLeaveEncashForm" type="FCIPAY.Payroll.WEBTIER.Form.LeaveEncashForm">
  <bean:define id="ParentForm" name="frmLeaveEncashForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>LEAVE ENCASHMENT</TD>
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
                  <td ><html:text property="txtEmpStatus" name="frmLeaveEncashForm" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23"  onchange="return changed(this.alt)" />
                  </td>             
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.curbas" /> </td>                            
                  <td ><html:text property="txtCurrBas" name="frmLeaveEncashForm" readonly="true" styleClass="locked" alt="<%=String.valueOf(i)%>" size="23" onchange="return changed(this.alt)" />
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
                            <TR>       
                              <td  width="15%" class=labelText>Application Date</td>
							   <logic:equal name="frmLeaveEncashForm" property="screenMode" value="U" >
                              <td ><html:text  property="txtApplnDt" disabled="true" readonly="true" styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="getData()" />
                             </logic:equal>
							 
							 
							 <logic:notEqual name="frmLeaveEncashForm" property="screenMode" value="U" >
							  <td ><html:text  property="txtApplnDt" disabled="true" readonly="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="getData()" />
							 <logic:equal name="frmLeaveEncashForm" property="txtInvId" value="">
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtDOJSite" alt="<%=(i-1) %>" onclick="showCalendar('txtApplnDt',this)" /></td>                                                                         
                              </logic:equal>
							  
							 </logic:notEqual>
		
                              <td  width="15%" class=labelText>Sanctioned ELs</td>    
								<logic:notEqual name="frmLeaveEncashForm" property="screenMode" value="U" >
                              <td ><html:text  property="txtEL" disabled="true" styleId = "elSantion" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="3" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" size="23" onchange="calcAmt()" /></td>                                                                       
								 </logic:notEqual>
								  <logic:equal name="frmLeaveEncashForm" property="screenMode" value="U" >
					 <td ><html:text  property="txtEL" disabled="true" styleId = "elSantion" readonly="true" styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="3" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" size="23" onchange="calcAmt()" /></td>                                                                       
								</logic:equal>
                            </tr>
                            
                             <tr>
                             <td  width="15%" class=labelText>Sanction Date</td>
							  <logic:equal name="frmLeaveEncashForm" property="screenMode" value="U" >
                              <td ><html:text  property="txtSnctnDt"  disabled="true" readonly="true" styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="chkSanctionDt()" />
                               </logic:equal>
							   
							   <logic:notEqual name="frmLeaveEncashForm" property="screenMode" value="U" >
							   <td ><html:text  property="txtSnctnDt"  disabled="true" readonly="true" styleClass = "required" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="chkSanctionDt()" />
							  <logic:equal name="frmLeaveEncashForm" property="txtInvId" value="">
                              <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="txtDOJSite" alt="<%=(i-1) %>" onclick="showCalendar('txtSnctnDt',this)" /></td>                                                                         
                              </logic:equal>
                               </logic:notEqual>
							  
                              <td  width="15%" class=labelText align="left">Encashment Amount</td>
                              <td ><html:text  property="txtEncshAmt" disabled="true"  styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" /></td>                                                                       
                               </tr>                           
                              <html:hidden property="txtPayModeType" />
                              
                              <tr>
                             <td  width="15%" class=labelText>
							 Number</td>
                              <td ><html:text  property="txtInvId"  readonly="true" styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onchange="chkSanctionDt()" />
                               </tr>

                            <TR>
                              <TD class=subHeader colspan=6> Deductions</TD>
                            </TR>
                
                            <TR>
                              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                            </TR> 
                             
                            <tr>
                              <td  width="15%" class=labelText align="left" >CPF Employee Contribution</td>                              
                              <td >
                              <html:hidden  property="txtCpfEmplyrCntrb" />
                              <html:text  property="txtCpfEmpCntrb" disabled="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" />
                              </td>                                                                       
                              
                              <td  width="15%" class=labelText align="left" >IT Deductions</td>
                              <td >                              
                              <html:text  property="txtDedIT" disabled="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" onchange="calcNetAmntPayble()" />
                              </td>                                 
                            </tr>
                            
                              <html:hidden property="txtDedOthr" name="frmLeaveEncashForm"  /> 
                           <tr>
                              <td class=labelText width="15%" >Remarks</td>                              
                              <td ><html:textarea  property="txtRmrks" disabled="true" styleClass = "optional" altKey="Payroll.EmpInfo.PermState" cols="27" /></td>                                                                                                    
                              <td  width="15%" class=labelText align="left" >Net Amount Payable</td>
                              <td ><html:text  property="txtNetAmt" disabled="true"  styleClass = "locked" altKey="Payroll.EmpInfo.PermState" maxlength="25" size="23" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="text-align:right" /></td>                                                                       
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
   
        <logic:equal name="frmLeaveEncashForm" property="screenMode" value="U" >
          <logic:equal name="frmLeaveEncashForm" property="txtInvId" value="" >
            <html:button value="Send Invoice" property="butInv" onclick="sendInv()"  />

			 <!--added by sonia on 31-08-2011-->
        <%--<html:button value="Delete Record" property="butInv" onclick="DelRecord()"  />--%>
          </logic:equal>
          <logic:notEqual name="frmLeaveEncashForm" property="txtInvId" value="" >
            <html:button value="Send Invoice" property="butInv" disabled="true"  />
             <html:button value="Cancel Invoice" property="butInv" onclick="cancelInv()" />
			 <!--added by sonia on 31-08-2011-->
        <%--<html:button value="Delete Record" property="butInv"  disabled="true" />--%>
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
<html:hidden name="frmLeaveEncashForm"  property="screenName" value="LeaveEncashScreen" />
<html:hidden property="loginLocCode" name="frmLeaveEncashForm"  />
<html:hidden name="frmLeaveEncashForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmLeaveEncashForm" />
<html:hidden property="positionRequested" name="frmLeaveEncashForm" />
<html:hidden property="userPositionRequested" name="frmLeaveEncashForm" />
<html:hidden property="buttonFlag" name="frmLeaveEncashForm"  />
<html:hidden property="lovKey" name="frmLeaveEncashForm"  />
<html:hidden property="txtFields" name="frmLeaveEncashForm"  />   
<html:hidden property="txtSearchFields" name="frmLeaveEncashForm"  />
<html:hidden property="txtDisplayFields" name="frmLeaveEncashForm"  />
<html:hidden property="txtIndex" name="frmLeaveEncashForm"  />

<html:hidden property="hdnDayWage" name="frmLeaveEncashForm"  />
<html:hidden property="hdnCpfDed" name="frmLeaveEncashForm"  />
<html:hidden property="hdnFlagIT" name="frmLeaveEncashForm"  />
<html:hidden property="txtPayScaleType" name="frmLeaveEncashForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript">
function ShowEmpNum()
{
   frmLeaveEncashForm.lovKey.value = "LeaveEncash" + frmLeaveEncashForm.screenName.value + frmLeaveEncashForm.screenMode.value;
   frmLeaveEncashForm.queryParam.value="txtSiteID="+ frmLeaveEncashForm.loginLocCode.value +",hdnEmpLbrFlag="+frmLeaveEncashForm.hdnEmpLbrFlag.value ;
   if(frmLeaveEncashForm.screenMode.value == 'N')
   {
      frmLeaveEncashForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtDsgn,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOPDesc,txtDOJSite,txtEmpStatus,txtCurrBas,txtPayScaleType";
      // frmLeaveEncashForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
       frmLeaveEncashForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
       frmLeaveEncashForm.txtIndex.value ="";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLeaveEncashForm');
   }
   if(frmLeaveEncashForm.screenMode.value == 'Q')
   {
     frmLeaveEncashForm.txtDisplayFields.value = "txtEmpNo,txtEmpName";
     frmLeaveEncashForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
     frmLeaveEncashForm.txtIndex.value ="";
     showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmLeaveEncashForm');
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
        document.all.txtApplnDt.disabled = "";
        document.all.txtSnctnDt.disabled = "";
        document.all.txtEL.disabled = "";
        document.all.txtRmrks.disabled = "";
		document.all.txtDedIT.disabled = "";
        if(document.all.hdnFlagIT.value=='N')
        {
          document.all.txtDedIT.disabled = "";
        }
        document.all.txtPayModeType.disabled = "";
        if(mode=='U' && document.all.hdnDayWage.value=='')
          getData();
		 
    }
    hedMenuHandling(mode);
	if(document.getElementById('txtInvId').value!="")
	{
    document.all.butSave.disabled = "true";
    document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	}
//        alert(frmLeaveEncashForm.hdnEmpLbrFlag.value)
      if (frmLeaveEncashForm.hdnEmpLbrFlag.value=="E") 
      {
//Disabling INsert Mode  and Delete Mode Added By Amresh
    disableInsert();
    }
}

function disableInsert(){
    document.all.butInsertMode.disabled="true";
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butDel.disabled="true";
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";
}
function SaveRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmLeaveEncashForm"))
    {     
		 var answer = confirm("Have you verified all the data including Income Tax.Press OK to save the record!!!!")
	   if (!answer)
     {
		   return false;
	   }
//added by Vini on 24/01/2014
       if(document.all.txtNetAmt.value == 0)
       {
         alert("Net Amount Payable can't be 0");
			   return false;
       }
///added by sonia 

if( document.all.txtDedIT.value != 0 || document.all.txtCpfEmpCntrb.value != 0){
	         calcNetAmntPayble();
			 var itDed=document.all.txtDedIT.value;
             var checkDed=parseInt(document.all.txtEncshAmt.value-document.all.txtCpfEmpCntrb.value-itDed);
				if(checkDed != document.all.txtNetAmt.value){
				alert("Please check your calculation it is not correct");
if(document.all.txtNetAmt.value == 0)
         alert("Net Amount Payable can't be 0");
				return false;
}
				
}

/////end 


        frmLeaveEncashForm.detailDataChanged.value = "false";  
        //if(frmLeaveEncashForm.screenMode.value == "N")
          frmLeaveEncashForm.headerDataChanged.value = "true";      
        frmLeaveEncashForm.headerFields.value = "true";
        frmLeaveEncashForm.txtEncshAmt.disabled = "";
        document.all.txtCpfEmpCntrb.disabled="";
        document.all.txtNetAmt.disabled="";
        document.all.txtDedIT.disabled="";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmLeaveEncashForm.action = "../../../LeaveEncashSaveAction.do";  
        frmLeaveEncashForm.submit();
    }
    else
    {
        return false;
    }
	
}

function lfnChanged(val)
{
    frmLeaveEncashForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    frmLeaveEncashForm.action="../../../LeaveEncashFirstGetHeaderAction.do"
    frmLeaveEncashForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmLeaveEncashForm.userPositionRequested.value = 1*frmLeaveEncashForm.positionRequested.value + 1;
    frmLeaveEncashForm.action="../../../LeaveEncashGetNextHeader.do";
    frmLeaveEncashForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmLeaveEncashForm.userPositionRequested.value = 1*frmLeaveEncashForm.positionRequested.value - 1;
    frmLeaveEncashForm.action = "../../../LeaveEncashGetNextHeader.do";
    frmLeaveEncashForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmLeaveEncashForm.userPositionRequested.value = 1*frmLeaveEncashForm.newPositionRequested.value;
    frmLeaveEncashForm.action = "../../../LeaveEncashGetNextHeader.do";
    frmLeaveEncashForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
     
    document.all.buttonFlag.value='';
    frmLeaveEncashForm.action="../../../LeaveEncashNewMode.do"
    frmLeaveEncashForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmLeaveEncashForm.action="../../../LeaveEncashQueryMode.do"
    frmLeaveEncashForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmLeaveEncashForm.action="../../../LeaveEncashRefresh.do"
    frmLeaveEncashForm.submit();
}

function getData()
{
	
    document.all.hdnDayWage.value="";
    applnDt=document.all.txtApplnDt.value;
	
    if(!cmpSysDate(applnDt,0))
    { 
      document.all.txtApplnDt.value="";
      return false;
    }
    if(document.all.txtEmpNo.value!="")
    {
      document.all.buttonFlag.value=''; 
      frmLeaveEncashForm.action="../../../LeaveEncashGetParam.do"
      frmLeaveEncashForm.submit();
      //calcAmt();
    }else
    {
      alert("Please Select an employee first!!!");
      document.all.txtApplnDt.value="";
    }
}

function chk_YearMonth(val)
{

       var  yearM = val;          
       var month =  yearM.substring(4,6);
                                     
        if (yearM.length != 6)
        {
          alert(" Year Month should be a Six digit Number");             
          event.srcElement.select();
          event.srcElement.focus();
          event.returnValue=false;   
          return false;
        }
        else if(month < 1 || month > 12)
        {
          alert("  Month should be Within 1 to 12");                   
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

function calcAmt()
{        
    //alert('inside calcAmt()')
	if(chkSelEL())
    {
      var itDed=document.all.txtDedIT.value==""?"0":document.all.txtDedIT.value;
      var othrDed=document.all.txtDedOthr.value==""?"0":document.all.txtDedOthr.value;
     // document.all.txtEncshAmt.value = parseInt(document.all.txtEL.value * document.all.hdnDayWage.value);   //commented by devendra on 14th sept 2010
	 document.all.txtEncshAmt.value = Math.round(parseFloat(document.all.txtEL.value * document.all.hdnDayWage.value));//added by devendra on 14th sept 2010
      document.all.txtNetAmt.value=parseInt(document.all.txtEncshAmt.value-document.all.txtCpfEmpCntrb.value-itDed-othrDed);
      document.all.txtDedOthr.value=othrDed;
      document.all.buttonFlag.value=''; 
      document.all.txtCpfEmpCntrb.disabled="";
      document.all.txtEncshAmt.disabled="";
      document.all.txtNetAmt.disabled="";
      
      frmLeaveEncashForm.action="../../../LeaveEncashCalcITDed.do"
      frmLeaveEncashForm.submit();
    }
    else
    {
    }
}

function calcNetAmntPayble()
{        
    if(chkSelEL())
    {
      var itDed=document.all.txtDedIT.value==""?"0":document.all.txtDedIT.value;
      var othrDed=document.all.txtDedOthr.value==""?"0":document.all.txtDedOthr.value;
      //document.all.txtEncshAmt.value = parseInt(document.all.txtEL.value * document.all.hdnDayWage.value);    //commented by devendra on 24 sept 2010  
	//   document.all.txtEncshAmt.value = Math.round(parseFloat(document.all.txtEL.value * document.all.hdnDayWage.value));//added by devendra on 24 sept 2010
	   if(document.all.txtEncshAmt.value-document.all.txtCpfEmpCntrb.value-itDed-othrDed>=0)
	   {
      document.all.txtNetAmt.value=parseInt(document.all.txtEncshAmt.value-document.all.txtCpfEmpCntrb.value-itDed-othrDed);
	  }
	  else
	  {
	  document.all.txtDedIT.value=0;
	  alert('IT deductions can con be greater then Encashment Amount.\n \nRecheck IT deduction amount.');
	  }
      document.all.txtDedOthr.value=othrDed;
    }
    
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
  if (!cmpDate(applnDt,sanctionDt,0))
  {
    alert("Application Date cannot be greater than Sanction Date");
    document.all.txtSnctnDt.value="";
    return false;                      
  }
}

 function chkSelEL()
 {
    payScale=document.all.txtPayScaleType.value;
    if(payScale=='IDA')
    {
      if(document.all.txtEL.value>135)
      {
        alert("Encashed Leaves cannot be grater than 135");
        document.all.txtEL.value="";
        document.all.txtEL.focus();
        return false;
      }
      else
      {
        return true;
      }
    }
    if(payScale=='CDA')
    {
      if(document.all.txtEL.value>150)
      {
        alert("Encashed Leaves cannot be greater than 150");
        document.all.txtEL.value="";
        document.all.txtEL.focus();
        return false;
      }
      else
      {
        return true;
      }
    }
 }
 
function sendInv()
{ 
  if(document.all.txtEmpNo.value=='')
  {
    alert("Please Select a record first!!");
    return false;
  }
  document.getElementById("butInv").disabled="true";
  frmLeaveEncashForm.action="../../../LeaveEncashSendInv.do"
  
  frmLeaveEncashForm.submit();
}

function checkeAllRecord(){
if( document.all.txtDedIT.value != 0 || document.all.txtCpfEmpCntrb.value != 0){
             var checkDed=parseInt(document.all.txtEncshAmt.value-document.all.txtCpfEmpCntrb.value-itDed);
				if(checkDed != document.all.txtNetAmt.value){
				alert("Please check your calculation it is not correct");
				return false;
				}
}

}

function DelRecord()
{ 
	//alert("deleting Record...");
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
  frmLeaveEncashForm.action="../../../LeaveEncashDelRecord.do?param1=leavencash"
  frmLeaveEncashForm.submit();
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
  frmLeaveEncashForm.action="../../../LeaveEncashCancelInv.do"
  
  frmLeaveEncashForm.submit();
 } 
}


</script>


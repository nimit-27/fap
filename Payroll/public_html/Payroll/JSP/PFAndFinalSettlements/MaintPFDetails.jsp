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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    
   
</head>
<BODY scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:errors/>

<html:form  action="MaintPfDetailBase" name="frmMaintPfDetail" type="FCIPAY.Payroll.WEBTIER.Form.MaintPfDetailForm" scope="session">
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN PF DETAILS</TD>
</TR>
</TABLE>
<!--container table starts -->
<div id=divBody style="height:550px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>

       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> PF Header Information</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.emp" /></td>
            <td align="left"><html:text  property="txtEmpNo" altKey="Payroll.MaintPfDetail.emp" maxlength="10" size="16" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpNo" >&nbsp;&nbsp;<html:text  property="txtEmpName"  maxlength="10" size="26" styleClass="locked" /></td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.fp" /></td>
            <td><html:text  property="txtFinPeriod" altKey="Payroll.MaintPfDetail.fp" maxlength="10" size="23" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtFinPeriod" ></td>
         
        </tr>

         <tr>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.op" /></td>
            <td align="left"><html:text  property="txtOpBal" altKey="Payroll.MaintPfDetail.op" maxlength="10" size="16" styleClass="required" /></td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.cl" /></td>
            <td><html:text  property="txtCloBal" altKey="Payroll.MaintPfDetail.cl" maxlength="10" size="23" styleClass="required" /></td>
         
        </tr>

         <tr>
            <td class="labelText"  width="25%" ><bean:message key="Payroll.MaintPfDetail.total" /></td>
            <td align="left"><html:text  property="txtIntActotal" altKey="Payroll.MaintPfDetail.total" maxlength="10" size="16" styleClass="required" /></td>
            <td class="labelText"  width="25%" ><bean:message key="Payroll.MaintPfDetail.actno" /></td>
            <td><html:text  property="txtPfActNo" altKey="Payroll.MaintPfDetail.actno" maxlength="10" size="23" styleClass="required" /></td>
         
        </tr>



           <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>
    

<TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>  Transfer In Amount</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.empsub" /></td>
            <td align="left"><html:text  property="txtEmpSub" altKey="Payroll.MaintPfDetail.empsub" maxlength="10" size="16" styleClass="required" /></td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.empcon" /></td>
            <td><html:text  property="txtEmpCon" altKey="Payroll.MaintPfDetail.empcon" maxlength="10" size="23" styleClass="required" /></td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.volpf" /></td>
            <td><html:text  property="txtVolPf" altKey="Payroll.MaintPfDetail.volpf" maxlength="10" size="23" styleClass="required" /></td>
         

        </tr>

        <tr>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.date" /></td>
            <td align="left"><html:text  property="txtTransDate" altKey="Payroll.MaintPfDetail.date" maxlength="10" size="16" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtTransDate" ></td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.date" /></td>
            <td><html:text  property="txtTransDate" altKey="Payroll.MaintPfDetail.date" maxlength="10" size="23" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtTransDate" ></td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.date" /></td>
            <td><html:text  property="txtTransDate" altKey="Payroll.MaintPfDetail.date" maxlength="10" size="23" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtTransDate" ></td>
         

        </tr>




           <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>

     <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>  Transfer Out Amount</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
         <tr>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.empsub" /></td>
            <td align="left"><html:text  property="txtEmpSub" altKey="Payroll.MaintPfDetail.empsub" maxlength="10" size="16" styleClass="required" /></td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.empcon" /></td>
            <td><html:text  property="txtEmpCon" altKey="Payroll.MaintPfDetail.empcon" maxlength="10" size="23" styleClass="required" /></td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.volpf" /></td>
            <td><html:text  property="txtVolPf" altKey="Payroll.MaintPfDetail.volpf" maxlength="10" size="23" styleClass="required" /></td>
         

        </tr>

        <tr>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.date" /></td>
            <td align="left"><html:text  property="txtTransDate" altKey="Payroll.MaintPfDetail.date" maxlength="10" size="16" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtTransDate" ></td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.date" /></td>
            <td><html:text  property="txtTransDate" altKey="Payroll.MaintPfDetail.date" maxlength="10" size="23" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtTransDate" ></td>
            <td class="labelText"  width="15%" ><bean:message key="Payroll.MaintPfDetail.date" /></td>
            <td><html:text  property="txtTransDate" altKey="Payroll.MaintPfDetail.date" maxlength="10" size="23" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtTransDate" ></td>
         

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
                <td bgcolor="#4682B4" nowrap class=actTabText>Pf Detail<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0">
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll')"  /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.sr" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.year" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.empsub" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.empcon" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.volpf" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.amtadv" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.refadv" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.amtw" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.bondepopf" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintPfDetail.exvpfamt" /></td>

                            </TR>

                          
                          
                          <logic:iterate id="pfdetail" name="frmMaintPfDetail" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintPfDetailBean" >
                          
                           <tr>
                              <td  width="1%" ><html:checkbox property="selectAll" value="check" /></td>
                              <td  width="5%" ><html:text property="txtSrlNo" name="pfdetail" styleClass="width:100%" /></td>
                              <td  width="5%" ><html:text property="txtYearMon" name="pfdetail" styleClass="width:100%" /></td>
                              <td  width="5%" ><html:text property="txtEmpSub" name="pfdetail" styleClass="width:100%" /></td>
                              <td  width="5%" ><html:text property="txtEmpCon" name="pfdetail" styleClass="width:100%" /></td>
                              <td  width="5%" ><html:text property="txtVolPf" name="pfdetail" styleClass="width:100%" /></td>
                              <td  width="5%" ><html:text property="txtAdvAmt" name="pfdetail" styleClass="width:100%" /></td>
                              <td  width="5%" ><html:text property="txtRefAdv" name="pfdetail" styleClass="width:100%" /></td>
                              <td  width="5%" ><html:text property="txtAmtWithDrawn" name="pfdetail" styleClass="width:100%" /></td>
                              <td  width="5%" ><html:text property="txtBonPf" name="pfdetail" styleClass="width:100%" /></td>
                              <td  width="5%" ><html:text property="txtExVpfAmt" name="pfdetail" styleClass="width:100%" /></td>

                             <html:hidden property="status" name="pfdetail"/>S<html:hidden property="detailId" name="pfdetail" /></td>
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
                      <TD><html:button value='Get Detail '  onclick="doGetDetail()" property="butGetDetail" styleClass="bottomBarText" /> <html:button value='  Add Row '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /> <html:button value='Delete Row'  onclick="delRow()" property="butInsert" styleClass="bottomBarText" /></TD>
                      <td width=46%> </td>	
                      <TD ><IMG src="../INCLUDES/IMAGES/butn_dtl_prev.jpg" onmouseover='this.src="../INCLUDES/IMAGES/butn_dtl_prev_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/butn_dtl_prev.jpg"' alt=Butn_prev src="../INCLUDES/butn_dtl_prev.jpg"></td>
                      <td class=dtlNavText>1 of 10</td>
                      <td align=right><IMG src="../INCLUDES/IMAGES/butn_dtl_next_act.jpg" onmouseover='this.src="../INCLUDES/IMAGES/butn_dtl_next_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/butn_dtl_next.jpg"' alt=Butn_next src="../INCLUDES/butn_dtl_next.jpg" onclick="doGetNextDetail()"></td>
                      <td align=right><input type="text" name="hdrGoto" size="1"></td>
                      <td><img src="..\INCLUDES\IMAGES\go_dtl.jpg"></td>		     
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
               <!--<td  bgcolor=#4682b4><html:button value='Approve'  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Reject '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /><html:button value=' Revise '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /></td>-->
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
<html:hidden name="finConfigChartOfAccount"  property="screenName" value="FinConfigChartOfAccountScreen" />


</html:form>
</body>
</html:html>

 
<script language="javascript">
var formMode="A";
var oElemName=new Object();
var sSaveFlag=1;
 function doExecute()
    {
      alert("Execute");
      document.forms[0].action="/enrgise/getFinConfigChartOfAccountHeaderInfo.do";
      document.forms[0].submit();
    }  
     function doGetDetail()
    {
      alert("Getting Details");
      document.forms[0].action="/enrgise/getFinConfigChartOfAccountDetailInfo.do";
      document.forms[0].submit();
    } 
     function doGetNextHeader()
    {
      alert("Next Header");    
      document.forms[0].action="/enrgise/getNextHeaderInfo.do";
      document.forms[0].submit();
    }
    function doGetNextDetail()
    {
      alert("Next Detail");    
      document.forms[0].action="/enrgise/getNextDetailInfo.do";
      document.forms[0].submit();
    }
     function doFirst()
    {
      alert("First Record");  
    }
   
function doGetButtons(mode){
  alert('getting buttons');
  var str="";
  if(mode=="Q")
  {
      str="<img alt='Execute' border='0' src='../INCLUDES/IMAGES/execute_act.jpg' style='CURSOR: default' onclick='doExecute()'>"
      str+="<img alt='Save'    border='0' src='../INCLUDES/IMAGES/save_act.jpg'   style='CURSOR: default' onclick='doSave()'   >"
      str+="<img alt='Delete'  border='0' src='../INCLUDES/IMAGES/delete_act.jpg' style='CURSOR: default' onclick='doDelete()' >"
      str+="<img alt='Refresh' border='0' src='../INCLUDES/IMAGES/refresh.jpg' hsrc='../INCLUDES/IMAGES/refresh_act.jpg' style='CURSOR: default' onclick='doRefresh()' >"
      str+="<img alt='Print'   border='0' src='../INCLUDES/IMAGES/print.jpg'   hsrc='../INCLUDES/IMAGES/print_act.jpg'   style='CURSOR: default' >"
  }
  else
  {
      str="<img alt='Execute' border='0' src='../INCLUDES/IMAGES/execute_dis.jpg' style='CURSOR: default'>"
      str+="<img alt='Save'    border='0' src='../INCLUDES/IMAGES/save.jpg'        hsrc='../INCLUDES/IMAGES/save_act.jpg' style='CURSOR: default'   onclick='doSave()'>"
      str+="<img alt='Delete'  border='0' src='../INCLUDES/IMAGES/delete_dis.jpg'  style='CURSOR: default' >"
      str+="<img alt='Refresh' border='0' src='../INCLUDES/IMAGES/refresh.jpg'     hsrc='../INCLUDES/IMAGES/refresh_act.jpg' style='CURSOR: default' onclick='doRefresh()'>"
      str+="<img alt='Print'   border='0' src='../INCLUDES/IMAGES/print.jpg'       hsrc='../INCLUDES/IMAGES/print_act.jpg' style='CURSOR: default'>"
  }
  return str;
}



//These functions are for mode change.
//------------------------------------
function doModeChange(mode){
  formMode=mode;
  alert(formMode+sSaveFlag);
  //No need for saveflag check for Update mode
  if(formMode=="U"){ //Update mode
    enable_all();
    return true;
  }

  //Check for saveflag for Insert/Query Mode
  if(sSaveFlag==0){
    var bResponse=confirm("Unsaved data will be lost!");
    if(bResponse==false){
      return false;
    }
  }
  sSaveFlag=1;
  if(formMode=="A"){ //Insert mode
    enable_all();
  }
  if(formMode=="Q"){ //Query mode
    alert('cane to enable_all');
    enable_all();
  }
  return true;
}

function doSaveChange(){
  sSaveFlag*=0;
  return (sSaveFlag==0)?true:false;  
}
</script>
 
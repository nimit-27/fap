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
   <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script> 
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
   
   
</head>
<BODY scroll=no onLoad="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />



<html:form  action="UndoPayroll" name="frmUndoPayroll" type="FCIPAY.Payroll.WEBTIER.Form.UndoPayrollForm" scope="session">
<bean:define id="ParentForm" name="frmUndoPayroll" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>UNDO PAYROLL TRANSCATION FOR <bean:write name="frmUndoPayroll" property="payYYMM" /></TD>
</TR>
</TABLE>
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Undo Payroll Transaction</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
   <!--      
        <tr>
              <td width="33%">  </td>
              <td width="6%" align="right"  class="radioText" ><input type="radio" name="optAll" value="A" checked="true" onclick="optClick(this.value);" /><bean:message key="Payroll.Compute.all"  />
              <td width="8%" align="right" class="radioText" ><html:radio  property="optAll" value="E" onclick="optClick(this.value);" /><bean:message key="Payroll.Compute.emp"  />
              <td  align="left"><html:text  property="txtEmpNum" maxlength="10" size="20" styleClass="optional" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmployee" name="butEmployee" onclick="showEmployee();" >&nbsp;&nbsp;<html:text  property="txtEmpName" maxlength="10" size="26" styleClass="locked" readonly="true" /></td>
        -->      
        </tr>
            <tr height="10">		    
        <TD colspan="6" > </TD>
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
                <td bgcolor="#4682B4" nowrap class=actTabText>Types of Transaction<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="16">
                  <TABLE cellSpacing="0" cellPadding="0" border="0" >
                    <tr height = 10><td></td></tr>
                    <TR>
                      <TD width = 30%></td>
  			<!-- Detail table starts -->
                      <TD width = 40%>        
                        <TABLE cellSpacing="0" cellPadding="0" border = 0 style="BORDER-RIGHT: #4682b4 thin solid; BORDER-LEFT: #4682b4 thin solid; BORDER-BOTTOM: #4682b4 thin solid;BORDER-top: #4682b4 thin solid;">
                              <!-- <TABLE cellSpacing="0" cellPadding="0" border = 4>-->
                              <tr height=30></tr>
                              <tr >
                             <td width=35%></td>                              
                             <TD  width = 5% align=right><html:checkbox name="frmUndoPayroll" property="chkLeave" disabled="true" /></TD>
                             <TD width = 60% class=checkText>Leave/Attendance</td>
                                                            
                              </tr>                               
                               <tr >
                             <td width=35%></td>                              
                             <TD  width = 5% align=right><html:checkbox name="frmUndoPayroll" property="chkLoan" disabled="true" /></TD>
                             <TD width = 60% class=checkText>Loan</td>
                           
                              </tr>                               
                              <tr >
                             <td width=35%></td>                              
                             <TD  width = 5% align=right><html:checkbox name="frmUndoPayroll" property="chkAdvance" disabled="true" /></TD>
                             <TD width = 60% class=checkText>Advance</td>
                                                         
                              </tr>                               
                          
                              <tr >
                             <td width=35%></td>                              
                             <TD  width = 5% align=right><html:checkbox name="frmUndoPayroll" property="chkSavings" disabled="true" /></TD>
                             <TD width = 60% class=checkText>Salary Savings</td>
                                                           
                              </tr> 
                   <!--           
                              <tr >
                             <td width=35%></td>                              
                             <TD  width = 5% align=right><html:checkbox name="frmUndoPayroll" property="chkElecConsmp" /></TD>
                             <TD width = 60% class=checkText>Electricity Consumption</td>                                                          
                              </tr>                               
            -->
                             <tr >
                             <td width=35%></td>                              
                             <TD  width = 5% align=right><html:checkbox name="frmUndoPayroll" property="chkPFAdvance" disabled="true" /></TD>
                             <TD width = 60% class=checkText>PF Advance Recovery</td>                                                         
                              </tr>                               

                              
                              <tr >
                             <td width=35%></td>                              
                             <TD  width = 5% align=right><html:checkbox name="frmUndoPayroll" property="chkMonthPayroll" disabled="true" /></TD>
                             <TD width = 60% class=checkText>Monthly Payroll</td>
                                                          
                              </tr>                                  


                           <tr height=30></tr>
                       <!--</table>-->       
                     </TABLE>
                   </TD>
                   <TD width = 30%></td>                   
                  </TR>                     
                    <tr height = 10><td></td></tr>                  
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
               <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />

               <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
                <% if(smode.equals(new String("U"))) {%> 
                Update Mode
               <%} else if(smode.equals(new String("N"))) {  %>
                New Mode
               <%} else if(smode.equals(new String("Q"))) {  %>
                Query Mode
               <%}  %>
               </td> 
        
               <td align=center bgcolor=#4682b4 width="35%"></td>
               <td  bgcolor=#4682b4><html:button value=' Undo Transaction'  onclick="UndoTransaction();" property="butUndoTran" styleClass="bottomBarText" /></td>
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
<html:hidden property="screenMode" name="frmUndoPayroll" />
<html:hidden name="frmUndoPayroll"  property="screenName" value="UndoTranScreen" />
<html:hidden name="frmUndoPayroll"  property="deFlag" />

<html:hidden property="lovKey" name="frmUndoPayroll"  />
<html:hidden property="txtFields" name="frmUndoPayroll"  />   
<html:hidden property="txtSearchFields" name="frmUndoPayroll"  />
<html:hidden property="txtDisplayFields" name="frmUndoPayroll"  />
<html:hidden property="txtIndex" name="frmUndoPayroll"  />

</html:form>
</body>
</html:html>

 
<script language="javascript">


  function lfnLoad()
  {
    mode = frmUndoPayroll.screenMode.value;

      if(mode=='Q'){
//        optClick('A');
        batchMenuHandling();         
        document.all.butRefresh.disabled="true";    
        document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";         
      }
      else
      {
        doQueryMode();
      }
    
  }
  
  function optClick(val)
  { 
      if(val == 'A')
      {
        frmUndoPayroll.txtEmpNum.value="";
        frmUndoPayroll.txtEmpName.value="";
        frmUndoPayroll.txtEmpNum.style.background="#e0e0e0";
        frmUndoPayroll.txtEmpNum.disabled="true";
        frmUndoPayroll.butEmployee.disabled="true";
      }
      else
      {
        frmUndoPayroll.txtEmpNum.style.background="#ffffd3";
        frmUndoPayroll.txtEmpNum.disabled="";
        frmUndoPayroll.butEmployee.disabled="";
      }
  }


  function showEmployee()
  {
       frmUndoPayroll.lovKey.value = "UndoPayroll" + frmUndoPayroll.screenName.value + frmUndoPayroll.screenMode.value;
       frmUndoPayroll.txtDisplayFields.value = "txtEmpNum,txtEmpName";
//       frmUndoPayroll.txtSearchFields.value = "Payroll.Compute.emp";
       frmUndoPayroll.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";   
       frmUndoPayroll.txtIndex.value ="";      
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmUndoPayroll');
       return true;
      
  }


  function UndoTransaction()
  {
    if(mandatory_Check("frmUndoPayroll"))
    {
    var dflag = "";
      if(frmUndoPayroll.chkLeave.checked)
      {
        dflag=dflag+"1";
      }
      else
      {
        dflag=dflag+"0";
      }
      if(frmUndoPayroll.chkLoan.checked)
      {
        dflag=dflag+"1";
      }
      else
      {
        dflag=dflag+"0";
      }
      if(frmUndoPayroll.chkAdvance.checked)
      {
        dflag=dflag+"1";
      }
      else
      {
        dflag=dflag+"0";
      }
      if(frmUndoPayroll.chkSavings.checked)
      {
        dflag=dflag+"1";
      }
      else
      {
        dflag=dflag+"0";
      }
      //Elec rembrsment will go 0
      dflag=dflag+"0";
      if(frmUndoPayroll.chkPFAdvance.checked)
      {
        dflag=dflag+"1";
      }
      else
      {
        dflag=dflag+"0";
      }
      

        frmUndoPayroll.deFlag.value = dflag;
		frmUndoPayroll.butUndoTran.disabled="true";
        frmUndoPayroll.action = "../../../UndoPayrollTransaction.do";
        frmUndoPayroll.submit();
        
    }
      else
        return false;
    }
  function doQueryMode()
  {
          frmUndoPayroll.action = "../../../UndoPayrollQueryMode.do";
          frmUndoPayroll.submit();
  }
function doRefresh()
{
  frmUndoPayroll.action="../../../UndoPayrollRefresh.do";
  frmUndoPayroll.submit();
}
</script>
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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
   <script type = "text/javascript">
        function enableForm()
        {
            document.forms[0].disabled=true;
        }
        window.onload=enableForm;
    </script>  
   
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="CreatePayroll" name="frmCreatePayroll" type="FCIPAY.Payroll.WEBTIER.Form.CreatePayrollForm" scope="session">
<bean:define id="ParentForm" name="frmCreatePayroll" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>CREATE PAYROLL TRANSCATION FOR <bean:write name="frmCreatePayroll" property="payYYMM" /></TD>
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
          <TD class=subHeader colspan=6> Create Payroll Transaction </TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="20" >
            <td width="50%"></td>
            <td width="50%"></td>
         </tr>
            <tr>		    
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
                        <TABLE cellSpacing="2" cellPadding="2" border = 0 style="BORDER-RIGHT: #4682b4 thin solid; BORDER-LEFT: #4682b4 thin solid; BORDER-BOTTOM: #4682b4 thin solid;BORDER-top: #4682b4 thin solid;">
                              <!-- <TABLE cellSpacing="0" cellPadding="0" border = 4>-->
                              <tr height=25></tr>
                              <tr >
                             <td width=35%></td>                              
                             <TD width = 50%><html:checkbox property="selectAll" value="" disabled="true" /> Leave/Attendance </TD>
                             <td width=15%></td>                                                            
                              </tr>                               
                               <tr >
                             <td width=35%></td>                              
                             <TD width = 50%><html:checkbox property="selectAll"  value="" disabled="true" /> Loan </TD>
                             <td width=15%></td>                                                            
                              </tr>                               
                              <tr >
                             <td width=35%></td>                              
                             <TD width = 50%><html:checkbox property="selectAll"  value="" disabled="true" /> Advances </TD>
                             <td width=15%></td>                                                            
                              </tr>                               
                          
                              <tr >
                             <td width=35%></td>                              
                             <TD width = 50%><html:checkbox property="selectAll"  value="" disabled="true" /> Salary Savings </TD>
                             <td width=15%></td>                                                            
                              </tr>                               

                         <!--   FCI Customizations Dt 15 Oct 2007  modified by Balpreet  --> 
                   <!--         <tr >
                              <td width=35%></td>                              
                              <TD width = 50%><html:checkbox property="selectAll"  value="check" /> Electricity Consumption </TD>
                              <td width=15%></td>                                                            
                              </tr>       
                  -->
                              <tr >
                              <td width=35%></td>                              
                              <TD width = 50%><html:checkbox property="selectAll"  value="" disabled="true" /> PF Advance Recovery </TD>
                              <td width=15%></td>                                                            
                              </tr>                                                                                           

                           <tr height=25></tr>
                       <!--</table>-->       
                     </TABLE>
                   </TD>
                   <TD width = 30%></td>                   
                  </TR>                     
                    <tr height = 10><td></td></ptr>                  
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
               <td align=center bgcolor=#4682b4 width="42%"></td>
               <td  bgcolor=#4682b4>
			   <html:button value=' Create Transaction'  onclick="createTransaction()" disabled="false" property="butInsert" styleClass="bottomBarText" />
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

<!-- Container Table Ends -->


    <html:hidden name="frmCreatePayroll"  property="screenMode"/>
    <html:hidden name="frmCreatePayroll"  property="txtEmp" value="" />
    <html:hidden name="frmCreatePayroll"  property="screenName" value="CreatePayroll" />
    <html:hidden name="frmCreatePayroll"  property="loginLocCode"/>
	<html:hidden name="frmCreatePayroll"  property="hdnAction" /><!--///////////added by sonia///////////////-->

    <html:hidden property="lovKey" name="frmCreatePayroll"  />
    <html:hidden property="txtFields" name="frmCreatePayroll"  />   
    <html:hidden property="txtSearchFields" name="frmCreatePayroll"  />
    <html:hidden property="txtDisplayFields" name="frmCreatePayroll"  />
    <html:hidden property="txtIndex" name="frmCreatePayroll"  />


    <input type="hidden" name="queryParam">

</html:form>
</body>
</html:html>

 
<script language="javascript">
function doSetEmployees(val)
{
  if(val=='E')
  {
    document.all.txtEmp.style.background = "#ffffd3";
    document.all.butTxtEmpNo.disabled="";
    document.all.txtEmp.className="required";
  }
  else
  {
    document.all.txtEmp.value="";
    document.all.txtEmpName.value="";
    document.all.txtEmp.style.background = "#e0e0e0";
    document.all.butTxtEmpNo.disabled="true";
    document.all.txtEmp.className="locked";
  }
}

  function doSetEmployee(val)
  { 
      if(val == 'A')
      {
        frmCreatePayroll.txtEmp.value="";
        frmCreatePayroll.txtEmpName.value="";
        frmCreatePayroll.txtEmp.style.background="#e0e0e0";
        frmCreatePayroll.txtEmp.disabled="true";
        frmCreatePayroll.butTxtEmpNo.disabled="true";
      }
      else
      {
        frmCreatePayroll.txtEmp.style.background="#ffffd3";
        frmCreatePayroll.txtEmp.disabled="";
        frmCreatePayroll.butTxtEmpNo.disabled="";
      }
  }


function createTransaction()
{
  if(mandatory_Check("frmCreatePayroll"))
  {
  var str="";
  for(i=0;i<5;i++)
  {
    if(document.all.selectAll[i].checked==false)
    {
      str = str+'0';
    }
    else
    {
      str = str+'1';
    }
  }
  str=str+'0';
  if(str=='000000')
    alert('Please select at least one type of Transaction');
  else
  {
	  
      /* commented by sonia -----------
	  ac="../../../CreatePayrollTransaction.do?param1="+str+"&param2="+document.all.txtEmp.value;
      //document.all.butInsert.disabled="true"; // added by sonia 
      document.forms[0].action=ac;
      document.forms[0].submit(); ------------commented by sonia*/



///////////added by sonia///////////////
 if (frmCreatePayroll.hdnAction.value != 'SUB') 
      {
        frmCreatePayroll.hdnAction.value = 'S'; 
        ac="../../../CreatePayrollTransaction.do?param1="+str+"&param2="+document.all.txtEmp.value;
		document.all.butInsert.disabled="true";
        document.forms[0].action=ac;
        document.forms[0].submit();
		
      }
      else
      {
        frmCreatePayroll.hdnAction.value='SUB';       
        ac="../../../CreatePayrollTransaction.do?param1="+str+"&param2="+document.all.txtEmp.value;
		document.all.butInsert.disabled="true";
        document.forms[0].action=ac;
        document.forms[0].submit();
      }        

///////////end added by sonia///////////////



  }
  }
  else
    return false;
}

function doQueryMode()
{
  frmCreatePayroll.hdnAction.value='Q'///////////added by sonia///////////////
  
  document.forms[0].action="../../../CreatePayrollQueryMode.do";
  document.forms[0].submit();
}

function lfnLoad()
{
	
  mode=document.all.screenMode.value;
  if(mode=='Q')
  {
  //  doSetEmployee('A')
 
  }
  else
  {
	 enableForm(); 
    doQueryMode();
	frmCreatePayroll.hdnAction.value='';  ///////////added by sonia///////////////
	
  }
///////////added by sonia///////////////
  if (frmCreatePayroll.hdnAction.value=='S') 
	{
		document.all.butInsert.disabled="true";
		frmCreatePayroll.hdnAction.value='SUB';
		createTransaction(); 
	}
///////////added by sonia///////////////
  batchMenuHandling();
}

function ShowLovEmpNo()
{
   document.forms[0].lovKey.value = "CreatePayrollEmp" + frmCreatePayroll.screenName.value + frmCreatePayroll.screenMode.value;
   document.forms[0].txtDisplayFields.value = "txtEmp,txtEmpName"; 
// document.forms[0].txtSearchFields.value = "Payroll.Create.emp";
   document.forms[0].txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";   
   document.forms[0].txtIndex.value ="";
   document.forms[0].queryParam.value="txtSiteID="+ frmCreatePayroll.loginLocCode.value +"" ;
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmCreatePayroll');
   return true;
}
function doRefresh()
{
  frmCreatePayroll.action="../../../CreatePayrollRefresh.do";
  frmCreatePayroll.submit();
}
</script>
 

    
  


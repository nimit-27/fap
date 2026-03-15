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
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>

   
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


  <html:form  action="MonthlyDepLbrPayroll" name="frmMonthlyPayroll" type="FCIPAY.Payroll.WEBTIER.Form.MonthlyPayrollForm" scope="session">
<bean:define id="ParentForm" name="frmMonthlyPayroll" toScope="request" />
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />


<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>COMPUTE MONTHLY PAYROLL PROCESS <bean:write name="frmMonthlyPayroll" property="payYYMM" /></TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6> Compute Monthly Payroll Process</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
                                                                                  
           		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=16>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              
          
              
                
		<!-- Detail table Container starts -->
                <TD colspan="16">
                  <TABLE cellSpacing="0" cellPadding="0" border="0" >
                    
                    <TR>
                      <TD width = 30%></td>
  			<!-- Detail table starts -->
                      <TD width = 40%>        
                        
                   </TD>
                   <TD width = 30%></td>                   
                  </TR>                     
                                      
        		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
              <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
               <td align=center bgcolor=#4682b4 width="42%"></td>
               <td  bgcolor=#4682b4><html:button value=' Compute Monthly Payroll'  onclick="computeTransaction()" property="butInsert" styleClass="bottomBarText" /></td>
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


    <html:hidden name="frmMonthlyPayroll"  property="screenMode"/>
    <html:hidden name="frmMonthlyPayroll"  property="txtEmp" value="" />
    <html:hidden name="frmMonthlyPayroll"  property="screenName" value="CompDepLbrPayroll" />
    <html:hidden property="buttonFlag" name="frmMonthlyPayroll"  />
    <html:hidden name="frmMonthlyPayroll"  property="hdnAction" />
    <html:hidden name="frmMonthlyPayroll"  property="loginLocCode" />
    
    <html:hidden property="lovKey" name="frmMonthlyPayroll"  />
    <html:hidden property="txtFields" name="frmMonthlyPayroll"  />   
    <html:hidden property="txtSearchFields" name="frmMonthlyPayroll"  />
    <html:hidden property="txtDisplayFields" name="frmMonthlyPayroll"  />
    <html:hidden property="txtIndex" name="frmMonthlyPayroll"  />
    <html:hidden name="frmMonthlyPayroll"  property="butAction" />
    <input type="hidden" name="queryParam">

</html:form>
</body>
</html:html>

 
<script language="javascript">
function doSetEmployee(val)
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
    document.all.txtEmp.style.background = "#ffffff";
    document.all.butTxtEmpNo.disabled="true";
    document.all.txtEmp.className="optional";
  }
}

function computeTransaction()
{  
  if(!mandatory_Check("frmMonthlyPayroll"))
  {
    return false;
  }

      if (frmMonthlyPayroll.hdnAction.value != 'SUB') 
      {
        frmMonthlyPayroll.hdnAction.value = 'S'; 
        ac="../../../ComputeDepLbrMonthlyPayroll.do?param1="+document.all.txtEmp.value+"&param2=A";
        document.forms[0].action=ac;
        document.forms[0].submit();
      }
      else
      {
        frmMonthlyPayroll.hdnAction.value='SUB';       
        ac="../../../ComputeDepLbrMonthlyPayroll.do?param1="+document.all.txtEmp.value+"&param2=A";
        document.forms[0].action=ac;
        document.forms[0].submit();
      }        
}

function doQueryMode()
{
  frmMonthlyPayroll.hdnAction.value='Q'
  document.forms[0].action="../../../MonthlyDepLbrPayrollQueryMode.do";
  document.forms[0].submit();
}

function lfnLoad()
{
  mode=document.all.screenMode.value;
  if(mode=='Q'){
//    optClick('A');
  }
  else
  {
    doQueryMode();
    frmMonthlyPayroll.hdnAction.value='';    
  }
 // document.all.butTxtEmpNo.disabled="true";

  if (frmMonthlyPayroll.hdnAction.value=='S') 
  {
      frmMonthlyPayroll.hdnAction.value='SUB';
      computeTransaction(); 
  }
  
  hedMenuHandling('Q');
  hedMenuHandling('N');
}

function ShowLovEmpNo()
{
   document.forms[0].lovKey.value = "CompMonthlyPayrollEmp" + frmMonthlyPayroll.screenName.value + "Q";
   document.forms[0].txtDisplayFields.value = "txtEmp,txtEmpName"; 
   document.forms[0].txtSearchFields.value =  "Payroll.Common.empNo,Payroll.Common.empName";
   document.forms[0].txtIndex.value ="";
   document.forms[0].queryParam.value="txtSiteID="+ frmMonthlyPayroll.loginLocCode.value +" " ;
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMonthlyPayroll');
   return true;
}

  function optClick(val)
  { 
      if(val == 'A')
      {
        frmMonthlyPayroll.txtEmp.value="";
        frmMonthlyPayroll.txtEmpName.value="";
        frmMonthlyPayroll.txtEmp.style.background="#e0e0e0";
        frmMonthlyPayroll.txtEmp.disabled="true";
        frmMonthlyPayroll.butTxtEmpNo.disabled="true";
      }
      else
      {
        frmMonthlyPayroll.txtEmp.style.background="#ffffd3";
        frmMonthlyPayroll.txtEmp.disabled="";
        frmMonthlyPayroll.butTxtEmpNo.disabled="";
      }
  }

</script>


<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script> 
</head>
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:errors/>

<html:form  action="GenerateSalaryJV" name="frmGenerateSalaryJV" type="FCIPAY.Payroll.WEBTIER.Form.GenerateSalaryJVForm">
<bean:define id="ParentForm" name="frmGenerateSalaryJV" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>GENERATE SALARY JV</TD>
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
          <TD class=subHeader colspan=6> GENERATE SALARY JV DETAILS</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
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
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="16">
                  <TABLE cellSpacing="0" cellPadding="0" border="0" >
                    <tr height = 10><td></td></tr>
                    <tr height = 10><td></td></tr>                  
        		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
               
    <TR>
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
                         <td align=center bgcolor=#4682b4 width="35%"></td>
           
               <td  bgcolor=#4682b4 width="25%"><html:button value='  Generate  '  onclick="GenSalJVTransaction()" property="butInsert" styleClass="bottomBarText" /></td>
             
               <td  bgcolor=#4682b4 width="25%"><html:button value='  Rollback  '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /></td>
               <td  bgcolor=#4682b4 width="25%">
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden property="screenMode" name="frmGenerateSalaryJV" />
<html:hidden name="frmGenerateSalaryJV"  property="screenName" value="GenerateSalaryJVScreen" />


</html:form>
</body>
</html:html>

 
<script language="javascript">


function lfnLoad()
{
  
 
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
      doQueryMode();
  }
  batchMenuHandling();
}

function doQueryMode()
{
  frmGenerateSalaryJV.action="../../../GenSalQueryMode.do"
  frmGenerateSalaryJV.submit();
}


 

  function GenSalJVTransaction()
{  
  
  ac="../../../GenSalaryJV.do";
  alert(ac);
  document.forms[0].action="../../../GenSalaryJV.do";
  document.forms[0].submit();
}
  
</script>
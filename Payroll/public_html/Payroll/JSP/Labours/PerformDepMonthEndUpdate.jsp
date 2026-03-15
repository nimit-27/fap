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
   <script type = "text/javascript">
       function enableForm()
        {
            document.forms[0].disabled=true;
        }
        window.onload=enableForm;
    </script> 
   
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="DepMonthUpdate" name="frmMonthUpdate" type="FCIPAY.Payroll.WEBTIER.Form.PerformMonthEndUpdateForm" scope="session" >
<bean:define id="ParentForm" name="frmMonthUpdate" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

<html:errors/>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>PERFORM LABOURS MONTH END UPDATE FOR <bean:write name="frmMonthUpdate" property="payYYMM" /></TD>
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
          <TD class=subHeader colspan=6> MONTH END DETAILS</TD>
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
          <td align=center bgcolor=#4682b4 width="40%"></td>
          
               <td  bgcolor=#4682b4 width="20%"><html:button value='Perform Month End'  onclick="MonthEndTransaction()" disabled="false" property="butInsert" styleClass="bottomBarText" /></td>
               <td  bgcolor=#4682b4 width="20%">
                <td  bgcolor=#4682b4 width="20%"></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>	   </TR>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden property="screenMode" name="frmMonthUpdate" />
<html:hidden name="frmMonthUpdate"  property="hdnAction" />    
<html:hidden name="frmMonthUpdate"  property="screenName" value="DepMonthUpdateScreen" />

<html:hidden property="lovKey" name="frmMonthUpdate"  />
<html:hidden property="txtFields" name="frmMonthUpdate"  />   
<html:hidden property="txtSearchFields" name="frmMonthUpdate"  />
<html:hidden property="txtDisplayFields" name="frmMonthUpdate"  />
<html:hidden property="txtIndex" name="frmMonthUpdate"  />

</html:form>
</body>
</html:html>

 
<script language="javascript">

function lfnLoad()
{
  
  batchMenuHandling();
 
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
	  enableForm();
      doQueryMode();
      frmMonthUpdate.hdnAction.value='';      
  }

  if (frmMonthUpdate.hdnAction.value=='S') 
  {
     frmMonthUpdate.hdnAction.value='SUB';
     MonthEndTransaction(); 
  }
  
}

function doQueryMode()
{
  frmMonthUpdate.hdnAction.value='Q' 
  frmMonthUpdate.action="../../../ComputeDepMonthEndQuery.do"
  frmMonthUpdate.submit();
}


 

   function MonthEndTransaction()
{ 

      if (frmMonthUpdate.hdnAction.value != 'SUB') 
      {
        frmMonthUpdate.hdnAction.value = 'S'; 
        frmMonthUpdate.action = "../../../ComputeDepMonthEnd.do";
        frmMonthUpdate.submit();
      }
      else
      {
        frmMonthUpdate.hdnAction.value='SUB';       
        frmMonthUpdate.action = "../../../ComputeDepMonthEnd.do";
        frmMonthUpdate.submit();
      }      

  
  
}
  
</script>
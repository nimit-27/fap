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
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="InitDpsLbrPayData" name="frmInitdpsPayroll" type="FCIPAY.Payroll.WEBTIER.Form.InitDpsInitialiseForm" scope="session">
<bean:define id="ParentForm" name="frmInitdpsPayroll" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>INITIALIZE ACTUAL WORK DONE FOR <bean:write name="frmInitdpsPayroll" property="payYYMM" /></TD>
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
          <TD class=subHeader colspan=6> Initialize Actual Work Transaction</TD>
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
        
               <td align=center bgcolor=#4682b4 width="30%"></td>
               <td  bgcolor=#4682b4><html:button value=' Initialize Incentive'  onclick="InitTransaction();" disabled="false" property="butInitTran" styleClass="bottomBarText" /></td>
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
<html:hidden name="frmInitdpsPayroll"  property="forwardedPage" />
<html:hidden name="frmInitdpsPayroll"  property="screenMode" />
<html:hidden name="frmInitdpsPayroll"  property="hdnAction" />
<html:hidden name="frmInitdpsPayroll"  property="screenName" value="InitPayDpsLbrScreen" />

<html:hidden property="lovKey" name="frmInitdpsPayroll"  />
<html:hidden property="txtFields" name="frmInitdpsPayroll"  />   
<html:hidden property="txtSearchFields" name="frmInitdpsPayroll"  />
<html:hidden property="txtDisplayFields" name="frmInitdpsPayroll"  />
<html:hidden property="txtIndex" name="frmInitdpsPayroll"  />

</html:form>
</body>
</html:html>


 
<script language="javascript">

  function lfnLoads()
  {
      var sMode = frmInitdpsPayroll.screenMode.value;

/*      if(mode == '')
      {
        frmInitdpsPayroll.screenMode.value='Q';      
        frmInitdpsPayroll.action = "../../../InitDepLbrPayrollQuery.do";
        frmInitdpsPayroll.submit();
      }
      else
      {
        batchMenuHandling();
      }  */

/*  if(sMode == "")
  {
    doQueryMode();
  }  */
		 
      batchMenuHandling();      
      doQueryMode();      
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";     
  }

function lfnLoader()
{
  mode=document.all.screenMode.value;
  if(mode=='Q'){}
  else
  {
    doQueryMode();
    frmInitdpsPayroll.hdnAction.value='';
  } 
      batchMenuHandling();
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";       
//    doQueryMode();      
}

function lfnLoad()
{
  
  batchMenuHandling();
 
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
	  enableForm();
      doQueryMode();
      frmInitdpsPayroll.hdnAction.value='';
  }

  if (frmInitdpsPayroll.hdnAction.value=='S') 
  {
     frmInitdpsPayroll.hdnAction.value='SUB';
     InitTransaction(); 
  }

      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";       
    
}
  


function doQueryMode()
{
  frmInitdpsPayroll.hdnAction.value='Q'
  frmInitdpsPayroll.action="../../../InitDpsLbrPayrollQuery.do"
  frmInitdpsPayroll.submit();
}
  


  function InitTransaction()
  {
      if (frmInitdpsPayroll.hdnAction.value != 'SUB') 
      {
        frmInitdpsPayroll.hdnAction.value = 'S'; 
        frmInitdpsPayroll.action = "../../../InitDpsLbrPayroll.do";
        frmInitdpsPayroll.submit();
      }
      else
      {
        frmInitdpsPayroll.hdnAction.value='SUB';       
        frmInitdpsPayroll.action = "../../../InitDpsLbrPayroll.do";
        frmInitdpsPayroll.submit();
      }      
  }

</script>


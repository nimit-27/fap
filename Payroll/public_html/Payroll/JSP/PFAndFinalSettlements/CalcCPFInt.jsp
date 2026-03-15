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
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="CPFCalcInt" name="frmCPFFinalPayForm" type="FCIPAY.Payroll.WEBTIER.Form.CPFFinalPaymentForm" scope="session">
<bean:define id="ParentForm" name="frmCPFFinalPayForm" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>CALCULATE YEAR END INTEREST</TD>
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
          <TD class=subHeader colspan=6>Calculate Interest</TD>
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

 	 <TR height="50">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
          
              <TR height=10>
                                    <?audit suppress oracle.ide.xml.mismatched-end-tag?>
                                    <!-- Detail table Container starts -->
                <TD colspan="16">
                 <TABLE cellSpacing="0" cellPadding="0" border="0" >

  <tr>
              <!--<td width="33%">  </td>-->
              
              <td class="labelText"  width="40%" >Financial Year (YYYYYY)</td>
              <td align="left"><html:text property="txtYr" alt="P" maxlength="6" size="22" styleClass="required" onchange="chk_FinYear()" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" /></td>
             </tr>
             <!-- commented by himanshu on 7-july-2014-->
             
             <%--<tr>
              <td class="labelText"  width="40%" >Employee Type</td>
              <td align="left">
              <html:select name="frmCPFFinalPayForm" property="txtEmpLbrFlag" styleClass="required">
              <html:option value=""> -------Please Select ------- </html:option>
              <html:option value="E">Employee</html:option>
              <html:option value="L">Dept Labours</html:option>
              <html:option value="D">DPS Labours</html:option>
              </html:select>
              </td>--%>
               
   	 <TR height="50"><td>&nbsp;</td></tr>
   
        </tr>
                    
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
        
               
			    <!--Modified by himanshu on 7-july-2014-->
               <td  bgcolor=#4682b4 align=center><html:button value='Calculate Interest/Re-Run Interest'  onclick="if(mandatory_Check('frmCPFFinalPayForm')){CalcInt()}else{return false;}" property="butCalcOTA" styleClass="bottomBarText" />
                <!--added by himanshu  on 7-july-2014-->
			  <!-- <html:button value='Freeze Year End Interest' onclick="freeze()" styleClass="bottomBarText"  property="butCalcOTA"/></td>-->
               <!--end of additiomn-->
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
<html:hidden name="frmCPFFinalPayForm"  property="forwardedPage" />
<html:hidden name="frmCPFFinalPayForm"  property="screenMode" />
<html:hidden name="frmCPFFinalPayForm"  property="hdnAction" />
<html:hidden name="frmCPFFinalPayForm"  property="screenName" value="CalcCPFIntScreen" />
<html:hidden property="loginLocCode" name="frmCPFFinalPayForm"  />

</html:form>
</body>
</html:html>


 
<script>

function lfnLoad()
{
  
  batchMenuHandling();
  var screenmode = document.all.screenMode.value;
  
  if(screenmode == '')
  {
      doQueryMode();
      frmCPFFinalPayForm.hdnAction.value='';
  }

/*  if (frmCPFFinalPayForm.hdnAction.value=='S') 
  {
     frmCPFFinalPayForm.hdnAction.value='SUB';
     CalcOTA(); 
  }*/

      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";       
    
}
  


function doQueryMode()
{
  frmCPFFinalPayForm.hdnAction.value='Q'
  frmCPFFinalPayForm.action="../../../CPFCalIntQueryMode.do"
  frmCPFFinalPayForm.submit();
}
  


  function CalcInt()
  {
      frmCPFFinalPayForm.hdnAction.value='calcInt';
      frmCPFFinalPayForm.action = "../../../CalcInt.do";
      frmCPFFinalPayForm.submit();
  }
function freeze()
{
      frmCPFFinalPayForm.hdnAction.value='freezeYrEnd';
      frmCPFFinalPayForm.action = "../../../freezeYearEnd.do";
      frmCPFFinalPayForm.submit();
}

function chk_FinYear()
{
    var  yearM = document.getElementById("txtYr").value;          
    var Year1;
    var Year2;    
    if ( yearM != "") 
    {
        if (num_Check(yearM,1))
        {                                   
            if (yearM.length != 6)
            {
                alert(" Fin Year should be a Six digit Number");
                document.getElementById("txtYr").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                            
                return false;    
            }        
            Year1 =  yearM.substring(2,4);
            Year2 =  yearM.substring(4,6);           
            
            var TempYr1 = parseInt(Year1,10) + 1; 
            var TempYr2 = parseInt(Year2,10);  
            if (parseInt(TempYr1,10) != parseInt(TempYr2,10))
            {
                alert("Year Should be in the format of a Financial Period Eg. 200607");
                document.getElementById("txtYr").focus();                     
                event.srcElement.select();
                event.srcElement.focus();
                event.returnValue=false;                   
                return false;       
            }
    
            return true;                                     
        }      
        else
        {
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;     
            return false;
        }
    }
}
</script>


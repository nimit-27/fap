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
    
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

  <html:form  action="CompIncTax" name="frmCompIncTax" type="FCIPAY.Payroll.WEBTIER.Form.CompIncTaxForm" scope="session">
  <bean:define id="ParentForm" name="frmCompIncTax" toScope="request" />
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />


<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>COMPUTE MONTHLY INCOME TAX PROCESS FOR <bean:write name="frmCompIncTax" property="payYYMM" /></TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       <!--<div id=divBody>-->
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6></TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="20" >
            <td colspan="2"></td>
         </tr>
        <tr>
        </tr> 
       
           <tr >		    
        <TD colspan="2" > </TD>
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
                <td bgcolor="#4682B4" nowrap class=actTabText >COMPUTE INCOME TAX DETAILS<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif"  width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
         <tr height="20" >
            <td colspan="14"></td>
         </tr>
         <td colspan="14">
          <table>
<!--                  <TR>                            
                <td width="10%"></td>
                <td class="radioText" ><html:radio  property="optSelectBasedOn" value="P"  onclick="doSetBasedOnFlag('P')"  /><bean:message key="Payroll.Compinc.proj"  />
                <td></td>     
                <td class="radioText" ><html:radio  property="optSelectBasedOn" value="A" onclick="doSetBasedOnFlag('A')"  /><bean:message  key="Payroll.Compinc.act" />
                <td></td>                         
                </TR>  0-->
          
         <tr height="10">	
         <tr>
            <tr height="10">	
             <td></td>
            </tr>

        
        
        </tr>  
           </table>
           <!-- Commeneted by Balpreet Dated 28 March 2008 
          <table>
            <tr height=20>
            </tr>

          <tr>
              <td width="33%">  </td>
              <td width="8%" align="right"  class="radioText" ><html:radio  property="optSelectAllEmp" value="L"  onclick=" return doSetAllEmpFlag('L');"  /><bean:message key="Payroll.Compute.all"  />
              <td width="8%" align="right"  class="radioText" ><html:radio  property="optSelectAllEmp" value="E"   onclick="return doSetAllEmpFlag('E');"  /><bean:message key="Payroll.Compute.emp"  />
              <td  align="left"><html:text  property="txtEmp" name="frmCompIncTax"  maxlength="10" size="20"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpLOV"  name="buttxtEmpLOV" onclick="showLOVEmp();">
              <html:text  property="txtEmpName" name="frmCompIncTax" maxlength="10" size="26" styleClass="locked" readonly="true"/></td>
              
          </tr>

          </table>
-->
<html:hidden  property="txtEmp" name="frmCompIncTax" />
        <table>
          <tr height = 10> <td>&nbsp; </td>  </tr>
                 <TR>                            
                <td width="40%"></td>
                <td class="radioText"  width="20%"><html:checkbox  property="chkConsMaxReb" value="P" onclick="doSetConsMaxRebFlag(this.value)"  /><bean:message key="Payroll.Compinc.ChkMaxRebate"  />
                <td></td>     
          
          </table>


          <tr height="20" >
            <td colspan="14"></td>
         </tr>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="14">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                   </TD>
                  </TR>                     
                  
   <!-- Get details starts -->
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
               <td  bgcolor=#4682b4><html:button value=' Compute Income Tax'  onclick="computeIncomeTax()" property="butInsert" styleClass="bottomBarText" /></td>
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
<!-- These four hidden fields must be present in pages where there is a detail part -->
<html:hidden name="frmCompIncTax"  property="screenName" value="ComputeMonthlyIncomeTaxScreen" />
<html:hidden name="frmCompIncTax"  property="forwardedPage" />
<html:hidden name="frmCompIncTax"  property="butAction" />
<html:hidden name="frmCompIncTax"  property="hdnAction" />    
<html:hidden name="frmCompIncTax"  property="incomeTaxPComputedFlag" />
<html:hidden name="frmCompIncTax"  property="incomeTaxAComputedFlag" />
<html:hidden name="frmCompIncTax"  property="basedOnFlag" />
<html:hidden name="frmCompIncTax"  property="hdnMaxRebFlag" />
<html:hidden property="screenMode" name="frmCompIncTax"  />
<html:hidden name="frmCompIncTax"  property="loginLocCode"  />

<html:hidden name="frmCompIncTax"  property="lovKey"  />
<html:hidden name="frmCompIncTax"  property="txtFields" />   
<html:hidden name="frmCompIncTax"  property="txtSearchFields" />
<html:hidden name="frmCompIncTax"  property="txtDisplayFields"  />
<html:hidden name="frmCompIncTax"  property="txtIndex"  />
<html:hidden name="frmCompIncTax"  property="payYYMM" />
<input type="hidden" name="queryParam" />
<!-- Hidden fields end -->

</html:form>
</body>
</html:html>

 
<script language="javascript">
var bOnFlag ;
var allEmpFlag;
var compFlag;

function lfnLoad()
{
  batchMenuHandling();
 
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
      doQueryMode();
      frmCompIncTax.hdnAction.value='';            
  }

  if (frmCompIncTax.hdnAction.value=='S') 
  {
	  
	 document.all.butInsert.disabled="true";
     frmCompIncTax.hdnAction.value='SUB';
      computeIncomeTax(); 
  }
  if(screenmode != '')
  {
     var payYear = frmCompIncTax.payYYMM.value;
     var month = payYear.substr(4,6);
	 if(month=='02')
	 {
		document.frmCompIncTax.hdnMaxRebFlag.value = 'N';
		document.frmCompIncTax.chkConsMaxReb.checked =  "";
		document.frmCompIncTax.chkConsMaxReb.disabled = "true";
	 }
  }
}

function computeIncomeTax()
{  
      bOnFlag = document.frmCompIncTax.basedOnFlag.value;
      
      if (frmCompIncTax.hdnAction.value != 'SUB') 
      {
        frmCompIncTax.hdnAction.value = 'S'; 
        frmCompIncTax.action="../../../computeITActual.do";
        document.forms[0].submit();      
      }
      else
      {
        frmCompIncTax.hdnAction.value='SUB';       
        frmCompIncTax.action="../../../computeITActual.do";
        document.forms[0].submit();      
      }      
}
   

function doSetBasedOnFlag(tempFlag)
{
        document.frmCompIncTax.basedOnFlag.value = tempFlag;
        //alert(document.frmCompIncTax.basedOnFlag.value);
}

function doSetConsMaxRebFlag(tempFlag)
{
  if (document.frmCompIncTax.chkConsMaxReb.checked ==  true) 
  {
      document.frmCompIncTax.hdnMaxRebFlag.value = 'Y';      
  }      
  else
      document.frmCompIncTax.hdnMaxRebFlag.value = 'N';      
}

function doSetAllEmpFlag(tempFlag)
{
        allEmpFlag = tempFlag;
        setEnableDisable(allEmpFlag);  
        //alert(allEmpFlag);
}

function setEnableDisable(allEmpFlag)
{
      if(allEmpFlag == 'L')
      {
        document.all.txtEmp.disabled = "true";
        document.all.txtEmp.value = "";        
        document.all.txtEmpName.value = "";                
        document.all.txtEmpName.disabled = "true";    
        document.frmCompIncTax.buttxtEmpLOV.disabled = "disabled";
      }
      else if(allEmpFlag == 'E')
      {
        document.all.txtEmp.disabled = "";
        document.all.txtEmpName.disabled = "";    
        document.frmCompIncTax.buttxtEmpLOV.disabled = "";  
      }

}

function showLOVEmp()
{
   //alert("lov");
   frmCompIncTax.lovKey.value = "CompIncTax" + frmCompIncTax.screenName.value + 'Q';
   frmCompIncTax.txtDisplayFields.value = "txtEmp,txtEmpName";
   frmCompIncTax.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";   
   frmCompIncTax.txtIndex.value ="";
   frmCompIncTax.queryParam.value="txtSiteID="+ frmCompIncTax.loginLocCode.value +" " ;
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmCompIncTax');
   return true;
}

function doRefresh()
{
  //alert("Refresh");
  frmCompIncTax.action="../../../refreshPage.do";
  frmCompIncTax.submit();                      
}

function doQueryMode()
{
  frmCompIncTax.hdnAction.value='Q' 
  frmCompIncTax.action="../../../IncomeQueryAction.do"
  frmCompIncTax.submit();
}


</script>


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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../INCLUDES/ENRGISE.js"></script>            
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
    
</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

  <html:form  action="CompDepIncTaxProj" name="frmCompIncTaxProj" type="FCIPAY.Payroll.WEBTIER.Form.CompIncTaxProjForm" scope="session">
  <bean:define id="ParentForm" name="frmCompIncTaxProj" toScope="request" />
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />


<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>COMPUTE INCOME TAX PROJECTION</TD>
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
                <td bgcolor="#4682B4" nowrap class=actTabText >COMPUTE INCOME TAX PROJECTION DETAILS (Dept Labours)<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
          <table>
            <tr height=20>
            </tr>

          <tr>
              <td width="33%">  </td>
              <td width="8%" align="right"  class="radioText" ><html:radio  property="optSelectAllEmp" value="L"  onclick=" return doSetAllEmpFlag('L');"  /><bean:message key="Payroll.Compute.all"  />
              <td width="8%" align="right"  class="radioText" ><html:radio  property="optSelectAllEmp" value="E"   onclick="return doSetAllEmpFlag('E');"  /><bean:message key="Payroll.Compute.emp"  />
              <td  align="left"><html:text  property="txtEmp" name="frmCompIncTaxProj"  maxlength="10" size="20"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmpLOV"  name="buttxtEmpLOV" onclick="showLOVEmp();">
              <html:text  property="txtEmpName" name="frmCompIncTaxProj" maxlength="10" size="26" styleClass="locked" readonly="true"/></td>
              
          </tr>
          

          </table>

        <table>
          <tr></tr>
          <tr height = 10> <td>&nbsp; </td>  </tr>          
                     <TD class=labelText width="45%" ><bean:message key="pay.CompTaxProject.txtYYMM" /></td>
                     <td><html:text  property="txtYYMM" altKey="pay.CompTaxProject.txtYYMM" maxlength="10" size="23" styleClass="optional" 
                     onchange="                                                  
                       if(!(chk_YearMonth()))
                          {
                          }" />
          </tr>
        
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
<html:hidden name="frmCompIncTaxProj"  property="screenName" value="ComputeDepIncomeTaxProjScreen" />
<html:hidden name="frmCompIncTaxProj"  property="forwardedPage" />
<html:hidden name="frmCompIncTaxProj"  property="butAction" />
<html:hidden name="frmCompIncTaxProj"  property="hdnAction" />    
<html:hidden name="frmCompIncTaxProj"  property="incomeTaxPComputedFlag" />
<html:hidden name="frmCompIncTaxProj"  property="incomeTaxAComputedFlag" />
<html:hidden name="frmCompIncTaxProj"  property="basedOnFlag" />
<html:hidden name="frmCompIncTaxProj"  property="hdnMaxRebFlag" />
<html:hidden property="screenMode" name="frmCompIncTaxProj"  />
<html:hidden property="loginLocCode" name="frmCompIncTaxProj" />

<html:hidden name="frmCompIncTaxProj"  property="lovKey"  />
<html:hidden name="frmCompIncTaxProj"  property="txtFields" />   
<html:hidden name="frmCompIncTaxProj"  property="txtSearchFields" />
<html:hidden name="frmCompIncTaxProj"  property="txtDisplayFields"  />
<html:hidden name="frmCompIncTaxProj"  property="txtIndex"  />
<html:hidden name="frmCompIncTaxProj"  property="hdnCurYYMM"  />

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
      frmCompIncTaxProj.hdnAction.value='';            
  }

  if (frmCompIncTaxProj.hdnAction.value=='S') 
  {
     frmCompIncTaxProj.hdnAction.value='SUB';
      computeIncomeTax(); 
  }
  
}

function computeIncomeTax()
{  
      bOnFlag = document.frmCompIncTaxProj.basedOnFlag.value;
      
      if (frmCompIncTaxProj.hdnAction.value != 'SUB') 
      {
        frmCompIncTaxProj.hdnAction.value = 'S'; 
        frmCompIncTaxProj.action="../../../computeDepITProj.do";
        document.forms[0].submit();      
      }
      else
      {
        frmCompIncTaxProj.hdnAction.value='SUB';       
        frmCompIncTaxProj.action="../../../computeDepITProj.do";
        document.forms[0].submit();      
      }      
}
   

function doSetBasedOnFlag(tempFlag)
{
        document.frmCompIncTaxProj.basedOnFlag.value = tempFlag;
        //alert(document.frmCompIncTaxProj.basedOnFlag.value);
}

function doSetConsMaxRebFlag(tempFlag)
{
  if (document.frmCompIncTaxProj.chkConsMaxReb.checked ==  true) 
  {
      document.frmCompIncTaxProj.hdnMaxRebFlag.value = 'Y';      
  }      
  else
      document.frmCompIncTaxProj.hdnMaxRebFlag.value = 'N';      
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
        document.all.txtEmp.styleClass = "optional";        
        document.all.txtEmpName.disabled = "true";    
        document.frmCompIncTaxProj.buttxtEmpLOV.disabled = "disabled";
      }
      else if(allEmpFlag == 'E')
      {
        document.all.txtEmp.disabled = "";
        document.all.txtEmp.styleClass = "required";
        document.all.txtEmpName.disabled = "";    
        document.frmCompIncTaxProj.buttxtEmpLOV.disabled = "";  
      }

}

function showLOVEmp()
{
   frmCompIncTaxProj.lovKey.value = "CompIncTaxProj" + frmCompIncTaxProj.screenName.value + 'Q';
   frmCompIncTaxProj.txtDisplayFields.value = "txtEmp,txtEmpName";
   frmCompIncTaxProj.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";   
   frmCompIncTaxProj.txtIndex.value ="";
   frmCompIncTaxProj.queryParam.value="txtSiteID="+ frmCompIncTaxProj.loginLocCode.value +",hdnEmpLbrFlag="+frmCompIncTaxProj.hdnEmpLbrFlag.value ;
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmCompIncTaxProj');
   return true;
}

function doQueryMode()
{
  frmCompIncTaxProj.hdnAction.value='Q' 
  frmCompIncTaxProj.action="../../../IncomeProjDepQueryAction.do"
  frmCompIncTaxProj.submit();
}

function chk_YearMonth()
{
       var  yearM = document.getElementById("txtYYMM").value;          
       var month =  parseInt(yearM.substring(4,6),10);

    if (num_Check(yearM,1))
     {                                   
        if (yearM.length != 6)
        {
        alert("Year Month should be a Six digit Number");
//        documnt.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;           
        
        return false;
    
        }

  
       if(month < 1 || month > 12)
       {
       alert("Year  Month should be Within 1 to 12");
   //    document.getElementById("txtYYMM").focus();                     
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



</script>


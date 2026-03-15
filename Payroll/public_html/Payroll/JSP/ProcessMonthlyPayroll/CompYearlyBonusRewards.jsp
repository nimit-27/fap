<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

        <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
        <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
        <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
        <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
        <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script> 
   
</head>
<BODY scroll=no onLoad="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">

<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

  <html:form  action="CompYearlyBonusRewards" name="frmCompYearlyBonusRewards" type="FCIPAY.Payroll.WEBTIER.Form.CompYearBonRewForm" scope="session">
  <bean:define id="ParentForm" name="frmCompYearlyBonusRewards" toScope="request" />  
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

<html:errors/>


<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>COMPUTE YEARLY BONUS/AWARDS</TD>
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
                <td bgcolor="#4682B4" nowrap class=actTabText >Compute Yearly Bonus/Awards<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
         <tr height="20" >
            <td colspan="14"></td>
         </tr>
         <td colspan="14">
          <table>
              <TR>     
              <td>
              <table>
              <tr>
                  <td width="10%"></td>
                  <td class="radioText" ><input type="radio" name="optSelect"  value="B" checked="true" onclick="doSetFlag('B')"  /><bean:message key="Payroll.CompYear.bon"  />
                  <td class=labelText ><bean:message key="Payroll.MaintAdhoc.yymm"  /></td>
                  <td  align="left"><html:text  property="txtYYMM" maxlength="10" size="23" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtAcctCodeType"  name="butYYMM" onclick="showYearMonth();"  >&nbsp;&nbsp;<bean:message key="Payroll.MaintDARates.yymm"  /></td>
                  <td></td>
                  <td class="radioText" ><html:radio  property="optSelect"  value="A"  onclick="doSetFlag('A')"  /><bean:message  key="Payroll.CompYear.rew" />
                  <td></td>
              </tr>
              </table>
              </td>
              </TR>
          
            <tr height="10">	
             <td></td>
            </tr>

        <!--logic:lessThan property= "optVal" name= "frmCompYearlyBonusRewards" value="1"-->
            <tr>
                  <td>
                  <table>
                  <tr>

                              <td class="labelText"  width="25%" ><bean:message key="Payroll.CompYear.eml" /></td>
                              <td  width="25%"><html:text  property="txtMaxEmolAmt" altKey="Payroll.CompYear.eml" maxlength="10" size="26" styleClass="required" onchange="lfnChange(this.value);" /></td>
         
            
                              <td class=labelText width="25%" ><bean:message key="Payroll.CompYear.AwdAmt" /></td>
                              <td width="25%"><html:text  property="txtMaxAwdAmt" altKey="Payroll.CompYear.AwdAmt" maxlength="10" size="26" styleClass="required" onchange="lfnChange(this.value);" /></td>

                    </tr>
                    <tr>

                              <td class=labelText width="25%" ><bean:message key="Payroll.CompYear.nod" /></td>
                              <td width="25%"><html:text  property="txtBonDays" altKey="Payroll.CompYear.nod" maxlength="10" size="26" styleClass="required" onchange="lfnChange(this.value);" /></td>
         
            
                              <td class=labelText width="25%" ><bean:message key="Payroll.CompYear.Ydays" /></td>
                              <td width="25%"><html:text  property="txtAwdDays" altKey="Payroll.CompYear.Ydays" maxlength="10" size="26" styleClass="required" onchange="lfnChange(this.value);" /></td>
                  </tr>
                  </table>
                  </td>
                    
        </tr>
        <!--/logic:lessThan-->
        
           </table>
          <table>
            <tr height=20><td></td>
            </tr>

          <tr>

              <td width="33%">  </td>
              <td width="6%" align="right"  class="radioText" ><input type="radio" name="optVal" value="A" checked="true" onclick="optClick(this.value);" /><bean:message key="Payroll.Compute.all"  />
              <td width="8%" align="right" class="radioText" ><html:radio  property="optVal" value="E" onclick="optClick(this.value);" /><bean:message key="Payroll.Compute.emp"  />
              <td  align="left"><html:text  property="txtEmpNum" maxlength="10" size="20" styleClass="required" /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtEmployee" name="butEmployee" onclick="showEmployee();" >&nbsp;&nbsp;<html:text  property="txtEmpName" maxlength="10" size="26" styleClass="locked" readonly="true" /></td>
              
          </tr>
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
               <td  bgcolor=#4682b4><html:button value=' Compute'  onclick="Compute();" property="butInsert" styleClass="bottomBarText" /></td>
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
<html:hidden name="frmCompYearlyBonusRewards"  property="screenName" value="YearlyBonAwdScreen" />
<html:hidden name="frmCompYearlyBonusRewards"  property="screenMode" />
<html:hidden name="frmCompYearlyBonusRewards"  property="txtSrlNo" />
<html:hidden name="frmCompYearlyBonusRewards"  property="detailDataChanged" />
<html:hidden name="frmCompYearlyBonusRewards"  property="headerDataChanged" />
<html:hidden name="frmCompYearlyBonusRewards"  property="headerFields" />
<html:hidden name="frmCompYearlyBonusRewards"  property="userPositionRequested" />
<html:hidden name="frmCompYearlyBonusRewards"  property="positionRequested" />
<html:hidden name="frmCompYearlyBonusRewards"  property="buttonFlag" />
<html:hidden name="frmCompYearlyBonusRewards"  property="txtBonAwdFlag" />


<html:hidden property="lovKey" name="frmCompYearlyBonusRewards"  />
<html:hidden property="txtFields" name="frmCompYearlyBonusRewards"  />   
<html:hidden property="txtSearchFields" name="frmCompYearlyBonusRewards"  />
<html:hidden property="txtDisplayFields" name="frmCompYearlyBonusRewards"  />
<html:hidden property="txtIndex" name="frmCompYearlyBonusRewards"  />

<!-- Hidden fields end -->

</html:form>
</body>
</html:html>

 
<script language="javascript">


function lfnLoad()
{
  mode = frmCompYearlyBonusRewards.screenMode.value;
    if(mode == '')
    {
      frmCompYearlyBonusRewards.action = "../../../BonAwdQueryMode.do";
      frmCompYearlyBonusRewards.submit();
      //optClick('A');
      //doSetFlag('B');
    }
    else
    {
        //doSetFlag('B');
       // alert(frmCompYearlyBonusRewards.txtBonAwdFlag.value);
      if(frmCompYearlyBonusRewards.txtBonAwdFlag.value == 'B')
      {
        doSetFlag('B');
      }
      if(frmCompYearlyBonusRewards.txtBonAwdFlag.value == 'A')
      {
        doSetFlag('A');
      }
      if(frmCompYearlyBonusRewards.txtBonAwdFlag.value == '')
      {
        doSetFlag('B');
      }
      optClick('A');
      hedMenuHandling(mode);
    }
}

function optClick(val)
{ 
    if(val == 'A')
    {
      frmCompYearlyBonusRewards.txtEmpNum.value="";
      frmCompYearlyBonusRewards.txtEmpName.value="";
      frmCompYearlyBonusRewards.txtEmpNum.style.background="#e0e0e0";
      frmCompYearlyBonusRewards.txtEmpNum.disabled="true";
      frmCompYearlyBonusRewards.butEmployee.disabled="true";
    }
    else
    {
      frmCompYearlyBonusRewards.txtEmpNum.style.background="#ffffd3";
      frmCompYearlyBonusRewards.txtEmpNum.disabled="";
      frmCompYearlyBonusRewards.butEmployee.disabled="";
    }
}

function doSetFlag(val)
{ 
    if(val == 'B')
    {
      frmCompYearlyBonusRewards.txtMaxEmolAmt.disabled="";
      frmCompYearlyBonusRewards.txtBonDays.disabled="";
      frmCompYearlyBonusRewards.txtMaxEmolAmt.style.background="#ffffd3";
      frmCompYearlyBonusRewards.txtBonDays.style.background="#ffffd3";
      frmCompYearlyBonusRewards.txtMaxAwdAmt.style.background="#e0e0e0";
      frmCompYearlyBonusRewards.txtAwdDays.style.background="#e0e0e0";
      frmCompYearlyBonusRewards.txtMaxAwdAmt.disabled="true";
      frmCompYearlyBonusRewards.txtAwdDays.disabled="true";
      frmCompYearlyBonusRewards.txtMaxAwdAmt.value="";
      frmCompYearlyBonusRewards.txtAwdDays.value="";
    }
    else
    {
      frmCompYearlyBonusRewards.txtMaxEmolAmt.value="";
      frmCompYearlyBonusRewards.txtBonDays.value="";
      frmCompYearlyBonusRewards.txtMaxEmolAmt.disabled="true";
      frmCompYearlyBonusRewards.txtBonDays.disabled="true";
      frmCompYearlyBonusRewards.txtMaxEmolAmt.style.background="#e0e0e0";
      frmCompYearlyBonusRewards.txtBonDays.style.background="#e0e0e0";
      frmCompYearlyBonusRewards.txtMaxAwdAmt.style.background="#ffffd3";
      frmCompYearlyBonusRewards.txtAwdDays.style.background="#ffffd3";
      frmCompYearlyBonusRewards.txtMaxAwdAmt.disabled="";
      frmCompYearlyBonusRewards.txtAwdDays.disabled="";
    }
}

  function showYearMonth()
  {
       frmCompYearlyBonusRewards.lovKey.value = "BonAwdYYMM" + frmCompYearlyBonusRewards.screenName.value + frmCompYearlyBonusRewards.screenMode.value;
       frmCompYearlyBonusRewards.txtDisplayFields.value = "txtYYMM";
       frmCompYearlyBonusRewards.txtSearchFields.value = "Payroll.MaintAdhoc.yymm";
       frmCompYearlyBonusRewards.txtIndex.value ="";      
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmUndoPayroll');
       return true;
      
  }

  function showEmployee()
  {
       frmCompYearlyBonusRewards.lovKey.value = "BonAwd" + frmCompYearlyBonusRewards.screenName.value + frmCompYearlyBonusRewards.screenMode.value;
       frmCompYearlyBonusRewards.txtDisplayFields.value = "txtEmpNum,txtEmpName";
       frmCompYearlyBonusRewards.txtSearchFields.value = "Payroll.Compute.emp";
       frmCompYearlyBonusRewards.txtIndex.value ="";      
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmUndoPayroll');
       return true;
      
  }


function doInsertMode()
{
  frmCompYearlyBonusRewards.action="../../../BonAwdNewMode.do"
  frmCompYearlyBonusRewards.submit();
}

function doQueryMode()
{
  frmCompYearlyBonusRewards.action="../../../BonAwdQueryMode.do"
  frmCompYearlyBonusRewards.submit();
}

function doRefresh()
{
  frmCompYearlyBonusRewards.action="../../../BonAwdRefresh.do"
  frmCompYearlyBonusRewards.submit();
}

 function lfnChange(val)
{
  if(num_Check(val,1))
  {
    frmCompYearlyBonusRewards.headerDataChanged.value = "true";
//    frmCompYearlyBonusRewards.screenMode.value = "U";
  }
  else
  {
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
  }
}

function getHeaderRecord()
{
  frmCompYearlyBonusRewards.txtBonAwdFlag.value = frmCompYearlyBonusRewards.optSelect.value;
  frmCompYearlyBonusRewards.action="../../../BonAwdGetHeader.do"
  frmCompYearlyBonusRewards.submit();
}


function doGetNextHeader()
{ 
    frmCompYearlyBonusRewards.userPositionRequested.value = 1*frmCompYearlyBonusRewards.positionRequested.value + 1;
    frmCompYearlyBonusRewards.action="../../../BonAwdNextHeader.do";
    frmCompYearlyBonusRewards.submit();
}


function PrevHeader()
{
  frmCompYearlyBonusRewards.userPositionRequested.value = 1*frmCompYearlyBonusRewards.positionRequested.value - 1;
  frmCompYearlyBonusRewards.action = "../../../BonAwdNextHeader.do";
  frmCompYearlyBonusRewards.submit();
}


function JumpHeader()
{
  frmCompYearlyBonusRewards.userPositionRequested.value = 1*frmCompYearlyBonusRewards.newPositionRequested.value;
  frmCompYearlyBonusRewards.action = "../../../BonAwdNextHeader.do";
  frmCompYearlyBonusRewards.submit();
}


function SaveRecord()
{
  if(mandatory_Check("frmCompYearlyBonusRewards"))
  {

    frmCompYearlyBonusRewards.detailDataChanged.value = "false";  
    if(frmCompYearlyBonusRewards.screenMode.value == "N")
      frmCompYearlyBonusRewards.headerDataChanged.value = "true";  
    frmCompYearlyBonusRewards.headerFields.value = "true";


      frmCompYearlyBonusRewards.txtMaxEmolAmt.disabled="";
      frmCompYearlyBonusRewards.txtBonDays.disabled="";
      frmCompYearlyBonusRewards.txtMaxAwdAmt.disabled="";
      frmCompYearlyBonusRewards.txtAwdDays.disabled="";
      frmCompYearlyBonusRewards.butEmployee.disabled="";
    
    frmCompYearlyBonusRewards.action = "../../../BonAwdSaveAction.do";
    frmCompYearlyBonusRewards.submit();
  }
  else
  {
    return false;
  }
}

function Compute()
{
    frmCompYearlyBonusRewards.action = "../../../BonAwdCompute.do";
    frmCompYearlyBonusRewards.submit();
}
</script>
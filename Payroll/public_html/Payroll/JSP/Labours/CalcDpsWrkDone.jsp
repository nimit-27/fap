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
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="CalcDpsWrkDoneAction" name="frmDpsWrkDone" type="FCIPAY.Payroll.Labour.WEBTIER.Form.CalcDpsWrkDoneForm" scope="session">
<bean:define id="ParentForm" name="frmDpsWrkDone" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>CALCULATE DPS LABOUR WORK DONE FOR <bean:write name="frmDpsWrkDone" property="payYYMM" /></TD>
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
          <TD class=subHeader colspan=6>Calculate Actual</TD>
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
                
		<!-- Detail table Container starts -->
                <TD colspan="16">
                <!--
                 <TABLE cellSpacing="0" cellPadding="0" border="0" >

  <tr>
              <!--<td width="33%">  </td>-- >
              
              <td class="labelText"  width="15%" >Location</td>
              <td align="left"><html:text property="txtLoc" alt="P" maxlength="20" size="23" styleClass="required" readonly="false"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtPayCode" onclick=" showLOVDepots();"></td>
              <html:hidden property="txtLocId" />
              <td class="labelText"  width="15%" >Gang</td>
              <td align="left"><html:text property="txtGangName" alt="P" maxlength="20" size="23" styleClass="required" readonly="false"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtPayCode" onclick=" showLOVGang();"></td>
              <html:hidden property="txtGangId" />
               
   	 <TR height="50"><td>&nbsp;</td></tr>
   
        </tr>
                    
        		    </TABLE>
                -->
                <html:hidden property="txtLocId" />
                <html:hidden property="txtGangId" />
            </td>
               </tr>

<!-- Tab table Row 3 starts -->
          <!--     
    <TR>
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>
-->
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
               <td  bgcolor=#4682b4><html:button value='Calculate Actual Work Done'  onclick="if(checkFields()){CalcWrkDone()}else{return false;}" property="butCalcIncentive" styleClass="bottomBarText" /></td>
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

<html:hidden name="frmDpsWrkDone"  property="screenFlag"  value="N" />
<html:hidden name="frmDpsWrkDone"  property="txtFrom" />
<html:hidden name="frmDpsWrkDone"  property="txtTo" />

<html:hidden name="frmDpsWrkDone"  property="forwardedPage" />
<html:hidden name="frmDpsWrkDone"  property="screenMode" />
<html:hidden name="frmDpsWrkDone"  property="hdnAction" />
<html:hidden name="frmDpsWrkDone"  property="screenName" value="CalcDpsWrkDoneScreen" />
<html:hidden property="loginLocCode" name="frmDpsWrkDone"  />

<html:hidden property="lovKey" name="frmDpsWrkDone"  />
<html:hidden property="txtFields" name="frmDpsWrkDone"  />   
<html:hidden property="txtSearchFields" name="frmDpsWrkDone"  />
<html:hidden property="txtDisplayFields" name="frmDpsWrkDone"  />
<html:hidden property="txtIndex" name="frmDpsWrkDone"  />
<html:hidden property="txtInputField" name="frmDpsWrkDone"  />

<input type="hidden" name="queryParam" >

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
      doQueryMode();
      frmDpsWrkDone.hdnAction.value='';
  }

  if (frmDpsWrkDone.hdnAction.value=='S') 
  {
     frmDpsWrkDone.hdnAction.value='SUB';
     CalcWrkDone(); 
  }

      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";       
    
}
  


function doQueryMode()
{
  frmDpsWrkDone.hdnAction.value='Q'
  frmDpsWrkDone.action="../../../CalcDpsWrkDoneQuery.do"
  frmDpsWrkDone.submit();
}
  


  function CalcWrkDone()
  {
      if (frmDpsWrkDone.hdnAction.value != 'SUB') 
      {
        frmDpsWrkDone.hdnAction.value = 'S'; 
        frmDpsWrkDone.action = "../../../CalcDpsWrkDone.do";
		document.all.butCalcIncentive.disabled="true";
        frmDpsWrkDone.submit();
      }
      else
      {
        frmDpsWrkDone.hdnAction.value='SUB';       
        frmDpsWrkDone.action = "../../../CalcDpsWrkDone.do";
		document.all.butCalcIncentive.disabled="true";
        frmDpsWrkDone.submit();
      }      
  }

function checkFields()
{
    return true;
    if(document.all.txtLoc.value=='')
    {
      if(document.all.txtGangName.value=='')
      {
        return confirm("This will calculate work done for all the labours under the Login Location");
      }
    }
    else
    {
      if(document.all.txtGangName.value=='')
      {
        return confirm("This will calculate work done for all the labours of selected Location");
      }
    }
    return true;
}

function showLOVGang()
{   
   frmDpsWrkDone.lovKey.value = "CalcDpsWrkDoneGang" + frmDpsWrkDone.screenName.value + frmDpsWrkDone.screenMode.value;   
   frmDpsWrkDone.txtDisplayFields.value = "txtGangId,txtGangName,txtLocId,txtLoc";
   frmDpsWrkDone.queryParam.value = "txtSiteID="+frmDpsWrkDone.loginLocCode.value+",txtLbrType=DPS,txtLocId="+frmDpsWrkDone.txtLocId.value+" ";
   frmDpsWrkDone.txtSearchFields.value = "Labours.txtGangName";
   frmDpsWrkDone.txtInputField.value =""; 
   frmDpsWrkDone.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDpsWrkDone');
   return true;
}

function showLOVDepots()
{
   frmDpsWrkDone.lovKey.value = "CalcDpsWrkDoneLoc" + frmDpsWrkDone.screenName.value + frmDpsWrkDone.screenMode.value;   
   frmDpsWrkDone.txtDisplayFields.value = "txtLocId,txtLoc";
   frmDpsWrkDone.queryParam.value = "txtSiteID="+frmDpsWrkDone.loginLocCode.value;
   frmDpsWrkDone.txtSearchFields.value = "";
   frmDpsWrkDone.txtInputField.value =""; 
   frmDpsWrkDone.txtIndex.value ="";       
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDpsWrkDone');
   return true;
}

</script>


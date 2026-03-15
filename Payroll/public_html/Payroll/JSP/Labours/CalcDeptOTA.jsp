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
<html:form  action="CalcDeptOTAAction" name="frmDeptOTA" type="FCIPAY.Payroll.Labour.WEBTIER.Form.CalcDeptOTAForm" scope="session">
<bean:define id="ParentForm" name="frmDeptOTA" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>CALCULATE DEPARTMENTAL LABOUR OTA</TD>
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
          <TD class=subHeader colspan=6>Calculate OTA</TD>
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
                 <TABLE cellSpacing="0" cellPadding="0" border="0" >

  <tr>
              <!--<td width="33%">  </td>-->
              
              <td class="labelText"  width="15%" >Location</td>
              <td align="left"><html:text property="txtLoc" alt="P" maxlength="20" size="23" styleClass="required" readonly="false"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtPayCode" onclick=" showLOVDepots();"></td>
              <html:hidden property="txtLocId" />
              <td class="labelText"  width="15%" >Gang</td>
              <td align="left"><html:text property="txtGangName" alt="P" maxlength="20" size="23" styleClass="required" readonly="false"  /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="butTxtPayCode" onclick=" showLOVGang();"></td>
              <html:hidden property="txtGangId" />
               
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
        
               <td align=center bgcolor=#4682b4 width="30%"></td>
               <td  bgcolor=#4682b4><html:button value='Calculate OTA'  onclick="if(checkFields()){CalcOTA()}else{return false;}" property="butCalcOTA" styleClass="bottomBarText" /></td>
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
<html:hidden name="frmDeptOTA"  property="forwardedPage" />
<html:hidden name="frmDeptOTA"  property="screenMode" />
<html:hidden name="frmDeptOTA"  property="hdnAction" />
<html:hidden name="frmDeptOTA"  property="screenName" value="CalcDeptOTAScreen" />
<html:hidden property="loginLocCode" name="frmDeptOTA"  />

<html:hidden property="lovKey" name="frmDeptOTA"  />
<html:hidden property="txtFields" name="frmDeptOTA"  />   
<html:hidden property="txtSearchFields" name="frmDeptOTA"  />
<html:hidden property="txtDisplayFields" name="frmDeptOTA"  />
<html:hidden property="txtIndex" name="frmDeptOTA"  />
<html:hidden property="txtInputField" name="frmDeptOTA"  />

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
      frmDeptOTA.hdnAction.value='';
  }

  if (frmDeptOTA.hdnAction.value=='S') 
  {
     frmDeptOTA.hdnAction.value='SUB';
     CalcOTA(); 
  }

      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";       
    
}
  


function doQueryMode()
{
  frmDeptOTA.hdnAction.value='Q'
  frmDeptOTA.action="../../../CalcDeptOTAQuery.do"
  frmDeptOTA.submit();
}
  


  function CalcOTA()
  {
      if (frmDeptOTA.hdnAction.value != 'SUB') 
      {
        frmDeptOTA.hdnAction.value = 'S'; 
        frmDeptOTA.action = "../../../CalcDeptOTA.do";
        frmDeptOTA.submit();
      }
      else
      {
        frmDeptOTA.hdnAction.value='SUB';       
        frmDeptOTA.action = "../../../CalcDeptOTA.do";
        frmDeptOTA.submit();
      }      
  }

function checkFields()
{
    
    if(document.all.txtLoc.value=='')
    {
      if(document.all.txtGangName.value=='')
      {
        return confirm("This will calculate OTA for all the labours under the Login Location");
      }
    }
    else
    {
      if(document.all.txtGangName.value=='')
      {
        return confirm("This will calculate OTA for all the labours of selected Location");
      }
    }
}

function showLOVGang()
{   
   frmDeptOTA.lovKey.value = "CalcOTAGang" + frmDeptOTA.screenName.value + frmDeptOTA.screenMode.value;   
   frmDeptOTA.txtDisplayFields.value = "txtGangId,txtGangName,txtLocId,txtLoc";
   frmDeptOTA.queryParam.value = "txtSiteID="+frmDeptOTA.loginLocCode.value+",txtLbrType=DEP,txtLocId="+frmDeptOTA.txtLocId.value+" ";
   frmDeptOTA.txtSearchFields.value =  "Labours.txtGangName";
   frmDeptOTA.txtInputField.value =""; 
   frmDeptOTA.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptOTA');
   return true;
}

function showLOVDepots()
{
   frmDeptOTA.lovKey.value = "CalcOTALoc" + frmDeptOTA.screenName.value + frmDeptOTA.screenMode.value;   
   frmDeptOTA.txtDisplayFields.value = "txtLocId,txtLoc";
   frmDeptOTA.queryParam.value = "txtSiteID="+frmDeptOTA.loginLocCode.value;
   frmDeptOTA.txtSearchFields.value = "";
   frmDeptOTA.txtInputField.value =""; 
   frmDeptOTA.txtIndex.value ="";       
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptOTA');
   return true;
}

</script>


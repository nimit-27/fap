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
<html:form  action="CalcDeptIncentiveParamAction" name="frmDeptIncentive" type="FCIPAY.Payroll.Labour.WEBTIER.Form.CalcDeptIncentiveForm" scope="session">
<bean:define id="ParentForm" name="frmDeptIncentive" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>CALCULATE DEPARTMENTAL LABOUR INCENTIVE FOR <bean:write name="frmDeptIncentive" property="payYYMM" /></TD>
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
          <TD class=subHeader colspan=6>Calculate Incentive</TD>
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
              
              <td class="labelText"  width="15%" >From Date</td>
              <td align="left"><html:text property="txtFrom" alt="P" maxlength="20" size="23" styleClass="required" readonly="true"  /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="txtFrom"  onclick="showCalendar('txtFrom',this)" /></td>
             
              <td class="labelText"  width="15%" >To Date</td>
              <td align="left"><html:text property="txtTo" alt="P" maxlength="20" size="23" styleClass="required" readonly="true"  /><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="txtTo"  onclick="showCalendar('txtTo',this)" /></td>
              
        
      <html:hidden property="txtGangId" />
       <html:hidden property="txtLocId" />
   	 <TR height="50"><td>&nbsp;</td></tr>
   
        </tr>
                    
        		    </TABLE>
            </td>
               </tr>

<!-- Tab table Row 3 starts -->

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
               <td  bgcolor=#4682b4><html:button value='Calculate Incentive'  onclick="if(checkFields()){CalcIncentive()}else{return false;}" property="butCalcIncentive" styleClass="bottomBarText" /></td>
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
<html:hidden name="frmDeptIncentive"  property="screenFlag" value="Y" />

<html:hidden name="frmDeptIncentive"  property="forwardedPage" />
<html:hidden name="frmDeptIncentive"  property="screenMode" />
<html:hidden name="frmDeptIncentive"  property="hdnAction" />
<html:hidden name="frmDeptIncentive"  property="screenName" value="CalcDeptIncentiveParamScreen" />
<html:hidden property="loginLocCode" name="frmDeptIncentive"  />

<html:hidden property="lovKey" name="frmDeptIncentive"  />
<html:hidden property="txtFields" name="frmDeptIncentive"  />   
<html:hidden property="txtSearchFields" name="frmDeptIncentive"  />
<html:hidden property="txtDisplayFields" name="frmDeptIncentive"  />
<html:hidden property="txtIndex" name="frmDeptIncentive"  />
<html:hidden property="txtInputField" name="frmDeptIncentive"  />

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
      frmDeptIncentive.hdnAction.value='';
  }

  if (frmDeptIncentive.hdnAction.value=='S') 
  {
     frmDeptIncentive.hdnAction.value='SUB';
     CalcIncentive(); 
  }

      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";       
}
  


function doQueryMode()
{
  frmDeptIncentive.hdnAction.value='Q'
  frmDeptIncentive.action="../../../CalcDeptIncentiveParamQuery.do"
  frmDeptIncentive.submit();
}

function CalcIncentive()
{
     if(!(mandatory_Check('frmDeptIncentive')))
        return false;
     if(!validateDate())
        return false;
    if (frmDeptIncentive.hdnAction.value != 'SUB') 
    {
      frmDeptIncentive.hdnAction.value = 'S'; 
      frmDeptIncentive.action = "../../../CalcDeptIncentiveParam.do";
      frmDeptIncentive.submit();
    }
    else
    {
      frmDeptIncentive.hdnAction.value='SUB';       
      frmDeptIncentive.action = "../../../CalcDeptIncentiveParam.do";
      frmDeptIncentive.submit();
    }      
}

function checkFields()
{
  /*  if(document.all.txtLoc.value=='')
    {
      if(document.all.txtGangName.value=='')
      {
        return confirm("This will calculate Incentive for all the labours under the Login Location");
      }
    }
    else
    {
      if(document.all.txtGangName.value=='')
      {
        return confirm("This will calculate Incentive for all the labours of selected Location");
      }
    } */
    return true;
   
}

function showLOVGang()
{   
   frmDeptIncentive.lovKey.value = "CalcIncentiveGang" + frmDeptIncentive.screenName.value + frmDeptIncentive.screenMode.value;   
   frmDeptIncentive.txtDisplayFields.value = "txtGangId,txtGangName,txtLocId,txtLoc";
   frmDeptIncentive.queryParam.value = "txtSiteID="+frmDeptIncentive.loginLocCode.value+",txtLbrType=DEP,txtLocId="+frmDeptIncentive.txtLocId.value+" ";
   frmDeptIncentive.txtSearchFields.value = "Labours.txtGangName";
   frmDeptIncentive.txtInputField.value =""; 
   frmDeptIncentive.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptIncentive');
   return true;
}

function showLOVDepots()
{
   frmDeptIncentive.lovKey.value = "CalcIncentiveLoc" + frmDeptIncentive.screenName.value + frmDeptIncentive.screenMode.value;   
   frmDeptIncentive.txtDisplayFields.value = "txtLocId,txtLoc";
   frmDeptIncentive.queryParam.value = "txtSiteID="+frmDeptIncentive.loginLocCode.value;
   frmDeptIncentive.txtSearchFields.value = "";
   frmDeptIncentive.txtInputField.value =""; 
   frmDeptIncentive.txtIndex.value ="";       
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptIncentive');
   return true;
}

function validateDate()
{
  var fromDt=document.all.txtFrom.value;
  var toDt=document.all.txtTo.value;
  var arrFrom=fromDt.split("-");
  var arrTo=toDt.split("-");
  if(arrFrom[1]==arrTo[1] && arrFrom[2]==arrTo[2])
  {
   return true;
  }
  alert("Please Select Correct From & To Date");
  return false;
}
</script>


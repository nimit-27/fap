<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<%@ page import="java.lang.String" %>
<%
    String lbrType = (String)session.getAttribute("hdnEmpLbrFlag"); 
%>
<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>

</head>

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" >
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="ReportLinkerAction" name="PaySlipReportForm" type="FCIPAY.Payroll.WEBTIER.Form.PaySlipReportForm" scope="session" >
<bean:define id="ParentForm" name="PaySlipReportForm" toScope="request" />

<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />


<enrgise:errors/>
<logic:messagesPresent message="true">
<Table>
    <html:messages id="message" message="true">
    <TR><TD>
      <bean:write name="message"/>
    </TD></TR>
    </html:messages>
</Table>
</logic:messagesPresent>
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>Total Earning Summary Report</TD>
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
          <TD class=subHeader colspan=6> Total Earning Summary Report</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
           
   	 </table>

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="100">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
          
             
              <table border=0 cellpadding=0>
              <center>
              <TR height=60>
         
		<!-- Detail table Container starts -->
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.PaySlip.Year" /></td><td colspan=2>
              <html:text  property="txtYYMM"  maxlength="6" size="23" styleClass="required"  
                

                onblur="                                                  
                       if(!(chk_YearMonth()))
                          {
                          }                                            
              " 
              />
              </td>
      
              </tr>
              <tr>

                <td class="labelText">Location/Depot Name</td>
                <td><html:text  property="txtLocId" maxlength="10" styleClass="optional" readonly="true" />            
                        <logic:equal name="PaySlipReportForm" property="screenMode" value="U" >            
                        <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" >
                        </logic:equal>            
                        <logic:notEqual name="PaySlipReportForm" property="screenMode" value="U" >
                        <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" onclick="return ShowSite();" >
                        </logic:notEqual>            
                        <html:text  property="txtLoc" maxlength="10" styleClass="locked" readonly="true" />
                </td>

                <%if(!lbrType.equals("N")){%>
                <td class="labelText">Gang Name</td>
                <td>
                        <logic:equal name="PaySlipReportForm" property="screenMode" value="Q" >
                                <html:text  property="txtGangName" maxlength="50" styleClass="optional" readonly="true" />
                                <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
                        </logic:equal>
                        <logic:equal name="PaySlipReportForm" property="screenMode" value="N" >
                                <html:text  property="txtGangName" maxlength="10" styleClass="required" />            
                        </logic:equal>
                        <logic:equal name="PaySlipReportForm" property="screenMode" value="U" >
                                <html:text  property="txtGangName" maxlength="10" styleClass="required" readonly="true" />            
                        </logic:equal>
                </td>
                <%}%>
              </tr>
              <html:hidden property="headerPrimaryKey" />
              </center>
              </table>

              <table border=0 cellpadding=0>
              <TR height=40>
                <td width=25% >
                <TD class=labelText width="20%" >                
                <bean:message key="Payroll.PaySlip.EmpNumber"  />  
                <td  align="left"><html:text  property="txtEmp" maxlength="10" size="20" styleClass="optional"  readonly="true" />
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovEmpNo();" >
                <html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" /></td>
                </td>
                </tr>           
           
                <tr height="15" >
            <td colspan="4"></td>
         </tr>
         
              </table>
            
        
               

<!-- Tab table Row 3 starts -->

  <TR>
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../includes/images/pixel.gif" width=1  border=0></TD>
    </TR>
         <tr height="15" >
            <td colspan="16"></td>
         </tr>

      <TR>
               <td align=center bgcolor=#4682b4 width="37%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE PAY SLIP REPORT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
               <td width="45%" bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	


                   
                </table>
            </td>
          </tr>
        
  
</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript">
function doGetReport()
{  
if(mandatory_Check('PaySlipReportForm'))
{
	var lbr_flag = PaySlipReportForm.hdnEmpLbrFlag.value;
	if (lbr_flag == 'L')
	{
		var winurl="CR236.rdf&P_EMP_NUM="+PaySlipReportForm.txtEmp.value+"&P_YYMM="+PaySlipReportForm.txtYYMM.value+"&P_LOCATION_CODE="+PaySlipReportForm.loginLocCode.value+"&P_EMP_FLG="+PaySlipReportForm.hdnEmpLbrFlag.value+"&P_Depot_CODE="+PaySlipReportForm.txtLocId.value+"&P_Gang_CODE="+PaySlipReportForm.headerPrimaryKey.value;
	}
	else
	{
		var winurl="CR236.rdf&P_EMP_NUM="+PaySlipReportForm.txtEmp.value+"&P_YYMM="+PaySlipReportForm.txtYYMM.value+"&P_LOCATION_CODE="+PaySlipReportForm.loginLocCode.value+"&P_EMP_FLG="+PaySlipReportForm.hdnEmpLbrFlag.value+"&P_Depot_CODE="+PaySlipReportForm.txtLocId.value+"&P_Gang_CODE="+PaySlipReportForm.headerPrimaryKey.value;
	}
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.PaySlipReportForm.submit();
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="PaySlipReportForm"  property="screenMode"/>
    <html:hidden name="PaySlipReportForm"  property="screenName" value="PaySlipDepReport" />
    <html:hidden property="buttonFlag" name="PaySlipReportForm"  />
    <html:hidden property="txtAllEmpFlag" name="PaySlipReportForm"  />  
<!--    <html:hidden property="txtEmp" name="PaySlipReportForm"  />    -->
    <html:hidden property="txtEmpName" name="PaySlipReportForm"  />          
	<html:hidden property="txtCpfCode" name="PaySlipReportForm"  />

    <html:hidden property="hdnMaxYYMM" name="PaySlipReportForm"  />    
    <html:hidden property="lovKey" name="PaySlipReportForm"  />
    <html:hidden property="txtFields" name="PaySlipReportForm"  />   
    <html:hidden property="txtSearchFields" name="PaySlipReportForm"  />
    <html:hidden property="txtDisplayFields" name="PaySlipReportForm"  />
    <html:hidden property="txtIndex" name="PaySlipReportForm"  />
	<html:hidden property="txtInputField" name="PaySlipReportForm"  />
    
    <html:hidden property="hdnLoginUserId" name="PaySlipReportForm"  />    
    <html:hidden property="hdnPayUser" name="PaySlipReportForm"  />        
    <html:hidden property="hdnLoginUserName" name="PaySlipReportForm"  />
    <html:hidden property="loginLocCode" name="PaySlipReportForm"  />
<html:hidden property="txtType" name="PaySlipReportForm" />
    <html:hidden property="txtMou" name="PaySlipReportForm" />

    <input type="hidden" name="queryParam" />    
    <input type="hidden" id="submitParam" name="submitParam" />   
</html:form>
</body>
</html:html>



<script language="javascript">

function lfnLoad()
{  
/*  if(PaySlipReportForm.firstLoad.value=="")
  {
   doBaseOnLoad();    
  } */

  mode=document.all.screenMode.value;
  disableMenu();

if(document.all.hdnEmpLbrFlag.value=='L')
  {
    document.all.txtType.value="DEP";
  }
  else if(document.all.hdnEmpLbrFlag.value=='D')
  {
    document.all.txtType.value="DPS";
  }
  else
  {
    document.all.txtType.value="KOT";
  }

  if(mode != 'Q' )
  {
    PaySlipReportForm.action="../../../TotalEarningGetAccess.do"
    PaySlipReportForm.submit();  
  }
}

function ShowLovYYMM()
{
        PaySlipReportForm.queryParam.value="hdnMaxYYMM="+ PaySlipReportForm.hdnMaxYYMM.value +" " ;    
        PaySlipReportForm.lovKey.value = "ReportGeneratePaySlipYear" + PaySlipReportForm.screenName.value + "U";
        PaySlipReportForm.txtSearchFields.value = "Payroll.PaySlip.Year";
        PaySlipReportForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PaySlipReportForm');

        
        return true;
}
function ShowSite()
{
	document.all.txtGangName.value="";

   PaySlipReportForm.lovKey.value = "GangDepot" + PaySlipReportForm.screenName.value + PaySlipReportForm.screenMode.value;
   PaySlipReportForm.queryParam.value="txtSiteID="+PaySlipReportForm.loginLocCode.value;
   //alert(PaySlipReportForm.queryParam.value)
   PaySlipReportForm.txtDisplayFields.value = "txtLocId,txtLoc";
   PaySlipReportForm.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   PaySlipReportForm.txtIndex.value=""; 
   PaySlipReportForm.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'PaySlipReportForm');
   return true;
}

function ShowLovGang()
{
   PaySlipReportForm.queryParam.value="txtLocId= "+ PaySlipReportForm.txtLocId.value +",txtSiteID="+PaySlipReportForm.loginLocCode.value+",txtType="+PaySlipReportForm.txtType.value;    
   //alert(PaySlipReportForm.queryParam.value)
   PaySlipReportForm.lovKey.value = "GangName" + PaySlipReportForm.screenName.value + PaySlipReportForm.screenMode.value;
   PaySlipReportForm.txtDisplayFields.value = "headerPrimaryKey,txtGangName,txtLocId,txtLoc,txtType,txtMou";
   PaySlipReportForm.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
   PaySlipReportForm.txtIndex.value="";
   PaySlipReportForm.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'PaySlipReportForm');
   return true;
}  

function ShowLovEmpNo()
{
		var gng= PaySlipReportForm.txtLocId.value;
		var dpt=PaySlipReportForm.headerPrimaryKey.value;
		
		if (gng == '')
			gng=0;
		if (dpt == '')
			dpt=0;

        PaySlipReportForm.lovKey.value = "ReportGeneratePaySlipEmp" + PaySlipReportForm.screenName.value + "U";
        PaySlipReportForm.queryParam.value="txtSiteID="+ PaySlipReportForm.loginLocCode.value +",hdnEmpLbrFlag="+PaySlipReportForm.hdnEmpLbrFlag.value +",txtLocId="+dpt+",headerPrimaryKey="+gng;
		//alert(PaySlipReportForm.queryParam.value)
        PaySlipReportForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
        PaySlipReportForm.txtDisplayFields.value = "txtEmp,txtEmpName,txtCpfCode";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','PaySlipReportForm');
        return true;
}

function chk_YearMonth()
{
            
     var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6);  
     var  maxYYMM = document.getElementById("hdnMaxYYMM").value;    
    if(yearM!=""){
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 6)
        {        
            alert(" Year Month should be a Six digit Number");
            document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
        else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;
        }
        else
        {
            return true;
        }
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

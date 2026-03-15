<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="FCIPAY.Payroll.common.utility.ReportReader" %>
<%@ page import="FCIPAY.Payroll.common.utility.ParamUtil" %>
<%@ page import="java.lang.String" %>

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

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="ReportLinkerAction" name="AnnualCPFReportForm" type="FCIPAY.Payroll.WEBTIER.Form.AnnualCPFReportForm" scope="session" >
<bean:define id="ParentForm" name="AnnualCPFReportForm" toScope="request" />

<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

  <html:errors/>

<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="headerDataChanged" value="false" />

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>ONLINE PF SLIP</TD>
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
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../includes/images/pixel.gif" width=1 border=0></TD>
	      </TR>

         
   	 </table>

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="100">
            <TD colspan=11>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
          
             
              <table border=0 cellpadding=0>
             
                    <TR height=25>         
                    <!-- Detail table Container starts -->
					<td width=5% >
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.MaintPfDetail.FromYr" /></td><td >
                    <html:text  property="txtFrYYYY"  maxlength="6" size="23" styleClass="required"  
                    onchange="                                                  
                    if(!(chk_YearMonth('txtFrYYYY')))
                    {
                    }                                            
                    " 
                    
                    onblur="                                                  
                    if(!(chk_YearMonth('txtFrYYYY')))
                    {
                    }                                            
                    " 
                    />
                    </td>              
					</td>
                  </tr>
 </table>
                  <table border=0 cellpadding=0>
                  <tr height=25>
				  <td width=5% >
                    <td class="labelText"  width="40%" align="center"><bean:message key="Payroll.MaintPfDetail.ToYr" /></td><td >
                    <html:text  property="txtToYYYY"  maxlength="6" size="23" styleClass="required"  
                    onchange="                                                  
                    if(!(chk_YearMonth('txtToYYYY')))
                    {
                    }                                            
                    " 
                    
                    onblur="                                                  
                    if(!(chk_YearMonth('txtToYYYY')))
                    {
                    }                                            
                    " 
                    />
                    </td>
					</td>
                  </tr>
              
                </table>
              
                <table border=0 cellpadding=0>
                <TR height=25>
                <td width=25% >
                <TD class=labelText width="20%" >                
                <bean:message key="Payroll.PaySlip.EmpNumber"  />  
                <td  align="left">
                <html:text  property="txtEmpNo" maxlength="10" size="23" styleClass="required"  readonly="true" />
               
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovEmpNo();" >
                <html:text property="txtEmpName"  size="35" value="" styleClass="locked" readonly="true" /></td>
                
                </td>
                 
                </tr>         
           
                      
              </table>
           
           <table border=0 cellpadding=0>
              <center>
              <TR height=25>
         
		<!-- Detail table Container starts -->
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.PaySlip.AccessKey" /></td><td colspan=2>
              <html:password  property="txtCPFDDYYMM" maxlength="20"    size="23"  styleClass="required"   onchange="                                                  
                       if(!(chk_CPFYearMonth()))
                          {
                          }                                            
              "  />
              <bean:message key="Payroll.MaintDARates.cpf@ddmmyyyy" />
              </td>      
              </tr>
              </center>
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
               <td  bgcolor=#4682b4><html:button value='GENERATE ONLINE PF SLIP'  onclick="validateUser();" property="butInsert" styleClass="bottomBarText" /></td>
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

function validateUser()
{
	//alert('inside validateUser' +AnnualCPFReportForm.txtSiteCode.value )
	AnnualCPFReportForm.headerDataChanged.value="true";
	AnnualCPFReportForm.screenMode.value="N";
	AnnualCPFReportForm.action = "../../../ValidateUserSaveActionCPF.do";
	AnnualCPFReportForm.submit();
}

function doGetReport()
{  

	//alert('inside doGetReport ')
if(mandatory_Check('AnnualCPFReportForm'))
{
	chk_CPFYearMonth();
    var winurl="pf.rdf&P_EMP_NUM="+AnnualCPFReportForm.txtEmpNo.value+"&P_FYEAR="+AnnualCPFReportForm.txtFrYYYY.value+"&p_TYEAR="+AnnualCPFReportForm.txtToYYYY.value+"&P_LOCATION="+AnnualCPFReportForm.txtSiteCode.value;
	document.getElementById('butInsert').value="Please wait. File is being downloaded..";
	document.getElementById('butInsert').disabled="true";
	document.getElementById('submitParam').value = winurl;
	document.AnnualCPFReportForm.submit();
 }
 else{
 return false;
 }
}
</script>

	 
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="AnnualCPFReportForm"  property="screenMode"/>
    <html:hidden name="AnnualCPFReportForm"  property="screenName" value="AnnualCPFReport" />
    <html:hidden property="buttonFlag" name="AnnualCPFReportForm"  />
    <html:hidden property="txtAllEmpFlag" name="AnnualCPFReportForm"  />  

    <html:hidden property="hdnMaxYYMM" name="AnnualCPFReportForm"  />    
    <html:hidden property="lovKey" name="AnnualCPFReportForm"  />
    <html:hidden property="txtFields" name="AnnualCPFReportForm"  />   
    <html:hidden property="txtSearchFields" name="AnnualCPFReportForm"  />
    <html:hidden property="txtDisplayFields" name="AnnualCPFReportForm"  />
    <html:hidden property="txtIndex" name="AnnualCPFReportForm"  />
    <html:hidden property="hdnLoginUserId" name="AnnualCPFReportForm"  />    
    <html:hidden property="hdnPayUser" name="AnnualCPFReportForm"  />        
    <html:hidden property="hdnLoginUserName" name="AnnualCPFReportForm"  />
    <html:hidden property="loginLocCode" name="AnnualCPFReportForm"  />
    <html:hidden property="txtInputField" name="AnnualCPFReportForm"  />

	<html:hidden property="txtCpfCode" name="AnnualCPFReportForm"  />
	<html:hidden property="txtSiteCode" name="AnnualCPFReportForm"/>
    <html:hidden property="txtSiteDesc" name="AnnualCPFReportForm"  />
	<html:hidden property="txtUserFlag" name="AnnualCPFReportForm"  />

	<input type="hidden" name="queryParam" />
	<input type="hidden" id="submitParam" name="submitParam" />       
    
</html:form>
</body>
</html:html>

<script language="javascript">

function lfnLoad()
{  
  mode=document.all.screenMode.value; 

  disableMenu();
  if(mode == 'N' )
  {
    //AnnualCPFReportForm.action="../../../CPFSlipGetAccess.do"
    //AnnualCPFReportForm.submit();  
	doGetReport();
  }
   else if(mode != 'N' && mode != 'Q' )
  {
    AnnualCPFReportForm.action="../../../CPFSlipGetAccess.do"
    AnnualCPFReportForm.submit();  
  }
}

function ShowLovEmpNo()
{
   AnnualCPFReportForm.lovKey.value = "EmpFinInfo" + AnnualCPFReportForm.screenName.value + AnnualCPFReportForm.screenMode.value;   
   AnnualCPFReportForm.queryParam.value="txtSiteID="+ AnnualCPFReportForm.loginLocCode.value +",hdnEmpLbrFlag="+AnnualCPFReportForm.hdnEmpLbrFlag.value ;
   AnnualCPFReportForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.EmpName,Payroll.Common.cpfCode,Payroll.common.SiteCode,Payroll.common.SiteDesc,Payroll.common.UserFlag";
   AnnualCPFReportForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode,txtSiteCode,txtSiteDesc,txtUserFlag";    
   AnnualCPFReportForm.txtIndex.value = 0;
   AnnualCPFReportForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CreateSearchScreen.jsp" />', 'AnnualCPFReportForm');
   return true;
}
function showLov(pageName, formName) {
    var oLovWin=window.open(pageName,formName, "height=500,width=900,resizable=yes,menubar=no,toolbar=none,statusbar=none");
    oLovWin.moveTo(200,200);
    //oLovWin.document.all.hdnLOVFlag.value = '0';
}

function chk_YearMonth(input)
{      
    var  yearM = document.getElementById(input).value;          
    //var month =  yearM.substring(4,6);    
    if (num_Check(yearM,1))
    {                                     
        if (yearM.length != 4)
        {        
            alert(" Year should be a four digit Number");
            document.getElementById(input).focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;            
        }        
     /*   else if(month < 1 || month > 12)
        {
            alert("  Month should be Within 1 to 12");
            document.getElementById(input).focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;
        } */
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

function chk_CPFYearMonth()
{

      var  EmpYYM = document.getElementById("txtCPFDDYYMM").value; 
      var searchIndex = parseInt(EmpYYM.indexOf("@"),10);
      var cpfNo=EmpYYM.substring(0,searchIndex);
      var dob=EmpYYM.substring(searchIndex+1,EmpYYM.length);
      
      if (searchIndex < 0)
        {
            alert("Invalid AccessKey!!!!!");                    
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
                return false;
    
        }
        
         if (dob.length != 8)
        {
            alert("DOB should be a Eight digit Number");                    
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }
	   
return true;
}
</script>

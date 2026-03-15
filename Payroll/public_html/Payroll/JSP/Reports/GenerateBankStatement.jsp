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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>   
</head>
<BODY scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


  <html:form  action="BankStatementBaseAction" name="GenerateBankStatementForm" type="FCIPAY.Payroll.WEBTIER.Form.GenerateBankStatementForm" scope="session">
<bean:define id="ParentForm" name="GenerateBankStatementForm" toScope="request" />
  <jsp:include page = "../INCLUDES/GenIconMenu.jsp" />


<html:errors/>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>GENERATE BANK STATEMENT </TD>
</TR>
</TABLE>
<!--container table starts-->

<TABLE cellSpacing=0 cellPadding=0 border=0 colspan=10 >
<TBODY>
  <TR>
    <TD>
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader > Generate Bank Statement</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

          <table border=0 cellpadding=0>
          <center>
          <TR height=60>
         <tr height="40" >
             <td class="labelText"  width="25%" align="right"><bean:message key="Payroll.CanteenSubsidy.YYMM" />
             </td>
             <td><html:text  property="txtYYMM"  maxlength="10" size="23" styleClass="required" readonly="false" onchange="chk_YearMonth(this); " /><img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" onclick="return ShowLovYYMM();" >
            <td width="25%" class=labelText><bean:message key="pay.Common.txtPayableDate" /></td>
         <td ><html:text  property="txtPayableDate" styleClass = "optional" altKey="pay.Common.txtPayableDate" maxlength="15" size="23" readonly = "true"  /><img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtPayableDate" onclick="showCalendar('txtPayableDate',this)" /></td>        
             
        <TR>                            
              </tr>
              </center>
              </table>

      <tr>
           <table border=0 cellpadding=0>
           <TR>                            
          <td width="20%" class="radioText" ><input type="radio" name="radioMisc" value="E" onclick="BankStClick()"   ><bean:message key="Payroll.BankStat.BankStatement"  />                
          <td width="20%" class="radioText" ><input type="radio" name="radioMisc" value="E" onclick="EcsClick()" ><bean:message  key="Payroll.BankStat.Ecs" />                
          <td width="20%" class="radioText" ><input type="radio" name="radioMisc" value="E" onclick="SwiftClick()" ><bean:message  key="Payroll.BankStat.Swift" />                          
          <td width="20%" class="radioText"><input type="radio" name="radioMisc" value="E" onclick="OthersClick()" ><bean:message  key="Payroll.BankStat.Others" />
          <td width="20%" class="radioText"><input type="radio" name="radioMisc" value="E" onclick="SummaryClick()" ><bean:message  key="Payroll.BankStat.BankSummary" />          
          <td colspan="3" ></td>          
            </TR>              
            <tr>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>            
          </tr>
            
        </table>
        </tr>

      <tr>
      <table border=2 cellpadding=0>          
      <tr>

        <td width>
              <table border=0 cellpadding=0>          
                <tr>
                     <td class="labelText"  width="25%" align="right"><bean:message key="pay.MaintBankMast.txtBankCode" />      
                     <td  align="left"><html:text  property="txtBankCode" maxlength="10" size="20" styleClass="optional"  />
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBankCodeNo" onclick="ShowLovBankCode();">&nbsp;&nbsp;
                     <html:text property="txtBankName"  size="35" value="" styleClass="locked" readonly="true" /></td>      
                    </tr>

                    <tr>
                     <td class="labelText"  width="25%" align="right"><bean:message key="Payroll.MaintBankMast.BranchCode" />      
                     <td  align="left"><html:text  property="txtBranchCode" maxlength="10" size="20" styleClass="optional"  />
                     <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtBranchCodeNo" onclick="ShowLovBranchCode();">&nbsp;&nbsp;
                     <html:text property="txtBranchName"  size="35" value="" styleClass="locked" readonly="true" /></td>      
                  </td>
                  </tr>
                </table>
          </td> 

        </tr>
      </table>
      </td>

            
      </tr>
      </table>
      </tr>
      
              
                    		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>

 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="60">
            <TD colspan=16>

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              
          
              
                
		<!-- Detail table Container starts -->
                <TD colspan="16">
                  <TABLE cellSpacing="0" cellPadding="0" border="0" >
                    
                    <TR>
                      <TD width = 30%></td>
  			<!-- Detail table starts -->
                      <TD width = 40%>        
                        
                   </TD>
                   <TD width = 30%></td>                   
                  </TR>                     
                                      
        		    </TABLE>
		  </td>
               </tr>

<!-- Tab table Row 3 starts -->
               <tr>
		
		</TR>
    <TR>
     <TD colspan=16 align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->

<!-- Bottom Blue Bar -->
        <TR>
               <td align=center bgcolor=#4682b4 width="37%"></td>
               <td  bgcolor=#4682b4><html:button value=' GENERATE STATEMENT'  onclick="doGetReport()" property="butInsert" styleClass="bottomBarText" /></td>
               <td bgColor=#4682b4></td>
               <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
	     </TR>
	
</TABLE>
 
<!-- Container Table Ending Columns Starts-->
    </TD>
    
</TR>
 <% ReportReader oReportReader=new ReportReader(); %> 
    <% ParamUtil oParamUtil=new ParamUtil(); %> 
   
<script language="javascript">

function doGetReport()
{
if(GenerateBankStatementForm.optReportType.value=='1')
  {
  var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
  window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateBankStatement","GenerateBankStatementkey").trim()%>&YYMM="+GenerateBankStatementForm.txtYYMM.value+"&bank_code="+GenerateBankStatementForm.txtBankCode.value+"&branch_code="+GenerateBankStatementForm.txtBranchCode.value+"&P_1="+GenerateBankStatementForm.txtPayableDate.value);
  }
if(GenerateBankStatementForm.optReportType.value=='2')
  {
  var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
  window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateBankStatement","GenerateECSReportkey").trim()%>&YYMM="+GenerateBankStatementForm.txtYYMM.value,'',win_option);
  }
if(GenerateBankStatementForm.optReportType.value=='3')
  {
  var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
  window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateBankStatement","GenerateSwiftReportkey").trim()%>&YYMM="+GenerateBankStatementForm.txtYYMM.value,'',win_option);
  }
if(GenerateBankStatementForm.optReportType.value=='4')
  {
  var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
  window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateBankStatement","GenerateOtherBankskey").trim()%>&YYMM="+GenerateBankStatementForm.txtYYMM.value+"&P_1="+GenerateBankStatementForm.txtPayableDate.value,'',win_option);
  }  
if(GenerateBankStatementForm.optReportType.value=='5')
  {
  var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
  window.open("http://<%=oReportReader.getAppServerName()%>:<%=oReportReader.getAppServerPortNumber()%>/<%=oReportReader.getAppServerReportPathAlias()%>/rwservlet?<%=oParamUtil.getKeyinfo("Payroll","GenerateBankStatement","GenerateBankSummarykey").trim()%>&YYMM="+GenerateBankStatementForm.txtYYMM.value,'',win_option);
  }
}

</script>

</TBODY>
</TABLE>

<!-- Container Table Ends -->

<html:hidden name="GenerateBankStatementForm"  property="screenName" value="GenerateBankStatement" />
  
<html:hidden property="screenMode" name="GenerateBankStatementForm" value="U" />
<html:hidden property="positionRequested" name="GenerateBankStatementForm" />
<html:hidden property="txtAllBankFlag" name="GenerateBankStatementForm"  />  
<html:hidden property="userPageRequested" name="GenerateBankStatementForm" />
<html:hidden property="userPositionRequested" name="GenerateBankStatementForm" />
<html:hidden property="pageRequested" name="GenerateBankStatementForm" />
<html:hidden property="headerDataChanged" name="GenerateBankStatementForm" />
<html:hidden property="detailDataChanged" name="GenerateBankStatementForm" />
<html:hidden property="lovKey" name="GenerateBankStatementForm"  />
<html:hidden property="optReportType" name="GenerateBankStatementForm"  />
<html:hidden property="txtSearchFields" name="GenerateBankStatementForm"  />
<html:hidden property="txtDisplayFields" name="GenerateBankStatementForm"  />
<html:hidden property="txtIndex" name="GenerateBankStatementForm"  />
<html:hidden property="headerPrimaryKey" name="GenerateBankStatementForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

 <script language="javascript">


function doSetFlag(val)
{ 
  GenerateBankStatementForm.txtAllBankFlag.value=val;   
     
  if(val=='B')
  {
    document.all.txtBankCode.style.background = "#ffffd3";
    document.all.txtBankCode.disabled="";
    document.all.txtBankCode.className="required";
  }
  else
  {
    document.all.txtBankCode.value="";
    document.all.txtBankName.value="";
    document.all.txtBankCode.style.background = "#e0e0e0";
    document.all.txtBankCode.disabled="true";
    document.all.txtBankCode.className="optional";
  }
     
}


function lfnLoad()
{  
  if(GenerateBankStatementForm.firstLoad.value=="")
  {
   doBaseOnLoad();
    
  }  
}
function doOnLoad()
{
  return  "BankStatementOnLoadAction.do";
}

 

function ShowLovBankCode()
{
       if (GenerateBankStatementForm.optReportType.value == "1")
       {
          GenerateBankStatementForm.lovKey.value = "GenerateBankStatementBankCode" + GenerateBankStatementForm.screenName.value + "U";
          GenerateBankStatementForm.txtSearchFields.value = "Payroll.BankStatement.BankCode,Payroll.Common.desc";
          GenerateBankStatementForm.txtDisplayFields.value = "txtBankCode,txtBankName";
          showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','GenerateBankStatementForm');
          return true;
      }
}

    function ShowLovBranchCode()
    {
       if (GenerateBankStatementForm.optReportType.value == "1")
       {
         GenerateBankStatementForm.queryParam.value="txtBankCode="+ GenerateBankStatementForm.txtBankCode.value +" " ;    
         GenerateBankStatementForm.lovKey.value = "GenerateBankStatementBranchCode" + GenerateBankStatementForm.screenName.value + "U";
         GenerateBankStatementForm.txtDisplayFields.value = "txtBranchCode,txtBranchName";
         GenerateBankStatementForm.txtSearchFields.value = "Payroll.EmpInfo.BranchCode,Payroll.Common.desc";
         GenerateBankStatementForm.txtIndex.value="";  
         showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'GenerateBankStatementForm');
         return true;
      }
    }    


function ShowLovYYMM()
{
        GenerateBankStatementForm.lovKey.value = "ReportGenerateBankStatementYear" + GenerateBankStatementForm.screenName.value + "U";
        GenerateBankStatementForm.txtSearchFields.value = "Payroll.CanteenSubsidy.YYMM";
        GenerateBankStatementForm.txtDisplayFields.value = "txtYYMM";
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />','GenerateBankStatementForm');
        return true;
}

function BankStClick()
{
    GenerateBankStatementForm.optReportType.value="1";
    document.all.txtBankCode.disabled="";    
   document.all.txtBranchCode.disabled="";    
}

function EcsClick()
{
    GenerateBankStatementForm.optReportType.value="2";
    document.all.txtBankCode.disabled="true";
    document.all.txtBranchCode.disabled="true";        
}

function SwiftClick()
{
    GenerateBankStatementForm.optReportType.value="3";
    document.all.txtBankCode.disabled="true";
    document.all.txtBranchCode.disabled="true";            
}

function OthersClick()
{
    GenerateBankStatementForm.optReportType.value="4";
    document.all.txtBankCode.disabled="true";
    document.all.txtBranchCode.disabled="true";            
}

function SummaryClick()
{
    GenerateBankStatementForm.optReportType.value="5";
    document.all.txtBankCode.disabled="true";
    document.all.txtBranchCode.disabled="true";            
}

function chk_YearMonth(that)
{
       var yearM = that.value;
       var month =  yearM.substring(4,6);
      
    if (num_Check(yearM,1))
     {                                   
        if (yearM.length != 6)
        {
        alert(" Year Month should be a Six digit Number");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

      else if(month <1 || month >12 )
       {
           alert("  Month should be Within 1 to 12 ");
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


</script>

<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic"%>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ page import="java.lang.String"%>
<html:html>
    <head>
        <html:base/>
        <title>
            <bean:message key="Payroll.title"/>
        </title>
        <jsp:include page="../INCLUDES/GenIncludes.jsp"/>
        <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css"/>
        <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
        <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
        <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
        <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
    </head>
    <body onload="lfnLoad()" scroll="no" onbeforeunload="confWindowClose()" onunload="handleOnClose()"
          oncontextmenu="return false">
        <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true"/>
         
        <!--PaySlipBaseAction-->
         
        <html:form action="ReportLinkerAction" name="EmpPrmsReportForm"
                   type="FCIPAY.Payroll.WEBTIER.Form.EmpPrmsReportForm" scope="session">
            <bean:define id="ParentForm" name="EmpPrmsReportForm" toScope="request"/>
            <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
            <errors/>
            <logic:messagesPresent message="true">
                <table>
                    <html:messages id="message" message="true">
                        <tr>
                            <td>
                                <bean:write name="message"/>
                            </td>
                        </tr>
                    </html:messages>
                </table>
            </logic:messagesPresent>
            <html:hidden property="detailDataChanged"/>
            <html:hidden property="headerFields" value="false"/>
            <table>
                <tr height="30">
                    <td colspan="12" class="mainHeader" height="10">PRMS MEDICAL CLAIM REPORT</td>
                </tr>
            </table>
            <table cellspacing="0" cellpadding="0" border="0">
                <tbody>
                    <tr>
                        <td>
                            <!-- Body table Starts -->
                            <table cellspacing="0" cellpadding="0">
                                <!--Account  Header Row Starts -->
                                <tr>
                                    <td class="subHeader" colspan="6">PRMS Medical Claim Report</td>
                                </tr>
                                 
                                <tr>
                                    <td colspan="6" bgcolor="#4682b4">
                                        <img height="1" src="../includes/images/pixel.gif" width="1" border="0"></img>
                                    </td>
                                </tr>
                                 
                                <tr height="15">
                                    <td colspan="2"></td>
                                </tr>
                            </table>
                            <table cellspacing="0" cellpadding="0" border="0">
                                <!-- Detail Information Row starts -->
                                <tr height="100">
                                    <td colspan="11">
                                        <!-- Account Config Detail Table Starts -->
                                        <table cellspacing="0" cellpadding="0">
                                            <table border="0" cellpadding="0">
                                                <center>
                                                    <tr height="60">
                                                        <!-- Detail table Container starts -->
                                                        <td align="center" width="45%" class="labelText">Financial Year</td>
                                                        <td colspan="2">
                                                            <html:text property="txtFinYear" maxlength="6" size="23"
                                                                       styleClass="required"/>
                                                             (YYYYYY)
                                                        </td>
                                                    </tr>
                                                </center>
                                                 
                                                <tr>
                                                    <td width="30%" align="center" class="labelText">
                                                        Employee wise
                                                        <input type="radio"  property="txtRepMode" name="radioAll" value="S"
                                                               onclick=" SetMode(1);"></input>
                                                    </td>
                                                    <td class="labelText">
                                                        <bean:message key="Payroll.PaySlip.EmpNumber"/>
                                                    </td>
                                                    <td align="left">
                                                        <html:text property="txtEmpNum" maxlength="10" size="20"
                                                                   styleClass="optional" onchange="if(!(checkEmployee(EmpPrmsReportForm.txtEmpNum.value,EmpPrmsReportForm.loginLocCode.value)))
                      {
                        EmpPrmsReportForm.txtEmpNum.value='';
                      }"/>
                                                         
                                                        <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center"
                                                             property="buttxtFinYear" onclick="if(CheckMode())
                        {
                        return ShowLovEmpNo();
                        }"></img>
                                                         
                                                        <html:text property="txtEmpName" size="35" value=""
                                                                   styleClass="locked" readonly="true"/>
                                                    </td>
                                                </tr>
                                                <tr>
                        <td width="30%" align="center" class="labelText">
                            Site wise 
                            <input type="radio" property="txtRepMode" name="radioAll" value="R" onclick=" SetMode(2);"></input>
                        </td>
                    </tr>
                                            </table>
                                        </table>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table>
            <table border="0" cellpadding="0">
                <tr height="15">
                    <td colspan="4"></td>
                </tr>
                 <TR>
                  <td class=labelText style="color:blue"   width="20000" >* NOTE : Please Enter Employee details while searching for employee</td>
                </tr>
                <!-- Tab table Row 3 starts -->
                 
                <tr>
                    <td align="right" bgcolor="#4682b4" colspan="8">
                        <img height="1" src="../includes/images/pixel.gif" width="1" border="0"></img>
                    </td>
                </tr>
                 
                <tr height="15">
                    <td colspan="16"></td>
                </tr>
                 
                <tr>
                    <td align="center" bgcolor="#4682b4" width="37%"></td>
                    <td bgcolor="#4682b4" id="genrptid">
                        <html:button value='GENERATE REPORT' onclick="return doGetReport();" property="butInsert"
                                     styleClass="bottomBarText"/>
                    </td>
                    <td width="45%" bgcolor="#4682b4"></td>
                    <td align="right" bgcolor="#4682b4">
                        <img src="../INCLUDES/IMAGES/man.jpg"></img>
                    </td>
                </tr>
            </table>
            <!-- Tab Table Ends -->
            <script language="javascript">
              function doGetReport() { /*alert("This Site Is Under Maintainance Kindly Retry Later...");
              return false;*/
                  if (mandatory_Check('EmpPrmsReportForm')) {
                      var lbr_flag = EmpPrmsReportForm.hdnEmpLbrFlag.value;
                      if (lbr_flag == 'E') 
                      {
                         if (document.all.txtRepMode.value == "E") 
                         {
                            if (document.all.txtEmpNum.value==""||document.all.txtEmpNum.value==null)
                            {
                                alert("Please select Employee number");
                                return false;
                            }
                            else 
                             {
                            var winurl = 'Prms_mediclaim_emp.rdf&P_EMP_NUM=' + EmpPrmsReportForm.txtEmpNum.value + '&P_LOC_ID=' + EmpPrmsReportForm.loginLocCode.value + '&P_EMP_TYPE=' + EmpPrmsReportForm.hdnEmpLbrFlag.value + '&P_FIN_YEAR=' + EmpPrmsReportForm.txtFinYear.value;
                            }
                            
                         }
                         else
                         {
                            var winurl = 'Prms_mediclaim_site.rdf&P_LOC_ID=' + EmpPrmsReportForm.loginLocCode.value + '&P_EMP_TYPE=' + EmpPrmsReportForm.hdnEmpLbrFlag.value+'&P_FIN_YEAR=' + EmpPrmsReportForm.txtFinYear.value;
                         /*alert(winurl);*/
                         }
                          document.getElementById('butInsert').value = "Please wait. File is being downloaded..";
                          document.getElementById('butInsert').disabled = "true";
                          document.getElementById('submitParam').value = winurl;
                          document.EmpPrmsReportForm.submit();
                      }
                      else 
                          return false;
                  }
                  else {
                      return false;
                  }
              }
            </script>
            <html:hidden name="EmpPrmsReportForm" property="screenMode"/>
            <html:hidden name="EmpPrmsReportForm" property="screenName" value="PrmsMediClaimReport"/>
            <html:hidden property="buttonFlag" name="EmpPrmsReportForm"/>
            <html:hidden property="txtAllEmpFlag" name="EmpPrmsReportForm"/>
            <html:hidden property="txtEmpName" name="EmpPrmsReportForm"/>
            <html:hidden property="txtRepMode" name="EmpPrmsReportForm"/>
            <html:hidden property="txtCpfCode" name="EmpPrmsReportForm"/>
            <html:hidden property="hdnMaxYYMM" name="EmpPrmsReportForm"/>
            <html:hidden property="lovKey" name="EmpPrmsReportForm"/>
            <html:hidden property="txtFields" name="EmpPrmsReportForm"/>
            <html:hidden property="txtSearchFields" name="EmpPrmsReportForm"/>
            <html:hidden property="txtDisplayFields" name="EmpPrmsReportForm"/>
            <html:hidden property="txtIndex" name="EmpPrmsReportForm"/>
            <html:hidden property="hdnLoginUserId" name="EmpPrmsReportForm"/>
            <html:hidden property="hdnPayUser" name="EmpPrmsReportForm"/>
            <html:hidden property="hdnLoginUserName" name="EmpPrmsReportForm"/>
            <html:hidden property="loginLocCode" name="EmpPrmsReportForm"/>
            <input type="hidden" name="queryParam"/>
            <input type="hidden" id="submitParam" name="submitParam"/>
        </html:form>
    </body>
</html:html>
<script language="javascript">
  function lfnLoad() {
      mode = document.all.screenMode.value;
      disableMenu();
      if (mode != 'Q') {
          EmpPrmsReportForm.action = "../../../PrmsMediRepGetAccess.do";
          EmpPrmsReportForm.submit();
      }
  }

  function ShowLovEmpNo() {
      EmpPrmsReportForm.lovKey.value = "ReportGeneratePrmsmediclaimEmp" + EmpPrmsReportForm.screenName.value + "U";
      EmpPrmsReportForm.queryParam.value = "txtSiteID=" + EmpPrmsReportForm.loginLocCode.value + ",hdnEmpLbrFlag=" + EmpPrmsReportForm.hdnEmpLbrFlag.value+",screenName="+EmpPrmsReportForm.screenName.value;
      EmpPrmsReportForm.txtSearchFields.value = "Payroll.PaySlip.Emp,Payroll.PaySlip.EmpName,Payroll.PaySlip.CpfCode";
      EmpPrmsReportForm.txtDisplayFields.value = "txtEmpNum,txtEmpName,txtCpfCode";
      showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'EmpPrmsReportForm');
      return true;
  }

  function SetMode(val) {
      //alert("Function SetMode Start");
      if (val == 1) {
          //alert("Mode" + val);
          document.all.txtRepMode.value = "E";
          //alert(document.all.txtRepMode.value);
          return true;
      }
      else {
          //alert("Mode" + val);
          document.all.txtRepMode.value = "S";
          //alert(document.all.txtRepMode.value);
          return true;
      }
      //alert("Function SetMode End");
  }

  function CheckMode() 
  {
      //alert("Function CheckMode Start");
      //alert("Selected Mode is  : "+document.all.txtRepMode.value);
      if (document.all.txtRepMode.value == "E") {
          return true;
      }
      
      else if (document.all.txtRepMode.value == "S")
      {
          alert("Cannot Select Employee in Site wise Mode.");
          return false;
      } 
      else 
      {
        alert("Kindly Select Mode  Employee Wise /Site Wise");
        return false;
      }
  }
</script>
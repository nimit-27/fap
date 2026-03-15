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
    <script language="JavaScriwinpt1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>    
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>

</head>

<BODY  onload="lfnLoad();"  scroll=no onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="ReportLinkerAction" name="OnlinePaySlipReportForm" type="FCIPAY.Payroll.WEBTIER.Form.OnlinePaySlipReportForm" scope="session" >
<bean:define id="ParentForm" name="OnlinePaySlipReportForm" toScope="request" />

<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

  <html:errors/>

<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />
<html:hidden property="headerDataChanged" value="false" />

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>ONLINE PAY SLIP REPORT</TD>
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

         <tr height="15">
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

        <tr> 
        <td width="100%" colspan=2 align="center">
                     
                       <input type="radio" name="radioEmp" id="radioEmp" value="E" CHECKED onclick="miscReport()"><b>Online Pay Slip Report </b>    
                                           
                       <input type="radio" name="radioEmp" id="radiobank" style ="margin-left:30" value="G" onclick="Bankreport()"><b>PF Detail Report </b>          
                        
                        
                      
                    </td> 
              </tr>   

              <TR height=60>
         
    <!-- Detail table Container starts -->
        <tr id="rowyymm">
            <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.PaySlip.Year" /></td><td colspan=2>
              <html:text  property="txtYYMM"  maxlength="6" size="23" styleClass="required"  
                onblur="                                                  
                       if(!(chk_YearMonth()))
                          {
                          }                                            
              " 
              /><bean:message key="Payroll.MaintDARates.yymm" />
             </td>
             </tr>
       



       <tr id="reofrom" style="display:none">
         
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.MaintPfDetail.FromYr" /></td><td colspan=2>
                    <html:text  property="txtFrYYYY"  name="OnlinePaySlipReportForm"  maxlength="4" size="16" styleClass="required"  
                      onchange="                                                  
                    if(!(chk_YearMonth1('txtFrYYYY')))
                    {
                    }                                            
                    " 
                    
                    onblur="                                                  
                    if(!(chk_YearMonth1('txtFrYYYY')))
                    {
                    }                                            
                    " 
          onfocus="document.getElementById('txtToYYYY').value=''" 
          onkeypress="
                    if(event.keyCode < 48 || event.keyCode > 57)
                    {                     
                      return false;
                    }"                    
                    />
                    </td>         
      </tr>
        <tr id="reoto"  style="display:none">
         
              <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.MaintPfDetail.ToYr" /></td><td colspan=2>
                    <html:text  property="txtToYYYY" name="OnlinePaySlipReportForm"  maxlength="4" size="16" styleClass="required"  
                     onchange="                                                  
                    if(!(chk_YearMonth1('txtToYYYY')))
                    {
                    }                                            
                    " 
                    
                    onblur="if(!(chk_toYear('txtToYYYY','txtFrYYYY'))){}"
          onkeypress="
                    if(event.keyCode < 48 || event.keyCode > 57)
                    {                     
                      return false;
                    }"                    
                    />
                    </td>      
              </tr>
             <tr id="rowemp">
        <td class=labelText width="45%" align="center">
         <bean:message key="Payroll.PaySlip.EmpNumber"  /></td> <td colspan=2>
           <html:text  property="txtEmpNo" name="OnlinePaySlipReportForm" maxlength="10" size="20" styleClass="required" 
           onchange=
          "if(!(checkEmployee(OnlinePaySlipReportForm.txtEmpNo.value,OnlinePaySlipReportForm.loginLocCode.value)))
          {
            OnlinePaySlipReportForm.txtEmpNo.value='';
          }"
          />
               
                <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" property="buttxtYYMM" 
              onclick="return ShowLovEmpNo();" >
                <html:text property="txtEmpName" name="OnlinePaySlipReportForm" size="35" value="" styleClass="locked" readonly="true" /></td>
                
                </td> 
        </tr>
      
  
      <tr id="rowaccesskey">
       <td class="labelText"  width="45%" align="center"><bean:message key="Payroll.PaySlip.AccessKey" /></td><td colspan=2>
              <html:password  property="txtCPFDDYYMM" maxlength="20"  name="OnlinePaySlipReportForm" size="23"  styleClass="required" onchange="return chk_CPFYearMonth();"  />
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
               <td  id="payslipbtnclm" bgcolor=#4682b4><html:button value=' GENERATE ONLINE PAY SLIP REPORT'  onclick="return doGetReport('Pay Slip Report')"  property="butInsert" disabled="true" styleClass="bottomBarText"  /></td>

         <td  id="pfdetailbtnclm" style ="display:none" bgcolor=#4682b4><html:button value=' GENERATE ANNUAL PF  DETAILS'  onclick="doGetReport('PF Detail Report')" property="butInsert1"  disabled="true" styleClass="bottomBarText"  /></td>
             
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


function doGetReport(obj)
{  

  //alert('inside doGetReport ')
  //OnlinePaySlipReportForm.txtReport.value=obj;
  
if(mandatory_Check('OnlinePaySlipReportForm'))
{
  
  if(obj=='Pay Slip Report')
  {
  var lbr_flag = OnlinePaySlipReportForm.txtEmpType.value;
    var txtReport = OnlinePaySlipReportForm.txtUserFlag.value;
  if (lbr_flag == 'E')
    {
      var winurl="payslip_online2.rdf&P_EMP_NUM="+OnlinePaySlipReportForm.txtEmpNo.value+"&P_YYMM="+OnlinePaySlipReportForm.txtYYMM.value+"&P_LOCATION_CODE="+OnlinePaySlipReportForm.txtSiteCode.value+"&P_EMP_FLG="+OnlinePaySlipReportForm.txtEmpType.value+"&P_CPF_No="+OnlinePaySlipReportForm.txtCPFDDYYMM.value;
    document.getElementById('butInsert').value="Please wait. File is being downloaded..";
    document.getElementById('butInsert').disabled="true";
    document.getElementById('submitParam').value = winurl;
    document.OnlinePaySlipReportForm.submit();
    }
  else
    {
      var winurl="onlinelabour_payslip.rdf&P_EMP_NUM="+OnlinePaySlipReportForm.txtEmpNo.value+"&P_YYMM="+OnlinePaySlipReportForm.txtYYMM.value+"&P_LOCATION_CODE="+OnlinePaySlipReportForm.txtSiteCode.value+"&P_EMP_FLG="+OnlinePaySlipReportForm.txtEmpType.value+"&P_CPF_No="+OnlinePaySlipReportForm.txtCPFDDYYMM.value;
    document.getElementById('butInsert').value="Please wait. File is being downloaded..";
    document.getElementById('butInsert').disabled="true";
    document.getElementById('submitParam').value = winurl;
    document.OnlinePaySlipReportForm.submit();
     }
    }
    else if (obj=='PF Detail Report')
  {
    var winurl="pf.rdf&P_FYEAR="+OnlinePaySlipReportForm.txtFrYYYY.value+"&p_TYEAR="+OnlinePaySlipReportForm.txtToYYYY.value+"&P_EMP_NUM="+OnlinePaySlipReportForm.txtEmpNo.value+"&P_LOCATION="+OnlinePaySlipReportForm.loginLocCode.value+"&P_CPF_No="+
    OnlinePaySlipReportForm.txtCPFDDYYMM.value;
    document.getElementById('butInsert1').value="Please wait. File is being downloaded..";
    document.getElementById('butInsert1').disabled="true";
    document.getElementById('submitParam').value = winurl;
    document.OnlinePaySlipReportForm.submit();
  }

 
}
 else
 {
  return false;
 }
}
</script>

   
</TBODY>
</TABLE>

<!-- Container Table Ends -->

    <html:hidden name="OnlinePaySlipReportForm"  property="screenMode"/>
    <html:hidden name="OnlinePaySlipReportForm"  property="screenName" value="OnlinePaySlipReport" />
    <html:hidden property="buttonFlag" name="OnlinePaySlipReportForm"  />
    <html:hidden property="txtAllEmpFlag" name="OnlinePaySlipReportForm"  />  

    <html:hidden property="hdnMaxYYMM" name="OnlinePaySlipReportForm"  />    
    <html:hidden property="lovKey" name="OnlinePaySlipReportForm"  />
    <html:hidden property="txtFields" name="OnlinePaySlipReportForm"  />   
    <html:hidden property="txtSearchFields" name="OnlinePaySlipReportForm"  />
    <html:hidden property="txtDisplayFields" name="OnlinePaySlipReportForm"  />
    <html:hidden property="txtIndex" name="OnlinePaySlipReportForm"  />
    <html:hidden property="hdnLoginUserId" name="OnlinePaySlipReportForm"  />    
    <html:hidden property="hdnPayUser" name="OnlinePaySlipReportForm"  />        
    <html:hidden property="hdnLoginUserName" name="OnlinePaySlipReportForm"  />
    <html:hidden property="loginLocCode" name="OnlinePaySlipReportForm"  />
    <html:hidden property="txtInputField" name="OnlinePaySlipReportForm"  />

  <html:hidden property="txtCpfCode" name="OnlinePaySlipReportForm"  />
  <html:hidden property="txtSiteCode" name="OnlinePaySlipReportForm"/>
    <html:hidden property="txtSiteDesc" name="OnlinePaySlipReportForm"  />
  <html:hidden property="txtUserFlag" name="OnlinePaySlipReportForm"  />
     <html:hidden property="txtEmpType" name="OnlinePaySlipReportForm"  />
  <html:hidden property="txtReport" name="OnlinePaySlipReportForm"  />
   

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
    if(mode=='Q' || mode=='N')
  {
      
      var val=document.getElementById("txtReport").value;
    
    if(val=="O" || val=="")
    {
       
        
        
        onloadDisplay_pay();
    }
     
      else
        if(val=="P")
    {
       document.getElementById('radiobank').checked = true;
        //document.getElementByNames("radioEmp")[1].checked="true";
       onloadDisplay_pf();
    }
  }
 if(mode == 'N' )
 {
  
 // OnlinePaySlipReportForm.action="../../../OnlinePaySlipGetAccess.do"
  //OnlinePaySlipReportForm.submit(); 
  //document.getElementById("butInsert").disabled = false;
   OnlinePaySlipReportForm.butInsert.disabled="";
   OnlinePaySlipReportForm.butInsert1.disabled="";
  //obj=OnlinePaySlipReportForm.txtReport.value
  //doGetReport(obj);
  }
  else if(mode != 'N' && mode != 'Q' )
 //if(mode !='Q')
  {
    OnlinePaySlipReportForm.action="../../../OnlinePaySlipGetAccess.do"
    OnlinePaySlipReportForm.submit();  
  }
}

function ShowLovEmpNo()
{
   
   document.getElementById("txtCPFDDYYMM").value="";
   OnlinePaySlipReportForm.lovKey.value = "EmpFinInfo" + OnlinePaySlipReportForm.screenName.value + OnlinePaySlipReportForm.screenMode.value;   
   OnlinePaySlipReportForm.queryParam.value="txtSiteID="+ OnlinePaySlipReportForm.loginLocCode.value +",hdnEmpLbrFlag=X";
   OnlinePaySlipReportForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.EmpName,Payroll.Common.cpfCode,Payroll.common.SiteCode,Payroll.common.SiteDesc,Payroll.common.UserFlag";
   OnlinePaySlipReportForm.txtDisplayFields.value = "txtEmpNo,txtEmpName,txtCpfCode,txtSiteCode,txtSiteDesc,txtUserFlag,txtEmpType";    
   OnlinePaySlipReportForm.txtIndex.value = 0;
   OnlinePaySlipReportForm.txtInputField.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/OnlineSearchScreen.jsp" />', 'OnlinePaySlipReportForm');
   return true;
}
function showLov(pageName, formName) {
    var oLovWin=window.open(pageName,formName, "height=500,width=900,resizable=yes,menubar=no,toolbar=none,statusbar=none");
    oLovWin.moveTo(200,200);
    //oLovWin.document.all.hdnLOVFlag.value = '0';
}

function chk_YearMonth()
{
       var  yearM = document.getElementById("txtYYMM").value;          
    if(yearM!=""){
     
       var month =  parseInt(yearM.substring(4,6),10);

       var  maxYYMM = document.getElementById("hdnMaxYYMM").value;          
      
    if (num_Check(yearM,1))
     {                                   
           
        if (yearM.length != 6)
        {
        alert("Year Month should be a Six digit Number");
//        document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

       if(month < 1 || month > 12)
       {
       alert("Month should be Within 1 to 12");
       document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                    
          return false;
       }
        return true;
     }
     else
     {
              document.getElementById("txtYYMM").select();
     //       event.srcElement.select();
      //      event.srcElement.focus();
     //       event.returnValue=false;     
    return false;
     }
    }
}

function chk_CPFYearMonth()
{

       OnlinePaySlipReportForm.butInsert.disabled="true";
      OnlinePaySlipReportForm.butInsert1.disabled="true";
      var  EmpYYM = document.getElementById("txtCPFDDYYMM").value; 
      var searchIndex = parseInt(EmpYYM.indexOf("@"),10);
      var cpfNo=EmpYYM.substring(0,searchIndex);
      var dob=EmpYYM.substring(searchIndex+1,EmpYYM.length);
    
     if (searchIndex < 0)
        {
            alert("Invalid AccessKey!!!!!");
      document.getElementById("txtCPFDDYYMM").value=""; 
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
            return false;
    
        }
        
         if (dob.length != 8)
        {
            alert("DOB should be a Eight digit Number");    
      document.getElementById("txtCPFDDYYMM").value=""; 
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;            
        
        return false;
    
        }

     validateUser();
   
   return true;
}
function validateUser()
{
  OnlinePaySlipReportForm.headerDataChanged.value="true";
  OnlinePaySlipReportForm.screenMode.value="N";
  OnlinePaySlipReportForm.action = "../../../ValidateUserSaveAction.do";
  OnlinePaySlipReportForm.submit();
}

function miscReport()
{
   document.getElementById("txtReport").value="O";
   document.getElementById("reofrom").style.display="none";
   document.getElementById("reoto").style.display="none";
   document.getElementById("rowyymm").style.display="";
   document.getElementById("pfdetailbtnclm").style.display="none";
   document.getElementById("payslipbtnclm").style.display="";
   document.getElementById("txtFrYYYY").value="0000";
   document.getElementById("txtToYYYY").value="0000";
   document.getElementById("txtYYMM").value="";
   document.getElementById('txtEmpNo').value="";
   document.getElementById('txtEmpName').value="";
   document.getElementById('txtCPFDDYYMM').value="";
   OnlinePaySlipReportForm.butInsert.disabled="false";
   OnlinePaySlipReportForm.butInsert1.disabled="false";

  
}
function Bankreport()
{

 document.getElementById("txtReport").value="P";
 document.getElementById("reofrom").style.display="";
 document.getElementById("reoto").style.display="";
 document.getElementById("rowyymm").style.display="none";
 document.getElementById("pfdetailbtnclm").style.display="";
 document.getElementById("payslipbtnclm").style.display="none";
 document.getElementById("txtYYMM").value="201101";
 document.getElementById("txtFrYYYY").value="";
 document.getElementById("txtToYYYY").value="";
 document.getElementById('txtEmpNo').value="";
 document.getElementById('txtEmpName').value="";
 document.getElementById('txtCPFDDYYMM').value="";
 OnlinePaySlipReportForm.butInsert.disabled="false";
 OnlinePaySlipReportForm.butInsert1.disabled="false";

}

function onloadDisplay_pf()
{
 document.getElementById("reofrom").style.display="";
 document.getElementById("reoto").style.display="";
 document.getElementById("rowyymm").style.display="none";
 document.getElementById("pfdetailbtnclm").style.display="";
 document.getElementById("payslipbtnclm").style.display="none";
 document.getElementById("txtYYMM").value="201101";
}
function onloadDisplay_pay()
{
   document.getElementById("reofrom").style.display="none";
   document.getElementById("reoto").style.display="none";
   document.getElementById("rowyymm").style.display="";
   document.getElementById("pfdetailbtnclm").style.display="none";
   document.getElementById("payslipbtnclm").style.display="";
   document.getElementById("txtFrYYYY").value="0000";
   document.getElementById("txtToYYYY").value="0000";
 
}

function chk_YearMonth1(input)
{      
    var  yearM = document.getElementById(input).value;
  if(yearM == "") return true;
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
function chk_toYear(obj1,obj2)
{
  if(chk_YearMonth1(obj1))
  {
    if(parseInt(document.getElementById(obj1).value)<parseInt(document.getElementById(obj2).value))
    {
      alert("To Year must be greater or equal to From Year ");
      document.getElementById(obj1).focus();
      document.getElementById(obj1).value="";
    }
  }
}

</script>

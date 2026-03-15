<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
         <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>

</head>
<!--<BODY scroll=no onload="lfnLoad();">-->
<BODY scroll=yes  onload="lfnLoad(); history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false"></BODY>
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>


<html:form  action="EmpHighAchieverAction" name="frmEmpHighAchievers" type="FCIPAY.Payroll.WEBTIER.Form.EmpHighAchieversForm" scope="session">
<bean:define id="ParentForm" name="frmEmpHighAchievers" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10> HIGH ACHIEVERS </TD>
  </TR>

  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
          
   <TR>
    <TD>
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                 <!-- <TD class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();" /></TD>
                    <!--<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>-->
                    <td bgcolor="#4682B4" nowrap class=actTabText>High Achievers<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
                 <TR height=10>
                   <!-- Detail table Container starts -->
                    <TD colspan=11>
                      <TABLE cellSpacing=0 cellPadding=0 border=0>
                        <TBODY>
                          <TR>
                           <TD >
                            <DIV id=divDtlTable style="height:320px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail">
                                <TBODY>
                                     <TR height="20">
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"   /></td>
                                              <TD class=tableHeader width="10%">Employee No</td>
                                              <TD class=tableHeader width="10%">Employee Name</td>
                                              <TD class=tableHeader width="10%">Increment Eff Date</td>
                                             
                                             
                                      </TR>   

 <logic:iterate id="intInfo" name="frmEmpHighAchievers"  property="emphighachievers" type="FCIPAY.Payroll.UTILITY.EmpHighAchieversBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="intInfo" property="status" value="D" >                                
                                   <tr>
                                      <td ><html:checkbox property="checked" name="frmEmpHighAchievers" onclick="checkRecord();"  /></td>
                                     
                                      <td >   <html:text property="txtEmployeeNo" name="intInfo"  styleClass="required" readonly="false" size="30"  alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" style="width:90%;text-align:right" onclick="ShowEmployeeNo(this.alt);"/> 
                                       
                               
                                        <logic:equal name="intInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite" onclick="ShowEmployeeNo(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite"   onclick="ShowEmployeeNo(this.alt);" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite"  onclick="ShowEmployeeNo(this.alt);" >                                       
                                      </logic:equal>
                                       <td >   <html:text property="txtEmployeeName" name="intInfo"  styleClass="locked" readonly="true" size="30"  alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" style="width:95%;text-align:right"/></td>  
                              <!--        <td colspan="1"><html:select property="txtIncrementDt" name="intInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" style="WIDTH: 90%"  >
                   <html:option value="" >-----------Please Select-----------</html:option>      
                   <logic:present name="IncrementDtCombo">
                  <html:optionsCollection label="label" value="value" property="dateList" name="IncrementDtCombo"/>
                </logic:present> 
                </html:select></td> -->
                
                <td align="left">
                  <html:text  property="txtIncrementDt"  readonly="true" maxlength="10" name="intInfo" size="16" styleClass="required" style="width:90%;text-align:right" onclick="showCalendar('txtIncrementDt',this)"/>
                  <logic:equal property= "screenMode" name= "frmEmpHighAchievers" value="Q">            
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov"  property="buttxtEmpInSubDate" alt="<%=idx%>"  onclick="showCalendar('txtIncrementDt',this)" onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'"  />
                  </logic:equal>
                  <logic:equal property= "screenMode" name= "frmEmpHighAchievers" value="N">            
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEmpInSubDate" alt="<%=idx%>"   onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtIncrementDt',this)" />
                  </logic:equal>  
                  <logic:equal property= "screenMode" name= "frmEmpHighAchievers" value="U">            
                  <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov"  property="buttxtEmpInSubDate" alt="<%=idx%>"  onmouseover="this.src='../INCLUDES/IMAGES/cal_act.gif'" onclick="showCalendar('txtIncrementDt',this)" />
                  </logic:equal> 
                <html:hidden property="txtSequenceID" name="intInfo" />
                <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo" />
                                    </tr>
                                  </logic:notEqual>
               
               <logic:equal name="intInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmEmpHighAchievers" value="notchecked" /></td>
                                       <td ><html:hidden property="txtEmployeeNo" name="intInfo" /></td>
                                       <td ><html:hidden property="txtIncrementDt" name="intInfo" /></td>
                                       <td><html:hidden property="txtSequenceID" name="intInfo" /></td>    
                                       <td><html:hidden property="txtEmployeeName" name="intInfo" /></td>
               <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo"  />
                                    </tr>
                                  </logic:equal>                                    
                               </logic:iterate>
                                
                            </TBODY>
                          </TABLE>
                        </DIV>
                      </TD>
                    </TR> 
                                        
                                <td colspan=11>	
                                  <TABLE border=0>
                                    <TBODY>
                                      <TR>
                                        <td colspan=11>	
                                          <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                                        </TD>                                  
                                      </TR>
                                    </TBODY>
                                  </TABLE>
                                </TD>
                              </tr>
                              
                            </TBODY>
                          </TABLE>
                        </td>
                      </tr>
                    </TABLE>
                  </td>
                </tr>
                <!-- Tab Table Ends -->
 
                                        <!-- Bottom Blue Bar -->
                <TR>
                  <td align=center bgcolor=#4682b4 width="40%"></td>
                  <td  bgcolor=#4682b4></td>
                  <td bgColor=#4682b4></td>
                  <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
                </TR>
                  </TBODY>
              </TABLE>
            <!-- Container Table Ends-->
<html:hidden property="headerPrimaryKey" name="frmEmpHighAchievers"  />

<html:hidden property="screenMode" name="frmEmpHighAchievers"  />
<html:hidden name="frmEmpHighAchievers"  property="screenName" value="HighAchieversMap" />
<html:hidden name="frmEmpHighAchievers"  property="forwardedPage" />


<html:hidden property="lovKey" name="frmEmpHighAchievers"  />
<html:hidden property="txtFields" name="frmEmpHighAchievers"  />
<html:hidden property="txtSearchFields" name="frmEmpHighAchievers"  />
<html:hidden property="txtDisplayFields" name="frmEmpHighAchievers"  />
<html:hidden property="txtIndex" name="frmEmpHighAchievers"  />
<html:hidden property="txtInputField" name="frmEmpHighAchievers"  />
<html:hidden property="buttonFlag" name="frmEmpHighAchievers"  />
<html:hidden property="userPageRequested" name="frmEmpHighAchievers" />
<html:hidden property="pageRequested" name="frmEmpHighAchievers" />
<html:hidden property="loginLocCode" name="frmEmpHighAchievers" />
<input type="hidden" name="queryParam" />
                                      
</html:form>
</body>
</html:html>

<script language="javascript">
//int chk_flag=0;
function lfnLoad()
{
   var mode = document.all.screenMode.value;
    
   //alert("mode------"+mode); 
    if(mode=='')
    {
        doQueryMode();
    }    
    if(mode=='Q')
    {
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="true";
    }
    if(mode=='U')
    {
      document.all.butGetDetail.disabled="true";
      document.all.butInsert.disabled="";
    }

     detMenuHandling(mode);
     if(document.all.hdnEmpLbrFlag.value=='V')
    {
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
    }
}

function doQueryMode()
{
    document.all.buttonFlag.value='';    
    frmEmpHighAchievers.action="../../../EmpHighAchieversQueryModeAction.do"
    frmEmpHighAchievers.submit();
}

function doRefresh()
{
    frmEmpHighAchievers.action="../../../EmpHighAchieversRefresh.do"
    frmEmpHighAchievers.submit();
}

function GetDetail()
{

   frmEmpHighAchievers.screenMode.value='U';    
   frmEmpHighAchievers.action="../../../EmpHighAchieversGetDetailAction.do"
   frmEmpHighAchievers.submit();
}

function SaveRecord()
{ 
    if(mandatory_Check("frmEmpHighAchievers"))
    {
        //enableAll(); 
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;       
        for(i=0; i < iTr2 -1; i++)
        {
            if (document.getElementsByName("status")[i].value == 'D')
               frmEmpHighAchievers.detailDataChanged.value = "true";
        }    
        document.all.buttonFlag.value='';
       frmEmpHighAchievers.headerFields.value = "false";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
       frmEmpHighAchievers.action = "../../../EmpHighAchieversSaveAction.do";
       frmEmpHighAchievers.submit();
    }
    else
    {
        return false;
    }
    
}
function doBaseAddRow()
{
    if(mandatory_Check("frmEmpHighAchievers"))
    {
        document.all.buttonFlag.value='';
        frmEmpHighAchievers.screenMode.value = "U";  
        document.forms[0].action = "../../../EmpHighAchieversAddRowAction.do";
        //enableAll(); 
        document.forms[0].submit();
    }
    else
    {
        return false;
    }
}



function doBaseDelRow()
{
    document.all.buttonFlag.value='';
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;    
    for(i=0; i < iTr2 -1; i++)
    {    
        if(document.getElementsByName("checked")[i].checked)
        {
            document.getElementsByName("itemChecked")[i].value = "Y";
            frmEmpHighAchievers.detailDataChanged.value = "true";      
        }
    }    
   // enable(); 
    document.forms[0].action = "../../../EmpHighAchieversDeleteRowAction.do";
    document.forms[0].submit();  
}

function ShowEmployeeNo(i)
{
   frmEmpHighAchievers.lovKey.value = "HighAchieversLOV" + frmEmpHighAchievers.screenName.value + frmEmpHighAchievers.screenMode.value;
   frmEmpHighAchievers.txtDisplayFields.value = "txtEmployeeNo,txtEmployeeName";
   frmEmpHighAchievers.txtSearchFields.value = 'Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.LoanForeclosure.CPFCode';
   frmEmpHighAchievers.txtIndex.value =i;      
   frmEmpHighAchievers.txtInputField.value ="txtEmployeeNo"; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpHighAchievers');
    return true;
}

function changed(i)
{
  frmEmpHighAchievers.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[i-1].value == 'Q')
       document.getElementsByName("status")[i-1].value = 'U';
}

function doBasePrevDetail()
{
    frmEmpHighAchievers.userPageRequested.value = 1*frmEmpHighAchievers.pageRequested.value - 1;
    frmEmpHighAchievers.action = "../../../EmpHighAchieversPrevAction.do";
    frmEmpHighAchievers.submit();
}


function doBaseNextDetail()
{
    frmEmpHighAchievers.userPageRequested.value = 1*frmEmpHighAchievers.pageRequested.value + 1;
    frmEmpHighAchievers.action = "../../../EmpHighAchieversNextAction.do";
    frmEmpHighAchievers.submit();
}

function JumpDetail()
{
    frmEmpHighAchievers.userPageRequested.value = 1*frmEmpHighAchievers.newPageRequested.value ;
    frmEmpHighAchievers.action = "../../../EmpHighAchieversJumpAction.do";
    frmEmpHighAchievers.submit();
}
</script>
                         
                                                     
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />
    
    <link rel="STYLESHEET" type="text/css" href="../../CSS/PayrollMenucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
  </head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintainEmpNomineeDetailBase" name="frmEmpNomineeInfoForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpNomineeInfoForm" scope="session">
<bean:define id="ParentForm" name="frmEmpNomineeInfoForm" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />

<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<table>
    <TR height=30>
        <TD  colSpan=12 class=mainHeader height=10>MAINTAIN DEPENDENT/GRATUITY/CPF NOMINEE DETAILS</TD>
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
          <TD class=subHeader colspan=6> Employee Header</TD>
        </TR>
        <TR>
          <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
        <tr height="15" >
          <td colspan="2"></td>
        </tr>
        <TR>                
          <TD class=labelText width="20%" ><bean:message key="Payroll.Common.empNo" /></td>
          <td><html:text  property="headerPrimaryKey" altKey="Payroll.Common.empNo" readonly="true" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" maxlength="10" size="23" styleClass="required"  />
          
          <logic:equal property= "screenMode" name= "frmEmpNomineeInfoForm" value="">
          <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNO"  onclick="ShowLovEmpNo();">                 
          </logic:equal>                                      
          
          <logic:equal property= "screenMode" name= "frmEmpNomineeInfoForm" value="Q">
          <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNO"  onclick="ShowLovEmpNo();">                 
          </logic:equal>                                      
          
          <logic:equal property= "screenMode" name= "frmEmpNomineeInfoForm" value="N">
          <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNO"  onclick="ShowLovEmpNo();">                                  
          </logic:equal> 
          
          <logic:equal property= "screenMode" name= "frmEmpNomineeInfoForm" value="U">
          <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNO"  disabled onclick="ShowLovEmpNo();">                                  
          </logic:equal>
          </td>
          <TD class=labelText width="20%">Employee Name</TD>
          <td>
          <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" styleClass="locked" readonly="locked" />                 
          </td>  
        </tr>      
       
       <TR>                
          <TD class=labelText width="20%" >Category</td>
          <td><html:text  property="txtCategDesc" altKey="Payroll.Common.empNo" readonly="true" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" maxlength="10" size="23" styleClass="locked"  />
          </td>
          <TD class=labelText width="20%">Designation</TD>
          <td>
          <html:text  property="txtDsgnDesc" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" styleClass="locked" readonly="true" />                 
          </td>  
        </tr>
        <TR>                
          <TD class=labelText width="20%" >CPF Code</td>
          <td><html:text  property="txtCpfCode" altKey="Payroll.Common.empNo" readonly="true"  maxlength="10" size="23" styleClass="locked"  />
          
          </td>
          <TD class=labelText width="20%">Date of Joining Site</TD>
          <td>
          <html:text  property="txtDOJSite" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" styleClass="locked" readonly="true" />                 
          <html:hidden property="txtDOR" />
          </td>  
        </tr>
         <TR>                
          <TD class=labelText width="20%" >Employee Type</td>
          <td><html:text  property="txtEmpType" altKey="Payroll.Common.empNo" readonly="true"  maxlength="10" size="23" styleClass="locked"  />
          
          </td>
          <TD class=labelText width="20%">Employee Status</TD>
          <td>
          <html:text  property="txtEmpStatus" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" styleClass="locked" readonly="true" />                 
          </td>  
        </tr>      
       
        <tr height="10">		    
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
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("Dependent")> Dependent Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>   
                    
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > Gratuity Nominee Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td> 
     <!-- added by dushyant on 12-09-2010 -->               
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("Gratuity")> CPF Nominee Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td> 
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
              </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="14">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail" >
                          <TBODY>
                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.EmpInfo.DepndntName" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.EmpInfo.DepndntAge" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.EmpInfo.DepndntRel" /></TD> 
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.EmpInfo.DepndntGuardian" /></TD>   
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.EmpInfo.NomineeShare" /></TD>                            
                            </TR>                          
                          <logic:iterate id="Nominee" name="frmEmpNomineeInfoForm" property="lstInstrDtls1" type="FCIPAY.Payroll.UTILITY.EmpDepndntBean" >
                              <% ++i; %>
                                <logic:notEqual name="Nominee" property="status" value="D" >                                                        
                            <tr> <% ++j; %>
                              <td  width="1%" align="center"><html:checkbox property="checked"  name="frmEmpNomineeInfoForm" onclick="checkRecord();"  /></td>
                              <td  width="5%" ><html:text property="txtDepndntName" name="Nominee" styleClass="required" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="30"  onchange="Chk_Char(this.alt,'txtDepndntName'); return changed(this.alt);"/></td>
                              <td  width="5%" ><html:text property="txtDepndntAge" name="Nominee" styleClass="required" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" maxlength="3" onchange="lfnChange(this.value,this.alt);"/></td>
                              <td  width="5%" ><html:text property="txtDepndntRel" name="Nominee" styleClass="required" maxlength="25" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="Chk_Char(this.alt,'txtDepndntRel'); return changed(this.alt);"/></td>                           
                              <td  width="5%" ><html:text property="txtDepndntGuard" name="Nominee" maxlength="75" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="Chk_Char(this.alt,'txtDepndntGuard');changed(this.alt);"/></td>  
                              <td  width="5%" ><html:text property="txtNomineeShare" name="Nominee" styleClass="required" maxlength="5" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="lfnChangePer(this.value,this.alt); return changed(this.alt);"/></td>                            
                              <html:hidden property="itemChecked" name="Nominee" />
                              <html:hidden property="txtNomineeId" name="Nominee" />
							                <html:hidden property="txtGratuityId" name="Nominee" />
                              <html:hidden property="txtDepndntId" name="Nominee" />
                              <html:hidden property="txtGratuityName" name="Nominee" />    <!-- added by dushyant-->
                              <html:hidden property="txtGratuityAge" name="Nominee" />
                              <html:hidden property="txtGratuityRel" name="Nominee" />
                              <html:hidden property="txtGratGuardian" name="Nominee" />
                              <html:hidden property="txtGratuityShare" name="Nominee" />
                              <html:hidden property="txtDepndntEffFrom" name="Nominee" />
                              <html:hidden property="txtDepndntEffTill" name="Nominee" />                              
                              <html:hidden property="status" name="Nominee" />    
                              <html:hidden property="detailId" name="Nominee" value="Default"/>
                          </tr>
                        </logic:notEqual>
                        <logic:equal name="Nominee" property="status" value="D" >
                         <tr>
                            <td  width="1%" ><html:hidden property="checked" value="notchecked" /></td>
                            <td  width="5%" ><html:hidden property="txtDepndntName" name="Nominee"  /></td>
                            <td  width="5%" ><html:hidden property="txtDepndntAge" name="Nominee"  /></td>
                            <td  width="5%" ><html:hidden property="txtDepndntRel" name="Nominee"  /></td>      
                            <td  width="5%" ><html:hidden property="txtDepndntGuard" name="Nominee"  /></td>
                            <td  width="5%" ><html:hidden property="txtNomineeShare" name="Nominee"  /></td>                                                        
                            
                            <html:hidden property="itemChecked" name="Nominee" />
							              <html:hidden property="txtGratuityId" name="Nominee" />
                            <html:hidden property="txtNomineeId" name="Nominee" />
                            <html:hidden property="txtDepndntId" name="Nominee" />
                            <html:hidden property="txtGratuityName" name="Nominee" />    <!-- added by dushyant-->
                            <html:hidden property="txtGratuityAge" name="Nominee" />
                            <html:hidden property="txtGratuityRel" name="Nominee" />
                            <html:hidden property="txtGratGuardian" name="Nominee" />
                            <html:hidden property="txtGratuityShare" name="Nominee" />    <!-- added by dushyant-->
                            <html:hidden property="txtDepndntEffFrom" name="Nominee" />
                            <html:hidden property="txtDepndntEffTill" name="Nominee" />
                            <html:hidden property="status" name="Nominee" />
                            <html:hidden property="detailId" name="Nominee" value="Default"/>
                         </tr>      
                        </logic:equal>                                    
                       </logic:iterate>       
                       </TBODY>
                     </TABLE>
                    </DIV>
                   </TD>
                  </TR>                     
                  
   <!-- Get details starts -->
	          <tr>
		          <td colspan=8>	
                  <TABLE border=0>
                    <TBODY>
                    <TR><td><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                    </td></TR>
                  </TBODY>
                </TABLE>
               </TD>               
            </tr>
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
          <td>
          <jsp:include  page = "../INCLUDES/BottomBlueBar.jsp" flush="true" />
          </td>
        </TR>	
     </TABLE> 
<!-- Container Table Ending Columns Starts-->
  </TD>    
</TR>
</TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden property="totalDetailRecord" name="frmEmpNomineeInfoForm" />
<html:hidden property="txtEmpNo" name="frmEmpNomineeInfoForm" />
<html:hidden property="screenMode" name="frmEmpNomineeInfoForm" />
<html:hidden name="frmEmpNomineeInfoForm"  property="screenName" value="EmpNomineeScreen" />
<html:hidden name="frmEmpNomineeInfoForm"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmEmpNomineeInfoForm" />
<html:hidden property="userPositionRequested" name="frmEmpNomineeInfoForm" />

<html:hidden property="screenModeNominee" name="frmEmpNomineeInfoForm" />
<html:hidden property="headerClick" name="frmEmpNomineeInfoForm" />
<html:hidden property="headerMode" name="frmEmpNomineeInfoForm" />
<html:hidden property="headerMode1" name="frmEmpNomineeInfoForm" />
<html:hidden property="headerMode2" name="frmEmpNomineeInfoForm" />
<html:hidden property="screenModeID"  name="frmEmpNomineeInfoForm" />

<html:hidden property="lovKey" name="frmEmpNomineeInfoForm"  />
<html:hidden property="txtFields" name="frmEmpNomineeInfoForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpNomineeInfoForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpNomineeInfoForm"  />
<html:hidden property="txtIndex" name="frmEmpNomineeInfoForm"  />
<html:hidden property="buttonFlag" name="frmEmpNomineeInfoForm"  />
<html:hidden property="flagDepndnt" name="frmEmpNomineeInfoForm"  />
<html:hidden property="flagNominee" name="frmEmpNomineeInfoForm"  />
<html:hidden property="flagGratuity" name="frmEmpNomineeInfoForm"  />
<html:hidden property="userPageRequested" name="frmEmpNomineeInfoForm" />
<html:hidden property="pageRequested" name="frmEmpNomineeInfoForm" />
<html:hidden property="loginLocCode" name="frmEmpNomineeInfoForm" />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function lfnLoad()
{ 
    mode1=document.all.flagNominee.value;
    frmEmpNomineeInfoForm.butGetDetail.disabled="true";
    frmEmpNomineeInfoForm.butInsert.disabled="true";
    frmEmpNomineeInfoForm.butDelete.disabled="true";
    if(mode1 == 'true' || document.all.flagDepndnt.value == 'true')
    {
      //  frmEmpNomineeInfoForm.headerPrimaryKey.disabled=true;
    }
    mode=document.all.screenMode.value;  
    if(mode=='')
    {
        doQueryMode();
    }
    if (frmEmpNomineeInfoForm.screenMode.value == 'U')
    { 
          if(mode1=='false')
          {
              frmEmpNomineeInfoForm.butGetDetail.disabled="";
              frmEmpNomineeInfoForm.butInsert.disabled="true";
              frmEmpNomineeInfoForm.butDelete.disabled="true";
          }    
          if(mode1=='true')
          {
              frmEmpNomineeInfoForm.butGetDetail.disabled="true";
              frmEmpNomineeInfoForm.butInsert.disabled="";
              frmEmpNomineeInfoForm.butDelete.disabled="";
              frmEmpNomineeInfoForm.headerPrimaryKey.disabled="true";
          }
    
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;        
    }
        if (frmEmpNomineeInfoForm.screenMode.value == 'N')
    {
        frmEmpNomineeInfoForm.butInsert.disabled="";
    }

    menuHandling(mode);
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";  
   
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    document.all.headerMode.value = "U";
    document.all.headerMode1.value = "U";
    document.all.headerMode2.value = "U";
    document.all.screenModeID.value='U';  
    document.all.screenModeNominee.value = "U1";    
    document.all.headerClick.value = "IDA";    
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		
    
    frmEmpNomineeInfoForm.action="../../../daRatesFirstGetHeaderAction.do"
    frmEmpNomineeInfoForm.submit();
}   


function lfnChange(val,ind)
{
    if(num_Check(val,1))
    {
        frmEmpNomineeInfoForm.detailDataChanged.value = "true";
        if (document.getElementsByName("status")[ind-1].value == 'Q')
        document.getElementsByName("status")[ind-1].value = 'U';
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function changed(ind)
{
  frmEmpNomineeInfoForm.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[ind-1].value == 'Q')
      document.getElementsByName("status")[ind-1].value = 'U';
}

function Chk_Char(ind,name)
{
    that=document.getElementsByName(name)[ind-1];
    str=that.value;
    for(i=0; i<str.length; i++)
    {
        var txtVal =str.charAt(i);
        if((txtVal >= 'A' && txtVal <= 'Z') ||(txtVal >= 'a' && txtVal <= 'z') || (txtVal == ',') || (txtVal == ' '))
        {}
        else
        {
            alert("Invalid Input");
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;
            return false;
        }
    }
}


function Chk_Char_age(ind,name)
{
    var oTable = document.getElementById("Detail");
    var iTr2 = oTable.rows.length;
    var i = 0;
    for(i=0; i < iTr2 -1; i++)
    {
		if(document.getElementsByName("txtDepndntAge")[i].value!="")
		{
			if((document.getElementsByName("txtDepndntAge")[i].value) < 18)
			{
				var guard = document.getElementsByName("txtDepndntGuard")[i];
				if(guard.value=="") 
				{
					document.getElementsByName("txtDepndntGuard")[i].style.background="#ffffd3";
					document.getElementsByName("txtDepndntGuard")[i].style.className="required"; 
					alert("  Enter the Guardian Name  ");
					guard.focus();
					return false;
				}
			}
		}
    }  

	return true;
}

function lfnChangeAmt(val,ind)
{
    if(num_Check(val,1))
    {
        maxCheck(ind);
        frmEmpNomineeInfoForm.detailDataChanged.value = "true";
        if (document.getElementsByName("status")[ind-1].value == 'Q')
            document.getElementsByName("status")[ind-1].value = 'U';
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}


function maxCheck(i)
{
    var low = parseInt(document.getElementsByName("startField")[i-1].value);
    var high = parseInt(document.getElementsByName("endField")[i-1].value);
    
    if(high <= low )
    {
        alert("High Basic Should be greater than Low Basic")
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
        return false;                        
    }
    return true;
}

function ShowLovEmpNo()
{
    frmEmpNomineeInfoForm.lovKey.value = "EmpNominee" + frmEmpNomineeInfoForm.screenName.value + frmEmpNomineeInfoForm.screenMode.value;
    frmEmpNomineeInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtDsgnDesc,txtCategDesc,txtDOR,txtEmpStatus,txtEmpType,txtCpfCode,txtDOJSite";       
    frmEmpNomineeInfoForm.txtSearchFields.value = "Payroll.Common.empName,Payroll.Common.cpfCode,Payroll.Common.Dsgn";   
    frmEmpNomineeInfoForm.queryParam.value = "txtSiteID="+frmEmpNomineeInfoForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpNomineeInfoForm.hdnEmpLbrFlag.value;    
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpNomineeInfoForm');
    return true;
}

function lfnChangePer(val,ind)
{
    if(percent_Check_Zero_Allwd(val))
    {
        frmEmpNomineeInfoForm.detailDataChanged.value = "true";
        if (document.getElementsByName("status")[ind-1].value == 'Q')
        document.getElementsByName("status")[ind-1].value = 'U';
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function doBaseAddRow()
{    
    document.all.buttonFlag.value='D';
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    for(i=0; i < iTr2 -1; i++)
    {
        if (document.getElementsByName("status")[i].value == 'Q')
        {                
            document.getElementsByName("txtDepndntName")[i].disabled=""; 
        }
    }  
   if(!mandatory_Check("frmEmpNomineeInfoForm"))
     return false;
    
      document.all.buttonFlag.value='D';
      document.all.screenMode.value='U';
      document.all.flagNominee.value='true';
      frmEmpNomineeInfoForm.headerPrimaryKey.disabled="";    
      document.forms[0].action = "../../../EmpNomineeAddRowAction.do";
      document.forms[0].submit();   
}

function doBaseDelRow()
{
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;   
    var strRecList='';
    var flag = 0;
    for(i=0; i < iTr2 -1; i++)
    {
      if(document.getElementsByName("checked")[i].checked)
      {
        flag=flag+1;
      }
    }
    if ( flag == 0)
    {
      alert("Please check the rows to be deleted");
      return false;
    }
    for(i=0; i < iTr2 -1; i++)
    {
      if(document.getElementsByName("checked")[i].checked)
      {
        if(document.getElementsByName("status")[i].value=="N")
        {
          document.getElementsByName("itemChecked")[i].value = "Y";
          frmEmpNomineeInfoForm.detailDataChanged.value = "true";      
          document.all.buttonFlag.value='D';
        }
        else
          strRecList=strRecList+(i+1)+",";

      }
    }
    if(strRecList!='')
    {
      alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
    }
    frmEmpNomineeInfoForm.headerPrimaryKey.disabled="";
    document.forms[0].action = "../../../EmpNomineeDeleteRowAction.do";
    document.forms[0].submit(); 
   
}

function SaveRecord()
{
    if(!mandatory_Check("frmEmpNomineeInfoForm"))
          return false;     
	if(!Chk_Char_age())
          return false;     
    var share=0;
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
            frmEmpNomineeInfoForm.detailDataChanged.value = "true";
        else
          share = share +parseFloat(document.getElementsByName("txtNomineeShare")[i].value);            
    }
  
    if(share != 100)
    {    
      if(share == 99.99)
      {
        //return;
      }
      else      
      {
        alert("Share % cannot be greater or lesser than 100. Please check the details");
        return false;
      }
    }
    document.all.buttonFlag.value='';
    frmEmpNomineeInfoForm.headerFields.value = "false";
    frmEmpNomineeInfoForm.totalDetailRecord.value = parseInt(iTr2,10) - 1;    
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmEmpNomineeInfoForm.action = "../../../EmpNomineeSaveAction.do";
    frmEmpNomineeInfoForm.submit();
}

function GetDetail()
{
    if(frmEmpNomineeInfoForm.headerPrimaryKey.value == '')
    {
      alert("Mandatory Field is empty");
      frmEmpNomineeInfoForm.headerPrimaryKey.focus();
      return;
    }
    else
    {
      document.all.buttonFlag.value='';
      frmEmpNomineeInfoForm.flagNominee.value="true";
      frmEmpNomineeInfoForm.txtEmpNo.value=frmEmpNomineeInfoForm.headerPrimaryKey.value;
      //document.all.screenModeIDA.value='U';
      document.all.screenMode.value='U';
      frmEmpNomineeInfoForm.headerPrimaryKey.disabled="";
      frmEmpNomineeInfoForm.action="../../../EmpNomineeGetDetailAction.do"
      frmEmpNomineeInfoForm.submit();
    }   
}

function doInsertMode()
{    
    frmEmpNomineeInfoForm.action="../../../EmpNomineeNewMode.do"
    frmEmpNomineeInfoForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';    
    frmEmpNomineeInfoForm.flagDepndnt.value="false";
    frmEmpNomineeInfoForm.flagNominee.value="false";
             frmEmpNomineeInfoForm.flagGratuity.value="false";
    frmEmpNomineeInfoForm.headerPrimaryKey.value="";
    frmEmpNomineeInfoForm.butGetDetail.disabled="";
    frmEmpNomineeInfoForm.butInsert.disabled="true";
    frmEmpNomineeInfoForm.butDelete.disabled="true";  
    
    frmEmpNomineeInfoForm.action="../../../EmpNomineeQueryMode.do"
    frmEmpNomineeInfoForm.submit();

}

function getHeaderRecord()
{
    document.all.flagNominee.value="false";
    document.all.flagDepndnt.value="false";
         document.all.flagGratuity.value="false";
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

    frmEmpNomineeInfoForm.action="../../../EmpNomineeHeaderAction.do"
    frmEmpNomineeInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.flagNominee.value="false";
    document.all.flagDepndnt.value="false";
          document.all.flagGratuity.value="false";
    frmEmpNomineeInfoForm.userPositionRequested.value = 1*frmEmpNomineeInfoForm.positionRequested.value + 1;
    frmEmpNomineeInfoForm.action="../../../EmpNomineeNextHeaderAction.do";
    frmEmpNomineeInfoForm.submit();
}

function PrevHeader()
{
    document.all.flagNominee.value="false";
    document.all.flagDepndnt.value="false";
    document.all.flagGratuity.value="false";
    frmEmpNomineeInfoForm.userPositionRequested.value = 1*frmEmpNomineeInfoForm.positionRequested.value - 1;
    frmEmpNomineeInfoForm.action = "../../../EmpNomineeNextHeaderAction.do";
    frmEmpNomineeInfoForm.submit();
}

function JumpHeader()
{
    document.all.flagNominee.value="false";
    document.all.flagDepndnt.value="false";
    document.all.flagGratuity.value="false";
    frmEmpNomineeInfoForm.userPositionRequested.value = 1*frmEmpNomineeInfoForm.newPositionRequested.value;
    frmEmpNomineeInfoForm.action = "../../../EmpNomineeNextHeaderAction.do";
    frmEmpNomineeInfoForm.submit();
}


function doGetTab(arg)
{
     
    document.all.buttonFlag.value='';
    if (frmEmpNomineeInfoForm.screenMode.value=="U")
    {
        frmEmpNomineeInfoForm.headerMode.value = "U";
        frmEmpNomineeInfoForm.headerMode1.value = "U";
        frmEmpNomineeInfoForm.headerMode2.value = "U";
    } 
    frmEmpNomineeInfoForm.forwardedPage.value=arg;    
    frmEmpNomineeInfoForm.action="../../../EmpNomineeTabAction.do";
    frmEmpNomineeInfoForm.submit();
}

function chk_YearMonth(val)
{
    var  yearM = document.getElementById("txtYYMM").value;          
    var month =  yearM.substring(4,6);    
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
            alert("Month should be Within 1 to 12");
            document.getElementById("txtYYMM").focus();                     
            event.srcElement.select();
            event.srcElement.focus();
            event.returnValue=false;                        
            return false;
        }
        else
        {        
            //return changed(val);
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

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmEmpNomineeInfoForm.userPageRequested.value = 1*frmEmpNomineeInfoForm.pageRequested.value - 1;
    frmEmpNomineeInfoForm.action = "../../../EmpNomineeNextDetailAction.do";
    frmEmpNomineeInfoForm.submit();
}


function doBaseNextDetail()
{
    document.all.buttonFlag.value=''; 
    frmEmpNomineeInfoForm.userPageRequested.value = 1*frmEmpNomineeInfoForm.pageRequested.value + 1;
    frmEmpNomineeInfoForm.action = "../../../EmpNomineeNextDetailAction.do";
    frmEmpNomineeInfoForm.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmEmpNomineeInfoForm.userPageRequested.value = 1*frmEmpNomineeInfoForm.newPageRequested.value ;
    frmEmpNomineeInfoForm.action = "../../../EmpNomineeNextDetailAction.do";
    frmEmpNomineeInfoForm.submit();
}

function doRefresh()
{
    frmEmpNomineeInfoForm.action = "../../../EmpNomineeRefresh.do";
    frmEmpNomineeInfoForm.submit();
}

function AmtCheck()
{
    var oTable = document.getElementById("Detail");
    var iTR = oTable.rows.length;
    var flag =0;    
    for(i=0;i<iTR-1;i++)
    {   
        var m = parseInt(document.getElementsByName("startField")[i].value);
        var n= parseInt(document.getElementsByName("endField")[i].value);               
    
        if (m >= n)
        {
            alert("Amount To Should Be Greater Than Amount From");
            document.getElementsByName("endField")[i].focus(); 
            return false;
        }                                 
    }                 
    return true;
} 

function checkSharePer()
{
    var oTable = document.getElementById("Detail");
    var iTR = oTable.rows.length;
    var sum=0;
    for(i=0;i<iTR-1;i++)
    {   
        sum=sum+ parseInt(document.getElementsByName("txtNomineeShare")[i].value,10);  
    } 
    
    if(sum != 100)
    {
      alert(+sum);
      if(sum == 99.99)
      {
        return true;
      }
      else
      
      {
      alert("Share % cannot be greater or lesser than 100. Please check the details");
      return false;
      }
    }
    
}
</script> 
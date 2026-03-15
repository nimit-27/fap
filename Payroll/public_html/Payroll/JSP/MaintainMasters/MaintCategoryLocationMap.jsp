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


<html:form  action="MaintCategoryLocationAction" name="frmMaintCategoryLocation" type="FCIPAY.Payroll.WEBTIER.Form.MaintCategoryLocationForm" scope="session">
<bean:define id="ParentForm" name="frmMaintCategoryLocation" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10> MAINTAIN CATEGORY VS SCHEME MAPPING</TD>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Category VS Scheme<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                              <TD class=tableHeader width="10%">Employee Category</td>
                                                <TD class=tableHeader width="10%">Pay Scale Type</td>
                                              <TD class=tableHeader width="11%">Location Type</TD>
                                               <TD class=tableHeader width="11%">Depot Type</TD>
                                              <TD class=tableHeader width="11%">Scheme</td>
                                               <TD class=tableHeader width="11%">Scheme Description</td>
                                          <!--         <TD class=tableHeader width="11%">Agency Site Desc</td> -->
                                              
                                      <!--         <TD class=tableHeader width="9%">Location Code</td>
                                                 <TD class=tableHeader width="11%">Location Desc</td>
                                              <td class=tableHeader width="9%">Employee No </td>  
                                               <td class=tableHeader width="11%">Employee Name </td>  -->
                                              
                                      </TR>   
                                      
                                                                                                           <!--  property="categorylocationmap" -->
                          <logic:iterate id="intInfo" name="frmMaintCategoryLocation"  property="categorylocationmap" type="FCIPAY.Payroll.UTILITY.MaintCategoryLocationBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="intInfo" property="status" value="D" >                                
                                   <tr>
                                      <td ><html:checkbox property="checked" name="frmMaintCategoryLocation" onclick="checkRecord();"  /></td>
                                      
                                    <!--  <td ><html:text property="txtEmpCategory" name="intInfo" styleClass="optional" style="width:60%" readonly="false" alt="<%=String.valueOf(i) %>"  />  
                                  
                                      <logic:equal name="intInfo" property="status" value="N">                                       
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  onclick="ShowPayCode(this.alt);" >
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowPayCode(this.alt);" >                                     
                                      </logic:equal>                                      
                                       
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmpNo"  disabled onclick="ShowPayCode(this.alt);" >                                       
                                      </logic:equal> -->
                                      
                                       <td colspan="1"><html:select property="txtEmpCategory" name="intInfo"  styleClass="required" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt);" style="WIDTH: 90%"  >
                   <html:option value="" >-----------Please Select-----------</html:option>      
                   <logic:present name="CtgryLocCombo">
                  <html:optionsCollection label="label" value="value" property="ctgryList" name="CtgryLocCombo"/>
                </logic:present> 
                </html:select></td>
                                  <td colspan="1"><html:select property="txtPayScaleType" name="intInfo"  styleClass="required" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt);" style="WIDTH: 90%"  >
                 <html:option value="" >-----------Please Select-----------</html:option>      
                   <logic:present name="CtgryLocCombo">
                  <html:optionsCollection label="label" value="value" property="payScale" name="CtgryLocCombo"/>
                </logic:present>
                </html:select></td>
                                       
                                    <!--  <td >   <html:text property="txtPayScaleType" name="intInfo"  styleClass="optional" readonly="false" size="30" style="width:80%" alt="<%=String.valueOf(i) %>" onclick="ShowPayScaleType(this.alt);" onchange="return changed(this.alt);"/> 
                                   <!-- <td>   <html:text property="txtPayScaleType" name="intInfo" style="width:60%"  styleClass="required" alt="<%=String.valueOf(i) %>" readonly="true" onchange="checkDuplicacy(this,this.alt);"   />                                      
                                     
                                      <logic:equal name="intInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency" onclick="ShowPayScaleType(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"   onclick="ShowPayScaleType(this.alt);" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgency"  onclick="ShowPayScaleType(this.alt);" >                                       
                                      </logic:equal>
                                     -->
                                      <td >   <html:text property="txtLocationType" name="intInfo"  styleClass="optional" readonly="false" size="30" style="width:80%" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt);" onclick="ShowLocationType(this.alt);"/> 
                                       
                               
                                        <logic:equal name="intInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite" onclick="ShowLocationType(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite"   onclick="ShowLocationType(this.alt);" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtAgencySite"  onclick="ShowLocationType(this.alt);" >                                       
                                      </logic:equal>
                         
                                   
                                       <td ><html:text property="txtDepotType" name="intInfo"    styleClass="optional" style="width:60%" alt="<%=String.valueOf(i) %>" onclick="ShowDepot(this.alt);" onchange="return changed(this.alt);" /> 
                                       
                                     <logic:equal name="intInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtLocation" onclick="ShowDepot(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtLocation"  onclick="ShowDepot(this.alt);" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtLocation"  onclick="ShowDepot(this.alt);" >                                       
                                      </logic:equal>
                                     
                                      <td >   <html:text property="txtScheme" name="intInfo"  styleClass="optional" readonly="false" size="19" style="width:80%" alt="<%=String.valueOf(i) %>" onclick="ShowScheme(this.alt);" onchange="return changed(this.alt);" /> 
                                
                          
                                         
                                       <logic:equal name="intInfo" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmployeeNo" onclick="ShowScheme(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmployeeNo"  onclick="ShowScheme(this.alt);" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="intInfo" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=idx%>" property="buttxtEmployeeNo"  onclick="ShowScheme(this.alt);" >                                       
                                      </logic:equal>  
                                    <td >   <html:text property="txtSchemeDesc" name="intInfo"  styleClass="locked" readonly="true" size="30" style="width:95%" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt);" /></td>  
                                     
                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo" />
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="intInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintCategoryLocation" value="notchecked" /></td>
                                       <td ><html:hidden property="txtEmpCategory" name="intInfo" /></td>
                                       <td ><html:hidden property="txtPayScaleType" name="intInfo" /></td>
                                  
                                       <td ><html:hidden property="txtLocationType" name="intInfo" /></td>
                                       <td ><html:hidden property="txtDepotType" name="intInfo" /></td>
                                       <td ><html:hidden property="txtScheme" name="intInfo" /></td>
                                       <td ><html:hidden property="txtSchemeDesc" name="intInfo" /></td>
                                       

                                       
                          
                                       
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
<html:hidden property="headerPrimaryKey" name="frmMaintCategoryLocation"  />

<html:hidden property="screenMode" name="frmMaintCategoryLocation"  />
<html:hidden name="frmMaintCategoryLocation"  property="screenName" value="MaintCategoryLocationMap" />
<html:hidden name="frmMaintCategoryLocation"  property="forwardedPage" />


<html:hidden property="lovKey" name="frmMaintCategoryLocation"  />
<html:hidden property="txtFields" name="frmMaintCategoryLocation"  />
<html:hidden property="txtSearchFields" name="frmMaintCategoryLocation"  />
<html:hidden property="txtDisplayFields" name="frmMaintCategoryLocation"  />
<html:hidden property="txtIndex" name="frmMaintCategoryLocation"  />
<html:hidden property="txtInputField" name="frmMaintCategoryLocation"  />
<html:hidden property="buttonFlag" name="frmMaintCategoryLocation"  />
<html:hidden property="userPageRequested" name="frmMaintCategoryLocation" />
<html:hidden property="pageRequested" name="frmMaintCategoryLocation" />
<html:hidden property="loginLocCode" name="frmMaintCategoryLocation" />
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
    frmMaintCategoryLocation.action="../../../MaintCategoryLocationQueryModeAction.do"
   frmMaintCategoryLocation.submit();
}

function doRefresh()
{
    frmMaintCategoryLocation.action="../../../MaintCategoryLocationRefresh.do"
   frmMaintCategoryLocation.submit();
}

function GetDetail()
{

   frmMaintCategoryLocation.screenMode.value='U';    
   frmMaintCategoryLocation.action="../../../MaintCategoryLocationGetDetailAction.do"
   frmMaintCategoryLocation.submit();
}

function SaveRecord()
{ 
    if(mandatory_Check("frmMaintCategoryLocation"))
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
               frmMaintCategoryLocation.detailDataChanged.value = "true";
        }    
        document.all.buttonFlag.value='';
      frmMaintCategoryLocation.headerFields.value = "false";
      document.all.butExecute.disabled="true";
	  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
      frmMaintCategoryLocation.action = "../../../MaintCategoryLocationSaveAction.do";
      frmMaintCategoryLocation.submit();
    }
    else
    {
        return false;
    }
    
}
function doBaseAddRow()
{
    if(mandatory_Check("frmMaintCategoryLocation"))
    {
        document.all.buttonFlag.value='';
     frmMaintCategoryLocation.screenMode.value = "U";  
        document.forms[0].action = "../../../MaintCategoryLocationAddRowAction.do";
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
           frmMaintCategoryLocation.detailDataChanged.value = "true";      
        }
    }    
   // enable(); 
    document.forms[0].action = "../../../MaintCategoryLocationDeleteRowAction.do";
    document.forms[0].submit();  
}

function ShowScheme(i)
{
   frmMaintCategoryLocation.lovKey.value = "CategorySchemeLOV" + frmMaintCategoryLocation.screenName.value + frmMaintCategoryLocation.screenMode.value;
   frmMaintCategoryLocation.txtDisplayFields.value = "txtScheme,txtSchemeDesc";
   frmMaintCategoryLocation.txtSearchFields.value = 'Payroll.CategoryLocation.Scheme';
   frmMaintCategoryLocation.txtIndex.value =i;      
   frmMaintCategoryLocation.txtInputField.value ="txtScheme"; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintCategoryLocation');
    return true;
}

/* function ShowPayScaleType(i)
{
   frmMaintCategoryLocation.lovKey.value = "CategorySchemePayScaleLOV" + frmMaintCategoryLocation.screenName.value + frmMaintCategoryLocation.screenMode.value;
   frmMaintCategoryLocation.txtDisplayFields.value = "txtPayScaleType";
   frmMaintCategoryLocation.txtSearchFields.value = 'Payroll.CategoryLocation.PayScaleType';
   frmMaintCategoryLocation.txtIndex.value =i;      
   frmMaintCategoryLocation.txtInputField.value ="txtPayScaleType"; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintCategoryLocation');
    return true;
} */

function ShowLocationType(i)
{
   frmMaintCategoryLocation.lovKey.value = "CategorySchemeLocationLOV" + frmMaintCategoryLocation.screenName.value + frmMaintCategoryLocation.screenMode.value;
   frmMaintCategoryLocation.txtDisplayFields.value = "txtLocationType";
   frmMaintCategoryLocation.txtSearchFields.value = 'Payroll.CategoryLocation.Location';
   frmMaintCategoryLocation.txtIndex.value =i;      
   frmMaintCategoryLocation.txtInputField.value ="txtLocationType"; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintCategoryLocation');
    return true;
}

function ShowDepot(i)
{
   frmMaintCategoryLocation.lovKey.value = "CategorySchemeDepotLOV" + frmMaintCategoryLocation.screenName.value + frmMaintCategoryLocation.screenMode.value;
   frmMaintCategoryLocation.txtDisplayFields.value = "txtDepotType";
   frmMaintCategoryLocation.txtSearchFields.value = 'Payroll.CategoryLocation.Depot';
   frmMaintCategoryLocation.txtIndex.value =i;      
   frmMaintCategoryLocation.txtInputField.value ="txtDepotType"; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintCategoryLocation');
    return true;
}

 function changed(i)
{
  frmMaintCategoryLocation.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[i-1].value == 'Q')
     document.getElementsByName("status")[i-1].value = 'U';
}

function doBasePrevDetail()
{
    frmMaintCategoryLocation.userPageRequested.value = 1*frmMaintCategoryLocation.pageRequested.value - 1;
   frmMaintCategoryLocation.action = "../../../CategoryLocationPrevAction.do";
    frmMaintCategoryLocation.submit();
}


function doBaseNextDetail()
{
  frmMaintCategoryLocation.userPageRequested.value = 1*frmMaintCategoryLocation.pageRequested.value + 1;
    frmMaintCategoryLocation.action = "../../../CategoryLocationNextAction.do";
   frmMaintCategoryLocation.submit();
}

function JumpDetail()
{
    frmMaintCategoryLocation.userPageRequested.value = 1*frmMaintCategoryLocation.newPageRequested.value ;
    frmMaintCategoryLocation.action = "../../../CategoryLocationJumpAction.do";
  frmMaintCategoryLocation.submit();
}
</script>
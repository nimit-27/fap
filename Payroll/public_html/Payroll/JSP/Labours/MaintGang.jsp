<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

     <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
     <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintGang" name="frmMaintGang" type="FCIPAY.Payroll.Labour.WEBTIER.Form.MaintGangForm" scope="session">
<bean:define id="ParentForm" name="frmMaintGang" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN GANG DETAILS</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
   <TR>
    <TD>
    
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0>
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=2>Header For Maintain Gang Details</TD>
        </TR>
        <TR>
              <TD colspan=4 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="4"></td>
         </tr>
         
 <tr>

            <td class="labelText">Location/Depot Name</td>
            <td><html:text  property="txtLocId" maxlength="10" styleClass="required" readonly="true" />            
            <logic:equal name="frmMaintGang" property="screenMode" value="U" >            
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" >
            </logic:equal>            
            <logic:notEqual name="frmMaintGang" property="screenMode" value="U" >
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" onclick="return ShowLovLocation();" >
            </logic:notEqual>            
            <html:text  property="txtLoc" maxlength="10" styleClass="locked" readonly="true" />
            </td>
            
            <td class="labelText">Gang Name</td>
            <td>
            <logic:equal name="frmMaintGang" property="screenMode" value="Q" >
            
            <html:text  property="txtGangName" maxlength="50" styleClass="required" readonly="true" />
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
            </logic:equal>
            
            <logic:equal name="frmMaintGang" property="screenMode" value="N" >
            
            <html:text  property="txtGangName" maxlength="10" styleClass="required" />            
            </logic:equal>
            <logic:equal name="frmMaintGang" property="screenMode" value="U" >
            
            <html:text  property="txtGangName" maxlength="10" styleClass="required" readonly="true" />            
            </logic:equal>
            </td>
            <html:hidden property="headerPrimaryKey" />

 </tr>
 <tr> 
            
            <td class="labelText">MOU Code</td>
            <td>
            <html:hidden property="txtType" />
            <html:select property="txtMou" alt="txtMou" styleClass="required" disabled="true" >
              <html:option value=""> --Please Select --</html:option>
              <logic:present name="GangCombo">
              <html:optionsCollection label="label" value="value" property="mouList" name="GangCombo" />
              </logic:present>            
              </html:select>
            </td>
  
          <td class="labelText"></td>
            <td></td>
          
        </tr>

           <tr height="10">		    
        <TD colspan="2" > </TD>
      </tr>
   	 </table>
    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
                <TR>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText >Member Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" border="0"></td>
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
                            <DIV id=divDtlTable style="height:280px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail" >
                                <TBODY>
                                  <TR height="22">
                                              
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td> 
                                              <TD class=tableHeader width="1%">S.No</TD>
											  <TD class=tableHeader width="3%">Employee No</td> <!--added by dushyant on 01-03-2011-->
											  <TD class=tableHeader width="3%">CPF Code</td> <!--added by dushyant on 01-03-2011-->
                                              <TD class=tableHeader width="10%">Member Name</TD>
                                              <TD class=tableHeader width="10%">Designation</td> 
                                              <TD class=tableHeader width="5%" id="dep">Basic</td>
                                              <TD class=tableHeader width="5%" id="dps">MGW</td>
                                              <TD class=tableHeader width="5%" >Effective From</td>
                                              <TD class=tableHeader width="5%" >Effective From(HH:MM)</td>
                                              <TD class=tableHeader width="5%" >Effective To</td>
                                              <TD class=tableHeader width="3%" >Effective To(HH:MM)</td>
                                               </tr> 
                             <logic:iterate id="gangInfo" name="frmMaintGang" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.MaintGangBean" >
                              <% ++i; %>
                               <logic:notEqual name="gangInfo" property="status" value="D" >  
                                   <tr><% ++j; %>
                                       <td ><html:checkbox property="checked" onclick="checkRecord();chkboxEnable(this.alt);" value="false" name="frmMaintGang" alt="<%=String.valueOf(i-1)%>" /></td> 
                                       <td ><html:text property="txtSNo" name="gangInfo" readonly="true" value="<%=String.valueOf(j)%>" style="width:100%"  />
					 <!-- added by dushyant on 22-feb-2011-->
										<td ><html:text property="hdnEmpId" name="gangInfo" size="1" styleClass="required" maxlength="10" readonly="true" onchange="checkDuplicacy(this.alt)" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>"  />
                    <!-- added by dushyant on 22-feb-2011-->
					<!-- added by dushyant on 22-feb-2011-->
										<td ><html:text property="txtCpfCode" name="gangInfo" size="1" styleClass="locked" maxlength="08" readonly="true" onchange="checkDuplicacy(this.alt)" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>"  />
                    <!-- added by dushyant on 22-feb-2011-->
                                       <td ><html:text property="txtEmpName" name="gangInfo" size="5" styleClass="required" maxlength="08" readonly="true" onchange="checkDuplicacy(this.alt)" style="width:89%;text-align:left" alt="<%=String.valueOf(i)%>"  />
                                       
                                       <logic:notEqual name="gangInfo" property="status" value="N" >
                                         <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" alt="<%=String.valueOf(i)%>" >
                                        </logic:notEqual>
                                        <logic:equal name="gangInfo" property="status" value="N" >
                                         <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" alt="<%=String.valueOf(i)%>" onclick="return ShowLovEmp(this.alt);" >
                                        </logic:equal>
                                       </td>
                                       <td >
                                       <html:text property="txtEmpTyp" name="gangInfo" styleClass="required" readonly="true" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" />
                                       </td>
                                       <td >
                                       <html:text property="txtCurrBas" name="gangInfo" styleClass="required" readonly="true" style="width:100%;text-align:left" alt="<%=String.valueOf(i)%>" />
                                       </td>
                                      <td  ><html:text property="txtFrom" name="gangInfo" size="9" styleClass="required" readonly="true" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="chkFromDt(this.alt)" />
                                      <logic:equal property="status" name="gangInfo" value="N" >
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" onclick="showCalendar('txtFrom',this)" />
                                       </logic:equal>
                                       <logic:notEqual property="status" name="gangInfo" value="N" >
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" id=calSwitch<%=(i-1)%> property="buttxtEffDate" alt="<%=(i-1)%>"/>
                                       </logic:notEqual>
                                       </td>
                                       
                                      <td >
                                      <logic:equal property="status" name="gangInfo" value="N" >
                                        <html:text property="txtFromHrs" name="gangInfo" styleClass="required" maxlength="2" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" /><b>&nbsp;:</b> 
                                        <html:text property="txtFromMin" name="gangInfo" styleClass="required" maxlength="2" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" />
                                      </logic:equal>
                                      <logic:notEqual property="status" name="gangInfo" value="N" >
                                        <html:text property="txtFromHrs" name="gangInfo" styleClass="required" readonly="true" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" /><b>&nbsp;:</b> 
                                        <html:text property="txtFromMin" name="gangInfo" styleClass="required" readonly="true" style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" />
                                      </logic:notEqual>
                                      </td>
                                       <td><html:text property="txtTo" name="gangInfo" styleClass="optional" readonly="true" style="width:80%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return checkEffEndDate(this.alt), ckeckEffTrnsStatus(this.alt),changed(this.alt);" />
                                           <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1)%>" onclick="showCalendar('txtTo',this)" />
                                           <html:hidden property="hdnEffToDt" name="gangInfo" />
                                             <html:hidden property="hdnEffToHr" name="gangInfo" />
                                               <html:hidden property="hdnEffToMin" name="gangInfo" />
                                       </td>
                                       
                                      <td ><html:text property="txtToHrs" name="gangInfo" styleClass="optional" maxlength="2" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" /><b>&nbsp;:</b> 
                                      <html:text property="txtToMin" name="gangInfo" styleClass="optional" maxlength="2" onkeypress="if((event.keyCode < 48 || event.keyCode > 57)){ return false;}; " style="width:40%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)" />
                                      </td>
                                   <!--    <html:hidden property="hdnEmpId" name="gangInfo" />     commented by dushyant -->
                                       <html:hidden property="itemChecked" name="gangInfo" />                               
                                       <html:hidden property="status" name="gangInfo" />
                                       <html:hidden property="detailId" name="gangInfo" />                                   
                                </tr>
                                 </logic:notEqual>                                                                
                                <logic:equal name="gangInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintGang" value="notchecked" /></td> 
                                       <td ><html:hidden property="hdnEmpId" name="gangInfo" /></td><!--added by dushyant on 01-03-2011--> 
									   <td ><html:hidden property="txtCpfCode" name="gangInfo" /></td><!--added by dushyant on 01-03-2011-->
									   <td ><html:hidden property="txtEmpName" name="gangInfo" /></td>
                                       <td ><html:hidden property="txtEmpTyp" name="gangInfo" /></td>
                                       <td ><html:hidden property="txtCurrBas" name="gangInfo" /></td>
                                       <html:hidden property="txtFrom" name="gangInfo" />
                                       <html:hidden property="txtFromHrs" name="gangInfo" />
                                       <html:hidden property="txtFromMin" name="gangInfo" />
                                       <html:hidden property="txtTo" name="gangInfo" />
                                       <html:hidden property="txtToHrs" name="gangInfo" />
                                       <html:hidden property="txtToMin" name="gangInfo" />
                                    <!--   <html:hidden property="hdnEmpId" name="gangInfo" />  commented by dushyant -->
                                       <html:hidden property="itemChecked" name="gangInfo" />                                   
                                       <html:hidden property="status" name="gangInfo" />
                                       <html:hidden property="detailId" name="gangInfo" />
                                    </tr>
                                  </logic:equal>                                    
                                                             
                           </logic:iterate>

                                 </TBODY>
                                </TABLE>
                              </DIV>
                             </TD>
                            </TR>                     
          
              <!-- Get details starts -->
                                 <TR>
                                 
                                 <td>
                                 <html:button value=' Update Row ' onclick="doEditDate()" property="butEdit" disabled="true"/>
                                 </td>
                              
                                  </TR>
                            <tr>
                              <td colspan=11>	
                                <TABLE border=0>
                                  <TBODY>
                                  <TR> <TD>
                                    <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" /></TD>
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

<html:hidden name="frmMaintGang"  property="screenMode"  />
<html:hidden name="frmMaintGang"  property="screenName" value="GangMasterScreen" />
<html:hidden name="frmMaintGang"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintGang"  />
<html:hidden property="buttonFlag" name="frmMaintGang"  />
<html:hidden property="userPageRequested" name="frmMaintGang" />
<html:hidden property="pageRequested" name="frmMaintGang" />
<html:hidden property="loginLocCode" name="frmMaintGang" />

<html:hidden property="lovKey" name="frmMaintGang"  />
<html:hidden property="txtFields" name="frmMaintGang"  />   
<html:hidden property="txtSearchFields" name="frmMaintGang"  />
<html:hidden property="txtDisplayFields" name="frmMaintGang"  />
<html:hidden property="txtInputField" name="frmMaintGang"  />
<html:hidden property="txtIndex" name="frmMaintGang"  />
<html:hidden property="payYYMM" name="frmMaintGang" /> 
<html:hidden property="headerDataChanged" name="frmMaintGang"  />
<html:hidden property="txtSiteID" name="frmMaintGang" /> 
<input type="hidden" name="queryParam" />
</html:form>
</body>
</html:html>

<script language="javascript">
var chkMes =0;
  
function changed(val)
{ 
  frmMaintGang.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
    document.getElementsByName("status")[val-1].value = 'U';
}

function doGetNextHeader()
{
    document.all.buttonFlag.value='';
    document.forms[0].action="/enrgise/TEPPurInfoGetNextHeader.do";
    document.forms[0].submit();
}

function doBaseAddRow()
{
  if(mandatory_Check("frmMaintGang"))
  {document.all.buttonFlag.value='D';
  frmMaintGang.headerPrimaryKey.disabled="";
   document.forms[0].action = "../../../GangAddRowAction.do";
  document.forms[0].submit();
  }
  else
  {
      return false;
  }
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
    
  var strRecList='';
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("status")[i].value!='D')
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("detailId")[i].value=="" )
      {
        document.getElementsByName("itemChecked")[i].value = "Y";
        frmMaintGang.detailDataChanged.value = "true";
      }
      else
        strRecList=strRecList+(i+1)+",";

    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
	
	return false;
  }

  frmMaintGang.headerPrimaryKey.disabled="";
  document.forms[0].action = "../../../GangDeleteRowAction.do";
  document.forms[0].submit();  
}



function GetDetail()
{
  if(frmMaintGang.headerPrimaryKey.value == '')
  {
    alert("Mandatory Field is empty");
  //  frmMaintGang.headerPrimaryKey.focus();
    return;
  }
  else
  {
  document.all.buttonFlag.value='';
 // frmMaintGang.flagAll.value="true";
  frmMaintGang.headerPrimaryKey.value=frmMaintGang.headerPrimaryKey.value;
  document.all.screenMode.value='U';
  frmMaintGang.headerPrimaryKey.disabled="";
  frmMaintGang.action="../../../GangFirstGetDetailAction.do"
  frmMaintGang.submit();
  }
}


function SaveRecord()
{

if(!mandatory_Check("frmMaintGang"))
        return false;      

  
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  if(iTr2<2)
  {
    alert("Please Add at Least one row");
    return false;
  }
  var i = 0;

  
  for(i=0; i < iTr2 -1; i++)
  {
      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintGang.detailDataChanged.value = "true";
      else
      {
        if(!chkToDt(i+1))
          return false;
      }
      
  }
  document.all.buttonFlag.value='';
  frmMaintGang.headerPrimaryKey.value=frmMaintGang.headerPrimaryKey.value;
  frmMaintGang.queryParam.value="txtGangName="+frmMaintGang.txtGangName.value;
  if ( document.all.screenMode.value == "N")
      document.all.headerDataChanged.value='true';
  frmMaintGang.txtMou.disabled="";
  frmMaintGang.totalDetailRecord.value = parseInt(iTr2,10) - 1;
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintGang.action = "../../../GangSaveAction.do";
  frmMaintGang.submit();
}

function doInsertMode()
{
  if ( document.all.screenMode.value == "Q")
      document.all.headerDataChanged.value='';
      
  document.all.buttonFlag.value='';
  frmMaintGang.action="../../../GangNewMode.do"
  frmMaintGang.submit();

}

function doQueryMode()
{
  document.all.buttonFlag.value='';
 //frmMaintGang.headerPrimaryKey.value="";
 
 //frmMaintGang.butInsert.disabled="true";
 //frmMaintGang.butDelete.disabled="true";
 frmMaintGang.action="../../../GangQueryMode.do"
 frmMaintGang.submit();
document.all.butGetDetail.disabled="true";
}

function lfnLoad()
{
  mode=document.all.screenMode.value;
  if(mode=='')
  {
    doQueryMode();
  }
  menuHandling(mode);
  if(document.all.hdnEmpLbrFlag.value=='L')
  {
    document.all.txtType.value="DEP";
    document.getElementById("dep").style.display='';
    document.getElementById("dps").style.display='none';
  }
  else if(document.all.hdnEmpLbrFlag.value=='D')
  {
    document.all.txtType.value="DPS";
    document.getElementById("dps").style.display='';
    document.getElementById("dep").style.display='none';
  }
  else
  {
    document.all.txtType.value="KOT";
    document.getElementById("dep").style.display='';
    document.getElementById("dps").style.display='none';
  }
  if(mode=='Q')
     {
     document.all.butInsert.disabled="true";
     document.all.butExecute.disabled="true";    
     document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
     } 
  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
      checkLbrTyp();
  }
 // document.all.butDelete.disabled="true";
}

function doBasePrevDetail()
{
    frmMaintGang.userPageRequested.value = 1*frmMaintGang.pageRequested.value - 1;
    frmMaintGang.action = "../../../GangNextDetailAction.do";
    frmMaintGang.submit();
}

function doBaseNextDetail()
{
    frmMaintGang.userPageRequested.value = 1*frmMaintGang.pageRequested.value + 1;
    frmMaintGang.action = "../../../GangNextDetailAction.do";
    frmMaintGang.submit();
}

function JumpDetail()
{
    frmMaintGang.userPageRequested.value = 1*frmMaintGang.newPageRequested.value;
    frmMaintGang.action = "../../../GangNextDetailAction.do";
    frmMaintGang.submit();
}

 function doRefresh()
    {  
        frmMaintGang.action = "../../../GangRefresh.do";
        frmMaintGang.submit();
    }

/*function ShowSite()
    {
       frmMaintGang.lovKey.value = "GangDepot" + frmMaintGang.screenName.value + frmMaintGang.screenMode.value;
       frmMaintGang.queryParam.value="txtSiteID="+frmMaintGang.loginLocCode.value;
       frmMaintGang.txtDisplayFields.value = "txtLocId,txtLoc";
       frmMaintGang.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
       frmMaintGang.txtIndex.value=""; 
       frmMaintGang.txtInputField.value="";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintGang');
     //  frmMaintGang.headerDataChanged.value = "true";       
       return true;
    }*/
function ShowLovLocation()
{   
   frmMaintGang.lovKey.value = "MaintAncllryAttnd" + frmMaintGang.screenName.value + frmMaintGang.screenMode.value;   
   frmMaintGang.txtDisplayFields.value = "txtLocId,txtLoc";
   frmMaintGang.queryParam.value = "txtSiteID="+frmMaintGang.loginLocCode.value+"";
   frmMaintGang.txtSearchFields.value = "Payroll.Labour.LocId,Payroll.Labour.Loc";
   frmMaintGang.txtInputField.value =""; 
   frmMaintGang.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintGang');
   return true;
}

function ShowLovGang()
    {
       frmMaintGang.queryParam.value="txtLocId= "+ frmMaintGang.txtLocId.value +",txtSiteID="+frmMaintGang.loginLocCode.value+",txtType="+frmMaintGang.txtType.value;    
       frmMaintGang.lovKey.value = "GangName" + frmMaintGang.screenName.value + frmMaintGang.screenMode.value;
       frmMaintGang.txtDisplayFields.value = "headerPrimaryKey,txtGangName,txtLocId,txtLoc,txtType,txtMou";
       frmMaintGang.txtSearchFields.value = "Payroll.Labour.GangId,Payroll.Labour.GangName";
       frmMaintGang.txtIndex.value="";
       frmMaintGang.txtInputField.value="";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintGang');
     //  frmMaintGang.headerDataChanged.value = "true";
       return true;
    }    
function ShowLovEmp(i)
    {
       frmMaintGang.queryParam.value="txtLocId="+ frmMaintGang.txtLocId.value +" ,txtLbrType= "+frmMaintGang.txtType.value ;    
       frmMaintGang.lovKey.value = "GangEmpLbr" + frmMaintGang.screenName.value + frmMaintGang.screenMode.value;
       frmMaintGang.txtDisplayFields.value = "hdnEmpId,txtCpfCode,txtEmpName,txtEmpTyp,txtCurrBas";
       frmMaintGang.txtIndex.value=i-1;
       frmMaintGang.txtInputField.value="txtEmpName";
      // frmMaintGang.txtSearchFields.value = "Labours.txtEmpId,Labours.txtEmpName";
       frmMaintGang.txtSearchFields.value = "";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintGang');
       return true;
    }

function chkFromDt(i)
{
  var fromDt=document.getElementsByName("txtFrom")[i-1].value;
  if(!cmpSysDate(fromDt,0))
    { 
      document.getElementsByName("txtFrom")[i-1].value="";
      return false;
    }
 // setEndDt(i);
 
   
	
	var systDate = getSysDate();
    var payrollyymm = frmMaintGang.payYYMM.value;
	var paylastdate = new Date((new Date(payrollyymm.substring(0, 4), payrollyymm.substring(4), 1) -1) );
    var lastDate = paylastdate.getDate() + '-' + (paylastdate.getMonth() + 1) + '-' + paylastdate.getFullYear();

	var msg = " Effective Start Date cannot be greater than current payroll YYMM's last date "+ lastDate;
	if(cmpDateMsg(fromDt,lastDate,0,msg))
	 {
			return true;
	 }
	 else
	 {
			document.getElementsByName("txtFrom")[i - 1].value = "";
			document.getElementsByName("txtFromHrs")[i-1].value = "";
			document.getElementsByName("txtFromMin")[i-1].value = "";
			return false;
	  }
		
	changed(i);
}

function chkToDt(i)
{
  var fromDt=(document.getElementsByName("txtFrom")[i-1].value).toUpperCase();
  var toDt=(document.getElementsByName("txtTo")[i-1].value).toUpperCase();
  if(toDt=='')
    return true;
  else
    if(document.getElementsByName("txtToHrs")[i-1].value=='' || document.getElementsByName("txtToMin")[i-1].value=='')
    {
      alert("Mandatory Field Effective To (HH:MM) is empty");
      return false;
    }
  if(fromDt==toDt)
  {
    if(parseInt(document.getElementsByName("txtFromHrs")[i-1].value,10) < parseInt(document.getElementsByName("txtToHrs")[i-1].value,10))
    {
      return true;
    }else if(parseInt(document.getElementsByName("txtFromHrs")[i-1].value,10) == parseInt(document.getElementsByName("txtToHrs")[i-1].value,10))
    { 
      if(parseInt(document.getElementsByName("txtFromMin")[i-1].value,10) >= parseInt(document.getElementsByName("txtToMin")[i-1].value,10))
      {
          document.getElementsByName("txtToMin")[i-1].value="";
          alert("Effective From cannot be greater than or equals to Effective To");
          return false;
      }else
      {
        return true;
      }
    }else
    {
      document.getElementsByName("txtToHrs")[i-1].value="";
      alert("Effective From cannot be greater than Effective To");
      return false;
    }
  }else
  {
    if(!cmpDate(fromDt,toDt,0))
    { 
      alert("Effective From cannot be greater than Effective To");
      document.getElementsByName("txtTo")[i-1].value=document.getElementsByName("hdnEffToDt")[i-1].value;
      document.getElementsByName("txtToMin")[i-1].value=document.getElementsByName("hdnEffToMin")[i-1].value;
      document.getElementsByName("txtToHrs")[i-1].value=document.getElementsByName("hdnEffToHr")[i-1].value;
      return false;
    }
  }
   return true;
}
	
function checkDuplicacy(rInd)
{
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName("hdnEmpId")[rInd-1].value;
  newtype = document.getElementsByName("txtEmpTyp")[rInd-1].value;   // added by dushyant on 17-june-2011
  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
	if(ind != rInd && document.getElementsByName("status")[ind-1].value!='D')
	{
		  oldComb = document.getElementsByName("hdnEmpId")[ind-1].value;
		  lbrType = document.getElementsByName("txtEmpTyp")[ind-1].value;
		  date = document.getElementsByName("txtTo")[ind-1].value;
			if((newtype == 'Sardar' || newtype == 'Mukadam' ) && date == '') //added by swapnendu Dt 08 May 2012.
			{
				if(lbrType == 'Sardar')
				{
					document.getElementsByName("hdnEmpId")[rInd-1].value='';
					document.getElementsByName("txtEmpName")[rInd-1].value='';
					document.getElementsByName("txtCpfCode")[rInd-1].value='';
					document.getElementsByName("txtEmpTyp")[rInd-1].value='';
					document.getElementsByName("txtCurrBas")[rInd-1].value='';
					alert("You can not Enter more than one "+lbrType);
					return ; 
				}
			if(lbrType == 'Mukadam')
				{
					document.getElementsByName("hdnEmpId")[rInd-1].value='';
					document.getElementsByName("txtEmpName")[rInd-1].value='';
					document.getElementsByName("txtCpfCode")[rInd-1].value='';
					document.getElementsByName("txtEmpTyp")[rInd-1].value='';
					document.getElementsByName("txtCurrBas")[rInd-1].value='';
					alert("You can not Enter more than one "+lbrType);
					return ; 
				}
			}
			if((newtype == 'Mandal' || newtype == 'Tindel') && date == '') //added by swapnendu Dt 08 May 2012.
			{
				if(lbrType == 'Mandal')
				{
					document.getElementsByName("hdnEmpId")[rInd-1].value='';
					document.getElementsByName("txtEmpName")[rInd-1].value='';
					document.getElementsByName("txtCpfCode")[rInd-1].value='';
					document.getElementsByName("txtEmpTyp")[rInd-1].value='';
					document.getElementsByName("txtCurrBas")[rInd-1].value='';
					alert("You can not Enter more than one "+lbrType);
					return ; 
				}
				if(lbrType == 'Tindel')
				{
					document.getElementsByName("hdnEmpId")[rInd-1].value='';
					document.getElementsByName("txtEmpName")[rInd-1].value='';
					document.getElementsByName("txtCpfCode")[rInd-1].value='';
					document.getElementsByName("txtEmpTyp")[rInd-1].value='';
					document.getElementsByName("txtCurrBas")[rInd-1].value='';
					alert("You can not Enter more than one "+lbrType);
					return ; 
				}
			}

		  if((oldComb == newComb) && (date == ''))
		  {
			document.getElementsByName("hdnEmpId")[rInd-1].value='';
			document.getElementsByName("txtEmpName")[rInd-1].value='';
			document.getElementsByName("txtCpfCode")[rInd-1].value='';
			document.getElementsByName("txtEmpTyp")[rInd-1].value='';
			document.getElementsByName("txtCurrBas")[rInd-1].value='';
			alert("You Can't Enter Duplicate Value");
			return ; 
		  }
            oldtype = document.getElementsByName("txtEmpTyp")[0].value;
			dummy = document.getElementsByName("txtEmpName")[0].value;
            end_dt = document.getElementsByName("txtTo")[0].value;

		    if((oldtype == 'Sardar'||oldtype =='Mandal'||oldtype =='Handling Labour') && (end_dt == ''))
		    {
				//alert('oldtype' + oldtype + ' Name :' + dummy + 'end_dt :' + end_dt  )   ;
			   if(newtype == 'Anchillary Labour' ||newtype =='Mukadam' ||newtype =='Tindel' ||newtype =='Loader' ||newtype =='Modia Stitcher' ||newtype =='Godown Mazdoor')
				{
				    //alert('oldtype' + oldtype + 'newtype' + newtype)   ;
					document.getElementsByName("hdnEmpId")[rInd-1].value='';
					document.getElementsByName("txtEmpName")[rInd-1].value='';
					document.getElementsByName("txtCpfCode")[rInd-1].value='';
					document.getElementsByName("txtEmpTyp")[rInd-1].value='';
					document.getElementsByName("txtCurrBas")[rInd-1].value='';
					alert("You Can't Enter "+ newtype +" In The Present Gang");
					return ;
				}
		    }

			if(oldtype == 'Anchillary Labour')
			{	
		    	if(newtype == 'Sardar'||newtype =='Mandal'||newtype =='Handling Labour' ||newtype =='Mukadam' ||newtype =='Tindel' ||newtype =='Loader' ||newtype =='Modia Stitcher' ||newtype =='Godown Mazdoor')
			    {
					document.getElementsByName("hdnEmpId")[rInd-1].value='';
					document.getElementsByName("txtEmpName")[rInd-1].value='';
					document.getElementsByName("txtCpfCode")[rInd-1].value='';
					document.getElementsByName("txtEmpTyp")[rInd-1].value='';
					document.getElementsByName("txtCurrBas")[rInd-1].value='';
					alert("You Can't Enter "+ newtype +" In The Present Gang");
					return ;
				}
			}
			//added by nitin on 25-02-2013
			if(oldtype == 'Mukadam'||oldtype =='Tindel'||oldtype =='Loader')
		    {
			   if(newtype == 'Anchillary Labour' ||newtype =='Sardar' ||newtype =='Mandal' ||newtype =='Handling Labour' ||newtype =='Modia Stitcher' ||newtype =='Godown Mazdoor')
				{
					document.getElementsByName("hdnEmpId")[rInd-1].value='';
					document.getElementsByName("txtEmpName")[rInd-1].value='';
					document.getElementsByName("txtCpfCode")[rInd-1].value='';
					document.getElementsByName("txtEmpTyp")[rInd-1].value='';
					document.getElementsByName("txtCurrBas")[rInd-1].value='';
					alert("You Can't Enter "+ newtype +" In The Present Gang");
					return ;
				}
		    }
			if(oldtype =='Godown Mazdoor')
		    {
			   if(newtype == 'Anchillary Labour' ||newtype =='Sardar' ||newtype =='Mandal' ||newtype =='Handling Labour' ||newtype =='Modia Stitcher' ||newtype =='Loader')
				{
					document.getElementsByName("hdnEmpId")[rInd-1].value='';
					document.getElementsByName("txtEmpName")[rInd-1].value='';
					document.getElementsByName("txtCpfCode")[rInd-1].value='';
					document.getElementsByName("txtEmpTyp")[rInd-1].value='';
					document.getElementsByName("txtCurrBas")[rInd-1].value='';
					alert("You Can't Enter "+ newtype +" In The Present Gang");
					return ;
				}
		    }
			if(oldtype =='Modia Stitcher')
		    {
			   if(newtype == 'Anchillary Labour' ||newtype =='Sardar' ||newtype =='Mandal' ||newtype =='Handling Labour' ||newtype =='Godown Mazdoor' ||newtype =='Loader')
				{
					document.getElementsByName("hdnEmpId")[rInd-1].value='';
					document.getElementsByName("txtEmpName")[rInd-1].value='';
					document.getElementsByName("txtCpfCode")[rInd-1].value='';
					document.getElementsByName("txtEmpTyp")[rInd-1].value='';
					document.getElementsByName("txtCurrBas")[rInd-1].value='';
					alert("You Can't Enter "+ newtype +" In The Present Gang");
					return ;
				}
		    }
			//addition by nitin on 25-02-2013 ends
		}
	}
 }

function checkLbrTyp()
{
  
  typ=document.all.txtType.value;
  if(typ=='DEP')
  {
    document.all.txtMou.disabled="";
    document.all.txtMou.style.background="#ffffd3";
    document.all.txtMou.style.className="required";
  }
  else
  {
    document.all.txtMou.disabled="true";
    document.all.txtMou.style.background="#ffffff";
    document.all.txtMou.style.className="optional";    
  }
}

//added by nand on 13-mar-2013
function ckeckEffTrnsStatus(i)
{
  var p_emp_num=document.getElementsByName("hdnEmpId")[i - 1].value;
  
  var p_eff_to_date=document.getElementsByName("txtTo")[i - 1].value;
   url="../../../GetEmpTransferStatus.do";
        prm="mode=1&p_emp_num="+p_emp_num+"&p_eff_to_date="+p_eff_to_date;
              // alert("inside eff end date3");

     //  alert(prm);
	xml=getXML(url,prm);
	Tags=xml.getElementsByTagName("record");
	var if_transfrd=0;
	if(Tags.length>0)
	{
            if_transfrd=Tags[0].childNodes[0].nodeValue;
	}
       // alert(if_transfrd);
	if(if_transfrd==1)
	{
            alert("You can not update the gang details! Employee is in transfer state.");
            document.getElementsByName("txtTo")[i-1].value=document.getElementsByName("hdnEffToDt")[i-1].value;
            return false;
	}

}
function checkEffEndDate(i)
{
	var toDt = document.getElementsByName("txtTo")[i - 1].value.toUpperCase();
	document.getElementsByName("txtTo")[i - 1].value = toDt;
	var systDate = getSysDate();
    var payrollyymm = frmMaintGang.payYYMM.value;
	var paylastdate = new Date((new Date(payrollyymm.substring(0, 4), payrollyymm.substring(4), 1) -1) );
    var lastDate = paylastdate.getDate() + '-' + (paylastdate.getMonth() + 1) + '-' + paylastdate.getFullYear();

	var msg = " Effective End Date cannot be greater than current payroll YYMM's last date "+ lastDate;
	if(cmpDateMsg(toDt,lastDate,0,msg))
	 {
			return true;
	 }
	 else
	 {
			//document.getElementsByName("txtTo")[i - 1].value = "";
                         document.getElementsByName("txtTo")[i-1].value=document.getElementsByName("hdnEffToDt")[i-1].value;
                         //alert( document.getElementsByName("hdnEffToHr")[i-1].value);
			document.getElementsByName("txtToHrs")[i-1].value = document.getElementsByName("hdnEffToHr")[i-1].value;
			document.getElementsByName("txtToMin")[i-1].value =document.getElementsByName("hdnEffToMin")[i-1].value;
			return false;
	  }
		
	changed(i);
} 
//end of additon by nand on 13-mar-2013

function chkboxEnable(s)
{
var index=s;

var calSwitch = "calSwitch"+s;
var oTable = document.getElementById("Detail");
 var flag=0;
 var iTr2 = oTable.rows.length;
  var i = 0;
    

 if(document.getElementsByName("checked")[index].checked)
   {    
                   
         for(i=0; i < iTr2 -1; i++)
             {
                  if(document.getElementsByName("checked")[i].checked)
                      {
                          
                          flag++;
                     
                     }
             }
       
    
       if(flag>1)
       {
       alert('More than one record cannot be selected');
       document.getElementsByName("checked")[index].checked=false;
        
       return false;
       }
          
           document.all.butSave.disabled="true";
            document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
           
            document.getElementById(calSwitch).onclick=showCalender;

            document.all.butEdit.disabled="";
            
           
            document.getElementsByName("txtFromHrs")[index].readOnly="";
			document.getElementsByName("txtFromMin")[index].readOnly ="";
			document.getElementsByName("txtToHrs")[index].readOnly ="";
			document.getElementsByName("txtToMin")[index].readOnly ="";
            document.getElementsByName("itemChecked")[index].value = "Y";
            return true;
        }
 else if (!(document.getElementsByName("checked")[index].checked))
        {
            
            document.all.butSave.disabled="";
           document.all.butSave.src="../INCLUDES/IMAGES/save.jpg";
            document.getElementById(calSwitch).onclick=hideCalendar ;

            document.all.butEdit.disabled='true';
             document.getElementsByName("itemChecked")[index].value = "N";
            return false;
        }

      
}

function showCalender()
{
    showCalendar('txtFrom',this);
}

function hideCalendar()
{
return false;
}

function doEditDate()
{
    
     frmMaintGang.queryParam.value="txtSiteID="+frmMaintGang.loginLocCode.value;

  frmMaintGang.headerPrimaryKey.disabled="";
  frmMaintGang.action = "../../../GangUpdateRowAction.do";
  frmMaintGang.submit();
}


</script>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
 
</head>

<BODY scroll=no onload="siteLoad()" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="MaintHolidayCal" name="frmMaintHolidayCal" type="FCIPAY.Payroll.WEBTIER.Form.MaintHolidayCalForm" scope="session">
<bean:define id="ParentForm" name="frmMaintHolidayCal" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="headerPrimaryKey" />
<html:hidden property="screenMode" name="frmMaintHolidayCal" />
<html:hidden name="frmMaintHolidayCal"  property="screenName" value="HolidayCalScreen" />
<html:hidden name="frmMaintHolidayCal"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintHolidayCal"  />
<html:hidden property="pageRequested" name="frmMaintHolidayCal" />
<html:hidden property="userPageRequested" name="frmMaintHolidayCal" />
<html:hidden property="userPositionRequested" name="frmMaintHolidayCal" />
<html:hidden property="buttonFlag" name="frmMaintHolidayCal"  />
<html:hidden property="lovKey" name="frmMaintHolidayCal"  />
<html:hidden property="txtFields" name="frmMaintHolidayCal"  />   
<html:hidden property="txtSearchFields" name="frmMaintHolidayCal"  />
<html:hidden property="txtDisplayFields" name="frmMaintHolidayCal"  />
<html:hidden property="txtIndex" name="frmMaintHolidayCal"  />
<input type="hidden" name="queryParam" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN LOCATION DETAILS</TD>
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
          <TD class=subHeader colspan=2>Header For Maintain Location</TD>
        </TR>
        <TR>
              <TD colspan=2 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
        <tr>

            <td class="labelText"  width="25%" >Year</td>
            <td width="25%"><html:select property="txtYr" styleClass="required" onchange="doQueryMode()">
                <html:option value="" >-----------Please Select-----------</html:option>      
                 <logic:present name="HolidayCal">
                  <html:optionsCollection label="label" value="value" property="yrList" name="HolidayCal"/>
                </logic:present>
                </html:select></td>
            <td class="labelText" width="25%" >Location
            </td>
            <td width="25%">
            <html:text property="txtLocId" readonly="true" styleClass="required" />
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtParentLoc" onclick="return ShowLoc();" >
            </td>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Holiday Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                <TBODY>
                                  <TR height="22">
                                      <td class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                                      <td class=tableHeader width="4%">Holiday Name</td>
                                      <td class=tableHeader width="6%">Holiday Date</td>
                                      <td class=tableHeader width="6%">Holiday Type</td>
                                   </tr> 
                           <logic:iterate id="calInfo" name="frmMaintHolidayCal" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintHolidayCalBean" >
                              <% ++i; %>
                                <logic:notEqual name="calInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                       <td align=center ><html:checkbox property="checked" name="frmMaintSiteDetail" onclick="checkRecord();" value="false" /></td>
                                       <td ><html:text property="txtHolidayName" name="calInfo" size="9"    styleClass="required" style="width:100%" alt="<%=String.valueOf(i) %>" onchange="upper(this); checkDuplicacy('txtSiteName',this.alt); return changed(this.alt);" /></td>
                                       <td ><html:text property="txtHolidayDt" name="calInfo" size="15" styleClass="optional" style="width:100%" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt);" /></td>
                                       <td ><html:text property="txtHolidayCode" name="calInfo" size="15" styleClass="optional" style="width:100%" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt);" /></td>
                                       
                                       <html:hidden property="itemChecked" name="calInfo" />
                                       <html:hidden property="status" name="calInfo" />
                                       <html:hidden property="detailId" name="calInfo" value="Default"/>
                                    </tr>
                                  </logic:notEqual>
                                  <logic:equal name="siteInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintHolidayCal" value="notchecked" /></td>
                                       <td ><html:hidden property="txtHolidayName" name="calInfo" /></td>
                                       <td ><html:hidden property="txtHolidayDt" name="calInfo" /></td>
                                       <td ><html:hidden property="txtHolidayCode" name="calInfo" /></td>
                                       
                                       <html:hidden property="itemChecked" name="calInfo" />
                                       <html:hidden property="status" name="calInfo" />
                                       <html:hidden property="detailId" name="calInfo" value="Default"/>
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
                              <td colspan=11>	
                                <TABLE border=0>
                                  <TBODY>
                                  <TR>
                                    <TD><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" /></td>                                 
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


</html:form>
</body>
</html:html>

 <script language="javascript">
     
 function changed(val)
{
  frmMaintSiteDetail.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}
   
function doBaseAddRow()
{
  if(mandatory_Check("frmMaintHolidayCal"))
  {
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
    document.getElementsByName("txtSiteName")[i].disabled="";
  }
  document.forms[0].action = "../../../CalAddRowAction.do";
  document.forms[0].submit();
  }
  else
  {
   return false;
  }
}

function doBaseDelRow()
{
  
if(mandatory_Check("frmMaintHolidayCal"))
{
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
      frmMaintHolidayCal.detailDataChanged.value = "true";      
    }

  }
   
  //enable();
  document.forms[0].action = "../../../CalDeleteRowAction.do";
  document.forms[0].submit();  
  }
  else
  {
     return false;
  }
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintHolidayCal"))
  {
  if(document.frmMaintHolidayCal.txtParentLoc)
  {
    document.frmMaintHolidayCal.headerPrimaryKey.value=document.frmMaintHolidayCal.txtLocTyp.value+", "+document.frmMaintHolidayCal.txtParentLoc.value;
  }
  else
  {
    document.frmMaintHolidayCal.headerPrimaryKey.value=document.frmMaintHolidayCal.txtLocTyp.value+", ";
  }
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;


  
  for(i=0; i < iTr2 -1; i++)
  {
      document.getElementsByName("txtSiteName")[i].disabled="";

        if (document.getElementsByName("status")[i].value == 'D')
        frmMaintHolidayCal.detailDataChanged.value = "true";
  }

  frmMaintHolidayCal.headerFields.value = "false";
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";

  frmMaintHolidayCal.action = "../../../CalSaveAction.do";
  frmMaintHolidayCal.totalDetailRecord.value=parseInt(iTr2)-1;
  frmMaintHolidayCal.submit();
  }
  else{
  return false;
  }
}

function GetDetail()
{
  if(mandatory_Check("frmMaintHolidayCal"))
  {
    document.all.screenMode.value='U';
    if(document.frmMaintHolidayCal.txtParentLoc)
    {
      document.frmMaintHolidayCal.headerPrimaryKey.value=document.frmMaintHolidayCal.txtLocTyp.value+", "+document.frmMaintHolidayCal.txtParentLoc.value;
    }
    else
    {
      document.frmMaintHolidayCal.headerPrimaryKey.value=document.frmMaintHolidayCal.txtLocTyp.value+", ";
    }
    frmMaintHolidayCal.action="../../../CalGetDetailAction.do"
    frmMaintHolidayCal.submit();
    return true;
  }
  else
  {
    return false;
  }
}

function checkDuplicacy(that,rInd)
{
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName(that)[rInd-1].value;
  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(rInd != ind)
    {
      oldComb = document.getElementsByName(that)[ind-1].value;
      if(oldComb.toUpperCase()==newComb.toUpperCase())
      {
        alert("You can\'t enter duplicate value");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
        return false;
      }
    }
  }
  return true;
}

function siteLoad()
{
 // doQueryMode();
  mode = document.all.screenMode.value;
  if(mode=='')
  {
      doQueryMode();
   }
  
if(mode=='Q')
     {
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
     } 


  if(mode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }


  if(mode=='U')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";

  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  }
//detMenuHandling(mode);
menuHandling(mode);
}
function upper(val)
{
   val.value=val.value.toUpperCase();
}
     
function doBasePrevDetail()
{
    frmMaintHolidayCal.userPageRequested.value = 1*frmMaintHolidayCal.pageRequested.value - 1;
    frmMaintHolidayCal.action = "../../../CalPrevDetailAction.do";
    frmMaintHolidayCal.submit();
}


function doBaseNextDetail()
{
    frmMaintHolidayCal.userPageRequested.value = 1*frmMaintHolidayCal.pageRequested.value + 1;
    frmMaintHolidayCal.action = "../../../CalNextDetailAction.do";
    frmMaintHolidayCal.submit();
}

function JumpDetail()
{
    frmMaintHolidayCal.userPageRequested.value = 1*frmMaintHolidayCal.newPageRequested.value ;
    frmMaintHolidayCal.action = "../../../CalNextDetailAction.do";
    frmMaintHolidayCal.submit();
}
function menuHandling(mode)
{
  if(mode=='' || mode =='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    

      document.all.butnGo.disabled="true";    
  }
  else
  {
      document.all.butQueryMode.disabled="";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_act.jpg";    
      document.all.butSave.disabled="";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_act.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
  }
}

function doQueryMode()
{    
    if(frmMaintHolidayCal.txtParentLoc)
    frmMaintHolidayCal.txtParentLoc.value="";
    frmMaintHolidayCal.action="../../../CalQueryMode.do"
    frmMaintHolidayCal.submit();
}

function enable()
{
   var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;

  for(i=0; i < iTr2 -1; i++)
  {
      
    document.getElementsByName("txtSteName")[i].disabled="";  
   
  }
 }
function doRefresh()
{
 
  frmMaintHolidayCal.action="../../../CalRefresh.do";
  frmMaintHolidayCal.submit();
}
function ShowLoc(lovId)
    {
       frmMaintHolidayCal.queryParam.value="txtLocTyp="+ lovId +" " ;
       frmMaintHolidayCal.lovKey.value = "LocTypId"+ frmMaintHolidayCal.screenName.value + frmMaintHolidayCal.screenMode.value;
       frmMaintHolidayCal.txtDisplayFields.value = "txtParentLoc";
     //  frmMaintSiteDetail.txtSearchFields.value = "Payroll.Site.LocId,Payroll.Site.LocName";
       frmMaintHolidayCal.txtSearchFields.value ="";
       frmMaintHolidayCal.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintHolidayCal');
     //  frmMaintGang.headerDataChanged.value = "true";       
       return true;
    }
 </script>
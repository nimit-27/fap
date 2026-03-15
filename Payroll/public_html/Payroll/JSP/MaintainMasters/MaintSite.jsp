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


<html:form  action="MaintSiteDetailBase" name="frmMaintSiteDetail" type="FCIPAY.Payroll.WEBTIER.Form.MaintSiteDetailForm" scope="session">
<bean:define id="ParentForm" name="frmMaintSiteDetail" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="headerPrimaryKey" />
<html:hidden property="screenMode" name="frmMaintSiteDetail" />
<html:hidden name="frmMaintSiteDetail"  property="screenName" value="SiteMasterScreen" />
<html:hidden name="frmMaintSiteDetail"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintSiteDetail"  />
<html:hidden property="pageRequested" name="frmMaintSiteDetail" />
<html:hidden property="userPageRequested" name="frmMaintSiteDetail" />
<html:hidden property="userPositionRequested" name="frmMaintSiteDetail" />
<html:hidden property="buttonFlag" name="frmMaintSiteDetail"  />
<html:hidden property="lovKey" name="frmMaintSiteDetail"  />
<html:hidden property="txtFields" name="frmMaintSiteDetail"  />   
<html:hidden property="txtSearchFields" name="frmMaintSiteDetail"  />
<html:hidden property="txtDisplayFields" name="frmMaintSiteDetail"  />
<html:hidden property="txtIndex" name="frmMaintSiteDetail"  />
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

            <td class="labelText"  width="25%" >Location Type</td>
            <td width="25%"><html:select property="txtLocTyp" styleClass="required" onchange="doQueryMode()">
                <html:option value="" >-----------Please Select-----------</html:option>      
                 <logic:present name="LocTypes">
                  <html:optionsCollection label="label" value="value" property="locTypList" name="LocTypes"/>
                </logic:present>
                </html:select></td>
           
            <logic:equal name="frmMaintSiteDetail" property="txtLocTyp" value="DP" >    
            <td class="labelText" width="25%" >District Office
            </td>
            <td width="25%">
            <html:text property="txtParentLocDesc" readonly="true" styleClass="required" />
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtParentLoc" onclick="return ShowLoc('DO');" >
            <html:hidden property="txtParentLoc" name="frmMaintSiteDetail" />
            </td>
            </logic:equal>
            <logic:equal name="frmMaintSiteDetail" property="txtLocTyp" value="PO" >    
            <td class="labelText" width="25%" >District Office
            </td>
            <td width="25%">
            <html:text property="txtParentLocDesc" readonly="true" styleClass="required" />
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtParentLoc" onclick="return ShowLoc('DO');" >
            <html:hidden property="txtParentLoc" name="frmMaintSiteDetail" />
            </td>
            </logic:equal>
            <logic:equal name="frmMaintSiteDetail" property="txtLocTyp" value="MD" >    
            <td class="labelText" width="25%" >District Office
            </td>
            <td width="25%">
            <html:text property="txtParentLocDesc" readonly="true" styleClass="required" />
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtParentLoc" onclick="return ShowLoc('DO');" >
            <html:hidden property="txtParentLoc" name="frmMaintSiteDetail" />
            </td>
            </logic:equal>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Location Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                      <td class=tableHeader width="4%"><bean:message key="Payroll.Site.Name" /></td>
                                      <td class=tableHeader width="6%"><bean:message key="Payroll.Site.Address" /></td>
                                      <td class=tableHeader width="3%"><bean:message key="Payroll.Site.State" /></td>
                                      <td class=tableHeader width="3%"><bean:message key="Payroll.Site.Pin" /></td>
                                      <td class=tableHeader width="3%"><bean:message key="Payroll.Site.Phone" /></td>
                                      <td class=tableHeader width="3%"><bean:message key="Payroll.Site.Fax" /></td>
                                      <td class=tableHeader width="3%"><bean:message key="Payroll.Site.Email" /></td>
                                      <td class=tableHeader width="3%"><bean:message key="Payroll.Site.PAN" /></td>
                                      <td class=tableHeader width="3%"><bean:message key="Payroll.Site.TAN" /></td>
                                   </tr> 
                           <logic:iterate id="siteInfo" name="frmMaintSiteDetail" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintSiteDetailBean" >
                              <% ++i; %>
                                <logic:notEqual name="siteInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                       <td align=center ><html:checkbox property="checked" name="frmMaintSiteDetail" onclick="checkRecord();" value="false" /></td>
                                       <td ><html:text property="txtSiteName" name="siteInfo" size="9" disabled="true" maxlength="50"  styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="upper(this); checkDuplicacy('txtSiteName',this.alt); return changed(this.alt);" /></td>
                                       <td ><html:textarea property="txtAddr" name="siteInfo" disabled="true" styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>" rows="1" onchange="return changed(this.alt);" /></td>
                                        <td ><html:text property="txtState" name="siteInfo" size="15" readonly="true" styleClass="required" style="width:75%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" />
                                        <logic:equal name="siteInfo" property="status" value="N" >
                                          <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" alt="<%=String.valueOf(i)%>"  name="buttxtParentLoc" onclick="ShowState(this.alt)" >
                                        </logic:equal>
                                        <logic:notEqual name="siteInfo" property="status" value="N" >
                                          <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" alt="<%=String.valueOf(i)%>"  name="buttxtParentLoc" >
                                        </logic:notEqual>
                                        <html:hidden property="hdnStateCode" name="siteInfo" />
                                        </td>
                                        <td ><html:text property="txtPin" name="siteInfo" disabled="true" maxlength="6" styleClass="optional" size="9" style="width:100%" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt);" /></td>
                                        <td ><html:text property="txtPh" name="siteInfo" disabled="true" maxlength="15" styleClass="optional" size="9" style="width:100%" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt);" /></td>
                                        <td ><html:text property="txtFax" name="siteInfo" disabled="true" maxlength="15" styleClass="optional" size="9" style="width:100%" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 || event.keyCode > 57))return false;" onchange="return changed(this.alt);" /></td>
                                        <td ><html:text property="txtEMail" name="siteInfo" disabled="true" maxlength="60" styleClass="optional" size="9" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="
                                        if(!email_Check(this.value))
                                        {
                                            this.select();
                                        }else{ 
                                          changed(this.alt); 
                                        }" /></td>
                                       <td ><html:text property="txtPan" name="siteInfo" readonly="true" maxlength="15" styleClass="locked" size="9" style="width:100%" alt="<%=String.valueOf(i)%>"  /></td>
                                       <td ><html:text property="txtTan" name="siteInfo" readonly="true" maxlength="15" styleClass="locked" size="9" style="width:100%" alt="<%=String.valueOf(i)%>" /></td>
                                       <html:hidden property="txtSiteId" name="siteInfo" />
                                       <html:hidden property="itemChecked" name="siteInfo" />
                                       <html:hidden property="status" name="siteInfo" />
                                       <html:hidden property="detailId" name="siteInfo" value="Default" />
                                    </tr>
                                  </logic:notEqual>
                                  <logic:equal name="siteInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintSiteDetail" value="notchecked" /></td>
                                       <td ><html:hidden property="txtSiteName" name="siteInfo" /></td>
                                       <td ><html:hidden property="txtAddr" name="siteInfo" /></td>
                                       <td ><html:hidden property="txtState" name="siteInfo" /></td>
                                       <html:hidden property="hdnStateCode" name="siteInfo" />
                                       <td ><html:hidden property="txtPin" name="siteInfo"  /></td>
                                       <td ><html:hidden property="txtPh" name="siteInfo"  /></td>
                                       <td ><html:hidden property="txtEMail" name="siteInfo"  /></td>
                                       <td ><html:hidden property="txtFax" name="siteInfo"  /></td>
                                       <td ><html:hidden property="txtTan" name="siteInfo"  /></td>
                                       <td ><html:hidden property="txtPan" name="siteInfo"  /></td>
                                       
                                       <html:hidden property="txtSiteId" name="siteInfo" /> 
                                       <html:hidden property="itemChecked" name="siteInfo" />
                                       <html:hidden property="status" name="siteInfo" />
                                       <html:hidden property="detailId" name="siteInfo" value="Default"/>
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
  if(mandatory_Check("frmMaintSiteDetail"))
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
  document.forms[0].action = "../../../SiteAddRowAction.do";
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
  var strRecList='';
  var i = 0;
  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("checked")[i].checked)
    {
      if(document.getElementsByName("txtSiteId")[i].value=="" )
        document.getElementsByName("itemChecked")[i].value = "Y";
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
    return false;
  }
   
  //enable();
  document.forms[0].action = "../../../SiteDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintSiteDetail"))
  {
  if(document.frmMaintSiteDetail.txtParentLoc)
  {
    document.frmMaintSiteDetail.headerPrimaryKey.value=document.frmMaintSiteDetail.txtLocTyp.value+", "+document.frmMaintSiteDetail.txtParentLoc.value;
  }
  else
  {
    document.frmMaintSiteDetail.headerPrimaryKey.value=document.frmMaintSiteDetail.txtLocTyp.value+", ";
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
        frmMaintSiteDetail.detailDataChanged.value = "true";
  }

	frmMaintSiteDetail.headerFields.value = "false";
	frmMaintSiteDetail.screenMode.value = "U";
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
	frmMaintSiteDetail.action = "../../../SiteSaveAction.do";
	frmMaintSiteDetail.totalDetailRecord.value=parseInt(iTr2)-1;
	frmMaintSiteDetail.submit();
  }
  else{
  return false;
  }
}

function GetDetail()
{
  if(mandatory_Check("frmMaintSiteDetail"))
  {
    document.all.screenMode.value='U';
    if(document.frmMaintSiteDetail.txtParentLoc)
    {
      document.frmMaintSiteDetail.headerPrimaryKey.value=document.frmMaintSiteDetail.txtLocTyp.value+", "+document.frmMaintSiteDetail.txtParentLoc.value;
    }
    else
    {
      document.frmMaintSiteDetail.headerPrimaryKey.value=document.frmMaintSiteDetail.txtLocTyp.value+", ";
    }
    frmMaintSiteDetail.action="../../../SiteGetDetailAction.do"
    frmMaintSiteDetail.submit();
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
      document.all.butInsert.disabled="disabled";
      document.all.butDelete.disabled="disabled";

  var locTyp=frmMaintSiteDetail.txtLocTyp.value;
  if(locTyp=='DP' || locTyp=='PO' || locTyp=='MD')
  {
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
    
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    for(i=0; i < iTr2 -1; i++)
    {
      
        if(document.getElementsByName("status")[i].value=='N')
        {
          document.getElementsByName("txtSiteName")[i].disabled="";
          document.getElementsByName("txtState")[i].disabled="";
        }
        document.getElementsByName("txtAddr")[i].disabled="";
        document.getElementsByName("txtState")[i].disabled="";
        document.getElementsByName("txtPh")[i].disabled="";
        document.getElementsByName("txtPin")[i].disabled="";
        document.getElementsByName("txtEMail")[i].disabled="";
        document.getElementsByName("txtFax")[i].disabled="";
    }
}  
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
    frmMaintSiteDetail.userPageRequested.value = 1*frmMaintSiteDetail.pageRequested.value - 1;
    frmMaintSiteDetail.action = "../../../SitePrevDetailAction.do";
    frmMaintSiteDetail.submit();
}


function doBaseNextDetail()
{
    frmMaintSiteDetail.userPageRequested.value = 1*frmMaintSiteDetail.pageRequested.value + 1;
    frmMaintSiteDetail.action = "../../../SiteNextDetailAction.do";
    frmMaintSiteDetail.submit();
}

function JumpDetail()
{
    frmMaintSiteDetail.userPageRequested.value = 1*frmMaintSiteDetail.newPageRequested.value ;
    frmMaintSiteDetail.action = "../../../SiteNextDetailAction.do";
    frmMaintSiteDetail.submit();
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
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query.jpg";    
      document.all.butSave.disabled="";    
      document.all.butSave.src="../INCLUDES/IMAGES/save.jpg";    
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
    
     if(frmMaintSiteDetail.txtParentLoc)
     {
      frmMaintSiteDetail.txtParentLoc.value="";
      frmMaintSiteDetail.txtParentLocDesc.value='';
     }
     frmMaintSiteDetail.action="../../../SiteQueryMode.do"
     frmMaintSiteDetail.submit();

}

function doRefresh()
{
 
  frmMaintSiteDetail.action="../../../SiteRefresh.do";
  frmMaintSiteDetail.submit();
}
function ShowLoc(lovId)
    {
       frmMaintSiteDetail.queryParam.value="txtLocTyp="+ lovId +" " ;
       frmMaintSiteDetail.lovKey.value = "LocTypId"+ frmMaintSiteDetail.screenName.value + frmMaintSiteDetail.screenMode.value;
       frmMaintSiteDetail.txtDisplayFields.value = "txtParentLoc,txtParentLocDesc";
     //  frmMaintSiteDetail.txtSearchFields.value = "Payroll.Site.LocId,Payroll.Site.LocName";
       frmMaintSiteDetail.txtSearchFields.value ="";
       frmMaintSiteDetail.txtIndex.value="";  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintSiteDetail');
     //  frmMaintGang.headerDataChanged.value = "true";       
       return true;
    }

function ShowState(indx)
    {
       frmMaintSiteDetail.lovKey.value = "StateCode"+ frmMaintSiteDetail.screenName.value + frmMaintSiteDetail.screenMode.value;
       frmMaintSiteDetail.txtDisplayFields.value = "hdnStateCode,txtState";
       frmMaintSiteDetail.txtSearchFields.value ="";
       frmMaintSiteDetail.txtIndex.value=indx-1;  
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintSiteDetail');
       return true;
    }

 </script>
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
<BODY scroll=no onload="lfnLoad( );" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>
<html:form  action="MaintAgency" name="frmMaintAgency" type="FCIPAY.Payroll.WEBTIER.Form.MaintAgencyForm" scope="session">
<bean:define id="ParentForm" name="frmMaintAgency" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged"  value="false" />
<html:hidden property="headerFields" value="false" />
<html:errors/>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN AGENCY MASTER</TD>
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
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText>Agency Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                              <TD class=tableHeader width="3%"><bean:message  key="Payroll.MaintAgency.code" /></TD>
                                              <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintAgency.name" /></TD>
                                              <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintAgency.add" /></td>
                                              <TD class=tableHeader width="6%"><bean:message  key="Payroll.MaintAgency.pay" /></TD>
                                              <TD class=tableHeader width="3%"><bean:message  key="Payroll.MaintAgency.favour" /></TD>
                                              <TD class=tableHeader width="8%"><bean:message  key="Payroll.MaintAgency.draw" /></td>
                                              <TD class=tableHeader width="3%"><bean:message  key="Payroll.MaintAgency.site" /></td>
                                      </TR>    

                         <logic:iterate id="agencyInfo" name="frmMaintAgency" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintAgencyBean" >
                              <% ++i; %>
                                <logic:notEqual name="agencyInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>

                                      <td align=center ><html:checkbox property="checked" name="frmMaintAgency" onclick="checkRecord();" /></td>
                                       <td ><html:text property="txtAgeCode" name="agencyInfo" size="5"  styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="upper(this); checkDuplicacy('txtAgeCode',this.alt); return changed(this.alt);" /></td>                                               
                                       <td ><html:text property="txtAgeName" name="agencyInfo" size="9"  styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="upper(this); return changed(this.alt)" /></td>                                               
                                       <td ><html:text property="txtAdd" name="agencyInfo" size="35"  styleClass="optional"  alt="<%=String.valueOf(i)%>" onchange="upper(this); return changed(this.alt)" /></td>                                               


                                        <td colspan="1"><html:select property="txtMode" name="agencyInfo"  styleClass="optional" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 100%"  >
                                        <html:option value="">-----------Please Select-----------</html:option>
                                        <html:option value="1">DD</html:option>
                                        <html:option value="2">Cheque</html:option>
                                        <html:option value="3">IUA</html:option>
                                        <html:option value="4">ECS</html:option>
                                        <html:option value="5">Adjustment</html:option>

                                         </html:select></td>  

                                       <td ><html:text property="txtFavour" name="agencyInfo" size="25"  styleClass="optional" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" /></td>                                               
                                       <td ><html:text property="txtDraw" name="agencyInfo" size="6"  styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)" /></td>                                               
                                       <td ><html:text property="txtSite" name="agencyInfo" size="6"  styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="if (num_Check(this.value,1)) changed(this.alt);" /></td>                                               

                                       
                                       <html:hidden property="itemChecked" name="agencyInfo" />
                                       <html:hidden property="status" name="agencyInfo" />
                                       <html:hidden property="detailId" name="agencyInfo" value="Default"/>
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="agencyInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintAgency" value="notchecked" /></td>
                                       <td ><html:hidden property="txtAgeCode" name="agencyInfo" /></td>
                                       <td ><html:hidden property="txtAgeName" name="agencyInfo" /></td>
                                       <td ><html:hidden property="txtAdd" name="agencyInfo" /></td>
                                       <td ><html:hidden property="txtMode" name="agencyInfo" /></td>
                                       <td ><html:hidden property="txtFavour" name="agencyInfo" /></td>
                                       <td ><html:hidden property="txtDraw" name="agencyInfo" /></td>
                                       <td ><html:hidden property="txtSite" name="agencyInfo" /></td>


                                        
                                       <html:hidden property="itemChecked" name="agencyInfo" />
                                       <html:hidden property="status" name="agencyInfo" />
                                       <html:hidden property="detailId" name="agencyInfo" value="Default"/>
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
                                    <TD><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                                    </td>  
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
	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>


<!-- Container Table Ends -->
<html:hidden property="headerPrimaryKey" name="frmMaintAgency" value="Default" />
<html:hidden property="screenMode" name="frmMaintAgency"  />
<html:hidden name="frmMaintAgency"  property="screenName" value="AgencyMasterScreen" />
<html:hidden name="frmMaintAgency"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintAgency"  />
<html:hidden property="pageRequested" name="frmMaintAgency" />
<html:hidden property="userPageRequested" name="frmMaintAgency" />
<html:hidden property="userPositionRequested" name="frmMaintAgency" />
<html:hidden property="buttonFlag" name="frmMaintAgency"  />

</html:form>
</body>
</html:html>

                        
                        
         


<script language="javascript">


var chkMes = 0;
  
 function changed(val)
{
   frmMaintAgency.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}

function doRefresh()
{
  frmMaintAgency.action="../../../AgencyRefresh.do"
  frmMaintAgency.submit();
}

    

function doBaseAddRow()
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
 
        document.getElementsByName("txtAgeCode")[i].disabled="";
  
  }


  document.forms[0].action = "../../../AgencyMasterAddRowAction.do";
  document.forms[0].submit();

}
 
function doBaseDelRow()
{
    //alert("hi");
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
      frmMaintAgency.detailDataChanged.value = "true";      
       
    }

  }
   
  enable();
  document.forms[0].action = "../../../AgencyMasterDeleteRowAction.do";
  document.forms[0].submit();  
  }
 

function SaveRecord()
{
  if(mandatory_Check("frmMaintAgency"))
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
      document.getElementsByName("txtAgeCode")[i].disabled="";

      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintAgency.detailDataChanged.value = "true";
  }

    frmMaintAgency.headerFields.value = "false";
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmMaintAgency.action = "../../../AgencyMasterSaveAction.do";
    frmMaintAgency.totalDetailRecord.value=parseInt(iTr2)-1;
    frmMaintAgency.submit();
}
 else
  {
    return false;
  }
}


function GetDetail()
{
   document.all.screenMode.value='U';
  frmMaintAgency.action="../../../AgencyMasterGetDetailAction.do"
  frmMaintAgency.submit();
}

function lfnLoad()
{
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

  for(i=0; i < iTr2 -1; i++)
  {
     if (document.getElementsByName("status")[i].value == 'Q')
      {      
          
        document.getElementsByName("txtAgeCode")[i].disabled="disabled";
       
        
      }
  }

  }
detMenuHandling(mode);
}

function upper(val)
{
   val.value=val.value.toUpperCase();
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

function upper(val)
{
   val.value=val.value.toUpperCase();
}

function doBasePrevDetail()
{
    frmMaintAgency.userPageRequested.value = 1*frmMaintAgency.pageRequested.value - 1;
    frmMaintAgency.action = "../../../AgencyNextDetailAction.do";
    frmMaintAgency.submit();
}


function doBaseNextDetail()
{
    frmMaintAgency.userPageRequested.value = 1*frmMaintAgency.pageRequested.value + 1;
    frmMaintAgency.action = "../../../AgencyNextDetailAction.do";
    frmMaintAgency.submit();
}

function JumpDetail()
{
    frmMaintAgency.userPageRequested.value = 1*frmMaintAgency.newPageRequested.value ;
    frmMaintAgency.action = "../../../AgencyNextDetailAction.do";
    frmMaintAgency.submit();
}

/*function menuHandling(mode)
{
  if(mode=='')
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
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
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
 

}*/

function doQueryMode()
{     
   frmMaintAgency.action="../../../AgencyQueryMode.do"
   frmMaintAgency.submit();
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
    document.getElementsByName("txtAgeCode")[i].disabled="";  
  }
 } 

 
</script>



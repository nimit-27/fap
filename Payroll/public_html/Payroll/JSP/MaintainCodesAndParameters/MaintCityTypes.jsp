
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
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>


</head>
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />


<html:form  action="MaintCityTypeBase" name="frmMaintCityType" type="FCIPAY.Payroll.WEBTIER.Form.MaintCityTypeForm" scope="session">
<bean:define id="ParentForm" name="frmMaintCityType" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
<html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN CITY TYPES</TD>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>City Type Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                      <td class=tableHeader width="4%"><bean:message key="Payroll.City.type" /></td>
                                      <td class=tableHeader width="6%"><bean:message key="Payroll.City.desc" /></td>
                                      <td class=tableHeader width="17%"><bean:message key="Payroll.City.Cities" /></td>
                                   </tr> 
                           <logic:iterate id="cityInfo" name="frmMaintCityType" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintCityTypeBean" >
                              <% ++i; %>
                                <logic:notEqual name="cityInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>
                                       <td align=center ><html:checkbox property="checked" name="frmMaintCityType" onclick="checkRecord();" /></td>
                                       <td ><html:text property="txtCityType" name="cityInfo" size="9"    styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="upper(this); checkDuplicacy('txtCityType',this.alt); return changed(this.alt);" /></td>
                                       <td ><html:text property="txtDesc" name="cityInfo"  styleClass="required" size="9" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td>
                                       <td ><html:text property="txtCities" name="cityInfo" size="15" styleClass="optional" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="Chk_Char(this.alt,'txtCities'); return changed(this.alt);" /></td>

                                       <html:hidden property="itemChecked" name="cityInfo" />
                                       <html:hidden property="status" name="cityInfo" />
                                       <html:hidden property="detailId" name="cityInfo" value="Default"/>
                                    </tr>
                                  </logic:notEqual>
                                  <logic:equal name="cityInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintCityType" value="notchecked" /></td>
                                       <td ><html:hidden property="txtCityType" name="cityInfo" /></td>
                                       <td ><html:hidden property="txtDesc" name="cityInfo" /></td>
                                       <td ><html:hidden property="txtCities" name="cityInfo" /></td>
                                       <html:hidden property="itemChecked" name="cityInfo" />
                                       <html:hidden property="status" name="cityInfo" />
                                       <html:hidden property="detailId" name="cityInfo" value="Default"/>
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
<html:hidden property="headerPrimaryKey" name="frmMaintCityType" value="Default" />
<html:hidden property="screenMode" name="frmMaintCityType" />
<html:hidden name="frmMaintCityType"  property="screenName" value="CityMasterScreen" />
<html:hidden name="frmMaintCityType"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintCityType"  />
<html:hidden property="pageRequested" name="frmMaintCityType" />
<html:hidden property="userPageRequested" name="frmMaintCityType" />
<html:hidden property="userPositionRequested" name="frmMaintCityType" />
<html:hidden property="buttonFlag" name="frmMaintCityType"  />


</html:form>
</body>
</html:html>

                        
                        
         


<script language="javascript">
    
 function changed(val)
{
  frmMaintCityType.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
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
      
        document.getElementsByName("txtCityType")[i].disabled="";
   
   
  }
  document.forms[0].action = "../../../CityAddRowAction.do";
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


  
  for(i=0; i < iTr2 -1; i++)
  {

    if(document.getElementsByName("checked")[i].checked)
    {
      
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintCityType.detailDataChanged.value = "true";      
    }

  }
   
  enable();
  document.forms[0].action = "../../../CityDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
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
      document.getElementsByName("txtCityType")[i].disabled="";

        if (document.getElementsByName("status")[i].value == 'D')
        frmMaintCityType.detailDataChanged.value = "true";
  }

  frmMaintCityType.headerFields.value = "false";
  document.all.butExecute.disabled="true";
  document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
  frmMaintCityType.action = "../../../CitySaveAction.do";
  frmMaintCityType.totalDetailRecord.value=parseInt(iTr2)-1;
  frmMaintCityType.submit();
}

function GetDetail()
{
  document.all.screenMode.value='U';
  frmMaintCityType.action="../../../CityGetDetailAction.do"
  frmMaintCityType.submit();
}

function Chk_Char(ind,name)
{
 that=document.getElementsByName(name)[ind-1];
 str=that.value;
 for(i=0; i<str.length; i++)
 {
  var city =str.charAt(i);
  if((city >= 'A' && city <= 'Z') ||(city >= 'a' && city <= 'z') || (city == ',') || (city == ' '))
  {}
  else
  {
    alert("Invalid Input");
    that.select();
    that.select();
    that.select();
    that.select();
    that.select();
    that.select();
    return true;
  }
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
          
        document.getElementsByName("txtCityType")[i].disabled="disabled";
       
        
      }
  }

  }
detMenuHandling(mode);
}
function upper(val)
{
   val.value=val.value.toUpperCase();
}
     
function doBasePrevDetail()
{
    frmMaintCityType.userPageRequested.value = 1*frmMaintCityType.pageRequested.value - 1;
    frmMaintCityType.action = "../../../CityPrevDetailAction.do";
    frmMaintCityType.submit();
}


function doBaseNextDetail()
{
    frmMaintCityType.userPageRequested.value = 1*frmMaintCityType.pageRequested.value + 1;
    frmMaintCityType.action = "../../../CityNextDetailAction.do";
    frmMaintCityType.submit();
}

function JumpDetail()
{
    frmMaintCityType.userPageRequested.value = 1*frmMaintCityType.newPageRequested.value ;
    frmMaintCityType.action = "../../../CityNextDetailAction.do";
    frmMaintCityType.submit();
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
    
     
     frmMaintCityType.action="../../../CityQueryMode.do"
     frmMaintCityType.submit();

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
      
        document.getElementsByName("txtCityType")[i].disabled="";
   
   
  }
 }
function doRefresh()
{
 
  frmMaintCityType.action="../../../CityRefresh.do"
  frmMaintCityType.submit();
}

 
</script>


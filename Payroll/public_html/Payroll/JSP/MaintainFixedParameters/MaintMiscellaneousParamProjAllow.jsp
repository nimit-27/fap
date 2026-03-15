<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>


<html:html>
 	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
     <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
     

</head>
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintMiscellaneousParam" name="frmMaintMiscellaneousParam" type="FCIPAY.Payroll.WEBTIER.Form.MaintMiscellaneousParamForm" scope="session">
<bean:define id="ParentForm" name="frmMaintMiscellaneousParam" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/> 

<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN MISCELLANEOUS PARAMETERS</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
  
   <TR>
    <TD>

 <TABLE cellSpacing=0 cellPadding=0 >
       <!--General Information Row Starts -->
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>
         <tr height="15" >
            <td colspan="6"></td>
         </tr>
          
                                 
        </table>
        


    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
 
              
                <TR>
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("wash")> Washing Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > Project Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
<!--                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("over")> Over Time Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>  -->
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("nduty")> Night Duty Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText  onclick=doGetTab("upgrade") > Upgrade Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>

          
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("other")>      Others      <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
          <!--          <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText  onclick=doGetTab("upgrade") > Upgrade Allowance <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
-->

                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
                 <TR height=10>
                   <!-- Detail table Container starts -->
                    <TD colspan=20>
                      <TABLE cellSpacing=0 cellPadding=0 border=0>
                        <TBODY>
                          <TR>
                           <TD >
                            <DIV id=divDtlTable style="height:320px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0  id="Detail" >
                                <TBODY>
                         <TR>
                              <td class=tableHeader width="1%"><html:checkbox property="selectAll" value="" onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                              <td class=tableHeader width="4%"><bean:message key="pay.MaintMiscellaneousParam.amtfrm" /></td>
                              <td class=tableHeader width="4%"><bean:message key="pay.MaintMiscellaneousParam.amtto" /></td>
                              <td class=tableHeader width="5%"><bean:message key="pay.MaintMiscellaneousParam.projallow" /> </td>
                        </tr> 
                          
                          <logic:iterate id="projInfo" name="frmMaintMiscellaneousParam" property="lstProjDtls" type="FCIPAY.Payroll.UTILITY.MiscellaneousParamDtlprojBean" >
                              <% ++i; %>
                                <logic:notEqual name="projInfo" property="status" value="D" >                                                        
                                <tr>
                                  <td align="center" ><html:checkbox property="checked" onclick="checkRecord();" /></td>
                                  <td ><html:text property="startField" name="projInfo"  styleClass="required" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" readonly="true" onchange="return changed(this.alt);"  /></td>
                                  <td><html:text property="endField" name="projInfo"  styleClass="required" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);  changeDtlStartField('startField','endField',this.alt,'0');"  /></td>
                                  <td ><html:text property="txtProjAllow" name="projInfo"  styleClass="required" style="width:100%;text-align:right"  alt="<%=String.valueOf(i)%>" onchange="lfnChange(this.value,this.alt);"  /></td>
                                   <html:hidden property="txtProjSrl" name="projInfo" />
                                   <html:hidden property="itemChecked" name="projInfo" />
                                   <html:hidden property="status" name="projInfo" />
                                   <html:hidden property="detailId" name="projInfo" value="Default"/>
                               </tr>
                        </logic:notEqual>
                        <logic:equal name="projInfo" property="status" value="D" >
                                <tr>
                                  <td align="center" ><html:hidden property="checked" value="notchecked" /></td>
                                  <td ><html:hidden property="startField" name="projInfo"  /></td>
                                  <td><html:hidden property="endField" name="projInfo"  /></td>
                                  <td ><html:hidden property="txtProjAllow" name="projInfo"  /></td>
                                   <html:hidden property="txtProjSrl" name="projInfo" />
                                   <html:hidden property="itemChecked" name="projInfo" />
                                   <html:hidden property="status" name="projInfo" />
                                   <html:hidden property="detailId" name="projInfo" value="Default"/>
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
                              <td colspan=20>	
                                  <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
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
<html:hidden name="frmMaintMiscellaneousParam"  property="screenName" value="MiscProjParamScreen" />
<html:hidden name="frmMaintMiscellaneousParam"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintMiscellaneousParam" />
<html:hidden property="headerPrimaryKey" name="frmMaintMiscellaneousParam" />
<html:hidden property="screenMode" name="frmMaintMiscellaneousParam" />
<html:hidden property="positionRequested" name="frmMaintMiscellaneousParam" />
<html:hidden property="flagProj" name="frmMaintMiscellaneousParam" />
<html:hidden property="pageRequested" name="frmMaintMiscellaneousParam" />
<html:hidden property="userPageRequested" name="frmMaintMiscellaneousParam" />
<html:hidden property="buttonFlag" name="frmMaintMiscellaneousParam"  />


</html:form>
</body>
</html:html>

                        
                        
         


<script language="javascript">

function lfnLoad()
{
  mode = document.all.screenMode.value;
  tot = document.all.flagProj.value;
  if(mode=='')
  {
      doQueryMode();
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
  }
  else
  {
    if(tot == 'true' )
    {
      document.all.butGetDetail.disabled="true";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
    }
    else
    {
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
    }
  }
  if(tot=='true')
  {
      detMenuHandling('U');
  }
  else
  {
      detMenuHandling('Q');
  }

}

 function changed(val)
{
  frmMaintMiscellaneousParam.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}

 function lfnChange(val,ind)
{
    if(num_Check(val,1))
    {
      maxCheck(ind);
      frmMaintMiscellaneousParam.detailDataChanged.value = "true";
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
      alert("Amount To Should be greater than Amount From")
      event.srcElement.select();
      event.srcElement.focus();
      event.returnValue=false;
      return false;                        
    }
    return true;
}

function doBaseAddRow()
{
  if(mandatory_Check("frmMaintMiscellaneousParam"))
  {
      document.forms[0].action = "../../../projAddRowAction.do";
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
  var fl = 0;

  for(i=0; i < iTr2 -1; i++)
  {

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintMiscellaneousParam.detailDataChanged.value = "true";  
      fl = 1;
    }

  }
  if(fl == 0)   
  {
    alert("select atleast one row");
    return false;
  }
     
  document.forms[0].action = "../../../projDeleteRowAction.do";
  document.forms[0].submit();  
}


function GetDetail()
{
  frmMaintMiscellaneousParam.flagProj.value = "true" ;
  frmMaintMiscellaneousParam.screenMode.value = "U" ;
  frmMaintMiscellaneousParam.headerPrimaryKey.value = "#" ;
  frmMaintMiscellaneousParam.action="../../../projFirstGetDetailAction.do"
  frmMaintMiscellaneousParam.submit();
}

function doInsertMode()
{
  frmMaintMiscellaneousParam.action="../../../projNewMode.do"
  frmMaintMiscellaneousParam.submit();
}

function doQueryMode()
{
  frmMaintMiscellaneousParam.action="../../../projQueryMode.do"
  frmMaintMiscellaneousParam.submit();
}


function doRefresh()
{
  frmMaintMiscellaneousParam.action="../../../projRefresh.do"
  frmMaintMiscellaneousParam.submit();
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintMiscellaneousParam"))
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
          if (document.getElementsByName("status")[i].value == 'D')
            frmMaintMiscellaneousParam.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'N')
            frmMaintMiscellaneousParam.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'U')
            frmMaintMiscellaneousParam.detailDataChanged.value = "true";
      }

      frmMaintMiscellaneousParam.headerPrimaryKey.value =  "#" ;
      frmMaintMiscellaneousParam.headerFields.value = "false";
      frmMaintMiscellaneousParam.totalDetailRecord.value = parseInt(iTr2)-1;  
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintMiscellaneousParam.action = "../../../projSaveAction.do";
      frmMaintMiscellaneousParam.submit();
  }
  else
  {
    return false;
  }
}

function doBasePrevDetail()
{
    frmMaintMiscellaneousParam.userPageRequested.value = 1*frmMaintMiscellaneousParam.pageRequested.value - 1;
    frmMaintMiscellaneousParam.action = "../../../projNextDetailAction.do";
    frmMaintMiscellaneousParam.submit();
}


function doBaseNextDetail()
{
    frmMaintMiscellaneousParam.userPageRequested.value = 1*frmMaintMiscellaneousParam.pageRequested.value + 1;
    frmMaintMiscellaneousParam.action = "../../../projNextDetailAction.do";
    frmMaintMiscellaneousParam.submit();
}

function JumpDetail()
{
    frmMaintMiscellaneousParam.userPageRequested.value = 1*frmMaintMiscellaneousParam.newPageRequested.value ;
    frmMaintMiscellaneousParam.action = "../../../projNextDetailAction.do";
    frmMaintMiscellaneousParam.submit();
}

 function doGetTab(arg)
 {
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../ProjTabAction.do";
    document.forms[0].submit();
 }
</script>

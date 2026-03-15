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
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
     

</head>
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintPFDudn" name="frmMaintPFDudn" type="FCIPAY.Payroll.WEBTIER.Form.MaintPFDeductMstForm" scope="session">
<bean:define id="ParentForm" name="frmMaintPFDudn" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN PF DEDUCTION MASTER</TD>
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
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText > PF Deduction Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
                 <TR height=10>
                   <!-- Detail table Container starts -->
                    <TD colspan=17>
                      <TABLE cellSpacing=0 cellPadding=0 border=0>
                        <TBODY>
                          <TR>
                           <TD >
                            <DIV id=divDtlTable style="height:320px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0  id="Detail" >
                                <TBODY>
                     <TR>
                              <td class=tableHeader width="1%"><html:checkbox property="selectAll" value="" onclick="toggleCheckBox('selectAll');checkRecord();"/></td>
                              <td class=tableHeader width="4%"><bean:message key="pay.pfDudnMst.AmtFrom" /></td>
                              <td class=tableHeader width="4%"><bean:message key="pay.pfDudnMst.AmtTo" /></td>
                              <td class=tableHeader width="5%"><bean:message key="pay.pfDudnMst.SubsAmt" /> </td>
    
                        </tr> 
                          
                          <logic:iterate id="pfInfo" name="frmMaintPFDudn" property="lstDudnDetails" type="FCIPAY.Payroll.UTILITY.MaintPFDudnMstBean" >
                              <% ++i; %>
                                <logic:notEqual name="pfInfo" property="status" value="D" >                                                        
                                <tr>
                                  <td align="center" ><html:checkbox property="checked" onclick="checkRecord();"/></td>
                                  <td ><html:text property="startField" name="pfInfo"  styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" readonly="true" onchange="changed(this.value,this.alt);"  /></td>
                                  <td><html:text property="endField" name="pfInfo"  styleClass="required" style="width:100%"  alt="<%=String.valueOf(i)%>" onchange="changed(this.value,this.alt); maxCheck(this.alt); changeDtlStartField('startField','endField',this.alt,'0');"  /></td>
                                  <td ><html:text property="txtSubscripAmt" name="pfInfo"  styleClass="required" style="width:100%"  alt="<%=String.valueOf(i)%>" onchange="changed(this.value,this.alt);"  /></td>
                                   <html:hidden property="txtDudnSrl" name="pfInfo" />
                                   <html:hidden property="itemChecked" name="pfInfo" />
                                   <html:hidden property="status" name="pfInfo" />
                                   <html:hidden property="detailId" name="pfInfo" value="Default"/>
                               </tr>
                        </logic:notEqual>
                        <logic:equal name="pfInfo" property="status" value="D" >
                                <tr>
                                  <td align="center" ><html:hidden property="checked" value="notchecked" /></td>
                                  <td ><html:hidden property="startField" name="pfInfo"  /></td>
                                  <td><html:hidden property="endField" name="pfInfo"  /></td>
                                  <td ><html:hidden property="txtSubscripAmt" name="pfInfo"  /></td>
                                   <html:hidden property="txtDudnSrl" name="pfInfo" />
                                   <html:hidden property="itemChecked" name="pfInfo" />
                                   <html:hidden property="status" name="pfInfo" />
                                   <html:hidden property="detailId" name="pfInfo" value="Default"/>
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
                              <td colspan=17>	
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
<html:hidden name="frmMaintPFDudn"  property="screenName" value="pfDudnMstScreen" />
<html:hidden name="frmMaintPFDudn"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintPFDudn" />
<html:hidden property="headerPrimaryKey" name="frmMaintPFDudn" />
<html:hidden property="screenMode" name="frmMaintPFDudn" />
<html:hidden property="positionRequested" name="frmMaintPFDudn" />
<html:hidden property="pageRequested" name="frmMaintPFDudn" />
<html:hidden property="userPageRequested" name="frmMaintPFDudn" />
<html:hidden property="positionRequested" name="frmMaintPFDudn" />
<html:hidden property="totalCount" name="frmMaintPFDudn" />
<html:hidden property="buttonFlag" name="frmMaintPFDudn"  />


</html:form>
</body>
</html:html>

                        
                        
         


<script language="javascript">

function lfnLoad()
{  
  mode = document.all.screenMode.value;
  if(mode == '')
  {
      doQueryMode();
  }
  
  if(mode=='Q')
  {
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
  }

  if(mode=='U')
  {
      document.all.butGetDetail.disabled="true";
  }

  detMenuHandling(mode);
  
}


 function changed(val,ind)
{
  if(num_Check(val,1))
  {
      frmMaintPFDudn.detailDataChanged.value = "true";
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
  if(mandatory_Check("frmMaintPFDudn"))
  {
      document.forms[0].action = "../../../pfDudnAddRowAction.do";
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


  for(i=0; i < iTr2 -1; i++)
  {

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintPFDudn.detailDataChanged.value = "true";      
    }

  }
     
  document.forms[0].action = "../../../pfDudnDeleteRowAction.do";
  document.forms[0].submit();  
}


function GetDetail()
{
  frmMaintPFDudn.headerPrimaryKey.value = "#" ;
  frmMaintPFDudn.screenMode.value="U";
  frmMaintPFDudn.action="../../../pfDudnFirstGetDetailAction.do"
  frmMaintPFDudn.submit();
}

function doInsertMode()
{
  frmMaintPFDudn.action="../../../pfDudnNewMode.do"
  frmMaintPFDudn.submit();
}

function doQueryMode()
{
  frmMaintPFDudn.action="../../../pfDudnQueryMode.do"
  frmMaintPFDudn.submit();
}

function doRefresh()
{
  frmMaintPFDudn.action="../../../pfDudnRefresh.do"
  frmMaintPFDudn.submit();
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


function maxCheckSave(i)
{
     var low = parseInt(document.getElementsByName("startField")[i-1].value);
     var high = parseInt(document.getElementsByName("endField")[i-1].value);

    if(high <= low )
    {
      alert("Amount To Should be greater than Amount From")
      document.getElementsByName("endField")[i-1].select();
      document.getElementsByName("endField")[i-1].focus();
      //event.returnValue=false;
      return false;                        
    }
    return true;
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintPFDudn"))
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
          if(!(maxCheckSave(i+1)))
          {
              return false;
          }
          if (document.getElementsByName("status")[i].value == 'D')
            frmMaintPFDudn.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'N')
            frmMaintPFDudn.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'U')
            frmMaintPFDudn.detailDataChanged.value = "true";
      }

      frmMaintPFDudn.headerPrimaryKey.value =  "#" ;
      frmMaintPFDudn.headerFields.value = "false";
      frmMaintPFDudn.totalDetailRecord.value = parseInt(iTr2)-1; 
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintPFDudn.action = "../../../pfDudnSaveAction.do";
      frmMaintPFDudn.submit();
  }
  else
  {
    return false;
  }
}


function doBasePrevDetail()
{
    frmMaintPFDudn.userPageRequested.value = 1*frmMaintPFDudn.pageRequested.value - 1;
    frmMaintPFDudn.action = "../../../pfDudnNextDetailAction.do";
    frmMaintPFDudn.submit();
}


function doBaseNextDetail()
{
    frmMaintPFDudn.userPageRequested.value = 1*frmMaintPFDudn.pageRequested.value + 1;
    frmMaintPFDudn.action = "../../../pfDudnNextDetailAction.do";
    frmMaintPFDudn.submit();
}

function JumpDetail()
{
    frmMaintPFDudn.userPageRequested.value = 1*frmMaintPFDudn.newPageRequested.value ;
    frmMaintPFDudn.action = "../../../pfDudnNextDetailAction.do";
    frmMaintPFDudn.submit();
}

</script>
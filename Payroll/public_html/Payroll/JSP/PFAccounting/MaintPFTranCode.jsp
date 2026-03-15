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
<BODY scroll=no onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="PFTranCode" name="frmPFTranCode" type="FCIPAY.Payroll.WEBTIER.Form.PFTranCodeFrom" scope="session">
<bean:define id="ParentForm" name="frmPFTranCode" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>PF TRANSACTION CODES</TD>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText > PF Transaction Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                              <td class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();" /></td>
                              <td class=tableHeader width="4%"><bean:message key="pay.pfTranMst.Code" /></td>
                              <td class=tableHeader width="5%"><bean:message key="pay.pfTranMst.Desc" /></td>
    
                        </tr> 
                          
                          <logic:iterate id="pfInfo" name="frmPFTranCode" property="lstPFtranDetails" type="FCIPAY.Payroll.UTILITY.PFTranCodeBean" >
                              <% ++i; %>
                                <logic:notEqual name="pfInfo" property="status" value="D" >                                                        
                                <tr>
                                  <td align="center" ><html:checkbox property="checked" onclick="checkRecord();" /></td>
                                  <td ><html:text property="txtCode" name="pfInfo"  styleClass="required" style="width:100%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);"  /></td>
                                  <td><html:text property="txtDesc" name="pfInfo"  styleClass="required" style="width:100%"  alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);"  /></td>
                                   <html:hidden property="itemChecked" name="pfInfo" />
                                   <html:hidden property="status" name="pfInfo" />
                                   <html:hidden property="detailId" name="pfInfo" value="Default"/>
                               </tr>
                        </logic:notEqual>
                        <logic:equal name="pfInfo" property="status" value="D" >
                                <tr>
                                  <td align="center" ><html:hidden property="checked" value="notchecked" /></td>
                                  <td ><html:hidden property="txtCode" name="pfInfo"  /></td>
                                  <td><html:hidden property="txtDesc" name="pfInfo"  /></td>
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
<html:hidden name="frmPFTranCode"  property="screenName" value="pfTranCodeScreen" />
<html:hidden name="frmPFTranCode"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmPFTranCode" />
<html:hidden property="headerPrimaryKey" name="frmPFTranCode" />
<html:hidden property="screenMode" name="frmPFTranCode" />
<html:hidden property="positionRequested" name="frmPFTranCode" />
<html:hidden property="pageRequested" name="frmPFTranCode" />
<html:hidden property="userPageRequested" name="frmPFTranCode" />
<html:hidden property="positionRequested" name="frmPFTranCode" />
<html:hidden property="totalCount" name="frmPFTranCode" />
<html:hidden property="buttonFlag" name="frmPFTranCode"  />


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

 function changed(val)
{
  frmPFTranCode.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}


function doBaseAddRow()
{
  if(mandatory_Check("frmPFTranCode"))
  {
      document.forms[0].action = "../../../pfTranAddRowAction.do";
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
      frmPFTranCode.detailDataChanged.value = "true";      
    }

  }
     
  document.forms[0].action = "../../../pfTranDeleteRowAction.do";
  document.forms[0].submit();  
}


function GetDetail()
{
  frmPFTranCode.headerPrimaryKey.value = "#" ;
  frmPFTranCode.screenMode.value="U";
  frmPFTranCode.action="../../../pfTranFirstGetDetailAction.do"
  frmPFTranCode.submit();
}

function doInsertMode()
{
  frmPFTranCode.action="../../../pfTranNewMode.do"
  frmPFTranCode.submit();
}

function doQueryMode()
{
  frmPFTranCode.action="../../../pfTranQueryMode.do"
  frmPFTranCode.submit();
}

function doRefresh()
{
  frmPFTranCode.action="../../../pfTranRefresh.do"
  frmPFTranCode.submit();
}

function SaveRecord()
{
  if(mandatory_Check("frmPFTranCode"))
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
            frmPFTranCode.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'N')
            frmPFTranCode.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'U')
            frmPFTranCode.detailDataChanged.value = "true";
      }

      frmPFTranCode.headerPrimaryKey.value =  "#" ;
      frmPFTranCode.headerFields.value = "false";
      frmPFTranCode.totalDetailRecord.value = parseInt(iTr2)-1; 
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmPFTranCode.action = "../../../pfTranSaveAction.do";
      frmPFTranCode.submit();
  }
  else
  {
    return false;
  }
}

function doBasePrevDetail()
{
    frmPFTranCode.userPageRequested.value = 1*frmPFTranCode.pageRequested.value - 1;
    frmPFTranCode.action = "../../../pfTranNextDetailAction.do";
    frmPFTranCode.submit();
}


function doBaseNextDetail()
{
    frmPFTranCode.userPageRequested.value = 1*frmPFTranCode.pageRequested.value + 1;
    frmPFTranCode.action = "../../../pfTranNextDetailAction.do";
    frmPFTranCode.submit();
}

function JumpDetail()
{
    frmPFTranCode.userPageRequested.value = 1*frmPFTranCode.newPageRequested.value ;
    frmPFTranCode.action = "../../../pfTranNextDetailAction.do";
    frmPFTranCode.submit();
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

</script>
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
<BODY scroll=no onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>


<html:form  action="MaintDsgn" name="frmMaintDsgn" type="FCIPAY.Payroll.WEBTIER.Form.MaintDsgnForm" scope="session">
<bean:define id="ParentForm" name="frmMaintDsgn" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN EMPLOYEE DESIGNATION</TD>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Designation Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                              <TD class=tableHeader width="5%">Designation Description</TD>
                                              <TD class=tableHeader width="2%">Category</TD>
                                              <TD class=tableHeader width="2%">Pay Scale</td>
                                              <TD class=tableHeader width="15%">Pay Scale Range</td>
                                              <td class=tableHeader width="1%">Board Flag</td>                                                                                            
                                              
                                      </TR>    

                         <logic:iterate id="dsgnInfo" name="frmMaintDsgn" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintDsgnBean" >
                              <% ++i; %>
                                <logic:notEqual name="dsgnInfo" property="status" value="D" >                              
                                   <tr>   <% ++j; %>

                                      <td align=center ><html:checkbox property="checked" value="false" name="frmMaintDsgn" onclick="checkRecord();" /></td>
                                      <td colspan="1"><html:text property="txtDsgnDesc" name="dsgnInfo" maxlength="30" styleClass="required" alt="<%=String.valueOf(i) %>" onchange="checkDuplicacy(this.alt); changed(this.alt)" style="WIDTH: 100%"  /></td>  
              
                                       <td colspan="1"><html:select property="txtCtgry" name="dsgnInfo"  styleClass="required" alt="<%=String.valueOf(i) %>" onchange="checkDuplicacy(this.alt); changed(this.alt)" style="WIDTH: 100%"  >
                                      <html:option value="" >-----------Please Select-----------</html:option>      
                                      <logic:present name="EmpCtgry">
                                        <html:optionsCollection label="label" value="value" property="ctgryList" name="EmpCtgry"/>
                                      </logic:present>
                                    </html:select></td>

                                       <td ><html:text property="txtPayScaleCode" name="dsgnInfo" styleClass="required" readonly="true" style="width:70%;text-align:right" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt)" />
                                       <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtPayCode"  onclick="ShowLovPayScaleCode(this.alt);" >
                                       </td>
                                       
                                       <td>
                                       <html:text property="txtPayScaleDesc" name="dsgnInfo" styleClass="locked" style="width:100%;text-align:left" readonly="true" />
                                        </td>
                                        
                                    <td>
                                    <input type="checkbox" name="chkBoardFlg" alt="<%=j%>" onchange="return changed(this.alt)" >
                                    <html:hidden property="txtBoardFlg" name="dsgnInfo" alt="<%=String.valueOf(i) %>" />
                                    </td>                                    
                                       
                                     
                                       <html:hidden property="itemChecked" name="dsgnInfo" />
                                       <html:hidden property="status" name="dsgnInfo" />
                                       <html:hidden property="txtDsgnId" name="dsgnInfo" />
                                       <html:hidden property="detailId" name="dsgnInfo" value="Default"/>
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="dsgnInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintDsgn" value="notchecked" /></td>
                                       <td ><html:hidden property="txtDsgnDesc" name="dsgnInfo" /></td>
                                       <td ><html:hidden property="txtCtgry" name="dsgnInfo" /></td>
                                       <td ><html:hidden property="txtPayScaleCode" name="dsgnInfo" /></td>
                                       <td><html:hidden property="txtPayScaleDesc" name="dsgnInfo" /></td>
                                       <td ><html:hidden property="txtBoardFlg" name="dsgnInfo" /></td>                                                                                                                    
                                       <html:hidden property="itemChecked" name="dsgnInfo" />
                                       <html:hidden property="status" name="dsgnInfo" />
                                       <html:hidden property="detailId" name="dsgnInfo" value="Default"/>
                                       <html:hidden property="txtDsgnId" name="dsgnInfo" />
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
	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>


<!-- Container Table Ends -->
<html:hidden property="headerPrimaryKey" name="frmMaintDsgn" value="Default" />
<html:hidden property="screenMode" name="frmMaintDsgn"  />
<html:hidden name="frmMaintDsgn"  property="screenName" value="DsgnScreen" />
<html:hidden name="frmMaintDsgn"  property="forwardedPage" />
<html:hidden property="buttonFlag" name="frmMaintDsgn"  />
<html:hidden property="lovKey" name="frmMaintDsgn"  />
<html:hidden property="txtFields" name="frmMaintDsgn"  />   
<html:hidden property="txtSearchFields" name="frmMaintDsgn"  />
<html:hidden property="txtDisplayFields" name="frmMaintDsgn"  />
<html:hidden property="txtIndex" name="frmMaintDsgn"  />

<html:hidden property="pageRequested" name="frmMaintDsgn" />
<html:hidden property="userPageRequested" name="frmMaintDsgn" />
<html:hidden property="userPositionRequested" name="frmMaintDsgn" />

</html:form>
</body>
</html:html>


<script language="javascript">

function lfnLoad()
{
  var screenmode = document.all.screenMode.value;
  if(screenmode == '')
  {
      doQueryMode();
  }  
 if(screenmode=='N')
  {
      document.all.butGetDetail.disabled="true";
  }
  if(screenmode=='U')
  {
      document.all.butGetDetail.disabled="disabled";
      document.all.butInsert.disabled="";
      document.all.butDelete.disabled="";
  
  }
  if(screenmode=='Q')
     {
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
     } 

  else
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
         if (document.getElementsByName("txtBoardFlg")[i].value == 'Y')
          {      
                document.getElementsByName("chkBoardFlg")[i].checked="true";        
          }
      }
   }

  detMenuHandling(screenmode);
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

 function changed(val)
{
   frmMaintDsgn.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[val-1].value == 'Q')
     document.getElementsByName("status")[val-1].value = 'U';
}


function doBaseAddRow()
{
  enable();
  if(mandatory_Check("frmMaintDsgn"))
  {
     var oTable = document.getElementById("Detail");
      if(oTable == null)
      {
        return;
      }
     var iTr2 = oTable.rows.length;
      
    document.forms[0].action = "../../../DsgnAddRowAction.do";
    document.forms[0].submit();
  }
  else
  {
      return false;
  }
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintDsgn"))
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
        frmMaintDsgn.detailDataChanged.value = "true";
      else
      {
        if(!checkDuplicacy(i+1))
        {
          return false;
        }
        if(document.getElementsByName("chkBoardFlg")[i].checked)
          document.getElementsByName("txtBoardFlg")[i].value='Y';
        else
          document.getElementsByName("txtBoardFlg")[i].value='N';
      }
  }

  frmMaintDsgn.headerFields.value = "false";
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";

  frmMaintDsgn.action = "../../../DsgnSaveAction.do";
  // frmMaintHraRate.totalDetailRecord.value=parseInt(iTr2)-1;
  frmMaintDsgn.submit();
}
 else
  {
    return false;
  }
}


function doQueryMode()
{
  
  frmMaintDsgn.action="../../../DsgnQueryAction.do"
  frmMaintDsgn.submit();
}

function GetDetail()
{
  document.all.screenMode.value='U'; 
  frmMaintDsgn.action="../../../DsgnGetDetailAction.do"
  frmMaintDsgn.submit();
}


function checkDuplicacy(rInd)
{
  lengthOfTable = document.getElementById("Detail").rows.length;
  newComb = document.getElementsByName("txtDsgnDesc")[rInd-1].value.toUpperCase();
  newCtgry=document.getElementsByName("txtCtgry")[rInd-1].value;

  for(ind = lengthOfTable - 1; ind > 0; ind --)
  {
    if(ind != rInd)
    {
      oldComb = document.getElementsByName("txtDsgnDesc")[ind-1].value.toUpperCase();
      oldCtgry = document.getElementsByName("txtCtgry")[ind-1].value;
      if((oldComb == newComb)&&(oldCtgry==newCtgry))
      {
        alert("You can\'t enter duplicate value");
        document.getElementsByName("txtDsgnDesc")[rInd-1].select();
        document.getElementsByName("txtDsgnDesc")[rInd-1].focus();
        return false;
      }
    }
  }
  return true;
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
      //  document.getElementsByName("txtType")[i].disabled="";
     //   document.getElementsByName("txtTypeofCity")[i].disabled="";
     //   document.getElementsByName("txtHRAAmt")[i].disabled=""         
  }
 }
 

function doRefresh()
{
  frmMaintDsgn.action="../../../DsgnRefresh.do"
  frmMaintDsgn.submit();
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
      if(document.getElementsByName("txtDsgnId")[i].value=="" )
        document.getElementsByName("itemChecked")[i].value = "Y";
      else
        strRecList=strRecList+(i+1)+",";
    }
  }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
   
  document.forms[0].action = "../../../DsgnDeleteRowAction.do";
  document.forms[0].submit();  
}

function ShowLovPayScaleCode(i)
{
  /* if(document.getElementsByName("txtCtgry")[i-1].value=='EMPCTGRY$DPSL')
   {
      return false;
   } */
   frmMaintDsgn.lovKey.value = "PayScaleCode" +frmMaintDsgn.screenName.value + "N";
   frmMaintDsgn.txtDisplayFields.value = "txtPayScaleCode,txtPayScaleDesc";
  // frmMaintDsgn.txtSearchFields.value = "Payroll.Common.Payscale,Payroll.Common.PayscaleRange";
   frmMaintDsgn.txtIndex.value=i-1;  
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintDsgn');
   frmMaintDsgn.detailDataChanged.value = "true";
   changed(i);
   return true;
}

function doBasePrevDetail()
{
    frmMaintDsgn.userPageRequested.value = 1*frmMaintDsgn.pageRequested.value - 1;
    frmMaintDsgn.action = "../../../DsgnPrevDetailAction.do";
    frmMaintDsgn.submit();
}


function doBaseNextDetail()
{
    frmMaintDsgn.userPageRequested.value = 1*frmMaintDsgn.pageRequested.value + 1;
    frmMaintDsgn.action = "../../../DsgnNextDetailAction.do";
    frmMaintDsgn.submit();
}

function JumpDetail()
{
    frmMaintDsgn.userPageRequested.value = 1*frmMaintDsgn.newPageRequested.value ;
    frmMaintDsgn.action = "../../../DsgnNextDetailAction.do";
    frmMaintDsgn.submit();
}
</script>


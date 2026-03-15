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
<BODY onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintKOTWrkSlip" name="frmMaintKotWrkSlip" type="FCIPAY.Payroll.Labour.WEBTIER.Form.MaintKotWrkSlipForm" scope="session">
<bean:define id="ParentForm" name="frmMaintKotWrkSlip" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

 <TABLE cellSpacing=0 bgColor=#bdd0ef>
        <TR height=30>
          <TD  colSpan=11 class=mainHeader height=10>MAINTAIN WORSLIP FOR KOTWAL LABOURS</TD>
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
       <!--  Header Row Starts -->
                <TR>
                  <TD class=subHeader colspan=6>Header For Kotwal Labour Workslip</TD>
                </TR>
                <TR>
                  <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
                </TR>

                <tr height="15" >
                  <td colspan="2"></td>
                </tr>
         
                <tr>
  
           <!-- <td class="labelText">Gang Name</td>
            <td>
            <html:text  property="txtGangName" maxlength="10" size="26" styleClass="required" readonly="true" />
            <html:hidden property="hdnGangId" />
            <logic:equal name="frmMaintKotWrkSlip" property="screenMode" value="U" >
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang"  >
            </logic:equal>
            <logic:notEqual name="frmMaintKotWrkSlip" property="screenMode" value="U" >
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtGang" onclick="return ShowLovGang();" >
            </logic:notEqual>
            </td>-->
              <td class="labelText">WorkSlip ID</td>
            <td>
            <html:text  property="hdnWrkSlipDtlId" maxlength="10" size="26" styleClass="locked" readonly="true" />
            <!--<html:hidden property="hdnGangId" /> 
            <logic:equal name="frmMaintKotWrkSlip" property="screenMode" value="U" >
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtWorkSlipID"  >
            </logic:equal>
            <logic:notEqual name="frmMaintKotWrkSlip" property="screenMode" value="U" >
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtWorkSlipID" onclick="return ShowLovWorkSlip();" >
            </logic:notEqual>  -->
            </td>
           <!-- <td class="labelText">Mukadam</td>
            <td>
            <html:text property="txtMukadam" alt="txtWrkSlipDt" size="26" readonly="true" styleClass="locked" />
            </td>-->
            
        </tr>
        
      <!-- <tr>
  
            <td class="labelText">No of Labours</td>
            <td>
            <html:text  property="txtNoLbrs" maxlength="10" size="26" styleClass="locked" readonly="true" />
            </td>-->

			<td class="labelText">WorkSlip Date</td>
            <td>
            <html:text property="txtWrkSlipDt" alt="txtWrkSlipDt" size="26" readonly="true" styleClass="required" />
               
           <!--    <logic:notEqual name="frmMaintKotWrkSlip" property="screenMode" value="U" >   -->
                <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" onclick="showCalendar('txtWrkSlipDt',this)" />
           <!--    </logic:notEqual>  -->
            </td>
            
        </tr>
        
        
        <tr>
         <td class="labelText"  width="25%" >Work Slip Type</td>
                  <td><html:select property="headerPrimaryKey" styleClass="required" >
                       <html:option value="" >  <bean:message key="Payroll.pleaseSelect" /></html:option>   
                                             <html:option value="A" > A </html:option>
                                             <html:option value="B" > B </html:option>
                                             </html:select>
                  </td>
        </tr>

 <!--<tr>
			<logic:equal name="frmMaintKotWrkSlip" property="screenMode" value="Q" >
			<td class="labelText">Year Month</td>
            <td><html:text property="txtYYMM" styleClass="optional" maxlength="6" /> </td>
       </logic:equal>
       <logic:equal name="frmMaintKotWrkSlip" property="screenMode" value="U" >
			<td class="labelText">Year Month</td>
            <td><html:text property="txtYYMM" styleClass="optional" maxlength="6" readonly="true" /> </td>
       </logic:equal>
       <logic:equal name="frmMaintKotWrkSlip" property="screenMode" value="N" >
        <td class="labelText"></td>
            <td><html:hidden property="txtYYMM" /> </td>
       </logic:equal>
            
        </tr> done by sak 13.2.09-->
           <tr height="10">		    
        <TD colspan="2" > </TD>
      </tr>
   	 </table>
    
       <table cellspacing=0 cellpadding=0 border=0>
          <!-- Detail Information Row starts -->
                <TR height="200">
                  <TD colspan=6>
                    <TABLE cellSpacing=0 cellPadding=0 >
                      <TR>
                        <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#4682B4" nowrap class=actTabText > Labour Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                        
                        <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("WorkSlip")> WorkSlip Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>

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
                                    <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                      <TBODY>
                                        <TR height="22">
                                              <td class=tableHeader width="1%"><html:checkbox property="selectAll" disabled="true"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                             
                                              <TD class=tableHeader width="5%">Labour ID</TD>
                                              <TD class=tableHeader width="25%">Labour Name</td> 
                                              <TD class=tableHeader width="10%">Designation</td> 
                                         <!--     <TD class=tableHeader width="10%">Lead Norm</td>   -->
                                              <TD class=tableHeader width="10%">Incentive</td> 
                                              
                                               </tr> 
<!-- New Ends -->                                               
                         <logic:iterate id="Labour" name="frmMaintKotWrkSlip" property="lstInstrDtlslbr" type="FCIPAY.Payroll.Labour.Utility.MaintKotWrkSlipBean" >
                            <% ++i; %>
                              <logic:notEqual name="Labour" property="status" value="D" >                                                    
                          <tr>
                           <% ++j; %>    
                             <td  width="1%" align="center"><html:checkbox property="checked" onclick="checkRecord();"  /></td>                                                        
                              <td  width="5%" ><html:text property="txtLbrID"  name="Labour" styleClass="optional" alt="<%=String.valueOf(i)%>" style="width:70%;text-align:center"  maxlength="15" />
                                      <logic:equal name="Labour" property="status" value="N">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtAgencySite" onchange="return changed(this.alt);" onclick="ShowEmployeeNo(this.alt);"  >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="Labour" property="status" value="Q">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtAgencySite" onchange="return changed(this.alt);"  onclick="ShowEmployeeNo(this.alt);" >                                       
                                      </logic:equal>                                      
                                      
                                      <logic:equal name="Labour" property="status" value="U">                                        
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtAgencySite" onchange="return changed(this.alt);" onclick="ShowEmployeeNo(this.alt);" >                                       
                                      </logic:equal>
                              <td  width="5%" ><html:text property="txtLbrName" name="Labour" styleClass="locked" alt="<%=String.valueOf(i)%>" readonly="true" style="width:100%;text-align:center"   maxlength="60" /></td>
                              <td  width="5%" ><html:text property="txtLbrDsgn" name="Labour" styleClass="locked" alt="<%=String.valueOf(i)%>" readonly="true"  maxlength="35" style="width:100%;text-align:center"/></td>                                                         
                              <td  width="5%" ><html:text property="txtIncentivelbr" name="Labour" styleClass="optional" alt="<%=String.valueOf(i)%>" readonly="true" style="width:90%;text-align:center"  /></td>                                                         
                              <html:hidden property="itemChecked" name="Labour" />
                           
                              <html:hidden property="status" name="Labour" />    
                              <html:hidden property="detailId" name="Labour" value="Default" />
                              <html:hidden property="txtNormTyp" name="Labour" value="Default" />
                              <html:hidden property="txtBags" name="Labour" value="Default" />
                              <html:hidden property="txtOperId" name="Labour" value="Default" />
                              <html:hidden property="txtOperDesc" name="Labour" value="Default" />
                              <html:hidden property="txtOperDatum" name="Labour" value="Default" />
                              <html:hidden property="txtIncentive" name="Labour"  />
                              <html:hidden property="txtIncentivelbr" name="Labour"  />                              
                              <html:hidden property="txtBagTyp" name="Labour" value="Default" />
                              
                              
                          </tr>
                            </logic:notEqual>
                            <logic:equal name="Labour" property="status" value="D" >
                       <tr>
                              <td  width="1%" ><html:hidden property="checked" value="notchecked" /></td>                                                            
                              <td  width="5%" ><html:hidden property="txtLbrID" name="Labour"  /></td>
                              <td  width="5%" ><html:hidden property="txtLbrName" name="Labour"  /></td>
                              <td  width="5%" ><html:hidden property="txtLbrDsgn" name="Labour"  /></td> 
                              <td  width="5%" ><html:hidden property="txtIncentivelbr" name="Labour"  /></td> 
                              <html:hidden property="txtNormTyp" name="Labour" value="Default" />
                              <html:hidden property="txtBags" name="Labour" value="Default" />
                              <html:hidden property="txtOperId" name="Labour" value="Default" />
                              <html:hidden property="txtOperDesc" name="Labour" value="Default" />
                              <html:hidden property="txtOperDatum" name="Labour" value="Default" />
                              <html:hidden property="txtIncentive" name="Labour"  />
                              <html:hidden property="txtIncentivelbr" name="Labour"  />                              
                              <html:hidden property="txtBagTyp" name="Labour" value="Default" />   
                              
                              <html:hidden property="itemChecked" name="Labour" />
                       
                              <html:hidden property="status" name="Labour" />
                              <html:hidden property="detailId" name="Labour" value="Default" />
                          </tr>     
                        </logic:equal>                              
                </logic:iterate>
                       </TBODY>
                     </TABLE>
                    </DIV>
                   </TD>
                  </TR>                     
                  
   <!-- Get details starts -->
	         
        </TBODY>
		    </TABLE>
		  </td>
    </tr>

<!-- Tab table Row 3 starts -->
               <tr>
		<TD background="../INCLUDES/IMAGES/line_r.gif"><IMG src="../INCLUDES/IMAGES/pixel.gif" border=0></TD>
		</TR>
    <TR>
     <TD align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
    </TR>

</TABLE>
        </td>
	</tr>
                <!-- Tab Table Ends -->
<tr>
		          <td colspan=8>	
                  <TABLE border=0>
                    <TBODY>
                    <TR><td><jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                    </td></TR>
                  </TBODY>
                </TABLE>
               </TD>               
            </tr>

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

<html:hidden name="frmMaintKotWrkSlip"  property="screenMode"  />
<html:hidden name="frmMaintKotWrkSlip"  property="screenName" value="LabourWrkSlipScreen" />
<html:hidden name="frmMaintKotWrkSlip"  property="forwardedPage" />
<html:hidden property="totalDetailRecord" name="frmMaintKotWrkSlip"  />
<html:hidden property="buttonFlag" name="frmMaintKotWrkSlip"  />
<html:hidden property="userPageRequested" name="frmMaintKotWrkSlip" />
<html:hidden property="pageRequested" name="frmMaintKotWrkSlip" />
<html:hidden name="frmMaintKotWrkSlip"  property="loginLocCode"  />

<html:hidden property="lovKey" name="frmMaintKotWrkSlip"  />
<html:hidden property="txtFields" name="frmMaintKotWrkSlip"  />   
<html:hidden property="txtSearchFields" name="frmMaintKotWrkSlip"  />
<html:hidden property="txtDisplayFields" name="frmMaintKotWrkSlip"  />
<html:hidden property="txtIndex" name="frmMaintKotWrkSlip"  />
<html:hidden property="txtInputField" name="frmMaintKotWrkSlip"  />
<html:hidden property="headerDataChanged" name="frmMaintKotWrkSlip"  />
<html:hidden property="headerPrimaryKey" name="frmMaintKotWrkSlip"  />
<html:hidden property="positionRequested" name="frmMaintKotWrkSlip" />
<html:hidden property="userPositionRequested" name="frmMaintKotWrkSlip" />
<html:hidden property="txtTotBags" name="frmMaintKotWrkSlip" />

<input type="hidden" name="queryParam" />
<input type="hidden" name="multipleFlag" />

</html:form>
</body>
</html:html>

<script language="javascript">




var chkMes =0;
   function doGetTab(arg)
  {
    frmMaintKotWrkSlip.headerPrimaryKey[0].disabled="";
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../WrkSlipKOTLbrTabAction.do";
    document.forms[0].submit();
  }
  
  
  
/*
function changed(val)
{ 
  frmMaintKotWrkSlip.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
    document.getElementsByName("status")[val-1].value = 'U';
  document.getElementsByName("txtIncentive")[val-1].value = '';
}
*/
function ShowLovEmpNo()
{
   frmMaintKotWrkSlip.lovKey.value = "LabourID" + frmMaintKotWrkSlip.screenName.value + frmMaintKotWrkSlip.screenMode.value;   
   frmMaintKotWrkSlip.txtDisplayFields.value ="txtLbrID";// "txtEmpNo,txtEmpName,txtDsgnDesc,txtCategDesc,txtDOR,txtEmpStatus,txtEmpType,txtCpfCode,txtDOJSite";      
   frmMaintKotWrkSlip.txtSearchFields.value = "";//"Payroll.Common.empName,Payroll.Common.cpfCode,Payroll.Common.Dsgn";   
   frmMaintKotWrkSlip.queryParam.value = "txtSiteID="+frmMaintKotWrkSlip.loginLocCode.value+",hdnEmpLbrFlag="+frmMaintKotWrkSlip.hdnEmpLbrFlag.value;    
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintKotWrkSlip');
   return true;
}

function datumChanged(val)
{ 
  
  var datumVal=document.getElementsByName("txtOperDatum")[val-1].value;
  
  if (datumVal =="" || datumVal == null)
  {
      document.getElementsByName("txtBagTyp")[val-1].disabled = "false"; 
      document.getElementsByName("txtNormTyp")[val-1].disabled = "false"; 
  }
  else
  {
      document.getElementsByName("txtBagTyp")[val-1].disabled = ""; 
      document.getElementsByName("txtNormTyp")[val-1].disabled = ""; 
  }
  return true;
}

function doGetNextHeader()
{   
    document.all.buttonFlag.value='';
    frmMaintKotWrkSlip.userPositionRequested.value = 1*frmMaintKotWrkSlip.positionRequested.value + 1;
    document.forms[0].action="../../../NewWrkSlipKOTGetNextHeader.do";
    document.forms[0].submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmMaintKotWrkSlip.userPositionRequested.value = 1*frmMaintKotWrkSlip.positionRequested.value - 1;
    document.forms[0].action="../../../WrkSlipKOTGetNextHeader.do";
    document.forms[0].submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmMaintKotWrkSlip.userPositionRequested.value = 1*frmMaintKotWrkSlip.newPositionRequested.value;
    document.forms[0].action="../../../WrkSlipKOTGetNextHeader.do";
    document.forms[0].submit();
}

function doBasePrevDetail()
{
    frmMaintKotWrkSlip.userPageRequested.value = 1*frmMaintKotWrkSlip.pageRequested.value - 1;
    frmMaintKotWrkSlip.action = "../../../NewWrkSlipKOTNextDetailAction.do";
    frmMaintKotWrkSlip.submit();
}

function doBaseNextDetail()
{
    frmMaintKotWrkSlip.userPageRequested.value = 1*frmMaintKotWrkSlip.pageRequested.value + 1;
    frmMaintKotWrkSlip.action = "../../../WrkSlipKOTNextDetailAction.do";
    frmMaintKotWrkSlip.submit();
}

function JumpDetail()
{
    frmMaintKotWrkSlip.userPageRequested.value = 1*frmMaintKotWrkSlip.newPageRequested.value;
    frmMaintKotWrkSlip.action = "../../../WrkSlipKOTNextDetailAction.do";
    frmMaintKotWrkSlip.submit();
}

/*
function doBaseAddRow()
{
 // EnableFields();
  if(mandatory_Check("frmMaintKotWrkSlip"))
  {
    //document.all.buttonFlag.value='D';
  frmMaintKotWrkSlip.headerPrimaryKey.disabled="";
 //  enableBagLeadTyp();    
   document.forms[0].action = "../../../NewWrkSlipKOTAddRowAction.do";
  document.forms[0].submit();
  }
  else
  {
      return false;
  }
}
*/
//added on 17.2.09 starts

function doBaseAddRow()
{    
    document.all.buttonFlag.value='D';    
    if(!mandatory_Check("frmMaintKotWrkSlip"))
     return false;
    
    //document.getElementById("txtEmpNo").disabled="";    
    document.forms[0].action = "../../../NewWrkSlipKOTAddRowAction.do";
    document.forms[0].submit();   
}

//added on 17.2.09 ends

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
       
  for(i=0; i < iTr2 -1; i++)
  {

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintKotWrkSlip.detailDataChanged.value = "true";   
      document.all.buttonFlag.value='D';
    }

  }
 // EnableFields();
  enableBagLeadTyp();    
  frmMaintKotWrkSlip.headerPrimaryKey.disabled="";
  document.forms[0].action = "../../../NewWrkSlipKOTDeleteRowAction.do";
  document.forms[0].submit();  
}



function GetDetail()
{
   document.all.buttonFlag.value='';
 // frmMaintKotWrkSlip.flagAll.value="true";
  frmMaintKotWrkSlip.headerPrimaryKey.value=frmMaintKotWrkSlip.headerPrimaryKey.value;
  document.all.screenMode.value='U';
  frmMaintKotWrkSlip.headerPrimaryKey.disabled="";
  frmMaintKotWrkSlip.action="../../../NewWrkSlipKOTGetDetailAction.do"
  frmMaintKotWrkSlip.submit();
}

function DelRecord()
{
  var oTable = document.getElementById("Detail");
  var iTr2 = oTable.rows.length;
  document.all.screenMode.value='D';
  document.all.buttonFlag.value='';
  frmMaintKotWrkSlip.headerPrimaryKey.value=frmMaintKotWrkSlip.headerPrimaryKey.value;
  frmMaintKotWrkSlip.headerFields.value = "false";
  document.all.headerDataChanged.value='true';
  frmMaintKotWrkSlip.totalDetailRecord.value = parseInt(iTr2,10) - 1;
  frmMaintKotWrkSlip.action = "../../../NewWrkSlipKOTDelRecordAction.do";
  frmMaintKotWrkSlip.submit();
}

function SaveRecord()
{
  //EnableFields();  
// alert('SAVE');  
if(!checkMandatory())
        return false;     

  if(!mandatory_Check("frmMaintKotWrkSlip"))
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

  
  for(i=0; i < iTr2 -2; i++)
  {
      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintKotWrkSlip.detailDataChanged.value = "true";
        
  }
  document.all.buttonFlag.value='';
  frmMaintKotWrkSlip.headerPrimaryKey.value=frmMaintKotWrkSlip.headerPrimaryKey.value;
  frmMaintKotWrkSlip.headerFields.value = "true";
  if ( document.all.screenMode.value == "N")
      document.all.headerDataChanged.value='true';
       enableBagLeadTyp();    
  frmMaintKotWrkSlip.totalDetailRecord.value = parseInt(iTr2,10) - 1;
  document.all.butSave.disabled="true";
  document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  frmMaintKotWrkSlip.action = "../../../NewWrkSlipKOTSaveAction.do";
  frmMaintKotWrkSlip.submit();
}

function doInsertMode()
{
  if ( document.all.screenMode.value == "Q")
      document.all.headerDataChanged.value='';
      
  document.all.buttonFlag.value='';
  frmMaintKotWrkSlip.action="../../../NewWrkSlipKOTNewMode.do"
  frmMaintKotWrkSlip.submit();

}

function doQueryMode()
{
  document.all.buttonFlag.value='';
 //frmMaintKotWrkSlip.headerPrimaryKey.value="";
 
 //frmMaintKotWrkSlip.butInsert.disabled="true";
 //frmMaintKotWrkSlip.butDelete.disabled="true";
 frmMaintKotWrkSlip.action="../../../NewWrkSlipKOTQueryMode.do"
 frmMaintKotWrkSlip.submit();
document.all.butGetDetail.disabled="true";
}


/*
function lfnLoad()
{
   // Newfunction();
   var mode = document.all.screenMode.value;
    
   //alert("mode------"+mode); 
    if(mode=='')
    {
        doQueryMode();
    }    
    if(mode=='Q')
    {
      document.all.butInsert.disabled="true";
     document.all.butExecute.disabled="true";    
     document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    }
    if(mode=='U')
    {
      document.all.butGetDetail.disabled="true";
      document.all.butInsert.disabled="";
    }

   if(mode=='N')
  {
      document.all.butGetDetail.disabled="";
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
   //   checkLbrTyp();
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

*/
//commented by Gagan on 23/02/09

function lfnLoad()
{
    mode=document.all.screenMode.value;
    frmMaintKotWrkSlip.butGetDetail.disabled="true";
    frmMaintKotWrkSlip.butInsert.disabled="true";
    frmMaintKotWrkSlip.butDelete.disabled="true";
     if(mode=='')
      {
        doQueryMode();
      }
 
    if (frmMaintKotWrkSlip.screenMode.value == 'U')
    { 
              frmMaintKotWrkSlip.butGetDetail.disabled="";
              frmMaintKotWrkSlip.butInsert.disabled="";
              frmMaintKotWrkSlip.butDelete.disabled="";
    }
        if (frmMaintKotWrkSlip.screenMode.value == 'N')
    {
        frmMaintKotWrkSlip.butInsert.disabled="";
         document.all.butGetDetail.disabled="";
    }
if (frmMaintKotWrkSlip.screenMode.value == 'Q')
    {
        frmMaintKotWrkSlip.butInsert.disabled="";
         document.all.butGetDetail.disabled="";
    }

  menuHandling(mode);
//  calcTotInc();
//disabBagNormTyp();
}

function disabBagNormTyp()
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
        if (document.getElementsByName("txtOperDatum")[i].value =="" || document.getElementsByName("txtOperDatum")[i].value == null)
        {
            document.getElementsByName("txtBagTyp")[i].disabled = "false"; 
            document.getElementsByName("txtNormTyp")[i].disabled = "false"; 
        }
        else
        {
            document.getElementsByName("txtBagTyp")[i].disabled = ""; 
            document.getElementsByName("txtNormTyp")[i].disabled = ""; 
        }
   }
}  

function enableBagLeadTyp()
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
        
        document.getElementsByName("txtBagTyp")[i].disabled = ""; 
        document.getElementsByName("txtNormTyp")[i].disabled = "";
        
   }
}

function doRefresh()
{  
    frmMaintKotWrkSlip.action = "../../../NewWrkSlipKOTRefresh.do";
    frmMaintKotWrkSlip.submit();
}

function ShowSite()
    {
       frmMaintKotWrkSlip.lovKey.value = "SiteId" + frmMaintKotWrkSlip.screenName.value + "Q";
       frmMaintKotWrkSlip.txtDisplayFields.value = "txtSiteId,txtSiteName";
       frmMaintKotWrkSlip.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
       frmMaintKotWrkSlip.txtIndex.value="";
       frmMaintKotWrkSlip.txtInputField.value="";
       frmMaintKotWrkSlip.multipleFlag.value = "";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintKotWrkSlip');
       return true;
    }
function ShowLovGang()
    {
       frmMaintKotWrkSlip.queryParam.value="txtSiteID="+ frmMaintKotWrkSlip.loginLocCode.value +",txtLbrTyp=KOT" ;    
       frmMaintKotWrkSlip.lovKey.value = "GangList" + frmMaintKotWrkSlip.screenName.value + "Q";
       frmMaintKotWrkSlip.txtDisplayFields.value = "hdnGangId,txtGangName,txtNoLbrs,txtMukadam";
       frmMaintKotWrkSlip.txtSearchFields.value = "Labours.txtGangName";
       frmMaintKotWrkSlip.txtIndex.value="";
       frmMaintKotWrkSlip.txtInputField.value="";
       frmMaintKotWrkSlip.multipleFlag.value = "";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintKotWrkSlip');
       return true;
    }

  function ShowSlab(i)
    {
      if(document.getElementsByName("txtNormTyp")[i-1].value!='OT_ABOVE' && document.getElementsByName("txtNormTyp")[i-1].value!='ABOVE')
      {
         frmMaintKotWrkSlip.queryParam.value="txtMou="+ frmMaintKotWrkSlip.hdnMou.value +" ,txtNormTyp= "+document.getElementsByName("txtNormTyp")[i-1].value+",txtBagTyp="+document.getElementByName("txtBagTyp").value ;    
         frmMaintKotWrkSlip.lovKey.value = "WrkSlipNormSlab" + frmMaintKotWrkSlip.screenName.value + frmMaintKotWrkSlip.screenMode.value;
         frmMaintKotWrkSlip.txtDisplayFields.value = "hdnSlabId,txtSlab";
         frmMaintKotWrkSlip.txtIndex.value=i-1;
         frmMaintKotWrkSlip.txtSearchFields.value = "";
         frmMaintKotWrkSlip.txtInputField.value="";
         frmMaintKotWrkSlip.multipleFlag.value = "";
         showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintKotWrkSlip');
         return true;
      }
       return false;
    }

function ShowOperation(i)
    {
       frmMaintKotWrkSlip.queryParam.value="txtSiteID="+ frmMaintKotWrkSlip.loginLocCode.value+",txtOperId= "+frmMaintKotWrkSlip.txtOperId.value+",hdnGangId="+frmMaintKotWrkSlip.hdnGangId.value+",txtWrkSlipDt="+frmMaintKotWrkSlip.txtWrkSlipDt.value;    
       frmMaintKotWrkSlip.lovKey.value = "WrkSlipOper" + frmMaintKotWrkSlip.screenName.value + frmMaintKotWrkSlip.screenMode.value;
       frmMaintKotWrkSlip.txtDisplayFields.value = "txtOperId,txtOperDesc,txtOperDatum";
       frmMaintKotWrkSlip.txtIndex.value=i-1;
       frmMaintKotWrkSlip.txtSearchFields.value = "";
       frmMaintKotWrkSlip.txtInputField.value="txtOperDesc";
       frmMaintKotWrkSlip.multipleFlag.value = "";
       showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintKotWrkSlip');
       return true;
    }

  function ShowEmp(i)
    {
        /* if(document.getElementsByName("txtEndHrs")[i-1].value=='' || document.getElementsByName("txtEndMin")[i-1].value=='')
         {
          alert("Please enter the end time first");
          return false;
         }
         */
         frmMaintKotWrkSlip.queryParam.value="hdnGangId="+ frmMaintKotWrkSlip.hdnGangId.value+",txtWrkSlipDt="+frmMaintKotWrkSlip.txtWrkSlipDt.value+",txtEndHrs= "+document.getElementsByName("txtEndHrs")[i-1].value+",txtEndMin= "+document.getElementsByName("txtEndMin")[i-1].value;    
         frmMaintKotWrkSlip.lovKey.value = "WrkSlipEmpList" + frmMaintKotWrkSlip.screenName.value + frmMaintKotWrkSlip.screenMode.value;
         frmMaintKotWrkSlip.txtDisplayFields.value = "txtEmpList";
         frmMaintKotWrkSlip.txtIndex.value=i-1;
         frmMaintKotWrkSlip.txtSearchFields.value = "";
         frmMaintKotWrkSlip.multipleFlag.value = "true";
         frmMaintKotWrkSlip.txtInputField.value = "";
         showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintKotWrkSlip');
         return true;
    }
    
function doSetFields(arrList,arrLength,arrCols)
{
  var arrEmpNo=new Array();
   var arrEmpName=new Array();
 // arr=arrList;
  for( i=0;i<arrList.length;i++)
  {
     arrEmpNo[i]=arrList[i][0];
     arrEmpName[i]=arrList[i][1];
  }
  var indx=frmMaintKotWrkSlip.txtIndex.value;
  document.getElementsByName("txtEmpList")[indx].value=arrEmpNo;
  //document.getElementsByName("txtEmpNameList")[indx].value=arrEmpName;
}
 function getHeaderRecord()
 {
   if(checkHeaderMandatory())
   {
    document.all.buttonFlag.value=''; 
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmMaintKotWrkSlip.action="../../../NewWrkSlipKOTGetHeaderAction.do";
    frmMaintKotWrkSlip.submit();
   }
 }
 
 //function checkHeaderMandatory()
 //{
 //   if(document.all.txtGangName.value=="")
 //   {
  //    alert("Please Select/Enter Gang ");
     // document.all.buttxtGang.setFocus();
  //    return false;
  //  }
  //  return true;
//}

function checkNormTyp(normTyp,i)
{
  if(normTyp=='OT_ABOVE' || normTyp=='ABOVE')
  {
    document.getElementsByName("txtStartHrs")[i-1].disabled="";
    document.getElementsByName("txtStartHrs")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtStartMin")[i-1].disabled="";
    document.getElementsByName("txtStartMin")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtEndHrs")[i-1].disabled="";
    document.getElementsByName("txtEndHrs")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtEndMin")[i-1].disabled="";
    document.getElementsByName("txtEndMin")[i-1].style.background="#ffffd3";
    document.getElementsByName("buttxtEmp")[i-1].disabled="";
    document.getElementsByName("txtEmpList")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtEmpList")[i-1].style.className="required";
    document.getElementsByName("txtSlab")[i-1].style.background="#ffffff";
    document.getElementsByName("txtSlab")[i-1].style.className="locked";
  }
  else
  {
    document.getElementsByName("txtStartHrs")[i-1].disabled="true";
    document.getElementsByName("txtStartHrs")[i-1].style.background="#ffffff";
    document.getElementsByName("txtStartMin")[i-1].disabled="true";
    document.getElementsByName("txtStartMin")[i-1].style.background="#ffffff";
    document.getElementsByName("txtEndHrs")[i-1].disabled="true";
    document.getElementsByName("txtEndHrs")[i-1].style.background="#ffffff";
    document.getElementsByName("txtEndMin")[i-1].disabled="true";
    document.getElementsByName("txtEndMin")[i-1].style.background="#ffffff";
    document.getElementsByName("buttxtEmp")[i-1].disabled="true";
    document.getElementsByName("txtEmpList")[i-1].style.background="#ffffff";
    document.getElementsByName("txtEmpList")[i-1].style.className="locked";
    document.getElementsByName("txtSlab")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtSlab")[i-1].style.className="required";
  }

}

function EnableFields()
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
    if(document.getElementsByName("status")[i].value!=='D')
    {
     document.getElementsByName("txtStartHrs")[i].disabled=""; 
     document.getElementsByName("txtStartMin")[i].disabled=""; 
     document.getElementsByName("txtEndHrs")[i].disabled=""; 
     document.getElementsByName("txtEndMin")[i].disabled=""; 
    }
  }

}

function checkMandatoryNorm()
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
     document.getElementsByName("txtOTHrs")[i].disabled=""; 
  }

}

function checkMandatory()
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
 /*    if(document.getElementsByName("status")[i].value!='D')
     {
       if(document.getElementsByName("txtIncentive")[i].value=='')
       {
        alert("Please Calculate the incentive before saving the record");
        return false;
       }
     }  */
  } 
  return true;
}

function calcIncentive()
{
    calcTotBags();
     enableBagLeadTyp();    
    frmMaintKotWrkSlip.action = "../../../WrkSlipKOTCalcIncentiveAction.do";
    frmMaintKotWrkSlip.submit();
}

function calcTotBags()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  var TotBags=0;

  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("status")[i].value!='D')
    {
      TotBags=parseInt(TotBags,10)+parseInt(document.getElementsByName("txtBags")[i].value,10);
    }
  } 
  document.all.txtTotBags.value=TotBags;
}

function calcTotInc()
{
  var oTable = document.getElementById("Detail");
  if(oTable == null)
  {
    return;
  }
  var iTr2 = oTable.rows.length;
  var i = 0;
  var TotInc=0;

  for(i=0; i < iTr2 -1; i++)
  {
    if(document.getElementsByName("status")[i].value!='D')
    {
      TotInc=parseFloat(TotInc)+parseFloat(document.getElementsByName("txtIncentive")[i].value);
    }
  } 
  document.all.txtTotIncentive.value=Math.round(TotInc);
}

function ShowEmployeeNo(i)
{
   frmMaintKotWrkSlip.lovKey.value = "KotWrkslipLbrID" + frmMaintKotWrkSlip.screenName.value + frmMaintKotWrkSlip.screenMode.value;
   frmMaintKotWrkSlip.queryParam.value="txtSiteID="+ frmMaintKotWrkSlip.loginLocCode.value +"" ;
   frmMaintKotWrkSlip.txtDisplayFields.value = "txtLbrID,txtLbrName,txtLbrDsgn";
  // frmMaintKotWrkSlip.txtDisplayFields.value = "txtLbrID";
   frmMaintKotWrkSlip.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.LoanForeclosure.CPFCode,pay.MaintainAnnualIncome.txtEmpName";
   frmMaintKotWrkSlip.txtIndex.value = i-1;      
   frmMaintKotWrkSlip.txtInputField.value =""; 
   
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintKotWrkSlip');
   return true;
}

 function changed(i)
{
  frmMaintKotWrkSlip.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[i-1].value == 'Q')
     document.getElementsByName("status")[i-1].value = 'U';
}
</script>
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

<html:form  action="MaintKOTWrkSlip" name="frmMaintKotWrkSlip" type="FCIPAY.Payroll.Labour.WEBTIER.Form.MaintKotWrkSlipForm" scope="session">
<bean:define id="ParentForm" name="frmMaintKotWrkSlip" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>


<!--container table starts -->
 <TABLE cellSpacing=0 cellPadding=0>
  <TBODY>
  <tr>
  
  </tr>
    <TR height="">
      <TD colspan=1>
      
    <TABLE cellSpacing=0 bgColor=#bdd0ef>
      <TR height=30>
        <TD  colSpan=11 class=mainHeader height=10>MAINTAIN WORKSLIP DETAILS FOR KOTWAL UNION</TD>
      </TR>
      <tr height="10"><td class=userText colspan="11"></td></tr>  
    </TABLE>
    <TABLE cellSpacing=0 cellPadding=0 border=0 >
    <TBODY>
    <TR>
      <TD>         
      <!-- Body table Starts -->
        <TABLE cellSpacing=0 cellPadding=0>
              <!--Account  Header Row Starts -->
                <TR>
                  <TD class=subHeader colspan=2>Header For Kotwal Workslip Details</TD>
              </TR>
              <TR>
                <TD colspan=11 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
              </TR>

              <tr height="15" >
                <td colspan="2"></td>
              </tr>                
            <tr >
            <td class="labelText">Location/Depot Name</td>
            <td colspan="3"><html:text  property="txtLocId" maxlength="10" size="15" styleClass="required" readonly="true" />            
            <logic:equal name="frmMaintKotWrkSlip" property="screenMode" value="U" >            
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" >
            </logic:equal>            
            <logic:notEqual name="frmMaintKotWrkSlip" property="screenMode" value="U" >
            <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSite" onclick="return ShowSite();" >
            </logic:notEqual>            
            <html:text  property="txtLoc" maxlength="10" styleClass="locked" size="40" readonly="true" />
            </td>
            </tr>    
              
            <tr> 
           
            <TD class=labelText>WorkSlip ID</TD>
            <td align="left" >
            <logic:notEqual property= "screenMode" name= "frmMaintKotWrkSlip" value="Q">                                                
            <html:text  property="hdnWrkSlipId" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="locked" readonly="true" />
            </logic:notEqual>                                                                    
            <logic:equal property= "screenMode" name= "frmMaintKotWrkSlip" value="Q">                              
            <html:text  property="hdnWrkSlipId" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required"  />            
            </logic:equal>               
            </td>   
    
          <TD class=labelText>WorkSlip Date</TD>
          <td align="left" >
          <logic:notEqual property= "screenMode" name= "frmMaintKotWrkSlip" value="U">                                                
          <html:text property="txtWrkSlipDt" alt="txtWrkSlipDt" size="26" readonly="true" styleClass="required" />
          <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" onclick="showCalendar('txtWrkSlipDt',this)" />
          </logic:notEqual>                                                                    
          <logic:equal property= "screenMode" name= "frmMaintKotWrkSlip" value="U">                              
          <html:text property="txtWrkSlipDt" alt="txtWrkSlipDt" size="26" readonly="true" styleClass="locked" />
          </logic:equal>               
          </td>  
        </tr>
        
        
        <tr>
          <td class="labelText">Year Month</td>
          <logic:equal name="frmMaintKotWrkSlip" property="screenMode" value="Q" >			
          <td><html:text property="txtYYMM" styleClass="optional" maxlength="6" /> </td>
          </logic:equal>
          
          <logic:notEqual name="frmMaintKotWrkSlip" property="screenMode" value="Q" >			
          <td><html:text property="txtYYMM" styleClass="locked" maxlength="6" readonly="true" /></td>
          </logic:notEqual>
       
          <td class="labelText"  width="25%" >Work Slip Type</td>
          <td><html:select property="txtWrkSlipTyp" name= "frmMaintKotWrkSlip" styleClass="required" >
          <html:option value="" >  <bean:message key="Payroll.pleaseSelect" /></html:option>   
          <html:option value="A" > A </html:option>
          <html:option value="B" > B </html:option>
          </html:select>
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
                    
                        <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTab("Labour")> Labour Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                        
                        <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                        <td bgcolor="#4682B4" nowrap class=actTabText  > WorkSlip Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                           <TD colspan="2">
                            <DIV id=divDtlTable style="height:280px" >
  		                        	<!-- Detail table starts -->
                              <TABLE cellSpacing=0 cellPadding=0 id="Detail" >
                                <TBODY>
                                  <TR height="22">
                                      <td class=tableHeader width="1%"><html:checkbox property="selectAll" disabled="true"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                     
                                      <TD class=tableHeader width="25%">Operation</TD>
                                      <TD class=tableHeader width="5%">No of Bags</td> 
                                      <TD class=tableHeader width="8%">Bag Type</td> 
                                      <TD class=tableHeader width="10%">Lead Norm</td> 
                                      <TD class=tableHeader width="8%">Incentive</td> 
                                              
                                  </tr> 
                             <logic:iterate id="wrkInfo" name="frmMaintKotWrkSlip" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.MaintKotWrkSlipBean" >
                              <% ++i; %>
                               <logic:notEqual name="wrkInfo" property="status" value="D" >  
                                   <tr>
                                       <logic:equal property="status" name="wrkInfo" value="N">
                                       <td ><html:checkbox property="checked"  onclick="checkRecord();"  name="frmMaintKotWrkSlip" /></td>
                                       
                                       <td ><html:textarea property="txtOperDesc" name="wrkInfo" readonly="true" rows="1"  styleClass="required" alt="<%=String.valueOf(i)%>"  onchange=" datumChanged(this.alt)"   style="WIDTH: 93%" />                                        
                                       <html:hidden property="txtOperId" name="wrkInfo" alt="<%=String.valueOf(i)%>" />
                                       <html:hidden property="txtOperDatum" name="wrkInfo" alt="<%=String.valueOf(i)%>" />
                                       <html:hidden property="txtOperSeq" name="wrkInfo" value="<%=String.valueOf(i)%>" alt="<%=String.valueOf(i)%>" />
                                       <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSlab" alt="<%=String.valueOf(i)%>" onclick="return ShowOperation(this.alt);" >
                                       </td>
                                       <td ><html:text property="txtBags" name="wrkInfo" size="5" styleClass="required" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  />
                                       </td>
                                       <td ><html:select property="txtBagTyp" name="wrkInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)"  style="WIDTH: 100%"  >
                                               <html:option value="" >-----------Please Select-----------</html:option>      
                                               <html:option value="S">Small Bag Type</html:option>
                                               <html:option value="B">Big Bag Type</html:option>
                                              </html:select>
                                       </td>
                                       <td ><html:select property="txtNormTyp" name="wrkInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)"  style="WIDTH: 100%"  >
                                              <html:option value="" >-----------Please Select-----------</html:option>      
                                                 <logic:present name="NormTyp">
                                                    <html:optionsCollection label="label" value="value" property="leadNormList" name="NormTyp" />
                                                 </logic:present>
                                            </html:select>
                                       </td>
                                       <td><html:text property="txtIncentive" name="wrkInfo" readonly="true" style="width:100%;" styleClass="optional" /></td>
                                  </logic:equal>
                                       
                                <logic:notEqual property="status" name="wrkInfo" value="N">
                                       <td ><html:checkbox property="checked"  onclick="checkRecord();"  value="false" name="frmMaintKotWrkSlip" /></td>
                                       
                                       <td ><html:textarea property="txtOperDesc" name="wrkInfo" readonly="true" rows="1" styleClass="required" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  style="WIDTH: 93%" />
                                       
                                       <html:hidden property="txtOperId" name="wrkInfo" alt="<%=String.valueOf(i)%>" />
                                       <html:hidden property="txtOperDatum" name="wrkInfo" alt="<%=String.valueOf(i)%>" />
                                        <html:hidden property="txtOperSeq" name="wrkInfo" alt="<%=String.valueOf(i)%>"/>
                                       <IMG height="16" src="../INCLUDES/IMAGES/lov.jpg" align="center" name="buttxtSlab" alt="<%=String.valueOf(i)%>"  >
                                       </td>
                                       
                                       <td ><html:text property="txtBags" name="wrkInfo" size="5" readonly="true" styleClass="required" maxlength="9" style="width:100%;text-align:right" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt)"  />
                                       </td>
                                       <td ><html:select property="txtBagTyp" name="wrkInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)"  style="WIDTH: 100%"  >
                                               <html:option value="" >-----------Please Select-----------</html:option>      
                                               <html:option value="S">Small Bag Type</html:option>
                                               <html:option value="B">Big Bag Type</html:option>
                                              </html:select>
                                       </td>
                                       <td ><html:select property="txtNormTyp" name="wrkInfo"  styleClass="required" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt)"  style="WIDTH: 100%"  >
                                              <html:option value="" >-----------Please Select-----------</html:option>      
                                                 <logic:present name="NormTyp">
                                                    <html:optionsCollection label="label" value="value" property="leadNormList" name="NormTyp" />
                                                 </logic:present>
                                            </html:select>
                                       </td>
                                       <td><html:text property="txtIncentive" style="width:100%" name="wrkInfo" readonly="true" styleClass="optional" /></td>
                                       </logic:notEqual>
                                      
                                    
                                       <html:hidden property="itemChecked" name="wrkInfo" />
                                       <html:hidden property="txtSrlNo" name="wrkInfo" />
                                       <html:hidden property="txtLbrID" name="wrkInfo" />
                                       <html:hidden property="txtLbrCode" name="wrkInfo" />
                                       <html:hidden property="txtLbrName" name="wrkInfo"  /></td>
                                       <html:hidden property="txtLbrDsgn" name="wrkInfo"  />
                                       <html:hidden property="txtIncentivelbr" name="wrkInfo"  />
                                       <html:hidden property="status" name="wrkInfo" />
                                       <html:hidden property="detailId" name="wrkInfo" value="Default"/>
                                </tr>
                              </logic:notEqual>
                              <logic:equal name="wrkInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintKotWrkSlip" value="notchecked" /></td>  
                                       <td ><html:hidden property="txtBagTyp" name="wrkInfo" /></td>
                                       <td ><html:hidden property="txtNormTyp" name="wrkInfo" /></td>
                                       <td ><html:hidden property="txtOperDesc" name="wrkInfo" /></td>
                                       <html:hidden property="txtOperId" name="wrkInfo"  />
                                       <html:hidden property="txtOperSeq" name="wrkInfo" />
                                       <html:hidden property="txtOperDatum" name="wrkInfo" />
                                       <td ><html:hidden property="txtBags" name="wrkInfo" /></td>
                                       <html:hidden property="txtIncentive" name="wrkInfo" />
                                       <html:hidden property="txtSrlNo" name="wrkInfo" />
                                       <html:hidden property="txtLbrCode" name="wrkInfo" />
                                       <html:hidden property="txtLbrID" name="wrkInfo" />
                                       <html:hidden property="txtLbrName" name="wrkInfo"  /></td>
                                       <html:hidden property="txtLbrDsgn" name="wrkInfo"  />
                                       <html:hidden property="txtIncentivelbr" name="wrkInfo"  />
                                       <html:hidden property="itemChecked" name="wrkInfo" />                                   
                                       <html:hidden property="status" name="wrkInfo" />
                                       <html:hidden property="detailId" name="wrkInfo" value="Default"/>
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
                     <td bgColor=#4682b4><html:button property="butIncentive" value="Calculate Incentive" onclick="calcIncentive()" /></td>
                     <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></td>
             </TR>
	
          </TABLE>
<!-- Container Table Ending Columns Starts-->
        </TD>
     </TR>
   </TBODY>
 </TABLE>


<!-- Container Table Ends -->

<html:hidden name="frmMaintKotWrkSlip"  property="screenMode"  />
<html:hidden name="frmMaintKotWrkSlip"  property="screenName" value="KOTWrkSlipScreen" />
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
<html:hidden property="flagLbr" name="frmMaintKotWrkSlip"  />
<html:hidden property="flagWrkSlp" name="frmMaintKotWrkSlip"  />
<html:hidden property="txtTotIncentive" name="frmMaintKotWrkSlip" />
<input type="hidden" name="queryParam" />
<input type="hidden" name="multipleFlag" />

</html:form>
</body>
</html:html>

<script language="javascript">
var chkMes =0;
  
 function doGetTab(arg)
  {
    
    document.all.forwardedPage.value=arg;
    document.all.flagLbr.value = true;
    document.forms[0].action="../../../WrkSlipKOTWrkTabAction.do";
    document.forms[0].submit();
  }
  
  
function changed(val)
{ 
  frmMaintKotWrkSlip.detailDataChanged.value = "true";
  if (document.getElementsByName("status")[val-1].value == 'Q')
    document.getElementsByName("status")[val-1].value = 'U';
  document.getElementsByName("txtIncentive")[val-1].value = '';
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
      document.getElementsByName("txtBagTyp")[val-1].value = "S";
      document.getElementsByName("txtNormTyp")[val-1].disabled = ""; 
  }
  return true;
}

function doGetNextHeader()
{   
    document.all.buttonFlag.value='';
    document.all.flagLbr.value="false";
    document.all.flagWrkSlp.value="false";
    frmMaintKotWrkSlip.userPositionRequested.value = 1*frmMaintKotWrkSlip.positionRequested.value + 1;
    document.forms[0].action="../../../WrkSlipKOTGetNextHeader.do";
    document.forms[0].submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    document.all.flagLbr.value="false";
    document.all.flagWrkSlp.value="false";
    frmMaintKotWrkSlip.userPositionRequested.value = 1*frmMaintKotWrkSlip.positionRequested.value - 1;
    document.forms[0].action="../../../WrkSlipKOTGetNextHeader.do";
    document.forms[0].submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    document.all.flagLbr.value="false";
    document.all.flagWrkSlp.value="false";
    frmMaintKotWrkSlip.userPositionRequested.value = 1*frmMaintKotWrkSlip.newPositionRequested.value;
    document.forms[0].action="../../../WrkSlipKOTGetNextHeader.do";
    document.forms[0].submit();
}

function doBasePrevDetail()
{
    frmMaintKotWrkSlip.userPageRequested.value = 1*frmMaintKotWrkSlip.pageRequested.value - 1;
    frmMaintKotWrkSlip.action = "../../../WrkSlipKOTNextDetailAction.do";
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

function doBaseAddRow()
{   
    document.all.buttonFlag.value='D';
    if(!mandatory_Check("frmMaintKotWrkSlip"))
     return false;
    
    document.all.buttonFlag.value='D';
    document.all.screenMode.value='U';
    document.all.flagWrkSlp.value='true';
    enableBagLeadTyp();
    frmMaintKotWrkSlip.headerPrimaryKey.disabled="";     
    document.forms[0].action = "../../../WrkSlipKOTAddRowAction.do";
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
  document.forms[0].action = "../../../WrkSlipKOTDeleteRowAction.do";
  document.forms[0].submit();  
}



function GetDetail()
{
  if(frmMaintKotWrkSlip.hdnWrkSlipId.value == '')
    {
      alert("Mandatory Field is empty");      
      return;
    }
    else
    {
      document.all.buttonFlag.value='';
      frmMaintKotWrkSlip.flagWrkSlp.value="true";      
      document.all.screenMode.value='U';
      frmMaintKotWrkSlip.headerPrimaryKey.disabled="";      
      frmMaintKotWrkSlip.action="../../../WrkSlipKOTGetDetailAction.do"
      frmMaintKotWrkSlip.submit();
    }  
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
  frmMaintKotWrkSlip.action = "../../../WrkSlipKOTDelRecordAction.do";
  frmMaintKotWrkSlip.submit();
}

function SaveRecord()
{
  frmMaintKotWrkSlip.hdnWrkSlipId.disabled="";
  if(document.all.hdnWrkSlipId.value != '')
  {
  
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
      alert("Please Add at Least 1 row");
      return false;
    }
    var i = 0; 
    var j = 0;
    for(i=0; i < iTr2 -1; i++)
    {
        if (document.getElementsByName("status")[i].value == 'D')
        {
          frmMaintKotWrkSlip.detailDataChanged.value = "true";
        }       
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
      frmMaintKotWrkSlip.action = "../../../WrkSlipKOTSaveAction.do";
  
      frmMaintKotWrkSlip.submit();
    }
    else
    {
      alert("Please Insert Labours Detail First");
    }
}

function lfnLoad()
{
    mode1=document.all.flagWrkSlp.value;
    frmMaintKotWrkSlip.butGetDetail.disabled="true";
    frmMaintKotWrkSlip.butInsert.disabled="true";
    frmMaintKotWrkSlip.butDelete.disabled="true";
    if(mode1 == 'true' || document.all.flagLbr.value == 'true')
    {
      //  frmMaintKotWrkSlip.headerPrimaryKey.disabled=true;
    }
    mode=document.all.screenMode.value;  
    if(mode=='')
    {
        doQueryMode();
    }
    //alert(frmMaintKotWrkSlip.screenMode.value);
    //alert(mode1);
    if (frmMaintKotWrkSlip.screenMode.value == 'U')
    { 
          if(mode1=='false')
          {
              frmMaintKotWrkSlip.butGetDetail.disabled="";
              frmMaintKotWrkSlip.butInsert.disabled="true";
              frmMaintKotWrkSlip.butDelete.disabled="true";
          }    
          if(mode1=='true')
          {
              frmMaintKotWrkSlip.butGetDetail.disabled="true";
              frmMaintKotWrkSlip.butInsert.disabled="";
              frmMaintKotWrkSlip.butDelete.disabled="";
              frmMaintKotWrkSlip.headerPrimaryKey.disabled="true";
          }
    
        var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;        
    }
        if (frmMaintKotWrkSlip.screenMode.value == 'N')
    {
        frmMaintKotWrkSlip.butInsert.disabled="";
    }

    menuHandling(mode);
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg"; 
    document.all.butQueryMode.disabled="true";    
    document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
    document.all.butInsertMode.disabled="true";    
    document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
    document.all.butPrevHeader.disabled="true";    
    document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
    document.all.butNextHeader.disabled="true";    
    document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
    document.all.butnGo.disabled="true"; 

  /*mode=document.all.screenMode.value;  
    frmMaintKotWrkSlip.butGetDetail.disabled="true";
    frmMaintKotWrkSlip.butInsert.disabled="true";
    frmMaintKotWrkSlip.butDelete.disabled="true";
     if(mode=='')
      {
        doQueryMode();
      }
    mode1=document.all.flagLbr.value;
    if (frmMaintKotWrkSlip.screenMode.value == 'U')
    { 
          if(mode1=='false')
          {
              frmMaintKotWrkSlip.butGetDetail.disabled="";
              frmMaintKotWrkSlip.butInsert.disabled="true";
              frmMaintKotWrkSlip.butDelete.disabled="true";
          }    
          if(mode1=='true')
          {
              frmMaintKotWrkSlip.butGetDetail.disabled="true";
              frmMaintKotWrkSlip.butInsert.disabled="";
              frmMaintKotWrkSlip.butDelete.disabled="";
              frmMaintKotWrkSlip.headerPrimaryKey.disabled="true";
          }
           
    }
    if (frmMaintKotWrkSlip.screenMode.value == 'N')
    {
        frmMaintKotWrkSlip.butInsert.disabled="";
    }

  menuHandling(mode);
  calcTotInc();*/
  disabBagNormTyp();

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
    frmMaintKotWrkSlip.action = "../../../WrkSlipKOTRefresh.do";
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
    
function ShowLovWorkSlip()
{
   frmMaintKotWrkSlip.queryParam.value="txtSiteID="+ frmMaintKotWrkSlip.loginLocCode.value +",txtLbrTyp=KOT" ;    
   frmMaintKotWrkSlip.lovKey.value = "WorkslipID" + frmMaintKotWrkSlip.screenName.value + "Q";
   frmMaintKotWrkSlip.txtDisplayFields.value = "txtWrkSlipDt";
   frmMaintKotWrkSlip.txtSearchFields.value = "Labours.hdnWrkSlipDtlId";
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
   frmMaintKotWrkSlip.queryParam.value="txtSiteID="+ frmMaintKotWrkSlip.loginLocCode.value +"";
   // ,txtOperId= "+frmMaintKotWrkSlip.txtOperId.value+",hdnGangId="+frmMaintKotWrkSlip.hdnGangId.value+",txtWrkSlipDt="+frmMaintKotWrkSlip.txtWrkSlipDt.value;    
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
    frmMaintKotWrkSlip.action="../../../WrkSlipKOTGetHeaderAction.do";
    frmMaintKotWrkSlip.submit();
   }
 }
 function checkHeaderMandatory()
 {
   if(document.all.hdnWrkSlipDtlId.value=="")
   {
     alert("Please Select/Enter WorkSlip ID ");
      document.all.buttxtWorkSlipID.setFocus();
      return false;
    }
    return true;
}
 

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
     if(document.getElementsByName("status")[i].value!='D')
     {
       if(document.getElementsByName("txtIncentive")[i].value=='')
       {
        alert("Please Calculate the incentive before saving the record");
        return false;
       }
     }
     if(document.getElementsByName("status")[i].value=='D')
     {
       if(document.getElementsByName("txtIncentive")[i].value!='')
       {
        alert("Please Calculate the incentive before saving the record");
        document.getElementsByName("txtIncentive")[i].value = '';
        return false;
       }
    }  
     
  } 
  return true;
}

function calcIncentive()
{
    if(!mandatory_Check("frmMaintKotWrkSlip"))
      return false;
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
      return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    var TotBags=0;
    var flag='N';
    for(i=0; i < iTr2 -1; i++)
    {
      if(document.getElementsByName("status")[i].value!='Q')
      {
        flag ='Y';
      }
      if(document.getElementsByName("status")[i].value=='D')
      {
        if(document.getElementsByName("txtIncentive")[i].value!='')
        {
          document.getElementsByName("txtIncentive")[i].value = '';        
        }
      }  
      
    } 
    if (flag == 'Y')
    {
      calcTotBags();
      enableBagLeadTyp();    
      frmMaintKotWrkSlip.action = "../../../WrkSlipKOTCalcIncentiveAction.do";
      frmMaintKotWrkSlip.submit();
    }  
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
      if(document.getElementsByName("txtIncentive")[i].value != '')
        TotInc=parseFloat(TotInc)+parseFloat(document.getElementsByName("txtIncentive")[i].value);
      else
        TotInc=parseFloat(TotInc);
    }
  } 
  document.all.txtTotIncentive.value=Math.round(TotInc);  
}

</script>
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

<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN WORKSLIP DETAILS FOR KOTWAL UNION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
    <!-- Body table Starts -->
      <TABLE cellSpacing=0 cellPadding=0 border=0>
      <!--  Header Row Starts -->
        <TR>
          <TD class=subHeader colspan=6>Header For Kotwal Workslip Details</TD>
        </TR>
        <TR>
          <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
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
          <html:text  property="hdnWrkSlipId" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="optional"  />            
          </logic:equal>               
          </td>           
          
          <TD class=labelText>WorkSlip Date</TD>
          <td align="left" >
          <logic:notEqual property= "screenMode" name= "frmMaintKotWrkSlip" value="Q">                                                
          <html:text property="txtWrkSlipDt" alt="txtWrkSlipDt" size="23" readonly="true" styleClass="required" />
          <img src="..\INCLUDES\IMAGES\cal.gif"  width=15 height=19 align="top" styleClass="lov" onclick="showCalendar('txtWrkSlipDt',this)" />
          </logic:notEqual>                                                                    
          <logic:equal property= "screenMode" name= "frmMaintKotWrkSlip" value="Q">                              
          <html:text property="txtWrkSlipDt" alt="txtWrkSlipDt" size="23" readonly="true" styleClass="optional" />
          </logic:equal>               
          </td>  
        </tr> 
        
        <tr> 
          <td class="labelText">Year Month</td>
          <logic:equal name="frmMaintKotWrkSlip" property="screenMode" value="Q" >			
          <td><html:text property="txtYYMM" styleClass="required" maxlength="6"  size="23"/> </td>
          </logic:equal>
          
          <logic:notEqual name="frmMaintKotWrkSlip" property="screenMode" value="Q" >			
          <td><html:text property="txtYYMM" styleClass="locked" maxlength="6" readonly="true" size="23"/></td>
          </logic:notEqual>
        
          <td class="labelText"  width="25%" >Work Slip Type</td>
          <logic:notEqual name="frmMaintKotWrkSlip" property="screenMode" value="Q" >			
          <td><html:select property="txtWrkSlipTyp" name= "frmMaintKotWrkSlip" styleClass="required" >
          <html:option value="" >  <bean:message key="Payroll.pleaseSelect" /></html:option>   
          <html:option value="A" > A </html:option>
          <html:option value="B" > B </html:option>
          </html:select>
          </td>
          </logic:notEqual>
          
          <logic:equal name="frmMaintKotWrkSlip" property="screenMode" value="Q" >			
          <td><html:select property="txtWrkSlipTyp" name= "frmMaintKotWrkSlip" styleClass="optional" >
          <html:option value="" >  <bean:message key="Payroll.pleaseSelect" /></html:option>   
          <html:option value="A" > A </html:option>
          <html:option value="B" > B </html:option>
          </html:select>
          </td>
          </logic:equal>
          
        </tr>


        <tr height="10">		    
          <TD colspan="2" > </TD>
        </tr>
      </table>
    
       <table cellspacing=0 cellpadding=0 border=0>
          <!-- Detail Information Row starts -->
                <TR height="300">
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
                                    <TABLE cellSpacing=0 cellPadding=0 id="Detail" border=0>
                                      <TBODY>
                                        <TR height="22">
                                          <td class=tableHeader width="1%"><html:checkbox property="selectAll" disabled="true"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                         <TD class=tableHeader width="3%">Sr. No.</TD>
                                          <TD class=tableHeader width="8%">Labour Code</TD>
                                          <TD class=tableHeader width="10%">Labour ID</TD>
                                          <TD class=tableHeader width="30%">Labour Name</td> 
                                          <TD class=tableHeader width="15%">Designation</td>                                    
                                          <TD class=tableHeader width="10%">Incentive</td> 
                                          
                                        </tr> 
<!-- New Ends -->                                               
                         <logic:iterate id="Labour" name="frmMaintKotWrkSlip" property="lstInstrDtlslbr" type="FCIPAY.Payroll.Labour.Utility.MaintKotWrkSlipBean" >
                            <% ++i; %>
                              <logic:notEqual name="Labour" property="status" value="D" >                                                    
                          <tr>
                           <% ++j; %>    
                             <td  width="1%" align="center"><html:checkbox property="checked" onclick="checkRecord();"  /></td>    
                             
                             <td  width="3%" >
                             <html:text property="txtSrlNo" name="Labour" size="1"  value="<%=String.valueOf(j)%>" styleClass="required" alt="<%=String.valueOf(i)%>" style="width:95%;text-align:center" maxlength="10" /></td>
                             
                             <td  width="8%" >
                             <html:text property="txtLbrCode" name="Labour" styleClass="required" alt="<%=String.valueOf(i)%>" style="width:95%;text-align:center" onchange=" upper(this); getEmployeeDetail(this.value,this.alt,'LabourCode')"  maxlength="10" /></td>
                              
                              
                              <td  width="10%" >                              
                              <html:text property="txtLbrID"  name="Labour" styleClass="required" alt="<%=String.valueOf(i)%>" style="width:80%;text-align:right" onchange="" readonly="true" maxlength="10" />
                              <logic:equal name="Labour" property="status" value="N">                                        
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtAgencySite" onchange="return changed(this.alt);" onclick="ShowEmployeeNo(this.alt);"  >                                       
                              </logic:equal>                                      
                              
                              <logic:equal name="Labour" property="status" value="Q">                                        
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtAgencySite" onchange="return changed(this.alt);"  onclick="ShowEmployeeNo(this.alt);" >                                       
                              </logic:equal>                                      
                              
                              <logic:equal name="Labour" property="status" value="U">                                        
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" alt="<%=i%>" property="buttxtAgencySite" onchange="return changed(this.alt);" onclick="ShowEmployeeNo(this.alt);" >                                       
                              </logic:equal>
                              </td>
                              
                              <td  width="30%" ><html:text property="txtLbrName" name="Labour" styleClass="locked" alt="<%=String.valueOf(i)%>" readonly="true" style="width:100%;text-align:center"   maxlength="60" /></td>
                              <td  width="15%" ><html:text property="txtLbrDsgn" name="Labour" styleClass="locked" alt="<%=String.valueOf(i)%>" readonly="true"  maxlength="35" style="width:100%;text-align:center"/></td>                                                         
                              <td  width="10%" ><html:text property="txtIncentivelbr" name="Labour" styleClass="optional" alt="<%=String.valueOf(i)%>" readonly="true" style="width:90%;text-align:center"  /></td>                                                         
                              <html:hidden property="itemChecked" name="Labour" />
                           
                              <html:hidden property="status" name="Labour" />    
                              <html:hidden property="detailId" name="Labour" value="Default" />
                              <html:hidden property="txtNormTyp" name="Labour" value="Default" />
                              <html:hidden property="txtBags" name="Labour" value="Default" />
                              <html:hidden property="txtOperSeq" name="Labour"  value="Default"/>
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
                              <td  width="5%" ><html:hidden property="txtSrlNo" name="Labour"  /></td>
                              <td  width="5%" ><html:hidden property="txtLbrCode" name="Labour"  /></td>
                              <td  width="5%" ><html:hidden property="txtLbrID" name="Labour"  /></td>
                              <td  width="5%" ><html:hidden property="txtLbrName" name="Labour"  /></td>
                              <td  width="5%" ><html:hidden property="txtLbrDsgn" name="Labour"  /></td> 
                              <td  width="5%" ><html:hidden property="txtIncentivelbr" name="Labour"  /></td> 
                              <html:hidden property="txtNormTyp" name="Labour" value="Default" />
                              <html:hidden property="txtBags" name="Labour" value="Default" />
                              <html:hidden property="txtOperSeq" name="Labour"  value="Default"/>
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
<html:hidden property="flagLbr" name="frmMaintKotWrkSlip"  />
<html:hidden property="flagWrkSlp" name="frmMaintKotWrkSlip"  />
<input type="hidden" name="queryParam" />
<input type="hidden" name="multipleFlag" />

</html:form>
</body>
</html:html>

<script language="javascript">

var chkMes =0;
function doGetTab(arg)
{
    if(document.all.screenMode.value != "Q")
    {
      var oTable = document.getElementById("Detail");  
      if(oTable == null)  
      {
        alert("Please Enter Labour Detail ");
        return;
      }
      var srlNo="<%= j %>"    
      if(srlNo < 1)
      {
        alert("Please Enter Labour Detail ");
        return;
      }          
      if(!mandatory_Check("frmMaintKotWrkSlip"))      
        return false;       
        
    }
    frmMaintKotWrkSlip.hdnWrkSlipId.disabled="";
    frmMaintKotWrkSlip.flagLbr.value="false";
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../WrkSlipKOTLbrTabAction.do";
    document.forms[0].submit();
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

function getHeaderRecord()
 {       
    if(frmMaintKotWrkSlip.txtLocId.value == '')
    {
      alert("Please Select Location/Depot first");
      return;
    }
    else
    {
		document.all.flagLbr.value="false";
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
		frmMaintKotWrkSlip.action="../../../NewWrkSlipKOTGetHeaderAction.do";
		frmMaintKotWrkSlip.submit();
    }  
 }

function doGetNextHeader()
{       
    document.all.flagLbr.value="false";
    document.all.flagWrkSlp.value="false";
    frmMaintKotWrkSlip.userPositionRequested.value = 1*frmMaintKotWrkSlip.positionRequested.value + 1;
    document.forms[0].action="../../../WrkSlipKOTLbrGetNextHeader.do";
    document.forms[0].submit();
}

function PrevHeader()
{
    document.all.flagLbr.value="false";
    document.all.flagWrkSlp.value="false";
    frmMaintKotWrkSlip.userPositionRequested.value = 1*frmMaintKotWrkSlip.positionRequested.value - 1;
    document.forms[0].action="../../../WrkSlipKOTLbrGetNextHeader.do";
    document.forms[0].submit();
}

function JumpHeader()
{
    document.all.flagLbr.value="false";
    document.all.flagWrkSlp.value="false";
    frmMaintKotWrkSlip.userPositionRequested.value = 1*frmMaintKotWrkSlip.newPositionRequested.value;
    document.forms[0].action="../../../WrkSlipKOTLbrGetNextHeader.do";
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

function doBaseAddRow()
{    
    document.all.buttonFlag.value='D';    
    if(!mandatory_Check("frmMaintKotWrkSlip"))
     return false;
    frmMaintKotWrkSlip.flagLbr.value="true";    
    document.forms[0].action = "../../../NewWrkSlipKOTAddRowAction.do";
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
  document.forms[0].action = "../../../WrkSlipKOTLbrDelRowAction.do";
  document.forms[0].submit();  
}



function GetDetail()
{
  if(mandatory_Check("frmMaintKotWrkSlip"))
  {
    document.all.buttonFlag.value='';
    frmMaintKotWrkSlip.flagLbr.value="true";
    //frmMaintKotWrkSlip.txtEmpNo.value=frmMaintKotWrkSlip.headerPrimaryKey.value;
    frmMaintKotWrkSlip.butGetDetail.disabled="";
    document.all.butInsert.disabled="disabled"
    document.all.butDelete.disabled="disabled"    
    document.all.screenMode.value='U';
    frmMaintKotWrkSlip.headerPrimaryKey.disabled=""; 
    frmMaintKotWrkSlip.action="../../../NewWrkSlipKOTGetDetailAction.do"
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
  frmMaintKotWrkSlip.action = "../../../NewWrkSlipKOTDelRecordAction.do";
  frmMaintKotWrkSlip.submit();
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintKotWrkSlip"))
  {   
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
    var tndlFlag = 0;  
    for(i=0; i < iTr2 -1; i++)
    {
      if(document.getElementsByName("txtLbrDsgn")[i].value =='Tindel')
      {
        if (document.getElementsByName("status")[i].value != 'D' ) 
        tndlFlag = 1;
      }   
      if (document.getElementsByName("status")[i].value == 'D')
        frmMaintKotWrkSlip.detailDataChanged.value = "true";    
    }  
    
    var srlNo="<%= j %>";  
    if(srlNo > 17)
    {  
      alert("No of Labours can not be greater than 17");
      return false;
    }
    else if(srlNo >= 1 && tndlFlag == 0)
    {
      alert("Please Select atleast one Tindel");
      return false;
    }
    else{}
    document.all.buttonFlag.value='';
    frmMaintKotWrkSlip.headerPrimaryKey.value=frmMaintKotWrkSlip.headerPrimaryKey.value;
    frmMaintKotWrkSlip.headerFields.value = "true";
    if(document.all.screenMode.value == "N")
      document.all.headerDataChanged.value='true';
      
    enableBagLeadTyp();    
    frmMaintKotWrkSlip.flagLbr.value="true";
    frmMaintKotWrkSlip.totalDetailRecord.value = parseInt(iTr2,10) - 1;
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmMaintKotWrkSlip.action = "../../../NewWrkSlipKOTSaveAction.do";
    frmMaintKotWrkSlip.submit();
  }
  else
  {
    return false;
  }
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
    frmMaintKotWrkSlip.flagLbr.value="false";
    frmMaintKotWrkSlip.flagWrkSlp.value="false";
    frmMaintKotWrkSlip.headerPrimaryKey.value="";
    frmMaintKotWrkSlip.butGetDetail.disabled="";
    frmMaintKotWrkSlip.butInsert.disabled="true";
    frmMaintKotWrkSlip.butDelete.disabled="true";    
    
    frmMaintKotWrkSlip.action="../../../NewWrkSlipKOTQueryMode.do"
    frmMaintKotWrkSlip.submit();    
}

function lfnLoad()
{ 
    mode1=document.all.flagLbr.value;
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
    
    /*mode1=document.all.flagLbr.value;
    frmMaintKotWrkSlip.butGetDetail.disabled="true";
    frmMaintKotWrkSlip.butInsert.disabled="true";
    frmMaintKotWrkSlip.butDelete.disabled="true";
    
    mode=document.all.screenMode.value;  
    if(mode=='')
    {
        doQueryMode();
    }
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
    document.all.butDel.disabled="true";    
    document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";  
    if(document.all.hdnEmpLbrFlag.value=='V')
    {
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";
    }*/
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
   frmMaintKotWrkSlip.lovKey.value = "GangDepot" + frmMaintKotWrkSlip.screenName.value + frmMaintKotWrkSlip.screenMode.value;
   frmMaintKotWrkSlip.queryParam.value="txtSiteID="+frmMaintKotWrkSlip.loginLocCode.value;
   frmMaintKotWrkSlip.txtDisplayFields.value = "txtLocId,txtLoc";
   frmMaintKotWrkSlip.txtSearchFields.value = "Labours.txtSiteId,Labours.txtSiteName";
   frmMaintKotWrkSlip.txtIndex.value="";
   frmMaintKotWrkSlip.txtInputField.value="";
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintKotWrkSlip');
 
   return true;
}

function ShowEmp(i)
{    
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
   frmMaintKotWrkSlip.queryParam.value="txtSiteID="+ frmMaintKotWrkSlip.loginLocCode.value +",txtDepotLocId="+frmMaintKotWrkSlip.txtLocId.value;   
   frmMaintKotWrkSlip.txtDisplayFields.value = "txtLbrCode,txtLbrID,txtLbrName,txtLbrDsgn";  
   frmMaintKotWrkSlip.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.EmployeeNo,Payroll.LoanForeclosure.CPFCode,pay.MaintainAnnualIncome.txtEmpName";
   frmMaintKotWrkSlip.txtIndex.value = i-1;      
   frmMaintKotWrkSlip.txtInputField.value ="txtLbrID"; 
   
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintKotWrkSlip');
   return true;
}

 function changed(i)
{
  frmMaintKotWrkSlip.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[i-1].value == 'Q')
     document.getElementsByName("status")[i-1].value = 'U';
}

function checkDuplicacy(fldVal, rInd, fldNam)
{
  lengthOfTable = document.getElementById("Detail").rows.length;  
  for(ind = lengthOfTable - 2; ind > 0; ind --)
  {
    if(ind != rInd)
    {      
      if(fldNam == 'LabourCode') 
      {
        oldVal = document.getElementsByName("txtLbrCode")[ind-1].value.toUpperCase();
      }  
      else if (fldNam == 'LabourId')
      {
        oldVal = document.getElementsByName("txtLbrId")[ind-1].value.toUpperCase();
      }
        else {}
        
      if(oldVal == fldVal && document.getElementsByName("status")[ind-1].value!='D')
      {
        alert("You can\'t enter duplicate value");                
        document.getElementsByName("txtLbrCode")[rInd-2].value = '';
        document.getElementsByName("txtLbrId")[rInd-2].value = '';        
        return false;              
      }
    }
  }
  return true;
}

function getEmployeeDetail(val,indx, fldName)
{
    var ind = parseInt(indx)+1;    
    if(!checkDuplicacy(val,ind,fldName))   
      return false;
    retrieveURL("../../../getWrkSlipKOTDetAction.do?kotVal="+escape(val)+"&fldVal="+escape(fldName), indx, fldName);
}

function retrieveURL(url,indx, fldNam) {
  var idx=indx;  
  var fldName=fldNam;  
    if (window.XMLHttpRequest) { // Non-IE browsers    
      req = new XMLHttpRequest();      
      req.onreadystatechange = function () { 
                                    processStateChange(idx, fldName);
                                    }

      try {        
        req.open("GET", url, true);
      } catch (e) {
        alert(e);
      }
      req.send(null);
    } else if (window.ActiveXObject) { // IE      
      req = new ActiveXObject("Microsoft.XMLHTTP");      
      if (req) {                       
        req.open("GET", url, true);
        req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded ");
        req.onreadystatechange = function () { 
                                    processStateChange(idx, fldName);
                                    }
        req.send(null);
        
      }
    }
  }

function processStateChange(indx, fldNam) {
    if (req.readyState == 4) { // Complete
      if (req.status == 200) { // OK response        
         var kotResponse = req.responseText;             
         var kotInfo = kotResponse.split("|");         
        if(kotInfo[0] == ''){
          alert("Labour Does not Exist");    
          document.getElementsByName("txtLbrCode")[indx-1].value = '';
          document.getElementsByName("txtLbrID")[indx-1].value = '';
          }          
          if(fldNam =='LabourCode')
          {
            document.getElementsByName("txtLbrID")[indx-1].value = kotInfo[0];
          }else{
            document.getElementsByName("txtLbrCode")[indx-1].value = kotInfo[0];
          }
          
          document.getElementsByName("txtLbrName")[indx-1].value = kotInfo[1];
          document.getElementsByName("txtLbrDsgn")[indx-1].value = kotInfo[2];
        } else {
        alert("Problem: " + req.statusText);
      }
    }       
  }

function getKotEmployeeDetail(LbrVal, rowIndx,fldNam)
{
  if(fnCheckInteger(LbrVal))
  {
    //var depotId = frmMaintKotWrkSlip.txtLocId.value;
    //alert(depotId);
    getEmployeeDetail(LbrVal, rowIndx,fldNam);
  }
  else
    document.getElementsByName("txtLbrID")[rowIndx-1].value ='';
}

function fnCheckInteger(astrFieldValue)
{
	var RefString="1234567890";
	var InString = astrFieldValue;	
	//check only the characters present in RefString are entered
	for (Count=0; Count < InString.length; Count++)  
	{			
    if (RefString.indexOf (InString.substring (Count, Count+1))==-1)  
		{				
				alert('Please enter a valid numeric value');                
				return (false);
		}
  }  
  return true;
}

function upper(val)
{
   val.value=val.value.toUpperCase();
}

</script>
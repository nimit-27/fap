<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
	<HEAD>
    <html:base/>
	<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />  
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>           
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </link></head>
  <BODY  onload="lfnLoad();history.forward(1);initFields();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="PrmsCeilAdjBaseAction" name="frmEmpPrmsCeilAdjForm" type="FCIPAY.Payroll.WEBTIER.Form.EmpPrmsCeilAdjForm">
  <bean:define id="ParentForm" name="frmEmpPrmsCeilAdjForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>
  <% i = 0;j=0; %>
<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>PRMS CEILING ADJUSTMENT</TD>
</TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=8>Detail Information Of Employee</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></img></TD>
	      </TR>
              <tr>
                <TD class=labelText width="18%"><bean:message key="payroll.prms.empnum" /></TD>
                  <td align="left" width="35%" >
                                                <logic:equal property= "screenMode" name= "frmEmpPrmsCeilAdjForm" value="N">
						  <html:text  property="txtEmpNum" name= "frmEmpPrmsCeilAdjForm" altKey="payroll.prms.empnum" maxlength="10" onchange="" size="15" styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();"/>
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:equal>
						<logic:notEqual property= "screenMode" name= "frmEmpPrmsCeilAdjForm" value="N">
						  <html:text  property="txtEmpNum" name= "frmEmpPrmsCeilAdjForm" altKey="payroll.prms.empnum" maxlength="10" onchange="" size="15" styleClass="required" readonly="true"/>
						  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();"/>
						  <html:text  property="txtEmpName" altKey="Payroll.EmpInfo.StaffCode" maxlength="75" size="38" readonly="true" styleClass="locked" />                 
						</logic:notEqual>
                  </td>
                  <td class=labelText width="18%"  ><bean:message key="payroll.prms.empcat"/></TD>
                  <td>                             
                  <html:text  property="txtEmpCat" altKey="payroll.prms.empcat" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
              </tr>
               <tr>
                <td class=labelText width="18%"  ><bean:message key="payroll.prms.cpfcode"/></TD>
                  <td>                             
                  <html:text  property="txtCpfCode" altKey="payroll.prms.cpfcode" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  <td class=labelText width="18%"  ><bean:message key="payroll.prms.empdsgn"/></TD>
                  <td>                             
                  <html:text  property="txtEmpDsgn" altKey="payroll.prms.empdsgn" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
              </tr>
               <tr>
                <td class=labelText width="18%"  ><bean:message key="payroll.prms.empsepdate"/></TD>
                  <td>                             
                  <html:text  property="txtSepDate" altKey="payroll.prms.empsepdate" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  <td class=labelText width="18%"  ><bean:message key="payroll.prms.empseptype"/></TD>
                  <td>                             
                  <html:text  property="txtSepType" altKey="payroll.prms.empseptype" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
              </tr>

         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
            <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
<TABLE cellSpacing=0 cellPadding=0 >
       <!--Account  Header Row Starts -->
       <TR>
          <td align=center bgcolor=#4682b4 width="10%" class=screenStatus colspan=8>Medical Ceiling Adjustment</TD>
        </TR>
        <TR>
	      </TR>
              <tr>
             <td class=labelText width="18%"  ><bean:message key="payroll.prms.empadjtype"/></TD>
                <td>
                  <html:select  property="txtAdjType"  style="width:50%" onchange="initAdj( this.value);" > 
                  <html:option value="">---Please Select---</html:option>
                  <html:option value="IPD">Indoor Treatment</html:option>
                  <%--<html:option value="OPD">Outdoor Treatment</html:option>--%>
                  </html:select>  
                 </td>
                 <td class=labelText width="18%"  >Financial Year</TD>
                  <td align="left" >
                  <html:text  property="txtFinYear" altKey="payroll.prms.empremarks" maxlength="10" size="10" styleClass="optional" />
                  </td>
                <td class=labelText width="18%" ><bean:message key="payroll.prms.emppaymode" /></td>
                 <td>
                  <html:select  property="txtPayMode" styleClass = "optional" style="width:80%" > 
                  <html:option value="1">ADD</html:option>
                  <html:option value="2">SUBTRACT`</html:option>
                  </html:select>  
                </td>
              </tr>
               <tr>
                <td class=labelText width="18%"  ><bean:message key="payroll.prms.empadjamt"/></TD>
                  <td>
                  <html:text  property="txtAdjAmt" altKey="payroll.prms.empadjamt" maxlength="8" style="text-align:right" size="23" styleClass="optional" onkeypress="
                    if((event.keyCode < 48 || event.keyCode > 57))
                    {                     
                      return false;
                    }               
                    ;" onchange=" document.all.txtClaimAmt.value=document.all.txtAdjAmt.value" />
                    </td>
             <td class=labelText width="18%"  ><bean:message key="payroll.prms.empremarks"/></TD>
                  <td align="left" >
                  <logic:notEqual property= "screenMode" name= "frmEmpPrmsCeilAdjForm" value="Q"> 
                  <html:text  property="txtRemarks" altKey="payroll.prms.empremarks" maxlength="10" size="23" styleClass="optional" />
                  </logic:notEqual> 
                  
                  <logic:equal property= "screenMode" name= "frmEmpPrmsCeilAdjForm" value="Q">
                  <html:text  property="txtRemarks" altKey="payroll.prms.empremarks" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  </logic:equal>
                  </td>
                   <td>
                    <td> 
                        <html:button  value='Adjust'   property="butAdj" onclick="CeilAdj()" />
                    </td>
                </td>
              </tr>
               
         <tr height="15" >
            <td colspan="2"></td>
         </tr>
         
            <tr height="10">		    
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
<tr>
<td class=labelText style="color:blue"   width="20000" >* NOTE : Please Enter Employee details while searching for employee</td>
</tr>
<TR>
     <TD colspan="16" align=right bgColor=#4682b4 colSpan=8><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1  border=0></TD>
      </TR>  

      </TABLE>
<TR>
</tr>
      <logic:equal property= "screenMode" name= "frmEmpPrmsCeilAdjForm" value="N">
      <table>
         </tr>
                
             <td class=labelText width="18%"  ><bean:message key="payroll.prms.empopenbal"/></TD>
                  <td>                             
                  <html:text  property="txtOpenBal" altKey="payroll.prms.empopenbal" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                               
             <td class=labelText width="18%"  ><bean:message key="payroll.prms.empclaimbal"/></TD>
                  <td>                             
                  <html:text  property="txtClaimAmt" altKey="payroll.prms.empclaimbal" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
                  
                               
             <td class=labelText width="18%"  ><bean:message key="payroll.prms.empavailbal"/></TD>
                  <td>                             
                  <html:text  property="txtAvailableBal" altKey="payroll.prms.empavailbal" maxlength="50" size="23" readonly="true" styleClass="locked" />                 
                  </td>
        

      </table>
      </logic:equal>

<logic:notEqual property= "screenMode" name= "frmEmpPrmsCeilAdjForm" value="N">      

 <TABLE cellSpacing=0 cellPadding=0>
          <TR>
            <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
            <td bgcolor="#4682B4" nowrap class=actTabText >Ceiling Adjustment History <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
            <td><img src="../INCLUDES/IMAGES/formtab_r.gif" border="0"></td>
            <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
            <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
        </TR> 
       </TABLE>
<!-- Detail table Container starts -->
<TD colspan=11>
  <TABLE cellSpacing=0 cellPadding=0 border=0>
    <TBODY>
      <TR>
       <TD >

       <DIV id=divDtlTable style="height:300px">
        <TABLE cellSpacing=0 cellPadding=0 id="Detail" border=0>
        <TBODY>
          <TR height="22">
              <!--<td class=tableHeader width="1%"><html:checkbox property="selectAll" disabled="false"  onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>-->
              <TD class=tableHeader>Financial Year</TD>
              <TD class=tableHeader>Opening Balance</TD>
              <TD class=tableHeader>Adjustment Amount</TD> 
              <TD class=tableHeader>Mode Of Adjustment</TD>
              <TD class=tableHeader>Closing Balance</TD>
              <TD class=tableHeader>Adjustment Date</TD>
              <TD class=tableHeader>User ID</TD>                                     
          </TR>
          
     <logic:iterate id="ceilingHist" name="frmEmpPrmsCeilAdjForm" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.EmpPrmsCeilAdjBean" >
      <% ++i; %>
       <logic:notEqual name="ceilingHist" property="status" value="D" >  
           <tr>
              <!--<td align="center" width="1%">
                    <html:checkbox property="checked"  onclick="checkRecord();" value="false" name="frmEmpPrmsCeilAdjForm" />
              </td>-->
              <td align=center>
                <html:text property="txtFinY" name="ceilingHist" size="20" styleClass="locked" readonly="true" style="text-align:right" alt="<%=String.valueOf(i)%>" />
              </td>
              
              <td align=center>
                <html:text property="txtOpeningBal" name="ceilingHist" size="25" styleClass="locked" readonly="true" style="text-align:right" alt="<%=String.valueOf(i)%>" />
              </td>
              
              <td align=center>
                <html:text property="txtAdjustBal" name="ceilingHist" size="25" styleClass="locked" readonly="true" style="text-align:right" alt="<%=String.valueOf(i)%>" />
              </td>
              <td align=center>
                <html:text property="txtAdjustMode" name="ceilingHist" size="25" styleClass="locked" readonly="true" style="text-align:right" alt="<%=String.valueOf(i)%>" />
              </td>
              <td align=center>
                <html:text property="txtClaimAmout" name="ceilingHist" size="25" styleClass="locked" readonly="true" style="text-align:right" alt="<%=String.valueOf(i)%>" />
              </td>
               
              <td align=center>
                <html:text property="txtAdjustDate" name="ceilingHist" size="30" styleClass="locked" readonly="true" style="text-align:right" alt="<%=String.valueOf(i)%>" />
              </td>
              
              <td align=center>
                <html:text property="txtUserId" name="ceilingHist" size="25" styleClass="locked" readonly="true" style="text-align:right" alt="<%=String.valueOf(i)%>" />
              </td>
       
            <html:hidden property="txtFinY" name="ceilingHist" />
            <html:hidden property="txtOpeningBal" name="ceilingHist" />
            <html:hidden property="txtAdjustBal" name="ceilingHist" />
            <html:hidden property="txtAdjustMode" name="ceilingHist" />
            <html:hidden property="txtClaimAmout" name="ceilingHist" />
            <html:hidden property="txtAdjustDate" name="ceilingHist" />
            <html:hidden property="txtUserId" name="ceilingHist" />
	
        </tr>        
       </logic:notEqual>
        </logic:iterate>
        </tbody>
       
 </table>
</div>
</td>
</tr>
</tbody>
</table>
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
        </logic:notEqual>
         
 <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	 <TR height="50">
            <TD colspan=11>
           <TABLE cellspacing="0" cellPadding="0" >
            <TR>
            <bean:define id="smode" name="ParentForm" property="screenMode" type="java.lang.String" />

           <td align=center bgcolor=#4682b4 width="10%" class=screenStatus >
            <% if(smode.equals(new String("U"))) {%> 
            Update Mode
           <%} else if(smode.equals(new String("N"))) {  %>
            New Mode
           <%} else if(smode.equals(new String("Q"))) {  %>
            Query Mode
           <%}  %>
           </td> 
    
           <td align=right bgColor=#4682b4><img src="../INCLUDES/IMAGES/man.jpg"></img></td>
        </TR>	
      </TABLE> 
      <!-- Container Table Ending Columns Starts-->
    </TD>    
  </TR>
</table></td></tr></TBODY>
</TABLE>

<!-- Container Table Ends -->
<html:hidden name="frmEmpPrmsCeilAdjForm"  property="screenName" value="EmpPrmsCeilAdjScreen" />
<html:hidden property="loginLocCode" name="frmEmpPrmsCeilAdjForm"  />
<html:hidden property="headerPrimaryKey" name="frmEmpPrmsCeilAdjForm"  />
<html:hidden name="frmEmpPrmsCeilAdjForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpPrmsCeilAdjForm" />
<html:hidden property="positionRequested" name="frmEmpPrmsCeilAdjForm" />
<html:hidden property="userPositionRequested" name="frmEmpPrmsCeilAdjForm" />
<html:hidden property="buttonFlag" name="frmEmpPrmsCeilAdjForm"  />
<html:hidden property="lovKey" name="frmEmpPrmsCeilAdjForm"  />
<html:hidden property="txtFields" name="frmEmpPrmsCeilAdjForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpPrmsCeilAdjForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpPrmsCeilAdjForm"  />
<html:hidden property="txtIndex" name="frmEmpPrmsCeilAdjForm"  />
<html:hidden property="txtCpfCode" name="frmEmpPrmsCeilAdjForm"  />
<html:hidden property="txtInputField" name="frmEmpPrmsCeilAdjForm"  />
<html:hidden property="hdnITFlag" name="frmEmpPrmsCeilAdjForm"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>
<script language="javascript" >

function ShowEmpNum()
{
        if(frmEmpPrmsCeilAdjForm.screenMode.value=='N')
        {
        qryprm = "txtSiteID="+ frmEmpPrmsCeilAdjForm.loginLocCode.value +",hdnEmpLbrFlag="+ frmEmpPrmsCeilAdjForm.hdnEmpLbrFlag.value;
	
	frmEmpPrmsCeilAdjForm.lovKey.value = "EmpPrmsCeilAdjEmpLov" + frmEmpPrmsCeilAdjForm.screenName.value + frmEmpPrmsCeilAdjForm.screenMode.value;
	frmEmpPrmsCeilAdjForm.queryParam.value = qryprm;
	frmEmpPrmsCeilAdjForm.txtDisplayFields.value = "txtEmpNum,txtEmpName,txtCpfCode,txtEmpDsgn,txtEmpCat,txtSepType,txtSepDate,hdnITFlag";
	frmEmpPrmsCeilAdjForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
	frmEmpPrmsCeilAdjForm.txtInputField.value ="txtEmpNum";
	frmEmpPrmsCeilAdjForm.txtIndex.value ="";
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPrmsCeilAdjForm');
	return true;
        }
        else {
            qryprm = "txtSiteID="+ frmEmpPrmsCeilAdjForm.loginLocCode.value +",hdnEmpLbrFlag="+ frmEmpPrmsCeilAdjForm.hdnEmpLbrFlag.value;
	
	frmEmpPrmsCeilAdjForm.lovKey.value = "EmpPrmsCeilAdjEmpLov" + frmEmpPrmsCeilAdjForm.screenName.value + frmEmpPrmsCeilAdjForm.screenMode.value;
	frmEmpPrmsCeilAdjForm.queryParam.value = qryprm;
	frmEmpPrmsCeilAdjForm.txtDisplayFields.value = "txtEmpNum,txtEmpName,txtCpfCode,hdnITFlag";
	frmEmpPrmsCeilAdjForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.cpfCode,Payroll.Common.empName";
	frmEmpPrmsCeilAdjForm.txtInputField.value ="txtEmpNum";
	frmEmpPrmsCeilAdjForm.txtIndex.value ="";
	showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPrmsCeilAdjForm');
	return true;
            
        }
}    
function lfnLoad()
{  mode = document.all.screenMode.value;
    //alert(mode);
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='N'|| frmEmpPrmsCeilAdjForm.headerPrimaryKey.value=='' )
    { 
    }
    hedMenuHandling(mode);        

}

function populateFieldsUpdate()
{
    var oTable = document.getElementById("Detail");
    var iTr2 = oTable.rows.length;
	
    if(oTable == null)
    {
        return;
    }
    iTr2 = iTr2-1;
    if(frmEmpPrmsCeilAdjForm.buttonFlag.value == 'D') //add row button clicked.
    {
        if(iTr2 > 1)
        {
            document.getElementsByName("txtEmpList")[iTr2-1].value = document.getElementsByName("txtEmpList")[0].value;
        }
    }
}
function GetDetail()
{   
    if(mandatory_Check("frmEmpPrmsCeilAdjForm"))
    {   
        if (frmEmpPrmsCeilAdjForm.txtFinYear.value=="")
        {
            alert("Please Enter Financial Year First");
            return false;
        }
        document.all.buttonFlag.value='';
        frmEmpPrmsCeilAdjForm.headerPrimaryKey.value=frmEmpPrmsCeilAdjForm.headerPrimaryKey.value;
        document.all.screenMode.value='U';
        frmEmpPrmsCeilAdjForm.headerPrimaryKey.disabled="";
        frmEmpPrmsCeilAdjForm.action="../../../EmpPrmsCeilAdjDetailAction.do"
        frmEmpPrmsCeilAdjForm.submit();
    }
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpPrmsCeilAdjForm.action="../../../EmpPrmsCeilAdjNewMode.do"
    frmEmpPrmsCeilAdjForm.submit();
}

function getHeaderRecord()
{
    if(mandatory_Check("frmEmpPrmsCeilAdjForm"))
    {   
		document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
		frmEmpPrmsCeilAdjForm.action="../../../EmpPrmsCeilAdjGetHeaderAction.do"
                frmEmpPrmsCeilAdjForm.submit();
                
                
    }
  
}

function doGetNextHeader()
{ 
    //document.all.buttonFlag.value='';
    //frmEmpPrmsCeilAdjForm.userPositionRequested.value = 1*frmEmpPrmsCeilAdjForm.positionRequested.value + 1;
    //frmEmpPrmsCeilAdjForm.action="../../../EmpPrmsCeilAdjGetNextHeader.do";
    //frmEmpPrmsCeilAdjForm.submit();
    return true;
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPrmsCeilAdjForm.userPositionRequested.value = 1*frmEmpPrmsCeilAdjForm.positionRequested.value - 1;
    frmEmpPrmsCeilAdjForm.action = "../../../EmpPrmsCeilAdjGetNextHeader.do";
    frmEmpPrmsCeilAdjForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPrmsCeilAdjForm.userPositionRequested.value = 1*frmEmpPrmsCeilAdjForm.newPositionRequested.value;
    frmEmpPrmsCeilAdjForm.action = "../../../EmpPrmsCeilAdjGetNextHeader.do";
    frmEmpPrmsCeilAdjForm.submit();
}

function doQueryMode()
{   document.all.buttonFlag.value='';
    frmEmpPrmsCeilAdjForm.action="../../../EmpPrmsCeilAdjQueryMode.do"
    frmEmpPrmsCeilAdjForm.submit();
    
    
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpPrmsCeilAdjForm.action="../../../EmpPrmsCeilAdjRefresh.do"
    frmEmpPrmsCeilAdjForm.submit();
}

function SaveRecord()
{   
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmEmpPrmsCeilAdjForm"))
      {   
		if (document.all.txtAvailableBal.value==""||document.all.txtAvailableBal.value==null)
                {
                    alert("Please Adjust The Ceiling First");
                    return false;
                }
                  var answer = confirm("Have you verified all the data.Press OK to save the record!!!!")
                  
	if (!answer){
		return false;
	}
                  
        frmEmpPrmsCeilAdjForm.detailDataChanged.value = "false";            
        if(frmEmpPrmsCeilAdjForm.screenMode.value == 'N')
          frmEmpPrmsCeilAdjForm.headerDataChanged.value = "true";
        else 
          frmEmpPrmsCeilAdjForm.headerDataChanged.value = "false";
        frmEmpPrmsCeilAdjForm.headerFields.value = "true";        
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpPrmsCeilAdjForm.action = "../../../EmpPrmsCeilAdjSaveAction.do";            
        frmEmpPrmsCeilAdjForm.submit();
    }
    else
    {
        return false;
    }  
      
}
function initFields()
{   if (document.all.screenMode.value != "N")
    {
        document.all.butInsert.disabled="true"
        document.all.butDelete.disabled="true"
        document.all.txtFinYear.disabled="true";
        document.all.txtPayMode.disabled="true";
        document.all.txtAdjAmt.disabled="true";
        document.all.txtRemarks.disabled="true";
        document.all.butAdj.disabled="true";
    }
    else {
        document.all.txtFinYear.disabled="true";
        document.all.txtPayMode.disabled="true";
        document.all.txtAdjAmt.disabled="true";
        document.all.txtRemarks.disabled="true";
        document.all.butAdj.disabled="true";
    }
}
function initAdj(varType) 
{//alert(varType);
    if(mandatory_Check("frmEmpPrmsCeilAdjForm")){
    if (document.all.screenMode.value == "N")
    {
    if (varType=="IPD"||varType=="OPD")
    {
     document.all.txtFinYear.disabled="";
     document.all.txtFinYear.style.className="required";
     document.all.txtFinYear.style.background="#ffffd8";
     
     document.all.txtPayMode.disabled="";
     document.all.txtPayMode.style.className="required";
     document.all.txtPayMode.style.background="#ffffd3";
     
     document.all.txtAdjAmt.disabled="";
     document.all.txtAdjAmt.style.className="required";
     document.all.txtAdjAmt.style.background="#ffffd3";
     
     document.all.txtRemarks.disabled="";
     document.all.txtRemarks.style.className="optional";
     
     document.all.butAdj.disabled="";
     document.all.butAdj.style.className="required";
     document.all.butAdj.style.background="#ffffd8";
    
     document.all.txtFinYear.disabled="";
     document.all.txtFinYear.style.className="required";
     document.all.txtFinYear.style.background="#ffffd8";
   }
    }
    if (document.all.screenMode.value != "N")
    {
    if (frmEmpPrmsCeilAdjForm.txtEmpDsgn.value=="")
        {
            alert("Please Execute First");
            return false;
        }
    if (varType=="IPD"||varType=="OPD")
    {document.all.txtFinYear.disabled="";
     document.all.txtFinYear.style.className="required";
     document.all.txtFinYear.style.background="#ffffd8";
    }
    }
 }
}

function CeilAdj()

{   //alert("FUNCTION CeilAdj START"); 
    //alert(document.all.txtFinYear.value);
        if(document.all.txtFinYear.value!='')
        { //alert("Inside If");
            url="../../../GetEmpDtlRetroParZone.do";
            //alert(frmEmpPrmsCeilAdjForm.txtAdjType.value);
        
        prm="mode=1&txtEmpNum="+frmEmpPrmsCeilAdjForm.txtEmpNum.value+
            "&txtFinYear="+frmEmpPrmsCeilAdjForm.txtFinYear.value+
            "&txtClaimAmt="+frmEmpPrmsCeilAdjForm.txtClaimAmt.value+
            " &txtAdjType="+frmEmpPrmsCeilAdjForm.txtAdjType.value+
            "&txtPayMode="+frmEmpPrmsCeilAdjForm.txtPayMode.value+
            "&screenName="+frmEmpPrmsCeilAdjForm.screenName.value;
        
        //alert(prm);
        xml=getXML(url,prm);
        Tags=xml.getElementsByTagName("record");
        if(Tags.length > 0)
        { 
            frmEmpPrmsCeilAdjForm.txtOpenBal.value=Tags[0].childNodes[0].nodeValue;
            frmEmpPrmsCeilAdjForm.txtAvailableBal.value=Tags[1].childNodes[0].nodeValue;
        }
        else
        {
            alert("Error Occuered Please Contact Administrator");
        }
        }
        else
        {
        //alert("Inside Else");
            url="../../../GetEmpDtlRetroParZone.do";
        //alert(frmEmpPrmsCeilAdjForm.txtPayCode.value);
        
        prm="mode=1&txtEmpNum="+frmEmpPrmsCeilAdjForm.txtEmpNum.value+
            "&txtFinYear="+frmEmpPrmsCeilAdjForm.txtFinYear.value+
            "&txtClaimAmt="+frmEmpPrmsCeilAdjForm.txtClaimAmt.value+
            " &txtAdjType="+frmEmpPrmsCeilAdjForm.txtAdjType.value+
            "&screenName="+frmEmpPrmsCeilAdjForm.screenName.value;
        
        //alert(prm);
        xml=getXML(url,prm);
        Tags=xml.getElementsByTagName("record");
        if(Tags.length > 0)
        { 
            frmEmpPrmsCeilAdjForm.txtEmpNum.value=Tags[0].childNodes[0].nodeValue;
            frmEmpPrmsCeilAdjForm.txtEmpName.value=Tags[1].childNodes[0].nodeValue;
            frmEmpPrmsCeilAdjForm.txtEmpCat.value=Tags[2].childNodes[0].nodeValue;
            frmEmpPrmsCeilAdjForm.txtCpfCode.value=Tags[3].childNodes[0].nodeValue;
            frmEmpPrmsCeilAdjForm.txtSepDate.value=Tags[4].childNodes[0].nodeValue;
            frmEmpPrmsCeilAdjForm.txtSepType.value=Tags[5].childNodes[0].nodeValue;
            frmEmpPrmsCeilAdjForm.txtEmpDsgn.value=Tags[6].childNodes[0].nodeValue;
        }
        else
        {
            alert("Somthing Wrong Please Contact Administrator");
        }
        }
}
</script>
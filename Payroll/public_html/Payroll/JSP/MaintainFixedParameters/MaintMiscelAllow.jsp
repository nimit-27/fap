<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="pay.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
   <script language="JavaScript1.2" src="../INCLUDES/Payroll.js"></script>
   <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintMiscRates" name="frmMaintMiscRates" type="FCIPAY.Payroll.WEBTIER.Form.MaintMiscRatesForm" scope="session">
<bean:define id="ParentForm" name="frmMaintMiscRates" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:hidden property="detailDataChanged" />
<html:hidden property="headerFields" value="false" />
<html:hidden property="txtIndex" name="frmMaintMiscRates"  />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>
 <html:errors/>
<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN MISCELLANEOUS ALLOWANCE RATES</TD>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText > Miscellanoeus Allowance Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                      <td class=tableHeader width="1%"><html:checkbox property="selectAll" value="" onclick="toggleCheckBox('selectAll');checkRecord();"  /></td>
                                      <td class=tableHeader width="10%">Pay Scale Type</td>
                                      <td class=tableHeader width="5%">Category</td>
                                      <td class=tableHeader width="8%">Pay Code</td>
                                      <td class=tableHeader width="10%">Description</td>
                                      <td class=tableHeader width="8%">Pay Scale Code</td>                                      
                                      <td class=tableHeader width="10%">Effective Start Date</td>                                      
                                      <td class=tableHeader width="5%">Rate</td>
                                      </tr> 
                             <logic:iterate id="MiscRatesInfo" name="frmMaintMiscRates" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintMiscAllowBean" indexId="idx" >
                              <% ++i; %>
                               <logic:notEqual name="MiscRatesInfo" property="status" value="D" >  
                                   <tr>
                                        <td align = "center"><html:checkbox property="checked" onclick="checkRecord();"   name="frmMaintMiscRates" /></td>
                                                                                
                                        <td colspan="1">
                                        <logic:equal name="MiscRatesInfo" property="status" value="N">
                                        <html:select property="txtPayScaleType" name="MiscRatesInfo"  styleClass="required" alt="<%=String.valueOf(i) %>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 98%"  >
                                        <html:option value="">-----------Please Select-----------</html:option>
                                        <html:option value="ALL">ALL</html:option>
                                        <html:option value="CDA">CDA</html:option>
                                        <html:option value="IDA">IDA</html:option>
                                        </html:select>
                                        </logic:equal> 
                                        <logic:notEqual name="MiscRatesInfo" property="status" value="N">
                                        <html:select property="txtPayScaleType" name="MiscRatesInfo" disabled="true" styleClass="required" alt="<%=String.valueOf(i) %>" onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 98%"  >
                                        <html:option value="">-----------Please Select-----------</html:option>
                                        <html:option value="ALL">ALL</html:option>
                                        <html:option value="CDA">CDA</html:option>
                                        <html:option value="IDA">IDA</html:option>
                                        </html:select>
                                        </logic:notEqual> 
                                        </td>  
                                                                 
                                        <td >
                                        <logic:equal name="MiscRatesInfo" property="status" value="N">
                                        <html:select property="txtCategory" name="MiscRatesInfo"  styleClass="optional" alt="<%=String.valueOf(i) %>"  onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 98%"  >
                                        <html:option value="" >---------Please Select---------</html:option>      
                                        <logic:present name="CatMiscAllow">
                                        <html:optionsCollection label="label" value="value" property="valueCategArrayList" name="CatMiscAllow"/>
                                        </logic:present>
                                        </html:select>
                                        </logic:equal> 
                                        <logic:notEqual name="MiscRatesInfo" property="status" value="N">
                                        <html:select property="txtCategory" name="MiscRatesInfo" disabled="true" styleClass="optional" alt="<%=String.valueOf(i) %>"  onblur="checkDuplicacy(this,this.alt);" onchange="return changed(this.alt)"  style="WIDTH: 98%"  >
                                        <html:option value="" >---------Please Select---------</html:option>      
                                        <logic:present name="CatMiscAllow">
                                        <html:optionsCollection label="label" value="value" property="valueCategArrayList" name="CatMiscAllow"/>
                                        </logic:present>
                                        </html:select>
                                        </logic:notEqual> 
                                        </td>

                                        
                                       <td ><html:text property="txtPayCode" name="MiscRatesInfo" size="6" styleClass="required" style="width:70%" alt="<%=String.valueOf(i) %>" onchange="return checkDuplicacy(this,this.alt);" readonly="true"/>

                                       <logic:equal name="MiscRatesInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg"  height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  onclick="ShowLovPayCode1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="MiscRatesInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg"  height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayCode1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="MiscRatesInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg"  height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayCode1(this.alt);" >
                                       </logic:equal>
                                       </td>

                                       <td ><html:text property="txtPayCodeDesc" name="MiscRatesInfo"  styleClass="locked" readonly="true" size="20" style="width:98%" alt="<%=String.valueOf(i) %>" onchange="return changed(this.alt);" /></td>                                       

                                       <td ><html:text property="txtPayScaleCode" name="MiscRatesInfo" size="6" styleClass="optional" style="width:70%" alt="<%=String.valueOf(i) %>" readonly="true"  onchange="return checkDuplicacy(this,this.alt);" />

                                       <logic:equal name="MiscRatesInfo" property="status" value="N">
                                        <img src="../INCLUDES/IMAGES/lov.jpg"  height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  onclick="ShowLovPayScaleCode1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="MiscRatesInfo" property="status" value="Q">
                                        <img src="../INCLUDES/IMAGES/lov.jpg"  height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayScaleCode1(this.alt);" >
                                       </logic:equal>                                      
                                       <logic:equal name="MiscRatesInfo" property="status" value="U">
                                        <img src="../INCLUDES/IMAGES/lov.jpg"  height="16" align="center" alt="<%=idx%>" property="buttxtPayCode"  disabled onclick="ShowLovPayScaleCode1(this.alt);" >
                                       </logic:equal>
                                       </td>

                                    <html:hidden property="txtPayScaleRange" name="MiscRatesInfo" />                                     

                                    <td><html:text property="txtEffDate" name="MiscRatesInfo"  size="26" styleClass="required" style="width:80%;text-align:center" alt="<%=String.valueOf(i) %>" onchange="return chkFromDt(this.alt);" />
                                      <logic:equal name="MiscRatesInfo" property="status" value="N">
                                        <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>                                      
                                       <logic:equal name="MiscRatesInfo" property="status" value="Q">
                                       <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" disabled onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>                                      
                                       <logic:equal name="MiscRatesInfo" property="status" value="U">
                                       <img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="buttxtEffDate" alt="<%=(i-1) %>" disabled onclick="showCalendar('txtEffDate',this)" />
                                       </logic:equal>
                                    </td>                                     
                                    
                                    <td >
                                    <logic:equal name="MiscRatesInfo" property="status" value="N">
                                    <html:text property="txtRate" maxlength="9" name="MiscRatesInfo"  styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i) %>" onchange="
                                        if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                        " />
                                      </logic:equal>
                                    <logic:notEqual name="MiscRatesInfo" property="status" value="N">
                                    <html:text property="txtRate" maxlength="9" name="MiscRatesInfo" readonly="true" styleClass="required" size="26" style="width:100%;text-align:right" alt="<%=String.valueOf(i) %>" onchange="
                                        if (!num_Check(this.value,1))
                                        {
                                          this.focus();
                                          return false;
                                        }                                      
                                       else
                                       return changed(this.alt);
                                        " />
                                      </logic:notEqual>
                                      </td>
                                       <html:hidden property="txtEffEndDate" name="MiscRatesInfo" />   
                                       <html:hidden property="txtSrlNo" name="MiscRatesInfo" />                                                                                
                                       <html:hidden property="itemChecked" name="MiscRatesInfo" />
                                       <html:hidden property="status" name="MiscRatesInfo" />
                                       <html:hidden property="detailId" name="MiscRatesInfo" value="Default"/>
                                   
                                </tr>
                                 </logic:notEqual>                               
                                 
                                <logic:equal name="MiscRatesInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmMaintMiscRates" value="notchecked" /></td>
                                       <td ><html:hidden property="txtPayScaleType" name="MiscRatesInfo" /></td>
                                       <td ><html:hidden property="txtCategory" name="MiscRatesInfo" /></td>
                                       <td ><html:hidden property="txtPayCode" name="MiscRatesInfo" /></td>
                                       <td ><html:hidden property="txtPayCodeDesc" name="MiscRatesInfo" /></td>
                                       <td ><html:hidden property="txtPayScaleCode" name="MiscRatesInfo" /></td>
                                       <td ><html:hidden property="txtPayScaleRange" name="MiscRatesInfo" /></td>                                                                              
                                       <td ><html:hidden property="txtRate" name="MiscRatesInfo" /></td>
                                       <td ><html:hidden property="txtEffDate" name="MiscRatesInfo" /></td>
                                       <td ><html:hidden property="txtEffEndDate" name="MiscRatesInfo" /></td>
                                       <html:hidden property="txtSrlNo" name="MiscRatesInfo" />                                                                                                                       
                                       <html:hidden property="itemChecked" name="MiscRatesInfo" />
                                       <html:hidden property="status" name="MiscRatesInfo" />
                                       <html:hidden property="detailId" name="MiscRatesInfo" value="Default"/>
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
                                <!--  <TR>
                                    <TD><html:button value='Get Detail '  onclick="GetDetail()" property="butGetDetail" styleClass="bottomBarText" /> <html:button value='  Add Row '  onclick="addRow()" property="butInsert" styleClass="bottomBarText" /> <html:button value='Delete Row'  onclick="deleteRow()" property="butDelete" styleClass="bottomBarText" /></TD>
                                    <td width=46%> </td>	
                                    <TD ><IMG src="../INCLUDES/IMAGES/butn_dtl_prev.jpg" onmouseover='this.src="../INCLUDES/IMAGES/butn_dtl_prev_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/butn_dtl_prev.jpg"' alt=Butn_prev src="../INCLUDES/butn_dtl_prev.jpg"></td>
                                    <td class=dtlNavText>1 of 10</td>
                                    <td align=right><IMG src="../INCLUDES/IMAGES/butn_dtl_next.jpg" onmouseover='this.src="../INCLUDES/IMAGES/butn_dtl_next_act.jpg"' onmouseout='this.src="../INCLUDES/IMAGES/butn_dtl_next.jpg"' alt=Butn_next src="../INCLUDES/butn_dtl_next_act.jpg"></td>
                                    <td align=right><input type="text" name="hdrGoto" size="1"></td>
                                    <td><input type="image" src="..\INCLUDES\IMAGES\go_dtl.jpg"></td>		     
                                  </TR> -->
                                 <tr>
                                  <td colspan=11>	
                                  <jsp:include  page = "../INCLUDES/GenDetailMenu.jsp" flush="true" />
                                 </TD>
                                 </tr>
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
<html:hidden name="frmMaintMiscRates"  property="headerPrimaryKey" value="Default" />
<html:hidden name="frmMaintMiscRates"  property="screenMode"  />
<html:hidden name="frmMaintMiscRates"  property="screenName" value="MaintMiscRatesScreen" />
<html:hidden name="frmMaintMiscRates"  property="forwardedPage" />

<html:hidden property="lovKey" name="frmMaintMiscRates"  />
<html:hidden property="txtFields" name="frmMaintMiscRates"  />   
<html:hidden property="txtSearchFields" name="frmMaintMiscRates"  />
<html:hidden property="txtDisplayFields" name="frmMaintMiscRates"  />
<html:hidden property="txtInputField" name="frmMaintMiscRates"  />
<html:hidden property="totalDetailRecord" name="frmMaintMiscRates"  />
<html:hidden property="buttonFlag" name="frmMaintMiscRates"  />
<html:hidden property="userPageRequested" name="frmMaintMiscRates" />
<html:hidden property="pageRequested" name="frmMaintMiscRates" />
</html:form>
</body>
</html:html>

<script language="javascript">
var chkMes =0;
    
function changed(val)
{ 
    frmMaintMiscRates.detailDataChanged.value = "true";
    if (document.getElementsByName("status")[val-1].value == 'Q')
        document.getElementsByName("status")[val-1].value = 'U';
} 

function doBaseAddRow()
{
    document.all.buttonFlag.value='D';  
    EnableFields();    
    if(mandatory_Check("frmMaintMiscRates"))
    {
        document.forms[0].action = "../../../MiscAllowRatesAddRowAction.do";
        document.forms[0].submit();
    }
    else
    {
        return false;
    }
}

function doBaseDelRow()
{
    document.all.buttonFlag.value='D';  
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;    
    var flag = 0;
    var strRecList='';
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
        if(document.getElementsByName("txtSrlNo")[i].value=="")
        {
          document.getElementsByName("itemChecked")[i].value = "Y";
          frmMaintMiscRates.detailDataChanged.value = "true";      
          document.all.buttonFlag.value='D';
        }
        else
          strRecList=strRecList+(i+1)+",";

      }
    }
  if(strRecList!='')
  {
    alert("Sorry You Don't Have permission to Delete Record "+strRecList+" ");
  }
    EnableFields();
    document.forms[0].action = "../../../MiscAllowRatesdeleteRowAction.do";
    document.forms[0].submit();  
}

function GetDetail()
{
    document.all.buttonFlag.value='';  
    document.all.screenMode.value='U';
    frmMaintMiscRates.action="../../../MiscAllowRatesFirstGetDetailAction.do"
    frmMaintMiscRates.submit();
}

function checkDuplicacy(that,rInd)
{
    lengthOfTable = document.getElementById("Detail").rows.length;
    newComb = document.getElementsByName("txtPayScaleType")[rInd-1].value;
    newComb = newComb + "-";    
    newComb = newComb + document.getElementsByName("txtCategory")[rInd-1].value;
    newComb = newComb + "-";    
    newComb = newComb + document.getElementsByName("txtPayCode")[rInd-1].value;
    newComb = newComb + "-";    
    newComb = newComb + document.getElementsByName("txtPayScaleCode")[rInd-1].value;      
    for(ind = lengthOfTable - 1; ind > 0; ind --)
    {
        if(ind != rInd)
        {
            oldComb = document.getElementsByName("txtPayScaleType")[ind-1].value;
            oldComb = oldComb + "-";    
            oldComb = oldComb + document.getElementsByName("txtCategory")[ind-1].value;
            oldComb = oldComb + "-";    
            oldComb = oldComb + document.getElementsByName("txtPayCode")[ind-1].value;
            oldComb = oldComb + "-";    
            oldComb = oldComb + document.getElementsByName("txtPayScaleCode")[ind-1].value;    
            if(oldComb == newComb)
            {
                // alert("You can\'t enter duplicate value");
                var response=confirm("There is already a record. Do You still want to continue ?");
                if(response==false)
                {
                    document.getElementsByName("txtPayScaleType")[rInd-1].value="";
                    document.getElementsByName("txtCategory")[rInd-1].value="";
                    document.getElementsByName("txtPayCode")[rInd-1].value="";
                    document.getElementsByName("txtPayCodeDesc")[rInd-1].value="";
                    document.getElementsByName("txtPayScaleCode")[rInd-1].value="";
                    document.getElementsByName("txtPayScaleRange")[rInd-1].value="";
                    document.getElementsByName("txtPayScaleType")[rInd-1].focus();
                }
                return;
            }
        }
    }
}
  
function setEndDt(rInd)
{
    lengthOfTable = document.getElementById("Detail").rows.length;
    newComb = document.getElementsByName("txtPayScaleType")[rInd-1].value;
    newComb = newComb + "-";    
    newComb = newComb + document.getElementsByName("txtCategory")[rInd-1].value;
    newComb = newComb + "-";    
    newComb = newComb + document.getElementsByName("txtPayCode")[rInd-1].value;
    newComb = newComb + "-";    
    newComb = newComb + document.getElementsByName("txtPayScaleCode")[rInd-1].value;    
    
    selDt = document.getElementsByName("txtEffDate")[rInd-1].value;
    var systDate = getSysDate();
    for(var ind = lengthOfTable - 1; ind > 0; ind --)
    {
        if(ind != rInd)
        {
            oldComb = document.getElementsByName("txtPayScaleType")[ind-1].value;
            oldComb = oldComb + "-";    
            oldComb = oldComb + document.getElementsByName("txtCategory")[ind-1].value;
            oldComb = oldComb + "-";    
            oldComb = oldComb + document.getElementsByName("txtPayCode")[ind-1].value;
            oldComb = oldComb + "-";    
            oldComb = oldComb + document.getElementsByName("txtPayScaleCode")[ind-1].value;            
            
            startDt= document.getElementsByName("txtEffDate")[ind-1].value;            
            if(oldComb == newComb)
            {
                if (!cmpDate(startDt,selDt,0)) 
                {
                    alert("Start Date must be greater than prev start date");                   
                    document.getElementsByName("txtEffDate")[rInd-1].value="";
                    return false;                      
                }
                else
                {               
                    document.getElementsByName("txtEffEndDate")[ind-1].value=selDt;                    
                    frmMaintMiscRates.detailDataChanged.value = "true";
                    if (document.getElementsByName("status")[ind-1].value == 'Q')
                        document.getElementsByName("status")[ind-1].value = 'U';                    
                    return;
                }
            }
        }
    }
}

function chkFromDt(i)
{
    var fromDt=document.getElementsByName("txtEffDate")[i-1].value;
    if(!cmpSysDate(fromDt,0))
    { 
        document.getElementsByName("txtEffDate")[i-1].value="";
        return false;
    }    
    var systDate = getSysDate();      
    if(!cmpDateMsg(fromDt,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        document.getElementsByName("txtEffDate")[i-1].value="";
        return false;        
    }    
    setEndDt(i);    
}

function SaveRecord()
{
    document.all.buttonFlag.value='';  
    if(!mandatory_Check("frmMaintMiscRates"))
        return false;          
    //if(!DupliCheck())
        //return false;      
    var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return;
    }
    var iTr2 = oTable.rows.length;
    var i = 0;
    for(i=0; i < iTr2 -1; i++)
    {
        document.getElementsByName("txtPayCode")[i].disabled="";
        document.getElementsByName("txtRate")[i].disabled="";
        document.getElementsByName("txtEffDate")[i].disabled=""       
        if (document.getElementsByName("status")[i].value == 'D')
            frmMaintMiscRates.detailDataChanged.value = "true";
    }    
    EnableFields();      
    frmMaintMiscRates.headerFields.value = "false";
    frmMaintMiscRates.totalDetailRecord.value = parseInt(iTr2,10) - 1;
	document.all.butSave.disabled="true";
	document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
    frmMaintMiscRates.action = "../../../MiscAllowRatesSaveAction.do";
    frmMaintMiscRates.submit();
} 

function DupliCheck()
{
    var oTable = document.getElementById("Detail");
    var iTr2 = oTable.rows.length;
    var flag =0;
    var i = 0;
    var j;
    j = 0;
    for(i=0;i<iTr2-2;i++)
    {       
        if (document.getElementsByName("status")[i].value != 'D')
        {
            var Group1 = document.getElementsByName("txtPayScaleType")[i].value;
            var Group11 = document.getElementsByName("txtCategory")[i].value;
            var Group111 =  parseInt(document.getElementsByName("txtPayCode")[i].value);
            var com1 = Group1 + Group11+ Group111;              
            for(j=i+1;j<iTr2-1;j++)                
            {                       
                if (document.getElementsByName("status")[j].value != 'D')
                {                    
                    var Group2 = document.getElementsByName("txtPayScaleType")[j].value;
                    var Group21 = document.getElementsByName("txtCategory")[j].value;     
                    var Group211 = parseInt(document.getElementsByName("txtPayCode")[j].value); 
                    var com2 = Group2 + Group21+ Group211;                        
                    if(com1==com2)
                    {
                        var response=confirm("There is already a record. Do You still want to continue ?");
                        if(response==false)
                        {
                            document.getElementsByName(that)[rInd-1].value="";
                            document.getElementsByName(that)[rInd-1].focus();
                            return false;
                        }                        
                    }                                               
                }
            }                              
        }
    }
    return true;
}

function doInsertMode()
{
    //  alert("new");
    //  frmMaintMiscRates.action="../../../MiscAllowRatesNewMode.do"
    //  frmMaintMiscRates.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';  
    frmMaintMiscRates.action="../../../MiscAllowRatesQueryMode.do"
    frmMaintMiscRates.submit();

}

function lfnLoad()
{
    mode = document.all.screenMode.value;
    if(mode=='')
    {
        doQueryMode();
        document.all.butInsert.disabled="disabled"
        document.all.butDelete.disabled="disabled"
    }
    if(mode=='Q')
    {
        document.all.butInsert.disabled="disabled"
        document.all.butDelete.disabled="disabled"
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
                document.getElementsByName("txtPayCode")[i].disabled="disabled";
                document.getElementsByName("txtEffDate")[i].disabled="disabled"; 
            }
        }
    }     
    mode1 = frmMaintMiscRates.screenMode.value; 
    detMenuHandling(mode1);
    
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
        document.getElementsByName("txtPayCode")[i].disabled="";
        document.getElementsByName("txtRate")[i].disabled="";
        document.getElementsByName("txtEffDate")[i].disabled="";    
    }
 }

function showCalendar(inputId, butId) 
{
    if(butId.alt)
    {
        iIndex=butId.alt;
    }
    else
    {
        iIndex="-1";
    }
    Calendar.setup({inputField	: inputId,
       ifFormat	: "%d-%b-%Y",
       button	: butId,
       position: iIndex
        });
    return false;
}

function doBasePrevDetail()
{
    frmMaintMiscRates.userPageRequested.value = 1*frmMaintMiscRates.pageRequested.value - 1;
    frmMaintMiscRates.action = "../../../MiscAllowRatesPrevDetailAction.do";
    frmMaintMiscRates.submit();
}

function doBaseNextDetail()
{
    frmMaintMiscRates.userPageRequested.value = 1*frmMaintMiscRates.pageRequested.value + 1;
    frmMaintMiscRates.action = "../../../MiscAllowRatesNextDetailAction.do";
    frmMaintMiscRates.submit();
}

function JumpDetail()
{
    frmMaintMiscRates.userPageRequested.value = 1*frmMaintMiscRates.newPageRequested.value ;
    frmMaintMiscRates.action = "../../../MiscAllowRatesNextDetailAction.do";
    frmMaintMiscRates.submit();
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
        document.getElementsByName("txtPayScaleType")[i].disabled="";
        document.getElementsByName("txtCategory")[i].disabled="";
        
        document.getElementsByName("txtPayCode")[i].disabled="";
        document.getElementsByName("txtEffDate")[i].disabled=""; 
    }
}

function checkDate(i)
{
    var m = document.getElementsByName("txtEffDate")[i].value;
    if(m != "")
    {
        if(!isDate(m,"dd-MMM-yyyy"))
        {
            alert("Enter Proper Effective Date  in the Format DD-MMM-YYYY");
            return false;
        }
    }    
    return true;
}

function doRefresh()
{
    frmMaintMiscRates.action = "../../../MiscAllowRatesRefresh.do";
    frmMaintMiscRates.submit();
}

function ShowLovPayCode1(i)
{
    frmMaintMiscRates.lovKey.value = "MiscelAllowPayCode" + frmMaintMiscRates.screenName.value + "Q";
    frmMaintMiscRates.txtDisplayFields.value = "txtPayCode,txtPayCodeDesc";
    frmMaintMiscRates.txtSearchFields.value = "Payroll.Common.Paycode,Payroll.Common.Desc";
    frmMaintMiscRates.txtInputField.value ="txtPayCode"; 
    frmMaintMiscRates.txtIndex.value=i;  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintMiscRates');
    return true;
}

function ShowLovPayScaleCode1(i)
{
    frmMaintMiscRates.lovKey.value = "MiscelAllowPayScaleCode" + frmMaintMiscRates.screenName.value + "Q";
    frmMaintMiscRates.txtDisplayFields.value = "txtPayScaleCode,txtPayScaleRange";
    frmMaintMiscRates.txtSearchFields.value = "";
    frmMaintMiscRates.txtInputField.value ="txtPayScaleCode"; 
    frmMaintMiscRates.txtIndex.value=i;  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintMiscRates');
    return true;
}

</script>
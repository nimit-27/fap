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
</head>
<BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<html:form  action="MaintEmpSelectGrDetailBase" name="frmEmpPromotionForm" type="FCIPAY.Payroll.WEBTIER.Form.MaintEmpPromotionForm">
<bean:define id="ParentForm" name="frmEmpPromotionForm" toScope="request" />
<jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
<html:errors/>
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="true" />
<%! int i=0,j=0; %>
<% i =1;j=0; %>
<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>EMPLOYEE SELECTION GRADE INFORMATION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0 >
            <!--General Information Row Starts -->
            <TR>
              <TD class=subHeader colspan=6> Detail Information Of Employee</TD>
            </TR>
            
            <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
            </TR> 
            
            <tr height="15" >
              <td colspan="6"></td>
            </tr>           
            
            <tr></tr>
            <table  cellSpacing=0 cellPadding=0 border=0> 
            
                <TR>
                  <TD class=labelText><bean:message key="Payroll.EmpInfo.Empno" /></TD>
                  <td align="left" colspan="5">
                  <logic:equal property= "screenMode" name= "frmEmpPromotionForm" value="N">                   
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true"/>
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal> 
                  <logic:notEqual property= "screenMode" name= "frmEmpPromotionForm" value="N">
                  <html:text  property="headerPrimaryKey" altKey="Payroll.EmpInfo.Empno" maxlength="10" size="23" styleClass="required" readonly="true" />
                  </logic:notEqual>                                                                                      
                  <logic:equal property= "screenMode" name= "frmEmpPromotionForm" value="Q">                              
                  <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtEmpNo"  onclick="return ShowEmpNum();">
                  </logic:equal>
                  <html:text  property="txtEmpName" altKey="pay.MaintainAnnualIncome.txtEmpName" maxlength="10" size="46" styleClass="locked" readonly="true" />
                  </td> 
              </TR> 
                                
              <TR>              
                  <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.Desig" /></TD>
                  <td align="left">
                  <html:text  property="txtDsgn" altKey="Payroll.EmpInfo.Desig" maxlength="10" size="23" styleClass="locked" readonly="true"/>
                  <html:hidden property="txtDsgnDesc"  styleClass="locked" />
                  </td>
                  
                  <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.lstCateg" /> </td>                            
                  <td ><html:text property="txtCategDesc" styleClass="locked" readonly="true" size="23"/><html:hidden property="txtCateg"  styleClass="locked" /></td>                                                                        
              </tr>
                      
              <tr> 
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.Emptype" /> </td>
                  <td>
                  <html:text  property="txtEmpType" altKey="Payroll.EmpInfo.Emptype" maxlength="10" size="23" styleClass="locked" readonly="true"/>                                    
                  </td> 
                  
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.CpfCode" /> </td>
                  <td>
                  <html:text  property="txtCpfCode" altKey="pay.EmpInfo.CpfCode" maxlength="7" size="23" styleClass="locked"  style="text-align:Left"   /></td>                                                                  
              </tr>
              <tr>
                  <td class=labelText  ><bean:message key="Payroll.EmpInfo.PresentPOP" /> </td>                
                  <td><html:text  property="txtPresentPOP" altKey="pay.EmpInfo.PresentPOP" maxlength="7" size="23" styleClass="locked"  style="text-align:left"   />                  
                  </td>                                                            
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.DojSite" /> </td>            
                  <td>
                  <html:text  property="txtDOJSite" altKey="Payroll.EmpInfo.DojSite" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
              </tr>    
      
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.EmpStat" /> </td>                            
                  <td ><html:text  property="txtEmpStatus" altKey="Payroll.EmpInfo.EmpStat" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>             
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.curbas" /> </td>            
                  <td>
                  <html:text  property="txtCurtBasic" altKey="Payroll.EmpInfo.curbas" maxlength="15" size="23" styleClass="locked" style="text-align:right" readonly="true"/>
                  </td>
              </tr>
              
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.PrvPromdate" /> </td>            
                  <td>
                  <html:text  property="txtPrvPromDate" altKey="Payroll.EmpInfo.PrvPromdate" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.PersPaySFN" /> </td>            
                  <td>
                  <html:text  property="txtPersPaySFNAmt" altKey="Payroll.EmpInfo.PersPaySFN" maxlength="15" size="23" styleClass="locked" style="text-align:right" readonly="true"/>
                  </td>
              </tr>    
              
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.PersPayHQual" /> </td>            
                  <td>
                  <html:text  property="txtPerPayHighQual" altKey="Payroll.EmpInfo.PersPayHQual" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.PersPayAdvIncr" /> </td>            
                  <td>
                  <html:text  property="txtPerPayAdvIncr" altKey="Payroll.EmpInfo.PersPayAdvIncr" maxlength="15" size="23" styleClass="locked" style="text-align:right" readonly="true"/>
                  </td>
              </tr>
              
              <tr>
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.StrInc" /> </td>            
                  <td>
                  <html:text  property="txtStagInc" altKey="Payroll.EmpInfo.StrInc" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
                  <td width="15%" class=labelText  ><bean:message key="Payroll.EmpInfo.persPayFutIncr" /> </td>            
                  <td>
                  <html:text  property="perPayFutureIncr" altKey="Payroll.EmpInfo.persPayFutIncr" maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>
                  
              </tr>
   

                  <!--added by sonia on 08-04-2011-->
				  <tr>
                  <td width="15%" class=labelText  >Pay Band/Pay Scale code </td>            
                  <td>
                  <html:text  property="payScaleCode"  maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>

				  <td width="15%" class=labelText  >Pay Scale</td>            
                  <td>
                  <html:text  property="txtPayType"  maxlength="15" size="23" styleClass="locked" readonly="true"/>
                  </td>

				  </tr>
                   <!--end by sonia on 08-04-2011-->
             

   
            </table>     
          </tr>            
      <tr height="15" >
      <td colspan="6"></td>
    </tr>                                 
  </table>
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
 	 <TR height="100">
      <TD colspan=6>
      <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText > Selection Grade Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
           
          <tr height="10"><td class=userText colspan="14"></td></tr>            
          <TR height=10>
 <!-- Detail table Container starts -->
            <TD colspan=14>
              <TABLE cellSpacing=0 cellPadding=0 border=0>
                <TBODY>
                  <TR>
                    <TD >
  			<!-- Detail table starts -->
                     <TABLE cellSpacing=0 cellPadding=0 border=0>
                      <TBODY>
                        <TR>                          
                          <td  width="23%" class=labelText><bean:message key="Payroll.EmpInfo.promType" /></td>                                                    
                          <td colspan="1">
                          <logic:equal property= "screenMode" name= "frmEmpPromotionForm" value="N">  
                          <html:select property="promType" name="frmEmpPromotionForm"  styleClass="required"    style="WIDTH: 54%"  >
                          <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="PROMTYPE$SELGR" ><bean:message key="Payroll.EmpInfo.SelGrade" /></html:option>
                          <html:option value="PROMTYPE$SELREV" ><bean:message key="Payroll.EmpInfo.SelRev" /></html:option> 
                          </html:select>
                          </logic:equal> 
                          
                          <logic:notEqual property= "screenMode" name= "frmEmpPromotionForm" value="N">
                          <html:select property="promType" name="frmEmpPromotionForm"  styleClass="optional"  disabled="true" style="WIDTH: 54%"  >
                          <html:option value="" ><bean:message key="Payroll.pleaseSelect" /></html:option>      
                          <html:option value="PROMTYPE$SELGR" ><bean:message key="Payroll.EmpInfo.SelGrade" /></html:option>
                          <html:option value="PROMTYPE$SELREV" ><bean:message key="Payroll.EmpInfo.SelRev" /></html:option> 
                          </html:select>
                          </logic:notEqual>
                          
                          </td>                                                   
                          
                          <TD width="23%" class=labelText  ><bean:message key="Payroll.EmpInfo.payscalecode" /></TD>
                          <td align="left" colspan="1">                                                    
                          <logic:equal property= "screenMode" name= "frmEmpPromotionForm" value="N">                              
                          <html:text  property="newPayScaleCode" altKey="Payroll.EmpInfo.payscalecode" maxlength="25" size="2" styleClass="required" onchange="upper(this);" readonly="true"/>
                          <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtDesig"  onclick="return ShowLovDsgn();">
                          
                          </logic:equal>                                                                                                 
                          <logic:notEqual property= "screenMode" name= "frmEmpPromotionForm" value="N"> 
                          <html:text  property="payScaleCode" altKey="Payroll.EmpInfo.payscalecode" maxlength="25" size="2" styleClass="optional" readonly="true"/>               
                          
                          </logic:notEqual>                                     
                          </td>
                    </tr> 

                    <tr>   
                        <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.newBasic" /></td>
                        <td colspan="1">
                        <logic:equal property= "screenMode" name= "frmEmpPromotionForm" value="N">  
                        <html:text  property="newBasic" styleClass = "required" alt="<%=String.valueOf(i) %>" maxlength="10" size="23"  onkeypress="
                         if((event.keyCode < 48 || event.keyCode > 57))
                          {
                            return false;
                          };    
                           "  style="text-align:right"  />                      
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmEmpPromotionForm" value="N">
                        <html:text  property="newBasic" styleClass = "optional" alt="<%=String.valueOf(i) %>" maxlength="25" size="23" style="text-align:right" readonly="true" />
                        </logic:notEqual>
                        </td>
                        
                        
                        <td width="20%" class=labelText  ><bean:message key="Payroll.EmpInfo.selRevEffDate" /> </td>            
                        <td colspan="1">
                        <logic:equal property= "screenMode" name= "frmEmpPromotionForm" value="N">  
                        <html:text  property="newPromEffDate"  maxlength="10" size="23" styleClass="required" onchange="checkPromEffDate(this.value);" readonly="true"/><img src="..\INCLUDES\IMAGES\cal.gif" title="Calender" width=15 height=19 align="top" styleClass="lov" property="newPromEffDate" alt="<%=(i-1) %>" onclick="showCalendar('newPromEffDate',this)" />
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmEmpPromotionForm" value="N">
                        <html:text  property="newPromEffDate"  maxlength="10" size="23" styleClass="optional" readonly="true"/>
                        </logic:notEqual>
                        </td>
                    </tr>
                    <tr>
                        <td width="20%" class=labelText><bean:message key="Payroll.EmpInfo.remark" /></td>
                        <td >
                        <logic:equal property= "screenMode" name= "frmEmpPromotionForm" value="N">  
                        <html:text  property="remarks" styleClass = "optional" alt="<%=String.valueOf(i) %>" maxlength="50" size="23" style="text-align:left"  />                             
                        </logic:equal> 
                        <logic:notEqual property= "screenMode" name= "frmEmpPromotionForm" value="N">
                        <html:text  property="remarks" styleClass = "optional" alt="<%=String.valueOf(i) %>" maxlength="50" size="23" style="text-align:left" readonly="true" />                              
                        </logic:notEqual>
                        </td>
                       
                    </tr>
                    
                    <tr height = 3><td>&nbsp;</td></tr>                    
                    <tr height = 3><td>&nbsp;</td></tr>                    
                  </TBODY>
                </TABLE>
              </TD>
            </TR>                     
         </TBODY>
		    </TABLE>
		  </td>
   </tr>       
<!-- Tab table Row 3 starts -->
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

</div>


<!-- Container Table Ends -->
<html:hidden name="frmEmpPromotionForm"  property="screenName" value="MaintEmpSelectGrScreen" />
<html:hidden name="frmEmpPromotionForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmEmpPromotionForm" />
<html:hidden property="loginLocCode" name="frmEmpPromotionForm" />
<html:hidden property="positionRequested" name="frmEmpPromotionForm" />
<html:hidden property="userPositionRequested" name="frmEmpPromotionForm" />
<html:hidden property="buttonFlag" name="frmEmpPromotionForm"  />
<html:hidden property="lovKey" name="frmEmpPromotionForm"  />
<html:hidden property="txtFields" name="frmEmpPromotionForm"  />   
<html:hidden property="txtSearchFields" name="frmEmpPromotionForm"  />
<html:hidden property="txtDisplayFields" name="frmEmpPromotionForm"  />
<html:hidden property="txtIndex" name="frmEmpPromotionForm"  />
<html:hidden property="txtEmpNo" name="frmEmpPromotionForm"  />
<html:hidden property="newCateg" name="frmEmpPromotionForm"  />
<html:hidden property="newCategDesc" name="frmEmpPromotionForm"  />
<html:hidden property="newPayScaleCode" name="frmEmpPromotionForm"  />
<html:hidden property="hdnStartBasic" name="frmEmpPromotionForm"  />
<html:hidden property="hdnEndBasic" name="frmEmpPromotionForm"  />
<html:hidden property="newDsgn" name="frmEmpPromotionForm"  />

<html:hidden property="newDsgnDesc" name="frmEmpPromotionForm"  />
<html:hidden property="newPerPayHighQual" name="frmEmpPromotionForm"  />
<html:hidden property="txtGradePay" name="frmEmpPromotionForm"  />
<html:hidden property="newGradePay" name="frmEmpPromotionForm"  />
<html:hidden property="newPerPayFutIncr" name="frmEmpPromotionForm"  />
<html:hidden property="newStagInc" name="frmEmpPromotionForm"  />
<html:hidden property="adhcPromEndDate" name="frmEmpPromotionForm"  />

<html:hidden property="txtInputField" name="frmEmpPromotionForm"  />

<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">

function ShowEmpNum()
{
    frmEmpPromotionForm.lovKey.value = "EmpSelectGr" + frmEmpPromotionForm.screenName.value + frmEmpPromotionForm.screenMode.value;    
    frmEmpPromotionForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName,txtDsgn,txtCateg,txtCategDesc,txtEmpType,txtCpfCode,txtPresentPOP,txtEmpStatus,txtDOJSite,txtCurtBasic,txtPrvPromDate,txtPayType,txtPersPaySFNAmt,txtPerPayHighQual,txtPerPayAdvIncr,txtStagInc,txtDsgnDesc,payScaleCode,txtGradePay";
    frmEmpPromotionForm.queryParam.value = "txtSiteID="+frmEmpPromotionForm.loginLocCode.value+",hdnEmpLbrFlag="+frmEmpPromotionForm.hdnEmpLbrFlag.value;
    frmEmpPromotionForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.EmpInfo.FirstName";
    frmEmpPromotionForm.txtIndex.value ="";         
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPromotionForm');
    return true;
}    

/* commented by sonia

function ShowLovDsgn()
{
   frmEmpPromotionForm.lovKey.value = "EmpPromoPayScaleCode" + frmEmpPromotionForm.screenName.value + frmEmpPromotionForm.screenMode.value;
   frmEmpPromotionForm.txtDisplayFields.value = "payScaleCode,payScaleCodeDesc";   
   frmEmpPromotionForm.txtSearchFields.value = "";
   frmEmpPromotionForm.txtInputField.value =""; 
   frmEmpPromotionForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPromotionForm');
   return true;
}
*/

/////////////////added by sonia////////////

function ShowLovDsgn(){
if(frmEmpPromotionForm.txtPayType.value == 'IDA'){
	
ShowLovDsgnIDA();
}
if(frmEmpPromotionForm.txtPayType.value == 'CDA'){
	
ShowLovDsgnCDA();
}

}
function ShowLovDsgnIDA()
{
    if(frmEmpPromotionForm.promType.value=="")
    {
        alert("Please Select Promotion/Reversal Type First!");
        frmEmpPromotionForm.promType.focus();
        return false;
    }
    else
    {
        frmEmpPromotionForm.lovKey.value = "EmpSelectionDsgnIDA" + frmEmpPromotionForm.screenName.value + frmEmpPromotionForm.screenMode.value;
        frmEmpPromotionForm.txtDisplayFields.value = "newDsgnDesc,newDsgn,newCateg,newCategDesc,newPayScaleCode,newGradePay";
        frmEmpPromotionForm.queryParam.value = "txtPromoType="+frmEmpPromotionForm.promType.value+",txtCategory="+frmEmpPromotionForm.txtCateg.value+" ";   
        frmEmpPromotionForm.txtSearchFields.value = "";
        frmEmpPromotionForm.txtInputField.value =""; 
        frmEmpPromotionForm.txtIndex.value =""; 
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPromotionForm');
        return true;
    }
}


function ShowLovDsgnCDA()
{
    if(frmEmpPromotionForm.promType.value=="")
    {
        alert("Please Select Promotion/Reversal Type First!");
        frmEmpPromotionForm.promType.focus();
        return false;
    }
    else
    {
        frmEmpPromotionForm.lovKey.value = "EmpSelectionDsgnCDA" + frmEmpPromotionForm.screenName.value + frmEmpPromotionForm.screenMode.value;
        frmEmpPromotionForm.txtDisplayFields.value = "newDsgnDesc,newDsgn,newCateg,newCategDesc,newPayScaleCode,newGradePay";
        frmEmpPromotionForm.queryParam.value = "txtPromoType="+frmEmpPromotionForm.promType.value+",txtCategory="+frmEmpPromotionForm.txtCateg.value+" ";   
        frmEmpPromotionForm.txtSearchFields.value = "";
        frmEmpPromotionForm.txtInputField.value =""; 
        frmEmpPromotionForm.txtIndex.value =""; 
        showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmEmpPromotionForm');
        return true;
    }
}

//////////////////end/////////


function lfnLoad()
{
    mode = document.all.screenMode.value;
    if(mode == '')
    {
        doQueryMode();
    }    
    if(mode=='U')
    {        
        document.all.txtCateg.disabled = "true";
        //document.all.txtDsgn.disabled = "true";      
        //document.all.headerPrimaryKey.disabled = "true";          
    } 
    hedMenuHandling(mode);    
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    frmEmpPromotionForm.action="../../../EmpSelGradeQueryMode.do"
    frmEmpPromotionForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpPromotionForm.action="../../../EmpSelGradeRefresh.do"
    frmEmpPromotionForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    frmEmpPromotionForm.action="../../../EmpSelGradeNewMode.do"
    frmEmpPromotionForm.submit();
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
		document.all.butExecute.disabled="true";
		document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";		

    frmEmpPromotionForm.action="../../../EmpSelGradeGetHeaderAction.do"
    frmEmpPromotionForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpPromotionForm.userPositionRequested.value = 1*frmEmpPromotionForm.positionRequested.value + 1;
    frmEmpPromotionForm.action="../../../EmpSelGradeGetNextHeader.do";
    frmEmpPromotionForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPromotionForm.userPositionRequested.value = 1*frmEmpPromotionForm.positionRequested.value - 1;
    frmEmpPromotionForm.action = "../../../EmpSelGradeGetPrevHeader.do";
    frmEmpPromotionForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpPromotionForm.userPositionRequested.value = 1*frmEmpPromotionForm.newPositionRequested.value;
    frmEmpPromotionForm.action = "../../../EmpSelGradeGetNextHeader.do";
    frmEmpPromotionForm.submit();
}


function cancelPromotion()
{
    alert("Cancel Promotion");
}

function SaveRecord()
{
    document.all.buttonFlag.value=''; 
    //if(checkCurBasicLimit())
    //{
        if(mandatory_Check("frmEmpPromotionForm"))
        {     
            frmEmpPromotionForm.txtEmpNo.value=frmEmpPromotionForm.headerPrimaryKey.value;                     
            frmEmpPromotionForm.detailDataChanged.value = "false";  
            if(frmEmpPromotionForm.screenMode.value == "N")
                frmEmpPromotionForm.headerDataChanged.value = "true";    
            frmEmpPromotionForm.headerFields.value = "true";
			document.all.butSave.disabled="true";
			document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
            frmEmpPromotionForm.action = "../../../EmpSelGradeSaveAction.do";            
            frmEmpPromotionForm.submit();
          }
    //}  
    else
    {
        return false;
    }
}


function Chk_Char(name)
{
    that=document.getElementsByName(name)[0];    
    str=that.value; 
    for(i=0; i<str.length; i++)
    {
        var txtVal =str.charAt(i);
        if((txtVal >= 'A' && txtVal <= 'Z') ||(txtVal >= 'a' && txtVal <= 'z') || (txtVal == ',') || (txtVal == ' '))
        {}
        else
        {
            alert("Invalid Input");               
            that.select(); 
            //alert(that.value);
            return true;
        }
    }
}

function checkPromEffDate(cdate)
{
    if (trim(cdate) == "" || frmEmpPromotionForm.txtPrvPromDate.value=='N')
    {
        return true;
    }
    if(frmEmpPromotionForm.txtPrvPromDate.value!= '')
    {
        firstIndex=cdate.indexOf("-");
        lastIndex=cdate.lastIndexOf("-");        
        if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
        {
            var arr=cdate.split("-");
            var arrDOJF=frmEmpPromotionForm.txtPrvPromDate.value.split("-");
            var cyear= arr[2];            
            var dyear=arrDOJF[2];
            var monIndx=getMonthIndx(arr[1]);            
            var dmonIndx=getMonthIndx(arrDOJF[1]);            
            if(monIndx!=-1)
            {
                cdate = arr[0] + "/" + monIndx + "/" + cyear;  		
                ddate = arrDOJF[0] + "/" + dmonIndx + "/" + dyear;  		
            }    
        }
        //cdate = change_DateFormat(cdate);  
        sysDate = getSysDate(); 
        if (dateDiff(ddate, cdate) < 0 || dateDiff(sysDate, cdate) >0)
        {
            alert("Promotion Date Cannot be Less then Prev. Promotion Date or Greater then Current Date");           
            
            frmEmpPromotionForm.newPromEffDate.value="";
            return false;
        }          
        return true;
    }
}

function checkCurBasicLimit()
{
    var curBasic;
    var startBasic;
    var endBasic;
    var curBasic;     
    curBasic = parseInt(frmEmpPromotionForm.newBasic.value);
    startBasic =parseInt(frmEmpPromotionForm.hdnStartBasic.value); 
    endBasic = parseInt(frmEmpPromotionForm.hdnEndBasic.value);    
    if(curBasic < startBasic || curBasic > endBasic)
    {
        alert("New Basic Should be In Range "+startBasic+" To "+endBasic);
        frmEmpPromotionForm.newBasic.select();
        frmEmpPromotionForm.newBasic.focus();
        return false;
    }    
    else
        return true;
}
    
</script>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="java.util.ArrayList,FCIPAY.Payroll.UTILITY.EmpFinVldnBean" %>
<html:html>
	<HEAD>
    <html:base/>
		<TITLE><bean:message key="pay.title"/></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />  
    <script language="javascript" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>  
    <script language="JavaScript1.2" src="../INCLUDES/EmpFinInfo.js"></script>      
    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>    
  </head>
  <BODY  onload="lfnLoad();history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintDeptLabourDetailBase" name="frmDeptLabourInfoForm" type="FCIPAY.Payroll.WEBTIER.Form.DeptLabourInfoForm">
  <bean:define id="ParentForm" name="frmDeptLabourInfoForm" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>  
  <% i = 0;j=0; %>
        <%
              ArrayList arEmpVld=new ArrayList();
              if(session.getAttribute("arEmpVld")!=null)
              {
                arEmpVld=(ArrayList)session.getAttribute("arEmpVld");
              }
        %>
  <jsp:include page="DeptLabourHeader.jsp" flush="true" />
  <table cellspacing=0 cellpadding=0 border=0 >
         <!-- Detail Information Row starts -->
    <TR>
            <TD colspan=6>
            <!-- Purchase Requisition Info Table Starts -->
            <TABLE cellSpacing=0 cellPadding=0 border = 0 >
               <TR>          
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("PayDet")> Payroll Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("FlagDet")> Payroll Flag Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    
                    <td bgcolor="#76A2C7" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#76A2C7" nowrap class=disTabText onclick=doGetTabs("HrDet")> HRMS Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_lb.gif" width="10" height="21" border="0"></td>
                    
                    <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td bgcolor="#4682B4" nowrap class=actTabText> Address Details <img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>                  
                                        
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="65%">&nbsp;</td>
                    
              </tr> 
            <tr height="10"><td class=userText colspan="17"></td></tr>            
            <TR height=10>
       <!-- Detail table Container starts -->
                <TD colspan=17>
                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                    <TBODY>
                      <TR>
                        <TD>
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0>
                          <TBODY>                                
                            <tr height = 3><td></td></tr>                          
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
    <!-- Purchase Requisition Info Table Starts -->
      <TABLE cellSpacing=0 cellPadding=0 >
        <TR>
          <TD class=subHeader colspan=11> Permanent Address</TD>
        </TR>   
        <TR>
          <TD colspan=11 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
        </tr> 
        <tr><td colspan=11>&nbsp;</td></tr>
        <TR height=20>
 <!-- Detail table Container starts -->
                <TD >
                  <TABLE cellSpacing=0 cellPadding=0 border=0 >
                    <TBODY>
                      <TR>
                        <TD >
  			<!-- Detail table starts -->
                        <TABLE cellSpacing=0 cellPadding=0 border=0>
                          <TBODY>                     
                            <TR>       
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermAddLine1" /></td>
                              <td ><html:text  property="txtPermAddL1" titleKey="Payroll.EmpInfo.PermAddLine1" styleClass = "optional" altKey="Payroll.EmpInfo.PermAddLine1" maxlength="100" size="23" onchange="Chk_Char(this.alt,'txtAddL1'); lfnChanged(this.value);" /></td>             
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermAddLine2" /></td>
                              <td ><html:text  property="txtPermAddL2" styleClass = "optional" altKey="Payroll.EmpInfo.PermAddLine2" maxlength="100" size="23" onchange="lfnChanged(this.value);"/></td>             
                          
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermCity" /></td>
                              <td ><html:text  property="txtPermCity" titleKey="Payroll.EmpInfo.PermCity" styleClass = "optional" altKey="Payroll.EmpInfo.PermCity" maxlength="20" size="23" onchange="lfnChanged(this.value);"/></td>                                                                          
                            </tr> 
                    
                            <tr>
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermState" /></td>
                              <td >
                              <html:text  property="txtPermStateDesc" altKey="pay.EmpInfo.PermState" size="23" styleClass="optional"  onchange="lfnChange(this.value);" maxlength="25"  />
                              <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovPermStateCode();">
                              </logic:equal>                                                                    
                              <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="N">                              
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovPermStateCode();">
                              </logic:equal><html:hidden  property="txtPermState" altKey="Payroll.EmpInfo.PermState"  /> 
                              </td>
                               
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermCountry" /></td>
                              <td ><html:text  property="txtPermCountry" titleKey="Payroll.EmpInfo.PermCountry" styleClass = "optional" altKey="Payroll.EmpInfo.PermCountry" maxlength="20" size="23" value="INDIA" onchange="lfnChanged(this.value);"/></td>                                           
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.PermPin" /></td>
                              <td ><html:text  property="txtPermPin" styleClass = "optional" altKey="Payroll.EmpInfo.PermPin" maxlength="6" size="23" onchange="checkMinLength(this.value)" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "  style="text-align:right"   /></td>             
                              
                            </tr>   
                            <tr><td colspan=6>&nbsp;</td></tr>                              
                            <TR>
                              <TD class=subHeader colspan=6> Present Address</TD>
                            </TR>   
                            <TR>
                              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>          
                            </tr>
                            <tr><td colspan=6>&nbsp;</td></tr> 
                            <TR>                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempAddLine1" /></td>
                              <td ><html:text  property="txtTempAddL1" styleClass = "optional" altKey="Payroll.EmpInfo.TempAddLine1" maxlength="100" size="23" onchange="lfnChanged(this.value);"/></td>             
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempAddLine2" /></td>
                              <td ><html:text  property="txtTempAddL2" styleClass = "optional" altKey="Payroll.EmpInfo.TempAddLine2" maxlength="100" size="23" onchange="lfnChanged(this.value);"/></td>             
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempCity" /></td>
                              <td ><html:text  property="txtTempCity" styleClass = "optional" altKey="Payroll.EmpInfo.TempCity" maxlength="20" size="23" onchange="lfnChanged(this.value);"/></td>                                                                         
                            </tr> 
                    
                            <tr>                              
                              
                              <td width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempState" /></td>
                              <td >
                              <html:text  property="txtTempStateDesc" altKey="pay.EmpInfo.TempState" size="23" styleClass="optional"  onchange="lfnChange(this.value);" maxlength="25"  />
                              <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="U">
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovTempStateCode();">
                              </logic:equal>                                                                    
                              <logic:equal property= "screenMode" name= "frmDeptLabourInfoForm" value="N">                              
                              <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtState"  onclick="return ShowLovTempStateCode();">
                              </logic:equal><html:hidden  property="txtTempState" altKey="Payroll.EmpInfo.TempState"  /> 
                              </td>
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempCountry" /></td>
                              <td ><html:text  property="txtTempCountry" styleClass = "optional" altKey="Payroll.EmpInfo.TempCountry" maxlength="20" size="23" value="INDIA" onchange="lfnChanged(this.value);"/></td>                                                                       
                              
                              <td  width="15%" class=labelText><bean:message key="Payroll.EmpInfo.TempPin" /></td>
                              <td ><html:text  property="txtTempPin" styleClass = "optional" altKey="Payroll.EmpInfo.TempPin" maxlength="6" size="23" onchange="checkMinLength(this.value)" onkeypress="
                               if((event.keyCode < 48 || event.keyCode > 57))
                                {
                                  return false;
                                };                            
                                      lfnChanged(this.value);
                                 "  style="text-align:right"   /></td>                                                       
                          </tr>                                                    
                          <tr><td colspan=6>&nbsp;</td> </tr>
                          <tr><td colspan=6>&nbsp;</td> </tr>                          
                          <tr height =1><td></td></tr>                          
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
<html:hidden name="frmDeptLabourInfoForm"  property="screenName" value="MaintDeptLabourDetailScreen" />
<html:hidden name="frmDeptLabourInfoForm"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDeptLabourInfoForm" />
<html:hidden property="positionRequested" name="frmDeptLabourInfoForm" />
<html:hidden property="userPositionRequested" name="frmDeptLabourInfoForm" />
<html:hidden property="buttonFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="lovKey" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtFields" name="frmDeptLabourInfoForm"  />   
<html:hidden property="txtSearchFields" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtDisplayFields" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtIndex" name="frmDeptLabourInfoForm"  />
<html:hidden property="loginLocCode" name="frmDeptLabourInfoForm" />
<html:hidden property="txtInputField" name="frmDeptLabourInfoForm"  />

<html:hidden property="txtPayType" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPayScaleCode" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtCurtBasic" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPayStatus" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPayMode" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPayModeType" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtBankCode" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtBankDesc" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtBranchCode" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtBranchDesc" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtBankAccNo" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPayStsChnDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPerPayHighQual" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtInrSt" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtStagInc" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtStagEffDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSubsAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPanNo" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtLicFeeDEM" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtCityTypeHra" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnStartBasic" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnEndBasic" name="frmDeptLabourInfoForm"  />

<html:hidden property="hdnHraFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnNpaFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnCantFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnWashFlag" name="frmDeptLabourInfoForm"  />   
<html:hidden property="hdnStationCompFlag" name="frmDeptLabourInfoForm"  /> 
<html:hidden property="hdnCCAFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnPLIFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnConvFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnDustOpAllowFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnDepuFlag" name="frmDeptLabourInfoForm"  /> 
<html:hidden property="hdnDblHraFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtDblHraCity" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnAdvIncrFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtAdvIncrType" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtAdvIncrEffDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnSplCmpAllowFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplCmpAllowAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnSplPaySprtFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplPaySprtAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnSplPayCshAllowFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtSplPayCshAllowAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnPersPaySFNFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPersPaySFNAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnPersPayHQuaFlag" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPersPayHQuaAmt" name="frmDeptLabourInfoForm"  />
<html:hidden property="hdnBoardFlag" name="frmDeptLabourInfoForm"  />

<html:hidden property="txtDOB" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtGender" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtMarStat" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtFatherNam" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtHomTwn" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtHandi" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtHandiEffDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtPrvPromDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtRetireDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtHRAStat" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtHRAEffDate" name="frmDeptLabourInfoForm"  />
<html:hidden property="lstAccomType" name="frmDeptLabourInfoForm"  />
<html:hidden property="txtLeaseAmt" name="frmDeptLabourInfoForm"  />

<html:hidden property="txtAddId" name="frmDeptLabourInfoForm"  />

<html:hidden property="txtEmpNo" name="frmDeptLabourInfoForm"  />
<input type="hidden" name="queryParam" />

</html:form>
</body>
</html:html>

<script language="javascript">
function ShowLovPermStateCode()
{
    frmDeptLabourInfoForm.lovKey.value = "DeptLabourStatecode" + frmDeptLabourInfoForm.screenName.value + frmDeptLabourInfoForm.screenMode.value;
    frmDeptLabourInfoForm.txtDisplayFields.value = "txtPermState,txtPermStateDesc";
    frmDeptLabourInfoForm.txtSearchFields.value = "";
    frmDeptLabourInfoForm.txtIndex.value="";
    frmDeptLabourInfoForm.txtInputField.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
    frmDeptLabourInfoForm.headerDataChanged.value = "true";       
    return true;
}

function ShowLovTempStateCode()
{
    frmDeptLabourInfoForm.lovKey.value = "DeptLabourStatecode" + frmDeptLabourInfoForm.screenName.value + frmDeptLabourInfoForm.screenMode.value;
    frmDeptLabourInfoForm.txtDisplayFields.value = "txtTempState,txtTempStateDesc";
    frmDeptLabourInfoForm.txtSearchFields.value = "";
    frmDeptLabourInfoForm.txtIndex.value="";
    frmDeptLabourInfoForm.txtInputField.value =""; 
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
    frmDeptLabourInfoForm.headerDataChanged.value = "true";       
    return true;
} 

function lfnLoad()
{   
    mode = document.all.screenMode.value;     
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode=='U')
    {        
        //document.all.txtCateg.disabled = "true";        
        document.all.headerPrimaryKey.disabled = "true";          
    }
      
    //checkPFType();         
    //checkDepuType();    
    hedMenuHandling(mode);
}

function enableDepuType(val)
{
    if (val=="EMPSTATUS$DEPU")
    {
       document.getElementById("txtDepuType").disabled = "";
       document.getElementById("txtDepuType").style.background="#ffffd3";
       document.getElementById("txtDepuType").style.className="required";           
    }  
    else 
    {
       document.getElementById("txtDepuType").disabled = "true";
       document.getElementById("txtDepuType").value = "";
       document.getElementById("txtDepuType").style.background="#ffffff";
       document.getElementById("txtDepuType").style.className="locked";           
    }  
}

function checkPFType(){  
    if (document.all.txtPFType.value=='PFTYPE$CPF' || document.all.txtPFType.value=='')
    {
        document.getElementById("cpf").style.display='';        
        document.getElementById("gpf").style.display='none';        
        //document.getElementById("vcpf").style.display='';        
        //document.getElementById("vgpf").style.display='none';        
    }
    if (document.all.txtPFType.value=="PFTYPE$GPF")
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';           
        //document.getElementById("vgpf").style.display='';
        //document.getElementById("vcpf").style.display='none';           
    }    
}  

function onChangePFType(val)
{
    if (val=='PFTYPE$GPF')
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';
        document.getElementById("vgpf").style.display='';
        document.getElementById("vcpf").style.display='none';    
    }
    if (val=='PFTYPE$CPF')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';
        document.getElementById("vcpf").style.display='';
        document.getElementById("vgpf").style.display='none';
    } 
}

function checkDepuType()
{
    if (document.all.txtEmpStatus.value=="EMPSTATUS$DEPU")
    {
       document.getElementById("txtDepuType").disabled = "";
       document.getElementById("txtDepuType").style.background="#ffffd3";
       document.getElementById("txtDepuType").style.className="required";           
    }  
    else 
    {
       document.getElementById("txtDepuType").disabled = "true";
       document.getElementById("txtDepuType").value = "";
       document.getElementById("txtDepuType").style.background="#ffffff";
       document.getElementById("txtDepuType").style.className="locked";           
    }  
    
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
    if(mandatory_Check("frmDeptLabourInfoForm"))
    {     
        
        frmDeptLabourInfoForm.detailDataChanged.value = "false";  
        if(frmDeptLabourInfoForm.screenMode.value == "U")
            frmDeptLabourInfoForm.headerDataChanged.value = "true";      
        frmDeptLabourInfoForm.headerFields.value = "true";  
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmDeptLabourInfoForm.action = "../../../DeptLbrAddSaveAction.do";                
        document.all.txtDsgn.disabled = "";              
        
        frmDeptLabourInfoForm.submit();
    }
    else
    {
        return false;
    }
}

function ShowLovEmpType()
{
   frmDeptLabourInfoForm.lovKey.value = "EmpInfoEmpType" + frmDeptLabourInfoForm.screenName.value + frmDeptLabourInfoForm.screenMode.value;
   frmDeptLabourInfoForm.txtDisplayFields.value = "txtEmpType";
   frmDeptLabourInfoForm.txtSearchFields.value = "";
   frmDeptLabourInfoForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
   lfnChanged(1);
   return true;
}

function ShowLovSection()
{
   frmDeptLabourInfoForm.lovKey.value = "EmpInfoSection" + frmDeptLabourInfoForm.screenName.value + frmDeptLabourInfoForm.screenMode.value;
   frmDeptLabourInfoForm.txtDisplayFields.value = "txtSection,txtSectionDesc,txtDivision";   
   frmDeptLabourInfoForm.txtSearchFields.value = "Payroll.EmpInfo.Division";
   frmDeptLabourInfoForm.txtIndex.value =""; 
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
   lfnChanged(1);
   return true;
}

function ShowEmpNum()
{
    frmDeptLabourInfoForm.lovKey.value = "EmpFinInfo" + frmDeptLabourInfoForm.screenName.value + frmDeptLabourInfoForm.screenMode.value; 
    if(frmDeptLabourInfoForm.screenMode.value == 'N')
    {    
        frmDeptLabourInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
        frmDeptLabourInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
        frmDeptLabourInfoForm.txtIndex.value ="";      
    }
    if(frmDeptLabourInfoForm.screenMode.value == 'Q')
    {
        frmDeptLabourInfoForm.txtDisplayFields.value = "headerPrimaryKey,txtEmpName";
        frmDeptLabourInfoForm.txtSearchFields.value = "Payroll.Common.empNo,Payroll.Common.empName";
        frmDeptLabourInfoForm.txtIndex.value ="";      
    }
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
    return true;
}    

function ShowLovStateCode()
{
    frmDeptLabourInfoForm.lovKey.value = "PayrollEmpMastStatecode" + frmDeptLabourInfoForm.screenName.value + "Q";
    frmDeptLabourInfoForm.txtDisplayFields.value = "txtStateCode,txtStateCodeDesc";
    frmDeptLabourInfoForm.txtSearchFields.value = "Pay.proftax.statecode,pr.PayCode.description";
    frmDeptLabourInfoForm.txtIndex.value="";  
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmDeptLabourInfoForm');
    frmDeptLabourInfoForm.headerDataChanged.value = "true";       
    return true;
}

function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../DeptLbrAddressTabAction.do";
    document.forms[0].submit(); 
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmDeptLabourInfoForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
    frmDeptLabourInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    document.all.butExecute.disabled="true";
    document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
    frmDeptLabourInfoForm.action="../../../DeptLbrAddressGetHeaderAction.do"
    frmDeptLabourInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.positionRequested.value + 1;
    frmDeptLabourInfoForm.action="../../../DeptLbrAddressGetNextHeader.do";
    frmDeptLabourInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.positionRequested.value - 1;
    frmDeptLabourInfoForm.action = "../../../DeptLbrAddressGetPrevHeader.do";
    frmDeptLabourInfoForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmDeptLabourInfoForm.userPositionRequested.value = 1*frmDeptLabourInfoForm.newPositionRequested.value;
    frmDeptLabourInfoForm.action = "../../../EmpAddressGetNextHeader.do";
    frmDeptLabourInfoForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmDeptLabourInfoForm.action="../../../DeptLbrFinNewMode.do"
    frmDeptLabourInfoForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmDeptLabourInfoForm.action="../../../DeptLabourQueryMode.do"
    frmDeptLabourInfoForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmDeptLabourInfoForm.action="../../../DeptLbrAddressRefresh.do"
    frmDeptLabourInfoForm.submit();
}

function checkMinLength(str)
{
    if(!(str.length == 6))
    {
        alert("Please Enter 6 Digit Value");
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}
</script>
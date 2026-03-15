<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<html:html>
	<HEAD>
  <html:base/>
		<TITLE><bean:message key="Payroll.title" /></TITLE>
    <jsp:include page = "../INCLUDES/GenIncludes.jsp" />

    <link rel="STYLESHEET" type="text/css" href="../../../COMMON/CSS/Menucss.css">
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_func.js"></script>
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
</head>
<BODY scroll=no onload="lfnLoad();">
 
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintCatVsPaycodeAction" name="frmMaintCatVsPaycode" type="FCIPAY.Payroll.WEBTIER.Form.MaintCatVsPaycodeForm" scope="session">
<bean:define id="ParentForm" name="frmMaintCatVsPaycode" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>
<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<TABLE cellSpacing=0 bgColor=#bdd0ef>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>MAINTAIN CLASSIFICATION VS PAYCODE MAPPING</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
 </TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
    <TR>
      <TD>	
        <!--<div id=divBody>-->
        <!-- Body table Starts -->
        <TABLE cellSpacing=0 cellPadding=0 border=0>
        <!--Account  Header Row Starts -->
          <TR>
            <TD class=subHeader colspan=6>Classifications </TD>
          </TR>
          <TR>
            <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
          </TR>

          <tr height="15" >
            <td colspan="4"></td>
          </tr>
       
          <TR align="center">                            
          <td colspan="4"><b>Classification:</b> <html:select property="txtCategory" name="frmMaintCatVsPaycode"  styleClass="required" alt="<%=String.valueOf(i)%>"   style="WIDTH: 15%"  >
										<html:option value="" >-----------Please Select-----------</html:option> 
											<logic:present name="ClassificationTyp">
									    <html:optionsCollection label="label" value="value" property="classificationTypList" name="ClassificationTyp"/> 		</logic:present>
										</html:select>
            </td>
          </TR>
          
          <tr height="10">	
            <td></td>
          </tr>       
          
      
        <TD colspan="6" > </TD>
      </tr>
   	 </table>
    </div>
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
                    <td bgcolor="#4682B4" nowrap class=actTabText>Pay Codes Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                    <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                    <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                    <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                 </tr> 
                 <TR height=10>
                   <!-- Detail table Container starts -->
                    <TD colspan=11>
                      <TABLE cellSpacing=0 cellPadding=0 border=0 >
                        <TBODY>
                          <TR>
                           <TD >
                            <DIV id=divDtlTable style="height:340px" >
  		                        	<!-- Detail table starts -->
                                    <TABLE cellSpacing=0 cellPadding=0 border = 0 id="Detail" style="padding-left:50">
                                <TBODY>
                                     <TR height="20"  >
								
                                               <TD class=tableHeader width="3%" style="Text-align:left;">Sr. No.</td>

                                              <td class=tableHeader width="5%" style="Text-align:left; "  ><html:checkbox property="selectAll"   onclick="toggleCheckBox('selectAll');checkRecord();"   /></td>
                                              <TD class=tableHeader width="18%" style="Text-align:left;">Paycode</td>
                                                <TD class=tableHeader width="45%" style="Text-align:left;">Paycode Desc</td>
                                               <TD class=tableHeader width="28%" style="Text-align:left;"></td>
                                              
                                      </TR>    
                                                                                 <!--  property="PaycodevsAgency"-->
                          <logic:iterate id="intInfo" name="frmMaintCatVsPaycode"  property="catVsPayCode" type="FCIPAY.Payroll.UTILITY.MaintCatVsPayCodeBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="intInfo" property="status" value="D" >                                
                                   <tr align="left"> 
                                                                                  <TD ><b><%=String.valueOf(i)%></b></td>

                                      <td ><html:checkbox property="checked" name="frmMaintCatVsPaycode" onclick="checkRecord();"  /></td>
                                      
                                      <td ><html:text property="txtPayCode" name="intInfo" styleClass="required" style="width:90%" readonly="true" alt="<%=String.valueOf(i)%>" onchange="changed(this.alt); checkDuplicate(this);"  />
                                      
                                      <logic:equal name="intInfo" property="status" value="N">                                       
                                      <img src="../INCLUDES/IMAGES/lov.jpg" height="15"  alt="<%=idx%>" property="buttxtEmpNo" enabled onclick="ShowPayCode(this.alt);" >
                                      </logic:equal>                                      
                                      
                                                                
                                       
                                      
                                       
                                      <td align="left" >   <html:text property="txtPayCodeDesc" name="intInfo"  styleClass="locked" readonly="true"  style="width:70%" alt="<%=String.valueOf(i)%>" onchange="return changed(this.alt);" /></td> 
                                                                                <TD  ></td>

                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo" />
                                     
										
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="intInfo" property="status" value="D" >
                                   <tr>
                                         <td ><html:hidden property="checked" name="frmMaintCatVsPaycode" value="notchecked" /></td>
                                 
                                         <td ><html:hidden property="txtPayCode" name="intInfo" /></td>
                                         <td ><html:hidden property="txtPayCodeDesc" name="intInfo" /></td>
                                      
                                                                                   <TD ></td>

                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo"  />
                                       
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
<html:hidden property="headerPrimaryKey" name="frmMaintCatVsPaycode"  />

<html:hidden property="screenMode" name="frmMaintCatVsPaycode"  />
<html:hidden name="frmMaintCatVsPaycode"  property="screenName" value="MaintCatVsPayCode" />
<html:hidden name="frmMaintCatVsPaycode"  property="forwardedPage" />

 
<html:hidden property="lovKey" name="frmMaintCatVsPaycode"  />
<html:hidden property="txtFields" name="frmMaintCatVsPaycode"  />
<html:hidden property="txtSearchFields" name="frmMaintCatVsPaycode"  />
<html:hidden property="txtDisplayFields" name="frmMaintCatVsPaycode"  />
<html:hidden property="txtIndex" name="frmMaintCatVsPaycode"  />
<html:hidden property="txtInputField" name="frmMaintCatVsPaycode"  />
<html:hidden property="buttonFlag" name="frmMaintCatVsPaycode"  />
<html:hidden property="userPageRequested" name="frmMaintCatVsPaycode" />
<html:hidden property="pageRequested" name="frmMaintCatVsPaycode" />
<html:hidden property="loginLocCode" name="frmMaintCatVsPaycode" />
<input type="hidden" name="queryParam" />
</html:form>

</html:html>

                        
                        
         


<script language="javascript">
    
function lfnLoad()
{

   var mode = document.all.screenMode.value;
    	
    if(mode=='')
    {

      doQueryMode();


    }    
    if(mode=='Q')
    {
		
      document.all.butGetDetail.disabled="";
      document.all.butInsert.disabled="true";
    }
    if(mode=='U')
    {
      document.all.butGetDetail.disabled="true";
	  document.all.txtCategory.disabled="true";
      document.all.butInsert.disabled="";
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


function changed(i)
{
  frmMaintCatVsPaycode.detailDataChanged.value = "true";
   if (document.getElementsByName("status")[i-1].value == 'Q')
     document.getElementsByName("status")[i-1].value = 'U';
}
function doQueryMode()
{
    document.all.buttonFlag.value='';    
	
    frmMaintCatVsPaycode.action="../../../CatVsPaycodeQueryModeAction.do"
    frmMaintCatVsPaycode.submit();
}

function doRefresh()
{
    frmMaintCatVsPaycode.action="../../../CatVsPaycodeRefreshPageAction.do"
    frmMaintCatVsPaycode.submit();
}

function GetDetail()
{
 if(mandatory_Check("frmMaintCatVsPaycode"))
    {
		  document.all.txtCategory.disabled="";

   frmMaintCatVsPaycode.headerPrimaryKey.value = document.getElementById("txtCategory").value;
   frmMaintCatVsPaycode.screenMode.value='U';    
   frmMaintCatVsPaycode.action="../../../CatVsPaycodeGetDetailAction.do"

   frmMaintCatVsPaycode.submit();
   
}
}
function SaveRecord()
{ 
		  document.all.txtCategory.disabled="";

    if(mandatory_Check("frmMaintCatVsPaycode"))
    {
        //enableAll(); 
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
               frmMaintCatVsPaycode.detailDataChanged.value = "true";
        }    
        document.all.buttonFlag.value='';
       frmMaintCatVsPaycode.headerFields.value = "false";
		document.all.butSave.disabled="true";
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
       frmMaintCatVsPaycode.action = "../../../CatVsPaycodeSaveRecordAction.do";

       frmMaintCatVsPaycode.submit();
    }
    else
    {
        return false;
    }
    
}

function doBaseAddRow()
{
    if(mandatory_Check("frmMaintCatVsPaycode"))
    { 
    
        document.all.buttonFlag.value='';
        frmMaintCatVsPaycode.screenMode.value = "U";  
        document.forms[0].action = "../../../CatVsPaycodeAddRowAction.do";
        //enableAll(); 
        
        document.forms[0].submit();
    }
    else
    {
        return false;
    }
}

function doBaseDelRow()
{
    document.all.buttonFlag.value='';
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
            frmMaintCatVsPaycode.detailDataChanged.value = "true";      
        }
    }    
   // enable(); 
    document.forms[0].action = "../../../CatVsPaycodeDeleteRowAction.do";
    document.forms[0].submit();  
}
function ShowPayCode(i)
{

    frmMaintCatVsPaycode.lovKey.value = "CatVSPayCodeLOVPay" + frmMaintCatVsPaycode.screenName.value + frmMaintCatVsPaycode.screenMode.value;
	frmMaintCatVsPaycode.queryParam.value = "txtCategory="+frmMaintCatVsPaycode.txtCategory.value; // added by swapnendu Dt 07 Sep 2012. 
    frmMaintCatVsPaycode.txtDisplayFields.value = "txtPayCode,txtPayCodeDesc";
    frmMaintCatVsPaycode.txtSearchFields.value = "Payroll.PaycodeVSAgencycode.Paycode,Payroll.PaycodeVSAgencycode.PayDesc";
    frmMaintCatVsPaycode.txtIndex.value =i;      
    frmMaintCatVsPaycode.txtInputField.value ="txtPayCode";      
    showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintCatVsPaycode');
    return true;
}



function doBasePrevDetail()
{
    frmMaintCatVsPaycode.userPageRequested.value = 1*frmMaintCatVsPaycode.pageRequested.value - 1;
    frmMaintCatVsPaycode.action = "../../../CatVsPaycodePrevDtlAction.do";
     frmMaintCatVsPaycode.submit();
}


function doBaseNextDetail()
{
   frmMaintCatVsPaycode.userPageRequested.value = 1*frmMaintCatVsPaycode.pageRequested.value + 1;
    frmMaintCatVsPaycode.action = "../../../CatVsPaycodeNextDtlAction.do";
    frmMaintCatVsPaycode.submit();
}

function JumpDetail()
{
    frmMaintCatVsPaycode.userPageRequested.value = 1*frmMaintCatVsPaycode.newPageRequested.value ;
    frmMaintCatVsPaycode.action = "../../../CatVsPaycodeJumpDtlAction.do";
    frmMaintCatVsPaycode.submit();
}

function checkDuplicate(that)
{

 var oTable = document.getElementById("Detail");
    if(oTable == null)
    {
        return true;
    }
    var iTr2 = oTable.rows.length;
      for(i=0; i < iTr2 -1; i++)
    {    
      if((document.getElementsByName("txtPayCode")[i]!==that) &&(document.getElementsByName("txtPayCode")[i].value==that.value) &&(document.getElementsByName("status")[i].value != 'D') )
        {
             alert('Duplicate values not allowed. Please check row '+(i+1) );   
			 that.value='';
			 var j=that.alt;
			document.getElementsByName("txtPayCodeDesc")[j-1].value='';
			
        }  
    }   
     
}
</script>
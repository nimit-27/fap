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
  <BODY  onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
  <jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
  <html:form  action="MaintDpsLbrSORViewBase" name="frmDpsLbrSORView" type="FCIPAY.Payroll.Labour.WEBTIER.Form.DpsLabourSORViewForm">
  <bean:define id="ParentForm" name="frmDpsLbrSORView" toScope="request" />
  <jsp:include page="../INCLUDES/GenIconMenu.jsp"/>
  <html:errors/>  
  <html:hidden property="headerDataChanged" value="false" />
  <html:hidden property="detailDataChanged" value="false" />
  <html:hidden property="headerFields" value="true" />
  <%! int i=0,j=0; %>  
  <% i = 0;j=0; %>       

  <table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10>DPS LABOUR SOR INFORMATION</TD>
  </TR>
  <tr height="10"><td class=userText colspan="11"></td></tr>
  </TABLE>
<!--container table starts -->
<div id=divDtlTable style="height:540px">
<TABLE cellSpacing=0 cellPadding=0 border=0 >
  <TBODY>
   <TR>
    <TD>
    
       <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->
         <tr>
         
            <td  width="45%" class=labelText><bean:message key="Payroll.Labour.region" /></td>
            <td ><html:text  property="txtRegName" styleClass = "locked" altKey="Payroll.Labour.region" maxlength="100" size="35" onchange=""/>
            <html:hidden  property="headerPrimaryKey" altKey="Payroll.EmpInfo.txtDesig"  />
            </td>  
            
        </tr>
        <tr height=5>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>

 	       <TR height="200">
            <TD colspan=6>

            <!-- Purchase Requisition Info Table Starts -->
             <TABLE cellSpacing=0 cellPadding=0 >
                              <TR>
                                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td bgcolor="#4682B4" nowrap class=actTabText>DPS Labour SOR Detail<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                              </TR> 
                              <TR>
                                <TD colspan=5>
                                  <!--Table 50 starts-->
                                  <TABLE cellSpacing=0 cellPadding=0 border=0>
                                    <TBODY>
                                      <TR>
                                        <TD >   
                                          <DIV id=divDtlTable style="height:200px" >
                                          <!-- Detail table starts -->
                                            <!--Table 60 starts-->
                                            <TABLE cellSpacing=0 cellPadding=0 id="Detail">
                                              <TBODY>
                                                <TR>
                                                  <td class=tableHeader width="20%">Kind of Service/Operation</td>
                                                  <td class=tableHeader width="10%">Previous Rate(Bag Above 65kg)</td>
                                                  <td class=tableHeader width="10%">Previous Rate(Bag Upto 65kg)</td>
                                                  <td class=tableHeader width="10%">Current Rate(Bag Above 65kg)</td>
                                                  <td class=tableHeader width="10%">Current Rate(Bag Upto 65kg)</td>                              
                                                </TR> 
                                                
                                                <logic:iterate id="DpsLbrSORView" name="frmDpsLbrSORView" property="lstInstrDtls" type="FCIPAY.Payroll.Labour.Utility.DpsLabourSORViewBean" indexId="idx">                                                                                            
                                                <% ++i; %>
                                                <logic:notEqual name="DpsLbrSORView" property="status" value="D" >
                                                  <tr>
                                                    <td width="20%"><html:text property="prevOperDesc" name="DpsLbrSORView" style="width:100%;text-align:center" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
                                                    <td width="10%"><html:text property="prevBagRateAbv65" name="DpsLbrSORView" style="width:100%;text-align:center" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
                                                    <td width="10%"><html:text property="prevBagRateBlw65" name="DpsLbrSORView" style="width:100%;text-align:center" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
                                                    <td width="10%"><html:text property="curBagRateAbv65" name="DpsLbrSORView" style="width:100%;text-align:center" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
                                                    <td width="10%"><html:text property="curBagRateBlw65" name="DpsLbrSORView" style="width:100%;text-align:center" readonly="true" alt="<%=String.valueOf(i)%>"/></td>
                                                    
                                                    <html:hidden property="itemChecked" name="DpsLbrSORView"  />
                                                    <html:hidden property="status" name="DpsLbrSORView" />
                                                    <html:hidden property="detailId" name="DpsLbrSORView" value="Default"/>
                                                  </tr> 
                                                  </logic:notEqual>
                                               </logic:iterate>   
                                              </TBODY>
                                            </TABLE>
                                            <!--Table 60 ends-->
                                          </DIV>
                                        </TD>
                                      </TR>                       
                                    </TBODY>
                                  </TABLE> 
                                  <!--Table 50 ends-->
                                </TD>
                              </TR>
                            </TABLE>
                            <!--Table 40 ends-->
                          </td>
                        </TR>                     
          
              <!-- Get details starts -->
                            <tr>
                              <td colspan=11>	
                                <TABLE border=0>
                                  <TBODY>
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
            <td colspan=11>
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
<html:hidden name="frmDpsLbrSORView"  property="screenName" value="MaintDpsLbrSORView" />
<html:hidden name="frmDpsLbrSORView"  property="forwardedPage" />
<html:hidden property="screenMode" name="frmDpsLbrSORView" />
<html:hidden property="positionRequested" name="frmDpsLbrSORView" />
<html:hidden property="userPositionRequested" name="frmDpsLbrSORView"/>
<html:hidden property="pageRequested" name="frmDpsLbrSORView" />
<html:hidden property="userPageRequested" name="frmDpsLbrSORView"/>
<html:hidden property="totalDetailRecord" name="frmDpsLbrSORView"  />
<html:hidden property="screenModeSOR" name="frmDpsLbrSORView"  />
<html:hidden property="screenModeSOR1" name="frmDpsLbrSORView"  />
<html:hidden property="screenModeSOR2" name="frmDpsLbrSORView"  />

<html:hidden property="buttonFlag" name="frmDpsLbrSORView"  />
<html:hidden property="lovKey" name="frmDpsLbrSORView"  />
<html:hidden property="txtFields" name="frmDpsLbrSORView"  />   
<html:hidden property="txtSearchFields" name="frmDpsLbrSORView"  />
<html:hidden property="txtDisplayFields" name="frmDpsLbrSORView" />
<html:hidden property="txtIndex" name="frmDpsLbrSORView"  />
<html:hidden property="loginLocCode" name="frmDpsLbrSORView" />
<html:hidden property="txtRegCode" name="frmDpsLbrSORView" />
<html:hidden property="effStartDate" name="frmDpsLbrSORView" />                                         

<input type="hidden" name="queryParam" />
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
    if (frmDpsLbrSORView.screenMode.value == "Q")
    {
        frmDpsLbrSORView.screenModeSOR.value="Q";
        document.all.butGetDetail.disabled="disabled";  
        document.all.butInsert.disabled="true";
    }
        
    mode = frmDpsLbrSORView.screenModeSOR.value;   
    if(mode=='')
   {
     document.all.butGetDetail.disabled="disabled";   
     document.all.butInsert.disabled="disabled";
     document.all.butDelete.disabled="disabled";
   }
    if(mode=='Q' && document.all.screenMode.value=='U')
    {
       document.all.butGetDetail.disabled="";
       document.all.butInsert.disabled="disabled";
       document.all.butDelete.disabled="disabled";     
    } 
    
    if(mode=='UG' && document.all.screenMode.value=='U')
    {
       document.all.butGetDetail.disabled="true";
       document.all.butInsert.disabled="true";
       document.all.butDelete.disabled="true";     
    } 
  document.getElementById("headerPrimaryKey").disabled="";       
    
  mode1 = document.all.screenMode.value;  
  menuHandlingCus(mode1, mode);      
    
}

function menuHandlingCus(mode, modeSor)
{
  if(document.all.buttonFlag.value!='D')    
    document.all.buttonFlag.value='ND';  
  if(mode=='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
   /*   document.all.butPrint.disabled="true";    
      document.all.butPrint.src="../INCLUDES/IMAGES/print_dis.jpg";  */  
      document.all.butRefresh.disabled="true";    
      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg";     
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
      document.all.newPositionRequested.disabled="true";    
  }
  if(mode=='U')
  {
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg"; 
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
//      document.all.butRefresh.disabled="true";    
//      document.all.butRefresh.src="../INCLUDES/IMAGES/refresh_dis.jpg"; 
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true";    
  }
  if(mode=='U')
  {
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";        
  }
  if(document.all.buttonFlag.value=='D')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";  
  }
  
  document.all.butDelete.disabled="true";
}

function getHeaderRecord()
{
	document.all.buttonFlag.value='';
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmDpsLbrSORView.action="../../../DpsLbrSORGetViewAction.do"
	frmDpsLbrSORView.submit();
}

function doQueryMode()
{   
    frmDpsLbrSORView.headerPrimaryKey.value="";
    document.all.buttonFlag.value='';
    document.all.screenModeSOR.value = "Q";
    document.all.screenMode.value = "Q";    
    frmDpsLbrSORView.action="../../../DpsLbrSORViewQryMode.do"
    frmDpsLbrSORView.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmDpsLbrSORView.action="../../../DpsLbrSORViewRefresh.do"
    frmDpsLbrSORView.submit();
}

function GetDetail()
{
    document.all.buttonFlag.value='';      
    document.all.screenModeSOR.value='UG';
    frmDpsLbrSORView.action="../../../DpsLbrSORViewDetailAction.do"
    frmDpsLbrSORView.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmDpsLbrSORView.userPageRequested.value = 1*frmDpsLbrSORView.newPageRequested.value ;
    frmDpsLbrSORView.action = "../../../DpsLbrSORViewNextDetailAction.do";
    frmDpsLbrSORView.submit();
}  
</script>


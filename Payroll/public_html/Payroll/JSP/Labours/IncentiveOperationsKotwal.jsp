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
<!--<BODY scroll=no onload="lfnLoad();">-->
<BODY scroll=yes  onload="lfnLoad(); history.forward(1);" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false"></BODY>
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />
<%! int i=0,j=0 ;%>
<% i = 0; j=0; %>


<html:form  action="MaintIncentiveOperationsKot" name="frmIncentiveOperationsKot" type="FCIPAY.Payroll.Labour.WEBTIER.Form.MaintIncentiveOperationsKotForm" scope="session">
<bean:define id="ParentForm" name="frmIncentiveOperationsKot" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>  
<html:hidden property="detailDataChanged"  />
<html:hidden property="headerFields" value="false" />

<table>
  <TR height=30>
    <TD  colSpan=11 class=mainHeader height=10> LABOUR INCENTIVE OPERATIONS</TD>
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
                 <!-- <TD class=tableHeader width="1%"><html:checkbox property="selectAll" onclick="toggleCheckBox('selectAll');checkRecord();" /></TD>
                    <!--<td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>-->
                    <td bgcolor="#4682B4" nowrap class=actTabText>Labour Incentive Operations<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
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
                                            
                                              <TD class=tableHeader width="30%">Description</td>
                                              <TD class=tableHeader width="11%">Datum Flag</TD>                                              
                                              <TD class=tableHeader width="11%">Rate</td>
                                              <TD class=tableHeader width="11%">Unit</td>
                                              
                                      </TR>   
                                      
                                                                                                           <!--  property="categorylocationmap" -->
                          <logic:iterate id="intInfo" name="frmIncentiveOperationsKot"  property="incentiveoperationskotwal" type="FCIPAY.Payroll.Labour.Utility.MaintIncentiveOperationsKotBean" indexId="idx" >
                              <% ++i; %>
                                <logic:notEqual name="intInfo" property="status" value="D" >                                
                                   <tr>
                                      <td ><html:checkbox property="checked" name="frmIncentiveOperationsKot" onclick="checkRecord();"  /></td>
                                      
                                    
                           
                                     <html:hidden property="txtOperationID" name="intInfo" />
                                       
                                    
                                    
                              <td > <html:text property="txtOperationDesc" name="intInfo"  styleClass="required"  size="30" style="width:95%" alt="<%=String.valueOf(i)%>"  /></td>  
                                     
                                       
                                           
                                       <td colspan="1"><html:select property="txtDatumFlag" name="intInfo"  styleClass="required" alt="<%=String.valueOf(i)%>"  style="WIDTH: 90%" onchange = "DatumValidate(this.alt);" >                                           
                                         
                                              
                                             <html:option value="" >  <bean:message key="Payroll.pleaseSelect" /></html:option>      
                                             <html:option value="Y" > <bean:message key="Pay.Paycode.Yes" /></html:option>
                                             <html:option value="N" > <bean:message key="Pay.Paycode.No" /></html:option>
                                             </html:select>
                                      </td>                     
                                      
                                      <td >   <html:text property="txtRate" name="intInfo"  styleClass="optional" readonly="false" size="30" style="width:80%" alt="<%=String.valueOf(i)%>" onkeypress="if((event.keyCode < 48 && event.keyCode !=46 || event.keyCode > 57))return false;" /> </td>
                                      <td colspan="1"><html:select property="txtUnit" name="intInfo"  styleClass="required" alt="<%=String.valueOf(i)%>"  style="WIDTH: 90%"  >
                                              
                                         <html:option value="" ><bean:message   key="Payroll.pleaseSelect" /></html:option>    
                                         <html:option value="KOTOPRUNIT$PERGANG" > Per Gang   </html:option>
                                         <html:option value="KOTOPRUNIT$PERWRKR" > Per Labour</html:option>
                                         </html:select>
                                      </td>      
                               
                                       
                                       <html:hidden property="itemChecked" name="intInfo" />
                                       <html:hidden property="status" name="intInfo" />
                                       <html:hidden property="detailId" name="intInfo" />
                                    </tr>
                                  </logic:notEqual>

                                  <logic:equal name="intInfo" property="status" value="D" >
                                   <tr>
                                       <td ><html:hidden property="checked" name="frmIncentiveOperationsKot" value="notchecked" /></td>
                                      
                                      <td ><html:hidden property="txtOperationID" name="intInfo" /></td>
                                       <td ><html:hidden property="txtOperationDesc" name="intInfo" /></td>
                                  
                                       <td ><html:hidden property="txtDatumFlag" name="intInfo" /></td>                                       
                                       <td ><html:hidden property="txtRate" name="intInfo" /></td>
                                       <td ><html:hidden property="txtUnit" name="intInfo" /></td>
                                     
                                       
                                       
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
                  </TBODY>
              </TABLE>
            <!-- Container Table Ends-->
<html:hidden property="headerPrimaryKey" name="frmIncentiveOperationsKot"  />

<html:hidden property="screenMode" name="frmIncentiveOperationsKot"  />
<html:hidden name="frmIncentiveOperationsKot"  property="screenName" value="MaintIncentiveOperationsMap" />
<html:hidden name="frmIncentiveOperationsKot"  property="forwardedPage" />


<html:hidden property="lovKey" name="frmIncentiveOperationsKot"  />
<html:hidden property="txtFields" name="frmIncentiveOperationsKot"  />
<html:hidden property="txtSearchFields" name="frmIncentiveOperationsKot"  />
<html:hidden property="txtDisplayFields" name="frmIncentiveOperationsKot"  />
<html:hidden property="txtIndex" name="frmIncentiveOperationsKot"  />
<html:hidden property="txtInputField" name="frmIncentiveOperationsKot"  />
<html:hidden property="buttonFlag" name="frmIncentiveOperationsKot"  />
<html:hidden property="userPageRequested" name="frmIncentiveOperationsKot" />
<html:hidden property="pageRequested" name="frmIncentiveOperationsKot" />
<html:hidden property="loginLocCode" name="frmIncentiveOperationsKot" />
<input type="hidden" name="queryParam" />
                                      
</html:form>
</body>
</html:html>

<script language="javascript">
function lfnLoad()
{
    Newfunction();
   var mode = document.all.screenMode.value;
    
   //alert("mode------"+mode); 
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
function doQueryMode()
{
    document.all.buttonFlag.value='';    
    frmIncentiveOperationsKot.action="../../../OperationsKotQueryMode.do"
   frmIncentiveOperationsKot.submit();
}

function doRefresh()
{
    frmIncentiveOperationsKot.action="../../../OperationsKotRefresh.do"
   frmIncentiveOperationsKot.submit();
}

function GetDetail()
{
    Newfunction();
   frmIncentiveOperationsKot.screenMode.value='U';    
   frmIncentiveOperationsKot.action="../../../OperationsKotGetDetailAction.do"
   frmIncentiveOperationsKot.submit();
}

function SaveRecord()
{ 
  
 
 if(mandatory_Check("frmIncentiveOperationsKot"))
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
           frmIncentiveOperationsKot.detailDataChanged.value = "true";
           document.getElementsByName("txtRate")[i].disabled="";
           document.getElementsByName("txtRate")[i].disabled="";
           //document.getElementsByName("txtLeadFlag")[i].disabled="";
           document.getElementsByName("txtUnit")[i].disabled=""; 
        }    
       document.all.buttonFlag.value='';
       
       frmIncentiveOperationsKot.headerFields.value = "false";
       
       if(!Virtual_Mandatory())
        return false;
       
       document.all.butSave.disabled="true";
       document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
  	   frmIncentiveOperationsKot.action = "../../../OperationsKotSaveAction.do";
       frmIncentiveOperationsKot.submit();
    }
    else
    {
        return false;
    }
 
}
function doBaseAddRow()
{
     Newfunction();
    if(mandatory_Check("frmIncentiveOperationsKot"))
    {
        document.all.buttonFlag.value='';
     frmIncentiveOperationsKot.screenMode.value = "U";  
        document.forms[0].action = "../../../OperationsKotAddRowAction.do";
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
    Newfunction();
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
           frmIncentiveOperationsKot.detailDataChanged.value = "true";      
        }
    }    
   // enable(); 
    document.forms[0].action = "../../../OperationsKotDeleteRowAction.do";
    document.forms[0].submit();  
}

function doBasePrevDetail()
{
    frmIncentiveOperationsKot.userPageRequested.value = 1*frmIncentiveOperationsKot.pageRequested.value - 1;
   frmIncentiveOperationsKot.action = "../../../OperationsKotPrevAction.do";
    frmIncentiveOperationsKot.submit();
}


function doBaseNextDetail()
{
  frmIncentiveOperationsKot.userPageRequested.value = 1*frmIncentiveOperationsKot.pageRequested.value + 1;
    frmIncentiveOperationsKot.action = "../../../OperationsKotNextAction.do";
   frmIncentiveOperationsKot.submit();
}

function JumpDetail()
{
    frmIncentiveOperationsKot.userPageRequested.value = 1*frmIncentiveOperationsKot.newPageRequested.value ;
    frmIncentiveOperationsKot.action = "../../../OperationsKotJumpAction.do";
  frmIncentiveOperationsKot.submit();
}

 function changed(i)
{
if(document.getElementsByName("txtDatumFlag")[i-1].value== 'N')
  {
    document.getElementsByName("txtRate")[i-1].disabled="";
    //document.getElementsByName("txtLeadFlag")[i-1].disabled="true";
    document.getElementsByName("txtRate")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtRate")[i-1].style.className="required";
  }
  
else 
  {
    document.getElementsByName("txtRate")[i-1].disabled="true";
    document.getElementsByName("txtRate")[i-1].style.background="#ffffff";
  }


}

function Newfunction()
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
            document.getElementsByName("txtOperationDesc")[i].disabled="";
            document.getElementsByName("txtDatumFlag")[i].disabled="";
            //document.getElementsByName("txtLeadFlag")[i].disabled="";
            document.getElementsByName("txtRate")[i].disabled="";
        }
}

function Validate()
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
          if(document.getElementsByName("txtDatumFlag")[i].value == 'N')
          {
            if(document.getElementsByName("txtRate")[i].value =="")
            {
             alert ("Mandatory field is empty");
              return false;
            }
            
          } 
          else
          alert("SAVE");
          return true;
          
        }
         alert("SAVE NEW");
}

function DatumValidate(i)
{
  if(document.getElementsByName("txtDatumFlag")[i-1].value == "Y")
  {
    document.getElementsByName("txtRate")[i-1].disabled="true";    
    
    document.getElementsByName("txtRate")[i-1].style.background="#ffffff";    
  }
  else if(document.getElementsByName("txtDatumFlag")[i-1].value == "N")
  {
   
    document.getElementsByName("txtRate")[i-1].disabled="";
    document.getElementsByName("txtRate")[i-1].style.background="#ffffd3";
    document.getElementsByName("txtRate")[i-1].style.className="required";
    
  }
  else
  {
    return false;
  }
}

function Virtual_Mandatory()
{
  
   var oTable = document.getElementById("Detail");
        if(oTable == null)
        {
            return;
        }
        var iTr2 = oTable.rows.length;
        var i = 0;       
        // alert("length is "+iTr2);
        for(i=0; i < iTr2 -1; i++)
          {
             document.getElementsByName("txtRate")[i].disabled="";
             document.getElementsByName("txtRate")[i].disabled="";
             //document.getElementsByName("txtLeadFlag")[i].disabled="";
             
            
            if((document.getElementsByName("txtDatumFlag")[i].value == "N") && (document.getElementsByName("txtRate")[i].value == '' ||   document.getElementsByName("txtUnit")[i].value ==''))
                {
                  alert("Mandatory field is empty ");
                   return false;
                }
          }    
          return true;
}
</script>
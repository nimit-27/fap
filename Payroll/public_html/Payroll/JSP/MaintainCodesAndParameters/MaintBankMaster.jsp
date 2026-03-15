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
    <script language="JavaScript1.2" src="../INCLUDES/payrollToolBar.js"></script>    
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/validate.js"></script>
    <script language="JavaScript1.2" src="../../../COMMON/JavaScript/Menu_addins.js"></script>
   
</head>
<BODY scroll=yes onload="lfnLoad();" onbeforeunload="confWindowClose()" onunload="handleOnClose()" oncontextmenu="return false">
<jsp:include page="../../../COMMON/JSP/menu.jsp" flush="true" />

<html:form  action="MaintBankMastBase" name="frmMaintBankMast" type="FCIPAY.Payroll.WEBTIER.Form.MaintBankMastForm" scope="session">
<bean:define id="ParentForm" name="frmMaintBankMast" toScope="request" />
<jsp:include page = "../INCLUDES/GenIconMenu.jsp" />
<html:errors/>

<html:hidden property="detailDataChanged" value="false" />
<html:hidden property="headerDataChanged" value="false" />
<html:hidden property="headerFields" value="false" />
<%! int i=0,j=0; %>
<% i = 0;j=0; %>

<table>
<TR height=30>
  <TD  colSpan=12 class=mainHeader height=10>MAINTAIN BANK DETAILS</TD>
</TR>
</TABLE>
<!--container table starts -->
<TABLE cellSpacing=0 cellPadding=0 border=0 >
<TBODY>
  <TR>
    <TD>
	
       
       <!-- Body table Starts -->
       <TABLE cellSpacing=0 cellPadding=0  border = 0>
       <!--Account  Header Row Starts -->
       <TR>
          <TD class=subHeader colspan=6>Header For Bank Details</TD>
        </TR>
        <TR>
              <TD colspan=6 bgColor=#4682b4><IMG height=1 src="../INCLUDES/IMAGES/pixel.gif" width=1 border=0></TD>
	      </TR>

         <tr height="15" >
            <td ></td>
         </tr>
         
        <tr>

                     <TD colspan = 2 class=labelText width="15%" ><bean:message key="pay.MaintBankMast.txtBankName" /></td>
                     <td width="25%"><html:text  property="txtBankCode" readonly="true" altKey="pay.MaintBankMast.txtBankCode" maxlength="5" size="23" styleClass="required"  onchange="upper(this);" />

                     <logic:equal property= "screenMode" name= "frmMaintBankMast" value="Q">
                         <img src="../INCLUDES/IMAGES/lov.jpg" height="16" align="center" name="buttxtRevYYMM"  onclick="showBankLov();">                 
                     </logic:equal>                                      
                      </td>

             </tr>
       
       <tr height="10">		    
        <TD > </TD>
      </tr>
   	 </table>
    
  <table cellspacing=0 cellpadding=0 border=0>
         <!-- Detail Information Row starts -->

 	 <TR height="200">
            <TD colspan=2 >

            <!-- Account Config Detail Table Starts -->
           <TABLE cellspacing="0" cellPadding="0" >
              <TR>
                <td bgcolor="#4682B4" width="10"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td bgcolor="#4682B4" nowrap class=actTabText>Branch Details<img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
                <td><img src="../INCLUDES/IMAGES/formtab_r.gif" width="10" height="21" border="0"></td>
                <td background="../INCLUDES/IMAGES/line_t.gif" width="100%">&nbsp;</td>
                <td background="../INCLUDES/IMAGES/line_t.gif"><img src="../INCLUDES/IMAGES/pixel.gif" width="10" height="1" border="0"></td>
           </TR>
          
              <TR height=10>
                
		<!-- Detail table Container starts -->
                <TD colspan="11">
                  <TABLE cellSpacing="0" cellPadding="0" border="0">
                    <TBODY>
                    <TR>
                      <TD >
                        <DIV id=divDtlTable style="height:320px">
  			<!-- Detail table starts -->
                        <TABLE cellSpacing="0" cellPadding="0" id="Detail">
                          <TBODY>

                          <TR>
                            <td class=tableHeader width="1%"><html:checkbox property="selectAll"    /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintBankMast.BranchCode" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintBankMast.BranchName" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintBankMast.Address1" /></TD>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintBankMast.Address2" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintBankMast.Address3" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintBankMast.City" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintBankMast.State" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintBankMast.PinCode" /></td>
                            <TD class=tableHeader width="5%"><bean:message  key="Payroll.MaintBankMast.MicrNO" /></td>                                    
                          </TR>
                       
                          <logic:iterate id="bankDtl" name="frmMaintBankMast" property="lstInstrDtls" type="FCIPAY.Payroll.UTILITY.MaintBankMasterBean" >
                              <% ++i; %>
                                <logic:notEqual name="bankDtl" property="status" value="D" >                                                        
                          
                           <tr>  <% ++j; %>
                              <td  width="1%" align="center"><html:checkbox property="checked" disabled="true" onclick="checkRecord();" /></td>
                              <td  width="5%" ><html:text property="txtBranchCode" name="bankDtl" readonly="true" styleClass="required" style="width:100%;text-align:left" maxlength="5" onchange="upper(this);lfnChange(this.value,this.alt);"  /></td>
                              <td  width="5%" ><html:text property="txtBranchName" styleClass="required" readonly="true"  name="bankDtl" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="lfnChange(this.value,this.alt);" /></td>
                              <td  width="5%" ><html:text property="txtAddress1" styleClass="optional" readonly="true"  name="bankDtl" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="lfnChange(this.value,this.alt);"  /></td>
                              <td  width="5%" ><html:text property="txtAddress2" name="bankDtl" styleClass="optional" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="lfnChange(this.value,this.alt);"  /></td>
                              <td  width="5%" ><html:text property="txtAddress3" name="bankDtl" styleClass="optional" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  onchange=""  /></td>
                              <td  width="5%" ><html:text property="txtCity" name="bankDtl" styleClass="optional" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  onchange=""  /></td>
                              <td  width="5%" ><html:text property="txtState" name="bankDtl" styleClass="optional" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  onchange=""  /></td>
                              <td  width="5%" ><html:text property="txtPinCode" name="bankDtl" styleClass="optional" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="lfnChange(this.value,this.alt);"  /></td>
                              <td  width="5%" ><html:text property="txtMicrNO" name="bankDtl" styleClass="optional" readonly="true" style="width:100%;text-align:left"  alt="<%=String.valueOf(i)%>"  maxlength="50" onchange="lfnChange(this.value,this.alt);"  /></td>                                       
                              <html:hidden property="itemChecked" name="bankDtl" />
                              <html:hidden property="status" name="bankDtl"/>
                              <html:hidden property="detailId" name="bankDtl" />
                          </tr>  
                        </logic:notEqual>
                        <logic:equal name="bankDtl" property="status" value="D" >
                           <tr>
                              <td  width="1%" ><html:hidden property="checked" value="notchecked" /></td>
                              <td  width="5%" ><html:hidden property="txtBranchCode" name="bankDtl" /></td>
                              <td  width="5%" ><html:hidden property="txtBranchName" name="bankDtl"  /></td>
                              <td  width="5%" ><html:hidden property="txtAddress1" name="bankDtl"  /></td>
                              <td  width="5%" ><html:hidden property="txtAddress2" name="bankDtl"  /></td>
                              <td  width="5%" ><html:hidden property="txtAddress3" name="bankDtl"  /></td>
                              <td  width="5%" ><html:hidden property="txtPinCode" name="bankDtl"  /></td>
                              <td  width="5%" ><html:hidden property="txtMicrNO" name="bankDtl"  /></td>                                                    
                              <html:hidden property="itemChecked" name="bankDtl" />
                              <html:hidden property="status" name="bankDtl"/>
                              <html:hidden property="detailId" name="bankDtl" />
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
<html:hidden property="totalDetailRecord" name="frmMaintBankMast" />
<html:hidden property="headerPrimaryKey" name="frmMaintBankMast" />
<html:hidden property="screenMode" name="frmMaintBankMast" />
<html:hidden property="screenModePay1" name="frmMaintBankMast" />
<html:hidden name="frmMaintBankMast"  property="screenName" value="BankDtlScreen" />
<html:hidden name="frmMaintBankMast"  property="forwardedPage" />
<html:hidden property="positionRequested" name="frmMaintBankMast" />
<html:hidden property="userPositionRequested" name="frmMaintBankMast" />
<html:hidden property="pageRequested" name="frmMaintBankMast" />
<html:hidden property="userPageRequested" name="frmMaintBankMast" />
<html:hidden property="flag" name="frmMaintBankMast" />
<html:hidden property="hdnBankDesc" name="frmMaintBankMast" />


<html:hidden property="lovKey" name="frmMaintBankMast"  />
<html:hidden property="txtFields" name="frmMaintBankMast"  />   
<html:hidden property="txtSearchFields" name="frmMaintBankMast"  />
<html:hidden property="txtDisplayFields" name="frmMaintBankMast"  />
<html:hidden property="txtIndex" name="frmMaintBankMast"  />
<html:hidden property="buttonFlag" name="frmMaintBankMast"  />

</html:form>
</body>
</html:html>

<script language="javascript">

function lfnLoad()
{
      mode = document.all.screenMode.value;
      var  mode1;
      mode1 = mode;
      if (mode == 'UG')
       mode1 = 'U';
      
      if(mode == '')
      {
          doQueryMode();
      }
      flag = document.all.flag.value;
      if(mode=='U')
      {
          document.all.txtBankCode.disabled="true";
          if(flag == 'true')
          {
            document.all.butGetDetail.disabled="true";
            document.all.butInsert.disabled="true";
            document.all.butDelete.disabled="true";
          }
          else
          {
            document.all.butGetDetail.disabled="";
            document.all.butInsert.disabled="true";
            document.all.butDelete.disabled="true";
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
                  document.getElementsByName("txtBranchCode")[i].disabled="disabled";
                  document.getElementsByName("txtBranchName")[i].disabled="disabled";
                  document.getElementsByName("txtAddress1")[i].disabled="disabled";
                  document.getElementsByName("txtAddress2")[i].disabled="disabled";
                  document.getElementsByName("txtAddress3")[i].disabled="disabled";
                  document.getElementsByName("txtPinCode")[i].disabled="disabled";
                  document.getElementsByName("txtMicrNO")[i].disabled="disabled";
                  document.getElementsByName("txtCity")[i].disabled="disabled";
                  document.getElementsByName("txtState")[i].disabled="disabled";
                }
           } 

      }
          
      if(mode=='N')
      {
          document.all.butGetDetail.disabled="true";
      }
      if(mode=='Q')
      {
         // document.all.butGetDetail.disabled="true";
      }

    if (frmMaintBankMast.screenModePay1.value=="N") 
      {
        frmMaintBankMast.screenMode.value ="N";
      }
      
      document.all.butInsert.disabled="true";
      document.all.butDelete.disabled="true";      
      document.all.butExecute.disabled="true"; 
      document.all.butInsertMode.disabled="true";
      menuHandling(mode);
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      
}

function menuHandling(mode)
{
  if(mode=='' || mode =='Q')
  {
      document.all.butQueryMode.disabled="true";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query_dis.jpg";    
      document.all.butSave.disabled="true";    
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    

      document.all.butnGo.disabled="true";    
  }
  else
  {
      document.all.butQueryMode.disabled="";    
      document.all.butQueryMode.src="../INCLUDES/IMAGES/query.jpg";    
      document.all.butSave.disabled="";    
      document.all.butSave.src="../INCLUDES/IMAGES/save.jpg";    
      document.all.butDel.disabled="true";    
      document.all.butDel.src="../INCLUDES/IMAGES/delete_dis.jpg";    
      document.all.butPrevHeader.disabled="true";    
      document.all.butPrevHeader.src="../INCLUDES/IMAGES/butn_prev_dis.jpg";    
      document.all.butNextHeader.disabled="true";    
      document.all.butNextHeader.src="../INCLUDES/IMAGES/butn_next_dis.jpg";    
      document.all.butnGo.disabled="true"; 
      document.all.butInsertMode.disabled="true";    
      document.all.butInsertMode.src="../INCLUDES/IMAGES/insert_dis.jpg";    
      document.all.butExecute.disabled="true";    
      document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";    

  }
 

}

function doRefresh()
{
  frmMaintBankMast.action="../../../bankDtlRefresh.do"
  frmMaintBankMast.submit();
}


 function lfnChange(val,ind)
{
      frmMaintBankMast.detailDataChanged.value = "true";
      if ((ind-1) > 0)
      {
        if (document.getElementsByName("status")[ind-1].value == "Q")
           document.getElementsByName("status")[ind-1].value = "U";
      }
}

function getHeaderRecord()
{
	document.all.buttonFlag.value='';
	frmMaintBankMast.flag.value = "false";
	document.all.butExecute.disabled="true";
	document.all.butExecute.src="../INCLUDES/IMAGES/execute_dis.jpg";
	frmMaintBankMast.action="../../../bankDtlFirstGetHeaderAction.do"
	frmMaintBankMast.submit();
}

function doGetNextHeader()
{
    document.all.buttonFlag.value='';
    frmMaintBankMast.flag.value = "false";
    frmMaintBankMast.userPositionRequested.value = 1*frmMaintBankMast.positionRequested.value + 1;
    frmMaintBankMast.action="../../../bankDtlGetNextHeader.do";
    frmMaintBankMast.submit();
}


function PrevHeader()
{
  document.all.buttonFlag.value='';
  frmMaintBankMast.flag.value = "false";
  frmMaintBankMast.userPositionRequested.value = 1*frmMaintBankMast.positionRequested.value - 1;
  frmMaintBankMast.action = "../../../bankDtlGetNextHeader.do";
  frmMaintBankMast.submit();
}


function JumpHeader()
{
  document.all.buttonFlag.value='';
  frmMaintBankMast.flag.value = "false";
  frmMaintBankMast.userPositionRequested.value = 1*frmMaintBankMast.newPositionRequested.value;
  frmMaintBankMast.action = "../../../bankDtlGetNextHeader.do";
  frmMaintBankMast.submit();
}

function doBasePrevDetail()
{
    document.all.buttonFlag.value='';
    frmMaintBankMast.userPageRequested.value = 1*frmMaintBankMast.pageRequested.value - 1;
    frmMaintBankMast.action = "../../../bankDtlNextDetailAction.do";
    frmMaintBankMast.submit();
}

function doBaseNextDetail()
{ 
    document.all.buttonFlag.value='';
    frmMaintBankMast.userPageRequested.value = 1*frmMaintBankMast.pageRequested.value + 1;
    frmMaintBankMast.action = "../../../bankDtlNextDetailAction.do";
    frmMaintBankMast.submit();
}

function JumpDetail()
{
    document.all.buttonFlag.value='';
    frmMaintBankMast.userPageRequested.value = 1*frmMaintBankMast.newPageRequested.value ;
    frmMaintBankMast.action = "../../../bankDtlNextDetailAction.do";
    frmMaintBankMast.submit();
}

function doBaseAddRow()
{
  if(mandatory_Check("frmMaintBankMast"))
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
          document.getElementsByName("checked")[i].disabled = "";
      }

  
    document.all.buttonFlag.value='D';
    EnableFields();
    frmMaintBankMast.headerDataChanged.value = "false";      
    document.forms[0].action = "../../../bankDtlAddRowAction.do";
    document.forms[0].submit();
  }
  else
  {
    return false;
  }
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


  for(i=0; i < iTr2 -1; i++)
  {
      document.getElementsByName("checked")[i].disabled = "";

    if(document.getElementsByName("checked")[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
      frmMaintBankMast.detailDataChanged.value = "true";    
      document.all.buttonFlag.value='D';  
    }

  }
   
  EnableFields();
  document.forms[0].action = "../../../bankDtlDeleteRowAction.do";
  document.forms[0].submit();  
}

function SaveRecord()
{
  if(mandatory_Check("frmMaintBankMast"))
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
          document.getElementsByName("checked")[i].disabled = "";
          if (document.getElementsByName("status")[i].value == 'D')
            frmMaintBankMast.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'N')
            frmMaintBankMast.detailDataChanged.value = "true";
          if (document.getElementsByName("status")[i].value == 'U')
            frmMaintBankMast.detailDataChanged.value = "true";
      }

      document.all.screenModePay1.value = document.all.screenMode.value;     
      if(frmMaintBankMast.screenMode.value == "N")
      {
      frmMaintBankMast.headerDataChanged.value = "true"; 
      frmMaintBankMast.detailDataChanged.value = "true";
      }
       if(frmMaintBankMast.screenMode.value == "U")
       {
      frmMaintBankMast.headerDataChanged.value = "true"; 
      }  
  
      frmMaintBankMast.headerFields.value = "true";
      frmMaintBankMast.screenMode.value ="U";                    

      frmMaintBankMast.headerPrimaryKey.value = "##";
      frmMaintBankMast.headerFields.value = "true";
      frmMaintBankMast.totalDetailRecord.value = parseInt(iTr2)-1;       
      frmMaintBankMast.buttonFlag.value='';
      EnableFields();
      document.all.butSave.disabled="true";
      document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
      frmMaintBankMast.action = "../../../bankDtlSaveAction.do";
      frmMaintBankMast.submit();
  }
  else
  {
    return false;
  }
}


function GetDetail()
{
if(mandatory_Check("frmMaintBankMast"))
{
  document.all.buttonFlag.value='';
  document.all.screenMode.value='U';
  frmMaintBankMast.headerPrimaryKey.value = "##";
  frmMaintBankMast.flag.value = "true";
  frmMaintBankMast.action="../../../bankDtlFirstGetDetailAction.do"
  frmMaintBankMast.submit();
}
}

function doInsertMode()
{
  document.all.buttonFlag.value='';
  frmMaintBankMast.screenModePay1.value='N';  
  frmMaintBankMast.action="../../../bankDtlNewMode.do"
  frmMaintBankMast.submit();
}


function doQueryMode()
{
  document.all.buttonFlag.value='';
  frmMaintBankMast.action="../../../bankDtlQueryMode.do"
  frmMaintBankMast.submit();
}

function showBankLov()
{
   frmMaintBankMast.lovKey.value = "BankMast" + frmMaintBankMast.screenName.value + frmMaintBankMast.screenMode.value;
   frmMaintBankMast.txtDisplayFields.value = "txtBankCode";
   frmMaintBankMast.txtSearchFields.value = "Payroll.Common.desc";     
   frmMaintBankMast.txtIndex.value ="";      
   showLov('<html:rewrite page="/Payroll/JSP/COMMON/JSP/CommonSearchScreen.jsp" />', 'frmMaintBankMast');
   return true;
}

function changed()
{
  frmMaintBankMast.headerDataChanged.value = "true";  
}

function upper(val)
{
   val.value=val.value.toUpperCase();
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
              document.getElementsByName("txtBranchCode")[i].disabled="";
       }
}



</script> 
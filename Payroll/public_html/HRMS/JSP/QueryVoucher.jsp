<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html locale="true">
<head>
<link rel="stylesheet" HREF='<html:rewrite page="/COMMON/CSS/IBA.css" />'>
<title>Query Voucher</title>
</head>
<html:errors />
<style>
#div3 {
	overflow: auto;
	left: 22.5%;
	top: 150px;
	width: 100%;
	height:300px;
}
</style>
<script>
function performOnLoad() {
   var queryString="";
   var doc_ref="";
   var doc_rem="";
   var po="";
   var wo="";
   var slcode="";
   var part="";
   var flg=0;
   var vouchno="";
   if((QueryVoucher.txtSubmitFirst.value!=opener.document.all.item("txtOpeningTime").value) || QueryVoucher.txtSubmitFirst.value=="") {
      if(opener.document.all.item("txtHidVouchType").value!="")
//         queryString=" A.VOUCHER_TYPE_GBL='" + opener.document.all.item("txtHidVouchType").value + "' AND A.TXN_STATUS_GBL='VHSTAT$1' AND A.CREATED_USER=? AND A.LOC_ID=? AND A.MODULE_ID=opener.document.all.item('txtModuleId').value)  AND (";     Query Modified to get all voucher types
        // queryString=" A.VOUCHER_TYPE_GBL='" + opener.document.all.item("txtHidVouchType").value + "' AND A.CREATED_USER=? AND A.LOC_ID=? AND A.MODULE_ID = " + opener.document.all.item('txtModuleId').value + " )  AND (";         
    //added for taking care of  Query Feature in Loans Payment Advice Screen (Allowing 2 module ids)
         queryString=" A.VOUCHER_TYPE_GBL='" + opener.document.all.item("txtHidVouchType").value + "' AND A.CREATED_USER=? AND A.LOC_ID=? AND (A.MODULE_ID = " + opener.document.all.item('txtModuleId').value + " ))  AND (";         
      if(opener.document.all.item("txtVouchNo").value!="") {
         vouchno=opener.document.all.item("txtVouchNo").value;
         queryString=queryString + " A.VOUCHER_NO='" + vouchno.toUpperCase() + "'";
         flg=1;
      }
        
//      alert("1="+flg);
      if(opener.document.all.item("txtVouchDate").value!="") {
         if(flg==1) {
            queryString=queryString + " OR TRUNC(A.VOUCHER_DT)=to_date('" + opener.document.all.item("txtVouchDate").value + "','DD/MM/YYYY')";
         }
         else {
            queryString=queryString + " TRUNC(A.VOUCHER_DT)=to_date('" + opener.document.all.item("txtVouchDate").value + "','DD/MM/YYYY')";            
            flg=1;
         }            
      }
//      alert("2="+flg);      
      if(opener.document.all.item("txtDocRef").value!="") {
         doc_ref=new String(opener.document.all.item("txtDocRef").value);
         if(flg==1)
            queryString=queryString + "  OR  lower(A.DOC_REF) LIKE '%" + doc_ref.toLowerCase()  + "%'";      
         else {
            queryString=queryString + " lower(A.DOC_REF) LIKE '%" + doc_ref.toLowerCase() + "%'";      
            flg=1;         
         }
      }
//      alert("3="+flg);      
      if(opener.document.all.item("txtRemarks").value!="") {
         doc_rem=new String(opener.document.all.item("txtRemarks").value);
         if(flg==1)
            queryString=queryString + "  OR  lower(A.DOC_REM) LIKE  '%" + doc_rem.toLowerCase()  + "%'";
         else {
            queryString=queryString + " lower(A.DOC_REM) LIKE  '%" + doc_rem.toLowerCase() + "%'";
            flg=1;
         } 
      }
//      alert("4="+flg);
      if(opener.document.all.item("txtPartMast").value!="") {
         part=new String(opener.document.all.item("txtPartMast").value);
         if(flg==1)
            queryString=queryString + "  OR  lower(B.DTL_NRTN) LIKE  '%" + part.toLowerCase() + "%'";
         else {
            queryString=queryString + " lower(B.DTL_NRTN) LIKE  '%" + part.toLowerCase() + "%'";
            flg=1;
         }
      }
 //     alert("5="+flg);
      if(opener.document.all.item("txtAcctIdMast").value!="") {
         if(flg==1)
            queryString=queryString + "  OR  B.ACCT_ID=" + opener.document.all.item("txtAcctIdMast").value;
         else {
            queryString=queryString + " B.ACCT_ID=" + opener.document.all.item("txtAcctIdMast").value;
            flg=1;
         }
      }
 //     alert("6="+flg);      
      if((opener.document.all.item("txtVouchType").value!="CJV") && (opener.document.all.item("txtVouchType").value!="IAV") && (opener.document.all.item("txtVouchType").value!="CPV")) {
         if(opener.document.all.item("txtPwoIndMast").value=="WO") {
            if(flg==1) {                
               if(opener.document.all.item("txtOrderNoMast").value!="") {
                 wo=new String(opener.document.all.item("txtOrderNoMast").value);
                  queryString=queryString + "  OR B.WO_ID IN (SELECT WO_ID FROM FIN_WO_MST_HDR WHERE lower(WO_NO) LIKE '%" + wo.toLowerCase() + "%')";
               } 
            }
            else {
               if(opener.document.all.item("txtOrderNoMast").value!="") {
                  wo=new String(opener.document.all.item("txtOrderNoMast").value);
                  queryString=queryString + " B.WO_ID IN (SELECT WO_ID FROM FIN_WO_MST_HDR WHERE lower(WO_NO) LIKE '%" + wo.toLowerCase() + "%')";         
                   flg=1;
               } 
            }
         }
         else if(opener.document.all.item("txtPwoIndMast").value=="PO") {
            if(flg==1) {
               if(opener.document.all.item("txtOrderNoMast").value!="") {
                  po=new String(opener.document.all.item("txtOrderNoMast").value);
                  queryString=queryString + "  OR B.PO_ID IN (SELECT PO_ID FROM CMM_PO_MST_F WHERE lower(PO_NO) LIKE '%" + po.toLowerCase() + "%')";
               } 
            }
            else {
               if(opener.document.all.item("txtOrderNoMast").value!="") {
                  po=new String(opener.document.all.item("txtOrderNoMast").value);
                  queryString=queryString + " B.PO_ID IN (SELECT PO_ID FROM CMM_PO_MST_F WHERE lower(PO_NO) LIKE '%" + po.toLowerCase() + "%')";         
                   flg=1;
               } 
            }
         }
      }
      //alert("7="+flg);      
      //alert(queryString);
      if((opener.document.all.item("txtVouchType").value!="CJV")) {
      //alert(opener.document.all.item("txtVouchType").value);
         if((opener.document.all.item("txtVouchType").value!="IAV") && (opener.document.all.item("txtVouchType").value!="CPV")) {
             if(opener.document.all.item("txtSlTypeMast").value=="VENCAT$CR" || opener.document.all.item("txtSlTypeMast").value=="VENCAT$DR") {
                if(flg==1) {
                   if(opener.document.all.item("txtSlCodeMast").value!="") {
                      slcode=new String(opener.document.all.item("txtSlCodeMast").value);
                      queryString=queryString + "  OR B.VEN_ID IN (SELECT VEN_ID FROM COM_VEN_MST WHERE lower(VEN_CODE) LIKE '%" + slcode.toLowerCase() + "%')";
                   } 
                }
                else {
                   if(opener.document.all.item("txtSlCodeMast").value!="") {
                      slcode=new String(opener.document.all.item("txtSlCodeMast").value);
                      queryString=queryString + " B.VEN_ID IN (SELECT VEN_ID FROM COM_VEN_MST WHERE lower(VEN_CODE) LIKE '%" + slcode.toLowerCase() + "%')";         
                       flg=1;
                   } 
                }
             } 
         }
         if((opener.document.all.item("txtVouchType").value=="IAV") || (opener.document.all.item("txtVouchType").value=="CPV")) {
               if(flg==1) {
                   if(opener.document.all.item("txtSlCodeMast").value!="")
                      queryString=queryString + "  OR B.EMP_NO LIKE '%" + opener.document.all.item("txtSlCodeMast").value + "%'";
                }
                else {
                   if(opener.document.all.item("txtSlCodeMast").value!="") {
                     queryString=queryString + " B.EMP_NO LIKE '%" + opener.document.all.item("txtSlCodeMast").value + "%'";         
                     flg=1;
                   } 
                }
         }
         else {
             if(opener.document.all.item("txtSlTypeMast").value=="EMPL") {
                if(flg==1) {
                   if(opener.document.all.item("txtSlCodeMast").value!="")
                      queryString=queryString + "  OR B.EMP_NO LIKE '%" + opener.document.all.item("txtSlCodeMast").value + "%'";
                }
                else {
                   if(opener.document.all.item("txtSlCodeMast").value!="") {
                      queryString=queryString + " B.EMP_NO LIKE '%" + opener.document.all.item("txtSlCodeMast").value + "%'";         
                       flg=1;
                   } 
                }
             }

         }
      }
      //alert("8="+flg);      
      //alert(queryString);
      if(opener.document.all.item("txtChCodeMast")!=null) {
          if(opener.document.all.item("txtChCodeMast").value!="") {
                 if(flg==1)
                    queryString=queryString + "  OR  (B.CH_ID LIKE '%" + opener.document.all.item("txtChCodeMast").value + "%')";
                 else {
                    queryString=queryString + " (B.CH_ID LIKE '%" + opener.document.all.item("txtChCodeMast").value + "%')";         
                    flg=1;
                 }
          }
      }
   //   alert("8="+flg);      
      if((opener.document.all.item("txtVouchType").value!="CJV")) {      
         if(opener.document.all.item("txtCcCodeMast").value!="") {
            if(flg==1)
               queryString=queryString + "  OR B.CCSGRP_ID IN (SELECT CCSGRP_ID FROM COM_CCSGRP_MST WHERE CCSGRP_CODE=" + opener.document.all.item("txtCcCodeMast").value + ")";         
            else {
               queryString=queryString + " B.CCSGRP_ID IN (SELECT CCSGRP_ID FROM COM_CCSGRP_MST WHERE CCSGRP_CODE=" + opener.document.all.item("txtCcCodeMast").value + ")";         
               flg=1;
            }
         }
      }
      if(opener.document.all.item("txtVouchType").value=="BPV" &&  opener.document.all.item("txtHidVouchType").value=="VOUCHTYPE$BRV" && opener.document.all.item("txtHidVouchType").value=="VOUCHTYPE$CRV" && opener.document.all.item("txtVouchType").value=="CPV") {      
         if(opener.document.all.item("txtUSICodeMast")!=null) {
             if(opener.document.all.item("txtUSICodeMast").value!="") {
                if(flg==1)
                   queryString=queryString + "  OR  B.USI_CODE IN(SELECT USI_ID FROM CMM_USI_MST WHERE USI_ID LIKE '%" + opener.document.all.item("txtUSICodeMast").value + "%')";         
                else {
                   queryString=queryString + " B.USI_CODE IN(SELECT USI_ID FROM CMM_USI_MST WHERE USI_ID LIKE '%" + opener.document.all.item("txtUSICodeMast").value + "%')";         
                   flg=1;
                }
             }
         }
      }
 //     alert("9="+flg);      
      if(opener.document.all.item("txtVouchType").value!="CJV" && opener.document.all.item("txtVouchType").value!="BPV" &&  opener.document.all.item("txtHidVouchType").value!="VOUCHTYPE$BRV" && opener.document.all.item("txtHidVouchType").value!="VOUCHTYPE$CRV" && opener.document.all.item("txtVouchType").value!="CPV") {      
         if(opener.document.all.item("txtLinkMast").value!="") {
            txtLink=opener.document.all.item("txtLinkMast").value;
            if(flg==1)
               queryString=queryString + "  OR  lower(B.LINK_REF) LIKE '%" + txtLink.toLowerCase() + "%'";         
            else {
               queryString=queryString + " lower(B.LINK_REF) LIKE '%" + txtLink.toLowerCase() + "%'";         
               flg=1;
            }
         }
      }
  //    alert("10="+flg);     
      if(opener.document.all.item("txtVouchType").value!="VOUCHTYPE$BRV" && opener.document.all.item("txtVouchType").value!="VOUCHTYPE$CRV") {      
          if(opener.document.all.item("txtDrMast").value!="") {
             if(flg==1)
                queryString=queryString + "  OR  (B.TXN_AMT =" + opener.document.all.item("txtDrMast").value + " AND B.DB_CR_FLG='D')";
             else {
                queryString=queryString + " (B.TXN_AMT =" + opener.document.all.item("txtDrMast").value + " AND B.DB_CR_FLG='D')";         
                flg=1;
             }
          }
      }
//      alert("11="+flg);

    //removed for correctionn of ltc advance voucher screen
   /*  if(opener.document.all.item("txtModuleId").value== 71) {      
          if(opener.document.all.item("txtDrMast").value!="") {
             if(flg==1)
                queryString=queryString + "  OR  (B.TXN_AMT =" + opener.document.all.item("txtDrMast").value + " AND B.DB_CR_FLG='D')";
             else {
                queryString=queryString + " (B.TXN_AMT =" + opener.document.all.item("txtDrMast").value + " AND B.DB_CR_FLG='D')";         
                flg=1;
             }
          }
      }*/
      
     // if(opener.document.all.item("txtModuleId").value!= 71) {  ----------removed for correctionn of ltc advance voucher screen
     
          if(opener.document.all.item("txtVouchType").value!="BPV" && opener.document.all.item("txtVouchType").value!="CPV") { 
              if(opener.document.all.item("txtCrMast").value!="") {
                 if(flg==1)
                    queryString=queryString + "  OR  (B.TXN_AMT =" + opener.document.all.item("txtCrMast").value + " AND B.DB_CR_FLG='C')";      
                 else {
                    queryString=queryString + " (B.TXN_AMT =" + opener.document.all.item("txtCrMast").value + " AND B.DB_CR_FLG='C')";
                    flg=1;
                 }
              }
          }
          
    //}          --------removed for correctionn of ltc advance voucher screen
 //     alert("queryString");      
      queryString=queryString + ") AND A.VOUCHER_ID=B.VOUCHER_ID";
      QueryVoucher.txtTransStatus.value=queryString;      
      QueryVoucher.txtSubmitFirst.value=opener.document.all.item("txtOpeningTime").value;
      QueryVoucher.txtHidAction.value="SearchQuery";
      QueryVoucher.txtHidSelectedValue.value="";
      //alert(queryString);
      QueryVoucher.submit();
   }
}
function setSelectedValues(Val) {
    if(document.getElementsByName("txtVhStat")[Val].value!="VHSTAT$1") {
        alert("Voucher cannot be selected for editing");
        document.getElementsByName("selRadio")[Val].checked=false;
    }
    else
        QueryVoucher.txtHidSelectedValue.value=Val;
}
function TransferValues() {
//alert(QueryVoucher.txtHidSelectedValue.value);
   if(QueryVoucher.txtHidSelectedValue.value=="") {
//      alert("null");
      if(confirm("No Voucher Selected, Close?")==true)
          opener.document.all.item("txtHidVoucherId").value="";
      else
          return;  
   }
   else {
//      alert("notnull");
      opener.document.all.item("txtVouchNo").value=document.getElementsByName("txtHidVoucherNo")[QueryVoucher.txtHidSelectedValue.value].value; 
      opener.document.all.item("txtHidVoucherId").value=document.getElementsByName("txtVoucherId")[QueryVoucher.txtHidSelectedValue.value].value; 
      opener.document.all.item("txtVouchNo").focus();
   }
//   alert(opener.document.all.item("txtHidVoucherId").value);
   QueryVoucher.txtSubmitFirst.value=opener.document.all.item("txtOpeningTime").value;
   QueryVoucher.txtSMS.value="Submit";
   QueryVoucher.txtHidAction.value="ClearValues";
   QueryVoucher.submit();
   // Added This part for submitting the parent page
   if(opener.document.all.item("txtModuleId").value== 1)  {
        if(opener.document.all.item("txtVouchNo").value!="") {
            self.close();
            opener.document.all.item("butGetValues").click();
        }
    }
    else
       self.close();
}
</script>
<body onload="performOnLoad();">
<html:form action="/QueryVoucherMap" name="QueryVoucher" type="FCIPAY.HRMS.WEBTIER.Form.QueryVoucherForm" method="post"  >
<center><b class="MainHeader" >Query Voucher</b></center>
<!-- bean Definition   -->  
<bean:define id="lstSearchResult" name="QueryVoucher" property="lstSearchResult" />

<!-- Hidden Fields -->     
<html:hidden property="txtHidAction" />
<html:hidden property="txtHidSelectedValue" />
<html:hidden property="txtHidTotRows" />
<html:hidden property="txtSubmitFirst" />

<!-- Hidden Fields For Child Field -->
<html:hidden property="txtHidVouchType" />
<html:hidden property="txtTransStatus" />  
<html:hidden property="txtSMS"  /> 

<%! int i=0; %> 

<logic:equal name="QueryVoucher" property="txtSMS" value="Submit">
   <table cellspacing="0"  cellpadding="0"  width="100%"  bgcolor="white"   border="0" >
      <tbody>
         <tr>
            <td width="20%" align="center" class="labelText" ><center><strong><font color="red" >Initializing The Form... Please Wait</font></strong></center></td>
         </tr>
      </tbody>
   </table>
</logic:equal>

<logic:equal name="QueryVoucher" property="txtHidTotRows" value="0">
<table width="100%">
<center><td align="center" ><strong><font color="red" >No Rows Found Please Redefine Your Search</font></strong></td></center>
</table>
</logic:equal>

<logic:greaterThan name="QueryVoucher" property="txtHidTotRows" value="0" >
<table width="100%">
<center><td align="center" ><strong><font color="red" ><bean:write name="QueryVoucher" property="txtHidTotRows" /> Rows Found</font></strong></td></center>
</table>
</logic:greaterThan>

<logic:greaterThan name="QueryVoucher" property="txtHidTotRows" value="0" >
<table width="100%" border="1" id="tableId" BGCOLOR="#d9ecff" cellpadding="0" cellspacing="0">
   <tr>
      <td width="6%" align="center">Select</td>
      <td width="10%" align="center" class="labelText"><b><center>Voucher No</center></b></td>
      <td width="10%" align="center" class="labelText"><b><center>Voucher Date</center></b></td>
      <td width="15%" align="center" class="labelText"><b><center>Document Reference</center></b></td>
      <td width="15%" align="center" class="labelText"><b><center>Document Remarks</center></b></td>
      <td width="20%" align="center" class="labelText"><b><center>Voucher Status</center></b></td>
      <td width="20%" align="center" class="labelText"><b><center>Auth Comment</center></b></td>
      <td width="20%" align="center" class="labelText"><b><center>View</center></b></td>
   </tr>
</table>
<div id="div3"  class="div3" >
<table width="100%" border="1" id="tableId" BGCOLOR="#d9ecff" cellpadding="0" cellspacing="0">
  <logic:iterate name="QueryVoucher" property="lstSearchResult" id="Index">
  
    <logic:notEqual name="Index" property="txtVhStat" value="VHSTAT$1" >    
        <table width="100%" border="1" id="tableId" BGCOLOR="#d9ecff" cellpadding="0" cellspacing="0">
    </logic:notEqual>
    <logic:equal name="Index" property="txtVhStat" value="VHSTAT$1" >
        <table width="100%" border="1" id="tableId" BGCOLOR="#d9eeaa" cellpadding="0" cellspacing="0">
    </logic:equal>
    
     <tr>
         <html:hidden name="Index" property="txtVhStat" />
         <html:hidden name="Index" property="txtVoucherId"  />
         <html:hidden name="Index" property="txtHidVoucherNo"  />
          <td width="6%" align="center">
            <html:radio property="selRadio"   onclick="setSelectedValues(this.value)"  value="<%=String.valueOf(i)%>" />
          </td>
          <td width="10%" align="center" class="labelText">
            <bean:write property="txtVoucherNo" name="Index" />
          </td>
          <td width="10%" align="center" class="labelText">
            <bean:write property="txtVoucherDate" name="Index" />
          </td>      
          <td width="15%" align="center" class="labelText" >
            <bean:write property="txtDocRef" name="Index"  />&nbsp;
          </td>      
          <td width="15%" align="center" class="labelText" >
            <bean:write property="txtDocRem" name="Index" />&nbsp;
          </td>  
          <td width="20%" align="center" class="labelText">
            <logic:equal name="Index" property="txtVhStat" value="VHSTAT$1" >
                Pending for changes
            </logic:equal>
            <logic:equal name="Index" property="txtVhStat" value="VHSTAT$2" >
                Pending for approval
            </logic:equal>
            <logic:equal name="Index" property="txtVhStat" value="VHSTAT$3" >
                Pending for payment/receipt
            </logic:equal>
            <logic:equal name="Index" property="txtVhStat" value="VHSTAT$4" >
                Release of cheque pending
            </logic:equal>
            <logic:equal name="Index" property="txtVhStat" value="VHSTAT$5" >
                Pending for posting
            </logic:equal>
            <logic:equal name="Index" property="txtVhStat" value="VHSTAT$6" >
                Posted voucher
            </logic:equal>
            <logic:equal name="Index" property="txtVhStat" value="VHSTAT$7" >
                Cancelled voucher
            </logic:equal>            
          </td>
          <td width="20%" align="center" class="labelText" >
            <bean:write property="txtAuthCmnt" name="Index" />&nbsp;
          </td>
          <td width="4%" align="center" class="labelText">
            <html:button accesskey="S" property="butView" value="..." styleClass="butto" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';" title="<%=String.valueOf(i++)%>" onclick="openWindow(this.title);" />              
          </td>
     </tr>
    </table>
    
   </logic:iterate>
</table>
</div>

<table width="100%">
<center><td align="center" ><html:button accesskey="S" property="butSave" onclick="TransferValues();"  value="Select" styleClass="butto" onmouseover="this.style.color='yellow';" onmouseout="this.style.color='white';"/> </td></center>
</table>
</logic:greaterThan>

<% i=0; %>

</html:form>
</body>
</html:html>

<script>
function openWindow(Id) {
    url="<html:rewrite page='/PrintVoucherMap.do?Id=' />" + document.getElementsByName("txtVoucherId")[Id].value;
    window.open(url,"PrintVoucher","menubar=no,toolbar=no,resizable=yes,scrollbars=yes");
}
</script>

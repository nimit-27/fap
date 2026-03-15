<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html locale="true">
    <head><html:base />
        <script language="javascript"  src='<html:rewrite page="/COMMON/JavaScript/validate.js" />' ></script>
        <script language="JavaScript1.2"  src='<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />'  ></script>
        <script language="JavaScript1.2"  src='<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />' ></script>
        <script language="JavaScript"  src='<html:rewrite page="/COMMON/JavaScript/calendar1.js" />' ></script>
        <link rel="STYLESHEET"  type="text/css"  href='<html:rewrite page="/COMMON/CSS/Menucss.css" />' >
        <link rel ="STYLESHEET" href ='<html:rewrite page="/COMMON/CSS/IBA.css" />' >
        <TITLE>HomePage</TITLE>
      <style type="text/css">  
       .tblbg{ width: 100%;height: 30px; text-align: center;
               background-color:#0080c0; 
               background-position: center; 
               color: White;
               font-family:tahoma, arial,helvetica; font-size:12px; font-weight:normal;
              
        }
        .rowodd{
            height: 30px;text-align: left; font-family: 'Courier New', Courier, monospace; font-size: 11px;font-style: normal;
            font-weight: normal;
            background-color: #D7FDDC;
        }
        .roweven{
            height: 30px;text-align: left; font-family: 'Courier New', Courier, monospace; font-size: 11px;font-style: normal;
            font-weight: normal;
            background-color: #E1E1E1;
        }
        .colborder{
            border-bottom: 1pt solid #FFFFFF;
            border-right: 1pt solid #FFFFFF ;
        }
        .colborder1{
            border-bottom: 1pt solid #FFFFFF;
            border-left: 1pt solid #FFFFFF;
            border-right: 1pt solid #FFFFFF;
        }
        .hdrcolborder{
            border-right: 1pt solid #FFFFFF;
        }
      </style>
        
    </HEAD>

    <BODY onload="chkReport(); history.forward(1);" topmargin="0" bgcolor="#d9ecff" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <html:form name="frmHomePage" method="post" action="/homepage" type="FCIPAY.COMMON.WEBTIER.Form.HomePageForm">
        <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />

            <html:hidden property="hdnReportURL" />
            <html:hidden property="hdnAction" />
            <br><br><br><br><br><br><br><br><br><br>
            <TABLE bgcolor="" align="center">
            <TR>
                <TD>
                    <center> 
                        <font color="#000000" face="courier"   ><h2><b>Payroll Management System </b></h2></font> 
                    </center>
                </TD>
            </TR>
            </TABLE>
            <TABLE bgcolor="" align="center" width="100%">
            <!--TR>
                <TD>
                    <center> 
                        <font color="#000000" face="courier"  size="3" ><b>Use Menu to Navigate to different Screens</b></font> 
                    </center>
                </TD>
            </TR-->
            <!--   Added By Swati  -->
            <TR>
                <TD align="center">
                    <b>Dashboard</b>
                </TD>
            </TR>
            <TR>
                <TD align=right>
                    <html:button value='Refresh' property="butRefresh" onclick="getDashboardAjax();" />
                    
                </TD>
                
            </TR>
            </table>
            <TABLE border='0' align="center" id='dtable' width="100%" cellspacing="0" cellpadding="2">
            <TR class=tblbg>
               <TD class=hdrcolborder>Sl no</TD>
               <TD class=hdrcolborder>Request Id</TD>
               <TD class=hdrcolborder> Process</TD>
               <TD class=hdrcolborder> Process Status  </TD>
               <TD class=hdrcolborder> Undo Status  </TD>
               <TD class=hdrcolborder> Message </TD> 
               <TD class=hdrcolborder>Request Submission Date  </TD>
               <TD class=hdrcolborder> Actual Start Date </TD>
               <TD> Actual Completion Date </TD> 
           </TR>
            </TABLE>

            </TR>
            <!--    End By Swati   -->
            </TABLE>
            <br><br><br>
        </html:form>         
    </body>
</html:html>

<script>
function chkReport()
{
    <% String i=(String) session.getAttribute("ReportElementNo"); %>;
    var temp=<%=i%>;
    //alert("Temp is=" + temp + " Action Value=" + frmHomePage.hdnAction.value);
    if((temp!=null)&&(frmHomePage.hdnAction.value==""))
    {
        //alert("Temp Value is " + temp);
        frmHomePage.hdnAction.value="Load";
        frmHomePage.hdnReportURL.value=temp;
        frmHomePage.submit();
/*      var URL=GetReportURL(0);
        window.open(URL);*/
    }
    if(frmHomePage.hdnAction.value=="Loaded")
    {
        //frmHomePage.hdnAction.value="";
        //alert("URL is " + frmHomePage.hdnReportURL.value);
        window.open(frmHomePage.hdnReportURL.value);
        frmHomePage.hdnAction.value="Reset";
        frmHomePage.submit();
    }
}
function getDashboardAjax()
{
    document.getElementById("butRefresh").disabled="true";
    document.getElementById("butRefresh").value="Please wait..";
    var rowlen=document.getElementById("dtable").rows.length;
    if(rowlen>1)
    {
        for(k=rowlen; k>1; k--)
        {
            document.getElementById("dtable").deleteRow(k-1);
        }
    }
    url="../../getDashboardAjax.do";
    prm="mode=1"
    xml=getXML(url,prm);
    Tags=xml.getElementsByTagName("record");
    Tags1=xml.getElementsByTagName("locid");
    
    if(Tags.length>0)
    {
        var tab= document.getElementById("dtable");
        var cols=Tags1.length/ Tags.length;
        for(i=0; i<Tags.length; i++)
        {
            var row= tab.insertRow(i+1);
            if(i%2==0){
                row.className='roweven';
            }else {
                row.className='rowodd';
            }
            var cell = row.insertCell();
            cell.className='colborder1';
            cell.innerHTML=i+1;
            for(j=0;j<cols;j++)
            {
                var cell = row.insertCell();
                cell.className='colborder';
                cell.innerHTML= Tags[i].childNodes[j].childNodes[0].nodeValue;
            }
        }
    }
    document.getElementById("butRefresh").disabled="";
    document.getElementById("butRefresh").value="Refresh";
}

</script>
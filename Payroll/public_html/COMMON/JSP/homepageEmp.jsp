<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>

<html:html locale="true">
    <head><html:base />
    <bean:define name="USERINFO" id="UserInfo"/>
        <script>
            function chkReport()
            {
                <% String i=(String) session.getAttribute("ReportElementNo"); %>;
                var temp=<%=i%>;
//                alert("Temp is=" + temp + " Action Value=" + frmHomePageEmp.hdnAction.value);
                if((temp!=null)&&(frmHomePageEmp.hdnAction.value==""))
                {
//                    alert("Temp Value is " + temp);
                    frmHomePageEmp.hdnAction.value="Load";
                    frmHomePageEmp.hdnReportURL.value=temp;
                    frmHomePageEmp.submit();
            /*      var URL=GetReportURL(0);
                    window.open(URL);*/
                }
               // alert("sdf,jdf");
                if(frmHomePageEmp.hdnAction.value=="Loaded")
                {
                    //frmHomePageEmp.hdnAction.value="";
                    //alert("URL is " + frmHomePageEmp.hdnReportURL.value);
                   // var url=frmHomePageEmp.hdnReportURL.value + "&paramform=no&EMP_NO="+ <bean:write property="LEmployeeNo" name="UserInfo"/>+"&LOC_ID="+ <bean:write property="LLocationCode" name="UserInfo"/>;
                   url=frmHomePageEmp.hdnReportURL.value;
                   alert(url);
                  var win_option="width=900,height=620,left=50,top=50,modal=yes,"+"toolbar=yes,location=no,directories=no,status=no,menubar=yes,"+"scrollbars=yes,resizable=yes";
                    window.open(url,'',win_option);
                    frmHomePageEmp.hdnAction.value="Reset";
                    frmHomePageEmp.submit();
                }
            }
        </script>
        <script language="javascript"  src='<html:rewrite page="/COMMON/JavaScript/validate.js" />' ></script>
        <script language="JavaScript1.2"  src='<html:rewrite page="/COMMON/JavaScript/Menu_func.js" />'  ></script>
        <script language="JavaScript1.2"  src='<html:rewrite page="/COMMON/JavaScript/Menu_addins.js" />' ></script>
        <script language="JavaScript"  src='<html:rewrite page="/COMMON/JavaScript/calendar1.js" />' ></script>
        <link rel="STYLESHEET"  type="text/css"  href='<html:rewrite page="/COMMON/CSS/Menucss.css" />' >
        <link rel ="STYLESHEET" href ='<html:rewrite page="/COMMON/CSS/IBA.css" />' >
        <TITLE>HomePageEmp</TITLE>
        
    </HEAD>

    <BODY onload="chkReport(); history.forward(1);" topmargin="0" bgcolor="#d9ecff" onbeforeunload="confWindowClose()" onunload="handleOnClose1()" oncontextmenu="return false">
        <html:form name="frmHomePageEmp" method="post" action="/homepageemp" type="FCIPAY.COMMON.WEBTIER.Form.HomePageForm">
        <jsp:include page="../../COMMON/JSP/menu.jsp" flush="true" />
            
            <html:hidden property="hdnReportURL" />
            <html:hidden property="hdnAction" />
            <br><br><br><br><br><br><br><br><br><br>
            <TABLE bgcolor="" align="center">
            <TR>
                <TD>
                    <center> 
                        <font color="#000000" face="courier"   ><h2><b>Integrated Business Application </b></h2></font> 
                    </center>
                </TD>
            </TR>
            </TABLE>
            <TABLE bgcolor="" align="center">
            <TR>
                <TD>
                    <center> 
                        <font color="#000000" face="courier"  size="3" ><b>Use Menu to Navigate to different Screens</b></font> 
                    </center>
                </TD>
            </TR>
            </TABLE>
            <br><br><br>
        </html:form>         
    </body>
</html:html>


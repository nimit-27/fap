function PopIt(label, msg)
{
 
  var s1 = 
    "<TITLE>Information!</TITLE>" +
    "<BODY BGCOLOR='ffffff'><TABLE BORDER=0><TR>" +
        "<TD WIDTH=90% HEIGHT=90 VALIGN=TOP ALIGN=LEFT>"+
        "<FONT SIZE=4>"
  

  var s2 = "<FONT COLOR='FF0000'><B>"+label+"</B></FONT><P>"
 

  var s3 =   
    "</TD><TD WIDTH=10%> </TD></TR><TR><TD> </TD>"+
    "<TD VALIGN=TOP ALIGN=RIGHT>"+
    "<FORM><INPUT TYPE='BUTTON' VALUE='Okay'" +
                   "onClick='self.close()'>"  +
    "</FORM></TD></TR></TABLE></BODY>"

 
  popup = window.open("","popDialog","height=160,width=300,scrollbars=no resize=no")
  popup.document.write(s1+s2+msg+s3)
  popup.document.close()
}


function popHelp()
{
  PopIt('PopIt', 'This function allows you to '  +
                 'create a popup window.')
}



// FUNCTION FOR TR PRINTING
function popHelp1(fname)
{
	popup=window.open(fname,"popDialog1",'height=500,width=670,scrollbars=yes,resize=yes');
	popup.document.close();
}


// FUNCTION HANDLING SUBBROKER CLIENT POPUP WINDOW

function popHelp3(fname)
{
    popup3=window.open(fname,"popDialog3","scrollbars=yes,resize=no,status=yes");
    popup3.document.close();
}

function popHelp4(fname,sbk_code12,sbk_name1,sbk_pan,sbk_adrs_pin,sbk_phne)
{
    popup4=window.open(fname,"popDialog4","scrollbars=yes,status=yes,resize=no");
    popup4.document.close();
}

// FUNCTION HANDLING BROKERAGE Query POPUP WINDOW

function popHelp7(fname,app_prdct_code,app_sbrkr_code,sbk_code12,app_amnt)
{
    q_brkr=window.open(fname,"popDialogq","scrollbars=no,status=yes,resize=no");
    q_brkr.document.close();
}


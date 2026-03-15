function lfnHrLoad()
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
        document.all.headerPrimaryKey.disabled = "true";          
    }
    checkEmpType();
    checkPFType();          
    checkDepuType();    
    checkHandicap();    
  //  checkHraStatus();    
   // onChangeAccomType();    
    hedMenuHandling(mode);    
}

function checkEmpType()
{
   if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DOTHRORG'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DTOORG')
   {
    document.all.parentZone.disabled="true";
    if(document.all.screenMode.value=='N')
      document.all.txtEmpStatus.value="EMPSTATUS$DEPU";
    document.all.txtEmpStatus.disabled="true";
   }
   else
   {
    if(document.all.screenMode.value=='N')
    {
      if(document.all.txtCateg.value!='EMPCTGRY$I')
        document.all.parentZone.disabled="";
      else
      {
        document.all.parentZone.value="0";
        document.all.parentZone.disabled="true";
      }
      document.all.txtEmpStatus.disabled="";
      document.getElementById("txtDepuType").disabled = "true";
    }
  }
}
function checkDepuType()
{
    if (document.all.txtEmpStatus.value=="EMPSTATUS$DEPU")
    {
      // document.getElementById("txtDepuType").disabled = "";
       document.getElementById("txtDepuType").style.background="#ffffd3";
       document.getElementById("txtDepuType").style.className="required";           
    }  
    else 
    {
     //  document.getElementById("txtDepuType").disabled = "true";
       document.getElementById("txtDepuType").value = "";
       document.getElementById("txtDepuType").style.background="#ffffff";
       document.getElementById("txtDepuType").style.className="optional";           
    }  
    
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

function checkHandicap()
{
    if (document.all.txtHandi.value=="Y")
    {
       document.getElementById("txtHandiEffDate").disabled = "";
       document.getElementById("txtHandiEffDate").style.background="#ffffd3";
       document.getElementById("txtHandiEffDate").style.className="required";           
    }  
    else 
    {
       //document.getElementById("txtHandiEffDate").disabled = "true";       
       document.all('txtHandi').options[document.all('txtHandi').selectedIndex].value="N";       
       document.getElementById("txtHandiEffDate").value = "";
       document.getElementById("txtHandiEffDate").style.background="#e0e0e0";
       document.getElementById("txtHandiEffDate").style.className="locked";           
    }    
}

function checkHraStatus()
{
    if (document.all.txtHRAStat.value=="Y")
    {
       document.getElementById("txtHRAEffDate").disabled = "";
       document.getElementById("txtHRAEffDate").style.background="#ffffd3";
       document.getElementById("txtHRAEffDate").style.className="required"; 
       document.getElementById("lstAccomType").disabled = "true";
       document.getElementById("lstAccomType").value = "";
       document.getElementById("lstAccomType").style.background="#e0e0e0";
       document.getElementById("lstAccomType").style.className="locked"; 
       document.getElementById("txtLeaseAmt").disabled = "true";
       document.getElementById("txtLeaseAmt").value = "";
       document.getElementById("txtLeaseAmt").style.background="#e0e0e0";
       document.getElementById("txtLeaseAmt").style.className="locked";
       
       document.getElementById("txtLicFeeDEM").disabled = "true";
       document.getElementById("txtLicFeeDEM").value = "";
       document.getElementById("txtLicFeeDEM").style.background="#e0e0e0";
       document.getElementById("txtLicFeeDEM").style.className="locked";       
       
    }  
    if (document.all.txtHRAStat.value=="N")
    {
       //document.getElementById("txtHRAEffDate").disabled = "true";
       document.getElementById("txtHRAEffDate").value = "";
       document.getElementById("txtHRAEffDate").style.background="#e0e0e0";
       document.getElementById("txtHRAEffDate").style.className="locked"; 
       document.getElementById("lstAccomType").disabled = "";
       document.getElementById("lstAccomType").style.background="#ffffd3";
       document.getElementById("lstAccomType").style.className="required";  
       
    }    
}

function onChangeAccomType()
{
    if (document.all.lstAccomType.value=="ACCOMTYPE$SELF" || document.all.lstAccomType.value=="ACCOMTYPE$THIRDP")
    {
       document.getElementById("txtLeaseAmt").disabled = "";
       document.getElementById("txtLeaseAmt").style.background="#ffffd3";
       document.getElementById("txtLeaseAmt").style.className="required";
    }
    else
    {
       document.getElementById("txtLeaseAmt").disabled = "true";
       document.getElementById("txtLeaseAmt").value = "";
       document.getElementById("txtLeaseAmt").style.background="#e0e0e0";
       document.getElementById("txtLeaseAmt").style.className="locked";
    }
    if (document.all.lstAccomType.value!="ACCOMTYPE$SPOUSE" && document.all.txtHRAStat.value=="N")
    {
       document.getElementById("txtLicFeeDEM").disabled = "";
       document.getElementById("txtLicFeeDEM").style.background="#ffffd3";
       document.getElementById("txtLicFeeDEM").style.className="required";
    }
    else
    {
       document.getElementById("txtLicFeeDEM").disabled = "true";
       document.getElementById("txtLicFeeDEM").value = "";
       document.getElementById("txtLicFeeDEM").style.background="#e0e0e0";
       document.getElementById("txtLicFeeDEM").style.className="locked"; 
    }
}

function checkGenPrefix(val)
{
    if(val=='M' && document.all.prefix.value!="")
    {
        if(document.all.prefix.value=='MISS' || document.all.prefix.value=='MRS' || document.all.prefix.value=='MS')
        {
            alert("Prefix is Miss, Please Choose Female")
            document.all.txtGender.value="";
            document.all.txtGender.focus();
        }
    }
    if(val=='F' && document.all.prefix.value!="")
    {
        if(document.all.prefix.value=='MR')
        {
            alert("Prefix is Mr, Please Choose Male")
            document.all.txtGender.value="";
            document.all.txtGender.focus();
        }
    }
    comboChange();
}

function SaveRecord()
{
    document.all.buttonFlag.value='';
    if (frmEmpFinInfoForm.txtHandi.value == 'Y')
    {
        if (frmEmpFinInfoForm.txtHandiEffDate.value == '')
        {
            alert("Handicapped Effective Date is Mandatory if Handicapped is Yes");
            frmEmpFinInfoForm.txtHandiEffDate.focus(); 
            return false;
        }
    }
 // commented by manish jindal reference issue 43490
   /* if(cmpDOBSysDate(frmEmpFinInfoForm.txtDOB.value)!=true)
    {
        return false;
    }
    */ 
    if(mandatory_Check("frmEmpFinInfoForm"))
    {     
        
        //document.getElementById("txtLicFeeDEM").disabled = "";
        //document.getElementById("txtLeaseAmt").disabled = "";
        //document.getElementById("lstAccomType").disabled = "";        
        frmEmpFinInfoForm.detailDataChanged.value = "false";  
        //if(frmEmpFinInfoForm.screenMode.value == "N")
          frmEmpFinInfoForm.headerDataChanged.value = "true";      
        frmEmpFinInfoForm.headerFields.value = "true";        
        //saveCheckBox(); 
        frmEmpFinInfoForm.action = "../../../EmpFinSaveAction.do";        
        document.all.txtCateg.disabled = "";
        document.all.txtDsgn.disabled = "";              
        document.all.txtEmpStatus.disabled='';
        document.all.txtDepuType.disabled="";
        document.all.parentZone.disabled='';
        frmEmpFinInfoForm.submit();
    }
    else
    {
        return false;
    }
}

function comboChange(val)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function upper(val)
{
   val.value=val.value.toUpperCase();
}

function saveCheckBox()
{  
    
}

function lfnChangeNegNum(val)
{
    if(NegNum_Check(val,1))
    { 
        frmEmpFinInfoForm.headerDataChanged.value = "true";
        return true;
    }
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function doGetTab(arg)
{    
    mode = document.all.screenMode.value;      
    if(mode == 'N' || mode == 'U')
    {
        if(mandatory_Check("frmEmpFinInfoForm"))
        {
            document.all.forwardedPage.value=arg;
            document.forms[0].action="../../../EmpInfoPayTabAction.do";
            document.forms[0].submit(); 
        }
    }
    else
    {
        document.all.forwardedPage.value=arg;
        document.forms[0].action="../../../EmpInfoPayTabAction.do";
        document.forms[0].submit(); 
    }
}


function doGetTabs(arg)
{
    if(mandatory_Check("frmEmpFinInfoForm"))
    {
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpInfoPayTabAction.do";
    document.forms[0].submit(); 
    }
}

/*function lfnChange(val)
{
    if(num_Check(val,1))
        frmEmpFinInfoForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}*/

function lfnChanged(val)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{
    document.all.buttonFlag.value='';
    document.all.txtEmpStatus.disabled='';    
    frmEmpFinInfoForm.action="../../../EmpFinFirstGetHeaderAction.do"
    frmEmpFinInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value + 1;
    frmEmpFinInfoForm.action="../../../EmpFinGetNextHeader.do";
    frmEmpFinInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value - 1;
    frmEmpFinInfoForm.action = "../../../EmpFinGetPrevHeader.do";
    frmEmpFinInfoForm.submit();
}

function JumpHeader()
{
    document.all.buttonFlag.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.newPositionRequested.value;
    frmEmpFinInfoForm.action = "../../../EmpFinGetNextHeader.do";
    frmEmpFinInfoForm.submit();
}

function doInsertMode()
{
    if ( document.all.screenMode.value == "Q")
        document.all.headerDataChanged.value='';
    
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.action="../../../EmpFinNewMode.do"
    frmEmpFinInfoForm.submit();
}

function doQueryMode()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.action="../../../EmpFinQueryMode.do"
    frmEmpFinInfoForm.submit();
}

function doRefresh()
{
    document.all.buttonFlag.value=''; 
    frmEmpFinInfoForm.action="../../../EmpHrRefresh.do"
    frmEmpFinInfoForm.submit();
}

function cmpDOBSysDate(cdate)
{
    if (trim(cdate) == "")
    {
        return true;
    }    
    firstIndex=cdate.indexOf("-");
    lastIndex=cdate.lastIndexOf("-");
    
    if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
    {
        var arr=cdate.split("-");
        var cyear= arr[2];
        var uyear=arr[2];
        var lyear;        
        lyear=parseInt(cyear)+18;  
        uyear=parseInt(cyear)+60;                
        var monIndx=getMonthIndx(arr[1]);
        
        if(arr[0]==01 && arr[1]!='Jan')
        { 
          var noDays = daysYearMonth(monIndx-1,uyear);          
          var rmonth = GetMonth(monIndx-2);          
          var retDate=noDays + "-" + rmonth + "-" + uyear;  
        }
        else if(arr[0]==01 && arr[1]=='Jan')
        {
          var retDate=31+ "-" + "Dec" + "-" + parseInt(uyear-1);        
        }
        else
        {
          var noDays = daysYearMonth(monIndx,uyear);          
          var retDate=noDays + "-" + arr[1] + "-" + uyear;
        }
        if(monIndx!=-1)
        {
            cdate = arr[0] + "/" + monIndx + "/" + lyear;  		
            udate = arr[0] + "/" + monIndx + "/" + uyear;  		
        }    
    }
    //cdate = change_DateFormat(cdate);  
    sysDate = getSysDate();  		
    if (dateDiff(sysDate, cdate) > 0 || dateDiff(sysDate, udate) < 0)
    {
        alert("Age cannot be Less than 18 or Greater then 60 Years!");
        frmEmpFinInfoForm.txtDOB.select();
        frmEmpFinInfoForm.txtDOB.focus();  
        return false;
    }    
    frmEmpFinInfoForm.txtRetireDate.value=retDate;
    return true;
}

function daysYearMonth(mnth, years )
{
    var intMonth = mnth; //given month
    var intYear = years; //given year        
    if (1 == intMonth || 3 == intMonth || 5 == intMonth || 7 == intMonth || 8 == intMonth ||
    10 == intMonth || 12 == intMonth)
    {
        return 31;
    }
    else if (2 == intMonth)
    {
        // Check for leap year
        if (0 == (intYear % 4))
        {
            // If date is divisible by 400, it's a leap year.
            // Otherwise, if it's divisible by 100 it's not.
            if (0 == (intYear % 400))
            {     
               return 29;
            }
            else if (0 == (intYear % 100))
            {             
                return 28;
            }    
            // Divisible by 4 but not by 100 or 400
            // so it leaps            
            return 29;
        }
        // Not a leap year        
        return 28;
    }
    return 30;     
}

function GetMonth(nMonth)
{
	var Months = new Array("Jan","Feb","Mar","Apr","May","Jun",
	                       "Jul","Aug","Sep","Oct","Nov","Dec");
	return Months[nMonth] 	  	 
}


function checkHandicapDate(val)
{
    if (trim(val) == "" || document.all.txtHandi.value=='N')
    {
        return true;
    }
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDOB.value,1,"Date cannot be Less than the Date of Birth!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtHandiEffDate.value="";     
        return false;
    }    
}

function checkHRAEffDate(val)
{

    var systDate = getSysDate();  
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtHRAEffDate.value="";     
        return false;
    }        
}

function checkPrevPromDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtPrvPromDate.value="";     
        return false;
    }    
}

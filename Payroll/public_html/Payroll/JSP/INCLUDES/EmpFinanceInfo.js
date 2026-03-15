
function EmpFinLoad()
{
        var epsFlag = getSafeValue("txtEpsFlag");
	mode = document.all.screenMode.value;     
	
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode == 'N')
    {     
        if(frmEmpFinInfoForm.txtPresentPOP.value == '')
        {
          document.all.txtPresentPOP.value=frmEmpFinInfoForm.loginLocCode.value;
          document.all.txtPresentPOPDesc.value=frmEmpFinInfoForm.loginEmployeelocation.value;
        }
		if(document.getElementById("txtPanNo").value=="Not Applicable")
		{
			document.getElementById("txtPanNo").readOnly='true';
			document.getElementById("txtPanNo").style.background="#e0e0e0";
			document.getElementById("txtPanNo").style.className="locked";        
		}
		
        document.all.txtEmpTypeId.value ='EMPTYPE$REG';
        document.all.txtEmpType.value ='Regular';
        document.all.txtPFType.value = 'PFTYPE$CPF';
    }   
    
    if(mode=='U')
    {         
        loadchkVldn();
        checkCPFVal();
        document.all.txtPayType.disabled = "true";
        document.all.headerPrimaryKey.disabled = "true";
        
        document.getElementById("txtHandi").disabled = true;
       document.getElementById("txtHandi").style.background="#e0e0e0";
       document.getElementById("txtHandi").style.className="locked";
   /////////////////ADDED BY MILAN    
  if(document.getElementById("selectDblHraFlag").checked==true)
        {
            if(document.getElementById("txtDblHraEffTill").value!='')
            {
                document.getElementById("txtDblHraCity").readOnly="true";
                document.getElementById("txtDblHraCity").style.background="#e0e0e0";
                document.getElementById("txtDblHraCity").style.className="locked";
                document.getElementById("buttxtDblHraCity").disabled="true";

                document.getElementById("txtDblHraEffFrom").readOnly="true";
                document.getElementById("txtDblHraEffFrom").style.background="#e0e0e0";
                document.getElementById("txtDblHraEffFrom").style.className="locked";
                document.getElementById("butTxtDblHraEffFrom").disabled="true";
                
                document.getElementById("txtDblHraEffTill").readOnly="true";
                document.getElementById("txtDblHraEffTill").style.background="#e0e0e0";
                document.getElementById("txtDblHraEffTill").style.className="locked";
                document.getElementById("butTxtDblHraEffTill").disabled="true";
             //   document.getElementById("txtPranNo").disabled = "true";  // added by sonali
            }
        }    
/////////////////////// 
         

       
    }
    if(mode=='Q')
    {     
        document.all.prefix.disabled = "true";
        document.all.txtEmpMiddleName.disabled = "true"; 
        document.getElementById("prefix").style.background="#ffffff";
        document.getElementById("prefix").style.className="locked";
        document.all.txtPFType.disabled = "true";
        document.getElementById("txtPFType").style.background="#ffffff";
        document.getElementById("txtPFType").style.className="locked";        
        document.getElementById("txtFpsNo").disabled = "true";  
     //   document.getElementById("txtPranNo").disabled = "true";// added by sonali
	//document.getElementById("txtPranNo").style.background="#e0e0e0";// added by sonali


 }
    onLoadcheckEmpType();
    checkPFType();      
    checkDepuType();
    //checkPayMode();  
    checkHandicap(); 
    //checkEpsFlag();    //commented by Swapnendu Dt 08 Apr 2013
	checkEpsFlagOnLoad(); //added by Swapnendu Dt 08 Apr 2013
    if(document.all.txtPayType.value=='CDA1')
    {
      
      document.getElementById("old").style.display='none';
      document.getElementById("new").style.display='';
    }
    else
    {
      
      document.getElementById("old").style.display='';
      document.getElementById("new").style.display='none';
    }
    hedMenuHandling(mode); 
    var arg=document.all.forwardedPage.value;
    showDiv(arg);    
    //document.all.selectCCAFlag.disabled = "true"; commented by devendra on 17th aug 2010
	 document.all.selectPLI.disabled = "true";    

	// added by by devendra on 17th aug 2010 start
	//var screenName =  document.all.screenName.value;
	//alert('just passed1')
	if(mode != 'N')
	{
		var payRevFlag=document.all.payRevFlag.value;
		//alert('just passed2')
	}
	if(mode != 'N' && payRevFlag!=null)
	{		
		//alert('payrevflag 5 , screenName::'+screenName+',   payRevFlag::'+payRevFlag);
		if(mode == 'U')
		{	
			//alert(' enabling select CCA flag.......')			
			if(frmEmpFinInfoForm.hdnCCAFlag.value=='Y')
			{
				//alert('checking selectCCAFlag...')
				document.all.selectCCAFlag.checked = "true";
			}else
			{
				document.all.selectCCAFlag.checked = "";
			}
			if(frmEmpFinInfoForm.hdnStationCompFlag.value=='Y')
			{
				document.all.selectStationComp.checked = "true";
			}else
			{
				document.all.selectStationComp.checked = "";
			}
			document.all.selectCCAFlag.disabled = "true";
			document.all.selectStationComp.disabled = "true";
		}
	}	
	else  if(mode=='N')
	{
			//alert(' disabling select CCA flag.......')
			document.all.selectCCAFlag.disabled = "true";
			document.all.selectStationComp.disabled = "true";
	}			

var ageStatus=0;
var getDob;
getDob=document.all.txtDOB.value;
ageStatus=epsAgeCal(getDob);
// added  by devendra on 17th aug 2010 end
   if(epsFlag=='Y'||epsFlag=='p')    //added by swapnendu Dt 08 Apr 2013.
		document.getElementById("txtEpsFlag").disabled = "true";
  else if(ageStatus==1)
  {
  document.getElementById("txtEpsFlag").disabled = "true";
  }
	else
		document.getElementById("txtEpsFlag").disabled = "";
   if(mode=='N')
	 fillPayStatusChdDate();
        PranFinLoad();        
}

function chkAadharNum(val)
{
 var len =val.length;
 if(len==12)
 {
   
   return true;
   
 }
 else 
 {
  alert("Aadhar number should be 12 digit");
  document.getElementById("txtAadharNum").value ="";
  return false;
 }
 
}

function chkUANum(val)
{

 var len =val.length;
 if(len==12)
 {
   return true;
 }
 else 
 {
  alert("UAN number should be 12 digit");
  document.getElementById("txtUanNum").value ="";
  return false;
  }
 
}

function panNA()
{
	document.getElementById("butNA").disabled="true";
	document.getElementById("txtPanNo").value = "Not Applicable";
	document.getElementById("txtPanNo").readOnly="true";
}
function butClearPan()
{
	document.getElementById("txtPanNo").value="";
	document.getElementById("txtPanNo").readOnly="";
	document.getElementById("txtPanNo").className="required";
	document.getElementById("txtPanNo").style.background="#ffffd3";

}

function updateFPSno(val) //added by swapnendu Dt 05 Oct 2011
{
	var len=val.length;
	if(len > 0)
	{
		if(isNaN(val))
		{
			if(confirm("do you want to modify FPS/EPS Number?"))
			{
				document.getElementById("txtFpsNo").value = val.substring(2);
			}
		}
	}
}
//function updatePranNo(val) //added by swapnendu Dt 05 Oct 2011
//{
//	var len=val.length;
//	if(len > 0)
//	{
//		if(isNaN(val))
//		{
//			if(confirm("do you want to modify PRAN Number?"))
//			{
//				document.getElementById("txtPranNo").value = val.substring(2);
//			}
//		}
//	}
//}

function showDiv(flag)
{
    
  if(flag=='flgDet')
  {
    document.getElementById('payDet').style.display='none';
    document.getElementById('flgDet').style.display='';
    document.getElementById('hrDet').style.display='none';
    document.getElementById('otrDet').style.display='none';
  }
  else if(flag=='hrDet')
  {
    document.getElementById('payDet').style.display='none';
    document.getElementById('flgDet').style.display='none';
    document.getElementById('hrDet').style.display='';
    document.getElementById('otrDet').style.display='none';
  }else if(flag=='otrDet')
  {
    document.getElementById('payDet').style.display='none';
    document.getElementById('flgDet').style.display='none';
    document.getElementById('hrDet').style.display='none';
    document.getElementById('otrDet').style.display='';
  }else
  {
    document.getElementById('payDet').style.display='';
    document.getElementById('flgDet').style.display='none';
    document.getElementById('hrDet').style.display='none';
    document.getElementById('otrDet').style.display='none';
  }
}

function checkEmpType()
{
    if (frmEmpFinInfoForm.hdnBoardFlag.value=='N')
    {        
        document.all.hdnPLIFlag.value='Y'; 
        document.getElementById("selectPLI").checked="true";
    }
    else
    {
        document.all.hdnPLIFlag.value='N'; 
        document.getElementById("selectPLI").checked="";
    }
    if(document.all.screenMode.value =='N')
    {
      if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT')
      {     
        document.getElementById("txtMHSTyp").value = 'N';      
        document.getElementById("txtMHSTyp").disabled="true";
      }
      else 
      {      
        document.getElementById("txtMHSTyp").disabled="";      
        //document.getElementById("txtMHSTyp").value = ''; commented by devendra
      }
   }
   
  //alert('inside checkEmpType function............frmEmpFinInfoForm.txtEmpTypeId.value:::'+frmEmpFinInfoForm.txtEmpTypeId.value+' and frmEmpFinInfoForm.txtCateg.value :::'+frmEmpFinInfoForm.txtCateg.value +' and document.all.screenMode.value :::'+document.all.screenMode.value);
  if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DOTHRORG'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DTOORG')
   {
		if(frmEmpFinInfoForm.txtCateg.value == "EMPCTGRY$I")
		{
			  document.all.parentZone.value=""; 
			  document.all.parentZone.disabled="true";   
			  //document.getElementById("parentZone").style.background="#ffffff";
			  //document.getElementById("parentZone").style.className="optional";
			  document.all.txtEmpStatus.disabled="true";
			  if(document.all.screenMode.value=='N')
			  {
				document.getElementById("txtDepuType").disabled = "";
				document.all.txtEmpStatus.value="EMPSTATUS$DEPU";
			  }
		}
		else 
		{ 
			  document.all.parentZone.value="";   
			  document.all.parentZone.disabled="";      
			  document.all.txtEmpStatus.value= "" ;
			  document.all.txtEmpStatus.disabled = "";
		}
   }
   else if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$REG')
   {
		document.all.txtEmpStatus.disabled="true";    
		if(frmEmpFinInfoForm.txtCateg.value == "EMPCTGRY$I")
		{
		  document.all.parentZone.value="0";
		  document.all.parentZone.disabled="true";
		}
		else
		{ 
		  //document.all.parentZone.value="";  commented by devendra
		  document.all.parentZone.disabled="";
		}      
		if(document.all.screenMode.value=='N')
		{      
		  document.all.txtEmpStatus.value="EMPSTATUS$PERM";
		}	
   }
   else if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$FOODTRNS')
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
		  document.all.txtEmpStatus.value= "" ;   
		  document.all.txtEmpStatus.disabled = "";     
		}
  }
  
  document.getElementById("parentZone").style.background="#ffffd3";
  document.getElementById("parentZone").style.className="required";
}

function onLoadcheckEmpType()
{ 
  if(document.all.screenMode.value =='U')
    {
		  if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT')
		  {        
			document.getElementById("txtMHSTyp").disabled="true";
		  }
		  else 
		  {      
			document.getElementById("txtMHSTyp").disabled="";              
		  }
   }
   if(document.all.screenMode.value =='N')
    {
		  if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT')
		  {     
			document.getElementById("txtMHSTyp").value = 'N';      
			document.getElementById("txtMHSTyp").disabled="true";
		  }      
   }
  //alert('inside onLoadcheckEmpType function............frmEmpFinInfoForm.txtEmpTypeId.value:::'+frmEmpFinInfoForm.txtEmpTypeId.value+' and frmEmpFinInfoForm.txtCateg.value :::'+frmEmpFinInfoForm.txtCateg.value +' and document.all.screenMode.value :::'+document.all.screenMode.value);
  if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DOTHRORG'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DTOORG')
   {
		if(frmEmpFinInfoForm.txtCateg.value == "EMPCTGRY$I")
		{
		  document.all.parentZone.value=""; 
		  document.all.parentZone.disabled="true";         
		  document.all.txtEmpStatus.disabled="true";
		  if(document.all.screenMode.value=='N')
		  {
			document.getElementById("txtDepuType").disabled = "";
			document.all.txtEmpStatus.value="EMPSTATUS$DEPU";
		  }
		}    
   }
   
   if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$REG' || 'PROMTYPE$ADHOC' || 'PROMTYPE$DEPLOY' )
   {
		document.all.txtEmpStatus.disabled="true";    
		if(frmEmpFinInfoForm.txtCateg.value == "EMPCTGRY$I")
		{
			
				


			var sysdate=new Date();
			var months = ['Jan', 'Feb', 'Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
			var newDate= sysdate.getDate()+'-'+months[sysdate.getMonth()]+'-'+sysdate.getYear();
            
		
			var dob= document.all.txtDOB.value
			var dobyr=dob.substring(7,11);
			
			var dobmth=dob.substring(3,6);
               
				 var dobdt=dob.substring(0,2);
				        
					       var newyr=Number(dobyr) + 59;
						 
              findt=dobdt+'-'+dobmth+'-'+newyr;
			
 

			var retdt=document.all.txtRetireDate.value;
		


   var date1=new Date(findt.replace(/[-]/g," "));
   

var date2=new Date(newDate.replace(/[-]/g," "));
  
if(date2.getTime() > date1.getTime())
			
			
			{
				
			
		  document.all.parentZone.disabled="true";
			}
			else
			{
          
		   document.all.parentZone.value="0";
		  document.all.parentZone.disabled="true";
			}
	
			
		} 
   }
   if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$FOODTRNS') 
   {    
		if(frmEmpFinInfoForm.txtCateg.value == "EMPCTGRY$I")
		{
		  document.all.parentZone.value="0";
		  document.all.parentZone.disabled="true";
		} 
   }
	   document.getElementById("parentZone").style.background="#ffffd3";
	   document.getElementById("parentZone").style.className="required";     
}

function checkDepuType()
{
    if (document.all.txtEmpStatus.value=="EMPSTATUS$DEPU")
    {      
       document.getElementById("txtDepuType").style.background="#ffffd3";
       document.getElementById("txtDepuType").style.className="required";           
    }  
    else 
    {     
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

function checkCPFVal()
{
  if(document.all.tmpCpfFlg.value=='N' || document.all.tmpCpfFlg.value=='')
  {
    document.all.txtCpfCode.readOnly = false;
    document.getElementById("txtCpfCode").style.background="#ffffd3";
  }
  else
  {
    document.all.txtCpfCode.readOnly = true;    
    document.getElementById("txtCpfCode").style.background="#e0e0e0";
  }
  
}

function checkPFType()
{     
    if (document.all.txtPFType.value=='PFTYPE$CPF' || document.all.txtPFType.value=='')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';        
    }
    if (document.all.txtPFType.value=="PFTYPE$GPF")
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';  
         document.getElementById("txtUanNum").style.background="#e0e0e0";
       document.getElementById("txtUanNum").style.className="locked"; 
       document.getElementById("txtUanNum").disabled = "true";
    }    
}  

function onChangePFType(val)
{   
    if (val=='PFTYPE$GPF')
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none'; 
         document.getElementById("txtUanNum").style.background="#e0e0e0";
       document.getElementById("txtUanNum").style.className="locked"; 
       document.getElementById("txtUanNum").disabled = "true";
    }
    if (val=='PFTYPE$CPF')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';        
    } 
}

function checkPayMode()
{
    if (document.all.txtPayMode.value=="O")
    {

        document.getElementById("txtPayModeType").disabled = "";
        document.getElementById("txtPayModeType").style.background="#ffffd3";
        document.getElementById("txtPayModeType").style.className="required";
        
        document.getElementById("txtBankDesc").style.background="#ffffff";
        document.getElementById("txtBankDesc").style.className="optional";
        
        document.getElementById("txtBranchDesc").style.background="#ffffff";
        document.getElementById("txtBranchDesc").style.className="optional";
        
        document.getElementById("txtBankAccNo").style.background="#ffffff";
        document.getElementById("txtBankAccNo").style.className="optional";
        if(frmEmpFinInfoForm.txtPayModeType.value=='ESC')
        {
            document.getElementById("txtBankDesc").disabled = "";
            document.getElementById("txtBankDesc").style.background="#ffffd3";
            document.getElementById("txtBankDesc").style.className="required";
            document.getElementById("txtBranchDesc").disabled = "";
            document.getElementById("txtBranchDesc").style.background="#ffffd3";
            document.getElementById("txtBranchDesc").style.className="required";
            document.getElementById("txtBankAccNo").disabled = "";
            document.getElementById("txtBankAccNo").style.background="#ffffd3";
            document.getElementById("txtBankAccNo").style.className="required";
        }
    }  
    else if (document.all.txtPayMode.value=="B")
    {
        document.getElementById("txtPayModeType").disabled = "true";
        document.getElementById("txtPayModeType").selectedIndex = "0";
        document.getElementById("txtPayModeType").style.background="#ffffff";
        document.getElementById("txtPayModeType").style.className="optional"; 
        document.getElementById("txtBankDesc").disabled = "";
        document.getElementById("txtBankDesc").style.background="#ffffd3";
        document.getElementById("txtBankDesc").style.className="required";
        document.getElementById("txtBranchDesc").disabled = "";
        document.getElementById("txtBranchDesc").style.background="#ffffd3";
        document.getElementById("txtBranchDesc").style.className="required";
        document.getElementById("txtBankAccNo").disabled = "";
        document.getElementById("txtBankAccNo").style.background="#ffffd3";
        document.getElementById("txtBankAccNo").style.className="required";
    }
    else 
    {
        document.getElementById("txtPayModeType").disabled = "true";
        document.getElementById("txtPayModeType").selectedIndex = "0";
        document.getElementById("txtPayModeType").style.background="#ffffff";
        document.getElementById("txtPayModeType").style.className="optional"; 
        
        document.getElementById("txtBankCode").value = "";
        document.getElementById("txtBankDesc").value = "";
        document.getElementById("txtBankDesc").style.background="#ffffff";
        document.getElementById("txtBankDesc").style.className="optional";
        
        document.getElementById("txtBranchCode").value = "";
        document.getElementById("txtBranchDesc").value = "";
        document.getElementById("txtBranchDesc").style.background="#ffffff";
        document.getElementById("txtBranchDesc").style.className="optional";
        
        document.getElementById("txtBankAccNo").value = "";
        document.getElementById("txtBankAccNo").style.background="#ffffff";
        document.getElementById("txtBankAccNo").style.className="optional";
    }    
}

function onChangePModeType()
{   
  
    comboChange();
    if (frmEmpFinInfoForm.txtPayMode.value == 'O' && frmEmpFinInfoForm.txtPayModeType.value=='ECS')
    {     
       document.getElementById("txtBankDesc").disabled = "";
       document.getElementById("txtBankDesc").style.background="#ffffd3";
       document.getElementById("txtBankDesc").style.className="required"; 
       document.getElementById("txtBranchDesc").disabled = "";
       document.getElementById("txtBranchDesc").style.background="#ffffd3";
       document.getElementById("txtBranchDesc").style.className="required";
       document.getElementById("txtBankAccNo").disabled = "";
       document.getElementById("txtBankAccNo").style.background="#ffffd3";
       document.getElementById("txtBankAccNo").style.className="required";
    }  
    else 
    {  
       document.getElementById("txtBankCode").value = "";
       document.getElementById("txtBankDesc").value = "";
       document.getElementById("txtBankDesc").style.background="#ffffff";
       document.getElementById("txtBankDesc").style.className="optional";  
       
       document.getElementById("txtBranchCode").value = "";
       document.getElementById("txtBranchDesc").value = "";
       document.getElementById("txtBranchDesc").style.background="#ffffff";
       document.getElementById("txtBranchDesc").style.className="optional";
       
       document.getElementById("txtBankAccNo").value = "";
       document.getElementById("txtBankAccNo").style.background="#ffffff";
       document.getElementById("txtBankAccNo").style.className="optional";
    }    
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmEmpFinInfoForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
	
    frmEmpFinInfoForm.headerDataChanged.value = "true";
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

function comboChange(val)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function doOnChangeCalendar(buttonName)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{    
    document.all.buttonFlag.value='';    
    document.all.txtEmpStatus.disabled=''; 
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.action="../../../EmpFinFirstGetHeaderAction.do"
    frmEmpFinInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value + 1;
    frmEmpFinInfoForm.action="../../../EmpFinGetNextHeader.do";
    frmEmpFinInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value - 1;
    frmEmpFinInfoForm.action = "../../../EmpFinGetPrevHeader.do";
    frmEmpFinInfoForm.submit();
}

function JumpHeader()
{   
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
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
    if(document.all.screenMode.value=='N')
      document.all.forwardedPage.value='';
    frmEmpFinInfoForm.action="../../../EmpFinRefresh.do"
    frmEmpFinInfoForm.submit();
}

function SaveRecord()
{
    //alert('inside save , value of payscale code is :::'+document.all.txtPayScaleCode.value);
	document.all.buttonFlag.value='';   
    if (frmEmpFinInfoForm.txtCateg.value != "EMPCTGRY$I" && (document.all.parentZone.value==0 || document.all.parentZone.value==''))
    {
        alert("Parent Zone is not Valid, Please Select Correct value");      
        document.all.parentZone.disabled="";    
        return false;
    }
    
    
    if (frmEmpFinInfoForm.txtEmpStatus.value=='EMPSTATUS$DEPU')
    {
        if (document.getElementById("txtDepuType").value ==" " || document.getElementById("txtDepuType").value =='')
        {
            alert("Deputation Type is Mandatory if Employee Status is Deputation");
            frmEmpFinInfoForm.txtDepuType.focus(); 
            return false;
        }
    }
    else
    {
        document.getElementById("txtDepuType").disabled = "false";
        document.getElementById("txtDepuType").value = "";
    }
    
   
          
    if(mandatory_Check("frmEmpFinInfoForm"))
    {     
		if (!validateCadr()) return;
        frmEmpFinInfoForm.txtEmpNo.value=frmEmpFinInfoForm.headerPrimaryKey.value;         
       
      
        document.all.parentZone.disabled=""; 
        document.all.txtDepuType.disabled="";
        document.all.txtEmpStatus.disabled="";
        document.getElementById("txtMHSTyp").disabled="";
        document.getElementById("txtHandiType").disabled = false;
        document.getElementById("txtCasteCateg").disabled = false;
        document.getElementById("txtReligion").disabled = false;
        document.getElementById("txtExsrvcman").disabled = false;
        document.getElementById("txtAadharNum").disabled = false;
        document.getElementById("txtUanNum").disabled = false;
        
        if (frmEmpFinInfoForm.txtPayMode.value == "C")
        {
            frmEmpFinInfoForm.txtPayModeType.value="";  
        }
        if (frmEmpFinInfoForm.txtPayMode.value == "B")    
        {
            frmEmpFinInfoForm.txtPayModeType.value="";  
        }       
        
        frmEmpFinInfoForm.detailDataChanged.value = "false";  
        
            frmEmpFinInfoForm.headerDataChanged.value = "true";    
        frmEmpFinInfoForm.headerFields.value = "true";    
        if(frmEmpFinInfoForm.txtGender.value=="")
        {
            alert("Mandatory Field Gender in HRMS Details is Empty! ");
            return;
        }

        saveCheckBox();
        document.all.txtSplDtyAllowArea.disabled="";
        frmEmpFinInfoForm.resetFlag.value ='false';
		document.all.butSave.disabled="true";
		document.all.txtEpsFlag.disabled="";
		document.all.butEpsEntDt.disabled="";
		document.all.txtFpsNo.disabled="";
        document.getElementById("txtPayStatus").disabled="";   // Added by dushyant on 17-May-2013
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpFinInfoForm.action = "../../../EmpFinSaveAction.do";              
      
        frmEmpFinInfoForm.submit();
    }
    
    else
    {
        return false;
    }
}

function SavePayrollTabData()
{
    document.all.buttonFlag.value='';

    if (frmEmpFinInfoForm.txtEmpStatus.value=='EMPSTATUS$DEPU')
    {
        if (document.getElementById("txtDepuType").value ==" " || document.getElementById("txtDepuType").value =='')
        {
            alert("Deputation Type is Mandatory if Employee Status is Deputation");
            frmEmpFinInfoForm.txtDepuType.focus(); 
            return false;
        }
    }
    else
    {
        document.getElementById("txtDepuType").disabled = "false";
        document.getElementById("txtDepuType").value = "";
    }     
   
    if (frmEmpFinInfoForm.txtPayMode.value == 'O' && frmEmpFinInfoForm.txtPayModeType.value=='ESC')
    {
        if (frmEmpFinInfoForm.txtBankCode.value == '')
        {
            alert("Mandatory Field Bank Code is Empty!");
            frmEmpFinInfoForm.txtBankDesc.focus(); 
            return false;
        }
        if (frmEmpFinInfoForm.txtBranchCode.value == '')
        {
            alert("Mandatory Field Branch Code is Empty!");
            frmEmpFinInfoForm.txtBranchDesc.focus(); 
            return false;
        }    
        if (frmEmpFinInfoForm.txtBankAccNo.value == '')
        {
            alert("Mandatory Field Bank Account Number is Empty!");
            frmEmpFinInfoForm.txtBankAccNo.focus(); 
            return false;
        }        
    }
        
    if(mandatory_Check("frmEmpFinInfoForm"))
    {     
        frmEmpFinInfoForm.txtEmpNo.value=frmEmpFinInfoForm.headerPrimaryKey.value; 
        if (frmEmpFinInfoForm.txtPayMode.value == "C")
        {
            frmEmpFinInfoForm.txtPayModeType.value="";  
        }
        if (frmEmpFinInfoForm.txtPayMode.value == "B")    
        {
            frmEmpFinInfoForm.txtPayModeType.value="";  
        }       
        
        frmEmpFinInfoForm.detailDataChanged.value = "false";  
        if(frmEmpFinInfoForm.screenMode.value == "N")
            frmEmpFinInfoForm.headerDataChanged.value = "false";    
        frmEmpFinInfoForm.headerFields.value = "true";        
        return true;
    }
    
    else
    {
        return false;
    }
}

function checkCurBasicLimit()
{
    var curBasic;
    var startBasic;
    var endBasic;
    var curBasic;
	
    curBasic = parseInt(frmEmpFinInfoForm.txtCurtBasic.value);
    startBasic =parseInt(frmEmpFinInfoForm.hdnStartBasic.value); 
    endBasic = parseInt(frmEmpFinInfoForm.hdnEndBasic.value);
	//alert('inside checkCurBasicLimit function. value of curBasic:'+curBasic+',startBasic:'+startBasic+', endBasic:'+endBasic);
    if(curBasic < startBasic || curBasic > endBasic)
    {
        alert("Current Basic Should be In Range "+startBasic+" To "+endBasic);
        frmEmpFinInfoForm.txtCurtBasic.select();
        frmEmpFinInfoForm.txtCurtBasic.focus();
        return false;
    }    
    else
        return true;
}



function saveCheckBox()
{      
	//alert('saveCheckBox() in empfinanceINfo.js')
    if (document.getElementById("selectNpa").checked==true)
    {        
        document.all.hdnNpaFlag.value="Y";
    }
    else 
    {      
        document.all.hdnNpaFlag.value="N";
    }
 
    if (document.getElementById("selectCant").checked==true)
    {        
        document.all.hdnCantFlag.value="Y";
    }
    else 
    {      
        document.all.hdnCantFlag.value="N";
    }
 
    if (document.getElementById("selectWash").checked==true)
    {        
        document.all.hdnWashFlag.value="Y";
    }
    else 
    {      
        document.all.hdnWashFlag.value="N";
    }
 
    if (document.getElementById("selectCCAFlag").checked==true)
    {        
        document.all.hdnCCAFlag.value="Y";
    }
    else 
    {      
        document.all.hdnCCAFlag.value="N";
    }   
    
    if (document.getElementById("selectPLI").checked==true)
    {        
        document.all.hdnPLIFlag.value="Y";        
    }
    else 
    {      
        document.all.hdnPLIFlag.value="N";
    }    
    
    if (document.getElementById("selectConvFlag").checked==true)
    {        
        document.all.hdnConvFlag.value="Y";
    }
    else 
    {      
        document.all.hdnConvFlag.value="N";
    }
    
    if (document.getElementById("selectDustOpAllow").checked==true)
    {        
        document.all.hdnDustOpAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnDustOpAllowFlag.value="N";
    }
    
    if (document.getElementById("selectStationComp").checked==true)
    {        
        document.all.hdnStationCompFlag.value="Y";
    }
    else 
    {      
        document.all.hdnStationCompFlag.value="N";
    }
    
    if (document.getElementById("selectDblHraFlag").checked==true)
    {        
        document.all.hdnDblHraFlag.value="Y";
    }
    else 
    {      
        document.all.hdnDblHraFlag.value="N";
    }
    
    if (document.getElementById("selectSplPaySprt").checked==true)
    {        
        document.all.hdnSplPaySprtFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplPaySprtFlag.value="N";
    }
    
    if (document.getElementById("selectSplPayCshAllow").checked==true)
    {        
        document.all.hdnSplPayCshAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplPayCshAllowFlag.value="N";
    }
    
    if (document.getElementById("selectPersPaySFN").checked==true)
    {        
        document.all.hdnPersPaySFNFlag.value="Y";
    }
    else 
    {      
        document.all.hdnPersPaySFNFlag.value="N";
    }
    
    if (document.getElementById("selectPersPayHQua").checked==true)
    {        
        document.all.hdnPersPayHQuaFlag.value="Y";
    }
    else 
    {      
        document.all.hdnPersPayHQuaFlag.value="N";
    }
    
    if (document.getElementById("selectSplCmpAllow").checked==true)
    {        
        document.all.hdnSplCmpAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplCmpAllowFlag.value="N";
    }

    if (document.getElementById("selectPersPayHndQua").checked==true)
    {        
        document.all.hdnPersPayHndQuaFlag.value="Y";
    }
    else 
    {      
        document.all.hdnPersPayHndQuaFlag.value="N";
    }
    
    if (document.getElementById("selectSplDtyAllow").checked==true)
    {        
        document.all.hdnSplDtyAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplDtyAllowFlag.value="N";
    }    
    
}


function disable()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    if (document.all.selectChEdAl.checked==true)
    {
        document.all.selectChEdAl.value="Y";
        if(document.all.selectChEdAl.value=="Y")
        {
        document.getElementById("txtNoc").disabled = "";
        document.getElementById("txtNoc").style.background="#ffffd3";
        document.getElementById("txtNoc").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtNoc").disabled = "true"; 
        document.getElementById("txtNoc").value = "";     
        document.getElementById("txtNoc").style.background="#e0e0e0";
        document.getElementById("txtNoc").style.className="locked";       
    }
}

function HosDisab()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    if (document.all.selectHos.checked==true)
    {
        document.all.selectHos.value="Y";
        if(document.all.selectHos.value=="Y")
        {
        document.getElementById("txtHosChld").disabled = "";
        document.getElementById("txtHosChld").style.background="#ffffd3";
        document.getElementById("txtHosChld").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtHosChld").disabled = "true";
        document.getElementById("txtHosChld").value = "";
        document.getElementById("txtHosChld").style.background="#e0e0e0";
        document.getElementById("txtHosChld").style.className="locked";       
    }
}

function CantDisab()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    if (document.all.selectCant.checked==true)
    {
        document.all.selectCant.value="Y";
        if(document.all.selectCant.value=="Y")
        {
        document.getElementById("txtCantRate").disabled = "";
        document.getElementById("txtCantRate").style.background="#ffffd3";
        document.getElementById("txtCantRate").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtCantRate").disabled = "true";
        document.getElementById("txtCantRate").value = "";
        document.getElementById("txtCantRate").style.background="#ffffff";
        document.getElementById("txtCantRate").style.className="optional";       
    }
}

function GisDisab()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    if (document.all.selectGisRec.checked==true)
    {
        document.all.selectGisRec.value="Y";
        if(document.all.selectGisRec.value=="Y")
        {
        document.getElementById("txtGisType").disabled = "";
        document.getElementById("txtGisType").style.background="#ffffd3";
        document.getElementById("txtGisType").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtGisType").disabled = "true";
        document.getElementById("txtGisType").value = "";
        document.getElementById("txtGisType").style.background="#ffffff";
        document.getElementById("txtGisType").style.className="optional";       
    }
}

String.prototype.endsWith = function(str) 
{return (this.match(str+"$")==str)}

//Function to enabled the control box if check box is selected
function cmnFlagTxtDisab(argFlag,argTxt)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    var arrArgTxt=argTxt.split(",");
    if (document.getElementById(argFlag).checked==true)
    {
        document.getElementById(argFlag).value="Y";        
        if(document.getElementById(argFlag).value=="Y")
        {
            for(i=0;i<arrArgTxt.length;i++)
            {
              if(arrArgTxt[i].endsWith('Till'))
              {
                document.getElementById(arrArgTxt[i]).disabled = "";
                document.getElementById(arrArgTxt[i]).style.background="#ffffff";
                document.getElementById(arrArgTxt[i]).style.className="optional"
              }else
              {
                document.getElementById(arrArgTxt[i]).disabled = "";
                document.getElementById(arrArgTxt[i]).style.background="#ffffd3";
                document.getElementById(arrArgTxt[i]).style.className="required"; 
              }
             }
        }
    }  
    else 
    {        
        document.getElementById(argFlag).value="N";
        for(i=0;i<arrArgTxt.length;i++)
        {
          document.getElementById(arrArgTxt[i]).disabled = "true";
          document.getElementById(arrArgTxt[i]).value = "";        
          document.getElementById(arrArgTxt[i]).style.background="#e0e0e0";
          document.getElementById(arrArgTxt[i]).style.className="locked"; 
        }
    }
}

//Function to enabled the control box and display LOV Image if check box is selected
function cmnFlagTxtImgDisab(argFlag,argTxt)
{       
    frmEmpFinInfoForm.headerDataChanged.value = "true";    
    if (document.getElementById(argFlag).checked==true)
    {
        document.getElementById(argFlag).value="Y";        
        if(document.getElementById(argFlag).value=="Y")
        {
            document.getElementById(argTxt).disabled = "";
            document.getElementById("buttxtDblHraCity").disabled = "";            
            document.getElementById(argTxt).style.background="#ffffd3";
            document.getElementById(argTxt).style.className="required";       
        }
    }  
    else 
    {
        document.getElementById(argTxt).disabled = "true";
        document.getElementById("buttxtDblHraCity").disabled = "true";
        document.getElementById(argFlag).value="N";
        document.getElementById(argTxt).value = "";        
        document.getElementById(argTxt).style.background="#e0e0e0";
        document.getElementById(argTxt).style.className="locked"; 
    }
}

//Function to enabled the control box and date field if check box is selected
function advIncFlagTxtDisab(argFlag,argTxt,argDate)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    if (document.getElementById(argFlag).checked==true)
    {
        document.getElementById(argFlag).value="Y";        
        if(document.getElementById(argFlag).value=="Y")
        {
            document.getElementById(argTxt).disabled = "";
            document.getElementById(argTxt).style.background="#ffffd3";
            document.getElementById(argTxt).style.className="required";       
            document.getElementById(argDate).disabled = "";
            document.getElementById(argDate).style.background="#ffffd3";
            document.getElementById(argDate).style.className="required";
        }
    }  
    else 
    {
        document.getElementById(argFlag).value="N";        
        document.getElementById(argTxt).disabled = "true";
        document.getElementById(argTxt).value = "";
        document.getElementById(argTxt).style.background="#e0e0e0";
        document.getElementById(argTxt).style.className="locked";       
        document.getElementById(argDate).disabled = "true";
        document.getElementById(argDate).value = "";
        document.getElementById(argDate).style.background="#e0e0e0";
        document.getElementById(argDate).style.className="locked";
    }
}
function DepuFlag()
{
    if (document.all.selectDep.checked==true)
        document.getElementById("selectOut").disabled = "";
    else
    {
        document.getElementById("selectOut").disabled = "disabled"; 
        document.getElementById("selectOut").checked="";
    }
}

function showCalendar(inputId, butId) 
{  
    if(butId.alt)
    {
        iIndex=butId.alt;
    }
    else
    {
        iIndex="-1";
    }
    Calendar.setup({inputField	: inputId,
    ifFormat	: "%d-%b-%Y",
    button	: butId,
    position: iIndex
    });        
    return false;
}

function disAdvIncrCal(inputId, butId)
{  
 if(document.getElementById("selectAdvIncr").checked= "true");  
    showCalendar(inputId, butId);
 
}
function doGetTab(arg)
{  
    mode = document.all.screenMode.value;      
    if(mode == 'N' || mode == 'U')
    { 
      if(mode=='N')
      {
      
      }
	  document.getElementById("txtPayStatus").disabled= "";   // Added by dushyant on 18-May-2013
      document.all.hdnPLIFlag.value=frmEmpFinInfoForm.hdnBoardFlag.value=='N'? 'Y' : 'N';
      document.all.forwardedPage.value=arg;
      showDiv(arg);           
      
    }
    else
    {
        document.all.forwardedPage.value=arg;
        showDiv(arg);
    }
}

function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpInfoFlagTabAction.do";
    document.forms[0].submit(); 
}

function checkDojFci(cdate)
{
    if (trim(cdate) == "")
    {
        return true;
    }    
    firstIndex=cdate.indexOf("-");
    lastIndex=cdate.lastIndexOf("-");
    var dojSite=cdate;
    if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
    {
        var arr=cdate.split("-");
        var cyear= arr[2];
        var lyear=1990;                
        var monIndx=getMonthIndx(arr[1]);
        var lmonthIndx=parseInt(01);
        var ldayIndx=parseInt(01);
        if(monIndx!=-1)
        {
            cdate = arr[0] + "/" + monIndx + "/" + cyear;  		
            udate = ldayIndx + "/" + lmonthIndx + "/" + lyear;  		
        }    
    }
    //cdate = change_DateFormat(cdate);  
    sysDate = getSysDate(); 
    if (dateDiff(udate, cdate) < 0 || dateDiff(sysDate, cdate) >0)
    {
        alert("Date Of Joining FCI Cannot be Less then 1990! or Greater then Current Date");
        frmEmpFinInfoForm.txtDojFCI.select();
        frmEmpFinInfoForm.txtDojFCI.focus();
        frmEmpFinInfoForm.txtDojFCI.value="";
        return false;
    }
    document.all.txtDOJSite.value=dojSite;
    return true;
}

function checkPostDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtDOJSite.value="";     
        return false;
    }    
}

function checkPayStatDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtPayStsChnDate.value="";     
        return false;
    }    
}



function checkHandicap()
{
    if (document.all.txtHandi.value=="Y")
    {
       document.getElementById("txtHandiEffDate").disabled = "";
       document.getElementById("txtHandiEffDate").style.background="#ffffd3";
       document.getElementById("txtHandiEffDate").className="required";  
        
       document.getElementById("txtHandiType").disabled = "";
       document.getElementById("txtHandiType").style.background="#ffffd3";
       document.getElementById("txtHandiType").className="required";
    }  
    else 
    {       
       document.all.txtHandi.value="N"
       document.getElementById("txtHandiEffDate").value = "";
       document.getElementById("txtHandiEffDate").style.background="#e0e0e0";
       document.getElementById("txtHandiEffDate").style.className="locked"; 
       document.getElementById("txtHandiType").disabled = true;
       document.getElementById("txtHandiType").value = "";
       document.getElementById("txtHandiType").style.background="#e0e0e0";
       document.getElementById("txtHandiType").style.className="locked";  
       document.getElementById("txtHandiType").disabled = true;
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
//13-11-2019 AMRESH 
function cmpDOBSysDate(cdate)
{  if (trim(cdate) == "")
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
		var uEpsyear =parseInt(cyear)+58;
		var epsDate;
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
			epsDate = arr[0] + "/" + monIndx + "/" + uEpsyear;
        }    
    }
    //cdate = change_DateFormat(cdate);  
    sysDate = getSysDate();  	     
    if (dateDiff(sysDate, cdate) > 0 || dateDiff(sysDate, udate) < 0)
    {
        alert("Age cannot be Less than 18 or Greater then 60 Years!");
        document.getElementById("txtDOB").value = ""; 
		document.getElementById("txtRetireDate").value = "";
        return false;
    }    
	
    document.getElementById("txtRetireDate").value = retDate;
	if (dateDiff(sysDate, epsDate) > 0)
	{
		document.getElementById("txtEpsFlag").value = 'N';
		checkEpsFlagOnLoad();
	} 
	if (dateDiff(sysDate, epsDate) < 0)
	{
		document.getElementById("txtEpsFlag").value= 'N';
		checkEpsFlagOnLoad();
	}
		
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

function onclickCheck(checkFlag,hdnFlag)
{
    lfnChange('1');  
    if (document.getElementById(checkFlag).checked==true)
    {
        hdnFlag.value="Y";                
    }  
    else 
    {        
        hdnFlag.value="N";      
    }    
}

function Chk_Char(name)
{
    that=document.getElementsByName(name)[0];    
    str=that.value; 
    for(i=0; i<str.length; i++)
    {
        var txtVal =str.charAt(i);
        if((txtVal >= 'A' && txtVal <= 'Z') ||(txtVal >= 'a' && txtVal <= 'z') || (txtVal == ',') || (txtVal == ' '))
        {}
        else
        {
            alert("Invalid Input");               
            that.select();             
            return true;
        }
    }
}

function checkEpsFlag()
{   var epsFlag = getSafeValue("txtEpsFlag");
  var mode = document.all.screenMode.value;  
  if(epsFlag=='Y'||epsFlag=='p')
  {
	if (mode=='U')  //added by swapnendu Dt 08 Apr 2013
	{
		    document.getElementById("butEpsEntDt").disabled="";
			document.getElementById("txtFpsNo").readOnly="";
			document.getElementById("txtEpsEntDt").style.background="#ffffd3";
			document.getElementById("txtEpsEntDt").className="required";
			document.getElementById("txtFpsNo").style.background="#ffffd3";
			document.getElementById("txtFpsNo").className="required";
			if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
    		 document.getElementById("txtFpsNo").className="locked";
				 document.getElementById("txtFpsNo").readOnly="true"; 
				 document.getElementById("txtFpsNo").value = "TEMP";
				 document.getElementById("txtFpsNo").style.background="#e0e0e0";
				}
	}
	if (mode=='N')
	{

		document.getElementById("butEpsEntDt").disabled="";
		document.getElementById("txtEpsEntDt").style.background="#ffffd3";
		document.getElementById("txtEpsEntDt").className="required";
		document.getElementById("txtFpsNo").style.background="#ffffd3";
		document.getElementById("txtFpsNo").className="required";
		document.getElementById("txtFpsNo").disabled="";
		document.getElementById("txtFpsNo").readOnly="";
		 if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
			{
			 document.getElementById("txtFpsNo").className="locked";
			 document.getElementById("txtFpsNo").readOnly="true"; 
			 document.getElementById("txtFpsNo").value = "TEMP"; 
			 document.getElementById("txtFpsNo").style.background="#e0e0e0";
		    }
	}
  }
  else
  {
    document.getElementById("butEpsEntDt").disabled="true";
    document.getElementById("txtEpsEntDt").value = "";
    document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
	document.getElementById("txtEpsEntDt").readOnly = "true";
    document.getElementById("txtEpsEntDt").className="locked";
    document.getElementById("txtFpsNo").style.background="#e0e0e0";
	document.getElementById("txtFpsNo").value = "";
	document.getElementById("txtFpsNo").readOnly = "true";
    document.getElementById("txtFpsNo").className="locked";
	document.getElementById("txtFpsNo").onclick="";
	   if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
			{
			 document.getElementById("txtFpsNo").value = "";   // Added by dushyant on 16-May-2013
		    }
  }
}

function checkEpsFlagOnLoad()  //added by swapnendu Dt 08 Apr 2013
{
	var epsFlag = getSafeValue("txtEpsFlag");
        var mode = document.all.screenMode.value;  
	if(epsFlag=='Y'||epsFlag=='p')
	{
		if (mode=='U') 
		{
			if (document.getElementById("txtEpsEntDt").value=="")
			{
				document.getElementById("butEpsEntDt").disabled="";
				document.getElementById("txtEpsEntDt").style.background="#ffffd3";
				document.getElementById("txtEpsEntDt").className="required";
			}
			else
			{
				document.getElementById("butEpsEntDt").disabled="true";
				document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
				document.getElementById("txtEpsEntDt").readOnly = "true"; 
				document.getElementById("txtEpsEntDt").className="locked";
			}
			if (document.getElementById("txtFpsNo").value=="")
			{
				document.getElementById("txtFpsNo").style.background="#ffffd3";
				document.getElementById("txtFpsNo").className="required";
				document.getElementById("txtFpsNo").disabled="";
				document.getElementById("txtFpsNo").readOnly="";
			}
			else 
			{
				document.getElementById("txtFpsNo").style.background="#e0e0e0";
				document.getElementById("txtFpsNo").readOnly = "true"; 
				document.getElementById("txtFpsNo").className="locked";
				document.getElementById("txtFpsNo").onclick="";
			}
		}
		if (mode=='N')
		{
			document.getElementById("txtEpsFlag").disabled = "true";
			document.getElementById("butEpsEntDt").disabled="";
			document.getElementById("txtEpsEntDt").style.background="#ffffd3";
			document.getElementById("txtEpsEntDt").className="required";
			document.getElementById("txtFpsNo").style.background="#ffffd3";
			document.getElementById("txtFpsNo").className="required";
			document.getElementById("txtFpsNo").disabled="";
			document.getElementById("txtFpsNo").readOnly="";
			if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
				 document.getElementById("txtFpsNo").className="locked";
				 document.getElementById("txtFpsNo").readOnly="true"; 
				 document.getElementById("txtFpsNo").value = "TEMP"; 
				 document.getElementById("txtFpsNo").style.background="#e0e0e0";
				}
		}
	}
	else
	{
		document.getElementById("butEpsEntDt").disabled="true";
		//document.getElementById("txtEpsEntDt").value = "";
		document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
		document.getElementById("txtEpsEntDt").readOnly = "true";
		document.getElementById("txtEpsEntDt").className="locked";
		document.getElementById("txtFpsNo").style.background="#e0e0e0";
		//document.getElementById("txtFpsNo").value = "";
		document.getElementById("txtFpsNo").readOnly = "true";
		document.getElementById("txtFpsNo").className="locked";
		document.getElementById("txtFpsNo").onclick="";
		  if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
			{
			 document.getElementById("txtFpsNo").value = "";   // Added by dushyant on 16-May-2013
		    }
	}
}
function chkDate(fromField,toField)
{
  var fromDt=document.getElementById(fromField).value;
  var toDt=document.getElementById(toField).value;
  if(toDt!='')
  {
  if (!cmpDate(fromDt,toDt,0))
  {
    alert("From Date must be greater than To Date");
    document.getElementById(toField).value="";
    return false;                      
  }
  }
}

function setPayRevChange()
{ 
   //alert('inside setPayRevChange function , document.all.txtPayType.value::'+ document.all.txtPayType.value)
   document.all.hdnTmpPayScaleCode.value=document.all.tmpPayScaleCode.value;
   document.all.hdnTmpGradePay.value=document.all.tmpGradePay.value;
   //alert('document.all.hdnTmpPayScaleCode.value::: '+document.all.hdnTmpPayScaleCode.value+',document.all.hdnTmpGradePay.value::'+document.all.hdnTmpGradePay.value);
 // if(document.all.txtPayType.value=='CDA1') // commented by devendra
	 if(document.all.txtPayType.value=='CDA') // added by devendra
  {
		document.getElementById("old").style.display='none';
		document.getElementById("new").style.display='';
		//if(document.all.screenMode.value=='N')
		//{
		 // document.all.txtPayScaleCode.value=document.all.tmpPayBand.value; commented by devendra
		//  document.all.txtGradePay.value=document.all.tmpGradePay.value;  commented by devendra
		
			//document.all.txtPayScaleCode.value=''; //added by  devendra
			 document.all.txtPayScaleCode.value=document.all.tmpPayScaleCode.value;
			document.all.txtGradePay.value=document.all.tmpGradePay.value;  //added by devendra
		//}
	  }
else
  {
		//alert(' for IDA-> tmpPayScaleCode::'+document.all.tmpPayScaleCode.value+',tmpGradePay::'+document.all.tmpGradePay.value);
		
		document.getElementById("old").style.display='';
		document.getElementById("new").style.display='none';
		//if(document.all.screenMode.value=='N')
		//{
			//alert('setting txtGradePay field to null') 
                        
		  document.all.txtPayScaleCode.value=document.all.tmpPayScaleCode.value;
		  document.all.txtGradePay.value=document.all.tmpGradePay.value; 
		  //document.all.txtGradePay.value='';
		//}

}  
}
function FathHusFlag(name)

{
//alert ("in function");
 frmEmpFinInfoForm.txtFathHusflag.value = name;
//alert (frmEmpFinInfoForm.txtFathHusflag.value);
return success;
}

function epsAgeCal(cdate)
{
var flag=0;
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
		var uEpsyear =parseInt(cyear)+58;
		var epsDate;
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
			epsDate = arr[0] + "/" + monIndx + "/" + uEpsyear;
        }    
    }
    //cdate = change_DateFormat(cdate);  
    sysDate = getSysDate();  	     
    
	
	if (dateDiff(sysDate, epsDate) < 0)
	{
	flag=1;	
	}
		
    return flag;
} 
//wrt MHS CR
   function mhsmember(){
     if(frmEmpFinInfoForm.txtEmpTypeId.value!='NULL')
      {     
        document.getElementById("txtMHSTyp").disabled="true";
      }
      
}

function EmpFinLoad()
{
    var epsFlag = getSafeValue("txtEpsFlag");
	mode = document.all.screenMode.value;     
	
    if(mode == '')
    {
        doQueryMode();
    }
    if(mode == 'N')
    {     
        if(frmEmpFinInfoForm.txtPresentPOP.value == '')
        {
          document.all.txtPresentPOP.value=frmEmpFinInfoForm.loginLocCode.value;
          document.all.txtPresentPOPDesc.value=frmEmpFinInfoForm.loginEmployeelocation.value;
        }
		if(document.getElementById("txtPanNo").value=="Not Applicable")
		{
			document.getElementById("txtPanNo").readOnly='true';
			document.getElementById("txtPanNo").style.background="#e0e0e0";
			document.getElementById("txtPanNo").style.className="locked";        
		}
		
        document.all.txtEmpTypeId.value ='EMPTYPE$REG';
        document.all.txtEmpType.value ='Regular';
        document.all.txtPFType.value = 'PFTYPE$CPF';
    }   
    
    if(mode=='U')
    {         
        loadchkVldn();
        checkCPFVal();
        document.all.txtPayType.disabled = "true";
        document.all.headerPrimaryKey.disabled = "true";
        
        document.getElementById("txtHandi").disabled = true;
       document.getElementById("txtHandi").style.background="#e0e0e0";
       document.getElementById("txtHandi").style.className="locked";
   /////////////////ADDED BY MILAN    
  if(document.getElementById("selectDblHraFlag").checked==true)
        {
            if(document.getElementById("txtDblHraEffTill").value!='')
            {
                document.getElementById("txtDblHraCity").readOnly="true";
                document.getElementById("txtDblHraCity").style.background="#e0e0e0";
                document.getElementById("txtDblHraCity").style.className="locked";
                document.getElementById("buttxtDblHraCity").disabled="true";

                document.getElementById("txtDblHraEffFrom").readOnly="true";
                document.getElementById("txtDblHraEffFrom").style.background="#e0e0e0";
                document.getElementById("txtDblHraEffFrom").style.className="locked";
                document.getElementById("butTxtDblHraEffFrom").disabled="true";
                
                document.getElementById("txtDblHraEffTill").readOnly="true";
                document.getElementById("txtDblHraEffTill").style.background="#e0e0e0";
                document.getElementById("txtDblHraEffTill").style.className="locked";
                document.getElementById("butTxtDblHraEffTill").disabled="true";
                document.getElementById("txtPranNo").disabled = "true";  // added by sonali
            }
        }    
/////////////////////// 
         

       
    }
    if(mode=='Q')
    {     
        document.all.prefix.disabled = "true";
        document.all.txtEmpMiddleName.disabled = "true"; 
        document.getElementById("prefix").style.background="#ffffff";
        document.getElementById("prefix").style.className="locked";
        document.all.txtPFType.disabled = "true";
        document.getElementById("txtPFType").style.background="#ffffff";
        document.getElementById("txtPFType").style.className="locked";        
        document.getElementById("txtFpsNo").disabled = "true";  
        document.getElementById("txtPranNo").disabled = "true";// added by sonali
	document.getElementById("txtPranNo").style.background="#e0e0e0";// added by sonali


 }
    onLoadcheckEmpType();
    PranFinLoad();
    checkPFType();      
    checkDepuType();
    //checkPayMode();  
    checkHandicap(); 
    //checkEpsFlag();    //commented by Swapnendu Dt 08 Apr 2013
	checkEpsFlagOnLoad(); //added by Swapnendu Dt 08 Apr 2013
    if(document.all.txtPayType.value=='CDA1')
    {
      
      document.getElementById("old").style.display='none';
      document.getElementById("new").style.display='';
    }
    else
    {
      
      document.getElementById("old").style.display='';
      document.getElementById("new").style.display='none';
    }
    hedMenuHandling(mode); 
    var arg=document.all.forwardedPage.value;
    showDiv(arg);    
    //document.all.selectCCAFlag.disabled = "true"; commented by devendra on 17th aug 2010
	 document.all.selectPLI.disabled = "true";    

	// added by by devendra on 17th aug 2010 start
	//var screenName =  document.all.screenName.value;
	//alert('just passed1')
	if(mode != 'N')
	{
		var payRevFlag=document.all.payRevFlag.value;
		//alert('just passed2')
	}
	if(mode != 'N' && payRevFlag!=null)
	{		
		//alert('payrevflag 5 , screenName::'+screenName+',   payRevFlag::'+payRevFlag);
		if(mode == 'U')
		{	
			//alert(' enabling select CCA flag.......')			
			if(frmEmpFinInfoForm.hdnCCAFlag.value=='Y')
			{
				//alert('checking selectCCAFlag...')
				document.all.selectCCAFlag.checked = "true";
			}else
			{
				document.all.selectCCAFlag.checked = "";
			}
			if(frmEmpFinInfoForm.hdnStationCompFlag.value=='Y')
			{
				document.all.selectStationComp.checked = "true";
			}else
			{
				document.all.selectStationComp.checked = "";
			}
			document.all.selectCCAFlag.disabled = "true";
			document.all.selectStationComp.disabled = "true";
		}
	}	
	else  if(mode=='N')
	{
			//alert(' disabling select CCA flag.......')
			document.all.selectCCAFlag.disabled = "true";
			document.all.selectStationComp.disabled = "true";
	}			

var ageStatus=0;
var getDob;
getDob=document.all.txtDOB.value;
ageStatus=epsAgeCal(getDob);
// added  by devendra on 17th aug 2010 end
   if(epsFlag=='Y'||epsFlag=='p')    //added by swapnendu Dt 08 Apr 2013.
		document.getElementById("txtEpsFlag").disabled = "true";
  else if(ageStatus==1)
  {
  document.getElementById("txtEpsFlag").disabled = "true";
  }
	else
		document.getElementById("txtEpsFlag").disabled = "";
   if(mode=='N')
	 fillPayStatusChdDate();
handlePohwOnLoad();

}

function chkAadharNum(val)
{
 var len =val.length;
 if(len==12)
 {
   
   return true;
   
 }
 else 
 {
  alert("Aadhar number should be 12 digit");
  document.getElementById("txtAadharNum").value ="";
  return false;
 }
 
}

function chkUANum(val)
{

 var len =val.length;
 if(len==12)
 {
   return true;
 }
 else 
 {
  alert("UAN number should be 12 digit");
  document.getElementById("txtUanNum").value ="";
  return false;
  }
 
}

function panNA()
{
	document.getElementById("butNA").disabled="true";
	document.getElementById("txtPanNo").value = "Not Applicable";
	document.getElementById("txtPanNo").readOnly="true";
}
function butClearPan()
{
	document.getElementById("txtPanNo").value="";
	document.getElementById("txtPanNo").readOnly="";
	document.getElementById("txtPanNo").className="required";
	document.getElementById("txtPanNo").style.background="#ffffd3";

}

function updateFPSno(val) //added by swapnendu Dt 05 Oct 2011
{
	var len=val.length;
	if(len > 0)
	{
		if(isNaN(val))
		{
			if(confirm("do you want to modify FPS/EPS Number?"))
			{
				document.getElementById("txtFpsNo").value = val.substring(2);
			}
		}
	}
}
//function updatePranNo(val) //added by swapnendu Dt 05 Oct 2011
//{
//	var len=val.length;
//	if(len > 0)
//	{
//		if(isNaN(val))
//		{
//			if(confirm("do you want to modify PRAN Number?"))
//			{
//				document.getElementById("txtPranNo").value = val.substring(2);
//			}
//		}
//	}
//}

function showDiv(flag)
{
    
  if(flag=='flgDet')
  {
    document.getElementById('payDet').style.display='none';
    document.getElementById('flgDet').style.display='';
    document.getElementById('hrDet').style.display='none';
    document.getElementById('otrDet').style.display='none';
  }
  else if(flag=='hrDet')
  {
    document.getElementById('payDet').style.display='none';
    document.getElementById('flgDet').style.display='none';
    document.getElementById('hrDet').style.display='';
    document.getElementById('otrDet').style.display='none';
  }else if(flag=='otrDet')
  {
    document.getElementById('payDet').style.display='none';
    document.getElementById('flgDet').style.display='none';
    document.getElementById('hrDet').style.display='none';
    document.getElementById('otrDet').style.display='';
  }else
  {
    document.getElementById('payDet').style.display='';
    document.getElementById('flgDet').style.display='none';
    document.getElementById('hrDet').style.display='none';
    document.getElementById('otrDet').style.display='none';
  }
}

function checkEmpType()
{
    if (frmEmpFinInfoForm.hdnBoardFlag.value=='N')
    {        
        document.all.hdnPLIFlag.value='Y'; 
        document.getElementById("selectPLI").checked="true";
    }
    else
    {
        document.all.hdnPLIFlag.value='N'; 
        document.getElementById("selectPLI").checked="";
    }
    if(document.all.screenMode.value =='N')
    {
      if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT')
      {     
        document.getElementById("txtMHSTyp").value = 'N';      
        document.getElementById("txtMHSTyp").disabled="true";
      }
      else 
      {      
        document.getElementById("txtMHSTyp").disabled="";      
        //document.getElementById("txtMHSTyp").value = ''; commented by devendra
      }
   }
   
  //alert('inside checkEmpType function............frmEmpFinInfoForm.txtEmpTypeId.value:::'+frmEmpFinInfoForm.txtEmpTypeId.value+' and frmEmpFinInfoForm.txtCateg.value :::'+frmEmpFinInfoForm.txtCateg.value +' and document.all.screenMode.value :::'+document.all.screenMode.value);
  if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DOTHRORG'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DTOORG')
   {
		if(frmEmpFinInfoForm.txtCateg.value == "EMPCTGRY$I")
		{
			  document.all.parentZone.value=""; 
			  document.all.parentZone.disabled="true";   
			  //document.getElementById("parentZone").style.background="#ffffff";
			  //document.getElementById("parentZone").style.className="optional";
			  document.all.txtEmpStatus.disabled="true";
			  if(document.all.screenMode.value=='N')
			  {
				document.getElementById("txtDepuType").disabled = "";
				document.all.txtEmpStatus.value="EMPSTATUS$DEPU";
			  }
		}
		else 
		{ 
			  document.all.parentZone.value="";   
			  document.all.parentZone.disabled="";      
			  document.all.txtEmpStatus.value= "" ;
			  document.all.txtEmpStatus.disabled = "";
		}
   }
   else if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$REG')
   {
		document.all.txtEmpStatus.disabled="true";    
		if(frmEmpFinInfoForm.txtCateg.value == "EMPCTGRY$I")
		{
		  document.all.parentZone.value="0";
		  document.all.parentZone.disabled="true";
		}
		else
		{ 
		  //document.all.parentZone.value="";  commented by devendra
		  document.all.parentZone.disabled="";
		}      
		if(document.all.screenMode.value=='N')
		{      
		  document.all.txtEmpStatus.value="EMPSTATUS$PERM";
		}	
   }
   else if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$FOODTRNS')
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
		  document.all.txtEmpStatus.value= "" ;   
		  document.all.txtEmpStatus.disabled = "";     
		}
  }
  
  document.getElementById("parentZone").style.background="#ffffd3";
  document.getElementById("parentZone").style.className="required";
}

function onLoadcheckEmpType()
{ 
  if(document.all.screenMode.value =='U')
    {
		  if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT')
		  {        
			document.getElementById("txtMHSTyp").disabled="true";
		  }
		  else 
		  {      
			document.getElementById("txtMHSTyp").disabled="";              
		  }
   }
   if(document.all.screenMode.value =='N')
    {
		  if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT')
		  {     
			document.getElementById("txtMHSTyp").value = 'N';      
			document.getElementById("txtMHSTyp").disabled="true";
		  }      
   }
  //alert('inside onLoadcheckEmpType function............frmEmpFinInfoForm.txtEmpTypeId.value:::'+frmEmpFinInfoForm.txtEmpTypeId.value+' and frmEmpFinInfoForm.txtCateg.value :::'+frmEmpFinInfoForm.txtCateg.value +' and document.all.screenMode.value :::'+document.all.screenMode.value);
  if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DCGOVT'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DOTHRORG'||frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$DTOORG')
   {
		if(frmEmpFinInfoForm.txtCateg.value == "EMPCTGRY$I")
		{
		  document.all.parentZone.value=""; 
		  document.all.parentZone.disabled="true";         
		  document.all.txtEmpStatus.disabled="true";
		  if(document.all.screenMode.value=='N')
		  {
			document.getElementById("txtDepuType").disabled = "";
			document.all.txtEmpStatus.value="EMPSTATUS$DEPU";
		  }
		}    
   }
   
   if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$REG' || 'PROMTYPE$ADHOC' || 'PROMTYPE$DEPLOY' )
   {
		document.all.txtEmpStatus.disabled="true";    
		if(frmEmpFinInfoForm.txtCateg.value == "EMPCTGRY$I")
		{
			
				


			var sysdate=new Date();
			var months = ['Jan', 'Feb', 'Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'];
			var newDate= sysdate.getDate()+'-'+months[sysdate.getMonth()]+'-'+sysdate.getYear();
            
		
			var dob= document.all.txtDOB.value
			var dobyr=dob.substring(7,11);
			
			var dobmth=dob.substring(3,6);
               
				 var dobdt=dob.substring(0,2);
				        
					       var newyr=Number(dobyr) + 59;
						 
              findt=dobdt+'-'+dobmth+'-'+newyr;
			
 

			var retdt=document.all.txtRetireDate.value;
		


   var date1=new Date(findt.replace(/[-]/g," "));
   

var date2=new Date(newDate.replace(/[-]/g," "));
  
if(date2.getTime() > date1.getTime())
			
			
			{
				
			
		  document.all.parentZone.disabled="true";
			}
			else
			{
          
		   document.all.parentZone.value="0";
		  document.all.parentZone.disabled="true";
			}
	
			
		} 
   }
   if(frmEmpFinInfoForm.txtEmpTypeId.value=='EMPTYPE$FOODTRNS') 
   {    
		if(frmEmpFinInfoForm.txtCateg.value == "EMPCTGRY$I")
		{
		  document.all.parentZone.value="0";
		  document.all.parentZone.disabled="true";
		} 
   }
	   document.getElementById("parentZone").style.background="#ffffd3";
	   document.getElementById("parentZone").style.className="required";     
}

function checkDepuType()
{
    if (document.all.txtEmpStatus.value=="EMPSTATUS$DEPU")
    {      
       document.getElementById("txtDepuType").style.background="#ffffd3";
       document.getElementById("txtDepuType").style.className="required";           
    }  
    else 
    {     
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

function checkCPFVal()
{
  if(document.all.tmpCpfFlg.value=='N' || document.all.tmpCpfFlg.value=='')
  {
    document.all.txtCpfCode.readOnly = false;
    document.getElementById("txtCpfCode").style.background="#ffffd3";
  }
  else
  {
    document.all.txtCpfCode.readOnly = true;    
    document.getElementById("txtCpfCode").style.background="#e0e0e0";
  }
  
}

function checkPFType()
{     
    if (document.all.txtPFType.value=='PFTYPE$CPF' || document.all.txtPFType.value=='')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';        
    }
    if (document.all.txtPFType.value=="PFTYPE$GPF")
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none';  
         document.getElementById("txtUanNum").style.background="#e0e0e0";
       document.getElementById("txtUanNum").style.className="locked"; 
       document.getElementById("txtUanNum").disabled = "true";
    }    
}  

function onChangePFType(val)
{   
    if (val=='PFTYPE$GPF')
    {
        document.getElementById("gpf").style.display='';
        document.getElementById("cpf").style.display='none'; 
         document.getElementById("txtUanNum").style.background="#e0e0e0";
       document.getElementById("txtUanNum").style.className="locked"; 
       document.getElementById("txtUanNum").disabled = "true";
    }
    if (val=='PFTYPE$CPF')
    {
        document.getElementById("cpf").style.display='';
        document.getElementById("gpf").style.display='none';        
    } 
}

function checkPayMode()
{
    if (document.all.txtPayMode.value=="O")
    {

        document.getElementById("txtPayModeType").disabled = "";
        document.getElementById("txtPayModeType").style.background="#ffffd3";
        document.getElementById("txtPayModeType").style.className="required";
        
        document.getElementById("txtBankDesc").style.background="#ffffff";
        document.getElementById("txtBankDesc").style.className="optional";
        
        document.getElementById("txtBranchDesc").style.background="#ffffff";
        document.getElementById("txtBranchDesc").style.className="optional";
        
        document.getElementById("txtBankAccNo").style.background="#ffffff";
        document.getElementById("txtBankAccNo").style.className="optional";
        if(frmEmpFinInfoForm.txtPayModeType.value=='ESC')
        {
            document.getElementById("txtBankDesc").disabled = "";
            document.getElementById("txtBankDesc").style.background="#ffffd3";
            document.getElementById("txtBankDesc").style.className="required";
            document.getElementById("txtBranchDesc").disabled = "";
            document.getElementById("txtBranchDesc").style.background="#ffffd3";
            document.getElementById("txtBranchDesc").style.className="required";
            document.getElementById("txtBankAccNo").disabled = "";
            document.getElementById("txtBankAccNo").style.background="#ffffd3";
            document.getElementById("txtBankAccNo").style.className="required";
        }
    }  
    else if (document.all.txtPayMode.value=="B")
    {
        document.getElementById("txtPayModeType").disabled = "true";
        document.getElementById("txtPayModeType").selectedIndex = "0";
        document.getElementById("txtPayModeType").style.background="#ffffff";
        document.getElementById("txtPayModeType").style.className="optional"; 
        document.getElementById("txtBankDesc").disabled = "";
        document.getElementById("txtBankDesc").style.background="#ffffd3";
        document.getElementById("txtBankDesc").style.className="required";
        document.getElementById("txtBranchDesc").disabled = "";
        document.getElementById("txtBranchDesc").style.background="#ffffd3";
        document.getElementById("txtBranchDesc").style.className="required";
        document.getElementById("txtBankAccNo").disabled = "";
        document.getElementById("txtBankAccNo").style.background="#ffffd3";
        document.getElementById("txtBankAccNo").style.className="required";
    }
    else 
    {
        document.getElementById("txtPayModeType").disabled = "true";
        document.getElementById("txtPayModeType").selectedIndex = "0";
        document.getElementById("txtPayModeType").style.background="#ffffff";
        document.getElementById("txtPayModeType").style.className="optional"; 
        
        document.getElementById("txtBankCode").value = "";
        document.getElementById("txtBankDesc").value = "";
        document.getElementById("txtBankDesc").style.background="#ffffff";
        document.getElementById("txtBankDesc").style.className="optional";
        
        document.getElementById("txtBranchCode").value = "";
        document.getElementById("txtBranchDesc").value = "";
        document.getElementById("txtBranchDesc").style.background="#ffffff";
        document.getElementById("txtBranchDesc").style.className="optional";
        
        document.getElementById("txtBankAccNo").value = "";
        document.getElementById("txtBankAccNo").style.background="#ffffff";
        document.getElementById("txtBankAccNo").style.className="optional";
    }    
}

function onChangePModeType()
{   
  
    comboChange();
    if (frmEmpFinInfoForm.txtPayMode.value == 'O' && frmEmpFinInfoForm.txtPayModeType.value=='ECS')
    {     
       document.getElementById("txtBankDesc").disabled = "";
       document.getElementById("txtBankDesc").style.background="#ffffd3";
       document.getElementById("txtBankDesc").style.className="required"; 
       document.getElementById("txtBranchDesc").disabled = "";
       document.getElementById("txtBranchDesc").style.background="#ffffd3";
       document.getElementById("txtBranchDesc").style.className="required";
       document.getElementById("txtBankAccNo").disabled = "";
       document.getElementById("txtBankAccNo").style.background="#ffffd3";
       document.getElementById("txtBankAccNo").style.className="required";
    }  
    else 
    {  
       document.getElementById("txtBankCode").value = "";
       document.getElementById("txtBankDesc").value = "";
       document.getElementById("txtBankDesc").style.background="#ffffff";
       document.getElementById("txtBankDesc").style.className="optional";  
       
       document.getElementById("txtBranchCode").value = "";
       document.getElementById("txtBranchDesc").value = "";
       document.getElementById("txtBranchDesc").style.background="#ffffff";
       document.getElementById("txtBranchDesc").style.className="optional";
       
       document.getElementById("txtBankAccNo").value = "";
       document.getElementById("txtBankAccNo").style.background="#ffffff";
       document.getElementById("txtBankAccNo").style.className="optional";
    }    
}

function lfnChange(val)
{
    if(num_Check(val,1))
        frmEmpFinInfoForm.headerDataChanged.value = "true";
    else
    {
        event.srcElement.select();
        event.srcElement.focus();
        event.returnValue=false;
    }
}

function lfnChanged(val)
{
	
    frmEmpFinInfoForm.headerDataChanged.value = "true";
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

function comboChange(val)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function doOnChangeCalendar(buttonName)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
}

function getHeaderRecord()
{    
    document.all.buttonFlag.value='';    
    document.all.txtEmpStatus.disabled=''; 
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.action="../../../EmpFinFirstGetHeaderAction.do"
    frmEmpFinInfoForm.submit();
}

function doGetNextHeader()
{ 
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value + 1;
    frmEmpFinInfoForm.action="../../../EmpFinGetNextHeader.do";
    frmEmpFinInfoForm.submit();
}

function PrevHeader()
{
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
    frmEmpFinInfoForm.userPositionRequested.value = 1*frmEmpFinInfoForm.positionRequested.value - 1;
    frmEmpFinInfoForm.action = "../../../EmpFinGetPrevHeader.do";
    frmEmpFinInfoForm.submit();
}

function JumpHeader()
{   
    document.all.buttonFlag.value='';
    document.all.forwardedPage.value='';
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
    if(document.all.screenMode.value=='N')
      document.all.forwardedPage.value='';
    frmEmpFinInfoForm.action="../../../EmpFinRefresh.do"
    frmEmpFinInfoForm.submit();
}

function SaveRecord()
{
    //alert('inside save , value of payscale code is :::'+document.all.txtPayScaleCode.value);
	document.all.buttonFlag.value='';   
    if (frmEmpFinInfoForm.txtCateg.value != "EMPCTGRY$I" && (document.all.parentZone.value==0 || document.all.parentZone.value==''))
    {
        alert("Parent Zone is not Valid, Please Select Correct value");      
        document.all.parentZone.disabled="";    
        return false;
    }
    
    
    if (frmEmpFinInfoForm.txtEmpStatus.value=='EMPSTATUS$DEPU')
    {
        if (document.getElementById("txtDepuType").value ==" " || document.getElementById("txtDepuType").value =='')
        {
            alert("Deputation Type is Mandatory if Employee Status is Deputation");
            frmEmpFinInfoForm.txtDepuType.focus(); 
            return false;
        }
    }
    else
    {
        document.getElementById("txtDepuType").disabled = "false";
        document.getElementById("txtDepuType").value = "";
    }
    
   
          
    if(mandatory_Check("frmEmpFinInfoForm"))
    {     
		if (!validateCadr()) return;
        frmEmpFinInfoForm.txtEmpNo.value=frmEmpFinInfoForm.headerPrimaryKey.value;         
       
      
        document.all.parentZone.disabled=""; 
        document.all.txtDepuType.disabled="";
        document.all.txtEmpStatus.disabled="";
        document.getElementById("txtMHSTyp").disabled="";
        document.getElementById("txtHandiType").disabled = false;
        document.getElementById("txtCasteCateg").disabled = false;
        document.getElementById("txtReligion").disabled = false;
        document.getElementById("txtExsrvcman").disabled = false;
        document.getElementById("txtAadharNum").disabled = false;
        document.getElementById("txtUanNum").disabled = false;
        
        if (frmEmpFinInfoForm.txtPayMode.value == "C")
        {
            frmEmpFinInfoForm.txtPayModeType.value="";  
        }
        if (frmEmpFinInfoForm.txtPayMode.value == "B")    
        {
            frmEmpFinInfoForm.txtPayModeType.value="";  
        }       
        
        frmEmpFinInfoForm.detailDataChanged.value = "false";  
        
            frmEmpFinInfoForm.headerDataChanged.value = "true";    
        frmEmpFinInfoForm.headerFields.value = "true";    
        if(frmEmpFinInfoForm.txtGender.value=="")
        {
            alert("Mandatory Field Gender in HRMS Details is Empty! ");
            return;
        }

        saveCheckBox();
        document.all.txtSplDtyAllowArea.disabled="";
        frmEmpFinInfoForm.resetFlag.value ='false';
		document.all.butSave.disabled="true";
		document.all.txtEpsFlag.disabled="";
		document.all.butEpsEntDt.disabled="";
		document.all.txtFpsNo.disabled="";
        document.getElementById("txtPayStatus").disabled="";   // Added by dushyant on 17-May-2013
		document.all.butSave.src="../INCLUDES/IMAGES/save_dis.jpg";
        frmEmpFinInfoForm.action = "../../../EmpFinSaveAction.do";              
      
        frmEmpFinInfoForm.submit();
    }
    
    else
    {
        return false;
    }
}

function SavePayrollTabData()
{
    document.all.buttonFlag.value='';

    if (frmEmpFinInfoForm.txtEmpStatus.value=='EMPSTATUS$DEPU')
    {
        if (document.getElementById("txtDepuType").value ==" " || document.getElementById("txtDepuType").value =='')
        {
            alert("Deputation Type is Mandatory if Employee Status is Deputation");
            frmEmpFinInfoForm.txtDepuType.focus(); 
            return false;
        }
    }
    else
    {
        document.getElementById("txtDepuType").disabled = "false";
        document.getElementById("txtDepuType").value = "";
    }     
   
    if (frmEmpFinInfoForm.txtPayMode.value == 'O' && frmEmpFinInfoForm.txtPayModeType.value=='ESC')
    {
        if (frmEmpFinInfoForm.txtBankCode.value == '')
        {
            alert("Mandatory Field Bank Code is Empty!");
            frmEmpFinInfoForm.txtBankDesc.focus(); 
            return false;
        }
        if (frmEmpFinInfoForm.txtBranchCode.value == '')
        {
            alert("Mandatory Field Branch Code is Empty!");
            frmEmpFinInfoForm.txtBranchDesc.focus(); 
            return false;
        }    
        if (frmEmpFinInfoForm.txtBankAccNo.value == '')
        {
            alert("Mandatory Field Bank Account Number is Empty!");
            frmEmpFinInfoForm.txtBankAccNo.focus(); 
            return false;
        }        
    }
        
    if(mandatory_Check("frmEmpFinInfoForm"))
    {     
        frmEmpFinInfoForm.txtEmpNo.value=frmEmpFinInfoForm.headerPrimaryKey.value; 
        if (frmEmpFinInfoForm.txtPayMode.value == "C")
        {
            frmEmpFinInfoForm.txtPayModeType.value="";  
        }
        if (frmEmpFinInfoForm.txtPayMode.value == "B")    
        {
            frmEmpFinInfoForm.txtPayModeType.value="";  
        }       
        
        frmEmpFinInfoForm.detailDataChanged.value = "false";  
        if(frmEmpFinInfoForm.screenMode.value == "N")
            frmEmpFinInfoForm.headerDataChanged.value = "false";    
        frmEmpFinInfoForm.headerFields.value = "true";        
        return true;
    }
    
    else
    {
        return false;
    }
}

function checkCurBasicLimit()
{
    var curBasic;
    var startBasic;
    var endBasic;
    var curBasic;
	
    curBasic = parseInt(frmEmpFinInfoForm.txtCurtBasic.value);
    startBasic =parseInt(frmEmpFinInfoForm.hdnStartBasic.value); 
    endBasic = parseInt(frmEmpFinInfoForm.hdnEndBasic.value);
	//alert('inside checkCurBasicLimit function. value of curBasic:'+curBasic+',startBasic:'+startBasic+', endBasic:'+endBasic);
    if(curBasic < startBasic || curBasic > endBasic)
    {
        alert("Current Basic Should be In Range "+startBasic+" To "+endBasic);
        frmEmpFinInfoForm.txtCurtBasic.select();
        frmEmpFinInfoForm.txtCurtBasic.focus();
        return false;
    }    
    else
        return true;
}



function saveCheckBox()
{      
	//alert('saveCheckBox() in empfinanceINfo.js')
    if (document.getElementById("selectNpa").checked==true)
    {        
        document.all.hdnNpaFlag.value="Y";
    }
    else 
    {      
        document.all.hdnNpaFlag.value="N";
    }
 
    if (document.getElementById("selectCant").checked==true)
    {        
        document.all.hdnCantFlag.value="Y";
    }
    else 
    {      
        document.all.hdnCantFlag.value="N";
    }
 
    if (document.getElementById("selectWash").checked==true)
    {        
        document.all.hdnWashFlag.value="Y";
    }
    else 
    {      
        document.all.hdnWashFlag.value="N";
    }
 
    if (document.getElementById("selectCCAFlag").checked==true)
    {        
        document.all.hdnCCAFlag.value="Y";
    }
    else 
    {      
        document.all.hdnCCAFlag.value="N";
    }   
    
    if (document.getElementById("selectPLI").checked==true)
    {        
        document.all.hdnPLIFlag.value="Y";        
    }
    else 
    {      
        document.all.hdnPLIFlag.value="N";
    }    
    
    if (document.getElementById("selectConvFlag").checked==true)
    {        
        document.all.hdnConvFlag.value="Y";
    }
    else 
    {      
        document.all.hdnConvFlag.value="N";
    }
    
    if (document.getElementById("selectDustOpAllow").checked==true)
    {        
        document.all.hdnDustOpAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnDustOpAllowFlag.value="N";
    }
    
    if (document.getElementById("selectStationComp").checked==true)
    {        
        document.all.hdnStationCompFlag.value="Y";
    }
    else 
    {      
        document.all.hdnStationCompFlag.value="N";
    }
    
    if (document.getElementById("selectDblHraFlag").checked==true)
    {        
        document.all.hdnDblHraFlag.value="Y";
    }
    else 
    {      
        document.all.hdnDblHraFlag.value="N";
    }
    
    if (document.getElementById("selectSplPaySprt").checked==true)
    {        
        document.all.hdnSplPaySprtFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplPaySprtFlag.value="N";
    }
    
    if (document.getElementById("selectSplPayCshAllow").checked==true)
    {        
        document.all.hdnSplPayCshAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplPayCshAllowFlag.value="N";
    }
    
    if (document.getElementById("selectPersPaySFN").checked==true)
    {        
        document.all.hdnPersPaySFNFlag.value="Y";
    }
    else 
    {      
        document.all.hdnPersPaySFNFlag.value="N";
    }
    
    if (document.getElementById("selectPersPayHQua").checked==true)
    {        
        document.all.hdnPersPayHQuaFlag.value="Y";
    }
    else 
    {      
        document.all.hdnPersPayHQuaFlag.value="N";
    }
    
    if (document.getElementById("selectSplCmpAllow").checked==true)
    {        
        document.all.hdnSplCmpAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplCmpAllowFlag.value="N";
    }

    if (document.getElementById("selectPersPayHndQua").checked==true)
    {        
        document.all.hdnPersPayHndQuaFlag.value="Y";
    }
    else 
    {      
        document.all.hdnPersPayHndQuaFlag.value="N";
    }
    
    if (document.getElementById("selectSplDtyAllow").checked==true)
    {        
        document.all.hdnSplDtyAllowFlag.value="Y";
    }
    else 
    {      
        document.all.hdnSplDtyAllowFlag.value="N";
    }    
    
}


function disable()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    if (document.all.selectChEdAl.checked==true)
    {
        document.all.selectChEdAl.value="Y";
        if(document.all.selectChEdAl.value=="Y")
        {
        document.getElementById("txtNoc").disabled = "";
        document.getElementById("txtNoc").style.background="#ffffd3";
        document.getElementById("txtNoc").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtNoc").disabled = "true"; 
        document.getElementById("txtNoc").value = "";     
        document.getElementById("txtNoc").style.background="#e0e0e0";
        document.getElementById("txtNoc").style.className="locked";       
    }
}

function HosDisab()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    if (document.all.selectHos.checked==true)
    {
        document.all.selectHos.value="Y";
        if(document.all.selectHos.value=="Y")
        {
        document.getElementById("txtHosChld").disabled = "";
        document.getElementById("txtHosChld").style.background="#ffffd3";
        document.getElementById("txtHosChld").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtHosChld").disabled = "true";
        document.getElementById("txtHosChld").value = "";
        document.getElementById("txtHosChld").style.background="#e0e0e0";
        document.getElementById("txtHosChld").style.className="locked";       
    }
}

function CantDisab()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    if (document.all.selectCant.checked==true)
    {
        document.all.selectCant.value="Y";
        if(document.all.selectCant.value=="Y")
        {
        document.getElementById("txtCantRate").disabled = "";
        document.getElementById("txtCantRate").style.background="#ffffd3";
        document.getElementById("txtCantRate").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtCantRate").disabled = "true";
        document.getElementById("txtCantRate").value = "";
        document.getElementById("txtCantRate").style.background="#ffffff";
        document.getElementById("txtCantRate").style.className="optional";       
    }
}

function GisDisab()
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    if (document.all.selectGisRec.checked==true)
    {
        document.all.selectGisRec.value="Y";
        if(document.all.selectGisRec.value=="Y")
        {
        document.getElementById("txtGisType").disabled = "";
        document.getElementById("txtGisType").style.background="#ffffd3";
        document.getElementById("txtGisType").style.className="required";       
        }
    }  
    else 
    {
        document.getElementById("txtGisType").disabled = "true";
        document.getElementById("txtGisType").value = "";
        document.getElementById("txtGisType").style.background="#ffffff";
        document.getElementById("txtGisType").style.className="optional";       
    }
}

String.prototype.endsWith = function(str) 
{return (this.match(str+"$")==str)}

//Function to enabled the control box if check box is selected
function cmnFlagTxtDisab(argFlag,argTxt)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    var arrArgTxt=argTxt.split(",");
    if (document.getElementById(argFlag).checked==true)
    {
        document.getElementById(argFlag).value="Y";        
        if(document.getElementById(argFlag).value=="Y")
        {
            for(i=0;i<arrArgTxt.length;i++)
            {
              if(arrArgTxt[i].endsWith('Till'))
              {
                document.getElementById(arrArgTxt[i]).disabled = "";
                document.getElementById(arrArgTxt[i]).style.background="#ffffff";
                document.getElementById(arrArgTxt[i]).style.className="optional"
              }else
              {
                document.getElementById(arrArgTxt[i]).disabled = "";
                document.getElementById(arrArgTxt[i]).style.background="#ffffd3";
                document.getElementById(arrArgTxt[i]).style.className="required"; 
              }
             }
        }
    }  
    else 
    {        
        document.getElementById(argFlag).value="N";
        for(i=0;i<arrArgTxt.length;i++)
        {
          document.getElementById(arrArgTxt[i]).disabled = "true";
          document.getElementById(arrArgTxt[i]).value = "";        
          document.getElementById(arrArgTxt[i]).style.background="#e0e0e0";
          document.getElementById(arrArgTxt[i]).style.className="locked"; 
        }
    }
}

//Function to enabled the control box and display LOV Image if check box is selected
function cmnFlagTxtImgDisab(argFlag,argTxt)
{       
    frmEmpFinInfoForm.headerDataChanged.value = "true";    
    if (document.getElementById(argFlag).checked==true)
    {
        document.getElementById(argFlag).value="Y";        
        if(document.getElementById(argFlag).value=="Y")
        {
            document.getElementById(argTxt).disabled = "";
            document.getElementById("buttxtDblHraCity").disabled = "";            
            document.getElementById(argTxt).style.background="#ffffd3";
            document.getElementById(argTxt).style.className="required";       
        }
    }  
    else 
    {
        document.getElementById(argTxt).disabled = "true";
        document.getElementById("buttxtDblHraCity").disabled = "true";
        document.getElementById(argFlag).value="N";
        document.getElementById(argTxt).value = "";        
        document.getElementById(argTxt).style.background="#e0e0e0";
        document.getElementById(argTxt).style.className="locked"; 
    }
}

//Function to enabled the control box and date field if check box is selected
function advIncFlagTxtDisab(argFlag,argTxt,argDate)
{
    frmEmpFinInfoForm.headerDataChanged.value = "true";
    if (document.getElementById(argFlag).checked==true)
    {
        document.getElementById(argFlag).value="Y";        
        if(document.getElementById(argFlag).value=="Y")
        {
            document.getElementById(argTxt).disabled = "";
            document.getElementById(argTxt).style.background="#ffffd3";
            document.getElementById(argTxt).style.className="required";       
            document.getElementById(argDate).disabled = "";
            document.getElementById(argDate).style.background="#ffffd3";
            document.getElementById(argDate).style.className="required";
        }
    }  
    else 
    {
        document.getElementById(argFlag).value="N";        
        document.getElementById(argTxt).disabled = "true";
        document.getElementById(argTxt).value = "";
        document.getElementById(argTxt).style.background="#e0e0e0";
        document.getElementById(argTxt).style.className="locked";       
        document.getElementById(argDate).disabled = "true";
        document.getElementById(argDate).value = "";
        document.getElementById(argDate).style.background="#e0e0e0";
        document.getElementById(argDate).style.className="locked";
    }
}
function DepuFlag()
{
    if (document.all.selectDep.checked==true)
        document.getElementById("selectOut").disabled = "";
    else
    {
        document.getElementById("selectOut").disabled = "disabled"; 
        document.getElementById("selectOut").checked="";
    }
}

function showCalendar(inputId, butId) 
{  
    if(butId.alt)
    {
        iIndex=butId.alt;
    }
    else
    {
        iIndex="-1";
    }
    Calendar.setup({inputField	: inputId,
    ifFormat	: "%d-%b-%Y",
    button	: butId,
    position: iIndex
    });        
    return false;
}

function disAdvIncrCal(inputId, butId)
{  
 if(document.getElementById("selectAdvIncr").checked= "true");  
    showCalendar(inputId, butId);
 
}
function doGetTab(arg)
{  
    mode = document.all.screenMode.value;      
    if(mode == 'N' || mode == 'U')
    { 
      if(mode=='N')
      {
      
      }
	  document.getElementById("txtPayStatus").disabled= "";   // Added by dushyant on 18-May-2013
      document.all.hdnPLIFlag.value=frmEmpFinInfoForm.hdnBoardFlag.value=='N'? 'Y' : 'N';
      document.all.forwardedPage.value=arg;
      showDiv(arg);           
      
    }
    else
    {
        document.all.forwardedPage.value=arg;
        showDiv(arg);
    }
}

function doGetTabs(arg)
{
    document.all.forwardedPage.value=arg;
    document.forms[0].action="../../../EmpInfoFlagTabAction.do";
    document.forms[0].submit(); 
}

function checkDojFci(cdate)
{
    if (trim(cdate) == "")
    {
        return true;
    }    
    firstIndex=cdate.indexOf("-");
    lastIndex=cdate.lastIndexOf("-");
    var dojSite=cdate;
    if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
    {
        var arr=cdate.split("-");
        var cyear= arr[2];
        var lyear=1990;                
        var monIndx=getMonthIndx(arr[1]);
        var lmonthIndx=parseInt(01);
        var ldayIndx=parseInt(01);
        if(monIndx!=-1)
        {
            cdate = arr[0] + "/" + monIndx + "/" + cyear;  		
            udate = ldayIndx + "/" + lmonthIndx + "/" + lyear;  		
        }    
    }
    //cdate = change_DateFormat(cdate);  
    sysDate = getSysDate(); 
    if (dateDiff(udate, cdate) < 0 || dateDiff(sysDate, cdate) >0)
    {
        alert("Date Of Joining FCI Cannot be Less then 1990! or Greater then Current Date");
        frmEmpFinInfoForm.txtDojFCI.select();
        frmEmpFinInfoForm.txtDojFCI.focus();
        frmEmpFinInfoForm.txtDojFCI.value="";
        return false;
    }
    document.all.txtDOJSite.value=dojSite;
    return true;
}

function checkPostDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtDOJSite.value="";     
        return false;
    }    
}

function checkPayStatDate(val)
{
    var systDate = getSysDate();      
    if(cmpDateMsg(val,document.all.txtDojFCI.value,1,"Date cannot be Less than the Date of Joining FCI!" ) && cmpDateMsg(val,systDate,0,"Date cannot be Greater then Current Date!"))
    {
        return true;        
    }
    else
    {
        document.all.txtPayStsChnDate.value="";     
        return false;
    }    
}



function checkHandicap()
{
    if (document.all.txtHandi.value=="Y")
    {
       document.getElementById("txtHandiEffDate").disabled = "";
       document.getElementById("txtHandiEffDate").style.background="#ffffd3";
       document.getElementById("txtHandiEffDate").className="required";  
        
       document.getElementById("txtHandiType").disabled = "";
       document.getElementById("txtHandiType").style.background="#ffffd3";
       document.getElementById("txtHandiType").className="required";
    }  
    else 
    {       
       document.all.txtHandi.value="N"
       document.getElementById("txtHandiEffDate").value = "";
       document.getElementById("txtHandiEffDate").style.background="#e0e0e0";
       document.getElementById("txtHandiEffDate").style.className="locked"; 
       document.getElementById("txtHandiType").disabled = true;
       document.getElementById("txtHandiType").value = "";
       document.getElementById("txtHandiType").style.background="#e0e0e0";
       document.getElementById("txtHandiType").style.className="locked";  
       document.getElementById("txtHandiType").disabled = true;
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
//13-11-2019 AMRESH 
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
		var uEpsyear =parseInt(cyear)+58;
		var epsDate;
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
			epsDate = arr[0] + "/" + monIndx + "/" + uEpsyear;
        }    
    }
    //cdate = change_DateFormat(cdate);  
    sysDate = getSysDate();  	     
    if (dateDiff(sysDate, cdate) > 0 || dateDiff(sysDate, udate) < 0)
    {
        alert("Age cannot be Less than 18 or Greater then 60 Years!");
        document.getElementById("txtDOB").value = ""; 
		document.getElementById("txtRetireDate").value = "";
        return false;
    }    
	
    document.getElementById("txtRetireDate").value = retDate;
	if (dateDiff(sysDate, epsDate) > 0)
	{
		document.getElementById("txtEpsFlag").value = 'N';
		checkEpsFlagOnLoad();
	} 
	if (dateDiff(sysDate, epsDate) < 0)
	{
		document.getElementById("txtEpsFlag").value= 'N';
		checkEpsFlagOnLoad();
	}
		
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

function onclickCheck(checkFlag,hdnFlag)
{
    lfnChange('1');  
    if (document.getElementById(checkFlag).checked==true)
    {
        hdnFlag.value="Y";                
    }  
    else 
    {        
        hdnFlag.value="N";      
    }    
}

function Chk_Char(name)
{
    that=document.getElementsByName(name)[0];    
    str=that.value; 
    for(i=0; i<str.length; i++)
    {
        var txtVal =str.charAt(i);
        if((txtVal >= 'A' && txtVal <= 'Z') ||(txtVal >= 'a' && txtVal <= 'z') || (txtVal == ',') || (txtVal == ' '))
        {}
        else
        {
            alert("Invalid Input");               
            that.select();             
            return true;
        }
    }
}

function checkEpsFlag()
{   var epsFlag = getSafeValue("txtEpsFlag");
  var mode = document.all.screenMode.value;  
  if(epsFlag=='Y')
  {
	if (mode=='U')  //added by swapnendu Dt 08 Apr 2013
	{
		    document.getElementById("butEpsEntDt").disabled="";
			document.getElementById("txtFpsNo").readOnly="";
			document.getElementById("txtEpsEntDt").style.background="#ffffd3";
			document.getElementById("txtEpsEntDt").className="required";
			document.getElementById("txtFpsNo").style.background="#ffffd3";
			document.getElementById("txtFpsNo").className="required";
			if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
    		 document.getElementById("txtFpsNo").className="locked";
				 document.getElementById("txtFpsNo").readOnly="true"; 
				 document.getElementById("txtFpsNo").value = "TEMP";
				 document.getElementById("txtFpsNo").style.background="#e0e0e0";
				}
	}
	if (mode=='N')
	{

		document.getElementById("butEpsEntDt").disabled="";
		document.getElementById("txtEpsEntDt").style.background="#ffffd3";
		document.getElementById("txtEpsEntDt").className="required";
		document.getElementById("txtFpsNo").style.background="#ffffd3";
		document.getElementById("txtFpsNo").className="required";
		document.getElementById("txtFpsNo").disabled="";
		document.getElementById("txtFpsNo").readOnly="";
		 if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
			{
			 document.getElementById("txtFpsNo").className="locked";
			 document.getElementById("txtFpsNo").readOnly="true"; 
			 document.getElementById("txtFpsNo").value = "TEMP"; 
			 document.getElementById("txtFpsNo").style.background="#e0e0e0";
		    }
	}
  }
  else
  {
    document.getElementById("butEpsEntDt").disabled="true";
    document.getElementById("txtEpsEntDt").value = "";
    document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
	document.getElementById("txtEpsEntDt").readOnly = "true";
    document.getElementById("txtEpsEntDt").className="locked";
    document.getElementById("txtFpsNo").style.background="#e0e0e0";
	document.getElementById("txtFpsNo").value = "";
	document.getElementById("txtFpsNo").readOnly = "true";
    document.getElementById("txtFpsNo").className="locked";
	document.getElementById("txtFpsNo").onclick="";
	   if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
			{
			 document.getElementById("txtFpsNo").value = "";   // Added by dushyant on 16-May-2013
		    }
  }
}

function checkEpsFlagOnLoad()  //added by swapnendu Dt 08 Apr 2013
{
	var epsFlag = getSafeValue("txtEpsFlag");
        var mode = document.all.screenMode.value;  
	if(epsFlag=='Y'||epsFlag=='p')
	{
		if (mode=='U') 
		{
			if (document.getElementById("txtEpsEntDt").value=="")
			{
				document.getElementById("butEpsEntDt").disabled="";
				document.getElementById("txtEpsEntDt").style.background="#ffffd3";
				document.getElementById("txtEpsEntDt").className="required";
			}
			else
			{
				document.getElementById("butEpsEntDt").disabled="true";
				document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
				document.getElementById("txtEpsEntDt").readOnly = "true"; 
				document.getElementById("txtEpsEntDt").className="locked";
			}
			if (document.getElementById("txtFpsNo").value=="")
			{
				document.getElementById("txtFpsNo").style.background="#ffffd3";
				document.getElementById("txtFpsNo").className="required";
				document.getElementById("txtFpsNo").disabled="";
				document.getElementById("txtFpsNo").readOnly="";
			}
			else 
			{
				document.getElementById("txtFpsNo").style.background="#e0e0e0";
				document.getElementById("txtFpsNo").readOnly = "true"; 
				document.getElementById("txtFpsNo").className="locked";
				document.getElementById("txtFpsNo").onclick="";
			}
		}
		if (mode=='N')
		{
			document.getElementById("txtEpsFlag").disabled = "true";
			document.getElementById("butEpsEntDt").disabled="";
			document.getElementById("txtEpsEntDt").style.background="#ffffd3";
			document.getElementById("txtEpsEntDt").className="required";
			document.getElementById("txtFpsNo").style.background="#ffffd3";
			document.getElementById("txtFpsNo").className="required";
			document.getElementById("txtFpsNo").disabled="";
			document.getElementById("txtFpsNo").readOnly="";
			if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
				{
				 document.getElementById("txtFpsNo").className="locked";
				 document.getElementById("txtFpsNo").readOnly="true"; 
				 document.getElementById("txtFpsNo").value = "TEMP"; 
				 document.getElementById("txtFpsNo").style.background="#e0e0e0";
				}
		}
	}
	else
	{
		document.getElementById("butEpsEntDt").disabled="true";
		//document.getElementById("txtEpsEntDt").value = "";
		document.getElementById("txtEpsEntDt").style.background="#e0e0e0";
		document.getElementById("txtEpsEntDt").readOnly = "true";
		document.getElementById("txtEpsEntDt").className="locked";
		document.getElementById("txtFpsNo").style.background="#e0e0e0";
		//document.getElementById("txtFpsNo").value = "";
		document.getElementById("txtFpsNo").readOnly = "true";
		document.getElementById("txtFpsNo").className="locked";
		document.getElementById("txtFpsNo").onclick="";
		  if (document.all.txtCpfCode.value=='TEMP') // Added by dushyant on 16-May-2013
			{
			 document.getElementById("txtFpsNo").value = "";   // Added by dushyant on 16-May-2013
		    }
	}
}
function chkDate(fromField,toField)
{
  var fromDt=document.getElementById(fromField).value;
  var toDt=document.getElementById(toField).value;
  if(toDt!='')
  {
  if (!cmpDate(fromDt,toDt,0))
  {
    alert("From Date must be greater than To Date");
    document.getElementById(toField).value="";
    return false;                      
  }
  }
}

function setPayRevChange()
{ 
   //alert('inside setPayRevChange function , document.all.txtPayType.value::'+ document.all.txtPayType.value)
   document.all.hdnTmpPayScaleCode.value=document.all.tmpPayScaleCode.value;
   document.all.hdnTmpGradePay.value=document.all.tmpGradePay.value;
   //alert('document.all.hdnTmpPayScaleCode.value::: '+document.all.hdnTmpPayScaleCode.value+',document.all.hdnTmpGradePay.value::'+document.all.hdnTmpGradePay.value);
 // if(document.all.txtPayType.value=='CDA1') // commented by devendra
	 if(document.all.txtPayType.value=='CDA') // added by devendra
  {
		document.getElementById("old").style.display='none';
		document.getElementById("new").style.display='';
		//if(document.all.screenMode.value=='N')
		//{
		 // document.all.txtPayScaleCode.value=document.all.tmpPayBand.value; commented by devendra
		//  document.all.txtGradePay.value=document.all.tmpGradePay.value;  commented by devendra
		
			//document.all.txtPayScaleCode.value=''; //added by  devendra
			 document.all.txtPayScaleCode.value=document.all.tmpPayScaleCode.value;
			document.all.txtGradePay.value=document.all.tmpGradePay.value;  //added by devendra
		//}
	  }
else
  {
		//alert(' for IDA-> tmpPayScaleCode::'+document.all.tmpPayScaleCode.value+',tmpGradePay::'+document.all.tmpGradePay.value);
		
		document.getElementById("old").style.display='';
		document.getElementById("new").style.display='none';
		//if(document.all.screenMode.value=='N')
		//{
			//alert('setting txtGradePay field to null') 
                        
		  document.all.txtPayScaleCode.value=document.all.tmpPayScaleCode.value;
		  document.all.txtGradePay.value=document.all.tmpGradePay.value; 
		  //document.all.txtGradePay.value='';
		//}

}  
}
function FathHusFlag(name)

{
//alert ("in function");
 frmEmpFinInfoForm.txtFathHusflag.value = name;
//alert (frmEmpFinInfoForm.txtFathHusflag.value);
return success;
}

function epsAgeCal(cdate)
{
var flag=0;
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
		var uEpsyear =parseInt(cyear)+58;
		var epsDate;
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
			epsDate = arr[0] + "/" + monIndx + "/" + uEpsyear;
        }    
    }
    //cdate = change_DateFormat(cdate);  
    sysDate = getSysDate();  	     
    
	
	if (dateDiff(sysDate, epsDate) < 0)
	{
	flag=1;	
	}
		
    return flag;
} 
//wrt MHS CR
   function mhsmember(){
     if(frmEmpFinInfoForm.txtEmpTypeId.value!='NULL')
      {     
        document.getElementById("txtMHSTyp").disabled="true";
      }
      
}

function PranFinLoad()
{
 
	mode = document.all.screenMode.value;     
	//alert(mode);
    if(mode == ''||mode == 'Q')
    {        

            document.getElementById("txtNpsFlag").disabled="true";
            document.getElementById("txtNpsFlag").readOnly="true";
            document.getElementById("txtNpsFlag").style.background="#e0e0e0";
            document.getElementById("txtNpsFlag").style.className="locked";
	    document.getElementById("txtPranNo").style.background="#e0e0e0";
            document.getElementById("txtPranNo").readOnly = "true";
            document.getElementById("txtPranNo").locked="true";
            document.getElementById("txtPranNo").className="locked";
            document.getElementById("txtPranNo").onclick="";
            document.getElementById("txtPranNo").disabled="true";
            document.getElementById("txtPranNo").className="optional";   
    }
    if(mode == 'N')
	{
        if (document.getElementById("txtNpsFlag").value=='N')
        {
		document.getElementById("txtPranNo").disabled="true";
		document.getElementById("txtPranNo").readOnly="true";
		document.getElementById("txtPranNo").style.background="#e0e0e0";
                document.getElementById("txtPranNo").style.className="locked";
                document.getElementById("txtNpsFlag").className="optional";
                document.getElementById("txtPranNo").className="optional";
	}	
	else
        {
            document.getElementById("txtPranNo").style.background="#ffffd3";
            document.getElementById("txtPranNo").className="required";
	    document.getElementById("txtPranNo").disabled="";
	    document.getElementById("txtPranNo").readOnly="";
        }
        
        }
	if (mode=='U')
        
	{   

            if(document.all.txtNpsFlag.value=='N')
		{
//                                document.getElementById("txtNpsFlag").disabled="true";
//                                document.getElementById("txtNpsFlag").readOnly="true";
//                                document.getElementById("txtNpsFlag").style.background="#e0e0e0";
//                                document.getElementById("txtNpsFlag").style.className="locked";
				document.getElementById("txtPranNo").style.background="#e0e0e0";
				document.getElementById("txtPranNo").readOnly = "true";
                                document.getElementById("txtPranNo").locked="true";
				document.getElementById("txtPranNo").className="locked";
				document.getElementById("txtPranNo").onclick="";
                                document.getElementById("txtPranNo").disabled="true";
                                document.getElementById("txtPranNo").className="optional";
                }               
		else if (document.all.txtNpsFlag.value=='Y'||document.all.txtNpsFlag.value=='')
		{
			if (document.getElementById("txtPranNo").value=='')
			{
				document.getElementById("txtPranNo").style.background="#ffffd3";
                                
				document.getElementById("txtPranNo").className="required";
				document.getElementById("txtPranNo").disabled="";
				document.getElementById("txtPranNo").readOnly="";
			}
			else 
			{
                                document.getElementById("txtPranNo").style.background="#ffffd3";
				document.getElementById("txtPranNo").className="optional";
				document.getElementById("txtPranNo").disabled="";
				document.getElementById("txtPranNo").readOnly="";
                        
                                document.getElementById("txtNpsFlag").disabled="true";
                                document.getElementById("txtNpsFlag").readOnly="true";
                                document.getElementById("txtNpsFlag").style.background="#e0e0e0";
                                document.getElementById("txtNpsFlag").style.className="locked";
				document.getElementById("txtPranNo").style.background="#e0e0e0";
				document.getElementById("txtPranNo").readOnly = "true";
                                document.getElementById("txtPranNo").locked="true";
				document.getElementById("txtPranNo").className="locked";
				document.getElementById("txtPranNo").onclick="";
                                document.getElementById("txtPranNo").disabled="true";
                                document.getElementById("txtPranNo").className="optional";
                                
            }
		} 
}
}
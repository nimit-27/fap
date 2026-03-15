contextRoot="/enrgise/";
//******************************************************************************
//                                    HOT KEYS
//******************************************************************************
var keyActions = new Array ();
              
keyActions [0] = {character:  "n", 
                  actionType: "Alt", 
                  param:      "doBaseInsertMode();"};                  
keyActions [1] = {character:  "q", 
                  actionType: "Ctrl", 
                  param:      "doBaseQueryMode();"};
keyActions [2] = {character:  "u", 
                  actionType: "Ctrl", 
                  param:      "doBaseExecute();"};                  
keyActions [3] = {character:  "s", 
                  actionType: "Ctrl", 
                  param:      "doBaseSave();"};                  
keyActions [4] = {character:  "d", 
                  actionType: "Ctrl", 
                  param:      "doBaseDelete();"};                  
keyActions [5] = {character:  "r", 
                  actionType: "Ctrl", 
                  param:      "doBaseRefresh();"};                  
keyActions [6] = {character:  "p", 
                  actionType: "Ctrl", 
                  param:      "doBasePrint();"};                  
keyActions [7] = {character:  "x", 
                  actionType: "Alt", 
                  param:      "doBaseExit();"};                  
keyActions [8] = {character:  "?", 
                  actionType: "Ctrl", 
                  param:      "doBaseHelp();"};                  
keyActions [9] = {character:   188, 
                  actionType: "Ctrl", 
                  param:      "doBasePrevHeader();"};                  
keyActions [10] = {character:  190, 
                  actionType: "Ctrl", 
                  param:      "doBaseNextHeader();"};                  
keyActions [11] = {character:  "g", 
                  actionType: "Ctrl", 
                  param:      "doBaseJumpHeader();"};                  
keyActions [12] = {character:  "t", 
                  actionType: "Ctrl", 
                  param:      "doBaseGetDetail();"};                  
keyActions [13] = {character:  "r", 
                  actionType: "Alt", 
                  param:      "doBaseAddRow();"};                  
keyActions [14] = {character:  "d", 
                  actionType: "Alt", 
                  param:      "doBaseDelRow();"};                  
keyActions [15] = {character:  188, 
                  actionType: "Alt", 
                  param:      "doBasePrevDetail();"};                  
keyActions [16] = {character:  190, 
                  actionType: "Alt", 
                  param:      "doBaseNextDetail();"};                  
keyActions [17] = {character:  "g", 
                  actionType: "Alt", 
                  param:      "doBaseJumpDetail();"}; 

                 
// End of user defined array

function hotKeys (event) {
  var action;
  event = (event) ? event : ((window.event) ? event : null);
  if (event) {   
    if (event.ctrlKey){
      // Pick up the Unicode value of the character of the depressed key.
      
      var charCode = (event.charCode) ? event.charCode : ((event.which) ? event.which : event.keyCode);

      // Convert Unicode character to its lowercase ASCII equivalent
      var myChar = String.fromCharCode (charCode).toLowerCase();
      
      // Convert it back into uppercase if the shift key is being held down
      if (event.shiftKey) {myChar = myChar.toUpperCase();}
      for (var i = 0; i < keyActions.length; i++) {       
           if ( (keyActions[i].character == myChar || keyActions[i].character == charCode ) && keyActions[i].actionType == "Ctrl") { 
               action = new Function (keyActions[i].param);
               action ();
               break;
            }
      }
                        
    } //If event.ctrlKey ends
    if (event.altKey){
      // Pick up the Unicode value of the character of the depressed key.
      var charCode = (event.charCode) ? event.charCode : ((event.which) ? event.which : event.keyCode);
      // Convert Unicode character to its lowercase ASCII equivalent
      var myChar = String.fromCharCode (charCode).toLowerCase();
      // Convert it back into uppercase if the shift key is being held down
      if (event.shiftKey) {myChar = myChar.toUpperCase();}
      for (var i = 0; i < keyActions.length; i++) {       
           if ((keyActions[i].character == myChar || keyActions[i].character == charCode )&& keyActions[i].actionType == "Alt") { 
               action = new Function (keyActions[i].param);
               action ();
               break;
            }
      }                  
    } //If event.altKey ends
  } 
}



//******************************************************************************
//                    CHECK FOR VALIDATIONS
//******************************************************************************


/*   function isValidated(){
  var elems=document.all;
  var sLabel;
  var sDataType;
  var val;

  for(i=0; i<elems.length; i++){
    sLabel=elems[i].title;
    sDataType=elems[i].alt;
    val=Trim(elems[i].value);
    
    //dataType checks
    if(  elems[i].tagName=="INPUT"  && elems[i].type=="text" ){

      //Design time code (delete after coding is completed)
      if(!elems[i].title ){
        alert('title field not properly set for ' + elems[i].name);
        return false;
      }
      if(!elems[i].alt ){
        alert('alt field not set for ' + elems[i].name);
        return false;
      }
      //Design time code ends here
      
    
      //Numeric Check
      if(sDataType=="N"){
        if(!isNumeric(val)){
          alert(sLabel + " should be Numeric");
          elems[i].focus();
          return false;
        }
      }
      
      //Alphanumeric Check
      if(sDataType=="A"){
        if(!isAlphaNumeric(val)){
          alert(sLabel + " should be AlphaNumeric");
          elems[i].focus();
          return false;
        }
      }
      
      //Currency Check
      if(sDataType=="C"){
        if(!isCurrency(val)){
          alert(sLabel + " should be Currency");
          elems[i].focus();
          return false;
        }
      }        
    
      
    }
    
    //Mandatory Check
    if( elems[i].tagName=="INPUT"  || elems[i].tagName=="SELECT" || elems[i].tagName=="TEXTAREA" ){
      if(elems[i].className && elems[i].className=="required"){
        if(val==""){
          alert("Please fill in "+ sLabel);
          elems[i].focus();
          return false;
        }
      }
    }
  }
  return true;
}*/

function isInteger(event) {
  if((event.keyCode < 48 || event.keyCode > 57))
  {
    event.returnValue=false;
  }
}

function LTrim(str){
	if (str==null){return null;}
	for(var i=0;str.charAt(i)==" ";i++);
	return str.substring(i,str.length);
	}
function RTrim(str){
	if (str==null){return null;}
	for(var i=str.length-1;str.charAt(i)==" ";i--);
	return str.substring(0,i+1);
	}
function Trim(str){return LTrim(RTrim(str));}

function isNumeric(val)
{
  if(val=="")
    return true; 
  else
    return new RegExp(/^\d+$/).test(val);
}

function isCurrency(val)
{
  if(val=="")
    return true; 
  else
    return new RegExp(/^\d+(\.\d{2})?$/).test(val);
}

function isAlphaNumeric(val)
{
  if(val=="")
    return true; 
  else
    return new RegExp(/^[A-Za-z0-9]+$/).test(val);
}
  
    









function disable_all(){
  var len=arguments.length;
  var elems=document.all;
  for(i=0; i<elems.length; i++){
    if(elems[i].tagName=="INPUT" || elems[i].tagName=="SELECT" || elems[i].tagName=="TEXTAREA" ){
         for(j=0;j<len;j++){
            if(arguments[j].name==elems[i].name){
              elems[i].disabled=false;
              break;
            }
            else{
              elems[i].disabled=true;
            }
         }
    }
  }
}
           
           
           
           
           
            
function enable_all(){
  var len=arguments.length;
  var elems=document.all;
  for(i=0; i<elems.length; i++){
    if(elems[i].tagName=="INPUT" || elems[i].tagName=="SELECT" || elems[i].tagName=="TEXTAREA" ){
         for(j=1;j<len;j++){
            if(arguments[j].name==elems[i].name){
              elems[i].disabled=true;
              break;
            }
            else{
              elems[i].disabled=false;
            }
         }
    }
  }
} 

//******************************************************************************
//              CHECK/UNCHECK TEXT BOXES IN DETAIL
//******************************************************************************
function toggleCheckBox(chkBoxName){
  var chkBoxes=document.getElementsByName(chkBoxName);
  var chkFlag=document.getElementById("selectAll").checked?true:false;
  for(i=0;i<chkBoxes.length;i++){
    chkBoxes[i].checked=chkFlag;
   if(chkBoxes[i].checked)
    {
      document.getElementsByName("itemChecked")[i].value = "Y";
     }
    else
    {
      document.getElementsByName("itemChecked")[i].value = "N";
     }
   }
}


//***************************************************************************
//                          CALENDAR CONTROL
//****************************************************************************
function showCalendar(inputId, butId) {
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


//***************************************************************************
//                          LOV CONTROL
//****************************************************************************
function showLov(pageName, formName) {
    var oLovWin=window.open(pageName,formName, "height=395,width=600,resizable=yes,menubar=no,toolbar=none,statusbar=none");
    oLovWin.moveTo(200,200);
    //oLovWin.document.all.hdnLOVFlag.value = '0';
}


//These functions are for navigate Buttons
//----------------------------------------
var first_dis="<img alt='First' src='../INCLUDES/IMAGES/butn_first_dis.jpg'  style='CURSOR: default' >";
var first_act="<img alt='First' src='../INCLUDES/IMAGES/butn_first.jpg' hsrc='../INCLUDES/IMAGES/butn_first_act.jpg' style='CURSOR: default' onclick='parent.frmBody.doFirst()'>";
var prev_dis="<img alt='Previous' src='../INCLUDES/IMAGES/butn_prev_dis.jpg' style='CURSOR: default' >";
var prev_act="<img alt='Previous' src='../INCLUDES/IMAGES/butn_prev.jpg' hsrc='../INCLUDES/IMAGES/butn_prev_act.jpg' style='CURSOR: default' onclick='parent.frmBody.doPrev()'>";
var next_dis="<img alt='Next' src='../INCLUDES/IMAGES/butn_next_dis.jpg' style='CURSOR: default' >";
var next_act="<img alt='Next' src='../INCLUDES/IMAGES/butn_next.jpg' hsrc='../INCLUDES/IMAGES/butn_next_act.jpg' style='CURSOR: default' onclick='parent.frmBody.doNext()'>";
var last_dis="<img alt='Last' src='../INCLUDES/IMAGES/butn_last_dis.jpg' style='CURSOR: default'>";
var last_act="<img alt='Last' src='../INCLUDES/IMAGES/butn_last.jpg' hsrc='../INCLUDES/IMAGES/butn_last_act.jpg' style='CURSOR: default' onclick='parent.frmBody.doLast()'>";
 
function NavButtons()
{
  this.firstRec=function fr(){ return (first_dis + prev_dis + next_act + last_act) } 
  this.lastRec=function lr(){ return (first_act + prev_act + next_dis + last_dis) }
  this.midRec=function mr(){ return (first_act + prev_act + next_act + last_act) }
  this.onlyRec=function or(){ return (first_dis + prev_dis + next_dis + last_dis) } 
} 

function firstRec(){ 
  return (first_dis + prev_dis + next_act + last_act) 
} 
function lastRec(){ 
  return (first_act + prev_act + next_dis + last_dis) 
}
function midRec(){
  return (first_act + prev_act + next_act + last_act) 
}
function onlyRec(){
  return (first_dis + prev_dis + next_dis + last_dis) 
}
//---------------------------------------------------

//*************************************************************
//              MODE CHANGE FUNCTIONS 
//*************************************************************
//function doBaseQueryMode() : Changes to Query  Mode.
//--------------------------------------------------------------
function doBaseQueryMode()
{
  if(isClearedToSubmit()){
    document.forms[0].action = contextRoot + doQueryMode();
    document.forms[0].submit();
  }
}

//function doBaseInsertMode() : Changes to Insert Mode.
//--------------------------------------------------------------
function doBaseInsertMode()
{
  if(isClearedToSubmit()){
    document.forms[0].action = contextRoot+ doInsertMode();
    document.forms[0].submit();
  }
}

//*************************************************************
//          EXECUTE,SAVE,DELETE,REFRESH,PRINT FUNCTIONS 
//*************************************************************
//function doBaseExecute() : Gets Header Records for First time.
//------------------------------------------------------------------------

function doBaseExecute()
{
  if(isClearedToSubmit()){
    document.forms[0].action= contextRoot + doExecute();
    document.forms[0].submit();
  }
}

//function doBaseSave() : Gets Header Record as demanded.
//-----------------------------------------------------------------

/*
function doBaseSave()
{

  if(isValidated()){
    document.forms[0].action = contextRoot+ doSave();
    document.forms[0].submit();
  }
}*/

//alternate 
function doBaseSave()
{
  document.forms[0].action = contextRoot+ doSave();
  document.forms[0].submit();
}



//function doBaseDelete() : Delete an entire Record as demanded.
//------------------------------------------------------------------------
function doBaseDelete()
{
  if(isClearedToSubmit()){
    document.forms[0].action = contextRoot+ doDelete();
    document.forms[0].submit();
  }
}

//function doBaseRefresh() : Refresh the data.
//-----------------------------------------------------
function doBaseRefresh()
{
  if(isClearedToSubmit()){
    document.forms[0].action = contextRoot+ doRefresh();
    document.forms[0].submit();
  }
}


//*************************************************************
//              HEADER NAVIGATION FUNCTIONS 
//*************************************************************
//function doBasePrevHeader() : Gets Previous Header Record.
//--------------------------------------------------------------------
function doBasePrevHeader()
{
  if(isClearedToSubmit()){
    document.forms[0].userPositionRequested.value = 1*document.forms[0].positionRequested.value - 1;
    document.forms[0].action = contextRoot+ doPrevHeader();
    document.forms[0].submit();
  }
}

//function doBaseNextHeader() : Gets Next Header Record.
//----------------------------------------------------------------
function doBaseNextHeader()
{  
  if(isClearedToSubmit()){
    document.forms[0].userPositionRequested.value =1*document.forms[0].positionRequested.value + 1;
    document.forms[0].action = contextRoot+ doNextHeader();
    document.forms[0].submit();
  }
}

//function doBaseJumpHeader() : Gets Header Record as demanded.
//-----------------------------------------------------------------------
function doBaseJumpHeader()
{
  if(isClearedToSubmit()){
    if(document.forms[0].newPositionRequested.value!="")
    {
      document.forms[0].userPositionRequested.value = 1*document.forms[0].newPositionRequested.value;
      document.forms[0].action = contextRoot+ doJumpHeader();
      document.forms[0].submit();
    }
  }
  return false;
}


//***********************************************************
//             FOR CHECKING THE MAXLENGTH OF TEXTAREA        
//*************************************************************

function doChangeLength(obj,iLength)
{ 
  
   if(obj.value.length > iLength) {
     alert('Exceeding the limit of the text area!');
      }   
   }
   
   
//*************************************************************
//              DETAIL TABLE FUNCTIONS 
//*************************************************************
//function doBaseGetTab(tabName,action) : Gets the Tab Page.
//----------------------------------------------------------
function doGetTab(tabName,action)
{
  if(isClearedToSubmit()){
    document.forms[0].forwardedPage.value = tabName;
    document.forms[0].action = contextRoot+ action;
    document.forms[0].submit();
  }
}

//function doBaseGetDetail() : Gets the Details for First set.
//----------------------------------------------------------------------
function doBaseGetDetail()
{
  if(isClearedToSubmit()){
    document.forms[0].action=contextRoot+ doGetDetail();
    document.forms[0].submit();
  }
}

//function doBaseAddRow() : Adds a Row in Detail Table.
//---------------------------------------------------------------
function doBaseAddRow()
{
  if(isClearedToSubmit()){
    document.forms[0].action = contextRoot+ doAddRow();
    document.forms[0].submit();
  }
}

//function doBaseDelRow() : Deletes Row/Rows from Detail table.
//-----------------------------------------------------------------------
function doBaseDelRow()
{
  //if(isClearedToSubmit()){
   // var oTable = document.getElementById(doGetDetailTableName());
   // if(oTable == null)
   // {
   //   return;
   // }
   // var iTr2 = oTable.rows.length;
   // var i = 0;
    
   // for(i=0; i < iTr2; i++)
    //{
   //   if(document.getElementsByName("selectAll")[i].checked)
     // {
      //  document.getElementsByName("selectAll")[i].value = "Y";
     // }
   // }
    
    document.forms[0].action = contextRoot+ doDelRow();
    document.forms[0].submit(); 
  //}
}

//function doBasePrevDetail() : Gets Previous Detail Record.
//--------------------------------------------------------------------
function doBasePrevDetail()
{
  if(isClearedToSubmit()){
    document.forms[0].userPageRequested.value = 1*document.forms[0].pageRequested.value - 1;
    document.forms[0].action = contextRoot+ doPrevDetail();
    document.forms[0].submit();
  }
}

//function doBaseNextDetail() : Gets Next Detail Record.
//----------------------------------------------------------------
function doBaseNextDetail()
{
  if(isClearedToSubmit()){
    document.forms[0].userPageRequested.value = 1*document.forms[0].pageRequested.value + 1;
    document.forms[0].action = contextRoot+ doNextDetail();
    document.forms[0].submit();
  }
 }

//function doBaseJumpDetail() : Gets Detail Page Set as demanded.
//-------------------------------------------------------------------------
function doBaseJumpDetail()
{
  if(isClearedToSubmit()){
    document.forms[0].userPageRequested.value =1* document.forms[0].newPageRequested.value;
    document.forms[0].action = contextRoot+ doJumpDetail();
    document.forms[0].submit();
  }
}

//function doChangeHeader() : Sets the Header Modified flag to true.
//-----------------------------------------------------------------------
function doChangeHeader()
{
  if(document.getElementById("screenMode").value!="Q")
  {
    document.getElementById("headerDataChanged").value = "true";
  }
}

//function doChangeDetail(val) : Sets the Detail Status flag.
//-----------------------------------------------------------------------
function doChangeDetail(val)
{
  document.forms[0].detailDataChanged.value = "true";
  //var r=new RegExp(/\d+/);
  //iIndex=parseInt(r.exec(val));
  //alert(val);
  iIndex=val;
  document.forms[0].txtIndex.value=iIndex;
  if(document.getElementsByName("status")[iIndex])
  {
    if(document.getElementsByName("status")[iIndex].value!="N")
    {
      document.getElementsByName("status")[iIndex].value="U";
    }
  }
 
  
}

//function doBaseSetFields(arr,rows,cols) : Returns data to pages from lov.
//-----------------------------------------------------------------------
function doBaseSetFields(arr,rows,cols)
{
  if(window.doSetFields)
  {
    doSetFields(arr,rows,cols);
  }
  else
  {
    alert('doSetFields(arr,rows,cols) function not present in jsp');
  }
  
  
}



function isClearedToSubmit()
{
/*
  if(document.getElementById("headerDataChanged").value == "true" ){
    if(confirm('You have Unsaved Data.\nSave them First?'))
      return false;
    else
      return true;
  } 
   if(document.getElementById("detailDataChanged").value == "true" ){
    if(confirm('You have Unsaved Data.\nSave them First?'))
      return false;
    else
      return true; 
  }
  */
  return true;
  
}


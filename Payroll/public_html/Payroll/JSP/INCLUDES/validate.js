function GetDay(nDay)
{
	var Days = new Array("Sunday","Monday","Tuesday","Wednesday",
	                     "Thursday","Friday","Saturday");
	return Days[nDay]
}

function GetMonth(nMonth)
{
	var Months = new Array("January","February","March","April","May","June",
	                       "July","August","September","October","November","December");
	return Months[nMonth] 	  	 
}

function DateString()
{
	var Today = new Date();
	var suffix = "th";
	switch (Today.getDate())
	{
		case 1:
		case 21:
		case 31: 
			suffix = "st"; break;
		case 2:
		case 22:
			suffix = "nd"; break;
		case 3:
		case 23:
			suffix = "rd"; break;
	};

	//var strDate = GetDay(Today.getDay()) + " " + Today.getDate();
//	strDate += suffix + " " + GetMonth(Today.getMonth()) + ", " + Today.getYear(); 

	var strDate = Today.getDate();
	strDate += suffix + " " + GetMonth(Today.getMonth()) + ", " + Today.getYear(); 

	return strDate
}

// populate data with one search key

function populate(name,value){
return true;
var source;
name=trim(name);
value=trim(value);
source=parent.frames(0).data_ref();
table=name.toString().substr(0,3);
if(value!="" && value!="null"){
var s = source.selectSingleNode('/data/'+table+'//rec['+name+'="'+value+'"]');
if(s!=null){
for(var i=0;i<s.childNodes.length;i++){
		 if(s.childNodes.item(i).getAttribute("id")!=""){if(document.all.item(s.childNodes.item(i).getAttribute("id"))){if(document.all.item(s.childNodes.item(i).getAttribute("id")).disabled==false){document.all.item(s.childNodes.item(i).getAttribute("id")).value=trim(s.childNodes.item(i).childNodes.item(0).nodeValue)=="null"?"":s.childNodes.item(i).childNodes.item(0).nodeValue;}}}
		 else if(document.all.item(s.childNodes.item(i).nodeName)){document.all.item(s.childNodes.item(i).nodeName).value=trim(s.childNodes.item(i).childNodes.item(0).nodeValue)=="null"?"":s.childNodes.item(i).childNodes.item(0).nodeValue;}
		 if(s.childNodes.item(i).getAttribute("ref")!=""){
					 populate(s.childNodes.item(i).getAttribute("ref").toString(),s.childNodes.item(i).childNodes.item(0).nodeValue);
		}
}
window.status=" ";
}
else{
var s = source.selectSingleNode('/data/'+table+'//rec');
for(var i=0;i<s.childNodes.length;i++){
		 if(s.childNodes.item(i).getAttribute("id")!=""){if(document.all.item(s.childNodes.item(i).getAttribute("id"))){if(document.all.item(s.childNodes.item(i).getAttribute("id")).disabled==false){document.all.item(s.childNodes.item(i).getAttribute("id")).value="";}}}
		 else if(document.all.item(s.childNodes.item(i).nodeName)){
		 	  if(!(s.childNodes.item(i).nodeName==event.srcElement.id || s.childNodes.item(i).nodeName==event.srcElement.name)){
			  		 	  document.all.item(s.childNodes.item(i).nodeName).value="";
			  }						  													
		 }
		 if(s.childNodes.item(i).getAttribute("ref")!=""){
					 populate(s.childNodes.item(i).getAttribute("ref").toString(),"");
		}
}
window.status="The Code does not exist in the Masters";
return false;
}
}
else if(value==""){
var s = source.selectSingleNode('/data/'+table+'//rec');
for(var i=0;i<s.childNodes.length;i++){
		 if(s.childNodes.item(i).getAttribute("id")!=""){if(document.all.item(s.childNodes.item(i).getAttribute("id"))){if(document.all.item(s.childNodes.item(i).getAttribute("id")).disabled==false){document.all.item(s.childNodes.item(i).getAttribute("id")).value="";}}}
		 else if(document.all.item(s.childNodes.item(i).nodeName)){
		 	  if(!(s.childNodes.item(i).nodeName==event.srcElement.id || s.childNodes.item(i).nodeName==event.srcElement.name)){
			  		 	  document.all.item(s.childNodes.item(i).nodeName).value="";
			  }						  													
		 }
		 if(s.childNodes.item(i).getAttribute("ref")!=""){
					 populate(s.childNodes.item(i).getAttribute("ref").toString(),"");
		}
}
window.status=" ";
return true;
}
window.status=" ";
return true;
}

// Validate data 

function validate_data(name,value){
return true;
var source;
name=trim(name);
value=trim(value);
source=parent.frames(0).data_ref();
table=name.toString().substr(0,3);

if(value!=""){
var s = source.selectSingleNode('/data/'+table+'//rec['+name+'="'+value+'"]');
if(s!=null){
	window.status=" ";
	return true;
}
else{
if(document.activeElement.name != event.srcElement.id+"_test" && document.activeElement.name != event.srcElement.name.substr(0,event.srcElement.name.lastIndexOf('_'))+"_test"){
alert("The Code does not exist in the Masters");
event.srcElement.focus();
event.srcElement.select();
}
return false;
}
}
window.status=" ";
return true;
}

// Search for a particular data

function search_data(name1,value1,name2){
return true;
var source;
name1=trim(name1);
value1=trim(value1);
name2=trim(name2);
source=parent.frames(0).data_ref();
table1=name1.toString().substr(0,3);
if(value1!=""){
var s = source.selectSingleNode('/data/'+table1+'//rec['+name1+'="'+value1+'"]');
if(s!=null){
for(var i=0;i<s.childNodes.length;i++){
		if(s.childNodes.item(i).nodeName==name2){
				 return trim(s.childNodes.item(i).childNodes.item(0).nodeValue)=="null"?"":s.childNodes.item(i).childNodes.item(0).nodeValue;
		}				 
}
}
else{
window.status="The Code does not exist in the Masters";
return "";
}
}
}

// Search for % given the slabs

function percent_data(name1,value1,name2,value2,amnt,type){
return true;

var source;
name1=trim(name1);
value1=trim(value1);
name2=trim(name2);
value2=trim(value2);
amnt=trim(amnt);
source=parent.frames(0).data_ref();
table=name1.toString().substr(0,3);

if(value1!="" && value2!="" && amnt!=""){
var s = source.selectSingleNode('/data/'+table+'//rec['+name1+'="'+value1+'" $and$ '+name2+'="'+value2+'" $and$ '+type+'_lwr_lmt $le$ '+amnt+' $and$ '+type+'_upr_lmt $ge$ '+amnt+']');
if(s!=null){
for(var i=0;i<s.childNodes.length;i++){
		if(s.childNodes.item(i).nodeName==(type+"_brkrge")){
				 document.all.item(s.childNodes.item(i).nodeName).value=trim(s.childNodes.item(i).childNodes.item(0).nodeValue)=="null"?"":s.childNodes.item(i).childNodes.item(0).nodeValue;
		}				 
}
}
else{
alert('The data does not exist in the Rates Masters');
var s = source.selectSingleNode('/data/'+table+'//rec');
for(var i=0;i<s.childNodes.length;i++){
		if(s.childNodes.item(i).nodeName==(type+"_brkrge")){
				 document.all.item(s.childNodes.item(i).nodeName).value="";
		}				 
}
}
}
else{
var s = source.selectSingleNode('/data/'+table+'//rec');
if(s!=null){
for(var i=0;i<s.childNodes.length;i++){
		if(s.childNodes.item(i).nodeName==(type+"_brkrge")){
		 document.all.item(s.childNodes.item(i).nodeName).value="";
		}				 
}
}

}
}

// populate data with dual search key

function populate_dual(name1,value1,name2,value2){
return true;
var source;
name1=trim(name1);
value1=trim(value1);
name2=trim(name2);
value2=trim(value2);
source=parent.frames(0).data_ref();
table=name1.toString().substr(0,3);

if(value1!="" && value2!=""){
var s = source.selectSingleNode('/data/'+table+'//rec['+name1+'='+value1+' $and$ '+name2+'='+value2+']');
if(s!=null){
for(var i=0;i<s.childNodes.length;i++){
		 if(s.childNodes.item(i).getAttribute("id")!=""){if(document.all.item(s.childNodes.item(i).getAttribute("id"))){if(document.all.item(s.childNodes.item(i).getAttribute("id")).disabled==false){document.all.item(s.childNodes.item(i).getAttribute("id")).value=trim(s.childNodes.item(i).childNodes.item(0).nodeValue)=="null"?"":s.childNodes.item(i).childNodes.item(0).nodeValue;}}}
		 else if(document.all.item(s.childNodes.item(i).nodeName)){document.all.item(s.childNodes.item(i).nodeName).value=trim(s.childNodes.item(i).childNodes.item(0).nodeValue)=="null"?"":s.childNodes.item(i).childNodes.item(0).nodeValue;}
}
}
else{
var s = source.selectSingleNode('/data/'+table+'//rec');
for(var i=0;i<s.childNodes.length;i++){
		 if(s.childNodes.item(i).getAttribute("id")!=""){if(document.all.item(s.childNodes.item(i).getAttribute("id"))){if(document.all.item(s.childNodes.item(i).getAttribute("id")).disabled==false){document.all.item(s.childNodes.item(i).getAttribute("id")).value="";}}}
		 else if(document.all.item(s.childNodes.item(i).nodeName)){document.all.item(s.childNodes.item(i).nodeName).value="";}
}
alert('The data does not exist in the Masters');
return false;
}
}
else{
var s = source.selectSingleNode('/data/'+table+'//rec');
for(var i=0;i<s.childNodes.length;i++){
		 if(s.childNodes.item(i).getAttribute("id")!=""){if(document.all.item(s.childNodes.item(i).getAttribute("id"))){if(document.all.item(s.childNodes.item(i).getAttribute("id")).disabled==false){document.all.item(s.childNodes.item(i).getAttribute("id")).value="";}}}
		 else if(document.all.item(s.childNodes.item(i).nodeName)){document.all.item(s.childNodes.item(i).nodeName).value="";}
}
}
}

// function for when form is submitted

function form_submit(){
var d =document.forms[0];
var validity = validate_form();
return true;
if(validity){
 after_clk();
 d.submit();	
}

}


// function for when form is voided

function form_void(){
return true;
var d =document.forms[0];
document.all.item("app_trnsctn_nmbr").disabled=false;
document.all.item("hide").value="void";
d.submit();	
}

// function for when form is reset

function form_reset(){
var d =document.forms[0];
//after_clk();
d.reset();
load();
window.status=" ";
}

// function for when form is queried

function form_query(){
return true;
var d =document.forms[0];
after_clk();
d.submit();
}

// functions for handling buttons !!!

function after_clk(){
var chec=event.srcElement.value;
var hid=document.all.item("hide").value;
if(chec=="<U>S</U>ubmit"){
document.all.item("hide").value="submit";
document.all.item("crtd_by").value=parent.frames(0).ret_usr();
}
else if(chec=="<U>Q</U>uery"){
document.all.item("hide").value="query";
}
else if(chec=="<U>U</U>pdate"){
document.all.item("hide").value="update";
	for(i=0;i<document.forms[0].length;i++){
		if(document.forms[0].elements[i].getAttribute("query")=="yes") document.forms[0].elements[i].disabled=false;
	}
}
else if(chec=="<U>R</U>eset" && hid=="submit" ){
document.all.item("hide").value="reset";
document.all.item("submit1").disabled=true;
document.all.item("update").disabled=true;
	for(i=0;i<document.forms[0].length;i++){
		if(document.forms[0].elements[i].getAttribute("submit")=="yes") document.forms[0].elements[i].disabled=false;
	}
}
else if(chec=="<U>R</U>eset" && hid=="update" ){
document.all.item("hide").value="reset";
document.all.item("submit1").disabled=true;
document.all.item("update").disabled=true;
	for(i=0;i<document.forms[0].length;i++){
		if(document.forms[0].elements[i].getAttribute("query")=="yes") document.forms[0].elements[i].disabled=false;
	}
}
else if(chec=="<U>R</U>eset" && hid=="query" ){
document.all.item("hide").value="reset";
document.all.item("submit1").disabled=true;
document.all.item("query").disabled=true;
document.all.item("update").disabled=true;
	for(i=0;i<document.forms[0].length;i++){
		if(document.forms[0].elements[i].getAttribute("query")=="yes") document.forms[0].elements[i].disabled=false;
	}

}
else if(chec=="<U>R</U>eset" && hid=="void" ){
document.all.item("hide").value="reset";
document.all.item("submit1").disabled=false;
document.all.item("query").disabled=true;
document.all.item("update").disabled=true;
	for(i=0;i<document.forms[0].length;i++){
		if(document.forms[0].elements[i].getAttribute("query")=="yes") document.forms[0].elements[i].disabled=false;
	}

}
	document.all.item("mdfd_by").value=parent.frames(0).ret_usr();
}

function on_txt(){
if(event.srcElement.value!="" && (document.all.item("hide").value=="" || document.all.item("hide").value=="null")){
document.all.item("query").disabled=false;
document.all.item("submit1").disabled=false;
}
else{
document.all.item("query").disabled=true;
document.all.item("submit1").disabled=true;
}
}

function on_text(){
var d =document.forms[0];
var i;	
	for(i=0;i<d.length;i++){
		if(d.elements[i].getAttribute("query")=="yes"){
				if(d.elements[i].value!="" && (document.all.item("hide").value=="" || document.all.item("hide").value=="null")){
								document.all.item("query").disabled=false;
								break;
				}
				else{
								document.all.item("query").disabled=true;
				}				
		}
	}
	for(i=0;i<d.length;i++){
		if(d.elements[i].getAttribute("submit")=="yes"){
				if(d.elements[i].value!=""){
								document.all.item("submit1").disabled=true;
								break;
				}
				else{
								document.all.item("submit1").disabled=false;
				}				
		}
	}
}

// Focuses the first enabled field

function load(){
var d =document.forms[0];
var i;	
	runClock();
	button_load();
	for(i=0;i<d.length;i++){
		if(d.elements[i].disabled==false && d.elements[i].type != "hidden" && d.elements[i].getAttribute("first")=="yes"){
			d.elements[i].select();
			d.elements[i].focus();
			break;
		}
	}
return true;
}



function button_load(){
var cc=document.all.item("hide").value;

if(cc=="submit"){
	document.all.item("submit1").disabled=true;
	document.all.item("query").disabled=true;
	document.all.item("update").disabled=true;
	for(i=0;i<document.forms[0].length;i++){
		if(document.forms[0].elements[i].getAttribute("submit")=="yes"){
			document.forms[0].elements[i].disabled=true;
		}
	}
}
else if(cc=="query"){
	document.all.item("submit1").disabled=true;
	document.all.item("query").disabled=true;
	document.all.item("update").disabled=false;
	for(i=0;i<document.forms[0].length;i++){
		if(document.forms[0].elements[i].getAttribute("query")=="yes"){
			document.forms[0].elements[i].disabled=true;
		}
	}
}
else if(cc=="update"){
	document.all.item("query").disabled=true;
	document.all.item("update").disabled=true;
	document.all.item("submit1").disabled=true;
	for(i=0;i<document.forms[0].length;i++){
		if(document.forms[0].elements[i].getAttribute("query")=="yes"){
			document.forms[0].elements[i].disabled=true;
		}
	}
}
else if(cc=="reset"){
	document.all.item("query").disabled=true;
	document.all.item("update").disabled=true;
	document.all.item("submit1").disabled=true;
	for(i=0;i<document.forms[0].length;i++){
		if(document.forms[0].elements[i].getAttribute("query")=="yes"){
			document.forms[0].elements[i].disabled=false;
		}
	}
}
else if(cc=="void"){
	document.all.item("void").disabled=true;
	document.all.item("query").disabled=true;
	document.all.item("update").disabled=true;
	document.all.item("submit1").disabled=true;
	for(i=0;i<document.forms[0].length;i++){
		if(document.forms[0].elements[i].getAttribute("query")=="yes"){
			document.forms[0].elements[i].disabled=true;
		}
	}
}

} 


// CHECKS FOR ALPHANUMERIC

function alphanum_check(value) {

value=trim(value);

if(value=="") return true;

var alphanumPattern = /^(\*{1}|[-\/&\.a-zA-Z0-9\s]+)$/ ;

if (alphanumPattern.test(value)) {
	return(true);
        } else {
		alert("Invalid Input");
			event.srcElement.select();
					event.srcElement.focus();

		return(false);
        }
}

function alpnum_check(value) {

value=trim(value);

if(value=="") return true;

var alphaPattern = /^[a-zA-Z\s]+$/; 

if (alphaPattern.test(value)) {
	return(true);
        } else {
		return(false);
        }
}

// CHECKS FOR ALPHABETIC

function alpha_check(value) {

if(value=="") 
	return true;
	

value=trim(value);

var alphaPattern = /^(\*{1}|[a-zA-Z\s]+)$/; 

if (alphaPattern.test(value)) {
  	return(true);
        } else {
		alert("Invalid Input");
			event.srcElement.select();
					event.srcElement.focus();

		return(false);
        }
}

// CHECKS FOR Email

function email_check(value) {

if(value=="") return true;

value=trim(value);

var emailPattern = /^.+\@.+\..+$/;

if (emailPattern.test(value)) {
	return(true);
        } else {
		alert("Incorrect Email Entered");
			event.srcElement.select();
					event.srcElement.focus();

		return(false);
        }
}

// CHECKS FOR URL

function url_check(value) {

if(value=="") return true;

value=trim(value);

/*
var urlPattern = /(\w+):\/\/([w.]+)\/(\S*)/;

if (urlPattern.test(value)) {  
	return(true);
        } else {
		alert("Incorrect URL Entered");
			event.srcElement.select();
					event.srcElement.focus();

		return(false);
        }
*/
}

// CHECKS FOR VALID INT 

function num_check(value)
{

if(value=="") return false;

value=trim(value);

if(value=="null") return false;

var intPattern = /^(\*{1}|\d*)$/;

if (intPattern.test(value)) {
  
	return(true);
        } else {
		alert("Invalid Entry");
			event.srcElement.select();
					event.srcElement.focus();

		return(false);
        }
}



// check for the amount validation

function amount_check(name,num,cmp,type){
if(num=="") return true;
validity=true;
if(amnt_check(num)){
if(type==1 && cmp!="") validity = max_check(name,num,cmp); 
if(type==2 && cmp!="") validity = min_check(name,num,cmp);
if(!validity){
		event.srcElement.value="";
		event.srcElement.focus();
		event.srcElement.select();
}
}
}

// check for the period validation

function period_check(name,num,cmp,type){
validity=true;
if(num_check(num)){
if(type==1 && cmp!="") validity = max_check(name,num,cmp); 
if(type==2 && cmp!="") validity = min_check(name,num,cmp);
if(!validity){
		event.srcElement.value="";
		event.srcElement.focus();
		event.srcElement.select();
}
}
}


// Check for Minimum

function min_check(name, num, min)
{
	if(parseFloat(num) < parseFloat(min))
	{
		alert(name + " should not be less than " + min);
		return false;
	}

	return true;
}

// Check for Maximum

function max_check(name, num, max)
{
	if(parseFloat(num) > parseFloat(max))
	{
		alert(name + " should not be greater than " + max);
		return false;
	}

	return true;
}

// Trim left

function trim_left(str)
{
	var c = 0;
	for(c = 0; c < str.length; c++)
		if(str.charAt(c) != ' ')
			break;

	return str.substring(c, str.length);
}

// Trim right

function trim_right(str)
{
	var c = 0;
	for(c = str.length - 1; c >= 0; c--)
		if(str.charAt(c) != ' ')
			break;	

	return str.substring(0, c + 1);
}


// Trim Both

function trim(str)
{
	str = trim_left(str);
	str = trim_right(str);
	return str;
}



// UPPERCASE CONVERSION 
	
function up_case(str){
//alert(event.keyCode);
//if(event.keyCode==13) event.srcElement.focus();
//if(alpnum_check(String.fromCharCode(event.keyCode))){
//event.srcElement.value=str.toUpperCase();
//}
return true;
}

// CHECKS amount entered

function amnt_check(str)
{
if(str=="") return true;

var sy=str.indexOf('.');

if(!float_check(str)) return false;

	if((str.substr(0,sy).length>9 || str.substr(sy+1,str.length).length>2) && sy>0)
	{
		alert(str + " is not a valid format, use decimal point");
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if(sy<0){
	var len=str.length;
	if(len>9){
		alert(str + " is not a valid format, use decimal point");
			event.srcElement.select();
					event.srcElement.focus();
		return false;
		}
		}

	return true;
}

// CHECKS tick size  entered

function tick_check(str)
{
if(str=="") return true;

var sy=str.indexOf('.');

if(!float_check(str)) return false;

	if((str.substr(0,sy).length>5 || str.substr(sy+1,str.length).length>2) && sy>0)
	{
		alert(str + " is not a Valid Amount");
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if(sy<0){
	var len=str.length;
	if(len>5){
		alert(str + " is not a Valid Amount");
			event.srcElement.select();
					event.srcElement.focus();
		return false;
		}
		}

	return true;
}

// CHECKS %age entered

function percent_check(str)
{

if(str=="") return true;

var sy=str.indexOf('.');

if(!float_check(str)) return false;

	if((str.substr(0,sy).length>2 || str.substr(sy+1,str.length).length>2) && sy>0)
	{
		alert(str + " is not a Valid Percentage");
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if(sy<0){
	var len=str.length;
	if(len>2){
		alert(str + " is not a Valid Percentage");
			event.srcElement.select();
					event.srcElement.focus();
		return false;
		}
		}

	return true;
}


// function for time check

function time_check(time_str){
if(time_str=="") return true;

validity=true;
var timPat = /^(\d{1,2})(:)(\d{1,2})\2(\d{1,2})$/;

	var matchArray = time_str.match(timPat); // is the format ok?
	if (matchArray == null) 
	{
	    validity=false;
		alert("Time is not in a valid format")
	}
	else{
	var hour = matchArray[1]; // parse date into variables
	var min = matchArray[3];
	var sec = matchArray[4];
	if(hour>23 || min>59 || sec>59)
	{
	    validity=false;
		alert("Time is not in a valid format")
	}
	}
	
if(!validity){
event.srcElement.value="";
event.srcElement.focus();
event.srcElement.select();
return false;
}
}


//******************** DATE VALIDATION FUNCTION ***********************



function date_check(name,date_str,date1,date2,type) {
if(date_str=="") return true;
var validity=check_date(date_str);
if(validity){
if(date1!="" && type==1){ if(!check_date_max(name,date_str,date1)) validity=false;}
if(date2!="" && type==1){ if(!check_date_max(name,date_str,date2)) validity=false;}
if(date1!="" && type==2){ if(!check_date_min(name,date_str,date1)) validity=false;}
if(date2!="" && type==2){ if(!check_date_max(name,date_str,date2)) validity=false;}
if(date1!="" && type==3){ if(!check_date_min(name,date_str,date1)) validity=false;}
if(date2!="" && type==3){ if(!check_date_min(name,date_str,date2)) validity=false;}
}

if(!validity){
event.srcElement.value="";
event.srcElement.focus();
event.srcElement.select();
return false;
}

return true;

//event.srcElement.value=chgdate(extract_date(date_str));
}


// Check for a valid date

function is_valid_date(month, day, year)
{
	if (month < 1 || month > 12) 
	{ 
		// check month range
		alert("Month must be between 1 and 12.");
		return false;
	}
	if (day < 1 || day > 31) 
	{
		alert("Day must be between 1 and 31.");
		return false;
	}
	if ((month==4 || month==6 || month==9 || month==11) && day==31) 
	{
		alert("Month "+month+" doesn't have 31 days!")
		return false
	}
	if (month == 2)
	{ // check for february 29th
		var isleap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
		if (day>29 || (day==29 && !isleap)) 
		{
			alert("February " + year + " doesn't have " + day + " days!");
			return false;
 		}
	}
	
	return true;
}

function make_date(m, d, y)
{
	this.month = parseInt(m);
	this.day = parseInt(d);
	this.year = parseInt(y);
}

function extract_date(dateStr)
{
	// Checks for the following valid date formats:
	// DD/MM/YYYY  DD-MM-YYYY
	// Also separates date into month, day, and year variables

	var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{4})$/;

	// To require a 4 digit year entry, use this line instead:
	// var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{4})$/;

	var matchArray = dateStr.match(datePat); // is the format ok?
	if (matchArray == null) 
	{
		alert("Date is not in a valid format, pls insert date as DD/MM/YYYY  DD-MM-YYYY");
		event.srcElement.select();
		event.srcElement.focus();
//		return false;
		return null;
	}
	
	var month = matchArray[3]; // parse date into variables
	var day = matchArray[1];
	var year = matchArray[4];


	if(!is_valid_date(month, day, year))
		return null;

	return new make_date(month, day, year);
}

function extract_period(periodStr)
{
	// Checks for the following valid date formats:
	// DD/MM/YYYY  DD-MM-YYYY
	// Also separates date into month, day, and year variables

	var periodPat  = /^(\0-2{2})(\d{4})$/; ///^(\(0-2)(\){1,2})(\d{4})$/;

	// To require a 4 digit year entry, use this line instead:
	// var datePat = /^(\d{1,2})(\/|-)(\d{1,2})\2(\d{4})$/;

	var matchArray = periodStr.match(periodPat); // is the format ok?
	if (matchArray == null) 
	{
		alert("Period is not in a valid format, pls insert date as MMYYYY")
		return null;
	}
	
/*	<!--var month = matchArray[3]; // parse date into variables
	var day = matchArray[1];
	var year = matchArray[4];


	if(!is_valid_date(month, day, year))
		return null;

	return new make_date(month, day, year);*/
}


// Check for Period

function check_period(periodStr) 
{
if (periodStr != "")
{
	var p = extract_period(periodStr);
	return p != null;  
}
/*  var d = extract_date(dateStr);
	return d != null;  */
}

// Check for date

function check_date(dateStr) 
{
if (dateStr != "")
{
	var d = extract_date(dateStr);
	return d != null;  
}
/*  var d = extract_date(dateStr);
	return d != null;  */
}


// Check for min date

function check_date_min(name, date, min)
{
var validity=true;
	var given_date = extract_date(date);
	var min_date = extract_date(min);

	if(given_date == null || min_date == null)
		return false;

	if(given_date.year >= min_date.year){
		 if (given_date.year == min_date.year){
			if(given_date.month >= min_date.month){
				if(given_date.month == min_date.month && given_date.day < min_date.day){
					 validity=false;
					}
			}
			else{
			validity=false;
			}
		 }
	}
	else{
	 validity=false;
	}

if(!validity){
	alert(name + " should be on or later than " + min);
}

return validity;
}

// Check for max date

function check_date_max(name, date, max)
{
var validity=true;
	var given_date = extract_date(date);
	var max_date = extract_date(max);

	if(given_date == null || max_date == null)
		return false;

	if(given_date.year <= max_date.year){
		 if (given_date.year == max_date.year){
			if(given_date.month <= max_date.month){
				if(given_date.month == max_date.month && given_date.day > max_date.day) validity=false;
			}
			else validity=false;
		 }
	}
	else validity=false;

if(!validity){
	alert(name + " should be on or before than " + max);
}

return validity;
}

// Check for Leap Year

function is_leap_year(year)
{
	return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
}


function chgdate(date) {
var strMonthArray = new Array(12);
strMonthArray[0] = "Jan";
strMonthArray[1] = "Feb";
strMonthArray[2] = "Mar";
strMonthArray[3] = "Apr";
strMonthArray[4] = "May";
strMonthArray[5] = "Jun";
strMonthArray[6] = "Jul";
strMonthArray[7] = "Aug";
strMonthArray[8] = "Sep";
strMonthArray[9] = "Oct";
strMonthArray[10] = "Nov";
strMonthArray[11] = "Dec";

return date.day + " " + strMonthArray[date.month-1] + " " + date.year;

}


// ****************************Date function ends her ******************************







// FORM GENERAL VALIDATION


function validate_form() {

validity = true; // assume valid
var d = document.forms[0];
var i;

for(i = 0; i < d.length; i++)
{
  if (d.elements[i].className=="required" && !check_empty(d.elements[i].value))
 	{ 
   	validity = false; alert('Mandatory field is empty!');
	d.elements[i].select();
	d.elements[i].focus();
	return validity;
	}
}

return validity;

}

function check_empty(text) {

  return (text.length > 0); // returns false if empty

}

//FUNCTION FOR VALIDATING THE FLOAT VALUES
/*function float_check(value)
{
	flag=0	//variable used for finding the invalid entry.
	if (isNaN(value))
		flag=1;
	else 
	{		
		index=value.indexOf(".");
		if(index==-1)
			return(true);
		else
		{
			noOfDigits=index;
			noOfDecimals=value.length-(index+1);
			if((noOfDecimals>2)||(noOfDecimals==0))
				flag=1;
		}
	}
	if(flag==1)
	{
		alert("Invalid Entry");
		event.srcElement.select();
		event.srcElement.focus();
	}
}*/
function float_check(val,Nozero)
{
var regExFloat = /^((\d+(\.\d(\d)?)?)|((\d*\.)\d(\d)?))$/
  if(val=="")
	   return true;
	if(Nozero==1) {
  	if (val.charAt(0) == '0'){
	     alert("Cannot Start With zero");
	     event.srcElement.select();
  		 event.srcElement.focus();
  		 return false;
  	}
	}
  if(regExFloat.test(val)==false) {
	   alert("Not a valid Floating Point Number");																																		
	   event.srcElement.select();
		 event.srcElement.focus();
		 return false;
	}
	if(eval(val)<=0) {
	   alert("Must Be Greater Than 0");
		 event.srcElement.select();
		 event.srcElement.focus();
		 return false
	 }
	return true;
}

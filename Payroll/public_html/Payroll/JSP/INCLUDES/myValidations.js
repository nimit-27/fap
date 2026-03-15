/*
     Creator: S. Muthu Subramaniam
     Purpose: This function testFloat2Dec tests whether the 
              particular value is a valid float value or not.
     Parameters:
                val-the textbox value.(the value to test)
                NoZero-whether it can be 0 or not
     returns:
               true-if value is null or valid
               false-if not valid
*/

function testFloat2Dec(val,Nozero) {
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
/*
     Creator: S. Muthu Subramaniam
     Purpose: This function testInteger tests whether the 
              particular value is a valid integer value or not.
     Parameters:
                val-the textbox value.(the value to test)
                NoZero-whether it can be 0 or not
     returns:
               true-if value is null or valid
               false-if not valid
*/
function testInteger(val,Nozero) {
var regExInteger = /^\d+$/
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
	if(regExInteger.test(val)==false) {
   	alert("Not a Valid Integer");
	   event.srcElement.select();
		 event.srcElement.focus();
		 return false;
	}
	if(eval(val)<1) {
	   alert("Must Be Greater Than zero");
		 event.srcElement.select();
		 event.srcElement.focus();
		 return false
	 }
	return true;
}
/*
     Creator: S. Muthu Subramaniam
     Purpose: This function lfnTestStarEnter allows the user 
              to enter *,enter,tab only.Rest of the Characters
              are ignored.this function is called by lfnTestPopup
              function.
     Parameters:
                no parameters
     returns:
               true-if value is *,enter or tab;
               false-if not.
*/
function lfnTestStarEnter() {
  switch(event.keyCode) {
	   case 13:
		    break;
		 case 42:
		    break;
		 case 9:
		    break;
		 default:
		    return false;
	}
	return true;
}
/*
     Creator: S. Muthu Subramaniam
     Purpose: This function lfnTestPopup calls lfnTestStartEnter
              to determine whether the keypressed is *,enter or tab.
              if it is * and enter then opens a window.
     Parameters:
              Still to be decided.
     returns:
               true-if value is *,enter or tab
               false-if not valid
*/
function lfnTestPopup() {
  if(lfnTestStarEnter()==true) {
	   if(((event.keyCode==13)||(event.keyCode==9)) && event.srcElement.value=="*") {
		    event.srcElement.value="";
		    alert("Open Window");
		 }
		 return true;
  }
	return false;
}
/*
     Creator: S. Muthu Subramaniam
     Purpose: This function lfnTestAlphanumeric tests for 
              alphanumeric characters 0-9,A-Z,a-z.
     Parameters:
                sParam-the textbox value.(the value to test)
     returns:
               true-if value is null or valid
               false-if not valid
*/
function lfnTestAlphaNumeric(sParam) {
var regExAlphanumeric = /^[a-zA-Z0-9]+$/
   if(sParam=="")
	    return true;
	 if(regExAlphanumeric.test(sParam)==false) {
    	alert("Not a Valid AlphaNumeric Character");
	    event.srcElement.select();
		  event.srcElement.focus();
		  return false;
	}
	return true;
}
/*
     Creator: S. Muthu Subramaniam
     Purpose: This function lfnTestAlphabetic tests for 
              alphabetic characters A-Z,a-z.
     Parameters:
                sParam-the textbox value.(the value to test)
     returns:
               true-if value is null or valid
               false-if not valid
*/

function lfnTestAlphabetic(sParam) {
var regExAlphabetic = /^[a-zA-Z]+$/
   if(sParam=="")
	    return true;
	 if(regExAlphabetic.test(sParam)==false) {
    	alert("Not a Valid Alphabetic Character");
	    event.srcElement.select();
		  event.srcElement.focus();
		  return false;
	}
	return true;
}
/*
     Creator: S. Muthu Subramaniam
     Purpose: This function lfnOpenCalendar is used to open
              a calendar.
     Parameters:
                tObj-the textbox associated with the calendar.
     returns:
               the date that u select.
*/

function lfnOpenCalendar(tObj) {
var cal1 = new calendar1(tObj);
cal1.popup();
cal1.year_scroll = true;
cal1.time_comp = false;
}
/*
     Creator: S. Muthu Subramaniam
     Purpose: This function lfnTestDate tests whether the date
              is valid or not and also checks for format.
     Parameters:
                tVal-the textbox value.(the value to test)
     returns:
               true-if value is null or valid
               false-if not valid
*/

function lfnTestDate(tVal) {
if(tVal=="" || tVal==null)
  return true;
arrMonth=new Array(31,28,31,30,31,30,31,31,30,31,30,31);
var regExDate = /^(( (0[1-9]) | ([1-2][0-9]) | (3[01]) )  (\/) ( (0[1-9]) | (1[0-2]) ) (\/) ( \d\d\d\d ) )$/
if(regExDate.test(tVal)==false) {
   alert("Not a valid date format");
 	  event.srcElement.select();
	  event.srcElement.focus();
	  return false;
}
tDay=eval(tVal.substr(0,2));
tMonth=eval(tVal.substr(3,2));
tYear=eval(tVal.substr(6,4));
if(tMonth==2) {
  ret=daysInFebruary(tYear);
  if(tDay!=ret) {
	  alert("February contains "+ret+" days");
 	  event.srcElement.select();
	  event.srcElement.focus();
	  return false;
	}
}
else {
  if(tDay>arrMonth[tMonth-1]) {
    alert("Not a valid day for this particular month");
	  event.srcElement.select();
 	  event.srcElement.focus();
	  return false;
  }
}
return true;
}
/*
     Creator: S. Muthu Subramaniam
     Purpose: Used by lfnTestDate to determine how many days 
              in February
     Parameters:
                year-the year
     returns:
               28 or 29 based on leap year.
*/

function daysInFebruary (year){
    return (((year % 4 == 0) && ( (!(year % 100 == 0)) || (year % 400 == 0))) ? 29 : 28 );
}
/*
     Creator: S. Muthu Subramaniam
     Purpose: This function lfnTestDiff tests two date and determine 
              whether date1 is greater than date2.
     Parameters:
                date1-First date
                date2-Second date
     returns:
               true-if First date is less than second date
               false-if not.
*/

function lfnDateDiff(date1,date2) {
  var dArr1=new Array();
  var dArr2=new Array();
	dArr1=date1.split('/');
	dArr2=date2.split('/');
  if(dArr2[2]<dArr1[2]) 
	  return false;
	if(dArr2[2]==dArr1[2]) {
  	if(dArr2[1]<dArr1[1])
		  return false;
		if(dArr2[1]==dArr1[1])
		  if(dArr2[0]<dArr1[0])
			  return false;
    }				
	return true;			 
}
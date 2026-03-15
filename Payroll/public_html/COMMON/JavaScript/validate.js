/*      Purpose: This function date_check tests whether the date
              is valid or not and also checks for format.
     Parameters:
                tVal-the textbox value.(the value to test)
     returns:
               true-if value is null or valid
               false-if not valid
*/
/*------Added By Abdul on 20-may-2015-----*/
function getyrmm(varDate)
{
    date1 = change_DateFormatMon(varDate);
    firstindex=date1.indexOf("/");
    lastindex=date1.lastIndexOf("/");
    if(lastindex==4)
    {
        MM1=date1.substring(firstindex+1,lastindex);
        YYYY1=date1.substring(lastindex+1,date1.length+1);
        return (YYYY1+'0'+MM1);
    }
    else
    {
        MM1=date1.substring(firstindex+1,lastindex);
        YYYY1=date1.substring(lastindex+1,date1.length+1);
        return (YYYY1+MM1);
    }
}
function date_Check(cdate) 
{
	var sub1="";
	var sub2="";
	var sub3="";

	if (cdate == "")
	{
		return true;
	}

	cdate = change_DateFormat(cdate);
	
	if(cdate.length > 10 || cdate.length < 8)
	{
		alert('Invalid Date!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	else
	{
		for(j=0;j<cdate.length;j++)
		{
			if(cdate.charAt(j)!="0" && cdate.charAt(j)!="1" && cdate.charAt(j)!="2" && cdate.charAt(j)!="3" 
				&& cdate.charAt(j)!="4" && cdate.charAt(j)!="5" && cdate.charAt(j)!="6" && cdate.charAt(j)!="7" 
				&& cdate.charAt(j)!="8" && cdate.charAt(j)!="9" && cdate.charAt(j)!="/")
			{				
				alert('Invalid Date!');
				event.srcElement.select();
				event.srcElement.focus();
				return false;
			}
		}
	} //All charecters are valid and length of value is valid

	firstindex=cdate.indexOf("/");
	lastindex=cdate.lastIndexOf("/");

	sub1=cdate.substring(0,firstindex);
	sub2=cdate.substring(firstindex+1,lastindex);
	sub3=cdate.substring(lastindex+1,cdate.length+1);

//	alert(sub1 + " " + sub2 + " " + sub3);

	if (isNaN(sub1) || sub1.length > 2)
	{		
		alert('Invalid Date!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	
	if (isNaN(sub2)|| sub2.length > 2)
	{
		alert('Invalid Date!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if (isNaN(sub3))
	{	
		alert('Invalid Date!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if (sub3.length > 4)
	{	
		alert('Invalid Year!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if (sub1 == 0)
	{
		alert("Day cannot be 0!");
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if (sub3 == 0)
	{
		alert("Year cannot be 0!");
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if(sub2 <=0 || sub2 >12)
	{		
		alert('Month cannot be 0 or more than 12!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if (sub3 < 1901)
	{		
		alert('Year cannot be less than 1901!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if(sub2 == 2)
	{
		if(((sub3 % 100)!=0) && ((sub3 % 4)==0) || ((sub3 % 400)==0))
		{
			if(sub1 < 1 || sub1 >29)
			{	
				alert('In leap year, February cannot  have 0 or more than 29 days!');
				event.srcElement.select();
				event.srcElement.focus();
				return false;
			}
		}
		else
		{
			if(sub1 < 1 || sub1 > 28)
			{
				alert('In non-leap year, February cannot  have 0 or more than 28 days!');
				event.srcElement.select();
				event.srcElement.focus();
				return false;
			}
		}
	}
	if(sub2 ==1 || sub2==3 || sub2==5 || sub2 == 7 || sub2==8 || sub2==10 ||sub2==12)
	{
		if(sub1 < 1 || sub1 > 31)
		{
			alert('Day cannot be 0 or more than 31 days!');
			event.srcElement.select();
			event.srcElement.focus();
			return false;
		}
	}
	if(sub2 ==4 || sub2==6 || sub2==9 || sub2 == 11)
	{
		if(sub1 < 1 || sub1 > 30)
		{		
			alert('Day cannot be 0 or more than 30 days!');
			event.srcElement.select();
			event.srcElement.focus();
			return false;
		}
	}
	return true;
}

// This converts the given date (which is in 'dd-mm-yyyy' format) into 'dd/mm/yyyy' format.

function change_DateFormat(cdate)
{
	firstIndex=cdate.indexOf("-");
	lastIndex=cdate.lastIndexOf("-");

	if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
	{
		var arr=cdate.split("-");
		cdate = arr[0] + "/" + arr[1] + "/" + arr[2];
	}

	return cdate;
}


//  This gives the difference of dates (dd/mm/yyyy or dd-mm-yyyy format)
//  This function returns the value in seconds

function dateDiff(date1, date2)
{
	var DD1;
	var MM1;
	var YYYY1;
	var DD2;
	var MM2;
	var YYYY2;

	date1 = change_DateFormat(date1);
	date2 = change_DateFormat(date2);

	firstindex=date1.indexOf("/");
	lastindex=date1.lastIndexOf("/");

	DD1=date1.substring(0,firstindex);
	MM1=date1.substring(firstindex+1,lastindex);
	YYYY1=date1.substring(lastindex+1,date1.length+1);
	
	firstindex2=date2.indexOf("/");
	lastindex2=date2.lastIndexOf("/");
	
	DD2=date2.substring(0,firstindex2);
	MM2=date2.substring(firstindex2 +1,lastindex2);
	YYYY2=date2.substring(lastindex2 +1,date2.length+1);
	
	datediff=Date.UTC(YYYY2,MM2-1,DD2,0,0,0)  -  Date.UTC(YYYY1,MM1-1,DD1,0,0,0);
	return datediff;
}

// This checks whether given value contains the given no of digits compulsorily.

function txtLength_Check(val, len)
{
	if (val.length != 0 && val.length != len)
	{
		alert('This field must contain ' + len + ' digits!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	return true;
}



// Function to check the phone number pattern (xx-xx-xxxx)

function phonenum_Check(value) 
{
    if(value=="") 
        return true;
    value=trim(value);
    var alphaPattern = /^[0-9]+[-]{0,1}[0-9]+[-]{0,1}[0-9]+$/;
    if (alphaPattern.test(value))
    {
        if(value.length<6)
        {
            alert("Invalid Entry! The Telephone or Mobile No Cannot Be Less Than Six Digits");
            event.srcElement.select();
            event.srcElement.focus();
            return(false);
        }
        return(true);
    }
    else 
    {
        alert("Invalid Entry!");
        event.srcElement.select();
        event.srcElement.focus();
        return(false);
    }
}

function NegNum_Check(value) 
{

    if(value=="") 
        return true;
    value=trim(value);
  	var alphaPattern = /^[\.\-\/0-9\s]+$/; 
    if (alphaPattern.test(value))
    {
      return(true); 
    }
    else 
    {
        alert("Invalid Entry!");
        event.srcElement.select();
        event.srcElement.focus();
        return(false);
    }
}



// This validates the float values, which must be a number(m, n) in oracle database i.e., 
// eg: number(5,2) contains 2 digits before decimal and 2 digits after decimal.

function validate_Float(value, m, n)
{
	if(value == "")
	{
		return true;	
	}
    else
	{
        if(value.indexOf('.') == 0)
            event.srcElement.value = '0'+value;		
		if (isNaN(value) || parseFloat(value) == 0)
		{
			alert("Invalid Entry!");
			event.srcElement.select();
			event.srcElement.focus();
			return false;
		}
		else if (value.length > m)
		{
			alert("Total length can not be more than " + m + " digits!");
			event.srcElement.select();
			event.srcElement.focus();
			return false;
		}
		else 
		{			
			index = value.indexOf("."); 
			if(index != -1 )
			{
				digitsAfterDecimal  = value.length - index - 1; 
				digitsBeforeDecimal = value.length - digitsAfterDecimal - 1;  

				if ((digitsAfterDecimal <= eval(n)) && digitsBeforeDecimal <= eval(m -  n - 1)) 
				{
					if (digitsAfterDecimal == 0)
					{
						event.srcElement.value = value + '00';
					}
					return true;
				}
				else
				{
					alert("No of digits Before decimal should not be more than " + eval(m - n - 1) +  " & After decimal it should not be more than " + n + " .");
					event.srcElement.select();
					event.srcElement.focus();
					return false;				
				}
					
			}
			else if (value.length < eval(m - n))
			{
				event.srcElement.value = value + '.00';
				return true;
			}
			else
			{
				alert("No of digits Before decimal should not be more than " + eval(m - n - 1) +  " & After decimal it should not be more than " + n + " .");
				event.srcElement.select();
				event.srcElement.focus();
				return false;			
			}
		}		
	}    
}

// This validates the float values, which must be a number(m, n) in oracle database i.e., 
// eg: number(5,2) contains 2 digits before decimal and 2 digits after decimal.

function validate_Float_Zero_Allwd(value, m, n)
{
	if(value == "")
	{
		return true;	
	}
    else
	{
        if(value.indexOf('.') == 0)
            event.srcElement.value = '0'+value;		
		if (isNaN(value))
		{
			alert("Invalid Entry!");
			event.srcElement.select();
			event.srcElement.focus();
			return false;
		}
		else if (value.length > m)
		{
			alert("Total length can not be more than " + m + " digits!");
			event.srcElement.select();
			event.srcElement.focus();
			return false;
		}
		else 
		{			
			index = value.indexOf("."); 
			if(index != -1 )
			{
				digitsAfterDecimal  = value.length - index - 1; 
				digitsBeforeDecimal = value.length - digitsAfterDecimal - 1;  

				if ((digitsAfterDecimal <= eval(n)) && digitsBeforeDecimal <= eval(m -  n - 1)) 
				{
					if (digitsAfterDecimal == 0)
					{
						event.srcElement.value = value + '00';
					}
					return true;
				}
				else
				{
					alert("No of digits Before decimal should not be more than " + eval(m - n - 1) +  " & After decimal it should not be more than " + n + " .");
					event.srcElement.select();
					event.srcElement.focus();
					return false;				
				}
					
			}
			else if (value.length < eval(m - n))
			{
				event.srcElement.value = value + '.00';
				return true;
			}
			else
			{
				alert("No of digits Before decimal should not be more than " + eval(m - n - 1) +  " & After decimal it should not be more than " + n + " .");
				event.srcElement.select();
				event.srcElement.focus();
				return false;			
			}
		}		
	}    
}

//this function will validate non negative float 
// This validates the float values, which must be a number(m, n) in oracle database i.e., 
// eg: number(5,2) contains 2 digits before decimal and 2 digits after decimal.

function validate_NonNegative_Float(value, m, n)
{
	if(value == "")
	{
		return true;	
	}
	else
	{
		
		if (isNaN(value) || parseFloat(value) <= 0)
		{
			alert("Invalid Entry!");
			event.srcElement.select();
			event.srcElement.focus();
			return false;
		}
		else if (value.length > m)
		{
			alert("Total length can not be more than " + m + " digits!");
			event.srcElement.select();
			event.srcElement.focus();
			return false;
		}
		else 
		{			
			index = value.indexOf("."); 
			if(index != -1 )
			{
				digitsAfterDecimal  = value.length - index - 1; 
				digitsBeforeDecimal = value.length - digitsAfterDecimal - 1;  

				if ((digitsAfterDecimal <= eval(n)) && digitsBeforeDecimal <= eval(m -  n - 1)) 
				{
					if (digitsAfterDecimal == 0)
					{
						event.srcElement.value = value + '00';
					}
					return true;
				}
				else
				{
					alert("No of digits Before decimal should be " + eval(m - n - 1) +  " & After decimal it should be " + n + " .");
					event.srcElement.select();
					event.srcElement.focus();
					return false;				
				}
					
			}
			else if (value.length < eval(m - n))
			{
				event.srcElement.value = value + '.00';
				return true;
			}
			else
			{
				alert("No of digits Before decimal should be " + eval(m - n - 1) +  " & After decimal it should be " + n + " .");
				event.srcElement.select();
				event.srcElement.focus();
				return false;			
			}
		}		
	}
}

// This converts the given date (which is in 'mm-yyyy' format) into 'mm/yyyy' format.

function change_DateFormat_MMYYYY(iDate)
{
	if(iDate.indexOf("-")!=-1)
	{
	var arr = iDate.split("-");
	var iDate = arr[0]+"/"+arr[1];
	}
	return iDate;
}


// This checks whether the date is valid in mm/yyyy or mm-yyyy format

function date_Check_MMYYYY(cdate)
{	
	if(cdate=='')
	{
		return true;
	}
	var sub1="";
	var sub2="";
	cdate = change_DateFormat_MMYYYY(cdate);
	if(cdate.length>7 || cdate.length < 6)
	{
		alert('Invalid Date!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	else
	{
		for(j=0;j<cdate.length;j++)
		{
			if(cdate.charAt(j)!="0" && cdate.charAt(j)!="1" && cdate.charAt(j)!="2" && cdate.charAt(j)!="3" && cdate.charAt(j)!="4" && cdate.charAt(j)!="5" && cdate.charAt(j)!="6" && cdate.charAt(j)!="7" && cdate.charAt(j)!="8" && cdate.charAt(j)!="9" && cdate.charAt(j)!="/")
			{
				alert('Invalid Date!');
				event.srcElement.select();
				event.srcElement.focus();
				return false;
			}
		}
	} 

	firstindex=cdate.indexOf("/");
	sub1=cdate.substring(0,firstindex);
	sub2=cdate.substring(firstindex+1,cdate.length+1);
	
	if (isNaN(sub1)|| sub1.length > 2)
	{
		alert('Invalid Date!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if (isNaN(sub2))
	{
		alert('Invalid Date!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if (sub2.length > 4)
	{	
		alert('Invalid Year!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if (sub2 == 0)
	{
		alert("Year cannot be 0!");
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if(sub1 <=0 || sub1 >12)
	{
		alert('Month cannot be 0 or more than 12!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	if (sub2 < 1901)
	{
		alert('Year cannnot be less than 1901!');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	
	return true;

}

// This gives the diff. b/w the given dates which are in the date format 'mm/yyyy' or 'mm-yyyy'.

function dateDiff_MMYYYY(date11,date12)
{
	var datediff;
	var DD1=1;
	var MM1;
	var YYYY1;
	var DD2=1;
	var MM2;
	var YYYY2;

	date1 = change_DateFormat_MMYYYY(date11);
	date2 = change_DateFormat_MMYYYY(date12);

	firstindex=date1.indexOf("/");
	MM1=date1.substring(0,firstindex);
	YYYY1=date1.substring(firstindex+1,date1.length+1);
	firstindex2=date2.indexOf("/");
	MM2=date2.substring(0,firstindex2);
	YYYY2=date2.substring(firstindex2 +1,date2.length+1);
	datediff=Date.UTC(YYYY2,MM2-1,DD2,0,0,0)  -  Date.UTC(YYYY1,MM1-1,DD1,0,0,0);
	return datediff;
}


// FUNCTION FOR VALIDATING THE Alphabets and Numeric

function alphanum_Check(value) 
{
	if(value=="") 
		return true;
	value=trim(value);
	//var alphaPattern = /^[a-zA-Z0-9]{1}+[.a-zA-Z0-9\s]*$/; 
	var alphaPattern = /^[\.&_\-\/a-zA-Z0-9\s]+$/; 
	if (alphaPattern.test(value))
		return(true);
	else 
	{
		alert("Invalid Entry!");
		event.srcElement.select();
		event.srcElement.focus();
		return(false);
	}
}

// FUNCTION FOR VALIDATING THE Alphabets 

function alpha_Check(value) 
{
	if(value=="")
		return true;
	value=trim(value);
	var alphanumPattern = /^[a-zA-Z0-9\s]+$/;  
	if(alphanumPattern.test(value)) 
		return(true);
	else
	{
		alert("Invalid Entry!");
		event.srcElement.select();
		event.srcElement.focus();
		return(false);
	}
}

/* Purpose : This function is for validating the Numbers.
    Arguments :
            value: the value to be checked.
            temp:    =0 means that it will accept any no of zeros and 
atleast one number after that. (i.e) accept : 000001 and not 0000.
                        =1 means that it will not accept zeros at first 
but it will accept 0. (i.e) will accept 123,0,120 and not 001
                        =2 means that it will not acept zero at all as 
first character.
Return Type:
            It returns true when the passed value is valid
            and return false and error message when the value is invalid.
*/

function num_Check(value,temp)
        {
            if(value=="")
                return true;
            //value=trim(value);
            if(temp==0)//for acceptin Zeros
                var intPattern = /^(((\d*)+[1-9]{1}+[0-9]*)|(^0{1}))$/;//This will function will accept any number of Zeros at First
            if(temp==1)
                var intPattern =/^(([1-9]{1}+[0-9]*)|(0{1}))$/;
            if(temp==2)
                var intPattern =/^([1-9]{1}+[0-9]*)$/;
            if(intPattern.test(value))
                return(true);
            else
            {
            alert("Invalid Input!");
            event.srcElement.select();
            event.srcElement.focus();
            return(false);
            }
}


// FUNCTION TO RESTRICT THE LENGTH OF THE TEXT AREA.
/*
	 This function limits the number of characters in the text area to the length specified
 
     Arguments: value to be checked and the maxlength it can have
	 While calling the function the programmer will have to write "return check_txtArea(value,maxlen) " in onKeyPress or onKeyDown
*/

function check_txtArea(value,maxlen)
{
	if(value.length >= (maxlen -1))
	{
		alert("No of characters should not exceed " + maxlen + "!");
		event.keyCode=8;
	}
}


// FUNCTION TO RESTRICT THE LENGTH OF THE TEXT AREA THAT RETURNS TRUE OR FALSE.
/*
	 This function limits the number of characters in the text area to the length specified
 
     Arguments: value to be checked and the maxlength it can have
	 While calling the function the programmer will have to write "return check_txtArea(value,maxlen) " in onKeyPress or onKeyDown
*/

function txtArea_Check(value,maxlen)
{
	if(value.length > maxlen)
	{
		alert("No of characters should not exceed " + maxlen + "!");
		event.keyCode=8;
        return false;
	}
    return true;
}

//   Check for Valid E-mail
/*
	 This function checks for the valid email. the email can be of the form (.com , .co.in , .net.in , npcil.ernet.in)
 
     Arguments: value to be checked.
	 
     returns:  true		-	if value is null or valid
               false	-	if not valid
*/
function email_Check(value) 
{
	if(value=="") 
		return true;
	value=trim(value);
    //this will validate for upper case also
	//var emailPattern = /^[A-Za-z0-9][\w-.]+[A-Za-z0-9]@[A-Za-z0-9]([\w-.]+[A-Za-z0-9]\.)+([A-Za-z]){2,4}$/i;
	//this is for smaller case only
	//var emailPattern = /^[a-z_0-9.]+@[a-z][a-z0-9]+\.([a-z]{3}|([a-z]{2,3}\.[a-z]{2})|([a-z]+\.[a-z]+\.[a-z]{2}))$/;
	var emailPattern = /^[a-z0-9A-Z]{1}+[A-Za-z_0-9.-]+@([A-Za-z0-9]+\.{0,1})*[A-Za-z0-9]+\.[a-zA-Z]{2,3}$/;
	if (emailPattern.test(value)) 
		return(true);
	else
	{
		alert("Incorrect Email ID!");
		event.srcElement.select();
		event.srcElement.focus();
		return(false);
    }
}

// Checks for valid URL
/*
	 This function checks for the valid URL. the url can be of the form (http:, yahoo.com, xyz.co.in , xyz.net.in)
 
     Arguments: value to be checked.
	 
     returns:  true		-	if value is null or valid
               false	-	if not valid

*/

function url_Check(value)
{
	if(value=="")
	{
		return true;
	}
	value = trim(value);
	var urlPattern = /^(www.|http:\/\/www.|https:\/\/www.|http:\/\/|https:\/\/)?([A-Za-z0-9]+\.{0,1})*[A-Za-z0-9]+\.[a-zA-Z]{2,3}$/;
	if (urlPattern.test(value)) 
	{  
		return(true);
	} 
	else 
	{
		alert("Invalid URL!");
		event.srcElement.select();
		event.srcElement.focus();
		return(false);
	}
}
// Trim Both
function trim(str)
{
	str = trim_left(str);//this is the user-defined-function for trimming the left 
	str = trim_right(str);//this is the user-defined-function for trimming the right 
	return str;
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

// Function to return the current date
/*
	 This function returns the current date
 
     Arguments: 
	 
     returns:  current date
*/
function getSysDate()
{
	var d=new Date();
	var curdate=d.getDate()+"/"+eval(d.getMonth()+1)+"/"+d.getYear();
	return(curdate);
}

//=========================================================================================================
// 					BASIC FORM FUNCTIONS 
//	The functions are :
//			mandatory_check(form),frmSave(form)
//=========================================================================================================

// This function is to check the Mandatory Fields in the form. The form is send as an argument.
/*
     This function checks for the mandatory fields in the form.
     Arguments: form to be checked
     returns:  true		-	if all the madatory fields are entered
               false	-	if not entered
*/
function mandatory_Check(tempfrm)
{
	var i;
	var flag=0;
  var fieldName;
	for(i=0;i<(eval(tempfrm).length);i++)
	{
		if((!(eval(tempfrm).elements[i].disabled))&&(eval(tempfrm).elements[i].className=='required') && (trim(eval(tempfrm).elements[i].value)==""))
			{
				fieldName=eval(tempfrm).elements[i].title;
        alert("Mandatory Field "+fieldName+" is empty!");
				eval(tempfrm).elements[i].focus();
				flag=1;
				return(false);
			}
	}
	if(flag==0)
		return true;
}

// This function is to Save the Details in the form when the user clicks the SAVE button.
/*
	 This function saves the form details
     Arguments: form to be checked
     returns:  true		-	if all the madatory fields are entered
               false	-	if not entered
*/
function validateForm(frm)
{
    if(mandatory_Check(frm))
    {
		sav=confirm("Do u want to save the details");
		if(sav==1)
		{
			alert("Details are Saved!");
			return(true);
		}
    }
   return(false);
}

// Checks the Percent value

function percent_Check(value)
{
	if (value == '') return true;

	if (validate_Float(value,6,2)) 
	{
		if (( eval(value) > 0) && (eval(value) <= 100 ))
		{
			return true;
		}
		else
		{
			alert("Percentage cannot be greater than 100!");
			event.srcElement.focus();
			event.srcElement.select();
			return false;
		}
	}
	else
	{
		return false;
	}
	
}

// Checks the Percent value zero allowed

function percent_Check_Zero_Allwd(value)
{
	if (value == '') return true;

	if (validate_Float_Zero_Allwd(value,6,2)) 
	{
		if (( eval(value) >= 0) && (eval(value) <= 100 ))
		{
			return true;
		}
		else
		{
			alert("Percentage cannot be greater than 100!");
			event.srcElement.focus();
			event.srcElement.select();
			return false;
		}
	}
	else
	{
		return false;
	}
	
}

// Inserts commas
 function insert_Comma(S)
 { 
	 S = String(S);
	 var RgX = /^(.* )?([-+\u00A3\u20AC]?\d+)(\d{3}\b)/
	 return S == (S=S.replace(RgX, "$1$2,$3")) ? S : insert_Comma(S) 
}

// Check Age(Later)
function age_Check(val)
{
	if (val == "")
	{
		return true;
	}
	if(!num_Check(val,2))
	{
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	
	if(val>=150||val<=0)
			{
				alert("Invalid Age!");
				event.srcElement.select();
				event.srcElement.focus();
				return false;
			}

		else
			{	return true;}

	return true;
}

// 30. Get Current Day

function GetDay(nDay)
{
	var Days = new Array("Sunday","Monday","Tuesday","Wednesday",
	                     "Thursday","Friday","Saturday");
	return Days[nDay]
}

//31. Get Current Month

function GetMonth(nMonth)
{
	var Months = new Array("January","February","March","April","May","June",
	                       "July","August","September","October","November","December");
	return Months[nMonth] 	  	 
}

//  Get Current Date 
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

// function for time check

function time_Check(time_str)
{
	 if(time_str=="") return true;
	 validity=true;
	 if (time_str.length < 3)
	 {
		   time_str = time_str + ":00";
	 }

	 var timPat = /^([01]?[0-9]|[2][0-3])(:[0-5][0-9])?$/;
	 var matchArray = time_str.match(timPat); // is the format ok?
	
	 if (matchArray == null) 
	 {
		  validity=false;
		  alert("Time is not in a valid format!")
	 }
	 else
	 {

		var hour = matchArray[1]; // parse date into variables
		var min = matchArray[3];
		var sec = matchArray[4];
	
		if(hour>23 || min>59 || sec>59)
	   {
		   validity=false;
		   alert("Time is not in a valid format!")
	   }
	}
 
	if(!validity)
	{
		event.srcElement.select();
	    event.srcElement.focus();
	    return false;
	}
	else
	{
	    event.srcElement.value=time_str;
	    validity=true;
	}
	return validity;
}

// This will return the date in format 'mm/yyyy'

function getSysDate_MMYYYY()
{
	var d=new Date();
	var curdate=eval(d.getMonth()+1)+"/"+d.getYear();
	return(curdate);
}


//  This will check whether the given date is less than or equal to/greater than or equal to the system date.
//  This assumes that the given date is valid(in date format dd/mm/yyyy or dd-mm-yyyy).

//  Explanation:
//  If flag is 0, it will check whether the given date is less than/equal to the system date.
// (i.e., returns error if it is gr.than the sys date)
//  else if flag is 1, it will check whether the given date is greater than/equal to the system date.
// (i.e., returns error if it is less than the sys date)



function cmpSysDate(cdate, flag)
{
	if (trim(cdate) == "")
	{
		return true;
	}

	cdate = change_DateFormatMon(cdate);
	//sysDate = getSysDate();
  sysDate = change_DateFormatMon(document.all.hdnLoginDate.value);
	if (flag == 0)
	{
		if (dateDiff(sysDate, cdate) > 0)
		{
			alert("Date cannot be more than the system date!");
			return false;

		}
	}
	else if (flag == 1)
	{
		if (dateDiff(sysDate, cdate) < 0)
		{
			alert("Date cannot be less than the system date!");
			return false;

		}
	}

	return true;
}


//  This will check whether the given date is less than/greater than/equal to the system date.
//  This assumes that the given date is valid(in date format mm/yyyy or mm-yyyy).

//  Explanation:
//  If flag is 0, it will check whether the given date is less than/equal to the system date.
// (i.e., returns error if it is gr.than the sys date)
//  else if flag is 1, it will check whether the given date is greater than/equal to the system date.
// (i.e., returns error if it is less than the sys date)

function cmpSysDate_MMYYYY(cdate, flag)
{
	if (trim(cdate) == "")
	{
		return true;
	}

	cdate = change_DateFormat_MMYYYY(cdate);
	sysDate = getSysDate_MMYYYY();
	
	if (flag == 0)
	{
		if (dateDiff_MMYYYY(sysDate, cdate) > 0)
		{
			alert("Date cannot be more than the system date!");
			event.srcElement.select();
			event.srcElement.focus();
			return false;

		}
	}
	else if (flag == 1)
	{
		if (dateDiff_MMYYYY(sysDate, cdate) < 0)
		{
			alert("Date cannot be less than the system date!");
			event.srcElement.select();
			event.srcElement.focus();
			return false;

		}
	}

	return true;
}

// This function checks for the USI Code
function ValidateUSICode (value)
{
	value = trim (value);

	if(value == "")
	return true;

	var USIPatt=/^[1-9]{1}[0-9]{0,4}\.[0-9]{2}$/;

	if (USIPatt.test(value))
	{
		return (true);
	}
	else 
	{
		alert("Invalid USI Code! Use format 'xxxxx.xx'!");
		event.srcElement.select();
		event.srcElement.focus();
		return (false);
	}
}

//This is predominantly used by HRMS.Here the element is being passed instead of value
//  This will check whether the given date is less than or equal to/greater than or equal to the system date.
//  This assumes that the given date is valid(in date format dd/mm/yyyy or dd-mm-yyyy).

//  Explanation:
//  If flag is 0, it will check whether the given date is less than/equal to the system date.
// (i.e., returns error if it is gr.than the sys date)
//  else if flag is 1, it will check whether the given date is greater than/equal to the system date.
// (i.e., returns error if it is less than the sys date)



function chkSysDate(element, flag)
{

	if (element.value =='') return true;
	element.value = change_DateFormat(element.value);

	firstindex=element.value.indexOf("/");
	lastindex=element.value.lastIndexOf("/");

	DD1=element.value.substring(0,firstindex);
	MM1=element.value.substring(firstindex+1,lastindex);
	YYYY1=element.value.substring(lastindex+1,element.value.length+1);

	date2=new Date();
	datediff=Date.UTC(YYYY1,MM1-1,DD1,0,0,0) - Date.UTC(date2.getYear(),date2.getMonth(),date2.getDate(),0,0,0);


	if (flag == 0)
	{
		if (datediff > 0)
		{
			alert("Date cannot be more than the system date!");
			event.srcElement.select();
			event.srcElement.focus();
			return false;

		}
	}
	else if (flag == 1)
	{
		if (datediff < 0)
		{
			alert("Date cannot be less than the system date!");
			event.srcElement.select();
			event.srcElement.focus();
			return false;

		}
	}

	return true;
}


//This function is perdominantly used by HRMS.Src Element is passed instead of element value
//  This gives the difference of dates (dd/mm/yyyy or dd-mm-yyyy format) and prompts appropriate error message


function diffdates(date1,date2)
{
		var DD1;
		var MM1;
		var YYYY1;
		var DD2;
		var MM2;
		var YYYY2;
		
		if (trim(date1.value) == ""  && trim(date2.value) != "")
		{
			alert("Period From to be entered");
			date1.select();
			date1.focus();
			return false;
		}

		if (trim(date1.value)==" " || trim(date2.value)==" ") return true;

		date1.value = change_DateFormat(date1.value);
		date2.value = change_DateFormat(date2.value);

		firstindex=date1.value.indexOf("/");
		lastindex=date1.value.lastIndexOf("/");

		DD1=date1.value.substring(0,firstindex);
		MM1=date1.value.substring(firstindex+1,lastindex);
		YYYY1=date1.value.substring(lastindex+1,date1.value.length+1);

		firstindex2=date2.value.indexOf("/");
		lastindex2=date2.value.lastIndexOf("/");

		DD2=date2.value.substring(0,firstindex2);
		MM2=date2.value.substring(firstindex2 +1,lastindex2);
		YYYY2=date2.value.substring(lastindex2 +1,date2.value.length+1);

		datediff=Date.UTC(YYYY2,MM2-1,DD2,0,0,0)  -  Date.UTC(YYYY1,MM1-1,DD1,0,0,0);

		if (datediff <0)
		{
			alert('To Date cannot be less than from date');
			event.srcElement.select();
			event.srcElement.focus();
			return false;
		}
}

//  Checks whether the content is empty
function check_empty(text) {
  text = trim(text);
  return (text.length > 0); // returns false if empty

}
// Function will populate the date into text box for which date value has been selected from the calendar page
function getdate(a) {
	var cal1 = new calendar1(a);
	cal1.popup();
	cal1.year_scroll = true;
	cal1.time_comp = false;
}


//These functions are used by HRMS module difftime(),validateyear()

//Validate Year value that's being entered
function ValidateYear(value){
	if ( trim(value)=='')  return true;
	if (value.length <4){
		alert('Invalid Year Value');
		event.srcElement.select();
		event.srcElement.focus();
		return false;
	}
	else{
		if ( eval(value) < 1980   ||  ( eval(value) > eval(new Date().getYear() + 2))){
			alert('Year value should be greater than 1980 or less than '+ (new Date().getYear() + 2));
			event.srcElement.select();
			event.srcElement.focus();
			return false;
		}
		else
			return true;
	}
}

//This function is used to calculate time difference.

function difftime(date1,date2)
{
var HH1;
var MM1;
var HH2;
var MM2;

firstindex=date1.indexOf(":");
HH1=date1.substring(0,firstindex);
MM1=date1.substring(firstindex+1,date1.length+1);
firstindex2=date2.indexOf(":");
HH2=date2.substring(0,firstindex2);
MM2=date2.substring(firstindex2 +1,date2.length+1);

datediff=Date.UTC(1900,1,1,HH2,MM2,0)  -  Date.UTC(1900,1,1,HH1,MM1,0);
if (datediff < 0){
	alert('To time cannot be less than From time');
	event.srcElement.select();
	event.srcElement.focus();
	return false;
}
else
	return true;
} 

//This function is used to print the screen
//It takes one parameter i.e ID of the Global DIV Tag of the Screen
function onPrint(divValue) 
{
     var printReadyElem = document.getElementById(divValue);
     if (printReadyElem != null)
     {
          document.hiddenFrame.document.body.innerHTML=document.getElementById(divValue).innerHTML;
     }

    hiddenFrame.focus();
    hiddenFrame.print();
}


// Function for opening the calendar
function OpenCalender(a) {
var cal1 = new calendar1(a);
a.focus();
cal1.popup();
cal1.year_scroll = true;
cal1.time_comp = false;
return;
}

	var alphaPattern = /^[\.&_,\-\/0-9\s]+$/; 
  
// THIS FUNCTION ACCETPS A-Z,a-z,0-9,.,COMMA,-,_,@,:,%,&
function alphanum_Check_Doc(value) 
{
	if(value=="") 
		return true;
	value=trim(value);
	//var alphaPattern = /^[a-zA-Z0-9]{1}+[.a-zA-Z0-9\s]*$/; 
	var alphaPattern = /^[\.&_,:%@\-\/a-zA-Z0-9\s]+$/; 
	if (alphaPattern.test(value))
		return(true);
	else 
	{
		alert("Invalid Entry!");
		event.srcElement.select();
		event.srcElement.focus();
		return(false);
	}
}

//========================FOR DISABLING THE RIGHT CLICK BUTTON============================
var isnn,isie
if(navigator.appName=='Microsoft Internet Explorer') //check the browser
{  isie=true }

if(navigator.appName=='Netscape')
{  isnn=true }

function right(e) //to trap right click button 
{
	if (isnn && (e.which == 3 || e.which == 2 ))
		return false;
	else if (isie && ( event.button == 3)) 
	{
		alert("Sorry, you do not have permission to right click on this page.");
		return false;
	}
		return true;
}

function key(k)   
{
	if(isie) {
		if(event.keyCode==18 || event.keyCode==93) {
			alert("Sorry, you do not have permission to press this key.") 
			return false;
		 } 
	}

	if(isnn){
		alert("Sorry, you do not have permission to press this key.") 
		return false; }   
}

if (document.layers) window.captureEvents(Event.KEYPRESS);  
if (document.layers) window.captureEvents(Event.MOUSEDOWN);
if (document.layers) window.captureEvents(Event.MOUSEUP);
document.onkeydown=key;  
document.onmousedown=right;
document.onmouseup=right;
window.document.layers=right;

//======================================================================================

function openNew()
{
      // FOR DEVELOPMENT PURPOSE(ON JDev)   
      //window.open("http://localhost:7101/Payroll/RedirectMap.do?action=frmLogin|LoginPage","Login","menubar=no,toolbar=no,scrollbars=yes,resizable=yes");    
      // FOR DEPLOYMENT PURPOSE
       window.open("RedirectMap.do?action=frmLogin|LoginPage","Login","menubar=no,toolbar=no,scrollbars=yes,resizable=yes");    
}


//Function for opening the calendar depending on the previous texbox value
function OpenCalender1(t,f){

var cal1 = new calendar2(t,f);
t.focus();
cal1.popup();
cal1.year_scroll = true;
cal1.time_comp = false;
return;
}

//  This will check whether the given date is less than or equal to/greater than or equal to the other date.
//  This assumes that the given date is valid(in date format dd/mm/yyyy or dd-mm-yyyy).

//  Explanation:
//  If flag is 0, it will check whether the given date is less than/equal to the other date.
// (i.e., returns error if it is gr.than the sys date)
//  else if flag is 1, it will check whether the given date is greater than/equal to the other date.
// (i.e., returns error if it is less than the sys date)


function cmpDate(date1,date2, flag)
{
  if (date1 == "")
	{
		return true;
	}
	date1 = change_DateFormatMon(date1);
	sysDate = change_DateFormatMon(date2);
	if (flag == 0)
	{
    if (dateDiff(sysDate, date1) > 0)
		{
		//	alert("Date cannot be more than the previous date!");
		//	event.srcElement.select();
		//	event.srcElement.focus();
			return false;
		}
	}
	else if (flag == 1)
	{
		if (dateDiff(sysDate, date1) < 0)
		{
		//	alert("Date cannot be less than the previous date!");
		//	event.srcElement.select();
		//	event.srcElement.focus();
			return false;

		}
	}

	return true;
}

// This converts the given date (which is in 'dd-mon-yyyy' format) into 'dd/mm/yyyy' format.

function change_DateFormatMon(cdate)
{
	firstIndex=cdate.indexOf("-");
 
	lastIndex=cdate.lastIndexOf("-");
 
	if((firstIndex != -1) && (lastIndex != -1) && (firstIndex != lastIndex))
	{
		var arr=cdate.split("-");
   
    var monIndx=getMonthIndx(arr[1]);
   
    if(monIndx!=-1)
      cdate = arr[0] + "/" + monIndx + "/" + arr[2];
	}

	return cdate;
}


function getMonthIndx(strMon)
{
  //var arrCal=new Array();
  var arrCal=["Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"];
  for(i=0;i<arrCal.length;i++)
  {
    if(arrCal[i].toUpperCase()==strMon.toUpperCase())
    {
      return i+1;
    }
  }
  
  return -1;
  
}


// This will check whether the given date is less than or equal to/greater than or equal to the other date.
// This assumes that the given date is valid(in date format dd/mm/yyyy or dd-mm-yyyy).It contain message that has to be display

// Explanation:
// If flag is 0, it will check whether the given date is less than/equal to the other date.
// (i.e., returns error if it is gr.than the sys date)
// else if flag is 1, it will check whether the given date is greater than/equal to the other date.
// (i.e., returns error if it is less than the sys date)

function cmpDateMsg(date1,date2,flag,messg)
{
    if (trim(date1) == "")
    {
      return true;
    }
    
    date1 = change_DateFormatMon(date1);
    sysDate = change_DateFormatMon(date2);
    if (flag == 0)
    {
      if (dateDiff(sysDate, date1) > 0)
      {
      alert(messg);
      //event.srcElement.select();
      //event.srcElement.focus();
      return false;
      
      }
    }
    else if (flag == 1)
    {
      if (dateDiff(sysDate, date1) < 0)
      {
        alert(messg);
        //event.srcElement.select();
        //event.srcElement.focus();
        return false;
      
      }
    }
    return true;
}
//disabling F-5 button press by swapnendu Dt 27 Aug 12.
document.onkeydown = function()
{
	if(window.event && window.event.keyCode == 116)
	{ // Capture and remap F5
		window.event.keyCode = 505;
	}

	if(window.event && window.event.keyCode == 505)
	{ // New action for F5
		return false;
	  // Must return false or the browser will refresh anyway
	}
}
var myclose = false;   
function confWindowClose()
{
	if (event.clientY < 0)
	{
		//event.returnValue = 'Your Session is going to be Invalidated.';      
		//setTimeout('myclose=false',100);      
		myclose=true;      
	}
}
function handleOnClose()
{
	if (myclose==true)       
	{
		alert("Window is closed");
		document.forms[0].action="../../../WindowCloseSessionOut.do";
		document.forms[0].submit();   
	}
}
var myclose = false;   
function confWindowClose()
{
	if (event.clientY < 0)
	{
		//event.returnValue = 'Your Session is going to be Invalidated.';      
		//setTimeout('myclose=false',100);      
		myclose=true;      
	}
}
function handleOnClose()
{
	if (myclose==true)       
	{
		document.forms[0].action="../../../WindowCloseSessionOut.do";
		//alert("Your session is Invalidated");
		document.forms[0].submit();   
	}
}
function handleOnClose1()
{
	if (myclose==true)       
	{
		document.forms[0].action="../../WindowCloseSessionOut.do";
		//alert("Your session is Invalidated");
		document.forms[0].submit();   
	}
}


function getXmlHttpReq() 
{
	var req;
	var ElmId;
	if(window.XMLHttpRequest && !(window.ActiveXObject)) {
		try {
			req = new XMLHttpRequest();
		} catch(e) {
			req = false;
		}
// branch for IE/Windows ActiveX version
	} else if(window.ActiveXObject) {
		try {
			req = new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e) {
				req = false;
			}
		}
	}				
	return req;
}

function getXML(url,param)
{
   // alert(url+"------"+param)
    var xml;
    var Req = getXmlHttpReq();
	//alert(Req)
    Req.open("Post", url, false);
    Req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    Req.setRequestHeader("Content-length", param.length);
    Req.setRequestHeader("Connection", "close");
    Req.onreadystatechange = function()
    {
      if (Req.readyState == 4 )
      {		
        xml = Req.responseXML;
      }
  	};
   Req.send(param);
   return xml;
}

function deleteRows(Table,Index){
	var Rows = Table.rows.length;
	if (Rows > Index ){
		for (var j=Index;j<Rows;j++){
			Table.deleteRow(Index);
		}
	}
}
function checkEmployee(emp_num,siteid)
{
	//alert("inside checkEmployee")
	url1="../../../ValidateEmployee.do";
    prm1="mode=1&p_emp_num="+emp_num+"&p_site_id="+siteid;
	xml1=getXML(url1,prm1);
	Tags=xml1.getElementsByTagName("record");
	var if_valid="";
	if(Tags.length>0)
	{
		if_valid=Tags[0].childNodes[0].nodeValue;
		//alert(if_valid);
	}
	if(if_valid==0)
	{
		alert("Employee does not exist. Enter a valid employee number.");
		return false;
	}
	else
	{
		return true;
	}
}
//added by priyanka
function getFinyr(yearM1)
{
    var y1=yearM1.substring(0,4);
    var y2=eval(yearM1.substring(4,6));
    var y=(eval(y1)+1).toString();
    var y3= (y.substring(2,4));
    if(y2=='1'|| y2=='2'|| y2=='3')
    {
      return (((eval(y1)-1).toString()).concat(((eval(y3)-1).toString())));
    }
    else
    {
      return (y1.concat(y3));
    }
}

// This function returns Internet Explorer's major version number,
// or 0 for others. It works by finding the "MSIE " string and
// extracting the version number following the space, up to the decimal
// point, ignoring the minor version number
function msieversion()
   {
   alert("1")
      var ua = window.navigator.userAgent
      var msie = ua.indexOf ( "MSIE " )

      if ( msie > 0 )      // If Internet Explorer, return version number
      {
         alert("hi");
         return parseInt (ua.substring (msie+5, ua.indexOf (".", msie )))
      }
      else                 // If another browser, return 0
      {
         alert("Please run the application on Internet Explorer only");
         prompt("Please run the application on Internet Explorer only");
         return;
      }

   }


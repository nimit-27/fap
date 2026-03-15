var recordNum=0
var argCount
var items
var arrAttributeNames
var arrDataBase
 
function mandatory_check(){
  var elems=document.all;
  for(i=0; i<elems.length; i++){
    if(elems[i].tagName=="INPUT" || elems[i].tagName=="SELECT" || elems[i].tagName=="TEXTAREA" ){
      if(elems[i].className && elems[i].className=="required"){
        if(trim(elems[i].value)==""){
          alert("Please fill in "+ elems[i].alt);
          elems[i].focus();
          return false;
        }
      }
    }
  }
}

function disable_all(){
  var len=arguments.length;
  var elems=document.all;
  for(i=0; i<elems.length; i++){
    if(elems[i].tagName=="INPUT" || elems[i].tagName=="SELECT" || elems[i].tagName=="TEXTAREA" ){
         for(j=0;j<len;j++){
            if(arguments[j].name==elems[i].name){
              elems[i].disabled=false;
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
         for(j=0;j<len;j++){
            if(arguments[j].name==elems[i].name){
              elems[i].disabled=true;
            }
            else{
              elems[i].disabled=false;
            }
         }
    }
  }
} 

function openCalandar(a) {
	var cal1 = new calendar1(a);
	cal1.popup();
	cal1.year_scroll = true;
	cal1.time_comp = false;
	return;
}
function today(){
	day=new Date()
	month = day.getMonth()
	date = day.getDate()
	year=day.getYear(); 
	theDate=date + "/" + month + "/" + year
	return(theDate)
}
function openLOV(arg) {
	var retval=window.showModalDialog("../INCLUDES/lov.html","LOV","dialogHeight=300,dialogWidth=300,scroll=no,status=no,resizable=no")	
	arg.value=(retval==null)?arg.value:retval
}
function getCookieVal (offset) {  
	var endstr = document.cookie.indexOf (";", offset);  
	if (endstr == -1)    
		endstr = document.cookie.length;  
	return unescape(document.cookie.substring(offset, endstr));
}
function getCookie (name) {  
	var arg = name + "=";  
	var alen = arg.length;  
	var clen = document.cookie.length;  
	var i = 0;  
	while (i < clen) {    
		var j = i + alen;    
		if (document.cookie.substring(i, j) == arg)      
		return getCookieVal (j);    
		i = document.cookie.indexOf(" ", i) + 1;    
		if (i == 0) break;   
	}  
	return null;
}
function setCookie (name, value) {  
	var argv = SetCookie.arguments;  
	var argc = SetCookie.arguments.length;  
	var expires = (argc > 2) ? argv[2] : null;  
	var path = (argc > 3) ? argv[3] : null;  
	var domain = (argc > 4) ? argv[4] : null;  
	var secure = (argc > 5) ? argv[5] : false;  
	document.cookie = name + "=" + escape (value) + 
	((expires == null) ? "" : ("; expires=" + expires.toGMTString())) + 
	((path == null) ? "" : ("; path=" + path)) +  
	((domain == null) ? "" : ("; domain=" + domain)) +    
	((secure == true) ? "; secure" : "");
}


function addRow(){
	if(addRow.arguments.length)
	{
		argv=addRow.arguments
		rows=argv[0]
		for(c=0;c<rows;c++)
		{
			recordNum=saveData(recordNum,0)
			showDtl()
		}
	}
	else
	{
		if(recordNum!=0){
			recordNum=saveData(recordNum,0)
			showDtl()
			
			getData(recordNum)
		}
		else{
			saveData(recordNum,0)
			recordNum=1 
			showDtl()
		}
	}
}

function delRow(){
	recordNum=saveData(recordNum,1)
	showDtl()
	
	getData(recordNum)
}


function initData(){
	arrAttributeNames=new Array();
	var argv=initData.arguments
	argCount=initData.arguments.length	
	for(i=0;i<argCount;i++){
		arrAttributeNames[i]=argv[i];
	}
}
	
function saveData(recordNum,delFlag)
{
	
	var k=0
	var flag=0
	delete items
	items=new Object()
	for(i=0;i<recordNum;i++){
		if(delFlag==1){
			if(!document.getElementById('chkRow'+i).checked){
				items[k]=new Array()
				for(j=0;j<argCount;j++){
					var obj=document.getElementById(arrAttributeNames[j]+i)
					val=(obj.type=='checkbox')?obj.checked:obj.value
					items[k][j]=val
				}
				flag=1
				k++
			}
			
		
		}
		else{
			if(document.getElementById('chkRow'+i).checked){
				items[k]=new Array()
				for(j=0;j<argCount;j++){
					var obj=document.getElementById(arrAttributeNames[j]+i)
					val=(obj.type=='checkbox')?0:""
					items[k][j]=val
				}
				k++
				flag=2
				
			}
			items[k]=new Array()
			for(j=0;j<argCount;j++){
				var obj=document.getElementById(arrAttributeNames[j]+i)
				val=(obj.type=='checkbox')?obj.checked:obj.value
				items[k][j]=(val)?val:""
			}
			k++
		}

	}
	if(flag==1){
		k=k
	}
	else{
		if(flag!=2){
			items[k]=new Array()
			i=i-1
			for(j=0;j<argCount;j++){
				var name=arrAttributeNames[j]
				val=(name.charAt(0)=='c')?0:""
				items[k][j]=val
			}
			k++
		}
	}
	return(k)
}

function getData(recordNum)
{
		for(i=0;i<recordNum;i++){
			
			for(j=0;j<argCount;j++){
				var obj=document.getElementById(arrAttributeNames[j]+i)
				if(obj.type=='checkbox')
					obj.checked=items[i][j]
				if(obj.type!='button')
					obj.value=items[i][j] 
			}
		}
}
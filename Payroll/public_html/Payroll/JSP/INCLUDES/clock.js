

function runClock() {
theTime = window.setTimeout("runClock()", 1000);
var today = new Date();
var display= today.toLocaleString();
var str1=display.slice(0,10);
var str2=display.slice(11,19);
if(document.all("dat")){
document.all("dat").innerHTML="Date :"+str1;
document.all("tim").innerHTML="Time :"+str2;
}
}

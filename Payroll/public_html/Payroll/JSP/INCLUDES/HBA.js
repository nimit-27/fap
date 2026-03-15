function HBA(){
document.all.item("prop").disabled = true;
document.all.item("prop").style.background="#d9ecff";//"#c0c0c0";
/*document.all.item("app_flo_nmbr").style.background="#c0c0c0";
document.all.item("app_flo_nmbr").className="A";
document.all.item("app_due_date").disabled=true;
document.all.item("app_due_date").style.background="#c0c0c0";
document.all.item("app_due_date").className="A";
document.all.item("app_adtnl_amnt").disabled=true;
document.all.item("app_adtnl_amnt").style.background="#c0c0c0";*/
}

function HBA1(value){
if (value = 1)
{
document.all.item("dtls").disabled = true;
document.all.item("dtls").style.background="#d9ecff";//"#c0c0c0";
}
else
{
document.all.item("dtls").disabled = false;
document.all.item("dtls").style.background="#ffffff";//"#c0c0c0";
}
/*document.all.item("app_flo_nmbr").style.background="#c0c0c0";
document.all.item("app_flo_nmbr").className="A";
document.all.item("app_due_date").disabled=true;
document.all.item("app_due_date").style.background="#c0c0c0";
document.all.item("app_due_date").className="A";
document.all.item("app_adtnl_amnt").disabled=true;
document.all.item("app_adtnl_amnt").style.background="#c0c0c0";*/
}
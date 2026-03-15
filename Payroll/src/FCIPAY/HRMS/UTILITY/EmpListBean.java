package FCIPAY.HRMS.UTILITY;
import java.util.ArrayList;
/*
* Module      :        EmpListBean.java
* Author      :        Anand Balasubramanian
* Date Written:  10/09/2003
* Description :  Bean object that would hold category,cadre,posts and employee type details which
* would be used in populating dropdowns
* Revision Log:  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/
public class EmpListBean 
{
    private long ETID;   //EmployeeTypeid 
    private long CID; //Categoryid
    private long CADID;   //Cadreid
    private long CadCatId;    //CadreCategoryid
    private String ETDesc;    //EmployeeType Description
    private String CDesc; //Category Description
    private String CADDesc; //CadreDescription
    private long PId; //Postid
    private String PDesc=null; //Posts name
    private String PScale; //PayScale
    private String txtRmks="";  
    private String scrudt_chg;
    private String scrDt1;
    private String scrDt2;
    private int icrdtlevel;
    private String sname="";
    private String seno="";
    private String sdob="";
    private String saqlid="";
    private String saqldesc="";
    private String stqlid="";
    private String stqldesc="";
    private String spqlid="";
    private String spqldesc="";
    private String stryr;
    private String strBt;
    private String sgrdt;
    private String sfitdtl;
    private String sfit;
    private String szocDtl;
    private String sconsForScreening;
    private String snoOfGradings;
    private String scr1;
    private String scr2;
    private String scr3;
    private String scr4;
    private String sqlmks;
    private String spercentage;
    private String lstgrade;
    private ArrayList prghistList=new ArrayList(1);
    private String sroleflg;
    private String sperfFlg;
    private String sinitflg;
    private String srelflg;
    private String ssupervision;
    private String sresponflg;
    private String sdisflg;
    private String advRemarks;
    private String txtExptMember;
    private String txtCR;
    private String txtEffPDT;
    private String txtEffPPos;
    
    public EmpListBean(){}
    public EmpListBean(int piflag,long pletid,String psetdesc)
    {
    if (piflag==0){ //EmpType
        this.ETID=pletid;
        this.ETDesc=psetdesc;
    }
    else if (piflag==1){ //Category
      this.CID=pletid;
      this.CDesc=psetdesc;
    }
    }
    public EmpListBean(int piflag,long pletid,String psetdesc,long plcdcatid){
        if (piflag==0){ //Cadre along with category
          this.CADID=pletid;
          this.CADDesc=psetdesc;
          this.CadCatId=plcdcatid;
          System.out.println("Cadre");
        }
    }

    public EmpListBean(int piTypeflag,long plPostid,String psPostname,String psPayscale){
        if (piTypeflag ==0){ //Block Type
            this.PId=plPostid;
            this.PDesc=psPostname;
        }
        else if(piTypeflag ==1){
            this.PId=plPostid;
            this.PDesc=psPostname;
            this.PScale=psPayscale;
        }
    }
    //CRLIST Generation
    public EmpListBean(int piTypeflag,long plPostid,String psPostname,String psPayscale,String psSectionname){
        if (piTypeflag ==0){ //Block Type
            this.PId=plPostid;
            this.PDesc=psPostname;
        }
        else if(piTypeflag ==1){
            this.PId=plPostid; //CR Grading
            this.PDesc=psPostname; //Start Period
            this.PScale=psPayscale; //End Period 
            this.ETDesc=psSectionname; //CR Grade Desc
            System.out.println(psPostname+"-"+psPayscale+"-"+psSectionname+"-");
        }
        else if (piTypeflag ==2){ //ZOC to add change of crucial date flag
            this.PId=plPostid;
            this.PDesc=psPostname;
            this.PScale=psPayscale;
            this.scrudt_chg=psSectionname;
        }
        else if(piTypeflag ==3){  //For grade details
            this.CID=plPostid; //Category id
            this.lstgrade=psPostname; //Grade id
            this.PDesc=psSectionname; //Grade desc
            this.PScale=psPayscale;
        }
        else{
            this.CID=piTypeflag;
            this.PId=plPostid;  //Eno
            this.PDesc=psPostname; //Strtdate
            this.PScale=psPayscale; //end date
            this.ETDesc=psSectionname; //grade
        }
        
    }
    public EmpListBean(int piTypeflag,long plPostid,String psPostname,String psPayscale,String psSectionname,String psAdvRemarks ){
        this.PId=plPostid; //CR Grading
        this.PDesc=psPostname; //Start Period
        this.PScale=psPayscale; //End Period 
        this.ETDesc=psSectionname; //CR Grade Desc
        this.advRemarks = psAdvRemarks; //Adverse remarks.
    }
    //Crucial Dates Bean
    public EmpListBean(int piTypeflag,String psCrdt1,String psCrdt2,int piCrDt){
        if(piTypeflag ==0){
            this.scrDt1=psCrdt1;
            this.scrDt2=psCrdt2;
            System.out.println("Inside Bean -CRDT1/CRDT2" + piCrDt);
            this.icrdtlevel=piCrDt; //To find whether it's crucial date 1 or crucial date 2
        }            
    }

    //Grade listing for ZOC
    public EmpListBean(int piTypeflag,long plPostid,String psPostname,String psPayscale,String psSectionname,String psCrdt1,String psCrdt2){
        if (piTypeflag ==2){
            this.PId=plPostid;
            this.PDesc=psPostname;
            this.PScale=psPayscale;
            this.scrudt_chg=psSectionname;
            this.scrDt1=psCrdt1;
            this.scrDt2=psCrdt2;
        }
        if (piTypeflag ==1){
            this.PId=plPostid;
            this.PDesc=psPostname;
            this.PScale=psPayscale;
            this.scrudt_chg=psSectionname;
            this.scrDt1=psCrdt1;
            this.scrDt2=psCrdt2;
        }        
    }

    public EmpListBean(int piTypeflag,String pseno,String psename,String psdob,String psTryr,String psTrBt,int pigrid,String psgrDesc,String psgrDt,long plETid,String psEtype,String psResCateg,String psFitDtl,String psFit ,int pliddd){
        this.seno=pseno;
        this.sname=psename;
        this.sdob=psdob;
        this.stryr=psTryr;
        this.strBt=psTrBt;
        this.PId=pigrid;
        this.PDesc=psgrDesc;
        this.sgrdt=psgrDt;
        this.ETID=plETid;
        this.ETDesc=psEtype;
        this.CDesc=psResCateg;
        this.sfitdtl=psFitDtl;
        this.sfit=psFit;    
    }

    public EmpListBean(int piTypeflag,String pseno,String psename,String psdob,String psTryr,String psTrBt,int pigrid,String psgrDesc,String psgrDt,long plETid,String psEtype,String psResCateg,String psFitDtl,String psFit ,String psPerc){
    //Used to show employee details in zoc list and also in gradewise screening list
        this.seno=pseno;
        this.sname=psename;
        this.sdob=psdob;
        this.stryr=psTryr;
        this.strBt=psTrBt;
        this.PId=pigrid;
        this.PDesc=psgrDesc;
        this.sgrdt=psgrDt;
        this.ETID=plETid;
        this.ETDesc=psEtype;
        this.CDesc=psResCateg;
        this.sfitdtl=psFitDtl;
        this.sfit=psFit;
        this.spercentage=psPerc;
    }    
    //EmpListBean populated for recommendation list
    public EmpListBean(int piTypeflag,long plZocDtlId,String psEno,String psEname,long plPrgrid,String psPrgrdt,String psPrgrDesc,long plTogr,String psTogrDesc,String psCrdt,String psdob,long plETid,String psETDesc,String psResCateg,String psZOCMastid)
    {
        this.CADID=plZocDtlId; //ZocDtlid
        this.seno=psEno;
        this.sname=psEname;
        this.CID=plPrgrid;  //Present Grade Id
        this.scrDt2=psPrgrdt; //Present Grade Date
        this.CADDesc=psPrgrDesc; //Presetn Grade Desc
        if (piTypeflag ==1){
            this.lstgrade=Long.toString(plTogr);
        }
        else{
            this.PId=plTogr; //To Gradeid
        }            
        this.PDesc=psTogrDesc; //To Grade Desc
        this.scrDt1=psCrdt; //Crucial Date
        this.sdob=psdob;
        this.ETID=plETid;
        this.ETDesc=psETDesc;
        this.stqldesc=psResCateg;
        this.CDesc=psZOCMastid;        
    }   

    //Populate Bean for Screening List
    public EmpListBean(int piTypeflag,long plZocMastId,String psFrmGrd,String psToGrd,String psutid,String psZOCType,String psCRDT,String psDtlDesc)
    {
        if (piTypeflag ==0){
             this.CID=plZocMastId;
            this.PDesc=psFrmGrd;
            this.CDesc=psToGrd;
            this.CADDesc=psutid;
            this.ETDesc=psZOCType;
            this.scrDt1=psCRDT;
            this.szocDtl=psDtlDesc;
        }
        if (piTypeflag == 1){ //used in probation closure list
            this.CID=plZocMastId; //Empno
            this.PDesc=psFrmGrd; //Empname
            this.CDesc=psToGrd; //Status
            this.CADDesc=psutid; //Probation due date
            this.ETDesc=psZOCType; //unit id
            this.scrDt1=psCRDT; //unit desc
            this.szocDtl=psDtlDesc; //days /sectionname
        }
    }

    public EmpListBean(int piTypeflag,long plPostid,String psPostname,String psPayscale,String psSectionname,int piDummy){
            this.CID=piTypeflag;
            this.PId=plPostid;  //Eno
            this.PDesc=psPostname; //Strtdate
            this.PScale=psPayscale; //end date
            this.ETDesc=psSectionname; //grade
    
    }

    public EmpListBean(int piTypeflag,String pseno,String psename,String psdob,String psuid,String psudesc,String psdoj,String psprgrdt,String psGrdesc,String psResKey,String psResCateg,String psRecExists){
        this.seno=pseno;  //empno
        this.sname=psename; //empname
        this.sdob=psdob; //dob
        this.stryr=psuid; //unit id
        this.strBt=psudesc; //unit desc
        this.PDesc=psdoj; //Doj
        this.sgrdt=psGrdesc; //Present grade date
        this.ETDesc=psprgrdt; //Grade desc
        this.CDesc=psResKey; //Rescateg id
        this.sfitdtl=psResCateg; //Reservation category desc
        this.scrudt_chg=psRecExists ; //Flag value showing if  record already exists or not
        
    }
    //Overloaded constructor used for generation Promotion Order list
    public EmpListBean(int piTypeflag,long plZocDtlId,String psEno,String psEname,long plPrgrid,String psPrgrdt,String psPrgrDesc,long plTogr,String psTogrDesc,String psCrdt,String psdob,long plETid,String psETDesc,String psResCateg,String psZOCMastid,String psChAssumptionDt,String psCategoryid,String psCategoryDesc,String psGroup,String psDesignationId,String psDesignationDesc,String psBasicPay,String psChangeinGrp)
    {
        this.CADID=plZocDtlId; //ZocDtlid
        this.seno=psEno;
        this.sname=psEname;
        this.CID=plPrgrid;  //Present Grade Id
        this.scrDt2=psPrgrdt; //Present Grade Date
        this.CADDesc=psPrgrDesc; //Presetn Grade Desc
        this.PId=plTogr; //To Gradeid
        this.PDesc=psTogrDesc; //To Grade Desc
        this.scrDt1=psCrdt; //Crucial Date
        this.sdob=psdob;
        this.ETID=plETid; //Unit id
        this.ETDesc=psETDesc; //Unit Desc
        this.stqldesc=psResCateg;
        this.CDesc=psZOCMastid;
        this.scrudt_chg=psChAssumptionDt; //Charge Assumption Date
        this.saqlid=psCategoryid;  //Category Id
        this.saqldesc=psCategoryDesc; //Category Desc
        this.stqlid=psGroup; //Group
        this.stqldesc=psDesignationId ; //Designation Id
        this.spqldesc=psDesignationDesc;
        this.sqlmks=psBasicPay; //Basic Pay
        this.sconsForScreening=psChangeinGrp; //Change in Group Flag
    }   
//Probation List
    public EmpListBean(int piTypeflag,long plEno,String psEname,String psStatus,String psDueDt,String psUnitid,String psUnitDesc,String psSectionid,String psSectionname,String psDoj,String psPeriod,String psDOAPrgr,String psDS_GR_Id,String psDS_GR_Desc){
        if (piTypeflag == 1){
            this.CID=plEno; //Empno
            this.PDesc=psEname; //Empname
            this.CDesc=psStatus; //Status
            this.CADDesc=psDueDt; //Probation due date
            this.ETDesc=psUnitid; //unit id
            this.scrDt1=psUnitDesc; //unit desc
            this.szocDtl=psSectionname; //days /sectionname
            this.ETDesc=psSectionid; //Section id
            this.sfitdtl=psDoj; //Doj npc
            this.scrudt_chg=psPeriod ; //Period of Probation
            this.scr1=psDOAPrgr; //Date of appointment present grade
            this.scr2=psDS_GR_Id ;//Designation/Grade id
            this.scr3=psDS_GR_Desc ;//Designation /Grade Desc
        }            
    }
    public EmpListBean(int piTypeflag,String pseno,String psename,String psdob,String psuid,String psudesc,String psdoj,String psprgrdt,String psGrdesc,String psResKey,String psResCateg,String psRecExists,String psPdt,String psPPos,String psEPdt,String psEPPos){
        this.seno=pseno;  //empno
        this.sname=psename; //empname
        this.sdob=psdob; //dob
        this.stryr=psuid; //unit id
        this.strBt=psudesc; //unit desc
        this.PDesc=psdoj; //Doj
        this.sgrdt=psGrdesc; //Present grade date
        this.ETDesc=psprgrdt; //Grade desc
        this.CDesc=psResKey; //Rescateg id
        this.sfitdtl=psResCateg; //Reservation category desc
        this.scrudt_chg=psRecExists ; //Flag value showing if  record already exists or not
        this.txtExptMember=psPdt;
        this.txtCR=psPPos;
        this.txtEffPDT=psEPdt;
        this.txtEffPPos=psEPPos;
    }

    public EmpListBean(int piTypeflag,String pseno,String psename,String psdob,String psuid,String psudesc,String psdoj,String psprgrdt,String psGrdesc,String psResKey,String psResCateg,String psRecExists,String psPdt,String psPPos,String psEPdt,String psEPPos,String psDS_GR_Desc){
        this.seno=pseno;  //empno
        this.sname=psename; //empname
        this.sdob=psdob; //dob
        this.stryr=psuid; //unit id
        this.strBt=psudesc; //unit desc
        this.PDesc=psdoj; //Doj
        this.sgrdt=psGrdesc; //Present grade date
        this.ETDesc=psprgrdt; //Grade desc
        this.CDesc=psResKey; //Rescateg id
        this.sfitdtl=psResCateg; //Reservation category desc
        this.scrudt_chg=psRecExists ; //Flag value showing if  record already exists or not
        this.txtExptMember=psPdt;
        this.txtCR=psPPos;
        this.txtEffPDT=psEPdt;
        this.txtEffPPos=psEPPos;
        this.scr3=psDS_GR_Desc ;
    }

    // Used for storing the promotion norms
  
    public EmpListBean(int piTypeflag,long plNormMastId,long plExp,String psFrmGrd,String psToGrd,String psutid,String psZOCType,String psCRDT,String psDtlDesc,String psEligExp,String psQlfnType,String psAddQlfn)
    {
        if (piTypeflag ==0){
            this.CADID=plNormMastId; // Criteria Id
            this.CID=plExp; // Experience
            this.PDesc=psFrmGrd; //No. of crs
            this.CDesc=psToGrd; // Cr All
            this.CADDesc=psutid; // Cr Atleast One
            this.ETDesc=psZOCType; // Marks
            this.scrDt1=psCRDT; // Cr all
            this.szocDtl=psDtlDesc; // Cr atleast one
            this.stryr=psEligExp; // Min. Elig Period
            this.stqldesc=psQlfnType; //Qualification Type
            this.sqlmks=psAddQlfn; // Add Qlfn
        }

    }
    public void setETID(long plETID){this.ETID=plETID;}
    public long getETID(){return this.ETID;}
  
    public void setETDesc(String psETDesc){this.ETDesc=psETDesc;}
    public String getETDesc(){return this.ETDesc;}
  
    public void setCID(long plCatID){this.CID=plCatID;}
    public long getCID(){return this.CID;}
  
    public void setCDesc(String psCatDesc){this.CDesc=psCatDesc;}
    public String getCDesc(){return this.CDesc;}
  
    public void setCADID(long plCadID){this.CADID=plCadID;}
    public long getCADID(){return this.CADID;}

    public void setCADDesc(String psCadDesc){this.CADDesc=psCadDesc;}
    public String getCADDesc(){return this.CADDesc;}

    public void setPId(long plPId){this.PId=plPId;}
    public long getPId(){return this.PId;}

    public void setPDesc(String psPDesc){this.PDesc=psPDesc;}
    public String getPDesc(){return this.PDesc;}
    
    public void setPScale(String psPScale){this.PScale=psPScale;}
    public String getPScale(){return this.PScale;}

    public void settxtRmks(String pstxtRmks){this.txtRmks=pstxtRmks;}
    public String gettxtRmks(){return this.txtRmks;}  

    public String getScrudt_chg(){return scrudt_chg;}
    public void setScrudt_chg(String newScrudt_chg){scrudt_chg = newScrudt_chg;}

    public String getScrDt1(){return scrDt1;}
    public void setScrDt1(String newScrDt1){scrDt1 = newScrDt1;}

    public String getScrDt2(){return scrDt2;}
    public void setScrDt2(String newScrDt2){scrDt2 = newScrDt2;}

    public int getIcrdtlevel(){return icrdtlevel;}
    public void setIcrdtlevel(int newIcrdtlevel){icrdtlevel = newIcrdtlevel;}

    public String getSname(){return sname;}
    public void setSname(String newSname){sname = newSname;}

    public String getSeno(){return seno;}
    public void setSeno(String newSeno){seno = newSeno;}

    public String getSdob(){return sdob;}
    public void setSdob(String newSdob){sdob = newSdob;} //advRemarks

    public String getAdvRemarks(){return advRemarks;}
    public void setAdvRemarks(String newAdvRemarks){advRemarks = newAdvRemarks;} //advRemarks

    public String getSaqlid(){return saqlid;}
    public void setSaqlid(String newSaqlid){saqlid = newSaqlid;}
    
    public String getSaqldesc(){return saqldesc;}
    public void setSaqldesc(String newSaqldesc){saqldesc = newSaqldesc;}

    public String getStqlid(){return stqlid;}
    public void setStqlid(String newStqlid){stqlid = newStqlid;}

    public String getStqldesc(){return stqldesc;}
    public void setStqldesc(String newStqldesc){stqldesc = newStqldesc;}

    public String getSpqlid(){return spqlid;}
    public void setSpqlid(String newSpqlid){spqlid = newSpqlid;}

    public String getSpqldesc(){return spqldesc;}
    public void setSpqldesc(String newSpqldesc){spqldesc = newSpqldesc;}

    public String getStryr(){return stryr;}
    public void setStryr(String newStryr){stryr = newStryr;}

    public String getStrBt(){return strBt;}
    public void setStrBt(String newStrBt){strBt = newStrBt;}

    public String getSgrdt(){return sgrdt;}
    public void setSgrdt(String newSgrdt){sgrdt = newSgrdt;}

    public String getSfitdtl(){return sfitdtl;    }
    public void setSfitdtl(String newSfitdtl){sfitdtl = newSfitdtl;}

    public String getSfit(){return sfit;}
    public void setSfit(String newSfit){sfit = newSfit;}

    public String getSzocDtl(){return szocDtl;}
    public void setSzocDtl(String newSzocDtl){szocDtl = newSzocDtl;}

    public String getSconsForScreening(){return sconsForScreening;}
    public void setSconsForScreening(String newSconsForScreening){sconsForScreening = newSconsForScreening;}

    public String getSnoOfGradings(){return snoOfGradings;}
    public void setSnoOfGradings(String newSnoOfGradings){snoOfGradings = newSnoOfGradings;}

    public String getScr1(){return scr1;}
   public void setScr1(String newScr1){scr1 = newScr1;}
    
    public String getScr2(){return scr2;}
    public void setScr2(String newScr2){scr2 = newScr2;}

    public String getScr3(){return scr3;}
    public void setScr3(String newScr3){scr3 = newScr3;}

    public String getScr4(){return scr4;}
    public void setScr4(String newScr4){scr4 = newScr4;}

    public String getSqlmks(){return sqlmks;}
    public void setSqlmks(String newSqlmks){sqlmks = newSqlmks;}

    public String getSpercentage(){return spercentage;}
    public void setSpercentage(String newSpercentage){spercentage = newSpercentage;}

    public String getLstgrade(){return lstgrade;}
    public void setLstgrade(String newLstgrade){lstgrade = newLstgrade;}

    public ArrayList getPrghistList(){return prghistList;}
    public void setPrghistList(ArrayList newPrghistList){prghistList = newPrghistList;}

    public String getSroleflg()
    {
        return sroleflg;
    }

    public void setSroleflg(String newSroleflg)
    {
        sroleflg = newSroleflg;
    }

    public String getSperfFlg()
    {
        return sperfFlg;
    }

    public void setSperfFlg(String newSperfFlg)
    {
        sperfFlg = newSperfFlg;
    }

    public String getSinitflg()
    {
        return sinitflg;
    }

    public void setSinitflg(String newSinitflg)
    {
        sinitflg = newSinitflg;
    }

    public String getSrelflg()
    {
        return srelflg;
    }

    public void setSrelflg(String newSrelflg)
    {
        srelflg = newSrelflg;
    }

    public String getSsupervision()
    {
        return ssupervision;
    }

    public void setSsupervision(String newSsupervision)
    {
        ssupervision = newSsupervision;
    }

    public String getSresponflg()
    {
        return sresponflg;
    }

    public void setSresponflg(String newSresponflg)
    {
        sresponflg = newSresponflg;
    }

    public String getSdisflg()
    {
        return sdisflg;
    }

    public void setSdisflg(String newSdisflg)
    {
        sdisflg = newSdisflg;
    }

    public String getTxtExptMember() {
        return txtExptMember;
    }

    public void setTxtExptMember(String newTxtExptMember) {
        txtExptMember = newTxtExptMember;
    }

    public String getTxtCR() {
        return txtCR;
    }

    public void setTxtCR(String newTxtCR) {
        txtCR = newTxtCR;
    }

    public String getTxtEffPDT()
    {
        return txtEffPDT;
    }

    public void setTxtEffPDT(String newTxtEffPDT)
    {
        txtEffPDT = newTxtEffPDT;
    }

    public String getTxtEffPPos()
    {
        return txtEffPPos;
    }

    public void setTxtEffPPos(String newTxtEffPPos)
    {
        txtEffPPos = newTxtEffPPos;
    }

}
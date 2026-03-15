package FCIPAY.HRMS.UTILITY;

public class EmpBean 
{
    private long lEmpId;
    private String sGrade;
    private String sDojNpc;
    private String sRet_Norm_Dt;
    private String sename;
    private String sdob;
    private String scateg;
    private String scategid;
    private String sgrade;
    private String sgradeid;
    private String srescateg;
    private String setype;
    private String setypeid;                      
    private String sprGrDt;
    private String sunit;
    private String sunitId;
    private String sdoj;
    private String spayScale="";
    private String spromEffDt="";
    private String sdrctId;
    private String sposts;
    private String sprGrp;
    private String spromotedGrp;
    private String scaddesc;
    private String sprCatid;
    private String sprDsgnid;
    private String sevntno;
    private String srolesflg;
    private String sperflg;
    private String sinitflg;
    private String srelflg;
    private String ssupflg;
    private String swilflg;
    private String sdisflg;
    private String srolesRmks;
    private String sperfRmks;
    private String sinitRmks;
    private String srelRmks;
    private String ssupRmks;
    private String swilRmks;
    private String sdiscRmks;
    private String scoopflg;
    private String scoopRmks;
    private String scaVerify;
    private String ssqVerify;
    private String sfinalRmks;
    private String sgrpId;
    private String sgrpDesc;
    private String sunitToId;
    private String sunitToDesc;
    private String sdrcrtTo;
    private String ssectTo;
    private String sgrpTo;
    private String frmUnit="";
    private String txtEmpNo;
    private String srepOffName;
    private String srepOffdsgn;
    private String srepApprDt;
    private String srepOffRmks;
    private String srevOffName;
    private String srevOffdsgn;
    private String srevOffRemks;
    private String srevApprDt;
    private String sestOffName;
    private String sestOffDsgn;
    private String sestOffRemks;
    private String sestApprDt;

    public EmpBean(){}
    public EmpBean(long plEmpId,String psGrade,String psDojNpc,String psRet_Norm_Dt)
    {
        this.lEmpId = plEmpId;
        this.sGrade = psGrade;
        this.sDojNpc = psDojNpc;
        this.sRet_Norm_Dt = psRet_Norm_Dt;
/*
         // this.getlEmpId()=qtr_id; // hidden var for getting the id
            this.scategid=qrtFrom; //from date
            this.scateg=qrtTo;//To date
            this.sgradeid=qrtCrg;// unitcharge
*/

        
    
    }

    public EmpBean(int piTypeflag,String psDsgnId,String psDsgnDesc,String psGrp){
        if (piTypeflag ==0){
            this.scategid=psDsgnId; //Designation id
            this.scateg=psDsgnDesc;//Designation Description
            this.sgradeid=psGrp;
        }
    }


    public EmpBean(int piTypeflag,long plManpowId,String psUnitid,String psCategId,String psGradeid,String psGrpId,String psNoofVacantPosts,String psCategdesc){
        if (piTypeflag ==0){
            this.lEmpId=plManpowId; //Manpower id
            this.sunitId=psUnitid; //Unit
            this.sgradeid=psGradeid; //Grade
            this.sdob=psNoofVacantPosts ; //No of vacant posts
            this.scategid=psCategId;
            this.scateg=psCategdesc;
            this.sdrctId=psGrpId;
            this.sposts="";
        }
    
    }
     public EmpBean(int piTypeflag,long plEmpno,String psEname,String psDob,String psUnitid,String psUnitDesc,String psDOJ,String psPrgrDt,String psGid,String psGDesc,String psResCateg,String psResDesc,String psEtypeId,String psEtypeDesc,String psCategId,String psCategDesc,String psDrcrtId,String psGrp)
    {
        
        if (piTypeflag == 0){
            this.lEmpId=plEmpno;
            this.sename=psEname;
            this.sdob=psDob;
            this.sunitId=psUnitid;
            this.sunit=psUnitDesc;
            this.sdoj=psDOJ;
            this.sprGrDt=psPrgrDt;
            this.sgradeid=psGid;
            this.sgrade=psGDesc;
            this.srescateg=psResCateg;
            this.sRet_Norm_Dt=psResDesc;
            this.setype=psEtypeDesc;
            this.setypeid=psEtypeId;
            this.scateg=psCategDesc;
            this.scategid=psCategId;
            this.spayScale="";
            this.spromEffDt="";
            this.sdrctId=psDrcrtId;
            this.sprGrp=psGrp;
        }
    }
//Constructor predominantly called in confirmation appraisal detail retrieval/probation appraisal detail retrieval
    public EmpBean(int piTypeflag,String psApprId,long plEmpno,String psEname,String psUnitid,String psUnitDesc,String psGid,String psGDesc,String psCategId,String psCategDesc,String psDrcrtId,String psGrp,String psProbStatus,String psProbClsDate,String psExtMnths,String psExtDt,String psDiscStatus,String psDiscDet,String psRolrtg,String psRolrmks,String psPerfrtg,String psPerfrmks,String psInitrtg,String psInitrmks,String psRelrtg,String psRelrmks,String psSupervisionrtg,String psSuperRmks,String psResprtg,String psResprmks,String psDiscrtg,String psDiscrmks,String pscoopflg,String pscoopRmks,String psDoj,String psSectionid,String psSectionname)
    {
        if (piTypeflag == 0){
            this.sevntno=psApprId;
            this.lEmpId=plEmpno; //Empno
            this.sename=psEname;
            this.sunitId=psUnitid;
            this.sunit=psUnitDesc;
            this.sgradeid=psGid;
            this.sgrade=psGDesc;
            this.scateg=psCategDesc;
            this.scategid=psCategId;
            this.sdrctId=psDrcrtId;
            this.sprGrp=psGrp;
            this.sDojNpc=psDoj;
            this.setype=psSectionname;
            this.setypeid=psSectionid;
            if(psProbStatus.equals("C")){
                this.srescateg="Probation can be Closed";//Probation status
            }
            else if (psProbStatus.equals("E")){
                this.srescateg="Probation can be Extended";//Probation status
            }
            else{
                this.srescateg=psProbStatus;
            }
            this.spromEffDt=psProbClsDate; //Probation closure date
            this.sprGrDt=psExtDt; //Probation extended date
            this.spromotedGrp=psExtMnths; //No of months probation extended
            this.scaddesc=psDiscDet; //Disciplinary Details
            this.sdob=psDiscStatus; //Disciplinary action status
            if (psRolrtg.lastIndexOf("$")!=-1){
                this.srolesflg=psRolrtg.substring(psRolrtg.lastIndexOf("$")+ 1,psRolrtg.length());
            }                
            this.srolesRmks=psRolrmks;
            if (psPerfrtg.lastIndexOf("$")!=-1){
                this.sperflg=psPerfrtg.substring(psPerfrtg.lastIndexOf("$")+ 1,psPerfrtg.length());
            }                
       
            this.sperfRmks=psPerfrmks;
            if (psInitrtg.lastIndexOf("$")!=-1){
                this.sinitflg=psInitrtg.substring(psInitrtg.lastIndexOf("$")+ 1,psInitrtg.length());
            }      
            this.sinitRmks=psInitrmks;
            if (psRelrtg.lastIndexOf("$")!=-1){
                this.srelflg=psRelrtg.substring(psRelrtg.lastIndexOf("$")+ 1,psRelrtg.length());
            }      
            this.srelRmks=psRelrmks;
            if (psSupervisionrtg.lastIndexOf("$")!=-1){
                this.ssupflg=psSupervisionrtg.substring(psSupervisionrtg.lastIndexOf("$")+ 1,psSupervisionrtg.length());
            }      
            this.ssupRmks=psSuperRmks;
            
            if (psResprtg.lastIndexOf("$")!=-1){
                this.swilflg=psResprtg.substring(psResprtg.lastIndexOf("$")+ 1,psResprtg.length());
            }      
            this.swilRmks=psResprmks;
            
            if (psDiscrtg.lastIndexOf("$")!=-1){
                this.sdisflg=psDiscrtg.substring(psDiscrtg.lastIndexOf("$")+ 1,psDiscrtg.length());
            }      
            this.sdiscRmks=psDiscrmks;
            if (pscoopflg.lastIndexOf("$")!=-1){
                this.scoopflg=pscoopflg.substring(pscoopflg.lastIndexOf("$")+ 1,pscoopflg.length());
            }      
            this.scoopRmks=pscoopRmks;
        }
        else if (piTypeflag ==1){
            this.sevntno=psApprId;
            this.lEmpId=plEmpno; //Empno
            this.sename=psEname;
            this.sunitId=psUnitid;
            this.sunit=psUnitDesc;
            this.sgradeid=psGid;
            this.sgrade=psGDesc;
            this.scateg=psCategDesc;
            this.scategid=psCategId;
            this.sdrctId=psDrcrtId;
            this.sprGrp=psGrp;
            this.sDojNpc=psDoj;
            this.setype=psSectionname;
            this.setypeid=psSectionid;
            this.srescateg=psProbStatus;
            this.scaddesc=psDiscDet; //Disciplinary Details
            this.sdob=psDiscStatus; //Disciplinary action status
            this.srolesflg=psRolrtg; //Work nature remarks
            this.srolesRmks=psRolrmks; //Work nature remarks
            this.sperflg=psPerfrtg;  //Accuracy Remarks
            this.sperfRmks=psPerfrmks; //Accuracy Remarks
            this.sinitflg=psInitrtg; //Keenness Remarks
            this.sinitRmks=psInitrmks; //Keenness Remarks
            this.srelflg=psRelrtg; //Reltation Remarks
            this.srelRmks=psRelrmks; //Relation Remarks
            this.ssupflg=psSupervisionrtg; //Discipline Remarks
            this.ssupRmks=psSuperRmks; //Discipline Remarks
            this.swilflg=psResprtg;  //Punctuality Remarks
            this.swilRmks=psResprmks; //Punctuality Remarks
            this.sdisflg=psDiscrtg; //Academic Qualification
            this.sdiscRmks=psDiscrmks; //Professional Qualification
            this.scoopflg=pscoopflg; //Technical Qualification
            this.scoopRmks=pscoopRmks; //Present Grade Date
            
        }
    }
    /**
     * Used in populating transfer order details for transfer through proposal type
     */
    public EmpBean(int piTypeflag,long plEmpno,String psEname,String psFrmUnitid,String psFrmUnitDesc,String psFrmDrcrtid,String psFrmDrctrDesc,String psFrmGrpid,String psFrmGrpDesc,String psSectid,String psFrmSectDesc,String psToUntId,String psToTransToname,String psMapname,String psCatId,String psCatDesc,String psSBType,String psSBTypeDesc,String psTrnsType,String psTrTypeDesc){
        if (piTypeflag ==0){
            lEmpId=plEmpno;
            sename=psEname;
            sunitId=psFrmUnitid;
            sunit=psFrmUnitDesc;
            sdrctId=psFrmDrcrtid;
            sdob=psFrmDrctrDesc;
            sgrpId=psFrmGrpid;
            sgrpDesc=psFrmGrpDesc;
            sdoj=psSectid;
            sDojNpc=psFrmSectDesc;
            sgradeid=psToUntId;
            sgrade=psToTransToname;
            scaddesc=psMapname;
            scategid=psCatId;
            scateg=psCatDesc;
            scoopflg=psSBType;
            scoopRmks=psSBTypeDesc;
            sdisflg=psTrnsType;
            sdiscRmks=psTrTypeDesc;
        }
    }
    /**Severance Order Population    *   */ 
    public EmpBean(int piTypeflag,long plEmpno,String psEname,String psFrmUnitid,String psFrmUnitDesc,String psFrmDrcrtid,String psFrmDrctrDesc,String psFrmGrpid,String psFrmGrpDesc,String psSectid,String psFrmSectDesc,String psGradeId,String psGradeDesc,String psPostsFlg,String psPostsSurrFlg,String psMapname,String psCatId,String psCatDesc,String psSBType,String psSBTypeDesc,String psTrnsGrndType,String psTrGrndDesc,String psToUnitId,String psToDrctId,String psToSectId,String psToGrpId,String psTransId,String psOptExercised,String psTransferDate){
    
        if (piTypeflag ==0){
            lEmpId=plEmpno;
            sename=psEname;
            sunitId=psFrmUnitid;
            sunit=psFrmUnitDesc;
            sdrctId=psFrmDrcrtid;
            sdob=psFrmDrctrDesc;
            sgrpId=psFrmGrpid;
            sgrpDesc=psFrmGrpDesc;
            sdoj=psSectid;
            sDojNpc=psFrmSectDesc;
            sgradeid=psGradeId;
            sgrade=psGradeDesc;
            sdisflg=psPostsFlg; //With Posts Flg
            sinitRmks=psPostsSurrFlg;//Posts Surrendered Flg
            scaddesc=psMapname;
            scategid=psCatId;
            scateg=psCatDesc;
            scoopflg=psSBType;
            scoopRmks=psSBTypeDesc;
            sperflg=psTrnsGrndType;
            sperfRmks=psTrGrndDesc;
            sunitToId=psToUnitId;
            sdrcrtTo=psToDrctId;
            sgrpTo=psToGrpId;
            ssectTo=psToSectId;
            sevntno=psTransId;
            srescateg=psOptExercised;
            sRet_Norm_Dt=psTransferDate;
        }
    }    







/** For  Maintain Quarter Master    * */  
 
    public EmpBean(String psEname,String psFrmUnitid,String psFrmUnitDesc,String psFrmDrcrtid,String psFrmDrctrDesc,String psFrmGrpid,String Id1,String Id2,String Id3)
      {
            sename=psEname;
            sunitId=psFrmUnitid;
            sunit=psFrmUnitDesc;
            sdrctId=psFrmDrcrtid;
            sdob=psFrmDrctrDesc;
            sgrpId=psFrmGrpid;
            scategid= Id1;
            sgradeid=Id2;    
            setypeid=Id3; 
        }
/** For  Electicity Charges    * */  
 
public EmpBean(String qrtFrom,String qrtTo,String qrtCrg)
       {
            
            this.scategid=qrtFrom; //from date
            this.scateg=qrtTo;//To date
            this.sgradeid=qrtCrg;// unitcharge
        
    }

/** For  Stationery Handing over screen    * */  
 
    public EmpBean(String fStryItemType,String fStryItemMake,long fStryQuantity ,String fStryReason ,String fStryCapitalNO ,String fStryDummy)
        {
            sename=fStryItemType;
            sdrctId=fStryItemMake;
            lEmpId=fStryQuantity;
            sunit=fStryReason;
            sdob=fStryCapitalNO;
            sgrpId=fStryDummy;
            
        }
    public EmpBean(String fStryItemType,String fStryItemMake,long fStryQuantity ,String fStryReason ,String fStryCapitalNO ,String fStryDummy, String poTxtEmpNo)
        {
            sename=fStryItemType;
            sdrctId=fStryItemMake;
            lEmpId=fStryQuantity;
            sunit=fStryReason;
            sdob=fStryCapitalNO;
            sgrpId=fStryDummy;
            this.txtEmpNo = poTxtEmpNo;
        }




        
   
     public long getlEmpId(){return lEmpId;}
    public void setlEmpId(long newlEmpId){lEmpId = newlEmpId;}

    public String getSGrade(){
        return sGrade;
}
    public void setSGrade(String newSGrade){
        sGrade = newSGrade;
}

    public String getSDojNpc(){return sDojNpc;}
    public void setSDojNpc(String newSDojNpc){sDojNpc = newSDojNpc;}

    public String getSRet_Norm_Dt(){return sRet_Norm_Dt;}
    public void setSRet_Norm_Dt(String newSRet_Norm_Dt){sRet_Norm_Dt = newSRet_Norm_Dt;}

    public String getSename(){return sename;}
    public void setSename(String newSename){sename = newSename;}

    public String getSdob(){return sdob;}
    public void setSdob(String newSdob){sdob = newSdob;}

    public String getScateg(){return scateg;}
    public void setScateg(String newScateg){scateg = newScateg;}

    public String getScategid(){return scategid;}
    public void setScategid(String newScategid){scategid = newScategid;}

    public String getSgrade(){return sgrade;}
    public void setSgrade(String newSgrade){sgrade = newSgrade;}

    public String getSgradeid(){return sgradeid;}
    public void setSgradeid(String newSgradeid){sgradeid = newSgradeid;}

    public String getSrescateg(){return srescateg;}
    public void setSrescateg(String newSrescateg){srescateg = newSrescateg;}

    public String getSetype(){return setype;}
    public void setSetype(String newSetype){setype = newSetype;}

    public String getSetypeid(){return setypeid;}
    public void setSetypeid(String newSetypeid){setypeid = newSetypeid;}

    public String getSprGrDt(){return sprGrDt;}
    public void setSprGrDt(String newSprGrDT){sprGrDt = newSprGrDT;}

    public String getSunit(){return sunit;}
    public void setSunit(String newSunit){sunit = newSunit;}

    public String getSunitId(){return sunitId;}
    public void setSunitId(String newSunitId){sunitId = newSunitId;}

    public String getSdoj(){return sdoj;}
    public void setSdoj(String newSdoj){sdoj = newSdoj;}

    public String getSpayScale(){return spayScale;}
    public void setSpayScale(String newSpayScale){spayScale = newSpayScale;}

    public String getSpromEffDt(){return spromEffDt;}
    public void setSpromEffDt(String newSpromEffDt){spromEffDt = newSpromEffDt;}

    public String getSdrctId(){return sdrctId;}
    public void setSdrctId(String newSdrctId){sdrctId = newSdrctId;}

    public String getSposts(){return sposts;}
    public void setSposts(String newSposts){sposts = newSposts;}

    public String getSprGrp(){return sprGrp;}
    public void setSprGrp(String newSprGrp){sprGrp = newSprGrp;}

    public String getSpromotedGrp(){return spromotedGrp;}
    public void setSpromotedGrp(String newSpromotedGrp){spromotedGrp = newSpromotedGrp;}

    public String getScaddesc(){return scaddesc;}
    public void setScaddesc(String newScaddesc){scaddesc = newScaddesc;}

    public String getSprCatid(){return sprCatid;}
    public void setSprCatid(String newSprCatid){sprCatid = newSprCatid;}

    public String getSprDsgnid(){return sprDsgnid;}
    public void setSprDsgnid(String newSprDsgnid){sprDsgnid = newSprDsgnid;}

    public String getSevntno(){return sevntno;}
    public void setSevntno(String newSevntno){sevntno = newSevntno;}

    public String getSrolesflg(){return srolesflg;}
    public void setSrolesflg(String newSrolesflg){srolesflg = newSrolesflg;}

    public String getSperflg(){return sperflg;}
    public void setSperflg(String newSperflg){sperflg = newSperflg;}

    public String getSinitflg(){return sinitflg;}
    public void setSinitflg(String newSinitflg){sinitflg = newSinitflg;}

    public String getSrelflg(){return srelflg;}
    public void setSrelflg(String newSrelflg){srelflg = newSrelflg;}

    public String getSsupflg(){return ssupflg;}
    public void setSsupflg(String newSsupflg){ssupflg = newSsupflg;}

    public String getSwilflg(){return swilflg;}
    public void setSwilflg(String newSwilflg){swilflg = newSwilflg;}

    public String getSdisflg(){return sdisflg;}
    public void setSdisflg(String newSdisflg){sdisflg = newSdisflg;}

    public String getSrolesRmks(){return srolesRmks;}
    public void setSrolesRmks(String newSrolesRmks){srolesRmks = newSrolesRmks;}

    public String getSperfRmks(){return sperfRmks;}
    public void setSperfRmks(String newSperfRmks){sperfRmks = newSperfRmks;}

    public String getSinitRmks(){return sinitRmks;}
    public void setSinitRmks(String newSinitRmks){sinitRmks = newSinitRmks;}

    public String getSrelRmks(){return srelRmks;}
    public void setSrelRmks(String newSrelRmks){srelRmks = newSrelRmks;}

    public String getSsupRmks(){return ssupRmks;}
    public void setSsupRmks(String newSsupRmks){ssupRmks = newSsupRmks;}

    public String getSwilRmks(){return swilRmks;}
    public void setSwilRmks(String newSwilRmks){swilRmks = newSwilRmks;}

    public String getSdiscRmks(){return sdiscRmks;}
    public void setSdiscRmks(String newSdiscRmks){sdiscRmks = newSdiscRmks;}

    public String getScoopflg(){return scoopflg;}
    public void setScoopflg(String newScoopflg){scoopflg = newScoopflg;}

    public String getScoopRmks(){return scoopRmks;}
    public void setScoopRmks(String newScoopRmks){scoopRmks = newScoopRmks;}

    public String getScaVerify(){return scaVerify;}
    public void setScaVerify(String newScaVerify){scaVerify = newScaVerify;}

    public String getSsqVerify(){return ssqVerify;}
    public void setSsqVerify(String newSsqVerify){ssqVerify = newSsqVerify;}

    public String getSfinalRmks(){return sfinalRmks;}
    public void setSfinalRmks(String newSfinalRmks){sfinalRmks = newSfinalRmks;}

    public String getSgrpId()
    {
        return sgrpId;
    }

    public void setSgrpId(String newSgrpId)
    {
        sgrpId = newSgrpId;
    }

    public String getSgrpDesc()
    {
        return sgrpDesc;
    }

    public void setSgrpDesc(String newSgrpDesc)
    {
        sgrpDesc = newSgrpDesc;
    }

    public String getSunitToId()
    {
        return sunitToId;
    }

    public void setSunitToId(String newSunitToId)
    {
        sunitToId = newSunitToId;
    }

    public String getSunitToDesc()
    {
        return sunitToDesc;
    }

    public void setSunitToDesc(String newSunitToDesc)
    {
        sunitToDesc = newSunitToDesc;
    }

    public String getSdrcrtTo()
    {
        return sdrcrtTo;
    }

    public void setSdrcrtTo(String newSdrcrtTo)
    {
        sdrcrtTo = newSdrcrtTo;
    }

    public String getSsectTo()
    {
        return ssectTo;
    }

    public void setSsectTo(String newSsectTo)
    {
        ssectTo = newSsectTo;
    }

    public String getSgrpTo()
    {
        return sgrpTo;
    }

    public void setSgrpTo(String newSgrpTo)
    {
        sgrpTo = newSgrpTo;
    }

    public String getFrmUnit()
    {
        return frmUnit;
    }

    public void setFrmUnit(String newFrmUnit)
    {
        frmUnit = newFrmUnit;
    }

    public String getTxtEmpNo()
    {
        return txtEmpNo;
    }

    public void setTxtEmpNo(String newTxtEmpNo)
    {
        txtEmpNo = newTxtEmpNo;
    }

    public String getSrepOffName()
    {
        return srepOffName;
    }

    public void setSrepOffName(String newSrepOffName)
    {
        srepOffName = newSrepOffName;
    }

    public String getSrepOffdsgn()
    {
        return srepOffdsgn;
    }

    public void setSrepOffdsgn(String newSrepOffdsgn)
    {
        srepOffdsgn = newSrepOffdsgn;
    }

    public String getSrepApprDt()
    {
        return srepApprDt;
    }

    public void setSrepApprDt(String newSrepApprDt)
    {
        srepApprDt = newSrepApprDt;
    }

    public String getSrepOffRmks()
    {
        return srepOffRmks;
    }

    public void setSrepOffRmks(String newSrepOffRmks)
    {
        srepOffRmks = newSrepOffRmks;
    }

    public String getSrevOffName()
    {
        return srevOffName;
    }

    public void setSrevOffName(String newSrevOffName)
    {
        srevOffName = newSrevOffName;
    }

    public String getSrevOffdsgn()
    {
        return srevOffdsgn;
    }

    public void setSrevOffdsgn(String newSrevOffdsgn)
    {
        srevOffdsgn = newSrevOffdsgn;
    }

    public String getSrevOffRemks()
    {
        return srevOffRemks;
    }

    public void setSrevOffRemks(String newSrevOffRemks)
    {
        srevOffRemks = newSrevOffRemks;
    }

    public String getSrevApprDt()
    {
        return srevApprDt;
    }

    public void setSrevApprDt(String newSrevApprDt)
    {
        srevApprDt = newSrevApprDt;
    }

    public String getSestOffName()
    {
        return sestOffName;
    }

    public void setSestOffName(String newSestOffName)
    {
        sestOffName = newSestOffName;
    }

    public String getSestOffDsgn()
    {
        return sestOffDsgn;
    }

    public void setSestOffDsgn(String newSestOffDsgn)
    {
        sestOffDsgn = newSestOffDsgn;
    }

    public String getSestOffRemks()
    {
        return sestOffRemks;
    }

    public void setSestOffRemks(String newSestOffRemks)
    {
        sestOffRemks = newSestOffRemks;
    }

    public String getSestApprDt()
    {
        return sestApprDt;
    }

    public void setSestApprDt(String newSestApprDt)
    {
        sestApprDt = newSestApprDt;
    }





    
}
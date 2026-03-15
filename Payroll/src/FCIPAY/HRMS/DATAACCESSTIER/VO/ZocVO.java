package FCIPAY.HRMS.DATAACCESSTIER.VO;
import java.util.ArrayList;
/*
 * Module:        ZocVO.java
 * Author:        Anand Balasubramanian
 * Date Written:  02/2004
* Description:  This class is used to hold the values from the screen and also to
* populate values to the screen.This object will be passed across different classes 
* predominantly
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/

public class ZocVO 
{
    String lstUnitname;
    String lstCriteria;
    String lstCategory;
    String lstCrucial;
    String lstFrmGrade;
    String lstToGrade;
    String txtMinyrsexp;
    String lstAddtnlQual;
    ArrayList gradefrmList=new ArrayList(1);
    ArrayList gradeToList=new ArrayList(1);
    String lstToCategory;
    String schkflg;
    String scrdt1;
    String scrdt2;
    String scurrentgr;
    String sfrmCrdt1;
    String sfrmCrdt2;
    String scriteria;
    String stype;
    ArrayList zocGenList=new ArrayList (1);
    long lempno;
    long llocCode;
    String sename;
    String sintExpert;
    String sextExpert;
    long luserid;
    String sacQlfn="";
    String stQlfn="";
    String spQlfn="";
    String sdoj="";
    String sdob="";
    String sincrdt="";
    String saqlfnacq="";
    String spqlfnacq="";
    String stqlfnacq="";
    String swrkRpt;
    String sexpName;
    String sexpDesg;
    String sexpTel;
    String sexpDiv;
    String sintExpname;
    String sintDesg;
    String sintDiv;
    String sintTel;
    String sdae;
    String sdiscStatus;
    String sdiscDet="";
    String szocDtlid;
    String slveCrdt;
    String slveCrdt2;
    String slveStatus;
    String sinExname;
    String sinExDesg;
    String sinExGrade;
    String sinExTel;
    String sextExname;
    String sextEDesg;
    String sextExpTel;
    String sextExpDiv;
    String strngReq;
    private String lstResCateg;
  private String[] lstConsolidate;
    private String txtUpdateUserStatus="";
    private ArrayList txtUpdateUserIDList=new ArrayList();
    private String txtQuarterStatus="";
    private String txtDate="";
    private String hdnPay_Present="";
    private ArrayList lstPay_Future=new ArrayList();

    public ArrayList getgradefrmList(){return this.gradefrmList;}

    public void setgradefrmList(ArrayList newgradefrmList){
        this.gradefrmList.clear();
        this.gradefrmList=(ArrayList ) newgradefrmList.clone();
    }
    public ArrayList getgradeToList(){return this.gradeToList;}
    public void setgradeToList(ArrayList newgradeToList){
        this.gradeToList.clear();
        this.gradeToList=(ArrayList ) newgradeToList.clone();
    }
    
    public String getLstUnitname(){return lstUnitname;}
    public void setLstUnitname(String newLstUnitname){lstUnitname = newLstUnitname;}

    public String getLstCriteria(){return lstCriteria;}
    public void setLstCriteria(String newLstCriteria){lstCriteria = newLstCriteria;}

    public String getLstCategory(){return lstCategory;}
    public void setLstCategory(String newLstCategory){lstCategory = newLstCategory;}

    public String getLstCrucial(){return lstCrucial;}
    public void setLstCrucial(String newLstCrucial){lstCrucial = newLstCrucial;}

    public String getLstFrmGrade(){return lstFrmGrade;}
    public void setLstFrmGrade(String newLstFrmGrade){lstFrmGrade = newLstFrmGrade;}

    public String getLstToGrade(){return lstToGrade;}
    public void setLstToGrade(String newLstToGrade){lstToGrade = newLstToGrade;}

    public String getTxtMinyrsexp(){return txtMinyrsexp;}
    public void setTxtMinyrsexp(String newTxtMinyrsexp){txtMinyrsexp = newTxtMinyrsexp;}

    public String getLstAddtnlQual(){return lstAddtnlQual;}
    public void setLstAddtnlQual(String newLstAddtnlQual){lstAddtnlQual = newLstAddtnlQual;}

    public String getLstToCategory(){return lstToCategory;}
    public void setLstToCategory(String newLstToCategory){lstToCategory = newLstToCategory;}

    public String getSchkflg(){return schkflg;}
    public void setSchkflg(String newSchkflg){schkflg = newSchkflg;}

    public String getScrdt1(){return scrdt1;}
    public void setScrdt1(String newScrdt1){scrdt1 = newScrdt1;}

    public String getScrdt2(){return scrdt2;}
    public void setScrdt2(String newScrdt2){scrdt2 = newScrdt2;}

    public String getScurrentgr(){return scurrentgr;}
    public void setScurrentgr(String newScurrentgr){scurrentgr = newScurrentgr;}

    public String getSfrmCrdt1(){return sfrmCrdt1;}
    public void setSfrmCrdt1(String newSfrmCrdt1){sfrmCrdt1 = newSfrmCrdt1;}

    public String getSfrmCrdt2(){return sfrmCrdt2;}
    public void setSfrmCrdt2(String newSfrmCrdt2){sfrmCrdt2 = newSfrmCrdt2;}

    public String getScriteria(){return scriteria;}
    public void setScriteria(String newScriteria){scriteria = newScriteria;}

    public String getStype(){return stype;}
    public void setStype(String newStype){stype = newStype;}

    public ArrayList getZocGenList(){return zocGenList;}

    public void setZocGenList(ArrayList newZocGenList){
        this.zocGenList.clear();
        zocGenList =(ArrayList ) newZocGenList.clone();
    }

    public long getLempno(){return lempno;}
    public void setLempno(long newLempno){lempno = newLempno;}

    public long getLlocCode(){return llocCode;}
    public void setLlocCode(long newLlocCode){llocCode = newLlocCode;}

    public String getSename(){return sename;}
    public void setSename(String newSename){sename = newSename;}

    public String getSintExpert(){return sintExpert;}
    public void setSintExpert(String newSintExpert){sintExpert = newSintExpert;}

    public String getSextExpert(){return sextExpert;}
    public void setSextExpert(String newSextExpert){sextExpert = newSextExpert;}

    public long getLuserid(){return luserid;}
    public void setLuserid(long newLuserid){luserid = newLuserid;}

    public String getSacQlfn()
    {
        return sacQlfn;
    }

    public void setSacQlfn(String newSacQlfn)
    {
        sacQlfn = newSacQlfn;
    }

    public String getStQlfn()
    {
        return stQlfn;
    }

    public void setStQlfn(String newStQlfn)
    {
        stQlfn = newStQlfn;
    }

    public String getSpQlfn()
    {
        return spQlfn;
    }

    public void setSpQlfn(String newSpQlfn)
    {
        spQlfn = newSpQlfn;
    }

    public String getSdoj()
    {
        return sdoj;
    }

    public void setSdoj(String newSdoj)
    {
        sdoj = newSdoj;
    }

    public String getSdob()
    {
        return sdob;
    }

    public void setSdob(String newSdob)
    {
        sdob = newSdob;
    }

    public String getSincrdt()
    {
        return sincrdt;
    }

    public void setSincrdt(String newSincrdt)
    {
        sincrdt = newSincrdt;
    }

    public String getSaqlfnacq()
    {
        return saqlfnacq;
    }

    public void setSaqlfnacq(String newSaqlfnacq)
    {
        saqlfnacq = newSaqlfnacq;
    }

    public String getSpqlfnacq()
    {
        return spqlfnacq;
    }

    public void setSpqlfnacq(String newSpqlfnacq)
    {
        spqlfnacq = newSpqlfnacq;
    }

    public String getStqlfnacq()
    {
        return stqlfnacq;
    }

    public void setStqlfnacq(String newStqlfnacq)
    {
        stqlfnacq = newStqlfnacq;
    }

    public String getSwrkRpt()
    {
        return swrkRpt;
    }

    public void setSwrkRpt(String newSwrkRpt)
    {
        swrkRpt = newSwrkRpt;
    }

    public String getSexpName()
    {
        return sexpName;
    }

    public void setSexpName(String newSexpName)
    {
        sexpName = newSexpName;
    }

    public String getSexpDesg()
    {
        return sexpDesg;
    }

    public void setSexpDesg(String newSexpDesg)
    {
        sexpDesg = newSexpDesg;
    }

    public String getSexpTel()
    {
        return sexpTel;
    }

    public void setSexpTel(String newSexpTel)
    {
        sexpTel = newSexpTel;
    }

    public String getSexpDiv()
    {
        return sexpDiv;
    }

    public void setSexpDiv(String newSexpDiv)
    {
        sexpDiv = newSexpDiv;
    }

    public String getSintExpname()
    {
        return sintExpname;
    }

    public void setSintExpname(String newSintExpname)
    {
        sintExpname = newSintExpname;
    }

    public String getSintDesg()
    {
        return sintDesg;
    }

    public void setSintDesg(String newSintDesg)
    {
        sintDesg = newSintDesg;
    }

    public String getSintDiv()
    {
        return sintDiv;
    }

    public void setSintDiv(String newSintDiv)
    {
        sintDiv = newSintDiv;
    }

    public String getSintTel()
    {
        return sintTel;
    }

    public void setSintTel(String newSintTel)
    {
        sintTel = newSintTel;
    }

    public String getSdae()
    {
        return sdae;
    }

    public void setSdae(String newSdae)
    {
        sdae = newSdae;
    }

    public String getSdiscStatus()
    {
        return sdiscStatus;
    }

    public void setSdiscStatus(String newSdiscStatus)
    {
        sdiscStatus = newSdiscStatus;
    }

    public String getSdiscDet()
    {
        return sdiscDet;
    }

    public void setSdiscDet(String newSdiscDet)
    {
        sdiscDet = newSdiscDet;
    }

    public String getSzocDtlid()
    {
        return szocDtlid;
    }

    public void setSzocDtlid(String newSzocDtlid)
    {
        szocDtlid = newSzocDtlid;
    }

    public String getSlveCrdt()
    {
        return slveCrdt;
    }

    public void setSlveCrdt(String newSlveCrdt)
    {
        slveCrdt = newSlveCrdt;
    }

    public String getSlveCrdt2()
    {
        return slveCrdt2;
    }

    public void setSlveCrdt2(String newSlveCrdt2)
    {
        slveCrdt2 = newSlveCrdt2;
    }

    public String getSlveStatus()
    {
        return slveStatus;
    }

    public void setSlveStatus(String newSlveStatus)
    {
        slveStatus = newSlveStatus;
    }

    public String getSinExname()
    {
        return sinExname;
    }

    public void setSinExname(String newSinExname)
    {
        sinExname = newSinExname;
    }

    public String getSinExDesg()
    {
        return sinExDesg;
    }

    public void setSinExDesg(String newSinExDesg)
    {
        sinExDesg = newSinExDesg;
    }

    public String getSinExGrade()
    {
        return sinExGrade;
    }

    public void setSinExGrade(String newSinExGrade)
    {
        sinExGrade = newSinExGrade;
    }

    public String getSinExTel()
    {
        return sinExTel;
    }

    public void setSinExTel(String newSinExTel)
    {
        sinExTel = newSinExTel;
    }

    public String getSextExname()
    {
        return sextExname;
    }

    public void setSextExname(String newSextExname)
    {
        sextExname = newSextExname;
    }

    public String getSextEDesg()
    {
        return sextEDesg;
    }

    public void setSextEDesg(String newSextEDesg)
    {
        sextEDesg = newSextEDesg;
    }

    public String getSextExpTel()
    {
        return sextExpTel;
    }

    public void setSextExpTel(String newSextExpTel)
    {
        sextExpTel = newSextExpTel;
    }

    public String getSextExpDiv()
    {
        return sextExpDiv;
    }

    public void setSextExpDiv(String newSextExpDiv)
    {
        sextExpDiv = newSextExpDiv;
    }

    public String getStrngReq()
    {
        return strngReq;
    }

    public void setStrngReq(String newStrngReq)
    {
        strngReq = newStrngReq;
    }

    public String getLstResCateg() {
        return lstResCateg;
    }

    public void setLstResCateg(String newLstResCateg) {
        lstResCateg = newLstResCateg;
    }

  public String[] getLstConsolidate()
  {
    return lstConsolidate;
  }

  public void setLstConsolidate(String[] newLstConsolidate)
  {
    lstConsolidate = newLstConsolidate;
  }

    public String getTxtUpdateUserStatus()
    {
        return txtUpdateUserStatus;
    }

    public void setTxtUpdateUserStatus(String newTxtUpdateUserStatus)
    {
        txtUpdateUserStatus = newTxtUpdateUserStatus;
    }

    public ArrayList getTxtUpdateUserIDList()
    {
        return txtUpdateUserIDList;
    }

   
    public void setTxtUpdateUserIDList(ArrayList newTxtUpdateUserIDList)
    {
        txtUpdateUserIDList = newTxtUpdateUserIDList;
    }

    public String getTxtQuarterStatus()
    {
        return txtQuarterStatus;
    }

    public void setTxtQuarterStatus(String newTxtQuarterStatus)
    {
        txtQuarterStatus = newTxtQuarterStatus;
    }

    public String getTxtDate()
    {
        return txtDate;
    }

    public void setTxtDate(String newTxtDate)
    {
        txtDate = newTxtDate;
    }

    public String getHdnPay_Present()
    {
        return hdnPay_Present;
    }

    public void setHdnPay_Present(String newHdnPay_Present)
    {
        hdnPay_Present = newHdnPay_Present;
    }



    public ArrayList getLstPay_Future()
    {
        return lstPay_Future;
    }

    public void setLstPay_Future(ArrayList newLstPay_Future)
    {
        lstPay_Future = newLstPay_Future;
    }







}
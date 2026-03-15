package FCIPAY.HRMS.UTILITY;
import java.util.ArrayList;
import java.lang.StringBuffer;
import java.lang.Integer;
/*
 * Module:        QualfnList.java
 * Author:        Anand Balasubramanian
 * Date Written:  03/09/2003
* Description:  Bean class that is used to construct values that are needed in dropdowns
* Revision Log  (mm/dd/yy initials description)
* --------------------------------------------------------
* mm/dd/yy xxx  What you changed
*/


public class QualfnList
{
    private String QCode;
    private long QId=0;
    private long Qlevel=0;
    private String QType=null;
    private long DId=0;
    private String DDesc=null;
    static ArrayList qlList=new ArrayList();
    static String sValuelist=new String();
    static ArrayList dlList=new ArrayList();
    String syrPassing;
    String sclass;
    private String spurpose;
    private ArrayList lstSrcDtl=new ArrayList(1);
    private ArrayList lstDtl=new ArrayList(1);
    private String srowLst;
    private String muthuRowList="";
    private String sqId;
    private String sid;
    private String sCode;
    public QualfnList(){}
    /**
    * constructor to initiailize qualification details dropdown.
    * @plQualfnid Qualification id.
    * @plQualfncode Qualification code.
    * @psQualfnType Qualification Type.
    *  @plQlevel Qualification Level.
    */
    public QualfnList(long plQualfnid,String plQualfnCode,String psQualfnType,long plQlevel)
    {
        this.QCode=plQualfnCode;
        this.QId=plQualfnid;
        this.Qlevel=plQlevel;
        this.QType=psQualfnType;
        this.sqId=Long.toString(plQlevel);
        this.DId=plQlevel;
    }
    public QualfnList(long plQualfnid,String plQualfnCode,String psQualfnType,long plQlevel,String pId)
    {
        this.QCode=plQualfnCode;
        this.QId=plQualfnid;
        this.Qlevel=plQlevel;
        this.QType=psQualfnType;
        this.sqId=Long.toString(plQlevel);
        this.DId=plQlevel;
        this.sid=pId;
    }
    /**
    * constructor to initiailize qualification details dropdown.
    * @plQualfnid Qualification id.
    * @psQualfncode Qualification code.
    */  
    public QualfnList(long plQualfnid,String psQualfnCode)
    {
        this.QCode=psQualfnCode;
        this.QId=plQualfnid;
        qlList.add(this);
//        System.out.println(qlList.size() +"Size of Arraylist " +this.QCode);    
    }
    public QualfnList(String sId,String psQualfnCode)
    {
        this.QCode=psQualfnCode;
        this.sid=sId;
//        qlList.add(this);
//        System.out.println(qlList.size() +"Size of Arraylist " +this.QCode);    
    }
    /**
    * constructor to initiailize Discipline details dropdown.
    * @piTypeflag flag to determine type of population
    * @plDsplnid Discipline id.
    * @psDsplnDesc Discipline Desc.
    * @plDsplQId Discipline Qualification Id.
    */
    
    public QualfnList(int piTypeflag,long plDsplnid,String psDsplnDesc,long plDsplQId){
        if (piTypeflag ==0){ //Populate discipline based on value selected
            this.DId=plDsplnid;
            this.DDesc=psDsplnDesc;
            this.QId=plDsplQId;
            dlList.add(this);
            System.out.println(dlList.size() +"Size of Discipline Arraylist ");
        }   
    }

    //Populating education details for the employee
    public QualfnList(int piTypeflag,long plqid,String psQDesc,String psQType,long plDsplnid,String psDsplnDesc,String psyrPass,String psDivision){
        if (piTypeflag==0){
            this.QId=plqid;
            this.QCode=psQDesc;
            this.QType=psQType;
            this.DId=plDsplnid;
            this.DDesc=psDsplnDesc;
            this.syrPassing=psyrPass;
            this.sclass=psDivision;
        }
    }

    /**
    * constructor to initiailize Property Acquistion details dropdown.
    * @piTypeflag flag to determine type of population
    * @psSrcDesc Source Description
    * @plstDtls list of Advance details
    * @psRowSrc Row id 
    */
    
    public QualfnList(int piTypeflag,String psSrcDesc,ArrayList plstDtls,String psRowSrc){
        if (piTypeflag ==0){ //Populate Acquistion Details
            this.spurpose=psSrcDesc;
            this.lstDtl=plstDtls;
            System.out.println(this.lstDtl.size());
            this.srowLst=psRowSrc;
        }   
    }    
    public void setQId(long plQualfnId){this.QId=plQualfnId;}
    public long getQId(){return this.QId;}

    //public void setqlList(long plQualfnId){this.qlList=plQualfnId;}
    public ArrayList getqlList(){return this.qlList;}
  
    public void setQCode(String newQCode){
        QCode = newQCode;
}
    public String getQCode(){
        return QCode;
}

    public void setQlevel(long plQlevel){this.Qlevel=plQlevel;}
    public long getQlevel(){return this.Qlevel;}
  
    public void setQType(String psQType){this.QType=psQType;}
    public String getQType(){return this.QType;}
  
    public void setDId(long plDsplnId){this.DId=plDsplnId;}
    public long getDId(){return this.DId;}

    public void setDDesc(String psDDesc){this.DDesc=psDDesc;}
    public String getDDesc(){return this.DDesc;}

    public String getSyrPassing(){return syrPassing;}
    public void setSyrPassing(String newSyrPassing){syrPassing = newSyrPassing;}

    public String getSclass(){return sclass;}
    public void setSclass(String newSclass){sclass = newSclass;}

    /**
    * Method to construct comma separated qualification list.
    * @String qualification list
    */

    public String getQulfnlist(){
        StringBuffer sbValuelist=new StringBuffer();
        QualfnList oTemp=null;
        for (int i=0;i<qlList.size() ;i++){
            oTemp=(QualfnList) qlList.get(i);
            sbValuelist.append(oTemp.QCode + "|"+oTemp.QId +"," );
        }
        return sbValuelist.toString() ;
    }

    /**
    * Method to construct comma separated Discipline list.
    * @String Discipline list
    */
    
    public String getDslnlist(){
        StringBuffer sbValuelist=new StringBuffer();
        QualfnList oTemp=null;
        for (int i=0;i<dlList.size() ;i++){
          oTemp=(QualfnList) dlList.get(i);
          sbValuelist.append(oTemp.QId + "|"+oTemp.DId +"|" +oTemp.DDesc +",");
        }
        return sbValuelist.toString() ;
    }

    public String getSpurpose()
    {
        return spurpose;
    }

    public void setSpurpose(String newSpurpose)
    {
        spurpose = newSpurpose;
    }

    public ArrayList getLstSrcDtl()
    {
        return lstSrcDtl;
    }

    public void setLstSrcDtl(ArrayList newLstSrcDtl)
    {
        lstSrcDtl = newLstSrcDtl;
    }

    public String getSrowLst()
    {
        return srowLst;
    }

    public void setSrowLst(String newSrowLst)
    {
        srowLst = newSrowLst;
    }

    public String getMuthuRowList()
    {
        return muthuRowList;
    }

    public ArrayList getLstDtl()
    {
        return lstDtl;
    }

    public String getSqId()
    {
        return sqId;
    }

    public void setSqId(String newSqId)
    {
        sqId = newSqId;
    }

    public String getSid()
    {
        return sid;
    }

    public void setSid(String newSid)
    {
        sid = newSid;
    }

    public String getSCode()
    {
        return sCode;
    }

    public void setSCode(String newSCode)
    {
        sCode = newSCode;
    }


    
}

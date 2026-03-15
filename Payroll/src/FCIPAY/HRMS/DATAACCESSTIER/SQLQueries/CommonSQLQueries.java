package FCIPAY.HRMS.DATAACCESSTIER.SQLQueries;

public class CommonSQLQueries 
{
    public static final String PAYSCALE_DETAILS="SELECT PSCALE_CODE,nvl(PSCALE_INITPAY,0) as PSCALE_INITPAY ," +
    "nvl(PSCALE_INCR1,0) as PSCALE_INCR1,nvl(PSCALE_TOPAY1,0) as PSCALE_TOPAY1," +
    "nvl(PSCALE_INCR2,0) as PSCALE_INCR2,nvl(PSCALE_TOPAY2,0) as PSCALE_TOPAY2,"+
    "nvl(PSCALE_INCR3,0) as PSCALE_INCR3,nvl(PSCALE_TOPAY3,0) as PSCALE_TOPAY3,"+
    "nvl(PSCALE_INCR4,0) as PSCALE_INCR4,nvl(PSCALE_TOPAY4,0) as PSCALE_TOPAY4,"+
    "nvl(PSCALE_INCR5,0) as PSCALE_INCR5,nvl(PSCALE_TOPAY5,0) as PSCALE_TOPAY5 "+
    " FROM HRM_PAYSCALE_MAST WHERE PSCALE_CODE  in " +
    "(SELECT PSCAL_CD FROM HRM_GRADE_MAST WHERE GRADE_ID=?)"; 

    public static final String IS_WEEK_OFF = "SELECT WEEKLY_OFF_1,WEEKLY_OFF_2 "+
    "FROM HRM_HOLIDAY_MAST WHERE LOC_CODE=? "+
    "AND TO_DATE(TO_CHAR(CALENDAR_YEAR,'YYYY'),'YYYY')=TO_DATE(?,'YYYY')";

    public static final String IS_HOLIDAY="SELECT COUNT(*) HOLIDAY_CNT " +
    "FROM HRM_HOLIDAY_MAST A,HRM_HOLIDAY_DTL B " +
    "WHERE A.HOLIDAY_ID=B.HOLIDAY_MAST_ID AND " +
    "A.LOC_CODE=? AND HOLIDAY_DATE=TO_DATE(?,'DD/MM/YYYY') AND B.HOLIDAY_STATUS_FLG='A'";      

    public static final String GET_DAY="SELECT TO_CHAR(TO_DATE(?,'DD/MM/YYYY'),'DAY') WEEKDAY FROM DUAL";           

    public static final String GET_NEXT_DATE="SELECT TO_CHAR(TO_DATE(?,'DD/MM/YYYY')+1,'DD/MM/YYYY') NEXT_DATE FROM DUAL";

    public static final String EMPLOYEE_DETAILS="SELECT NVL(G.GRADE_ID,0) AS GRADE_ID ,NVL(G.GRADE_DESC,'U') AS GRADE_DESC,E.EMP_FST_NAME  ||' ' || E.EMP_MDL_NAME || ' ' || E.EMP_LST_NAME  AS  ENAME , TO_CHAR(E.EMP_CR_PRD_END_DT,'DD/MM/YYYY') AS DOA FROM  " +
    " HRM_EMPLOYEE E ,HRM_GRADE_MAST  G WHERE E.EMP_NO=? AND E.EMP_GRADE_ID=G.GRADE_ID ";

    public static final String SECTION_DETAILS="SELECT NVL(SECT_ID,0) AS SECT_ID ,"+
    "NVL(SECT_NAME,'U') AS SECT_NAME FROM HRM_SECT_MAST	ORDER BY SECT_NAME" ;

/*    public static final String GET_HIGHEST_QUALFN_FOR_EMPLOYEE=" SELECT Q2.QLFN_CODE AS QCODE,Q2.QLFN_ID AS QID,Q2.QLFN_TYPE AS QTYPE, " +
    " Q2.QLFN_LEVEL AS QLEVEL FROM HRM_QLFN_MAST Q2 WHERE Q2.QLFN_LEVEL IN( " +
    " SELECT MAX(QM.QLFN_LEVEL) FROM HRM_QLFN_MAST QM WHERE EXISTS( " +
    " SELECT E.QLFN_CODE FROM HRM_EMP_QLFN E,HRM_QLFN_MAST Q " +
    " WHERE E.EMP_NO=? AND E.QLFN_CODE=Q.QLFN_ID AND QM.QLFN_ID=E.QLFN_CODE AND Q2.QLFN_TYPE=Q.QLFN_TYPE AND UPPER(NVL(E.QLFN_STATUS,'N'))!=UPPER('D')  " + 
    " GROUP BY  Q.QLFN_TYPE ) " +
    " GROUP BY QM.QLFN_TYPE) AND EXISTS (SELECT E.QLFN_CODE FROM HRM_EMP_QLFN E,HRM_QLFN_MAST Q " +
    " WHERE E.EMP_NO=? AND E.QLFN_CODE=Q.QLFN_ID AND Q2.QLFN_ID=E.QLFN_CODE  " +
    " GROUP BY  Q.QLFN_TYPE,E.QLFN_CODE ,Q.QLFN_CODE)  " ;    */

    public static final String GET_HIGHEST_QUALFN_FOR_EMPLOYEE=" SELECT DISTINCT Q2.QLFN_CODE || ' ' || D.DSPL_DESC     AS QCODE,  "+
"               Q2.QLFN_ID    AS QID,  "+
"               Q2.QLFN_TYPE  AS QTYPE,  "+
"               Q2.QLFN_LEVEL AS QLEVEL  "+
"         FROM HRM_QLFN_MAST Q2 , HRM_DSPL_MAST D , HRM_EMP_QLFN EQ  "+
"         WHERE Q2.QLFN_LEVEL =  "+
"               (SELECT MAX(QM.QLFN_LEVEL)  "+
"                  FROM HRM_QLFN_MAST QM  "+
"                 WHERE EXISTS (SELECT E.QLFN_CODE  "+
"                          FROM HRM_EMP_QLFN E, HRM_QLFN_MAST Q  "+
"                         WHERE E.EMP_NO = ? AND E.QLFN_CODE = Q.QLFN_ID AND  "+
"                               QM.QLFN_ID = E.QLFN_CODE AND  "+
"                               Q2.QLFN_TYPE = Q.QLFN_TYPE AND  "+
"                               UPPER(NVL(E.QLFN_STATUS, 'N')) != UPPER('D')  "+
"                         GROUP BY Q.QLFN_TYPE)  "+
"                 GROUP BY QM.QLFN_TYPE) AND EXISTS  "+
"         (SELECT E.QLFN_CODE  "+
"                  FROM HRM_EMP_QLFN E, HRM_QLFN_MAST Q  "+
"                 WHERE E.EMP_NO = ? AND E.QLFN_CODE = Q.QLFN_ID AND  "+
"                       Q2.QLFN_ID = E.QLFN_CODE  "+
"                 GROUP BY Q.QLFN_TYPE, E.QLFN_CODE, Q.QLFN_CODE)  "+
"                 AND D.DSPL_ID(+) = EQ.QLFN_DISC AND EQ.QLFN_CODE(+)=Q2.QLFN_ID AND EQ.EMP_NO = ?  ";


    public static final String GET_GBLDTLS_FOR_CODE=" SELECT DT.GBL_CODE AS GCODE,DT.CODE_DESC AS GDESC,DT.GBL_TYPE AS GTYPE "  +
    " FROM COM_GBL_DTL DT WHERE DT.GBL_TYPE LIKE ? " ;   

    public static final String GET_ALL_GRADE_DETAILS="SELECT NVL(CATEG_ID,0) AS CID,NVL(GRADE_ID,0) AS GID,NVL(GRADE_DESC,'U') AS GDESC, " +
    " NVL(PSCAL_CD,'U') AS PSCALE FROM HRM_GRADE_MAST GROUP BY  CATEG_ID,GRADE_ID,GRADE_DESC,PSCAL_CD  ORDER BY GRADE_DESC, CATEG_ID,GRADE_ID,PSCAL_CD " ; 

    public static final String GET_ALL_GRADES_FOR_GRADE_PAYSCALE=" SELECT NVL(G.CATEG_ID,0) AS CID,NVL(G.GRADE_ID,0) AS GID,NVL(G.GRADE_DESC,'U') AS GDESC, " +
    " NVL(G.PSCAL_CD,'U') AS PSCALE FROM HRM_GRADE_MAST G1,HRM_GRADE_MAST G " +
    " WHERE G1.GRADE_ID=?  AND G.PSCAL_CD=G1.PSCAL_CD " +
    " GROUP BY  G.CATEG_ID,G.GRADE_ID,G.GRADE_DESC,G.PSCAL_CD  ORDER BY " +
    " G.GRADE_DESC,G.CATEG_ID,G.GRADE_ID,G.PSCAL_CD  ";
    
    public static final String GET_GRADE_FOR_CATEGORY="SELECT NVL(CATEG_ID,0) AS CID,NVL(GRADE_ID,0) AS GID,NVL(GRADE_DESC,'U') AS GDESC, " +
   " NVL(PSCAL_CD,'U') AS PSCALE FROM HRM_GRADE_MAST WHERE CATEG_ID=?  GROUP BY  CATEG_ID,GRADE_ID,GRADE_DESC,PSCAL_CD  ORDER BY GRADE_DESC,CATEG_ID,GRADE_ID,PSCAL_CD " ;

    public static final String GET_CRDATES_FOR_GRADE=" SELECT GM.GRADE_ID GID,NVL(GM.GRADE_DESC,'') AS GDESC,NVL(GM.PROM_CRUC_DT1, '') AS CRDT1 ,NVL(GM.PROM_CRUC_DT2, ' ') AS CRDT2 FROM HRM_GRADE_MAST GM, " +
    " HRM_EMPLOYEE E WHERE E.EMP_NO=? AND GM.GRADE_ID=E.EMP_GRADE_ID ";

    public static final String GET_ALL_UNIT_DETAILS="SELECT T.LOC_ID AS UNID,NVL(T.LOC_SDESC,' ') AS UDESC,NVL(T.LOC_TYPE_GBL, ' ') AS UTYPE FROM COM_LOC_MST T ORDER BY T.LOC_SDESC " ;

    public static final String GET_NONTECHNICAL_GRADE_DETAILS=" SELECT NVL(G.CATEG_ID,0) AS CID,NVL(G.GRADE_ID,0) AS GID,NVL(G.GRADE_DESC,'U') AS GDESC,  " +
    " NVL(G.PSCAL_CD,'U') AS PSCALE FROM HRM_GRADE_MAST G, HRM_CATEG_MAST C1 WHERE  " +
    " C1.CATEG_ID=G.CATEG_ID AND UPPER(C1.CATEG_DESC)!=UPPER('Scientific') AND UPPER(C1.CATEG_DESC)!=UPPER('Technical')   " +
    " GROUP BY  G.CATEG_ID,G.GRADE_ID,G.GRADE_DESC,G.PSCAL_CD  ORDER BY G.GRADE_DESC,G.CATEG_ID,G.GRADE_ID,G.PSCAL_CD   " ;

    public static final String GET_EMPLOYEE_DETAILS=" SELECT E.EMP_NO AS EMPNO, TRIM(E.EMP_FST_NAME)  ||' ' || TRIM(E.EMP_MDL_NAME) || ' ' || TRIM(E.EMP_LST_NAME)  AS ENAME,   " +
    " NVL(TO_CHAR(E.EMP_DOB,'DD/MM/YYYY'), ' ') AS DOB,E.EMP_UNIT_ID AS UNID,L.LOC_SDESC AS UDESC,    " +
    " NVL(NVL(TO_CHAR(E.EMP_DOJ_NPC,'DD/MM/YYYY'),TO_CHAR(E.EMP_DOJ_DAE,'DD/MM/YYYY')), ' ') AS DOJ,   " +
    " NVL(TO_CHAR(E.EMP_DOA_PRES_GRADE,'DD/MM/YYYY'),' ') AS PRGRDT,NVL(G.GRADE_DESC,' ') AS GDESC,NVL(E.EMP_GRADE_ID,0) AS GID, " +  
    " NVL(E.EMP_RES_CATEG,' ') AS RESCATE,NVL(GDT.CODE_DESC,' ') AS RESDESC,E.EMP_TYPE_ID AS ETYPE,NVL(E.EMP_GRP_ID,0) AS ETDESC,NVL(E.EMP_CATEG_ID,0) AS CID,NVL(CM.CATEG_DESC,' ') AS CDESC,NVL(E.EMP_DRCRT_ID,0) AS DRID,NVL(G.EMP_GROUP,'') AS FRMGRP " +
    " FROM HRM_EMPLOYEE E,COM_GBL_DTL GDT,COM_LOC_MST L,HRM_EMP_TYPE_MAST ET,HRM_GRADE_MAST G,HRM_CATEG_MAST CM " +
    " WHERE E.EMP_NO=? AND E.EMP_TEMP_STATUS IN ('HEMPSTATUS$PERM','HEMPSTATUS$PROMPROB','HEMPSTATUS$PROB')  AND   L.LOC_ID(+)=E.EMP_UNIT_ID AND GDT.GBL_CODE(+)=E.EMP_RES_CATEG AND G.GRADE_ID(+)=E.EMP_GRADE_ID AND ET.EMP_TYPE_ID(+)=E.EMP_TYPE_ID AND CM.CATEG_ID(+)=E.EMP_CATEG_ID  AND UPPER(CM.CATEG_DESC)!=UPPER('Scientific') AND UPPER(CM.CATEG_DESC)!=UPPER('Technical') ";

    public static final String GET_OTHER_GRADE_DETAILS=" SELECT NVL(G.CATEG_ID,0) AS CID,NVL(G.GRADE_ID,0) AS GID,NVL(G.GRADE_DESC,'U') AS GDESC, " +
    " NVL(G.PSCAL_CD,'U') AS PSCALE,NVL(G.EMP_GROUP, ' ') AS TOGRP,NVL(C1.CATEG_DESC,'') AS CDESC, " +
    " NVL(DS.DSGN_ID,0) AS DSGNID,NVL(DS.DSGN_DESC,' ') AS DSGNDESC " +
    " FROM HRM_GRADE_MAST G,HRM_CATEG_MAST C1,HRM_DSGN_MAST DS " +
    " WHERE  G.GRADE_ID=? AND C1.CATEG_ID=G.CATEG_ID AND UPPER(C1.CATEG_DESC)!=UPPER('SCIENTIFIC') AND UPPER(C1.CATEG_DESC)!=UPPER('TECHNICAL') " +
    " AND G.GRADE_ID=DS.DSGN_GRADE_ID(+)   " ; 

    public static final String GET_DESIGNATION_DETAILS_FOR_EMPLOYEE=" SELECT NVL(E.EMP_DSGN_ID,'') AS DSGNID,NVL(D.DSGN_DESC, '') AS DSGNDESC FROM HRM_EMPLOYEE E,HRM_DSGN_MAST D " +
    " WHERE E.EMP_DSGN_ID(+)=D.DSGN_ID AND E.EMP_NO=? " ;

    public static final String GET_GENERAL_EMPLOYEE_DETAILS=" SELECT NVL(T.EMP_FST_NAME || ' ' || T.EMP_MDL_NAME || ' ' || T.EMP_LST_NAME,'') AS ENAME,NVL(TO_CHAR(T.EMP_DOB,'DD/MM/YYYY') ,'')AS DOB, " +
    " NVL(T.EMP_UNIT_ID,'') AS UNID,NVL(M.LOC_SDESC,'') AS UDESC, " +
    " NVL(TO_CHAR(T.EMP_DOJ_DAE,'DD/MM/YYYY'),TO_CHAR(T.EMP_DOJ_NPC,'DD/MM/YYYY')) AS DOJ, " +
    " NVL(T.EMP_OPT_EXERCISED,'') AS OPTEX, " +
    " NVL(T.EMP_GRADE_ID,'') AS GID,NVL(G.GRADE_DESC,'') AS GDESC, " +
    " NVL(T.EMP_GRP,'') AS GRP, " +
    " NVL(T.EMP_SECT_ID,'')AS SECTID,NVL(S.SECT_NAME,'') AS SNAME, " +
    " NVL(T.EMP_DRCRT_ID,'') AS DRID,NVL(G.DRCRT_NAME,'') AS DRDESC, " +
    " NVL(T.EMP_CATEG_ID,'') AS CID,NVL(C.CATEG_DESC,'') AS CDESC,NVL(T.EMP_GRP_ID,'') AS GRPID " +
    " FROM HRM_EMPLOYEE T,COM_LOC_MST M,HRM_SECT_MAST S,HRM_DSGN_MAST D,HRM_GRADE_MAST G,HRM_CATEG_MAST C,HRM_DRCRT_MAST G " +
    " WHERE M.LOC_ID=T.EMP_UNIT_ID AND S.SECT_ID=T.EMP_SECT_ID(+) AND " +
    " T.EMP_DSGN_ID=D.DSGN_ID(+) AND T.EMP_GRADE_ID=G.GRADE_ID(+) AND " +
    " T.EMP_CATEG_ID=C.CATEG_ID(+) AND T.EMP_DRCRT_ID=G.DRCRT_ID(+) AND T.EMP_TEMP_STATUS IN ('HEMPSTATUS$PERM','HEMPSTATUS$PROMPROB','HEMPSTATUS$PROB') AND T.EMP_NO=? AND T.EMP_UNIT_ID=?  ";

    public static final String GET_DIRECTORATES_FOR_UNIT="SELECT DRCRT_ID,DRCRT_NAME,DRCRT_HEAD FROM HRM_DRCRT_MAST WHERE UNIT_ID=?";
    public static final String GET_GRPS_FOR_DIRECTORATES="SELECT NVL(T.GRP_ID,'') AS GRP_ID,NVL(T.GRP_NAME,'') AS GRP_NAME,NVL(T.GRP_HEAD,'') AS GRP_HEAD FROM HRM_GRP_MAST T WHERE T.GRP_DRCRT_ID=?" ;


    public static final String GET_ALL_GRP_DETAILS="SELECT NVL(GRP_ID,'') AS GRPID,NVL(GRP_NAME,'') AS GRPNAME FROM HRM_GRP_MAST ORDER BY GRPNAME ";
    public static final String GET_ALL_DRCRT_DETAILS="SELECT NVL(DRCRT_ID,'') AS DRID,NVL(DRCRT_NAME, '') AS DRNAME FROM HRM_DRCRT_MAST ORDER BY  DRNAME";
    public static final String GET_ALL_SECTION_DETAILS="SELECT NVL(SECT_ID,'') AS SECID,NVL(SECT_NAME, '') AS SNAME FROM HRM_SECT_MAST ORDER BY SNAME " ;


    public static final String GET_ACCT_DTL = "SELECT ACCT_STATUS,CTRL_ACCT,CHG_FLG,CC_FLG FROM FIN_ACCT_MST WHERE ACCT_ID = ? AND (CTRL_TYPE_FLG IN ('O', 'E') OR CTRL_TYPE_FLG IS NULL) ";

    public static final String SELECT_CATEGORY_TECHNICAL="select CATEG_ID,CATEG_DESC from HRM_CATEG_MAST WHERE UPPER(CATEG_DESC)=UPPER('Scientific') or UPPER(CATEG_DESC)=UPPER('Technical') ORDER BY CATEG_DESC ";    
    public static final String SELECT_CATEGORY_NONTECHNICAL="select CATEG_ID,CATEG_DESC from HRM_CATEG_MAST WHERE UPPER(CATEG_DESC)!=UPPER('Scientific') and  UPPER(CATEG_DESC)!=UPPER('Technical')  ORDER BY CATEG_DESC ";


    //query to get the Role of the employee
    public static final String GETEMPROLE =" SELECT S.EMP_NO,A.EMPROLE_ID,A.USERLOC_ID,A.ROLE_ID_GBL,A.SCREEN_SDESC,R.ROLE_ID,R.ROLE_LVL,GD.CODE_DESC ROLE_DESC "+
                                           " FROM SYSADMIN_EMP_ROLE_MST A,SYSADMIN_USER_LOC S,COM_GBL_DTL GD,SYSADMIN_ROLE_HEIRARCHY R "+
                                           " WHERE A.USERLOC_ID =S.USERLOC_ID  AND A.ROLE_ID_GBL=GD.GBL_CODE "+
                                           " AND R.ROLE_ID_GBL=A.ROLE_ID_GBL AND A.SCREEN_SDESC=? "+
                                           " AND S.EMP_NO=? ";

    //Query to insert into Miscellaneous Apprv Details 
    public static final String INSERTAPPRVDTLS=" INSERT INTO HRM_MISC_APPRV_DTLS D (D.APPR_ID, D.REQUEST_TYPE ,D.REQUEST_NO,D.LOC_ID,D.APPR_EMP_NO,D.APPR_NAME,D.APPR_DSGN,D.APPR_DATE,D.REVIEW_STATUS,D.APPRV_REVIEW_CMNTS,D.CREATED_USER_ID,D.CREATED_SITE_ID,D.CREATED_TIME_STMP) "+
                                               " VALUES(GET_ID(?,'HRM_MISC_APPRV_DTLS'), ?,?,?,?,?,?,TO_DATE(?,'DD/MM/YYYY'),?,?,?,?,SYSDATE)";

    public static final String UPDATEAPPRVDTLS="UPDATE HRM_MISC_APPRV_DTLS DT SET DT.REQUEST_NO=?,DT.MODIFIED_USER_ID=?,DT.MODIFIED_SITE_ID=?,DT.MODIFIED_TIME_STMP=SYSDATE WHERE DT.REQUEST_TYPE=? AND DT.REQUEST_NO=? ";
    //Query to retrieve the Approver Details 
    public static final String sql_getApprvDtls=" SELECT A.REQUEST_TYPE ,A.REQUEST_NO,A.LOC_ID,A.APPR_EMP_NO,A.APPR_NAME,A.APPR_DSGN,TO_CHAR(A.APPR_DATE,'DD/MM/YYYY') APPR_DATE  ,A.REVIEW_STATUS,A.APPR_ID ,RH.ROLE_LVL ,GD.CODE_DESC ROLE_DESC ,A.APPRV_REVIEW_CMNTS "+
                                                " FROM HRM_MISC_APPRV_DTLS A,SYSADMIN_ROLE_HEIRARCHY RH,COM_GBL_DTL GD "+
                                                " WHERE A.REQUEST_TYPE =? "+
                                                " AND A.REQUEST_NO=? "+
                                                " AND A.REVIEW_STATUS =RH.ROLE_ID_GBL(+) "+
                                                " AND A.REVIEW_STATUS =GD.GBL_CODE(+) "+
                                                " ORDER BY RH.ROLE_LVL ";

    //----------------Added by Abhishek------------------------------------
    public static final String PAY_PRESENT="select decode(nvl(t.pscale_topay5,0),0,decode(nvl(t.pscale_topay4,0),0,decode(nvl(t.pscale_topay3,0),0, "
                                  +"decode(nvl(t.pscale_topay2,0),0,decode(nvl(t.pscale_topay1,0),0,0,nvl(t.pscale_topay1,0)),   "
                                                                       +"nvl(t.pscale_topay2,0)),   "
                                  +"nvl(t.pscale_topay3,0)),   "
                                  +"nvl(t.pscale_topay4,0)),  " 
                                  +"nvl(t.pscale_topay5,0)) as pay "
                                  +"from hrm_payscale_mast t,hrm_grade_mast m,hrm_employee e "
                                  +"where m.pscal_cd=t.pscale_code "
                                  +"and e.emp_grade_id=m.grade_id "
                                  +"and e.emp_no=?";

    public static final String PAY_FUTURE="select distinct decode(nvl(t.pscale_topay5,0),0,decode(nvl(t.pscale_topay4,0),0,decode(nvl(t.pscale_topay3,0),0, "
                                          +"decode(nvl(t.pscale_topay2,0),0,decode(nvl(t.pscale_topay1,0),0,0,nvl(t.pscale_topay1,0)),   "
                                                                               +"nvl(t.pscale_topay2,0)),  " 
                                          +"nvl(t.pscale_topay3,0)),  " 
                                          +"nvl(t.pscale_topay4,0)),   "
                                          +"nvl(t.pscale_topay5,0)) as pay,m.grade_id   "
                                          +"from hrm_payscale_mast t,hrm_grade_mast m   "
                                          +"where m.pscal_cd=t.pscale_code order by m.grade_id";
                                                                    
    
}
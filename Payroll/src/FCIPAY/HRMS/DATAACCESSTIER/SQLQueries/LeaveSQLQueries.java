package FCIPAY.HRMS.DATAACCESSTIER.SQLQueries;

public class LeaveSQLQueries 
{
    public LeaveSQLQueries()
    {
    }

    /*public static final String SELECT_EMP_EXISTS="select  NVL(e.emp_fst_name,' ') emp_fst_name,NVL(e.emp_mdl_name,' ') emp_mdl_name,NVL(e.emp_lst_name,' ') emp_lst_name,  m.sect_name " +
    "  NVL(NVL(d.DSGN_DESC,C.GRADE_DESC), ' ') as dsgn_desc from hrm_dsgn_mast d,hrm_employee e , HRM_GRADE_MAST C ,hrm_sect_mast m  " +
    " where e.EMP_DSGN_ID = d.DSGN_ID(+) AND  " +
    " e.EMP_GRADE_ID = C.GRADE_ID(+)  " +
    " and  e.emp_sect_id=m.sect_id and emp_no=? ";*/



    public static final String SELECT_EMP_EXISTS="select  NVL(e.emp_fst_name,' ') emp_fst_name,NVL(e.emp_mdl_name,' ') emp_mdl_name,NVL(e.emp_lst_name,' ') emp_lst_name, NVL(m.sect_name,' ') as sect, " +
    " NVL(NVL(d.DSGN_DESC,C.GRADE_DESC), ' ') as dsgn_desc ,NVL(TO_CHAR(E.EMP_EXT_RET_DT,'DD/MM/YYYY'),NVL(TO_CHAR(E.EMP_NORM_RET_DT,'DD/MM/YYYY'), ' ')) as ret " +
    " from hrm_dsgn_mast d,hrm_employee e , HRM_GRADE_MAST C ,hrm_sect_mast m   " +
    " where e.EMP_DSGN_ID = d.DSGN_ID(+) AND   " +
    " e.EMP_GRADE_ID = C.GRADE_ID(+)   " +
    " and  e.emp_sect_id=m.sect_id(+) and e.emp_no=? and e.emp_unit_id=? and e.EMP_TEMP_STATUS IN ('HEMPSTATUS$PERM','HEMPSTATUS$PROMPROB','HEMPSTATUS$PROB') ";



    
    
    public static final String INSERT_JOINRPT="insert into HRM_LEAVE_JOINRPT " + 
    " ( JOINRPT_ID,LVEAPPL_ID,LVJNTRPT_APPLCN_DT,LVJNTRPT_EMP_NO,LVJNTRPT_DESIGN, " + 
    " LVJNTRPT_SECT,LVJNTRPT_TEL_NO,LVJNTRPT_STN,LVJNTRPT_JOIN_TIME, " +
    " LVJNTRPT_JOIN_DT, " +
    " LVJNTRPT_LV_FROM_DT,LVJNTRPT_LV_TO_DT,LVJNTRPT_PREFIX_DT1, " + 
    " LVJNTRPT_PREFIX_DT2,LVJNTRPT_SUFFIX_DT1,LVJNTRPT_SUFFIX_DT2, " + 
    " LVJNTRPT_NAME_SECTHEAD,LVJNTRPT_NAME_MGR,LVJNTRPT_STATUS, " + 
    " USER_ID_CREATED,CREATED_SITE_ID,CREATED_TIME_STMP) " + 
    " VALUES(get_id(?,'HRM_LEAVE_JOINRPT'),?,sysdate,?,?,?,?,?,?,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,'J',?,?,sysdate)";
    public static final String UPDATE_JOINRPT_LEAVEMAST="UPDATE HRM_EMP_LEAVEAPPLN_MAST SET  USER_ID_MODIFIED=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate ,LVE_JOIN_DATE=to_date(?,'dd/mm/yyyy') WHERE  LVEAPPL_ID=? ";
    public static final String GET_ATTENDANCE="SELECT * FROM HRM_EMP_ATT "+
    "WHERE ATT_EMP_NO=? AND TO_CHAR(ATT_DATE,'DD/MM/YYYY') = TO_CHAR(SYSDATE,'DD/MM/YYYY')";    

///Changed For adjustment 29/03
    public static final String SELECT_JOINRPT_DATE="select LVEAPPL_EMP_NO,LVE_APPLN_STATUS, LVE_APPR_STATUS ,LVE_JOIN_DATE, LVEAPPL_ID,to_char(LVE_FRM_DT,'DD/MM/YYYY') LVE_FRM_DT, to_char(LVE_TO_DT,'DD/MM/YYYY') LVE_TO_DT from HRM_EMP_LEAVEAPPLN_MAST where LVEAPPL_EMP_NO=? and LVE_APPLN_STATUS ='A' AND NVL(LVE_JOIN_DATE,TO_DATE('1/1/1000','DD/MM/YYYY')) =TO_DATE('1/1/1000','DD/MM/YYYY') AND NVL(TRUNC(SUFFIX_DT2),TRUNC(LVE_TO_DT)) <= TRUNC(SYSDATE)";

    public static final String SELECT_JOINRPT_PRESUF="select to_char(M.PREFIX_DT1, 'DD/MM/YYYY') PREFIX_DT1,to_char(M.PREFIX_DT2, 'DD/MM/YYYY') PREFIX_DT2,to_char(M.PREFIX_DT3, 'DD/MM/YYYY') PREFIX_DT3,to_char(M.SUFFIX_DT1, 'DD/MM/YYYY') SUFFIX_DT1,to_char(M.SUFFIX_DT2, 'DD/MM/YYYY') SUFFIX_DT2, D.NO_OF_DAYS SUFFIX_DT3 from HRM_EMP_LEAVEAPPLN_MAST M,HRM_EMP_LEAVEAPPLN_DTLS D where M.LVEAPPL_ID = ? AND M.LVEAPPL_ID=D.LVEAPPL_ID "+
    " AND D.LVEDTL_ID IN (SELECT MAX(D1.LVEDTL_ID) FROM HRM_EMP_LEAVEAPPLN_DTLS D1 "+
    " WHERE D1.LVEAPPL_ID=D.LVEAPPL_ID)";    


    public static final String GETMAX_LVEAPPL_ID=" select get_id(?,'HRM_EMP_LEAVEAPPLN_MAST') as LVEAPPL_ID from DUAL";
    public static final String INSERT_LEAVEAPPLN_DTLS="insert into HRM_EMP_LEAVEAPPLN_DTLS( LVEAPPL_ID,LVEDTL_ID,LEAVE_CODE, NO_OF_DAYS,LVE_FRM_DT,LVE_TO_DT,PREFIX_DT1,SUFFIX_DT1,PREFIX_DT2,SUFFIX_DT2,PREFIX_DT3,SUFFIX_DT3,LEAVE_REASON,USER_ID_CREATED,CREATED_SITE_ID,CREATED_TIME_STMP,NO_OF_HOLIDAYS,LVE_REV_NO,EXTENDED_FLAG) VALUES(?,get_id(?,'HRM_EMP_LEAVEAPPLN_DTLS'),?,?,to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),?,?,?,sysdate,?,?,?)";
    public static final String SELECT_LEAVEAPPLN_CODES="SELECT LEAVE_ID,LEAVE_SDESC,NVL(applicable_to,' ')as applicable_to FROM  HRM_LEAVE_MAST where display_flg='Y' ORDER BY LEAVE_SDESC";     
//Changed For Adjustment 29/03
//public static final String SELECT_LEAVECANCLN_DATE="select LVEAPPL_ID,to_char(LVE_FRM_DT,'DD/MM/YYYY') LVE_FRM_DT, to_char(LVE_TO_DT,'DD/MM/YYYY') LVE_TO_DT from HRM_EMP_LEAVEAPPLN_MAST where LVEAPPL_EMP_NO=? and NVL(LVE_JOIN_DATE,TO_DATE('1/1/1000','DD/MM/YYYY')) =TO_DATE('1/1/1000','DD/MM/YYYY') AND LVE_APPLN_STATUS!='C' AND LVE_APPLN_STATUS!='J' AND LVE_APPLN_STATUS!='L' and  LVEAPPL_ID in (select lvencash_appl_id  from hrm_leave_encash_appln  where lvencash_status='R')";
 public static final String SELECT_EXTN_DATE="select LVEAPPL_ID,to_char(LVE_FRM_DT,'DD/MM/YYYY') LVE_FRM_DT, to_char(LVE_TO_DT,'DD/MM/YYYY') LVE_TO_DT from HRM_EMP_LEAVEAPPLN_MAST where LVEAPPL_EMP_NO=? and NVL(LVE_JOIN_DATE,TO_DATE('1/1/1000','DD/MM/YYYY')) =TO_DATE('1/1/1000','DD/MM/YYYY') AND LVE_APPLN_STATUS!='C' AND LVE_APPLN_STATUS!='J' AND LVE_APPLN_STATUS!='L' and nvl(LVE_APPR_LVL,0) != -1";

public static final String SELECT_LEAVECANCLN_DATE="select m.LVEAPPL_ID,to_char(m.LVE_FRM_DT,'DD/MM/YYYY') LVE_FRM_DT, " +
   " to_char(m.LVE_TO_DT,'DD/MM/YYYY') LVE_TO_DT " +
   " from hrm_emp_leaveappln_mast m  " +
   " where m.LVEAPPL_EMP_NO=? and " +
   "  NVL(m.LVE_JOIN_DATE,TO_DATE('1/1/1000','DD/MM/YYYY')) =TO_DATE('1/1/1000','DD/MM/YYYY') AND " +
   "  m.LVE_APPLN_STATUS!='C' AND m.LVE_APPLN_STATUS!='J' AND m.LVE_APPLN_STATUS!='L' and  nvl(m.LVE_APPR_LVL,0) != -1 and " +
  "   m.LVEAPPL_ID not in (select nvl(lvencash_appl_id,0)  from hrm_leave_encash_appln  where lvencash_status!='R') AND m.lveappl_id not in (select nvl(leave_id,0) from hrm_ltc_emp_encash where LTCENCASH_APPLN_STATUS != 'J') and "+
  "     m.lveappl_id not in(select nvl(ltcempclm_lv_id,0) from hrm_ltc_emp_clm where LTCEMPCLM_APPLN_STATUS != 'J') and m.lveappl_id not in(select nvl(ltcempadv_lv_id,0) from hrm_ltc_emp_adv where LTCEMPADV_APPLN_STATUS != 'J') and "+
  "   DECODE(GREATEST(SYSDATE-NVL(PREFIX_DT2,LVE_FRM_DT),0),0,'NOT STARTED',"+
  "   DECODE(NVL(M.LVE_APPR_LVL,0),1,'YES','NO')) IN ('YES','NOT STARTED') AND "+
  "   NOT EXISTS"+
  "   (SELECT MS.LVEAPPL_ID FROM HRM_EMP_LEAVEAPPLN_MAST MS "+
  "   WHERE MS.LVE_APPLN_STATUS IN ('R','E') "+
  "   AND MS.LVE_APPR_LVL=1 AND MS.LVEAPPL_ID = M.LVEAPPL_ID) "+
  "   AND NOT EXISTS "+
  "   (SELECT MS1.LVEAPPL_ID FROM HRM_EMP_LEAVEAPPLN_MAST MS1 "+
  "   WHERE MS1.LVE_APPLN_STATUS IN ('R','E') "+
  "   AND  DECODE(GREATEST(SYSDATE - NVL(PREFIX_DT2, LVE_FRM_DT), 0),"+
  "   0,'NOT STARTED',"+
  "   DECODE(NVL(M.LVE_APPR_LVL, 0), 1, 'YES', 'NO')) = 'YES' AND MS1.LVEAPPL_ID = M.LVEAPPL_ID)"+
  "   AND M.PAYROLL_YYYYMM IS NULL";




   /// public static final String GET_LEAVEMAST_DTLS="select * from HRM_LEAVE_MAST";
    public static final String GET_LEAVEMAST_DTLS="select LEAVE_ID,LEAVE_SDESC," +
 " NVL( MAX_LIMIT_1, 999) as MAX_LIMIT_1,NVL( MAX_LIMIT_2, 999) as MAX_LIMIT_2," +
 " NVL( MAX_LIMIT_3, 999) as MAX_LIMIT_3 ," +
 " NVL( MAX_LIMIT_FREQ, ' ') as MAX_LIMIT_FREQ,NVL( MIN_EXP_REQ, 0) as MIN_EXP_REQ " +
" from  hrm_leave_mast ";
    
 public static final String INSERT_LEAVEAPPLN_MAST="INSERT INTO  HRM_EMP_LEAVEAPPLN_MAST(LVEAPPL_ID,LVEAPPL_DT,LVE_FRM_DT,LVE_TO_DT,PREFIX_DT1,SUFFIX_DT1,PREFIX_DT2,SUFFIX_DT2,PREFIX_DT3,SUFFIX_DT3,LVEAPPL_EMP_NO,LVEAPPL_DESIG,LVEAPPL_SECT,LTC_FLG,SALADV_REQD_FLG,LVEAPPL_LV_ADDRESS,LVE_APPLN_STATUS,LVE_REV_NO,LVE_APPR_STATUS,USER_ID_CREATED,CREATED_SITE_ID,CREATED_TIME_STMP )VALUES(?,SYSDATE,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,'0',?,?,?,sysdate)";
   // public static final String INSERT_LEAVEAPPLN_MAST="INSERT INTO  HRM_EMP_LEAVEAPPLN_MAST(LVEAPPL_ID,LVEAPPL_DT,LVE_FRM_DT,LVE_TO_DT,PREFIX_DT1,SUFFIX_DT1,PREFIX_DT2,SUFFIX_DT2,PREFIX_DT3,SUFFIX_DT3,LVEAPPL_EMP_NO,LVEAPPL_DESIG,LVEAPPL_SECT,LTC_FLG,SALADV_REQD_FLG,LVEAPPL_LV_ADDRESS,LVE_APPLN_STATUS,LVE_REV_NO,LVE_APPR_STATUS,USER_ID_CREATED,CREATED_SITE_ID,CREATED_TIME_STMP )VALUES(?,SYSDATE,to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy'),?,?,?,?,?,?,'N','0','N',?,?,sysdate)";
 //   public static final String SELECT_LEAVECANCLN_DTLS="select a.lvedtl_id lvedtl_id,c.LEAVE_ID LEAVE_ID,c.LEAVE_SDESC LEAVE_SDESC,m.LTC_FLG LTC_FLG,m.SALADV_REQD_FLG SALADV_REQD_FLG,m.LVEAPPL_LV_ADDRESS LVEAPPL_LV_ADDRESS, a.LEAVE_CODE LEAVE_CODE,a.NO_OF_DAYS NO_OF_DAYS,to_char(a.LVE_FRM_DT,'DD/MM/YYYY') LVE_FRM_DT, to_char(a.LVE_TO_DT,'DD/MM/YYYY') LVE_TO_DT ,to_char(a.PREFIX_DT1,'DD/MM/YYYY') PREFIX_DT1,to_char(a.PREFIX_DT2,'DD/MM/YYYY') PREFIX_DT2,to_char(a.PREFIX_DT3,'DD/MM/YYYY') PREFIX_DT3,to_char(a.SUFFIX_DT1,'DD/MM/YYYY') SUFFIX_DT1,to_char(a.SUFFIX_DT2,'DD/MM/YYYY') SUFFIX_DT2,to_char(a.SUFFIX_DT3,'DD/MM/YYYY') SUFFIX_DT3,a.LEAVE_REASON,m.LVE_APPLN_STATUS LVE_APPLN_STATUS,m.LVE_APPR_STATUS LVE_APPR_STATUS,a.LVE_REV_NO LVE_REV_NO,a.EXTENDED_FLAG EXT_FLG from HRM_EMP_LEAVEAPPLN_DTLS a, HRM_EMP_LEAVEAPPLN_MAST m,HRM_LEAVE_MAST c where (a.LEAVE_CODE=c.LEAVE_ID) AND (a.LVEAPPL_ID=m.LVEAPPL_ID) and a.LVEAPPL_ID=? and a.LVE_REV_NO in(select max(LVE_REV_NO) from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=?) ORDER BY LVEDTL_ID";
     public static final String SELECT_LEAVECANCLN_DTLS="select a.lvedtl_id lvedtl_id,c.LEAVE_ID LEAVE_ID,c.LEAVE_SDESC LEAVE_SDESC,m.LTC_FLG LTC_FLG,m.SALADV_REQD_FLG SALADV_REQD_FLG,m.LVEAPPL_LV_ADDRESS LVEAPPL_LV_ADDRESS, a.LEAVE_CODE LEAVE_CODE,a.NO_OF_DAYS NO_OF_DAYS,to_char(a.LVE_FRM_DT,'DD/MM/YYYY') LVE_FRM_DT, to_char(a.LVE_TO_DT,'DD/MM/YYYY') LVE_TO_DT ,to_char(a.PREFIX_DT1,'DD/MM/YYYY') PREFIX_DT1,to_char(a.PREFIX_DT2,'DD/MM/YYYY') PREFIX_DT2,to_char(a.PREFIX_DT3,'DD/MM/YYYY') PREFIX_DT3,to_char(a.SUFFIX_DT1,'DD/MM/YYYY') SUFFIX_DT1,to_char(a.SUFFIX_DT2,'DD/MM/YYYY') SUFFIX_DT2,to_char(a.SUFFIX_DT3,'DD/MM/YYYY') SUFFIX_DT3,a.LEAVE_REASON,m.LVE_APPLN_STATUS LVE_APPLN_STATUS,m.LVE_APPR_STATUS LVE_APPR_STATUS,a.LVE_REV_NO LVE_REV_NO,NVL(a.EXTENDED_FLAG,' ') as  EXT_FLG from HRM_EMP_LEAVEAPPLN_DTLS a, HRM_EMP_LEAVEAPPLN_MAST m,HRM_LEAVE_MAST c where (a.LEAVE_CODE=c.LEAVE_ID) AND (a.LVEAPPL_ID=m.LVEAPPL_ID) and a.LVEAPPL_ID=? and a.LVE_REV_NO in(select max(LVE_REV_NO) from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=?) ORDER BY LVEDTL_ID";

    // Select the leave details for approval
    public static final String SELECT_LEAVE_APP_DTLS="select c.LEAVE_ID LEAVE_ID,c.LEAVE_SDESC LEAVE_SDESC,m.LTC_FLG LTC_FLG,m.SALADV_REQD_FLG SALADV_REQD_FLG,m.LVEAPPL_LV_ADDRESS LVEAPPL_LV_ADDRESS, a.LEAVE_CODE LEAVE_CODE,a.NO_OF_DAYS NO_OF_DAYS,to_char(a.LVE_FRM_DT,'DD/MM/YYYY') LVE_FRM_DT, to_char(a.LVE_TO_DT,'DD/MM/YYYY') LVE_TO_DT ,to_char(a.PREFIX_DT1,'DD/MM/YYYY') PREFIX_DT1,to_char(a.PREFIX_DT2,'DD/MM/YYYY') PREFIX_DT2,to_char(a.PREFIX_DT3,'DD/MM/YYYY') PREFIX_DT3,to_char(a.SUFFIX_DT1,'DD/MM/YYYY') SUFFIX_DT1,to_char(a.SUFFIX_DT2,'DD/MM/YYYY') SUFFIX_DT2,to_char(a.SUFFIX_DT3,'DD/MM/YYYY') SUFFIX_DT3,a.LEAVE_REASON,m.LVE_APPLN_STATUS LVE_APPLN_STATUS,m.LVE_APPR_STATUS LVE_APPR_STATUS,m.LVE_REV_NO LVE_REV_NO from HRM_EMP_LEAVEAPPLN_DTLS a, HRM_EMP_LEAVEAPPLN_MAST m,HRM_LEAVE_MAST c where (a.LEAVE_CODE=c.LEAVE_ID) AND (a.LVEAPPL_ID=m.LVEAPPL_ID) and a.LVEAPPL_ID=? and a.LVE_REV_NO in(select max(LVE_REV_NO) from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=?) ORDER BY LVEDTL_ID";    
    
    
    public static final String UPDATE_LEAVECANCLN="UPDATE HRM_EMP_LEAVEAPPLN_MAST SET LVE_APPLN_STATUS=DECODE(GREATEST(SYSDATE-NVL(PREFIX_DT2,LVE_FRM_DT),0),0,DECODE(LVE_APPR_LVL,1,'N','C'),DECODE(LVE_APPR_LVL,1,'N','N')),LVE_APPR_LVL=-1,USER_ID_MODIFIED=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate WHERE  LVEAPPL_ID=? ";

    public static final String SELECT_STATUS="select lve_appln_status from  hrm_emp_leaveappln_mast where lveappl_id=? ";

    public static final String UPDATE_LEAVECANCLN_DTLS="UPDATE HRM_EMP_LEAVEAPPLN_DTLS SET EXTENDED_FLAG='C', user_id_modified=?,modified_site_id=?,modified_time_stmp=sysdate where "+
    " LVEAPPL_ID=? and LVEDTL_ID > "+
    " ALL(SELECT t1.lve_dt_id from hrm_emp_leaveappln_hist h, table(h.lve_dt_ids) t1 "+
    " WHERE H.LVEAPPL_ID = ? "+
    " AND H.LVE_HIST_ID = (SELECT MAX(H1.LVE_HIST_ID) FROM HRM_EMP_LEAVEAPPLN_HIST H1 "+
    " WHERE H1.LVEAPPL_ID = ?)) ";

    public static final String UPDATE_LEAVECANCLN_DTLS_CURR="UPDATE HRM_EMP_LEAVEAPPLN_DTLS SET EXTENDED_FLAG='C', user_id_modified=?,modified_site_id=?,modified_time_stmp=sysdate where "+
    " LVEAPPL_ID=? and LVEDTL_ID "+
    " IN(SELECT t1.lve_dt_id from hrm_emp_leaveappln_hist h, table(h.lve_dt_ids) t1 "+
    " WHERE H.LVEAPPL_ID = ? "+
    " AND H.LVE_HIST_ID = (SELECT MAX(H1.LVE_HIST_ID) FROM HRM_EMP_LEAVEAPPLN_HIST H1 "+
    " WHERE H1.LVEAPPL_ID = ?)) ";  

    public static final String UPDATE_LEAVECANCLN_DTLS_ALL="UPDATE HRM_EMP_LEAVEAPPLN_DTLS SET EXTENDED_FLAG='C', user_id_modified=?,modified_site_id=?,modified_time_stmp=sysdate where   LVEAPPL_ID=? ";    


 
    // Leave Cancel "





    public static final String SELECT_LEAVEPREV_REC="select c.LEAVE_ID LEAVE_ID,c.LEAVE_SDESC LEAVE_SDESC,m.LTC_FLG LTC_FLG,m.SALADV_REQD_FLG SALADV_REQD_FLG,m.LVEAPPL_LV_ADDRESS LVEAPPL_LV_ADDRESS, a.LEAVE_CODE LEAVE_CODE,a.NO_OF_DAYS NO_OF_DAYS,to_char(a.LVE_FRM_DT,'DD/MM/YYYY') LVE_FRM_DT, to_char(a.LVE_TO_DT,'DD/MM/YYYY') LVE_TO_DT ,to_char(a.PREFIX_DT1,'DD/MM/YYYY') PREFIX_DT1,to_char(a.PREFIX_DT2,'DD/MM/YYYY') PREFIX_DT2,to_char(a.PREFIX_DT3,'DD/MM/YYYY') PREFIX_DT3,to_char(a.SUFFIX_DT1,'DD/MM/YYYY') SUFFIX_DT1,to_char(a.SUFFIX_DT2,'DD/MM/YYYY') SUFFIX_DT2,to_char(a.SUFFIX_DT3,'DD/MM/YYYY') SUFFIX_DT3,a.LEAVE_REASON,m.LVE_APPLN_STATUS LVE_APPLN_STATUS,m.LVE_APPR_STATUS LVE_APPR_STATUS,a.LVE_REV_NO LVE_REV_NO,a.extended_flag ext_flg,a.lvedtl_id lvedtl_id from HRM_EMP_LEAVEAPPLN_DTLS a, HRM_EMP_LEAVEAPPLN_MAST m,HRM_LEAVE_MAST c where (a.LEAVE_CODE=c.LEAVE_ID) AND (a.LVEAPPL_ID=m.LVEAPPL_ID) and a.LVEAPPL_ID=? and a.LVE_REV_NO not in(select max(LVE_REV_NO) from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=?) and a.LVE_REV_NO in (select max(LVE_REV_NO) from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=? and extended_flag like '%A' union select LVE_REV_NO from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=? and extended_flag not like '%A') order by lvedtl_id";


    public static final String SELECT_LEAVE_APPLN="select * from hrm_emp_leaveappln";


    public static final String SELECT_LEAVEREVN_MAXREVNO="select LVE_REV_NO from hrm_emp_leaveappln_mast WHERE  LVEAPPL_ID=?";

//Changed For Adjustment 29/03

    public static final String SELECT_LEAVEREVN_DATE="Select m.LVEAPPL_ID, m.lve_appr_status,to_char( m.lve_frm_dt,'DD/MM/YYYY') lve_frm_dt, " + 
"   to_char( m.lve_to_dt,'DD/MM/YYYY') lve_to_dt from hrm_emp_leaveappln_mast m   " + 
"   where m.LVEAPPL_EMP_NO=? and SYSDATE <= DECODE(m.LVE_JOIN_DATE,NULL,ADD_MONTHS(m.LVE_TO_DT,1),ADD_MONTHS(m.LVE_JOIN_DATE,1))   " + 
"   AND  m.LVE_APPLN_STATUS='A' and  m.LVE_APPLN_STATUS!= 'C' AND  m.LVE_APPLN_STATUS!= 'J' AND  m.LVE_APPLN_STATUS!= 'L' and nvl(m.LVE_APPR_LVL,0) != -1 and " + 
"   m.LVEAPPL_ID not in (select lvencash_appl_id  from hrm_leave_encash_appln  where lvencash_status!='R')  AND M.PAYROLL_YYYYMM IS NULL";




    public static final String UPDATE_LEAVEREVN_MAST="UPDATE HRM_EMP_LEAVEAPPLN_MAST SET lve_appr_lvl=0, LVE_REV_NO=?,LTC_FLG=?,SALADV_REQD_FLG=?,LVEAPPL_LV_ADDRESS=?,LVE_FRM_DT=to_date(?,'dd-mm-yyyy'),LVE_TO_DT=to_date(?,'dd-mm-yyyy') ,PREFIX_DT1=to_date(?,'dd-mm-yyyy'),SUFFIX_DT1=to_date(?,'dd-mm-yyyy'),PREFIX_DT2=to_date(?,'dd-mm-yyyy'),SUFFIX_DT2=to_date(?,'dd-mm-yyyy'),LVE_APPLN_STATUS='R', USER_ID_MODIFIED=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate WHERE  LVEAPPL_ID=?";


    public static final String INSERT_LEAVEREVN_DTLS="insert into HRM_EMP_LEAVEAPPLN_DTLS( LVEAPPL_ID,LVEDTL_ID,LEAVE_CODE, NO_OF_DAYS,LVE_FRM_DT,LVE_TO_DT,PREFIX_DT1,SUFFIX_DT1,PREFIX_DT2,SUFFIX_DT2,PREFIX_DT3,SUFFIX_DT3,LEAVE_REASON,LVE_REV_NO,USER_ID_CREATED,CREATED_SITE_ID,CREATED_TIME_STMP,NO_OF_HOLIDAYS,extended_flag) VALUES(?,get_id(?,'HRM_EMP_LEAVEAPPLN_DTLS'),?,?,to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),to_date(?,'dd-mm-yyyy'),?,?,?,?,sysdate,?,'R')";



    public static final String UPDATE_LEAVEEXTN_MAST="UPDATE HRM_EMP_LEAVEAPPLN_MAST SET lve_appr_lvl=0,LVE_APPLN_STATUS='E',LVE_TO_DT=to_date(?,'dd-mm-yyyy'),SUFFIX_DT1=to_date(?,'dd-mm-yyyy'),SUFFIX_DT2=to_date(?,'dd-mm-yyyy'),SUFFIX_DT3=to_date(?,'dd-mm-yyyy'), USER_ID_MODIFIED=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate WHERE  LVEAPPL_ID=?";

    // Make the Suffix dates null for the last row
    public static final String UPDATE_LEAVEEXTN_DTLS="UPDATE HRM_EMP_LEAVEAPPLN_DTLS DT SET DT.SUFFIX_DT1=NULL,DT.SUFFIX_DT2=NULL,USER_ID_MODIFIED=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate WHERE DT.LVEDTL_ID=(SELECT MAX(DT1.LVEDTL_ID) FROM HRM_EMP_LEAVEAPPLN_DTLS DT1 WHERE DT1.LVEAPPL_ID=?)";
    
    
    public static final String GET_LEAVEBAL_Y="Select sum(EMPLVBAL_LVE_AVAILED) DAYS from hrm_emp_leave_BAL Where EMPLVBAL_LVE_CODE =? and EMPLVBAL_FROM_DATE >= to_date(?,'dd-mm-yyyy') and EMPLVBAL_TO_DATE <=to_date(?,'dd-mm-yyyy') and EMPLVBAL_emp_no =?";

////new code for rev n appr
 public static final String GET_LEAVEBAL_Y_RA = "select nvl(c.emplvbal_lve_availed,0)- sum(nvl(a.no_of_days,0)) as days " +
 " from (select * from hrm_emp_leaveappln_dtls where lve_rev_no =  " +
 " (select max(LVE_REV_NO)  " +
 " from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=?)) a, " +
 " hrm_emp_leaveappln_mast b,hrm_emp_leave_bal c " +
 " where a.lveappl_id=b.lveappl_id(+) and a.leave_code(+)=c.emplvbal_lve_code  " +
 " and a.lveappl_id(+)=? " +
 " and a.leave_code(+)= ?  " +
 " and c.emplvbal_lve_code= ? And c.EMPLVBAL_emp_no =?  " +
 " and EMPLVBAL_FROM_DATE >= to_date(?,'dd-mm-yyyy') and EMPLVBAL_TO_DATE <=to_date(?,'dd-mm-yyyy') " +
 " group by c.emplvbal_lve_availed " ;






    public static final String GET_LEAVEBAL_S="Select sum(EMPLVBAL_LVE_AVAILED) DAYS from hrm_emp_leave_BAL Where EMPLVBAL_LVE_CODE =? and EMPLVBAL_emp_no =?";

  /*  public static final String GET_LEAVEBAL_S_RA="select sum(nvl(c.emplvbal_lve_availed,0)) - sum(nvl(a.no_of_days,0)) as days " +
       " from (select * from hrm_emp_leaveappln_dtls where lve_rev_no =  " +
       " (select max(LVE_REV_NO)  " +
       " from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=?)) a, " +
       " hrm_emp_leaveappln_mast b,hrm_emp_leave_bal c " +
       " where a.lveappl_id=b.lveappl_id(+) and a.leave_code(+)=c.emplvbal_lve_code  " +
       " and a.lveappl_id(+)=? " +
       " and a.leave_code(+)= ? " +
       " and c.emplvbal_lve_code= ? And c.EMPLVBAL_emp_no =?  " +
       " group by c.emplvbal_lve_code ";

*/
public static final String GET_LEAVEBAL_S_RA=" select (SELECT SUM(BL.EMPLVBAL_LVE_AVAILED) " +
" FROM HRM_EMP_LEAVE_BAL BL WHERE BL.EMPLVBAL_EMP_NO=? AND " + 
" BL.EMPLVBAL_LVE_CODE=? )- ( " +
" SELECT SUM(LD.NO_OF_DAYS) FROM HRM_EMP_LEAVEAPPLN_DTLS LD,HRM_EMP_LEAVEAPPLN_MAST LM WHERE " +
" LM.LVEAPPL_ID=? AND LM.LVEAPPL_EMP_NO=? AND LD.LVEAPPL_ID=LM.LVEAPPL_ID AND " +
" LD.LVE_REV_NO =(SELECT MAX(LD1.LVE_REV_NO) FROM HRM_EMP_LEAVEAPPLN_DTLS LD1 WHERE " +
" LD1.LVEAPPL_ID=LM.LVEAPPL_ID AND LD1.LEAVE_CODE=LD.LEAVE_CODE)  " +
" AND LD.LEAVE_CODE=?)   AS  days FROM DUAL";




//    public static final String GET_LEAVEBAL_S="Select sum(APP_NO_OF_DAYS) DAYS from hrm_emp_leaveappln_mast a, hrm_emp_leaveappln_dtls b Where a. LVEAPPL_ID = b. LVEAPPL_ID And b.leave_code = ? and a.lveappl_emp_no = ?";

 //    public static final String GET_LEAVEBAL_O=" Select EMPLVBAL_LVE_BALANCE as DAYS from hrm_emp_leave_BAL  Where EMPLVBAL_LVE_CODE = ? And EMPLVBAL_emp_no =? "+
  //  "and EMPLVBAL_FROM_DATE = (SELECT MAX(EMPLVBAL_FROM_DATE) FROM hrm_emp_leave_BAL)";

    /*changed 22/3
     public static final String GET_LEAVEBAL_O=" Select MAX(EMPLVBAL_FROM_DATE),EMPLVBAL_LVE_BALANCE as DAYS from hrm_emp_leave_BAL  Where EMPLVBAL_LVE_CODE = ? And EMPLVBAL_emp_no =? "+
    "GROUP BY EMPLVBAL_LVE_BALANCE";
    */

    public static final String GET_LEAVEBAL_O=" Select EMPLVBAL_LVE_BALANCE+ NVL(EMPLVBAL_LVE_LAPSED,0) as DAYS " +
" from hrm_emp_leave_BAL   " +
" Where EMPLVBAL_LVE_CODE = ? And EMPLVBAL_emp_no =?  " +
" and to_char(emplvbal_from_date,'dd/mm/yyyy')=( " +
" select to_char(MAX(EMPLVBAL_FROM_DATE),'dd/mm/yyyy') from hrm_emp_leave_BAL " +
" Where EMPLVBAL_LVE_CODE = ? And EMPLVBAL_emp_no =?)";

 public static final String GET_LEAVEBAL_O_RA="select nvl(c.emplvbal_lve_balance,0) + sum(nvl(a.no_of_days,0)) as days " +
 " from (select * from hrm_emp_leaveappln_dtls where lve_rev_no =  " +
 " (select max(LVE_REV_NO)  " +
 " from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=?)) a, " +
 " hrm_emp_leaveappln_mast b,hrm_emp_leave_bal c " +
 " where a.lveappl_id=b.lveappl_id(+) and a.leave_code(+)=c.emplvbal_lve_code  " +
 " and a.lveappl_id(+)=?  " +
 " and a.leave_code(+)= ?  " +
 " and c.emplvbal_lve_code= ? And c.EMPLVBAL_emp_no =? and  " +
 " to_char(c.emplvbal_from_date,'dd/mm/yyyy')=( " +
 " select to_char(MAX(EMPLVBAL_FROM_DATE),'dd/mm/yyyy') from hrm_emp_leave_BAL " +
 " Where EMPLVBAL_LVE_CODE =? And EMPLVBAL_emp_no = ?)  " +
 " group by c.emplvbal_lve_balance ";





    

    public static final String GET_LEAVEBAL_COMMUTED="Select EMPLVBAL_LVE_BALANCE  as DAYS from hrm_emp_leave_BAL A,HRM_LEAVE_MAST B " +
    " Where A.EMPLVBAL_LVE_CODE = B.LEAVE_ID AND B.LEAVE_SDESC = 'HPL' And EMPLVBAL_emp_no = ? "+
    " and EMPLVBAL_FROM_DATE =  (SELECT MAX(EMPLVBAL_FROM_DATE) from  hrm_emp_leave_BAL c,HRM_LEAVE_MAST d " +
    " Where c.EMPLVBAL_LVE_CODE = d.LEAVE_ID AND d.LEAVE_SDESC = 'HPL' ) ";


    public static final String GET_LEAVEBAL_COMMUTED_RA="select nvl(c.emplvbal_lve_balance,0)+ sum(nvl(a.no_of_days,0)) as days " +
    " from (select * from hrm_emp_leaveappln_dtls where lve_rev_no =  " +
    " (select max(LVE_REV_NO)  " +
    " from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=?)) a, " +
    " hrm_emp_leaveappln_mast b,hrm_emp_leave_bal c,hrm_leave_mast d " +
    " where a.lveappl_id=b.lveappl_id(+) and a.leave_code(+)=c.emplvbal_lve_code " +
    " and c.emplvbal_lve_code = d.leave_id  " +
    " and d.leave_sdesc = 'HPL' " +
    " and a.lveappl_id(+)=? " + 
    " And c.EMPLVBAL_emp_no =?  " +
    " and to_char(c.emplvbal_from_date,'dd/mm/yyyy')=( " +
    " select to_char(MAX(EMPLVBAL_FROM_DATE),'dd/mm/yyyy') from hrm_emp_leave_BAL e, " +
    " hrm_leave_mast f Where e.EMPLVBAL_LVE_CODE = f.leave_id And f.leave_sdesc = 'HPL') " +
    " group by c.emplvbal_lve_balance ";

    






     public static final String GET_LEAVEBAL_HPLCREDIT="Select credit_days  as DAYS  from hrm_leave_credit A,HRM_LEAVE_MAST B where A.LEAVE_ID = B.LEAVE_ID AND B.LEAVE_SDESC = 'HPL'"; 



    public static final String UPDATE_LEAVEAPPRVL="Update HRM_EMP_LEAVEAPPLN_MAST SET LVE_APPR_STATUS=?,LVE_APPLN_STATUS=?,ESTT_AUTH_DT=sysdate,ESTT_AUTHO_NAME=?,ESTT_AUTHO_DESGN=?,USER_ID_MODIFIED=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where LVEAPPL_ID=? and LVE_APPLN_STATUS in ('N','R','E')"; 
                    
    // Update sanction status
    public static final String UPDATE_LEAVESANC_APP="Update HRM_EMP_LEAVEAPPLN_MAST SET LVE_APPR_LVL=?,LVE_APPR_REM=?,RECOMNDG_AUTHO_DT=sysdate,RECOMNDG_AUTHO_NAME=?,RECOMNDG_AUTHO_DESG=?,USER_ID_MODIFIED=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where LVEAPPL_ID=? and LVE_APPLN_STATUS in ('N','R','E')"; 
    public static final String UPDATE_LEAVESANC_REJ="Update HRM_EMP_LEAVEAPPLN_MAST SET LVE_APPR_LVL=?,LVE_APPR_REM=?,LVE_APPR_STATUS=?,LVE_APPLN_STATUS=?,RECOMNDG_AUTHO_DT=sysdate,RECOMNDG_AUTHO_NAME=?,RECOMNDG_AUTHO_DESG=?,USER_ID_MODIFIED=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where LVEAPPL_ID=? and LVE_APPLN_STATUS in ('N','R','E')";     

  //Change for Adjustment 29/03
//    public static final String SELECT_LEAVEAPPL_ID="select LVEAPPL_ID,LVEAPPL_EMP_NO FROM HRM_EMP_LEAVEAPPLN_MAST WHERE lveappl_emp_no!=? and LVE_APPLN_STATUS NOT IN ('A','J','C','L') AND NVL(LVE_APPR_LVL,0)=1 ORDER BY LVEAPPL_ID";
    public static final String SELECT_LEAVEAPPL_ID="select distinct (M.LVEAPPL_EMP_NO||'-'|| MA.LEAVE_SDESC)LEAVE_DESC,M.LVEAPPL_ID,M.LVEAPPL_EMP_NO FROM HRM_EMP_LEAVEAPPLN_MAST M,HRM_EMP_LEAVEAPPLN_DTLS DT,HRM_LEAVE_MAST MA WHERE LVE_APPLN_STATUS NOT IN ('A','J','C','L') AND NVL(LVE_APPR_LVL,0)=1 and  DT.LVEAPPL_ID = M.LVEAPPL_ID AND MA.LEAVE_ID = DT.LEAVE_CODE AND EXISTS(SELECT G2.EMP_NO FROM SYSADMIN_GRP_EMP_MST G2 WHERE EXISTS(SELECT G1.GRP_SDESC FROM SYSADMIN_GRP_EMP_MST G1,SYSADMIN_GRP_MST G WHERE G.MODULE_GBL='M$LEAVE' AND G1.EMP_NO=? AND G.GRP_SDESC=G1.GRP_SDESC AND G.GRP_STAT_FLG='A' AND G2.GRP_SDESC=G1.GRP_SDESC AND G2.EMP_NO!=G1.EMP_NO) AND  G2.EMP_NO=LVEAPPL_EMP_NO) ORDER BY M.LVEAPPL_ID";    

    // Leaves for sanction
/*    public static final String SELECT_LEAVEAPPL_ID_SANC=" SELECT LVEAPPL_ID,LVEAPPL_EMP_NO FROM HRM_EMP_LEAVEAPPLN_MAST " +
    " WHERE LVEAPPL_EMP_NO IN (SELECT E1.EMP_NO FROM HRM_EMPLOYEE E1 " +
    " START WITH E1.EMP_REP_ID=? CONNECT BY PRIOR E1.EMP_NO=E1.EMP_REP_ID AND LEVEL<3) AND LVE_APPLN_STATUS NOT IN ('A','J','C','L') AND NVL(LVE_APPR_LVL,0)!=1  " +
    " UNION  " +
    " SELECT LVEAPPL_ID,LVEAPPL_EMP_NO FROM HRM_EMP_LEAVEAPPLN_MAST  " +
    " WHERE LVEAPPL_EMP_NO IN(SELECT E1.EMP_NO FROM HRM_EMPLOYEE E1,HRM_GRADE_MAST G WHERE " +
    " E1.EMP_NO=? AND G.GRADE_ID=E1.EMP_GRADE_ID AND UPPER(TRIM(G.GRADE_DESC))=UPPER('CMD'))  AND LVE_APPLN_STATUS NOT IN ('A','J','C','L') AND NVL(LVE_APPR_LVL,0)!=1  " +
    " ORDER BY LVEAPPL_ID  ";*/

    public static final String SELECT_LEAVEAPPL_ID_SANC=" SELECT TRIM(B.EMP_CHQ_NAME) || '-' || A.LVEAPPL_ID AS LVEAPPL_ID,A.LVEAPPL_EMP_NO FROM HRM_EMP_LEAVEAPPLN_MAST A, HRM_EMPLOYEE B " +
    " WHERE A.LVEAPPL_EMP_NO IN (SELECT E1.EMP_NO FROM HRM_EMPLOYEE E1 " +
    " START WITH E1.EMP_REP_ID=? CONNECT BY PRIOR E1.EMP_NO=E1.EMP_REP_ID AND LEVEL<3) AND LVE_APPLN_STATUS NOT IN ('A','J','C','L') AND NVL(LVE_APPR_LVL,0)!=1  AND B.EMP_NO=A.LVEAPPL_EMP_NO " +
    " UNION  " +
    " SELECT TRIM(B.EMP_CHQ_NAME) || '-' || A.LVEAPPL_ID AS LVEAPPL_ID,A.LVEAPPL_EMP_NO FROM HRM_EMP_LEAVEAPPLN_MAST A,  HRM_EMPLOYEE B " +
    " WHERE A.LVEAPPL_EMP_NO IN(SELECT E1.EMP_NO FROM HRM_EMPLOYEE E1,HRM_GRADE_MAST G WHERE " +
    " E1.EMP_NO=? AND G.GRADE_ID=E1.EMP_GRADE_ID AND UPPER(TRIM(G.GRADE_DESC))=UPPER('CMD'))  AND LVE_APPLN_STATUS NOT IN ('A','J','C','L') AND NVL(LVE_APPR_LVL,0)!=1  AND B.EMP_NO=A.LVEAPPL_EMP_NO " +
    " ORDER BY LVEAPPL_ID  ";    
//    public static final String SELECT_LEAVEAPPL_ID_SANC= " SELECT LVEAPPL_ID,LVEAPPL_EMP_NO FROM HRM_EMP_LEAVEAPPLN_MAST " +
//    " WHERE LVEAPPL_EMP_NO IN (SELECT E1.EMP_NO FROM HRM_EMPLOYEE E1 " +
//    " START WITH E1.EMP_REP_ID=? CONNECT BY PRIOR E1.EMP_NO=E1.EMP_REP_ID AND LEVEL<3) AND LVE_APPLN_STATUS NOT IN ('A','J','C','L') AND NVL(LVE_APPR_LVL,0)!=1  " +
//    " ORDER BY LVEAPPL_ID " ;
//    public static final String SELECT_LEAVEAPPL_ID_SANC="SELECT LVEAPPL_ID,LVEAPPL_EMP_NO FROM HRM_EMP_LEAVEAPPLN_MAST "+
//                                                        "WHERE LVEAPPL_EMP_NO IN (SELECT E.EMP_NO FROM HRM_EMPLOYEE E WHERE "+
//                                                        "E.EMP_REP_ID=?) AND LVE_APPLN_STATUS NOT IN ('A','J','C','L') AND NVL(LVE_APPR_LVL,0)!=1 ORDER BY LVEAPPL_ID";


    
   //  public static final String SELECT_LEAVEAPPL_ID="select LVEAPPL_ID,LVEAPPL_EMP_NO,LVE_APPLN_STATUS FROM HRM_EMP_LEAVEAPPLN_MAST WHERE LVE_APPLN_STATUS NOT LIKE 'J'";
    
      
    public static final String SELECT_LEAVEBAL_DTLS="select EMPLVBAL_LVE_AVAILED,EMPLVBAL_LVE_BALANCE from HRM_EMP_LEAVE_BAL where EMPLVBAL_EMP_NO=? and EMPLVBAL_LVE_ID=?";
    
    public static final String UPDATE_LEAVEBAL_EL="Update HRM_EMP_LEAVE_BAL set EMPLVBAL_LVE_AVAILED = EMPLVBAL_LVE_AVAILED + ?,EMPLVBAL_LVE_BALANCE = EMPLVBAL_LVE_BALANCE - ?, MODIFIED_USER_ID=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where EMPLVBAL_EMP_NO = ? and EMPLVBAL_LVE_CODE=? and EMPLVBAL_FROM_DATE = (select max(EMPLVBAL_FROM_DATE) from HRM_EMP_LEAVE_BAL where EMPLVBAL_LVE_CODE = ?) ";

    // Added for implementing changes in EL
    public static final String UPDATE_LEAVEBAL_EL_1="Update HRM_EMP_LEAVE_BAL set EMPLVBAL_LVE_AVAILED = EMPLVBAL_LVE_AVAILED + ?,EMPLVBAL_LVE_BALANCE = EMPLVBAL_LVE_BALANCE - ?,EMPLVBAL_LVE_LAPSED=?, MODIFIED_USER_ID=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where EMPLVBAL_EMP_NO = ? and EMPLVBAL_LVE_CODE=? and EMPLVBAL_FROM_DATE = (select max(EMPLVBAL_FROM_DATE) from HRM_EMP_LEAVE_BAL where EMPLVBAL_LVE_CODE = ?) ";

    public static final String UPDATE_LEAVEBAL_COMMUTED="Update HRM_EMP_LEAVE_BAL set EMPLVBAL_LVE_BALANCE = EMPLVBAL_LVE_BALANCE - (?*2) ,  MODIFIED_USER_ID=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where EMPLVBAL_EMP_NO = ? and EMPLVBAL_LVE_CODE = (SELECT LEAVE_ID FROM HRM_LEAVE_MAST WHERE LEAVE_SDESC = 'HPL') and EMPLVBAL_FROM_DATE = (select max(EMPLVBAL_FROM_DATE) from HRM_EMP_LEAVE_BAL where EMPLVBAL_LVE_CODE = (SELECT LEAVE_ID FROM HRM_LEAVE_MAST WHERE LEAVE_SDESC = 'HPL'))";

    public static final String UPDATE_LEAVEBAL_OTHER=" Update HRM_EMP_LEAVE_BAL set EMPLVBAL_LVE_AVAILED = EMPLVBAL_LVE_AVAILED + ?, MODIFIED_USER_ID=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where EMPLVBAL_EMP_NO =? and EMPLVBAL_LVE_CODE=? and to_char(EMPLVBAL_FROM_DATE,'YYYY')=? ";

 public static final String UPDATE_LEAVEDTL_EXTNFLG="Update hrm_emp_leaveappln_dtls set extended_flag=? ,user_id_modified=?,modified_site_id=?,modified_time_stmp=sysdate where  lvedtl_id=? ";
    // Leave Cancel 

    public static final String REVERT_LEAVEBAL_EL="Update HRM_EMP_LEAVE_BAL set EMPLVBAL_LVE_AVAILED = EMPLVBAL_LVE_AVAILED - ?,EMPLVBAL_LVE_BALANCE = EMPLVBAL_LVE_BALANCE + ?,EMPLVBAL_LVE_LAPSED=?, MODIFIED_USER_ID=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where EMPLVBAL_EMP_NO = ? and EMPLVBAL_LVE_CODE=? and EMPLVBAL_FROM_DATE = (select max(EMPLVBAL_FROM_DATE) from HRM_EMP_LEAVE_BAL where EMPLVBAL_LVE_CODE = ?) ";

    public static final String REVERT_LEAVEBAL_EL1="Update HRM_EMP_LEAVE_BAL set EMPLVBAL_LVE_AVAILED = EMPLVBAL_LVE_AVAILED - ?,EMPLVBAL_LVE_BALANCE = EMPLVBAL_LVE_BALANCE + ?, MODIFIED_USER_ID=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where EMPLVBAL_EMP_NO = ? and EMPLVBAL_LVE_CODE=? and EMPLVBAL_FROM_DATE = (select max(EMPLVBAL_FROM_DATE) from HRM_EMP_LEAVE_BAL where EMPLVBAL_LVE_CODE = ?) ";

    public static final String REVERT_LEAVEBAL_COMMUTED="Update HRM_EMP_LEAVE_BAL set EMPLVBAL_LVE_BALANCE = EMPLVBAL_LVE_BALANCE + (?*2) ,  MODIFIED_USER_ID=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where EMPLVBAL_EMP_NO = ? and EMPLVBAL_LVE_CODE = (SELECT LEAVE_ID FROM HRM_LEAVE_MAST WHERE LEAVE_SDESC = 'HPL') and EMPLVBAL_FROM_DATE = (select max(EMPLVBAL_FROM_DATE) from HRM_EMP_LEAVE_BAL where EMPLVBAL_LVE_CODE = (SELECT LEAVE_ID FROM HRM_LEAVE_MAST WHERE LEAVE_SDESC = 'HPL'))";

    public static final String REVERT_LEAVEBAL_OTHER=" Update HRM_EMP_LEAVE_BAL set EMPLVBAL_LVE_AVAILED = EMPLVBAL_LVE_AVAILED - ?, MODIFIED_USER_ID=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where EMPLVBAL_EMP_NO =? and EMPLVBAL_LVE_CODE=? and to_char(EMPLVBAL_FROM_DATE,'YYYY')=? ";

    public static final String GET_MONTHS="select months_between(to_date(?,'dd/mm/yyyy'),to_date(?,'dd/mm/yyyy')) as NO_OF_MONS from dual";

    // Check leave balance record
    public static final String CHECK_LV_REC="select COUNT(*) AS COUNT from HRM_EMP_LEAVE_BAL where EMPLVBAL_EMP_NO = ? and EMPLVBAL_LVE_CODE=? and to_char(EMPLVBAL_FROM_DATE,'YYYY')=?";
    // Insert leave balance record
    public static final String INSERT_LV_REC="INSERT INTO HRM_EMP_LEAVE_BAL ("+
    "EMPLVBAL_LVE_ID,EMPLVBAL_EMP_NO,EMPLVBAL_LVE_CODE,EMPLVBAL_FROM_DATE,EMPLVBAL_TO_DATE,"+	
    "EMPLVBAL_LVE_CREDITED,EMPLVBAL_LVE_AVAILED,EMPLVBAL_LVE_BALANCE,CREATED_USER_ID,"+
    "CREATED_SITE_ID,CREATED_TIME_STMP)VALUES(GET_ID(?,'HRM_EMP_LEAVE_BAL'),"+
    "?,?,TO_DATE(?,'DD/MM/YYYY'),TO_DATE(?,'DD/MM/YYYY'),0,?,0,?,?,SYSDATE)";

    // Leave Encashment Queries
//    public static final String SELECT_CREDIT_DTLS = "SELECT  to_char(D.EMPLVBAL_FROM_DATE,'dd/mm/yyyy') EMPLVBAL_FROM_DATE,D.EMPLVBAL_LVE_AVAILED ,    D.EMPLVBAL_LVE_CREDITED ,D.EMPLVBAL_LVE_BALANCE AS EMPLVBAL_LVE_BALANCE,E.LEAVE_LDESC LEAVE_LDESC,E.LEAVE_SDESC AS DESC1 FROM HRM_EMP_LEAVE_BAL D,HRM_LEAVE_MAST E WHERE to_char(D.EMPLVBAL_FROM_DATE,'dd/mm/yyyy') IN(SELECT MAX(EMPLVBAL_FROM_DATE) EMPLVBAL_FROM_DATE   FROM HRM_EMP_LEAVE_BAL A, HRM_LEAVE_CREDIT B,HRM_LEAVE_MAST C WHERE A.EMPLVBAL_EMP_NO= ? AND D.EMPLVBAL_EMP_NO=A.EMPLVBAL_EMP_NO AND A.EMPLVBAL_LVE_CODE=C.LEAVE_ID  AND A.EMPLVBAL_LVE_CODE=B.LEAVE_ID  GROUP BY  A.EMPLVBAL_LVE_CODE,C.LEAVE_LDESC,C.LEAVE_SDESC); AND D.EMPLVBAL_LVE_CODE=E.LEAVE_ID GROUP BY D.EMPLVBAL_FROM_DATE,D.EMPLVBAL_LVE_CODE,D.EMPLVBAL_LVE_CREDITED ,D.EMPLVBAL_LVE_AVAILED,D.EMPLVBAL_LVE_BALANCE,E.LEAVE_LDESC,E.LEAVE_SDESC";
    //public static final String SELECT_CREDIT_DTLS = "SELECT EMPLVBAL_FROM_DATE,EMPLVBAL_LVE_CREDITED,EMPLVBAL_LVE_AVAILED,EMPLVBAL_LVE_BALANCE,C.LEAVE_LDESC LEAVE_LDESC,C.LEAVE_SDESC FROM HRM_EMP_LEAVE_BAL A,HRM_LEAVE_CREDIT B,HRM_LEAVE_MAST C WHERE A.EMPLVBAL_LVE_CODE=B.LEAVE_ID AND A.EMPLVBAL_LVE_CODE=C.LEAVE_ID AND EMPLVBAL_EMP_NO=? AND C.LEAVE_SDESC <> 'HPL' AND EMPLVBAL_FROM_DATE=(SELECT MAX(EMPLVBAL_FROM_DATE) FROM HRM_EMP_LEAVE_BAL)";

/*    public static final String SELECT_CREDIT_DTLS = 
    "SELECT  to_char(D.EMPLVBAL_FROM_DATE,'dd/mm/yyyy') EMPLVBAL_FROM_DATE,D.EMPLVBAL_LVE_AVAILED ,"+
"D.EMPLVBAL_LVE_CREDITED ,D.EMPLVBAL_LVE_BALANCE AS EMPLVBAL_LVE_BALANCE,"+
"E.LEAVE_LDESC LEAVE_LDESC,E.LEAVE_SDESC AS DESC1 FROM  "+
"HRM_EMP_LEAVE_BAL D,HRM_LEAVE_MAST E WHERE to_char(D.EMPLVBAL_FROM_DATE,'dd/mm/yyyy') IN("+
"SELECT MAX(to_char(EMPLVBAL_FROM_DATE,'dd/mm/yyyy')) EMPLVBAL_FROM_DATE "+
"FROM HRM_EMP_LEAVE_BAL A,"+
"HRM_LEAVE_CREDIT B,HRM_LEAVE_MAST C "+
"WHERE A.EMPLVBAL_EMP_NO=? AND D.EMPLVBAL_EMP_NO=A.EMPLVBAL_EMP_NO AND "+
"A.EMPLVBAL_LVE_CODE=C.LEAVE_ID  AND "+
"A.EMPLVBAL_LVE_CODE=B.LEAVE_ID  GROUP BY  A.EMPLVBAL_LVE_CODE,"+
"C.LEAVE_LDESC,C.LEAVE_SDESC)  AND D.EMPLVBAL_LVE_CODE=E.LEAVE_ID GROUP BY D.EMPLVBAL_FROM_DATE,D.EMPLVBAL_LVE_CODE,D.EMPLVBAL_LVE_CREDITED ,D.EMPLVBAL_LVE_AVAILED,D.EMPLVBAL_LVE_BALANCE,"+
"E.LEAVE_LDESC,E.LEAVE_SDESC";

    public static final String SELECT_DURATION_DTLS = "SELECT LVEAPPL_ID LVEAPPL_ID, to_char(LVE_FRM_DT, 'dd/mm/yyyy') LVE_FRM_DT,to_char(LVE_TO_DT, 'dd/mm/yyyy') LVE_TO_DT FROM HRM_EMP_LEAVEAPPLN_MAST A where A.LVE_FRM_DT >= SYSDATE and A.LVEAPPL_EMP_NO = ? AND LVE_APPLN_STATUS NOT IN ('C','J')";
    public static final String SELECT_DURATIONQUERY_DTLS = "SELECT A.LVEAPPL_ID LVEAPPL_ID, to_char(A.LVE_FRM_DT, 'dd/mm/yyyy') LVE_FRM_DT,to_char(A.LVE_TO_DT, 'dd/mm/yyyy') LVE_TO_DT FROM HRM_EMP_LEAVEAPPLN_MAST A,  HRM_LEAVE_ENCASH_APPLN B WHERE A.LVEAPPL_EMP_NO = ? AND A.LVEAPPL_ID = B.LVENCASH_APPL_ID AND B.LVENCASH_STATUS = 'N'";
    public static final String SELECT_DURATION_PRD = "SELECT SUM(B.NO_OF_DAYS) NO_OF_DAYS FROM hrm_emp_leaveappln_mast A, hrm_emp_leaveappln_dtls B where A.LVE_FRM_DT >= SYSDATE,'dd/mm/yyyy') and A.LVEAPPL_EMP_NO = ? and A.LVEAPPL_ID = B.LVEAPPL_ID AND A.LVEAPPL_ID = ?";
    public static final String INSERT_ENCASHAPP_DTLS = "INSERT INTO HRM_LEAVE_ENCASH_APPLN_DUMMY (LVENCASH_ID,LVENCASH_APPLCN_DT,LVENCASH_EMP_NO,LVENCASH_DESIG,LVENCASH_BASIC_PAY,LVENCASH_SECT,LVENCASH_PROPOS_LV,LVENCASH_APPL_ID,LVENCASH_STATUS,CREATED_USER_ID,CREATED_SITE_ID,CREATED_TIME_STMP)VALUES(get_id(?,'HRM_LEAVE_ENCASH_APPLN'),sysdate,?,?,?,?,?,?,'N',?,?,sysdate)";
    public static final String SELECT_PROPDURATION_DTLS = "SELECT LVENCASH_ID,LVENCASH_PROPOS_LV FROM  HRM_LEAVE_ENCASH_APPLN_DUMMY WHERE LVENCASH_STATUS = 'N' AND LVENCASH_EMP_NO = ? AND LVENCASH_APPL_ID =?";
    public static final String SELECT_APPL_DTLS = "SELECT LVENCASH_ID FROM HRM_LEAVE_ENCASH_APPLN_DUMMY WHERE LVENCASH_STATUS = 'N'";    

*/

  public static final String SELECT_CREDIT_DTLS = 
    "SELECT  to_char(D.EMPLVBAL_FROM_DATE,'dd/mm/yyyy') EMPLVBAL_FROM_DATE,D.EMPLVBAL_LVE_AVAILED ,"+
"D.EMPLVBAL_LVE_CREDITED ,D.EMPLVBAL_LVE_BALANCE AS EMPLVBAL_LVE_BALANCE,"+
"E.LEAVE_LDESC LEAVE_LDESC,E.LEAVE_SDESC AS DESC1,E.LEAVE_ID LEAVE_ID FROM  "+
"HRM_EMP_LEAVE_BAL D,HRM_LEAVE_MAST E,HRM_LEAVE_CREDIT F WHERE to_char(D.EMPLVBAL_FROM_DATE,'dd/mm/yyyy') IN("+
"SELECT TO_CHAR(MAX(EMPLVBAL_FROM_DATE),'DD/MM/YYYY') EMPLVBAL_FROM_DATE "+
"FROM HRM_EMP_LEAVE_BAL A,"+
"HRM_LEAVE_CREDIT B,HRM_LEAVE_MAST C "+
"WHERE A.EMPLVBAL_EMP_NO=? AND D.EMPLVBAL_EMP_NO=A.EMPLVBAL_EMP_NO AND "+
"A.EMPLVBAL_LVE_CODE=C.LEAVE_ID  AND "+
"A.EMPLVBAL_LVE_CODE=B.LEAVE_ID AND D.EMPLVBAL_LVE_CODE=A.EMPLVBAL_LVE_CODE GROUP BY  A.EMPLVBAL_LVE_CODE,"+
"C.LEAVE_LDESC,C.LEAVE_SDESC)  AND D.EMPLVBAL_LVE_CODE=E.LEAVE_ID AND D.EMPLVBAL_LVE_CODE=F.LEAVE_ID GROUP BY D.EMPLVBAL_FROM_DATE,D.EMPLVBAL_LVE_CODE,D.EMPLVBAL_LVE_CREDITED ,D.EMPLVBAL_LVE_AVAILED,D.EMPLVBAL_LVE_BALANCE,"+
"E.LEAVE_LDESC,E.LEAVE_SDESC,E.LEAVE_ID";

 public static final String SELECT_ENCASH_DTSTATUS = "select count(*) as  RESULT "
         +" from HRM_LEAVE_ENCASH_APPLN A, hrm_emp_leaveappln_mast B "
         +"where B.LVEAPPL_EMP_NO = ? and a.lvencash_appl_id = B.LVEAPPL_ID and "
               +"A.LVENCASH_STATUS = 'A' and B.LVE_FRM_DT between "
       +"to_date('01/01/' || (select to_char(sysdate, 'yyyy') from dual), "
               +"'dd/mm/yyyy') and "
       +"to_date('31/12/' || (select to_char(to_number(to_char(sysdate, 'yyyy')) + 1) "
                              +"from dual), "
              +" 'dd/mm/yyyy')";

 /*public static final String SELECT_ENCASH_DTSTATUS = 
  " select 1 RESULT from dual " +
  " where " +
  "  ( " +
  "   select B.LVE_FRM_DT " +
  "   from HRM_LEAVE_ENCASH_APPLN A, hrm_emp_leaveappln_mast B " +
  "   where B.LVEAPPL_EMP_NO = ? " +
  "   and a.lvencash_appl_id = B.LVEAPPL_ID " +
  "   and A.LVENCASH_STATUS = 'A' " +
  "   )" +
  "   between " +
  "   to_date('01/01/'||(select to_char(sysdate, 'yyyy') from dual), 'dd/mm/yyyy') and " +
  "   to_date('31/12/'||(select to_char(to_number(to_char(sysdate, 'yyyy'))+1) from dual), 'dd/mm/yyyy') " ;
*/
public static final String SELECT_ENCASHAPPL_STATUS = "SELECT COUNT(*) COUNT FROM HRM_LEAVE_ENCASH_APPLN WHERE LVENCASH_EMP_NO =? AND LVENCASH_STATUS IN ('N')";

//public static final String SELECT_DURATION_DTLS = "SELECT LVEAPPL_ID LVEAPPL_ID, to_char(LVE_FRM_DT, 'dd/mm/yyyy') LVE_FRM_DT,to_char(LVE_TO_DT, 'dd/mm/yyyy') LVE_TO_DT FROM HRM_EMP_LEAVEAPPLN_MAST A where to_char(LVE_FRM_DT, 'dd/mm/yyyy') >= to_char(SYSDATE, 'dd/mm/yyyy') and A.LVEAPPL_EMP_NO = ? AND LVE_APPLN_STATUS NOT IN ('C','J') AND LVEAPPL_ID in (select LVEAPPL_ID from HRM_EMP_LEAVEAPPLN_DTLS where LEAVE_CODE IN (select leave_id from hrm_leave_mast WHERE LEAVE_SDESC NOT LIKE ('CL')))";

public static final String SELECT_DURATION_DTLS = "SELECT A.LVEAPPL_EMP_NO,A.LVEAPPL_ID LVEAPPL_ID, to_char(B.LVE_FRM_DT, 'dd/mm/yyyy') LVE_FRM_DT," +
" to_char(B.LVE_TO_DT, 'dd/mm/yyyy') LVE_TO_DT,C.LEAVE_SDESC LEAVE_SDESC FROM HRM_EMP_LEAVEAPPLN_MAST A,HRM_EMP_LEAVEAPPLN_DTLS B," +
" HRM_LEAVE_MAST C where A.LVE_FRM_DT >= TO_DATE(TO_CHAR(SYSDATE,'DD/MM/YYYY'),'DD/MM/YYYY') and to_char(A.LVE_FRM_DT,'yyyy') = to_char(SYSDATE,'yyyy') and A.LVEAPPL_EMP_NO = ?" + 
" AND A.LVE_APPLN_STATUS NOT IN ('C','J','L') AND A.LVEAPPL_ID = B.LVEAPPL_ID  AND B.LEAVE_CODE = C.LEAVE_ID AND C.LEAVE_SDESC  IN ('EL','AL')" +
" AND A.LVEAPPL_ID NOT IN (SELECT LVENCASH_APPL_ID from HRM_LEAVE_ENCASH_APPLN WHERE LVENCASH_STATUS NOT IN ('N','R')) and b.lve_rev_no= "+
" (select max(lve_rev_no) from hrm_emp_leaveappln_dtls where lveappl_id=b.lveappl_id)";




public static final String SELECT_DURATIONQUERY_DTLS = "SELECT A.LVEAPPL_ID LVEAPPL_ID, to_char(A.LVE_FRM_DT, 'dd/mm/yyyy')" +
" LVE_FRM_DT,to_char(A.LVE_TO_DT, 'dd/mm/yyyy') LVE_TO_DT FROM HRM_EMP_LEAVEAPPLN_MAST A,  HRM_LEAVE_ENCASH_APPLN B WHERE A.LVEAPPL_EMP_NO = ? AND A.LVEAPPL_ID = B.LVENCASH_APPL_ID AND B.LVENCASH_STATUS = 'N'";
/* Changed*/public static final String SELECT_DURATION_PRD = "SELECT B.NO_OF_DAYS NO_OF_DAYS FROM hrm_emp_leaveappln_mast A, hrm_emp_leaveappln_dtls B where A.LVE_FRM_DT >= TRUNC(SYSDATE) and A.LVEAPPL_EMP_NO = ? and A.LVEAPPL_ID = B.LVEAPPL_ID AND A.LVEAPPL_ID = ? and b.lve_rev_no="+
" (select max(lve_rev_no) from hrm_emp_leaveappln_dtls where lveappl_id=b.lveappl_id)";
    /* Changed*/    public static final String INSERT_ENCASHAPP_DTLS = "INSERT INTO HRM_LEAVE_ENCASH_APPLN (LVENCASH_ID,LVENCASH_APPLCN_DT,LVENCASH_EMP_NO,LVENCASH_DESIG,LVENCASH_BASIC_PAY,LVENCASH_SECT,LVENCASH_PROPOS_LV,LVENCASH_APPL_ID,LVENCASH_STATUS,CREATED_USER_ID,CREATED_SITE_ID,CREATED_TIME_STMP,LVENCASH_LV_BAL,LVENCASH_LV_CODE) VALUES(?,sysdate,?,?,?,?,?,?,'N',?,?,sysdate,?,?)";
    public static final String SELECT_PROPDURATION_DTLS = "SELECT LVENCASH_ID,LVENCASH_PROPOS_LV FROM  HRM_LEAVE_ENCASH_APPLN_DUMMY WHERE LVENCASH_STATUS = 'N' AND LVENCASH_EMP_NO = ? AND LVENCASH_APPL_ID =?";
//    public static final String SELECT_APPL_DTLS = "SELECT LVENCASH_ID FROM HRM_LEAVE_ENCASH_APPLN WHERE LVENCASH_STATUS = 'N' AND LVENCASH_EMP_NO != ? AND NVL(LVENCASH_APPR_LVL,0)=1 ORDER BY LVENCASH_ID";   
    public static final String SELECT_APPL_DTLS = "SELECT LVENCASH_ID FROM HRM_LEAVE_ENCASH_APPLN WHERE LVENCASH_STATUS = 'N' AND EXISTS(SELECT G2.EMP_NO FROM SYSADMIN_GRP_EMP_MST G2 WHERE EXISTS(SELECT G1.GRP_SDESC FROM SYSADMIN_GRP_EMP_MST G1,SYSADMIN_GRP_MST G WHERE G.MODULE_GBL='M$LEAVEENC' AND G1.EMP_NO=? AND G.GRP_SDESC=G1.GRP_SDESC AND G.GRP_STAT_FLG='A' AND G2.GRP_SDESC=G1.GRP_SDESC AND G2.EMP_NO!=G1.EMP_NO) AND  G2.EMP_NO=LVENCASH_EMP_NO) AND NVL(LVENCASH_APPR_LVL,0)=1 ORDER BY LVENCASH_ID";   

   
    // For Sanction
    public static final String SELECT_APPL_DTLS_SANC =" SELECT LVENCASH_ID FROM HRM_LEAVE_ENCASH_APPLN WHERE LVENCASH_STATUS = 'N' AND LVENCASH_EMP_NO IN " +
    " (SELECT E1.EMP_NO FROM HRM_EMPLOYEE E1 " +
    " START WITH E1.EMP_REP_ID=? CONNECT BY PRIOR E1.EMP_NO=E1.EMP_REP_ID AND LEVEL<3) AND  " +
    " NVL(LVENCASH_APPR_LVL,0)!=1 " +
    " UNION " +
    " SELECT LVENCASH_ID FROM HRM_LEAVE_ENCASH_APPLN WHERE LVENCASH_STATUS = 'N' AND LVENCASH_EMP_NO IN " +
    " (SELECT E1.EMP_NO FROM HRM_EMPLOYEE E1,HRM_GRADE_MAST G WHERE " +
    " E1.EMP_NO=? AND G.GRADE_ID=E1.EMP_GRADE_ID AND UPPER(TRIM(G.GRADE_DESC))=UPPER('CMD')) AND  " +
    " NVL(LVENCASH_APPR_LVL,0)!=1 ORDER BY LVENCASH_ID " ;
//    public static final String SELECT_APPL_DTLS_SANC =" SELECT LVENCASH_ID FROM HRM_LEAVE_ENCASH_APPLN WHERE LVENCASH_STATUS = 'N' AND LVENCASH_EMP_NO IN " +
//    " (SELECT E1.EMP_NO FROM HRM_EMPLOYEE E1 " +
//    " START WITH E1.EMP_REP_ID=? CONNECT BY PRIOR E1.EMP_NO=E1.EMP_REP_ID AND LEVEL<3) AND  " +
//    " NVL(LVENCASH_APPR_LVL,0)!=1 ORDER BY LVENCASH_ID " ;
    
//    public static final String SELECT_APPL_DTLS_SANC = "SELECT LVENCASH_ID FROM HRM_LEAVE_ENCASH_APPLN WHERE LVENCASH_STATUS = 'N' AND LVENCASH_EMP_NO IN "+
//                                                        "(SELECT E.EMP_NO FROM HRM_EMPLOYEE E WHERE E.EMP_REP_ID=?) AND "+
//                                                        "NVL(LVENCASH_APPR_LVL,0)!=1 ORDER BY LVENCASH_ID";        
    //public static final String SELECT_ENCASH_DTLS = "SELECT LVENCASH_LV_BAL, LVENCASH_PROPOS_LV, LVENCASH_BASIC_PAY,LVENCASH_EMP_NO,LVENCASH_LV_CODE FROM HRM_LEAVE_ENCASH_APPLN WHERE LVENCASH_ID = ?";
    //public static final String SELECT_ENCASH_DTLS = "SELECT A.LVENCASH_ID, A.LVENCASH_LV_BAL, A.LVENCASH_PROPOS_LV, A.LVENCASH_BASIC_PAY, A.LVENCASH_EMP_NO, A.LVENCASH_LV_CODE, (A.LVENCASH_BASIC_PAY + B.SPECIAL_PAY + B.PERSONAL_PAY + B.NPA) PAY FROM HRM_LEAVE_ENCASH_APPLN A, HRM_PAYROLL_PARAM B WHERE A.LVENCASH_EMP_NO = B.EMP_NO AND A.LVENCASH_ID = ?";  
    public static final String SELECT_DA_DP_DTLS = "select nvl(c.da_rate, 0) da_rate,nvl(c.dp_rate, 0) dp_rate "
                                                    +"from pay_da_rate c,hrm_employee e,HRM_LEAVE_ENCASH_APPLN f "
                                                    +"where f.lvencash_id=? "
                                                    +"and e.emp_no=f.lvencash_emp_no "
                                                    +"and c.yyyymm = (select max(d.yyyymm) "
                                                             +" from pay_da_rate d,HRM_EMP_LEAVEAPPLN_MAST M "
                                                             +"where e.emp_5th_pay_basic between d.low_basic and d.high_basic and M.LVEAPPL_ID = f.LVENCASH_APPL_ID and  "
                                                                   +"d.yyyymm <= "
                                                                   +"to_number(to_char(to_date(to_char(M.LVE_FRM_DT,'dd/mm/yyyy'), 'dd/mm/yyyy'), 'yyyymm')))";
    public static final String SELECT_ENCASH_DTLS = "SELECT A.LVENCASH_ID,A.LVENCASH_LV_BAL,A.LVENCASH_PROPOS_LV,A.LVENCASH_BASIC_PAY,A.LVENCASH_EMP_NO,A.LVENCASH_LV_CODE, "
                                                          +" nvl((A.LVENCASH_BASIC_PAY + C.SPECIAL_PAY + C.PERSONAL_PAY + C.NPA_AMOUNT),A.LVENCASH_BASIC_PAY) PAY "
                                                      +"FROM HRM_LEAVE_ENCASH_APPLN A, PAY_EMP_MAST C "
                                                     +"WHERE A.LVENCASH_EMP_NO = C.EMP_NUM(+) AND A.LVENCASH_ID =?";  
    public static final String UPDATE_ENCASH_DTLS = "UPDATE HRM_LEAVE_ENCASH_APPLN SET LVENCASH_ENCSH_BAL= ?, LVENCASH_NONENCSH_BAL = ?, LVENCASH_ADMSBLE_AMNT =?, LVENCASH_SANC_AMNT= ?, LVENCASH_LVE_ENCSH_DAYS =?, LVENCASH_STATUS = ?, MODIFIED_USER_ID = ?, MODIFIED_SITE_ID = ?, MODIFIED_TIME_STMP = sysdate WHERE LVENCASH_ID = ? AND LVENCASH_STATUS not in ('A','R') ";
    public static final String REJECT_ENCASH_DTLS = "UPDATE HRM_LEAVE_ENCASH_APPLN SET LVENCASH_STATUS = 'R', MODIFIED_USER_ID = ?, MODIFIED_SITE_ID = ?, MODIFIED_TIME_STMP = sysdate WHERE LVENCASH_ID = ? AND LVENCASH_STATUS not in ('A','R')";
    // Update sanction details
    public static final String UPDATE_ENCASH_DTLS_SANC = "UPDATE HRM_LEAVE_ENCASH_APPLN SET LVENCASH_APPR_LVL=?,LVENCASH_APPR_REM=?,LVENCASH_SANCTN_DT=SYSDATE,LVENCASH_SANCTN_NAME=?,LVENCASH_SANCTN_DSGN=?,MODIFIED_USER_ID = ?, MODIFIED_SITE_ID = ?, MODIFIED_TIME_STMP = sysdate  WHERE LVENCASH_ID = ? AND LVENCASH_STATUS not in ('A','R') ";
    public static final String REJECT_ENCASH_DTLS_SANC = "UPDATE HRM_LEAVE_ENCASH_APPLN SET LVENCASH_APPR_LVL=?,LVENCASH_STATUS='R',LVENCASH_APPR_REM=?,LVENCASH_SANCTN_DT=SYSDATE,LVENCASH_SANCTN_NAME=?,LVENCASH_SANCTN_DSGN=?,MODIFIED_USER_ID = ?, MODIFIED_SITE_ID = ?, MODIFIED_TIME_STMP = sysdate  WHERE LVENCASH_ID = ? AND LVENCASH_STATUS not in ('A','R') ";
    // Reject the Leave Application for Waivel
    public static final String REJECT_LEAVE_APP = "UPDATE HRM_EMP_LEAVEAPPLN_MAST "+
    "SET LVE_APPR_LVL=-2,LVE_APPR_REM='WAIVEL GIVEN BY DIRECTOR',LVE_APPR_STATUS='J',"+
    "LVE_APPLN_STATUS='J',RECOMNDG_AUTHO_DT=sysdate,RECOMNDG_AUTHO_NAME=?,RECOMNDG_AUTHO_DESG=?,"+
    "USER_ID_MODIFIED=?,MODIFIED_SITE_ID=?,MODIFIED_TIME_STMP=SYSDATE "+
    "WHERE LVEAPPL_ID=(SELECT LVENCASH_APPL_ID FROM HRM_LEAVE_ENCASH_APPLN WHERE LVENCASH_ID=?)";
    
    public static final String UPDATE_LEAVE_BAL = "UPDATE HRM_EMP_LEAVE_BAL SET EMPLVBAL_LVE_AVAILED = EMPLVBAL_LVE_AVAILED + ?,EMPLVBAL_LVE_BALANCE = EMPLVBAL_LVE_BALANCE - ?, MODIFIED_USER_ID=?,MODIFIED_SITE_ID=?, MODIFIED_TIME_STMP=sysdate where EMPLVBAL_EMP_NO = ? and EMPLVBAL_LVE_CODE=? and EMPLVBAL_FROM_DATE = (select max(EMPLVBAL_FROM_DATE) from HRM_EMP_LEAVE_BAL where EMPLVBAL_LVE_CODE = ?) ";
    public static final String GETMAX_LVEENCASH_ID=" select get_id(?,'HRM_LEAVE_ENCASH_APPLN') as LVEENCASH_ID from DUAL";


//LeaveAdjustment Queries

public static final String SELECT_LEAVEADJUSTMENT_CODES="SELECT LEAVE_ID,LEAVE_SDESC FROM  HRM_LEAVE_MAST ORDER BY LEAVE_SDESC";     
//Changed For Adjustment 29/03
public static final String SELECT_COUNT_UNAPPRVD="select count(*) as UNAPPRVD  from hrm_emp_leaveappln_dtls d , " + 
" hrm_emp_leaveappln_mast m where  d.LVEAPPL_ID=m.LVEAPPL_ID and  ((m.LVE_APPR_STATUS='N' or m.LVE_APPLN_STATUS='N') and m.LVE_APPLN_STATUS!='C' and m.LVE_APPLN_STATUS!='L')  and m.LVEAPPL_EMP_NO=? " +
" and d.LEAVE_CODE=? and m.lveappl_id!=? ";

 
public static final String SELECT_COUNT_COMHPL_UNAPPRVD="select count(*) as UNAPPRVD  from hrm_emp_leaveappln_dtls d , " +
 " hrm_emp_leaveappln_mast m  where  d.LVEAPPL_ID=m.LVEAPPL_ID and  " +
 " ((m.LVE_APPR_STATUS='N' or m.LVE_APPLN_STATUS='N') and m.LVE_APPLN_STATUS!='C' and m.LVE_APPLN_STATUS!='L')  " +
 " and m.LVEAPPL_EMP_NO=? and d.LEAVE_CODE in  " +
" (select leave_id from hrm_leave_mast where leave_sdesc in ('HPL','Commuted Leave')) and m.lveappl_id!=? ";




/*public static final String SELECT_COUNT_ALREADYAPPLD="select count(*)  as ALREADYAPPLD from hrm_emp_leaveappln_dtls d,hrm_emp_leaveappln_mast m " + 
 " where d.lveappl_id=m.lveappl_id and m.lveappl_emp_no=? and to_char(d.lve_frm_dt,'dd/mm/yyyy')=to_char(to_date(?,'dd/mm/yyyy'),'dd/mm/yyyy') " +
 " and m.lve_appln_status not in ('C','J') and m.lveappl_id!=? ";
*/
//Changed For Adjustment 29/03
/*public static final String SELECT_COUNT_ALREADYAPPLD=" select count(*)  as ALREADYAPPLD from hrm_emp_leaveappln_dtls d,hrm_emp_leaveappln_mast m " +
   " where d.lveappl_id=m.lveappl_id and m.lveappl_emp_no=? and " +
  " ((to_date(?,'dd/mm/yyyy') between d.lve_frm_dt and d.lve_to_dt ) " +
" or (to_date(?,'dd/mm/yyyy') between d.lve_frm_dt and d.lve_to_dt)) " +
 "   and m.lve_appln_status not in ('C','J') and m.lveappl_id!=? ";
// Leave View
*/


   public static final String SELECT_COUNT_ALREADYAPPLD="select count(*)  as ALREADYAPPLD  from hrm_emp_leaveappln_dtls d,hrm_emp_leaveappln_mast m " +
    " where d.lveappl_id=m.lveappl_id and m.lveappl_emp_no=? and " +
   " ((d.lve_frm_dt between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy')) " +
  " or (d.lve_to_dt between to_date(?,'dd/mm/yyyy') and to_date(?,'dd/mm/yyyy')) " +
  " or (to_date(?,'dd/mm/yyyy') between d.lve_frm_dt and d.lve_to_dt) "+
  " or (to_date(?,'dd/mm/yyyy') between d.lve_frm_dt and d.lve_to_dt)) "+
  " and m.lve_appln_status not in ('C','J') and m.lveappl_id!=? and d.lve_rev_no="+
  " (select max(lve_rev_no) from hrm_emp_leaveappln_dtls where lveappl_id=d.lveappl_id)";




/*public static final String SELECT_COUNT_EXTENSION="select count(*) as EXTENDAPPLN from hrm_emp_leaveappln_mast t where t.lveappl_emp_no=? and t.lve_to_dt=to_date(?,'dd/mm/yyyy')-1 " +
" and t.lve_appln_status not in ('C','J') and t.lveappl_id!=? " ;
*/
public static final String SELECT_COUNT_EXTENSION="select count(*) as EXTENDAPPLN from hrm_emp_leaveappln_mast t,HRM_EMP_LEAVEAPPLN_DTLS D  where t.lveappl_emp_no=? and (t.lve_to_dt=to_date(?,'dd/mm/yyyy')-1 "+
" or t.suffix_dt1=to_date(?,'dd/mm/yyyy')-1 or t.suffix_dt2=to_date(?,'dd/mm/yyyy')-1 )" +
" and t.lve_appln_status not in ('C','J') and t.lveappl_id!=?  and t.LVEAPPL_ID=D.LVEAPPL_ID "+
" and D.LVEDTL_ID IN (SELECT MAX(D1.LVEDTL_ID) FROM HRM_EMP_LEAVEAPPLN_DTLS D1 "+
" WHERE D1.LVEAPPL_ID=D.LVEAPPL_ID ) and d.no_of_days != 0.50" ;


public static final String SELECT_LEAVE_DETAILS=" SELECT  'LEAVE.'||m.lve_appln_status||m.lve_appr_status||nvl(m.lve_appr_lvl,0) AS CURSTATUS ,      D.LEAVE_CODE AS LEAVE_CODE, " +
" L.LEAVE_SDESC AS LEAVE_SDESC,to_char(M.lveappl_dt,'dd/mm/yyyy') AS lveappl_dt,to_char(D.LVE_FRM_DT,'dd/mm/yyyy')AS LVE_FRM_DT, " +
" to_char(D.LVE_TO_DT,'dd/mm/yyyy') AS LVE_TO_DT,to_char(D.PREFIX_DT1,'dd/mm/yyyy') AS PREFIX_DT1, " +
" to_char(D.SUFFIX_DT1,'dd/mm/yyyy') AS SUFFIX_DT1, to_char(D.PREFIX_DT2,'dd/mm/yyyy') AS PREFIX_DT2, " +
" to_char(D.SUFFIX_DT2,'dd/mm/yyyy') AS SUFFIX_DT2,to_char(D.PREFIX_DT3,'dd/mm/yyyy') AS PREFIX_DT3, " +
" to_char(D.SUFFIX_DT3,'dd/mm/yyyy') AS SUFFIX_DT3, D.NO_OF_DAYS AS NO_OF_DAYS, D.LEAVE_REASON AS LEAVE_REASON, decode(nvl(M.LTC_FLG,'N'),'Y','Yes','No') AS LTC_FLG, " +
" decode(nvl(M.SALADV_REQD_FLG,'N'),'Y','Yes','No') AS SALADV_REQD_FLG,NVL(M.LVEAPPL_LV_ADDRESS,' ') AS LVEAPPL_LV_ADDRESS, " +
" M.LVEAPPL_EMP_NO AS LVEAPPL_EMP_NO,NVL(M.LVEAPPL_DESIG,' ') AS LVEAPPL_DESIG,NVL(M.LVEAPPL_SECT,' ') AS LVEAPPL_SECT, " +
" M.LVE_APPLN_STATUS AS LVE_APPLN_STATUS,M.LVE_APPR_STATUS AS LVE_APPR_STATUS, " +
" NVL(E.EMP_FST_NAME,' ') AS EMP_FST_NAME,NVL(E.EMP_MDL_NAME,' ') AS EMP_MDL_NAME, NVL(E.EMP_LST_NAME,' ') AS EMP_LST_NAME, " +
" NVL(E.EMP_OFFC_PHONE_AUTO ,' ') AS EMP_OFFC_PHONE_AUTO,NVL(D.EXTENDED_FLAG,'N') AS ST_FLG,m.recomndg_autho_name as sanctioned_by,m.recomndg_autho_desg as sanc_desg,to_char(m.recomndg_autho_dt,'DD/MM/YYYY') as sanc_date,m.lve_appr_rem as sanc_remarks,m.estt_autho_name as verify_name,m.estt_autho_desgn as verify_desg,to_char(m.estt_auth_dt,'DD/MM/YYYY') as verify_date " +
" FROM HRM_EMP_LEAVEAPPLN_DTLS D, HRM_EMP_LEAVEAPPLN_MAST M, HRM_LEAVE_MAST L, HRM_EMPLOYEE E " +
" WHERE D.LVEAPPL_ID=? AND D.LVEAPPL_ID=M.LVEAPPL_ID AND D.LEAVE_CODE=L.LEAVE_ID AND M.LVEAPPL_EMP_NO=E.EMP_NO  " +
" and d.LVE_REV_NO = (select max(LVE_REV_NO) from HRM_EMP_LEAVEAPPLN_DTLS WHERE LVEAPPL_ID=?) order by d.lvedtl_id";


public static final String SELECT_COUNT_CHILDREN= " select count(*) as CHILDREN from hrm_emp_dpndt t where t.emp_no=? and t.dpndt_reltn_id in " +
 " (select r.reltn_id from hrm_reltn_mast r where upper(r.reltn_name) in ('SON','DAUGHTER')) and t.dpndt_status != 'D'";

public static final String SELECT_MAX_ACCU_DAYS="select MAX_ACCU_DAYS from hrm_leave_credit WHERE LEAVE_ID=?";


// Leave Encashment View Queries
    /* Added on 14/01/2004 */ /* Added on 14/01/2004 */ public static final String SELECT_EMP_DTLS = "select A.EMP_NO,nvl(A.EMP_FST_NAME,' ') EMP_FST_NAME,nvl(A.EMP_MDL_NAME,' ') EMP_MDL_NAME,nvl(A.EMP_LST_NAME,' ') EMP_LST_NAME,A.EMP_OFFC_PHONE_DEPT,B.DSGN_DESC,C.DRCRT_NAME,D.SECT_NAME,EMP_5TH_PAY_BASIC from HRM_EMPLOYEE A,HRM_DSGN_MAST B,HRM_DRCRT_MAST C,HRM_SECT_MAST D WHERE A.EMP_DSGN_ID = B.DSGN_ID(+) AND A.EMP_SECT_ID = D.SECT_ID(+) and A.EMP_DRCRT_ID = C.DRCRT_ID(+) AND A.EMP_NO =?";
//select 'LVENCASH.'||en.lvencash_status||nvl(en.lvencash_appr_lvl,0) from hrm_leave_encash_appln en
    /* Added on 15/01/2004 */ public static final  String SELECT_LVENCASH_VIEW = "select 'LVENCASH.'||lvencash_status||nvl(lvencash_appr_lvl,0) AS CURSTATUS,LVENCASH_ID, TO_CHAR(LVENCASH_APPLCN_DT,'dd/mm/yyyy') LVENCASH_APPLCN_DT, LVENCASH_EMP_NO, LVENCASH_PROPOS_LV , LVENCASH_APPL_ID from HRM_LEAVE_ENCASH_APPLN where  LVENCASH_ID =?"; 
    /* Added on 15/01/2004 */ public static final String SELECT_DURATION_VIEW = "SELECT LVEAPPL_ID LVEAPPL_ID, to_char(LVE_FRM_DT, 'dd/mm/yyyy') LVE_FRM_DT,to_char(LVE_TO_DT, 'dd/mm/yyyy') LVE_TO_DT,'LEAVE.'||A.LVE_APPLN_STATUS||A.LVE_APPR_STATUS||NVL(A.LVE_APPR_LVL,0) LV_STATUS FROM HRM_EMP_LEAVEAPPLN_MAST A where LVEAPPL_ID =?";
}
        

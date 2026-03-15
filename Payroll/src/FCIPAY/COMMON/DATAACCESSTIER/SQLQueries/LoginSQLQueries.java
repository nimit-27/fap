package FCIPAY.COMMON.DATAACCESSTIER.SQLQueries;

public class LoginSQLQueries 
{
//    public static final String GET_LOC_CODES = "select a.loc_id LocId, a.loc_desc LocDesc from com_loc_mst a, sysadmin_user_loc b where a.loc_id = b.loc_id and b.emp_no =?";
//    public static final String GET_EMP_INFO  = "select emp_stat_flg from sysadmin_user_mst where emp_no = ? and emp_psswd = ?";    

    public static final String GET_LOC_CODE="SELECT LOC.LOC_ID,LOC.LOC_DESC FROM SYSADMIN_USER_LOC T,SYSADMIN_USER_MST USR,COM_LOC_MST LOC"
                                                + " WHERE USR.EMP_NO=? AND USR.EMP_PSSWD=? AND USR.EMP_STAT_FLG='A' "
                                                + " AND T.LOC_STAT_FLG='A' AND T.EMP_NO=USR.EMP_NO AND T.LOC_ID=LOC.LOC_ID "
                                                + " ORDER BY LOC.LOC_DESC";

    public static final String Chk_Employee="select * from sysadmin_user_mst t where t.emp_no=? and t.emp_psswd=?";
    
    public static final String Chk_Employee_LOCKED="select PSSWD_CHANGED from sysadmin_user_mst t where t.emp_no=?";

    
  /*  public static final String GET_EMP_DET   = 
    "select EMP_NO, EMP_FST_NAME, NVL(EMP_MDL_NAME, '??') EMP_MDL_NAME, NVL(EMP_LST_NAME, '??') EMP_LST_NAME, " + 
    "NVL(EMP_OFFC_PHONE_AUTO, ' ') EMP_OFFC_PHONE_AUTO, NVL(EMP_EMAIL, ' ') EMP_EMAIL, " + 
    "NVL(TO_CHAR(EMP_DOB,'DD/MM/YYYY'), ' ') DOB, EMP_SEX, NVL(TO_CHAR(EMP_DOJ_DAE,'DD/MM/YYYY'), ' ') DOJ_DAE, " +
    "NVL(TO_CHAR(EMP_DOJ_GOV,'DD/MM/YYYY'), ' ') DOJ_GOV, NVL(TO_CHAR(EMP_DOJ_NPC,'DD/MM/YYYY'), ' ') DOJ_NPC, " + 
    "NVL(TO_CHAR(EMP_DOJ_SITE,'DD/MM/YYYY'), ' ') DOJ_SITE, NVL(B.EMP_TYPE_DESC, ' ') EMP_TYPE, NVL(C.CATEG_DESC, ' ') CATEG_DESC, " + 
    "NVL(D.CADRE_DESC, ' ') CADRE_DESC, NVL(EMP_UNIT_ID, 0) EMP_UNIT_ID, " + 
    "NVL(E.DRCRT_NAME, ' ') DRCRT_NAME, NVL(EMP_GRP, ' ') EMP_GRP, NVL(F.GRP_NAME, ' ') GRP_NAME, NVL(G.SECT_NAME, ' ') SECT_NAME, " + 
    "NVL(EMP_REP_ID, 0) EMP_REP_ID, NVL(NVL(H.DSGN_DESC,I.GRADE_DESC), ' ') DESG_DESC, " +
    "NVL(I.WORKMEN_FLAG, ' ') WORKMEN_FLAG, NVL(EMP_5TH_PAY_BASIC, 0) EMP_5TH_PAY_BASIC, NVL(EMP_LOC, ' ') EMP_LOC, " + 
    "NVL(EMP_SUB_LOC, ' ') EMP_SUB_LOC, NVL(TO_CHAR(EMP_DOC,'DD/MM/YYYY'), ' ') EMP_DOC, " + 
    "NVL(TO_CHAR(EMP_INCR_DT,'DD/MM/YYYY'), ' ') INCR_DT, NVL(TO_CHAR(EMP_LST_PROM_DT,'DD/MM/YYYY'), ' ') LST_PROM, " + 
    "NVL(TO_CHAR(EMP_CR_PRD_END_DT,'DD/MM/YYYY'), ' ') CR_PRD_END_DT, NVL(EMP_OPT_EXERCISED, ' ') EMP_OPT_EXERCISED, " + 
    "NVL(TO_CHAR(EMP_NORM_RET_DT,'DD/MM/YYYY'), ' ') NORM_RET_DT, " +
    "NVL(A.EMP_LVE_TYPE, ' ') LEAVE_TYPE, UPPER(J.CODE_DESC) CODE_DESC ,UPPER(M.LOC_DESC) LOC_DESC, NVL(A.EMP_SPLZN,' ') EMP_SPLZN " +
    "FROM HRM_EMPLOYEE A,HRM_EMP_TYPE_MAST B,HRM_CATEG_MAST C, " + 
    "HRM_CADRE_MAST D,HRM_DRCRT_MAST E,HRM_GRP_MAST F, HRM_SECT_MAST G,HRM_DSGN_MAST H,HRM_GRADE_MAST I,COM_GBL_DTL J,COM_LOC_MST M WHERE A.EMP_NO=? " + 
    "AND A.EMP_TYPE_ID = B.EMP_TYPE_ID(+) AND A.EMP_CATEG_ID = C.CATEG_ID(+) AND A.EMP_CADRE_ID = D.CADRE_ID(+)" + 
    "AND A.EMP_DRCRT_ID = E.DRCRT_ID(+) AND A.EMP_GRP_ID = F.GRP_ID(+) AND A.EMP_SECT_ID = G.SECT_ID(+)" +
    "AND A.EMP_DSGN_ID = H.DSGN_ID(+) AND A.EMP_GRADE_ID = I.GRADE_ID(+) AND A.EMP_MARITAL_STATUS = J.GBL_CODE(+) AND A.EMP_UNIT_ID=M.LOC_ID (+)";
*/
    public static final String GET_SECTION_HEAD_DETAILS="SELECT  NVL(S.SECT_HEAD,0) AS SHEAD,NVL(NVL(H.DSGN_DESC,I.GRADE_DESC), ' ') DESG_DESC,NVL(E1.EMP_CHQ_NAME,' ') SENAME FROM HRM_SECT_MAST S ,HRM_EMPLOYEE E,HRM_EMPLOYEE E1,HRM_DSGN_MAST H,HRM_GRADE_MAST I WHERE E.EMP_NO=? AND E.EMP_SECT_ID=S.SECT_ID(+) AND E1.EMP_DSGN_ID = H.DSGN_ID(+) AND E1.EMP_GRADE_ID = I.GRADE_ID(+) AND E1.EMP_NO(+)=S.SECT_HEAD";
    public static final String GET_USR_DET   = 
    "select EMP_NO, EMP_FST_NAME, NVL(EMP_MDL_NAME, '??') EMP_MDL_NAME, NVL(EMP_LST_NAME, '??') EMP_LST_NAME, " + 
    " NVL(EMP_LOC, ' ') EMP_LOC, UPPER(M.LOC_DESC) LOC_DESC " +
    "FROM HRM_EMPLOYEE A, " + 
    "COM_LOC_MST M WHERE A.EMP_NO=? " + 
    " AND A.EMP_UNIT_ID=M.LOC_ID (+)";

    public static final String GET_EMP_DET   = "SELECT SYS.EMP_NO EMP_NO,LOC.LOC_ID,MST.LOC_DESC,MST.LOC_TYPE_GBL, NVL(EMP_FIRST_NAME, '') || ' ' || NVL(EMP_MIDDLE_NAME, '') || ' ' || NVL(EMP_LAST_NAME, '') AS EMP_NAME , round(sysdate-sys.modified_dt) sts FROM SYSADMIN_USER_MST SYS, PAY_EMP_MAST EMP,SYSADMIN_USER_LOC LOC,COM_LOC_MST MST WHERE SYS.EMP_NO = EMP.EMP_NUM(+) AND LOC.EMP_NO=SYS.EMP_NO AND LOC.LOC_ID=MST.LOC_ID AND SYS.EMP_NO=? AND LOC.LOC_ID=? ORDER BY EMP_NO";
     
    public static final String UPDATE_LOGIN_SUCESS   = "UPDATE SYSADMIN_USER_MST SET PSSWD_CHANGED='0' where EMP_NO=?";

    public static final String UPDATE_LOGIN_UNSUCESS   = "UPDATE SYSADMIN_USER_MST SET PSSWD_CHANGED=to_number(PSSWD_CHANGED+1) where EMP_NO=?";
    public static final String MAX_LOGIN_ATTEMPT   = "SELECT pkg_pay_fixed_misc_param.Get_Allow_Value('MAX_LOGIN_ATTEMPT',null) AS CNT from dual";

}


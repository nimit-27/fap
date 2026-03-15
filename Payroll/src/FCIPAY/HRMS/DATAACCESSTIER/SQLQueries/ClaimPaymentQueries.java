package FCIPAY.HRMS.DATAACCESSTIER.SQLQueries;

public class ClaimPaymentQueries 
{
    public static final String GET_EMP_NOS = "SELECT * FROM ( "+
                                            "SELECT distinct(A.EMP_NO) "+
                                            "FROM FIN_PAYROLL_INTERFACE A, FIN_VOUCHER_HDR B "+
                                            "WHERE A.RECORD_TYPE = 'P' AND A.REC_MODE_GBL = 'SETLMODE$VOUCHER' AND "+
                                            "A.REC_STATE_GBL = 'PAYROLL$PENDING' AND "+
                                            "B.TXN_STATUS_GBL in ('VHSTAT$6','VHSTAT$5') AND A.MODULE_ID = ? AND A.LOC_ID = ? AND "+
                                            "A.VOUCHER_ID = B.VOUCHER_ID and a.pmt_voucher_id is null "+
                                            "UNION "+
                                            "SELECT distinct(A.EMP_NO) "+
                                            "FROM FIN_PAYROLL_INTERFACE A, FIN_VOUCHER_HDR B,FIN_VOUCHER_HDR C "+
                                            "WHERE A.RECORD_TYPE = 'P' AND A.REC_MODE_GBL = 'SETLMODE$VOUCHER' AND "+
                                            "A.REC_STATE_GBL = 'PAYROLL$PROCESSED' AND "+
                                            "B.TXN_STATUS_GBL in ('VHSTAT$6','VHSTAT$5') AND A.MODULE_ID = ? AND A.LOC_ID = ? AND "+
                                            "A.VOUCHER_ID = B.VOUCHER_ID AND A.PMT_VOUCHER_ID=C.VOUCHER_ID "+
                                            "AND C.TXN_STATUS_GBL='VHSTAT$7' "+
                                            ") ORDER BY 1 ";
    public static final String GET_EMP_DTLS = "SELECT A.EMP_FST_NAME||' '||A.EMP_MDL_NAME||' '||A.EMP_LST_NAME AS EMP_NAME FROM HRM_EMPLOYEE A WHERE A.EMP_NO = ?";
    public static final String GET_VOUCH_DTLS = "SELECT A.RECORD_ID,A.RECORD_SOURCE,A.ACCT_ID,A.TXN_AMT FROM FIN_PAYROLL_INTERFACE A, FIN_VOUCHER_HDR B WHERE A.EMP_NO = ? AND A.LOC_ID = ? AND A.MODULE_ID = ? AND A.RECORD_TYPE = 'P' AND A.REC_MODE_GBL = 'SETLMODE$VOUCHER' AND A.REC_STATE_GBL = 'PAYROLL$PENDING' AND B.TXN_STATUS_GBL = 'VHSTAT$6' AND A.VOUCHER_ID = B.VOUCHER_ID "+
                                             "UNION "+
                                               "SELECT  A.RECORD_ID,A.RECORD_SOURCE,A.ACCT_ID,A.TXN_AMT "+
                                            "FROM FIN_PAYROLL_INTERFACE A, FIN_VOUCHER_HDR B,FIN_VOUCHER_HDR C "+
                                            "WHERE A.EMP_NO = ? and  A.RECORD_TYPE = 'P' AND A.REC_MODE_GBL = 'SETLMODE$VOUCHER' AND "+
                                            "A.REC_STATE_GBL = 'PAYROLL$PROCESSED' AND "+
                                            "B.TXN_STATUS_GBL in ('VHSTAT$6','VHSTAT$5') AND A.MODULE_ID = ? AND A.LOC_ID = ? AND "+
                                            "A.VOUCHER_ID = B.VOUCHER_ID AND A.PMT_VOUCHER_ID=C.VOUCHER_ID "+
                                            "AND C.TXN_STATUS_GBL='VHSTAT$7' ";
                                             
    public static final String UPDATE_PAYROLL_INTERFACE = "UPDATE FIN_PAYROLL_INTERFACE A SET A.PMT_VOUCHER_ID = ?,A.REC_STATE_GBL = 'PAYROLL$PROCESSED',MODIFIED_USER = ?,MODIFIED_SITE=?,MODIFIED_DT = SYSDATE WHERE A.RECORD_ID = ? ";
    public static final String GET_VOUCHER_NO= "SELECT (B.LOC_ID||substr(from_dt,8,2)||TRIM(A.CODE_SDESC)||B.PARAM_VOUCHER_NO) AS VOUCHER_NO, B.PARAM_VOUCHER_NO FROM  COM_GBL_DTL A,FIN_VOUCHER_PARAMS_VHNO B,FIN_CLNDR_MST C "+
                                            "WHERE A.GBL_CODE = ? AND B.PARAM_TYPE_GBL = ? AND B.LOC_ID = ? AND C.LOC_ID=B.LOC_ID AND clndr_status_gbl='CALSTATUS$OPEN' and clndr_open_ind_gbl='CALSTATE$CUR'";
    public static final String INSERT_INTO_VOUCHHDR = "INSERT INTO FIN_VOUCHER_HDR (VOUCHER_ID,LOC_ID,VOUCHER_NO,PRD_ID,VOUCHER_DT,TXN_STATUS_GBL,VOUCHER_TYPE_GBL,MODULE_ID,DOC_REF,DOC_REM,CREATED_USER,CREATED_SITE,CREATED_DT,VH_FOR_GBL,AUTH_ID,AUTH_DT) VALUES(get_id(?,'FIN_VOUCHER_HDR'),?,?,?,TO_DATE(?,'DD/MM/YYYY'),'VHSTAT$2',?,?,?,?,?,?,SYSDATE,?,?,SYSDATE)";
    public static final String INSERT_INTO_VOUCHDTL = "INSERT INTO FIN_VOUCHER_DTL (VOUCHER_DTL_ID,VOUCHER_TXN_NO,DTL_NRTN,EMP_NO,CH_ID,CCSGRP_ID,TXN_AMT,DB_CR_FLG,VOUCHER_ID,ACCT_ID,CREATED_USER,CREATED_SITE,CREATED_DT) VALUES (get_id(?,'FIN_VOUCHER_DTL'),?,?,?,?,(SELECT CCSGRP_ID FROM COM_CCSGRP_MST WHERE CCSGRP_CODE = ?),?,?,?,?,?,?,SYSDATE)";
    public static final String UPDATE_VOUCHERPARAMNO = "UPDATE FIN_VOUCHER_PARAMS_VHNO SET PARAM_VOUCHER_NO = ?,MODIFIED_USER =?,MODIFIED_SITE=?,MODIFIED_DT =SYSDATE WHERE LOC_ID =? AND PARAM_TYPE_GBL = ? AND PARAM_VOUCHER_NO = ?";
    public static final String GET_VOUCH_ID = "SELECT VOUCHER_ID FROM FIN_VOUCHER_HDR WHERE VOUCHER_NO = ?";
    public static final String GET_CURR_PRD_BPVCPV = "SELECT A.PRD_ID,A.PRD_DESC,TO_CHAR(SYSDATE,'DD/MM/YYYY') AS CURR_DATE FROM FIN_CLNDR_PRD A, FIN_CLNDR_MST B WHERE B.LOC_ID = ? AND B.CLNDR_STATUS_GBL = 'CALSTATUS$OPEN' AND CLNDR_OPEN_IND_GBL = 'CALSTATE$CUR' AND A.PRD_STATUS = 'A' AND (TRUNC(A.START_DT) <= TRUNC(SYSDATE)) AND A.CLNDR_ID = B.CLNDR_ID ORDER BY A.PRD_ID DESC";
}
/*
    * Module:        TEVBPVQueries.java
    * Author:        Kamlesh Mandhani
    * Date Written:  May 2004
    * Description:   SQL Query Class for TEV Screen
    * Revision Log   (mm/dd/yy initials description)
    * --------------------------------------------------------
    * mm/dd/yy xxx  What you changed 
*/

package FCIPAY.HRMS.DATAACCESSTIER.SQLQueries;

public class TEVBPVQueries 
{
//    public static final String GET_CLM_IDS = "SELECT A.CLM_ID, A.CLM_NO FROM FIN_TR_CLM_HDR A, FIN_VOUCHER_HDR B WHERE A.CLM_STATUS_GBL = 'FTRSTATUS$6' AND A.CLM_STATE_GBL = 'FTRSTATE$5' AND A.LOC_ID = ? AND ((A.JV_VOUCHER_ID = B.VOUCHER_ID AND B.TXN_STATUS_GBL = 'VHSTAT$7') OR A.JV_VOUCHER_ID IS NULL) ORDER BY A.CLM_NO";
    public static final String GET_CLM_IDS = "SELECT A.CLM_ID,A.CLM_NO FROM FIN_TR_CLM_HDR A WHERE A.CLM_STATUS_GBL = 'FTRSTATUS$6' AND A.CLM_STATE_GBL = 'FTRSTATE$4' AND A.LOC_ID = ? AND CLM_FOR != 'T'  AND ((A.JV_VOUCHER_ID IS NULL) OR (A.JV_VOUCHER_ID IN (SELECT VOUCHER_ID FROM FIN_VOUCHER_HDR B WHERE B.TXN_STATUS_GBL = 'VHSTAT$7' ))) ORDER BY A.CREATED_DT, A.CLM_NO";

    //ADDED BY BHAVNA 04/05/2005
    public static final String GET_CLM_DTLS = "SELECT A.REC_MODE_GBL,D.CODE_DESC,A.TR_ID,B.TR_DESC, A.EMP_NO, C.EMP_FST_NAME || ' ' || C.EMP_MDL_NAME  || ' ' || "+
                                                "C.EMP_LST_NAME AS EMP_NAME FROM FIN_TR_CLM_HDR A, FIN_TR_TYPE B, "+
                                                "HRM_EMPLOYEE C,COM_GBL_DTL D WHERE A.CLM_ID = ? AND A.TR_ID = B.TR_ID AND A.EMP_NO = C.EMP_NO  "+
                                                "AND A.REC_MODE_GBL=D.GBL_CODE";
    //ADDED BY BHAVNA 04/05/2005
    public static final String GET_TR_TYPE_GBL = "SELECT TR_TYPE_GBL FROM FIN_TR_TYPE WHERE TR_ID = ?";
//    public static final String GET_CURR_PRD = "SELECT A.PRD_ID,A.PRD_DESC,TO_CHAR(SYSDATE,'DD/MM/YYYY') AS CURR_DATE FROM FIN_CLNDR_PRD A, FIN_CLNDR_MST B WHERE B.LOC_ID = ? AND B.CLNDR_STATUS_GBL = 'CALSTATUS$OPEN' AND B.CLNDR_OPEN_IND_GBL = 'CALSTATE$CUR' AND A.PRD_STATUS = 'A' AND (TRUNC(A.START_DT) <= TRUNC(SYSDATE)) AND A.CLNDR_ID = B.CLNDR_ID";
    public static final String GET_CURR_PRD = "SELECT A.PRD_ID,A.PRD_DESC,TO_CHAR(SYSDATE,'DD/MM/YYYY') AS CURR_DATE FROM FIN_CLNDR_PRD A, FIN_CLNDR_MST B WHERE B.LOC_ID = ? AND B.CLNDR_STATUS_GBL = 'CALSTATUS$OPEN' AND A.PRD_STATUS = 'A' AND (TRUNC(A.START_DT) <= TRUNC(SYSDATE)) AND A.CLNDR_ID = B.CLNDR_ID ORDER BY A.PRD_ID DESC";
    public static final String GET_CURR_PRD_BPVCPV = "SELECT A.PRD_ID,A.PRD_DESC,TO_CHAR(SYSDATE,'DD/MM/YYYY') AS CURR_DATE FROM FIN_CLNDR_PRD A, FIN_CLNDR_MST B WHERE B.LOC_ID = ? AND B.CLNDR_STATUS_GBL = 'CALSTATUS$OPEN' AND CLNDR_OPEN_IND_GBL = 'CALSTATE$CUR' AND A.PRD_STATUS = 'A' AND (TRUNC(A.START_DT) <= TRUNC(SYSDATE)) AND A.CLNDR_ID = B.CLNDR_ID ORDER BY A.PRD_ID DESC";
    public static final String GET_LOC_DESC = "SELECT LOC_DESC FROM COM_LOC_MST WHERE LOC_ID =?";
//    public static final String GET_SUM_ADVS = "SELECT SUM(SANC_AMT) AS TOT_ADV FROM FIN_TR_ADV_HDR WHERE ADV_ID IN (SELECT ADV_ID FROM FIN_TR_CLM_ADVSETL WHERE CLM_ID = ?)";
    public static final String GET_SUM_ADVS = "SELECT SUM(A.SANC_AMT) AS TOT_ADV FROM FIN_TR_ADV_HDR A,FIN_TR_CLM_ADVSETL B "+
                                              "WHERE B.CLM_ID = ? AND A.ADV_ID = B.ADV_ID ";
//    public static final String GET_SUM_RECEIPT_AMT = "SELECT SUM(RECEIPT_AMT) AS TOT_REFUNDS FROM FIN_TR_RECEIPT WHERE RECEIPT_NO IN(SELECT RECEIPT_NO FROM FIN_TR_CLM_RCPTDTL WHERE CLM_ID = ?) AND TXN_STATE = 'A'";
    public static final String GET_SUM_RECEIPT_AMT = "SELECT SUM(A.RECEIPT_AMT) AS TOT_REFUNDS FROM FIN_TR_RECEIPT A, FIN_TR_CLM_RCPTDTL B "+
                                                     "WHERE B.CLM_ID= ? AND A.TXN_STATE = 'A' AND A.RECEIPT_NO = B.RECEIPT_NO ";
    public static final String GET_SUM_PENALTY = "SELECT SUM(PENALTY_AMT) AS PENALTY_AMT FROM FIN_TR_CLM_PENALTY WHERE CLM_ID = ? AND PENALTY_FLG = 'Y' ";
    public static final String GET_CLM_SANCT_AMT = "SELECT CLM_SANC_AMT FROM FIN_TR_CLM_HDR WHERE CLM_ID =?";
    public static final String GET_CLM_PENALTY_ACCT = "SELECT PENALTY_ACCT_ID FROM FIN_TR_TYPE WHERE TR_ID = ?  ";
    public static final String GET_ADV_ACCT_ID = "SELECT ADV_ACCT_ID FROM FIN_TR_TYPE WHERE TR_SDESC_GBL = 'TRREQTYPE$A' AND TR_TYPE_GBL = (SELECT TR_TYPE_GBL FROM FIN_TR_TYPE WHERE TR_ID = ?)";
    public static final String GET_ACCT_DTL = "SELECT ACCT_STATUS,CTRL_ACCT,CHG_FLG,CC_FLG FROM FIN_ACCT_MST WHERE ACCT_ID = ?";
    public static final String GET_EMP_CH_CC_CODE = "SELECT C.CHG_CODE,B.CCSGRP_CODE FROM HRM_EMPLOYEE A,COM_CCSGRP_MST B, COM_CHG_MST C WHERE EMP_NO = ? AND A.EMP_CC_CODE = B.CCSGRP_ID AND C.CHG_ID= A.EMP_CH_CODE";
//    public static final String INSERT_INTO_VOUCH_DTL = "INSERT INTO FIN_VOUCHER_DTL (VOUCHER_TXN_NO,DTL_NRTN,ACCT_ID,CH_ID,CCSGRP_ID,LINK_REF,EMP_NO,TXN_AMT,DB_CR_FLG,CREATED_USER,CREATER_SITE,CREATED_DT) VALUES(?,?,?,?,?,?,?,?,?,?,?,SYSDATE)";
    public static final String GET_CLM_SANC_AMTS = "SELECT I.EXP_ACCT_ID,SUM(G.SANC_AMT)AS SANC_AMT FROM"+
                                                   " (SELECT A.HD_ID,SUM(A.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_CLASS A WHERE A.CLM_ID =? GROUP BY A.HD_ID UNION"+
                                                   " SELECT B.HD_ID,SUM(B.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_RATE B WHERE B.CLM_ID = ? GROUP BY B.HD_ID UNION"+
                                                   " SELECT C.HD_ID,SUM(C.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_PRD C WHERE C.CLM_ID =?  GROUP BY C.HD_ID UNION"+
                                                   " SELECT D.HD_ID,SUM(D.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_PCT D WHERE D.CLM_ID =? GROUP BY D.HD_ID UNION"+
                                                   " SELECT E.HD_ID,SUM(E.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_LS E WHERE E.CLM_ID =? GROUP BY E.HD_ID UNION"+
                                                   " SELECT F.HD_ID,SUM(F.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_DA F WHERE F.CLM_ID = ? GROUP BY F.HD_ID) G,"+
                                                   " (SELECT H.HD_ID,H.EXP_ACCT_ID FROM FIN_TR_HDS H) I"+
                                                   " WHERE G.HD_ID = I.HD_ID GROUP BY I.EXP_ACCT_ID ";
    public static final String GET_TR_ACCT_ID = " FROM FIN_TR_TYPE WHERE TR_ID = ?";
    public static final String GET_VOUCHER_NO= "SELECT (B.LOC_ID||substr(from_dt,8,2)||TRIM(A.CODE_SDESC)||B.PARAM_VOUCHER_NO) AS VOUCHER_NO, B.PARAM_VOUCHER_NO FROM  COM_GBL_DTL A,FIN_VOUCHER_PARAMS_VHNO B,FIN_CLNDR_MST C "+
                                            "WHERE A.GBL_CODE = ? AND B.PARAM_TYPE_GBL = ? AND B.LOC_ID = ? AND C.LOC_ID=B.LOC_ID AND clndr_status_gbl='CALSTATUS$OPEN' and clndr_open_ind_gbl='CALSTATE$CUR'";
//    public static final String GET_VOUCH_PARAMNO = "SELECT (PARAM_VOUCHER_NO+1) AS PARAM_VOUCHER_NO FROM FIN_VOUCHER_PARAMS_VHNO WHERE PARAM_TYPE_GBL = 'VOUCHTYPE$TEV'"
//    public static final String GET_VOUCHTYPE_SDESC = "SELECT TRIM(CODE_SDESC) FROM COM_GBL_DTL WHERE GBL_CODE = 'VOUCHTYPE$TEV'"
    public static final String INSERT_INTO_VOUCHHDR = "INSERT INTO FIN_VOUCHER_HDR (VOUCHER_ID,LOC_ID,VOUCHER_NO,PRD_ID,VOUCHER_DT,TXN_STATUS_GBL,VOUCHER_TYPE_GBL,MODULE_ID,DOC_REF,DOC_REM,CREATED_USER,CREATED_SITE,CREATED_DT,AUTH_ID,AUTH_DESG,AUTH_DT,AUTH_CMNT) VALUES(get_id(?,'FIN_VOUCHER_HDR'),?,?,?,TO_DATE(?,'DD/MM/YYYY'),'VHSTAT$5',?,4,?,?,?,?,SYSDATE,?,?,SYSDATE,'AUTO')";
    public static final String INSERT_INTO_VOUCHDTL = "INSERT INTO FIN_VOUCHER_DTL (VOUCHER_DTL_ID,VOUCHER_TXN_NO,DTL_NRTN,EMP_NO,CH_ID,CCSGRP_ID,LINK_REF,TXN_AMT,DB_CR_FLG,VOUCHER_ID,ACCT_ID,CREATED_USER,CREATED_SITE,CREATED_DT) VALUES (get_id(?,'FIN_VOUCHER_DTL'),?,?,?,?,(SELECT CCSGRP_ID FROM COM_CCSGRP_MST WHERE CCSGRP_CODE = ?),?,?,?,?,?,?,?,SYSDATE)";
    public static final String INSERT_INTO_PAYROLLINTERFACE = "INSERT INTO FIN_PAYROLL_INTERFACE (RECORD_ID,VOUCHER_ID,RECORD_SOURCE,MODULE_ID,RECORD_TYPE,EMP_NO,TXN_AMT,ACCT_ID,DB_CR_FLG,REC_STATE_GBL,REC_MODE_GBL,CREATED_USER,CREATED_SITE,CREATED_DT,LOC_ID) VALUES(get_id(?,'FIN_PAYROLL_INTERFACE'),?,'Travel Claim - TEV',4,?,?,?,?,?,'PAYROLL$PENDING',?,?,?,SYSDATE,?)";
    public static final String UPDATE_VOUCHERPARAMNO = "UPDATE FIN_VOUCHER_PARAMS_VHNO SET PARAM_VOUCHER_NO = ?,MODIFIED_USER = ?,MODIFIED_SITE = ?,MODIFIED_DT = SYSDATE WHERE LOC_ID =? AND PARAM_TYPE_GBL = ? AND PARAM_VOUCHER_NO = ?";
    public static final String GET_VOUCH_ID = "SELECT VOUCHER_ID FROM FIN_VOUCHER_HDR WHERE VOUCHER_NO = ?";
    public static final String CHK_DATE = "SELECT 'Y' FROM FIN_CLNDR_PRD WHERE PRD_ID = ?  and TO_DATE(?, 'dd/mm/yyyy') BETWEEN START_DT AND END_DT";
    public static final String IS_CLNDR_PAST = "SELECT 'Y' FROM FIN_CLNDR_MST WHERE CLNDR_ID  = (SELECT CLNDR_ID FROM FIN_CLNDR_PRD WHERE PRD_ID = ?) AND CLNDR_OPEN_IND_GBL = 'CALSTATE$PAS'";
    public static final String VALIDATE_DATE_OF_PAST_PRD = "SELECT 1 ERROR FROM FIN_CLNDR_PRD WHERE PRD_ID = ? AND TRUNC(END_DT) != TO_DATE(?,'DD/MM/YYYY')";
    public static final String VALIDATE_VH_DATE = "SELECT 'Y' RESULT FROM DUAL WHERE TO_DATE(?,'DD/MM/YYYY') > = (SELECT NVL(TRUNC(MAX(POSTING_DT)),TO_DATE('01/01/0001','DD/MM/YYYY')) FROM FIN_VOUCHER_HDR WHERE LOC_ID = ? AND TXN_STATUS_GBL = 'VHSTAT$6')";
    public static final String UPDATE_CLMHDR = "UPDATE FIN_TR_CLM_HDR SET JV_VOUCHER_ID = ?,MODIFIED_USER = ?,MODIFIED_SITE = ?,MODIFIED_DT = SYSDATE,REC_MODE_GBL =? WHERE CLM_ID = ? AND CLM_STATUS_GBL = 'FTRSTATUS$6' AND CLM_STATE_GBL = 'FTRSTATE$4' AND ((JV_VOUCHER_ID IS NULL) OR (JV_VOUCHER_ID IN (SELECT VOUCHER_ID FROM FIN_VOUCHER_HDR WHERE TXN_STATUS_GBL = 'VHSTAT$7' )))";
    public static final String UPDATE_CLMHDR_ONSENDBACK = "UPDATE FIN_TR_CLM_HDR SET CLM_STATE_GBL = 'FTRSTATE$3',MODIFIED_USER = ?,MODIFIED_SITE = ?,MODIFIED_DT = SYSDATE WHERE CLM_ID = ? AND CLM_STATE_GBL = 'FTRSTATE$4' AND ((JV_VOUCHER_ID IS NULL) OR (JV_VOUCHER_ID IN (SELECT VOUCHER_ID FROM FIN_VOUCHER_HDR WHERE TXN_STATUS_GBL = 'VHSTAT$7' )))";
    public static final String INSERT_SENDBACK_CMNTS = "INSERT INTO FIN_TR_CLM_REJ_DTL (REJ_ID,CLM_ID,REJ_USER,REJ_CMNT,REJ_DT) VALUES(get_id(?,'FIN_TR_CLM_REJ_DTL'),?,?,?,SYSDATE)";      

    //QUERIES FOR FOREIGN TRAVEL REQUEST
    
//    public static final String GET_SUM_FRLOC_RECEIPT_AMT = "SELECT SUM(RECEIPT_AMT) AS TOT_REFUNDS FROM FIN_TR_RECEIPT WHERE RECEIPT_NO IN(SELECT RECEIPT_NO FROM FIN_TR_CLM_RCPTDTL WHERE CLM_ID = ?) AND TXN_STATE = 'A' AND CURR_ID IS NULL AND CONVR_RATE IS NULL AND FC_AMOUNT IS NULL";
    public static final String GET_SUM_FRLOC_RECEIPT_AMT = "SELECT SUM(A.RECEIPT_AMT) AS TOT_REFUNDS FROM FIN_TR_RECEIPT A, FIN_TR_CLM_RCPTDTL B "+
                                                            "WHERE B.CLM_ID= ? AND A.TXN_STATE = 'A' AND A.RECEIPT_NO = B.RECEIPT_NO AND A.CURR_ID IS NULL ";
    public static final String GET_SUM_FRCURR_RECEIPT_AMT = "SELECT SUM(A.RECEIPT_AMT) AS FR_REFUNDS FROM FIN_TR_RECEIPT A, FIN_TR_CLM_RCPTDTL B "+
                                                            "WHERE B.CLM_ID= ? AND A.TXN_STATE = 'A' AND A.RECEIPT_NO = B.RECEIPT_NO AND A.CURR_ID IS NOT NULL ";                                                    


    public static final String GET_SUM_FRLOC_CLMSANCT = "SELECT O.EXP_ACCT_ID,SUM(M.SANC_AMT)AS SANC_AMT FROM "+
                                                    "(SELECT A.HD_ID,SUM(A.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_CLASS A,FIN_TR_HDS B "+
                                                    "WHERE A.CLM_ID =? AND A.HD_ID= B.HD_ID AND B.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') GROUP BY A.HD_ID UNION "+
                                                    "SELECT C.HD_ID,SUM(C.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_RATE C,FIN_TR_HDS D "+
                                                    "WHERE C.CLM_ID =? AND C.HD_ID= D.HD_ID AND D.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') GROUP BY C.HD_ID UNION "+
                                                    "SELECT E.HD_ID,SUM(E.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_PRD E,FIN_TR_HDS F "+
                                                    "WHERE E.CLM_ID =? AND E.HD_ID= F.HD_ID AND F.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') GROUP BY E.HD_ID UNION "+
                                                    "SELECT G.HD_ID,SUM(G.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_PCT G,FIN_TR_HDS H "+
                                                    "WHERE G.CLM_ID =? AND G.HD_ID= H.HD_ID AND H.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') GROUP BY G.HD_ID UNION "+
                                                    "SELECT I.HD_ID,SUM(I.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_LS I,FIN_TR_HDS J "+
                                                    "WHERE I.CLM_ID =? AND I.HD_ID= J. HD_ID AND J.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') GROUP BY I.HD_ID UNION "+
                                                    "SELECT K.HD_ID,SUM(K.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_DA K,FIN_TR_HDS L "+
                                                    "WHERE K.CLM_ID =? AND K.HD_ID= L.HD_ID AND L.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') GROUP BY K.HD_ID ) M, FIN_TR_HDS O "+
                                                    "WHERE M.HD_ID = O.HD_ID GROUP BY O.EXP_ACCT_ID ";     
                                                    
/*    public static final String GET_SUM_FRLOC_CLMSANCT = "SELECT O.EXP_ACCT_ID,SUM(M.SANC_AMT)AS SANC_AMT FROM "+
                                                        "(SELECT A.HD_ID,A.SANC_AMT FROM FIN_TR_CLM_CLASS A,FIN_TR_HDS B "+
                                                        "WHERE A.CLM_ID =? AND A.HD_ID= B.HD_ID AND B.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') UNION "+
                                                        "SELECT C.HD_ID,C.SANC_AMT FROM FIN_TR_CLM_RATE C,FIN_TR_HDS D "+
                                                        "WHERE C.CLM_ID =? AND C.HD_ID= D.HD_ID AND D.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') UNION "+
                                                        "SELECT E.HD_ID,E.SANC_AMT FROM FIN_TR_CLM_PRD E,FIN_TR_HDS F "+
                                                        "WHERE E.CLM_ID =? AND E.HD_ID= F.HD_ID AND F.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') UNION "+
                                                        "SELECT G.HD_ID,G.SANC_AMT FROM FIN_TR_CLM_PCT G,FIN_TR_HDS H "+
                                                        "WHERE G.CLM_ID =? AND G.HD_ID= H.HD_ID AND H.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') UNION "+      
                                                        "SELECT I.HD_ID,I.SANC_AMT FROM FIN_TR_CLM_LS I,FIN_TR_HDS J "+
                                                        "WHERE I.CLM_ID =? AND I.HD_ID= J.HD_ID AND J.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') UNION "+
                                                        "SELECT K.HD_ID,K.SANC_AMT FROM FIN_TR_CLM_DA K,FIN_TR_HDS L "+
                                                        "WHERE K.CLM_ID =? AND K.HD_ID= L.HD_ID AND L.HD_CLASS_GBL IN ('TRCLASS$DA','TRCLASS$DL','TRCLASS$DT') ) M, "+
                                                        "FIN_TR_HDS O "+
                                                        "WHERE M.HD_ID = O.HD_ID GROUP BY O.EXP_ACCT_ID ";*/

    public static final String GET_SUM_FR_CLMSANCT = "SELECT N.EXP_ACCT_ID,SUM(M.SANC_AMT)AS SANC_AMT FROM "+
                                                     "(SELECT A.HD_ID,SUM(A.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_CLASS A,FIN_TR_HDS B WHERE "+
                                                     "A.CLM_ID = ? AND B.HD_ID = A.HD_ID  AND B.HD_CLASS_GBL IN ('TRCLASS$FL','TRCLASS$FT','TRCLASS$FA') GROUP BY A.HD_ID "+
                                                     "UNION "+
                                                     "SELECT C.HD_ID,SUM(C.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_RATE C,FIN_TR_HDS D WHERE "+
                                                     "C.CLM_ID = ? AND D.HD_ID = C.HD_ID  AND D.HD_CLASS_GBL IN ('TRCLASS$FL','TRCLASS$FT','TRCLASS$FA') GROUP BY C.HD_ID "+
                                                     "UNION "+
                                                     "SELECT E.HD_ID,SUM(E.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_RATE E,FIN_TR_HDS F WHERE "+
                                                     "E.CLM_ID = ? AND F.HD_ID = E.HD_ID  AND F.HD_CLASS_GBL IN ('TRCLASS$FL','TRCLASS$FT','TRCLASS$FA') GROUP BY E.HD_ID "+
                                                     "UNION "+
                                                     "SELECT G.HD_ID,SUM(G.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_PCT G,FIN_TR_HDS H WHERE "+
                                                     "G.CLM_ID = ? AND H.HD_ID = G.HD_ID  AND H.HD_CLASS_GBL IN ('TRCLASS$FL','TRCLASS$FT','TRCLASS$FA') GROUP BY G.HD_ID "+
                                                     "UNION "+                                       
                                                     "SELECT I.HD_ID,SUM(I.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_PCT I,FIN_TR_HDS J WHERE "+
                                                     "I.CLM_ID = ? AND J.HD_ID = I.HD_ID  AND J.HD_CLASS_GBL IN ('TRCLASS$FL','TRCLASS$FT','TRCLASS$FA') GROUP BY I.HD_ID "+
                                                     "UNION "+
                                                     "SELECT K.HD_ID,SUM(K.SANC_AMT) AS SANC_AMT FROM FIN_TR_CLM_LS K,FIN_TR_HDS L WHERE "+
                                                     "K.CLM_ID = ? AND L.HD_ID = K.HD_ID  AND L.HD_CLASS_GBL IN ('TRCLASS$FL','TRCLASS$FT','TRCLASS$FA') GROUP BY K.HD_ID) M, "+
                                                     "FIN_TR_HDS N WHERE "+
                                                     "N.HD_ID = M.HD_ID GROUP BY N.EXP_ACCT_ID ";
                                                        

/*    public static final String GET_SUM_FR_CLMSANCT = "SELECT O.EXP_ACCT_ID,SUM(M.SANC_AMT)AS SANC_AMT FROM "+
                                                     "(SELECT A.HD_ID,A.SANC_AMT FROM FIN_TR_CLM_CLASS A,FIN_TR_HDS B "+
                                                     "WHERE A.CLM_ID =? AND A.HD_ID= B.HD_ID AND B.HD_CLASS_GBL IN ('TRCLASS$FA','TRCLASS$FL','TRCLASS$FT') UNION "+
                                                     "SELECT C.HD_ID,C.SANC_AMT FROM FIN_TR_CLM_RATE C,FIN_TR_HDS D "+
                                                     "WHERE C.CLM_ID =? AND C.HD_ID= D.HD_ID AND D.HD_CLASS_GBL IN ('TRCLASS$FA','TRCLASS$FL','TRCLASS$FT') UNION "+
                                                     "SELECT E.HD_ID,E.SANC_AMT FROM FIN_TR_CLM_PRD E,FIN_TR_HDS F "+
                                                     "WHERE E.CLM_ID =? AND E.HD_ID= F.HD_ID AND F.HD_CLASS_GBL IN ('TRCLASS$FA','TRCLASS$FL','TRCLASS$FT') UNION "+
                                                     "SELECT G.HD_ID,G.SANC_AMT FROM FIN_TR_CLM_PCT G,FIN_TR_HDS H "+
                                                     "WHERE G.CLM_ID =? AND G.HD_ID= H.HD_ID AND H.HD_CLASS_GBL IN ('TRCLASS$FA','TRCLASS$FL','TRCLASS$FT') UNION "+     
                                                     "SELECT I.HD_ID,I.SANC_AMT FROM FIN_TR_CLM_LS I,FIN_TR_HDS J "+
                                                     "WHERE I.CLM_ID =? AND I.HD_ID= J.HD_ID AND J.HD_CLASS_GBL IN ('TRCLASS$FA','TRCLASS$FL','TRCLASS$FT') UNION "+
                                                     "SELECT K.HD_ID,K.SANC_AMT FROM FIN_TR_CLM_DA K,FIN_TR_HDS L "+
                                                     "WHERE K.CLM_ID =? AND K.HD_ID= L.HD_ID AND L.HD_CLASS_GBL IN ('TRCLASS$FA','TRCLASS$FL','TRCLASS$FT') ) M, "+
                                                     "(SELECT N.HD_ID,N.EXP_ACCT_ID FROM FIN_TR_HDS N) O "+
                                                     "WHERE M.HD_ID = O.HD_ID GROUP BY O.EXP_ACCT_ID ";*/

    public static final String GET_DEPORDER_DTLS = "SELECT F.FE_CONV_RATE,F.FE_AMT FROM FIN_TR_CLM_HDR D,FIN_DEPORDER_HDR E,FIN_DEPORDER_DTL F WHERE D.CLM_ID = ? AND D.DEPORDER_NO = E.DEPORDER_NO AND E.PMT_ID = F.PMT_ID ORDER BY F.FE_CONV_RATE DESC";                                                     
    public static final String GET_DEPORDER_JVVOUCHSTATUS = "SELECT NVL(C.TXN_STATUS_GBL,'XYZ') AS TXN_STATUS_GBL FROM FIN_TR_CLM_HDR A,FIN_DEPORDER_HDR B,FIN_VOUCHER_HDR C WHERE A.CLM_ID = ? AND A.DEPORDER_NO = B.DEPORDER_NO(+) AND B.JV_VOUCHER_ID = C.VOUCHER_ID(+)";
    public static final String GET_FC_RCPT_DTL = "SELECT A.CONVR_RATE,A.FC_AMOUNT FROM FIN_TR_RECEIPT A, FIN_TR_CLM_RCPTDTL B WHERE "+
                                                 "B.CLM_ID = ? AND A.TXN_STATE = 'A' AND A.RECEIPT_NO = B.RECEIPT_NO AND A.CURR_ID IS NOT NULL";                                                        
    public static final String GET_DEPORDER_AMT = "SELECT ROUND(SUM(F.FE_CONV_RATE*F.FE_AMT)) AS DEPUTATION_AMT "+
                                                  "FROM FIN_TR_CLM_HDR D,FIN_DEPORDER_HDR E,FIN_DEPORDER_DTL F "+
                                                  "WHERE D.CLM_ID = ? AND D.DEPORDER_NO = E.DEPORDER_NO AND E.PMT_ID = F.PMT_ID";


             public static final String GET_PMT_DTLS=
                                                    "SELECT A.GBL_CODE,A.CODE_DESC FROM COM_GBL_DTL A,FIN_TR_CLM_HDR B WHERE  "+
                                                    "A.GBL_TYPE='SETLMODE' "+
                                                    "AND A.GBL_CODE NOT IN(SELECT B.REC_MODE_GBL FROM FIN_TR_CLM_HDR B WHERE B.CLM_ID=?)";                                    

}
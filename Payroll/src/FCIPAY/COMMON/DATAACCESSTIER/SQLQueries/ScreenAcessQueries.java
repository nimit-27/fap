/*
 * Program Name : ScreenAcessQueries.java
 * Author       : Jegan.V
 * Date Written : 01/03/2004
 * Description  : This is the list of queries that are for screen access
 *
*/


package FCIPAY.COMMON.DATAACCESSTIER.SQLQueries;

public class ScreenAcessQueries  
{

//============================================DYNAMIC MENU QUERIES=======================================

   //Queries for getting the Dynamic Menu Page. Queries were used in MainPageDAO.
//    public static final String SQL_GETMODULENAME="SELECT DISTINCT(CODE_DESC) AS MODULE FROM SYSADMIN_EMP_SCREEN_MAP T,SYSADMIN_SCREENACCESS_MST T1,COM_GBL_DTL C1 "
//                                                    + " WHERE T.EMP_NO=? AND T.LOC_ID=? AND T.SCREEN_ID=T1.SCREENACCESS_ID AND T1.MODULE_NAME=C1.GBL_CODE ";
    public static final String SQL_GETMODULENAME="SELECT DISTINCT(c1.CODE_DESC) AS MODULE FROM SYSADMIN_EMP_SCREEN_MAP T,SYSADMIN_SCREENACCESS_MST T1,COM_GBL_DTL C1,com_gbl_dtl c2  "
                                                    + " WHERE T.EMP_NO=? AND T.LOC_ID=? AND T.SCREEN_ID=T1.SCREENACCESS_ID AND T1.MODULE_NAME=C1.GBL_CODE and c2.code_desc=? and c2.gbl_code=t1.owner and c2.gbl_type='OWNER' order by MODULE DESC";


/*    public static final String SQL_GETSCREENNAMES="SELECT T1.HEADER_NAME,T1.LEVEL1,NVL(T1.LEVEL2,' '),NVL(T1.LEVEL3,' '),NVL(T1.FORMBEANNAME,' '),NVL(T1.ACTIONNAME,' '),T1.REPORT_URL "
                                                    + " FROM SYSADMIN_EMP_SCREEN_MAP T,SYSADMIN_SCREENACCESS_MST T1,COM_GBL_DTL C1 "
                                                    + " WHERE T.EMP_NO=? AND T.SCREEN_ID=T1.SCREENACCESS_ID AND T1.MODULE_NAME=C1.GBL_CODE AND C1.CODE_SDESC=?";*/

    public static final String SQL_GETSCREENNAMES="SELECT T1.HEADER_NAME HEADER_NAME,trim(T1.LEVEL1) level1,NVL(trim(T1.LEVEL2),' ') level2,NVL(trim(T1.LEVEL3),' ') level3,NVL(T1.FORMBEANNAME,' ') FORMBEANNAME,NVL(T1.ACTIONNAME,' ') ACTIONNAME ,T1.REPORT_URL REPORT_URL,NVL(T1.ALL_EMP_FLG,'') ALL_EMP_FLG"
                                                    +" FROM SYSADMIN_EMP_SCREEN_MAP T,SYSADMIN_SCREENACCESS_MST T1,COM_GBL_DTL C1"
                                                    +" WHERE T.EMP_NO=? AND T.LOC_ID=? AND C1.CODE_DESC=? AND T.SCREEN_ID=T1.SCREENACCESS_ID AND T1.MODULE_NAME=C1.GBL_CODE order by menuindx,level1_indx,level2_indx,level3_indx";




//============================================SCREEN MASTER QUERIES=======================================


    public static final String SQL_GETGLOBALMODULE="SELECT GBL_CODE,CODE_DESC FROM COM_GBL_DTL WHERE GBL_TYPE='M'";
    
    public static final String SQL_GETHEADER="SELECT DISTINCT(HEADER_NAME) FROM SYSADMIN_SCREENACCESS_MST WHERE MODULE_NAME=?";

    public static final String SQL_GETLEVEL1="SELECT DISTINCT(LEVEL1) as level1 FROM SYSADMIN_SCREENACCESS_MST WHERE MODULE_NAME=? AND HEADER_NAME=? AND LEVEL2 IS NOT NULL";

    public static final String SQL_GETLEVEL2="SELECT DISTINCT(LEVEL2) FROM SYSADMIN_SCREENACCESS_MST WHERE MODULE_NAME=? AND HEADER_NAME=? AND LEVEL1=? AND LEVEL3 IS NOT NULL";

    public static final String SQL_SAVESA_SCREEN_DTLS="INSERT INTO SYSADMIN_SCREENACCESS_MST(SCREENACCESS_ID,MODULE_NAME,HEADER_NAME,LEVEL1,LEVEL2,LEVEL3,ACTIONNAME,FORMBEANNAME,REPORT_URL,"
                                                    + "CREATED_USER,CREATED_SITE,CREATED_DATE) VALUES(GET_ID(?,'SYSADMIN_SCREENACCESS_MST'),?,upper(trim(?)),upper(trim(?)),upper(trim(?)),upper(trim(?)),trim(?),trim(?),trim(?),?,?,SYSDATE)";

    public static final String SQL_SAVESA_REPORT_DTLS="INSERT INTO SYSADMIN_SCREENACCESS_MST(SCREENACCESS_ID,MODULE_NAME,HEADER_NAME,LEVEL1,LEVEL2,LEVEL3,ACTIONNAME,FORMBEANNAME,REPORT_URL,"
                                                    + " CREATED_USER,CREATED_SITE,CREATED_DATE) VALUES(GET_ID(?,'SYSADMIN_SCREENACCESS_MST'),?,upper(trim(?)),upper(trim(?)),upper(trim(?)),upper(trim(?)),trim(?),"
                                                    + " (select max(formbeanname) from sysadmin_screenaccess_mst where actionname='HomePage')+1,trim(?),?,?,SYSDATE)";





//============================================SCREEN EMP MAPPING QUERIES=======================================


    public static final String SQL_GETEMPNO="SELECT DISTINCT T.EMP_NO FROM SYSADMIN_USER_LOC T,SYSADMIN_USER_MST T1 WHERE T1.EMP_NO=T.EMP_NO AND T.LOC_STAT_FLG='A' AND T1.EMP_STAT_FLG='A'";
    
    public static final String SQL_GETMODULE="SELECT DISTINCT(CODE_SDESC) AS MODULE_NAME,GBL_CODE FROM SYSADMIN_SCREENACCESS_MST T,COM_GBL_DTL C WHERE T.MODULE_NAME=C.GBL_CODE AND T.MODULE_NAME in ('M$PAYROLL','M$SA','M$DEP','M$DPS','M$CPF','M$KOT','M$PENSION','M$NWNP')";

    public static final String SQL_GETEMPDTLS="SELECT T.EMP_FST_NAME || ' ' || T.EMP_MDL_NAME || ' ' || T.EMP_LST_NAME AS EMP_NAME,S.SECT_NAME,DECODE(T.EMP_DSGN_ID,NULL,(SELECT GRADE_DESC FROM HRM_GRADE_MAST WHERE GRADE_ID=T.EMP_GRADE_ID),"
                                               + "(SELECT DSGN_DESC FROM HRM_DSGN_MAST WHERE DSGN_ID=T.EMP_DSGN_ID)) AS DSGN FROM HRM_EMPLOYEE T,HRM_SECT_MAST S WHERE T.EMP_NO=? AND T.EMP_SECT_ID=S.SECT_ID";


    //New Query which is introduced after the List box is changed into the text box.

    public static final String SQL_GETLikeEMPNO="SELECT DISTINCT T.EMP_NO FROM SYSADMIN_USER_LOC T,SYSADMIN_USER_MST T1 WHERE T1.EMP_NO=T.EMP_NO AND T.EMP_NO LIKE ? AND T.LOC_STAT_FLG='A' AND T1.EMP_STAT_FLG='A'";
    
    public static final String sql_GetEmpDetails="SELECT T.EMP_NO,EMP.EMP_FST_NAME || ' ' || EMP.EMP_MDL_NAME || ' ' || EMP.EMP_LST_NAME AS EMP_NAME,"
                                                    + "S.SECT_NAME,DECODE(EMP.EMP_DSGN_ID,NULL,(SELECT GRADE_DESC FROM HRM_GRADE_MAST WHERE GRADE_ID=EMP.EMP_GRADE_ID),"
                                                    + "(SELECT DSGN_DESC FROM HRM_DSGN_MAST WHERE DSGN_ID=EMP.EMP_DSGN_ID)) AS DSGN"
                                                    + "FROM SYSADMIN_USER_LOC T,SYSADMIN_USER_MST T1,HRM_EMPLOYEE EMP,HRM_SECT_MAST S "
                                                    + "WHERE T1.EMP_NO=T.EMP_NO AND T.LOC_ID=? AND T.LOC_STAT_FLG='A' AND T1.EMP_STAT_FLG='A'"
                                                    + "AND T.EMP_NO=EMP.EMP_NO AND EMP.EMP_SECT_ID=S.SECT_ID AND T.EMP_NO=?";

    //End of New Query

    public static final String SQL_GETLEVELS="SELECT T1.SCREENACCESS_ID,T1.LEVEL1,T1.LEVEL2,T1.LEVEL3 FROM SYSADMIN_SCREENACCESS_MST T1 WHERE T1.MODULE_NAME=? AND T1.HEADER_NAME=? "
                                                + " MINUS "
                                                + " SELECT T3.SCREENACCESS_ID,T3.LEVEL1,T3.LEVEL2,T3.LEVEL3 FROM SYSADMIN_EMP_SCREEN_MAP T2,SYSADMIN_SCREENACCESS_MST T3 WHERE T3.SCREENACCESS_ID=T2.SCREEN_ID AND T2.EMP_NO=? AND T2.LOC_ID=? ";

    public static final String SQL_ASSIGNEDLEVELS="SELECT T.SCREEN_EMP_ID,SCREEN_ID,T1.LEVEL1,T1.LEVEL2,T1.LEVEL3 FROM SYSADMIN_EMP_SCREEN_MAP T,SYSADMIN_SCREENACCESS_MST T1 "
                                                    + "WHERE T.SCREEN_ID=T1.SCREENACCESS_ID AND T1.MODULE_NAME=? AND T1.HEADER_NAME=? AND T.EMP_NO=? AND T.LOC_ID=?";

    public static final String SQL_SAVE_EMPSCREENDTLS_AUDIT="INSERT INTO audit_sysadmin_emp_screen_map(SCREEN_EMP_ID, LOC_ID, SCREEN_ID, EMP_NO, REVOKED_BY, REVOKED_SITE, REVOKED_DATE) VALUES(?,?,?,?,?,?,SYSDATE)";

    public static final String SQL_DEL_ASSIGNEDLEVELS="DELETE FROM SYSADMIN_EMP_SCREEN_MAP WHERE SCREEN_EMP_ID=?";


    //public static final String SQL_GETLEVELS="SELECT SCREENACCESS_ID,LEVEL1,LEVEL2,LEVEL3 FROM SYSADMIN_SCREENACCESS_MST WHERE MODULE_NAME=? AND HEADER_NAME=?";


    public static final String SQL_SAVE_EMPSCREENDTLS="INSERT INTO SYSADMIN_EMP_SCREEN_MAP(SCREEN_EMP_ID,SCREEN_ID,EMP_NO,LOC_ID,CREATED_USER,CREATED_SITE,CREATED_DATE) VALUES(GET_ID(?,'SYSADMIN_EMP_SCREEN_MAP'),?,?,?,?,?,SYSDATE)";


    //FOR GETTING THE REPORT IN THE NEXT PAGE
 //   public static final String SQL_GETREPORT_URL="SELECT REPORT_URL FROM SYSADMIN_SCREENACCESS_MST WHERE ACTIONNAME='HomePage' AND FORMBEANNAME=?";
    public static final String SQL_GETREPORT_URL="SELECT REPORT_URL FROM SYSADMIN_SCREENACCESS_MST WHERE ACTIONNAME= ? AND FORMBEANNAME=?"; 
    
//Added by Balpreet Dt 22 Nov 2007 fro fetching location dtls for selected emp.
    
    public static final String SQL_GETEMPLOCDTLS="SELECT lm.loc_desc,lm.loc_id FROM SYSADMIN_USER_LOC ul,com_loc_mst lm where ul.emp_no =?and LOC_STAT_FLG = 'A' and lm.loc_id=ul.loc_id";

}
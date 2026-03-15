package FCIPAY.COMMON.DATAACCESSTIER.SQLQueries;

public class UsrLocMastSQLQueries 
{
    public static final String sql_GetEmpNo="SELECT SYS.EMP_NO EMP_NO,NVL(EMP_FIRST_NAME,'') || ' ' || NVL(EMP_MIDDLE_NAME,'') || ' ' || NVL(EMP_LAST_NAME,'') AS EMP_NAME "
                                            + " FROM SYSADMIN_USER_MST SYS,PAY_EMP_MAST EMP WHERE SYS.EMP_NO=EMP.EMP_NUM(+) ORDER BY EMP_NO";

    public static final String sql_GetLocation="SELECT LOC_ID,LOC_SDESC,LOC_DESC FROM COM_LOC_MST WHERE  LOC_TYPE_GBL NOT IN  ('DP','PO') ORDER BY LOC_ID";


    public static final String sql_GetUsrLocDtls="SELECT T.USERLOC_ID,T.EMP_NO,T.LOC_ID,T.LOC_STAT_FLG,NVL(EMP.EMP_FIRST_NAME,'') || ' ' || NVL(EMP.EMP_MIDDLE_NAME,'') || ' ' || NVL(EMP.EMP_LAST_NAME,'') AS EMP_NAME,LOC.LOC_SDESC "
                                                    + " FROM SYSADMIN_USER_LOC T,PAY_EMP_MAST EMP,COM_LOC_MST LOC WHERE T.EMP_NO=EMP.EMP_NUM(+) AND T.LOC_ID=LOC.LOC_ID AND T.EMP_NO=?"; 

    public static final String sql_InsertUsrLocDtls="INSERT INTO SYSADMIN_USER_LOC(USERLOC_ID,EMP_NO,LOC_ID,LOC_STAT_FLG,CREATED_USER,CREATED_SITE,CREATED_DT) "
                                                      + " VALUES(get_id(?,'SYSADMIN_USER_LOC'),?,?,?,?,?,sysdate)";
                                                    
    public static final String sql_UpdateUsrLocDtls="UPDATE SYSADMIN_USER_LOC SET LOC_STAT_FLG=?,MODIFIED_USER=?,MODIFIED_SITE=?,MODIFIED_DT=sysdate WHERE USERLOC_ID=?";
}
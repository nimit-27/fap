package FCIPAY.COMMON.DATAACCESSTIER.SQLQueries;

public class UserMastQueries  
{
/**
 * Queries for the Create User Screen
 */
    public static final String sql_GetEmpDtls="select t.emp_first_name || ' ' || t.emp_middle_name || ' ' || t.emp_last_name as emp_name,nvl(l.loc_desc, '') loc_desc,d.dsgn_desc from pay_emp_mast t, pay_dsgn_mst d, com_loc_mst l where t.emp_num=? and d.dsgn_id = t.designation_id and l.loc_id = t.pres_location_code and  t.emp_num not in (Select s.emp_no from sysadmin_user_mst s)";
   
    public static final String sql_InsertUser="INSERT INTO sysadmin_user_mst(emp_no,emp_psswd,emp_stat_flg,created_user,created_site,created_dt,modified_dt,psswd_changed) VALUES(?,?,'A',?,?,sysdate,sysdate,'0')";
    public static final String sql_GetUserDtls="Select count(*) reccount from sysadmin_user_mst where emp_no=?";
    public static final String sql_GetUserSts="Select emp_stat_flg from sysadmin_user_mst where emp_no=?";
    public static final String sql_MakeUserActive="UPDATE sysadmin_user_mst SET emp_stat_flg='A', modified_user=?, modified_site=?, modified_dt=sysdate WHERE emp_no=?";
    public static final String sql_ChkIfHQ="SELECT count(*) reccount from com_loc_mst where loc_type_gbl='HQ' and loc_id=?";
    
}
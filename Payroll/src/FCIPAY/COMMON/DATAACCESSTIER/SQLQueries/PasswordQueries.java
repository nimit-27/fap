package FCIPAY.COMMON.DATAACCESSTIER.SQLQueries;

public class PasswordQueries  
{
/**
 * Queries for the Change password Screen
 */
    public static final String sql_ChangePwd = "update sysadmin_user_mst set emp_psswd=?,modified_user=?,modified_site=?,modified_dt=sysdate where emp_no=? and emp_psswd=? and emp_stat_flg='A'";
    


/**
 * Queries for the Reset password Screen
 */
    public static final String sql_GetEmpDtls="select t.emp_first_name || ' ' || t.emp_middle_name || ' ' || t.emp_last_name as emp_name,nvl(l.loc_desc, '') loc_desc, d.dsgn_desc from pay_emp_mast t, pay_dsgn_mst d, com_loc_mst l, sysadmin_user_mst s where s.emp_no =? and d.dsgn_id = t.designation_id and l.loc_id = t.pres_location_code and s.emp_no = t.emp_num";

/**
 * Query to Verify USer's Status
 */
 
  //public static final String sql_GetUserDtls="select s.emp_no  from sysadmin_user_mst s where s.emp_no =? and s.emp_stat_flg='A'";
  public static final String sql_GetUserDtls="select t.emp_first_name || ' ' || t.emp_middle_name || ' ' || t.emp_last_name as emp_name,nvl(l.loc_desc, '') loc_desc,d.dsgn_desc from sysadmin_user_mst s, pay_emp_mast t, pay_dsgn_mst d, com_loc_mst l where s.emp_no=? and d.dsgn_id = t.designation_id and l.loc_id = t.pres_location_code and s.emp_no = t.emp_num and s.emp_stat_flg='A'";
    public static final String sql_ResetPwd="update sysadmin_user_mst set emp_psswd=?,psswd_changed='0' where emp_no=?";

//    public static final String sql_ResetPwd="update sysadmin_user_mst set emp_psswd='npc123' where emp_no=?";

/**
 * Queries for the Password Uploading Screen
 */
 
//    public static final String sql_InsertPwdDetails="insert into temp_sysadmin_pwd(emp_no,emp_psswd,emp_stat_flg,org_pwd,created_user,created_site,created_dt) values(?,?,'A',?,?,?,sysdate)";
      public static final String sql_InsertPwdDetails="insert into sysadmin_user_mst(emp_no,emp_psswd,emp_stat_flg,created_user,created_site,created_dt,psswd_changed) values(?,?,'A',?,?,sysdate,'0')";
}
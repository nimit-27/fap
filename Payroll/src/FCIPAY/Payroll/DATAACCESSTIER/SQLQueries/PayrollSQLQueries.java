package  FCIPAY.Payroll.DATAACCESSTIER.SQLQueries;

public class PayrollSQLQueries 
{
    public static final String INSERT_PAYCODES = "insert into pay_codes (pay_code, pay_code_desc, taxable_ind, ext_save_rebate, rebate_limit, adj_priority, user_id_created, created_site_id, created_time_stamp) " +
    " values(?,?,?,?,?,?,?,?,sysdate)";
    public static final String UPDATE_PAYCODES = "update pay_codes set pay_code_desc = ?, taxable_ind = ?, ext_save_rebate = ?, rebate_limit = ?, adj_priority = ?, user_id_modified = ?, modified_site_id = ?, modified_time_stamp = sysdate where pay_code = ?";
    public static final String DELETE_PAYCODES = "DELETE FROM PAY_CODES WHERE PAY_CODE = ?";    
    public static final String SELECT_PAYCODES_DTLS = "select t.pay_code, t.pay_code_desc, t.taxable_ind, t.ext_save_rebate,t.rebate_limit,t.adj_priority from pay_codes t order by pay_code";

    //Foreign Service Commission Param Master
    public static final String INSERT_FSC_PARAM = "insert into PAY_FSC_RATES (srl_no, from_year, to_year, rate_pen_a, rate_leave_a, rate_pen_b, rate_leave_b, rate_pen_c, rate_pen_d, " +
    " rate_leave_d, user_id_created,created_site_id, created_site_id, created_time_stamp) " +
    " values(get_id(0,'PAY_FSC_RATES'),?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";

     // For Direct Payroll
     public static final String INSERT_DIR_PAYROLL = "insert into PAY_PAYROLL_TXN (emp_num, pay_code, pay_code_srl,pay_mode, txn_amt, " +
     " valid_upto_yymm, txn_type,payroll_flag, user_id_created,created_site_id, created_time_stamp) " +
     " values(?,?,?,?,?,?,0,'N',?,?,sysdate)";
     public static final String Select_DIR_PAYROLL = "select txn.emp_num, emp.emp_fst_name || '  '  || emp.emp_mdl_name || '  '  ||  emp.emp_lst_name Name, txn.pay_code,pay.pay_code_desc, txn.pay_code_srl, txn.pay_mode, pay.pay_code, txn.valid_from_yymm, txn.valid_upto_yymm, txn.txn_amt " +
     " from pay_payroll_txn txn, hrm_employee emp, pay_codes pay " +
     " where txn.emp_num = emp.emp_no(+) and txn.pay_code = pay.pay_code(+)";
     public static final String Select_DIR_PAYROLL_PAYCODE = "select txn.emp_num, emp.emp_fst_name || '  '  || emp.emp_mdl_name || '  '  ||  emp.emp_lst_name Name, txn.pay_code,pay.pay_code_desc, txn.pay_code_srl, txn.pay_mode, pay.pay_code, txn.valid_from_yymm, txn.valid_upto_yymm, txn.txn_amt " +
     " from pay_payroll_txn txn, hrm_employee emp, pay_codes pay " +
     " where txn.emp_num = emp.emp_no(+) and txn.pay_code = pay.pay_code(+) and txn.pay_code = ?";
      public static final String Select_DIR_PAYROLL_EMPCODE = "select txn.emp_num, emp.emp_fst_name || '  '  || emp.emp_mdl_name || '  '  ||  emp.emp_lst_name Name, txn.pay_code,pay.pay_code_desc, txn.pay_code_srl, txn.pay_mode, pay.pay_code, txn.valid_from_yymm, txn.valid_upto_yymm, txn.txn_amt " +
     " from pay_payroll_txn txn, hrm_employee emp, pay_codes pay " +
     " where txn.emp_num = emp.emp_no(+) and txn.pay_code = pay.pay_code(+) and txn.emp_num = ?";
     public static final String DELETE_DIRECT_PAYROLL = "delete from pay_payroll_txn where emp_num = ? and pay_code = ? and pay_code_srl = ? ";
     public static final String UPDATE_DIRECT_PAYROLL = "update pay_payroll_txn set pay_mode = ?, txn_amt = ?,valid_upto_yymm = ?, valid_from_yymm = ?, user_id_modified = ?, modified_site_id = ?, modified_time_stamp = sysdate where emp_num = ? and pay_code = ? and pay_code_srl = ?";  
     public static final String GEN_DIR_PAY_MAX_SRL_NO = "select nvl(max(pay_code_srl),0)+1 as SRL_NO from pay_payroll_txn where emp_num = ? and pay_code = ?";


     public static final String SELECT_PAY_SCALE = "select t.srl_no, t.rev_year, t.pay_scale_code,  t.start_basic, t.increment_amt, t.end_basic, t.eb_flag, t.pay_scale_type from pay_scale t order by rev_year, pay_scale_type, pay_scale_code, start_basic ";
     public static final String SELECT_PAY_SCALE_REV_YEAR = "select t.srl_no, t.rev_year, t.pay_scale_code, t.start_basic,  t.increment_amt, t.end_basic, t.eb_flag, t.pay_scale_type from pay_scale t where t.rev_year = ? order by rev_year, pay_scale_type, pay_scale_code , start_basic ";     
     public static final String SELECT_PAY_SCALE_PAY_SCALE_CODE = "select t.srl_no, t.rev_year, t.pay_scale_code, t.start_basic, t.increment_amt, t.end_basic, t.eb_flag, t.pay_scale_type from pay_scale t where t.pay_scale_code = ? order by rev_year, pay_scale_type, pay_scale_code , start_basic ";
     public static final String SELECT_PAY_SCALE_YYMM_AND_PSC = "select t.srl_no, t.rev_year, t.pay_scale_code, t.start_basic,  t.increment_amt, t.end_basic, t.eb_flag, t.pay_scale_type from pay_scale t where t.pay_scale_code = ? and t.rev_year = ? order by rev_year, pay_scale_type, pay_scale_code , start_basic  ";
     
     public static final String UPDATE_PAY_SCALE = "UPDATE PAY_SCALE T SET START_BASIC = ?,  INCREMENT_AMT = ?,  END_BASIC = ?, EB_FLAG = ?, user_id_modified = ?, modified_site_id = ?, modified_time_stamp = sysdate WHERE REV_YEAR = ? AND PAY_SCALE_TYPE = ? AND PAY_SCALE_CODE = ? AND SRL_NO= ?";
     public static final String DELETE_PAY_SCALE = "DELETE FROM PAY_SCALE  WHERE REV_YEAR = ? AND PAY_SCALE_TYPE = ? AND PAY_SCALE_CODE = ? AND SRL_NO= ?";     
     public static final String DELETE_PAY_SCALE_RECORD = "DELETE FROM PAY_SCALE  WHERE REV_YEAR = ? AND PAY_SCALE_CODE = ? ";          

     //Maintain Miscellaneous Parameters
     public static final String SELECT_WASHING_ALLOWANCE_DETAILS = "select t.srl_no, t.cadre, t.category,t.wash_allow,t.cable_tv_reim_amt from pay_fixed_wash_rates t order by cadre, category";
     public static final String SELECT_PROJECT_ALLOWANCE_DETAILS = "select t.srl_no, t.amount_from, t.amount_to, t.proj_allow from pay_fixed_proj_allow_rates t order by amount_from";
     public static final String SELECT_OVERTIME_ALLOWANCE_DETAILS = "select t.srl_no, t.amount_from,t.amount_to, t.over_time_allow from pay_fixed_over_time_rates t order by amount_from";
     public static final String SELECT_NIGHT_ALLOWANCE_DETAILS = "select t.srl_no, t.cadre,t.category, t.min_basic, t.max_basic, t.rate_per_hour  from pay_fixed_night_duty_rates t order by  cadre, category, min_basic";     
     public static final String SELECT_OTHER_ALLOWANCE_DETAILS = "select t.da_same_per, t.da_out_per, t.da_same_ceiling, t.da_out_ceiling, t.cycle_allow, t.uniform_allow, t.spl_allow,t.nursing_allow,t.charge_allow,t.mess_allow,t.education_allow, t.pf_deduct_perc from pay_fixed_misc_rates t";     

     public static final String INSERT_WASHING_ALLOWANCE = "insert into pay_fixed_wash_rates (srl_no, cadre, category, wash_allow, cable_tv_reim_amt, user_id_created, created_site_id, created_time_stamp) values (get_id(0,'pay_fixed_wash_rates'),?,?,?,?,?,?,sysdate)";     
     public static final String UPDATE_WASHING_ALLOWANCE = "update pay_fixed_wash_rates  set cadre = ?, category = ?, wash_allow = ?, cable_tv_reim_amt = ?, user_id_modified = ?, modified_site_id = ?, modified_time_stamp = sysdate where srl_no = ?";
     public static final String DELETE_WASHING_ALLOWANCE = "delete from pay_fixed_wash_rates where srl_no = ?";

     public static final String INSERT_PROJECT_ALLOWANCE = "insert into pay_fixed_proj_allow_rates (srl_no, amount_from, amount_to, proj_allow, user_id_created, created_site_id, created_time_stamp) values  (get_id(0,'PAY_FIXED_PROJ_RATES'),?,?,?,?,?,sysdate)";
     public static final String UPDATE_PROJECT_ALLOWANCE = "update pay_fixed_proj_allow_rates set amount_from = ?, amount_to = ?, proj_allow = ?, user_id_modified = ?, modified_site_id = ?, modified_time_stamp = sysdate where srl_no = ?";
     public static final String DELETE_PROJECT_ALLOWANCE = "delete from pay_fixed_proj_allow_rates where srl_no = ?";

     public static final String INSERT_OVERTIME_ALLOWANCE_DETAILS = "insert into pay_fixed_over_time_rates (srl_no, amount_from, amount_to, over_time_allow,  user_id_created, created_site_id, created_time_stamp) values (get_id(0,'PAY_FIXED_OT_RATES'),?,?,?,?,?,sysdate)";
     public static final String UPDATE_OVERTIME_ALLOWANCE_DETAILS = "update pay_fixed_over_time_rates set amount_from = ?, amount_to = ?, over_time_allow = ?,  user_id_modified = ?, modified_site_id = ?, modified_time_stamp = sysdate where srl_no = ?";
     public static final String DELETE_OVERTIME_ALLOWANCE_DETAILS = "delete from pay_fixed_over_time_rates where srl_no = ?";

     public static final String INSERT_NIGHT_ALLOWANCE_DETAILS = "insert into pay_fixed_night_duty_rates (srl_no, cadre, category, min_basic, max_basic, rate_per_hour, user_id_created, created_site_id, created_time_stamp) values (get_id(0,'PAY_FIXED_NIGHT_RATES'),?,?,?,?,?,?,?,sysdate)";
     public static final String UPDATE_NIGHT_ALLOWANCE_DETAILS = "update pay_fixed_night_duty_rates set  cadre = ?, category = ?, min_basic = ?, max_basic = ?, rate_per_hour = ?,  user_id_modified = ?, modified_site_id = ?, modified_time_stamp = sysdate where srl_no = ?";
     public static final String DELETE_NIGHT_ALLOWANCE_DETAILS = "delete from pay_fixed_night_duty_rates where srl_no = ?";

     public static final String INSERT_OTHER_ALLOWANCE_DETAILS = "insert into pay_fixed_misc_rates (da_same_per, da_out_per, da_same_ceiling, da_out_ceiling, cycle_allow, uniform_allow, spl_allow, nursing_allow, charge_allow, mess_allow, education_allow, pf_deduct_perc, user_id_created, created_site_id, created_time_stamp) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate)";     
     public static final String UPDATE_OTHER_ALLOWANCE_DETAILS = "update pay_fixed_misc_rates set da_same_per = ?, da_out_per = ?, da_same_ceiling = ?, da_out_ceiling = ?,  cycle_allow = ?, uniform_allow = ?, spl_allow = ?,   nursing_allow = ?, charge_allow = ?,  mess_allow = ?, education_allow = ?, pf_deduct_perc = ?,  user_id_modified = ?, modified_site_id = ?, modified_time_stamp = sysdate";
//     public static final String DELETE_OTHER_ALLOWANCE_DETAILS = "delete from pay_fixed_over_time_rates where srl_no = ?";

   //MAINTAIN CONVEYANCE ALLOWANCE & RECOVERY RATES
    public static final String DELETE_FIXED_ALLOW = "delete from pay_fixed_con_rates where srl_no=? and pay_scale_type=? ";     
    public static final String DELETE_FIXED_RECOV = "delete from pay_fixed_con_recov_rates where srl_no = ? and pay_scale_type = ? ";     
    public static final String Select_Cadre_mast = "select cadre_id,cadre_desc from hrm_cadre_mast order by cadre_desc ";
    public static final String Select_Categ_mast = "select categ_id,categ_desc from hrm_categ_mast order by categ_desc ";
    public static final String Select_Conv_Allow = "select srl_no,amount_from,amount_to,convey_a1,convey_a,convey_b1,convey_b,convey_c from pay_fixed_con_rates where pay_scale_type=? order by srl_no ";
    public static final String Select_Conv_Recov = "select srl_no,cadre,category,max_journey_allowed,recovery_amount from pay_fixed_con_recov_rates where pay_scale_type = ? order by srl_no ";
    public static final String Update_Conv_Allow = "update pay_fixed_con_rates set amount_from=?,amount_to=?,convey_a1=?,convey_a=?,convey_b1=?,convey_b=?,convey_c = ? where srl_no=? and pay_scale_type=? ";
    public static final String Update_Conv_Recov = "update pay_fixed_con_recov_rates set cadre= ? ,category= ? ,max_journey_allowed= ?,recovery_amount= ?  where srl_no= ? and pay_scale_type= ? ";

    //Maintain CCA Rates
    public static final String DELETE_CCA_RATES = "delete from pay_fixed_cca_rates where srl_no= ? and pay_scale_type= ? ";     
    public static final String Select_CCA_RATES = "select srl_no, amount_from, amount_to, cca_a1, cca_a, cca_b1, cca_b2, cca_c from pay_fixed_cca_rates where pay_scale_type = ?  order by srl_no ";
    public static final String Update_CCA_Rates = "update pay_fixed_cca_rates set amount_from= ? ,amount_to= ? ,cca_a1= ? ,cca_a= ? ,cca_b1= ? ,cca_b2= ? ,cca_c= ?  where srl_no = ? and pay_scale_type = ? ";

    // Maint FSC Param
     public static final String GET_FSC_PARAM_ID = "SELECT GET_ID(0,'pay_fsc_rates') FSC_ID FROM DUAL"; 
     public static final String SELECT_FSC_PARAM = "select t.srl_no, t.from_year, t.to_year,t.rate_pen_a,t.rate_leave_a,t.rate_pen_b,t.rate_leave_b,t.rate_pen_c,t.rate_leave_c,t.rate_pen_d,t.rate_leave_d  from pay_fsc_rates t";
     public static final String UPDATE_FSC_PARAM = "update pay_fsc_rates set  rate_pen_a = ?, rate_leave_a = ?, rate_pen_b = ? , rate_leave_b = ?, rate_pen_c = ? , rate_leave_c = ?, rate_pen_d = ?, rate_leave_d = ?  where srl_no = ? ";
     public static final String DELETE_FSC_PARAM = "delete from pay_fsc_rates where srl_no  = ?";
     //Maint Acct Code
     public static final String  SELECT_ACCT_CODE=  "select t.account_code,t.account_code_desc,t.account_code_type,t.account_code_type_desc from pay_account_codes t order by account_code_type, account_code";
     public static final String  SELECT_ACCT_CODE_TYPE=  "select t.account_code,t.account_code_desc from pay_account_codes t where account_code_type =? order by account_code_type, account_code";
     public static final String  DELETE_ACCT_CODE=  "delete from pay_account_codes where account_code_type=? and account_code=?";
     public static final String  UPDATE_ACCT_CODE_DESC=  "update pay_account_codes set account_code_desc=? where account_code_type=? and account_code=?";
     public static final String  UPDATE_ACCT_CODE_TYPE_DESC =  "update pay_account_codes set account_code_type_desc=? where account_code_type=?";     
     public static final String  DELETE_ACCT_CODE_ALL="delete from pay_account_codes a where a.account_code_type=? and a.account_code=? ";
     //MaintHraHrrRate
    //public static final String DELETE_FIXED_HRA = "delete from pay_fixed_hra_rates where srl_no=? and pay_scale_type=? ";     
    public static final String DELETE_FIXED_HRR = "delete from pay_fixed_hrr_rates where srl_no = ? and pay_scale_type = ? ";     
    public static final String Select_Hra_det = "select hra_a1,hra_a,hra_b1,hra_b2,hra_c,hra_unclassified from pay_fixed_hra_rates where pay_scale_type=?";
    public static final String Select_Hrr_det = "select srl_no,amount_from,amount_to,agency_code,qtr_type,area_from,area_to,licence_fee from pay_fixed_hrr_rates where pay_scale_type = ? order by srl_no ";
    public static final String Update_Hra_det = "update pay_fixed_hra_rates set hra_a1=?,hra_a=?,hra_b1=?,hra_b2=?,hra_c=?,hra_unclassified=?where pay_scale_type=? ";
    public static final String Update_Hrr_det = "update pay_fixed_hrr_rates set amount_from=?,amount_to=?,agency_code=?,qtr_type=?,area_from=?,area_to=?,licence_fee=?  where srl_no= ? and pay_scale_type= ?"; 
//    public static final String Select_Cadre_mast = "select cadre_id,cadre_desc from hrm_cadre_mast order by cadre_desc ";

    //Maint ElecMtrRdg
    public static final String DELETE_ELEC_MTR = "delete from pay_electricity_mtr_rdng where initial_mtr_reading = ? and meter_number = ? and emp_num=?"; 
    public static final String UPDATE_ELEC_MTR = "update pay_electricity_mtr_rdng set final_mtr_reading=?,initial_yymm=?,final_yymm=?where emp_num=? and meter_number=? and initial_mtr_reading=? ";
    public static final String UPDATE_ELEC_FRQ = "update pay_electricity_mtr_rdng set frequency=? where emp_num=? and meter_number=?  ";
    public static final String SELECT_ELEC_MTR= "select t.emp_num,t.meter_number,t.frequency,t.initial_mtr_reading,t.final_mtr_reading,t.initial_yymm,t.final_yymm from pay_electricity_mtr_rdng t order by emp_num";
    public static final String SELECT_ELEC_MTR_EMP= "select t.emp_num,t.meter_number,t.frequency,t.initial_mtr_reading,t.final_mtr_reading,t.initial_yymm,t.final_yymm from pay_electricity_mtr_rdng t where emp_num=? order by emp_num"; 
    public static final String SELECT_ELEC_MTR_FRE="select t.emp_num,t.meter_number,t.frequency,t.initial_mtr_reading,t.final_mtr_reading,t.initial_yymm,t.final_yymm from pay_electricity_mtr_rdng t where frequency=? order by emp_num";
    public static final String SELECT_ELEC_MTR_EMP_FRE="select t.emp_num,t.meter_number,t.frequency,t.initial_mtr_reading,t.final_mtr_reading,t.initial_yymm,t.final_yymm from pay_electricity_mtr_rdng t where emp_num=? frequency=? order by emp_num";

    //Maint Internal Savings
    public static final String DELETE_INT_SAV ="delete from pay_internal_savings where emp_num=? and savings_code=? and savings_srl_no=?";
    public static final String UPDATE_INT_SAV="Update pay_internal_savings set savings_amount=?,valid_upto_yymm=?,savings_number=? where emp_num=? and savings_code=? and savings_srl_no=?";
    public static final String GEN_INT_SAV_MAX_SRL_NO="select nvl(max(savings_srl_no),0)+1 as SRL_NO from pay_internal_savings where emp_num=? and savings_code=?";
    public static final String SELECT_INT_SAV="select i.emp_num,e.emp_fst_name,e.emp_mdl_name,e.emp_lst_name Name ,i.savings_code,p.pay_code_desc,i.savings_srl_no,i.savings_number,i.valid_upto_yymm,i.savings_amount from pay_internal_savings i,hrm_employee e,pay_codes p where i.emp_num=e.emp_no(+) and i.savings_code=p.pay_code";
    public static final String SELECT_INT_SAV_SAVCODE="select i.emp_num,e.emp_fst_name,e.emp_mdl_name,e.emp_lst_name Name,i.savings_code,p.pay_code_desc,i.savings_srl_no,i.savings_number,i.valid_upto_yymm,i.savings_amount from pay_internal_savings i,hrm_employee e,pay_codes p where i.emp_num=e.emp_no(+) and i.savings_code=p.pay_code and savings_code=?"; 
    public static final String SELECT_INT_SAV_EMPCODE="select i.emp_num,e.emp_fst_name,e.emp_mdl_name,e.emp_lst_name Name,i.savings_code,p.pay_code_desc,i.savings_srl_no,i.savings_number,i.valid_upto_yymm,i.savings_amount from pay_internal_savings i,hrm_employee e,pay_codes p where i.emp_num=e.emp_no(+) and i.savings_code=p.pay_code and emp_num=?"; 

    //Maintain DA Rates
    public static final String SELECT_DIST_DA_RATES = "select distinct yyyymm, pay_scale_type from pay_da_rate";
    public static final String SELECT_DA_RATES = "select a.srl_no,a.pay_scale_type,a.yyyymm,a.low_basic,a.high_basic,a.da_rate,a.da_min from pay_da_rate a order by yyyymm, pay_scale_type,low_basic";
    public static final String SELECT_DA_RATES_YYYYMM = "select a.srl_no,a.pay_scale_type,a.yyyymm,a.low_basic,a.high_basic,a.da_rate,a.da_min from pay_da_rate a  where a.yyyymm = ? order by yyyymm, pay_scale_type,low_basic";
    public static final String SELECT_DA_RATES_PAY = "select a.srl_no,a.pay_scale_type,a.yyyymm,a.low_basic,a.high_basic,a.da_rate,a.da_min from pay_da_rate a where a.pay_scale_type = ? order by yyyymm, pay_scale_type,low_basic";     
    public static final String SELECT_DA_RATES_YYYYMM_PAY = "select a.srl_no,a.pay_scale_type,a.yyyymm,a.low_basic,a.high_basic,a.da_rate,a.da_min from pay_da_rate a where a.yyyymm = ? and a.pay_scale_type = ? order by yyyymm, pay_scale_type,low_basic";     
    public static final String DELETE_DA_RATES = "delete from pay_da_rate a where a.pay_scale_type = ? and a.yyyymm = ? and a.srl_no = ? ";
    public static final String DELETE_ALL_DA_RATES = "delete from pay_da_rate a where a.pay_scale_type = ? and a.yyyymm = ? ";
    public static final String UPDATE_DA_RATES = "update pay_da_rate set low_basic = ? , high_basic = ? , da_rate = ? , da_min = ? where srl_no = ? and pay_scale_type = ? and yyyymm = ? ";  

   //Maintain Tax Param
   public static final String Select_IT_Details= "select amount_from,amount_to,rate_tax_rebate,rate_surcharge,rate_it,srl_no from pay_fixed_it_rates where rev_yymm=? ";
   public static final String Select_SD_Details="select amount_from,amount_to,sd_male_amount,sd_female_amount,per_amount,srl_no from pay_fixed_sd_rates where rev_yymm=?";
   public static final String Select_PT_Details="select amount_from,amount_to,prof_tax_amount,srl_no from pay_fixed_proftax_rates where rev_year=? and state_code=?";
   public static final String Select_Other_Details="select rev_year,rebate_savings_limit,female_addl,addl_limit from pay_fixed_it_savings_limit where rev_year=?";
   public static final String UPDATE_ITSavingsLimit_DETAILS="update pay_fixed_it_savings_limit set rebate_savings_limit=?,female_addl=?,addl_limit=? where rev_year=? ";
   public static final String UPDATE_PROF_TAX_DETAILS="update pay_fixed_proftax_rates set amount_from=?,amount_to=?,prof_tax_amount=? where rev_year=? and state_code=? and srl_no=? ";
   public static final String UPDATE_IT_DETAILS="update pay_fixed_it_rates set amount_from=?,amount_to=?,rate_it=?,rate_tax_rebate=?,rate_surcharge=? where rev_yymm=? and srl_no=?";
   public static final String UPDATE_SD_DETAILS="update pay_fixed_sd_rates set amount_from=?,amount_to=?,sd_male_amount=?,sd_female_amount=?,per_amount=? where rev_yymm=? and srl_no=?";
   public static final String DELETE_IT_DETAILS="delete from pay_fixed_it_rates where rev_yymm=? and srl_no=?"; 
   public static final String DELETE_SD_DETAILS="delete from pay_fixed_sd_rates where rev_yymm=? and srl_no=?";


//Maintain Annual Income

 public static final String Select_pay_emp_ytm_mast = "select emp_num,ytm_gross_erng,ytm_taxable_erng,ytm_hra,ytm_taxable_hrr,ytm_it_paid,ytm_prof_tax,ytm_medical,ytm_rent_paid,tax_due_to_apportion,apportioned_amt,external_income,ytm_gis,ytm_cpf,ytm_epf,ytm_fpf,ytm_lic,ytm_vpf,other_deductions,hba_interest,hba_principal,sal_prev_employer,external_it_paid,mth_rent,mthly_tax_dedn_amt from pay_emp_ytm_mast order by emp_num"; 
 public static final String Select_pay_emp_ytm_mast_empnum = "select emp_num,ytm_gross_erng,ytm_taxable_erng,ytm_hra,ytm_taxable_hrr,ytm_it_paid,ytm_prof_tax,ytm_medical,ytm_rent_paid,tax_due_to_apportion,apportioned_amt,external_income,ytm_gis,ytm_cpf,ytm_epf,ytm_fpf,ytm_lic,ytm_vpf,other_deductions,hba_interest,hba_principal,sal_prev_employer,external_it_paid,mth_rent,mthly_tax_dedn_amt from pay_emp_ytm_mast where trim(emp_num) = ? "; 
 public static final String UPDATE_pay_emp_ytm_mast = "update  pay_emp_ytm_mast set ytm_gross_erng =?,ytm_taxable_erng =?,ytm_hra =?,ytm_taxable_hrr =?,ytm_it_paid =?,ytm_prof_tax =?,ytm_medical =?,ytm_rent_paid =?,tax_due_to_apportion =?,apportioned_amt =?,external_income =?,ytm_gis =?,ytm_cpf =?,ytm_epf =?,ytm_fpf =?,ytm_lic =?,ytm_vpf =?,other_deductions =?,hba_interest =?,hba_principal =?,sal_prev_employer =?,external_it_paid =?,mth_rent =?,mthly_tax_dedn_amt =?,  user_id_modified = ?,modified_site_id = ?,modified_time_stamp = sysdate where trim(emp_num) =? ";

    //PayCodesVsAcctCodes
    public static final String DELETE_PAY_ACCT_CODE_DIR= "delete from pay_acct_code_dir where pay_code= ? and class_hdr= ? and agency_code= ? and site_id= ? and dr_cr_flag= ? ";    
    public static final String Select_Pay_Acct_Code = "select pay_code,acct_code,class_hdr,agency_code,site_id,dr_cr_flag from pay_acct_code_dir order by pay_code,class_hdr,agency_code,site_id,dr_cr_flag";
    public static final String Update_PAY_ACCT_CODE_DIR = "update pay_acct_code_dir set acct_code= ?,user_id_modified = ?,modified_site_id = ?,modified_time_stamp = sysdate  where pay_code= ?  and class_hdr= ? and agency_code= ? and site_id= ? and dr_cr_flag= ? ";
    public static final String SELECT_Pay_Acct_Code_desc ="select a.pay_code, c.pay_code_desc,class_hdr,agency_code,site_id,dr_cr_flag,acct_code from pay_acct_code_dir a , pay_codes c where a.pay_code=c.pay_code(+) order by pay_code, class_hdr,agency_code,site_id,dr_cr_flag";
    public static final String Select_ClassHead = "select cadre_id,cadre_desc from hrm_cadre_mast order by cadre_desc ";
    public static final String Select_AgencyCode = "select cadre_id,cadre_desc from hrm_cadre_mast order by cadre_desc ";
    public static final String Select_SiteId = "select loc_id,loc_sdesc from com_loc_mst order by loc_sdesc ";

    public static final String Update_Session_State = "UPDATE PAY_SESSION_STATE SET STATUS = 'INACTIVE' WHERE MODULE = ?";
   }    
   
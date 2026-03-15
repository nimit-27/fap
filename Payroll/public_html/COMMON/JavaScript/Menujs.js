//Menu object creation
MyMenu=new makeCM("MyMenu") //Making the menu object. Argument: menuname

FinMenu = "/Payroll/Finance/JSP/";
HRMenu = "/Payroll/HRMS/JSP/";
var cmmMenu="/Payroll/CMM/JSP/";
ComMenu = "/Payroll/COMMON/JSP/";

MyMenu.frames = 0

//Menu properties   
MyMenu.pxBetween=10
MyMenu.fromLeft=20 
MyMenu.fromTop=0   
MyMenu.rows=1 
MyMenu.menuPlacement="center"
                                                             
MyMenu.offlineRoot="" 
MyMenu.onlineRoot="" 
MyMenu.resizeCheck=1 
MyMenu.wait=1000 
MyMenu.fillImg="cm_fill.gif"
MyMenu.zIndex=1

//Background bar properties
MyMenu.useBar=1
MyMenu.barWidth="98%"
MyMenu.barHeight="menu" 
MyMenu.barClass="clBar"
MyMenu.barX=10 
MyMenu.barY=0
MyMenu.barBorderX=0
MyMenu.barBorderY=0
MyMenu.barBorderClass=""

MyMenu.onresize="makeCM('MyMenu'); MyMenu.construct(1);"

//Level properties - ALL properties have to be spesified in level 0
MyMenu.level[0]=new cm_makeLevel() //Add this for each new level
MyMenu.level[0].width=130
MyMenu.level[0].height=25 
MyMenu.level[0].regClass="clLevel0"
MyMenu.level[0].overClass="clLevel0over"
MyMenu.level[0].borderX=0
MyMenu.level[0].borderY=1
MyMenu.level[0].borderClass="clLevel0border"
MyMenu.level[0].offsetX=0
MyMenu.level[0].offsetY=0
MyMenu.level[0].rows=0
MyMenu.level[0].arrow=0
MyMenu.level[0].arrowWidth=0
MyMenu.level[0].arrowHeight=0
MyMenu.level[0].align="bottom"

//EXAMPLE SUB LEVEL[1] PROPERTIES - You have to specify the properties you want different from LEVEL[0] - If you want all items to look the same just remove this
MyMenu.level[1]=new cm_makeLevel() //Add this for each new level (adding one to the number)
MyMenu.level[1].width=130
MyMenu.level[1].height=22
MyMenu.level[1].regClass="clLevel1"
MyMenu.level[1].overClass="clLevel1over"
MyMenu.level[1].borderX=1
MyMenu.level[1].borderY=1
MyMenu.level[1].align="right" 
MyMenu.level[1].offsetX=0//-(MyMenu.level[0].width-2)/2+20
MyMenu.level[1].offsetY=0
MyMenu.level[1].borderClass="clLevel1border"


//EXAMPLE SUB LEVEL[2] PROPERTIES - You have to spesify the properties you want different from LEVEL[1] OR LEVEL[0] - If you want all items to look the same just remove this
MyMenu.level[2]=new cm_makeLevel() //Add this for each new level (adding one to the number)
MyMenu.level[2].width=160
MyMenu.level[2].height=20
MyMenu.level[2].offsetX=0
MyMenu.level[2].offsetY=0
MyMenu.level[2].regClass="clLevel2"
MyMenu.level[2].overClass="clLevel2over"
MyMenu.level[2].borderClass="clLevel2border"


/******************************************
Menu item creation:

*************************************/
MyMenu.makeMenu('f0','','FINANCE');
MyMenu.makeMenu('h1','','HRMS');
MyMenu.makeMenu('cmm0','','CMM');
MyMenu.makeMenu('m4','','ABOUT US',ComMenu + 'homepage.jsp');
MyMenu.makeMenu('m5','','EXIT',ComMenu + 'Login.jsp');

/********************************************

Start of Finance Menu Items

*********************************************/
MyMenu.makeMenu('f1','f0','Accounting');
MyMenu.makeMenu('f2','f0','Consultancy');
MyMenu.makeMenu('f3','f0','Contracts');
MyMenu.makeMenu('f4','f0','Energy Billing');
MyMenu.makeMenu('f5','f0','Travel');


/* ********** GL Accounting ********************** */
MyMenu.makeMenu('f11','f1','Master Maintenance');
MyMenu.makeMenu('f12','f1','Voucher Transactions');
MyMenu.makeMenu('f13','f1','Bank Transactions');
MyMenu.makeMenu('f14','f1','Reports');

MyMenu.makeMenu('f101','f11','Location Master', FinMenu + 'LocationMaster.jsp');
MyMenu.makeMenu('f102','f11','Charge Location Master',FinMenu + 'ChargeLocationMaster.jsp');
MyMenu.makeMenu('f103','f11','Charge Code Map',FinMenu + 'LocationCodeChargeCodeMap.jsp');
MyMenu.makeMenu('f104','f11','Cost Centre Master',FinMenu + 'CostCentreMaster.jsp');
MyMenu.makeMenu('f105','f11','Schedule Group Master',FinMenu + 'ScheduleGroupMaster.jsp');
MyMenu.makeMenu('f106','f11','Vendor Master',FinMenu + 'VendorMaster.jsp');
MyMenu.makeMenu('f107','f11','Vendor Id Map',FinMenu + 'VendorIdMap.jsp');
MyMenu.makeMenu('f108','f11','Vendor Address',FinMenu + 'VendorAddress.jsp');
MyMenu.makeMenu('f109','f11','Chart of Accounts',FinMenu + 'ChartOfAccounts.jsp');
MyMenu.makeMenu('f110','f11','Financial Calendar',FinMenu + 'FinancialCalendar.jsp');


MyMenu.makeMenu('f111','f12','Create New');
MyMenu.makeMenu('f112','f12','Authorise',FinMenu + 'SelJournalVoucher.jsp');
MyMenu.makeMenu('f113','f12','Record Payment/Receipt');
MyMenu.makeMenu('f114','f12','Posting',FinMenu + 'VoucherPosting.jsp');

MyMenu.makeMenu('f115','f13','Bank Pass Book Reconcilation',FinMenu + 'BankPassBookRecon.jsp');
MyMenu.makeMenu('f116','f13','Bank Pass Book',FinMenu + 'BankPassBook.jsp');
MyMenu.makeMenu('f117','f13','Upload Bank Pass Book',FinMenu + 'upload.jsp');
MyMenu.makeMenu('f118','f13','Financial Bank Pass Book',FinMenu + 'FinPassBook.jsp');
MyMenu.makeMenu('f119','f13','Cash Bank Day Book',FinMenu + 'CBDayBook.jsp');

MyMenu.makeMenu('f120','f14','Schedule Sub Group');
MyMenu.makeMenu('f121','f14','Trial / Sub Ledger Balance');
MyMenu.makeMenu('f122','f14','HQ Overhead');
MyMenu.makeMenu('f123','f14','Consolidated Trial Balance',FinMenu + 'CQReport.jsp');
MyMenu.makeMenu('f124','f14','Balance Sheet');
MyMenu.makeMenu('f125','f14','Schedule Group / Sub Group');

MyMenu.makeMenu('f501','f111','Journal Voucher');
MyMenu.makeMenu('f502','f111','Payment Voucher');
MyMenu.makeMenu('f503','f111','Receipt Voucher',FinMenu + 'ReceiptVoucher.jsp');

MyMenu.makeMenu('f504','f113','Generate Set',FinMenu + 'RecordMultiplePayments.jsp');
MyMenu.makeMenu('f505','f113','Single Voucher',FinMenu + 'RecordPayments.jsp');
MyMenu.makeMenu('f506','f113','Multiple Vouchers',FinMenu + 'RecordSetPayments.jsp');
MyMenu.makeMenu('f507','f113','Voucher Processing',FinMenu + 'VoucherProcessing.jsp');
MyMenu.makeMenu('f508','f113','Record Receipt',FinMenu + 'RecordReceipts.jsp');
MyMenu.makeMenu('f509','f113','Cheque Printing');

MyMenu.makeMenu('f1001','f501','NJV',FinMenu + 'NJV.jsp');
MyMenu.makeMenu('f1002','f501','SJV',FinMenu + 'SJV.jsp');
MyMenu.makeMenu('f1003','f501','CJV',FinMenu + 'CJV.jsp');
MyMenu.makeMenu('f1004','f501','IAV',FinMenu + 'IAV.jsp');
MyMenu.makeMenu('f1005','f501','IUA');

MyMenu.makeMenu('f1006','f502','BPV',FinMenu + 'BankPaymentVoucher.jsp');
MyMenu.makeMenu('f1007','f502','CPV',FinMenu + 'CashPaymentVoucher.jsp');

MyMenu.makeMenu('f1008','f509','Cheque Master',FinMenu + 'ChequeMaster.jsp');
MyMenu.makeMenu('f1009','f509','Cheque Void',FinMenu + 'VoidCheques.jsp');
MyMenu.makeMenu('f1010','f509','New Cheque Assignment',FinMenu + 'ReAssignCheque.jsp');
MyMenu.makeMenu('f1011','f509','Reuse Cheque',FinMenu + 'ReUseDeletedCheque.jsp');


/***************************************************************************************/

/* ********** Travel ********************** */
MyMenu.makeMenu('f51','f5','Master Maintenance');

MyMenu.makeMenu('f401','f51','Request Type Master', FinMenu + 'HeadMaster.jsp');
MyMenu.makeMenu('f402','f51','Travel Amount Limit',FinMenu + 'TravelAmtLimit.jsp');
MyMenu.makeMenu('f403','f51','Travel Heads Master',FinMenu + 'TravelHead.jsp');
MyMenu.makeMenu('f404','f51','Travel Type Head Map',FinMenu + 'TravelTypeHeadMap.jsp');
MyMenu.makeMenu('f405','f51','Travel Class Master',FinMenu + 'TravelClassMaster.jsp');
MyMenu.makeMenu('f406','f51','Travel Rates Master',FinMenu + 'TravelRateMaster.jsp');
MyMenu.makeMenu('f407','f51','Percent Master',FinMenu + 'PercentMaster.jsp');
MyMenu.makeMenu('f408','f51','Periodicity Master',FinMenu + 'PeriodicityMaster.jsp');
MyMenu.makeMenu('f409','f51','Lump Sum Master',FinMenu + 'LumpSumMaster.jsp');
MyMenu.makeMenu('f410','f51','Document Master',FinMenu + 'TravelDocMaster.jsp');
MyMenu.makeMenu('f411','f51','Rate Group Master',FinMenu + 'TrvRateGrpMaster.jsp');
MyMenu.makeMenu('f412','f51','Rate Group Detail',FinMenu + 'TrvRateGrpDtl.jsp');
MyMenu.makeMenu('f413','f51','Currency Master',FinMenu + 'CurrencyMaster.jsp');


/***End of Finance Menu Items ****************************************/

/********************************************

Start of HR Menu Items

*********************************************/
MyMenu.makeMenu('h2','h1','Establishment');
MyMenu.makeMenu('h3','h1','Admin Services');
MyMenu.makeMenu('h4','h1','Manpower Planning');
MyMenu.makeMenu('h5','h1','CHRIS');
MyMenu.makeMenu('h6','h1','Trg. & Dev');
MyMenu.makeMenu('h7','h1','Admin Audit');
MyMenu.makeMenu('h8','h1','Estate Management');
MyMenu.makeMenu('h9','h1','Security');
MyMenu.makeMenu('h10','h4','Masters');


//Master Listing 
MyMenu.makeMenu('h11','h10','City', HRMenu + 'frmCityMaster.jsp');
MyMenu.makeMenu('h12','h10','State', HRMenu + 'frmStateMaster.jsp');
MyMenu.makeMenu('h13','h10','Country', HRMenu + 'frmCountryMaster.jsp');
MyMenu.makeMenu('h14','h10','Category', HRMenu + 'frmCategoryMaster.jsp');
MyMenu.makeMenu('h15','h10','Cadre', HRMenu + 'frmCadreMaster.jsp');
MyMenu.makeMenu('h16','h10','Qualification', HRMenu + 'frmQualificationMaster.jsp');
MyMenu.makeMenu('h17','h10','Discipline', HRMenu + 'frmDisciplineMaster.jsp');
MyMenu.makeMenu('h18','h10','Directorate', HRMenu + 'frmDrcrtMaster.jsp');
MyMenu.makeMenu('h19','h10','Functional Group', HRMenu + 'frmFuncMaster.jsp');
MyMenu.makeMenu('h20','h10','Group', HRMenu + 'frmDGrpHqMaster.jsp');
MyMenu.makeMenu('h21','h10','Designation', HRMenu + 'frmDsgnMaster.jsp');
MyMenu.makeMenu('h22','h10','Employee Type', HRMenu + 'frmEmployeeTypeMaster.jsp');
MyMenu.makeMenu('h23','h10','Post Type', HRMenu + 'frmPostTypeMaster.jsp');
MyMenu.makeMenu('h24','h10','Relation', HRMenu + 'frmRelationMaster.jsp');
MyMenu.makeMenu('h25','h10','Religion', HRMenu + 'frmReligionMaster.jsp');
MyMenu.makeMenu('h26','h10','Venue', HRMenu + 'frmVenueMaster.jsp');
MyMenu.makeMenu('h27','h10','Language', HRMenu + 'frmLanguageMaster.jsp');
MyMenu.makeMenu('h28','h10','PayScale', HRMenu + 'frmPayScaleMaster.jsp');

MyMenu.makeMenu('h29','h2','Leave');
MyMenu.makeMenu('h30','h2','LTC');

MyMenu.makeMenu('h31','h29','Leave Master', HRMenu + 'frmLeaveMaster.jsp');
MyMenu.makeMenu('h32','h29','Leave Adjustment', HRMenu + 'frmLeaveAdjustment.jsp');
MyMenu.makeMenu('h33','h29','Leave Crediting', HRMenu + 'frmLeaveCredit.jsp');
MyMenu.makeMenu('h34','h29','Leave Application', HRMenu + 'frmLeaveAppln1.jsp');
MyMenu.makeMenu('h35','h29','Leave Approval', HRMenu + 'frmLeaveApprvl.jsp');
MyMenu.makeMenu('h36','h29','Joining Report', HRMenu + 'frmJoinRpt.jsp');
MyMenu.makeMenu('h37','h29','Balance', HRMenu + 'LeaveBalance.jsp');
MyMenu.makeMenu('h38','h29','Encashment', HRMenu + 'frmLeaveEncashAppln.jsp');
MyMenu.makeMenu('h39','h29','Encashment Approval', HRMenu + 'frmLeaveEncashAppr.jsp');

//LTC Listing
MyMenu.makeMenu('h40','h30','Eligibility Master', HRMenu + 'frmLtcEligibility.jsp');
MyMenu.makeMenu('h41','h30','Blockyear master', HRMenu + 'frmBlockYearMaster.jsp');
MyMenu.makeMenu('h42','h30','Dependent', HRMenu + 'frmEmpDependent.jsp');
MyMenu.makeMenu('h43','h30','Dependent Approval', HRMenu + 'EmpDependentApprv.jsp');
MyMenu.makeMenu('h44','h30','HomeTown Declaration', HRMenu + 'frmLTCHometownDecl.jsp');
MyMenu.makeMenu('h45','h30','HomeTown Decl Approval', HRMenu + 'frmLTCHometownAppr.jsp');
MyMenu.makeMenu('h46','h30','HomeTown Advance', HRMenu + 'frmLTCHomeTown.jsp');
MyMenu.makeMenu('h47','h30','Other than HT Advance ', HRMenu + 'frmLTCOTHAdvPg1.jsp');
MyMenu.makeMenu('h48','h30','Advance Approval', HRMenu + 'frmLtcAdvPg2.jsp');
MyMenu.makeMenu('h49','h30','Hometown Claim', HRMenu + 'frmLTCHomeTownClaim.jsp');
MyMenu.makeMenu('h50','h30','Other than HT Claim', HRMenu + 'frmLTCOTHClaim.jsp');
MyMenu.makeMenu('h51','h30','Claim Approval (Personnel)', HRMenu + 'frmLTCClaimPerApprv.jsp');
MyMenu.makeMenu('h52','h30','Claim Approval (Accounts)', HRMenu + 'frmLTCClaimAccountApprv.jsp');
MyMenu.makeMenu('h53','h30','Encashment ', HRMenu + 'LTCEncash1.jsp');
MyMenu.makeMenu('h54','h30','Encashment Approval', HRMenu + 'LTCEncash2.jsp');
MyMenu.makeMenu('h55','h30','HomeTown Change', HRMenu + 'LtcDeclChngAppl.jsp');
MyMenu.makeMenu('h56','h30','HomeTown Change Approval', HRMenu + 'LtcDeclChngAppr.jsp');



//PF
/*MyMenu.makeMenu('h46','h2','PF');
MyMenu.makeMenu('h47','h46','Membership');
MyMenu.makeMenu('h48','h47','EPF', HRMenu + 'frmPFEpfMemApp.jsp');
MyMenu.makeMenu('h49','h47','EPF', HRMenu + 'frmPFNcpfMemApp.jsp');
MyMenu.makeMenu('h50','h46','Nominee Declaration');
MyMenu.makeMenu('h51','h50','EPF', HRMenu + 'frmPFEpfFamNom.jsp');
MyMenu.makeMenu('h52','h50','NCPF', HRMenu + 'frmPFNcpfFamNom.jsp');
MyMenu.makeMenu('h53','h46','Nominee Cancellation');
MyMenu.makeMenu('h54','h53','EPF ', HRMenu + 'frmPFEpfNomCanc.jsp');
MyMenu.makeMenu('h55','h53','NCPF', HRMenu + 'frmPFNcpfNomCanc.jsp');
MyMenu.makeMenu('h56','h46','Advance / Withdrawal', HRMenu + 'frmPFAdvWithdrawApp.jsp');
*/

/********************************************
Start of CMM Menu Items
*********************************************/
MyMenu.makeMenu('cmm1','cmm0','Store Details');
MyMenu.makeMenu('cmm2','cmm0','Section Details');
MyMenu.makeMenu('cmm3','cmm0','WareHouse Details');
MyMenu.makeMenu('cmm4','cmm0','Item Master');

MyMenu.makeMenu('cmm5','cmm1','New Store',cmmMenu + 'StoreMaster.jsp');
MyMenu.makeMenu('cmm6','cmm1','Edit Store',cmmMenu + 'StoreMaster_Edit.jsp');
MyMenu.makeMenu('cmm7','cmm2','New Section',cmmMenu + 'SectionMaster.jsp');
MyMenu.makeMenu('cmm8','cmm2','Edit Section',cmmMenu + 'SectionMaster_Edit.jsp');
MyMenu.makeMenu('cmm9','cmm3','New WareHouse',cmmMenu + 'WareHouseMaster.jsp');
MyMenu.makeMenu('cmm10','cmm3','Edit WareHouse',cmmMenu + 'WareHouseMaster_Edit.jsp');
MyMenu.makeMenu('cmm11','cmm4','New Item Details',cmmMenu + 'frmItemMasterNew.jsp');
MyMenu.makeMenu('cmm12','cmm4','Edit Item Details',cmmMenu + 'frmItemMasterEdit.jsp');


//Leave this line - it constructs the menu
MyMenu.construct()		

//MyMenu.showsub("top3")
MyMenu.hidesub()

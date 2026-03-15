//Menu object creation
MyMenu=new makeCM("MyMenu") //Making the menu object. Argument: menuname

MyMenu.frames = 0

//Menu properties   
MyMenu.pxBetween=10 //10
MyMenu.fromLeft=0 
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
MyMenu.barWidth="100%"
MyMenu.barHeight="menu" 
MyMenu.barClass="clBar"
MyMenu.barX=0 //10 
MyMenu.barY=0
MyMenu.barBorderX=0
MyMenu.barBorderY=0
MyMenu.barBorderClass=""

MyMenu.onresize="makeCM('MyMenu'); MyMenu.construct(1);"

//Level properties - ALL properties have to be spesified in level 0
MyMenu.level[0]=new cm_makeLevel() //Add this for each new level
MyMenu.level[0].width=100 //130
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
MyMenu.level[1].width=180 //200
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
MyMenu.level[2].width=180 //200
MyMenu.level[2].height=20
MyMenu.level[2].offsetX=0
MyMenu.level[2].offsetY=0
MyMenu.level[2].regClass="clLevel2"
MyMenu.level[2].overClass="clLevel2over"
MyMenu.level[2].borderClass="clLevel2border"


/******************************************
Menu item creation:

*************************************/
MyMenu.makeMenu('2000000243','','Master Maintenance                                                                                                                                                                                                                                             ')
MyMenu.makeMenu('2000000504','2000000243','Store Master                                                                                                                                                                                                                                          ','IvmStoresMst.jsp')
MyMenu.makeMenu('2050200584','2000000243','Sub Store Master                                                                                                                                                                                                                                      ','IvmSubStoreMst.jsp')
MyMenu.makeMenu('2000000507','2000000243','Material Group Types Master                                                                                                                                                                                                                           ','IvmMaterialGroupTypesMst.jsp')
MyMenu.makeMenu('4002000565','2000000243','Item Master                                                                                                                                                                                                                                           ','IvmItemMaster.jsp')
MyMenu.makeMenu('2000000508','2000000243','Stock Master                                                                                                                                                                                                                                          ','IvmStockMaster.jsp')
MyMenu.makeMenu('2000000505','2000000243','Units Of Measurement Master(UOM)                                                                                                                                                                                                                                            ','IvmUnitsOfMeasurement.jsp')
MyMenu.makeMenu('2050200580','2000000243','Conversion Factor Master                                                                                                                                                                                                                             ','IvmConversionFactorsMst.jsp')
MyMenu.makeMenu('2000000511','2000000243','ABC Class Parameter Master                                                                                                                                                                                                                            ','IvmABCClassMaster.jsp')
MyMenu.makeMenu('2000000244','','Material Requisition                                                                                                                                                                                                                                  ')
MyMenu.makeMenu('2000000515','2000000244','Material Requisition                                                                                                                                                                                                                                  ','IvmMaterialRequisition.jsp')

MyMenu.makeMenu('2000000245','','Receipts and Inspections                                                                                                                                                                                                                                       ')
MyMenu.makeMenu('2000200646','2000000245','Consignment Register                                                                                                                                                                                                                                  ','IvmConsignmentRegister.jsp')
MyMenu.makeMenu('2000200641','2000000245','Material Inward Register(MIR)                                                                                                                                                                                                                                                   ','IvmPrepareMirDtl.jsp')
MyMenu.makeMenu('2000000518','2000000245','Inspection Register                                                                                                                                                                                                                                   ','IvmInspectionRegister.jsp')
MyMenu.makeMenu('2000000246','','Stores Transactions                                                                                                                                                                                                                                            ')
MyMenu.makeMenu('2000000519','2000000246','Goods Receipt Sheet (GRS)                                                                                                                                                                                                                             ','IvmGoodsReceiptSheet.jsp')
MyMenu.makeMenu('2000000520','2000000246','Material Issue Note (MIN)                                                                                                                                                                                                                             ','IvmMaterialIssueNote.jsp')
MyMenu.makeMenu('2000000521','2000000246','Material Return Note (MRN)                                                                                                                                                                                                                            ','IvmMaterialReturnNote.jsp')
MyMenu.makeMenu('2000000522','2000000246','Stores Transfer Note - In (STN-IN)                                                                                                                                                                                                                    ','IvmStoresTransferNoteIN.jsp')
MyMenu.makeMenu('2000000523','2000000246','Stores Transfer Note - Out (STN-OUT)                                                                                                                                                                                                                  ','IvmStoresTransferNoteOut.jsp')
MyMenu.makeMenu('2000000524','2000000246','Stores Adjustment (SAJ)                                                                                                                                                                                                                               ','IvmPerformStoresAdjustment.jsp')
MyMenu.makeMenu('2050200585','2000000246','Material At Site Register for Sub-Stores(MAS)                                                                                                                                                                                                                           ','IvmMasRegister.jsp')

MyMenu.makeMenu('2000000248','','Scrap Maintenance                                                                                                                                                                                                                                              ')
MyMenu.makeMenu('2000000528','2000000248','Scrap Indentification                                                                                                                                                                                                                                 ','frmScrapIdentification')
MyMenu.makeMenu('2000000532','2000000248','Scrap Return                                                                                                                                                                                                                                          ','frmScrapReturn')
MyMenu.makeMenu('2000000529','2000000248','NIT for Scrap                                                                                                                                                                                                                                         ','frmInviteTenderForScrap')
MyMenu.makeMenu('2000000530','2000000248','Receive Bid for Scrap                                                                                                                                                                                                                                 ','frmScrapBid')
MyMenu.makeMenu('2050200639','2000000248','Generate Comparative Statement for Scrap                                                                                                                                                                                                                       ','frmCompStatementDriverforScrap')
MyMenu.makeMenu('2000000531','2000000248','Letter of Award                                                                                                                                                                                                                                       ','frmLetterOfAward')
MyMenu.makeMenu('2000000250','','Challan                                                                                                                                                                                                                                                        ')
MyMenu.makeMenu('2000000551','2000000250','Challan                                                                                                                                                                                                                                               ','frmChallan')
MyMenu.makeMenu('2000000247','','Inventory Control                                                                                                                                                                                                                                              ')
MyMenu.makeMenu('2000000526','2000000247','ABC Analysis (Consumption Value Wise)                                                                                                                                                                                                                          ','frmABCBatch')
MyMenu.makeMenu('2000301030','2000000247','ABC Analysis (Unit Value Wise)                                                                                                                                                                                                                                 ','frmABCBatchUnitValWise')
MyMenu.makeMenu('2000000527','2000000247','FSN Analysis                                                                                                                                                                                                                                                   ','frmFSNInfo')
MyMenu.makeMenu('2050200591','2000000247','Generate Automatic Purchase Requisition                                                                                                                                                                                                                        ','frmAutoPI')
MyMenu.makeMenu('2000301026','2000000247','Perpetual Inventory                                                                                                                                                                                                                                            ','frmPerpetualInventory')
MyMenu.makeMenu('2000000249','','MIS Reports                                                                                                                                                                                                                                                    ')
MyMenu.makeMenu('2000000533','2000000249','Print ABC Report                                                                                                                                                                                                                                               ','frmABCReport')
MyMenu.makeMenu('2000000534','2000000249','Print List Of Issues Report                                                                                                                                                                                                                                    ','frmLOIDriver')
MyMenu.makeMenu('2000000536','2000000249','Print Inventory Head Wise Summary of Receipts                                                                                                                                                                                                                  ','frmGRNoReport')
MyMenu.makeMenu('2000000550','2000000249','Print Work Order wise Issue Report                                                                                                                                                                                                                             ','frmLOIWorkOrderWiseReport')
MyMenu.makeMenu('2000000537','2000000249','Print Material Issued to Contractor Report                                                                                                                                                                                                                     ','frmMtlIssuedContractorsReport')
MyMenu.makeMenu('2000000538','2000000249','Print Stock Position Report                                                                                                                                                                                                                                    ','frmStockPositionReport')
MyMenu.makeMenu('2000000539','2000000249','Print Supply Order Wise Receipt Report                                                                                                                                                                                                                         ','frmSuppOrderWiseReceiptsReport')
MyMenu.makeMenu('2000000541','2000000249','Print Cost Centre wise list of Issue Report                                                                                                                                                                                                                    ','frmLOICostCentreWiseReport')
MyMenu.makeMenu('2000000542','2000000249','Print List of Notional GRS Report                                                                                                                                                                                                                              ','frmListOfNotionalGRS')
MyMenu.makeMenu('2000000546','2000000249','Print Consolidated Inventory Headwise Summary Report                                                                                                                                                                                                           ','frmAcctWiseIssueSummaryReport')
MyMenu.makeMenu('2000000544','2000000249','Print Abstract Summary of Contractors Report                                                                                                                                                                                                                   ','frmContractorSummaryReport')
MyMenu.makeMenu('2000000545','2000000249','Print Bin Card Updation Report                                                                                                                                                                                                                                 ','frmBinCardUpdReport')
MyMenu.makeMenu('2000000543','2000000249','Print Summary of Issues Acct Head-wise                                                                                                                                                                                                                         ','frmInvHdWiseIssueFigOfAcctHdReport')
MyMenu.makeMenu('2000000547','2000000249','Print Consolidated Receipts & issues Summary Report                                                                                                                                                                                                            ','frmTxnSummaryReport')
MyMenu.makeMenu('4002000561','2000000249','Print Document Flow Details Report                                                                                                                                                                                                                             ','frmShowDocDetails')
MyMenu.makeMenu('4002000570','2000000249','Print Tag No Report                                                                                                                                                                                                                                            ','frmGenerateTagNoReport')
MyMenu.makeMenu('2050200586','2000000249','Print MAS Register                                                                                                                                                                                                                                             ','frmMASReport')
MyMenu.makeMenu('2050200587','2000000249','Material Ageing Report                                                                                                                                                                                                                                         ','frmMaterialAgeingReport')
MyMenu.makeMenu('2000200698','2000000249','Print Store Adjustment Report                                                                                                                                                                                                                                  ','frmStoreAdjstmntTxnRpt')
MyMenu.makeMenu('2000200699','2000000249','Print Issue Report                                                                                                                                                                                                                                             ','frmGroupWiseIssueRpt')
MyMenu.makeMenu('2000300789','2000000249','Print Supply Order Wise GRN Report                                                                                                                                                                                                                             ','frmGRNWiseRpt')
MyMenu.makeMenu('2000301017','2000000249','Print Re-Order Level Report                                                                                                                                                                                                                                    ','frmReorderLevelReport')
MyMenu.makeMenu('2000301018','2000000249','Print Unused Items YearWise                                                                                                                                                                                                                                    ','frmUnsedItemDtl')
MyMenu.makeMenu('2000301023','2000000249','Print GR Wise Indents                                                                                                                                                                                                                                          ','frmReceiptWiseIndentReport')
MyMenu.makeMenu('2000301028','2000000249','Print FSN Report                                                                                                                                                                                                                                               ','frmFSNReportFinal')
MyMenu.makeMenu('2050200253','','Schema Viewer                                                                                                                                                                                                                                                  ')
MyMenu.makeMenu('2050200592','2050200253','View Material Schema                                                                                                                                                                                                                                           ','frmSchemaViewer')



//Leave this line - it constructs the menu
MyMenu.construct()		

//MyMenu.showsub("top3")
MyMenu.hidesub()

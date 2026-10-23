import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.ebay.sdk.*;
import com.ebay.sdk.pictureservice.*;
import com.ebay.soap.eBLBaseComponents.*;
import java.text.*;  
import com.ebay.sdk.helper.ShippingServiceSelector;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.SdkProxySelector;
import com.ebay.sdk.helper.Utils;
import com.ebay.sdk.call.GetSellerTransactionsCall;




public class ebay_import_sales extends JFrame {

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


private ApiContext apiContext = new ApiContext();

JTable tblTransactions = new JTable();

JTextField txtModTimeFrom = new JTextField();
JTextField txtModTimeTo = new JTextField();

final static String[] colNames = nm.db_string;
final static int totalColumns = colNames.length;

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

Boolean yes_has_more_pages = true;

//int response;
int page_number_to_get = 1; 
int ix2 = 0;






public ebay_import_sales() {//*********************************************************************************************


	super("eBay Import Sales");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	//setDefaultLookAndFeelDecorated(false);
	//setUndecorated(true);


	//load images from JAR
	Image ximagex1 = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex1);

	Image ximagex2 = new ImageIcon(this.getClass().getResource("images/ebay.png")).getImage();
	Icon aicon = new ImageIcon(ximagex2);

	infox0.setPreferredSize(new Dimension(320, 80));
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 1.2.1");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("item number: ");
	infox1.setForeground(nm.whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(nm.blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("item number: ");
	infox2.setForeground(nm.whitex);
	infox2.setOpaque(true); 
	infox2.setBackground(nm.blackx);


	BackgroundPanel bkp = new BackgroundPanel();
	bkp.setPreferredSize(new Dimension(340, 140));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(nm.blackx);
	bkp.setForeground(nm.whitex);

	//bkp.add(txtModTimeFrom);
	//bkp.add(txtModTimeTo);

	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);



	Container cp = getContentPane();
	cp.add(bkp);



	if (!nm.run_silent) {setVisible(true);}
	else {System.out.println("RUN SILENT");}


	//get_fees_here();


	System.out.println("Start import of ebay");

	try {

		loadConfiguration();

		try {

			ix2 = Integer.parseInt(nm.carbon[5][ebay_settings.sales_days_past_xx][nm.current_submit_item_a]);

		} catch (Exception e) {ix2 = 31;}

		if (ix2 < 29) {

			GuiUtil.setTimeFilterFields(ix2, this.txtModTimeFrom, this.txtModTimeTo);

		}//**********
		else {GuiUtil.setTimeFilterFields(29, this.txtModTimeFrom, this.txtModTimeTo);}




		page_number_to_get = 1;

		while (yes_has_more_pages) {//***************

			call_ebay_transactions();
			System.out.println();
			System.out.println(" GO TO NEXT PAGE");
			System.out.println();
			page_number_to_get++;

		}//****************************************


	} catch (Exception e) {System.out.println("error 0009870980"); e.printStackTrace();}

	pullThePlug();

}//*************************






	static String[] transactionToColumns(TransactionType trans){

		System.out.println("S T A R T");

    	String[] cols = new String[totalColumns];
    	int i = 0;

    	if (trans.getTransactionID() != null) {cols[i++] = trans.getTransactionID();}
    	else {cols[i++] = "Sale ID IS NULL";}    

    	AddressType shippingAddress = trans.getBuyer().getBuyerInfo().getShippingAddress();

    	if (shippingAddress.getStreet1() != null && shippingAddress.getStreet2() != null) {cols[i++] = shippingAddress.getStreet1() + ", " + shippingAddress.getStreet2();} 
    	else if (shippingAddress.getStreet1() != null) {cols[i++] = shippingAddress.getStreet1();} 
    	else {cols[i++] = " ";}

   		if (shippingAddress.getCityName() != null) {cols[i++] = shippingAddress.getCityName();} else{cols[i++] = " ";}
   		if (shippingAddress.getStateOrProvince() != null) {cols[i++] = shippingAddress.getStateOrProvince();} else{cols[i++] = " ";}
    	if (shippingAddress.getPostalCode() != null) {cols[i++] = shippingAddress.getPostalCode();} else{cols[i++] = " ";}
    	if (shippingAddress.getCountryName() != null) {cols[i++] = shippingAddress.getCountryName();} else{cols[i++] = " ";}

    	UserType buyer = trans.getBuyer();
    	cols[i++] = buyer == null ? "" : buyer.getUserID();
    	cols[i++] = trans.getBuyer().getEmail();

    	if (shippingAddress.getName() != null) {cols[i++] = shippingAddress.getName();} else{cols[i++] = " ";}
    	if (trans.getBuyerCheckoutMessage() != null) {cols[i++] = trans.getBuyerCheckoutMessage();} else{cols[i++] = " ";}
    	if (shippingAddress.getPhone() != null) {cols[i++] = shippingAddress.getPhone();} else{cols[i++] = " ";}

    	if (trans.getAmountPaid().getCurrencyID() != null) {cols[i++] = trans.getAmountPaid().getCurrencyID().toString();}
    	else {cols[i++] = new String("NULL Currency ID");}
    
    	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss.SSS");// HH:mm:ss.SSS
    	ExternalTransactionType[] externalTransactions = trans.getExternalTransaction();
    	cols[i++] = dateFormatter.format(externalTransactions[0].getExternalTransactionTime().getTime());

    	String itemID = trans.getItem().getItemID();
    	cols[i++] = itemID == null ? "" : itemID;

    	Double dd = (double) 0.00;
    	if (trans.getFinalValueFee() != null) {

    		AmountType finalValueFee = trans.getFinalValueFee();
    		dd = finalValueFee.getValue();
    		System.out.println("eBay Fees " + (new Double(finalValueFee.getValue())).toString());

    	}//**********************************
    	else {System.out.println("NULL FINAL VALUE FEE");}
    	System.out.println("eBay Fees e-mail " + dd);

    	cols[i++] = Double.toString(dd);//ebay

    	cols[i++] = Double.toString(externalTransactions[0].getFeeOrCreditAmount().getValue() + dd);//paypal

    	if (trans.getTransactionPrice() != null) {cols[i++] = "" + trans.getTransactionPrice().getValue();} else {cols[i++] = "0.00";}

   		if (trans.getItem().getSKU() != null) {cols[i++] = trans.getItem().getSKU();}
    	else {cols[i++] = "NULL PART NUMBER";}

    	//BuyerPaymentMethodCodeType[] paymentMethod = trans.getPaymentMethods();
    	cols[i++] = new String("PayPal");

    	cols[i++] = Double.toString(externalTransactions[0].getFeeOrCreditAmount().getValue());

    	cols[i++] = trans.getQuantityPurchased().toString();

    	if (Double.toString(trans.getShippingDetails().getSalesTax().getSalesTaxAmount().getValue()) != null) {cols[i++] = Double.toString(trans.getShippingDetails().getSalesTax().getSalesTaxAmount().getValue());}

    	cols[i++] = Double.toString(trans.getShippingServiceSelected().getShippingServiceCost().getValue());

    	cols[i++] = trans.getItem().getTitle();

    	AmountType amt = trans.getAmountPaid();
    	cols[i++] = amt == null ? "" : (new Double(amt.getValue())).toString();
    	//System.out.println("XXXXXXXXXXX " + (new Double(amt.getValue())).toString());

    	cols[i++] = externalTransactions[0].getExternalTransactionID();

    	ShippingDetailsType shippingDetails = trans.getShippingDetails();
    	ShippingServiceOptionsType [] sso = shippingDetails.getShippingServiceOptions();
    	int size = sso != null ? sso.length : 0;
    	cols[i++] = new Integer(size).toString();

    	InternationalShippingServiceOptionsType [] isso = shippingDetails.getInternationalShippingServiceOption();
    	size = isso != null ? isso.length : 0;
    	cols[i++] = new Integer(size).toString();

    	Boolean insuranceWanted = shippingDetails.isInsuranceWanted();
    	if (insuranceWanted != null) {cols[i] = insuranceWanted.toString();}

    	cols[i++] = Utils.booleanToYesNo(trans.isBestOfferSale());

    	cols[i++] = trans.getItem().getQuantity().toString();

		System.out.println("E N D");

  		return cols;

 	}//*****************************************************************







	boolean test_sale(String sale_id) {


		String xgetx = Integer.toString(nm.current_submit_item_a) + sale_id;

		boolean new_sale_yes = false;


		int ixtest3 = 0;
		int ixtest4 = 0;

		try {

			//see if item is already imported in the sales db
			for (int xloopx2 = 0; xloopx2 < nm.carbon[2][nm.sale_id_xx].length; xloopx2++) {//***************

				ixtest3 = 0;
				//System.out.println(xloopx2 + " " + nm.carbon[2][nm.sale_id_xx].length + " " + nm.carbon[2][nm.sale_id_xx][xloopx2]);
				ixtest4 = xgetx.indexOf(nm.carbon[2][nm.sale_id_xx][xloopx2]);
				if (ixtest4 > -1 || xgetx.length() < 3) {

					ixtest3++; 
					System.out.println(" 77 " + nm.carbon[2][nm.sale_id_xx][xloopx2]); 
					break;

				}//**********************************

			}//for*****************************************************************************************
			//see if item is already imported

		} catch (Exception e) {ixtest3 = 0;}


		try {

			//see if item is already imported in the archived db
			for (int xloopx2 = 0; xloopx2 < nm.jdb_load_sales_ids.length; xloopx2++) {//***************

				ixtest4 = 0;
				//System.out.println(xloopx2 + " " + nm.jdb_load_sales_ids[xloopx2] + " " + nm.jdb_load_sales_ids[xloopx2]);
				int ix5 = xgetx.indexOf(nm.jdb_load_sales_ids[xloopx2]);

				if (ix5 > -1 || xgetx.length() < 3) {

					ixtest4++; 
					System.out.println(" 88 " + nm.jdb_load_sales_ids[xloopx2]); 
					break;

				}//**********************************

			}//for*****************************************************************************************
			//see if item is already imported in the archived

		} catch (Exception e) {ixtest4 = 0;}



		//only import inventoried sales if requested.
		try {

			if (nm.carbon[5][etsy_settings.import_everything_xx][nm.current_submit_item_a].equals("1") && ixtest3 == 0) {

				String cx0 = "-1";
				System.out.println(cx0);

				for (int xloopx1 = 1; xloopx1 < (nm.carbon[0][0].length); xloopx1++) {//***************

					if (ixtest3 == 0) {ixtest3 = 2;}

					//System.out.println(nm.carbon[0][nm.part_number_xx][xloopx1]);
					if (cx0.equals(nm.carbon[0][nm.part_number_xx][xloopx1])) {

						ixtest3 = 0; 
						break;

					}//*********************************************************

				}//**********************************************************************************

			}//if***************************************************

		} catch (Exception e) {e.printStackTrace();}



		System.out.println("xx working " + ixtest3 + " " + ixtest4);

		if (ixtest3 == 0 && ixtest4 == 0) {

			new_sale_yes = true;

		}//********************************

		return new_sale_yes;

	}//*********************






	public void call_ebay_transactions() {//************************************************************************************

		String temp0 = new String("0.01");
		String temp1 = new String("0.00");
		String temp2 = new String("1");
		String temp3 = new String("10");
		String temp4 = new String("5");
		String temp5 = new String("5");
		String temp6 = new String("0.00");

		String temp8 = new String("");

		String custom_temp1 = new String();
		String custom_temp2 = new String();
		String custom_temp3 = new String();
		String custom_temp4 = new String();
		String custom_temp5 = new String();
		String custom_temp6 = new String();
		String custom_temp7 = new String();
		String custom_temp8 = new String();
		String custom_temp9 = new String();
		String custom_temp10 = new String();
		String custom_temp11 = new String();
		String custom_temp12 = new String();
		String custom_temp13 = new String();
		String custom_temp14 = new String();
		String custom_temp15 = new String();
		String custom_temp16 = new String();
		String custom_temp17 = new String();
		String custom_temp18 = new String();
		String custom_temp19 = new String();
		String custom_temp20 = new String();
		String custom_temp21 = new String();
		String custom_temp22 = new String();
		String custom_temp23 = new String();
		String custom_temp24 = new String();
		String custom_temp25 = new String();
		String custom_temp26 = new String();
		String custom_temp27 = new String();
		String custom_temp28 = new String();
		String custom_temp29 = new String();
		String custom_temp30 = new String();
		String custom_temp31 = new String();
		String custom_temp32 = new String();
		String custom_temp33 = new String();
		String custom_temp34 = new String();
		String custom_temp35 = new String();
		String custom_temp36 = new String();
		String custom_temp37 = new String();
		String custom_temp38 = new String();
		String custom_temp39 = new String();
		String custom_temp40 = new String();
		String custom_temp41 = new String();
		String custom_temp42 = new String();
		String custom_temp43 = new String();
		String custom_temp44 = new String();
		String custom_temp45 = new String();
		String custom_temp46 = new String();

		String total_on_hand_now = "000";

		try {

    		infox1.setText("Import Sales Page(" + Integer.toString(page_number_to_get) + ")");
    		infox2.setText("start");


    		GetSellerTransactionsCall api = new GetSellerTransactionsCall(this.apiContext);
    		DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {DetailLevelCodeType.RETURN_ALL,};

    		api.setDetailLevel(detailLevels);


			try {

				ix2 = Integer.parseInt(nm.carbon[5][ebay_settings.sales_days_past_xx][nm.current_submit_item_a]);

			} catch (Exception e) {}

			//build custom dates
			if (nm.carbon[5][ebay_settings.sales_days_past_xx][nm.current_submit_item_a].contains("-")) {

				//     yyyy mm dd
				String cx0 = nm.carbon[5][ebay_settings.sales_days_past_xx][nm.current_submit_item_a] + "-01 22:25:06";
				String cx1 = nm.carbon[5][ebay_settings.sales_days_past_xx][nm.current_submit_item_a] + "-30 22:25:06";

				this.txtModTimeFrom.setText(cx0);
				this.txtModTimeTo.setText(cx1);

			}//if ix2 > 29




    		TimeFilter tf = GuiUtil.getTimeFilterFromFields(this.txtModTimeFrom, this.txtModTimeTo);

    		System.out.println(this.txtModTimeFrom.getText() + " " + this.txtModTimeTo.getText());

    		PaginationType pgn = new PaginationType();
    		System.out.println("get page number " + page_number_to_get);
    		pgn.setPageNumber(page_number_to_get);//new Integer(this.txtPageNumber.getText())
    		pgn.setEntriesPerPage(100);//new Integer(this.txtTransPerPage.getText())

    		api.setPagination(pgn);

			infox2.setText("Loading eBay Sales....");

      		// Call eBay.
      		final TransactionType[] transList = api.getSellerTransactions(tf);

      		PaginationResultType pnresult = api.getPaginationResult();

      		// Display results.
      		infox2.setText(pnresult.getTotalNumberOfEntries().toString());

      		String has_more_pages = api.getHasMoreTransactions() ? "yes" : "no";

      		System.out.println("has more " + has_more_pages);
      		if (has_more_pages.equals("yes")) {yes_has_more_pages = true;} 
      		else {yes_has_more_pages = false;}
     

      		String pagescount = pnresult.getTotalNumberOfPages() == null ? "j" : pnresult.getTotalNumberOfPages().toString();

      		System.out.println("pages " + pagescount);

      		String actualCountTxt = new Integer(api.getReturnedTransactionCountActual()).toString();

      		System.out.println("count " + actualCountTxt);

      		final int row = Integer.parseInt(actualCountTxt);

      		if (actualCountTxt.equals("0")) {System.out.println("NO SALES"); pullThePlug();}

			String xgetx = new String();

			int carbon_items = 0;
			TransactionType trans;
			//carbon_items = 0;


			//import items
			for (int loop1 = 0; loop1 < row; loop1++) {//***********************************************************************************
				
				System.out.println("row " + row);
				infox2.setText("Import item: " + (loop1 + 1) + " of " + row);
				System.out.println("Import item: " + (loop1 + 1) + " of " + row);

				trans = transList[loop1];
				System.out.println("Import itemx: " + (loop1 + 1) + " of " + row);

				try {

					xgetx = ebay_import_sales.transactionToColumns(trans)[0];
					System.out.println("Import itemx1: " + (loop1 + 1) + " of " + row);

				} catch (Exception e) {System.out.println("DDXXDD " + e.getMessage());}


				try {

					for (int loop = 0; loop < 23; loop++) {//***************

						System.out.println("DD>>>>>>>>>>>>>>  " + loop + " " + ebay_import_sales.transactionToColumns(trans)[loop]);

					}//for************************************************

				} catch (Exception e) {System.out.println("DDXXDDLOOP " + e.getMessage());}
				//System.exit(0);


				int ixtest3 = 0;
				int ixtest4 = 0;


				//see if item is already imported in the sales db
				for (int xloopx2 = 0; xloopx2 < nm.carbon[2][nm.sale_id_xx].length; xloopx2++) {//***************

					ixtest3 = 0;
					//System.out.println(xloopx2 + " " + nm.carbon[2][nm.sale_id_xx].length + " " + nm.carbon[2][nm.sale_id_xx][xloopx2]);
					ixtest4 = xgetx.indexOf(nm.carbon[2][nm.sale_id_xx][xloopx2]);

					if (ixtest4 > -1 || xgetx.length() < 3) {ixtest3++; System.out.println(" 77 " + nm.carbon[2][nm.sale_id_xx][xloopx2]); break;}

				}//for*****************************************************************************************
				//see if item is already imported



				try {

					//see if item is already imported in the archived db
					for (int xloopx2 = 0; xloopx2 < nm.jdb_load_sales_ids.length; xloopx2++) {//*************

						ixtest4 = 0;
						//System.out.println(xloopx2 + " " + nm.jdb_load_sales_ids[xloopx2] + " " + nm.jdb_load_sales_ids[xloopx2]);
						int ix5 = xgetx.indexOf(nm.jdb_load_sales_ids[xloopx2]);

						if (ix5 > -1 || xgetx.length() < 3) {ixtest4++; System.out.println(" 88 " + nm.jdb_load_sales_ids[xloopx2]); break;}

					}//for***********************************************************************************

					//see if item is already imported in the archived

				} catch (Exception e) {System.exit(0);}




				//only import inventoried sales if requested.
				try {

					String cx0 = "";

					//some items from ebay could be missing info.
					try {

						cx0 = ebay_import_sales.transactionToColumns(trans)[17];

					} catch (Exception e) {e.printStackTrace(); ixtest3 = 1;}


					if (nm.carbon[5][ebay_settings.import_everything_xx][nm.current_submit_item_a].equals("1") && ixtest3 == 0) {

						System.out.println(cx0);

 						for (int xloopx1 = 1; xloopx1 < (nm.carbon[0][0].length); xloopx1++) {//***************

 							if (ixtest3 == 0) {ixtest3 = 2;}
							//System.out.println(nm.carbon[0][nm.part_number_xx][xloopx1]);
 							if (cx0.equals(nm.carbon[0][nm.part_number_xx][xloopx1])) {ixtest3 = 0; break;}//******

 						}//**********************************************************************************

					}//if***************************************************

				} catch (Exception e) {e.printStackTrace();}




				System.out.println("xx working " + ixtest3 + " " + ixtest4);


				if (ixtest3 == 0 && ixtest4 == 0) {//*************************************************************ix3 == 0 && ix4 == 0

					System.out.println("working");

					//add to database
					
					String[] sale_xn = new String[nm.db_cc_number];


					for (int xloopx1 = 0; xloopx1 < 1; xloopx1++) {//***************


						//get the item from inventory 
						String[] loaditem = new String[nm.db_cc_number];
						jdb_loader_item invx = new jdb_loader_item();
						loaditem = invx.getSku(ebay_import_sales.transactionToColumns(trans)[17]);

						System.out.println(loaditem[nm.part_number_xx]);


						if (ebay_import_sales.transactionToColumns(trans)[17].equals(loaditem[nm.part_number_xx])) {

							//quantity

							try {

								total_on_hand_now = "000";
								loaditem[nm.total_on_hand_xx] = Integer.toString( Integer.parseInt(loaditem[nm.total_on_hand_xx]) - Integer.parseInt(ebay_import_sales.transactionToColumns(trans)[20]) );
								total_on_hand_now = loaditem[nm.total_on_hand_xx];

							} catch (Exception e) {System.out.println("Quantity update failed."); JOptionPane.showMessageDialog(null,"Quantity update failed.");}


							//update the item page if this item is there
							for (int xloopx2 = 0; xloopx2 < nm.carbon[0][0].length; xloopx2++) {//***************

								if (ebay_import_sales.transactionToColumns(trans)[17].equals(nm.carbon[0][nm.part_number_xx][xloopx2])) {

									nm.carbon[0][nm.total_on_hand_xx][xloopx2] = loaditem[nm.total_on_hand_xx];

								}//******************************************************************************************************

							}//********************************************************************************



							temp1 = loaditem[nm.item_cost_xx];
							temp2 = loaditem[nm.item_weight_xx];
							temp3 = loaditem[nm.package_d_xx];
							temp4 = loaditem[nm.package_l_xx];
							temp5 = loaditem[nm.package_w_xx];
							temp6 = loaditem[nm.shipping_out_xx];

							temp8 = loaditem[nm.shipping_company_xx];

							custom_temp1 = loaditem[nm.custom_1_xx];
							custom_temp2 = loaditem[nm.custom_2_xx];
							custom_temp3 = loaditem[nm.custom_3_xx];
							custom_temp4 = loaditem[nm.custom_4_xx];
							custom_temp5 = loaditem[nm.custom_5_xx];
							custom_temp6 = loaditem[nm.custom_6_xx];
							custom_temp7 = loaditem[nm.custom_7_xx];
							custom_temp8 = loaditem[nm.custom_8_xx];
							custom_temp9 = loaditem[nm.custom_9_xx];
							custom_temp10 = loaditem[nm.custom_10_xx];
							custom_temp11 = loaditem[nm.custom_11_xx];
							custom_temp12 = loaditem[nm.custom_12_xx];
							custom_temp13 = loaditem[nm.custom_13_xx];
							custom_temp14 = loaditem[nm.custom_14_xx];
							custom_temp15 = loaditem[nm.custom_15_xx];
							custom_temp16 = loaditem[nm.custom_16_xx];
							custom_temp17 = loaditem[nm.custom_17_xx];
							custom_temp18 = loaditem[nm.custom_18_xx];
							custom_temp19 = loaditem[nm.custom_19_xx];
							custom_temp20 = loaditem[nm.custom_20_xx];
							custom_temp21 = loaditem[nm.custom_21_xx];
							custom_temp22 = loaditem[nm.custom_22_xx];
							custom_temp23 = loaditem[nm.custom_23_xx];
							custom_temp24 = loaditem[nm.custom_24_xx];
							custom_temp25 = loaditem[nm.custom_25_xx];
							custom_temp26 = loaditem[nm.custom_26_xx];
							custom_temp27 = loaditem[nm.custom_27_xx];
							custom_temp28 = loaditem[nm.custom_28_xx];
							custom_temp29 = loaditem[nm.custom_29_xx];
							custom_temp30 = loaditem[nm.custom_30_xx];
							custom_temp31 = loaditem[nm.custom_31_xx];
							custom_temp32 = loaditem[nm.custom_32_xx];
							custom_temp33 = loaditem[nm.custom_33_xx];
							custom_temp34 = loaditem[nm.custom_34_xx];
							custom_temp35 = loaditem[nm.custom_35_xx];
							custom_temp36 = loaditem[nm.custom_36_xx];
							custom_temp37 = loaditem[nm.custom_37_xx];
							custom_temp38 = loaditem[nm.custom_38_xx];
							custom_temp39 = loaditem[nm.custom_39_xx];
							custom_temp40 = loaditem[nm.custom_40_xx];
							custom_temp41 = loaditem[nm.custom_41_xx];
							custom_temp42 = loaditem[nm.custom_42_xx];
							custom_temp43 = loaditem[nm.custom_43_xx];
							custom_temp44 = loaditem[nm.custom_44_xx];
							custom_temp45 = loaditem[nm.custom_45_xx];
							custom_temp46 = loaditem[nm.custom_46_xx];


							break;

						}//*****************************************************************************************************
						else {

							//JOptionPane.showMessageDialog(null,"Cannot match item to inventory.");

							temp0 = "0.01";
							temp1 = "0.00";
							temp2 = "1";
							temp3 = "10";
							temp4 = "5";
							temp5 = "5";
							temp6 = "0.00";

						}//**

					}//**********************************************************************************


					//quantity more cost more
					try {

						temp0 = Float.toString(Float.parseFloat(ebay_import_sales.transactionToColumns(trans)[16]) * Float.parseFloat(ebay_import_sales.transactionToColumns(trans)[20]));
						temp1 = Float.toString(Float.parseFloat(temp1) * Float.parseFloat(ebay_import_sales.transactionToColumns(trans)[20]));

					} catch (Exception e) {System.out.println("Q M P M"); temp0 = "0.02"; temp1 = "0.02";}


					try {
					
						sale_xn[0]  = new String(ebay_import_sales.transactionToColumns(trans)[1]);
						sale_xn[1]  = new String(ebay_import_sales.transactionToColumns(trans)[2]);
						sale_xn[2]  = new String(ebay_import_sales.transactionToColumns(trans)[3]);
						sale_xn[3]  = new String(ebay_import_sales.transactionToColumns(trans)[4]);
						sale_xn[4]  = new String(ebay_import_sales.transactionToColumns(trans)[5]);
						sale_xn[5]  = new String("");
						sale_xn[6]  = new String(ebay_import_sales.transactionToColumns(trans)[6]);
						sale_xn[7]  = new String(ebay_import_sales.transactionToColumns(trans)[7]);
						sale_xn[8]  = new String(ebay_import_sales.transactionToColumns(trans)[8]);
						sale_xn[9]  = new String("");
						sale_xn[10] = new String(ebay_import_sales.transactionToColumns(trans)[9]);
						sale_xn[11] = new String(ebay_import_sales.transactionToColumns(trans)[10]);
						sale_xn[12] = new String(ebay_import_sales.transactionToColumns(trans)[11]);
						sale_xn[13] = new String(custom_temp1);
						sale_xn[14] = new String(custom_temp2);
						sale_xn[15] = new String(custom_temp3);
						sale_xn[16] = new String(custom_temp4);
						sale_xn[17] = new String(custom_temp5);
						sale_xn[18] = new String(custom_temp6);
						sale_xn[19] = new String(custom_temp7);
						sale_xn[20] = new String(custom_temp8);
						sale_xn[21] = new String(custom_temp9);
						sale_xn[22] = new String(custom_temp10);
						sale_xn[23] = new String(custom_temp11);
						sale_xn[24] = new String(custom_temp12);
						sale_xn[25] = new String(custom_temp13);
						sale_xn[26] = new String(custom_temp14);
						sale_xn[27] = new String(custom_temp15);
						sale_xn[28] = new String(custom_temp16);
						sale_xn[29] = new String(custom_temp17);
						sale_xn[30] = new String(custom_temp18);
						sale_xn[31] = new String(custom_temp19);
						sale_xn[32] = new String(custom_temp20);
						sale_xn[33] = new String(custom_temp21);
						sale_xn[34] = new String(custom_temp22);
						sale_xn[35] = new String(custom_temp23);
						sale_xn[36] = new String(custom_temp24);
						sale_xn[37] = new String(custom_temp25);
						sale_xn[38] = new String(custom_temp26);
						sale_xn[39] = new String(custom_temp27);
						sale_xn[40] = new String(custom_temp28);
						sale_xn[41] = new String(custom_temp29);
						sale_xn[42] = new String(custom_temp30);
						sale_xn[43] = new String(custom_temp31);
						sale_xn[44] = new String(custom_temp32);
						sale_xn[45] = new String(custom_temp33);
						sale_xn[46] = new String(custom_temp34);
						sale_xn[47] = new String(custom_temp35);
						sale_xn[48] = new String(custom_temp36);
						sale_xn[49] = new String(custom_temp37);
						sale_xn[50] = new String(custom_temp38);
						sale_xn[51] = new String(custom_temp39);
						sale_xn[52] = new String(custom_temp40);
						sale_xn[53] = new String(custom_temp41);
						sale_xn[54] = new String(custom_temp42);
						sale_xn[55] = new String(custom_temp43);
						sale_xn[56] = new String(custom_temp44);
						sale_xn[57] = new String(custom_temp45);
						sale_xn[58] = new String(custom_temp46);
						sale_xn[59] = new String("custom_template");
						sale_xn[60] = new String(ebay_import_sales.transactionToColumns(trans)[12]);//date_last_modified
						sale_xn[61] = new String(ebay_import_sales.transactionToColumns(trans)[12]);//date_payment_received
						sale_xn[62] = new String(" ");//date_shipped
						sale_xn[63] = new String(ebay_import_sales.transactionToColumns(trans)[12].replace(".000","." + Integer.toString(100 + loop1)));//date_sold
						sale_xn[64] = new String(ebay_import_sales.transactionToColumns(trans)[13]);//ebay_item
						sale_xn[65] = new String(ebay_import_sales.transactionToColumns(trans)[14]);//final_value_fee ebay
						sale_xn[66] = new String("0.0");//handling paypal.
						sale_xn[67] = new String(" ");//hits
						sale_xn[68] = new String(temp1);//item_cost
						sale_xn[69] = new String("item_description");
						sale_xn[70] = new String("item_id");
						sale_xn[71] = new String(temp0);//item_price trans 16
						sale_xn[72] = new String(temp2);//item_weight
						sale_xn[73] = new String("0.05");//listing_fees
						sale_xn[74] = new String(ebay_import_sales.transactionToColumns(trans)[13]);//listing_id
						sale_xn[75] = new String("notes");
						sale_xn[76] = new String(temp3);//package
						sale_xn[77] = new String(temp4);
						sale_xn[78] = new String(temp5);
						sale_xn[79] = new String(ebay_import_sales.transactionToColumns(trans)[17]);//part_number
						sale_xn[80] = new String(ebay_import_sales.transactionToColumns(trans)[18]);//payment_type
						sale_xn[81] = new String(ebay_import_sales.transactionToColumns(trans)[19]);//paypal_fees
						sale_xn[82] = new String(" ");
						sale_xn[83] = new String(ebay_import_sales.transactionToColumns(trans)[20]);//quantity_sold
						sale_xn[84] = new String(ebay_import_sales.transactionToColumns(trans)[0]);//sale id
						sale_xn[85] = new String("Sold");//sale status
						sale_xn[86] = new String(ebay_import_sales.transactionToColumns(trans)[21]);//sales_tax
						sale_xn[87] = new String(temp8);//shipping_company
						sale_xn[88] = new String(ebay_import_sales.transactionToColumns(trans)[22]);//shipping_in
						sale_xn[89] = new String("0.00");//shipping_out
						sale_xn[90] = new String("eBay");
						sale_xn[91] = new String("site_url");
						sale_xn[92] = new String(nm.carbon[5][0][nm.current_submit_item_a]);//source of sale
						sale_xn[93] = new String(ebay_import_sales.transactionToColumns(trans)[23]);//title
						sale_xn[94] = new String("title_url");
						sale_xn[95] = new String(total_on_hand_now);//ebay_import_sales.transactionToColumns(trans)[30]
						sale_xn[96] = new String(ebay_import_sales.transactionToColumns(trans)[24]);//total_sale_amount
						sale_xn[97] = new String(" ");//tracking number
						sale_xn[98] = new String(nm.carbon[5][nm.id_mm][nm.current_submit_item_a]);//transaction_id Integer.toString(nm.current_submit_item_a)
						sale_xn[99] = new String(ebay_import_sales.transactionToColumns(trans)[25]);

					} catch (Exception e) {System.out.println("FFFFFF");}



					// change ship type if quanitity is too high. 
					try {
					
						int ix3 = Integer.parseInt(sale_xn[nm.quantity_sold_xx]);
						int ix4 = Integer.parseInt(nm.carbon[5][ebay_settings.ship_change_quantity_xx][nm.current_submit_item_a]);

						System.out.println(ix3);
						System.out.println(ix4);
						//System.exit(0);

						if (ix3 >= ix4) {

							int ix5 = Integer.parseInt(nm.carbon[5][ebay_settings.ship_change_field_xx][nm.current_submit_item_a]);
							sale_xn[ix5] = nm.carbon[5][ebay_settings.ship_change_type_xx][nm.current_submit_item_a];

						}//************

					} catch (Exception e) {System.out.println("Quantity ship type failed.");}



					//change ship type if quanitity is too high2. 
					try {

						int ix3 = Integer.parseInt(sale_xn[nm.quantity_sold_xx]);
						int ix4 = Integer.parseInt(nm.carbon[5][ebay_settings.ship_change_quantity_xx2][nm.current_submit_item_a]);

						System.out.println(ix3);
						System.out.println(ix4);
						//System.exit(0);

						if(ix3 >= ix4){

							int ix5 = Integer.parseInt(nm.carbon[5][ebay_settings.ship_change_field_xx2][nm.current_submit_item_a]);
							sale_xn[ix5] = nm.carbon[5][ebay_settings.ship_change_type_xx2][nm.current_submit_item_a];

						}//************

					} catch (Exception e) {System.out.println("Quantity ship type2 failed.");}



					//change ship type if weight is too high. 
					try {

						int ix3 = Integer.parseInt(sale_xn[nm.quantity_sold_xx]);
						int ix4 = Integer.parseInt(sale_xn[nm.item_weight_xx]);
						int ix5 = Integer.parseInt(nm.carbon[5][ebay_settings.ship_weight_change_quantity_xx][nm.current_submit_item_a]);

						System.out.println(ix3);
						System.out.println(ix4);
						System.out.println((ix3 * ix4) + " " + ix5);
						//System.exit(0);

						if ((ix3 * ix4) > ix5) {

							System.out.println("yes change");
							ix5 = Integer.parseInt(nm.carbon[5][ebay_settings.ship_weight_change_field_xx][nm.current_submit_item_a]);
							sale_xn[ix5] = nm.carbon[5][ebay_settings.ship_weight_change_type_xx][nm.current_submit_item_a];

						}//************

					} catch (Exception e) {System.out.println("Weight ship type failed.");}



					//change ship type if weight is too high. 
					try {

						int ix3 = Integer.parseInt(sale_xn[nm.quantity_sold_xx]);
						int ix4 = Integer.parseInt(sale_xn[nm.item_weight_xx]);
						int ix5 = Integer.parseInt(nm.carbon[5][ebay_settings.ship_weight_change_quantity_xx2][nm.current_submit_item_a]);

						System.out.println(ix3);
						System.out.println(ix4);
						System.out.println((ix3 * ix4) + " " + ix5);
						//System.exit(0);

						if ((ix3 * ix4) > ix5) {

							System.out.println("yes change");
							ix5 = Integer.parseInt(nm.carbon[5][ebay_settings.ship_weight_change_field_xx2][nm.current_submit_item_a]);
							sale_xn[ix5] = nm.carbon[5][ebay_settings.ship_weight_change_type_xx2][nm.current_submit_item_a];

						}//************

					} catch (Exception e) {System.out.println("Weight ship type failed2.");}



					//fix price errors. 
					try {
					
						int ix0 = sale_xn[nm.item_price_xx].indexOf(".");

						if (ix0 > -1) {

							String cx0 = sale_xn[nm.item_price_xx].substring(ix0, sale_xn[nm.item_price_xx].length());

							if (cx0.length() == 2) {sale_xn[nm.item_price_xx] = sale_xn[nm.item_price_xx] + "0";}
							//if(cx0.length() == 3){nm.carbon[2][nm.item_price_xx][1] = nm.carbon[2][nm.item_price_xx][1] + "x";}
							if (cx0.length() > 3) {sale_xn[nm.item_price_xx] = sale_xn[nm.item_price_xx].substring(0, ix0 + 3);}

						}//**********

					} catch (Exception e) {System.out.println("Fix price errors failed.");}



					//fix cost errors. 
					try {

						int ix0 = sale_xn[nm.item_cost_xx].indexOf(".");

						if (ix0 > -1) {

							String cx0 = sale_xn[nm.item_cost_xx].substring(ix0, sale_xn[nm.item_cost_xx].length());

							if(cx0.length() == 2){sale_xn[nm.item_cost_xx] = sale_xn[nm.item_cost_xx] + "0";}
							//if(cx0.length() == 3){sale_xn[nm.item_cost_xx][1] = sale_xn[nm.item_cost_xx][1] + "x";}
							if(cx0.length() > 3){sale_xn[nm.item_cost_xx] = sale_xn[nm.item_cost_xx].substring(0, ix0 + 3);}

						}//**********

					} catch (Exception e) {System.out.println("Fix cost errors failed.");}




					//change wrong country name
					try {

						sale_xn = change_name_country(sale_xn);

					} catch(Exception e) {System.out.println("failed.");}



					//add to database
					jdb_new_sale saves = new jdb_new_sale(sale_xn);


					System.out.println("NND " + sale_xn[84]);

					carbon_items++;


				}//if**************************************************************************************ix3 == 0 && ix4 == 0
				else {System.out.println("getx item already imported.");}//carbon_items++;



			}//for************************************************************************************************************************



		} catch (Exception ex) {

			//System.out.println("XXXXXXXXXXXXX " + nm.carbon[2][84][0]); 
			infox2.setText(ex.getMessage()); yes_has_more_pages = false; 

			if (!nm.run_silent) {JOptionPane.showMessageDialog(null, "einfo " + ex.getMessage());}

		}//*******************


	}//***************************************************************************************************************************








	public String[] change_name_country(String[] update_name) {

		if (update_name[4].equals("USA"))                {update_name[4] = ("United States");}
		if (update_name[4].equals("US"))                 {update_name[4] = ("United States");}
		if (update_name[4].equals("Russian Federation")) {update_name[4] = ("Russia");}
		if (update_name[4].equals("Turkey"))             {update_name[4] = ("Turker");}
		if (update_name[4].equals("Puerto Rico"))        {update_name[4] = ("United States");}
		if (update_name[4].equals("Guam"))               {update_name[4] = ("United States");}
		if (update_name[4].equals("APO/FPO"))            {update_name[4] = ("United States");}
		if (update_name[2].equals("Puerto Rico"))        {update_name[4] = ("PR");}

		return update_name;

	}//*******************************







	public void get_fees_here() {
	
		try {

			ItemType item = new ItemType();
			//item.setItemID(nm.carbon[2][nm.listing_id_xx][nm.what_item]);
			//item.setTransactionID(nm.carbon[2][nm.sale_id_xx][nm.what_item]);

   			ApiCall api = new ApiCall(this.apiContext);

   			// 2. Construct an object of class AddItemRequestType and store an item number
   			// in the Item field.
   			AddItemRequestType req = new AddItemRequestType();
   			req.setItem(item);

   			// 3. Execute the API call.
   			AddItemResponseType resp = (AddItemResponseType)api.execute(req);

   			// 4. Extract the fields you need.
   			FeesType fees = resp.getFees();

			System.out.println("fees " + fees);
			System.exit(0);


		} catch (Exception e) {}

	}//get fees









	public void loadConfiguration() throws Exception{

    	this.apiContext.setApiServerUrl(nm.carbon[5][1][nm.current_submit_item_a]);

    	//this.apiContext.setEpsServerUrl("https://api.sandbox.ebay.com/ws/api.dll");
    	//this.apiContext.setSignInUrl("https://signin.sandbox.ebay.com/ws/eBayISAPI.dll?SignIn");

    	ApiCredential apiCred = new ApiCredential();
    	this.apiContext.setApiCredential(apiCred);

    	ApiAccount ac = new ApiAccount();
    	apiCred.setApiAccount(ac);

    	ac.setDeveloper(ebay_settings.ebay_api_developer);
    	ac.setApplication(ebay_settings.ebay_api_application);
    	ac.setCertificate(ebay_settings.ebay_api_certificate);

    	//ac.setDeveloper("a2e5bb52-b43d-4fad-8db9-2ea2c8c65c06");
    	//ac.setApplication("Alchemis-5458-4dac-ab21-a6ab7bfc1422");
    	//ac.setCertificate("785bafce-f33e-4381-8ef3-e26c2a9d2f72");

    	apiCred.seteBayToken(nm.carbon[5][2][nm.current_submit_item_a]);  
    
    	this.apiContext.setRuName("Alchemist_Devel-Alchemis-5458-4-opowmx");

	    String host = "";//XmlUtil.getChildString(proxy, "Host");
	    String port = "";//XmlUtil.getChildString(proxy, "Port");

	    if (host.length() > 0 && port.length() > 0) {

	    	SdkProxySelector ps = null;
	    	String username = "";//XmlUtil.getChildString(proxy, "Username");
	    	String password = "";//XmlUtil.getChildString(proxy, "Password");

	    	if (username.length() > 0 && password.length() > 0) {

	    		ps = new SdkProxySelector(host, Integer.parseInt(port), username, password);

	    	}//************************************************** 
			else {ps = new SdkProxySelector(host, Integer.parseInt(port));}

	    	ps.register();

	    }//******************************************
    
    
  	}//************************************************************







    public void pullThePlug() {

    	System.out.println("PULL THE PLUG");

    	nm.sales_import_done = true;

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull






	class BackgroundPanel extends JPanel{

	  	Image image;

	  	public BackgroundPanel(){

		    try{

		      	image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3r.jpg"), "background3r.jpg"));

		    }catch (Exception e) { System.out.println("Failed001"); }

	  	}//backgroundpanel

	  	protected void paintComponent(Graphics g){

		    super.paintComponent(g); 

		    if (image != null){

		      	g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);

		  	}
	  
	  	}//paint

	}//jpanel





}//last













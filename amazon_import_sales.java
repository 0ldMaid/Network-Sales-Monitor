import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import com.amazonservices.mws.orders.MarketplaceWebServiceOrdersConfig;
import com.amazonservices.mws.orders.model.MarketplaceIdList;
import com.amazonservices.mws.orders.MarketplaceWebServiceOrders;
import com.amazonservices.mws.orders.MarketplaceWebServiceOrdersClient;
import com.amazonservices.mws.orders.MarketplaceWebServiceOrdersException;
import com.amazonservices.mws.orders.model.Address;
import com.amazonservices.mws.orders.model.ListOrdersRequest;
import com.amazonservices.mws.orders.model.ListOrdersResponse;
import com.amazonservices.mws.orders.model.ListOrdersResult;
import com.amazonservices.mws.orders.model.Money;
import com.amazonservices.mws.orders.model.Order;
import com.amazonservices.mws.orders.model.OrderList;
import com.amazonservices.mws.orders.model.ResponseMetadata;
import com.amazonservices.mws.orders.model.ListOrdersByNextTokenRequest;
import com.amazonservices.mws.orders.model.ListOrdersByNextTokenResponse;
import com.amazonservices.mws.orders.model.ListOrdersByNextTokenResult;
import com.amazonservices.mws.orders.model.ListOrderItemsRequest;
import com.amazonservices.mws.orders.model.ListOrderItemsResponse;
import com.amazonservices.mws.orders.model.ListOrderItemsResult;
import com.amazonservices.mws.orders.model.OrderItem;
import com.amazonservices.mws.orders.model.OrderItemList;
import com.amazonservices.mws.orders.model.PromotionIdList;



public class amazon_import_sales extends JFrame{

	Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
	int xzx = 350;
	int xzy = 150;
	int cenx = (scrSize.width / 2) - (xzx / 2);
	int ceny = (scrSize.height / 2) - (xzy / 2);

	JLabel infox0 = new JLabel("", JLabel.RIGHT);
	JLabel infox1 = new JLabel("Get Orders Request.", JLabel.LEFT);
	JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

	int ix0 = 0;
	int carbon_items = 0;

	String token_id = new String("");

	String temp0 = new String("0.01");
	String temp1 = new String("0.00");
	String temp2 = new String("1");
	String temp3 = new String("10");
	String temp4 = new String("5");
	String temp5 = new String("5");
	String temp6 = new String("0.00");
	String temp7 = new String("0.00");
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

	String currency_code_x = new String("");

	int list_items_number = 0;

	String passx_title[] = new String[100];
	String passx_sku[] = new String[100];
	String passx_price[] = new String[100];
	String passx_sale_price[] = new String[100];
	String passx_quanitity[] = new String[100];
	String passx_shipping_price[] = new String[100];
	String passx_item_tax[] = new String[100];
	String passx_listing_id[] = new String[100];
	String passx_AmazonOrderIdx[] = new String[100];
	String passx_shipped_number[] = new String[100];

	String sellerId = "x";//nm.carbon[5][6][nm.current_submit_item_a]; //"A2IS



	amazon_import_sales(){//*******************************************************************************

		super("Amazon Import Sales");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
		setBackground(Color.black);
		setSize(xzx, xzy);
		setLocation(cenx, ceny);
		setResizable(false);
		setDefaultLookAndFeelDecorated(false);
		setUndecorated(true);


	//load images from JAR
		Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
		setIconImage(ximagex);

		Image ximagex2 = new ImageIcon(this.getClass().getResource("images/amazon.png")).getImage();
		Icon aicon = new ImageIcon(ximagex2);

		infox0.setPreferredSize(new Dimension(320, 80));
		infox0.setBackground(nm.blackx);
		infox0.setForeground(nm.whitex);
		infox0.setOpaque(false);
		infox0.setIcon(aicon);
		infox0.setText("Version 1.1.1");
		infox0.setHorizontalTextPosition(JLabel.LEFT);
		infox0.setIconTextGap(30);

		infox1.setPreferredSize(new Dimension(320, 25));
		infox1.setText("Import from Amazon");
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


		infox2.setText("Get orders....");

		ix0 = 0;

		getorders();


	}//*************************************************************************************




	public void getorders() {

		int has_more_tokens = 0;

		String accessKeyId = nm.carbon[5][2][nm.current_submit_item_a]; 
		String secretAccessKey = nm.carbon[5][3][nm.current_submit_item_a];
		String applicationName = nm.program_name;//"Alchemist";
		String applicationVersion = nm.program_version;//"1.3.4.6";
		sellerId = nm.carbon[5][6][nm.current_submit_item_a]; //"A2IS
		String merchantId = nm.carbon[5][6][nm.current_submit_item_a]; //"A2IS
		String marketplaceId = nm.carbon[5][7][nm.current_submit_item_a]; //"ATV

		System.out.println(accessKeyId);
		System.out.println(secretAccessKey);
		System.out.println(applicationName);
		System.out.println(applicationVersion);
		System.out.println(sellerId);
		System.out.println(marketplaceId);
		System.out.println(merchantId);

        MarketplaceWebServiceOrdersConfig config = new MarketplaceWebServiceOrdersConfig();
    
        List<String> marketplaceIdArrayList = new ArrayList<String>();
        //marketplaceIdArrayList.add(nm.carbon[5][7][nm.current_submit_item_a]);
        marketplaceIdArrayList.add(nm.carbon[5][7][nm.current_submit_item_a]);//ATVPDKIKX0DER

        MarketplaceIdList marketplaceIdList = null;
        marketplaceIdList = new MarketplaceIdList(marketplaceIdArrayList);

        //config.setServiceURL("https://mws.amazonservices.com/Orders/2012-01-01");
        config.setServiceURL(nm.carbon[5][1][nm.current_submit_item_a] + "/Orders/2011-01-01");
        //config.setMaxAsyncThreads(35);

        //Instantiate Http Client Implementation of Marketplace Web Service
        //Orders
        MarketplaceWebServiceOrders service = new MarketplaceWebServiceOrdersClient(accessKeyId, secretAccessKey, applicationName, applicationVersion, config);

        ListOrdersRequest request = new ListOrdersRequest();

        request.setSellerId(merchantId);
        request.setMarketplaceId(marketplaceIdList);


		try {

			Calendar cal = Calendar.getInstance();

			System.out.println(cal.get(Calendar.DATE));
			System.out.println(cal.get(Calendar.MONTH));
			System.out.println(cal.get(Calendar.YEAR));

			try {

				ix0 = (cal.get(Calendar.DATE) - Integer.parseInt(nm.carbon[5][amazon_settings.sales_days_past_xx][nm.current_submit_item_a]));

			} catch (Exception e) {ix0 = (cal.get(Calendar.DATE) - 1);}

			XMLGregorianCalendar mwsDateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar(cal.get(Calendar.YEAR), (cal.get(Calendar.MONTH) + 0), ix0 ));
			request.setCreatedAfter(mwsDateTime); 

		} catch (DatatypeConfigurationException e) {System.out.println(e.getMessage());}


		infox1.setText("ListOrders start....");
		infox2.setText("Get orders start....");
	    invokeListOrders(service, request);

		System.out.println("NEXT ORDER " + token_id);

		infox1.setText("ListOrdersByNextToken start....");
		infox2.setText("Get orders start....");

		while (has_more_tokens > 0) {

			System.exit(0);
			System.out.println("INSIDE");

	        ListOrdersByNextTokenRequest requestx = new ListOrdersByNextTokenRequest();
	        requestx.setSellerId(merchantId);
			requestx.setNextToken(token_id);

			invokeListOrdersByNextToken(service, requestx);


		}//while******************

		pullThePlug();



	}//*********************




    public void invokeListOrders(MarketplaceWebServiceOrders service, ListOrdersRequest request) {


    	try {

			ListOrdersResponse response = service.listOrders(request);

			if (response.isSetListOrdersResult()) {//******************************************************************************

				ListOrdersResult listOrdersResult = response.getListOrdersResult();

				if (listOrdersResult.isSetOrders()) {//********************************************************************

					OrderList orders = listOrdersResult.getOrders();
					java.util.List<Order> orderList = orders.getOrder();


					for (Order order : orderList){//***********************************************************


						if (order.isSetAmazonOrderId()) {//*****************************

							System.out.println("AmazonOrderId " + order.getAmazonOrderId());
							String xgetx = order.getAmazonOrderId();
							infox2.setText("Orders ID " + xgetx);

							try {

								Address shippingAddress = order.getShippingAddress();
										
								if (shippingAddress.isSetName()) {

									Money orderTotal = order.getOrderTotal();
												
									if (orderTotal.isSetAmount()) {



										try {

											passx_sku[0] = "";

											ListOrderItemsRequest request_item = new ListOrderItemsRequest();
											request_item.setSellerId(sellerId);
											request_item.setAmazonOrderId(xgetx);

											invokeListOrderItems(service, request_item);

											System.out.println(list_items_number);
											//if(list_items_number > 1){System.exit(0);}

										} catch(Exception e) {System.out.println("GET ITEM REQUEST FAILED");}

										//*******************************************************************************
										//*******************************************************************************



										int ixtest3 = 0;
										int ixtest4 = 0;

										try {

											//see if item is already imported in the sales db
										
											for (int xloopx2 = 0; xloopx2 < nm.carbon[2][nm.sale_id_xx].length; xloopx2++) {//***************

												ixtest3 = 0;
												ixtest4 = xgetx.indexOf(nm.carbon[2][nm.sale_id_xx][xloopx2]);
        										
        										if (ixtest4 > -1 && nm.carbon[2][nm.sale_status_xx][xloopx2].equals("Shipped")) { 

        											if(passx_shipped_number[0].equals("0")) {

        												nm.carbon[2][nm.sale_status_xx][xloopx2] = "Error"; nm.carbon[2][nm.notes_xx][xloopx2] = "Amazon POST ERROR. Item NOT marked shipped.";

        											}//**************************************

        										}//**************************************************************************

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

											String cx0 = "";

											//some items from amazon could be missing info.
											try {

												cx0 = order.getAmazonOrderId();

											} catch (Exception e) {e.printStackTrace(); ixtest3 = 1;}


											if (nm.carbon[5][amazon_settings.import_everything_xx][nm.current_submit_item_a].equals("1") && ixtest3 == 0) {

												System.out.println(cx0);

 												for (int xloopx1 = 1; xloopx1 < (nm.carbon[0][0].length); xloopx1++) {//***********
 							
 														if (ixtest3 == 0) {ixtest3 = 2;}

														//System.out.println(nm.carbon[0][nm.part_number_xx][xloopx1]);
 														if (cx0.equals(nm.carbon[0][nm.part_number_xx][xloopx1])) {

 															ixtest3 = 0; break;

 														}//********************************************************

 												}//******************************************************************************

											}//if*********************************************************************************************************
							
										} catch (Exception e) {e.printStackTrace();}



										System.out.println("xx working " + ixtest3 + " " + ixtest4);


										if (ixtest3 == 0 && ixtest4 == 0) {//*************************************************************ixtest3 == 0 && ix4 == 0

											System.out.println("working");

											ix0++;
											infox2.setText("Orders count " + Integer.toString(ix0));

											System.out.println(list_items_number);


											for (int x_loop = 0; x_loop < list_items_number; x_loop++) {//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

												String total_on_hand_now = "";


												/**

												String[][] carbonfiber = nm.carbon[2];

												nm.carbon[2] = new String[nm.db_cc_number][(carbonfiber[0].length + 1)];

												int ix6 = 1;
												//ix7 = 0;

												try {//***********************************************

													for (int xloopx1 = 2; xloopx1 < (nm.carbon[2][0].length); xloopx1++) {//*************

														for (int xloopx2 = 0; xloopx2 < nm.db_cc_number; xloopx2++) {//*************

															nm.carbon[2][xloopx2][xloopx1] = carbonfiber[xloopx2][ix6];
															//System.out.println("xx " + xloopx1 + " " + nm.carbon[2][xloopx2][xloopx1]);

														}//*************************************************************************

														ix6++;

													}//**********************************************************************************

												} catch (Exception e) {System.out.println("FFFFFF LOOP");}
	
												**/



												passx_title[x_loop] = new String("null");
												passx_listing_id[x_loop] = new String("null");


												for (int xloopx1 = 0; xloopx1 < 1; xloopx1++) {//***************

													

													//get the item from inventory 
													String[] loaditem = new String[nm.db_cc_number];
													jdb_loader_item invx = new jdb_loader_item();
													loaditem = invx.getSku(passx_sku[x_loop]);

													System.out.println(loaditem[nm.part_number_xx]);


													if (passx_sku[x_loop].equals(loaditem[nm.part_number_xx])) {

														
														//quantity
														try {

															loaditem[nm.total_on_hand_xx] = Integer.toString( Integer.parseInt(loaditem[nm.total_on_hand_xx]) - Integer.parseInt(passx_quanitity[x_loop]) );
															total_on_hand_now = loaditem[nm.total_on_hand_xx];

														} catch (Exception e) {System.out.println("Quantity update failed.");}

														
														//update the item page if this item is there
														for (int xloopx2 = 0; xloopx2 < nm.carbon[0][0].length; xloopx2++) {//***************

															if (passx_sku[x_loop].equals(nm.carbon[0][nm.part_number_xx][xloopx2])) {

																nm.carbon[0][nm.total_on_hand_xx][xloopx2] = loaditem[nm.total_on_hand_xx];

															}//***********************************************************************

														}//**********************************************************************************



														temp1 = loaditem[nm.item_cost_xx];
														temp2 = loaditem[nm.item_weight_xx];
														temp3 = loaditem[nm.package_d_xx];
														temp4 = loaditem[nm.package_l_xx];
														temp5 = loaditem[nm.package_w_xx];
														temp6 = loaditem[nm.shipping_out_xx];
														temp8 = loaditem[nm.shipping_company_xx];

														passx_title[x_loop] = new String(loaditem[nm.title_xx]);
														System.out.println(passx_title[x_loop]);


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


														passx_listing_id[x_loop] = new String(loaditem[nm.listing_id_xx]);

														break;

													}//*****************************************************************************************************
													else {

														temp0 = "0.01";
														temp1 = "0.00";
														temp2 = "1";
														temp3 = "10";
														temp4 = "5";
														temp5 = "5";
														temp6 = "0.00";
														temp8 = "Standard";

													}//**

												}//**********************************************************************************





												//quantity more cost more
												try {

													temp0 = Float.toString(Float.parseFloat(passx_price[x_loop]));// * Float.parseFloat(passx_quanitity)
													temp1 = Float.toString(Float.parseFloat(temp1) * Float.parseFloat(passx_quanitity[x_loop]));
													temp7 = Float.toString((Float.parseFloat(passx_price[x_loop]) * 0.15f)); //amazon fees

													ix0 = temp7.indexOf(".");

													if (ix0 > -1) {

														String cx0 = temp7.substring(0, ix0);
														String cx1 = temp7.substring(ix0, temp7.length());

														if (cx1.length() > 3) {temp7 = cx0 + temp7.substring(ix0, ix0 + 3);}

													}//**********

												} catch (Exception e) {System.out.println("Q M P M"); temp0 = "0.02"; temp1 = "0.02";}


												try {
											
													if (shippingAddress.getAddressLine2() == null) {nm.carbon[2][0][0] = new String("" + shippingAddress.getAddressLine1());}
													else {nm.carbon[2][0][0] = new String("" + shippingAddress.getAddressLine1() + " " + shippingAddress.getAddressLine2());}

													nm.carbon[2][1] [0] = new String("" + shippingAddress.getCity());
													nm.carbon[2][2] [0] = new String("" + shippingAddress.getStateOrRegion());
													nm.carbon[2][3] [0] = new String("" + shippingAddress.getPostalCode());
													nm.carbon[2][4] [0] = new String("" + shippingAddress.getCountryCode());
													nm.carbon[2][5] [0] = new String("");
													nm.carbon[2][6] [0] = new String("" + order.getBuyerName());
													nm.carbon[2][7] [0] = new String("" + order.getBuyerEmail());
													nm.carbon[2][8] [0] = new String("" + shippingAddress.getName());
													nm.carbon[2][9] [0] = new String("");
													nm.carbon[2][10][0] = new String("");
													nm.carbon[2][11][0] = new String("" + shippingAddress.getPhone());
														if(nm.carbon[5][1][nm.current_submit_item_a].equals("https://mws.amazonservices.com")){nm.carbon[2][12][0] = new String("USD");}
														else if(nm.carbon[5][1][nm.current_submit_item_a].equals("https://mws.amazonservices.fr")){nm.carbon[2][12][0] = new String("EUR");}
														else if(nm.carbon[5][1][nm.current_submit_item_a].equals("https://mws.amazonservices.de")){nm.carbon[2][12][0] = new String("EUR");}
														else{nm.carbon[2][12][0] = new String("USD");}
													nm.carbon[2][13][0] = new String(custom_temp1);
													nm.carbon[2][14][0] = new String(custom_temp2);
													nm.carbon[2][15][0] = new String(custom_temp3);
													nm.carbon[2][16][0] = new String(custom_temp4);
													nm.carbon[2][17][0] = new String(custom_temp5);
													nm.carbon[2][18][0] = new String(custom_temp6);
													nm.carbon[2][19][0] = new String(custom_temp7);
													nm.carbon[2][20][0] = new String(custom_temp8);
													nm.carbon[2][21][0] = new String(custom_temp9);
													nm.carbon[2][22][0] = new String(custom_temp10);
													nm.carbon[2][23][0] = new String(custom_temp11);
													nm.carbon[2][24][0] = new String(custom_temp12);
													nm.carbon[2][25][0] = new String(custom_temp13);
													nm.carbon[2][26][0] = new String(custom_temp14);
													nm.carbon[2][27][0] = new String(custom_temp15);
													nm.carbon[2][28][0] = new String(custom_temp16);
													nm.carbon[2][29][0] = new String(custom_temp17);
													nm.carbon[2][30][0] = new String(custom_temp18);
													nm.carbon[2][31][0] = new String(custom_temp19);
													nm.carbon[2][32][0] = new String(custom_temp20);
													nm.carbon[2][33][0] = new String(custom_temp21);
													nm.carbon[2][34][0] = new String(custom_temp22);
													nm.carbon[2][35][0] = new String(custom_temp23);
													nm.carbon[2][36][0] = new String(custom_temp24);
													nm.carbon[2][37][0] = new String(custom_temp25);
													nm.carbon[2][38][0] = new String(custom_temp26);
													nm.carbon[2][39][0] = new String(custom_temp27);
													nm.carbon[2][40][0] = new String(custom_temp28);
													nm.carbon[2][41][0] = new String(custom_temp29);
													nm.carbon[2][42][0] = new String(custom_temp30);
													nm.carbon[2][43][0] = new String(custom_temp31);
													nm.carbon[2][44][0] = new String(custom_temp32);
													nm.carbon[2][45][0] = new String(custom_temp33);
													nm.carbon[2][46][0] = new String(custom_temp34);
													nm.carbon[2][47][0] = new String(custom_temp35);
													nm.carbon[2][48][0] = new String(custom_temp36);
													nm.carbon[2][49][0] = new String(custom_temp37);
													nm.carbon[2][50][0] = new String(custom_temp38);
													nm.carbon[2][51][0] = new String(custom_temp39);
													nm.carbon[2][52][0] = new String(custom_temp40);
													nm.carbon[2][53][0] = new String(custom_temp41);
													nm.carbon[2][54][0] = new String(custom_temp42);
													nm.carbon[2][55][0] = new String(custom_temp43);
													nm.carbon[2][56][0] = new String(custom_temp44);
													nm.carbon[2][57][0] = new String(custom_temp45);
													nm.carbon[2][58][0] = new String(custom_temp46);
													nm.carbon[2][59][0] = new String("custom_template");
													nm.carbon[2][60][0] = new String("" + order.getPurchaseDate().toString().replace("T","-").replace("Z","") + Integer.toString(x_loop));//date_last_modified
													nm.carbon[2][61][0] = new String("" + order.getPurchaseDate().toString().replace("T","-").replace("Z","") + Integer.toString(x_loop));//date_payment_received
													nm.carbon[2][62][0] = new String("");//date_shipped
													nm.carbon[2][63][0] = new String("" + order.getPurchaseDate().toString().replace("T","-").replace("Z","") + ".00" + Integer.toString(x_loop));//date_sold
													nm.carbon[2][64][0] = new String("");//ebay_item
													nm.carbon[2][65][0] = new String("0.00");//final_value_fee ebay
													nm.carbon[2][66][0] = new String("0.00");//handling paypal.
													nm.carbon[2][67][0] = new String("0");//hits
													nm.carbon[2][68][0] = new String(temp1);//item_cost
													nm.carbon[2][69][0] = new String("item_description");
													nm.carbon[2][70][0] = new String("item_id");
													nm.carbon[2][71][0] = new String(temp0);//item_price trans 16
													nm.carbon[2][72][0] = new String(temp2);//item_weight
													nm.carbon[2][73][0] = new String("0.00");//listing_fees
													nm.carbon[2][74][0] = new String("" + passx_listing_id[0]);//listing_id
													nm.carbon[2][75][0] = new String("notes");
													nm.carbon[2][76][0] = new String(temp3);//package
													nm.carbon[2][77][0] = new String(temp4);
													nm.carbon[2][78][0] = new String(temp5);
													nm.carbon[2][79][0] = new String("" + passx_sku[x_loop]);//part_number
													nm.carbon[2][80][0] = new String("Amazon");//payment_type
													nm.carbon[2][81][0] = new String(temp7);//paypal_fees
													nm.carbon[2][82][0] = new String("picture_1");
													nm.carbon[2][83][0] = new String("" + passx_quanitity[x_loop]);//quantity_sold
													nm.carbon[2][84][0] = new String("" + order.getAmazonOrderId());//sale id
													nm.carbon[2][85][0] = new String("Sold");//sale status
													nm.carbon[2][86][0] = new String("" + passx_item_tax[x_loop]);//sales_tax
													nm.carbon[2][87][0] = new String(temp8);//shipping_company
													nm.carbon[2][88][0] = new String("" + passx_shipping_price[x_loop]);//shipping_in
													nm.carbon[2][89][0] = new String(temp6);//shipping_out
													nm.carbon[2][90][0] = new String("Amazon");
													nm.carbon[2][91][0] = new String("site_url");
													nm.carbon[2][92][0] = new String("" + nm.carbon[5][0][nm.current_submit_item_a]);//source of sale
													nm.carbon[2][93][0] = new String("" + passx_title[x_loop]);//title
													nm.carbon[2][94][0] = new String("title_url");
													nm.carbon[2][95][0] = new String(total_on_hand_now);
													nm.carbon[2][96][0] = new String(temp0);//total_sale_amount
													nm.carbon[2][97][0] = new String(" ");//tracking number
													nm.carbon[2][98][0] = new String(nm.carbon[5][nm.id_mm][nm.current_submit_item_a]);//transaction_id Integer.toString(nm.current_submit_item_a)
													nm.carbon[2][99][0] = new String("" + passx_AmazonOrderIdx[x_loop]);
												
												} catch (Exception e) {System.out.println("FFFFFF");}




												change_name_country();



												//amazon can give you multiple orders of the same item they will need new ids for the labels to match
												if (x_loop > 0) {

													nm.carbon[2][84][0] = new String("" + order.getAmazonOrderId() + "-" + Integer.toString(x_loop));

												}//sale id


												//don't ship error items
												if (passx_title[x_loop].equals("null")) {

													nm.carbon[2][85][0] = new String("Error");

												}//sale status




												//change ship type if quanitity is too high. 
												try {

													int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
													int ix4 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_change_quantity_xx][nm.current_submit_item_a]);

													System.out.println(ix3);
													System.out.println(ix4);
													//System.exit(0);

													if (ix3 >= ix4) {

														int ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_change_field_xx][nm.current_submit_item_a]);
														nm.carbon[2][ix5][0] = nm.carbon[5][amazon_settings.ship_change_type_xx][nm.current_submit_item_a];

													}//************

												} catch (Exception e) {System.out.println("Quantity ship type failed.");}




												//change ship type if quanitity is too high2. 
												try {

													int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
													int ix4 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_change_quantity_xx2][nm.current_submit_item_a]);

													System.out.println(ix3);
													System.out.println(ix4);
													//System.exit(0);

													if (ix3 >= ix4) {

														int ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_change_field_xx2][nm.current_submit_item_a]);
														nm.carbon[2][ix5][0] = nm.carbon[5][amazon_settings.ship_change_type_xx2][nm.current_submit_item_a];

													}//************

												} catch (Exception e) {System.out.println("Quantity ship type2 failed.");}





												//change ship type if weight is too high. 
												try {

													int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
													int ix4 = Integer.parseInt(nm.carbon[2][nm.item_weight_xx][0]);
													int ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_weight_change_quantity_xx][nm.current_submit_item_a]);

													System.out.println(ix3);
													System.out.println(ix4);
													System.out.println((ix3 * ix4) + " " + ix5);
													//System.exit(0);

													if ((ix3 * ix4) > ix5 && ix3 > 1) {

														System.out.println("yes change");
														ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_weight_change_field_xx][nm.current_submit_item_a]);
														nm.carbon[2][ix5][0] = nm.carbon[5][amazon_settings.ship_weight_change_type_xx][nm.current_submit_item_a];

													}//************

												} catch (Exception e) {System.out.println("Weight ship type failed.");}




												//change ship type if weight is too high. 
												try {

													int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
													int ix4 = Integer.parseInt(nm.carbon[2][nm.item_weight_xx][0]);
													int ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_weight_change_quantity_xx2][nm.current_submit_item_a]);

													System.out.println(ix3);
													System.out.println(ix4);
													System.out.println((ix3 * ix4) + " " + ix5);
													//System.exit(0);

													if ((ix3 * ix4) > ix5 && ix3 > 1) {

														System.out.println("yes change");
														ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_weight_change_field_xx2][nm.current_submit_item_a]);
														nm.carbon[2][ix5][0] = nm.carbon[5][amazon_settings.ship_weight_change_type_xx2][nm.current_submit_item_a];

													}//************

												} catch (Exception e) {System.out.println("Weight ship type failed2.");}





												//change wrong country name
												try {

													change_name_country();

												} catch (Exception e) {System.out.println("failed.");}



												System.out.println("NND " + nm.carbon[2][84][0]);

												//ix5++;
												carbon_items++;



											}//for^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

										}//if*******************************************************************************************************working

									}//orderTotal*******************************************************************************************************

								}//shippingAddress*******************************************************************************************************

							} catch (Exception exe) {System.out.println("ADDRESS FAIL");}

						}//if order**********************************************************

					}//for***************************************************************************************

				}//if******************************************************************************************************

			}//if******************************************************************************************************************




        } catch (MarketplaceWebServiceOrdersException ex) {

           	System.out.println("Caught Exception: " + ex.getMessage());
           	System.out.println("Response Status Code: " + ex.getStatusCode());
           	System.out.println("Error Code: " + ex.getErrorCode());
           	System.out.println("Error Type: " + ex.getErrorType());
           	System.out.println("Request ID: " + ex.getRequestId());
           	System.out.print("XML: " + ex.getXML());

        }//*********************************************


    }//********************invokeListOrders****




	//get more orders
	public void invokeListOrdersByNextToken(MarketplaceWebServiceOrders service, ListOrdersByNextTokenRequest request) {

    	try {


            ListOrdersByNextTokenResponse response = service.listOrdersByNextToken(request);

			ix0++;
			infox2.setText("Orders count " + Integer.toString(ix0));


			if (response.isSetListOrdersByNextTokenResult()) {//******************************************************************************

				ListOrdersByNextTokenResult listOrdersResult = response.getListOrdersByNextTokenResult();

				if (listOrdersResult.isSetOrders()) {//********************************************************************

					OrderList orders = listOrdersResult.getOrders();
					java.util.List<Order> orderList = orders.getOrder();


					for (Order order : orderList) {//***********************************************************

						if (order.isSetAmazonOrderId()) {//*****************************

							System.out.println("AmazonOrderId " + order.getAmazonOrderId());
							String xgetx = order.getAmazonOrderId();
	

							try {

								Address shippingAddress = order.getShippingAddress();

								if (shippingAddress.isSetName()) {

									Money orderTotal = order.getOrderTotal();
	
									if (orderTotal.isSetAmount()) {


										try {

											passx_sku[0] = "";

											ListOrderItemsRequest request_item = new ListOrderItemsRequest();
											request_item.setSellerId(sellerId);
											request_item.setAmazonOrderId(xgetx);

											invokeListOrderItems(service, request_item);

										} catch (Exception e) {System.out.println("GET ITEM REQUEST FAILED");}


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

												}//***********************************

											}//for*****************************************************************************************
											//see if item is already imported in the archived

										} catch (Exception e) {ixtest4 = 0;}

										//only import inventoried sales if requested.

										try {

											String cx0 = "";

											//some items from ebay could be missing info.
											try {

												cx0 = order.getAmazonOrderId();

											} catch(Exception e) {e.printStackTrace(); ixtest3 = 1;}


											if (nm.carbon[5][amazon_settings.import_everything_xx][nm.current_submit_item_a].equals("1") && ixtest3 == 0) {

												System.out.println(cx0);

													for (int xloopx1 = 1; xloopx1 < (nm.carbon[0][0].length); xloopx1++) {//***************
										
														if (ixtest3 == 0) {ixtest3 = 2;}

														//System.out.println(nm.carbon[0][nm.part_number_xx][xloopx1]);
														if (cx0.equals(nm.carbon[0][nm.part_number_xx][xloopx1])) {

															ixtest3 = 0; 
															break;

														}//********************************************************

													}//**********************************************************************************

											}//if*******************************************************************************************************
										
										} catch (Exception e) {e.printStackTrace();}


										System.out.println("xx working " + ixtest3 + " " + ixtest4);


										if (ixtest3 == 0 && ixtest4 == 0) {//*************************************************************ix3 == 0 && ix4 == 0

											System.out.println("working");

											ix0++;
											infox2.setText("Orders count " + Integer.toString(ix0));


											/**

											carbonfiber = nm.carbon[2];

											nm.carbon[2] = new String[nm.db_cc_number][(carbonfiber[0].length + 1)];

											int ix6 = 1;
											//ix7 = 0;

											try {//***********************************************

												for (int xloopx1 = 2; xloopx1 < (nm.carbon[2][0].length); xloopx1++) {//***************

													for( int xloopx2 = 0; xloopx2 < nm.db_cc_number; xloopx2++) {//***************

														nm.carbon[2][xloopx2][xloopx1] = carbonfiber[xloopx2][ix6];
														//System.out.println("xx " + xloopx1 + " " + nm.carbon[2][xloopx2][xloopx1]);

													}//*************************************************************************

													ix6++;

												}//**********************************************************************************

											} catch (Exception e) {System.out.println("FFFFFF LOOP");}

											**/

		
	
											for (int xloopx1 = 1; xloopx1 < (nm.carbon[0][0].length); xloopx1++) {//***************

												if (passx_sku.equals(nm.carbon[0][nm.part_number_xx][xloopx1])) {

													//quantity
													try {

														nm.carbon[0][nm.total_on_hand_xx][xloopx1] = Integer.toString( Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][xloopx1]) - order.getNumberOfItemsShipped() );

													} catch (Exception e) {System.out.println("Quantity update failed.");}


													temp1 = nm.carbon[0][nm.item_cost_xx][xloopx1];
													temp2 = nm.carbon[0][nm.item_weight_xx][xloopx1];
													temp3 = nm.carbon[0][nm.package_d_xx][xloopx1];
													temp4 = nm.carbon[0][nm.package_l_xx][xloopx1];
													temp5 = nm.carbon[0][nm.package_w_xx][xloopx1];
													temp6 = nm.carbon[0][nm.shipping_out_xx][xloopx1];

													custom_temp1 = nm.carbon[0][nm.custom_1_xx][xloopx1];
													custom_temp2 = nm.carbon[0][nm.custom_2_xx][xloopx1];
													custom_temp3 = nm.carbon[0][nm.custom_3_xx][xloopx1];
													custom_temp4 = nm.carbon[0][nm.custom_4_xx][xloopx1];
													custom_temp5 = nm.carbon[0][nm.custom_5_xx][xloopx1];
													custom_temp6 = nm.carbon[0][nm.custom_6_xx][xloopx1];
													custom_temp7 = nm.carbon[0][nm.custom_7_xx][xloopx1];
													custom_temp8 = nm.carbon[0][nm.custom_8_xx][xloopx1];
													custom_temp9 = nm.carbon[0][nm.custom_9_xx][xloopx1];
													custom_temp10 = nm.carbon[0][nm.custom_10_xx][xloopx1];
													custom_temp11 = nm.carbon[0][nm.custom_11_xx][xloopx1];
													custom_temp12 = nm.carbon[0][nm.custom_12_xx][xloopx1];
													custom_temp13 = nm.carbon[0][nm.custom_13_xx][xloopx1];
													custom_temp14 = nm.carbon[0][nm.custom_14_xx][xloopx1];
													custom_temp15 = nm.carbon[0][nm.custom_15_xx][xloopx1];
													custom_temp16 = nm.carbon[0][nm.custom_16_xx][xloopx1];
													custom_temp17 = nm.carbon[0][nm.custom_17_xx][xloopx1];
													custom_temp18 = nm.carbon[0][nm.custom_18_xx][xloopx1];
													custom_temp19 = nm.carbon[0][nm.custom_19_xx][xloopx1];
													custom_temp20 = nm.carbon[0][nm.custom_20_xx][xloopx1];
													custom_temp21 = nm.carbon[0][nm.custom_21_xx][xloopx1];
													custom_temp22 = nm.carbon[0][nm.custom_22_xx][xloopx1];
													custom_temp23 = nm.carbon[0][nm.custom_23_xx][xloopx1];
													custom_temp24 = nm.carbon[0][nm.custom_24_xx][xloopx1];
													custom_temp25 = nm.carbon[0][nm.custom_25_xx][xloopx1];
													custom_temp26 = nm.carbon[0][nm.custom_26_xx][xloopx1];
													custom_temp27 = nm.carbon[0][nm.custom_27_xx][xloopx1];
													custom_temp28 = nm.carbon[0][nm.custom_28_xx][xloopx1];
													custom_temp29 = nm.carbon[0][nm.custom_29_xx][xloopx1];
													custom_temp30 = nm.carbon[0][nm.custom_30_xx][xloopx1];
													custom_temp31 = nm.carbon[0][nm.custom_31_xx][xloopx1];
													custom_temp32 = nm.carbon[0][nm.custom_32_xx][xloopx1];
													custom_temp33 = nm.carbon[0][nm.custom_33_xx][xloopx1];
													custom_temp34 = nm.carbon[0][nm.custom_34_xx][xloopx1];
													custom_temp35 = nm.carbon[0][nm.custom_35_xx][xloopx1];
													custom_temp36 = nm.carbon[0][nm.custom_36_xx][xloopx1];
													custom_temp37 = nm.carbon[0][nm.custom_37_xx][xloopx1];
													custom_temp38 = nm.carbon[0][nm.custom_38_xx][xloopx1];
													custom_temp39 = nm.carbon[0][nm.custom_39_xx][xloopx1];
													custom_temp40 = nm.carbon[0][nm.custom_40_xx][xloopx1];
													custom_temp41 = nm.carbon[0][nm.custom_41_xx][xloopx1];
													custom_temp42 = nm.carbon[0][nm.custom_42_xx][xloopx1];
													custom_temp43 = nm.carbon[0][nm.custom_43_xx][xloopx1];
													custom_temp44 = nm.carbon[0][nm.custom_44_xx][xloopx1];
													custom_temp45 = nm.carbon[0][nm.custom_45_xx][xloopx1];
													custom_temp46 = nm.carbon[0][nm.custom_46_xx][xloopx1];


													passx_listing_id[0] = nm.carbon[0][nm.listing_id_xx][xloopx1];

													break;

												}//*****************************************************************************************************
												else {

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

												temp0 = Float.toString(Float.parseFloat(passx_price[0]));// * Float.parseFloat(passx_quanitity)
												temp1 = Float.toString(Float.parseFloat(temp1) * Float.parseFloat(passx_quanitity[0]));
												temp7 = Float.toString((Float.parseFloat(passx_price[0]) * 0.15f)); //amazon fees

												ix0 = temp7.indexOf(".");
												
												if (ix0 > -1) {

													String cx0 = temp7.substring(0, ix0);
													String cx1 = temp7.substring(ix0, temp7.length());
					
													if (cx1.length() > 3) {temp7 = cx0 + temp7.substring(ix0, ix0 + 3);}

												}//**********

											} catch (Exception e) {

												System.out.println("Q M P M"); 
												temp0 = "0.02"; 
												temp1 = "0.02";

											}//********************


											try {

												if (shippingAddress.getAddressLine2() == null) {nm.carbon[2][0][0] = new String("" + shippingAddress.getAddressLine1());}
												else {nm.carbon[2][0][0] = new String("" + shippingAddress.getAddressLine1() + shippingAddress.getAddressLine2());}

												nm.carbon[2][1] [0] = new String("" + shippingAddress.getCity());
												nm.carbon[2][2] [0] = new String("" + shippingAddress.getStateOrRegion());
												nm.carbon[2][3] [0] = new String("" + shippingAddress.getPostalCode());
												nm.carbon[2][4] [0] = new String("" + shippingAddress.getCountryCode());
												nm.carbon[2][5] [0] = new String("");
												nm.carbon[2][6] [0] = new String("" + order.getBuyerName());
												nm.carbon[2][7] [0] = new String("" + order.getBuyerEmail());
												nm.carbon[2][8] [0] = new String("" + shippingAddress.getName());
												nm.carbon[2][9] [0] = new String("");
												nm.carbon[2][10][0] = new String("");
												nm.carbon[2][11][0] = new String("" + shippingAddress.getPhone());
												nm.carbon[2][12][0] = new String(currency_code_x);
												nm.carbon[2][13][0] = new String(custom_temp1);
												nm.carbon[2][14][0] = new String(custom_temp2);
												nm.carbon[2][15][0] = new String(custom_temp3);
												nm.carbon[2][16][0] = new String(custom_temp4);
												nm.carbon[2][17][0] = new String(custom_temp5);
												nm.carbon[2][18][0] = new String(custom_temp6);
												nm.carbon[2][19][0] = new String(custom_temp7);
												nm.carbon[2][20][0] = new String(custom_temp8);
												nm.carbon[2][21][0] = new String(custom_temp9);
												nm.carbon[2][22][0] = new String(custom_temp10);
												nm.carbon[2][23][0] = new String(custom_temp11);
												nm.carbon[2][24][0] = new String(custom_temp12);
												nm.carbon[2][25][0] = new String(custom_temp13);
												nm.carbon[2][26][0] = new String(custom_temp14);
												nm.carbon[2][27][0] = new String(custom_temp15);
												nm.carbon[2][28][0] = new String(custom_temp16);
												nm.carbon[2][29][0] = new String(custom_temp17);
												nm.carbon[2][30][0] = new String(custom_temp18);
												nm.carbon[2][31][0] = new String(custom_temp19);
												nm.carbon[2][32][0] = new String(custom_temp20);
												nm.carbon[2][33][0] = new String(custom_temp21);
												nm.carbon[2][34][0] = new String(custom_temp22);
												nm.carbon[2][35][0] = new String(custom_temp23);
												nm.carbon[2][36][0] = new String(custom_temp24);
												nm.carbon[2][37][0] = new String(custom_temp25);
												nm.carbon[2][38][0] = new String(custom_temp26);
												nm.carbon[2][39][0] = new String(custom_temp27);
												nm.carbon[2][40][0] = new String(custom_temp28);
												nm.carbon[2][41][0] = new String(custom_temp29);
												nm.carbon[2][42][0] = new String(custom_temp30);
												nm.carbon[2][43][0] = new String(custom_temp31);
												nm.carbon[2][44][0] = new String(custom_temp32);
												nm.carbon[2][45][0] = new String(custom_temp33);
												nm.carbon[2][46][0] = new String(custom_temp34);
												nm.carbon[2][47][0] = new String(custom_temp35);
												nm.carbon[2][48][0] = new String(custom_temp36);
												nm.carbon[2][49][0] = new String(custom_temp37);
												nm.carbon[2][50][0] = new String(custom_temp38);
												nm.carbon[2][51][0] = new String(custom_temp39);
												nm.carbon[2][52][0] = new String(custom_temp40);
												nm.carbon[2][53][0] = new String(custom_temp41);
												nm.carbon[2][54][0] = new String(custom_temp42);
												nm.carbon[2][55][0] = new String(custom_temp43);
												nm.carbon[2][56][0] = new String(custom_temp44);
												nm.carbon[2][57][0] = new String(custom_temp45);
												nm.carbon[2][58][0] = new String(custom_temp46);
												nm.carbon[2][59][0] = new String("custom_template");
												nm.carbon[2][60][0] = new String("" + order.getPurchaseDate().toString().replace("T","-").replace("Z",""));//date_last_modified
												nm.carbon[2][61][0] = new String("" + order.getPurchaseDate().toString().replace("T","-").replace("Z",""));//date_payment_received
												nm.carbon[2][62][0] = new String("");//date_shipped
												nm.carbon[2][63][0] = new String("" + order.getPurchaseDate().toString().replace("T","-").replace("Z",""));//date_sold
												nm.carbon[2][64][0] = new String("");//ebay_item
												nm.carbon[2][65][0] = new String("0.00");//final_value_fee ebay
												nm.carbon[2][66][0] = new String("0.00");//handling paypal.
												nm.carbon[2][67][0] = new String("0");//hits
												nm.carbon[2][68][0] = new String(temp1);//item_cost
												nm.carbon[2][69][0] = new String("item_description");
												nm.carbon[2][70][0] = new String("item_id");
												nm.carbon[2][71][0] = new String(temp0);//item_price trans 16
												nm.carbon[2][72][0] = new String(temp2);//item_weight
												nm.carbon[2][73][0] = new String("0.00");//listing_fees
												nm.carbon[2][74][0] = new String("" + passx_listing_id);//listing_id
												nm.carbon[2][75][0] = new String("notes");
												nm.carbon[2][76][0] = new String(temp3);//package
												nm.carbon[2][77][0] = new String(temp4);
												nm.carbon[2][78][0] = new String(temp5);
												nm.carbon[2][79][0] = new String("" + passx_sku);//part_number
												nm.carbon[2][80][0] = new String("Amazon");//payment_type
												nm.carbon[2][81][0] = new String(temp7);//paypal_fees
												nm.carbon[2][82][0] = new String("picture_1");
												nm.carbon[2][83][0] = new String("" + passx_quanitity);//quantity_sold
												nm.carbon[2][84][0] = new String("" + order.getAmazonOrderId());//sale id
												nm.carbon[2][85][0] = new String("Sold");//sale status
												nm.carbon[2][86][0] = new String("" + passx_item_tax);//sales_tax
												nm.carbon[2][87][0] = new String("USPS");//shipping_company
												nm.carbon[2][88][0] = new String("" + passx_shipping_price);//shipping_in
												nm.carbon[2][89][0] = new String("0.00");//shipping_out
												nm.carbon[2][90][0] = new String("Amazon");
												nm.carbon[2][91][0] = new String("site_url");
												nm.carbon[2][92][0] = new String("" + nm.carbon[5][0][nm.current_submit_item_a]);//source of sale
												nm.carbon[2][93][0] = new String("" + passx_title[0]);//title
												nm.carbon[2][94][0] = new String("title_url");
												nm.carbon[2][95][0] = new String("total_on_hand");
												nm.carbon[2][96][0] = new String(temp0);//total_sale_amount
												nm.carbon[2][97][0] = new String(" ");//tracking number
												nm.carbon[2][98][0] = new String(Integer.toString(nm.current_submit_item_a));//transaction_id
												nm.carbon[2][99][0] = new String("" + passx_AmazonOrderIdx);

											}catch(Exception e){System.out.println("FFFFFF");}





											//change ship type if quanitity is too high. 
											try {

												int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
												int ix4 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_change_quantity_xx][nm.current_submit_item_a]);

												System.out.println(ix3);
												System.out.println(ix4);
												//System.exit(0);

												if (ix3 >= ix4) {

													int ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_change_field_xx][nm.current_submit_item_a]);
													nm.carbon[2][ix5][0] = nm.carbon[5][amazon_settings.ship_change_type_xx][nm.current_submit_item_a];

												}//************

											} catch (Exception e) {System.out.println("Quantity ship type failed.");}




											//change ship type if quanitity is too high2. 
											try {

												int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
												int ix4 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_change_quantity_xx2][nm.current_submit_item_a]);

												System.out.println(ix3);
												System.out.println(ix4);
												//System.exit(0);

												if (ix3 >= ix4) {

													int ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_change_field_xx2][nm.current_submit_item_a]);
													nm.carbon[2][ix5][0] = nm.carbon[5][amazon_settings.ship_change_type_xx2][nm.current_submit_item_a];

												}//************

											} catch (Exception e) {System.out.println("Quantity ship type2 failed.");}






											//change ship type if weight is too high. 
											try {

												int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
												int ix4 = Integer.parseInt(nm.carbon[2][nm.item_weight_xx][0]);
												int ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_weight_change_quantity_xx][nm.current_submit_item_a]);

												System.out.println(ix3);
												System.out.println(ix4);
												System.out.println((ix3 * ix4) + " " + ix5);
												//System.exit(0);

												if ((ix3 * ix4) > ix5 && ix3 > 1) {

													System.out.println("yes change");
													ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_weight_change_field_xx][nm.current_submit_item_a]);
													nm.carbon[2][ix5][0] = nm.carbon[5][amazon_settings.ship_weight_change_type_xx][nm.current_submit_item_a];

												}//************

											} catch (Exception e) {System.out.println("Weight ship type failed.");}




											//change ship type if weight is too high. 
											try{

												int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
												int ix4 = Integer.parseInt(nm.carbon[2][nm.item_weight_xx][0]);
												int ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_weight_change_quantity_xx2][nm.current_submit_item_a]);

												System.out.println(ix3);
												System.out.println(ix4);
												System.out.println((ix3 * ix4) + " " + ix5);
												//System.exit(0);

												if((ix3 * ix4) > ix5 && ix3 > 1){

													System.out.println("yes change");
													ix5 = Integer.parseInt(nm.carbon[5][amazon_settings.ship_weight_change_field_xx2][nm.current_submit_item_a]);
													nm.carbon[2][ix5][0] = nm.carbon[5][amazon_settings.ship_weight_change_type_xx2][nm.current_submit_item_a];

												}//************

											}catch(Exception e){System.out.println("Weight ship type failed2.");}



											//change wrong country name
											try{

												change_name_country();

											}catch(Exception e){System.out.println("failed.");}




											//add to database
											String[][] sale_xn = new String[ nm.carbon[2].length ][1];

											for(int xloopx = 0; xloopx < nm.carbon[2].length; xloopx++){//******

												sale_xn[xloopx][0] = nm.carbon[2][xloopx][0];

											}//*****************************************************************

											//add to database
											jdb_new_sale saves = new jdb_new_sale(sale_xn);




											System.out.println("NND " + nm.carbon[2][84][0]);

											//ix5++;
											carbon_items++;



										}//if*******************************************************************************************************working

									}//orderTotal*******************************************************************************************************

								}//shippingAddress*******************************************************************************************************

							} catch (Exception exe) {System.out.println("ADDRESS FAIL");}

						}//if order**********************************************************
					
					}//for***************************************************************************************
				
				}//if******************************************************************************************************

			}//if******************************************************************************************************************



        } catch (MarketplaceWebServiceOrdersException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
        }



		pullThePlug();


    }//...........******invokeListOrders****




    public void invokeListOrderItems(MarketplaceWebServiceOrders service, ListOrderItemsRequest request) {

		list_items_number = 0;

        try {

            ListOrderItemsResponse response = service.listOrderItems(request);

            System.out.println("ListOrderItems Action Response");
            System.out.println("=============================================================================");
            System.out.println();

            System.out.println("    ListOrderItemsResponse");
            System.out.println();
            if (response.isSetListOrderItemsResult()) {
                System.out.println("        ListOrderItemsResult");
                System.out.println();
                ListOrderItemsResult listOrderItemsResult = response.getListOrderItemsResult();
                if (listOrderItemsResult.isSetNextToken()) {
                    System.out.println("            NextToken");
                    System.out.println();
                    System.out.println("                "
                            + listOrderItemsResult.getNextToken()); token_id = listOrderItemsResult.getNextToken();
                    System.out.println();
                }
                if (listOrderItemsResult.isSetAmazonOrderId()) {
                    System.out.println("            AmazonOrderId");
                    System.out.println();
                    System.out.println(" " + listOrderItemsResult.getAmazonOrderId()); 
                    System.out.println();
                }
                if (listOrderItemsResult.isSetOrderItems()) {
                    System.out.println("            OrderItems");
                    System.out.println();
                    OrderItemList orderItems = listOrderItemsResult.getOrderItems();
                    java.util.List<OrderItem> orderItemList = orderItems.getOrderItem();
                    for (OrderItem orderItem : orderItemList) {
                        System.out.println("                OrderItem");
                        System.out.println();
                        if (orderItem.isSetASIN()) {
                            System.out.println("                    ASIN");
                            System.out.println();
                            System.out.println("   " + orderItem.getASIN() + " " + orderItem.getOrderItemId()); passx_AmazonOrderIdx[list_items_number] = orderItem.getOrderItemId();
                            System.out.println();
                        }
                        if (orderItem.isSetSellerSKU()) {
                            System.out.println("                    SellerSKU");
                            System.out.println();
                            System.out.println("" + orderItem.getSellerSKU()); passx_sku[list_items_number] = orderItem.getSellerSKU();
                            System.out.println();
                        }
                        if (orderItem.isSetTitle()) {
                            System.out.println("                    Title");
                            System.out.println();
                            System.out.println("" + orderItem.getTitle()); //passx_title[0] = orderItem.getTitle();
                            System.out.println();
                        }
                        if (orderItem.isSetQuantityOrdered()) {
                            System.out.println("                    QuantityOrdered");
                            System.out.println();
                            System.out.println("" + orderItem.getQuantityOrdered()); passx_quanitity[list_items_number] = Integer.toString(orderItem.getQuantityOrdered());
                            System.out.println();
                        }
                        if (orderItem.isSetQuantityShipped()) {
                            System.out.println("                    QuantityShipped");
							passx_shipped_number[list_items_number] = orderItem.getQuantityShipped().toString();
                            System.out.println();  //******************************************************************************************
                            System.out.println("                  " + orderItem.getQuantityShipped());
                            System.out.println();
                        }
                        if (orderItem.isSetGiftMessageText()) {
                            System.out.println("                    GiftMessageText");
                            System.out.println();
                            System.out.println("                        " + orderItem.getGiftMessageText());
                            System.out.println();
                        }
                        if (orderItem.isSetItemPrice()) {
                            System.out.println("                    ItemPrice");
                            System.out.println();
                            Money itemPrice = orderItem.getItemPrice(); 
                            if (itemPrice.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("  " + itemPrice.getCurrencyCode());
                                System.out.println();
                            }
                            if (itemPrice.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println(" " + itemPrice.getAmount()); passx_price[list_items_number] = itemPrice.getAmount();
                                System.out.println();
                            }
                        }
                        if (orderItem.isSetShippingPrice()) {
                            System.out.println("                    ShippingPrice");
                            System.out.println();
                            Money shippingPrice = orderItem.getShippingPrice();
                            if (shippingPrice.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("" + shippingPrice.getCurrencyCode()); 
                                System.out.println();
                            }
                            if (shippingPrice.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + shippingPrice.getAmount()); passx_shipping_price[list_items_number] = shippingPrice.getAmount();
                                System.out.println();
                            }
                        }
                        if (orderItem.isSetGiftWrapPrice()) {
                            System.out.println("                    GiftWrapPrice");
                            System.out.println();
                            Money giftWrapPrice = orderItem.getGiftWrapPrice();
                            if (giftWrapPrice.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + giftWrapPrice.getCurrencyCode());
                                System.out.println();
                            }
                            if (giftWrapPrice.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + giftWrapPrice.getAmount());
                                System.out.println();
                            }
                        }
                        if (orderItem.isSetItemTax()) {
                            System.out.println("                    ItemTax");
                            System.out.println();
                            Money itemTax = orderItem.getItemTax();
                            if (itemTax.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + itemTax.getCurrencyCode());
                                System.out.println();
                            }
                            if (itemTax.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + itemTax.getAmount()); passx_item_tax[list_items_number] = itemTax.getAmount();
								list_items_number++;

                                System.out.println();
                            }
                        }
                        if (orderItem.isSetShippingTax()) {
                            System.out.println("                    ShippingTax");
                            System.out.println();
                            Money shippingTax = orderItem.getShippingTax();
                            if (shippingTax.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + shippingTax.getCurrencyCode());
                                System.out.println();
                            }
                            if (shippingTax.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + shippingTax.getAmount());
                                System.out.println();
                            }
                        }
                        if (orderItem.isSetGiftWrapTax()) {
                            System.out.println("                    GiftWrapTax");
                            System.out.println();
                            Money giftWrapTax = orderItem.getGiftWrapTax();
                            if (giftWrapTax.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + giftWrapTax.getCurrencyCode());
                                System.out.println();
                            }
                            if (giftWrapTax.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + giftWrapTax.getAmount());
                                System.out.println();
                            }
                        }
                        if (orderItem.isSetShippingDiscount()) {
                            System.out.println("                    ShippingDiscount");
                            System.out.println();
                            Money shippingDiscount = orderItem.getShippingDiscount();
                            if (shippingDiscount.isSetCurrencyCode()) {
                                System.out
                                        .println("                        CurrencyCode");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + shippingDiscount
                                                        .getCurrencyCode());
                                System.out.println();
                            }
                            if (shippingDiscount.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + shippingDiscount.getAmount());
                                System.out.println();
                            }
                        }
                        if (orderItem.isSetPromotionDiscount()) {
                            System.out.println("                    PromotionDiscount");
                            System.out.println();
                            Money promotionDiscount = orderItem.getPromotionDiscount();
                            if (promotionDiscount.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + promotionDiscount.getCurrencyCode());
                                System.out.println();
                            }
                            if (promotionDiscount.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + promotionDiscount.getAmount());
                                System.out.println();
                            }
                        }
                        if (orderItem.isSetPromotionIds()) {
                            System.out.println("                    PromotionIds");
                            System.out.println();
                            PromotionIdList promotionIds = orderItem
                                    .getPromotionIds();
                            java.util.List<String> promotionIdList = promotionIds
                                    .getPromotionId();
                            for (String promotionId : promotionIdList) {
                                System.out
                                        .println("                        PromotionId");
                                System.out.println();
                                System.out
                                        .println("                            "
                                                + promotionId);
                            }
                        }
                        if (orderItem.isSetCODFee()) {
                            System.out.println("                    CODFee");
                            System.out.println();
                            Money  CODFee = orderItem.getCODFee();
                            if (CODFee.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();
                                System.out.println("                            " + CODFee.getCurrencyCode());
                                System.out.println();
                            }
                            if (CODFee.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + CODFee.getAmount());
                                System.out.println();
                            }
                        } 
                        if (orderItem.isSetCODFeeDiscount()) {
                            System.out.println("                    CODFeeDiscount");
                            System.out.println();
                            Money  CODFeeDiscount = orderItem.getCODFeeDiscount();
                            if (CODFeeDiscount.isSetCurrencyCode()) {
                                System.out.println("                        CurrencyCode");
                                System.out.println();				currency_code_x = CODFeeDiscount.getCurrencyCode();
                                System.out.println("                            " + CODFeeDiscount.getCurrencyCode());
                                System.out.println();
                            }
                            if (CODFeeDiscount.isSetAmount()) {
                                System.out.println("                        Amount");
                                System.out.println();
                                System.out.println("                            " + CODFeeDiscount.getAmount());
                                System.out.println();
                            }
                        }
                        if (orderItem.isSetGiftMessageText()) {
                            System.out.println("                    GiftMessageText");
                            System.out.println();
                            System.out.println("                        " + orderItem.getGiftMessageText());
                            System.out.println();
                        }
                        if (orderItem.isSetGiftWrapLevel()) {
                            System.out.println("                    GiftWrapLevel");
                            System.out.println();
                            System.out.println("                        " + orderItem.getGiftWrapLevel());
                            System.out.println();
                        }
                    }
                }
            }
            if (response.isSetResponseMetadata()) {
                System.out.println("        ResponseMetadata");
                System.out.println();
                ResponseMetadata responseMetadata = response
                        .getResponseMetadata();
                if (responseMetadata.isSetRequestId()) {
                    System.out.println("            RequestId");
                    System.out.println();
                    System.out.println("                "
                            + responseMetadata.getRequestId());
                    System.out.println();
                }
            }
            System.out.println();

        } catch (MarketplaceWebServiceOrdersException ex) {

            System.out.println("Caught Exception: " + ex.getMessage());
            System.out.println("Response Status Code: " + ex.getStatusCode());
            System.out.println("Error Code: " + ex.getErrorCode());
            System.out.println("Error Type: " + ex.getErrorType());
            System.out.println("Request ID: " + ex.getRequestId());
            System.out.print("XML: " + ex.getXML());
        }
    }




    public void pullThePlug() {

    	System.out.println("PULL THE PLUG");

    	nm.sales_import_done = true;

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull




	public void change_name_country() {

		if(nm.carbon[2][4][0].equals("USA")){nm.carbon[2][4][0] = new String("United States");}
		if(nm.carbon[2][4][0].equals("US")){nm.carbon[2][4][0] = new String("United States");}
		if(nm.carbon[2][4][0].equals("Russian Federation")){nm.carbon[2][4][0] = new String("Russia");}
		if(nm.carbon[2][4][0].equals("Turkey")){nm.carbon[2][4][0] = new String("Turker");}
		if(nm.carbon[2][4][0].equals("Puerto Rico")){nm.carbon[2][4][0] = new String("United States");}
		if(nm.carbon[2][4][0].equals("PR")){nm.carbon[2][4][0] = new String("United States");}
		if(nm.carbon[2][4][0].equals("FM")){nm.carbon[2][4][0] = new String("United States");}


		if(nm.carbon[2][2][0].equals("null")){nm.carbon[2][2][0] = new String("PR");}


		System.out.println("X" + nm.carbon[2][4][0] + "X");
		System.out.println("X" + nm.carbon[2][2][0] + "X");


		//System.out.println(nm.carbon[2][4][1]);
		//System.exit(0);

	}//*******************************




	class BackgroundPanel extends JPanel{

	  	Image image;

	  	public BackgroundPanel(){

		    try {

		      	image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3w.jpg"), "background3w.jpg"));

		    } catch (Exception e) { System.out.println("Failed001"); }

	  	}//backgroundpanel

	  	protected void paintComponent(Graphics g){

	    	super.paintComponent(g); 

	    	if (image != null){
	     
	      		g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);

	      	}

	  	}//paint
	
	}//jpanel




}//last

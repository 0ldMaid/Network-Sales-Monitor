import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import org.scribe.builder.*;
import org.scribe.builder.api.*;
import org.scribe.model.*;
import org.scribe.oauth.*;
import java.awt.Toolkit;
import java.net.URLConnection;
import java.security.Security.*;
import com.sun.net.ssl.*;
import com.sun.*; 
import java.security.MessageDigest;
import javax.net.ssl.HttpsURLConnection;
import java.security.cert.Certificate;
import javax.net.ssl.SSLPeerUnverifiedException;



public class etsy_import_sales extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JSONParser parser = new JSONParser();

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int order_sales = 0;//sales.
int order_items = 0;//items in each sale.






etsy_import_sales() {//**********************************************************

	super("Etsy Import Sales");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);



//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	ximagex = new ImageIcon(this.getClass().getResource("images/etsy.png")).getImage();
	Icon aicon = new ImageIcon(ximagex);

	infox0.setPreferredSize(new Dimension(320, 50));
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 2.0.1");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("OAuth Start");
	infox1.setForeground(nm.whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(nm.blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("Loading...");
	infox2.setForeground(nm.whitex);
	infox2.setOpaque(true); 
	infox2.setBackground(nm.blackx);



	BackgroundPanel bkp = new BackgroundPanel();
	bkp.setPreferredSize(new Dimension(340, 140));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(nm.blackx);
	bkp.setForeground(nm.whitex);
	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);



	Container cp = getContentPane();
	cp.add(bkp);


	if (!nm.run_silent) {setVisible(true);}
	else {System.out.println("RUN SILENT");}

	connectx();

	pullThePlug();


}//csv_loader_x1********************************************************






	public void connectx() {


		// Construct data
		try {


  			String apiKey = nm.carbon[5][2][nm.current_submit_item_a];
  			String apiSecret = nm.carbon[5][3][nm.current_submit_item_a];

  			String NETWORK_NAME = "Etsy";
  			String AUTHORIZE_URL = "";
  			String PROTECTED_RESOURCE_URL = "https://openapi.etsy.com/v2/shops/" + nm.carbon[5][etsy_settings.etsy_shop_id][nm.current_submit_item_a] + "/receipts/unshipped";


			System.out.println(apiKey);
			System.out.println(apiSecret);

    		OAuthService service = new ServiceBuilder()
                                  .provider(EtsyAPI.class)
                                  .apiKey(apiKey)
                                  .apiSecret(apiSecret)
                                  .build();



    		System.out.println(nm.carbon[5][etsy_settings.etsy_token_xx][nm.current_submit_item_a]);
    		System.out.println(nm.carbon[5][etsy_settings.etsy_secret_xx][nm.current_submit_item_a]);
    		System.out.println(nm.carbon[5][etsy_settings.etsy_raw_xx][nm.current_submit_item_a]);


    		Token accessToken = new Token(nm.carbon[5][etsy_settings.etsy_token_xx][nm.current_submit_item_a],nm.carbon[5][etsy_settings.etsy_secret_xx][nm.current_submit_item_a],nm.carbon[5][etsy_settings.etsy_raw_xx][nm.current_submit_item_a]);
    		System.out.println("Got the Access Token!");
    		System.out.println();



    		// Now let's go and ask for a protected resource!
    		System.out.println("Now we're going to access a protected resource...");
    		OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
    		service.signRequest(accessToken, request);
    		Response response = request.send();
    		System.out.println("Got it! Lets see what we found...");
    		System.out.println();
    		System.out.println(response.getCode());
    		System.out.println(response.getBody());

    		System.out.println();
    		System.out.println("Thats it man! Go and build something awesome with Scribe! :)");



			//JSONParser parser = new JSONParser();

			try {//*********************************************************
 

				Object obj = parser.parse(response.getBody());
 
				JSONObject jsonObject = (JSONObject) obj;
  
				String requestx = (String) jsonObject.get("count").toString();


				System.out.println(requestx);

				if (!requestx.equals("0")) {

					//get the array from the above item
					String new_string_sales = (String) jsonObject.get("results").toString();

					//parse the new array
					Object obj2 = parser.parse(new_string_sales);
 
					JSONArray array = (JSONArray) obj2;

  					System.out.println(array.size());


					for (int loop = 0; loop < array.size(); loop++) {


						//System.out.println("NEW SALE " + array.get(loop).toString());

						String new_sale_string = array.get(loop).toString();

						Object obj3 = parser.parse(new_sale_string);

						JSONObject jsonObject3 = (JSONObject) obj3;

						String salex = (String) jsonObject3.get("order_id").toString();

    					System.out.println("SALE IDS " + salex);


    					//test the sales
    					boolean testxs = test_sale(salex);

    					System.out.println("testxs " + testxs);

    					if (testxs) {

    						String listings_array = get_sale_id2(new_sale_string);

							//parse the new array
							Object obj4 = parser.parse(listings_array);

							JSONArray array2 = (JSONArray) obj4;

							System.out.println(array2.size());


							for (int loop2 = 0; loop2 < array2.size(); loop2++) {


								String new_listing_string = array2.get(loop2).toString();

								Object obj5 = parser.parse(new_listing_string);

								JSONObject jsonObject5 = (JSONObject) obj5;

								String itemx = (String) jsonObject5.get("listing_id").toString();

	        					System.out.println("ITEM IDS " + itemx);

	        					add_sale(new_sale_string, new_listing_string);


							}//************************************************


    					}//test****


					}//********************************************


					//test for more sales

					String next_page = (String) jsonObject.get("pagination").toString();

					System.out.println("next_page " + next_page);


				}//if


			} catch (ParseException e) {

				e.printStackTrace();

				if (!nm.run_silent) {JOptionPane.showMessageDialog(null, response.getBody());}

			}//**************************


		} catch (Exception e) {e.printStackTrace();}


	}//connectx()*********************************************************************************************









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







	public String get_sale_id2(String sale_string){

		String listingx = new String("");


		try {



			Object objx = parser.parse(sale_string);

			JSONObject jsonObjectx = (JSONObject) objx;

			String sale_id = (String) jsonObjectx.get("order_id").toString();
			String receipt_id = (String) jsonObjectx.get("receipt_id").toString();

			System.out.println("Sale ID: " + sale_id);

	  		String apiKey = nm.carbon[5][2][nm.current_submit_item_a];
	  		String apiSecret = nm.carbon[5][3][nm.current_submit_item_a];


	  		String NETWORK_NAME = "Etsy";
	  		String AUTHORIZE_URL = "";
	  		String PROTECTED_RESOURCE_URL = "https://openapi.etsy.com/v2/receipts/" + receipt_id + "/transactions";

	  		System.out.println(PROTECTED_RESOURCE_URL);


			System.out.println(apiKey);
			System.out.println(apiSecret);

	    	OAuthService service = new ServiceBuilder()
	                                  .provider(EtsyAPI.class)
	                                  .apiKey(apiKey)
	                                  .apiSecret(apiSecret)
	                                  .build();



	    	System.out.println(nm.carbon[5][etsy_settings.etsy_token_xx][nm.current_submit_item_a]);
	    	System.out.println(nm.carbon[5][etsy_settings.etsy_secret_xx][nm.current_submit_item_a]);
	    	System.out.println(nm.carbon[5][etsy_settings.etsy_raw_xx][nm.current_submit_item_a]);


	    	Token accessToken = new Token(nm.carbon[5][etsy_settings.etsy_token_xx][nm.current_submit_item_a],nm.carbon[5][etsy_settings.etsy_secret_xx][nm.current_submit_item_a],nm.carbon[5][etsy_settings.etsy_raw_xx][nm.current_submit_item_a]);
	    	System.out.println("Got the Access Token!");
	    	System.out.println();



	    	// Now let's go and ask for a protected resource!
	    	System.out.println("Now we're going to access a protected resource...");
	    	OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
	    	service.signRequest(accessToken, request);
	    	Response response = request.send();
	    	System.out.println("Got it! Lets see what we found...");
	    	System.out.println();
	    	System.out.println(response.getCode());
	    	System.out.println(response.getBody());

	    	System.out.println();
	    	System.out.println("Thats it man! Go and build something awesome with Scribe! :)");


			try {//*********************************************************
	 

				Object obj = parser.parse(response.getBody());
	 
				JSONObject jsonObject = (JSONObject) obj;
	  
				String requestx = (String) jsonObject.get("count").toString();

				listingx = (String) jsonObject.get("results").toString();

				System.out.println(requestx);


			} catch (ParseException e) {

				e.printStackTrace();  
				if (!nm.run_silent) {JOptionPane.showMessageDialog(null, response.getBody());}

			}//*************************


		} catch (Exception e) {e.printStackTrace();}

		return listingx;

	}//************************










	public void add_sale(String sale_string, String trans_string) {

		int ix8 = 0;
		int item_match = 0;

		String temp0 = new String("0.01");
		String temp1 = new String("0.00");
		String temp2 = new String("1");
		String temp3 = new String("10");
		String temp4 = new String("5");
		String temp5 = new String("5");
		String temp6 = new String("0.00");
		String temp7 = new String("0.00");
		String temp8 = new String("0.00");
		String temp9 = new String("0.00");
		String temp10 = new String("0.00");
		String temp11 = new String("USPS");
		String temp12 = new String("0");

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




		try {//*****************************************************************************************************************************************


			//sale string
			Object objx1 = parser.parse(sale_string);

			JSONObject jsonObjectx1 = (JSONObject) objx1;

			String sale_id = (String) jsonObjectx1.get("order_id").toString();

			String xgetx = Integer.toString(nm.current_submit_item_a) + sale_id;


			byte[] bytesOfMessage = xgetx.getBytes("UTF-8");
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] thedigest = md.digest(bytesOfMessage);
			String sale_id_hash = thedigest.toString();

			System.out.println("sale_id_hash " + sale_id_hash);


			//listing string
			Object objx2 = parser.parse(trans_string);

			JSONObject jsonObjectx2 = (JSONObject) objx2;

			String listing_id = (String) jsonObjectx2.get("listing_id").toString();



			ix8++;

			String ADDRESS_STREET2 = new String("");

			try {

				ADDRESS_STREET2 = jsonObjectx1.get("second_line").toString();

			} catch(Exception e) {ADDRESS_STREET2 = "";}



    		String TITLE = jsonObjectx2.get("title").toString();
			String PART_NUMBER = new String("");//etsy doesn't have this :(
			String QTYORDERED = jsonObjectx2.get("quantity").toString();
			String PRICE = jsonObjectx2.get("price").toString();
			String SHIPPING_AMOUNT = jsonObjectx1.get("total_shipping_cost").toString();
			String TAX = jsonObjectx1.get("total_tax_cost").toString();
			String NOTE = jsonObjectx1.get("message_from_buyer").toString();
			String ADDRESS_STREET = jsonObjectx1.get("first_line").toString() + " " + ADDRESS_STREET2;
			String ADDRESS_CITY = jsonObjectx1.get("city").toString();
			String ADDRESS_REGION = jsonObjectx1.get("state").toString();
			String ADDRESS_ZIP = jsonObjectx1.get("zip").toString();
			String ADDRESS_COUNTRY = jsonObjectx1.get("country_id").toString();
			String LAST_NAME = new String();
			String FIRST_NAME = jsonObjectx1.get("name").toString();
			String TELEPHONE = new String("");
			String CURRENCY = jsonObjectx1.get("currency_code").toString();
			String EMAIL = jsonObjectx1.get("buyer_email").toString();
			String BUYER_ID = jsonObjectx1.get("buyer_user_id").toString();
			String STATUS = new String("Sold");
			String GRAND_TOTAL = new String("");
			String ORDER_ID = new String(sale_id);
			String TIME_STAMP = new String(sale_id);


			//the other items in the transaction will have 0 shipping in because it cannot be calculated per item. 
			if (order_items > 0) {SHIPPING_AMOUNT = "0.00";}


			//test items
			int ixtest3 = 0;
			int ixtest4 = 0;


			try {

				System.out.println(ADDRESS_STREET.replace("\n",", ").replace("\r",", "));
				System.out.println(ADDRESS_CITY); 
				System.out.println(ADDRESS_REGION); 
				System.out.println(ADDRESS_ZIP);
				System.out.println(ADDRESS_COUNTRY);
				System.out.println(FIRST_NAME);
				System.out.println(TELEPHONE);

				System.out.println(NOTE);
				System.out.println(TIME_STAMP);
				System.out.println(CURRENCY);
				System.out.println(EMAIL);

				System.out.println(EMAIL);

			} catch (Exception e) {ixtest3 = 1; ixtest4 = 1;}




			if (ixtest3 == 0 && ixtest4 == 0) {//*************************************************************ix3 == 0 && ix4 == 0


				System.out.println("working");

				order_sales++;
				infox2.setText("Orders count " + Integer.toString(order_sales));

				//System.out.println(list_items_number);


				//for (int x_loop = 0; x_loop < 1; x_loop++) {//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


					String[] sale_xn = new String[nm.db_cc_number];

					//quantity
					try {

						temp8 = QTYORDERED;
						int ix0 = temp8.indexOf(".");
						if (ix0 > -1) {temp8 = temp8.substring(0, ix0);}

					} catch (Exception e) {System.out.println("Quantity update failed.");}
					//quantity


					item_match = 0;
					//for (int xloopx1 = 0; xloopx1 < 1; xloopx1++) {//***************

						
						//get the item from inventory 
						String[] loaditem = new String[nm.db_cc_number];
						jdb_loader_item invx = new jdb_loader_item();
						loaditem = invx.getTitle(TITLE);

						System.out.println(loaditem[nm.part_number_xx]);


						if (TITLE.equals(loaditem[nm.title_xx])) {

							//quantity
							try {

								loaditem[nm.total_on_hand_xx] = Integer.toString( Integer.parseInt(loaditem[nm.total_on_hand_xx]) - Integer.parseInt(temp8));
								jdb_driver.s.execute("UPDATE listings SET total_on_hand='" + loaditem[nm.total_on_hand_xx] + "' WHERE item_id='" + loaditem[nm.item_id_xx] + "'");

							} catch (Exception e) {System.out.println("Quantity update failed.");}

							//update the item page if this item is there
							for (int xloopx2 = 0; xloopx2 < nm.carbon[0][0].length; xloopx2++) {//***************

								if (TITLE.equals(nm.carbon[0][nm.title_xx][xloopx2])) {

									nm.carbon[0][nm.total_on_hand_xx][xloopx2] = loaditem[nm.total_on_hand_xx];

								}//****************************************************

							}//********************************************************************************

							PART_NUMBER = loaditem[nm.part_number_xx];


							temp1 = loaditem[nm.item_cost_xx];
							temp2 = loaditem[nm.item_weight_xx];
							temp3 = loaditem[nm.package_d_xx];
							temp4 = loaditem[nm.package_l_xx];
							temp5 = loaditem[nm.package_w_xx];
							temp6 = loaditem[nm.shipping_out_xx];
							temp11 = loaditem[nm.shipping_company_xx];
							temp12 = loaditem[nm.total_on_hand_xx];

							custom_temp1 = loaditem[nm.custom_1_xx];
							custom_temp2 = loaditem[nm.custom_2_xx];
							custom_temp3 = loaditem[nm.custom_3_xx];
							custom_temp4 = loaditem[nm.custom_4_xx];
							custom_temp5 = loaditem[nm.custom_5_xx];
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


							item_match = 1;

							//break;

						}//*****************************************************************************************************
						else{

							temp0 = "0.01";
							temp1 = "0.00";
							temp2 = "1";
							temp3 = "10";
							temp4 = "5";
							temp5 = "5";
							temp6 = "0.00";

						}//**

					//}//**********************************************************************************





					//quantity more cost more
					try {


						temp0 = Double.toString(Double.parseDouble(PRICE) * Integer.parseInt(temp8));
						temp1 = Float.toString(Float.parseFloat(temp1) * Integer.parseInt(temp8));
						temp7 = Float.toString(0.00f); //amazon fees


						int ix0 = temp7.indexOf(".");
						if (ix0 > -1) {

							String cx0 = temp7.substring(0, ix0);
							String cx1 = temp7.substring(ix0, temp7.length());

							if (cx1.length() > 3) {

								temp7 = cx0 + temp7.substring(ix0, ix0 + 3);

							}//********************

						}//**********

					} catch (Exception e) {System.out.println("Q M P M"); temp0 = "0.02"; temp1 = "0.02";}


					try {

						DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:MM:ss");
						String formattedDate = df.format(new Date()) + ".00" + Integer.toString(ix8);


						temp9 = TAX;
						temp10 = SHIPPING_AMOUNT;

						if (ix8 > 1) {temp9 = "0.00"; temp10 = "0.00";}

						String customer_notes_save = new String("");
						try {

							if (NOTE != null) {customer_notes_save = NOTE;}
						
						} catch (Exception ee) {}


						sale_xn[0]  = new String(ADDRESS_STREET.replace("\n",", ").replace("\r",", "));//street
						sale_xn[1]  = new String(ADDRESS_CITY);//city
						sale_xn[2]  = new String(ADDRESS_REGION);//state
						sale_xn[3]  = new String(ADDRESS_ZIP);//zip
						sale_xn[4]  = new String(ADDRESS_COUNTRY);//country
						sale_xn[5]  = new String("");//address_6
						sale_xn[6]  = new String(BUYER_ID);//user id
						sale_xn[7]  = new String(EMAIL);//email
						sale_xn[8]  = new String(FIRST_NAME);//name first
						sale_xn[9]  = new String(LAST_NAME);//name last
						sale_xn[10]  = new String(customer_notes_save);//buyers_notes
						sale_xn[11]  = new String(TELEPHONE);//phone
						sale_xn[12]  = new String(CURRENCY);
						sale_xn[13]  = new String(custom_temp1);
						sale_xn[14]  = new String(custom_temp2);
						sale_xn[15]  = new String(custom_temp3);
						sale_xn[16]  = new String(custom_temp4);
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
						sale_xn[60] = new String(formattedDate);//date_last_modified
						sale_xn[61] = new String(formattedDate);//date_payment_received
						sale_xn[62] = new String("date_shipped");//date_shipped
						sale_xn[63] = new String(formattedDate);//date_sold
						sale_xn[64] = new String("ebay_item");//ebay_item
						sale_xn[65] = new String("0.00");//final_value_fee ebay
						sale_xn[66] = new String("0.00");//handling paypal.
						sale_xn[67] = new String("0");//hits
						sale_xn[68] = new String(temp1);//item_cost
						sale_xn[69] = new String("item_description");
						sale_xn[70] = new String("item_id");
						sale_xn[71] = new String(temp0);//item_price trans 16
						sale_xn[72] = new String(temp2);//item_weight
						sale_xn[73] = new String("0.00");//listing_fees
						sale_xn[74] = new String("listing_id");//listing_id
						sale_xn[75] = new String(STATUS);
						sale_xn[76] = new String(temp3);//package
						sale_xn[77] = new String(temp4);
						sale_xn[78] = new String(temp5);
						sale_xn[79] = new String(PART_NUMBER);//part_number
						sale_xn[80] = new String("PayPal");//payment_type
						sale_xn[81] = new String(temp7);//paypal_fees
						sale_xn[82] = new String("picture_1");
						sale_xn[83] = new String(temp8);//quantity_sold
						sale_xn[84] = new String(xgetx);//sale id
						sale_xn[85] = new String("Sold");//sale status
						sale_xn[86] = new String(temp9);//sales_tax
						sale_xn[87] = new String(temp11);//shipping_company
						sale_xn[88] = new String(temp10);//shipping_in
						sale_xn[89] = new String("0.00");//shipping_out
						sale_xn[90] = new String("Etsy");
						sale_xn[91] = new String("site_url");
						sale_xn[92] = new String(nm.carbon[5][0][nm.current_submit_item_a]);//source of sale
						sale_xn[93] = new String(TITLE);//title
						sale_xn[94] = new String("title_url");
						sale_xn[95] = new String(temp12);//total left
						sale_xn[96] = new String(GRAND_TOTAL);//total_sale_amount
						sale_xn[97] = new String(" ");//tracking number
						sale_xn[98] = new String(nm.carbon[5][nm.id_mm][nm.current_submit_item_a]);//transaction_id
						sale_xn[99] = new String(ORDER_ID);//transaction_info

					} catch (Exception e) {System.out.println("FFFFFF");}



					//fix 00

					//test tax
					int xixx0 = sale_xn[nm.sales_tax_xx].indexOf(".");
					if (xixx0 > -1) {

						String cx0 = sale_xn[nm.sales_tax_xx].substring(xixx0, sale_xn[nm.sales_tax_xx].length());

						     if (cx0.length() == 1) {sale_xn[nm.sales_tax_xx] = sale_xn[nm.sales_tax_xx] + "00";}
						else if (cx0.length() == 2) {sale_xn[nm.sales_tax_xx] = sale_xn[nm.sales_tax_xx] + "0";}
						else if (cx0.length() == 4) {sale_xn[nm.sales_tax_xx] = sale_xn[nm.sales_tax_xx].substring(0, sale_xn[nm.sales_tax_xx].length() -1);}

					}//**********



					//test shipping
					int xiyx0 = sale_xn[nm.shipping_in_xx].indexOf(".");
					if (xiyx0 > -1) {

						String cx0 = sale_xn[nm.shipping_in_xx].substring(xiyx0, sale_xn[nm.shipping_in_xx].length());

						     if (cx0.length() == 1) {sale_xn[nm.shipping_in_xx] = sale_xn[nm.shipping_in_xx] + "00";}
						else if (cx0.length() == 2) {sale_xn[nm.shipping_in_xx] = sale_xn[nm.shipping_in_xx] + "0";}
						else if (cx0.length() == 4) {sale_xn[nm.shipping_in_xx] = sale_xn[nm.shipping_in_xx].substring(0, sale_xn[nm.shipping_in_xx].length() -1);}

					}//**********


					System.out.println(ADDRESS_STREET.replace("\n","").replace("\r",""));
					System.out.println(ADDRESS_STREET.length());




					//don't ship error items
					if (item_match != 1) {sale_xn[85] = new String("Error");}//sale status

					//change ship type if quanitity is too high. 
					try {

						int ix3 = Integer.parseInt(sale_xn[nm.quantity_sold_xx]);
						int ix4 = Integer.parseInt(nm.carbon[5][etsy_settings.ship_change_quantity_xx][nm.current_submit_item_a]);

						System.out.println(ix3);
						System.out.println(ix4);
						//System.exit(0);

						if (ix3 >= ix4) {

							int ix5 = Integer.parseInt(nm.carbon[5][etsy_settings.ship_change_field_xx][nm.current_submit_item_a]);
							sale_xn[ix5] = nm.carbon[5][etsy_settings.ship_change_type_xx][nm.current_submit_item_a];

						}//************

					} catch (Exception e) {System.out.println("Quantity ship type failed.");}




					//change ship type if quanitity is too high2. 
					try {

						int ix3 = Integer.parseInt(sale_xn[nm.quantity_sold_xx]);
						int ix4 = Integer.parseInt(nm.carbon[5][etsy_settings.ship_change_quantity_xx2][nm.current_submit_item_a]);

						System.out.println(ix3);
						System.out.println(ix4);
						//System.exit(0);

						if (ix3 >= ix4) {

							int ix5 = Integer.parseInt(nm.carbon[5][etsy_settings.ship_change_field_xx2][nm.current_submit_item_a]);
							sale_xn[ix5] = nm.carbon[5][etsy_settings.ship_change_type_xx2][nm.current_submit_item_a];

						}//************

					} catch (Exception e) {System.out.println("Quantity ship type2 failed.");}





					//change ship type if weight is too high. 
					try {

						int ix3 = Integer.parseInt(sale_xn[nm.quantity_sold_xx]);
						int ix4 = Integer.parseInt(sale_xn[nm.item_weight_xx]);
						int ix5 = Integer.parseInt(nm.carbon[5][etsy_settings.ship_weight_change_quantity_xx][nm.current_submit_item_a]);

						System.out.println(ix3);
						System.out.println(ix4);
						System.out.println((ix3 * ix4) + " " + ix5);
						//System.exit(0);

						if ((ix3 * ix4) > ix5 && ix3 > 1) {

							System.out.println("yes change");
							ix5 = Integer.parseInt(nm.carbon[5][etsy_settings.ship_weight_change_field_xx][nm.current_submit_item_a]);
							sale_xn[ix5] = nm.carbon[5][etsy_settings.ship_weight_change_type_xx][nm.current_submit_item_a];

						}//************

					} catch (Exception e) {System.out.println("Weight ship type failed.");}




					//change ship type if weight is too high. 
					try {

						int ix3 = Integer.parseInt(sale_xn[nm.quantity_sold_xx]);
						int ix4 = Integer.parseInt(sale_xn[nm.item_weight_xx]);
						int ix5 = Integer.parseInt(nm.carbon[5][etsy_settings.ship_weight_change_quantity_xx2][nm.current_submit_item_a]);

						System.out.println(ix3);
						System.out.println(ix4);
						System.out.println((ix3 * ix4) + " " + ix5);
						//System.exit(0);

						if ((ix3 * ix4) > ix5 && ix3 > 1) {

							System.out.println("yes change");
							ix5 = Integer.parseInt(nm.carbon[5][etsy_settings.ship_weight_change_field_xx2][nm.current_submit_item_a]);
							sale_xn[ix5] = nm.carbon[5][etsy_settings.ship_weight_change_type_xx2][nm.current_submit_item_a];

						}//************

					} catch (Exception e) {System.out.println("Weight ship type failed2.");}



					//change wrong country name
					try {

						change_name_country(sale_xn);

					} catch (Exception e) {System.out.println("failed.");}



					//add to database
					jdb_new_sale saves = new jdb_new_sale(sale_xn);

					System.out.println("NND " + sale_xn[84]);

					order_items++;



				//}//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


			}//if*******************************************************************************************************working


		} catch (Exception e) {e.printStackTrace(); System.out.println("XXXX987987");}//**************************************************************************************************************************


	}//get orders//*********************************************************************************************************************************









	public String[] change_name_country (String[] update_name) {

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




	public void change_name_countryggggggggggggggggggg() {

		if (nm.carbon[2][4][0].equals("209")) {nm.carbon[2][4][0] = new String("United States");}
		if (nm.carbon[2][4][0].equals("Russian Federation")) {nm.carbon[2][4][0] = new String("Russia");}
		if (nm.carbon[2][4][0].equals("Turkey")) {nm.carbon[2][4][0] = new String("Turker");}
		if (nm.carbon[2][4][0].equals("Puerto Rico")){nm.carbon[2][4][0] = new String("United States");}
		if (nm.carbon[2][4][0].equals("PR")) {nm.carbon[2][4][0] = new String("United States");}
		if (nm.carbon[2][4][0].equals("FM")) {nm.carbon[2][4][0] = new String("United States");}


		//System.out.println(nm.carbon[2][4][1]);
		//System.exit(0);

	}//*******************************










    public void pullThePlug() {

    	System.out.println("PULL THE PLUG");

    	nm.sales_import_done = true;

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull







	class BackgroundPanel extends JPanel{

	  	Image image;
	  	public BackgroundPanel(){

	    	try {

	      		image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/backgroundyellow.jpg"), "backgroundyellow.jpg"));

	    	} catch (Exception e) { System.out.println("Failed001"); }

	  	}//backgroundpanel

	  	protected void paintComponent(Graphics g) {

	    	super.paintComponent(g);

	    	if (image != null) {
	      
	     		g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);

	     	}//****************

	  	}//paint

	}//jpanel



}//last****************************************




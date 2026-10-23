import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.util.regex.*;
import java.util.List;
import com.google.code.magja.model.order.OrderItem;
import com.google.code.magja.model.order.Order;
import com.google.code.magja.model.order.OrderFilter;
import com.google.code.magja.model.order.OrderFilterItem;
import com.google.code.magja.service.RemoteServiceFactory;
import com.google.code.magja.service.ServiceException;
import com.google.code.magja.service.order.OrderRemoteService;
import com.google.code.magja.model.customer.Customer;
import com.google.code.magja.service.customer.CustomerRemoteService;
import com.google.code.magja.soap.SoapConfig;
import com.google.code.magja.soap.MagentoSoapClient;
import com.google.code.magja.soap.SoapClient;
import com.google.code.magja.service.RemoteServiceFactory;
import java.util.*;
import com.google.code.magja.model.BaseMagentoModel;





public class magento_import_sales extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 168;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


Calendar calendar = new GregorianCalendar();

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Getting items from site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int order_count = 0;



magento_import_sales(){//****************************

	super("Import Sales");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	setDefaultLookAndFeelDecorated(false);
	//setUndecorated(true);


	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	ximagex = new ImageIcon(this.getClass().getResource("images/magento.png")).getImage();
	Icon aicon = new ImageIcon(ximagex);

	infox0.setPreferredSize(new Dimension(320, 80));
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 1.1.1");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("Loading Settings...");
	infox1.setForeground(nm.whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(nm.blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("Ready.");
	infox2.setForeground(nm.whitex);
	infox2.setOpaque(true); 
	infox2.setBackground(nm.blackx);



	FlowLayout fl1 = new FlowLayout();
	fl1.setHgap(0);
	fl1.setVgap(0);



	BackgroundPanel bkp = new BackgroundPanel();
	bkp.setPreferredSize(new Dimension(340, 140));
	bkp.setLayout(fl1);
	bkp.setBackground(nm.blackx);
	bkp.setForeground(nm.whitex);
	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);


	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(nm.blackx);
	cpx.setForeground(nm.whitex);
	cpx.add(bkp);



	if(!nm.run_silent){setVisible(true);}
	else{System.out.println("RUN SILENT");}


	String user = nm.carbon[5][2][nm.current_submit_item_a];
	String pass = nm.carbon[5][3][nm.current_submit_item_a];
	String host = nm.carbon[5][1][nm.current_submit_item_a];


	System.out.println("user " + user);
	System.out.println("pass " + pass);
	System.out.println("host " + host);


	System.out.println("Test Magento");
	connectx();


	pullThePlug();

}//csv_loader_x1********************************************************










	public void connectx() {

		infox1.setText("Get Sales List...");
		infox2.setText("Loading...");


		try {

 
	    	String user = nm.carbon[5][2][nm.current_submit_item_a];
	   		String pass = nm.carbon[5][3][nm.current_submit_item_a];
	   		String host = nm.carbon[5][1][nm.current_submit_item_a];


	    	System.out.println("user " + user);
	    	System.out.println("pass " + pass);
	    	System.out.println("host " + host);

 	    	// configure connection
	    	SoapConfig soapConfig = new SoapConfig(user, pass, host);

	    	MagentoSoapClient magentoSoapClient = MagentoSoapClient.getInstance(soapConfig);
	    	magentoSoapClient.setConfig(soapConfig);



            OrderRemoteService servicex = new RemoteServiceFactory(magentoSoapClient).getOrderRemoteService();
            servicex.setSoapClient(magentoSoapClient);

			int ix0 = 1;
            List<Order> list = servicex.list(null);


            for (Order order : list) {

	            infox1.setText("Importing (" + ix0 + " of " + list.size() + ")");

			    try {
			       
                    System.out.println(order.getId()); 

			        String orderid = order.getId().toString(); 			       
			       	int testnumber = Integer.parseInt(orderid);
			        get_order(orderid);

			    } catch (Exception e) {System.out.println("ID ERROR");}

				ix0++;

			}//for




            // TODO: is not working tha find with filter
            // make sure to have a order with billing_name = Joao da Silva
            //OrderFilter filter = new OrderFilter();
            //filter.getItems().add(new OrderFilterItem("billing_name", "like", "%Silva%"));
            //filter.getItems().add(new OrderFilterItem("billing_lastname", "=", "Martins"));

            //List<Order> filtered = service.list(filter);
            //for (Order order : filtered)
            //System.out.println(order.toString());



		} catch (Exception e) {System.out.println(e.getMessage());}




	}//connectx()*********************************************************************************************











	public void get_order(String orderid) {


		int item_match = 0;
		int order_items = 0;//sale id

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

	  		infox2.setText("Sale ID: " + Integer.parseInt(orderid));


	    	String user = nm.carbon[5][2][nm.current_submit_item_a];
	    	String pass = nm.carbon[5][3][nm.current_submit_item_a];
	    	String host = nm.carbon[5][1][nm.current_submit_item_a];


	    	System.out.println("user " + user);
	    	System.out.println("pass " + pass);
	    	System.out.println("host " + host);

 	    	// configure connection
	    	SoapConfig soapConfig = new SoapConfig(user, pass, host);

	    	MagentoSoapClient magentoSoapClient = MagentoSoapClient.getInstance(soapConfig);
	    	magentoSoapClient.setConfig(soapConfig);

            OrderRemoteService servicex = new RemoteServiceFactory(magentoSoapClient).getOrderRemoteService();
            servicex.setSoapClient(magentoSoapClient);

            Order order = servicex.getById(Integer.parseInt(orderid));
            System.out.println(order.toString());
	        //System.out.println(order.getCustomer().toString());
            //System.out.println(order.getCustomer().getFirstName().toString());
            //System.out.println(order.getShippingAddress().getFirstName().toString());
            //System.out.println(order.getBillingAddress().toString());
	        	



			for (OrderItem item : order.getItems()) {//*******************************************************************************************************

				//System.out.println(item.getProperties().toString());


				order_items++;

				String xgetx = Integer.toString(nm.current_submit_item_a) + orderid + Integer.toString(order_items);

				int ixtest3 = 0;
				int ixtest4 = 0;

				try {

					//see if item is already imported in the sales db
					for (int xloopx2 = 0; xloopx2 < nm.carbon[2][nm.sale_id_xx].length; xloopx2++) {//***************

						ixtest3 = 0;
						ixtest4 = xgetx.indexOf(nm.carbon[2][nm.sale_id_xx][xloopx2]);

						if (ixtest4 > -1 || xgetx.length() < 3) {

							ixtest3++; 
							System.out.println(" 77 " + nm.carbon[2][nm.sale_id_xx][xloopx2]); 
							break;

						}//***********************************

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

					}//for*************************************************************************************
					//see if item is already imported in the archived

				} catch (Exception e) {ixtest4 = 0;}



				//only import inventoried sales if requested.
				try {

					String cx0 = "";

					//some items from ebay could be missing info.
					try {

						cx0 = item.getSku().toString();

					} catch (Exception e) {e.printStackTrace(); ixtest3 = 1;}


					if (nm.carbon[5][magento_settings.import_everything_xx][nm.current_submit_item_a].equals("1") && ixtest3 == 0) {

						System.out.println(cx0);

 						for (int xloopx1 = 1; xloopx1 < (nm.carbon[0][0].length); xloopx1++) {//*************

 							if (ixtest3 == 0) {ixtest3 = 2;}

							//System.out.println(nm.carbon[0][nm.part_number_xx][xloopx1]);
 							if (cx0.equals(nm.carbon[0][nm.part_number_xx][xloopx1])) {ixtest3 = 0; break;}

 						}//**********************************************************************************

					}//if*******************************************************************************************************

				} catch (Exception e) {e.printStackTrace();}



				System.out.println("xx working " + ixtest3 + " " + ixtest4);



				try {

					System.out.println(order.getShippingAddress().getStreet().toString().replace("\n",", ").replace("\r",", "));
					System.out.println(order.getShippingAddress().getCity().toString()); 
					System.out.println(order.getShippingAddress().getRegion().toString()); 
					System.out.println(order.getShippingAddress().getPostCode().toString());
					System.out.println(order.getShippingAddress().getCountryCode().toString());
					System.out.println(order.getShippingAddress().getLastName().toString());
					System.out.println(order.getShippingAddress().getTelephone().toString());

					System.out.println(order.get("customer_note"));
					System.out.println(order.get("created_at"));
					System.out.println(order.get("base_currency_code"));
					System.out.println(order.get("customer_email"));

					//System.out.println(order.getCustomer().getEmail().toString());

				} catch (Exception e) {ixtest3 = 1; ixtest4 = 1;}


				if (ixtest3 == 0 && ixtest4 == 0) {//*************************************************************ixtest3 == 0 && ixtest4 == 0

					System.out.println("working");

					order_count++;
					infox2.setText("Orders count " + Integer.toString(order_count));



					//System.out.println(list_items_number);


					for (int x_loop = 0; x_loop < 1; x_loop++) {//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^


						/**

						String[][] carbonfiber = nm.carbon[2];

						nm.carbon[2] = new String[nm.db_cc_number][(carbonfiber[0].length + 1)];

						int ix6 = 0;

						try {//***********************************************

							for (int xloopx1 = 1; xloopx1 < (nm.carbon[2][0].length); xloopx1++) {//*************

								for (int xloopx2 = 0; xloopx2 < nm.db_cc_number; xloopx2++) {//*************

									nm.carbon[2][xloopx2][xloopx1] = carbonfiber[xloopx2][ix6];
									//System.out.println("xx " + xloopx1 + " " + nm.carbon[2][xloopx2][xloopx1]);

								}//*************************************************************************

								ix6++;

							}//**********************************************************************************

						} catch (Exception e) {System.out.println("FFFFFF LOOP");}


						**/


						//quantity
						try {

							temp8 = item.getQtyOrdered().toString();
							int ix0 = temp8.indexOf(".");

							if (ix0 > -1) {

								temp8 = temp8.substring(0, ix0);

							}//************

						} catch (Exception e) {System.out.println("Quantity update failed.");}
						//quantity


						item_match = 0;

						for (int xloopx1 = 0; xloopx1 < 1; xloopx1++) {//***************

							
							//get the item from inventory 
							String[] loaditem = new String[nm.db_cc_number];
							jdb_loader_item invx = new jdb_loader_item();
							loaditem = invx.getSku(item.getSku().toString());

							System.out.println(loaditem[nm.part_number_xx]);


							if (item.getSku().toString().equals(loaditem[nm.part_number_xx])) {

								//quantity
								try {

									loaditem[nm.total_on_hand_xx] = Integer.toString( Integer.parseInt(loaditem[nm.total_on_hand_xx]) - Integer.parseInt(temp8));
									jdb_driver.s.execute("UPDATE listings SET total_on_hand='" + loaditem[nm.total_on_hand_xx] + "' WHERE item_id='" + loaditem[nm.item_id_xx] + "'");

								} catch (Exception e) {

									System.out.println("Quantity update failed."); 
									loaditem[nm.total_on_hand_xx] = "0";

								}//*********************

								//update the item page if this item is there
								for (int xloopx2 = 0; xloopx2 < nm.carbon[0][0].length; xloopx2++) {//*************

									if (item.getSku().toString().equals(nm.carbon[0][nm.part_number_xx][xloopx2])) {nm.carbon[0][nm.total_on_hand_xx][xloopx2] = loaditem[nm.total_on_hand_xx];}

								}//********************************************************************************


								temp1 = loaditem[nm.item_cost_xx];
								temp2 = loaditem[nm.item_weight_xx];
								temp3 = loaditem[nm.package_d_xx];
								temp4 = loaditem[nm.package_l_xx];
								temp5 = loaditem[nm.package_w_xx];
								temp6 = loaditem[nm.shipping_out_xx];
								temp11 = loaditem[nm.shipping_company_xx];
								temp12 = loaditem[nm.total_on_hand_xx];

								//passx_title[x_loop] = new String(nm.carbon[0][nm.title_xx][xloopx1]);
								//System.out.println(passx_title[x_loop]);

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


								//passx_listing_id[x_loop] = new String(nm.carbon[0][nm.listing_id_xx][xloopx1]);

								item_match = 1;

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
								temp12 = "0";

							}//**

						}//**********************************************************************************





						//quantity more cost more
						try {


							temp0 = Double.toString(item.getPrice() * Integer.parseInt(temp8));
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
							String formattedDate = df.format(new Date()) + ".00" + Integer.toString(order_items);


							temp9 = order.getTaxAmount().toString();
							temp10 = order.getShippingAmount().toString();

							if (order_items > 1) {temp9 = "0.00"; temp10 = "0.00";}

							String customer_notes_save = new String("");
							try {

								if (order.get("customer_note").toString() != null) {

									customer_notes_save = order.get("customer_note").toString();

								}//*************************************************
							
							} catch (Exception ee) {}


							nm.carbon[2][0] [0] = new String(order.getShippingAddress().getStreet().toString().replace("\n",", ").replace("\r",", "));//street
							nm.carbon[2][1] [0] = new String(order.getShippingAddress().getCity().toString());//city
							nm.carbon[2][2] [0] = new String(order.getShippingAddress().getRegion().toString());//state
							nm.carbon[2][3] [0] = new String(order.getShippingAddress().getPostCode().toString());//zip
							nm.carbon[2][4] [0] = new String(order.getShippingAddress().getCountryCode().toString());//country
							nm.carbon[2][5] [0] = new String("");//address_6
							nm.carbon[2][6] [0] = new String(order.getShippingAddress().getLastName().toString());//first name
							nm.carbon[2][7] [0] = new String(order.get("customer_email").toString());//email
							nm.carbon[2][8] [0] = new String(order.getShippingAddress().getFirstName().toString() + " " + order.getShippingAddress().getLastName().toString());//name
							nm.carbon[2][9] [0] = new String("");//buyers_last_name
							nm.carbon[2][10][0] = new String(customer_notes_save);//buyers_notes
							nm.carbon[2][11][0] = new String(order.getShippingAddress().getTelephone().toString());//phone
							nm.carbon[2][12][0] = new String(order.get("base_currency_code").toString());
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
							nm.carbon[2][60][0] = new String(formattedDate);//date_last_modified
							nm.carbon[2][61][0] = new String(formattedDate);//date_payment_received
							nm.carbon[2][62][0] = new String("date_shipped");//date_shipped
							nm.carbon[2][63][0] = new String(formattedDate);//date_sold
							nm.carbon[2][64][0] = new String("ebay_item");//ebay_item
							nm.carbon[2][65][0] = new String("0.00");//final_value_fee ebay
							nm.carbon[2][66][0] = new String("0.00");//handling paypal.
							nm.carbon[2][67][0] = new String("0");//hits
							nm.carbon[2][68][0] = new String(temp1);//item_cost
							nm.carbon[2][69][0] = new String("item_description");
							nm.carbon[2][70][0] = new String("item_id");
							nm.carbon[2][71][0] = new String(temp0);//item_price trans 16
							nm.carbon[2][72][0] = new String(temp2);//item_weight
							nm.carbon[2][73][0] = new String("0.00");//listing_fees
							nm.carbon[2][74][0] = new String("listing_id");//listing_id
							nm.carbon[2][75][0] = new String(order.getStatus().toString());
							nm.carbon[2][76][0] = new String(temp3);//package
							nm.carbon[2][77][0] = new String(temp4);
							nm.carbon[2][78][0] = new String(temp5);
							nm.carbon[2][79][0] = new String(item.getSku().toString());//part_number
							nm.carbon[2][80][0] = new String("PayPal");//payment_type
							nm.carbon[2][81][0] = new String(temp7);//paypal_fees
							nm.carbon[2][82][0] = new String("picture_1");
							nm.carbon[2][83][0] = new String(temp8);//quantity_sold
							nm.carbon[2][84][0] = new String(xgetx);//sale id
							nm.carbon[2][85][0] = new String("Sold");//sale status
							nm.carbon[2][86][0] = new String(temp9);//sales_tax
							nm.carbon[2][87][0] = new String(temp11);//shipping_company
							nm.carbon[2][88][0] = new String(temp10);//shipping_in
							nm.carbon[2][89][0] = new String("0.00");//shipping_out
							nm.carbon[2][90][0] = new String("Magento");
							nm.carbon[2][91][0] = new String("site_url");
							nm.carbon[2][92][0] = new String(nm.carbon[5][0][nm.current_submit_item_a]);//source of sale
							nm.carbon[2][93][0] = new String(item.getName().toString());//title
							nm.carbon[2][94][0] = new String("title_url");
							nm.carbon[2][95][0] = new String(temp12);//total left
							nm.carbon[2][96][0] = new String(order.getGrandTotal().toString());//total_sale_amount
							nm.carbon[2][97][0] = new String(" ");//tracking number
							nm.carbon[2][98][0] = new String(nm.carbon[5][nm.id_mm][nm.current_submit_item_a]);//transaction_id Integer.toString(nm.current_submit_item_a)
							nm.carbon[2][99][0] = new String(orderid);//transaction_info

						} catch (Exception e) {System.out.println("FFFFFF");}




						//test tax
						int ixtest0 = nm.carbon[2][nm.sales_tax_xx][0].indexOf(".");
						if (ixtest0 > -1) {

							String cx0 = nm.carbon[2][nm.sales_tax_xx][0].substring(ixtest0, nm.carbon[2][nm.sales_tax_xx][0].length());

							     if (cx0.length() == 1) {nm.carbon[2][nm.sales_tax_xx][0] = nm.carbon[2][nm.sales_tax_xx][0] + "00";}
							else if (cx0.length() == 2) {nm.carbon[2][nm.sales_tax_xx][0] = nm.carbon[2][nm.sales_tax_xx][0] + "0";}
							else if (cx0.length() == 4) {nm.carbon[2][nm.sales_tax_xx][0] = nm.carbon[2][nm.sales_tax_xx][0].substring(0, nm.carbon[2][nm.sales_tax_xx][0].length() -1);}

						}//**********



						//test shipping
						int ixtest1 = nm.carbon[2][nm.shipping_in_xx][0].indexOf(".");
						if (ixtest1 > -1) {

							String cx0 = nm.carbon[2][nm.shipping_in_xx][0].substring(ixtest1, nm.carbon[2][nm.shipping_in_xx][0].length());

							if(cx0.length() == 1){nm.carbon[2][nm.shipping_in_xx][0] = nm.carbon[2][nm.shipping_in_xx][0] + "00";}
							else if(cx0.length() == 2){nm.carbon[2][nm.shipping_in_xx][0] = nm.carbon[2][nm.shipping_in_xx][0] + "0";}
							else if(cx0.length() == 4){nm.carbon[2][nm.shipping_in_xx][0] = nm.carbon[2][nm.shipping_in_xx][0].substring(0, nm.carbon[2][nm.shipping_in_xx][0].length() -1);}

						}//**********


						System.out.println(order.getShippingAddress().getStreet().toString().replace("\n","").replace("\r",""));
						System.out.println(order.getShippingAddress().getStreet().toString().length());



						//System.out.println(order.getModel().getCreatedAtStoreDate().toString());
						//System.exit(0);

						change_name_country();




						//don't ship error items
						if (item_match != 1) {nm.carbon[2][85][0] = new String("Error");}//sale status

						//change ship type if quanitity is too high. 
						try {

							int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
							int ix4 = Integer.parseInt(nm.carbon[5][magento_settings.ship_change_quantity_xx][nm.current_submit_item_a]);

							System.out.println(ix3);
							System.out.println(ix4);
							//System.exit(0);

							if (ix3 >= ix4) {

								int ix5 = Integer.parseInt(nm.carbon[5][magento_settings.ship_change_field_xx][nm.current_submit_item_a]);
								nm.carbon[2][ix5][0] = nm.carbon[5][magento_settings.ship_change_type_xx][nm.current_submit_item_a];

							}//**************

						} catch (Exception e) {System.out.println("Quantity ship type failed.");}




						//change ship type if quanitity is too high2. 
						try {

							int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
							int ix4 = Integer.parseInt(nm.carbon[5][magento_settings.ship_change_quantity_xx2][nm.current_submit_item_a]);

							System.out.println(ix3);
							System.out.println(ix4);
							//System.exit(0);

							if (ix3 >= ix4) {

								int ix5 = Integer.parseInt(nm.carbon[5][magento_settings.ship_change_field_xx2][nm.current_submit_item_a]);
								nm.carbon[2][ix5][0] = nm.carbon[5][magento_settings.ship_change_type_xx2][nm.current_submit_item_a];

							}//**************

						} catch (Exception e) {System.out.println("Quantity ship type2 failed.");}





						//change ship type if weight is too high. 
						try {

							int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
							int ix4 = Integer.parseInt(nm.carbon[2][nm.item_weight_xx][0]);
							int ix5 = Integer.parseInt(nm.carbon[5][magento_settings.ship_weight_change_quantity_xx][nm.current_submit_item_a]);

							System.out.println(ix3);
							System.out.println(ix4);
							System.out.println((ix3 * ix4) + " " + ix5);
							//System.exit(0);

							if ((ix3 * ix4) > ix5 && ix3 > 1) {

								System.out.println("yes change");
								ix5 = Integer.parseInt(nm.carbon[5][magento_settings.ship_weight_change_field_xx][nm.current_submit_item_a]);
								nm.carbon[2][ix5][0] = nm.carbon[5][magento_settings.ship_weight_change_type_xx][nm.current_submit_item_a];

							}//********************************

						} catch (Exception e) {System.out.println("Weight ship type failed.");}
 



						//change ship type if weight is too high. 
						try {

							int ix3 = Integer.parseInt(nm.carbon[2][nm.quantity_sold_xx][0]);
							int ix4 = Integer.parseInt(nm.carbon[2][nm.item_weight_xx][0]);
							int ix5 = Integer.parseInt(nm.carbon[5][magento_settings.ship_weight_change_quantity_xx2][nm.current_submit_item_a]);

							System.out.println(ix3);
							System.out.println(ix4);
							System.out.println((ix3 * ix4) + " " + ix5);
							//System.exit(0);

							if ((ix3 * ix4) > ix5 && ix3 > 1) {

								System.out.println("yes change");
								ix5 = Integer.parseInt(nm.carbon[5][magento_settings.ship_weight_change_field_xx2][nm.current_submit_item_a]);
								nm.carbon[2][ix5][0] = nm.carbon[5][magento_settings.ship_weight_change_type_xx2][nm.current_submit_item_a];

							}//********************************

						} catch (Exception e) {System.out.println("Weight ship type failed2.");}





						//change wrong country name
						try {

							change_name_country();

						} catch(Exception e) {System.out.println("failed.");}




						//add to database
						String[][] sale_xn = new String[ nm.carbon[2].length ][1];


						for (int xloopx = 0; xloopx < nm.carbon[2].length; xloopx++) {//***

							sale_xn[xloopx][0] = nm.carbon[2][xloopx][0];

						}//****************************************************************


						//add to database
						jdb_new_sale saves = new jdb_new_sale(sale_xn);


						System.out.println("NND " + nm.carbon[2][84][0]);

						//ix5++;
						//carbon_items++;




					}//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

				}//if*******************************************************************************************************working

			}//**********************************************************************************************************************************************

		} catch(Exception e) {System.out.println("XXXX987987");}//**************************************************************************************************************************


	}//get orders//*********************************************************************************************************************************









	public void change_name_country() {

		if (nm.carbon[2][4][0].equals("USA")) {nm.carbon[2][4][0] = new String("United States");}
		if (nm.carbon[2][4][0].equals("US")) {nm.carbon[2][4][0] = new String("United States");}
		if (nm.carbon[2][4][0].equals("Russian Federation")) {nm.carbon[2][4][0] = new String("Russia");}
		if (nm.carbon[2][4][0].equals("Turkey")) {nm.carbon[2][4][0] = new String("Turker");}
		if (nm.carbon[2][4][0].equals("Puerto Rico")){nm.carbon[2][4][0] = new String("United States");}
		if (nm.carbon[2][4][0].equals("PR")) {nm.carbon[2][4][0] = new String("United States");}
		if (nm.carbon[2][4][0].equals("FM")) {nm.carbon[2][4][0] = new String("United States");}


		if (nm.carbon[2][2][0].equals("null")) {nm.carbon[2][2][0] = new String("PR");}


		System.out.println("X" + nm.carbon[2][4][0] + "X");
		System.out.println("X" + nm.carbon[2][2][0] + "X");


		//System.out.println(nm.carbon[2][4][1]);
		//System.exit(0);

	}//*******************************








    public void pullThePlug() {

    	System.out.println("PULL THE PLUG");

    	nm.sales_import_done = true;

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull







    public static void main(String[] args){

		magento_import_sales xr = new magento_import_sales();

    }//main





	class BackgroundPanel extends JPanel {
	  	
	  	Image image;

	  	public BackgroundPanel(){
	    
	    	try {

	      		image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3b.jpg"), "background3b.jpg"));

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
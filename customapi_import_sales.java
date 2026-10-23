import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;



public class customapi_import_sales extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Importing sales.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int csv_passes_x = 17;
int kcountxx = 0;
int kcountxx2 = 0;
int csv_int = 0;
int working = 1; 
int thisc2 = 0; 
int thisc3 = 0;
int stop = 0;
int post_number = 1;
int db_items = 0;
int carbon_items; 
int running = 0;
int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0;
int ix6 = 0;
int ix7 = 0;
int ix1x = 0;
int ix0x = 0;
int lineitems = 0;
int websites = 50;
int HTMLINT = 0;
int looppx = 0;
int current_submit_item_xx = -1;

String[] carbonfiber = new String[82];
String[][] silver = new String[1][1];
String[] bufferarray;
String xlinex = new String("");
String blank = new String("");
String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");
String HTMLGO = new String("");
String total_on_hand_now = new String("");
String temp0 = new String("0.01");
String temp1 = new String("0.00");
String temp2 = new String("1");
String temp3 = new String("10");
String temp4 = new String("5");
String temp5 = new String("5");
String temp6 = new String("0.00");
String temp8 = new String("");
String item_json_text = new String("");

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








customapi_import_sales(int ssxs){//****************************

	super("Custom API Import Sales");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	setDefaultLookAndFeelDecorated(false);
	setUndecorated(true);
    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){running = 0;}});


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	Icon aicon = new ImageIcon(ximagex);

	current_submit_item_xx = ssxs;

	System.out.println("current_submit_item_xx " + current_submit_item_xx);

	infox0.setPreferredSize(new Dimension(320, 80));
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 1.1.1");
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
	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);


	infox1.setText("Import items");
	infox2.setText("Get Sale_ID list...");

	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(nm.blackx);
	cpx.setForeground(nm.whitex);
	cpx.add(bkp);




	if(nm.run_silent == 0){setVisible(true);}
	else{System.out.println("RUN SILENT");}



	requestFocus();
	repaint();

	connectx();


}//csv_loader_x1********************************************************











	public void connectx(){

		String jsontext = new String("");


		String data;
		URL url;
		OutputStreamWriter wr;
		BufferedReader rd;
		URLConnection conn;

		System.out.println("nm.carbon[5][1][current_submit_item_xx] " + nm.carbon[5][1][current_submit_item_xx]);

		db_items = 0;




		// get list data
		try {

           	data = URLEncoder.encode("user", "UTF-8")        + "=" + URLEncoder.encode(nm.carbon[5][2][current_submit_item_xx], "UTF-8");
    		data += "&" + URLEncoder.encode("password", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[5][3][current_submit_item_xx], "UTF-8");
    		data += "&" + URLEncoder.encode("time", "UTF-8")        + "=" + URLEncoder.encode(nm.carbon[5][nm.sales_days_past_xx][current_submit_item_xx], "UTF-8");


			HTMLGO = nm.carbon[5][1][current_submit_item_xx];

			System.out.println(data);
			System.out.println(HTMLGO + "/dbx_export_sales_ids.php");

    		// Send data
    		url = new URL(HTMLGO + "/dbx_export_sales_ids.php");
    		conn = url.openConnection();
    		conn.setDoOutput(true);
    		wr = new OutputStreamWriter(conn.getOutputStream());
    		wr.write(data);
    		wr.flush();

    		// Get the response
    		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;
    		while ((line = rd.readLine()) != null) {

    			jsontext = line;

    		}//while
   			wr.close();
    		rd.close();

		} catch (Exception e) {System.out.println("URL falure get item list.");}


		try {


			System.out.println(jsontext);

			JSONParser parser = new JSONParser();

			Object obj = parser.parse(jsontext);
 
			JSONArray array = (JSONArray)obj;

			bufferarray = new String[array.size()];
			db_items = array.size();

			for (int loop = 0; loop < array.size(); loop++) {

        		System.out.println(array.get(loop));
				bufferarray[loop] = new String(array.get(loop).toString());
        		System.out.println();

			}//********************************************&&


		} catch (Exception e) {e.printStackTrace();}



		ix5 = 1;
		//import items


		System.out.println("db_items " + db_items);	
		carbon_items = 0;

		for (int xloopx = 0; xloopx < db_items; xloopx++) {//********************************************************************

			infox1.setText("Import item: " + (xloopx + 1) + " of " + db_items);

			//see if item is already imported
			for (int xloopx2 = 0; xloopx2 < nm.carbon[2][nm.sale_id_xx].length; xloopx2++) {//***************
		
				ix3 = 0;
				System.out.println(xloopx2 + " " + nm.carbon[2][nm.sale_id_xx].length + " " + nm.carbon[2][nm.sale_id_xx][xloopx2]);
				ix4 = bufferarray[xloopx].indexOf(nm.carbon[2][nm.sale_id_xx][xloopx2]);
				if(ix4 > -1){ix3++; System.out.println(" 77 " + nm.carbon[2][nm.sale_id_xx][xloopx2]); break;}

			}//for*******************************************************************************************
			//see if item is already imported


			//see if item is already imported in the archived
			for (int xloopx2 = 0; xloopx2 < nm.carbon[3][nm.sale_id_xx].length; xloopx2++) {//***************
	
				ix4 = 0;
				System.out.println(xloopx2 + " " + nm.carbon[3][nm.sale_id_xx].length + " " + nm.carbon[3][nm.sale_id_xx][xloopx2]);
				ix5 = bufferarray[xloopx].indexOf(nm.carbon[3][nm.sale_id_xx][xloopx2]);
				if(ix5 > -1){ix4++; System.out.println(" 77 " + nm.carbon[3][nm.sale_id_xx][xloopx2]); break;}

			}//for*******************************************************************************************
			//see if item is already imported in the archived



			//only import inventoried sales if requested.
			try {

				//some items from ebay could be missing info.
				try {

					cx0 = bufferarray[xloopx];

				} catch (Exception e) {e.printStackTrace(); ix3 = 1;}


				if (nm.carbon[5][nm.import_everything_xx][nm.current_submit_item_a].equals("1") && ix3 == 0) {
					
					System.out.println(cx0);
 					for (int xloopx1 = 1; xloopx1 < (nm.carbon[0][0].length); xloopx1++) {//***************
 	
 						if (ix3 == 0) {ix3 = 2;}

						//System.out.println(nm.carbon[0][nm.part_number_xx][xloopx1]);
 						if (cx0.equals(nm.carbon[0][nm.part_number_xx][xloopx1])) {ix3 = 0; break;}//******

 					}//**********************************************************************************

				}//if***************************************************

			} catch (Exception e) {e.printStackTrace();}




			if (ix3 == 0 && ix4 == 0) {looppx = xloopx; add_item(); ix5++; carbon_items++;}
			else {System.out.println("getx item already imported.");}//carbon_items++;


			requestFocus();

		}//for*****************************************************************************************************************



		pullThePlug();

	}//connectx()*********************************************************************************************








	public void add_item(){//******************************************************************


		String data;
		URL url;
		OutputStreamWriter wr;
		BufferedReader rd;
		URLConnection conn;



		String x_address_1 = new String("");
		String x_address_2 = new String("");
		String x_address_3 = new String("");
		String x_address_4 = new String("");
		String x_address_5 = new String("");
		String x_address_6 = new String("");
		String x_buyer_id = new String("");
		String x_buyers_email = new String("");
		String x_buyers_first_name = new String("");
		String x_buyers_last_name = new String("");
		String x_buyers_notes = new String("");
		String x_buyers_phone = new String("");
		String x_currency = new String("");
		String x_custom_1 = new String("");
		String x_custom_2 = new String("");
		String x_custom_3 = new String("");
		String x_custom_4 = new String("");
		String x_custom_5 = new String("");
		String x_custom_6 = new String("");
		String x_custom_7 = new String("");
		String x_custom_8 = new String("");
		String x_custom_9 = new String("");
		String x_custom_10 = new String("");
		String x_custom_11 = new String("");
		String x_custom_12 = new String("");
		String x_custom_13 = new String("");
		String x_custom_14 = new String("");
		String x_custom_15 = new String("");
		String x_custom_16 = new String("");
		String x_custom_17 = new String("");
		String x_custom_18 = new String("");
		String x_custom_19 = new String("");
		String x_custom_20 = new String("");
		String x_custom_21 = new String("");
		String x_custom_22 = new String("");
		String x_custom_23 = new String("");
		String x_custom_24 = new String("");
		String x_custom_25 = new String("");
		String x_custom_26 = new String("");
		String x_custom_27 = new String("");
		String x_custom_28 = new String("");
		String x_custom_29 = new String("");
		String x_custom_30 = new String("");
		String x_custom_31 = new String("");
		String x_custom_32 = new String("");
		String x_custom_33 = new String("");
		String x_custom_34 = new String("");
		String x_custom_35 = new String("");
		String x_custom_36 = new String("");
		String x_custom_37 = new String("");
		String x_custom_38 = new String("");
		String x_custom_39 = new String("");
		String x_custom_40 = new String("");
		String x_custom_41 = new String("");
		String x_custom_42 = new String("");
		String x_custom_43 = new String("");
		String x_custom_44 = new String("");
		String x_custom_45 = new String("");
		String x_custom_46 = new String("");
		String x_custom_template = new String("");
		String x_date_last_modified = new String("");
		String x_date_payment_received = new String("");
		String x_date_shipped = new String("");
		String x_date_sold = new String("");
		String x_ebay_item = new String("");
		String x_final_value_fee = new String("");
		String x_handling = new String("");
		String x_hits = new String("");
		String x_item_cost = new String("");
		String x_item_description = new String("");
		String x_item_id = new String("");
		String x_item_price = new String("");
		String x_item_weight = new String("");
		String x_listing_fees = new String("");
		String x_listing_id = new String("");
		String x_notes = new String("");
		String x_package_d = new String("");
		String x_package_l = new String("");
		String x_package_w = new String("");
		String x_part_number = new String("");
		String x_payment_type = new String("");
		String x_paypal_fees = new String("");
		String x_picture_1 = new String("");
		String x_quantity_sold = new String("");
		String x_sale_id = new String("");
		String x_sale_status = new String("");
		String x_sales_tax = new String("");
		String x_shipping_company = new String("");
		String x_shipping_in = new String("");
		String x_shipping_out = new String("");
		String x_site_id = new String("");
		String x_site_url = new String("");
		String x_source_of_sale = new String("");
		String x_title = new String("");
		String x_title_url = new String("");
		String x_total_on_hand = new String("");
		String x_total_sale_amount = new String("");
		String x_tracking_number = new String("");
		String x_transaction_id = new String("");
		String x_transaction_info = new String("");





		silver = new String[nm.db_cc_number][nm.carbon[2][0].length + 1];
		System.out.println("silver length " + silver[0].length);


		ix6 = 0;
		for (int xloop1 = 1; xloop1 < silver[0].length; xloop1++) {//***********************************

			for (int xloop2 = 0; xloop2 < nm.db_cc_number; xloop2++) {//************************

				silver[xloop2][xloop1] = nm.carbon[2][xloop2][ix6]; 

			}//for****************************************************************************

			ix6++;

		}//for*****************************************************************************************





		// get items*************************************************************************************************
		try {



           	data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[5][2][current_submit_item_xx], "UTF-8");
   			data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[5][3][current_submit_item_xx], "UTF-8");
    		data += "&" + URLEncoder.encode("item", "UTF-8")     + "=" + URLEncoder.encode(bufferarray[looppx], "UTF-8");

			System.out.println(HTMLGO + "/dbx_export_sales.php" + data);


    		// Send data
    		url = new URL(HTMLGO + "/dbx_export_sales.php");
    		conn = url.openConnection();
    		conn.setDoOutput(true);
    		wr = new OutputStreamWriter(conn.getOutputStream());
    		wr.write(data);
    		wr.flush();

    		// Get the response
    		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

    		String line;
    		lineitems = 0;

    		while ((line = rd.readLine()) != null) {

				item_json_text = line;
				System.out.println("dd " + line);
				lineitems++;

    		}//while
    		wr.close();
    		rd.close();

		} catch (Exception e) {System.out.println("URL falure."); infox0.setText("URL falure.");}



		System.out.println(item_json_text);



		silver[0] [0] = new String("address_1");
		silver[1] [0] = new String("address_2");
		silver[2] [0] = new String("address_3");
		silver[3] [0] = new String("address_4");
		silver[4] [0] = new String("address_5");
		silver[5] [0] = new String("address_6");
		silver[6] [0] = new String("buyer_id");
		silver[7] [0] = new String("buyers_email");
		silver[8] [0] = new String("buyers_first_name");
		silver[9] [0] = new String("buyers_last_name");
		silver[10][0] = new String("buyers_notes");
		silver[11][0] = new String("buyers_phone");
		silver[12][0] = new String("currency");
		silver[13][0] = new String("custom_1");
		silver[14][0] = new String("custom_2");
		silver[15][0] = new String("custom_3");
		silver[16][0] = new String("custom_4");
		silver[17][0] = new String("custom_5");
		silver[18][0] = new String("custom_6");
		silver[19][0] = new String("custom_7");
		silver[20][0] = new String("custom_8");
		silver[21][0] = new String("custom_9");
		silver[22][0] = new String("custom_10");
		silver[23][0] = new String("custom_11");
		silver[24][0] = new String("custom_12");
		silver[25][0] = new String("custom_13");
		silver[26][0] = new String("custom_14");
		silver[27][0] = new String("custom_15");
		silver[28][0] = new String("custom_16");
		silver[29][0] = new String("custom_17");
		silver[30][0] = new String("custom_18");
		silver[31][0] = new String("custom_19");
		silver[32][0] = new String("custom_20");
		silver[33][0] = new String("custom_21");
		silver[34][0] = new String("custom_22");
		silver[35][0] = new String("custom_23");
		silver[36][0] = new String("custom_24");
		silver[37][0] = new String("custom_25");
		silver[38][0] = new String("custom_26");
		silver[39][0] = new String("custom_27");
		silver[40][0] = new String("custom_28");
		silver[41][0] = new String("custom_29");
		silver[42][0] = new String("custom_30");
		silver[43][0] = new String("custom_31");
		silver[44][0] = new String("custom_32");
		silver[45][0] = new String("custom_33");
		silver[46][0] = new String("custom_34");
		silver[47][0] = new String("custom_35");
		silver[48][0] = new String("custom_36");
		silver[49][0] = new String("custom_37");
		silver[50][0] = new String("custom_38");
		silver[51][0] = new String("custom_39");
		silver[52][0] = new String("custom_40");
		silver[53][0] = new String("custom_41");
		silver[54][0] = new String("custom_42");
		silver[55][0] = new String("custom_43");
		silver[56][0] = new String("custom_44");
		silver[57][0] = new String("custom_45");
		silver[58][0] = new String("custom_46");
		silver[59][0] = new String("custom_template");
		silver[60][0] = new String("date_last_modified");
		silver[61][0] = new String("date_payment_received");
		silver[62][0] = new String("date_shipped");
		silver[63][0] = new String("date_sold");
		silver[64][0] = new String("ebay_item");
		silver[65][0] = new String("final_value_fee");
		silver[66][0] = new String("handling");
		silver[67][0] = new String("hits");
		silver[68][0] = new String("item_cost");
		silver[69][0] = new String("item_description");
		silver[70][0] = new String("item_id");
		silver[71][0] = new String("item_price");
		silver[72][0] = new String("item_weight");
		silver[73][0] = new String("listing_fees");
		silver[74][0] = new String("listing_id");
		silver[75][0] = new String("notes");
		silver[76][0] = new String("package_d");
		silver[77][0] = new String("package_l");
		silver[78][0] = new String("package_w");
		silver[79][0] = new String("part_number");
		silver[80][0] = new String("payment_type");
		silver[81][0] = new String("paypal_fees");
		silver[82][0] = new String("picture_1");
		silver[83][0] = new String("quantity_sold");
		silver[84][0] = new String("sale_id");
		silver[85][0] = new String("sale_status");
		silver[86][0] = new String("sales_tax");
		silver[87][0] = new String("shipping_company");
		silver[88][0] = new String("shipping_in");
		silver[89][0] = new String("shipping_out");
		silver[90][0] = new String("site_id");
		silver[91][0] = new String("site_url");
		silver[92][0] = new String("source_of_sale");
		silver[93][0] = new String("title");
		silver[94][0] = new String("title_url");
		silver[95][0] = new String("total_on_hand");
		silver[96][0] = new String("total_sale_amount");
		silver[97][0] = new String("tracking_number");
		silver[98][0] = new String("transaction_id");
		silver[99][0] = new String("transaction_info");





		for(int xloop1 = 0; xloop1 < nm.carbon[0][0].length; xloop1++){//**************************************

			if(bufferarray[looppx].equals(nm.carbon[0][nm.part_number_xx][xloop1])){

				silver[0] [1] = nm.carbon[0][0][xloop1];
				silver[1] [1] = nm.carbon[0][1][xloop1];
				silver[2] [1] = nm.carbon[0][2][xloop1];
				silver[3] [1] = nm.carbon[0][3][xloop1];
				silver[4] [1] = nm.carbon[0][4][xloop1];
				silver[5] [1] = nm.carbon[0][5][xloop1];
				silver[6] [1] = nm.carbon[0][6][xloop1];
				silver[7] [1] = nm.carbon[0][7][xloop1];
				silver[8] [1] = nm.carbon[0][8][xloop1];
				silver[9] [1] = nm.carbon[0][9][xloop1];
				silver[10][1] = nm.carbon[0][10][xloop1];
				silver[11][1] = nm.carbon[0][11][xloop1];
				silver[12][1] = nm.carbon[0][12][xloop1];
				silver[13][1] = nm.carbon[0][13][xloop1];
				silver[14][1] = nm.carbon[0][14][xloop1];
				silver[15][1] = nm.carbon[0][15][xloop1];
				silver[16][1] = nm.carbon[0][16][xloop1];
				silver[17][1] = nm.carbon[0][17][xloop1];
				silver[18][1] = nm.carbon[0][18][xloop1];
				silver[19][1] = nm.carbon[0][19][xloop1];
				silver[20][1] = nm.carbon[0][20][xloop1];
				silver[21][1] = nm.carbon[0][21][xloop1];
				silver[22][1] = nm.carbon[0][22][xloop1];
				silver[23][1] = nm.carbon[0][23][xloop1];
				silver[24][1] = nm.carbon[0][24][xloop1];
				silver[25][1] = nm.carbon[0][25][xloop1];
				silver[26][1] = nm.carbon[0][26][xloop1];
				silver[27][1] = nm.carbon[0][27][xloop1];
				silver[28][1] = nm.carbon[0][28][xloop1];
				silver[29][1] = nm.carbon[0][29][xloop1];
				silver[30][1] = nm.carbon[0][30][xloop1];
				silver[31][1] = nm.carbon[0][31][xloop1];
				silver[32][1] = nm.carbon[0][32][xloop1];
				silver[33][1] = nm.carbon[0][33][xloop1];
				silver[34][1] = nm.carbon[0][34][xloop1];
				silver[35][1] = nm.carbon[0][35][xloop1];
				silver[36][1] = nm.carbon[0][36][xloop1];
				silver[37][1] = nm.carbon[0][37][xloop1];
				silver[38][1] = nm.carbon[0][38][xloop1];
				silver[39][1] = nm.carbon[0][39][xloop1];
				silver[40][1] = nm.carbon[0][40][xloop1];
				silver[41][1] = nm.carbon[0][41][xloop1];
				silver[42][1] = nm.carbon[0][42][xloop1];
				silver[43][1] = nm.carbon[0][43][xloop1];
				silver[44][1] = nm.carbon[0][44][xloop1];
				silver[45][1] = nm.carbon[0][45][xloop1];
				silver[46][1] = nm.carbon[0][46][xloop1];
				silver[47][1] = nm.carbon[0][47][xloop1];
				silver[48][1] = nm.carbon[0][48][xloop1];
				silver[49][1] = nm.carbon[0][49][xloop1];
				silver[50][1] = nm.carbon[0][50][xloop1];
				silver[51][1] = nm.carbon[0][51][xloop1];
				silver[52][1] = nm.carbon[0][52][xloop1];
				silver[53][1] = nm.carbon[0][53][xloop1];
				silver[54][1] = nm.carbon[0][54][xloop1];
				silver[55][1] = nm.carbon[0][55][xloop1];
				silver[56][1] = nm.carbon[0][56][xloop1];
				silver[57][1] = nm.carbon[0][57][xloop1];
				silver[58][1] = nm.carbon[0][58][xloop1];
				silver[59][1] = nm.carbon[0][59][xloop1];
				silver[60][1] = nm.carbon[0][60][xloop1];
				silver[61][1] = nm.carbon[0][61][xloop1];
				silver[62][1] = nm.carbon[0][62][xloop1];
				silver[63][1] = nm.carbon[0][63][xloop1];
				silver[64][1] = nm.carbon[0][64][xloop1];
				silver[65][1] = nm.carbon[0][65][xloop1];
				silver[66][1] = nm.carbon[0][66][xloop1];
				silver[67][1] = nm.carbon[0][67][xloop1];
				silver[68][1] = nm.carbon[0][68][xloop1];
				silver[69][1] = nm.carbon[0][69][xloop1];
				silver[70][1] = nm.carbon[0][70][xloop1];
				silver[71][1] = nm.carbon[0][71][xloop1];
				silver[72][1] = nm.carbon[0][72][xloop1];
				silver[73][1] = nm.carbon[0][73][xloop1];
				silver[74][1] = nm.carbon[0][74][xloop1];
				silver[75][1] = nm.carbon[0][75][xloop1];
				silver[76][1] = nm.carbon[0][76][xloop1];
				silver[77][1] = nm.carbon[0][77][xloop1];
				silver[78][1] = nm.carbon[0][78][xloop1];
				silver[79][1] = nm.carbon[0][79][xloop1];
				silver[80][1] = nm.carbon[0][80][xloop1];
				silver[81][1] = nm.carbon[0][81][xloop1];
				silver[82][1] = nm.carbon[0][82][xloop1];
				silver[83][1] = nm.carbon[0][83][xloop1];
				silver[84][1] = nm.carbon[0][84][xloop1];
				silver[85][1] = nm.carbon[0][85][xloop1];
				silver[86][1] = nm.carbon[0][86][xloop1];
				silver[87][1] = nm.carbon[0][87][xloop1];
				silver[88][1] = nm.carbon[0][88][xloop1];
				silver[89][1] = nm.carbon[0][89][xloop1];
				silver[90][1] = nm.carbon[0][90][xloop1];
				silver[91][1] = nm.carbon[0][91][xloop1];
				silver[92][1] = nm.carbon[0][92][xloop1];
				silver[93][1] = nm.carbon[0][93][xloop1];
				silver[94][1] = nm.carbon[0][94][xloop1];
				silver[95][1] = nm.carbon[0][95][xloop1];
				silver[96][1] = nm.carbon[0][96][xloop1];
				silver[97][1] = nm.carbon[0][97][xloop1];
				silver[98][1] = nm.carbon[0][98][xloop1];
				silver[99][1] = nm.carbon[0][99][xloop1];

			}//if****************************************************************

		}//***********************************************************************************************





		ix7 = 0;
		//test site




		try {

			JSONParser parser = new JSONParser();

			Object obj = parser.parse(item_json_text);
 
			JSONObject jsonObject = (JSONObject) obj;
  
			try {x_address_1 =             (String) jsonObject.get("address_1");}                catch (Exception e) {x_address_1 = new String("");}
			try {x_address_2 =             (String) jsonObject.get("address_2");}                catch (Exception e) {x_address_2 = new String("");}
			try {x_address_3 =             (String) jsonObject.get("address_3");}                catch (Exception e) {x_address_3 = new String("");}
			try {x_address_4 =             (String) jsonObject.get("address_4");}                catch (Exception e) {x_address_4 = new String("");}
			try {x_address_5 =             (String) jsonObject.get("address_5");}                catch (Exception e) {x_address_5 = new String("");}
			try {x_address_6 =             (String) jsonObject.get("address_6");}                catch (Exception e) {x_address_6 = new String("");}
			try {x_buyer_id =              (String) jsonObject.get("buyer_id");}                 catch (Exception e) {x_buyer_id = new String("");}
			try {x_buyers_email =          (String) jsonObject.get("buyers_email");}             catch (Exception e) {x_buyers_email = new String("");}
			try {x_buyers_first_name =     (String) jsonObject.get("buyers_first_name");}        catch (Exception e) {x_buyers_first_name = new String("");}
			try {x_buyers_last_name =      (String) jsonObject.get("buyers_last_name");}         catch (Exception e) {x_buyers_last_name = new String("");}
			try {x_buyers_notes =          (String) jsonObject.get("buyers_notes");}             catch (Exception e) {x_buyers_notes = new String("");}
			try {x_buyers_phone =          (String) jsonObject.get("buyers_phone");}             catch (Exception e) {x_buyers_phone = new String("");}
			try {x_currency =              (String) jsonObject.get("currency");}                 catch (Exception e) {x_currency = new String("");}
			try {x_custom_1 =              (String) jsonObject.get("custom_1");}                 catch (Exception e) {x_custom_1 = new String("");}
			try {x_custom_2 =              (String) jsonObject.get("custom_2");}                 catch (Exception e) {x_custom_2 = new String("");}
			try {x_custom_3 =              (String) jsonObject.get("custom_3");}                 catch (Exception e) {x_custom_3 = new String("");}
			try {x_custom_4 =              (String) jsonObject.get("custom_4");}                 catch (Exception e) {x_custom_4 = new String("");}
			try {x_custom_5 =              (String) jsonObject.get("custom_5");}                 catch (Exception e) {x_custom_5 = new String("");}
			try {x_custom_6 =              (String) jsonObject.get("custom_6");}                 catch (Exception e) {x_custom_6 = new String("");}
			try {x_custom_7 =              (String) jsonObject.get("custom_7");}                 catch (Exception e) {x_custom_7 = new String("");}
			try {x_custom_8 =              (String) jsonObject.get("custom_8");}                 catch (Exception e) {x_custom_8 = new String("");}
			try {x_custom_9 =              (String) jsonObject.get("custom_9");}                 catch (Exception e) {x_custom_9 = new String("");}
			try {x_custom_10 =             (String) jsonObject.get("custom_10");}                catch (Exception e) {x_custom_10 = new String("");}
			try {x_custom_11 =             (String) jsonObject.get("custom_11");}                catch (Exception e) {x_custom_11 = new String("");}
			try {x_custom_12 =             (String) jsonObject.get("custom_12");}                catch (Exception e) {x_custom_12 = new String("");}
			try {x_custom_13 =             (String) jsonObject.get("custom_13");}                catch (Exception e) {x_custom_13 = new String("");}
			try {x_custom_14 =             (String) jsonObject.get("custom_14");}                catch (Exception e) {x_custom_14 = new String("");}
			try {x_custom_15 =             (String) jsonObject.get("custom_15");}                catch (Exception e) {x_custom_15 = new String("");}
			try {x_custom_16 =             (String) jsonObject.get("custom_16");}                catch (Exception e) {x_custom_16 = new String("");}
			try {x_custom_17 =             (String) jsonObject.get("custom_17");}                catch (Exception e) {x_custom_17 = new String("");}
			try {x_custom_18 =             (String) jsonObject.get("custom_18");}                catch (Exception e) {x_custom_18 = new String("");}
			try {x_custom_19 =             (String) jsonObject.get("custom_19");}                catch (Exception e) {x_custom_19 = new String("");}
			try {x_custom_20 =             (String) jsonObject.get("custom_20");}                catch (Exception e) {x_custom_20 = new String("");}
			try {x_custom_21 =             (String) jsonObject.get("custom_21");}                catch (Exception e) {x_custom_21 = new String("");}
			try {x_custom_22 =             (String) jsonObject.get("custom_22");}                catch (Exception e) {x_custom_22 = new String("");}
			try {x_custom_23 =             (String) jsonObject.get("custom_23");}                catch (Exception e) {x_custom_23 = new String("");}
			try {x_custom_24 =             (String) jsonObject.get("custom_24");}                catch (Exception e) {x_custom_24 = new String("");}
			try {x_custom_25 =             (String) jsonObject.get("custom_25");}                catch (Exception e) {x_custom_25 = new String("");}
			try {x_custom_26 =             (String) jsonObject.get("custom_26");}                catch (Exception e) {x_custom_26 = new String("");}
			try {x_custom_27 =             (String) jsonObject.get("custom_27");}                catch (Exception e) {x_custom_27 = new String("");}
			try {x_custom_28 =             (String) jsonObject.get("custom_28");}                catch (Exception e) {x_custom_28 = new String("");}
			try {x_custom_29 =             (String) jsonObject.get("custom_29");}                catch (Exception e) {x_custom_29 = new String("");}
			try {x_custom_30 =             (String) jsonObject.get("custom_30");}                catch (Exception e) {x_custom_30 = new String("");}
			try {x_custom_31 =             (String) jsonObject.get("custom_31");}                catch (Exception e) {x_custom_31 = new String("");}
			try {x_custom_32 =             (String) jsonObject.get("custom_32");}                catch (Exception e) {x_custom_32 = new String("");}
			try {x_custom_33 =             (String) jsonObject.get("custom_33");}                catch (Exception e) {x_custom_33 = new String("");}
			try {x_custom_34 =             (String) jsonObject.get("custom_34");}                catch (Exception e) {x_custom_34 = new String("");}
			try {x_custom_35 =             (String) jsonObject.get("custom_35");}                catch (Exception e) {x_custom_35 = new String("");}
			try {x_custom_36 =             (String) jsonObject.get("custom_36");}                catch (Exception e) {x_custom_36 = new String("");}
			try {x_custom_37 =             (String) jsonObject.get("custom_37");}                catch (Exception e) {x_custom_37 = new String("");}
			try {x_custom_38 =             (String) jsonObject.get("custom_38");}                catch (Exception e) {x_custom_38 = new String("");}
			try {x_custom_39 =             (String) jsonObject.get("custom_39");}                catch (Exception e) {x_custom_39 = new String("");}
			try {x_custom_40 =             (String) jsonObject.get("custom_40");}                catch (Exception e) {x_custom_40 = new String("");}
			try {x_custom_41 =             (String) jsonObject.get("custom_41");}                catch (Exception e) {x_custom_41 = new String("");}
			try {x_custom_42 =             (String) jsonObject.get("custom_42");}                catch (Exception e) {x_custom_42 = new String("");}
			try {x_custom_43 =             (String) jsonObject.get("custom_43");}                catch (Exception e) {x_custom_43 = new String("");}
			try {x_custom_44 =             (String) jsonObject.get("custom_44");}                catch (Exception e) {x_custom_44 = new String("");}
			try {x_custom_45 =             (String) jsonObject.get("custom_45");}                catch (Exception e) {x_custom_45 = new String("");}
			try {x_custom_46 =             (String) jsonObject.get("custom_46");}                catch (Exception e) {x_custom_46 = new String("");}
			try {x_custom_template =       (String) jsonObject.get("custom_template");}          catch (Exception e) {x_custom_template = new String("");}
			try {x_date_last_modified =    (String) jsonObject.get("date_last_modified");}       catch (Exception e) {x_date_last_modified = new String("");}
			try {x_date_payment_received = (String) jsonObject.get("date_payment_received");}    catch (Exception e) {x_date_payment_received = new String("");}
			try {x_date_shipped =          (String) jsonObject.get("date_shipped");}             catch (Exception e) {x_date_shipped = new String("");}
			try {x_date_sold =             (String) jsonObject.get("date_sold");}                catch (Exception e) {x_date_sold = new String("3000-12-12-24:32:14.000");}
			try {x_ebay_item =             (String) jsonObject.get("ebay_item");}                catch (Exception e) {x_ebay_item = new String("");}
			try {x_final_value_fee =       (String) jsonObject.get("final_value_fee");}          catch (Exception e) {x_final_value_fee = new String("");}
			try {x_handling =              (String) jsonObject.get("handling");}                 catch (Exception e) {x_handling = new String("");}
			try {x_hits =                  (String) jsonObject.get("hits");}                     catch (Exception e) {x_hits = new String("");}
			try {x_item_cost =             (String) jsonObject.get("item_cost");}                catch (Exception e) {x_item_cost = new String("0.00");}
			try {x_item_description =      (String) jsonObject.get("item_description");}         catch (Exception e) {x_item_description = new String("");}
			try {x_item_id =               (String) jsonObject.get("item_id");}                  catch (Exception e) {x_item_id = new String("");}
			try {x_item_price =            (String) jsonObject.get("item_price");}               catch (Exception e) {x_item_price = new String("0.00");}
			try {x_item_weight =           (String) jsonObject.get("item_weight");}              catch (Exception e) {x_item_weight = new String("16");}
			try {x_listing_fees =          (String) jsonObject.get("listing_fees");}             catch (Exception e) {x_listing_fees = new String("0.00");}
			try {x_listing_id =            (String) jsonObject.get("listing_id");}               catch (Exception e) {x_listing_id = new String("");}
			try {x_notes =                 (String) jsonObject.get("notes");}                    catch (Exception e) {x_notes = new String("");}
			try {x_package_d =             (String) jsonObject.get("package_d");}                catch (Exception e) {x_package_d = new String("1");}
			try {x_package_l =             (String) jsonObject.get("package_l");}                catch (Exception e) {x_package_l = new String("1");}
			try {x_package_w =             (String) jsonObject.get("package_w");}                catch (Exception e) {x_package_w = new String("1");}
			try {x_part_number =           (String) jsonObject.get("part_number");}              catch (Exception e) {x_part_number = new String("");}
			try {x_payment_type =          (String) jsonObject.get("payment_type");}             catch (Exception e) {x_payment_type = new String("");}
			try {x_paypal_fees =           (String) jsonObject.get("paypal_fees");}              catch (Exception e) {x_paypal_fees = new String("0.00");}
			try {x_picture_1 =             (String) jsonObject.get("picture_1");}                catch (Exception e) {x_picture_1 = new String("");}
			try {x_quantity_sold =         (String) jsonObject.get("quantity_sold");}            catch (Exception e) {x_quantity_sold = new String("0");}
			try {x_sale_id =               (String) jsonObject.get("sale_id");}                  catch (Exception e) {x_sale_id = new String("");}
			try {x_sale_status =           (String) jsonObject.get("sale_status");}              catch (Exception e) {x_sale_status = new String("error");}
			try {x_sales_tax =             (String) jsonObject.get("sales_tax");}                catch (Exception e) {x_sales_tax = new String("0.00");}
			try {x_shipping_company =      (String) jsonObject.get("shipping_company");}         catch (Exception e) {x_shipping_company = new String("");}
			try {x_shipping_in =           (String) jsonObject.get("shipping_in");}              catch (Exception e) {x_shipping_in = new String("0.00");}
			try {x_shipping_out =          (String) jsonObject.get("shipping_out");}             catch (Exception e) {x_shipping_out = new String("0.00");}
			try {x_site_id =               (String) jsonObject.get("site_id");}                  catch (Exception e) {x_site_id = new String("");}
			try {x_site_url =              (String) jsonObject.get("site_url");}                 catch (Exception e) {x_site_url = new String("");}
			try {x_source_of_sale =        (String) jsonObject.get("source_of_sale");}           catch (Exception e) {x_source_of_sale = new String("error");}
			try {x_title =                 (String) jsonObject.get("title");}                    catch (Exception e) {x_title = new String("");}
			try {x_title_url =             (String) jsonObject.get("title_url");}                catch (Exception e) {x_title_url = new String("");}
			try {x_total_on_hand =         (String) jsonObject.get("total_on_hand");}            catch (Exception e) {x_total_on_hand = new String("0");}
			try {x_total_sale_amount =     (String) jsonObject.get("total_sale_amount");}        catch (Exception e) {x_total_sale_amount = new String("");}
			try {x_tracking_number =       (String) jsonObject.get("tracking_number");}          catch (Exception e) {x_tracking_number = new String("");}
			try {x_transaction_id =        (String) jsonObject.get("transaction_id");}           catch (Exception e) {x_transaction_id = new String("");}
			try {x_transaction_info =      (String) jsonObject.get("transaction_info");}         catch (Exception e) {x_transaction_info = new String("");}


			try {

				if (x_date_sold.length() < 3) {x_date_sold = "3000-12-12-24:32:14.000";}

			} catch (Exception e) {x_date_sold = new String("3000-12-12-24:32:14.000");}

			System.out.println(x_paypal_fees);


			System.out.println(ix7);


		} catch (Exception e) {e.printStackTrace(); JOptionPane.showMessageDialog(null, "Import Error!");}




		System.out.println("nums " + (nm.carbon[2][0].length +1));

		for (int xloopx1 = 1; xloopx1 < (nm.carbon[0][0].length); xloopx1++) {//***************

			if (x_part_number.equals(nm.carbon[0][nm.part_number_xx][xloopx1])) {

				//quantity
				try {

					total_on_hand_now = "000";
					nm.carbon[0][nm.total_on_hand_xx][xloopx1] = Integer.toString( Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][xloopx1]) - Integer.parseInt(x_quantity_sold) );
					total_on_hand_now = nm.carbon[0][nm.total_on_hand_xx][xloopx1];

				} catch (Exception e) {System.out.println("Quantity update failed."); JOptionPane.showMessageDialog(null,"Quantity update failed.");}


				temp1 = nm.carbon[0][nm.item_cost_xx][xloopx1];
				temp2 = nm.carbon[0][nm.item_weight_xx][xloopx1];
				temp3 = nm.carbon[0][nm.package_d_xx][xloopx1];
				temp4 = nm.carbon[0][nm.package_l_xx][xloopx1];
				temp5 = nm.carbon[0][nm.package_w_xx][xloopx1];
				temp6 = nm.carbon[0][nm.shipping_out_xx][xloopx1];

				temp8 = nm.carbon[0][nm.shipping_company_xx][xloopx1];

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




		silver[nm.address_1_xx][1]              = x_address_1;
		silver[nm.address_2_xx][1]              = x_address_2;
		silver[nm.address_3_xx][1]              = x_address_3;
		silver[nm.address_4_xx][1]              = x_address_4;
		silver[nm.address_5_xx][1]              = x_address_5;
		silver[nm.address_6_xx][1]              = "";
		silver[nm.buyer_id_xx][1]               = x_buyer_id;
		silver[nm.buyers_email_xx][1]           = x_buyers_email;
		silver[nm.buyers_first_name_xx][1]      = x_buyers_first_name;
		silver[nm.buyers_last_name_xx][1]       = x_buyers_last_name;
		silver[nm.buyers_notes_xx][1]           = x_buyers_notes;
		silver[nm.buyers_phone_xx][1]           = x_buyers_phone;
		silver[nm.currency_xx][1]               = x_currency;
		silver[nm.custom_1_xx][1]               = custom_temp1;
		silver[nm.custom_2_xx][1]               = custom_temp2;
		silver[nm.custom_3_xx][1]               = custom_temp3;
		silver[nm.custom_4_xx][1]               = custom_temp4;
		silver[nm.custom_5_xx][1]               = custom_temp5;
		silver[nm.custom_6_xx][1]               = custom_temp6;
		silver[nm.custom_7_xx][1]               = custom_temp7;
		silver[nm.custom_8_xx][1]               = custom_temp8;
		silver[nm.custom_9_xx][1]               = custom_temp9;
		silver[nm.custom_10_xx][1]              = custom_temp10;
		silver[nm.custom_11_xx][1]              = custom_temp11;
		silver[nm.custom_12_xx][1]              = custom_temp12;
		silver[nm.custom_13_xx][1]              = custom_temp13;
		silver[nm.custom_14_xx][1]              = custom_temp14;
		silver[nm.custom_15_xx][1]              = custom_temp15;
		silver[nm.custom_16_xx][1]              = custom_temp16;
		silver[nm.custom_17_xx][1]              = custom_temp17;
		silver[nm.custom_18_xx][1]              = custom_temp18;
		silver[nm.custom_19_xx][1]              = custom_temp19;
		silver[nm.custom_20_xx][1]              = custom_temp20;
		silver[nm.custom_21_xx][1]              = custom_temp21;
		silver[nm.custom_22_xx][1]              = custom_temp22;
		silver[nm.custom_23_xx][1]              = custom_temp23;
		silver[nm.custom_24_xx][1]              = custom_temp24;
		silver[nm.custom_25_xx][1]              = custom_temp25;
		silver[nm.custom_26_xx][1]              = custom_temp26;
		silver[nm.custom_27_xx][1]              = custom_temp27;
		silver[nm.custom_28_xx][1]              = custom_temp28;
		silver[nm.custom_29_xx][1]              = custom_temp29;
		silver[nm.custom_30_xx][1]              = custom_temp30;
		silver[nm.custom_31_xx][1]              = custom_temp31;
		silver[nm.custom_32_xx][1]              = custom_temp32;
		silver[nm.custom_33_xx][1]              = custom_temp33;
		silver[nm.custom_34_xx][1]              = custom_temp34;
		silver[nm.custom_35_xx][1]              = custom_temp35;
		silver[nm.custom_36_xx][1]              = custom_temp36;
		silver[nm.custom_37_xx][1]              = custom_temp37;
		silver[nm.custom_38_xx][1]              = custom_temp38;
		silver[nm.custom_39_xx][1]              = custom_temp39;
		silver[nm.custom_40_xx][1]              = custom_temp40;
		silver[nm.custom_41_xx][1]              = custom_temp41;
		silver[nm.custom_42_xx][1]              = custom_temp42;
		silver[nm.custom_43_xx][1]              = custom_temp43;
		silver[nm.custom_44_xx][1]              = custom_temp44;
		silver[nm.custom_45_xx][1]              = custom_temp45;
		silver[nm.custom_46_xx][1]              = custom_temp46;
		silver[nm.custom_template_xx][1]        = "";
		silver[nm.date_last_modified_xx][1]     = "";
		silver[nm.date_payment_received_xx][1]  = x_date_payment_received;
		silver[nm.date_shipped_xx][1]           = "";
		silver[nm.date_sold_xx][1]              = x_date_sold;
		silver[nm.ebay_item_xx][1]              = "no";
		silver[nm.final_value_fee_xx][1]        = x_final_value_fee;
		silver[nm.handling_xx][1]               = x_handling;
		silver[nm.hits_xx][1]                   = x_hits;
		silver[nm.item_cost_xx][1]              = temp1;
		silver[nm.item_description_xx][1]       = "item_description";
		silver[nm.item_id_xx][1]                = x_item_id;
		silver[nm.item_price_xx][1]             = x_item_price;
		silver[nm.item_weight_xx][1]            = temp2;
		silver[nm.listing_fees_xx][1]           = "";
		silver[nm.listing_id_xx][1]             = "";
		silver[nm.notes_xx][1]                  = "";
		silver[nm.package_d_xx][1]              = temp3;
		silver[nm.package_l_xx][1]              = temp4;
		silver[nm.package_w_xx][1]              = temp5;
		silver[nm.part_number_xx][1]            = x_part_number;
		silver[nm.payment_type_xx][1]           = "";
		silver[nm.paypal_fees_xx][1]            = x_paypal_fees;
		silver[nm.picture_1_xx][1]              = "";
		silver[nm.quantity_sold_xx][1]          = x_quantity_sold;
		silver[nm.sale_id_xx][1]                = bufferarray[looppx];
		silver[nm.sale_status_xx][1]            = "Sold";
		silver[nm.sales_tax_xx][1]              = x_sales_tax;
		silver[nm.shipping_company_xx][1]       = "";
		silver[nm.shipping_in_xx][1]            = x_shipping_in;
		silver[nm.shipping_out_xx][1]           = x_shipping_out;
		silver[nm.site_id_xx][1]                = x_site_id;
		silver[nm.site_url_xx][1]               = "";
		silver[nm.source_of_sale_xx][1]         = nm.carbon[5][0][nm.current_submit_item_a];
		silver[nm.title_xx][1]                  = x_title;
		silver[nm.title_url_xx][1]              = "";
		silver[nm.total_on_hand_xx][1]          = total_on_hand_now;
		silver[nm.total_sale_amount_xx][1]      = x_total_sale_amount;
		silver[nm.tracking_number_xx][1]        = "";
		silver[nm.transaction_id_xx][1]         = nm.carbon[5][nm.id_mm][nm.current_submit_item_a];//Integer.toString(nm.current_submit_item_a);
		silver[nm.transaction_info_xx][1]       = x_transaction_info;




		//test if null

		if (silver[nm.address_1_xx][1] == null){JOptionPane.showMessageDialog(null,"address_1");}
		if (silver[nm.address_2_xx][1] == null){JOptionPane.showMessageDialog(null,"address_2");}
		if (silver[nm.address_3_xx][1] == null){JOptionPane.showMessageDialog(null,"address_3");}
		if (silver[nm.address_4_xx][1] == null){JOptionPane.showMessageDialog(null,"address_4");}
		if (silver[nm.address_5_xx][1] == null){JOptionPane.showMessageDialog(null,"address_5");}
		if (silver[nm.address_6_xx][1] == null)           {JOptionPane.showMessageDialog(null,"address_6");}
		if (silver[nm.buyer_id_xx][1] == null)            {JOptionPane.showMessageDialog(null,"buyer_id");}
		if (silver[nm.buyers_email_xx][1] == null)        {JOptionPane.showMessageDialog(null,"buyers_email");}
		if (silver[nm.buyers_first_name_xx][1] == null)   {JOptionPane.showMessageDialog(null,"buyers_first_name");}
		if (silver[nm.buyers_last_name_xx][1] == null){JOptionPane.showMessageDialog(null,"buyers_last_name");}
		if (silver[nm.buyers_notes_xx][1] == null){JOptionPane.showMessageDialog(null,"buyers_notes");}
		if (silver[nm.buyers_phone_xx][1] == null){JOptionPane.showMessageDialog(null,"buyers_phone");}
		if (silver[nm.currency_xx][1] == null){JOptionPane.showMessageDialog(null,"currency");}
		if (silver[nm.custom_1_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_1");}
		if (silver[nm.custom_2_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_2");}
		if (silver[nm.custom_3_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_3");}
		if (silver[nm.custom_4_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_4");}
		if (silver[nm.custom_5_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_5");}
		if (silver[nm.custom_6_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_6");}
		if (silver[nm.custom_7_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_7");}
		if (silver[nm.custom_8_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_8");}
		if (silver[nm.custom_9_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_9");}
		if (silver[nm.custom_10_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_10");}
		if (silver[nm.custom_11_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_11");}
		if (silver[nm.custom_12_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_12");}
		if (silver[nm.custom_13_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_13");}
		if (silver[nm.custom_14_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_14");}
		if (silver[nm.custom_15_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_15");}
		if (silver[nm.custom_16_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_16");}
		if (silver[nm.custom_17_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_17");}
		if (silver[nm.custom_18_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_18");}
		if (silver[nm.custom_19_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_19");}
		if (silver[nm.custom_20_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_20");}
		if (silver[nm.custom_21_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_21");}
		if (silver[nm.custom_22_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_22");}
		if (silver[nm.custom_23_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_23");}
		if (silver[nm.custom_24_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_24");}
		if (silver[nm.custom_25_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_25");}
		if (silver[nm.custom_26_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_26");}
		if (silver[nm.custom_27_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_27");}
		if (silver[nm.custom_28_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_28");}
		if (silver[nm.custom_29_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_29");}
		if (silver[nm.custom_30_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_30");}
		if (silver[nm.custom_31_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_31");}
		if (silver[nm.custom_32_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_32");}
		if (silver[nm.custom_33_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_33");}
		if (silver[nm.custom_34_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_34");}
		if (silver[nm.custom_35_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_35");}
		if (silver[nm.custom_36_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_36");}
		if (silver[nm.custom_37_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_37");}
		if (silver[nm.custom_38_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_38");}
		if (silver[nm.custom_39_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_39");}
		if (silver[nm.custom_40_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_40");}
		if (silver[nm.custom_41_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_41");}
		if (silver[nm.custom_42_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_42");}
		if (silver[nm.custom_43_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_43");}
		if (silver[nm.custom_44_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_44");}
		if (silver[nm.custom_45_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_45");}
		if (silver[nm.custom_46_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_46");}
		if (silver[nm.custom_template_xx][1] == null){JOptionPane.showMessageDialog(null,"custom_template");}
		if (silver[nm.date_last_modified_xx][1] == null){JOptionPane.showMessageDialog(null,"date_last_modified");}
		if (silver[nm.date_payment_received_xx][1] == null){JOptionPane.showMessageDialog(null,"date_payment_received");}
		if (silver[nm.date_shipped_xx][1] == null){JOptionPane.showMessageDialog(null,"date_shipped");}
		if (silver[nm.date_sold_xx][1] == null){JOptionPane.showMessageDialog(null,"date_sold");}
		if (silver[nm.ebay_item_xx][1] == null){JOptionPane.showMessageDialog(null,"ebay_item");}
		if (silver[nm.final_value_fee_xx][1] == null){JOptionPane.showMessageDialog(null,"final_value_fee");}
		if (silver[nm.handling_xx][1] == null){JOptionPane.showMessageDialog(null,"handling");}
		if (silver[nm.hits_xx][1] == null){JOptionPane.showMessageDialog(null,"hits");}
		if (silver[nm.item_cost_xx][1] == null){JOptionPane.showMessageDialog(null,"item_cost");}
		if (silver[nm.item_description_xx][1] == null){JOptionPane.showMessageDialog(null,"item_description");}
		if (silver[nm.item_id_xx][1] == null){JOptionPane.showMessageDialog(null,"item_id");}
		if (silver[nm.item_price_xx][1] == null){JOptionPane.showMessageDialog(null,"item_price");}
		if (silver[nm.item_weight_xx][1] == null){JOptionPane.showMessageDialog(null,"item_weight");}
		if (silver[nm.listing_fees_xx][1] == null){JOptionPane.showMessageDialog(null,"listing_fees");}
		if (silver[nm.listing_id_xx][1] == null){JOptionPane.showMessageDialog(null,"listing_id");}
		if (silver[nm.notes_xx][1] == null){JOptionPane.showMessageDialog(null,"notes");}
		if (silver[nm.package_d_xx][1] == null){JOptionPane.showMessageDialog(null,"package_d");}
		if (silver[nm.package_l_xx][1] == null){JOptionPane.showMessageDialog(null,"package_l");}
		if (silver[nm.package_w_xx][1] == null){JOptionPane.showMessageDialog(null,"package_w");}
		if (silver[nm.part_number_xx][1] == null){JOptionPane.showMessageDialog(null,"part_number");}
		if (silver[nm.payment_type_xx][1] == null){JOptionPane.showMessageDialog(null,"payment_type");}
		if (silver[nm.paypal_fees_xx][1] == null){JOptionPane.showMessageDialog(null,"paypal_fees");}
		if (silver[nm.picture_1_xx][1] == null){JOptionPane.showMessageDialog(null,"picture_1");}
		if (silver[nm.quantity_sold_xx][1] == null){JOptionPane.showMessageDialog(null,"quantity_sold");}
		if (silver[nm.sale_id_xx][1] == null){JOptionPane.showMessageDialog(null,"sale_id");}
		if (silver[nm.sale_status_xx][1] == null){JOptionPane.showMessageDialog(null,"sale_status");}
		if (silver[nm.sales_tax_xx][1] == null){JOptionPane.showMessageDialog(null,"sales_tax");}
		if (silver[nm.shipping_company_xx][1] == null){JOptionPane.showMessageDialog(null,"shipping_company");}
		if (silver[nm.shipping_in_xx][1] == null)          {JOptionPane.showMessageDialog(null,"shipping_in");}
		if (silver[nm.shipping_out_xx][1] == null)         {JOptionPane.showMessageDialog(null,"shipping_out");}
		if (silver[nm.site_id_xx][1] == null)              {JOptionPane.showMessageDialog(null,"site_id");}
		if (silver[nm.site_url_xx][1] == null)             {JOptionPane.showMessageDialog(null,"site_url");}
		if (silver[nm.source_of_sale_xx][1] == null)       {JOptionPane.showMessageDialog(null,"source_of_sale");}
		if (silver[nm.title_xx][1] == null)                {JOptionPane.showMessageDialog(null,"title");}
		if (silver[nm.title_url_xx][1] == null)            {JOptionPane.showMessageDialog(null,"title_url");}
		if (silver[nm.total_on_hand_xx][1] == null)        {JOptionPane.showMessageDialog(null,"total_on_hand");}
		if (silver[nm.total_sale_amount_xx][1] == null)    {JOptionPane.showMessageDialog(null,"total_sale_amount");}
		if (silver[nm.tracking_number_xx][1] == null)      {JOptionPane.showMessageDialog(null,"tracking_number");}
		if (silver[nm.transaction_id_xx][1] == null)       {JOptionPane.showMessageDialog(null,"transaction_id");}
		if (silver[nm.transaction_info_xx][1] == null)     {JOptionPane.showMessageDialog(null,"transaction_info");}




		nm.carbon[2] = silver;



	}//******************add item















    public void pullThePlug() {

    	System.out.println("PULL THE PLUG");

    	nm.firex2 = 1;

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
   		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull



    public static void main(int ssxs){

		customapi_import_sales xr = new customapi_import_sales(ssxs);

    }//main







	class BackgroundPanel extends JPanel {

	  	Image image;
	  	
	  	public BackgroundPanel() {

		    try {

		      	image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/backgroundgold.jpg"), "backgroundgold.jpg"));

		    } catch (Exception e) { System.out.println("Failed001"); }

	  	}//backgroundpanel

		protected void paintComponent(Graphics g) {

		    super.paintComponent(g);

		    if (image != null) {

		    	g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);

		  	}

		}//paint

	}//jpanel




}//last****************************************



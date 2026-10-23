//package alchemy_lib;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_import_items extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

String data2;
URL url2;
OutputStreamWriter wr2;
BufferedReader rd2;
URLConnection conn2;



JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int kcountxx = 0;
int kcountxx2 = 0;
int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
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
int ix1x = 0;
int ix0x = 0;
int websites = 50;
int HTMLINT = 0;
int looppx = 0;

Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);



String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");


File st1;

String carbonfiber = new String();
String[][] silver = new String[1][1];
String[][] silverx = new String[1][1];
String xgetx[] = new String[10000];
String xlinex = new String("");
String blank = new String("");
String HTMLGO = new String("");

File file_open_0 = new File("ALCHEMIST_DBX2.CSV");
File file_open_1 = new File("ALCHEMIST_DBX.CSV");

int current_submit_item_xx = -1;


//************************************************************************************************************************
alchemy_import_items(int ssxs){//****************************

	super("Import Items");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){running = 0;}});


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);




	current_submit_item_xx = ssxs;

	System.out.println("current_submit_item_xx " + current_submit_item_xx);

	Icon aicon = new ImageIcon(ximagex);

	infox0.setPreferredSize(new Dimension(320, 50));
	infox0.setBackground(black);
	infox0.setForeground(whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 2.1.1");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("item number: ");
	infox1.setForeground(whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(blackx);

	infox2.setPreferredSize(new Dimension(320, 25));
	infox2.setText("item number: ");
	infox2.setForeground(whitex);
	infox2.setOpaque(true); 
	infox2.setBackground(blackx);



	BackgroundPanel bkp = new BackgroundPanel();
	bkp.setPreferredSize(new Dimension(340, 140));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(blackx);
	bkp.setForeground(whitex);
	bkp.add(infox0);
	bkp.add(infox1);
	bkp.add(infox2);




	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(blackx);
	cpx.setForeground(whitex);
	cpx.add(bkp);


	setVisible(true);



	requestFocus();
	repaint();

	connectx();
	pullThePlug();

}//csv_loader_x1********************************************************








	public void connectx(){

		System.out.println("nm.carbon[5][1][current_submit_item_xx] " + nm.carbon[5][1][current_submit_item_xx]);

		db_items = 0;

		// get list data
		try {



		           data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[5][2][current_submit_item_xx], "UTF-8");
		    data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[5][3][current_submit_item_xx], "UTF-8");



			HTMLGO = nm.carbon[5][1][current_submit_item_xx];

			System.out.println(data);
			System.out.println(HTMLGO + "/dbx_export_items.php");

		    // Send data
		    url = new URL(HTMLGO + "/dbx_export_items.php");
		    conn = url.openConnection();
		    conn.setDoOutput(true);
		    wr = new OutputStreamWriter(conn.getOutputStream());
		    wr.write(data);
		    wr.flush();

		    // Get the response
		    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    String line;
		    while ((line = rd.readLine()) != null) {

			ix0 = line.indexOf("<<<");
			ix1 = line.indexOf(">>>");

			if(ix0 > -1){

				xgetx[db_items] = line.substring(3, ix1);
				db_items++;

			}//if

		    }//while
		    wr.close();
		    rd.close();

		} catch (Exception e) {System.out.println("URL falure get item list.");}





		ix5 = 1;
		//import items

		System.out.println("db_items " + db_items);	
		carbon_items = 0;
		running = 1;

		for(int xloopx = 0; xloopx < db_items; xloopx++){//********************************************************************
		
			infox1.setText("Import item: " + (xloopx + 1) + " of " + db_items);
			if(running == 0){break;}

			//see if item is already imported
			for(int xloopx2 = 0; xloopx2 < nm.carbon[0][nm.item_id_xx].length; xloopx2++){//***************

				ix3 = 0;
				
				System.out.println(xloopx2 + " " + nm.carbon[0][nm.item_id_xx].length + " " + nm.carbon[0][nm.item_id_xx][xloopx2]);
				ix4 = xgetx[xloopx].indexOf(nm.carbon[0][nm.item_id_xx][xloopx2]);
				if(ix4 > -1){ix3++; System.out.println(" 77 " + nm.carbon[0][nm.item_id_xx][xloopx2]); break;}

			}//for**************************************************************************
			//see if item is already imported



			if(ix3 == 0){looppx = xloopx; add_item(); ix5++; carbon_items++; infox2.setText("Imported.");}
			else{System.out.println("getx item already imported."); infox2.setText("Getx item already imported.");}//carbon_items++;


			requestFocus();

		}//for*****************************************************************************************************************




	}//connectx()*********************************************************************************************













	public void add_item(){//****************************************     *******       *********          ************



		silver = new String[nm.db_cc_number][nm.carbon[0][0].length + 1];
		System.out.println("silver length " + silver[0].length);


		ix6 = 0;
		for(int xloop1 = 1; xloop1 < silver[0].length; xloop1++){//************************
		for(int xloop2 = 0; xloop2 < nm.db_cc_number; xloop2++){//************************

			silver[xloop2][xloop1] = nm.carbon[0][xloop2][ix6]; 

		}//for********************************************
		ix6++;
		}//for********************************************



		nm.carbon[0] = silver;


		nm.carbon[0][0] [0] = new String("*address_1");
		nm.carbon[0][1] [0] = new String("*address_2");
		nm.carbon[0][2] [0] = new String("*address_3");
		nm.carbon[0][3] [0] = new String("*address_4");
		nm.carbon[0][4] [0] = new String("*address_5");
		nm.carbon[0][5] [0] = new String("*address_6");
		nm.carbon[0][6] [0] = new String("*buyer_id");
		nm.carbon[0][7] [0] = new String("*buyers_email");
		nm.carbon[0][8] [0] = new String("*buyers_first_name");
		nm.carbon[0][9] [0] = new String("*buyers_last_name");
		nm.carbon[0][10][0] = new String("*buyers_notes");
		nm.carbon[0][11][0] = new String("*buyers_phone");
		nm.carbon[0][12][0] = new String("*currency");
		nm.carbon[0][13][0] = new String("*custom_1");
		nm.carbon[0][14][0] = new String("*custom_2");
		nm.carbon[0][15][0] = new String("*custom_3");
		nm.carbon[0][16][0] = new String("*custom_4");
		nm.carbon[0][17][0] = new String("*custom_5");
		nm.carbon[0][18][0] = new String("*custom_6");
		nm.carbon[0][19][0] = new String("*custom_7");
		nm.carbon[0][20][0] = new String("*custom_8");
		nm.carbon[0][21][0] = new String("*custom_9");
		nm.carbon[0][22][0] = new String("*custom_10");
		nm.carbon[0][23][0] = new String("*custom_11");
		nm.carbon[0][24][0] = new String("*custom_12");
		nm.carbon[0][25][0] = new String("*custom_13");
		nm.carbon[0][26][0] = new String("*custom_14");
		nm.carbon[0][27][0] = new String("*custom_15");
		nm.carbon[0][28][0] = new String("*custom_16");
		nm.carbon[0][29][0] = new String("*custom_17");
		nm.carbon[0][30][0] = new String("*custom_18");
		nm.carbon[0][31][0] = new String("*custom_19");
		nm.carbon[0][32][0] = new String("*custom_20");
		nm.carbon[0][33][0] = new String("*custom_21");
		nm.carbon[0][34][0] = new String("*custom_22");
		nm.carbon[0][35][0] = new String("*custom_23");
		nm.carbon[0][36][0] = new String("*custom_24");
		nm.carbon[0][37][0] = new String("*custom_25");
		nm.carbon[0][38][0] = new String("*custom_26");
		nm.carbon[0][39][0] = new String("*custom_27");
		nm.carbon[0][40][0] = new String("*custom_28");
		nm.carbon[0][41][0] = new String("*custom_29");
		nm.carbon[0][42][0] = new String("*custom_30");
		nm.carbon[0][43][0] = new String("*custom_31");
		nm.carbon[0][44][0] = new String("*custom_32");
		nm.carbon[0][45][0] = new String("*custom_33");
		nm.carbon[0][46][0] = new String("*custom_34");
		nm.carbon[0][47][0] = new String("*custom_35");
		nm.carbon[0][48][0] = new String("*custom_36");
		nm.carbon[0][49][0] = new String("*custom_37");
		nm.carbon[0][50][0] = new String("*custom_38");
		nm.carbon[0][51][0] = new String("*custom_39");
		nm.carbon[0][52][0] = new String("*custom_40");
		nm.carbon[0][53][0] = new String("*custom_41");
		nm.carbon[0][54][0] = new String("*custom_42");
		nm.carbon[0][55][0] = new String("*custom_43");
		nm.carbon[0][56][0] = new String("*custom_44");
		nm.carbon[0][57][0] = new String("*custom_45");
		nm.carbon[0][58][0] = new String("*custom_46");
		nm.carbon[0][59][0] = new String("*custom_template");
		nm.carbon[0][60][0] = new String("*date_last_modified");
		nm.carbon[0][61][0] = new String("*date_payment_received");
		nm.carbon[0][62][0] = new String("*date_shipped");
		nm.carbon[0][63][0] = new String("*date_sold");
		nm.carbon[0][64][0] = new String("*ebay_item");
		nm.carbon[0][65][0] = new String("*final_value_fee");
		nm.carbon[0][66][0] = new String("*handling");
		nm.carbon[0][67][0] = new String("*hits");
		nm.carbon[0][68][0] = new String("*item_cost");
		nm.carbon[0][69][0] = new String("*item_description");
		nm.carbon[0][70][0] = new String("*item_id");
		nm.carbon[0][71][0] = new String("*item_price");
		nm.carbon[0][72][0] = new String("*item_weight");
		nm.carbon[0][73][0] = new String("*listing_fees");
		nm.carbon[0][74][0] = new String("*listing_id");
		nm.carbon[0][75][0] = new String("*notes");
		nm.carbon[0][76][0] = new String("*package_d");
		nm.carbon[0][77][0] = new String("*package_l");
		nm.carbon[0][78][0] = new String("*package_w");
		nm.carbon[0][79][0] = new String("*part_number");
		nm.carbon[0][80][0] = new String("*payment_type");
		nm.carbon[0][81][0] = new String("*paypal_fees");
		nm.carbon[0][82][0] = new String("*picture_1");
		nm.carbon[0][83][0] = new String("*quantity_sold");
		nm.carbon[0][84][0] = new String("*sale_id");
		nm.carbon[0][85][0] = new String("*sale_status");
		nm.carbon[0][86][0] = new String("*sales_tax");
		nm.carbon[0][87][0] = new String("*shipping_company");
		nm.carbon[0][88][0] = new String("*shipping_in");
		nm.carbon[0][89][0] = new String("*shipping_out");
		nm.carbon[0][90][0] = new String("*site_id");
		nm.carbon[0][91][0] = new String("*site_url");
		nm.carbon[0][92][0] = new String("*source_of_sale");
		nm.carbon[0][93][0] = new String("*title");
		nm.carbon[0][94][0] = new String("*title_url");
		nm.carbon[0][95][0] = new String("*total_on_hand");
		nm.carbon[0][96][0] = new String("*total_sale_amount");
		nm.carbon[0][97][0] = new String("*tracking_number");
		nm.carbon[0][98][0] = new String("*transaction_id");
		nm.carbon[0][99][0] = new String("*transaction_info");






		nm.carbon[0][0] [1] = new String("address_1");
		nm.carbon[0][1] [1] = new String("address_2");
		nm.carbon[0][2] [1] = new String("address_3");
		nm.carbon[0][3] [1] = new String("address_4");
		nm.carbon[0][4] [1] = new String("address_5");
		nm.carbon[0][5] [1] = new String("address_6");
		nm.carbon[0][6] [1] = new String("buyer_id");
		nm.carbon[0][7] [1] = new String("buyers_email");
		nm.carbon[0][8] [1] = new String("buyers_first_name");
		nm.carbon[0][9] [1] = new String("buyers_last_name");
		nm.carbon[0][10][1] = new String("buyers_notes");
		nm.carbon[0][11][1] = new String("buyers_phone");
		nm.carbon[0][12][1] = new String("currency");
		nm.carbon[0][13][1] = new String("custom_1");
		nm.carbon[0][14][1] = new String("custom_2");
		nm.carbon[0][15][1] = new String("custom_3");
		nm.carbon[0][16][1] = new String("custom_4");
		nm.carbon[0][17][1] = new String("custom_5");
		nm.carbon[0][18][1] = new String("custom_6");
		nm.carbon[0][19][1] = new String("custom_7");
		nm.carbon[0][20][1] = new String("custom_8");
		nm.carbon[0][21][1] = new String("custom_9");
		nm.carbon[0][22][1] = new String("custom_10");
		nm.carbon[0][23][1] = new String("custom_11");
		nm.carbon[0][24][1] = new String("custom_12");
		nm.carbon[0][25][1] = new String("custom_13");
		nm.carbon[0][26][1] = new String("custom_14");
		nm.carbon[0][27][1] = new String("custom_15");
		nm.carbon[0][28][1] = new String("custom_16");
		nm.carbon[0][29][1] = new String("custom_17");
		nm.carbon[0][30][1] = new String("custom_18");
		nm.carbon[0][31][1] = new String("custom_19");
		nm.carbon[0][32][1] = new String("custom_20");
		nm.carbon[0][33][1] = new String("custom_21");
		nm.carbon[0][34][1] = new String("custom_22");
		nm.carbon[0][35][1] = new String("custom_23");
		nm.carbon[0][36][1] = new String("custom_24");
		nm.carbon[0][37][1] = new String("custom_25");
		nm.carbon[0][38][1] = new String("custom_26");
		nm.carbon[0][39][1] = new String("custom_27");
		nm.carbon[0][40][1] = new String("custom_28");
		nm.carbon[0][41][1] = new String("custom_29");
		nm.carbon[0][42][1] = new String("custom_30");
		nm.carbon[0][43][1] = new String("custom_31");
		nm.carbon[0][44][1] = new String("custom_32");
		nm.carbon[0][45][1] = new String("custom_33");
		nm.carbon[0][46][1] = new String("custom_34");
		nm.carbon[0][47][1] = new String("custom_35");
		nm.carbon[0][48][1] = new String("custom_36");
		nm.carbon[0][49][1] = new String("custom_37");
		nm.carbon[0][50][1] = new String("custom_38");
		nm.carbon[0][51][1] = new String("custom_39");
		nm.carbon[0][52][1] = new String("custom_40");
		nm.carbon[0][53][1] = new String("custom_41");
		nm.carbon[0][54][1] = new String("custom_42");
		nm.carbon[0][55][1] = new String("custom_43");
		nm.carbon[0][56][1] = new String("custom_44");
		nm.carbon[0][57][1] = new String("custom_45");
		nm.carbon[0][58][1] = new String("custom_46");
		nm.carbon[0][59][1] = new String("custom_template");
		nm.carbon[0][60][1] = new String("date_last_modified");
		nm.carbon[0][61][1] = new String("date_payment_received");
		nm.carbon[0][62][1] = new String("date_shipped");
		nm.carbon[0][63][1] = new String("date_sold");
		nm.carbon[0][64][1] = new String("ebay_item");
		nm.carbon[0][65][1] = new String("final_value_fee");
		nm.carbon[0][66][1] = new String("handling");
		nm.carbon[0][67][1] = new String("hits");
		nm.carbon[0][68][1] = new String("item_cost");
		nm.carbon[0][69][1] = new String("item_description");
		nm.carbon[0][70][1] = new String("item_id");
		nm.carbon[0][71][1] = new String("item_price");
		nm.carbon[0][72][1] = new String("item_weight");
		nm.carbon[0][73][1] = new String("listing_fees");
		nm.carbon[0][74][1] = new String("listing_id");
		nm.carbon[0][75][1] = new String("notes");
		nm.carbon[0][76][1] = new String("package_d");
		nm.carbon[0][77][1] = new String("package_l");
		nm.carbon[0][78][1] = new String("package_w");
		nm.carbon[0][79][1] = new String("part_number");
		nm.carbon[0][80][1] = new String("payment_type");
		nm.carbon[0][81][1] = new String("paypal_fees");
		nm.carbon[0][82][1] = new String("picture_1");
		nm.carbon[0][83][1] = new String("quantity_sold");
		nm.carbon[0][84][1] = new String("sale_id");
		nm.carbon[0][85][1] = new String("sale_status");
		nm.carbon[0][86][1] = new String("sales_tax");
		nm.carbon[0][87][1] = new String("shipping_company");
		nm.carbon[0][88][1] = new String("shipping_in");
		nm.carbon[0][89][1] = new String("shipping_out");
		nm.carbon[0][90][1] = new String("site_id");
		nm.carbon[0][91][1] = new String("site_url");
		nm.carbon[0][92][1] = new String("source_of_sale");
		nm.carbon[0][93][1] = new String("title");
		nm.carbon[0][94][1] = new String("title_url");
		nm.carbon[0][95][1] = new String("total_on_hand");
		nm.carbon[0][96][1] = new String("total_sale_amount");
		nm.carbon[0][97][1] = new String("tracking_number");
		nm.carbon[0][98][1] = new String("transaction_id");
		nm.carbon[0][99][1] = new String("transaction_info");







		// get items*************************************************************************************************
		try {

		           data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[5][2][current_submit_item_xx], "UTF-8");
		    data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[5][3][current_submit_item_xx], "UTF-8");
		    data += "&" + URLEncoder.encode("item", "UTF-8")     + "=" + URLEncoder.encode(xgetx[looppx]  , "UTF-8");

			System.out.println(HTMLGO + "/dbx_export_items.php" + data);


		    // Send data
		    url = new URL(HTMLGO + "/dbx_export_items.php");
		    conn = url.openConnection();
		    conn.setDoOutput(true);
		    wr = new OutputStreamWriter(conn.getOutputStream());
		    wr.write(data);
		    wr.flush();

		    // Get the response
		    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		    String line;
		    carbonfiber = new String("");

		    while ((line = rd.readLine()) != null) {

				carbonfiber = carbonfiber + line;
				System.out.println("dd " + line);
			
		    }//while
		    wr.close();
		    rd.close();

		} catch (Exception e) {System.out.println("URL falure."); infox2.setText("URL falure.");}





		silver[0] [0] = new String("*address_1");
		silver[1] [0] = new String("*address_2");
		silver[2] [0] = new String("*address_3");
		silver[3] [0] = new String("*address_4");
		silver[4] [0] = new String("*address_5");
		silver[5] [0] = new String("*address_6");
		silver[6] [0] = new String("*buyer_id");
		silver[7] [0] = new String("*buyers_email");
		silver[8] [0] = new String("*buyers_first_name");
		silver[9] [0] = new String("*buyers_last_name");
		silver[10][0] = new String("*buyers_notes");
		silver[11][0] = new String("*buyers_phone");
		silver[12][0] = new String("*currency");
		silver[13][0] = new String("*custom_1");
		silver[14][0] = new String("*custom_2");
		silver[15][0] = new String("*custom_3");
		silver[16][0] = new String("*custom_4");
		silver[17][0] = new String("*custom_5");
		silver[18][0] = new String("*custom_6");
		silver[19][0] = new String("*custom_7");
		silver[20][0] = new String("*custom_8");
		silver[21][0] = new String("*custom_9");
		silver[22][0] = new String("*custom_10");
		silver[23][0] = new String("*custom_11");
		silver[24][0] = new String("*custom_12");
		silver[25][0] = new String("*custom_13");
		silver[26][0] = new String("*custom_14");
		silver[27][0] = new String("*custom_15");
		silver[28][0] = new String("*custom_16");
		silver[29][0] = new String("*custom_17");
		silver[30][0] = new String("*custom_18");
		silver[31][0] = new String("*custom_19");
		silver[32][0] = new String("*custom_20");
		silver[33][0] = new String("*custom_21");
		silver[34][0] = new String("*custom_22");
		silver[35][0] = new String("*custom_23");
		silver[36][0] = new String("*custom_24");
		silver[37][0] = new String("*custom_25");
		silver[38][0] = new String("*custom_26");
		silver[39][0] = new String("*custom_27");
		silver[40][0] = new String("*custom_28");
		silver[41][0] = new String("*custom_29");
		silver[42][0] = new String("*custom_30");
		silver[43][0] = new String("*custom_31");
		silver[44][0] = new String("*custom_32");
		silver[45][0] = new String("*custom_33");
		silver[46][0] = new String("*custom_34");
		silver[47][0] = new String("*custom_35");
		silver[48][0] = new String("*custom_36");
		silver[49][0] = new String("*custom_37");
		silver[50][0] = new String("*custom_38");
		silver[51][0] = new String("*custom_39");
		silver[52][0] = new String("*custom_40");
		silver[53][0] = new String("*custom_41");
		silver[54][0] = new String("*custom_42");
		silver[55][0] = new String("*custom_43");
		silver[56][0] = new String("*custom_44");
		silver[57][0] = new String("*custom_45");
		silver[58][0] = new String("*custom_46");
		silver[59][0] = new String("*custom_template");
		silver[60][0] = new String("*date_last_modified");
		silver[61][0] = new String("*date_payment_received");
		silver[62][0] = new String("*date_shipped");
		silver[63][0] = new String("*date_sold");
		silver[64][0] = new String("*ebay_item");
		silver[65][0] = new String("*final_value_fee");
		silver[66][0] = new String("*handling");
		silver[67][0] = new String("*hits");
		silver[68][0] = new String("*item_cost");
		silver[69][0] = new String("*item_description");
		silver[70][0] = new String("*item_id");
		silver[71][0] = new String("*item_price");
		silver[72][0] = new String("*item_weight");
		silver[73][0] = new String("*listing_fees");
		silver[74][0] = new String("*listing_id");
		silver[75][0] = new String("*notes");
		silver[76][0] = new String("*package_d");
		silver[77][0] = new String("*package_l");
		silver[78][0] = new String("*package_w");
		silver[79][0] = new String("*part_number");
		silver[80][0] = new String("*payment_type");
		silver[81][0] = new String("*paypal_fees");
		silver[82][0] = new String("*picture_1");
		silver[83][0] = new String("*quantity_sold");
		silver[84][0] = new String("*sale_id");
		silver[85][0] = new String("*sale_status");
		silver[86][0] = new String("*sales_tax");
		silver[87][0] = new String("*shipping_company");
		silver[88][0] = new String("*shipping_in");
		silver[89][0] = new String("*shipping_out");
		silver[90][0] = new String("*site_id");
		silver[91][0] = new String("*site_url");
		silver[92][0] = new String("*source_of_sale");
		silver[93][0] = new String("*title");
		silver[94][0] = new String("*title_url");
		silver[95][0] = new String("*total_on_hand");
		silver[96][0] = new String("*total_sale_amount");
		silver[97][0] = new String("*tracking_number");
		silver[98][0] = new String("*transaction_id");
		silver[99][0] = new String("*transaction_info");




		System.out.println("nums " + (nm.carbon[0][0].length +1));



		cx0 = carbonfiber;

		System.out.println("numsx " + cx0);
		System.out.println("numsx " + ix5);


		for(int xloop2 = 0; xloop2 < nm.db_cc_number; xloop2++){//************************

			ix0 = cx0.indexOf("<<,>>");

			if(ix0 > -1){

				silver[xloop2][1] = new String(cx0.substring(0, ix0));
				//System.out.println("nn " + silver[xloop2][1]);

				cx0 = cx0.substring(ix0 + 5, cx0.length());

			}//if**********************


		}//for*********************************************************************




		nm.carbon[0] = silver;

	}//******************add item















    public void pullThePlug() {

	    System.out.println("PULL THE PLUG");

	    nm.firex = 1;

	    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull



    public static void main(int ssxs){

		alchemy_import_items xr = new alchemy_import_items(ssxs);

    }//main









	class BackgroundPanel extends JPanel{
  
  		Image image;
  
  		public BackgroundPanel(){
    
    		try{

      			image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/backgroundgold.jpg"), "backgroundgold.jpg"));

    		}catch (Exception e) { System.out.println("Failed001"); }

  		}//backgroundpanel

  		protected void paintComponent(Graphics g){

    		super.paintComponent(g); 
    
    		if (image != null){
      
      			g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);

      		}//****************
  
  		}//paint

	}//jpanel



}//last****************************************
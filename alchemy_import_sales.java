//package alchemy_lib;

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_import_sales extends JFrame{//************************************************************************

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
JLabel infox1 = new JLabel("Importing sales.", JLabel.LEFT);
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
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


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



alchemy_import_sales(int ssxs){//****************************

	super("Import Sales");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){running = 0;}});


	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	Icon aicon = new ImageIcon(ximagex);

	current_submit_item_xx = ssxs;

	System.out.println("current_submit_item_xx " + current_submit_item_xx);

	infox0.setPreferredSize(new Dimension(320, 50));
	infox0.setBackground(black);
	infox0.setForeground(whitex);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("Version 1.1.1");
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




	if(nm.run_silent == 0){setVisible(true);}
	else{System.out.println("RUN SILENT");}



	requestFocus();
	repaint();

	connectx();


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
			System.out.println(HTMLGO + "/dbx_export_sales.php");

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
		
		}catch(Exception e){System.out.println("URL falure get item list.");}




		ix5 = 1;
		//import items

		System.out.println("db_items " + db_items);	
		carbon_items = 0;

		for(int xloopx = 0; xloopx < db_items; xloopx++){//********************************************************************

			infox1.setText("Import item: " + (xloopx + 1) + " of " + db_items);

			//see if item is already imported
			for(int xloopx2 = 0; xloopx2 < nm.carbon[2][nm.sale_id_xx].length; xloopx2++){//***************
			
				ix3 = 0;
				System.out.println(xloopx2 + " " + nm.carbon[2][nm.sale_id_xx].length + " " + nm.carbon[2][nm.sale_id_xx][xloopx2]);
				ix4 = xgetx[xloopx].indexOf(nm.carbon[2][nm.sale_id_xx][xloopx2]);
				if(ix4 > -1){ix3++; System.out.println(" 77 " + nm.carbon[2][nm.sale_id_xx][xloopx2]); break;}

			}//for**************************************************************************
			//see if item is already imported

			//see if item is already imported in the archived
			for(int xloopx2 = 0; xloopx2 < nm.carbon[3][nm.sale_id_xx].length; xloopx2++){//***************
	
				ix4 = 0;
				System.out.println(xloopx2 + " " + nm.carbon[3][nm.sale_id_xx].length + " " + nm.carbon[3][nm.sale_id_xx][xloopx2]);
				ix5 = xgetx[xloopx].indexOf(nm.carbon[3][nm.sale_id_xx][xloopx2]);
				if(ix5 > -1){ix4++; System.out.println(" 77 " + nm.carbon[3][nm.sale_id_xx][xloopx2]); break;}

			}//for**************************************************************************
			//see if item is already imported in the archived



			if(ix3 == 0 && ix4 == 0){looppx = xloopx; add_item(); ix5++; carbon_items++;}
			else{System.out.println("getx item already imported.");}//carbon_items++;


			requestFocus();

		}//for*****************************************************************************************************************




	pullThePlug();

	}//connectx()*********************************************************************************************








	public void add_item(){//****************************************     *******       *********          ************



		silver = new String[nm.db_cc_number][nm.carbon[2][0].length + 1];
		System.out.println("silver length " + silver[0].length);


		ix6 = 0;
		for(int xloop1 = 1; xloop1 < silver[0].length; xloop1++){//**************
			for(int xloop2 = 0; xloop2 < nm.db_cc_number; xloop2++){//************************

				silver[xloop2][xloop1] = nm.carbon[2][xloop2][ix6]; 

			}//for****************************************************************************
		ix6++;
		}//for*******************************************************************



		nm.carbon[2] = silver;

		nm.carbon[2][0] [1] = new String("address_1");
		nm.carbon[2][1] [1] = new String("address_2");
		nm.carbon[2][2] [1] = new String("address_3");
		nm.carbon[2][3] [1] = new String("address_4");
		nm.carbon[2][4] [1] = new String("address_5");
		nm.carbon[2][5] [1] = new String("address_6");
		nm.carbon[2][6] [1] = new String("buyer_id");
		nm.carbon[2][7] [1] = new String("buyers_email");
		nm.carbon[2][8] [1] = new String("buyers_first_name");
		nm.carbon[2][9] [1] = new String("buyers_last_name");
		nm.carbon[2][10][1] = new String("buyers_notes");
		nm.carbon[2][11][1] = new String("buyers_phone");
		nm.carbon[2][12][1] = new String("currency");
		nm.carbon[2][13][1] = new String("custom_1");
		nm.carbon[2][14][1] = new String("custom_2");
		nm.carbon[2][15][1] = new String("custom_3");
		nm.carbon[2][16][1] = new String("custom_4");
		nm.carbon[2][17][1] = new String("custom_5");
		nm.carbon[2][18][1] = new String("custom_6");
		nm.carbon[2][19][1] = new String("custom_7");
		nm.carbon[2][20][1] = new String("custom_8");
		nm.carbon[2][21][1] = new String("custom_9");
		nm.carbon[2][22][1] = new String("custom_10");
		nm.carbon[2][23][1] = new String("custom_11");
		nm.carbon[2][24][1] = new String("custom_12");
		nm.carbon[2][25][1] = new String("custom_13");
		nm.carbon[2][26][1] = new String("custom_14");
		nm.carbon[2][27][1] = new String("custom_15");
		nm.carbon[2][28][1] = new String("custom_16");
		nm.carbon[2][29][1] = new String("custom_17");
		nm.carbon[2][30][1] = new String("custom_18");
		nm.carbon[2][31][1] = new String("custom_19");
		nm.carbon[2][32][1] = new String("custom_20");
		nm.carbon[2][33][1] = new String("custom_21");
		nm.carbon[2][34][1] = new String("custom_22");
		nm.carbon[2][35][1] = new String("custom_23");
		nm.carbon[2][36][1] = new String("custom_24");
		nm.carbon[2][37][1] = new String("custom_25");
		nm.carbon[2][38][1] = new String("custom_26");
		nm.carbon[2][39][1] = new String("custom_27");
		nm.carbon[2][40][1] = new String("custom_28");
		nm.carbon[2][41][1] = new String("custom_29");
		nm.carbon[2][42][1] = new String("custom_30");
		nm.carbon[2][43][1] = new String("custom_31");
		nm.carbon[2][44][1] = new String("custom_32");
		nm.carbon[2][45][1] = new String("custom_33");
		nm.carbon[2][46][1] = new String("custom_34");
		nm.carbon[2][47][1] = new String("custom_35");
		nm.carbon[2][48][1] = new String("custom_36");
		nm.carbon[2][49][1] = new String("custom_37");
		nm.carbon[2][50][1] = new String("custom_38");
		nm.carbon[2][51][1] = new String("custom_39");
		nm.carbon[2][52][1] = new String("custom_40");
		nm.carbon[2][53][1] = new String("custom_41");
		nm.carbon[2][54][1] = new String("custom_42");
		nm.carbon[2][55][1] = new String("custom_43");
		nm.carbon[2][56][1] = new String("custom_44");
		nm.carbon[2][57][1] = new String("custom_45");
		nm.carbon[2][58][1] = new String("custom_46");
		nm.carbon[2][59][1] = new String("custom_template");
		nm.carbon[2][60][1] = new String("date_last_modified");
		nm.carbon[2][61][1] = new String("date_payment_received");
		nm.carbon[2][62][1] = new String("date_shipped");
		nm.carbon[2][63][1] = new String("date_sold");
		nm.carbon[2][64][1] = new String("ebay_item");
		nm.carbon[2][65][1] = new String("final_value_fee");
		nm.carbon[2][66][1] = new String("handling");
		nm.carbon[2][67][1] = new String("hits");
		nm.carbon[2][68][1] = new String("item_cost");
		nm.carbon[2][69][1] = new String("item_description");
		nm.carbon[2][70][1] = new String("item_id");
		nm.carbon[2][71][1] = new String("item_price");
		nm.carbon[2][72][1] = new String("item_weight");
		nm.carbon[2][73][1] = new String("listing_fees");
		nm.carbon[2][74][1] = new String("listing_id");
		nm.carbon[2][75][1] = new String("notes");
		nm.carbon[2][76][1] = new String("package_d");
		nm.carbon[2][77][1] = new String("package_l");
		nm.carbon[2][78][1] = new String("package_w");
		nm.carbon[2][79][1] = new String("part_number");
		nm.carbon[2][80][1] = new String("payment_type");
		nm.carbon[2][81][1] = new String("paypal_fees");
		nm.carbon[2][82][1] = new String("picture_1");
		nm.carbon[2][83][1] = new String("quantity_sold");
		nm.carbon[2][84][1] = new String("sale_id");
		nm.carbon[2][85][1] = new String("sale_status");
		nm.carbon[2][86][1] = new String("sales_tax");
		nm.carbon[2][87][1] = new String("shipping_company");
		nm.carbon[2][88][1] = new String("shipping_in");
		nm.carbon[2][89][1] = new String("shipping_out");
		nm.carbon[2][90][1] = new String("site_id");
		nm.carbon[2][91][1] = new String("site_url");
		nm.carbon[2][92][1] = new String("source_of_sale");
		nm.carbon[2][93][1] = new String("title");
		nm.carbon[2][94][1] = new String("title_url");
		nm.carbon[2][95][1] = new String("total_on_hand");
		nm.carbon[2][96][1] = new String("total_sale_amount");
		nm.carbon[2][97][1] = new String("tracking_number");
		nm.carbon[2][98][1] = new String("transaction_id");
		nm.carbon[2][99][1] = new String("transaction_info");






		// get items*************************************************************************************************
		try{

        	       data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[5][2][current_submit_item_xx], "UTF-8");
    		data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[5][3][current_submit_item_xx], "UTF-8");
    		data += "&" + URLEncoder.encode("item", "UTF-8")     + "=" + URLEncoder.encode(xgetx[looppx]  , "UTF-8");

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
    		carbonfiber = new String("");

    		while ((line = rd.readLine()) != null){

				carbonfiber = carbonfiber + line;
				System.out.println("dd " + line);
	
    		}//while
    		wr.close();
    		rd.close();
			}catch(Exception e) {System.out.println("URL falure."); infox0.setText("URL falure.");}




			System.out.println("nums " + (nm.carbon[2][0].length +1));




			cx0 = carbonfiber;

			System.out.println("numsx " + cx0);
			System.out.println("numsx " + ix5);


			for(int xloop2 = 0; xloop2 < nm.db_cc_number; xloop2++){//************************

				ix0 = cx0.indexOf("<<,>>");

				if(ix0 > -1){

					silver[xloop2][0] = new String(cx0.substring(0, ix0));
					//System.out.println("nn " + silver[xloop2][1]);

					cx0 = cx0.substring(ix0 + 5, cx0.length());

				}//if**********************

			}//for*********************************************************************


			nm.carbon[2] = silver;

			nm.carbon[2][nm.site_id_xx][0] = "Alchemist";
			nm.carbon[2][nm.source_of_sale_xx][0] = nm.carbon[5][0][nm.current_submit_item_a];
			nm.carbon[2][nm.item_description_xx][0] = "item_description";



			//add to database
			String[][] sale_xn = new String[ nm.carbon[2].length ][1];

			for(int xloopx = 0; xloopx < nm.carbon[2].length; xloopx++){//******

				sale_xn[xloopx][0] = nm.carbon[2][xloopx][0];

			}//*****************************************************************

			//add to database
			jdb_new_sale saves = new jdb_new_sale(sale_xn);




	}//******************add item







    public void pullThePlug() {

    	System.out.println("PULL THE PLUG");

    	nm.firex = 1;

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull



    public static void main(int ssxs){

		alchemy_import_sales xr = new alchemy_import_sales(ssxs);

    }//main









	class BackgroundPanel extends JPanel{

		Image image;
		public BackgroundPanel(){

	    	try{

				image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/backgroundgold.jpg"), "backgroundgold.jpg"));

			}catch(Exception e){ System.out.println("Failed001"); }

		}//backgroundpanel

		protected void paintComponent(Graphics g){

			super.paintComponent(g);
			if(image != null){g.drawImage(image, 0,0,this.getWidth(),this.getHeight(), this);}

		}//paint

	}//jpanel




}//last****************************************
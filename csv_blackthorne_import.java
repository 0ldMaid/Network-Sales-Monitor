import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  







public class csv_blackthorne_import extends JFrame implements ActionListener{//************************************************************************

JFrame frame = new JFrame();
File f1 = new File("Listings-Running.csv");
JFileChooser fc = new JFileChooser(f1);

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


int csv_passes_x = 17;

int runx = 0;
int runs2 = 400;
int runs = 50000;

String carbon_load[][];
String carbonfiber[][];
String carbon1[][];
String carbon2[][];
String cx0 = new String("");
String cx1 = new String("");


String getn_0 = new String("\"Title\"");
String getn_1 = new String("\"Part Number\"");
String getn_2 = new String("\"Cost\"");
String getn_3 = new String("\"Current Price\"");
String getn_4 = new String("\"Custom 1\"");
String getn_5 = new String("\"Description\"");
String getn_6 = new String("\"Item ID\"");
String getn_7 = new String("\"Picture 1\"");
String getn_8 = new String("\"Total on Hand\"");
String getn_9 = new String("\"Weight Major\"");
String getn_10 = new String("\"Package Depth\"");
String getn_11 = new String("\"Package Length\"");
String getn_12 = new String("\"Package Width\"");
String getn_13 = new String("\"Ad Template Name\"");


String tem_0 = new String("notes");
String tem_1 = new String("item_price");
String tem_2 = new String("item_id");
String tem_3 = new String("custom_1");
String tem_4 = new String("handling");
String tem_5 = new String("item_description");
String tem_6 = new String("item_cost");
String tem_7 = new String("item_weight");
String tem_8 = new String("package_d");
String tem_9 = new String("package_l");
String tem_10 = new String("package_w");
String tem_11 = new String("part_number");
String tem_12 = new String("picture_1");
String tem_13 = new String("title");
String tem_14 = new String("title_url");
String tem_15 = new String("total_on_hand");


int int_title = 0;
int int_id = 0;
int int_cost = 0;
int int_price = 0;
int int_custom_1 = 0;
int int_item_description = 0;
int int_item_id = 0;
int int_picture_1 = 0;
int int_total_on_hand = 0;
int int_item_weight = 0;
int int_package_d = 0;
int int_package_l = 0;
int int_package_w = 0;
int int_custom_template = 0;
int running = 1;
int websites = 50;
int products_items = 50;
int page0 = -1;
int page1 = 0;
int page2 = 0;
int kcountx = 0;
int kcountx2 = 0;
int kcountxx = 0;
int kcountxx2 = 0;
int sleepx = 10;
int db_number = 0;
int pressx = 0;
int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0;
int ix6 = 0;
int ix1x = 0;
int ix0x = 0;


Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);

JLabel jl0 = new JLabel("", JLabel.RIGHT);
JLabel jl1 = new JLabel("Import Listings-Running.CSV", JLabel.LEFT);
JLabel jl2 = new JLabel("Loading...", JLabel.LEFT);

JLabel jl3 = new JLabel("Version 1.1.1", JLabel.LEFT);
JLabel jl4 = new JLabel("Database: Local CSV", JLabel.LEFT);
JLabel jl5 = new JLabel("d", JLabel.LEFT);
JLabel jls = new JLabel("", JLabel.LEFT);



JButton importx = new JButton("Import");


File file_db_1 = new File("Listings-Running.CSV");



File file_open_0 = new File("ALCHEMIST_DBX2.CSV");
File file_open_1 = new File("ALCHEMIST_DBX.CSV");
File file_open_2 = new File("SSi.ini");



csv_blackthorne_import(){//****************************

	super("Blackthore import");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(black);
	cenx = (scrSize.width / 2) - (xzx / 2);
	ceny = (scrSize.height / 2) - (xzy / 2) - 25;
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){nm.firex = 1;}});


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/black.png")).getImage();
	setIconImage(ximagex);

	Icon aicon = new ImageIcon(ximagex);

	jl0.setPreferredSize(new Dimension(320, 50));
	jl0.setBackground(black);
	jl0.setForeground(whitex);
	jl0.setOpaque(false);
	jl0.setIcon(aicon);
	jl0.setText("Version 1.1.1");
	jl0.setHorizontalTextPosition(JLabel.LEFT);
	jl0.setIconTextGap(30);

	jl1.setPreferredSize(new Dimension(320, 25));
	jl1.setBackground(black);
	jl1.setForeground(whitex);
	jl1.setOpaque(true);

	jl2.setPreferredSize(new Dimension(320, 25));
	jl2.setBackground(black);
	jl2.setForeground(whitex);
	jl2.setOpaque(true);

	jl3.setPreferredSize(new Dimension(320, 25));
	jl3.setBackground(black);
	jl3.setForeground(whitex);
	jl3.setOpaque(true);

	jl4.setPreferredSize(new Dimension(320, 25));
	jl4.setBackground(black);
	jl4.setForeground(whitex);
	jl4.setOpaque(true);

	jl5.setPreferredSize(new Dimension(320, 25));
	jl5.setBackground(black);
	jl5.setForeground(whitex);
	jl5.setOpaque(true);


	jls.setPreferredSize(new Dimension(400, 45));




	importx.setMargin(new Insets(0, 0, 0, 0));
  	importx.addActionListener(this);
 	importx.setPreferredSize(new Dimension(220, 45));
 	//importx.setIcon(imx2); 
	importx.setHorizontalTextPosition(JButton.CENTER);
 	//importx.setForeground(darkgreenx);
	importx.setBorder(null);


	BackgroundPanel bgp = new BackgroundPanel();
	bgp.setPreferredSize(new Dimension(350, 150));
	bgp.add(jl0);
	bgp.add(jl1);
	bgp.add(jl2);
	bgp.add(jl3);




	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(black);
	cp.add(bgp);



	nm.carbon[0][0][0] = new String("");
	nm.carbon[1][0][0] = new String("");
	nm.carbon[2][0][0] = new String("");
	nm.carbon[3][0][0] = new String("");
	nm.carbon[4][0][0] = new String("");
	nm.carbon[5][0][0] = new String("");

	//setVisible(true);



	f1 = new File(nm.carbon[4][0][26]);


	fc = new JFileChooser(f1);

   	ix0 = fc.showOpenDialog(frame);


	if(f1.exists() && ix0 == 0){

	   	f1 = fc.getSelectedFile();


		file_db_1 = f1;

		//load_csv1();
		test_csv();

		import_csv();
		save_csv_0();

	}//if
	else{System.out.println("USER CANCEL"); pullThePlug();}





}//import_blackthore********************************************************






//load****************************************************************************************************
//load****************************************************************************************************

	public void load_csv1(){

		dbx_loader dbxload = new dbx_loader(file_open_1);


		websites = kcountxx2;


	}//*******************









//save****************************************************************************************************
//save****************************************************************************************************




	public void save_csv_0(){



		nm.firex = 1;
		pullThePlug();


	}//csv








//save****************************************************************************************************
//save****************************************************************************************************










	public void test_csv(){

		csv_loader1 xcsvx2 = new csv_loader1(f1);
		carbonfiber = xcsvx2.getData0();
		kcountx = xcsvx2.getData1();
		kcountx2 = xcsvx2.getData2();

		System.out.println("kcountx: " + kcountx);
		System.out.println("kcountx2: " + kcountx2);

		//nm.carbon[0] = new String[nm.db_cc_number][kcountx2];
		carbon1 = new String[nm.db_cc_number][kcountx2];
		ix0 = 0;

		for(int xloop = 0; xloop < kcountx; xloop++){//******
		

			if(carbonfiber[xloop][0].equals(getn_0)){int_title = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_1)){int_id = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_2)){int_cost = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_3)){int_price = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_4)){int_custom_1 = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_5)){int_item_description = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_6)){int_item_id = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_7)){int_picture_1 = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_8)){int_total_on_hand = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_9)){int_item_weight = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_10)){int_package_d = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_11)){int_package_l = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_12)){int_package_w = xloop; ix0++;}
			if(carbonfiber[xloop][0].equals(getn_13)){int_custom_template = xloop; ix0++;}


		}//for************************************************************

		System.out.println("Found: " + ix0);

	}//test csv*******************
















	public void import_csv(){


	    for(int xloop = 1; xloop < kcountx2; xloop++){//******

			//System.out.println("dd" + xloop);

			jl5.setText("Importing: " + carbonfiber[int_title][xloop]);



			cx0 = carbonfiber[int_price][xloop];
			ix0 = cx0.indexOf(".");
			if(ix0 == -1){cx0 = cx0 + ".00";}
			carbonfiber[int_price][xloop] = cx0;


			cx0 = carbonfiber[int_cost][xloop];
			ix0 = cx0.indexOf(".");
			if(ix0 == -1){cx0 = cx0 + ".00";}
			carbonfiber[int_cost][xloop] = cx0;



			if(carbonfiber[int_title][xloop].length() > 2){
				cx0 = carbonfiber[int_title][xloop];
				if(cx0.substring(0,1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1, cx0.length() -1);}
				carbonfiber[int_title][xloop] = cx0;
			}//********

			if(carbonfiber[int_item_description][xloop].length() > 2){
				cx0 = carbonfiber[int_item_description][xloop];
				if(cx0.substring(0,1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1, cx0.length() -1);}
				carbonfiber[int_item_description][xloop] = cx0;
			}//********

			if(carbonfiber[int_picture_1][xloop].length() > 2){
				cx0 = carbonfiber[int_picture_1][xloop];
				if(cx0.substring(0,1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1, cx0.length() -1);}
				carbonfiber[int_picture_1][xloop] = cx0;
			}//********

			if(carbonfiber[int_custom_1][xloop].length() > 2){
				cx0 = carbonfiber[int_custom_1][xloop];
				if(cx0.substring(0,1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1, cx0.length() -1);}
				carbonfiber[int_custom_1][xloop] = cx0;
			}//********

			if(carbonfiber[int_id][xloop].length() > 2){
				cx0 = carbonfiber[int_id][xloop];
				if(cx0.substring(0,1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1, cx0.length() -1);}
				carbonfiber[int_id][xloop] = cx0;
			}//********

			if(carbonfiber[int_custom_template][xloop].length() > 2){
				cx0 = carbonfiber[int_custom_template][xloop];
				if(cx0.substring(0,1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1, cx0.length() -1);}
				carbonfiber[int_custom_template][xloop] = cx0;
			}//********

			if(carbonfiber[int_item_weight][xloop].length() > 2){
				cx0 = carbonfiber[int_item_weight][xloop];
				if(cx0.substring(0,1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1, cx0.length() -1);}
				carbonfiber[int_item_weight][xloop] = cx0;
			}//********

			if(carbonfiber[int_package_d][xloop].length() > 2){
				cx0 = carbonfiber[int_package_d][xloop];
				if(cx0.substring(0,1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1, cx0.length() -1);}
				carbonfiber[int_package_d][xloop] = cx0;
			}//********

			if(carbonfiber[int_item_weight][xloop].length() > 2){
				cx0 = carbonfiber[int_item_weight][xloop];
				if(cx0.substring(0,1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1, cx0.length() -1);}
				carbonfiber[int_item_weight][xloop] = cx0;
			}//********

			if(carbonfiber[int_item_weight][xloop].length() > 2){
				cx0 = carbonfiber[int_item_weight][xloop];
				if(cx0.substring(0,1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1, cx0.length() -1);}
				carbonfiber[int_item_weight][xloop] = cx0;
			}//********




			ix5 = Integer.parseInt(nm.carbon[4][0][12]) + (xloop + 1);


		    carbon1[0][xloop] = new String("address_1");
		    carbon1[1][xloop] = new String("address_2");
		    carbon1[2][xloop] = new String("address_3");
		    carbon1[3][xloop] = new String("address_4");
		    carbon1[4][xloop] = new String("address_5");
		    carbon1[5][xloop] = new String("address_5");
		    carbon1[6][xloop] = new String("buyer_id");
		    carbon1[7][xloop] = new String("buyers_email");
		    carbon1[8][xloop] = new String("buyers_first_name");
		    carbon1[9][xloop] = new String("buyers_last_name");
		    carbon1[10][xloop] = new String("buyers_notes");
		    carbon1[11][xloop] = new String("checkout_completed");
		    carbon1[12][xloop] = new String("currency");
		    carbon1[13][xloop] = carbonfiber[int_custom_1][xloop]; 
		    carbon1[14][xloop] = new String("custom_2");   
		    carbon1[15][xloop] = new String("custom_3");   
		    carbon1[16][xloop] = new String("custom_4");         
		    carbon1[17][xloop] = new String("custom_5");            
		    carbon1[18][xloop] = new String("custom_6"); 
		    carbon1[19][xloop] = new String("custom_7");
		    carbon1[20][xloop] = new String("custom_8"); 
		    carbon1[21][xloop] = new String("custom_9");  
		    carbon1[22][xloop] = new String("custom_10");   
		    carbon1[23][xloop] = new String("custom_11");   
		    carbon1[24][xloop] = new String("custom_12");         
		    carbon1[25][xloop] = new String("custom_13");            
		    carbon1[26][xloop] = new String("custom_14"); 
		    carbon1[27][xloop] = new String("custom_15");
		    carbon1[28][xloop] = new String("custom_16"); 
		    carbon1[29][xloop] = new String("custom_17");  
		    carbon1[30][xloop] = new String("custom_18");   
		    carbon1[31][xloop] = new String("custom_19");   
		    carbon1[32][xloop] = new String("custom_20");         
		    carbon1[33][xloop] = new String("custom_21");            
		    carbon1[34][xloop] = new String("custom_22"); 
		    carbon1[35][xloop] = new String("custom_23");
		    carbon1[36][xloop] = new String("custom_24"); 
		    carbon1[37][xloop] = new String("custom_25");  
		    carbon1[38][xloop] = new String("custom_26");   
		    carbon1[39][xloop] = new String("custom_27");   
		    carbon1[40][xloop] = new String("custom_28");         
		    carbon1[41][xloop] = new String("custom_29");            
		    carbon1[42][xloop] = new String("custom_30"); 
		    carbon1[43][xloop] = new String("custom_31");
		    carbon1[44][xloop] = new String("custom_32"); 
		    carbon1[45][xloop] = new String("custom_33");  
		    carbon1[46][xloop] = new String("custom_34");   
		    carbon1[47][xloop] = new String("custom_35");         
		    carbon1[48][xloop] = new String("custom_36");            
		    carbon1[49][xloop] = new String("custom_37"); 
		    carbon1[50][xloop] = new String("custom_38");
		    carbon1[51][xloop] = new String("custom_39"); 
		    carbon1[52][xloop] = new String("custom_40");  
		    carbon1[53][xloop] = new String("custom_41");   
		    carbon1[54][xloop] = new String("custom_42");   
		    carbon1[55][xloop] = new String("custom_43");         
		    carbon1[56][xloop] = new String("custom_44");            
		    carbon1[57][xloop] = new String("custom_45"); 
		    carbon1[58][xloop] = new String("custom_46");
		    carbon1[59][xloop] = carbonfiber[int_custom_template][xloop];
		    carbon1[60][xloop] = new String("date_last_modified");
		    carbon1[61][xloop] = new String("date_payment_received");
		    carbon1[62][xloop] = new String("date_shipped");
		    carbon1[63][xloop] = new String("date_sold");
		    carbon1[64][xloop] = new String("ebay_item"); 
		    carbon1[65][xloop] = new String("final_value_fee");
		    carbon1[66][xloop] = new String("handling");
		    carbon1[67][xloop] = new String("0");
		    carbon1[68][xloop] = carbonfiber[int_cost][xloop];
		    carbon1[69][xloop] = carbonfiber[int_item_description][xloop];
		    carbon1[70][xloop] = "bk" + (ix5);
		    carbon1[71][xloop] = carbonfiber[int_price][xloop];
		    carbon1[72][xloop] = carbonfiber[int_item_weight][xloop];
		    carbon1[73][xloop] = new String("listing_fees");
		    carbon1[74][xloop] = new String("listing_id");
		    carbon1[75][xloop] = new String("notes");
		    carbon1[76][xloop] = carbonfiber[int_package_d][xloop];
		    carbon1[77][xloop] = carbonfiber[int_package_l][xloop];
		    carbon1[78][xloop] = carbonfiber[int_package_w][xloop];
		    carbon1[79][xloop] = carbonfiber[int_id][xloop];
		    carbon1[80][xloop] = new String("payment_type");
		    carbon1[81][xloop] = new String("paypal_fees");
		    carbon1[82][xloop] = carbonfiber[int_picture_1][xloop];
		    carbon1[83][xloop] = new String("quantity_sold");
		    carbon1[84][xloop] = new String("sale_id");
		    carbon1[85][xloop] = new String("Error");
		    carbon1[86][xloop] = new String("sales_tax");
		    carbon1[87][xloop] = new String("shipping_company");
		    carbon1[88][xloop] = new String("shipping_in");
		    carbon1[89][xloop] = new String("shipping_out");
		    carbon1[90][xloop] = new String("site_id");
		    carbon1[91][xloop] = new String("site_url");
		    carbon1[92][xloop] = new String("source_of_sale");
		    carbon1[93][xloop] = carbonfiber[int_title][xloop];
		    carbon1[94][xloop] = new String("title_url");
		    carbon1[95][xloop] = carbonfiber[int_total_on_hand][xloop];
		    carbon1[96][xloop] = new String("total_sale_amount");
		    carbon1[97][xloop] = new String("tracking_number");
		    carbon1[98][xloop] = new String("transaction_id");
		    carbon1[99][xloop] = new String("transaction_info");






			System.out.println(carbon1[13][xloop]);

			carbon1[13][xloop] = carbonfiber[int_custom_1][xloop];
			cx0 = carbon1[13][xloop];
			if(cx0.substring(0,1).equals("\"") && !cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1,cx0.length()); carbon1[13][xloop] = cx0;}


			carbon1[69][xloop] = carbonfiber[int_item_description][xloop];
			cx0 = carbon1[69][xloop];
			if(cx0.substring(0,1).equals("\"") && !cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1,cx0.length()); carbon1[69][xloop] = cx0;}


			if(carbonfiber[int_title][xloop].length() > 2){
			carbon1[82][xloop] = carbonfiber[int_picture_1][xloop];
			cx0 = carbon1[82][xloop];
			if(cx0.substring(0,1).equals("\"") && !cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1,cx0.length()); carbon1[82][xloop] = cx0;}
			else{carbon1[82][xloop] = cx0;}
			}//if
			else{carbon1[82][xloop] = "imageshere";}


			if(carbonfiber[int_title][xloop].length() > 2){
			carbon1[93][xloop] = carbonfiber[int_title][xloop];
			cx0 = carbon1[93][xloop];
			if(cx0.substring(0,1).equals("\"") && !cx0.substring(cx0.length() -1, cx0.length()).equals("\"")){cx0 = cx0.substring(1,cx0.length()); carbon1[93][xloop] = cx0;}
			}//if
			else{carbon1[49][xloop] = "titlehere";}


		}//for************************************************************



		nm.carbon[4][0][12] = Integer.toString(ix5);




		ix0 = nm.carbon[0][0].length;
		ix1 = carbon1[0].length;
		ix3 = ix0 + ix1;

		carbon2 = nm.carbon[0];

		nm.carbon[0] = new String[nm.db_cc_number][(ix3 -1)];

		ix4 = 0;


		for(int xloop0 = 0; xloop0 < ix0; xloop0++){//******
		for(int xloop1 = 0; xloop1 < nm.db_cc_number; xloop1++){//******

			nm.carbon[0][xloop1][ix4] = carbon2[xloop1][xloop0];

		}//for***************************************************
		ix4++;
		}//for***************************************************





		for(int xloop0 = 1; xloop0 < ix1; xloop0++){//******
		for(int xloop1 = 0; xloop1 < nm.db_cc_number; xloop1++){//******

			nm.carbon[0][xloop1][ix4] = carbon1[xloop1][xloop0];

		}//for***************************************************
		ix4++;
		}//for***************************************************






		nm.carbon[0][0] [0] = new String("address_1");
		nm.carbon[0][1] [0] = new String("address_2");
		nm.carbon[0][2] [0] = new String("address_3");
		nm.carbon[0][3] [0] = new String("address_4");
		nm.carbon[0][4] [0] = new String("address_5");
		nm.carbon[0][5] [0] = new String("address_6");
		nm.carbon[0][6] [0] = new String("buyer_id");
		nm.carbon[0][7] [0] = new String("buyers_email");
		nm.carbon[0][8] [0] = new String("buyers_first_name");
		nm.carbon[0][9] [0] = new String("buyers_last_name");
		nm.carbon[0][10][0] = new String("buyers_notes");
		nm.carbon[0][11][0] = new String("buyers_phone");
		nm.carbon[0][12][0] = new String("currency");
		nm.carbon[0][13][0] = new String("custom_1");
		nm.carbon[0][14][0] = new String("custom_2");
		nm.carbon[0][15][0] = new String("custom_3");
		nm.carbon[0][16][0] = new String("custom_4");
		nm.carbon[0][17][0] = new String("custom_5");
		nm.carbon[0][18][0] = new String("custom_6");
		nm.carbon[0][19][0] = new String("custom_7");
		nm.carbon[0][20][0] = new String("custom_8");
		nm.carbon[0][21][0] = new String("custom_9");
		nm.carbon[0][22][0] = new String("custom_10");
		nm.carbon[0][23][0] = new String("custom_11");
		nm.carbon[0][24][0] = new String("custom_12");
		nm.carbon[0][25][0] = new String("custom_13");
		nm.carbon[0][26][0] = new String("custom_14");
		nm.carbon[0][27][0] = new String("custom_15");
		nm.carbon[0][28][0] = new String("custom_16");
		nm.carbon[0][29][0] = new String("custom_17");
		nm.carbon[0][30][0] = new String("custom_18");
		nm.carbon[0][31][0] = new String("custom_19");
		nm.carbon[0][32][0] = new String("custom_20");
		nm.carbon[0][33][0] = new String("custom_21");
		nm.carbon[0][34][0] = new String("custom_22");
		nm.carbon[0][35][0] = new String("custom_23");
		nm.carbon[0][36][0] = new String("custom_24");
		nm.carbon[0][37][0] = new String("custom_25");
		nm.carbon[0][38][0] = new String("custom_26");
		nm.carbon[0][39][0] = new String("custom_27");
		nm.carbon[0][40][0] = new String("custom_28");
		nm.carbon[0][41][0] = new String("custom_29");
		nm.carbon[0][42][0] = new String("custom_30");
		nm.carbon[0][43][0] = new String("custom_31");
		nm.carbon[0][44][0] = new String("custom_32");
		nm.carbon[0][45][0] = new String("custom_33");
		nm.carbon[0][46][0] = new String("custom_34");
		nm.carbon[0][47][0] = new String("custom_35");
		nm.carbon[0][48][0] = new String("custom_36");
		nm.carbon[0][49][0] = new String("custom_37");
		nm.carbon[0][50][0] = new String("custom_38");
		nm.carbon[0][51][0] = new String("custom_39");
		nm.carbon[0][52][0] = new String("custom_40");
		nm.carbon[0][53][0] = new String("custom_41");
		nm.carbon[0][54][0] = new String("custom_42");
		nm.carbon[0][55][0] = new String("custom_43");
		nm.carbon[0][56][0] = new String("custom_44");
		nm.carbon[0][57][0] = new String("custom_45");
		nm.carbon[0][58][0] = new String("custom_46");
		nm.carbon[0][59][0] = new String("custom_template");
		nm.carbon[0][60][0] = new String("date_last_modified");
		nm.carbon[0][61][0] = new String("date_payment_received");
		nm.carbon[0][62][0] = new String("date_shipped");
		nm.carbon[0][63][0] = new String("date_sold");
		nm.carbon[0][64][0] = new String("ebay_item");
		nm.carbon[0][65][0] = new String("final_value_fee");
		nm.carbon[0][66][0] = new String("handling");
		nm.carbon[0][67][0] = new String("hits");
		nm.carbon[0][68][0] = new String("item_cost");
		nm.carbon[0][69][0] = new String("item_description");
		nm.carbon[0][70][0] = new String("item_id");
		nm.carbon[0][71][0] = new String("item_price");
		nm.carbon[0][72][0] = new String("item_weight");
		nm.carbon[0][73][0] = new String("listing_fees");
		nm.carbon[0][74][0] = new String("listing_id");
		nm.carbon[0][75][0] = new String("notes");
		nm.carbon[0][76][0] = new String("package_d");
		nm.carbon[0][77][0] = new String("package_l");
		nm.carbon[0][78][0] = new String("package_w");
		nm.carbon[0][79][0] = new String("part_number");
		nm.carbon[0][80][0] = new String("payment_type");
		nm.carbon[0][81][0] = new String("paypal_fees");
		nm.carbon[0][82][0] = new String("picture_1");
		nm.carbon[0][83][0] = new String("quantity_sold");
		nm.carbon[0][84][0] = new String("sale_id");
		nm.carbon[0][85][0] = new String("sale_status");
		nm.carbon[0][86][0] = new String("sales_tax");
		nm.carbon[0][87][0] = new String("shipping_company");
		nm.carbon[0][88][0] = new String("shipping_in");
		nm.carbon[0][89][0] = new String("shipping_out");
		nm.carbon[0][90][0] = new String("site_id");
		nm.carbon[0][91][0] = new String("site_url");
		nm.carbon[0][92][0] = new String("source_of_sale");
		nm.carbon[0][93][0] = new String("title");
		nm.carbon[0][94][0] = new String("title_url");
		nm.carbon[0][95][0] = new String("total_on_hand");
		nm.carbon[0][96][0] = new String("total_sale_amount");
		nm.carbon[0][97][0] = new String("tracking_number");
		nm.carbon[0][98][0] = new String("transaction_id");
		nm.carbon[0][99][0] = new String("transaction_info");


		jl5.setText("Done.");
			



	}//import ***************















//handel all the button clicks. 
public void actionPerformed(ActionEvent event){



	if(event.getSource() == importx){import_csv(); save_csv_0();}//not used




}//actionPerformed	






    public void pullThePlug(){

	    System.out.println("PULL THE PLUG");

	    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

	    nm.firex = 1;


    }//pull











	class BackgroundPanel extends JPanel{
  
  		Image image;
  
  		public BackgroundPanel(){
    
    		try{

      			image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3.jpg"), "background3.jpg"));

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
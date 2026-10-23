//alchemist dbx version

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;





public class quickbooks_export_sales {

File f1;

int csv_passes_x = 26;
int runs = 5000;

File file_iff_1 = new File(System.getProperty("user.dir") + "\\iif_build\\iff_template.iif");
File file_ite_1 = new File(System.getProperty("user.dir") + "\\iif_build\\item_template.iif");
File file_tra_1 = new File(System.getProperty("user.dir") + "\\iif_build\\tran_template.iif");
File file_tra_2 = new File(System.getProperty("user.dir") + "\\iif_build\\tran_template_tax.iif");
File file_csv_1 = new File("Sales-Paid.csv");
File file_ssx_1 = new File("SSi.ini");
File file_sst_1 = new File(System.getProperty("user.dir") + "\\iif_build\\SST_template.csv");

int iff_int = 0;
int tra_int = 0;
int tra_int_tax = 0;
int ite_int = 0;
int csv_int = 0;
int ssx_int = 0;
int out_int = 0;

String IFFTEMP[] = new String[0];
String TRATEMP[] = new String[0];
String TRATEMP_TAX[] = new String[0];
String ITETEMP[] = new String[0];
String CSVTEMP[] = new String[0];
String SSXTEMP[] = new String[0];
String OUTTEMP[] = new String[runs];

String str_iff = new String("iif_build/iff_template.iif");
String str_ite = new String("iif_build/item_template.iif");
String str_tra = new String("iif_build/tran_template.iif");
String str_tra_tax = new String("iif_build/tran_template_tax.iif");

String main = new String("");
String xlinex = new String("");
String blank = new String("");

String getn_0 = new String("\"Date Payment Received\"");
String getn_1 = new String("\"Buyers.eBay Userid\"");
String getn_2 = new String("\"Part Number\"");
String getn_3 = new String("\"Item Cost\"");
String getn_4 = new String("\"Title\"");
String getn_5 = new String("\"Consignment Commission\"");
String getn_6 = new String("\"PayPal Fees Paid\"");
String getn_7 = new String("\"Final Value Fee\"");
String getn_8 = new String("\"Quantity Sold\"");
String getn_9 = new String("\"Shipping\"");
String getn_10 = new String("\"Actual Shipping\"");
String getn_11 = new String("\"Handling\"");

String getn_13 = new String("\"ShippingAddress.First Name\"");
String getn_14 = new String("\"ShippingAddress.Last Name\"");
String getn_15 = new String("\"ShippingAddress.Address Line 1\"");
String getn_16 = new String("\"ShippingAddress.Address Line 2\"");
String getn_17 = new String("\"ShippingAddress.City\"");
String getn_18 = new String("\"ShippingAddress.State\"");
String getn_19 = new String("\"ShippingAddress.Zip\"");
String getn_20 = new String("\"ShippingAddress.Country\"");

String getn_21 = new String("\"Sales Tax\"");

String carbonfiber[][];
String goldfiber[][];
String d1 = new String();
String d2 = new String();
String rep1 = new String();
String rep2 = new String();
String rex = new String(".jpg.gif");
String rexw = new String("");
String save_as = new String("converted_tranactions.iif");

String cx0 = new String();
String cx1 = new String();
String cx2 = new String();
String cx3 = new String();
String cx4 = new String();

int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0; 
int ix6 = 0; 
int fg = 0;
int fs = 0;
int kcountxx = 0;
int thisx = 0;
int loopc1 = 0;
int thisc2 = 0;//the second carbonfiber array.
int working = 0; 

int nfor_date = 0;
int nfor_name = 1;
int nfor_title = 2;
int nfor_cost = 0;
int nfor_desc = 0;
int nfor_sale_price = 10;
int nfor_paypal = 8;
int nfor_ebay = 9;
int nfor_quantity = 3;
int nfor_shipping = 5;
int nfor_shipping_paid = 6;
int nfor_handling = 7;

int nfor_firt_name = 3;
int nfor_last_name = 5;
int nfor_address1 = 3;
int nfor_address2 = 5;
int nfor_city = 6;
int nfor_state = 7;
int nfor_zip = 7;
int nfor_country = 7;

int nfor_tax = 7;
int nfor_sale_site = 7;
int nfor_sale_customer = 7;

int nfor_tracking_number = 7;






quickbooks_export_sales(String[][] inxx) {//********************************************************************************************************
	
	carbonfiber = inxx;

	System.out.println("carbonfiber " + carbonfiber[0].length);

	JFrame frame = new JFrame();

	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	frame.setIconImage(ximagex);

	f1 = new File(nm.carbon[4][0][26]);
	JFileChooser fc = new JFileChooser(f1);
	fc.setCurrentDirectory(new File(f1.getAbsolutePath()));


	f1 = new File(f1 + "\\quickbooks_sales_iif.iif"); 
	save_as = new String("quickbooks_sales_iif.iif");


	fc.setSelectedFile(f1);
	int returnVal = fc.showSaveDialog(frame);
	f1 = fc.getSelectedFile(); //This grabs the File you typed

	System.out.println(returnVal);

	if (returnVal == 0) {

		nm.carbon[4][0][26] = f1.toString(); 
		convert_iff();

	}//******************


}//postid**************************************************************************************************************







	public void loadx0() {

		try {

			Path path = Paths.get(str_iff);
			int lineCount = (int) Files.lines(path).count();

			iff_int = 0;

			IFFTEMP = new String[lineCount];

			BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(str_iff)));

			xlinex = blank;
			while ((xlinex = in.readLine()) != null) {IFFTEMP[iff_int] = xlinex; iff_int++;}
			in.close();

		} catch (IOException e) {working = 0;}

	}//loadx************



	public void loadx1() {
	
		try {
		
			Path path = Paths.get(str_ite);
			int lineCount = (int) Files.lines(path).count();

			tra_int = 0;

			ITETEMP = new String[lineCount];

			BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(str_ite)));

			xlinex = blank;
			while ((xlinex = in.readLine()) != null) {ITETEMP[ite_int] = xlinex; ite_int++;}
			in.close();

		} catch (IOException e) {working = 0;}

	}//loadx************



	public void loadx2() {
	
		try {
	
			Path path = Paths.get(str_tra);
			int lineCount = (int) Files.lines(path).count();

			tra_int = 0;

			TRATEMP = new String[lineCount];

			BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(str_tra)));

			xlinex = blank;
			while ((xlinex = in.readLine()) != null) {TRATEMP[tra_int] = xlinex; tra_int++;}
			in.close();

		} catch (IOException e) {working = 0;}

	}//loadx************



	public void loadx2_tax() {
	
		try {
			
			Path path = Paths.get(str_tra_tax);
			int lineCount = (int) Files.lines(path).count();

			tra_int_tax = 0;

			TRATEMP_TAX = new String[lineCount];

			BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(str_tra_tax)));

			xlinex = blank;
			while ((xlinex = in.readLine()) != null) {TRATEMP_TAX[tra_int_tax] = xlinex; tra_int_tax++;}
			in.close();

		} catch (IOException e) {working = 0;}

	}//loadx************








	public void show_load() {

		working = 1;

		loadx0();
		loadx1();
		loadx2();
		loadx2_tax();

		loadxcsv(); 
		check_csv();  
		fix_price(); 
		fix_item_name(); 
		fix_date(); 
		compress();

	}//showload.





	//break up the CSV file
	public void loadxcsv() {

		thisc2 = carbonfiber.length;
		csv_int = carbonfiber[0].length;

		if (thisc2 > 11) {

			System.out.println("CSV File is loaded. " + thisc2 + " sections and " + csv_int + " rows.");

		}//***************
		else {

			System.out.println("CSV File is did not pass test1..." + thisc2 + " sections and " + csv_int + " rows.");

		}//***

	}//loadx









	public void compress() {//************************************************************************************************************************************


		goldfiber = new String[26][csv_int];


		for (int loop1 = 0; loop1 < csv_int; loop1++) {

			goldfiber[0][loop1] =  carbonfiber[nfor_date][loop1];
			goldfiber[1][loop1] =  carbonfiber[nfor_name][loop1];
			goldfiber[2][loop1] =  carbonfiber[nm.part_number_xx][loop1];
			goldfiber[3][loop1] =  carbonfiber[nm.item_cost_xx][loop1];
			goldfiber[4][loop1] =  carbonfiber[nm.title_xx][loop1];
			goldfiber[5][loop1] =  carbonfiber[nm.item_price_xx][loop1];
			goldfiber[6][loop1] =  carbonfiber[nfor_paypal][loop1];
			goldfiber[7][loop1] =  carbonfiber[nfor_ebay][loop1];
			goldfiber[8][loop1] =  carbonfiber[nfor_quantity][loop1];
			goldfiber[9][loop1] =  carbonfiber[nfor_shipping][loop1];
			goldfiber[10][loop1] = carbonfiber[nfor_shipping_paid][loop1];
			goldfiber[11][loop1] = carbonfiber[nfor_handling][loop1];
			goldfiber[12][loop1] = carbonfiber[58][loop1];

			goldfiber[13][loop1] = carbonfiber[nfor_firt_name][loop1];
			goldfiber[14][loop1] = carbonfiber[nfor_last_name][loop1];
			goldfiber[15][loop1] = carbonfiber[nfor_address1][loop1];
			goldfiber[16][loop1] = carbonfiber[nfor_address2][loop1];
			goldfiber[17][loop1] = carbonfiber[nfor_city][loop1];
			goldfiber[18][loop1] = carbonfiber[nfor_state][loop1];
			goldfiber[19][loop1] = carbonfiber[nfor_zip][loop1];
			goldfiber[20][loop1] = carbonfiber[nfor_country][loop1];

			goldfiber[21][loop1] = carbonfiber[nfor_tax][loop1];

			System.out.println(carbonfiber[nm.item_price_xx][loop1]);
			goldfiber[22][loop1] = carbonfiber[nm.item_price_xx][loop1];
			goldfiber[22][loop1] = Float.toString(Float.parseFloat(goldfiber[22][loop1]) / Integer.parseInt(carbonfiber[nfor_quantity][loop1]));

			goldfiber[23][loop1] = carbonfiber[nfor_sale_site][loop1];
			goldfiber[24][loop1] = carbonfiber[nfor_sale_customer][loop1];

			//tracking number
			goldfiber[25][loop1] = carbonfiber[nfor_tracking_number][loop1];

		}//for******************************************



		System.out.println("nfor_date " + nfor_date);
		System.out.println("nfor_name " + nfor_name);
		System.out.println("nfor_title " + nfor_title );
		System.out.println("nfor_cost " + nfor_cost);
		System.out.println("nfor_desc " + nfor_desc);
		System.out.println("nfor_sale_price " + nfor_sale_price);
		System.out.println("nfor_paypal " + nfor_paypal);
		System.out.println("nfor_ebay " + nfor_ebay);
		System.out.println("nfor_quantity " + nfor_quantity);
		System.out.println("nfor_shipping " + nfor_shipping);
		System.out.println("nfor_shipping_paid " + nfor_shipping_paid);


		carbonfiber = goldfiber;


	}//compress**************************************************************************************************************************************************








	public void check_csv() {//

		int test_3_x = 0; 


		nfor_date            = nm.date_sold_xx;          test_3_x++;
		nfor_name            = nm.buyer_id_xx;           test_3_x++;
		nfor_title           = nm.title_xx;              test_3_x++;
		nfor_cost            = nm.item_cost_xx;          test_3_x++;
		nfor_desc            = nm.part_number_xx;        test_3_x++;
		nfor_sale_price      = nm.item_price_xx;         test_3_x++;
		nfor_paypal          = nm.paypal_fees_xx;        test_3_x++;
		nfor_ebay            = nm.final_value_fee_xx;    test_3_x++;
		nfor_quantity        = nm.quantity_sold_xx;      test_3_x++;
		nfor_shipping        = nm.shipping_in_xx;        test_3_x++;
		nfor_shipping_paid   = nm.shipping_out_xx;       test_3_x++;
		nfor_handling        = nm.handling_xx;           test_3_x++;
		nfor_firt_name       = nm.buyers_first_name_xx;  test_3_x++;
		nfor_last_name       = nm.buyers_last_name_xx;   test_3_x++;
		nfor_address1        = nm.address_1_xx;          test_3_x++;
		nfor_address2        = nm.address_2_xx;          test_3_x++;
		nfor_city            = nm.address_2_xx;          test_3_x++;
		nfor_state           = nm.address_3_xx;          test_3_x++;
		nfor_zip             = nm.address_4_xx;          test_3_x++;
		nfor_country         = nm.address_5_xx;          test_3_x++;
		nfor_tax             = nm.sales_tax_xx;          test_3_x++;
		nfor_sale_site       = nm.source_of_sale_xx;     test_3_x++;
        nfor_sale_customer   = nm.site_id_xx;            test_3_x++;
        nfor_tracking_number = nm.tracking_number_xx;    test_3_x++;


		System.out.println("nfor_date          " + nfor_date);
		System.out.println("nfor_name          " + nfor_name);
		System.out.println("nfor_title         " + nfor_title );
		System.out.println("nfor_cost          " + nfor_cost);
		System.out.println("nfor_desc          " + nfor_desc);
		System.out.println("nfor_sale_price    " + nfor_sale_price);
		System.out.println("nfor_paypal        " + nfor_paypal);
		System.out.println("nfor_ebay          " + nfor_ebay);
		System.out.println("nfor_quantity      " + nfor_quantity);
		System.out.println("nfor_shipping      " + nfor_shipping);
		System.out.println("nfor_shipping_paid " + nfor_shipping_paid);

		System.out.println("");


		System.out.println("CSV File is good... TEST = " + test_3_x);

		if (test_3_x < 19) {

			System.out.println("CSV File is bad... TEST = " + test_3_x);

		}//if***************


	}//check






	public void fix_date() {


		System.out.println("xx " + carbonfiber.length + " " + carbonfiber[0].length);

		for (int loop1 = 0; loop1 < csv_int; loop1++) {

			cx0 = carbonfiber[nfor_date][loop1];
			System.out.println(cx0 + " " + nfor_date + " " + carbonfiber[nfor_date][loop1]);

			//System.out.println(carbonfiber[0][loop1]);

		}//*******************************************


		for (int loop1 = 0; loop1 < csv_int; loop1++) {

			cx0 = carbonfiber[nfor_date][loop1];

			//change 

			ix0 = cx0.lastIndexOf("-");
			cx0 = cx0.substring(0, ix0);
	
			cx1 = cx0;
			ix0 = cx0.indexOf("-");
			ix1 = cx0.lastIndexOf("-");


			//2012-02-29
			cx0 = cx1.substring(ix1 + 1, cx1.length()) + "-" + cx1.substring(ix0 + 1, ix1) + "-" + cx1.substring(0, ix0);


			System.out.println(cx0);
	
			carbonfiber[nfor_date][loop1] = cx0;

			//System.out.println(carbonfiber[nfor_date][loop1]);

		}//*******************************************


	}//********************






	public void fix_item_name() {

		for (int loop1 = 0; loop1 < carbonfiber[0].length; loop1++) {


			System.out.println("xx   " + carbonfiber.length + " " + carbonfiber[0].length);
			System.out.println("xxxx " + carbonfiber[nfor_title][loop1] + " " + carbonfiber[0].length);

			cx0 = carbonfiber[nfor_title][loop1];

			cx0.replace("'","");
			cx0.replace("/","");
			cx0.replace("\"","");
			cx0.replace("-","");
			cx0.replace("!","");
			cx0.replace(".","");

			if (cx0.length() > 80) {cx0 = cx0.substring(0, 80);}

			carbonfiber[nfor_title][loop1] = cx0;
			//System.out.println(carbonfiber[2][loop1]);

		}//*******************************************

		System.out.println("FIX NAME DONE ");

	}//********************








	public void fix_item_desc() {


		for (int loop1 = 0; loop1 < csv_int; loop1++) {

			cx0 = carbonfiber[nfor_desc][loop1];
			cx0 = cx0.substring(1, cx0.length() - 1);

			cx0.replace("'","");
			cx0.replace("/","");
			cx0.replace("\"","");
			cx0.replace("-","");
			cx0.replace("!","");
			cx0.replace(".","");

			if (cx0.length() > 30) {cx0 = cx0.substring(0, 20);}

			carbonfiber[nfor_desc][loop1] = cx0;
			//System.out.println(carbonfiber[loop1][2]);

		}//*******************************************


	}//********************










	public void fix_name() {


		for (int loop1 = 0; loop1 < csv_int; loop1++) {

			System.out.println("CSV name section: " + carbonfiber[nfor_name][loop1] + " " + carbonfiber[nfor_name + 1][loop1]);
			System.out.println(carbonfiber[nfor_name][loop1] + " " + carbonfiber[nfor_name + 1][loop1]);

			cx0 = carbonfiber[nfor_name][loop1];
			cx0 = cx0.substring(1, cx0.length() -1);
			carbonfiber[nfor_name][loop1] = cx0;

			//System.out.println(carbonfiber[nfor_name][loop1]);

		}//*******************************************


	}//********************







	public void fix_price() {

		Float fx0 = (float) 0.0;
		int fxc = 0;
		Float fx1 = (float) 0.0;
		Float fx2 = (float) 0.0;
		Float fx3 = (float) 0.0;
		Float fx4 = (float) 0.0;
		Float fx5 = (float) 0.0;
		Float fx51 = (float) 0.0;//tax
		Float fx6 = (float) 0.0;


		for (int loop1 = 0; loop1 < csv_int; loop1++) {

			System.out.println("xxx " + carbonfiber[nfor_sale_price][loop1]);

			fx0 = (Float.parseFloat(carbonfiber[nfor_sale_price][loop1]) * 100);//start sale price
			fxc =  Integer.parseInt(carbonfiber[nfor_quantity][loop1]);//quantity
			fx1 = (Float.parseFloat(carbonfiber[nfor_shipping][loop1]) * 100);//shipping
			fx2 = (Float.parseFloat(carbonfiber[nfor_shipping_paid][loop1]) * 100);//shipping paid
			fx3 = (Float.parseFloat(carbonfiber[nfor_handling][loop1]) * 100);//handling
			fx4 = (Float.parseFloat(carbonfiber[nfor_paypal][loop1]) * 100);//paypal
			fx5 = (Float.parseFloat(carbonfiber[nfor_ebay][loop1]) * 100);//ebay
			fx51 = (Float.parseFloat(carbonfiber[nfor_tax][loop1]) * 100);//tax

			fx6 = (float)(Math.round((fx0 + fx1 + fx3 + fx51) - (fx2 + fx4 + fx5)));
			fx6 = (fx6 / 100);

			System.out.println("mm+ " + Math.round((fx0 + fx1 + fx3 + fx51)));
			System.out.println("mm- " + Math.round((fx2 + fx4 + fx5)));


			System.out.println();
			System.out.println(fx0);
			System.out.println(fx1);
			System.out.println(fx2);
			System.out.println(fx3);
			System.out.println(fx4);
			System.out.println(fx5);
			System.out.println("");
			System.out.println(fx6);

			cx0 = Float.toString(fx6);

			ix0 = cx0.indexOf(".");

			if (ix0 > -1 && ix0 == cx0.length() - 6) {

				if (cx0.substring(ix0 + 3, ix0 + 4).equals("9")) {

					System.out.println(cx0);
					System.out.println(cx0.substring(ix0 + 2, ix0 + 3));

					     if (cx0.substring(ix0 + 2, ix0 + 3).equals("0")) {cx0 = cx0.substring(0, ix0 + 2) + "1";}
					else if (cx0.substring(ix0 + 2, ix0 + 3).equals("1")) {cx0 = cx0.substring(0, ix0 + 2) + "2";}
					else if (cx0.substring(ix0 + 2, ix0 + 3).equals("2")) {cx0 = cx0.substring(0, ix0 + 2) + "3";}
					else if (cx0.substring(ix0 + 2, ix0 + 3).equals("3")) {cx0 = cx0.substring(0, ix0 + 2) + "4";}
					else if (cx0.substring(ix0 + 2, ix0 + 3).equals("4")) {cx0 = cx0.substring(0, ix0 + 2) + "5";}
					else if (cx0.substring(ix0 + 2, ix0 + 3).equals("5")) {cx0 = cx0.substring(0, ix0 + 2) + "6";}
					else if (cx0.substring(ix0 + 2, ix0 + 3).equals("6")) {cx0 = cx0.substring(0, ix0 + 2) + "7";}
					else if (cx0.substring(ix0 + 2, ix0 + 3).equals("7")) {cx0 = cx0.substring(0, ix0 + 2) + "8";}
					else if (cx0.substring(ix0 + 2, ix0 + 3).equals("8")) {cx0 = cx0.substring(0, ix0 + 2) + "9";}
					else if (cx0.substring(ix0 + 2, ix0 + 3).equals("9")) {cx0 = cx0.substring(0, ix0 + 1) + "0";}
					else {working = 0;}

					System.out.println(cx0);


				}//if*******************************************
				else if (cx0.substring(ix0 + 3, ix0 + 4).equals("0")) {

					cx0 = cx0.substring(0, cx0.length() - 3);

				}//****************************************************

			}//if



			carbonfiber[58][loop1] = cx0;
			System.out.println(cx0);

			if (working == 1) {System.out.println("CSV math sections converted...");}


		}//*******************************************for

	}//********************price






	public void fix_address() {


		for (int loop1 = 0; loop1 < csv_int; loop1++) {

			carbonfiber[nfor_firt_name][loop1] = carbonfiber[nfor_firt_name][loop1].substring(1, carbonfiber[nfor_firt_name][loop1].length() -1);
			carbonfiber[nfor_last_name][loop1] = carbonfiber[nfor_last_name][loop1].substring(1, carbonfiber[nfor_last_name][loop1].length() -1);
			carbonfiber[nfor_address1][loop1]  = carbonfiber[nfor_address1][loop1].substring(1, carbonfiber[nfor_address1][loop1].length() -1);
			carbonfiber[nfor_address2][loop1]  = carbonfiber[nfor_address2][loop1].substring(1, carbonfiber[nfor_address2][loop1].length() -1);
			carbonfiber[nfor_city][loop1]      = carbonfiber[nfor_city][loop1].substring(1, carbonfiber[nfor_city][loop1].length() -1);
			carbonfiber[nfor_state][loop1]     = carbonfiber[nfor_state][loop1].substring(1, carbonfiber[nfor_state][loop1].length() -1);
			carbonfiber[nfor_zip][loop1]       = carbonfiber[nfor_zip][loop1].substring(1, carbonfiber[nfor_zip][loop1].length() -1);
			carbonfiber[nfor_country][loop1]   = carbonfiber[nfor_country][loop1].substring(1, carbonfiber[nfor_country][loop1].length() -1);

		}//*******************************************


	}//********************











	//items replace. 
	public void replace_items() {


		for (int loop0 = ix6; loop0 < ix6 + 1; loop0++) {//**********************number of files  
		
			loopc1 = loop0;

			//refresh clean template
			for (int loopx0 = 0; loopx0 < ite_int; loopx0++) { 

				OUTTEMP[loopx0] = ITETEMP[loopx0];
				//System.out.println(OUTTEMP[loopx0]);

			}//for*******************************************

			//System.out.println(OUTTEMP[31]);
			//System.out.println(carbon1[31]);

			for (int loop2 = 0; loop2 < ite_int; loop2++) {//template lines

				for (int loop1 = 0; loop1 < csv_passes_x; loop1++) {//************csv sections


					for (int loopx = 0; loopx < 100; loopx++) {//*csv repeats***

						ix4 = loop2;

						cx0 = "<!--Java_CFA[" + loop1 + "]-->";
						ix0 = OUTTEMP[loop2].indexOf(cx0);

						if (ix0 == -1) {}
						else {

							OUTTEMP[loop2] = OUTTEMP[loop2].substring(0, ix0) + carbonfiber[loop1][loop0] + OUTTEMP[loop2].substring(ix0 + cx0.length(), OUTTEMP[loop2].length());
							//System.out.println("output; " + OUTTEMP[loop2]);

						}//else

					}//for*****************************************************


				}//for*****************************************************

			}//for***************************************

			//print1();

		}//for**************************************************************

		//l5.setText(ix5);

	}//cf replace







	public void cfreplace() {


	
		for (int loop0 = ix6; loop0 < ix6 + 1; loop0++) {//**********************number of files  
	
			loopc1 = loop0;

			//refresh clean template
			for (int loopx0 = 0; loopx0 < tra_int; loopx0++) {
		
				OUTTEMP[loopx0] = TRATEMP[loopx0];
				//System.out.println(OUTTEMP[loopx0]);

			}//for*******************************************
			//System.out.println(OUTTEMP[31]);
			//System.out.println(carbon1[31]);

			for (int loop2 = 0; loop2 < tra_int; loop2++) {//template lines   

				for (int loop1 = 0; loop1 < csv_passes_x; loop1++) {//************csv sections

					for (int loopx = 0; loopx < 100; loopx++) {//*csv repeats***
	
						ix4 = loop2;

						cx0 = "<!--Java_CFA[" + loop1 + "]-->";
						ix0 = OUTTEMP[loop2].indexOf(cx0);

						if (ix0 == -1) {}
						else {

							//System.out.println("replace");
							OUTTEMP[loop2] = OUTTEMP[loop2].substring(0, ix0) + carbonfiber[loop1][loop0] + OUTTEMP[loop2].substring(ix0 + cx0.length(), OUTTEMP[loop2].length());
	
						}//else

					}//for*****************************************************


				}//for*****************************************************

			}//for***************************************

			//print1();

		}//for**************************************************************

		//System.out.println(ix5);

	}//cf replace










	public void cfreplace_tax(){//**********************TAX VERSION


	
		for (int loop0 = ix6; loop0 < ix6 + 1; loop0++) {//**********************number of files  
	
			loopc1 = loop0;

			//refresh clean template
			for (int loopx0 = 0; loopx0 < tra_int_tax; loopx0++) {

				OUTTEMP[loopx0] = TRATEMP_TAX[loopx0];
				//System.out.println(OUTTEMP[loopx0]);

			}//for*************************************************


			for (int loop2 = 0; loop2 < tra_int_tax; loop2++) {//template lines   

				for (int loop1 = 0; loop1 < csv_passes_x; loop1++) {//************csv sections

					for (int loopx = 0; loopx < 100; loopx++) {//*csv repeats***

						ix4 = loop2;

						cx0 = "<!--Java_CFA[" + loop1 + "]-->";
						ix0 = OUTTEMP[loop2].indexOf(cx0);

						if (ix0 == -1) {}
						else {
	
							//System.out.println("replace");
							OUTTEMP[loop2] = OUTTEMP[loop2].substring(0, ix0) + carbonfiber[loop1][loop0] + OUTTEMP[loop2].substring(ix0 + cx0.length(), OUTTEMP[loop2].length());
	
						}//else

					}//for*****************************************************


				}//for*****************************************************

			}//for***************************************

			//print1();

		}//for**************************************************************

		//System.out.println(ix5);

	}//cf replace













	public void convert_iff(){

		show_load();

		//build header
	

		try {

        	BufferedWriter out = new BufferedWriter(new FileWriter(f1));

			for (int loop1 = 0; loop1 < iff_int; loop1++) {
	
				out.write(IFFTEMP[loop1]); out.newLine();

			}//for*****************************************


			//the compiled items list. 
			//for (int loop0 = 0; loop0 < csv_int; loop0++){

			//ix6 = loop0;
			//replace_items();

			//	for (int loop1 = 0; loop1 < ite_int; loop1++){out.write(OUTTEMP[loop1]); out.newLine();}//for
			//}//for****************************************
			//the compiled transactions list. 


			//the compiled transactions list. 
			System.out.println("PRINT LIST***************** " + csv_int + " " + goldfiber[21][0]);

			for (int loop0 = (csv_int -1); loop0 > -1; loop0--){

				ix6 = loop0;

				if (Float.parseFloat(goldfiber[21][loop0]) > 0) {

					cfreplace_tax(); 
					System.out.println("*TAX************************************************************************");

				}//**********************************************
				else {

					cfreplace(); 
					System.out.println("NO TAX**********************************************************************");

				}//****


				for (int loop1 = 0; loop1 < tra_int; loop1++) {

					out.write(OUTTEMP[loop1]); 
					out.newLine();

				}//for*****************************************

			}//for****************************************


        	out.close();

        } catch (IOException e) {e.printStackTrace();}



		JOptionPane.showMessageDialog(null,"Exported Quickbooks_sales.iif\nQuickbooks uses the system clock to make it's date. You MUST use 15-APR-2010 display type for this export to work.");

	}//convert iff************






}//last
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  







public class dbx_loader{//************************************************************************

int csv_passes_x = 17;

static int runx = 0;
static int runs2 = 400;
static int runs = 50000;

int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int loop_pass_1 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0;
int kcountxx = 0;
int kcountxx2 = 0;
int websites = 0;

int stop = 0;
int ix0x = 0;
int ix1x = 0;

String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");
String[][] carbon_load = new String[7][7];

File st1;
String[] CSVTEMP = new String[runs];
public static String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");

csv_saver1 xxp;
csv_saver1 xxr;
csv_loader1 xcsvx1;
csv_loader1 xcsvx2;
csv_loader1 xcsvx3;
csv_loader1 xcsvx4;

//static String[][][] nm.carbon = new String[7][7][7];



File file_open_0 = new File("ALCHEMIST_DBX2.CSV");
File file_open_1 = new File("ALCHEMIST_DBX.CSV");









dbx_loader(File st1){//****************************

	stop = 0;
	csv_int = 0;
	thisc3 = 0;

	try {

		BufferedReader in = new BufferedReader(new FileReader(st1));
		xlinex = blank;
		while ((xlinex = in.readLine()) != null){CSVTEMP[csv_int] = xlinex; csv_int++; thisc3++;}
		in.close();

	}catch(IOException e){working = 0; System.out.println("no file " + st1);}


	if(csv_int < 1){System.out.println("file is empty."); working = 0; rebuild();}
	else{//**********************************************

		cx0 = CSVTEMP[0];
		runx = 1;


			for (int loop1 = 0; loop1 < runs; loop1++){

				ix0 = cx0.indexOf("<*°*>");
				ix1 = cx0.indexOf("<*°*>");
				ix2 = cx0.indexOf("<*°*>");

				if(ix0 > -1){runx++; cx0 = cx0.substring(ix0 + 5, cx0.length());}
				else if(ix1 > -1){runx++; cx0 = cx0.substring(ix1 + 5, cx0.length());}
				else if(ix2 > -1){runx++; cx0 = cx0.substring(ix2 + 5, cx0.length());}
				else{break;}

				//System.out.println("runx " + runx);

			}//******************************************



			runs2 = runx;
			//System.out.println("ccx " + runx);
			//System.out.println("csv_int " + csv_int);

			check_csv();
			if(working == 1){loadxcsv(); load_csv1xx();}
			//else{rebuild_db ddx = new rebuild();}

	}//else************************************************

}//csv_loader_x1********************************************************





//csvx***********************************************************************************************************************************************************************************
//csvx***********************************************************************************************************************************************************************************









public void check_csv(){


	carbonfiber = new String[runs2][thisc3];


}//*********************







	public void loadxcsv(){//break up the csv file

		thisc2 = 0;

		for (int loop1 = 0; loop1 < csv_int; loop1++){

			cx0 = CSVTEMP[loop1];

			for (int loop2 = 0; loop2 < 500; loop2++){


				ix0 = cx0.indexOf("<*°*>");
				if(ix0 > -1){//***********************

					if(loop2 == carbonfiber.length -1){System.out.println("fail"); break;}
					thisc2 = loop2 + 1;
					carbonfiber[loop2][loop1] = cx0.substring(0, ix0);
					cx0 = cx0.substring(ix0 + 5, cx0.length());
					//System.out.println(" " + carbonfiber[loop2][loop1] + " " + loop2 + " " + loop1 + " " + carbonfiber.length);

				}//if*********************************
				else{carbonfiber[loop2][loop1] = cx0; if(stop == 0){thisc2++;} stop = 1; break;}



			}//for*************************************
			//info

		}//for**************************************


		System.out.println("CSV File Has: " + thisc2 + " section(s) and: " + thisc3 + " row(s).");
		//System.out.println(carbonfiber[0][0]);
		//System.out.println(carbonfiber[0][1]);


	}//csv








//csvx***********************************************************************************************************************************************************************************
//csvx***********************************************************************************************************************************************************************************





//database***********************************************************************************************************************************************************************************
//database***********************************************************************************************************************************************************************************







//load****************************************************************************************************
//load****************************************************************************************************

	public void load_csv1xx(){

		ix0 = 0;
		loop_pass_1 = 0;

		carbon_load = carbonfiber;

		kcountxx = thisc3;
		kcountxx2 = thisc2;


		if(kcountxx < 3){System.out.println("Rebuild Database."); rebuild(); load_csv1xx();}

		System.out.println("   " + carbon_load[0].length);
		System.out.println("   " + carbon_load[0][thisc3 -1]);

		for(int xloop = 0; xloop < runs; xloop++){//******

			if(carbon_load[0][thisc3 -1].equals("*DBX" + Integer.toString(xloop) + "*")){ix0 = xloop; break;}
		
		}//for********************************************

		System.out.println("   " + ix0);
		websites = ix0;

		ix0 = -1;
		ix1 = -1;

		for(int sxloop = 0; sxloop < websites; sxloop++){//******

			loop_pass_1 = sxloop;

			for(int xloop = 0; xloop < thisc3; xloop++){//******

				if(carbon_load[0][xloop].equals("*DBX" + Integer.toString(sxloop) + "*")){ix0 = xloop;}
				if(carbon_load[0][xloop].equals("*DBX" + Integer.toString(sxloop + 1) + "*")){ix1 = xloop;}
			
			}//for


			System.out.println(sxloop + " " + ix0 + " " + ix1);

			array_copy0(carbon_load, (ix0 + 1), ix1); 


		}//for*************************************************





	}//csvxx*******************










//********************************************************************************


	public void array_copy0(String sspx[][], int x, int y){

		ix0x = y - x;
		ix1x = 0;
		String ssp[][] = new String[sspx.length][ix0x];


		for(int xloop = x; xloop < y; xloop++){//******
		for(int xloox = 0; xloox < sspx.length; xloox++){//******

			ssp[xloox][ix1x] = sspx[xloox][xloop];

		}//***************
		ix1x++;
		}//***************


		nm.carbon[loop_pass_1] = ssp;

	}//*****************************************************













//load****************************************************************************************************
//load****************************************************************************************************

	public void rebuild(){

		//rebuild_db ddx = new rebuild_db();

	}//***************************




	public void rebuild_db_xxr(){

		System.out.println("REBUILD DATABASE");
		nm.carbon = new String[6][nm.db_cc_number][1];

		for(int xloop1 = 0; xloop1 < 4; xloop1++){//************************

			nm.carbon[xloop1][0] [0] = new String("address_1");
			nm.carbon[xloop1][1] [0] = new String("address_2");
			nm.carbon[xloop1][2] [0] = new String("address_3");
			nm.carbon[xloop1][3] [0] = new String("address_4");
			nm.carbon[xloop1][4] [0] = new String("address_5");
			nm.carbon[xloop1][5] [0] = new String("buyer_id");
			nm.carbon[xloop1][6] [0] = new String("buyers_email");
			nm.carbon[xloop1][7] [0] = new String("buyers_first_name");
			nm.carbon[xloop1][8] [0] = new String("buyers_last_name");
			nm.carbon[xloop1][9] [0] = new String("buyers_notes");
			nm.carbon[xloop1][10][0] = new String("checkout_completed");
			nm.carbon[xloop1][11][0] = new String("currency");
			nm.carbon[xloop1][12][0] = new String("custom_1");
			nm.carbon[xloop1][13][0] = new String("custom_2");
			nm.carbon[xloop1][14][0] = new String("custom_3");
			nm.carbon[xloop1][15][0] = new String("custom_4");
			nm.carbon[xloop1][16][0] = new String("custom_5");
			nm.carbon[xloop1][17][0] = new String("custom_6");
			nm.carbon[xloop1][18][0] = new String("custom_7");
			nm.carbon[xloop1][19][0] = new String("custom_8");
			nm.carbon[xloop1][20][0] = new String("custom_9");
			nm.carbon[xloop1][21][0] = new String("custom_template");
			nm.carbon[xloop1][22][0] = new String("date_payment_cleared");
			nm.carbon[xloop1][23][0] = new String("date_payment_received");
			nm.carbon[xloop1][24][0] = new String("date_shipped");
			nm.carbon[xloop1][25][0] = new String("date_sold");
			nm.carbon[xloop1][26][0] = new String("ebay_item");
			nm.carbon[xloop1][27][0] = new String("final_value_fee");
			nm.carbon[xloop1][28][0] = new String("handling");
			nm.carbon[xloop1][29][0] = new String("hits");
			nm.carbon[xloop1][30][0] = new String("item_cost");
			nm.carbon[xloop1][31][0] = new String("item_description");
			nm.carbon[xloop1][32][0] = new String("item_id");
			nm.carbon[xloop1][33][0] = new String("item_price");
			nm.carbon[xloop1][34][0] = new String("item_weight");
			nm.carbon[xloop1][35][0] = new String("listing_id");
			nm.carbon[xloop1][36][0] = new String("notes");
			nm.carbon[xloop1][37][0] = new String("package_d");
			nm.carbon[xloop1][38][0] = new String("package_l");
			nm.carbon[xloop1][39][0] = new String("package_w");
			nm.carbon[xloop1][40][0] = new String("part_number");
			nm.carbon[xloop1][41][0] = new String("payment_type");
			nm.carbon[xloop1][42][0] = new String("paypal_fees");
			nm.carbon[xloop1][43][0] = new String("picture_1");
			nm.carbon[xloop1][44][0] = new String("quantity_sold");
			nm.carbon[xloop1][45][0] = new String("sale_id");
			nm.carbon[xloop1][46][0] = new String("shipping_company");


			nm.carbon[xloop1][47][0] = new String("site_id");
			nm.carbon[xloop1][48][0] = new String("source_of_sale");
			nm.carbon[xloop1][49][0] = new String("title");
			nm.carbon[xloop1][50][0] = new String("title_url");
			nm.carbon[xloop1][51][0] = new String("total_on_hand");
			nm.carbon[xloop1][52][0] = new String("tracking_number");
			nm.carbon[xloop1][53][0] = new String("transaction_id");
			nm.carbon[xloop1][54][0] = new String("transaction_info");
		
		}//for********************************************






		nm.carbon[4] = new String[nm.db_cc_number][29];

		for(int xloop0 = 0; xloop0 < 29; xloop0++){//************************
		for(int xloop1 = 0; xloop1 < nm.db_cc_number; xloop1++){//************************

			nm.carbon[4][xloop1][xloop0] = new String("!");
			nm.carbon[4][0][xloop0] = ("800");

		}//for
		}//for


		nm.carbon[5] = new String[nm.db_cc_number][10];

		for(int xloop0 = 0; xloop0 < 10; xloop0++){//************************
		for(int xloop1 = 0; xloop1 < nm.db_cc_number; xloop1++){//************************
	
			nm.carbon[5][xloop1][xloop0] = new String("*");
			nm.carbon[5][0][xloop0] = ("name " + xloop0);
			nm.carbon[5][5][xloop0] = ("no");

		}//for
		}//for



		//System.out.println("h " + nm.carbon[5][0].length);
		//System.out.println("x " + nm.carbon[5].length);

		dbx_saver dbx_save = new dbx_saver(file_open_1);



	}//db***********************************





}//last****************************************
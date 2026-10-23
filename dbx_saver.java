import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  







public class dbx_saver{//************************************************************************

int csv_passes_x = 17;

static int runx = 0;
static int runs2 = 400;
static int runs = 50000;

int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0; 
int ix4 = 0;

int ix1x = 0; 
int ix0x = 0;

int stop = 0;

String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");


File st1;
String[] CSVTEMP = new String[runs];
String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");
String carbon_load[][] = new String[0][0];




File file_open_0 = new File("ALCHEMIST_DBX2.CSV");
File file_open_1 = new File("ALCHEMIST_DBX.CSV");




dbx_saver(File f1){//****************************

	file_open_1 = f1;


	stop = 0;
	csv_int = 0;
	thisc3 = 0;


	save_csv_0xx();


}//csv_loader_x1********************************************************





//database***********************************************************************************************************************************************************************************
//database***********************************************************************************************************************************************************************************







	public void save_csv_0xx(){

		ix0 = 0;

		System.out.println("number of databases to save: " + nm.carbon.length);

		ix0 = ix0 + 1;

		for(int sloop0 = 0; sloop0 < nm.carbon.length; sloop0++){//*************************

			ix0 = ix0 + nm.carbon[sloop0][0].length;
			ix0 = ix0 + 1;

		}//for******************************************************************************


		ix1x = 0;

		carbon_load = new String[nm.carbon[0].length][ix0];



		for(int xloop1 = 0; xloop1 < nm.carbon[0].length; xloop1++){//******55

			carbon_load[xloop1][ix1x] = new String("*DBX0*");

		}//********
		ix1x++;



		for(int sloop0 = 0; sloop0 < nm.carbon.length; sloop0++){//*************************


			for(int xloop0 = 0; xloop0 < nm.carbon[sloop0][0].length; xloop0++){//******

				for(int xloop1 = 0; xloop1 < nm.carbon[sloop0].length; xloop1++){//******55

					carbon_load[xloop1][ix1x] = nm.carbon[sloop0][xloop1][xloop0];

				}//********

			ix1x++;
			}//********


			for(int xloop1 = 0; xloop1 < nm.carbon[0].length; xloop1++){//******55

				carbon_load[xloop1][ix1x] = new String("*DBX" + (sloop0 + 1) + "*");

			}//********

			ix1x++;

		}//for*************************************************************************************




		csv_saver1xx(carbon_load, file_open_1);

	}//csv









//database***********************************************************************************************************************************************************************************
//database***********************************************************************************************************************************************************************************
//database***********************************************************************************************************************************************************************************














	public void csv_saver1xx(String[][] sxx, File st1){//****************************


		stop = 0;
		csv_int = 0;
		thisc3 = 0;

		carbonfiber = new String[sxx.length][sxx[0].length];
		System.out.println("SAVE X: " + sxx.length);
		System.out.println("SAVE Y: " + sxx[0].length);


		for (int loop1 = 0; loop1 < sxx[0].length; loop1++){//*************************
		for (int loop2 = 0; loop2 < sxx.length; loop2++){//*************************

			carbonfiber[loop2][loop1] = new String("*!*");
			carbonfiber[loop2][loop1] = sxx[loop2][loop1];

		}//for
		}//for





		ix0 = carbonfiber.length;
		ix1 = carbonfiber[0].length;

		System.out.println("save DBX save");



		try {

	        BufferedWriter out = new BufferedWriter(new FileWriter(st1));

			for (int loop1 = 0; loop1 < ix1; loop1++){//****************************************


				for (int loop2 = 0; loop2 < ix0; loop2++){//*************************

					if(loop2 > 0){out.write("<*°*>");}

					System.out.println(loop2 + " " + carbonfiber[loop2][loop1]);

					out.write(carbonfiber[loop2][loop1]);

					//System.out.println("print " + carbonfiber[loop2][loop1]);
					//System.out.println("print " + ix0 + " " + ix1 + " " + loop1 + " " + loop2);

				}//for****************************************************************

				out.newLine();

			}//for*******************************************************************************
			

	        out.close();

	    }catch(IOException e){System.out.println("print fail.");}


	}//****************************
















}//last****************************************
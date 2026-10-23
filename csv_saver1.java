import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  







public class csv_saver1{//************************************************************************

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int stop = 0;

String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");


File st1;
//String[] CSVTEMP = new String[runs];
String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");




csv_saver1(String[][] sxx, File st1){//****************************

	stop = 0;
	csv_int = 0;
	thisc3 = 0;

	carbonfiber = sxx;

	ix0 = carbonfiber.length;
	ix1 = carbonfiber[0].length;

	//System.out.println("ix0 " + carbonfiber.length);
	//System.out.println("ix1 " + carbonfiber[0].length);

	//System.out.println(ix0);
	//System.out.println(ix1);


	try {

        BufferedWriter out = new BufferedWriter(new FileWriter(st1));

		for (int loop1 = 0; loop1 < ix1; loop1++){//****************************************


			for (int loop2 = 0; loop2 < ix0; loop2++){//*************************

				if(loop2 > 0){out.write(",");}

				System.out.println(loop2 + " " + carbonfiber[loop2][loop1]);

				out.write(carbonfiber[loop2][loop1]);

				//System.out.println("print " + carbonfiber[loop2][loop1]);
				//System.out.println("print " + ix0 + " " + ix1 + " " + loop1 + " " + loop2);

			}//for****************************************************************
			out.newLine();
			
		}//for*******************************************************************************
	

    	out.close();

    } catch (IOException e) {System.out.println("print fail.");}


}//csv_loader_x1********************************************************







}//last****************************************
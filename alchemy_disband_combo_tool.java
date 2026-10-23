import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;






public class alchemy_disband_combo_tool{



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

String[] delete_items_mark;
String[][] delete_items_memory;





	alchemy_disband_combo_tool(){//********************************************************************************************************
	


		System.out.println("");
		System.out.println("Start Scrips");


		disband_tool1();
		disband_tool2();



		System.out.println("");
		System.out.println("End Scrips");
		System.out.println("");


	}//pro_tools**************************************************************************************************************











	public void disband_tool1(){

		//disband quanitity
		ix0 = Integer.parseInt(nm.carbon[4][0][38]);
		ix1 = Integer.parseInt(nm.carbon[4][0][39]);
		ix3 = 0;


		delete_items_mark = new String[nm.carbon[0][0].length];

		delete_items_mark[0] = new String("0");




		for(int xloopx1 = 1; xloopx1 < nm.carbon[0][0].length; xloopx1++){//******

			delete_items_mark[xloopx1] = new String("0");

			if(nm.carbon[0][nm.part_number_xx][xloopx1].length() > 7){
			
				if(nm.carbon[0][nm.part_number_xx][xloopx1].substring(0, 7).equals("[COMBO]")){
			
					delete_items_mark[xloopx1] = ("1");



					for(int xloopx2 = 1; xloopx2 < nm.carbon[0][0].length; xloopx2++){//******************

						cx0 = nm.carbon[0][ix0][xloopx1];//combo part numbers
						cx1 = nm.carbon[0][ix1][xloopx1];



						if(nm.carbon[0][nm.part_number_xx][xloopx2].equals(cx0)){nm.carbon[0][nm.total_on_hand_xx][xloopx2] = Integer.toString( Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][xloopx1]) + Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][xloopx2]) );}
						else if(nm.carbon[0][nm.part_number_xx][xloopx2].equals(cx1)){nm.carbon[0][nm.total_on_hand_xx][xloopx2] = Integer.toString( Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][xloopx1]) + Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][xloopx2]) );}
						else{}//System.out.println("NO MATCH (" + cx0 + ")(" + cx1 + ")(" + nm.carbon[0][nm.part_number_xx][xloopx2]);

					}//***********************************************************************************


				}//if**************************************************************************

			}//*********************************************************

		}//************************************************************************

	}//************************1














	public void disband_tool2(){

		ix3 = 0;

		for(int xloopx1 = 0; xloopx1 < nm.carbon[0][0].length; xloopx1++){//******

			if(delete_items_mark[xloopx1].equals("0")){ix3++;}

		}//***********************************************************************

	

		ix4 = 0;

		delete_items_memory = new String[100][ix3];

		for(int xloopx1 = 0; xloopx1 < nm.carbon[0][0].length; xloopx1++){//******
		for(int xloopx2 = 0; xloopx2 < nm.carbon[0].length; xloopx2++){//******************

			if(ix4 <= (ix3 -1)){

				delete_items_memory[xloopx2][ix4] = new String("");

			}//*****************

			if(delete_items_mark[xloopx1].equals("0")){//************

				delete_items_memory[xloopx2][ix4] = nm.carbon[0][xloopx2][xloopx1];

			}//******************************************************


		}//***********************************************************************************
		if(delete_items_mark[xloopx1].equals("0")){ix4++;}
		}//************************************************************************


		nm.carbon[0] = delete_items_memory;


	}//************************2











}//last
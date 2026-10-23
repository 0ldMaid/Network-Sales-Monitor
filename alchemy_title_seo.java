import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;






public class alchemy_title_seo{



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






alchemy_title_seo(){//********************************************************************************************************
	
		System.out.println("");
		System.out.println("Start Scrips");


		tools1();
		tools2();


		System.out.println("");
		System.out.println("End Scrips");

		JOptionPane.showMessageDialog(null,"Title SEO Script complete.");

}//pro_tools**************************************************************************************************************






	public void tools1(){


		for (int loop1 = 1; loop1 < nm.carbon[0][0].length; loop1++){
	
			nm.carbon[0][nm.title_xx][loop1] = nm.carbon[0][nm.title_xx][loop1].toLowerCase();	

			nm.carbon[0][nm.title_xx][loop1] = nm.carbon[0][nm.title_xx][loop1].replace("  "," ");



		}//**********************************************************

	}//******************







	public void tools2(){


		for (int loop1 = 1; loop1 < nm.carbon[0][0].length; loop1++){
	


			if(nm.carbon[0][nm.title_xx][loop1].length() < 40){
				nm.carbon[0][nm.title_xx][loop1] = nm.carbon[0][nm.title_xx][loop1] + "";
			}//if**********************************************


			if(nm.carbon[0][nm.title_xx][loop1].length() < 50){
				nm.carbon[0][nm.title_xx][loop1] = nm.carbon[0][nm.title_xx][loop1] + "";
			}//if**********************************************


			if(nm.carbon[0][nm.title_xx][loop1].length() < 60){
				nm.carbon[0][nm.title_xx][loop1] = nm.carbon[0][nm.title_xx][loop1] + "";
			}//if**********************************************


			if(nm.carbon[0][nm.title_xx][loop1].length() < 70){
				nm.carbon[0][nm.title_xx][loop1] = nm.carbon[0][nm.title_xx][loop1] + " NEW!";
			}//if**********************************************



			nm.carbon[0][nm.title_xx][loop1] = nm.carbon[0][nm.title_xx][loop1].replace("  "," ");
	

		}//**********************************************************

	}//******************










}//last
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;
import java.net.*;





public class alchemy_pro_tools{



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






alchemy_pro_tools(){//********************************************************************************************************
	

		System.out.println("");
		System.out.println("Start Scrips");

		ebay_fees();

		System.out.println("");
		System.out.println("End Scrips");

		JOptionPane.showMessageDialog(null,"Pro Tools Script complete");


}//pro_tools**************************************************************************************************************










	public void ebay_fees(){




		for(int xloopx = 1; xloopx < nm.carbon[3][0].length; xloopx++){//*****************************	


			Float fxx1 = Float.parseFloat(nm.carbon[3][nm.item_price_xx][xloopx]);


			fxx1 = (float) (fxx1 * 0.10f);

			String cxx = Float.toString(fxx1);


			//test prices
			ix0 = cxx.indexOf(".");
	
			if(ix0 > -1){

				cx0 = cxx.substring(ix0, cxx.length());

				if(cx0.length() == 1){cxx = cxx + "00";}
				else if(cx0.length() == 2){cxx = cxx + "0";}
				else if(cx0.length() == 4){cxx = cxx.substring(0, cxx.length() -1);}
				else if(cx0.length() == 5){cxx = cxx.substring(0, cxx.length() -2);}
				else if(cx0.length() == 6){cxx = cxx.substring(0, cxx.length() -3);}
				else if(cx0.length() == 7){cxx = cxx.substring(0, cxx.length() -4);}
				else if(cx0.length() == 8){cxx = cxx.substring(0, cxx.length() -5);}
				else if(cx0.length() == 9){cxx = cxx.substring(0, cxx.length() -6);}
				else if(cx0.length() == 10){cxx = cxx.substring(0, cxx.length() -7);}
				else if(cx0.length() == 11){cxx = cxx.substring(0, cxx.length() -8);}

			}//**********




			nm.carbon[3][nm.final_value_fee_xx][xloopx] = cxx;


		}//*******************************************************************************************


	}//*********************









	public void replacecc(){



		for(int xloopx = 1; xloopx < nm.carbon[2][0].length; xloopx++){//*****************************	


			nm.carbon[2][nm.sale_status_xx][xloopx] = "Ready to ship";
			nm.carbon[2][nm.item_description_xx][xloopx] = "";


		}//*******************************************************************************************




	}//**********************









	public void tools_wiki(){



		for(int xloopx = 24422; xloopx < nm.carbon[0][0].length; xloopx++){//*****************************	



			try {


			    String data = URLEncoder.encode("brand", "UTF-8")       + "=" + URLEncoder.encode(nm.carbon[0][nm.part_number_xx][xloopx].replace("[","").replace("]",""), "UTF-8");


			    data += "&" + URLEncoder.encode("title", "UTF-8")       + "=" + URLEncoder.encode(nm.carbon[0][nm.title_xx][xloopx], "UTF-8");
			    data += "&" + URLEncoder.encode("price", "UTF-8")       + "=" + URLEncoder.encode(nm.carbon[0][nm.item_price_xx][xloopx], "UTF-8");
			    data += "&" + URLEncoder.encode("description", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[0][nm.item_description_xx][xloopx], "UTF-8");
			    data += "&" + URLEncoder.encode("pic1", "UTF-8")        + "=" + URLEncoder.encode(nm.carbon[0][nm.picture_1_xx][xloopx], "UTF-8");
			    data += "&" + URLEncoder.encode("itemcustom1", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[0][nm.custom_45_xx][xloopx], "UTF-8");




			    // Send data
			    URL url = new URL("http://www.alchemistwebshops.com/api_edit_product.php");
			    URLConnection conn = url.openConnection();
			    conn.setDoOutput(true);
			    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			    wr.write(data);
			    wr.flush();

			    // Get the response
			    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			    String line;
			    while ((line = rd.readLine()) != null){

			        cx0 = line;
					System.out.println(cx0);

			    }//************************************
			    wr.close();
			    rd.close();
			    //conn.close();



			}catch(Exception e) {System.out.println(e.getMessage()); System.out.println("URL falure."); JOptionPane.showMessageDialog(null,"ERROR");}



		}//*********************************************************************************************




	}//******************





















	public void tools3(){

		try {
        
        	BufferedWriter out = new BufferedWriter(new FileWriter("brands.csv"));

				for (int loop1 = 0; loop1 < nm.carbon[0][0].length; loop1++){//****************************************

					out.write(nm.carbon[0][nm.part_number_xx][loop1]);
					out.write(",");
					out.write(nm.carbon[0][nm.custom_5_xx][loop1]);

					out.newLine();

				}//for**************************************************************************************************
				

        out.close();

        } catch (IOException e) {System.out.println("print fail.");}



	}//******************









	public void tools2(){



		for(int xloopx = 1; xloopx < nm.carbon[0][0].length; xloopx++){//*****************************	
		for(int xloopy = 0; xloopy < nm.carbon[0].length; xloopy++){//*****************************	


			if(nm.carbon[0][xloopy][xloopx].contains("custom") && nm.carbon[0][xloopy][xloopx].length() < 10){nm.carbon[0][xloopy][xloopx] = "custom";}


		}//*****************************************************************************************
		}//*********************************************************************************************



	}//******************

















	public void tools1(){


		System.out.println("Tools 1");


		for(int xloopx = 1; xloopx < nm.carbon[0][0].length; xloopx++){//*****************************	

			cx0 = nm.carbon[0][nm.item_description_xx][xloopx];

			ix0 = cx0.indexOf("<ul>");

			if(ix0 > -1){
				
				cx1 = cx0.substring(ix0, cx0.length());

				System.out.println("working " + xloopx);


				cx1 = cx1.replace("<br />","</li><li>");

				cx1 = cx1.replace("<br>","</li><li>");

				cx1 = cx1.replace("<BR>","</li><li>");

				cx1 = cx1.replace("<li></li></ul>","</ul>");




				cx0 = cx0.substring(0, ix0) + cx1;


				nm.carbon[0][nm.item_description_xx][xloopx] = cx0;

			}//**********

		}//*********************************************************************************************


	}//******************







}//last
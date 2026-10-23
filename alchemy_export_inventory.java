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





public class alchemy_export_inventory{



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






alchemy_export_inventory(){//********************************************************************************************************

    System.out.println("");

    ix0 = Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][nm.what_item]);

    for(int loop1 = 0; loop1 < ix0; loop1++){//********************

        engine();

    }//************************************************************

    JOptionPane.showMessageDialog(null,"Exported.");

}//alchemist_export_inventory**********************************************************************************************************










	public void engine(){



	    // Construct data
	    try {

		    String data;

           	       data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(nm.carbon[4][0][60], "UTF-8");
    		data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[4][0][41], "UTF-8");
    		data += "&" + URLEncoder.encode("post_key", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[4][0][61], "UTF-8");

    		data += "&" + URLEncoder.encode("part_number", "UTF-8")       + "=" + URLEncoder.encode(nm.carbon[0][nm.part_number_xx][nm.what_item], "UTF-8");
    		data += "&" + URLEncoder.encode("part_price", "UTF-8")        + "=" + URLEncoder.encode(nm.carbon[0][nm.item_cost_xx][nm.what_item], "UTF-8");
    		data += "&" + URLEncoder.encode("part_payout", "UTF-8")       + "=" + URLEncoder.encode(nm.carbon[0][nm.item_price_xx][nm.what_item], "UTF-8");
    		data += "&" + URLEncoder.encode("part_picture", "UTF-8")      + "=" + URLEncoder.encode(nm.carbon[0][nm.picture_1_xx][nm.what_item].replace("[[url]]", ""), "UTF-8");


		    URL url;
		    OutputStreamWriter wr;
		    BufferedReader rd;
		    URLConnection conn;

    		// Send data
    		System.out.println("SEND TO " + nm.carbon[4][0][40]);
    		url = new URL(nm.carbon[4][0][40]);
    		conn = url.openConnection();
    		conn.setDoOutput(true);
    		wr = new OutputStreamWriter(conn.getOutputStream());
    		wr.write(data);
    		wr.flush();

    		// Get the response
    		rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;

   		    while ((line = rd.readLine()) != null) {

			    System.out.println(line);
                
    		}//*************************************

   		    wr.close();
    		rd.close();
	
        } catch (Exception e){System.out.println("URL falure.");}



	}//e*****************
















}//last
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





public class alchemy_update_warehouse_inventory{



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


String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;




alchemy_update_warehouse_inventory(int i){//********************************************************************************************************
	


	System.out.println("");
	System.out.println("Start");



    try {//*******************************************************


               data = URLEncoder.encode("quantity", "UTF-8")  + "=" + URLEncoder.encode( Integer.toString(nm.carbon[0][0].length -1), "UTF-8");
        data += "&" + URLEncoder.encode("user_id", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[4][0][60], "UTF-8");
        data += "&" + URLEncoder.encode("pass_id", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[4][0][41], "UTF-8");
        data += "&" + URLEncoder.encode("key_id", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[4][0][61], "UTF-8");


        data += "&" + URLEncoder.encode("part_number", "UTF-8")       + "=" + URLEncoder.encode(nm.carbon[0][nm.part_number_xx][i].replace("'",""), "UTF-8");
        data += "&" + URLEncoder.encode("item_id", "UTF-8")           + "=" + URLEncoder.encode(nm.carbon[0][nm.item_id_xx][i], "UTF-8");
        data += "&" + URLEncoder.encode("on_hand", "UTF-8")           + "=" + URLEncoder.encode(nm.carbon[0][nm.total_on_hand_xx][i], "UTF-8");
        data += "&" + URLEncoder.encode("order_min", "UTF-8")         + "=" + URLEncoder.encode(nm.carbon[0][ Integer.parseInt(nm.carbon[4][0][73]) ][i], "UTF-8");
        data += "&" + URLEncoder.encode("order_max", "UTF-8")         + "=" + URLEncoder.encode(nm.carbon[0][ Integer.parseInt(nm.carbon[4][0][74]) ][i], "UTF-8");
        data += "&" + URLEncoder.encode("picture", "UTF-8")           + "=" + URLEncoder.encode(nm.carbon[0][nm.picture_1_xx][i], "UTF-8");



        // Send data
        System.out.println("post info to: " + nm.carbon[4][0][40] + "dbx_import_inventory.php");
        url = new URL(nm.carbon[4][0][40] + "dbx_import_inventory.php");
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
            nm.pass_com = line;

        }
        wr.close();
        rd.close();

    } catch (Exception e){System.out.println("URL falure. UPDATE WAREHOUSE.");}





	System.out.println("");
	System.out.println("End");



}//pro_tools**************************************************************************************************************







}//last
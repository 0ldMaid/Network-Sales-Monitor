import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;

import java.awt.image.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;

import java.util.ArrayList;
import java.util.Properties;

import java.util.*;






public class jdb_loader_monitor_stats extends JFrame{


// the default framework is embedded
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";



Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 143;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

static int error_code = 0;
int bytesRead = 0;

String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

Label infox0 = new Label("", Label.RIGHT);
Label infox1 = new Label("Starting", Label.CENTER);
Label infox2 = new Label("Loading...", Label.LEFT);

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int amazon_items = 0;//number of new items to submit. 
int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;//don't use
int stop = 0;
int post_number = 1;
int what_item_here = 0;

Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
static String cx2 = new String("");


File st1;


String[][] carbonfiber;
String submit_x = new String("");
String xlinex = new String("");
String blank = new String("");


String ssxs;
String ssxu;
String ssxp;







    jdb_loader_monitor_stats(){//**************************************************************************





		try{




			//System.out.println(System.currentTimeMillis());
			//jdb_driver.s.execute("UPDATE monitor SET buyers_first_name='1465583697174' WHERE buyer_id='0'");
			//jdb_driver.s.execute("UPDATE monitor SET buyers_first_name='1465583697174' WHERE buyer_id='1'");
			//jdb_driver.s.execute("UPDATE monitor SET buyers_first_name='1465583697174' WHERE buyer_id='3'");




			Float item_cost = (float) 0.00;
			Float item_price = (float) 0.00;
			int quantity_sold = 0;
			Float sales_tax = (float) 0.00;
			Float shipping_out = (float) 0.00;


            //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			//get all items
			jdb_driver.rs = jdb_driver.s.executeQuery("SELECT item_price FROM sold ORDER BY xd ASC");
			jdb_driver.rs.last();
	    	int rowCount = jdb_driver.rs.getRow();
	    	System.out.println("rowCount " + rowCount);


	    	//get the items from this site
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT item_cost, item_price, quantity_sold, sales_tax, shipping_out, sale_status FROM sold WHERE transaction_id='" + nm.carbon[1][nm.buyer_id_xx][nm.what_item] + "' ORDER BY date_sold DESC");

	    	ix0 = 0;
	    	ix1 = 0;
	    	ix2 = 0;
	    	while(jdb_driver.rs.next()){


	    		System.out.println(jdb_driver.rs.getString(1));
				System.out.println(jdb_driver.rs.getString(2));
				System.out.println(jdb_driver.rs.getString(3));
				System.out.println(jdb_driver.rs.getString(4));
				System.out.println(jdb_driver.rs.getString(5));

				if(!jdb_driver.rs.getString(6).equals("Error") || !jdb_driver.rs.getString(6).equals("Refunded")){

					item_cost = item_cost + jdb_driver.rs.getFloat(1);
					item_price = item_price + jdb_driver.rs.getFloat(2);
					sales_tax = sales_tax + jdb_driver.rs.getFloat(4);
					shipping_out = shipping_out + jdb_driver.rs.getFloat(5);

				}//*********************************************

	    		if(jdb_driver.rs.getString(6).equals("Refunded")){ix1++;}	
				else if(jdb_driver.rs.getString(6).equals("Error")){ix2++;}
				else{ix0++;}


	    	}//while

			Float total_cost_sold = (float) item_cost + sales_tax + shipping_out;

			nm.carbon[1][nm.sold_count_mm][nm.what_item] = Integer.toString(ix0 + ix1 + ix2);


			double amount1 = (double) item_price;
	   		Locale locale1 = new Locale("en", "US");      
	   		Currency currency1 = Currency.getInstance(locale1);
	   		NumberFormat currencyFormatter1 = NumberFormat.getCurrencyInstance(locale1);
	   		System.out.println(currencyFormatter1.format(amount1));

			nm.carbon[1][nm.sold_sales_mm][nm.what_item] = currencyFormatter1.format(amount1).toString().replace("$","");
			nm.carbon[1][nm.sold_costs_mm][nm.what_item] = Float.toString(total_cost_sold);

			if(rowCount > 0){nm.carbon[1][nm.sold_perc_mm][nm.what_item] = Float.toString((ix0 * 100) / rowCount);}
			else{nm.carbon[1][nm.sold_perc_mm][nm.what_item] = "0";}


			double amount3 = (double) item_price - total_cost_sold;
	   		Locale locale3 = new Locale("en", "US");      
	   		Currency currency3 = Currency.getInstance(locale3);
	   		NumberFormat currencyFormatter3 = NumberFormat.getCurrencyInstance(locale3);
	   		System.out.println(currencyFormatter3.format(amount3));

			nm.carbon[1][nm.sold_profit_mm][nm.what_item] = currencyFormatter3.format(amount3).toString().replace("$","");
			nm.carbon[1][nm.sold_rank_mm][nm.what_item] = Integer.toString(ix0 + 1);








           	//load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			//get all items
			jdb_driver.rs = jdb_driver.s.executeQuery("SELECT item_price FROM archived ORDER BY xd ASC");
			jdb_driver.rs.last();
	    	int rowCount2 = jdb_driver.rs.getRow();



            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT item_cost, item_price, quantity_sold, sales_tax, shipping_out, sale_status FROM archived WHERE transaction_id='" + nm.carbon[1][nm.buyer_id_xx][nm.what_item] + "' ORDER BY date_sold DESC");

	    	ix0 = 0;
	    	ix1 = 0;
	    	ix2 = 0;
	    	while(jdb_driver.rs.next()){


	    		System.out.println(jdb_driver.rs.getString(1));
				System.out.println(jdb_driver.rs.getString(2));
				System.out.println(jdb_driver.rs.getString(3));
				System.out.println(jdb_driver.rs.getString(4));
				System.out.println(jdb_driver.rs.getString(5));

				if(!jdb_driver.rs.getString(6).equals("Error") || !jdb_driver.rs.getString(6).equals("Refunded")){

					item_cost = item_cost + jdb_driver.rs.getFloat(1);
					item_price = item_price + jdb_driver.rs.getFloat(2);
					sales_tax = sales_tax + jdb_driver.rs.getFloat(4);
					shipping_out = shipping_out + jdb_driver.rs.getFloat(5);

				}//*********************************************

	    		if(jdb_driver.rs.getString(6).equals("Refunded")){ix1++;}	
				else if(jdb_driver.rs.getString(6).equals("Error")){ix2++;}
				else{ix0++;}


	    	}//while

	    	Float total_cost_archive = (float) item_cost + sales_tax + shipping_out;
 
			nm.carbon[1][nm.archive_count_mm][nm.what_item] = Integer.toString(ix0 + ix1 + ix2);


			double amount4 = (double) item_price;
	   		Locale locale4 = new Locale("en", "US");      
	   		Currency currency4 = Currency.getInstance(locale4);
	   		NumberFormat currencyFormatter4 = NumberFormat.getCurrencyInstance(locale4);
	   		System.out.println(currencyFormatter4.format(amount4));

			nm.carbon[1][nm.archive_sales_mm][nm.what_item] = currencyFormatter4.format(amount4).toString().replace("$","");
			nm.carbon[1][nm.archive_costs_mm][nm.what_item] = Float.toString(total_cost_archive);

			if(rowCount2 > 0){nm.carbon[1][nm.archive_perc_mm][nm.what_item] = Float.toString((ix0 * 100) / rowCount2);}
			else{nm.carbon[1][nm.archive_perc_mm][nm.what_item] = "0";}


			double amount6 = (double) item_price - total_cost_archive;
	   		Locale locale6 = new Locale("en", "US");      
	   		Currency currency6 = Currency.getInstance(locale6);
	   		NumberFormat currencyFormatter6 = NumberFormat.getCurrencyInstance(locale6);
	   		System.out.println(currencyFormatter6.format(amount6));

			nm.carbon[1][nm.archive_profit_mm][nm.what_item] = currencyFormatter6.format(amount6).toString().replace("$","");
			nm.carbon[1][nm.archive_rank_mm][nm.what_item] = Integer.toString(ix0 + 1);


            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


        }catch(Exception e){e.printStackTrace();}


	//pullThePlug();


	}//load






    public void pullThePlug() {

    	nm.firex = 1;

    	System.out.println("PULL THE PLUG");

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull





}//last
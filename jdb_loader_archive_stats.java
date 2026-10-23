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




public class jdb_loader_archive_stats {


// the default framework is embedded
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";




    jdb_loader_archive_stats(){//**************************************************************************



		try{


			
			int ix0 = 0;
			int ix1 = 0; 
			int ix2 = 0;


			Float item_cost = (float) 0.00;
			Float item_price = (float) 0.00;
			int quantity_sold = 0;
			Float sales_tax = (float) 0.00;
			Float shipping_out = (float) 0.00;



            //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//jdb_driver.s.setMaxRows(nm.load_limit); 
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT item_cost, item_price, quantity_sold, sales_tax, shipping_out, sale_status FROM archived ORDER BY date_sold DESC");

	    	ix0 = 0;
	    	ix1 = 0;
	    	ix2 = 0;
	    	while (jdb_driver.rs.next()) {


	    		System.out.println(jdb_driver.rs.getString(1));
				System.out.println(jdb_driver.rs.getString(2));
				System.out.println(jdb_driver.rs.getString(3));
				System.out.println(jdb_driver.rs.getString(4));
				System.out.println(jdb_driver.rs.getString(5));

				if (!jdb_driver.rs.getString(6).equals("Error")) {

					item_cost = item_cost + jdb_driver.rs.getFloat(1);
					item_price = item_price + jdb_driver.rs.getFloat(2);
					sales_tax = sales_tax + jdb_driver.rs.getFloat(4);
					shipping_out = shipping_out + jdb_driver.rs.getFloat(5);

				}//*********************************************

	    		if (jdb_driver.rs.getString(6).equals("Refunded")) {ix1++;}	
				else if (jdb_driver.rs.getString(6).equals("Error")) {ix2++;}
				else {ix0++;}


	    	}//while

	    	nm.carbon[4][0][87] = Float.toString(item_cost);
			nm.carbon[4][0][88] = Float.toString(item_price);
			nm.carbon[4][0][89] = Float.toString(sales_tax);
			nm.carbon[4][0][90] = Float.toString(shipping_out);

			nm.carbon[4][0][91] = Integer.toString(ix0);
			nm.carbon[4][0][92] = Integer.toString(ix1);
			nm.carbon[4][0][93] = Integer.toString(ix2);
			nm.carbon[4][0][94] = Integer.toString(ix0 + ix1 + ix2);


            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


        } catch (Exception e) {e.printStackTrace();}



	}//load









}//last
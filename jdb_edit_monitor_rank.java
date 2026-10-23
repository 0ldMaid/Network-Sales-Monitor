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






public class jdb_edit_monitor_rank{


// the default framework is embedded
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";



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









    jdb_edit_monitor_rank(){//**************************************************************************





		try{




			//System.out.println(System.currentTimeMillis());
			//jdb_driver.s.execute("UPDATE monitor SET buyers_first_name='1465583697174' WHERE buyer_id='0'");
			//jdb_driver.s.execute("UPDATE monitor SET buyers_first_name='1465583697174' WHERE buyer_id='1'");
			//jdb_driver.s.execute("UPDATE monitor SET buyers_first_name='1465583697174' WHERE buyer_id='3'");



			System.out.println("DB STRING > " + nm.db_string[nm.archive_profit_mm]);

			//sort monitor items
			jdb_driver.rs = jdb_driver.s.executeQuery("SELECT " + nm.db_string[nm.sold_profit_mm] + ", transaction_info FROM monitor ORDER BY " + nm.db_string[nm.sold_profit_mm] + " DESC");

			int ix0 = 1;
			while(jdb_driver.rs.next()){

				System.out.println("> " + jdb_driver.rs.getString(1));

				System.out.println("UPDATE monitor SET " + nm.db_string[nm.sold_rank_mm] + "='" + Integer.toString(ix0) + "' WHERE transaction_info='" + jdb_driver.rs.getString(2) + "'");

				jdb_driver.s2.execute("UPDATE monitor SET " + nm.db_string[nm.sold_rank_mm] + "='" + Integer.toString(ix0) + "' WHERE transaction_info='" + jdb_driver.rs.getString(2) + "'");



				ix0++;

			}//*************************






			System.out.println("DB STRING > " + nm.db_string[nm.archive_profit_mm]);

			//sort monitor items
			jdb_driver.rs = jdb_driver.s.executeQuery("SELECT " + nm.db_string[nm.archive_profit_mm] + ", transaction_info FROM monitor ORDER BY " + nm.db_string[nm.archive_profit_mm] + " DESC");

			int ix1 = 1;
			while(jdb_driver.rs.next()){

				System.out.println("> " + jdb_driver.rs.getString(1));

				System.out.println("UPDATE monitor SET " + nm.db_string[nm.archive_rank_mm] + "='" + Integer.toString(ix1) + "' WHERE transaction_info='" + jdb_driver.rs.getString(2) + "'");

				jdb_driver.s2.execute("UPDATE monitor SET " + nm.db_string[nm.archive_rank_mm] + "='" + Integer.toString(ix1) + "' WHERE transaction_info='" + jdb_driver.rs.getString(2) + "'");

				

				ix1++;

			}//*************************





            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


        }catch(Exception e){e.printStackTrace();}





	}//load





}//last
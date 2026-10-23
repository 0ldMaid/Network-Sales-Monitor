import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import java.util.Timer;
import java.util.TimerTask;



public class jdb_loader_settings extends JFrame{

/* the default framework is embedded*/
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";




jdb_loader_settings(){//*******************************


	buildx();


}//load************************************************





	public void buildx() {



        try {


        	int ix0 = 0;

	    	nm.carbon = new String[7][1][1];




            CallableStatement cs = jdb_driver.conn.prepareCall("CALL SYSCS_UTIL.SYSCS_COMPRESS_TABLE(?, ?, ?)");

            cs = jdb_driver.conn.prepareCall("CALL SYSCS_UTIL.SYSCS_COMPRESS_TABLE(?, ?, ?)");
            cs.setString(1, "APP");
            cs.setString(2, "LISTINGS");
            cs.setShort(3, (short) 1);
            cs.execute();

            cs.setString(1, "APP");
            cs.setString(2, "MONITOR");
            cs.setShort(3, (short) 1);
            cs.execute();

            cs.setString(1, "APP");
            cs.setString(2, "SOLD");
            cs.setShort(3, (short) 1);
            cs.execute();

            cs.setString(1, "APP");
            cs.setString(2, "ARCHIVED");
            cs.setShort(3, (short) 1);
            cs.execute();

            //cs.setString(1, "APP");
            //cs.setString(2, "SETTINGS");
            //cs.setShort(3, (short) 1);
            //cs.execute();

            cs.setString(1, "APP");
            cs.setString(2, "CONNECTIONS");
            cs.setShort(3, (short) 1);
            cs.execute();

            cs.setString(1, "APP");
            cs.setString(2, "SETTINGS_DISPLAY");
            cs.setShort(3, (short) 1);
            cs.execute();




			//infox2.setText(spacer_0 + "Load Database List");
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT databases FROM select_database ORDER BY databases");

			jdb_driver.rs.last();
	    	int rowCount = jdb_driver.rs.getRow();
	    	nm.jdb_load_list = new String[rowCount];

			jdb_driver.rs.beforeFirst();

	    	while (jdb_driver.rs.next()) {

	    		nm.jdb_load_list[ix0] = new String(jdb_driver.rs.getString(1));
	    		System.out.println(nm.jdb_load_list[ix0]);

	    		ix0++;

	    	}//while




			//infox2.setText(spacer_0 + "Load Sale Ids");
			System.out.println("Load Settings.");
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT ids FROM archived_sales_ids ORDER BY ids");

	 		jdb_driver.rs.last();
	    	int rowCount2 = jdb_driver.rs.getRow();
	    	nm.jdb_load_sales_ids = new String[rowCount2];

			jdb_driver.rs.beforeFirst();

			ix0 = 0;
	    	while (jdb_driver.rs.next()) {

	    		nm.jdb_load_sales_ids[ix0] = new String(jdb_driver.rs.getString(1));
	    		//System.out.println("LOADER " + nm.jdb_load_sales_ids[ix0]);

	    		ix0++;

	    	}//while








			//infox2.setText(spacer_0 + "Load Monitor database");
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //jdb_driver.rs = jdb_driver.s.executeQuery("SELECT address_1, address_2, address_3, address_4, address_5, address_6, buyer_id, buyers_email, buyers_first_name, buyers_last_name, buyers_notes, buyers_phone, currency, custom_1, custom_2, custom_3, custom_4, custom_5, custom_6, custom_7, custom_8, custom_9, custom_10, custom_11, custom_12, custom_13, custom_14, custom_15, custom_16, custom_17, custom_18, custom_19, custom_20, custom_21, custom_22, custom_23, custom_24, custom_25, custom_26, custom_27, custom_28, custom_29, custom_30, custom_31, custom_32, custom_33, custom_34, custom_35, custom_36, custom_37, custom_38, custom_39, custom_40, custom_41, custom_42, custom_43, custom_44, custom_45, custom_46, custom_template, date_last_modified, date_payment_received, date_shipped, date_sold, ebay_item, final_value_fee, handling, hits, item_cost, item_description, item_id, item_price, item_weight, listing_fees, listing_id, notes, package_d, package_l, package_w, part_number, payment_type, paypal_fees, picture_1, quantity_sold, sale_id, sale_status, sales_tax, shipping_company, shipping_in, shipping_out, site_id, site_url, source_of_sale, title, title_url, total_on_hand, total_sale_amount, tracking_number, transaction_id, transaction_info FROM monitor WHERE buyers_email='yes' ORDER BY buyer_id");
			jdb_driver.rs = jdb_driver.s.executeQuery("SELECT set001, set002, set003, set004, set005, set006, set007, set008, set009, set010, set011, set012, set013, set014, set015, set016, set017, set018, set019, set020, set021, set022, set023, set024, set025, set026, set027, set028, set029, set030, set031, set032, set033, set034, set035, set036, set037, set038, set039, set040, set041, set042, set043, set044, set045, set046, set047, set048, set049, set050, set051, set052, set053, set054, set055, set056, set057, set058, set059, set060, set061, set062, set063, set064, set065, set066, set067, set068, set069, set070, set071, set072, set073, set074, set075, set076, set077, set078, set079, set080, set081, set082, set083, set084, set085, set086, set087, set088, set089, set090, set091, set092, set093, set094, set095, set096, set097, set098, set099, set100 FROM monitor WHERE set008='yes' ORDER BY set007");


	 		jdb_driver.rs.last();
	    	int rowCount3 = jdb_driver.rs.getRow();
	    	nm.carbon[1] = new String[100][rowCount3];

			jdb_driver.rs.beforeFirst();

	    	ix0 = 0;
	    	while (jdb_driver.rs.next()) {

	    		System.out.println("JDB " + jdb_driver.rs.getString(1));
				System.out.println("JDB " + jdb_driver.rs.getString(8));

		   		nm.carbon[1][0][ix0] = new String(jdb_driver.rs.getString(1));
		   		nm.carbon[1][1][ix0] = new String(jdb_driver.rs.getString(2));
		    	nm.carbon[1][2][ix0] = new String(jdb_driver.rs.getString(3));
		    	nm.carbon[1][3][ix0] = new String(jdb_driver.rs.getString(4));
		    	nm.carbon[1][4][ix0] = new String(jdb_driver.rs.getString(5));
		    	nm.carbon[1][5][ix0] = new String(jdb_driver.rs.getString(6));
		    	nm.carbon[1][6][ix0] = new String(jdb_driver.rs.getString(7));
		    	nm.carbon[1][7][ix0] = new String(jdb_driver.rs.getString(8));
		    	nm.carbon[1][8][ix0] = new String(jdb_driver.rs.getString(9));
		    	nm.carbon[1][9][ix0] = new String(jdb_driver.rs.getString(10));
		    	nm.carbon[1][10][ix0] = new String(jdb_driver.rs.getString(11));
		    	nm.carbon[1][11][ix0] = new String(jdb_driver.rs.getString(12));
		    	nm.carbon[1][12][ix0] = new String(jdb_driver.rs.getString(13));
		    	nm.carbon[1][13][ix0] = new String(jdb_driver.rs.getString(14));
		    	nm.carbon[1][14][ix0] = new String(jdb_driver.rs.getString(15));
		    	nm.carbon[1][15][ix0] = new String(jdb_driver.rs.getString(16));
		    	nm.carbon[1][16][ix0] = new String(jdb_driver.rs.getString(17));
		    	nm.carbon[1][17][ix0] = new String(jdb_driver.rs.getString(18));
		    	nm.carbon[1][18][ix0] = new String(jdb_driver.rs.getString(19));
		    	nm.carbon[1][19][ix0] = new String(jdb_driver.rs.getString(20));
		   		nm.carbon[1][20][ix0] = new String(jdb_driver.rs.getString(21));
		    	nm.carbon[1][21][ix0] = new String(jdb_driver.rs.getString(22));
		    	nm.carbon[1][22][ix0] = new String(jdb_driver.rs.getString(23));
		    	nm.carbon[1][23][ix0] = new String(jdb_driver.rs.getString(24));
		    	nm.carbon[1][24][ix0] = new String(jdb_driver.rs.getString(25));
		    	nm.carbon[1][25][ix0] = new String(jdb_driver.rs.getString(26));
		    	nm.carbon[1][26][ix0] = new String(jdb_driver.rs.getString(27));
		    	nm.carbon[1][27][ix0] = new String(jdb_driver.rs.getString(28));
		    	nm.carbon[1][28][ix0] = new String(jdb_driver.rs.getString(29));
		    	nm.carbon[1][29][ix0] = new String(jdb_driver.rs.getString(30));
		    	nm.carbon[1][30][ix0] = new String(jdb_driver.rs.getString(31));
		    	nm.carbon[1][31][ix0] = new String(jdb_driver.rs.getString(32));
		    	nm.carbon[1][32][ix0] = new String(jdb_driver.rs.getString(33));
		    	nm.carbon[1][33][ix0] = new String(jdb_driver.rs.getString(34));
		   		nm.carbon[1][34][ix0] = new String(jdb_driver.rs.getString(35));
		    	nm.carbon[1][35][ix0] = new String(jdb_driver.rs.getString(36));
		    	nm.carbon[1][36][ix0] = new String(jdb_driver.rs.getString(37));
		    	nm.carbon[1][37][ix0] = new String(jdb_driver.rs.getString(38));
		    	nm.carbon[1][38][ix0] = new String(jdb_driver.rs.getString(39));
		    	nm.carbon[1][39][ix0] = new String(jdb_driver.rs.getString(40));
		    	nm.carbon[1][40][ix0] = new String(jdb_driver.rs.getString(41));
		    	nm.carbon[1][41][ix0] = new String(jdb_driver.rs.getString(42));
		    	nm.carbon[1][42][ix0] = new String(jdb_driver.rs.getString(43));
		    	nm.carbon[1][43][ix0] = new String(jdb_driver.rs.getString(44));
		    	nm.carbon[1][44][ix0] = new String(jdb_driver.rs.getString(45));
		    	nm.carbon[1][45][ix0] = new String(jdb_driver.rs.getString(46));
		    	nm.carbon[1][46][ix0] = new String(jdb_driver.rs.getString(47));
		    	nm.carbon[1][47][ix0] = new String(jdb_driver.rs.getString(48));
		   		nm.carbon[1][48][ix0] = new String(jdb_driver.rs.getString(49));
		    	nm.carbon[1][49][ix0] = new String(jdb_driver.rs.getString(50));	    
	           	nm.carbon[1][50][ix0] = new String(jdb_driver.rs.getString(51));
		    	nm.carbon[1][51][ix0] = new String(jdb_driver.rs.getString(52));
		    	nm.carbon[1][52][ix0] = new String(jdb_driver.rs.getString(53));
		    	nm.carbon[1][53][ix0] = new String(jdb_driver.rs.getString(54));
		    	nm.carbon[1][54][ix0] = new String(jdb_driver.rs.getString(55));
		    	nm.carbon[1][55][ix0] = new String(jdb_driver.rs.getString(56));
		    	nm.carbon[1][56][ix0] = new String(jdb_driver.rs.getString(57));
		    	nm.carbon[1][57][ix0] = new String(jdb_driver.rs.getString(58));
		    	nm.carbon[1][58][ix0] = new String(jdb_driver.rs.getString(59));
		    	nm.carbon[1][59][ix0] = new String(jdb_driver.rs.getString(60));
		    	nm.carbon[1][60][ix0] = new String(jdb_driver.rs.getString(61));
		    	nm.carbon[1][61][ix0] = new String(jdb_driver.rs.getString(62));
		   		nm.carbon[1][62][ix0] = new String(jdb_driver.rs.getString(63));
		    	nm.carbon[1][63][ix0] = new String(jdb_driver.rs.getString(64));
		    	nm.carbon[1][64][ix0] = new String(jdb_driver.rs.getString(65));
		    	nm.carbon[1][65][ix0] = new String(jdb_driver.rs.getString(66));
		    	nm.carbon[1][66][ix0] = new String(jdb_driver.rs.getString(67));
		    	nm.carbon[1][67][ix0] = new String(jdb_driver.rs.getString(68));
		    	nm.carbon[1][68][ix0] = new String(jdb_driver.rs.getString(69));
		   		nm.carbon[1][69][ix0] = new String(jdb_driver.rs.getString(70));
		    	nm.carbon[1][70][ix0] = new String(jdb_driver.rs.getString(71));
		    	nm.carbon[1][71][ix0] = new String(jdb_driver.rs.getString(72));
		   		nm.carbon[1][72][ix0] = new String(jdb_driver.rs.getString(73));
		    	nm.carbon[1][73][ix0] = new String(jdb_driver.rs.getString(74));
		    	nm.carbon[1][74][ix0] = new String(jdb_driver.rs.getString(75));	    
	           	nm.carbon[1][75][ix0] = new String(jdb_driver.rs.getString(76));
		    	nm.carbon[1][76][ix0] = new String(jdb_driver.rs.getString(77));
		    	nm.carbon[1][77][ix0] = new String(jdb_driver.rs.getString(78));
		    	nm.carbon[1][78][ix0] = new String(jdb_driver.rs.getString(79));
		    	nm.carbon[1][79][ix0] = new String(jdb_driver.rs.getString(80));
		    	nm.carbon[1][80][ix0] = new String(jdb_driver.rs.getString(81));
		    	nm.carbon[1][81][ix0] = new String(jdb_driver.rs.getString(82));
		    	nm.carbon[1][82][ix0] = new String(jdb_driver.rs.getString(83));
		    	nm.carbon[1][83][ix0] = new String(jdb_driver.rs.getString(84));
		    	nm.carbon[1][84][ix0] = new String(jdb_driver.rs.getString(85));
		    	nm.carbon[1][85][ix0] = new String(jdb_driver.rs.getString(86));
		    	nm.carbon[1][86][ix0] = new String(jdb_driver.rs.getString(87));
		    	nm.carbon[1][87][ix0] = new String(jdb_driver.rs.getString(88));
		    	nm.carbon[1][88][ix0] = new String(jdb_driver.rs.getString(89));
		    	nm.carbon[1][89][ix0] = new String(jdb_driver.rs.getString(90));
		    	nm.carbon[1][90][ix0] = new String(jdb_driver.rs.getString(91));
		   		nm.carbon[1][91][ix0] = new String(jdb_driver.rs.getString(92));
		    	nm.carbon[1][92][ix0] = new String(jdb_driver.rs.getString(93));
		    	nm.carbon[1][93][ix0] = new String(jdb_driver.rs.getString(94));
		    	nm.carbon[1][94][ix0] = new String(jdb_driver.rs.getString(95));
		    	nm.carbon[1][95][ix0] = new String(jdb_driver.rs.getString(96));
		    	nm.carbon[1][96][ix0] = new String(jdb_driver.rs.getString(97));
		    	nm.carbon[1][97][ix0] = new String(jdb_driver.rs.getString(98));
		    	nm.carbon[1][98][ix0] = new String(jdb_driver.rs.getString(99));
		    	nm.carbon[1][99][ix0] = new String(jdb_driver.rs.getString(100));


		    	ix0++;

	    	}//while







			//infox2.setText(spacer_0 + "Test Sold database");
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           	jdb_driver.rs = jdb_driver.s.executeQuery("SELECT xd FROM listings");

	 		jdb_driver.rs.last();
	    	nm.db_00_size = jdb_driver.rs.getRow();





			//infox2.setText(spacer_0 + "Test Sold database");
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           	jdb_driver.rs = jdb_driver.s.executeQuery("SELECT xd FROM sold");

	 		jdb_driver.rs.last();
	    	nm.db_02_size = jdb_driver.rs.getRow();





			//infox2.setText(spacer_0 + "Test Archive database");
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           	jdb_driver.rs = jdb_driver.s.executeQuery("SELECT xd FROM archived");

	 		jdb_driver.rs.last();
	    	nm.db_03_size = jdb_driver.rs.getRow();








	    	nm.carbon[4] = new String[1][nm.db_ss_number];

			//infox2.setText(spacer_0 + "Load Settings database");
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT settings_json FROM settings ORDER BY xd");

			jdb_driver.rs.next();
	    	String buffer3 = new String(jdb_driver.rs.getString(1));

			JSONParser parserx = new JSONParser();
			Object objx = parserx.parse(buffer3);
			JSONObject jsonObjectx = (JSONObject) objx;

			for (int xloop = 0; xloop < nm.db_ss_number; xloop++) {//******

				nm.carbon[4][0][xloop] = (String) jsonObjectx.get(Integer.toString(xloop));

			}//for*********************************************************








			//infox2.setText(spacer_0 + "Load Connections database");
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           	jdb_driver.rs = jdb_driver.s.executeQuery("SELECT con001, con002, con003, con004, con005, con006, con007, con008, con009, con010, con011, con012, con013, con014, con015, con016, con017, con018, con019, con020, con021, con022, con023, con024, con025, con026, con027, con028, con029, con030, con031, con032, con033, con034, con035, con036, con037, con038, con039, con040, con041, con042, con043, con044, con045, con046, con047, con048, con049, con050, con051, con052, con053, con054, con055, con056, con057, con058, con059, con060, con061, con062, con063, con064, con065, con066, con067, con068, con069, con070, con071, con072, con073, con074, con075, con076, con077, con078, con079, con080, con081, con082, con083, con084, con085, con086, con087, con088, con089, con090, con091, con092, con093, con094, con095, con096, con097, con098, con099, con100 FROM connections ORDER BY con009");

	    	System.out.println("Got List");

	 		jdb_driver.rs.last();
	    	int rowCount6 = jdb_driver.rs.getRow();
	    	nm.carbon[5] = new String[nm.db_cx_number][rowCount6];

			jdb_driver.rs.beforeFirst();

	    	ix0 = 0;
	    	while (jdb_driver.rs.next()) {

	    		//System.out.println("while working");

	    		//System.out.println(rs.getString(1) + " " + ix0);
	    		//System.out.println(rs.getString(2) + " " + ix0);

	    		nm.carbon[5][0][ix0] = new String(jdb_driver.rs.getString(1));
	    		nm.carbon[5][1][ix0] = new String(jdb_driver.rs.getString(2));
	    		nm.carbon[5][2][ix0] = new String(jdb_driver.rs.getString(3));
	    		nm.carbon[5][3][ix0] = new String(jdb_driver.rs.getString(4));
	    		nm.carbon[5][4][ix0] = new String(jdb_driver.rs.getString(5));
	    		nm.carbon[5][5][ix0] = new String(jdb_driver.rs.getString(6));
	    		nm.carbon[5][6][ix0] = new String(jdb_driver.rs.getString(7));
	    		nm.carbon[5][7][ix0] = new String(jdb_driver.rs.getString(8));
	    		nm.carbon[5][8][ix0] = new String(jdb_driver.rs.getString(9));
	    		nm.carbon[5][9][ix0] = new String(jdb_driver.rs.getString(10));
	    		nm.carbon[5][10][ix0] = new String(jdb_driver.rs.getString(11));
	    		nm.carbon[5][11][ix0] = new String(jdb_driver.rs.getString(12));
	    		nm.carbon[5][12][ix0] = new String(jdb_driver.rs.getString(13));
	    		nm.carbon[5][13][ix0] = new String(jdb_driver.rs.getString(14));
	    		nm.carbon[5][14][ix0] = new String(jdb_driver.rs.getString(15));
	    		nm.carbon[5][15][ix0] = new String(jdb_driver.rs.getString(16));
	    		nm.carbon[5][16][ix0] = new String(jdb_driver.rs.getString(17));
	    		nm.carbon[5][17][ix0] = new String(jdb_driver.rs.getString(18));
	    		nm.carbon[5][18][ix0] = new String(jdb_driver.rs.getString(19));
	    		nm.carbon[5][19][ix0] = new String(jdb_driver.rs.getString(20));
	    		nm.carbon[5][20][ix0] = new String(jdb_driver.rs.getString(21));
	    		nm.carbon[5][21][ix0] = new String(jdb_driver.rs.getString(22));
	    		nm.carbon[5][22][ix0] = new String(jdb_driver.rs.getString(23));
	    		nm.carbon[5][23][ix0] = new String(jdb_driver.rs.getString(24));
	    		nm.carbon[5][24][ix0] = new String(jdb_driver.rs.getString(25));
	    		nm.carbon[5][25][ix0] = new String(jdb_driver.rs.getString(26));
	    		nm.carbon[5][26][ix0] = new String(jdb_driver.rs.getString(27));
	    		nm.carbon[5][27][ix0] = new String(jdb_driver.rs.getString(28));
	    		nm.carbon[5][28][ix0] = new String(jdb_driver.rs.getString(29));
	    		nm.carbon[5][29][ix0] = new String(jdb_driver.rs.getString(30));
	  			nm.carbon[5][30][ix0] = new String(jdb_driver.rs.getString(31));
	   			nm.carbon[5][31][ix0] = new String(jdb_driver.rs.getString(32));
	   			nm.carbon[5][32][ix0] = new String(jdb_driver.rs.getString(33));
	   			nm.carbon[5][33][ix0] = new String(jdb_driver.rs.getString(34));
	   			nm.carbon[5][34][ix0] = new String(jdb_driver.rs.getString(35));
	   			nm.carbon[5][35][ix0] = new String(jdb_driver.rs.getString(36));
	   			nm.carbon[5][36][ix0] = new String(jdb_driver.rs.getString(37));
	   			nm.carbon[5][37][ix0] = new String(jdb_driver.rs.getString(38));
	   			nm.carbon[5][38][ix0] = new String(jdb_driver.rs.getString(39));
	   			nm.carbon[5][39][ix0] = new String(jdb_driver.rs.getString(40));
	   			nm.carbon[5][40][ix0] = new String(jdb_driver.rs.getString(41));
	   			nm.carbon[5][41][ix0] = new String(jdb_driver.rs.getString(42));
	   			nm.carbon[5][42][ix0] = new String(jdb_driver.rs.getString(43));
	   			nm.carbon[5][43][ix0] = new String(jdb_driver.rs.getString(44));
	   			nm.carbon[5][44][ix0] = new String(jdb_driver.rs.getString(45));
	   			nm.carbon[5][45][ix0] = new String(jdb_driver.rs.getString(46));
	   			nm.carbon[5][46][ix0] = new String(jdb_driver.rs.getString(47));
	  			nm.carbon[5][47][ix0] = new String(jdb_driver.rs.getString(48));
	   			nm.carbon[5][48][ix0] = new String(jdb_driver.rs.getString(49));
	   			nm.carbon[5][49][ix0] = new String(jdb_driver.rs.getString(50));	    
           		nm.carbon[5][50][ix0] = new String(jdb_driver.rs.getString(51));
	    		nm.carbon[5][51][ix0] = new String(jdb_driver.rs.getString(52));
	    		nm.carbon[5][52][ix0] = new String(jdb_driver.rs.getString(53));
	    		nm.carbon[5][53][ix0] = new String(jdb_driver.rs.getString(54));
	    		nm.carbon[5][54][ix0] = new String(jdb_driver.rs.getString(55));
	    		nm.carbon[5][55][ix0] = new String(jdb_driver.rs.getString(56));
	    		nm.carbon[5][56][ix0] = new String(jdb_driver.rs.getString(57));
	    		nm.carbon[5][57][ix0] = new String(jdb_driver.rs.getString(58));
	    		nm.carbon[5][58][ix0] = new String(jdb_driver.rs.getString(59));
	    		nm.carbon[5][59][ix0] = new String(jdb_driver.rs.getString(60));
	    		nm.carbon[5][60][ix0] = new String(jdb_driver.rs.getString(61));
	    		nm.carbon[5][61][ix0] = new String(jdb_driver.rs.getString(62));
	    		nm.carbon[5][62][ix0] = new String(jdb_driver.rs.getString(63));
	    		nm.carbon[5][63][ix0] = new String(jdb_driver.rs.getString(64));
	    		nm.carbon[5][64][ix0] = new String(jdb_driver.rs.getString(65));
	    		nm.carbon[5][65][ix0] = new String(jdb_driver.rs.getString(66));
	    		nm.carbon[5][66][ix0] = new String(jdb_driver.rs.getString(67));
	    		nm.carbon[5][67][ix0] = new String(jdb_driver.rs.getString(68));
	    		nm.carbon[5][68][ix0] = new String(jdb_driver.rs.getString(69));
	    		nm.carbon[5][69][ix0] = new String(jdb_driver.rs.getString(70));
	    		nm.carbon[5][70][ix0] = new String(jdb_driver.rs.getString(71));
	    		nm.carbon[5][71][ix0] = new String(jdb_driver.rs.getString(72));
	    		nm.carbon[5][72][ix0] = new String(jdb_driver.rs.getString(73));
	    		nm.carbon[5][73][ix0] = new String(jdb_driver.rs.getString(74));
	    		nm.carbon[5][74][ix0] = new String(jdb_driver.rs.getString(75));	    
            	nm.carbon[5][75][ix0] = new String(jdb_driver.rs.getString(76));
	    		nm.carbon[5][76][ix0] = new String(jdb_driver.rs.getString(77));
	    		nm.carbon[5][77][ix0] = new String(jdb_driver.rs.getString(78));
	    		nm.carbon[5][78][ix0] = new String(jdb_driver.rs.getString(79));
	    		nm.carbon[5][79][ix0] = new String(jdb_driver.rs.getString(80));
	    		nm.carbon[5][80][ix0] = new String(jdb_driver.rs.getString(81));
	    		nm.carbon[5][81][ix0] = new String(jdb_driver.rs.getString(82));
	    		nm.carbon[5][82][ix0] = new String(jdb_driver.rs.getString(83));
	    		nm.carbon[5][83][ix0] = new String(jdb_driver.rs.getString(84));
	    		nm.carbon[5][84][ix0] = new String(jdb_driver.rs.getString(85));
	    		nm.carbon[5][85][ix0] = new String(jdb_driver.rs.getString(86));
	   	 		nm.carbon[5][86][ix0] = new String(jdb_driver.rs.getString(87));
	    		nm.carbon[5][87][ix0] = new String(jdb_driver.rs.getString(88));
	    		nm.carbon[5][88][ix0] = new String(jdb_driver.rs.getString(89));
	    		nm.carbon[5][89][ix0] = new String(jdb_driver.rs.getString(90));
	    		nm.carbon[5][90][ix0] = new String(jdb_driver.rs.getString(91));
	    		nm.carbon[5][91][ix0] = new String(jdb_driver.rs.getString(92));
	    		nm.carbon[5][92][ix0] = new String(jdb_driver.rs.getString(93));
	    		nm.carbon[5][93][ix0] = new String(jdb_driver.rs.getString(94));
	    		nm.carbon[5][94][ix0] = new String(jdb_driver.rs.getString(95));
	    		nm.carbon[5][95][ix0] = new String(jdb_driver.rs.getString(96));
	    		nm.carbon[5][96][ix0] = new String(jdb_driver.rs.getString(97));
	    		nm.carbon[5][97][ix0] = new String(jdb_driver.rs.getString(98));
	    		nm.carbon[5][98][ix0] = new String(jdb_driver.rs.getString(99));
	    		nm.carbon[5][99][ix0] = new String(jdb_driver.rs.getString(100));

	    		
	    		//System.out.println();


	    		ix0++;

	    	}//while








	    	nm.carbon[6] = new String[4][nm.db_dd_number];

			//infox2.setText(spacer_0 + "Load Settings Display database");
           	jdb_driver.rs = jdb_driver.s.executeQuery("SELECT settings_json FROM settings_display");

	    	System.out.println("Got List");

			jdb_driver.rs.next();
	    	String buffer4 = new String(jdb_driver.rs.getString(1));

			//JSONParser parserx2 = new JSONParser();
			Object objx2 = parserx.parse(buffer4);
			JSONObject jsonObjectx2 = (JSONObject) objx2;

			for (int xloop = 0; xloop < nm.db_dd_number; xloop++) {//******************

				nm.carbon[6][0][xloop] = (String) jsonObjectx2.get("w" + Integer.toString(xloop));
				nm.carbon[6][1][xloop] = (String) jsonObjectx2.get("x" + Integer.toString(xloop));
				nm.carbon[6][2][xloop] = (String) jsonObjectx2.get("y" + Integer.toString(xloop));
				nm.carbon[6][3][xloop] = (String) jsonObjectx2.get("z" + Integer.toString(xloop));

			}//for*********************************************************************

			//System.out.println(nm.settings_display[0][0]);




            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


        } catch (Exception e) {e.printStackTrace();}




	}//build*************







}//last

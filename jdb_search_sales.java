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




public class jdb_search_sales {


// the default framework is embedded
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";




jdb_search_sales() {//***********

	System.out.println("Ready!");

}//******************************





	public String[][] searchItems(String search_text, String column_string, int load_limit, int db_cc_number) {//**************************************************************************


		String[][] carbon = new String[0][0];

		try{


			//String sort_string = new String("part_number");
	    	String display_cut = new String("");
			int ix0 = 0;


            //load the new items
			PreparedStatement updateemp = jdb_driver.conn.prepareStatement("SELECT * FROM sold WHERE LOWER(" + column_string + ") LIKE ? ORDER BY part_number DESC", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
	      	updateemp.setString(1, "%" + search_text + "%");
	      	updateemp.setMaxRows(load_limit);
            jdb_driver.rs = updateemp.executeQuery();

			jdb_driver.rs.last();
	    	int rowCount = jdb_driver.rs.getRow();

	    	System.out.println("rowCount " + rowCount);

	    	carbon = new String[db_cc_number][rowCount];

			jdb_driver.rs.beforeFirst();


	    	while (jdb_driver.rs.next()) {


	    		carbon[0][ix0] = new String(jdb_driver.rs.getString(2));
	    		carbon[1][ix0] = new String(jdb_driver.rs.getString(3));
	    		carbon[2][ix0] = new String(jdb_driver.rs.getString(4));
	   		 	carbon[3][ix0] = new String(jdb_driver.rs.getString(5));
	    		carbon[4][ix0] = new String(jdb_driver.rs.getString(6));
	    		carbon[5][ix0] = new String(jdb_driver.rs.getString(7));
	    		carbon[6][ix0] = new String(jdb_driver.rs.getString(8));
	    		carbon[7][ix0] = new String(jdb_driver.rs.getString(9));
	    		carbon[8][ix0] = new String(jdb_driver.rs.getString(10));
	    		carbon[9][ix0] = new String(jdb_driver.rs.getString(11));
	    		carbon[10][ix0] = new String(jdb_driver.rs.getString(12));
	    		carbon[11][ix0] = new String(jdb_driver.rs.getString(13));
	    		carbon[12][ix0] = new String(jdb_driver.rs.getString(14));
	    		carbon[13][ix0] = new String(jdb_driver.rs.getString(15));
	    		carbon[14][ix0] = new String(jdb_driver.rs.getString(16));
	    		carbon[15][ix0] = new String(jdb_driver.rs.getString(17));
	    		carbon[16][ix0] = new String(jdb_driver.rs.getString(18));
	    		carbon[17][ix0] = new String(jdb_driver.rs.getString(19));
	    		carbon[18][ix0] = new String(jdb_driver.rs.getString(20));
	    		carbon[19][ix0] = new String(jdb_driver.rs.getString(21));
	    		carbon[20][ix0] = new String(jdb_driver.rs.getString(22));
	    		carbon[21][ix0] = new String(jdb_driver.rs.getString(23));
	    		carbon[22][ix0] = new String(jdb_driver.rs.getString(24));
	    		carbon[23][ix0] = new String(jdb_driver.rs.getString(25));
	    		carbon[24][ix0] = new String(jdb_driver.rs.getString(26));
	    		carbon[25][ix0] = new String(jdb_driver.rs.getString(27));
	    		carbon[26][ix0] = new String(jdb_driver.rs.getString(28));
	    		carbon[27][ix0] = new String(jdb_driver.rs.getString(29));
	    		carbon[28][ix0] = new String(jdb_driver.rs.getString(30));
	    		carbon[29][ix0] = new String(jdb_driver.rs.getString(31));
	    		carbon[30][ix0] = new String(jdb_driver.rs.getString(32));
	    		carbon[31][ix0] = new String(jdb_driver.rs.getString(33));
			   	carbon[32][ix0] = new String(jdb_driver.rs.getString(34));
			   	carbon[33][ix0] = new String(jdb_driver.rs.getString(35));
	    		carbon[34][ix0] = new String(jdb_driver.rs.getString(36));
	    		carbon[35][ix0] = new String(jdb_driver.rs.getString(37));
	    		carbon[36][ix0] = new String(jdb_driver.rs.getString(38));
	    		carbon[37][ix0] = new String(jdb_driver.rs.getString(39));
	    		carbon[38][ix0] = new String(jdb_driver.rs.getString(40));
	    		carbon[39][ix0] = new String(jdb_driver.rs.getString(41));
	    		carbon[40][ix0] = new String(jdb_driver.rs.getString(42));
	    		carbon[41][ix0] = new String(jdb_driver.rs.getString(43));
	    		carbon[42][ix0] = new String(jdb_driver.rs.getString(44));
	    		carbon[43][ix0] = new String(jdb_driver.rs.getString(45));
	    		carbon[44][ix0] = new String(jdb_driver.rs.getString(46));
	    		carbon[45][ix0] = new String(jdb_driver.rs.getString(47));
	    		carbon[46][ix0] = new String(jdb_driver.rs.getString(48));
	    		carbon[47][ix0] = new String(jdb_driver.rs.getString(49));
	    		carbon[48][ix0] = new String(jdb_driver.rs.getString(50));
	    		carbon[49][ix0] = new String(jdb_driver.rs.getString(51));	    
            	carbon[50][ix0] = new String(jdb_driver.rs.getString(52));
	    		carbon[51][ix0] = new String(jdb_driver.rs.getString(53));
	    		carbon[52][ix0] = new String(jdb_driver.rs.getString(54));
	   	 		carbon[53][ix0] = new String(jdb_driver.rs.getString(55));
	   		 	carbon[54][ix0] = new String(jdb_driver.rs.getString(56));
	   		 	carbon[55][ix0] = new String(jdb_driver.rs.getString(57));
	    		carbon[56][ix0] = new String(jdb_driver.rs.getString(58));
	    		carbon[57][ix0] = new String(jdb_driver.rs.getString(59));
	    		carbon[58][ix0] = new String(jdb_driver.rs.getString(60));
	    		carbon[59][ix0] = new String(jdb_driver.rs.getString(61));
	    		carbon[60][ix0] = new String(jdb_driver.rs.getString(62));
	    		carbon[61][ix0] = new String(jdb_driver.rs.getString(63));
	    		carbon[62][ix0] = new String(jdb_driver.rs.getString(64));
	    		carbon[63][ix0] = new String(jdb_driver.rs.getString(65));
	    		carbon[64][ix0] = new String(jdb_driver.rs.getString(66));
	    		carbon[65][ix0] = new String(jdb_driver.rs.getString(67));
	   			carbon[66][ix0] = new String(jdb_driver.rs.getString(68));
	   			carbon[67][ix0] = new String(jdb_driver.rs.getString(69));
	   			carbon[68][ix0] = new String(jdb_driver.rs.getString(70));
	    		carbon[69][ix0] = new String(jdb_driver.rs.getString(71));
	    		carbon[70][ix0] = new String(jdb_driver.rs.getString(72));
	   			carbon[71][ix0] = new String(jdb_driver.rs.getString(73));
	   			carbon[72][ix0] = new String(jdb_driver.rs.getString(74));
	   			carbon[73][ix0] = new String(jdb_driver.rs.getString(75));
	    		carbon[74][ix0] = new String(jdb_driver.rs.getString(76));	    
           		carbon[75][ix0] = new String(jdb_driver.rs.getString(77));
	    		carbon[76][ix0] = new String(jdb_driver.rs.getString(78));
	   			carbon[77][ix0] = new String(jdb_driver.rs.getString(79));
	   			carbon[78][ix0] = new String(jdb_driver.rs.getString(80));
	    		carbon[79][ix0] = new String(jdb_driver.rs.getString(81));
	    		carbon[80][ix0] = new String(jdb_driver.rs.getString(82));
	    		carbon[81][ix0] = new String(jdb_driver.rs.getString(83));
    			carbon[82][ix0] = new String(jdb_driver.rs.getString(84));
	   			carbon[83][ix0] = new String(jdb_driver.rs.getString(85));
	   			carbon[84][ix0] = new String(jdb_driver.rs.getString(86));
	   			carbon[85][ix0] = new String(jdb_driver.rs.getString(87));
	   			carbon[86][ix0] = new String(jdb_driver.rs.getString(88));
	    		carbon[87][ix0] = new String(jdb_driver.rs.getString(89));
	    		carbon[88][ix0] = new String(jdb_driver.rs.getString(90));
	    		carbon[89][ix0] = new String(jdb_driver.rs.getString(91));
	    		carbon[90][ix0] = new String(jdb_driver.rs.getString(92));
	   		 	carbon[91][ix0] = new String(jdb_driver.rs.getString(93));
	    		carbon[92][ix0] = new String(jdb_driver.rs.getString(94));
	    		carbon[93][ix0] = new String(jdb_driver.rs.getString(95));
	    		carbon[94][ix0] = new String(jdb_driver.rs.getString(96));
	    		carbon[95][ix0] = new String(jdb_driver.rs.getString(97));
	    		carbon[96][ix0] = new String(jdb_driver.rs.getString(98));
	    		carbon[97][ix0] = new String(jdb_driver.rs.getString(99));
	    		carbon[98][ix0] = new String(jdb_driver.rs.getString(100));
	    		carbon[99][ix0] = new String(jdb_driver.rs.getString(101));


	    		ix0++;

	    	}//while




            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


        } catch (Exception e) {e.printStackTrace();}


        return carbon;

	}//load






}//last
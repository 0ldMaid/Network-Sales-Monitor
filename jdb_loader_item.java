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




public class jdb_loader_item extends JFrame{


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



static String ddx;
Image ximageg;


String spacer_0 = new String("  ");





    String[] getTitle(String title){//**************************************************************************



		String[] ssp = new String[nm.db_cc_number];

		try{



	    	
	    	String display_cut = new String("");



            //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			jdb_driver.s.setMaxRows(1); 
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT * FROM listings WHERE title='" + title + "'");

	    	ix0 = 0;
	    	while(jdb_driver.rs.next()){


	    		//repaint();

	    		display_cut = jdb_driver.rs.getString(83);

	    		if(display_cut.length() > 25){display_cut = display_cut.substring(0,25) + "...";}

	    		ssp[0]  = new String(jdb_driver.rs.getString(2));
	    		ssp[1]  = new String(jdb_driver.rs.getString(3));
	    		ssp[2]  = new String(jdb_driver.rs.getString(4));
	   		 	ssp[3]  = new String(jdb_driver.rs.getString(5));
	    		ssp[4]  = new String(jdb_driver.rs.getString(6));
	    		ssp[5]  = new String(jdb_driver.rs.getString(7));
	    		ssp[6]  = new String(jdb_driver.rs.getString(8));
	    		ssp[7]  = new String(jdb_driver.rs.getString(9));
	    		ssp[8]  = new String(jdb_driver.rs.getString(10));
	    		ssp[9]  = new String(jdb_driver.rs.getString(11));
	    		ssp[10] = new String(jdb_driver.rs.getString(12));
	    		ssp[11] = new String(jdb_driver.rs.getString(13));
	    		ssp[12] = new String(jdb_driver.rs.getString(14));
	    		ssp[13] = new String(jdb_driver.rs.getString(15));
	    		ssp[14] = new String(jdb_driver.rs.getString(16));
	    		ssp[15] = new String(jdb_driver.rs.getString(17));
	    		ssp[16] = new String(jdb_driver.rs.getString(18));
	    		ssp[17] = new String(jdb_driver.rs.getString(19));
	    		ssp[18] = new String(jdb_driver.rs.getString(20));
	    		ssp[19] = new String(jdb_driver.rs.getString(21));
	    		ssp[20] = new String(jdb_driver.rs.getString(22));
	    		ssp[21] = new String(jdb_driver.rs.getString(23));
	    		ssp[22] = new String(jdb_driver.rs.getString(24));
	    		ssp[23] = new String(jdb_driver.rs.getString(25));
	    		ssp[24] = new String(jdb_driver.rs.getString(26));
	    		ssp[25] = new String(jdb_driver.rs.getString(27));
	    		ssp[26] = new String(jdb_driver.rs.getString(28));
	    		ssp[27] = new String(jdb_driver.rs.getString(29));
	    		ssp[28] = new String(jdb_driver.rs.getString(30));
	    		ssp[29] = new String(jdb_driver.rs.getString(31));
	    		ssp[30] = new String(jdb_driver.rs.getString(32));
	    		ssp[31] = new String(jdb_driver.rs.getString(33));
			   	ssp[32] = new String(jdb_driver.rs.getString(34));
			   	ssp[33] = new String(jdb_driver.rs.getString(35));
	    		ssp[34] = new String(jdb_driver.rs.getString(36));
	    		ssp[35] = new String(jdb_driver.rs.getString(37));
	    		ssp[36] = new String(jdb_driver.rs.getString(38));
	    		ssp[37] = new String(jdb_driver.rs.getString(39));
	    		ssp[38] = new String(jdb_driver.rs.getString(40));
	    		ssp[39] = new String(jdb_driver.rs.getString(41));
	    		ssp[40] = new String(jdb_driver.rs.getString(42));
	    		ssp[41] = new String(jdb_driver.rs.getString(43));
	    		ssp[42] = new String(jdb_driver.rs.getString(44));
	    		ssp[43] = new String(jdb_driver.rs.getString(45));
	    		ssp[44] = new String(jdb_driver.rs.getString(46));
	    		ssp[45] = new String(jdb_driver.rs.getString(47));
	    		ssp[46] = new String(jdb_driver.rs.getString(48));
	    		ssp[47] = new String(jdb_driver.rs.getString(49));
	    		ssp[48] = new String(jdb_driver.rs.getString(50));
	    		ssp[49] = new String(jdb_driver.rs.getString(51));	    
            	ssp[50] = new String(jdb_driver.rs.getString(52));
	    		ssp[51] = new String(jdb_driver.rs.getString(53));
	    		ssp[52] = new String(jdb_driver.rs.getString(54));
	   	 		ssp[53] = new String(jdb_driver.rs.getString(55));
	   		 	ssp[54] = new String(jdb_driver.rs.getString(56));
	   		 	ssp[55] = new String(jdb_driver.rs.getString(57));
	   			ssp[56] = new String(jdb_driver.rs.getString(58));
	    		ssp[57] = new String(jdb_driver.rs.getString(59));
	    		ssp[58] = new String(jdb_driver.rs.getString(60));
	    		ssp[59] = new String(jdb_driver.rs.getString(61));
	    		ssp[60] = new String(jdb_driver.rs.getString(62));
	    		ssp[61] = new String(jdb_driver.rs.getString(63));
	    		ssp[62] = new String(jdb_driver.rs.getString(64));
	    		ssp[63] = new String(jdb_driver.rs.getString(65));
	    		ssp[64] = new String(jdb_driver.rs.getString(66));
	    		ssp[65] = new String(jdb_driver.rs.getString(67));
	    		ssp[66] = new String(jdb_driver.rs.getString(68));
	    		ssp[67] = new String(jdb_driver.rs.getString(69));
	    		ssp[68] = new String(jdb_driver.rs.getString(70));
	    		ssp[69] = new String(jdb_driver.rs.getString(71) + jdb_driver.rs.getString(72) + jdb_driver.rs.getString(73));
	    		ssp[70] = new String(jdb_driver.rs.getString(74));
	    		ssp[71] = new String(jdb_driver.rs.getString(75));
	    		ssp[72] = new String(jdb_driver.rs.getString(76));
	    		ssp[73] = new String(jdb_driver.rs.getString(77));
	    		ssp[74] = new String(jdb_driver.rs.getString(78));	    
            	ssp[75] = new String(jdb_driver.rs.getString(79));
	    		ssp[76] = new String(jdb_driver.rs.getString(80));
	    		ssp[77] = new String(jdb_driver.rs.getString(81));
	    		ssp[78] = new String(jdb_driver.rs.getString(82));
	    		ssp[79] = new String(jdb_driver.rs.getString(83));
	    		ssp[80] = new String(jdb_driver.rs.getString(84));
	    		ssp[81] = new String(jdb_driver.rs.getString(85));
	    		ssp[82] = new String(jdb_driver.rs.getString(86));
	    		ssp[83] = new String(jdb_driver.rs.getString(87));
	    		ssp[84] = new String(jdb_driver.rs.getString(88));
	    		ssp[85] = new String(jdb_driver.rs.getString(89));
	    		ssp[86] = new String(jdb_driver.rs.getString(90));
	    		ssp[87] = new String(jdb_driver.rs.getString(91));
	    		ssp[88] = new String(jdb_driver.rs.getString(92));
	    		ssp[89] = new String(jdb_driver.rs.getString(93));
	    		ssp[90] = new String(jdb_driver.rs.getString(94));
	   		 	ssp[91] = new String(jdb_driver.rs.getString(95));
	    		ssp[92] = new String(jdb_driver.rs.getString(96));
	    		ssp[93] = new String(jdb_driver.rs.getString(97));
	    		ssp[94] = new String(jdb_driver.rs.getString(98));
	    		ssp[95] = new String(jdb_driver.rs.getString(99));
	    		ssp[96] = new String(jdb_driver.rs.getString(100));
	    		ssp[97] = new String(jdb_driver.rs.getString(101));
	    		ssp[98] = new String(jdb_driver.rs.getString(102));
	    		ssp[99] = new String(jdb_driver.rs.getString(103));


	    		ix0++;

	    	}//while




            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


        }catch(Exception e){e.printStackTrace();}


        return ssp;
		//pullThePlug();


	}//load









    String[] getSku(String sku){//**************************************************************************



		String[] ssp = new String[100];

		try{



	    	
	    	String display_cut = new String("");



            //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			jdb_driver.s.setMaxRows(1); 
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT * FROM listings WHERE part_number='" + sku + "'");

	    	ix0 = 0;
	    	while(jdb_driver.rs.next()){


	    		//repaint();

	    		display_cut = jdb_driver.rs.getString(83);

	    		if(display_cut.length() > 25){display_cut = display_cut.substring(0,25) + "...";}

	    		ssp[0]  = new String(jdb_driver.rs.getString(2));
	    		ssp[1]  = new String(jdb_driver.rs.getString(3));
	    		ssp[2]  = new String(jdb_driver.rs.getString(4));
	   			ssp[3]  = new String(jdb_driver.rs.getString(5));
	    		ssp[4]  = new String(jdb_driver.rs.getString(6));
	    		ssp[5]  = new String(jdb_driver.rs.getString(7));
	    		ssp[6]  = new String(jdb_driver.rs.getString(8));
	    		ssp[7]  = new String(jdb_driver.rs.getString(9));
	    		ssp[8]  = new String(jdb_driver.rs.getString(10));
	    		ssp[9]  = new String(jdb_driver.rs.getString(11));
	    		ssp[10] = new String(jdb_driver.rs.getString(12));
	    		ssp[11] = new String(jdb_driver.rs.getString(13));
	    		ssp[12] = new String(jdb_driver.rs.getString(14));
	    		ssp[13] = new String(jdb_driver.rs.getString(15));
	    		ssp[14] = new String(jdb_driver.rs.getString(16));
	    		ssp[15] = new String(jdb_driver.rs.getString(17));
	    		ssp[16] = new String(jdb_driver.rs.getString(18));
	    		ssp[17] = new String(jdb_driver.rs.getString(19));
	    		ssp[18] = new String(jdb_driver.rs.getString(20));
	    		ssp[19] = new String(jdb_driver.rs.getString(21));
	    		ssp[20] = new String(jdb_driver.rs.getString(22));
	    		ssp[21] = new String(jdb_driver.rs.getString(23));
	    		ssp[22] = new String(jdb_driver.rs.getString(24));
	    		ssp[23] = new String(jdb_driver.rs.getString(25));
	    		ssp[24] = new String(jdb_driver.rs.getString(26));
	    		ssp[25] = new String(jdb_driver.rs.getString(27));
	    		ssp[26] = new String(jdb_driver.rs.getString(28));
	    		ssp[27] = new String(jdb_driver.rs.getString(29));
	    		ssp[28] = new String(jdb_driver.rs.getString(30));
	    		ssp[29] = new String(jdb_driver.rs.getString(31));
	    		ssp[30] = new String(jdb_driver.rs.getString(32));
	    		ssp[31] = new String(jdb_driver.rs.getString(33));
			   	ssp[32] = new String(jdb_driver.rs.getString(34));
			   	ssp[33] = new String(jdb_driver.rs.getString(35));
	    		ssp[34] = new String(jdb_driver.rs.getString(36));
	    		ssp[35] = new String(jdb_driver.rs.getString(37));
	    		ssp[36] = new String(jdb_driver.rs.getString(38));
	    		ssp[37] = new String(jdb_driver.rs.getString(39));
	    		ssp[38] = new String(jdb_driver.rs.getString(40));
	    		ssp[39] = new String(jdb_driver.rs.getString(41));
	    		ssp[40] = new String(jdb_driver.rs.getString(42));
	    		ssp[41] = new String(jdb_driver.rs.getString(43));
	    		ssp[42] = new String(jdb_driver.rs.getString(44));
	    		ssp[43] = new String(jdb_driver.rs.getString(45));
	    		ssp[44] = new String(jdb_driver.rs.getString(46));
	    		ssp[45] = new String(jdb_driver.rs.getString(47));
	    		ssp[46] = new String(jdb_driver.rs.getString(48));
	    		ssp[47] = new String(jdb_driver.rs.getString(49));
	    		ssp[48] = new String(jdb_driver.rs.getString(50));
	    		ssp[49] = new String(jdb_driver.rs.getString(51));	    
            	ssp[50] = new String(jdb_driver.rs.getString(52));
	    		ssp[51] = new String(jdb_driver.rs.getString(53));
	    		ssp[52] = new String(jdb_driver.rs.getString(54));
	   	 		ssp[53] = new String(jdb_driver.rs.getString(55));
	   		 	ssp[54] = new String(jdb_driver.rs.getString(56));
	   		 	ssp[55] = new String(jdb_driver.rs.getString(57));
	    		ssp[56] = new String(jdb_driver.rs.getString(58));
	    		ssp[57] = new String(jdb_driver.rs.getString(59));
	    		ssp[58] = new String(jdb_driver.rs.getString(60));
	    		ssp[59] = new String(jdb_driver.rs.getString(61));
	    		ssp[60] = new String(jdb_driver.rs.getString(62));
	    		ssp[61] = new String(jdb_driver.rs.getString(63));
	    		ssp[62] = new String(jdb_driver.rs.getString(64));
	    		ssp[63] = new String(jdb_driver.rs.getString(65));
	    		ssp[64] = new String(jdb_driver.rs.getString(66));
	    		ssp[65] = new String(jdb_driver.rs.getString(67));
	    		ssp[66] = new String(jdb_driver.rs.getString(68));
	    		ssp[67] = new String(jdb_driver.rs.getString(69));
	    		ssp[68] = new String(jdb_driver.rs.getString(70));
	   			ssp[69] = new String(jdb_driver.rs.getString(71) + jdb_driver.rs.getString(72) + jdb_driver.rs.getString(73));
	   			ssp[70] = new String(jdb_driver.rs.getString(74));
	   			ssp[71] = new String(jdb_driver.rs.getString(75));
	   			ssp[72] = new String(jdb_driver.rs.getString(76));
	   			ssp[73] = new String(jdb_driver.rs.getString(77));
	   			ssp[74] = new String(jdb_driver.rs.getString(78));	    
          		ssp[75] = new String(jdb_driver.rs.getString(79));
	    		ssp[76] = new String(jdb_driver.rs.getString(80));
	    		ssp[77] = new String(jdb_driver.rs.getString(81));
	    		ssp[78] = new String(jdb_driver.rs.getString(82));
	    		ssp[79] = new String(jdb_driver.rs.getString(83));
	    		ssp[80] = new String(jdb_driver.rs.getString(84));
	    		ssp[81] = new String(jdb_driver.rs.getString(85));
	    		ssp[82] = new String(jdb_driver.rs.getString(86));
	    		ssp[83] = new String(jdb_driver.rs.getString(87));
	    		ssp[84] = new String(jdb_driver.rs.getString(88));
	    		ssp[85] = new String(jdb_driver.rs.getString(89));
	    		ssp[86] = new String(jdb_driver.rs.getString(90));
	    		ssp[87] = new String(jdb_driver.rs.getString(91));
	    		ssp[88] = new String(jdb_driver.rs.getString(92));
	    		ssp[89] = new String(jdb_driver.rs.getString(93));
	    		ssp[90] = new String(jdb_driver.rs.getString(94));
	   			ssp[91] = new String(jdb_driver.rs.getString(95));
	    		ssp[92] = new String(jdb_driver.rs.getString(96));
	    		ssp[93] = new String(jdb_driver.rs.getString(97));
	    		ssp[94] = new String(jdb_driver.rs.getString(98));
	    		ssp[95] = new String(jdb_driver.rs.getString(99));
	    		ssp[96] = new String(jdb_driver.rs.getString(100));
	    		ssp[97] = new String(jdb_driver.rs.getString(101));
	    		ssp[98] = new String(jdb_driver.rs.getString(102));
	    		ssp[99] = new String(jdb_driver.rs.getString(103));


	    		ix0++;

	    	}//while




            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");


        }catch(Exception e){e.printStackTrace();}


        return ssp;
		//pullThePlug();


	}//load






    public void pullThePlug() {

    	nm.firex = 1;

    	System.out.println("PULL THE PLUG");

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull





}//last
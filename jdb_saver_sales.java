import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;



public class jdb_saver_sales{

/* the default framework is embedded*/
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";


int ix0 = 0;
int ix1 = 0;

String cx0 = new String();
String cx1 = new String();
String cx2 = new String();




    jdb_saver_sales(){//************************************************************************



        try{






	        if(nm.carbon[4][0][18].equals("1")){

	            //s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" + "'derby.connection.requireAuthentication', 'true')");
	            //s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" + "'derby.connection.requireAuthentication', 'true')");
                //s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" + "'derby.authentication.provider', 'BUILTIN')");
                //s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" + "'derby.user." + nm.carbon[4][0][14] + "', '" + nm.carbon[4][0][15] + "')");
                //s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" + "'derby.database.fullAccessUsers', '" + nm.carbon[4][0][14] + "')");
                
	        }//if use login
	        else{}

            // delete the table


            ix1 = 20000;



            //and add a few rows...

	        PreparedStatement ps = null;

	        ps = jdb_driver.conn.prepareStatement("insert into sales(address_1, address_2, address_3, address_4, address_5, address_6, buyer_id, buyers_email, buyers_first_name, buyers_last_name, buyers_notes, buyers_phone, currency, custom_1, custom_2, custom_3, custom_4, custom_5, custom_6, custom_7, custom_8, custom_9, custom_10, custom_11, custom_12, custom_13, custom_14, custom_15, custom_16, custom_17, custom_18, custom_19, custom_20, custom_21, custom_22, custom_23, custom_24, custom_25, custom_26, custom_27, custom_28, custom_29, custom_30, custom_31, custom_32, custom_33, custom_34, custom_35, custom_36, custom_37, custom_38, custom_39, custom_40, custom_41, custom_42, custom_43, custom_44, custom_45, custom_46, custom_template, date_last_modified, date_payment_received, date_shipped, date_sold, ebay_item, final_value_fee, handling, hits, item_cost, item_description1, item_description2, item_description3, item_id, item_price, item_weight, listing_fees, listing_id, notes, package_d, package_l, package_w, part_number, payment_type, paypal_fees, picture_1, quantity_sold, sale_id, sale_status, sales_tax, shipping_company, shipping_in, shipping_out, site_id, site_url, source_of_sale, title, title_url, total_on_hand, total_sale_amount, tracking_number, transaction_id, transaction_info) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

	        int numrows = 0;

	        for(int loop1 = 0; loop1 < nm.carbon[6][0].length; loop1++){//********************

                if(nm.carbon[6][0][loop1].length() == 0){nm.carbon[6][0][loop1] = new String("*");}

	        }//*******************************************************************************

	        for(int loop1 = 0; loop1 < nm.carbon[2][0].length; loop1++){//********************


                if(nm.carbon[2][13][loop1].length() > 2500){nm.carbon[2][13][loop1] = nm.carbon[2][13][loop1].substring(0, 2500);}


                ps.setString(1,nm.carbon[2][0][loop1]);
                ps.setString(2,nm.carbon[2][1][loop1]);
                ps.setString(3,nm.carbon[2][2][loop1]);
                ps.setString(4,nm.carbon[2][3][loop1]);
                ps.setString(5,nm.carbon[2][4][loop1]);
                ps.setString(6,nm.carbon[2][5][loop1]);
                ps.setString(7,nm.carbon[2][6][loop1]);
                ps.setString(8,nm.carbon[2][7][loop1]);
                ps.setString(9,nm.carbon[2][8][loop1]);
                ps.setString(10,nm.carbon[2][9][loop1]);           
                ps.setString(11,nm.carbon[2][10][loop1]);
                ps.setString(12,nm.carbon[2][11][loop1]);
                if(nm.carbon[2][12][loop1].length() > 2499){nm.carbon[2][12][loop1] = nm.carbon[2][12][loop1].substring(0, 199);} ps.setString(13,nm.carbon[2][12][loop1]);
                if(nm.carbon[2][13][loop1].length() > 2499){nm.carbon[2][13][loop1] = nm.carbon[2][13][loop1].substring(0, 199);} ps.setString(14,nm.carbon[2][13][loop1]);
                if(nm.carbon[2][14][loop1].length() > 499){nm.carbon[2][14][loop1] = nm.carbon[2][14][loop1].substring(0, 199);} ps.setString(15,nm.carbon[2][14][loop1]);
                if(nm.carbon[2][15][loop1].length() > 499){nm.carbon[2][15][loop1] = nm.carbon[2][15][loop1].substring(0, 199);} ps.setString(16,nm.carbon[2][15][loop1]);
                if(nm.carbon[2][16][loop1].length() > 199){nm.carbon[2][16][loop1] = nm.carbon[2][16][loop1].substring(0, 199);} ps.setString(17,nm.carbon[2][16][loop1]);
                if(nm.carbon[2][17][loop1].length() > 199){nm.carbon[2][17][loop1] = nm.carbon[2][17][loop1].substring(0, 199);} ps.setString(18,nm.carbon[2][17][loop1]);
                if(nm.carbon[2][18][loop1].length() > 199){nm.carbon[2][18][loop1] = nm.carbon[2][18][loop1].substring(0, 199);} ps.setString(19,nm.carbon[2][18][loop1]);
                if(nm.carbon[2][19][loop1].length() > 199){nm.carbon[2][19][loop1] = nm.carbon[2][19][loop1].substring(0, 199);} ps.setString(20,nm.carbon[2][19][loop1]);           
                if(nm.carbon[2][20][loop1].length() > 199){nm.carbon[2][20][loop1] = nm.carbon[2][20][loop1].substring(0, 199);} ps.setString(21,nm.carbon[2][20][loop1]);
                if(nm.carbon[2][21][loop1].length() > 199){nm.carbon[2][21][loop1] = nm.carbon[2][21][loop1].substring(0, 199);} ps.setString(22,nm.carbon[2][21][loop1]);
                if(nm.carbon[2][22][loop1].length() > 199){nm.carbon[2][22][loop1] = nm.carbon[2][22][loop1].substring(0, 199);} ps.setString(23,nm.carbon[2][22][loop1]);
                if(nm.carbon[2][23][loop1].length() > 199){nm.carbon[2][23][loop1] = nm.carbon[2][23][loop1].substring(0, 199);} ps.setString(24,nm.carbon[2][23][loop1]);
                if(nm.carbon[2][24][loop1].length() > 199){nm.carbon[2][24][loop1] = nm.carbon[2][24][loop1].substring(0, 199);} ps.setString(25,nm.carbon[2][24][loop1]);
                if(nm.carbon[2][25][loop1].length() > 199){nm.carbon[2][25][loop1] = nm.carbon[2][25][loop1].substring(0, 199);} ps.setString(26,nm.carbon[2][25][loop1]);
                if(nm.carbon[2][26][loop1].length() > 199){nm.carbon[2][26][loop1] = nm.carbon[2][26][loop1].substring(0, 199);} ps.setString(27,nm.carbon[2][26][loop1]);
                if(nm.carbon[2][27][loop1].length() > 199){nm.carbon[2][27][loop1] = nm.carbon[2][27][loop1].substring(0, 199);} ps.setString(28,nm.carbon[2][27][loop1]);
                if(nm.carbon[2][28][loop1].length() > 199){nm.carbon[2][28][loop1] = nm.carbon[2][28][loop1].substring(0, 199);} ps.setString(29,nm.carbon[2][28][loop1]);
                if(nm.carbon[2][29][loop1].length() > 199){nm.carbon[2][29][loop1] = nm.carbon[2][29][loop1].substring(0, 199);} ps.setString(30,nm.carbon[2][29][loop1]);
                if(nm.carbon[2][30][loop1].length() > 199){nm.carbon[2][30][loop1] = nm.carbon[2][30][loop1].substring(0, 199);} ps.setString(31,nm.carbon[2][30][loop1]);
                if(nm.carbon[2][31][loop1].length() > 199){nm.carbon[2][31][loop1] = nm.carbon[2][31][loop1].substring(0, 199);} ps.setString(32,nm.carbon[2][31][loop1]);
                if(nm.carbon[2][32][loop1].length() > 199){nm.carbon[2][32][loop1] = nm.carbon[2][32][loop1].substring(0, 199);} ps.setString(33,nm.carbon[2][32][loop1]);
                if(nm.carbon[2][33][loop1].length() > 199){nm.carbon[2][33][loop1] = nm.carbon[2][33][loop1].substring(0, 199);} ps.setString(34,nm.carbon[2][33][loop1]);
                if(nm.carbon[2][34][loop1].length() > 199){nm.carbon[2][34][loop1] = nm.carbon[2][34][loop1].substring(0, 199);} ps.setString(35,nm.carbon[2][34][loop1]);           
                if(nm.carbon[2][35][loop1].length() > 199){nm.carbon[2][35][loop1] = nm.carbon[2][35][loop1].substring(0, 199);} ps.setString(36,nm.carbon[2][35][loop1]);
                if(nm.carbon[2][36][loop1].length() > 199){nm.carbon[2][36][loop1] = nm.carbon[2][36][loop1].substring(0, 199);} ps.setString(37,nm.carbon[2][36][loop1]);
                if(nm.carbon[2][37][loop1].length() > 199){nm.carbon[2][37][loop1] = nm.carbon[2][37][loop1].substring(0, 199);} ps.setString(38,nm.carbon[2][37][loop1]);
                if(nm.carbon[2][38][loop1].length() > 199){nm.carbon[2][38][loop1] = nm.carbon[2][38][loop1].substring(0, 199);} ps.setString(39,nm.carbon[2][38][loop1]);
                if(nm.carbon[2][39][loop1].length() > 199){nm.carbon[2][39][loop1] = nm.carbon[2][39][loop1].substring(0, 199);} ps.setString(40,nm.carbon[2][39][loop1]);
                if(nm.carbon[2][40][loop1].length() > 199){nm.carbon[2][40][loop1] = nm.carbon[2][40][loop1].substring(0, 199);} ps.setString(41,nm.carbon[2][40][loop1]);
                if(nm.carbon[2][41][loop1].length() > 199){nm.carbon[2][41][loop1] = nm.carbon[2][41][loop1].substring(0, 199);} ps.setString(42,nm.carbon[2][41][loop1]);
                if(nm.carbon[2][42][loop1].length() > 199){nm.carbon[2][42][loop1] = nm.carbon[2][42][loop1].substring(0, 199);} ps.setString(43,nm.carbon[2][42][loop1]);
                if(nm.carbon[2][43][loop1].length() > 199){nm.carbon[2][43][loop1] = nm.carbon[2][43][loop1].substring(0, 199);} ps.setString(44,nm.carbon[2][43][loop1]);
                if(nm.carbon[2][44][loop1].length() > 199){nm.carbon[2][44][loop1] = nm.carbon[2][44][loop1].substring(0, 199);} ps.setString(45,nm.carbon[2][44][loop1]);           
                if(nm.carbon[2][45][loop1].length() > 199){nm.carbon[2][45][loop1] = nm.carbon[2][45][loop1].substring(0, 199);} ps.setString(46,nm.carbon[2][45][loop1]);
                if(nm.carbon[2][46][loop1].length() > 199){nm.carbon[2][46][loop1] = nm.carbon[2][46][loop1].substring(0, 199);} ps.setString(47,nm.carbon[2][46][loop1]);
                if(nm.carbon[2][47][loop1].length() > 199){nm.carbon[2][47][loop1] = nm.carbon[2][47][loop1].substring(0, 199);} ps.setString(48,nm.carbon[2][47][loop1]);
                if(nm.carbon[2][48][loop1].length() > 199){nm.carbon[2][48][loop1] = nm.carbon[2][48][loop1].substring(0, 199);} ps.setString(49,nm.carbon[2][48][loop1]);
                if(nm.carbon[2][49][loop1].length() > 199){nm.carbon[2][49][loop1] = nm.carbon[2][49][loop1].substring(0, 199);} ps.setString(50,nm.carbon[2][49][loop1]);   
                if(nm.carbon[2][50][loop1].length() > 199){nm.carbon[2][50][loop1] = nm.carbon[2][50][loop1].substring(0, 199);} ps.setString(51,nm.carbon[2][50][loop1]);
                if(nm.carbon[2][51][loop1].length() > 199){nm.carbon[2][51][loop1] = nm.carbon[2][51][loop1].substring(0, 199);} ps.setString(52,nm.carbon[2][51][loop1]);
                if(nm.carbon[2][52][loop1].length() > 199){nm.carbon[2][52][loop1] = nm.carbon[2][52][loop1].substring(0, 199);} ps.setString(53,nm.carbon[2][52][loop1]);
                if(nm.carbon[2][53][loop1].length() > 199){nm.carbon[2][53][loop1] = nm.carbon[2][53][loop1].substring(0, 199);} ps.setString(54,nm.carbon[2][53][loop1]);
                if(nm.carbon[2][54][loop1].length() > 199){nm.carbon[2][54][loop1] = nm.carbon[2][54][loop1].substring(0, 199);} ps.setString(55,nm.carbon[2][54][loop1]);
                if(nm.carbon[2][55][loop1].length() > 199){nm.carbon[2][55][loop1] = nm.carbon[2][55][loop1].substring(0, 199);} ps.setString(56,nm.carbon[2][55][loop1]);
                if(nm.carbon[2][56][loop1].length() > 199){nm.carbon[2][56][loop1] = nm.carbon[2][56][loop1].substring(0, 199);} ps.setString(57,nm.carbon[2][56][loop1]);
                if(nm.carbon[2][57][loop1].length() > 199){nm.carbon[2][57][loop1] = nm.carbon[2][57][loop1].substring(0, 199);} ps.setString(58,nm.carbon[2][57][loop1]);
                ps.setString(59,nm.carbon[2][58][loop1]);           
                ps.setString(60,nm.carbon[2][59][loop1]);
                ps.setString(61,nm.carbon[2][60][loop1]);
                ps.setString(62,nm.carbon[2][61][loop1]);
                ps.setString(63,nm.carbon[2][62][loop1]);
                ps.setString(64,nm.carbon[2][63][loop1]);
                if(nm.carbon[2][64][loop1].length() > 59){nm.carbon[2][64][loop1] = nm.carbon[2][64][loop1].substring(0, 59);} ps.setString(65,nm.carbon[2][64][loop1]);
                ps.setString(66,nm.carbon[2][65][loop1]);
                ps.setString(67,nm.carbon[2][66][loop1]);
                ps.setString(68,nm.carbon[2][67][loop1]);
                ps.setString(69,nm.carbon[2][68][loop1]);



	            nm.carbon[2][69][loop1] = nm.carbon[2][69][loop1].replace("\r\n", " ").replace("\n", " ");



	            if(nm.carbon[2][69][loop1].length() < 30000){

                    ps.setString(70,nm.carbon[2][69][loop1]);
	                ps.setString(71,"");
	                ps.setString(72,"");

	            }//******************************************
	            else if(nm.carbon[2][69][loop1].length() > 30000  && nm.carbon[2][69][loop1].length() < 60000){

                    cx0 = nm.carbon[2][69][loop1].substring(0,30000);
	                cx1 = nm.carbon[2][69][loop1].substring(30000,nm.carbon[2][69][loop1].length());

                    ps.setString(70,cx0);
	                ps.setString(71,cx1);
	                ps.setString(72,"");

	            }//***************************************************************************************
	            else if(nm.carbon[2][69][loop1].length() > 60000  && nm.carbon[2][69][loop1].length() < 90000){

	                cx0 = nm.carbon[2][69][loop1].substring(0,30000);
	                cx1 = nm.carbon[2][69][loop1].substring(30000,60000);
	                cx2 = nm.carbon[2][69][loop1].substring(60000,nm.carbon[2][69][loop1].length());

                    ps.setString(70,cx0);
	                ps.setString(71,cx1);
	                ps.setString(72,cx2);

	            }//*******          
	            else{

	                cx0 = nm.carbon[2][69][loop1].substring(0,30000);
	                cx1 = nm.carbon[2][69][loop1].substring(30000,60000);
	                cx2 = nm.carbon[2][69][loop1].substring(60000,90000);

                    ps.setString(70,cx0);
                    ps.setString(71,cx1);
                    ps.setString(72,cx2);

	            }//*




                ps.setString(73,nm.carbon[2][70][loop1]);
                ps.setString(74,nm.carbon[2][71][loop1]);
                ps.setString(75,nm.carbon[2][72][loop1]);
                ps.setString(76,nm.carbon[2][73][loop1]);    
                ps.setString(77,nm.carbon[2][74][loop1]);
                ps.setString(78,nm.carbon[2][75][loop1]);
                ps.setString(79,nm.carbon[2][76][loop1]);
                ps.setString(80,nm.carbon[2][77][loop1]);
                ps.setString(81,nm.carbon[2][78][loop1]);
                ps.setString(82,nm.carbon[2][79][loop1]);
                ps.setString(83,nm.carbon[2][80][loop1]);
                ps.setString(84,nm.carbon[2][81][loop1]);
                ps.setString(85,nm.carbon[2][82][loop1]);           
                ps.setString(86,nm.carbon[2][83][loop1]);
                ps.setString(87,nm.carbon[2][84][loop1]);
                ps.setString(88,nm.carbon[2][85][loop1]);
                ps.setString(89,nm.carbon[2][86][loop1]);
                ps.setString(90,nm.carbon[2][87][loop1]);
                ps.setString(91,nm.carbon[2][88][loop1]);
                ps.setString(92,nm.carbon[2][89][loop1]);
                if(nm.carbon[2][93][loop1].length() > 199){nm.carbon[2][93][loop1] = nm.carbon[2][93][loop1].substring(0, 199);} ps.setString(93,nm.carbon[2][90][loop1]);
                ps.setString(94,nm.carbon[2][91][loop1]);
                ps.setString(95,nm.carbon[2][92][loop1]);           
                ps.setString(96,nm.carbon[2][93][loop1]);
                ps.setString(97,nm.carbon[2][94][loop1]);
                ps.setString(98,nm.carbon[2][95][loop1]);
                ps.setString(99,nm.carbon[2][96][loop1]);
                ps.setString(100,nm.carbon[2][97][loop1]);
                ps.setString(101,nm.carbon[2][98][loop1]);
                ps.setString(102,nm.carbon[2][99][loop1]);

	            numrows = numrows + ps.executeUpdate();


	        }//************************************************************

	        ps.close();


            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



        }catch(Exception e){e.printStackTrace();}




    }//save




}//last

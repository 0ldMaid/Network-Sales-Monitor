import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;



public class jdb_saver_items{

/* the default framework is embedded*/
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";


int ix0 = 0;
int ix1 = 0;

String cx0 = new String();
String cx1 = new String();
String cx2 = new String();




    jdb_saver_items(){//************************************************************************



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

	        ps = jdb_driver.conn.prepareStatement("insert into listings(address_1, address_2, address_3, address_4, address_5, address_6, buyer_id, buyers_email, buyers_first_name, buyers_last_name, buyers_notes, buyers_phone, currency, custom_1, custom_2, custom_3, custom_4, custom_5, custom_6, custom_7, custom_8, custom_9, custom_10, custom_11, custom_12, custom_13, custom_14, custom_15, custom_16, custom_17, custom_18, custom_19, custom_20, custom_21, custom_22, custom_23, custom_24, custom_25, custom_26, custom_27, custom_28, custom_29, custom_30, custom_31, custom_32, custom_33, custom_34, custom_35, custom_36, custom_37, custom_38, custom_39, custom_40, custom_41, custom_42, custom_43, custom_44, custom_45, custom_46, custom_template, date_last_modified, date_payment_received, date_shipped, date_sold, ebay_item, final_value_fee, handling, hits, item_cost, item_description1, item_description2, item_description3, item_id, item_price, item_weight, listing_fees, listing_id, notes, package_d, package_l, package_w, part_number, payment_type, paypal_fees, picture_1, quantity_sold, sale_id, sale_status, sales_tax, shipping_company, shipping_in, shipping_out, site_id, site_url, source_of_sale, title, title_url, total_on_hand, total_sale_amount, tracking_number, transaction_id, transaction_info) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

	        int numrows = 0;

	        for(int loop1 = 0; loop1 < nm.carbon[6][0].length; loop1++){//********************
                if(nm.carbon[6][0][loop1].length() == 0){nm.carbon[6][0][loop1] = new String("*");}
	        }//*******************************************************************************

	        for(int loop1 = 0; loop1 < nm.carbon[0][0].length; loop1++){//********************


                if(nm.carbon[0][13][loop1].length() > 2500){nm.carbon[0][13][loop1] = nm.carbon[0][13][loop1].substring(0, 2500);}


                ps.setString(1,nm.carbon[0][0][loop1]);
                ps.setString(2,nm.carbon[0][1][loop1]);
                ps.setString(3,nm.carbon[0][2][loop1]);
                ps.setString(4,nm.carbon[0][3][loop1]);
                ps.setString(5,nm.carbon[0][4][loop1]);
                ps.setString(6,nm.carbon[0][5][loop1]);
                ps.setString(7,nm.carbon[0][6][loop1]);
                ps.setString(8,nm.carbon[0][7][loop1]);
                ps.setString(9,nm.carbon[0][8][loop1]);
                ps.setString(10,nm.carbon[0][9][loop1]);           
                ps.setString(11,nm.carbon[0][10][loop1]);
                ps.setString(12,nm.carbon[0][11][loop1]);
                if(nm.carbon[0][12][loop1].length() > 2499){nm.carbon[0][12][loop1] = nm.carbon[0][12][loop1].substring(0, 199);} ps.setString(13,nm.carbon[0][12][loop1]);
                if(nm.carbon[0][13][loop1].length() > 2499){nm.carbon[0][13][loop1] = nm.carbon[0][13][loop1].substring(0, 199);} ps.setString(14,nm.carbon[0][13][loop1]);
                if(nm.carbon[0][14][loop1].length() > 499){nm.carbon[0][14][loop1] = nm.carbon[0][14][loop1].substring(0, 199);} ps.setString(15,nm.carbon[0][14][loop1]);
                if(nm.carbon[0][15][loop1].length() > 499){nm.carbon[0][15][loop1] = nm.carbon[0][15][loop1].substring(0, 199);} ps.setString(16,nm.carbon[0][15][loop1]);
                if(nm.carbon[0][16][loop1].length() > 199){nm.carbon[0][16][loop1] = nm.carbon[0][16][loop1].substring(0, 199);} ps.setString(17,nm.carbon[0][16][loop1]);
                if(nm.carbon[0][17][loop1].length() > 199){nm.carbon[0][17][loop1] = nm.carbon[0][17][loop1].substring(0, 199);} ps.setString(18,nm.carbon[0][17][loop1]);
                if(nm.carbon[0][18][loop1].length() > 199){nm.carbon[0][18][loop1] = nm.carbon[0][18][loop1].substring(0, 199);} ps.setString(19,nm.carbon[0][18][loop1]);
                if(nm.carbon[0][19][loop1].length() > 199){nm.carbon[0][19][loop1] = nm.carbon[0][19][loop1].substring(0, 199);} ps.setString(20,nm.carbon[0][19][loop1]);           
                if(nm.carbon[0][20][loop1].length() > 199){nm.carbon[0][20][loop1] = nm.carbon[0][20][loop1].substring(0, 199);} ps.setString(21,nm.carbon[0][20][loop1]);
                if(nm.carbon[0][21][loop1].length() > 199){nm.carbon[0][21][loop1] = nm.carbon[0][21][loop1].substring(0, 199);} ps.setString(22,nm.carbon[0][21][loop1]);
                if(nm.carbon[0][22][loop1].length() > 199){nm.carbon[0][22][loop1] = nm.carbon[0][22][loop1].substring(0, 199);} ps.setString(23,nm.carbon[0][22][loop1]);
                if(nm.carbon[0][23][loop1].length() > 199){nm.carbon[0][23][loop1] = nm.carbon[0][23][loop1].substring(0, 199);} ps.setString(24,nm.carbon[0][23][loop1]);
                if(nm.carbon[0][24][loop1].length() > 199){nm.carbon[0][24][loop1] = nm.carbon[0][24][loop1].substring(0, 199);} ps.setString(25,nm.carbon[0][24][loop1]);
                if(nm.carbon[0][25][loop1].length() > 199){nm.carbon[0][25][loop1] = nm.carbon[0][25][loop1].substring(0, 199);} ps.setString(26,nm.carbon[0][25][loop1]);
                if(nm.carbon[0][26][loop1].length() > 199){nm.carbon[0][26][loop1] = nm.carbon[0][26][loop1].substring(0, 199);} ps.setString(27,nm.carbon[0][26][loop1]);
                if(nm.carbon[0][27][loop1].length() > 199){nm.carbon[0][27][loop1] = nm.carbon[0][27][loop1].substring(0, 199);} ps.setString(28,nm.carbon[0][27][loop1]);
                if(nm.carbon[0][28][loop1].length() > 199){nm.carbon[0][28][loop1] = nm.carbon[0][28][loop1].substring(0, 199);} ps.setString(29,nm.carbon[0][28][loop1]);
                if(nm.carbon[0][29][loop1].length() > 199){nm.carbon[0][29][loop1] = nm.carbon[0][29][loop1].substring(0, 199);} ps.setString(30,nm.carbon[0][29][loop1]);
                if(nm.carbon[0][30][loop1].length() > 199){nm.carbon[0][30][loop1] = nm.carbon[0][30][loop1].substring(0, 199);} ps.setString(31,nm.carbon[0][30][loop1]);
                if(nm.carbon[0][31][loop1].length() > 199){nm.carbon[0][31][loop1] = nm.carbon[0][31][loop1].substring(0, 199);} ps.setString(32,nm.carbon[0][31][loop1]);
                if(nm.carbon[0][32][loop1].length() > 199){nm.carbon[0][32][loop1] = nm.carbon[0][32][loop1].substring(0, 199);} ps.setString(33,nm.carbon[0][32][loop1]);
                if(nm.carbon[0][33][loop1].length() > 199){nm.carbon[0][33][loop1] = nm.carbon[0][33][loop1].substring(0, 199);} ps.setString(34,nm.carbon[0][33][loop1]);
                if(nm.carbon[0][34][loop1].length() > 199){nm.carbon[0][34][loop1] = nm.carbon[0][34][loop1].substring(0, 199);} ps.setString(35,nm.carbon[0][34][loop1]);           
                if(nm.carbon[0][35][loop1].length() > 199){nm.carbon[0][35][loop1] = nm.carbon[0][35][loop1].substring(0, 199);} ps.setString(36,nm.carbon[0][35][loop1]);
                if(nm.carbon[0][36][loop1].length() > 199){nm.carbon[0][36][loop1] = nm.carbon[0][36][loop1].substring(0, 199);} ps.setString(37,nm.carbon[0][36][loop1]);
                if(nm.carbon[0][37][loop1].length() > 199){nm.carbon[0][37][loop1] = nm.carbon[0][37][loop1].substring(0, 199);} ps.setString(38,nm.carbon[0][37][loop1]);
                if(nm.carbon[0][38][loop1].length() > 199){nm.carbon[0][38][loop1] = nm.carbon[0][38][loop1].substring(0, 199);} ps.setString(39,nm.carbon[0][38][loop1]);
                if(nm.carbon[0][39][loop1].length() > 199){nm.carbon[0][39][loop1] = nm.carbon[0][39][loop1].substring(0, 199);} ps.setString(40,nm.carbon[0][39][loop1]);
                if(nm.carbon[0][40][loop1].length() > 199){nm.carbon[0][40][loop1] = nm.carbon[0][40][loop1].substring(0, 199);} ps.setString(41,nm.carbon[0][40][loop1]);
                if(nm.carbon[0][41][loop1].length() > 199){nm.carbon[0][41][loop1] = nm.carbon[0][41][loop1].substring(0, 199);} ps.setString(42,nm.carbon[0][41][loop1]);
                if(nm.carbon[0][42][loop1].length() > 199){nm.carbon[0][42][loop1] = nm.carbon[0][42][loop1].substring(0, 199);} ps.setString(43,nm.carbon[0][42][loop1]);
                if(nm.carbon[0][43][loop1].length() > 199){nm.carbon[0][43][loop1] = nm.carbon[0][43][loop1].substring(0, 199);} ps.setString(44,nm.carbon[0][43][loop1]);
                if(nm.carbon[0][44][loop1].length() > 199){nm.carbon[0][44][loop1] = nm.carbon[0][44][loop1].substring(0, 199);} ps.setString(45,nm.carbon[0][44][loop1]);           
                if(nm.carbon[0][45][loop1].length() > 199){nm.carbon[0][45][loop1] = nm.carbon[0][45][loop1].substring(0, 199);} ps.setString(46,nm.carbon[0][45][loop1]);
                if(nm.carbon[0][46][loop1].length() > 199){nm.carbon[0][46][loop1] = nm.carbon[0][46][loop1].substring(0, 199);} ps.setString(47,nm.carbon[0][46][loop1]);
                if(nm.carbon[0][47][loop1].length() > 199){nm.carbon[0][47][loop1] = nm.carbon[0][47][loop1].substring(0, 199);} ps.setString(48,nm.carbon[0][47][loop1]);
                if(nm.carbon[0][48][loop1].length() > 199){nm.carbon[0][48][loop1] = nm.carbon[0][48][loop1].substring(0, 199);} ps.setString(49,nm.carbon[0][48][loop1]);
                if(nm.carbon[0][49][loop1].length() > 199){nm.carbon[0][49][loop1] = nm.carbon[0][49][loop1].substring(0, 199);} ps.setString(50,nm.carbon[0][49][loop1]);   
                if(nm.carbon[0][50][loop1].length() > 199){nm.carbon[0][50][loop1] = nm.carbon[0][50][loop1].substring(0, 199);} ps.setString(51,nm.carbon[0][50][loop1]);
                if(nm.carbon[0][51][loop1].length() > 199){nm.carbon[0][51][loop1] = nm.carbon[0][51][loop1].substring(0, 199);} ps.setString(52,nm.carbon[0][51][loop1]);
                if(nm.carbon[0][52][loop1].length() > 199){nm.carbon[0][52][loop1] = nm.carbon[0][52][loop1].substring(0, 199);} ps.setString(53,nm.carbon[0][52][loop1]);
                if(nm.carbon[0][53][loop1].length() > 199){nm.carbon[0][53][loop1] = nm.carbon[0][53][loop1].substring(0, 199);} ps.setString(54,nm.carbon[0][53][loop1]);
                if(nm.carbon[0][54][loop1].length() > 199){nm.carbon[0][54][loop1] = nm.carbon[0][54][loop1].substring(0, 199);} ps.setString(55,nm.carbon[0][54][loop1]);
                if(nm.carbon[0][55][loop1].length() > 199){nm.carbon[0][55][loop1] = nm.carbon[0][55][loop1].substring(0, 199);} ps.setString(56,nm.carbon[0][55][loop1]);
                if(nm.carbon[0][56][loop1].length() > 199){nm.carbon[0][56][loop1] = nm.carbon[0][56][loop1].substring(0, 199);} ps.setString(57,nm.carbon[0][56][loop1]);
                if(nm.carbon[0][57][loop1].length() > 199){nm.carbon[0][57][loop1] = nm.carbon[0][57][loop1].substring(0, 199);} ps.setString(58,nm.carbon[0][57][loop1]);
                ps.setString(59,nm.carbon[0][58][loop1]);           
                ps.setString(60,nm.carbon[0][59][loop1]);
                ps.setString(61,nm.carbon[0][60][loop1]);
                ps.setString(62,nm.carbon[0][61][loop1]);
                ps.setString(63,nm.carbon[0][62][loop1]);
                ps.setString(64,nm.carbon[0][63][loop1]);
                if(nm.carbon[0][64][loop1].length() > 59){nm.carbon[0][64][loop1] = nm.carbon[0][64][loop1].substring(0, 59);} ps.setString(65,nm.carbon[0][64][loop1]);
                ps.setString(66,nm.carbon[0][65][loop1]);
                ps.setString(67,nm.carbon[0][66][loop1]);
                ps.setString(68,nm.carbon[0][67][loop1]);
                ps.setString(69,nm.carbon[0][68][loop1]);



	            nm.carbon[0][69][loop1] = nm.carbon[0][69][loop1].replace("\r\n", " ").replace("\n", " ");



	            if(nm.carbon[0][69][loop1].length() < 30000){

                    ps.setString(70,nm.carbon[0][69][loop1]);
	                ps.setString(71,"");
	                ps.setString(72,"");

	            }//******************************************
	            else if(nm.carbon[0][69][loop1].length() > 30000  && nm.carbon[0][69][loop1].length() < 60000){

                    cx0 = nm.carbon[0][69][loop1].substring(0,30000);
	                cx1 = nm.carbon[0][69][loop1].substring(30000,nm.carbon[0][69][loop1].length());

                    ps.setString(70,cx0);
	                ps.setString(71,cx1);
	                ps.setString(72,"");

	            }//***************************************************************************************
	            else if(nm.carbon[0][69][loop1].length() > 60000  && nm.carbon[0][69][loop1].length() < 90000){

	                cx0 = nm.carbon[0][69][loop1].substring(0,30000);
	                cx1 = nm.carbon[0][69][loop1].substring(30000,60000);
	                cx2 = nm.carbon[0][69][loop1].substring(60000,nm.carbon[0][69][loop1].length());

                    ps.setString(70,cx0);
	                ps.setString(71,cx1);
	                ps.setString(72,cx2);

	            }//*******          
	            else{

	                cx0 = nm.carbon[0][69][loop1].substring(0,30000);
	                cx1 = nm.carbon[0][69][loop1].substring(30000,60000);
	                cx2 = nm.carbon[0][69][loop1].substring(60000,90000);

                    ps.setString(70,cx0);
                    ps.setString(71,cx1);
                    ps.setString(72,cx2);

	            }//*




                ps.setString(73,nm.carbon[0][70][loop1]);
                ps.setString(74,nm.carbon[0][71][loop1]);
                ps.setString(75,nm.carbon[0][72][loop1]);
                ps.setString(76,nm.carbon[0][73][loop1]);    
                ps.setString(77,nm.carbon[0][74][loop1]);
                ps.setString(78,nm.carbon[0][75][loop1]);
                ps.setString(79,nm.carbon[0][76][loop1]);
                ps.setString(80,nm.carbon[0][77][loop1]);
                ps.setString(81,nm.carbon[0][78][loop1]);
                ps.setString(82,nm.carbon[0][79][loop1]);
                ps.setString(83,nm.carbon[0][80][loop1]);
                ps.setString(84,nm.carbon[0][81][loop1]);
                ps.setString(85,nm.carbon[0][82][loop1]);           
                ps.setString(86,nm.carbon[0][83][loop1]);
                ps.setString(87,nm.carbon[0][84][loop1]);
                ps.setString(88,nm.carbon[0][85][loop1]);
                ps.setString(89,nm.carbon[0][86][loop1]);
                ps.setString(90,nm.carbon[0][87][loop1]);
                ps.setString(91,nm.carbon[0][88][loop1]);
                ps.setString(92,nm.carbon[0][89][loop1]);
                if(nm.carbon[0][93][loop1].length() > 199){nm.carbon[0][93][loop1] = nm.carbon[0][93][loop1].substring(0, 199);} ps.setString(93,nm.carbon[0][90][loop1]);
                ps.setString(94,nm.carbon[0][91][loop1]);
                ps.setString(95,nm.carbon[0][92][loop1]);           
                ps.setString(96,nm.carbon[0][93][loop1]);
                ps.setString(97,nm.carbon[0][94][loop1]);
                ps.setString(98,nm.carbon[0][95][loop1]);
                ps.setString(99,nm.carbon[0][96][loop1]);
                ps.setString(100,nm.carbon[0][97][loop1]);
                ps.setString(101,nm.carbon[0][98][loop1]);
                ps.setString(102,nm.carbon[0][99][loop1]);

	            numrows = numrows + ps.executeUpdate();


	        }//************************************************************

	        ps.close();


            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



        }catch(Exception e){e.printStackTrace();}




    }//save




}//last

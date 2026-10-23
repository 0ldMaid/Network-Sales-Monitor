import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;



public class jdb_new_sale{

/* the default framework is embedded*/
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";


int ix0 = 0;
int ix1 = 0;











    jdb_new_sale (String[] new_item) {//************************************************************************



        try {


            //and add a few rows...
            PreparedStatement ps = null;
            int numrows = 0;


            ps = jdb_driver.conn.prepareStatement("INSERT INTO archived_sales_ids(ids) values(?)");

            ps.setString(1, new_item[nm.sale_id_xx]);

            numrows = numrows + ps.executeUpdate();



            //reload the list
            System.out.println("Load Settings.");
            jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT ids FROM archived_sales_ids ORDER BY ids");

            jdb_driver.rs.last();
            int rowCount2 = jdb_driver.rs.getRow();
            nm.jdb_load_sales_ids = new String[rowCount2];

            jdb_driver.rs.beforeFirst();

            ix0 = 0;
            while(jdb_driver.rs.next()){

                nm.jdb_load_sales_ids[ix0] = new String(jdb_driver.rs.getString(1));
                //System.out.println("LOADER " + nm.jdb_load_sales_ids[ix0]);

                ix0++;

            }//while********************



            ps = jdb_driver.conn.prepareStatement("INSERT INTO sold(address_1, address_2, address_3, address_4, address_5, address_6, buyer_id, buyers_email, buyers_first_name, buyers_last_name, buyers_notes, buyers_phone, currency, custom_1, custom_2, custom_3, custom_4, custom_5, custom_6, custom_7, custom_8, custom_9, custom_10, custom_11, custom_12, custom_13, custom_14, custom_15, custom_16, custom_17, custom_18, custom_19, custom_20, custom_21, custom_22, custom_23, custom_24, custom_25, custom_26, custom_27, custom_28, custom_29, custom_30, custom_31, custom_32, custom_33, custom_34, custom_35, custom_36, custom_37, custom_38, custom_39, custom_40, custom_41, custom_42, custom_43, custom_44, custom_45, custom_46, custom_template, date_last_modified, date_payment_received, date_shipped, date_sold, ebay_item, final_value_fee, handling, hits, item_cost, item_description, item_id, item_price, item_weight, listing_fees, listing_id, notes, package_d, package_l, package_w, part_number, payment_type, paypal_fees, picture_1, quantity_sold, sale_id, sale_status, sales_tax, shipping_company, shipping_in, shipping_out, site_id, site_url, source_of_sale, title, title_url, total_on_hand, total_sale_amount, tracking_number, transaction_id, transaction_info) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");


            ps.setString(1,new_item[0]);
            ps.setString(2,new_item[1]);
            ps.setString(3,new_item[2]);
            ps.setString(4,new_item[3]);
            ps.setString(5,new_item[4]);
            ps.setString(6,new_item[5]);
            ps.setString(7,new_item[6]);
            ps.setString(8,new_item[7]);
            ps.setString(9,new_item[8]);
            ps.setString(10,new_item[9]);           
            ps.setString(11,new_item[10]);
            ps.setString(12,new_item[11]);
            ps.setString(13,new_item[12]);
            ps.setString(14,new_item[13]);
            ps.setString(15,new_item[14]);
            ps.setString(16,new_item[15]);
            ps.setString(17,new_item[16]);
            ps.setString(18,new_item[17]);
            ps.setString(19,new_item[18]);
            ps.setString(20,new_item[19]);           
            ps.setString(21,new_item[20]);
            ps.setString(22,new_item[21]);
            ps.setString(23,new_item[22]);
            ps.setString(24,new_item[23]);
            ps.setString(25,new_item[24]);
            ps.setString(26,new_item[25]);
            ps.setString(27,new_item[26]);
            ps.setString(28,new_item[27]);
            ps.setString(29,new_item[28]);
            ps.setString(30,new_item[29]);
            ps.setString(31,new_item[30]);
            ps.setString(32,new_item[31]);
            ps.setString(33,new_item[32]);
            ps.setString(34,new_item[33]);
            ps.setString(35,new_item[34]);           
            ps.setString(36,new_item[35]);
            ps.setString(37,new_item[36]);
            ps.setString(38,new_item[37]);
            ps.setString(39,new_item[38]);
            ps.setString(40,new_item[39]);
            ps.setString(41,new_item[40]);
            ps.setString(42,new_item[41]);
            ps.setString(43,new_item[42]);
            ps.setString(44,new_item[43]);
            ps.setString(45,new_item[44]);           
            ps.setString(46,new_item[45]);
            ps.setString(47,new_item[46]);
            ps.setString(48,new_item[47]);
            ps.setString(49,new_item[48]);
            ps.setString(50,new_item[49]);   
            ps.setString(51,new_item[50]);
            ps.setString(52,new_item[51]);
            ps.setString(53,new_item[52]);
            ps.setString(54,new_item[53]);
            ps.setString(55,new_item[54]);
            ps.setString(56,new_item[55]);
            ps.setString(57,new_item[56]);
            ps.setString(58,new_item[57]);
            ps.setString(59,new_item[58]);           
            ps.setString(60,new_item[59]);
            ps.setString(61,new_item[60]);
            ps.setString(62,new_item[61]);
            ps.setString(63,new_item[62]);
            ps.setString(64,new_item[63]);
            ps.setString(65,new_item[64]);
            ps.setString(66,new_item[65]);
            ps.setString(67,new_item[66]);
            ps.setString(68,new_item[67]);
            ps.setString(69,new_item[68]);
            ps.setString(70,new_item[69]);
            ps.setString(71,new_item[70]);
            ps.setString(72,new_item[71]);
            ps.setString(73,new_item[72]);    
            ps.setString(74,new_item[73]);
            ps.setString(75,new_item[74]);
            ps.setString(76,new_item[75]);
            ps.setString(77,new_item[76]);
            ps.setString(78,new_item[77]);
            ps.setString(79,new_item[78]);
            ps.setString(80,new_item[79]);
            ps.setString(81,new_item[80]);
            ps.setString(82,new_item[81]);           
            ps.setString(83,new_item[82]);
            ps.setString(84,new_item[83]);
            ps.setString(85,new_item[84]);
            ps.setString(86,new_item[85]);
            ps.setString(87,new_item[86]);
            ps.setString(88,new_item[87]);
            ps.setString(89,new_item[88]);
            ps.setString(90,new_item[89]);
            ps.setString(91,new_item[90]);
            ps.setString(92,new_item[91]);           
            ps.setString(93,new_item[92]);
            ps.setString(94,new_item[93]);
            ps.setString(95,new_item[94]);
            ps.setString(96,new_item[95]);
            ps.setString(97,new_item[96]);
            ps.setString(98,new_item[97]);
            ps.setString(99,new_item[98]);
            ps.setString(100,new_item[99]);

            numrows = numrows + ps.executeUpdate();




            ps.close();


            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



        } catch (Exception e) {e.printStackTrace();}




    }//save









    jdb_new_sale (String[][] new_item) {//************************************************************************



        try{


            //and add a few rows...
	        PreparedStatement ps = null;
            int numrows = 0;


            ps = jdb_driver.conn.prepareStatement("INSERT INTO archived_sales_ids(ids) values(?)");

            
            for(int loop1 = 0; loop1 < new_item[0].length; loop1++){//********************

                ps.setString(1, new_item[nm.sale_id_xx][loop1]);

                numrows = numrows + ps.executeUpdate();

            }//***************************************************************************


            //reload the list
            System.out.println("Load Settings.");
            jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            jdb_driver.rs = jdb_driver.s.executeQuery("SELECT ids FROM archived_sales_ids ORDER BY ids");

            jdb_driver.rs.last();
            int rowCount2 = jdb_driver.rs.getRow();
            nm.jdb_load_sales_ids = new String[rowCount2];

            jdb_driver.rs.beforeFirst();

            ix0 = 0;
            while(jdb_driver.rs.next()){

                nm.jdb_load_sales_ids[ix0] = new String(jdb_driver.rs.getString(1));
                //System.out.println("LOADER " + nm.jdb_load_sales_ids[ix0]);

                ix0++;

            }//while********************








	        ps = jdb_driver.conn.prepareStatement("INSERT INTO sold(address_1, address_2, address_3, address_4, address_5, address_6, buyer_id, buyers_email, buyers_first_name, buyers_last_name, buyers_notes, buyers_phone, currency, custom_1, custom_2, custom_3, custom_4, custom_5, custom_6, custom_7, custom_8, custom_9, custom_10, custom_11, custom_12, custom_13, custom_14, custom_15, custom_16, custom_17, custom_18, custom_19, custom_20, custom_21, custom_22, custom_23, custom_24, custom_25, custom_26, custom_27, custom_28, custom_29, custom_30, custom_31, custom_32, custom_33, custom_34, custom_35, custom_36, custom_37, custom_38, custom_39, custom_40, custom_41, custom_42, custom_43, custom_44, custom_45, custom_46, custom_template, date_last_modified, date_payment_received, date_shipped, date_sold, ebay_item, final_value_fee, handling, hits, item_cost, item_description, item_id, item_price, item_weight, listing_fees, listing_id, notes, package_d, package_l, package_w, part_number, payment_type, paypal_fees, picture_1, quantity_sold, sale_id, sale_status, sales_tax, shipping_company, shipping_in, shipping_out, site_id, site_url, source_of_sale, title, title_url, total_on_hand, total_sale_amount, tracking_number, transaction_id, transaction_info) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

	        for (int loop1 = 0; loop1 < new_item[0].length; loop1++) {//********************


                ps.setString(1,new_item[0][loop1]);
                ps.setString(2,new_item[1][loop1]);
                ps.setString(3,new_item[2][loop1]);
                ps.setString(4,new_item[3][loop1]);
                ps.setString(5,new_item[4][loop1]);
                ps.setString(6,new_item[5][loop1]);
                ps.setString(7,new_item[6][loop1]);
                ps.setString(8,new_item[7][loop1]);
                ps.setString(9,new_item[8][loop1]);
                ps.setString(10,new_item[9][loop1]);           
                ps.setString(11,new_item[10][loop1]);
                ps.setString(12,new_item[11][loop1]);
                ps.setString(13,new_item[12][loop1]);
                ps.setString(14,new_item[13][loop1]);
                ps.setString(15,new_item[14][loop1]);
                ps.setString(16,new_item[15][loop1]);
                ps.setString(17,new_item[16][loop1]);
                ps.setString(18,new_item[17][loop1]);
                ps.setString(19,new_item[18][loop1]);
                ps.setString(20,new_item[19][loop1]);           
                ps.setString(21,new_item[20][loop1]);
                ps.setString(22,new_item[21][loop1]);
                ps.setString(23,new_item[22][loop1]);
                ps.setString(24,new_item[23][loop1]);
                ps.setString(25,new_item[24][loop1]);
                ps.setString(26,new_item[25][loop1]);
                ps.setString(27,new_item[26][loop1]);
                ps.setString(28,new_item[27][loop1]);
                ps.setString(29,new_item[28][loop1]);
                ps.setString(30,new_item[29][loop1]);
                ps.setString(31,new_item[30][loop1]);
                ps.setString(32,new_item[31][loop1]);
                ps.setString(33,new_item[32][loop1]);
                ps.setString(34,new_item[33][loop1]);
                ps.setString(35,new_item[34][loop1]);           
                ps.setString(36,new_item[35][loop1]);
                ps.setString(37,new_item[36][loop1]);
                ps.setString(38,new_item[37][loop1]);
                ps.setString(39,new_item[38][loop1]);
                ps.setString(40,new_item[39][loop1]);
                ps.setString(41,new_item[40][loop1]);
                ps.setString(42,new_item[41][loop1]);
                ps.setString(43,new_item[42][loop1]);
                ps.setString(44,new_item[43][loop1]);
                ps.setString(45,new_item[44][loop1]);           
                ps.setString(46,new_item[45][loop1]);
                ps.setString(47,new_item[46][loop1]);
                ps.setString(48,new_item[47][loop1]);
                ps.setString(49,new_item[48][loop1]);
                ps.setString(50,new_item[49][loop1]);   
                ps.setString(51,new_item[50][loop1]);
                ps.setString(52,new_item[51][loop1]);
                ps.setString(53,new_item[52][loop1]);
                ps.setString(54,new_item[53][loop1]);
                ps.setString(55,new_item[54][loop1]);
                ps.setString(56,new_item[55][loop1]);
                ps.setString(57,new_item[56][loop1]);
                ps.setString(58,new_item[57][loop1]);
                ps.setString(59,new_item[58][loop1]);           
                ps.setString(60,new_item[59][loop1]);
                ps.setString(61,new_item[60][loop1]);
                ps.setString(62,new_item[61][loop1]);
                ps.setString(63,new_item[62][loop1]);
                ps.setString(64,new_item[63][loop1]);
                ps.setString(65,new_item[64][loop1]);
                ps.setString(66,new_item[65][loop1]);
                ps.setString(67,new_item[66][loop1]);
                ps.setString(68,new_item[67][loop1]);
                ps.setString(69,new_item[68][loop1]);
                ps.setString(70,new_item[69][loop1]);
                ps.setString(71,new_item[70][loop1]);
                ps.setString(72,new_item[71][loop1]);
                ps.setString(73,new_item[72][loop1]);    
                ps.setString(74,new_item[73][loop1]);
                ps.setString(75,new_item[74][loop1]);
                ps.setString(76,new_item[75][loop1]);
                ps.setString(77,new_item[76][loop1]);
                ps.setString(78,new_item[77][loop1]);
                ps.setString(79,new_item[78][loop1]);
                ps.setString(80,new_item[79][loop1]);
                ps.setString(81,new_item[80][loop1]);
                ps.setString(82,new_item[81][loop1]);           
                ps.setString(83,new_item[82][loop1]);
                ps.setString(84,new_item[83][loop1]);
                ps.setString(85,new_item[84][loop1]);
                ps.setString(86,new_item[85][loop1]);
                ps.setString(87,new_item[86][loop1]);
                ps.setString(88,new_item[87][loop1]);
                ps.setString(89,new_item[88][loop1]);
                ps.setString(90,new_item[89][loop1]);
                ps.setString(91,new_item[90][loop1]);
                ps.setString(92,new_item[91][loop1]);           
                ps.setString(93,new_item[92][loop1]);
                ps.setString(94,new_item[93][loop1]);
                ps.setString(95,new_item[94][loop1]);
                ps.setString(96,new_item[95][loop1]);
                ps.setString(97,new_item[96][loop1]);
                ps.setString(98,new_item[97][loop1]);
                ps.setString(99,new_item[98][loop1]);
                ps.setString(100,new_item[99][loop1]);

	            numrows = numrows + ps.executeUpdate();


	        }//************************************************************

	        ps.close();


            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



        } catch (Exception e) {e.printStackTrace();}




    }//save




}//last

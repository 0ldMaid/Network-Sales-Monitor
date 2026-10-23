import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;



public class jdb_edit_archive {

/* the default framework is embedded*/
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";



    jdb_edit_archive(String[][] new_item) {//************************************************************************



        try {


            //and add a few rows...

            PreparedStatement ps = null;

            ps = jdb_driver.conn.prepareStatement("UPDATE archived SET address_1 = ?, address_2 = ?, address_3 = ?, address_4 = ?, address_5 = ?, address_6 = ?, buyer_id = ?, buyers_email = ?, buyers_first_name = ?, buyers_last_name = ?, buyers_notes = ?, buyers_phone = ?, currency = ?, custom_1 = ?, custom_2 = ?, custom_3 = ?, custom_4 = ?, custom_5 = ?, custom_6 = ?, custom_7 = ?, custom_8 = ?, custom_9 = ?, custom_10 = ?, custom_11 = ?, custom_12 = ?, custom_13 = ?, custom_14 = ?, custom_15 = ?, custom_16 = ?, custom_17 = ?, custom_18 = ?, custom_19 = ?, custom_20 = ?, custom_21 = ?, custom_22 = ?, custom_23 = ?, custom_24 = ?, custom_25 = ?, custom_26 = ?, custom_27 = ?, custom_28 = ?, custom_29 = ?, custom_30 = ?, custom_31 = ?, custom_32 = ?, custom_33 = ?, custom_34 = ?, custom_35 = ?, custom_36 = ?, custom_37 = ?, custom_38 = ?, custom_39 = ?, custom_40 = ?, custom_41 = ?, custom_42 = ?, custom_43 = ?, custom_44 = ?, custom_45 = ?, custom_46 = ?, custom_template = ?, date_last_modified = ?, date_payment_received = ?, date_shipped = ?, date_sold = ?, ebay_item = ?, final_value_fee = ?, handling = ?, hits = ?, item_cost = ?, item_description = ?, item_id = ?, item_price = ?, item_weight = ?, listing_fees = ?, listing_id = ?, notes = ?, package_d = ?, package_l = ?, package_w = ?, part_number = ?, payment_type = ?, paypal_fees = ?, picture_1 = ?, quantity_sold = ?, sale_id = ?, sale_status = ?, sales_tax = ?, shipping_company = ?, shipping_in = ?, shipping_out = ?, site_id = ?, site_url = ?, source_of_sale = ?, title = ?, title_url = ?, total_on_hand = ?, total_sale_amount = ?, tracking_number = ?, transaction_id = ?, transaction_info = ? WHERE sale_id='" + new_item[nm.sale_id_xx][0] + "'");

            int numrows = 0;

            System.out.println("Sale ID " + new_item[nm.sale_id_xx][0]);

            if (new_item[13][0].length() > 2500) {new_item[13][0] = new_item[13][0].substring(0, 2500);}


            ps.setString(1,new_item[0][0]);
            ps.setString(2,new_item[1][0]);
            ps.setString(3,new_item[2][0]);
            ps.setString(4,new_item[3][0]);
            ps.setString(5,new_item[4][0]);
            ps.setString(6,new_item[5][0]);
            ps.setString(7,new_item[6][0]);
            ps.setString(8,new_item[7][0]);
            ps.setString(9,new_item[8][0]);
            ps.setString(10,new_item[9][0]);           
            ps.setString(11,new_item[10][0]);
            ps.setString(12,new_item[11][0]);
            ps.setString(13,new_item[12][0]);
            ps.setString(14,new_item[13][0]);
            ps.setString(15,new_item[14][0]);
            ps.setString(16,new_item[15][0]);
            ps.setString(17,new_item[16][0]);
            ps.setString(18,new_item[17][0]);
            ps.setString(19,new_item[18][0]);
            ps.setString(20,new_item[19][0]);           
            ps.setString(21,new_item[20][0]);
            ps.setString(22,new_item[21][0]);
            ps.setString(23,new_item[22][0]);
            ps.setString(24,new_item[23][0]);
            ps.setString(25,new_item[24][0]);
            ps.setString(26,new_item[25][0]);
            ps.setString(27,new_item[26][0]);
            ps.setString(28,new_item[27][0]);
            ps.setString(29,new_item[28][0]);
            ps.setString(30,new_item[29][0]);
            ps.setString(31,new_item[30][0]);
            ps.setString(32,new_item[31][0]);
            ps.setString(33,new_item[32][0]);
            ps.setString(34,new_item[33][0]);
            ps.setString(35,new_item[34][0]);           
            ps.setString(36,new_item[35][0]);
            ps.setString(37,new_item[36][0]);
            ps.setString(38,new_item[37][0]);
            ps.setString(39,new_item[38][0]);
            ps.setString(40,new_item[39][0]);
            ps.setString(41,new_item[40][0]);
            ps.setString(42,new_item[41][0]);
            ps.setString(43,new_item[42][0]);
            ps.setString(44,new_item[43][0]);
            ps.setString(45,new_item[44][0]);           
            ps.setString(46,new_item[45][0]);
            ps.setString(47,new_item[46][0]);
            ps.setString(48,new_item[47][0]);
            ps.setString(49,new_item[48][0]);
            ps.setString(50,new_item[49][0]);   
            ps.setString(51,new_item[50][0]);
            ps.setString(52,new_item[51][0]);
            ps.setString(53,new_item[52][0]);
            ps.setString(54,new_item[53][0]);
            ps.setString(55,new_item[54][0]);
            ps.setString(56,new_item[55][0]);
            ps.setString(57,new_item[56][0]);
            ps.setString(58,new_item[57][0]);
            ps.setString(59,new_item[58][0]);           
            ps.setString(60,new_item[59][0]);
            ps.setString(61,new_item[60][0]);
            ps.setString(62,new_item[61][0]);
            ps.setString(63,new_item[62][0]);
            ps.setString(64,new_item[63][0]);
            ps.setString(65,new_item[64][0]);
            ps.setString(66,new_item[65][0]);
            ps.setString(67,new_item[66][0]);
            ps.setString(68,new_item[67][0]);
            ps.setString(69,new_item[68][0]);
            ps.setString(70,new_item[69][0]);
            ps.setString(71,new_item[70][0]);
            ps.setString(72,new_item[71][0]);
            ps.setString(73,new_item[72][0]);    
            ps.setString(74,new_item[73][0]);
            ps.setString(75,new_item[74][0]);
            ps.setString(76,new_item[75][0]);
            ps.setString(77,new_item[76][0]);
            ps.setString(78,new_item[77][0]);
            ps.setString(79,new_item[78][0]);
            ps.setString(80,new_item[79][0]);
            ps.setString(81,new_item[80][0]);
            ps.setString(82,new_item[81][0]);           
            ps.setString(83,new_item[82][0]);
            ps.setString(84,new_item[83][0]);
            ps.setString(85,new_item[84][0]);
            ps.setString(86,new_item[85][0]);
            ps.setString(87,new_item[86][0]);
            ps.setString(88,new_item[87][0]);
            ps.setString(89,new_item[88][0]);
            ps.setString(90,new_item[89][0]);
            ps.setString(91,new_item[90][0]);
            ps.setString(92,new_item[91][0]);           
            ps.setString(93,new_item[92][0]);
            ps.setString(94,new_item[93][0]);
            ps.setString(95,new_item[94][0]);
            ps.setString(96,new_item[95][0]);
            ps.setString(97,new_item[96][0]);
            ps.setString(98,new_item[97][0]);
            ps.setString(99,new_item[98][0]);
            ps.setString(100,new_item[99][0]);


            numrows = numrows + ps.executeUpdate();

            ps.close();

            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



        } catch (Exception e) {e.printStackTrace();}




    }//save




}//last

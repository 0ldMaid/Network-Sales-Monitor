import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.io.*;
import java.security.*;
import org.json.simple.JSONObject;





public class jdb_driver{

/* the default framework is embedded*/
static String framework = "embedded";
static String driver = "org.apache.derby.jdbc.EmbeddedDriver";
static String protocol = "jdbc:derby:";

int worm_size = 10;
String base58 = new String("");
KeyPair keyPair;

static ArrayList<Statement> statements = new ArrayList<Statement>(); // list of Statements, 
static PreparedStatement psInsert = null;
static PreparedStatement psUpdate = null;

static Statement s = null;//load network
static Statement s2 = null;//load
//static Statement se = null;//edit

static ResultSet rs = null;
static ResultSet rs2 = null; 
//static ResultSet rse = null;//edit

static Connection conn = null;





jdb_driver(){//************************************************************************

    /* parse the arguments to determine which framework is desired*/
    //parseArguments(args);

    System.out.println("JDB saving starting in " + framework + " mode");

    /* load the desired JDBC driver */
    loadDriver();



    try {


        Properties props = new Properties(); // connection properties
        // providing a user name and password is optional in the embedded
        // and derbyclient frameworks

        //props.put("user", "user1");
        //props.put("password", "pass1");

        /* By default, the schema APP will be used when no username is
         * provided.
         * Otherwise, the schema name is the same as the user name (in this
         * case "user1" or USER1.)
         *
         * Note that user authentication is off by default, meaning that any
         * user can connect to your database using any password. To enable
         * authentication, see the Derby Developer's Guide.
         */

        String dbName = "ALCHEMIST"; // the name of the database

        /*
         * This connection specifies create=true in the connection URL to
         * cause the database to be created when connecting for the first
         * time. To remove the database, remove the directory derbyDB (the
         * same as the database name) and its contents.
         *
         * The directory derbyDB will be created under the directory that
         * the system property derby.system.home points to, or the current
         * directory (user.dir) if derby.system.home is not set.
         */



        conn = DriverManager.getConnection(protocol + dbName + ";create=true", props);

        System.out.println("Connected to and created database " + dbName);

        // We want to control transactions manually. Autocommit is on by
        // default in JDBC.
        conn.setAutoCommit(false);

        /* Creating a statement object that we can use for running various
         * SQL statements commands against the database.*/
        s = conn.createStatement();
        statements.add(s);
        s2 = conn.createStatement();
        statements.add(s2);
        //se = conn.createStatement();
        //statements.add(se);


        //this should fail if no database is found
        rs = s.executeQuery("SELECT xd FROM settings");


        conn.commit();
        System.out.println("Committed the transaction");



    } catch (SQLException se) {

        System.out.println("No database!"); 
        jdb_build_database(); 
        build_settings();

    }



    //Set some other info
    set_db_string();

    set_new_item_db_string();
    
    build_settings_list();
    
    set_numbers();


}//database










    public void set_numbers() {
    

        System.out.println("SET NUMBERS************************************************************");

        nm.address_1_xx = 0;
        nm.address_2_xx = 1;
        nm.address_3_xx = 2;
        nm.address_4_xx = 3;
        nm.address_5_xx = 4;
        nm.address_6_xx = 5;
        nm.buyer_id_xx = 6;
        nm.buyers_email_xx = 7;
        nm.buyers_first_name_xx = 8;
        nm.buyers_last_name_xx = 9;
        nm.buyers_notes_xx = 10;
        nm.buyers_phone_xx = 11;
        nm.currency_xx = 12;
        nm.custom_1_xx = 13;
        nm.custom_2_xx = 14;
        nm.custom_3_xx = 15;
        nm.custom_4_xx = 16;
        nm.custom_5_xx = 17;
        nm.custom_6_xx = 18;
        nm.custom_7_xx = 19;
        nm.custom_8_xx = 20;
        nm.custom_9_xx = 21;
        nm.custom_10_xx = 22;
        nm.custom_11_xx = 23;
        nm.custom_12_xx = 24;
        nm.custom_13_xx = 25;
        nm.custom_14_xx = 26;
        nm.custom_15_xx = 27;
        nm.custom_16_xx = 28;
        nm.custom_17_xx = 29;
        nm.custom_18_xx = 30;
        nm.custom_19_xx = 31;
        nm.custom_20_xx = 32;
        nm.custom_21_xx = 33;
        nm.custom_22_xx = 34;
        nm.custom_23_xx = 35;
        nm.custom_24_xx = 36;
        nm.custom_25_xx = 37;
        nm.custom_26_xx = 38;
        nm.custom_27_xx = 39;
        nm.custom_28_xx = 40;
        nm.custom_29_xx = 41;
        nm.custom_30_xx = 42;
        nm.custom_31_xx = 43;
        nm.custom_32_xx = 44;
        nm.custom_33_xx = 45;
        nm.custom_34_xx = 46;
        nm.custom_35_xx = 47;
        nm.custom_36_xx = 48;
        nm.custom_37_xx = 49;
        nm.custom_38_xx = 50;
        nm.custom_39_xx = 51;
        nm.custom_40_xx = 52;
        nm.custom_41_xx = 53;
        nm.custom_42_xx = 54;
        nm.custom_43_xx = 55;
        nm.custom_44_xx = 56;
        nm.custom_45_xx = 57;
        nm.custom_46_xx = 58;
        nm.custom_template_xx = 59;
        nm.date_last_modified_xx = 60;
        nm.date_payment_received_xx = 61;
        nm.date_shipped_xx = 62;
        nm.date_sold_xx = 63;
        nm.ebay_item_xx = 64;
        nm.final_value_fee_xx = 65;
        nm.handling_xx = 66;
        nm.hits_xx = 67;
        nm.item_cost_xx = 68;
        nm.item_description_xx = 69;
        nm.item_id_xx = 70;
        nm.item_price_xx = 71;
        nm.item_weight_xx = 72;
        nm.listing_fees_xx = 73;
        nm.listing_id_xx = 74;
        nm.notes_xx = 75;
        nm.package_d_xx = 76;
        nm.package_l_xx = 77;
        nm.package_w_xx = 78;
        nm.part_number_xx = 79;
        nm.payment_type_xx = 80;
        nm.paypal_fees_xx = 81;
        nm.picture_1_xx = 82;
        nm.quantity_sold_xx = 83;
        nm.sale_id_xx = 84;
        nm.sale_status_xx = 85;
        nm.sales_tax_xx = 86;
        nm.shipping_company_xx = 87;
        nm.shipping_in_xx = 88;
        nm.shipping_out_xx = 89;
        nm.site_id_xx = 90;
        nm.site_url_xx = 91;
        nm.source_of_sale_xx = 92;
        nm.title_xx = 93;
        nm.title_url_xx = 94;
        nm.total_on_hand_xx = 95;
        nm.total_sale_amount_xx = 96;
        nm.tracking_number_xx = 97;
        nm.transaction_id_xx = 98;
        nm.transaction_info_xx = 99;


    }//set numbers





    public void set_db_string() {

        nm.db_string = new String[nm.db_cc_number];

        nm.db_string[0]  = new String("address_1");
        nm.db_string[1]  = new String("address_2");
        nm.db_string[2]  = new String("address_3");
        nm.db_string[3]  = new String("address_4");
        nm.db_string[4]  = new String("address_5");
        nm.db_string[5]  = new String("address_6");
        nm.db_string[6]  = new String("buyer_id");
        nm.db_string[7]  = new String("buyers_email");
        nm.db_string[8]  = new String("buyers_first_name");
        nm.db_string[9]  = new String("buyers_last_name");
        nm.db_string[10] = new String("buyers_notes");
        nm.db_string[11] = new String("buyers_phone");
        nm.db_string[12] = new String("currency");
        nm.db_string[13] = new String("custom_1");
        nm.db_string[14] = new String("custom_2");
        nm.db_string[15] = new String("custom_3");
        nm.db_string[16] = new String("custom_4");
        nm.db_string[17] = new String("custom_5");
        nm.db_string[18] = new String("custom_6");
        nm.db_string[19] = new String("custom_7");
        nm.db_string[20] = new String("custom_8");
        nm.db_string[21] = new String("custom_9");
        nm.db_string[22] = new String("custom_10");
        nm.db_string[23] = new String("custom_11");
        nm.db_string[24] = new String("custom_12");
        nm.db_string[25] = new String("custom_13");
        nm.db_string[26] = new String("custom_14");
        nm.db_string[27] = new String("custom_15");
        nm.db_string[28] = new String("custom_16");
        nm.db_string[29] = new String("custom_17");
        nm.db_string[30] = new String("custom_18");
        nm.db_string[31] = new String("custom_19");
        nm.db_string[32] = new String("custom_20");
        nm.db_string[33] = new String("custom_21");
        nm.db_string[34] = new String("custom_22");
        nm.db_string[35] = new String("custom_23");
        nm.db_string[36] = new String("custom_24");
        nm.db_string[37] = new String("custom_25");
        nm.db_string[38] = new String("custom_26");
        nm.db_string[39] = new String("custom_27");
        nm.db_string[40] = new String("custom_28");
        nm.db_string[41] = new String("custom_29");
        nm.db_string[42] = new String("custom_30");
        nm.db_string[43] = new String("custom_31");
        nm.db_string[44] = new String("custom_32");
        nm.db_string[45] = new String("custom_33");
        nm.db_string[46] = new String("custom_34");
        nm.db_string[47] = new String("custom_35");
        nm.db_string[48] = new String("custom_36");
        nm.db_string[49] = new String("custom_37");
        nm.db_string[50] = new String("custom_38");
        nm.db_string[51] = new String("custom_39");
        nm.db_string[52] = new String("custom_40");
        nm.db_string[53] = new String("custom_41");
        nm.db_string[54] = new String("custom_42");
        nm.db_string[55] = new String("custom_43");
        nm.db_string[56] = new String("custom_44");
        nm.db_string[57] = new String("custom_45");
        nm.db_string[58] = new String("custom_46");
        nm.db_string[59] = new String("custom_template");
        nm.db_string[60] = new String("date_last_modified");
        nm.db_string[61] = new String("date_payment_received");
        nm.db_string[62] = new String("date_shipped");
        nm.db_string[63] = new String("date_sold");
        nm.db_string[64] = new String("ebay_item");
        nm.db_string[65] = new String("final_value_fee");
        nm.db_string[66] = new String("handling");
        nm.db_string[67] = new String("hits");
        nm.db_string[68] = new String("item_cost");
        nm.db_string[69] = new String("item_description");
        nm.db_string[70] = new String("item_id");
        nm.db_string[71] = new String("item_price");
        nm.db_string[72] = new String("item_weight");
        nm.db_string[73] = new String("listing_fees");
        nm.db_string[74] = new String("listing_id");
        nm.db_string[75] = new String("notes");
        nm.db_string[76] = new String("package_d");
        nm.db_string[77] = new String("package_l");
        nm.db_string[78] = new String("package_w");
        nm.db_string[79] = new String("part_number");
        nm.db_string[80] = new String("payment_type");
        nm.db_string[81] = new String("paypal_fees");
        nm.db_string[82] = new String("picture_1");
        nm.db_string[83] = new String("quantity_sold");
        nm.db_string[84] = new String("sale_id");
        nm.db_string[85] = new String("sale_status");
        nm.db_string[86] = new String("sales_tax");
        nm.db_string[87] = new String("shipping_company");
        nm.db_string[88] = new String("shipping_in");
        nm.db_string[89] = new String("shipping_out");
        nm.db_string[90] = new String("site_id");
        nm.db_string[91] = new String("site_url");
        nm.db_string[92] = new String("source_of_sale");
        nm.db_string[93] = new String("title");
        nm.db_string[94] = new String("title_url");
        nm.db_string[95] = new String("total_on_hand");
        nm.db_string[96] = new String("total_sale_amount");
        nm.db_string[97] = new String("tracking_number");
        nm.db_string[98] = new String("transaction_id");
        nm.db_string[99] = new String("transaction_info");

    }//*************************





    public void set_new_item_db_string() {

        nm.new_item_db_string = new String[nm.db_cc_number];

        nm.new_item_db_string[0]  = new String("address_1");
        nm.new_item_db_string[1]  = new String("address_2");
        nm.new_item_db_string[2]  = new String("address_3");
        nm.new_item_db_string[3]  = new String("address_4");
        nm.new_item_db_string[4]  = new String("address_5");
        nm.new_item_db_string[5]  = new String("address_6");
        nm.new_item_db_string[6]  = new String("buyer_id");
        nm.new_item_db_string[7]  = new String("buyers_email");
        nm.new_item_db_string[8]  = new String("buyers_first_name");
        nm.new_item_db_string[9]  = new String("buyers_last_name");
        nm.new_item_db_string[10] = new String("buyers_notes");
        nm.new_item_db_string[11] = new String("buyers_phone");
        nm.new_item_db_string[12] = new String("currency");
        nm.new_item_db_string[13] = new String("custom_1");
        nm.new_item_db_string[14] = new String("custom_2");
        nm.new_item_db_string[15] = new String("custom_3");
        nm.new_item_db_string[16] = new String("custom_4");
        nm.new_item_db_string[17] = new String("custom_5");
        nm.new_item_db_string[18] = new String("custom_6");
        nm.new_item_db_string[19] = new String("custom_7");
        nm.new_item_db_string[20] = new String("custom_8");
        nm.new_item_db_string[21] = new String("custom_9");
        nm.new_item_db_string[22] = new String("custom_10");
        nm.new_item_db_string[23] = new String("custom_11");
        nm.new_item_db_string[24] = new String("custom_12");
        nm.new_item_db_string[25] = new String("custom_13");
        nm.new_item_db_string[26] = new String("custom_14");
        nm.new_item_db_string[27] = new String("custom_15");
        nm.new_item_db_string[28] = new String("custom_16");
        nm.new_item_db_string[29] = new String("custom_17");
        nm.new_item_db_string[30] = new String("custom_18");
        nm.new_item_db_string[31] = new String("custom_19");
        nm.new_item_db_string[32] = new String("custom_20");
        nm.new_item_db_string[33] = new String("custom_21");
        nm.new_item_db_string[34] = new String("custom_22");
        nm.new_item_db_string[35] = new String("custom_23");
        nm.new_item_db_string[36] = new String("custom_24");
        nm.new_item_db_string[37] = new String("custom_25");
        nm.new_item_db_string[38] = new String("custom_26");
        nm.new_item_db_string[39] = new String("custom_27");
        nm.new_item_db_string[40] = new String("custom_28");
        nm.new_item_db_string[41] = new String("custom_29");
        nm.new_item_db_string[42] = new String("custom_30");
        nm.new_item_db_string[43] = new String("custom_31");
        nm.new_item_db_string[44] = new String("custom_32");
        nm.new_item_db_string[45] = new String("custom_33");
        nm.new_item_db_string[46] = new String("custom_34");
        nm.new_item_db_string[47] = new String("custom_35");
        nm.new_item_db_string[48] = new String("custom_36");
        nm.new_item_db_string[49] = new String("custom_37");
        nm.new_item_db_string[50] = new String("custom_38");
        nm.new_item_db_string[51] = new String("custom_39");
        nm.new_item_db_string[52] = new String("custom_40");
        nm.new_item_db_string[53] = new String("custom_41");
        nm.new_item_db_string[54] = new String("custom_42");
        nm.new_item_db_string[55] = new String("custom_43");
        nm.new_item_db_string[56] = new String("custom_44");
        nm.new_item_db_string[57] = new String("custom_45");
        nm.new_item_db_string[58] = new String("custom_46");
        nm.new_item_db_string[59] = new String("custom_template");
        nm.new_item_db_string[60] = new String("date_last_modified");
        nm.new_item_db_string[61] = new String("date_payment_received");
        nm.new_item_db_string[62] = new String("date_shipped");
        nm.new_item_db_string[63] = new String("date_sold");
        nm.new_item_db_string[64] = new String("ebay_item");
        nm.new_item_db_string[65] = new String("0.00");
        nm.new_item_db_string[66] = new String("0.00");
        nm.new_item_db_string[67] = new String("0");
        nm.new_item_db_string[68] = new String("0.00");
        nm.new_item_db_string[69] = new String("item_description");
        nm.new_item_db_string[70] = new String("item_id");
        nm.new_item_db_string[71] = new String("1.00");
        nm.new_item_db_string[72] = new String("0");
        nm.new_item_db_string[73] = new String("listing_fees");
        nm.new_item_db_string[74] = new String("listing_id");
        nm.new_item_db_string[75] = new String("notes");
        nm.new_item_db_string[76] = new String("1");
        nm.new_item_db_string[77] = new String("1");
        nm.new_item_db_string[78] = new String("1");
        nm.new_item_db_string[79] = new String("part_number");
        nm.new_item_db_string[80] = new String("payment_type");
        nm.new_item_db_string[81] = new String("paypal_fees");
        nm.new_item_db_string[82] = new String("picture_1");
        nm.new_item_db_string[83] = new String("quantity_sold");
        nm.new_item_db_string[84] = new String("sale_id");
        nm.new_item_db_string[85] = new String("New");
        nm.new_item_db_string[86] = new String("sales_tax");
        nm.new_item_db_string[87] = new String("shipping_company");
        nm.new_item_db_string[88] = new String("shipping_in");
        nm.new_item_db_string[89] = new String("shipping_out");
        nm.new_item_db_string[90] = new String("site_id");
        nm.new_item_db_string[91] = new String("site_url");
        nm.new_item_db_string[92] = new String("source_of_sale");
        nm.new_item_db_string[93] = new String("title");
        nm.new_item_db_string[94] = new String("title_url");
        nm.new_item_db_string[95] = new String("0");
        nm.new_item_db_string[96] = new String("0.00");
        nm.new_item_db_string[97] = new String("tracking_number");
        nm.new_item_db_string[98] = new String("transaction_id");
        nm.new_item_db_string[99] = new String("transaction_info");

    }//*************************





    public void build_settings_list() {


        nm.db_settings_string = new String[nm.db_ss_number];

        nm.db_settings_string[0] = new String("Program Width");                 
        nm.db_settings_string[1] = new String("Program Height");  
        nm.db_settings_string[2] = new String("Submit Number (x)");                 
        nm.db_settings_string[3] = new String("Current DB View");  
        nm.db_settings_string[4] = new String("Local .CSV Items Database"); 
        nm.db_settings_string[5] = new String("Submit Number DB (a)");                 
        nm.db_settings_string[6] = new String("Use Local JDB");  
        nm.db_settings_string[7] = new String("mySQL URL");                 
        nm.db_settings_string[8] = new String("mySQL User");  
        nm.db_settings_string[9] = new String("mySQL Password"); 
        nm.db_settings_string[10] = new String("mySQL DB");                 
        nm.db_settings_string[11] = new String("mySQL is active");  
        nm.db_settings_string[12] = new String("Import Number"); 
        nm.db_settings_string[13] = new String("JDB Database");  
        nm.db_settings_string[14] = new String("JDB User Name"); 
        nm.db_settings_string[15] = new String("JDB Password");                 
        nm.db_settings_string[16] = new String("JDB is active");  
        nm.db_settings_string[17] = new String("JDB DB number"); 
        nm.db_settings_string[18] = new String("JDB Use Encryption Login");
        nm.db_settings_string[19] = new String("Auto Ship System ON");  
        nm.db_settings_string[20] = new String("Build label settings"); 
        nm.db_settings_string[21] = new String("Label change name settings");                 
        nm.db_settings_string[22] = new String("FTP label settings");  
        nm.db_settings_string[23] = new String("Shipping order settings"); 
        nm.db_settings_string[24] = new String("Combo1 ID");  
        nm.db_settings_string[25] = new String("Sort Section"); 
        nm.db_settings_string[26] = new String("Working Directory");                 
        nm.db_settings_string[27] = new String("Search text");  
        nm.db_settings_string[28] = new String("Search field"); 
        nm.db_settings_string[29] = new String("Choose shipping system");                  
        nm.db_settings_string[30] = new String("*");  
        nm.db_settings_string[31] = new String("*"); 
        nm.db_settings_string[32] = new String("*");                 
        nm.db_settings_string[33] = new String("*");  
        nm.db_settings_string[34] = new String("*"); 
        nm.db_settings_string[35] = new String("*");  
        nm.db_settings_string[36] = new String("Combo2 ID"); 
        nm.db_settings_string[37] = new String("Combo2 %");                 
        nm.db_settings_string[38] = new String("Combo2 Part 1");  
        nm.db_settings_string[39] = new String("Combo2 Part 2"); 
        nm.db_settings_string[40] = new String("Warehouse URL");
        nm.db_settings_string[41] = new String("Warehouse Password");  
        nm.db_settings_string[42] = new String("Post FEEDBACK with label"); 
        nm.db_settings_string[43] = new String("Post SHIPPED with label");  
        nm.db_settings_string[44] = new String("Shipping get file name");                
        nm.db_settings_string[45] = new String("Shipping .exe location");                 
        nm.db_settings_string[46] = new String("Shipping .lyt location");  
        nm.db_settings_string[47] = new String("Shipping .lyt international location"); 
        nm.db_settings_string[48] = new String("Shipping .XML template location");
        nm.db_settings_string[49] = new String("Shipping .XML postback location");  
        nm.db_settings_string[50] = new String("Shipping label output location"); 
        nm.db_settings_string[51] = new String("FTP User"); 
        nm.db_settings_string[52] = new String("FTP Password");                 
        nm.db_settings_string[53] = new String("FTP Server");  
        nm.db_settings_string[54] = new String("FTP Local File Folder"); 
        nm.db_settings_string[55] = new String("FTP Remote File Folder");
        nm.db_settings_string[56] = new String("Shipping System URL API");  
        nm.db_settings_string[57] = new String("Shipping System Password"); 
        nm.db_settings_string[58] = new String("Shipping System User");      //XML Postback Tracking ID
        nm.db_settings_string[59] = new String("Shipping System Key");       //XML Postback Cost ID
        nm.db_settings_string[60] = new String("Warehouse System User");                 
        nm.db_settings_string[61] = new String("Warehouse System Key");  
        nm.db_settings_string[62] = new String("*"); 
        nm.db_settings_string[63] = new String("*");
        nm.db_settings_string[64] = new String("Replace2 Field Box 1");  
        nm.db_settings_string[65] = new String("Replace2 Field Box 2"); 
        nm.db_settings_string[66] = new String("Replace2 Text Section 1"); 
        nm.db_settings_string[67] = new String("Replace2 Text Section 2");                 
        nm.db_settings_string[68] = new String("eBay Final Value Fee %");  
        nm.db_settings_string[69] = new String("Replace1 Field Box"); 
        nm.db_settings_string[70] = new String("Replace1 Text Section 1");
        nm.db_settings_string[71] = new String("Replace1 Text Section 2");  
        nm.db_settings_string[72] = new String("Inventory Management");                 
        nm.db_settings_string[73] = new String("Warehouse ORDER MIN");  
        nm.db_settings_string[74] = new String("Warehouse ORDER MAX"); 
        nm.db_settings_string[75] = new String("ORDER System MIN");                 
        nm.db_settings_string[76] = new String("ORDER System MAX");  
        nm.db_settings_string[77] = new String("ORDER System PART");                 
        nm.db_settings_string[78] = new String("Bitcoin API ID");  
        nm.db_settings_string[79] = new String("Bitcoin API PASSWORD"); 
        nm.db_settings_string[80] = new String("Bitcoin API PASSWORD2"); 
        nm.db_settings_string[81] = new String("*");  
        nm.db_settings_string[82] = new String("*");                 
        nm.db_settings_string[83] = new String("*");  
        nm.db_settings_string[84] = new String("*"); 
        nm.db_settings_string[85] = new String("*");                 
        nm.db_settings_string[86] = new String("API PORT");  
        nm.db_settings_string[87] = new String("Archive stats Cost");                 
        nm.db_settings_string[88] = new String("Archive stats Price");  
        nm.db_settings_string[89] = new String("Archive stats Taxes"); 
        nm.db_settings_string[90] = new String("Archive stats Shipping"); 
        nm.db_settings_string[91] = new String("Archive stats Sold#");  
        nm.db_settings_string[92] = new String("Archive stats Refund#");                 
        nm.db_settings_string[93] = new String("Archive stats Error#");  
        nm.db_settings_string[94] = new String("Archive stats Total#"); 
        nm.db_settings_string[95] = new String("*");                 
        nm.db_settings_string[96] = new String("*");  
        nm.db_settings_string[97] = new String("*");                 
        nm.db_settings_string[98] = new String("Combo1 %");  
        nm.db_settings_string[99] = new String("Combo1 Type"); 


    }//************************************











    public void jdb_build_database(){//************************************************************************


        System.out.println("Start a new database...");

        try {


            jdb_driver.s.execute("create table listings(xd integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), address_1 varchar(60), address_2 varchar(60), address_3 varchar(60), address_4 varchar(60), address_5 varchar(60), address_6 varchar(60), buyer_id varchar(160), buyers_email varchar(160), buyers_first_name varchar(160), buyers_last_name varchar(60), buyers_notes varchar(60), buyers_phone varchar(60), currency varchar(60), custom_1 varchar(2500), custom_2 varchar(2500), custom_3 varchar(2500), custom_4 varchar(500), custom_5 varchar(200), custom_6 varchar(200), custom_7 varchar(200), custom_8 varchar(200), custom_9 varchar(200), custom_10 varchar(200), custom_11 varchar(200), custom_12 varchar(200), custom_13 varchar(200), custom_14 varchar(200), custom_15 varchar(200), custom_16 varchar(200), custom_17 varchar(200), custom_18 varchar(200), custom_19 varchar(200), custom_20 varchar(200), custom_21 varchar(200), custom_22 varchar(200), custom_23 varchar(200), custom_24 varchar(200), custom_25 varchar(200), custom_26 varchar(200), custom_27 varchar(200), custom_28 varchar(200), custom_29 varchar(200), custom_30 varchar(200), custom_31 varchar(200), custom_32 varchar(200), custom_33 varchar(200), custom_34 varchar(200), custom_35 varchar(200), custom_36 varchar(200), custom_37 varchar(200), custom_38 varchar(200), custom_39 varchar(200), custom_40 varchar(200), custom_41 varchar(200), custom_42 varchar(200), custom_43 varchar(200), custom_44 varchar(200), custom_45 varchar(200), custom_46 varchar(200), custom_template varchar(60), date_last_modified varchar(60), date_payment_received varchar(60), date_shipped varchar(60), date_sold varchar(60), ebay_item varchar(60), final_value_fee varchar(60), handling varchar(60), hits varchar(60), item_cost varchar(60), item_description1 varchar(30000), item_description2 varchar(30000), item_description3 varchar(30000), item_id varchar(60), item_price varchar(60), item_weight varchar(60), listing_fees varchar(60), listing_id varchar(60), notes varchar(600), package_d varchar(60), package_l varchar(60), package_w varchar(60), part_number varchar(160), payment_type varchar(60), paypal_fees varchar(60), picture_1 varchar(300), quantity_sold varchar(60), sale_id varchar(60), sale_status varchar(60), sales_tax varchar(60), shipping_company varchar(60), shipping_in varchar(60), shipping_out varchar(60), site_id varchar(60), site_url varchar(60), source_of_sale varchar(60), title varchar(200), title_url varchar(100), total_on_hand varchar(60), total_sale_amount varchar(60), tracking_number varchar(60), transaction_id varchar(60), transaction_info varchar(60))"); 
            System.out.println("Created table listings");


            //jdb_driver.s.execute("create table monitor(xd integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), address_1 varchar(260), address_2 varchar(260), address_3 varchar(260), address_4 varchar(260), address_5 varchar(260), address_6 varchar(260), buyer_id varchar(160), buyers_email varchar(160), buyers_first_name varchar(160), buyers_last_name varchar(60), buyers_notes varchar(60), buyers_phone varchar(60), currency varchar(60), custom_1 varchar(500), custom_2 varchar(500), custom_3 varchar(500), custom_4 varchar(500), custom_5 varchar(200), custom_6 varchar(200), custom_7 varchar(200), custom_8 varchar(200), custom_9 varchar(200), custom_10 varchar(200), custom_11 varchar(200), custom_12 varchar(200), custom_13 varchar(200), custom_14 varchar(200), custom_15 varchar(200), custom_16 varchar(200), custom_17 varchar(200), custom_18 varchar(200), custom_19 varchar(200), custom_20 varchar(200), custom_21 varchar(200), custom_22 varchar(200), custom_23 varchar(200), custom_24 varchar(200), custom_25 varchar(200), custom_26 varchar(200), custom_27 varchar(200), custom_28 varchar(200), custom_29 varchar(200), custom_30 varchar(200), custom_31 varchar(200), custom_32 varchar(200), custom_33 varchar(200), custom_34 varchar(200), custom_35 varchar(200), custom_36 varchar(200), custom_37 varchar(200), custom_38 varchar(200), custom_39 varchar(200), custom_40 varchar(200), custom_41 varchar(200), custom_42 varchar(200), custom_43 varchar(200), custom_44 varchar(200), custom_45 varchar(200), custom_46 varchar(200), custom_template varchar(60), date_last_modified varchar(60), date_payment_received varchar(60), date_shipped varchar(60), date_sold varchar(60), ebay_item varchar(60), final_value_fee varchar(60), handling varchar(60), hits varchar(60), item_cost varchar(60), item_description varchar(30000), item_id varchar(60), item_price varchar(60), item_weight varchar(60), listing_fees varchar(60), listing_id varchar(60), notes varchar(200), package_d varchar(60), package_l varchar(60), package_w varchar(60), part_number varchar(60), payment_type varchar(60), paypal_fees varchar(60), picture_1 varchar(300), quantity_sold varchar(60), sale_id varchar(60), sale_status varchar(60), sales_tax varchar(60), shipping_company varchar(60), shipping_in varchar(60), shipping_out varchar(60), site_id varchar(60), site_url varchar(60), source_of_sale varchar(60), title varchar(160), title_url varchar(60), total_on_hand varchar(60), total_sale_amount varchar(60), tracking_number varchar(60), transaction_id varchar(60), transaction_info varchar(60))"); 
            //System.out.println("Created table monitor");


            jdb_driver.s.execute("create table monitor(xd integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), set001 varchar(360), set002 varchar(360), set003 varchar(1600), set004 varchar(60), set005 varchar(60), set006 varchar(60), set007 varchar(160), set008 varchar(160), set009 varchar(160), set010 varchar(160), set011 varchar(160), set012 varchar(160), set013 varchar(160), set014 varchar(500), set015 varchar(500), set016 varchar(500), set017 varchar(500), set018 varchar(200), set019 varchar(200), set020 varchar(200), set021 varchar(200), set022 varchar(200), set023 varchar(200), set024 varchar(200), set025 varchar(200), set026 varchar(29000), set027 varchar(200), set028 varchar(200), set029 varchar(200), set030 varchar(200), set031 varchar(200), set032 varchar(200), set033 varchar(200), set034 varchar(50), set035 varchar(50), set036 varchar(50), set037 varchar(50), set038 varchar(50), set039 varchar(50), set040 varchar(50), set041 varchar(50), set042 varchar(50), set043 varchar(50), set044 varchar(50), set045 varchar(50), set046 varchar(50), set047 varchar(50), set048 varchar(50), set049 varchar(50), set050 varchar(50), set051 varchar(50), set052 varchar(50), set053 varchar(50), set054 varchar(50), set055 varchar(50), set056 varchar(50), set057 varchar(50), set058 varchar(50), set059 varchar(50), set060 varchar(50), set061 varchar(650), set062 varchar(50), set063 varchar(50), set064 varchar(50), set065 varchar(50), set066 varchar(50), set067 varchar(50), set068 varchar(50), set069 varchar(50), set070 varchar(50), set071 varchar(50), set072 varchar(50), set073 varchar(50), set074 varchar(50), set075 varchar(50), set076 varchar(50), set077 varchar(50), set078 varchar(50), set079 varchar(50), set080 varchar(50), set081 varchar(50), set082 varchar(50), set083 varchar(50), set084 varchar(50), set085 varchar(50), set086 varchar(50), set087 varchar(50), set088 varchar(50), set089 varchar(50), set090 varchar(50), set091 varchar(50), set092 varchar(50), set093 varchar(50), set094 varchar(50), set095 varchar(50), set096 varchar(50), set097 varchar(50), set098 varchar(50), set099 varchar(50), set100 varchar(60))"); 
            System.out.println("Created table monitor");


            jdb_driver.s.execute("create table sold(xd integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), address_1 varchar(260), address_2 varchar(260), address_3 varchar(260), address_4 varchar(260), address_5 varchar(260), address_6 varchar(260), buyer_id varchar(160), buyers_email varchar(160), buyers_first_name varchar(160), buyers_last_name varchar(60), buyers_notes varchar(1360), buyers_phone varchar(60), currency varchar(60), custom_1 varchar(2500), custom_2 varchar(1500), custom_3 varchar(1500), custom_4 varchar(1500), custom_5 varchar(1500), custom_6 varchar(200), custom_7 varchar(200), custom_8 varchar(200), custom_9 varchar(200), custom_10 varchar(200), custom_11 varchar(200), custom_12 varchar(200), custom_13 varchar(200), custom_14 varchar(200), custom_15 varchar(200), custom_16 varchar(200), custom_17 varchar(200), custom_18 varchar(200), custom_19 varchar(200), custom_20 varchar(200), custom_21 varchar(200), custom_22 varchar(200), custom_23 varchar(200), custom_24 varchar(200), custom_25 varchar(200), custom_26 varchar(200), custom_27 varchar(200), custom_28 varchar(200), custom_29 varchar(200), custom_30 varchar(200), custom_31 varchar(200), custom_32 varchar(200), custom_33 varchar(200), custom_34 varchar(200), custom_35 varchar(200), custom_36 varchar(200), custom_37 varchar(200), custom_38 varchar(200), custom_39 varchar(200), custom_40 varchar(200), custom_41 varchar(200), custom_42 varchar(200), custom_43 varchar(200), custom_44 varchar(200), custom_45 varchar(200), custom_46 varchar(200), custom_template varchar(60), date_last_modified varchar(60), date_payment_received varchar(60), date_shipped varchar(60), date_sold varchar(60), ebay_item varchar(60), final_value_fee varchar(60), handling varchar(60), hits varchar(60), item_cost varchar(60), item_description varchar(30000), item_id varchar(60), item_price varchar(60), item_weight varchar(60), listing_fees varchar(60), listing_id varchar(60), notes varchar(2000), package_d varchar(60), package_l varchar(60), package_w varchar(60), part_number varchar(60), payment_type varchar(60), paypal_fees varchar(60), picture_1 varchar(300), quantity_sold varchar(60), sale_id varchar(60), sale_status varchar(60), sales_tax varchar(60), shipping_company varchar(60), shipping_in varchar(60), shipping_out varchar(60), site_id varchar(60), site_url varchar(60), source_of_sale varchar(60), title varchar(160), title_url varchar(100), total_on_hand varchar(60), total_sale_amount varchar(60), tracking_number varchar(60), transaction_id varchar(60), transaction_info varchar(60))"); 
            System.out.println("Created table sold");


            jdb_driver.s.execute("create table archived(xd integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), address_1 varchar(260), address_2 varchar(260), address_3 varchar(260), address_4 varchar(260), address_5 varchar(260), address_6 varchar(260), buyer_id varchar(160), buyers_email varchar(160), buyers_first_name varchar(160), buyers_last_name varchar(60), buyers_notes varchar(1360), buyers_phone varchar(60), currency varchar(60), custom_1 varchar(2500), custom_2 varchar(1500), custom_3 varchar(1500), custom_4 varchar(1500), custom_5 varchar(1500), custom_6 varchar(200), custom_7 varchar(200), custom_8 varchar(200), custom_9 varchar(200), custom_10 varchar(200), custom_11 varchar(200), custom_12 varchar(200), custom_13 varchar(200), custom_14 varchar(200), custom_15 varchar(200), custom_16 varchar(200), custom_17 varchar(200), custom_18 varchar(200), custom_19 varchar(200), custom_20 varchar(200), custom_21 varchar(200), custom_22 varchar(200), custom_23 varchar(200), custom_24 varchar(200), custom_25 varchar(200), custom_26 varchar(200), custom_27 varchar(200), custom_28 varchar(200), custom_29 varchar(200), custom_30 varchar(200), custom_31 varchar(200), custom_32 varchar(200), custom_33 varchar(200), custom_34 varchar(200), custom_35 varchar(200), custom_36 varchar(200), custom_37 varchar(200), custom_38 varchar(200), custom_39 varchar(200), custom_40 varchar(200), custom_41 varchar(200), custom_42 varchar(200), custom_43 varchar(200), custom_44 varchar(200), custom_45 varchar(200), custom_46 varchar(200), custom_template varchar(60), date_last_modified varchar(60), date_payment_received varchar(60), date_shipped varchar(60), date_sold varchar(60), ebay_item varchar(60), final_value_fee varchar(60), handling varchar(60), hits varchar(60), item_cost varchar(60), item_description varchar(30000), item_id varchar(60), item_price varchar(60), item_weight varchar(60), listing_fees varchar(60), listing_id varchar(60), notes varchar(660), package_d varchar(60), package_l varchar(60), package_w varchar(60), part_number varchar(60), payment_type varchar(60), paypal_fees varchar(60), picture_1 varchar(300), quantity_sold varchar(60), sale_id varchar(60), sale_status varchar(60), sales_tax varchar(60), shipping_company varchar(60), shipping_in varchar(60), shipping_out varchar(60), site_id varchar(60), site_url varchar(60), source_of_sale varchar(60), title varchar(160), title_url varchar(100), total_on_hand varchar(60), total_sale_amount varchar(60), tracking_number varchar(60), transaction_id varchar(60), transaction_info varchar(60))"); 
            System.out.println("Created table archived");


            jdb_driver.s.execute("create table settings(xd integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), settings_json varchar(20000))"); 
            System.out.println("Created table settings");


            jdb_driver.s.execute("create table connections(xd integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), con001 varchar(360), con002 varchar(360), con003 varchar(1600), con004 varchar(60), con005 varchar(60), con006 varchar(60), con007 varchar(160), con008 varchar(160), con009 varchar(160), con010 varchar(160), con011 varchar(160), con012 varchar(160), con013 varchar(160), con014 varchar(500), con015 varchar(500), con016 varchar(500), con017 varchar(500), con018 varchar(200), con019 varchar(200), con020 varchar(200), con021 varchar(200), con022 varchar(200), con023 varchar(200), con024 varchar(200), con025 varchar(200), con026 varchar(29000), con027 varchar(200), con028 varchar(200), con029 varchar(200), con030 varchar(200), con031 varchar(200), con032 varchar(200), con033 varchar(200), con034 varchar(50), con035 varchar(50), con036 varchar(50), con037 varchar(50), con038 varchar(50), con039 varchar(50), con040 varchar(50), con041 varchar(50), con042 varchar(50), con043 varchar(50), con044 varchar(50), con045 varchar(50), con046 varchar(50), con047 varchar(50), con048 varchar(50), con049 varchar(50), con050 varchar(50), con051 varchar(50), con052 varchar(50), con053 varchar(50), con054 varchar(50), con055 varchar(50), con056 varchar(50), con057 varchar(50), con058 varchar(50), con059 varchar(50), con060 varchar(50), con061 varchar(650), con062 varchar(50), con063 varchar(50), con064 varchar(50), con065 varchar(50), con066 varchar(50), con067 varchar(50), con068 varchar(50), con069 varchar(50), con070 varchar(50), con071 varchar(50), con072 varchar(50), con073 varchar(50), con074 varchar(50), con075 varchar(50), con076 varchar(50), con077 varchar(50), con078 varchar(50), con079 varchar(50), con080 varchar(50), con081 varchar(50), con082 varchar(50), con083 varchar(50), con084 varchar(50), con085 varchar(50), con086 varchar(50), con087 varchar(50), con088 varchar(50), con089 varchar(50), con090 varchar(50), con091 varchar(50), con092 varchar(50), con093 varchar(50), con094 varchar(50), con095 varchar(50), con096 varchar(50), con097 varchar(50), con098 varchar(50), con099 varchar(50), con100 varchar(60))"); 
            System.out.println("Created table connections");


            jdb_driver.s.execute("create table settings_display(xd integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), settings_json varchar(20000))"); 
            System.out.println("Created table settings");


            jdb_driver.s.execute("create table select_database(xd integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), databases varchar(200))"); 
            System.out.println("Created table select_database");


            jdb_driver.s.execute("create table archived_sales_ids(xd integer not null primary key GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), ids varchar(500))"); 
            System.out.println("Created table archived_sales_ids");


            conn.commit();
            System.out.println("ALCHEMIST DATABASE BUILD");


        } catch (SQLException se) {se.printStackTrace();}


    }//database






    public void build_settings() {


        nm.carbon[4] = new String[1][nm.db_ss_number];

        nm.carbon[4][0][0] = new String("800");
        nm.carbon[4][0][1] = new String("500");
        nm.carbon[4][0][2] = new String("0");
        nm.carbon[4][0][3] = new String("2");
        nm.carbon[4][0][4] = new String("ALCHEMIST_DBX.CSV");
        nm.carbon[4][0][5] = new String("0");
        nm.carbon[4][0][6] = new String("1");
        nm.carbon[4][0][7] = new String("127.0.0.1");
        nm.carbon[4][0][8] = new String("USER");
        nm.carbon[4][0][9] = new String("PASS");
        nm.carbon[4][0][10] = new String("DB");
        nm.carbon[4][0][11] = new String("0");
        nm.carbon[4][0][12] = new String("1000000");
        nm.carbon[4][0][13] = new String("ALCHEMIST");
        nm.carbon[4][0][14] = new String("LLLH8097");
        nm.carbon[4][0][15] = new String("87098798723452345884777");
        nm.carbon[4][0][16] = new String("1");
        nm.carbon[4][0][17] = new String("0");
        nm.carbon[4][0][18] = new String("0");//0 or 1
        nm.carbon[4][0][19] = new String("0");
        nm.carbon[4][0][20] = new String("1");
        nm.carbon[4][0][21] = new String("1");
        nm.carbon[4][0][22] = new String("1");
        nm.carbon[4][0][23] = new String("1");
        nm.carbon[4][0][24] = new String("1000000");
        nm.carbon[4][0][25] = new String("79");
        nm.carbon[4][0][26] = new String("800");
        nm.carbon[4][0][27] = new String("search");
        nm.carbon[4][0][28] = new String("93");
        nm.carbon[4][0][29] = new String("KLJHIU90989798KNM");
        nm.carbon[4][0][30] = new String("800");
        nm.carbon[4][0][31] = new String("800");
        nm.carbon[4][0][32] = new String("800");
        nm.carbon[4][0][33] = new String("800");
        nm.carbon[4][0][34] = new String("800");
        nm.carbon[4][0][35] = new String("800");
        nm.carbon[4][0][36] = new String("0");
        nm.carbon[4][0][37] = new String("18");
        nm.carbon[4][0][38] = new String("42");
        nm.carbon[4][0][39] = new String("43");
        nm.carbon[4][0][40] = new String("http://www.x.com/alchemy_api/");
        nm.carbon[4][0][41] = new String("QQQ");
        nm.carbon[4][0][42] = new String("0");
        nm.carbon[4][0][43] = new String("0");
        nm.carbon[4][0][44] = new String("800");
        nm.carbon[4][0][45] = new String("C:\\program files\\DAZzle\\DAZZLE.EXE");
        nm.carbon[4][0][46] = new String("C:\\program files\\alchemist\\site1\\");
        nm.carbon[4][0][47] = new String("C:\\program files\\alchemist\\site1\\");
        nm.carbon[4][0][48] = new String("C:\\program files\\alchemist\\site1\\");
        nm.carbon[4][0][49] = new String("C:\\program files\\alchemist\\site1\\");
        nm.carbon[4][0][50] = new String("C:\\program files\\alchemist\\site1\\");
        nm.carbon[4][0][51] = new String("pro");
        nm.carbon[4][0][52] = new String("2010");
        nm.carbon[4][0][53] = new String("ftp.pro.com");
        nm.carbon[4][0][54] = new String("C:\\program files\\alchemist\\site1\\");
        nm.carbon[4][0][55] = new String("/alchemy_api/labels/");
        nm.carbon[4][0][56] = new String("800");
        nm.carbon[4][0][57] = new String("!!!");
        nm.carbon[4][0][58] = new String("systemx");
        nm.carbon[4][0][59] = new String("88iuyoi97");
        nm.carbon[4][0][60] = new String("systemx");
        nm.carbon[4][0][61] = new String("88iuyoi97");
        nm.carbon[4][0][62] = new String("800");
        nm.carbon[4][0][63] = new String("800");
        nm.carbon[4][0][64] = new String("800");
        nm.carbon[4][0][65] = new String("800");
        nm.carbon[4][0][66] = new String("800");
        nm.carbon[4][0][67] = new String("800");
        nm.carbon[4][0][68] = new String("800");
        nm.carbon[4][0][69] = new String("800");
        nm.carbon[4][0][70] = new String("800");
        nm.carbon[4][0][71] = new String("800");
        nm.carbon[4][0][72] = new String("800");
        nm.carbon[4][0][73] = new String("800");
        nm.carbon[4][0][74] = new String("800");
        nm.carbon[4][0][75] = new String("800");
        nm.carbon[4][0][76] = new String("800");
        nm.carbon[4][0][77] = new String("800");
        nm.carbon[4][0][78] = new String("800");
        nm.carbon[4][0][79] = new String("800");
        nm.carbon[4][0][80] = new String("800");
        nm.carbon[4][0][81] = new String("800");
        nm.carbon[4][0][82] = new String("800");
        nm.carbon[4][0][83] = new String("800");
        nm.carbon[4][0][84] = new String("800");
        nm.carbon[4][0][85] = new String("800");
        nm.carbon[4][0][86] = new String("7779");
        nm.carbon[4][0][87] = new String("800");
        nm.carbon[4][0][88] = new String("800");
        nm.carbon[4][0][89] = new String("800");
        nm.carbon[4][0][90] = new String("800");
        nm.carbon[4][0][91] = new String("800");
        nm.carbon[4][0][92] = new String("800");
        nm.carbon[4][0][93] = new String("800");
        nm.carbon[4][0][94] = new String("800");
        nm.carbon[4][0][95] = new String("800");
        nm.carbon[4][0][96] = new String("800");
        nm.carbon[4][0][97] = new String("800");
        nm.carbon[4][0][98] = new String("800");
        nm.carbon[4][0][99] = new String("800");





        //Set common display settings. 
        alchemy_rebuild_display rebuildx = new alchemy_rebuild_display();




        try {


            String json_settings = new String("");

            JSONObject obj = new JSONObject();

            for (int loop = 0; loop < nm.db_ss_number; loop++) {//*************

                obj.put(Integer.toString(loop), nm.carbon[4][0][loop]);

            }//****************************************************************

            StringWriter out = new StringWriter();
            obj.writeJSONString(out);
            json_settings = out.toString();
            System.out.println(json_settings);


            PreparedStatement ps = null;
            int numrows = 0;


            //settings
            ps = jdb_driver.conn.prepareStatement("insert into settings(settings_json) values(?)");

            numrows = 0;

            ps.setString(1, json_settings);

            numrows = numrows + ps.executeUpdate();

            ps.close();


        } catch (Exception e) {e.printStackTrace();}




        try {


            String json_settings = new String("");

            JSONObject obj = new JSONObject();

            for (int loop = 0; loop < nm.db_dd_number; loop++) {//*************

                obj.put("w" + Integer.toString(loop), nm.carbon[6][0][loop]);
                obj.put("x" + Integer.toString(loop), nm.carbon[6][1][loop]);
                obj.put("y" + Integer.toString(loop), nm.carbon[6][2][loop]);
                obj.put("z" + Integer.toString(loop), nm.carbon[6][3][loop]);

            }//****************************************************************

            StringWriter out = new StringWriter();
            obj.writeJSONString(out);
            json_settings = out.toString();
            System.out.println(json_settings);


            PreparedStatement ps = null;
            int numrows = 0;


            //display system
            ps = jdb_driver.conn.prepareStatement("insert into settings_display(settings_json) values(?)");

            numrows = 0;

            ps.setString(1, json_settings);

            numrows = numrows + ps.executeUpdate();

            ps.close();



        } catch (Exception e) {e.printStackTrace();}



    }//**************************










    public void shutdown(){

        try {


            if (framework.equals("embedded")) {

                try {

                    // the shutdown=true attribute shuts down Derby
                    DriverManager.getConnection("jdbc:derby:;shutdown=true");

                    // To shut down a specific database only, but keep the
                    // engine running (for example for connecting to other
                    // databases), specify a database in the connection URL:
                    //DriverManager.getConnection("jdbc:derby:" + dbName + ";shutdown=true");

                } catch (SQLException se) {

                    if (( (se.getErrorCode() == 50000) && ("XJ015".equals(se.getSQLState()) ))) {

                        // we got the expected exception
                        System.out.println("Derby shut down normally");
                        // Note that for single database shutdown, the expected
                        // SQL state is "08006", and the error code is 45000.

                    }//**************************************************************************
                    else {

                        // if the error code or SQLState is different, we have
                        // an unexpected exception (shutdown failed)
                        System.err.println("Derby did not shut down normally");
                        printSQLException(se);

                    }

                }//*********************

            }//if****************************


        } catch (Exception sqle) {

            sqle.printStackTrace();
            //printSQLException(sqle);

        } finally {

            // release all open resources to avoid unnecessary memory usage
            // ResultSet
            try {

                if(rs != null) {

                    rs.close();
                    rs = null;

                }//************

            } catch (SQLException sqle) {

                printSQLException(sqle);

            }

            // Statements and PreparedStatements
            int i = 0;
            while (!statements.isEmpty()) {

                // PreparedStatement extend Statement
                Statement st = (Statement)statements.remove(i);

                try {

                    if (st != null) {

                        st.close();
                        st = null;

                    }

                } catch (SQLException sqle) {

                    printSQLException(sqle);

                }
            }

            //Connection
            try{

                if (conn != null) {

                    conn.close();
                    conn = null;

                }//****************

            }catch(SQLException sqle){

                printSQLException(sqle);
                
            }

        }//finally




    }//shutdown










    private void loadDriver() {
        /*
         *  The JDBC driver is loaded by loading its class.
         *  If you are using JDBC 4.0 (Java SE 6) or newer, JDBC drivers may
         *  be automatically loaded, making this code optional.
         *
         *  In an embedded environment, this will also start up the Derby
         *  engine (though not any databases), since it is not already
         *  running. In a client environment, the Derby engine is being run
         *  by the network server framework.
         *
         *  In an embedded environment, any static Derby system properties
         *  must be set before loading the driver to take effect.
         */
        try {
            Class.forName(driver).newInstance();
            System.out.println("Loaded the appropriate driver");
        } catch (ClassNotFoundException cnfe) {
            System.err.println("\nUnable to load the JDBC driver " + driver);
            System.err.println("Please check your CLASSPATH.");
            cnfe.printStackTrace(System.err);
        } catch (InstantiationException ie) {
            System.err.println("\nUnable to instantiate the JDBC driver " + driver);
            ie.printStackTrace(System.err);
        } catch (IllegalAccessException iae) {
            System.err.println("\nNot allowed to access the JDBC driver " + driver);
            iae.printStackTrace(System.err);
        }
    }

    /**
     * Reports a data verification failure to System.err with the given message.
     *
     * @param message A message describing what failed.
     */


    private void reportFailure(String message) {
        System.err.println("\nData verification failed:");
        System.err.println('\t' + message);
    }

    /**
     * Prints details of an SQLException chain to <code>System.err</code>.
     * Details included are SQL State, Error code, Exception message.
     *
     * @param e the SQLException from which to print details.
     */


    public static void printSQLException(SQLException e)
    {
        // Unwraps the entire exception chain to unveil the real cause of the
        // Exception.
        while (e != null)
        {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            // for stack traces, refer to derby.log or uncomment this:
            //e.printStackTrace(System.err);
            e = e.getNextException();
        }
    }



    /**
     * Parses the arguments given and sets the values of this class' instance
     * variables accordingly - that is which framework to use, the name of the
     * JDBC driver class, and which connection protocol protocol to use. The
     * protocol should be used as part of the JDBC URL when connecting to Derby.
     * <p>
     * If the argument is "embedded" or invalid, this method will not change
     * anything, meaning that the default values will be used.</p>
     * <p>
     * @param args JDBC connection framework, either "embedded", "derbyclient".
     * Only the first argument will be considered, the rest will be ignored.
     */
    private void parseArguments(String[] args)
    {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("derbyclient"))
            {
                framework = "derbyclient";
                driver = "org.apache.derby.jdbc.ClientDriver";
                protocol = "jdbc:derby://localhost:1527/";
            }
        }
    }




}//database driver

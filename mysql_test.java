import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.Properties;



public class mysql_test{

    /* the default framework is embedded*/
    private String framework = "embedded";
    private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private String protocol = "jdbc:derby://http://76.162.254.170";


    int ix0 = 0;
    int ix1 = 0;

    String cx0 = new String();
    String cx1 = new String();
    String cx2 = new String();




   mysql_test(){//************************************************************************


        /* parse the arguments to determine which framework is desired*/
        //parseArguments(args);

        System.out.println("");
        System.out.println("JDB saving starting in " + framework + " mode");

        /* load the desired JDBC driver */
        loadDriver();

        /* We will be using Statement and PreparedStatement objects for
         * executing SQL. These objects, as well as Connections and ResultSets,
         * are resources that should be released explicitly after use, hence
         * the try-catch-finally pattern used below.
         * We are storing the Statement and Prepared statement object references
         * in an array list for convenience.
         */


        Connection conn = null;


	/* This ArrayList usage may cause a warning when compiling this class
	 * with a compiler for J2SE 5.0 or newer. We are not using generics
	 * because we want the source to support J2SE 1.4.2 environments. 
	*/


        ArrayList statements = new ArrayList(); // list of Statements, PreparedStatements
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        Statement s = null;
        ResultSet rs = null;


        try{

            Properties props = new Properties(); // connection properties
            // providing a user name and password is optional in the embedded
            // and derbyclient frameworks

	    if(nm.carbon[4][0][14].equals("0")){nm.carbon[4][0][14] = "LLLH8097";}
	    if(nm.carbon[4][0][15].equals("0")){nm.carbon[4][0][15] = "87098798723452345884777";}

            props.put("user", "user1");
            props.put("password", nm.carbon[4][0][15]);

            /* By default, the schema APP will be used when no username is
             * provided.
             * Otherwise, the schema name is the same as the user name (in this
             * case "user1" or USER1.)
             *
             * Note that user authentication is off by default, meaning that any
             * user can connect to your database using any password. To enable
             * authentication, see the Derby Developer's Guide.
             */

            String dbName = nm.carbon[4][0][13]; // the name of the database

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


    	    if(nm.carbon[4][0][18].equals("1")){
    	    //s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" + "'derby.connection.requireAuthentication', 'true')");
    	    s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" + "'derby.connection.requireAuthentication', 'true')");
                s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" + "'derby.authentication.provider', 'BUILTIN')");
                s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" + "'derby.user." + nm.carbon[4][0][14] + "', '" + nm.carbon[4][0][15] + "')");
                s.executeUpdate("CALL SYSCS_UTIL.SYSCS_SET_DATABASE_PROPERTY(" + "'derby.database.fullAccessUsers', '" + nm.carbon[4][0][14] + "')");
    	    }//if use login
    	    else{}

            // delete the table


            ix1 = 20000;

            ix0 = 0;
            try{s.execute("drop table listings");}catch (SQLException se){System.out.println("DB does not Exist0."); ix0 = 1;}
            try{s.execute("drop table listings");}catch (SQLException se){System.out.println("DB does not Exist1."); ix0 = 1;}

            // We create a table...
            if(ix0 == 1){//******************************************************

            	s.execute("create table listings(address_1 varchar(60), address_2 varchar(60), address_3 varchar(60), address_4 varchar(60), address_5 varchar(60), address_6 varchar(60), buyer_id varchar(160), buyers_email varchar(160), buyers_first_name varchar(160), buyers_last_name varchar(60), buyers_notes varchar(60), buyers_phone varchar(60), currency varchar(60), custom_1 varchar(2500), custom_2 varchar(2500), custom_3 varchar(2500), custom_4 varchar(500), custom_5 varchar(200), custom_6 varchar(200), custom_7 varchar(200), custom_8 varchar(200), custom_9 varchar(200), custom_10 varchar(200), custom_11 varchar(200), custom_12 varchar(200), custom_13 varchar(200), custom_14 varchar(200), custom_15 varchar(200), custom_16 varchar(200), custom_17 varchar(200), custom_18 varchar(200), custom_19 varchar(200), custom_20 varchar(200), custom_21 varchar(200), custom_22 varchar(200), custom_23 varchar(200), custom_24 varchar(200), custom_25 varchar(200), custom_26 varchar(200), custom_27 varchar(200), custom_28 varchar(200), custom_29 varchar(200), custom_30 varchar(200), custom_31 varchar(200), custom_32 varchar(200), custom_33 varchar(200), custom_34 varchar(200), custom_35 varchar(200), custom_36 varchar(200), custom_37 varchar(200), custom_38 varchar(200), custom_39 varchar(200), custom_40 varchar(200), custom_41 varchar(200), custom_42 varchar(200), custom_43 varchar(200), custom_44 varchar(200), custom_45 varchar(200), custom_46 varchar(200), custom_template varchar(60), date_last_modified varchar(60), date_payment_received varchar(60), date_shipped varchar(60), date_sold varchar(60), ebay_item varchar(60), final_value_fee varchar(60), handling varchar(60), hits varchar(60), item_cost varchar(60), item_description1 varchar(30000), item_description2 varchar(30000), item_description3 varchar(30000), item_id varchar(60), item_price varchar(60), item_weight varchar(60), listing_fees varchar(60), listing_id varchar(60), notes varchar(600), package_d varchar(60), package_l varchar(60), package_w varchar(60), part_number varchar(160), payment_type varchar(60), paypal_fees varchar(60), picture_1 varchar(300), quantity_sold varchar(60), sale_id varchar(60), sale_status varchar(60), sales_tax varchar(60), shipping_company varchar(60), shipping_in varchar(60), shipping_out varchar(60), site_id varchar(60), site_url varchar(60), source_of_sale varchar(60), title varchar(200), title_url varchar(100), total_on_hand varchar(60), total_sale_amount varchar(60), tracking_number varchar(60), transaction_id varchar(60), transaction_info varchar(60))"); 
                System.out.println("Created table listings");

            }//****************************************************************





        	for(int loop1 = 0; loop1 < nm.carbon[0].length; loop1++){//********************

        	   nm.carbon[0][loop1][0] = "*" + nm.db_string[loop1];

        	}//*******************************************************************************




            //and add a few rows...

        	PreparedStatement ps = null;

        	

        	ps = conn.prepareStatement("insert into listings(address_1, address_2, address_3, address_4, address_5, address_6, buyer_id, buyers_email, buyers_first_name, buyers_last_name, buyers_notes, buyers_phone, currency, custom_1, custom_2, custom_3, custom_4, custom_5, custom_6, custom_7, custom_8, custom_9, custom_10, custom_11, custom_12, custom_13, custom_14, custom_15, custom_16, custom_17, custom_18, custom_19, custom_20, custom_21, custom_22, custom_23, custom_24, custom_25, custom_26, custom_27, custom_28, custom_29, custom_30, custom_31, custom_32, custom_33, custom_34, custom_35, custom_36, custom_37, custom_38, custom_39, custom_40, custom_41, custom_42, custom_43, custom_44, custom_45, custom_46, custom_template, date_last_modified, date_payment_received, date_shipped, date_sold, ebay_item, final_value_fee, handling, hits, item_cost, item_description1, item_description2, item_description3, item_id, item_price, item_weight, listing_fees, listing_id, notes, package_d, package_l, package_w, part_number, payment_type, paypal_fees, picture_1, quantity_sold, sale_id, sale_status, sales_tax, shipping_company, shipping_in, shipping_out, site_id, site_url, source_of_sale, title, title_url, total_on_hand, total_sale_amount, tracking_number, transaction_id, transaction_info) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

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







            conn.commit();
            System.out.println("Committed the transaction");

            /*
             * In embedded mode, an application should shut down the database.
             * If the application fails to shut down the database,
             * Derby will not perform a checkpoint when the JVM shuts down.
             * This means that it will take longer to boot (connect to) the
             * database the next time, because Derby needs to perform a recovery
             * operation.
             *
             * It is also possible to shut down the Derby system/engine, which
             * automatically shuts down all booted databases.
             *
             * Explicitly shutting down the database or the Derby engine with
             * the connection URL is preferred. This style of shutdown will
             * always throw an SQLException.
             *
             * Not shutting down when in a client environment, see method
             * Javadoc.
             */

            if (framework.equals("embedded")){
                try
                {
                    // the shutdown=true attribute shuts down Derby
                    DriverManager.getConnection("jdbc:derby:;shutdown=true");

                    // To shut down a specific database only, but keep the
                    // engine running (for example for connecting to other
                    // databases), specify a database in the connection URL:
                    //DriverManager.getConnection("jdbc:derby:" + dbName + ";shutdown=true");
                }
                catch (SQLException se)
                {
                    if (( (se.getErrorCode() == 50000)
                            && ("XJ015".equals(se.getSQLState()) ))) {
                        // we got the expected exception
                        System.out.println("Derby shut down normally");
                        // Note that for single database shutdown, the expected
                        // SQL state is "08006", and the error code is 45000.
                    } else {
                        // if the error code or SQLState is different, we have
                        // an unexpected exception (shutdown failed)
                        System.err.println("Derby did not shut down normally");
                        printSQLException(se);
                    }
                }
            }
        }
        catch (SQLException sqle)
        {
            printSQLException(sqle);
        } finally {
            // release all open resources to avoid unnecessary memory usage

            // ResultSet
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
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
            try {
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqle) {
                printSQLException(sqle);
            }
        }
    }












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
            System.err.println(
                        "\nUnable to instantiate the JDBC driver " + driver);
            ie.printStackTrace(System.err);
        } catch (IllegalAccessException iae) {
            System.err.println(
                        "\nNot allowed to access the JDBC driver " + driver);
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
                protocol = "jdbc:derby://http://76.162.254.170";
            }
        }
    }


}//last

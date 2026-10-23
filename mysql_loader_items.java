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

import java.util.ArrayList;
import java.util.Properties;



  
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.ResultSet;  
import java.sql.Statement;  







public class mysql_loader_items extends JFrame{

/* the default framework is embedded*/
private String framework = "embedded";
private String driver = "com.mysql.jdbc.Driver";
private String protocol = "jdbc:derby:";



Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
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
Label infox1 = new Label("Submitting items to site.", Label.LEFT);
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



String CONFIG_XML_NAME = "amazon_template.xml";
String SUBMIT_XML_NAME = "amazon_template.xml";
String SUBMIT_FEEDTYPE = "";
int SUBMIT_NUMBER = 0;

String spacer_0 = new String("  ");






mysql_loader_items(){//**************************************************************************






	super("mySQL Load Database Listings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);


	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);



	Icon aicon = new ImageIcon(ximagex);

	infox0.setPreferredSize(new Dimension(320, 50));
	infox0.setBackground(black);
	infox0.setForeground(whitex);
	//infox0.setOpaque(false);
	//infox0.setIcon(ximagex);
	infox0.setText("Version 2.1.1");
	//infox0.setHorizontalTextPosition(Label.LEFT);
	//infox0.setIconTextGap(30);

	infox1.setPreferredSize(new Dimension(350, 98));
	infox1.setText("");


	infox2.setPreferredSize(new Dimension(350, 25));
	infox2.setText(spacer_0 + "Start Database System.");
	//infox2.setBackground(nm.program_gray_1);

	FlowLayout fl1 = new FlowLayout();
	fl1.setHgap(0);
	fl1.setVgap(0);


	JPanel bkp = new JPanel();
	bkp.setPreferredSize(new Dimension(340, 140));
	bkp.setLayout(fl1);
	bkp.setBackground(blackx);
	bkp.setForeground(whitex);
	//bkp.add(infox0);
	//bkp.add(infox1);
	//bkp.add(infox2);




	Container cpx = getContentPane();
	cpx.setLayout(fl1);
	cpx.setBackground(nm.program_gray_3);
	cpx.setForeground(whitex);
	cpx.add(infox1);
	cpx.add(infox2);

	error_code = 0;

	setVisible(true);








        System.out.println("JDB loader starting in " + framework + " mode");

        /* load the desired JDBC driver */
        loadDriver();


        Connection conn = null;



        ArrayList statements = new ArrayList(); // list of Statements, PreparedStatements
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        Statement s = null;
        ResultSet rs = null;

        try{


            Properties props = new Properties(); // connection properties
            // providing a user name and password is optional in the embedded
            // and derbyclient frameworks
            props.put("user", "user1");
            props.put("password", nm.carbon[4][0][15]);



            String dbName = "listings"; // the name of the database

            String dburl = "your.database.domain"; // the name of the database



            conn = DriverManager.getConnection(protocol + dburl + dbName + ";create=false", props);

            System.out.println("Connected to database " + dbName);

            // We want to control transactions manually. Autocommit is on by
            // default in JDBC.
            conn.setAutoCommit(false);

            /* Creating a statement object that we can use for running various
             * SQL statements commands against the database.*/
            s = conn.createStatement();
            statements.add(s);


	    	String ssp[][];
	    	String ssp2[];



	    	infox2.setText(spacer_0 + "Build string list: ");

	   		Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

	    	ResultSet resultSet = stmt.executeQuery("SELECT * FROM listings");

	    	resultSet.last();
	    	int rowCount = resultSet.getRow();

	    	infox2.setText(spacer_0 + "Build string list: " + Integer.toString(rowCount));


	    	ix0 = rowCount;



			//34594

	    	ssp = new String[100][ix0];
	    	nm.carbon[0] = ssp;

        	rs = s.executeQuery("SELECT address_1, address_2, address_3, address_4, address_5, address_6, buyer_id, buyers_email, buyers_first_name, buyers_last_name, buyers_notes, buyers_phone, currency, custom_1, custom_2, custom_3, custom_4, custom_5, custom_6, custom_7, custom_8, custom_9, custom_10, custom_11, custom_12, custom_13, custom_14, custom_15, custom_16, custom_17, custom_18, custom_19, custom_20, custom_21, custom_22, custom_23, custom_24, custom_25, custom_26, custom_27, custom_28, custom_29, custom_30, custom_31, custom_32, custom_33, custom_34, custom_35, custom_36, custom_37, custom_38, custom_39, custom_40, custom_41, custom_42, custom_43, custom_44, custom_45, custom_46, custom_template, date_last_modified, date_payment_received, date_shipped, date_sold, ebay_item, final_value_fee, handling, hits, item_cost, item_description1, item_description2, item_description3, item_id, item_price, item_weight, listing_fees, listing_id, notes, package_d, package_l, package_w, part_number, payment_type, paypal_fees, picture_1, quantity_sold, sale_id, sale_status, sales_tax, shipping_company, shipping_in, shipping_out, site_id, site_url, source_of_sale, title, title_url, total_on_hand, total_sale_amount, tracking_number, transaction_id, transaction_info FROM listings ORDER BY item_id");





	    	ix0 = 0;
	    	while(rs.next()){

	    		infox2.setText(spacer_0 + "Load items: (" + Integer.toString((ix0 + 1)) + " of " + Integer.toString(rowCount) + ") " + rs.getString(79));

	    		nm.carbon[0][0][ix0] = new String(rs.getString(1));
	    		nm.carbon[0][1][ix0] = new String(rs.getString(2));
	    		nm.carbon[0][2][ix0] = new String(rs.getString(3));
	    		nm.carbon[0][3][ix0] = new String(rs.getString(4));
	    		nm.carbon[0][4][ix0] = new String(rs.getString(5));
	    		nm.carbon[0][5][ix0] = new String(rs.getString(6));
	    		nm.carbon[0][6][ix0] = new String(rs.getString(7));
	    		nm.carbon[0][7][ix0] = new String(rs.getString(8));
	    		nm.carbon[0][8][ix0] = new String(rs.getString(9));
	    		nm.carbon[0][9][ix0] = new String(rs.getString(10));
	    		nm.carbon[0][10][ix0] = new String(rs.getString(11));
	    		nm.carbon[0][11][ix0] = new String(rs.getString(12));
	    		nm.carbon[0][12][ix0] = new String(rs.getString(13));
	    		nm.carbon[0][13][ix0] = new String(rs.getString(14));
	    		nm.carbon[0][14][ix0] = new String(rs.getString(15));
	    		nm.carbon[0][15][ix0] = new String(rs.getString(16));
	    		nm.carbon[0][16][ix0] = new String(rs.getString(17));
	    		nm.carbon[0][17][ix0] = new String(rs.getString(18));
	    		nm.carbon[0][18][ix0] = new String(rs.getString(19));
	    		nm.carbon[0][19][ix0] = new String(rs.getString(20));
	    		nm.carbon[0][20][ix0] = new String(rs.getString(21));
	    		nm.carbon[0][21][ix0] = new String(rs.getString(22));
	    		nm.carbon[0][22][ix0] = new String(rs.getString(23));
	    		nm.carbon[0][23][ix0] = new String(rs.getString(24));
	    		nm.carbon[0][24][ix0] = new String(rs.getString(25));
	    		nm.carbon[0][25][ix0] = new String(rs.getString(26));
	    		nm.carbon[0][26][ix0] = new String(rs.getString(27));
	    		nm.carbon[0][27][ix0] = new String(rs.getString(28));
	    		nm.carbon[0][28][ix0] = new String(rs.getString(29));
	    		nm.carbon[0][29][ix0] = new String(rs.getString(30));
	    		nm.carbon[0][30][ix0] = new String(rs.getString(31));
	    		nm.carbon[0][31][ix0] = new String(rs.getString(32));
	    		nm.carbon[0][32][ix0] = new String(rs.getString(33));
	    		nm.carbon[0][33][ix0] = new String(rs.getString(34));
	    		nm.carbon[0][34][ix0] = new String(rs.getString(35));
	    		nm.carbon[0][35][ix0] = new String(rs.getString(36));
	    		nm.carbon[0][36][ix0] = new String(rs.getString(37));
	    		nm.carbon[0][37][ix0] = new String(rs.getString(38));
	    		nm.carbon[0][38][ix0] = new String(rs.getString(39));
	    		nm.carbon[0][39][ix0] = new String(rs.getString(40));
	    		nm.carbon[0][40][ix0] = new String(rs.getString(41));
	    		nm.carbon[0][41][ix0] = new String(rs.getString(42));
	    		nm.carbon[0][42][ix0] = new String(rs.getString(43));
	    		nm.carbon[0][43][ix0] = new String(rs.getString(44));
	    		nm.carbon[0][44][ix0] = new String(rs.getString(45));
	    		nm.carbon[0][45][ix0] = new String(rs.getString(46));
	    		nm.carbon[0][46][ix0] = new String(rs.getString(47));
	    		nm.carbon[0][47][ix0] = new String(rs.getString(48));
	    		nm.carbon[0][48][ix0] = new String(rs.getString(49));
	    		nm.carbon[0][49][ix0] = new String(rs.getString(50));	    
            	nm.carbon[0][50][ix0] = new String(rs.getString(51));
	    		nm.carbon[0][51][ix0] = new String(rs.getString(52));
	    		nm.carbon[0][52][ix0] = new String(rs.getString(53));
	    		nm.carbon[0][53][ix0] = new String(rs.getString(54));
	    		nm.carbon[0][54][ix0] = new String(rs.getString(55));
	    		nm.carbon[0][55][ix0] = new String(rs.getString(56));
	    		nm.carbon[0][56][ix0] = new String(rs.getString(57));
	    		nm.carbon[0][57][ix0] = new String(rs.getString(58));
	    		nm.carbon[0][58][ix0] = new String(rs.getString(59));
	    		nm.carbon[0][59][ix0] = new String(rs.getString(60));
	    		nm.carbon[0][60][ix0] = new String(rs.getString(61));
	    		nm.carbon[0][61][ix0] = new String(rs.getString(62));
	    		nm.carbon[0][62][ix0] = new String(rs.getString(63));
	    		nm.carbon[0][63][ix0] = new String(rs.getString(64));
	    		nm.carbon[0][64][ix0] = new String(rs.getString(65));
	    		nm.carbon[0][65][ix0] = new String(rs.getString(66));
	    		nm.carbon[0][66][ix0] = new String(rs.getString(67));
	    		nm.carbon[0][67][ix0] = new String(rs.getString(68));
	    		nm.carbon[0][68][ix0] = new String(rs.getString(69));
	    		nm.carbon[0][69][ix0] = new String(rs.getString(70) + rs.getString(71) + rs.getString(72));
	    		nm.carbon[0][70][ix0] = new String(rs.getString(73));
	    		nm.carbon[0][71][ix0] = new String(rs.getString(74));
	    		nm.carbon[0][72][ix0] = new String(rs.getString(75));
	    		nm.carbon[0][73][ix0] = new String(rs.getString(76));
	   		 	nm.carbon[0][74][ix0] = new String(rs.getString(77));	    
            	nm.carbon[0][75][ix0] = new String(rs.getString(78));
	    		nm.carbon[0][76][ix0] = new String(rs.getString(79));
	    		nm.carbon[0][77][ix0] = new String(rs.getString(80));
	    		nm.carbon[0][78][ix0] = new String(rs.getString(81));
	    		nm.carbon[0][79][ix0] = new String(rs.getString(82));
	    		nm.carbon[0][80][ix0] = new String(rs.getString(83));
	    		nm.carbon[0][81][ix0] = new String(rs.getString(84));
	    		nm.carbon[0][82][ix0] = new String(rs.getString(85));
	    		nm.carbon[0][83][ix0] = new String(rs.getString(86));
	    		nm.carbon[0][84][ix0] = new String(rs.getString(87));
	    		nm.carbon[0][85][ix0] = new String(rs.getString(88));
	    		nm.carbon[0][86][ix0] = new String(rs.getString(89));
	    		nm.carbon[0][87][ix0] = new String(rs.getString(90));
	    		nm.carbon[0][88][ix0] = new String(rs.getString(91));
	    		nm.carbon[0][89][ix0] = new String(rs.getString(92));
	    		nm.carbon[0][90][ix0] = new String(rs.getString(93));
	    		nm.carbon[0][91][ix0] = new String(rs.getString(94));
	    		nm.carbon[0][92][ix0] = new String(rs.getString(95));
	   		 	nm.carbon[0][93][ix0] = new String(rs.getString(96));
	    		nm.carbon[0][94][ix0] = new String(rs.getString(97));
	    		nm.carbon[0][95][ix0] = new String(rs.getString(98));
	   		 	nm.carbon[0][96][ix0] = new String(rs.getString(99));
	    		nm.carbon[0][97][ix0] = new String(rs.getString(100));
	    		nm.carbon[0][98][ix0] = new String(rs.getString(101));
	    		nm.carbon[0][99][ix0] = new String(rs.getString(102));


	    		ix0++;

	    	}//while





			for(int loop1 = 0; loop1 < nm.carbon[0].length; loop1++){//***********************

				nm.carbon[0][loop1][0] = "*" + nm.db_string[loop1];

			}//*******************************************************************************



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

            if (framework.equals("embedded"))
            {
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




	pullThePlug();


}//load






    public void pullThePlug() {

    	System.out.println("PULL THE PLUG");

    	nm.firex = 1;

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull







    private void loadDriver() {

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
}

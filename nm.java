import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;   
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Timer;
import java.awt.datatransfer.*;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;
import java.util.*;
import javax.net.ssl.HttpsURLConnection;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.border.EmptyBorder;





public class nm extends JFrame implements ActionListener, KeyListener, MouseListener, MouseMotionListener, ChangeListener, PropertyChangeListener {//*******************************ItemListener,

//setup size
Dimension dimx = new Dimension();//for csv field. 
Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
Dimension jd = new Dimension(1,1);
int jdi0 = 0;
int jdi1 = 0;
static int xzx = 760;
static int xzy = 550;
int sf_xzx = 500;
int sf_xzy = 300;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


private static final long serialVersionUID = 1;

//display engine
alchemy_display_engine dxengine0 = new alchemy_display_engine();
alchemy_display_engine dxengine1 = new alchemy_display_engine();
alchemy_display_engine dxengine2 = new alchemy_display_engine();
alchemy_display_engine dxengine3 = new alchemy_display_engine();
alchemy_display_engine dxengine4 = new alchemy_display_engine();
alchemy_display_engine dxengine5 = new alchemy_display_engine();
alchemy_display_engine dxengine6 = new alchemy_display_engine();

//program update message.
String ebay_api_test_url = new String("https://api.ebay.com/buy/feed/v1_beta/item?feed_scope=NEWLY_LISTED&category_id=625");
String shipping_api_test_url = new String("http://www.alchemistwebshops.com/connect/system_test.php");
String program_update_url = new String("http://www.alchemistwebshops.com/connect/messages.php");
String program_messages_url = new String("http://www.alchemistwebshops.com/connect/messages.php");

//only on windows we can show the try icon for the API.
TrayIcon icon;

//fonts
Font f_01 = new Font("Arial", Font.PLAIN, 11);
Font f_02 = new Font("Arial", Font.PLAIN, 12);
Font f_03 = new Font("Arial", Font.BOLD, 12);

Runtime r = Runtime.getRuntime();
//r.gc();

//database driver
jdb_driver systemx;

static final int FPS_MIN = 0;
static final int FPS_MAX = 5;
static final int FPS_INIT = 0;    //initial frames per second

//Right slider bar for pages
JSlider framesPerPage0 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);
JSlider xselector0 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);

JSlider framesPerPage1 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);
JSlider xselector1 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);

JSlider framesPerPage2 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);
JSlider xselector2 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);

JSlider framesPerPage3 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);
JSlider xselector3 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);

JSlider framesPerPage4 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);
JSlider xselector4 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);

JSlider framesPerPage5 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);
JSlider xselector5 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);

JSlider framesPerPage6 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);
JSlider xselector6 = new JSlider(JSlider.VERTICAL, FPS_MIN, FPS_MAX, FPS_INIT);




//visible container
Container cp = getContentPane();
JWindow start_window = new JWindow();
JLabel jpicture = new JLabel("", JLabel.CENTER);
JLabel jloader_start = new JLabel("Loading", JLabel.LEFT);


//define and add two drop down menu to the menubar
JMenu fileMenu = new JMenu("File");
JMenu editMenu = new JMenu("Edit");
JMenu toolMenu = new JMenu("Tools");
JMenu dataMenu = new JMenu("Database");
JMenu shipMenu = new JMenu("Shipping");
JMenu warehouseMenu = new JMenu("Warehouse");
JMenu separatorx = new JMenu(" | ");
JMenu websMenu = new JMenu("Connections");

//file
JMenuItem openAction = new JMenuItem("Open (.csv) File");
JMenuItem loadAction = new JMenuItem("Load Database");
JMenuItem saveAction = new JMenuItem("Save Settings");
JMenuItem exitAction = new JMenuItem("Exit (Force Shutdown)");
JMenuItem amazon_upload_builder = new JMenuItem("Export Amazon Upload File");
JMenuItem exportcsvinventory = new JMenuItem("Export Inventory.csv");
JMenuItem exportcsv = new JMenuItem("Export .csv");
JMenuItem exportiif = new JMenuItem("Export .iif");
JMenuItem exportxml = new JMenuItem("Export .xml");
JMenuItem exportjson = new JMenuItem("Export .json");
JMenuItem importaction_xml = new JMenuItem("Import .xml");
JMenuItem importaction_json = new JMenuItem("Import .json");
JMenuItem importaction_csv = new JMenuItem("Import .csv");
JMenuItem importaction_csv_inventory = new JMenuItem("Import inventory.csv");
JMenuItem importblack = new JMenuItem("Import Blackthorne .csv");
JMenuItem importturbo = new JMenuItem("Import Turbo Lister .csv");

//edit
JMenuItem newitem = new JMenuItem("Create new item");
JMenuItem newAction = new JMenuItem("Create new item");
JMenuItem duplicate = new JMenuItem("Duplicate");
JMenuItem duplicatex10 = new JMenuItem("Duplicate X 10");
JMenuItem replace = new JMenuItem("Replace");
JMenuItem replace_other = new JMenuItem("Replace to Other Field");
JMenuItem copy_to = new JMenuItem("Copy To");
JMenuItem deleteitem = new JMenuItem("Delete Item");
JMenuItem cutAction = new JMenuItem("Cut");
JMenuItem copyAction = new JMenuItem("Copy");
JMenuItem pasteAction = new JMenuItem("Paste");
JMenuItem edititem = new JMenuItem("Edit Item");

//tools
JMenuItem combo = new JMenuItem("Combo Generator");
JMenuItem combo2 = new JMenuItem("Combo Generator2 (Reaper)");
JMenuItem combo3 = new JMenuItem("Combo Generator3 (1 + 1)");
JMenuItem combo_update_price = new JMenuItem("Update Combo Prices COST +1%");
JMenuItem combo_update_price_down = new JMenuItem("Update Combo Prices COST -1%");
JMenuItem blackmagic = new JMenuItem("Maintain Price");
JMenuItem ship_rates = new JMenuItem("Shipping Rates Settings");
JMenuItem image_3 = new JMenuItem("Java Images Tool 3");
JMenuItem select_20_profit = new JMenuItem("Selected items to 45% profit margin");
JMenuItem pro_tools = new JMenuItem("Pro Scrips");
JMenuItem pro_titles = new JMenuItem("Title SEO");
JMenuItem frame_builder = new JMenuItem("Frame Builder");
JMenuItem alchemy = new JMenuItem("Alchemy(.IIF)");
JMenuItem upload_archive = new JMenuItem("Upload Archive");
JMenuItem alchemy_settings = new JMenuItem("Alchemy Settings");
JMenuItem setview = new JMenuItem("Settings");
JMenuItem viewer = new JMenuItem("Display Viewer");
JMenuItem keyboard_settings = new JMenuItem("Keyboard Commands");
JMenuItem disband_combos = new JMenuItem("Disband Combined Items");
JMenuItem fix_cost_price = new JMenuItem("Fix Cost and Price");
JMenuItem fix_ebay_id = new JMenuItem("Reset eBay listing IDs");
JMenuItem reset_ebay_id = new JMenuItem("Show eBay listing IDs");
JMenuItem build_url_titles = new JMenuItem("Rebuild URL Titles");
JMenuItem change_api_port = new JMenuItem("Change API Port");
JMenuItem change_directory = new JMenuItem("Change working directory");
JMenuItem ebay_final_fee = new JMenuItem("Set eBay Final Value Fee %");
JMenuItem import_shipping_system = new JMenuItem("Import from Shipping System");
JMenuItem import_usps_data = new JMenuItem("Import data from USPS");
JMenuItem import_royal_data = new JMenuItem("Import data from Royal Mail");
JMenuItem tools_rebuild_display = new JMenuItem("Rebuild display");

//database
ButtonGroup group = new ButtonGroup();
JRadioButtonMenuItem connectdbo = new JRadioButtonMenuItem("Local JDB Database");
JRadioButtonMenuItem connectset = new JRadioButtonMenuItem("MySQL Database");
JRadioButtonMenuItem connectcsv = new JRadioButtonMenuItem("CSV File");
JMenuItem databasesettings = new JMenuItem("DB Settings");

//shipping
ButtonGroup group2 = new ButtonGroup();
JRadioButtonMenuItem use_item_x = new JRadioButtonMenuItem("Item Defined Shipping");
JRadioButtonMenuItem use_dazzle = new JRadioButtonMenuItem("Use Dazzle Shipping");
JRadioButtonMenuItem use_ups = new JRadioButtonMenuItem("Use UPS Shipping");
JRadioButtonMenuItem use_email = new JRadioButtonMenuItem("Use eMail Shipping");

JMenuItem shipping_settings_item_x = new JMenuItem("Item Defined Settings");
JMenuItem shipping_settings_dazzle = new JMenuItem("Dazzle Shipping Settings");
JMenuItem shipping_settings_ups = new JMenuItem("UPS Shipping Settings");
JMenuItem shipping_settings_email = new JMenuItem("eMail Settings");

//warehouse
JMenuItem web_goto_shipping = new JMenuItem("Go to Shipping System");
JMenuItem web_goto_inventory = new JMenuItem("Go to Inventory System");
JMenuItem web_goto_add_item = new JMenuItem("Go to Add Item");
JMenuItem web_goto_orders = new JMenuItem("Go to Order System");
JMenuItem export_item = new JMenuItem("Export Inventory");
JMenuItem value_inventory = new JMenuItem("Value Inventory");
JMenuItem weight_inventory = new JMenuItem("Inventory Weight");
JMenuItem order_program = new JMenuItem("Order System");
JMenuItem warehousesettings = new JMenuItem("Warehouse System Settings");

ButtonGroup group3 = new ButtonGroup();
JRadioButtonMenuItem inventory_yes = new JRadioButtonMenuItem("Inventory Management(ON)");
JRadioButtonMenuItem inventory_no = new JRadioButtonMenuItem("Inventory Management(OFF)");

//websites
JMenuItem amazon_errors = new JMenuItem("Amazon Errors");
JMenuItem update_inventory = new JMenuItem("Update My Inventory");
JMenuItem update_warehouse_inventory = new JMenuItem("Update Warehouse Inventory");
JMenuItem ebay_inventory = new JMenuItem("Update eBay Inventory");
JMenuItem ebay_sale_price = new JMenuItem("Update eBay Sale Prices");
JMenuItem custom_update_field = new JMenuItem("Import Custom Fields");
JMenuItem amazon_inventory = new JMenuItem("Update Amazon Inventory");
JMenuItem amazon_sale_price = new JMenuItem("Update Amazon Prices");
JMenuItem update_site_inventory = new JMenuItem("Update Site Inventory");
JMenuItem update_site_sale_price = new JMenuItem("Update Site Prices");


//layout panels 
FlowLayout flow0 = new FlowLayout(0);
FlowLayout flow1 = new FlowLayout(0);
FlowLayout flow2 = new FlowLayout(0);
FlowLayout flow3 = new FlowLayout(0);
FlowLayout flow4 = new FlowLayout(0);
FlowLayout flow5 = new FlowLayout(0);
FlowLayout flow6 = new FlowLayout(0);

JPanel jpk0 = new JPanel(flow0);
JPanel jpk1[] = new JPanel[7];
JPanel jpk2 = new JPanel();
JPanel jpk1_solid = new JPanel();
JPanel jpk2_solid = new JPanel();
JPanel jpk3_solid = new JPanel();
JPanel jpk3 = new JPanel(flow0);//Fotter

JPanel jpk0x = new JPanel();
JPanel jpk1x = new JPanel();
JPanel jpk2x = new JPanel();
JPanel jpk3x = new JPanel();
JPanel jpk4x = new JPanel();
JPanel jpk5x = new JPanel();
JPanel jpk6x = new JPanel();

JPanel jpk_ccc[] = new JPanel[7];//Main display
JPanel jpk_sel[] = new JPanel[7];//Buttons panel

JScrollPane[] scrollPane = new JScrollPane[7];

JTextArea j_message_area_0 = new JTextArea();
JScrollPane j_message_area = new JScrollPane(j_message_area_0, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

JTextArea j_message_send_0 = new JTextArea();
JScrollPane j_message_send = new JScrollPane(j_message_send_0, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

JTextField tf_namex = new JTextField("", 32);
JTextField tf_urlx = new JTextField("", 32);
JTextField tf_userx = new JTextField("", 15);
JTextField tf_passx = new JTextField("", 15);
JTextField tf_key1x = new JTextField("", 15);
JTextField tf_key2x = new JTextField("", 15);


static boolean reset_display_switch = false;//reset the display and tracking if api has updated information. 
static boolean archiving_flag = false;
static boolean delete_flag_change_inventory = false;//update inventory when deleting?
static boolean program_ready_flag = false;//some items should not load until the program is ready.
static boolean program_display_ready = false;//for start up 
static boolean replace_window_open = false;//replace window is open don't open more.
static boolean replace_other_window_open = false;//replace window is open don't open more.
static boolean edit_window_is_open = false;//the item editor is open
static boolean csv_import_open = false;//the csv import window
static boolean account_settings_open = false;//magento settings window is open.
static boolean magento_settings_open = false;//magento settings window is open.
static boolean amazon_settings_open = false;//the amazon settings window is open.
static boolean ebay_settings_open = false;//the ebay settings window is open.
static boolean ebay_token_window_open = false;//the ebay settings window is open.
static boolean etsy_settings_open = false;//the ebay settings window is open.
static boolean custom_settings_open = false;//the custom settings window is open.
static boolean alchemy_shipping_settings = false;//shipping settings window is open.
static boolean warehouse_setting_open = false;//the warehouse window is open
static boolean order_system_open = false;//the order system window is open.
static boolean shipping_settings_open = false;//the shipping system window is open.
static boolean run_silent = false;//should we show the user the imporing screen or not. 
static boolean sales_import_done = false;//the system has finished importing.
boolean searching = false;//if we are searching for something or loading standard. 
boolean ifrunning = false;//slider likes to run lots of times 
boolean rebuild_display = false;
boolean change_tab = false;


static Color program_gray_1 = new Color(0.7f, 0.7f, 0.7f);
static Color program_gray_2 = new Color(0.6f, 0.6f, 0.6f);
static Color program_gray_3 = new Color(0.4f, 0.4f, 0.4f);
static Color grayx1 = new Color(0.7f, 0.7f, 0.7f);
static Color grayx2 = new Color(0.6f, 0.6f, 0.6f);
static Color grayx3 = new Color(0.4f, 0.4f, 0.4f);
static Color st_gray1 = new Color(0.8f, 0.8f, 0.8f);//light gray for sites
static Color st_gray2 = new Color(0.99f, 0.99f, 0.99f);//darker gray for sites
static Color jgray = new Color(0.92f, 0.92f, 0.92f);
static Color jblue = new Color(0.78f, 0.86f, 0.94f);
static Color xstripesc = new Color(0.0f, 0.0f, 0.0f);
static Color xblue = new Color(0.1f, 0.1f, 0.16f);
static Color bluex1 = new Color(0.0f, 0.0f, 0.3f);
static Color bluex2 = new Color(0.1f, 0.17f, 0.39f);
static Color bluex3 = new Color(0.6f, 0.67f, 0.9f);
static Color bluex4 = new Color(0.3f, 0.5f, 0.6f);
static Color darkgray04 = new Color(0.04f, 0.04f, 0.04f);//dark gray
static Color darkgray08 = new Color(0.08f, 0.08f, 0.08f);//dark gray
static Color darkgray01 = new Color(0.156f, 0.156f, 0.156f);//dark gray
static Color darkgray70 = new Color(0.3f, 0.3f, 0.3f);
static Color gray5 = new Color(0.5f, 0.5f, 0.5f);
static Color gray6 = new Color(0.6f, 0.6f, 0.6f);
static Color gray7 = new Color(0.7f, 0.7f, 0.7f);
static Color gray8 = new Color(0.8f, 0.8f, 0.8f);
static Color gray9 = new Color(0.9f, 0.9f, 0.9f);
static Color blackx = new Color(0.0f, 0.0f, 0.0f);
static Color whitex = new Color(1.0f, 1.0f, 1.0f);
static Color purple = new Color(1.0f, 0.0f, 0.8f);
static Color redx = new Color(1.0f, 0.2f, 0.216f);
static Color yellowx = new Color(1.0f, 0.9f, 0.0f);
static Color yellowx2 = new Color(0.8f, 0.7f, 0.0f);
static Color tab_off = gray8;//for the tabs
static Color tab_on = whitex;//for the tabs
static Color lightgreenx = new Color(0.5f, 0.9f, 0.5f);
static Color darkgreenx = new Color(0.1f, 0.3f, 0.1f);
static Color darkgreebnx = new Color(0.1f, 0.3f, 0.1f);
static Color yellow = new Color(0.3f, 0.5f, 0.6f);


//monitor database settings location
static int settings1_mm = 0;
static int settings2_mm = 1;
static int settings3_mm = 2;
static int settings4_mm = 3;
static int settings5_mm = 4;
static int settings6_mm = 5;
static int settings7_mm = 6;
static int settings8_mm = 7;
static int start_time_mm = 8;
static int sold_sales_mm = 9;
static int sold_costs_mm = 10;
static int sold_count_mm = 11;
static int sold_perc_mm = 12;
static int sold_profit_mm = 13;
static int sold_rank_mm = 14;
static int archive_sales_mm = 15;
static int archive_costs_mm = 16;
static int archive_count_mm = 17;
static int archive_perc_mm = 18;
static int archive_profit_mm = 19;
static int archive_rank_mm = 20;
static int set22_mm = 21;
static int set23_mm = 22;
static int set24_mm = 23;
static int set25_mm = 24;
static int set26_mm = 25;
static int set27_mm = 26;
static int set28_mm = 27;
static int set29_mm = 28;
static int set30_mm = 29;
static int set31_mm = 30;
static int set32_mm = 31;
static int set33_mm = 32;
static int set34_mm = 33;
static int set35_mm = 34;
static int set36_mm = 35;
static int set37_mm = 36;
static int set38_mm = 37;
static int set39_mm = 38;
static int set40_mm = 39;
static int set41_mm = 40;
static int set42_mm = 41;
static int set43_mm = 42;
static int set44_mm = 43;
static int set45_mm = 44;
static int set46_mm = 45;
static int set47_mm = 46;
static int set48_mm = 47;
static int set49_mm = 48;
static int set50_mm = 49;
static int set51_mm = 50;
static int set52_mm = 51;
static int set53_mm = 52;
static int set54_mm = 53;
static int set55_mm = 54;
static int set56_mm = 55;
static int set57_mm = 56;
static int set58_mm = 57;
static int set59_mm = 58;
static int set60_mm = 59;
static int set61_mm = 60;
static int set62_mm = 61;
static int set63_mm = 62;
static int set64_mm = 63;
static int set65_mm = 64;
static int set66_mm = 65;
static int set67_mm = 66;
static int set68_mm = 67;
static int set69_mm = 68;
static int set70_mm = 69;
static int set71_mm = 70;
static int set72_mm = 71;
static int set73_mm = 72;
static int set74_mm = 73;
static int set75_mm = 74;
static int set76_mm = 75;
static int set77_mm = 76;
static int set78_mm = 77;
static int set79_mm = 78;
static int set80_mm = 79;
static int set81_mm = 80;
static int set82_mm = 81;
static int set83_mm = 82;
static int set84_mm = 83;
static int set85_mm = 84;
static int set86_mm = 85;
static int set87_mm = 86;
static int set88_mm = 87;
static int set89_mm = 88;
static int set90_mm = 89;
static int set91_mm = 90;
static int set92_mm = 91;
static int set93_mm = 92;
static int set94_mm = 93;
static int set95_mm = 94;
static int set96_mm = 95;
static int set97_mm = 96;
static int set98_mm = 97;
static int set99_mm = 98; 
static int id_mm = 99;


//static int db_int_location[] = new int[100];
static int address_1_xx = 0;
static int address_2_xx = 1;
static int address_3_xx = 2;
static int address_4_xx = 3;
static int address_5_xx = 4;
static int address_6_xx = 5;
static int buyer_id_xx = 6;
static int buyers_email_xx = 7;
static int buyers_first_name_xx = 8;
static int buyers_last_name_xx = 9;
static int buyers_notes_xx = 10;
static int buyers_phone_xx = 11;
static int currency_xx = 12;
static int custom_1_xx = 13;
static int custom_2_xx = 14;
static int custom_3_xx = 15;
static int custom_4_xx = 16;
static int custom_5_xx = 17;
static int custom_6_xx = 18;
static int custom_7_xx = 19;
static int custom_8_xx = 20;
static int custom_9_xx = 21;
static int custom_10_xx = 22;
static int custom_11_xx = 23;
static int custom_12_xx = 24;
static int custom_13_xx = 25;
static int custom_14_xx = 26;
static int custom_15_xx = 27;
static int custom_16_xx = 28;
static int custom_17_xx = 29;
static int custom_18_xx = 30;
static int custom_19_xx = 31;
static int custom_20_xx = 32;
static int custom_21_xx = 33;
static int custom_22_xx = 34;
static int custom_23_xx = 35;
static int custom_24_xx = 36;
static int custom_25_xx = 37;
static int custom_26_xx = 38;
static int custom_27_xx = 39;
static int custom_28_xx = 40;
static int custom_29_xx = 41;
static int custom_30_xx = 42;
static int custom_31_xx = 43;
static int custom_32_xx = 44;
static int custom_33_xx = 45;
static int custom_34_xx = 46;
static int custom_35_xx = 47;
static int custom_36_xx = 48;
static int custom_37_xx = 49;
static int custom_38_xx = 50;
static int custom_39_xx = 51;
static int custom_40_xx = 52;
static int custom_41_xx = 53;
static int custom_42_xx = 54;
static int custom_43_xx = 55;
static int custom_44_xx = 56;
static int custom_45_xx = 57;
static int custom_46_xx = 58;
static int custom_template_xx = 59;
static int date_last_modified_xx = 60;
static int date_payment_received_xx = 61;
static int date_shipped_xx = 62;
static int date_sold_xx = 63;
static int ebay_item_xx = 64;
static int final_value_fee_xx = 65;
static int handling_xx = 66;
static int hits_xx = 67;
static int item_cost_xx = 68;
static int item_description_xx = 69;
static int item_id_xx = 70;
static int item_price_xx = 71;
static int item_weight_xx = 72;
static int listing_fees_xx = 73;
static int listing_id_xx = 74;
static int notes_xx = 75;
static int package_d_xx = 76;
static int package_l_xx = 77;
static int package_w_xx = 78;
static int part_number_xx = 79;
static int payment_type_xx = 80;
static int paypal_fees_xx = 81;
static int picture_1_xx = 82;
static int quantity_sold_xx = 83;
static int sale_id_xx = 84;
static int sale_status_xx = 85;
static int sales_tax_xx = 86;
static int shipping_company_xx = 87;
static int shipping_in_xx = 88;
static int shipping_out_xx = 89;
static int site_id_xx = 90;
static int site_url_xx = 91;
static int source_of_sale_xx = 92;
static int title_xx = 93;
static int title_url_xx = 94;
static int total_on_hand_xx = 95;
static int total_sale_amount_xx = 96;
static int tracking_number_xx = 97;
static int transaction_id_xx = 98; 
static int transaction_info_xx = 99;


//connection settings locations
static int name_info_xx = 0;
static int urlx_info_xx = 1;
static int user_info_xx = 2;
static int pass_info_xx = 3;
static int key1_info_xx = 4;
static int key2_info_xx = 5;
static int key3_info_xx = 6;//unused
static int key4_info_xx = 7;//unused
static int id_info_xx = 8;
static int date_info_xx = 9;
static int type_info_xx = 10;
static int active_info_xx = 11;
//static int active_info_xx = 12;//unused
//static int active_info_xx = 13;//unused
//static int active_info_xx = 14;//unused
//static int active_info_xx = 15;//unused


//int settings static
static int selected_int[] = new int[0];//what items are selected
static int warning_list[] = new int[0];
static int error_list[] = new int[0];
static int api_server_port = 8558;//port of the API server
static int server_requests = 0;
static int firex = 0;//extension start end
static int firex2 = 0;//extension start end
static int firex22 = 0;//wait for ebay silent.
static int firex_edit = 0;//extension start end
static int auto_sales = 0;// auto matic sales system.
static int db_cc_number_active = 13;//
static int db_cc_number = 100;//the size of the listing
static int db_ss_number = 100;//the size of the settings list
static int db_cx_number = 100;//the size of the connections list
static int db_dd_number = 300;//the size of the settings display
static int ss_create = 0;
static int ss_monitor = 1;
static int ss_sold = 2;
static int ss_archive = 3;
static int ss_settings = 4;
static int ss_accounts = 5;
static int ss_display = 6;
static int display_count = 300;//number of items to display on each page.
static int database_load_mode = 1;//0 1 2
static int html_view_number = 0;// 1 = item 2 = template 3 = item + template
static int items_total = 50;//total number of alchemist items**
static int items_value = 50;//active number of items total on this page. 
static int items_start = 0;//start location of items for pages.
static int items_end = 50;//end location of items for pages.
static int items_page0_start = 0;//offset
static int items_page1_start = 0;//offset
static int items_page2_start = 0;//offset
static int items_page3_start = 0;//offset
static int db_00_size = 0;//size of the listings db
static int db_02_size = 0;//size of the sold db
static int db_03_size = 0;//size of the archived db
static int total_items_selected = 0;
static int what_item0 = 0;//for combo3
static int what_item_old = 1;
static int what_item_old_select = 0;
static int what_item_selected = 0;//what item was selected before a refresh.
static int what_item_api_switch = 0;//what item the api has just updated 
static int what_item_display = 0;//the real display item on other pages not just the first page
static int what_frame_page = 0;//framesPerPage0.getValue
static int what_item_frame = 0;//frame builder
static int what_item_amazon_update = 0;
static int current_submit_item_a = 0;//the account position where the info is
static int current_submit_item_x = 0;//the drop down menu number selected, it doesn't match up with an account. 
static int section_number0 = 0;//page section. side bar
static int section_number1 = 0;//page section. side bar
static int section_number2 = 0;//page section. side bar
static int section_number3 = 0;//page section. side bar
static int program_working = 0;//the program is working don't mess it up. 
static int auto_ebay_import = 0;//the item editor is open 1
static int amazon_settings_item = 0;//settings in test mode is not the same as the current submit item. 
static int paypal_settings_item = 0;//settings in test mode is not the same as the current submit item. 
static int etsy_settings_item = 0;//settings in test mode is not the same as the current submit item.
static int load_limit = 300;//number of items to load in display.
static int search_load_limit = 1000;//number of items to load in display.
static int db_number = 0;//current database number. 1-7
static int internet_access = 0;//we have internet access
static int shipping_api_access = 0;//we have a connection to the host
static int what_item = 0;//what item is current selected in blue
int what_column = 0;//what column the user selected
int select_all_itemsx_listed = 0;
int select_sites_int = 1;
int line_errors = 0;//how many errors this list has
int line_warnings = 0;//how many warnings this list has
int slow_refresh = 0;
int stripesx = 0;
int header_size = 23;//display info
int body_size = 700;//display info
int item_size = 18;//display info
int base_size = 140;//display info
int footer_size = 20;//display info
int response;
int products_items = 50;
int combostart1 = 0;
int combostart2 = 0;
int new_sales_int = 0;
int sort_int = 79;//what database to sort
int use_message_text = 0;// db location
int what_search_field = 0;
int custom_select = 0;// which custom secton to update from website.
int program_setup = 0;//set up the archive db


//sales data	
int view_data_i_total = 0;
int view_data_i_newsales = 0;
int view_data_i_ready = 0;
int view_data_i_shipped = 0;
int view_data_i_delivered = 0;
int view_data_i_refunded = 0;
int view_data_i_errors = 0;
int view_data_i_success = 0;


static String[][][] carbon = new String[9][7][7];
static String[] db_settings_string = new String[db_ss_number];
static String[] db_string = new String[db_cc_number];
static String[] new_item_db_string = new String[db_cc_number];
static String[] jdb_load_sales_ids = new String[10];//load the sales ids for import blocking
static String[] jdb_load_list = new String[10];
static String[][] carbon_post = new String[db_cc_number][100];
static String stats_name = new String("");
static String stats_url = new String("");
static String stats_running = new String("");
static String stats_hits = new String("");
static String stats_sales = new String("");
static String ebay_tx = new String("");
static String pass_log_5 = new String("user1");//db
static String pass_log_6 = new String("911929183");//db
static String program_location = new String("");
static String working_message = new String("");//what is the program doing? window
static String program_name = new String("Alkhimist");
static String program_version = new String("1.4.0");
static String program_date = new String("15-OCT-2019");
static String program_version_info = new String("140");
String sort_array[] = new String[37];//needed for sorting
String carbon_export[] = new String[1];
String cx_a0[][] = new String[1][1];//open string array for anyone to use
String cx_a1[][] = new String[1][1];//open string array for anyone to use
String[][] carbon_passover = new String[7][7];
String[][] carbon_load = new String[7][7];
String[] load_yes_no_list = new String[2];
String[] load_site_list = new String[7];//accounts
String[] shipping_status = new String[8];
String[] color_choice = new String[4];
String[] set_on_off = new String[2];//on off
String[] load_search_list = new String[db_cc_number];//on off
String tracking_test_id = new String("");//test if an item has been shipped. 
String sort_string = new String("part_number");//the name of the header to sort with.
String xlinex = new String("");
String blank = new String("");
String save_item_control = new String("");
String error_message_list = new String("error");

//main program loop
Timer xtimerx;//class loop.
Toolkit toolkit;

//logo
Image ximagex;

//footer icons
Icon imx_message_red;//message red
Icon imx_message_green;//message green
Icon imx_settings;//settings
Icon imx_database;//database
Icon imx_messages;//messages
Icon imx_download;//download



//header*******************************************************************************************

JTabbedPane tabbedPane = new JTabbedPane();

JComboBox<String> cb_active_site;
JComboBox<String> cb_search_field;
JComboBox<String> cb_active;
JComboBox<String> cb_sitese;

JLabel spacer_0 = new JLabel("", JLabel.RIGHT);//for header frame
JLabel spacer_1 = new JLabel("", JLabel.RIGHT);//for header frame
JLabel spacer_2 = new JLabel("Respond", JLabel.LEFT);//for messages jpanel
JLabel spacer_3 = new JLabel("", JLabel.LEFT);//for messages jpanel
JLabel spacer_4 = new JLabel("Connection:", JLabel.RIGHT);//for messages jpanel

JTextField search_tf = new JTextField("", 15);

JButton search_b = new JButton("Search");

JPanel header_panel = new JPanel();

JLabel infox0 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox2 = new JLabel("", JLabel.LEFT);
JLabel infox3 = new JLabel("website", JLabel.CENTER);
JLabel infox4 = new JLabel("", JLabel.LEFT);
JLabel infox5 = new JLabel("", JLabel.LEFT);

//header*******************************************************************************************

//body*********************************************************************************************

JButton select_all = new JButton("All");
JButton select_quantity = new JButton("Quanitity");
JButton select_combo = new JButton("Combo");

JButton select_ebayid = new JButton("eBay ID");
JButton select_amazonid = new JButton("Amazon");
JButton select_sold_s1 = new JButton("Amazon");
JButton select_sold_s2 = new JButton("Custom");
JButton select_sold_s3 = new JButton("eBay");
JButton select_sold_s4 = new JButton("Etsy");
JButton select_sold_s5 = new JButton("Magento");
JButton select_sold_s6 = new JButton("MySQL");
JButton select_sold_s7 = new JButton("PayPal");
JButton select_listed = new JButton("Status");
JButton select_types = new JButton("Types");
JButton select_sites = new JButton("Sites");

JButton select_archive_s1 = new JButton("Amazon");
JButton select_archive_s2 = new JButton("Custom");
JButton select_archive_s3 = new JButton("eBay");
JButton select_archive_s4 = new JButton("Etsy");
JButton select_archive_s5 = new JButton("Magento");
JButton select_archive_s6 = new JButton("MySQL");
JButton select_archive_s7 = new JButton("PayPal");

JButton select_space1 = new JButton("");
JButton select_space2 = new JButton("");

JPanel topPanel;

JPanel export_panel;
JPanel monitor_panel;
JPanel sold_panel;
JPanel archive_panel;
JPanel settings_panel;
JPanel connections_panel;
JPanel display_panel;
JPanel import_panel;

//body*********************************************************************************************

//Export*******************************************************************************************

JLabel item_label0 = new JLabel("Loading...", JLabel.LEFT);

JTextField tf_title = new JTextField("", 35);
JTextField tf_part = new JTextField("", 16);
JTextField tf_d = new JTextField("", 6);
JTextField tf_l = new JTextField("", 6);
JTextField tf_w = new JTextField("", 6);
JTextField tf_weight = new JTextField("", 6);
JTextField tf_cost = new JTextField("", 6);
JTextField tf_price = new JTextField("", 6);
JTextField tf_onhand = new JTextField("", 5);
JTextField tf_picture_1 = new JTextField("", 44);
JTextField tf_custom_1 = new JTextField("", 30);
JTextField tf_custom_2 = new JTextField("", 20);
JTextField tf_custom_3 = new JTextField("", 20);

JLabel item_label0_1 = new JLabel("xx", JLabel.LEFT);
JLabel item_label0_2 = new JLabel("xx", JLabel.LEFT);

//Export*******************************************************************************************

//Monitor******************************************************************************************

JLabel item_label1 = new JLabel("Loading...", JLabel.LEFT);

JButton refresh_db = new JButton("Refresh Site");
JButton refresh_all_db = new JButton("Refresh DB");
JButton empty_db = new JButton("Drop DB");
//JButton _db = new JButton("Drop DB");

JPanel mpanel0 = new JPanel();
JPanel mpanel1 = new JPanel();
JPanel mpanel2 = new JPanel();
JPanel mpanel3 = new JPanel();

JLabel view_hm0 = new JLabel("Remote Database", JLabel.CENTER);
JLabel view_hm2 = new JLabel("Sales DB2", JLabel.CENTER);
JLabel view_hm3 = new JLabel("Archive DB3", JLabel.CENTER);

JLabel viewx_0m1 = new JLabel("x", JLabel.LEFT);
JLabel viewx_0m2 = new JLabel("x", JLabel.LEFT);
JLabel viewx_0m3 = new JLabel("x", JLabel.LEFT);
JLabel viewx_0m4 = new JLabel("x", JLabel.LEFT);
JLabel viewx_0m5 = new JLabel("x", JLabel.LEFT);

JLabel viewx_2m1 = new JLabel("x", JLabel.LEFT);
JLabel viewx_2m2 = new JLabel("x", JLabel.LEFT);
JLabel viewx_2m3 = new JLabel("x", JLabel.LEFT);
JLabel viewx_2m4 = new JLabel("x", JLabel.LEFT);
JLabel viewx_2m5 = new JLabel("x", JLabel.LEFT);

JLabel viewx_3m1 = new JLabel("x", JLabel.LEFT);
JLabel viewx_3m2 = new JLabel("x", JLabel.LEFT);
JLabel viewx_3m3 = new JLabel("x", JLabel.LEFT);
JLabel viewx_3m4 = new JLabel("x", JLabel.LEFT);
JLabel viewx_3m5 = new JLabel("x", JLabel.LEFT);

JLabel view_0m1 = new JLabel("", JLabel.LEFT);
JLabel view_0m2 = new JLabel("", JLabel.LEFT);
JLabel view_0m3 = new JLabel("", JLabel.LEFT);
JLabel view_0m4 = new JLabel("", JLabel.LEFT);
JLabel view_0m5 = new JLabel("", JLabel.LEFT);

JLabel view_2m1 = new JLabel("", JLabel.LEFT);
JLabel view_2m2 = new JLabel("", JLabel.LEFT);
JLabel view_2m3 = new JLabel("", JLabel.LEFT);
JLabel view_2m4 = new JLabel("", JLabel.LEFT);
JLabel view_2m5 = new JLabel("", JLabel.LEFT);

JLabel view_3m1 = new JLabel("", JLabel.LEFT);
JLabel view_3m2 = new JLabel("", JLabel.LEFT);
JLabel view_3m3 = new JLabel("", JLabel.LEFT);
JLabel view_3m4 = new JLabel("", JLabel.LEFT);
JLabel view_3m5 = new JLabel("", JLabel.LEFT);

//Monitor******************************************************************************************

//sold panel***************************************************************************************

JLabel item_label2 = new JLabel("", JLabel.LEFT);

JPanel sold_1 = new JPanel();
JPanel sold_2 = new JPanel(flow1);
JPanel sold_3 = new JPanel();

JComboBox<String> sale_status_cb;
JButton sale_status_b = new JButton("STATUS");
JButton sale_status_b_archive = new JButton("STATUS");

JLabel sold_sp = new JLabel("Sale Price................................................................", JLabel.LEFT);
JLabel sold_cp = new JLabel("Cost......................................................................", JLabel.LEFT);
JLabel sold_si = new JLabel("Shipping In...............................................................", JLabel.LEFT);
JLabel sold_so = new JLabel("Shipping Out..............................................................", JLabel.LEFT);
JLabel sold_tax = new JLabel("Taxes....................................................................", JLabel.LEFT);
JLabel sold_fee = new JLabel("Transaction Fees.........................................................", JLabel.LEFT);

JLabel sold_costs = new JLabel("     Costs: ", JLabel.LEFT);
JLabel sold_profit = new JLabel("     Total Profit: ", JLabel.LEFT);

JTextField sold_tf_sp = new JTextField("", 4);
JTextField sold_tf_cp = new JTextField("", 4);
JTextField sold_tf_si = new JTextField("", 4);
JTextField sold_tf_so = new JTextField("", 4);
JTextField sold_tf_tax = new JTextField("", 4);
JTextField sold_tf_fee = new JTextField("", 4);

JButton sold_track = new JButton("Track");

JTextArea sold_address;

JTextField sold_tracking = new JTextField("", 18);

JButton sold_received = new JButton("E-mail");
JButton sold_shipped = new JButton("E-mail");
JButton sold_done = new JButton("E-mail");
JButton sold_blank = new JButton("E-mail");

JLabel sold_received_l = new JLabel("User Info", JLabel.LEFT);
JLabel sold_shipped_l = new JLabel("Shipped", JLabel.LEFT);
JLabel sold_done_l = new JLabel("Success", JLabel.LEFT);
JLabel sold_blank_l = new JLabel("Blank", JLabel.LEFT);

JLabel sold_header1 = new JLabel("Send E-mail", JLabel.LEFT);

JTextField sold_tf_username = new JTextField("", 12);
JTextField sold_tf_email = new JTextField("", 12);
JTextField sold_tf_saleid = new JTextField("", 12);

//sold panel***************************************************************************************

//archive******************************************************************************************

JLabel item_label3 = new JLabel("Loading...", JLabel.LEFT);

JTextArea archive_address;

JTextField archive_tf_email = new JTextField("", 17);
JTextField archive_tf_saleid = new JTextField("", 17);

JLabel archive_spacerx = new JLabel("", JLabel.LEFT);

JButton archive_track = new JButton("Track");
JButton archive_c1 = new JButton("");
JButton archive_c2 = new JButton("");
JButton archive_c3 = new JButton("Refresh Stats");

JButton archive_info1 = new JButton("Info");
JButton archive_info2 = new JButton("Info");
JButton archive_info3 = new JButton("Info");

JLabel al_total_sales = new JLabel("Total Sales:", JLabel.RIGHT);
JLabel al_total_costs = new JLabel("Total Costs:", JLabel.RIGHT);
JLabel al_total_taxes = new JLabel("Taxes:", JLabel.RIGHT);
JLabel al_total_shipping = new JLabel("Shipping(Paid):", JLabel.RIGHT);
JLabel al_total_profit = new JLabel("Total Profit:", JLabel.RIGHT);

JLabel al_total_sales_n = new JLabel("0.0", JLabel.RIGHT);
JLabel al_total_costs_n = new JLabel("0.0", JLabel.RIGHT);
JLabel al_total_taxes_n = new JLabel("0.0", JLabel.RIGHT);
JLabel al_total_shipping_n = new JLabel("0.0", JLabel.RIGHT);
JLabel al_total_profit_n = new JLabel("0.0", JLabel.RIGHT);

JLabel al_total_sold = new JLabel("Total Sold: ", JLabel.RIGHT);
JLabel al_total_refunded = new JLabel("Total Refunded: ", JLabel.RIGHT);
JLabel al_total_errors = new JLabel("Total Errors: ", JLabel.RIGHT);

JLabel al_total_sold_n = new JLabel("0.0", JLabel.RIGHT);
JLabel al_total_refunded_n = new JLabel("0.0", JLabel.RIGHT);
JLabel al_total_errors_n = new JLabel("0.0", JLabel.RIGHT);

//archive******************************************************************************************

//settings*****************************************************************************************

JLabel item_label4 = new JLabel("Loading...", JLabel.LEFT);

JLabel set_info_text = new JLabel("These items are generated by the program and cannot be edited.", JLabel.LEFT);

//settings*****************************************************************************************

//connections**************************************************************************************

JLabel item_label5 = new JLabel("Loading...", JLabel.LEFT);

JLabel item_label5x_0 = new JLabel("", JLabel.LEFT);
JLabel item_label5x_1 = new JLabel("", JLabel.LEFT);
JLabel item_label5x_2 = new JLabel("Active:", JLabel.RIGHT);
JLabel item_label5x_3 = new JLabel("Account:", JLabel.RIGHT);
JLabel item_label5x_4 = new JLabel("", JLabel.RIGHT);
JLabel item_label5x_5 = new JLabel("", JLabel.LEFT);

JLabel item_label5_0 = new JLabel("name:", JLabel.RIGHT);
JLabel item_label5_1 = new JLabel("Site URL or API:", JLabel.RIGHT);
JLabel item_label5_2 = new JLabel("User Name:", JLabel.RIGHT);
JLabel item_label5_3 = new JLabel("User Password:", JLabel.RIGHT);
JLabel item_label5_4 = new JLabel("Key 1", JLabel.RIGHT);
JLabel item_label5_5 = new JLabel("Key 2", JLabel.RIGHT);
JLabel item_label5_6 = new JLabel("Loading...", JLabel.LEFT);

JButton ws_test = new JButton("Test");
JButton ws_save = new JButton("Save");
JButton get_ebay_token = new JButton("Generate Key");
JButton get_settings_x = new JButton("Settings");

//connections**************************************************************************************

//display******************************************************************************************

JLabel item_label6 = new JLabel("Loading...", JLabel.LEFT);

JLabel set_info0 = new JLabel("Error list...", JLabel.LEFT);
JLabel set_info1 = new JLabel("Active:", JLabel.RIGHT);
JLabel set_info2 = new JLabel("Order:", JLabel.RIGHT);
JLabel set_info3 = new JLabel("Size:", JLabel.RIGHT);
JLabel set_info4 = new JLabel("Color:", JLabel.RIGHT);
JLabel set_info5 = new JLabel("", JLabel.LEFT);

JButton set_save = new JButton("Save");
JButton set_rebuild_display = new JButton("Reset Display");

JTextField set_tf_position = new JTextField("", 4);
JTextField set_tf_size = new JTextField("", 4);

JComboBox<String> set_status_on;
JComboBox<String> set_status_color;

//display******************************************************************************************

//body2********************************************************************************************

JButton submit = new JButton("Export");
JButton importx = new JButton("Import");
JButton refresh = new JButton("Refresh");
JButton print_shipping = new JButton("Shipping Label");
JButton archivex = new JButton("Archive");

JButton new_item = new JButton("New");
JButton edit_item = new JButton("Edit");
JButton delete = new JButton("Delete");
JButton settings_edit = new JButton("Edit Settings");
JButton view_item = new JButton("Preview");
JButton empty_site = new JButton("Empty DB");

//body2********************************************************************************************

//import settings**********************************************************************************

JPanel import_panel_bar = new JPanel();

static JScrollPane import_amazon_sp;
static JScrollPane import_custom_sp;
static JScrollPane import_ebay_sp;
static JScrollPane import_etsy_sp;
static JScrollPane import_magento_sp;
static JScrollPane import_mysql_sp;
static JScrollPane import_krypton_sp;
static JScrollPane import_paypal_sp;
static JScrollPane import_gmail_sp;

//import settings**********************************************************************************

//footer*******************************************************************************************

JLabel fii0 = new JLabel(program_version + "  " + program_date, JLabel.LEFT);
JLabel fii1 = new JLabel("(0) Message(s)", JLabel.LEFT);
JButton messages_db_button = new JButton("(0) Message(s)");
JLabel fii2 = new JLabel("Database: Local CSV", JLabel.LEFT);

JButton program_version_button = new JButton("Shipping System API");
JButton program_message_button = new JButton("Program Internet Access");

//footer*******************************************************************************************











// Program start

nm() {//**************************************************************************************************************************

	super(program_name + " - Database and Sales Management");
	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); 
	setBackground(program_gray_3);


	//If something fails here we don't want the settings screen logo to stay on. 
	try {

		//Show start screen.
		alchemy_start_screen start_screen = new alchemy_start_screen();

		//Load settings.
		load_jdb_settings();

		File location_xx4 = new File("Alchemist.jar");
		program_location = location_xx4.getAbsoluteFile().toString();
		program_location = program_location.substring(0, program_location.length() - 13);



		try {

			jdi0 = Integer.parseInt(carbon[4][0][0]);
			jdi1 = Integer.parseInt(carbon[4][0][1]);

		} catch (Exception e) {

			//If the program database doesn't load we set basic size. 
			jdi0 = 800;
			jdi1 = 500;

		}//********************


		xzx = jdi0;
		xzy = jdi1;

		jd = getSize();
		cenx = (scrSize.width / 2) - (xzx / 2);
		ceny = (scrSize.height / 2) - (xzy / 2) - 25;
		setSize(xzx, xzy);
		setLocation(cenx, ceny);
		//setResizable(false);
	    addWindowListener(new WindowAdapter(){
	   	public void windowClosing(WindowEvent e){

	    	SystemTray.getSystemTray().remove(icon); 
	    	setVisible(false); 
	    	save_jdb_settings(); 
	    	systemx.shutdown(); 
	    	System.exit(0);

	   	}
	    });

		addWindowStateListener(new WindowStateListener() {
		public void windowStateChanged(WindowEvent arg0) {

		    frame__windowStateChanged(arg0);
		      
		}
		});




	//load images from JAR
		ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
		setIconImage(ximagex);

	//get button images from the Jar file.
		imx_message_green = new ImageIcon(this.getClass().getResource("images/message-yes.png"));
		imx_message_red = new ImageIcon(this.getClass().getResource("images/message-no.png"));
		imx_settings = new ImageIcon(this.getClass().getResource("images/settings.png"));
		imx_database = new ImageIcon(this.getClass().getResource("images/database.png"));
		imx_messages = new ImageIcon(this.getClass().getResource("images/messages.png"));
		imx_download = new ImageIcon(this.getClass().getResource("images/download.png"));


		jpk0.setLayout(flow0);

		flow0.setHgap(5);
		flow0.setVgap(0);

		flow1.setHgap(0);
		flow1.setVgap(0);

		flow2.setHgap(7);
		flow2.setVgap(9);

		flow3.setHgap(0);
		flow3.setVgap(5);

		flow4.setHgap(5);
		flow4.setVgap(1);

		flow5.setHgap(15);
		flow5.setVgap(1);
		flow5.setAlignment(FlowLayout.CENTER);

		flow6.setHgap(15);
		flow6.setVgap(0);
		flow6.setAlignment(FlowLayout.CENTER);



	//header******************************************************************************

	    search_tf.setToolTipText("Search for ");
		search_tf.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, whitex));

		//String[] load_yes_no_list = new String[2];
		load_yes_no_list[0] = new String("no");
		load_yes_no_list[1] = new String("yes");

		cb_active = new JComboBox<String>(load_yes_no_list);
		cb_active.setSelectedIndex(0);
		cb_active.addActionListener(this);
		cb_active.setPreferredSize(new Dimension(100, 20));
		cb_active.setEnabled(false);

		//String[] load_site_list = new String[7];
		load_site_list[0] = new String("Amazon");
		load_site_list[1] = new String("Custom");
		load_site_list[2] = new String("eBay");	
		load_site_list[3] = new String("Etsy");
		load_site_list[4] = new String("Magento");
		load_site_list[5] = new String("MySQL");
		load_site_list[6] = new String("PayPal");

		cb_sitese = new JComboBox<String>(load_site_list);
		cb_sitese.setSelectedIndex(0);
		cb_sitese.addActionListener(this);
		cb_sitese.setPreferredSize(new Dimension(100, 20));
		cb_sitese.setToolTipText("Type of website");

		String[] load_empty_list = new String[1];
		load_empty_list[0] = new String("NO ITEMS");

		cb_active_site = new JComboBox<String>(load_empty_list);
		cb_active_site.setSelectedIndex(0);
		cb_active_site.addActionListener(this);
		cb_active_site.setPreferredSize(new Dimension(150, 20));
		cb_active_site.setToolTipText("Set Active Website");
		//cb_active_site.setBorder(BorderFactory.createLineBorder(Color.black, 1));

		//String[] load_search_list = new String[db_cc_number];
		for (int xloopx = 0; xloopx < db_cc_number; xloopx++) {//******

			//System.out.println(carbon[0][xloopx][0]);
			load_search_list[xloopx] = new String(db_string[xloopx]);
		
		}//for*********************************************************

		cb_search_field = new JComboBox<String>(load_search_list);
		cb_search_field.setSelectedIndex(0);
		cb_search_field.addActionListener(this);
		cb_search_field.setPreferredSize(new Dimension(120, 20));
		cb_search_field.setToolTipText("In which field");
		cb_search_field.setFont(f_01);

		infox0.setForeground(blackx);
		infox0.setBackground(gray6);//darkgray01
		infox0.setOpaque(true);
		infox0.setPreferredSize(new Dimension(200,20));
		infox0.setToolTipText("Database diplay section");
		infox0.setFont(f_01);
		infox0.setIcon(imx_database); 

		infox1.setForeground(blackx);
		infox1.setBackground(gray6);//darkgray01
		//infox1.setOpaque(true);
		infox1.setPreferredSize(new Dimension(500,20));
		infox1.setToolTipText("Program status info");
		infox1.setFont(f_01);

		infox2.setForeground(blackx);
		infox2.setBackground(gray6);//gray6
		infox2.setOpaque(true);
		infox2.setPreferredSize(new Dimension(166,20));
		infox2.setToolTipText("<html>Program status info 3 <br>Refresh: 1 Hour<br>Shipping Status: 1 Hour<br>Ship Order: 1 Min</html>");
		infox2.setFont(f_01);

		infox3.setForeground(bluex2);//blackx
		infox3.setBackground(gray7);
		infox3.setOpaque(true);
		infox3.setPreferredSize(new Dimension(150,20));
		infox3.setToolTipText("Account type");
		infox3.setFont(f_01);

		infox4.setForeground(blackx);
		infox4.setBackground(gray6);//darkgray01
		infox4.setOpaque(true);
		infox4.setPreferredSize(new Dimension(20,20));
		//infox4.setToolTipText("Program status info 5");
		infox4.setFont(f_01);

		infox5.setForeground(blackx);
		infox5.setBackground(gray6);//darkgray01
		infox5.setOpaque(true);
		infox5.setPreferredSize(new Dimension(30,20));
		//infox5.setToolTipText("Program status info 5");
		infox5.setFont(f_01);

		header_panel.setPreferredSize(new Dimension(xzx - 10, 35));
		header_panel.setBackground(gray7);//darkgray08
		header_panel.setLayout(flow3);
		header_panel.add(infox0);
		header_panel.add(infox1);
		header_panel.add(infox2);
		header_panel.add(infox4);
		header_panel.add(infox3);
		header_panel.add(infox5);

		search_b.setMargin(new Insets(0, 0, 0, 0));
	  	search_b.addActionListener(this);
		search_b.setPreferredSize(new Dimension(55, 20));
	 	//search_b.setIcon(imx4);
		search_b.setBackground(jgray);
		search_b.setHorizontalTextPosition(JButton.CENTER);
	 	search_b.setForeground(blackx);

		spacer_0.setPreferredSize(new Dimension(80, 25));
		spacer_1.setPreferredSize(new Dimension(50, 25));
		spacer_2.setPreferredSize(new Dimension(120, 25));
		spacer_3.setPreferredSize(new Dimension(60, 25));
		spacer_4.setPreferredSize(new Dimension(70, 25));


	//header*******************************************************************************************

	//csvx*********************************************************************************************


		framesPerPage0.addChangeListener(this);
		framesPerPage0.setPreferredSize(new Dimension(30, 400));

		//Turn on labels at major tick marks.
		framesPerPage0.setMajorTickSpacing(1);
		framesPerPage0.setMinorTickSpacing(1);
		framesPerPage0.setPaintTicks(true);
		framesPerPage0.setPaintLabels(false);
		framesPerPage0.setPaintTrack(false); 
		framesPerPage0.setSnapToTicks(true); 
		framesPerPage0.setInverted(true);
		//framesPerPage.setTickColor(whitex);


		xselector0.addChangeListener(this);
		xselector0.setPreferredSize(new Dimension(60, 400));

		//Turn on labels at major tick marks.
		xselector0.setMajorTickSpacing(1);
		xselector0.setMinorTickSpacing(1);
		xselector0.setPaintTicks(true);
		xselector0.setPaintLabels(true);
		xselector0.setPaintTrack(false); 
		xselector0.setSnapToTicks(true); 
		xselector0.setInverted(true);
		//xselector.setTickColor(whitex);



		framesPerPage1.addChangeListener(this);
		framesPerPage1.setPreferredSize(new Dimension(30, 400));

		//Turn on labels at major tick marks.
		framesPerPage1.setMajorTickSpacing(1);
		framesPerPage1.setMinorTickSpacing(1);
		framesPerPage1.setPaintTicks(true);
		framesPerPage1.setPaintLabels(false);
		framesPerPage1.setPaintTrack(false); 
		framesPerPage1.setSnapToTicks(true); 
		framesPerPage1.setInverted(true);
		//framesPerPage1.setTickColor(whitex);

		xselector1.addChangeListener(this);
		xselector1.setPreferredSize(new Dimension(60, 400));

		//Turn on labels at major tick marks.
		xselector1.setMajorTickSpacing(1);
		xselector1.setMinorTickSpacing(1);
		xselector1.setPaintTicks(true);
		xselector1.setPaintLabels(true);
		xselector1.setPaintTrack(false); 
		xselector1.setSnapToTicks(true); 
		xselector1.setInverted(true);
		//xselector1.setTickColor(whitex);



		framesPerPage2.addChangeListener(this);
		framesPerPage2.setPreferredSize(new Dimension(30, 400));

		//Turn on labels at major tick marks.
		framesPerPage2.setMajorTickSpacing(1);
		framesPerPage2.setMinorTickSpacing(1);
		framesPerPage2.setPaintTicks(true);
		framesPerPage2.setPaintLabels(false);
		framesPerPage2.setPaintTrack(false); 
		framesPerPage2.setSnapToTicks(true); 
		framesPerPage2.setInverted(true);
		//framesPerPage2.setTickColor(whitex);

		xselector2.addChangeListener(this);
		xselector2.setPreferredSize(new Dimension(60, 400));

		//Turn on labels at major tick marks.
		xselector2.setMajorTickSpacing(1);
		xselector2.setMinorTickSpacing(1);
		xselector2.setPaintTicks(true);
		xselector2.setPaintLabels(true);
		xselector2.setPaintTrack(false); 
		xselector2.setSnapToTicks(true); 
		xselector2.setInverted(true);
		//xselector2.setTickColor(whitex);



		framesPerPage3.addChangeListener(this);
		framesPerPage3.setPreferredSize(new Dimension(30, 400));

		//Turn on labels at major tick marks.
		framesPerPage3.setMajorTickSpacing(1);
		framesPerPage3.setMinorTickSpacing(1);
		framesPerPage3.setPaintTicks(true);
		framesPerPage3.setPaintLabels(false);
		framesPerPage3.setPaintTrack(false); 
		framesPerPage3.setSnapToTicks(true); 
		framesPerPage3.setInverted(true);
		//framesPerPage3.setTickColor(whitex);

		xselector3.addChangeListener(this);
		xselector3.setPreferredSize(new Dimension(60, 400));

		//Turn on labels at major tick marks.
		xselector3.setMajorTickSpacing(1);
		xselector3.setMinorTickSpacing(1);
		xselector3.setPaintTicks(true);
		xselector3.setPaintLabels(true);
		xselector3.setPaintTrack(false); 
		xselector3.setSnapToTicks(true); 
		xselector3.setInverted(true);
		//xselector3.setTickColor(whitex);



		framesPerPage4.addChangeListener(this);
		framesPerPage4.setPreferredSize(new Dimension(30, 400));

		//Turn on labels at major tick marks.
		framesPerPage4.setMajorTickSpacing(1);
		framesPerPage4.setMinorTickSpacing(1);
		framesPerPage4.setPaintTicks(true);
		framesPerPage4.setPaintLabels(false);
		framesPerPage4.setPaintTrack(false); 
		framesPerPage4.setSnapToTicks(true); 
		framesPerPage4.setInverted(true);
		//framesPerPage2.setTickColor(whitex);

		xselector4.addChangeListener(this);
		xselector4.setPreferredSize(new Dimension(60, 400));

		//Turn on labels at major tick marks.
		xselector4.setMajorTickSpacing(1);
		xselector4.setMinorTickSpacing(1);
		xselector4.setPaintTicks(true);
		xselector4.setPaintLabels(true);
		xselector4.setPaintTrack(false); 
		xselector4.setSnapToTicks(true); 
		xselector4.setInverted(true);
		//xselector4.setTickColor(whitex);



		framesPerPage5.addChangeListener(this);
		framesPerPage5.setPreferredSize(new Dimension(30, 400));

		//Turn on labels at major tick marks.
		framesPerPage5.setMajorTickSpacing(1);
		framesPerPage5.setMinorTickSpacing(1);
		framesPerPage5.setPaintTicks(true);
		framesPerPage5.setPaintLabels(false);
		framesPerPage5.setPaintTrack(false); 
		framesPerPage5.setSnapToTicks(true); 
		framesPerPage5.setInverted(true);
		//framesPerPage5.setTickColor(whitex);

		xselector5.addChangeListener(this);
		xselector5.setPreferredSize(new Dimension(60, 400));

		//Turn on labels at major tick marks.
		xselector5.setMajorTickSpacing(1);
		xselector5.setMinorTickSpacing(1);
		xselector5.setPaintTicks(true);
		xselector5.setPaintLabels(true);
		xselector5.setPaintTrack(false); 
		xselector5.setSnapToTicks(true); 
		xselector5.setInverted(true);
		//xselector5.setTickColor(whitex);



		framesPerPage6.addChangeListener(this);
		framesPerPage6.setPreferredSize(new Dimension(30, 400));

		//Turn on labels at major tick marks.
		framesPerPage6.setMajorTickSpacing(1);
		framesPerPage6.setMinorTickSpacing(1);
		framesPerPage6.setPaintTicks(true);
		framesPerPage6.setPaintLabels(false);
		framesPerPage6.setPaintTrack(false); 
		framesPerPage6.setSnapToTicks(true); 
		framesPerPage6.setInverted(true);
		//framesPerPage6.setTickColor(whitex);

		xselector6.addChangeListener(this);
		xselector6.setPreferredSize(new Dimension(60, 400));

		//Turn on labels at major tick marks.
		xselector6.setMajorTickSpacing(1);
		xselector6.setMinorTickSpacing(1);
		xselector6.setPaintTicks(true);
		xselector6.setPaintLabels(true);
		xselector6.setPaintTrack(false); 
		xselector6.setSnapToTicks(true); 
		xselector6.setInverted(true);
		//xselector6.setTickColor(whitex);


	//csvx*****************************************************************************************

	//top******************************************************************************************


		//JPanel jpk0 = new JPanel(0);
		jpk0.setPreferredSize(new Dimension(xzx, header_size));
		jpk0.setBackground(jgray);
		jpk0.add(infox1);
		jpk0.add(spacer_0);
		jpk0.add(search_tf);
		jpk0.add(cb_search_field);
		jpk0.add(search_b);
		jpk0.add(spacer_1);
		jpk0.add(spacer_4);
		jpk0.add(cb_active_site);


	//ctop*****************************************************************************************

	//export***************************************************************************************


		item_label0.setPreferredSize(new Dimension(400, 25));
		item_label0.setForeground(blackx);

		item_label0_1.setPreferredSize(new Dimension(180, 25));
		item_label0_1.setForeground(blackx);

		item_label0_2.setPreferredSize(new Dimension(195, 25));
		item_label0_2.setForeground(blackx);


		tf_weight.setForeground(blackx);
		tf_weight.setBackground(gray8);
		tf_weight.setToolTipText("Weight: oz, 16oz = 1LB");
		tf_weight.setHorizontalAlignment(JTextField.RIGHT);

		tf_onhand.setForeground(blackx);
		tf_onhand.setBackground(gray8);
		tf_onhand.setToolTipText("On Hand");
		tf_onhand.setHorizontalAlignment(JTextField.RIGHT);

		tf_picture_1.setForeground(blackx);
		tf_picture_1.setBackground(whitex);
		tf_picture_1.setToolTipText("Picture 1");

		tf_cost.setForeground(whitex);
		tf_cost.setBackground(redx);
		tf_cost.setToolTipText("Cost");
		tf_cost.setHorizontalAlignment(JTextField.RIGHT);

		tf_price.setForeground(blackx);
		tf_price.setBackground(lightgreenx);
		tf_price.setToolTipText("Sale Price");
		tf_price.setHorizontalAlignment(JTextField.RIGHT);

		tf_title.setCaretColor(whitex);
		tf_title.setForeground(whitex);
		tf_title.setBackground(bluex2);
		tf_title.setToolTipText("Title");

		tf_part.setCaretColor(whitex);
		tf_part.setForeground(whitex);
		tf_part.setBackground(bluex2);
		tf_part.setToolTipText("Part Number");

		tf_d.setForeground(whitex);
		tf_d.setBackground(darkgray70);
		tf_d.setToolTipText("Demention Depth. Inches");
		tf_d.setHorizontalAlignment(JTextField.RIGHT);

		tf_l.setForeground(whitex);
		tf_l.setBackground(darkgray70);
		tf_l.setToolTipText("Demention Length. Inches");
		tf_l.setHorizontalAlignment(JTextField.RIGHT);

		tf_w.setForeground(whitex);
		tf_w.setBackground(darkgray70);
		tf_w.setToolTipText("Demention Width. Inches");
		tf_w.setHorizontalAlignment(JTextField.RIGHT);

		tf_custom_1.setForeground(blackx);
		tf_custom_1.setBackground(bluex3);
		tf_custom_1.setToolTipText("Custom 1");

		tf_custom_2.setForeground(blackx);
		tf_custom_2.setBackground(bluex3);
		tf_custom_2.setToolTipText("Custom 2");
		//tf_custom_2.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black));

		tf_custom_3.setForeground(blackx);
		tf_custom_3.setBackground(bluex3);
		tf_custom_3.setToolTipText("Custom 3");


		//JPanel jpk0x = new JPanel();
		jpk0x.setPreferredSize(new Dimension(810, base_size -10));
		jpk0x.setBackground(st_gray1);//blackx
		jpk0x.setLayout(flow2);//blackx
		jpk0x.add(item_label0);
		jpk0x.add(item_label0_1);
		jpk0x.add(item_label0_2);
		jpk0x.add(tf_title);
		jpk0x.add(tf_part);
		jpk0x.add(tf_cost);
		jpk0x.add(tf_price);
		jpk0x.add(tf_onhand);
		jpk0x.add(tf_weight);
		jpk0x.add(tf_d);
		jpk0x.add(tf_l);
		jpk0x.add(tf_w);
		jpk0x.add(tf_picture_1);
		jpk0x.add(tf_custom_1);
		jpk0x.add(tf_custom_2);
		jpk0x.add(tf_custom_3);


	//export***************************************************************************************

	//monitor**************************************************************************************


		view_hm0.setPreferredSize(new Dimension(200, 15));
		view_hm0.setBackground(blackx);
		view_hm0.setForeground(blackx);

		view_hm2.setPreferredSize(new Dimension(200, 15)); 
		view_hm2.setBackground(blackx);
		view_hm2.setForeground(blackx);

		view_hm3.setPreferredSize(new Dimension(200, 15)); 
		view_hm3.setBackground(blackx);
		view_hm3.setForeground(blackx);


		view_0m1.setPreferredSize(new Dimension(130, 15));
		view_0m1.setBackground(blackx);
		view_0m1.setForeground(blackx);
		view_0m1.setFont(f_01);

		view_0m2.setPreferredSize(new Dimension(130, 15));
		view_0m2.setBackground(blackx);
		view_0m2.setForeground(blackx);
		view_0m2.setFont(f_01);

		view_0m3.setPreferredSize(new Dimension(130, 15));
		view_0m3.setBackground(blackx);
		view_0m3.setForeground(blackx);
		view_0m3.setFont(f_01);

		view_0m4.setPreferredSize(new Dimension(130, 15));
		view_0m4.setBackground(blackx);
		view_0m4.setForeground(blackx);
		view_0m4.setFont(f_01);

		view_0m5.setPreferredSize(new Dimension(130, 15));
		view_0m5.setBackground(blackx);
		view_0m5.setForeground(blackx);
		view_0m5.setFont(f_01);


		view_2m1.setPreferredSize(new Dimension(100, 15));
		view_2m1.setBackground(blackx);
		view_2m1.setForeground(blackx);
		view_2m1.setFont(f_01);

		view_2m2.setPreferredSize(new Dimension(100, 15));
		view_2m2.setBackground(blackx);
		view_2m2.setForeground(blackx);
		view_2m2.setFont(f_01);

		view_2m3.setPreferredSize(new Dimension(100, 15));
		view_2m3.setBackground(blackx);
		view_2m3.setForeground(blackx);
		view_2m3.setFont(f_01);

		view_2m4.setPreferredSize(new Dimension(100, 15));
		view_2m4.setBackground(blackx);
		view_2m4.setForeground(blackx);
		view_2m4.setFont(f_01);

		view_2m5.setPreferredSize(new Dimension(100, 15));
		view_2m5.setBackground(blackx);
		view_2m5.setForeground(blackx);
		view_2m5.setFont(f_01);


		view_3m1.setPreferredSize(new Dimension(100, 15));
		view_3m1.setBackground(blackx);
		view_3m1.setForeground(blackx);
		view_3m1.setFont(f_01);

		view_3m2.setPreferredSize(new Dimension(100, 15));
		view_3m2.setBackground(blackx);
		view_3m2.setForeground(blackx);
		view_3m2.setFont(f_01);

		view_3m3.setPreferredSize(new Dimension(100, 15));
		view_3m3.setBackground(blackx);
		view_3m3.setForeground(blackx);
		view_3m3.setFont(f_01);

		view_3m4.setPreferredSize(new Dimension(100, 15));
		view_3m4.setBackground(blackx);
		view_3m4.setForeground(blackx);
		view_3m4.setFont(f_01);

		view_3m5.setPreferredSize(new Dimension(100, 15));
		view_3m5.setBackground(blackx);
		view_3m5.setForeground(blackx);
		view_3m5.setFont(f_01);


		viewx_0m1.setPreferredSize(new Dimension(70, 15));
		viewx_0m1.setBackground(blackx);
		viewx_0m1.setForeground(blackx);
		viewx_0m1.setFont(f_01);

		viewx_0m2.setPreferredSize(new Dimension(70, 15));
		viewx_0m2.setBackground(blackx);
		viewx_0m2.setForeground(blackx);
		viewx_0m2.setFont(f_01);

		viewx_0m3.setPreferredSize(new Dimension(70, 15));
		viewx_0m3.setBackground(blackx);
		viewx_0m3.setForeground(blackx);
		viewx_0m3.setFont(f_01);

		viewx_0m4.setPreferredSize(new Dimension(70, 15));
		viewx_0m4.setBackground(blackx);
		viewx_0m4.setForeground(blackx);
		viewx_0m4.setFont(f_01);

		viewx_0m5.setPreferredSize(new Dimension(70, 15));
		viewx_0m5.setBackground(blackx);
		viewx_0m5.setForeground(blackx);
		viewx_0m5.setFont(f_01);


		viewx_2m1.setPreferredSize(new Dimension(100, 15));
		viewx_2m1.setBackground(blackx);
		viewx_2m1.setForeground(blackx);
		viewx_2m1.setFont(f_01);

		viewx_2m2.setPreferredSize(new Dimension(100, 15));
		viewx_2m2.setBackground(blackx);
		viewx_2m2.setForeground(blackx);
		viewx_2m2.setFont(f_01);

		viewx_2m3.setPreferredSize(new Dimension(100, 15));
		viewx_2m3.setBackground(blackx);
		viewx_2m3.setForeground(blackx);
		viewx_2m3.setFont(f_01);

		viewx_2m4.setPreferredSize(new Dimension(100, 15));
		viewx_2m4.setBackground(blackx);
		viewx_2m4.setForeground(blackx);
		viewx_2m4.setFont(f_01);

		viewx_2m5.setPreferredSize(new Dimension(100, 15));
		viewx_2m5.setBackground(blackx);
		viewx_2m5.setForeground(blackx);
		viewx_2m5.setFont(f_01);


		viewx_3m1.setPreferredSize(new Dimension(100, 15));
		viewx_3m1.setBackground(blackx);
		viewx_3m1.setForeground(blackx);
		viewx_3m1.setFont(f_01);

		viewx_3m2.setPreferredSize(new Dimension(100, 15));
		viewx_3m2.setBackground(blackx);
		viewx_3m2.setForeground(blackx);
		viewx_3m2.setFont(f_01);

		viewx_3m3.setPreferredSize(new Dimension(100, 15));
		viewx_3m3.setBackground(blackx);
		viewx_3m3.setForeground(blackx);
		viewx_3m3.setFont(f_01);

		viewx_3m4.setPreferredSize(new Dimension(100, 15));
		viewx_3m4.setBackground(blackx);
		viewx_3m4.setForeground(blackx);
		viewx_3m4.setFont(f_01);

		viewx_3m5.setPreferredSize(new Dimension(100, 15));
		viewx_3m5.setBackground(blackx);
		viewx_3m5.setForeground(blackx);
		viewx_3m5.setFont(f_01);


		refresh_db.setMargin(new Insets(0, 0, 0, 0));
		refresh_db.addActionListener(this);
		refresh_db.setPreferredSize(new Dimension(100, 20));
		refresh_db.setBackground(jgray);
		refresh_db.setHorizontalTextPosition(JButton.CENTER);
		refresh_db.setForeground(blackx);
		refresh_db.setToolTipText("Refresh info from the connected site");

		refresh_all_db.setMargin(new Insets(0, 0, 0, 0));
		refresh_all_db.addActionListener(this);
		refresh_all_db.setPreferredSize(new Dimension(100, 20));
		refresh_all_db.setBackground(jgray);
		refresh_all_db.setHorizontalTextPosition(JButton.CENTER);
		refresh_all_db.setForeground(blackx);
		refresh_all_db.setToolTipText("Refresh DB2 and DB3");
		refresh_all_db.setEnabled(true);

		empty_db.setMargin(new Insets(0, 0, 0, 0));
		empty_db.addActionListener(this);
		empty_db.setPreferredSize(new Dimension(100, 20));
		empty_db.setBackground(jgray);
		empty_db.setHorizontalTextPosition(JButton.CENTER);
		empty_db.setForeground(blackx);
		empty_db.setToolTipText("Dump the connected sites database");
		empty_db.setEnabled(false);


		//JPanel mpanel0 = new JPanel();
		mpanel0.setPreferredSize(new Dimension(210, 121));
		mpanel0.setBackground(jgray);
		mpanel0.add(view_hm0);
		mpanel0.add(viewx_0m1);	mpanel0.add(view_0m1);
		mpanel0.add(viewx_0m2);	mpanel0.add(view_0m2);
		mpanel0.add(viewx_0m3);	mpanel0.add(view_0m3);
		mpanel0.add(viewx_0m4);	mpanel0.add(view_0m4);
		mpanel0.add(viewx_0m5);	mpanel0.add(view_0m5);

		//JPanel mpanel1 = new JPanel();
		mpanel1.setPreferredSize(new Dimension(210, 121));
		mpanel1.setBackground(jgray);
		mpanel1.add(view_hm2);
		mpanel1.add(viewx_2m1);	mpanel1.add(view_2m1);
		mpanel1.add(viewx_2m2);	mpanel1.add(view_2m2);
		mpanel1.add(viewx_2m3);	mpanel1.add(view_2m3);
		mpanel1.add(viewx_2m4);	mpanel1.add(view_2m4);
		mpanel1.add(viewx_2m5);	mpanel1.add(view_2m5);

		//JPanel mpanel2 = new JPanel();
		mpanel2.setPreferredSize(new Dimension(210, 121));
		mpanel2.setBackground(jgray);
		mpanel2.add(view_hm3);
		mpanel2.add(viewx_3m1);	mpanel2.add(view_3m1);
		mpanel2.add(viewx_3m2);	mpanel2.add(view_3m2);
		mpanel2.add(viewx_3m3);	mpanel2.add(view_3m3);
		mpanel2.add(viewx_3m4);	mpanel2.add(view_3m4);
		mpanel2.add(viewx_3m5);	mpanel2.add(view_3m5);

		//JPanel mpanel3 = new JPanel();
		mpanel3.setPreferredSize(new Dimension(150, 121));
		//mpanel3.setLayout(null);
		mpanel3.setBackground(st_gray1);
		mpanel3.add(refresh_db);
		mpanel3.add(refresh_all_db);
		mpanel3.add(empty_db);

		jpk1x.setPreferredSize(new Dimension(810, base_size -10));
		jpk1x.setBackground(st_gray1);
		//jpk1x.add(item_label1);
		jpk1x.add(mpanel0);
		jpk1x.add(mpanel1);
		jpk1x.add(mpanel2);
		jpk1x.add(mpanel3);


	//monitor**************************************************************************************

	//sold*****************************************************************************************


		sold_tracking.setToolTipText("Tracking Number");

		sold_tf_username.setToolTipText("Buyer Username");
		sold_tf_email.setToolTipText("Buyer Email");
		sold_tf_saleid.setToolTipText("Sale ID");

		//String[] shipping_status = new String[8];
		shipping_status[0] = new String("Listed");
		shipping_status[1] = new String("Sold");
		shipping_status[2] = new String("Ready to ship");
		shipping_status[3] = new String("Shipped");
		shipping_status[4] = new String("Successful");
		shipping_status[5] = new String("Unsold");
		shipping_status[6] = new String("Exported");
		shipping_status[7] = new String("Error");

		sale_status_cb = new JComboBox<String>(shipping_status);
		sale_status_cb.setSelectedIndex(0);
		sale_status_cb.addActionListener(this);
		sale_status_cb.setPreferredSize(new Dimension(100, 20));
		sale_status_cb.setEnabled(true);

		//item_label2.setText("hi");
		item_label2.setPreferredSize(new Dimension(400, 25));
		item_label2.setBorder(new EmptyBorder(0,6,0,0));
		//item_label2.setOpaque(true);
		item_label2.setBackground(jgray);
		item_label2.setForeground(blackx);

		sold_address = new JTextArea("", 200, 85);
		sold_address.setToolTipText("Buyer's Address. You cannot edit this field.");

		sold_received.setMargin(new Insets(0, 0, 0, 0));
	  	sold_received.addActionListener(this);
		sold_received.setPreferredSize(new Dimension(50, 18));
		sold_received.setHorizontalTextPosition(JButton.CENTER);
		sold_received.setForeground(gray8);
		sold_received.setToolTipText("Sale Status");

		sold_shipped.setMargin(new Insets(0, 0, 0, 0));
	  	sold_shipped.addActionListener(this);
		sold_shipped.setPreferredSize(new Dimension(50, 18));
		sold_shipped.setHorizontalTextPosition(JButton.CENTER);
		sold_shipped.setForeground(gray8);

		sold_done.setMargin(new Insets(0, 0, 0, 0));
	  	sold_done.addActionListener(this);
		sold_done.setPreferredSize(new Dimension(50, 18));
		sold_done.setHorizontalTextPosition(JButton.CENTER);
		sold_done.setForeground(gray8);

		sold_blank.setMargin(new Insets(0, 0, 0, 0));
	  	sold_blank.addActionListener(this);
		sold_blank.setPreferredSize(new Dimension(50, 18));
		sold_blank.setHorizontalTextPosition(JButton.CENTER);
		sold_blank.setForeground(gray8);
		sold_blank.setToolTipText("Sale Status");

		sold_track.setMargin(new Insets(0, 0, 0, 0));
	  	sold_track.addActionListener(this);
		sold_track.setPreferredSize(new Dimension(50, 20));
	 	sold_track.setBackground(jgray);
		sold_track.setHorizontalTextPosition(JButton.CENTER);
		sold_track.setForeground(blackx);
		sold_track.setToolTipText("View tracking information");

		sale_status_b.setPreferredSize(new Dimension(115, 20));
		sale_status_b.addActionListener(this);
		sale_status_b.setBackground(jgray);
		sale_status_b.setForeground(blackx);
		sale_status_b.setToolTipText("Sale Status");

		sold_received_l.setPreferredSize(new Dimension(100, 18));
		sold_received_l.setForeground(blackx);

		sold_shipped_l.setPreferredSize(new Dimension(100, 18));
		sold_shipped_l.setForeground(blackx);

		sold_done_l.setPreferredSize(new Dimension(100, 18));
		sold_done_l.setForeground(blackx);

		sold_blank_l.setPreferredSize(new Dimension(100, 18));
		sold_blank_l.setForeground(blackx);

		sold_header1.setPreferredSize(new Dimension(150, 10));
		sold_header1.setForeground(blackx);

		sold_sp.setPreferredSize(new Dimension(140, 20));
		sold_sp.setForeground(blackx);

		sold_cp.setPreferredSize(new Dimension(140, 20));
		sold_cp.setForeground(blackx);

		sold_si.setPreferredSize(new Dimension(140, 20));
		sold_si.setForeground(blackx);

		sold_so.setPreferredSize(new Dimension(140, 20));
		sold_so.setForeground(blackx);

		sold_tax.setPreferredSize(new Dimension(140, 20));
		sold_tax.setForeground(blackx);	

		sold_fee.setPreferredSize(new Dimension(140, 20));
		sold_fee.setForeground(blackx);

		sold_tf_sp.setHorizontalAlignment(JTextField.RIGHT);
		sold_tf_cp.setHorizontalAlignment(JTextField.RIGHT);
		sold_tf_si.setHorizontalAlignment(JTextField.RIGHT);
		sold_tf_so.setHorizontalAlignment(JTextField.RIGHT);
		sold_tf_tax.setHorizontalAlignment(JTextField.RIGHT);
		sold_tf_fee.setHorizontalAlignment(JTextField.RIGHT);

		sold_costs.setPreferredSize(new Dimension(193, 20));
		sold_costs.setForeground(blackx);// redx

		sold_profit.setPreferredSize(new Dimension(193, 20));
		sold_profit.setForeground(blackx);// lightgreenx

		sold_1.setPreferredSize(new Dimension(400, 90));
		sold_1.setBackground(st_gray1);//gray7
		sold_1.setLayout(flow4);
		sold_1.add(sold_cp);    sold_1.add(sold_tf_cp); 	sold_1.add(sold_sp);  sold_1.add(sold_tf_sp);
		sold_1.add(sold_si);    sold_1.add(sold_tf_si); 	sold_1.add(sold_so);  sold_1.add(sold_tf_so);
		sold_1.add(sold_tax);   sold_1.add(sold_tf_tax); 	sold_1.add(sold_fee); sold_1.add(sold_tf_fee);
		sold_1.add(sold_costs); sold_1.add(sold_profit);

		sold_2.setPreferredSize(new Dimension(200, 90));
		sold_2.setBackground(blackx);
		sold_2.add(sold_address);

		sold_3.setPreferredSize(new Dimension(170, 90));
		sold_3.setBackground(st_gray1);//darkgray08
		sold_3.setLayout(flow4);
		sold_3.add(sold_received_l);
		sold_3.add(sold_tf_username);
		sold_3.add(sold_tf_email);
		sold_3.add(sold_tf_saleid);

		jpk2x.setPreferredSize(new Dimension(810, base_size -10));
		jpk2x.setBackground(st_gray1);//blackx
		jpk2x.add(item_label2);
		jpk2x.add(sold_tracking);
		jpk2x.add(sold_track);
		jpk2x.add(sale_status_b);
		jpk2x.add(sold_1);
		jpk2x.add(sold_2);
		jpk2x.add(sold_3);


	//sold*****************************************************************************************

	//archived*************************************************************************************


		archive_address = new JTextArea("", 1, 5);
		archive_address.setPreferredSize(new Dimension(191, 80));

		archive_spacerx.setPreferredSize(new Dimension(115, 14));

		archive_track.setMargin(new Insets(0, 0, 0, 0));
	  	archive_track.addActionListener(this);
		archive_track.setPreferredSize(new Dimension(115, 20));
		archive_track.setHorizontalTextPosition(JButton.CENTER);
		archive_track.setForeground(blackx);
		archive_track.setBackground(jgray);

		archive_c1.setMargin(new Insets(0, 0, 0, 0));
		archive_c1.setPreferredSize(new Dimension(115, 20));
		archive_c1.setEnabled(false);
		archive_c1.setHorizontalTextPosition(JButton.CENTER);
		archive_c1.setForeground(blackx);
		archive_c1.setBackground(jgray);

		archive_c2.setMargin(new Insets(0, 0, 0, 0));
		archive_c2.setPreferredSize(new Dimension(115, 20));
		archive_c2.setEnabled(false);
		archive_c2.setHorizontalTextPosition(JButton.CENTER);
		archive_c2.setForeground(blackx);
		archive_c2.setBackground(jgray);

		archive_c3.setMargin(new Insets(0, 0, 0, 0));
	  	archive_c3.addActionListener(this);
		archive_c3.setPreferredSize(new Dimension(115, 20));
		archive_c3.setEnabled(true);
		archive_c3.setHorizontalTextPosition(JButton.CENTER);
		archive_c3.setForeground(blackx);
		archive_c3.setBackground(jgray);

		sale_status_b_archive.setPreferredSize(new Dimension(115, 20));
		sale_status_b_archive.addActionListener(this);
		sale_status_b_archive.setBackground(jgray);
		sale_status_b_archive.setForeground(blackx);

		archivex.setMargin(new Insets(0, 0, 0, 0));
	  	archivex.addActionListener(this);
		archivex.setPreferredSize(new Dimension(100, 25));
		archivex.setBackground(jgray);
		archivex.setHorizontalTextPosition(JButton.CENTER);
		archivex.setForeground(blackx);
	 	archivex.setToolTipText("Archive the selected item(s)");

		al_total_sales.setPreferredSize(new Dimension(90, 20));
		al_total_costs.setPreferredSize(new Dimension(90, 20));
		al_total_taxes.setPreferredSize(new Dimension(90, 20));
		al_total_shipping.setPreferredSize(new Dimension(90, 20));
		al_total_profit.setPreferredSize(new Dimension(90, 40));

		al_total_sales_n.setPreferredSize(new Dimension(110, 20));
		al_total_costs_n.setPreferredSize(new Dimension(110, 20));
		al_total_taxes_n.setPreferredSize(new Dimension(110, 20));
		al_total_shipping_n.setPreferredSize(new Dimension(110, 20));
		al_total_profit_n.setPreferredSize(new Dimension(110, 40));

		al_total_sold.setPreferredSize(new Dimension(100, 20));
		al_total_refunded.setPreferredSize(new Dimension(100, 20));
		al_total_errors.setPreferredSize(new Dimension(100, 20));

		al_total_sold_n.setPreferredSize(new Dimension(70, 20));
		al_total_refunded_n.setPreferredSize(new Dimension(70, 20));
		al_total_errors_n.setPreferredSize(new Dimension(70, 20));

		al_total_sales.setForeground(blackx);
		al_total_costs.setForeground(blackx);
		al_total_taxes.setForeground(blackx);
		al_total_shipping.setForeground(blackx);
		al_total_profit.setForeground(blackx);

		al_total_sales_n.setForeground(blackx);
		al_total_costs_n.setForeground(blackx);
		al_total_taxes_n.setForeground(blackx);
		al_total_shipping_n.setForeground(blackx);
		al_total_profit_n.setForeground(blackx);


		JPanel archive_1 = new JPanel();
		archive_1.setPreferredSize(new Dimension(220, 120));
		archive_1.setBackground(st_gray1);
		archive_1.setLayout(flow4);
		archive_1.add(al_total_sales);      archive_1.add(al_total_sales_n);
		archive_1.add(al_total_costs); 	    archive_1.add(al_total_costs_n);
		archive_1.add(al_total_taxes);	    archive_1.add(al_total_taxes_n);
		archive_1.add(al_total_shipping); 	archive_1.add(al_total_shipping_n);
		archive_1.add(al_total_profit);    	archive_1.add(al_total_profit_n);

		JPanel archive_2 = new JPanel();
		archive_2.setPreferredSize(new Dimension(150, 120));
		archive_2.setBackground(st_gray1);
		archive_2.setLayout(flow5);
		archive_2.add(sale_status_b_archive);
		archive_2.add(archive_spacerx);
		archive_2.add(archive_track);
		archive_2.add(archive_c1);
		archive_2.add(archive_c2);
		archive_2.add(archive_c3);

		JPanel archive_3 = new JPanel();
		archive_3.setPreferredSize(new Dimension(200, 120));
		archive_3.setBackground(st_gray1);
		archive_3.setLayout(flow4);
		archive_3.add(al_total_sold);        	archive_3.add(al_total_sold_n);
		archive_3.add(al_total_refunded);       archive_3.add(al_total_refunded_n);
		archive_3.add(al_total_errors);        	archive_3.add(al_total_errors_n);

		JPanel archive_4 = new JPanel();
		archive_4.setPreferredSize(new Dimension(200, 120));
		archive_4.setBackground(st_gray1);
		archive_4.setLayout(flow1);
		archive_4.add(archive_address);
		archive_4.add(archive_tf_email);
		archive_4.add(archive_tf_saleid);


		jpk3x.setPreferredSize(new Dimension(810, base_size -10));
		jpk3x.setBackground(st_gray1);
		jpk3x.add(archive_1);
		jpk3x.add(archive_3);
		jpk3x.add(archive_4);
		jpk3x.add(archive_2);


	//archived*************************************************************************************

	//settings*************************************************************************************


		//String[] set_on_off = new String[2];
		set_on_off[0] = new String("0");
		set_on_off[1] = new String("1");

		set_status_on = new JComboBox<String>(set_on_off);
		set_status_on.setSelectedIndex(0);
		set_status_on.addActionListener(this);
		set_status_on.setPreferredSize(new Dimension(100, 20));
		set_status_on.setEnabled(false);


		//String[] color_choice = new String[4];
		color_choice[0] = new String("Black");
		color_choice[1] = new String("Red");
		color_choice[2] = new String("Green");
		color_choice[3] = new String("Blue");

		set_status_color = new JComboBox<String>(color_choice);
		set_status_color.setSelectedIndex(0);
		set_status_color.addActionListener(this);
		set_status_color.setPreferredSize(new Dimension(100, 20));
		set_status_color.setEnabled(false);


		set_info0.setPreferredSize(new Dimension(700, 25));
		set_info0.setForeground(blackx);

		set_info1.setPreferredSize(new Dimension(100, 25));
		set_info1.setForeground(blackx);

		set_info2.setPreferredSize(new Dimension(50, 25));
		set_info2.setForeground(blackx);

		set_info3.setPreferredSize(new Dimension(50, 25));
		set_info3.setForeground(blackx);

		set_info4.setPreferredSize(new Dimension(50, 25));
		set_info4.setForeground(blackx);

		set_save.setMargin(new Insets(0, 0, 0, 0));
	  	set_save.addActionListener(this);
		set_save.setPreferredSize(new Dimension(60, 20));
		set_save.setHorizontalTextPosition(JButton.CENTER);
		set_save.setForeground(blackx);
		set_save.setBackground(st_gray1);

		set_rebuild_display.setMargin(new Insets(0, 0, 0, 0));
	  	set_rebuild_display.addActionListener(this);
		set_rebuild_display.setPreferredSize(new Dimension(100, 20));
		set_rebuild_display.setHorizontalTextPosition(JButton.CENTER);
		set_rebuild_display.setForeground(blackx);
		set_rebuild_display.setBackground(st_gray1);


		JPanel display_save_panel = new JPanel();
		display_save_panel.setPreferredSize(new Dimension(750, 35));
		display_save_panel.setBackground(jgray);
		display_save_panel.add(set_info1);
		display_save_panel.add(set_status_on);
		display_save_panel.add(set_info2);
		display_save_panel.add(set_tf_position);
		display_save_panel.add(set_info3);
		display_save_panel.add(set_tf_size);
		display_save_panel.add(set_info4);
		display_save_panel.add(set_status_color);
		display_save_panel.add(set_save);

		item_label4.setPreferredSize(new Dimension(700, 20));

		jpk6x.setPreferredSize(new Dimension(810, base_size -10));
		jpk6x.setBackground(st_gray1);
		jpk6x.add(item_label4);
		jpk6x.add(set_info0);
		jpk6x.add(display_save_panel);
		jpk6x.add(set_rebuild_display);

		jpk4x.setPreferredSize(new Dimension(810, base_size -10));
		jpk4x.setBackground(st_gray1);
		jpk4x.add(set_info_text); 


	//settings*************************************************************************************

	//Sites****************************************************************************************


		get_ebay_token.setMargin(new Insets(0, 0, 0, 0));
	  	get_ebay_token.addActionListener(this);
		get_ebay_token.setPreferredSize(new Dimension(100, 20));
	 	get_ebay_token.setBackground(jgray);
		get_ebay_token.setHorizontalTextPosition(JButton.CENTER);
		get_ebay_token.setForeground(blackx);

		get_settings_x.setMargin(new Insets(0, 0, 0, 0));
	  	get_settings_x.addActionListener(this);
		get_settings_x.setPreferredSize(new Dimension(100, 20));
	 	get_settings_x.setBackground(jgray);
		get_settings_x.setHorizontalTextPosition(JButton.CENTER);
		get_settings_x.setForeground(blackx);

		ws_test.setMargin(new Insets(0, 0, 0, 0));
	  	ws_test.addActionListener(this);
	 	ws_test.setPreferredSize(new Dimension(100, 20));
	 	ws_test.setBackground(jgray);
		ws_test.setHorizontalTextPosition(JButton.CENTER);
	 	ws_test.setForeground(blackx);

		ws_save.setMargin(new Insets(0, 0, 0, 0));
	  	ws_save.addActionListener(this);
	 	ws_save.setPreferredSize(new Dimension(100, 20));
	 	ws_save.setBackground(jgray);
		ws_save.setHorizontalTextPosition(JButton.CENTER);
	 	ws_save.setForeground(blackx);


		item_label5x_0.setPreferredSize(new Dimension(197, 25));
		item_label5x_1.setPreferredSize(new Dimension(92, 25));
		item_label5x_2.setPreferredSize(new Dimension(92, 25));
		item_label5x_3.setPreferredSize(new Dimension(92, 25));
		item_label5x_4.setPreferredSize(new Dimension(95, 25));
		item_label5x_5.setPreferredSize(new Dimension(95, 25));

		item_label5x_0.setHorizontalAlignment(SwingConstants.CENTER); 

		item_label5_0.setPreferredSize(new Dimension(120, 25));
		item_label5_1.setPreferredSize(new Dimension(120, 25));
		item_label5_2.setPreferredSize(new Dimension(120, 25));
		item_label5_3.setPreferredSize(new Dimension(120, 25));
		item_label5_4.setPreferredSize(new Dimension(113, 25));
		item_label5_5.setPreferredSize(new Dimension(113, 25));

		item_label5_0.setForeground(blackx);
		item_label5_1.setForeground(blackx);
		item_label5_2.setForeground(blackx);
		item_label5_3.setForeground(blackx);
		item_label5_4.setForeground(blackx);
		item_label5_5.setForeground(blackx);

		tf_namex.setBackground(lightgreenx);
		tf_urlx.setBackground(bluex3);

		item_label5x_2.setForeground(blackx);
		item_label5x_3.setForeground(blackx);

		item_label1.setPreferredSize(new Dimension(800, 25));
		item_label3.setPreferredSize(new Dimension(800, 25));
		//item_label10.setPreferredSize(new Dimension(120, 25));

		item_label1.setForeground(gray8);
		item_label3.setForeground(gray8);

		fii0.setForeground(blackx);
		fii1.setForeground(blackx);
		fii2.setForeground(blackx);

		fii0.setFont(f_01);
		fii1.setFont(f_01);
		fii2.setFont(f_01);

		jpk5x.setPreferredSize(new Dimension(810, base_size -10));
		jpk5x.setBackground(st_gray1);
		jpk5x.add(item_label5_0);  jpk5x.add(tf_namex);                              jpk5x.add(item_label5x_0);  jpk5x.add(ws_test);
		jpk5x.add(item_label5_1);  jpk5x.add(tf_urlx);   jpk5x.add(get_ebay_token);  jpk5x.add(item_label5x_1);  jpk5x.add(ws_save);
		jpk5x.add(item_label5_2);  jpk5x.add(tf_userx);  jpk5x.add(item_label5_4);   jpk5x.add(tf_key1x);        jpk5x.add(item_label5x_2);  jpk5x.add(cb_active);
		jpk5x.add(item_label5_3);  jpk5x.add(tf_passx);  jpk5x.add(item_label5_5);   jpk5x.add(tf_key2x);        jpk5x.add(item_label5x_3);  jpk5x.add(cb_sitese);


	//Sites****************************************************************************************

	//body2****************************************************************************************


		submit.setMargin(new Insets(0, 0, 0, 0));
	  	submit.addActionListener(this);
		submit.setPreferredSize(new Dimension(100, 25));
	 	//submit.setIcon(imx4);
		submit.setBackground(jgray);//st_gray1
		submit.setHorizontalTextPosition(JButton.CENTER);
	 	submit.setForeground(blackx);
	 	submit.setToolTipText("Submit item(s) to the selected database");

		refresh.setMargin(new Insets(0, 0, 0, 0));
	  	refresh.addActionListener(this);
		refresh.setPreferredSize(new Dimension(100, 25));
	 	//refresh.setIcon(imx4);
		refresh.setBackground(jgray);
		refresh.setHorizontalTextPosition(JButton.CENTER);
		refresh.setForeground(blackx);
	 	refresh.setToolTipText("Refresh this database");

		importx.setMargin(new Insets(0, 0, 0, 0));
	  	importx.addActionListener(this);
		importx.setPreferredSize(new Dimension(100, 25));
	 	//importx.setIcon(imx4);
		importx.setBackground(jgray);
		importx.setHorizontalTextPosition(JButton.CENTER);
		importx.setForeground(blackx);
	 	importx.setToolTipText("Import from selected database");

		print_shipping.setMargin(new Insets(0, 0, 0, 0));
	  	print_shipping.addActionListener(this);
		print_shipping.setPreferredSize(new Dimension(100, 25));
	 	//print_shipping.setIcon(imx4);
		print_shipping.setBackground(jgray);
		print_shipping.setHorizontalTextPosition(JButton.CENTER);
		print_shipping.setForeground(blackx);
	 	print_shipping.setToolTipText("Create a shipping label");

		empty_site.setMargin(new Insets(0, 0, 0, 0));
	  	empty_site.addActionListener(this);
		empty_site.setPreferredSize(new Dimension(100, 25));
	 	//empty_site.setIcon(imx4);
		empty_site.setBackground(jgray);
		empty_site.setHorizontalTextPosition(JButton.CENTER);
		empty_site.setForeground(blackx);
	 	empty_site.setToolTipText("Delete this item from the selected website");

		settings_edit.setMargin(new Insets(0, 0, 0, 0));
	  	settings_edit.addActionListener(this);
		settings_edit.setPreferredSize(new Dimension(100, 25));
	 	//settings_edit.setIcon(imx4);
		settings_edit.setBackground(jgray);
		settings_edit.setHorizontalTextPosition(JButton.CENTER);
		settings_edit.setForeground(blackx);
	 	settings_edit.setToolTipText("Edit settings");

		delete.setMargin(new Insets(0, 0, 0, 0));
	  	delete.addActionListener(this);
		delete.setPreferredSize(new Dimension(100, 25));
	 	//delete.setIcon(imx4);
		delete.setBackground(jgray);
		delete.setHorizontalTextPosition(JButton.CENTER);
		delete.setForeground(blackx);
	 	delete.setToolTipText("Delete item(s)");

		new_item.setMargin(new Insets(0, 0, 0, 0));
	  	new_item.addActionListener(this);
		new_item.setPreferredSize(new Dimension(100, 25));
	 	//new_item.setIcon(imx4);
		new_item.setBackground(jgray);
		new_item.setHorizontalTextPosition(JButton.CENTER);
		new_item.setForeground(blackx);
	 	new_item.setToolTipText("Create a new item");

		edit_item.setMargin(new Insets(0, 0, 0, 0));
	  	edit_item.addActionListener(this);
		edit_item.setPreferredSize(new Dimension(100, 25));
	 	//edit_item.setIcon(imx4);
		edit_item.setBackground(jgray);
		edit_item.setHorizontalTextPosition(JButton.CENTER);
		edit_item.setForeground(blackx);
	 	edit_item.setToolTipText("Edit selected item");

		view_item.setMargin(new Insets(0, 0, 0, 0));
	  	view_item.addActionListener(this);
		view_item.setPreferredSize(new Dimension(100, 25));
	 	//view_item.setIcon(imx4);
		view_item.setBackground(jgray);
		view_item.setHorizontalTextPosition(JButton.CENTER);
		view_item.setForeground(blackx);
	 	view_item.setToolTipText("Preview selected item");


	//sides****************************************************************************************


		JPanel jpk1s2 = new JPanel();
		jpk1s2.setPreferredSize(new Dimension(110, base_size));
		jpk1s2.setBackground(jgray);//darkgray08
		jpk1s2.setLayout(flow4);
		jpk1s2.add(new_item);
		jpk1s2.add(edit_item);
		jpk1s2.add(delete);
		jpk1s2.add(view_item);
		jpk1s2.add(archivex);

		jpk1_solid.setPreferredSize(new Dimension(150, base_size));
		jpk1_solid.setBackground(st_gray1);//blackx
		jpk1_solid.setLayout(flow6);
		jpk1_solid.add(jpk1s2);

		//JPanel jpk2_solid = new JPanel();
		jpk2_solid.setPreferredSize(new Dimension(810, base_size -10));
		jpk2_solid.setBackground(st_gray1);//darkgray08
		jpk2_solid.setLayout(flow1);
		jpk2_solid.add(jpk0x);
		jpk2_solid.add(jpk1x);
		jpk2_solid.add(jpk2x);
		jpk2_solid.add(jpk3x);
		jpk2_solid.add(jpk4x);
		jpk2_solid.add(jpk5x);
		jpk2_solid.add(jpk6x);

		JPanel jpk3s2 = new JPanel();
		jpk3s2.setPreferredSize(new Dimension(110, base_size));
		jpk3s2.setBackground(jgray);//gray6
		jpk3s2.setLayout(flow4);
		jpk3s2.add(submit);
		jpk3s2.add(importx);
		jpk3s2.add(refresh);
		jpk3s2.add(print_shipping);
		jpk3s2.add(empty_site);

		jpk3_solid.setPreferredSize(new Dimension(150, base_size));
		jpk3_solid.setBackground(st_gray1);//blackx
		jpk3_solid.setLayout(flow6);
		jpk3_solid.add(jpk3s2);

		//JPanel jpk2 = new JPanel();
		jpk2.setPreferredSize(new Dimension(900, base_size));
		jpk2.setBackground(jblue);//darkgray08
		jpk2.add(jpk1_solid);
		jpk2.add(jpk2_solid);
		jpk2.add(jpk3_solid);	


	//sides****************************************************************************************

	//footer***************************************************************************************


		fii0.setPreferredSize(new Dimension(135, 20));
		fii0.setIcon(imx_settings);
		//fii0.setToolTipText("<html>Alchemist<br>Java Database Durdby 1.0<br></html>");

		messages_db_button.setBorder(null); 
		messages_db_button.setPreferredSize(new Dimension(180, 20)); 
		messages_db_button.setOpaque(false); 
		messages_db_button.setBackground(blackx); 
		messages_db_button.setForeground(bluex1);  
		messages_db_button.addActionListener(this); 
		messages_db_button.setHorizontalAlignment(SwingConstants.CENTER); 
		messages_db_button.setToolTipText("Click here to view messages");
		messages_db_button.setFont(f_01);
		messages_db_button.setIcon(imx_messages);


		fii1.setPreferredSize(new Dimension(150, 20));

		fii2.setPreferredSize(new Dimension(400, 20));
		fii2.setText("Local JDB Database: Apache Derby - 10.5.3.0 - (802917)");
		fii2.setIcon(imx_database);

		//fii2.setIcon(imx_message_red);
		this.setTitle(program_name + " - Database and Sales Management - Running " + program_location + carbon[4][0][13]);

		program_version_button.setBorder(null); 
		program_version_button.setPreferredSize(new Dimension(150,20)); 
		program_version_button.setOpaque(false); 
		program_version_button.setBackground(blackx); 
		program_version_button.setForeground(bluex1);  
		program_version_button.addActionListener(this); 
		program_version_button.setHorizontalAlignment(SwingConstants.CENTER); 
		program_version_button.setToolTipText("Shipping System Test");
		program_version_button.setFont(f_01);
		program_version_button.setIcon(imx_message_red);


		program_message_button.setBorder(null); 
		program_message_button.setPreferredSize(new Dimension(150,20)); 
		program_message_button.setOpaque(false); 
		program_message_button.setBackground(blackx); 
		program_message_button.setForeground(bluex1);  
		program_message_button.addActionListener(this); 
		program_message_button.setHorizontalAlignment(SwingConstants.CENTER); 
		program_message_button.setToolTipText("Internet Access Test");
		program_message_button.setFont(f_01);
		program_message_button.setIcon(imx_message_red);

		//JPanel jpk3 = new JPanel();
		jpk3.setPreferredSize(new Dimension(xzx - 10, footer_size));
		jpk3.setBackground(jblue);//darkgray08
		jpk3.add(fii0);
		jpk3.add(fii2);
		jpk3.add(program_message_button);
		jpk3.add(program_version_button);


	//footer***************************************************************************************





	//setup********************************************************************************************************************************************************************
	//setup********************************************************************************************************************************************************************
	//setup********************************************************************************************************************************************************************
	//setup********************************************************************************************************************************************************************




		load_settings_pp();

	

		select_all.setMargin(new Insets(0, 0, 0, 0));
	  	select_all.addActionListener(this);
		select_all.setPreferredSize(new Dimension(60, 25));
		select_all.setHorizontalTextPosition(JButton.CENTER);
		select_all.setForeground(blackx);
		select_all.setBackground(jblue);
		select_all.setToolTipText("Select all items");

		select_quantity.setMargin(new Insets(0, 0, 0, 0));
	  	select_quantity.addActionListener(this);
		select_quantity.setPreferredSize(new Dimension(60, 25));
		select_quantity.setHorizontalTextPosition(JButton.CENTER);
		select_quantity.setForeground(blackx);
		select_quantity.setBackground(jblue);
		select_quantity.setToolTipText("Select items with quanitity > 0");

		select_combo.setMargin(new Insets(0, 0, 0, 0));
	  	select_combo.addActionListener(this);
		select_combo.setPreferredSize(new Dimension(60, 25));
		select_combo.setHorizontalTextPosition(JButton.CENTER);
		select_combo.setForeground(blackx);
		select_combo.setBackground(jblue);
		select_combo.setToolTipText("Select combo items");


		select_sold_s1.setMargin(new Insets(0, 0, 0, 0));
	  	select_sold_s1.addActionListener(this);
		select_sold_s1.setPreferredSize(new Dimension(60, 25));
		select_sold_s1.setHorizontalTextPosition(JButton.CENTER);
		select_sold_s1.setForeground(blackx);
		select_sold_s1.setBackground(jblue);
		select_sold_s1.setToolTipText("Select items that have quantity but no listing IDs");

		select_sold_s2.setMargin(new Insets(0, 0, 0, 0));
	  	select_sold_s2.addActionListener(this);
		select_sold_s2.setPreferredSize(new Dimension(60, 25));
		select_sold_s2.setHorizontalTextPosition(JButton.CENTER);
		select_sold_s2.setForeground(blackx);
		select_sold_s2.setBackground(jblue);
		select_sold_s2.setToolTipText("Select items with quantity > 30");

		select_sold_s3.setMargin(new Insets(0, 0, 0, 0));
	  	select_sold_s3.addActionListener(this);
		select_sold_s3.setPreferredSize(new Dimension(60, 25));
		select_sold_s3.setHorizontalTextPosition(JButton.CENTER);
		select_sold_s3.setForeground(blackx);
		select_sold_s3.setBackground(jblue);
		select_sold_s3.setToolTipText("Select items with sale prices less then 100");

		select_sold_s4.setMargin(new Insets(0, 0, 0, 0));
	  	select_sold_s4.addActionListener(this);
		select_sold_s4.setPreferredSize(new Dimension(60, 25));
		select_sold_s4.setHorizontalTextPosition(JButton.CENTER);
		select_sold_s4.setForeground(blackx);
		select_sold_s4.setBackground(jblue);
		select_sold_s4.setToolTipText("Select items with sale prices less then 100");

		select_sold_s5.setMargin(new Insets(0, 0, 0, 0));
	  	select_sold_s5.addActionListener(this);
		select_sold_s5.setPreferredSize(new Dimension(60, 25));
		select_sold_s5.setHorizontalTextPosition(JButton.CENTER);
		select_sold_s5.setForeground(blackx);
		select_sold_s5.setBackground(jblue);
		select_sold_s5.setToolTipText("Select items with sale prices less then 100");

		select_sold_s6.setMargin(new Insets(0, 0, 0, 0));
	  	select_sold_s6.addActionListener(this);
		select_sold_s6.setPreferredSize(new Dimension(60, 25));
		select_sold_s6.setHorizontalTextPosition(JButton.CENTER);
		select_sold_s6.setForeground(blackx);
		select_sold_s6.setBackground(jblue);
		select_sold_s6.setToolTipText("Select items with sale prices less then 100");

		select_sold_s7.setMargin(new Insets(0, 0, 0, 0));
	  	select_sold_s7.addActionListener(this);
		select_sold_s7.setPreferredSize(new Dimension(60, 25));
		select_sold_s7.setHorizontalTextPosition(JButton.CENTER);
		select_sold_s7.setForeground(blackx);
		select_sold_s7.setBackground(jblue);
		select_sold_s7.setToolTipText("Select items with sale prices less then 100");

		select_space1.setMargin(new Insets(0, 0, 0, 0));
		select_space1.setPreferredSize(new Dimension(60, 15));
		select_space1.setHorizontalTextPosition(JButton.CENTER);
		select_space1.setBackground(jblue);
		select_space1.setBorderPainted(false);

		select_listed.setMargin(new Insets(0, 0, 0, 0));
	  	select_listed.addActionListener(this);
		select_listed.setPreferredSize(new Dimension(60, 25));
		select_listed.setHorizontalTextPosition(JButton.CENTER);
		select_listed.setForeground(blackx);
		select_listed.setBackground(jblue);
		select_listed.setToolTipText("Select items that are Listed.. Sold.. ");

		select_types.setMargin(new Insets(0, 0, 0, 0));
	  	select_types.addActionListener(this);
		select_types.setPreferredSize(new Dimension(60, 25));
		select_types.setHorizontalTextPosition(JButton.CENTER);
		select_types.setForeground(blackx);
		select_types.setBackground(jblue);
		select_types.setToolTipText("Select account types. Like Magento accounts, or eBay accounts...");

		select_sites.setMargin(new Insets(0, 0, 0, 0));
	  	select_sites.addActionListener(this);
		select_sites.setPreferredSize(new Dimension(60, 25));
		select_sites.setHorizontalTextPosition(JButton.CENTER);
		select_sites.setForeground(blackx);
		select_sites.setBackground(jblue);
		select_sites.setToolTipText("Select items from the current list of accounts");


		select_space2.setMargin(new Insets(0, 0, 0, 0));
		select_space2.setPreferredSize(new Dimension(60, 15));
		select_space2.setHorizontalTextPosition(JButton.CENTER);
		select_space2.setBackground(jblue);
		select_space2.setBorderPainted(false);
		select_space2.setToolTipText("");


		select_archive_s1.setMargin(new Insets(0, 0, 0, 0));
	  	select_archive_s1.addActionListener(this);
		select_archive_s1.setPreferredSize(new Dimension(60, 25));
		select_archive_s1.setHorizontalTextPosition(JButton.CENTER);
		select_archive_s1.setForeground(blackx);
		select_archive_s1.setBackground(jblue);
		select_archive_s1.setToolTipText("Select items that have quantity but no listing IDs");

		select_archive_s2.setMargin(new Insets(0, 0, 0, 0));
	  	select_archive_s2.addActionListener(this);
		select_archive_s2.setPreferredSize(new Dimension(60, 25));
		select_archive_s2.setHorizontalTextPosition(JButton.CENTER);
		select_archive_s2.setForeground(blackx);
		select_archive_s2.setBackground(jblue);
		select_archive_s2.setToolTipText("Select items with quantity > 30");

		select_archive_s3.setMargin(new Insets(0, 0, 0, 0));
	  	select_archive_s3.addActionListener(this);
		select_archive_s3.setPreferredSize(new Dimension(60, 25));
		select_archive_s3.setHorizontalTextPosition(JButton.CENTER);
		select_archive_s3.setForeground(blackx);
		select_archive_s3.setBackground(jblue);
		select_archive_s3.setToolTipText("Select items with sale prices less then 100");

		select_archive_s4.setMargin(new Insets(0, 0, 0, 0));
	  	select_archive_s4.addActionListener(this);
		select_archive_s4.setPreferredSize(new Dimension(60, 25));
		select_archive_s4.setHorizontalTextPosition(JButton.CENTER);
		select_archive_s4.setForeground(blackx);
		select_archive_s4.setBackground(jblue);
		select_archive_s4.setToolTipText("Select items with sale prices less then 100");

		select_archive_s5.setMargin(new Insets(0, 0, 0, 0));
	  	select_archive_s5.addActionListener(this);
		select_archive_s5.setPreferredSize(new Dimension(60, 25));
		select_archive_s5.setHorizontalTextPosition(JButton.CENTER);
		select_archive_s5.setForeground(blackx);
		select_archive_s5.setBackground(jblue);
		select_archive_s5.setToolTipText("Select items with sale prices less then 100");

		select_archive_s6.setMargin(new Insets(0, 0, 0, 0));
	  	select_archive_s6.addActionListener(this);
		select_archive_s6.setPreferredSize(new Dimension(60, 25));
		select_archive_s6.setHorizontalTextPosition(JButton.CENTER);
		select_archive_s6.setForeground(blackx);
		select_archive_s6.setBackground(jblue);
		select_archive_s6.setToolTipText("Select items with sale prices less then 100");

		select_archive_s7.setMargin(new Insets(0, 0, 0, 0));
	  	select_archive_s7.addActionListener(this);
		select_archive_s7.setPreferredSize(new Dimension(60, 25));
		select_archive_s7.setHorizontalTextPosition(JButton.CENTER);
		select_archive_s7.setForeground(blackx);
		select_archive_s7.setBackground(jblue);
		select_archive_s7.setToolTipText("Select items with sale prices less then 100");


		jpk_sel[0] = new JPanel();
		jpk_sel[0].setPreferredSize(new Dimension(60, 400));
		jpk_sel[0].setBackground(jblue);
		jpk_sel[0].add(select_all);
		jpk_sel[0].add(select_quantity);
		jpk_sel[0].add(select_combo);
		jpk_sel[0].add(select_space1);

		jpk_sel[1] = new JPanel();
		jpk_sel[1].setPreferredSize(new Dimension(60, 400));
		jpk_sel[1].setBackground(jblue);

		jpk_sel[2] = new JPanel();
		jpk_sel[2].setPreferredSize(new Dimension(60, 400));
		jpk_sel[2].setBackground(jblue);
		jpk_sel[2].add(select_sold_s1);
		jpk_sel[2].add(select_sold_s2);
		jpk_sel[2].add(select_sold_s3);
		jpk_sel[2].add(select_sold_s4);
		jpk_sel[2].add(select_sold_s5);
		jpk_sel[2].add(select_sold_s6);
		jpk_sel[2].add(select_sold_s7);
		jpk_sel[2].add(select_space2);
		jpk_sel[2].add(select_listed);
		jpk_sel[2].add(select_types);
		jpk_sel[2].add(select_sites);

		jpk_sel[3] = new JPanel();
		jpk_sel[3].setPreferredSize(new Dimension(60, 400));
		jpk_sel[3].setBackground(jblue);
		jpk_sel[3].add(select_archive_s1);
		jpk_sel[3].add(select_archive_s2);
		jpk_sel[3].add(select_archive_s3);
		jpk_sel[3].add(select_archive_s4);
		jpk_sel[3].add(select_archive_s5);
		jpk_sel[3].add(select_archive_s6);
		jpk_sel[3].add(select_archive_s7);

		jpk_sel[4] = new JPanel();
		jpk_sel[4].setPreferredSize(new Dimension(60, 400));
		jpk_sel[4].setBackground(jblue);

		jpk_sel[5] = new JPanel();
		jpk_sel[5].setPreferredSize(new Dimension(60, 400));
		jpk_sel[5].setBackground(jblue);

		jpk_sel[6] = new JPanel();
		jpk_sel[6].setPreferredSize(new Dimension(60, 400));
		jpk_sel[6].setBackground(jblue);



		dxengine0.addPropertyChangeListener(this);
		dxengine1.addPropertyChangeListener(this);
		dxengine2.addPropertyChangeListener(this);
		dxengine3.addPropertyChangeListener(this);
		dxengine4.addPropertyChangeListener(this);
		dxengine5.addPropertyChangeListener(this);
		dxengine6.addPropertyChangeListener(this);


		//Build display panels including display, page bar and select all buttons.
		String[][][] export_display_list = build_export_display_list();
		dxengine0.setHeaderList(export_display_list[1]);
		dxengine0.setSizeList(export_display_list[2]);
		scrollPane[0] = dxengine0.getDisplay(export_display_list[0], xzx - 10, 360, 0, 1);

		String[][] export_monitor_list = build_monitor_display_list();
		String monitor_list[] = {"Name","URL","Running","Page Hits","Sales","Last Update","Account"};
		dxengine1.setHeaderList(monitor_list);
		int size_listx1[] = {250,500,150,150,150,150,150};
		dxengine1.setSizeList(size_listx1);
		scrollPane[1] = dxengine1.getDisplay(export_monitor_list, xzx - 10, 360, 1, 1);

		String[][][] sold_display_list = build_sold_display_list();
		dxengine2.setHeaderList(sold_display_list[1]);
		dxengine2.setSizeList(sold_display_list[2]);
		scrollPane[2] = dxengine2.getDisplay(sold_display_list[0], xzx - 10, 360, 2, 1);

		String[][][] archive_display_list = build_archive_display_list();
		dxengine3.setHeaderList(archive_display_list[1]);
		dxengine3.setSizeList(archive_display_list[2]);
		scrollPane[3] = dxengine3.getDisplay(archive_display_list[0], xzx - 10, 360, 3, 1);
		
		String[][] settings_display_list = build_settings_display_list();
		String settings_list[] = {"ID","Value"};
		dxengine4.setHeaderList(settings_list);
		int size_listx4[] = {250,500};
		dxengine4.setSizeList(size_listx4);
		scrollPane[4] = dxengine4.getDisplay(settings_display_list, xzx - 10, 360, 4, 0);
		
		String[][] connections_display_list = build_connections_display_list();
		String connections_list[] = {"Name","URL","ID","Date","Type","Active"};
		dxengine5.setHeaderList(connections_list);
		int size_listx5[] = {200,500,150,150,150,150};
		dxengine5.setSizeList(size_listx5);
		scrollPane[5] = dxengine5.getDisplay(connections_display_list, xzx - 10, 360, 5, 1);

		String[][] arrange_display_list = build_arrange_display_list();
		String arrange_list[] = {"Field","Database","Active","Order","Size","Color"};
		dxengine6.setHeaderList(arrange_list);
		int size_listx6[] = {250,250,150,150,150,150};
		dxengine6.setSizeList(size_listx6);
		scrollPane[6] = dxengine6.getDisplay(arrange_display_list, xzx - 10, 360, 6, 0);




		jpk_ccc[0] = new JPanel();
		jpk_ccc[0].setPreferredSize(new Dimension(xzx + 700, (items_value * (item_size + 5)) + 5));
		jpk_ccc[0].setBackground(jblue);
		jpk_ccc[0].setLayout(flow0);
		jpk_ccc[0].add(jpk_sel[0]);
		jpk_ccc[0].add(scrollPane[0]);
		jpk_ccc[0].add(framesPerPage0);

		jpk_ccc[1] = new JPanel();
		jpk_ccc[1].setPreferredSize(new Dimension(xzx + 700, (items_value * (item_size + 5)) + 5));
		jpk_ccc[1].setBackground(jblue);
		jpk_ccc[1].setLayout(flow0);
		jpk_ccc[1].add(jpk_sel[1]);
		jpk_ccc[1].add(scrollPane[1]);
		jpk_ccc[1].add(framesPerPage1);

		jpk_ccc[2] = new JPanel();
		jpk_ccc[2].setPreferredSize(new Dimension(xzx + 700, (items_value * (item_size + 5)) + 5));
		jpk_ccc[2].setBackground(jblue);
		jpk_ccc[2].setLayout(flow0);
		jpk_ccc[2].add(jpk_sel[2]);
		jpk_ccc[2].add(scrollPane[2]);
		jpk_ccc[2].add(framesPerPage2);

		jpk_ccc[3] = new JPanel();
		jpk_ccc[3].setPreferredSize(new Dimension(xzx + 700, (items_value * (item_size + 5)) + 5));
		jpk_ccc[3].setBackground(jblue);
		jpk_ccc[3].setLayout(flow0);
		jpk_ccc[3].add(jpk_sel[3]);
		jpk_ccc[3].add(scrollPane[3]);
		jpk_ccc[3].add(framesPerPage3);

		jpk_ccc[4] = new JPanel();
		jpk_ccc[4].setPreferredSize(new Dimension(xzx + 700, (items_value * (item_size + 5)) + 5));
		jpk_ccc[4].setBackground(jblue);
		jpk_ccc[4].setLayout(flow0);
		jpk_ccc[4].add(jpk_sel[4]);
		jpk_ccc[4].add(scrollPane[4]);
		jpk_ccc[4].add(framesPerPage4);

		jpk_ccc[5] = new JPanel();
		jpk_ccc[5].setPreferredSize(new Dimension(xzx + 700, (items_value * (item_size + 5)) + 5));
		jpk_ccc[5].setBackground(jblue);
		jpk_ccc[5].setLayout(flow0);
		jpk_ccc[5].add(jpk_sel[5]);
		jpk_ccc[5].add(scrollPane[5]);
		jpk_ccc[5].add(framesPerPage5);

		jpk_ccc[6] = new JPanel();
		jpk_ccc[6].setPreferredSize(new Dimension(xzx + 700, (items_value * (item_size + 5)) + 5));
		jpk_ccc[6].setBackground(jblue);
		jpk_ccc[6].setLayout(flow0);
		jpk_ccc[6].add(jpk_sel[6]);
		jpk_ccc[6].add(scrollPane[6]);
		jpk_ccc[6].add(framesPerPage6);





	//menu********************************************************************************************
	//menu********************************************************************************************
	//menu********************************************************************************************


	    JMenuBar menuBar = new JMenuBar();
	        
	    // Add the menubar to the frame
	    setJMenuBar(menuBar);
	        

		group.add(connectdbo);
		group.add(connectset);
		connectset.setEnabled(false);

		group2.add(use_item_x);
		group2.add(use_dazzle);
		group2.add(use_ups);
		group2.add(use_email);

		group3.add(inventory_yes);
		group3.add(inventory_no);



		try {

			     if (carbon[4][0][29].equals("0")) {use_item_x.setSelected(true);}
			else if (carbon[4][0][29].equals("1")) {use_dazzle.setSelected(true);}
			else if (carbon[4][0][29].equals("2")) {use_ups.setSelected(true);}
			else if (carbon[4][0][29].equals("3")) {use_email.setSelected(true);}

		} catch(Exception e) {

			use_dazzle.setSelected(true); 
			carbon[4][0][29] = "1";

		}//*******************




		loadAction.setEnabled(false);

		export_item.setEnabled(false);

		separatorx.setEnabled(false);


	    menuBar.add(fileMenu);
	    menuBar.add(editMenu);
	    menuBar.add(toolMenu);
	    menuBar.add(dataMenu); 
	    menuBar.add(shipMenu); 
	    menuBar.add(warehouseMenu); 
		menuBar.add(separatorx);
	    menuBar.add(websMenu);
		

		fileMenu.setFont(f_03);
	    fileMenu.add(saveAction);
	    fileMenu.addSeparator();
	    fileMenu.add(importblack);
	    fileMenu.add(importaction_csv_inventory);
	    fileMenu.add(importaction_csv);
	    fileMenu.add(importaction_xml);
	    fileMenu.add(importaction_json);
	    fileMenu.addSeparator();
	    fileMenu.add(amazon_upload_builder);
	    fileMenu.add(exportcsvinventory);
	    fileMenu.add(exportcsv);
	    fileMenu.add(exportiif);
	    fileMenu.add(exportxml);
	    fileMenu.add(exportjson);
	    fileMenu.addSeparator();
	    fileMenu.add(exitAction);

		editMenu.setFont(f_03);
	    editMenu.add(newitem);
	    editMenu.add(duplicate);
	    editMenu.add(duplicatex10);
	    editMenu.add(edititem);
	    editMenu.addSeparator();
	    editMenu.add(replace);
		editMenu.add(replace_other);
	    editMenu.addSeparator();
	    editMenu.add(copyAction);
	    editMenu.add(pasteAction);
	    editMenu.addSeparator();
	    editMenu.add(deleteitem);

		toolMenu.setFont(f_03);
		toolMenu.add(image_3);
		toolMenu.addSeparator();
	    toolMenu.add(combo);
	    toolMenu.add(combo2);
	    toolMenu.add(combo3);
	    toolMenu.add(combo_update_price);
	    toolMenu.add(combo_update_price_down);
		toolMenu.addSeparator();
	    toolMenu.add(blackmagic);
	    toolMenu.add(upload_archive);
		toolMenu.addSeparator();
	    toolMenu.add(disband_combos);
		toolMenu.addSeparator();
		toolMenu.add(ebay_final_fee);
		toolMenu.add(import_shipping_system);
		toolMenu.add(import_usps_data);
		toolMenu.add(import_royal_data);
		toolMenu.addSeparator();
	    toolMenu.add(keyboard_settings);
	    toolMenu.add(frame_builder);
	    toolMenu.add(change_api_port);
		toolMenu.add(change_directory);
	    toolMenu.add(pro_titles);
	    toolMenu.add(pro_tools);
	    toolMenu.add(fix_cost_price);
	    toolMenu.add(build_url_titles);
		toolMenu.addSeparator();
	    toolMenu.add(tools_rebuild_display);

		dataMenu.setFont(f_03);
		dataMenu.add(connectdbo);
		dataMenu.add(connectset);

		shipMenu.setFont(f_03);
		shipMenu.add(use_item_x);
		shipMenu.add(use_dazzle);
		shipMenu.add(use_ups);
		shipMenu.add(use_email);
		shipMenu.addSeparator();
		shipMenu.add(shipping_settings_item_x);
		shipMenu.add(shipping_settings_dazzle);
		shipMenu.add(shipping_settings_ups);
		shipMenu.add(shipping_settings_email);

		warehouseMenu.setFont(f_03);
		warehouseMenu.add(inventory_yes);
		warehouseMenu.add(inventory_no);
		warehouseMenu.addSeparator();
		warehouseMenu.add(value_inventory);
		warehouseMenu.add(weight_inventory);
		warehouseMenu.addSeparator();
		warehouseMenu.add(export_item);
		warehouseMenu.add(update_site_inventory);
		warehouseMenu.add(update_site_sale_price);
		warehouseMenu.addSeparator();
		warehouseMenu.add(order_program);

		websMenu.setFont(f_03);
		websMenu.add(amazon_errors);
		//websMenu.addSeparator();




	//action File
		openAction.addActionListener(this);
	    loadAction.addActionListener(this);
	    saveAction.addActionListener(this);
		importaction_csv_inventory.addActionListener(this);
	    importaction_csv.addActionListener(this);
	    importaction_xml.addActionListener(this);
	    importaction_json.addActionListener(this);
	  	importblack.addActionListener(this);
		importturbo.addActionListener(this);
		amazon_upload_builder.addActionListener(this);
		exportcsvinventory.addActionListener(this);
		exportcsv.addActionListener(this);
		exportiif.addActionListener(this);
		exportxml.addActionListener(this);
		exportjson.addActionListener(this);
		exitAction.addActionListener(this);

	//action Edit
		newitem.addActionListener(this);
		duplicate.addActionListener(this);
		duplicatex10.addActionListener(this);
		edititem.addActionListener(this);
		replace.addActionListener(this);
		replace_other.addActionListener(this);
		copyAction.addActionListener(this);
		pasteAction.addActionListener(this);
		deleteitem.addActionListener(this);

	//action Tools
		image_3.addActionListener(this);
		combo.addActionListener(this);
		combo2.addActionListener(this);
		combo3.addActionListener(this);
		combo_update_price.addActionListener(this);
		combo_update_price_down.addActionListener(this);
		ship_rates.addActionListener(this);
		blackmagic.addActionListener(this);
		upload_archive.addActionListener(this);
		disband_combos.addActionListener(this);
		ebay_final_fee.addActionListener(this);
		import_shipping_system.addActionListener(this);
		import_usps_data.addActionListener(this);
		import_royal_data.addActionListener(this);
		frame_builder.addActionListener(this);
		change_api_port.addActionListener(this);
		change_directory.addActionListener(this);
		pro_titles.addActionListener(this);
		pro_tools.addActionListener(this);
		fix_cost_price.addActionListener(this);
		build_url_titles.addActionListener(this);
		fix_ebay_id.addActionListener(this);
		reset_ebay_id.addActionListener(this);
		select_20_profit.addActionListener(this);
	    viewer.addActionListener(this);
	    setview.addActionListener(this);
	    shipping_settings_dazzle.addActionListener(this);
	    shipping_settings_ups.addActionListener(this);
		keyboard_settings.addActionListener(this);
		tools_rebuild_display.addActionListener(this);



	//action DB
		connectdbo.addActionListener(this);
		databasesettings.addActionListener(this);

	//action Ship
		use_item_x.addActionListener(this);
		use_dazzle.addActionListener(this);
		use_ups.addActionListener(this);
		use_email.addActionListener(this);
		shipping_settings_dazzle.addActionListener(this);
		shipping_settings_ups.addActionListener(this);
		shipping_settings_email.addActionListener(this);

	//action Warehouse
		inventory_yes.addActionListener(this);
		inventory_no.addActionListener(this);
		order_program.addActionListener(this);
		value_inventory.addActionListener(this);
		weight_inventory.addActionListener(this);
		update_site_inventory.addActionListener(this);
		update_site_sale_price.addActionListener(this);
		export_item.addActionListener(this);
		warehousesettings.addActionListener(this);

	//action Websites
	 	custom_update_field.addActionListener(this);
	 	amazon_errors.addActionListener(this);



	//font File
		openAction.setFont(f_01);
	    loadAction.setFont(f_01);
	    saveAction.setFont(f_01);
		importaction_csv_inventory.setFont(f_01);
	    importaction_csv.setFont(f_01);
	    importaction_xml.setFont(f_01);
	    importaction_json.setFont(f_01);
	  	importblack.setFont(f_01);
		importturbo.setFont(f_01);
		amazon_upload_builder.setFont(f_01);
		exportcsvinventory.setFont(f_01);
		exportcsv.setFont(f_01);
		exportiif.setFont(f_01);
		exportxml.setFont(f_01);
		exportjson.setFont(f_01);
		exitAction.setFont(f_01);

	//font Edit
		newitem.setFont(f_01);
		duplicate.setFont(f_01);
		duplicatex10.setFont(f_01);
		edititem.setFont(f_01);
		replace.setFont(f_01);
		replace_other.setFont(f_01);
		copyAction.setFont(f_01);
		pasteAction.setFont(f_01);
		deleteitem.setFont(f_01);

	//font Tools
		image_3.setFont(f_01);
		combo.setFont(f_01);
		combo2.setFont(f_01);
		combo3.setFont(f_01);
		combo_update_price.setFont(f_01);
		combo_update_price_down.setFont(f_01);
		ship_rates.setFont(f_01);
		blackmagic.setFont(f_01);
		upload_archive.setFont(f_01);
		disband_combos.setFont(f_01);
		ebay_final_fee.setFont(f_01);
		import_shipping_system.setFont(f_01);
		import_usps_data.setFont(f_01);
		import_royal_data.setFont(f_01);
		frame_builder.setFont(f_01);
		pro_titles.setFont(f_01);
		change_api_port.setFont(f_01);
		change_directory.setFont(f_01);
		pro_tools.setFont(f_01);
		fix_cost_price.setFont(f_01);
		build_url_titles.setFont(f_01);
		fix_ebay_id.setFont(f_01);
		reset_ebay_id.setFont(f_01);
		select_20_profit.setFont(f_01);
	    viewer.setFont(f_01);
	    setview.setFont(f_01);
		keyboard_settings.setFont(f_01);
		tools_rebuild_display.setFont(f_01);

	//font DB
		connectdbo.setFont(f_01);
		connectset.setFont(f_01);
		databasesettings.setFont(f_01);

	//font Ship
		use_item_x.setFont(f_01);
		use_dazzle.setFont(f_01);
		use_ups.setFont(f_01);
		use_email.setFont(f_01);
		shipping_settings_item_x.setFont(f_01);
		shipping_settings_dazzle.setFont(f_01);
		shipping_settings_ups.setFont(f_01);
		shipping_settings_email.setFont(f_01);

	//font Warehouse
		inventory_yes.setFont(f_01);
		inventory_no.setFont(f_01);
		order_program.setFont(f_01);
		value_inventory.setFont(f_01);
		weight_inventory.setFont(f_01);
		update_site_inventory.setFont(f_01);
		update_site_sale_price.setFont(f_01);
		export_item.setFont(f_01);
		warehousesettings.setFont(f_01);

	//font Websites
	 	custom_update_field.setFont(f_01);
	 	amazon_errors.setFont(f_01);




		//build sections
		export_panel = new JPanel();
		export_panel.setPreferredSize(new Dimension(xzx - 10, 500));
		export_panel.setBackground(jblue);//blackx
		export_panel.add(jpk_ccc[0]);
		
		monitor_panel = new JPanel();
		monitor_panel.setPreferredSize(new Dimension(xzx - 10, 500));
		monitor_panel.setBackground(jblue);//blackx
		monitor_panel.add(jpk_ccc[1]);

		sold_panel = new JPanel();
		sold_panel.setPreferredSize(new Dimension(xzx - 10, 500));
		sold_panel.setBackground(jblue);//blackx
		sold_panel.add(jpk_ccc[2]);

		archive_panel = new JPanel();
		archive_panel.setPreferredSize(new Dimension(xzx - 10, 500));
		archive_panel.setBackground(jblue);//blackx
		archive_panel.add(jpk_ccc[3]);

		settings_panel = new JPanel();
		settings_panel.setPreferredSize(new Dimension(xzx - 10, 500));
		settings_panel.setBackground(jblue);//blackx
		settings_panel.add(jpk_ccc[4]);

		connections_panel = new JPanel();
		connections_panel.setPreferredSize(new Dimension(xzx - 10, 500));
		connections_panel.setBackground(jblue);//blackx
		connections_panel.add(jpk_ccc[5]);

		display_panel = new JPanel();
		display_panel.setPreferredSize(new Dimension(xzx - 10, 500));
		display_panel.setBackground(jblue);//blackx
		display_panel.add(jpk_ccc[6]);
		//alchemist_display_viewer2 d2 = new alchemist_display_viewer2();

		import_panel = new JPanel();
		import_panel.setPreferredSize(new Dimension(xzx - 10, 500));
		import_panel.setBackground(jblue);//blackx
		//import_panel.add();
		//alchemist_import_viewer d3 = new alchemist_import_viewer();




		//tabbed pane
		topPanel = new JPanel();
		//topPanel.setPreferredSize(new Dimension(xzx - 10, 500));
		topPanel.setBackground(jgray);//blackx

		tabbedPane = new JTabbedPane();
		//tabbedPane.setPreferredSize(new Dimension(xzx - 100, 500));

		tabbedPane.addTab("Export", export_panel );
		tabbedPane.addTab("Monitor", monitor_panel );
		tabbedPane.addTab("Import", sold_panel );
		tabbedPane.addTab("Archive", archive_panel );
		tabbedPane.addTab("System", settings_panel );
		tabbedPane.addTab("Connections", connections_panel );
		tabbedPane.addTab("Display", display_panel);

		topPanel.add( tabbedPane, BorderLayout.CENTER );

		tabbedPane.addChangeListener(new ChangeListener() {

	    	public void stateChanged(ChangeEvent e) {

	            System.out.println("Tab: " + tabbedPane.getSelectedIndex());

	                 if (tabbedPane.getSelectedIndex() == 0) {create_button();}
	       		else if (tabbedPane.getSelectedIndex() == 1) {monitor_button();}
	        	else if (tabbedPane.getSelectedIndex() == 2) {sold_button();}
	        	else if (tabbedPane.getSelectedIndex() == 3) {archive_button();}
	        	else if (tabbedPane.getSelectedIndex() == 4) {settings_button();}
	        	else if (tabbedPane.getSelectedIndex() == 5) {websites_button();}
	        	else if (tabbedPane.getSelectedIndex() == 6) {display_button();}

	    	}//*************************************

		});//**********************************************



		//Container cp = getContentPane();
		cp.setLayout(flow1);
		cp.setFont(f_01);
		cp.setBackground(jgray);//blackx
		cp.setForeground(whitex);
		cp.add(jpk0);
		cp.add(topPanel);
		cp.add(jpk2);
		cp.add(jpk3);



		//Manual panel refresh. 
		refreshx();


		//If the program is resized we have to rebuild our panels.
		this.getContentPane().addHierarchyBoundsListener(new HierarchyBoundsListener(){

			@Override
			public void ancestorMoved(HierarchyEvent e) {
			
				refreshx();
					
			}

			@Override
			public void ancestorResized(HierarchyEvent e) {
					
				refreshx();
			
			}//override************************************		

		});//**************************************************************************




		//Loop program options.
	    xtimerx = new Timer();
	    xtimerx.schedule(new RemindTask_loopx(), 0);


		//Loop program api switch.
	    xtimerx = new Timer();
	    xtimerx.schedule(new RemindTask_api_switch(), 0);


	    //Current DB view.
		System.out.println("Current DB view: " + carbon[4][0][3]);


		//Load the drop down list top right. 
		set_submit_items();
		set_submit_monitor_items();


		//This is needed to fix the start up issues.
		archive_button();
		sold_button();
		create_button();


		//Auto ship.
		if (carbon[4][0][19].equals("1")) {infox1.setText("Auto ship System Is ON. Press Q to end."); auto_sales = 1;}


		carbon[4][0][14] = "user1";


		//test for internet access and version
		if (carbon[4][0][6].equals("0")) {remote_db_set();}
		else if (carbon[4][0][6].equals("2")) {csv_db_set();}
		else {local_db_set();}


		//Display is ready.
		program_display_ready = true;


		//Show the program.
		setVisible(true);


		//The try icon.
		SysTray();


		//Start the API Server.
		try {

			api_server_port = Integer.parseInt(carbon[4][0][86]);

			System.out.println("API PORT " + api_server_port);
			alchemy_api apix = new alchemy_api();

		} catch (Exception e) {System.out.println("API PORT ERROR");}


		//Everything is ready.
		program_ready_flag = true;

		//Test for internet connection.
		test_for_internet();


	} catch (Exception e) {e.printStackTrace(); System.exit(0);}



}//nm******************************************************************************************************************************










	public static int find_site_match(String id) {

		System.out.println("Find Site Match...");

		int id_match = -1;

		for (int loop1 = 0; loop1 < nm.carbon[5][user_info_xx].length; loop1++){

			if (nm.carbon[5][nm.id_mm][loop1].equals(id)) {id_match = loop1;}

		}//************************************************

		System.out.println("id_match " + id_match);

		return id_match;

	}//************************************



 




	public void ship_post_tracking_number_choose() {

		System.out.println(carbon[5][type_info_xx][current_submit_item_a]);


		     if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ].equals("Alchemy"))    {}
		else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ].equals("Amazon"))     {amazon_post_order_addtrack spof = new amazon_post_order_addtrack(what_item);}
		else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ].equals("Custom"))     {}
		else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ].equals("eBay"))       {ebay_post_order_addtrack sptn = new ebay_post_order_addtrack(what_item);}
		else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ].equals("Etsy"))       {etsy_post_order_addtrack sptn = new etsy_post_order_addtrack(what_item);}
		else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ].equals("Magento"))    {magento_post_order_addtrack sptn = new magento_post_order_addtrack(what_item);}
		else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ].equals("MySQL"))      {}
		else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][what_item]) ].equals("PayPal"))     {}


	}//********************************************







	public void ship_post_tracking_number_choose_x(int ix10) {//loop system.

		System.out.println(carbon[5][type_info_xx][current_submit_item_a]);


		     if (carbon[5][type_info_xx][current_submit_item_a].equals("Alchemy"))    {}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon"))     {amazon_post_order_addtrack spof = new amazon_post_order_addtrack(ix10);}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Custom"))     {}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay"))       {ebay_post_order_addtrack sptn1 = new ebay_post_order_addtrack(ix10);}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Etsy"))       {etsy_post_order_addtrack xptn1 = new etsy_post_order_addtrack(ix10);}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Magento"))    {magento_post_order_addtrack xptn1 = new magento_post_order_addtrack(ix10);}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("MySQL"))      {}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("PayPal"))     {}
		else if (current_submit_item_a == 0) {

			     if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("Alchemy"))    {}
			else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("Amazon"))     {amazon_post_order_addtrack spof = new amazon_post_order_addtrack(ix10);}
			else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("Custom"))     {}
			else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("eBay"))       {ebay_post_order_addtrack sptn1 = new ebay_post_order_addtrack(ix10);}
			else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("Etsy"))       {etsy_post_order_addtrack xptn1 = new etsy_post_order_addtrack(ix10);}
			else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("Magento"))    {magento_post_order_addtrack xptn1 = new magento_post_order_addtrack(ix10);}
			else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("MySQL"))      {}
			else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("PayPal"))     {}

		}//*********************************

	}//************************************************************






//database***********************************************************************************************************************************************************************************
//database***********************************************************************************************************************************************************************************





//load****************************************************************************************************
//load****************************************************************************************************




	public void test_for_sql(){

		this.setTitle(program_name + " - Database and Sales Management - Running jdbc:derby:" + carbon[4][0][7]);
		database_load_mode = 0;

		System.out.println("Test for SQL");

		System.out.println("Test for SQL Loader");

		infox1.setText("Load SQL Database...");

		try {

			mysql_loader_items msql = new mysql_loader_items();

		} catch (Exception e) {infox1.setText("Load SQL Database... Failed."); }


		if (carbon[0].length < 100) {

			System.out.println("TOO SMALL"); 
	
			carbon[0] = new String[db_cc_number][1];

			for (int xloop0 = 0; xloop0 < carbon[0][0].length; xloop0++) {//****

				for (int xloop1 = 0; xloop1 < 100; xloop1++) {//****

					carbon[0][xloop1][xloop0] = new String(db_string[xloop1]);

				}//if***********************************************

			}//if***************************************************************


			JOptionPane.showMessageDialog(null,"The SQL database failed to load.");

		}//if**********************
		else {System.out.println("TOO SMALL " + carbon[0][0].length);}


	}//***********************






	public void test_for_csv() {

		this.setTitle(program_name + " - Database and Sales Management - Running " + carbon[4][0][4]);
		database_load_mode = 2;

		carbon[0] = new String[0][0];

		try {

			csv_loader_items csv_imxx = new csv_loader_items();

		} catch (Exception e) {System.out.println("Error 879870890-");}


		if (carbon[0].length < 100) {

			System.out.println("TOO SMALL"); 
	
			carbon[0] = new String[db_cc_number][1];

			for (int xloop0 = 0; xloop0 < carbon[0][0].length; xloop0++) {//****

				for (int xloop1 = 0; xloop1 < 100; xloop1++){//******

					carbon[0][xloop1][xloop0] = new String(db_string[xloop1]);

				}//if***********************************************

			}//if***************************************************************

			JOptionPane.showMessageDialog(null,"The .csv database failed to load.");

		}//if**********************
		else{System.out.println("TOO SMALL " + carbon[0][0].length);}


	}//************************







	public void test_for_jdb() {

		this.setTitle(program_name + " - Database and Sales Management - Running " + program_location + carbon[4][0][13]);

		database_load_mode = 1;

		try{

			jdb_loader_items jdbloaderitems = new jdb_loader_items();

			int kcountxx = carbon[0].length;
			int kcountxx2 = carbon[0][0].length;

			items_total = kcountxx2;

		} catch (Exception e) {System.out.println("JDB LOAD ITEMS FAILED");}//rebuild items database;




		if (carbon[0].length < 100) {

			System.out.println("TOO SMALL"); 
	
			carbon[0] = new String[db_cc_number][1];

			for (int xloop0 = 0; xloop0 < carbon[0][0].length; xloop0++) {//***

				for (int xloop1 = 0; xloop1 < 100; xloop1++) {//****

					carbon[0][xloop1][xloop0] = new String(db_string[xloop1]);

				}//if***********************************************

			}//if**************************************************************

			JOptionPane.showMessageDialog(null,"The JDB database failed to load.");

		}//if**********************
		else {System.out.println("TOO SMALL " + carbon[0][0].length);}


	}//************************










	public void load_jdb_settings() {


		//start the system driver
		systemx = new jdb_driver();

		jloader_start.setText("Load Database Settings");


		try {

			jdb_loader_settings jdbloadersettings = new jdb_loader_settings();

			int kcountxx = carbon[0].length;
			int kcountxx2 = carbon[0][0].length;

			items_total = kcountxx2;

			carbon[4][0][16] = "1";

		} catch (Exception e) {

			e.printStackTrace(); 
			System.out.println("JDB LOAD SETTINGS FAILED");

		}

		System.out.println("NEXT SETTINGS");

		try {

			if (db_ss_number < 100) {

				System.out.println("Rebuild DB...");

				alchemy_rebuild_db rbd = new alchemy_rebuild_db(); 
				carbon[4][0][16] = new String("0");

			}//************************

			jloader_start.setText("Load Database Listings");

		} catch (Exception e) {

			System.out.println("TEST REBUILD"); 
			alchemy_rebuild_db rbd = new alchemy_rebuild_db(); 
			carbon[4][0][16] = new String("0");

		}


	}//public**************








	public void save_jdb_settings() {

		infox1.setText("Saving test for length errors...");

		alchemy_trim trimx = new alchemy_trim();
		//System.out.println("TRIM THEM DONE.");

		infox1.setText("Saving...");

		jdb_saver_settings jdb_save_settings = new jdb_saver_settings();

		infox1.setText("Save complete.");

	}//*********************




//database***********************************************************************************************************************************************************************************
//database***********************************************************************************************************************************************************************************
//database***********************************************************************************************************************************************************************************




//************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************
//errors



	public int[] test_warnings() {

		warning_list = new int[carbon[0][0].length];

		int items_y = carbon[0][0].length;

		//set warnings

		for (int xloop = 0; xloop < items_y; xloop++) {//******

			try {


				if (Integer.parseInt(carbon[0][total_on_hand_xx][xloop]) < 1) {//**************************************

					warning_list[xloop] = 1; 
					carbon[0][notes_xx][xloop] = "Out of stock";

				}//*****************************************************************************************************
				else if (Integer.parseInt(carbon[0][total_on_hand_xx][xloop]) < Integer.parseInt(carbon[0][ Integer.parseInt(carbon[4][0][75]) ][xloop]) || Integer.parseInt(carbon[0][total_on_hand_xx][xloop]) < 1) {

					warning_list[xloop] = 1; 
					carbon[0][notes_xx][xloop] = "Inventory is low";

				}//*************************************************************************************************************************************************************************************************
				else {

					warning_list[xloop] = 0;
					carbon[0][notes_xx][xloop] = ""; 

				}//**


			} catch(Exception e) {

				//e.printStackTrace();

				try {

					if (Integer.parseInt(carbon[0][total_on_hand_xx][xloop]) < 1) {//**************************************

						warning_list[xloop] = 1; 
						carbon[0][notes_xx][xloop] = "Out of stock";

					}//*****************************************************************************************************
					else {

						warning_list[xloop] = 0;
						carbon[0][notes_xx][xloop] = ""; 

					}//**

				} catch(Exception ex) {

					warning_list[xloop] = 1; 
					carbon[0][notes_xx][xloop] = "Stock index error";

				}//*******************

			}//*****************

		}//********************************************************************



		for (int xloop = 0; xloop < items_y; xloop++) {//***********

			try {

				int ix0 = carbon[0][title_xx][xloop].length();

        		if (ix0 > 79) { 

        			warning_list[xloop] = 1;
					carbon[0][notes_xx][xloop] = "Titles on eBay can only be 80 characters.";

				}//done

			} catch (Exception e) {}

			try {

				Float costx = Float.parseFloat(carbon[0][item_cost_xx][xloop]);
				Float pricex = Float.parseFloat(carbon[0][item_price_xx][xloop]);

        		if (pricex < costx) { 

        			warning_list[xloop] = 1;
					carbon[0][notes_xx][xloop] = "The price of this item is set less then your cost.";

				}//done

			} catch (Exception e) {}

		}//*********************************************************


		return warning_list;

	}//***************************






	public int[] test_errors() {

		error_list = new int[carbon[0][0].length];

		int items_y = carbon[0][0].length;


		//set errors

		for (int xloop = 0; xloop < items_y; xloop++) {//***********

			try {

				int ix0 = carbon[0][title_xx][xloop].indexOf("“");
				int ix1 = carbon[0][part_number_xx][xloop].indexOf("“");

        		if (ix0 > -1 || ix1 > -1) {

        			error_list[xloop] = 1;
					carbon[0][notes_xx][xloop] = "The '“' Symbol used in this Title or Description could cause XML errors with eBay.";

				}//done

			} catch (Exception e) {}

			try {

				int ix0 = carbon[0][item_description_xx][xloop].indexOf("“");
				int ix1 = carbon[0][picture_1_xx][xloop].indexOf("“");

        		if (ix0 > -1 || ix1 > -1) { 

        			error_list[xloop] = 1;
					carbon[0][notes_xx][xloop] = "The '“' Symbol used in this Title or Description could cause XML errors with eBay.";

				}//done

			} catch (Exception e) {}

			try{

     			if (carbon[0][item_description_xx][xloop].length() > 90000) {

					error_list[xloop] = 1;
					carbon[0][notes_xx][xloop] = "This item's description will be truncated to 90,000 characters.";

				}//done

			} catch (Exception e) {}

			try {

				int ix0 = carbon[0][title_xx][xloop].indexOf("&");
				int ix1 = carbon[0][part_number_xx][xloop].indexOf("&");

        		if (ix0 > -1 || ix1 > -1) { 

        			error_list[xloop] = 1;
					carbon[0][notes_xx][xloop] = "The '&' Symbol used in this Title or Part Number will cause XML Postback errors when shipping.";

				}//done

			} catch (Exception e) {}

			try {

				int ix0 = carbon[0][title_xx][xloop].indexOf("|");
				int ix1 = carbon[0][part_number_xx][xloop].indexOf("|");

       			if(ix0 > -1 || ix1 > -1){ 

       				error_list[xloop] = 1;
					carbon[0][notes_xx][xloop] = "The '|' Symbol used in this Title or Part Number will cause errors.";

				}//done

			} catch (Exception e) {}


		}//********************************************************************



		for (int xloop = 0; xloop < items_y; xloop++) {//******

			for (int xloop2 = (xloop + 1); xloop2 < items_end; xloop2++) {//*******

				try {

					String cx0 = carbon[0][item_id_xx][xloop];
					String cx1 = carbon[0][item_id_xx][xloop2];

        			if (cx0.equals(cx1)) { 

        				error_list[xloop] = 1;
						carbon[0][notes_xx][xloop] = "This item's ID is the same as another item's ID. This will cause listing erros.";

					}//*******************

				} catch (Exception e) {}

			}//********************************************************************

		}//****************************************************



		for (int xloop = 0; xloop < items_y; xloop++) {//******

			for (int xloop2 = (xloop + 1); xloop2 < items_end; xloop2++) {//******

				try {

					String cx0 = carbon[0][item_id_xx][xloop];
					String cx1 = carbon[0][item_id_xx][xloop2];

        			if (cx0.equals(cx1)) { 

        				error_list[xloop] = 1;
						carbon[0][notes_xx][xloop] = "This item's ID is the same as another item's ID. This will cause listing erros.";

					}//*******************
					else{}

				} catch (Exception e) {}

			}//********************************************************************

		}//********************************************************************


		return error_list;

	}//testerros***********************







	public void show_errors() {



		//show warning
		int warning_int = 0;

		for (int xloop = items_start; xloop < items_end; xloop++){//******

			try {

				if (warning_list[xloop] == 1) {warning_int++;}
			
			} catch (Exception e) {}

		}//********************************************************************

		item_label0_1.setText("Total Warnings (" + Integer.toString(warning_int) + ")");



		//show errors
		int error_int = 0;
		for (int xloop = items_start; xloop < items_end; xloop++){//******

			try {

				if (error_list[xloop] == 1) {error_int++;}

			} catch (Exception e) {}

		}//********************************************************************

		item_label0_2.setText("Total Errors (" + Integer.toString(error_int) + ")");


	
	}//showerrors***********************






	public void show_error_list() {


		line_warnings = 0;
		line_errors = 0;

		System.out.println("Show Error List...");

		error_message_list = "<html>ERROR LIST:";

		//set warnings

		try {

			if (Integer.parseInt(carbon[0][total_on_hand_xx][what_item]) < 1) {//**************************************

				error_message_list = error_message_list + "<br>Out of stock";
				line_warnings++;

			}//********************************************************************************************************
			else if (Integer.parseInt(carbon[0][total_on_hand_xx][what_item]) < Integer.parseInt(carbon[0][ Integer.parseInt(carbon[4][0][75]) ][what_item]) || Integer.parseInt(carbon[0][total_on_hand_xx][what_item]) < 1) {

				error_message_list = error_message_list + "<br>Inventory is low";
				line_warnings++;

			}//**************************************************************************************************************************************************************************************************************

		} catch(Exception e) {

			error_message_list = error_message_list + "<br>Stock index error"; 
			line_warnings++;

		}//*****************


		try {

			int ix0 = carbon[0][title_xx][what_item].indexOf("“");
			int ix1 = carbon[0][part_number_xx][what_item].indexOf("“");

      		if (ix0 > -1 || ix1 > -1) {

    			error_message_list = error_message_list + "<br>The '“' Symbol used in this Title or Description could cause XML errors with eBay";
				line_errors++;

			}//done

		} catch (Exception e) {}


		try {

			int ix0 = carbon[0][item_description_xx][what_item].indexOf("“");
			int ix1 = carbon[0][picture_1_xx][what_item].indexOf("“");

      		if (ix0 > -1 || ix1 > -1) {

    			error_message_list = error_message_list + "<br>The '“' Symbol used in this Title or Description could cause XML errors with eBay";
				line_errors++;

			}//done

		} catch (Exception e) {}


		try {

       		if (carbon[0][item_description_xx][what_item].length() > 90000) {

    			error_message_list = error_message_list + "<br>This item's description will be truncated to 90,000 characters";
				line_errors++;

			}//done

		} catch (Exception e) {}


		try {

			int ix0 = carbon[0][title_xx][what_item].indexOf("&");
			int ix1 = carbon[0][part_number_xx][what_item].indexOf("&");

       		if (ix0 > -1 || ix1 > -1) {

       		 	error_message_list = error_message_list + "<br>The '&' Symbol used in this Title or Part Number will cause XML Postback errors when shipping";
				line_errors++;

			}//done

		} catch (Exception e) {}


		try {

			int ix0 = carbon[0][title_xx][what_item].length();

        	if (ix0 > 79) {

       			error_message_list = error_message_list + "<br>eBay titles can only be 80 characters.";
				line_warnings++;

			}//done

		} catch (Exception e) {}


		try {

			int ix0 = carbon[0][title_xx][what_item].indexOf("|");
			int ix1 = carbon[0][part_number_xx][what_item].indexOf("|");

      		if (ix0 > -1 || ix1 > -1) {

       			error_message_list = error_message_list + "<br>The '|' Symbol used in this Title or Part Number will cause errors";
				line_errors++;

			}//done

		} catch (Exception e) {}


		try {

			Float costx = Float.parseFloat(carbon[0][item_cost_xx][what_item]);
			Float pricex = Float.parseFloat(carbon[0][item_price_xx][what_item]);

      		if (pricex < costx) {

       			error_message_list = error_message_list + "<br>The price of this item is set less then your cost";
				line_warnings++;

			}//done

		} catch (Exception e) {}


		for (int xloop2 = 0; xloop2 < items_end; xloop2++) {//******

			try {

				String cx0 = carbon[0][item_id_xx][what_item];
				String cx1 = carbon[0][item_id_xx][xloop2];

        		if (cx0.equals(cx1) && xloop2 != what_item) {

       				error_message_list = error_message_list + "<br>This items ID is the same as another item's ID. This will cause listing erros";
					line_errors++;

				}//******************************************

			} catch (Exception e) {}

		}//********************************************************************


		error_message_list = error_message_list + "</html>";
		item_label0.setText("Item: " + Integer.toString(what_item + 1) + " selected with warnings(" + Integer.toString(line_warnings) + ") errors(" + Integer.toString(line_errors) + ")");
		item_label0.setToolTipText(error_message_list);

		try {

			//throw new ArithmeticException("/ by zero");

		} catch (Exception e) {e.printStackTrace();}	

	}//***************************show error list










	public void stats_get_sales_datax() {

		try {

			view_data_i_total = 0;	
			view_data_i_newsales = 0;
			view_data_i_ready = 0;
			view_data_i_shipped = 0;
			view_data_i_refunded = 0;
			view_data_i_errors = 0;
			view_data_i_success = 0;

			for (int xloop = 0; xloop < nm.carbon[2][0].length; xloop++) {//*********

				view_data_i_total++;

				     if (nm.carbon[2][nm.sale_status_xx][xloop].equals("Sold")) {view_data_i_newsales++;}
				else if (nm.carbon[2][nm.sale_status_xx][xloop].equals("Ready to ship")) {view_data_i_ready++;}
				else if (nm.carbon[2][nm.sale_status_xx][xloop].equals("Shipped")) {view_data_i_shipped++;}
				else if (nm.carbon[2][nm.sale_status_xx][xloop].equals("Refunded")) {view_data_i_refunded++;}
				else if (nm.carbon[2][nm.sale_status_xx][xloop].equals("Error")) {view_data_i_errors++;}
				else if (nm.carbon[2][nm.sale_status_xx][xloop].equals("Successful")) {view_data_i_success++;}
				else {}

			}//********************************************************************

			infox1.setText("SALE STATUS: (" + view_data_i_newsales + " New) (" + view_data_i_ready + " Ready) (" + view_data_i_shipped + " Shipped) (" + view_data_i_refunded + " Refunded) (" + view_data_i_errors + " Errors) (" + view_data_i_success + " Success)");
	
		} catch (Exception e) {System.out.println("1234155"); infox1.setText("Errors!");}

	}//**********************************








	public void stats_get_sales_count() {

		try {

			int view_ix1 = 0;
			Float view_fx0 = (float) 0.00;
			Float view_fx1 = (float) 0.00;
			Float view_fx2 = (float) 0.00;

			for (int xloop = 1; xloop < nm.carbon[2][0].length; xloop++) {//*********

				if (nm.carbon[2][source_of_sale_xx][xloop].equals(nm.carbon[1][0][what_item])) {
				
					view_ix1++; 
					view_fx0 = view_fx0 + (Float.parseFloat(nm.carbon[2][total_sale_amount_xx][xloop]));

				}//***************************************************************************

				view_fx1 = view_fx1 + (Float.parseFloat(nm.carbon[2][total_sale_amount_xx][xloop]));

			}//********************************************************************


			view_fx2 = (view_fx0 * 100) / view_fx1;



			String cx0 = Float.toString(view_fx0);
			int ix0 = cx0.indexOf(".");

			if (ix0 > -1) {

				cx0 = cx0 + "00";
				cx0 = cx0.substring(0, ix0 + 3);
				view_fx0 = Float.parseFloat(cx0);

			}//**********

			String cx1 = Float.toString(view_fx2);
			int ix1 = cx1.indexOf(".");

			if (ix1 > -1) {

				cx1 = cx1 + "00";
				cx1 = cx1.substring(0, ix1 + 3);
				view_fx2 = Float.parseFloat(cx1);

			}//**********

		} catch (Exception e) {System.out.println("1234155"); infox1.setText("Errors!");}

	}//**********************************






	public void stats_get_sales_count2() {

		try{

			int view_ix1 = 0;
			Float view_fx0 = (float) 0.00;
			Float view_fx1 = (float) 0.00;
			Float view_fx2 = (float) 0.00;

			for(int xloop = 1; xloop < nm.carbon[3][0].length; xloop++){//*********

				if(nm.carbon[3][source_of_sale_xx][xloop].equals(nm.carbon[1][0][what_item])){
		
					view_ix1++; 
					view_fx0 = view_fx0 + (Float.parseFloat(nm.carbon[3][total_sale_amount_xx][xloop]));

				}//***************************************************************************

				view_fx1 = view_fx1 + (Float.parseFloat(nm.carbon[3][total_sale_amount_xx][xloop]));

			}//********************************************************************


			view_fx2 = (view_fx0 * 100) / view_fx1;


			String cx0 = Float.toString(view_fx0);
			int ix0 = cx0.indexOf(".");

			if(ix0 > -1){

				cx0 = cx0 + "00";
				cx0 = cx0.substring(0, ix0 + 3);
				view_fx0 = Float.parseFloat(cx0);

			}//**********

			String cx1 = Float.toString(view_fx2);
			int ix1 = cx1.indexOf(".");

			if (ix1 > -1) {

				cx1 = cx1 + "00";
				cx1 = cx1.substring(0, ix1 + 3);
				view_fx2 = Float.parseFloat(cx1);

			}//**********

		} catch (Exception e) {System.out.println("1234156"); infox1.setText("Errors!");}

	}//**********************************











//************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************
//************************************************************************************************************************************************************************




	public void select_all_itemsx() {



	}//********************************




	public void select_all_itemsx_q() {


	}//select_all_items****************




	public void select_all_itemsx_combo() {


	}//select_all_items********************




	public void select_all_itemsx_amazon() {


	}//select_all_items*********************




	public void select_all_itemsx_ebay() {


	}//select_all_items*******************




	public void select_all_itemsx_listed() {


	}//select_all_items*********************




	public void select_all_itemsx_types() {


	}//select_all_items********************




	public void select_all_itemsx_sites() {


	}//select_all_items********************




	public void select_all_itemsx_q_no_id() {


	}//select_all_items**********************




	public void select_all_itemsx_q_g_30() {


	}//select_all_items*********************




	public void select_all_itemsx_q_l_100() {


	}//select_all_items**********************











	public void save_settings_pp() {

		//Save Settings.
		carbon[4][0][0] = Integer.toString(jdi0);
		carbon[4][0][1] = Integer.toString(jdi1);
		carbon[4][0][2] = Integer.toString(current_submit_item_x);
		carbon[4][0][3] = Integer.toString(db_number);

		carbon[4][0][5] = Integer.toString(current_submit_item_a);

		carbon[4][0][27] = search_tf.getText();
		carbon[4][0][28] = Integer.toString(what_search_field);

	}//****************************









	public void load_settings_pp() {


		//settings
		current_submit_item_x = Integer.parseInt(carbon[4][0][2]);
		current_submit_item_a = Integer.parseInt(carbon[4][0][5]);


		//what database was last used
		db_number = Integer.parseInt(carbon[4][0][3]);


		//set search items
		search_tf.setText(carbon[4][0][27]);
		what_search_field = Integer.parseInt(carbon[4][0][28]);


		try {

			cb_search_field.setSelectedIndex(what_search_field);

		} catch (Exception e){System.out.println("what_search_field " + what_search_field);}


		//what section was used to sort rows
		sort_int = Integer.parseInt(carbon[4][0][25]);
		sort_string = db_string[sort_int];

		// database set
		if (carbon[4][0][6].equals("0")) {remote_db_set();}
		else if (carbon[4][0][6].equals("2")) {csv_db_set();}
		else {local_db_set();}


		// other
		if (carbon[4][0][72].equals("0")) {inventory_no.setSelected(true);}
		else {inventory_yes.setSelected(true);}


	}//**********************************






	public void set_300_page(){

		int size_dd = (items_total / display_count);

		System.out.println("framesPerPage " + size_dd);
		framesPerPage0.setMaximum(db_00_size / display_count);
		framesPerPage1.setMaximum(size_dd);
		framesPerPage2.setMaximum(db_02_size / display_count);
		framesPerPage3.setMaximum(db_03_size / display_count);
		framesPerPage4.setMaximum(0);
		framesPerPage5.setMaximum(0);
		framesPerPage6.setMaximum(0);

		items_value = items_end - items_start;

		System.out.println("Display items set page " + items_value);

	}//*************************






	public void refreshx(){

		//System.out.println("REFRESH");

		jd = getSize();

		jdi0 = (int) jd.getWidth();
		jdi1 = (int) jd.getHeight();

		jpk0.setPreferredSize(new Dimension(jdi0 -15, header_size));

		//jpk_ccc[0].setPreferredSize(new Dimension(jdi0 -128, jdi1 -285));
		//jpk_sel[0].setPreferredSize(new Dimension(jdi0 -128, jdi1 -285));
		scrollPane[0].setPreferredSize(new Dimension(jdi0 -128, jdi1 -285));
		scrollPane[1].setPreferredSize(new Dimension(jdi0 -128, jdi1 -285));
		scrollPane[2].setPreferredSize(new Dimension(jdi0 -128, jdi1 -285));
		scrollPane[3].setPreferredSize(new Dimension(jdi0 -128, jdi1 -285));
		scrollPane[4].setPreferredSize(new Dimension(jdi0 -128, jdi1 -285));
		scrollPane[5].setPreferredSize(new Dimension(jdi0 -128, jdi1 -285));
		scrollPane[6].setPreferredSize(new Dimension(jdi0 -128, jdi1 -285));

		framesPerPage0.setPreferredSize(new Dimension(30, jdi1 -285));
		framesPerPage1.setPreferredSize(new Dimension(30, jdi1 -285));
		framesPerPage2.setPreferredSize(new Dimension(30, jdi1 -285));
		framesPerPage3.setPreferredSize(new Dimension(30, jdi1 -285));
		framesPerPage4.setPreferredSize(new Dimension(30, jdi1 -285));
		framesPerPage5.setPreferredSize(new Dimension(30, jdi1 -285));
		framesPerPage6.setPreferredSize(new Dimension(30, jdi1 -285));

		jpk_sel[0].setPreferredSize(new Dimension(60, jdi1 -285));
		jpk_sel[1].setPreferredSize(new Dimension(60, jdi1 -285));
		jpk_sel[2].setPreferredSize(new Dimension(60, jdi1 -285));
		jpk_sel[3].setPreferredSize(new Dimension(60, jdi1 -285));
		jpk_sel[4].setPreferredSize(new Dimension(60, jdi1 -285));
		jpk_sel[5].setPreferredSize(new Dimension(60, jdi1 -285));
		jpk_sel[6].setPreferredSize(new Dimension(60, jdi1 -285));

		jpk_ccc[0].setPreferredSize(new Dimension(jdi0 -15, jdi1 -285));
		jpk_ccc[1].setPreferredSize(new Dimension(jdi0 -15, jdi1 -285));
		jpk_ccc[2].setPreferredSize(new Dimension(jdi0 -15, jdi1 -285));
		jpk_ccc[3].setPreferredSize(new Dimension(jdi0 -15, jdi1 -285));
		jpk_ccc[4].setPreferredSize(new Dimension(jdi0 -15, jdi1 -285));
		jpk_ccc[5].setPreferredSize(new Dimension(jdi0 -15, jdi1 -285));
		jpk_ccc[6].setPreferredSize(new Dimension(jdi0 -15, jdi1 -285));

		jpk2.setPreferredSize(new Dimension(jdi0 -15, base_size)); // don't change this width int*******
		jpk3.setPreferredSize(new Dimension(jdi0 -15, footer_size));

		//spacer_4.setPreferredSize(new Dimension(jdi0 - 1200, 20));
		infox1.setPreferredSize(new Dimension(jdi0 - 770, 20));
		infox4.setPreferredSize(new Dimension(jdi0 - 1135, 20));
		header_panel.setPreferredSize(new Dimension(jdi0 - 10, 35));

		fii2.setPreferredSize(new Dimension((jdi0 - 470), 20));

		topPanel.setPreferredSize(new Dimension(jdi0 - 10, jdi1 -244));
		tabbedPane.setPreferredSize(new Dimension(jdi0 - 10, jdi1 -244));
		export_panel.setPreferredSize(new Dimension(jdi0 - 10, jdi1 -145));

		jpk1_solid.setPreferredSize(new Dimension(((jdi0 / 2) - 458), base_size -10));
		jpk3_solid.setPreferredSize(new Dimension(((jdi0 / 2) - 458), base_size -10));


		//import sections
		try {import_amazon_sp.setPreferredSize(new Dimension(1000, jdi1 -286));}  catch (Exception e) {}
		try {import_custom_sp.setPreferredSize(new Dimension(1000, jdi1 -286));}  catch (Exception e) {}
		try {import_ebay_sp.setPreferredSize(new Dimension(1000, jdi1 -286));}    catch (Exception e) {}
		try {import_etsy_sp.setPreferredSize(new Dimension(1000, jdi1 -286));}    catch (Exception e) {}
		try {import_magento_sp.setPreferredSize(new Dimension(1000, jdi1 -286));} catch (Exception e) {}
		try {import_mysql_sp.setPreferredSize(new Dimension(1000, jdi1 -286));}   catch (Exception e) {}
		try {import_krypton_sp.setPreferredSize(new Dimension(1000, jdi1 -286));} catch (Exception e) {}
		try {import_paypal_sp.setPreferredSize(new Dimension(1000, jdi1 -286));}  catch (Exception e) {}
		try {import_gmail_sp.setPreferredSize(new Dimension(1000, jdi1 -286));}   catch (Exception e) {}



	}//******************




//********************************************************************************************************************************





//set select buttons on off

	public void set_select_on() {

		select_all.setEnabled(false);
		select_quantity.setEnabled(false);
		select_combo.setEnabled(false);
		select_ebayid.setEnabled(false);
		select_amazonid.setEnabled(false);
		select_space1.setEnabled(false);
		select_listed.setEnabled(false);
		select_types.setEnabled(false);
		select_sites.setEnabled(false);
		select_space2.setEnabled(false);
		select_archive_s1.setEnabled(false);
		select_archive_s2.setEnabled(false);
		select_archive_s3.setEnabled(false);



		if (db_number == 0) {

			select_all.setEnabled(true);
			select_quantity.setEnabled(true);
			select_combo.setEnabled(true);
			select_ebayid.setEnabled(true);
			select_amazonid.setEnabled(true);
			select_space1.setEnabled(false);
			select_listed.setEnabled(false);
			select_types.setEnabled(false);
			select_sites.setEnabled(false);
			select_space2.setEnabled(false);
			select_archive_s1.setEnabled(false);
			select_archive_s2.setEnabled(false);
			select_archive_s3.setEnabled(false);

		}//****************
		if (db_number == 2) {

			select_all.setEnabled(true);
			select_quantity.setEnabled(true);
			select_combo.setEnabled(true);
			select_ebayid.setEnabled(false);
			select_amazonid.setEnabled(false);
			select_space1.setEnabled(false);
			select_listed.setEnabled(true);
			select_types.setEnabled(true);
			select_sites.setEnabled(true);
			select_space2.setEnabled(false);
			select_archive_s1.setEnabled(false);
			select_archive_s2.setEnabled(false);
			select_archive_s3.setEnabled(false);

		}//*****************
		if (db_number == 3) {

			select_all.setEnabled(true);
			select_quantity.setEnabled(true);
			select_combo.setEnabled(true);
			select_ebayid.setEnabled(false);
			select_amazonid.setEnabled(false);
			select_space1.setEnabled(false);
			select_listed.setEnabled(true);
			select_types.setEnabled(true);
			select_sites.setEnabled(true);
			select_space2.setEnabled(false);
			select_archive_s1.setEnabled(true);
			select_archive_s2.setEnabled(true);
			select_archive_s3.setEnabled(true);

		}//*****************


	}//*************************



	public void set_select_off() {

		select_all.setEnabled(false);
		select_quantity.setEnabled(false);
		select_combo.setEnabled(false);
		select_ebayid.setEnabled(false);
		select_amazonid.setEnabled(false);
		select_space1.setEnabled(false);
		select_listed.setEnabled(false);
		select_types.setEnabled(false);
		select_space2.setEnabled(false);
		select_sites.setEnabled(false);
		select_archive_s1.setEnabled(false);
		select_archive_s2.setEnabled(false);
		select_archive_s3.setEnabled(false);

	}//***************************




//********************************************************************************************************************************

	public void set_button_on_off() {

		try {

			System.out.println("current_submit_item_a " + current_submit_item_a);

			     if (current_submit_item_a == 0) {infox3.setText("All accounts");}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon")) {infox3.setText("Amazon Account");}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Custom")) {infox3.setText("Custom");}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay")) {infox3.setText("eBay Account");}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Etsy")) {infox3.setText("Etsy Account");}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Magento")) {infox3.setText("Magento account");}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("MySQL")) {infox3.setText("MySQL");}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("PayPal")) {infox3.setText("PayPal");}
			else {infox1.setText("error 89899");}

			System.out.println("SET_BUTTONS_ON_OFF");

			if (db_number == 0) {//********************************************

				import_shipping_system.setEnabled(false);
				import_usps_data.setEnabled(false);
				import_royal_data.setEnabled(false);

				upload_archive.setEnabled(false);
				amazon_upload_builder.setEnabled(true);
				select_20_profit.setEnabled(true);
				fix_ebay_id.setEnabled(true);
				pro_titles.setEnabled(true);
				fix_cost_price.setEnabled(true);
				replace_other.setEnabled(true);
				disband_combos.setEnabled(true);
				cutAction.setEnabled(true);
				copy_to.setEnabled(true);
				copyAction.setEnabled(true);
				pasteAction.setEnabled(true);
				deleteitem.setEnabled(true);
				frame_builder.setEnabled(true);
				build_url_titles.setEnabled(true);

				cb_search_field.setEnabled(true);
				search_tf.setEnabled(true);
				search_b.setEnabled(true);

				newitem.setEnabled(true);
				newAction.setEnabled(true);
				new_item.setEnabled(true);
				edit_item.setEnabled(true);
				delete.setEnabled(true);
				view_item.setEnabled(false);
				empty_site.setEnabled(true);
				duplicate.setEnabled(true);
				duplicatex10.setEnabled(true);

				openAction.setEnabled(false);
	   			importaction_csv_inventory.setEnabled(true);

				submit.setEnabled(true);
				importx.setEnabled(true);
				refresh.setEnabled(false);
				print_shipping.setEnabled(false);
				archivex.setEnabled(false);

				exportcsvinventory.setEnabled(true);
				exportcsv.setEnabled(true);
				exportiif.setEnabled(true);
				exportxml.setEnabled(true);
				exportjson.setEnabled(true);

				importaction_xml.setEnabled(true);
				importaction_csv.setEnabled(true);
				importaction_json.setEnabled(true);
				importblack.setEnabled(true);
				importturbo.setEnabled(true);

				combo.setEnabled(true);
				combo2.setEnabled(true);
				combo3.setEnabled(true);
				combo_update_price.setEnabled(true);
				combo_update_price_down.setEnabled(true);
				ship_rates.setEnabled(true);
				image_3.setEnabled(true);
				replace.setEnabled(true);

				try {


	  		  		if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon")) {

	  		  			amazon_inventory.setEnabled(true);
	  		  			amazon_sale_price.setEnabled(true);
	  		  			amazon_errors.setEnabled(true);

	  		  		}//*******************************************************************
	  		  		else {

	  		  			amazon_inventory.setEnabled(false);
	  		  			amazon_sale_price.setEnabled(false);
	  		  			amazon_errors.setEnabled(false);

	  		  		}//***


	   				if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay")) {

	   					ebay_inventory.setEnabled(true);
	   					ebay_sale_price.setEnabled(true);

	   				}//*****************************************************************
	   				else {

	   					ebay_inventory.setEnabled(false);
						ebay_sale_price.setEnabled(false);

	   				}//***


	    		} catch (Exception e) {}

				importturbo.setEnabled(false);

				order_program.setEnabled(true);
				warehousesettings.setEnabled(true);
				update_warehouse_inventory.setEnabled(true);
				update_inventory.setEnabled(true);
				value_inventory.setEnabled(true);
				weight_inventory.setEnabled(true);
				custom_update_field.setEnabled(false); 
				edititem.setEnabled(true);
				reset_ebay_id.setEnabled(true);

				if (current_submit_item_x == 0) {

					submit.setEnabled(false);
					importx.setEnabled(false);
					refresh.setEnabled(false);
					empty_site.setEnabled(false);
					view_item.setEnabled(false);

					update_site_inventory.setEnabled(false);
					update_site_sale_price.setEnabled(false);

				}//****************************
				else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay")) {

					refresh.setEnabled(false);
					importx.setEnabled(false);
					empty_site.setEnabled(false);
					view_item.setEnabled(false);

					update_site_inventory.setEnabled(true);
					update_site_sale_price.setEnabled(true);

				}//****************************************************
				else if (carbon[5][type_info_xx][current_submit_item_a].equals("Etsy")) {

					refresh.setEnabled(false);
					importx.setEnabled(false);
					empty_site.setEnabled(false);
					view_item.setEnabled(false);

					update_site_inventory.setEnabled(true);
					update_site_sale_price.setEnabled(true);

				}//*******************************************************
				else if (carbon[5][type_info_xx][current_submit_item_a].equals("Custom")) {

					refresh.setEnabled(true);
					view_item.setEnabled(false);

					update_site_inventory.setEnabled(true);
					update_site_sale_price.setEnabled(true);

				}//*******************************************************
				else if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon")) {

					importx.setEnabled(false);
					empty_site.setEnabled(false);
					view_item.setEnabled(false);

					update_site_inventory.setEnabled(true);
					update_site_sale_price.setEnabled(true);

				}//*******************************************************
				else if (carbon[5][type_info_xx][current_submit_item_a].equals("Magento")) {

					submit.setEnabled(true);
					importx.setEnabled(false);
					refresh.setEnabled(false);
					empty_site.setEnabled(true);
					view_item.setEnabled(false);

					update_site_inventory.setEnabled(true);
					update_site_sale_price.setEnabled(true);

				}//*******************************************************
				else {

					submit.setEnabled(false);
					importx.setEnabled(false);
					refresh.setEnabled(false);
					empty_site.setEnabled(false);
					view_item.setEnabled(false);

					update_site_inventory.setEnabled(false);
					update_site_sale_price.setEnabled(false);

				}//***


		 		if (carbon[4][0][6].equals("2")) {

		 			view_item.setEnabled(false); 
		 			edit_item.setEnabled(false);

		 		}//***************************

			}//if************************************************************




			if (db_number == 1) {//********************************************

				import_shipping_system.setEnabled(true);
				import_usps_data.setEnabled(true);
				import_royal_data.setEnabled(true);

				upload_archive.setEnabled(false);
				amazon_upload_builder.setEnabled(false);
				select_20_profit.setEnabled(false);
				fix_ebay_id.setEnabled(false);
				pro_titles.setEnabled(false);
				fix_cost_price.setEnabled(false);
				replace_other.setEnabled(false);
				disband_combos.setEnabled(false);
				cutAction.setEnabled(false);
				copy_to.setEnabled(false);
				copyAction.setEnabled(false);
				pasteAction.setEnabled(false);
				deleteitem.setEnabled(false);
				frame_builder.setEnabled(false);
				build_url_titles.setEnabled(false);

				newitem.setEnabled(false);
				newAction.setEnabled(false);
				new_item.setEnabled(false);
				edit_item.setEnabled(false);
				delete.setEnabled(false);
				view_item.setEnabled(false);
				empty_site.setEnabled(false);
				duplicate.setEnabled(false);
				duplicatex10.setEnabled(false);
				refresh.setEnabled(false);

				openAction.setEnabled(false);
	   			importaction_csv_inventory.setEnabled(false);
	   			amazon_inventory.setEnabled(false);

				cb_search_field.setEnabled(false);
				search_tf.setEnabled(false);
				search_b.setEnabled(false);

				combo.setEnabled(false);
				combo2.setEnabled(false);
				combo3.setEnabled(false);
				combo_update_price.setEnabled(false);
				combo_update_price_down.setEnabled(false);
				ship_rates.setEnabled(false);
				image_3.setEnabled(false);
				replace.setEnabled(false);

				exportcsvinventory.setEnabled(false);
				exportcsv.setEnabled(false);
				exportiif.setEnabled(false);
				exportxml.setEnabled(false);
				exportjson.setEnabled(false);

				importaction_xml.setEnabled(false);
				importaction_csv.setEnabled(false);
				importaction_json.setEnabled(false);
				importblack.setEnabled(false);
				importturbo.setEnabled(false);
				amazon_errors.setEnabled(false);

				reset_ebay_id.setEnabled(false);

				order_program.setEnabled(false);
				warehousesettings.setEnabled(false);
				update_warehouse_inventory.setEnabled(false);
				update_inventory.setEnabled(false);
				value_inventory.setEnabled(false);
				weight_inventory.setEnabled(false);
				ebay_inventory.setEnabled(false); 
				ebay_sale_price.setEnabled(false); 
				amazon_sale_price.setEnabled(false); 
				custom_update_field.setEnabled(false); 
				edititem.setEnabled(false);

				update_site_inventory.setEnabled(false);
				update_site_sale_price.setEnabled(false);

			}//if************************************************************




			if (db_number == 2) {//********************************************

				import_shipping_system.setEnabled(false);
				import_usps_data.setEnabled(false);
				import_royal_data.setEnabled(false);

				upload_archive.setEnabled(true);
				amazon_upload_builder.setEnabled(false);
				select_20_profit.setEnabled(false);
				fix_ebay_id.setEnabled(false);
				pro_titles.setEnabled(false);
				fix_cost_price.setEnabled(false);
				replace_other.setEnabled(false);
				disband_combos.setEnabled(false);
				cutAction.setEnabled(false);
				copy_to.setEnabled(false);
				copyAction.setEnabled(false);
				pasteAction.setEnabled(false);
				deleteitem.setEnabled(false);
				frame_builder.setEnabled(false);
				build_url_titles.setEnabled(false);

				newitem.setEnabled(false);
				newAction.setEnabled(false);

				cb_search_field.setEnabled(true);
				search_tf.setEnabled(true);
				search_b.setEnabled(true);
				duplicate.setEnabled(false);
				duplicatex10.setEnabled(false);

				openAction.setEnabled(false);
	      		importaction_csv_inventory.setEnabled(false);
	       		amazon_inventory.setEnabled(false);

				combo.setEnabled(false);
				combo2.setEnabled(false);
				combo3.setEnabled(false);
				combo_update_price.setEnabled(false);
				combo_update_price_down.setEnabled(false);
				ship_rates.setEnabled(false);
				image_3.setEnabled(false);
				replace.setEnabled(false);

				exportcsvinventory.setEnabled(false);
				exportcsv.setEnabled(true);
				exportiif.setEnabled(true);
				exportxml.setEnabled(true);
				exportjson.setEnabled(true);

				importaction_xml.setEnabled(true);
				importaction_csv.setEnabled(true);
				importaction_json.setEnabled(true);
				importblack.setEnabled(false);
				importturbo.setEnabled(false);
				amazon_errors.setEnabled(true);
				importturbo.setEnabled(false);

				try {

					if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay")) {submit.setEnabled(false);}
					else {submit.setEnabled(true);}

				} catch (Exception e) {}

				order_program.setEnabled(false);
				warehousesettings.setEnabled(false);
				update_warehouse_inventory.setEnabled(false);
				update_inventory.setEnabled(false);
				value_inventory.setEnabled(false);
				weight_inventory.setEnabled(false);
				ebay_inventory.setEnabled(false); 
				custom_update_field.setEnabled(false); 
				edititem.setEnabled(false);
				ebay_sale_price.setEnabled(false); 
				amazon_sale_price.setEnabled(false); 

				update_site_inventory.setEnabled(false);
				update_site_sale_price.setEnabled(false);

				reset_ebay_id.setEnabled(false);


					if (current_submit_item_a == 0) {//*************

		  				submit.setEnabled(false);
		  				//importx.setEnabled(false);
		 				refresh.setEnabled(false);

		 			}//*******************************************
		  			else {//**************************************

		  				submit.setEnabled(false);
		  				importx.setEnabled(true);
		  				refresh.setEnabled(false);

		 			}//******************************************


			}//if************************************************************

	 


			if (db_number == 3) {//********************************************

				upload_archive.setEnabled(true);
				amazon_upload_builder.setEnabled(false);
				select_20_profit.setEnabled(false);
				fix_ebay_id.setEnabled(false);
				pro_titles.setEnabled(false);
				fix_cost_price.setEnabled(false);
				replace_other.setEnabled(true);
				disband_combos.setEnabled(false);
				cutAction.setEnabled(false);
				copy_to.setEnabled(false);
				copyAction.setEnabled(false);
				pasteAction.setEnabled(false);
				deleteitem.setEnabled(false);
				frame_builder.setEnabled(false);
				build_url_titles.setEnabled(false);

				newitem.setEnabled(false);
				newAction.setEnabled(false);
				empty_site.setEnabled(false);

				cb_search_field.setEnabled(true);
				search_tf.setEnabled(true);
				search_b.setEnabled(true);
				duplicate.setEnabled(false);
				duplicatex10.setEnabled(false);

				openAction.setEnabled(false);
	        	importaction_csv_inventory.setEnabled(false);
	        	amazon_inventory.setEnabled(false);

				combo.setEnabled(false);
				combo2.setEnabled(false);
				combo3.setEnabled(false);
				combo_update_price.setEnabled(false);
				combo_update_price_down.setEnabled(false);
				ship_rates.setEnabled(false);
				image_3.setEnabled(false);
				replace.setEnabled(true);

				exportcsvinventory.setEnabled(false);
				exportcsv.setEnabled(true);
				exportiif.setEnabled(true);
				exportxml.setEnabled(true);
				exportjson.setEnabled(true);

				importaction_xml.setEnabled(true);
				importaction_csv.setEnabled(true);
				importaction_json.setEnabled(true);
				importblack.setEnabled(false);
				importturbo.setEnabled(false);
				amazon_errors.setEnabled(false);

				order_program.setEnabled(false);
				warehousesettings.setEnabled(false);
				update_warehouse_inventory.setEnabled(false);
				update_inventory.setEnabled(false);
				value_inventory.setEnabled(false);
				weight_inventory.setEnabled(false);
				ebay_inventory.setEnabled(false);
				custom_update_field.setEnabled(false);  
				edititem.setEnabled(false);
				ebay_sale_price.setEnabled(false); 
				amazon_sale_price.setEnabled(false); 

				update_site_inventory.setEnabled(false);
				update_site_sale_price.setEnabled(false);

				reset_ebay_id.setEnabled(false);


		 			if(current_submit_item_a == 0){//*************

		  				submit.setEnabled(false);
		  				importx.setEnabled(false);
		  				refresh.setEnabled(false);

		  			}//*******************************************
		  			else{//**************************************

		  				submit.setEnabled(false);
		  				importx.setEnabled(false);
		  				refresh.setEnabled(false);

		  			}//*******************************************


			}//if************************************************************




			if(db_number == 4){//********************************************

				import_shipping_system.setEnabled(false);
				import_usps_data.setEnabled(false);
				import_royal_data.setEnabled(false);

				upload_archive.setEnabled(false);
				amazon_upload_builder.setEnabled(false);
				select_20_profit.setEnabled(false);
				fix_ebay_id.setEnabled(false);
				pro_titles.setEnabled(false);
				fix_cost_price.setEnabled(false);
				replace_other.setEnabled(false);
				disband_combos.setEnabled(false);
				cutAction.setEnabled(false);
				copy_to.setEnabled(false);
				copyAction.setEnabled(false);
				pasteAction.setEnabled(false);
				deleteitem.setEnabled(false);
				frame_builder.setEnabled(false);
				build_url_titles.setEnabled(false);

				newitem.setEnabled(false);
				newAction.setEnabled(false);

				cb_search_field.setEnabled(false);
				search_tf.setEnabled(false);
				search_b.setEnabled(false);
				duplicate.setEnabled(false);
				duplicatex10.setEnabled(false);

				openAction.setEnabled(false);
	        	importaction_csv_inventory.setEnabled(false);
	        	amazon_inventory.setEnabled(false);

				combo.setEnabled(false);
				combo2.setEnabled(false);
				combo3.setEnabled(false);
				combo_update_price.setEnabled(false);
				combo_update_price_down.setEnabled(false);
				ship_rates.setEnabled(false);
				image_3.setEnabled(false);
				replace.setEnabled(false);

				exportcsvinventory.setEnabled(false);
				exportcsv.setEnabled(false);
				exportiif.setEnabled(false);
				exportxml.setEnabled(false);
				exportjson.setEnabled(false);

				importaction_xml.setEnabled(false);
				importaction_csv.setEnabled(false);
				importaction_json.setEnabled(false);
				importblack.setEnabled(false);
				importturbo.setEnabled(false);
				amazon_errors.setEnabled(false);

				order_program.setEnabled(false);
				warehousesettings.setEnabled(false);
				update_warehouse_inventory.setEnabled(false);
				update_inventory.setEnabled(false);
				value_inventory.setEnabled(false);
				weight_inventory.setEnabled(false);
				ebay_inventory.setEnabled(false); 
				custom_update_field.setEnabled(false); 
				edititem.setEnabled(false);
				ebay_sale_price.setEnabled(false); 
				amazon_sale_price.setEnabled(false); 

				update_site_inventory.setEnabled(false);
				update_site_sale_price.setEnabled(false);

				reset_ebay_id.setEnabled(false);


		  			if (current_submit_item_a == 0) {//*************

		  				submit.setEnabled(false);
		  				//importx.setEnabled(false);
		  				refresh.setEnabled(false);

		 			}//*******************************************
		  			else {//**************************************

			  			submit.setEnabled(false);
			  			importx.setEnabled(false);
			  			refresh.setEnabled(false);

		  			}//******************************************


			}//if************************************************************




			if (db_number == 5) {//********************************************

				import_shipping_system.setEnabled(false);
				import_usps_data.setEnabled(false);
				import_royal_data.setEnabled(false);

				upload_archive.setEnabled(false);
				amazon_upload_builder.setEnabled(false);
				select_20_profit.setEnabled(false);
				fix_ebay_id.setEnabled(false);
				pro_titles.setEnabled(false);
				fix_cost_price.setEnabled(false);
				replace_other.setEnabled(false);
				disband_combos.setEnabled(false);
				cutAction.setEnabled(false);
				copy_to.setEnabled(false);
				copyAction.setEnabled(false);
				pasteAction.setEnabled(false);
				deleteitem.setEnabled(true);
				frame_builder.setEnabled(false);
				build_url_titles.setEnabled(false);

				newitem.setEnabled(false);
				newAction.setEnabled(false);

				cb_search_field.setEnabled(false);
				search_tf.setEnabled(false);
				search_b.setEnabled(false);
				duplicate.setEnabled(false);
				duplicatex10.setEnabled(false);
				exportiif.setEnabled(false);

				openAction.setEnabled(false);
	       		importaction_csv_inventory.setEnabled(false);
	        	amazon_inventory.setEnabled(false);

				combo.setEnabled(false);
				combo2.setEnabled(false);
				combo3.setEnabled(false);
				combo_update_price.setEnabled(false);
				combo_update_price_down.setEnabled(false);
				ship_rates.setEnabled(false);
				image_3.setEnabled(false);
				replace.setEnabled(false);

				exportcsvinventory.setEnabled(false);
				exportcsv.setEnabled(false);
				exportiif.setEnabled(false);
				exportxml.setEnabled(false);
				exportjson.setEnabled(false);

				importaction_xml.setEnabled(false);
				importaction_csv.setEnabled(false);
				importaction_json.setEnabled(false);
				importblack.setEnabled(false);
				importturbo.setEnabled(false);
				amazon_errors.setEnabled(false);

				order_program.setEnabled(false);
				warehousesettings.setEnabled(false);
				update_warehouse_inventory.setEnabled(false);
				update_inventory.setEnabled(false);
				value_inventory.setEnabled(false);
				weight_inventory.setEnabled(false);
				ebay_inventory.setEnabled(false); 
				custom_update_field.setEnabled(false); 
				edititem.setEnabled(true);
				ebay_sale_price.setEnabled(false); 
				amazon_sale_price.setEnabled(false); 

				update_site_inventory.setEnabled(false);
				update_site_sale_price.setEnabled(false);

				reset_ebay_id.setEnabled(false);


		  			if (current_submit_item_a == 0) {//*************

		  				submit.setEnabled(false);
		  				importx.setEnabled(false);
		  				refresh.setEnabled(false);

		  			}//*******************************************
		  			else {//**************************************

		  				submit.setEnabled(false);
		  				importx.setEnabled(false);
		  				refresh.setEnabled(false);

		  			}//*******************************************


			}//if************************************************************


		} catch (Exception e) {e.printStackTrace();}


	}//on off***********************





//******************************************************************************************************************777
//******************************************************************************************************************777
//******************************************************************************************************************777






//online***********************************************************************************************************************************************************************************
//online***********************************************************************************************************************************************************************************





	//test amazon
	public void connectx_amazon() {//********************************************************************************amazon

		item_label5x_0.setForeground(darkgreenx);
		item_label5x_0.setText("");

		// Construct data
		try {

 
			System.out.println("test1");
			amazon_test testx = new amazon_test();
			String pass_com = "0";
			System.out.println("test2");


			if (pass_com.equals("1")) {

				item_label5x_0.setForeground(darkgreenx);  
				carbon[5][active_info_xx][what_item] = "yes"; 

				cb_active.setSelectedIndex(1); 
				item_label5x_0.setText("Connected");

			}//*******************
			else {

				item_label5x_0.setForeground(redx);                         
				carbon[5][active_info_xx][what_item] = "no"; 

				cb_active.setSelectedIndex(0); 
				item_label5x_0.setText("Faild!"); 

			}

			set_submit_monitor_items();
			//save_sites();


			} catch (Exception e) {

				e.printStackTrace(); 

				item_label5x_0.setForeground(redx); 
				carbon[5][active_info_xx][what_item] = "no";  

				cb_active.setSelectedIndex(0); 
				item_label5x_0.setText("Error!"); 

			}//*****************



	}//connectx()*********************************************************************************************





	//Custom API
	public void connectx_custom() {//********************************************************************************

		item_label5x_0.setForeground(darkgreenx);
		item_label5x_0.setText("");

		// Construct data
		try {

			System.out.println("test1");
			alchemy_test testx = new alchemy_test();
			String pass_com = "0";
			System.out.println("test2");

			if (pass_com.equals("1")) {

				item_label5x_0.setForeground(darkgreenx);  
				carbon[5][active_info_xx][what_item] = "yes"; 

				cb_active.setSelectedIndex(1); 
				item_label5x_0.setText("Connected");

			}//*******************
			else {

				item_label5x_0.setForeground(redx);   
				carbon[5][active_info_xx][what_item] = "no"; 

				cb_active.setSelectedIndex(0); 
				item_label5x_0.setText("Failed!");

			}//***

			set_submit_monitor_items();
			//save_sites();

		} catch (Exception e) {

			item_label5x_0.setForeground(redx); 
			carbon[5][active_info_xx][what_item] = "no"; 

			cb_active.setSelectedIndex(0); 
			item_label5x_0.setText("Error!");

		}//******************


	}//connectx()*********************************************************************************************





	//test ebay
	public void connectx_ebay() {//********************************************************************************ebay

		item_label5x_0.setForeground(darkgreenx);
		item_label5x_0.setText("");


		try {


			infox1.setText("Connecting to eBay.");
			System.out.println("Connecting to eBay.");
			repaint();


			ebay_test testx = new ebay_test();
			String pass_com = testx.test(what_item);

			infox1.setText(pass_com);

			if (pass_com.equals("1")){       

				item_label5x_0.setForeground(darkgreenx);  
				carbon[5][active_info_xx][what_item] = "yes";

				String[][] connections_display_list = build_connections_display_list();
				dxengine5.display_item(connections_display_list,1);

				cb_active.setSelectedIndex(1); 
				item_label5x_0.setText("Connected!");

			}
			else {                       

				item_label5x_0.setForeground(redx);       
				carbon[5][active_info_xx][what_item] = "no";

				String[][] connections_display_list = build_connections_display_list();
				dxengine5.display_item(connections_display_list,1);

				cb_active.setSelectedIndex(0); 
				item_label5x_0.setText("Failed!");

			}

			set_submit_monitor_items();
			//save_sites();

		} catch (Exception e) {

			item_label5x_0.setForeground(redx); 
			carbon[5][active_info_xx][what_item] = "no";

			String[][] connections_display_list = build_connections_display_list();
			dxengine5.display_item(connections_display_list,1);

			cb_active.setSelectedIndex(0); 
			item_label5x_0.setText("Error!");

		}//*****************


	}//connectx()*********************************************************************************************




	//magento alchemy
	public void connectx_magento() {//********************************************************************************

		item_label5x_0.setForeground(darkgreenx);
		item_label5x_0.setText("");

		// Construct data
		try {


			System.out.println("test1");
			magento_test ais = new magento_test();
			String pass_com = "0";

			System.out.println("test2");

			if (pass_com.equals("1")) {     

				item_label5x_0.setForeground(darkgreenx);  
				carbon[5][active_info_xx][what_item] = "yes";

				cb_active.setSelectedIndex(1); 
				item_label5x_0.setText("Connected");

			}
			else {

				item_label5x_0.setForeground(redx);        
				carbon[5][active_info_xx][what_item] = "no";

				cb_active.setSelectedIndex(0); 
				item_label5x_0.setText("Failed!");

			}

			set_submit_monitor_items();
			//save_sites();

		}catch(Exception e){

			item_label5x_0.setForeground(redx); 
			carbon[5][active_info_xx][what_item] = "no";

			cb_active.setSelectedIndex(0); 
			item_label5x_0.setText("Error!");

		}//****************


	}//connectx()*********************************************************************************************




	public void connectx_mysql() {//**************************************************************************

		item_label5x_0.setForeground(darkgreenx);
		item_label5x_0.setText("");

		// Construct data
		try {

			System.out.println("test1");

			System.out.println("TEST DB");
			mysql_test msqlt = new mysql_test();
			String pass_com = "0";

			System.out.println("test2");

			if (pass_com.equals("1")) {

				item_label5x_0.setForeground(darkgreenx);  
				carbon[5][active_info_xx][what_item] = "yes";

				cb_active.setSelectedIndex(1); 
				item_label5x_0.setText("Connected");

			}//***********************
			else {

				item_label5x_0.setForeground(redx); 
				carbon[5][active_info_xx][what_item] = "no";

				cb_active.setSelectedIndex(0); 
				item_label5x_0.setText("Failed!");

			}//***

			set_submit_monitor_items();
			//save_sites();

		} catch (Exception e) {

			item_label5x_0.setForeground(redx); 
			carbon[5][active_info_xx][what_item] = "no";

			cb_active.setSelectedIndex(0); 
			item_label5x_0.setText("Error!");

		}//*****************

	}//connectx()*********************************************************************************************




	//etsy
	public void connectx_etsy() {//********************************************************************************

		item_label5x_0.setForeground(darkgreenx);
		item_label5x_0.setText("");

		// Construct data
		try {


			System.out.println("ETSY DB");

			etsy_test testx = new etsy_test();
			String pass_com = testx.test(what_item);

			System.out.println("test2");

			if(pass_com.equals("1")) {

				item_label5x_0.setForeground(darkgreenx);  
				carbon[5][active_info_xx][what_item] = "yes";

				cb_active.setSelectedIndex(1); 
				item_label5x_0.setText("Connected");

			}//***********************
			else {

				item_label5x_0.setForeground(redx); 
				carbon[5][active_info_xx][what_item] = "no";

				cb_active.setSelectedIndex(0); 
				item_label5x_0.setText("Failed!");

			}//***

			set_submit_monitor_items();
			//save_sites();

		} catch (Exception e) {

			item_label5x_0.setForeground(redx); 
			carbon[5][active_info_xx][what_item] = "no";

			cb_active.setSelectedIndex(0); 
			item_label5x_0.setText("Error!");

		}//*****************


	}//connectx()*********************************************************************************************




	//test paypal
	public void connectx_paypal() {//********************************************************************************paypal

		item_label5x_0.setForeground(darkgreenx);
		item_label5x_0.setText("");

		// Construct data
		try {
 	
			System.out.println("test1");

			paypal_test testx = new paypal_test();
			String pass_com = "0";

			System.out.println("test2");

			if (pass_com.equals("1")) {

				item_label5x_0.setForeground(darkgreenx);  
				carbon[5][active_info_xx][what_item] = "yes"; 
				cb_active.setSelectedIndex(1); 
				item_label5x_0.setText("Connected");

			}
			else {

				item_label5x_0.setForeground(redx);                         
				carbon[5][active_info_xx][what_item] = "no";

				cb_active.setSelectedIndex(0); 
				item_label5x_0.setText("Failed!"); 
				//infox1.setText(pass_error);

			}

			set_submit_monitor_items();
			//save_sites();


		} catch (Exception e) {

			e.printStackTrace();

			item_label5x_0.setForeground(redx); 
			carbon[5][active_info_xx][what_item] = "no";

			cb_active.setSelectedIndex(0); 
			item_label5x_0.setText("Error!");

		}//*****************



	}//connectx()*********************************************************************************************







	public void read_stats(){//********************************************************************************


		System.out.println(carbon[1][1][what_item] + "/dbx_import_stats.php");

		System.out.println(carbon[5][user_info_xx][what_item]);
		System.out.println(carbon[5][pass_info_xx][what_item]);


		String xcx0 = "-1";
		String xcx1 = "-1";
		String xcx2 = "-1";
		String xcx3 = "-1";
		int ix0 = 0;


		// Construct data
		try {


    		String data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(carbon[5][user_info_xx][Integer.parseInt(carbon[1][6][what_item])], "UTF-8");
    		data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(carbon[5][pass_info_xx][Integer.parseInt(carbon[1][6][what_item])], "UTF-8");


    		// Send data
    		URL url = new URL(carbon[1][1][what_item] + "/dbx_export_stats.php");
    		URLConnection conn = url.openConnection();
    		conn.setDoOutput(true);
    		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    		wr.write(data);
    		wr.flush();

    		// Get the response
    		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;
    		while ((line = rd.readLine()) != null) {

        		xcx0 = line;

    		}
    		wr.close();
    		rd.close();
    		//conn.close();

		} catch (Exception e) {infox1.setText("Connection Failed." + carbon[1][1][what_item] + "/dbx_export_stats.php");}//*****************



		System.out.println("Get html " + xcx0);

		ix0 = xcx0.indexOf("||");
		if(ix0 > -1){xcx1 = xcx0.substring(0, ix0);}
		carbon[db_number][2][what_item] = xcx1;
		if(xcx0.length() > 2){xcx0 = xcx0.substring(ix0 + 2, xcx0.length());}
		else{infox1.setText("HTML falure. String is = -1. Section 1");}
		System.out.println(xcx1);


		ix0 = xcx0.indexOf("||");
		if(ix0 > -1){xcx2 = xcx0.substring(0, ix0);}
		carbon[db_number][3][what_item] = xcx2;
		if(xcx0.length() > 2){xcx0 = xcx0.substring(ix0 + 2, xcx0.length());}
		else{infox1.setText("HTML falure. String is = -1. Section 2");}
		System.out.println(xcx2);


		ix0 = xcx0.indexOf("||");
		if(ix0 > -1){xcx3 = xcx0.substring(0, ix0);}
		carbon[db_number][4][what_item] = xcx3;
		System.out.println(xcx3);


		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		carbon[db_number][5][what_item] = sdf.format(cal.getTime());
 

		view_0m2.setText(carbon[db_number][3][what_item]);
		view_0m3.setText(carbon[db_number][4][what_item]);

		//display_item();


	}//connectx()*********************************************************************************************









	public void read_stats_silent(){//********************************************************************************


		System.out.println(carbon[1][1][what_item] + "/dbx_import_stats.php");

		System.out.println(carbon[5][user_info_xx][what_item]);
		System.out.println(carbon[5][pass_info_xx][what_item]);


		String cx0 = "-1";
		String cx1 = "-1";
		String cx2 = "-1";
		String cx3 = "-1";
		int ix0 = 0;



		// Construct data
		try {


    		String data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(carbon[5][user_info_xx][Integer.parseInt(carbon[1][6][what_item])], "UTF-8");
    		data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(carbon[5][pass_info_xx][Integer.parseInt(carbon[1][6][what_item])], "UTF-8");


    		// Send data
    		URL url = new URL(carbon[1][1][what_item] + "/dbx_export_stats.php");
    		URLConnection conn = url.openConnection();
    		conn.setDoOutput(true);
    		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
   			wr.write(data);
    		wr.flush();

    		// Get the response
    		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;
    		while ((line = rd.readLine()) != null) {
        		cx0 = line;
    		}
    		wr.close();
    		rd.close();
    		//conn.close();

		}catch(Exception e){System.out.println("Connection Failed." + carbon[1][1][what_item] + "/dbx_import_stats.php");}//*****************



		System.out.println("Get html " + cx0);

		ix0 = cx0.indexOf("||");
		if (ix0 > -1) {cx1 = cx0.substring(0, ix0);}
		carbon[db_number][2][what_item] = cx1;
		if (cx0.length() > 2) {cx0 = cx0.substring(ix0 + 2, cx0.length());}
		else{infox1.setText("HTML falure. String is = -1. Section 1");}
		System.out.println(cx1);


		ix0 = cx0.indexOf("||");
		if (ix0 > -1) {cx2 = cx0.substring(0, ix0);}
		carbon[db_number][3][what_item] = cx2;
		if (cx0.length() > 2) {cx0 = cx0.substring(ix0 + 2, cx0.length());}
		else{infox1.setText("HTML falure. String is = -1. Section 2");}
		System.out.println(cx2);


		ix0 = cx0.indexOf("||");
		if (ix0 > -1) {cx3 = cx0.substring(0, ix0);}
		carbon[db_number][4][what_item] = cx3;
		System.out.println(cx3);


		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		carbon[db_number][5][what_item] = sdf.format(cal.getTime());


		view_0m2.setText(carbon[db_number][3][what_item]);
		view_0m3.setText(carbon[db_number][4][what_item]);

		//display_item();


	}//connectx()*********************************************************************************************













	public void delete_db_listings() {


		String xcx0 = "-1";
		// Construct data

		try {


    		String data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(carbon[5][user_info_xx][Integer.parseInt(carbon[1][6][what_item])], "UTF-8");
    		data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(carbon[5][pass_info_xx][Integer.parseInt(carbon[1][6][what_item])], "UTF-8");


    		// Send data
    		System.out.println(carbon[1][1][what_item] + "/dbx_delete_db_listings.php");
    		URL url = new URL(carbon[1][1][what_item] + "/dbx_delete_db_listings.php");
    		URLConnection conn = url.openConnection();
    		conn.setDoOutput(true);
    		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    		wr.write(data);
    		wr.flush();

    		// Get the response
    		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;
    		xcx0 = "";
    		while ((line = rd.readLine()) != null){

        		xcx0 = xcx0 + line;
				System.out.println(xcx0);
				infox1.setText(xcx0);

    		}//************************************
    		wr.close();
    		rd.close();
    		//conn.close();

		}catch(Exception e){

			infox1.setText("URL falure delete.");

		}//*****************



	}//delete******************









	public void delete_db_item() {

		System.out.println(carbon[0][0].length);

		for (int xloop = 0; xloop < carbon[0][0].length; xloop++) {//************************************************************************

			if (selected_int[xloop] == 1) {//**************************************************************************************************


				System.out.println("Delete message DB");
				String xcx0 = "-1";
				// Construct data

				System.out.println(carbon[5][urlx_info_xx][current_submit_item_a] + "/dbx_delete_item.php");

				try {


	    			String data = URLEncoder.encode("user", "UTF-8")     + "=" + URLEncoder.encode(carbon[5][user_info_xx][current_submit_item_a], "UTF-8");
	    			data += "&" + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(carbon[5][pass_info_xx][current_submit_item_a], "UTF-8");
	    			data += "&" + URLEncoder.encode("item_id", "UTF-8") +  "=" + URLEncoder.encode(carbon[0][item_id_xx][xloop], "UTF-8");

					System.out.println(xcx0);

	   				// Send data
	    			URL url = new URL(carbon[5][urlx_info_xx][current_submit_item_a] + "/dbx_delete_item.php");
	    			URLConnection conn = url.openConnection();
	    			conn.setDoOutput(true);
	    			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	    			wr.write(data);
	    			wr.flush();

	    			// Get the response
	    			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    			String line;
	    			xcx0 = "";
	    			while ((line = rd.readLine()) != null){

	        			xcx0 = xcx0 + line;
						infox1.setText(xcx0);
						System.out.println(xcx0);	

	    			}//************************************
	    			wr.close();
	    			rd.close();
	    			//conn.close();

	    			infox1.setText(Integer.toString(xloop) + " of " + Integer.toString(carbon[0][0].length) + " " + xcx0);



				} catch(Exception e) {

					infox1.setText("URL falure delete item.");

				}//*****************



			}//if******************************************************************************************************************************

		}//for*****************************************************************************************************************************

	}//delete******************










	public void test_if_shipped(int ix10) {


		String cx0 = "0";
		String cx9 = "0";

		//Construct data
		try {


    		String data = URLEncoder.encode("tracking_id", "UTF-8") + "=" + URLEncoder.encode(tracking_test_id, "UTF-8");

    		infox1.setText(Integer.toString(ix10) + " " + carbon[4][0][56].substring(0, carbon[4][0][56].lastIndexOf("/")) + "/shipped_postback1.php");

    		// Send data
    		URL url = new URL(carbon[4][0][56].substring(0, carbon[4][0][56].lastIndexOf("/")) + "/shipped_postback1.php");
    		URLConnection conn = url.openConnection();
    		conn.setDoOutput(true);
    		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    		wr.write(data);
    		wr.flush();

    		// Get the response
    		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;
    		while ((line = rd.readLine()) != null){

				cx9 = line;
				infox1.setText("Postback: " + cx0);

    		}//************************************
    		wr.close();
    		rd.close();
    		//conn.close();

		} catch (Exception e) {infox1.setText("URL falure test shipping.");}

	}//test_if_shipped()******************





	public void get_tracking_shipped() {


		String cx0 = "0";
		String cx9 = "0";

		// Construct data
		try {


	   		String data = URLEncoder.encode("tracking_id", "UTF-8") + "=" + URLEncoder.encode(tracking_test_id, "UTF-8");

	    	infox1.setText(carbon[4][0][56].substring(0, carbon[4][0][56].lastIndexOf("/")) + "/shipped_postback2.php");

	    	// Send data
	    	URL url = new URL(carbon[4][0][56].substring(0, carbon[4][0][56].lastIndexOf("/")) + "/shipped_postback2.php");
	    	URLConnection conn = url.openConnection();
	   		conn.setDoOutput(true);
	    	OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	    	wr.write(data);
	    	wr.flush();

	    	// Get the response
	    	BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    	String line;
	    	int line2 = 0;
	    	while ((line = rd.readLine()) != null){

	        	if (line2 == 0) {cx9 = line; System.out.println("1 " + cx9);}
				if (line2 == 1) {cx9 = line; System.out.println("2 " + cx9);}

				infox1.setText("Postback: " + cx0);
				line2++;

	    	}//************************************

	   		wr.close();
	    	rd.close();
	    	//conn.close();

		} catch (Exception e) {infox1.setText("URL falure tracking ship.");}


	}//get_tracking_shipped()******************











	public String test_for_quantity() {


		String cx0 = "0";
		int ix1 = 0;

		// Construct data
		try {


    		String data = URLEncoder.encode("item_id", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[0][part_number_xx][ix1], "UTF-8");


    		// Send data
    		URL url = new URL(carbon[4][0][56].substring(0, carbon[4][0][56].lastIndexOf("/shipping_system")) + "/inventory_system/quantity_postback.php");
    		URLConnection conn = url.openConnection();
    		conn.setDoOutput(true);
    		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    		wr.write(data);
    		wr.flush();

    		// Get the response
    		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;
    		while ((line = rd.readLine()) != null){

        		cx0 = line;
				System.out.println(cx0);
				infox1.setText("Postback: " + cx0);

   			}//************************************
    		wr.close();
    		rd.close();
    		//conn.close();

		} catch (Exception e) {infox1.setText("URL falure quantity test.");}


		return cx0;

	}//test_for_quantity******************









	public String custom_update() {


		String cx0 = "null";
		int ix1 = 0;

		// Construct data
		try {


    		String data = URLEncoder.encode("item_id", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[0][item_id_xx][ix1], "UTF-8");
    		data += "&" + URLEncoder.encode("field", "UTF-8") + "=" + URLEncoder.encode(db_string[custom_select], "UTF-8");

    		System.out.println(nm.carbon[0][item_id_xx][ix1]); 
    		System.out.println(db_string[custom_select]);
    		System.out.println(nm.carbon[5][urlx_info_xx][current_submit_item_a] + "/dbx_custom_postback.php");
    		//infox1.setText(nm.carbon[5][urlx_info_xx][current_submit_item_a] + "/dbx_custom_postback.php");

    		//send data
    		URL url = new URL(nm.carbon[5][urlx_info_xx][current_submit_item_a] + "/dbx_custom_postback.php");
    		URLConnection conn = url.openConnection();
    		conn.setDoOutput(true);
    		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    		wr.write(data);
    		wr.flush();

    		// Get the response
    		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;
    		while ((line = rd.readLine()) != null){

        		cx0 = line;
				System.out.println(">>> " + cx0);
				infox1.setText("Postback: " + cx0);

    		}//************************************
    		wr.close();
   			rd.close();
    		//conn.close();

		} catch (Exception e) {infox1.setText("URL falure update.");}


		return cx0;

	}//custom_update******************











	public void test_for_internet() {

		System.out.println("Testing");

		// This is just to test that we are connected to the internet an that ebay API is working. 
		// It will return an error that we don't have a token that's fine. This is not connected to the user's account.

		// Construct data
		try {


			String cxtest = "";

    		// Send data
   			URL url = new URL(ebay_api_test_url);

			HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();

			System.out.println("Error Code: " + urlConnection.getResponseCode());

    		// Get the response
   	 		BufferedReader rd = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
    		String line;
    		while ((line = rd.readLine()) != null){

       			cxtest = line;
				System.out.println(cxtest);

				if(cxtest.length() > 0){

					internet_access = 1; 
					program_message_button.setText("Program Internet Access"); 
					program_message_button.setIcon(imx_message_green);

				}
				else{

					internet_access = 0; 
					program_message_button.setText("Program Internet Access"); 
					program_message_button.setIcon(imx_message_red);

				}

   	 		}//************************************
   			//wr.close();
    		rd.close();
    		//conn.close();

		} catch(Exception e) {

			internet_access = 0; 
			//e.printStackTrace();
			infox1.setText("URL falure INTERNET TEST."); 
			program_message_button.setText("Program Internet Access"); 
			program_message_button.setIcon(imx_message_red);

		}//*******************


		test_for_shipping_system();

	}//updates******************






	public void test_for_shipping_system(){

		System.out.println("Testing");
		String cx000 = "0";

		// Construct data
		try {

    		//String data = URLEncoder.encode("item_id", "UTF-8") + "=" + URLEncoder.encode(nm.carbon[0][part_number_xx][ix1], "UTF-8");
    		// Send data
   			URL url = new URL(shipping_api_test_url);
    		URLConnection conn = url.openConnection();
   			conn.setDoOutput(true);
    		OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
    		//wr.write(data);
    		wr.flush();

    		// Get the response
    		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    		String line;
    		while ((line = rd.readLine()) != null) {

        		cx000 = line;
				System.out.println(cx000);
				infox1.setText("SQL Test: " + cx000);
				if (!cx000.equals("0")) {

					shipping_api_access = 1; 
					program_version_button.setText("Shipping System API"); 
					program_version_button.setIcon(imx_message_green); 
					program_version_button.setToolTipText(cx000);

				}
				else {

					shipping_api_access = 0; 
					program_version_button.setText("Shipping System API"); 
					program_version_button.setIcon(imx_message_red);

				}


   			}//************************************

   			wr.close();
    		rd.close();
    		//conn.close();

		} catch (Exception e) {

			shipping_api_access = 0; 
			System.out.println("URL falure."); 
			infox1.setText("URL falure Shipping System."); 
			program_version_button.setText("Shipping System API"); 
			program_version_button.setIcon(imx_message_red);

		}//******************

	}//updates******************












//online***********************************************************************************************************************************************************************************
//online***********************************************************************************************************************************************************************************


//settings**************************************************************************
//settings**************************************************************************



	public void set_monitor_items() {//***********



		int ix0 = 0;

		System.out.println("SET MONITOR ITEMS");

		for (int xloop = 0; xloop < carbon[5][active_info_xx].length; xloop++) {//****

			try {

				if (carbon[5][active_info_xx][xloop].equals("yes")) {ix0++; System.out.println(carbon[5][name_info_xx][xloop]);}

			} catch (Exception e) {}

		}//for***********************************************************

		System.out.println("ix0: " + ix0);



		System.out.println("ADD MONITOR IF");

			carbon[1] = new String[db_cc_number][ix0];

			int ix3 = 0;
			int ix4 = 0;
			int ix5 = 0;


			for (int xloop0 = 0; xloop0 < carbon[5][name_info_xx].length; xloop0++) {//****************************
	
				ix3 = 0;

				for (int xloop1 = 0; xloop1 < db_cc_number; xloop1++) {//******

	 				if (carbon[5][active_info_xx][xloop0].equals("yes")) {//*****************************
		    

						Calendar cal = Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

	 	     			     if (xloop1 == 0) {carbon[1][xloop1][ix5] = new String(carbon[5][xloop1][xloop0]);}
	 					else if (xloop1 == 1) {carbon[1][xloop1][ix5] = new String(carbon[5][xloop1][xloop0]);}
	 					else if (xloop1 == 2) {carbon[1][xloop1][ix5] = new String("0");}
	 					else if (xloop1 == 3) {carbon[1][xloop1][ix5] = new String("0");}
	 					else if (xloop1 == 4) {carbon[1][xloop1][ix5] = new String("0");}
	 					else if (xloop1 == 5) {carbon[1][xloop1][ix5] = new String(sdf.format(cal.getTime()));}
	 					else if (xloop1 == 6) {

	 						carbon[1][xloop1][ix5] = new String(Integer.toString(xloop0)); 
	 						ix5++; 

	 						if(ix5 > ix0){break;}

	 					}
						else{}

						//System.out.println("nn " + ix5 + " " + carbon[1][xloop1][xloop0]);

	 				}//if*****************************************************************

					ix3++;

				}//for*******************************************************

				ix4++;
				//System.out.println("ix3 " + ix3);
				//System.out.println("ix4 " + ix4);

			}//for************************************************************************************




		for (int xloop0 = 0; xloop0 < carbon[1][0].length; xloop0++) {//****

			for (int xloop1 = 7; xloop1 < db_cc_number; xloop1++) {//****

				carbon[1][xloop1][xloop0] = new String("•");

			}//for*******************************************************

		}//for**************************************************************


		titles_xx();
		//display_item();
		

	}//SET MONITOR******************************************






	public void set_monitor_items2(){//***********

		try {

			//jdb_driver.s.execute("DELETE FROM monitor WHERE address_1='*'");

		} catch (Exception e) {e.printStackTrace();}


		System.out.println("SET MONITOR ITEMS 2.1");

		jdb_loader_monitor loadm = new jdb_loader_monitor();

		System.out.println("SET MONITOR ITEMS 2.2");


		for (int xloop0 = 0; xloop0 < carbon[1][0].length; xloop0++) {//****

			for (int xloop1 = 7; xloop1 < db_cc_number; xloop1++) {//****

				//carbon[1][xloop1][xloop0] = new String("•");

			}//for*******************************************************

		}//for**************************************************************


		titles_xx();

		//display_item(); removed
		

	}//SET MONITOR******************************************







	public void set_submit_monitor_items() {

		//Full reset.

		set_monitor_items();

		set_submit_items();

	}//*************************************



	public void set_submit_items() {


		current_submit_item_x = Integer.parseInt(carbon[4][0][2]);
		int ix0 = current_submit_item_x;

		System.out.println("dd bba3 " + current_submit_item_a);
		System.out.println("dd bbx3 " + current_submit_item_x);

		cb_active_site.removeAllItems();

		System.out.println("dd bba3x " + current_submit_item_a);
		System.out.println("dd bbx3x " + current_submit_item_x);
 
		cb_active_site.addItem("All Sites(" + (carbon[1][0].length) + ")");

		System.out.println("dd bba4 " + current_submit_item_a);
		System.out.println("dd bbx4 " + current_submit_item_x);

		for (int xloop = 0; xloop < carbon[5][active_info_xx].length; xloop++) {//****

			System.out.println(carbon[5][name_info_xx][xloop] + " " + carbon[5][active_info_xx].length);

			if (carbon[5][active_info_xx][xloop].equals("yes")) {

				cb_active_site.addItem(carbon[5][name_info_xx][xloop]);

			}//*************************************

		}//for***********************************************************


		current_submit_item_x = ix0;

		if (current_submit_item_x > carbon[5][active_info_xx].length) {

			current_submit_item_x = 0; 
			infox0.setText("current_submit_item_x = 0"); 
			System.out.println("xx");

		}//***********************************************
		if (current_submit_item_x < cb_active_site.getItemCount()) {

			cb_active_site.setSelectedIndex(current_submit_item_x);

		}//*********************************************************

		titles_xx();


		String[][] connections_display_list = build_connections_display_list();
		dxengine5.display_item(connections_display_list,1);


	}///****************************







	public void reset_fields() {

		// We are resetting the connection settings items so that if something was switched to a different account there are not errors.
		// Start at 16 because below 16 are the connection settings. 

		System.out.println("RESET FIELDS *");

		for (int xloop0 = 16; xloop0 < db_cx_number; xloop0++) {//*********

			carbon[5][xloop0][what_item] = new String("0");

		}//for*************************************************************

	}//************************







	public void save_sites(boolean connect_save_flag) {


		int test_p1 = 0;

		for (int loop = 0; loop < carbon[5][name_info_xx].length; loop++) {//**********

			if (carbon[5][name_info_xx][loop].equals(tf_namex.getText()) && loop != what_item) {

				test_p1++;

			}//**********************************************************************

		}//****************************************************************

		if (test_p1 == 0) {

			save_sites2(connect_save_flag);

		}//****************
		else {

			JOptionPane.showMessageDialog(null,"Names must be unique!");

		}//****


	}//**********************





	public void save_sites2(boolean connect_save_flag) {

		response = JOptionPane.showConfirmDialog(null, "If there is any info already saved with this site, it will be overwritten. Continue?");
		System.out.println("response " + response);
		if(response == 0) {//********************************************************************************************************************


			String fix_urlx = tf_urlx.getText();
			fix_urlx = fix_urlx.substring(fix_urlx.length() -1, fix_urlx.length());

			if (fix_urlx.equals("/")) {

				fix_urlx = tf_urlx.getText();
				fix_urlx = fix_urlx.substring(0, fix_urlx.length() -1);
				tf_urlx.setText(fix_urlx);

			}//************************


			item_label5x_0.setText("");


			carbon[5][name_info_xx][what_item] = tf_namex.getText();
			carbon[5][urlx_info_xx][what_item] = tf_urlx.getText();
			carbon[5][user_info_xx][what_item] = tf_userx.getText();
			carbon[5][pass_info_xx][what_item] = tf_passx.getText();

			if (carbon[5][type_info_xx][what_item].equals("Amazon")) {

				carbon[5][key1_info_xx][what_item] = tf_key1x.getText();
				carbon[5][key2_info_xx][what_item] = tf_key2x.getText();

			}//********************************************

			if (carbon[5][type_info_xx][what_item].equals("Etsy")) {

				carbon[5][key1_info_xx][what_item] = tf_key1x.getText();
				carbon[5][key2_info_xx][what_item] = tf_key2x.getText();

			}//********************************************


     	         if (combostart2 == 0) {carbon[5][type_info_xx][what_item] = "Amazon";}
			else if (combostart2 == 1) {carbon[5][type_info_xx][what_item] = "Custom";}
			else if (combostart2 == 2) {carbon[5][type_info_xx][what_item] = "eBay";}
			else if (combostart2 == 3) {carbon[5][type_info_xx][what_item] = "Etsy";}
			else if (combostart2 == 4) {carbon[5][type_info_xx][what_item] = "Magento";}
			else if (combostart2 == 5) {carbon[5][type_info_xx][what_item] = "MySQL";}
			else if (combostart2 == 6) {carbon[5][type_info_xx][what_item] = "PayPal";}

     	         if (combostart1 == 0) {carbon[5][active_info_xx][what_item] = "no";}
			else if (combostart1 == 1) {carbon[5][active_info_xx][what_item] = "yes";}


			//Build custom ID.

			//String custom_id = Long.toString(System.currentTimeMillis());

			reset_fields();

			//display_item();

			String[][] edit_new = new String[carbon[5].length][1];


			for (int loop = 0; loop < carbon[5].length; loop++) {//************

				edit_new[loop][0] = carbon[5][loop][what_item];

			}//****************************************************************


			jdb_edit_connection editc = new jdb_edit_connection(edit_new, Integer.toString(what_item));

			if (connect_save_flag) {connectx();}

			set_submit_monitor_items();


		}//**************************************************************************************************************************************

	}//save






	public int display_save_item_test0() {
 
		int item_save_test = 0;

		try {

			System.out.println("what_item_old " + what_item_old);
			System.out.println("length        " + carbon[0][0].length);
			System.out.println("1             " + carbon[0][title_xx][what_item_old]);

		} catch (Exception e) {System.out.println("ERROR 0709873");}

		try {

			if (!carbon[0][title_xx][what_item_old].equals(tf_title.getText()))          {item_save_test++;}
			if (!carbon[0][part_number_xx][what_item_old].equals(tf_part.getText()))     {item_save_test++;}
			if (!carbon[0][item_cost_xx][what_item_old].equals(tf_cost.getText()))       {item_save_test++;}
			if (!carbon[0][item_price_xx][what_item_old].equals(tf_price.getText()))     {item_save_test++;}
			if (!carbon[0][item_weight_xx][what_item_old].equals(tf_weight.getText()))   {item_save_test++;}
			if (!carbon[0][package_d_xx][what_item_old].equals(tf_d.getText()))          {item_save_test++;}
			if (!carbon[0][package_l_xx][what_item_old].equals(tf_l.getText()))          {item_save_test++;}
			if (!carbon[0][package_w_xx][what_item_old].equals(tf_w.getText()))          {item_save_test++;}
			if (!carbon[0][total_on_hand_xx][what_item_old].equals(tf_onhand.getText())) {item_save_test++;}
			if (!carbon[0][item_weight_xx][what_item_old].equals(tf_weight.getText()))   {item_save_test++;}
			if (!carbon[0][picture_1_xx][what_item_old].equals(tf_picture_1.getText()))  {item_save_test++;}
			if (!carbon[0][custom_1_xx][what_item_old].equals(tf_custom_1.getText()))    {item_save_test++;}
			if (!carbon[0][custom_2_xx][what_item_old].equals(tf_custom_2.getText()))    {item_save_test++;}
			if (!carbon[0][custom_3_xx][what_item_old].equals(tf_custom_3.getText()))    {item_save_test++;}

		} catch (Exception e) {

			System.out.println("ERROR 0709873X"); 
			infox1.setText("Items contain errors! File>EXIT or your database will be corrupted.");

		}//********************


		System.out.println("item_save_test " + item_save_test);


		return item_save_test;

	}//test******************************





	public void display_save_item0() {

		System.out.println("WHAT ITEM ***************************** " + what_item);

		try {


			int item_save_test = display_save_item_test0();

			if (save_item_control.equals(carbon[0][item_id_xx][what_item_old])) {//***************

				carbon[0][title_xx][what_item_old] = tf_title.getText();
				carbon[0][part_number_xx][what_item_old] = tf_part.getText();
				carbon[0][item_cost_xx][what_item_old] = tf_cost.getText().replace(" ", "");
				carbon[0][item_price_xx][what_item_old] = tf_price.getText().replace(" ", "");
				carbon[0][item_weight_xx][what_item_old] = tf_weight.getText();
				carbon[0][package_d_xx][what_item_old] = tf_d.getText();
				carbon[0][package_l_xx][what_item_old] = tf_l.getText();
				carbon[0][package_w_xx][what_item_old] = tf_w.getText();
				carbon[0][total_on_hand_xx][what_item_old] = tf_onhand.getText();
				carbon[0][item_weight_xx][what_item_old] = tf_weight.getText();
				carbon[0][picture_1_xx][what_item_old] = tf_picture_1.getText();
				carbon[0][custom_1_xx][what_item_old] = tf_custom_1.getText();
				carbon[0][custom_2_xx][what_item_old] = tf_custom_2.getText();
				carbon[0][custom_3_xx][what_item_old] = tf_custom_3.getText();

				if (carbon[0][title_xx][what_item_old].length() > 40) {

					carbon[0][title_url_xx][what_item_old] = carbon[0][title_xx][what_item_old].substring(0,40).replace(" ", "_").replace("'", "").replace("\"", "") + "_" + carbon[0][item_id_xx][what_item_old];

				}//****************************************************
				else {

					carbon[0][title_url_xx][what_item_old] = carbon[0][title_xx][what_item_old].replace(" ", "_").replace("'", "").replace("\"", "") + "_" + carbon[0][item_id_xx][what_item_old];

				}//***


				if (item_save_test > 0) {

					String[][] save_itemd = new String[carbon[0].length][1];

					//save info
					for (int loop = 0; loop < carbon[0].length; loop++){//*************

						save_itemd[loop][0] = carbon[0][loop][what_item_old];

					}//****************************************************************

					jdb_edit_item edit = new jdb_edit_item(save_itemd);

					if (db_number == 0) {

						sortx_engine();

						int[] warningsx = test_warnings();
						int[] errorsx = test_errors();
						show_errors();
						dxengine0.setWarningList(warningsx);
						dxengine0.setErrorList(errorsx);
						String[][][] export_display_list = build_export_display_list();
						dxengine0.display_item(export_display_list[0], what_item_display);

					}//******************

					infox1.setText("Item " + Integer.toString(what_item_old + 1) + " saved.");


				}//**********


			}//else*****************************************************************************
			else {System.out.println("item ids don't match, can't save. = item");}

			//what_item_old = what_item;

		} catch (Exception e) {System.out.println("Item save error!");}



		try {

			tf_title.setText(carbon[0][title_xx][what_item]);
			tf_part.setText(carbon[0][part_number_xx][what_item]);
			tf_d.setText(carbon[0][package_d_xx][what_item]);
			tf_l.setText(carbon[0][package_l_xx][what_item]);
			tf_w.setText(carbon[0][package_w_xx][what_item]);
			tf_cost.setText(carbon[0][item_cost_xx][what_item]);
			tf_price.setText(carbon[0][item_price_xx][what_item]);
			tf_onhand.setText(carbon[0][total_on_hand_xx][what_item]);
			tf_weight.setText(carbon[0][item_weight_xx][what_item]);
			tf_picture_1.setText(carbon[0][picture_1_xx][what_item]);
			tf_custom_1.setText(carbon[0][custom_1_xx][what_item]);
			tf_custom_2.setText(carbon[0][custom_2_xx][what_item]);
			tf_custom_3.setText(carbon[0][custom_3_xx][what_item]);
			save_item_control = carbon[0][item_id_xx][what_item];

		} catch (Exception e) {System.out.println("Set info failed.");}

		//throw new ArithmeticException("/ by zero");

		show_error_list();


	}//************************








	public void display_save_item1() {//sold prices


		try {


			view_hm0.setText("Remote Database");
			viewx_0m1.setText("Account:");
			viewx_0m2.setText("Name:");
			viewx_0m3.setText("Running:");
			viewx_0m4.setText("Sales:");
			viewx_0m5.setText("Days Active:");

			view_hm2.setText("Sales DB2");
			viewx_2m1.setText("Site Rank:");
			viewx_2m2.setText("Sales:");
			viewx_2m3.setText("Sales Count:");
			viewx_2m4.setText("Sales % of Total:");
			viewx_2m5.setText("Profit:");

			view_hm3.setText("Archive DB3");
			viewx_3m1.setText("Site Rank:");
			viewx_3m2.setText("Sales:");
			viewx_3m3.setText("Sales Count:");
			viewx_3m4.setText("Sales % of Total:");
			viewx_3m5.setText("Profit:");


			view_0m1.setText("n/a");
			view_0m2.setText("n/a");
			view_0m3.setText("n/a");
			view_0m4.setText("n/a");
			view_0m5.setText("n/a");

			view_2m1.setText("n/a");
			view_2m2.setText("n/a");
			view_2m3.setText("n/a");
			view_2m4.setText("n/a");
			view_2m5.setText("n/a");

			view_3m1.setText("n/a");
			view_3m2.setText("n/a");
			view_3m3.setText("n/a");
			view_3m4.setText("n/a");
			view_3m5.setText("n/a");		



			if (what_item <= items_value) {


				long daysx = (long) 0;

				try {

					daysx = System.currentTimeMillis() - Long.parseLong(carbon[1][start_time_mm][what_item]);

					System.out.println("daysx " + daysx);

					daysx = (daysx / 1000);//seconds
					System.out.println("daysx " + daysx);
					daysx = (daysx / 60);//mins
					System.out.println("daysx " + daysx);
					daysx = (daysx / 60);//hours
					System.out.println("daysx " + daysx);
					daysx = (daysx / 24);//days
					System.out.println("daysx " + daysx);

				} catch (Exception e) {}

				view_hm0.setText("Remote Database");
				view_0m1.setText(carbon[5][type_info_xx][ Integer.parseInt(carbon[1][6][what_item]) ]);
				view_0m2.setText(carbon[1][0][what_item]);
				view_0m3.setText(carbon[1][2][what_item]);
				view_0m4.setText(carbon[1][4][what_item]);
				view_0m5.setText(Long.toString(daysx));


				//stats_get_sales_count();

				view_hm2.setText("Sales DB2");
				view_2m1.setText("#" + carbon[1][sold_rank_mm][what_item]);
				view_2m2.setText(carbon[1][sold_sales_mm][what_item]);
				view_2m3.setText(carbon[1][sold_count_mm][what_item]);
				view_2m4.setText(carbon[1][sold_perc_mm][what_item] + "%");
				view_2m5.setText(carbon[1][sold_profit_mm][what_item]);


				//stats_get_sales_count2();

				view_hm3.setText("Archive DB3");
				view_3m1.setText("#" + carbon[1][archive_rank_mm][what_item]);
				view_3m2.setText(carbon[1][archive_sales_mm][what_item]);
				view_3m3.setText(carbon[1][archive_count_mm][what_item]);
				view_3m4.setText(carbon[1][archive_perc_mm][what_item] + "%");
				view_3m5.setText(carbon[1][archive_profit_mm][what_item]);


			}//if********************
			else {System.out.println("Error 898392");}


		} catch (Exception e) {infox1.setText("Display system failed.");}


	}//********************************************









	public int display_save_item_test2() {//sold prices

		int item2_test = 0;

		try {


			if (!carbon[2][item_price_xx][what_item_old].equals(sold_tf_sp.getText())) {item2_test++;}
			if (!carbon[2][item_cost_xx][what_item_old].equals(sold_tf_cp.getText())) {item2_test++;}
			if (!carbon[2][shipping_in_xx][what_item_old].equals(sold_tf_si.getText())) {item2_test++;}
			if (!carbon[2][shipping_out_xx][what_item_old].equals(sold_tf_so.getText())) {item2_test++;}
			if (!carbon[2][paypal_fees_xx][what_item_old].equals(sold_tf_fee.getText())) {item2_test++;}
			if (!carbon[2][sales_tax_xx][what_item_old].equals(sold_tf_tax.getText())) {item2_test++;}

			if (!carbon[2][tracking_number_xx][what_item_old].equals(sold_tracking.getText())) {item2_test++;}

			System.out.println("item2_test " + item2_test);


		} catch (Exception e) {infox1.setText("Save Sales Info Failed.");}

		return item2_test;

	}//test******************************




	public void display_save_item2() {//sold prices


		int item2_test = display_save_item_test2();


		if (item2_test == 0) {System.out.println("DO NOT SAVE SOLD DB");}
		else if (save_item_control.equals(carbon[2][sale_id_xx][what_item_old])) {

			carbon[2][item_price_xx][what_item_old] = sold_tf_sp.getText();
			carbon[2][item_cost_xx][what_item_old] = sold_tf_cp.getText();
			carbon[2][shipping_in_xx][what_item_old] = sold_tf_si.getText();
			carbon[2][shipping_out_xx][what_item_old] = sold_tf_so.getText();
			carbon[2][paypal_fees_xx][what_item_old] = sold_tf_fee.getText();
			carbon[2][sales_tax_xx][what_item_old] = sold_tf_tax.getText();

			carbon[2][tracking_number_xx][what_item_old] = sold_tracking.getText();

			//carbon[2][sale_status_xx][what_item_old] = sold_tracking.getText();



			if (item2_test > 0) {


				String[][] save_itemd = new String[carbon[2].length][1];

				//save info
				for (int loop = 0; loop < carbon[2].length; loop++){//*************

					save_itemd[loop][0] = carbon[2][loop][what_item_old];

				}//****************************************************************

				jdb_edit_sale edit = new jdb_edit_sale(save_itemd);
				infox1.setText("Item " + Integer.toString(what_item_old + 1) + " saved.");

			}//**********



			if (db_number == 0) {}//displayx


		}//**********************************************************************







		System.out.println("math");

		//test costs
		try {

			int ix0 = carbon[2][item_cost_xx][what_item].indexOf(".");

			if (ix0 > -1) {

				String cx0 = carbon[2][item_cost_xx][what_item].substring(ix0, carbon[2][item_cost_xx][what_item].length());

				if (cx0.length() == 2) {carbon[2][item_cost_xx][what_item] = carbon[2][item_cost_xx][what_item] + "0";}

			}//**********

		} catch (Exception e) {System.out.println("Cannot set costs");}
		//test costs


		//test prices
		try {
		
			int ix0 = carbon[2][item_price_xx][what_item].indexOf(".");

			if (ix0 > -1) {

				String cx0 = carbon[2][item_price_xx][what_item].substring(ix0, carbon[2][item_price_xx][what_item].length());

				if (cx0.length() == 2) {carbon[2][item_price_xx][what_item] = carbon[2][item_price_xx][what_item] + "0";}

			}//**********

		} catch (Exception e) {System.out.println("Cannot set price");}
		//test prices


		//test fees
		try {
	
			int ix0 = carbon[2][paypal_fees_xx][what_item].indexOf(".");
	
			if (ix0 > -1) {

				String cx0 = carbon[2][paypal_fees_xx][what_item].substring(ix0, carbon[2][paypal_fees_xx][what_item].length());

				if (cx0.length() == 1) {carbon[2][paypal_fees_xx][what_item] = carbon[2][paypal_fees_xx][what_item] + "00";}
				else if (cx0.length() == 2) {carbon[2][paypal_fees_xx][what_item] = carbon[2][paypal_fees_xx][what_item] + "0";}
				else if (cx0.length() == 4) {carbon[2][paypal_fees_xx][what_item] = carbon[2][paypal_fees_xx][what_item].substring(0, carbon[2][paypal_fees_xx][what_item].length() -1);}

			}//**********

		} catch (Exception e) {System.out.println("Cannot set fees");}
		//test fees


		//test tax
		try {
			
			int ix0 = carbon[2][sales_tax_xx][what_item].indexOf(".");
	
			if (ix0 > -1) {

				String cx0 = carbon[2][sales_tax_xx][what_item].substring(ix0, carbon[2][sales_tax_xx][what_item].length());

				if (cx0.length() == 1) {carbon[2][sales_tax_xx][what_item] = carbon[2][sales_tax_xx][what_item] + "00";}
				else if (cx0.length() == 2) {carbon[2][sales_tax_xx][what_item] = carbon[2][sales_tax_xx][what_item] + "0";}
				else if (cx0.length() == 4) {carbon[2][sales_tax_xx][what_item] = carbon[2][sales_tax_xx][what_item].substring(0, carbon[2][sales_tax_xx][what_item].length() -1);}

			}//**********

		} catch (Exception e) {System.out.println("Cannot set tax");}
		//test tax


		//test shipping
		try {

			int ix0 = carbon[2][shipping_in_xx][what_item].indexOf(".");

			if (ix0 > -1) {

				String cx0 = carbon[2][shipping_in_xx][what_item].substring(ix0, carbon[2][shipping_in_xx][what_item].length());

				if (cx0.length() == 1) {carbon[2][shipping_in_xx][what_item] = carbon[2][shipping_in_xx][what_item] + "00";}
				else if (cx0.length() == 2) {carbon[2][shipping_in_xx][what_item] = carbon[2][shipping_in_xx][what_item] + "0";}
				else if (cx0.length() == 4) {carbon[2][shipping_in_xx][what_item] = carbon[2][shipping_in_xx][what_item].substring(0, carbon[2][shipping_in_xx][what_item].length() -1);}

			}//**********

		}catch(Exception e){System.out.println("Cannot set shipping");}
		//test shipping




		try {

			//set other info
			sold_tf_username.setText(carbon[2][buyer_id_xx][what_item]);
			sold_tf_email.setText(carbon[2][buyers_email_xx][what_item]);
			sold_tf_saleid.setText(carbon[2][sale_id_xx][what_item]);

			//set cost fields. 
			sold_tf_cp.setText(carbon[2][item_cost_xx][what_item]);
			sold_tf_sp.setText(carbon[2][item_price_xx][what_item]);
			sold_tf_si.setText(carbon[2][shipping_in_xx][what_item]);
			sold_tf_so.setText(carbon[2][shipping_out_xx][what_item]);
			sold_tf_tax.setText(carbon[2][sales_tax_xx][what_item]);
			sold_tf_fee.setText(carbon[2][paypal_fees_xx][what_item]);
			save_item_control = carbon[2][sale_id_xx][what_item];

		} catch (Exception e) {}





		try {//*******************************************


			System.out.println("math");

			int ix0 = 0;

			Float fx0 = (Float.parseFloat(carbon[db_number][item_price_xx][what_item]) - Float.parseFloat(carbon[db_number][item_cost_xx][what_item]));
			fx0 = fx0 - (Float.parseFloat(carbon[db_number][shipping_out_xx][what_item]) - Float.parseFloat(carbon[db_number][shipping_in_xx][what_item]));
			fx0 = fx0 - (Float.parseFloat(carbon[db_number][paypal_fees_xx][what_item]));

			fx0 = (fx0 * 100);
			ix0 = Math.round(fx0);
			fx0 = (float) ix0;
			fx0 = (fx0 / 100);


			String cx0 = Float.toString(fx0);
			ix0 = cx0.indexOf(".");
		
			if (ix0 > -1) {

				cx0 = cx0 + "00";
				cx0 = cx0.substring(0, ix0 + 3);

			}//**********

			sold_profit.setText("Total Profit: " + cx0 + " " + carbon[2][currency_xx][what_item]);
			if (cx0.indexOf("-") > -1) {carbon[2][sale_status_xx][what_item] = "Error";}

		} catch (Exception e) {sold_profit.setText("Addition errors");};



		try {


			Float fx1 = (Float.parseFloat(carbon[db_number][item_cost_xx][what_item]) + Float.parseFloat(carbon[db_number][shipping_out_xx][what_item]));
			fx1 = fx1 + (Float.parseFloat(carbon[db_number][sales_tax_xx][what_item]) + Float.parseFloat(carbon[db_number][paypal_fees_xx][what_item]));

			fx1 = (fx1 * 100);
			int ix1 = Math.round(fx1);
			fx1 = (float) ix1;
			fx1 = (fx1 / 100);


			String cx0 = Float.toString(fx1);
			int ix0 = cx0.indexOf(".");
			
			if (ix0 > -1) {

				cx0 = cx0 + "00";
				cx0 = cx0.substring(0, ix0 + 3);

			}//**********

			sold_costs.setText("Costs: (" + cx0 + ") " + carbon[2][currency_xx][what_item]);

		} catch (Exception e) {sold_costs.setText("Addition errors");};



		try {

			//set cost fields. end.
			System.out.println("fields");
			sold_address.setText(carbon[db_number][buyers_first_name_xx][what_item] + " " + carbon[db_number][buyers_last_name_xx][what_item] + "\n" + carbon[db_number][address_1_xx][what_item] + "\n" + carbon[db_number][address_2_xx][what_item] + ", " + carbon[db_number][address_3_xx][what_item] + " " + carbon[db_number][address_4_xx][what_item] + "\n" + carbon[db_number][address_5_xx][what_item] + "\n" + carbon[db_number][address_6_xx][what_item]);
			sold_tracking.setText(carbon[db_number][tracking_number_xx][what_item]);
			sale_status_b.setText(carbon[2][sale_status_xx][what_item].replace("[","").replace("]",""));              
                                                                   
		} catch (Exception e) {}



		//sales data
		if (what_item == 0 && total_items_selected == 1) {

			stats_get_sales_datax(); 
			infox1.setText("SALE STATUS: (" + view_data_i_newsales + " New) (" + view_data_i_ready + " Ready) (" + view_data_i_shipped + " Shipped) (" + view_data_i_refunded + " Refunded) (" + view_data_i_errors + " Errors) (" + view_data_i_success + " Success)");

		}//*********************************************

        //carbon[2][date_sold_xx][0] = "*[[" + db_string[date_sold_xx] + "]]";



	}//************************






	public void display_save_item3() {



		try {

			for (int xloop = 0; xloop < carbon[0][0].length; xloop++){//******

				if (carbon[0][part_number_xx][xloop].equals(carbon[3][part_number_xx][what_item]) && carbon[3][item_cost_xx][what_item].equals("0.00")) {

					carbon[3][item_cost_xx][what_item] = Float.toString( Float.parseFloat(carbon[0][item_cost_xx][xloop]) * Integer.parseInt(carbon[3][quantity_sold_xx][what_item]) );

				}//*************************************************************************************************************************************

			}//**************************************************************

		} catch (Exception e) {infox1.setText("Archive display error! 898923");}


		try {

			//test costs
			int ix0 = carbon[3][item_cost_xx][what_item].indexOf(".");

			if (ix0 > -1) {

				String cx0 = carbon[3][item_cost_xx][what_item].substring(ix0, carbon[3][item_cost_xx][what_item].length());

				if (cx0.length() == 1) {carbon[3][item_cost_xx][what_item] = carbon[3][item_cost_xx][what_item] + "00";}
				else if (cx0.length() == 2) {carbon[3][item_cost_xx][what_item] = carbon[3][item_cost_xx][what_item] + "0";}
				else if (cx0.length() == 4) {carbon[3][item_cost_xx][what_item] = carbon[3][item_cost_xx][what_item].substring(0, carbon[3][item_cost_xx][what_item].length() -1);}
				else if (cx0.length() == 5) {carbon[3][item_cost_xx][what_item] = carbon[3][item_cost_xx][what_item].substring(0, carbon[3][item_cost_xx][what_item].length() -2);}

			}//**********

		} catch (Exception e) {infox1.setText("Archive display error! cost");}


		try {

			//test prices
			int ix0 = carbon[3][item_price_xx][what_item].indexOf(".");

			if (ix0 > -1) {

				String cx0 = carbon[3][item_price_xx][what_item].substring(ix0, carbon[3][item_price_xx][what_item].length());

				if (cx0.length() == 1) {carbon[3][item_price_xx][what_item] = carbon[3][item_price_xx][what_item] + "00";}
				else if (cx0.length() == 2) {carbon[3][item_price_xx][what_item] = carbon[3][item_price_xx][what_item] + "0";}
				else if (cx0.length() == 4) {carbon[3][item_price_xx][what_item] = carbon[3][item_price_xx][what_item].substring(0, carbon[3][item_price_xx][what_item].length() -1);}
				else if (cx0.length() == 5) {carbon[3][item_price_xx][what_item] = carbon[3][item_price_xx][what_item].substring(0, carbon[3][item_price_xx][what_item].length() -2);}

			}//**********

		} catch (Exception e) {infox1.setText("Archive display error! price");}


		try {

			//test fees
			int ix0 = carbon[3][paypal_fees_xx][what_item].indexOf(".");

			if (ix0 > -1) {

				String cx0 = carbon[3][paypal_fees_xx][what_item].substring(ix0, carbon[3][paypal_fees_xx][what_item].length());

				if (cx0.length() == 1) {carbon[3][paypal_fees_xx][what_item] = carbon[3][paypal_fees_xx][what_item] + "00";}
				else if (cx0.length() == 2) {carbon[3][paypal_fees_xx][what_item] = carbon[3][paypal_fees_xx][what_item] + "0";}
				else if (cx0.length() == 4) {carbon[3][paypal_fees_xx][what_item] = carbon[3][paypal_fees_xx][what_item].substring(0, carbon[3][paypal_fees_xx][what_item].length() -1);}
				else if (cx0.length() == 5) {carbon[3][paypal_fees_xx][what_item] = carbon[3][paypal_fees_xx][what_item].substring(0, carbon[3][paypal_fees_xx][what_item].length() -2);}

			}//**********

		} catch (Exception e) {infox1.setText("Archive display error! fees");}


		try {

			double amount = Double.parseDouble(carbon[4][0][88]);
   			Locale locale = new Locale("en", "US");      
   			Currency currency = Currency.getInstance(locale);
   			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
   			System.out.println(currencyFormatter.format(amount));

			al_total_sales_n.setText("" + currencyFormatter.format(amount).toString().replace("$",""));
	
		}catch(Exception e){infox1.setText("Archive display error! PRICE");}


		try {

			double amount = Double.parseDouble(carbon[4][0][87]);
   			Locale locale = new Locale("en", "US");      
   			Currency currency = Currency.getInstance(locale);
   			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
   			System.out.println(currencyFormatter.format(amount));

			al_total_costs_n.setText("(" + currencyFormatter.format(amount).toString().replace("$","") + ")");

		} catch (Exception e) {infox1.setText("Archive display error! COST");}


		try {

			double amount = Double.parseDouble(carbon[4][0][89]);
   			Locale locale = new Locale("en", "US");      
   			Currency currency = Currency.getInstance(locale);
   			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
   			System.out.println(currencyFormatter.format(amount));

			al_total_taxes_n.setText("(" + currencyFormatter.format(amount).toString().replace("$","")  + ")");

		} catch (Exception e) {infox1.setText("Archive display error! TAX");}


		try {

			double amount = Double.parseDouble(carbon[4][0][90]);
   			Locale locale = new Locale("en", "US");      
   			Currency currency = Currency.getInstance(locale);
   			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
   			System.out.println(currencyFormatter.format(amount));

			al_total_shipping_n.setText("(" + currencyFormatter.format(amount).toString().replace("$","")  + ")");

		} catch (Exception e) {infox1.setText("Archive display error! SHIPPING");}


		try {
	
			Double ixd1 = Double.parseDouble(carbon[4][0][88]);

			Double ixd2 = Double.parseDouble(carbon[4][0][87]);
			Double ixd3 = Double.parseDouble(carbon[4][0][89]);
			Double ixd4 = Double.parseDouble(carbon[4][0][90]);


			Double ixd0 = (Double) ixd1 - (ixd2 + ixd3 + ixd4);

			double amount = ixd0;
   			Locale locale = new Locale("en", "US");      
   			Currency currency = Currency.getInstance(locale);
   			NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
   			System.out.println(currencyFormatter.format(amount));


			al_total_profit_n.setText("" + currencyFormatter.format(amount).toString().replace("$",""));

		} catch (Exception e) {infox1.setText("Addition errors!");}


		try {

			archive_address.setText(carbon[db_number][buyers_first_name_xx][what_item] + " " + carbon[db_number][buyers_last_name_xx][what_item] + "\n" + carbon[db_number][address_1_xx][what_item] + "\n" + carbon[db_number][address_2_xx][what_item] + ", " + carbon[db_number][address_3_xx][what_item] + " " + carbon[db_number][address_4_xx][what_item] + "\n" + carbon[db_number][address_5_xx][what_item] + "\n" + carbon[db_number][address_6_xx][what_item]);

			archive_tf_email.setText(carbon[db_number][buyers_email_xx][what_item]);
			archive_tf_saleid.setText(carbon[db_number][sale_id_xx][what_item]);

		} catch (Exception e) {infox1.setText("Archive display error! address");}



		try {

			sale_status_b_archive.setText(carbon[3][sale_status_xx][what_item].replace("[","").replace("]",""));  

		} catch (Exception e) {infox1.setText("Archive display error! set status");}





		//archived stats

		try {

			int ix0 = Integer.parseInt(carbon[4][0][92]);//refund
			int ix1 = Integer.parseInt(carbon[4][0][93]);//error
			int ix2 = Integer.parseInt(carbon[4][0][91]);//sold

			int ix3 = (ix0 * 100 / Integer.parseInt(carbon[4][0][94]));
			int ix4 = (ix1 * 100 / Integer.parseInt(carbon[4][0][94]));
			int ix5 = (ix2 * 100 / Integer.parseInt(carbon[4][0][94]));

			al_total_sold_n.setText(Integer.toString(ix2) + " (" + Integer.toString(ix5) + "%)");
			al_total_refunded_n.setText(Integer.toString(ix0) + " (" + Integer.toString(ix3) + "%)");
			al_total_errors_n.setText(Integer.toString(ix1) + " (" + Integer.toString(ix4) + "%)");

			if (ix3 == 0) {al_total_refunded_n.setText(Integer.toString(ix0) + " " + "(< 1%)");}
			if (ix4 == 0) {al_total_errors_n.setText(Integer.toString(ix1) + " " + "(< 1%)");}

	        //carbon[3][date_sold_xx][0] = "*[[" + db_string[date_sold_xx] + "]]";

	    } catch(Exception e) {infox1.setText("Display system failed.");}   



	}//*******************







	public void display_save_item5() {


		try {

			tf_namex.setText(carbon[5][name_info_xx][what_item]);
			tf_urlx.setText(carbon[5][urlx_info_xx][what_item]);
			tf_userx.setText(carbon[5][user_info_xx][what_item]);
			tf_passx.setText(carbon[5][pass_info_xx][what_item]);
			tf_key1x.setText(carbon[5][key1_info_xx][what_item]);
			tf_key2x.setText(carbon[5][key2_info_xx][what_item]);

			set_dropdown_fields_on_off();
			
		} catch(Exception e) {infox1.setText("Display system failed.");}


	}//*******************************









	public void display_save_item6() {

		total_items_selected = 1;


		if (carbon[6][1][what_item].equals("")) {carbon[6][1][what_item] = "";}
		if (carbon[6][2][what_item].equals("")) {carbon[6][2][what_item] = "0";}


		if (total_items_selected == 1) {

			set_status_on.setEnabled(true);
			set_tf_position.setEnabled(true);
			set_tf_size.setEnabled(true);
			set_status_color.setEnabled(true);

			if (carbon[6][0][what_item].equals("1")) {set_status_on.setSelectedIndex(1);}
			else {set_status_on.setSelectedIndex(0);}

			System.out.println("what_item " + what_item);

			set_tf_position.setText(carbon[6][1][what_item]);
			set_tf_size.setText(carbon[6][2][what_item]);

			if (carbon[6][3][what_item].equals("Red")) {set_status_color.setSelectedIndex(1);}
			else if (carbon[6][3][what_item].equals("Green")) {set_status_color.setSelectedIndex(2);}
			else if (carbon[6][3][what_item].equals("Blue")) {set_status_color.setSelectedIndex(3);}
			else {set_status_color.setSelectedIndex(0);}

		}//***************************
		else {

			set_status_on.setEnabled(false);
			set_tf_position.setEnabled(false);
			set_tf_size.setEnabled(false);
			set_status_color.setEnabled(false);

		}//**



	}//*******************************








	public void new_item_connect() {

		System.out.println("MAKE NEW ITEM");

		int ix0 = carbon[5][0].length;
		int ix1 = (carbon[5][0].length + 1);

		String[][] item_arrayx = new String[ carbon[5].length ][ ix1 ];

		for (int xloop0 = 0; xloop0 < carbon[5][name_info_xx].length; xloop0++) {//**********************
		
			for (int xloop1 = 0; xloop1 < carbon[5].length; xloop1++) {//********

				item_arrayx[xloop1][xloop0] = carbon[5][xloop1][xloop0];

			}//*****************************************************************

		}//for*******************************************************************************************


		String[][] build_new_connection = new String[db_cx_number][1];

		for (int xloop1 = 0; xloop1 < carbon[5].length; xloop1++) {//*********************

			item_arrayx[xloop1][ix0] = new String("*");
			build_new_connection[xloop1][0] = new String("*");

		}//for****************************************************************************


		item_arrayx[active_info_xx][ix0] = "no";

		item_arrayx[id_info_xx][ix0] = Long.toString(System.currentTimeMillis());

		build_new_connection[active_info_xx][0] = "no";

		build_new_connection[id_info_xx][0] = item_arrayx[id_info_xx][ix0];

		carbon[5] = item_arrayx;

		String next_id = Integer.toString(carbon[5][name_info_xx].length);

		jdb_new_connection newxc = new jdb_new_connection(build_new_connection,next_id);


	}//new item********************








	public void duplicate_yes() {

		System.out.println("duplicate ITEM");

		jdb_new_item_duplicate duplicatex10 = new jdb_new_item_duplicate(1, what_item);

		save_jdb_settings();

		create_button();
	
	}//new item********************





	public void duplicatex10_yes() {

		System.out.println("duplicate 10 ITEMs");

		jdb_new_item_duplicate duplicatex10 = new jdb_new_item_duplicate(10, what_item);

		save_jdb_settings();

		create_button();
	
	}//new item********************










	//old version not used. 
	public void set_shipped_items(){

		infox1.setText("Check for shipped items.");

	    if (db_number == 2 && program_working != 1) {

			program_working = 1;
			infox1.setText("Check for shipped items. Start.");

			for (int xloop0 = (carbon[2][0].length -1); xloop0 > 0; xloop0--) {

				if (carbon[2][sale_status_xx][xloop0].equals("Ready to ship")) {// || carbon[2][sale_status_xx][xloop0].equals("Sold")

					infox1.setText("Check for changes. " + Integer.toString(xloop0));

					int ix10 = xloop0;

					tracking_test_id = carbon[2][sale_id_xx][xloop0];

					String cx0 = new String("");
					String cx9 = "0";
					String cx9t = "x";
					String cx9x = "x";

					test_if_shipped(ix10);

					if (cx9.equals("1")) {

						carbon[2][sale_status_xx][xloop0] = "Shipped"; 
						//display_item();
						System.out.println("CX) " + cx0 + " " + cx9);


						if (carbon[2][tracking_number_xx][xloop0].length() < 3) {

							if (carbon[4][0][29].equals("4")) {}
							else {get_tracking_shipped();}

							if (carbon[2][tracking_number_xx][xloop0].length() > 3) {carbon[2][tracking_number_xx][xloop0] = cx9t; carbon[2][shipping_company_xx][xloop0] = cx9x;}
							if (carbon[2][tracking_number_xx][xloop0].length() > 3) {ship_post_tracking_number_choose_x(ix10);}
							if (ix10 == what_item){sold_tracking.setText(cx9t);}
							//display_item();
							System.out.println("CX) " + cx0 + " " + cx9);

						}//******************************************************


					}//******************************************************************************


					break;

				}//**************************************************

			}//*********************************************************

			program_working = 0;

	    }//********************
		else{infox1.setText("No items are ready.");}

		infox1.setText("Check for shipped items done....");

	}//******************************













	public void import_items_from_ebay() {

	//slower refresh*******************************


		firex22 = 0;
		int ix6_here = 0;


		if(db_number == 2) {

			infox1.setText("Importing new sales. Please wait...");

		    toolkit = Toolkit.getDefaultToolkit();
 	   		xtimerx = new Timer();
 	   		xtimerx.schedule(new RemindTask_import_sales_silent(), 0);

		}//****************
		else {System.out.println("9870394873434");}



		infox1.setText("Wait for refresh");

		while (ix6_here == 0) {

			if (firex22 == 1) {

				ix6_here = 2;

			}//****************

			System.out.println("holding....");

			try {Thread.sleep(1000);} catch (InterruptedException e){}

		}//while

		infox1.setText("Wait for refresh2");

		try {Thread.sleep(10000);} catch (InterruptedException e){}

		
		save_jdb_settings();

		infox1.setText("DB saved.");


	}//******************************










	//program loop. 
	class RemindTask_api_switch extends TimerTask{
	Runtime loop_runtime = Runtime.getRuntime();

	public void run() {//************************************************************************************


		int api_track = 0;

		while (true) {//************************************************************************************************************

			//quick test for api refresh requests 
			if (api_track < server_requests) {

				infox1.setText("API server requests: " + Integer.toString(server_requests)); 
				api_track = server_requests;

			}//*******************************

			//reset display
			if (reset_display_switch) {

				if (what_item == what_item_api_switch) {sold_tracking.setText(carbon[2][tracking_number_xx][what_item]);}

				//display_item();

				reset_display_switch = false;

			}//************************

			try {Thread.sleep(1000);} catch (InterruptedException e) {System.out.println("import black failed 000331");}

		}//while******************************************************************************************************************

	}//runx*************************************************************************************************
    }//remindtask








	//program loop. 
	class RemindTask_loopx extends TimerTask{
	Runtime loop_runtime = Runtime.getRuntime();


	public void run() {//************************************************************************************


		if (db_number == 0) {infox2.setText("Refresh loop db 0: started...");}
		else if (db_number == 2) {infox2.setText("Refresh loop db 2: started...");}
		else {infox2.setText("Refresh loop db X: started...");}

	    slow_refresh = 1;


		while (true) {//************************************************************************************************************

			//fast refresh

		
			try {Thread.sleep(60000);} catch (InterruptedException e) {System.out.println("import black failed 000331");}


			if (db_number == 0) {//**********************************************

				System.out.println("RUN XX0");
				infox2.setText("Refresh loop db 0: " + Integer.toString(slow_refresh) + " of 60.");


				if(slow_refresh == 15 && program_working != 1){

					//program_working = 1;
					//save_csv_1();
					//program_working = 0;

				}//********************************************


			}//if db_number == 0****************************************************
			else if (db_number == 2) {//*******************************************************************************************************


		
				System.out.println("RUN XX");
				infox2.setText("Refresh loop db 2: " + Integer.toString(slow_refresh) + " of 60.");


				if (slow_refresh == 1 && program_working != 1) {

					program_working = 1;
					import_items_from_ebay();			
		
				}//if slow****************************
				else if (slow_refresh == 1 && program_working == 1) {infox1.setText("1 Program is working can't import.");}



				infox1.setText("Check for new sales.");

				if (program_working != 1 && slow_refresh > 5) {//*******************************************************************
				//program_working = 1;

	        		if (auto_sales == 1 && db_number == 2){
		
						for (int xloop0 = (carbon[2][0].length -1); xloop0 > 0; xloop0--) {

							if (carbon[2][sale_status_xx][xloop0].equals("Sold") && xloop0 < 100) {

								infox1.setText("Check for new sales. " + Integer.toString(xloop0));
								//carbon[2][sale_status_xx][xloop0] = "Ready to ship";
								what_item = xloop0;
								export_dazzle_ll_2();
								//display_item();

								break;

							}//******************************************************************

						}//**************************************************************

	        		}//***********************************
					else {infox1.setText("Auto Ship System Is OFF. Press Q to Activate.");}


					stats_get_sales_datax();
					infox1.setText("SALE STATUS: (" + view_data_i_newsales + " New) (" + view_data_i_ready + " Ready) (" + view_data_i_shipped + " Shipped) (" + view_data_i_refunded + " Refunded) (" + view_data_i_errors + " Errors) (" + view_data_i_success + " Success)");
	

				//program_working = 0;
				}//*******************************************************************************************
				else if (program_working == 1) {System.out.println("Program is working, can't ship.");}//infox1.setText("Program is working, can't ship.");




				if (slow_refresh == 15 && program_working != 1) {

					//slow_refresh = 1; 
					System.out.println("test for updates"); 
					test_for_internet(); 
					r.gc();

					if (internet_access == 1) {

    					toolkit = Toolkit.getDefaultToolkit();
    					xtimerx = new Timer();
    					xtimerx.schedule(new RemindTask_import_shipped_sales(), 0);

					}//**********************

				}//*********************************************





			}//if db_number == 2********************************************************************************************************
			else {infox2.setText("Refresh: Paused.");}



			System.out.println("slow_refresh " + slow_refresh);
			if (slow_refresh > 59) {

				slow_refresh = 1; 
				System.out.println("test for updates"); 
				test_for_internet(); 
				r.gc();

			}
			else {slow_refresh++;}


		}//while******************************************************************************************************************

	}//runx*************************************************************************************************
    }//remindtask








	class RemindTask_1 extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************

		System.out.println("total_items_selected "  + total_items_selected);

		firex = 0;
		firex2 = 0;

		int ix6_here = 0;
		
		int ix0 = 0;
		int ix1 = 0;

		int ix6 = 0;
		//int ix6x = 0;


		for (int xloop = 0; xloop < carbon[db_number][0].length; xloop++) {//******

			if (selected_int[xloop] == 1) {

				System.out.println(">>> X >>> " + xloop);

			}//****************************

		}//*************************************************************************



		System.out.println("xxx " + total_items_selected);
		carbon_post = new String[db_cc_number][total_items_selected];
		System.out.println("xxx2 " + total_items_selected);

		for (int xloop0 = 0; xloop0 < carbon[0][0].length; xloop0++) {

			for (int xloop1 = 0; xloop1 < carbon[0].length; xloop1++) {

				if (selected_int[xloop0] == 1 && xloop0 != 0) {

					carbon_post[xloop1][ix0] = carbon[0][xloop1][xloop0];

				}//********************************************

			}//for***************************************************

			if (selected_int[xloop0] == 1 && xloop0 != 0) {

				ix0++;

			}//********************************************

		}//for***************************************************



		String cx0 = carbon[5][urlx_info_xx][Integer.parseInt(carbon[1][6][current_submit_item_x -1])];
		String cx1 = carbon[5][user_info_xx][Integer.parseInt(carbon[1][6][current_submit_item_x -1])];
		String cx2 = carbon[5][pass_info_xx][Integer.parseInt(carbon[1][6][current_submit_item_x -1])];

		if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay")) {

			System.out.println("Site ID ebay_site_xx " + nm.carbon[5][ebay_settings.ebay_site_xx][nm.current_submit_item_a]);

		}//******************************************************

		if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay") && nm.carbon[5][ebay_settings.ebay_site_xx][nm.current_submit_item_a].equals("*")) {

			JOptionPane.showMessageDialog(null,"eBay settings US UK site is not set.");

		}//*****************************************************************************************************************************


	         if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon"))    {System.out.println("Amazon"); amazon_export_items amxxp = new amazon_export_items();}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Custom"))    {System.out.println("API"); customapi_export_items pxa = new customapi_export_items(carbon_post, cx0, cx1, cx2);}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay") && nm.carbon[5][ebay_settings.ebay_site_xx][nm.current_submit_item_a].equals("0")) {System.out.println("eBay"); ebay_export_items exxp = new ebay_export_items();}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay") && nm.carbon[5][ebay_settings.ebay_site_xx][nm.current_submit_item_a].equals("1")) {System.out.println("eBay UK"); ebay_export_items_uk exxp_uk = new ebay_export_items_uk();}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Etsy"))       {System.out.println("Etsy"); etsy_export_items xxetsy = new etsy_export_items();}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Magento"))    {System.out.println("Magento"); magento_export_items mei = new magento_export_items(carbon_post, cx0, cx1, cx2);}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("MySQL"))      {System.out.println("MySQL");}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("PayPal"))     {JOptionPane.showMessageDialog(null,"You cannot export items to PayPal.");}
		else {}



		ix6 = 0;
		//ix6x = 0;

		while (ix6 == 0) {

			if (firex == 1) {

				ix6 = 2; 
				//pressx_repaint = 1; 
				//display_item(); 
				System.out.println("import bxx");

			}
	        
	        System.out.println("working..."); 

			//ix6x++;

			//if(ix1 > 10){firex = 1; ix6 = 2;}

			try {Thread.sleep(1000);} catch (InterruptedException e) {System.out.println("import black failed 000332");}

		}//while


	}//runx***************************************************************************************************
    }//remindtask












	class RemindTask_1_sold extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run() {//************************************************************************************

		System.out.println("total_items_selected "  + total_items_selected);

		firex2 = 0;
		int ix6_here = 0;
		int ix0 = 0;
		firex = 0;


		System.out.println("xxx " + total_items_selected);
		carbon_post = new String[db_cc_number][total_items_selected];

		for (int xloop0 = 0; xloop0 < carbon[2][0].length; xloop0++) {

			for (int xloop1 = 0; xloop1 < carbon[2].length; xloop1++) {

				if (selected_int[xloop0] == 1 && xloop0 != 0) {

					carbon_post[xloop1][ix0] = carbon[2][xloop1][xloop0];

				}

			}//for***************************************************

			if (selected_int[xloop0] == 1 && xloop0 != 0) {

				ix0++;

			}

		}//for***************************************************



		String cx0 = carbon[5][urlx_info_xx][Integer.parseInt(carbon[1][6][current_submit_item_x])];
		String cx1 = carbon[5][user_info_xx][Integer.parseInt(carbon[1][6][current_submit_item_x])];
		String cx2 = carbon[5][pass_info_xx][Integer.parseInt(carbon[1][6][current_submit_item_x])];

		System.out.println("Site ID ebay_site_xx " + nm.carbon[5][ebay_settings.ebay_site_xx][nm.current_submit_item_a]);

		if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay") && nm.carbon[5][ebay_settings.ebay_site_xx][nm.current_submit_item_a].equals("*")) {

			JOptionPane.showMessageDialog(null,"eBay settings US UK site is not set.");

		}//*****************************************************************************************************************************


	    if (carbon[5][type_info_xx][current_submit_item_a].equals("Alchemist")) {

	    	alchemy_export_sales pxas = new alchemy_export_sales(carbon_post, cx0, cx1, cx2);

	    }//***********************************************************


	    int ix1 = 0;

		while (ix6_here == 1) {

			if (firex == 1) {

				ix6_here = 2; 
				sold_button(); 
				System.out.println("import bxx");}

	   		System.out.println("working...");

	   		ix1++;

			if (ix1 > 10) {

				firex = 1; 
				ix6_here = 2;

			}//************

			try {Thread.sleep(1000);} catch (InterruptedException e) {System.out.println("import black failed 000332");}

		}//while


	}//runx***************************************************************************************************
    }//remindtask














	class RemindTask_2 extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************

		firex = 0;
		int ix6_here = 0;


		csv_blackthorne_import bti = new csv_blackthorne_import();
		//System.out.println("submit nm");


		while(ix6_here == 0){

			if (firex == 1) {

				ix6_here = 2; 
				create_button(); 
				System.out.println("import bxx");

			}

	        System.out.println("working...");

			try {Thread.sleep(1000);} catch (InterruptedException e) {System.out.println("import black failed 000332");}

		}//while

	}//runx***************************************************************************************************
    }//remindtask





	class RemindTask_import_sales extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//*********************************************************************************

		sales_import_done = false;
		run_silent = false;

		
	         if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon"))     {System.out.println("Amazon");     amazon_import_sales amazons = new amazon_import_sales();}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Custom"))     {System.out.println("Custom");     customapi_import_sales readx = new customapi_import_sales(current_submit_item_a);}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay"))       {System.out.println("eBay");       ebay_import_sales ebayis = new ebay_import_sales();}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Etsy"))       {System.out.println("Etsy");       etsy_import_sales ebayis = new etsy_import_sales();}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Magento"))    {System.out.println("Magento");    magento_import_sales mis = new magento_import_sales();}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("MySQL"))      {System.out.println("MySQL");      JOptionPane.showMessageDialog(null,"You cannot import items from SQL Databases. Use the Custom API.");}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("PayPal"))     {System.out.println("PayPal");     paypal_import_sales pix = new paypal_import_sales();}
		else {}


		while (true) {

			if (sales_import_done) {

				jdb_loader_titles settt = new jdb_loader_titles();
				titles_xx();
				sold_button();
				break;

			}//*************

			System.out.println("RUNNING...");

			try {Thread.sleep(1000);} catch (InterruptedException e) {}

		}//while

		run_silent = false;

		program_working = 0;

	}//runx***************************************************************************************************
    }//remindtask








	class RemindTask_import_sales_silent extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run() {//************************************************************************************


		if (current_submit_item_x == 0) {

			for (int xloop = 0; xloop < carbon[5][name_info_xx].length; xloop++) {//************

   				if (carbon[5][active_info_xx][xloop].equals("yes")) {//***********

					current_submit_item_a = xloop;

					infox1.setText("Importing: " + carbon[5][name_info_xx][xloop]);

					sales_import_done = false;
					run_silent = true;
					auto_ebay_import = 1;

        			System.out.println("AUTO1");


	         			 if (carbon[5][type_info_xx][xloop].equals("Amazon"))     {System.out.println("Amazon");     amazon_import_sales amazonss = new amazon_import_sales();}
					else if (carbon[5][type_info_xx][xloop].equals("Custom"))     {System.out.println("Custom");     customapi_import_sales readx = new customapi_import_sales(xloop);}
					else if (carbon[5][type_info_xx][xloop].equals("eBay"))       {System.out.println("eBay");       ebay_import_sales ebayis = new ebay_import_sales();}
					else if (carbon[5][type_info_xx][xloop].equals("Etsy"))       {System.out.println("Etsy");       etsy_import_sales ebayis = new etsy_import_sales();}
					else if (carbon[5][type_info_xx][xloop].equals("Magento"))    {System.out.println("Magento");    magento_import_sales mis = new magento_import_sales();}
					else if (carbon[5][type_info_xx][xloop].equals("MySQL"))      {System.out.println("MySQL");}
					else if (carbon[5][type_info_xx][xloop].equals("PayPal"))     {System.out.println("PayPal");     paypal_import_sales pix = new paypal_import_sales();}


      				System.out.println("AUTO2");

					while (true) {

						if (sales_import_done) {

							run_silent = false;
							break;

						}//****************

						System.out.println("RUNNING...S");

						try {Thread.sleep(1000);} catch (InterruptedException e){}

					}//while


   				}//if***************************************************

			}//for***********************************************************************

			try {

				current_submit_item_a = Integer.parseInt(carbon[1][6][(current_submit_item_x -1)]);

			} catch (Exception e) {e.printStackTrace();}


       		System.out.println("AUTO 00 IMPORT DONE>");

			if (db_number == 2) {

				jdb_loader_titles settt = new jdb_loader_titles();
				titles_xx();
				auto_ebay_import = 0; 
				sold_button();

			}//****************


		}//if**************************
		else {


			infox1.setText("Importing: " + carbon[5][name_info_xx][current_submit_item_a]);

			sales_import_done = false;
			run_silent = true;


	             if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon"))     {System.out.println("Amazon");     amazon_import_sales amazons = new amazon_import_sales();}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Custom"))     {System.out.println("Custom");     customapi_import_sales readx = new customapi_import_sales(current_submit_item_a);}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay"))       {System.out.println("eBay");       ebay_import_sales ebayis = new ebay_import_sales();}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Etsy"))       {System.out.println("Etsy");       etsy_import_sales ebayis = new etsy_import_sales();}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Magento"))    {System.out.println("Magento");    magento_import_sales mis = new magento_import_sales();}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("MySQL"))      {System.out.println("SQL");}
			else if (carbon[5][type_info_xx][current_submit_item_a].equals("PayPal"))     {System.out.println("PayPal");     paypal_import_sales pix = new paypal_import_sales();}


			while (true) {

				if (sales_import_done) {

					if (db_number == 2) {

						jdb_loader_titles settt = new jdb_loader_titles();
						titles_xx();
						sold_button(); 

					}//**************** 

					repaint(); 
					run_silent = false;
					break;

				}//*************

				System.out.println("RUNNING...X");

				try {Thread.sleep(1000);} catch (InterruptedException e) {}

			}//while


		}//else

		firex22 = 1;

		program_working = 0;

		if (SystemTray.isSupported()) {

			SysTray_message();

		}

	}//runx***************************************************************************************************
    }//remindtask











	class RemindTask_import_items extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************

		int ix0 = 1;
		firex = 0;
		int ix6_here = 1;


	         if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon"))  {System.out.println("Amazon");}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Custom"))  {System.out.println("Custom"); alchemy_import_items read = new alchemy_import_items(current_submit_item_a);}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay"))    {System.out.println("eBay");}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Etsy"))    {System.out.println("eBay");}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("Magento")) {System.out.println("Magento");}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("MySQL"))   {System.out.println("SQL");}
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("PayPal"))  {System.out.println("PayPal");}
		else {}


		while (ix6_here == 1) {

			if (firex == 1) {

				ix6_here = 2; 
				program_working = 0; 
				create_button();

			}//**************

			try{Thread.sleep(1000);} catch (InterruptedException e){}

		}//while*************

	}//runx***************************************************************************************************
    }//remindtask












	class RemindTask_import_shipped_sales extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run() {//************************************************************************************


		firex = 0;
		int ix6_here = 0;


		infox1.setText("Get Shipped List...");
		if (program_working != 1) {

			program_working = 1;

			for (int xloop0 = 1; xloop0 < carbon[2][0].length; xloop0++) {//**************


				if (carbon[2][sale_status_xx][xloop0].equals("Ready to ship")) {// || carbon[2][sale_status_xx][xloop0].equals("Sold")

					infox1.setText("Check for changes: " + Integer.toString(xloop0));

					int ix10 = xloop0;

					tracking_test_id = carbon[2][sale_id_xx][xloop0];

					String cx0 = new String("");
					String cx9 = "0";
					String cx9t = "0";
					String cx9x = "0";

					test_if_shipped(ix10);

					if (cx9.equals("1")) {


						carbon[2][sale_status_xx][xloop0] = "Shipped";//*************

						DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:MM:ss");
						String formattedDate = df.format(new Date()) + ".00" + Integer.toString(0);

						carbon[2][date_shipped_xx][xloop0] = formattedDate;//*************
						System.out.println("CX) " + cx0 + " " + cx9);


						if (carbon[2][tracking_number_xx][xloop0].length() < 3) {

							get_tracking_shipped();

							if (cx9.equals("")) {cx9 = "0";}

							carbon[2][tracking_number_xx][xloop0] = cx9t;
							carbon[2][shipping_company_xx][xloop0] = cx9x;

							if (ix10 == what_item) {sold_tracking.setText(cx9t);}

							infox1.setText("Post tracking number " + Integer.toString(ix10) + " " + carbon[2][tracking_number_xx][xloop0]);

							//testing************************************************

							ix10 = xloop0;

							     if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("Alchemy"))    {}
							else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("Amazon"))     {amazon_post_order_addtrack spof = new amazon_post_order_addtrack(ix10); amazon_post_order_addtrack spof2 = new amazon_post_order_addtrack(ix10);}
							else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("Custom"))     {}
							else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("eBay"))       {ebay_post_order_addtrack sptn1 = new ebay_post_order_addtrack(ix10);}
							else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("Etsy"))       {etsy_post_order_addtrack sptn1 = new etsy_post_order_addtrack(ix10);}
							else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("Magento"))    {magento_post_order_addtrack xptn1 = new magento_post_order_addtrack(ix10);}
							else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("MySQL"))      {}
							else if (nm.carbon[5][type_info_xx][ Integer.parseInt(nm.carbon[2][nm.transaction_id_xx][ix10]) ].equals("PayPal"))     {}

							//testing************************************************

							//ship_post_tracking_number_choose_x();
							//display_item();
							System.out.println("CX) " + cx0 + " " + cx9);

						}//****************************************************

					}//********************************************************************************

				}//if*****************************************************************************************************************


				//display_item();

			}//for*************************************************************************


			program_working = 0;

		}//*************************



		while (ix6_here == 1) {

			if (firex == 1) {

				ix6_here = 2; 
				program_working = 0; 
				sold_button(); 
				repaint();

			}//**************

			try {Thread.sleep(1000);} catch (InterruptedException e) {}

		}//while

	}//runx***************************************************************************************************
    }//remindtask













	class RemindTask_import_shipped_sales_archived extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run() {//************************************************************************************

		firex = 0;

		int ix6_here = 0;

		infox1.setText("Get Shipped List a...");

		if (program_working != 1) {

			program_working = 1;

			for (int xloop0 = 1; xloop0 < carbon[3][0].length; xloop0++) {//**************


				if (carbon[3][sale_status_xx][xloop0].equals("Ready to ship")) {// || carbon[2][sale_status_xx][xloop0].equals("Sold")

					infox1.setText("Check for changes: " + Integer.toString(xloop0));

					int ix10 = xloop0;

					tracking_test_id = carbon[3][sale_id_xx][xloop0];

					String cx0 = new String("");
					String cx9 = "0";
					String cx9t = "0";
					String cx9x = "0";

					test_if_shipped(ix10);

					if (cx9.equals("1")) {

						carbon[3][sale_status_xx][xloop0] = "Shipped";//*************


						DateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:MM:ss");
						String formattedDate = df.format(new Date()) + ".00" + Integer.toString(0);

						carbon[3][date_shipped_xx][xloop0] = formattedDate;//*************
						System.out.println("CX) " + cx0 + " " + cx9);


						if (carbon[3][tracking_number_xx][xloop0].length() < 3) {

							get_tracking_shipped();

							if(cx9.equals("")){cx9 = "0";}

							carbon[3][tracking_number_xx][xloop0] = cx9t;
							carbon[3][shipping_company_xx][xloop0] = cx9x;

							if(ix10 == what_item){sold_tracking.setText(cx9t);}

							infox1.setText("Post tracking number " + Integer.toString(ix10) + " " + carbon[3][tracking_number_xx][xloop0]);

							//testing************************************************

							ix10 = xloop0;

							//testing************************************************

							//ship_post_tracking_number_choose_x();
							//display_item();
							System.out.println("CX) " + cx0 + " " + cx9);

						}//****************************************************

					}//********************************************************************************

				}//if*****************************************************************************************************************


				//display_item();

			}//*************************************************************************


			program_working = 0;

		}//*************************



		while (ix6_here == 1) {

			if (firex == 1) {

				ix6_here = 2; 
				program_working = 0; 
				archive_button(); 
				repaint();

			}

			try {Thread.sleep(1000);} catch (InterruptedException e){}

		}//while

	}//runx***************************************************************************************************
    }//remindtask













	class RemindTask_import_shipped_status extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************

		firex = 0;
		int ix6_here = 0;
		int ix0 = 0;

		infox1.setText("Get Shipped List...");

		if (program_working != 1) {

			program_working = 1;

			for (int xloop0 = 1; xloop0 < carbon[2][0].length; xloop0++) {//**************
			//ix10 = xloop0;

			if (carbon[2][sale_status_xx][xloop0].equals("Shipped")) {//*********************************************************


				infox1.setText("Check shipping changes USPS: " + Integer.toString(xloop0));

					try {


						try {

							//String ReturnValue = "<TrackRequest USERID=\"033ALCHE5855\"><TrackID ID=\"EJ958083578US\"></TrackID></TrackRequest>";
							//String ReturnValue = "<CityStateLookupRequest USERID=\"033ALCHE5855\"><ZipCode ID=\"0\"><Zip5>90210</Zip5></ZipCode></CityStateLookupRequest>";
							String ReturnValue = "<TrackRequest USERID=\"033ALCHE5855\"><TrackID ID=\"" + carbon[2][tracking_number_xx][xloop0] + "\"></TrackID></TrackRequest>";


							ReturnValue = URLEncoder.encode(ReturnValue, "UTF-8");

							System.out.println(ReturnValue);

							//URL url = new URL("http://testing.shippingapis.com/ShippingAPITest.dll?API=CityStateLookup&XML=" + ReturnValue);
							//URL url = new URL("http://production.shippingapis.com/ShippingAPITest.dll?API=TrackV2&XML=" + ReturnValue);
							URL url = new URL("http://production.shippingapis.com/ShippingAPI.dll?API=TrackV2&XML=" + ReturnValue);

							URLConnection con = url.openConnection();



							InputStream input = url.openStream();
							System.out.println("10");
							String str = IOUtils.toString(input, "utf-8"); //encoding is important
							System.out.println(str);
							System.out.println("11");

							ix0 = str.indexOf("Your item was delivered");

						} catch(Exception e) {e.printStackTrace();}

							if (ix0 != -1) {

								carbon[2][sale_status_xx][xloop0] = "Successful";

							}//***********
							else {System.out.println("USPS FAIL");}

					} catch (Exception e) {infox1.setText("URL falure."); System.out.println("URL falure."); e.printStackTrace(System.out);}



				}//if*****************************************************************************************************************


				//display_item();

			}//for*************************************************************************


			program_working = 0;

		}//if*************************



		while (ix6_here == 1) {

			if (firex == 1) { 

				ix6_here = 2; 
				program_working = 0; 
				sold_button(); 

			}

			try {Thread.sleep(1000);} catch (InterruptedException e){}

		}//while

	}//runx***************************************************************************************************
    }//remindtask













	class RemindTask_import_shipped_status_uk extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************

		String cx000 = new String();

		infox1.setText("Get Shipped List...");

		if(program_working != 1){

			program_working = 1;

			for(int xloop0 = 1; xloop0 < carbon[2][0].length; xloop0++){//**************


				infox1.setText("Get Shipped List Royal Mail " + Integer.toString(xloop0));
				if(carbon[2][sale_status_xx][xloop0].equals("Shipped")){//********************************************************************************

					try {


	    				// Send data
	    				URL url = new URL("http://www.alchemistwebshops.com/tools/tracktrace.php?tn=" + carbon[2][tracking_number_xx][xloop0]);//
	    				URLConnection conn = url.openConnection();
	    				conn.setDoOutput(true);
	    				OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	    				wr.flush();

	    				// Get the response
	    				BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    				String line;
	    				while ((line = rd.readLine()) != null) {

	        				cx000 = line;

	    				}//**************************************
	   					wr.close();
	    				rd.close();
	    				//conn.close();

	    				//System.out.println(cx000);


						try {

							String resultString;
							JSONParser parser = new JSONParser();

							Object obj = JSONValue.parse(cx000);

							JSONObject jsonObject = (JSONObject) obj;

							System.out.println("DDL3");

							Long name = (Long) jsonObject.get("response");
							System.out.println(name);

							if(name == 1){carbon[2][sale_status_xx][xloop0] = "Successful";}
							else{}


						} catch (Exception e) {e.printStackTrace();}

	
					} catch (Exception e) {infox1.setText("Connection Failed.");}


				}//if shipped*****************************************************************************************************************************

				//display_item();

			}//for*************************************************************************


		}//if**********************


		program_working = 0;


	}//runx***************************************************************************************************
    }//remindtask












//*********************************
//*********************************
	class RemindTask_import_shipped_status2 extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************


		String cx000 = new String();
		int ix0 = 0;

		infox1.setText("Get Shipped List...2");
		System.out.println("Get Shipped List...2");

		if (program_working != 1) {
	
			program_working = 1;

			for (int xloop0 = 1; xloop0 < carbon[2][0].length; xloop0++) {//**************

				infox1.setText("Get Shipped List: " + Integer.toString(xloop0));


				if (carbon[2][shipping_company_xx][xloop0].equals("USPS")) {

					//ix10 = xloop0;

					if (carbon[2][sale_status_xx][xloop0].equals("Shipped")) {//*********************************************************


						infox1.setText("Get Shipped List USPS: " + Integer.toString(xloop0));

						try {


							try {

								//String ReturnValue = "<TrackRequest USERID=\"033ALCHE5855\"><TrackID ID=\"EJ958083578US\"></TrackID></TrackRequest>";
								//String ReturnValue = "<CityStateLookupRequest USERID=\"033ALCHE5855\"><ZipCode ID=\"0\"><Zip5>90210</Zip5></ZipCode></CityStateLookupRequest>";
								String ReturnValue = "<TrackRequest USERID=\"033ALCHE5855\"><TrackID ID=\"" + carbon[2][tracking_number_xx][xloop0] + "\"></TrackID></TrackRequest>";


								ReturnValue = URLEncoder.encode(ReturnValue, "UTF-8");

								System.out.println(ReturnValue);

								//URL url = new URL("http://testing.shippingapis.com/ShippingAPITest.dll?API=CityStateLookup&XML=" + ReturnValue);
								//URL url = new URL("http://production.shippingapis.com/ShippingAPITest.dll?API=TrackV2&XML=" + ReturnValue);
								URL url = new URL("http://production.shippingapis.com/ShippingAPI.dll?API=TrackV2&XML=" + ReturnValue);

								URLConnection con = url.openConnection();



								InputStream input = url.openStream();
								System.out.println("10");
								String str = IOUtils.toString(input, "utf-8"); //encoding is important
								System.out.println(str);
								System.out.println("11");

								ix0 = str.indexOf("Your item was delivered");

							} catch (Exception e) {e.printStackTrace();}


							if (ix0 != -1) {

								carbon[2][sale_status_xx][xloop0] = "Successful";

							}//***********
							else {System.out.println("USPS FAIL");}

						} catch (Exception e) {

							infox1.setText("URL falure."); 
							System.out.println("URL falure."); 
							e.printStackTrace(System.out);

						}



						//display_item();

					}//if*****************************************************************************************************************




				}//if1
				else if(carbon[2][shipping_company_xx][xloop0].equals("Royal Mail")){


					infox1.setText("Get Shipped List Royal Mail: " + Integer.toString(xloop0));
					if(carbon[2][sale_status_xx][xloop0].equals("Shipped")){//********************************************************************************

						try {


	   						// Send data
	    					URL url = new URL("http://www.alchemistwebshops.com/tools/tracktrace.php?tn=" + carbon[2][tracking_number_xx][xloop0]);//
	    					URLConnection conn = url.openConnection();
	    					conn.setDoOutput(true);
	    					OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	    					wr.flush();

	    					// Get the response
	   						BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    					String line;
	    					while ((line = rd.readLine()) != null) {

	        					cx000 = line;

	   						}//**************************************
	   						wr.close();
	    					rd.close();
	    					//conn.close();

	    					//System.out.println(cx000);


							try{

								String resultString;
								JSONParser parser = new JSONParser();

								Object obj = JSONValue.parse(cx000);

								JSONObject jsonObject = (JSONObject) obj;

								System.out.println("DDL3");

								carbon[2][notes_xx][xloop0] = jsonObject.toString();

								Long name = (Long) jsonObject.get("delivered");
								System.out.println(name);

								if(name == 1){carbon[2][sale_status_xx][xloop0] = "Successful";}
								else{}

							}catch(Exception e){e.printStackTrace();}

	
						}catch(Exception e){infox1.setText("Connection Failed.");}

						//display_item();

					}//if shipped*****************************************************************************************************************************



				}//******else
				else{infox1.setText("Unknown Shipping company " + carbon[2][shipping_company_xx][xloop0] + " " + Integer.toString(xloop0));}


			}//for*************************************************************************


	
		}//if*************************


		System.out.println("SHIP LIST DONE 1223");
		program_working = 0;
		sold_button(); 



	}//runx***************************************************************************************************
    }//remindtask


//*********************************
//*********************************






//archived version
//*********************************
//*********************************


	class RemindTask_import_shipped_status2_archive extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run() {//************************************************************************************


		String cx000 = new String();
		int ix0 = 0;

		infox1.setText("Get Archived Shipped List...2");
		System.out.println("Get Shipped List...2");

		if (program_working != 1) {

			program_working = 1;

			for (int xloop0 = 1; xloop0 < 2225; xloop0++) {//**************carbon[3][0].length

				infox1.setText("Get Shipped List: " + Integer.toString(xloop0));


				if (carbon[3][shipping_company_xx][xloop0].equals("USPS")) {


					//ix10 = xloop0;

					if (carbon[3][sale_status_xx][xloop0].equals("Shipped")) {//*********************************************************


						infox1.setText("Get Archived Shipped List USPS: " + Integer.toString(xloop0));

						try {

							try {

								//String ReturnValue = "<TrackRequest USERID=\"033ALCHE5855\"><TrackID ID=\"EJ958083578US\"></TrackID></TrackRequest>";
								//String ReturnValue = "<CityStateLookupRequest USERID=\"033ALCHE5855\"><ZipCode ID=\"0\"><Zip5>90210</Zip5></ZipCode></CityStateLookupRequest>";
								String ReturnValue = "<TrackRequest USERID=\"033ALCHE5855\"><TrackID ID=\"" + carbon[3][tracking_number_xx][xloop0] + "\"></TrackID></TrackRequest>";


								ReturnValue = URLEncoder.encode(ReturnValue, "UTF-8");

								System.out.println(ReturnValue);

								//URL url = new URL("http://testing.shippingapis.com/ShippingAPITest.dll?API=CityStateLookup&XML=" + ReturnValue);
								//URL url = new URL("http://production.shippingapis.com/ShippingAPITest.dll?API=TrackV2&XML=" + ReturnValue);
								URL url = new URL("http://production.shippingapis.com/ShippingAPI.dll?API=TrackV2&XML=" + ReturnValue);

								URLConnection con = url.openConnection();

								InputStream input = url.openStream();
								System.out.println("10");
								String str = IOUtils.toString(input, "utf-8"); //encoding is important
								System.out.println(str);
								System.out.println("11");

								ix0 = str.indexOf("Your item was delivered");

							} catch (Exception e) {e.printStackTrace();}




							if (ix0 != -1) {

								carbon[3][sale_status_xx][xloop0] = "Successful";

							}//***********
							else {System.out.println("USPS FAIL");}


						} catch (Exception e) {

							infox1.setText("URL falure."); 
							System.out.println("URL falure."); 
							e.printStackTrace(System.out);

						}



						//display_item();

					}//if*****************************************************************************************************************




				}//if1
				else if (carbon[3][shipping_company_xx][xloop0].equals("Royal Mail")) {


					infox1.setText("Get Shipped List Royal Mail: " + Integer.toString(xloop0));
					if (carbon[3][sale_status_xx][xloop0].equals("Shipped")) {//********************************************************************************

						try {


	   						// Send data
	   						URL url = new URL("http://www.alchemistwebshops.com/tools/tracktrace.php?tn=" + carbon[3][tracking_number_xx][xloop0]);//
	    					URLConnection conn = url.openConnection();
	   						conn.setDoOutput(true);
	    					OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	    					wr.flush();

	    					// Get the response
	    					BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    					String line;
	    					while ((line = rd.readLine()) != null) {

	        					cx000 = line;

	   						}//**************************************
	    					wr.close();
	    					rd.close();
	    					//conn.close();
	    					//System.out.println(cx000);


							try {

								String resultString;
								JSONParser parser = new JSONParser();

								Object obj = JSONValue.parse(cx000);

								JSONObject jsonObject = (JSONObject) obj;

								System.out.println("DDL3");

								carbon[3][notes_xx][xloop0] = jsonObject.toString();

								Long name = (Long) jsonObject.get("delivered");
								System.out.println(name);

								if (name == 1) {carbon[3][sale_status_xx][xloop0] = "Successful";}
								else {}


							} catch (Exception e) {e.printStackTrace();}

	
						} catch (Exception e) {infox1.setText("Connection Failed.");}

						//display_item();

					}//if shipped*****************************************************************************************************************************






				}//******else
				else{

					infox1.setText("Unknown Shipping company " + carbon[3][shipping_company_xx][xloop0] + " " + Integer.toString(xloop0));

				}


			}//for*************************************************************************


	
		}//if*************************


		System.out.println("SHIP LIST DONE 1223a");
		program_working = 0;
		archive_button(); 
		repaint();



	}//runx***************************************************************************************************
    }//remindtask
//*********************************
//*********************************











	class RemindTask_combo_tool extends TimerTask {
	Runtime rxrunti = Runtime.getRuntime();

	public void run() {//************************************************************************************


		alchemy_disband_combo_tool dct = new alchemy_disband_combo_tool();

		create_button();

		System.out.println("total_items_selected "  + total_items_selected);


		int ix0 = 0;
		int ix1 = 0;


		if (total_items_selected < 2) {

			select_all_itemsx();

			int ix6_here = 0;
			firex = 0;

			System.out.println("xxx " + total_items_selected);
			carbon_post = new String[db_cc_number][total_items_selected];

			for (int xloop0 = 0; xloop0 < carbon[0][0].length; xloop0++) {

				for (int xloop1 = 0; xloop1 < carbon[0].length; xloop1++) {

					if(selected_int[xloop0] == 1 && xloop0 != 0) {

						carbon_post[xloop1][ix0] = carbon[0][xloop1][xloop0];

					}//*******************************************

				}//for***************************************************

				if (selected_int[xloop0] == 1 && xloop0 != 0) {ix0++;}

			}//for***************************************************

		}//**************************		
		else {


			System.out.println("xxx " + total_items_selected);
			carbon_post = new String[db_cc_number][total_items_selected];

			for (int xloop0 = 0; xloop0 < carbon[0][0].length; xloop0++) {

				for (int xloop1 = 0; xloop1 < carbon[0].length; xloop1++) {

					if (selected_int[xloop0] == 1 && xloop0 != 0) {

						carbon_post[xloop1][ix0] = carbon[0][xloop1][xloop0];

					}//********************************************

				}//for***************************************************

				if (selected_int[xloop0] == 1 && xloop0 != 0) {ix0++;}

			}//for*****************************************************

		}//****
		

		int ix6_here = 0;
		firex = 0;

		System.out.println("cc " + firex + " " + ix0);

		combo_generator1 combo_generator_system = new combo_generator1();

		System.out.println("cc " + firex + " " + ix0);

		while (ix6_here == 1) {

			if (firex == 1) {

				ix6_here = 2; 
				create_button(); 
				ix6_here = 2;

			}//*************

			System.out.println("working...");

			try {Thread.sleep(1000);} catch (InterruptedException e){}

		}//while



	}//runx***************************************************************************************************
    }//remindtask














	class RemindTask_combo_tool2 extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************


		alchemy_disband_combo_tool dct = new alchemy_disband_combo_tool(); 

		create_button();

		int ix0 = 0;

		System.out.println("total_items_selected "  + total_items_selected);


		if (carbon[0][0].length < 501 && carbon[0][0].length > 3) {//*************

			select_all_itemsx();
			//selected_int[0] = 0;

			firex = 0;
			int ix6_here = 0;

			System.out.println("xxx " + total_items_selected);

			carbon_post = new String[db_cc_number][total_items_selected];

			for (int xloop0 = 0; xloop0 < carbon[0][0].length; xloop0++) {

				for (int xloop1 = 0; xloop1 < carbon[0].length; xloop1++) {

					if (selected_int[xloop0] == 1 && xloop0 != 0) {

						carbon_post[xloop1][ix0] = carbon[0][xloop1][xloop0];

					}//********************************************

				}//for***************************************************

			if (selected_int[xloop0] == 1 && xloop0 != 0) {ix0++;}

			}//for******************************************************
	

		
			System.out.println("cc " + firex + " " + ix0);

			combo_generator2 combo_generator_system = new combo_generator2();

			System.out.println("cc " + firex + " " + ix0);

			while (ix6_here == 1) {

				if (firex == 1) {

					ix6_here = 2; 
					create_button();

				}//**************

				System.out.println("working...");

				try {Thread.sleep(1000);} catch (InterruptedException e){}

			}//while



		}//if**********************************
		else {JOptionPane.showMessageDialog(null,"Your database must be > 3 and < 500 items.");}

	}//runx***************************************************************************************************
    }//remindtask










	class RemindTask_alchemy extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run() {//************************************************************************************

		System.out.println(carbon[db_number][0].length + " " + what_item);


		if (carbon[db_number][0].length > 0) {

			int ix0 = 0;
			int ix1 = 0;

			System.out.println("xxx " + total_items_selected);
			carbon_post = new String[db_cc_number][total_items_selected];

			for (int xloop0 = 0; xloop0 < carbon[db_number][0].length; xloop0++) {

				for (int xloop1 = 0; xloop1 < db_cc_number; xloop1++) {

					if (selected_int[xloop0] == 1) {

						carbon_post[xloop1][ix0] = carbon[db_number][xloop1][xloop0]; 
						System.out.println("nm " + carbon_post[xloop1][ix0]); 

						if (db_number == 2) {carbon[2][sale_status_xx][xloop0] = "Exported";}
						if (db_number == 3) {carbon[3][sale_status_xx][xloop0] = "Exported";}

					}//if***************************

				}//for*************************************************

				if (selected_int[xloop0] == 1) {ix0++;}

			}//for****************************************************************


			if (db_number == 0) {quickbooks_export_items cgxa = new quickbooks_export_items(carbon_post);}
			if (db_number == 2) {quickbooks_export_sales cgxa = new quickbooks_export_sales(carbon_post);}
			if (db_number == 3) {quickbooks_export_sales cgxa = new quickbooks_export_sales(carbon_post);}

			//if (db_number == 0) {create_button();}
			//if (db_number == 2) {sold_button();}
			//if (db_number == 3) {archive_button();}


		}//***********************************
		else {JOptionPane.showMessageDialog(null, "Nothing to export!");}


	}//runx***************************************************************************************************
    }//remindtask





	class RemindTask_rt extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();
	

	public void run(){//************************************************************************************

		System.out.println("run replace.");

		//alchemy_replace_7 cgxaxx = new alchemy_replace_7();

	}//runx*************************************************************************************************
    }//remindtask






	class RemindTask_replace_window extends TimerTask {
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************

		replace_window_open = true;
		boolean workingx = true;

		System.out.println("WORKINGx1");

		jdb_replace_1 alchemistr = new jdb_replace_1();

		System.out.println("WORKINGx2");

		while (workingx) {

			if (!replace_window_open) {//******
		
				workingx = false; 

				if (db_number == 0) {

					//update the textfields

					tf_title.setText(carbon[0][title_xx][what_item]);
					tf_part.setText(carbon[0][part_number_xx][what_item]);
					tf_d.setText(carbon[0][package_d_xx][what_item]);
					tf_l.setText(carbon[0][package_l_xx][what_item]);
					tf_w.setText(carbon[0][package_w_xx][what_item]);
					tf_cost.setText(carbon[0][item_cost_xx][what_item]);
					tf_price.setText(carbon[0][item_price_xx][what_item]);
					tf_onhand.setText(carbon[0][total_on_hand_xx][what_item]);
					tf_weight.setText(carbon[0][item_weight_xx][what_item]);
					tf_picture_1.setText(carbon[0][picture_1_xx][what_item]);
					tf_custom_1.setText(carbon[0][custom_1_xx][what_item]);
					tf_custom_2.setText(carbon[0][custom_2_xx][what_item]);
					tf_custom_3.setText(carbon[0][custom_3_xx][what_item]);

					create_button();

				}//****************

				if (db_number == 2) {sold_button();}
				if (db_number == 3) {archive_button();}

			}//********************

			//System.out.println("Replace Window is Open...");

			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}

		}//while


	}//runx***************************************************************************************************
    }//remindtask



	class RemindTask_rxxx extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************

		replace_other_window_open =true;
		boolean workingx = true;

		jdb_replace_2 a_r = new jdb_replace_2();


		while (workingx) {

			if (!replace_other_window_open) {//******
			
				workingx = false; 

				if (db_number == 0) {create_button();}
				if (db_number == 2) {sold_button();}
				if (db_number == 3) {archive_button();}

			}//********************

			//System.out.println("WORKING");

			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}

		}//while


	}//runx***************************************************************************************************
    }//remindtask














	class RemindTask_xml_import extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************


		firex2 = 0;
		int ix6_here = 0;

	     xml_import xmli = new xml_import();

	     while (ix6_here == 0) {

			if (nm.firex2 == 1) {

				ix6_here = 1;

			}//******************

	        System.out.println("Waiting...");

			try {Thread.sleep(1000);} catch (InterruptedException e) {}
	
	     }//******************


		if (db_number == 0) {create_button();}
		else if (db_number == 2) {sold_button();}
		else if (db_number == 3) {archive_button();}
		else {System.out.println("C ERROR");}

		JOptionPane.showMessageDialog(null,"XML file imported.");

	}//runx***************************************************************************************************
    }//remindtask






	class RemindTask_json_import extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run() {//************************************************************************************


		firex2 = 0;
		int ix6_here = 0;

	     json_import read = new json_import();

	     while (ix6_here == 0) {

			if (nm.firex2 == 1) {

				ix6_here = 1;

			}//******************

	        System.out.println("Waiting...");
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
	
	     }//******************


		if (db_number == 0) {create_button();}
		else if (db_number == 2) {sold_button();}
		else if (db_number == 3) {archive_button();}
		else {System.out.println("C ERROR");}

		JOptionPane.showMessageDialog(null,"JSON file imported.");

	}//runx***************************************************************************************************
    }//remindtask






	class RemindTask_csv_import extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************


		csv_import_open = true;

	     csv_import read = new csv_import();

	     while (true) {

			if (!nm.csv_import_open) {

				break;

			}//***********************

	        System.out.println("Waiting...");
			try {Thread.sleep(1000);} catch (InterruptedException e) {}
	
	     }//******************


		     if (db_number == 0) {create_button();}
		else if (db_number == 2) {sold_button();}
		else if (db_number == 3) {archive_button();}
		else {System.out.println("C ERROR");}

		//JOptionPane.showMessageDialog(null,"CSV file imported.");


	}//runx***************************************************************************************************
    }//remindtask






	class RemindTask_edit extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************


		if (!edit_window_is_open && db_number == 0) {

			edit_window_is_open = true;

			save_item_control = carbon[0][item_id_xx][what_item];

			alchemy_edit ae = new alchemy_edit(what_item);


			while (edit_window_is_open) {

				//System.out.println("Waiting...");

				try {Thread.sleep(1000);} catch (InterruptedException e) {System.out.println("edit...");}

			}//while


			if (db_number == 0) {

				if (save_item_control.equals(carbon[0][item_id_xx][what_item])) {//*********************

					tf_title.setText(carbon[0][title_xx][what_item]);
					tf_part.setText(carbon[0][part_number_xx][what_item]);
					tf_d.setText(carbon[0][package_d_xx][what_item]);
					tf_l.setText(carbon[0][package_l_xx][what_item]);
					tf_w.setText(carbon[0][package_w_xx][what_item]);
					tf_cost.setText(carbon[0][item_cost_xx][what_item]);
					tf_price.setText(carbon[0][item_price_xx][what_item]);
					tf_onhand.setText(carbon[0][total_on_hand_xx][what_item]);
					tf_weight.setText(carbon[0][item_weight_xx][what_item]);
					tf_picture_1.setText(carbon[0][picture_1_xx][what_item]);
					tf_custom_1.setText(carbon[0][custom_1_xx][what_item]);
					tf_custom_2.setText(carbon[0][custom_2_xx][what_item]);
					tf_custom_3.setText(carbon[0][custom_3_xx][what_item]);

				}//*************************************************************************************


				String[][][] export_display_list = build_export_display_list();
				dxengine0.display_item(export_display_list[0], what_item_display);
				
				System.out.println("close editor..");

			}//if************



		}//if
		else {System.out.println("Window is already open!");}

	}//runx***************************************************************************************************
    }//remindtask






	class RemindTask_sql_test extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************


		alchemy_database_settings sqltest = new alchemy_database_settings();

		int ix6_here = 0;
		nm.firex = 0;

		while (ix6_here == 0) {

			if (firex == 1) {

				ix6_here = 2; 
				create_button(); 
				setTitle(program_name + " - Database and Sales Management - Running " + program_location + carbon[4][0][13]); 
				repaint(); 
				nm.firex = 0;

			}//***********

			try {Thread.sleep(1000);} catch (InterruptedException e){}

		}//while

		System.out.println("DONE " + nm.firex + " " + ix6_here + " DONE");

	}//runx***************************************************************************************************
    }//remindtask








	class RemindTask_shipping_system_settings extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************


		if (!shipping_settings_open) {

			shipping_settings_open = true;

			dazzle_shipping_settings dazzle = new dazzle_shipping_settings();

			while (shipping_settings_open) {

				//System.out.println("working");

				try {Thread.sleep(1000);} catch (InterruptedException e) {}

			}//while

		}//if****************************


	}//runx***************************************************************************************************
    }//remindtask







	class RemindTask_get_ebay_tokenx extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************


		System.out.println("Get eBay Token.");

		if (!ebay_token_window_open) {

			ebay_token_window_open = true;

		    ebay_gettokenx gtx = new ebay_gettokenx(what_item);

			while (ebay_token_window_open) {

				try {Thread.sleep(1000);} catch (InterruptedException e) {}

			}//while

			tf_userx.setText(ebay_tx);

		}//	


	}//runx***************************************************************************************************
    }//remindtask







	class RemindTask_export_json extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************

		System.out.println("Export JSON");
        json_export gtxxx = new json_export();

	}//runx***************************************************************************************************
    }//remindtask







	class RemindTask_export_csv extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************

		System.out.println("Export CSV");
        csv_export gtxxx = new csv_export();

	}//runx***************************************************************************************************
    }//remindtask








	class RemindTask_display_viewer_x2 extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************

		int ix6_here = 0;
		firex = 0;

		alchemy_display_viewer2 a_rx = new alchemy_display_viewer2();

		while(ix6_here == 0){

			if(firex == 1){ix6_here = 2;}

			System.out.println("DSX");

			try {Thread.sleep(1000);} catch (InterruptedException e) {}

		}//while

	}//runx***************************************************************************************************
    }//remindtask








	class RemindTask_alchemist_export_label extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************

		program_working = 1;
		firex = 0;
		int ix6_here = 0;

		if (what_item > 0) {
	
			choose_ship_system();
			//dazzle_export_label del = new dazzle_export_label();

		}//******************

		System.out.println("Wait for label... start. ix0 " + Integer.toString(ix6_here));

		while (ix6_here == 0) {

			System.out.println("Wait for label...");

			if (firex == 1) {

				ix6_here = 2; 
				sold_button();
				program_working = 0;

				}

			try {Thread.sleep(1000);} catch (InterruptedException e) {System.out.println("98888888");}

		}//while

	}//runx***************************************************************************************************
    }//remindtask








	class RemindTask_export_archive extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************

		int xxxxx = what_item;
		int ix0 = 1;

		for (int loop2 = xxxxx; loop2 > 0; loop2--) {//**************************************

			infox1.setText("Uploading... " + Integer.toString(ix0) + " of " + Integer.toString(xxxxx));
			
			what_item = loop2;

			if (db_number == 2) {

				alchemy_shipping_system_order_sold ssox = new alchemy_shipping_system_order_sold();

			}//******************
			else if (db_number == 3) {

				alchemy_shipping_system_order_archive ssox = new alchemy_shipping_system_order_archive();

			}//***********************

			ix0++;

		}//for*******************************************************************************


	}//runx***************************************************************************************************
    }//remindtask







	class RemindTask_test_for_quantity extends TimerTask {
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************


		int ix0 = carbon[0][0].length;

		for (int xloop0 = 1; xloop0 < ix0; xloop0++) {//**************
	
			if (db_number != 0) {

				break;

			}//******************



			int ix1 = xloop0;

			carbon[0][total_on_hand_xx][ix1] = test_for_quantity();

			infox1.setText(Integer.toString(xloop0) + " of " + Integer.toString((ix0 -1)) + " Quantity of " + carbon[0][part_number_xx][ix1] + " is " + carbon[0][total_on_hand_xx][ix1]);
			//display_item();

			if (db_number != 0) {

				break;

			}//******************

		}//*******************************************************

		//display_item();


	}//runx***************************************************************************************************
    }//remindtask







	class RemindTask_custom_update extends TimerTask {
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************


		int ix0 = carbon[0][0].length;

		for (int xloop0 = 1; xloop0 < ix0; xloop0++){//**************

			if (db_number != 0) {

				break;

			}//******************


			int ix1 = xloop0;

			carbon[0][custom_select][ix1] = custom_update();

			infox1.setText(Integer.toString(xloop0) + " of " + Integer.toString((ix0 -1)) + " Value of " + db_string[custom_select] + " is " + carbon[0][custom_select][ix1]);

			//display_item();

			if (db_number != 0) {break;}

		}//*******************************************************


	}//runx***************************************************************************************************
    }//remindtask







	class RemindTask_ebay_update_quantity extends TimerTask {
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************

		infox1.setText("Start eBay inventory update.");


		for (int xloop0 = 1; xloop0 < carbon[0][0].length; xloop0++) {//**************

			if (!carbon[0][ebay_item_xx][xloop0].equals("ebay_item") && carbon[0][ebay_item_xx][xloop0].length() > 2) {

				ebay_update_quantity ebay_xx = new ebay_update_quantity(xloop0);

				infox1.setText("eBay update inventory " + Integer.toString(xloop0) + " of " + Integer.toString(carbon[0][0].length -1));

			}//********************************************************************************************************

		}//**************************************************************************

		infox1.setText("eBay inventory update: Done.");

	}//runx***************************************************************************************************
    }//remindtask







	class RemindTask_ebay_update_sale_prices extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {


		infox1.setText("Start eBay Sale Price update.");

		for (int xloop0 = 1; xloop0 < carbon[0][0].length; xloop0++) {//**************

			if (!carbon[0][ebay_item_xx][xloop0].equals("ebay_item") && carbon[0][ebay_item_xx][xloop0].length() > 9) {

				if (!carbon[0][item_price_xx][xloop0].equals("item_price")) {

					ebay_update_sale_price ebay_xx = new ebay_update_sale_price(xloop0);

					infox1.setText("eBay update sale price " + Integer.toString(xloop0) + " of " + Integer.toString(carbon[0][0].length -1));

				}//**********************************************************

			}//*********************************************************************************************************

		}//**************************************************************************

	}//runx
    }//remindtask








	class RemindTask_update_warehouse_1 extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************

		int ix0 = 1;
		firex = 0;

		String pass_com = "0";

		infox1.setText("Export warehouse inventory (0 of " + Integer.toString(carbon[0][0].length) + ")");

		for (int xloop = 1; xloop < carbon[0][0].length; xloop++) {//********

			alchemy_update_warehouse_inventory ddg = new alchemy_update_warehouse_inventory(xloop); 

			infox1.setText("Export warehouse inventory (" + Integer.toString(xloop) + " of " + Integer.toString(carbon[0][0].length) + ") " + pass_com);

		}//for**************************************************************

		infox1.setText("Update Inventory: " + pass_com);



	}//runx***************************************************************************************************
    }//remindtask






	class RemindTask_alchemist_delete_items extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************

		int ix6_here = 0;
		firex = 0;

		delete_db_item();

		while (ix6_here == 0) {

			if (firex == 1) {

				ix6_here = 2;

			}//**************

			try {Thread.sleep(1000);} catch (InterruptedException e) {System.out.println("98709870987");}

		}//while


	}//runx***************************************************************************************************
    }//remindtask





	class RemindTask_copy_to extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************

		int ix6_here = 0;
		firex = 0;

		alchemy_copy_to a_rx_copy_to = new alchemy_copy_to();

		while (ix6_here == 0) {

			if (firex == 1) {

				ix6_here = 2; 

				if (db_number == 0) {create_button();}
				if (db_number == 1) {sold_button();}
				if (db_number == 2) {archive_button();}

			}//********************		


			try {Thread.sleep(1000);} catch (InterruptedException e) {System.out.println("Working...");}

		}//while


	}//runx***************************************************************************************************
    }//remindtask








	class RemindTask_export_settings extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************

		System.out.println("export settings");
        alchemy_export_settings gtxxx = new alchemy_export_settings();

		int ix6_here = 0;
		firex = 0;


		while (ix6_here == 0) {

			if (firex == 1) {

				ix6_here = 2;

			}

			try {Thread.sleep(1000);} catch (InterruptedException e) {}

		}//while



	}//runx***************************************************************************************************
    }//remindtask







	class RemindTask_update_csv_inventory extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************

		System.out.println("UP IN");
        csv_update_inventory gtxxxe = new csv_update_inventory();

		int ix6_here = 0;
		firex = 0;


		while (ix6_here == 0) {

			if (firex == 1) {

				ix6_here = 2;
				create_button();

			}

			try {Thread.sleep(1000);} catch (InterruptedException e) {}

		}//while



	}//runx***************************************************************************************************
    }//remindtask






	class RemindTask_shipping_settings_online extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************

		System.out.println("Shipping Setting");

		if (!alchemy_shipping_settings) {

			alchemy_shipping_settings = true;


	        alchemy_shipping_settings gtxxddxe = new  alchemy_shipping_settings();

			while (alchemy_shipping_settings) {


				try {Thread.sleep(1000);} catch (InterruptedException e){}

			}//while


		}//***************************


	}//runx***************************************************************************************************
    }//remindtask





	class RemindTask_alchemist_viewer extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************

		System.out.println("Viewer");

		int ix6_here = 0;
		firex = 0;
		html_view_number = 3;

        alchemy_view gtxxxddxe = new alchemy_view();

		while (ix6_here == 0) {

			if (firex == 1) {

				ix6_here = 2;

			}

			try {Thread.sleep(1000);} catch (InterruptedException e){}

		}//while



	}//runx***************************************************************************************************
    }//remindtask






	class RemindTask_frame_builder extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************

		what_item_frame = what_item;
		what_item = 0;
		what_item_old = 0;

		create_button();

		System.out.println("Viewer");
        alchemy_frame_builder gtxxdde = new alchemy_frame_builder();

		int ix6_here = 0;
		firex = 0;


		while (ix6_here == 0) {

			if (firex == 1) {

				create_button(); 

				ix6_here = 2;

			}//**************

			try {Thread.sleep(1000);} catch (InterruptedException e){}

		}//while


	}//runx***************************************************************************************************
    }//remindtask










	class RemindTask_amazon_inventory extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************


		int ix6_here = 0;
		firex = 0;

		System.out.println("RemindTask_amazon_inventory");

		infox1.setText("Update Amazon Inventory " + Integer.toString(1) + " of " + Integer.toString(carbon[0][0].length -1));

		for (int xloop0 = 1; xloop0 < carbon[0][0].length; xloop0++) {//**************

			if (carbon[0][listing_id_xx][xloop0].equals("listing_id")) {infox1.setText("listing_id");}
			else if (carbon[0][listing_id_xx][xloop0].equals("listing_id")) {infox1.setText("listing_id");}
			else {

				what_item_amazon_update = xloop0;
        		amazon_update_inventory gtxxx22ddxe = new amazon_update_inventory();
				infox1.setText("Update Amazon Inventory " + Integer.toString(xloop0) + " of " + Integer.toString(carbon[0][0].length -1));

				try {Thread.sleep(1000);} catch (InterruptedException e){}

			}//else

		}//*************************************************************************


		while (ix6_here == 0) {

			if (firex == 1) {ix6_here = 2;}

			try {Thread.sleep(1000);} catch (InterruptedException e){}

		}//while



	}//runx***************************************************************************************************
    }//remindtask






	class RemindTask_amazon_sale_price extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run() {//************************************************************************************


		System.out.println("RemindTask_amazon_sale_price");

		infox1.setText("Update Amazon Sale Prices " + Integer.toString(1) + " of " + Integer.toString(carbon[0][0].length -1));


		for (int xloop0 = 1; xloop0 < carbon[0][0].length; xloop0++) {//************

			what_item_amazon_update = xloop0;
        	amazon_update_price gtxx1xddxe = new amazon_update_price();
			infox1.setText("Update Amazon Sale Prices " + Integer.toString(xloop0) + " of " + Integer.toString(carbon[0][0].length -1));

		}//*************************************************************************



		int ix6_here = 0;
		firex = 0;


		while (ix6_here == 0) {

			if (firex == 1) {

				ix6_here = 2;

			}

			try{Thread.sleep(1000);} catch(InterruptedException e){}

		}//while



	}//runx**************************************************************************************************
    }//remindtask












	class RemindTask_order_system extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();


	public void run(){//************************************************************************************

		System.out.println("order_system " + order_system_open);
	
		if (!order_system_open) {//*******************
	
       	 	alchemy_order_system gtxxx_xx = new alchemy_order_system();

			order_system_open = true;
			int ix6_here = 0;
			firex = 0;

			while (ix6_here == 0) {

				if (firex == 1) {

					ix6_here = 2;

					order_system_open = false;

				}//*************

				try {Thread.sleep(1000);} catch (InterruptedException e) {}

			}//while


		}//*********************************************

	}//runx***************************************************************************************************
    }//remindtask













//runtime**************************************************************************
//runtime**************************************************************************






//**********************************************************************************************************************************
//**********************************************************************************************************************************



	public void titles_xx() {

		try {

			tabbedPane.setTitleAt(0, "Export (" + (db_00_size) + ")");
			tabbedPane.setTitleAt(1, "Monitor (" + (carbon[1][0].length) + ")");
			tabbedPane.setTitleAt(2, "Sold (" + (db_02_size) + ")");
			tabbedPane.setTitleAt(3, "Archived (" + (db_03_size) + ")");
			tabbedPane.setTitleAt(5, "Connections (" + (carbon[5][0].length) + ")");

		} catch (Exception e) {}

	}//titles**






	public void reset_ss_click() {

		if (what_item_selected <= (carbon[db_number][0].length -1)) {

			what_item = what_item_selected;

		}
		else {

			what_item = (carbon[db_number][0].length -1);

		}

	}//**************************






	public void create_button() {

		System.out.println("CREATE BUTTON 0");

		//Reload the database.
		jdb_loader_items loadc = new jdb_loader_items();
		carbon[0] = loadc.loadItems(load_limit, items_page0_start, db_cc_number, sort_string);
		db_00_size = loadc.getDBSize();

		//we don't want the system reloading if the user clicks the sort button.
		searching = false;

		//The database number we are viewing.
		db_number = 0;

		//The select buttons on the left of the display.
		set_select_on();

		//Arrage numbers to database fields.
		//set_numbers();

		//Set our total number of items we are displaying
		items_total = carbon[0][0].length;

		//Set the titles on the tabs
		titles_xx();

		//Set all buttons on or off.
		set_button_on_off();

		//The bottom JPanels below the display
		jpk2_solid.removeAll();
		jpk2_solid.add(jpk0x);
	
		//Reset the selected values to our new database.
		//selected_int = new int[items_total];

		//What page are we on.
		set_300_page();

		//Get the position of the right slider bar. 
		set_fire_slider();

		//Display change on a new click.
		display_save_item0();

		//Sort the items before they are sent to the display.
		sortx_engine();

		//Display system build.
		int[] warningsx = test_warnings();
		int[] errorsx = test_errors();
		show_errors();
		dxengine0.setWarningList(warningsx);
		dxengine0.setErrorList(errorsx);
		String[][][] export_display_list = build_export_display_list();
		dxengine0.setHeaderList(export_display_list[1]);
		dxengine0.setSizeList(export_display_list[2]);
		dxengine0.displayx(export_display_list[0], xzx - 10, 360, what_item_display);

		//Reset the size of the scrollpane.
		refreshx();

		//Refresh the whole swing system.
		repaint();

		//Quick save the settings. 
		save_settings_pp();

		//Show the user some info.
		infox0.setText("Export section (DB0)");
		infox1.setText("Use this section to create items for export.");

	}//*************************





	public void monitor_button() {

		set_select_off();

		db_number = 1;

 		//set_numbers();
		items_total = carbon[1][0].length;
		titles_xx();

		submit.setEnabled(false);
		importx.setEnabled(false);
		refresh.setEnabled(true);
		print_shipping.setEnabled(false);
		archivex.setEnabled(false);
		new_item.setEnabled(false);
		edit_item.setEnabled(false);
		delete.setEnabled(false);
		view_item.setEnabled(false);
		empty_site.setEnabled(true);

		jpk2_solid.removeAll();
		jpk2_solid.add(jpk1x);

		set_button_on_off();

		selected_int = new int[items_total];
  		set_300_page();
		set_fire_slider();   

		display_save_item1();

		int size_listx1[] = {250,500,150,150,150,150,150};
		dxengine1.setSizeList(size_listx1);
		String[][] monitor_display_list = build_monitor_display_list();
		dxengine1.displayx(monitor_display_list, xzx - 10, 360, 1);

		repaint();
		reset_ss_click();
		save_settings_pp();

		infox0.setText("Monitor section (DB1)");
		infox1.setText("Monitor your attached web sites and view stats. ");

	}//*************************





	public void sold_button() {

		//Rebuild the database.
		jdb_loader_sales loads = new jdb_loader_sales();
		carbon[2] = loads.loadItems(load_limit, items_page2_start, db_cc_number, "date_sold");
		db_02_size = loads.getDBSize();

		db_number = 2;

		set_select_on();
 		//set_numbers();
		items_total = carbon[2][0].length;
		titles_xx();

		submit.setEnabled(true);
		importx.setEnabled(true);
		refresh.setEnabled(false);
		print_shipping.setEnabled(true);
		archivex.setEnabled(true);
		new_item.setEnabled(false);
		edit_item.setEnabled(false);
		delete.setEnabled(true);
		view_item.setEnabled(false);
		empty_site.setEnabled(false);

		jpk2_solid.removeAll();
		jpk2_solid.add(jpk2x);

		set_button_on_off();

		selected_int = new int[items_total];
  		set_300_page();
		set_fire_slider();

		display_save_item2();

		sortx_engine2();

		String[][][] sold_display_list = build_sold_display_list();
		dxengine2.setHeaderList(sold_display_list[1]);
		dxengine2.setSizeList(sold_display_list[2]);
		dxengine2.displayx(sold_display_list[0], xzx - 10, 360, what_item_display);

		repaint();
		reset_ss_click();
		save_settings_pp();

		infox0.setText("Import sales (DB2)");
		infox1.setText("Import sales from online databases. ");

	}//*************************





	public void archive_button() {

		//Rebuild the database.
		jdb_loader_archive loada = new jdb_loader_archive();
		carbon[3] = loada.loadItems(load_limit, items_page3_start, db_cc_number, "date_sold");
		db_03_size = loada.getDBSize();

		db_number = 3;

		set_select_on();
		//set_numbers();
		items_total = carbon[3][0].length;
		titles_xx();

		submit.setEnabled(true);
		importx.setEnabled(true);
		refresh.setEnabled(false);
		print_shipping.setEnabled(false);
		archivex.setEnabled(false);
		new_item.setEnabled(false);
		edit_item.setEnabled(false);
		delete.setEnabled(true);
		view_item.setEnabled(false);
		empty_site.setEnabled(true);

		jpk2_solid.removeAll();
		jpk2_solid.add(jpk3x);

		set_button_on_off();

		selected_int = new int[items_total];
  		set_300_page();
		set_fire_slider();

		display_save_item3();

		sortx_engine3();

		String[][][] archive_display_list = build_archive_display_list();
		dxengine3.setHeaderList(archive_display_list[1]);
		dxengine3.setSizeList(archive_display_list[2]);
		dxengine3.displayx(archive_display_list[0], xzx - 10, 360, what_item_display);

		repaint();
		reset_ss_click();
		save_settings_pp();

		infox0.setText("Archive old items (DB3)");
		infox1.setText("Archived items and sales that are no longer needed on the sales page.");

	}//*************************






	public void settings_button() {

		set_select_off();

		db_number = 4;

		items_total = db_ss_number;

		submit.setEnabled(false);
		importx.setEnabled(false);
		refresh.setEnabled(false);
		print_shipping.setEnabled(false);
		archivex.setEnabled(false);
		new_item.setEnabled(false);
		edit_item.setEnabled(false);
		delete.setEnabled(false);
		view_item.setEnabled(false);
		empty_site.setEnabled(false);

		jpk2_solid.removeAll();
		jpk2_solid.add(jpk4x);

		set_button_on_off();

		selected_int = new int[items_total];
  		set_300_page();
		set_fire_slider();

		int size_listx4[] = {250,500};
		dxengine4.setSizeList(size_listx4);
		String[][] settings_display_list = build_settings_display_list();
		dxengine4.displayx(settings_display_list, xzx - 10, 360, 0);

		refreshx();
		repaint();
		save_settings_pp();

		item_label4.setText("These items are created by the program and cannot be edited.");
		infox0.setText("Settings viewer (DB4)");
		infox1.setText("View the settings of this database.");

	}//*************************





	public void websites_button() {
 
		set_select_off();

		db_number = 5;
		
		items_total = carbon[5][0].length;
		titles_xx();

		submit.setEnabled(true);
		importx.setEnabled(true);
		refresh.setEnabled(false);
		print_shipping.setEnabled(false);
		archivex.setEnabled(false);
		new_item.setEnabled(true);
		edit_item.setEnabled(true);
		delete.setEnabled(true);
		view_item.setEnabled(false);
		empty_site.setEnabled(false);

		jpk2_solid.removeAll();
		jpk2_solid.add(jpk5x);

		set_button_on_off();

		selected_int = new int[items_total];
   		set_300_page();
		set_fire_slider();

		int size_listx5[] = {200,500,150,150,150,150};
		dxengine5.setSizeList(size_listx5);
		String[][] connections_display_list = build_connections_display_list();
		dxengine5.displayx(connections_display_list, xzx - 10, 360, 1);

		refreshx();
		repaint();
		save_settings_pp();

		infox0.setText("Add online databases (DB5)");
		infox1.setText("Create and update online database accounts. So you can connect to them.");

		display_save_item5();

	}//*************************





	public void display_button() {

		set_select_off();

		db_number = 6;

		submit.setEnabled(false);
		importx.setEnabled(false);
		refresh.setEnabled(false);
		print_shipping.setEnabled(false);
		archivex.setEnabled(false);
		new_item.setEnabled(false);
		edit_item.setEnabled(false);
		delete.setEnabled(false);
		view_item.setEnabled(false);
		empty_site.setEnabled(false);

		jpk2_solid.removeAll();
		jpk2_solid.add(jpk6x);

		set_button_on_off();

		items_total = 300;
		selected_int = new int[items_total];
  		set_300_page();
		set_fire_slider();
		//items_value = items_end - items_start;

		int size_listx6[] = {250,250,150,150,150,150};
		dxengine6.setSizeList(size_listx6);
		String[][] arrange_display_list = build_arrange_display_list();
		dxengine6.displayx(arrange_display_list, xzx - 10, 360, 0);

		refreshx();
		repaint();
   		//requestFocus();
		save_settings_pp();

		item_label5.setText("Low level display settings for database fields.");
		infox0.setText("Display viewer (DB6)");
		infox1.setText("View the display settings of this database.");

		display_save_item6();

	}//*************************







//**********************************************************************************************************************************
//**********************************************************************************************************************************

//sort





	public void sortx_engine() {//******************************************************************************************************

		try {

			System.out.println("Sort...");

			
			//Arrays.sort(carbon[0][sort_int], 1, carbon[0][sort_int].length);


			String[][] data = new String[carbon[0][sort_int].length][2];

			for (int xloopx = 0; xloopx < carbon[0][sort_int].length; xloopx++) {//****

				data[xloopx][0] = carbon[0][sort_int][xloopx];
				data[xloopx][1] = new String(Integer.toString(xloopx));

			}//************************************************************************



       		Arrays.sort(data, 0, carbon[0][sort_int].length, new Comparator<String[]>() {

	            @Override
	            public int compare(final String[] entry1, final String[] entry2) {

	                final String time1 = entry1[0];
	                final String time2 = entry2[0];
	                return time1.compareTo(time2);

	            }//***************************************************************

       		});

        	for (final String[] s : data) {

            	//System.out.println(s[1] + " " + s[0]);

        	}



			String[][] data2 = new String[carbon[0].length][carbon[0][sort_int].length];


			for (int xloop0 = 0; xloop0 < carbon[0][sort_int].length; xloop0++) {//****

				for (int xloop1 = 0; xloop1 < carbon[0].length; xloop1++) {//****

					data2[xloop1][xloop0] = carbon[0][xloop1][ Integer.parseInt(data[xloop0][1]) ];

				}//**************************************************************

			}//************************************************************************


			carbon[0] = data2;


		} catch (Exception e) {}

		//throw new ArithmeticException("/ by zero");

	}//sort*********************************************************************************************************************









	public void sortx_engine2() {//******************************************************************************************************

		try {

			System.out.println(date_sold_xx + " " + carbon[2][date_sold_xx][0]);

			String[][] data = new String[carbon[2][date_sold_xx].length][2];

			for (int xloopx = 0; xloopx < carbon[2][date_sold_xx].length; xloopx++) {//******

				data[xloopx][0] = carbon[2][63][xloopx];
				data[xloopx][1] = new String(Integer.toString(xloopx));

			}//******************************************************************************



        	Arrays.sort(data, 0, carbon[2][date_sold_xx].length, new Comparator<String[]>() {
            
            	@Override
	            public int compare(final String[] entry1, final String[] entry2) {

	                final String time1 = entry1[0];
	                final String time2 = entry2[0];
	                return time1.compareTo(time2);

	            }

        	});

        	for (final String[] s : data) {

            	//System.out.println(s[1] + " " + s[0]);

        	}



			String[][] data2 = new String[carbon[2].length][carbon[2][date_sold_xx].length];


			for (int xloop0 = 0; xloop0 < carbon[2][date_sold_xx].length; xloop0++) {//******

				for (int xloop1 = 0; xloop1 < carbon[2].length; xloop1++) {//******

					if (xloop0 == 0) {

						data2[xloop1][xloop0] = carbon[2][xloop1][ Integer.parseInt(data[xloop0][1]) ];

					}
					else {

						data2[xloop1][((carbon[2][date_sold_xx].length) - xloop0)] = carbon[2][xloop1][ Integer.parseInt(data[xloop0][1]) ];

					}

				}//**************************************************************

			}//****************************************************************************


			carbon[2] = data2;

			//this will be called twice
			//display_item();

		} catch(Exception e) {}

	}//sort*********************************************************************************************************************









	public void sortx_engine3() {//******************************************************************************************************

		try {

			System.out.println(date_sold_xx + " " + carbon[3][date_sold_xx][0]);

			String[][] data = new String[carbon[3][date_sold_xx].length][2];

			for (int xloopx = 0; xloopx < carbon[3][date_sold_xx].length; xloopx++) {//****

				data[xloopx][0] = carbon[3][63][xloopx];
				data[xloopx][1] = new String(Integer.toString(xloopx));

			}//****************************************************************************



        	Arrays.sort(data, 0, carbon[3][date_sold_xx].length, new Comparator<String[]>() {

            	@Override
            	public int compare(final String[] entry1, final String[] entry2) {
                	final String time1 = entry1[0];
                	final String time2 = entry2[0];
                	return time1.compareTo(time2);
            	}

       		});



			String[][] data2 = new String[carbon[3].length][carbon[3][date_sold_xx].length];


			for(int xloop0 = 0; xloop0 < carbon[3][date_sold_xx].length; xloop0++){//******

				for(int xloop1 = 0; xloop1 < carbon[3].length; xloop1++){//******

					if (xloop0 == 0) {

						data2[xloop1][xloop0] = carbon[3][xloop1][ Integer.parseInt(data[xloop0][1]) ];

					}
					else {

						data2[xloop1][((carbon[3][date_sold_xx].length) - xloop0)] = carbon[3][xloop1][ Integer.parseInt(data[xloop0][1]) ];

					}

				}//***************************************************************

			}//****************************************************************************


			carbon[3] = data2;

			//this is already used on the button 
			//display_item();

		}catch(Exception e){}

	}//sort*********************************************************************************************************************







//search**************************************************************************************************


	public void searchx() {

		System.out.println("Search x");

	

		if (db_number == 0) {

			//we don't want the system reloading if the user clicks the sort button.
			searching = true;

			System.out.println("search_tf         " + search_tf.getText());
			System.out.println("what_search_field " + db_string[what_search_field]);

			jdb_search_items searchs = new jdb_search_items();
			String[][] serachx = searchs.searchItems(search_tf.getText(), db_string[what_search_field], search_load_limit, db_cc_number);

			carbon[0] = serachx;

			int[] warningsx = test_warnings();
			int[] errorsx = test_errors();
			show_errors();
			dxengine0.setWarningList(warningsx);
			dxengine0.setErrorList(errorsx);

			String[][][] export_display_list = build_export_display_list();
			dxengine0.setHeaderList(export_display_list[1]);
			dxengine0.setSizeList(export_display_list[2]);
			dxengine0.displayx(export_display_list[0], xzx - 10, 360, what_item_display);

			framesPerPage0.setMaximum(0);

			refreshx();
			repaint();

			infox1.setText("Search returned " + carbon[0][0].length + " items. Limit " + search_load_limit);

		}//******************
		else if(db_number == 2) {

			System.out.println("search_tf         " + search_tf.getText());
			System.out.println("what_search_field " + db_string[what_search_field]);

			jdb_search_sales searchs = new jdb_search_sales();
			String[][] serachx = searchs.searchItems(search_tf.getText(), db_string[what_search_field], search_load_limit, db_cc_number);

			carbon[2] = serachx;




			String[][][] sold_display_list = build_sold_display_list();
			dxengine2.setHeaderList(sold_display_list[1]);
			dxengine2.setSizeList(sold_display_list[2]);
			dxengine2.displayx(sold_display_list[0], xzx - 10, 360, what_item_display);

			framesPerPage2.setMaximum(0);

			refreshx();
			repaint();

			infox1.setText("Search returned " + carbon[2][0].length + " items. Limit " + search_load_limit);

		}//**********************
		else if (db_number == 3) {

			System.out.println("search_tf         " + search_tf.getText());
			System.out.println("what_search_field " + db_string[what_search_field]);

			jdb_search_archive searchs = new jdb_search_archive();
			String[][] serachx = searchs.searchItems(search_tf.getText(), db_string[what_search_field], search_load_limit, db_cc_number);

			carbon[3] = serachx;

			String[][][] archive_display_list = build_archive_display_list();
			dxengine3.setHeaderList(archive_display_list[1]);
			dxengine3.setSizeList(archive_display_list[2]);
			dxengine3.displayx(archive_display_list[0], xzx - 10, 360, what_item_display);

			framesPerPage3.setMaximum(0);

			refreshx();
			repaint();

			infox1.setText("Search returned " + carbon[3][0].length + " items. Limit "  + search_load_limit);

		}//***********************



	}//searchx************




//search**********************************************************************************************************************************
//search**********************************************************************************************************************************

//delete*******************************************************************************************************************
//delete*******************************************************************************************************************



	public void array_remove() {

		int ix0 = 0;
		int ix1 = 0;


		//reset total on hand
		if (db_number == 2 && delete_flag_change_inventory) {

			for (int xloop = 0; xloop < carbon[2][part_number_xx].length; xloop++) {//****

				if (selected_int[xloop] == 1){

					for (int xloop2 = 0; xloop2 < carbon[0][part_number_xx].length; xloop2++) {//*************

						if (carbon[0][part_number_xx][xloop2].equals(carbon[2][part_number_xx][xloop])) {

							//update_inventory
							try {

								carbon[0][total_on_hand_xx][xloop2] = Integer.toString( (Integer.parseInt(carbon[0][total_on_hand_xx][xloop2]) + Integer.parseInt(carbon[2][quantity_sold_xx][xloop])) );
								jdb_driver.s.execute("UPDATE listings SET total_on_hand='" + carbon[0][total_on_hand_xx][xloop2] + "' WHERE part_number='" + carbon[0][part_number_xx][xloop2] + "'");
								carbon[2][quantity_sold_xx][xloop] = "0";

								infox1.setText("Updating " + carbon[2][item_id_xx][xloop] + ".");
								System.out.println("Updating " + carbon[2][item_id_xx][xloop] + ".");

								break;

							} catch (Exception e) {e.printStackTrace(); System.out.println("Inventory update failed!");}

		        		}//if**************************************************************************

					}//**************************************************************************************

				}//if************************

			}//*************************************************************************

		}//***************************************************
		//reset total on hand 



		int first_item = 0;
		boolean foundx = false;

		for (int xloop = 0; xloop < carbon[db_number][0].length; xloop++) {//******

			if (selected_int[xloop] == 1) {

				if (!foundx) {

					first_item = xloop; 
					foundx = true;

				}//***********

				ix1++;

				try {

					if (db_number == 0) {

						jdb_driver.s.execute("DELETE FROM listings WHERE item_id='" + carbon[0][item_id_xx][xloop] + "'");

					}
					else if (db_number == 2) {

						jdb_driver.s.execute("DELETE FROM sold WHERE sale_id='" + carbon[2][sale_id_xx][xloop] + "'"); 
						
						if (!archiving_flag) {

							jdb_driver.s.execute("DELETE FROM archived_sales_ids WHERE ids='" + carbon[2][sale_id_xx][xloop] + "'");

						}//*******************

					}//*********************
					else if (db_number == 3) {

						jdb_driver.s.execute("DELETE FROM archived WHERE sale_id='" + carbon[3][sale_id_xx][xloop] + "'"); 
						jdb_driver.s.execute("DELETE FROM archived_sales_ids WHERE ids='" + carbon[3][sale_id_xx][xloop] + "'");

					}
					else if (db_number == 5) {

						jdb_driver.s.execute("DELETE FROM connections WHERE con100='" + carbon[5][transaction_info_xx][xloop] + "'"); 
						jdb_driver.s.execute("DELETE FROM monitor WHERE transaction_info='" + carbon[5][transaction_info_xx][xloop] + "'");

					}

					infox1.setText("Deleting " + carbon[db_number][item_id_xx][xloop] + ".");
					System.out.println("Deleting " + carbon[db_number][item_id_xx][xloop] + ".");

				} catch (Exception e) {}

			}//if**********************

		}//**********************************************************************


		System.out.println("xx " + ix1);
		String ppx[][] = new String[carbon[db_number].length][(carbon[db_number][0].length - ix1)];


		System.out.println("xxx " + ppx[0].length);
		System.out.println("xxxx " + ix1);


		for (int xloop1 = 0; xloop1 < carbon[db_number][0].length; xloop1++) {//******

			for (int xloop2 = 0; xloop2 < carbon[db_number].length; xloop2++) {//***
 
				//System.out.println("pppp " + xloop1 + " " + ix0);

				if (ix0 == ppx[0].length) {

					break;

				}//************************

				ppx[xloop2][ix0] = carbon[db_number][xloop2][xloop1];
				//System.out.println(ppx[49][ix0]);

			}//*******************************************************************

			if (ix0 == ppx[0].length) {

				break;

			}
			else if (selected_int[xloop1] != 1) {

				ix0++;

			}
			else {

				infox0.setText("delete " + xloop1); 
				System.out.println(ppx[49][ix0]);

			}

		}//*************************************************************************


		//what_item_old = 0;
		carbon[db_number] = ppx;
		items_total = carbon[db_number][0].length;
		items_value = items_end - items_start;

		//JOptionPane.showMessageDialog(null, Integer.toString(what_item) + " " + Integer.toString(what_item_old) + " " + Integer.toString(first_item));

		//reset the selected item.
		if (what_item > carbon[db_number][0].length) {

			what_item = carbon[db_number][0].length;
			what_item_old = 0;

		}
		else {what_item = first_item;}

		//JOptionPane.showMessageDialog(null, Integer.toString(what_item) + " " + Integer.toString(what_item_old) + " " + Integer.toString(first_item));

		//pressx = 0; 
		//pressx_repaint = 1;

		//selected_int = new int[items_value];
		//display_item();

	}//remove*****************





	public void delete_item() {

		//selected_int[0] = 0;

		//items_total = carbon[db_number][0].length;
		//items_value = items_end - items_start;
		array_remove();

		jdb_loader_titles titlesc = new jdb_loader_titles();
		titles_xx();

		//update the ids list
		jdb_update_sale_ids update = new jdb_update_sale_ids();

		//test for errors in dispay 
		System.out.println("LENGTH " + carbon[db_number][0].length);
		if (what_item > carbon[db_number][0].length) {

			what_item = 0; 
			what_item_old = 0;

		}//*******************************************

		//reset the fields
		if (db_number == 0)      {create_button();}
		else if (db_number == 2) {sold_button();}
		else if (db_number == 3) {archive_button();}
		else if (db_number == 5) {websites_button();}

	}//delete***************






//delete*******************************************************************************************************************
//delete*******************************************************************************************************************



	public void archive_db(){

		int response123 = JOptionPane.showConfirmDialog(null,"Archive Sale(s)?");
		if (response123 == 0) {

			//jdb_load_sales_ids

			int ilx0 = 0;

			for (int xloopw = 0; xloopw < carbon[2][0].length; xloopw++) {//****

				if (selected_int[xloopw] == 1){ilx0++;}

			}//*****************************************************************


			int ilx1 = ilx0 + carbon[3][0].length;


			String[][] xcxa = new String[db_cc_number][ilx1];
			String[][] xcxb = new String[db_cc_number][ilx0];//for db

			System.out.println("xcxa " + ilx1);
			System.out.println("xcxb " + ilx0);

			int ilx2 = 0;

			System.out.println("ilx2 " + ilx2 + " " + ilx1);

			for (int xloopw = 0; xloopw < carbon[2][0].length; xloopw++) {//************

				for (int xloop = 0; xloop < carbon[2].length; xloop++) {//******

					if (selected_int[xloopw] == 1) {xcxa[xloop][ilx2] = new String(carbon[2][xloop][xloopw]);}
					if (selected_int[xloopw] == 1) {xcxb[xloop][ilx2] = new String(carbon[2][xloop][xloopw]);}

				}//for********************************************************
				
				if (selected_int[xloopw] == 1) {

					ilx2++;

				}//*****************************

			}//for********************************************************************

			jdb_new_archive newacv = new jdb_new_archive(xcxb);


			for(int xloopw = 0; xloopw < carbon[3][0].length; xloopw++){//************

				for(int xloop = 0; xloop < carbon[3].length; xloop++){//******

					xcxa[xloop][ilx2] = new String(carbon[3][xloop][xloopw]);

				}//for********************************************************

				ilx2++;

			}//for********************************************************************


			carbon[3] = xcxa;

			what_item_old_select = 0;
			what_item_old = 0;
			what_item = 0;

			delete_flag_change_inventory = false;
			archiving_flag = true;
			delete_item();
			archiving_flag = false;

			jdb_loader_titles titlesx = new jdb_loader_titles();
			titles_xx();

		}//***************response

	}//********************archive







//timers********************
//timers********************



	public void update_inventory_thread(){

		response = JOptionPane.showConfirmDialog(null, "Update inventory from csv?");
 		if(response == 0){

    		toolkit = Toolkit.getDefaultToolkit();
    		xtimerx = new Timer();
    		xtimerx.schedule(new RemindTask_update_csv_inventory(), 0);

		}//***************************************

	}//replace




	public void replace_xx(){

		if (!replace_window_open) {

	    	toolkit = Toolkit.getDefaultToolkit();
	    	xtimerx = new Timer();
	    	xtimerx.schedule(new RemindTask_replace_window(), 0);

    	}
    	else{System.out.println("Replace window is already open...");}

	}//replace




	public void replace_xxx(){

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_rxxx(), 0);

	}//replace




	public void replace_tool() {
	System.out.println("run replace.");

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_rt(), 0);

	}//replace




	public void bt_import() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_2(), 0);

	}//********************




	public void ship_rates_settings() {

		alchemy_shipping_settings ss = new alchemy_shipping_settings();

	}//******************************




	public void combo_tool() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_combo_tool(), 0);

	}//********************




	public void combo_tool2(){

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_combo_tool2(), 0);

	}//********************




	public void combo_tool3() {

		System.out.println("Combo Tool 3 (1 + 1) " + total_items_selected);
	
		if (total_items_selected != 2) {JOptionPane.showMessageDialog(null,"You must select 2 items to combine.");}
		else {

			int ix0 = Integer.parseInt(carbon[0][total_on_hand_xx][what_item0]);
			int ix1 = Integer.parseInt(carbon[0][total_on_hand_xx][what_item]);

			if (ix0 < 1 || ix1 < 1) {JOptionPane.showMessageDialog(null,"BOTH items must have stock on hand!");}
			else {

				if (carbon[0][part_number_xx][what_item0].contains("[COMBO]") || carbon[0][part_number_xx][what_item].contains("[COMBO]")) {JOptionPane.showMessageDialog(null,"You cannot COMBO COMOS!");}
				else {//******************


					try {

						for (int xloop2 = 0; xloop2 < (carbon[0][0].length); xloop2++) {//******

							if (carbon[0][part_number_xx][xloop2].equals("[COMBO][" + carbon[0][item_id_xx][what_item0] + "][" + carbon[0][item_id_xx][what_item] + "]")){throw new IllegalArgumentException("COMBO3");}
							//if(carbon[0][part_number_xx][xloop2].equals("[COMBO][" + carbon[0][item_id_xx][what_item] + "][" + carbon[0][item_id_xx][what_item0] + "]")){throw new IllegalArgumentException("COMBO3");}

						}//*******************************************************************

						try {
							
							combo_generator3 cg3 = new combo_generator3();
							create_button();

						} catch (Exception e) {

							e.printStackTrace(); 
							infox1.setText("Build Failed."); 
							JOptionPane.showMessageDialog(null,"Build Failed.");

						}

					} catch (Exception e) {JOptionPane.showMessageDialog(null,"COMBO already exists.");}

		

				}//else******************

			}//else

		}//else


	}//***********************



	

	public void combo_tool_price() {

		System.out.println("Combo Price tool");
	
		int xx_int = 0;
		Float xx_fnt0 = (float) 0.0;
		Float xx_fnt1 = (float) 0.0;
		Float xx_fnt2 = (float) 0.0;


		xx_int = Integer.parseInt(carbon[4][0][37]);
		xx_int++;
		carbon[4][0][37] = Integer.toString(xx_int);



		for (int xloop2 = 0; xloop2 < (carbon[0][part_number_xx].length); xloop2++) {//******

	 		try {

	 			if (carbon[0][part_number_xx][xloop2].substring(0, 7).equals("[COMBO]")) {

	 				xx_fnt0 = Float.parseFloat(carbon[0][item_cost_xx][xloop2]);
	 				xx_int = Integer.parseInt(carbon[4][0][37]);

					xx_fnt1 = (float) xx_int / 100;

					xx_fnt2 = (float) xx_fnt0 * xx_fnt1;

					if (xx_fnt1 < Float.parseFloat(carbon[4][0][87])) {xx_fnt1 = Float.parseFloat(carbon[4][0][87]);}
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 16 && xx_fnt1 < Float.parseFloat(carbon[4][0][88])) {xx_fnt1 = Float.parseFloat(carbon[4][0][88]);}//1lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 32 && xx_fnt1 < Float.parseFloat(carbon[4][0][89])) {xx_fnt1 = Float.parseFloat(carbon[4][0][89]);}//2lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 48 && xx_fnt1 < Float.parseFloat(carbon[4][0][90])) {xx_fnt1 = Float.parseFloat(carbon[4][0][90]);}//3lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 64 && xx_fnt1 < Float.parseFloat(carbon[4][0][91])) {xx_fnt1 = Float.parseFloat(carbon[4][0][91]);}//4lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 80 && xx_fnt1 < Float.parseFloat(carbon[4][0][92])) {xx_fnt1 = Float.parseFloat(carbon[4][0][92]);}//5lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 96 && xx_fnt1 < Float.parseFloat(carbon[4][0][93])) {xx_fnt1 = Float.parseFloat(carbon[4][0][93]);}//6lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 112 && xx_fnt1 < Float.parseFloat(carbon[4][0][94])) {xx_fnt1 = Float.parseFloat(carbon[4][0][94]);}//7lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 128 && xx_fnt1 < Float.parseFloat(carbon[4][0][95])) {xx_fnt1 = Float.parseFloat(carbon[4][0][95]);}//8lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 144 && xx_fnt1 < Float.parseFloat(carbon[4][0][96])) {xx_fnt1 = Float.parseFloat(carbon[4][0][96]);}//9lb
					if (xx_fnt1 > 144) {xx_fnt1 = Float.parseFloat(carbon[4][0][97]);}

					xx_fnt1 = xx_fnt1 + xx_fnt2;

					xx_fnt1 = xx_fnt0 + xx_fnt1;


					//test for map.
					for (int xloopx2 = 0; xloopx2 < nm.carbon[0][0].length; xloopx2++) {//*************
		
						if (carbon[0][ Integer.parseInt(carbon[4][0][38]) ][xloop2].equals(nm.carbon[0][nm.part_number_xx][xloopx2]) && Float.parseFloat(nm.carbon[0][nm.item_price_xx][xloopx2]) > xx_fnt1) {xx_fnt1 = Float.parseFloat(nm.carbon[0][nm.item_price_xx][xloopx2]);}
						if (carbon[0][ Integer.parseInt(carbon[4][0][39]) ][xloop2].equals(nm.carbon[0][nm.part_number_xx][xloopx2]) && Float.parseFloat(nm.carbon[0][nm.item_price_xx][xloopx2]) > xx_fnt1) {xx_fnt1 = Float.parseFloat(nm.carbon[0][nm.item_price_xx][xloopx2]);}

					}//********************************************************************************


					carbon[0][item_price_xx][xloop2] = Float.toString(xx_fnt1);


					int ix0 = carbon[0][item_price_xx][xloop2].indexOf(".");
					
					if (ix0 > -1) {

						String cx0 = carbon[0][item_price_xx][xloop2].substring(ix0, carbon[0][item_price_xx][xloop2].length());

						if (cx0.length() == 2) {carbon[0][item_price_xx][xloop2] = carbon[0][item_price_xx][xloop2] + "0";}
						if (cx0.length() > 3) {carbon[0][item_price_xx][xloop2] = carbon[0][item_price_xx][xloop2].substring(0, ix0 + 3);}

					}//if********


					System.out.println(carbon[0][part_number_xx][xloop2] + " " + xx_fnt0 + " " + xx_fnt1 + " " + xx_int);
	 

	 			}//*********************************************************************

	 		} catch (Exception e) {System.out.println("NOT COMBO"); infox1.setText("Error " + carbon[0][part_number_xx][xloop2] + ".");}

		}//for*****************************************************************************


		//display_item();
		infox1.setText("Combo 2 Profit is now " + carbon[4][0][37] + ".");


	}//***********************








	public void combo_tool_price_down(){

		System.out.println("Combo Price tool down");
	
		int xx_int = 0;
		Float xx_fnt0 = 0.0f;
		Float xx_fnt1 = 0.0f;
		Float xx_fnt2 = 0.0f;


		xx_int = Integer.parseInt(carbon[4][0][37]);
		xx_int--;
		carbon[4][0][37] = Integer.toString(xx_int);



		for (int xloop2 = 0; xloop2 < (carbon[0][part_number_xx].length); xloop2++) {//******

	 		try {

	 			if (carbon[0][part_number_xx][xloop2].substring(0, 7).equals("[COMBO]")) {

	 				xx_fnt0 = Float.parseFloat(carbon[0][item_cost_xx][xloop2]);
	 				xx_int = Integer.parseInt(carbon[4][0][37]);

					xx_fnt1 = (float) xx_int / 100;

					xx_fnt2 = xx_fnt0 * xx_fnt1;

					if (xx_fnt1 < Float.parseFloat(carbon[4][0][87])) {xx_fnt1 = Float.parseFloat(carbon[4][0][87]);}
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 16 && xx_fnt1 < Float.parseFloat(carbon[4][0][88]))  {xx_fnt1 = Float.parseFloat(carbon[4][0][88]);}//1lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 32 && xx_fnt1 < Float.parseFloat(carbon[4][0][89]))  {xx_fnt1 = Float.parseFloat(carbon[4][0][89]);}//2lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 48 && xx_fnt1 < Float.parseFloat(carbon[4][0][90]))  {xx_fnt1 = Float.parseFloat(carbon[4][0][90]);}//3lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 64 && xx_fnt1 < Float.parseFloat(carbon[4][0][91]))  {xx_fnt1 = Float.parseFloat(carbon[4][0][91]);}//4lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 80 && xx_fnt1 < Float.parseFloat(carbon[4][0][92]))  {xx_fnt1 = Float.parseFloat(carbon[4][0][92]);}//5lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 96 && xx_fnt1 < Float.parseFloat(carbon[4][0][93]))  {xx_fnt1 = Float.parseFloat(carbon[4][0][93]);}//6lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 112 && xx_fnt1 < Float.parseFloat(carbon[4][0][94])) {xx_fnt1 = Float.parseFloat(carbon[4][0][94]);}//7lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 128 && xx_fnt1 < Float.parseFloat(carbon[4][0][95])) {xx_fnt1 = Float.parseFloat(carbon[4][0][95]);}//8lb
					if (Integer.parseInt(carbon[0][item_weight_xx][xloop2]) > 144 && xx_fnt1 < Float.parseFloat(carbon[4][0][96])) {xx_fnt1 = Float.parseFloat(carbon[4][0][96]);}//9lb
					if (xx_fnt1 > 144) {xx_fnt1 = Float.parseFloat(carbon[4][0][97]);}

					xx_fnt1 = xx_fnt1 + xx_fnt2;

					xx_fnt1 = xx_fnt0 + xx_fnt1;


					//test for map.
					for (int xloopx2 = 0; xloopx2 < nm.carbon[0][0].length; xloopx2++) {//***************
		
						if (carbon[0][ Integer.parseInt(carbon[4][0][38]) ][xloop2].equals(nm.carbon[0][nm.part_number_xx][xloopx2]) && Float.parseFloat(nm.carbon[0][nm.item_price_xx][xloopx2]) > xx_fnt1){

							xx_fnt1 = Float.parseFloat(nm.carbon[0][nm.item_price_xx][xloopx2]);

						}
						if (carbon[0][ Integer.parseInt(carbon[4][0][39]) ][xloop2].equals(nm.carbon[0][nm.part_number_xx][xloopx2]) && Float.parseFloat(nm.carbon[0][nm.item_price_xx][xloopx2]) > xx_fnt1){

							xx_fnt1 = Float.parseFloat(nm.carbon[0][nm.item_price_xx][xloopx2]);

						}

					}//********************************************************************************

					carbon[0][item_price_xx][xloop2] = Float.toString(xx_fnt1);


					int ix0 = carbon[0][item_price_xx][xloop2].indexOf(".");

					if (ix0 > -1) {

						String cx0 = carbon[0][item_price_xx][xloop2].substring(ix0, carbon[0][item_price_xx][xloop2].length());

						if(cx0.length() == 2){carbon[0][item_price_xx][xloop2] = carbon[0][item_price_xx][xloop2] + "0";}
						if(cx0.length() > 3){carbon[0][item_price_xx][xloop2] = carbon[0][item_price_xx][xloop2].substring(0, ix0 + 3);}

					}//if********


					System.out.println(carbon[0][part_number_xx][xloop2] + " " + xx_fnt0 + " " + xx_fnt1 + " " + xx_int);
	 

	 			}//*********************************************************************
	 	
	 		} catch(Exception e) {

	 			System.out.println("NOT COMBO"); 
	 			infox1.setText("Error " + carbon[0][part_number_xx][xloop2] + ".");

	 		}//*******************

		}//for*****************************************************************************


		//display_item();
		infox1.setText("Combo 2 Profit is now " + carbon[4][0][37] + ".");


	}//***********************




	public void shipping_settings_online() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_shipping_settings_online(), 0);

	}//********************




	public void edit_item_x() {

		if (db_number == 0) {

	    	toolkit = Toolkit.getDefaultToolkit();
	    	xtimerx = new Timer();
	    	xtimerx.schedule(new RemindTask_edit(), 0);

    	}
    	else if (db_number == 5) {

    		choose_settings_system();

    	}

	}//********************




	public void amazon_inventory_ss() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_amazon_inventory(), 0);

	}//replace




	public void amazon_sale_price_ss() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_amazon_sale_price(), 0);

	}//replace



	public void copy_to() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_copy_to(), 0);

	}//replace



	public void delete_item_thread() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_alchemist_delete_items(), 0);

	}//replace



	public void import_csvx() { 

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_csv_import(), 0);

    }//*****************************



	public void import_json_button() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_json_import(), 0);

    }//*****************************



	public void remote_test_sql() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_sql_test(), 0);

	}//**************************



	public void export_iff_button() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_alchemy(), 0);

	}//export**********************



	public void display_v_x() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_display_viewer_x2(), 0);

	}//export******************



	public void export_csv_button() {

		System.out.println();

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_export_csv(), 0);

	}//export**********************



	public void export_json_button() {

		System.out.println();

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_export_json(), 0);

	}//export**********************




	public void frame_builder_show() {

		System.out.println("Frame_builder");

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_frame_builder(), 0);

	}//export**********************



	public void update_ebay_ee() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_ebay_update_quantity(), 0);

	}//*************************



	public void update_ebay_sp() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_ebay_update_sale_prices(), 0);

	}//*************************



    public void get_ebay_token_x() {

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_get_ebay_tokenx(), 0);

    }//get ebay



	public void order_system_show() {

		System.out.println("order_system");

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_order_system(), 0);

	}//export**********************





//timers********************
//timers********************








	public void import_yes() {//************************************


		if (current_submit_item_x == 0) {//*********

			if (current_submit_item_x == 0 && db_number == 2) {
				
				response = JOptionPane.showConfirmDialog(null, "Import all sales from all active sites?"); 
	
				if (response == 0){

					if (program_working != 1 && db_number == 2) {
			
						program_working = 1;

    					toolkit = Toolkit.getDefaultToolkit();
    					xtimerx = new Timer();
    					xtimerx.schedule(new RemindTask_import_sales_silent(), 0);

					}//****************************************

				}//****************

			}//****************************
			else {JOptionPane.showMessageDialog(null,"You cannot import items from multiple sites at the same time. Only SALES.");}

		}//if importing




		if (db_number == 0 && current_submit_item_x != 0) {//****
		
			response = JOptionPane.showConfirmDialog(null, "Import items from " + carbon[5][name_info_xx][current_submit_item_a] + "?"); 
	
			if (response == 0) {

    			toolkit = Toolkit.getDefaultToolkit();
    			xtimerx = new Timer();
    			xtimerx.schedule(new RemindTask_import_items(), 0);

			}//***************

		}//**********************





		if (program_working != 1) {//******

			if (db_number == 2 && current_submit_item_x != 0) {//****
	
				response = JOptionPane.showConfirmDialog(null, "Import sales from " + carbon[5][name_info_xx][current_submit_item_a] + "?"); 
	
				if (response == 0) {

					program_working = 1;
    				toolkit = Toolkit.getDefaultToolkit();
    				xtimerx = new Timer();
    				xtimerx.schedule(new RemindTask_import_sales(), 0);

				}//***************

			}//**********************
	
		}//*******************************
		else {infox1.setText("Program is working. Please wait...");}




	}//import*********************************************************
















	public void alchemy_view(){//****************************************************************************

		if(carbon[5][type_info_xx][current_submit_item_a].equals("eBay")){//**********
		
			System.out.println("Settings3");

    		toolkit = Toolkit.getDefaultToolkit();
    		xtimerx = new Timer();
    		xtimerx.schedule(new RemindTask_alchemist_viewer(), 0);

		}//*****************************************************************

		if(carbon[5][type_info_xx][current_submit_item_a].equals("Amazon")){//**********

			System.out.println("Settings33");

		}//*****************************************************************

		if (carbon[5][type_info_xx][current_submit_item_a].equals("Alchemist")) {//****
		
			System.out.println("Settings333");

			String urlx = new String(carbon[5][urlx_info_xx][current_submit_item_a] + "/dbx_item.php?itemurl=" + carbon[0][title_url_xx][what_item]);
			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

			try {

       			java.net.URI uri = new java.net.URI(urlx);
      			desktop.browse(uri);

			} catch (Exception e) {}


		}//*****************************************************************

	}//export**************************************************************************************************










	public String[][][] build_export_display_list() {

		int db_offset = 0;//create db is at 0 - 100
		int new_db_cc_number = 0;

		for (int xloop = 0; xloop < db_cc_number; xloop++){//******

			if (carbon[6][0][(xloop + (100 * db_offset))].equals("1")) {//******

				new_db_cc_number++;

			}//*************************************************************************

		}//********************************************************

		System.out.println("new_db_cc_number " + new_db_cc_number);

		String[][][] dlist = new String[4][new_db_cc_number][nm.carbon[0][0].length];

		int runsx = 0;


		for (int xloop0 = 0; xloop0 < nm.carbon[0][0].length; xloop0++) {//**************

			runsx = 0;

			for (int xloopx = 0; xloopx < db_cc_number; xloopx++) {//************************

				for (int xloopn = 0; xloopn < db_cc_number; xloopn++) {//************************


		    		if (carbon[6][1][(xloopn + (100 * db_offset))].equals(Integer.toString(xloopx))) {//**************

			      		if (carbon[6][0][(xloopn + (100 * db_offset))].equals("1")) {//*********************************************

							try {

								//The items list.
								dlist[0][runsx][xloop0] = nm.carbon[0][xloopn][xloop0];

								//System.out.println("xloopx " + xloopn);
								//System.out.println("xloopx " + xloop0);
								//System.out.println("carbon " + nm.carbon[0][xloopn][xloop0]);

								//The header list.
								dlist[1][runsx][0] = db_string[xloopn];

								//System.out.println("title " + db_string[xloopn]);

								//The size list.
								dlist[2][runsx][xloop0] = carbon[6][2][(xloopn + (100 * db_offset))];

								runsx++;

							} catch (Exception e) {}

							break;

						}//if**************************************************************************************************************

		   			}//if****************************************************************************************************


				}//for***************************************************************************

			}//for***************************************************************************

		}//for***************************************************************************

		return dlist;

	}//**********************************************







	public String[][] build_monitor_display_list() {

		String[][] dlist = new String[7][nm.carbon[1][0].length];

		for(int xloop = 0; xloop < nm.carbon[1][0].length; xloop++){//******

			dlist[0][xloop] = nm.carbon[1][0][xloop];
			dlist[1][xloop] = nm.carbon[1][1][xloop];
			dlist[2][xloop] = nm.carbon[1][2][xloop];
			dlist[3][xloop] = nm.carbon[1][3][xloop];
			dlist[4][xloop] = nm.carbon[1][4][xloop];
			dlist[5][xloop] = nm.carbon[1][5][xloop];
			dlist[6][xloop] = nm.carbon[1][6][xloop];

		}//for**************************************************************

		return dlist;

	}//**********************************************








	public String[][][] build_sold_display_list() {

		int db_offset = 1;//create db is at 0 - 100
		int new_db_cc_number = 0;

		for (int xloop = 0; xloop < db_cc_number; xloop++){//******

			if (carbon[6][0][(xloop + (100 * db_offset))].equals("1")) {//******

				new_db_cc_number++;

			}//*************************************************************************

		}//********************************************************

		System.out.println("new_db_cc_number " + new_db_cc_number);

		String[][][] dlist = new String[4][new_db_cc_number][nm.carbon[2][0].length];

		int runsx = 0;


		for (int xloop0 = 0; xloop0 < nm.carbon[2][0].length; xloop0++) {//**************

			runsx = 0;

			for (int xloopx = 0; xloopx < db_cc_number; xloopx++) {//************************

				for (int xloopn = 0; xloopn < db_cc_number; xloopn++) {//************************


		    		if (carbon[6][1][(xloopn + (100 * db_offset))].equals(Integer.toString(xloopx))) {//**************

			      		if (carbon[6][0][(xloopn + (100 * db_offset))].equals("1")) {//*********************************************

							try {

								//The items list.
								dlist[0][runsx][xloop0] = nm.carbon[2][xloopn][xloop0];

								//System.out.println("xloopx " + xloopn);
								//System.out.println("xloopx " + xloop0);
								//System.out.println("carbon " + nm.carbon[0][xloopn][xloop0]);

								//The header list.
								dlist[1][runsx][0] = db_string[xloopn];

								//System.out.println("title " + db_string[xloopn]);

								//The size list.
								dlist[2][runsx][xloop0] = carbon[6][2][(xloopn + (100 * db_offset))];

								runsx++;

							} catch (Exception e) {}

							break;

						}//if**************************************************************************************************************

		   			}//if****************************************************************************************************


				}//for***************************************************************************

			}//for***************************************************************************

		}//for***************************************************************************

		return dlist;

	}//**********************************************








	public String[][][] build_archive_display_list() {

		int db_offset = 2;//create db is at 0 - 100
		int new_db_cc_number = 0;

		for (int xloop = 0; xloop < db_cc_number; xloop++){//******

			if (carbon[6][0][(xloop + (100 * db_offset))].equals("1")) {//******

				new_db_cc_number++;

			}//*************************************************************************

		}//********************************************************

		System.out.println("new_db_cc_number " + new_db_cc_number);

		String[][][] dlist = new String[4][new_db_cc_number][nm.carbon[3][0].length];

		int runsx = 0;


		for (int xloop0 = 0; xloop0 < nm.carbon[3][0].length; xloop0++) {//**************

			runsx = 0;

			for (int xloopx = 0; xloopx < db_cc_number; xloopx++) {//************************

				for (int xloopn = 0; xloopn < db_cc_number; xloopn++) {//************************


		    		if (carbon[6][1][(xloopn + (100 * db_offset))].equals(Integer.toString(xloopx))) {//**************

			      		if (carbon[6][0][(xloopn + (100 * db_offset))].equals("1")) {//*********************************************

							try {

								//The items list.
								dlist[0][runsx][xloop0] = nm.carbon[3][xloopn][xloop0];

								//System.out.println("xloopx " + xloopn);
								//System.out.println("xloopx " + xloop0);
								//System.out.println("carbon " + nm.carbon[0][xloopn][xloop0]);

								//The header list.
								dlist[1][runsx][0] = db_string[xloopn];

								//System.out.println("title " + db_string[xloopn]);

								//The size list.
								dlist[2][runsx][xloop0] = carbon[6][2][(xloopn + (100 * db_offset))];

								runsx++;

							} catch (Exception e) {}

							break;

						}//if**************************************************************************************************************

		   			}//if****************************************************************************************************


				}//for***************************************************************************

			}//for***************************************************************************

		}//for***************************************************************************

		return dlist;

	}//**********************************************








	public String[][] build_settings_display_list() {

		String[][] dlist = new String[2][db_ss_number];

		for (int xloop = 0; xloop < db_ss_number; xloop++) {//****

			dlist[0][xloop] = db_settings_string[xloop];
			dlist[1][xloop] = carbon[4][0][xloop];

		}//for****************************************************

		return dlist;

	}//**********************************************







	public String[][] build_connections_display_list() {

		String[][] dlist = new String[6][nm.carbon[5][name_info_xx].length];

		Calendar calendar = Calendar.getInstance();

		for (int xloop = 0; xloop < nm.carbon[5][name_info_xx].length; xloop++) {//******

			try {

				calendar.setTimeInMillis(Long.parseLong(nm.carbon[5][id_info_xx][xloop]));

			} catch (Exception e) {}

			int mYear = calendar.get(Calendar.YEAR);
			int mMonth = calendar.get(Calendar.MONTH);
			int mDay = calendar.get(Calendar.DAY_OF_MONTH);


			dlist[0][xloop] = nm.carbon[5][name_info_xx][xloop];
			dlist[1][xloop] = nm.carbon[5][urlx_info_xx][xloop];
			dlist[2][xloop] = nm.carbon[5][id_info_xx][xloop];
			dlist[3][xloop] = Integer.toString(mDay) + "-" + Integer.toString(mMonth) + "-" + Integer.toString(mYear);
			dlist[4][xloop] = nm.carbon[5][type_info_xx][xloop];
			dlist[5][xloop] = nm.carbon[5][active_info_xx][xloop];

		}//for**************************************************************

		return dlist;

	}//**********************************************







	public String[][] build_arrange_display_list() {

		String[][] dlist = new String[6][db_dd_number];

		for (int xloop = 0; xloop < db_dd_number; xloop++) {//******


			if (xloop < 100) {

				dlist[0][xloop] = "Export";
				dlist[1][xloop] = db_string[xloop];

			}//***************

			if (xloop > 99 && xloop < 200) {

				dlist[0][xloop] = "Sold";
				dlist[1][xloop] = db_string[xloop - 100];

			}//*****************************

			if (xloop > 199 && xloop < 300) {

				dlist[0][xloop] = "Archive";
				dlist[1][xloop] = db_string[xloop - 200];

			}//******************************


			dlist[2][xloop] = carbon[6][0][xloop];
			dlist[3][xloop] = carbon[6][1][xloop];
			dlist[4][xloop] = carbon[6][2][xloop];
			dlist[5][xloop] = carbon[6][3][xloop];

		}//for******************************************************************

		return dlist;

	}//**********************************************










	public void refresh_yes() {

		if (db_number == 1) {//***********************

			int ix0 = Integer.parseInt(carbon[1][6][what_item]);


			     if (carbon[5][type_info_xx][ix0].equals("Amazon"))     {infox1.setText("Amazon");    amazon_import_stats readx = new amazon_import_stats(what_item);}
			else if (carbon[5][type_info_xx][ix0].equals("Custom"))     {infox1.setText("Custom");}
			else if (carbon[5][type_info_xx][ix0].equals("eBay"))       {infox1.setText("eBay");      ebay_import_stats readx = new ebay_import_stats(what_item);}
			else if (carbon[5][type_info_xx][ix0].equals("Etsy"))       {infox1.setText("Etsy");      etsy_import_stats readx = new etsy_import_stats(what_item);}
			else if (carbon[5][type_info_xx][ix0].equals("Magento"))    {infox1.setText("Magento");   magento_import_stats readx = new magento_import_stats(what_item);}
			else if (carbon[5][type_info_xx][ix0].equals("MySQL"))      {infox1.setText("MySQL");}
			else if (carbon[5][type_info_xx][ix0].equals("PayPal"))     {infox1.setText("PayPal");}


			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			carbon[db_number][5][what_item] = sdf.format(cal.getTime());


			carbon[db_number][2][what_item] = stats_running;
			carbon[db_number][3][what_item] = stats_hits;
			carbon[db_number][4][what_item] = stats_sales;


			String[][] save_itemd = new String[carbon[1].length][1];

			//save info
			for (int loop = 0; loop < carbon[1].length; loop++){//********

				save_itemd[loop][0] = carbon[1][loop][what_item];

				if (save_itemd[loop][0].length() == 0) {

					save_itemd[loop][0] = new String("0");

				}

				System.out.println(loop + " " + save_itemd[loop][0].length());

			}//***********************************************************

			jdb_edit_monitor edit = new jdb_edit_monitor(save_itemd);



       		//display_item();

		}//if*****************************************
		else if (db_number == 0) {//***********************

			System.out.println("Get Items List Listed.");

			alchemy_get_items_list cccx = new alchemy_get_items_list();

			create_button();

		}//if********************************************


	}//refresh yes






	public void delete_x() {


		if (db_number == 0) {

			response = JOptionPane.showConfirmDialog(null, "Delete item(s)?");
 			if (response == 0) {

 				delete_item();

 			}//*****************

		}//if

		if (db_number == 1) {

			response = JOptionPane.showConfirmDialog(null, "Delete running DB item(s) from this site?");
 			if (response == 0) {}

		}//if

		if (db_number == 2) {

			response = JOptionPane.showConfirmDialog(null, "Delete sale(s)?");
 			if (response == 0) {

 				delete_flag_change_inventory = true; 
 				delete_item();

 			}//*****************

		}//if

		if (db_number == 3) {

			response = JOptionPane.showConfirmDialog(null, "Delete archived sale(s)?");
 			if (response == 0) {

 				delete_item();

 			}//*****************

		}//if

		if (db_number == 5) {

			response = JOptionPane.showConfirmDialog(null, "Delete Account(s)? This will remove the link to one or more accounts. The sales items will no longer have a match.");
 			if (response == 0) {

 				delete_item(); 

 				set_submit_monitor_items(); 

 			}//*****************

		}//if



	}//delete yes










	public void empty_yes() {

		if (db_number == 0) {

			response = JOptionPane.showConfirmDialog(null, "Delete selected ITEM from: " + carbon[5][name_info_xx][current_submit_item_a]);
 	
 			if (response == 0) {

				if (carbon[5][type_info_xx][current_submit_item_a].equals("Alchemist")) {delete_item_thread();}
				else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay")) {}

			}//if

		}//if**************


		if (db_number == 1) {

			response = JOptionPane.showConfirmDialog(null, "Delete running DB item(s) from " + carbon[1][1][what_item] + "?");
 			if (response == 0) {

 				delete_db_listings(); 
 				System.out.println(">>>"); 
 				alchemy_import_stats readx = new alchemy_import_stats(); 
 				monitor_button();

 			}//*****************
		
		}//if

		if (db_number == 2) {

			response = JOptionPane.showConfirmDialog(null, "Deleting sales from the website is not permitted.");
 			if (response == 0) {}
		
		}//if



	}//empty yes








	public void export_dazzle_return_ll() {

		JOptionPane.showMessageDialog(null,"Build Return Label.");

	}//export**********************








	public void update_custom_ee(){

		custom_select = 35;

		if(carbon[5][type_info_xx][current_submit_item_a].equals("Alchemist")){

        	String input = (String) JOptionPane.showInputDialog(null, "Import which custom field?", "Import Custom Field", JOptionPane.QUESTION_MESSAGE, null, db_string, db_string[13]); // Initial choice


			if ((input != null) && (input.length() > 0)) {
	  
				System.out.println(input);

				for(int xloop2 = 0; xloop2 < carbon[0].length; xloop2++){//******

					if(input.equals(db_string[xloop2])){custom_select = xloop2;}

				}//for***********************************************************
	
				System.out.println(custom_select);

	    		toolkit = Toolkit.getDefaultToolkit();
	    		xtimerx = new Timer();
	    		xtimerx.schedule(new RemindTask_custom_update(), 0);
  
			}//****************************************


		}//*********************************************************
		else {JOptionPane.showMessageDialog(null,"You can only import from webshops. Not eBay or Amazon.");}

	}//*************************










	public void connectx() {


		System.out.println("" + carbon[5][type_info_xx][what_item]);

 		     if (carbon[5][type_info_xx][what_item].equals("Amazon"))     {connectx_amazon();}
 		else if (carbon[5][type_info_xx][what_item].equals("Custom"))     {connectx_custom();}
 		else if (carbon[5][type_info_xx][what_item].equals("eBay"))       {connectx_ebay();}
 		else if (carbon[5][type_info_xx][what_item].equals("Etsy"))       {connectx_etsy();}
 		else if (carbon[5][type_info_xx][what_item].equals("Magento"))    {connectx_magento();}
		else if (carbon[5][type_info_xx][what_item].equals("MySQL"))      {connectx_mysql();}
		else if (carbon[5][type_info_xx][what_item].equals("PayPal"))     {connectx_paypal();}

		String[][] edit_new = new String[carbon[5].length][1];

		for (int loop = 0; loop < carbon[5].length; loop++) {//************
 
			edit_new[loop][0] = carbon[5][loop][what_item];

		}//****************************************************************

		jdb_edit_connection editc = new jdb_edit_connection(edit_new, Integer.toString(what_item));



	}//import







	public void new_item_yes(){

		if (db_number == 0) {

			jdb_new_item addx = new jdb_new_item(); 
			create_button();

		}//******************

		if (db_number == 5) {

			new_item_connect(); 
			websites_button();

		}//******************
	
	}//import



	public void export_xml_button(){

		xml_export xmle = new xml_export();

	}//import



	public void import_xml_button(){

		toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_xml_import(), 0);

	}//import



	public void button_export_settings(){

    	toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_export_settings(), 0);

	}//********************







	public void post_yes(){

		System.out.println("POST_YES");
		System.out.println(carbon[5][type_info_xx][current_submit_item_a]);

		     if (db_number == 4) {System.out.println("Export settings"); button_export_settings();}
		else if (db_number == 5) {}
		else if (db_number == 6) {}
		else if (db_number == 1) {}
		else {


 			if (carbon[5][type_info_xx][current_submit_item_a].equals("Custom")) {//*********************************

				response = JOptionPane.showConfirmDialog(null, "Post item(s) to " + carbon[5][name_info_xx][current_submit_item_a] + "?");

				if (response == 0 && db_number == 0) {

    				toolkit = Toolkit.getDefaultToolkit();
    				xtimerx = new Timer();
    				xtimerx.schedule(new RemindTask_1(), 0);

				}//*********************************

				if (response == 0 && db_number == 2) {

    				toolkit = Toolkit.getDefaultToolkit();
    				xtimerx = new Timer();
    				xtimerx.schedule(new RemindTask_1_sold(), 0);

				}//*********************************


			}//*********************************************************************************************

 			else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay")) {//***********************************

				response = JOptionPane.showConfirmDialog(null, "Post item(s) to eBay?");

				if (response == 0 && db_number == 0) {

    				toolkit = Toolkit.getDefaultToolkit();
    				xtimerx = new Timer();
    				xtimerx.schedule(new RemindTask_1(), 0);

				}//*********************************

			}//*********************************************************************

 			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Etsy")) {//***********************************
	
				response = JOptionPane.showConfirmDialog(null, "Post item(s) to Etsy?");

				if (response == 0 && db_number == 0) {

    				toolkit = Toolkit.getDefaultToolkit();
    				xtimerx = new Timer();
    				xtimerx.schedule(new RemindTask_1(), 0);

				}//*********************************

			}//*********************************************************************

 			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon")) {//***********************************
	
				response = JOptionPane.showConfirmDialog(null, "Post item(s) to Amazon?");

				if (response == 0 && db_number == 0) {

    				toolkit = Toolkit.getDefaultToolkit();
    				xtimerx = new Timer();
    				xtimerx.schedule(new RemindTask_1(), 0);

				}//*********************************

			}//*********************************************************************

 			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Magento")) {//***********************************
	
				response = JOptionPane.showConfirmDialog(null, "Post item(s) to Magento?");

				if (response == 0 && db_number == 0) {

    				toolkit = Toolkit.getDefaultToolkit();
    				xtimerx = new Timer();
    				xtimerx.schedule(new RemindTask_1(), 0);

				}//*********************************

			}//*********************************************************************

 			else if (carbon[5][type_info_xx][current_submit_item_a].equals("Custom")) {//***********************************

				response = JOptionPane.showConfirmDialog(null, "Post item(s) to API?");

				if (response == 0 && db_number == 0) {

    				toolkit = Toolkit.getDefaultToolkit();
    				xtimerx = new Timer();
    				xtimerx.schedule(new RemindTask_1(), 0);

				}//*********************************

			}//*********************************************************************

			else {JOptionPane.showMessageDialog(null,"No site selected. Top right.");}


		}//else*****************

	}//import**************







	public void get_amazon_erros_x(){

		System.out.println("Get Amazon Errors.");

		amazon_errors am = new amazon_errors();

	}//get_amazon_erros_x()








	public void import_black_yes(){

		response = JOptionPane.showConfirmDialog(null, "Import item(s) from Blackthorne file?");
 		if (response == 0) {

 			bt_import();

 		}//*****************

	}//import








	public void local_db_set(){

		carbon[4][0][6] = "1";

		connectset.setSelected(false);
		connectdbo.setSelected(true);
		connectcsv.setSelected(false);

		if(db_number == 4){}

		save_settings_pp();

	}//import



	public void remote_db_set(){

		carbon[4][0][6] = "0";
		infox1.setText("Remote SQL DB: " + carbon[4][0][7] + ".");

		connectdbo.setSelected(false);
		connectset.setSelected(true);
		connectcsv.setSelected(false);

		if(db_number == 4){}

		save_settings_pp();

	}//import





	public void csv_db_set(){

		carbon[4][0][6] = "2";
		infox1.setText("Local .CSV DB: " + carbon[4][0][4] + ".");

		connectdbo.setSelected(false);
		connectset.setSelected(false);
		connectcsv.setSelected(true);

		if(db_number == 4){}

		save_settings_pp();

	}//import








	public void print_string_csvx(){

	
		response = JOptionPane.showConfirmDialog(null, "Print String CSVX?");
 		if (response == 0) {

			for (int xloop0 = 0; xloop0 < 7; xloop0++) {//**************

				for (int xloop1 = 0; xloop1 < carbon[xloop0][0].length; xloop1++) {//******

					for (int xloop2 = 0; xloop2 < carbon[xloop0].length; xloop2++) {//******

						if (!carbon[xloop0][xloop2][xloop1].equals("null")) {System.out.println(xloop1 + " " + carbon[xloop0][xloop2][xloop1]);}

					}//for

				}//for

			}//for***********************************************************************

		}//response


	}//******************************








	public void weight_fix(){
	
		carbon[2][item_weight_xx][what_item] = Integer.toString( (Integer.parseInt(carbon[2][item_weight_xx][what_item]) * (16) * Integer.parseInt(carbon[2][quantity_sold_xx][what_item])) );

	}//**********************







	public void build_url_titles_tool(){


		for(int xloop2 = 1; xloop2 < carbon[0][0].length; xloop2++){//******

			if(carbon[0][title_xx][xloop2].length() > 40){carbon[0][title_url_xx][xloop2] = carbon[0][title_xx][xloop2].substring(0,40).replace(" ", "_").replace("'", "").replace("\"", "") + "_" + carbon[0][item_id_xx][xloop2];}
			else{carbon[0][title_url_xx][xloop2] = carbon[0][title_xx][xloop2].replace(" ", "_").replace("'", "").replace("\"", "") + "_" + carbon[0][item_id_xx][xloop2];}

		}//for**********************************************


		if(db_number == 0){create_button();}


	}//************************









	public void change_c(){

		response = JOptionPane.showConfirmDialog(null, "Change AC import IDs?");
 		if(response == 0){

				System.out.println("CHANGE"); 
				carbon[4][0][12] = Integer.toString(Integer.parseInt(carbon[4][0][12]) + 1000); 
				carbon[4][0][24] = Integer.toString(Integer.parseInt(carbon[4][0][24]) + 1000);

		}//***************

	}//********************








	public void change_account(){

		response = JOptionPane.showConfirmDialog(null, "Change sale to new account?");
 		if (response == 0) {

			System.out.println("::Y::"); carbon[2][source_of_sale_xx][what_item] = carbon[5][name_info_xx][current_submit_item_a]; 
			//display_item();
	
		}//***************

	}//**************************












	public void get_shipped_list(){

		response = JOptionPane.showConfirmDialog(null, "Import status from shipping system?");
 		if (response == 0) {


			if (db_number == 2) {

    			toolkit = Toolkit.getDefaultToolkit();
    			xtimerx = new Timer();
    			xtimerx.schedule(new RemindTask_import_shipped_sales(), 0);

			}//if***************
			else if (db_number == 3) {

    			toolkit = Toolkit.getDefaultToolkit();
    			xtimerx = new Timer();
    			xtimerx.schedule(new RemindTask_import_shipped_sales_archived(), 0);

			}//if***************


		}//***************

	}//****************************get_list





	public void get_delivery_list(){

		response = JOptionPane.showConfirmDialog(null, "Import shipping status?");
 		if (response == 0) {


			if (db_number == 2) {

    			toolkit = Toolkit.getDefaultToolkit();
    			xtimerx = new Timer();
    			xtimerx.schedule(new RemindTask_import_shipped_status2(), 0);

			}//if***************
			else if (db_number == 3) {

    			toolkit = Toolkit.getDefaultToolkit();
    			xtimerx = new Timer();
    			xtimerx.schedule(new RemindTask_import_shipped_status2_archive(), 0);

			}//if***************


    		//toolkit = Toolkit.getDefaultToolkit();
    		//xtimerx = new Timer();
    		//xtimerx.schedule(new RemindTask_import_shipped_status(), 0);

		}//***************

	}//****************************get_list






	public void get_delivery_list_uk(){

		response = JOptionPane.showConfirmDialog(null, "Import status from Royal mail system?");
 		if (response == 0) {

    		toolkit = Toolkit.getDefaultToolkit();
    		xtimerx = new Timer();
    		xtimerx.schedule(new RemindTask_import_shipped_status_uk(), 0);

		}//***************

	}//****************************get_list








	public void set_fire_slider(){

		System.out.println(framesPerPage0.getValue());

		int ix0 = 0;

		if (db_number == 0)      {ix0 = framesPerPage0.getValue();}
		else if (db_number == 1) {ix0 = framesPerPage1.getValue();}
		else if (db_number == 2) {ix0 = framesPerPage2.getValue();}
		else if (db_number == 3) {ix0 = framesPerPage3.getValue();}
		else if (db_number == 4) {ix0 = framesPerPage4.getValue();}
		else if (db_number == 5) {ix0 = framesPerPage5.getValue();}
		else if (db_number == 6) {ix0 = framesPerPage6.getValue();}

		what_frame_page = ix0;

		items_start = 0;
		items_end = carbon[db_number][0].length;

		if (db_number == 0)      {items_page0_start = (ix0 * display_count);}
		else if (db_number == 1) {items_page1_start = (ix0 * display_count);}
		else if (db_number == 2) {items_page2_start = (ix0 * display_count);}
		else if (db_number == 3) {items_page3_start = (ix0 * display_count);}
		else if (db_number == 4) {items_end = db_ss_number;}
		else if (db_number == 5) {}
		else if (db_number == 6) {items_end = 300;}

		what_item_display = (load_limit * what_frame_page) + 1;

		System.out.println("SPAN " + items_start + " - " + items_end);

	}//**************************









     public void stateChanged(ChangeEvent e) {

        JSlider source = (JSlider) e.getSource();

        if (!source.getValueIsAdjusting()) {


			System.out.println("source.getValue() " + source.getValue());

			int i00 = framesPerPage0.getValue();
			int i01 = 0;
			int i02 = framesPerPage2.getValue();
			int i03 = framesPerPage3.getValue();

			//JOptionPane.showMessageDialog(null,"i00 " + i00 + " " + i02 + " " + i03);

			//items_start = 0;
			//items_end = carbon[db_number][0].length;


			if (!ifrunning) {

				ifrunning = true;

				if (db_number == 0)      {items_page0_start = (i00 * display_count);}
				else if (db_number == 1) {items_page1_start = (i01 * display_count);}
				else if (db_number == 2) {items_page2_start = (i02 * display_count);}
				else if (db_number == 3) {items_page3_start = (i03 * display_count);}


				if (db_number == 0 && section_number0 != i00) {

					//JOptionPane.showMessageDialog(null,"xxx " + section_number0 + " " + i00);

					System.out.println("changx 1 " + change_tab);

					framesPerPage0.setToolTipText(Integer.toString(i00 * display_count) + " " + Integer.toString((i00 * display_count) + display_count));
					System.out.println("SPAN " + items_start + " - " + items_end);

					System.out.println("change 1");
					create_button();
					section_number0 = i00;

				}//*****************************************
				else if (db_number == 2 && section_number2 != i02) {

					System.out.println("changx 2 " + change_tab);

					framesPerPage2.setToolTipText(Integer.toString(i00 * display_count) + " " + Integer.toString((i00 * display_count) + display_count));
					System.out.println("SPAN " + items_start + " - " + items_end);

					System.out.println("change 2"); 
					sold_button(); 
					section_number2 = i02;

				}//*****************************************
				else if (db_number == 3 && section_number3 != i03) {

					System.out.println("changx 3 " + change_tab);

					framesPerPage3.setToolTipText(Integer.toString(i00 * display_count) + " " + Integer.toString((i00 * display_count) + display_count));
					System.out.println("SPAN " + items_start + " - " + items_end);

					System.out.println("change 3");
					archive_button(); 
					section_number3 = i03;

				}//*****************************************
				else {System.out.println("NOTHING");}

				//System.out.println(section_number0 + " >>>>>>>>>>>> ** " + i00);


				what_item_selected = 0;

				//selected items are void
				try {

					for (int xloop2 = 0; xloop2 < carbon[db_number][0].length; xloop2++) {selected_int[xloop2] = 0;}//for
					//System.out.println("SELECTED NO MORE " + selected_int[1]);

				} catch(Exception ex){System.out.println("Set selected failed... 32356");}


				ifrunning = false;

			}//ifrunning


		}//if******************************


    }//*************************************    











	public void export_dazzle_ll(){

		System.out.println("DAZZLE");

		response = JOptionPane.showConfirmDialog(null, "Start Shipping System?");
		if (response == 0 && db_number == 2) {

			if (program_working != 1 && db_number == 2) {

				if (carbon[2][sale_status_xx][what_item].equals("Sold")) {

	    			toolkit = Toolkit.getDefaultToolkit();
    				xtimerx = new Timer();
    				xtimerx.schedule(new RemindTask_alchemist_export_label(), 0);

				} else {JOptionPane.showMessageDialog(null,"Item must be in 'Sold' state to ship");}

			}//****************************************
			else {JOptionPane.showMessageDialog(null,"Program is importing data. Please try again later");}

		}//*********************************

	}//***************************






	public void export_dazzle_ll_2(){

		System.out.println("DAZZLE2");


		if(program_working != 1 && db_number == 2){

			if(carbon[2][sale_status_xx][what_item].equals("Sold")){

	    		toolkit = Toolkit.getDefaultToolkit();
    			xtimerx = new Timer();
    			xtimerx.schedule(new RemindTask_alchemist_export_label(), 0);

			}else{JOptionPane.showMessageDialog(null,"Item must be in 'Sold' state to ship");}

		}//****************************************
		else{JOptionPane.showMessageDialog(null,"Program is importing data. Please try again later");}



	}//***************************








	public void shipping_ssss(){

		System.out.println("Shipping System Settings Dazzle");

		toolkit = Toolkit.getDefaultToolkit();
    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_shipping_system_settings(), 0);


	}//**************************************







	public void open_tracking_nn(){

		String urlx = new String("https://www.google.com/search?ix=hca&sourceid=chrome&ie=UTF-8&q=" + carbon[2][tracking_number_xx][what_item]);

		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

		try{

      		java.net.URI uri = new java.net.URI(urlx);
       		desktop.browse(uri);

		}catch(Exception e){}

	}//**************************************











//import inventory from the website. 
	public void update_inventory_x() {
	

		response = JOptionPane.showConfirmDialog(null, "Are you sure you want to overwrite your database?");

		if(response == 0){


			alchemy_update_database_inventory ddb = new alchemy_update_database_inventory();

			String pass_com = "0";

			infox1.setText("Update Inventory: " + pass_com + ".");


		}//****************

		create_button();

		JOptionPane.showMessageDialog(null, "Inventory has been updated");
	

	}//******************************







//value the inventory in the datebase. 
	public void value_inventory_x(){

		int ix0 = carbon[0][0].length;
		int ix1 = 0;

		Float fx0 = (float) 0.0;
		Float fx1 = (float) 0.0;
		

		for (int xloop0 = 1; xloop0 < ix0; xloop0++) {//**************

			infox1.setText(carbon[0][part_number_xx][xloop0] + " " + carbon[0][item_cost_xx][xloop0] + " x " + carbon[0][total_on_hand_xx][xloop0] + ".");
			fx0 = (float) fx0 + (Float.parseFloat(carbon[0][item_cost_xx][xloop0]) * Integer.parseInt(carbon[0][total_on_hand_xx][xloop0]));
			fx1 = (float) fx1 + (Float.parseFloat(carbon[0][item_price_xx][xloop0]) * Integer.parseInt(carbon[0][total_on_hand_xx][xloop0]));

			ix1 = ix1 + Integer.parseInt(carbon[0][total_on_hand_xx][xloop0]);

		}//*******************************************************


		JOptionPane.showMessageDialog(null, Integer.toString(ix1) + " items.\nValued at: " + Float.toString(fx0) + "\nWith a sale price of: " + Float.toString(fx1));
	

	}//******************************







//value the inventory in the datebase. 
	public void weight_inventory_x() {

		int ix0 = carbon[0][0].length;
		int ix1 = 0;
		int ix2 = 0;
		int ix3 = 0;
		int ix4 = 0;


		for(int xloop0 = 1; xloop0 < ix0; xloop0++){//************

			infox1.setText(carbon[0][part_number_xx][xloop0] + " " + carbon[0][item_weight_xx][xloop0] + " x " + carbon[0][total_on_hand_xx][xloop0] + ".");

			ix1 = ix1 + (Integer.parseInt(carbon[0][item_weight_xx][xloop0]) * Integer.parseInt(carbon[0][total_on_hand_xx][xloop0]));

			ix4 = ix4 + Integer.parseInt(carbon[0][total_on_hand_xx][xloop0]);

		}//*******************************************************

		ix2 = ix1 / 16;
		ix3 = (int) (ix1 / 35.274);

		JOptionPane.showMessageDialog(null, Integer.toString(ix4) + " Total items \n" + ix1 + " .oz \n" + ix2 + " .lbs \n" + ix3 + " .kg");
	

	}//******************************











	public void sale_status_change() {

		if (what_item > -1) {

			System.out.println("Set Status SB");

			     if (carbon[2][sale_status_xx][what_item].equals("Listed"))       {carbon[2][sale_status_xx][what_item] = "Sold";}
			else if (carbon[2][sale_status_xx][what_item].equals("Sold"))         {carbon[2][sale_status_xx][what_item] = "Ready to ship";}
			else if (carbon[2][sale_status_xx][what_item].equals("Ready to ship")){carbon[2][sale_status_xx][what_item] = "Shipped";}
			else if (carbon[2][sale_status_xx][what_item].equals("Shipped"))      {carbon[2][sale_status_xx][what_item] = "Successful";}
			else if (carbon[2][sale_status_xx][what_item].equals("Successful"))   {carbon[2][sale_status_xx][what_item] = "Refunded";}
			else if (carbon[2][sale_status_xx][what_item].equals("Refunded"))     {carbon[2][sale_status_xx][what_item] = "Exported";}
			else if (carbon[2][sale_status_xx][what_item].equals("Exported"))     {carbon[2][sale_status_xx][what_item] = "Error";}
			else if (carbon[2][sale_status_xx][what_item].equals("Error"))        {carbon[2][sale_status_xx][what_item] = "Listed";}
			   else {carbon[2][sale_status_xx][what_item] = "Error";}


			String[][] save_itemd = new String[db_cc_number][1];

			//save info
			for (int loop = 0; loop < carbon[2].length; loop++){//*************

				save_itemd[loop][0] = carbon[2][loop][what_item];

			}//****************************************************************

			jdb_edit_sale edit = new jdb_edit_sale(save_itemd);

			String[][][] sold_display_list = build_sold_display_list();
			dxengine2.display_item(sold_display_list[0], what_item_display);

			infox1.setText("Item " + Integer.toString(what_item + 1) + " saved.");

		}//if***************

	}//*****************************
	





	public void sale_status_change_archive() {

		if (what_item > -1) {

			     if (carbon[3][sale_status_xx][what_item].equals("Listed"))       {carbon[3][sale_status_xx][what_item] = "Sold";}
			else if (carbon[3][sale_status_xx][what_item].equals("Sold"))         {carbon[3][sale_status_xx][what_item] = "Ready to ship";}
			else if (carbon[3][sale_status_xx][what_item].equals("Ready to ship")){carbon[3][sale_status_xx][what_item] = "Shipped";}
			else if (carbon[3][sale_status_xx][what_item].equals("Shipped"))      {carbon[3][sale_status_xx][what_item] = "Successful";}
			else if (carbon[3][sale_status_xx][what_item].equals("Successful"))   {carbon[3][sale_status_xx][what_item] = "Refunded";}
			else if (carbon[3][sale_status_xx][what_item].equals("Refunded"))     {carbon[3][sale_status_xx][what_item] = "Exported";}
			else if (carbon[3][sale_status_xx][what_item].equals("Exported"))     {carbon[3][sale_status_xx][what_item] = "Error";}
			else if (carbon[3][sale_status_xx][what_item].equals("Error"))        {carbon[3][sale_status_xx][what_item] = "Listed";}
			   else {carbon[3][sale_status_xx][what_item] = "Error";}


			String[][] save_itemd = new String[db_cc_number][1];

			//save info
			for (int loop = 0; loop < carbon[3].length; loop++){//*************

				save_itemd[loop][0] = carbon[3][loop][what_item];

			}//****************************************************************

			jdb_edit_archive edit = new jdb_edit_archive(save_itemd);

			String[][][] archive_display_list = build_archive_display_list();
			dxengine3.display_item(archive_display_list[0], what_item_display);

			infox1.setText("Item " + Integer.toString(what_item + 1) + " saved.");

		}//if***************

	}//*****************************











	public void open_goto_ad(){

		try{

			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
        	java.net.URI uri = new java.net.URI(program_update_url);
       		desktop.browse(uri);

		}catch(Exception e){}

	}//******************************


	public void open_goto_version(){

		try{

			java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
       		java.net.URI uri = new java.net.URI(program_update_url);
        	desktop.browse(uri);

		}catch(Exception e){}

	}//******************************





	public void open_goto_shipping(){

		String urlx = new String(carbon[4][0][56].replace("/shipping_system/site_add_item_api.php", "/shipping_system/index.php"));

		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

		try{

        	java.net.URI uri = new java.net.URI(urlx);
        	desktop.browse(uri);

		}catch(Exception e){}

	}//******************************



	public void open_goto_inventory(){

		String urlx = new String(carbon[4][0][56].replace("/shipping_system/site_add_item_api.php", "/inventory_system/index.php"));

		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

		try{

        	java.net.URI uri = new java.net.URI(urlx);
        	desktop.browse(uri);

		}catch(Exception e){}

	}//******************************



	public void open_goto_add_item(){

		String urlx = new String(carbon[4][0][56].replace("/shipping_system/site_add_item_api.php", "/shipping_system/site_add_item.php"));

		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

		try{

        	java.net.URI uri = new java.net.URI(urlx);
        	desktop.browse(uri);

		}catch(Exception e){}

	}//******************************



	public void open_goto_orders(){

		String urlx = new String(carbon[4][0][56].replace("/shipping_system/site_add_item_api.php", "/order_system/index.php"));

		java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

		try{

       		java.net.URI uri = new java.net.URI(urlx);
       		desktop.browse(uri);

		}catch(Exception e){}

	}//******************************












//***************************************************************************************************************************
//***************************************************************************************************************************






	public void export_csvx(){

		System.out.println("Export CSV " + carbon[4][0][4]);


		int ix0 = 0;

		for (int xloop = 1; xloop < nm.carbon[0][0].length; xloop++) {//****

			ix0++;

		}//*****************************************************************

		System.out.println("build file. " + ix0);
		carbon_export = new String[(ix0 + 1)];

		for (int xloop = 0; xloop < (ix0 + 1); xloop++) {//***********

			carbon_export[xloop] = new String("");

		}//***********************************************************


		for (int xloop = 0; xloop < 100; xloop++) {//*************

			if ( xloop > -1 ) {carbon_export[0] = carbon_export[0] + "\"";}

			carbon_export[0] = carbon_export[0] + nm.db_string[xloop]; 

			if ( xloop < (100 -1) ) {carbon_export[0] = carbon_export[0] + "\",";}
			if ( xloop == (100 -1) ) {carbon_export[0] = carbon_export[0] + "\"";}

		}//*****************************************************


		System.out.println("build file 2.");



		int ix1 = 1;

		for (int xloop = 1; xloop < nm.carbon[0][0].length; xloop++) {//**************

			for (int xloopx = 0; xloopx < 100; xloopx++) {//***

				String cx0 = nm.carbon[0][xloopx][xloop];
				cx0 = cx0.replace("\r\n", " ").replace("\n", " ");
				cx0 = cx0.replace("\"", "$''$");
				cx0 = cx0.replace(",", "$,$");

				cx0 = cx0.replace("[[url]]", nm.carbon[5][urlx_info_xx][nm.current_submit_item_a]);

				if (xloopx > -1) {carbon_export[ix1] = carbon_export[ix1] + "\"";}

				carbon_export[ix1] = carbon_export[ix1] + cx0; 

				if (xloopx < 99) {carbon_export[ix1] = carbon_export[ix1] + "\",";}
				if (xloopx == 99) {carbon_export[ix1] = carbon_export[ix1] + "\"";}

			}//*******************************************

			ix1++;

		}//*******************************************************



		System.out.println("write file.");



		try {

        	BufferedWriter out = new BufferedWriter(new FileWriter(carbon[4][0][4]));

			for (int loop2 = 1; loop2 < carbon_export.length; loop2++) {//***********************

				System.out.println(carbon_export[loop2]);
				out.write(carbon_export[loop2]);
				out.newLine();

			}//for*******************************************************************************
	
        	out.close();

        } catch (IOException e) {System.out.println("print fail.");}


		//JOptionPane.showMessageDialog(null,"Exported. Comma was changed to $,$ and quote was changed to $''$");

	}//***************************








	public void fix_cost_price_tool(){

		System.out.println("Fix Cost Price");

		for (int loop2 = 1; loop2 < carbon[0][0].length; loop2++){//*************************
	

			//test costs
			int ix0 = carbon[0][item_cost_xx][loop2].indexOf(".");

			if (ix0 > -1) {

				String cx0 = carbon[0][item_cost_xx][loop2].substring(ix0, carbon[0][item_cost_xx][loop2].length());

				if (cx0.length() == 2) {carbon[0][item_cost_xx][loop2] = carbon[0][item_cost_xx][loop2] + "0";}
				if (cx0.length() > 3) {carbon[0][item_cost_xx][loop2] = carbon[0][item_cost_xx][loop2].substring(0, ix0 + 3);}

			}//**********



			//test prices
			int ix1 = carbon[0][item_price_xx][loop2].indexOf(".");

			if (ix1 > -1) {

				String cx0 = carbon[0][item_price_xx][loop2].substring(ix0, carbon[0][item_price_xx][loop2].length());

				if (cx0.length() == 2) {carbon[0][item_price_xx][loop2] = carbon[0][item_price_xx][loop2] + "0";}
				if (cx0.length() > 3) {carbon[0][item_price_xx][loop2] = carbon[0][item_price_xx][loop2].substring(0, ix1 + 3);}

			}//**********


		}//**********************************************************************************

	}//*******************************









	public void update_site_inventory(){//****************

		if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon")) {

    		toolkit = Toolkit.getDefaultToolkit();
    		xtimerx = new Timer();
    		xtimerx.schedule(new RemindTask_amazon_inventory(), 0);

		}//*******************************
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay")) {

			if (carbon[4][0][72].equals("1")) {JOptionPane.showMessageDialog(null,"Your updating inventory with Inventory Management: ON");}
			if (carbon[4][0][72].equals("0")) {JOptionPane.showMessageDialog(null,"Your updating inventory with Inventory Management: OFF");}

			update_ebay_ee();

		}//*******************************
		else{}

	}//***************************************************






	public void update_site_sale_price(){//****************

		if (carbon[5][type_info_xx][current_submit_item_a].equals("Amazon")) {

    		toolkit = Toolkit.getDefaultToolkit();
    		xtimerx = new Timer();
    		xtimerx.schedule(new RemindTask_amazon_sale_price(), 0);

		}//******************************************************
		else if (carbon[5][type_info_xx][current_submit_item_a].equals("eBay")) {

			update_ebay_sp();

		}//*********************************************************
		else{}

	}//***************************************************







	public void fix_ebay_id_tool(){

		for (int loop2 = 1; loop2 < carbon[0][0].length; loop2++){//*************************

			carbon[0][ebay_item_xx][loop2] = "ebay_item";
			carbon[0][listing_id_xx][loop2] = "amazon_id";

		}//for*******************************************************************************

		//display_item();

	}//***************************



	public void reset_ebay_id_tool(){

		for (int loop2 = 1; loop2 < carbon[0][0].length; loop2++){//*************************

			carbon[0][ebay_item_xx][loop2] = "ebay_item";

		}//for*******************************************************************************


		for (int loop2 = 1; loop2 < carbon[0][0].length; loop2++){//*************************

			carbon[0][ebay_item_xx][loop2] = carbon[0][ Integer.parseInt(nm.carbon[5][ebay_settings.ebay_listing_id2_xx][nm.current_submit_item_a]) ][loop2];

		}//for*******************************************************************************


		//display_item();

	}//***************************




	public void copy_to_clip() {

		StringSelection selection = new StringSelection(carbon[db_number][what_column][what_item]);
   		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
   		clipboard.setContents(selection, selection);

	}//************************




	public void pro_titlesx() {

		response = JOptionPane.showConfirmDialog(null, "Are you sure you want to rebuild Titles?");

		if(response == 0){

			alchemy_title_seo seo = new alchemy_title_seo();

			//display_item();

		}//***************

	}//************************






	public void pro_tools_yes() {

		try {

			alchemy_pro_tools pt = new alchemy_pro_tools();

		} catch (Exception e) {JOptionPane.showMessageDialog(null,"There is no Pro_tools.class file in your directory");}

	}//*************************






//make price profitable 
	public void push_20p() {

		System.out.println("45 % Profit");

		int ix0 = 0;
		String cx0 = new String("");
		String cx1 = new String("");
		Float fx0 = 0.0f;
		Float fx1 = 0.0f;
		Float fx2 = 0.0f;
		Float fx3 = 0.0f;

		response = JOptionPane.showConfirmDialog(null, "Are you sure? Changes: " + Integer.toString(total_items_selected) + " item(s).");

		if (response == 0) {

			for (int loop2 = 1; loop2 < carbon[0][0].length; loop2++) {//*************************

				if (selected_int[loop2] == 1) {

					System.out.println(carbon[0][title_xx][loop2]);

					try {//**************

						fx0 = Float.parseFloat(carbon[0][item_cost_xx][loop2]);
						fx1 = Float.parseFloat(carbon[0][item_price_xx][loop2]);

						fx2 = (fx0 * 0.45f) + fx0;

						System.out.println("xx " + fx2);


						if (fx2 > fx1 || fx1 < 6) {


							cx0 = Float.toString(fx2);
			 				cx1 = Float.toString(fx2);
			 				ix0 = cx1.indexOf(".");

		         			System.out.println(fx2);

							if (ix0 > -1) {

			 					cx0 = cx1.substring(ix0, cx1.length());

			 					     if (cx0.length() == 1) {cx0 = cx1 + "00";}
			 					else if (cx0.length() == 2) {cx0 = cx1 + "0";}
			 					else if (cx0.length() == 3) {cx0 = cx1;}
			 					else if (cx0.length() > 3)  {cx0 = cx1.substring(0, ix0 + 3);}

			 					System.out.println("x> " + cx0);

							}//***************


		    				fx3 = Float.parseFloat(cx0);

		    				if (fx3 < 6) {cx0 = "5.99";}

		    				carbon[0][item_price_xx][loop2] = cx0; 

		    				if (what_item == loop2) {tf_price.setText(carbon[0][item_price_xx][loop2]);}

		    				System.out.println("pp " + cx0);

						}//********************

						System.out.println(fx2);


					} catch (Exception e) {System.out.println("Errors push");}

				}//**************************

			}//for*******************************************************************************

			//display_item();

		}//response*******

	}//push********************






	public void ship_order_post() {

		response = JOptionPane.showConfirmDialog(null, "Post order to shipping system?");
		if (response == 0) {

			if (carbon[4][0][29].equals("4")) {}
			if (carbon[4][0][29].equals("5")) {email_export_order dotd = new email_export_order();}
			else {alchemy_shipping_system_order ssso = new alchemy_shipping_system_order();}

		}//***************

	}//****************************






	public void export_archive() {

		int xxxxx = what_item;

		response = JOptionPane.showConfirmDialog(null, "Export ALL archived data AT (" + Integer.toString(xxxxx) + ") to the shipping system?");
		if (response == 0) {

			response = JOptionPane.showConfirmDialog(null, "Are you sure?");
			if (response == 0) {

				System.out.println("EXPORT");

    			toolkit = Toolkit.getDefaultToolkit();
    			xtimerx = new Timer();
    			xtimerx.schedule(new RemindTask_export_archive(), 0);

			}//***************

		}//***************

	}//****************************






	public void change_api_p() {

		String response2 = JOptionPane.showInputDialog(null, "Enter the port", "API Port", JOptionPane.QUESTION_MESSAGE);

		if (response2.length() > 0 && Integer.parseInt(response2) > 0) {carbon[4][0][86] = response2;}
		else {System.out.println("Error setting API Port");}

		api_server_port = Integer.parseInt(carbon[4][0][86]);

	}//*************************






	public void change_ebay_fvf() {

		String response2 = JOptionPane.showInputDialog(null, "Enter eBay Final Value", "Fee %", JOptionPane.QUESTION_MESSAGE);

		try {

			if (response2.length() > 0 && Integer.parseInt(response2) > 0) {carbon[4][0][68] = response2;}
			else {System.out.println("Error setting eBay %");}

		} catch (Exception e) {System.out.println("Error setting eBay %");}

	}//***************************






	public void choose_ship_system() {

		System.out.println("SHIP SYSTEM");

		     if (carbon[4][0][29].equals("0")) {}//user
		else if (carbon[4][0][29].equals("1")) {dazzle_export_label xxl = new dazzle_export_label();}
		else if (carbon[4][0][29].equals("2")) {}//UPS
		else if (carbon[4][0][29].equals("3")) {email_export_order emd = new email_export_order();}
		else {System.out.println("Choose ship error");}

	}//******************************







	public void choose_settings_system() {

		if (!account_settings_open) {

			account_settings_open = true;

			     if (carbon[5][type_info_xx][what_item].equals("Amazon"))     {amazon_settings aws = new amazon_settings(what_item);}
			else if (carbon[5][type_info_xx][what_item].equals("Custom"))     {customapi_settings apis = new customapi_settings(what_item);}
			else if (carbon[5][type_info_xx][what_item].equals("eBay"))       {ebay_settings ebays = new ebay_settings(what_item);}
			else if (carbon[5][type_info_xx][what_item].equals("Etsy"))       {etsy_settings etsys = new etsy_settings(what_item);}
			else if (carbon[5][type_info_xx][what_item].equals("Magento"))    {magento_settings mxs = new magento_settings(what_item);}
			else if (carbon[5][type_info_xx][what_item].equals("MySQL"))      {account_settings_open = false;}
			else if (carbon[5][type_info_xx][what_item].equals("PayPal"))     {account_settings_open = false;}
			else {account_settings_open = false;}

		}
	
	}//**************************







	public void save_settings_display() {

  		int testx = 0;
  		//test

		System.out.println("SET " + set_status_on.getSelectedItem());
		System.out.println("SET " + carbon[6][0][what_item_old]);

  		if (!carbon[6][0][what_item_old].equals(set_status_on.getSelectedItem())) {testx++;}
  		if (!carbon[6][1][what_item_old].equals(set_tf_position.getText())) {testx++;}
  		if (!carbon[6][2][what_item_old].equals(set_tf_size.getText())) {testx++;}
  		if (!carbon[6][3][what_item_old].equals(set_status_color.getSelectedItem())) {testx++;}

		if (testx > 0) {//****


			if (set_status_on.getSelectedIndex() == 1) {carbon[6][0][what_item] = "1";}
			else {carbon[6][0][what_item] = "0";}

			carbon[6][1][what_item_old] = set_tf_position.getText();
			carbon[6][2][what_item_old] = set_tf_size.getText();

			if (set_status_color.getSelectedIndex() == 1) {carbon[6][3][what_item] = "Red";}
			else if (set_status_color.getSelectedIndex() == 2) {carbon[6][3][what_item] = "Green";}
			else if (set_status_color.getSelectedIndex() == 3) {carbon[6][3][what_item] = "Blue";}
			else {carbon[6][3][what_item] = "Black";}

			System.out.println("SAVE SETTINGS " + testx);

			save_jdb_settings();

  		}//save***********

		String[][] arrange_display_list = build_arrange_display_list();
		dxengine6.displayx(arrange_display_list, xzx - 10, 360, 0);

		display_save_item6();

	}//**********************************






	public void keyboard_settingsx() {

		System.out.println("SHOW KEYS");

		String keysx = new String("");

		keysx = keysx + "Q = Autoship On/Off\n";
		keysx = keysx + "Esc = Close\n";
		keysx = keysx + "A = Select All\n";
		keysx = keysx + "X = Select All X\n";
		keysx = keysx + "C = Select All Combo\n";
		keysx = keysx + "UP = Move up\n";
		keysx = keysx + "DOWN = Move down\n";
		keysx = keysx + "DELETE = Delete Item(s)\n";
		keysx = keysx + "P = Print\n";
		keysx = keysx + "H = Upload Label\n";
		keysx = keysx + "T = Time++\n";
		keysx = keysx + "S = Import Shipping Status\n";
		keysx = keysx + "U = Import Delivery Status\n";
		keysx = keysx + "W = Fix Weight\n";
		keysx = keysx + "M = Change-C\n";
		keysx = keysx + "Y = Change Account\n";
		keysx = keysx + "K = Print Database\n";


		JOptionPane.showMessageDialog(null, keysx);


	}//******************************





	public void rebuild_display_full() {

		     if (db_number == 0) {create_button();}
		else if (db_number == 1) {monitor_button();}
		else if (db_number == 2) {sold_button();}
		else if (db_number == 3) {archive_button();}
		else if (db_number == 4) {settings_button();}
		else if (db_number == 5) {websites_button();}
		else if (db_number == 6) {display_button();}

	}//********************************







	public void print_id_list() {

		for (int loop1 = 0; loop1 < jdb_load_sales_ids.length; loop1++) {//*****************

			System.out.println(jdb_load_sales_ids[loop1]);

		}//*********************************************************************************

	}//*************************






	public void set_monitor_stats() {

		System.out.println("Set Monitor Stats");

		jdb_loader_monitor_stats stats = new jdb_loader_monitor_stats(); 


		String[][] save_itemd = new String[carbon[1].length][1];

		//save info
		for (int loop = 0; loop < carbon[1].length; loop++){//********

			save_itemd[loop][0] = carbon[1][loop][what_item];

			if(save_itemd[loop][0].length() == 0){save_itemd[loop][0] = new String("0");}

			System.out.println(loop + " " + save_itemd[loop][0].length());

		}//***********************************************************


		jdb_edit_monitor edit = new jdb_edit_monitor(save_itemd);

		jdb_edit_monitor_rank rankx = new jdb_edit_monitor_rank();

		jdb_loader_monitor loadx = new jdb_loader_monitor();

		monitor_button();

	}//*****************************






	public void change_directory_f(){

		System.out.println("Change directory file");

		JFrame frame = new JFrame();

		File file_1 = new File(carbon[4][0][26]);

		JFileChooser fc = new JFileChooser(file_1);

		fc.setCurrentDirectory(new File(file_1.getAbsolutePath()));
		fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		fc.setSelectedFile(file_1);
		frame.setIconImage(ximagex);
		int returnVal = fc.showOpenDialog(frame);

		file_1 = fc.getCurrentDirectory(); //This grabs the File you typed

		System.out.println(file_1);

		file_1 = fc.getSelectedFile(); //This grabs the File you typed

		System.out.println(file_1);

		carbon[4][0][26] = file_1.toString();


		save_jdb_settings(); 

		infox1.setText("Save complete.");

	}//******************************






	public void copy_listing(){

		System.out.println("Copy");

		try{

			JSONObject objx = new JSONObject();
			
			for (int loop = 0; loop < nm.carbon[db_number].length; loop++){//************

		    	objx.put(loop, nm.carbon[db_number][loop][what_item]);

		    }//**************************************************************************

			StringWriter outx = new StringWriter();
			objx.writeJSONString(outx);

			StringSelection selection = new StringSelection(outx.toString());
	   		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
	   		clipboard.setContents(selection, selection);

	   	}catch(Exception e){e.printStackTrace();}

	}//************************





	public void paste_listing(){

		System.out.println("Paste");



		
	}//*************************






	public void refresh_stats_archive() {

		jdb_loader_archive_stats load_stats = new jdb_loader_archive_stats();

		archive_button();

		save_jdb_settings();

		infox1.setText("Save complete.");

	}//**********************************







	public void set_dropdown_website_on_off(int combostart2) {



		if (combostart2 == 0) {

			if (carbon[5][urlx_info_xx][what_item].equals("*")) {tf_urlx.setText("https://mws.amazonservices.com");}

			get_ebay_token.setEnabled(false);
			get_settings_x.setEnabled(true);
	     	tf_passx.setEnabled(true);      
	     	tf_key2x.setEnabled(true);
	     	tf_key1x.setEnabled(true);  
			item_label5_0.setText("Name:");
			item_label5_2.setText("Access Key ID:");
			item_label5_3.setText("Secret Key:");
			item_label5_4.setText("MerchantID:");    
	     	item_label5_5.setText("MarketplaceID:");
	     	tf_passx.setBackground(whitex);
			tf_key1x.setBackground(whitex);
			tf_key2x.setBackground(whitex);

		}
		if (combostart2 == 1) {

			if (carbon[5][urlx_info_xx][what_item].equals("*")) {tf_urlx.setText("https://www.test.com");}

			get_ebay_token.setEnabled(false);
			get_settings_x.setEnabled(true);
			tf_passx.setEnabled(true); 
			tf_key1x.setEnabled(false);
			tf_key2x.setEnabled(false);
			item_label5_0.setText("Name:");
			item_label5_2.setText("User Name:");
			item_label5_3.setText("User Password:");
			item_label5_4.setText("");
			item_label5_5.setText("");
			tf_key1x.setText("");
			tf_key2x.setText("");
			tf_passx.setBackground(whitex);
			tf_key1x.setBackground(gray8);
			tf_key2x.setBackground(gray8);

		}
		if (combostart2 == 2) {

			if (carbon[5][urlx_info_xx][what_item].equals("*")) {tf_urlx.setText("https://api.ebay.com/wsapi");}

			get_ebay_token.setEnabled(true);
			get_settings_x.setEnabled(true);
			tf_passx.setEnabled(false); 
			tf_key1x.setEnabled(false);    
			tf_key2x.setEnabled(false);
			item_label5_0.setText("Name:");
			item_label5_2.setText("Token:");   
			item_label5_3.setText("");
			item_label5_4.setText("");               
			item_label5_5.setText("");
			tf_passx.setText(""); 
			tf_key1x.setText("");
			tf_key2x.setText("");
			tf_passx.setBackground(gray8);
			tf_key1x.setBackground(gray8);
			tf_key2x.setBackground(gray8);

		}
		if (combostart2 == 3) {

			if (carbon[5][urlx_info_xx][what_item].equals("*")) {tf_urlx.setText("https://openapi.etsy.com/v2/");}

			get_ebay_token.setEnabled(false);
			get_settings_x.setEnabled(true);
			tf_passx.setEnabled(true);
			tf_key1x.setEnabled(true);    
			tf_key2x.setEnabled(true);
			item_label5_0.setText("Name:");
			item_label5_2.setText("Keystring:");        
			item_label5_3.setText("Shared Secret:");    
			item_label5_4.setText("Account ID:");
			item_label5_5.setText("Shop Name:");
			tf_passx.setBackground(whitex);
			tf_key1x.setBackground(whitex);
			tf_key2x.setBackground(whitex);

		}
		if (combostart2 == 4) {

			if (carbon[5][urlx_info_xx][what_item].equals("*")) {tf_urlx.setText("http://magentohost.com/index.php/api/");}

			get_ebay_token.setEnabled(false);    
			get_settings_x.setEnabled(true);
			tf_passx.setEnabled(true);
			tf_key1x.setEnabled(false);    
			tf_key2x.setEnabled(false);    
			item_label5_0.setText("Name:");    
			item_label5_2.setText("API User:");         
			item_label5_3.setText("API Key:");
			item_label5_4.setText("");               
			item_label5_5.setText("");
			tf_key1x.setText("");
			tf_key2x.setText("");
			tf_passx.setBackground(whitex);
			tf_key1x.setBackground(gray8);
			tf_key2x.setBackground(gray8);

		}
		if (combostart2 == 5) {

			if (carbon[5][urlx_info_xx][what_item].equals("*")) {tf_urlx.setText("https://web35.ixhost.com");}

			get_ebay_token.setEnabled(false);
			get_settings_x.setEnabled(true);
			tf_passx.setEnabled(true);  
			tf_key1x.setEnabled(false);    
			tf_key2x.setEnabled(false); 
			item_label5_0.setText("Name:");
			item_label5_2.setText("User Name:");        
			item_label5_3.setText("User Password:");
			item_label5_4.setText("");
			item_label5_5.setText("");
			tf_key1x.setText("");
			tf_key2x.setText("");
			tf_passx.setBackground(whitex);
			tf_key1x.setBackground(gray8);
			tf_key2x.setBackground(gray8);

		}
		if (combostart2 == 6) {

			if (carbon[5][urlx_info_xx][what_item].equals("*")) {tf_urlx.setText("https://api.paypal.com"); tf_userx.setText("9292");}

			get_ebay_token.setEnabled(false);
			get_settings_x.setEnabled(true);
			tf_passx.setEnabled(true);
			tf_key1x.setEnabled(false);    
			tf_key2x.setEnabled(false);   
			item_label5_0.setText("Name:");
			item_label5_2.setText("Port:"); 
			item_label5_3.setText("Password:");
			item_label5_4.setText("");            
			item_label5_5.setText("");
			tf_key1x.setText("");
			tf_key2x.setText("");
			tf_passx.setBackground(whitex);
			tf_key1x.setBackground(gray8);
			tf_key2x.setBackground(gray8);
 
		}//********************


	}//*************************************




	public void set_dropdown_fields_on_off() {


			 if (carbon[5][active_info_xx][what_item].equals("no"))  {cb_active.setSelectedIndex(0); cb_sitese.setEnabled(true);}
		else if (carbon[5][active_info_xx][what_item].equals("yes")) {cb_active.setSelectedIndex(1); cb_sitese.setEnabled(false);}
		else {cb_active.setSelectedIndex(0);}

		if (carbon[5][type_info_xx][what_item].equals("Amazon")) {      

	     	cb_sitese.setSelectedIndex(0);
	     	item_label5_2.setText("Access Key ID:");
	     	item_label5_3.setText("Secret Key:");
	     	item_label5_4.setText("MerchantID:");
	     	item_label5_5.setText("MarketplaceID:");
	     	tf_passx.setEnabled(true);
	     	tf_key1x.setEnabled(true);
	     	tf_key2x.setEnabled(true);

		}
		else if (carbon[5][type_info_xx][what_item].equals("Custom")) {  

			cb_sitese.setSelectedIndex(1);
			item_label5_2.setText("User Name:");
			item_label5_3.setText("User Password:");
			item_label5_4.setText("");
			item_label5_5.setText("");
			tf_passx.setEnabled(true);
			tf_key1x.setEnabled(false);
			tf_key2x.setEnabled(false);

		}
		else if (carbon[5][type_info_xx][what_item].equals("eBay")) {        

			cb_sitese.setSelectedIndex(2);    
			item_label5_2.setText("Token:");            
			item_label5_3.setText("");
			item_label5_4.setText("");               
			item_label5_5.setText("");                  
			tf_passx.setEnabled(false); 
			tf_key1x.setEnabled(false);    
			tf_key2x.setEnabled(false);

		}
		else if (carbon[5][type_info_xx][what_item].equals("Etsy")) {        

			cb_sitese.setSelectedIndex(3);    
			item_label5_2.setText("Keystring:");        
			item_label5_3.setText("Shared Secret:");    
			item_label5_4.setText("Account ID:");
			item_label5_5.setText("Shop Name:");
			tf_passx.setEnabled(true);
			tf_key1x.setEnabled(true);
			tf_key2x.setEnabled(true);

		}
		else if (carbon[5][type_info_xx][what_item].equals("Magento")) {     

			cb_sitese.setSelectedIndex(4);    
			item_label5_2.setText("API User:");         
			item_label5_3.setText("API Key:");          
			item_label5_4.setText("");
			item_label5_5.setText("");
			tf_passx.setEnabled(true);
			tf_key1x.setEnabled(false);
			tf_key2x.setEnabled(false);

		}
		else if (carbon[5][type_info_xx][what_item].equals("MySQL")) {    

			cb_sitese.setSelectedIndex(5);
			item_label5_2.setText("User Name:");
			item_label5_3.setText("User Password:");
			item_label5_4.setText("");
			item_label5_5.setText("");
			tf_passx.setEnabled(true);
			tf_key1x.setEnabled(false);
			tf_key2x.setEnabled(false);


		}
		else if (carbon[5][type_info_xx][what_item].equals("PayPal")) {  

			cb_sitese.setSelectedIndex(6);
			item_label5_2.setText("Port:");
			item_label5_3.setText("Password:");
			item_label5_4.setText("");
			item_label5_5.setText("");
			tf_passx.setEnabled(true);
			tf_key1x.setEnabled(false);
			tf_key2x.setEnabled(false);

		}
		else {

	     	cb_sitese.setSelectedIndex(0);
	     	item_label5_2.setText("Access Key ID:");
	     	item_label5_3.setText("Secret Key:");
	     	item_label5_4.setText("MerchantID:");
	     	item_label5_5.setText("MarketplaceID:");
	     	tf_key1x.setEnabled(true);
	     	tf_passx.setEnabled(true);
	     	tf_key2x.setEnabled(true);

		}

	}//**********************************************************



//***************************************************************************************************************************
//***************************************************************************************************************************

	public void frame__windowStateChanged(WindowEvent e) {

	   	// minimized
	    if ((e.getNewState() & Frame.ICONIFIED) == Frame.ICONIFIED) {

	        System.out.println("minimized");

	    }

	    // maximized
	    else if ((e.getNewState() & Frame.MAXIMIZED_BOTH) == Frame.MAXIMIZED_BOTH) {

	        System.out.println("maximized");

	    }//*************************************************************************

	}//**************************************************






    public void keyTyped(KeyEvent e) {}//typed*************************
    public void keyReleased(KeyEvent e) {



		if (e.getKeyCode() == KeyEvent.VK_DELETE) {delete_x();}
		if (e.getKeyCode() == KeyEvent.VK_P) {print_string_csvx();}
		if (e.getKeyCode() == KeyEvent.VK_H) {System.out.println("::::"); }//ftp_upload xxxp = new ftp_upload();
		if (e.getKeyCode() == KeyEvent.VK_L) {print_id_list();}

		//if (e.getKeyCode() == KeyEvent.VK_G) {jpkx[db_number][what_item].setPreferredSize(new Dimension(csv_width,(2))); }

		if (e.getKeyCode() == KeyEvent.VK_T) {

			slow_refresh++; 
			if (slow_refresh > 60) {slow_refresh = 1;} 
			infox2.setText("Refresh loop db 2: " + Integer.toString(slow_refresh) + " of 60.");

		}//***********************************
		if (e.getKeyCode() == KeyEvent.VK_S) { 

			if (db_number == 2 || db_number == 3) {get_shipped_list();} 

		}//***********************************
		if (e.getKeyCode() == KeyEvent.VK_U) { 

			if (db_number == 2 || db_number == 3) {get_delivery_list();} 

		}//***********************************
		if (e.getKeyCode() == KeyEvent.VK_R && db_number == 2) {get_delivery_list_uk();}
		//if (e.getKeyCode() == KeyEvent.VK_W) {weight_fix();}
		//if (e.getKeyCode() == KeyEvent.VK_X) {archived_fix();}
		if (e.getKeyCode() == KeyEvent.VK_M) {System.out.println("CHANGE"); change_c();}
		if (e.getKeyCode() == KeyEvent.VK_Y && db_number == 2) {change_account();}


		if (e.getKeyCode() == KeyEvent.VK_Q) {

			if (auto_sales == 1) {

				auto_sales = 0;
				carbon[4][0][19] = "0";
				infox1.setText("Auto ship System Is OFF. Press Q to Activate.");

			}//*****************
			else {

				response = JOptionPane.showConfirmDialog(null, "Start Auto ship System?");
				if (response == 0) {

					carbon[4][0][19] = "1";
					auto_sales = 1; 
					infox1.setText("Auto ship System Is ON. Press Q to end.");

				}

			}//else

    	}//if************************


		if (e.getKeyCode() == KeyEvent.VK_K) {

			for (int xloop2 = 0; xloop2 < carbon[db_number][0].length; xloop2++) {

				System.out.print(selected_int[xloop2]);

			}//for

		}//**************************


		if (e.getKeyCode() == KeyEvent.VK_D) {

			nm.firex = 0;

			JOptionPane.showMessageDialog(null,"WEBSITES VALUE " + items_value + "\n" + "WEBSITES " + items_total + "\n" + "WEBSITES START " + items_start + "\n" + "WEBSITES END " + items_end + "\n" + "SECTION NUMBER " + section_number0 + "\n" + "DB CC NUMBER ACTIVE " + db_cc_number_active + "\n" + "FIREX " + nm.firex + "\n" + "PROGRAM WORKING " + program_working + "\n");
 
			System.out.println("");
			System.out.println("WEBSITES VALUE " + items_value);
			System.out.println("WEBSITES " + items_total);
			System.out.println("WEBSITES START " + items_start);
			System.out.println("WEBSITES END " + items_end);
			System.out.println("SECTION NUMBER " + section_number0);
			System.out.println("DB CC NUMBER ACTIVE " + db_cc_number_active);
			System.out.println("FIREX " + nm.firex);
			System.out.println("PROGRAM WORKING " + program_working);
			System.out.println("");

		}//print*********************

    }//*********************************








    public void keyPressed(KeyEvent e){



    }//pressed

    public void mousePressed(MouseEvent ev) {

        //if(ev.isPopupTrigger()){menu.show(ev.getComponent(), ev.getX(), ev.getY());}

    }//**************************************

    public void mouseReleased(MouseEvent ev) {

        //if (ev.isPopupTrigger()) {menu.show(ev.getComponent(), ev.getX(), ev.getY());}

    }//***************************************

    public void mouseClicked(MouseEvent ev) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {}






	//handel all the button clicks. 
	public void actionPerformed(ActionEvent event){


		int found_1 = 0;
		//r.gc();

	//File
		if (event.getSource() == amazon_upload_builder)        {amazon_upload_builder aup = new amazon_upload_builder();}
		if (event.getSource() == exportiif)                    {export_iff_button();}
		if (event.getSource() == exportxml)                    {export_xml_button();}
		if (event.getSource() == exportcsv)                    {export_csv_button();}
		if (event.getSource() == exportjson)                   {export_json_button();}
		if (event.getSource() == importaction_csv)             {import_csvx();}
		if (event.getSource() == importaction_xml)             {import_xml_button();}
		if (event.getSource() == importaction_json)            {import_json_button();}
		if (event.getSource() == importblack)                  {import_black_yes();}
		if (event.getSource() == exportcsvinventory)           {csv_export_csv_inventory ecx = new csv_export_csv_inventory();}
		if (event.getSource() == saveAction)                   {save_jdb_settings();}
		if (event.getSource() == loadAction)                   {load_jdb_settings();}
		if (event.getSource() == exitAction)                   {SystemTray.getSystemTray().remove(icon); System.exit(0);}

	//Edit  
		if (event.getSource() == newitem)                      {new_item_yes();}
		if (event.getSource() == copy_to)                      {copy_to();}
		if (event.getSource() == build_url_titles)             {build_url_titles_tool();}
		if (event.getSource() == edititem)                     {edit_item_x();}
		if (event.getSource() == search_b)                     {searchx();}
		if (event.getSource() == replace)                      {replace_xx();}
		if (event.getSource() == copyAction)                   {copy_listing();}
		if (event.getSource() == pasteAction)                  {paste_listing();}
		if (event.getSource() == replace_other)                {replace_xxx();}
		if (event.getSource() == duplicate)                    {duplicate_yes();}
		if (event.getSource() == duplicatex10)                 {duplicatex10_yes();}
		if (event.getSource() == viewer)                       {display_v_x();}
		if (event.getSource() == deleteitem)                   {delete_x();}
		
	//Tools	
		if (event.getSource() == setview)                      {settings_button();}	
		if (event.getSource() == combo)                        {combo_tool();}
		if (event.getSource() == combo2)                       {combo_tool2();}
		if (event.getSource() == combo3)                       {combo_tool3();}
		if (event.getSource() == combo_update_price)           {combo_tool_price();}
		if (event.getSource() == combo_update_price_down)      {combo_tool_price_down();}
		if (event.getSource() == ship_rates)                   {ship_rates_settings();}
		if (event.getSource() == blackmagic)                   {alchemy_blackmagic bm = new alchemy_blackmagic();}
		if (event.getSource() == upload_archive)               {export_archive();}
		if (event.getSource() == shipping_settings_dazzle)     {shipping_ssss();}
		if (event.getSource() == image_3)                      {alchemy_images3 imx3 = new alchemy_images3();}
		if (event.getSource() == amazon_errors)                {get_amazon_erros_x();}
	    if (event.getSource() == custom_update_field)          {update_custom_ee();}
		if (event.getSource() == pro_tools)                    {pro_tools_yes();}
		if (event.getSource() == pro_titles)                   {pro_titlesx();}
		if (event.getSource() == keyboard_settings)            {keyboard_settingsx();}
		if (event.getSource() == disband_combos)               {alchemy_disband_combo_tool dct = new alchemy_disband_combo_tool(); create_button();}
		if (event.getSource() == frame_builder)                {frame_builder_show();}
		if (event.getSource() == fix_cost_price)               {fix_cost_price_tool();}
		if (event.getSource() == fix_ebay_id)                  {fix_ebay_id_tool();}
		if (event.getSource() == reset_ebay_id)                {reset_ebay_id_tool();}
		if (event.getSource() == select_20_profit)             {push_20p();}
		if (event.getSource() == change_api_port)              {change_api_p();}
		if (event.getSource() == change_directory)             {change_directory_f();}
		if (event.getSource() == ebay_final_fee)               {change_ebay_fvf();}
		if (event.getSource() == import_shipping_system)       {get_shipped_list();}
		if (event.getSource() == import_usps_data)             {get_delivery_list();}
		if (event.getSource() == import_royal_data)            {get_delivery_list_uk();}
		if (event.getSource() == tools_rebuild_display)        {rebuild_display_full();}

	//Shipping
		if (event.getSource() == use_item_x)                   {carbon[4][0][29] = "0";}
		if (event.getSource() == use_dazzle)                   {carbon[4][0][29] = "1";}
		if (event.getSource() == use_ups)                      {carbon[4][0][29] = "2";}
		if (event.getSource() == use_email)                    {carbon[4][0][29] = "3";}
		if (event.getSource() == shipping_settings_email)      {email_settings em = new email_settings();}

	//Warehouse
		if (event.getSource() == value_inventory)              {value_inventory_x();}
		if (event.getSource() == weight_inventory)             {weight_inventory_x();}
		if (event.getSource() == update_warehouse_inventory)   {} 
		if (event.getSource() == update_inventory)             {update_inventory_x();}
		if (event.getSource() == export_item)                  {alchemy_export_inventory expii = new alchemy_export_inventory();}
		if (event.getSource() == order_program)                {order_system_show();}

	//Websites
		if (event.getSource() == web_goto_shipping)            {open_goto_shipping();} 
		if (event.getSource() == web_goto_inventory)           {open_goto_inventory();} 
		if (event.getSource() == web_goto_add_item)            {open_goto_add_item();} 
		if (event.getSource() == web_goto_orders)              {open_goto_orders();} 
		if (event.getSource() == amazon_inventory)             {amazon_inventory_ss();}
		if (event.getSource() == amazon_sale_price)            {amazon_sale_price_ss();}
		if (event.getSource() == ebay_inventory)               {update_ebay_ee();}
		if (event.getSource() == ebay_sale_price)              {update_ebay_sp();}
		if (event.getSource() == update_site_sale_price)       {update_site_sale_price();}
		if (event.getSource() == update_site_inventory)        {update_site_inventory();}
		if (event.getSource() == inventory_yes)                {carbon[4][0][72] = "1";}
		if (event.getSource() == inventory_no)                 {carbon[4][0][72] = "0";}

	//SQL
		if (event.getSource() == connectdbo)                   {local_db_set();}
		if (event.getSource() == connectset)                   {remote_db_set();}
		if (event.getSource() == connectcsv)                   {csv_db_set();}
		if (event.getSource() == databasesettings)             {remote_test_sql();}

	//Settings
		if (event.getSource() == get_settings_x)               {choose_settings_system();}
		if (event.getSource() == get_ebay_token)               {get_ebay_token_x();}
		if (event.getSource() == warehousesettings)            {alchemy_warehouse_settings wss = new alchemy_warehouse_settings();}

	//Body buttons left
		if (event.getSource() == new_item)                     {new_item_yes();}
		if (event.getSource() == edit_item)                    {edit_item_x();}
		if (event.getSource() == delete)                       {delete_x();}
		if (event.getSource() == empty_site)                   {empty_yes();}
		if (event.getSource() == view_item)                    {alchemy_view();}

	//Body buttons right
		if (event.getSource() == submit)                       {post_yes();}
		if (event.getSource() == importx)                      {import_yes();}
		if (event.getSource() == refresh)                      {refresh_yes();}
		if (event.getSource() == print_shipping)               {export_dazzle_ll();}
		if (event.getSource() == archivex)                     {archive_db();}

	//Monitor
		if (event.getSource() == refresh_db)                   {refresh_yes();}
		if (event.getSource() == refresh_all_db)               {set_monitor_stats();}
		if (event.getSource() == empty_db)                     {empty_yes();}

	//sold
		if (event.getSource() == importaction_csv_inventory)   {update_inventory_thread();} 
		if (event.getSource() == sold_track)                   {open_tracking_nn();}//send reply message
		if (event.getSource() == sale_status_b)                {sale_status_change();}   
		
	//Archive
		if (event.getSource() == archive_track)                {}
		if (event.getSource() == archive_c3)                   {refresh_stats_archive();}
		if (event.getSource() == sale_status_b_archive)        {sale_status_change_archive();}

	//Connection settings
		if (event.getSource() == ws_save)                      {save_sites(false);}
		if (event.getSource() == ws_test)                      {save_sites(true);}

	//Display
		if (event.getSource() == set_save)                     {save_settings_display();}
		if (event.getSource() == set_rebuild_display)          {alchemy_rebuild_display rbd = new alchemy_rebuild_display();}

	//Footer
		if (event.getSource() == program_message_button)       {test_for_internet();}
		if (event.getSource() == program_version_button)       {test_for_shipping_system();}
		
	//Select
		if (event.getSource() == select_all)                   {select_all_itemsx();}
		if (event.getSource() == select_quantity)              {select_all_itemsx_q();}
		if (event.getSource() == select_combo)                 {select_all_itemsx_combo();}
		if (event.getSource() == select_amazonid)              {select_all_itemsx_amazon();}
		if (event.getSource() == select_ebayid)                {select_all_itemsx_ebay();}

		if (event.getSource() == select_listed)                {select_all_itemsx_listed();}
		if (event.getSource() == select_types)                 {select_all_itemsx_types();}
		if (event.getSource() == select_sites)                 {select_all_itemsx_sites();}

		if (event.getSource() == select_archive_s1)            {select_all_itemsx_q_no_id();}
		if (event.getSource() == select_archive_s2)            {select_all_itemsx_q_g_30();}
		if (event.getSource() == select_archive_s3)            {select_all_itemsx_q_l_100();}




	//drop down***********************************************************************






		if (event.getSource() == cb_active) {

	        //cb = (JComboBox) event.getSource();
	        Object newItemObject = cb_active.getSelectedItem();

			for (int loop1 = 0; loop1 < load_yes_no_list.length; loop1++) {//***

				if (load_yes_no_list[loop1].equals(newItemObject)) {combostart1 = loop1;}

			}//*****************************************************************

			found_1 = 1;

		}//*********************************



		if (event.getSource() == cb_sitese) {

	        //cb = (JComboBox) event.getSource();
	        Object newItemObject = cb_sitese.getSelectedItem();
	        System.out.println("cb_sitese.getSelectedItem() " + cb_sitese.getSelectedItem());

			for (int loop1 = 0; loop1 < load_site_list.length; loop1++) {//s1x

				System.out.println("load_site_list[loop1] " + load_site_list[loop1]);

				if (load_site_list[loop1].equals(newItemObject)) {combostart2 = loop1;}

			}//**************************************************************

			set_dropdown_website_on_off(combostart2);

			found_1 = 1;

		}//if******************************




		if (event.getSource() == cb_active_site) {

	        //cb = (JComboBox) event.getSource();
	        Object newItemObject = cb_active_site.getSelectedItem();

			for (int loop1 = 0; loop1 < cb_active_site.getItemCount(); loop1++) {//s1x

				if (cb_active_site.getItemAt(loop1).equals(newItemObject)) {


					try {

						current_submit_item_x = loop1; 
						//current_submit_item_a = Integer.parseInt(carbon[1][6][(current_submit_item_x -1)]);

						current_submit_item_a = 0;

						for (int loop = 0; loop < carbon[5][name_info_xx].length; loop++) {//********

							if (carbon[5][name_info_xx][loop].equals(carbon[1][0][(current_submit_item_x -1)])) {

								current_submit_item_a = loop;

							}//***********************************************************************

						}//***************************************************************

					} catch(Exception e) {current_submit_item_a = 0; System.out.println("RESET 0 0 RESET");}


					System.out.println("current_submit_item_x " + current_submit_item_x);
					System.out.println("current_submit_item_a " + current_submit_item_a);

				}//if***********************************************

			}//**********************************************************************

			found_1 = 1;

			carbon[4][0][2] = Integer.toString(current_submit_item_x);

			set_button_on_off();
			//reset_fields();


		}//if************************************




		if (event.getSource() == sale_status_cb) {

	        //cb = (JComboBox) event.getSource();
	        Object newItemObject = sale_status_cb.getSelectedItem();

			for (int loop1 = 0; loop1 < sale_status_cb.getItemCount(); loop1++) {//s1x

				if (what_item > 0) {

					if (shipping_status[loop1].equals(newItemObject)) {

						carbon[2][sale_status_xx][what_item] = shipping_status[loop1]; 

					}//*****************************

				}//if**************

			}//**********************************************************************

			found_1 = 1;
			set_button_on_off();

		}//*************************************



		if (event.getSource() == set_status_on) {

	        //cb = (JComboBox) event.getSource();
	        Object newItemObject = set_status_on.getSelectedItem();

			for (int loop1 = 0; loop1 < set_status_on.getItemCount(); loop1++) {//s1x

				if (what_item > 0) {

					if (set_on_off[loop1].equals(newItemObject)) {

						//settings_display[0][what_item] = set_on_off[loop1]; 

					}//*****************************

				}//if**************

			}//**********************************************************************

			found_1 = 1;

		}//************************************



		if (event.getSource() == set_status_color) {

	        //cb = (JComboBox) event.getSource();
	        Object newItemObject = set_status_color.getSelectedItem();

			for (int loop1 = 0; loop1 < set_status_color.getItemCount(); loop1++) {//s1x

				if (what_item > 0) {

					//if(color_choice[loop1].equals(newItemObject)){settings_display[3][what_item] = color_choice[loop1];}

				}//if*************

			}//************************************************************************

			found_1 = 1;

		}//***************************************




		if (event.getSource() == cb_search_field) {

	        //cb = (JComboBox) event.getSource();
	        Object newItemObject = cb_search_field.getSelectedItem();

			for (int loop1 = 0; loop1 < cb_search_field.getItemCount(); loop1++){//s1x

				if (load_search_list[loop1].equals(newItemObject)) {

					what_search_field = loop1; 
					save_settings_pp(); 
					System.out.println("cb_search_field " + what_search_field);

				}//*******************************

			}//*********************

			found_1 = 1;

		}//**************************************






	}//actionPerformed	
	//***************************************************************************************************************************
	//***************************************************************************************************************************





    public void propertyChange(PropertyChangeEvent evt) {

    	System.out.println("propertyChange");
		
    	System.out.println("Name      =D " + evt.getPropertyName());
        System.out.println("Old Value =D " + evt.getOldValue());
        System.out.println("New Value =D " + evt.getNewValue());

        if (evt.getPropertyName().equals("totalItemsSelected")) {

        	total_items_selected = (Integer) evt.getNewValue();

        }//******************************************************


        if (evt.getPropertyName().equals("sortClick")) {

        	sort_string = evt.getNewValue().toString();

        	System.out.println("sort_string " + sort_string);

        	if (db_number == 0) {

        		for (int loop1 = 0; loop1 < db_string.length; loop1++) {

        			if (db_string[loop1].equals(sort_string)) {

        				sort_int = loop1;
        				break;

        			}//****************************************

        		}//*****************************************************

        		System.out.println("sort_int " + sort_int);

        		//If the user is searching we cannot do a full reload. 
        		if (!searching) {

        			create_button();

        		}//**************
        		else {

        			sortx_engine();

					int[] warningsx = test_warnings();
					int[] errorsx = test_errors();
					show_errors();
					dxengine0.setWarningList(warningsx);
					dxengine0.setErrorList(errorsx);
					String[][][] export_display_list = build_export_display_list();
					dxengine0.display_item(export_display_list[0], what_item_display);

        		}//***

        	}//******************

        }//*********************************************



    	if (evt.getPropertyName().equals("Preview")) {alchemy_view();}
    	if (evt.getPropertyName().equals("Edit")) {edit_item_x();}
    	if (evt.getPropertyName().equals("Duplicate")) {duplicate_yes();;}
    	if (evt.getPropertyName().equals("Delete")) {delete_x();}
    	if (evt.getPropertyName().equals("Copy")) {copy_to_clip();}
    	if (evt.getPropertyName().equals("Paste")) {}
    		
    	if (evt.getPropertyName().equals("PrintLabel")) {}
    	if (evt.getPropertyName().equals("FTPLabel")) {alchemy_ftp_label sfl = new alchemy_ftp_label();}
    	if (evt.getPropertyName().equals("XMLPostback")) {

    		dazzle_xml_postback sgxml = new dazzle_xml_postback(); 
    		sold_tracking.setText(carbon[2][tracking_number_xx][what_item]); 
    		sold_tf_so.setText(carbon[2][shipping_out_xx][what_item]);

    	}//***********************************************

    	if (evt.getPropertyName().equals("SSOrder")) {ship_order_post();}
    	if (evt.getPropertyName().equals("PostTracking")) {ship_post_tracking_number_choose();}
    	if (evt.getPropertyName().equals("Feedback")) {ebay_leave_feedback slf = new ebay_leave_feedback(what_item);}
    	if (evt.getPropertyName().equals("ReturnLabel")) {export_dazzle_return_ll();}

    	if (evt.getPropertyName().equals("Export")) {post_yes();}
    	if (evt.getPropertyName().equals("Import")) {import_yes();}
    	if (evt.getPropertyName().equals("ShippingLabel")) {export_dazzle_ll();}
    	if (evt.getPropertyName().equals("Hide")) {}

    	if (evt.getPropertyName().equals("CSV")) {export_csv_button();}
    	if (evt.getPropertyName().equals("IFF")) {export_iff_button();}
    	if (evt.getPropertyName().equals("XML")) {export_xml_button();}
    	if (evt.getPropertyName().equals("JSON")) {export_json_button();}




    	if (evt.getPropertyName().equals("leftClick")) {

    		if (db_number == 0) {

	    		System.out.println("leftClick 0");
		        what_item = (Integer) evt.getNewValue();
		        selected_int = dxengine0.getSelectedValues();
		        display_save_item0();
		        what_item_old = what_item;

		    }//*******************
		    if (db_number == 1) {

		    	what_item = (Integer) evt.getNewValue();
	    		display_save_item1();
				what_item_old = what_item;

			}//*******************
		    if (db_number == 2) {

	    		what_item = (Integer) evt.getNewValue();
	    		selected_int = dxengine2.getSelectedValues();
				display_save_item2();
				what_item_old = what_item;

    		}//******************
	    	if (db_number == 3) {

	    		what_item = (Integer) evt.getNewValue();
	    		selected_int = dxengine3.getSelectedValues();
	    		display_save_item3();
				what_item_old = what_item;

	    	}//*******************
	    	if (db_number == 4) {

	    		what_item = (Integer) evt.getNewValue();
				what_item_old = what_item;

	    	}//******************
	    	if (db_number == 5) {

	    		item_label5x_0.setText("");

	    		what_item = (Integer) evt.getNewValue();
	    		selected_int = dxengine5.getSelectedValues();
	    		display_save_item5();
				what_item_old = what_item;

	    	}//*******************
	    	if (db_number == 6) {

	    		what_item = (Integer) evt.getNewValue();
	    		selected_int = dxengine6.getSelectedValues();
	    		display_save_item6();
				what_item_old = what_item;

	    	}//*******************

    	}//*********************************************


		if (evt.getPropertyName().equals("doubleClick")) {

			if (db_number == 0) {edit_item_x();}
			if (db_number == 5) {edit_item_x();}

		}//***********************************************





    }//****************************************************








	public void SysTray_message() {


		new_sales_int = 0;

		for (int loop2 = 0; loop2 < carbon[2][0].length; loop2++){//*************************

			if (carbon[2][sale_status_xx][loop2].equals("Sold")) {new_sales_int++;}

		}//for*******************************************************************************


      	icon.displayMessage("Alchemist", Integer.toString(new_sales_int) + " new sale(s)", TrayIcon.MessageType.INFO);


	}//*****************************






	public void SysTray() {

		try {


	 		Image ximage = ImageIO.read(getClass().getResourceAsStream("images/gold_tray.png"));

      		icon = new TrayIcon(ximage, carbon[4][0][13] + " API on port: " + carbon[4][0][86]);
     		icon.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){

            	//JOptionPane.showMessageDialog(null, "Open!");

       		}
     		});

     		SystemTray.getSystemTray().add(icon);


		} catch (Exception e) {}

	}//last8********************************************











    public static void main(String[] args){

		nm xr = new nm();

    }//main






}//last************************************************************************************************|||||||||||||||||||||
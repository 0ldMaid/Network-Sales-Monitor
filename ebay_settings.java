import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import javax.swing.JOptionPane;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;




public class ebay_settings extends JFrame implements ActionListener{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 700;
int xzy = 700;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


//Alchemist eBay Keys
static String ebay_api_developer = new String("a2e5bb52-b43d-4fad-8db9-2ea2c8c65c06");
static String ebay_api_application = new String("Alchemis-5458-4dac-ab21-a6ab7bfc1422");
static String ebay_api_certificate = new String("785bafce-f33e-4381-8ef3-e26c2a9d2f72");

JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);

int current_submit_item_here;

JTextArea jtexta_des = new JTextArea("", 9, 40);

String dd_type_shipping[] = new String[3];
String dd_local_ww[] = new String[2];
String dd_us_uk[] = new String[2];
String dd_listing_duration[] = new String[3];

JTextField location_zip = new JTextField("", 12);

JLabel info_header2_1 = new JLabel("Import ?? days past:", JLabel.LEFT);
JLabel info_header2_2 = new JLabel("Import ONLY inventoried items.", JLabel.RIGHT);
JTextField sales_days_past = new JTextField("", 12);

JComboBox shipping_location = new JComboBox();
JComboBox shipping_type = new JComboBox();
JComboBox match_column = new JComboBox();
JComboBox match_type = new JComboBox();
JComboBox export_mail_type = new JComboBox();

JCheckBox import_everything = new JCheckBox();

JLabel over_2_units_l = new JLabel("If Quantity sold > ", JLabel.LEFT);
JLabel switch_to_l = new JLabel("Switch (package) to: ", JLabel.LEFT);
JLabel in_this_field_l = new JLabel("In field: ", JLabel.LEFT);
JTextField over_2_units_tf = new JTextField("", 5);
JTextField switch_to_tf = new JTextField("", 12);
JComboBox in_this_field_cb = new JComboBox();

JLabel over_2_units_l2 = new JLabel("If Quantity sold > ", JLabel.LEFT);
JLabel switch_to_l2 = new JLabel("Switch (mail type) to: ", JLabel.LEFT);
JLabel in_this_field_l2 = new JLabel("In field: ", JLabel.LEFT);
JTextField over_2_units_tf2 = new JTextField("", 5);
JTextField switch_to_tf2 = new JTextField("", 12);
JComboBox in_this_field_cb2 = new JComboBox();

JLabel over_2_weight_l = new JLabel("If total Weight > ", JLabel.LEFT);
JLabel weight_switch_to_l = new JLabel("Switch (package) to: ", JLabel.LEFT);
JLabel weight_in_this_field_l = new JLabel("In field: ", JLabel.LEFT);
JTextField over_2_weight_tf = new JTextField("", 5);
JTextField weight_switch_to_tf = new JTextField("", 12);
JComboBox weight_in_this_field_cb = new JComboBox();

JLabel over_2_weight_l2 = new JLabel("If total Weight > ", JLabel.LEFT);
JLabel weight_switch_to_l2 = new JLabel("Switch (mail type) to: ", JLabel.LEFT);
JLabel weight_in_this_field_l2 = new JLabel("In field: ", JLabel.LEFT);
JTextField over_2_weight_tf2 = new JTextField("", 5);
JTextField weight_switch_to_tf2 = new JTextField("", 12);
JComboBox weight_in_this_field_cb2 = new JComboBox();

JLabel tax_state_l = new JLabel("We charge tax in: ", JLabel.RIGHT);
JLabel tax_amount_l = new JLabel("%:", JLabel.RIGHT);
JTextField tax_state = new JTextField("", 5);
JTextField tax_amount = new JTextField("", 5);

JLabel not_international_l = new JLabel("If the sale is NOT international then use (MAIL TYPE) settings in this field: ", JLabel.LEFT);
JComboBox not_international_cb = new JComboBox();

JLabel shipping_cost_l = new JLabel("Shipping cost type: ", JLabel.RIGHT);
JLabel shipping_to_l = new JLabel("Ships to: ", JLabel.RIGHT);

JLabel loop_for_mail_type_l = new JLabel("(MAIL TYPE): ", JLabel.RIGHT);

JLabel paypal_payment_email_l = new JLabel("Paypal e-mail: ", JLabel.RIGHT);
JTextField paypal_email = new JTextField("", 13);

JLabel shipping_if_flat_l = new JLabel("FLAT RATE International: ", JLabel.RIGHT);
JTextField shipping_flat_rate = new JTextField("", 13);

JLabel ship_from_location_l = new JLabel("Ships from: ", JLabel.RIGHT);
JTextField ship_from_location_tf = new JTextField("", 13);

JLabel ship_from_zip_l = new JLabel("Ships from zip: ", JLabel.RIGHT);
JTextField ship_from_zip_tf = new JTextField("", 13);

JLabel ebay_site_l = new JLabel("eBay Site: ", JLabel.RIGHT);
JComboBox ebay_site_cb = new JComboBox();

JLabel feedback_l = new JLabel("Feedback Text: ", JLabel.RIGHT);
JTextField feedback_tf = new JTextField("", 13);

JLabel category_l = new JLabel("Listing Category: ", JLabel.RIGHT);
JTextField category_tf = new JTextField("", 5);
JComboBox category_cb = new JComboBox();

JLabel store_category1_l = new JLabel("Store Category 1 ", JLabel.RIGHT);
JComboBox store_category1_cb = new JComboBox();

JLabel ebay_duration_l = new JLabel("Listing duration: ", JLabel.RIGHT);
JComboBox ebay_duration_cb = new JComboBox();

JLabel logox = new JLabel("", JLabel.CENTER);

JButton des_view1 = new JButton("View");
JButton des_view2 = new JButton("With Item");
JButton des_build1 = new JButton("Standard1");
JButton des_build2 = new JButton("Standard2");
JButton save_db = new JButton("Save");

JLabel ebay_shipping_settings_l = new JLabel("Shipping Carrier POST: ", JLabel.LEFT);
JTextField ebay_shipping_settings = new JTextField("", 15);

JLabel ebay_upc_l = new JLabel("eBay UPC Info: ", JLabel.RIGHT);
JComboBox ebay_upc_cb = new JComboBox();

JLabel ebay_listing_id2_l = new JLabel("eBay ID info: ", JLabel.RIGHT);
JComboBox ebay_listing_id2_cb = new JComboBox();


//settings for ebay
//0 - 15 defined in nm
static int match_type_xx = 16;
static int match_column_xx = 17;
static int shipping_type_xx = 18;
static int shipping_location_xx = 19; //US or other
static int shipping_zip_xx = 20;
static int paypal_email_xx = 21;
static int tax_state_xx = 22;
static int tax_amount_xx = 23;
static int ship_not_international_xx = 24;
static int ship_from_state_xx = 25;
static int ebay_site_xx = 26;
static int feedback_message_xx = 27;
static int ebay_category_xx = 28;
static int ebay_store_category1_xx = 29;
static int ebay_duration_xx = 30;
static int ebay_shipping_type_xx = 31;
static int ebay_upc_xx = 32;
static int ebay_listing_id2_xx = 33;

static int sales_days_past_xx = 82;
static int import_everything_xx = 83;
static int ship_change_quantity_xx = 84;
static int ship_change_type_xx = 85;
static int ship_change_field_xx = 86;
static int template_xx = 87;
static int ship_change_quantity_xx2 = 88;
static int ship_change_type_xx2 = 89;
static int ship_change_field_xx2 = 90;
static int export_mail_type_xx = 91;
static int shipping_flat_rate_xx = 92;
static int ship_weight_change_quantity_xx = 93;
static int ship_weight_change_type_xx = 94;
static int ship_weight_change_field_xx = 95;
static int ship_weight_change_quantity_xx2 = 96;
static int ship_weight_change_type_xx2 = 97;
static int ship_weight_change_field_xx2 = 98;





ebay_settings(int what_item) {//*******************************************************************************************************

	super("eBay Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex_x(); nm.account_settings_open = false;}});

    // We save the edit item so that if the user clicks on a new item and then saves we don't get errors. 
    current_submit_item_here = what_item;

	// Load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	paypal_email.setToolTipText("PayPal e-mail");

	tax_state_l.setPreferredSize(new Dimension(120, 20));
	tax_amount_l.setPreferredSize(new Dimension(20, 20));
	shipping_cost_l.setPreferredSize(new Dimension(120, 20));
	shipping_to_l.setPreferredSize(new Dimension(120, 20));
	shipping_if_flat_l.setPreferredSize(new Dimension(120, 20));
	ship_from_location_l.setPreferredSize(new Dimension(120, 20));
	ebay_site_l.setPreferredSize(new Dimension(120, 20));
	ship_from_zip_l.setPreferredSize(new Dimension(120, 20));
	ebay_listing_id2_l.setPreferredSize(new Dimension(120, 20));
	ebay_duration_l.setPreferredSize(new Dimension(120, 20));
	store_category1_l.setPreferredSize(new Dimension(120, 20));
	category_l.setPreferredSize(new Dimension(120, 20));
	feedback_l.setPreferredSize(new Dimension(120, 20));
	ebay_upc_l.setPreferredSize(new Dimension(120, 20));
	paypal_payment_email_l.setPreferredSize(new Dimension(120, 20));
	loop_for_mail_type_l.setPreferredSize(new Dimension(120, 20));
	loop_for_mail_type_l.setToolTipText("Shipping EXPORT (MAIL TYPE) FIRST, PRIORITY, EXPRESS: ");


	weight_switch_to_l.setPreferredSize(new Dimension(123, 20));
	weight_switch_to_l2.setPreferredSize(new Dimension(123, 20));

	switch_to_l.setPreferredSize(new Dimension(123, 20));
	switch_to_l2.setPreferredSize(new Dimension(123, 20));

	over_2_units_l.setPreferredSize(new Dimension(97, 20));
	over_2_units_l2.setPreferredSize(new Dimension(97, 20));

	over_2_weight_l.setPreferredSize(new Dimension(97, 20));
	over_2_weight_l2.setPreferredSize(new Dimension(97, 20));


	infoxs.setPreferredSize(new Dimension(xzx -40, 20));
	infoxs.setBackground(nm.blackx);
	infoxs.setForeground(nm.whitex);

	infox0.setPreferredSize(new Dimension(xzx -30, 20));
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.blackx);

	infox1.setPreferredSize(new Dimension(xzx -30, 20));
	infox1.setBackground(nm.blackx);
	infox1.setForeground(nm.blackx);




	jtexta_des.setWrapStyleWord(true);
	jtexta_des.setLineWrap(true);
	jtexta_des.setWrapStyleWord(true);

	FlowLayout flow = new FlowLayout(0);
	flow.setHgap(0);
	flow.setVgap(0);



	save_db.setMargin(new Insets(0, 0, 0, 0));
  	save_db.addActionListener(this);
 	save_db.setPreferredSize(new Dimension(120, 30));
	save_db.setBackground(nm.st_gray1);
	save_db.setHorizontalTextPosition(JButton.CENTER);
 	save_db.setForeground(nm.blackx);
	save_db.setToolTipText("Save database");




	match_column = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][match_column_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][match_column_xx][current_submit_item_here]);
		match_column.setSelectedIndex(ix0);

	} catch (Exception e) {match_column.setSelectedIndex(0);}
	match_column.addActionListener(this);
	match_column.setPreferredSize(new Dimension(150, 20));
	match_column.setToolTipText("Set Match Info Location");



	dd_type_shipping[0] = new String("FREE");
	dd_type_shipping[1] = new String("FLAT");
	dd_type_shipping[2] = new String("CALCULATED");

	shipping_type = new JComboBox(dd_type_shipping);
	try {

		System.out.println(nm.carbon[5][shipping_type_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][shipping_type_xx][current_submit_item_here]);
		shipping_type.setSelectedIndex(ix0);

	} catch (Exception e) {shipping_type.setSelectedIndex(0);}
	shipping_type.addActionListener(this);
	shipping_type.setPreferredSize(new Dimension(148, 20));
	shipping_type.setToolTipText("Set shipping type");
	shipping_type.setEnabled(false);



	dd_local_ww[0] = new String("Local Only");
	dd_local_ww[1] = new String("Worldwide");

	shipping_location = new JComboBox(dd_local_ww);
	try {

		System.out.println(nm.carbon[5][shipping_location_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][shipping_location_xx][current_submit_item_here]);
		shipping_location.setSelectedIndex(ix0);

	} catch (Exception e) {shipping_location.setSelectedIndex(0);}
	shipping_location.addActionListener(this);
	shipping_location.setPreferredSize(new Dimension(148, 20));
	shipping_location.setToolTipText("Set shipping type");



	info_header2_1.setPreferredSize(new Dimension(130, 20));
	info_header2_1.setToolTipText("Integer less then 30. OR YYYY-MM: 2012-03");
	info_header2_2.setPreferredSize(new Dimension(330, 20));



	in_this_field_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_change_field_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ship_change_field_xx][current_submit_item_here]);
		in_this_field_cb.setSelectedIndex(ix0);

	} catch (Exception e) {in_this_field_cb.setSelectedIndex(0);}
	in_this_field_cb.addActionListener(this);
	in_this_field_cb.setPreferredSize(new Dimension(150, 20));
	in_this_field_cb.setToolTipText("Set Match Type");



	in_this_field_cb2 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_change_field_xx2][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ship_change_field_xx2][current_submit_item_here]);
		in_this_field_cb2.setSelectedIndex(ix0);

	} catch (Exception e) {in_this_field_cb2.setSelectedIndex(0);}
	in_this_field_cb2.addActionListener(this);
	in_this_field_cb2.setPreferredSize(new Dimension(150, 20));
	in_this_field_cb2.setToolTipText("Set Match Type");



	weight_in_this_field_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_weight_change_field_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ship_weight_change_field_xx][current_submit_item_here]);
		weight_in_this_field_cb.setSelectedIndex(ix0);

	} catch (Exception e) {weight_in_this_field_cb.setSelectedIndex(0);}
	weight_in_this_field_cb.addActionListener(this);
	weight_in_this_field_cb.setPreferredSize(new Dimension(150, 20));
	weight_in_this_field_cb.setToolTipText("Set Match Type");



	weight_in_this_field_cb2 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_weight_change_field_xx2][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ship_weight_change_field_xx2][current_submit_item_here]);
		weight_in_this_field_cb2.setSelectedIndex(ix0);

	} catch (Exception e) {weight_in_this_field_cb2.setSelectedIndex(0);}
	weight_in_this_field_cb2.addActionListener(this);
	weight_in_this_field_cb2.setPreferredSize(new Dimension(150, 20));
	weight_in_this_field_cb2.setToolTipText("Set Match Type");



	not_international_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_not_international_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ship_not_international_xx][current_submit_item_here]);
		not_international_cb.setSelectedIndex(ix0);

	} catch (Exception e) {not_international_cb.setSelectedIndex(0);}
	not_international_cb.addActionListener(this);
	not_international_cb.setPreferredSize(new Dimension(150, 20));
	not_international_cb.setToolTipText("Set Match Type");



	export_mail_type = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][export_mail_type_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][export_mail_type_xx][current_submit_item_here]);
		export_mail_type.setSelectedIndex(ix0);

	} catch (Exception e) {export_mail_type.setSelectedIndex(0);}
	export_mail_type.addActionListener(this);
	export_mail_type.setPreferredSize(new Dimension(150, 20));
	export_mail_type.setToolTipText("Export Mail Type");



	dd_us_uk[0] = new String("eBay U.S.");
	dd_us_uk[1] = new String("eBay U.K.");

	ebay_site_cb = new JComboBox(dd_us_uk);
	try {

		System.out.println(nm.carbon[5][ebay_site_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ebay_site_xx][current_submit_item_here]);
		ebay_site_cb.setSelectedIndex(ix0);

	} catch (Exception e) {

		ebay_site_cb.setSelectedIndex(0); 
		nm.carbon[5][ebay_site_xx][current_submit_item_here] = "0";

	}
	ebay_site_cb.addActionListener(this);
	ebay_site_cb.setPreferredSize(new Dimension(148, 20));
	ebay_site_cb.setToolTipText("eBay site");



	store_category1_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ebay_store_category1_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ebay_store_category1_xx][current_submit_item_here]);
		store_category1_cb.setSelectedIndex(ix0);

	} catch (Exception e) {

		store_category1_cb.setSelectedIndex(0); 
		nm.carbon[5][ebay_store_category1_xx][current_submit_item_here] = "0";

	}
	store_category1_cb.addActionListener(this);
	store_category1_cb.setPreferredSize(new Dimension(148, 20));
	store_category1_cb.setToolTipText("eBay site");



	category_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ebay_category_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ebay_category_xx][current_submit_item_here]);
		category_cb.setSelectedIndex(ix0);

	} catch (Exception e) {

		category_cb.setSelectedIndex(0); 
		nm.carbon[5][ebay_category_xx][current_submit_item_here] = "0";

	}
	category_cb.addActionListener(this);
	category_cb.setPreferredSize(new Dimension(148, 20));
	category_cb.setToolTipText("eBay site");



	dd_listing_duration[0] = new String("GTC");
	dd_listing_duration[1] = new String("3_DAYS");
	dd_listing_duration[2] = new String("30_DAYS");

	ebay_duration_cb = new JComboBox(dd_listing_duration);
	try {

		System.out.println(nm.carbon[5][ebay_duration_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ebay_duration_xx][current_submit_item_here]);
		ebay_duration_cb.setSelectedIndex(ix0);

	} catch (Exception e) {

		ebay_duration_cb.setSelectedIndex(0); 
		nm.carbon[5][ebay_duration_xx][current_submit_item_here] = "0";

	}//********************
	ebay_duration_cb.addActionListener(this);
	ebay_duration_cb.setPreferredSize(new Dimension(148, 20));
	ebay_duration_cb.setToolTipText("eBay site");



	ebay_upc_cb = new JComboBox(nm.db_string);
	try { 

		System.out.println(nm.carbon[5][ebay_upc_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ebay_upc_xx][current_submit_item_here]);
		ebay_upc_cb.setSelectedIndex(ix0);

	} catch (Exception e) {ebay_upc_cb.setSelectedIndex(0);}
	ebay_upc_cb.addActionListener(this);
	ebay_upc_cb.setPreferredSize(new Dimension(150, 20));
	ebay_upc_cb.setToolTipText("Set UPC Location");



	ebay_listing_id2_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ebay_listing_id2_xx][current_submit_item_here]);
		int ix0 = Integer.parseInt(nm.carbon[5][ebay_listing_id2_xx][current_submit_item_here]);
		ebay_listing_id2_cb.setSelectedIndex(ix0);

	} catch (Exception e) {ebay_listing_id2_cb.setSelectedIndex(0);}
	ebay_listing_id2_cb.addActionListener(this);
	ebay_listing_id2_cb.setPreferredSize(new Dimension(150, 20));
	ebay_listing_id2_cb.setToolTipText("Set Listing ID save location");



	JPanel jpk0_p0 = new JPanel();
	jpk0_p0.setPreferredSize(new Dimension(350, 40));
	jpk0_p0.setBackground(nm.st_gray1);
	jpk0_p0.add(shipping_if_flat_l);   jpk0_p0.add(shipping_flat_rate);

	JPanel jpk0_p0x = new JPanel();
	jpk0_p0x.setPreferredSize(new Dimension(295, 40));
	jpk0_p0x.setBackground(nm.st_gray1);
	jpk0_p0x.add(shipping_cost_l);          jpk0_p0x.add(shipping_type);


	JPanel jpk0_p1 = new JPanel();
	jpk0_p1.setPreferredSize(new Dimension(350, 40));
	jpk0_p1.setBackground(nm.st_gray1);
	jpk0_p1.add(tax_state_l);    	   jpk0_p1.add(tax_state);
	jpk0_p1.add(tax_amount_l);         jpk0_p1.add(tax_amount);

	JPanel jpk0_p1x = new JPanel();
	jpk0_p1x.setPreferredSize(new Dimension(295, 40));
	jpk0_p1x.setBackground(nm.st_gray1);
	jpk0_p1x.add(category_l);          jpk0_p1x.add(category_cb);


	JPanel jpk0_p2 = new JPanel();
	jpk0_p2.setPreferredSize(new Dimension(350, 40));
	jpk0_p2.setBackground(nm.st_gray1);
	jpk0_p2.add(paypal_payment_email_l); jpk0_p2.add(paypal_email);

	JPanel jpk0_p2x = new JPanel();
	jpk0_p2x.setPreferredSize(new Dimension(295, 40));
	jpk0_p2x.setBackground(nm.st_gray1);
	jpk0_p2x.add(ebay_duration_l);        jpk0_p2x.add(ebay_duration_cb);


	JPanel jpk0_p3 = new JPanel();
	jpk0_p3.setPreferredSize(new Dimension(350, 40));
	jpk0_p3.setBackground(nm.st_gray1);
	jpk0_p3.add(feedback_l);          jpk0_p3.add(feedback_tf);

	JPanel jpk0_p3x = new JPanel();
	jpk0_p3x.setPreferredSize(new Dimension(295, 40));
	jpk0_p3x.setBackground(nm.st_gray1);
	jpk0_p3x.add(loop_for_mail_type_l);   jpk0_p3x.add(export_mail_type);


	JPanel jpk0_p4 = new JPanel();
	jpk0_p4.setPreferredSize(new Dimension(350, 40));
	jpk0_p4.setBackground(nm.st_gray1);
	jpk0_p4.add(ship_from_location_l);   jpk0_p4.add(ship_from_location_tf);

	JPanel jpk0_p4x = new JPanel();
	jpk0_p4x.setPreferredSize(new Dimension(295, 40));
	jpk0_p4x.setBackground(nm.st_gray1);
	jpk0_p4x.add(store_category1_l);   jpk0_p4x.add(store_category1_cb);


	JPanel jpk0_p5 = new JPanel();
	jpk0_p5.setPreferredSize(new Dimension(350, 40));
	jpk0_p5.setBackground(nm.st_gray1);
	jpk0_p5.add(ship_from_zip_l);   jpk0_p5.add(ship_from_zip_tf);
	
	JPanel jpk0_p5x = new JPanel();
	jpk0_p5x.setPreferredSize(new Dimension(295, 40));
	jpk0_p5x.setBackground(nm.st_gray1);
	jpk0_p5x.add(ebay_upc_l);          jpk0_p5x.add(ebay_upc_cb);


	JPanel jpk0_p6 = new JPanel();
	jpk0_p6.setPreferredSize(new Dimension(350, 40));
	jpk0_p6.setBackground(nm.st_gray1);
	
	JPanel jpk0_p6x = new JPanel();
	jpk0_p6x.setPreferredSize(new Dimension(295, 40));
	jpk0_p6x.setBackground(nm.st_gray1);
	jpk0_p6x.add(shipping_to_l);   jpk0_p6x.add(shipping_location);


	JPanel jpk0_p7 = new JPanel();
	jpk0_p7.setPreferredSize(new Dimension(350, 40));
	jpk0_p7.setBackground(nm.st_gray1);

	JPanel jpk0_p7x = new JPanel();
	jpk0_p7x.setPreferredSize(new Dimension(295, 40));
	jpk0_p7x.setBackground(nm.st_gray1);
	jpk0_p7x.add(ebay_listing_id2_l);   jpk0_p7x.add(ebay_listing_id2_cb);


	JPanel jpk0_p8 = new JPanel();
	jpk0_p8.setPreferredSize(new Dimension(350, 40));
	jpk0_p8.setBackground(nm.st_gray1);

	JPanel jpk0_p8x = new JPanel();
	jpk0_p8x.setPreferredSize(new Dimension(295, 40));
	jpk0_p8x.setBackground(nm.st_gray1);
	jpk0_p8x.add(ebay_site_l);          jpk0_p8x.add(ebay_site_cb);

          

	TitledBorder titled1 = BorderFactory.createTitledBorder("Export Settings");
	titled1.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk0_0 = new JPanel();
	jpk0_0.setPreferredSize(new Dimension(xzx -25, 440));
	jpk0_0.setBackground(nm.st_gray1);
	jpk0_0.setBorder(titled1);
	jpk0_0.add(jpk0_p0);    jpk0_0.add(jpk0_p0x);
	jpk0_0.add(jpk0_p1);    jpk0_0.add(jpk0_p1x);
	jpk0_0.add(jpk0_p2);    jpk0_0.add(jpk0_p2x);
	jpk0_0.add(jpk0_p3);    jpk0_0.add(jpk0_p3x);
	jpk0_0.add(jpk0_p4);    jpk0_0.add(jpk0_p4x);
	jpk0_0.add(jpk0_p5);    jpk0_0.add(jpk0_p5x);
	jpk0_0.add(jpk0_p6);    jpk0_0.add(jpk0_p6x);
	jpk0_0.add(jpk0_p7);    jpk0_0.add(jpk0_p7x);
	jpk0_0.add(jpk0_p8);    jpk0_0.add(jpk0_p8x);





	des_view1.setMargin(new Insets(0, 0, 0, 0));
  	des_view1.addActionListener(this);
 	des_view1.setPreferredSize(new Dimension(100, 20));
 	//des_view1.setIcon(imx2); 
	des_view1.setBackground(nm.jblue);
	des_view1.setHorizontalTextPosition(JButton.CENTER);
 	des_view1.setForeground(nm.blackx);
	des_view1.setToolTipText("Create items to export");

	des_view2.setMargin(new Insets(0, 0, 0, 0));
  	des_view2.addActionListener(this);
 	des_view2.setPreferredSize(new Dimension(100, 20));
 	//des_view2.setIcon(imx2); 
	des_view2.setBackground(nm.jblue);
	des_view2.setHorizontalTextPosition(JButton.CENTER);
 	des_view2.setForeground(nm.blackx);
	des_view2.setToolTipText("Create items to export");

	des_build1.setMargin(new Insets(0, 0, 0, 0));
  	des_build1.addActionListener(this);
 	des_build1.setPreferredSize(new Dimension(100, 20));
 	//des_build1.setIcon(imx2); 
	des_build1.setBackground(nm.jblue);
	des_build1.setHorizontalTextPosition(JButton.CENTER);
 	des_build1.setForeground(nm.blackx);
	des_build1.setToolTipText("Insert a Standard Tempalte");

	des_build2.setMargin(new Insets(0, 0, 0, 0));
  	des_build2.addActionListener(this);
 	des_build2.setPreferredSize(new Dimension(100, 20));
 	//des_build2.setIcon(imx2); 
	des_build2.setBackground(nm.jblue);
	des_build2.setHorizontalTextPosition(JButton.CENTER);
 	des_build2.setForeground(nm.blackx);
	des_build2.setToolTipText("Create items to export");

	JPanel jpk1_d_buttons = new JPanel();
	jpk1_d_buttons.setPreferredSize(new Dimension(150, 160));
	jpk1_d_buttons.setBackground(nm.st_gray1);
	jpk1_d_buttons.add(des_view1);
	jpk1_d_buttons.add(des_view2);
	jpk1_d_buttons.add(des_build1);
	jpk1_d_buttons.add(des_build2);

	JScrollPane scrollPaned = new JScrollPane(jtexta_des);
	scrollPaned.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPaned.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPaned.setFont(new Font("Arial", Font.PLAIN, 14));

	TitledBorder titled2 = BorderFactory.createTitledBorder("Template Settings");
	titled2.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_d = new JPanel();
	jpk1_d.setPreferredSize(new Dimension(xzx -25, 190));
	jpk1_d.setBackground(nm.st_gray1);
	jpk1_d.setBorder(titled2);
	jpk1_d.add(scrollPaned);
	jpk1_d.add(jpk1_d_buttons);






	JPanel jpk1_p0 = new JPanel();
	jpk1_p0.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p0.setBackground(nm.st_gray1);
	jpk1_p0.add(info_header2_1); jpk1_p0.add(sales_days_past);
	jpk1_p0.add(info_header2_2); jpk1_p0.add(import_everything);

	JPanel jpk1_p1 = new JPanel();
	jpk1_p1.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p1.setBackground(nm.st_gray1);
 	jpk1_p1.add(over_2_weight_l);        jpk1_p1.add(over_2_weight_tf);
	jpk1_p1.add(weight_switch_to_l);     jpk1_p1.add(weight_switch_to_tf);
	jpk1_p1.add(weight_in_this_field_l); jpk1_p1.add(weight_in_this_field_cb);

	JPanel jpk1_p2 = new JPanel();
	jpk1_p2.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p2.setBackground(nm.st_gray1);
 	jpk1_p2.add(over_2_weight_l2);        jpk1_p2.add(over_2_weight_tf2);
	jpk1_p2.add(weight_switch_to_l2);     jpk1_p2.add(weight_switch_to_tf2);
	jpk1_p2.add(weight_in_this_field_l2); jpk1_p2.add(weight_in_this_field_cb2);

	JPanel jpk1_p3 = new JPanel();
	jpk1_p3.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p3.setBackground(nm.st_gray1);
 	jpk1_p3.add(over_2_units_l);  jpk1_p3.add(over_2_units_tf);
	jpk1_p3.add(switch_to_l);     jpk1_p3.add(switch_to_tf);
	jpk1_p3.add(in_this_field_l); jpk1_p3.add(in_this_field_cb);

	JPanel jpk1_p4 = new JPanel();
	jpk1_p4.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p4.setBackground(nm.st_gray1);
 	jpk1_p4.add(over_2_units_l2);  jpk1_p4.add(over_2_units_tf2);
	jpk1_p4.add(switch_to_l2);     jpk1_p4.add(switch_to_tf2);
	jpk1_p4.add(in_this_field_l2); jpk1_p4.add(in_this_field_cb2);

	JPanel jpk1_p5 = new JPanel();
	jpk1_p5.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p5.setBackground(nm.st_gray1);
	jpk1_p5.add(not_international_l); jpk1_p5.add(not_international_cb);


	TitledBorder titled3 = BorderFactory.createTitledBorder("Import Settings");
	titled3.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_1 = new JPanel();
	jpk1_1.setPreferredSize(new Dimension(xzx -25, 290));
	jpk1_1.setBackground(nm.st_gray1);
	jpk1_1.setBorder(titled3);
	jpk1_1.add(jpk1_p0);
	jpk1_1.add(jpk1_p1);
	jpk1_1.add(jpk1_p2);
	jpk1_1.add(jpk1_p3);
	jpk1_1.add(jpk1_p4);





	JPanel jpk1_x = new JPanel();
	jpk1_x.setLayout(new FlowLayout());
	jpk1_x.setPreferredSize(new Dimension(xzx -25, 40));
	jpk1_x.setBackground(nm.st_gray1);
	jpk1_x.add(save_db);

	JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(xzx -25, 940));
	jpk1.setBackground(nm.st_gray1);
	jpk1.add(jpk0_0);
	jpk1.add(jpk1_d);
	jpk1.add(jpk1_1);




	JScrollPane scrollPane = new JScrollPane(jpk1);
	scrollPane.setPreferredSize(new Dimension(xzx -5, xzy -70));
	//scrollPane.setBackground(bluex2);
	scrollPane.setFont(new Font("Arial", Font.PLAIN, 14));


	JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(xzx, 50));
	jpk2.setBackground(nm.st_gray1);
	jpk2.add(save_db);



	Container cpx = getContentPane();
	cpx.setLayout(flow);
	cpx.setBackground(nm.st_gray1);
	cpx.add(scrollPane);
	cpx.add(jpk2);

	setVisible(true);


	requestFocus();
	loadx_x();

}//csv_loader_x1********************************************************








	public void loadx_x() {


		jtexta_des.setText(nm.carbon[5][template_xx][current_submit_item_here]);

		paypal_email.setText(nm.carbon[5][paypal_email_xx][current_submit_item_here]);
		sales_days_past.setText(nm.carbon[5][sales_days_past_xx][current_submit_item_here]);

		if (nm.carbon[5][import_everything_xx][current_submit_item_here].equals("1")) {

			import_everything.setSelected(true);

		}//****************************************************************************
		else {import_everything.setSelected(false);}

		over_2_units_tf.setText(nm.carbon[5][ship_change_quantity_xx][current_submit_item_here]);
		switch_to_tf.setText(nm.carbon[5][ship_change_type_xx][current_submit_item_here]);
		//paypal_email.setText(nm.carbon[5][nm.ship_change_field_xx][current_submit_item_here]);

		over_2_units_tf2.setText(nm.carbon[5][ship_change_quantity_xx2][current_submit_item_here]);
		switch_to_tf2.setText(nm.carbon[5][ship_change_type_xx2][current_submit_item_here]);
		//paypal_email.setText(nm.carbon[5][nm.ship_change_field_xx][current_submit_item_here]);

		tax_state.setText(nm.carbon[5][tax_state_xx][current_submit_item_here]);
		tax_amount.setText(nm.carbon[5][tax_amount_xx][current_submit_item_here]);

		ship_from_location_tf.setText(nm.carbon[5][ship_from_state_xx][current_submit_item_here]);
		ship_from_zip_tf.setText(nm.carbon[5][shipping_zip_xx][current_submit_item_here]);

		shipping_flat_rate.setText(nm.carbon[5][shipping_flat_rate_xx][current_submit_item_here]);

		over_2_weight_tf.setText(nm.carbon[5][ship_weight_change_quantity_xx][current_submit_item_here]);
		weight_switch_to_tf.setText(nm.carbon[5][ship_weight_change_type_xx][current_submit_item_here]);

		over_2_weight_tf2.setText(nm.carbon[5][ship_weight_change_quantity_xx2][current_submit_item_here]);
		weight_switch_to_tf2.setText(nm.carbon[5][ship_weight_change_type_xx2][current_submit_item_here]);

		feedback_tf.setText(nm.carbon[5][feedback_message_xx][current_submit_item_here]);

		category_tf.setText(nm.carbon[5][ebay_category_xx][current_submit_item_here]);

		ebay_shipping_settings.setText(nm.carbon[5][ebay_shipping_type_xx][current_submit_item_here]);


	}//*******************





	public void savex_x() {


		nm.carbon[5][template_xx][current_submit_item_here] = jtexta_des.getText().replace("\r\n", " ").replace("\n", " ");

		nm.carbon[5][paypal_email_xx][current_submit_item_here] = paypal_email.getText();

		nm.carbon[5][sales_days_past_xx][current_submit_item_here] = sales_days_past.getText();

		String cx0 = nm.carbon[0][nm.item_description_xx][0];
		System.out.println(cx0);

		if (import_everything.isSelected() == true) {

			nm.carbon[5][import_everything_xx][current_submit_item_here] = "1";

		}//******************************************
		else {nm.carbon[5][import_everything_xx][current_submit_item_here] = "0";}

		nm.carbon[5][ship_change_quantity_xx][current_submit_item_here] = over_2_units_tf.getText();
		nm.carbon[5][ship_change_type_xx][current_submit_item_here] = switch_to_tf.getText();

		nm.carbon[5][ship_change_quantity_xx2][current_submit_item_here] = over_2_units_tf2.getText();
		nm.carbon[5][ship_change_type_xx2][current_submit_item_here] = switch_to_tf2.getText();

		nm.carbon[5][tax_state_xx][current_submit_item_here] = tax_state.getText();
		nm.carbon[5][tax_amount_xx][current_submit_item_here] = tax_amount.getText();

		nm.carbon[5][ship_from_state_xx][current_submit_item_here] = ship_from_location_tf.getText();
		nm.carbon[5][shipping_zip_xx][current_submit_item_here] = ship_from_zip_tf.getText();

		nm.carbon[5][shipping_flat_rate_xx][current_submit_item_here] = shipping_flat_rate.getText();

		nm.carbon[5][ship_weight_change_quantity_xx][current_submit_item_here] = over_2_weight_tf.getText();
		nm.carbon[5][ship_weight_change_type_xx][current_submit_item_here] = weight_switch_to_tf.getText();

		nm.carbon[5][ship_weight_change_quantity_xx2][current_submit_item_here] = over_2_weight_tf2.getText();
		nm.carbon[5][ship_weight_change_type_xx2][current_submit_item_here] = weight_switch_to_tf2.getText();

		nm.carbon[5][feedback_message_xx][current_submit_item_here] = feedback_tf.getText();

		//nm.carbon[5][ebay_category_xx][current_submit_item_here] = category_tf.getText();

		nm.carbon[5][ebay_shipping_type_xx][current_submit_item_here] = ebay_shipping_settings.getText();

		String[][] save_item = new String[nm.carbon[5].length][1];

		for (int xloop = 0; xloop < nm.carbon[5].length; xloop++) {//************

			save_item[xloop][0] = nm.carbon[5][xloop][current_submit_item_here];

		}//**********************************************************************
		
		jdb_edit_connection save = new jdb_edit_connection(save_item, Integer.toString(current_submit_item_here));


	}//savex









	public void des_build(){

		String memoryx = new String();
		int bytesRead = 0;

		try {

			InputStream in = nm.class.getResourceAsStream("ext/ebay_template.html");
			byte xdatax[] = new byte[10240];
			while ((bytesRead = in.read(xdatax)) != -1) {memoryx = new String(xdatax);}
			in.close();

		} catch (IOException e) {System.out.println("ext/ebay_template.html"); e.printStackTrace();}

		System.out.println(memoryx);

		if (jtexta_des.getText().length() == 0) {

			jtexta_des.setText(memoryx);

		}//**************************************
		else {JOptionPane.showMessageDialog(null,"Delete old template first.");}

	}//*********************









//handel all the button clicks. 
public void actionPerformed(ActionEvent event){



	if (event.getSource() == des_view1) {}//not used
	if (event.getSource() == des_view2) {}//not used
	if (event.getSource() == des_build1) {des_build();}//not used
	if (event.getSource() == des_build2) {}//not used

	if (event.getSource() == save_db) {savex_x();}//not used

	if (event.getSource() == match_column) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < match_column.getItemCount(); loop1++){//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][match_column_xx][current_submit_item_here] = Integer.toString(loop1); System.out.println(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == shipping_type) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < shipping_type.getItemCount(); loop1++) {//s1x

			if (dd_type_shipping[loop1].equals(newItem)) {

				nm.carbon[5][shipping_type_xx][current_submit_item_here] = Integer.toString(loop1); System.out.println(loop1);

			}//*******************************************

		}//*********************

	}//not used



	if (event.getSource() == shipping_location) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < shipping_location.getItemCount(); loop1++) {//s1x

			if (dd_local_ww[loop1].equals(newItem)) {

				nm.carbon[5][shipping_location_xx][current_submit_item_here] = Integer.toString(loop1); System.out.println(loop1);

			}//**************************************

		}//*********************

	}//not used



	if (event.getSource() == in_this_field_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < in_this_field_cb.getItemCount(); loop1++){//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ship_change_field_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == in_this_field_cb2) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < in_this_field_cb2.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ship_change_field_xx2][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == weight_in_this_field_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < weight_in_this_field_cb.getItemCount(); loop1++){//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ship_weight_change_field_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == weight_in_this_field_cb2) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < weight_in_this_field_cb2.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ship_weight_change_field_xx2][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == not_international_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < not_international_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ship_not_international_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == export_mail_type) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < export_mail_type.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][export_mail_type_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == ebay_site_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < ebay_site_cb.getItemCount(); loop1++){//s1x

			if (dd_us_uk[loop1].equals(newItem)) {

				nm.carbon[5][ebay_site_xx][current_submit_item_here] = Integer.toString(loop1); 
				System.out.println("ebay site cb " + nm.carbon[5][ebay_site_xx][current_submit_item_here]);

			}//*******************************

		}//*********************

	}//not used



	if (event.getSource() == store_category1_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < store_category1_cb.getItemCount(); loop1++) {//s1x
 
			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ebay_store_category1_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == category_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < category_cb.getItemCount(); loop1++){//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ebay_category_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == ebay_duration_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < ebay_duration_cb.getItemCount(); loop1++) {//s1x

			if (dd_listing_duration[loop1].equals(newItem)) {

				nm.carbon[5][ebay_duration_xx][current_submit_item_here] = Integer.toString(loop1);  
				System.out.println("Listing " + nm.carbon[5][ebay_duration_xx][current_submit_item_here]);

			}//**********************************************

		}//*********************

	}//not used



	if (event.getSource() == ebay_upc_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < ebay_upc_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ebay_upc_xx][current_submit_item_here] = Integer.toString(loop1);  
				System.out.println("Listing " + nm.carbon[5][ebay_upc_xx][current_submit_item_here]);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == ebay_listing_id2_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < ebay_listing_id2_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ebay_listing_id2_xx][current_submit_item_here] = Integer.toString(loop1);  
				System.out.println("Listing " + nm.carbon[5][ebay_upc_xx][current_submit_item_here]);

			}//***************************************

		}//*********************

	}//not used




}//actionPerformed









    public static void main(int what_item) {

		ebay_settings xr = new ebay_settings(what_item);

    }//main







}//last****************************************
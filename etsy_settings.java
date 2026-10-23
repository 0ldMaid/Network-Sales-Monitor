import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.awt.datatransfer.*;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;


public class etsy_settings extends JFrame implements ActionListener {//************************************************************************


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 700;
int xzy = 700;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox2 = new JLabel("Import Settings:", JLabel.LEFT);

JLabel header1 = new JLabel("Export Settings", JLabel.LEFT);
JLabel header2 = new JLabel("Import Settings", JLabel.LEFT);
JLabel header3 = new JLabel("Template Settings", JLabel.LEFT);
JLabel header4 = new JLabel("Shipping Settings", JLabel.LEFT);

String listing_state[] = new String[2];

JTextField location_zip = new JTextField("", 12);

JLabel info_header2_1 = new JLabel("Import ?? days past:", JLabel.LEFT);
JLabel info_header2_2 = new JLabel("Import ONLY inventoried items.", JLabel.RIGHT);
JTextField sales_days_past = new JTextField("", 12);

JButton des_view = new JButton("Test");
JButton des_view2 = new JButton("Get Ship ID");
JButton des_build = new JButton("Standard");
JButton des_build2 = new JButton("Standard2");
JButton save_db = new JButton("Save");

JLabel tax_state_l = new JLabel("We charge tax in: ", JLabel.LEFT);
JLabel tax_amount_l = new JLabel("%: ", JLabel.LEFT);
JTextField tax_state = new JTextField("", 4);
JTextField tax_amount = new JTextField("", 4);

JLabel logox = new JLabel("", JLabel.CENTER);
JLabel shipping_cost_l = new JLabel("Shipping cost type: ", JLabel.RIGHT);
JLabel shipping_to_l = new JLabel("Ships to: ", JLabel.RIGHT);
JLabel loop_for_mail_type_l = new JLabel("(MAIL TYPE): ", JLabel.RIGHT);

JLabel account_l = new JLabel("Account ID or Name: ", JLabel.RIGHT);
JLabel shop_l = new JLabel("Shop ID or Name: ", JLabel.RIGHT);
JTextField account = new JTextField("", 12);
JTextField shop = new JTextField("", 12);
JLabel account_l2 = new JLabel(" ", JLabel.CENTER);
JLabel shop_l2 = new JLabel(" ", JLabel.CENTER);

JLabel picture_url_l = new JLabel("Picture URL: ", JLabel.RIGHT);
JTextField picture_url = new JTextField("", 32);
JLabel picture_url_ls = new JLabel("", JLabel.RIGHT);

JLabel etsy_materials_l = new JLabel("Materials: ", JLabel.RIGHT);
JComboBox etsy_materials_cb = new JComboBox();

JLabel etsy_template_l = new JLabel("Shipping template ID: ", JLabel.RIGHT);
JComboBox etsy_template_cb = new JComboBox();

JLabel etsy_state_l = new JLabel("Listing STATE: ", JLabel.RIGHT);
JComboBox etsy_state_cb = new JComboBox();

JLabel etsy_category_l = new JLabel("Category ID: ", JLabel.RIGHT);
JComboBox etsy_category_cb = new JComboBox();

JLabel etsy_processing_min_l = new JLabel("Processing min: ", JLabel.RIGHT);
JComboBox etsy_processing_min_cb = new JComboBox();

JLabel etsy_processing_max_l = new JLabel("Processing max: ", JLabel.RIGHT);
JComboBox etsy_processing_max_cb = new JComboBox();

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

JLabel not_international_l = new JLabel("If the sale is NOT international then use (MAIL TYPE) settings in this field: ", JLabel.LEFT);
JComboBox not_international_cb = new JComboBox();




//settings for etsy

static int etsy_url_x = 1;
static int etsy_account_id = 6;
static int etsy_shop_id = 7;

static int etsy_token_xx = 16;
static int etsy_secret_xx = 17;
static int etsy_raw_xx = 18;
static int etsy_tax_state_xx = 19;
static int etsy_tax_amount_xx = 20;
static int etsy_ship_not_international_xx = 21;
static int etsy_ship_from_state_xx = 22;
static int etsy_materials_xx = 23;
static int etsy_template_xx = 24;
static int etsy_section_id_xx = 25;
static int etsy_image_ids_xx = 26;
static int etsy_customizable_xx = 27;
static int etsy_taxable_xx = 28;
static int etsy_image_xx = 29;
static int etsy_state_xx = 30;
static int etsy_processing_min_xx = 31;
static int etsy_processing_max_xx = 32;
static int etsy_category_id_xx = 33;
static int etsy_tags_xx = 34;
static int etsy_who_made_xx = 35;
static int etsy_is_supply_xx = 36;
static int etsy_when_made_xx = 37;
static int etsy_recipient_xx = 38;
static int etsy_occasion_xx = 39;
static int etsy_style_xx = 40;

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
//99 = id






etsy_settings(int what_item) {//*******************************************************************************************************

	super("Etsy Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex_x(); nm.account_settings_open = false;}});



	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);



	infoxs.setPreferredSize(new Dimension(xzx -40, 20));
	infoxs.setBackground(nm.blackx);
	infoxs.setForeground(nm.whitex);

	infox0.setPreferredSize(new Dimension(xzx -30, 20));
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.blackx);

	infox1.setPreferredSize(new Dimension(xzx -30, 20));
	infox1.setBackground(nm.blackx);
	infox1.setForeground(nm.blackx);

	infox2.setPreferredSize(new Dimension(xzx -30, 20));
	infox2.setBackground(nm.blackx);
	infox2.setForeground(nm.blackx);


	FlowLayout flow = new FlowLayout(0);
	flow.setHgap(0);
	flow.setVgap(0);


	weight_switch_to_l.setPreferredSize(new Dimension(123, 20));
	weight_switch_to_l2.setPreferredSize(new Dimension(123, 20));

	switch_to_l.setPreferredSize(new Dimension(123, 20));
	switch_to_l2.setPreferredSize(new Dimension(123, 20));

	over_2_units_l.setPreferredSize(new Dimension(97, 20));
	over_2_units_l2.setPreferredSize(new Dimension(97, 20));

	over_2_weight_l.setPreferredSize(new Dimension(97, 20));
	over_2_weight_l2.setPreferredSize(new Dimension(97, 20));


	save_db.setMargin(new Insets(0, 0, 0, 0));
  	save_db.addActionListener(this);
 	save_db.setPreferredSize(new Dimension(120, 30));
	save_db.setBackground(nm.st_gray1);
	save_db.setHorizontalTextPosition(JButton.CENTER);
 	save_db.setForeground(nm.blackx);
	save_db.setToolTipText("Save database");

	header1.setPreferredSize(new Dimension(660, 20));
	header2.setPreferredSize(new Dimension(660, 20));
	header3.setPreferredSize(new Dimension(660, 20));
	header4.setPreferredSize(new Dimension(660, 20));

	info_header2_1.setPreferredSize(new Dimension(130, 20));
	info_header2_1.setToolTipText("Integer less then 30. OR YYYY-MM: 2012-03");

	info_header2_2.setPreferredSize(new Dimension(330, 20));

	etsy_materials_l.setPreferredSize(new Dimension(130, 20));
	etsy_template_l.setPreferredSize(new Dimension(130, 20));
	etsy_state_l.setPreferredSize(new Dimension(130, 20));
	etsy_category_l.setPreferredSize(new Dimension(130, 20));

	etsy_processing_min_l.setPreferredSize(new Dimension(130, 20));
	etsy_processing_max_l.setPreferredSize(new Dimension(130, 20));




	in_this_field_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_change_field_xx][nm.current_submit_item_a]);
		int ix1 = Integer.parseInt(nm.carbon[5][ship_change_field_xx][nm.current_submit_item_a]);

		in_this_field_cb.setSelectedIndex(ix1);

	} catch (Exception e) {}
	in_this_field_cb.addActionListener(this);
	in_this_field_cb.setPreferredSize(new Dimension(150, 20));
	in_this_field_cb.setToolTipText("Set Match Type");



	in_this_field_cb2 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_change_field_xx2][nm.current_submit_item_a]);
		int ix1 = Integer.parseInt(nm.carbon[5][ship_change_field_xx2][nm.current_submit_item_a]);

		in_this_field_cb2.setSelectedIndex(ix1);

	} catch (Exception e) {}
	in_this_field_cb2.addActionListener(this);
	in_this_field_cb2.setPreferredSize(new Dimension(150, 20));
	in_this_field_cb2.setToolTipText("Set Match Type");



	weight_in_this_field_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_weight_change_field_xx][nm.current_submit_item_a]);
		int ix1 = Integer.parseInt(nm.carbon[5][ship_weight_change_field_xx][nm.current_submit_item_a]);

		weight_in_this_field_cb.setSelectedIndex(ix1);

	} catch (Exception e) {}
	weight_in_this_field_cb.addActionListener(this);
	weight_in_this_field_cb.setPreferredSize(new Dimension(150, 20));
	weight_in_this_field_cb.setToolTipText("Set Match Type");



	weight_in_this_field_cb2 = new JComboBox(nm.db_string);
	try { 

		System.out.println(nm.carbon[5][ship_weight_change_field_xx2][nm.current_submit_item_a]);
		int ix1 = Integer.parseInt(nm.carbon[5][ship_weight_change_field_xx2][nm.current_submit_item_a]);

		weight_in_this_field_cb2.setSelectedIndex(ix1);

	} catch (Exception e) {}
	weight_in_this_field_cb2.addActionListener(this);
	weight_in_this_field_cb2.setPreferredSize(new Dimension(150, 20));
	weight_in_this_field_cb2.setToolTipText("Set Match Type");



	etsy_materials_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][etsy_materials_xx][nm.current_submit_item_a]);
		int ix1 = Integer.parseInt(nm.carbon[5][etsy_materials_xx][nm.current_submit_item_a]);

		etsy_materials_cb.setSelectedIndex(ix1);

	} catch (Exception e) {nm.carbon[5][etsy_materials_xx][nm.current_submit_item_a] = "0";}
	etsy_materials_cb.addActionListener(this);
	etsy_materials_cb.setPreferredSize(new Dimension(148, 20));
	etsy_materials_cb.setToolTipText("Materials used");



	etsy_template_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][etsy_template_xx][nm.current_submit_item_a]);
		int ix1 = Integer.parseInt(nm.carbon[5][etsy_template_xx][nm.current_submit_item_a]);

		etsy_template_cb.setSelectedIndex(ix1);

	} catch (Exception e) {}
	etsy_template_cb.addActionListener(this);
	etsy_template_cb.setPreferredSize(new Dimension(148, 20));
	etsy_template_cb.setToolTipText("The shipping template integer");



	listing_state[0] = new String("draft");
	listing_state[1] = new String("active");

	etsy_state_cb = new JComboBox(listing_state);
	try {

		System.out.println(nm.carbon[5][etsy_state_xx][nm.current_submit_item_a]);
		int ix0 = Integer.parseInt(nm.carbon[5][etsy_state_xx][nm.current_submit_item_a]);

		if(ix0 > 1 || ix0 < 0){ix0 = 0;}

		etsy_state_cb.setSelectedIndex(ix0);

	} catch (Exception e) {}
	etsy_state_cb.addActionListener(this);
	etsy_state_cb.setPreferredSize(new Dimension(150, 20));
	etsy_state_cb.setToolTipText("Set STATE Draft or Active");



	etsy_category_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][etsy_category_id_xx][nm.current_submit_item_a]);
		int ix0 = Integer.parseInt(nm.carbon[5][etsy_category_id_xx][nm.current_submit_item_a]);

		etsy_category_cb.setSelectedIndex(ix0);

	} catch (Exception e) {}
	etsy_category_cb.addActionListener(this);
	etsy_category_cb.setPreferredSize(new Dimension(150, 20));
	etsy_category_cb.setToolTipText("Set category ID location");



	etsy_processing_min_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][etsy_processing_min_xx][nm.current_submit_item_a]);
		int ix0 = Integer.parseInt(nm.carbon[5][etsy_processing_min_xx][nm.current_submit_item_a]);

		etsy_processing_min_cb.setSelectedIndex(ix0);

	} catch (Exception e) {}
	etsy_processing_min_cb.addActionListener(this);
	etsy_processing_min_cb.setPreferredSize(new Dimension(150, 20));
	etsy_processing_min_cb.setToolTipText("Set processing time min");



	etsy_processing_max_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][etsy_processing_max_xx][nm.current_submit_item_a]);
		int ix0 = Integer.parseInt(nm.carbon[5][etsy_processing_max_xx][nm.current_submit_item_a]);

		etsy_processing_max_cb.setSelectedIndex(ix0);

	} catch (Exception e) {}
	etsy_processing_max_cb.addActionListener(this);
	etsy_processing_max_cb.setPreferredSize(new Dimension(150, 20));
	etsy_processing_max_cb.setToolTipText("Set processing time max");



	//des_view.setMargin(new Insets(0, 0, 0, 0));
  	des_view.addActionListener(this);
 	des_view.setPreferredSize(new Dimension(80, 20));
	des_view.setBackground(nm.st_gray1);
 	des_view.setForeground(nm.blackx);
	des_view.setToolTipText("Test");


	//des_view.setMargin(new Insets(0, 0, 0, 0));
  	des_view2.addActionListener(this);
 	des_view2.setPreferredSize(new Dimension(120, 20));
	des_view2.setBackground(nm.st_gray1);
 	des_view2.setForeground(nm.blackx);
	des_view2.setToolTipText("Test");



	account_l.setPreferredSize(new Dimension(120, 20));
	account_l2.setPreferredSize(new Dimension(120, 20));

	shop_l.setPreferredSize(new Dimension(190, 20));
	shop_l2.setPreferredSize(new Dimension(150, 20));

	picture_url_l.setPreferredSize(new Dimension(80, 20));
	picture_url_ls.setPreferredSize(new Dimension(38, 20));



	JPanel jpk0_p0 = new JPanel();
	jpk0_p0.setPreferredSize(new Dimension(xzx -50, 80));
	jpk0_p0.setBackground(nm.st_gray1);
	jpk0_p0.add(account_l);               jpk0_p0.add(account);   jpk0_p0.add(des_view);     jpk0_p0.add(account_l2);
	jpk0_p0.add(shop_l);                  jpk0_p0.add(shop);      jpk0_p0.add(des_view2);    jpk0_p0.add(shop_l2);

	JPanel jpk0_url = new JPanel();
	jpk0_url.setPreferredSize(new Dimension(650, 40));
	jpk0_url.setBackground(nm.st_gray1);
	jpk0_url.add(picture_url_l);    	  jpk0_url.add(picture_url);    	  jpk0_url.add(picture_url_ls);


	JPanel jpk0_p1 = new JPanel();
	jpk0_p1.setPreferredSize(new Dimension(350, 40));
	jpk0_p1.setBackground(nm.st_gray1);
	jpk0_p1.add(etsy_template_l);    	  jpk0_p1.add(etsy_template_cb);

	JPanel jpk0_p1x = new JPanel();
	jpk0_p1x.setPreferredSize(new Dimension(295, 40));
	jpk0_p1x.setBackground(nm.st_gray1);
	jpk0_p1x.add(etsy_state_l);           jpk0_p1x.add(etsy_state_cb);


	JPanel jpk0_p2 = new JPanel();
	jpk0_p2.setPreferredSize(new Dimension(350, 40));
	jpk0_p2.setBackground(nm.st_gray1);
	jpk0_p2.add(etsy_category_l);         jpk0_p2.add(etsy_category_cb);

	JPanel jpk0_p2x = new JPanel();
	jpk0_p2x.setPreferredSize(new Dimension(295, 40));
	jpk0_p2x.setBackground(nm.st_gray1);
	jpk0_p2x.add(etsy_materials_l);       jpk0_p2x.add(etsy_materials_cb);


	JPanel jpk0_p3 = new JPanel();
	jpk0_p3.setPreferredSize(new Dimension(350, 40));
	jpk0_p3.setBackground(nm.st_gray1);

	JPanel jpk0_p3x = new JPanel();
	jpk0_p3x.setPreferredSize(new Dimension(295, 40));
	jpk0_p3x.setBackground(nm.st_gray1);
	jpk0_p3x.add(etsy_processing_min_l);  jpk0_p3x.add(etsy_processing_min_cb);


	JPanel jpk0_p4 = new JPanel();
	jpk0_p4.setPreferredSize(new Dimension(350, 40));
	jpk0_p4.setBackground(nm.st_gray1);

	JPanel jpk0_p4x = new JPanel();
	jpk0_p4x.setPreferredSize(new Dimension(295, 40));
	jpk0_p4x.setBackground(nm.st_gray1);
	jpk0_p4x.add(etsy_processing_max_l);  jpk0_p4x.add(etsy_processing_max_cb);


	JPanel jpk0_p5 = new JPanel();
	jpk0_p5.setPreferredSize(new Dimension(350, 40));
	jpk0_p5.setBackground(nm.st_gray1);

	JPanel jpk0_p5x = new JPanel();
	jpk0_p5x.setPreferredSize(new Dimension(295, 40));
	jpk0_p5x.setBackground(nm.st_gray1);




	TitledBorder titled1 = BorderFactory.createTitledBorder("Import Settings");
	titled1.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk0_0 = new JPanel();
	jpk0_0.setPreferredSize(new Dimension(xzx -25, 425));
	jpk0_0.setBackground(nm.st_gray1);
	jpk0_0.setBorder(titled1);
	jpk0_0.add(jpk0_url);	
	jpk0_0.add(jpk0_p1);                  jpk0_0.add(jpk0_p1x);
	jpk0_0.add(jpk0_p2);                  jpk0_0.add(jpk0_p2x);
	jpk0_0.add(jpk0_p3);                  jpk0_0.add(jpk0_p3x);
	jpk0_0.add(jpk0_p4);                  jpk0_0.add(jpk0_p4x);
	jpk0_0.add(jpk0_p5);                  jpk0_0.add(jpk0_p5x);



	//standard import

	JPanel jpk1_p0 = new JPanel();
	jpk1_p0.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p0.setBackground(nm.st_gray1);
	jpk1_p0.add(info_header2_1);          jpk1_p0.add(sales_days_past);
	jpk1_p0.add(info_header2_2);          jpk1_p0.add(import_everything);


	JPanel jpk1_p1 = new JPanel();
	jpk1_p1.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p1.setBackground(nm.st_gray1);
 	jpk1_p1.add(over_2_weight_l);         jpk1_p1.add(over_2_weight_tf);
	jpk1_p1.add(weight_switch_to_l);      jpk1_p1.add(weight_switch_to_tf);
	jpk1_p1.add(weight_in_this_field_l);  jpk1_p1.add(weight_in_this_field_cb);


	JPanel jpk1_p2 = new JPanel();
	jpk1_p2.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p2.setBackground(nm.st_gray1);
 	jpk1_p2.add(over_2_weight_l2);        jpk1_p2.add(over_2_weight_tf2);
	jpk1_p2.add(weight_switch_to_l2);     jpk1_p2.add(weight_switch_to_tf2);
	jpk1_p2.add(weight_in_this_field_l2); jpk1_p2.add(weight_in_this_field_cb2);


	JPanel jpk1_p3 = new JPanel();
	jpk1_p3.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p3.setBackground(nm.st_gray1);
 	jpk1_p3.add(over_2_units_l);          jpk1_p3.add(over_2_units_tf);
	jpk1_p3.add(switch_to_l);             jpk1_p3.add(switch_to_tf);
	jpk1_p3.add(in_this_field_l);         jpk1_p3.add(in_this_field_cb);


	JPanel jpk1_p4 = new JPanel();
	jpk1_p4.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p4.setBackground(nm.st_gray1);
 	jpk1_p4.add(over_2_units_l2);         jpk1_p4.add(over_2_units_tf2);
	jpk1_p4.add(switch_to_l2);            jpk1_p4.add(switch_to_tf2);
	jpk1_p4.add(in_this_field_l2);        jpk1_p4.add(in_this_field_cb2);


	JPanel jpk1_p5 = new JPanel();
	jpk1_p5.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p5.setBackground(nm.st_gray1);
	jpk1_p5.add(not_international_l);     jpk1_p5.add(not_international_cb);





	TitledBorder titled2 = BorderFactory.createTitledBorder("Export Settings");
	titled2.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_1 = new JPanel();
	jpk1_1.setPreferredSize(new Dimension(xzx -25, 290));
	jpk1_1.setBackground(nm.st_gray1);
	jpk1_1.setBorder(titled2);
	jpk1_1.add(jpk1_p0);
	jpk1_1.add(jpk1_p1);
	jpk1_1.add(jpk1_p2);
	jpk1_1.add(jpk1_p3);
	jpk1_1.add(jpk1_p4);


	JPanel jpk1_c = new JPanel();
	jpk1_c.setPreferredSize(new Dimension(xzx -25, 290));
	jpk1_c.setBackground(nm.st_gray1);


	JPanel jpk1_d_buttons = new JPanel();
	jpk1_d_buttons.setPreferredSize(new Dimension(150, 164));
	jpk1_d_buttons.setBackground(nm.st_gray1);


	JPanel jpk1_d = new JPanel();
	jpk1_d.setPreferredSize(new Dimension(xzx -25, 230));
	jpk1_d.setBackground(nm.st_gray1);


	JPanel jpk1_x = new JPanel();
	jpk1_x.setLayout(new FlowLayout());
	jpk1_x.setPreferredSize(new Dimension(xzx -25, 40));
	jpk1_x.setBackground(nm.st_gray1);
	jpk1_x.add(save_db);


	JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(xzx -25, 730));
	jpk1.setBackground(nm.st_gray1);
	jpk1.add(jpk0_0);
	jpk1.add(jpk1_1);


	JScrollPane scrollPane = new JScrollPane(jpk1);
	scrollPane.setPreferredSize(new Dimension(xzx -5, xzy -70));
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


		account.setText(nm.carbon[5][etsy_account_id][nm.current_submit_item_a]);
		shop.setText(nm.carbon[5][etsy_shop_id][nm.current_submit_item_a]);

		picture_url.setText(nm.carbon[5][etsy_url_x][nm.current_submit_item_a]);

		sales_days_past.setText(nm.carbon[5][sales_days_past_xx][nm.current_submit_item_a]);

		if (nm.carbon[5][import_everything_xx][nm.current_submit_item_a].equals("1")) {import_everything.setSelected(true);}
		else {import_everything.setSelected(false);}

		over_2_units_tf.setText(nm.carbon[5][ship_change_quantity_xx][nm.current_submit_item_a]);
		switch_to_tf.setText(nm.carbon[5][ship_change_type_xx][nm.current_submit_item_a]);

		over_2_units_tf2.setText(nm.carbon[5][ship_change_quantity_xx2][nm.current_submit_item_a]);
		switch_to_tf2.setText(nm.carbon[5][ship_change_type_xx2][nm.current_submit_item_a]);

		over_2_weight_tf.setText(nm.carbon[5][ship_weight_change_quantity_xx][nm.current_submit_item_a]);
		weight_switch_to_tf.setText(nm.carbon[5][ship_weight_change_type_xx][nm.current_submit_item_a]);

		over_2_weight_tf2.setText(nm.carbon[5][ship_weight_change_quantity_xx2][nm.current_submit_item_a]);
		weight_switch_to_tf2.setText(nm.carbon[5][ship_weight_change_type_xx2][nm.current_submit_item_a]);


	}//*******************





	public void savex_x() {


		nm.carbon[5][etsy_account_id][nm.current_submit_item_a] = account.getText();
		nm.carbon[5][etsy_shop_id][nm.current_submit_item_a] = shop.getText();

		nm.carbon[5][etsy_url_x][nm.current_submit_item_a] = picture_url.getText();

		nm.carbon[5][sales_days_past_xx][nm.current_submit_item_a] = sales_days_past.getText();

		if (import_everything.isSelected() == true) {nm.carbon[5][import_everything_xx][nm.current_submit_item_a] = "1";}
		else {nm.carbon[5][import_everything_xx][nm.current_submit_item_a] = "0";}

		nm.carbon[5][ship_change_quantity_xx][nm.current_submit_item_a] = over_2_units_tf.getText();
		nm.carbon[5][ship_change_type_xx][nm.current_submit_item_a] = switch_to_tf.getText();

		nm.carbon[5][ship_change_quantity_xx2][nm.current_submit_item_a] = over_2_units_tf2.getText();
		nm.carbon[5][ship_change_type_xx2][nm.current_submit_item_a] = switch_to_tf2.getText();

		nm.carbon[5][ship_weight_change_quantity_xx][nm.current_submit_item_a] = over_2_weight_tf.getText();
		nm.carbon[5][ship_weight_change_type_xx][nm.current_submit_item_a] = weight_switch_to_tf.getText();

		nm.carbon[5][ship_weight_change_quantity_xx2][nm.current_submit_item_a] = over_2_weight_tf2.getText();
		nm.carbon[5][ship_weight_change_type_xx2][nm.current_submit_item_a] = weight_switch_to_tf2.getText();


		String[][] save_item = new String[nm.carbon[5].length][1];

		for(int xloop = 0; xloop < nm.carbon[5].length; xloop++){//**************

			save_item[xloop][0] = nm.carbon[5][xloop][nm.current_submit_item_a];

		}//**********************************************************************

		jdb_edit_connection save = new jdb_edit_connection(save_item, Integer.toString(nm.current_submit_item_a));


	}//savex








	public void get_user_info() {

		etsy_user_info geti = new etsy_user_info();

		String temp = geti.get_user_info();

		System.out.println(temp);

		if(temp.equals("1")){account_l2.setText("Account is active.");}
		else{account_l2.setText("Error!");}

	}//*************************


	public void get_shipping_templates() {

		etsy_shipping_templates gett = new etsy_shipping_templates();

		String temp = gett.get_templates();

		System.out.println(temp);

		shop_l2.setText(temp);


		StringSelection selection = new StringSelection(temp);
    	Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    	clipboard.setContents(selection, selection);

		JOptionPane.showMessageDialog(null, "Shipping ID saved to clipboard");

	}//*************************







//handel all the button clicks. 
public void actionPerformed(ActionEvent event) {



	if (event.getSource() == des_view) {get_user_info();}//not used
	if (event.getSource() == des_view2) {get_shipping_templates();}//not used
	if (event.getSource() == des_build) {}//not used
	if (event.getSource() == des_build2) {}//not used

	if (event.getSource() == save_db) {savex_x();}//not used



	if (event.getSource() == etsy_materials_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < etsy_materials_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][etsy_materials_xx][nm.current_submit_item_a] = Integer.toString(loop1); System.out.println(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == etsy_template_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < etsy_template_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][etsy_template_xx][nm.current_submit_item_a] = Integer.toString(loop1); System.out.println(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == etsy_state_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < etsy_state_cb.getItemCount(); loop1++) {//s1x

			if (listing_state[loop1].equals(newItem)) {

				nm.carbon[5][etsy_state_xx][nm.current_submit_item_a] = Integer.toString(loop1); System.out.println(loop1);

			}//****************************************

		}//*********************

	}//not used



	if (event.getSource() == etsy_category_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < etsy_category_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][etsy_category_id_xx][nm.current_submit_item_a] = Integer.toString(loop1); System.out.println(loop1);

			}//***************************************

		}//*********************

	}//not used



	if(event.getSource() == etsy_processing_min_cb){

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < etsy_processing_min_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][etsy_processing_min_xx][nm.current_submit_item_a] = Integer.toString(loop1); System.out.println(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == etsy_processing_max_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < etsy_processing_max_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][etsy_processing_max_xx][nm.current_submit_item_a] = Integer.toString(loop1); System.out.println(loop1);

			}//***************************************

		}//*********************

	}//not used



	//standard import settings

	if (event.getSource() == in_this_field_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < in_this_field_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ship_change_field_xx][nm.current_submit_item_a] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == in_this_field_cb2) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < in_this_field_cb2.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ship_change_field_xx2][nm.current_submit_item_a] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == weight_in_this_field_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < weight_in_this_field_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ship_weight_change_field_xx][nm.current_submit_item_a] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == weight_in_this_field_cb2) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < weight_in_this_field_cb2.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ship_weight_change_field_xx2][nm.current_submit_item_a] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used





}//actionPerformed







    public static void main(int what_item) {

		etsy_settings xr = new etsy_settings(what_item);

    }//main










}//last****************************************
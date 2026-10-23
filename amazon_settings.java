import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;




public class amazon_settings extends JFrame implements ActionListener{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 700;
int xzy = 700;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int current_submit_item_here = -1;

static String[] amazon_match_type = new String[3];

JButton save_db = new JButton("Save");

JTextArea jtexta = new JTextArea();

JLabel header1_l = new JLabel("Amazon API information", JLabel.LEFT);
JLabel header2_l = new JLabel("Export Settings", JLabel.LEFT);
JLabel header3_l = new JLabel("Import Settings", JLabel.LEFT);
JLabel header4_l = new JLabel("Shipping Settings", JLabel.LEFT);

JLabel labelMerchantID = new JLabel("MerchantID", JLabel.LEFT);
JLabel labelMarketplaceID = new JLabel("MarketplaceID", JLabel.LEFT);
JLabel labelAWSAccessKeyID = new JLabel("AWSAccessKeyID", JLabel.LEFT);
JLabel labelSecretKey = new JLabel("SecretKey", JLabel.LEFT);

JTextField tfMerchantID = new JTextField("", 18);
JTextField tfMarketplaceID = new JTextField("", 18);
JTextField tfAWSAccessKeyID = new JTextField("", 18);
JTextField tfSecretKey = new JTextField("", 18);

JLabel match_type_l = new JLabel("Match Amazon ", JLabel.LEFT);
JLabel match_column_l = new JLabel(" to my product ID in ", JLabel.LEFT);

JComboBox match_type = new JComboBox();
JComboBox match_column = new JComboBox();

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

JLabel not_international_l = new JLabel("If the sale is NOT international then use (MAIL TYPE) settings in this field: ", JLabel.RIGHT);
JComboBox not_international_cb = new JComboBox();

JLabel info_header2_1 = new JLabel("Import ?? days past.", JLabel.LEFT);
JLabel info_header2_2 = new JLabel("Import ONLY inventoried items.", JLabel.RIGHT);
JTextField sales_days_past = new JTextField("", 12);
JCheckBox import_everything = new JCheckBox();

JLabel amazon_id_export_l = new JLabel("Save the Amazon Listing ID to: ", JLabel.RIGHT);
JComboBox amazon_id_export = new JComboBox();



//settings for amazon
//0 - 15 defined in nm
static int awsAccessKeyID_xx = 2;
static int secretKey_xx = 3; 
static int merchantID_xx = 6;
static int marketplaceID_xx = 7;

static int match_type_xx = 16;
static int match_column_xx = 17;
static int amazon_site_xx = 18;
static int amazon_id_export_xx = 19;
static int amazon_ship_not_international_xx = 20;

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





amazon_settings(int what_item) {//****************************

	super("Amazon Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex_x(); nm.account_settings_open = false;}});

    //we save the edit item so that if the user clicks on a new item and then saves we don't get errors. 
    current_submit_item_here = what_item;


	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	amazon_match_type[0] = new String("ASIN");
	amazon_match_type[1] = new String("UPC");
	amazon_match_type[2] = new String("EAN");

	//match_type_l.setPreferredSize(new Dimension(190, 20));

	info_header2_1.setPreferredSize(new Dimension(130, 20));
	info_header2_2.setPreferredSize(new Dimension(330, 20));

	not_international_l.setPreferredSize(new Dimension(478, 20));

	jtexta = new JTextArea("", 10, 40);
	jtexta.setWrapStyleWord(true);
	jtexta.setLineWrap(true);
	jtexta.setWrapStyleWord(true);

	JScrollPane scrollPaned = new JScrollPane(jtexta);
	scrollPaned.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPaned.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPaned.setFont(new Font("Arial", Font.PLAIN, 14));

	FlowLayout flow = new FlowLayout(0);
	flow.setHgap(0);
	flow.setVgap(0);


	tfMerchantID.setEnabled(false);
	tfMarketplaceID.setEnabled(false);
	tfAWSAccessKeyID.setEnabled(false);
	tfSecretKey.setEnabled(false);


	match_type = new JComboBox(amazon_match_type);
	//match_type.setSelectedIndex(ix0);
	match_type.addActionListener(this);
	match_type.setPreferredSize(new Dimension(150, 20));
	match_type.setToolTipText("Set Match Type.");


	match_column = new JComboBox(nm.db_string);
	//match_column.setSelectedIndex(ix1);
	match_column.addActionListener(this);
	match_column.setPreferredSize(new Dimension(150, 20));
	match_column.setToolTipText("Set Match Info Location.");


	labelMerchantID.setPreferredSize(new Dimension(250, 20));
	labelMarketplaceID.setPreferredSize(new Dimension(250, 20));
	labelAWSAccessKeyID.setPreferredSize(new Dimension(250, 20));
	labelSecretKey.setPreferredSize(new Dimension(250, 20));


	header1_l.setPreferredSize(new Dimension(650, 20));
	header2_l.setPreferredSize(new Dimension(650, 20));
	header3_l.setPreferredSize(new Dimension(650, 20));
	header4_l.setPreferredSize(new Dimension(650, 20));


	save_db.setMargin(new Insets(0, 0, 0, 0));
  	save_db.addActionListener(this);
 	save_db.setPreferredSize(new Dimension(120, 30));
	save_db.setBackground(nm.st_gray1);
	save_db.setHorizontalTextPosition(JButton.CENTER);
 	save_db.setForeground(nm.blackx);
	save_db.setToolTipText("Save database");




	amazon_id_export = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][amazon_id_export_xx][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][amazon_id_export_xx][current_submit_item_here]);

		amazon_id_export.setSelectedIndex(ix1);

	} catch (Exception e) {}
	amazon_id_export.addActionListener(this);
	amazon_id_export.setPreferredSize(new Dimension(150, 20));
	amazon_id_export.setToolTipText("Set Match Type.");

	amazon_id_export_l.setPreferredSize(new Dimension(359, 20));




	TitledBorder titled1 = BorderFactory.createTitledBorder("Export Settings");
	titled1.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_0 = new JPanel();
	jpk1_0.setPreferredSize(new Dimension(xzx -25, 335));
	jpk1_0.setBackground(nm.st_gray1); 
	jpk1_0.setBorder(titled1);
	jpk1_0.add(match_type_l);            jpk1_0.add(match_type);         jpk1_0.add(match_column_l);     jpk1_0.add(match_column);
	jpk1_0.add(amazon_id_export_l);      jpk1_0.add(amazon_id_export);


	JPanel jpk1_1 = new JPanel();
	jpk1_1.setPreferredSize(new Dimension(xzx -25, 200));
	jpk1_1.setBackground(nm.st_gray1);






	in_this_field_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_change_field_xx][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][ship_change_field_xx][current_submit_item_here]);

		in_this_field_cb.setSelectedIndex(ix1);

	} catch (Exception e) {}
	in_this_field_cb.addActionListener(this);
	in_this_field_cb.setPreferredSize(new Dimension(150, 20));
	in_this_field_cb.setToolTipText("Set Match Type.");



	in_this_field_cb2 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_change_field_xx2][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][ship_change_field_xx2][current_submit_item_here]);

		in_this_field_cb2.setSelectedIndex(ix1);

	} catch (Exception e) {}
	in_this_field_cb2.addActionListener(this);
	in_this_field_cb2.setPreferredSize(new Dimension(150, 20));
	in_this_field_cb2.setToolTipText("Set Match Type.");



	not_international_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][amazon_ship_not_international_xx][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][amazon_ship_not_international_xx][current_submit_item_here]);

		not_international_cb.setSelectedIndex(ix1);

	} catch (Exception e) {}
	not_international_cb.addActionListener(this);
	not_international_cb.setPreferredSize(new Dimension(150, 20));
	not_international_cb.setToolTipText("Set Match Type.");



	weight_in_this_field_cb = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_weight_change_field_xx][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][ship_weight_change_field_xx][current_submit_item_here]);

		weight_in_this_field_cb.setSelectedIndex(ix1);

	} catch (Exception e) {}	
	weight_in_this_field_cb.addActionListener(this);
	weight_in_this_field_cb.setPreferredSize(new Dimension(150, 20));
	weight_in_this_field_cb.setToolTipText("Set Match Type.");



	weight_in_this_field_cb2 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][ship_weight_change_field_xx2][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][ship_weight_change_field_xx2][current_submit_item_here]);

		weight_in_this_field_cb2.setSelectedIndex(ix1);

	} catch (Exception e) {}
	weight_in_this_field_cb2.addActionListener(this);
	weight_in_this_field_cb2.setPreferredSize(new Dimension(150, 20));
	weight_in_this_field_cb2.setToolTipText("Set Match Type.");




	weight_switch_to_l.setPreferredSize(new Dimension(123, 20));
	weight_switch_to_l2.setPreferredSize(new Dimension(123, 20));

	switch_to_l.setPreferredSize(new Dimension(123, 20));
	switch_to_l2.setPreferredSize(new Dimension(123, 20));

	over_2_units_l.setPreferredSize(new Dimension(97, 20));
	over_2_units_l2.setPreferredSize(new Dimension(97, 20));

	over_2_weight_l.setPreferredSize(new Dimension(97, 20));
	over_2_weight_l2.setPreferredSize(new Dimension(97, 20));




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
 	jpk1_p4.add(over_2_units_l2);      jpk1_p4.add(over_2_units_tf2);
	jpk1_p4.add(switch_to_l2);         jpk1_p4.add(switch_to_tf2);
	jpk1_p4.add(in_this_field_l2);     jpk1_p4.add(in_this_field_cb2);

	JPanel jpk1_p5 = new JPanel();
	jpk1_p5.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p5.setBackground(nm.st_gray1);
	jpk1_p5.add(not_international_l);  jpk1_p5.add(not_international_cb);



	TitledBorder titled2 = BorderFactory.createTitledBorder("Import Settings");
	titled2.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_d = new JPanel();
	jpk1_d.setPreferredSize(new Dimension(xzx -25, 310));
	jpk1_d.setBackground(nm.st_gray1);
	jpk1_d.setBorder(titled2);
	jpk1_d.add(jpk1_p0);
	jpk1_d.add(jpk1_p1);
	jpk1_d.add(jpk1_p2);
	jpk1_d.add(jpk1_p3);
	jpk1_d.add(jpk1_p4);
	jpk1_d.add(jpk1_p5);


	JPanel jpk1_c = new JPanel();
	jpk1_c.setPreferredSize(new Dimension(xzx -25, 600));
	jpk1_c.setBackground(nm.st_gray1);


	JPanel jpk1_x = new JPanel();
	jpk1_x.setLayout(new FlowLayout());
	jpk1_x.setPreferredSize(new Dimension(xzx -25, 40));
	jpk1_x.setBackground(nm.st_gray1);
	jpk1_x.add(save_db);


	JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(xzx -25, 660));
	jpk1.setBackground(nm.st_gray1);
	jpk1.add(jpk1_0);
	jpk1.add(jpk1_d);




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


	loadx_x();

	requestFocus();



}//csv_loader_x1********************************************************







	public void loadx_x() {



		tfAWSAccessKeyID.setText(nm.carbon[5][2][nm.amazon_settings_item]);
		tfSecretKey.setText(nm.carbon[5][3][nm.amazon_settings_item]);
		tfMerchantID.setText(nm.carbon[5][6][nm.amazon_settings_item]);
		tfMarketplaceID.setText(nm.carbon[5][7][nm.amazon_settings_item]);


		over_2_units_tf.setText(nm.carbon[5][ship_change_quantity_xx][current_submit_item_here]);
		switch_to_tf.setText(nm.carbon[5][ship_change_type_xx][current_submit_item_here]);
		//paypal_email.setText(nm.carbon[5][nm.ship_change_field_xx][current_submit_item_here]);

		over_2_units_tf2.setText(nm.carbon[5][ship_change_quantity_xx2][current_submit_item_here]);
		switch_to_tf2.setText(nm.carbon[5][ship_change_type_xx2][current_submit_item_here]);
		//paypal_email.setText(nm.carbon[5][nm.ship_change_field_xx][current_submit_item_here]);

		over_2_weight_tf.setText(nm.carbon[5][ship_weight_change_quantity_xx][current_submit_item_here]);
		weight_switch_to_tf.setText(nm.carbon[5][ship_weight_change_type_xx][current_submit_item_here]);

		over_2_weight_tf2.setText(nm.carbon[5][ship_weight_change_quantity_xx2][current_submit_item_here]);
		weight_switch_to_tf2.setText(nm.carbon[5][ship_weight_change_type_xx2][current_submit_item_here]);


		try {

			System.out.println("match type " + nm.carbon[5][match_type_xx][nm.amazon_settings_item]);
			int ix0 = Integer.parseInt(nm.carbon[5][match_type_xx][nm.amazon_settings_item]);

			if (amazon_match_type.length < ix0) {ix0 = 1;}

			match_type.setSelectedIndex(ix0);

		} catch (Exception e) {match_type.setSelectedIndex(0);}



		try {

			System.out.println(nm.carbon[5][match_column_xx][nm.amazon_settings_item]);
			int ix1 = Integer.parseInt(nm.carbon[5][match_column_xx][nm.amazon_settings_item]);

			if (ix1 > nm.db_string.length) {ix1 = 1;}

			match_column.setSelectedIndex(ix1);

		} catch (Exception e) {match_column.setSelectedIndex(1);}





		sales_days_past.setText(nm.carbon[5][sales_days_past_xx][current_submit_item_here]);

		if (nm.carbon[5][import_everything_xx][current_submit_item_here].equals("1")) {

			import_everything.setSelected(true);

		}//****************************************************************************
		else {

			import_everything.setSelected(false);

		}//***



	}//savex










	public void savex_x() {



		nm.carbon[5][2][nm.amazon_settings_item] = tfAWSAccessKeyID.getText();
		nm.carbon[5][3][nm.amazon_settings_item] = tfSecretKey.getText();
		nm.carbon[5][6][nm.amazon_settings_item] = tfMerchantID.getText();
		nm.carbon[5][7][nm.amazon_settings_item] = tfMarketplaceID.getText();


		nm.carbon[5][ship_weight_change_quantity_xx][current_submit_item_here] = over_2_weight_tf.getText();
		nm.carbon[5][ship_weight_change_type_xx][current_submit_item_here] = weight_switch_to_tf.getText();

		nm.carbon[5][ship_weight_change_quantity_xx2][current_submit_item_here] = over_2_weight_tf2.getText();
		nm.carbon[5][ship_weight_change_type_xx2][current_submit_item_here] = weight_switch_to_tf2.getText();


		nm.carbon[5][ship_change_quantity_xx][current_submit_item_here] = over_2_units_tf.getText();
		nm.carbon[5][ship_change_type_xx][current_submit_item_here] = switch_to_tf.getText();

		nm.carbon[5][ship_change_quantity_xx2][current_submit_item_here] = over_2_units_tf2.getText();
		nm.carbon[5][ship_change_type_xx2][current_submit_item_here] = switch_to_tf2.getText();


		//nm.carbon[0][nm.item_description_xx][selected_int] = jtexta.getText().replace("\r\n", " ").replace("\n", " ");
		//cx0 = nm.carbon[5][nm.item_description_xx][nm.amazon_settings_item];
		//System.out.println(cx0);


		nm.carbon[5][sales_days_past_xx][current_submit_item_here] = sales_days_past.getText();

		if (import_everything.isSelected() == true) {

			nm.carbon[5][import_everything_xx][current_submit_item_here] = "1";

		}//******************************************
		else {

			nm.carbon[5][import_everything_xx][current_submit_item_here] = "0";

		}//***


		String[][] save_item = new String[nm.carbon[5].length][1];

		for(int xloop = 0; xloop < nm.carbon[5].length; xloop++){//**************

			save_item[xloop][0] = nm.carbon[5][xloop][current_submit_item_here];

		}//**********************************************************************

		
		jdb_edit_connection save = new jdb_edit_connection(save_item, Integer.toString(current_submit_item_here));


	}//savex








//handel all the button clicks. 
public void actionPerformed(ActionEvent event){



	if (event.getSource() == save_db) {savex_x();}


	if (event.getSource() == match_column) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < match_column.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][match_column_xx][nm.amazon_settings_item] = Integer.toString(loop1); 
				System.out.println(loop1);

			}//**************************************

		}//*********************

	}//not used



	if (event.getSource() == match_type) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < match_type.getItemCount(); loop1++){//s1x

			if (amazon_match_type[loop1].equals(newItem)) {

				nm.carbon[5][match_type_xx][nm.amazon_settings_item] = Integer.toString(loop1); 
				System.out.println(loop1);

			}//***********************************************

		}//*********************

	}//not used



	if (event.getSource() == in_this_field_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < in_this_field_cb.getItemCount(); loop1++) {//s1x

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

		for (int loop1 = 0; loop1 < weight_in_this_field_cb.getItemCount(); loop1++) {//s1x

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

		for (int loop1 = 0; loop1 < not_international_cb.getItemCount(); loop1++){

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][amazon_ship_not_international_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == amazon_id_export) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < amazon_id_export.getItemCount(); loop1++) {

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][amazon_id_export_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



}//actionPerformed








    public static void main(int what_item) {

		amazon_settings xr = new amazon_settings(what_item);

    }//main







}//last****************************************
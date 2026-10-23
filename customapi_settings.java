import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPHTTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.commons.net.ftp.FTPSClient;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;




public class customapi_settings extends JFrame implements ActionListener {//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 700;
int xzy = 700;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JLabel header1 = new JLabel("Export Settings", JLabel.LEFT);
JLabel header2 = new JLabel("Import Settings", JLabel.LEFT);
JLabel header3 = new JLabel("Import Settings", JLabel.LEFT);

Object newItem;
JComboBox cb;

JComboBox shipping_location = new JComboBox();
JComboBox shipping_type = new JComboBox();
JComboBox match_column = new JComboBox();
JComboBox match_type = new JComboBox();
JComboBox export_mail_type = new JComboBox();

JLabel not_international_l = new JLabel("If the sale is NOT international then use (MAIL TYPE) settings in this field: ", JLabel.LEFT);
JComboBox not_international_cb = new JComboBox();

JLabel info_header2_1 = new JLabel("Import ?? days past ", JLabel.LEFT);
JLabel info_header2_2 = new JLabel("Import ONLY inventoried items ", JLabel.RIGHT);
JTextField sales_days_past = new JTextField("", 12);

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

JButton export_php = new JButton("Export");
JButton build_db = new JButton("Build DB");
JButton save_db = new JButton("Save");

JLabel alchemy_shipping_settings_l = new JLabel("Shipping Carrier POST: ", JLabel.LEFT);
JTextField alchemy_shipping_settings = new JTextField("", 15);

JLabel store_catx1_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx1_lp = new JLabel("cpost1", JLabel.LEFT);
JTextField store_catx1 = new JTextField("", 13);
JComboBox store_catx1_cb = new JComboBox();

JLabel store_catx2_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx2_lp = new JLabel("cpost2", JLabel.LEFT);
JTextField store_catx2 = new JTextField("", 13);
JComboBox store_catx2_cb = new JComboBox();

JLabel store_catx3_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx3_lp = new JLabel("cpost3", JLabel.LEFT);
JTextField store_catx3 = new JTextField("", 13);
JComboBox store_catx3_cb = new JComboBox();

JLabel store_catx4_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx4_lp = new JLabel("cpost4", JLabel.LEFT);
JTextField store_catx4 = new JTextField("", 13);
JComboBox store_catx4_cb = new JComboBox();

JLabel store_catx5_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx5_lp = new JLabel("cpost5", JLabel.LEFT);
JTextField store_catx5 = new JTextField("", 13);
JComboBox store_catx5_cb = new JComboBox();

JLabel store_catx6_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx6_lp = new JLabel("cpost6", JLabel.LEFT);
JTextField store_catx6 = new JTextField("", 13);
JComboBox store_catx6_cb = new JComboBox();

JLabel store_catx7_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx7_lp = new JLabel("cpost7", JLabel.LEFT);
JTextField store_catx7 = new JTextField("", 13);
JComboBox store_catx7_cb = new JComboBox();

JLabel store_catx8_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx8_lp = new JLabel("cpost8", JLabel.LEFT);
JTextField store_catx8 = new JTextField("", 13);
JComboBox store_catx8_cb = new JComboBox();

JLabel store_catx9_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx9_lp = new JLabel("cpost9", JLabel.LEFT);
JTextField store_catx9 = new JTextField("", 13);
JComboBox store_catx9_cb = new JComboBox();

JLabel store_catx10_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx10_lp = new JLabel("cpost10", JLabel.LEFT);
JTextField store_catx10 = new JTextField("", 13);
JComboBox store_catx10_cb = new JComboBox();

JLabel store_catx11_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx11_lp = new JLabel("cpost11", JLabel.LEFT);
JTextField store_catx11 = new JTextField("", 13);
JComboBox store_catx11_cb = new JComboBox();

JLabel store_catx12_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx12_lp = new JLabel("cpost12", JLabel.LEFT);
JTextField store_catx12 = new JTextField("", 13);
JComboBox store_catx12_cb = new JComboBox();

JLabel store_catx13_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx13_lp = new JLabel("cpost13", JLabel.LEFT);
JTextField store_catx13 = new JTextField("", 13);
JComboBox store_catx13_cb = new JComboBox();

JLabel store_catx14_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx14_lp = new JLabel("cpost14", JLabel.LEFT);
JTextField store_catx14 = new JTextField("", 13);
JComboBox store_catx14_cb = new JComboBox();

JLabel store_catx15_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx15_lp = new JLabel("cpost15", JLabel.LEFT);
JTextField store_catx15 = new JTextField("", 13);
JComboBox store_catx15_cb = new JComboBox();

JLabel store_catx16_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx16_lp = new JLabel("cpost16", JLabel.LEFT);
JTextField store_catx16 = new JTextField("", 13);
JComboBox store_catx16_cb = new JComboBox();

JLabel store_catx17_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx17_lp = new JLabel("cpost17", JLabel.LEFT);
JTextField store_catx17 = new JTextField("", 13);
JComboBox store_catx17_cb = new JComboBox();

JLabel store_catx18_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx18_lp = new JLabel("cpost18", JLabel.LEFT);
JTextField store_catx18 = new JTextField("", 13);
JComboBox store_catx18_cb = new JComboBox();

JLabel store_catx19_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx19_lp = new JLabel("cpost19", JLabel.LEFT);
JTextField store_catx19 = new JTextField("", 13);
JComboBox store_catx19_cb = new JComboBox();

JLabel store_catx20_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx20_lp = new JLabel("cpost20", JLabel.LEFT);
JTextField store_catx20 = new JTextField("", 13);
JComboBox store_catx20_cb = new JComboBox();

JLabel store_catx21_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx21_lp = new JLabel("cpost21", JLabel.LEFT);
JTextField store_catx21 = new JTextField("", 13);
JComboBox store_catx21_cb = new JComboBox();

JLabel store_catx22_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx22_lp = new JLabel("cpost22", JLabel.LEFT);
JTextField store_catx22 = new JTextField("", 13);
JComboBox store_catx22_cb = new JComboBox();

JLabel store_catx23_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx23_lp = new JLabel("cpost23", JLabel.LEFT);
JTextField store_catx23 = new JTextField("", 13);
JComboBox store_catx23_cb = new JComboBox();

JLabel store_catx24_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx24_lp = new JLabel("cpost24", JLabel.LEFT);
JTextField store_catx24 = new JTextField("", 13);
JComboBox store_catx24_cb = new JComboBox();

JLabel store_catx25_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx25_lp = new JLabel("cpost25", JLabel.LEFT);
JTextField store_catx25 = new JTextField("", 13);
JComboBox store_catx25_cb = new JComboBox();

JLabel store_catx26_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx26_lp = new JLabel("cpost26", JLabel.LEFT);
JTextField store_catx26 = new JTextField("", 13);
JComboBox store_catx26_cb = new JComboBox();

JLabel store_catx27_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx27_lp = new JLabel("cpost27", JLabel.LEFT);
JTextField store_catx27 = new JTextField("", 13);
JComboBox store_catx27_cb = new JComboBox();

JLabel store_catx28_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx28_lp = new JLabel("cpost28", JLabel.LEFT);
JTextField store_catx28 = new JTextField("", 13);
JComboBox store_catx28_cb = new JComboBox();

JLabel store_catx29_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx29_lp = new JLabel("cpost29", JLabel.LEFT);
JTextField store_catx29 = new JTextField("", 13);
JComboBox store_catx29_cb = new JComboBox();

JLabel store_catx30_l = new JLabel("Match POST fields ", JLabel.LEFT);
JLabel store_catx30_lp = new JLabel("cpost30", JLabel.LEFT);
JTextField store_catx30 = new JTextField("", 13);
JComboBox store_catx30_cb = new JComboBox();

JLabel store_urlx_lp = new JLabel("Picture Base URL:", JLabel.RIGHT);
JTextField store_urlx = new JTextField("", 35);

JLabel store_userx_lp = new JLabel("User Name:", JLabel.RIGHT);
JTextField store_userx = new JTextField("", 13);

JLabel store_passx_lp = new JLabel("Password:", JLabel.RIGHT);
JTextField store_passx = new JTextField("", 13);

JLabel store_import_url_lp = new JLabel("Import API URL", JLabel.LEFT);
JTextField store_import_url = new JTextField("", 35);

JLabel store_export_url_lp = new JLabel("Export API URL", JLabel.LEFT);
JTextField store_export_url = new JTextField("", 35);


//settings custom_api
//0 - 15 defined in nm.
static int m2_cx1_xx = 16;
static int m2_cx2_xx = 17;
static int m2_cx3_xx = 18;
static int m2_cx4_xx = 19;
static int m2_cx5_xx = 20;
static int m2_cx6_xx = 21;
static int m2_cx7_xx = 22;
static int m2_cx8_xx = 23;
static int m2_cx9_xx = 24;
static int m2_cx10_xx = 25;
static int m2_cx11_xx = 26;
static int m2_cx12_xx = 27;
static int m2_cx13_xx = 28;
static int m2_cx14_xx = 29;
static int m2_cx15_xx = 30;
static int m2_cx16_xx = 31;
static int m2_cx17_xx = 32;
static int m2_cx18_xx = 33;
static int m2_cx19_xx = 34;
static int m2_cx20_xx = 35;
static int m2_cx21_xx = 36;
static int m2_cx22_xx = 37;
static int m2_cx23_xx = 38;
static int m2_cx24_xx = 39;
static int m2_cx25_xx = 40;
static int m2_cx26_xx = 41;
static int m2_cx27_xx = 42;
static int m2_cx28_xx = 43;
static int m2_cx29_xx = 44;
static int m2_cx30_xx = 45;
static int m2_pic_url_xx = 46;
static int m2_userx_xx = 47;
static int m2_passx_xx = 48;
static int m2_import_url_xx = 49;
static int m2_export_url_xx = 50;

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






customapi_settings(int what_item) {//****************************

	super("Custom API Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, (ceny - 10));
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex_x(); nm.account_settings_open = false;}});


	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	export_php.setMargin(new Insets(0, 0, 0, 0));
  	export_php.addActionListener(this);
 	export_php.setPreferredSize(new Dimension(80, 20));
	export_php.setBackground(nm.st_gray1); 
	export_php.setHorizontalTextPosition(JButton.CENTER);
 	export_php.setForeground(nm.blackx);
	export_php.setToolTipText("Export PHP files to the website.");

	build_db.setMargin(new Insets(0, 0, 0, 0));
  	build_db.addActionListener(this);
 	build_db.setPreferredSize(new Dimension(80, 20));
	build_db.setBackground(nm.st_gray1);
	build_db.setHorizontalTextPosition(JButton.CENTER);
 	build_db.setForeground(nm.blackx);
	build_db.setToolTipText("Install DB Tables.");

    save_db.setMargin(new Insets(0, 0, 0, 0));
    save_db.addActionListener(this);
    save_db.setPreferredSize(new Dimension(120, 30));
    save_db.setBackground(nm.st_gray1);
    save_db.setHorizontalTextPosition(JButton.CENTER);
    save_db.setForeground(nm.blackx);
    save_db.setToolTipText("Save database");


	FlowLayout flow = new FlowLayout(0);
	flow.setHgap(0);
	flow.setVgap(0);


	header1.setPreferredSize(new Dimension(660, 20));
	header2.setPreferredSize(new Dimension(660, 20));
	header3.setPreferredSize(new Dimension(660, 20));

	info_header2_1.setPreferredSize(new Dimension(130, 20));
	info_header2_2.setPreferredSize(new Dimension(330, 20));

	load_import_settingsx();

	store_catx1_l.setPreferredSize(new Dimension(200, 20));
	store_catx1_lp.setPreferredSize(new Dimension(100, 20));

	store_catx2_l.setPreferredSize(new Dimension(200, 20));
	store_catx2_lp.setPreferredSize(new Dimension(100, 20));

	store_catx3_l.setPreferredSize(new Dimension(200, 20));
	store_catx3_lp.setPreferredSize(new Dimension(100, 20));

	store_catx4_l.setPreferredSize(new Dimension(200, 20));
	store_catx4_lp.setPreferredSize(new Dimension(100, 20));

	store_catx5_l.setPreferredSize(new Dimension(200, 20));
	store_catx5_lp.setPreferredSize(new Dimension(100, 20));

	store_catx6_l.setPreferredSize(new Dimension(200, 20));
	store_catx6_lp.setPreferredSize(new Dimension(100, 20));

	store_catx7_l.setPreferredSize(new Dimension(200, 20));
	store_catx7_lp.setPreferredSize(new Dimension(100, 20));

	store_catx8_l.setPreferredSize(new Dimension(200, 20));
	store_catx8_lp.setPreferredSize(new Dimension(100, 20));

	store_catx9_l.setPreferredSize(new Dimension(200, 20));
	store_catx9_lp.setPreferredSize(new Dimension(100, 20));

	store_catx10_l.setPreferredSize(new Dimension(200, 20));
	store_catx10_lp.setPreferredSize(new Dimension(100, 20));

	store_catx11_l.setPreferredSize(new Dimension(200, 20));
	store_catx11_lp.setPreferredSize(new Dimension(100, 20));

	store_catx12_l.setPreferredSize(new Dimension(200, 20));
	store_catx12_lp.setPreferredSize(new Dimension(100, 20));

	store_catx13_l.setPreferredSize(new Dimension(200, 20));
	store_catx13_lp.setPreferredSize(new Dimension(100, 20));

	store_catx14_l.setPreferredSize(new Dimension(200, 20));
	store_catx14_lp.setPreferredSize(new Dimension(100, 20));

	store_catx15_l.setPreferredSize(new Dimension(200, 20));
	store_catx15_lp.setPreferredSize(new Dimension(100, 20));

	store_catx16_l.setPreferredSize(new Dimension(200, 20));
	store_catx16_lp.setPreferredSize(new Dimension(100, 20));

	store_catx17_l.setPreferredSize(new Dimension(200, 20));
	store_catx17_lp.setPreferredSize(new Dimension(100, 20));

	store_catx18_l.setPreferredSize(new Dimension(200, 20));
	store_catx18_lp.setPreferredSize(new Dimension(100, 20));

	store_catx19_l.setPreferredSize(new Dimension(200, 20));
	store_catx19_lp.setPreferredSize(new Dimension(100, 20));

	store_catx20_l.setPreferredSize(new Dimension(200, 20));
	store_catx20_lp.setPreferredSize(new Dimension(100, 20));

	store_catx21_l.setPreferredSize(new Dimension(200, 20));
	store_catx21_lp.setPreferredSize(new Dimension(100, 20));

	store_catx22_l.setPreferredSize(new Dimension(200, 20));
	store_catx22_lp.setPreferredSize(new Dimension(100, 20));

	store_catx23_l.setPreferredSize(new Dimension(200, 20));
	store_catx23_lp.setPreferredSize(new Dimension(100, 20));

	store_catx24_l.setPreferredSize(new Dimension(200, 20));
	store_catx24_lp.setPreferredSize(new Dimension(100, 20));

	store_catx25_l.setPreferredSize(new Dimension(200, 20));
	store_catx25_lp.setPreferredSize(new Dimension(100, 20));

	store_catx26_l.setPreferredSize(new Dimension(200, 20));
	store_catx26_lp.setPreferredSize(new Dimension(100, 20));

	store_catx27_l.setPreferredSize(new Dimension(200, 20));
	store_catx27_lp.setPreferredSize(new Dimension(100, 20));

	store_catx28_l.setPreferredSize(new Dimension(200, 20));
	store_catx28_lp.setPreferredSize(new Dimension(100, 20));

	store_catx29_l.setPreferredSize(new Dimension(200, 20));
	store_catx29_lp.setPreferredSize(new Dimension(100, 20));

	store_catx30_l.setPreferredSize(new Dimension(200, 20));
	store_catx30_lp.setPreferredSize(new Dimension(100, 20));



	loadx_x();
	setupd();


	System.out.println("LOAD " + nm.carbon[5][m2_cx1_xx][nm.current_submit_item_a]);
	store_catx1_cb = new JComboBox(nm.db_string);
	try {

		store_catx1_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx1_xx][nm.current_submit_item_a]));

	} catch (Exception e) {

		System.out.println("LOAD " + nm.carbon[5][m2_cx1_xx][nm.current_submit_item_a]);

	}//********************
	store_catx1_cb.addActionListener(this);
	store_catx1_cb.setPreferredSize(new Dimension(180, 20));


	store_catx2_cb = new JComboBox(nm.db_string);
	try {

		store_catx2_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx2_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx2_cb.addActionListener(this);
	store_catx2_cb.setPreferredSize(new Dimension(180, 20));


	store_catx3_cb = new JComboBox(nm.db_string);
	try {

		store_catx3_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx3_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx3_cb.addActionListener(this);
	store_catx3_cb.setPreferredSize(new Dimension(180, 20));


	store_catx4_cb = new JComboBox(nm.db_string);
	try {

		store_catx4_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx4_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx4_cb.addActionListener(this);
	store_catx4_cb.setPreferredSize(new Dimension(180, 20));


	store_catx5_cb = new JComboBox(nm.db_string);
	try {

		store_catx5_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx5_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx5_cb.addActionListener(this);
	store_catx5_cb.setPreferredSize(new Dimension(180, 20));


	store_catx6_cb = new JComboBox(nm.db_string);
	try {

		store_catx6_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx6_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx6_cb.addActionListener(this);
	store_catx6_cb.setPreferredSize(new Dimension(180, 20));


	store_catx7_cb = new JComboBox(nm.db_string);
	try {

		store_catx7_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx7_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx7_cb.addActionListener(this);
	store_catx7_cb.setPreferredSize(new Dimension(180, 20));


	store_catx8_cb = new JComboBox(nm.db_string);
	try {

		store_catx8_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx8_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx8_cb.addActionListener(this);
	store_catx8_cb.setPreferredSize(new Dimension(180, 20));


	store_catx9_cb = new JComboBox(nm.db_string);
	try {

		store_catx9_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx9_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx9_cb.addActionListener(this);
	store_catx9_cb.setPreferredSize(new Dimension(180, 20));


	store_catx10_cb = new JComboBox(nm.db_string);
	try {

		store_catx10_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx10_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx10_cb.addActionListener(this);
	store_catx10_cb.setPreferredSize(new Dimension(180, 20));


	store_catx11_cb = new JComboBox(nm.db_string);
	try {

		store_catx11_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx11_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx11_cb.addActionListener(this);
	store_catx11_cb.setPreferredSize(new Dimension(180, 20));


	store_catx12_cb = new JComboBox(nm.db_string);
	try {

		store_catx12_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx12_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx12_cb.addActionListener(this);
	store_catx12_cb.setPreferredSize(new Dimension(180, 20));


	store_catx13_cb = new JComboBox(nm.db_string);
	try {

		store_catx13_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx13_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx13_cb.addActionListener(this);
	store_catx13_cb.setPreferredSize(new Dimension(180, 20));


	store_catx14_cb = new JComboBox(nm.db_string);
	try {

		store_catx14_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx14_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx14_cb.addActionListener(this);
	store_catx14_cb.setPreferredSize(new Dimension(180, 20));


	store_catx15_cb = new JComboBox(nm.db_string);
	try {

		store_catx15_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx15_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx15_cb.addActionListener(this);
	store_catx15_cb.setPreferredSize(new Dimension(180, 20));


	store_catx16_cb = new JComboBox(nm.db_string);
	try {

		store_catx16_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx16_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx16_cb.addActionListener(this);
	store_catx16_cb.setPreferredSize(new Dimension(180, 20));


	store_catx17_cb = new JComboBox(nm.db_string);
	try {

		store_catx17_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx17_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx17_cb.addActionListener(this);
	store_catx17_cb.setPreferredSize(new Dimension(180, 20));


	store_catx18_cb = new JComboBox(nm.db_string);
	try {

		store_catx18_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx18_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx18_cb.addActionListener(this);
	store_catx18_cb.setPreferredSize(new Dimension(180, 20));


	store_catx19_cb = new JComboBox(nm.db_string);
	try {

		store_catx19_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx19_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx19_cb.addActionListener(this);
	store_catx19_cb.setPreferredSize(new Dimension(180, 20));


	store_catx20_cb = new JComboBox(nm.db_string);
	try {

		store_catx20_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx20_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx20_cb.addActionListener(this);
	store_catx20_cb.setPreferredSize(new Dimension(180, 20));


	store_catx21_cb = new JComboBox(nm.db_string);
	try {

		store_catx21_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx21_xx][nm.current_submit_item_a]));

	} catch (Exception e){}
	store_catx21_cb.addActionListener(this);
	store_catx21_cb.setPreferredSize(new Dimension(180, 20));


	store_catx22_cb = new JComboBox(nm.db_string);
	try {

		store_catx22_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx22_xx][nm.current_submit_item_a]));

	} catch (Exception e){}
	store_catx22_cb.addActionListener(this);
	store_catx22_cb.setPreferredSize(new Dimension(180, 20));


	store_catx23_cb = new JComboBox(nm.db_string);
	try {

		store_catx23_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx23_xx][nm.current_submit_item_a]));

	} catch (Exception e){}
	store_catx23_cb.addActionListener(this);
	store_catx23_cb.setPreferredSize(new Dimension(180, 20));


	store_catx24_cb = new JComboBox(nm.db_string);
	try {

		store_catx24_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx24_xx][nm.current_submit_item_a]));

	} catch (Exception e){}
	store_catx24_cb.addActionListener(this);
	store_catx24_cb.setPreferredSize(new Dimension(180, 20));


	store_catx25_cb = new JComboBox(nm.db_string);
	try {

		store_catx25_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx25_xx][nm.current_submit_item_a]));

	} catch (Exception e){}
	store_catx25_cb.addActionListener(this);
	store_catx25_cb.setPreferredSize(new Dimension(180, 20));


	store_catx26_cb = new JComboBox(nm.db_string);
	try {

		store_catx26_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx26_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx26_cb.addActionListener(this);
	store_catx26_cb.setPreferredSize(new Dimension(180, 20));


	store_catx27_cb = new JComboBox(nm.db_string);
	try {

		store_catx27_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx27_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx27_cb.addActionListener(this);
	store_catx27_cb.setPreferredSize(new Dimension(180, 20));


	store_catx28_cb = new JComboBox(nm.db_string);
	try {

		store_catx28_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx28_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx28_cb.addActionListener(this);
	store_catx28_cb.setPreferredSize(new Dimension(180, 20));


	store_catx29_cb = new JComboBox(nm.db_string);
	try {

		store_catx29_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx29_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx29_cb.addActionListener(this);
	store_catx29_cb.setPreferredSize(new Dimension(180, 20));


	store_catx30_cb = new JComboBox(nm.db_string);
	try {

		store_catx30_cb.setSelectedIndex(Integer.parseInt(nm.carbon[5][m2_cx30_xx][nm.current_submit_item_a]));

	} catch (Exception e) {}
	store_catx30_cb.addActionListener(this);
	store_catx30_cb.setPreferredSize(new Dimension(180, 20));




	//store settings

	JPanel jpk1_xx1 = new JPanel();
	jpk1_xx1.setPreferredSize(new Dimension(xzx -50, 780));
	jpk1_xx1.setBackground(nm.st_gray1);
	jpk1_xx1.add(store_catx1_l);   jpk1_xx1.add(store_catx1_lp);   jpk1_xx1.add(store_catx1_cb);  
	jpk1_xx1.add(store_catx2_l);   jpk1_xx1.add(store_catx2_lp);   jpk1_xx1.add(store_catx2_cb);  
	jpk1_xx1.add(store_catx3_l);   jpk1_xx1.add(store_catx3_lp);   jpk1_xx1.add(store_catx3_cb);  
	jpk1_xx1.add(store_catx4_l);   jpk1_xx1.add(store_catx4_lp);   jpk1_xx1.add(store_catx4_cb);  
	jpk1_xx1.add(store_catx5_l);   jpk1_xx1.add(store_catx5_lp);   jpk1_xx1.add(store_catx5_cb);  
	jpk1_xx1.add(store_catx6_l);   jpk1_xx1.add(store_catx6_lp);   jpk1_xx1.add(store_catx6_cb);  
	jpk1_xx1.add(store_catx7_l);   jpk1_xx1.add(store_catx7_lp);   jpk1_xx1.add(store_catx7_cb);  
	jpk1_xx1.add(store_catx8_l);   jpk1_xx1.add(store_catx8_lp);   jpk1_xx1.add(store_catx8_cb);  
	jpk1_xx1.add(store_catx9_l);   jpk1_xx1.add(store_catx9_lp);   jpk1_xx1.add(store_catx9_cb);  
	jpk1_xx1.add(store_catx10_l);  jpk1_xx1.add(store_catx10_lp);  jpk1_xx1.add(store_catx10_cb);  

	jpk1_xx1.add(store_catx11_l);  jpk1_xx1.add(store_catx11_lp);  jpk1_xx1.add(store_catx11_cb);  
	jpk1_xx1.add(store_catx12_l);  jpk1_xx1.add(store_catx12_lp);  jpk1_xx1.add(store_catx12_cb);  
	jpk1_xx1.add(store_catx13_l);  jpk1_xx1.add(store_catx13_lp);  jpk1_xx1.add(store_catx13_cb);  
	jpk1_xx1.add(store_catx14_l);  jpk1_xx1.add(store_catx14_lp);  jpk1_xx1.add(store_catx14_cb);  
	jpk1_xx1.add(store_catx15_l);  jpk1_xx1.add(store_catx15_lp);  jpk1_xx1.add(store_catx15_cb);  
	jpk1_xx1.add(store_catx16_l);  jpk1_xx1.add(store_catx16_lp);  jpk1_xx1.add(store_catx16_cb);  
	jpk1_xx1.add(store_catx17_l);  jpk1_xx1.add(store_catx17_lp);  jpk1_xx1.add(store_catx17_cb);  
	jpk1_xx1.add(store_catx18_l);  jpk1_xx1.add(store_catx18_lp);  jpk1_xx1.add(store_catx18_cb);  
	jpk1_xx1.add(store_catx19_l);  jpk1_xx1.add(store_catx19_lp);  jpk1_xx1.add(store_catx19_cb);  
	jpk1_xx1.add(store_catx20_l);  jpk1_xx1.add(store_catx20_lp);  jpk1_xx1.add(store_catx20_cb); 

	jpk1_xx1.add(store_catx21_l);  jpk1_xx1.add(store_catx21_lp);  jpk1_xx1.add(store_catx21_cb);  
	jpk1_xx1.add(store_catx22_l);  jpk1_xx1.add(store_catx22_lp);  jpk1_xx1.add(store_catx22_cb);  
	jpk1_xx1.add(store_catx23_l);  jpk1_xx1.add(store_catx23_lp);  jpk1_xx1.add(store_catx23_cb);  
	jpk1_xx1.add(store_catx24_l);  jpk1_xx1.add(store_catx24_lp);  jpk1_xx1.add(store_catx24_cb);  
	jpk1_xx1.add(store_catx25_l);  jpk1_xx1.add(store_catx25_lp);  jpk1_xx1.add(store_catx25_cb);  
	jpk1_xx1.add(store_catx26_l);  jpk1_xx1.add(store_catx26_lp);  jpk1_xx1.add(store_catx26_cb);  
	jpk1_xx1.add(store_catx27_l);  jpk1_xx1.add(store_catx27_lp);  jpk1_xx1.add(store_catx27_cb);  
	jpk1_xx1.add(store_catx28_l);  jpk1_xx1.add(store_catx28_lp);  jpk1_xx1.add(store_catx28_cb);  
	jpk1_xx1.add(store_catx29_l);  jpk1_xx1.add(store_catx29_lp);  jpk1_xx1.add(store_catx29_cb);  
	jpk1_xx1.add(store_catx30_l);  jpk1_xx1.add(store_catx30_lp);  jpk1_xx1.add(store_catx30_cb); 


	store_urlx_lp.setPreferredSize(new Dimension(112, 20));
	store_userx_lp.setPreferredSize(new Dimension(87, 20));
	store_passx_lp.setPreferredSize(new Dimension(110, 20));
	store_import_url_lp.setPreferredSize(new Dimension(100, 20));


	JPanel jpk1_xx2 = new JPanel();
	jpk1_xx2.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_xx2.setBackground(nm.st_gray1);
	jpk1_xx2.add(store_urlx_lp);  jpk1_xx2.add(store_urlx);


	JPanel jpk1_xx3 = new JPanel();
	jpk1_xx3.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_xx3.setBackground(nm.st_gray1);
	jpk1_xx3.add(store_userx_lp);  jpk1_xx3.add(store_userx);
	jpk1_xx3.add(store_passx_lp);  jpk1_xx3.add(store_passx);


	JPanel jpk1_xx4 = new JPanel();
	jpk1_xx4.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_xx4.setBackground(nm.st_gray1);
	jpk1_xx4.add(store_import_url_lp);  jpk1_xx4.add(store_import_url);




	TitledBorder titled1 = BorderFactory.createTitledBorder("Export Settings");
	titled1.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_x = new JPanel();
	jpk1_x.setPreferredSize(new Dimension(xzx -25, 950));
	jpk1_x.setBackground(nm.st_gray1);
	jpk1_x.setBorder(titled1);
  	jpk1_x.add(jpk1_xx1);
  	jpk1_x.add(jpk1_xx2);
  	jpk1_x.add(jpk1_xx3);
  	//jpk1_x.add(jpk1_xx4);


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



	TitledBorder titled2 = BorderFactory.createTitledBorder("Import Settings");
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
	//jpk1_1.add(jpk1_p5);


    JPanel jpk0_x = new JPanel();
    jpk0_x.setLayout(new FlowLayout());
    jpk0_x.setPreferredSize(new Dimension(xzx -25, 40));
    jpk0_x.setBackground(nm.st_gray1);
    jpk0_x.add(save_db);


	JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(xzx -25, 1255));
	jpk1.setBackground(nm.whitex);
	jpk1.setBackground(nm.st_gray1);
    //jpk1.add(jpk0_x);
	jpk1.add(jpk1_x);
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



}//csv_loader_x1********************************************************












	public void loadx_x() {

		System.out.println("Load Settings");

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

	    store_urlx.setText(nm.carbon[5][m2_pic_url_xx][nm.current_submit_item_a]);

	    store_userx.setText(nm.carbon[5][m2_userx_xx][nm.current_submit_item_a]);
	    store_passx.setText(nm.carbon[5][m2_passx_xx][nm.current_submit_item_a]);
	    store_import_url.setText(nm.carbon[5][m2_import_url_xx][nm.current_submit_item_a]);
	    store_export_url.setText(nm.carbon[5][m2_export_url_xx][nm.current_submit_item_a]);

	}//*****************************************************************************************************











	public void savex_x() {

		System.out.println("Save Settings");

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

	    nm.carbon[5][m2_pic_url_xx][nm.current_submit_item_a] = store_urlx.getText();

	    nm.carbon[5][m2_userx_xx][nm.current_submit_item_a] = store_userx.getText();
	    nm.carbon[5][m2_passx_xx][nm.current_submit_item_a] = store_passx.getText();
	    nm.carbon[5][m2_import_url_xx][nm.current_submit_item_a] = store_import_url.getText();
	    nm.carbon[5][m2_export_url_xx][nm.current_submit_item_a] = store_export_url.getText();

        String[][] save_item = new String[nm.carbon[5].length][1];

        for (int xloop = 0; xloop < nm.carbon[5].length; xloop++) {//************

            save_item[xloop][0] = nm.carbon[5][xloop][nm.current_submit_item_a];

        }//**********************************************************************

        jdb_edit_connection save = new jdb_edit_connection(save_item, nm.carbon[5][nm.id_mm][nm.current_submit_item_a]);


	}//savex******************************************************************************************************














	public void load_import_settingsx() {


		int match_column_xx = 0;
		int match_type_xx = 0;




		match_column = new JComboBox(nm.db_string);
	    try {

	        System.out.println(nm.carbon[4][match_column_xx][nm.current_submit_item_a]);
	        int ix1 = Integer.parseInt(nm.carbon[4][match_column_xx][nm.current_submit_item_a]);

	        //match_column.setSelectedIndex(ix1);

	    } catch (Exception e){}
	    match_column.addActionListener(this);
	    match_column.setPreferredSize(new Dimension(150, 20));
	    match_column.setToolTipText("Set Match Info Location.");



	    in_this_field_cb = new JComboBox(nm.db_string);
	    try {

	        System.out.println(nm.carbon[5][ship_change_field_xx][nm.current_submit_item_a]);
	        int ix1 = Integer.parseInt(nm.carbon[5][ship_change_field_xx][nm.current_submit_item_a]);

	        in_this_field_cb.setSelectedIndex(ix1);

	    } catch (Exception e) {}
	    in_this_field_cb.addActionListener(this);
	    in_this_field_cb.setPreferredSize(new Dimension(150, 20));
	    in_this_field_cb.setToolTipText("Set Match Type.");



	    in_this_field_cb2 = new JComboBox(nm.db_string);
	    try {

	        System.out.println(nm.carbon[5][ship_change_field_xx2][nm.current_submit_item_a]);
	        int ix1 = Integer.parseInt(nm.carbon[5][ship_change_field_xx2][nm.current_submit_item_a]);

	        in_this_field_cb2.setSelectedIndex(ix1);

	    } catch (Exception e) {}
	    in_this_field_cb2.addActionListener(this);
	    in_this_field_cb2.setPreferredSize(new Dimension(150, 20));
	    in_this_field_cb2.setToolTipText("Set Match Type.");



	    weight_in_this_field_cb = new JComboBox(nm.db_string);
	    try {

	        System.out.println(nm.carbon[5][ship_weight_change_field_xx][nm.current_submit_item_a]);
	        int ix1 = Integer.parseInt(nm.carbon[5][ship_weight_change_field_xx][nm.current_submit_item_a]);

	        weight_in_this_field_cb.setSelectedIndex(ix1);

	    } catch (Exception e) {}
	    weight_in_this_field_cb.addActionListener(this);
	    weight_in_this_field_cb.setPreferredSize(new Dimension(150, 20));
	    weight_in_this_field_cb.setToolTipText("Set Match Type.");



	    weight_in_this_field_cb2 = new JComboBox(nm.db_string);
	    try {

	        System.out.println(nm.carbon[5][ship_weight_change_field_xx2][nm.current_submit_item_a]);
	        int ix1 = Integer.parseInt(nm.carbon[5][ship_weight_change_field_xx2][nm.current_submit_item_a]);

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



	}//**********************************











	public void setupd() {

	    if (nm.carbon[5][sales_days_past_xx][nm.current_submit_item_a].equals("0") && nm.carbon[5][ship_weight_change_quantity_xx][nm.current_submit_item_a].equals("0")) {


            import_everything.setSelected(false);

            over_2_units_tf.setText("1000");
            switch_to_tf.setText("NONRECPARCEL");

            over_2_units_tf2.setText("1000");
            switch_to_tf2.setText("PRIORITY");

            over_2_weight_tf.setText("1000");
            weight_switch_to_tf.setText("NONRECPARCEL");

            over_2_weight_tf2.setText("1000");
            weight_switch_to_tf2.setText("PRIROTY");


            sales_days_past.setText("1");

            alchemy_shipping_settings.setText("1");


            nm.carbon[5][m2_cx1_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx2_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx3_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx4_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx5_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx6_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx7_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx8_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx9_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx10_xx][nm.current_submit_item_a] = ("93");

            nm.carbon[5][m2_cx11_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx12_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx13_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx14_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx15_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx16_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx17_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx18_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx19_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx20_xx][nm.current_submit_item_a] = ("93");

            nm.carbon[5][m2_cx21_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx22_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx23_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx24_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx25_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx26_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx27_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx28_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx29_xx][nm.current_submit_item_a] = ("93");
            nm.carbon[5][m2_cx30_xx][nm.current_submit_item_a] = ("93");



            in_this_field_cb.setSelectedIndex(2);
            in_this_field_cb2.setSelectedIndex(3);
            weight_in_this_field_cb.setSelectedIndex(2);
            weight_in_this_field_cb2.setSelectedIndex(3);


	   }//if

	}//******************













//handel all the button clicks. 
public void actionPerformed(ActionEvent event) {



    if (event.getSource() == save_db) {savex_x();}


	if (event.getSource() == store_catx1_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx1_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx1_xx][nm.current_submit_item_a] = Integer.toString(loop1); 
	        	System.out.println("SAVE " + nm.carbon[5][m2_cx1_xx][nm.current_submit_item_a]);

	        }//***************************************

	    }//*********************

	}//not used



	if (event.getSource() == store_catx2_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

    	for (int loop1 = 0; loop1 < store_catx2_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx2_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }//***************************************

	    }//*********************

	}//not used



	if (event.getSource() == store_catx3_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx3_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx3_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx4_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx4_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx4_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx5_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx5_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx5_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }//***************************************

	    }//*********************

	}//not used



	if (event.getSource() == store_catx6_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx6_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx6_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

     	}//*********************

	}//not used



	if (event.getSource() == store_catx7_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx7_cb.getItemCount(); loop1++) {//s1x

         	if (nm.db_string[loop1].equals(newItem)) {

         		nm.carbon[5][m2_cx7_xx][nm.current_submit_item_a] = Integer.toString(loop1);

         	}

     	}//*********************

	}//not used



	if (event.getSource() == store_catx8_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx8_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx8_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx9_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx9_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx9_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx10_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx10_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx10_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx11_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx11_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx11_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx12_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx12_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx12_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx13_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx13_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx13_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx14_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx14_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx14_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx15_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx15_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx15_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx16_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx16_cb.getItemCount(); loop1++){//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx16_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx17_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx17_cb.getItemCount(); loop1++){//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx17_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx18_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx18_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx18_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx19_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx19_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx19_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx20_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx20_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx20_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

     	}//*********************

	}//not used



	if (event.getSource() == store_catx21_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx21_cb.getItemCount(); loop1++){//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx21_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx22_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx22_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx22_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx23_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx23_cb.getItemCount(); loop1++){//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx23_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx24_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx24_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx24_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx25_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx25_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx25_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx26_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx26_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx26_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx27_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx27_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx27_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx28_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx28_cb.getItemCount(); loop1++) {//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx28_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if(event.getSource() == store_catx29_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx29_cb.getItemCount(); loop1++) {//s1x

	         if (nm.db_string[loop1].equals(newItem)) {

	         	nm.carbon[5][m2_cx29_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	         }

	    }//*********************

	}//not used



	if (event.getSource() == store_catx30_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < store_catx30_cb.getItemCount(); loop1++){//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][m2_cx30_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == in_this_field_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < in_this_field_cb.getItemCount(); loop1++){//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][ship_change_field_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == in_this_field_cb2){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < in_this_field_cb2.getItemCount(); loop1++){//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][ship_change_field_xx2][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == weight_in_this_field_cb) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < weight_in_this_field_cb.getItemCount(); loop1++){//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][ship_weight_change_field_xx][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used



	if (event.getSource() == weight_in_this_field_cb2) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

	    for (int loop1 = 0; loop1 < weight_in_this_field_cb2.getItemCount(); loop1++){//s1x

	        if (nm.db_string[loop1].equals(newItem)) {

	        	nm.carbon[5][ship_weight_change_field_xx2][nm.current_submit_item_a] = Integer.toString(loop1);

	        }

	    }//*********************

	}//not used





}//actionPerformed








    public static void main(int what_item) {

	   customapi_settings xr = new customapi_settings(what_item);

    }//main










}//last****************************************
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;




public class magento_settings extends JFrame implements ActionListener{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 700;
int xzy = 700;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


Label infoxs = new Label("", Label.LEFT);

JLabel infox0 = new JLabel("Export Settings:", JLabel.LEFT);
JLabel infox1 = new JLabel("Export Settings2:", JLabel.LEFT);
JLabel infox2 = new JLabel("Import Settings:", JLabel.LEFT);
JLabel infox3 = new JLabel("Export Settings1:", JLabel.LEFT);

int current_submit_item_here = -1;

JComboBox shipping_location = new JComboBox();
JComboBox shipping_type = new JComboBox();
JComboBox match_column = new JComboBox();
JComboBox match_type = new JComboBox();
JComboBox export_mail_type = new JComboBox();

JTextArea jtexta = new JTextArea();

JLabel not_international_l = new JLabel("If the sale is NOT international then use (MAIL TYPE) settings in this field: ", JLabel.LEFT);
JComboBox not_international_cb = new JComboBox();

JLabel info_header2_1 = new JLabel("Import ?? days past:", JLabel.LEFT);
JLabel info_header2_2 = new JLabel("Import ONLY inventoried items.", JLabel.RIGHT);
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

JLabel picture_url_l = new JLabel("Image Host", JLabel.LEFT);
JTextField picture_url = new JTextField("", 16);

JLabel ftp_folder_l = new JLabel("FTP Folder", JLabel.LEFT);
JTextField ftp_folder = new JTextField("", 18);

JLabel ftp_user_l = new JLabel("FTP User", JLabel.LEFT);
JTextField ftp_user = new JTextField("", 18);

JLabel ftp_pass_l = new JLabel("FTP Password", JLabel.LEFT);
JTextField ftp_pass = new JTextField("", 18);

JButton export_php = new JButton("Export");
JButton build_db = new JButton("Build DB");
JButton save_db = new JButton("Save");

String strUser = new String();
String strPassword = new String();
String strServer = new String();
String strRemoteName = new String();

String strLocalName = new String();

JLabel picture_other1_l = new JLabel("Other Images 1", JLabel.LEFT);
JLabel picture_other2_l = new JLabel("Other Images 2", JLabel.LEFT);
JLabel picture_other3_l = new JLabel("Other Images 3", JLabel.LEFT);
JLabel picture_other4_l = new JLabel("Other Images 4", JLabel.LEFT);

JComboBox picture_other1 = new JComboBox();
JComboBox picture_other2 = new JComboBox();
JComboBox picture_other3 = new JComboBox();
JComboBox picture_other4 = new JComboBox();

JCheckBox picture_other1_xb = new JCheckBox();
JCheckBox picture_other2_xb = new JCheckBox();
JCheckBox picture_other3_xb = new JCheckBox();
JCheckBox picture_other4_xb = new JCheckBox();

JLabel cat1_l = new JLabel("Magento Category 1:", JLabel.RIGHT);
JLabel cat2_l = new JLabel("Magento Category 2:", JLabel.RIGHT);

JComboBox cat1 = new JComboBox();
JComboBox cat2 = new JComboBox();

JLabel build_path_l = new JLabel("Description Build Path", JLabel.LEFT);
JTextField build_path = new JTextField("", 28);

JLabel magento_shipping_url_l = new JLabel("Shipping API URL: ", JLabel.RIGHT);
JTextField magento_shipping_url = new JTextField("", 20);
JLabel magento_spacerx1 = new JLabel("", JLabel.LEFT);

JLabel magento_shipping_user_l = new JLabel("User Name: ", JLabel.RIGHT);
JTextField magento_shipping_user = new JTextField("", 15);
JLabel magento_spacerx2 = new JLabel("", JLabel.LEFT);

JLabel magento_shipping_password_l = new JLabel("Password: ", JLabel.RIGHT);
JTextField magento_shipping_password = new JTextField("", 15);
JLabel magento_spacerx3 = new JLabel("", JLabel.LEFT);



//settings magento
static int host_set_url_xx = 16;
static int m_other_image1_xx = 17;
static int m_other_image2_xx = 18;
static int m_other_image3_xx = 19;
static int m_other_image4_xx = 20;
static int m_other_image1_yn = 21;
static int m_other_image2_yn = 22;
static int m_other_image3_yn = 23;
static int m_other_image4_yn = 24;
static int m_cat1_xx = 25;
static int m_cat2_xx = 26;
static int m_build_path_xx = 27;
static int m_shipping_url_xx = 28;
static int m_shipping_user_xx = 29;
static int m_shipping_password_xx = 30;

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




magento_settings(int what_item) {//****************************

	super("Magento Settings");
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



	export_php.setMargin(new Insets(0, 0, 0, 0));
  	export_php.addActionListener(this);
 	export_php.setPreferredSize(new Dimension(80, 20));
 	//export_php.setIcon(imx4); 
	export_php.setBackground(nm.st_gray1);
	export_php.setHorizontalTextPosition(JButton.CENTER);
 	export_php.setForeground(nm.blackx);
	export_php.setToolTipText("Export PHP files to the website.");

	build_db.setMargin(new Insets(0, 0, 0, 0));
  	build_db.addActionListener(this);
 	build_db.setPreferredSize(new Dimension(80, 20));
 	//build_db.setIcon(imx4); 
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

	info_header2_1.setPreferredSize(new Dimension(130, 20));
	info_header2_2.setPreferredSize(new Dimension(330, 20));

	magento_shipping_url_l.setPreferredSize(new Dimension(140, 20));
	magento_shipping_user_l.setPreferredSize(new Dimension(140, 20));
	magento_shipping_password_l.setPreferredSize(new Dimension(140, 20));

	magento_spacerx1.setPreferredSize(new Dimension(180, 20));
	magento_spacerx2.setPreferredSize(new Dimension(291, 20));
	magento_spacerx3.setPreferredSize(new Dimension(291, 20));



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


	picture_url_l.setPreferredSize(new Dimension(141, 20));
	picture_url_l.setBackground(nm.blackx);
	picture_url_l.setForeground(nm.blackx);


	ftp_user_l.setPreferredSize(new Dimension(255, 20));
	ftp_user_l.setBackground(nm.blackx);
	ftp_user_l.setForeground(nm.blackx);

	ftp_pass_l.setPreferredSize(new Dimension(255, 20));
	ftp_pass_l.setBackground(nm.blackx);
	ftp_pass_l.setForeground(nm.blackx);



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



	picture_other1_l.setPreferredSize(new Dimension(145, 20));
	picture_other2_l.setPreferredSize(new Dimension(145, 20));
	picture_other3_l.setPreferredSize(new Dimension(145, 20));
	picture_other4_l.setPreferredSize(new Dimension(145, 20));


	picture_other1 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][m_other_image1_xx][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][m_other_image1_xx][current_submit_item_here]);

		picture_other1.setSelectedIndex(ix1);

	} catch (Exception e) {}
	picture_other1.addActionListener(this);
	picture_other1.setPreferredSize(new Dimension(150, 20));
	picture_other1.setToolTipText("Set Match Type.");


	picture_other2 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][m_other_image2_xx][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][m_other_image2_xx][current_submit_item_here]);

		picture_other2.setSelectedIndex(ix1);

	} catch (Exception e) {}
	picture_other2.addActionListener(this);
	picture_other2.setPreferredSize(new Dimension(150, 20));
	picture_other2.setToolTipText("Set Match Type.");


	picture_other3 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][m_other_image3_xx][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][m_other_image3_xx][current_submit_item_here]);

		picture_other3.setSelectedIndex(ix1);

	} catch (Exception e) {}
	picture_other3.addActionListener(this);
	picture_other3.setPreferredSize(new Dimension(150, 20));
	picture_other3.setToolTipText("Set Match Type.");


	picture_other4 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][m_other_image4_xx][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][m_other_image4_xx][current_submit_item_here]);

		picture_other4.setSelectedIndex(ix1);

	} catch (Exception e) {}
	picture_other4.addActionListener(this);
	picture_other4.setPreferredSize(new Dimension(150, 20));
	picture_other4.setToolTipText("Set Match Type.");



//other images
	JPanel jpk1_0 = new JPanel();
	jpk1_0.setPreferredSize(new Dimension(350, 160));
	jpk1_0.setBackground(nm.st_gray1);
	jpk1_0.add(picture_url_l);      jpk1_0.add(picture_url);
	jpk1_0.add(picture_other1_xb);	jpk1_0.add(picture_other1_l);    jpk1_0.add(picture_other1);
	jpk1_0.add(picture_other2_xb);	jpk1_0.add(picture_other2_l);    jpk1_0.add(picture_other2);
	jpk1_0.add(picture_other3_xb);	jpk1_0.add(picture_other3_l);    jpk1_0.add(picture_other3);
	jpk1_0.add(picture_other4_xb);	jpk1_0.add(picture_other4_l);    jpk1_0.add(picture_other4);





//category

	cat1_l.setPreferredSize(new Dimension(171, 20));
	cat2_l.setPreferredSize(new Dimension(171, 20));


	cat1 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][m_cat1_xx][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][m_cat1_xx][current_submit_item_here]);

		cat1.setSelectedIndex(ix1);

	} catch (Exception e) {}
	cat1.addActionListener(this);
	cat1.setPreferredSize(new Dimension(150, 20));
	cat1.setToolTipText("Set Match Type.");



	cat2 = new JComboBox(nm.db_string);
	try {

		System.out.println(nm.carbon[5][m_cat2_xx][current_submit_item_here]);
		int ix1 = Integer.parseInt(nm.carbon[5][m_cat2_xx][current_submit_item_here]);

		cat2.setSelectedIndex(ix1);

	} catch (Exception e) {}
	cat2.addActionListener(this);
	cat2.setPreferredSize(new Dimension(150, 20));
	cat2.setToolTipText("Set Match Type.");





	JPanel jpk1_0b = new JPanel();
	jpk1_0b.setPreferredSize(new Dimension(400, 100));
	jpk1_0b.setBackground(nm.st_gray1);
	jpk1_0b.add(cat1_l);    jpk1_0b.add(cat1);
	jpk1_0b.add(cat2_l);   	jpk1_0b.add(cat2);


	JPanel jpkx1_1 = new JPanel();
	jpkx1_1.setPreferredSize(new Dimension(xzx -45, 50));
	jpkx1_1.setBackground(nm.st_gray1);
	jpkx1_1.add(build_path_l);
	jpkx1_1.add(build_path); 



	TitledBorder titled1 = BorderFactory.createTitledBorder("Export Settings");
	titled1.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_0x = new JPanel();
	jpk1_0x.setPreferredSize(new Dimension(xzx -25, 350));
	jpk1_0x.setBackground(nm.st_gray1);
	jpk1_0x.setBorder(titled1);
	jpk1_0x.add(jpk1_0);
	jpk1_0x.add(jpk1_0b);
	jpk1_0x.add(jpkx1_1);


	JPanel jpk1_d = new JPanel();
	jpk1_d.setPreferredSize(new Dimension(xzx -25, 200));
	jpk1_d.setBackground(nm.st_gray1);
	jpk1_d.add(scrollPaned);


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


	JPanel jpk1_c = new JPanel();
	jpk1_c.setPreferredSize(new Dimension(xzx -25, 290));
	jpk1_c.setBackground(nm.st_gray1);
	jpk1_c.add(infox2);
	jpk1_c.add(jpk1_1);


	JPanel jpk1_x = new JPanel();
	jpk1_x.setLayout(new FlowLayout());
	jpk1_x.setPreferredSize(new Dimension(xzx -25, 40));
	jpk1_x.setBackground(nm.st_gray1);
	jpk1_x.add(save_db);


	JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(xzx -25, 655));
	jpk1.setBackground(nm.whitex);
	jpk1.setBackground(nm.st_gray1);
	jpk1.add(jpk1_0x);
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

		System.out.println("Load");

		System.out.println("cb " + nm.carbon[5][m_other_image1_yn][current_submit_item_here]);
		System.out.println("cb " + nm.carbon[5][m_other_image2_yn][current_submit_item_here]);
		System.out.println("cb " + nm.carbon[5][m_other_image3_yn][current_submit_item_here]);
		System.out.println("cb " + nm.carbon[5][m_other_image4_yn][current_submit_item_here]);

		if(nm.carbon[5][m_other_image1_yn][current_submit_item_here] == "1"){picture_other1_xb.setSelected(true);}
		if(nm.carbon[5][m_other_image2_yn][current_submit_item_here] == "1"){picture_other2_xb.setSelected(true);}
		if(nm.carbon[5][m_other_image3_yn][current_submit_item_here] == "1"){picture_other3_xb.setSelected(true);}
		if(nm.carbon[5][m_other_image4_yn][current_submit_item_here] == "1"){picture_other4_xb.setSelected(true);}

		picture_url.setText(nm.carbon[5][host_set_url_xx][current_submit_item_here]);
	
		sales_days_past.setText(nm.carbon[5][sales_days_past_xx][current_submit_item_here]);

		if(nm.carbon[5][import_everything_xx][current_submit_item_here].equals("1")){import_everything.setSelected(true);}
		else{import_everything.setSelected(false);}

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

		build_path.setText(nm.carbon[5][m_build_path_xx][current_submit_item_here]);

		magento_shipping_url.setText(nm.carbon[5][m_shipping_url_xx][current_submit_item_here]);
		magento_shipping_user.setText(nm.carbon[5][m_shipping_user_xx][current_submit_item_here]);
		magento_shipping_password.setText(nm.carbon[5][m_shipping_password_xx][current_submit_item_here]);


	}//*******************





	public void savex_x(){


		System.out.println("Save");

		if (picture_other1_xb.isSelected()) {nm.carbon[5][m_other_image1_yn][current_submit_item_here] = "1";}
		else {nm.carbon[5][m_other_image1_yn][current_submit_item_here] = "0";}

		if (picture_other2_xb.isSelected()) {nm.carbon[5][m_other_image2_yn][current_submit_item_here] = "1";}
		else {nm.carbon[5][m_other_image2_yn][current_submit_item_here] = "0";}

		if (picture_other3_xb.isSelected()) {nm.carbon[5][m_other_image3_yn][current_submit_item_here] = "1";}
		else {nm.carbon[5][m_other_image3_yn][current_submit_item_here] = "0";}

		if (picture_other4_xb.isSelected()) {nm.carbon[5][m_other_image4_yn][current_submit_item_here] = "1";}
		else {nm.carbon[5][m_other_image4_yn][current_submit_item_here] = "0";}


		nm.carbon[5][host_set_url_xx][current_submit_item_here] = picture_url.getText();
		nm.carbon[5][sales_days_past_xx][current_submit_item_here] = sales_days_past.getText();


		if (import_everything.isSelected() == true) {nm.carbon[5][import_everything_xx][current_submit_item_here] = "1";}
		else {nm.carbon[5][import_everything_xx][current_submit_item_here] = "0";}


		nm.carbon[5][ship_change_quantity_xx][current_submit_item_here] = over_2_units_tf.getText();
		nm.carbon[5][ship_change_type_xx][current_submit_item_here] = switch_to_tf.getText();
		nm.carbon[5][ship_change_quantity_xx2][current_submit_item_here] = over_2_units_tf2.getText();
		nm.carbon[5][ship_change_type_xx2][current_submit_item_here] = switch_to_tf2.getText();
		nm.carbon[5][ship_weight_change_quantity_xx][current_submit_item_here] = over_2_weight_tf.getText();
		nm.carbon[5][ship_weight_change_type_xx][current_submit_item_here] = weight_switch_to_tf.getText();
		nm.carbon[5][ship_weight_change_quantity_xx2][current_submit_item_here] = over_2_weight_tf2.getText();
		nm.carbon[5][ship_weight_change_type_xx2][current_submit_item_here] = weight_switch_to_tf2.getText();
		nm.carbon[5][m_build_path_xx][current_submit_item_here] = build_path.getText();
		nm.carbon[5][m_shipping_url_xx][current_submit_item_here] = magento_shipping_url.getText();
		nm.carbon[5][m_shipping_user_xx][current_submit_item_here] = magento_shipping_user.getText();
		nm.carbon[5][m_shipping_password_xx][current_submit_item_here] = magento_shipping_password.getText();


		String[][] save_item = new String[nm.carbon[5].length][1];

		for (int xloop = 0; xloop < nm.carbon[5].length; xloop++) {//************

			save_item[xloop][0] = nm.carbon[5][xloop][current_submit_item_here];

		}//**********************************************************************

		
		jdb_edit_connection save = new jdb_edit_connection(save_item, Integer.toString(current_submit_item_here));


	}//savex













//handel all the button clicks. 
public void actionPerformed(ActionEvent event) {


	if (event.getSource() == save_db) {savex_x();}
	

	if (event.getSource() == in_this_field_cb) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < in_this_field_cb.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][ship_change_field_xx][current_submit_item_here] = Integer.toString(loop1);

			}//**************************************

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



	if (event.getSource() == picture_other1) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < picture_other1.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][m_other_image1_xx][current_submit_item_here] = Integer.toString(loop1);

			}//**************************************

		}//*********************

	}//not used



	if (event.getSource() == picture_other2) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < picture_other2.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][m_other_image2_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == picture_other3) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < picture_other3.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][m_other_image3_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == picture_other4) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < picture_other4.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][m_other_image4_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == cat1) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < cat1.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][m_cat1_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used



	if (event.getSource() == cat2) {

        JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < cat2.getItemCount(); loop1++) {//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				nm.carbon[5][m_cat2_xx][current_submit_item_here] = Integer.toString(loop1);

			}//***************************************

		}//*********************

	}//not used




}//actionPerformed










    public static void main(int what_item) {

		magento_settings xr = new magento_settings(what_item);

    }//main







}//last****************************************
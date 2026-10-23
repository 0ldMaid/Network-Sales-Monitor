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
import org.apache.commons.net.io.CopyStreamEvent;
import org.apache.commons.net.io.CopyStreamListener;
import org.apache.commons.net.util.TrustManagerUtils;





public class alchemy_export_shipping_system extends JFrame implements ActionListener{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 700;
int xzy = 700;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

Object newItem;
JComboBox cb;


String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;


JLabel header1 = new JLabel("Export Settings", JLabel.LEFT);
JLabel header2 = new JLabel("Import Settings", JLabel.LEFT);
JLabel header3 = new JLabel("Template Settings", JLabel.LEFT);
JLabel header4 = new JLabel("Shipping Settings", JLabel.LEFT);
JLabel header5 = new JLabel("Shipping Carrior Settings", JLabel.LEFT);

Label infoxs = new Label("", Label.LEFT);
JLabel infox0 = new JLabel("Store Settings:", JLabel.LEFT);
JLabel infox1 = new JLabel("Export Settings:", JLabel.LEFT);
JLabel infox2 = new JLabel("Import Settings:", JLabel.LEFT);


int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int stop = 0;
int post_number = 1;


JComboBox shipping_location = new JComboBox();
JComboBox shipping_type = new JComboBox();
JComboBox match_column = new JComboBox();
JComboBox match_type = new JComboBox();
JComboBox export_mail_type = new JComboBox();

String cxx0[] = new String[3];
String cxx1[] = new String[3];
String cxx2[] = new String[2];
String cxx3[] = new String[2];
String cxx4[] = new String[3];


Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color bluex2 = new Color(0.2f, 0.27f, 0.39f);
Color grayx1 = new Color(0.7f, 0.7f, 0.7f);
Color grayx2 = new Color(0.6f, 0.6f, 0.6f);


JLabel jlabel[] = new JLabel[100];
JTextField jtextf[] = new JTextField[100];

JTextArea jtexta[] = new JTextArea[1];



String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");



File st1;

int selected_int;

String settings[][] = new String[1][runs];
String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");



JTextField MerchantID = new JTextField("", 18);
JTextField MarketplaceID = new JTextField("", 12);
JTextField AWSAccessKeyID = new JTextField("", 12);
JTextField SecretKey = new JTextField("", 12);


Icon imx4;

JLabel not_international_l = new JLabel("If the sale is NOT international then use (MAIL TYPE) settings in this field: ", JLabel.LEFT);
JComboBox not_international_cb = new JComboBox();

JLabel info_header2_1 = new JLabel("Import ?? days past.", JLabel.RIGHT);
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



JLabel ftp_url_l = new JLabel("FTP URL", JLabel.LEFT);
JLabel ftp_folder_l = new JLabel("FTP Folder", JLabel.LEFT);
JLabel ftp_user_l = new JLabel("FTP User", JLabel.LEFT);
JLabel ftp_pass_l = new JLabel("FTP Password", JLabel.LEFT);

JTextField ftp_url = new JTextField("", 18);
JTextField ftp_folder = new JTextField("", 18);
JTextField ftp_user = new JTextField("", 18);
JTextField ftp_pass = new JTextField("", 18);





JButton export_php = new JButton("Export");
JButton build_db = new JButton("Build DB");

String strUser = new String();
String strPassword = new String();
String strServer = new String();
String strRemoteName = new String();

String strLocalName = new String();






JLabel alchemy_shipping_settings_l = new JLabel("Shipping Carrier POST: ", JLabel.LEFT);
JTextField alchemy_shipping_settings = new JTextField("", 15);


JLabel store_category1_l = new JLabel("Store Category 1 ", JLabel.LEFT);
JTextField store_category1 = new JTextField("category3", 13);

JLabel store_category2_l = new JLabel("Store Category 1 ", JLabel.LEFT);
JTextField store_category2 = new JTextField("category3", 13);

JLabel store_category3_l = new JLabel("Store Category 1 ", JLabel.LEFT);
JTextField store_category3 = new JTextField("category3", 13);











alchemy_export_shipping_system(){//****************************

	super("Marketplace 2 Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex_x(); nm.firex = 1;}});





//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);



	stop = 0;
	csv_int = 0;
	thisc3 = 0;

	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));





	export_php.setMargin(new Insets(0, 0, 0, 0));
  	export_php.addActionListener(this);
 	export_php.setPreferredSize(new Dimension(80, 20));
 	export_php.setIcon(imx4);
	export_php.setBackground(nm.st_gray1); 
	export_php.setHorizontalTextPosition(JButton.CENTER);
 	export_php.setForeground(blackx);
	export_php.setToolTipText("Export PHP files to the website.");

	build_db.setMargin(new Insets(0, 0, 0, 0));
  	build_db.addActionListener(this);
 	build_db.setPreferredSize(new Dimension(80, 20));
 	build_db.setIcon(imx4); 
	build_db.setBackground(nm.st_gray1);
	build_db.setHorizontalTextPosition(JButton.CENTER);
 	build_db.setForeground(blackx);
	build_db.setToolTipText("Install DB Tables.");





	ix0 = 120;
	ix1 = 20;



	jtexta[0] = new JTextArea("", 10, 40);
	jtexta[0].setWrapStyleWord(true);
	jtexta[0].setLineWrap(true);
	jtexta[0].setWrapStyleWord(true);

	JScrollPane scrollPaned = new JScrollPane(jtexta[0]);
	scrollPaned.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPaned.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPaned.setFont(new Font("Arial", Font.PLAIN, 14));

	FlowLayout flow = new FlowLayout(0);
	flow.setHgap(0);
	flow.setVgap(0);



	header1.setPreferredSize(new Dimension(660, 20));
	header2.setPreferredSize(new Dimension(660, 20));
	header3.setPreferredSize(new Dimension(660, 20));
	header4.setPreferredSize(new Dimension(660, 20));
	header5.setPreferredSize(new Dimension(660, 20));

	info_header2_1.setPreferredSize(new Dimension(130, 20));
	info_header2_2.setPreferredSize(new Dimension(290, 20));



	try{

		System.out.println(nm.carbon[4][nm.match_type_xx][nm.current_submit_item_a]);
		ix0 = Integer.parseInt(nm.carbon[4][nm.match_type_xx][nm.current_submit_item_a]);

	}catch(Exception e){ix0 = 1;}

	match_type = new JComboBox(nm.amazon_match_type);
	//match_type.setSelectedIndex(ix0);
	match_type.addActionListener(this);
	match_type.setPreferredSize(new Dimension(150, 20));
	match_type.setToolTipText("Set Match Type.");



	try{

		System.out.println(nm.carbon[4][nm.match_column_xx][nm.current_submit_item_a]);
		ix1 = Integer.parseInt(nm.carbon[4][nm.match_column_xx][nm.current_submit_item_a]);

	}catch(Exception e){ix1 = 1;}

	match_column = new JComboBox(nm.db_string);
	//match_column.setSelectedIndex(ix1);
	match_column.addActionListener(this);
	match_column.setPreferredSize(new Dimension(150, 20));
	match_column.setToolTipText("Set Match Info Location.");








	try{

		System.out.println(nm.carbon[5][nm.ship_change_field_xx][nm.current_submit_item_a]);
		ix1 = Integer.parseInt(nm.carbon[5][nm.ship_change_field_xx][nm.current_submit_item_a]);

	}catch(Exception e){ix1 = 1;}

	in_this_field_cb = new JComboBox(nm.db_string);
	in_this_field_cb.setSelectedIndex(ix1);
	in_this_field_cb.addActionListener(this);
	in_this_field_cb.setPreferredSize(new Dimension(150, 20));
	in_this_field_cb.setToolTipText("Set Match Type.");


	try{

		System.out.println(nm.carbon[5][nm.ship_change_field_xx2][nm.current_submit_item_a]);
		ix1 = Integer.parseInt(nm.carbon[5][nm.ship_change_field_xx2][nm.current_submit_item_a]);

	}catch(Exception e){ix1 = 1;}

	in_this_field_cb2 = new JComboBox(nm.db_string);
	in_this_field_cb2.setSelectedIndex(ix1);
	in_this_field_cb2.addActionListener(this);
	in_this_field_cb2.setPreferredSize(new Dimension(150, 20));
	in_this_field_cb2.setToolTipText("Set Match Type.");








	try{

		System.out.println(nm.carbon[5][nm.ship_weight_change_field_xx][nm.current_submit_item_a]);
		ix1 = Integer.parseInt(nm.carbon[5][nm.ship_weight_change_field_xx][nm.current_submit_item_a]);

	}catch(Exception e){ix1 = 1;}

	weight_in_this_field_cb = new JComboBox(nm.db_string);
	weight_in_this_field_cb.setSelectedIndex(ix1);
	weight_in_this_field_cb.addActionListener(this);
	weight_in_this_field_cb.setPreferredSize(new Dimension(150, 20));
	weight_in_this_field_cb.setToolTipText("Set Match Type.");


	try{

		System.out.println(nm.carbon[5][nm.ship_weight_change_field_xx2][nm.current_submit_item_a]);
		ix1 = Integer.parseInt(nm.carbon[5][nm.ship_weight_change_field_xx2][nm.current_submit_item_a]);

	}catch(Exception e){ix1 = 1;}

	weight_in_this_field_cb2 = new JComboBox(nm.db_string);
	weight_in_this_field_cb2.setSelectedIndex(ix1);
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






	
	ftp_url_l.setPreferredSize(new Dimension(255, 20));
	ftp_url_l.setBackground(blackx);
	ftp_url_l.setForeground(blackx);

	ftp_folder_l.setPreferredSize(new Dimension(255, 20));
	ftp_folder_l.setBackground(blackx);
	ftp_folder_l.setForeground(blackx);

	ftp_user_l.setPreferredSize(new Dimension(255, 20));
	ftp_user_l.setBackground(blackx);
	ftp_user_l.setForeground(blackx);

	ftp_pass_l.setPreferredSize(new Dimension(255, 20));
	ftp_pass_l.setBackground(blackx);
	ftp_pass_l.setForeground(blackx);



	infoxs.setPreferredSize(new Dimension(xzx -40, 20));
	infoxs.setBackground(blackx);
	infoxs.setForeground(whitex);

	infox0.setPreferredSize(new Dimension(xzx -30, 20));
	infox0.setBackground(blackx);
	infox0.setForeground(blackx);

	infox1.setPreferredSize(new Dimension(xzx -30, 20));
	infox1.setBackground(blackx);
	infox1.setForeground(blackx);

	infox2.setPreferredSize(new Dimension(xzx -30, 20));
	infox2.setBackground(blackx);
	infox2.setForeground(blackx);














	JPanel jpk1_0 = new JPanel();
	jpk1_0.setPreferredSize(new Dimension(500, 110));
	jpk1_0.setBackground(grayx2);
	jpk1_0.add(ftp_url_l);    jpk1_0.add(ftp_url);
	jpk1_0.add(ftp_folder_l); jpk1_0.add(ftp_folder);
	jpk1_0.add(ftp_user_l);	  jpk1_0.add(ftp_user);
	jpk1_0.add(ftp_pass_l);	  jpk1_0.add(ftp_pass);

	JPanel jpk1_0b = new JPanel();
	jpk1_0b.setPreferredSize(new Dimension(100, 110));
	jpk1_0b.setBackground(grayx2);
	jpk1_0b.add(export_php);
	jpk1_0b.add(build_db);



	JPanel jpk1_0x = new JPanel();
	jpk1_0x.setPreferredSize(new Dimension(xzx -25, 150));
	jpk1_0x.setBackground(grayx1);
	jpk1_0x.add(infox0);
	jpk1_0x.add(jpk1_0);
	jpk1_0x.add(jpk1_0b);





	JPanel jpk1_d = new JPanel();
	jpk1_d.setPreferredSize(new Dimension(xzx -25, 200));
	jpk1_d.setBackground(grayx1);
	jpk1_d.add(scrollPaned);










	JPanel jpk1_p0 = new JPanel();
	jpk1_p0.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p0.setBackground(grayx2);
	jpk1_p0.add(info_header2_1); jpk1_p0.add(sales_days_past);
	jpk1_p0.add(info_header2_2); jpk1_p0.add(import_everything);



	JPanel jpk1_p1 = new JPanel();
	jpk1_p1.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p1.setBackground(grayx2);
 	jpk1_p1.add(over_2_weight_l);        jpk1_p1.add(over_2_weight_tf);
	jpk1_p1.add(weight_switch_to_l);     jpk1_p1.add(weight_switch_to_tf);
	jpk1_p1.add(weight_in_this_field_l); jpk1_p1.add(weight_in_this_field_cb);

	JPanel jpk1_p2 = new JPanel();
	jpk1_p2.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p2.setBackground(grayx2);
 	jpk1_p2.add(over_2_weight_l2);        jpk1_p2.add(over_2_weight_tf2);
	jpk1_p2.add(weight_switch_to_l2);     jpk1_p2.add(weight_switch_to_tf2);
	jpk1_p2.add(weight_in_this_field_l2); jpk1_p2.add(weight_in_this_field_cb2);




	JPanel jpk1_p3 = new JPanel();
	jpk1_p3.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p3.setBackground(grayx2);
 	jpk1_p3.add(over_2_units_l);  jpk1_p3.add(over_2_units_tf);
	jpk1_p3.add(switch_to_l);     jpk1_p3.add(switch_to_tf);
	jpk1_p3.add(in_this_field_l); jpk1_p3.add(in_this_field_cb);

	JPanel jpk1_p4 = new JPanel();
	jpk1_p4.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_p4.setBackground(grayx2);
 	jpk1_p4.add(over_2_units_l2);  jpk1_p4.add(over_2_units_tf2);
	jpk1_p4.add(switch_to_l2);     jpk1_p4.add(switch_to_tf2);
	jpk1_p4.add(in_this_field_l2); jpk1_p4.add(in_this_field_cb2);



	JPanel jpk1_1 = new JPanel();
	jpk1_1.setPreferredSize(new Dimension(xzx -25, 230));
	jpk1_1.setBackground(grayx1);
	//jpk1_1.add(header2);
	jpk1_1.add(jpk1_p0);
	jpk1_1.add(jpk1_p1);
	jpk1_1.add(jpk1_p2);
	jpk1_1.add(jpk1_p3);
	jpk1_1.add(jpk1_p4);
	//jpk1_1.add(jpk1_p5);







	JPanel jpk1_x = new JPanel();
	jpk1_x.setPreferredSize(new Dimension(xzx -25, 200));
	jpk1_x.setBackground(grayx1);
	jpk1_x.add(infox1);





	JPanel jpk1_c = new JPanel();
	jpk1_c.setPreferredSize(new Dimension(xzx -25, 300));
	jpk1_c.setBackground(grayx1);
	jpk1_c.add(infox2);
	jpk1_c.add(jpk1_1);









	JPanel jpk1_cx1 = new JPanel();
	jpk1_cx1.setPreferredSize(new Dimension(xzx -50, 40));
	jpk1_cx1.setBackground(grayx2);
	jpk1_cx1.add(alchemy_shipping_settings_l);	jpk1_cx1.add(alchemy_shipping_settings);


	JPanel jpk2_x = new JPanel();
	jpk2_x.setPreferredSize(new Dimension(xzx -25, 300));
	jpk2_x.setBackground(grayx1);
	jpk2_x.add(header4);
	jpk2_x.add(jpk1_cx1);

	JPanel jpk2_y = new JPanel();
	jpk2_y.setPreferredSize(new Dimension(xzx -25, 100));
	jpk2_y.setBackground(grayx1);
	jpk2_y.add(header5);
	jpk2_y.add(header5);
	jpk2_y.add(header5);




	JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(xzx -25, 700));
	jpk1.setBackground(whitex);
	jpk1.setBackground(grayx2);
	jpk1.add(jpk1_0x);
	jpk1.add(jpk1_x);
	jpk1.add(jpk1_c);
	jpk1.add(jpk2_x);
	jpk1.add(jpk2_y);





	JScrollPane scrollPane = new JScrollPane(jpk1);
	scrollPane.setPreferredSize(new Dimension(xzx -5, xzy -70));
	//scrollPane.setBackground(bluex2);
	scrollPane.setFont(new Font("Arial", Font.PLAIN, 14));


	JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(xzx, 50));
	jpk2.setBackground(nm.st_gray1);
	//jpk2.add(infoxs);



	Container cpx = getContentPane();
	cpx.setLayout(flow);
	cpx.setBackground(nm.program_gray_2);
	cpx.setForeground(whitex);
	cpx.add(scrollPane);
	cpx.add(jpk2);


	setVisible(true);







	requestFocus();

	loadx_x();

}//csv_loader_x1********************************************************












	public void loadx_x(){


		ftp_url.setText(nm.carbon[5][nm.ftp_set_url_xxal][nm.current_submit_item_a]);
		ftp_folder.setText(nm.carbon[5][nm.ftp_set_folder_xxal][nm.current_submit_item_a]);
		ftp_user.setText(nm.carbon[5][nm.ftp_set_user_xxal][nm.current_submit_item_a]); 
		ftp_pass.setText(nm.carbon[5][nm.ftp_set_pass_xxal][nm.current_submit_item_a]); 



		if(nm.carbon[5][nm.import_everything_xx][nm.current_submit_item_a].equals("1")){import_everything.setSelected(true);}
		else{import_everything.setSelected(false);}


		over_2_units_tf.setText(nm.carbon[5][nm.ship_change_quantity_xx][nm.current_submit_item_a]);
		switch_to_tf.setText(nm.carbon[5][nm.ship_change_type_xx][nm.current_submit_item_a]);
		//paypal_email.setText(nm.carbon[5][nm.ship_change_field_xx][nm.current_submit_item_a]);

		over_2_units_tf2.setText(nm.carbon[5][nm.ship_change_quantity_xx2][nm.current_submit_item_a]);
		switch_to_tf2.setText(nm.carbon[5][nm.ship_change_type_xx2][nm.current_submit_item_a]);
		//paypal_email.setText(nm.carbon[5][nm.ship_change_field_xx][nm.current_submit_item_a]);


		over_2_weight_tf.setText(nm.carbon[5][nm.ship_weight_change_quantity_xx][nm.current_submit_item_a]);
		weight_switch_to_tf.setText(nm.carbon[5][nm.ship_weight_change_type_xx][nm.current_submit_item_a]);

		over_2_weight_tf2.setText(nm.carbon[5][nm.ship_weight_change_quantity_xx2][nm.current_submit_item_a]);
		weight_switch_to_tf2.setText(nm.carbon[5][nm.ship_weight_change_type_xx2][nm.current_submit_item_a]);


		sales_days_past.setText(nm.carbon[5][nm.sales_days_past_xx][nm.current_submit_item_a]);

		alchemy_shipping_settings.setText(nm.carbon[5][nm.alchemist_shipping_type_xx][nm.current_submit_item_a]);


	}//*******************





	public void savex_x(){



		nm.carbon[5][nm.ftp_set_url_xxal][nm.current_submit_item_a] = ftp_url.getText();
		nm.carbon[5][nm.ftp_set_folder_xxal][nm.current_submit_item_a] = ftp_folder.getText();
		nm.carbon[5][nm.ftp_set_user_xxal][nm.current_submit_item_a] = ftp_user.getText();
		nm.carbon[5][nm.ftp_set_pass_xxal][nm.current_submit_item_a] = ftp_pass.getText();




		nm.carbon[0][nm.item_description_xx][selected_int] = jtexta[0].getText().replace("\r\n", " ").replace("\n", " ");
		cx0 = nm.carbon[0][nm.item_description_xx][selected_int];
		System.out.println(cx0);




		if(import_everything.isSelected() == true){nm.carbon[5][nm.import_everything_xx][nm.current_submit_item_a] = "1";}
		else{nm.carbon[5][nm.import_everything_xx][nm.current_submit_item_a] = "0";}


		nm.carbon[5][nm.ship_change_quantity_xx][nm.current_submit_item_a] = over_2_units_tf.getText();
		nm.carbon[5][nm.ship_change_type_xx][nm.current_submit_item_a] = switch_to_tf.getText();

		nm.carbon[5][nm.ship_change_quantity_xx2][nm.current_submit_item_a] = over_2_units_tf2.getText();
		nm.carbon[5][nm.ship_change_type_xx2][nm.current_submit_item_a] = switch_to_tf2.getText();

		nm.carbon[5][nm.ship_weight_change_quantity_xx][nm.current_submit_item_a] = over_2_weight_tf.getText();
		nm.carbon[5][nm.ship_weight_change_type_xx][nm.current_submit_item_a] = weight_switch_to_tf.getText();

		nm.carbon[5][nm.ship_weight_change_quantity_xx2][nm.current_submit_item_a] = over_2_weight_tf2.getText();
		nm.carbon[5][nm.ship_weight_change_type_xx2][nm.current_submit_item_a] = weight_switch_to_tf2.getText();


		nm.carbon[5][nm.sales_days_past_xx][nm.current_submit_item_a] = sales_days_past.getText();



		nm.carbon[5][nm.alchemist_shipping_type_xx][nm.current_submit_item_a] = alchemy_shipping_settings.getText();

	}//savex






















	public void ftp_upload_build(){

		System.out.println("FTP START");

	 
		String[] website_list = new String[71];

		website_list[0] = new String("AC_RunActiveContent.js");
		website_list[1] = new String("dbx_custom_postback.php");
		website_list[2] = new String("dbx_delete_db_archived.php");
		website_list[3] = new String("dbx_delete_db_listings.php");
		website_list[4] = new String("dbx_delete_db_messages.php");
		website_list[5] = new String("dbx_delete_db_settings.php");
		website_list[6] = new String("dbx_delete_item.php");
		website_list[7] = new String("dbx_export_items.php");
		website_list[8] = new String("dbx_export_messages.php");
		website_list[9] = new String("dbx_export_sales.php");
		website_list[10] = new String("dbx_export_stats.php");
		website_list[11] = new String("dbx_import_items.php");
		website_list[12] = new String("dbx_import_sales.php");
		website_list[13] = new String("dbx_import_settings.php");
		website_list[14] = new String("dbx_install_db2.php");
		website_list[15] = new String("dbx_item.php");
		website_list[16] = new String("dbx_messages_add.php");
		website_list[17] = new String("dbx_monitor_info.php");
		website_list[18] = new String("dbx_paypal_api.php");
		website_list[19] = new String("dbx_paypal_api_cancel");
		website_list[20] = new String("dbx_paypal_api_confirm");
		website_list[21] = new String("dbx_paypal_expresscheckout");
		website_list[22] = new String("dbx_paypal_paypalfunctions paypal.php");
		website_list[23] = new String("dbx_paypal_paypalfunctions.php");
		website_list[24] = new String("dbx_security.php");
		website_list[25] = new String("dbx_send_email.php");
		website_list[26] = new String("dbx_settings.php");
		website_list[27] = new String("dbx_test.php");
		website_list[28] = new String("favicon.ico");
		website_list[29] = new String("global.css");
		website_list[30] = new String("index.php");
		website_list[31] = new String("jquery.js");
		website_list[32] = new String("site_contact.php");
		website_list[33] = new String("site_ebay.php");
		website_list[34] = new String("site_info.php");
		website_list[35] = new String("site_item.php");
		website_list[36] = new String("site_links.php");
		website_list[37] = new String("site_search_results.php");
		website_list[38] = new String("site_sitemap.php");

		website_list[39] = new String("inventory_system/dbx_security.php");
		website_list[40] = new String("inventory_system/favicon.ico");
		website_list[41] = new String("inventory_system/index.php");
		website_list[42] = new String("inventory_system/site_change_status_quantity.php");

		website_list[43] = new String("shipping_system/dbx_security.php");
		website_list[44] = new String("shipping_system/dbx_settings.php");
		website_list[45] = new String("shipping_system/favicon.ico");
		website_list[46] = new String("shipping_system/index.php");
		website_list[47] = new String("shipping_system/index_unshipped.php");
		website_list[48] = new String("shipping_system/php_ftp.php");
		website_list[49] = new String("shipping_system/shipped_postback.php");
		website_list[50] = new String("shipping_system/shipped_postback2.php");
		website_list[51] = new String("shipping_system/site_add_item.php");
		website_list[52] = new String("shipping_system/site_add_item_api.php");
		website_list[53] = new String("shipping_system/site_change_status_delete.php");
		website_list[54] = new String("shipping_system/site_change_status_notes.php");
		website_list[55] = new String("shipping_system/site_change_status_notshipped.php");
		website_list[56] = new String("shipping_system/site_change_status_shipped.php");
		website_list[57] = new String("shipping_system/site_csv_sales.php");

		website_list[58] = new String("order_system/index.php");
		website_list[59] = new String("order_system/favicon.ico");

		website_list[60] = new String("images/btn_xpressCheckout.gif");
		website_list[61] = new String("images/btn_xpressCheckout_x.gif");
		website_list[62] = new String("images/CheckoutByAmazon.gif");
		website_list[63] = new String("images/CheckoutByAmazon.png");
		website_list[64] = new String("images/CheckoutByAmazon_x.gif");
		website_list[65] = new String("images/google_checkout.jpg");
		website_list[66] = new String("images/google_checkout_button.gif");
		website_list[67] = new String("images/google_checkout_button_x.gif");
		website_list[68] = new String("images/GoogleCheckout.gif");
		website_list[69] = new String("images/payment_logo.gif");
		website_list[70] = new String("images/paypal-gray.png");





		infoxs.setText("Make Folders...");

		System.out.println("UPLOAD FTP");

		try{

			FTPClient ftp = new FTPClient();

			cx0 = (ftp_url.getText());

			System.out.println("START1 " + cx0);
			ftp.connect(cx0);
			System.out.println("START2");
		    ftp.login(ftp_user.getText(), ftp_pass.getText());
			System.out.println("START3");
			ftp.makeDirectory(ftp_folder.getText() + "/images");
			ftp.makeDirectory(ftp_folder.getText() + "/inventory_system");
			ftp.makeDirectory(ftp_folder.getText() + "/shipping_system");
			ftp.makeDirectory(ftp_folder.getText() + "/order_system");
			ftp.makeDirectory(ftp_folder.getText() + "/shipping_system/labels");
			ftp.logout();
			System.out.println("DONE");

		}catch(Exception e){System.out.println("FTP Failed");}



		infoxs.setText("Make Folders... Done.");






		for(int xloop = 0; xloop < website_list.length; xloop++){//******
		
			try{

				System.out.println("START");
				infoxs.setText("Uploading: " + website_list[xloop] + " (" + Integer.toString(xloop + 1) + " of " + Integer.toString(website_list.length) + ")");

				strServer = ftp_url.getText() + ftp_folder.getText();
				strRemoteName = website_list[xloop];
				strUser = ftp_user.getText();
				strPassword = ftp_pass.getText();

				System.out.println(strServer);
				System.out.println(strRemoteName);
				System.out.println(strUser);
				System.out.println(strPassword);

				String strUrl = new String("ftp://"+strUser+":"+strPassword+"@"+strServer+strRemoteName);
		
				//infox0.setText(strUrl);
				System.out.println(strUrl);

				URI uri = new URI(strUrl);

				URL url = uri.toURL();


				URLConnection con = url.openConnection();
				BufferedOutputStream out = new BufferedOutputStream(con.getOutputStream());
				 

				//infox0.setText("GET FILE");


				InputStream in = nm.class.getResourceAsStream("alchemy_webshop\\" + website_list[xloop]);
	 
				//infox0.setText("UPLOAD FILE");

				int i = 0;
				byte[] bytesIn = new byte[1024];
				while ((i = in.read(bytesIn)) >= 0){

					out.write(bytesIn, 0, i);

				}

				System.out.println("CLOSE");
				out.close();
				in.close();
				System.out.println("DONE");

	 
			}catch (Exception exc){System.out.println(exc.getMessage()); infox0.setText("FTP PHP Settings: " + exc.getMessage());}

		}//*********************************************************************


		infoxs.setText("Uploading DONE.");


	}//***************last









	public void build_db_x(){

		infox0.setText("FTP PHP Setting: Build_DB...");

		try {//*******************************************************



		           data = URLEncoder.encode("user", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[5][2][nm.current_submit_item_a], "UTF-8");
		    data += "&" + URLEncoder.encode("password", "UTF-8")   + "=" + URLEncoder.encode(nm.carbon[5][3][nm.current_submit_item_a], "UTF-8");
		    data += "&" + URLEncoder.encode("key", "UTF-8")    + "=" + URLEncoder.encode(nm.carbon[5][3][nm.current_submit_item_a], "UTF-8");


		    // Send data
		    System.out.println("Build DB @: " + nm.carbon[5][1][nm.current_submit_item_a] + "/dbx_install_db2.php");
		    url = new URL(nm.carbon[5][1][nm.current_submit_item_a] + "/dbx_install_db2.php");
		    conn = url.openConnection();
		    conn.setDoOutput(true);
		    wr = new OutputStreamWriter(conn.getOutputStream());
		    wr.write(data);
		    wr.flush();

		    // Get the response
		    rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		    String line;
		    while ((line = rd.readLine()) != null) {

		        if(line.contains("Connected successfully<br>Finished_")){infox0.setText("FTP PHP Setting: " + "Build Done.");}
				else{infox0.setText("FTP PHP Setting: " + "Login Failed.");}
				System.out.println(line);

		    }
		    wr.close();
		    rd.close();

		} catch (Exception e){System.out.println("URL falure."); infox0.setText("FTP PHP Setting: URL falure.");}





	}//**********************










//handel all the button clicks. 
public void actionPerformed(ActionEvent event){



	if(event.getSource() == export_php){ftp_upload_build();}
	if(event.getSource() == build_db){build_db_x();}





	if(event.getSource() == match_column){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < match_column.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[5][nm.match_column_xx][nm.current_submit_item_a] = Integer.toString(loop1); System.out.println(loop1);}

		}//*********************

	}//not used



	if(event.getSource() == match_type){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < match_type.getItemCount(); loop1++){//s1x

			if(nm.amazon_match_type[loop1].equals(newItem)){nm.carbon[5][nm.match_type_xx][nm.current_submit_item_a] = Integer.toString(loop1); System.out.println(loop1);}

		}//*********************

	}//not used



	if(event.getSource() == shipping_type){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < shipping_type.getItemCount(); loop1++){//s1x

			if(cxx1[loop1].equals(newItem)){nm.carbon[5][nm.shipping_type_xx][nm.current_submit_item_a] = Integer.toString(loop1); System.out.println(loop1);}

		}//*********************

	}//not used



	if(event.getSource() == shipping_location){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < shipping_location.getItemCount(); loop1++){//s1x

			if(cxx2[loop1].equals(newItem)){nm.carbon[5][nm.shipping_location_xx][nm.current_submit_item_a] = Integer.toString(loop1); System.out.println(loop1);}

		}//*********************

	}//not used





	if(event.getSource() == in_this_field_cb){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < in_this_field_cb.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[5][nm.ship_change_field_xx][nm.current_submit_item_a] = Integer.toString(loop1);}

		}//*********************

	}//not used

	if(event.getSource() == in_this_field_cb2){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < in_this_field_cb2.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[5][nm.ship_change_field_xx2][nm.current_submit_item_a] = Integer.toString(loop1);}

		}//*********************

	}//not used









	if(event.getSource() == weight_in_this_field_cb){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < weight_in_this_field_cb.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[5][nm.ship_weight_change_field_xx][nm.current_submit_item_a] = Integer.toString(loop1);}

		}//*********************

	}//not used

	if(event.getSource() == weight_in_this_field_cb2){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < weight_in_this_field_cb2.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[5][nm.ship_weight_change_field_xx2][nm.current_submit_item_a] = Integer.toString(loop1);}

		}//*********************

	}//not used












	if(event.getSource() == not_international_cb){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < not_international_cb.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[5][nm.ship_not_international_xx][nm.current_submit_item_a] = Integer.toString(loop1);}

		}//*********************

	}//not used






	if(event.getSource() == export_mail_type){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < export_mail_type.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[5][nm.export_mail_type_xx][nm.current_submit_item_a] = Integer.toString(loop1);}

		}//*********************
		
	}//not used






}//actionPerformed














    public static void main(){

		alchemy_export_shipping_system xr = new alchemy_export_shipping_system();

    }//main










}//last****************************************
import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.border.*;
import com.ebay.sdk.*;
import com.ebay.sdk.pictureservice.*;
import com.ebay.sdk.pictureservice.eps.*;
import com.ebay.soap.eBLBaseComponents.*;

import java.math.BigDecimal;

import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;

import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import java.util.Calendar;
import java.text.SimpleDateFormat;


import java.sql.*;





public class alchemy_shipping_settings extends JFrame implements ActionListener{


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

String data2;
URL url2;
OutputStreamWriter wr2;
BufferedReader rd2;
URLConnection conn2;



JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infoxq = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox2 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox3 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox4 = new JLabel("Loading...", JLabel.LEFT);
Label infox5 = new Label("Loading...", Label.LEFT);

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int kcountxx = 0;
int kcountxx2 = 0;
int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int stop = 0;
int post_number = 1;
int db_items = 0;
int carbon_items; 
int running = 0;
int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0;
int ix6 = 0;
int ix1x = 0;
int ix0x = 0;
int cb_edit = 0;
int websites = 50;
int HTMLINT = 0;
int looppx = 0;

Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");

String[] cxx0 = new String[1];

File st1;

String carbonfiber = new String();
String[][] silver = new String[1][1];
String[][] silverx = new String[1][1];
String xgetx[] = new String[10000];
String xlinex = new String("");
String blank = new String("");
String HTMLGO = new String("");
String new_db = new String("");
String new_db_number = new String("");



File file_open_0 = new File("ALCHEMIST_DBX2.CSV");
File file_open_1 = new File("ALCHEMIST_DBX.CSV");

int current_submit_item_xx = -1;



JLabel warehouse_url_l = new JLabel("Site URL", JLabel.LEFT);
JLabel warehouse_password_l = new JLabel("Password", JLabel.LEFT);


JTextField warehouse_url = new JTextField("", 20);
JTextField warehouse_password = new JTextField("", 20);
JTextField sql_user = new JTextField("", 15);
JTextField sql_pass = new JTextField("", 14);
JTextField sql_db = new JTextField("", 30);




JLabel ss_min_l = new JLabel("Shipping Minimum", JLabel.LEFT);
JLabel ss_1_l = new JLabel("Shipping 1lbs", JLabel.LEFT);
JLabel ss_2_l = new JLabel("Shipping 2lbs", JLabel.LEFT);
JLabel ss_3_l = new JLabel("Shipping 3lbs", JLabel.LEFT);
JLabel ss_4_l = new JLabel("Shipping 4lbs", JLabel.LEFT);
JLabel ss_5_l = new JLabel("Shipping 5lbs", JLabel.LEFT);
JLabel ss_6_l = new JLabel("Shipping 6lbs", JLabel.LEFT);
JLabel ss_7_l = new JLabel("Shipping 7lbs", JLabel.LEFT);
JLabel ss_8_l = new JLabel("Shipping 8lbs", JLabel.LEFT);
JLabel ss_9_l = new JLabel("Shipping 9lbs", JLabel.LEFT);
JLabel ss_max_l = new JLabel("Shipping > 9lbs", JLabel.LEFT);

JTextField ss_min = new JTextField("", 5);
JTextField ss_1 = new JTextField("", 5);
JTextField ss_2 = new JTextField("", 5);
JTextField ss_3 = new JTextField("", 5);
JTextField ss_4 = new JTextField("", 5);
JTextField ss_5 = new JTextField("", 5);
JTextField ss_6 = new JTextField("", 5);
JTextField ss_7 = new JTextField("", 5);
JTextField ss_8 = new JTextField("", 5);
JTextField ss_9 = new JTextField("", 5);
JTextField ss_max = new JTextField("", 5);




JComboBox jdb_db; 

String jdb_db_options[] = new String[1];

JButton save_b = new JButton("Save");
JButton test_b = new JButton("Test");

JButton load_a = new JButton("Load");
JButton save_a = new JButton("Save");
JButton delete_a = new JButton("Delete");


Icon imx4;







alchemy_shipping_settings(){//********************************************************************************************

	super("Shipping Rates Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){nm.firex = 1; running = 0;}});


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));



	infoxs.setPreferredSize(new Dimension(320, 25));
	infoxs.setText("Warehouse Site Settings");
	infoxs.setForeground(whitex);
	infoxs.setOpaque(true); 
	infoxs.setBackground(blackx);


	ss_min_l.setPreferredSize(new Dimension(220, 25));
	ss_min_l.setForeground(blackx);

	ss_1_l.setPreferredSize(new Dimension(220, 25));
	ss_1_l.setForeground(blackx);

	ss_2_l.setPreferredSize(new Dimension(220, 25));
	ss_2_l.setForeground(blackx);

	ss_3_l.setPreferredSize(new Dimension(220, 25));
	ss_3_l.setForeground(blackx);

	ss_4_l.setPreferredSize(new Dimension(220, 25));
	ss_4_l.setForeground(blackx);

	ss_5_l.setPreferredSize(new Dimension(220, 25));
	ss_5_l.setForeground(blackx);

	ss_6_l.setPreferredSize(new Dimension(220, 25));
	ss_6_l.setForeground(blackx);

	ss_7_l.setPreferredSize(new Dimension(220, 25));
	ss_7_l.setForeground(blackx);

	ss_8_l.setPreferredSize(new Dimension(220, 25));
	ss_8_l.setForeground(blackx);

	ss_9_l.setPreferredSize(new Dimension(220, 25));
	ss_9_l.setForeground(blackx);

	ss_max_l.setPreferredSize(new Dimension(220, 25));
	ss_max_l.setForeground(blackx);





	save_b.setMargin(new Insets(0, 0, 0, 0));
  	save_b.addActionListener(this);
	save_b.setPreferredSize(new Dimension(155, 20));
	save_b.setHorizontalTextPosition(JButton.CENTER);
	save_b.setBackground(nm.program_gray_1);
 	save_b.setForeground(blackx);







	test_b.setEnabled(false);
	save_b.setEnabled(true);



	warehouse_url_l.setPreferredSize(new Dimension(80, 20));
	warehouse_password_l.setPreferredSize(new Dimension(80, 20));
	warehouse_url_l.setForeground(whitex);
	warehouse_password_l.setForeground(whitex);




	warehouse_url.setText(nm.carbon[4][0][40]);
	warehouse_password.setText(nm.carbon[4][0][41]);



	JPanel bkp = new JPanel();
	bkp.setPreferredSize(new Dimension(340, 340));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(nm.program_gray_1);
	bkp.setForeground(whitex);
	bkp.add(ss_min_l);    bkp.add(ss_min);
	bkp.add(ss_1_l);      bkp.add(ss_1);
	bkp.add(ss_2_l);      bkp.add(ss_2);
	bkp.add(ss_3_l);      bkp.add(ss_3);
	bkp.add(ss_4_l);      bkp.add(ss_4);
	bkp.add(ss_5_l);      bkp.add(ss_5);
	bkp.add(ss_6_l);      bkp.add(ss_6);
	bkp.add(ss_7_l);      bkp.add(ss_7);
	bkp.add(ss_8_l);      bkp.add(ss_8);
	bkp.add(ss_9_l);      bkp.add(ss_9);
	bkp.add(ss_max_l);    bkp.add(ss_max);



	JPanel jpx0 = new JPanel();
	jpx0.setPreferredSize(new Dimension(340, 80));
	jpx0.setLayout(new FlowLayout());
	jpx0.setBackground(nm.program_gray_1);
	jpx0.setForeground(whitex);
	jpx0.add(save_b);




	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(nm.program_gray_2);
	cpx.setForeground(whitex);
	cpx.add(bkp);
	cpx.add(jpx0);

	setVisible(true);


	loadx();



}//mySQL_test












	public void savex(){


		System.out.println("Save");

		nm.carbon[4][0][87] = ss_min.getText();
		nm.carbon[4][0][88] = ss_1.getText();
		nm.carbon[4][0][89] = ss_2.getText();
		nm.carbon[4][0][90] = ss_3.getText();
		nm.carbon[4][0][91] = ss_4.getText();
		nm.carbon[4][0][92] = ss_5.getText();
		nm.carbon[4][0][93] = ss_6.getText();
		nm.carbon[4][0][94] = ss_7.getText();
		nm.carbon[4][0][95] = ss_8.getText();
		nm.carbon[4][0][96] = ss_9.getText();
		nm.carbon[4][0][97] = ss_max.getText();



	}//*****************










	public void loadx(){


		System.out.println("Load");

		ss_min.setText(nm.carbon[4][0][87]);
		ss_1.setText(nm.carbon[4][0][88]);
		ss_2.setText(nm.carbon[4][0][89]);
		ss_3.setText(nm.carbon[4][0][90]);
		ss_4.setText(nm.carbon[4][0][91]);
		ss_5.setText(nm.carbon[4][0][92]);
		ss_6.setText(nm.carbon[4][0][93]);
		ss_7.setText(nm.carbon[4][0][94]);
		ss_8.setText(nm.carbon[4][0][95]);
		ss_9.setText(nm.carbon[4][0][96]);
		ss_max.setText(nm.carbon[4][0][97]);


	}//*****************










	//handel all the button clicks. 
	public void actionPerformed(ActionEvent event){

		System.out.println("click");

		if(event.getSource() == save_b){savex();}//not used

	}//actionPerformed	










    public void pullThePlug() {

    
   		nm.firex = 1;


    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull







    public static void main(String[] args) {

    	ship_shipping_settings go = new ship_shipping_settings();

    }//main











}//last


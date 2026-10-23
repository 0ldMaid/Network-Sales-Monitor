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





public class alchemy_warehouse_settings extends JFrame implements ActionListener{


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 410;
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

int order_min_int = 0;
int order_max_int = 0;


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
JLabel warehouse_user_l = new JLabel("User", JLabel.LEFT);
JLabel warehouse_password_l = new JLabel("Password", JLabel.LEFT);
JLabel warehouse_key_l = new JLabel("Key", JLabel.LEFT);

JTextField warehouse_url = new JTextField("", 20);
JTextField warehouse_user = new JTextField("", 20);
JTextField warehouse_password = new JTextField("", 20);
JTextField warehouse_key = new JTextField("", 20);
JTextField sql_user = new JTextField("", 15);
JTextField sql_pass = new JTextField("", 14);
JTextField sql_db = new JTextField("", 30);

JComboBox jdb_db; 

JLabel order_spacer = new JLabel("", JLabel.LEFT);

JLabel order_min_l = new JLabel("Order Min", JLabel.LEFT);
JLabel order_max_l = new JLabel("Order Max", JLabel.LEFT);
JComboBox order_min; 
JComboBox order_max; 



String jdb_db_options[] = new String[1];

JButton save_b = new JButton("Save");
JButton test_b = new JButton("Test");

JButton load_a = new JButton("Load");
JButton save_a = new JButton("Save");
JButton delete_a = new JButton("Delete");


Icon imx4;







alchemy_warehouse_settings(){//********************************************************************************************

	super("Warehouse Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){nm.firex = 1; running = 0; savex();}});


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));



	infoxs.setPreferredSize(new Dimension(320, 25));
	infoxs.setText("  Warehouse Site Settings");
	infoxs.setForeground(blackx);
	infoxs.setOpaque(true); 
	infoxs.setBackground(nm.program_gray_2);

	infoxq.setPreferredSize(new Dimension(320, 25));
	infoxq.setText("  Remote mySQL DB");
	infoxq.setForeground(blackx);
	infoxq.setOpaque(true); 
	infoxq.setBackground(nm.program_gray_2);



	infox0.setPreferredSize(new Dimension(320, 20));
	infox0.setText("");
	infox0.setBackground(blackx);
	infox0.setForeground(whitex);
	//infox0.setOpaque(true); 
	//infox0.setBackground(blackx);


	infox1.setPreferredSize(new Dimension(320, 25));
	infox1.setText("SQL database IP");
	infox1.setForeground(whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(blackx);


	infox2.setPreferredSize(new Dimension(170, 25));
	infox2.setText("User Name");
	infox2.setForeground(whitex);
	infox2.setOpaque(true); 
	infox2.setBackground(blackx);


	infox3.setPreferredSize(new Dimension(150, 25));
	infox3.setText("Passworld");
	infox3.setForeground(whitex);
	infox3.setOpaque(true); 
	infox3.setBackground(blackx);


	infox4.setPreferredSize(new Dimension(320, 25));
	infox4.setText("mySQL Database");
	infox4.setForeground(whitex);
	infox4.setOpaque(true); 
	infox4.setBackground(blackx);


	infox5.setPreferredSize(new Dimension(200, 25));
	infox5.setText("mySQL Test");
	infox5.setForeground(whitex);
	infox5.setBackground(blackx);




	ix0 = 0;
	for (int loop1 = 0; loop1 < nm.jdb_load_list.length; loop1++){//*************
		if(nm.jdb_load_list[loop1].equals(nm.carbon[4][0][13])){ix0 = loop1;}
	}//************************************************************************

	jdb_db_options[0] = new String("nothing active");
	jdb_db = new JComboBox(nm.jdb_load_list);
	jdb_db.setSelectedIndex(ix0);
	jdb_db.addActionListener(this);
	jdb_db.setPreferredSize(new Dimension(197, 20));
	jdb_db.setEnabled(true);







	order_spacer.setPreferredSize(new Dimension(355, 20));

	order_min_l.setPreferredSize(new Dimension(155, 20));
	order_max_l.setPreferredSize(new Dimension(155, 20));





	load_a.setMargin(new Insets(0, 0, 0, 0));
  	load_a.addActionListener(this);
	load_a.setPreferredSize(new Dimension(55, 20));
 	load_a.setIcon(imx4);
	load_a.setHorizontalTextPosition(JButton.CENTER);
 	load_a.setForeground(whitex);

	save_a.setMargin(new Insets(0, 0, 0, 0));
  	save_a.addActionListener(this);
	save_a.setPreferredSize(new Dimension(55, 20));
 	save_a.setIcon(imx4);
	save_a.setHorizontalTextPosition(JButton.CENTER);
 	save_a.setForeground(whitex);

	delete_a.setMargin(new Insets(0, 0, 0, 0));
  	delete_a.addActionListener(this);
	delete_a.setPreferredSize(new Dimension(55, 20));
 	delete_a.setIcon(imx4);
	delete_a.setHorizontalTextPosition(JButton.CENTER);
 	delete_a.setForeground(whitex);



	save_b.setMargin(new Insets(0, 0, 0, 0));
  	save_b.addActionListener(this);
	save_b.setPreferredSize(new Dimension(55, 20));
 	save_b.setIcon(imx4);
	save_b.setHorizontalTextPosition(JButton.CENTER);
 	save_b.setForeground(blackx);

	test_b.setMargin(new Insets(0, 0, 0, 0));
  	test_b.addActionListener(this);
	test_b.setPreferredSize(new Dimension(55, 20));
 	test_b.setIcon(imx4);
	test_b.setHorizontalTextPosition(JButton.CENTER);
 	test_b.setForeground(blackx);





	try{

		System.out.println(nm.carbon[4][0][73]);
		order_min_int = Integer.parseInt(nm.carbon[4][0][73]);

	}catch(Exception e){order_min_int = 1;}

	if(order_min_int > nm.db_string.length){order_min_int = 0;}

	order_min = new JComboBox(nm.db_string);
	order_min.setSelectedIndex(order_min_int);
	order_min.addActionListener(this);
	order_min.setPreferredSize(new Dimension(150, 20));
	order_min.setToolTipText("Set Match Type.");

	try{

		System.out.println(nm.carbon[4][0][74]);
		order_max_int = Integer.parseInt(nm.carbon[4][0][74]);

	}catch(Exception e){order_max_int = 1;}

	if(order_max_int > nm.db_string.length){order_max_int = 0;}

	order_max = new JComboBox(nm.db_string);
	order_max.setSelectedIndex(order_max_int);
	order_max.addActionListener(this);
	order_max.setPreferredSize(new Dimension(150, 20));
	order_max.setToolTipText("Set Match Type.");








	test_b.setEnabled(false);
	save_b.setEnabled(true);


	warehouse_url_l.setForeground(blackx);
	warehouse_url_l.setPreferredSize(new Dimension(80, 20));

	warehouse_user_l.setForeground(blackx);
	warehouse_user_l.setPreferredSize(new Dimension(80, 20));

	warehouse_password_l.setForeground(blackx);
	warehouse_password_l.setPreferredSize(new Dimension(80, 20));

	warehouse_key_l.setForeground(blackx);
	warehouse_key_l.setPreferredSize(new Dimension(80, 20));


	warehouse_url.setText(nm.carbon[4][0][40]);
	warehouse_password.setText(nm.carbon[4][0][41]);
	warehouse_user.setText(nm.carbon[4][0][60]);
	warehouse_key.setText(nm.carbon[4][0][61]);


	JPanel bkp = new JPanel();
	bkp.setPreferredSize(new Dimension(340, 320));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(nm.program_gray_1);
	bkp.setForeground(whitex);
	bkp.add(infoxs); 
	bkp.add(warehouse_url_l);          bkp.add(warehouse_url); 
	bkp.add(warehouse_user_l);         bkp.add(warehouse_user); 
	bkp.add(warehouse_password_l);     bkp.add(warehouse_password); 
	bkp.add(warehouse_key_l);          bkp.add(warehouse_key); 
	bkp.add(order_spacer);
	bkp.add(order_min_l);     bkp.add(order_min); 
	bkp.add(order_max_l);     bkp.add(order_max); 



	JPanel jpx0 = new JPanel();
	jpx0.setPreferredSize(new Dimension(340, 80));
	jpx0.setLayout(new FlowLayout());
	jpx0.setBackground(nm.program_gray_1);
	jpx0.setForeground(whitex);
	jpx0.add(infox5);
	jpx0.add(test_b);
	jpx0.add(save_b);




	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(nm.program_gray_2);
	cpx.setForeground(whitex);
	cpx.add(bkp);
	cpx.add(jpx0);

	setVisible(true);






}//mySQL_test












	public void savex(){


		System.out.println("Save");

		nm.carbon[4][0][40] = warehouse_url.getText();
		nm.carbon[4][0][41] = warehouse_password.getText();

		nm.carbon[4][0][60] = warehouse_user.getText();
		nm.carbon[4][0][61] = warehouse_key.getText();


		nm.carbon[4][0][73] = Integer.toString(order_min_int);
		nm.carbon[4][0][74] = Integer.toString(order_max_int);



	}//*****************








//handel all the button clicks. 
public void actionPerformed(ActionEvent event){


	System.out.println("click");

	if(event.getSource() == save_b){savex();}//not used




	if(event.getSource() == order_min){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();
		
		for (int loop1 = 0; loop1 < order_min.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){order_min_int = loop1;}

		}//*********************

	}//not used


	if(event.getSource() == order_max){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < order_max.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){order_max_int = loop1;}

		}//*********************

	}//not used






}//actionPerformed	










    public void pullThePlug() {

	    savex();
	    
	    nm.firex = 1;

	    System.out.println("PULL THE PLUG");

	    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull







    public static void main(String[] args) {

    	alchemy_warehouse_settings go = new alchemy_warehouse_settings();

    }//main






	class BackgroundPanel extends JPanel{
  
  		Image image;
  
  		public BackgroundPanel(){
    
    		try{

      			image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3b.jpg"), "background3b.jpg"));

    		}catch (Exception e) { System.out.println("Failed001"); }

  		}//backgroundpanel

  		protected void paintComponent(Graphics g){

    		super.paintComponent(g); 
    
    		if (image != null){
      
      			g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);

      		}//****************
  
  		}//paint

	}//jpanel











}//last


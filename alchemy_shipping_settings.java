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

JLabel info0 = new JLabel("POST 0", JLabel.CENTER);
JLabel info1 = new JLabel("POST 1", JLabel.CENTER);
JLabel info2 = new JLabel("POST 2", JLabel.CENTER);
JLabel info3 = new JLabel("POST 3", JLabel.CENTER);
JLabel info4 = new JLabel("POST 4", JLabel.CENTER);
JLabel info5 = new JLabel("POST 5", JLabel.CENTER);
JLabel info6 = new JLabel("POST 6", JLabel.CENTER);
JLabel info7 = new JLabel("POST 7", JLabel.CENTER);
JLabel info8 = new JLabel("POST 8", JLabel.CENTER);
JLabel info9 = new JLabel("POST 9", JLabel.CENTER);
JLabel info10 = new JLabel("POST 10", JLabel.CENTER);
JLabel info11 = new JLabel("POST 11", JLabel.CENTER);

JComboBox post_0 = new JComboBox();
JComboBox post_1 = new JComboBox();
JComboBox post_2 = new JComboBox();
JComboBox post_3 = new JComboBox();
JComboBox post_4 = new JComboBox();
JComboBox post_5 = new JComboBox();
JComboBox post_6 = new JComboBox();
JComboBox post_7 = new JComboBox();
JComboBox post_8 = new JComboBox();
JComboBox post_9 = new JComboBox();
JComboBox post_10 = new JComboBox();
JComboBox post_11 = new JComboBox();

static int runs2 = 400;
static int runs = 50000;
static int thisc2 = 0; 
static int thisc3 = 0;
int kcountxx = 0;
int kcountxx2 = 0;
int csv_int = 0;
int working = 1; 
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
int csv_passes_x = 17;

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

JTextField local_url = new JTextField("", 23);
JTextField sql_url = new JTextField("", 30);
JTextField sql_user = new JTextField("", 15);
JTextField sql_pass = new JTextField("", 14);
JTextField sql_db = new JTextField("", 30);

JComboBox jdb_db; 

String jdb_db_options[] = new String[1];

JButton save_b = new JButton("Save");
JButton test_b = new JButton("Test");

JButton load_a = new JButton("Load");
JButton save_a = new JButton("Save");
JButton delete_a = new JButton("Delete");

Icon imx4;







alchemy_shipping_settings(){//********************************************************************************************

	super("Online POST Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){nm.shipping_settings_open = 0; nm.firex = 1; running = 0;}});


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));


	nm.shipping_settings_open = 1;


	infoxs.setPreferredSize(new Dimension(320, 25));
	infoxs.setText("Local JDB Databases");
	infoxs.setForeground(nm.whitex);
	infoxs.setOpaque(true); 
	infoxs.setBackground(nm.blackx);

	infoxq.setPreferredSize(new Dimension(320, 25));
	infoxq.setText("Remote mySQL DB");
	infoxq.setForeground(nm.whitex);
	infoxq.setOpaque(true); 
	infoxq.setBackground(nm.blackx);



	infox0.setPreferredSize(new Dimension(320, 20));
	infox0.setText("  Shipping System Settings");
	infox0.setBackground(nm.blackx);
	infox0.setForeground(nm.whitex);
	infox0.setOpaque(true); 
	infox0.setBackground(nm.grayx3);


	infox1.setPreferredSize(new Dimension(320, 20));
	infox1.setText("  POST Fields");
	infox1.setForeground(nm.whitex);
	infox1.setOpaque(true); 
	infox1.setBackground(nm.grayx3);


	info0.setPreferredSize(new Dimension(70, 20));
	info0.setText("Post 00");
	info0.setForeground(nm.whitex);
	info0.setOpaque(true); 
	info0.setBackground(nm.grayx3);

	info1.setPreferredSize(new Dimension(70, 20));
	info1.setText("Post 01");
	info1.setForeground(nm.whitex);
	info1.setOpaque(true); 
	info1.setBackground(nm.grayx3);

	info2.setPreferredSize(new Dimension(70, 20));
	info2.setText("Post 02");
	info2.setForeground(nm.whitex);
	info2.setOpaque(true); 
	info2.setBackground(nm.grayx3);

	info3.setPreferredSize(new Dimension(70, 20));
	info3.setText("Post 03");
	info3.setForeground(nm.whitex);
	info3.setOpaque(true); 
	info3.setBackground(nm.grayx3);

	info4.setPreferredSize(new Dimension(70, 20));
	info4.setText("Post 04");
	info4.setForeground(nm.whitex);
	info4.setOpaque(true); 
	info4.setBackground(nm.grayx3);

	info5.setPreferredSize(new Dimension(70, 20));
	info5.setText("Post 05");
	info5.setForeground(nm.whitex);
	info5.setOpaque(true); 
	info5.setBackground(nm.grayx3);

	info6.setPreferredSize(new Dimension(70, 20));
	info6.setText("Post 06");
	info6.setForeground(nm.whitex);
	info6.setOpaque(true); 
	info6.setBackground(nm.grayx3);

	info7.setPreferredSize(new Dimension(70, 20));
	info7.setText("Post 07");
	info7.setForeground(nm.whitex);
	info7.setOpaque(true); 
	info7.setBackground(nm.grayx3);

	info8.setPreferredSize(new Dimension(70, 20));
	info8.setText("Post 08");
	info8.setForeground(nm.whitex);
	info8.setOpaque(true); 
	info8.setBackground(nm.grayx3);

	info9.setPreferredSize(new Dimension(70, 20));
	info9.setText("Post 09");
	info9.setForeground(nm.whitex);
	info9.setOpaque(true); 
	info9.setBackground(nm.grayx3);

	info10.setPreferredSize(new Dimension(70, 20));
	info10.setText("Post 10");
	info10.setForeground(nm.whitex);
	info10.setOpaque(true); 
	info10.setBackground(nm.grayx3);

	info11.setPreferredSize(new Dimension(70, 20));
	info11.setText("Post 11");
	info11.setForeground(nm.whitex);
	info11.setOpaque(true); 
	info11.setBackground(nm.grayx3);



	ix0 = 0;
	for (int loop1 = 0; loop1 < nm.jdb_load_list.length; loop1++){//*************

		if (nm.jdb_load_list[loop1].equals(nm.carbon[4][0][13])) {ix0 = loop1;}

	}//************************************************************************

	jdb_db_options[0] = new String("nothing active");
	jdb_db = new JComboBox(nm.jdb_load_list);
	jdb_db.setSelectedIndex(ix0);
	jdb_db.addActionListener(this);
	jdb_db.setPreferredSize(new Dimension(197, 20));
	jdb_db.setEnabled(true);


	local_url.setEnabled(true);
	local_url.setText("");


	sql_url.setText(nm.carbon[4][0][7]);
	sql_user.setText(nm.carbon[4][0][8]);
	sql_pass.setText(nm.carbon[4][0][9]);
	sql_db.setText(nm.carbon[4][0][10]);




	load_a.setMargin(new Insets(0, 0, 0, 0));
  	load_a.addActionListener(this);
	load_a.setPreferredSize(new Dimension(55, 20));
 	load_a.setIcon(imx4);
	load_a.setHorizontalTextPosition(JButton.CENTER);
 	load_a.setForeground(nm.whitex);

	save_a.setMargin(new Insets(0, 0, 0, 0));
  	save_a.addActionListener(this);
	save_a.setPreferredSize(new Dimension(55, 20));
 	save_a.setIcon(imx4);
	save_a.setHorizontalTextPosition(JButton.CENTER);
 	save_a.setForeground(nm.whitex);

	delete_a.setMargin(new Insets(0, 0, 0, 0));
  	delete_a.addActionListener(this);
	delete_a.setPreferredSize(new Dimension(55, 20));
 	delete_a.setIcon(imx4);
	delete_a.setHorizontalTextPosition(JButton.CENTER);
 	delete_a.setForeground(nm.whitex);



	save_b.setMargin(new Insets(0, 0, 0, 0));
  	save_b.addActionListener(this);
	save_b.setPreferredSize(new Dimension(55, 20));
 	save_b.setIcon(imx4);
	save_b.setHorizontalTextPosition(JButton.CENTER);
 	save_b.setForeground(nm.whitex);

	test_b.setMargin(new Insets(0, 0, 0, 0));
  	test_b.addActionListener(this);
	test_b.setPreferredSize(new Dimension(55, 20));
 	test_b.setIcon(imx4);
	test_b.setHorizontalTextPosition(JButton.CENTER);
 	test_b.setForeground(nm.whitex);



	try{ix1 = Integer.parseInt(nm.carbon[4][0][62]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_0 = new JComboBox(nm.db_string);
	post_0.setSelectedIndex(ix1);
	post_0.addActionListener(this);
	post_0.setPreferredSize(new Dimension(188, 20));
	post_0.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][63]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_1 = new JComboBox(nm.db_string);
	post_1.setSelectedIndex(ix1);
	post_1.addActionListener(this);
	post_1.setPreferredSize(new Dimension(188, 20));
	post_1.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][64]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_2 = new JComboBox(nm.db_string);
	post_2.setSelectedIndex(ix1);
	post_2.addActionListener(this);
	post_2.setPreferredSize(new Dimension(188, 20));
	post_2.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][65]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_3 = new JComboBox(nm.db_string);
	post_3.setSelectedIndex(ix1);
	post_3.addActionListener(this);
	post_3.setPreferredSize(new Dimension(188, 20));
	post_3.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][66]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_4 = new JComboBox(nm.db_string);
	post_4.setSelectedIndex(ix1);
	post_4.addActionListener(this);
	post_4.setPreferredSize(new Dimension(188, 20));
	post_4.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][67]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_5 = new JComboBox(nm.db_string);
	post_5.setSelectedIndex(ix1);
	post_5.addActionListener(this);
	post_5.setPreferredSize(new Dimension(188, 20));
	post_5.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][68]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_6 = new JComboBox(nm.db_string);
	post_6.setSelectedIndex(ix1);
	post_6.addActionListener(this);
	post_6.setPreferredSize(new Dimension(188, 20));
	post_6.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][69]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_7 = new JComboBox(nm.db_string);
	post_7.setSelectedIndex(ix1);
	post_7.addActionListener(this);
	post_7.setPreferredSize(new Dimension(188, 20));
	post_7.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][70]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_8 = new JComboBox(nm.db_string);
	post_8.setSelectedIndex(ix1);
	post_8.addActionListener(this);
	post_8.setPreferredSize(new Dimension(188, 20));
	post_8.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][71]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_9 = new JComboBox(nm.db_string);
	post_9.setSelectedIndex(ix1);
	post_9.addActionListener(this);
	post_9.setPreferredSize(new Dimension(188, 20));
	post_9.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][72]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_10 = new JComboBox(nm.db_string);
	post_10.setSelectedIndex(ix1);
	post_10.addActionListener(this);
	post_10.setPreferredSize(new Dimension(188, 20));
	post_10.setToolTipText("Set shipping type.");

	try{ix1 = Integer.parseInt(nm.carbon[4][0][73]);}catch(Exception e){ix1 = 0;}
	if(ix1 > 99){ix1 = 0;}
	post_11 = new JComboBox(nm.db_string);
	post_11.setSelectedIndex(ix1);
	post_11.addActionListener(this);
	post_11.setPreferredSize(new Dimension(188, 20));
	post_11.setToolTipText("Set shipping type.");


	
	sql_url.setEnabled(false);
	sql_user.setEnabled(false);
	sql_pass.setEnabled(false);
	sql_db.setEnabled(false);

	test_b.setEnabled(false);
	save_b.setEnabled(false);



	JPanel bkp = new JPanel();
	bkp.setPreferredSize(new Dimension(340, 220));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(nm.grayx1);
	bkp.setForeground(nm.whitex);
	bkp.add(infox0); 



	JPanel jpx0 = new JPanel();
	jpx0.setPreferredSize(new Dimension(340, 400));
	jpx0.setLayout(new FlowLayout());
	jpx0.setBackground(nm.grayx1);
	jpx0.setForeground(nm.whitex);
	jpx0.add(infox1); 
	jpx0.add(info0);   jpx0.add(post_0);
	jpx0.add(info1);   jpx0.add(post_1);
	jpx0.add(info2);   jpx0.add(post_2);
	jpx0.add(info3);   jpx0.add(post_3);
	jpx0.add(info4);   jpx0.add(post_4);
	jpx0.add(info5);   jpx0.add(post_5);
	jpx0.add(info6);   jpx0.add(post_6);
	jpx0.add(info7);   jpx0.add(post_7);
	jpx0.add(info8);   jpx0.add(post_8);
	jpx0.add(info9);   jpx0.add(post_9);
	jpx0.add(info10);  jpx0.add(post_10);
	jpx0.add(info11);  jpx0.add(post_11);


	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(nm.grayx2);
	cpx.setForeground(nm.whitex);
	cpx.add(bkp);
	cpx.add(jpx0);

	setVisible(true);



	//jdb_db.fireItemStateChanged();


}//mySQL_test










//handel all the button clicks. 
public void actionPerformed(ActionEvent event){


	//if(event.getSource() == save_b){save_sql_login();}//send reply message



	if(event.getSource() == post_0){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][62] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used



	if(event.getSource() == post_1){

           cb = (JComboBox) event.getSource();
           newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][63] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used



	if(event.getSource() == post_2){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][64] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used



	if(event.getSource() == post_3){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][65] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used



	if(event.getSource() == post_4){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][66] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used




	if(event.getSource() == post_5){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][67] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used



	if(event.getSource() == post_6){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][68] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used



	if(event.getSource() == post_7){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][69] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used



	if(event.getSource() == post_8){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][70] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used



	if(event.getSource() == post_9){
           
        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][71] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used



	if(event.getSource() == post_10){
           
        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][72] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used



	if(event.getSource() == post_11){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < post_0.getItemCount(); loop1++){//s1x

			if(nm.db_string[loop1].equals(newItem)){nm.carbon[4][0][73] = Integer.toString(loop1);}

		}//**************************************************************

	}//not used




}//actionPerformed	










    public void pullThePlug() {

    
    	nm.firex = 1;


   		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
   		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull














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


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





public class alchemy_database_settings extends JFrame implements ActionListener{

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 430;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


Object newItem;
JComboBox cb;

JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infoxq = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox2 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox3 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox4 = new JLabel("Loading...", JLabel.LEFT);
JLabel jdb_pass_l = new JLabel("JDB Password", JLabel.RIGHT);
JLabel infox00 = new JLabel("", JLabel.LEFT);
JLabel csv_file_info = new JLabel(" Local .csv File", JLabel.LEFT);
JLabel csv_file_l = new JLabel("Path:", JLabel.RIGHT);

Label infox5 = new Label("Loading...", Label.LEFT);

int csv_passes_x = 17;
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
int looppx = 0;
int current_submit_item_xx = -1;

String[] cxx0 = new String[1];
String jdb_db_options[] = new String[1];
String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");
String new_db = new String("");
String new_db_number = new String("");

JTextField local_url = new JTextField("", 23);
JTextField jdb_pass = new JTextField("", 10);
JTextField sql_url = new JTextField("", 20);
JTextField sql_user = new JTextField("", 20);
JTextField sql_pass = new JTextField("", 20);
JTextField sql_db = new JTextField("", 20);

JTextField csv_file = new JTextField("", 20);

JComboBox jdb_db; 

JButton save_b = new JButton("Build");
JButton test_b = new JButton("Test");
JButton load_a = new JButton("Load");
JButton save_a = new JButton("Save");
JButton delete_a = new JButton("Delete");

Icon imx4;







alchemy_database_settings(){//********************************************************************************************

	super("DB Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){running = 0; savex(); nm.firex = 1;}});


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));



	infoxs.setPreferredSize(new Dimension(325, 25));
	infoxs.setText(" Local JDB Databases");
	infoxs.setForeground(nm.blackx);
	infoxs.setOpaque(true); 
	infoxs.setBackground(nm.program_gray_2);

	infoxq.setPreferredSize(new Dimension(325, 25));
	infoxq.setText(" Remote mySQL DB");
	infoxq.setForeground(nm.blackx);
	infoxq.setOpaque(true); 
	infoxq.setBackground(nm.program_gray_2);



	infox0.setPreferredSize(new Dimension(325, 10));
	infox0.setText("");



	infox1.setPreferredSize(new Dimension(80, 25));
	infox1.setText("SQL IP");
	infox1.setForeground(nm.blackx);
	infox1.setBackground(nm.program_gray_2);


	infox2.setPreferredSize(new Dimension(80, 25));
	infox2.setText("User Name");
	infox2.setForeground(nm.blackx);
	infox2.setBackground(nm.program_gray_2);


	infox3.setPreferredSize(new Dimension(80, 25));
	infox3.setText("Passworld");
	infox3.setForeground(nm.blackx);
	infox3.setBackground(nm.program_gray_2);


	infox4.setPreferredSize(new Dimension(80, 25));
	infox4.setText("Database");
	infox4.setForeground(nm.blackx);
	infox4.setBackground(nm.program_gray_2);


	infox5.setPreferredSize(new Dimension(200, 25));
	infox5.setText(" mySQL Test");
	infox5.setForeground(nm.whitex);
	infox5.setBackground(nm.blackx);


	jdb_pass_l.setPreferredSize(new Dimension(140, 25));
	jdb_pass_l.setForeground(nm.blackx);
	jdb_pass_l.setBackground(nm.blackx);



	infox00.setPreferredSize(new Dimension(325, 10));
	infox00.setText("");



	csv_file_info.setPreferredSize(new Dimension(325, 25));
	csv_file_info.setForeground(nm.blackx);
	csv_file_info.setOpaque(true); 
	csv_file_info.setBackground(nm.program_gray_2);

	csv_file_l.setPreferredSize(new Dimension(80, 25));
	csv_file_l.setForeground(nm.blackx);
	csv_file_l.setBackground(nm.blackx);




	ix0 = 0;
	for (int loop1 = 0; loop1 < nm.jdb_load_list.length; loop1++) {//*********

		if(nm.jdb_load_list[loop1].equals(nm.carbon[4][0][13])){ix0 = loop1;}

	}//***********************************************************************

	jdb_db_options[0] = new String("nothing active");
	jdb_db = new JComboBox(nm.jdb_load_list);
	jdb_db.setSelectedIndex(ix0);
	jdb_db.addActionListener(this);
	jdb_db.setPreferredSize(new Dimension(197, 20));
	jdb_db.setEnabled(true);


	cb_edit = ix0; 
	new_db_number = Integer.toString(ix0); 
	new_db = nm.jdb_load_list[ix0];


	local_url.setEnabled(true);
	local_url.setText("");


	sql_url.setText(nm.carbon[4][0][7]);
	sql_user.setText(nm.carbon[4][0][8]);
	sql_pass.setText(nm.carbon[4][0][9]);
	sql_db.setText(nm.carbon[4][0][10]);

	sql_url.setEnabled(false);
	sql_user.setEnabled(false);
	sql_pass.setEnabled(false);
	sql_db.setEnabled(false);




	load_a.setMargin(new Insets(0, 0, 0, 0));
  	load_a.addActionListener(this);
	load_a.setPreferredSize(new Dimension(55, 20));
 	//load_a.setIcon(imx4);
	load_a.setBackground(nm.st_gray1);
	load_a.setHorizontalTextPosition(JButton.CENTER);
 	load_a.setForeground(nm.blackx);

	save_a.setMargin(new Insets(0, 0, 0, 0));
  	save_a.addActionListener(this);
	save_a.setPreferredSize(new Dimension(55, 20));
 	//save_a.setIcon(imx4);
	save_a.setBackground(nm.st_gray1);
	save_a.setHorizontalTextPosition(JButton.CENTER);
 	save_a.setForeground(nm.blackx);

	delete_a.setMargin(new Insets(0, 0, 0, 0));
  	delete_a.addActionListener(this);
	delete_a.setPreferredSize(new Dimension(55, 20));
 	//delete_a.setIcon(imx4);
	delete_a.setBackground(nm.st_gray1);
	delete_a.setHorizontalTextPosition(JButton.CENTER);
 	delete_a.setForeground(nm.blackx);



	save_b.setMargin(new Insets(0, 0, 0, 0));
  	save_b.addActionListener(this);
	save_b.setPreferredSize(new Dimension(55, 20));
 	//save_b.setIcon(imx4);
	save_b.setBackground(nm.st_gray1);
	save_b.setHorizontalTextPosition(JButton.CENTER);
 	save_b.setForeground(nm.blackx);

	test_b.setMargin(new Insets(0, 0, 0, 0));
  	test_b.addActionListener(this);
	test_b.setPreferredSize(new Dimension(55, 20));
 	//test_b.setIcon(imx4);
	test_b.setBackground(nm.st_gray1);
	test_b.setHorizontalTextPosition(JButton.CENTER);
 	test_b.setForeground(nm.blackx);




	//sql_url.setEnabled(false);
	//sql_user.setEnabled(false);
	//sql_pass.setEnabled(false);
	//sql_db.setEnabled(false);

	//test_b.setEnabled(false);
	//save_b.setEnabled(false);



	//BackgroundPanel bkp = new BackgroundPanel();
	JPanel bkp = new JPanel();
	bkp.setPreferredSize(new Dimension(340, 355));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(nm.program_gray_1);
	bkp.setForeground(nm.whitex);
	bkp.add(infoxs); 
	bkp.add(jdb_db);    bkp.add(load_a);  bkp.add(delete_a);
	bkp.add(local_url); bkp.add(save_a);
	bkp.add(jdb_pass_l);bkp.add(jdb_pass);

	bkp.add(infox0);

	bkp.add(csv_file_info);
	bkp.add(csv_file_l);
	bkp.add(csv_file);

	bkp.add(infox00);

	bkp.add(infoxq);
	bkp.add(infox1);
	bkp.add(sql_url);
	bkp.add(infox2);
	bkp.add(sql_user);
	bkp.add(infox3);
	bkp.add(sql_pass);
	bkp.add(infox4);
	bkp.add(sql_db);




	JPanel jpx0 = new JPanel();
	jpx0.setPreferredSize(new Dimension(340, 80));
	jpx0.setLayout(new FlowLayout());
	jpx0.setBackground(nm.program_gray_1);
	jpx0.setForeground(nm.whitex);
	jpx0.add(infox5);
	jpx0.add(test_b);
	jpx0.add(save_b);


	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(nm.program_gray_2);
	cpx.setForeground(nm.whitex);
	cpx.add(bkp);
	cpx.add(jpx0);

	setVisible(true);

	jdb_pass.setText(nm.carbon[4][0][15]);
	csv_file.setText(nm.carbon[4][0][4]);

	//jdb_db.fireItemStateChanged();


}//mySQL_test







	public void savex(){

		nm.carbon[4][0][15] = jdb_pass.getText();
		nm.carbon[4][0][4] = csv_file.getText();

	}//*****************







	public void save_sql_login(){


		nm.carbon[4][0][7] = sql_url.getText();
		nm.carbon[4][0][8] = sql_user.getText();
		nm.carbon[4][0][9] = sql_pass.getText();
		nm.carbon[4][0][10] = sql_db.getText();

	}//login






	public void test_sql_login(){


        Connection conn = null;

        try{

           
           	String userName = sql_user.getText();
			infox5.setText("1"); 
            String password = sql_pass.getText();
			infox5.setText("2"); 
            String url = "jdbc:mysql://" + sql_url.getText() + "";
			infox5.setText("Load SQL driver."); 

            Class.forName("com.mysql.jdbc.Driver").newInstance();
			infox5.setText("Connect to SQL server."); 
            conn = DriverManager.getConnection(url, userName, password);
			infox5.setText("Success."); 
            System.out.println("Database connection established");

			DatabaseMetaData dbmd = conn.getMetaData(); 
			String dbmsName = dbmd.getDatabaseProductName(); 
			ResultSet rs = dbmd.getTableTypes(); 
			System.out.print("The following types of tables are "); 
			System.out.println("available in " + dbmsName + ": "); 


        } catch (Exception e) {System.err.println ("Cannot connect to database server");}



        finally {

            if (conn != null) {

                try {

                    conn.close ();
                    System.out.println ("Database connection terminated");

                } catch (Exception e) { /* ignore close errors */ }

			}//if

        }//finally




	}//login








	public void save_jdb_list(){


		jdb_db.removeAllItems();


		String[] new_jdb = new String[(nm.jdb_load_list.length + 1)];

		for (int loop1 = 0; loop1 < nm.jdb_load_list.length; loop1++){//s1x

			new_jdb[loop1] = nm.jdb_load_list[loop1];
			jdb_db.addItem(nm.jdb_load_list[loop1]);

		}//**************************************************************


		new_jdb[jdb_db.getItemCount()] = new String(local_url.getText());

		nm.jdb_load_list = new_jdb;

		jdb_db.addItem(nm.jdb_load_list[jdb_db.getItemCount()]);

		jdb_db.setSelectedItem(nm.jdb_load_list[(jdb_db.getItemCount() -1)]);



		cxx0 = nm.jdb_load_list;



		cx0 = nm.jdb_load_list[(nm.jdb_load_list.length -1)];

		nm.jdb_load_list[(nm.jdb_load_list.length -1)] = nm.jdb_load_list[0];
		nm.jdb_load_list[0] = cx0;



		jdb_saver_items jdbs = new jdb_saver_items();

		nm.jdb_load_list = cxx0;


	}//**************************









	public void load_jdb_list(){

		jdb_saver_items jdbs = new jdb_saver_items();


		nm.carbon[4][0][13] = new_db;
		nm.carbon[4][0][17] = new_db_number;


		jdb_loader_items jdbl = new jdb_loader_items();


		pullThePlug();

	}//**************************









	public void delete_jdb_list(){

		System.out.println("DELETE");
		if(nm.jdb_load_list.length > 1){
	

			System.out.println("DELETE YES " + Integer.toString(cb_edit));

			cxx0 = new String[(nm.jdb_load_list.length)];

			ix0 = 0;
	
			for (int loop1 = 0; loop1 < cxx0.length; loop1++){//s1x*********

				if(loop1 == cb_edit){System.out.println("DELETE HERE");}
				else{cxx0[ix0] = new String(nm.jdb_load_list[loop1]); ix0++;}
				//System.out.println(nm.jdb_load_list[loop1] + " " + Integer.toString(loop1) + " " + Integer.toString(cb_edit));
	
			}//**************************************************************


			nm.jdb_load_list = new String[(cxx0.length -1)];


			for (int loop1 = 0; loop1 < nm.jdb_load_list.length; loop1++){//s1x*********

				System.out.println(nm.jdb_load_list[loop1] + " " + Integer.toString(loop1) + " " + Integer.toString(cb_edit));
				nm.jdb_load_list[loop1] = new String(cxx0[loop1]);	

			}//**************************************************************



			jdb_db.removeAllItems();


			for (int loop1 = 0; loop1 < nm.jdb_load_list.length; loop1++){//s1x*********

				System.out.println(nm.jdb_load_list[loop1] + " " + Integer.toString(loop1) + " " + Integer.toString(cb_edit));
				jdb_db.addItem(nm.jdb_load_list[loop1]); 	

			}//**************************************************************



			load_jdb_list();


		}//*************if

	}//**************************






    public void pullThePlug() {

		System.out.println("PULL THE PLUG");    

    	nm.firex = 1;


    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull











//handel all the button clicks. 
public void actionPerformed(ActionEvent event){


	if(event.getSource() == save_b){save_sql_login();}//send reply message
	if(event.getSource() == test_b){test_sql_login();}//send reply message

	if(event.getSource() == load_a){load_jdb_list();}//send reply message
	if(event.getSource() == save_a){save_jdb_list();}//send reply message
	if(event.getSource() == delete_a){delete_jdb_list();}//send reply message




	if(event.getSource() == jdb_db){

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();
		
		for (int loop1 = 0; loop1 < jdb_db.getItemCount(); loop1++){//s1x

			if(nm.jdb_load_list[loop1].equals(newItem)){cb_edit = loop1; new_db_number = Integer.toString(loop1); new_db = nm.jdb_load_list[loop1];}

		}//**************************************************************

	}//not used




}//actionPerformed	








}//last


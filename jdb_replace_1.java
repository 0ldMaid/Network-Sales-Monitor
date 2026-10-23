import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.text.*;  
//import java.lang.Object.*;  
//import javax.imageio.ImageIO;
//import javax.imageio.*;
//import java.awt.image.*;
//import javax.swing.border.EmptyBorder;
//import java.awt.BorderLayout;
//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.sql.CallableStatement;




public class jdb_replace_1 extends JFrame implements ActionListener{

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 380;
int xzy = 190;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

JFrame frame_1 = new JFrame();
//JFileChooser file_chooser = new JFileChooser(file_open_1);

int section_number = 0;
int ix0 = 0;

String[][] carbonfiber = new String[0][0];
String[] silver = new String[0];
String d1 = new String();
String d2 = new String();
String rep1 = new String();
String rep2 = new String();
String cx0 = new String();
String cx1 = new String();
String cx2 = new String();

JButton b0 = new JButton();
JButton b1 = new JButton();
JButton b2 = new JButton();

JComboBox cb_column;
//JComboBox cb_sitese;

Label l0 = new Label();
Label l1 = new Label();
Label l2 = new Label();

TextField sectionxa = new TextField("", 28);
TextField sectionxb = new TextField("", 28);

File filex1;
File filex2;

Icon imx0;





jdb_replace_1(){//********************************************************************************************************
	
	super("Alchemy Replace");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){nm.replace_window_open = false;}});//



//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

//get button images from the Jar file.
	//imx0 = new ImageIcon(this.getClass().getResource("images/buttonimage.png"));


	b0 = new JButton("Replace");
	b0.setMargin(new Insets(0, 0, 0, 0));  
	b0.addActionListener(this);
	b0.setPreferredSize(new Dimension(70, 25));
	b0.setHorizontalTextPosition(JButton.CENTER);
	b0.setForeground(Color.BLACK);
	b0.setBackground(nm.jblue);

	b1 = new JButton("Replace (Selected)");
	b1.setMargin(new Insets(0, 0, 0, 0));  
	b1.addActionListener(this);
	b1.setPreferredSize(new Dimension(120, 25));
	b1.setHorizontalTextPosition(JButton.CENTER);
	b1.setForeground(Color.BLACK);
	b1.setBackground(nm.jblue);

	b2 = new JButton("Replace (All)");
	b2.setMargin(new Insets(0, 0, 0, 0));  
	b2.addActionListener(this);
	b2.setPreferredSize(new Dimension(120, 25));
	b2.setHorizontalTextPosition(JButton.CENTER);
	b2.setForeground(Color.BLACK);
	b2.setBackground(nm.jblue);





	carbonfiber = nm.carbon[nm.db_number];
	silver = new String[carbonfiber.length];


	for(int xloop0 = 0; xloop0 < nm.db_string.length; xloop0++){//******

		silver[xloop0] = nm.db_string[xloop0];

	}//for**************************************************************


	try {
	
		ix0 = Integer.parseInt(nm.carbon[4][0][69]);
		sectionxa.setText(nm.carbon[4][0][70]);
		sectionxb.setText(nm.carbon[4][0][71]);
		section_number = ix0;
	
	} catch (Exception e) {ix0 = 1;}

	cb_column = new JComboBox(silver);

	try {
	
		cb_column.setSelectedIndex(ix0);
	
	} catch (Exception e) {}

	cb_column.addActionListener(this);
	cb_column.setPreferredSize(new Dimension(360, 20));


	sectionxa.setBackground(Color.WHITE);
	sectionxa.setForeground(Color.BLACK);
	sectionxb.setBackground(Color.WHITE);
	sectionxb.setForeground(Color.BLACK);


	l0 = new Label("Loading", Label.LEFT);
	l0.setPreferredSize(new Dimension(360, 20));
	l0.setBackground(nm.jblue);
	l0.setForeground(Color.BLACK);

	l1 = new Label("Find:", Label.LEFT);
	l1.setPreferredSize(new Dimension(75, 20));
	l1.setBackground(nm.jblue);
	l1.setForeground(Color.BLACK);

	l2 = new Label("Replace:", Label.LEFT);
	l2.setPreferredSize(new Dimension(75, 20));
	l2.setBackground(nm.jblue);
	l2.setForeground(Color.BLACK);




    JPanel jp0 = new JPanel();
	jp0.setPreferredSize(new Dimension(370, 90));
	jp0.setBackground(nm.jblue);
	jp0.add(l0);
	jp0.add(l1);  jp0.add(sectionxa);
	jp0.add(l2);  jp0.add(sectionxb);

    JPanel jp2 = new JPanel();
	jp2.setPreferredSize(new Dimension(370, 40));
	jp2.setBackground(nm.jblue);
	jp2.add(b0);
	jp2.add(b1);
	jp2.add(b2);

	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(nm.jgray);
	cp.setForeground(nm.jgray);
	cp.add(cb_column);
	cp.add(jp0);
	cp.add(jp2);



	setVisible(true);


}//postid**************************************************************************************************************














//workers***************************************************************************************
//workers***************************************************************************************





	public void replacex() {//replace a with b



		for (int loop0 = 0; loop0 < nm.carbon[nm.db_number][0].length; loop0++) {

			cx0 = nm.carbon[nm.db_number][section_number][loop0];
			cx1 = sectionxa.getText();
			cx2 = sectionxb.getText();
			l0.setText((loop0 * 100 / nm.carbon[nm.db_number][0].length) + "% Complete."); 

			if (cx1.equals("<<<\">>>")) {

				System.out.println("SS REPLACE");

				if (nm.carbon[nm.db_number][section_number][loop0].substring(0,1).equals("\"")) {

					nm.carbon[nm.db_number][section_number][loop0] = nm.carbon[nm.db_number][section_number][loop0].substring(1, nm.carbon[nm.db_number][section_number][loop0].length());
				
				}//*****************************************************************

				if (nm.carbon[nm.db_number][section_number][loop0].substring(nm.carbon[nm.db_number][section_number][loop0].length() -1, nm.carbon[nm.db_number][section_number][loop0].length()).equals("\"")) {
				
					nm.carbon[nm.db_number][section_number][loop0] = nm.carbon[nm.db_number][section_number][loop0].substring(0, nm.carbon[nm.db_number][section_number][loop0].length() -1);
				
				}//*****************************************************************

			}//************************


			if (cx1.equals("<<<START>>>")) {

				nm.carbon[nm.db_number][section_number][loop0] = cx2 + nm.carbon[nm.db_number][section_number][loop0];

			}//***************************


			if (cx1.equals("<<<END>>>")) {

				nm.carbon[nm.db_number][section_number][loop0] = nm.carbon[nm.db_number][section_number][loop0] + cx2;

			}//***************************


			if (cx1.equals("<<<CURRENCY>>>")) {

				nm.carbon[nm.db_number][section_number][loop0] = Float.toString( Float.parseFloat(nm.carbon[nm.db_number][section_number][loop0]) * Float.parseFloat(sectionxb.getText()) );

			}//***************************


			String testx1 = nm.carbon[nm.db_number][section_number][loop0];
			String testx2 = nm.carbon[nm.db_number][section_number][loop0].replace(cx1,cx2);

			nm.carbon[nm.db_number][section_number][loop0] = nm.carbon[nm.db_number][section_number][loop0].replace(cx1,cx2);


			if (!testx1.equals(testx2)) {

				System.out.println("Update");


				try {

					//database
					//jdb_driver.s.execute("UPDATE listings SET " + nm.db_string[section_number] + "='" + testx2 + "' WHERE item_id='" + nm.carbon[nm.db_number][nm.item_id_xx][loop0] + "'");

					PreparedStatement updateemp = jdb_driver.conn.prepareStatement("UPDATE listings SET " + nm.db_string[section_number] + "= ? WHERE item_id='" + nm.carbon[nm.db_number][nm.item_id_xx][loop0] + "'");
			      	updateemp.setString(1, testx2);
		            updateemp.executeUpdate();

				} catch (Exception e) {e.printStackTrace();}


			}//************************



			System.out.println(nm.carbon[nm.db_number][section_number][loop0]);


		}//for******************************************************************


		l0.setText("100% Complete."); 

		pullThePlug();
	

	}//replacex









	public void replacex_selected() {//replace a with b


		for (int loop0 = 0; loop0 < nm.carbon[nm.db_number][0].length; loop0++) {


			cx0 = nm.carbon[nm.db_number][section_number][loop0];
			cx1 = sectionxa.getText();
			cx2 = sectionxb.getText();
			l0.setText((loop0 * 100 / nm.carbon[nm.db_number][0].length) + "% Complete."); 

			if (nm.selected_int[loop0] == 1) {

				nm.carbon[nm.db_number][section_number][loop0] = nm.carbon[nm.db_number][section_number][loop0].replace(cx1,cx2);


				try {

					//database
					//jdb_driver.s.execute("UPDATE listings SET " + nm.db_string[section_number] + "='" + cx2 + "' WHERE " + nm.db_string[section_number] + "='" + cx1 + "' AND item_id='" + nm.carbon[nm.db_number][nm.item_id_xx][loop0] + "'");

					PreparedStatement updateemp = jdb_driver.conn.prepareStatement("UPDATE listings SET " + nm.db_string[section_number] + "= ? WHERE " + nm.db_string[section_number] + "='" + cx1 + "' AND item_id='" + nm.carbon[nm.db_number][nm.item_id_xx][loop0] + "'");
			      	updateemp.setString(1, cx2);
		            updateemp.executeUpdate();

				} catch(Exception e) {e.printStackTrace();}

				System.out.println(nm.carbon[nm.db_number][section_number][loop0]);

			}//*****************************

		}//for******************************************************************


		l0.setText("100% Complete."); 

		pullThePlug();

	}//***********************************************














	public void replacex_all() {//replace a with b

		for (int loop0 = 0; loop0 < nm.carbon[nm.db_number][0].length; loop0++){

			cx0 = nm.carbon[nm.db_number][section_number][loop0];
			cx1 = sectionxa.getText();
			cx2 = sectionxb.getText();
			
			nm.carbon[nm.db_number][section_number][loop0] = nm.carbon[nm.db_number][section_number][loop0].replace(cx1,cx2);

			System.out.println(nm.carbon[nm.db_number][section_number][loop0]);

		}//*********************************************************************


		try{

			int loop0 = 0;
			int loop1 = 0;

	        //load the new items
			jdb_driver.s = jdb_driver.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			//jdb_driver.s.setMaxRows(1); 
	        jdb_driver.rs = jdb_driver.s.executeQuery("SELECT item_id," + nm.db_string[section_number] + " FROM listings");


	        jdb_driver.rs.last();
            loop0 = jdb_driver.rs.getRow();


	        jdb_driver.rs.beforeFirst();

		    while (jdb_driver.rs.next()) {

		    	l0.setText((loop1 * 100 / loop0) + "% Complete."); 

				String newstringx = jdb_driver.rs.getString(2);

				String newstringx2 = newstringx.replace(cx1,cx2);

				if (!newstringx.equals(newstringx2)) {

					//database
					//jdb_driver.s2.execute("UPDATE listings SET " + nm.db_string[section_number] + "='" + newstringx2 + "' WHERE item_id='" + jdb_driver.rs.getString(1) + "'");

					PreparedStatement updateemp = jdb_driver.conn.prepareStatement("UPDATE listings SET " + nm.db_string[section_number] + "= ? WHERE item_id='" + jdb_driver.rs.getString(1) + "'");
			      	updateemp.setString(1, newstringx2);
		            updateemp.executeUpdate();

				}//*********************************

				loop1++;

			}//*************************

		} catch (Exception e) {e.printStackTrace();}


		l0.setText("100% Complete."); 

		pullThePlug();

	}//***********************************************












//workers end***************************************************************************************
//workers end***************************************************************************************









public void actionPerformed(ActionEvent event) {


	if(event.getSource() == cb_column){

       	JComboBox cb = (JComboBox) event.getSource();
        Object newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < nm.db_string.length; loop1++){//s1x

			if (nm.db_string[loop1].equals(newItem)) {

				section_number = loop1; 
				System.out.println("yyyx " + loop1);

			}//***************************************

		}//************************************************************
	
	}//not used



	if (event.getSource() == b0) {replacex();}//
	if (event.getSource() == b1) {replacex_selected();}//
	if (event.getSource() == b2) {replacex_all();}//

	try {

		nm.carbon[4][0][69] = Integer.toString(section_number);
		nm.carbon[4][0][70] = sectionxa.getText();
		nm.carbon[4][0][71] = sectionxb.getText();

	} catch (Exception e) {}


}//action**




    public static void main(String[] args){

		jdb_replace_1 xr = new jdb_replace_1();

    }//main






    public void pullThePlug() {

   	 	System.out.println("PULL THE PLUG");

    	nm.replace_window_open = false;

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull




}//last
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




public class dazzle_shipping_settings extends JFrame implements ActionListener{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 700;
int xzy = 700;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JTextField ss_url = new JTextField("", 20);
JTextField ss_user = new JTextField("", 20);
JTextField ss_pass = new JTextField("", 20);
JTextField ss_key = new JTextField("", 20);
JTextField ftp_user = new JTextField("", 20);
JTextField ftp_pass = new JTextField("", 20);
JTextField ftp_server = new JTextField("", 20);
JTextField ftp_get = new JTextField("", 20);
JTextField ftp_post = new JTextField("", 20);
JTextField program_location = new JTextField("", 20);
JTextField template_us = new JTextField("", 20);
JTextField template_worldwide = new JTextField("", 20);
JTextField template_XML = new JTextField("", 20);
JTextField template_XML_POSTBACK = new JTextField("", 20);
JTextField label_save_folder = new JTextField("", 20);
JTextField file_name = new JTextField("", 20);

JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);

JLabel ss_url_i = new JLabel("Shipping System URL", JLabel.LEFT);
JLabel ss_user_i = new JLabel("Shipping System User", JLabel.LEFT);
JLabel ss_pass_i = new JLabel("Shipping System Pass", JLabel.LEFT);
JLabel ss_key_i = new JLabel("Shipping System Key", JLabel.LEFT);
JLabel ftp_user_i = new JLabel("FTP User", JLabel.LEFT);
JLabel ftp_pass_i = new JLabel("FTP Password", JLabel.LEFT);
JLabel ftp_server_i = new JLabel("FTP Server", JLabel.LEFT);
JLabel ftp_get_i = new JLabel("FTP Local File", JLabel.LEFT);
JLabel ftp_post_i = new JLabel("FTP Post Folder", JLabel.LEFT);
JLabel header1_i = new JLabel("Dazzle Program Settings", JLabel.LEFT);
JLabel header2_i = new JLabel("FTP Label Settings", JLabel.LEFT);
JLabel header3_i = new JLabel("Online Shipping System Settings", JLabel.LEFT);
JLabel program_location_i = new JLabel("Program Location", JLabel.LEFT);
JLabel template_us_i = new JLabel("U.S. .lyt Location", JLabel.LEFT);
JLabel template_worldwide_i = new JLabel("Worldwide .lyt Location", JLabel.LEFT);
JLabel template_XML_i = new JLabel("XML Template Location", JLabel.LEFT);
JLabel template_XML_POSTBACK_i = new JLabel("XML Postback Location", JLabel.LEFT);
JLabel label_save_folder_i = new JLabel("Label output Location", JLabel.LEFT);
JLabel file_name_i = new JLabel("PDF File Name", JLabel.LEFT);
JLabel program_location_r = new JLabel("[[program_location]]", JLabel.LEFT);
JLabel template_us_r = new JLabel("[[shipping_1]]", JLabel.LEFT);
JLabel template_worldwide_r = new JLabel("[[shipping_2]]", JLabel.LEFT);
JLabel template_XML_r = new JLabel("[[layout_template]]", JLabel.LEFT);
JLabel template_XML_POSTBACK_r = new JLabel("[[postback_template]]", JLabel.LEFT);
JLabel label_save_folder_r = new JLabel("[[label_output]]", JLabel.LEFT);
JLabel file_name_r = new JLabel("String + [[id]] + .pdf", JLabel.LEFT);

JLabel build_label_yes_l = new JLabel("Build PDF", JLabel.LEFT);
JLabel label_change_name_yes_l = new JLabel("Change name", JLabel.LEFT);
JLabel ftp_label_yes_l = new JLabel("FTP label", JLabel.LEFT);
JLabel shipped_yes_l = new JLabel("Mark shipped", JLabel.LEFT);
JLabel feedback_yes_l = new JLabel("Post feedback", JLabel.LEFT);
JLabel shipping_order_yes_l = new JLabel("Post order", JLabel.LEFT);

JComboBox match_type = new JComboBox();
JComboBox match_column = new JComboBox();
JCheckBox build_label_yes = new JCheckBox();
JCheckBox label_change_name_yes = new JCheckBox();
JCheckBox ftp_label_yes = new JCheckBox();
JCheckBox shipped_yes = new JCheckBox();
JCheckBox feedback_yes = new JCheckBox();
JCheckBox shipping_order_yes = new JCheckBox();

JButton savex = new JButton("Save");

JButton file1 = new JButton("...");
JButton file2 = new JButton("...");
JButton file3 = new JButton("...");
JButton file4 = new JButton("...");
JButton file5 = new JButton("...");
JButton file6 = new JButton("...");

JButton file7 = new JButton("Save");





dazzle_shipping_settings(){//****************************

	super("Dazzle Shipping Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex_x(); nm.shipping_settings_open = false;}});



	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	header1_i.setPreferredSize(new Dimension(610, 20));
	header2_i.setPreferredSize(new Dimension(380, 20));
	header3_i.setPreferredSize(new Dimension(380, 20));


	program_location_i.setPreferredSize(new Dimension(140, 20));
	template_us_i.setPreferredSize(new Dimension(140, 20));
	template_worldwide_i.setPreferredSize(new Dimension(140, 20));
	template_XML_i.setPreferredSize(new Dimension(140, 20));         
	template_XML_POSTBACK_i.setPreferredSize(new Dimension(140, 20)); 
	label_save_folder_i.setPreferredSize(new Dimension(140, 20));     
	file_name_i.setPreferredSize(new Dimension(140, 20));             

	program_location_r.setPreferredSize(new Dimension(180, 20));
	template_us_r.setPreferredSize(new Dimension(180, 20));
	template_worldwide_r.setPreferredSize(new Dimension(180, 20));
	template_XML_r.setPreferredSize(new Dimension(180, 20));
	template_XML_POSTBACK_r.setPreferredSize(new Dimension(180, 20));
	label_save_folder_r.setPreferredSize(new Dimension(180, 20));
	file_name_r.setPreferredSize(new Dimension(225, 20));

	ftp_user_i.setPreferredSize(new Dimension(140, 20));
	ftp_pass_i.setPreferredSize(new Dimension(140, 20));
	ftp_server_i.setPreferredSize(new Dimension(140, 20));
	ftp_get_i.setPreferredSize(new Dimension(140, 20));
	ftp_post_i.setPreferredSize(new Dimension(140, 20));

	ss_url_i.setPreferredSize(new Dimension(140, 20));
	ss_user_i.setPreferredSize(new Dimension(140, 20));
	ss_pass_i.setPreferredSize(new Dimension(140, 20));
	ss_key_i.setPreferredSize(new Dimension(140, 20));


	try {

		if (nm.carbon[4][0][20].equals("1")) {build_label_yes.setSelected(true);}
		if (nm.carbon[4][0][21].equals("1")) {label_change_name_yes.setSelected(true);}
		if (nm.carbon[4][0][22].equals("1")) {ftp_label_yes.setSelected(true);}
		if (nm.carbon[4][0][23].equals("1")) {shipping_order_yes.setSelected(true);}

		if (nm.carbon[4][0][42].equals("1")) {feedback_yes.setSelected(true);}
		if (nm.carbon[4][0][43].equals("1")) {shipped_yes.setSelected(true);}

	} catch (Exception e) {nm.carbon[4][0][42] = "0"; nm.carbon[4][0][43] = "0";}



	build_label_yes_l.setPreferredSize(new Dimension(120, 20));          
	label_change_name_yes_l.setPreferredSize(new Dimension(120, 20));    
	ftp_label_yes_l.setPreferredSize(new Dimension(120, 20));            
	shipping_order_yes_l.setPreferredSize(new Dimension(120, 20));       
	shipped_yes_l.setPreferredSize(new Dimension(120, 20));              
	feedback_yes_l.setPreferredSize(new Dimension(120, 20));            

	savex.setPreferredSize(new Dimension(120, 30)); 
	savex.addActionListener(this);
	savex.setBackground(nm.st_gray1);

	file1.setPreferredSize(new Dimension(40, 20)); 
	file1.addActionListener(this);
	file1.setBackground(nm.jgray);

	file2.setPreferredSize(new Dimension(40, 20)); 
	file2.addActionListener(this);
	file2.setBackground(nm.jgray);

	file3.setPreferredSize(new Dimension(40, 20)); 
	file3.addActionListener(this);
	file3.setBackground(nm.jgray);

	file4.setPreferredSize(new Dimension(40, 20)); 
	file4.addActionListener(this);
	file4.setBackground(nm.jgray);

	file5.setPreferredSize(new Dimension(40, 20)); 
	file5.addActionListener(this);
	file5.setBackground(nm.jgray);

	file6.setPreferredSize(new Dimension(40, 20)); 
	file6.addActionListener(this);
	file6.setBackground(nm.jgray);




	TitledBorder titled0 = BorderFactory.createTitledBorder("Program Settings");
	titled0.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk0 = new JPanel();
	jpk0.setPreferredSize(new Dimension(685, 262));
	jpk0.setBackground(nm.st_gray1);
	jpk0.setBorder(titled0);
	jpk0.add(header1_i);
	jpk0.add(program_location_i);      jpk0.add(program_location);	     jpk0.add(file1);       jpk0.add(program_location_r);
	jpk0.add(template_us_i);           jpk0.add(template_us);            jpk0.add(file2);       jpk0.add(template_us_r);
	jpk0.add(template_worldwide_i);    jpk0.add(template_worldwide);     jpk0.add(file3);       jpk0.add(template_worldwide_r);
	jpk0.add(template_XML_i);          jpk0.add(template_XML);	         jpk0.add(file4);       jpk0.add(template_XML_r); 
	jpk0.add(template_XML_POSTBACK_i); jpk0.add(template_XML_POSTBACK);  jpk0.add(file5);       jpk0.add(template_XML_POSTBACK_r);
	jpk0.add(label_save_folder_i);     jpk0.add(label_save_folder);      jpk0.add(file6);       jpk0.add(label_save_folder_r);
	jpk0.add(file_name_i);             jpk0.add(file_name);              jpk0.add(file_name_r);


	JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(390, 160));
	jpk1.setBackground(nm.st_gray1);
	jpk1.add(header2_i);
	jpk1.add(ftp_server_i); jpk1.add(ftp_server); 
	jpk1.add(ftp_user_i); 	jpk1.add(ftp_user); 
	jpk1.add(ftp_pass_i); 	jpk1.add(ftp_pass); 
	jpk1.add(ftp_get_i); 	jpk1.add(ftp_get); 
	jpk1.add(ftp_post_i); 	jpk1.add(ftp_post); 


	JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(390, 125));
	jpk2.setBackground(nm.st_gray1);
	jpk2.add(header3_i);
	jpk2.add(ss_url_i); 	jpk2.add(ss_url); 
	jpk2.add(ss_user_i); 	jpk2.add(ss_user); 
	jpk2.add(ss_pass_i); 	jpk2.add(ss_pass); 
	jpk2.add(ss_key_i); 	jpk2.add(ss_key); 
	jpk2.add(feedback_yes); jpk2.add(feedback_yes_l); 
	jpk2.add(shipped_yes); 	jpk2.add(shipped_yes_l); 


	TitledBorder titled1 = BorderFactory.createTitledBorder("FTP Settings");
	titled1.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk2x = new JPanel();
	jpk2x.setPreferredSize(new Dimension(500, 350));
	jpk2x.setBackground(nm.st_gray1);
	jpk2x.setBorder(titled1);
	jpk2x.add(jpk1);
	jpk2x.add(jpk2);


	JPanel jpk3 = new JPanel();
	jpk3.setPreferredSize(new Dimension(170, 310));
	jpk3.setBackground(nm.st_gray1);
	jpk3.add(build_label_yes);        jpk3.add(build_label_yes_l); 
	jpk3.add(label_change_name_yes);  jpk3.add(label_change_name_yes_l); 
	jpk3.add(ftp_label_yes);          jpk3.add(ftp_label_yes_l); 
	jpk3.add(shipped_yes);            jpk3.add(shipped_yes_l); 
	jpk3.add(feedback_yes);           jpk3.add(feedback_yes_l);
	jpk3.add(shipping_order_yes); 	  jpk3.add(shipping_order_yes_l); 


	TitledBorder titled2 = BorderFactory.createTitledBorder("Build Settings");
	titled2.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk4 = new JPanel();
	jpk4.setPreferredSize(new Dimension(180, 350));
	jpk4.setBackground(nm.st_gray1);
	jpk4.setBorder(titled2);
	jpk4.add(jpk3); 


	JPanel jpk5 = new JPanel();
	jpk5.setPreferredSize(new Dimension(685, 40));
	jpk5.setBackground(nm.st_gray1);
	jpk5.add(savex); 


	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(nm.st_gray1);
	cpx.setForeground(nm.whitex);
	cpx.add(jpk0);
	cpx.add(jpk2x);
	cpx.add(jpk4);
	cpx.add(jpk5);

	setVisible(true);


	loadx_x();
	requestFocus();



}//csv_loader_x1********************************************************









	public void loadx_x(){

		program_location.setText(nm.carbon[4][0][45]);
		template_us.setText(nm.carbon[4][0][46]);
		template_worldwide.setText(nm.carbon[4][0][47]);
		template_XML.setText(nm.carbon[4][0][48]);
		template_XML_POSTBACK.setText(nm.carbon[4][0][49]);
		label_save_folder.setText(nm.carbon[4][0][50]);

		ftp_user.setText(nm.carbon[4][0][51]);
		ftp_pass.setText(nm.carbon[4][0][52]);
		ftp_server.setText(nm.carbon[4][0][53]);
		ftp_get.setText(nm.carbon[4][0][54]);
		ftp_post.setText(nm.carbon[4][0][55]);

		ss_url.setText(nm.carbon[4][0][56]);
		ss_pass.setText(nm.carbon[4][0][57]);
		ss_user.setText(nm.carbon[4][0][58]);
		ss_key.setText(nm.carbon[4][0][59]);

		file_name.setText(nm.carbon[4][0][44]);

	}//savex








	public void savex_x(){

		nm.carbon[4][0][45] = program_location.getText();
		nm.carbon[4][0][46] = template_us.getText();
		nm.carbon[4][0][47] = template_worldwide.getText();
		nm.carbon[4][0][48] = template_XML.getText();
		nm.carbon[4][0][49] = template_XML_POSTBACK.getText();
		nm.carbon[4][0][50] = label_save_folder.getText();

		nm.carbon[4][0][51] = ftp_user.getText();
		nm.carbon[4][0][52] = ftp_pass.getText();
		nm.carbon[4][0][53] = ftp_server.getText();
		nm.carbon[4][0][54] = ftp_get.getText();
		nm.carbon[4][0][55] = ftp_post.getText();

		nm.carbon[4][0][56] = ss_url.getText();
		nm.carbon[4][0][57] = ss_pass.getText();
		nm.carbon[4][0][58] = ss_user.getText();
		nm.carbon[4][0][59] = ss_key.getText();


		if (build_label_yes.isSelected()) {nm.carbon[4][0][20] = "1";} 
		else {nm.carbon[4][0][20] = "0";}

		if (label_change_name_yes.isSelected()) {nm.carbon[4][0][21] = "1";} 
		else {nm.carbon[4][0][21] = "0";}

		if (ftp_label_yes.isSelected()) {nm.carbon[4][0][22] = "1";} 
		else {nm.carbon[4][0][22] = "0";}

		if (feedback_yes.isSelected()) {nm.carbon[4][0][42] = "1";} 
		else {nm.carbon[4][0][42] = "0";}

		if (shipped_yes.isSelected()) {nm.carbon[4][0][43] = "1";} 
		else {nm.carbon[4][0][43] = "0";}

		if (shipping_order_yes.isSelected()) {nm.carbon[4][0][23] = "1";} 
		else {nm.carbon[4][0][23] = "0";}

		nm.carbon[4][0][44] = file_name.getText();

	}//savex





	//handel all the button clicks. 
	public void actionPerformed(ActionEvent event) {











	}//actionPerformed








    public static void main(){

		dazzle_shipping_settings xr = new dazzle_shipping_settings();

    }//main







}//last****************************************
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;


import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;






public class combo_generator1 extends JFrame implements ActionListener{

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
Dimension jd = new Dimension(1,1);
int xzx = 560;
int xzy = 450;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


int bytesRead = 0;//read image!!!!

csv_loader1 xcsvx;
int get_file_fail = 0;

int thisc2 = 0;
int thisc3 = 0;
int csv_passes_x = 25;
int runs = 10000;



//**load**

File file_sst_1 = new File("Listings-Running.CSV");
File file_sst_2 = new File(System.getProperty("user.dir") + "\\cs_images");
File file_sst_3 = new File(System.getProperty("user.dir") + "\\cs_images_out");
File file_sst_4 = new File(System.getProperty("user.dir") + "\\templates\\List.CSV");


//**load**



String imagex1 = new String();
String imagex2 = new String();


String main = new String("");
String xlinex = new String("");
String blank = new String("");

String getn_0 = new String("\"Part Number\"");
String getn_1 = new String("\"Title\"");
String getn_2 = new String("\"Fixed Price\"");
String getn_3 = new String("\"Cost\"");
String getn_4 = new String("\"Description\"");
String getn_5 = new String("\"Picture 1\"");
String getn_6 = new String("\"Custom 1\"");
String getn_7 = new String("\"Weight Major\"");
String getn_8 = new String("\"Listing Status\"");

int discountx = 0;

int geti_0 = 0;
int geti_1 = 0;
int geti_2 = 0;
int geti_3 = 0;
int geti_4 = 0;
int geti_5 = 0;
int geti_6 = 0;
int geti_7 = 0;
int geti_8 = 0;

int discount_type_int = 0;

int possible_combo_number = 0;
int ran_int = 0;
int get_file_fail_number = 0;


String title_1 = new String();
String title_2 = new String();

String cx0 = new String();
String cx1 = new String();
String cx2 = new String();
String cx3 = new String();
String cx4 = new String();

int combostart1 = 0;
int combostart2 = 0;
int comboend1 = 0;
int comboend2 = 0;

int ixx0 = 0;
int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0; 
int ix6 = 0; 


String picture_link = new String("/pictures/combo_m_al/");

String change_image_name = new String();

String carbonfiber[][] = new String[runs][500];
String goldfiber[][] = new String[runs][500];
String platinum[][] = new String[runs][500];
String carbon[][] = new String[runs][500];
String carbon_out[] = new String[runs];
String carbon_convert[][] = new String[0][0];

int platinum0 = 0;
int platinum1 = 1;
int platinum2 = 2;
int platinum3 = 3;
int platinum4 = 4;
int platinum5 = 5;
int platinum6 = 6;
int platinum7 = 7;
int platinum8 = 8;

int errorsx = 0;

int carbon_num = 0;

int combo_id = 0;

String ximages[] = new String[runs];
String silver[] = new String[runs];
String cxx0[] = new String[2];

String save_as = new String("COMBO_csv_products.CSV");

File file_csv_1;
File file_csv_2;

Float sx1 = (float) 0.0;
Float sx2 = (float) 0.0;
Float sx3 = (float) 0.0;
Float sx4 = (float) 0.0;



JComboBox start;
JComboBox stop;
JComboBox startcombo;
JComboBox stopcombo;
JComboBox discount_type;

JButton build = new JButton("Build");
JButton test = new JButton("Test");


JLabel combo_image = new JLabel("", JLabel.CENTER);
JTextField image_bin = new JTextField("/cs_images/", 12);
JTextField combo_image_field = new JTextField("/combo_image.jpg", 12);
JTextField profit_m = new JTextField("10", 5);

JLabel infox0 = new JLabel("Images Bin: ", JLabel.LEFT);
JLabel infox1 = new JLabel("loading...", JLabel.LEFT);

JLabel infox2 = new JLabel("Combo Image: ", JLabel.LEFT);
JLabel infox3 = new JLabel("loading...", JLabel.LEFT);

Label infox4 = new Label("test1", Label.LEFT);
JLabel infox5 = new JLabel("Profit Margin %", JLabel.LEFT);
Label infox6 = new Label("test3", Label.LEFT);



Color st_gray1 = new Color(0.8f, 0.8f, 0.8f);//light gray for sites
Color st_gray2 = new Color(0.99f, 0.99f, 0.99f);//darker gray for sites
Color xstripesc = new Color(0.0f, 0.0f, 0.0f);
Color xblue = new Color(0.1f, 0.1f, 0.16f);
Color bluex2 = new Color(0.2f, 0.27f, 0.39f);
Color bluex3 = new Color(0.6f, 0.67f, 0.9f);
Color darkgray04 = new Color(0.04f, 0.04f, 0.04f);//dark gray
Color darkgray08 = new Color(0.08f, 0.08f, 0.08f);//dark gray
Color darkgray01 = new Color(0.156f, 0.156f, 0.156f);//dark gray
Color darkgray70 = new Color(0.3f, 0.3f, 0.3f);
Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color purple = new Color(1.0f, 0.0f, 0.8f);
Color redx = new Color(1.0f, 0.2f, 0.216f);
Color lightgreenx = new Color(0.5f, 0.9f, 0.5f);
Color darkgreenx = new Color(0.1f, 0.3f, 0.1f);
Color darkgreebnx = new Color(0.1f, 0.3f, 0.1f);
Color yellow = bluex2;



Icon imcombo;
Icon imx4;
Icon imx5;


String getfilex = new String();
String filename = new String();








	combo_generator1(){//********************************************************************************************************
	

	super("Alchemist COMBO Generator");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex(); nm.firex = 1;}});



//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));

	try {

		imx5 = new ImageIcon("combo_image.jpg");
		infox3.setText("Loaded");

	} catch (Exception e) {infox3.setText("Failed");}



	System.out.println("");
	System.out.println("COMBINE>>");

	System.out.println("set listpp");

	carbonfiber = nm.carbon_post;

	thisc2 = carbonfiber.length;
	thisc3 = carbonfiber[0].length;

	System.out.println("CSV File: " + thisc2 + " " + thisc3);

	System.out.println("");
	System.out.println("Stage 1.");
	System.out.println("");


	image_bin.setEditable(false);
	combo_image_field.setEditable(false);

	profit_m.setText(nm.carbon[4][0][98]);

	try{

		discountx = Integer.parseInt(profit_m.getText());

	}catch(Exception e){System.out.println("discount failed.");}


	start = new JComboBox(carbonfiber[nm.title_xx]);
	start.setSelectedIndex(0);
	start.addActionListener(this);
	start.setPreferredSize(new Dimension(400, 30));	


	stop = new JComboBox(carbonfiber[nm.title_xx]);
	stop.setSelectedIndex(0);
	stop.addActionListener(this);
	stop.setPreferredSize(new Dimension(400, 30));


	startcombo = new JComboBox(carbonfiber[nm.title_xx]);
	startcombo.setSelectedIndex(0);
	startcombo.addActionListener(this);
	startcombo.setPreferredSize(new Dimension(400, 30));

	
	stopcombo = new JComboBox(carbonfiber[nm.title_xx]);
	stopcombo.setSelectedIndex(0);
	stopcombo.addActionListener(this);
	stopcombo.setPreferredSize(new Dimension(400, 30));
	stopcombo.setSelectedIndex((carbonfiber[nm.title_xx].length -1));



	cxx0[0] = new String("Profit Margin %");
	cxx0[1] = new String("Discount %");

	discount_type = new JComboBox(cxx0);
	discount_type.addActionListener(this);
	discount_type.setPreferredSize(new Dimension(141, 20));

	try{

		System.out.println("xxx " + nm.carbon[4][0][99]);
		discount_type.setSelectedIndex(Integer.parseInt(nm.carbon[4][0][99]));

	}catch(Exception e){discount_type.setSelectedIndex(0); System.out.println("asdfasdfasd");}



	build.setMargin(new Insets(0, 0, 0, 0));
  	build.addActionListener(this);
	build.setPreferredSize(new Dimension(100, 20));
 	//build.setIcon(imx4);
	build.setHorizontalTextPosition(JButton.CENTER);
	build.setForeground(blackx);
	build.setBackground(nm.st_gray1);

	test.setMargin(new Insets(0, 0, 0, 0));
  	test.addActionListener(this);
	test.setPreferredSize(new Dimension(100, 20));
 	//test.setIcon(imx4);
	test.setHorizontalTextPosition(JButton.CENTER);
	test.setForeground(blackx);
	test.setBackground(nm.st_gray1);


	combo_image.setPreferredSize(new Dimension(540, 150));
	combo_image.setOpaque(true); 
	combo_image.setBackground(blackx);
	combo_image.setForeground(whitex);
	combo_image.setIcon(imx5);


	infox0.setPreferredSize(new Dimension(150, 20));
	infox0.setOpaque(true); 
	infox0.setBackground(blackx);
	infox0.setForeground(whitex);

	infox1.setPreferredSize(new Dimension(200, 20));
	infox1.setOpaque(true); 
	infox1.setBackground(blackx);
	infox1.setForeground(whitex);

	infox2.setPreferredSize(new Dimension(150, 20));
	infox2.setOpaque(true); 
	infox2.setBackground(blackx);
	infox2.setForeground(whitex);

	infox3.setPreferredSize(new Dimension(200, 20));
	infox3.setOpaque(true); 
	infox3.setBackground(blackx);
	infox3.setForeground(whitex);

	infox4.setPreferredSize(new Dimension(285, 20));
	//infox4.setOpaque(true); 
	infox4.setBackground(blackx);
	infox4.setForeground(whitex);

	infox5.setPreferredSize(new Dimension(100, 20));
	infox5.setOpaque(true); 
	infox5.setBackground(blackx);
	infox5.setForeground(whitex);

	infox6.setPreferredSize(new Dimension(285, 20));
	//infox6.setOpaque(true); 
	infox6.setBackground(blackx);
	infox6.setForeground(whitex);





	BackgroundPanel jpk0 = new BackgroundPanel();
	jpk0.setPreferredSize(new Dimension(550, 300));
	//jpk0.setBackground(darkgray08);
	jpk0.add(start);
	jpk0.add(stop);
	jpk0.add(combo_image);
	jpk0.add(startcombo);
	jpk0.add(stopcombo);


	JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(550, 105));
	jpk1.setBackground(darkgray08);
	jpk1.add(infox0);
	jpk1.add(image_bin);
	jpk1.add(infox1);

	jpk1.add(infox2);
	jpk1.add(combo_image_field);
	jpk1.add(infox3);

	jpk1.add(infox4);
	jpk1.add(profit_m); jpk1.add(discount_type);

	jpk1.add(infox6);
	jpk1.add(test);
	jpk1.add(build);






	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(blackx);
	//cp.setForeground(whitex);
	cp.add(jpk0);
	cp.add(jpk1);




	setVisible(true);
	System.out.println("set visible");

	combo_id = Integer.parseInt(nm.carbon[4][0][24]);
	if(combo_id < 1000000){combo_id = 1000000;}


	if(file_sst_2.exists()){

		ximages = file_sst_2.list();
		System.out.println("Images: " + ximages.length);
		infox1.setText("Images: " + ximages.length);

	}//***********************
	else{System.out.println("NO images.");}


	}//postid**************************************************************************************************************









	public void displayx(){

		try{

			BufferedInputStream in = new BufferedInputStream(new URL(getfilex).openStream());
			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filename));
			byte xdatax[] = new byte[10240];
			while((bytesRead = in.read(xdatax)) != -1){bout.write(xdatax, 0, bytesRead);}
			bout.close();
			in.close();

		}catch (IOException e){System.out.println("get file fail");}

	}//display************










	public void rebuild_image_name(){

		cx0 = change_image_name;


		for(int loop1 = 1; loop1 < 2000; loop1++){

			ix5 = cx0.indexOf(" ");

			if(ix5 > -1){cx0 = cx0.substring(0, ix5) + "_" + cx0.substring(ix5 + 1, cx0.length());}
			else{break;}

		}//for



		for(int loop1 = 1; loop1 < 2000; loop1++){

			ix5 = cx0.indexOf("\\");

			if(ix5 > -1){cx0 = cx0.substring(0, ix5) + cx0.substring(ix5 + 1, cx0.length());}
			else{break;}	

		}//for



		for(int loop1 = 1; loop1 < 2000; loop1++){

			ix5 = cx0.indexOf("/");

			if(ix5 > -1){cx0 = cx0.substring(0, ix5) + cx0.substring(ix5 + 1, cx0.length());}
			else{break;}	

		}//for



		for(int loop1 = 1; loop1 < 2000; loop1++){

			ix5 = cx0.indexOf("\"");

			if(ix5 > -1){cx0 = cx0.substring(0, ix5) + cx0.substring(ix5 + 1, cx0.length());}
			else{break;}	

		}//for



		for(int loop1 = 1; loop1 < 2000; loop1++){

			ix5 = cx0.indexOf("'");

			if(ix5 > -1){cx0 = cx0.substring(0, ix5) + cx0.substring(ix5 + 1, cx0.length());}
			else{break;}	

		}//for






		change_image_name = cx0;
		System.out.println(change_image_name);

	}//************************










	//profit %
	public void mathx_profit(Float ss1, Float ss2){

		System.out.println("profit");

		sx1 = ss1 * 100;
		sx2 = ss2 * 100;

		sx3 = sx1 + sx2;

		sx3 = sx3 / 100;

	}//math**************





	//profit %
	public void mathx2_profit(Float ss1, Float ss2){

		System.out.println("profit");

		sx1 = ss1 * 100;
		sx2 = ss2 * 100;

		sx3 = sx1 + sx2;

		sx3 = sx3 / 100;

		sx4 = sx3;

		System.out.println("dd " + Float.toString(discountx));
		sx4 = (float) discountx / 100;
		System.out.println("d% " + Float.toString(sx4));
		System.out.println("d3 " + Float.toString(sx3));
		sx4 = sx3 * sx4;
		System.out.println("sx " + Float.toString(sx4));
		ix3 = Math.round(sx4);
		System.out.println("ff " + Float.toString(ix3));

		sx3 = sx3 + ix3;


	}//math**************








	//discount %
	public void mathx(Float ss1, Float ss2){

		System.out.println("discount");

		sx1 = ss1 * 100;
		sx2 = ss2 * 100;

		sx3 = sx1 + sx2;

		sx3 = sx3 / 100;

	}//math**************





	//discount %
	public void mathx2(Float ss1, Float ss2){

		System.out.println("discount");

		sx1 = ss1 * 100;
		sx2 = ss2 * 100;

		sx3 = sx1 + sx2;

		sx4 = sx3;

		sx4 = sx4 / 100;
		sx4 = sx4 / 100;
		sx4 = sx4 * discountx;

		ix3 = Math.round(sx4);

		sx3 = sx3 / 100;

		sx3 = sx3 - ix3;

	}//math**************







	public void cut_image_name(){

		ix3 = imagex1.lastIndexOf("/");
		if(ix3 > -1){imagex1 = imagex1.substring(ix3 + 1, imagex1.length());}


		ix3 = imagex2.lastIndexOf("/");
		if(ix3 > -1){imagex2 = imagex2.substring(ix3 + 1, imagex2.length());}


	}//cut image***************











	public void xrun1(){

		for (int loop1 = combostart2; loop1 < (comboend2 + 1); loop1++){//*****************************************************

			try{
				discountx = Integer.parseInt(profit_m.getText());
			}catch(Exception e){System.out.println("discount failed.");}


			infox4.setText("Build (" + (ran_int +1) + " of " + possible_combo_number + ") Image Build Falures: " + get_file_fail_number);
			ran_int++;
			get_file_fail = 0;


			ix0 = 27;
			ix1 = 26;

			if(goldfiber[1][ixx0].length() < 27){ix0 = goldfiber[1][ixx0].length();}
			if(goldfiber[1][loop1].length() < 26){ix1 = goldfiber[1][loop1].length();}


			platinum[0][loop1] = "[COMBO] " + Integer.toString(combo_id); combo_id++;
			platinum[1][loop1] = goldfiber[1][ixx0].substring(0, ix0) + "+" + goldfiber[1][loop1].substring(0, ix1) + "";
			change_image_name = platinum[1][loop1];
			rebuild_image_name();

			infox6.setText(change_image_name);




			//math for fixed price
			if(discount_type_int == 0){//********** 

				mathx2_profit(Float.parseFloat(goldfiber[3][ixx0]), Float.parseFloat(goldfiber[3][loop1]));
				platinum[2][loop1] = Float.toString(sx3);

			}//************************************
			else{//***********

				mathx2(Float.parseFloat(goldfiber[2][ixx0]), Float.parseFloat(goldfiber[2][loop1]));
				platinum[2][loop1] = Float.toString(sx3);
	
			}//***************



			System.out.println("Fixed price " + platinum[2][loop1]);
			System.out.println("OLD price   " + Float.parseFloat(goldfiber[2][ixx0]) + " " + Float.parseFloat(goldfiber[2][loop1]));

			if(sx3 < Float.parseFloat(goldfiber[2][ixx0])){platinum[2][loop1] = goldfiber[2][ixx0];}
			else if(sx3 < Float.parseFloat(goldfiber[2][loop1])){platinum[2][loop1] = goldfiber[2][loop1];}
			else{System.out.println("Price is ok ***************");}

			System.out.println("Fixed price " + platinum[2][loop1]);
			System.out.println("OLD price   " + Float.parseFloat(goldfiber[2][ixx0]) + " " + Float.parseFloat(goldfiber[2][loop1]));



			//math for cost
			if(discount_type_int == 0){//********** 

				mathx_profit(Float.parseFloat(goldfiber[3][ixx0]), Float.parseFloat(goldfiber[3][loop1]));
				platinum[3][loop1] = Float.toString(sx3);

			}//************************************
			else{//***********

				mathx(Float.parseFloat(goldfiber[3][ixx0]), Float.parseFloat(goldfiber[3][loop1]));
				platinum[3][loop1] = Float.toString(sx3);

			}//***************



			title_1 = "<h2>" + goldfiber[1][ixx0] + "</h2>";
			title_2 = "<h2>" + goldfiber[1][loop1] + "</h2>";

			platinum[4][loop1] = "<h2>These two items together!</h2>" + title_1 + title_2 +"<br>" + goldfiber[4][ixx0] + " <br><br><center><img src='" + nm.carbon[5][1][nm.current_submit_item_a] + "/images/combo_image.jpg'></center><br><br><br>" + goldfiber[4][loop1] + "<br><br>" + goldfiber[6][ixx0] + "<br>" + goldfiber[6][loop1];


			imagex1 = goldfiber[5][ixx0];
			imagex2 = goldfiber[5][loop1];
			cut_image_name();
			rebuild_image();

			platinum[5][loop1] = "[[url]]" + picture_link + change_image_name + ".jpg";
			platinum[6][loop1] = goldfiber[6][ixx0] + "<br>" + goldfiber[6][loop1];
			platinum7 = Integer.parseInt(goldfiber[7][ixx0]) + Integer.parseInt(goldfiber[7][loop1]);



			platinum[8][loop1] = "0";





			for (int loop2 = 0; loop2 < thisc2; loop2++){

				carbon[loop2][loop1] = carbonfiber[loop2][loop1];

			}//for****************************************


			System.out.println("price: " + platinum[2][loop1]);
			System.out.println("cost: " + platinum[3][loop1]);


			carbon[geti_0][loop1] = platinum[0][loop1];
			carbon[geti_1][loop1] = platinum[1][loop1];
			carbon[geti_2][loop1] = platinum[2][loop1];
			carbon[geti_3][loop1] = platinum[3][loop1];
			carbon[geti_4][loop1] = platinum[4][loop1];
			carbon[geti_5][loop1] = platinum[5][loop1];
			carbon[geti_6][loop1] = platinum[6][loop1];
			carbon[geti_7][loop1] = Integer.toString(platinum7);
			carbon[geti_8][loop1] = platinum[8][loop1];


			carbon_out[carbon_num] = new String("");

			for (int loop2 = 0; loop2 < thisc2; loop2++){

				carbon_out[carbon_num] = carbon_out[carbon_num] + carbon[loop2][loop1];
				if(loop2 != thisc2){carbon_out[carbon_num] = carbon_out[carbon_num] + ",";}

				carbon_convert[loop2][carbon_num] = carbon[loop2][loop1];

			}//for****************************************


			System.out.println("BBB " + carbon_num);

			if(get_file_fail == 0){carbon_num++;}


			System.out.println("");
			System.out.println("");


		}//for***************************************************************************************************************


	}//rund***************











	public void xrun(){//*********************************************START HERE****

		carbon_num = 0;

		carbon_convert = new String[nm.carbon[0].length][possible_combo_number];


		get_file_fail_number = 0;
		ran_int = 0;

		carbon_out[carbon_num] = new String("");
		
		for (int loop2 = 0; loop2 < thisc2; loop2++){//thisc2

			carbon_out[carbon_num] = carbon_out[carbon_num] + carbonfiber[loop2][0] + ",";

		}//for****************************************

		//carbon_num++;




		for(int loop1 = combostart1; loop1 < (comboend1 + 1); loop1++){//thisc2 -1

			ixx0 = loop1;


			//System.out.println((loop1 * 100 / thisc3) + "% Compleat.");
			//infox4.setText("Build (" + (loop2 +1) + " of " + thisc2 + ")");
			//infox4.setText((loop1 * 100 / thisc3) + "% Compleat.");

			xrun1();

		}//********************************************





		printx();

		infox6.setText("Output File: " + save_as);


		add_to_db();

		nm.carbon[4][0][24] = Integer.toString(combo_id);



		if(errorsx == 0){

			//nm.firex = 1;
			WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
			Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

		}//if************

	}//***************








	public void add_to_db(){



		ix0 = carbon_num + nm.carbon[0][0].length;
		ix1 = carbon_num;
		ix2 = nm.carbon[0][0].length;
		ix3 = nm.carbon[0].length;
		ix4 = 0;

		System.out.println("ix0 " + ix0);
		System.out.println("ix1 " + ix1);
		System.out.println("ix2 " + ix2);
		System.out.println("ix3 " + ix3);
		System.out.println("ix4 " + ix4);


		String[][] combine_xx = new String[ix3][ix0];

		for (int loop1 = 0; loop1 < ix2; loop1++){//thisc2
		for (int loop2 = 0; loop2 < ix3; loop2++){//thisc2

			combine_xx[loop2][loop1] = nm.carbon[0][loop2][loop1];

		}//***************************************************
		ix4++;
		}//***************************************************

		System.out.println("ix4 " + ix4);

		for (int loop1 = 0; loop1 < ix1; loop1++){//thisc2
		for (int loop2 = 0; loop2 < ix3; loop2++){//thisc2

			combine_xx[loop2][ix4] = carbon_convert[loop2][loop1];
			//System.out.println("  " + carbon_convert[loop2][loop1]);

 			if(loop2 == nm.item_id_xx){
 	
 				ix0 = Integer.parseInt(nm.carbon[4][0][12]);
 				combine_xx[loop2][ix4] = new String("cc" + Integer.toString(ix0)); 
 				ix0++;
 				nm.carbon[4][0][12] = Integer.toString(ix0);
 
 			}//************************


		}//***************************************************
		ix4++;
		}//***************************************************


		nm.carbon[0] = combine_xx;

	}//*********************








	//******************************************************************************
	//******************************************************************************
	public void rebuild_image(){

		System.out.println(imagex1);
		System.out.println(imagex2);

		ix5 = 100;
		ix6 = 100;


		if(imagex1.equals("Thumbs.db")){}
		else if(imagex1.equals("imager.jar")){}
		else if(imagex1.equals("imager2.java")){}
		else if(imagex1.equals("imager2.class")){}
		else{//********************************>


			try{

				BufferedInputStream imageStream1 = new BufferedInputStream(new FileInputStream("cs_images\\" + imagex1));
 				BufferedInputStream imageStream2 = new BufferedInputStream(new FileInputStream("cs_images\\" + imagex2));
 				BufferedInputStream imageStream3 = new BufferedInputStream(new FileInputStream("combo_image.jpg"));

				Image image1 = (Image) ImageIO.read(imageStream1);
				Image image2 = (Image) ImageIO.read(imageStream2);
				Image image3 = (Image) ImageIO.read(imageStream3);

				//System.out.println(image);

 	
				BufferedImage thumbImage = new BufferedImage(600, 600, BufferedImage.TYPE_INT_RGB);

       			Graphics2D g2dx = thumbImage.createGraphics(); 

        		g2dx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

				g2dx.setColor(Color.WHITE);
    			g2dx.fillRect(0, 0, 600, 600);

        		g2dx.drawImage(image1, 150, 0, 300, 300, null);
        		g2dx.drawImage(image2, 150, 300, 300, 300, null);
        		g2dx.drawImage(image3, 0, 240, 600, 120, null);


        		// Write the scaled image to the outputstream
     			File out = new File("cs_images_out\\" + change_image_name + ".jpg");          

        		ImageIO.write(thumbImage, "jpeg", out);

				imageStream1.close();
				imageStream2.close();

			}catch (IOException e){System.out.println("get file fail"); get_file_fail = 1; get_file_fail_number++;}


		}//else ********************************>


	}//************************


















	public void re_build(){


		geti_0 = nm.part_number_xx;
		geti_1 = nm.title_xx;
		geti_2 = nm.item_price_xx;
		geti_3 = nm.item_cost_xx;
		geti_4 = nm.item_description_xx;
		geti_5 = nm.picture_1_xx;
		geti_6 = nm.custom_1_xx;
		geti_7 = nm.item_weight_xx;
		geti_8 = 0;







		for (int loop1 = 0; loop1 < thisc3; loop1++){//s1x//kcountxx

			goldfiber[0][loop1] = carbonfiber[geti_0][loop1].substring(0, carbonfiber[geti_0][loop1].length()); 
			goldfiber[1][loop1] = carbonfiber[geti_1][loop1].substring(0, carbonfiber[geti_1][loop1].length()); 
			goldfiber[2][loop1] = carbonfiber[geti_2][loop1].substring(0, carbonfiber[geti_2][loop1].length()); 
			goldfiber[3][loop1] = carbonfiber[geti_3][loop1].substring(0, carbonfiber[geti_3][loop1].length()); 
			goldfiber[4][loop1] = carbonfiber[geti_4][loop1].substring(0, carbonfiber[geti_4][loop1].length()); 
			goldfiber[5][loop1] = carbonfiber[geti_5][loop1].substring(0, carbonfiber[geti_5][loop1].length()); 
			goldfiber[6][loop1] = carbonfiber[geti_6][loop1].substring(0, carbonfiber[geti_6][loop1].length()); 
			goldfiber[7][loop1] = carbonfiber[geti_7][loop1].substring(0, carbonfiber[geti_7][loop1].length()); 
			goldfiber[8][loop1] = carbonfiber[geti_8][loop1].substring(0, carbonfiber[geti_8][loop1].length()); 

		}//for********************************************************






		for (int loop1 = 0; loop1 < thisc3; loop1++){//s1x//kcountxx
		silver[loop1] = "";
		for (int loop2 = 0; loop2 < 8; loop2++){//s1x//kcountxx

			silver[loop1] = silver[loop1] + goldfiber[loop2][loop1] + ",";

		}//for
		}//for






	}//rebuild**************








	public void printx(){


		try {
       
       		BufferedWriter out = new BufferedWriter(new FileWriter(save_as));

			for (int loop1 = 0; loop1 < carbon_num; loop1++){//s1x//kcountxx

				out.write(carbon_out[loop1]);
				out.newLine();

			}//for


        out.close();
        }catch(IOException e){System.out.println("print fail.");}


	}//print












	public void show_combo_number(){

		System.out.println(combostart1);
		System.out.println(comboend1);


		ix0 = ((comboend1) - (combostart1));
		ix1 = ((comboend2) - (combostart2));

		System.out.println(ix0);
		System.out.println(ix1);


		ix2 = ((ix0 + 1) * (ix1 + 1));

		infox6.setText(Integer.toString(ix2) + " Possible combinations.");
		possible_combo_number = ix2;

	}//show combo number










	public void test_X(){

		show_combo_number();

		errorsx = 0;

		//test price
		for (int loop1 = 0; loop1 < carbonfiber[0].length; loop1++){//s1x//kcountxx

			infox4.setText(carbonfiber[nm.title_xx][loop1]);

		}//for**********************************************************



		//test images

		infox4.setText("Test Images... errors " + Integer.toString(errorsx) + " " + Integer.toString(carbonfiber[0].length));

		BufferedInputStream imagetest;

		for (int loop1 = 0; loop1 < carbonfiber[0].length; loop1++){//s1x//kcountxx
		
			if(errorsx == 0){//*****************

			ix0 = carbonfiber[nm.picture_1_xx][loop1].lastIndexOf("/");
			if(ix0 > -1){cx0 = carbonfiber[nm.picture_1_xx][loop1].substring(ix0, carbonfiber[nm.picture_1_xx][loop1].length());}

			infox4.setText("error " + cx0);


			try{

				imagetest = new BufferedInputStream(new FileInputStream("cs_images\\" + cx0));
	
			}catch(Exception e){errorsx++; System.out.println("IMXX");}


			}//*********************************

		}//for**********************************************************



		if(errorsx == 0){infox4.setText("Test Images... done " + Integer.toString(errorsx));}



	}//********************








public void actionPerformed(ActionEvent event){




		if(event.getSource() == start){

           JComboBox cb = (JComboBox) event.getSource();
           Object newItem = cb.getSelectedItem();

			for (int loop1 = 0; loop1 < thisc3; loop1++){//s1x

				if(carbonfiber[nm.title_xx][loop1].equals(newItem)){combostart1 = loop1;}

			}//*********************

		}//not used


		if(event.getSource() == stop){

           JComboBox cb = (JComboBox) event.getSource();
           Object newItem = cb.getSelectedItem();

			for (int loop1 = 0; loop1 < thisc3; loop1++){//s1x

				if(carbonfiber[nm.title_xx][loop1].equals(newItem)){comboend1 = loop1; startcombo.setSelectedIndex((loop1 + 1));}

			}//*********************
	
		}//not used


		if(event.getSource() == startcombo){

           JComboBox cb = (JComboBox) event.getSource();
           Object newItem = cb.getSelectedItem();
	
			for (int loop1 = 0; loop1 < thisc3; loop1++){//s1x

				if(carbonfiber[nm.title_xx][loop1].equals(newItem)){combostart2 = loop1;}

			}//*********************

		}//not used


		if(event.getSource() == stopcombo){

           JComboBox cb = (JComboBox) event.getSource();
           Object newItem = cb.getSelectedItem();
	
			for (int loop1 = 0; loop1 < thisc3; loop1++){//s1x

				if(carbonfiber[nm.title_xx][loop1].equals(newItem)){comboend2 = loop1; System.out.println("  " + carbonfiber[nm.title_xx][loop1] + " " + loop1 + " " + carbonfiber[nm.title_xx].length);}

			}//*********************

		}//not used





		if(event.getSource() == discount_type){

            JComboBox cb = (JComboBox) event.getSource();
            Object newItem = cb.getSelectedItem();
	
			for (int loop1 = 0; loop1 < cxx0.length; loop1++){//s1x

				if(cxx0[loop1].equals(newItem)){discount_type_int = loop1;}

			}//*********************

		}//not used






		if(event.getSource() == build){test_X(); re_build(); xrun();}//not used
		if(event.getSource() == test){test_X();}//not used
	






}//actionPerformed










	public void savex() {

		nm.carbon[4][0][99] = Integer.toString(discount_type_int);
		nm.carbon[4][0][98] = profit_m.getText();




	}//****************





	public void pull_the_plug(){

		System.out.println("Pull the Plug");

		nm.firex = 1;
		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

		System.out.println("Pull the Plug2");

	}//*************************






    public static void main(String[] args){

		combo_generator1 xxxxr = new combo_generator1();

    }//main






    class BackgroundPanel extends JPanel{
  
        Image image;
  
        public BackgroundPanel(){
    
            try{

                image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/backgroundblack.jpg"), "backgroundblack.jpg"));

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
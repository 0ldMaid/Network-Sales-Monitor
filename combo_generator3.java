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






class combo_generator3{

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








combo_generator3(){//********************************************************************************************************
		

	System.out.println("Custom Build.");

	System.out.println(nm.carbon[0][0].length);


	String carbonx[][] = new String[nm.db_cc_number][(nm.carbon[0][0].length + 1)];

	System.out.println(carbonx[0].length);



	for(int xloopx1 = 0; xloopx1 < nm.carbon[0][0].length; xloopx1++){//***************
	for(int xloopx2 = 0; xloopx2 < nm.db_cc_number; xloopx2++){//***************

		carbonx[xloopx2][xloopx1] = nm.carbon[0][xloopx2][xloopx1];

	}//*************************************************************************
	}//*************************************************************************************



	System.out.println("Section 2");



	for(int xloopx2 = 0; xloopx2 < nm.db_cc_number; xloopx2++){//***************

		carbonx[xloopx2][(carbonx[0].length -1)] = nm.carbon[0][xloopx2][nm.what_item];

	}//*************************************************************************


	System.out.println("Section 3");



	try{

		String nn_name_part = nm.carbon[0][nm.part_number_xx][nm.what_item].replace("[","").replace("]","");
		String nn_name = nm.carbon[0][nm.title_xx][nm.what_item0];

		if((nn_name.length() + nn_name_part.length()) < 75){nn_name = nn_name + " + " + nn_name_part;}
		else{//******************************************

			nn_name = nn_name.substring(0, (75 - nn_name_part.length()));

			int cnc = nn_name.lastIndexOf(" ");

			if(cnc > -1){

				nn_name = nn_name.substring(0, cnc);
			
			}//**********

			nn_name = nn_name = nn_name + " + " + nn_name_part;

		}//**********************************************

		carbonx[nm.title_xx][(carbonx[0].length -1)] = nn_name;

	}catch(Exception e){System.out.println("NN NEW NAME FAIL.");}



	carbonx[nm.part_number_xx][(carbonx[0].length -1)] = "[COMBO][" + nm.carbon[0][nm.item_id_xx][nm.what_item0] + "][" + nm.carbon[0][nm.item_id_xx][nm.what_item] + "]";

	carbonx[nm.item_id_xx][(carbonx[0].length -1)] = "3c" + nm.carbon[4][0][24];
	nm.carbon[4][0][24] = Integer.toString( (Integer.parseInt(nm.carbon[4][0][24]) +1) );




	carbonx[nm.item_cost_xx][(carbonx[0].length -1)] = Float.toString( (Float.parseFloat(nm.carbon[0][nm.item_cost_xx][nm.what_item0]) + Float.parseFloat(nm.carbon[0][nm.item_cost_xx][nm.what_item])) );

	carbonx[nm.item_weight_xx][(carbonx[0].length -1)] = Integer.toString( (Integer.parseInt(nm.carbon[0][nm.item_weight_xx][nm.what_item0]) + Integer.parseInt(nm.carbon[0][nm.item_weight_xx][nm.what_item])) );


	System.out.println("Section 4");



	int xx_int = 0;
	Float xx_fnt0 = (float) 0.0;
	Float xx_fnt1 = (float) 0.0;
	Float xx_fnt2 = (float) 0.0;

	xx_int = Integer.parseInt(nm.carbon[4][0][37]);
	xx_int++;
	nm.carbon[4][0][37] = Integer.toString(xx_int);



	 xx_fnt0 = Float.parseFloat(carbonx[nm.item_cost_xx][(carbonx[0].length -1)]);
	 xx_int = Integer.parseInt(nm.carbon[4][0][37]);

	xx_fnt1 = (float) xx_int / 100;

	xx_fnt2 = (float) xx_fnt0 * xx_fnt1;

	if(xx_fnt1 < Float.parseFloat(nm.carbon[4][0][87])){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][87]);}
	if(Integer.parseInt(carbonx[nm.item_weight_xx][(carbonx[0].length -1)]) > 16 && xx_fnt1 < Float.parseFloat(nm.carbon[4][0][88])){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][88]);}//1lb
	if(Integer.parseInt(carbonx[nm.item_weight_xx][(carbonx[0].length -1)]) > 32 && xx_fnt1 < Float.parseFloat(nm.carbon[4][0][89])){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][89]);}//2lb
	if(Integer.parseInt(carbonx[nm.item_weight_xx][(carbonx[0].length -1)]) > 48 && xx_fnt1 < Float.parseFloat(nm.carbon[4][0][90])){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][90]);}//3lb
	if(Integer.parseInt(carbonx[nm.item_weight_xx][(carbonx[0].length -1)]) > 64 && xx_fnt1 < Float.parseFloat(nm.carbon[4][0][91])){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][91]);}//4lb
	if(Integer.parseInt(carbonx[nm.item_weight_xx][(carbonx[0].length -1)]) > 80 && xx_fnt1 < Float.parseFloat(nm.carbon[4][0][92])){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][92]);}//5lb
	if(Integer.parseInt(carbonx[nm.item_weight_xx][(carbonx[0].length -1)]) > 96 && xx_fnt1 < Float.parseFloat(nm.carbon[4][0][93])){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][93]);}//6lb
	if(Integer.parseInt(carbonx[nm.item_weight_xx][(carbonx[0].length -1)]) > 112 && xx_fnt1 < Float.parseFloat(nm.carbon[4][0][94])){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][94]);}//7lb
	if(Integer.parseInt(carbonx[nm.item_weight_xx][(carbonx[0].length -1)]) > 128 && xx_fnt1 < Float.parseFloat(nm.carbon[4][0][95])){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][95]);}//8lb
	if(Integer.parseInt(carbonx[nm.item_weight_xx][(carbonx[0].length -1)]) > 144 && xx_fnt1 < Float.parseFloat(nm.carbon[4][0][96])){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][96]);}//9lb
	if(xx_fnt1 > 144){xx_fnt1 = (float) Float.parseFloat(nm.carbon[4][0][97]);}

	xx_fnt1 = xx_fnt1 + xx_fnt2;

	xx_fnt1 = xx_fnt0 + xx_fnt1;


	//test for map.

		
	if(Float.parseFloat(nm.carbon[0][nm.item_price_xx][nm.what_item0]) > xx_fnt1){xx_fnt1 = (float) Float.parseFloat(nm.carbon[0][nm.item_price_xx][nm.what_item0]);}
	if(Float.parseFloat(nm.carbon[0][nm.item_price_xx][nm.what_item]) > xx_fnt1){xx_fnt1 = (float) Float.parseFloat(nm.carbon[0][nm.item_price_xx][nm.what_item]);}

	carbonx[nm.item_price_xx][(carbonx[0].length -1)] = Float.toString(xx_fnt1);



	ix0 = carbonx[nm.item_price_xx][(carbonx[0].length -1)].indexOf(".");
	if(ix0 > -1){

		cx0 = carbonx[nm.item_price_xx][(carbonx[0].length -1)].substring(ix0, carbonx[nm.item_price_xx][(carbonx[0].length -1)].length());

		if(cx0.length() == 2){carbonx[nm.item_price_xx][(carbonx[0].length -1)] = carbonx[nm.item_price_xx][(carbonx[0].length -1)] + "0";}
		if(cx0.length() > 3){carbonx[nm.item_price_xx][(carbonx[0].length -1)] = carbonx[nm.item_price_xx][(carbonx[0].length -1)].substring(0, ix0 + 3);}

	}//if********


	System.out.println("Section 5");



	cx3 = "<h3>These two items together!</h3><h3>" + nm.carbon[0][nm.title_xx][nm.what_item0] + "</h3><h3>" + nm.carbon[0][nm.title_xx][nm.what_item] + "<h3><br>";

	cx3 = cx3 + nm.carbon[0][nm.item_description_xx][nm.what_item0];

	cx3 = cx3 + "<br><br><center><img src=\"[[url]]/images/combo_image.jpg\"></center><br><br><br>";

	cx3 = cx3 + nm.carbon[0][nm.item_description_xx][nm.what_item];

	cx3 = cx3 + "<br><br>" + nm.carbon[0][nm.custom_1_xx][nm.what_item0] + "<br>" + nm.carbon[0][nm.custom_1_xx][nm.what_item];

	carbonx[nm.item_description_xx][(carbonx[0].length -1)] = cx3;
	


	System.out.println("Section 6");



	change_image_name = nm.carbon[0][nm.part_number_xx][nm.what_item0].replace("[","").replace("]","").replace(" ","_") + "+" + nm.carbon[0][nm.part_number_xx][nm.what_item].replace("[","").replace("]","").replace(" ","_");

	ix2 = nm.carbon[0][nm.picture_1_xx][nm.what_item0].lastIndexOf("/");
	ix3 = nm.carbon[0][nm.picture_1_xx][nm.what_item].lastIndexOf("/");

	try{

		imagex1 = nm.carbon[0][nm.picture_1_xx][nm.what_item0].substring(ix2 +1, nm.carbon[0][nm.picture_1_xx][nm.what_item0].length());
		imagex2 = nm.carbon[0][nm.picture_1_xx][nm.what_item].substring(ix3 +1, nm.carbon[0][nm.picture_1_xx][nm.what_item].length());

	}catch(Exception e){}


	rebuild_image();


	carbonx[nm.picture_1_xx][(carbonx[0].length -1)] = "[[url]]/pictures/combo_m_al/" + change_image_name + ".jpg";




	System.out.println("Section 6");

	carbonx[ Integer.parseInt(nm.carbon[4][0][38]) ][(carbonx[0].length -1)] = nm.carbon[0][nm.part_number_xx][nm.what_item0];
	carbonx[ Integer.parseInt(nm.carbon[4][0][39]) ][(carbonx[0].length -1)] = nm.carbon[0][nm.part_number_xx][nm.what_item];

	System.out.println("Section 7");



	carbonx[nm.total_on_hand_xx][(carbonx[0].length -1)] = "1";

	carbonx[nm.total_on_hand_xx][nm.what_item0] = Integer.toString( (Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][nm.what_item0]) -1) );

	carbonx[nm.total_on_hand_xx][nm.what_item] = Integer.toString( (Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][nm.what_item]) -1) );


	System.out.println("Section 8");

	nm.carbon[0] = carbonx;

	//JOptionPane.showMessageDialog(null,"Done.");

}//postid**************************************************************************************************************












	//******************************************************************************
	//******************************************************************************
	public void rebuild_image(){

		System.out.println(">> " + imagex1);
		System.out.println(">> " + imagex2);

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
			    File out = new File("combo_m_al\\" + change_image_name + ".jpg");          

			    ImageIO.write(thumbImage, "jpeg", out);

				imageStream1.close();
				imageStream2.close();

			}catch (Exception e){System.out.println("get file fail"); get_file_fail = 1; get_file_fail_number++;}



		}//else ********************************>



	}//************************rebuild








}//last
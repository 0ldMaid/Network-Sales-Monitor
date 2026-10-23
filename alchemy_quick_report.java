import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;






public class alchemy_quick_report extends JFrame implements ActionListener{

csv_loader0 xcsvx;

String version = new String("1.5.0");

int csv_passes_x = 25;
int runs = 5000;

//**load**

File file_iff_1 = new File(System.getProperty("user.dir") + "\\iif_build\\iff_template.iif");
File file_ite_1 = new File(System.getProperty("user.dir") + "\\iif_build\\item_template.iif");
File file_tra_1 = new File(System.getProperty("user.dir") + "\\iif_build\\tran_template.iif");
File file_tra_2 = new File(System.getProperty("user.dir") + "\\iif_build\\tran_template_tax.iif");
File file_csv_1 = new File("Sales-Paid.csv");
File file_ssx_1 = new File("SSi.ini");
File file_sst_1 = new File(System.getProperty("user.dir") + "\\iif_build\\SST_template.csv");

int iff_int = 0;
int tra_int = 0;
int tra_int_tax = 0;
int ite_int = 0;
int csv_int = 0;
int ssx_int = 0;
int out_int = 0;

String IFFTEMP[] = new String[runs];
String TRATEMP[] = new String[runs];
String TRATEMP_TAX[] = new String[runs];
String ITETEMP[] = new String[runs];
String CSVTEMP[] = new String[runs];
String SSXTEMP[] = new String[runs];
String OUTTEMP[] = new String[runs];

String str_iff = new String("iif_build/iff_template.iif");
String str_ite = new String("iif_build/item_template.iif");
String str_tra = new String("iif_build/tran_template.iif");
String str_tra_tax = new String("iif_build/tran_template_tax.iif");
String str_csv = new String("iif_build/Sales-Paid.csv");
String str_ssx = new String("iif_build/SSi.ini");

//**load**


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 460;
int xzy = 365;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


String main = new String("");
String xlinex = new String("");
String blank = new String("");

String getn_0 = new String("\"Date Sold\"");
String getn_1 = new String("\"Buyers.eBay Userid\"");
String getn_2 = new String("\"Part Number\"");
String getn_3 = new String("\"Item Cost\"");
String getn_4 = new String("\"Title\"");
String getn_5 = new String("\"Consignment Commission\"");
String getn_6 = new String("\"PayPal Fees Paid\"");
String getn_7 = new String("\"Final Value Fee\"");
String getn_8 = new String("\"Quantity Sold\"");
String getn_9 = new String("\"Shipping\"");
String getn_10 = new String("\"Actual Shipping\"");
String getn_11 = new String("\"Handling\"");

String getn_13 = new String("\"ShippingAddress.First Name\"");
String getn_14 = new String("\"ShippingAddress.Last Name\"");
String getn_15 = new String("\"ShippingAddress.Address Line 1\"");
String getn_16 = new String("\"ShippingAddress.Address Line 2\"");
String getn_17 = new String("\"ShippingAddress.City\"");
String getn_18 = new String("\"ShippingAddress.State\"");
String getn_19 = new String("\"ShippingAddress.Zip\"");
String getn_20 = new String("\"ShippingAddress.Country\"");

String getn_21 = new String("\"Sales Tax\"");




String cx0 = new String();
String cx1 = new String();
String cx2 = new String();
String cx3 = new String();
String cx4 = new String();


int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0; 
int ix6 = 0; 
int fg = 0;
int fs = 0;
int kcountxx = 0;
int thisx = 0;
int loopc1 = 0;
int thisc2 = 0;//the second carbonfiber array.
int working = 0; 

int nfor_date = 0;
int nfor_name = 1;
int nfor_title = 2;
int nfor_cost = 0;
int nfor_desc = 0;
int nfor_sale_price = 10;
int nfor_paypal = 8;
int nfor_ebay = 9;
int nfor_quantity = 3;
int nfor_shipping = 5;
int nfor_shipping_paid = 6;
int nfor_handling = 7;

int nfor_firt_name = 3;
int nfor_last_name = 5;
int nfor_address1 = 3;
int nfor_address2 = 5;
int nfor_city = 6;
int nfor_state = 7;
int nfor_zip = 7;
int nfor_country = 7;

int nfor_tax = 7;

JButton b0 = new JButton();
JButton b1 = new JButton();
JButton b2 = new JButton();
JButton b3 = new JButton();
JButton b4 = new JButton();
JButton b5 = new JButton();
JButton bx0 = new JButton();
JButton bx1 = new JButton();

Label l0 = new Label();
Label l1 = new Label();
Label l2 = new Label();
Label l3 = new Label();
Label l4 = new Label();
Label l5 = new Label();
Label l6 = new Label();


Label sp0 = new Label("", Label.LEFT);
Label sp1 = new Label("", Label.LEFT);


String carbonfiber[][] = new String[500][runs];
String goldfiber[][] = new String[500][runs];
String d1 = new String();
String d2 = new String();
String switchsx1 = new String("XMX.CSV");
String switchsx2 = new String("XMXR.CSV");
String rep1 = new String();
String rep2 = new String();
String rex = new String(".jpg.gif");
String rexw = new String("");
String save_as = new String("converted_tranactions.iif");


File filex1;
File filex2;
String str0;

Color c1 = new Color(0.1f, 0.1f, 0.1f);
Color c2 = new Color(0.09f, 0.09f, 0.13f);

Icon imx0;
Icon imx1;




alchemy_quick_report(){//********************************************************************************************************
	
	super("Alchemy Converter V.a 1.5.0");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/hex.png")).getImage();
	setIconImage(ximagex);

//get button images from the Jar file.
	imx0 = new ImageIcon(this.getClass().getResource("images/buttonimage.png"));

//get button images from the Jar file.
	imx1 = new ImageIcon(this.getClass().getResource("images/buttonimage1.png"));



	b0 = new JButton("Create Quickbooks IIF");
	b0.setMargin(new Insets(0, 0, 0, 0));  
	b0.addActionListener(this);
	b0.setPreferredSize(new Dimension(350, 80));
	b0.setIcon(imx1);
	b0.setHorizontalTextPosition(JButton.CENTER);
	b0.setForeground(Color.BLACK);


	b1 = new JButton("Quick Report");
	b1.setMargin(new Insets(0, 0, 0, 0));  
	b1.addActionListener(this);
	b1.setPreferredSize(new Dimension(110, 20));
	b1.setIcon(imx0);
	b1.setHorizontalTextPosition(JButton.CENTER);
	b1.setForeground(Color.WHITE);

	b2 = new JButton("Items Only");
	b2.setMargin(new Insets(0, 0, 0, 0));  
	b2.addActionListener(this);
	b2.setPreferredSize(new Dimension(110, 20));
	b2.setIcon(imx0);
	b2.setHorizontalTextPosition(JButton.CENTER);
	b2.setForeground(Color.WHITE);

	b3 = new JButton("Settings");
	b3.setMargin(new Insets(0, 0, 0, 0));  
	b3.addActionListener(this);
	b3.setPreferredSize(new Dimension(110, 20));
	b3.setIcon(imx0);
	b3.setHorizontalTextPosition(JButton.CENTER);
	b3.setForeground(Color.WHITE);

	b4 = new JButton("Settings");
	b4.setMargin(new Insets(0, 0, 0, 0));  
	b4.addActionListener(this);
	b4.setPreferredSize(new Dimension(110, 20));
	b4.setIcon(imx0);
	b4.setHorizontalTextPosition(JButton.CENTER);
	b4.setForeground(Color.WHITE);




	l0 = new Label("Templates Loaded...", Label.LEFT);
	l0.setPreferredSize(new Dimension(400, 20));
	l0.setBackground(c2);
	l0.setForeground(Color.WHITE);

	l1 = new Label("Test...", Label.LEFT);
	l1.setPreferredSize(new Dimension(400, 20));
	l1.setBackground(c2);
	l1.setForeground(Color.WHITE);

	l2 = new Label("Test...", Label.LEFT);
	l2.setPreferredSize(new Dimension(400, 20));
	l2.setBackground(c2);
	l2.setForeground(Color.WHITE);

	l3 = new Label("Test...", Label.LEFT);
	l3.setPreferredSize(new Dimension(400, 20));
	l3.setBackground(c2);
	l3.setForeground(Color.WHITE);

	l4 = new Label("Test...", Label.LEFT);
	l4.setPreferredSize(new Dimension(400, 20));
	l4.setBackground(c2);
	l4.setForeground(Color.WHITE);

	l5 = new Label("Test...", Label.LEFT);
	l5.setPreferredSize(new Dimension(400, 20));
	l5.setBackground(c2);
	l5.setForeground(Color.WHITE);

	l6 = new Label("Save As: " + save_as, Label.LEFT);
	l6.setPreferredSize(new Dimension(400, 20));
	l6.setBackground(c2);
	l6.setForeground(Color.WHITE);





	sp0 = new Label("", Label.LEFT);
	sp0.setPreferredSize(new Dimension(400, 10));
	sp0.setBackground(new Color(0.0f, 0.0f, 0.0f, 1.0f));
	sp0.setForeground(Color.WHITE);

	sp1 = new Label("", Label.LEFT);
	sp1.setPreferredSize(new Dimension(400, 10));
	sp1.setBackground(new Color(0.0f, 0.0f, 0.0f, 0.0f));
	sp1.setForeground(Color.WHITE);





    BackgroundPanel jp0 = new BackgroundPanel();
	jp0.setPreferredSize(new Dimension(450, 460));
	jp0.setBackground(c1);
	jp0.add(l0);
	jp0.add(l1);
	jp0.add(l2);
	jp0.add(l3);
	jp0.add(l4);
	jp0.add(l5);

	jp0.add(sp0);//spacer
	jp0.add(b0);	
	jp0.add(sp1);//spacer

	jp0.add(b1);	
	jp0.add(b2);	
	jp0.add(b3);	
	//jp0.add(b4);	

	jp0.add(l6);


	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(Color.BLACK);
	cp.setForeground(Color.BLACK);
	cp.add(jp0);

	setVisible(true);

	show_load();


}//postid**************************************************************************************************************







	public void loadx0(){
	iff_int = 0;

		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(str_iff)));
		xlinex = blank;
		while ((xlinex = in.readLine()) != null){IFFTEMP[iff_int] = xlinex; iff_int++;}
		in.close();
		}catch(IOException e){working = 0;}

	}//loadx************

	public void loadx1(){
	tra_int = 0;

		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(str_ite)));
		xlinex = blank;
		while ((xlinex = in.readLine()) != null){ITETEMP[ite_int] = xlinex; ite_int++;}
		in.close();
		}catch(IOException e){working = 0;}

	}//loadx************

	public void loadx2(){
	tra_int = 0;

		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(str_tra)));
		xlinex = blank;
		while ((xlinex = in.readLine()) != null){TRATEMP[tra_int] = xlinex; tra_int++;}
		in.close();
		}catch(IOException e){working = 0;}

	}//loadx************

	public void loadx2_tax(){
	tra_int_tax = 0;

		try {
		BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(str_tra_tax)));
		xlinex = blank;
		while ((xlinex = in.readLine()) != null){TRATEMP_TAX[tra_int_tax] = xlinex; tra_int_tax++;}
		in.close();
		}catch(IOException e){working = 0;}

	}//loadx************

	public void loadx3(){
	csv_int = 0;

		try {
		BufferedReader in = new BufferedReader(new FileReader(file_csv_1));
		xlinex = blank;
		while ((xlinex = in.readLine()) != null){CSVTEMP[csv_int] = xlinex; csv_int++;}
		in.close();
		}catch(IOException e){working = 0;}

	}//loadx************

	public void loadx4(){
	ssx_int = 0;

		try {
		BufferedReader in = new BufferedReader(new FileReader(file_ssx_1));
		xlinex = blank;
		while ((xlinex = in.readLine()) != null){SSXTEMP[ssx_int] = xlinex; ssx_int++;}
		in.close();
		}catch(IOException e){working = 0;}

	}//loadx************







	public void show_load(){//**************************************************************************

		working = 1;

		if(working == 1){l0.setText(str_iff); loadx0(); l0.setForeground(Color.GREEN);}
		if(working == 0){l0.setForeground(Color.RED);}

		if(working == 1){l0.setText(str_ite); loadx1();}
		if(working == 0){l0.setForeground(Color.RED);}

		if(working == 1){l0.setText(str_tra); loadx2();}
		if(working == 0){l0.setForeground(Color.RED);}

		if(working == 1){l0.setText(str_tra_tax); loadx2_tax();}
		if(working == 0){l0.setForeground(Color.RED);}

		if(working == 1){l0.setText(str_csv); loadx3();}
		if(working == 0){l0.setForeground(Color.RED);}

		if(working == 1){l0.setText(str_ssx); loadx4();}
		if(working == 0){l0.setForeground(Color.RED);}

		if(working == 1){l0.setText("Loading files complete."); show_test();}

	}//showload.




	public void show_test(){

		//csv slip
		if(working == 1){loadxcsv(); check_csv(); fix_name(); fix_price(); fix_address(); fix_item_name(); fix_date(); compress();}
		if(working == 0){l0.setText(str_ssx); l0.setForeground(Color.RED);}

	}//showload. 


	//load************************************
	//load************************************





	//break up the CSV file
	public void loadxcsv(){


		xcsvx = new csv_loader0(file_csv_1);

		carbonfiber = csv_loader0.getData0();
		thisc2 = csv_loader0.getData1();
		csv_int = csv_loader0.getData2();


		if(thisc2 > 11){l1.setForeground(Color.GREEN); l1.setText("CSV File is loaded. " + thisc2 + " sections and " + csv_int + " rows.");}
		else{l1.setForeground(Color.RED); l1.setText("CSV File is did not pass test1..." + thisc2 + " sections and " + csv_int + " rows.");}

	}//loadx









	public void compress(){//************************************************************************************************************************************

		int goodx = 0;


		for (int loop1 = 0; loop1 < csv_int; loop1++){

			goldfiber[0][loop1] = carbonfiber[nfor_date][loop1];
			goldfiber[1][loop1] = carbonfiber[nfor_name][loop1];
			goldfiber[2][loop1] = carbonfiber[nfor_title][loop1];
			goldfiber[3][loop1] = carbonfiber[nfor_cost][loop1];
			goldfiber[4][loop1] = carbonfiber[nfor_desc][loop1];
			goldfiber[5][loop1] = carbonfiber[nfor_sale_price][loop1];
			goldfiber[6][loop1] = carbonfiber[nfor_paypal][loop1];
			goldfiber[7][loop1] = carbonfiber[nfor_ebay][loop1];
			goldfiber[8][loop1] = carbonfiber[nfor_quantity][loop1];
			goldfiber[9][loop1] = carbonfiber[nfor_shipping][loop1];
			goldfiber[10][loop1] = carbonfiber[nfor_shipping_paid][loop1];
			goldfiber[11][loop1] = carbonfiber[nfor_handling][loop1];
			goldfiber[12][loop1] = carbonfiber[199][loop1];

			goldfiber[13][loop1] = carbonfiber[nfor_firt_name][loop1];
			goldfiber[14][loop1] = carbonfiber[nfor_last_name][loop1];
			goldfiber[15][loop1] = carbonfiber[nfor_address1][loop1];
			goldfiber[16][loop1] = carbonfiber[nfor_address2][loop1];
			goldfiber[17][loop1] = carbonfiber[nfor_city][loop1];
			goldfiber[18][loop1] = carbonfiber[nfor_state][loop1];
			goldfiber[19][loop1] = carbonfiber[nfor_zip][loop1];
			goldfiber[20][loop1] = carbonfiber[nfor_country][loop1];

			goldfiber[21][loop1] = carbonfiber[nfor_tax][loop1];

		}//for******************************************


		carbonfiber = goldfiber;


	}//compress**************************************************************************************************************************************************








	public void check_csv(){//

		int test_3_x = 0; 

		l2.setForeground(Color.RED);
		l2.setText("CSV File is did not pass test1...");



		for (int loop1 = 0; loop1 < thisc2; loop1++){

			l2.setText("CSV File did not pass test2... line: " + loop1 + " of " + thisc2);

			if(carbonfiber[loop1][0].equals(getn_0)){nfor_date = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_1)){nfor_name = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_2)){nfor_title = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_3)){nfor_cost = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_4)){nfor_desc = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_5)){nfor_sale_price = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_6)){nfor_paypal = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_7)){nfor_ebay = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_8)){nfor_quantity = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_9)){nfor_shipping = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_10)){nfor_shipping_paid = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_11)){nfor_handling = loop1; test_3_x++;}

			if(carbonfiber[loop1][0].equals(getn_13)){nfor_firt_name = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_14)){nfor_last_name = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_15)){nfor_address1 = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_16)){nfor_address2 = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_17)){nfor_city = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_18)){nfor_state = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_19)){nfor_zip = loop1; test_3_x++;}
			if(carbonfiber[loop1][0].equals(getn_20)){nfor_country = loop1; test_3_x++;}

			if(carbonfiber[loop1][0].equals(getn_21)){nfor_tax = loop1; test_3_x++;}

		}//for 




		l2.setForeground(Color.GREEN);
		l2.setText("CSV File is good... TEST = " + test_3_x);

		if(test_3_x < 19){

			l2.setForeground(Color.RED);
			l2.setText("CSV File is bad... TEST = " + test_3_x);

		}//if


	}//check






//workers***************************************************************************************
//workers***************************************************************************************



	public void fix_date(){

		System.out.println("CSV Date section...");
		l4.setForeground(Color.RED);

		for (int loop1 = 0; loop1 < csv_int; loop1++){

			cx0 = carbonfiber[nfor_date][loop1];
			cx0 = cx0.substring(1, 10);
			carbonfiber[nfor_date][loop1] = cx0;

			//System.out.println(carbonfiber[0][loop1]);

		}//*******************************************


		for (int loop1 = 0; loop1 < csv_int; loop1++){

			cx0 = carbonfiber[nfor_date][loop1];

			ix0 = cx0.indexOf("Jan"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "01" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("Feb"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "02" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("Mar"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "03" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("Apr"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "04" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("May"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "05" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("Jun"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "06" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("Jul"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "07" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("Aug"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "08" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("Sep"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "09" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("Oct"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "10" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("Nov"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "11" + cx0.substring(6, cx0.length());}
			ix0 = cx0.indexOf("Dec"); if(ix0 > -1){cx0 = cx0.substring(0, 3) + "12" + cx0.substring(6, cx0.length());}

			carbonfiber[nfor_date][loop1] = cx0;

			//System.out.println(carbonfiber[nfor_date][loop1]);

		}//*******************************************




		l4.setForeground(Color.GREEN);
		l4.setText("CSV Date section fixed...");

	}//********************






	public void fix_item_name(){

		for (int loop1 = 0; loop1 < csv_int; loop1++){

		cx0 = carbonfiber[nfor_title][loop1];
		cx0 = cx0.substring(1, cx0.length() - 1);

			for (int loop2 = 0; loop2 < 10; loop2++){
				ix0 = cx0.indexOf("'");
				if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************

			for (int loop2 = 0; loop2 < 10; loop2++){
				ix0 = cx0.indexOf("/");
				if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************

			for (int loop2 = 0; loop2 < 10; loop2++){
				ix0 = cx0.indexOf("\"");
				if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************

			for (int loop2 = 0; loop2 < 10; loop2++){
				ix0 = cx0.indexOf("-");
				if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************

			for (int loop2 = 0; loop2 < 10; loop2++){
				ix0 = cx0.indexOf("!");
				if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************

			for (int loop2 = 0; loop2 < 10; loop2++){
				ix0 = cx0.indexOf(".");
				if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************


			if(cx0.length() > 30){cx0 = cx0.substring(0, 20);}

			carbonfiber[nfor_title][loop1] = cx0;
			//System.out.println(carbonfiber[2][loop1]);

		}//*******************************************

	}//********************








	public void fix_item_desc(){

		for (int loop1 = 0; loop1 < csv_int; loop1++){

		cx0 = carbonfiber[nfor_desc][loop1];
		cx0 = cx0.substring(1, cx0.length() - 1);

			for (int loop2 = 0; loop2 < 10; loop2++){
			ix0 = cx0.indexOf("'");
			if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************

			for (int loop2 = 0; loop2 < 10; loop2++){
			ix0 = cx0.indexOf("/");
			if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************

			for (int loop2 = 0; loop2 < 10; loop2++){
			ix0 = cx0.indexOf("\"");
			if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************

			for (int loop2 = 0; loop2 < 10; loop2++){
			ix0 = cx0.indexOf("-");
			if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************

			for (int loop2 = 0; loop2 < 10; loop2++){
			ix0 = cx0.indexOf("!");
			if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************

			for (int loop2 = 0; loop2 < 10; loop2++){
			ix0 = cx0.indexOf(".");
			if(ix0 > -1){cx0 = cx0.substring(0, ix0) + cx0.substring(ix0 + 1, cx0.length());}
			}//*******************************************


		if(cx0.length() > 30){cx0 = cx0.substring(0, 20);}

		carbonfiber[nfor_desc][loop1] = cx0;
		//System.out.println(carbonfiber[loop1][2]);

		}//*******************************************

	}//********************














	public void fix_name(){

		l3.setForeground(Color.RED);
		l3.setText("CSV Name section...");


			for (int loop1 = 0; loop1 < csv_int; loop1++){

				System.out.println("CSV name section: " + carbonfiber[nfor_name][loop1] + " " + carbonfiber[nfor_name + 1][loop1]);
				System.out.println(carbonfiber[nfor_name][loop1] + " " + carbonfiber[nfor_name + 1][loop1]);

				cx0 = carbonfiber[nfor_name][loop1];
				cx0 = cx0.substring(1, cx0.length() -1);
				carbonfiber[nfor_name][loop1] = cx0;

				//System.out.println(carbonfiber[nfor_name][loop1]);

			}//*******************************************


		l3.setForeground(Color.GREEN);
		l3.setText("CSV Name section fixed...");

	}//********************







	public void fix_price(){


		Float fx0 = (float) 0.0;
		int fxc = 0;
		Float fx1 = (float) 0.0;
		Float fx2 = (float) 0.0;
		Float fx3 = (float) 0.0;
		Float fx4 = (float) 0.0;
		Float fx5 = (float) 0.0;
		Float fx51 = (float) 0.0;//tax
		Float fx6 = (float) 0.0;



		for (int loop1 = 1; loop1 < csv_int; loop1++){



			for (int loop1x = 1; loop1x < 10; loop1x++){

			ix0 = carbonfiber[nfor_paypal][loop1].indexOf("\"");
			if(ix0 > -1){carbonfiber[nfor_paypal][loop1] = carbonfiber[nfor_paypal][loop1].substring(0, ix0) + carbonfiber[nfor_paypal][loop1].substring(ix0 + 1, carbonfiber[nfor_paypal][loop1].length());}
			else{break;}

			}//*******************************************



				fx0 = (Float.parseFloat(carbonfiber[nfor_sale_price][loop1]) * 100);//start sale price
				fxc =  Integer.parseInt(carbonfiber[nfor_quantity][loop1]);//quantity
				fx1 = (Float.parseFloat(carbonfiber[nfor_shipping][loop1]) * 100);//shipping
				fx2 = (Float.parseFloat(carbonfiber[nfor_shipping_paid][loop1]) * 100);//shipping paid
				fx3 = (Float.parseFloat(carbonfiber[nfor_handling][loop1]) * 100);//handling
				fx4 = (Float.parseFloat(carbonfiber[nfor_paypal][loop1]) * 100);//paypal
				fx5 = (Float.parseFloat(carbonfiber[nfor_ebay][loop1]) * 100);//ebay
				fx51 = (Float.parseFloat(carbonfiber[nfor_tax][loop1]) * 100);//tax

				fx6 = (float)(Math.round((fx0 + fx1 + fx3 + fx51) - (fx2 + fx4 + fx5)));
				fx6 = (fx6 / 100);

				System.out.println("mm+ " + Math.round((fx0 + fx1 + fx3)));
				System.out.println("mm- " + Math.round((fx2 + fx4 + fx5)));


				System.out.println();
				System.out.println(fx0);
				System.out.println(fx1);
				System.out.println(fx2);
				System.out.println(fx3);
				System.out.println(fx4);
				System.out.println(fx5);
				System.out.println("");
				System.out.println(fx6);

				cx0 = Float.toString(fx6);

				ix0 = cx0.indexOf(".");

				if(ix0 > -1 && ix0 == cx0.length() - 6){

					if(cx0.substring(ix0 + 3, ix0 + 4).equals("9")){

						System.out.println(cx0);
						System.out.println(cx0.substring(ix0 + 2, ix0 + 3));

						if(cx0.substring(ix0 + 2, ix0 + 3).equals("0")){cx0 = cx0.substring(0, ix0 + 2) + "1";}
						else if(cx0.substring(ix0 + 2, ix0 + 3).equals("1")){cx0 = cx0.substring(0, ix0 + 2) + "2";}
						else if(cx0.substring(ix0 + 2, ix0 + 3).equals("2")){cx0 = cx0.substring(0, ix0 + 2) + "3";}
						else if(cx0.substring(ix0 + 2, ix0 + 3).equals("3")){cx0 = cx0.substring(0, ix0 + 2) + "4";}
						else if(cx0.substring(ix0 + 2, ix0 + 3).equals("4")){cx0 = cx0.substring(0, ix0 + 2) + "5";}
						else if(cx0.substring(ix0 + 2, ix0 + 3).equals("5")){cx0 = cx0.substring(0, ix0 + 2) + "6";}
						else if(cx0.substring(ix0 + 2, ix0 + 3).equals("6")){cx0 = cx0.substring(0, ix0 + 2) + "7";}
						else if(cx0.substring(ix0 + 2, ix0 + 3).equals("7")){cx0 = cx0.substring(0, ix0 + 2) + "8";}
						else if(cx0.substring(ix0 + 2, ix0 + 3).equals("8")){cx0 = cx0.substring(0, ix0 + 2) + "9";}
						else if(cx0.substring(ix0 + 2, ix0 + 3).equals("9")){cx0 = cx0.substring(0, ix0 + 1) + "0";}
						else{l2.setForeground(Color.RED); working = 0;}

						System.out.println(cx0);


					}//if*******************************************
					else if(cx0.substring(ix0 + 3, ix0 + 4).equals("0")){cx0 = cx0.substring(0, cx0.length() - 3);}
					else{l3.setForeground(Color.RED);}

				}//if

			carbonfiber[199][loop1] = cx0;

			System.out.println(cx0);

			if(working == 1){System.out.println("CSV math sections converted..."); l3.setForeground(Color.GREEN);}


		}//*******************************************for

	}//********************price






	public void fix_address(){

		l3.setForeground(Color.RED);
		l3.setText("CSV address...");


		for (int loop1 = 0; loop1 < csv_int; loop1++){

			carbonfiber[nfor_firt_name][loop1] = carbonfiber[nfor_firt_name][loop1].substring(1, carbonfiber[nfor_firt_name][loop1].length() -1);
			carbonfiber[nfor_last_name][loop1] = carbonfiber[nfor_last_name][loop1].substring(1, carbonfiber[nfor_last_name][loop1].length() -1);
			carbonfiber[nfor_address1][loop1] = carbonfiber[nfor_address1][loop1].substring(1, carbonfiber[nfor_address1][loop1].length() -1);
			carbonfiber[nfor_address2][loop1] = carbonfiber[nfor_address2][loop1].substring(1, carbonfiber[nfor_address2][loop1].length() -1);
			carbonfiber[nfor_city][loop1] = carbonfiber[nfor_city][loop1].substring(1, carbonfiber[nfor_city][loop1].length() -1);
			carbonfiber[nfor_state][loop1] = carbonfiber[nfor_state][loop1].substring(1, carbonfiber[nfor_state][loop1].length() -1);
			carbonfiber[nfor_zip][loop1] = carbonfiber[nfor_zip][loop1].substring(1, carbonfiber[nfor_zip][loop1].length() -1);
			carbonfiber[nfor_country][loop1] = carbonfiber[nfor_country][loop1].substring(1, carbonfiber[nfor_country][loop1].length() -1);

		}//*******************************************

		l3.setForeground(Color.GREEN);
		l3.setText("CSV address fixed...");

	}//********************











//assemblers***********************************
//assemblers***********************************
//**************************************TRANSACTIONS****************************************************************************
//**************************************TRANSACTIONS****************************************************************************




	//items replace. 
	public void replace_items(){

		//System.out.println("ite_int: " + ite_int);
		//System.out.println("ITETEMP[0]: " + ITETEMP[0]);

		l5.setText("Build IFF file... part 1");
		l5.setForeground(Color.RED);

			
		for (int loop0 = ix6; loop0 < ix6 + 1; loop0++){//**********************number of files  

			loopc1 = loop0;

			//refresh clean template

				for (int loopx0 = 0; loopx0 < ite_int; loopx0++){

					OUTTEMP[loopx0] = ITETEMP[loopx0];
					//System.out.println(OUTTEMP[loopx0]);

				}//for*******************************************

				//System.out.println(OUTTEMP[31]);
				//System.out.println(carbon1[31]);

				for (int loop2 = 0; loop2 < ite_int; loop2++){//template lines

					for (int loop1 = 0; loop1 < csv_passes_x; loop1++){//************csv sections

						for (int loopx = 0; loopx < 100; loopx++){//*csv repeats***

							ix4 = loop2;

							cx0 = "<!--Java_CFA[" + loop1 + "]-->";
							ix0 = OUTTEMP[loop2].indexOf(cx0);
							if(ix0 == -1){}
							else{
							OUTTEMP[loop2] = OUTTEMP[loop2].substring(0, ix0) + carbonfiber[loop1][loop0] + OUTTEMP[loop2].substring(ix0 + cx0.length(), OUTTEMP[loop2].length());
							//System.out.println("output; " + OUTTEMP[loop2]);
							}//else

						}//for*****************************************************


					}//for*****************************************************

				}//for***************************************

		//print1();
		}//for**************************************************************

		//l5.setText(ix5);

	}//cf replace







	public void cfreplace(){


		l5.setText("Build IFF file... part 2");
		l5.setForeground(Color.RED);

		
		for (int loop0 = ix6; loop0 < ix6 + 1; loop0++){//**********************number of files  
		
			loopc1 = loop0;

				//refresh clean template
				for (int loopx0 = 0; loopx0 < tra_int; loopx0++){

					OUTTEMP[loopx0] = TRATEMP[loopx0];
					//System.out.println(OUTTEMP[loopx0]);

				}//for*******************************************
				//System.out.println(OUTTEMP[31]);
				//System.out.println(carbon1[31]);


				for (int loop2 = 0; loop2 < tra_int; loop2++){//template lines   

					for (int loop1 = 0; loop1 < csv_passes_x; loop1++){//************csv sections

						for (int loopx = 0; loopx < 100; loopx++){//*csv repeats***

							ix4 = loop2;

							cx0 = "<!--Java_CFA[" + loop1 + "]-->";
							ix0 = OUTTEMP[loop2].indexOf(cx0);
							if(ix0 == -1){}
							else{
							//System.out.println("replace");
							OUTTEMP[loop2] = OUTTEMP[loop2].substring(0, ix0) + carbonfiber[loop1][loop0] + OUTTEMP[loop2].substring(ix0 + cx0.length(), OUTTEMP[loop2].length());
							}//else

						}//for*****************************************************


					}//for*****************************************************

				}//for***************************************

		//print1();
		}//for**************************************************************

		//System.out.println(ix5);

	}//cf replace










	public void cfreplace_tax(){//**********************TAX VERSION


		l5.setText("Build IFF file... part 2");
		l5.setForeground(Color.RED);

		
		for (int loop0 = ix6; loop0 < ix6 + 1; loop0++){//**********************number of files  
		
			loopc1 = loop0;

			//refresh clean template
			for (int loopx0 = 0; loopx0 < tra_int_tax; loopx0++){

				OUTTEMP[loopx0] = TRATEMP_TAX[loopx0];
				//System.out.println(OUTTEMP[loopx0]);

			}//for*******************************************
			//System.out.println(OUTTEMP[31]);
			//System.out.println(carbon1[31]);

			for (int loop2 = 0; loop2 < tra_int_tax; loop2++){//template lines   

				for (int loop1 = 0; loop1 < csv_passes_x; loop1++){//************csv sections

					for (int loopx = 0; loopx < 100; loopx++){//*csv repeats***
						ix4 = loop2;

						cx0 = "<!--Java_CFA[" + loop1 + "]-->";
						ix0 = OUTTEMP[loop2].indexOf(cx0);
						if(ix0 == -1){}
						else{
						//System.out.println("replace");
						OUTTEMP[loop2] = OUTTEMP[loop2].substring(0, ix0) + carbonfiber[loop1][loop0] + OUTTEMP[loop2].substring(ix0 + cx0.length(), OUTTEMP[loop2].length());
						}//else
					}//for*****************************************************


				}//for*****************************************************

			}//for***************************************

		//print1();
		}//for**************************************************************

		//System.out.println(ix5);

	}//cf replace













	public void convert_iff(){

		show_load();

		//build header
			

			try {

		        BufferedWriter out = new BufferedWriter(new FileWriter(save_as));

				for (int loop1 = 0; loop1 < iff_int; loop1++){
				
					out.write(IFFTEMP[loop1]); out.newLine();

				}//for


				//the compiled items list. 
				for (int loop0 = 1; loop0 < csv_int; loop0++){

					ix6 = loop0;
					replace_items();

					for (int loop1 = 0; loop1 < ite_int; loop1++){out.write(OUTTEMP[loop1]); out.newLine();}//for

				}//for****************************************
				//the compiled transactions list. 





				//the compiled transactions list. 
				for (int loop0 = 1; loop0 < csv_int; loop0++){

					ix6 = loop0;


					if(Float.parseFloat(goldfiber[21][loop0]) > 0){cfreplace_tax(); System.out.println("*TAX*");}
					else{cfreplace(); System.out.println("NO TAX");}

					for (int loop1 = 0; loop1 < tra_int; loop1++){out.write(OUTTEMP[loop1]); out.newLine();}//for

				}//for****************************************
				//the compiled transactions list. 



		    	out.close();

		    } catch (IOException e) {l6.setForeground(Color.RED);}


		l5.setForeground(Color.GREEN);
		l5.setText("Build IFF file... Complete.");
		l6.setForeground(Color.GREEN);
		l6 = new Label("Save As: " + save_as, Label.LEFT);

	}//convert iff************



//**************************************TRANSACTIONS****************************************************************************
//**************************************TRANSACTIONS****************************************************************************
//stop****************************************************************************
//stop****************************************************************************


//repair***********************************************************************
//repair***********************************************************************








	public void repair_csv(){//*


		String silver[] = new String[runs];
		int silver_int = 0;





		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("iff_template.iif")));
			xlinex = blank;
			while ((xlinex = in.readLine()) != null){silver[silver_int] = xlinex; silver_int++;}
			in.close();

		}catch(IOException e){l6.setText("Failed to load backup file...1"); l6.setForeground(Color.RED);}

		try {

		    BufferedWriter out = new BufferedWriter(new FileWriter(file_iff_1));

			for (int loop1 = 0; loop1 < silver_int; loop1++){

				out.write(silver[loop1]); out.newLine();

			}//for
			out.close();
	        
	    }catch(IOException e){l6.setText("Failed to print backup file...1"); l6.setForeground(Color.RED);}




		silver_int = 0;


		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("item_template.iif")));
			xlinex = blank;
			while ((xlinex = in.readLine()) != null){silver[silver_int] = xlinex; silver_int++;}
			in.close();

		}catch(IOException e){l6.setText("Failed to load backup file...2"); l6.setForeground(Color.RED);}

		try {

	        BufferedWriter out = new BufferedWriter(new FileWriter(file_ite_1));
			for (int loop1 = 0; loop1 < silver_int; loop1++){

				out.write(silver[loop1]); out.newLine();

			}//for
			out.close();

	    }catch(IOException e){l6.setText("Failed to print backup file...2"); l6.setForeground(Color.RED);}




		silver_int = 0;


		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("tran_template.iif")));
			xlinex = blank;
			while ((xlinex = in.readLine()) != null){silver[silver_int] = xlinex; silver_int++;}
			in.close();

		}catch(IOException e){l6.setText("Failed to load backup file...3"); l6.setForeground(Color.RED);}

		try {

		    BufferedWriter out = new BufferedWriter(new FileWriter(file_tra_1));
			for (int loop1 = 0; loop1 < silver_int; loop1++){

				out.write(silver[loop1]); out.newLine();

			}//for
			out.close();

	    }catch(IOException e){l6.setText("Failed to print backup file...3"); l6.setForeground(Color.RED);}


		silver_int = 0;


		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("Sales-Paid.csv")));
			xlinex = blank;
			while ((xlinex = in.readLine()) != null){silver[silver_int] = xlinex; silver_int++;}
			in.close();

		}catch(IOException e){l6.setText("Failed to load backup file...4"); l6.setForeground(Color.RED);}

		try {

		    BufferedWriter out = new BufferedWriter(new FileWriter(file_csv_1));

			for (int loop1 = 0; loop1 < silver_int; loop1++){

				out.write(silver[loop1]); out.newLine();

			}//for
			out.close();

	    }catch(IOException e){l6.setText("Failed to print backup file...4"); l6.setForeground(Color.RED);}


		silver_int = 0;


		try {

			BufferedReader in = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("ssx.ini")));
			xlinex = blank;
			while ((xlinex = in.readLine()) != null){silver[silver_int] = xlinex; silver_int++;}
			in.close();

		}catch(IOException e){l6.setText("Failed to load backup file...5"); l6.setForeground(Color.RED);}

		try {

		    BufferedWriter out = new BufferedWriter(new FileWriter(file_ssx_1));

			for (int loop1 = 0; loop1 < silver_int; loop1++){

				out.write(silver[loop1]); out.newLine();

			}//for
		out.close();

	    }catch(IOException e){l6.setText("Failed to print backup file...5"); l6.setForeground(Color.RED);}


		silver_int = 0;

	}//repair*******************




//repair***********************************************************************
//repair***********************************************************************
//stop****************************************************************************
//stop****************************************************************************









	public void quick_report(){

		Float flx0 = (float) 0;
		Float flx1 = (float) 0;
		Float flx2 = (float) 0;
		Float flx3 = (float) 0;
		Float flx4 = (float) 0;
		Float flx5 = (float) 0;
		Float flx6 = (float) 0;
		Float flx7 = (float) 0;
		Float flx8 = (float) 0;


		try {
		        
		    BufferedWriter out = new BufferedWriter(new FileWriter("Quick Report.txt"));


			System.out.println("csv_int " + csv_int);
			System.out.println(goldfiber[5][0]);
			System.out.println(nfor_sale_price);


			for(int loop0 = 1; loop0 < csv_int; loop0++){

				flx0 = flx0 + Float.parseFloat(goldfiber[5][loop0]);
			
			}//for ****************************************


			for(int loop0 = 1; loop0 < csv_int; loop0++){

				flx1 = flx1 + Float.parseFloat(goldfiber[3][loop0]);

			}//for ****************************************


			for(int loop0 = 1; loop0 < csv_int; loop0++){

				flx2 = flx2 + Float.parseFloat(goldfiber[9][loop0]);

			}//for ****************************************


			for(int loop0 = 1; loop0 < csv_int; loop0++){

				flx3 = flx3 + Float.parseFloat(goldfiber[10][loop0]);

			}//for ****************************************


			for(int loop0 = 1; loop0 < csv_int; loop0++){

				flx4 = flx4 + Float.parseFloat(goldfiber[7][loop0]);

			}//for ****************************************


			for(int loop0 = 1; loop0 < csv_int; loop0++){

				flx5 = flx5 + Float.parseFloat(goldfiber[6][loop0]);

			}//for ****************************************


			for(int loop0 = 1; loop0 < csv_int; loop0++){

				flx6 = flx6 + Float.parseFloat(goldfiber[11][loop0]);

			}//for ****************************************


			for(int loop0 = 1; loop0 < csv_int; loop0++){

				flx7 = flx7 + Float.parseFloat(goldfiber[21][loop0]);

			}//for ****************************************


			flx8 = ((flx0 + flx2 + flx6) - (flx1 + flx3 + flx4 + flx5));

			System.out.println((flx0 + flx2));
			System.out.println((flx1 + flx3 + flx4 + flx5));


				out.write("Sales:         " + Float.toString(flx0)); 
				out.newLine();

				out.write("Cost:          " + Float.toString(flx1)); 
				out.newLine();

				out.write("Shipping(in)   " + Float.toString(flx2)); 
				out.newLine();

				out.write("Shipping(out)  " + Float.toString(flx3)); 
				out.newLine();

				out.write("eBay(fees)     " + Float.toString(flx4)); 
				out.newLine();

				out.write("PayPal(fees)   " + Float.toString(flx5)); 
				out.newLine();

				out.write("Handling       " + Float.toString(flx6)); 
				out.newLine();

				out.write("Sales Tax      " + Float.toString(flx7)); 
				out.newLine();
				out.newLine();

				out.write("*********************************************"); 
				out.newLine();
				out.write("TOTAL     " + Float.toString(flx8)); 
				out.newLine();


		        out.close();
		        
		} catch (IOException e) {l6.setForeground(Color.RED); l6.setText("Quick Report Failed.");}


		l5.setForeground(Color.GREEN);
		l5.setText("Build Quick Report file... Complete.");

		l6.setForeground(Color.GREEN);
		l6.setText("Save As: Quick Report.txt");

	}//quickreport.














	public void csv_alchemy(){




	}//csv_alchemy











public void actionPerformed(ActionEvent event){


	if(event.getSource() == b0){convert_iff();}//convert_iff();

	if(event.getSource() == b1){quick_report();}//simple report
	if(event.getSource() == b2){csv_alchemy();}//simple csv
	if(event.getSource() == b3){}//settings
	if(event.getSource() == b4){}//not used

}//action**




	public static void main(String[] args){

		alchemy_a xr = new alchemy_a();

	}//main












	class BackgroundPanel extends JPanel{
  
  		Image image;
  
  		public BackgroundPanel(){
    
    		try{

      			image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3.jpg"), "background3.jpg"));

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
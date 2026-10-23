import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_display_viewer1 extends JFrame implements ActionListener{//************************************************************************

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

JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int ix0x = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int stop = 0;
int post_number = 1;
int db_edit = 1;


int response = 1100;


Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color bluex2 = new Color(0.2f, 0.27f, 0.39f);
Color grayx1 = new Color(0.7f, 0.7f, 0.7f);
Color grayx2 = new Color(0.6f, 0.6f, 0.6f);
Color darkgreenx = new Color(0.1f, 0.3f, 0.1f);




JPanel jpk_x[] = new JPanel[100];
JLabel jlabel_number[] = new JLabel[100];
JCheckBox jcbx[] = new JCheckBox[100];
JLabel jlabel_space[] = new JLabel[100];
JLabel jlabel[] = new JLabel[100];
JTextField jtextf[] = new JTextField[100];
JLabel jlabel_size[] = new JLabel[100];
JLabel jlabel_location[] = new JLabel[100];
JButton jup[] = new JButton[100];
JButton jdown[] = new JButton[100];





String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");

String cxx0[] = new String[3];

File st1;

int selected_int;

String settings[][] = new String[1][runs];
String xlinex = new String("");
String blank = new String("");



JButton create = new JButton("Create");
JButton sold = new JButton("Sold");
JButton archive = new JButton("Archive");
JButton reset = new JButton("Reset");




JLabel not_international_l = new JLabel("If the sale is NOT international then use (MAIL TYPE) settings in this field: ", JLabel.LEFT);
JComboBox not_international_cb = new JComboBox();



JLabel info_header2_1 = new JLabel("Import ?? days past.", JLabel.RIGHT);
JLabel info_header2_2 = new JLabel("Import ONLY inventoried items.", JLabel.RIGHT);
JTextField sales_days_past = new JTextField("", 12);
JCheckBox import_everything = new JCheckBox();


ImageIcon imx2;
ImageIcon imx3;
ImageIcon imx4;





alchemy_display_viewer1(){//****************************

	super("Display Viewer");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex_x(); nm.firex = 1;}});





//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);




	imx2 = new ImageIcon(this.getClass().getResource("images/buttonimage2.png"));
	imx3 = new ImageIcon(this.getClass().getResource("images/buttonimage3.png"));
	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));




	create.setMargin(new Insets(0, 0, 0, 0));
  	create.addActionListener(this);
 	create.setPreferredSize(new Dimension(120, 25));
 	create.setIcon(imx2); 
	create.setHorizontalTextPosition(JButton.CENTER);
 	create.setForeground(grayx1);
	create.setBorder(null);
	create.setToolTipText("The EXPORT database");


	sold.setMargin(new Insets(0, 0, 0, 0));
  	sold.addActionListener(this);
 	sold.setPreferredSize(new Dimension(120, 25));
 	sold.setIcon(imx2); 
	sold.setHorizontalTextPosition(JButton.CENTER);
 	sold.setForeground(grayx2);
	sold.setBorder(null);
	sold.setToolTipText("The SOLD database");


	archive.setMargin(new Insets(0, 0, 0, 0));
  	archive.addActionListener(this);
 	archive.setPreferredSize(new Dimension(120, 25));
 	archive.setIcon(imx2); 
	archive.setHorizontalTextPosition(JButton.CENTER);
 	archive.setForeground(grayx2);
	archive.setBorder(null);
	archive.setToolTipText("The ARCHIVE database");


	reset.setMargin(new Insets(0, 0, 0, 0));
 	reset.setPreferredSize(new Dimension(100, 20));
  	reset.addActionListener(this);
	reset.setHorizontalTextPosition(JButton.CENTER);
 	reset.setForeground(blackx);
	reset.setBackground(nm.st_gray1);
 	//reset.setIcon(imx4); 



	stop = 0;
	csv_int = 0;
	thisc3 = 0;

	ImageIcon imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));


	ix0 = 120;
	ix1 = 20;




	info_header2_1.setPreferredSize(new Dimension(130, 20));
	info_header2_2.setPreferredSize(new Dimension(290, 20));



	FlowLayout flow = new FlowLayout(0);
	flow.setHgap(1);
	flow.setVgap(1);





	JPanel jpk_xt = new JPanel(flow);
	jpk_xt.setPreferredSize(new Dimension(xzx -25, 25));
	jpk_xt.setBackground(grayx2);
	jpk_xt.add(create);
	jpk_xt.add(sold);
	jpk_xt.add(archive);


	for (int loop1 = 0; loop1 < 100; loop1++){
	

		jcbx[loop1] = new JCheckBox();

		jlabel_number[loop1] = new JLabel(Integer.toString(loop1), JLabel.CENTER);
		jlabel_number[loop1].setPreferredSize(new Dimension(60, 20));

		jtextf[loop1] = new JTextField("100", 10);

		jlabel_space[loop1] = new JLabel();
		jlabel_space[loop1].setPreferredSize(new Dimension(10, 20));


		jlabel_size[loop1] = new JLabel("");
		jlabel_size[loop1].setPreferredSize(new Dimension(160, 20));

		jlabel_location[loop1] = new JLabel("*");
		jlabel_location[loop1].setPreferredSize(new Dimension(160, 20));

		jcbx[loop1].addActionListener(this);


		jup[loop1] = new JButton("Up");
		jup[loop1].setPreferredSize(new Dimension(60, 20));
		jup[loop1].addActionListener(this);
		jup[loop1].setBackground(nm.st_gray1);
		jup[loop1].setForeground(blackx);

		jdown[loop1] = new JButton("Down");
		jdown[loop1].setPreferredSize(new Dimension(80, 20));
		jdown[loop1].addActionListener(this);


		jpk_x[loop1] = new JPanel(flow);
		jpk_x[loop1].setPreferredSize(new Dimension(xzx -25, 25));
		jpk_x[loop1].setBackground(grayx1);
		jpk_x[loop1].add(jcbx[loop1]);
		jpk_x[loop1].add(jlabel_number[loop1]);
		jpk_x[loop1].add(jtextf[loop1]);
		jpk_x[loop1].add(jlabel_space[loop1]);
		jpk_x[loop1].add(jlabel_location[loop1]);
		jpk_x[loop1].add(jlabel_size[loop1]);
		jpk_x[loop1].add(jup[loop1]);
		jpk_x[loop1].add(jdown[loop1]);
		jdown[loop1].setEnabled(false);

	}//*******************************************





	JPanel jpk1 = new JPanel(flow);
	jpk1.setPreferredSize(new Dimension(xzx -25, 2600));
	jpk1.setBackground(grayx2);
	for (int loop1 = 0; loop1 < 100; loop1++){
	
		jpk1.add(jpk_x[loop1]);

	}//*******************************************





	JScrollPane scrollPane = new JScrollPane(jpk1);
	scrollPane.setPreferredSize(new Dimension(xzx -5, xzy -85));
	//scrollPane.setBackground(bluex2);
	scrollPane.setFont(new Font("Arial", Font.PLAIN, 14));


	JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(xzx, 50));
	jpk2.setBackground(nm.st_gray1);
	jpk2.add(reset);



	Container cpx = getContentPane();
	cpx.setLayout(flow);
	cpx.setBackground(grayx2);
	cpx.setForeground(whitex);
	cpx.add(jpk_xt);
	cpx.add(scrollPane);
	cpx.add(jpk2);


	setVisible(true);



	loadx_x();



	requestFocus();




	if(nm.db_number == 0){db_edit = 1; loadx_x();} 
	if(nm.db_number == 2){db_edit = 2; loadx_x();} 
	if(nm.db_number == 3){db_edit = 3; loadx_x();} 


}//csv_loader_x1********************************************************







	public void loadx_x(){


		ix0x = 0;


		for (int loop1 = 0; loop1 < 100; loop1++){
		for (int loop2 = 0; loop2 < 100; loop2++){


			if(nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))].equals(Integer.toString(loop1))){

				if(nm.carbon[nm.ss_settings][0][(loop2 + (100 * db_edit))].equals("1")){jcbx[loop1].setSelected(true);}
				else{jcbx[loop1].setSelected(false);}

				jlabel_location[loop1].setText(nm.db_string[loop2]);
				jlabel_size[loop1].setText(nm.carbon[nm.ss_settings][1][(loop1 + (100 * db_edit))]);
				ix0x++;


				jtextf[loop1].setText(nm.carbon[nm.ss_settings][2][(loop2 + (100 * db_edit))]);

			}//***********************************************************************************
	

			if(nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))].equals("100")){nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))] = Integer.toString(ix0x); ix0x++;}


		}//***************************************
		}//***************************************






		if(db_edit == 1){create.setIcon(imx3); sold.setIcon(imx2); archive.setIcon(imx2); create.setForeground(whitex); sold.setForeground(grayx1); archive.setForeground(grayx1);}
 		if(db_edit == 2){create.setIcon(imx2); sold.setIcon(imx3); archive.setIcon(imx2); create.setForeground(grayx1); sold.setForeground(whitex); archive.setForeground(grayx1);}
		if(db_edit == 3){create.setIcon(imx2); sold.setIcon(imx2); archive.setIcon(imx3); create.setForeground(grayx1); sold.setForeground(grayx1); archive.setForeground(whitex);}


	}//savex










	public void savex_x(){

		for (int loop1 = 0; loop1 < 100; loop1++){
		for (int loop2 = 0; loop2 < 100; loop2++){

			if(nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))].equals(Integer.toString(loop1))){nm.carbon[nm.ss_settings][2][(loop2 + (100 * db_edit))] = jtextf[loop1].getText();}

		}//***************************************
		}//***************************************

	}//savex











	public void reset_x(){

		response = JOptionPane.showConfirmDialog(null, "Are you sure you want to overwrite settings?");

		if(response == 0){


			if(db_edit == 1){

				nm.carbon[nm.ss_settings][0][(0 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(1 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(2 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(3 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(4 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(5 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(6 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(7 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(8 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(9 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(10 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(11 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(12 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(13 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(14 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(15 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(16 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(17 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(18 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(19 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(20 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(21 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(22 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(23 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(24 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(25 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(26 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(27 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(28 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(29 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(30 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(31 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(32 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(33 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(34 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(35 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(36 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(37 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(38 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(39 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(40 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(41 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(42 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(43 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(44 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(45 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(46 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(47 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(48 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(49 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(50 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(51 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(52 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(53 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(54 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(55 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(56 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(57 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(58 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(59 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(60 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(61 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(62 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(63 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(64 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(65 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(66 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(67 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(68 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(69 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(70 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(71 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(72 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(73 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(74 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(75 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(76 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(77 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(78 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(79 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(80 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(81 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(82 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(83 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(84 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(85 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(86 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(87 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(88 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(89 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(90 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(91 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(92 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(93 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(94 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(95 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(96 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(97 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(98 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(99 + (100 * db_edit))] = Integer.toString(0);

				nm.carbon[nm.ss_settings][1][(0 + (100 * db_edit))] = Integer.toString(86);
				nm.carbon[nm.ss_settings][1][(1 + (100 * db_edit))] = Integer.toString(87);
				nm.carbon[nm.ss_settings][1][(2 + (100 * db_edit))] = Integer.toString(88);
				nm.carbon[nm.ss_settings][1][(3 + (100 * db_edit))] = Integer.toString(89);
				nm.carbon[nm.ss_settings][1][(4 + (100 * db_edit))] = Integer.toString(90);
				nm.carbon[nm.ss_settings][1][(5 + (100 * db_edit))] = Integer.toString(91);
				nm.carbon[nm.ss_settings][1][(6 + (100 * db_edit))] = Integer.toString(92);
				nm.carbon[nm.ss_settings][1][(7 + (100 * db_edit))] = Integer.toString(93);
				nm.carbon[nm.ss_settings][1][(8 + (100 * db_edit))] = Integer.toString(94);
				nm.carbon[nm.ss_settings][1][(9 + (100 * db_edit))] = Integer.toString(95);
				nm.carbon[nm.ss_settings][1][(10 + (100 * db_edit))] = Integer.toString(96);
				nm.carbon[nm.ss_settings][1][(11 + (100 * db_edit))] = Integer.toString(97);
				nm.carbon[nm.ss_settings][1][(12 + (100 * db_edit))] = Integer.toString(98);
				nm.carbon[nm.ss_settings][1][(13 + (100 * db_edit))] = Integer.toString(7);
				nm.carbon[nm.ss_settings][1][(14 + (100 * db_edit))] = Integer.toString(8);
				nm.carbon[nm.ss_settings][1][(15 + (100 * db_edit))] = Integer.toString(13);
				nm.carbon[nm.ss_settings][1][(16 + (100 * db_edit))] = Integer.toString(14);
				nm.carbon[nm.ss_settings][1][(17 + (100 * db_edit))] = Integer.toString(15);
				nm.carbon[nm.ss_settings][1][(18 + (100 * db_edit))] = Integer.toString(16);
				nm.carbon[nm.ss_settings][1][(19 + (100 * db_edit))] = Integer.toString(17);
				nm.carbon[nm.ss_settings][1][(20 + (100 * db_edit))] = Integer.toString(18);
				nm.carbon[nm.ss_settings][1][(21 + (100 * db_edit))] = Integer.toString(19);
				nm.carbon[nm.ss_settings][1][(22 + (100 * db_edit))] = Integer.toString(20);
				nm.carbon[nm.ss_settings][1][(23 + (100 * db_edit))] = Integer.toString(21);
				nm.carbon[nm.ss_settings][1][(24 + (100 * db_edit))] = Integer.toString(22);
				nm.carbon[nm.ss_settings][1][(25 + (100 * db_edit))] = Integer.toString(23);
				nm.carbon[nm.ss_settings][1][(26 + (100 * db_edit))] = Integer.toString(24);
				nm.carbon[nm.ss_settings][1][(27 + (100 * db_edit))] = Integer.toString(25);
				nm.carbon[nm.ss_settings][1][(28 + (100 * db_edit))] = Integer.toString(26);
				nm.carbon[nm.ss_settings][1][(29 + (100 * db_edit))] = Integer.toString(27);
				nm.carbon[nm.ss_settings][1][(30 + (100 * db_edit))] = Integer.toString(28);
				nm.carbon[nm.ss_settings][1][(31 + (100 * db_edit))] = Integer.toString(29);
				nm.carbon[nm.ss_settings][1][(32 + (100 * db_edit))] = Integer.toString(30);
				nm.carbon[nm.ss_settings][1][(33 + (100 * db_edit))] = Integer.toString(31);
				nm.carbon[nm.ss_settings][1][(34 + (100 * db_edit))] = Integer.toString(32);
				nm.carbon[nm.ss_settings][1][(35 + (100 * db_edit))] = Integer.toString(33);
				nm.carbon[nm.ss_settings][1][(36 + (100 * db_edit))] = Integer.toString(34);
				nm.carbon[nm.ss_settings][1][(37 + (100 * db_edit))] = Integer.toString(35);
				nm.carbon[nm.ss_settings][1][(38 + (100 * db_edit))] = Integer.toString(36);
				nm.carbon[nm.ss_settings][1][(39 + (100 * db_edit))] = Integer.toString(37);
				nm.carbon[nm.ss_settings][1][(40 + (100 * db_edit))] = Integer.toString(38);
				nm.carbon[nm.ss_settings][1][(41 + (100 * db_edit))] = Integer.toString(39);
				nm.carbon[nm.ss_settings][1][(42 + (100 * db_edit))] = Integer.toString(40);
				nm.carbon[nm.ss_settings][1][(43 + (100 * db_edit))] = Integer.toString(41);
				nm.carbon[nm.ss_settings][1][(44 + (100 * db_edit))] = Integer.toString(42);
				nm.carbon[nm.ss_settings][1][(45 + (100 * db_edit))] = Integer.toString(43);
				nm.carbon[nm.ss_settings][1][(46 + (100 * db_edit))] = Integer.toString(44);
				nm.carbon[nm.ss_settings][1][(47 + (100 * db_edit))] = Integer.toString(45);
				nm.carbon[nm.ss_settings][1][(48 + (100 * db_edit))] = Integer.toString(46);
				nm.carbon[nm.ss_settings][1][(49 + (100 * db_edit))] = Integer.toString(47);
				nm.carbon[nm.ss_settings][1][(50 + (100 * db_edit))] = Integer.toString(48);
				nm.carbon[nm.ss_settings][1][(51 + (100 * db_edit))] = Integer.toString(49);
				nm.carbon[nm.ss_settings][1][(52 + (100 * db_edit))] = Integer.toString(50);
				nm.carbon[nm.ss_settings][1][(53 + (100 * db_edit))] = Integer.toString(51);
				nm.carbon[nm.ss_settings][1][(54 + (100 * db_edit))] = Integer.toString(52);
				nm.carbon[nm.ss_settings][1][(55 + (100 * db_edit))] = Integer.toString(53);
				nm.carbon[nm.ss_settings][1][(56 + (100 * db_edit))] = Integer.toString(54);
				nm.carbon[nm.ss_settings][1][(57 + (100 * db_edit))] = Integer.toString(55);
				nm.carbon[nm.ss_settings][1][(58 + (100 * db_edit))] = Integer.toString(56);
				nm.carbon[nm.ss_settings][1][(59 + (100 * db_edit))] = Integer.toString(57);
				nm.carbon[nm.ss_settings][1][(60 + (100 * db_edit))] = Integer.toString(58);
				nm.carbon[nm.ss_settings][1][(61 + (100 * db_edit))] = Integer.toString(59);
				nm.carbon[nm.ss_settings][1][(62 + (100 * db_edit))] = Integer.toString(60);
				nm.carbon[nm.ss_settings][1][(63 + (100 * db_edit))] = Integer.toString(61);
				nm.carbon[nm.ss_settings][1][(64 + (100 * db_edit))] = Integer.toString(6);
				nm.carbon[nm.ss_settings][1][(65 + (100 * db_edit))] = Integer.toString(62);
				nm.carbon[nm.ss_settings][1][(66 + (100 * db_edit))] = Integer.toString(63);
				nm.carbon[nm.ss_settings][1][(67 + (100 * db_edit))] = Integer.toString(64);
				nm.carbon[nm.ss_settings][1][(68 + (100 * db_edit))] = Integer.toString(3);
				nm.carbon[nm.ss_settings][1][(69 + (100 * db_edit))] = Integer.toString(65);
				nm.carbon[nm.ss_settings][1][(70 + (100 * db_edit))] = Integer.toString(9);
				nm.carbon[nm.ss_settings][1][(71 + (100 * db_edit))] = Integer.toString(4);
				nm.carbon[nm.ss_settings][1][(72 + (100 * db_edit))] = Integer.toString(66);
				nm.carbon[nm.ss_settings][1][(73 + (100 * db_edit))] = Integer.toString(67);
				nm.carbon[nm.ss_settings][1][(74 + (100 * db_edit))] = Integer.toString(99);
				nm.carbon[nm.ss_settings][1][(75 + (100 * db_edit))] = Integer.toString(11);
				nm.carbon[nm.ss_settings][1][(76 + (100 * db_edit))] = Integer.toString(68);
				nm.carbon[nm.ss_settings][1][(77 + (100 * db_edit))] = Integer.toString(69);
				nm.carbon[nm.ss_settings][1][(78 + (100 * db_edit))] = Integer.toString(70);
				nm.carbon[nm.ss_settings][1][(79 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][1][(80 + (100 * db_edit))] = Integer.toString(71);
				nm.carbon[nm.ss_settings][1][(81 + (100 * db_edit))] = Integer.toString(73);
				nm.carbon[nm.ss_settings][1][(82 + (100 * db_edit))] = Integer.toString(72);
				nm.carbon[nm.ss_settings][1][(83 + (100 * db_edit))] = Integer.toString(74);
				nm.carbon[nm.ss_settings][1][(84 + (100 * db_edit))] = Integer.toString(10);
				nm.carbon[nm.ss_settings][1][(85 + (100 * db_edit))] = Integer.toString(2);
				nm.carbon[nm.ss_settings][1][(86 + (100 * db_edit))] = Integer.toString(75);
				nm.carbon[nm.ss_settings][1][(87 + (100 * db_edit))] = Integer.toString(76);
				nm.carbon[nm.ss_settings][1][(88 + (100 * db_edit))] = Integer.toString(77);
				nm.carbon[nm.ss_settings][1][(89 + (100 * db_edit))] = Integer.toString(78);
				nm.carbon[nm.ss_settings][1][(90 + (100 * db_edit))] = Integer.toString(79);
				nm.carbon[nm.ss_settings][1][(91 + (100 * db_edit))] = Integer.toString(80);
				nm.carbon[nm.ss_settings][1][(92 + (100 * db_edit))] = Integer.toString(81);
				nm.carbon[nm.ss_settings][1][(93 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][1][(94 + (100 * db_edit))] = Integer.toString(12);
				nm.carbon[nm.ss_settings][1][(95 + (100 * db_edit))] = Integer.toString(5);
				nm.carbon[nm.ss_settings][1][(96 + (100 * db_edit))] = Integer.toString(82);
				nm.carbon[nm.ss_settings][1][(97 + (100 * db_edit))] = Integer.toString(83);
				nm.carbon[nm.ss_settings][1][(98 + (100 * db_edit))] = Integer.toString(84);
				nm.carbon[nm.ss_settings][1][(99 + (100 * db_edit))] = Integer.toString(85);

				nm.carbon[nm.ss_settings][2][(0 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(1 + (100 * db_edit))] = Integer.toString(200);
				nm.carbon[nm.ss_settings][2][(2 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(3 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(4 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(5 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(6 + (100 * db_edit))] = Integer.toString(140);
				nm.carbon[nm.ss_settings][2][(7 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(8 + (100 * db_edit))] = Integer.toString(150);
				nm.carbon[nm.ss_settings][2][(9 + (100 * db_edit))] = Integer.toString(200);
				nm.carbon[nm.ss_settings][2][(10 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(11 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(12 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(13 + (100 * db_edit))] = Integer.toString(200);
				nm.carbon[nm.ss_settings][2][(14 + (100 * db_edit))] = Integer.toString(150);
				nm.carbon[nm.ss_settings][2][(15 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(16 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(17 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(18 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(19 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(20 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(21 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(22 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(23 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(24 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(25 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(26 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(27 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(28 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(29 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(30 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(31 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(32 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(33 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(34 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(35 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(36 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(37 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(38 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(39 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(40 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(41 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(42 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(43 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(44 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(45 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(46 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(47 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(48 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(49 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(50 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(51 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(52 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(53 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(54 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(55 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(56 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(57 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(58 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(59 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(60 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(61 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(62 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(63 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(64 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(65 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(66 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(67 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(68 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(69 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(70 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(71 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(72 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(73 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(74 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(75 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(76 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(77 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(78 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(79 + (100 * db_edit))] = Integer.toString(200);
				nm.carbon[nm.ss_settings][2][(80 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(81 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(82 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(83 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(84 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(85 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(86 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(87 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(88 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(89 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(90 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(91 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(92 + (100 * db_edit))] = Integer.toString(150);
				nm.carbon[nm.ss_settings][2][(93 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(94 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(95 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(96 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(97 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(98 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(99 + (100 * db_edit))] = Integer.toString(240);

			}//1
			if(db_edit == 2){

				nm.carbon[nm.ss_settings][0][(0 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(1 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(2 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(3 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(4 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(5 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(6 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(7 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(8 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(9 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(10 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(11 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(12 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(13 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(14 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(15 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(16 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(17 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(18 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(19 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(20 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(21 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(22 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(23 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(24 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(25 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(26 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(27 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(28 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(29 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(30 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(31 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(32 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(33 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(34 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(35 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(36 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(37 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(38 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(39 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(40 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(41 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(42 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(43 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(44 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(45 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(46 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(47 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(48 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(49 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(50 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(51 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(52 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(53 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(54 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(55 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(56 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(57 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(58 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(59 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(60 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(61 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(62 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(63 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(64 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(65 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(66 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(67 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(68 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(69 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(70 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(71 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(72 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(73 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(74 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(75 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(76 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(77 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(78 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(79 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(80 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(81 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(82 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(83 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(84 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(85 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(86 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(87 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(88 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(89 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(90 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(91 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(92 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(93 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(94 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(95 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(96 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(97 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][0][(98 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(99 + (100 * db_edit))] = Integer.toString(0);

				nm.carbon[nm.ss_settings][1][(0 + (100 * db_edit))] = Integer.toString(15);
				nm.carbon[nm.ss_settings][1][(1 + (100 * db_edit))] = Integer.toString(16);
				nm.carbon[nm.ss_settings][1][(2 + (100 * db_edit))] = Integer.toString(17);
				nm.carbon[nm.ss_settings][1][(3 + (100 * db_edit))] = Integer.toString(18);
				nm.carbon[nm.ss_settings][1][(4 + (100 * db_edit))] = Integer.toString(19);
				nm.carbon[nm.ss_settings][1][(5 + (100 * db_edit))] = Integer.toString(20);
				nm.carbon[nm.ss_settings][1][(6 + (100 * db_edit))] = Integer.toString(21);
				nm.carbon[nm.ss_settings][1][(7 + (100 * db_edit))] = Integer.toString(22);
				nm.carbon[nm.ss_settings][1][(8 + (100 * db_edit))] = Integer.toString(1);//
				nm.carbon[nm.ss_settings][1][(9 + (100 * db_edit))] = Integer.toString(23);
				nm.carbon[nm.ss_settings][1][(10 + (100 * db_edit))] = Integer.toString(6);//
				nm.carbon[nm.ss_settings][1][(11 + (100 * db_edit))] = Integer.toString(0);//
				nm.carbon[nm.ss_settings][1][(12 + (100 * db_edit))] = Integer.toString(24);
				nm.carbon[nm.ss_settings][1][(13 + (100 * db_edit))] = Integer.toString(25);
				nm.carbon[nm.ss_settings][1][(14 + (100 * db_edit))] = Integer.toString(26);
				nm.carbon[nm.ss_settings][1][(15 + (100 * db_edit))] = Integer.toString(10);//
				nm.carbon[nm.ss_settings][1][(16 + (100 * db_edit))] = Integer.toString(11);//
				nm.carbon[nm.ss_settings][1][(17 + (100 * db_edit))] = Integer.toString(27);
				nm.carbon[nm.ss_settings][1][(18 + (100 * db_edit))] = Integer.toString(28);
				nm.carbon[nm.ss_settings][1][(19 + (100 * db_edit))] = Integer.toString(29);
				nm.carbon[nm.ss_settings][1][(20 + (100 * db_edit))] = Integer.toString(30);
				nm.carbon[nm.ss_settings][1][(21 + (100 * db_edit))] = Integer.toString(31);
				nm.carbon[nm.ss_settings][1][(22 + (100 * db_edit))] = Integer.toString(32);
				nm.carbon[nm.ss_settings][1][(23 + (100 * db_edit))] = Integer.toString(33);
				nm.carbon[nm.ss_settings][1][(24 + (100 * db_edit))] = Integer.toString(34);
				nm.carbon[nm.ss_settings][1][(25 + (100 * db_edit))] = Integer.toString(35);
				nm.carbon[nm.ss_settings][1][(26 + (100 * db_edit))] = Integer.toString(36);
				nm.carbon[nm.ss_settings][1][(27 + (100 * db_edit))] = Integer.toString(37);
				nm.carbon[nm.ss_settings][1][(28 + (100 * db_edit))] = Integer.toString(38);
				nm.carbon[nm.ss_settings][1][(29 + (100 * db_edit))] = Integer.toString(39);
				nm.carbon[nm.ss_settings][1][(30 + (100 * db_edit))] = Integer.toString(40);
				nm.carbon[nm.ss_settings][1][(31 + (100 * db_edit))] = Integer.toString(41);
				nm.carbon[nm.ss_settings][1][(32 + (100 * db_edit))] = Integer.toString(42);
				nm.carbon[nm.ss_settings][1][(33 + (100 * db_edit))] = Integer.toString(43);
				nm.carbon[nm.ss_settings][1][(34 + (100 * db_edit))] = Integer.toString(44);
				nm.carbon[nm.ss_settings][1][(35 + (100 * db_edit))] = Integer.toString(45);
				nm.carbon[nm.ss_settings][1][(36 + (100 * db_edit))] = Integer.toString(46);
				nm.carbon[nm.ss_settings][1][(37 + (100 * db_edit))] = Integer.toString(47);
				nm.carbon[nm.ss_settings][1][(38 + (100 * db_edit))] = Integer.toString(48);
				nm.carbon[nm.ss_settings][1][(39 + (100 * db_edit))] = Integer.toString(49);
				nm.carbon[nm.ss_settings][1][(40 + (100 * db_edit))] = Integer.toString(50);
				nm.carbon[nm.ss_settings][1][(41 + (100 * db_edit))] = Integer.toString(51);
				nm.carbon[nm.ss_settings][1][(42 + (100 * db_edit))] = Integer.toString(52);
				nm.carbon[nm.ss_settings][1][(43 + (100 * db_edit))] = Integer.toString(53);
				nm.carbon[nm.ss_settings][1][(44 + (100 * db_edit))] = Integer.toString(54);
				nm.carbon[nm.ss_settings][1][(45 + (100 * db_edit))] = Integer.toString(55);
				nm.carbon[nm.ss_settings][1][(46 + (100 * db_edit))] = Integer.toString(56);
				nm.carbon[nm.ss_settings][1][(47 + (100 * db_edit))] = Integer.toString(57);
				nm.carbon[nm.ss_settings][1][(48 + (100 * db_edit))] = Integer.toString(58);
				nm.carbon[nm.ss_settings][1][(49 + (100 * db_edit))] = Integer.toString(59);
				nm.carbon[nm.ss_settings][1][(50 + (100 * db_edit))] = Integer.toString(60);
				nm.carbon[nm.ss_settings][1][(51 + (100 * db_edit))] = Integer.toString(61);
				nm.carbon[nm.ss_settings][1][(52 + (100 * db_edit))] = Integer.toString(62);
				nm.carbon[nm.ss_settings][1][(53 + (100 * db_edit))] = Integer.toString(63);
				nm.carbon[nm.ss_settings][1][(54 + (100 * db_edit))] = Integer.toString(64);
				nm.carbon[nm.ss_settings][1][(55 + (100 * db_edit))] = Integer.toString(65);
				nm.carbon[nm.ss_settings][1][(56 + (100 * db_edit))] = Integer.toString(66);
				nm.carbon[nm.ss_settings][1][(57 + (100 * db_edit))] = Integer.toString(67);
				nm.carbon[nm.ss_settings][1][(58 + (100 * db_edit))] = Integer.toString(68);
				nm.carbon[nm.ss_settings][1][(59 + (100 * db_edit))] = Integer.toString(69);
				nm.carbon[nm.ss_settings][1][(60 + (100 * db_edit))] = Integer.toString(70);
				nm.carbon[nm.ss_settings][1][(61 + (100 * db_edit))] = Integer.toString(71);
				nm.carbon[nm.ss_settings][1][(62 + (100 * db_edit))] = Integer.toString(9);//
				nm.carbon[nm.ss_settings][1][(63 + (100 * db_edit))] = Integer.toString(8);//
				nm.carbon[nm.ss_settings][1][(64 + (100 * db_edit))] = Integer.toString(72);
				nm.carbon[nm.ss_settings][1][(65 + (100 * db_edit))] = Integer.toString(73);
				nm.carbon[nm.ss_settings][1][(66 + (100 * db_edit))] = Integer.toString(74);
				nm.carbon[nm.ss_settings][1][(67 + (100 * db_edit))] = Integer.toString(75);
				nm.carbon[nm.ss_settings][1][(68 + (100 * db_edit))] = Integer.toString(76);
				nm.carbon[nm.ss_settings][1][(69 + (100 * db_edit))] = Integer.toString(77);
				nm.carbon[nm.ss_settings][1][(70 + (100 * db_edit))] = Integer.toString(78);
				nm.carbon[nm.ss_settings][1][(71 + (100 * db_edit))] = Integer.toString(12);//
				nm.carbon[nm.ss_settings][1][(72 + (100 * db_edit))] = Integer.toString(7);//
				nm.carbon[nm.ss_settings][1][(73 + (100 * db_edit))] = Integer.toString(79);
				nm.carbon[nm.ss_settings][1][(74 + (100 * db_edit))] = Integer.toString(80);
				nm.carbon[nm.ss_settings][1][(75 + (100 * db_edit))] = Integer.toString(81);
				nm.carbon[nm.ss_settings][1][(76 + (100 * db_edit))] = Integer.toString(82);
				nm.carbon[nm.ss_settings][1][(77 + (100 * db_edit))] = Integer.toString(83);
				nm.carbon[nm.ss_settings][1][(78 + (100 * db_edit))] = Integer.toString(84);
				nm.carbon[nm.ss_settings][1][(79 + (100 * db_edit))] = Integer.toString(3);//
				nm.carbon[nm.ss_settings][1][(80 + (100 * db_edit))] = Integer.toString(85);
				nm.carbon[nm.ss_settings][1][(81 + (100 * db_edit))] = Integer.toString(86);
				nm.carbon[nm.ss_settings][1][(82 + (100 * db_edit))] = Integer.toString(87);
				nm.carbon[nm.ss_settings][1][(83 + (100 * db_edit))] = Integer.toString(88);
				nm.carbon[nm.ss_settings][1][(84 + (100 * db_edit))] = Integer.toString(89);
				nm.carbon[nm.ss_settings][1][(85 + (100 * db_edit))] = Integer.toString(2);//
				nm.carbon[nm.ss_settings][1][(86 + (100 * db_edit))] = Integer.toString(90);
				nm.carbon[nm.ss_settings][1][(87 + (100 * db_edit))] = Integer.toString(13);//
				nm.carbon[nm.ss_settings][1][(88 + (100 * db_edit))] = Integer.toString(91);
				nm.carbon[nm.ss_settings][1][(89 + (100 * db_edit))] = Integer.toString(92);
				nm.carbon[nm.ss_settings][1][(90 + (100 * db_edit))] = Integer.toString(93);
				nm.carbon[nm.ss_settings][1][(91 + (100 * db_edit))] = Integer.toString(94);
				nm.carbon[nm.ss_settings][1][(92 + (100 * db_edit))] = Integer.toString(5);//
				nm.carbon[nm.ss_settings][1][(93 + (100 * db_edit))] = Integer.toString(95);
				nm.carbon[nm.ss_settings][1][(94 + (100 * db_edit))] = Integer.toString(96);
				nm.carbon[nm.ss_settings][1][(95 + (100 * db_edit))] = Integer.toString(14);//
				nm.carbon[nm.ss_settings][1][(96 + (100 * db_edit))] = Integer.toString(97);
				nm.carbon[nm.ss_settings][1][(97 + (100 * db_edit))] = Integer.toString(4);//
				nm.carbon[nm.ss_settings][1][(98 + (100 * db_edit))] = Integer.toString(98);
				nm.carbon[nm.ss_settings][1][(99 + (100 * db_edit))] = Integer.toString(99);

				nm.carbon[nm.ss_settings][2][(0 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(1 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(2 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(3 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(4 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(5 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(6 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(7 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(8 + (100 * db_edit))] = Integer.toString(150);//
				nm.carbon[nm.ss_settings][2][(9 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(10 + (100 * db_edit))] = Integer.toString(300);//
				nm.carbon[nm.ss_settings][2][(11 + (100 * db_edit))] = Integer.toString(150);//
				nm.carbon[nm.ss_settings][2][(12 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(13 + (100 * db_edit))] = Integer.toString(200);
				nm.carbon[nm.ss_settings][2][(14 + (100 * db_edit))] = Integer.toString(150);
				nm.carbon[nm.ss_settings][2][(15 + (100 * db_edit))] = Integer.toString(120);//
				nm.carbon[nm.ss_settings][2][(16 + (100 * db_edit))] = Integer.toString(120);//
				nm.carbon[nm.ss_settings][2][(17 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(18 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(19 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(20 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(21 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(22 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(23 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(24 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(25 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(26 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(27 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(28 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(29 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(30 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(31 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(32 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(33 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(34 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(35 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(36 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(37 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(38 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(39 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(40 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(41 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(42 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(43 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(44 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(45 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(46 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(47 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(48 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(49 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(50 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(51 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(52 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(53 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(54 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(55 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(56 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(57 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(58 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(59 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(60 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(61 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(62 + (100 * db_edit))] = Integer.toString(200);//
				nm.carbon[nm.ss_settings][2][(63 + (100 * db_edit))] = Integer.toString(200);//
				nm.carbon[nm.ss_settings][2][(64 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(65 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(66 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(67 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(68 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(69 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(70 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(71 + (100 * db_edit))] = Integer.toString(100);//
				nm.carbon[nm.ss_settings][2][(72 + (100 * db_edit))] = Integer.toString(100);//
				nm.carbon[nm.ss_settings][2][(73 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(74 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(75 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(76 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(77 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(78 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(79 + (100 * db_edit))] = Integer.toString(200);//
				nm.carbon[nm.ss_settings][2][(80 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(81 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(82 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(83 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(84 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(85 + (100 * db_edit))] = Integer.toString(100);//
				nm.carbon[nm.ss_settings][2][(86 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(87 + (100 * db_edit))] = Integer.toString(100);//
				nm.carbon[nm.ss_settings][2][(88 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(89 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(90 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(91 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(92 + (100 * db_edit))] = Integer.toString(150);//
				nm.carbon[nm.ss_settings][2][(93 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(94 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(95 + (100 * db_edit))] = Integer.toString(120);//
				nm.carbon[nm.ss_settings][2][(96 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(97 + (100 * db_edit))] = Integer.toString(250);//
				nm.carbon[nm.ss_settings][2][(98 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(99 + (100 * db_edit))] = Integer.toString(100);

			}//2
			if(db_edit == 3){

				nm.carbon[nm.ss_settings][0][(0 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(1 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(2 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(3 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(4 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(5 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(6 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(7 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(8 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(9 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(10 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(11 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(12 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(13 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(14 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(15 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(16 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(17 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(18 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(19 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(20 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(21 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(22 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(23 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(24 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(25 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(26 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(27 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(28 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(29 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(30 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(31 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(32 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(33 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(34 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(35 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(36 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(37 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(38 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(39 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(40 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(41 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(42 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(43 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(44 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(45 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(46 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(47 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(48 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(49 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(50 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(51 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(52 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(53 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(54 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(55 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(56 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(57 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(58 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(59 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(60 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(61 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(62 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(63 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(64 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(65 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(66 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(67 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(68 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(69 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(70 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(71 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(72 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(73 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(74 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(75 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(76 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(77 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(78 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(79 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(80 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(81 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(82 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(83 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(84 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(85 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(86 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(87 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(88 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(89 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(90 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(91 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(92 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(93 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(94 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(95 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(96 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(97 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][0][(98 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][0][(99 + (100 * db_edit))] = Integer.toString(0);

				nm.carbon[nm.ss_settings][1][(0 + (100 * db_edit))] = Integer.toString(12);
				nm.carbon[nm.ss_settings][1][(1 + (100 * db_edit))] = Integer.toString(3);
				nm.carbon[nm.ss_settings][1][(2 + (100 * db_edit))] = Integer.toString(5);
				nm.carbon[nm.ss_settings][1][(3 + (100 * db_edit))] = Integer.toString(7);
				nm.carbon[nm.ss_settings][1][(4 + (100 * db_edit))] = Integer.toString(8);
				nm.carbon[nm.ss_settings][1][(5 + (100 * db_edit))] = Integer.toString(9);
				nm.carbon[nm.ss_settings][1][(6 + (100 * db_edit))] = Integer.toString(10);
				nm.carbon[nm.ss_settings][1][(7 + (100 * db_edit))] = Integer.toString(11);
				nm.carbon[nm.ss_settings][1][(8 + (100 * db_edit))] = Integer.toString(1);
				nm.carbon[nm.ss_settings][1][(9 + (100 * db_edit))] = Integer.toString(13);
				nm.carbon[nm.ss_settings][1][(10 + (100 * db_edit))] = Integer.toString(14);
				nm.carbon[nm.ss_settings][1][(11 + (100 * db_edit))] = Integer.toString(0);
				nm.carbon[nm.ss_settings][1][(12 + (100 * db_edit))] = Integer.toString(15);
				nm.carbon[nm.ss_settings][1][(13 + (100 * db_edit))] = Integer.toString(16);
				nm.carbon[nm.ss_settings][1][(14 + (100 * db_edit))] = Integer.toString(17);
				nm.carbon[nm.ss_settings][1][(15 + (100 * db_edit))] = Integer.toString(18);
				nm.carbon[nm.ss_settings][1][(16 + (100 * db_edit))] = Integer.toString(20);
				nm.carbon[nm.ss_settings][1][(17 + (100 * db_edit))] = Integer.toString(19);
				nm.carbon[nm.ss_settings][1][(18 + (100 * db_edit))] = Integer.toString(21);
				nm.carbon[nm.ss_settings][1][(19 + (100 * db_edit))] = Integer.toString(22);
				nm.carbon[nm.ss_settings][1][(20 + (100 * db_edit))] = Integer.toString(23);
				nm.carbon[nm.ss_settings][1][(21 + (100 * db_edit))] = Integer.toString(24);
				nm.carbon[nm.ss_settings][1][(22 + (100 * db_edit))] = Integer.toString(25);
				nm.carbon[nm.ss_settings][1][(23 + (100 * db_edit))] = Integer.toString(26);
				nm.carbon[nm.ss_settings][1][(24 + (100 * db_edit))] = Integer.toString(27);
				nm.carbon[nm.ss_settings][1][(25 + (100 * db_edit))] = Integer.toString(28);
				nm.carbon[nm.ss_settings][1][(26 + (100 * db_edit))] = Integer.toString(29);
				nm.carbon[nm.ss_settings][1][(27 + (100 * db_edit))] = Integer.toString(30);
				nm.carbon[nm.ss_settings][1][(28 + (100 * db_edit))] = Integer.toString(31);
				nm.carbon[nm.ss_settings][1][(29 + (100 * db_edit))] = Integer.toString(32);
				nm.carbon[nm.ss_settings][1][(30 + (100 * db_edit))] = Integer.toString(33);
				nm.carbon[nm.ss_settings][1][(31 + (100 * db_edit))] = Integer.toString(34);
				nm.carbon[nm.ss_settings][1][(32 + (100 * db_edit))] = Integer.toString(35);
				nm.carbon[nm.ss_settings][1][(33 + (100 * db_edit))] = Integer.toString(36);
				nm.carbon[nm.ss_settings][1][(34 + (100 * db_edit))] = Integer.toString(37);
				nm.carbon[nm.ss_settings][1][(35 + (100 * db_edit))] = Integer.toString(38);
				nm.carbon[nm.ss_settings][1][(36 + (100 * db_edit))] = Integer.toString(39);
				nm.carbon[nm.ss_settings][1][(37 + (100 * db_edit))] = Integer.toString(40);
				nm.carbon[nm.ss_settings][1][(38 + (100 * db_edit))] = Integer.toString(41);
				nm.carbon[nm.ss_settings][1][(39 + (100 * db_edit))] = Integer.toString(42);
				nm.carbon[nm.ss_settings][1][(40 + (100 * db_edit))] = Integer.toString(43);
				nm.carbon[nm.ss_settings][1][(41 + (100 * db_edit))] = Integer.toString(44);
				nm.carbon[nm.ss_settings][1][(42 + (100 * db_edit))] = Integer.toString(45);
				nm.carbon[nm.ss_settings][1][(43 + (100 * db_edit))] = Integer.toString(46);
				nm.carbon[nm.ss_settings][1][(44 + (100 * db_edit))] = Integer.toString(47);
				nm.carbon[nm.ss_settings][1][(45 + (100 * db_edit))] = Integer.toString(48);
				nm.carbon[nm.ss_settings][1][(46 + (100 * db_edit))] = Integer.toString(49);
				nm.carbon[nm.ss_settings][1][(47 + (100 * db_edit))] = Integer.toString(50);
				nm.carbon[nm.ss_settings][1][(48 + (100 * db_edit))] = Integer.toString(51);
				nm.carbon[nm.ss_settings][1][(49 + (100 * db_edit))] = Integer.toString(52);
				nm.carbon[nm.ss_settings][1][(50 + (100 * db_edit))] = Integer.toString(53);
				nm.carbon[nm.ss_settings][1][(51 + (100 * db_edit))] = Integer.toString(54);
				nm.carbon[nm.ss_settings][1][(52 + (100 * db_edit))] = Integer.toString(55);
				nm.carbon[nm.ss_settings][1][(53 + (100 * db_edit))] = Integer.toString(56);
				nm.carbon[nm.ss_settings][1][(54 + (100 * db_edit))] = Integer.toString(57);
				nm.carbon[nm.ss_settings][1][(55 + (100 * db_edit))] = Integer.toString(58);
				nm.carbon[nm.ss_settings][1][(56 + (100 * db_edit))] = Integer.toString(59);
				nm.carbon[nm.ss_settings][1][(57 + (100 * db_edit))] = Integer.toString(60);
				nm.carbon[nm.ss_settings][1][(58 + (100 * db_edit))] = Integer.toString(61);
				nm.carbon[nm.ss_settings][1][(59 + (100 * db_edit))] = Integer.toString(62);
				nm.carbon[nm.ss_settings][1][(60 + (100 * db_edit))] = Integer.toString(63);
				nm.carbon[nm.ss_settings][1][(61 + (100 * db_edit))] = Integer.toString(64);
				nm.carbon[nm.ss_settings][1][(62 + (100 * db_edit))] = Integer.toString(65);
				nm.carbon[nm.ss_settings][1][(63 + (100 * db_edit))] = Integer.toString(2);
				nm.carbon[nm.ss_settings][1][(64 + (100 * db_edit))] = Integer.toString(66);
				nm.carbon[nm.ss_settings][1][(65 + (100 * db_edit))] = Integer.toString(67);
				nm.carbon[nm.ss_settings][1][(66 + (100 * db_edit))] = Integer.toString(68);
				nm.carbon[nm.ss_settings][1][(67 + (100 * db_edit))] = Integer.toString(69);
				nm.carbon[nm.ss_settings][1][(68 + (100 * db_edit))] = Integer.toString(70);
				nm.carbon[nm.ss_settings][1][(69 + (100 * db_edit))] = Integer.toString(71);
				nm.carbon[nm.ss_settings][1][(70 + (100 * db_edit))] = Integer.toString(72);
				nm.carbon[nm.ss_settings][1][(71 + (100 * db_edit))] = Integer.toString(73);
				nm.carbon[nm.ss_settings][1][(72 + (100 * db_edit))] = Integer.toString(74);
				nm.carbon[nm.ss_settings][1][(73 + (100 * db_edit))] = Integer.toString(75);
				nm.carbon[nm.ss_settings][1][(74 + (100 * db_edit))] = Integer.toString(99);
				nm.carbon[nm.ss_settings][1][(75 + (100 * db_edit))] = Integer.toString(76);
				nm.carbon[nm.ss_settings][1][(76 + (100 * db_edit))] = Integer.toString(77);
				nm.carbon[nm.ss_settings][1][(77 + (100 * db_edit))] = Integer.toString(78);
				nm.carbon[nm.ss_settings][1][(78 + (100 * db_edit))] = Integer.toString(79);
				nm.carbon[nm.ss_settings][1][(79 + (100 * db_edit))] = Integer.toString(4);
				nm.carbon[nm.ss_settings][1][(80 + (100 * db_edit))] = Integer.toString(80);
				nm.carbon[nm.ss_settings][1][(81 + (100 * db_edit))] = Integer.toString(81);
				nm.carbon[nm.ss_settings][1][(82 + (100 * db_edit))] = Integer.toString(82);
				nm.carbon[nm.ss_settings][1][(83 + (100 * db_edit))] = Integer.toString(83);
				nm.carbon[nm.ss_settings][1][(84 + (100 * db_edit))] = Integer.toString(84);
				nm.carbon[nm.ss_settings][1][(85 + (100 * db_edit))] = Integer.toString(85);
				nm.carbon[nm.ss_settings][1][(86 + (100 * db_edit))] = Integer.toString(86);
				nm.carbon[nm.ss_settings][1][(87 + (100 * db_edit))] = Integer.toString(87);
				nm.carbon[nm.ss_settings][1][(88 + (100 * db_edit))] = Integer.toString(88);
				nm.carbon[nm.ss_settings][1][(89 + (100 * db_edit))] = Integer.toString(89);
				nm.carbon[nm.ss_settings][1][(90 + (100 * db_edit))] = Integer.toString(90);
				nm.carbon[nm.ss_settings][1][(91 + (100 * db_edit))] = Integer.toString(91);
				nm.carbon[nm.ss_settings][1][(92 + (100 * db_edit))] = Integer.toString(92);
				nm.carbon[nm.ss_settings][1][(93 + (100 * db_edit))] = Integer.toString(93);
				nm.carbon[nm.ss_settings][1][(94 + (100 * db_edit))] = Integer.toString(94);
				nm.carbon[nm.ss_settings][1][(95 + (100 * db_edit))] = Integer.toString(95);
				nm.carbon[nm.ss_settings][1][(96 + (100 * db_edit))] = Integer.toString(96);
				nm.carbon[nm.ss_settings][1][(97 + (100 * db_edit))] = Integer.toString(6);
				nm.carbon[nm.ss_settings][1][(98 + (100 * db_edit))] = Integer.toString(97);
				nm.carbon[nm.ss_settings][1][(99 + (100 * db_edit))] = Integer.toString(98);

				nm.carbon[nm.ss_settings][2][(0 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(1 + (100 * db_edit))] = Integer.toString(200);
				nm.carbon[nm.ss_settings][2][(2 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(3 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(4 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(5 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(6 + (100 * db_edit))] = Integer.toString(140);
				nm.carbon[nm.ss_settings][2][(7 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(8 + (100 * db_edit))] = Integer.toString(150);
				nm.carbon[nm.ss_settings][2][(9 + (100 * db_edit))] = Integer.toString(200);
				nm.carbon[nm.ss_settings][2][(10 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(11 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(12 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(13 + (100 * db_edit))] = Integer.toString(200);
				nm.carbon[nm.ss_settings][2][(14 + (100 * db_edit))] = Integer.toString(150);
				nm.carbon[nm.ss_settings][2][(15 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(16 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(17 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(18 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(19 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(20 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(21 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(22 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(23 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(24 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(25 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(26 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(27 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(28 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(29 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(30 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(31 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(32 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(33 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(34 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(35 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(36 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(37 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(38 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(39 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(40 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(41 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(42 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(43 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(44 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(45 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(46 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(47 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(48 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(49 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(50 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(51 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(52 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(53 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(54 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(55 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(56 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(57 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(58 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(59 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(60 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(61 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(62 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(63 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(64 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(65 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(66 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(67 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(68 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(69 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(70 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(71 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(72 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(73 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(74 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(75 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(76 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(77 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(78 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(79 + (100 * db_edit))] = Integer.toString(200);
				nm.carbon[nm.ss_settings][2][(80 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(81 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(82 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(83 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(84 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(85 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(86 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(87 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(88 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(89 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(90 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(91 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(92 + (100 * db_edit))] = Integer.toString(150);
				nm.carbon[nm.ss_settings][2][(93 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(94 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(95 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(96 + (100 * db_edit))] = Integer.toString(100);
				nm.carbon[nm.ss_settings][2][(97 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(98 + (100 * db_edit))] = Integer.toString(300);
				nm.carbon[nm.ss_settings][2][(99 + (100 * db_edit))] = Integer.toString(240);

			}//3


			loadx_x();
		}//ifresponse

	}//savex










//handel all the button clicks. 
public void actionPerformed(ActionEvent event){



	if(event.getSource() == create){db_edit = 1; loadx_x();} 
	if(event.getSource() == sold){db_edit = 2; loadx_x();} 
	if(event.getSource() == archive){db_edit = 3; loadx_x();} 
	if(event.getSource() == reset){reset_x();}


	savex_x();


	for (int loop1 = 0; loop1 < 100; loop1++){

		if(event.getSource() == jcbx[loop1] && jcbx[loop1].isSelected()){

			for (int loop2 = 0; loop2 < 100; loop2++){//*********
				if(nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))].equals(Integer.toString(loop1))){nm.carbon[nm.ss_settings][0][(loop2 + (100 * db_edit))] = "1"; System.out.println(loop1);}
			}//for***********************************************

		}//**************************************************************
		else if(event.getSource() == jcbx[loop1] && !jcbx[loop1].isSelected()){//**********************************************************

			for (int loop2 = 0; loop2 < 100; loop2++){//*********
				if(nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))].equals(Integer.toString(loop1))){nm.carbon[nm.ss_settings][0][(loop2 + (100 * db_edit))] = "0"; System.out.println(loop1);}
			}//for***********************************************

		}//**************************************************************




		if(event.getSource() == jup[loop1] && loop1 > 0){//************************

			for (int loop2 = 0; loop2 < 100; loop2++){//*********
				if(nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))].equals(Integer.toString(loop1))){nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))] = "1000"; System.out.println("loop 1 " + loop1);}
			}//for***********************************************

			for (int loop2 = 0; loop2 < 100; loop2++){//*********
				if(nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))].equals(Integer.toString( (loop1 -1) ))){nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))] = Integer.toString(loop1); System.out.println("loop 2 " + loop2);}
			}//for***********************************************

			for (int loop2 = 0; loop2 < 100; loop2++){//*********
				if(nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))].equals("1000")){nm.carbon[nm.ss_settings][1][(loop2 + (100 * db_edit))] = Integer.toString(loop1 -1); loadx_x(); break;}
			}//for***********************************************

		}//************************************************************************




	}//****************************************




}//actionPerformed














    public static void main(){

		alchemy_display_viewer xr = new alchemy_display_viewer();

    }//main










}//last****************************************
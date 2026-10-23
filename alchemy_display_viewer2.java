import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;





public class alchemy_display_viewer2 implements ActionListener{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 700;
int xzy = 500;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

FlowLayout flow;

static JScrollPane scrollPane1;
static JScrollPane scrollPane2;

JPanel jpk1 = new JPanel();
JPanel jpk2 = new JPanel();

Object newItem;
JComboBox cb;

static JPanel jpkf;
static JPanel jpk3;
static JPanel jpkbk;


JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);
JLabel v_space = new JLabel("", JLabel.LEFT);

int csv_passes_x = 17;

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
int move_up = 0;
int move_count = 0;
int move_up_test = 0;
int hold_up = 0;
int itemx = 0;
int response = 1100;


Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color bluex2 = new Color(0.2f, 0.27f, 0.39f);
Color grayx0 = new Color(0.85f, 0.85f, 0.85f);
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

String settings[][] = new String[1][1];
String xlinex = new String("");
String blank = new String("");



JButton create = new JButton("Create");
JButton sold = new JButton("Sold");
JButton archive = new JButton("Archive");
JButton reset = new JButton("Reset");
JButton preset = new JButton("Presets");

JButton add_item = new JButton(">>>");
JButton sub_item = new JButton("<<<");

JButton saves = new JButton("Save");




JLabel not_international_l = new JLabel("If the sale is NOT international then use (MAIL TYPE) settings in this field: ", JLabel.LEFT);
JComboBox not_international_cb = new JComboBox();

JTextField save_size = new JTextField("", 4);

JLabel info_header2_1 = new JLabel("Import ?? days past.", JLabel.RIGHT);
JLabel info_header2_2 = new JLabel("Import ONLY inventoried items.", JLabel.RIGHT);
JTextField sales_days_past = new JTextField("", 12);
JCheckBox import_everything = new JCheckBox();


ImageIcon imx2;
ImageIcon imx3;
ImageIcon imx4;








alchemy_display_viewer2(){//****************************




	imx2 = new ImageIcon(this.getClass().getResource("images/buttonimage2.png"));
	imx3 = new ImageIcon(this.getClass().getResource("images/buttonimage3.png"));
	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));




	create.setMargin(new Insets(0, 0, 0, 0));
  	create.addActionListener(this);
 	create.setPreferredSize(new Dimension(100, 25)); 
	create.setHorizontalTextPosition(JButton.CENTER);
 	create.setForeground(grayx1);
	create.setToolTipText("The EXPORT database");


	sold.setMargin(new Insets(0, 0, 0, 0));
  	sold.addActionListener(this);
 	sold.setPreferredSize(new Dimension(100, 25));
	sold.setHorizontalTextPosition(JButton.CENTER);
 	sold.setForeground(grayx1);
	sold.setToolTipText("The SOLD database");


	archive.setMargin(new Insets(0, 0, 0, 0));
  	archive.addActionListener(this);
 	archive.setPreferredSize(new Dimension(100, 25));
	archive.setHorizontalTextPosition(JButton.CENTER);
 	archive.setForeground(grayx1);
	archive.setToolTipText("The ARCHIVE database");








	reset.setMargin(new Insets(0, 0, 0, 0));
 	reset.setPreferredSize(new Dimension(95, 20));
  	reset.addActionListener(this);
	reset.setHorizontalTextPosition(JButton.CENTER);
 	reset.setForeground(blackx);
	reset.setBackground(grayx0);
 	//reset.setIcon(imx4); 

	preset.setMargin(new Insets(0, 0, 0, 0));
 	preset.setPreferredSize(new Dimension(95, 20));
  	preset.addActionListener(this);
	preset.setHorizontalTextPosition(JButton.CENTER);
 	preset.setForeground(blackx);
	preset.setBackground(grayx0);
 	//preset.setIcon(imx4); 







	add_item.setMargin(new Insets(0, 0, 0, 0));
  	add_item.addActionListener(this);
 	add_item.setPreferredSize(new Dimension(68, 25));
	add_item.setHorizontalTextPosition(JButton.CENTER);
 	add_item.setForeground(blackx);
	add_item.setBackground(grayx0);
	add_item.setToolTipText("Add Item");


	sub_item.setMargin(new Insets(0, 0, 0, 0));
  	sub_item.addActionListener(this);
 	sub_item.setPreferredSize(new Dimension(68, 25));
	sub_item.setHorizontalTextPosition(JButton.CENTER);
 	sub_item.setForeground(blackx);
	sub_item.setBackground(grayx0);
	sub_item.setToolTipText("Remove Item");





	JLabel space_ss3 = new JLabel("", JLabel.RIGHT);
	space_ss3.setPreferredSize(new Dimension(100, 50));

	JLabel size_ss = new JLabel("Size:", JLabel.RIGHT);
	size_ss.setPreferredSize(new Dimension(42, 20));

	saves.setMargin(new Insets(0, 0, 0, 0));
  	saves.addActionListener(this);
 	saves.setPreferredSize(new Dimension(68, 25));
	saves.setHorizontalTextPosition(JButton.CENTER);
 	saves.setForeground(blackx);
	saves.setBackground(grayx0);
	saves.setToolTipText("Save settings");









	stop = 0;
	csv_int = 0;
	thisc3 = 0;

	ImageIcon imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));


	ix0 = 120;
	ix1 = 20;



	v_space.setPreferredSize(new Dimension(50, 150));
	info_header2_1.setPreferredSize(new Dimension(130, 20));
	info_header2_2.setPreferredSize(new Dimension(290, 20));



	flow = new FlowLayout(0);
	flow.setHgap(1);
	flow.setVgap(1);





	JPanel jpk_xt = new JPanel(flow);
	jpk_xt.setPreferredSize(new Dimension(110, 300));
	jpk_xt.setBackground(grayx0);
	jpk_xt.add(create);
	jpk_xt.add(sold);
	jpk_xt.add(archive);


	scrollPane1 = new JScrollPane(jpk1);
	scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane1.setPreferredSize(new Dimension((xzx /2) -40, xzy -85));
	//scrollPane1.setBackground(bluex2);
	scrollPane1.setFont(new Font("Arial", Font.PLAIN, 14));


	jpk3 = new JPanel();
	jpk3.setPreferredSize(new Dimension(71, xzy -85));
	jpk3.setBackground(grayx0);
	jpk3.add(v_space);
	jpk3.add(add_item);
	jpk3.add(sub_item);


	scrollPane2 = new JScrollPane(jpk2);
	scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPane2.setPreferredSize(new Dimension((xzx /2) -40, xzy -85));
	//scrollPane2.setBackground(bluex2);
	scrollPane2.setFont(new Font("Arial", Font.PLAIN, 14));


	jpkf = new JPanel();
	jpkf.setPreferredSize(new Dimension(100, 300));
	jpkf.setBackground(grayx0);
	jpkf.add(reset);
	jpkf.add(preset);
	jpkf.add(space_ss3);
	jpkf.add(size_ss);
	jpkf.add(save_size);
	jpkf.add(saves);



	jpkbk = new JPanel();
	jpkbk.setPreferredSize(new Dimension(700, 500));
	jpkbk.setBackground(grayx0);
	jpkbk.add(jpk_xt);
	jpkbk.add(scrollPane1);
	jpkbk.add(jpk3);
	jpkbk.add(scrollPane2);
	jpkbk.add(jpkf);


	//nm.display_panel.add(jpkbk);




	db_edit = 0; 
	loadx_x();
	displayx();

}//csv_loader_x1********************************************************







	public void loadx_x(){


		if(db_edit == 0){

			create.setBackground(grayx1);
			sold.setBackground(grayx0);
			archive.setBackground(grayx0);
			create.setForeground(blackx); 
			sold.setForeground(grayx1); 
			archive.setForeground(grayx1);

		}//**************
 		if(db_edit == 1){

 			create.setBackground(grayx0);
 			sold.setBackground(grayx1);
 			archive.setBackground(grayx0);
 			create.setForeground(grayx1); 
 			sold.setForeground(blackx); 
 			archive.setForeground(grayx1);

 		}//**************
		if(db_edit == 2){

			create.setBackground(grayx0);
			sold.setBackground(grayx0);
			archive.setBackground(grayx1);
			create.setForeground(grayx1); 
			sold.setForeground(grayx1); 
			archive.setForeground(blackx);

		}//**************



		displayx();


	}//*******************



	public void savex_x(){




	}



	public void reset_x(){


		response = JOptionPane.showConfirmDialog(null, "Are you sure you want to overwrite settings?");
		if(response == 0){//***************************************************************************

			if(db_edit == 0){

				for (int loop1 = 0; loop1 < 100; loop1++){

					nm.settings_display[0][(loop1 + (100 * db_edit))] = "0";
					nm.settings_display[1][(loop1 + (100 * db_edit))] = "1000";

				}//***************************************

				move_up = 0;
				displayx();

			}//**************


			if(db_edit == 1){

				for (int loop1 = 0; loop1 < 100; loop1++){

					nm.settings_display[0][(loop1 + (100 * db_edit))] = "0";
					nm.settings_display[1][(loop1 + (100 * db_edit))] = "1000";

				}//***************************************

				move_up = 0;
				displayx();

			}//**************


			if(db_edit == 2){

				for (int loop1 = 0; loop1 < 100; loop1++){

					nm.settings_display[0][(loop1 + (100 * db_edit))] = "0";
					nm.settings_display[1][(loop1 + (100 * db_edit))] = "1000";

				}//***************************************

				move_up = 0;
				displayx();

			}//**************


		}//reset****************************************************************************************


	}//*******************














	public void displayx(){


		int xxs1 = 0;
		int xxs2 = 0;


		jpk1.removeAll();
		jpk1.setLayout(flow);
		jpk1.setBackground(grayx2);

		jpk2.removeAll();
		jpk2.setLayout(flow);
		jpk2.setBackground(grayx2);


		for (int loop1 = 0; loop1 < 100; loop1++){
	
			jup[loop1] = new JButton(nm.db_string[loop1]);
			jup[loop1].setPreferredSize(new Dimension((xzx / 2) -62, 23));
			jup[loop1].addActionListener(this);
			jup[loop1].setBackground(nm.st_gray1);
			jup[loop1].setForeground(blackx);
			jup[loop1].setBorder(null);


			if(nm.settings_display[0][(loop1 + (100 * db_edit))].equals("0")){xxs1 = xxs1 + 24; jpk1.add(jup[loop1]);}

		}//*******************************************


		move_up = 0;
		move_up_test = 0;

		for (int loop0 = 0; loop0 < 100; loop0++){

			move_up_test = move_up;

			for (int loop1 = 0; loop1 < 100; loop1++){

				if(nm.settings_display[0][(loop1 + (100 * db_edit))].equals("1")){

					if(nm.settings_display[1][(loop1 + (100 * db_edit))].equals(Integer.toString(loop0))){

						jup[loop1] = new JButton(nm.db_string[loop1]);
						jup[loop1].setPreferredSize(new Dimension((xzx / 2) -62, 23));
						jup[loop1].addActionListener(this);
						jup[loop1].setBackground(nm.st_gray1);
						jup[loop1].setForeground(blackx);
						jup[loop1].setBorder(null);

				
						xxs2 = xxs2 + 24; 
						jpk2.add(jup[loop1]);
						move_up++;

					}//*************************************************************************************

				}//***************************************************************

			}//*******************************************

		}//*******************************************



		jpk1.setPreferredSize(new Dimension((xzx / 2) -60, xxs1));
		jpk2.setPreferredSize(new Dimension((xzx / 2) -60, xxs2));


		//scrollPane1.removeAll();
		//scrollPane1.add(jpk1);
		scrollPane1.revalidate();
		scrollPane1.repaint();


		//scrollPane2.removeAll();
		//scrollPane2.add(jpk2);
		scrollPane2.revalidate();
		scrollPane2.repaint();


	}//********************

















	public void preset_x(){

	response = JOptionPane.showConfirmDialog(null, "Are you sure you want to overwrite settings?");

	if(response == 0){


		if(db_edit == 0){

			nm.settings_display[0][(0 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(1 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(2 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(3 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(4 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(5 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(6 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(7 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(8 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(9 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(10 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(11 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(12 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(13 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(14 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(15 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(16 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(17 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(18 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(19 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(20 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(21 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(22 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(23 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(24 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(25 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(26 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(27 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(28 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(29 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(30 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(31 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(32 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(33 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(34 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(35 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(36 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(37 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(38 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(39 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(40 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(41 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(42 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(43 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(44 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(45 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(46 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(47 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(48 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(49 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(50 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(51 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(52 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(53 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(54 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(55 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(56 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(57 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(58 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(59 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(60 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(61 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(62 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(63 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(64 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(65 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(66 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(67 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(68 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(69 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(70 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(71 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(72 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(73 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(74 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(75 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(76 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(77 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(78 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(79 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(80 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(81 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(82 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(83 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(84 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(85 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(86 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(87 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(88 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(89 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(90 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(91 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(92 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(93 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(94 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(95 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(96 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(97 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(98 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(99 + (100 * db_edit))] = Integer.toString(0);

			nm.settings_display[1][(0 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(1 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(2 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(3 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(4 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(5 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(6 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(7 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(8 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(9 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(10 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(11 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(12 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(13 + (100 * db_edit))] = Integer.toString(8);
			nm.settings_display[1][(14 + (100 * db_edit))] = Integer.toString(9);
			nm.settings_display[1][(15 + (100 * db_edit))] = Integer.toString(13);
			nm.settings_display[1][(16 + (100 * db_edit))] = Integer.toString(14);
			nm.settings_display[1][(17 + (100 * db_edit))] = Integer.toString(15);
			nm.settings_display[1][(18 + (100 * db_edit))] = Integer.toString(16);
			nm.settings_display[1][(19 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(20 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(21 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(22 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(23 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(24 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(25 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(26 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(27 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(28 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(29 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(30 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(31 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(32 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(33 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(34 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(35 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(36 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(37 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(38 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(39 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(40 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(41 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(42 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(43 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(44 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(45 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(46 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(47 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(48 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(49 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(50 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(51 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(52 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(53 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(54 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(55 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(56 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(57 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(58 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(59 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(60 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(61 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(62 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(63 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(64 + (100 * db_edit))] = Integer.toString(7);
			nm.settings_display[1][(65 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(66 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(67 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(68 + (100 * db_edit))] = Integer.toString(4);
			nm.settings_display[1][(69 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(70 + (100 * db_edit))] = Integer.toString(10);
			nm.settings_display[1][(71 + (100 * db_edit))] = Integer.toString(5);
			nm.settings_display[1][(72 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(73 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(74 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(75 + (100 * db_edit))] = Integer.toString(12);
			nm.settings_display[1][(76 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(77 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(78 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(79 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[1][(80 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(81 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(82 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(83 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(84 + (100 * db_edit))] = Integer.toString(11);
			nm.settings_display[1][(85 + (100 * db_edit))] = Integer.toString(2);
			nm.settings_display[1][(86 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(87 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(88 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(89 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(90 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(91 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(92 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(93 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[1][(94 + (100 * db_edit))] = Integer.toString(3);
			nm.settings_display[1][(95 + (100 * db_edit))] = Integer.toString(6);
			nm.settings_display[1][(96 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(97 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(98 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(99 + (100 * db_edit))] = Integer.toString(1000);

			nm.settings_display[2][(0 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(1 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(2 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(3 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(4 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(5 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(6 + (100 * db_edit))] = Integer.toString(140);
			nm.settings_display[2][(7 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(8 + (100 * db_edit))] = Integer.toString(150);
			nm.settings_display[2][(9 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(10 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(11 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(12 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(13 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(14 + (100 * db_edit))] = Integer.toString(150);
			nm.settings_display[2][(15 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(16 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(17 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(18 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(19 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(20 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(21 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(22 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(23 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(24 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(25 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(26 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(27 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(28 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(29 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(30 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(31 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(32 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(33 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(34 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(35 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(36 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(37 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(38 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(39 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(40 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(41 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(42 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(43 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(44 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(45 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(46 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(47 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(48 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(49 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(50 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(51 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(52 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(53 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(54 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(55 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(56 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(57 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(58 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(59 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(60 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(61 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(62 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(63 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(64 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(65 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(66 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(67 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(68 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(69 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(70 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(71 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(72 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(73 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(74 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(75 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(76 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(77 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(78 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(79 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(80 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(81 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(82 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(83 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(84 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(85 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(86 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(87 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(88 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(89 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(90 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(91 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(92 + (100 * db_edit))] = Integer.toString(150);
			nm.settings_display[2][(93 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(94 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(95 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(96 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(97 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(98 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(99 + (100 * db_edit))] = Integer.toString(240);

		}//1
		if(db_edit == 1){

			nm.settings_display[0][(0 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(1 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(2 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(3 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(4 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(5 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(6 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(7 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(8 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(9 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(10 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(11 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(12 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(13 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(14 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(15 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(16 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(17 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(18 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(19 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(20 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(21 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(22 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(23 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(24 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(25 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(26 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(27 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(28 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(29 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(30 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(31 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(32 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(33 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(34 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(35 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(36 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(37 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(38 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(39 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(40 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(41 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(42 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(43 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(44 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(45 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(46 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(47 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(48 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(49 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(50 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(51 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(52 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(53 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(54 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(55 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(56 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(57 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(58 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(59 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(60 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(61 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(62 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(63 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(64 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(65 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(66 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(67 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(68 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(69 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(70 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(71 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(72 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(73 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(74 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(75 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(76 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(77 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(78 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(79 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(80 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(81 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(82 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(83 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(84 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(85 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(86 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(87 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(88 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(89 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(90 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(91 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(92 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(93 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(94 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(95 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(96 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(97 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[0][(98 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(99 + (100 * db_edit))] = Integer.toString(0);

			nm.settings_display[1][(0 + (100 * db_edit))] = Integer.toString(15);
			nm.settings_display[1][(1 + (100 * db_edit))] = Integer.toString(16);
			nm.settings_display[1][(2 + (100 * db_edit))] = Integer.toString(17);
			nm.settings_display[1][(3 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(4 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(5 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(6 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(7 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(8 + (100 * db_edit))] = Integer.toString(1);//
			nm.settings_display[1][(9 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(10 + (100 * db_edit))] = Integer.toString(7);//
			nm.settings_display[1][(11 + (100 * db_edit))] = Integer.toString(0);//
			nm.settings_display[1][(12 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(13 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(14 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(15 + (100 * db_edit))] = Integer.toString(11);//
			nm.settings_display[1][(16 + (100 * db_edit))] = Integer.toString(12);//
			nm.settings_display[1][(17 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(18 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(19 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(20 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(21 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(22 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(23 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(24 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(25 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(26 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(27 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(28 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(29 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(30 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(31 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(32 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(33 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(34 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(35 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(36 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(37 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(38 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(39 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(40 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(41 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(42 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(43 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(44 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(45 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(46 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(47 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(48 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(49 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(50 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(51 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(52 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(53 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(54 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(55 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(56 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(57 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(58 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(59 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(60 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(61 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(62 + (100 * db_edit))] = Integer.toString(10);//
			nm.settings_display[1][(63 + (100 * db_edit))] = Integer.toString(9);//
			nm.settings_display[1][(64 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(65 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(66 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(67 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(68 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(69 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(70 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(71 + (100 * db_edit))] = Integer.toString(13);//
			nm.settings_display[1][(72 + (100 * db_edit))] = Integer.toString(8);//
			nm.settings_display[1][(73 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(74 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(75 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(76 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(77 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(78 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(79 + (100 * db_edit))] = Integer.toString(4);//
			nm.settings_display[1][(80 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(81 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(82 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(83 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(84 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(85 + (100 * db_edit))] = Integer.toString(2);//
			nm.settings_display[1][(86 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(87 + (100 * db_edit))] = Integer.toString(14);//
			nm.settings_display[1][(88 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(89 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(90 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(91 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(92 + (100 * db_edit))] = Integer.toString(6);//
			nm.settings_display[1][(93 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(94 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(95 + (100 * db_edit))] = Integer.toString(3);//
			nm.settings_display[1][(96 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(97 + (100 * db_edit))] = Integer.toString(5);//
			nm.settings_display[1][(98 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(99 + (100 * db_edit))] = Integer.toString(1000);

			nm.settings_display[2][(0 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(1 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(2 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(3 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(4 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(5 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(6 + (100 * db_edit))] = Integer.toString(140);
			nm.settings_display[2][(7 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(8 + (100 * db_edit))] = Integer.toString(180);
			nm.settings_display[2][(9 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(10 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(11 + (100 * db_edit))] = Integer.toString(130);
			nm.settings_display[2][(12 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(13 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(14 + (100 * db_edit))] = Integer.toString(150);
			nm.settings_display[2][(15 + (100 * db_edit))] = Integer.toString(130);
			nm.settings_display[2][(16 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(17 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(18 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(19 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(20 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(21 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(22 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(23 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(24 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(25 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(26 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(27 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(28 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(29 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(30 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(31 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(32 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(33 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(34 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(35 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(36 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(37 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(38 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(39 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(40 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(41 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(42 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(43 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(44 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(45 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(46 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(47 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(48 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(49 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(50 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(51 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(52 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(53 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(54 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(55 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(56 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(57 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(58 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(59 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(60 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(61 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(62 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(63 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(64 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(65 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(66 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(67 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(68 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(69 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(70 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(71 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(72 + (100 * db_edit))] = Integer.toString(120);
			nm.settings_display[2][(73 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(74 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(75 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(76 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(77 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(78 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(79 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(80 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(81 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(82 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(83 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(84 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(85 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(86 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(87 + (100 * db_edit))] = Integer.toString(120);
			nm.settings_display[2][(88 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(89 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(90 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(91 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(92 + (100 * db_edit))] = Integer.toString(150);
			nm.settings_display[2][(93 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(94 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(95 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(96 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(97 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(98 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(99 + (100 * db_edit))] = Integer.toString(240);

		}//2
		if(db_edit == 2){

			nm.settings_display[0][(0 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(1 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(2 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(3 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(4 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(5 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(6 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(7 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(8 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(9 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(10 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(11 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(12 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(13 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(14 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(15 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(16 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(17 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(18 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(19 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(20 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(21 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(22 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(23 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(24 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(25 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(26 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(27 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(28 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(29 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(30 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(31 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(32 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(33 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(34 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(35 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(36 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(37 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(38 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(39 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(40 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(41 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(42 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(43 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(44 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(45 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(46 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(47 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(48 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(49 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(50 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(51 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(52 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(53 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(54 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(55 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(56 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(57 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(58 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(59 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(60 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(61 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(62 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(63 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(64 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(65 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(66 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(67 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(68 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(69 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(70 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(71 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(72 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(73 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(74 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(75 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(76 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(77 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(78 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(79 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(80 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(81 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(82 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(83 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(84 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(85 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(86 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(87 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(88 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(89 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(90 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(91 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(92 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(93 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(94 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(95 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(96 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(97 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[0][(98 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[0][(99 + (100 * db_edit))] = Integer.toString(0);

			nm.settings_display[1][(0 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(1 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(2 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(3 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(4 + (100 * db_edit))] = Integer.toString(7);
			nm.settings_display[1][(5 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(6 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(7 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(8 + (100 * db_edit))] = Integer.toString(1);
			nm.settings_display[1][(9 + (100 * db_edit))] = Integer.toString(9);
			nm.settings_display[1][(10 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(11 + (100 * db_edit))] = Integer.toString(0);
			nm.settings_display[1][(12 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(13 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(14 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(15 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(16 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(17 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(18 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(19 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(20 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(21 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(22 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(23 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(24 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(25 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(26 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(27 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(28 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(29 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(30 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(31 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(32 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(33 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(34 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(35 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(36 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(37 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(38 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(39 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(40 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(41 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(42 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(43 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(44 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(45 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(46 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(47 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(48 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(49 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(50 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(51 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(52 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(53 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(54 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(55 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(56 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(57 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(58 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(59 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(60 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(61 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(62 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(63 + (100 * db_edit))] = Integer.toString(2);
			nm.settings_display[1][(64 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(65 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(66 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(67 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(68 + (100 * db_edit))] = Integer.toString(5);
			nm.settings_display[1][(69 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(70 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(71 + (100 * db_edit))] = Integer.toString(6);
			nm.settings_display[1][(72 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(73 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(74 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(75 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(76 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(77 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(78 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(79 + (100 * db_edit))] = Integer.toString(3);
			nm.settings_display[1][(80 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(81 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(82 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(83 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(84 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(85 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(86 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(87 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(88 + (100 * db_edit))] = Integer.toString(8);
			nm.settings_display[1][(89 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(90 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(91 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(92 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(93 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(94 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(95 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(96 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(97 + (100 * db_edit))] = Integer.toString(4);
			nm.settings_display[1][(98 + (100 * db_edit))] = Integer.toString(1000);
			nm.settings_display[1][(99 + (100 * db_edit))] = Integer.toString(1000);

			nm.settings_display[2][(0 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(1 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(2 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(3 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(4 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(5 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(6 + (100 * db_edit))] = Integer.toString(140);
			nm.settings_display[2][(7 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(8 + (100 * db_edit))] = Integer.toString(150);
			nm.settings_display[2][(9 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(10 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(11 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(12 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(13 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(14 + (100 * db_edit))] = Integer.toString(150);
			nm.settings_display[2][(15 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(16 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(17 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(18 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(19 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(20 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(21 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(22 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(23 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(24 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(25 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(26 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(27 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(28 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(29 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(30 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(31 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(32 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(33 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(34 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(35 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(36 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(37 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(38 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(39 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(40 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(41 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(42 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(43 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(44 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(45 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(46 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(47 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(48 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(49 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(50 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(51 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(52 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(53 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(54 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(55 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(56 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(57 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(58 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(59 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(60 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(61 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(62 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(63 + (100 * db_edit))] = Integer.toString(230);
			nm.settings_display[2][(64 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(65 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(66 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(67 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(68 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(69 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(70 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(71 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(72 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(73 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(74 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(75 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(76 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(77 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(78 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(79 + (100 * db_edit))] = Integer.toString(200);
			nm.settings_display[2][(80 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(81 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(82 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(83 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(84 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(85 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(86 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(87 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(88 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(89 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(90 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(91 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(92 + (100 * db_edit))] = Integer.toString(150);
			nm.settings_display[2][(93 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(94 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(95 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(96 + (100 * db_edit))] = Integer.toString(100);
			nm.settings_display[2][(97 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(98 + (100 * db_edit))] = Integer.toString(300);
			nm.settings_display[2][(99 + (100 * db_edit))] = Integer.toString(240);

		}//3


	loadx_x();
	}//ifresponse

	}//savex










//handel all the button clicks. 
public void actionPerformed(ActionEvent event){

	savex_x();



	for (int loop1 = 0; loop1 < 100; loop1++){

		jup[loop1].setBackground(nm.st_gray1);
		jup[loop1].setForeground(blackx);

		if(event.getSource() == jup[loop1]){//**********************************

			hold_up = loop1;
			System.out.println(nm.db_string[loop1]);
			jup[loop1].setBackground(nm.st_gray2);
			jup[loop1].setForeground(blackx);
			save_size.setText(nm.settings_display[2][loop1]);

			itemx = loop1;

		}//*********************************************************************

	}//***************************************


	if(event.getSource() == create){db_edit = 0; loadx_x();} 
	if(event.getSource() == sold){db_edit = 1; loadx_x();} 
	if(event.getSource() == archive){db_edit = 2; loadx_x();} 
	if(event.getSource() == reset){reset_x();}
	if(event.getSource() == preset){preset_x();}
	if(event.getSource() == saves){

		nm.settings_display[2][itemx] = save_size.getText(); 
		jdb_saver_settings savex = new jdb_saver_settings();

		//nm.reset_export_flag = true;
		//nm.reset_sold_flag = true;
		//nm.reset_archive_flag = true;

	}//****************************




	if(event.getSource() == add_item){

		nm.settings_display[0][(hold_up + (100 * db_edit))] = "1";
		nm.settings_display[1][(hold_up + (100 * db_edit))] = Integer.toString(move_up);
		move_up++;
		displayx();

	}//*******************************


	if(event.getSource() == sub_item){

		nm.settings_display[0][(hold_up + (100 * db_edit))] = "0";
		nm.settings_display[1][(hold_up + (100 * db_edit))] = "1000";
		displayx();

	}//*******************************





}//actionPerformed










    public static void main(){

		alchemy_display_viewer2 xr = new alchemy_display_viewer2();

    }//main










}//last****************************************
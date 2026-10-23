import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;






public class alchemy_edit extends JFrame implements ActionListener{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 700;
int xzy = 700;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

Timer xtimerx;//class loop.

int selected_int;

String cx0 = new String("");

JButton des_view = new JButton("View");
JButton des_template = new JButton("With Template");
JButton next = new JButton("Next >");
JButton back = new JButton("< Back");
JButton savex = new JButton("Save");

Icon picture_1_img;
Icon imx4;
Icon imx5;

JLabel note_label1 = new JLabel("<html>Some database items are not displayed for editing. Use Edit > Replace to edit those fields. <br><br>Items in the last section are for exporting and should not be changed. <br><br>Some ANSI symbols will be rejected by some databases. Such as “,” and ’ avoid these symbols in the description use HTML replacements instead.<br><br></html>", JLabel.LEFT);
JLabel note_label2 = new JLabel("", JLabel.LEFT);

JLabel title_lb = new JLabel("Title:", JLabel.CENTER);
JTextField title_tf = new JTextField("", 30);

JLabel cost_lb = new JLabel("Cost:", JLabel.RIGHT);
JTextField cost_tf = new JTextField("", 5);

JLabel price_lb = new JLabel("Price:", JLabel.RIGHT);
JTextField price_tf = new JTextField("", 5);

JTextField picture_1_tf = new JTextField("", 45);

JLabel weight_lb = new JLabel("Item weight in ounces:", JLabel.RIGHT);
JTextField weight_tf = new JTextField("", 5);

JLabel onhand_lb = new JLabel("Items on hand:", JLabel.RIGHT);
JTextField onhand_tf = new JTextField("", 5);
JLabel space1_lb = new JLabel("", JLabel.RIGHT);

JLabel package_d_lb = new JLabel("Package depth:", JLabel.RIGHT);
JTextField package_d_tf = new JTextField("", 5);

JLabel package_l_lb = new JLabel("Package length:", JLabel.RIGHT);
JTextField package_l_tf = new JTextField("", 5);

JLabel package_w_lb = new JLabel("Package width:", JLabel.RIGHT);
JTextField package_w_tf = new JTextField("", 5);

JLabel custom_1_lb = new JLabel("Custom 1", JLabel.RIGHT);
JTextField custom_1_tf = new JTextField("", 30);
JLabel custom_1_2b = new JLabel("2500 characters", JLabel.RIGHT);

JLabel custom_2_lb = new JLabel("Custom 2", JLabel.RIGHT);
JTextField custom_2_tf = new JTextField("", 30);
JLabel custom_2_2b = new JLabel("2500 characters", JLabel.RIGHT);

JLabel custom_3_lb = new JLabel("Custom 3", JLabel.RIGHT);
JTextField custom_3_tf = new JTextField("", 30);
JLabel custom_3_2b = new JLabel("500 characters", JLabel.RIGHT);

JLabel custom_4_lb = new JLabel("Custom 4", JLabel.RIGHT);
JTextField custom_4_tf = new JTextField("", 30);
JLabel custom_4_2b = new JLabel("500 characters", JLabel.RIGHT);

JLabel custom_5_lb = new JLabel("Custom 5", JLabel.RIGHT);
JTextField custom_5_tf = new JTextField("", 30);
JLabel custom_5_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_6_lb = new JLabel("Custom 6", JLabel.RIGHT);
JTextField custom_6_tf = new JTextField("", 30);
JLabel custom_6_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_7_lb = new JLabel("Custom 7", JLabel.RIGHT);
JTextField custom_7_tf = new JTextField("", 30);
JLabel custom_7_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_8_lb = new JLabel("Custom 8", JLabel.RIGHT);
JTextField custom_8_tf = new JTextField("", 30);
JLabel custom_8_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_9_lb = new JLabel("Custom 9", JLabel.RIGHT);
JTextField custom_9_tf = new JTextField("", 30);
JLabel custom_9_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_10_lb = new JLabel("Custom 10", JLabel.RIGHT);
JTextField custom_10_tf = new JTextField("", 30);
JLabel custom_10_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_11_lb = new JLabel("Custom 11", JLabel.RIGHT);
JTextField custom_11_tf = new JTextField("", 30);
JLabel custom_11_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_12_lb = new JLabel("Custom 12", JLabel.RIGHT);
JTextField custom_12_tf = new JTextField("", 30);
JLabel custom_12_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_13_lb = new JLabel("Custom 13", JLabel.RIGHT);
JTextField custom_13_tf = new JTextField("", 30);
JLabel custom_13_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_14_lb = new JLabel("Custom 14", JLabel.RIGHT);
JTextField custom_14_tf = new JTextField("", 30);
JLabel custom_14_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_15_lb = new JLabel("Custom 15", JLabel.RIGHT);
JTextField custom_15_tf = new JTextField("", 30);
JLabel custom_15_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_16_lb = new JLabel("Custom 16", JLabel.RIGHT);
JTextField custom_16_tf = new JTextField("", 30);
JLabel custom_16_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_17_lb = new JLabel("Custom 17", JLabel.RIGHT);
JTextField custom_17_tf = new JTextField("", 30);
JLabel custom_17_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_18_lb = new JLabel("Custom 18", JLabel.RIGHT);
JTextField custom_18_tf = new JTextField("", 30);
JLabel custom_18_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_19_lb = new JLabel("Custom 19", JLabel.RIGHT);
JTextField custom_19_tf = new JTextField("", 30);
JLabel custom_19_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_20_lb = new JLabel("Custom 20", JLabel.RIGHT);
JTextField custom_20_tf = new JTextField("", 30);
JLabel custom_20_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_21_lb = new JLabel("Custom 21", JLabel.RIGHT);
JTextField custom_21_tf = new JTextField("", 30);
JLabel custom_21_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_22_lb = new JLabel("Custom 22", JLabel.RIGHT);
JTextField custom_22_tf = new JTextField("", 30);
JLabel custom_22_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_23_lb = new JLabel("Custom 23", JLabel.RIGHT);
JTextField custom_23_tf = new JTextField("", 30);
JLabel custom_23_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_24_lb = new JLabel("Custom 24", JLabel.RIGHT);
JTextField custom_24_tf = new JTextField("", 30);
JLabel custom_24_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_25_lb = new JLabel("Custom 25", JLabel.RIGHT);
JTextField custom_25_tf = new JTextField("", 30);
JLabel custom_25_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_26_lb = new JLabel("Custom 26", JLabel.RIGHT);
JTextField custom_26_tf = new JTextField("", 30);
JLabel custom_26_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_27_lb = new JLabel("Custom 27", JLabel.RIGHT);
JTextField custom_27_tf = new JTextField("", 30);
JLabel custom_27_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_28_lb = new JLabel("Custom 28", JLabel.RIGHT);
JTextField custom_28_tf = new JTextField("", 30);
JLabel custom_28_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_29_lb = new JLabel("Custom 29", JLabel.RIGHT);
JTextField custom_29_tf = new JTextField("", 30);
JLabel custom_29_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_30_lb = new JLabel("Custom 30", JLabel.RIGHT);
JTextField custom_30_tf = new JTextField("", 30);
JLabel custom_30_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_31_lb = new JLabel("Custom 31", JLabel.RIGHT);
JTextField custom_31_tf = new JTextField("", 30);
JLabel custom_31_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_32_lb = new JLabel("Custom 32", JLabel.RIGHT);
JTextField custom_32_tf = new JTextField("", 30);
JLabel custom_32_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_33_lb = new JLabel("Custom 33", JLabel.RIGHT);
JTextField custom_33_tf = new JTextField("", 30);
JLabel custom_33_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_34_lb = new JLabel("Custom 34", JLabel.RIGHT);
JTextField custom_34_tf = new JTextField("", 30);
JLabel custom_34_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_35_lb = new JLabel("Custom 35", JLabel.RIGHT);
JTextField custom_35_tf = new JTextField("", 30);
JLabel custom_35_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_36_lb = new JLabel("Custom 36", JLabel.RIGHT);
JTextField custom_36_tf = new JTextField("", 30);
JLabel custom_36_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_37_lb = new JLabel("Custom 37", JLabel.RIGHT);
JTextField custom_37_tf = new JTextField("", 30);
JLabel custom_37_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_38_lb = new JLabel("Custom 38", JLabel.RIGHT);
JTextField custom_38_tf = new JTextField("", 30);
JLabel custom_38_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_39_lb = new JLabel("Custom 39", JLabel.RIGHT);
JTextField custom_39_tf = new JTextField("", 30);
JLabel custom_39_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_40_lb = new JLabel("Custom 40", JLabel.RIGHT);
JTextField custom_40_tf = new JTextField("", 30);
JLabel custom_40_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_41_lb = new JLabel("Custom 41", JLabel.RIGHT);
JTextField custom_41_tf = new JTextField("", 30);
JLabel custom_41_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_42_lb = new JLabel("Custom 42", JLabel.RIGHT);
JTextField custom_42_tf = new JTextField("", 30);
JLabel custom_42_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_43_lb = new JLabel("Custom 43", JLabel.RIGHT);
JTextField custom_43_tf = new JTextField("", 30);
JLabel custom_43_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_44_lb = new JLabel("Custom 44", JLabel.RIGHT);
JTextField custom_44_tf = new JTextField("", 30);
JLabel custom_44_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_45_lb = new JLabel("Custom 45", JLabel.RIGHT);
JTextField custom_45_tf = new JTextField("", 30);
JLabel custom_45_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel custom_46_lb = new JLabel("Custom 46", JLabel.RIGHT);
JTextField custom_46_tf = new JTextField("", 30);
JLabel custom_46_2b = new JLabel("200 characters", JLabel.RIGHT);

JLabel error_edit = new JLabel("Do not edit these fields", JLabel.LEFT);

JLabel shipping_company_lb = new JLabel("Shipping Company", JLabel.RIGHT);
JTextField shipping_company_tf = new JTextField("", 15);

JLabel item_id_lb = new JLabel("Item ID", JLabel.RIGHT);
JTextField item_id_tf = new JTextField("", 15);

JLabel listing_id_lb = new JLabel("Listing ID", JLabel.RIGHT);
JTextField listing_id_tf = new JTextField("", 15);

JLabel ebay_id_lb = new JLabel("eBay Listing ID", JLabel.RIGHT);
JTextField ebay_id_tf = new JTextField("", 15);

JLabel picture_1_lb = new JLabel("", JLabel.LEFT);

JLabel jlabel[] = new JLabel[100];
JTextField jtextf[] = new JTextField[100];

JTextArea jtexta = new JTextArea();






alchemy_edit(int what_item) {//****************************

	super("Edit Item");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, (ceny -15));
	setResizable(false);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {savex_x(); nm.edit_window_is_open = false; nm.firex_edit = 1;}});



//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	selected_int = what_item;


	imx5 = new ImageIcon(this.getClass().getResource("images/no_image1.jpg"));


	note_label1.setPreferredSize(new Dimension(280, 170));
	note_label1.setForeground(nm.blackx);
	//note_label1.setOpaque(true);
	note_label1.setFont(new Font("Arial", Font.PLAIN, 11));

	note_label2.setPreferredSize(new Dimension(280, 70));
	note_label2.setForeground(nm.blackx);
	//note_label2.setOpaque(true);
	note_label2.setFont(new Font("Arial", Font.PLAIN, 11));



	des_view.setMargin(new Insets(0, 0, 0, 0));
  	des_view.addActionListener(this);
	des_view.setPreferredSize(new Dimension(100, 20));
 	//des_view.setIcon(imx4);
	des_view.setBackground(nm.jblue);
	des_view.setHorizontalTextPosition(JButton.CENTER);
	des_view.setForeground(nm.blackx);

	des_template.setMargin(new Insets(0, 0, 0, 0));
  	des_template.addActionListener(this);
	des_template.setPreferredSize(new Dimension(100, 20));
 	//des_template.setIcon(imx4);
	des_template.setBackground(nm.jblue);
	des_template.setHorizontalTextPosition(JButton.CENTER);
	des_template.setForeground(nm.blackx);



	next.setMargin(new Insets(0, 0, 0, 0));
  	next.addActionListener(this);
	next.setPreferredSize(new Dimension(120, 30));
 	//next.setIcon(imx4);
	next.setBackground(nm.st_gray1);
	next.setHorizontalTextPosition(JButton.CENTER);
	next.setForeground(nm.blackx);

	savex.setMargin(new Insets(0, 0, 0, 0));
  	savex.addActionListener(this);
	savex.setPreferredSize(new Dimension(120, 30));
 	//savex.setIcon(imx4);
	savex.setBackground(nm.st_gray1);
	savex.setHorizontalTextPosition(JButton.CENTER);
	savex.setForeground(nm.blackx);

	back.setMargin(new Insets(0, 0, 0, 0));
  	back.addActionListener(this);
	back.setPreferredSize(new Dimension(120, 30));
 	//back.setIcon(imx4);
	back.setBackground(nm.st_gray1);
	back.setHorizontalTextPosition(JButton.CENTER);
	back.setForeground(nm.blackx);

	picture_1_lb.setForeground(nm.whitex);
	picture_1_lb.setBackground(nm.blackx);
	picture_1_lb.setOpaque(true);
	picture_1_lb.setIcon(imx5);
	picture_1_lb.setPreferredSize(new Dimension(100, 100));
	picture_1_lb.setToolTipText("Item Image 1");

	title_lb.setPreferredSize(new Dimension(50,20));
	cost_lb.setPreferredSize(new Dimension(50,20));
	price_lb.setPreferredSize(new Dimension(50,20));

	onhand_lb.setPreferredSize(new Dimension(239,20));
	weight_lb.setPreferredSize(new Dimension(239,20));

	package_l_lb.setPreferredSize(new Dimension(239,20));
	package_d_lb.setPreferredSize(new Dimension(239,20));
	package_w_lb.setPreferredSize(new Dimension(239,20));

	shipping_company_lb.setPreferredSize(new Dimension(150,20));
	item_id_lb.setPreferredSize(new Dimension(150,20));
	listing_id_lb.setPreferredSize(new Dimension(150,20));
	ebay_id_lb.setPreferredSize(new Dimension(150,20));

	space1_lb.setPreferredSize(new Dimension(180,20));

	custom_1_lb.setPreferredSize(new Dimension(80,20));
	custom_2_lb.setPreferredSize(new Dimension(80,20));
	custom_3_lb.setPreferredSize(new Dimension(80,20));
	custom_4_lb.setPreferredSize(new Dimension(80,20));
	custom_5_lb.setPreferredSize(new Dimension(80,20));
	custom_6_lb.setPreferredSize(new Dimension(80,20));
	custom_7_lb.setPreferredSize(new Dimension(80,20));
	custom_8_lb.setPreferredSize(new Dimension(80,20));
	custom_9_lb.setPreferredSize(new Dimension(80,20));
	custom_10_lb.setPreferredSize(new Dimension(80,20));
	custom_11_lb.setPreferredSize(new Dimension(80,20));
	custom_12_lb.setPreferredSize(new Dimension(80,20));
	custom_13_lb.setPreferredSize(new Dimension(80,20));
	custom_14_lb.setPreferredSize(new Dimension(80,20));
	custom_15_lb.setPreferredSize(new Dimension(80,20));
	custom_16_lb.setPreferredSize(new Dimension(80,20));
	custom_17_lb.setPreferredSize(new Dimension(80,20));
	custom_18_lb.setPreferredSize(new Dimension(80,20));
	custom_19_lb.setPreferredSize(new Dimension(80,20));
	custom_20_lb.setPreferredSize(new Dimension(80,20));
	custom_21_lb.setPreferredSize(new Dimension(80,20));
	custom_22_lb.setPreferredSize(new Dimension(80,20));
	custom_23_lb.setPreferredSize(new Dimension(80,20));
	custom_24_lb.setPreferredSize(new Dimension(80,20));
	custom_25_lb.setPreferredSize(new Dimension(80,20));
	custom_26_lb.setPreferredSize(new Dimension(80,20));
	custom_27_lb.setPreferredSize(new Dimension(80,20));
	custom_28_lb.setPreferredSize(new Dimension(80,20));
	custom_29_lb.setPreferredSize(new Dimension(80,20));
	custom_30_lb.setPreferredSize(new Dimension(80,20));
	custom_31_lb.setPreferredSize(new Dimension(80,20));
	custom_32_lb.setPreferredSize(new Dimension(80,20));
	custom_33_lb.setPreferredSize(new Dimension(80,20));
	custom_34_lb.setPreferredSize(new Dimension(80,20));
	custom_35_lb.setPreferredSize(new Dimension(80,20));
	custom_36_lb.setPreferredSize(new Dimension(80,20));
	custom_37_lb.setPreferredSize(new Dimension(80,20));
	custom_38_lb.setPreferredSize(new Dimension(80,20));
	custom_39_lb.setPreferredSize(new Dimension(80,20));
	custom_40_lb.setPreferredSize(new Dimension(80,20));
	custom_41_lb.setPreferredSize(new Dimension(80,20));
	custom_42_lb.setPreferredSize(new Dimension(80,20));
	custom_43_lb.setPreferredSize(new Dimension(80,20));
	custom_44_lb.setPreferredSize(new Dimension(80,20));
	custom_45_lb.setPreferredSize(new Dimension(80,20));
	custom_46_lb.setPreferredSize(new Dimension(80,20));


	custom_1_2b.setPreferredSize(new Dimension(180,20));
	custom_2_2b.setPreferredSize(new Dimension(180,20));
	custom_3_2b.setPreferredSize(new Dimension(180,20));
	custom_4_2b.setPreferredSize(new Dimension(180,20));
	custom_5_2b.setPreferredSize(new Dimension(180,20));
	custom_6_2b.setPreferredSize(new Dimension(180,20));
	custom_7_2b.setPreferredSize(new Dimension(180,20));
	custom_8_2b.setPreferredSize(new Dimension(180,20));
	custom_9_2b.setPreferredSize(new Dimension(180,20));
	custom_10_2b.setPreferredSize(new Dimension(180,20));
	custom_11_2b.setPreferredSize(new Dimension(180,20));
	custom_12_2b.setPreferredSize(new Dimension(180,20));
	custom_13_2b.setPreferredSize(new Dimension(180,20));
	custom_14_2b.setPreferredSize(new Dimension(180,20));
	custom_15_2b.setPreferredSize(new Dimension(180,20));
	custom_16_2b.setPreferredSize(new Dimension(180,20));
	custom_17_2b.setPreferredSize(new Dimension(180,20));
	custom_18_2b.setPreferredSize(new Dimension(180,20));
	custom_19_2b.setPreferredSize(new Dimension(180,20));
	custom_20_2b.setPreferredSize(new Dimension(180,20));
	custom_21_2b.setPreferredSize(new Dimension(180,20));
	custom_22_2b.setPreferredSize(new Dimension(180,20));
	custom_23_2b.setPreferredSize(new Dimension(180,20));
	custom_24_2b.setPreferredSize(new Dimension(180,20));
	custom_25_2b.setPreferredSize(new Dimension(180,20));
	custom_26_2b.setPreferredSize(new Dimension(180,20));
	custom_27_2b.setPreferredSize(new Dimension(180,20));
	custom_28_2b.setPreferredSize(new Dimension(180,20));
	custom_29_2b.setPreferredSize(new Dimension(180,20));
	custom_30_2b.setPreferredSize(new Dimension(180,20));
	custom_31_2b.setPreferredSize(new Dimension(180,20));
	custom_32_2b.setPreferredSize(new Dimension(180,20));
	custom_33_2b.setPreferredSize(new Dimension(180,20));
	custom_34_2b.setPreferredSize(new Dimension(180,20));
	custom_35_2b.setPreferredSize(new Dimension(180,20));
	custom_36_2b.setPreferredSize(new Dimension(180,20));
	custom_37_2b.setPreferredSize(new Dimension(180,20));
	custom_38_2b.setPreferredSize(new Dimension(180,20));
	custom_39_2b.setPreferredSize(new Dimension(180,20));
	custom_40_2b.setPreferredSize(new Dimension(180,20));
	custom_41_2b.setPreferredSize(new Dimension(180,20));
	custom_42_2b.setPreferredSize(new Dimension(180,20));
	custom_43_2b.setPreferredSize(new Dimension(180,20));
	custom_44_2b.setPreferredSize(new Dimension(180,20));
	custom_45_2b.setPreferredSize(new Dimension(180,20));
	custom_46_2b.setPreferredSize(new Dimension(180,20));


	error_edit.setPreferredSize(new Dimension(620,30));
	error_edit.setForeground(nm.redx);

	jtexta = new JTextArea("", 9, 40);
	jtexta.setWrapStyleWord(true);
	jtexta.setLineWrap(true);
	jtexta.setWrapStyleWord(true);

	JScrollPane scrollPaned = new JScrollPane(jtexta);
	scrollPaned.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scrollPaned.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPaned.setFont(new Font("Arial", Font.PLAIN, 14));

	FlowLayout flow = new FlowLayout(0);
	flow.setHgap(0);
	flow.setVgap(0);





	JPanel jpk0_0 = new JPanel();
	jpk0_0.setPreferredSize(new Dimension(320, 160));
	jpk0_0.setBackground(nm.st_gray1);
	jpk0_0.add(note_label1);
	jpk0_0.add(note_label2);


	JPanel jpk0_1 = new JPanel();
	jpk0_1.setPreferredSize(new Dimension(320, 160));
	jpk0_1.setBackground(nm.st_gray1);
	jpk0_1.add(weight_lb);
	jpk0_1.add(weight_tf);
	jpk0_1.add(onhand_lb);
	jpk0_1.add(onhand_tf);
	jpk0_1.add(space1_lb);
 	jpk0_1.add(package_l_lb);
	jpk0_1.add(package_l_tf);
	jpk0_1.add(package_d_lb);
	jpk0_1.add(package_d_tf);
	jpk0_1.add(package_w_lb);
	jpk0_1.add(package_w_tf);


	TitledBorder titled0 = BorderFactory.createTitledBorder("Basic Settings");
	titled0.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_0 = new JPanel();
	jpk1_0.setPreferredSize(new Dimension(xzx -25, 220));
	jpk1_0.setBackground(nm.st_gray1);
	jpk1_0.setBorder(titled0);
	jpk1_0.add(title_lb);
	jpk1_0.add(title_tf);
	jpk1_0.add(cost_lb);
	jpk1_0.add(cost_tf);
	jpk1_0.add(price_lb);
	jpk1_0.add(price_tf);

	jpk1_0.add(jpk0_0);
	jpk1_0.add(jpk0_1);




	JPanel jpk1_1 = new JPanel();
	jpk1_1.setPreferredSize(new Dimension(xzx -25, 200));
	jpk1_1.setBackground(nm.st_gray1);


	JPanel jpk1_d_buttons = new JPanel();
	jpk1_d_buttons.setPreferredSize(new Dimension(146, 160));
	jpk1_d_buttons.setBackground(nm.st_gray1);
	jpk1_d_buttons.add(des_view);
	jpk1_d_buttons.add(des_template);


	TitledBorder titled1 = BorderFactory.createTitledBorder("Description Settings");
	titled1.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_d = new JPanel();
	jpk1_d.setPreferredSize(new Dimension(xzx -25, 190));
	jpk1_d.setBackground(nm.st_gray1);
	jpk1_d.setBorder(titled1);
	jpk1_d.add(scrollPaned);
	jpk1_d.add(jpk1_d_buttons);



	TitledBorder titled2 = BorderFactory.createTitledBorder("Picture Settings");
	titled2.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_image = new JPanel();
	jpk1_image.setPreferredSize(new Dimension(xzx -25, 140));
	jpk1_image.setBackground(nm.st_gray1);
	jpk1_image.setBorder(titled2);
	jpk1_image.add(picture_1_lb);
	jpk1_image.add(picture_1_tf);




	TitledBorder titled3 = BorderFactory.createTitledBorder("Custom Settings");
	titled3.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_c = new JPanel();
	jpk1_c.setPreferredSize(new Dimension(xzx -25, 1200));
	jpk1_c.setBackground(nm.st_gray1);
	jpk1_c.setBorder(titled3);

	jpk1_c.add(custom_1_lb);	jpk1_c.add(custom_1_tf);    	 jpk1_c.add(custom_1_2b);
	jpk1_c.add(custom_2_lb);    jpk1_c.add(custom_2_tf);         jpk1_c.add(custom_2_2b);
	jpk1_c.add(custom_3_lb);	jpk1_c.add(custom_3_tf);	     jpk1_c.add(custom_3_2b);
	jpk1_c.add(custom_4_lb);	jpk1_c.add(custom_4_tf);    	 jpk1_c.add(custom_4_2b);
	jpk1_c.add(custom_5_lb);	jpk1_c.add(custom_5_tf);    	 jpk1_c.add(custom_5_2b);
	jpk1_c.add(custom_6_lb);	jpk1_c.add(custom_6_tf);    	 jpk1_c.add(custom_6_2b);
	jpk1_c.add(custom_7_lb);	jpk1_c.add(custom_7_tf);    	 jpk1_c.add(custom_7_2b);
	jpk1_c.add(custom_8_lb);    jpk1_c.add(custom_8_tf);         jpk1_c.add(custom_8_2b);
	jpk1_c.add(custom_9_lb);	jpk1_c.add(custom_9_tf);    	 jpk1_c.add(custom_9_2b);	 
	jpk1_c.add(custom_10_lb);	jpk1_c.add(custom_10_tf);    	 jpk1_c.add(custom_10_2b);
	jpk1_c.add(custom_11_lb);	jpk1_c.add(custom_11_tf);    	 jpk1_c.add(custom_11_2b);
	jpk1_c.add(custom_12_lb);	jpk1_c.add(custom_12_tf);    	 jpk1_c.add(custom_12_2b);
	jpk1_c.add(custom_13_lb);	jpk1_c.add(custom_13_tf);    	 jpk1_c.add(custom_13_2b);    	 
	jpk1_c.add(custom_14_lb);   jpk1_c.add(custom_14_tf);    	 jpk1_c.add(custom_14_2b);
	jpk1_c.add(custom_15_lb);	jpk1_c.add(custom_15_tf);    	 jpk1_c.add(custom_15_2b);	 
	jpk1_c.add(custom_16_lb);	jpk1_c.add(custom_16_tf);    	 jpk1_c.add(custom_16_2b);
	jpk1_c.add(custom_17_lb);	jpk1_c.add(custom_17_tf);    	 jpk1_c.add(custom_17_2b);
	jpk1_c.add(custom_18_lb);	jpk1_c.add(custom_18_tf);    	 jpk1_c.add(custom_18_2b);
	jpk1_c.add(custom_19_lb);	jpk1_c.add(custom_19_tf);    	 jpk1_c.add(custom_19_2b);	 
	jpk1_c.add(custom_20_lb);	jpk1_c.add(custom_20_tf);    	 jpk1_c.add(custom_20_2b);
	jpk1_c.add(custom_21_lb);	jpk1_c.add(custom_21_tf);    	 jpk1_c.add(custom_21_2b);
	jpk1_c.add(custom_22_lb);	jpk1_c.add(custom_22_tf);    	 jpk1_c.add(custom_22_2b);
	jpk1_c.add(custom_23_lb);	jpk1_c.add(custom_23_tf);    	 jpk1_c.add(custom_23_2b);    	 
	jpk1_c.add(custom_24_lb);   jpk1_c.add(custom_24_tf);    	 jpk1_c.add(custom_24_2b);
	jpk1_c.add(custom_25_lb);	jpk1_c.add(custom_25_tf);    	 jpk1_c.add(custom_25_2b);	 
	jpk1_c.add(custom_26_lb);	jpk1_c.add(custom_26_tf);    	 jpk1_c.add(custom_26_2b);
	jpk1_c.add(custom_27_lb);	jpk1_c.add(custom_27_tf);    	 jpk1_c.add(custom_27_2b);
	jpk1_c.add(custom_28_lb);	jpk1_c.add(custom_28_tf);    	 jpk1_c.add(custom_28_2b);

	jpk1_c.add(custom_29_lb);	jpk1_c.add(custom_29_tf);    	 jpk1_c.add(custom_29_2b);
	jpk1_c.add(custom_30_lb);	jpk1_c.add(custom_30_tf);    	 jpk1_c.add(custom_30_2b);    	 
	jpk1_c.add(custom_31_lb);   jpk1_c.add(custom_31_tf);    	 jpk1_c.add(custom_31_2b);
	jpk1_c.add(custom_32_lb);	jpk1_c.add(custom_32_tf);    	 jpk1_c.add(custom_32_2b);	 
	jpk1_c.add(custom_33_lb);	jpk1_c.add(custom_33_tf);    	 jpk1_c.add(custom_33_2b);
	jpk1_c.add(custom_34_lb);	jpk1_c.add(custom_34_tf);    	 jpk1_c.add(custom_34_2b);
	jpk1_c.add(custom_35_lb);	jpk1_c.add(custom_35_tf);    	 jpk1_c.add(custom_35_2b);
	jpk1_c.add(custom_36_lb);	jpk1_c.add(custom_36_tf);    	 jpk1_c.add(custom_36_2b);	 
	jpk1_c.add(custom_37_lb);	jpk1_c.add(custom_37_tf);    	 jpk1_c.add(custom_37_2b);
	jpk1_c.add(custom_38_lb);	jpk1_c.add(custom_38_tf);    	 jpk1_c.add(custom_38_2b);
	jpk1_c.add(custom_39_lb);	jpk1_c.add(custom_39_tf);    	 jpk1_c.add(custom_39_2b);
	jpk1_c.add(custom_40_lb);	jpk1_c.add(custom_40_tf);    	 jpk1_c.add(custom_40_2b);    	 
	jpk1_c.add(custom_41_lb);   jpk1_c.add(custom_41_tf);    	 jpk1_c.add(custom_41_2b);
	jpk1_c.add(custom_42_lb);	jpk1_c.add(custom_42_tf);    	 jpk1_c.add(custom_42_2b);	 
	jpk1_c.add(custom_43_lb);	jpk1_c.add(custom_43_tf);    	 jpk1_c.add(custom_43_2b);
	jpk1_c.add(custom_44_lb);	jpk1_c.add(custom_44_tf);    	 jpk1_c.add(custom_44_2b);
	jpk1_c.add(custom_45_lb);	jpk1_c.add(custom_45_tf);    	 jpk1_c.add(custom_45_2b);
	jpk1_c.add(custom_46_lb);	jpk1_c.add(custom_46_tf);    	 jpk1_c.add(custom_46_2b);



	TitledBorder titled11 = BorderFactory.createTitledBorder("Advanced Settings");
	titled11.setBorder(BorderFactory.createLineBorder(nm.grayx3));

	JPanel jpk1_warning = new JPanel();
	jpk1_warning.setPreferredSize(new Dimension(xzx -25, 170));
	jpk1_warning.setBackground(nm.st_gray1);
	jpk1_warning.setBorder(titled11);
	jpk1_warning.add(error_edit);
	jpk1_warning.add(shipping_company_lb);	jpk1_warning.add(shipping_company_tf);
	jpk1_warning.add(item_id_lb);	        jpk1_warning.add(item_id_tf);
	jpk1_warning.add(listing_id_lb);        jpk1_warning.add(listing_id_tf);
	jpk1_warning.add(ebay_id_lb);           jpk1_warning.add(ebay_id_tf);



	JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(xzx -25, 1950));
	jpk1.setBackground(nm.st_gray1);
	jpk1.add(jpk1_0);
	jpk1.add(jpk1_image);
	jpk1.add(jpk1_d);
	jpk1.add(jpk1_c);
	jpk1.add(jpk1_warning);



	JScrollPane scrollPane = new JScrollPane(jpk1);
	scrollPane.setPreferredSize(new Dimension(xzx -5, xzy -70));
	//scrollPane.setBackground(bluex2);
	scrollPane.setFont(new Font("Arial", Font.PLAIN, 14));


	JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(xzx, 50));
	jpk2.setBackground(nm.st_gray1);
	jpk2.add(back);
	jpk2.add(savex);
	jpk2.add(next);



	Container cpx = getContentPane();
	cpx.setLayout(flow);
	cpx.setBackground(nm.st_gray1);
	cpx.setForeground(nm.blackx);
	cpx.add(scrollPane);
	cpx.add(jpk2);


	setVisible(true);



	custom_1_2b.setText( Integer.toString(2500 - (nm.carbon[0][nm.custom_1_xx][selected_int].length())) + " Characters");
	custom_2_2b.setText( Integer.toString(2500 - (nm.carbon[0][nm.custom_2_xx][selected_int].length())) + " Characters");
	custom_3_2b.setText( Integer.toString(500 - (nm.carbon[0][nm.custom_3_xx][selected_int].length())) + " Characters");
	custom_4_2b.setText( Integer.toString(500 - (nm.carbon[0][nm.custom_4_xx][selected_int].length())) + " Characters");
	custom_5_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_5_xx][selected_int].length())) + " Characters");
	custom_6_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_6_xx][selected_int].length())) + " Characters");
	custom_7_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_7_xx][selected_int].length())) + " Characters");
	custom_8_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_8_xx][selected_int].length())) + " Characters");
	custom_9_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_9_xx][selected_int].length())) + " Characters");
	custom_10_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_10_xx][selected_int].length())) + " Characters");
	custom_11_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_11_xx][selected_int].length())) + " Characters");
	custom_12_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_12_xx][selected_int].length())) + " Characters");
	custom_13_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_13_xx][selected_int].length())) + " Characters");
	custom_14_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_14_xx][selected_int].length())) + " Characters");
	custom_15_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_15_xx][selected_int].length())) + " Characters");
	custom_16_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_16_xx][selected_int].length())) + " Characters");
	custom_17_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_17_xx][selected_int].length())) + " Characters");
	custom_18_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_18_xx][selected_int].length())) + " Characters");
	custom_19_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_19_xx][selected_int].length())) + " Characters");
	custom_20_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_20_xx][selected_int].length())) + " Characters");
	custom_21_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_21_xx][selected_int].length())) + " Characters");
	custom_22_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_22_xx][selected_int].length())) + " Characters");
	custom_23_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_23_xx][selected_int].length())) + " Characters");
	custom_24_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_24_xx][selected_int].length())) + " Characters");
	custom_25_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_25_xx][selected_int].length())) + " Characters");
	custom_26_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_26_xx][selected_int].length())) + " Characters");
	custom_27_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_27_xx][selected_int].length())) + " Characters");
	custom_28_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_28_xx][selected_int].length())) + " Characters");
	custom_29_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_29_xx][selected_int].length())) + " Characters");
	custom_30_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_30_xx][selected_int].length())) + " Characters");
	custom_31_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_31_xx][selected_int].length())) + " Characters");
	custom_32_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_32_xx][selected_int].length())) + " Characters");
	custom_33_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_33_xx][selected_int].length())) + " Characters");
	custom_34_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_34_xx][selected_int].length())) + " Characters");
	custom_35_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_35_xx][selected_int].length())) + " Characters");
	custom_36_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_36_xx][selected_int].length())) + " Characters");
	custom_37_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_37_xx][selected_int].length())) + " Characters");
	custom_38_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_38_xx][selected_int].length())) + " Characters");
	custom_39_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_39_xx][selected_int].length())) + " Characters");
	custom_40_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_40_xx][selected_int].length())) + " Characters");
	custom_41_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_41_xx][selected_int].length())) + " Characters");
	custom_42_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_42_xx][selected_int].length())) + " Characters");
	custom_43_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_43_xx][selected_int].length())) + " Characters");
	custom_44_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_44_xx][selected_int].length())) + " Characters");
	custom_45_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_45_xx][selected_int].length())) + " Characters");
	custom_46_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_46_xx][selected_int].length())) + " Characters");


	displayl();
	requestFocus();


}//csv_loader_x1********************************************************











	public void get_img_picture(){

		if (nm.carbon[5][4][nm.current_submit_item_a].equals("eBay")) {

			cx0 = nm.carbon[0][nm.picture_1_xx][selected_int].replace("[[url]]", nm.carbon[5][3][nm.current_submit_item_a]);

		}//***********************************************************
		else if (nm.carbon[5][4][nm.current_submit_item_a].equals("Magento")) {

			cx0 = nm.carbon[0][nm.picture_1_xx][selected_int].replace("[[url]]", nm.carbon[5][magento_settings.host_set_url_xx][nm.current_submit_item_a]);

		}//********************************************************************
		else {

			cx0 = nm.carbon[0][nm.picture_1_xx][selected_int].replace("[[url]]", nm.carbon[5][1][nm.current_submit_item_a]);

		}//***

		System.out.println(cx0);


		try {

       		URL url = new URL(cx0);

			Image image = java.awt.Toolkit.getDefaultToolkit().getDefaultToolkit().createImage(url);

			Icon aicon = new ImageIcon(image);
			picture_1_lb.setIcon(aicon);


			BufferedImage resizedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
			Graphics2D g = resizedImage.createGraphics();
			g.drawImage(image, 0, 0, 100, 100, null);
			//g.fillRect(10, 10, 10, 10);

			image = java.awt.Toolkit.getDefaultToolkit().getDefaultToolkit().createImage(resizedImage.getSource());

			aicon = new ImageIcon(image);
			picture_1_lb.setIcon(aicon);


		} catch (Exception e) {System.out.println("Error 987098");} 


	}//*****************









	class RemindTask_pics extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************

		get_img_picture();
		System.out.println("Get Image");

	}//runx***************************************************************************************************
    }//remindtask







	public void nextxx(){

		selected_int++;

		if(selected_int > (nm.carbon[0][0].length -1)){selected_int = 0;}

		displayl();

	}//*****************





	public void backxx(){

		selected_int--;

		if(selected_int < 0){selected_int = (nm.carbon[0][0].length -1);}

		displayl();

	}//*****************







	public void displayl(){


		weight_tf.setText(nm.carbon[0][nm.item_weight_xx][selected_int]);
		onhand_tf.setText(nm.carbon[0][nm.total_on_hand_xx][selected_int]);

		package_d_tf.setText(nm.carbon[0][nm.package_d_xx][selected_int]);
		package_w_tf.setText(nm.carbon[0][nm.package_w_xx][selected_int]);
		package_l_tf.setText(nm.carbon[0][nm.package_l_xx][selected_int]);

		jtexta.setText(nm.carbon[0][nm.item_description_xx][selected_int]);
		title_tf.setText(nm.carbon[0][nm.title_xx][selected_int]);

		this.setTitle("Edit Item " + selected_int + " of " + (nm.carbon[0][0].length -1));

		picture_1_tf.setText(nm.carbon[0][nm.picture_1_xx][selected_int]);

		cost_tf.setText(nm.carbon[0][nm.item_cost_xx][selected_int]);
		price_tf.setText(nm.carbon[0][nm.item_price_xx][selected_int]);

		custom_1_tf.setText(nm.carbon[0][nm.custom_1_xx][selected_int]);
		custom_2_tf.setText(nm.carbon[0][nm.custom_2_xx][selected_int]);
		custom_3_tf.setText(nm.carbon[0][nm.custom_3_xx][selected_int]);
		custom_4_tf.setText(nm.carbon[0][nm.custom_4_xx][selected_int]);
		custom_5_tf.setText(nm.carbon[0][nm.custom_5_xx][selected_int]);
		custom_6_tf.setText(nm.carbon[0][nm.custom_6_xx][selected_int]);
		custom_7_tf.setText(nm.carbon[0][nm.custom_7_xx][selected_int]);
		custom_8_tf.setText(nm.carbon[0][nm.custom_8_xx][selected_int]);
		custom_9_tf.setText(nm.carbon[0][nm.custom_9_xx][selected_int]);
		custom_10_tf.setText(nm.carbon[0][nm.custom_10_xx][selected_int]);
		custom_11_tf.setText(nm.carbon[0][nm.custom_11_xx][selected_int]);
		custom_12_tf.setText(nm.carbon[0][nm.custom_12_xx][selected_int]);
		custom_13_tf.setText(nm.carbon[0][nm.custom_13_xx][selected_int]);
		custom_14_tf.setText(nm.carbon[0][nm.custom_14_xx][selected_int]);
		custom_15_tf.setText(nm.carbon[0][nm.custom_15_xx][selected_int]);
		custom_16_tf.setText(nm.carbon[0][nm.custom_16_xx][selected_int]);
		custom_17_tf.setText(nm.carbon[0][nm.custom_17_xx][selected_int]);
		custom_18_tf.setText(nm.carbon[0][nm.custom_18_xx][selected_int]);
		custom_19_tf.setText(nm.carbon[0][nm.custom_19_xx][selected_int]);
		custom_20_tf.setText(nm.carbon[0][nm.custom_20_xx][selected_int]);
		custom_21_tf.setText(nm.carbon[0][nm.custom_21_xx][selected_int]);
		custom_22_tf.setText(nm.carbon[0][nm.custom_22_xx][selected_int]);
		custom_23_tf.setText(nm.carbon[0][nm.custom_23_xx][selected_int]);
		custom_24_tf.setText(nm.carbon[0][nm.custom_24_xx][selected_int]);
		custom_25_tf.setText(nm.carbon[0][nm.custom_25_xx][selected_int]);
		custom_26_tf.setText(nm.carbon[0][nm.custom_26_xx][selected_int]);
		custom_27_tf.setText(nm.carbon[0][nm.custom_27_xx][selected_int]);
		custom_28_tf.setText(nm.carbon[0][nm.custom_28_xx][selected_int]);
		custom_29_tf.setText(nm.carbon[0][nm.custom_29_xx][selected_int]);
		custom_30_tf.setText(nm.carbon[0][nm.custom_30_xx][selected_int]);
		custom_31_tf.setText(nm.carbon[0][nm.custom_31_xx][selected_int]);
		custom_32_tf.setText(nm.carbon[0][nm.custom_32_xx][selected_int]);
		custom_33_tf.setText(nm.carbon[0][nm.custom_33_xx][selected_int]);
		custom_34_tf.setText(nm.carbon[0][nm.custom_34_xx][selected_int]);
		custom_35_tf.setText(nm.carbon[0][nm.custom_35_xx][selected_int]);
		custom_36_tf.setText(nm.carbon[0][nm.custom_36_xx][selected_int]);
		custom_37_tf.setText(nm.carbon[0][nm.custom_37_xx][selected_int]);
		custom_38_tf.setText(nm.carbon[0][nm.custom_38_xx][selected_int]);
		custom_39_tf.setText(nm.carbon[0][nm.custom_39_xx][selected_int]);
		custom_40_tf.setText(nm.carbon[0][nm.custom_40_xx][selected_int]);
		custom_41_tf.setText(nm.carbon[0][nm.custom_41_xx][selected_int]);
		custom_42_tf.setText(nm.carbon[0][nm.custom_42_xx][selected_int]);
		custom_43_tf.setText(nm.carbon[0][nm.custom_43_xx][selected_int]);
		custom_44_tf.setText(nm.carbon[0][nm.custom_44_xx][selected_int]);
		custom_45_tf.setText(nm.carbon[0][nm.custom_45_xx][selected_int]);
		custom_46_tf.setText(nm.carbon[0][nm.custom_46_xx][selected_int]);

		shipping_company_tf.setText(nm.carbon[0][nm.shipping_company_xx][selected_int]);

		item_id_tf.setText(nm.carbon[0][nm.item_id_xx][selected_int]);

		listing_id_tf.setText(nm.carbon[0][nm.listing_id_xx][selected_int]);
		ebay_id_tf.setText(nm.carbon[0][nm.ebay_item_xx][selected_int]);



    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_pics(), 0);


    	
	}//display







	public void savex_x(){

		nm.carbon[0][nm.title_xx][selected_int] = title_tf.getText();
		nm.carbon[0][nm.item_cost_xx][selected_int] = cost_tf.getText();
		nm.carbon[0][nm.item_price_xx][selected_int] = price_tf.getText();
		nm.carbon[0][nm.picture_1_xx][selected_int] = picture_1_tf.getText();
   
		nm.carbon[0][nm.package_d_xx][selected_int] = package_d_tf.getText();
		nm.carbon[0][nm.package_w_xx][selected_int] = package_w_tf.getText();
		nm.carbon[0][nm.package_l_xx][selected_int] = package_l_tf.getText();

		nm.carbon[0][nm.item_description_xx][selected_int] = jtexta.getText();
		nm.carbon[0][nm.item_description_xx][selected_int].replace("\r\n", " ");
		nm.carbon[0][nm.item_description_xx][selected_int].replace("\n", " ");
		nm.carbon[0][nm.item_description_xx][selected_int].replace("’", "'");
		nm.carbon[0][nm.item_description_xx][selected_int].replace("“", "\"");
		nm.carbon[0][nm.item_description_xx][selected_int].replace("”", "\"");

		cx0 = nm.carbon[0][nm.item_description_xx][selected_int];

		System.out.println(cx0);

		nm.carbon[0][nm.custom_1_xx][selected_int] = custom_1_tf.getText();
		nm.carbon[0][nm.custom_2_xx][selected_int] = custom_2_tf.getText();
		nm.carbon[0][nm.custom_3_xx][selected_int] = custom_3_tf.getText();
		nm.carbon[0][nm.custom_4_xx][selected_int] = custom_4_tf.getText();
		nm.carbon[0][nm.custom_5_xx][selected_int] = custom_5_tf.getText();
		nm.carbon[0][nm.custom_6_xx][selected_int] = custom_6_tf.getText();
		nm.carbon[0][nm.custom_7_xx][selected_int] = custom_7_tf.getText();
		nm.carbon[0][nm.custom_8_xx][selected_int] = custom_8_tf.getText();
		nm.carbon[0][nm.custom_9_xx][selected_int] = custom_9_tf.getText();
		nm.carbon[0][nm.custom_10_xx][selected_int] = custom_10_tf.getText();
		nm.carbon[0][nm.custom_11_xx][selected_int] = custom_11_tf.getText();
		nm.carbon[0][nm.custom_12_xx][selected_int] = custom_12_tf.getText();
		nm.carbon[0][nm.custom_13_xx][selected_int] = custom_13_tf.getText();
		nm.carbon[0][nm.custom_14_xx][selected_int] = custom_14_tf.getText();
		nm.carbon[0][nm.custom_15_xx][selected_int] = custom_15_tf.getText();
		nm.carbon[0][nm.custom_16_xx][selected_int] = custom_16_tf.getText();
		nm.carbon[0][nm.custom_17_xx][selected_int] = custom_17_tf.getText();
		nm.carbon[0][nm.custom_18_xx][selected_int] = custom_18_tf.getText();
		nm.carbon[0][nm.custom_19_xx][selected_int] = custom_19_tf.getText();
		nm.carbon[0][nm.custom_20_xx][selected_int] = custom_20_tf.getText();
		nm.carbon[0][nm.custom_21_xx][selected_int] = custom_21_tf.getText();
		nm.carbon[0][nm.custom_22_xx][selected_int] = custom_22_tf.getText();
		nm.carbon[0][nm.custom_23_xx][selected_int] = custom_23_tf.getText();
		nm.carbon[0][nm.custom_24_xx][selected_int] = custom_24_tf.getText();
		nm.carbon[0][nm.custom_25_xx][selected_int] = custom_25_tf.getText().replace(",","&#44;").replace("“","\"").replace("”","\"");
		nm.carbon[0][nm.custom_26_xx][selected_int] = custom_26_tf.getText();
		nm.carbon[0][nm.custom_27_xx][selected_int] = custom_27_tf.getText();
		nm.carbon[0][nm.custom_28_xx][selected_int] = custom_28_tf.getText();
		nm.carbon[0][nm.custom_29_xx][selected_int] = custom_29_tf.getText();
		nm.carbon[0][nm.custom_30_xx][selected_int] = custom_30_tf.getText();
		nm.carbon[0][nm.custom_31_xx][selected_int] = custom_31_tf.getText();
		nm.carbon[0][nm.custom_32_xx][selected_int] = custom_32_tf.getText();
		nm.carbon[0][nm.custom_33_xx][selected_int] = custom_33_tf.getText();
		nm.carbon[0][nm.custom_34_xx][selected_int] = custom_34_tf.getText();
		nm.carbon[0][nm.custom_35_xx][selected_int] = custom_35_tf.getText();
		nm.carbon[0][nm.custom_36_xx][selected_int] = custom_36_tf.getText();
		nm.carbon[0][nm.custom_37_xx][selected_int] = custom_37_tf.getText();
		nm.carbon[0][nm.custom_38_xx][selected_int] = custom_38_tf.getText();
		nm.carbon[0][nm.custom_39_xx][selected_int] = custom_39_tf.getText();
		nm.carbon[0][nm.custom_40_xx][selected_int] = custom_40_tf.getText();
		nm.carbon[0][nm.custom_41_xx][selected_int] = custom_41_tf.getText();
		nm.carbon[0][nm.custom_42_xx][selected_int] = custom_42_tf.getText();
		nm.carbon[0][nm.custom_43_xx][selected_int] = custom_43_tf.getText();
		nm.carbon[0][nm.custom_44_xx][selected_int] = custom_44_tf.getText();
		nm.carbon[0][nm.custom_45_xx][selected_int] = custom_45_tf.getText();
		nm.carbon[0][nm.custom_46_xx][selected_int] = custom_46_tf.getText();

		nm.carbon[0][nm.shipping_company_xx][selected_int] = shipping_company_tf.getText();

		nm.carbon[0][nm.item_id_xx][selected_int] = item_id_tf.getText();

		nm.carbon[0][nm.listing_id_xx][selected_int] = listing_id_tf.getText();
		nm.carbon[0][nm.ebay_item_xx][selected_int] = ebay_id_tf.getText();


		String[][] save_itemd = new String[nm.carbon[0].length][1];

		//save info
		for (int loop = 0; loop < nm.carbon[0].length; loop++){//**********

			save_itemd[loop][0] = nm.carbon[0][loop][selected_int];

		}//****************************************************************

		jdb_edit_item edit = new jdb_edit_item(save_itemd);



	}//savex











	public void des_view_x() {

		nm.html_view_number = 1;

    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_viewer_x(), 0);

	}//**********************


	public void des_template_x() {

		nm.html_view_number = 3;

    	xtimerx = new Timer();
    	xtimerx.schedule(new RemindTask_viewer_x(), 0);

	}//**************************



	class RemindTask_viewer_x extends TimerTask{
	Runtime rxrunti = Runtime.getRuntime();

	public void run(){//************************************************************************************

		alchemy_view gtxxxddxe2 = new alchemy_view();

	}//runx***************************************************************************************************
    }//remindtask




//handel all the button clicks. 
public void actionPerformed(ActionEvent event) {


	if (event.getSource() == next) {savex_x(); nextxx();}//not used
	if (event.getSource() == savex) {savex_x();}//not used
	if (event.getSource() == back) {savex_x(); backxx();}//not used

	if (event.getSource() == des_view) {des_view_x();}//not used
	if (event.getSource() == des_template) {des_template_x();}//not used



	custom_1_2b.setText( Integer.toString(2500 - (nm.carbon[0][nm.custom_1_xx][selected_int].length())) + " Characters");
	custom_2_2b.setText( Integer.toString(2500 - (nm.carbon[0][nm.custom_2_xx][selected_int].length())) + " Characters");
	custom_3_2b.setText( Integer.toString(500 - (nm.carbon[0][nm.custom_3_xx][selected_int].length())) + " Characters");
	custom_4_2b.setText( Integer.toString(500 - (nm.carbon[0][nm.custom_4_xx][selected_int].length())) + " Characters");
	custom_5_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_5_xx][selected_int].length())) + " Characters");
	custom_6_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_6_xx][selected_int].length())) + " Characters");
	custom_7_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_7_xx][selected_int].length())) + " Characters");
	custom_8_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_8_xx][selected_int].length())) + " Characters");
	custom_9_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_9_xx][selected_int].length())) + " Characters");
	custom_10_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_10_xx][selected_int].length())) + " Characters");
	custom_11_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_11_xx][selected_int].length())) + " Characters");
	custom_12_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_12_xx][selected_int].length())) + " Characters");
	custom_13_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_13_xx][selected_int].length())) + " Characters");
	custom_14_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_14_xx][selected_int].length())) + " Characters");
	custom_15_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_15_xx][selected_int].length())) + " Characters");
	custom_16_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_16_xx][selected_int].length())) + " Characters");
	custom_17_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_17_xx][selected_int].length())) + " Characters");
	custom_18_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_18_xx][selected_int].length())) + " Characters");
	custom_19_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_19_xx][selected_int].length())) + " Characters");
	custom_20_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_20_xx][selected_int].length())) + " Characters");
	custom_21_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_21_xx][selected_int].length())) + " Characters");
	custom_22_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_22_xx][selected_int].length())) + " Characters");
	custom_23_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_23_xx][selected_int].length())) + " Characters");
	custom_24_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_24_xx][selected_int].length())) + " Characters");
	custom_25_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_25_xx][selected_int].length())) + " Characters");
	custom_26_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_26_xx][selected_int].length())) + " Characters");
	custom_27_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_27_xx][selected_int].length())) + " Characters");
	custom_28_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_28_xx][selected_int].length())) + " Characters");
	custom_29_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_29_xx][selected_int].length())) + " Characters");
	custom_30_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_30_xx][selected_int].length())) + " Characters");
	custom_31_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_31_xx][selected_int].length())) + " Characters");
	custom_32_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_32_xx][selected_int].length())) + " Characters");
	custom_33_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_33_xx][selected_int].length())) + " Characters");
	custom_34_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_34_xx][selected_int].length())) + " Characters");
	custom_35_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_35_xx][selected_int].length())) + " Characters");
	custom_36_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_36_xx][selected_int].length())) + " Characters");
	custom_37_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_37_xx][selected_int].length())) + " Characters");
	custom_38_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_38_xx][selected_int].length())) + " Characters");
	custom_39_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_39_xx][selected_int].length())) + " Characters");
	custom_40_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_40_xx][selected_int].length())) + " Characters");
	custom_41_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_41_xx][selected_int].length())) + " Characters");
	custom_42_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_42_xx][selected_int].length())) + " Characters");
	custom_43_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_43_xx][selected_int].length())) + " Characters");
	custom_44_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_44_xx][selected_int].length())) + " Characters");
	custom_45_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_45_xx][selected_int].length())) + " Characters");
	custom_46_2b.setText( Integer.toString(200 - (nm.carbon[0][nm.custom_46_xx][selected_int].length())) + " Characters");



}//actionPerformed









    public static void main(int what_item) {

		alchemy_edit xr = new alchemy_edit(what_item);

    }//main








}//last****************************************
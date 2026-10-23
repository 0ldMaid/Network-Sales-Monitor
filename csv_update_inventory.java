import java.io.*;
import javax.swing.*;
import java.awt.*;
//import javax.sound.sampled.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;






public class csv_update_inventory extends JFrame implements ActionListener{

File file_image_1 = new File("cs_images\\");
File file_basei_1 = new File("\\cs_images\\");

File f1 = new File("inventory.csv");
File file_open_0 = new File("ALCHEMIST_DBX.CSV");
File file_open_1 = new File("XMXR.CSV");
File file_open_2 = new File("XMX.CSV");
File file_open_3 = new File("XMXRUndo.CSV");
File file_open_4 = new File("cs_images");
File file_open_5 = new File("cs_images");

JFrame frame_1 = new JFrame();
JFileChooser file_chooser = new JFileChooser(file_open_1);

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 460;
int xzy = 255;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

int runs = 50000;
String main = new String("");

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
int fg = 0;
int fs = 0;
int kcountxx = 0;
int kcountxx2 = 0;
int thisx = 0;
int loopc1 = 0;
int can_not_match = 0;


JButton b0 = new JButton();
JButton b1 = new JButton();
JButton b2 = new JButton();
JButton b3 = new JButton();
JButton b4 = new JButton();
JButton b5 = new JButton();
JButton bx0 = new JButton();
JButton bx1 = new JButton();
JButton bx2 = new JButton();
JButton bx3 = new JButton();

Label l0 = new Label();
Label l1 = new Label();
Label l2 = new Label();
Label l3 = new Label();
Label l4 = new Label();
Label btl0 = new Label();
Label btl1 = new Label();
Label btl2 = new Label();
Label btl3 = new Label();
Label btl4 = new Label();
Label btl5 = new Label();

TextField linex0 = new TextField("", 60);
TextField linex1 = new TextField("", 60);
TextField sectionxa = new TextField("", 18);
TextField sectionxb = new TextField("", 18);


String[][] carbonfiber = new String[1][1];
String gold[] = new String[runs];
String[] silver = new String[runs];
String d1 = new String();
String d2 = new String();
String switchsx1 = new String("XMX.CSV");
String switchsx2 = new String("XMXR.CSV");
String rep1 = new String();
String rep2 = new String();
String rex = new String(".jpg.gif");
String rexw = new String("");


File filex1;
File filex2;
String str0;

Color c1 = new Color(0.1f, 0.1f, 0.1f);
Color c2 = new Color(0.09f, 0.09f, 0.13f);

Icon imx0;

int kcountx = 0;
int kcountx2 = 0;



csv_update_inventory(){//********************************************************************************************************
	
	super("Update Inventory from CSV");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){nm.firex = 1;}});//


	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	//get button images from the Jar file.
	imx0 = new ImageIcon(this.getClass().getResource("images/buttonimage.png"));


	b0 = new JButton("Replace");
	b0.setMargin(new Insets(0, 0, 0, 0));  
	b0.addActionListener(this);
	b0.setPreferredSize(new Dimension(70, 20));
	b0.setIcon(imx0);
	b0.setHorizontalTextPosition(JButton.CENTER);
	b0.setForeground(Color.WHITE);

	b1 = new JButton("Delete");
	b1.setMargin(new Insets(0, 0, 0, 0));  
	b1.addActionListener(this);
	b1.setPreferredSize(new Dimension(70, 20));
	b1.setIcon(imx0);
	b1.setHorizontalTextPosition(JButton.CENTER);
	b1.setForeground(Color.WHITE);

	b2 = new JButton("Contains");
	b2.setMargin(new Insets(0, 0, 0, 0));  
	b2.addActionListener(this);
	b2.setPreferredSize(new Dimension(70, 20));
	b2.setIcon(imx0);
	b2.setHorizontalTextPosition(JButton.CENTER);
	b2.setForeground(Color.WHITE);

	b3 = new JButton("ImageN");
	b3.setMargin(new Insets(0, 0, 0, 0));  
	b3.addActionListener(this);
	b3.setPreferredSize(new Dimension(70, 20));
	b3.setIcon(imx0);
	b3.setHorizontalTextPosition(JButton.CENTER);
	b3.setForeground(Color.WHITE);

	b4 = new JButton("ImageS");
	b4.setMargin(new Insets(0, 0, 0, 0));  
	b4.addActionListener(this);
	b4.setPreferredSize(new Dimension(70, 20));
	b4.setIcon(imx0);
	b4.setHorizontalTextPosition(JButton.CENTER);
	b4.setForeground(Color.WHITE);

	b5 = new JButton("Undo");
	b5.setMargin(new Insets(0, 0, 0, 0));  
	b5.addActionListener(this);
	b5.setPreferredSize(new Dimension(70, 20));
	b5.setIcon(imx0);
	b5.setHorizontalTextPosition(JButton.CENTER);
	b5.setForeground(Color.WHITE);





	bx0 = new JButton("CSV Cleanup");
	bx0.setMargin(new Insets(0, 0, 0, 0));  
	bx0.addActionListener(this);
	bx0.setPreferredSize(new Dimension(100, 20));
	bx0.setIcon(imx0);
	bx0.setHorizontalTextPosition(JButton.CENTER);
	bx0.setForeground(Color.WHITE);

	bx1 = new JButton("Delete Repeats");
	bx1.setMargin(new Insets(0, 0, 0, 0));  
	bx1.addActionListener(this);
	bx1.setPreferredSize(new Dimension(100, 20));
	bx1.setIcon(imx0);
	bx1.setHorizontalTextPosition(JButton.CENTER);
	bx1.setForeground(Color.WHITE);

	bx2 = new JButton("Imagex");
	bx2.setMargin(new Insets(0, 0, 0, 0));  
	bx2.addActionListener(this);
	bx2.setPreferredSize(new Dimension(100, 20));
	bx2.setIcon(imx0);
	bx2.setHorizontalTextPosition(JButton.CENTER);
	bx2.setForeground(Color.WHITE);

	bx3 = new JButton("SPLIT");
	bx3.setMargin(new Insets(0, 0, 0, 0));  
	bx3.addActionListener(this);
	bx3.setPreferredSize(new Dimension(100, 20));
	bx3.setIcon(imx0);
	bx3.setHorizontalTextPosition(JButton.CENTER);
	bx3.setForeground(Color.WHITE);



	linex0.setBackground(Color.BLACK);
	linex0.setForeground(Color.WHITE);
	linex1.setBackground(Color.BLACK);
	linex1.setForeground(Color.WHITE);

	sectionxa.setBackground(Color.BLACK);
	sectionxa.setForeground(Color.WHITE);
	sectionxb.setBackground(Color.BLACK);
	sectionxb.setForeground(Color.WHITE);


	l0 = new Label("", Label.LEFT);
	l0.setPreferredSize(new Dimension(220, 20));
	l0.setBackground(c2);
	l0.setForeground(Color.WHITE);

	l1 = new Label("Section A:", Label.LEFT);
	l1.setPreferredSize(new Dimension(75, 20));
	l1.setBackground(c2);
	l1.setForeground(Color.WHITE);

	l2 = new Label("Section B:", Label.LEFT);
	l2.setPreferredSize(new Dimension(75, 20));
	l2.setBackground(c2);
	l2.setForeground(Color.WHITE);

	l3 = new Label("", Label.LEFT);
	l3.setPreferredSize(new Dimension(220, 20));
	l3.setBackground(c2);
	l3.setForeground(Color.WHITE);

	l4 = new Label("", Label.LEFT);
	l4.setPreferredSize(new Dimension(220, 20));
	l4.setBackground(c2);
	l4.setForeground(Color.WHITE);

	btl0 = new Label("A with B.", Label.LEFT);
	btl0.setPreferredSize(new Dimension(100, 20));
	btl0.setBackground(c2);
	btl0.setForeground(Color.WHITE);

	btl1 = new Label("From A to B.", Label.LEFT);
	btl1.setPreferredSize(new Dimension(100, 20));
	btl1.setBackground(c2);
	btl1.setForeground(Color.WHITE);

	btl2 = new Label("A, Doesn't B.", Label.LEFT);
	btl2.setPreferredSize(new Dimension(100, 20));
	btl2.setBackground(c2);
	btl2.setForeground(Color.WHITE);

	btl3 = new Label("replace name.", Label.LEFT);
	btl3.setPreferredSize(new Dimension(100, 20));
	btl3.setBackground(c2);
	btl3.setForeground(Color.WHITE);

	btl4 = new Label("change size.", Label.LEFT);
	btl4.setPreferredSize(new Dimension(100, 20));
	btl4.setBackground(c2);
	btl4.setForeground(Color.WHITE);

	btl5 = new Label("Last CSV edit.", Label.LEFT);
	btl5.setPreferredSize(new Dimension(100, 20));
	btl5.setBackground(c2);
	btl5.setForeground(Color.WHITE);


    JPanel jp0 = new JPanel();
	jp0.setPreferredSize(new Dimension(247, 160));
	jp0.setBackground(c1);
	jp0.add(l0);
	jp0.add(l1);  jp0.add(sectionxa);
	jp0.add(l2);  jp0.add(sectionxb);
	jp0.add(l3);
	jp0.add(bx0); jp0.add(bx1); jp0.add(bx2); jp0.add(bx3);


    JPanel jp2 = new JPanel();
	jp2.setPreferredSize(new Dimension(190, 160));
	jp2.setBackground(c1);
	jp2.add(b0);	jp2.add(btl0);
	jp2.add(b1);	jp2.add(btl1);
	jp2.add(b2);	jp2.add(btl2);
	jp2.add(b3);	jp2.add(btl3);
	jp2.add(b4);	jp2.add(btl4);
	jp2.add(b5);	jp2.add(btl5);


	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(Color.BLACK);
	cp.setForeground(Color.BLACK);
	cp.add(linex0);
	cp.add(linex1);
	cp.add(jp0);
	cp.add(jp2);



	//setVisible(true);



	loadx();

	if(kcountx2 > 1){importx();}
	else{JOptionPane.showMessageDialog(null,"No inventory.csv file.");}
	
	JOptionPane.showMessageDialog(null,"Can't match: " + Integer.toString(can_not_match) + " items.");


}//postid**************************************************************************************************************














	public void loadx(){

		csv_loader1 xcsvx2 = new csv_loader1(f1);
		carbonfiber = xcsvx2.getData0();
		kcountx = xcsvx2.getData1();
		kcountx2 = xcsvx2.getData2();


		System.out.println("kcountx  " + kcountx);


	}//loadx





//workers***************************************************************************************
//workers***************************************************************************************






	public void importx(){

		can_not_match = 0;



		for(int xloop = 1; xloop < nm.carbon[0][0].length; xloop++){//********

			nm.carbon[0][nm.total_on_hand_xx][xloop] = "0";

		}//*******************************************************************


		for(int xloop = 0; xloop < kcountx2; xloop++){//********


			for(int xloop2 = 1; xloop2 < nm.carbon[0][0].length; xloop2++){//********

				if(nm.carbon[0][nm.part_number_xx][xloop2].replace("'","").replace("  "," ").equals(carbonfiber[0][xloop].replace("'","").replace("  "," "))){break;}
				else if(xloop2 == (nm.carbon[0][0].length -1)){

					can_not_match++;
					if(can_not_match > 5){}
					else{JOptionPane.showMessageDialog(null,"Can't match: " + carbonfiber[0][xloop]);}
		
				}//*********************************************

			}//if*********************************************************************
		

			for(int xloop2 = 0; xloop2 < nm.carbon[0][0].length; xloop2++){//********


				try{
	
					if(nm.carbon[0][nm.part_number_xx][xloop2].replace("'","").replace("  "," ").equals(carbonfiber[0][xloop].replace("'","").replace("  "," "))){

						ix0 = Integer.parseInt(nm.carbon[0][nm.total_on_hand_xx][xloop2]);
						ix1 = Integer.parseInt(carbonfiber[1][xloop]);

						ix2 = ix0 + ix1;

						nm.carbon[0][nm.total_on_hand_xx][xloop2] = Integer.toString(ix2);

					}//if*********************************************************************
			
				}catch(Exception e){JOptionPane.showMessageDialog(null,"Math Fail: " + nm.carbon[0][nm.part_number_xx][xloop2] + " " + carbonfiber[1][xloop] + " + " + nm.carbon[0][nm.total_on_hand_xx][xloop2]);}

			}//*******************************************************************



		}//******************************************************

	}//loadx








public void actionPerformed(ActionEvent event){




}//action**




    public static void main(String[] args){

		csv_update_inventory xr = new csv_update_inventory();

    }//main





}//last
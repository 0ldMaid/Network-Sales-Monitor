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






public class alchemy_frame_builder extends JFrame implements ActionListener{

File file_image_1 = new File("cs_images\\");
File file_basei_1 = new File("\\cs_images\\");

File file_open = new File("");
File file_open_0 = new File("ALCHEMIST_DBX.CSV");
File file_open_1 = new File("XMXR.CSV");
File file_open_2 = new File("XMX.CSV");
File file_open_3 = new File("XMXRUndo.CSV");
File file_open_4 = new File("cs_images");
File file_open_5 = new File("cs_images");

JFrame frame_1 = new JFrame();
JFileChooser file_chooser = new JFileChooser(file_open_1);

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 590;
int xzy = 658;
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

JLabel build_l_image;
JButton build1 = new JButton();
Label build_l = new Label("Load...", Label.LEFT);


TextField linex0 = new TextField("", 60);
TextField linex1 = new TextField("", 60);
TextField sectionxa = new TextField("", 18);
TextField sectionxb = new TextField("", 18);


String[] carbonfiber = new String[runs];
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
Color c3 = new Color(0.7f, 0.7f, 0.7f);
Color c4 = new Color(0.6f, 0.6f, 0.6f);

Icon imx0;
JPanel jp0 = new JPanel();






alchemy_frame_builder(){//********************************************************************************************************
	
	super("Frame Builder");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	frame_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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







        File out_make = new File("framed_images\\"); 
	out_make.mkdirs();


	build_l_image = new JLabel("", JLabel.CENTER);
	build_l_image.setPreferredSize(new Dimension(575, 575));
	build_l_image.setBackground(Color.BLACK);
	build_l_image.setForeground(Color.BLACK);
 

	build1 = new JButton("Build");
	build1.setMargin(new Insets(0, 0, 0, 0));  
	build1.addActionListener(this);
	build1.setPreferredSize(new Dimension(70, 20));
	//build1.setIcon(imx0);
	build1.setHorizontalTextPosition(JButton.CENTER);
	build1.setBackground(c3);
	build1.setForeground(Color.BLACK);


	build_l = new Label("Item preview loaded.", Label.LEFT);
	build_l.setPreferredSize(new Dimension(350, 20));
	build_l.setBackground(c3);
	build_l.setForeground(Color.BLACK);




        //JPanel jp0 = new JPanel();
	jp0.setPreferredSize(new Dimension(600, 585));
	jp0.setBackground(Color.WHITE);
	jp0.add(build_l_image);


        JPanel jp2 = new JPanel();
	jp2.setPreferredSize(new Dimension(600, 30));
	jp2.setBackground(c4);
	jp2.add(build_l);
	jp2.add(build1);



	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(c3);
	cp.setForeground(c3);
	cp.add(jp0);
	cp.add(jp2);



	setVisible(true);
	imagechange2_builder();


}//postid**************************************************************************************************************














	public void imagechange2_builder(){//change size



		try{
	
			BufferedInputStream imageStream;
			BufferedInputStream imageStream2;

			try{

				imageStream = new BufferedInputStream(new FileInputStream("frame_builder_image.jpg"));

 			}catch (IOException e){

				build_l.setText("frame_builder_image.jpg not found. Load template.");
				imageStream = new BufferedInputStream(new FileInputStream("images\\frame_builder_image.jpg"));

			}//catch***************


			try{

				cx0 = nm.carbon[0][nm.picture_1_xx][nm.what_item_frame];
				if(cx0.contains("/")){ix0 = cx0.lastIndexOf("/");}
				else if(cx0.contains("\\")){ix0 = cx0.lastIndexOf("\\");}
				else{System.out.println("PICTURE PATH ERROR");}
				cx0 = cx0.substring(ix0 + 1, cx0.length());
				System.out.println(cx0);
				imageStream2 = new BufferedInputStream(new FileInputStream("cs_images\\" + cx0));
 	
 			}catch (IOException e){

				build_l.setText("Item picture not found. No file in cs_images.");
				imageStream2 = new BufferedInputStream(new FileInputStream("images\\frame_builder_imagex.jpg"));

			}//catch***************




			Image image = (Image) ImageIO.read(imageStream);
			Image image2 = (Image) ImageIO.read(imageStream2);


			System.out.println("FIX ");
 
			BufferedImage thumbImage = new BufferedImage(576, 576, BufferedImage.TYPE_INT_RGB);
			BufferedImage thumbImage_item = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);

        	Graphics2D g2dx = thumbImage.createGraphics(); 

        	g2dx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
       	 	g2dx.drawImage(image, 0, 0, 576, 576, null);
       	 	g2dx.drawImage(image2, 38, 60, 500, 500, null);


			build_l_image.setIcon(new ImageIcon(thumbImage));
	
			imageStream.close();
			imageStream2.close();

		}catch (IOException e){System.out.println("get file fail");}



	}//imagechange
















	public void imagechange2_builder2(){//change size


		for(int xloopx0 = 1; xloopx0 < nm.carbon[0][0].length; xloopx0++){//************************************************



        	File in = new File("");
			File out = new File("");


			try{
	
				BufferedInputStream imageStream;
				BufferedInputStream imageStream2;

				try{

					imageStream = new BufferedInputStream(new FileInputStream("frame_builder_image.jpg"));
 		
 				}catch (IOException e){

					imageStream = new BufferedInputStream(new FileInputStream("images\\frame_builder_image.jpg"));

				}//catch***************


				try{

					cx0 = nm.carbon[0][nm.picture_1_xx][xloopx0];
					ix0 = cx0.lastIndexOf("/");
					cx0 = cx0.substring(ix0 + 1, cx0.length());
					System.out.println(cx0);
					imageStream2 = new BufferedInputStream(new FileInputStream("cs_images\\" + cx0));
 
 				}catch (IOException e){

					imageStream2 = new BufferedInputStream(new FileInputStream("images\\frame_builder_imagex.jpg"));

				}//catch***************




				Image image = (Image) ImageIO.read(imageStream);
				Image image2 = (Image) ImageIO.read(imageStream2);


				System.out.println("FIX ");
 
				BufferedImage thumbImage = new BufferedImage(576, 576, BufferedImage.TYPE_INT_RGB);
				BufferedImage thumbImage_item = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);

      		    Graphics2D g2dx = thumbImage.createGraphics(); 

        		g2dx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
       			g2dx.drawImage(image, 0, 0, 576, 576, null);
        		g2dx.drawImage(image2, 38, 60, 500, 500, null);


				//build_l_image.setIcon(new ImageIcon(thumbImage));
				build_l.setText("Building (" + Integer.toString(xloopx0) + " of " + Integer.toString(nm.carbon[0][0].length) + ")");	


				cx0 = nm.carbon[0][nm.picture_1_xx][xloopx0];
				ix0 = cx0.lastIndexOf("/");
				cx0 = cx0.substring(ix0 + 1, cx0.length());
        		out = new File("framed_images\\" + cx0.toLowerCase()); 

        		ImageIO.write(thumbImage, "jpeg", out);


				nm.carbon[0][nm.picture_1_xx][xloopx0] = "[[url]]/pictures/framed_images/" + cx0.toLowerCase();


				//if(out.exists() && !out.equals(in)){in.delete();}

				imageStream.close();
				imageStream2.close();

				//in.close();
				//out.close();
	
			}catch (IOException e){System.out.println("get file fail");}

		}//for*************************************************************************************************************


		build_l.setText("Building (" + Integer.toString(nm.carbon[0][0].length) + " of " + Integer.toString(nm.carbon[0][0].length) + ")... Done.");

	}//imagechange



































	public void imagechange1(){


		if(file_image_1.exists()){
	
			carbonfiber = file_image_1.list();

			thisx = carbonfiber.length;

			l3.setText("cs_image found: " + Integer.toString(thisx));
	
		}//
		else{l3.setText("cs_image folder was not found.");}


        File in = new File("");
		File out = new File("");


		for(int xloopx0 = 0; xloopx0 < thisx; xloopx0++){//********************************************

			if(carbonfiber[xloopx0].equals("Thumbs.db")){}
			else if(carbonfiber[xloopx0].equals("imager.jar")){}
			else if(carbonfiber[xloopx0].equals("imager2.java")){}
			else if(carbonfiber[xloopx0].equals("imager2.class")){}
			else{//**>


				l0.setText((xloopx0 * 100 / thisx) + "% Compleat."); 
				l3.setText(carbonfiber[xloopx0]); 

				try{

       				in = new File("cs_images\\" + carbonfiber[xloopx0]); 

					BufferedInputStream imageStream = new BufferedInputStream(new FileInputStream("cs_images\\" + carbonfiber[xloopx0]));
 
					Image image = (Image) ImageIO.read(imageStream);


					//System.out.println(image);

	     			int thumbWidth = image.getHeight(null);
	     			int thumbHeight = image.getWidth(null);
 
					BufferedImage thumbImage = new BufferedImage(thumbWidth, thumbHeight, BufferedImage.TYPE_INT_RGB);

        			Graphics2D g2dx = thumbImage.createGraphics(); 

        			g2dx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        			g2dx.drawImage(image, 0, 0, thumbWidth, thumbHeight, null);
					//g2dx.drawLine(0,0,300,300);


        			// Write the scaled image to the outputstream

					cx3 = carbonfiber[xloopx0];
					//replacename();
					cx4 = carbonfiber[xloopx0];
					carbonfiber[xloopx0] = cx3; 

        			out = new File("cs_images\\" + carbonfiber[xloopx0]); 

       				ImageIO.write(thumbImage, "jpeg", out);

					imageStream.close();

					if(out.exists() && !out.equals(in)){in.delete();}

				}catch (IOException e){System.out.println("get file fail");}

			}//******************************************************************************************

		}//for

		l0.setText("100% Compleat."); 

	}//imagechange











	public void imagechange2(){//change size


		if(file_image_1.exists()){
		
			carbonfiber = file_image_1.list();

			thisx = carbonfiber.length;

			l3.setText("cs_image found: " + Integer.toString(thisx));
	
		}//
		else{l3.setText("cs_image folder was not found.");}



		l0.setText(Integer.toString(thisx));
		//l3.setText(carbonfiber[0]);


		for(int xloopx0 = 0; xloopx0 < thisx; xloopx0++){//********************************************

			if(carbonfiber[xloopx0].equals("Thumbs.db")){}
			else if(carbonfiber[xloopx0].equals("imager.jar")){}
			else if(carbonfiber[xloopx0].equals("imager2.java")){}
			else if(carbonfiber[xloopx0].equals("imager2.class")){}
			else{//********************************>

				l0.setText((xloopx0 * 100 / thisx) + "% Compleat."); 
				//l1.setText(carbonfiber[xloopx0]); 

				try{

					BufferedInputStream imageStream = new BufferedInputStream(new FileInputStream("cs_images\\" + carbonfiber[xloopx0]));
 
					Image image = (Image) ImageIO.read(imageStream);



					if(ix1 < image.getHeight(null) && ix0 < image.getWidth(null)){//***************************************
	
						System.out.println("FIX " + carbonfiber[xloopx0]);

						ix0 = Integer.parseInt(sectionxa.getText());
						ix1 = Integer.parseInt(sectionxb.getText());
 
						BufferedImage thumbImage = new BufferedImage(ix0, ix1, BufferedImage.TYPE_INT_RGB);

       					Graphics2D g2dx = thumbImage.createGraphics(); 

        				g2dx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        				g2dx.drawImage(image, 0, 0, ix0, ix1, null);
						//g2dx.drawLine(0,0,300,300);


        				// Write the scaled image to the outputstream
     					File out = new File("cs_images\\" + carbonfiber[xloopx0]);          

        				ImageIO.write(thumbImage, "jpeg", out);


					}//*****************************************************************************************************
					else{System.out.println("IMAGE TOO SMALL " + image.getHeight(null) + " " +  image.getWidth(null) + " " + carbonfiber[xloopx0]);}

						imageStream.close();

				}catch (IOException e){System.out.println("get file fail");}


			}//else******************************************************************************************

			l0.setText("100% Compleat."); 
		}//for********************************>

	}//imagechange











	public void imagex(){//delete CSV records that don't have images

		String[][] carbon1 = new String[20][runs];

		csv_loader1 xcsvx1 = new csv_loader1(file_open_3);
		carbon1 = xcsvx1.getData0();
		kcountxx = xcsvx1.getData1();
		kcountxx2 = xcsvx1.getData2();


		cx1 = sectionxa.getText();
		cx2 = sectionxb.getText();

		ix0 = 0;
		ix1 = 0;


		if(cx1.length() < 1){cx1 = Integer.toString(kcountxx -1);}	



			for (int loop1 = 0; loop1 < kcountxx2; loop1++){//**********************

				l0.setText((loop1 * 100 / kcountxx2) + "% Compleat."); 

				cx0 = carbon1[Integer.parseInt(cx1)][loop1];

				ix4 = cx0.indexOf("Image file name: ");
				if(ix4 > -1){cx0 = cx0.substring(17, cx0.length());}
				else{}

				ix0 = 0;

				//System.out.println(cx0);

				for (int loop2 = 0; loop2 < carbonfiber.length; loop2++){

					if(carbonfiber[loop2].equals(cx0)){ix0++; break;}

				}//for*****************************************************


				if(ix0 == 0){ix1++; l3.setText(ix1 + " Sections with no images."); carbon1[0][loop1] = "<no image>" + carbon1[0][loop1];}
				else{}//else


			}//for******************************************

			l0.setText("100% Compleat.");
			System.out.println(cx3);



			try {
        
        		BufferedWriter out = new BufferedWriter(new FileWriter(file_open));

				for (int loop0 = 0; loop0 < kcountxx2; loop0++){
				for (int loop1 = 0; loop1 < kcountxx; loop1++){

					out.write(carbon1[loop1][loop0] + ",");

				}//for
				out.newLine();
				}//for

        		out.close();
        		
       		}catch(IOException e){System.out.println("print fail.");}




	}//imagex*********************************************************************************************************
















//workers end***************************************************************************************
//workers end***************************************************************************************


//printers ***************************************************************************************
//printers ***************************************************************************************










public void actionPerformed(ActionEvent event){


	if (event.getSource() == build1) {imagechange2_builder2();}//


}//action**




    public static void main(String[] args){

		alchemy_frame_builder frame_builderxr = new alchemy_frame_builder();

    }//main





}//last
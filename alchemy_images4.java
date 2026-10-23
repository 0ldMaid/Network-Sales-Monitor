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






public class alchemy_images4 extends JFrame implements ActionListener{

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
int xzx = 300;
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
Color c2 = new Color(0.09f, 0.09f, 0.19f);
Color c3 = new Color(0.29f, 0.29f, 0.29f);
Color c4 = new Color(0.39f, 0.39f, 0.39f);
Color c5 = new Color(0.49f, 0.49f, 0.49f);

Icon imx0;





alchemy_images4(){//********************************************************************************************************
	
	super("Image Tools 4");
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
	imx0 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));


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





	bx0 = new JButton("Square Images");
	bx0.setMargin(new Insets(0, 0, 0, 0));  
	bx0.addActionListener(this);
	bx0.setPreferredSize(new Dimension(100, 25));
	//bx0.setIcon(imx0);
	bx0.setHorizontalTextPosition(JButton.CENTER);
	bx0.setBackground(c3);
	bx0.setForeground(Color.WHITE);

	bx1 = new JButton("Resize");
	bx1.setMargin(new Insets(0, 0, 0, 0));  
	bx1.addActionListener(this);
	bx1.setPreferredSize(new Dimension(100, 25));
	//bx1.setIcon(imx0);
	bx1.setHorizontalTextPosition(JButton.CENTER);
	bx1.setBackground(c3);
	bx1.setForeground(Color.WHITE);

	bx2 = new JButton("Rename");
	bx2.setMargin(new Insets(0, 0, 0, 0));  
	bx2.addActionListener(this);
	bx2.setPreferredSize(new Dimension(100, 25));
	//bx2.setIcon(imx0);
	bx2.setHorizontalTextPosition(JButton.CENTER);
	bx2.setBackground(c3);
	bx2.setForeground(Color.WHITE);

	bx3 = new JButton("Link Test");
	bx3.setMargin(new Insets(0, 0, 0, 0));  
	bx3.addActionListener(this);
	bx3.setPreferredSize(new Dimension(100, 25));
	//bx3.setIcon(imx0);
	bx3.setHorizontalTextPosition(JButton.CENTER);
	bx3.setBackground(c3);
	bx3.setForeground(Color.WHITE);



	linex0.setBackground(Color.BLACK);
	linex0.setForeground(Color.WHITE);
	linex1.setBackground(Color.BLACK);
	linex1.setForeground(Color.WHITE);

	sectionxa.setBackground(Color.BLACK);
	sectionxa.setForeground(Color.WHITE);
	sectionxb.setBackground(Color.BLACK);
	sectionxb.setForeground(Color.WHITE);


	l0 = new Label("Make images square", Label.LEFT);
	l0.setPreferredSize(new Dimension(150, 25));
	//l0.setBackground(c2);
	l0.setForeground(Color.WHITE);

	l1 = new Label("Resize to 750x750", Label.LEFT);
	l1.setPreferredSize(new Dimension(150, 25));
	//l1.setBackground(c2);
	l1.setForeground(Color.WHITE);

	l2 = new Label("Rename to (Part_Number)", Label.LEFT);
	l2.setPreferredSize(new Dimension(150, 25));
	//l2.setBackground(c2);
	l2.setForeground(Color.WHITE);

	l3 = new Label("Test image link", Label.LEFT);
	l3.setPreferredSize(new Dimension(150, 25));
	//l3.setBackground(c2);
	l3.setForeground(Color.WHITE);

	l4 = new Label("", Label.LEFT);
	l4.setPreferredSize(new Dimension(150, 25));
	//l4.setBackground(c2);
	l4.setForeground(Color.WHITE);




        JPanel jp0 = new JPanel();
	jp0.setPreferredSize(new Dimension(290, 245));
	jp0.setBackground(c2);
	jp0.add(bx0);   jp0.add(l0);
	jp0.add(bx1);   jp0.add(l1);
	jp0.add(bx2);   jp0.add(l2);
	jp0.add(bx3);   jp0.add(l3);





	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(c2);
	cp.setForeground(c2);
	cp.add(jp0);



	setVisible(true);

	l0.requestFocus();

}//postid**************************************************************************************************************









//workers***************************************************************************************
//workers***************************************************************************************












	public void imagechange1(){


		if(file_image_1.exists()){
	
			carbonfiber = file_image_1.list();

			thisx = carbonfiber.length;

			l3.setText("cs_image found: " + Integer.toString(thisx));
	
		}//
		else{l3.setText("cs_images folder was not found.");}


        File in = new File("");
		File out = new File("");


		for(int xloopx0 = 0; xloopx0 < thisx; xloopx0++){//********************************************

			if(carbonfiber[xloopx0].equals("Thumbs.db")){}
			else if(carbonfiber[xloopx0].equals("imager.jar")){}
			else if(carbonfiber[xloopx0].equals("imager2.java")){}
			else if(carbonfiber[xloopx0].equals("imager2.class")){}
			else{//**>


				l0.setText((xloopx0 * 100 / thisx) + "% Compleat"); 
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


        			//Write the scaled image to the outputstream

					cx3 = carbonfiber[xloopx0];
					replacename();
					cx4 = carbonfiber[xloopx0];
					carbonfiber[xloopx0] = cx3; 

        			out = new File("cs_images\\" + carbonfiber[xloopx0]); 

        			ImageIO.write(thumbImage, "jpeg", out);

					imageStream.close();

					if(out.exists() && !out.equals(in)){in.delete();}

				}catch (IOException e){System.out.println("get file fail");}

			}//else******************************************************************************************

		}//

		l0.setText("100% Compleat"); 

	}//imagechange






	public void replacename(){}
























	public void imagechange2(){//change size


		if(file_image_1.exists()){
	
			carbonfiber = file_image_1.list();

			thisx = carbonfiber.length;

			l1.setText("cs_image found: " + Integer.toString(thisx));
	
		}//
		else{l1.setText("cs_image folder was not found.");}



		l1.setText(Integer.toString(thisx));
		//l3.setText(carbonfiber[0]);


		for(int xloopx0 = 0; xloopx0 < thisx; xloopx0++){//********************************************


			l1.setText((xloopx0 * 100 / thisx) + "% Compleat"); 

			try{

				BufferedInputStream imageStream = new BufferedInputStream(new FileInputStream("cs_images\\" + carbonfiber[xloopx0]));
 
				Image image = (Image) ImageIO.read(imageStream);



				if(ix1 < image.getHeight(null) && ix0 < image.getWidth(null)){//***************************************
		
					System.out.println("FIX " + carbonfiber[xloopx0]);

					ix0 = 750;
					ix1 = 750;
 
					BufferedImage thumbImage = new BufferedImage(ix0, ix1, BufferedImage.TYPE_INT_RGB);

       				Graphics2D g2dx = thumbImage.createGraphics(); 

        			g2dx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        			g2dx.drawImage(image, 0, 0, ix0, ix1, null);
					//g2dx.drawLine(0,0,300,300);


        			//Write the scaled image to the outputstream
     				File out = new File("cs_images\\" + carbonfiber[xloopx0]);          

        			ImageIO.write(thumbImage, "jpeg", out);


				}//*****************************************************************************************************
				else{System.out.println("IMAGE TOO SMALL " + image.getHeight(null) + " " +  image.getWidth(null) + " " + carbonfiber[xloopx0]);}

				imageStream.close();

			}catch (IOException e){System.out.println("get file fail");}

		}//for******************************************************************************************


		l1.setText("100% Compleat"); 
	
	}//imagechange













	public void imagechange2x2(){//makes images square

		if(file_image_1.exists()){
	
			carbonfiber = file_image_1.list();

			thisx = carbonfiber.length;

			l0.setText("cs_image found: " + Integer.toString(thisx));
	
		}//
		else{l0.setText("cs_image folder missing!");}






		for(int xloopx0 = 0; xloopx0 < thisx; xloopx0++){//********************************************


			l0.setText((xloopx0 * 100 / thisx) + "% Compleat"); 

			try{



				String namex = new String(carbonfiber[xloopx0]);

				namex = "cs_images" + "/" + namex;
				System.out.println(namex);


				BufferedInputStream imageStream = new BufferedInputStream(new FileInputStream(namex));
 
				Image image = (Image) ImageIO.read(imageStream);


				ix0 = 0;
				ix1 = 0;



				if(image.getHeight(null) > 0 && image.getWidth(null) > 0){//***************************************
		
					System.out.println("FIX " + carbonfiber[xloopx0]);



					if(image.getWidth(null) > image.getHeight(null)){ix0 = image.getWidth(null); ix1 = image.getWidth(null);}
					else if(image.getHeight(null) > image.getWidth(null)){ix0 = image.getHeight(null); ix1 = image.getHeight(null);}
					else{ix0 = image.getWidth(null); ix1 = image.getHeight(null);}

					System.out.println("ix0 " + ix0);
 					System.out.println("ix1 " + ix1);

					BufferedImage thumbImage = new BufferedImage(ix0, ix1, BufferedImage.TYPE_INT_RGB);

        			Graphics2D g2dx = thumbImage.createGraphics(); 

        			g2dx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);



					//image.getWidth(null)
					//image.getHeight(null)

					int xx1 = (ix0 - image.getWidth(null)) / 2;
					int xx2 = (ix1 - image.getHeight(null)) / 2;
					int xx3 = image.getWidth(null);
					int xx4 = image.getHeight(null);

					g2dx.setColor(Color.WHITE);
    				g2dx.fillRect(0, 0, ix0, ix1);

       				g2dx.drawImage(image, xx1, xx2, xx3, xx4, null);



        			// Write the scaled image to the outputstream
     				File out = new File(namex);          

       				ImageIO.write(thumbImage, "jpeg", out);

				}//*****************************************************************************************************
				else{System.out.println("IMAGE TOO SMALL " + image.getHeight(null) + " " +  image.getWidth(null) + " " + carbonfiber[xloopx0]);}



				imageStream.close();

			}catch(Exception e){System.out.println("Image read error: " + carbonfiber[xloopx0] + ". Delete Image.");}
			//}catch(Exception e){JOptionPane.showMessageDialog(null,"Image read error: " + carbonfiber[xloopx0] + ". Delete Image.");}

		}//for******************************************************************************************


		l0.setText("100% Compleat"); 

	}//imagechange















	public void imagechangename(){//rename



		for(int xloopx0 = 0; xloopx0 < nm.carbon[0][0].length; xloopx0++){//********************************************


			l2.setText((xloopx0 * 100 / nm.carbon[0][0].length) + "% Compleat"); 

			try{



				String namex = new String(nm.carbon[0][nm.picture_1_xx][xloopx0]);
				String namex_out = new String(nm.carbon[0][nm.part_number_xx][xloopx0].replace("[","").replace("]","").replace(" ","_") + ".jpg");
				String namex_path = new String(nm.carbon[0][nm.picture_1_xx][xloopx0]);

				int ixx0 = 0;
				ixx0 = namex.lastIndexOf("/");

				if(ixx0 > -1){namex = namex.substring(ixx0, namex.length());}
				else{ixx0 = namex.lastIndexOf("\\"); if(ixx0 > -1){namex = namex.substring(ixx0, namex.length());} }

				namex = "cs_images" + namex;
				System.out.println("namex " + namex);


				//path
				ixx0 = 0;
				ixx0 = namex_path.lastIndexOf("/");

				if(ixx0 > -1){namex_path = namex_path.substring(0, ixx0 + 1);}
				else{ixx0 = namex_path.lastIndexOf("\\"); if(ixx0 > -1){namex_path = namex_path.substring(0, ixx0 + 1);} }

				System.out.println("namex_path " + namex_path);




				BufferedInputStream imageStream = new BufferedInputStream(new FileInputStream(namex));
 
				Image image = (Image) ImageIO.read(imageStream);

				System.out.println("FIX " + nm.carbon[0][nm.picture_1_xx][xloopx0]);

				ix0 = image.getHeight(null);
				ix1 = image.getWidth(null);
 
				BufferedImage thumbImage = new BufferedImage(ix0, ix1, BufferedImage.TYPE_INT_RGB);

        		Graphics2D g2dx = thumbImage.createGraphics(); 

       			g2dx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        		g2dx.drawImage(image, 0, 0, ix0, ix1, null);
				//g2dx.drawLine(0,0,300,300);


        		// Write the scaled image to the outputstream
     			File out = new File("cs_images\\" + namex_out);          

       			ImageIO.write(thumbImage, "jpeg", out);
				nm.carbon[0][nm.picture_1_xx][xloopx0] = namex_path + "" + namex_out;

				imageStream.close();

			}catch (IOException e){System.out.println("get file failed");}

		}//for******************************************************************************************


	l2.setText("100% Compleat"); 
	}//imagechange


















//workers end***************************************************************************************
//workers end***************************************************************************************







public void actionPerformed(ActionEvent event){


	if(event.getSource() == bx0){imagechange2x2();}//
	if(event.getSource() == bx1){imagechange2();}//
	if(event.getSource() == bx2){imagechangename();}//



}//action**




    public static void main(String[] args){

		alchemy_images4 xr = new alchemy_images4();

    }//main





}//last
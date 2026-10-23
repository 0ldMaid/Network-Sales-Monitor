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





public class alchemy_waterm{

csv_loader1 xcsvx;
int get_file_fail = 0;

int thisc2 = 0;
int thisc3 = 0;
int csv_passes_x = 25;
int runs = 10000;

//**load**

File file_sst_1 = new File("C:\\Users\\Black\\Desktop\\vulture\\second stage\\cs_images\\");

String file_ss_1 = new String("C:\\Users\\Black\\Desktop\\vulture\\second stage\\cs_images\\");

//**load**


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 460;
int xzy = 355;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


String imagex1 = new String();
String imagex2 = new String();


String main = new String("");
String xlinex = new String("");
String blank = new String("");

int discountx = 17;
int discountx2 = 0;

int geti_0 = 0;
int geti_1 = 0;
int geti_2 = 0;
int geti_3 = 0;
int geti_4 = 0;
int geti_5 = 0;
int geti_6 = 0;
int geti_7 = 0;
int geti_8 = 0;


String title_1 = new String();
String title_2 = new String();

String cx0 = new String();
String cx1 = new String();
String cx2 = new String();
String cx3 = new String();
String cx4 = new String();

int ixx0 = 0;
int ixx1 = 0;

int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0; 
int ix6 = 0; 


String picture_link = new String("C:\\Users\\Black\\Desktop\\ebay\\pictures_l_as\\");

String change_image_name = new String();

String carbonfiber[][] = new String[runs][500];
String goldfiber[][] = new String[runs][500];
String platinum[][] = new String[runs][500];
String carbon[][] = new String[runs][500];
String carbon_out[] = new String[runs];


int platinum0 = 0;
int platinum1 = 1;
int platinum2 = 2;
int platinum3 = 3;
int platinum4 = 4;
int platinum5 = 5;
int platinum6 = 6;
int platinum7 = 7;
int platinum8 = 8;

int carbon_num = 0;

String ximages[] = new String[runs];
String silver[] = new String[runs];


String save_as = new String("converted_csv_products.CSV");

File file_csv_1;
File file_csv_2;

Float sx1 = (float) 0.0;
Float sx2 = (float) 0.0;
Float sx3 = (float) 0.0;
Float sx4 = (float) 0.0;




alchemy_waterm(){//********************************************************************************************************
	
	System.out.println("");
	System.out.println("REBUILD>>");
	System.out.println("");




	if(file_sst_1.exists()){

		ximages = file_sst_1.list();
		System.out.println("Images: " + ximages.length);

	}//***********************
	else{System.out.println("NO images.");}

	ixx0 = ximages.length;


	System.out.println("");
	System.out.println("Stage 1.");
	System.out.println("");


	


	for(int xloop = 0; xloop < ixx0; xloop++){//******

		ixx1 = xloop;
		if(ximages[ixx1].length() < 1){System.out.println("NO NAME");}
		else{rebuild_image();}

	}//***************************************************


}//postid**************************************************************************************************************









//******************************************************************************
//******************************************************************************
	public void rebuild_image(){


		System.out.println(ximages[ixx1]);

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

			BufferedInputStream imageStream1 = new BufferedInputStream(new FileInputStream(file_ss_1 + ximages[ixx1]));

			Image image1 = (Image) ImageIO.read(imageStream1);

			ix0 = image1.getWidth(null);
	    	ix1 = image1.getHeight(null);



			System.out.println(ix0);
			System.out.println(ix1);


			if(ix0 >= ix1){ix2 = ix0;}//if********
			else if(ix1 >= 0x1){ix2 = ix1;}//if********
			else{System.out.println("image falure.");}


	 
			BufferedImage thumbImage = new BufferedImage((ix2 + 20), (ix2 + 20), BufferedImage.TYPE_INT_RGB);

	        Graphics2D g2dx = thumbImage.createGraphics(); 

	        g2dx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

			g2dx.setColor(Color.WHITE);
	    	g2dx.fillRect(0, 0, (ix2 + 20), (ix2 + 20));


			ix3 = ((ix2 / 2) - (ix0 / 2) + 10);
			ix4 = ((ix2 / 2) - (ix1 / 2) + 10);

	        g2dx.drawImage(image1, ix3, ix4, ix0, ix1, null);




	        // Write the scaled image to the outputstream
	     	File out = new File(file_ss_1 + ximages[ixx1]);          

	        ImageIO.write(thumbImage, "jpeg", out);

			imageStream1.close();

		}catch (IOException e){System.out.println("get file fail"); get_file_fail = 1;}



	}//else ********************************>








	}//************************















	public static void main(String[] args) {

		alchemy_waterm xr = new alchemy_waterm();

	}//main


}//last
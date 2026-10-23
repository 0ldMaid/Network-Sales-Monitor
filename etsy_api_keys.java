import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;

import java.awt.Toolkit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;








public class etsy_api_keys extends JFrame{//************************************************************************

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 230;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox3 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox4 = new JLabel("Loading...", JLabel.LEFT);

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;

int ix0x = 0;
int ix1x = 0; 
int ix2x = 0;

Float fx0x = (float) 0.0;

int stop = 0;
int post_number = 1;


Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");
String cx3 = new String("");

File st1;


String[][] carbonfiber;
String xlinex = new String("");
String blank = new String("");


String ssxs;
String ssxu;
String ssxp;


JTextField key1 = new JTextField("", 16);
JTextField key2 = new JTextField("", 16);
JTextField key3 = new JTextField("", 16);
JTextField key4 = new JTextField("", 16);



etsy_api_keys(){//*********************************************************************************

	super("Etsy API Keys");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(nm.jgray);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){savex(); pullThePlug();}});//





//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);


	ximagex = new ImageIcon(this.getClass().getResource("images/etsy.png")).getImage();








	Icon aicon = new ImageIcon(ximagex);

	infox0.setPreferredSize(new Dimension(320, 50));
	infox0.setBackground(black);
	infox0.setForeground(blackx);
	infox0.setOpaque(false);
	infox0.setIcon(aicon);
	infox0.setText("  Save Etsy API Keys");
	infox0.setHorizontalTextPosition(JLabel.LEFT);
	infox0.setIconTextGap(30);

	infox2.setPreferredSize(new Dimension(120, 20));
	infox2.setText("  APP NAME");
	infox2.setForeground(blackx);
	infox2.setOpaque(true); 
	infox2.setBackground(nm.jgray);

	infox3.setPreferredSize(new Dimension(120, 20));
	infox3.setText("  KEYSTRING");
	infox3.setForeground(blackx);
	infox3.setOpaque(true); 
	infox3.setBackground(nm.jgray);

	infox4.setPreferredSize(new Dimension(120, 20));
	infox4.setText("  SHARED SECRET");
	infox4.setForeground(blackx);
	infox4.setOpaque(true); 
	infox4.setBackground(nm.jgray);



	JPanel bkp = new JPanel();
	bkp.setPreferredSize(new Dimension(340, 220));
	bkp.setLayout(new FlowLayout());
	bkp.setBackground(nm.jgray);
	bkp.setForeground(blackx);
	bkp.add(infox0);

	bkp.add(infox2); bkp.add(key2); 
	bkp.add(infox3); bkp.add(key3); 
	bkp.add(infox4); bkp.add(key4); 



	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(nm.program_gray_2);
	cpx.setForeground(whitex);
	cpx.add(bkp);


	setVisible(true);




	//key1.setText(nm.carbon[5][6][nm.what_item]);
	//key2.setText(nm.carbon[5][7][nm.what_item]);

	key2.setText("Alchemist");
	key2.setEditable(false);

	key3.setText(nm.carbon[5][2][nm.what_item]);
	key4.setText(nm.carbon[5][3][nm.what_item]);




	requestFocus();



}//csv_loader_x1********************************************************







	public void savex(){



		//nm.carbon[5][6][nm.what_item] = key1.getText();
		nm.carbon[5][7][nm.what_item] = key2.getText();
		nm.carbon[5][2][nm.what_item] = key3.getText();
		nm.carbon[5][3][nm.what_item] = key4.getText();



	}//*****************












    public void pullThePlug() {

    	System.out.println("PULL THE PLUG");

    	nm.firex = 1;


    }//pull











class BackgroundPanel extends JPanel{

  	Image image;
  	public BackgroundPanel(){
    
    	try{

      		image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3b.jpg"), "background3b.jpg"));

    	}catch (Exception e) { System.out.println("Failed001"); }

  	}//backgroundpanel

  	protected void paintComponent(Graphics g){

    	super.paintComponent(g); 
    	if (image != null){

      		g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);

  		}//****************

  	}//paint

}//jpanel




}//last****************************************
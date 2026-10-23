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


//<<<\">>>



public class alchemy_copy_to extends JFrame implements ActionListener{




JFrame frame_1 = new JFrame();
//JFileChooser file_chooser = new JFileChooser(file_open_1);

Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 380;
int xzy = 190;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

int runs = 50000;
String main = new String("");

String cx0 = new String();
String cx1 = new String();
String cx2 = new String();
String cx3 = new String();
String cx4 = new String();

int section_number = 0;
int section_number2 = 0;
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

JComboBox cb_column;
JComboBox cb_column2;
//JComboBox cb_sitese;

JLabel l0 = new JLabel();
JLabel l1 = new JLabel();
Label l2 = new Label();
Label l3 = new Label();
Label l4 = new Label();
Label btl0 = new Label();
Label btl1 = new Label();
Label btl2 = new Label();
Label btl3 = new Label();
Label btl4 = new Label();
Label btl5 = new Label();


TextField sectionxa = new TextField("", 28);
TextField sectionxb = new TextField("", 28);


String[][] carbonfiber = new String[0][0];
String[] silver = new String[0];
String[] gold = new String[runs];
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





alchemy_copy_to(){//********************************************************************************************************
	
	super("Copy To");
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

	b1 = new JButton("Undo");
	b1.setMargin(new Insets(0, 0, 0, 0));  
	b1.addActionListener(this);
	b1.setPreferredSize(new Dimension(70, 20));
	b1.setIcon(imx0);
	b1.setHorizontalTextPosition(JButton.CENTER);
	b1.setForeground(Color.WHITE);



	carbonfiber = nm.carbon[0];
	silver = new String[carbonfiber.length];


	for(int xloop0 = 0; xloop0 < carbonfiber.length; xloop0++){//******

		silver[xloop0] = carbonfiber[xloop0][0];

	}//for


	cb_column = new JComboBox(silver);
	cb_column.setSelectedIndex(0);
	cb_column.addActionListener(this);
	cb_column.setPreferredSize(new Dimension(360, 20));

	cb_column2 = new JComboBox(silver);
	cb_column2.setSelectedIndex(0);
	cb_column2.addActionListener(this);
	cb_column2.setPreferredSize(new Dimension(360, 20));



	sectionxa.setBackground(Color.BLACK);
	sectionxa.setForeground(Color.WHITE);
	sectionxb.setBackground(Color.BLACK);
	sectionxb.setForeground(Color.WHITE);


	l0 = new JLabel("Copy info from this field: ", JLabel.LEFT);
	l0.setPreferredSize(new Dimension(370, 20));
	l0.setBackground(c2);
	l0.setForeground(Color.WHITE);

	l1 = new JLabel("Insert into this Field: ", JLabel.LEFT);
	l1.setPreferredSize(new Dimension(370, 20));
	l1.setBackground(c2);
	l1.setForeground(Color.WHITE);

	l2 = new Label("Replace:", Label.LEFT);
	l2.setPreferredSize(new Dimension(75, 20));
	l2.setBackground(c2);
	l2.setForeground(Color.WHITE);




    BackgroundPanel jp0 = new BackgroundPanel();
	jp0.setPreferredSize(new Dimension(370, 120));
	jp0.setBackground(c1);
	jp0.add(l0);
	jp0.add(cb_column);
	jp0.add(l1);
	jp0.add(cb_column2);


    JPanel jp2 = new JPanel();
	jp2.setPreferredSize(new Dimension(370, 40));
	jp2.setBackground(c1);
	jp2.add(b0);
	jp2.add(b1);


	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(Color.BLACK);
	cp.setForeground(Color.BLACK);
	cp.add(jp0);
	cp.add(jp2);



	setVisible(true);


}//postid**************************************************************************************************************














	public void loadx(){



	}//loadx





//workers***************************************************************************************
//workers***************************************************************************************




	public void replacex(){//replace a with b




		for (int loop3 = 1; loop3 < nm.carbon[0][0].length; loop3++){//****************************

			nm.carbon[0][section_number2][loop3] = nm.carbon[0][section_number][loop3];

		}//for*************************************************************************************



		nm.firex = 1;

		pullThePlug();
	

	}//replacex*******************************




//workers end***************************************************************************************
//workers end***************************************************************************************









public void actionPerformed(ActionEvent event){





		if(event.getSource() == cb_column){

           	JComboBox cb = (JComboBox) event.getSource();
           	Object newItem = cb.getSelectedItem();

			for (int loop1 = 0; loop1 < nm.carbon[0].length; loop1++){//s1x

				if(nm.carbon[0][loop1][0].equals(newItem)){section_number = loop1; System.out.println("yyyx " + loop1);}

			}//*********************
	
		}//not used



		if(event.getSource() == cb_column2){

            JComboBox cb = (JComboBox) event.getSource();
            Object newItem = cb.getSelectedItem();
		
			for (int loop1 = 0; loop1 < nm.carbon[0].length; loop1++){//s1x

				if(nm.carbon[0][loop1][0].equals(newItem)){section_number2 = loop1; System.out.println("yyyx " + loop1);}

			}//*********************
	
		}//not used




	if(event.getSource() == b0){replacex();}//



}//action**




    public static void main(String[] args){

		alchemist_copy_to xr = new alchemist_copy_to();

    }//main






    public void pullThePlug() {

    	nm.firex = 1;

   		WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
   		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull





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
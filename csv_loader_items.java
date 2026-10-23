import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;






public class csv_loader_items extends JFrame{

JFrame frame = new JFrame();
File f1 = new File("jstelth.class");
JFileChooser fc = new JFileChooser(f1);


Dimension dimx = new Dimension();//for csv field. 
Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 660;
int xzy = 650;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

JPanel jpk1 = new JPanel();
JScrollPane scrollPane = new JScrollPane(jpk1);

String carbon1[][] = new String[1][1];
String carbon2[][] = new String[1][1];

int kcountxx = 0;
int kcountxx2 = 0;

String cx0 = new String("");

JTextField loader_x = new JTextField("", 57);
JButton load_b = new JButton("Load");
JButton import_x = new JButton("Import");
JLabel infox0 = new JLabel("load csv file.", JLabel.LEFT);
Label infox1 = new Label("Import to Alchemist. ");



JPanel jpkx[] = new JPanel[100];
JComboBox jcbx[] = new JComboBox[100];
JLabel jlx[] = new JLabel[100];
JLabel jly[] = new JLabel[100];
JLabel jlxi[] = new JLabel[100];



ImageIcon imx4;


int ix0 = 0;
int ix1 = 0;

Integer iix[] = new Integer[100];

String cxx5[] = new String[100];


Object newItem;
JComboBox cb;

String gold[][] = new String[100][1];

csv_loader1 xcsvx1;


File file_1 = new File("alchemist_export_csv.csv");




csv_loader_items(){//********************************************************************************************************
	
	super("Import CSV file");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);

	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));


    loader_x.setEditable(false);


	//JPanel jpk1 = new JPanel();
	jpk1.setPreferredSize(new Dimension(300, 710));
	//jpk1.setBackground(st_gray1);
	jpk1.setToolTipText("display area.");



	//JScrollPane scrollPane = new JScrollPane(jpk1);
	scrollPane.setPreferredSize(new Dimension(400, 550));
	//scrollPane.setBackground(bluex2);
	scrollPane.setFont(new Font("Arial", Font.PLAIN, 14));
	//scrollPane.add(jpkx);




	JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(405, 560));
	jpk2.add(scrollPane);
	jpk2.add(infox1);
	



	JPanel jpk3 = new JPanel();
	jpk3.setPreferredSize(new Dimension(220, 560));
	jpk3.setBackground(nm.program_gray_2);
	jpk3.add(load_b);
	jpk3.add(import_x);




	infox0.setPreferredSize(new Dimension(380, 20));
	infox0.setBackground(Color.BLACK);
	infox0.setForeground(Color.WHITE);

	infox1.setPreferredSize(new Dimension(330, 20));
	infox1.setBackground(Color.BLACK);
	infox1.setForeground(Color.WHITE);





	load_b.setMargin(new Insets(0, 0, 0, 0));
  	//load_b.addActionListener(this);
	load_b.setPreferredSize(new Dimension(55, 20));
 	load_b.setIcon(imx4);
	load_b.setHorizontalTextPosition(JButton.CENTER);
 	load_b.setForeground(Color.WHITE);



	import_x.setMargin(new Insets(0, 0, 0, 0));
  	//import_x.addActionListener(this);
	import_x.setPreferredSize(new Dimension(55, 20));
 	import_x.setIcon(imx4);
	import_x.setHorizontalTextPosition(JButton.CENTER);
 	import_x.setForeground(Color.WHITE);



	file_1 = new File(nm.carbon[4][0][26] + "/alchemist_export_csv.csv");

    JMenu fileMenu = new JMenu("File");

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(fileMenu);


    //Add the menubar to the frame
    //setJMenuBar(menuBar);


	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(nm.program_gray_1);
	cp.setForeground(Color.WHITE);
    cp.add(loader_x);
	cp.add(jpk2);
	cp.add(jpk3);
    cp.add(infox0);


	//setVisible(true);

	loadx();
	build_import();

}//postid**************************************************************************************************************









	public void loadx(){

		System.out.println("Load loadx");

		file_1 = new File(nm.carbon[4][0][4]);


        loader_x.setText(file_1.toString());


		xcsvx1 = new csv_loader1(file_1);
		carbon1 = xcsvx1.getData0();
		kcountxx = xcsvx1.getData1();
		kcountxx2 = xcsvx1.getData2();


		iix = new Integer[kcountxx];

		for(int xloopx = 0; xloopx < kcountxx; xloopx++){//*****************
	
			iix[xloopx] = 0;
	
		}//for**************************************************************


		infox0.setText(kcountxx + " sections, and " + kcountxx2 + " rows.");



	}//loadx************















	public void build_import(){//***********************************************************************


		System.out.println(kcountxx);
		System.out.println(kcountxx2);


		carbon2 = new String[100][(kcountxx2 + 1)];

		System.out.println("Start loop");

		for(int xloopx0 = 1; xloopx0 < carbon2[0].length; xloopx0++){//**************************
		
			for(int xloopx1 = 0; xloopx1 < 100; xloopx1++){//****************************

				carbon2[xloopx1][xloopx0] = new String("");

			}//for***********************************************************************


			ix0 = 0;
			for(int xloopx3 = 0; xloopx3 < kcountxx; xloopx3++){//****************************

				if(ix0 < 100){
	
					carbon2[ix0][xloopx0] = carbon1[ix0][(xloopx0 -1)];
					if(carbon2[ix0][xloopx0].substring(0, 1).equals("\"")){carbon2[ix0][xloopx0] = carbon2[ix0][xloopx0].substring(1, carbon2[ix0][xloopx0].length() -1);}

				ix0++;
				}//if

			}//for****************************************************************************

			//carbon2[nm.item_price_xx][xloopx0] = new String("0.00");
			//carbon2[nm.item_cost_xx][xloopx0] = new String("0.00");

		}//for************************************************************************************


		System.out.println("End loop");


		for(int xloop0 = 0; xloop0 < 1; xloop0++){//******

			for(int xloop1 = 0; xloop1 < 100; xloop1++){//*******************
		
				carbon2[xloop1][xloop0] = new String("*" + nm.db_string[xloop1]);
		
			}//if************************************************************

		}//if**********************************************


		//System.exit(0);

		nm.carbon[0] = carbon2;


		pullThePlug();
	

	}//import*************











    public void pullThePlug() {


   		nm.firex = 1;

    	System.out.println("PULL THE PLUG");

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull










public static void main(String[] args){

	csv_loader_items xr = new csv_loader_items();

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
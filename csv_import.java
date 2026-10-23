import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;
import java.util.Date;
import java.text.SimpleDateFormat;





public class csv_import extends JFrame implements ActionListener{

Dimension dimx = new Dimension();//for csv field. 
Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 660;
int xzy = 650;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

JFrame frame = new JFrame();
File f1 = new File("jstelth.class");
JFileChooser fc = new JFileChooser(f1);

JPanel jpk1 = new JPanel();
JScrollPane scrollPane = new JScrollPane(jpk1);

JTextField loader_x = new JTextField("", 51);
JButton load_b = new JButton("Load");
JButton import_x = new JButton("Import");
Label infox0 = new Label("Import CSV file into program database.", Label.LEFT);
Label infox1 = new Label("Import to Alchemist. ");

JLabel infox10 = new JLabel("load csv file.", JLabel.LEFT);
JLabel infox11 = new JLabel("load csv file.", JLabel.LEFT);
JLabel infox12 = new JLabel("load csv file.", JLabel.LEFT);
JLabel infox13 = new JLabel("load csv file.", JLabel.LEFT);
JLabel infox14 = new JLabel("load csv file.", JLabel.LEFT);
JLabel infox15 = new JLabel("load csv file.", JLabel.LEFT);

JPanel jpkx[] = new JPanel[100];
JComboBox jcbx[] = new JComboBox[100];
JLabel jlx[] = new JLabel[100];
JLabel jly[] = new JLabel[100];
JLabel jlxi[] = new JLabel[100];

JComboBox jc_section = new JComboBox();

ImageIcon imx4;

Integer iix[] = new Integer[100];
int ix0 = 0;
int ix1 = 0;
int kcountxx = 0;
int kcountxx2 = 0;
int db_import_number = 0;

String cxx5[] = new String[100];
String gold[][] = new String[100][1];
String carbon1[][] = new String[1][1];
String import_section[] = new String[3];
String cx0 = new String("");

Object newItem;
JComboBox cb;

File file_1 = new File("alchemist_export_csv.csv");

JCheckBox checkbox = new JCheckBox("Skip first line");

csv_loader2 xcsvx1;







csv_import(){//********************************************************************************************************
	
	super("Import CSV file");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
	addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e) {nm.csv_import_open = false;}});//

//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	//imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));


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


	checkbox.setPreferredSize(new Dimension(180, 20));
	checkbox.setSelected(true);


	infox10.setPreferredSize(new Dimension(180, 20));
	infox10.setBackground(Color.BLACK);
	infox10.setForeground(Color.BLACK);

	infox11.setPreferredSize(new Dimension(180, 20));
	infox11.setBackground(Color.BLACK);
	infox11.setForeground(Color.BLACK);

	infox12.setPreferredSize(new Dimension(180, 20));
	infox12.setBackground(Color.BLACK);
	infox12.setForeground(Color.BLACK);

	infox13.setPreferredSize(new Dimension(180, 20));
	infox13.setBackground(Color.BLACK);
	infox13.setForeground(Color.BLACK);

	infox14.setPreferredSize(new Dimension(180, 20));
	infox14.setBackground(Color.BLACK);
	infox14.setForeground(Color.BLACK);

	infox15.setPreferredSize(new Dimension(180, 20));
	infox15.setBackground(Color.BLACK);
	infox15.setForeground(Color.BLACK);



	JPanel jpk2 = new JPanel();
	jpk2.setPreferredSize(new Dimension(405, 560));
	jpk2.add(scrollPane);
	jpk2.add(infox1);
	


	import_section[0] = new String("Import into the Export DB");
	import_section[1] = new String("Import into the Sold DB");
	import_section[2] = new String("Import into the Archived DB");

	jc_section = new JComboBox(import_section);
	jc_section.setPreferredSize(new Dimension(180, 20));
	jc_section.addActionListener(this);



	JPanel jpk3x = new JPanel();
	jpk3x.setPreferredSize(new Dimension(180, 260));
	jpk3x.setBackground(nm.gray8);
	jpk3x.add(import_x);


	JPanel jpk3 = new JPanel();
	jpk3.setPreferredSize(new Dimension(220, 560));
	jpk3.setBackground(nm.jgray);
	jpk3.add(jc_section);
	jpk3.add(infox10);
	jpk3.add(infox11);
	jpk3.add(infox12);
	jpk3.add(infox13);
	jpk3.add(infox14);
	jpk3.add(checkbox);         //jpk3.add(infox15);
	jpk3.add(jpk3x);


	infox0.setPreferredSize(new Dimension(330, 20));
	//infox0.setBackground(Color.BLACK);
	infox0.setForeground(Color.BLACK);

	infox1.setPreferredSize(new Dimension(330, 20));
	infox1.setBackground(Color.BLACK);
	infox1.setForeground(Color.WHITE);


	load_b.setMargin(new Insets(0, 0, 0, 0));
  	load_b.addActionListener(this);
	load_b.setPreferredSize(new Dimension(60, 20));
	load_b.setHorizontalTextPosition(JButton.CENTER);
 	load_b.setForeground(Color.BLACK);
	load_b.setBackground(nm.program_gray_1);


	import_x.setMargin(new Insets(0, 0, 0, 0));
  	import_x.addActionListener(this);
	import_x.setPreferredSize(new Dimension(105, 20));
	import_x.setHorizontalTextPosition(JButton.CENTER);
 	import_x.setForeground(Color.BLACK);
	import_x.setBackground(nm.program_gray_1);



	file_1 = new File(nm.carbon[4][0][26] + "/alchemist_export_csv.csv");

    JMenu fileMenu = new JMenu("File");

    JMenuBar menuBar = new JMenuBar();
    menuBar.add(fileMenu);


    //Add the menubar to the frame
    //setJMenuBar(menuBar);


	Container cp = getContentPane();
	cp.setLayout(new FlowLayout());
	cp.setBackground(nm.jblue);
	cp.setForeground(Color.WHITE);
    cp.add(loader_x);
	cp.add(load_b);
	cp.add(jpk2);
	cp.add(jpk3);
    cp.add(infox0);



	JFileChooser fc = new JFileChooser(file_1);

	fc.setCurrentDirectory(new File(file_1.getAbsolutePath()));

	fc.setSelectedFile(file_1);
	frame.setIconImage(ximagex);
	int returnVal = fc.showOpenDialog(frame);


	file_1 = fc.getSelectedFile(); //This grabs the File you typed


	setVisible(true);

	loadx();


	infox12.setText("Import into DB 0");

}//postid**************************************************************************************************************










	public void import_csv() {


		JFileChooser fc = new JFileChooser(file_1);

		fc.setCurrentDirectory(new File(file_1.getAbsolutePath()));

		fc.setSelectedFile(file_1);

		int returnVal = fc.showOpenDialog(frame);


		file_1 = fc.getSelectedFile(); //This grabs the File you typed

		loadx();


	}//*********************










	public void loadx() {


        loader_x.setText(file_1.toString());

		xcsvx1 = new csv_loader2(file_1);
		carbon1 = xcsvx1.getData0();
		kcountxx = xcsvx1.getData1();
		kcountxx2 = xcsvx1.getData2();

		try {
        
        	System.out.println(carbon1[4][3]);
	
		} catch (Exception e) {System.out.println("0979870");}

		iix = new Integer[kcountxx];

		for (int xloopx = 0; xloopx < kcountxx; xloopx++) {//****
	
			iix[xloopx] = 0;
	
		}//for***************************************************


		infox10.setText(kcountxx + " sections.");
		infox11.setText(kcountxx2 + " rows.");

		build_import();


	}//loadx************









	public void build_import() {//***********************************************************************

		jpk1.removeAll();


		for (int xloopx = 0; xloopx < nm.db_cc_number; xloopx++) {//******

			cxx5 = nm.db_string;
	
		}//for************************************************************


		System.out.println("kcountxx " + kcountxx);


		for (int loopx = 0; loopx < kcountxx; loopx++) {//******


			jlx[loopx] = new JLabel(carbon1[loopx][0], JLabel.LEFT);
			jlx[loopx].setPreferredSize(new Dimension(130, 20));
			jlx[loopx].setBackground(Color.BLACK);
			jlx[loopx].setForeground(Color.BLACK);


			jly[loopx] = new JLabel("", JLabel.LEFT);
			jly[loopx].setPreferredSize(new Dimension(50, 20));
			jly[loopx].setBackground(Color.BLACK);
			jly[loopx].setForeground(Color.BLACK);


			jlxi[loopx] = new JLabel(">>>", JLabel.LEFT);


			jcbx[loopx] = new JComboBox(cxx5);
			jcbx[loopx].setPreferredSize(new Dimension(130, 20));
			jcbx[loopx].addActionListener(this);

			ix0 = 0;
	
			for (int loopx2 = 0; loopx2 < cxx5.length; loopx2++) {//****
	
				//System.out.println(cxx5[loopx2] + "<>" + carbon1[loopx][0] + "<");
				if (cxx5[loopx2].equals(carbon1[loopx][0])){ix0 = loopx2; break;}
				else if (("\"" + cxx5[loopx2] + "\"").equals(carbon1[loopx][0])) {ix0 = loopx2; break;}
	
			}//for******************************************************

			jcbx[loopx].setSelectedIndex(ix0);




			jpkx[loopx] = new JPanel();
			jpkx[loopx].setPreferredSize(new Dimension(370, 30));
			jpkx[loopx].setBackground(nm.gray8);
			jpkx[loopx].setToolTipText("display area. " + loopx);
			//jpkx[loopx].add(jly[loopx]);
			jpkx[loopx].add(jlx[loopx]);
			jpkx[loopx].add(jlxi[loopx]);
			jpkx[loopx].add(jcbx[loopx]);

			System.out.println("add " + loopx);


		}//for*************************************************



		for (int loopx = 0; loopx < kcountxx; loopx++) {//*****
		
			jpk1.add(jpkx[loopx]);
	
		}//for*************************************************



		if (kcountxx > 1) {
	
			jlx[0].setText("Load");
			jlx[0].setText(carbon1[0][0]);
	
		}//****************


		jpk1.setPreferredSize(new Dimension(155, (kcountxx * 35) + 15));

		repaint();

	}//build************************************************************************************














	public void importxx(){

        gold = new String[nm.db_cc_number][kcountxx2];


		for (int xloop0 = 0; xloop0 < gold[0].length; xloop0++) {//***********************************************************
		
			infox0.setText("Section 2 of 3 " + (nm.carbon[db_import_number][0].length / 100 * xloop0));
			
			for (int xloop1 = 0; xloop1 < nm.carbon[db_import_number].length; xloop1++) {//*******************

				gold[xloop1][xloop0] = nm.new_item_db_string[xloop1];

			}//for********************************************************************************************
			
		}//for****************************************************************************************************************



        //System.out.println(carbon1[4][3]);


        for (int xloop0 = 0; xloop0 < kcountxx; xloop0++) {//******************
	
			ix0 = 0;

			infox0.setText("Building " + ((xloop0 * 100) / kcountxx) + "%");

	  		for (int xloop1 = 0; xloop1 < gold[0].length; xloop1++) {//****************************************

	 			try {
	  
	  				//System.out.println("xx " + xloop1 + " " + gold[0].length + " " + xloop0 + " " + carbon1[xloop0][ix0]);
	  				//infox15.setText("xx " + xloop1 + " " + gold[0].length + " " + xloop0 + " " + carbon1[xloop0][ix0]);

	  				gold[ (iix[xloop0]) ][xloop1] = carbon1[xloop0][ix0];
	  				gold[ (iix[xloop0]) ][xloop1] = gold[ (iix[xloop0]) ][xloop1].replace("$|$", "\"").replace("$:$", ",");

	  				cx0 = gold[ (iix[xloop0]) ][xloop1];

	 				if (cx0.substring(0, 1).equals("\"") && cx0.substring(cx0.length() -1, cx0.length()).equals("\"")) {

	 					cx0 = cx0.substring(1, cx0.length() -1); 
	 					gold[ (iix[xloop0]) ][xloop1] = cx0;

	 				}//*************************************************************************************************

	  			} catch (Exception e) {break;}

	 			ix0++;

	  		}//for*********************************************************************************************

        }//for***************************************************************


		//fix picture link

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd-HH:MM:ss");

	
		for (int xloop0 = 0; xloop0 < gold[0].length; xloop0++) {//****************************************

	        
			infox0.setText("Importing " + ((xloop0 * 100) / gold[0].length) + "%");

 			String[][] save_item = new String[nm.db_cc_number][1];

 			for (int xloop3 = 0; xloop3 < nm.db_cc_number; xloop3++) {//**

				save_item[xloop3][0] = gold[xloop3][xloop0];

 			}//***********************************************************

 			if (xloop0 == 0 && checkbox.isSelected()) {System.out.println("SKIP");}
 			else {

 				     if (nm.db_number == 0) {jdb_new_item addx = new jdb_new_item(save_item);}
 				else if (nm.db_number == 2) {jdb_new_sale adds = new jdb_new_sale(save_item);}
 				else if (nm.db_number == 3) {jdb_new_archive adda = new jdb_new_archive(save_item);}

 			}//**

		}//for*******************************************************************************************

	
		

		//gold[nm.item_id_xx][0] = "item_id";
		//nm.carbon[db_import_number] = gold;

		pullThePlug();


	}//import*************











    public void pullThePlug() {


    	nm.csv_import_open = false;

    	System.out.println("PULL THE PLUG");

    	WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
    	Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

   		System.out.println("EXIT");

    }//pull










public static void main(String[] args){

	csv_import xr = new csv_import();

}//main












public void actionPerformed(ActionEvent event){

	if (event.getSource() == load_b) {import_csv(); loadx();}//not used
	if (event.getSource() == import_x){importxx();}//not used




	if (event.getSource() == jc_section) {

        cb = (JComboBox) event.getSource();
        newItem = cb.getSelectedItem();

		for (int loop1 = 0; loop1 < jc_section.getItemCount(); loop1++){//s1x

			if (import_section[0].equals(newItem)) {db_import_number = 0; infox12.setText("Import into DB 0");}
			if (import_section[1].equals(newItem)) {db_import_number = 2; infox12.setText("Import into DB 2");}
			if (import_section[2].equals(newItem)) {db_import_number = 3; infox12.setText("Import into DB 3");}

		}//******************************************************************

	}//not used


	for (int xloop0 = 0; xloop0 < kcountxx; xloop0++) {//******************


		if (event.getSource() == jcbx[xloop0]) {
           
           	cb = (JComboBox) event.getSource();
            newItem = cb.getSelectedItem();
	
			for (int loop1 = 0; loop1 < jcbx[xloop0].getItemCount(); loop1++) {//s1x

				if (cxx5[loop1].equals(newItem)) {iix[xloop0] = loop1;}

			}//********************************************************************
	
		}//************************************


	}//******************************************************************




}//********************************************








    class BackgroundPanel extends JPanel {
  
        Image image;
  
        public BackgroundPanel(){
    
            try {

                image = javax.imageio.ImageIO.read(new java.net.URL(getClass().getResource("images/background3.jpg"), "background3.jpg"));

            } catch (Exception e) { System.out.println("Failed001"); }

        }//backgroundpanel

        protected void paintComponent(Graphics g) {

            super.paintComponent(g); 
    
            if (image != null){
      
                g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);

            }//****************
  
        }//paint

    }//jpanel




}//last
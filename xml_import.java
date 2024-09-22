import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.io.File;
import org.w3c.dom.Document;
import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;







public class xml_import {//************************************************************************

JFrame frame = new JFrame();
File f1 = new File("Listings-Running.csv");
JFileChooser fc = new JFileChooser(f1);




Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 150;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

static int error_code = 0;
int bytesRead = 0;

String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

JLabel infox0 = new JLabel("", JLabel.RIGHT);
JLabel infox1 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox2 = new JLabel("Loading...", JLabel.LEFT);

int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int amazon_items = 0;//number of new items to submit. 
int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int ix0 = 0;
int ix1 = 0; 
int ix2 = 0;
int ix3 = 0;//don't use
int ix6 = 0;
int stop = 0;
int post_number = 1;
int what_item_here = 0;

Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color black = new Color(0.0f, 0.0f, 0.0f);
Color green = new Color(0.2f, 0.5f, 0.2f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
static String cx2 = new String("");


File st1;


String[][] carbonfiber;
String[][] carbon_pass;
String submit_x = new String("");
String xlinex = new String("");
String blank = new String("");


String ssxs;
String ssxu;
String ssxp;

String xml_temp[] = new String[100];

static String ddx;



String CONFIG_XML_NAME = "amazon_template.xml";
String SUBMIT_XML_NAME = "amazon_template.xml";
String SUBMIT_FEEDTYPE = "";
int SUBMIT_NUMBER = 0;









xml_import(){//****************************



	//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();






	error_code = 0;

	//setVisible(true);





	ix0 = 0;


	infox2.setText("Build Upload files...");
	CONFIG_XML_NAME = "alchemist_xml_export.xml";
	SUBMIT_XML_NAME = "alchemist_xml_export.xml";





	frame.setIconImage(ximagex);

	f1 = new File(nm.carbon[4][0][26]);

	fc = new JFileChooser(f1);
	fc.setSelectedFile(new File(f1.toString()));

   	ix0 = fc.showOpenDialog(frame);

   	f1 = fc.getSelectedFile();


	if(f1.exists() && ix0 == 0){

		SUBMIT_NUMBER = 1;

		build_file_item();

	}//if***********************
	else{System.out.println("USER CANCEL");}





	System.out.println(f1);

	//JOptionPane.showMessageDialog(null,"Imported " + CONFIG_XML_NAME);



}//csv_loader_x1********************************************************













	public void build_file_item(){


		//convert xml item for upload*

		try{



	        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

	        Document doc = docBuilder.parse(new File(f1.toString()));

	        // normalize text representation
	        doc.getDocumentElement ().normalize ();
	        System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());


		    NodeList listx; 
	        Node childx;





			ix0 = 0;
			for (int loop1 = 0; loop1 < 100000; loop1++){//**********************************************

				try{

				    listx = doc.getElementsByTagName("item" + Integer.toString(loop1));
				    childx = listx.item(0);
			 	    System.out.println("data in child number 0: "+ childx.getTextContent());

					ix0++;

				}catch(Exception e){System.out.println("NO MORE"); break;}

			}//*****************************************************************************************


			System.out.println(">>> " + ix0);

			carbon_pass = new String[100][(ix0 + nm.carbon[0][0].length)];





			ix6 = 0;
			for(int xloopx1 = 0; xloopx1 < (nm.carbon[0][0].length); xloopx1++){//***************

				for(int xloopx2 = 0; xloopx2 < nm.db_cc_number; xloopx2++){//***************

					carbon_pass[xloopx2][xloopx1] = nm.carbon[0][xloopx2][xloopx1];

				}//*************************************************************************
				ix6++;

			}//**********************************************************************************







			NodeList list1[] = new NodeList[100];
		    Node child1[] = new Node[100];


			for (int loop1 = 0; loop1 < ix0; loop1++) {//******************************************

				String[][] save_item = new String[nm.db_cc_number][1];

				for (int loop2 = 0; loop2 < xml_temp.length; loop2++) {//*************************

				    list1[loop2] = doc.getElementsByTagName(nm.db_string[loop2]);
				    child1[loop2] = list1[loop2].item(loop1);

			        //System.out.println("data in child number 0: "+ child1[loop2].getTextContent());

				    carbon_pass[loop2][ix6] = child1[loop2].getTextContent();
				
					save_item[loop2][0] = child1[loop2].getTextContent();

				}//******************************************************************************
				
				save_item[nm.item_id_xx][0] = "xm" + nm.carbon[4][0][12];

				int h43d = Integer.parseInt(nm.carbon[4][0][12]) + 1;
				nm.carbon[4][0][12] = Integer.toString(h43d);

				jdb_new_item addx = new jdb_new_item(save_item);

				ix6++;

			}//*************************************************************************************


			
		    //System.out.println("xxxxxxxxxxxxxxxxxxxxxx" + carbon_pass[nm.title_xx][0]);
		    //System.out.println("xxxxxxxxxxxxxxxxxxxxxx" + carbon_pass[nm.title_xx][1]);
		    //System.out.println("xxxxxxxxxxxxxxxxxxxxxx" + carbon_pass[nm.title_xx][1280]);


		    //not used anymore
			//nm.carbon[0] = carbon_pass;



		}catch(Exception ex){

			System.out.println("xml failed."); infox2.setText("xml failed.");

	        System.err.println("+============================+");
	        System.err.println("|        XML Error           |");
	        System.err.println("+============================+");
	        System.err.println(ex.getClass());
	        System.err.println(ex.getMessage());
	        System.err.println("+============================+");

		}//catch





	    System.out.println("Done");


	}//*************************build_file








}//last****************************************
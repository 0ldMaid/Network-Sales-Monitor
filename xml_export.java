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







public class xml_export {//************************************************************************

JFrame frame = new JFrame();
File f1 = new File("Listings-Running.csv");
JFileChooser fc = new JFileChooser(f1);



byte[] b;




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









xml_export(){//****************************



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

	System.out.println(f1);

	fc = new JFileChooser(nm.carbon[4][0][26]);

	if(nm.db_number == 0){fc.setSelectedFile(new File((nm.carbon[4][0][26] + "\\alchemist_xml_export.xml")));}
	else if(nm.db_number == 2){fc.setSelectedFile(new File((nm.carbon[4][0][26] + "\\alchemist_xml_sold.xml")));}
	else if(nm.db_number == 3){fc.setSelectedFile(new File((nm.carbon[4][0][26] + "\\alchemist_xml_archive.xml")));}


   	ix0 = fc.showSaveDialog(frame);
	System.out.println(ix0 + " " + f1.exists());

	if(ix0 == 0){

   		f1 = fc.getSelectedFile();

		build_template();

		SUBMIT_NUMBER = 1;

		if(nm.total_items_selected > 99){JOptionPane.showMessageDialog(null,"Exporting more then 100 items by XML may not work.");}

		build_file_item();

		JOptionPane.showMessageDialog(null,"Exported " + CONFIG_XML_NAME);

		cx0 = f1.toString();
		ix0 = cx0.lastIndexOf("\\");

		if (ix0 > -1) {nm.carbon[4][0][26] = cx0.substring(0, ix0 + 1);}

		System.out.println(nm.carbon[4][0][26]);

	}//if***********************
	else {System.out.println("USER CANCEL");}


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


	   		NodeList list1[] = new NodeList[100];
        	Node child1[] = new Node[100];



			ix0 = 0;

			for (int loop1 = 0; loop1 < nm.carbon[nm.db_number][0].length; loop1++){//*************************

				for (int loop2 = 0; loop2 < xml_temp.length; loop2++){//*************************


					if(nm.selected_int[loop1] == 1){

	    				list1[loop2] = doc.getElementsByTagName(nm.db_string[loop2]);
	    				child1[loop2] = list1[loop2].item(ix0);
	    				child1[loop2].setTextContent(nm.carbon[nm.db_number][loop2][loop1]);
            			System.out.println("data in child number 0: "+ child1[loop2].getTextContent());


					}//**************************
	

				}//******************************************************************************

				if(nm.selected_int[loop1] == 1){ix0++;}

			}//*************************************************************************************







	   		DOMSource source = new DOMSource(doc);

            PrintStream ps = new PrintStream(f1);
            StreamResult result = new StreamResult(ps);

            // Once again we are using a factory of some sort,
            // this time for getting a Transformer instance,
            // which we use to output the XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            // The actual output to a file goes here
            transformer.transform(source, result);

	    	ps.close();


		} catch (Exception ex) {

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









	public void build_template(){

	


		xml_temp[0]  = new String("<address_1></address_1>");
		xml_temp[1]  = new String("<address_2></address_2>");
		xml_temp[2]  = new String("<address_3></address_3>");
		xml_temp[3]  = new String("<address_4></address_4>");
		xml_temp[4]  = new String("<address_5></address_5>");
		xml_temp[5]  = new String("<address_6></address_6>");
		xml_temp[6]  = new String("<buyer_id></buyer_id>");
		xml_temp[7]  = new String("<buyers_email></buyers_email>");
		xml_temp[8]  = new String("<buyers_first_name></buyers_first_name>");
		xml_temp[9]  = new String("<buyers_last_name></buyers_last_name>");
		xml_temp[10] = new String("<buyers_notes></buyers_notes>");
		xml_temp[11] = new String("<buyers_phone></buyers_phone>");
		xml_temp[12] = new String("<currency></currency>");
		xml_temp[13] = new String("<custom_1></custom_1>");
		xml_temp[14] = new String("<custom_2></custom_2>");
		xml_temp[15] = new String("<custom_3></custom_3>");
		xml_temp[16] = new String("<custom_4></custom_4>");
		xml_temp[17] = new String("<custom_5></custom_5>");
		xml_temp[18] = new String("<custom_6></custom_6>");
		xml_temp[19] = new String("<custom_7></custom_7>");
		xml_temp[20] = new String("<custom_8></custom_8>");
		xml_temp[21] = new String("<custom_9></custom_9>");
		xml_temp[22] = new String("<custom_10></custom_10>");
		xml_temp[23] = new String("<custom_11></custom_11>");
		xml_temp[24] = new String("<custom_12></custom_12>");
		xml_temp[25] = new String("<custom_13></custom_13>");
		xml_temp[26] = new String("<custom_14></custom_14>");
		xml_temp[27] = new String("<custom_15></custom_15>");
		xml_temp[28] = new String("<custom_16></custom_16>");
		xml_temp[29] = new String("<custom_17></custom_17>");
		xml_temp[30] = new String("<custom_18></custom_18>");
		xml_temp[31] = new String("<custom_19></custom_19>");
		xml_temp[32] = new String("<custom_20></custom_20>");
		xml_temp[33] = new String("<custom_21></custom_21>");
		xml_temp[34] = new String("<custom_22></custom_22>");
		xml_temp[35] = new String("<custom_23></custom_23>");
		xml_temp[36] = new String("<custom_24></custom_24>");
		xml_temp[37] = new String("<custom_25></custom_25>");
		xml_temp[38] = new String("<custom_26></custom_26>");
		xml_temp[39] = new String("<custom_27></custom_27>");
		xml_temp[40] = new String("<custom_28></custom_28>");
		xml_temp[41] = new String("<custom_29></custom_29>");
		xml_temp[42] = new String("<custom_30></custom_30>");
		xml_temp[43] = new String("<custom_31></custom_31>");
		xml_temp[44] = new String("<custom_32></custom_32>");
		xml_temp[45] = new String("<custom_33></custom_33>");
		xml_temp[46] = new String("<custom_34></custom_34>");
		xml_temp[47] = new String("<custom_35></custom_35>");
		xml_temp[48] = new String("<custom_36></custom_36>");
		xml_temp[49] = new String("<custom_37></custom_37>");
		xml_temp[50] = new String("<custom_38></custom_38>");
		xml_temp[51] = new String("<custom_39></custom_39>");
		xml_temp[52] = new String("<custom_40></custom_40>");
		xml_temp[53] = new String("<custom_41></custom_41>");
		xml_temp[54] = new String("<custom_42></custom_42>");
		xml_temp[55] = new String("<custom_43></custom_43>");
		xml_temp[56] = new String("<custom_44></custom_44>");
		xml_temp[57] = new String("<custom_45></custom_45>");
		xml_temp[58] = new String("<custom_46></custom_46>");
		xml_temp[59] = new String("<custom_template></custom_template>");
		xml_temp[60] = new String("<date_last_modified></date_last_modified>");
		xml_temp[61] = new String("<date_payment_received></date_payment_received>");
		xml_temp[62] = new String("<date_shipped></date_shipped>");
		xml_temp[63] = new String("<date_sold></date_sold>");
		xml_temp[64] = new String("<ebay_item></ebay_item>");
		xml_temp[65] = new String("<final_value_fee></final_value_fee>");
		xml_temp[66] = new String("<handling></handling>");
		xml_temp[67] = new String("<hits></hits>");
		xml_temp[68] = new String("<item_cost></item_cost>");
		xml_temp[69] = new String("<item_description></item_description>");
		xml_temp[70] = new String("<item_id></item_id>");
		xml_temp[71] = new String("<item_price></item_price>");
		xml_temp[72] = new String("<item_weight></item_weight>");
		xml_temp[73] = new String("<listing_fees></listing_fees>");
		xml_temp[74] = new String("<listing_id></listing_id>");
		xml_temp[75] = new String("<notes></notes>");
		xml_temp[76] = new String("<package_d></package_d>");
		xml_temp[77] = new String("<package_l></package_l>");
		xml_temp[78] = new String("<package_w></package_w>");
		xml_temp[79] = new String("<part_number></part_number>");
		xml_temp[80] = new String("<payment_type></payment_type>");
		xml_temp[81] = new String("<paypal_fees></paypal_fees>");
		xml_temp[82] = new String("<picture_1></picture_1>");
		xml_temp[83] = new String("<quantity_sold></quantity_sold>");
		xml_temp[84] = new String("<sale_id></sale_id>");
		xml_temp[85] = new String("<sale_status></sale_status>");
		xml_temp[86] = new String("<sales_tax></sales_tax>");
		xml_temp[87] = new String("<shipping_company></shipping_company>");
		xml_temp[88] = new String("<shipping_in></shipping_in>");
		xml_temp[89] = new String("<shipping_out></shipping_out>");
		xml_temp[90] = new String("<site_id></site_id>");
		xml_temp[91] = new String("<site_url></site_url>");
		xml_temp[92] = new String("<source_of_sale></source_of_sale>");
		xml_temp[93] = new String("<title></title>");
		xml_temp[94] = new String("<title_url></title_url>");
		xml_temp[95] = new String("<total_on_hand></total_on_hand>");
		xml_temp[96] = new String("<total_sale_amount></total_sale_amount>");
		xml_temp[97] = new String("<tracking_number></tracking_number>");
		xml_temp[98] = new String("<transaction_id></transaction_id>");
		xml_temp[99] = new String("<transaction_info></transaction_info>");





		try {

       	 	BufferedWriter out = new BufferedWriter(new FileWriter(f1));

			out.newLine();
			out.write("<Alchemist version='1.0' encoding='UTF-8'>");


			for (int loop1 = 0; loop1 < nm.total_items_selected; loop1++){//*************************

				out.newLine();
				out.write("<item" + Integer.toString(loop1) + ">");

				for (int loop2 = 0; loop2 < xml_temp.length; loop2++){//*************************

					out.newLine();
					System.out.println(loop2);
					out.write(xml_temp[loop2]);

				}//for***************************************************************************
	
			out.newLine();
			out.write("</item" + Integer.toString(loop1) + ">");


			}//for**********************************************************************************************



			out.newLine();
			out.write("</Alchemist>");

       		out.close();

        } catch (IOException e) {System.out.println("print fail.");}



        System.out.println("Done");



	}//**************************









}//last****************************************
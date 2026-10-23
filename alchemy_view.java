import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;
import javax.swing.*;
import javax.swing.border.*;
import com.ebay.sdk.*;
import com.ebay.sdk.pictureservice.*;
import com.ebay.sdk.pictureservice.eps.*;
import com.ebay.soap.eBLBaseComponents.*;
import java.math.BigDecimal;
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.sql.*;





public class alchemy_view extends JFrame implements ActionListener{


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 1050;
int xzy = 610;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

Object newItem;
JComboBox cb;

String data;
URL url;
OutputStreamWriter wr;
BufferedReader rd;
URLConnection conn;

String data2;
URL url2;
OutputStreamWriter wr2;
BufferedReader rd2;
URLConnection conn2;



JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infoxq = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);

JLabel info0 = new JLabel("POST 0", JLabel.CENTER);
JLabel info1 = new JLabel("POST 1", JLabel.CENTER);
JLabel info2 = new JLabel("POST 2", JLabel.CENTER);
JLabel info3 = new JLabel("POST 3", JLabel.CENTER);
JLabel info4 = new JLabel("POST 4", JLabel.CENTER);
JLabel info5 = new JLabel("POST 5", JLabel.CENTER);
JLabel info6 = new JLabel("POST 6", JLabel.CENTER);
JLabel info7 = new JLabel("POST 7", JLabel.CENTER);
JLabel info8 = new JLabel("POST 8", JLabel.CENTER);
JLabel info9 = new JLabel("POST 9", JLabel.CENTER);
JLabel info10 = new JLabel("POST 10", JLabel.CENTER);
JLabel info11 = new JLabel("POST 11", JLabel.CENTER);



JComboBox post_0 = new JComboBox();
JComboBox post_1 = new JComboBox();
JComboBox post_2 = new JComboBox();
JComboBox post_3 = new JComboBox();
JComboBox post_4 = new JComboBox();
JComboBox post_5 = new JComboBox();
JComboBox post_6 = new JComboBox();
JComboBox post_7 = new JComboBox();
JComboBox post_8 = new JComboBox();
JComboBox post_9 = new JComboBox();
JComboBox post_10 = new JComboBox();
JComboBox post_11 = new JComboBox();



int csv_passes_x = 17;

static int runs2 = 400;
static int runs = 50000;

int kcountxx = 0;
int kcountxx2 = 0;
int csv_int = 0;
int working = 1; 
static int thisc2 = 0; 
static int thisc3 = 0;
int stop = 0;
int post_number = 1;
int db_items = 0;
int carbon_items; 
int running = 0;
int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0;
int ix6 = 0;
int ix1x = 0;
int ix0x = 0;
int cb_edit = 0;
int websites = 50;
int HTMLINT = 0;
int looppx = 0;

Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);
Color bluex2 = new Color(0.2f, 0.27f, 0.39f);
Color grayx1 = new Color(0.7f, 0.7f, 0.7f);
Color grayx2 = new Color(0.6f, 0.6f, 0.6f);
Color grayx3 = new Color(0.4f, 0.4f, 0.4f);


String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");

String[] cxx0 = new String[1];

File st1;

String carbonfiber = new String();
String[][] silver = new String[1][1];
String[][] silverx = new String[1][1];
String xgetx[] = new String[10000];
String xlinex = new String("");
String blank = new String("");
String HTMLGO = new String("");
String new_db = new String("");
String new_db_number = new String("");



File file_open_0 = new File("ALCHEMIST_DBX2.CSV");
File file_open_1 = new File("ALCHEMIST_DBX.CSV");

int current_submit_item_xx = -1;

JTextField local_url = new JTextField("", 23);
JTextField sql_url = new JTextField("", 30);
JTextField sql_user = new JTextField("", 15);
JTextField sql_pass = new JTextField("", 14);
JTextField sql_db = new JTextField("", 30);

JComboBox jdb_db; 

String jdb_db_options[] = new String[1];

JButton save_b = new JButton("Save");
JButton test_b = new JButton("Test");

JButton load_a = new JButton("Load");
JButton save_a = new JButton("Save");
JButton delete_a = new JButton("Delete");


Icon imx4;



JEditorPane ed1;

Dimension dimx;











alchemy_view(){//********************************************************************************************

	super("Template Viewer");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){nm.firex = 1; running = 0;}});


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));



	//set up html
	if(nm.html_view_number == 3){

		cx0 = nm.carbon[5][nm.template_xx][nm.current_submit_item_a];

			for (int loop3 = 0; loop3 < nm.db_string.length; loop3++){//****************************
				cx0 = cx0.replace("[[" + nm.db_string[loop3] + "]]", nm.carbon[0][loop3][nm.what_item]);
			}//for**********************************************************************************

		cx0 = cx0.replace("[[url]]",nm.carbon[5][3][nm.current_submit_item_a]);
		System.out.println(cx0);

	}//**************************
	else if(nm.html_view_number == 2){

		cx0 = nm.carbon[5][nm.template_xx][nm.current_submit_item_a];

	}//**************************
	else if(nm.html_view_number == 1){

		cx0 = nm.carbon[5][nm.item_description_xx][nm.current_submit_item_a];

	}//**************************
	else{}






    ed1 = new JEditorPane();
	ed1.setText("Loading...");
	ed1.setEditable(false);
	dimx = ed1.getPreferredSize();
	System.out.println(dimx.height);
    ed1.setPreferredSize(new Dimension(xzx - 10, dimx.height + 50));


	FlowLayout flow = new FlowLayout(0);

	flow.setHgap(0);
	flow.setVgap(0);


	JPanel jpx = new JPanel(flow);
	JScrollPane scrollPane = new JScrollPane(jpx);
	scrollPane.setPreferredSize(new Dimension(xzx -6, xzy -28));
	//scrollPane.setBackground(bluex2);
	scrollPane.setFont(new Font("Arial", Font.PLAIN, 14));


	//jpx.setLayout(new FlowLayout());
	jpx.setPreferredSize(new Dimension(xzx - 20, dimx.height + 20));
	jpx.setBackground(whitex);
	jpx.setForeground(whitex);
	jpx.add(ed1);


	Container cpx = getContentPane();
	cpx.setLayout(flow);
	cpx.setBackground(whitex);
	cpx.setForeground(whitex);
	cpx.add(scrollPane);
	//cpx.add(ed1);


	setVisible(true);



	System.out.println("xx1");

    ed1 = new JEditorPane("text/html", cx0);
	ed1.setEditable(false);
	dimx = ed1.getPreferredSize();
	System.out.println(dimx.height);
    ed1.setPreferredSize(new Dimension(xzx - 10, dimx.height + 20));

	jpx.setPreferredSize(new Dimension(xzx - 20, dimx.height + 20));
	scrollPane.setPreferredSize(new Dimension(xzx -6, xzy -28));

	jpx.removeAll();
	jpx.add(ed1);
	System.out.println("xx2");


	if(dimx.height < 10){ed1.setText("Error loading template. There are errors in the template or description which will prevent this simple viewer from displaying HTML.");}


}//mySQL_test











//handel all the button clicks. 
public void actionPerformed(ActionEvent event){







}//actionPerformed	










    public void pullThePlug() {

	    System.out.println("PULL THE PLUG");
	    
	    nm.firex = 1;


	    WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
	    Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

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










}//last


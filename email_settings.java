import java.io.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class email_settings extends JFrame{


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 310;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


JLabel infoxs = new JLabel("", JLabel.LEFT);
JLabel infoxq = new JLabel("", JLabel.LEFT);
JLabel infox0 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox1 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox2 = new JLabel("Submitting items to site.", JLabel.LEFT);
JLabel infox3 = new JLabel("Loading...", JLabel.LEFT);
JLabel infox4 = new JLabel("Loading...", JLabel.LEFT);
Label infox5 = new Label("Loading...", Label.LEFT);

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

int order_min_int = 0;
int order_max_int = 0;


Color blackx = new Color(0.0f, 0.0f, 0.0f);
Color whitex = new Color(1.0f, 1.0f, 1.0f);


String cx0 = new String("");
String cx1 = new String("");
String cx2 = new String("");

File st1;

JTextField info_address = new JTextField("https://blockchain.info", 13);
JTextField info_id = new JTextField("balance", 13);
JTextField info_user = new JTextField("", 13);
JTextField info_pass = new JTextField("", 13);

JComboBox jdb_db; 

JLabel order_spacer = new JLabel("", JLabel.LEFT);

JLabel order_min_l = new JLabel("Order Min", JLabel.LEFT);
JLabel order_max_l = new JLabel("Order Max", JLabel.LEFT);
JComboBox order_min; 
JComboBox order_max; 

JButton save_b = new JButton("Save");
JButton test_b = new JButton("Test");

JButton load_a = new JButton("Load");
JButton save_a = new JButton("Save");
JButton delete_a = new JButton("Delete");


Icon imx4;







email_settings(){//********************************************************************************************

	super("eMail Settings");
	setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
	setBackground(Color.black);
	setSize(xzx, xzy);
	setLocation(cenx, ceny);
	setResizable(false);
    addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){nm.firex = 1; savex();}});


//load images from JAR
	Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
	setIconImage(ximagex);

	imx4 = new ImageIcon(this.getClass().getResource("images/buttonimage4.png"));




	infoxs.setPreferredSize(new Dimension(290, 50));
	infoxs.setText("DotData.com shipping settings");
	infoxs.setForeground(blackx);


	infox0.setPreferredSize(new Dimension(100, 20));
	infox0.setText("URL");
	infox0.setForeground(blackx);

	infox1.setPreferredSize(new Dimension(100, 25));
	infox1.setText("API");
	infox1.setForeground(blackx);

	infox2.setPreferredSize(new Dimension(100, 25));
	infox2.setText("ID");
	infox2.setForeground(blackx);

	infox3.setPreferredSize(new Dimension(100, 25));
	infox3.setText("Password");
	infox3.setForeground(blackx);



 





	JPanel jpx0 = new JPanel();
	jpx0.setPreferredSize(new Dimension(340, 300));
	jpx0.setLayout(new FlowLayout());
	jpx0.setBackground(nm.program_gray_1);
	jpx0.setForeground(whitex);

	jpx0.add(infoxs);
	jpx0.add(infox0);	jpx0.add(info_address);
	jpx0.add(infox1);	jpx0.add(info_id);
	jpx0.add(infox2);	jpx0.add(info_user);
	jpx0.add(infox3);	jpx0.add(info_pass);





	Container cpx = getContentPane();
	cpx.setLayout(new FlowLayout());
	cpx.setBackground(nm.program_gray_2);
	cpx.setForeground(whitex);
	cpx.add(jpx0);

	setVisible(true);



	loadx();


}//mySQL_test












	public void savex(){


		System.out.println("Save");


	}//*****************





	public void loadx(){


		System.out.println("Load");


	}//*****************







    public static void main(String[] args) {

    	blockchain_settings go = new blockchain_settings();

    }//main












}//last


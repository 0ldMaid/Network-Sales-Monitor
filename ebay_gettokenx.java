//import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.text.*;  
//import java.lang.Object.*;  
import java.net.*;
//import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.Frame;
//import java.awt.event.ActionEvent;
//import java.net.URLEncoder;
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextField;
//import javax.swing.JTextPane;
import com.ebay.sdk.ApiAccount;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.call.FetchTokenCall;
import com.ebay.sdk.call.GetSessionIDCall;
import com.ebay.sdk.helper.Utils;
//import org.w3c.dom.Document;
//import org.w3c.dom.Node;
//import com.ebay.sdk.util.XmlUtil;
//import com.ebay.sdk.ApiAccount;
//import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
//import com.ebay.sdk.CallRetry;
//import com.ebay.sdk.helper.ui.DialogAccount;
//import com.ebay.sdk.helper.ui.GuiUtil;
//import com.ebay.soap.eBLBaseComponents.ItemType;
//import com.ebay.soap.eBLBaseComponents.SiteCodeType;
import com.ebay.sdk.util.SdkProxySelector;
//import java.awt.Desktop;








public class ebay_gettokenx extends JFrame implements ActionListener{


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 470;
int xzy = 400;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);

int what_item_here = 0;

//static final String CONFIG_XML_NAME = "Config.xml";

private String generatedToken = null;
private boolean closeOnToken = false;
private boolean cancelled = true;

JPanel panel1 = new JPanel();
JPanel jPanel1 = new JPanel();
JPanel jPanel2 = new JPanel();
JPanel jPanel3 = new JPanel();

JLabel sLabel1 = new JLabel();
JLabel sLabel2 = new JLabel();
JLabel sLabel3 = new JLabel();
JLabel sLabel4 = new JLabel();

JButton btnGetSessionID = new JButton();
JButton btnFetchToken = new JButton();
JButton btnLaunchWebBrowser = new JButton();

JTextField txtSessionID = new JTextField();
JScrollPane jScrollPane1 = new JScrollPane();

JTextPane txtToken = new JTextPane();

JPanel jPanelSecret = new JPanel();
JPanel jPanel5 = new JPanel();
JPanel jPanel6 = new JPanel();

JPanel jPanel7 = new JPanel();
JLabel jLabel2 = new JLabel();
JPanel jPanelRuName = new JPanel();
JPanel jPanel9 = new JPanel();
JPanel jPanel4 = new JPanel();
JPanel jPanel10 = new JPanel();
JPanel jPanel11 = new JPanel();
JLabel jLabel3 = new JLabel();
JLabel jLabel1 = new JLabel();
JLabel jLabel4 = new JLabel();
JPanel jPanel12 = new JPanel();
JLabel jLabel10 = new JLabel();

JTextField ruNameField = new JTextField("Alchemist_Devel-Alchemis-5458-4-opowmx");

JPanel jPanel13 = new JPanel();
JLabel jLabel5 = new JLabel();
JPanel jPanel14 = new JPanel();
JPanel jPanel15 = new JPanel();
JLabel jLabel6 = new JLabel();


public void setCloseOnToken(boolean closeOnToken) {
    this.closeOnToken = closeOnToken;
}
  
public String getGeneratedToken() {
    return generatedToken;
}

public boolean isCloseOnToken() {
    return closeOnToken;
}

public boolean isCancelled() {
    return cancelled;
}




private ApiContext apiContext = new ApiContext();




ebay_gettokenx(int what_item) {//****************************************************************************

    super("Get eBay Token");
    setDefaultCloseOperation(DISPOSE_ON_CLOSE); 
    setSize(xzx, xzy);
    setLocation(cenx, ceny);
    setResizable(false);

    Image ximagex = new ImageIcon(this.getClass().getResource("images/gold.png")).getImage();
    setIconImage(ximagex);


    ruNameField.setEditable(false); 

    what_item_here = what_item;

    try {

        loadConfiguration();

        jbInit();

        this.apiContext = apiContext;

        String signInUrl = this.apiContext.getSignInUrl();
 
    } catch(Exception ex) {ex.printStackTrace();}


	setVisible(true);


}//**************************************************************************************




    private void jbInit() throws Exception {

        panel1.setLayout(new BorderLayout());
        jPanelSecret.setLayout(new BorderLayout());
        jPanel3.setLayout(new BorderLayout());
        jPanel1.setLayout(new BorderLayout());
        jPanel2.setLayout(new BorderLayout());
        jPanel6.setLayout(new BorderLayout());
        jPanel4.setLayout(new BorderLayout());
        jPanel13.setLayout(new BorderLayout());
        jPanel9.setLayout(new BorderLayout());
        jPanel14.setLayout(new BorderLayout());
        jPanelRuName.setLayout(new BorderLayout());

        jPanel3.setBorder(BorderFactory.createEtchedBorder());


        sLabel1.setPreferredSize(new Dimension(168, 21));
        sLabel2.setPreferredSize(new Dimension(16, 21));
        sLabel3.setPreferredSize(new Dimension(170, 21));
        sLabel4.setPreferredSize(new Dimension(170, 21));


        txtSessionID.setPreferredSize(new Dimension(160, 21));
        txtSessionID.setEditable(false);
        txtSessionID.setText("");

        txtToken.setEditable(false);
        txtToken.setText("");

        jLabel4.setText("  1) Please input your RuName here.");

        jLabel3.setText("  2) Retrieve a Session ID.");
        
        jLabel6.setText("  3) Launch browser with your secret and sign-in to generate the token online.");

        jLabel5.setText("  4) Click FetchToken API to retrieve the generated token text.");
        

        jLabel1.setText("Session ID:");


        jLabel2.setText("API Token");
        jLabel2.setPreferredSize(new Dimension(60, 21));
        jScrollPane1.setPreferredSize(new Dimension(400, 100));

        jLabel10.setText("RuName :");
        jLabel10.setPreferredSize(new Dimension(60, 21));
        ruNameField.setPreferredSize(new Dimension(160, 21));



        btnGetSessionID.setText("GetSessionID");
        btnGetSessionID.setBackground(nm.jgray);
        btnGetSessionID.setPreferredSize(new Dimension(150, 21));
        btnGetSessionID.addActionListener(this);

        btnLaunchWebBrowser.setText("Launch Web Browser");
        btnLaunchWebBrowser.setBackground(nm.jgray);
        btnLaunchWebBrowser.setPreferredSize(new Dimension(160, 21));
        btnLaunchWebBrowser.addActionListener(this);

        btnFetchToken.setText("FetchToken");
        btnFetchToken.setBackground(nm.jgray);
        btnFetchToken.setPreferredSize(new Dimension(160, 21));
        btnFetchToken.addActionListener(this);



        getContentPane().add(panel1);


        jPanel12.add(jLabel10);
        jPanel12.add(ruNameField);
        jPanel12.add(sLabel1);
        
        jPanel11.add(jLabel1, null);
        jPanel11.add(txtSessionID, null);
        jPanel11.add(btnGetSessionID, null);
        jPanel11.add(sLabel2, null);
        
        jPanel15.add(btnLaunchWebBrowser, null);
        jPanel15.add(sLabel3, null);

        jPanel5.add(btnFetchToken, null);
        jPanel5.add(sLabel4, null);

        jPanel7.add(jLabel2, null);


        panel1.add(jPanel1,  BorderLayout.NORTH);
        jPanel1.add(jPanelSecret,  BorderLayout.CENTER);
        jPanelSecret.add(jPanel6,  BorderLayout.NORTH);
        jPanel1.add(jPanelRuName,  BorderLayout.NORTH);
        jPanel1.add(jPanel9, BorderLayout.SOUTH);
        jPanel9.add(jPanel14,  BorderLayout.NORTH);
        jPanel14.add(jLabel6, BorderLayout.WEST);
        jPanel9.add(jPanel15, BorderLayout.CENTER);

        panel1.add(jPanel2,  BorderLayout.CENTER);
        jPanel2.add(jPanel5, BorderLayout.CENTER);
        jPanel2.add(jPanel13, BorderLayout.NORTH);
        jPanel13.add(jLabel5, BorderLayout.WEST);
        panel1.add(jPanel3, BorderLayout.SOUTH);
        jPanel3.add(jScrollPane1,  BorderLayout.CENTER);
        jPanel3.add(jPanel7, BorderLayout.NORTH);


        jScrollPane1.getViewport().add(txtToken, null);
        jPanelRuName.add(jPanel4,  BorderLayout.NORTH);
        jPanelRuName.add(jPanel10, BorderLayout.SOUTH);
        jPanelRuName.add(jPanel12, BorderLayout.CENTER);
        jPanelSecret.add(jPanel11, BorderLayout.CENTER);

        jPanel6.add(jLabel3, BorderLayout.CENTER);

        jPanel4.add(jLabel4, BorderLayout.CENTER);

    }

  
    private boolean validateApiAccount() {

	   ApiAccount acc = this.apiContext.getApiCredential().getApiAccount();

	   if (acc == null) {return false;}
	   if (acc.getDeveloper().length() == 0)   {return false;}
	   if (acc.getApplication().length() == 0) {return false;}
	   if (acc.getCertificate().length() == 0) {return false;}
	   return true;

    }//***********************************













    public void loadConfiguration() throws Exception{

        //ix0 = Integer.parseInt(nm.carbon[1][6][nm.what_item]);
        this.apiContext.setApiServerUrl(nm.carbon[5][1][what_item_here]);


        if (nm.carbon[5][1][what_item_here].equals("https://api.ebay.com/wsapi")) {

            this.apiContext.setEpsServerUrl("https://api.ebay.com/ws/api.dll");
            this.apiContext.setSignInUrl("https://signin.ebay.com/ws/eBayISAPI.dll?SignIn"); 

        }//if
        else if (nm.carbon[5][1][what_item_here].equals("https://api.ebay.co.uk/wsapi")) {

            this.apiContext.setEpsServerUrl("https://api.ebay.co.uk/ws/api.dll");
            this.apiContext.setSignInUrl("https://signin.ebay.co.uk/ws/eBayISAPI.dll?SignIn"); 

        }//if
        else {

            this.apiContext.setEpsServerUrl("https://api.sandbox.ebay.com/ws/api.dll");
            this.apiContext.setSignInUrl("https://signin.sandbox.ebay.com/ws/eBayISAPI.dll?SignIn"); 

        }//else




        ApiCredential apiCred = new ApiCredential();
        this.apiContext.setApiCredential(apiCred);

        ApiAccount ac = new ApiAccount();
        apiCred.setApiAccount(ac);


        ac.setDeveloper("a2e5bb52-b43d-4fad-8db9-2ea2c8c65c06");
        ac.setApplication("Alchemis-5458-4dac-ab21-a6ab7bfc1422");
        ac.setCertificate("785bafce-f33e-4381-8ef3-e26c2a9d2f72");


        //ix0 = Integer.parseInt(nm.carbon[1][6][nm.what_item]);
        //apiCred.seteBayToken(nm.carbon[5][2][ix0]);  
    

        this.apiContext.setRuName("Alchemist_Devel-Alchemis-5458-4-opowmx");

    

	    String host = "";//XmlUtil.getChildString(proxy, "Host");
	    String port = "";//XmlUtil.getChildString(proxy, "Port");
	    if (host.length() > 0 && port.length() > 0) {

	    	SdkProxySelector ps = null;
	    	String username = "";//XmlUtil.getChildString(proxy, "Username");
	    	String password = "";//XmlUtil.getChildString(proxy, "Password");
	    	if (username.length() > 0 && password.length() > 0) {ps = new SdkProxySelector(host, Integer.parseInt(port), username, password);} 
		    else {ps = new SdkProxySelector(host, Integer.parseInt(port));}

	    	ps.register();

	    }//******************************************
    
    
    }//************************************************************










    void btnFetchToken_actionPerformed() {

        try {

            FetchTokenCall api = new FetchTokenCall(this.apiContext);

            String s = this.txtSessionID.getText();
            if (s.length() == 0) {throw new SdkException("Please get SessionID first.");}
      
            api.setSessionID(s);

            this.generatedToken = api.fetchToken();

            this.txtToken.setText(this.generatedToken);

            nm.ebay_tx = this.generatedToken;
            System.out.println(nm.ebay_tx);

            if (this.closeOnToken) {

                System.out.println("The API token has been generated successfully!");
                this.cancelled = false;
                this.dispose();

            }//*********************
    
        } catch(Exception ex) {

            String msg = ex.getClass().getName() + " : " + ex.getMessage();
            //System.out.println(this, msg);

        }//******************

    }








    void getSessionID() {

        try {
    	  
      	    if (!validateApiAccount()) {

    		    throw new SdkException("Please fill in Api Account first.");

    	    }//***********************
    	  
		    GetSessionIDCall api = new GetSessionIDCall(this.apiContext);
		  
		    String runame = this.getRuName();
	        if( runame == null || runame.length() == 0 ){throw new Exception("Please select a RuName.");}
	      
	        api.setRuName(runame);
	      
	        String s = api.getSessionID();
	      
	        this.txtSessionID.setText(s);
      
	    }
	    catch (Exception ex) {

		    ex.printStackTrace();
		    //System.out.println(this, ex.getMessage());

	    }//*****************

    }





    private String getRuName() {

	    String ruName = ruNameField.getText();

	    if (ruName.length() == 0) {
		    return null;
	    }

	    return ruName;

    }//*************************









    void btnGetSessionID_xx(){this.getSessionID();}


    void btnLaunchWebBrowser_actionPerformed() {

        try {

            String sessionID = this.txtSessionID.getText();
      

            if ( sessionID.length() == 0 ){throw new Exception("Please get SessionID first.");}
      

            sessionID = URLEncoder.encode(sessionID, "UTF-8");
      
            String runame = this.getRuName();
      

            if ( runame == null || runame.length() == 0 ){throw new Exception("Please select a RuName.");}
      

            String signInUrl = this.apiContext.getSignInUrl();

            String url = java.text.MessageFormat.format("{0}&RuName={1}&SessID={2}",new Object[] {signInUrl, runame, sessionID});
      
            System.out.println(url); 

            //BrowserLauncher.openURL(url);

            java.awt.Desktop desktop = java.awt.Desktop.getDesktop();

            java.net.URI uri = new java.net.URI(url);
            desktop.browse(uri);

        } catch (Exception ex) {System.out.println(ex.getMessage());}

    }//**************************************************************************







    public void pullThePlug() {

        nm.ebay_token_window_open = false;

        WindowEvent wev = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(wev);

    }//pull




    public static void main(String[] args, int what_item) {

	   ebay_gettokenx xr = new ebay_gettokenx(what_item);

    }//main




    public void actionPerformed(ActionEvent event) {

        if(event.getSource() == btnGetSessionID){btnGetSessionID_xx();}//not used
        if(event.getSource() == btnLaunchWebBrowser){btnLaunchWebBrowser_actionPerformed();}//
        if(event.getSource() == btnFetchToken){btnFetchToken_actionPerformed(); pullThePlug();}//

    }//********************************************







}//last******************************************









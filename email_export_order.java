import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;










public class email_export_order{



String cx0 = new String();
String cx1 = new String();
String cx2 = new String();
String cx3 = new String();
String cx4 = new String();

int responseCode = 0;
String postx1 = new String("");
String bodyx = new String("");

int ix0 = 0;
int ix1 = 0;
int ix2 = 0;
int ix3 = 0;
int ix4 = 0;
int ix5 = 0; 
int ix6 = 0; 
int fg = 0;
int fs = 0;
int kcountxx = 0;
int thisx = 0;
int loopc1 = 0;
int thisc2 = 0;//the second carbonfiber array.
int working = 0; 
int item_xxx = 0;











	email_export_order(){//********************************************************************************************************
	
    	System.out.println("");
    	System.out.println("Send eMail Start");




    	send_mail();



    	//all done
    	pullThePlug();

	}//pro_tools*******************************************************************************************************************













	public void send_mail(){


	    String messageb = "Alchemist Shipping Order\n\r";
	    messageb += nm.carbon[2][nm.quantity_sold_xx][nm.what_item] + " Unit(s) " + "Part Number: " + nm.carbon[2][nm.part_number_xx][nm.what_item] + "\n\r";
	    messageb += "\n\r\n\r";
	    messageb += "Send to: ";
	    messageb += nm.carbon[2][nm.buyers_first_name_xx][nm.what_item] + " " + nm.carbon[2][nm.buyers_last_name_xx][nm.what_item] + "\n\r";
	    messageb += nm.carbon[2][nm.address_1_xx][nm.what_item] + "\n\r";
	    messageb += nm.carbon[2][nm.address_2_xx][nm.what_item] + " " + nm.carbon[2][nm.address_3_xx][nm.what_item] + " " + nm.carbon[2][nm.address_4_xx][nm.what_item] + "\n\r";
	    messageb += nm.carbon[2][nm.address_5_xx][nm.what_item] + "\n\r";




	    final String username = "combonationinc@gmail.com";
        final String password = "Strange2010!";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(username, password);

            }

        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("combonationinc@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("combonationinc@gmail.com"));
            message.setSubject("Alchemist Shipping ORDER");
            message.setText(messageb);

            Transport.send(message);

            System.out.println("Done");


	        nm.carbon[2][nm.sale_status_xx][nm.what_item] = "Ready to Ship";


	        System.out.println("SENT!");


        }catch(MessagingException e) {

            throw new RuntimeException(e);

        }//***************************


	    System.out.println("SENT!");
        

	}//*********************
















    public void pullThePlug() {

        System.out.println("PULL THE PLUG");
        nm.firex = 1;

    }//pull********************





}//last
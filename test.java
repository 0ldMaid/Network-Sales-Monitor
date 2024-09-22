import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.imageio.ImageIO;
import javax.imageio.*;
import java.awt.image.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;







public class test{


Timer xtimerx;//class loop.
Toolkit toolkit;

String command = new String();



test(String[] argsx){//*****************************************************************


	//command = argsx[0];
	request_status();



}//**************************************************************************************************









public void request_status(){//*****************************************************************

	String jsonText = new String("");


	try{

		JSONObject obj = new JSONObject();
		obj.put("request", "get_database_fields");
		obj.put("sale_id", "01000000021");
		obj.put("tracking_number", "EE123456789XXX");

		StringWriter out = new StringWriter();
		obj.writeJSONString(out);
		jsonText = out.toString();
		System.out.println(jsonText);

	}catch(Exception e){System.out.println("JSON ERROR");}




	try{

		String sentence;   
		String modifiedSentence;   

		BufferedReader inFromUser = new BufferedReader( new InputStreamReader(System.in) );
		System.out.println(">>> " + "localhost" + " " + "7779");
		Socket clientSocket = new Socket("127.0.0.1", 7779);   
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));    
		sentence = jsonText;  
		outToServer.writeBytes(sentence + '\n');   
		modifiedSentence = inFromServer.readLine();   
		System.out.println("FROM SERVER: " + modifiedSentence);
		clientSocket.close();

	}catch(Exception e){e.printStackTrace(); System.out.println("API SERVER OFFLINE!");}

}//*********************************************************************************************






//start the program.
    public static void main(String[] args) {

		test api = new test(args);

    }//main




}//last

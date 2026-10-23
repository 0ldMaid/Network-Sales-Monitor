import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONValue;





public class jdb_saver_settings {


/* the default framework is embedded*/
private String framework = "embedded";
private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
private String protocol = "jdbc:derby:";


Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
int xzx = 350;
int xzy = 143;
int cenx = (scrSize.width / 2) - (xzx / 2);
int ceny = (scrSize.height / 2) - (xzy / 2);


jdb_saver_settings(){//*****************************************************


	save_settings();

    save_display_settings();


}//*************************************************************************







	public void save_settings() {


        try {



            String settings_jsonx = new String("");

            JSONObject obj = new JSONObject();

            for (int loop = 0; loop < nm.db_ss_number; loop++){//*************

                obj.put(Integer.toString(loop), nm.carbon[4][0][loop]);

            }//***************************************************************

            StringWriter out = new StringWriter();
            obj.writeJSONString(out);
            settings_jsonx = out.toString();
            //System.out.println(settings_jsonx);


            jdb_driver.s.execute("UPDATE settings SET settings_json='" + settings_jsonx + "' WHERE xd=1");


            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



        } catch (Exception e) {e.printStackTrace();}




	}//****************************







    public void save_display_settings() {


        try {



            String settings_jsonx = new String("");

            JSONObject obj = new JSONObject();
            
            for (int loop = 0; loop < nm.db_dd_number; loop++){//*************

                obj.put("w" + Integer.toString(loop), nm.carbon[6][0][loop]);
                obj.put("x" + Integer.toString(loop), nm.carbon[6][1][loop]);
                obj.put("y" + Integer.toString(loop), nm.carbon[6][2][loop]);
                obj.put("z" + Integer.toString(loop), nm.carbon[6][3][loop]);

            }//***************************************************************

            StringWriter out = new StringWriter();
            obj.writeJSONString(out);
            settings_jsonx = out.toString();
            //System.out.println(settings_jsonx);


            //display settings
            jdb_driver.s.execute("UPDATE settings_display SET settings_json='" + settings_jsonx + "' WHERE xd=1");



            jdb_driver.conn.commit();
            System.out.println("Committed the transaction");



        } catch (Exception e) {e.printStackTrace();}




    }//*****************************





}//last****************************

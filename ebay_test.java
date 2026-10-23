import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.text.*;  
//import java.lang.Object.*;  
//import java.net.*;
//import java.awt.Toolkit;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Frame;
//import java.awt.event.ActionEvent;
//import javax.swing.BorderFactory;
//import javax.swing.JButton;
//import javax.swing.JDialog;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//import javax.swing.table.AbstractTableModel;
//import javax.swing.table.TableModel;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetApiAccessRulesCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.soap.eBLBaseComponents.ApiAccessRuleType;
import com.ebay.soap.eBLBaseComponents.MyMessagesFolderType;
import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiCredential;
import com.ebay.sdk.helper.ConsoleUtil;
import com.ebay.sdk.call.GeteBayOfficialTimeCall;
//import java.io.IOException;
//import java.util.Calendar;




public class ebay_test {//************************************************************************




      public String test(int what_item) {


            String pass_com = "0";


            try {


                  ApiContext apiContext = new ApiContext();
                  ApiCredential cred = apiContext.getApiCredential();

                  cred.seteBayToken(nm.carbon[5][2][what_item]);

                  apiContext.setApiServerUrl(nm.carbon[5][1][what_item]);


                  //ApiContext apiContext = getApiContext();

                  GetApiAccessRulesCall api = new GetApiAccessRulesCall(apiContext);

                  api.getApiAccessRules();

                  ApiAccessRuleType[] rules = api.getReturnedApiAccessRules();

                  ApiAccessRuleType rule = rules[0];

                  String[] cols = new String[8];

                  int i = 0;
                  cols[i++] = rule.getCallName();
                  cols[i++] = rule.getHourlySoftLimit() == null ? "" : rule.getHourlySoftLimit().toString();
                  cols[i++] = rule.getHourlyHardLimit() == null ? "" : rule.getHourlyHardLimit().toString();
                  cols[i++] = rule.getHourlyUsage() == null ? "" : rule.getHourlyUsage().toString();
                  cols[i++] = rule.getDailySoftLimit() == null ? "" : rule.getDailySoftLimit().toString();
                  cols[i++] = rule.getDailyHardLimit() == null ? "" : rule.getDailyHardLimit().toString();
                  cols[i++] = rule.getDailyUsage() == null ? "" : rule.getDailyUsage().toString();
                  cols[i++] = Utils.booleanToYesNo(rule.isCountsTowardAggregate());


                  System.out.println(cols[0]); 
                  System.out.println(cols[1]); 
                  System.out.println(cols[2]); 
                  System.out.println(cols[3]); 


                  pass_com = "1";

            } catch (Exception e) {e.printStackTrace(); pass_com = "0";}

            return pass_com;

      }//ebaytest







}//last****************************************
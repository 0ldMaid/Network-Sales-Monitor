import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;  
import java.lang.Object.*;  
import java.net.*;
import java.awt.Toolkit;





public class alchemy_rebuild_db extends JFrame {//************************************************************************



	alchemy_rebuild_db(){

		System.out.println("REBUILD DATABASE");

		nm.carbon = new String[7][nm.db_cc_number][1];

		for(int xloop1 = 0; xloop1 < 7; xloop1++){//************************

			nm.carbon[xloop1][0] [0] = new String("address_1");
			nm.carbon[xloop1][1] [0] = new String("address_2");
			nm.carbon[xloop1][2] [0] = new String("address_3");
			nm.carbon[xloop1][3] [0] = new String("address_4");
			nm.carbon[xloop1][4] [0] = new String("address_5");
			nm.carbon[xloop1][5] [0] = new String("address_6");
			nm.carbon[xloop1][6] [0] = new String("buyer_id");
			nm.carbon[xloop1][7] [0] = new String("buyers_email");
			nm.carbon[xloop1][8] [0] = new String("buyers_first_name");
			nm.carbon[xloop1][9] [0] = new String("buyers_last_name");
			nm.carbon[xloop1][10][0] = new String("buyers_notes");
			nm.carbon[xloop1][11][0] = new String("buyers_phone");
			nm.carbon[xloop1][12][0] = new String("currency");
			nm.carbon[xloop1][13][0] = new String("custom_1");
			nm.carbon[xloop1][14][0] = new String("custom_2");
			nm.carbon[xloop1][15][0] = new String("custom_3");
			nm.carbon[xloop1][16][0] = new String("custom_4");
			nm.carbon[xloop1][17][0] = new String("custom_5");
			nm.carbon[xloop1][18][0] = new String("custom_6");
			nm.carbon[xloop1][19][0] = new String("custom_7");
			nm.carbon[xloop1][20][0] = new String("custom_8");
			nm.carbon[xloop1][21][0] = new String("custom_9");
			nm.carbon[xloop1][22][0] = new String("custom_10");
			nm.carbon[xloop1][23][0] = new String("custom_11");
			nm.carbon[xloop1][24][0] = new String("custom_12");
			nm.carbon[xloop1][25][0] = new String("custom_13");
			nm.carbon[xloop1][26][0] = new String("custom_14");
			nm.carbon[xloop1][27][0] = new String("custom_15");
			nm.carbon[xloop1][28][0] = new String("custom_16");
			nm.carbon[xloop1][29][0] = new String("custom_17");
			nm.carbon[xloop1][30][0] = new String("custom_18");
			nm.carbon[xloop1][31][0] = new String("custom_19");
			nm.carbon[xloop1][32][0] = new String("custom_20");
			nm.carbon[xloop1][33][0] = new String("custom_21");
			nm.carbon[xloop1][34][0] = new String("custom_22");
			nm.carbon[xloop1][35][0] = new String("custom_23");
			nm.carbon[xloop1][36][0] = new String("custom_24");
			nm.carbon[xloop1][37][0] = new String("custom_25");
			nm.carbon[xloop1][38][0] = new String("custom_26");
			nm.carbon[xloop1][39][0] = new String("custom_27");
			nm.carbon[xloop1][40][0] = new String("custom_28");
			nm.carbon[xloop1][41][0] = new String("custom_29");
			nm.carbon[xloop1][42][0] = new String("custom_30");
			nm.carbon[xloop1][43][0] = new String("custom_31");
			nm.carbon[xloop1][44][0] = new String("custom_32");
			nm.carbon[xloop1][45][0] = new String("custom_33");
			nm.carbon[xloop1][46][0] = new String("custom_34");
			nm.carbon[xloop1][47][0] = new String("custom_35");
			nm.carbon[xloop1][48][0] = new String("custom_36");
			nm.carbon[xloop1][49][0] = new String("custom_37");
			nm.carbon[xloop1][50][0] = new String("custom_38");
			nm.carbon[xloop1][51][0] = new String("custom_39");
			nm.carbon[xloop1][52][0] = new String("custom_40");
			nm.carbon[xloop1][53][0] = new String("custom_41");
			nm.carbon[xloop1][54][0] = new String("custom_42");
			nm.carbon[xloop1][55][0] = new String("custom_43");
			nm.carbon[xloop1][56][0] = new String("custom_44");
			nm.carbon[xloop1][57][0] = new String("custom_45");
			nm.carbon[xloop1][58][0] = new String("custom_46");
			nm.carbon[xloop1][59][0] = new String("custom_template");
			nm.carbon[xloop1][60][0] = new String("date_last_modified");
			nm.carbon[xloop1][61][0] = new String("date_payment_received");
			nm.carbon[xloop1][62][0] = new String("date_shipped");
			nm.carbon[xloop1][63][0] = new String("date_sold");
			nm.carbon[xloop1][64][0] = new String("ebay_item");
			nm.carbon[xloop1][65][0] = new String("final_value_fee");
			nm.carbon[xloop1][66][0] = new String("handling");
			nm.carbon[xloop1][67][0] = new String("hits");
			nm.carbon[xloop1][68][0] = new String("item_cost");
			nm.carbon[xloop1][69][0] = new String("item_description");
			nm.carbon[xloop1][70][0] = new String("item_id");
			nm.carbon[xloop1][71][0] = new String("item_price");
			nm.carbon[xloop1][72][0] = new String("item_weight");
			nm.carbon[xloop1][73][0] = new String("listing_fees");
			nm.carbon[xloop1][74][0] = new String("listing_id");
			nm.carbon[xloop1][75][0] = new String("notes");
			nm.carbon[xloop1][76][0] = new String("package_d");
			nm.carbon[xloop1][77][0] = new String("package_l");
			nm.carbon[xloop1][78][0] = new String("package_w");
			nm.carbon[xloop1][79][0] = new String("part_number");
			nm.carbon[xloop1][80][0] = new String("payment_type");
			nm.carbon[xloop1][81][0] = new String("paypal_fees");
			nm.carbon[xloop1][82][0] = new String("picture_1");
			nm.carbon[xloop1][83][0] = new String("quantity_sold");
			nm.carbon[xloop1][84][0] = new String("sale_id");
			nm.carbon[xloop1][85][0] = new String("sale_status");
			nm.carbon[xloop1][86][0] = new String("sales_tax");
			nm.carbon[xloop1][87][0] = new String("shipping_company");
			nm.carbon[xloop1][88][0] = new String("shipping_in");
			nm.carbon[xloop1][89][0] = new String("shipping_out");
			nm.carbon[xloop1][90][0] = new String("site_id");
			nm.carbon[xloop1][91][0] = new String("site_url");
			nm.carbon[xloop1][92][0] = new String("source_of_sale");
			nm.carbon[xloop1][93][0] = new String("title");
			nm.carbon[xloop1][94][0] = new String("title_url");
			nm.carbon[xloop1][95][0] = new String("total_on_hand");
			nm.carbon[xloop1][96][0] = new String("total_sale_amount");
			nm.carbon[xloop1][97][0] = new String("tracking_number");
			nm.carbon[xloop1][98][0] = new String("transaction_id");
			nm.carbon[xloop1][99][0] = new String("transaction_info");

		}//for********************************************











		for(int xloop1 = 0; xloop1 < 1; xloop1++){//******

			nm.carbon[4][xloop1] = new String[100];

		}//for********************************************


		nm.carbon[4][0][0] = new String("333");
		nm.carbon[4][0][1] = new String("333");
		nm.carbon[4][0][2] = new String("0");
		nm.carbon[4][0][3] = new String("2");
		nm.carbon[4][0][4] = new String("ALCHEMIST_DBX.CSV");
		nm.carbon[4][0][5] = new String("0");
		nm.carbon[4][0][6] = new String("1");
		nm.carbon[4][0][7] = new String("127.0.0.1");
		nm.carbon[4][0][8] = new String("USER");
		nm.carbon[4][0][9] = new String("PASS");
		nm.carbon[4][0][10] = new String("DB");
		nm.carbon[4][0][11] = new String("0");
		nm.carbon[4][0][12] = new String("0");
		nm.carbon[4][0][13] = new String("create_export");
		nm.carbon[4][0][14] = new String("LLLH8097");
		nm.carbon[4][0][15] = new String("87098798723452345884777");
		nm.carbon[4][0][16] = new String("1");
		nm.carbon[4][0][17] = new String("0");
		nm.carbon[4][0][18] = new String("0");//0 or 1
		nm.carbon[4][0][19] = new String("0");
		nm.carbon[4][0][20] = new String("1");
		nm.carbon[4][0][21] = new String("1");
		nm.carbon[4][0][22] = new String("1");
		nm.carbon[4][0][23] = new String("1");
		nm.carbon[4][0][24] = new String("1000000");
		nm.carbon[4][0][25] = new String("79");
		nm.carbon[4][0][26] = new String("800");
		nm.carbon[4][0][27] = new String("search");
		nm.carbon[4][0][28] = new String("800");
		nm.carbon[4][0][29] = new String("KLJHIU90989798KNM");
		nm.carbon[4][0][30] = new String("800");
		nm.carbon[4][0][31] = new String("800");
		nm.carbon[4][0][32] = new String("800");
		nm.carbon[4][0][33] = new String("800");
		nm.carbon[4][0][34] = new String("800");
		nm.carbon[4][0][35] = new String("800");
		nm.carbon[4][0][36] = new String("0");
		nm.carbon[4][0][37] = new String("18");
		nm.carbon[4][0][38] = new String("42");
		nm.carbon[4][0][39] = new String("43");
		nm.carbon[4][0][40] = new String("http://www.x.com/alchemy_api/");
		nm.carbon[4][0][41] = new String("QQQ");
		nm.carbon[4][0][42] = new String("0");
		nm.carbon[4][0][43] = new String("0");
		nm.carbon[4][0][44] = new String("800");
		nm.carbon[4][0][45] = new String("C:\\program files\\DAZzle\\DAZZLE.EXE");
		nm.carbon[4][0][46] = new String("C:\\program files\\alchemist\\site1\\");
		nm.carbon[4][0][47] = new String("C:\\program files\\alchemist\\site1\\");
		nm.carbon[4][0][48] = new String("C:\\program files\\alchemist\\site1\\");
		nm.carbon[4][0][49] = new String("C:\\program files\\alchemist\\site1\\");
		nm.carbon[4][0][50] = new String("C:\\program files\\alchemist\\site1\\");
		nm.carbon[4][0][51] = new String("pro");
		nm.carbon[4][0][52] = new String("2010");
		nm.carbon[4][0][53] = new String("ftp.pro.com");
		nm.carbon[4][0][54] = new String("C:\\program files\\alchemist\\site1\\");
		nm.carbon[4][0][55] = new String("/alchemy_api/labels/");
		nm.carbon[4][0][56] = new String("800");
		nm.carbon[4][0][57] = new String("!!!");
		nm.carbon[4][0][58] = new String("systemx");
		nm.carbon[4][0][59] = new String("88iuyoi97");
		nm.carbon[4][0][60] = new String("systemx");
		nm.carbon[4][0][61] = new String("88iuyoi97");
		nm.carbon[4][0][62] = new String("800");
		nm.carbon[4][0][63] = new String("800");
		nm.carbon[4][0][64] = new String("800");
		nm.carbon[4][0][65] = new String("800");
		nm.carbon[4][0][66] = new String("800");
		nm.carbon[4][0][67] = new String("800");
		nm.carbon[4][0][68] = new String("800");
		nm.carbon[4][0][69] = new String("800");
		nm.carbon[4][0][70] = new String("800");
		nm.carbon[4][0][71] = new String("800");
		nm.carbon[4][0][72] = new String("800");
		nm.carbon[4][0][73] = new String("800");
		nm.carbon[4][0][74] = new String("800");
		nm.carbon[4][0][75] = new String("800");
		nm.carbon[4][0][76] = new String("800");
		nm.carbon[4][0][77] = new String("800");
		nm.carbon[4][0][78] = new String("800");
		nm.carbon[4][0][79] = new String("800");
		nm.carbon[4][0][80] = new String("800");
		nm.carbon[4][0][81] = new String("800");
		nm.carbon[4][0][82] = new String("800");
		nm.carbon[4][0][83] = new String("800");
		nm.carbon[4][0][84] = new String("800");
		nm.carbon[4][0][85] = new String("800");
		nm.carbon[4][0][86] = new String("800");
		nm.carbon[4][0][87] = new String("800");
		nm.carbon[4][0][88] = new String("800");
		nm.carbon[4][0][89] = new String("800");
		nm.carbon[4][0][90] = new String("800");
		nm.carbon[4][0][91] = new String("800");
		nm.carbon[4][0][92] = new String("800");
		nm.carbon[4][0][93] = new String("800");
		nm.carbon[4][0][94] = new String("800");
		nm.carbon[4][0][95] = new String("800");
		nm.carbon[4][0][96] = new String("800");
		nm.carbon[4][0][97] = new String("800");
		nm.carbon[4][0][98] = new String("800");
		nm.carbon[4][0][99] = new String("800");










		for(int xloop1 = 0; xloop1 < 4; xloop1++){//****

			nm.carbon[6][xloop1] = new String[300];

		}//for******************************************



		for(int xloop1 = 0; xloop1 < 100; xloop1++){//************************

			nm.carbon[6][0][xloop1] = new String("0");
			nm.carbon[6][1][xloop1] = new String("100");
			nm.carbon[6][2][xloop1] = new String("100");
			nm.carbon[6][3][xloop1] = new String("Black");

		}//for****************************************************************


		for(int xloop1 = 100; xloop1 < 200; xloop1++){//**********************

			nm.carbon[6][0][xloop1] = new String("0");
			nm.carbon[6][1][xloop1] = new String("100");
			nm.carbon[6][2][xloop1] = new String("100");
			nm.carbon[6][3][xloop1] = new String("Black");

		}//for****************************************************************


		for(int xloop1 = 200; xloop1 < 300; xloop1++){//**********************

			nm.carbon[6][0][xloop1] = new String("0");
			nm.carbon[6][1][xloop1] = new String("100");
			nm.carbon[6][2][xloop1] = new String("100");
			nm.carbon[6][3][xloop1] = new String("Black");

		}//for****************************************************************








			//build display settings
			nm.carbon[6][0][0] = new String("0");
			nm.carbon[6][0][1] = new String("0");
			nm.carbon[6][0][2] = new String("0");
			nm.carbon[6][0][3] = new String("0");
			nm.carbon[6][0][4] = new String("0");
			nm.carbon[6][0][5] = new String("0");
			nm.carbon[6][0][6] = new String("0");
			nm.carbon[6][0][7] = new String("0");
			nm.carbon[6][0][8] = new String("0");
			nm.carbon[6][0][9] = new String("0");
			nm.carbon[6][0][10] = new String("0");
			nm.carbon[6][0][11] = new String("0");
			nm.carbon[6][0][12] = new String("0");
			nm.carbon[6][0][13] = new String("1");
			nm.carbon[6][0][14] = new String("1");
			nm.carbon[6][0][15] = new String("1");
			nm.carbon[6][0][16] = new String("1");
			nm.carbon[6][0][17] = new String("0");
			nm.carbon[6][0][18] = new String("0");
			nm.carbon[6][0][19] = new String("0");
			nm.carbon[6][0][20] = new String("0");
			nm.carbon[6][0][21] = new String("1");
			nm.carbon[6][0][22] = new String("1");
			nm.carbon[6][0][23] = new String("0");
			nm.carbon[6][0][24] = new String("0");
			nm.carbon[6][0][25] = new String("0");
			nm.carbon[6][0][26] = new String("0");
			nm.carbon[6][0][27] = new String("0");
			nm.carbon[6][0][28] = new String("0");
			nm.carbon[6][0][29] = new String("0");
			nm.carbon[6][0][30] = new String("0");
			nm.carbon[6][0][31] = new String("0");
			nm.carbon[6][0][32] = new String("0");
			nm.carbon[6][0][33] = new String("0");
			nm.carbon[6][0][34] = new String("0");
			nm.carbon[6][0][35] = new String("0");
			nm.carbon[6][0][36] = new String("0");
			nm.carbon[6][0][37] = new String("0");
			nm.carbon[6][0][38] = new String("0");
			nm.carbon[6][0][39] = new String("0");
			nm.carbon[6][0][40] = new String("0");
			nm.carbon[6][0][41] = new String("0");
			nm.carbon[6][0][42] = new String("0");
			nm.carbon[6][0][43] = new String("0");
			nm.carbon[6][0][44] = new String("0");
			nm.carbon[6][0][45] = new String("0");
			nm.carbon[6][0][46] = new String("0");
			nm.carbon[6][0][47] = new String("0");
			nm.carbon[6][0][48] = new String("0");
			nm.carbon[6][0][49] = new String("0");
			nm.carbon[6][0][50] = new String("0");
			nm.carbon[6][0][51] = new String("0");
			nm.carbon[6][0][52] = new String("1");
			nm.carbon[6][0][53] = new String("1");
			nm.carbon[6][0][54] = new String("1");
			nm.carbon[6][0][55] = new String("0");
			nm.carbon[6][0][56] = new String("0");
			nm.carbon[6][0][57] = new String("0");
			nm.carbon[6][0][58] = new String("0");
			nm.carbon[6][0][59] = new String("0");
			nm.carbon[6][0][60] = new String("0");
			nm.carbon[6][0][61] = new String("0");
			nm.carbon[6][0][62] = new String("0");
			nm.carbon[6][0][63] = new String("0");
			nm.carbon[6][0][64] = new String("1");
			nm.carbon[6][0][65] = new String("0");
			nm.carbon[6][0][66] = new String("0");
			nm.carbon[6][0][67] = new String("0");
			nm.carbon[6][0][68] = new String("1");
			nm.carbon[6][0][69] = new String("0");
			nm.carbon[6][0][70] = new String("1");
			nm.carbon[6][0][71] = new String("1");
			nm.carbon[6][0][72] = new String("0");
			nm.carbon[6][0][73] = new String("0");
			nm.carbon[6][0][74] = new String("0");
			nm.carbon[6][0][75] = new String("0");
			nm.carbon[6][0][76] = new String("0");
			nm.carbon[6][0][77] = new String("0");
			nm.carbon[6][0][78] = new String("0");
			nm.carbon[6][0][79] = new String("1");
			nm.carbon[6][0][80] = new String("0");
			nm.carbon[6][0][81] = new String("0");
			nm.carbon[6][0][82] = new String("0");
			nm.carbon[6][0][83] = new String("0");
			nm.carbon[6][0][84] = new String("0");
			nm.carbon[6][0][85] = new String("1");
			nm.carbon[6][0][86] = new String("0");
			nm.carbon[6][0][87] = new String("0");
			nm.carbon[6][0][88] = new String("0");
			nm.carbon[6][0][89] = new String("0");
			nm.carbon[6][0][90] = new String("0");
			nm.carbon[6][0][91] = new String("0");
			nm.carbon[6][0][92] = new String("0");
			nm.carbon[6][0][93] = new String("1");
			nm.carbon[6][0][94] = new String("0");
			nm.carbon[6][0][95] = new String("0");
			nm.carbon[6][0][96] = new String("0");
			nm.carbon[6][0][97] = new String("0");
			nm.carbon[6][0][98] = new String("0");
			nm.carbon[6][0][99] = new String("0");

			nm.carbon[6][0][100] = new String("0");
			nm.carbon[6][0][101] = new String("0");
			nm.carbon[6][0][102] = new String("0");
			nm.carbon[6][0][103] = new String("0");
			nm.carbon[6][0][104] = new String("0");
			nm.carbon[6][0][105] = new String("0");
			nm.carbon[6][0][106] = new String("0");
			nm.carbon[6][0][107] = new String("0");
			nm.carbon[6][0][108] = new String("1");
			nm.carbon[6][0][109] = new String("0");
			nm.carbon[6][0][110] = new String("1");
			nm.carbon[6][0][111] = new String("1");
			nm.carbon[6][0][112] = new String("0");
			nm.carbon[6][0][113] = new String("0");
			nm.carbon[6][0][114] = new String("0");
			nm.carbon[6][0][115] = new String("1");
			nm.carbon[6][0][116] = new String("1");
			nm.carbon[6][0][117] = new String("0");
			nm.carbon[6][0][118] = new String("0");
			nm.carbon[6][0][119] = new String("0");
			nm.carbon[6][0][120] = new String("0");
			nm.carbon[6][0][121] = new String("0");
			nm.carbon[6][0][122] = new String("0");
			nm.carbon[6][0][123] = new String("0");
			nm.carbon[6][0][124] = new String("0");
			nm.carbon[6][0][125] = new String("0");
			nm.carbon[6][0][126] = new String("0");
			nm.carbon[6][0][127] = new String("0");
			nm.carbon[6][0][128] = new String("0");
			nm.carbon[6][0][129] = new String("0");
			nm.carbon[6][0][130] = new String("0");
			nm.carbon[6][0][131] = new String("0");
			nm.carbon[6][0][132] = new String("0");
			nm.carbon[6][0][133] = new String("0");
			nm.carbon[6][0][134] = new String("0");
			nm.carbon[6][0][135] = new String("0");
			nm.carbon[6][0][136] = new String("0");
			nm.carbon[6][0][137] = new String("0");
			nm.carbon[6][0][138] = new String("0");
			nm.carbon[6][0][139] = new String("0");
			nm.carbon[6][0][140] = new String("0");
			nm.carbon[6][0][141] = new String("0");
			nm.carbon[6][0][142] = new String("0");
			nm.carbon[6][0][143] = new String("0");
			nm.carbon[6][0][144] = new String("0");
			nm.carbon[6][0][145] = new String("0");
			nm.carbon[6][0][146] = new String("0");
			nm.carbon[6][0][147] = new String("0");
			nm.carbon[6][0][148] = new String("0");
			nm.carbon[6][0][149] = new String("0");
			nm.carbon[6][0][150] = new String("0");
			nm.carbon[6][0][151] = new String("0");
			nm.carbon[6][0][152] = new String("0");
			nm.carbon[6][0][153] = new String("0");
			nm.carbon[6][0][154] = new String("0");
			nm.carbon[6][0][155] = new String("0");
			nm.carbon[6][0][156] = new String("0");
			nm.carbon[6][0][157] = new String("0");
			nm.carbon[6][0][158] = new String("0");
			nm.carbon[6][0][159] = new String("0");
			nm.carbon[6][0][160] = new String("0");
			nm.carbon[6][0][161] = new String("0");
			nm.carbon[6][0][162] = new String("0");
			nm.carbon[6][0][163] = new String("1");
			nm.carbon[6][0][164] = new String("0");
			nm.carbon[6][0][165] = new String("0");
			nm.carbon[6][0][166] = new String("0");
			nm.carbon[6][0][167] = new String("0");
			nm.carbon[6][0][168] = new String("0");
			nm.carbon[6][0][169] = new String("0");
			nm.carbon[6][0][170] = new String("0");
			nm.carbon[6][0][171] = new String("1");
			nm.carbon[6][0][172] = new String("1");
			nm.carbon[6][0][173] = new String("0");
			nm.carbon[6][0][174] = new String("0");
			nm.carbon[6][0][175] = new String("0");
			nm.carbon[6][0][176] = new String("0");
			nm.carbon[6][0][177] = new String("0");
			nm.carbon[6][0][178] = new String("0");
			nm.carbon[6][0][179] = new String("1");
			nm.carbon[6][0][180] = new String("0");
			nm.carbon[6][0][181] = new String("0");
			nm.carbon[6][0][182] = new String("0");
			nm.carbon[6][0][183] = new String("1");
			nm.carbon[6][0][184] = new String("0");
			nm.carbon[6][0][185] = new String("1");
			nm.carbon[6][0][186] = new String("0");
			nm.carbon[6][0][187] = new String("0");
			nm.carbon[6][0][188] = new String("0");
			nm.carbon[6][0][189] = new String("0");
			nm.carbon[6][0][190] = new String("0");
			nm.carbon[6][0][191] = new String("0");
			nm.carbon[6][0][192] = new String("1");
			nm.carbon[6][0][193] = new String("0");
			nm.carbon[6][0][194] = new String("0");
			nm.carbon[6][0][195] = new String("0");
			nm.carbon[6][0][196] = new String("1");
			nm.carbon[6][0][197] = new String("0");
			nm.carbon[6][0][198] = new String("0");
			nm.carbon[6][0][199] = new String("0");

			nm.carbon[6][0][200] = new String("0");
			nm.carbon[6][0][201] = new String("0");
			nm.carbon[6][0][202] = new String("0");
			nm.carbon[6][0][203] = new String("0");
			nm.carbon[6][0][204] = new String("0");
			nm.carbon[6][0][205] = new String("0");
			nm.carbon[6][0][206] = new String("1");
			nm.carbon[6][0][207] = new String("0");
			nm.carbon[6][0][208] = new String("1");
			nm.carbon[6][0][209] = new String("0");
			nm.carbon[6][0][210] = new String("0");
			nm.carbon[6][0][211] = new String("0");
			nm.carbon[6][0][212] = new String("0");
			nm.carbon[6][0][213] = new String("0");
			nm.carbon[6][0][214] = new String("0");
			nm.carbon[6][0][215] = new String("0");
			nm.carbon[6][0][216] = new String("0");
			nm.carbon[6][0][217] = new String("0");
			nm.carbon[6][0][218] = new String("0");
			nm.carbon[6][0][219] = new String("0");
			nm.carbon[6][0][220] = new String("0");
			nm.carbon[6][0][221] = new String("0");
			nm.carbon[6][0][222] = new String("0");
			nm.carbon[6][0][223] = new String("0");
			nm.carbon[6][0][224] = new String("0");
			nm.carbon[6][0][225] = new String("0");
			nm.carbon[6][0][226] = new String("0");
			nm.carbon[6][0][227] = new String("0");
			nm.carbon[6][0][228] = new String("0");
			nm.carbon[6][0][229] = new String("0");
			nm.carbon[6][0][230] = new String("0");
			nm.carbon[6][0][231] = new String("0");
			nm.carbon[6][0][232] = new String("0");
			nm.carbon[6][0][233] = new String("0");
			nm.carbon[6][0][234] = new String("0");
			nm.carbon[6][0][235] = new String("0");
			nm.carbon[6][0][236] = new String("0");
			nm.carbon[6][0][237] = new String("0");
			nm.carbon[6][0][238] = new String("0");
			nm.carbon[6][0][239] = new String("0");
			nm.carbon[6][0][240] = new String("0");
			nm.carbon[6][0][241] = new String("0");
			nm.carbon[6][0][242] = new String("0");
			nm.carbon[6][0][243] = new String("0");
			nm.carbon[6][0][244] = new String("0");
			nm.carbon[6][0][245] = new String("0");
			nm.carbon[6][0][246] = new String("0");
			nm.carbon[6][0][247] = new String("0");
			nm.carbon[6][0][248] = new String("0");
			nm.carbon[6][0][249] = new String("0");
			nm.carbon[6][0][250] = new String("0");
			nm.carbon[6][0][251] = new String("0");
			nm.carbon[6][0][252] = new String("0");
			nm.carbon[6][0][253] = new String("0");
			nm.carbon[6][0][254] = new String("0");
			nm.carbon[6][0][255] = new String("0");
			nm.carbon[6][0][256] = new String("0");
			nm.carbon[6][0][257] = new String("0");
			nm.carbon[6][0][258] = new String("0");
			nm.carbon[6][0][259] = new String("0");
			nm.carbon[6][0][260] = new String("0");
			nm.carbon[6][0][261] = new String("0");
			nm.carbon[6][0][262] = new String("0");
			nm.carbon[6][0][263] = new String("1");
			nm.carbon[6][0][264] = new String("0");
			nm.carbon[6][0][265] = new String("0");
			nm.carbon[6][0][266] = new String("0");
			nm.carbon[6][0][267] = new String("0");
			nm.carbon[6][0][268] = new String("0");
			nm.carbon[6][0][269] = new String("0");
			nm.carbon[6][0][270] = new String("0");
			nm.carbon[6][0][271] = new String("0");
			nm.carbon[6][0][272] = new String("0");
			nm.carbon[6][0][273] = new String("0");
			nm.carbon[6][0][274] = new String("0");
			nm.carbon[6][0][275] = new String("0");
			nm.carbon[6][0][276] = new String("0");
			nm.carbon[6][0][277] = new String("0");
			nm.carbon[6][0][278] = new String("0");
			nm.carbon[6][0][279] = new String("1");
			nm.carbon[6][0][280] = new String("0");
			nm.carbon[6][0][281] = new String("0");
			nm.carbon[6][0][282] = new String("0");
			nm.carbon[6][0][283] = new String("1");
			nm.carbon[6][0][284] = new String("0");
			nm.carbon[6][0][285] = new String("1");
			nm.carbon[6][0][286] = new String("0");
			nm.carbon[6][0][287] = new String("0");
			nm.carbon[6][0][288] = new String("0");
			nm.carbon[6][0][289] = new String("0");
			nm.carbon[6][0][290] = new String("0");
			nm.carbon[6][0][291] = new String("0");
			nm.carbon[6][0][292] = new String("0");
			nm.carbon[6][0][293] = new String("0");
			nm.carbon[6][0][294] = new String("0");
			nm.carbon[6][0][295] = new String("0");
			nm.carbon[6][0][296] = new String("0");
			nm.carbon[6][0][297] = new String("1");
			nm.carbon[6][0][298] = new String("0");
			nm.carbon[6][0][299] = new String("0");





			//rebuild display settings order list
			nm.carbon[6][1][0] = new String("86");
			nm.carbon[6][1][1] = new String("87");
			nm.carbon[6][1][2] = new String("88");
			nm.carbon[6][1][3] = new String("89");
			nm.carbon[6][1][4] = new String("90");
			nm.carbon[6][1][5] = new String("91");
			nm.carbon[6][1][6] = new String("92");
			nm.carbon[6][1][7] = new String("93");
			nm.carbon[6][1][8] = new String("94");
			nm.carbon[6][1][9] = new String("95");
			nm.carbon[6][1][10] = new String("96");
			nm.carbon[6][1][11] = new String("97");
			nm.carbon[6][1][12] = new String("98");
			nm.carbon[6][1][13] = new String("5");
			nm.carbon[6][1][14] = new String("6");
			nm.carbon[6][1][15] = new String("11");
			nm.carbon[6][1][16] = new String("12");
			nm.carbon[6][1][17] = new String("13");
			nm.carbon[6][1][18] = new String("14");
			nm.carbon[6][1][19] = new String("15");
			nm.carbon[6][1][20] = new String("16");
			nm.carbon[6][1][21] = new String("17");
			nm.carbon[6][1][22] = new String("18");
			nm.carbon[6][1][23] = new String("19");
			nm.carbon[6][1][24] = new String("20");
			nm.carbon[6][1][25] = new String("21");
			nm.carbon[6][1][26] = new String("22");
			nm.carbon[6][1][27] = new String("23");
			nm.carbon[6][1][28] = new String("24");
			nm.carbon[6][1][29] = new String("25");
			nm.carbon[6][1][30] = new String("26");
			nm.carbon[6][1][31] = new String("27");
			nm.carbon[6][1][32] = new String("28");
			nm.carbon[6][1][33] = new String("29");
			nm.carbon[6][1][34] = new String("30");
			nm.carbon[6][1][35] = new String("31");
			nm.carbon[6][1][36] = new String("32");
			nm.carbon[6][1][37] = new String("33");
			nm.carbon[6][1][38] = new String("34");
			nm.carbon[6][1][39] = new String("35");
			nm.carbon[6][1][40] = new String("36");
			nm.carbon[6][1][41] = new String("37");
			nm.carbon[6][1][42] = new String("38");
			nm.carbon[6][1][43] = new String("39");
			nm.carbon[6][1][44] = new String("40");
			nm.carbon[6][1][45] = new String("41");
			nm.carbon[6][1][46] = new String("42");
			nm.carbon[6][1][47] = new String("43");
			nm.carbon[6][1][48] = new String("44");
			nm.carbon[6][1][49] = new String("45");
			nm.carbon[6][1][50] = new String("46");
			nm.carbon[6][1][51] = new String("47");
			nm.carbon[6][1][52] = new String("48");
			nm.carbon[6][1][53] = new String("49");
			nm.carbon[6][1][54] = new String("50");
			nm.carbon[6][1][55] = new String("51");
			nm.carbon[6][1][56] = new String("52");
			nm.carbon[6][1][57] = new String("53");
			nm.carbon[6][1][58] = new String("54");
			nm.carbon[6][1][59] = new String("55");
			nm.carbon[6][1][60] = new String("56");
			nm.carbon[6][1][61] = new String("57");
			nm.carbon[6][1][62] = new String("58");
			nm.carbon[6][1][63] = new String("59");
			nm.carbon[6][1][64] = new String("4");
			nm.carbon[6][1][65] = new String("60");
			nm.carbon[6][1][66] = new String("61");
			nm.carbon[6][1][67] = new String("62");
			nm.carbon[6][1][68] = new String("80");
			nm.carbon[6][1][69] = new String("63");
			nm.carbon[6][1][70] = new String("7");
			nm.carbon[6][1][71] = new String("3");
			nm.carbon[6][1][72] = new String("64");
			nm.carbon[6][1][73] = new String("65");
			nm.carbon[6][1][74] = new String("99");
			nm.carbon[6][1][75] = new String("9");
			nm.carbon[6][1][76] = new String("66");
			nm.carbon[6][1][77] = new String("67");
			nm.carbon[6][1][78] = new String("68");
			nm.carbon[6][1][79] = new String("1");
			nm.carbon[6][1][80] = new String("69");
			nm.carbon[6][1][81] = new String("70");
			nm.carbon[6][1][82] = new String("71");
			nm.carbon[6][1][83] = new String("72");
			nm.carbon[6][1][84] = new String("8");
			nm.carbon[6][1][85] = new String("2");
			nm.carbon[6][1][86] = new String("73");
			nm.carbon[6][1][87] = new String("74");
			nm.carbon[6][1][88] = new String("75");
			nm.carbon[6][1][89] = new String("76");
			nm.carbon[6][1][90] = new String("77");
			nm.carbon[6][1][91] = new String("78");
			nm.carbon[6][1][92] = new String("79");
			nm.carbon[6][1][93] = new String("0");
			nm.carbon[6][1][94] = new String("10");
			nm.carbon[6][1][95] = new String("81");
			nm.carbon[6][1][96] = new String("82");
			nm.carbon[6][1][97] = new String("83");
			nm.carbon[6][1][98] = new String("84");
			nm.carbon[6][1][99] = new String("85");

			nm.carbon[6][1][100] = new String("0");
			nm.carbon[6][1][101] = new String("0");
			nm.carbon[6][1][102] = new String("0");
			nm.carbon[6][1][103] = new String("0");
			nm.carbon[6][1][104] = new String("0");
			nm.carbon[6][1][105] = new String("0");
			nm.carbon[6][1][106] = new String("0");
			nm.carbon[6][1][107] = new String("0");
			nm.carbon[6][1][108] = new String("1");
			nm.carbon[6][1][109] = new String("0");
			nm.carbon[6][1][110] = new String("1");
			nm.carbon[6][1][111] = new String("1");
			nm.carbon[6][1][112] = new String("0");
			nm.carbon[6][1][113] = new String("0");
			nm.carbon[6][1][114] = new String("0");
			nm.carbon[6][1][115] = new String("1");
			nm.carbon[6][1][116] = new String("1");
			nm.carbon[6][1][117] = new String("0");
			nm.carbon[6][1][118] = new String("0");
			nm.carbon[6][1][119] = new String("0");
			nm.carbon[6][1][120] = new String("0");
			nm.carbon[6][1][121] = new String("0");
			nm.carbon[6][1][122] = new String("0");
			nm.carbon[6][1][123] = new String("0");
			nm.carbon[6][1][124] = new String("0");
			nm.carbon[6][1][125] = new String("0");
			nm.carbon[6][1][126] = new String("0");
			nm.carbon[6][1][127] = new String("0");
			nm.carbon[6][1][128] = new String("0");
			nm.carbon[6][1][129] = new String("0");
			nm.carbon[6][1][130] = new String("0");
			nm.carbon[6][1][131] = new String("0");
			nm.carbon[6][1][132] = new String("0");
			nm.carbon[6][1][133] = new String("0");
			nm.carbon[6][1][134] = new String("0");
			nm.carbon[6][1][135] = new String("0");
			nm.carbon[6][1][136] = new String("0");
			nm.carbon[6][1][137] = new String("0");
			nm.carbon[6][1][138] = new String("0");
			nm.carbon[6][1][139] = new String("0");
			nm.carbon[6][1][140] = new String("0");
			nm.carbon[6][1][141] = new String("0");
			nm.carbon[6][1][142] = new String("0");
			nm.carbon[6][1][143] = new String("0");
			nm.carbon[6][1][144] = new String("0");
			nm.carbon[6][1][145] = new String("0");
			nm.carbon[6][1][146] = new String("0");
			nm.carbon[6][1][147] = new String("0");
			nm.carbon[6][1][148] = new String("0");
			nm.carbon[6][1][149] = new String("0");
			nm.carbon[6][1][150] = new String("0");
			nm.carbon[6][1][151] = new String("0");
			nm.carbon[6][1][152] = new String("0");
			nm.carbon[6][1][153] = new String("0");
			nm.carbon[6][1][154] = new String("0");
			nm.carbon[6][1][155] = new String("0");
			nm.carbon[6][1][156] = new String("0");
			nm.carbon[6][1][157] = new String("0");
			nm.carbon[6][1][158] = new String("0");
			nm.carbon[6][1][159] = new String("0");
			nm.carbon[6][1][160] = new String("0");
			nm.carbon[6][1][161] = new String("0");
			nm.carbon[6][1][162] = new String("0");
			nm.carbon[6][1][163] = new String("1");
			nm.carbon[6][1][164] = new String("0");
			nm.carbon[6][1][165] = new String("0");
			nm.carbon[6][1][166] = new String("0");
			nm.carbon[6][1][167] = new String("0");
			nm.carbon[6][1][168] = new String("0");
			nm.carbon[6][1][169] = new String("0");
			nm.carbon[6][1][170] = new String("0");
			nm.carbon[6][1][171] = new String("1");
			nm.carbon[6][1][172] = new String("1");
			nm.carbon[6][1][173] = new String("0");
			nm.carbon[6][1][174] = new String("0");
			nm.carbon[6][1][175] = new String("0");
			nm.carbon[6][1][176] = new String("0");
			nm.carbon[6][1][177] = new String("0");
			nm.carbon[6][1][178] = new String("0");
			nm.carbon[6][1][179] = new String("1");
			nm.carbon[6][1][180] = new String("0");
			nm.carbon[6][1][181] = new String("0");
			nm.carbon[6][1][182] = new String("0");
			nm.carbon[6][1][183] = new String("1");
			nm.carbon[6][1][184] = new String("0");
			nm.carbon[6][1][185] = new String("1");
			nm.carbon[6][1][186] = new String("0");
			nm.carbon[6][1][187] = new String("0");
			nm.carbon[6][1][188] = new String("0");
			nm.carbon[6][1][189] = new String("0");
			nm.carbon[6][1][190] = new String("0");
			nm.carbon[6][1][191] = new String("0");
			nm.carbon[6][1][192] = new String("1");
			nm.carbon[6][1][193] = new String("0");
			nm.carbon[6][1][194] = new String("0");
			nm.carbon[6][1][195] = new String("0");
			nm.carbon[6][1][196] = new String("1");
			nm.carbon[6][1][197] = new String("0");
			nm.carbon[6][1][198] = new String("0");
			nm.carbon[6][1][199] = new String("0");

			nm.carbon[6][1][200] = new String("0");
			nm.carbon[6][1][201] = new String("0");
			nm.carbon[6][1][202] = new String("0");
			nm.carbon[6][1][203] = new String("0");
			nm.carbon[6][1][204] = new String("0");
			nm.carbon[6][1][205] = new String("0");
			nm.carbon[6][1][206] = new String("1");
			nm.carbon[6][1][207] = new String("0");
			nm.carbon[6][1][208] = new String("1");
			nm.carbon[6][1][209] = new String("0");
			nm.carbon[6][1][210] = new String("0");
			nm.carbon[6][1][211] = new String("0");
			nm.carbon[6][1][212] = new String("0");
			nm.carbon[6][1][213] = new String("0");
			nm.carbon[6][1][214] = new String("0");
			nm.carbon[6][1][215] = new String("0");
			nm.carbon[6][1][216] = new String("0");
			nm.carbon[6][1][217] = new String("0");
			nm.carbon[6][1][218] = new String("0");
			nm.carbon[6][1][219] = new String("0");
			nm.carbon[6][1][220] = new String("0");
			nm.carbon[6][1][221] = new String("0");
			nm.carbon[6][1][222] = new String("0");
			nm.carbon[6][1][223] = new String("0");
			nm.carbon[6][1][224] = new String("0");
			nm.carbon[6][1][225] = new String("0");
			nm.carbon[6][1][226] = new String("0");
			nm.carbon[6][1][227] = new String("0");
			nm.carbon[6][1][228] = new String("0");
			nm.carbon[6][1][229] = new String("0");
			nm.carbon[6][1][230] = new String("0");
			nm.carbon[6][1][231] = new String("0");
			nm.carbon[6][1][232] = new String("0");
			nm.carbon[6][1][233] = new String("0");
			nm.carbon[6][1][234] = new String("0");
			nm.carbon[6][1][235] = new String("0");
			nm.carbon[6][1][236] = new String("0");
			nm.carbon[6][1][237] = new String("0");
			nm.carbon[6][1][238] = new String("0");
			nm.carbon[6][1][239] = new String("0");
			nm.carbon[6][1][240] = new String("0");
			nm.carbon[6][1][241] = new String("0");
			nm.carbon[6][1][242] = new String("0");
			nm.carbon[6][1][243] = new String("0");
			nm.carbon[6][1][244] = new String("0");
			nm.carbon[6][1][245] = new String("0");
			nm.carbon[6][1][246] = new String("0");
			nm.carbon[6][1][247] = new String("0");
			nm.carbon[6][1][248] = new String("0");
			nm.carbon[6][1][249] = new String("0");
			nm.carbon[6][1][250] = new String("0");
			nm.carbon[6][1][251] = new String("0");
			nm.carbon[6][1][252] = new String("0");
			nm.carbon[6][1][253] = new String("0");
			nm.carbon[6][1][254] = new String("0");
			nm.carbon[6][1][255] = new String("0");
			nm.carbon[6][1][256] = new String("0");
			nm.carbon[6][1][257] = new String("0");
			nm.carbon[6][1][258] = new String("0");
			nm.carbon[6][1][259] = new String("0");
			nm.carbon[6][1][260] = new String("0");
			nm.carbon[6][1][261] = new String("0");
			nm.carbon[6][1][262] = new String("0");
			nm.carbon[6][1][263] = new String("1");
			nm.carbon[6][1][264] = new String("0");
			nm.carbon[6][1][265] = new String("0");
			nm.carbon[6][1][266] = new String("0");
			nm.carbon[6][1][267] = new String("0");
			nm.carbon[6][1][268] = new String("0");
			nm.carbon[6][1][269] = new String("0");
			nm.carbon[6][1][270] = new String("0");
			nm.carbon[6][1][271] = new String("0");
			nm.carbon[6][1][272] = new String("0");
			nm.carbon[6][1][273] = new String("0");
			nm.carbon[6][1][274] = new String("0");
			nm.carbon[6][1][275] = new String("0");
			nm.carbon[6][1][276] = new String("0");
			nm.carbon[6][1][277] = new String("0");
			nm.carbon[6][1][278] = new String("0");
			nm.carbon[6][1][279] = new String("1");
			nm.carbon[6][1][280] = new String("0");
			nm.carbon[6][1][281] = new String("0");
			nm.carbon[6][1][282] = new String("0");
			nm.carbon[6][1][283] = new String("1");
			nm.carbon[6][1][284] = new String("0");
			nm.carbon[6][1][285] = new String("1");
			nm.carbon[6][1][286] = new String("0");
			nm.carbon[6][1][287] = new String("0");
			nm.carbon[6][1][288] = new String("0");
			nm.carbon[6][1][289] = new String("0");
			nm.carbon[6][1][290] = new String("0");
			nm.carbon[6][1][291] = new String("0");
			nm.carbon[6][1][292] = new String("0");
			nm.carbon[6][1][293] = new String("0");
			nm.carbon[6][1][294] = new String("0");
			nm.carbon[6][1][295] = new String("0");
			nm.carbon[6][1][296] = new String("0");
			nm.carbon[6][1][297] = new String("1");
			nm.carbon[6][1][298] = new String("0");
			nm.carbon[6][1][299] = new String("0");





			nm.jdb_load_sales_ids = new String[0];



			nm.jdb_load_list = new String[1];
			nm.jdb_load_list[0] = new String("create_export");





	}//**********






}//last****************************************
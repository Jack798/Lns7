package com.Lns7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordProcessing {


	public static String delNum(String codeText) {
		
		StringBuffer sb = new StringBuffer();
    	//^\\d+\\.
    	//(?m)^[ \t]*\\d{4}:[ \t]*    多行匹配模式
        Pattern pattern = Pattern.compile("^\\d+\\.");
        Matcher matcher = null;
        //得到系统平台下的换行符，windows平台下是“/r/n”,Unix下是“/r”
        String line = System.getProperty("line.separator");
        try {
           String a_codeText[]  =codeText.split(line);
           for (int i = 0; i < a_codeText.length; i++){
                matcher = pattern.matcher(a_codeText[i]);
                sb.append(matcher.replaceAll("")+line);
            }
		} catch (Exception e) {
			sb.append(e) ;
		}
        //System.out.println(sb.toString());
        return sb.toString();
      
        //return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	

}

package com.Lns7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testdelNum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   BufferedReader br = null;
	        BufferedWriter bw = null;
	        try {
	            Pattern pattern = Pattern.compile("(?m)^[ \t]*\\d{4}:[ \t]*");//多行匹配模式
	            String line = System.getProperty("line.separator");
	            System.out.println(line);
	            System.out.println(line.length());
	            
	            br = new BufferedReader(new FileReader("D:\\t\\1.txt"));
	            bw = new BufferedWriter(new FileWriter("D:\\t\\1_.txt"));
	            String str = null;
	            while((str = br.readLine())!=null) {
	                str = replace(pattern, str);
	                bw.write(str+line);
	            }
	        }catch(IOException e) {
	            e.printStackTrace();
	        }finally{
	            close(bw);
	            close(br);
	        }
	        System.out.println("finished.");
	    }
	    
	    private static String replace(Pattern pattern, String str) {
	        Matcher matcher = pattern.matcher(str);
	        return matcher.replaceAll("");
	    }
	   
	    private static void close(Closeable closeable) {
	        if(closeable != null) {
	            try {
	                closeable.close();
	            } catch (IOException e) {
	               e.printStackTrace();
	            }
	        }
	    }

}

package com.Lns7;

import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.htmlparser.*;
import org.htmlparser.filters.*;
import org.htmlparser.util.*;


public class t1 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	
	
	
	
	
	public static void main(String[] args) throws Exception {
		
		
		//System.out.println(getHtmlCharset("http://www.ip138.com"));
	}
	 public static String getHtmlCharset(String URL) throws Exception {
		 		String rt=null;
		 		
		 		String str = null;

	            NodeList nodes = null;

	            nodes = nodeMatch(URL,new TagNameFilter("meta"),new HasAttributeFilter("http-equiv","Content-Type"));
	            
	            if(nodes.size()>0){
	            	str = nodes.toHtml().toUpperCase();
	            }else{
	            	nodes = nodeMatch(URL,new TagNameFilter("meta"),new HasAttributeFilter("charset"));

		            if(nodes.size()>0){
		            	str = nodes.toHtml().toUpperCase();
		            }
	            }
	           
	            
	            
	            
	            System.out.println(nodes.size());
	            str = nodes.toHtml().toUpperCase();
	            
	            System.out.println(nodes.toHtml());
	            
	            if(str.contains("GBK")){
	            	rt="GBK";
	            	
	            }else if(str.contains("GB2312")){
	            	rt="GB2312";
	            }else{
	            	rt="utf-8";
	            }
		 return rt;
	 }
	 
	 public static NodeList nodeMatch(String url,NodeFilter filter1,NodeFilter filter2) throws Exception {
		 Parser parser = new Parser((HttpURLConnection)(new URL(url)).openConnection());
         
         NodeFilter filter = new AndFilter(filter1, filter2);

         NodeList nodes = parser.extractAllNodesThatMatch(filter);

         return nodes;
	 }
		
		
		//Google();
		//testPost();
		/*
		String result = "";
		String inputParam = "";
		URL url = new URL("http://www.taobao.com");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestProperty( "Content-Length",String.valueOf( inputParam.toString().getBytes().length ));
		httpConn.setRequestProperty("Content-Type","text/xml; charset=utf-8");
		httpConn.setRequestMethod( "POST" );
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		
		OutputStream out1 = httpConn.getOutputStream();
		//out1.write(inputParam.toString().getBytes());
		out1.close();
			
		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream(),"utf-8");
		BufferedReader in1 = new BufferedReader(isr);
		String inputLine;
		while ((inputLine = in1.readLine()) != null){
			result += inputLine;
		}
		in1.close();
		
		System.out.println("\n\n======"+result+"======\n\n");
		*/
		
	/*
		 String sendurl = "http://nportal2.nxdx.com:80/nxdx/info.do?action=viewInfo&id=";
		 
		 URL urlObj = new URL(sendurl);
		 HttpURLConnection urlCon =  (HttpURLConnection)urlObj.openConnection() ;

		 urlCon.setInstanceFollowRedirects(false);
		 
		 urlCon.setRequestProperty("Cookie", sb.toString());
		 urlCon.setRequestMethod("GET");
		 urlCon.setRequestProperty("Accept-Language", "zh-cn");
		 urlCon.setRequestProperty("Accept-Encoding", "gzip,deflate");
		 urlCon.setRequestProperty("User-Agent","Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1; .NET CLR 2.0.50727)");
		 urlCon.setRequestProperty("Accept", "");
		 
		**///

	
	 
	 public static void testPost() throws IOException {  
		  
	        /** 
	         * 首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using 
	         *  java.net.URL and //java.net.URLConnection 
	         */  
	        URL url = new URL("https://api.yixin.im/cgi-bin/token?grant_type=client_credential&appid=58359daa5419463e9d1f2d4aba258c4f&secret=3ce235a3a74f461abae3c05023088225");  
	        URLConnection connection = url.openConnection();  
	        /** 
	         * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。 
	         * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做： 
	         */  
	        connection.setDoOutput(true);  
	        /** 
	         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ... 
	         */  
	        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "gbk");  
	        out.write("username=kevin&password=*********"); //post的关键所在！  
	        // remember to clean up  
	        out.flush();  
	        out.close();  
	        /** 
	         * 这样就可以发送一个看起来象这样的POST：  
	         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT: 
	         * text/plain Content-type: application/x-www-form-urlencoded 
	         * Content-length: 99 username=bob password=someword 
	         */  
	        // 一旦发送成功，用以下方法就可以得到服务器的回应：  
	        String sCurrentLine;  
	        String sTotalString;  
	        sCurrentLine = "";  
	        sTotalString = "";  
	        InputStream l_urlStream;  
	        l_urlStream = connection.getInputStream();  
	        // 传说中的三层包装阿！  
	        BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));  
	        while ((sCurrentLine = l_reader.readLine()) != null) {  
	            sTotalString += sCurrentLine + "/r/n";  
	        }  
	        System.out.println(sTotalString);  
	    }  


	
	
	public static void Google(String strurl) throws Exception{
		URL url = new URL(strurl);
		URLConnection httpCon =  url.openConnection();
		
		System.out.println(httpCon.getHeaderField("Content-Type"));
		System.out.println("====================================");
		System.out.println();
		System.out.println("====================================");
		Map<String, List<String>> hdrs = httpCon.getHeaderFields();
		Set<String> hdrKeys = hdrs.keySet();

		for (String k : hdrKeys){
			System.out.println("Key: " + k + "  ------Value: " + hdrs.get(k));
		}
	}

}

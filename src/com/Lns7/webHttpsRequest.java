package com.Lns7;

import java.io.*;
import java.net.*;
import java.nio.charset.*;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;
import java.util.logging.*;
import javax.net.ssl.*;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

public class webHttpsRequest {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		HttpRequester requester = new HttpRequester();
		
		String url="https://api.yixin.im/cgi-bin/menu/create?access_token=7e9c0d1b72e44312ba3f7578ac7b596d";
		String data="{ \"button\" : [ { \"name\" : \"在线客服\",\"sub_button\" : [ { \"key\" : \"/dt2/ai.yx\",\"name\" : \"召唤精灵\",\"type\" : \"click\"},{ \"key\" : \"/dt2/chat.yx\",\"name\" : \"人工服务\",\"type\" : \"click\"}]},{ \"key\" : \"/dt2/self.yx?id=36001\",\"name\" : \"自助服务\",\"type\" : \"click\"},{ \"key\" : \"/dt2/self.yx\",\"name\" : \"帐号服务\",\"type\" : \"click\"},{ \"name\" : \"其他\",\"sub_button\" : [ { \"key\" : \"/dt2/self.yx?id=77011\",\"name\" : \"將军令\",\"type\" : \"click\"},{ \"key\" : \"/dt2/self.yx\",\"name\" : \"防盜教程\",\"type\" : \"click\"},{ \"key\" : \"/dt2/self.yx\",\"name\" : \"防骗教程\",\"type\" : \"click\"},{ \"key\" : \"/dt2/self.yx\",\"name\" : \"其他介紹\",\"type\" : \"click\"},{ \"key\" : \"/dt2/logout.yx\",\"name\" : \"切换帐号\",\"type\" : \"click\"} ]}] }";
		
		//HttpResponser responser = requester.sendPost(url,data);
		//fDED891YO4N3QMy8LHB3nQmFerh6NPabluNFCX9AqJusCHwkeSry87vOthxlHaCklo-0zP_ZwIN264uF7_jTM376vDLB5sLN0J1sdMjWw4ov704DtBkEifjlgK9PrW2_e0zwvj66mIQK6QyLpjGofQ
        HttpResponser responser = requester.sendGet("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx1a99d720fa867dc6&secret=29569dbbade2b710848ed8ea40fc70b4");

		System.out.println(responser.getContent());

	}
	

	public static String getValue(String label,String attName){
		return label.split(attName+"=\"")[1].split("\"")[0];
	}
	
	public static String getLabel(String str,String labelName){
		String before,afuerStr,s;
		before = str.split(labelName)[0];
		afuerStr = str.substring(before.lastIndexOf("<"));
		s = afuerStr.substring(0,afuerStr.indexOf(">")+1);
		return s;
	}
	
	 public static String getHtmlCharset(String url,String Defaultcharset){
		 String rt=null;
	 		
	 	 String str = null;

         NodeList nodes = null;
         
         try {
			nodes = nodeMatch(url,new TagNameFilter("meta"),new HasAttributeFilter("http-equiv","Content-Type"));
			 if(nodes.size()>0){
		         	str = nodes.toHtml().toUpperCase();
		         	//System.out.println(nodes.toHtml()); 
		         }else{
		         	nodes = nodeMatch(url,new TagNameFilter("meta"),new HasAttributeFilter("charset"));

			            if(nodes.size()>0){
			            	str = nodes.toHtml().toUpperCase();
			            }
		         }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
        //System.out.println(nodes.toHtml()+"cccc"); 
         
        str = nodes.toHtml().toUpperCase();
	            
        if(str.contains("GBK")){
        	rt="GBK";
        	
        }else if(str.contains("GB2312")){
        	rt="GB2312";
        }else{
        	rt=Defaultcharset;
        }
		 return rt;
	 }
	 
	 public static NodeList nodeMatch(String url,NodeFilter filter1,NodeFilter filter2) throws Exception {
		 Parser parser =new Parser((HttpURLConnection)(new URL(url)).openConnection());

		 //System.out.println(url+"vvvvxxx"); 
		 
         NodeFilter filter = new AndFilter(filter1, filter2);

         NodeList nodes = parser.extractAllNodesThatMatch(filter);

         return nodes;
	 }

	public static class HttpRequester {
		 
	    private String _encoding = Charset.defaultCharset().name();
	    private HttpURLConnection _HttpURLConnection = null;
	    

		private Map<String,String> _reHeaders = new HashMap <String, String>();
	    /**
	     * 发送请求
	     * @param urlString
	     * @param method
	     * @param data
	     * @return
	     */
	
		public HttpResponser send(String urlString, String method, String data){
	        HttpsURLConnection urlConnection = null;
	        HttpResponser httpResponser = new HttpResponser();

            
	        try {
	        	urlString = urlString.replace("&amp;","&"); 
	            URL url = new URL(urlString);
	            urlConnection = (HttpsURLConnection) url.openConnection();
	            set_HttpURLConnection(urlConnection);
	            urlConnection.setRequestMethod(method);

	            if(this.getReHeaders().size() != 0){
	            	for(String K : this.getReHeaders().keySet()){   
		            	urlConnection.setRequestProperty(K,this.getReHeaders().get(K));
		            }
	            }	
	            TrustManager[] tm = { (TrustManager) new MyX509TrustManager() };  

	            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  

	            sslContext.init(null, tm, new java.security.SecureRandom());  
	            SSLSocketFactory ssf = sslContext.getSocketFactory();  
	            urlConnection.setSSLSocketFactory(ssf);  
	            
	            urlConnection.setDoOutput(true);
	            urlConnection.setDoInput(true);
	            urlConnection.setUseCaches(false);
	            urlConnection.setInstanceFollowRedirects(false);
	            
	            
	            if ("POST".equals(method)){
	                urlConnection.getOutputStream().write(data.getBytes(this._encoding));
	                urlConnection.getOutputStream().flush();
	                urlConnection.getOutputStream().close();
	            }
	            //获取详情页面字符集名称
	            
	            String resCharset = "utf-8";

	            if(urlConnection.getContentType().indexOf("=")>1){
	            	resCharset = urlConnection.getContentType().split("=")[1];
	            	
	            	
	            }else{
	            	resCharset = getHtmlCharset(urlString,resCharset);
	            	System.out.println(resCharset);
	            }

	            InputStream in = urlConnection.getInputStream();   
	            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in,resCharset));   
	            StringBuffer temp = new StringBuffer();   
	            String line = bufferedReader.readLine();   
	            while (line != null) {   
	            	//转换特殊字符
	            	line=utilityHelper.HTMLFilter(line);
	            	//temp.append(line).append("\r\n");   
	            	temp.append(line).append("<br/>");   
	                line = bufferedReader.readLine();   
	            }   
	            //System.out.println(temp.toString().length()+"ppppppppp11");
	            bufferedReader.close();   

	            String ecod = urlConnection.getContentEncoding();   

	            if (ecod == null){
	                ecod = resCharset;   
	            }

	            httpResponser.setHeaderMap(urlConnection.getHeaderFields());
	            httpResponser.setUrl(urlString);   
	            httpResponser.setContent(temp.toString());   
	            httpResponser.setEncoding(ecod);   
	            httpResponser.setResponseCode(urlConnection.getResponseCode());
	            httpResponser.setLocation(urlConnection.getHeaderField("Location"));

	        } catch (IOException ex) {
	            Logger.getLogger(HttpRequester.class.getName()).log(Level.SEVERE, null, ex);

			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchProviderException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (KeyManagementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {   
	            if (urlConnection != null)   
	                urlConnection.disconnect();   
	        }   

	        return httpResponser;
	    }
		
		public HttpURLConnection get_HttpURLConnection() {
			return _HttpURLConnection;
		}


		public void set_HttpURLConnection(HttpURLConnection _HttpURLConnection) {
			this._HttpURLConnection = _HttpURLConnection;
		}
		
		
		 /**
	     *  发送Get请求
	     * @param urlString
	     * @return
	     */
	    public HttpResponser sendGet(String urlString){
	        return send(urlString, "GET", null);
	    }
	    /**
	     * 发送Post请求
	     * @param urlString
	     * @param data
	     * @return
	     */
	    public HttpResponser sendPost(String urlString, String data){
	        return send(urlString, "POST", data);
	    }
	    /**
	     * 获取请求编码
	     * @return
	     */
	    public String GetEncoding(){
	        return this._encoding;
	    }
	    /**
	     * 设置请求编码
	     * @param encoding
	     */
	    public void setEncoding(String encoding){
	        this._encoding = encoding;
	    }
	    
	    public Map<String,String> getReHeaders() {

	    	return _reHeaders;
	    }
	 
	    public void setReHeaders(String key, String value) {
	    	
	        this._reHeaders.put(key,value);
	        
	    }

	}
	
	/**
	 * 响应对象
	 * 
	 */
	public static class HttpResponser {
	    
	    private String _url = null; //链接
	    private String _encoding = null;//编码
	    private String _content = null;//内容
	    private int _responseCode = 0;//状态码
	    private String _location = null;//内容
	    private Map<String, List<String>> _headerMap = null;
	    public String getLocation() {
	        return _location;
	    }
	 
	    public void setLocation(String Str) {
	        this._location = Str;
	    }
	    
	    public int getResponseCode() {
	        return _responseCode;
	    }
	 
	    public void setResponseCode(int codeStr) {
	        this._responseCode = codeStr;
	    }

	    public Map<String, List<String>> getHeaderMap() {
	        return _headerMap;
	    }
	 
	    public void setHeaderMap(Map<String, List<String>> content) {
	        this._headerMap = content;
	    }	    
	    
	    public String getContent() {
	        return _content;
	    }
	 
	    public void setContent(String content) {
	        this._content = content;
	    }
	 
	    public String getEncoding() {
	        return _encoding;
	    }
	 
	    public void setEncoding(String encoding) {
	        this._encoding = encoding;
	    }
	 
	    public String getUrl() {
	        return _url;
	    }
	 
	    public void setUrl(String url) {
	        this._url = url;
	    }
	}

}



/*public static HttpResponser request302(HttpResponser Responser,String Cookie1,String Cookie2,String CAScookie,String host){
	HttpResponser rs=null;
	if(Responser.getResponseCode() == 302){
		
		String url = Responser.getLocation();

		HttpRequester requester = new HttpRequester();
		requester.setEncoding("gbk");
		requester.setReHeaders("Accept","application/x-shockwave-flash, image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/vnd.ms-excel, application/vnd.ms-powerpoint, application/msword,");
		requester.setReHeaders("Accept-Language","zh-cn");
		requester.setReHeaders("Accept-Encoding","gzip, deflate");
		requester.setReHeaders("User-Agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 2.0.50727)");
		
		if(url.substring(0, 32).equals("http://" + host + "/CASCenter")){
			requester.setReHeaders("Cookie",Cookie2+"; "+Cookie1+";"+CAScookie);
		}else{
			requester.setReHeaders("Cookie",Cookie1);
		}
		
		
		url = url.substring(0,7).equals("http://") ? url : "http://135.161.158.135" + url;
		HttpResponser responser = requester.sendGet(url);
		rs = request302(responser,Cookie1,Cookie2,CAScookie,host);

	}else{
		rs = Responser;
	}

	return rs;
}*/

/*	    URL url = new URL("http://www.google.com");
HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();

Map<String, List<String>> hdrs = httpCon.getHeaderFields();
Set<String> hdrKeys = hdrs.keySet();

for (String k : hdrKeys){
	System.out.println("Key: " + k + "  Value: " + hdrs.get(k));
}*/
  

/*		
	URL url = new URL("http://www.baidu.com/s?wd=wa");
	URLConnection connection = url.openConnection();
	connection.setRequestProperty("accept","");
	connection.setRequestProperty("connection","Keep-Alive");
	connection.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
	connection.connect();
	Map<String, List<String>> headerMap = connection.getHeaderFields();
	for(String key :headerMap.keySet()){
		System.out.println(key+"-->"+headerMap.get(key));
	}*/




/*		String url_str,method,charset;
url_str="http://135.161.158.135/cpmis/workflow/oaLogin.do?usercode=64082422&modelcode=oa&targetUrl=http://135.161.158.135/cpmis/workflow/execute.do?workItemId=398771`.busiId=15004304`.busiAlias=BLCK`.nodeId=652898`.orderId=21984429`.from=ALL&ssokey=E5BADB13C63C314D26CC8084B8AF2FB2103634303832343232132DF64N35F56";
method="GET";
charset="gbk";
    
    
    HttpURLConnection urlConnection = null;
  
    try {
        
        URL url = new URL(url_str);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod(method);
        urlConnection.setDoOutput(true);
        urlConnection.setInstanceFollowRedirects(false);
        urlConnection.setDoInput(true);
        urlConnection.setUseCaches(false);
        
        if ("POST".equals("POST")){
            urlConnection.getOutputStream().write("name=sss".getBytes("gbk"));
            urlConnection.getOutputStream().flush();
            urlConnection.getOutputStream().close();
        }
        
        InputStream in = urlConnection.getInputStream(); 
        
        System.out.println(urlConnection.getHeaderField("Set-Cookie"));
       
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));   
        StringBuffer temp = new StringBuffer();   
        String line = bufferedReader.readLine();   
        while (line != null) {   
            temp.append(line).append("\r\n");   
            line = bufferedReader.readLine();   
        }   
        bufferedReader.close();   

        String ecod = urlConnection.getContentEncoding();   
        if (ecod == null){
            ecod = "gbk";   
        }

        
        
        System.out.println(new String(temp.toString().getBytes(), ecod));
        
    } catch (IOException ex) {
        Logger.getLogger(HttpRequester.class.getName()).log(Level.SEVERE, null, ex);
    } finally {   
        if (urlConnection != null)   
            urlConnection.disconnect();   
    }   
*/
    
    
    



/*		SAXReader reader = new  SAXReader();  
Document doc = null;
File file = new File("d:/Untitled1.xml");
System.out.println(file.exists());

try {
	doc = reader.read(file);
} catch (Exception e) {
	e.printStackTrace();
}     



List<?> childNodes = doc.selectNodes("//input[@type='hidden']");    
for (Object obj:childNodes) {    
	Node childNode = (Node)obj;    
	String name = childNode.valueOf("@name"); 

	String text = name.equals("pageCode")? "WoMine" : childNode.valueOf("@value");   
	System.out.println(name+":"+text);
	System.out.println("========================");
} */

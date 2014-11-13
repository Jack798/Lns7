package com.Lns7;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.dom4j.*;
import org.dom4j.io.*;

public class utilityHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		
		Map<String, String> map = new LinkedHashMap<String, String>();  
        map.put("a3", "aa");       
        map.put("a2", "bb"); 
        map.put("b1", "cc");  
        System.out.print(getUUID());
        /*
        for(Entry<String, String> entry: map.entrySet()) { 
        	
        	System.out.print(entry.getKey() + ":" + entry.getValue() + "\t");
        	
       }*/
		// TODO Auto-generated method stub

		/*String strAbsPath = request.getServletPath(); 

		out.println(strAbsPath.substring(strAbsPath.lastIndexOf("/")+1)); 	*/
		
		//System.out.println(String2Date("2012-03-07 09:30:29"));
		
		//System.out.println(Date2String(new Date()));

	}
	
	public static String cutStr(String str,int cutLength,String addStr){
		if(str.length() > cutLength){
			return (str.substring(0, cutLength)) + addStr;
		}else{
			return str;
		}
		
	}
	
	public static boolean delFile(String path,String fileName){
		File f = new File(path,fileName);
			if(f.exists()){
				try{
					f.delete();
				}catch(Exception e){
					e.printStackTrace();
					return false;
				}
			}
			return true;
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, Object> uploadFile(HttpServletRequest req,String uploadPath){
		
		File savedFile = null;
		// 设置上传文件最大为 3M   
	    final long MAX_SIZE = 3 * 1024 * 1024;
	    // 允许上传的文件格式的列表   
	    final String[] allowedExt = new String[] {".gif",".jpg",".png",".jpeg"};   
	    //编码格式
	    final String enc = "utf-8";
	    String fieldName;
	    //缓存文件夹
	    String tempPath = uploadPath + "/tmp";
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置缓冲区大小，这里是4kb
        factory.setSizeThreshold(4096);
	    if (!new File(uploadPath).exists()) {
    	   new File(uploadPath).mkdirs();
        }
	 	      
	    if (!new File(tempPath).exists()) {
	    	  new File(tempPath).mkdirs();
	    }
	   //设置缓冲区目录
	   factory.setRepository(new File(tempPath));
	   // Create a new file upload handler
	   ServletFileUpload upload = new ServletFileUpload(factory);
	   // 设置最大文件尺寸，这里是4MB
	   upload.setSizeMax(MAX_SIZE);
	   
	   Map<String, Object> fieldMap = new LinkedHashMap<String, Object>();  

	   List<FileItem> items;
	   try {  
		   items = upload.parseRequest(req);
	
		   Iterator<FileItem> i = items.iterator();
		  
		   while (i.hasNext()) {
		      FileItem fi = (FileItem) i.next();
		      //如果是普通表单项目，显示表单内容
		      if(fi.isFormField()){
		    	  fieldName = fi.getFieldName();
		    	  fieldMap.put(fieldName,fi.getString(enc));       
		    	  if(fieldName.equals("model")){
		        	// System.out.println("KEY:"+fi.getString());
		    		//  modelName=fi.getString("UTF-8");
		          }
	           	  
	              }else{
	            	  //判断上传文件是否为空
		              if (fi.getSize()!=0 || !fi.getName().equals("")) {
		                  String Suffix = fi.getName().substring(fi.getName().lastIndexOf("."));
		                 // System.out.println(fullFile.getName());
	  
			            for (int allowFlag = 0; allowFlag < allowedExt.length; allowFlag++) {   
			                if (allowedExt[allowFlag].equals(Suffix))   
			                    break;   
			            }   
			            //判断文件后缀名
			            /*
			            if (allowFlag == allowedExtCount) {   
			                out.println("请上传以下类型的文件<br />");   
			                for (allowFlag = 0; allowFlag < allowedExtCount; allowFlag++){
			                	out.println(allowedExt[allowFlag]  + "&nbsp;&nbsp;&nbsp;");   
			                }   
			                    
			                return;
			              } 
			              */  
			              //modelImage=xmlHelper.getUUID()+Suffix;
			              System.out.println(uploadPath);
		                  savedFile = new File(uploadPath,"sss.jsp");
		                  fi.write(savedFile);
		              }
	              }
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return fieldMap;
	}
	
	 public static String formatXml(String str) throws Exception {
		  Document document = null;
		  document = DocumentHelper.parseText(str);
		  // 格式化输出格式
		  OutputFormat format = OutputFormat.createPrettyPrint();
		  format.setEncoding("gbk");
		  StringWriter writer = new StringWriter();
		  // 格式化输出流
		  XMLWriter xmlWriter = new XMLWriter(writer, format);
		  // 将document写入到输出流
		  xmlWriter.write(document);
		  xmlWriter.close();

		  return writer.toString();
	}
	 
	 public static Element String2XML(String str){
		 SAXReader saxReader = new SAXReader();  
         Document document;  
         Element incomingForm = null;
         try {  
             document = saxReader.read(new ByteArrayInputStream(str.getBytes()));  
             incomingForm = document.getRootElement();  
         } catch (DocumentException e) {  
            e.printStackTrace();  
        }
		return incomingForm;  
	 }
	 
		public static String Date2String(Date d){ 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			String datetime="";
			if(d!=null){
				datetime = sdf.format(d);
			}
		    
		    return datetime; 
		}
		
		public static String Date2String(Date d,String f){ 
			SimpleDateFormat sdf = new SimpleDateFormat(f); 
			String datetime="";
			if(d!=null){
				datetime = sdf.format(d);
			}
		    return datetime; 
		}
		
		public static Date String2Date(String str){ 
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			Date datetime = null;
			if(str != null){
				try {
					datetime = (Date) sdf.parseObject(str);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		    return datetime; 
		}

		public static String getUUID(){
			return UUID.randomUUID().toString(); 
		}
		
		public static Date getNowDate(){
			return new Date(); 
		}
		
		 public static String HTMLFilter(String message) {

		        if (message == null)
		            return (null);

		        char content[] = new char[message.length()];
		        message.getChars(0, message.length(), content, 0);
		        StringBuffer result = new StringBuffer(content.length + 50);
		        for (int i = 0; i < content.length; i++) {
		            switch (content[i]) {
		            case '<':
		                result.append("&lt;");
		                break;
		            case '>':
		                result.append("&gt;");
		                break;
		            case '&':
		                result.append("&amp;");
		                break;
		            case '"':
		                result.append("&quot;");
		                break;
		            case ' ':
		                result.append("&ensp;");
		                break;
		            default:
		                result.append(content[i]);
		            }
		        }
		        return (result.toString());

		    }
		
}

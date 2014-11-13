package com.Lns7;

import java.io.File;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class uploadFile {
	public uploadFile(){
	
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 uploadFile uf = new uploadFile();
		 //System.out.println(uf.containExt(".jpeg"));

	}
	
	public boolean containExt(String ext){
		boolean rtn = false;
		for (int i = 0; i < getAllowedExt().length; i++) {   
            if (allowedExt[i].equals(ext)){
            	rtn = true;
            }
            if(i < getAllowedExt().length && (rtn==false)){
            	rtn = false;
            }
        }
		return rtn;
	}
	
	public void save(){
		
		//System.out.println(getFileStream().getSize());
		
		if(getFileStream() == null){
			setFileName(null);
			return ;
		}
		
		if(getFileStream().getSize() != 0){
			String Suffix = null;
			
			Suffix = getFileStream().getName().substring(getFileStream().getName().lastIndexOf("."));
			setFileName(getFileId()+ Suffix);
			setSavedFile(new File(getSavePath(),getFileName()));
			//System.out.println(getSavePath());
			try {
				getFileStream().write(getSavedFile());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			setFileName(null);
		}
		
		
		
	}
	
	
	@SuppressWarnings("unchecked")
	public void upload(HttpServletRequest req){
		//自动创建文件夹
	    if (!new File(getSavePath()).exists()) {
	    	   new File(getSavePath()).mkdirs();
	    }
		 	      
	    if (!new File(getTempPath()).exists()) {
	    	  new File(getTempPath()).mkdirs();
	    }
	    
	    
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//设置缓冲区大小，这里是4kb
        factory.setSizeThreshold(getCacheSize());
 	    //设置缓冲区目录
 	    factory.setRepository(new File(getTempPath()));
	    // Create a new file upload handler
	    ServletFileUpload upload = new ServletFileUpload(factory);
	    // 设置最大文件尺寸，这里是4MB
	    upload.setSizeMax(getMAX_SIZE());
	    try {
	    	List<FileItem> items = upload.parseRequest(req);
			Iterator<FileItem> i = items.iterator();
			FileItem fi = null;
			
			while (i.hasNext()) {
			  setFileItem((FileItem) i.next());
			  fi = getFileItem();
			  if(fi.isFormField()){
				  setFieldName(fi.getFieldName());
				  setFieldMap(getFieldName(),fi.getString(getEnc()));
			  }else{
				  setFileStream(fi);
			  }
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
    }
	
	
	//保存路径
	String savePath = "uploadFile";

	File savedFile = null;
	//设置上传文件最大为 3M   
    long MAX_SIZE = 3 * 1024 * 1024;
    // 允许上传的文件格式的列表   
    String[] allowedExt = new String[] {".gif",".jpg",".png",".jpeg"};   
    //编码格式
    String enc = "utf-8";
    
    String fieldName = null;
    //缓存文件夹
    String tempPath = getSavePath() + "/tmp";
    //缓存区大小,单位k
    int cacheSize = 1024*4;

	Map<String, String> fieldMap = new LinkedHashMap<String, String>();  
	
	String fileName = null;
	
	String fileId = utilityHelper.getUUID();

	FileItem fileItem = null;
	
	FileItem FileStream = null;
	
	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	
    public FileItem getFileStream() {
		return FileStream;
	}

	public void setFileStream(FileItem fileStream) {
		FileStream = fileStream;
	}

	public FileItem getFileItem() {
		return fileItem;
	}

	public void setFileItem(FileItem fileItem) {
		this.fileItem = fileItem;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Map<String, String> getFieldMap() {
		return fieldMap;
	}

	public void setFieldMap(String k, String v) {
		this.fieldMap.put(k, v);
	}
	
	public int getCacheSize() {
		return cacheSize;
	}

	public void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
	}

	public String getTempPath() {
		return tempPath;
	}

	public void setTempPath(String tempPath) {
		this.tempPath = tempPath;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
    
	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getEnc() {
		return enc;
	}

	public void setEnc(String enc) {
		this.enc = enc;
	}

	public String[] getAllowedExt() {
		return allowedExt;
	}

	public void setAllowedExt(String[] allowedExt) {
		this.allowedExt = allowedExt;
	}

	public long getMAX_SIZE() {
		return MAX_SIZE;
	}

	public void setMAX_SIZE(long mAX_SIZE) {
		MAX_SIZE = mAX_SIZE;
	}

	public File getSavedFile() {
		return savedFile;
	}

	public void setSavedFile(File savedFile) {
		this.savedFile = savedFile;
	}

}

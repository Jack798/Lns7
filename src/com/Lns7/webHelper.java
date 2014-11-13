package com.Lns7;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.dom4j.*;
import org.dom4j.io.*;

public class webHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
    

	}

	
	 public static void redirect(HttpServletResponse res,String url){
		  try {
			res.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

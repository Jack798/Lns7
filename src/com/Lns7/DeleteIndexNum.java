package com.Lns7;

import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.io.OutputStreamWriter;  
  
public class DeleteIndexNum {  
  
    /**  
     * 在CSDN、javaeye 等各大IT网站复制实例代码时候，在每行代码前总会有行数序列  
     * 手动一个一个删除序列太麻烦，于是写了个方法自动删除  
     * 例如复制过来的代码：  
     *      001 第一行代码  
     *      002 第二行代码  
     *      003 第三行代码  
     *   
     * @param path01 要替换的代码路径  
     * @param path02 替换后代码的路径  
     * @param index 前缀数字位数  
     */    
    public static void getJavaCode(String path01, String path02,int index) {    
        FileInputStream fis = null;    
        InputStreamReader isr = null;    
        FileOutputStream fos = null;    
        OutputStreamWriter osw = null;    
        BufferedReader br = null;    
        BufferedWriter bw = null;    
        String line = null;    
        try {    
            fis = new FileInputStream(path01);    
            
            isr = new InputStreamReader(fis);    
            
           
            
            br = new BufferedReader(isr);    
        
            fos = new FileOutputStream(path02, true);    
            osw = new OutputStreamWriter(fos);    
            bw = new BufferedWriter(osw);    
        
            while ((line = br.readLine()) != null) {    
                if (line.length() > index) {
                    String newline = line.substring(index, line.length());    
                   // bw.write(newline + "\r\n");    
                    System.out.println(newline);    
                }    
            }    
        
        } catch (FileNotFoundException e) {    
            e.printStackTrace();    
        } catch (Exception e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                if (bw != null) {    
                    bw.close();    
                }    
                if (osw != null) {    
                    osw.close();    
                }    
                if (fos != null) {    
                    fos.close();    
                }    
                if (br != null) {    
                    br.close();    
                }    
                if (isr != null) {    
                    isr.close();    
                }    
                if (fis != null) {    
                    fis.close();    
                }    
            } catch (IOException e) {    
                e.printStackTrace();    
            }    
        
        }    
    }    
      
    /** 
     * @param args 
     * 1.txt和2.txt都在项目路径下 
     * 1.txt表示要去除序列行的文件 
     * 2.txt表示去除后的文件 
     *  
     * 控制台也会打印 
     */  
    public static void main(String[] args) {  
        getJavaCode("d:\\hanghao.txt","d:\\hanghao2.txt",0);  
    }  
}  
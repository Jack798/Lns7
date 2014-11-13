package com.Lns7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedReadAndBufferedWriter {
	public static BufferedInputStream bfr = null;
	 public static BufferedOutputStream bfw = null;

	 public static void main(String[] args) {
	  try {
	   /**  
	    * ��������������,ʹ�õ���õ�BufferedReader����BufferedWriter����Ϊ������readLine()��������  
	    * ��Ҫע�����BufferedReader����BufferedWriter�Ǵ��������������������ýڵ�����:FileInputStream(OutputStream),  
	    * FileReader(Writer),CharArrayInputStream(OutputStream),ByteArrayReader(Writer),StreamReader(Writer).  
	    * ��õĴ������У�BufferedReader(Writer),BufferedInputSteam(OutputStream),InputStreamReader(Writer),PrintStream,PrintWriter.  
	    * ����BufferedReader����BufferedWriter  
	    */
	   bfr = new BufferedInputStream(new FileInputStream("d:/input.txt"));

	   bfw = new BufferedOutputStream(new FileOutputStream("d:/output.txt"));

	   // ��������Ϊ������Ҫ��Դ�ļ���ÿ���ַ������жϣ����Բ���ʹ��BufferedReader��readLine��������ֻ��ʹ��read()������һ���ַ�һ���ַ��Ķ�ȡ   
	   int c = 0;
	   // n1, n2, n3, n4�ֱ����˼�¼������ȡ��4���ַ�   
	   int n1, n2, n3, n4;

	   outer1: while ((c = bfr.read()) != -1) {
	    // ��ȡ�ַ����������   
	    if (c >= 48 && c <= 57) {
	     n1 = c;
	     // �������ж������һ���ַ�   
	     while ((n2 = bfr.read()) != -1) {
	      // ����ڶ����ַ�ʱ���ֻ��ߵ��   
	      if ((n2 >= 48 && n2 <= 57) || n2 == 46) {
	       // ����ڶ����ǵ�   
	       if (n2 == 46) {
	        continue outer1;
	       }
	       // ����ڶ���������   
	       if (n2 >= 48 && n2 <= 57) {
	        // �жϵ�����   
	        while ((n3 = bfr.read()) != -1) {
	         // ����������ַ�ʱ���ֻ��ߵ��   
	         if ((n3 >= 48 && n3 <= 57) || n3 == 46) {
	          // �����������ȡ�����ǵ�   
	          if (n3 == 46) {
	           continue outer1;
	          }
	          // �����������ȡ����������   
	          if (n3 >= 48 && n3 <= 57) {
	           // �жϵ�4��   
	           while ((n4 = bfr.read()) != -1) {
	            // �����4�������ֻ����ַ�   
	            if (n4 == 46) {
	             continue outer1;
	            }
	            // ��4����ȡ�����ǵ���������ַ��������㣩   
	            else {
	             bfw.write(n1);
	             bfw.write(n2);
	             bfw.write(n3);
	             bfw.write(n4);
	             continue outer1;
	            }
	           }
	          }

	         }
	         // �����ȡ���ĵ�3���ַ��������ֻ��߲��ǵ㣬��n1,n2��n3һ��д���ļ�   
	         else {
	          bfw.write(n1);
	          bfw.write(n2);
	          bfw.write(n3);
	          continue outer1;
	         }

	        }

	       }
	      }
	      // ����ڶ�����ȡ���ĵڶ����ַ���������Ҳ���ǵ㣬��n1,n2һ��д���ļ�   
	      else {
	       bfw.write(n1);
	       bfw.write(n2);
	       continue outer1;
	      }
	     }
	    }
	    // ����������֣�ֱ��д��   
	    else {
	     bfw.write(c);
	    }
	   }

	  } catch (FileNotFoundException e) {
	   e.printStackTrace();
	  } catch (IOException e) {
	   e.printStackTrace();
	  } finally {
	   try {
	    bfw.flush();
	    bfr.close();
	    bfw.close();
	   } catch (IOException e) {
	    e.printStackTrace();
	   }
	  }
	 System.out.println("������ϣ�");
	 }
}

/* ת���ļ�����

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Convert {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename;//�����ת�����ļ���·��
		System.out.println("������Ҫת�����ļ����ڵ�·��");
		Scanner scanner=new Scanner(System.in);
		filename=scanner.next();
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		String outfilename;
		System.out.println("������ת�����ļ���·��,�����ļ����ֺͺ�׺��");
		outfilename=scanner.next();
		FileWriter bw=new FileWriter(outfilename);
		BufferedWriter bufw=new BufferedWriter(bw);
		String str=null;
		while((str=br.readLine())!=null){
			str=str.substring(str.indexOf('.')+1);
			System.out.println(str);
			bufw.write(str);
			bufw.newLine();
			bufw.flush();
		}
		
		bufw.close();
		bw.close();
		br.close();
		fr.close();
		scanner.close();
	}

}




 */

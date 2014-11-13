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
	    * 定义输入和输出流,使用的最常用的BufferedReader，和BufferedWriter，因为他们有readLine()方法可用  
	    * 需要注意的是BufferedReader，和BufferedWriter是处理流。在这里回忆下最常用节点流有:FileInputStream(OutputStream),  
	    * FileReader(Writer),CharArrayInputStream(OutputStream),ByteArrayReader(Writer),StreamReader(Writer).  
	    * 最常用的处理流有：BufferedReader(Writer),BufferedInputSteam(OutputStream),InputStreamReader(Writer),PrintStream,PrintWriter.  
	    * 其中BufferedReader，和BufferedWriter  
	    */
	   bfr = new BufferedInputStream(new FileInputStream("d:/input.txt"));

	   bfw = new BufferedOutputStream(new FileOutputStream("d:/output.txt"));

	   // 在这里因为我们需要对源文件的每个字符进行判断，所以不能使用BufferedReader的readLine方法。而只能使用read()方法，一个字符一个字符的读取   
	   int c = 0;
	   // n1, n2, n3, n4分别用了记录连续读取的4个字符   
	   int n1, n2, n3, n4;

	   outer1: while ((c = bfr.read()) != -1) {
	    // 读取字符如果是数字   
	    if (c >= 48 && c <= 57) {
	     n1 = c;
	     // 紧接着判断下面的一个字符   
	     while ((n2 = bfr.read()) != -1) {
	      // 如果第二个字符时数字或者点号   
	      if ((n2 >= 48 && n2 <= 57) || n2 == 46) {
	       // 如果第二个是点   
	       if (n2 == 46) {
	        continue outer1;
	       }
	       // 如果第二个是数字   
	       if (n2 >= 48 && n2 <= 57) {
	        // 判断第三个   
	        while ((n3 = bfr.read()) != -1) {
	         // 如果第三个字符时数字或者点号   
	         if ((n3 >= 48 && n3 <= 57) || n3 == 46) {
	          // 如果第三个读取到的是点   
	          if (n3 == 46) {
	           continue outer1;
	          }
	          // 如果第三个读取到的是数字   
	          if (n3 >= 48 && n3 <= 57) {
	           // 判断第4个   
	           while ((n4 = bfr.read()) != -1) {
	            // 如果第4个是数字或者字符   
	            if (n4 == 46) {
	             continue outer1;
	            }
	            // 第4个读取到的是点或者其他字符（除开点）   
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
	         // 否则读取到的第3个字符不是数字或者不是点，则将n1,n2，n3一起写入文件   
	         else {
	          bfw.write(n1);
	          bfw.write(n2);
	          bfw.write(n3);
	          continue outer1;
	         }

	        }

	       }
	      }
	      // 否则第二个读取到的第二个字符不是数字也不是点，则将n1,n2一起写入文件   
	      else {
	       bfw.write(n1);
	       bfw.write(n2);
	       continue outer1;
	      }
	     }
	    }
	    // 如果不是数字，直接写入   
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
	 System.out.println("处理完毕！");
	 }
}

/* 转换文件命名

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Convert {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename;//输入待转换的文件的路径
		System.out.println("请输入要转换的文件所在的路径");
		Scanner scanner=new Scanner(System.in);
		filename=scanner.next();
		FileReader fr=new FileReader(filename);
		BufferedReader br=new BufferedReader(fr);
		String outfilename;
		System.out.println("请输入转换后文件的路径,包含文件名字和后缀名");
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

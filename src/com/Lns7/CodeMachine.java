package com.Lns7;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.File;

public class CodeMachine
{
 /**
 * @auther badu 2009-11-5
 * @purpose deleting the line number in each row
 */
 public static void main(String [] args)
 {

      System.out.print("Please input the file name: ");
      Scanner in=new Scanner(System.in);
      String oldFileName=in.nextLine();
      //获取文件的类型，即后缀名
      int locate=oldFileName.lastIndexOf('.');
      String fileType=oldFileName.substring(locate,oldFileName.length());

      //正则表达式搜集 ^\d+\.   ^s+d+.
      
      //正则表达式，匹配行号和后面的点
      String regex="^[0-9]+//.";

        try
        {
   //File file=new File(oldFileName);
   BufferedReader fileIn=new BufferedReader(new FileReader(oldFileName));
   String newFileName="temp"+fileType;
   File tempFile=new File(newFileName);
   if(!tempFile.exists())
       tempFile.createNewFile();
   PrintWriter out=new PrintWriter(new FileWriter(newFileName));

   String str1;
   //逐行处理
   while((str1=fileIn.readLine())!=null)
   {
    //替换每行中的行号
    out.write(str1.replaceAll(regex,""));
    //得到系统平台下的换行符，windows平台下是“/r/n”,Unix下是“/r”
    String newLine=System.getProperty("line.separator");
    out.write(newLine+"/n");
   }
   //输入输出流必须关闭，否则文件无法删除，也无法重命名
   fileIn.close();
   out.close();
            new File(oldFileName).delete();
   tempFile.renameTo(new File(oldFileName));
   System.out.println("The End !!");

  }
  catch(Exception e)
  {
          e.printStackTrace();
  }
 }
}
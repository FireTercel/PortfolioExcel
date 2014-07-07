package io.stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import poi.fileUitl.FileCreate;

public class MessageFile {
	private static File file;
	private static FileReader filereader;
	private static FileWriter filewriter;
	private static BufferedReader bufferedreader; 
	private static BufferedWriter bufferedwriter;
	private static FileCreate fileCreate;
	
	public static String message;
	 
	public MessageFile(){
		 
	}
	public MessageFile(String FileURL){
		file=new File(FileURL);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MessageFile msgFile=new MessageFile("D:/aa.txt");
		for(int i=0;i<5;i++){
			msgFile.message("abc");
		}

	}
	public void test() {
        file = new File("D:/aa.txt");
        
        file.mkdirs();
        
        StringBuffer message = new StringBuffer();
        try {
        	
        	filewriter = new FileWriter(file,true);// 初始化输出流
        	bufferedwriter = new BufferedWriter(filewriter);// 初始化输出字符流
        	bufferedwriter.write("my txt");// 写文件
        	bufferedwriter.flush();
        	bufferedwriter.close();
        	filewriter.close();
             
        	filereader = new FileReader(file);// 初始化输入流
        	bufferedreader = new BufferedReader(filereader);// 初始化输入字符流
        	message.append(bufferedreader.readLine().toString());// 按行读文件
            System.out.println("文件内容是：" + message);
            bufferedreader.close();
            filereader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void message(String msg){
		fileCreate=new FileCreate();
		String url=fileCreate.createFile();
		file = new File(url+"\\"+"日志.txt");
		message = msg;
		String time;
		
		try{
			filewriter = new FileWriter(file,true);// 初始化输出流
        	bufferedwriter = new BufferedWriter(filewriter);// 初始化输出字符流
        	Date date=new Date();
        	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        	time=sdf.format(date);
        	
        	bufferedwriter.write(time+"     "+message);// 写文件
        	bufferedwriter.newLine();
        	bufferedwriter.flush();
        	bufferedwriter.close();
        	filewriter.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

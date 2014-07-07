package data.thread;

import java.util.Scanner;

/**
 * 线程类，用于获得实时指令，继续运行、停止运行线程。
 * @author 唐东宇
 *
 */
public class StatusThread implements Runnable{
 
	private String info="";
	private static boolean flag=false; 
	private Scanner input;
	
	public boolean isFlag() {
		return flag; 
	}
 
	@SuppressWarnings("static-access")
	public void setFlag(boolean flag) {
		this.flag = flag; 
	}
	
	public StatusThread(){
		
	}
	
	public StatusThread(String info){
		this.info=info;
	}
	
	public boolean changeStatue(String  input){
		
		
		//判断input是否等于字符G,若为G,则修改flag为true,否则继续线程.
		if(input.equals("G")){
			setFlag(true);
			return isFlag();
		}
		else
			System.out.println("NO NO NO !");
			return isFlag();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
		input=new Scanner(System.in);
		info=input.next();
		try {
			while(flag==false){
				
				flag=changeStatue(info);
				if(!info.equals("G")){
					info=input.next();
				}
				
				System.out.println(info);
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

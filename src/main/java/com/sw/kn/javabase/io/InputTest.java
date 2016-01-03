package com.sw.kn.javabase.io;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.BeforeClass;
import org.junit.Test;

public class InputTest {
	private static  File file ;
	
	@BeforeClass
	public  static void setup(){
		file = new File("/Users/shaowei/project/andes.shard/20151204_465990_andes-helloworld_1/src/test/java/com/alibaba/antis/test/instance/header-content.html");
	}
	
	@Test
	/**
	 * 使用普通的inputStream
	 */
	public void originInputStream() throws IOException{
		InputStream is =  new FileInputStream(file);
		
		//1.一次性转byte数组
		byte[] bs =new byte[is.available()];
		long startTime = System.currentTimeMillis();
		is.read(bs);
		long finishTime= System.currentTimeMillis();
		System.out.println("inputStream.read time:"+(finishTime-startTime));
		//转成字符串
		String str = new String(bs,"utf-8");
		//System.out.println(str);
		
		//2.多次
		byte[] bs1 =new byte[1024];
		long startTime1 = System.currentTimeMillis();
		
		while (is.read(bs1)!=-1){
			System.out.println(bs1);
			String str1 = new String(bs1,"utf-8");
			//System.out.println(str1);
		}
		long finishTime1= System.currentTimeMillis();
		System.out.println("inputStream.read time:"+(finishTime1-startTime1));
	}
	
	@Test
	/**
	 * 2使用链式流处理器-bufferInputStream，效率会得到提高
	 */
	public void bufferedInputStream() throws IOException{
		
		InputStream is =  new FileInputStream(file);
		BufferedInputStream bis = new BufferedInputStream(is); 
		
		byte[] bs =new byte[bis.available()];
		long startTime = System.currentTimeMillis();
		bis.read(bs);
		long finishTime= System.currentTimeMillis();
		System.out.println("inputStream.read time:"+(finishTime-startTime));
		
		//转成字符串
		String str = new String(bs,"utf-8");
		//System.out.println(str);
	}
	
	@Test
	/**
	 * 3 ByteArraInputStream一般作为程序缓冲区，从字节数组读取数据
	 */
	public void byteArrayIsTest() throws IOException{
		byte[] out = new byte[]{1,2,3};
		
		//ByteArrayInputStream: 可以将字节数组转化为输入流
		ByteArrayInputStream bin=new ByteArrayInputStream(out);
		int b=0;
		while( (b=bin.read())!=-1)
		{
		  System.out.println(b);
		}
		bin.close();
	}
	
	
	@Test
	/**
	 * 4 根据String生成input
	 */
	public void string2Input(){
		//1 string 转input
		String str = "this is a beautiful city";
		InputStream is = new ByteArrayInputStream(str.getBytes());
	}
}

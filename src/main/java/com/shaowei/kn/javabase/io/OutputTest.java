package com.shaowei.kn.javabase.io;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberInputStream;
import java.util.Date;

public class OutputTest {
	private static  File file ;
	
	@BeforeClass
	public  static void setup(){
		file = new File("/Users/shaowei/project/andes.shard/20151204_465990_andes-helloworld_1/src/test/java/com/alibaba/antis/test/instance/header-content.html");
	}
	
	@Test
	/**
	 * bos一般作为程序的缓冲
	 * @throws IOException 
	 */
	public void outputStream() throws IOException{
		ByteArrayOutputStream bos= new ByteArrayOutputStream();
		bos.write(10);
		bos.write(12);
		byte[] out = bos.toByteArray();
		for(int i=0;i<out.length;i++)
		{
		  System.out.println(out[i]);
		}
		bos.close();
		
		
	}
	
}

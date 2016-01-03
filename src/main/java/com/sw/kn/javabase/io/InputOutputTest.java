package com.sw.kn.javabase.io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.junit.BeforeClass;
import org.junit.Test;

public class InputOutputTest {
	private static  File file ;
	
	@BeforeClass
	public  static void setup(){
		file = new File("/Users/shaowei/project/andes.shard/20151204_465990_andes-helloworld_1/src/test/java/com/alibaba/antis/test/instance/header-content.html");
	}
	
	@Test
	public void in2out() throws IOException{
		InputStream is =  new FileInputStream(file);
		File outputFile = new File("test.output.html");
		OutputStream os = new FileOutputStream(outputFile);
		
		byte[] bs = new byte[1024];
		while(is.read(bs)!=-1){
			os.write(bs);
		}
	}
	
	//直接使用outputStream.getInputStream();
	public void out2in(){
		
	}
}

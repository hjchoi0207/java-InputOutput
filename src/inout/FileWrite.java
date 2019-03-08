package inout;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileWrite {

	public static void main(String[] args) {
		
		OutputStream outputStream =null;
		
		try {
			outputStream = new FileOutputStream("C:\\Users\\USER\\javatxt\\hello.txt");
			String data = "Hello java world!!";
			byte[] arr = data.getBytes(); //data 추출
			
			try {
				outputStream.write(arr,0,5); //Hello
				//outputStream.write(arr);	//Hello java world!!
			}catch (IOException e) {
				e.printStackTrace();
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				if(outputStream != null) outputStream.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}

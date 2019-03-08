package inout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileIo {

	public static void main(String[] args) {
		
		//read()
		InputStream inputStream = null;
		try {
			
			inputStream = new FileInputStream("C:\\Users\\USER\\javatxt\\hello.txt");
			int data =0;
			
			while(true) {
				
				try {
					data = inputStream.read();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				if(data == -1) break; //no more read data
				System.out.println("data : " + data);
			}
		} catch(FileNotFoundException e) { //file not exist
			e.printStackTrace();
		}finally {
			try {
				if(inputStream != null) inputStream.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}

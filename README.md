## java-입력과 출력
Java에서는 입력과 출력에 InputStream과 OutputStream을 기반으로 하여 다양한 Class들을 제공해준다.
여기서 가장 기본이 되는 InputStream, OutputStream을 먼저 알아보겠다.

```java
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
					data = inputStream.read(); //read to end of file 
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				if(data == -1) break; //no more read data
				System.out.println("data : " + data); //or
			}
		} catch(FileNotFoundException e) { //file not exist
			e.printStackTrace();
		}finally {
			try {
				if(inputStream != null) inputStream.close(); //항상 file을 close
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
```
텍스트 파일의 경로를 지정하여 파일의 끝까지 읽어들이는 코드이다. FIleInputStream상의 경로에는 "Hello java"가 적힌 파일이 존재한다

> 실행결과에 나타나는 정수는 Hello java라는 문자 하나하나를(공백포함) ASCII로 나타낸다.
```
data : 72
data : 101
data : 108
data : 108
data : 111
data : 32
data : 106
data : 97
data : 118
data : 97
data : 13
data : 10
```

- 간단한 입력을 알아보았고 이제 출력에 관해서도 프로그램을 작성해 보았다. 입력과 구성은 비슷하며 OutputStream을 이용한다.
```java
		try {
			outputStream = new FileOutputStream("C:\\Users\\USER\\javatxt\\hello.txt");
			String data = "Hello java world!!";
			byte[] arr = data.getBytes(); //data 추출
			
			try {
				outputStream.write(arr,0,5);   //Hello
				//outputStream.write(arr);	 //Hello java world!!
			}catch (IOException e) {
				e.printStackTrace();
			}
			...
```
먼저 경로를 지정하여 입력할 데이타를 선언한다 (String data) 그리고 arr배열에 data의 String을 추출하여 파일에 입력한다.
이 떄 모든 String을 입력할 수도있으며 offset과 length를 이용하여 스트링의 특정부분만을 입력할 수도있다.
주석처리된 부분이 전자이며 그 위의 코드가 후자이다. **(공백또한 길이에 들어간다)**


### 그럼 이제 FileInput , Output Stream을 이용하여 동시에 입,출력을 다뤄보자

```java
public static void main(String[] args) {
		InputStream inputStream =null;
		OutputStream outputStream = null;
		
		try {
			inputStream = new FileInputStream("C:\\Users\\USER\\javatxt\\hello.txt");
			outputStream = new FileOutputStream("C:\\Users\\USER\\javatxt\\hellocopy.txt");
			
			byte[] arr = new byte[3]; // 3byte 단위로 데이터 처리
			
			while(true) {
				int len = inputStream.read(arr);
				if(len == -1)break;
				outputStream.write(arr, 0, len);
```
inmputStream의 내용을 OutputStream의 경로에 존재하는 txt파일에 복사하는 과정이다. 3byte 단위로 읽어오고난 후 outputStream에 write한다.

- 추가적으로 예외처리는 필수이다. (CheckedException)

### File을 다루는 코드에서는 항상 예외처리를 (FileNotFound, EOF 등) 해주어야 한다. 얼마전에 배운 try를 이용해서 익숙하지 않을 수 있지만 전체적인 형식은 동일하니 여러번 반복해서 코드를 입력하다 보면 빨리 익숙해질 것이라고 생각한다.

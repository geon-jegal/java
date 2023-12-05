package day22;

//import java.util.*;
import java.io.*;

public class Day22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("byte");
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		try {
            // Provide file paths without unnecessary double quotes
            File sourceFile = new File("C:\\a.pdf");
            File destinationFile = new File("b.pdf");

            // Use try-with-resources to automatically close streams
            try (FileInputStream fin = new FileInputStream(sourceFile);
                 FileOutputStream fout = new FileOutputStream(destinationFile)) {

                int i;
                while ((i = fin.read()) != -1) {
                    fout.write(i);
                }
                
                System.out.println("File copied successfully.");
            }
        } catch (IOException e) {
            System.out.println("입출력 오류: " + e.getMessage());
        }
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime);
		
		System.out.println("buffer");
		long beforeTime2 = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		try (BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream("b.pdf"));
	             FileInputStream fin = new FileInputStream("C:\\a.pdf")) {

	            int c;
	            while ((c = fin.read()) != -1) {
	                bout.write(c);
	            }

	            System.out.println("File copied successfully.");
	        } catch (IOException e) {
	            System.out.println("입출력 오류: " + e.getMessage());
	        }
		
		long afterTime2 = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime2 = (afterTime2 - beforeTime2)/1000; //두 시간에 차 계산
		System.out.println("시간차이(m) : "+secDiffTime2);
		}
}
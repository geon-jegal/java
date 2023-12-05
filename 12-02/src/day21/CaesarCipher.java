package day21;

import java.io.*;

public class CaesarCipher {

	// 파일 암호화
	public static String caesarCipher(String text, int shift) {
	    StringBuilder result = new StringBuilder();

	    for (char c : text.toCharArray()) {
	        if (Character.isLetter(c)) {
	            char base = Character.isLowerCase(c) ? 'a' : 'A';
	            char encryptedChar = (char) ((c - base + shift + 26) % 26 + base);
	            result.append(encryptedChar);
	        } else {
	            result.append(c);
	        }
	    }

	    return result.toString();
	}
	
    // 파일 생성 함수
    public static void createInputFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 암호화 함수
    public static void encrypt(String inputFilePath, String outputFilePath, int shift) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            StringBuilder encryptedText = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                String encryptedLine = caesarCipher(line, shift);
                encryptedText.append(encryptedLine).append("\n");
                writer.write(encryptedLine + "\n");
            }

            System.out.println("Encryption completed. Encrypted result:\n" + encryptedText);
            System.out.println("Encrypted file created: " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 복호화 함수
    public static void decrypt(String inputFilePath, String outputFilePath, int shift) {
        StringBuilder decryptedText = new StringBuilder();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String decryptedLine = caesarCipher(line, -shift);
                decryptedText.append(decryptedLine).append("\n");
                writer.write(decryptedLine + "\n");
            }

            System.out.println("Decryption completed. Decrypted result:\n" + decryptedText);
            System.out.println("Recovered file created: " + outputFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 2개의 파일이 동일한지 확인하는 함수
    public static boolean compareFiles(String filePath1, String filePath2) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
             BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))) {

            String line1, line2;
            while ((line1 = reader1.readLine()) != null && (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) {
                    return false;
                }
            }

            // Check if both files have the same number of lines
            return reader1.readLine() == null && reader2.readLine() == null;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static void main(String[] args) {
        String inputFilePath = "input.txt";
        String encryptedFilePath = "enc.txt";
        String decryptedFilePath = "recover.txt";
        int shift = 3;

        // 입력 파일 생성
        String inputContent = "Hello. My name is Geon JeGal.";
        createInputFile(inputFilePath, inputContent);
        System.out.println("Input file created: " + inputFilePath);

        // 암호화
        encrypt(inputFilePath, encryptedFilePath, shift);

        // 복호화
        decrypt(encryptedFilePath, decryptedFilePath, shift);

        // 입력 파일과 복호화 결과 비교
        if (compareFiles(inputFilePath, decryptedFilePath)) {
            System.out.println("Input file and recovered file are the same.");
        } else {
            System.out.println("Input file and recovered file are different.");
        }
    }
}

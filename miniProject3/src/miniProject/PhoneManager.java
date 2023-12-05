package miniProject;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class PhoneManager {
    private HashMap<Integer, Phone> phoneMap;
    private Scanner sc;

    public PhoneManager() {
        this.phoneMap = new HashMap<>();
        this.sc = new Scanner(System.in); // Scanner 객체를 생성
        loadFromFile("phoneData.txt");
    }

    private void insert() {
        System.out.println("연락처의 타입을 입력하시요.(일반 = 0, 대학 = 1, 회사 = 2)");
        int type = sc.nextInt();

        System.out.print("이름: ");
        String name = sc.next();

        System.out.print("연락처: ");
        int num = sc.nextInt();

        if(type == 0) {
            phoneMap.put(num, new Phone(num, name));
        } else if (type == 1) {
            System.out.print("전공: ");
            String mjr = sc.next();

            System.out.print("학년: ");
            int grd = sc.nextInt();

            phoneMap.put(num, new PhoneUniv(num, name, grd, mjr));
        } else if (type == 2) {
            System.out.print("회사명: ");
            String comp = sc.next();

            phoneMap.put(num, new PhoneComp(num, name, comp));
        }
    }
    
    private void search(int num) {
        Phone phone = phoneMap.get(num);
        if (phone != null) {
            phone.Show();
        } else {
            System.out.println(num + "을(를) 찾을 수 없습니다.");
        }
    }

    private void delete(int num) {
        Phone phone = phoneMap.get(num);
        if (phone != null) {
            phoneMap.remove(num);
            System.out.println(num + "을(를) 삭제했습니다.");
        } else {
            System.out.println(num + "을(를) 찾을 수 없습니다.");
        }
    }

    private void displayAll() {
        if (phoneMap.isEmpty()) {
            System.out.println("저장된 연락처가 없습니다.");
            return;
        }

        for (Phone phone : phoneMap.values()) {
            phone.Show();
        }
    }
    
 // 파일로 저장하는 메서드
    public void saveToFile(String fileName) {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(phoneMap);
            oos.close();
            fos.close();
            System.out.println("데이터가 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("데이터 저장 중 오류가 발생했습니다.");
        }
    }

    public void loadFromFile(String fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            phoneMap = (HashMap<Integer, Phone>) ois.readObject();
            ois.close();
            fis.close();
            System.out.println("데이터가 성공적으로 불러와졌습니다.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("데이터 불러오기 중 오류가 발생했습니다. (클래스를 찾을 수 없음)");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("데이터 불러오기 중 오류가 발생했습니다.");
        }
    }

    
    
    public void run() {
        while (true) {
            System.out.println("전화번호 관리 프로그램");
            System.out.println("1. 데이터 입력");
            System.out.println("2. 데이터 검색");
            System.out.println("3. 데이터 삭제");
            System.out.println("4. 전체 데이터 출력");
            System.out.println("5. 프로그램 종료");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    this.insert();
                    break;
                case 2:
                    System.out.println("검색할 번호를 입력하세요: ");
                    int num = sc.nextInt();
                    this.search(num);
                    break;
                case 3:
                    System.out.println("삭제할 번호를 입력하세요: ");
                    int Delete = sc.nextInt();
                    this.delete(Delete);
                    break;
                case 4:
                    this.displayAll();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close(); // 프로그램 종료 시에 Scanner를 닫아줍니다.
                    try {
                        saveToFile("phoneData.txt"); // 프로그램 종료 시에 파일로 저장
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("데이터 저장 중 오류가 발생했습니다.");
                    }
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }
}

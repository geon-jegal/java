package miniProject;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PhoneManager {
	private HashSet<Phone> phoneSet;
    private Scanner sc;

    public PhoneManager() {
    	this.phoneSet = new HashSet<>();
        this.sc = new Scanner(System.in); // Scanner 객체를 생성
        loadFromFile("phoneData.dat");
    }

    private void insert() {
        System.out.println("연락처의 타입을 입력하시요.(일반 = 0, 대학 = 1, 회사 = 2)");
        int type = sc.nextInt();

        System.out.print("이름: ");
        String name = sc.next();

        System.out.print("연락처: ");
        String num = sc.next();

        // 중복 체크
        boolean isDuplicate = false;
        Iterator<Phone> iterator = phoneSet.iterator();
        while (iterator.hasNext()) {
            Phone existingPhone = iterator.next();
            if (existingPhone.getNum().equals(num) && existingPhone.getName().equals(name)) {
                isDuplicate = true;
                if (existingPhone.getClass() == Phone.class && (type == 1 || type == 2)) {
                    // 기존 데이터가 슈퍼클래스이고 새로운 데이터가 자식클래스인 경우 교체
                    iterator.remove();
                    if (type == 1) {
                        System.out.print("전공: ");
                        String mjr = sc.next();

                        System.out.print("학년: ");
                        int grd = sc.nextInt();

                        phoneSet.add(new PhoneUniv(num, name, grd, mjr));
                        System.out.println("기존 데이터를 교체했습니다.");
                    } else if (type == 2) {
                        System.out.print("회사명: ");
                        String comp = sc.next();

                        phoneSet.add(new PhoneComp(num, name, comp));
                        System.out.println("기존 데이터를 교체했습니다.");
                    } else {
                        // 새로운 데이터가 슈퍼클래스인데 기존 데이터가 자식클래스인 경우 교체하지 않음
                        System.out.println("이미 중복된 데이터가 있습니다.");
                    }
                } else if (existingPhone.getClass() != Phone.class && type == 0) {
                    // 기존 데이터가 자식클래스이고 새로운 데이터가 슈퍼클래스인 경우 교체하지 않음
                    System.out.println("이미 중복된 데이터가 있습니다.");
                } else {
                    // 중복된 경우 메시지 출력
                    System.out.println("이미 중복된 데이터가 있습니다.");
                }
                break;
            }
        }

        // 중복되지 않은 경우 데이터 추가
        if (!isDuplicate) {
            if (type == 0) {
                phoneSet.add(new Phone(num, name));
            } else if (type == 1) {
                System.out.print("전공: ");
                String mjr = sc.next();

                System.out.print("학년: ");
                int grd = sc.nextInt();

                phoneSet.add(new PhoneUniv(num, name, grd, mjr));
            } else if (type == 2) {
                System.out.print("회사명: ");
                String comp = sc.next();

                phoneSet.add(new PhoneComp(num, name, comp));
            }
            System.out.println("데이터를 추가했습니다.");
        }
    }

    
    private void search(String num) {
    	boolean found = false;
        for (Phone phone : phoneSet) {
            if (phone.getNum() == num) {
                phone.Show();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(num + "을(를) 찾을 수 없습니다.");
        }
    }

    private void delete(String num) {
    	Iterator<Phone> iterator = phoneSet.iterator();
        boolean found = false;
        while (iterator.hasNext()) {
            Phone phone = iterator.next();
            if (phone.getNum() == num) {
                iterator.remove();
                System.out.println(num + "을(를) 삭제했습니다.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(num + "을(를) 찾을 수 없습니다.");
        }
    }

    private void displayAll() {
    	if (phoneSet.isEmpty()) {
            System.out.println("저장된 연락처가 없습니다.");
            return;
        }

        for (Phone phone : phoneSet) {
            phone.Show();
        }
    }

    // 파일로 저장하는 메서드
    public void saveToFile(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(phoneSet);
            System.out.println("데이터를 파일에 저장했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("데이터 저장 중 오류가 발생했습니다.");
        }
    }

    // 파일을 읽어오는 메서드
    public void loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            phoneSet = (HashSet<Phone>) ois.readObject();
            System.out.println("데이터를 파일에서 불러왔습니다.");
        } catch (IOException | ClassNotFoundException e) {
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
                    String num = sc.next();
                    this.search(num);
                    break;
                case 3:
                    System.out.println("삭제할 번호를 입력하세요: ");
                    String Delete = sc.next();
                    this.delete(Delete);
                    break;
                case 4:
                    this.displayAll();
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    sc.close(); // 프로그램 종료 시에 Scanner를 닫아줍니다.
                    try {
                        saveToFile("phoneData.dat"); // 프로그램 종료 시에 파일로 저장
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

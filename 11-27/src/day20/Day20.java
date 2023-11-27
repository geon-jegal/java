package day20;

//import java.util.*;

public class Day20 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberManager m = new MemberManager();
		Member m1 = new Member(101, "Lee");
		Member m2 = new Member(102, "Kim");
		Member m3 = new Member(103, "Park");
		Member m4 = new Member(104, "Park");
		Member m5 = new Member(101, "Lee2");
		Member m6 = new Member(105, "Lee2");
		
		System.out.println("insert 시작");
		m.addMember(m1);
		m.addMember(m2);
		m.addMember(m3);
		m.addMember(m4);
		m.addMember(m5);
		m.addMember(m6);
		
		System.out.println("\nPrint All");
		m.showAll();
		
		System.out.println("\ndelete 시작");
		m.removeMember(1);
		m.removeMember(104);
		
		System.out.println("\n Search 시작");
		m.searchMember(103);
		m.searchMember(110);
		
		System.out.println("\nPrint All");
		m.showAll();
		
		
		/*
		TreeMap<Integer, String> map = new TreeMap<>();
		// Key-Value 기반 데이터 저장
		map.put(45, "Brown");
		map.put(37, "James");
		map.put(23, "Martin");
		// Key만 담고 있는 컬렉션 인스턴스 생성
		Set<Integer> ks = map.keySet();
		// 전체 Key 출력 (for-each문 기반)
		for(Integer n : ks)
		System.out.print(n.toString() + '\t');
		System.out.println();
		// 전체 Value 출력 (반복자 기반)
		for(Iterator<Integer> itr = ks.iterator(); itr.hasNext(); )
		System.out.print(map.get(itr.next()) + '\t');
		System.out.println();
		*/
		}
}
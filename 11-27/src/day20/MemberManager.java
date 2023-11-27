package day20;

import java.util.*;
//import java.util.Comparator;

public class MemberManager {
	private TreeMap<Integer, Member> m;
	
	public MemberManager() {
		m = new TreeMap<Integer, Member>(new AgeComparator());
	}
	
	public void addMember(Member M) {
		System.out.println(M + " 삽입");
		Set<Integer> k = m.keySet();
		for(Integer n : k) {
			if(M.getID() == m.get(n).getID()) {
				System.out.println("동일한 ID가 이미 등록되어 있습니다.");
				return;
			}
		}
		m.put(M.getID(),M);
	}
	
	public void removeMember(int i) {
		System.out.println("ID: " + i + "번 삭제");
		
		Set<Integer> k = m.keySet();
		for(Integer n : k) {
			if(i == m.get(n).getID()) {
				System.out.println("ID: " + m.get(n).getID() + "를 삭제하였습니다.");
				m.remove(n);
				return;
			}
		}
		System.out.println("해당 ID가 존재하지 않습니다.");
	}
	
	public void searchMember(int i) {
		System.out.println("ID: " + i + "번 검색");
		Set<Integer> k = m.keySet();
		for(Integer n : k) {
			if(i == m.get(n).getID()) {
				System.out.println("검색한 데이터[" + m.get(n) + "]");
				return;
			}
		}
		System.out.println("해당 데이터가 존재하지 않습니다.");
	}
	
	public void showAll() {	
		Set<Integer> k = m.keySet();
		for(Integer n : k) {
			System.out.println(m.get(n));
		}
	}
}
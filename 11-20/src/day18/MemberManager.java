package day18;

import java.util.*;

public class MemberManager {
	private ArrayList<Member> m;
	
	public MemberManager() {
		m = new ArrayList<Member>();
	}
	
	public void addMember(Member M) {
		System.out.println(M + " 삽입");
		for(Member member : m) {
			if(M.getID() == member.getID()) {
				System.out.println("동일한 ID가 이미 등록되어 있습니다.");
				return ;
			}
		}
		m.add(M);
	}
	
	public void removeMember(int i) {
		System.out.println("ID: " + i + "번 삭제");
		for(int j = 0; j < m.size(); j++) {
			if(i == m.get(j).getID()) {
				System.out.println("ID: " + m.get(j).getID() + "를 삭제하였습니다.");
				m.remove(j);
				return ;
			}
		}
		System.out.println("해당 ID가 존재하지 않습니다.");
	}
	
	public void showAll() {
		for (Member member : m) {
	        System.out.println(member);
	    }
	}
}
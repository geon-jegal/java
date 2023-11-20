package day18;

import java.util.*;

public class MemberManager {
	private ArrayList<Member> m;
	
	public MemberManager() {
		m = new ArrayList<Member>();
	}
	
	public void addMember(Member M) {
		for(Member member : m) {
			if(M.getID() == member.getID()) {
				System.out.println("동일한 ID가 이미 등록되어 있습니다.");
				return ;
			}
		}
		m.add(M);
	}
	
	public void removeMember(int i) {
		for(int j = 0; j < m.size(); j++) {
			if(i == m.get(j).getID()) {
				m.remove(j);
				System.out.println("해당 ID를 삭제하였습니다.");
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

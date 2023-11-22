package day19;

import java.util.*;

public class MemberManager {
	private HashSet<Member> m;
	
	public MemberManager() {
		m = new HashSet<Member>();
	}
	
	public void addMember(Member M) {
		System.out.println(M + " 삽입");
		m.add(M);
	}
	
	public void removeMember(int i) {
		System.out.println("ID: " + i + "번 삭제");
		Iterator<Member> itr = m.iterator();
		while(itr.hasNext()) {
			Member o = itr.next();
			if(i == o.getID()) {
				System.out.println("ID: " + o.getID() + "를 삭제하였습니다.");
				m.remove(o);
				return;
			}
		}
		System.out.println("해당 ID가 존재하지 않습니다.");
	}
	
	public void showAll() {	
		Iterator<Member> itr = m.iterator();
		while(itr.hasNext()) System.out.println(itr.next());
	}
}
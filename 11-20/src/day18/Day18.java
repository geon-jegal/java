package day18;

public class Day18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberManager m = new MemberManager();
		Member m1 = new Member(101, "Lee");
		Member m2 = new Member(102, "Kim");
		Member m3 = new Member(103, "Park");
		Member m4 = new Member(104, "Park");
		Member m5 = new Member(101, "Kim");
		
		System.out.println("insert 시작");
		m.addMember(m1);
		m.addMember(m2);
		m.addMember(m3);
		m.addMember(m4);
		m.addMember(m5);
		
		System.out.println("\nPrint All");
		m.showAll();
		
		System.out.println("\ndelete 시작");
		m.removeMember(1);
		m.removeMember(101);
		
		System.out.println("\nPrint All");
		m.showAll();
	}

}
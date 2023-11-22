package day19;

public class Member{

	private int ID;
	private String name;
	
	public Member(int i, String n) {
		this.ID = i;
		this.name = n;
	}
	
	public String toString() {
		return "ID: " + this.ID + " Name : " + this.name;
	}
	
	public int getID() {
		return this.ID;
	}
	
	/*
    public boolean equals(Member m) {
        return ID == m.hashCode();
    }
    */
	@Override
    public boolean equals(Object obj) {
		/*
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        */
        Member member = (Member) obj;
        return ID == member.ID;
    }

    @Override
    public int hashCode() {
        return ID;
    }
}
package com.leonardchow.club.model;

/**
 * Created by leonardchow on 5/25/2017.
 */
public class Member extends Person implements Comparable<Member> {
    private int memberNumber;

    public Member (String surname, String firstName, String secondName, int memberNumber) {
        super(surname, firstName, secondName);
        this.memberNumber = memberNumber;
    }

    public Member  (String surname, String firstName, int memberNumber) {
        this(surname, firstName, "", memberNumber);
    }

    public int getMemberNumber() {
        return memberNumber;
    }

    public String toString() {
        return super.toString() + ", number: " + getMemberNumber();
    }

	@Override
	public int compareTo(Member o) {
		return this.getMemberNumber() - o.getMemberNumber();
	}
}

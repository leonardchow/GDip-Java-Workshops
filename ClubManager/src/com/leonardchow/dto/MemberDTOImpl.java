package com.leonardchow.dto;

public class MemberDTOImpl extends PersonDTOImpl implements MemberDTO {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int DEFAULT_MEM_NUM = 0;
	private int memberNumber;
	
    public MemberDTOImpl() {
		super();
	}

	public MemberDTOImpl (String surname, String firstName, String secondName, int memberNumber) {
        super(surname, firstName, secondName);
        this.memberNumber = memberNumber;
    }

    public MemberDTOImpl  (String surname, String firstName, int memberNumber) {
        this(surname, firstName, "", memberNumber);
    }
    
    public MemberDTOImpl (String surname, String firstName, String secondName) {
        this(surname, firstName, secondName, DEFAULT_MEM_NUM);
    }
    
    public MemberDTOImpl  (String surname, String firstName) {
        this(surname, firstName, "");
    }
    
    @Override
    public int getMemberNumber() {
        return memberNumber;
    }
    
    @Override
    public void setMemberNumber(int memberNumber) {
    	this.memberNumber = memberNumber;	
    }
    
    @Override
    public String toString() {
        return super.toString() + ", number: " + getMemberNumber();
    }

	@Override
	public int compareTo(MemberDTO o) {
		return this.getMemberNumber() - o.getMemberNumber();
	}

}

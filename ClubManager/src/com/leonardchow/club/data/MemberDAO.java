package com.leonardchow.club.data;

import java.util.List;

import com.leonardchow.club.model.Member;
import com.leonardchow.dto.MemberDTO;

public interface MemberDAO {
	public Boolean createMember(MemberDTO member);
//	public Member createMember(String surname, String firstName);
//	public Integer updateMember(int memberNumber, String surname, String firstName, String secondName);
	public Integer updateMember(MemberDTO member);
	public int removeMember(int memberNumber);
	public void listMember(String name);
	public void listAllMembers();
	public MemberDTO getMemberByID(int id);
	public List<MemberDTO> getMemberByName(String name);
	public MemberDTO getFirstMemberByName(String name);
	
	
}

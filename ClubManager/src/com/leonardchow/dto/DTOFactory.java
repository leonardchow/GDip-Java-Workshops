package com.leonardchow.dto;

public abstract class DTOFactory {
	public static PersonDTO getPersonDTOInstance(){
		return new PersonDTOImpl();
	}
	
	public static MemberDTO getMemberDTOInstance(){
		return new MemberDTOImpl();
	}
}

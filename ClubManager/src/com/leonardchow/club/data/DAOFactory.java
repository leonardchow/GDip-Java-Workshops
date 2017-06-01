package com.leonardchow.club.data;

public abstract class DAOFactory {
	public static MemberDAO getMemberDAOInstance(){
		return new MemberDAOImplementation();
	}
}

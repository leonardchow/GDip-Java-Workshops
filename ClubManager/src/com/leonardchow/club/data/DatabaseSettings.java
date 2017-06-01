package com.leonardchow.club.data;

public class DatabaseSettings {
	public static final String CONN_STR = "jdbc:mysql://localhost:3306/club?useSSL=true";
	public static final String USER = "root";
	public static final String PASSWORD = "password";
	
	public static final String MEMBER_TABLE = "Members";
	public static final String MEMBER_ID_COL = "id";
	public static final String MEMBER_SURNAME_COL = "surname";
	public static final String MEMBER_FIRSTNAME_COL = "firstName";
	public static final String MEMBER_SECONDNAME_COL = "secondName";
	
}

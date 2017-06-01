package com.leonardchow.club.data;

import com.leonardchow.dto.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberDAOImplementation implements MemberDAO {
	
	private static final String GET_ALL_MEMBERS_QRY = "SELECT * FROM " + DatabaseSettings.MEMBER_TABLE;
	private static final String GET_HIGHEST_ID_QRY = "SELECT id FROM " + DatabaseSettings.MEMBER_TABLE + " ORDER BY id DESC LIMIT 1;";
	private static final String UPDATE_MEMBER_WITH_VALS = "INSERT INTO " + DatabaseSettings.MEMBER_TABLE + " (id, surname, firstName, secondName) VALUES(?, ?, ?, ?);";
	private static final String GET_BY_MEMBER_WHERE_ID_IS_ = "SELECT * FROM " + DatabaseSettings.MEMBER_TABLE + " WHERE id = ";
	private static final String DELETE_BY_MEMBER_WHERE_ID_IS = "DELETE FROM " + DatabaseSettings.MEMBER_TABLE + " WHERE id = ";

	private ArrayList<MemberDTO> getAllMembers() {

		ArrayList<MemberDTO> members = new ArrayList<>();
		try (DatabaseConnection context = new DatabaseConnection()) {

			ResultSet results = context.dbQuery(GET_ALL_MEMBERS_QRY);

			while (results.next()) {
				String secondName = results.getString(DatabaseSettings.MEMBER_SECONDNAME_COL) == null ? "" : results.getString(DatabaseSettings.MEMBER_SECONDNAME_COL);
				
				MemberDTO member = DTOFactory.getMemberDTOInstance();
				member.setFirstName(results.getString(DatabaseSettings.MEMBER_FIRSTNAME_COL));
				member.setSecondName(secondName);
				member.setSurname(results.getString(DatabaseSettings.MEMBER_SURNAME_COL));
				member.setMemberNumber(results.getInt(DatabaseSettings.MEMBER_ID_COL));
				
				members.add(member);
			}
		} catch (SQLException e) {
			System.out.println("Could not get members from database.");
			e.printStackTrace();
		}

		return members;
	}

	private int getNextID() {

		int highestID = 1;
		try (DatabaseConnection context = new DatabaseConnection()) {
			ResultSet results = context.dbQuery(GET_HIGHEST_ID_QRY);

			if (results.first()) { // There is a first entry
				highestID = results.getInt(DatabaseSettings.MEMBER_ID_COL);
			}
		} catch (SQLException e) {
			System.out.println("Could not get next highest member number.");
			e.printStackTrace();
		}

		return highestID + 1;
	}

	@Override
	public Boolean createMember(MemberDTO member) {
		// Get highest member number
		// Add a new member based on the member number
		// return the member
		int id = 0;
		try {
			id = getNextID();
			try (DatabaseConnection context = new DatabaseConnection()) {
				Connection connection = context.openConnection();

				PreparedStatement statement = connection.prepareStatement(UPDATE_MEMBER_WITH_VALS);

				statement.setInt(1, id);
				statement.setString(2, member.getSurname());
				statement.setString(3, member.getFirstName());
				statement.setString(4, member.getSecondName());

				System.out.println(statement);

				int res = statement.executeUpdate();
				if (res == 0)
					throw new SQLException("No changes were made");
			}
		} catch (SQLException e) {
			System.out.println("Could not create member due to a database issue.");
			e.printStackTrace();
		}
		return false;
	}

	// @Override
	// public Integer updateMember(int memberNumber, String surname, String
	// firstName, String secondName) {
	// int changes = 0;
	// try (DatabaseConnection context = new DatabaseConnection()) {
	// String updateStr = String.format(
	// "UPDATE Members SET surname='%s', firstName='%s', secondName='%s' WHERE
	// id=%s;", surname, firstName,
	// secondName, memberNumber);
	//
	// System.out.println(updateStr);
	//
	// changes = context.dbUpdate(updateStr);
	// }
	// return changes;
	// }

	@Override
	public Integer updateMember(MemberDTO member) {
		int changes = 0;
		try (DatabaseConnection context = new DatabaseConnection()) {
			String queryStr = GET_BY_MEMBER_WHERE_ID_IS_ + member.getMemberNumber() + ";";

			ResultSet resultSet = context.dbQueryUpdatable(queryStr);

			if (resultSet.isLast())
				System.out.println("No members matched the member number.");

			resultSet.beforeFirst();
			do {
				resultSet.next();
				resultSet.updateString(DatabaseSettings.MEMBER_SURNAME_COL, member.getSurname());
				resultSet.updateString(DatabaseSettings.MEMBER_FIRSTNAME_COL, member.getFirstName());
				resultSet.updateString(DatabaseSettings.MEMBER_SECONDNAME_COL, member.getSecondName());
				resultSet.updateRow();
				changes++;
			} while (!resultSet.isLast());
		} catch (SQLException e) {
			System.out.println("Could not update member due to a database issue.");
			e.printStackTrace();
		}
		System.out.println("Changed " + changes + " record(s).");
		return changes;
	}

	// @Override
	// public int removeMember(int memberNumber) {
	// int removals = 0;
	// try (DatabaseConnection context = new DatabaseConnection()) {
	// String queryStr = "SELECT * FROM Members WHERE id = " + memberNumber +
	// ";";
	//
	// ResultSet resultSet = context.dbQueryUpdatable(queryStr);
	//
	// if (resultSet.isLast()) System.out.println("No members matched the member
	// number.");
	//
	// resultSet.beforeFirst();
	// do {
	// resultSet.next();
	// resultSet.deleteRow();
	// removals++;
	// System.out.println("Removed member: " + memberNumber);
	// } while (resultSet.next());
	// } catch (SQLException e) {
	// System.out.println("Could not update member due to a database issue.");
	// e.printStackTrace();
	// }
	// return removals;
	//
	// }

	@Override
	public int removeMember(int memberNumber) {
		int removals = 0;
		try (DatabaseConnection context = new DatabaseConnection()) {
			String queryStr = DELETE_BY_MEMBER_WHERE_ID_IS + memberNumber + ";";

			removals = context.dbUpdate(queryStr);

		}
		if (removals == 0)
			System.out.println("No member found, nothing removed.");
		else
			System.out.println(removals + " member(s) removed.");
		return removals;

	}

	@Override
	public void listMember(String name) {
		System.out.println(getFirstMemberByName(name));
	}

	@Override
	public void listAllMembers() {
		getAllMembers().forEach(member -> {
			System.out.println(member);
		});

	}

	@Override
	public MemberDTO getMemberByID(int id) {
		MemberDTO member = null;
		
		try (DatabaseConnection context = new DatabaseConnection()) {
			String queryStr = GET_BY_MEMBER_WHERE_ID_IS_ + id + ";";

			ResultSet resultSet = context.dbQuery(queryStr);

			if (resultSet.next()) {
				member = DTOFactory.getMemberDTOInstance();
				member.setFirstName(resultSet.getString(DatabaseSettings.MEMBER_FIRSTNAME_COL));
				member.setSecondName(resultSet.getString(DatabaseSettings.MEMBER_SECONDNAME_COL));
				member.setSurname(resultSet.getString(DatabaseSettings.MEMBER_SURNAME_COL));
				member.setMemberNumber(resultSet.getInt(DatabaseSettings.MEMBER_ID_COL));
			} else {
				System.out.println("No members matched the member number.");
			}
		} catch (SQLException e) {
			System.out.println("Could not update member due to a database issue.");
			e.printStackTrace();
		}
		return member;
	}

	@Override
	public List<MemberDTO> getMemberByName(String name) {
		
		String compare = name.toUpperCase();
		List<MemberDTO> members = getAllMembers().stream().filter(m -> {
			return m.getFirstName().toUpperCase().contains(compare) || m.getSurname().toUpperCase().contains(compare)
					|| m.getSecondName().toUpperCase().contains(compare);
		}).collect(Collectors.toList());

		if (members.isEmpty()) {
			System.out.println("Found no members matching that name.");
		} else {
			System.out.println("Found " + members.size() + " members matching that name.");			
		}
		return members;
	}

	@Override
	public MemberDTO getFirstMemberByName(String name) {
		return getMemberByName(name).get(0);
	}

}

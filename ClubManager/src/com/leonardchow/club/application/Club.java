package com.leonardchow.club.application;

import com.leonardchow.club.model.*;
//import com.sun.org.apache.xpath.internal.operations.Bool;
//import org.omg.CORBA.Environment;

//import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leonardchow on 5/25/2017.
 */

public class Club {
    private int currentNumber;
    private List<Member> members;
    private HashMap<String, Facility> facilities;
    private BookingRegister bookings;

    public Club (int startingNumber) {
        this.currentNumber = startingNumber;
        members = new ArrayList<>();
        facilities = new HashMap<>();
        bookings = new BookingRegister();
    }

    public Club() {
        this(1);
    }

    public Boolean addBooking(int memberNumber, String facilityName, Date startDate, Date endDate) {
        Member member = getMember(memberNumber);
        Facility facility = getFacility(facilityName);
        if (member == null || facility == null) {
            System.out.println("Could not find member or facility.");
            return false;
        }
        return bookings.addBooking(member, facility, startDate, endDate);
    }

    public ArrayList<Booking> getBookingsBetween(String facilityName, Date firstDate, Date lastDate) {
        Facility facility = getFacility(facilityName);
        if (facility == null) {
            System.out.println("Could not find that facility.");
            return null;
        }
        return bookings.getBookingsBetween(facility, firstDate, lastDate);
    }

    public void showBookings(String facilityName, Date firstDate, Date lastDate) {
        ArrayList<Booking> bookings = getBookingsBetween(facilityName, firstDate, lastDate);
        if (bookings.size() > 0) {
            bookings.forEach(booking -> booking.show());
        } else {
            System.out.println("No bookings to show between those dates.");
        }
    }

    public Member addMember(String surname, String firstName, String secondName) {
        Member member = new Member(surname, firstName, secondName, currentNumber);
        members.add(member);
        currentNumber++;
        return member;
    }

    public Member addMember(String surname, String firstName) {
        return addMember(surname, firstName, "");
    }

    public Member getMember(int memberNumber) {
        int index = -1;
        for (Member member : members) {
            if (member.getMemberNumber() == memberNumber) {
                index = members.indexOf(member);
            }
        }
        if (index < 0) return null;
        return members.get(index);
    }

    public void showMembers() {
        String memberList = "";
        for (Member member: members
                ) {
            memberList += member.show() + "\n";
        }
       System.out.println(memberList);
    }

    public boolean removeMember(int memberNumber) {
        int index = -1;
        for (Member member: members
                ) {
            if (member.getMemberNumber() == memberNumber) {
                index = members.indexOf(member);
            }
        }

        if (index < 0) {
            return false;
        }

        members.remove(index);
        return true;
    }

    public Facility getFacility (String name) {
        return facilities.get(name);
    }

    public ArrayList<Facility> getFacilities() {
        return new ArrayList<Facility>(facilities.values());
    }

    public void addFacility(String name, String description) {
        facilities.put(name, new Facility(name, description));
    }

    public void addFacility(String name) {
        addFacility(name, "");
    }

    public boolean removeFacility(String name) {
        if (facilities.containsKey(name)) {
            facilities.remove(name);
            return true;
        }
        return false;
    }

    public void showFacilities() {
        facilities.values().forEach(facility -> System.out.println(facility));
    }
    
    public void sortByMemberNumber() {
    	Collections.sort(members);
    }
    
    public void sortByMemberNumberDescending(){
    	Collections.sort(members, Collections.reverseOrder());
    }
}



/*
public class Club {
    private int currentNumber;
    private Member[] members;

    public Club (int startingNumber) {
        this.currentNumber = startingNumber - 1;
        members = new Member[3];
    }

    public Club() {
        this(1);
    }

    public Member addMember(String surname, String firstName, String secondName) {
        if (members.length <= currentNumber) {
            // do array resize
            Member[] tempArray = new Member[members.length * 2];
            for (int i = 0; i < members.length; i++) {
                tempArray[i] = members[i];
            }
            members = tempArray;
        }

        Member member = new Member(surname, firstName, secondName, currentNumber+1);
        members[currentNumber] = member;
        currentNumber++;
        return member;
    }

    public Member addMember(String surname, String firstName) {
        return addMember(surname, firstName, "");
    }

    public String showMembers() {
        boolean noMembers = true;
        String memberList = "";
        for (Member member: members
             ) {
            if (member != null) {
                memberList += member.show() + "\n";
                noMembers = false;
            }
        }

        if (noMembers) {
            return "There are no members currently.";
        }
        return memberList;
    }

    public boolean removeMember(int memberNumber) {
        int index = memberNumber - 1;
        if (members[index] == null) {
            return false;
        }

        members[index] = null;
        return true;
    }
}
*/
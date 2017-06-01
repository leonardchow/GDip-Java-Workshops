package com.leonardchow.club.application;

import com.leonardchow.club.data.DAOFactory;
import com.leonardchow.club.data.MemberDAO;
import com.leonardchow.club.data.MemberDAOImplementation;
import com.leonardchow.dto.MemberDTO;
import com.leonardchow.utils.DateUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by leonardchow on 5/24/2017.
 */
public class ClubApplication {

    public static void main(String[] args) {
//        Member m = new Member("Wong", "James", 10);
//        System.out.println(m.show());
//
//        Person n = new Member("Wong", "James", 10);
//        System.out.println(n.show());

        Club club = new Club();

        club.addMember("Tan", "Manny", "S.");
        club.addMember("Lim", "Sunny");
        club.addMember("Sim", "Jimmy");
        club.addMember("Chan", "Bryan");
        club.addMember("Cheong", "Kenneth", "H.");

//        System.out.println(club.showMembers());

        //club.removeMember(1);
//        club.removeMember(2);
//        club.removeMember(3);
//        club.removeMember(4);
//        club.removeMember(5);
//        System.out.println(club.showMembers());

        club.addFacility("Basketball court");
        club.addFacility("Badminton court", "Fun for family!");
        club.addFacility("Tennis court", "Only for collegiate members.");
        club.addFacility("Soccer field", "");

//        System.out.println(club.getFacility("Tennis court"));

//        club.showFacilities();


        club.addBooking(
                1,
                "Tennis court",
                DateUtils.useDate("2017/05/11").toDate(),
                DateUtils.useDate("2017-05-15").toDate());
        club.addBooking(
                1,
                "Tennis court",
                DateUtils.useDate("2017/05/15").toDate(),
                DateUtils.useDate("2017-05-16").toDate());
        club.addBooking(
                1,
                "Tennis court",
                DateUtils.useDate("2017/05/19").toDate(),
                DateUtils.useDate("2017-05-25").toDate());
        club.addBooking(
                2,
                "Basketball court",
                DateUtils.useDate("2017/05/11").toDate(),
                DateUtils.useDate("2017-05-15").toDate());

        /*club.showBookings("Basketball court",
                DateUtils.useDate("2017/05/10").toDate(),
                DateUtils.useDate("2017-05-20").toDate());
        
        System.out.println("Members");
        club.showMembers();
        club.sortByMemberNumber();
        System.out.println("Members sorted asc");
        club.showMembers();
        System.out.println("Members sorted descending");
        club.sortByMemberNumberDescending();
        club.showMembers();*/
        
        MemberDAO md = DAOFactory.getMemberDAOInstance();
        
        System.out.println("Printing members from database: ");
        md.listAllMembers();
        
//        MemberDTO member = new MemberDTO("ff", "ff");
        
//        md.createMember(member);
        
        MemberDTO memberToUpdate = md.getFirstMemberByName("Peter");
        memberToUpdate.setSecondName("Jay-Z");
        md.updateMember(memberToUpdate);
//        md.removeMember(9);
//        md.listMember("Lem");
//        md.listAllMembers();
    }
}


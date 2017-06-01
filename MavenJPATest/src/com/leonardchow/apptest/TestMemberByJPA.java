package com.leonardchow.apptest;

import java.util.List;

import javax.persistence.EntityManager;

import com.leonardchow.model.Member;
import com.leonardchow.persistence.PersistenceManager;

public class TestMemberByJPA {

	public static void main(String[] args) {
		
		EntityManager em = PersistenceManager.INSTANCE.getEntityManager();
		em.getTransaction().begin();
		// ==> Remove member by id
//		try {			
//			Member toRemove = em.getReference(Member.class, 18);
//			em.remove(toRemove);
//		} catch (EntityNotFoundException ef) {
//			System.out.println("=*=*=*=* Could not find entity of that ID.");
//		}

		// ==> Update member by id, using getReference
//		Member toUpdate = em.getReference(Member.class, 17);
//		toUpdate.setSecondName("Potato");

		// ==> Find member and return as hydrated member
//		Member simon = em.find(Member.class, 12);
		
		// ==> Insert a new member (set PKEY to 0 so that auto-incr will take over
//		em.persist(new Member("KarrineAAAA", "Tstue", "LAAAA"));
		
		// ==> Find all members
		String surname = "patrick";
		
		String compare = surname.toUpperCase();
		
		Member found = null;
		
		String string = "SELECT m FROM " + Member.class.getName() + " m";
		List<Member> members = em.createQuery(string).getResultList();

		for (Member member : members) {
			System.out.println(member);
			if (member.getSurname().toUpperCase().contains(compare)) {
				found = member;
			}
		}
		
		if (found != null) {
//			found.setSecondName("K.");
		}
		
		em.getTransaction().commit();
		
		em.close();
		PersistenceManager.INSTANCE.close();
		
		

	}

}

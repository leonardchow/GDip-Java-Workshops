package com.leonardchow.data;


import javax.persistence.EntityManager;

import com.leonardchow.persistence.PersistenceManager;

public class LapsEntity implements AutoCloseable {
	
	private EntityManager lapsEntity;
	
	public LapsEntity() {
		lapsEntity = PersistenceManager.INSTANCE.getEntityManager();
	}
	
	public EntityManager getEntityManager() {
		lapsEntity.getTransaction().begin();	
		return lapsEntity;
	}
	
	public void close() {
		lapsEntity.close();
		PersistenceManager.INSTANCE.close();		
	}
	
}
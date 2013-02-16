package com.myfaces.repositories.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DAOImpl {

	@PersistenceContext
	protected EntityManager entityManager; 	
    
    private Integer max_result;
    
    public int getMaxResult(){
    	if (max_result == null){
    		max_result = 100;
    	}
    	return max_result;
    }
    
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

}

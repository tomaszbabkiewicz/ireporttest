package com.elerning.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.elerning.model.Role;
import com.elerning.repositories.RoleDAO;


@Repository("RolesRepository")
public class RoleDAOImpl implements RoleDAO {
	
	private EntityManager em = null;
    
	/**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAllRoles() {
		return em.createQuery("select p from Role p").getResultList();
	}

}

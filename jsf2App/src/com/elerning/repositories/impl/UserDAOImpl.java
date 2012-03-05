package com.elerning.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.elerning.model.User;
import com.elerning.repositories.UserDAO;


@Repository("UsersRepository")
public class UserDAOImpl implements UserDAO {
	
	private EntityManager em = null;
    
	/**
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

	@Override
	public User getUserByLogin(String login) {
		return (User) em.createQuery("select p from User p where p.login = :login").setParameter("login", login).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		return  em.createQuery("select p from User p").getResultList();
	}

}

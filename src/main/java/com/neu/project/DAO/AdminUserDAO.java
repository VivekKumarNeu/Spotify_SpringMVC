package com.neu.project.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.myexception.AdException;

public class AdminUserDAO extends DAO {

    public AdminUserDAO() {
    }

    public List getallusers() throws AdException {

    	try {
            begin();
            Query q = getSession().createQuery("from User where status = :status and role = :role");
            q.setString("status", "pending");
            q.setString("role", "Normal");
            List userlist = q.list();
            commit();
            return userlist;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user list", e);
        }
    	
    	
    	
    }
}

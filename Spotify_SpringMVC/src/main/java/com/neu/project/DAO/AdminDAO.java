package com.neu.project.DAO;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.neu.project.myexception.AdException;
import com.neu.project.pojo.User;

public class AdminDAO extends DAO {

    public AdminDAO() {
    }

    public User get(String username)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where name = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

    public User create(String username, String password,String emailId, String firstName, String lastName,int age)
            throws AdException {
        try {
            begin();
           // boolean uu = alreadyExists(username);
            
            User user=new User(username,password);
            
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(emailId);
            user.setAge(age);
            getSession().save(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(User user)
            throws AdException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not delete user " + user.getUserName(), e);
        }
    }
    
    public boolean alreadyExists(String username) {
    	Query query = getSession().             
    		    createQuery("select 1 from user t where t.user = :key");
    		        query.setString("key", username);
    		    return (query.uniqueResult() != null);
    }
    
    
    public int requeststatus(String username, String response, String PersonId) throws AdException 
    {
    	int result=0;
    	if(response.equals("ok"))
    	{
    		try {
                begin();
                Query q = getSession().createQuery("UPDATE User set status = :ok WHERE userName = :username");
                q.setParameter("username", username);
                q.setParameter("ok", response);
                result = q.executeUpdate();
                commit();
    		}
    		catch (HibernateException e) {
                rollback();
    		}
    	} else if (response.equals("no"))
    	{
    		try {
                begin();
                Query q = getSession().createQuery("UPDATE User set status = :ok WHERE userName = :username");
                q.setString("username", username);
                q.setString("ok", response);
                q.setString("personid", PersonId);
                result = q.executeUpdate();
    		}
    		catch (HibernateException e) {
                rollback();
    		}
    		
    		
    		
    	}
    	return result;
    }
    
    
    
    
    
    }   

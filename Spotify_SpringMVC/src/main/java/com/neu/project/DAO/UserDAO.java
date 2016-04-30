package com.neu.project.DAO;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

import com.neu.project.myexception.AdException;
import com.neu.project.pojo.PlayList;
import com.neu.project.pojo.User;

public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User get(String username, String password)
            throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from User where user = :username and password= :password");
            q.setString("username", username);
            q.setString("password", password);
            User user = (User) q.uniqueResult();
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }

    public User getuser(String username)
            throws AdException {
    	
    	try{
    		begin();
            Query q = getSession().createQuery("from User where user = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            commit();
            return user;
    	}
    	catch (HibernateException e) {
            rollback();
            throw new AdException("Could not get user " + username, e);
        }
    }
    
    
    
    public User create(String username, String password,String emailId, String firstName, String lastName,int age,String role)
            throws AdException {
        try {
            begin();
            
            User user=new User(username,password);
            
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(emailId);
            user.setAge(age);
            user.setRole(role);
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
    	Query query = getSession().createQuery("from User where userName = :username");
    	query.setString("username", username);
    	return (query.uniqueResult() != null);
    }
    
    
    //get All users from database
    public List<User> getallusers() throws AdException
	{
		 begin();
		 //String sql = "SELECT * FROM USER";
		 //SQLQuery query = getSession().createSQLQuery(sql);
		 //query.addEntity(User.class);
		 Query query = getSession().createQuery("from User where role=:role");
		 query.setString("role", "Normal");
		 List results = query.list();
		 commit();
		 return results;
		
		
	}
    
    
    public void changeuserrequest(String username) throws AdException
    {
    	begin();
    	Query query = getSession().createQuery("UPDATE User set status = :stat where userName =:username");
		query.setString("stat", "pending");
		query.setString("username", username);
		int results = query.executeUpdate();
    	commit();
    }
    
    
    
    
    
    
    
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.algebra.model;

import java.util.Date;

/**
 *
 * @author Ivan
 */
public class User {
        private int id;

	private String username;
	private String password;
	private String email;
        private UserPackage userPackage;
        private Date lastPacketChange;

    public Date getLastPacketChange() {
        return lastPacketChange;
    }

    public void setLastPacketChange(Date lastPacketChange) {
        this.lastPacketChange = lastPacketChange;
    }

	public User() {
	}

	public User(int id, String username, String password, String email, UserPackage userPackage ) {
		this.id = id;

		this.username = username;
		this.password = password;
		this.email = email;
                this.userPackage = userPackage;
	}

    public User(String username, String password, String email, UserPackage userPackage) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userPackage = userPackage;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
     public User(int id,String username, String email, UserPackage userPackage, Date date) {
         		this.id = id;
        this.username = username;
        this.email = email;
        this.userPackage = userPackage;
        this.lastPacketChange=date;
    }
     public User(int id,String username, String email, UserPackage userPackage) {
         		this.id = id;
        this.username = username;
        this.email = email;
        this.userPackage = userPackage;
    }
        
        

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String email) {
		this.username = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
        public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

    public UserPackage getUserPackage() {
        return userPackage;
    }

    public void setUserPackage(UserPackage userPackage) {
        String s = userPackage.toString();
        this.userPackage = PackageFactory.getPackage(s);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", userPackage=" + userPackage + '}';
    }


}

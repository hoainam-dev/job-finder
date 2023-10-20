package com.jobfinder.security;

import org.mindrot.jbcrypt.BCrypt;


public class BcryptPassword {
	
	public String BcryptPass(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
	}
}

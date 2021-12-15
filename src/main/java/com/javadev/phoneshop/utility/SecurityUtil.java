package com.javadev.phoneshop.utility;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUtil {
	public static User getUserDetails() {	
		return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
 
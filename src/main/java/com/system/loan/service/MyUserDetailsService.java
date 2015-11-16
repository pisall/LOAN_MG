package com.system.loan.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.loan.dao.co.CO_DAO_001;
import com.system.loan.dao.co.CO_DAO_001_IMP;



@Service("MYuserDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	private CO_DAO_001 login = new CO_DAO_001_IMP();

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String username) 
		throws UsernameNotFoundException {
		System.out.println("userName="+username);
		HashMap<String, Object> user = login.findLogByLogMail(username);
		List<GrantedAuthority> authorities =buildUserAuthority(user.get("log_email").toString());

		return buildUserForAuthentication(user, authorities);
		
		
	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(HashMap<String, Object> user, 
		List<GrantedAuthority> authorities) {
		System.out.println((boolean)user.get("enabled")+"==========================");
		return new User(user.get("log_email").toString(), user.get("log_password").toString(), 
				(boolean)user.get("enabled"), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(String userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		setAuths.add(new SimpleGrantedAuthority(userRoles));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}
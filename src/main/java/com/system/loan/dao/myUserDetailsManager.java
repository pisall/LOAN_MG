package com.system.loan.dao;

import java.nio.file.AccessDeniedException;

import javax.security.sasl.AuthenticationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import com.system.loan.dao.login.LOGIN_DAO_001_IMP;
import com.system.loan.service.MyUserDetailsService;

public class myUserDetailsManager  implements UserDetailsManager{
	
	protected final Log logger = LogFactory.getLog(getClass());
	
	private AuthenticationManager authenticationManager;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(UserDetails user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(String oldPassword, String newPassword){
		// TODO Auto-generated method stub
		Authentication currentUser=SecurityContextHolder.getContext().getAuthentication();
		AuthenticationManager authOld;
		try {
			if(currentUser==null){
				throw new AccessDeniedException("Can't change password as no Authentication object found in context for current user.");
			}
			
			
			String username=currentUser.getName();
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
			
			if(authenticationManager !=null){
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, oldPassword));
				//boolean test=authenticationManager==authOld.authenticate(currentUser);
				logger.info("yes have ");
			}else{
				logger.info("No authentication manager set. Password won't be re-checked.");
			}
			
			logger.debug("Changing password for user '" + username + "'");
			LOGIN_DAO_001_IMP log=new LOGIN_DAO_001_IMP();
			log.changePassword(newPassword, username);
			SecurityContextHolder.getContext().setAuthentication(createNewAuthentication(currentUser,newPassword));
			
		} catch (AccessDeniedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	protected Authentication createNewAuthentication(Authentication currentAuth,
			String newPassword) {
		MyUserDetailsService myUser=new MyUserDetailsService();
		UserDetails user = myUser.loadUserByUsername(currentAuth.getName());
		

		UsernamePasswordAuthenticationToken newAuthentication = new UsernamePasswordAuthenticationToken(
				user, null, user.getAuthorities());
		newAuthentication.setDetails(currentAuth.getDetails());

		return newAuthentication;
	}

	@Override
	public boolean userExists(String username) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

}

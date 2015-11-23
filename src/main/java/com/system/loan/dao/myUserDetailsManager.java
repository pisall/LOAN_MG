package com.system.loan.dao;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;

import javax.inject.Inject;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;

import com.system.loan.dao.login.LOGIN_DAO_001_IMP;
import com.system.loan.service.MyUserDetailsService;


public class myUserDetailsManager  implements UserDetailsManager{
	//@Inject AuthenticationManager authenticationManager;
	
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
		try {
			if(currentUser==null){
				throw new AccessDeniedException("Can't change password as no Authentication object found in context for current user.");
			}
			
			
			String username=currentUser.getName();
			Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String password=((UserDetails)principal).getPassword();
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			if(encoder.matches(oldPassword, password)){
				logger.info("password is match");
			}else{
				logger.info("password is not match!");
				throw new AccessDeniedException("Can't change password as no Authentication object found in context for current user.");
			}
			logger.info("userName="+username+"; oldPassword="+oldPassword+";currentpassword="+password);
			
			
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
	
	public HashMap<String, Object> changeUserName(String newUserName,String enterPassword){
		Authentication currentUser=SecurityContextHolder.getContext().getAuthentication();
		try {
			if(currentUser==null){
				throw new AccessDeniedException("Can't change password as no Authentication object found in context for current user.");
			}
			
			String username=currentUser.getName();
			Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			String password=((UserDetails)principal).getPassword();
			PasswordEncoder encoder = new BCryptPasswordEncoder();
			if(encoder.matches(enterPassword, password)){
				logger.info("password is match");
			}else{
				logger.info("password is not match!");
				throw new AccessDeniedException("Can't change password as no Authentication object found in context for current user.");
			}
			
			
			if(authenticationManager !=null){
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, enterPassword));
				//boolean test=authenticationManager==authOld.authenticate(currentUser);
				logger.info("yes have ");
			}else{
				logger.info("No authentication manager set. Password won't be re-checked.");
			}
			
			LOGIN_DAO_001_IMP log=new LOGIN_DAO_001_IMP();
			HashMap<String , Object> result=new HashMap<>();
			result=log.changeUserName(username, newUserName);
			if(!(boolean)result.get("ERROR")){
				SecurityContextHolder.getContext().setAuthentication(createNewAuthenticationByUserName(currentUser,newUserName));
			}
			
			return result;
		}catch (AccessDeniedException e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	protected Authentication createNewAuthenticationByUserName(Authentication currentAuth,String userName){
		MyUserDetailsService myUser=new MyUserDetailsService();
		UserDetails user = myUser.loadUserByUsername(userName);
		

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
	public boolean isValidePass(String oldPass){
		Object principal=SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String password=((UserDetails)principal).getPassword();
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		if(encoder.matches(oldPass, password)){
			logger.info("password is match");
			return true;
		}else{
			logger.info("password is not match!");
			return false;
		}
		
	}

}

package com.system.loan;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.system.loan.dao.co.CO_DAO_001_IMP;
import com.system.loan.dto.session.USER_SESSION;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication)
            throws IOException, ServletException {
        //do some logic here if you want something to be done whenever
        //the user successfully logs in.
    	System.out.println(" login successful !!!!!!))");
    	
    	String strRole="";
    	for(GrantedAuthority gauth:authentication.getAuthorities()){
    		strRole=gauth.getAuthority();
    	}
    	if(strRole.equals("ROLE_SYS")){
    		 httpServletResponse.setStatus(HttpServletResponse.SC_OK);
    		 httpServletResponse.sendRedirect("sys/sys_form");
    		
    	}else{
    		 HttpSession session = httpServletRequest.getSession();
	        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	        String userName=authUser.getUsername();
	        CO_DAO_001_IMP co=new CO_DAO_001_IMP();
	        HashMap<String, Object> coInfo=co.findCobyUserId(userName);
	        String strFirstNm=coInfo.get("co_first_nm").toString();
	        String strLastNm=coInfo.get("co_last_nm").toString();
	        
	        int coId=(int)coInfo.get("co_id");
	        USER_SESSION userSession=new USER_SESSION();
	        userSession.setCoId(coId);
	        userSession.setLogType(strRole);
	        userSession.setCoNm(strFirstNm+" "+ strLastNm);
	        session.setAttribute("USER_SESSION", userSession/*authUser.getUsername()*/);
	        session.setAttribute("authorities", authentication.getAuthorities());
	        //set our response to OK status
	       

	        //since we have created our custom success handler, its up to us to where
	        //we will redirect the user after successfully login
	        httpServletResponse.sendRedirect("home");
    		
    	}
    	
       
    }
}

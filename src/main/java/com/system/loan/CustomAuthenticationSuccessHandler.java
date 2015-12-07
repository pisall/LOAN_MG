package com.system.loan;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.SynchronousQueue;

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
        HttpSession session = httpServletRequest.getSession();
        User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName=authUser.getUsername();
        CO_DAO_001_IMP co=new CO_DAO_001_IMP();
        
        String strRole="";
        for(GrantedAuthority auth:authentication.getAuthorities()){
        	System.out.println("=====+++========="+auth.getAuthority());
        	strRole=auth.getAuthority();
        }
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        
        if(strRole.equals("ROLE_ADMIN")){
        	HashMap<String, Object> coInfo=co.findCobyUserId(userName);
            String strFirstNm=coInfo.get("co_first_nm").toString();
            String strLastNm=coInfo.get("co_last_nm").toString();
            String strBooOtherEditProf=coInfo.get("other_edit_prof").toString();
            
            System.out.println("is edit="+strBooOtherEditProf);
            boolean booOtherEditProf=false;
            if (strBooOtherEditProf.length()!=0){
            	if(strBooOtherEditProf.equals("true")|| strBooOtherEditProf.equals("1"));
            	booOtherEditProf=true;
            }
            int coId=(int)coInfo.get("co_id");
            USER_SESSION userSession=new USER_SESSION();
            userSession.setCoId(coId);
            userSession.setCoNm(strFirstNm+" "+ strLastNm);
            userSession.setOther_edit_prof(booOtherEditProf);
            session.setAttribute("USER_SESSION", userSession/*authUser.getUsername()*/);
            session.setAttribute("authorities", authentication.getAuthorities());
            
            
            
            httpServletResponse.sendRedirect("home");
        	
        }else{
        	httpServletResponse.sendRedirect("sys/sys_form");
        }
        
       
        

        //set our response to OK status
        

        //since we have created our custom success handler, its up to us to where
        //we will redirect the user after successfully login
        
        
    }
}

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page import="org.springframework.security.core.GrantedAuthority" %>
<%@page import="org.springframework.context.annotation.Import"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@page import="com.system.loan.dto.session.USER_SESSION"%>
<!DOCTYPE html>

<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Loan_Approve</title>
	    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    
     <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/v_costomize.css">
   	<style type="text/css">
   		label.error{
   			color:red;
   		}
   	</style>
   
   </head>
   
 
   
   <%
	Date  now = new Date();
	SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
	
	String datetime = date.format(now);
	
	

 	USER_SESSION user=(USER_SESSION)session.getAttribute("USER_SESSION");
 		int strCoId=0;
 		String strCoNm="";
 	if(user!=null){
 		strCoId=user.getCoId();
 		strCoNm=user.getCoNm();
 		
 	}
	%>
    


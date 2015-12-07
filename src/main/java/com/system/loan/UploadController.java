package com.system.loan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.system.loan.dao.FileValidator;
import com.system.loan.dto.UploadedFile;

@Controller
@RequestMapping("uploadController")
public class UploadController {
	@Autowired
	 FileValidator fileValidator;
	

	 @RequestMapping("/fileUploadForm")
	 public ModelAndView getUploadForm(
	   @ModelAttribute("uploadedFile") UploadedFile uploadedFile,
	   BindingResult result) {
	  return new ModelAndView("uploadForm");
	 }

	 @RequestMapping("/fileUpload")
	 public ModelAndView fileUploaded(
	   @ModelAttribute("uploadedFile") UploadedFile uploadedFile,
	   BindingResult result,HttpServletRequest request) {
	  InputStream inputStream = null;
	  OutputStream outputStream = null;

	  MultipartFile file = uploadedFile.getFile();
	  fileValidator.validate(uploadedFile, result);

	  String fileName = file.getOriginalFilename();
	  
	  
	  HttpSession ss=request.getSession();
	 String parths=ss.getServletContext().getRealPath("/");
	 String[] par=parths.split(Pattern.quote("\\.metadata\\"));
	 String fullPath=par[0];
	 System.out.println(par.length);
	 System.out.println(parths);

	  if (result.hasErrors()) {
	   return new ModelAndView("uploadForm");
	  }

	  try {
	   inputStream = file.getInputStream();
	   String fileFullNm=fullPath+"\\LOAN_MG\\src\\main\\webapp\\resources\\img\\" + fileName;
	   System.out.println("file full name="+fileFullNm);

	   File newFile = new File(fileFullNm);
	   if (!newFile.exists()) {
		   System.out.println("start write new file");
	    newFile.createNewFile();
	   }
	   outputStream = new FileOutputStream(newFile);
	   int read = 0;
	   byte[] bytes = new byte[1024];

	   while ((read = inputStream.read(bytes)) != -1) {
	    outputStream.write(bytes, 0, read);
	   }
	   System.out.println("writing is finished");
	   outputStream.close();
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }

	  return new ModelAndView("showFile", "message", fileName);
	 }
	

}

package com.system.loan;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jws.WebParam.Mode;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.loan.dao.BackupAndRestore;
@Controller
@RequestMapping("backupandrestore")
public class BackupAndRestoreController {
	@Inject
		BackupAndRestore br;
	@RequestMapping(value = "/backup")
	public @ResponseBody int backup(Model model){	
		model.addAttribute("page_id","cont_6");
		return br.backup();
	}
}

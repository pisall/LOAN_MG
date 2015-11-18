package com.system.loan;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.stereotype.Controller;
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
	public @ResponseBody int backup(){	
		return br.backup();
	}
}

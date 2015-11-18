package com.system.loan.dao;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.stereotype.Service;

import com.system.loan.dto.CustomerDto;

@Service
public class BackupAndRestore {
	public int backup() {
		String date = new SimpleDateFormat("ddMMyyyy").format(new Date());
		String executeCmd = "C:\\Program Files\\PostgreSQL\\9.5\\bin\\pg_dump -h 192.168.178.78  -U postgres -d postgres -w -c -f D:\\"
				+ date + ".sql";
		Process runtimeProcess;
		int processComplete = 0;
		try {
			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			processComplete = runtimeProcess.waitFor();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return processComplete;
	}

	public void restore() {
		String date = new SimpleDateFormat("ddMMyyyy").format(new Date());
		String executeCmd = "C:\\Program Files\\PostgreSQL\\9.5\\bin\\psql -h 192.168.178.78 -U postgres -d loanSystem -w -f D:\\"
				+ date + ".sql";
		Process runtimeProcess;
		try {
			runtimeProcess = Runtime.getRuntime().exec(executeCmd);
			int processComplete = runtimeProcess.waitFor();
			if (processComplete == 0) {
				System.out.println("Backup created successfully");
			} else {
				System.out.println("Could not create the backup");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}

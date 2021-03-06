package com.juve.payroll.service.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.juve.payroll.data.config.PayrollJPAConfig;
import com.juve.payroll.data.dao.IClientDAO;
import com.juve.payroll.data.dao.IEmployeeDAO;
import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.data.dao.ITimeRecordDAO;
import com.juve.payroll.model.Client;
import com.juve.payroll.model.Employee;
import com.juve.payroll.model.EmployeeLeave;
import com.juve.payroll.model.Leave;
import com.juve.payroll.model.TimeRecord;
import com.juve.payroll.service.IClientService;
import com.juve.payroll.service.IEmployeeLeaveService;
import com.juve.payroll.service.IEmployeeService;
import com.juve.payroll.service.IEmployeeTimeRecordService;
import com.juve.payroll.service.config.PayrollServiceConfig;
import com.juve.payroll.service.model.ExcelTimeRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PayrollServiceConfig.class)
public class ServiceTest {
	@Autowired
	private IEmployeeService employeeService; 
	
	@Autowired
	private IClientService clientService;
	
	@Autowired
	private IEmployeeTimeRecordService employeeTimeRecordService;
	
	@Autowired
	private IEmployeeLeaveService employeeLeaveService;
	
	//@Test
	public void testEmployee() throws ParseException {
		Client client = clientService.getClientDetails(1L);
		System.out.println(client.getClientName());
	}
	
	//@Test
	public void testTimeReccord() {
		List<TimeRecord> timeRecords = employeeTimeRecordService.getEmployeeTimeRecord(2L, new Date("05/1/2017 00:00:00"), new Date("05/1/2017 23:59:59"));
		
		System.out.println("ss " + timeRecords.size());
		
	}
	
	//@Test
	public void testEmployeeLeave() {
		List<EmployeeLeave> leaves = employeeLeaveService.getEmployeeLeave(1L, new Date("05/1/2017"), new Date("05/10/2017"));
		
		System.out.println("leaves " + leaves.size());
	}
	
	
	
	//@Test
	public void testTimeRecordExcel() throws IOException {
		 FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\dell\\Desktop\\Book1.xlsx"));
         Workbook workbook = new XSSFWorkbook(excelFile);
		List<ExcelTimeRecord> list = employeeTimeRecordService.readExcelRecord(workbook);
		System.out.println(list.size());
		for(ExcelTimeRecord timeRecord : list) {
			System.out.println(timeRecord.getEmployeeId());
		}
	}
}

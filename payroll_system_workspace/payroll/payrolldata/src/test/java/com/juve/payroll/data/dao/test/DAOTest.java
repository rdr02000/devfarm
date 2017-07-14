package com.juve.payroll.data.dao.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.juve.payroll.data.config.PayrollJPAConfig;
import com.juve.payroll.data.dao.IEmployeeDAO;
import com.juve.payroll.data.dao.IEmployeeLeaveDAO;
import com.juve.payroll.data.dao.IEmployeeOvertimeRecordDAO;
import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.data.dao.ITimeRecordDAO;
import com.juve.payroll.data.dao.IBonusAndAllowanceDAO;
import com.juve.payroll.data.dao.IClientOfferedAllowanceDAO;
import com.juve.payroll.model.BonusAndAllowance;
import com.juve.payroll.model.ClientOfferedAllowance;
import com.juve.payroll.model.Employee;
import com.juve.payroll.model.EmployeeLeave;
import com.juve.payroll.model.OvertimeRecord;
import com.juve.payroll.model.TimeRecord;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=PayrollJPAConfig.class)
public class DAOTest {
	@Autowired
	private IPayrollGenericDAO<TimeRecord> timeRecordDAO;
	
	@Autowired
	private IPayrollGenericDAO<EmployeeLeave> employeeLeaveDAO;
	
	@Autowired
	private IPayrollGenericDAO<BonusAndAllowance> bonusAndAllowanceDAO;
	
	@Autowired
	private IPayrollGenericDAO<ClientOfferedAllowance> clientOfferedAllowanceDAO;
	
	@Autowired
	private IPayrollGenericDAO<Employee> employeeDAO;
	
	@Autowired
	private IPayrollGenericDAO<OvertimeRecord> employeeOvertimeRecordDAO;
	
	//@Test
	public void testTimeRecord() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		List<TimeRecord> timeRecord = ((ITimeRecordDAO)timeRecordDAO).getEmployeeTimeRecord(1L,  sdf.parse("2017-05-01 08:00:00"),
				 sdf.parse("2017-05-04 17:00:00"));
		
		System.out.println("time record " + timeRecord.size());
	}
	
	//@Test
	public void testEmployeeLeave() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		List<EmployeeLeave> employeeLeaves = ((IEmployeeLeaveDAO)employeeLeaveDAO).getEmployeesLeave(1l, sdf.parse("2017-05-01"),
				 sdf.parse("2017-05-04"));
		
		System.out.println("employeeLeave " + employeeLeaves.size());
	}
	
	//@Test
	public void testBonusAndAllowance() {
		bonusAndAllowanceDAO.setClazz(BonusAndAllowance.class);
		
		List<BonusAndAllowance> list = ((IBonusAndAllowanceDAO)bonusAndAllowanceDAO).getBonusAndAllowances();
		
		System.out.println(list.size());
	}
	
	//@Test
	public void testClientAllowanceDAO() {
		List<ClientOfferedAllowance> list = ((IClientOfferedAllowanceDAO)clientOfferedAllowanceDAO).
				getClientOfferedAllowanceByClientId(1L);
		
		ClientOfferedAllowance allowance = list.get(0);
		
		System.out.println(allowance.getBonusAndAllowance().getBonusName());
	}
	
	//@Test
	public void testEmployee() {
		List<Employee> list = ((IEmployeeDAO)employeeDAO).getEmployeesByClientId(1L);
		
		for(Employee employee : list) {
			System.out.println(employee.getFirstName());
			System.out.println(employee.getEmployeeShift().getScheduleShift().getShiftName());
		}
	}
	
	//@Test
	public void testGerDirecReportEmployee() {
		List<Employee> list = ((IEmployeeDAO)employeeDAO).getEmployeeDirectReport(1L);
		
		System.out.println(list.size());
	}
	
	//@Test
	public void testEmployeeLeaveByReportingEmployees() {
		List<EmployeeLeave> list = ((IEmployeeLeaveDAO)employeeLeaveDAO).getEmployeeLeavesByReportingEmployee(1L);
		
		System.out.println(list.size());
	}
	
	@Test
	public void testEmployeeOvertime() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		
		List<OvertimeRecord> list = ((IEmployeeOvertimeRecordDAO)employeeOvertimeRecordDAO).getEmployeesOvertime(1L, sdf.parse("2017-05-01 08:00:00"),
				 sdf.parse("2017-08-04 17:00:00"));
		
		System.out.println(list.size());
	}
}

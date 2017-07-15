package com.juve.payroll.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.juve.payroll.model.Client;
import com.juve.payroll.model.Employee;
import com.juve.payroll.model.EmployeeShift;
import com.juve.payroll.model.ScheduleShift;
import com.juve.payroll.model.TimeRecord;
import com.juve.payroll.model.WorkdayShift;

public class TimeRecordUtilityService {
	private static final String HYPEN = "-";
	private static final String VERTICAL_SIGN = "|";
	
	public static long getLate(Employee employee, TimeRecord timeRecord) {
		int hour = 0;
		int min = 0;
		int sec = 0;
		long lateTotal = 0;
		
		String shiftTime = employee.getEmployeeShift().getScheduleShift().getShiftRule();
		Calendar ruleTimeIn = Calendar.getInstance();
		
		Calendar timeIn = Calendar.getInstance();
		timeIn.setTime(new Date(timeRecord.getTimeIn().getTime()));
		
		if (shiftTime.contains(HYPEN)) {
			String[] timeStr = shiftTime.split("-");
			hour = Integer.parseInt(timeStr[1].substring(0, 2));
			min  = Integer.parseInt(timeStr[1].substring(2, 4));
			sec  = Integer.parseInt(timeStr[1].substring(4, 6));
		} else if (shiftTime.contains(VERTICAL_SIGN)) {
			String[] timeStr = shiftTime.split("\\|");
			
			if (timeIn.get(Calendar.HOUR_OF_DAY) < (Integer.parseInt(timeStr[0].substring(0,2)) + 4)) {
				hour = Integer.parseInt(timeStr[0].substring(0,2));
				min  = Integer.parseInt(timeStr[0].substring(2,4));
				sec  = Integer.parseInt(timeStr[0].substring(4,6));
			} else {
				hour = Integer.parseInt(timeStr[1].substring(0,2));
				min  = Integer.parseInt(timeStr[1].substring(2,4));
				sec  = Integer.parseInt(timeStr[1].substring(4,6));
			}
		} else {
			hour = Integer.parseInt(shiftTime.substring(0,2));
			min  = Integer.parseInt(shiftTime.substring(2,4));
			sec  = Integer.parseInt(shiftTime.substring(4,6));
		}
	
		ruleTimeIn.setTime(new Date(timeRecord.getTimeIn().getTime()));
		ruleTimeIn.set(Calendar.HOUR_OF_DAY, hour);
		ruleTimeIn.set(Calendar.MINUTE, min);
		ruleTimeIn.set(Calendar.SECOND, sec);
		
		lateTotal = TimeUnit.MILLISECONDS.toMinutes(timeRecord.getTimeIn().getTime() - ruleTimeIn.getTime().getTime());
		
		if (lateTotal < 0) {
			return 0;
		}

		return lateTotal;
	} 
	
	public static long getUnderTime(Employee employee, TimeRecord timeRecord) {
		long underTime = 0;
		
		try {
		
			String shiftTime = employee.getEmployeeShift().getScheduleShift().getShiftRule();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			Calendar timeIn = Calendar.getInstance();
			timeIn.setTime(new Date(timeRecord.getTimeIn().getTime()));
			
			Calendar timeOut = Calendar.getInstance();
			timeOut.setTime(new Date(timeRecord.getTimeOut().getTime()));
			
			Calendar ruledTimeOut = Calendar.getInstance();
			ruledTimeOut.setTime(formatter.parse(formatter.format(new Date(timeRecord.getTimeIn().getTime()))));
			
			if (shiftTime.contains(HYPEN)) {
				String[] timeStr = shiftTime.split("-");
				
				ruledTimeOut.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr[1].substring(0, 2)));
				ruledTimeOut.set(Calendar.MINUTE, Integer.parseInt(timeStr[1].substring(2, 4)));
				ruledTimeOut.set(Calendar.SECOND, Integer.parseInt(timeStr[1].substring(4, 6)));
				
				ruledTimeOut.add(Calendar.HOUR_OF_DAY, 9);
			} else if (shiftTime.contains(VERTICAL_SIGN)) {
				String[] timeStr = shiftTime.split("\\|");
				
				if (timeIn.get(Calendar.HOUR_OF_DAY) < (Integer.parseInt(timeStr[0].substring(0,2)) + 4)) {
					ruledTimeOut.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr[0].substring(0, 2)));
					ruledTimeOut.set(Calendar.MINUTE, Integer.parseInt(timeStr[0].substring(2,4)));
					ruledTimeOut.set(Calendar.SECOND, Integer.parseInt(timeStr[0].substring(4,6)));
					
					ruledTimeOut.add(Calendar.HOUR_OF_DAY, 4);
				} else {
					ruledTimeOut.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr[1].substring(0, 2)));
					ruledTimeOut.set(Calendar.MINUTE, Integer.parseInt(timeStr[1].substring(2,4)));
					ruledTimeOut.set(Calendar.SECOND, Integer.parseInt(timeStr[1].substring(4,6)));
					
					ruledTimeOut.add(Calendar.HOUR_OF_DAY, 4);
				}
			} else {
				ruledTimeOut.set(Calendar.HOUR_OF_DAY,  Integer.parseInt(shiftTime.substring(0,2)));
				ruledTimeOut.set(Calendar.MINUTE, Integer.parseInt(shiftTime.substring(2,4)));
				ruledTimeOut.set(Calendar.SECOND, Integer.parseInt(shiftTime.substring(4,6)));
				
				ruledTimeOut.add(Calendar.HOUR_OF_DAY, 9);
			}
			
			underTime = TimeUnit.MILLISECONDS.toMinutes(ruledTimeOut.getTime().getTime() - timeOut.getTime().getTime());
			
			if (underTime < 0) {
				return 0;
			}
			
			return underTime;
		} catch (ParseException e) {
			e.printStackTrace();
			
			return 0;
		}
	}
	
	public static long getNightShift(Employee employee, TimeRecord timeRecord) {
		long nightShiftMin = 0;
		
		if (!employee.getEmployeeShift().getScheduleShift().getShiftName().equals("NightShift")) {
			return nightShiftMin;
		}
		
		try {
			String shiftTime = employee.getEmployeeShift().getScheduleShift().getShiftRule();
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			
			Calendar timeIn = Calendar.getInstance();
			timeIn.setTime(new Date(timeRecord.getTimeIn().getTime()));
			
			Calendar timeOut = Calendar.getInstance();
			timeOut.setTime(new Date(timeRecord.getTimeOut().getTime()));
			
			Calendar ruledTimeIn = Calendar.getInstance();
			ruledTimeIn.setTime(formatter.parse(formatter.format(new Date(timeRecord.getTimeIn().getTime()))));
			
			Calendar ruledTimeOut = Calendar.getInstance();
			ruledTimeOut.setTime(formatter.parse(formatter.format(new Date(timeRecord.getTimeIn().getTime()))));
			
			nightShiftMin = TimeUnit.MILLISECONDS.toMinutes(Math.abs(timeOut.getTimeInMillis() - timeIn.getTimeInMillis()));
			
			if (shiftTime.contains(HYPEN)) {
				String[] timeStr = shiftTime.split("-");
				
				Calendar ruledTimeInStart = Calendar.getInstance();
				ruledTimeInStart.setTime(formatter.parse(formatter.format(new Date(timeRecord.getTimeIn().getTime()))));
				ruledTimeInStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr[0].substring(0, 2)));
				ruledTimeInStart.set(Calendar.MINUTE, Integer.parseInt(timeStr[0].substring(2, 4)));
				ruledTimeInStart.set(Calendar.SECOND, Integer.parseInt(timeStr[0].substring(4, 6)));
		
				if (timeIn.before(ruledTimeInStart)) {
					nightShiftMin -= TimeUnit.MILLISECONDS.toMinutes((Math.abs(ruledTimeInStart.getTimeInMillis() - timeIn.getTimeInMillis())));
				}
			} else if (shiftTime.contains(VERTICAL_SIGN)) {
				String[] timeStr = shiftTime.split("\\|");
				Calendar ruledTimeInStart = Calendar.getInstance();
				
				if (timeIn.get(Calendar.HOUR_OF_DAY) < (Integer.parseInt(timeStr[0].substring(0,2)) + 4)) {
					ruledTimeInStart.setTime(formatter.parse(formatter.format(new Date(timeRecord.getTimeIn().getTime()))));
					ruledTimeInStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr[0].substring(0, 2)));
					ruledTimeInStart.set(Calendar.MINUTE, Integer.parseInt(timeStr[0].substring(2, 4)));
					ruledTimeInStart.set(Calendar.SECOND, Integer.parseInt(timeStr[0].substring(4, 6)));
						
					if (timeIn.before(ruledTimeInStart)) {
						nightShiftMin -= TimeUnit.MILLISECONDS.toMinutes((Math.abs(ruledTimeInStart.getTimeInMillis() - timeIn.getTimeInMillis())));
					}
				} else {
					ruledTimeInStart.setTime(formatter.parse(formatter.format(new Date(timeRecord.getTimeIn().getTime()))));
					ruledTimeInStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeStr[1].substring(0, 2)));
					ruledTimeInStart.set(Calendar.MINUTE, Integer.parseInt(timeStr[1].substring(2, 4)));
					ruledTimeInStart.set(Calendar.SECOND, Integer.parseInt(timeStr[1].substring(4, 6)));
						
					if (timeIn.before(ruledTimeInStart)) {
						nightShiftMin -= TimeUnit.MILLISECONDS.toMinutes((Math.abs(ruledTimeInStart.getTimeInMillis() - timeIn.getTimeInMillis())));
					}
				}
			} else {
				
				Calendar ruledTimeInStart = Calendar.getInstance();
				ruledTimeInStart.setTime(formatter.parse(formatter.format(new Date(timeRecord.getTimeIn().getTime()))));
				ruledTimeInStart.set(Calendar.HOUR_OF_DAY, Integer.parseInt(shiftTime.substring(0, 2)));
				ruledTimeInStart.set(Calendar.MINUTE, Integer.parseInt(shiftTime.substring(2, 4)));
				ruledTimeInStart.set(Calendar.SECOND, Integer.parseInt(shiftTime.substring(4, 6)));
		
				if (timeIn.before(ruledTimeInStart)) {
					nightShiftMin -= TimeUnit.MILLISECONDS.toMinutes((Math.abs(ruledTimeInStart.getTimeInMillis() - timeIn.getTimeInMillis())));
				}
			}
			
			return nightShiftMin;
		
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public static long getUnderTime(Employee employee, List<TimeRecord> timeRecordList) {
		long underTime = 0;
		
		for (TimeRecord timeRecord : timeRecordList) {
			underTime += TimeRecordUtilityService.getUnderTime(employee, timeRecord);	
		}
		
		return underTime;
	}

	public static long getLate(Employee employee, List<TimeRecord> timeRecordList) {
		long lateTotal = 0;
		
		for (TimeRecord timeRecord : timeRecordList) {
			lateTotal += TimeRecordUtilityService.getLate(employee, timeRecord);
		}
		
		return lateTotal;
	}
	
	public static long getNightShift(Employee employee, List<TimeRecord> timeRecordList) {
		long nightShift = 0;
		
		if (employee.getEmployeeShift().getScheduleShift().getShiftName().equals("NightShift")) {
			for (TimeRecord timeRecord : timeRecordList) {
				nightShift += TimeRecordUtilityService.getNightShift(employee, timeRecord);
			}
		}
		
		return nightShift;
	}

	public static int getAbsences(Employee employee, List<TimeRecord> timeRecords) {
		EmployeeShift shift = employee.getEmployeeShift();
		WorkdayShift workDayShift = shift.getWorkdayShiftBean();
		ScheduleShift scheduleShift = shift.getScheduleShift();
		Client client = employee.getClient();
		List<String> workDays = Arrays.asList(workDayShift.getDailyShiftSched().split("-"));
		int requiredTimeInNumberOfLogin = 0;
		
		if ("weekly".equals(client.getPayrollOccurence())) {
			requiredTimeInNumberOfLogin = workDays.size();
		} else if ("semimonthly".equals(client.getPayrollOccurence())) {
			requiredTimeInNumberOfLogin = 2*workDays.size();
		} else if ("monthly".equals(client.getPayrollOccurence())) {
			requiredTimeInNumberOfLogin = 4*workDays.size();	
		}
		
		if (scheduleShift.getShiftRule().contains(VERTICAL_SIGN)) {
			requiredTimeInNumberOfLogin = 2*requiredTimeInNumberOfLogin;
		}
		
		int missedTimeIn = requiredTimeInNumberOfLogin - timeRecords.size();
		
		if (scheduleShift.getShiftRule().contains(VERTICAL_SIGN)) {
			missedTimeIn /= 2;
		}
		
		return missedTimeIn;
	} 
}
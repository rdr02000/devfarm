package com.juve.payroll.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juve.payroll.data.dao.IPayrollGenericDAO;
import com.juve.payroll.data.dao.ITimeRecordDAO;
import com.juve.payroll.model.TimeRecord;
import com.juve.payroll.service.IEmployeeTimeRecordService;
import com.juve.payroll.service.model.ExcelTimeRecord;

@Service
public class EmployeeTimeRecordService extends AbstractPayrollGenericService<TimeRecord> 
		implements IEmployeeTimeRecordService {
	
	@Autowired
	public void setDAO(IPayrollGenericDAO<TimeRecord> genericPayrollDAO) {
		this.genericPayrollDAO = genericPayrollDAO;
		this.genericPayrollDAO.setClazz(TimeRecord.class);
	}
	
	public List<TimeRecord> getEmployeeTimeRecord(Long employeeId, Date from,
			Date to) {
		return ((ITimeRecordDAO)genericPayrollDAO).getEmployeeTimeRecord(employeeId, from, to);
	}

	public List<TimeRecord> getEmployeeTimeRecord(Long employeeId, Date date) {
		return ((ITimeRecordDAO)genericPayrollDAO).getEmployeeTimeRecord(employeeId, date, date);
	}

	public List<ExcelTimeRecord> readExcelRecord(Workbook workbook) {
		Sheet dataTypeSheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = dataTypeSheet.iterator();
		List<ExcelTimeRecord> timeRecords = new ArrayList<ExcelTimeRecord>();
		
		while(iterator.hasNext()) {
			Row currentRow = iterator.next();
			
			Iterator<Cell> cellIterator = currentRow.iterator();
			ExcelTimeRecord timeRecord = new ExcelTimeRecord();
			
			while(cellIterator.hasNext()) {
				Cell cell = cellIterator.next();
				if (cell.getRowIndex() > 0) {
					if (cell.getColumnIndex() == 0) {
						timeRecord.setEmployeeId(Long.valueOf(cell.getStringCellValue()));
					} else if (cell.getColumnIndex() == 1) {
						timeRecord.setFrom(cell.getDateCellValue());
					} else if (cell.getColumnIndex() == 2) {
						timeRecord.setTo(cell.getDateCellValue());
					}
				}
			}
			
			if (currentRow.getRowNum() > 0) {
				timeRecords.add(timeRecord);
			}
		}
	
		return timeRecords;
	}
}

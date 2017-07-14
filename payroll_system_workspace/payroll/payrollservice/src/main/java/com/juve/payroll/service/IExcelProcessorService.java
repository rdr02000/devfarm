package com.juve.payroll.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;

public interface IExcelProcessorService<E> {
	public List<E> readExcelRecord(Workbook workbook);
}

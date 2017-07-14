package com.juve.payroll.tax.configuration;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoadTaxProperties<T> {
	private Class<T> type;
	private T t;
	
	public LoadTaxProperties(Class<T> type) {
		this.type = type;
	} 
	
	public T loadTaxProperties(ObjectMapper mapper, File file) {
		try {
			t = (T) mapper.readValue(file,  type);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return (T) t;
	}
}

package com.juve.payroll.employeews.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.juve.payroll.employeews.form.FileInfo;

@RestController
public class FileUploadController {
	@Autowired
	private ServletContext servletContext;
	
	@RequestMapping(value = "/fileupload", headers=("content-type=multipart/form-data"), method = RequestMethod.POST,
			produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<FileInfo> fileUpload(@RequestParam("file")MultipartFile inputFile) {
		try {
			if (!inputFile.isEmpty()) {
				String origFileName = inputFile.getOriginalFilename();
				File destFileName = new File(servletContext.getRealPath("\\WEB-INF\\uploadedFile") + "\\" + origFileName);
				inputFile.transferTo(destFileName);
				
				FileInfo fileInfo = new FileInfo();
				fileInfo.setFileName(destFileName.getPath());
				fileInfo.setFileSize(inputFile.getSize());
				fileInfo.setUploadStatus("Upload successful");
				
				return new ResponseEntity<FileInfo>(fileInfo, HttpStatus.OK);
			}
		} catch(IOException ioException) {
			return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<FileInfo>(HttpStatus.BAD_REQUEST);
	}
}
package com.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.employee.management.dto.ResponseDto;

import com.employee.management.service.FileStroageServive;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

@RestController
public class FileControlller {

    @Autowired
     FileStroageServive fileStroageServive;
    
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/upload")
    public ResponseDto uploadFile(@RequestParam("file") MultipartFile file,String empId) {
    	ResponseDto response = new ResponseDto();
    	response.setStatus("success");
    	response.setMessage("Upload Successful");
        String fileName = fileStroageServive.storeFile(file,Long.parseLong(empId));
        response.setData(fileName);
        return response;
    }
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/download/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) {
        try {
            File file = fileStroageServive.getFile(fileName);
            Resource resource = new UrlResource(file.toURI());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (MalformedURLException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            
            
        }
    }
	@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("getAllFiles")
    public ResponseDto  getAllFiles() {
    	ResponseDto response = new ResponseDto();
    	response.setStatus("success");
    	response.setMessage("Upload Successful");
    	response.setData(fileStroageServive.getAllFiles());
    	return response;
    }
}

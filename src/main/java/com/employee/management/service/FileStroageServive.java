package com.employee.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.employee.management.model.FileMetData;
import com.employee.management.repository.FileMetDataRepository;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class FileStroageServive {

    private final Path fileStorageLocation;

    @Autowired
    FileMetDataRepository fileMetdataRepository;

    public FileStroageServive() {
        this.fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public String storeFile(MultipartFile file,long empId ) {
        String fileName = file.getOriginalFilename();
        try {
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation);
            FileMetData fileMetdata = new FileMetData();
            fileMetdata.setFileName(fileName);
            fileMetdata.setFileType(file.getContentType());
            fileMetdata.setFileSize(file.getSize());
            fileMetdata.setEmployeeId(empId);
            fileMetdataRepository.save(fileMetdata);
            return fileName;
        } catch (IOException ex) {
            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public File getFile(String fileName) {
        Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
        return filePath.toFile();
    }
    
    public List<FileMetData> getAllFiles() {
        return fileMetdataRepository.findAll();
    }
}


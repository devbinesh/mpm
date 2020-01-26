package com.mypayrollmaster.service;
 
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.mypayrollmaster.exception.FileStorageException;
import com.mypayrollmaster.model.AccountUser;
import com.mypayrollmaster.utils.AuthUtils; 
@Service
public class FileUploadService {
	 
	@Value("${dir.company_logo}")
	String companyLogoDir;
	@Autowired
	UserService utils;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	public String storeCompanyLogo(MultipartFile file) {
		 
		Path fileStorageLocation = Paths.get(companyLogoDir).toAbsolutePath().normalize();
		logger.info("fuck "+companyLogoDir);
		
		try {
		    Files.createDirectories(fileStorageLocation);
		} catch (Exception ex) {
		    throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
		}
		String originalFile = StringUtils.cleanPath(file.getOriginalFilename());
		
		String filename = utils.getLoginUser().getAccount()+"_"+System.currentTimeMillis()+"."+StringUtils.getFilenameExtension(originalFile);
		storeFile(file,fileStorageLocation,filename);
		logger.info("fuck filename "+filename);
		
		return filename;
	}
	 public String storeFile(MultipartFile file,Path fileStorageLocation,String fileName) {
		 fileName = StringUtils.hasLength(fileName)?fileName: StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	            // Copy file to the target location (Replacing existing file with the same name)
	            Path targetLocation = fileStorageLocation.resolve(fileName);
	            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

	            return fileName;
	        } catch (IOException ex) {
	            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
	        }
	 }
}

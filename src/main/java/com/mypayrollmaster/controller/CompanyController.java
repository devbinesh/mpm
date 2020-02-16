package com.mypayrollmaster.controller;

import java.security.Principal;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mypayrollmaster.dto.CompanyInfo;
import com.mypayrollmaster.dto.FormData;
import com.mypayrollmaster.dto.SubmitResponse;
import com.mypayrollmaster.model.CompanyContactInfo;
import com.mypayrollmaster.model.ComplianceInfo;
import com.mypayrollmaster.repository.CompanyComplianceInfoRepository;
import com.mypayrollmaster.repository.CompanyInfoRepository;
import com.mypayrollmaster.service.FileUploadService; 

@RestController
@RequestMapping("/api/company")
public class CompanyController {

	 
	@Value("${image-server}")
	String imageServer;
	
	@Autowired
	CompanyInfoRepository companyInfoRepo;
	@Autowired
	CompanyComplianceInfoRepository companyCompliInfoRepo;
	@Autowired
	FileUploadService fileUploadService;
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@GetMapping(value = "/load")
	public FormData load(Principal principal) {
		logger.info("dddddd "+principal.getName());
		 CompanyContactInfo ccIinfo = companyInfoRepo.findAll().iterator().next();
		 ComplianceInfo cInfo =  companyCompliInfoRepo.findAll().iterator().next();
		 CompanyInfo companyInfo = new CompanyInfo();
		 BeanUtils.copyProperties(ccIinfo, companyInfo);
		 BeanUtils.copyProperties(cInfo, companyInfo);
		 
		  companyInfo.setLogo(imageServer+companyInfo.getLogo());
		return	new FormData(true,companyInfo);
	}
	@PostMapping(value = "/save")
	public SubmitResponse save( CompanyInfo companyInfo) {
		if(companyInfo.getLogoFile() != null) {
			String logFileName = fileUploadService.storeCompanyLogo(companyInfo.getLogoFile());
			companyInfo.setLogo(logFileName);
		}
		logger.info(companyInfo.toString());
		 CompanyContactInfo ccIinfo = companyInfoRepo.findAll().iterator().next();
		 ComplianceInfo cInfo =  companyCompliInfoRepo.findAll().iterator().next();
		 
		 BeanUtils.copyProperties(companyInfo,cInfo);
		
		 companyCompliInfoRepo.save(cInfo);
		 BeanUtils.copyProperties(companyInfo,ccIinfo,new String[] {"logo"});
		 if(companyInfo.getLogo() != null) {
			 ccIinfo.setLogo(companyInfo.getLogo());
		 }
		 companyInfoRepo.save(ccIinfo);
		return	new SubmitResponse(true,"success save");
	}
	
	@PostMapping(value = "/uploadlogo")
	public SubmitResponse<String> uploadlogo( MultipartFile logo) {
		 
		String logFileName = fileUploadService.storeCompanyLogo(logo);
		CompanyContactInfo ccIinfo = companyInfoRepo.findAll().iterator().next();
		ccIinfo.setLogo( logFileName);
		companyInfoRepo.save(ccIinfo);
		return	new SubmitResponse<>(true,"success save",imageServer+logFileName);
	}
}

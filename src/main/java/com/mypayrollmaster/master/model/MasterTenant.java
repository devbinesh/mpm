package com.mypayrollmaster.master.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "central_control")
public class MasterTenant {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "control_pkey")
	    private Long control_pkey;
	 	
	    @Column(name = "company_code")
	 	private String companyCode;
	    
	    @Column(name = "company_name")
	 	private String companyName;
	    
	    @Column(name = "Admin_name")	
	 	private String adminName;
	    
	    @Column(name = "user_pwd")
	 	private String userPwd;
	    
	    @Column(name = "user_db")
	 	private String userDb;
	    
		public Long getContolPkey() {
			return control_pkey;
		}
		public void setControlPkey(Long id) {
			this.control_pkey = id;
		}
		public String getCompanyCode() {
			return companyCode;
		}
		public void setCompanyCode(String companyCode) {
			this.companyCode = companyCode;
		}
		public String getCompanyName() {
			return companyName;
		}
		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}
		public String getUsername() {
			return adminName;
		}
		public void setUsername(String username) {
			this.adminName = username;
		}
		public String getUserPwd() {
			return userPwd;
		}
		public void setUserPwd(String password) {
			this.userPwd = password;
		}
		public String getUserDb() {
			return userDb;
		}
		public void setUserDb(String database) {
			this.userDb = database;
		}
	 	
		public String getUrl() {
			return "jdbc:mysql://localhost:3306/";
		}
		@Override
		public String toString() {
			return "MasterTenant [control_pkey=" + control_pkey + ", companyCode=" + companyCode + ", companyName="
					+ companyName + ", adminName=" + adminName + ", userPwd=" + userPwd + ", userDb=" + userDb + "]";
		}
	 
}

package com.mypayrollmaster.datasource;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.datasource.lookup.DataSourceLookup;
import org.springframework.jdbc.datasource.lookup.DataSourceLookupFailureException;
import org.springframework.stereotype.Component;
 
import com.mypayrollmaster.master.model.MasterTenant;
import com.mypayrollmaster.master.repository.MasterTenantRepository; 
import com.zaxxer.hikari.HikariDataSource;

@Component
public class AccountDataSourceLookUp implements DataSourceLookup {
	private static final Logger LOG = LoggerFactory
            .getLogger(AccountDataSourceLookUp.class);
	   @Autowired
	    private MasterTenantRepository masterTenantRepo;
	@Override
	public DataSource getDataSource(String dataSourceName) throws DataSourceLookupFailureException {
		// TODO Auto-generated method stub
			MasterTenant masterTenant = masterTenantRepo.findByTenantId(dataSourceName);
		    if(masterTenant != null) {
		    	 LOG.info(masterTenant.toString());
		    	 HikariDataSource ds = DataSourceBuilder.create().driverClassName("com.mysql.jdbc.Driver")
		    	.password(masterTenant.getUserPwd())
		    	.username(masterTenant.getUsername())
		    	.url(masterTenant.getUrl()+masterTenant.getUserDb()+"?zeroDateTimeBehavior=convertToNull").type(HikariDataSource.class).build();
		    	
		    	
		        ds.setConnectionTimeout(20000);

		        // Minimum number of idle connections in the pool
		        ds.setMinimumIdle(10);

		        // Maximum number of actual connection in the pool
		        ds.setMaximumPoolSize(20);

		        // Maximum time that a connection is allowed to sit idle in the pool
		        ds.setIdleTimeout(300000);
		        ds.setConnectionTimeout(20000);

		        // Setting up a pool name for each tenant datasource
		        String tenantId = masterTenant.getCompanyCode();
		        String tenantConnectionPoolName = tenantId + "-connection-pool";
		        ds.setPoolName(tenantConnectionPoolName);
		        LOG.info("Configured datasource:" + masterTenant.getCompanyCode()
		                + ". Connection poolname:" + tenantConnectionPoolName);
		        return ds;
		    }else {
		    	throw new DataSourceLookupFailureException("No Account ");
		    }
	}

}

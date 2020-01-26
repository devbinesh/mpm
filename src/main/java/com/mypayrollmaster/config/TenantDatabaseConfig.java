/*
 * Copyright 2018 onwards - Sunit Katkar (sunitkatkar@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.mypayrollmaster.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mypayrollmaster.datasource.AccountAwareDataSource;
import com.mypayrollmaster.datasource.AccountDataSourceLookUp;
import com.zaxxer.hikari.HikariDataSource;


/**
 * This is the tenant data sources configuration which sets up the multitenancy.
 * 
 * @author Sunit Katkar, sunitkatkar@gmail.com
 *         (https://sunitkatkar.blogspot.com/)
 * @since ver 1.0 (May 2018)
 * @version 1.0
 */
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = { "com.mypayrollmaster.repository","com.mypayrollmaster.model" })
@EnableJpaRepositories(basePackages = { "com.mypayrollmaster.model",
        "com.mypayrollmaster.repository","com.mypayrollmaster.service" }, 
        entityManagerFactoryRef = "tenantEntityManagerFactory", 
        transactionManagerRef = "tenantTransactionManager")
public class TenantDatabaseConfig {

    private static final Logger LOG = LoggerFactory
            .getLogger(TenantDatabaseConfig.class);


    @Bean(name = "tenantJpaVendorAdapter")
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

  
    @Bean(name = "tenantTransactionManager")
    public JpaTransactionManager transactionManager(
    		@Qualifier("tenantEntityManagerFactory")    EntityManagerFactory tenantEntityManager) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(tenantEntityManager);
        return transactionManager;
    }
    @Bean(name="accountDatasource")
	public DataSource accountDatasource(AccountDataSourceLookUp adLookUp ,@Qualifier("rootDatasource") HikariDataSource rootDatasource) throws ClassNotFoundException {
		 
	//	Class.forName("oracle.jdbc.driver.OracleDriver");
		AccountAwareDataSource acSource = new AccountAwareDataSource();
		acSource.setDataSourceLookup(adLookUp);
		acSource.setDefaultTargetDataSource(rootDatasource);
		return acSource;
	}

   
    /**
     * Creates the entity manager factory bean which is required to access the
     * JPA functionalities provided by the JPA persistence provider, i.e.
     * Hibernate in this case.
     * 
     * @param connectionProvider
     * @param tenantResolver
     * @return
     */
    
    @Bean(name = "tenantEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("accountDatasource") DataSource  accountDatasource) {

        LocalContainerEntityManagerFactoryBean emfBean = new LocalContainerEntityManagerFactoryBean();
        emfBean.setDataSource(accountDatasource);
        //All tenant related entities, repositories and service classes must be scanned
        emfBean.setPackagesToScan(
              new String[] { "com.mypayrollmaster.model", "com.mypayrollmaster.repository" , "com.mypayrollmaster.service" });
        emfBean.setJpaVendorAdapter(jpaVendorAdapter());
        emfBean.setPersistenceUnitName("tenantdb-persistence-unit");
        Map<String, Object> properties = new HashMap<>();
       
        // ImprovedNamingStrategy is deprecated and unsupported in Hibernate 5
        // properties.put("hibernate.ejb.naming_strategy",
        // "org.hibernate.cfg.ImprovedNamingStrategy");
        properties.put(org.hibernate.cfg.Environment.DIALECT,
                "org.hibernate.dialect.MySQL5Dialect");
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
        properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, true);
       // properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");

        emfBean.setJpaPropertyMap(properties);
        LOG.info("tenantEntityManagerFactory set up successfully!");
        return emfBean;
    }
}
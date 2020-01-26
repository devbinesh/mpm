package com.mypayrollmaster.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
 
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.mypayrollmaster.master.model.MasterTenant;
import com.mypayrollmaster.master.repository.MasterTenantRepository;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = { "com.mypayrollmaster.master.model","com.mypayrollmaster.master.repository"  }, entityManagerFactoryRef = "masterEntityManagerFactory", transactionManagerRef = "masterTransactionManager")

public class MasterDataSourceConfig {

	@Bean(name="rootDatasource")
	 
	@ConfigurationProperties("spring.datasource")
	public HikariDataSource datasource() throws ClassNotFoundException {
		 
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		return DataSourceBuilder.create().type(HikariDataSource.class).build();
	}
	
	@Bean(name="rootJDBCTemplate")  
	public JdbcTemplate jdbcTemplate(@Qualifier("rootDatasource")  DataSource datasource) {
		
		return new JdbcTemplate(datasource);
	}
	/**
     * Creates the entity manager factory bean which is required to access the
     * JPA functionalities provided by the JPA persistence provider, i.e.
     * Hibernate in this case. <br/>
     * <br/>
     * Note the <b>{@literal @}Primary</b> annotation which tells Spring boot to
     * create this entity manager as the first thing when starting the
     * application.
     * 
     * @return
     */
  
    @Bean(name = "masterEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean masterEntityManagerFactory(@Qualifier("rootDatasource") DataSource  rootDatasource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();

        // Set the master data source
        em.setDataSource(rootDatasource);

        // The master tenant entity and repository need to be scanned
        em.setPackagesToScan(
                new String[] { MasterTenant.class.getPackage().getName(),
                        MasterTenantRepository.class.getPackage().getName() });
        // Setting a name for the persistence unit as Spring sets it as
        // 'default' if not defined
        em.setPersistenceUnitName("masterdb-persistence-unit");

        // Setting Hibernate as the JPA provider
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);

        // Set the hibernate properties
        em.setJpaProperties(hibernateProperties());
       // Logger.info("Setup of masterEntityManagerFactory succeeded.");
        return em;
    }

    /**
     * This transaction manager is appropriate for applications that use a
     * single JPA EntityManagerFactory for transactional data access. <br/>
     * <br/>
     * Note the <b>{@literal @}Qualifier</b> annotation to ensure that the
     * <tt>masterEntityManagerFactory</tt> is used for setting up the
     * transaction manager.
     * 
     * @param emf
     * @return
     */
    @Bean(name = "masterTransactionManager")
    public JpaTransactionManager masterTransactionManager(
            @Qualifier("masterEntityManagerFactory") EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    /**
     * Bean post-processor that automatically applies persistence exception
     * translation to any bean marked with Spring's @Repository annotation,
     * adding a corresponding PersistenceExceptionTranslationAdvisor to the
     * exposed proxy (either an existing AOP proxy or a newly generated proxy
     * that implements all of the target's interfaces).
     * 
     * @return
     */
    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    /**
     * The properties for configuring the JPA provider Hibernate.
     * 
     * @return
     */
    private Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.put(org.hibernate.cfg.Environment.DIALECT,
                "org.hibernate.dialect.MySQL5Dialect");
        properties.put(org.hibernate.cfg.Environment.SHOW_SQL, true);
        properties.put(org.hibernate.cfg.Environment.FORMAT_SQL, true);
        properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, "update");
        return properties;
    }
}

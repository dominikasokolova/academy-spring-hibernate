package sk.ness.academy.springdata.config;

import org.hibernate.cfg.Environment;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

  @Bean
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(final DataSource dataSource) {
    final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPackagesToScan(new String[] { "sk.ness.academy.springdata.model" });
    em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
    em.setJpaProperties(additionalProperties());

    return em;
  }

  final Properties additionalProperties() {
    final Properties properties = new Properties();
    properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");
    properties.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
    properties.setProperty(Environment.POOL_SIZE, "1");
    properties.setProperty(Environment.HBM2DDL_AUTO, "update");
    properties.setProperty(Environment.SHOW_SQL, Boolean.TRUE.toString());
    properties.setProperty(Environment.FORMAT_SQL, Boolean.TRUE.toString());

    return properties;
  }

  @Bean(name = "dataSource")
  public DataSource getDataSource() {
    final DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.hsqldb.jdbcDriver");
    dataSourceBuilder.url("jdbc:hsqldb:file:mydb;shutdown=true");
    dataSourceBuilder.username("sa");
    dataSourceBuilder.password("");
    return dataSourceBuilder.build();
  }

}

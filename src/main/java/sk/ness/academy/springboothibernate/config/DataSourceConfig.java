package sk.ness.academy.springboothibernate.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class DataSourceConfig {

  @Bean(name = "sessionFactory")
  public LocalSessionFactoryBean sessionFactory(final DataSource dataSource) {
    final Properties properties = new Properties();
    properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.HSQLDialect");
    properties.setProperty(Environment.DRIVER, "org.hsqldb.jdbcDriver");
    properties.setProperty(Environment.POOL_SIZE, "1");
    properties.setProperty(Environment.HBM2DDL_AUTO, "update");
    properties.setProperty(Environment.SHOW_SQL, Boolean.TRUE.toString());
    properties.setProperty(Environment.FORMAT_SQL, Boolean.TRUE.toString());

    final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource);
    sessionFactory.setPackagesToScan(new String[] { "sk.ness.academy.springboothibernate.model" });
    sessionFactory.setHibernateProperties(properties);

    return sessionFactory;
  }

  @Bean(name = "dataSource")
  public DataSource getDataSource() {
    final DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.hsqldb.jdbcDriver");
    dataSourceBuilder.url("jdbc:hsqldb:file:mydb;shutdown=true");
    dataSourceBuilder.username("sa");
    dataSourceBuilder.password("");
    return dataSourceBuilder.build();
//    return new SimpleDriverDataSource(new JDBCDriver(), "jdbc:hsqldb:file:mydb;shutdown=true", "sa", "");
  }

  @Bean(name = "transactionManager")
  public PlatformTransactionManager transactionManager(final SessionFactory sessionFactory) {
    return new HibernateTransactionManager(sessionFactory);
  }

}

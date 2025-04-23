@Configuration 
@EnableTransactionManagement 
public class AppConfig { 
@Bean 
public DataSource dataSource() { 
DriverManagerDataSource ds = new DriverManagerDataSource(); 
ds.setDriverClassName("com.mysql.cj.jdbc.Driver"); 
ds.setUrl("jdbc:mysql://localhost:3306/testdb"); 
ds.setUsername("root"); 
ds.setPassword("password"); 
return ds; 
} 
@Bean 
public LocalSessionFactoryBean sessionFactory() { 
LocalSessionFactoryBean lsf = new LocalSessionFactoryBean(); 
lsf.setDataSource(dataSource()); 
lsf.setPackagesToScan("your.package"); 
Properties props = new Properties(); 
props.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"); 
props.put("hibernate.hbm2ddl.auto", "update"); 
lsf.setHibernateProperties(props); 
return lsf; 
} 
@Bean 
public HibernateTransactionManager transactionManager(SessionFactory sf) { 
return new HibernateTransactionManager(sf); 
} 
@Bean 
public BankService bankService(SessionFactory sf) { 
return new BankService(sf); 
} 
}

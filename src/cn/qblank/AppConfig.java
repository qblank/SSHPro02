package cn.qblank;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("cn.qblank")
@PropertySource("classpath:jdbc.properties") //引入外部属性文件到Enviroment
@EnableTransactionManagement
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{
	/**
	 * 负责将控制器方法返回的字符串映射到某个JSP
	 */
	@Bean
	public ViewResolver viewResolver(){
		//创建对象
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// 支持jsp及标准taglib
		viewResolver.setViewClass(JstlView.class);
		//设置前后缀
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/**
	 * 扫描实体类
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		//加载数据源
		factoryBean.setDataSource(dataSource);
		//自动扫描实体类
		factoryBean.setPackagesToScan("cn.qblank.entity");
		return factoryBean;
	}
	/**
	 * 配置数据源
	 * 依赖Environment
	 */
	@Bean
	public DataSource dataSource(Environment env){
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("jdbc.driverClass"));
		ds.setUrl(env.getProperty("jdbc.jdbcUrl"));
		ds.setUsername(env.getProperty("jdbc.user"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}
	
	/**
	 * 创建事务类
	 * @param sessionFactory
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
	/**
	 * bootstrap映射路径
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/public/");
	}
}

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
@PropertySource("classpath:jdbc.properties") //�����ⲿ�����ļ���Enviroment
@EnableTransactionManagement
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{
	/**
	 * ���𽫿������������ص��ַ���ӳ�䵽ĳ��JSP
	 */
	@Bean
	public ViewResolver viewResolver(){
		//��������
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		// ֧��jsp����׼taglib
		viewResolver.setViewClass(JstlView.class);
		//����ǰ��׺
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	/**
	 * ɨ��ʵ����
	 */
	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource dataSource){
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		//��������Դ
		factoryBean.setDataSource(dataSource);
		//�Զ�ɨ��ʵ����
		factoryBean.setPackagesToScan("cn.qblank.entity");
		return factoryBean;
	}
	/**
	 * ��������Դ
	 * ����Environment
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
	 * ����������
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
	 * bootstrapӳ��·��
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("/public/");
	}
}

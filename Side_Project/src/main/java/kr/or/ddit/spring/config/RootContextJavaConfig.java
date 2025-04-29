package kr.or.ddit.spring.config;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.val;


@EnableAspectJAutoProxy //AOP 기능 활성화
@EnableTransactionManagement // 트랜잭션 처리 활성화
public class RootContextJavaConfig {
	
	//DB연결정보 (DBInfo.properties) 로딩 Bean정의
	@Bean
	public PropertiesFactoryBean dbInfo(
		@Value("classpath:kr/or/ddit/db/DBInfo.properties") Resource location	
			){
		PropertiesFactoryBean factory = new PropertiesFactoryBean(); //Properties읽어들이는 팩토리
		factory.setLocation(location); //파일 경로 설정
		return factory; //빈 등록
	}
	
	@Bean
	public DataSource dataSource(
		@Value("#{dbInfo.driverClassName}")String driverClassName, //DB드라이버 클래스명 주입
		@Value("#{dbInfo['url']}")String url, //DB URL 주입
		@Value("#{dbInfo.user}")String user,//접속ID주입
		@Value("#{dbInfo.password}")String password,
		@Value("#{dbInfo.initialSize}") int initialSize,//초기 커넥션 개수 주입
		@Value("#{dbInfo.maxWait}")long maxWait, //커넥션 최대 대기시간 주입
		@Value("#{dbInfo.maxTotal}") int maxTotal //커넥션 최대 개수 주입
			){
		BasicDataSource ds = new BasicDataSource(); // 커넥션 풀 객체 생성
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(user);
		ds.setPassword(password);
		ds.setInitialSize(initialSize);
		ds.setMaxWait(Duration.of(maxTotal/1000, ChronoUnit.SECONDS));//커넥션 최대 대기시간 설정
		ds.setMaxTotal(maxTotal);
		return ds;// DataSource로 빈 등록
	}
		//MaBatis의 sqlSessionFactory를 생성하는 Bean정의
//		@Bean
		public SqlSessionFactoryBean sqlSessionFactory(
			DataSource dataSource,
			//매퍼 스케너 객체 생성
			@Value("classpath:kr/or/ddit/mybatis/Configuration.xml")Resource configLocation,
			//매퍼 인터페이스가 있는 기본 패키지 설정
			@Value("classpath:kr/or/ddit/mybatis/mappers/**/*.xml") Resource...mapperLocations
				){
			SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
			factoryBean.setDataSource(dataSource);
			factoryBean.setConfigLocation(configLocation);//매퍼 설정파일등록
			factoryBean.setMapperLocations(mapperLocations);//매퍼 XML등록
			factoryBean.setTypeAliasesPackage("kr.or.ddit.**.vo"); //VO클래스 패키지등록
			
			return factoryBean;
			
		}
		
		//Mapper 인터페이스를 자동으로 스캔해서 등록하는 Bean정의
//		@Bean
		public MapperScannerConfigurer mapperScanner() {
			MapperScannerConfigurer configurar = new MapperScannerConfigurer();//매퍼 스캐너객체
			configurar.setBasePackage("kr.or.ddit.mybatis.mappers");
			configurar.setAnnotationClass(Mapper.class);//@Mapper 어노테이션 기준 스캔
			configurar.setSqlSessionFactoryBeanName("sqlSEssionFactory");
			return configurar;
		}

		
		//트랜잭션 처리를 위한 Bean정의
		public TransactionManager transactionManager(DataSource dataSource) {
			return new DataSourceTransactionManager(dataSource);
		}
		
		
}

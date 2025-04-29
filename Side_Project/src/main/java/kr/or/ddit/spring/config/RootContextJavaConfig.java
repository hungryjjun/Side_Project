package kr.or.ddit.spring.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAspectJAutoProxy //AOP 기능 활성화
@EnableTransactionManagement // 트랜잭션 처리 활성화
public class RootContextJavaConfig {
	
	//DB연결정보 (DBInfo.properties) 로딩 Bean정의
	@Bean
	public PropertiesFactoryBean dbInfo() {
		
		return 0;
	}
}

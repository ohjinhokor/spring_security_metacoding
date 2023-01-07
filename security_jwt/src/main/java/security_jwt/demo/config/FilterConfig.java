package security_jwt.demo.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import security_jwt.demo.filter.CustumFilter1;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<CustumFilter1> filter1() {
		FilterRegistrationBean<CustumFilter1> bean = new FilterRegistrationBean<>(new CustumFilter1());
		bean.addUrlPatterns("/*");
		bean.setOrder(0);
		return bean;
	}

//	@Bean
//	public FilterRegistrationBean<CustomFilter2> filter2() {
//		FilterRegistrationBean<CustomFilter2> bean = new FilterRegistrationBean<>(new CustomFilter2());
//		bean.addUrlPatterns("/*");
//		bean.setOrder(1);
//		return bean;
//	}
}

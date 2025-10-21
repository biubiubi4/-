package config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// create global ApplicationContext
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// create Servlet ApplicationContext
		return new Class<?>[] { SpringMVCConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		// servlet.addMapping("/")
		return new String[] { "/" }; 
	}
}

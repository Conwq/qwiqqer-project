package org.example.sergey.patseev.qwiqqer.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyQwiqqerApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	protected Class<?>[] getRootConfigClasses() {
		return new Class[0];
	}

	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{QwiqqerConfiguration.class};
	}

	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
}

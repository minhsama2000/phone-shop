package com.javadev.phoneshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class WebMVCConfiguration implements WebMvcConfigurer {
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations("classpath:/static/client/assets/css/");
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/static/client/owcarosel/assets/");
		registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/client/handleJs/");
		registry.addResourceHandler("/owcarosel/**").addResourceLocations("classpath:/static/client/owcarosel/");
		registry.addResourceHandler("/fonts/**").addResourceLocations("classpath:/static/client/assets/fonts/");
		registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/client/assets/images/");
		
		registry.addResourceHandler("/admin/css/**").addResourceLocations("classpath:/static/admin/css/");
		registry.addResourceHandler("/admin/js/**").addResourceLocations("classpath:/static/admin/js/");
		registry.addResourceHandler("/admin/fonts/**").addResourceLocations("classpath:/static/admin/fonts/");
		registry.addResourceHandler("/admin/images/**").addResourceLocations("classpath:/static/admin/images/");
		registry.addResourceHandler("/admin/media/**").addResourceLocations("classpath:/static/admin/media/");
		registry.addResourceHandler("/admin/vendor/**").addResourceLocations("classpath:/static/admin/vendor/");
		registry.addResourceHandler("/upload/**").addResourceLocations("file:upload/");
	}
	
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        registry.viewResolver(resolver);
    }
}

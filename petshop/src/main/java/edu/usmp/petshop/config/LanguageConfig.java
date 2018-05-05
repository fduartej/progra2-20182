package edu.usmp.petshop.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SuppressWarnings("deprecation")
@Configuration
public class LanguageConfig extends WebMvcConfigurerAdapter{
	
	   @Bean
	    public MessageSource messageSource() {
	        ReloadableResourceBundleMessageSource msgSrc = new ReloadableResourceBundleMessageSource();
	        msgSrc.setBasename("classpath:messages");
	        msgSrc.setDefaultEncoding("UTF-8");
	        return msgSrc;
	    }
		
		@Bean
		public LocaleResolver localeResolver() {
			 SessionLocaleResolver slr = new SessionLocaleResolver();
			 slr.setDefaultLocale(Locale.US);
			 return slr;
		}
		
		@Bean
		public LocaleChangeInterceptor localeChangeInterceptor() {
		    LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
		    lci.setParamName("lang");
		    return lci;
		}

		 @Override
		public void addInterceptors(InterceptorRegistry registry) {
		    registry.addInterceptor(localeChangeInterceptor());
		}

}

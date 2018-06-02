package edu.usmp.petshop.config;

import javax.cache.configuration.Configuration;
import javax.cache.configuration.MutableConfiguration;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@EnableCaching
@org.springframework.context.annotation.Configuration
public class CacheConfig {

	@Bean
	public JCacheManagerCustomizer cacheManagerCustomizer() {
		return cm -> {
			Configuration<Object, Object> cacheConfiguration = createCacheConfiguration();
			cm.createCache("person", cacheConfiguration);
			cm.createCache("contact", cacheConfiguration);
		};
	}

	private Configuration<Object, Object> createCacheConfiguration() {
		return new MutableConfiguration<>().setStatisticsEnabled(true);
	}
}
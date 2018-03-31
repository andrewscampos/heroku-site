package br.com.site.config;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.site.annotations.Open;

@EnableWebSecurity
public class ConfiguracaoParaUsuario {

	
	@Configuration
	public static class ConfiguracaoParaUsuarios extends WebSecurityConfigurerAdapter {
		
		 @Autowired
		 ApplicationContext applicationContext;

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			String[] forAnnotation = applicationContext.getBeanNamesForAnnotation(Controller.class);
			List<String> list = new ArrayList<>();
			for (String beanName : forAnnotation) {
				Object bean = applicationContext.getBean(beanName);
				 if(bean == null) continue;
				Class<? extends Object> clazz =bean.getClass();
				boolean isController = clazz.isAnnotationPresent(Controller.class);
				if(!isController) {
					continue;
				}
				Method[] methods = clazz.getMethods();
				for (Method method : methods) {
					boolean present = method.isAnnotationPresent(Open.class) && method.isAnnotationPresent(RequestMapping.class);
					if (present) {
						RequestMapping mapping = method.getAnnotation(RequestMapping.class); 
						String[] value = mapping.value();
						if(clazz.isAnnotationPresent(RequestMapping.class)) {
							RequestMapping annotation = clazz.getAnnotation(RequestMapping.class);
							for (String string : value) {
								String[] strings = annotation.value();
								for (String string2 : strings) {
									list.add(string2+string);
								}
							}
						}else {
							list.addAll(Arrays.asList(value));
						}
					}
				}
				
			}
			
			String[] caminhosPermitidos = new String[] {
				"/","/css/**","/img/**",
				"/webjars/**", "/static/**", "/jquery*","*.css"
			};
			list.addAll(Arrays.asList(caminhosPermitidos));
			 String[] array = list.toArray(new String[list.size()]);

			// @formatter:off
			http.authorizeRequests().antMatchers(array).permitAll()
			.anyRequest().authenticated().and()
					.formLogin().permitAll().loginPage("/").and().logout().permitAll().and().csrf().disable();
			// @formatter:on
		}
	}
}

package br.com.site.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan(basePackages = "br.com.site")
//@EnableWebSecurity
public class Application extends WebMvcConfigurerAdapter{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/static/**");
    }
	
	/*@Configuration
	public static class ConfiguracaoParaUsuario extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			/*String[] caminhosPermitidos = new String[] {
				"/", "/home", "/usuarios",
				"/webjars/**", "/static/**", "/jquery*"
			};

			// @formatter:off
			http
				.authorizeRequests()
					.antMatchers(caminhosPermitidos).permitAll()
					.anyRequest().authenticated().and()
				.formLogin()
					.permitAll()
					.loginPage("/login")
					.and()
				.logout()
					.permitAll()
					.and()
				.csrf().disable();
			// @formatter:on
		}
	}*/
	
}

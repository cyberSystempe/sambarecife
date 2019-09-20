package br.com.festacheia.sambarecife;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SambaRecifeApplication extends SpringBootServletInitializer{

	public static ServletContext context;

	public static void main(String[] args) {
		SpringApplication.run(SambaRecifeApplication.class, args);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		if (SambaRecifeApplication.context == null)
			SambaRecifeApplication.context = servletContext;
		super.onStartup(servletContext);
	}
}

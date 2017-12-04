package com.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class IndexController {

	@Value("${config.path}")
	private String configPath;
	
	@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new Browser_jsp(configPath), "/browser");
    }
    
	@RequestMapping("/")
	public void index(HttpServletResponse response) throws IOException {
		response.sendRedirect("/browser");
	}
}

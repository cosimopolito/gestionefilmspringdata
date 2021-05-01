package it.prova.raccoltafilmspringbootservletspringdata;

import it.prova.raccoltafilmspringbootservletspringdata.web.servlet.regista.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import it.prova.raccoltafilmspringbootservletspringdata.web.servlet.auth.LoginServlet;
import it.prova.raccoltafilmspringbootservletspringdata.web.servlet.film.ExecuteInsertFilmServlet;
import it.prova.raccoltafilmspringbootservletspringdata.web.servlet.film.ExecuteListFilmServlet;
import it.prova.raccoltafilmspringbootservletspringdata.web.servlet.film.ExecuteSearchFilmServlet;
import it.prova.raccoltafilmspringbootservletspringdata.web.servlet.film.PrepareInsertFilmServlet;
import it.prova.raccoltafilmspringbootservletspringdata.web.servlet.film.PrepareSearchFilmServlet;

@Configuration
public class SerlvetRegistrationConfig {
	// N.B. se le servlet usano bean al loro interno vanno affidate a spring
	// altrimenti va bene @WebServlet

	@Autowired
	private LoginServlet loginServlet;
	@Autowired
	private ExecuteSearchRegistaServlet executeSearchRegistaServlet;
	@Autowired
	private ExecuteInsertRegistaServlet executeInsertRegistaServlet;
	@Autowired
	private ExecuteListRegistaServlet executeListRegistaServlet;
	@Autowired
	private PrepareSearchFilmServlet prepareSearchFilmServlet;
	@Autowired
	private PrepareInsertFilmServlet prepareInsertFilmServlet;
	@Autowired
	private ExecuteInsertFilmServlet executeInsertFilmServlet;
	@Autowired
	private ExecuteListFilmServlet executeListFilmServlet;
	@Autowired
	private ExecuteSearchFilmServlet executeSearchFilmServlet;
	@Autowired
	private ExecuteVisualizzaRegistaServlet executeVisualizzaRegistaServlet;
	@Autowired
	private ExecuteDeleteRegistaServlet executeDeleteRegistaServlet;
	@Autowired
	private PrepareDeleteRegistaServlet prepareDeleteRegistaServlet;
	@Autowired
	private PrepareModificaRegistaServlet prepareModificaRegistaServlet;
	@Autowired
	private ExecuteModificaRegistaServlet executeModificaRegistaServlet;




	@Bean
	public ServletRegistrationBean<LoginServlet> createLoginServletBean() {
		ServletRegistrationBean<LoginServlet> bean = new ServletRegistrationBean<LoginServlet>(loginServlet,
				"/LoginServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteSearchRegistaServlet> createExecuteSearchRegistaServletBean() {
		ServletRegistrationBean<ExecuteSearchRegistaServlet> bean = new ServletRegistrationBean<ExecuteSearchRegistaServlet>(
				executeSearchRegistaServlet, "/ExecuteSearchRegistaServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteInsertRegistaServlet> createExecuteInsertRegistaServletBean() {
		ServletRegistrationBean<ExecuteInsertRegistaServlet> bean = new ServletRegistrationBean<ExecuteInsertRegistaServlet>(
				executeInsertRegistaServlet, "/ExecuteInsertRegistaServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteListRegistaServlet> createExecuteListRegistaServletBean() {
		ServletRegistrationBean<ExecuteListRegistaServlet> bean = new ServletRegistrationBean<ExecuteListRegistaServlet>(
				executeListRegistaServlet, "/ExecuteListRegistaServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareSearchFilmServlet> createPrepareSearchFilmServletBean() {
		ServletRegistrationBean<PrepareSearchFilmServlet> bean = new ServletRegistrationBean<PrepareSearchFilmServlet>(
				prepareSearchFilmServlet, "/PrepareSearchFilmServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareInsertFilmServlet> createPrepareInsertFilmServletBean() {
		ServletRegistrationBean<PrepareInsertFilmServlet> bean = new ServletRegistrationBean<PrepareInsertFilmServlet>(
				prepareInsertFilmServlet, "/PrepareInsertFilmServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteInsertFilmServlet> createExecuteInsertFilmServletBean() {
		ServletRegistrationBean<ExecuteInsertFilmServlet> bean = new ServletRegistrationBean<ExecuteInsertFilmServlet>(
				executeInsertFilmServlet, "/ExecuteInsertFilmServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteListFilmServlet> createExecuteListFilmServletBean() {
		ServletRegistrationBean<ExecuteListFilmServlet> bean = new ServletRegistrationBean<ExecuteListFilmServlet>(
				executeListFilmServlet, "/ExecuteListFilmServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteSearchFilmServlet> createExecuteSearchFilmServletBean() {
		ServletRegistrationBean<ExecuteSearchFilmServlet> bean = new ServletRegistrationBean<ExecuteSearchFilmServlet>(
				executeSearchFilmServlet, "/ExecuteSearchFilmServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteVisualizzaRegistaServlet> createExecuteVisualizzaRegistaServletBean() {
		ServletRegistrationBean<ExecuteVisualizzaRegistaServlet> bean = new ServletRegistrationBean<ExecuteVisualizzaRegistaServlet>(
				executeVisualizzaRegistaServlet, "/ExecuteVisualizzaRegistaServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteDeleteRegistaServlet> createExecuteDeleteRegistaServletBean() {
		ServletRegistrationBean<ExecuteDeleteRegistaServlet> bean = new ServletRegistrationBean<ExecuteDeleteRegistaServlet>(
				executeDeleteRegistaServlet, "/ExecuteDeleteRegistaServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareDeleteRegistaServlet> createPrepareDeleteRegistaServletBean() {
		ServletRegistrationBean<PrepareDeleteRegistaServlet> bean = new ServletRegistrationBean<PrepareDeleteRegistaServlet>(
				prepareDeleteRegistaServlet, "/PrepareDeleteRegistaServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<PrepareModificaRegistaServlet> createPrepareModificaRegistaServletBean() {
		ServletRegistrationBean<PrepareModificaRegistaServlet> bean = new ServletRegistrationBean<PrepareModificaRegistaServlet>(
				prepareModificaRegistaServlet, "/PrepareModificaRegistaServlet");
		return bean;
	}

	@Bean
	public ServletRegistrationBean<ExecuteModificaRegistaServlet> createExecuteModificaRegistaServletBean() {
		ServletRegistrationBean<ExecuteModificaRegistaServlet> bean = new ServletRegistrationBean<ExecuteModificaRegistaServlet>(
				executeModificaRegistaServlet, "/ExecuteModificaRegistaServlet");
		return bean;
	}




	
}

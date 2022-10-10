package sk.ness.academy.springdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import sk.ness.academy.springboothibernate.AcademySpringHibernateApplicationRunMe;

@SpringBootApplication
@EnableJpaRepositories
public class AcademySpringDataApplication {

	public static void main(final String[] args) {
		final ConfigurableApplicationContext context = SpringApplication.run(AcademySpringDataApplication.class, args);
		context.getBean(AcademySpringDataApplicationRunMe.class).run();
	}

}

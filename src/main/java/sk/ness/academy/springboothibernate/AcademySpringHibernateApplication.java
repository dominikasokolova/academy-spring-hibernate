package sk.ness.academy.springboothibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AcademySpringHibernateApplication {

  public static void main(final String[] args) {
    final ConfigurableApplicationContext context = SpringApplication.run(AcademySpringHibernateApplication.class, args);
    context.getBean(AcademySpringHibernateApplicationRunMe.class).run();
  }

}

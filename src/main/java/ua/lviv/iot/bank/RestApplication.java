package ua.lviv.iot.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ua.lviv.iot.bank.dataaccess",
    "ua.lviv.iot.bank.business",
    "ua.lviv.iot.bank.controller"})
@EnableJpaRepositories({"ua.lviv.iot.bank.dataaccess"})
public class RestApplication {

  public static void main(String[] args) {
    SpringApplication.run(RestApplication.class, args);
  }
}

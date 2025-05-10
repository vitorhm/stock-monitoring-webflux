package br.com.stock.monitoring.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.stock.monitoring")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

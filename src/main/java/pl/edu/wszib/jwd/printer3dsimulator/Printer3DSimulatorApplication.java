package pl.edu.wszib.jwd.printer3dsimulator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@PropertySource("classpath:db.properties")
@SpringBootApplication
@EnableScheduling
public class Printer3DSimulatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(Printer3DSimulatorApplication.class, args);
    }
}
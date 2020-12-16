package cn.bdqn.itripcontroller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.bdqn.*"})
public class ItripControllerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItripControllerApplication.class, args);
    }

}

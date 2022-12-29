package pers.yin;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
//注册中心
public class register {

    public static void main(String[] args) {
        SpringApplication.run(register.class, args);
    }
}


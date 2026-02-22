package com.codestrela;

import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@SpringBootApplication
public class ConnecthubApplication {
    @Autowired
    private Environment env;

    @RequestMapping("/")
    String home() {
        log.info("The Application is running at http://{}:{}", env.getProperty("server.address"), env.getProperty("server.port"));
        return env.getProperty("application.title") + " " + env.getProperty("application.version");
    }

    public static void main(String[] args) {
        SpringApplication.run(ConnecthubApplication.class, args);
    }
}
package me.mupu.ibikehda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jooq.JooqAutoConfiguration;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

@SpringBootApplication(exclude = JooqAutoConfiguration.class)
public class Main {
    public static void main(String[] args) {
        /**
         * DISABLE JOOQ BANNER  -Dorg.jooq.no-logo=true
         * DISABLE ILLIGAL ACCESS WARNING --illegal-access=warn
         */
        System.getProperties().setProperty("org.jooq.no-logo", "true");

        SpringApplication.run(Main.class, args);
    }

}
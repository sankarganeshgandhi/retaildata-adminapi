package com.sgglabs.retail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Sankarganesh (sgandhi@sgglabs.com)
 *
 */
@SpringBootApplication
public class UserApplication {
    private static final Logger LOG = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
